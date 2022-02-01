package com.tencent.mm.plugin.voip.model;

import android.app.ActivityManager;
import android.app.ActivityManager.RunningTaskInfo;
import android.app.KeyguardManager;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Point;
import android.os.Build.VERSION;
import android.os.Looper;
import android.widget.RemoteViews;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.app.AppForegroundDelegate;
import com.tencent.mm.g.a.jx;
import com.tencent.mm.g.a.xh;
import com.tencent.mm.g.c.av;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.aq;
import com.tencent.mm.network.n.a;
import com.tencent.mm.plugin.expt.a.b.a;
import com.tencent.mm.plugin.voip.model.a.e;
import com.tencent.mm.plugin.voip.ui.VideoActivity;
import com.tencent.mm.plugin.voip.video.i;
import com.tencent.mm.plugin.voip.widget.VoipForegroundService;
import com.tencent.mm.protocal.protobuf.boe;
import com.tencent.mm.protocal.protobuf.dfx;
import com.tencent.mm.protocal.protobuf.doo;
import com.tencent.mm.protocal.protobuf.dsb;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ai;
import com.tencent.mm.sdk.platformtools.ap;
import com.tencent.mm.sdk.platformtools.au;
import com.tencent.mm.sdk.platformtools.au.a;
import com.tencent.mm.sdk.platformtools.bs;
import com.tencent.mm.storage.bj;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;

public final class u
{
  private static final com.tencent.mm.b.f<Integer, p.a> fAs;
  public String AAf;
  public v AEF;
  public com.tencent.mm.plugin.voip.a AEG;
  public boolean AEH;
  public boolean AEI;
  public boolean AEJ;
  private long AEK;
  public Map<Integer, Long> AEL;
  public int AEM;
  public long AEN;
  public long AEO;
  public volatile u.b AEP;
  private Point AEQ;
  public boolean AER;
  boolean AES;
  boolean AET;
  public boolean AEU;
  public boolean AEV;
  private boolean AEW;
  public dsb AEX;
  public long AEY;
  public boolean AEZ;
  List<a> AFa;
  public boolean cUz;
  public String talker;
  public au uXE;
  private com.tencent.mm.network.n zVK;
  
  static
  {
    AppMethodBeat.i(115155);
    fAs = new com.tencent.mm.memory.a.c(5);
    AppMethodBeat.o(115155);
  }
  
  public u()
  {
    AppMethodBeat.i(115113);
    this.cUz = false;
    this.AEH = false;
    this.AEI = false;
    this.AEJ = false;
    this.talker = null;
    this.AEK = 0L;
    this.AEL = new HashMap();
    this.AEM = -1;
    this.AEN = 0L;
    this.AEO = 0L;
    this.AER = false;
    this.AES = false;
    this.AET = false;
    this.AEU = false;
    this.AEV = false;
    this.AEW = false;
    this.AEX = null;
    this.AEY = 0L;
    this.AAf = null;
    this.AEZ = false;
    this.zVK = new n.a()
    {
      public final void onNetworkChange(int paramAnonymousInt)
      {
        AppMethodBeat.i(115109);
        ac.d("MicroMsg.Voip.VoipService", "network status change from ".concat(String.valueOf(paramAnonymousInt)));
        l locall;
        if ((u.a(u.this)) && (paramAnonymousInt == 4))
        {
          locall = u.this.AEF.Ayh;
          if (locall.ABU == 0) {
            locall.ABU = locall.ABJ.AGe;
          }
          paramAnonymousInt = com.tencent.mm.plugin.voip.b.d.getNetType(ai.getContext());
          if (paramAnonymousInt != locall.ABU) {
            com.tencent.mm.plugin.voip.b.d.Logi("MicroMsg.Voip.VoipContext", "steve: onVoipLocalNetTypeChange: local network type change from " + locall.ABU + " to " + paramAnonymousInt);
          }
        }
        try
        {
          byte[] arrayOfByte = new byte[4];
          arrayOfByte[0] = ((byte)paramAnonymousInt);
          int i = locall.ABJ.setAppCmd(301, arrayOfByte, 4);
          if (i < 0) {
            com.tencent.mm.plugin.voip.b.d.Logi("MicroMsg.Voip.VoipContext", "steve:[ENGINE]IMVQQEngine::SetAppCmd[EMethodSetLocalNetType] update local network type" + paramAnonymousInt + "fail:" + i + ", [roomid=" + locall.ABJ.tIN + ", roomkey=" + locall.ABJ.tIG + "]");
          }
          doo localdoo = new doo();
          localdoo.FWj = 3;
          localdoo.FWk = new com.tencent.mm.bw.b(arrayOfByte, 0, 1);
          locall.ABJ.SendRUDP(localdoo.toByteArray(), localdoo.toByteArray().length);
        }
        catch (Exception localException)
        {
          for (;;)
          {
            com.tencent.mm.plugin.voip.b.d.Logi("MicroMsg.Voip.VoipContext", "onVoipLocalNetTypeChange Error");
          }
        }
        locall.ABU = paramAnonymousInt;
        u.this.AEF.ekm();
        AppMethodBeat.o(115109);
      }
    };
    this.uXE = new au(Looper.getMainLooper(), new au.a()
    {
      public final boolean onTimerExpired()
      {
        AppMethodBeat.i(115111);
        ac.v("MicroMsg.Voip.VoipService", "voip repeat check is foreground");
        if (u.e(u.this) == null)
        {
          u.f(u.this);
          u.g(u.this).stopTimer();
          AppMethodBeat.o(115111);
          return false;
        }
        if (u.gx(ai.getContext()))
        {
          u.this.az(u.e(u.this).Exf, u.e(u.this).Exg);
          ac.i("MicroMsg.Voip.VoipService", "steve:voip callin in mRepeatCheckHandler, roomid:%d, roomkey:%s, time:%d", new Object[] { Integer.valueOf(u.e(u.this).Exf), Long.valueOf(u.e(u.this).Exg), Integer.valueOf(u.e(u.this).CreateTime) });
          u.this.c(u.e(u.this));
          u.h(u.this);
          u.f(u.this);
          u.g(u.this).stopTimer();
          com.tencent.mm.plugin.report.service.h.wUl.idkeyStat(500L, 5L, 1L, false);
          AppMethodBeat.o(115111);
          return false;
        }
        if (System.currentTimeMillis() - u.i(u.this) < 60000L)
        {
          AppMethodBeat.o(115111);
          return true;
        }
        u.h(u.this);
        u.f(u.this);
        u.g(u.this).stopTimer();
        AppMethodBeat.o(115111);
        return false;
      }
    }, true);
    this.AFa = null;
    this.AEF = new v();
    this.cUz = false;
    this.AEH = false;
    this.AEI = false;
    this.talker = null;
    this.AEJ = false;
    this.AAf = null;
    g.agQ().a(this.zVK);
    AppMethodBeat.o(115113);
  }
  
  public static byte[] W(byte[] paramArrayOfByte, int paramInt)
  {
    byte[] arrayOfByte = new byte[paramInt];
    int i = 12;
    while (i < paramInt + 12)
    {
      arrayOfByte[(i - 12)] = paramArrayOfByte[i];
      i += 1;
    }
    return arrayOfByte;
  }
  
  private static byte[] aO(Map<Integer, Long> paramMap)
  {
    AppMethodBeat.i(115126);
    dfx localdfx = new dfx();
    LinkedList localLinkedList = new LinkedList();
    Iterator localIterator = paramMap.keySet().iterator();
    while (localIterator.hasNext())
    {
      Integer localInteger = (Integer)localIterator.next();
      boe localboe = new boe();
      localboe.wTD = localInteger.intValue();
      localboe.FdH = ((Long)paramMap.get(localInteger)).intValue();
      localLinkedList.push(localboe);
    }
    localdfx.FIa = localLinkedList;
    localdfx.FHZ = localLinkedList.size();
    try
    {
      paramMap = localdfx.toByteArray();
      AppMethodBeat.o(115126);
      return paramMap;
    }
    catch (IOException paramMap)
    {
      ac.printErrStackTrace("MicroMsg.Voip.VoipService", paramMap, "", new Object[0]);
      AppMethodBeat.o(115126);
    }
    return null;
  }
  
  public static p.a ayw(String paramString)
  {
    AppMethodBeat.i(115124);
    if ((paramString == null) || (paramString.length() == 0))
    {
      AppMethodBeat.o(115124);
      return null;
    }
    int i = paramString.hashCode();
    p.a locala = (p.a)fAs.get(Integer.valueOf(i));
    if (locala != null)
    {
      AppMethodBeat.o(115124);
      return locala;
    }
    locala = new p.a();
    if (!locala.parse(paramString))
    {
      AppMethodBeat.o(115124);
      return null;
    }
    fAs.o(Integer.valueOf(i), locala);
    AppMethodBeat.o(115124);
    return locala;
  }
  
  private int b(dsb paramdsb)
  {
    int j = -1;
    boolean bool1 = true;
    AppMethodBeat.i(115120);
    Object localObject = com.tencent.mm.model.u.axw();
    String str2;
    int i;
    String str1;
    if (paramdsb != null)
    {
      str2 = paramdsb.FZq;
      k = paramdsb.FZh;
      ac.i("MicroMsg.Voip.VoipService", "steve:[simucall] being called! roomid:%d, myname:%s, remoteInviteName:%s,myInviteName:%s, calltype:%d, working:%b, dialing:%b, isSimulCall:%b", new Object[] { Integer.valueOf(paramdsb.Exf), localObject, str2, this.AEF.AFs, Integer.valueOf(k), Boolean.valueOf(this.AEF.eil()), Boolean.valueOf(this.AEF.Ayh.eij()), Boolean.valueOf(this.AEF.AFp) });
      i = j;
      if (!this.AEF.eil()) {
        break label616;
      }
      i = j;
      if (this.AEF.Ayh == null) {
        break label616;
      }
      i = j;
      if (!this.AEF.Ayh.eij()) {
        break label616;
      }
      i = j;
      if (this.AEF.AFp) {
        break label616;
      }
      str1 = this.AEF.AFs;
      if ((str2 == null) || (str1 == null))
      {
        ac.e("MicroMsg.Voip.VoipService", "steve:[simucall] name null! myname:%s, remoteInviteName:%s, myInviteName:%s", new Object[] { localObject, str2, str1 });
        AppMethodBeat.o(115120);
        return -1;
      }
    }
    else
    {
      AppMethodBeat.o(115120);
      return -1;
    }
    boolean bool2 = str1.equals(str2);
    ac.i("MicroMsg.Voip.VoipService", "steve:[simucall]  mutualCalling:%s", new Object[] { Boolean.valueOf(bool2) });
    if (bool2)
    {
      this.AEF.AFp = true;
      i = str1.compareTo((String)localObject);
      boolean bool3 = str1.contains("@");
      if ((i < 0) || (bool3))
      {
        i = 1;
        localObject = this.AEF.Ayh.ABJ;
        ((v2protocal)localObject).AIg |= 0x2;
        if (!this.AEG.egU()) {
          break label650;
        }
        j = 0;
        label347:
        if ((k != 1) && (j != 1)) {
          break label710;
        }
      }
    }
    label650:
    label710:
    for (int k = 1;; k = 0)
    {
      if ((this.AEG.egU()) && (k == 1))
      {
        ac.i("MicroMsg.Voip.VoipService", "steve:[simucall]audio room, close camera first! myInviteType:%d, finalRoomType:%d", new Object[] { Integer.valueOf(j), Integer.valueOf(k) });
        this.AEF.Ayh.ABK.RY(1);
      }
      paramdsb.FZh = k;
      this.AEF.AFq = k;
      ac.i("MicroMsg.Voip.VoipService", "steve:[simucall]myInviteName:%s, mutualCalling:%s,caller:%d,myInviteType:%d,finalType:%d", new Object[] { str1, Boolean.valueOf(bool2), Integer.valueOf(i), Integer.valueOf(j), Integer.valueOf(k) });
      if (i == 2)
      {
        ac.i("MicroMsg.Voip.VoipService", "steve:[simucall] i'm callee, cancel my previous invite!");
        this.AEF.AFr = true;
        if ((this.AEF.Ayh.ABJ != null) && (this.AEF.Ayh.ABJ.roomId != 0) && (this.AEF.Ayh.ABJ.tIG != 0L) && (this.AEF.Ayh.ABJ.roomId != paramdsb.Exf)) {
          b(this.AEF.Ayh.ABJ.roomId, this.AEF.Ayh.ABJ.tIG, j);
        }
        if (k == 0) {
          label607:
          this.AEG.sr(bool1);
        }
      }
      for (;;)
      {
        label616:
        if (this.AEF.AFp) {
          paramdsb.FZh = this.AEF.AFq;
        }
        AppMethodBeat.o(115120);
        return i;
        i = 2;
        break;
        j = 1;
        break label347;
        bool1 = false;
        break label607;
        this.AEF.AFr = false;
        ac.i("MicroMsg.Voip.VoipService", "steve:[simucall] i'm caller, do NOT answer others' invite!");
        continue;
        ac.i("MicroMsg.Voip.VoipService", "steve:[simucall] myInviteName:%s, mutualCalling:%s", new Object[] { str1, Boolean.valueOf(bool2) });
        i = j;
      }
    }
  }
  
  private static Map<Integer, Long> bL(byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(115125);
    if (bs.cv(paramArrayOfByte))
    {
      AppMethodBeat.o(115125);
      return null;
    }
    try
    {
      paramArrayOfByte = (dfx)new dfx().parseFrom(paramArrayOfByte);
      if (paramArrayOfByte == null)
      {
        AppMethodBeat.o(115125);
        return null;
      }
    }
    catch (Exception paramArrayOfByte)
    {
      AppMethodBeat.o(115125);
      return null;
    }
    ac.d("MicroMsg.Voip.VoipService", "dkpush : keyCount:" + paramArrayOfByte.FHZ);
    LinkedList localLinkedList = paramArrayOfByte.FIa;
    if (localLinkedList.size() != paramArrayOfByte.FHZ)
    {
      AppMethodBeat.o(115125);
      return null;
    }
    HashMap localHashMap = new HashMap();
    int i = 0;
    while (i < paramArrayOfByte.FHZ)
    {
      localHashMap.put(Integer.valueOf(((boe)localLinkedList.get(i)).wTD), Long.valueOf(0xFFFFFFFF & ((boe)localLinkedList.get(i)).FdH));
      i += 1;
    }
    if (localHashMap.size() != paramArrayOfByte.FHZ)
    {
      AppMethodBeat.o(115125);
      return null;
    }
    AppMethodBeat.o(115125);
    return localHashMap;
  }
  
  private static String bM(byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(115127);
    String str1 = "";
    int i = 0;
    while (i < paramArrayOfByte.length)
    {
      String str3 = Integer.toHexString(paramArrayOfByte[i] & 0xFF);
      String str2 = str3;
      if (str3.length() == 1) {
        str2 = "0".concat(String.valueOf(str3));
      }
      str1 = str1 + str2.toUpperCase();
      i += 1;
    }
    AppMethodBeat.o(115127);
    return str1;
  }
  
  private static boolean cK(Context paramContext)
  {
    AppMethodBeat.i(115150);
    Object localObject = ((ActivityManager)paramContext.getSystemService("activity")).getRunningTasks(1);
    if ((localObject != null) && (!((List)localObject).isEmpty()))
    {
      localObject = ((ActivityManager.RunningTaskInfo)((List)localObject).get(0)).topActivity;
      ac.d("MicroMsg.Voip.VoipService", "topActivity:" + ((ComponentName)localObject).flattenToString());
      if (!((ComponentName)localObject).getPackageName().equals(paramContext.getPackageName()))
      {
        ac.i("MicroMsg.Voip.VoipService", "is in backGround.");
        AppMethodBeat.o(115150);
        return false;
      }
    }
    if (((KeyguardManager)ai.getContext().getSystemService("keyguard")).inKeyguardRestrictedInputMode())
    {
      AppMethodBeat.o(115150);
      return false;
    }
    ac.i("MicroMsg.Voip.VoipService", "is in foreGround.");
    AppMethodBeat.o(115150);
    return true;
  }
  
  private static void ejI()
  {
    AppMethodBeat.i(115119);
    xh localxh = new xh();
    localxh.dAb.dgL = 7;
    com.tencent.mm.sdk.b.a.GpY.l(localxh);
    AppMethodBeat.o(115119);
  }
  
  private void ejU()
  {
    AppMethodBeat.i(115146);
    ac.m("MicroMsg.Voip.VoipService", "unbindVoiceServiceIfNeed", new Object[0]);
    if (com.tencent.mm.compatible.util.d.kZ(26)) {}
    try
    {
      Object localObject = new Intent();
      ((Intent)localObject).setClass(ai.getContext(), VoipForegroundService.class);
      ai.getContext().stopService((Intent)localObject);
      localObject = q.ADO;
      q.eiY();
      i = 1;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        ac.printErrStackTrace("MicroMsg.Voip.VoipService", localException, "unBind vidoeforeground error: %s", new Object[] { localException.getMessage() });
        int i = 0;
      }
    }
    if (i != 0) {
      this.AEW = false;
    }
    AppMethodBeat.o(115146);
  }
  
  public static float sG(boolean paramBoolean)
  {
    AppMethodBeat.i(115148);
    float f1 = 0.7476636F;
    float f2 = f1;
    for (;;)
    {
      try
      {
        localObject = com.tencent.mm.plugin.voip.c.ehb();
        if (!paramBoolean) {
          continue;
        }
        f2 = f1;
        localObject = ((u)localObject).AEF.Ayh.ABJ.field_capInfo;
        f2 = f1;
        if (localObject != null)
        {
          f2 = f1;
          localObject = ByteBuffer.wrap((byte[])localObject);
          f2 = f1;
          if (((ByteBuffer)localObject).getInt() > 65535)
          {
            f2 = f1;
            ((ByteBuffer)localObject).order(ByteOrder.LITTLE_ENDIAN);
          }
          f2 = f1;
          ((ByteBuffer)localObject).getShort();
          f2 = f1;
          ((ByteBuffer)localObject).getShort();
          f2 = f1;
          float f3 = ((ByteBuffer)localObject).getInt() / 100.0F;
          if (f3 != 0.0F) {
            f1 = f3;
          }
          f2 = f1;
          ac.d("MicroMsg.Voip.VoipService", "use rate: %s, changed: %s", new Object[] { Float.valueOf(f1), Boolean.valueOf(paramBoolean) });
          f2 = f1;
        }
      }
      catch (Exception localException)
      {
        Object localObject;
        ac.e("MicroMsg.Voip.VoipService", "update failed: " + localException.getMessage());
        continue;
      }
      AppMethodBeat.o(115148);
      return f2;
      f2 = f1;
      localObject = ((u)localObject).AEF.Ayh.ABJ.AGi;
    }
  }
  
  public final void Sm(int paramInt)
  {
    AppMethodBeat.i(115130);
    this.AEF.Sm(paramInt);
    AppMethodBeat.o(115130);
  }
  
  public final void So(int paramInt)
  {
    AppMethodBeat.i(115151);
    this.AEF.Ayh.So(paramInt);
    AppMethodBeat.o(115151);
  }
  
  public final void St(int paramInt)
  {
    AppMethodBeat.i(115123);
    if ((this.AFa == null) || (this.AFa.isEmpty()))
    {
      AppMethodBeat.o(115123);
      return;
    }
    Iterator localIterator = this.AFa.iterator();
    while (localIterator.hasNext())
    {
      a locala = (a)localIterator.next();
      if ((locala != null) && (locala.AFc != null) && (locala.AFc.Exf == paramInt))
      {
        locala.cancelled = true;
        AppMethodBeat.o(115123);
        return;
      }
    }
    AppMethodBeat.o(115123);
  }
  
  public final void Su(int paramInt)
  {
    AppMethodBeat.i(115134);
    ac.d("MicroMsg.Voip.VoipService", "devin: camera errcode: %d", new Object[] { Integer.valueOf(paramInt) });
    this.AEF.Su(paramInt);
    AppMethodBeat.o(115134);
  }
  
  public final void Sv(int paramInt)
  {
    AppMethodBeat.i(115141);
    v localv = this.AEF;
    if (localv.oue != null) {
      localv.oue.T(false, paramInt);
    }
    AppMethodBeat.o(115141);
  }
  
  public final void Sw(int paramInt)
  {
    AppMethodBeat.i(208393);
    k localk = k.ABe;
    k.a(this.AEF.Ayh.ABJ, paramInt);
    this.AEF.Ayh.ABJ.ekD();
    AppMethodBeat.o(208393);
  }
  
  public final void Sx(int paramInt)
  {
    AppMethodBeat.i(208394);
    this.AEF.Sx(paramInt);
    AppMethodBeat.o(208394);
  }
  
  public final int a(byte[] paramArrayOfByte1, int paramInt1, int paramInt2, int paramInt3, int paramInt4, byte[] paramArrayOfByte2, int paramInt5, int paramInt6, int paramInt7, int paramInt8)
  {
    AppMethodBeat.i(208386);
    n localn = this.AEF.Ayh.ABL;
    if (localn.osN == n.osM)
    {
      AppMethodBeat.o(208386);
      return -1;
    }
    if (!localn.Ayh.ABJ.ekM())
    {
      AppMethodBeat.o(208386);
      return -1;
    }
    if (!localn.Ayh.eit())
    {
      AppMethodBeat.o(208386);
      return -2;
    }
    paramInt1 = localn.Ayh.ABJ.videoRorate90D(paramArrayOfByte1, paramInt1, paramInt2, paramInt3, paramInt4, paramArrayOfByte2, paramInt5, paramInt6, paramInt7, paramInt8);
    AppMethodBeat.o(208386);
    return paramInt1;
  }
  
  public final int a(byte[] paramArrayOfByte, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int[] paramArrayOfInt, boolean paramBoolean)
  {
    AppMethodBeat.i(115136);
    n localn = this.AEF.Ayh.ABL;
    int i;
    if (localn.osN == n.osM)
    {
      i = 1;
      if (paramBoolean) {
        break label62;
      }
    }
    label62:
    for (int j = 1;; j = 0)
    {
      if ((j & i) == 0) {
        break label68;
      }
      AppMethodBeat.o(115136);
      return -1;
      i = 0;
      break;
    }
    label68:
    if (!localn.Ayh.ABJ.ekM())
    {
      AppMethodBeat.o(115136);
      return -1;
    }
    paramInt1 = localn.Ayh.ABJ.videoEncodeToLocal(paramArrayOfByte, paramInt1, paramInt3, paramInt4, paramInt2, 0, 75, paramArrayOfInt);
    AppMethodBeat.o(115136);
    return paramInt1;
  }
  
  public final void a(Context paramContext, x paramx)
  {
    AppMethodBeat.i(208377);
    this.AEF.a(paramContext, paramx);
    AppMethodBeat.o(208377);
  }
  
  public final void a(Context paramContext, String paramString, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3)
  {
    AppMethodBeat.i(115144);
    if (paramContext == null) {
      paramContext = ai.getContext();
    }
    for (;;)
    {
      dfW();
      long l = System.currentTimeMillis();
      Object localObject1 = new jx();
      ((jx)localObject1).dlw.dlz = false;
      ((jx)localObject1).dlw.dly = l;
      ((jx)localObject1).dlw.dlx = paramContext;
      com.tencent.mm.sdk.b.a.GpY.l((com.tencent.mm.sdk.b.b)localObject1);
      ac.i("MicroMsg.Voip.VoipService", "start VideoActivity in foreground,%s", new Object[] { Boolean.valueOf(AppForegroundDelegate.cHM.cqc) });
      int i;
      Intent localIntent;
      Object localObject2;
      if ((com.tencent.mm.compatible.util.d.lb(28)) || (Build.VERSION.CODENAME.equals("Q")))
      {
        i = 1;
        localIntent = new Intent(paramContext, VideoActivity.class);
        localIntent.putExtra("Voip_User", paramString);
        localIntent.putExtra("Voip_Outcall", paramBoolean1);
        localIntent.putExtra("Voip_VideoCall", paramBoolean2);
        localIntent.putExtra("Voip_LastPage_Hash", l);
        localObject2 = "";
        if ((paramBoolean1) || (i == 0) || (AppForegroundDelegate.cHM.cqc)) {
          break label458;
        }
        this.AEP = new u.b(this, paramBoolean2, paramString, paramBoolean3);
        String str = com.tencent.mm.model.v.wk(((com.tencent.mm.plugin.messenger.foundation.a.k)g.ab(com.tencent.mm.plugin.messenger.foundation.a.k.class)).awB().aNt(localIntent.getStringExtra("Voip_User")).field_username);
        localObject2 = new RemoteViews(ai.getPackageName(), 2131495877);
        ((RemoteViews)localObject2).setTextViewText(2131302962, str);
        if (!localIntent.getBooleanExtra("Voip_VideoCall", true)) {
          break label423;
        }
        localObject1 = ai.getResources().getString(2131764876);
        ((RemoteViews)localObject2).setTextViewText(2131302963, (CharSequence)localObject1);
        ((RemoteViews)localObject2).setImageViewResource(2131302957, 2131234460);
        label314:
        ((RemoteViews)localObject2).setImageViewResource(2131306948, 2131234752);
        str = str + (String)localObject1;
        localObject1 = localObject2;
        localObject2 = str;
      }
      for (;;)
      {
        if (paramBoolean3)
        {
          localIntent.setFlags(603979776);
          localIntent.addFlags(268435456);
        }
        if (localObject1 == null) {
          i(paramString, paramBoolean2, false);
        }
        com.tencent.mm.util.a.a(paramContext, localIntent, (RemoteViews)localObject1, (String)localObject2, VideoActivity.class.getCanonicalName(), com.tencent.mm.bq.a.eJQ());
        AppMethodBeat.o(115144);
        return;
        i = 0;
        break;
        label423:
        localObject1 = ai.getResources().getString(2131764875);
        ((RemoteViews)localObject2).setTextViewText(2131302963, (CharSequence)localObject1);
        ((RemoteViews)localObject2).setImageViewResource(2131302957, 2131234488);
        break label314;
        label458:
        localObject1 = null;
      }
    }
  }
  
  public final void aH(int paramInt, boolean paramBoolean)
  {
    AppMethodBeat.i(115140);
    v localv = this.AEF;
    if (localv.oue != null) {
      localv.oue.aI(paramInt, paramBoolean);
    }
    AppMethodBeat.o(115140);
  }
  
  public final void aHe()
  {
    AppMethodBeat.i(115142);
    ac.i("MicroMsg.Voip.VoipService", "unRegister and remove all notification and voip foreground service");
    this.AEJ = false;
    ejU();
    dfW();
    ((com.tencent.mm.plugin.notification.b.a)g.ad(com.tencent.mm.plugin.notification.b.a.class)).getNotification().cancel(40);
    AppMethodBeat.o(115142);
  }
  
  public final int aKj()
  {
    AppMethodBeat.i(185953);
    n localn = this.AEF.Ayh.ABL;
    if (localn.ACs != null)
    {
      int i = localn.ACs.aKj();
      AppMethodBeat.o(185953);
      return i;
    }
    AppMethodBeat.o(185953);
    return 0;
  }
  
  public final void aq(boolean paramBoolean1, boolean paramBoolean2)
  {
    AppMethodBeat.i(115116);
    this.AEU = paramBoolean1;
    this.AEV = paramBoolean2;
    ac.d("MicroMsg.Voip.VoipService", "isMinimize: %b, miniOnlyHideVoip: %b", new Object[] { Boolean.valueOf(paramBoolean1), Boolean.valueOf(paramBoolean2) });
    AppMethodBeat.o(115116);
  }
  
  public final int ar(boolean paramBoolean1, boolean paramBoolean2)
  {
    AppMethodBeat.i(115129);
    int i = this.AEF.ar(paramBoolean1, paramBoolean2);
    AppMethodBeat.o(115129);
    return i;
  }
  
  public final int ayx(String paramString)
  {
    AppMethodBeat.i(208379);
    int i = this.AEF.eR(paramString, 1);
    AppMethodBeat.o(208379);
    return i;
  }
  
  public final int ayy(String paramString)
  {
    AppMethodBeat.i(208380);
    int i = this.AEF.eR(paramString, 0);
    AppMethodBeat.o(208380);
    return i;
  }
  
  public final void az(final int paramInt, final long paramLong)
  {
    AppMethodBeat.i(115121);
    ap.f(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(115110);
        ac.i("MicroMsg.Voip.VoipService", "onDelayInvite, roomId:%s, roomKey:%s", new Object[] { Integer.valueOf(paramInt), Long.valueOf(paramLong) });
        if ((!com.tencent.mm.m.f.Zh()) && (!u.gx(ai.getContext())))
        {
          ac.i("MicroMsg.Voip.VoipService", "background now and notification Is closed.");
          AppMethodBeat.o(115110);
          return;
        }
        if (u.this.AEF.ekd())
        {
          ac.i("MicroMsg.Voip.VoipService", "room is ready, ingore the msg and ack busy");
          if ((u.this.AEF.Ayh.ABJ.roomId != paramInt) && (u.this.AEF.Ayh.ABJ.tIG != paramLong))
          {
            ac.i("MicroMsg.Voip.VoipService", "not match current room id and roomkey: %s %s %s %s", new Object[] { Integer.valueOf(paramInt), Long.valueOf(paramLong), Integer.valueOf(u.this.AEF.Ayh.ABJ.roomId), Long.valueOf(u.this.AEF.Ayh.ABJ.tIG) });
            u.this.AEF.a(paramInt, paramLong, 2, null, null, u.b(u.this));
          }
          AppMethodBeat.o(115110);
          return;
        }
        new e(paramInt, paramLong, "").ekv();
        ac.i("MicroMsg.Voip.VoipService", "onDelayInvite, send getroominfo cgi done! roomId:%d, roomKey:%s", new Object[] { Integer.valueOf(paramInt), Long.valueOf(paramLong) });
        if (!u.c(u.this))
        {
          com.tencent.mm.plugin.voip.b.d.c(paramInt, paramLong, 1, 2);
          u.d(u.this);
        }
        AppMethodBeat.o(115110);
      }
    });
    AppMethodBeat.o(115121);
  }
  
  public final int b(int paramInt1, long paramLong, int paramInt2)
  {
    AppMethodBeat.i(115132);
    paramInt1 = this.AEF.c(paramInt1, paramLong, paramInt2);
    AppMethodBeat.o(115132);
    return paramInt1;
  }
  
  public final int b(ByteBuffer paramByteBuffer, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    AppMethodBeat.i(208388);
    paramInt1 = this.AEF.b(paramByteBuffer, paramInt1, paramInt2, paramInt3, paramInt4);
    AppMethodBeat.o(208388);
    return paramInt1;
  }
  
  /* Error */
  public final int b(byte[] paramArrayOfByte, int paramInt, long paramLong)
  {
    // Byte code:
    //   0: ldc_w 998
    //   3: invokestatic 71	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   6: lconst_0
    //   7: lstore 18
    //   9: lconst_0
    //   10: lstore 16
    //   12: lconst_0
    //   13: lstore 8
    //   15: lconst_0
    //   16: lstore 10
    //   18: lconst_0
    //   19: lstore 12
    //   21: ldc 243
    //   23: ldc_w 1000
    //   26: invokestatic 387	com/tencent/mm/sdk/platformtools/ac:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   29: aload_0
    //   30: getfield 154	com/tencent/mm/plugin/voip/model/u:AEF	Lcom/tencent/mm/plugin/voip/model/v;
    //   33: getfield 318	com/tencent/mm/plugin/voip/model/v:Ayh	Lcom/tencent/mm/plugin/voip/model/l;
    //   36: getfield 1003	com/tencent/mm/plugin/voip/model/l:ABN	[B
    //   39: invokestatic 1005	com/tencent/mm/plugin/voip/model/u:bL	([B)Ljava/util/Map;
    //   42: astore 24
    //   44: aload 24
    //   46: ifnonnull +328 -> 374
    //   49: ldc 243
    //   51: ldc_w 1007
    //   54: invokestatic 387	com/tencent/mm/sdk/platformtools/ac:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   57: lconst_0
    //   58: lstore 14
    //   60: ldc 243
    //   62: new 425	java/lang/StringBuilder
    //   65: dup
    //   66: ldc_w 1009
    //   69: invokespecial 430	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   72: lload 18
    //   74: invokevirtual 1012	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   77: ldc_w 1014
    //   80: invokevirtual 474	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   83: lload 16
    //   85: invokevirtual 1012	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   88: ldc_w 1016
    //   91: invokevirtual 474	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   94: lload 14
    //   96: invokevirtual 1012	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   99: invokevirtual 437	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   102: invokestatic 387	com/tencent/mm/sdk/platformtools/ac:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   105: new 1018	com/tencent/mm/protocal/protobuf/drx
    //   108: dup
    //   109: invokespecial 1019	com/tencent/mm/protocal/protobuf/drx:<init>	()V
    //   112: aload_1
    //   113: invokevirtual 1020	com/tencent/mm/protocal/protobuf/drx:parseFrom	([B)Lcom/tencent/mm/bw/a;
    //   116: checkcast 1018	com/tencent/mm/protocal/protobuf/drx
    //   119: astore 24
    //   121: iconst_0
    //   122: istore 5
    //   124: lload 12
    //   126: lstore 6
    //   128: iload 5
    //   130: aload 24
    //   132: getfield 1023	com/tencent/mm/protocal/protobuf/drx:FZj	Ljava/util/LinkedList;
    //   135: invokevirtual 234	java/util/LinkedList:size	()I
    //   138: if_icmpge +1145 -> 1283
    //   141: aload 24
    //   143: getfield 1023	com/tencent/mm/protocal/protobuf/drx:FZj	Ljava/util/LinkedList;
    //   146: iload 5
    //   148: invokevirtual 443	java/util/LinkedList:get	(I)Ljava/lang/Object;
    //   151: checkcast 1025	com/tencent/mm/protocal/protobuf/drw
    //   154: astore 25
    //   156: ldc 243
    //   158: new 425	java/lang/StringBuilder
    //   161: dup
    //   162: ldc_w 1027
    //   165: invokespecial 430	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   168: aload 25
    //   170: getfield 1030	com/tencent/mm/protocal/protobuf/drw:ErL	I
    //   173: invokevirtual 434	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   176: invokevirtual 437	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   179: invokestatic 387	com/tencent/mm/sdk/platformtools/ac:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   182: aload 25
    //   184: getfield 1030	com/tencent/mm/protocal/protobuf/drw:ErL	I
    //   187: iconst_1
    //   188: if_icmpne +450 -> 638
    //   191: new 1032	com/tencent/mm/protocal/protobuf/dtd
    //   194: dup
    //   195: invokespecial 1033	com/tencent/mm/protocal/protobuf/dtd:<init>	()V
    //   198: aload 25
    //   200: getfield 1037	com/tencent/mm/protocal/protobuf/drw:DVs	Lcom/tencent/mm/protocal/protobuf/SKBuiltinBuffer_t;
    //   203: invokevirtual 1042	com/tencent/mm/protocal/protobuf/SKBuiltinBuffer_t:getBufferToBytes	()[B
    //   206: invokevirtual 1043	com/tencent/mm/protocal/protobuf/dtd:parseFrom	([B)Lcom/tencent/mm/bw/a;
    //   209: checkcast 1032	com/tencent/mm/protocal/protobuf/dtd
    //   212: astore_1
    //   213: aload_1
    //   214: ifnull +405 -> 619
    //   217: ldc 243
    //   219: new 425	java/lang/StringBuilder
    //   222: dup
    //   223: ldc_w 1045
    //   226: invokespecial 430	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   229: aload_1
    //   230: getfield 1048	com/tencent/mm/protocal/protobuf/dtd:ndj	I
    //   233: invokevirtual 434	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   236: invokevirtual 437	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   239: invokestatic 387	com/tencent/mm/sdk/platformtools/ac:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   242: lload 8
    //   244: lstore 12
    //   246: lload 8
    //   248: aload 25
    //   250: getfield 1049	com/tencent/mm/protocal/protobuf/drw:wTD	I
    //   253: i2l
    //   254: lcmp
    //   255: ifge +11 -> 266
    //   258: aload 25
    //   260: getfield 1049	com/tencent/mm/protocal/protobuf/drw:wTD	I
    //   263: i2l
    //   264: lstore 12
    //   266: lload 12
    //   268: lstore 8
    //   270: aload 25
    //   272: getfield 1049	com/tencent/mm/protocal/protobuf/drw:wTD	I
    //   275: i2l
    //   276: lload 18
    //   278: lcmp
    //   279: ifle +348 -> 627
    //   282: ldc 243
    //   284: new 425	java/lang/StringBuilder
    //   287: dup
    //   288: ldc_w 1051
    //   291: invokespecial 430	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   294: aload 25
    //   296: getfield 1049	com/tencent/mm/protocal/protobuf/drw:wTD	I
    //   299: invokevirtual 434	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   302: ldc_w 1053
    //   305: invokevirtual 474	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   308: lload 18
    //   310: invokevirtual 1012	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   313: ldc_w 1055
    //   316: invokevirtual 474	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   319: aload_1
    //   320: getfield 1048	com/tencent/mm/protocal/protobuf/dtd:ndj	I
    //   323: invokevirtual 434	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   326: ldc_w 1057
    //   329: invokevirtual 474	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   332: invokevirtual 437	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   335: invokestatic 387	com/tencent/mm/sdk/platformtools/ac:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   338: aload_0
    //   339: getfield 154	com/tencent/mm/plugin/voip/model/u:AEF	Lcom/tencent/mm/plugin/voip/model/v;
    //   342: getfield 318	com/tencent/mm/plugin/voip/model/v:Ayh	Lcom/tencent/mm/plugin/voip/model/l;
    //   345: getfield 1061	com/tencent/mm/plugin/voip/model/l:ABM	Lcom/tencent/mm/plugin/voip/model/w;
    //   348: aload_1
    //   349: iconst_1
    //   350: invokevirtual 1066	com/tencent/mm/plugin/voip/model/w:a	(Lcom/tencent/mm/protocal/protobuf/dtd;I)V
    //   353: lload 10
    //   355: lstore 22
    //   357: iload 5
    //   359: iconst_1
    //   360: iadd
    //   361: istore 5
    //   363: lload 22
    //   365: lstore 10
    //   367: lload 12
    //   369: lstore 8
    //   371: goto -243 -> 128
    //   374: aload 24
    //   376: invokeinterface 185 1 0
    //   381: invokeinterface 191 1 0
    //   386: astore 25
    //   388: lconst_0
    //   389: lstore 6
    //   391: aload 25
    //   393: invokeinterface 197 1 0
    //   398: ifeq +1116 -> 1514
    //   401: aload 25
    //   403: invokeinterface 201 1 0
    //   408: checkcast 203	java/lang/Integer
    //   411: astore 26
    //   413: aload 24
    //   415: aload 26
    //   417: invokeinterface 217 2 0
    //   422: checkcast 219	java/lang/Long
    //   425: astore 27
    //   427: aload 26
    //   429: invokevirtual 210	java/lang/Integer:intValue	()I
    //   432: tableswitch	default:+28 -> 460, 1:+68->500, 2:+78->510, 3:+88->520
    //   461: <illegal opcode>
    //   462: new 425	java/lang/StringBuilder
    //   465: dup
    //   466: ldc_w 1068
    //   469: invokespecial 430	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   472: aload 26
    //   474: invokevirtual 210	java/lang/Integer:intValue	()I
    //   477: invokevirtual 434	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   480: ldc_w 1070
    //   483: invokevirtual 474	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   486: aload 27
    //   488: invokevirtual 1073	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   491: invokevirtual 437	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   494: invokestatic 387	com/tencent/mm/sdk/platformtools/ac:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   497: goto -106 -> 391
    //   500: aload 27
    //   502: invokevirtual 1076	java/lang/Long:longValue	()J
    //   505: lstore 18
    //   507: goto -116 -> 391
    //   510: aload 27
    //   512: invokevirtual 1076	java/lang/Long:longValue	()J
    //   515: lstore 16
    //   517: goto -126 -> 391
    //   520: aload 27
    //   522: invokevirtual 1076	java/lang/Long:longValue	()J
    //   525: lstore 6
    //   527: goto -136 -> 391
    //   530: astore 24
    //   532: ldc 243
    //   534: aload 24
    //   536: ldc 245
    //   538: iconst_0
    //   539: anewarray 4	java/lang/Object
    //   542: invokestatic 251	com/tencent/mm/sdk/platformtools/ac:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   545: aload_1
    //   546: invokestatic 1078	com/tencent/mm/plugin/voip/model/u:bM	([B)Ljava/lang/String;
    //   549: astore 24
    //   551: ldc 243
    //   553: new 425	java/lang/StringBuilder
    //   556: dup
    //   557: ldc_w 1080
    //   560: invokespecial 430	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   563: aload_1
    //   564: arraylength
    //   565: invokevirtual 434	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   568: ldc_w 1082
    //   571: invokevirtual 474	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   574: aload 24
    //   576: invokevirtual 474	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   579: invokevirtual 437	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   582: invokestatic 387	com/tencent/mm/sdk/platformtools/ac:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   585: ldc_w 998
    //   588: invokestatic 81	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   591: iconst_0
    //   592: ireturn
    //   593: astore_1
    //   594: ldc 243
    //   596: ldc_w 1084
    //   599: invokestatic 387	com/tencent/mm/sdk/platformtools/ac:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   602: ldc 243
    //   604: aload_1
    //   605: ldc 245
    //   607: iconst_0
    //   608: anewarray 4	java/lang/Object
    //   611: invokestatic 251	com/tencent/mm/sdk/platformtools/ac:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   614: aconst_null
    //   615: astore_1
    //   616: goto -403 -> 213
    //   619: ldc 243
    //   621: ldc_w 1084
    //   624: invokestatic 387	com/tencent/mm/sdk/platformtools/ac:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   627: lload 10
    //   629: lstore 22
    //   631: lload 8
    //   633: lstore 12
    //   635: goto -278 -> 357
    //   638: aload 25
    //   640: getfield 1030	com/tencent/mm/protocal/protobuf/drw:ErL	I
    //   643: iconst_2
    //   644: if_icmpne +416 -> 1060
    //   647: new 1086	com/tencent/mm/protocal/protobuf/dss
    //   650: dup
    //   651: invokespecial 1087	com/tencent/mm/protocal/protobuf/dss:<init>	()V
    //   654: aload 25
    //   656: getfield 1037	com/tencent/mm/protocal/protobuf/drw:DVs	Lcom/tencent/mm/protocal/protobuf/SKBuiltinBuffer_t;
    //   659: invokevirtual 1042	com/tencent/mm/protocal/protobuf/SKBuiltinBuffer_t:getBufferToBytes	()[B
    //   662: invokevirtual 1088	com/tencent/mm/protocal/protobuf/dss:parseFrom	([B)Lcom/tencent/mm/bw/a;
    //   665: checkcast 1086	com/tencent/mm/protocal/protobuf/dss
    //   668: astore_1
    //   669: aload_1
    //   670: ifnull +371 -> 1041
    //   673: ldc 243
    //   675: new 425	java/lang/StringBuilder
    //   678: dup
    //   679: ldc_w 1090
    //   682: invokespecial 430	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   685: aload_1
    //   686: getfield 1093	com/tencent/mm/protocal/protobuf/dss:ndI	I
    //   689: invokevirtual 434	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   692: invokevirtual 437	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   695: invokestatic 387	com/tencent/mm/sdk/platformtools/ac:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   698: lload 10
    //   700: lstore 12
    //   702: lload 10
    //   704: aload 25
    //   706: getfield 1049	com/tencent/mm/protocal/protobuf/drw:wTD	I
    //   709: i2l
    //   710: lcmp
    //   711: ifge +11 -> 722
    //   714: aload 25
    //   716: getfield 1049	com/tencent/mm/protocal/protobuf/drw:wTD	I
    //   719: i2l
    //   720: lstore 12
    //   722: aload 25
    //   724: getfield 1049	com/tencent/mm/protocal/protobuf/drw:wTD	I
    //   727: i2l
    //   728: lload 16
    //   730: lcmp
    //   731: ifle +256 -> 987
    //   734: ldc 243
    //   736: new 425	java/lang/StringBuilder
    //   739: dup
    //   740: ldc_w 1095
    //   743: invokespecial 430	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   746: aload 25
    //   748: getfield 1049	com/tencent/mm/protocal/protobuf/drw:wTD	I
    //   751: invokevirtual 434	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   754: ldc_w 1097
    //   757: invokevirtual 474	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   760: lload 16
    //   762: invokevirtual 1012	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   765: ldc_w 1057
    //   768: invokevirtual 474	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   771: invokevirtual 437	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   774: invokestatic 387	com/tencent/mm/sdk/platformtools/ac:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   777: aload_1
    //   778: getfield 1093	com/tencent/mm/protocal/protobuf/dss:ndI	I
    //   781: iconst_5
    //   782: if_icmpne +54 -> 836
    //   785: aload_0
    //   786: getfield 154	com/tencent/mm/plugin/voip/model/u:AEF	Lcom/tencent/mm/plugin/voip/model/v;
    //   789: getfield 318	com/tencent/mm/plugin/voip/model/v:Ayh	Lcom/tencent/mm/plugin/voip/model/l;
    //   792: getfield 1061	com/tencent/mm/plugin/voip/model/l:ABM	Lcom/tencent/mm/plugin/voip/model/w;
    //   795: aload_1
    //   796: invokevirtual 1100	com/tencent/mm/plugin/voip/model/w:a	(Lcom/tencent/mm/protocal/protobuf/dss;)V
    //   799: lload 12
    //   801: lstore 22
    //   803: lload 8
    //   805: lstore 12
    //   807: goto -450 -> 357
    //   810: astore_1
    //   811: ldc 243
    //   813: ldc_w 1102
    //   816: invokestatic 387	com/tencent/mm/sdk/platformtools/ac:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   819: ldc 243
    //   821: aload_1
    //   822: ldc 245
    //   824: iconst_0
    //   825: anewarray 4	java/lang/Object
    //   828: invokestatic 251	com/tencent/mm/sdk/platformtools/ac:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   831: aconst_null
    //   832: astore_1
    //   833: goto -164 -> 669
    //   836: aload_1
    //   837: getfield 1093	com/tencent/mm/protocal/protobuf/dss:ndI	I
    //   840: iconst_1
    //   841: if_icmpne +28 -> 869
    //   844: aload_0
    //   845: getfield 154	com/tencent/mm/plugin/voip/model/u:AEF	Lcom/tencent/mm/plugin/voip/model/v;
    //   848: getfield 318	com/tencent/mm/plugin/voip/model/v:Ayh	Lcom/tencent/mm/plugin/voip/model/l;
    //   851: getfield 1061	com/tencent/mm/plugin/voip/model/l:ABM	Lcom/tencent/mm/plugin/voip/model/w;
    //   854: aload_1
    //   855: invokevirtual 1104	com/tencent/mm/plugin/voip/model/w:b	(Lcom/tencent/mm/protocal/protobuf/dss;)V
    //   858: lload 12
    //   860: lstore 22
    //   862: lload 8
    //   864: lstore 12
    //   866: goto -509 -> 357
    //   869: aload_1
    //   870: getfield 1093	com/tencent/mm/protocal/protobuf/dss:ndI	I
    //   873: bipush 6
    //   875: if_icmpne +76 -> 951
    //   878: aload_1
    //   879: getfield 1105	com/tencent/mm/protocal/protobuf/dss:DVs	Lcom/tencent/mm/protocal/protobuf/SKBuiltinBuffer_t;
    //   882: invokevirtual 1109	com/tencent/mm/protocal/protobuf/SKBuiltinBuffer_t:getBuffer	()Lcom/tencent/mm/bw/b;
    //   885: invokevirtual 1112	com/tencent/mm/bw/b:toByteArray	()[B
    //   888: astore_1
    //   889: new 1114	com/tencent/mm/protocal/protobuf/dsl
    //   892: dup
    //   893: invokespecial 1115	com/tencent/mm/protocal/protobuf/dsl:<init>	()V
    //   896: aload_1
    //   897: invokevirtual 1116	com/tencent/mm/protocal/protobuf/dsl:parseFrom	([B)Lcom/tencent/mm/bw/a;
    //   900: checkcast 1114	com/tencent/mm/protocal/protobuf/dsl
    //   903: astore_1
    //   904: aload_1
    //   905: ifnull +17 -> 922
    //   908: aload_0
    //   909: getfield 154	com/tencent/mm/plugin/voip/model/u:AEF	Lcom/tencent/mm/plugin/voip/model/v;
    //   912: getfield 318	com/tencent/mm/plugin/voip/model/v:Ayh	Lcom/tencent/mm/plugin/voip/model/l;
    //   915: getfield 1061	com/tencent/mm/plugin/voip/model/l:ABM	Lcom/tencent/mm/plugin/voip/model/w;
    //   918: aload_1
    //   919: invokevirtual 1119	com/tencent/mm/plugin/voip/model/w:a	(Lcom/tencent/mm/protocal/protobuf/dsl;)V
    //   922: lload 12
    //   924: lstore 22
    //   926: lload 8
    //   928: lstore 12
    //   930: goto -573 -> 357
    //   933: astore_1
    //   934: ldc 243
    //   936: aload_1
    //   937: ldc 245
    //   939: iconst_0
    //   940: anewarray 4	java/lang/Object
    //   943: invokestatic 251	com/tencent/mm/sdk/platformtools/ac:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   946: aconst_null
    //   947: astore_1
    //   948: goto -44 -> 904
    //   951: ldc 243
    //   953: new 425	java/lang/StringBuilder
    //   956: dup
    //   957: ldc_w 1121
    //   960: invokespecial 430	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   963: aload_1
    //   964: getfield 1093	com/tencent/mm/protocal/protobuf/dss:ndI	I
    //   967: invokevirtual 434	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   970: invokevirtual 437	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   973: invokestatic 387	com/tencent/mm/sdk/platformtools/ac:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   976: lload 12
    //   978: lstore 22
    //   980: lload 8
    //   982: lstore 12
    //   984: goto -627 -> 357
    //   987: ldc 243
    //   989: new 425	java/lang/StringBuilder
    //   992: dup
    //   993: ldc_w 1123
    //   996: invokespecial 430	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   999: aload 25
    //   1001: getfield 1049	com/tencent/mm/protocal/protobuf/drw:wTD	I
    //   1004: invokevirtual 434	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1007: ldc_w 1125
    //   1010: invokevirtual 474	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1013: lload 16
    //   1015: invokevirtual 1012	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   1018: ldc_w 1057
    //   1021: invokevirtual 474	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1024: invokevirtual 437	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1027: invokestatic 387	com/tencent/mm/sdk/platformtools/ac:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   1030: lload 12
    //   1032: lstore 22
    //   1034: lload 8
    //   1036: lstore 12
    //   1038: goto -681 -> 357
    //   1041: ldc 243
    //   1043: ldc_w 1102
    //   1046: invokestatic 387	com/tencent/mm/sdk/platformtools/ac:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   1049: lload 10
    //   1051: lstore 22
    //   1053: lload 8
    //   1055: lstore 12
    //   1057: goto -700 -> 357
    //   1060: aload 25
    //   1062: getfield 1030	com/tencent/mm/protocal/protobuf/drw:ErL	I
    //   1065: iconst_3
    //   1066: if_icmpne +437 -> 1503
    //   1069: new 1039	com/tencent/mm/protocal/protobuf/SKBuiltinBuffer_t
    //   1072: dup
    //   1073: invokespecial 1126	com/tencent/mm/protocal/protobuf/SKBuiltinBuffer_t:<init>	()V
    //   1076: aload 25
    //   1078: getfield 1037	com/tencent/mm/protocal/protobuf/drw:DVs	Lcom/tencent/mm/protocal/protobuf/SKBuiltinBuffer_t;
    //   1081: invokevirtual 1042	com/tencent/mm/protocal/protobuf/SKBuiltinBuffer_t:getBufferToBytes	()[B
    //   1084: invokevirtual 1129	com/tencent/mm/protocal/protobuf/SKBuiltinBuffer_t:parseFrom	([B)Lcom/tencent/mm/protocal/protobuf/SKBuiltinBuffer_t;
    //   1087: astore_1
    //   1088: aload_1
    //   1089: ifnull +414 -> 1503
    //   1092: lload 6
    //   1094: aload 25
    //   1096: getfield 1049	com/tencent/mm/protocal/protobuf/drw:wTD	I
    //   1099: i2l
    //   1100: lcmp
    //   1101: ifge +395 -> 1496
    //   1104: aload 25
    //   1106: getfield 1049	com/tencent/mm/protocal/protobuf/drw:wTD	I
    //   1109: i2l
    //   1110: lstore 20
    //   1112: lload 20
    //   1114: lstore 6
    //   1116: lload 10
    //   1118: lstore 22
    //   1120: lload 8
    //   1122: lstore 12
    //   1124: aload 25
    //   1126: getfield 1049	com/tencent/mm/protocal/protobuf/drw:wTD	I
    //   1129: i2l
    //   1130: lload 14
    //   1132: lcmp
    //   1133: ifle -776 -> 357
    //   1136: ldc 243
    //   1138: new 425	java/lang/StringBuilder
    //   1141: dup
    //   1142: ldc_w 1131
    //   1145: invokespecial 430	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   1148: aload 25
    //   1150: getfield 1049	com/tencent/mm/protocal/protobuf/drw:wTD	I
    //   1153: invokevirtual 434	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1156: ldc_w 1133
    //   1159: invokevirtual 474	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1162: lload 14
    //   1164: invokevirtual 1012	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   1167: ldc_w 1057
    //   1170: invokevirtual 474	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1173: invokevirtual 437	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1176: invokestatic 387	com/tencent/mm/sdk/platformtools/ac:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   1179: aload_0
    //   1180: getfield 154	com/tencent/mm/plugin/voip/model/u:AEF	Lcom/tencent/mm/plugin/voip/model/v;
    //   1183: getfield 318	com/tencent/mm/plugin/voip/model/v:Ayh	Lcom/tencent/mm/plugin/voip/model/l;
    //   1186: getfield 1061	com/tencent/mm/plugin/voip/model/l:ABM	Lcom/tencent/mm/plugin/voip/model/w;
    //   1189: aload_1
    //   1190: invokevirtual 1136	com/tencent/mm/plugin/voip/model/w:c	(Lcom/tencent/mm/protocal/protobuf/SKBuiltinBuffer_t;)V
    //   1193: lload 20
    //   1195: lstore 6
    //   1197: lload 10
    //   1199: lstore 22
    //   1201: lload 8
    //   1203: lstore 12
    //   1205: aload_0
    //   1206: getfield 122	com/tencent/mm/plugin/voip/model/u:AEX	Lcom/tencent/mm/protocal/protobuf/dsb;
    //   1209: ifnull -852 -> 357
    //   1212: lload 20
    //   1214: lstore 6
    //   1216: lload 10
    //   1218: lstore 22
    //   1220: lload 8
    //   1222: lstore 12
    //   1224: aload_1
    //   1225: invokevirtual 1109	com/tencent/mm/protocal/protobuf/SKBuiltinBuffer_t:getBuffer	()Lcom/tencent/mm/bw/b;
    //   1228: invokevirtual 1112	com/tencent/mm/bw/b:toByteArray	()[B
    //   1231: invokestatic 1142	com/tencent/mm/plugin/voip/b/d:bO	([B)I
    //   1234: sipush 255
    //   1237: iand
    //   1238: iconst_1
    //   1239: if_icmpne -882 -> 357
    //   1242: aload_0
    //   1243: getfield 122	com/tencent/mm/plugin/voip/model/u:AEX	Lcom/tencent/mm/protocal/protobuf/dsb;
    //   1246: iconst_1
    //   1247: putfield 298	com/tencent/mm/protocal/protobuf/dsb:FZh	I
    //   1250: lload 20
    //   1252: lstore 6
    //   1254: lload 10
    //   1256: lstore 22
    //   1258: lload 8
    //   1260: lstore 12
    //   1262: goto -905 -> 357
    //   1265: astore_1
    //   1266: ldc 243
    //   1268: aload_1
    //   1269: ldc 245
    //   1271: iconst_0
    //   1272: anewarray 4	java/lang/Object
    //   1275: invokestatic 251	com/tencent/mm/sdk/platformtools/ac:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   1278: aconst_null
    //   1279: astore_1
    //   1280: goto -192 -> 1088
    //   1283: lload 8
    //   1285: lload 18
    //   1287: lcmp
    //   1288: ifle +201 -> 1489
    //   1291: lload 10
    //   1293: lload 16
    //   1295: lcmp
    //   1296: ifle +186 -> 1482
    //   1299: lload 6
    //   1301: lload 14
    //   1303: lcmp
    //   1304: ifle +171 -> 1475
    //   1307: new 99	java/util/HashMap
    //   1310: dup
    //   1311: invokespecial 100	java/util/HashMap:<init>	()V
    //   1314: astore_1
    //   1315: aload_1
    //   1316: iconst_1
    //   1317: invokestatic 268	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   1320: lload 8
    //   1322: invokestatic 448	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   1325: invokeinterface 452 3 0
    //   1330: pop
    //   1331: aload_1
    //   1332: iconst_2
    //   1333: invokestatic 268	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   1336: lload 10
    //   1338: invokestatic 448	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   1341: invokeinterface 452 3 0
    //   1346: pop
    //   1347: aload_1
    //   1348: iconst_3
    //   1349: invokestatic 268	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   1352: lload 6
    //   1354: invokestatic 448	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   1357: invokeinterface 452 3 0
    //   1362: pop
    //   1363: aload_1
    //   1364: invokestatic 1144	com/tencent/mm/plugin/voip/model/u:aO	(Ljava/util/Map;)[B
    //   1367: astore_1
    //   1368: iload_2
    //   1369: aload_0
    //   1370: getfield 154	com/tencent/mm/plugin/voip/model/u:AEF	Lcom/tencent/mm/plugin/voip/model/v;
    //   1373: getfield 318	com/tencent/mm/plugin/voip/model/v:Ayh	Lcom/tencent/mm/plugin/voip/model/l;
    //   1376: getfield 354	com/tencent/mm/plugin/voip/model/l:ABJ	Lcom/tencent/mm/plugin/voip/model/v2protocal;
    //   1379: getfield 393	com/tencent/mm/plugin/voip/model/v2protocal:roomId	I
    //   1382: if_icmpne +77 -> 1459
    //   1385: lload_3
    //   1386: aload_0
    //   1387: getfield 154	com/tencent/mm/plugin/voip/model/u:AEF	Lcom/tencent/mm/plugin/voip/model/v;
    //   1390: getfield 318	com/tencent/mm/plugin/voip/model/v:Ayh	Lcom/tencent/mm/plugin/voip/model/l;
    //   1393: getfield 354	com/tencent/mm/plugin/voip/model/l:ABJ	Lcom/tencent/mm/plugin/voip/model/v2protocal;
    //   1396: getfield 396	com/tencent/mm/plugin/voip/model/v2protocal:tIG	J
    //   1399: lcmp
    //   1400: ifne +59 -> 1459
    //   1403: aload_0
    //   1404: getfield 154	com/tencent/mm/plugin/voip/model/u:AEF	Lcom/tencent/mm/plugin/voip/model/v;
    //   1407: getfield 318	com/tencent/mm/plugin/voip/model/v:Ayh	Lcom/tencent/mm/plugin/voip/model/l;
    //   1410: aload_1
    //   1411: putfield 1003	com/tencent/mm/plugin/voip/model/l:ABN	[B
    //   1414: ldc 243
    //   1416: new 425	java/lang/StringBuilder
    //   1419: dup
    //   1420: ldc_w 1146
    //   1423: invokespecial 430	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   1426: lload 8
    //   1428: invokevirtual 1012	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   1431: ldc_w 1148
    //   1434: invokevirtual 474	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1437: lload 10
    //   1439: invokevirtual 1012	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   1442: ldc_w 1148
    //   1445: invokevirtual 474	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1448: lload 6
    //   1450: invokevirtual 1012	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   1453: invokevirtual 437	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1456: invokestatic 387	com/tencent/mm/sdk/platformtools/ac:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   1459: ldc 243
    //   1461: ldc_w 1150
    //   1464: invokestatic 387	com/tencent/mm/sdk/platformtools/ac:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   1467: ldc_w 998
    //   1470: invokestatic 81	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   1473: iconst_0
    //   1474: ireturn
    //   1475: lload 14
    //   1477: lstore 6
    //   1479: goto -172 -> 1307
    //   1482: lload 16
    //   1484: lstore 10
    //   1486: goto -187 -> 1299
    //   1489: lload 18
    //   1491: lstore 8
    //   1493: goto -202 -> 1291
    //   1496: lload 6
    //   1498: lstore 20
    //   1500: goto -388 -> 1112
    //   1503: lload 10
    //   1505: lstore 22
    //   1507: lload 8
    //   1509: lstore 12
    //   1511: goto -1154 -> 357
    //   1514: lload 6
    //   1516: lstore 14
    //   1518: goto -1458 -> 60
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	1521	0	this	u
    //   0	1521	1	paramArrayOfByte	byte[]
    //   0	1521	2	paramInt	int
    //   0	1521	3	paramLong	long
    //   122	240	5	i	int
    //   126	1389	6	l1	long
    //   13	1495	8	l2	long
    //   16	1488	10	l3	long
    //   19	1491	12	l4	long
    //   58	1459	14	l5	long
    //   10	1473	16	l6	long
    //   7	1483	18	l7	long
    //   1110	389	20	l8	long
    //   355	1151	22	l9	long
    //   42	372	24	localObject1	Object
    //   530	5	24	localException	Exception
    //   549	26	24	str	String
    //   154	995	25	localObject2	Object
    //   411	62	26	localInteger	Integer
    //   425	96	27	localLong	Long
    // Exception table:
    //   from	to	target	type
    //   105	121	530	java/lang/Exception
    //   191	213	593	java/io/IOException
    //   647	669	810	java/io/IOException
    //   889	904	933	java/io/IOException
    //   1069	1088	1265	java/io/IOException
  }
  
  public final void b(Context paramContext, x paramx)
  {
    AppMethodBeat.i(208378);
    this.AEF.b(paramContext, paramx);
    AppMethodBeat.o(208378);
  }
  
  public final void b(boolean paramBoolean1, boolean paramBoolean2, String paramString)
  {
    AppMethodBeat.i(115115);
    ac.i("MicroMsg.Voip.VoipService", "setCalling " + paramBoolean1 + "  videoCall " + paramBoolean2 + "username " + paramString);
    this.cUz = paramBoolean1;
    if (paramBoolean2)
    {
      this.AEH = paramBoolean1;
      this.AEF.Ayh.ABJ.AGu = 0;
    }
    for (;;)
    {
      this.talker = paramString;
      this.AEF.Ayh.ABJ.AIf.ion = paramString;
      AppMethodBeat.o(115115);
      return;
      this.AEF.Ayh.ABJ.AGu = 1;
      this.AEI = paramBoolean1;
    }
  }
  
  public final boolean bVB()
  {
    AppMethodBeat.i(210537);
    boolean bool = this.AEF.bVB();
    AppMethodBeat.o(210537);
    return bool;
  }
  
  public final void bn(Context paramContext, String paramString)
  {
    AppMethodBeat.i(115117);
    ac.i("MicroMsg.Voip.VoipService", "startVoiceCall, toUser:".concat(String.valueOf(paramString)));
    if ((bs.isNullOrNil(paramString)) || ((System.currentTimeMillis() - this.AEK < 2000L) && (System.currentTimeMillis() - this.AEK > 0L)))
    {
      AppMethodBeat.o(115117);
      return;
    }
    if ((System.currentTimeMillis() - this.AEN < this.AEO) && (System.currentTimeMillis() - this.AEN > 0L))
    {
      ac.i("MicroMsg.Voip.VoipService", "fail! cuz overloadInterval fail!");
      com.tencent.mm.ui.base.h.a(paramContext, 2131764916, 2131764950, null);
      AppMethodBeat.o(115117);
      return;
    }
    this.AEK = System.currentTimeMillis();
    if (((com.tencent.mm.plugin.messenger.foundation.a.k)g.ab(com.tencent.mm.plugin.messenger.foundation.a.k.class)).awB().aNt(paramString) == null)
    {
      AppMethodBeat.o(115117);
      return;
    }
    a(paramContext, paramString, true, false, false);
    ejI();
    AppMethodBeat.o(115117);
  }
  
  public final void bo(Context paramContext, String paramString)
  {
    AppMethodBeat.i(115118);
    ac.i("MicroMsg.Voip.VoipService", "startVideoCall, toUser:".concat(String.valueOf(paramString)));
    if ((bs.isNullOrNil(paramString)) || ((System.currentTimeMillis() - this.AEK < 2000L) && (System.currentTimeMillis() - this.AEK > 0L)))
    {
      AppMethodBeat.o(115118);
      return;
    }
    if ((System.currentTimeMillis() - this.AEN < this.AEO) && (System.currentTimeMillis() - this.AEN > 0L))
    {
      ac.i("MicroMsg.Voip.VoipService", "fail! cuz overloadInterval fail!");
      com.tencent.mm.ui.base.h.a(paramContext, 2131764916, 2131764950, null);
      AppMethodBeat.o(115118);
      return;
    }
    this.AEK = System.currentTimeMillis();
    if (((com.tencent.mm.plugin.messenger.foundation.a.k)g.ab(com.tencent.mm.plugin.messenger.foundation.a.k.class)).awB().aNt(paramString) == null)
    {
      AppMethodBeat.o(115118);
      return;
    }
    a(paramContext, paramString, true, true, false);
    ejI();
    AppMethodBeat.o(115118);
  }
  
  public final int c(byte[] paramArrayOfByte, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    AppMethodBeat.i(208387);
    paramInt1 = this.AEF.c(paramArrayOfByte, paramInt1, paramInt2, paramInt3, paramInt4);
    AppMethodBeat.o(208387);
    return paramInt1;
  }
  
  public final void c(dsb paramdsb)
  {
    AppMethodBeat.i(115122);
    if (this.AEF.Ayh.ABJ.AIg != 0)
    {
      ac.i("MicroMsg.Voip.VoipService", "steve:[simucall]doTaskCallin simulcall already processed, return! VoipGetRoomInfoResp roomid:%d, roomType:%d, mProtocol.roomId:%d, iSimulCallStatus:%d ", new Object[] { Integer.valueOf(paramdsb.Exf), Integer.valueOf(paramdsb.FZh), Integer.valueOf(this.AEF.Ayh.ABJ.roomId), Integer.valueOf(this.AEF.Ayh.ABJ.AIg) });
      AppMethodBeat.o(115122);
      return;
    }
    int j = paramdsb.FZh;
    boolean bool = ((com.tencent.mm.plugin.expt.a.b)g.ab(com.tencent.mm.plugin.expt.a.b.class)).a(b.a.pSq, false);
    ac.i("MicroMsg.Voip.VoipService", "steve:[simucall]doTaskCallin bNewSimulCallSwitch:%b ", new Object[] { Boolean.valueOf(bool) });
    int i = -1;
    if (bool) {
      i = b(paramdsb);
    }
    if (i == 1)
    {
      this.AEF.a(paramdsb.Exf, paramdsb.Exg, 5, null, null, paramdsb.FZq);
      ac.i("MicroMsg.Voip.VoipService", "steve:[simucall]doTaskCallin simulcall caller send ack roomid:%d, finalRoomType:%d, orgRoomType:%d ", new Object[] { Integer.valueOf(paramdsb.Exf), Integer.valueOf(paramdsb.FZh), Integer.valueOf(j) });
      com.tencent.mm.plugin.report.service.h.wUl.a(11525, true, true, new Object[] { Integer.valueOf(paramdsb.Exf), Long.valueOf(paramdsb.Exg), Integer.valueOf(j), Integer.valueOf(6), Integer.valueOf(com.tencent.mm.plugin.voip.b.d.getNetType(ai.getContext())), Long.valueOf(System.currentTimeMillis()) });
      AppMethodBeat.o(115122);
      return;
    }
    if ((!com.tencent.mm.m.f.Zh()) && (!cK(ai.getContext())))
    {
      ac.i("MicroMsg.Voip.VoipService", "NotificationConfig.isNewVoipMsgNotification() is false and is not in foreground, now return.");
      if ((this.AEX == null) && (this.uXE.eVs()))
      {
        ac.i("MicroMsg.Voip.VoipService", "voipGetRoomInfoResp is null and time is stopped.");
        this.AEX = paramdsb;
        this.uXE.au(2000L, 2000L);
        this.AEY = System.currentTimeMillis();
        ac.i("MicroMsg.Voip.VoipService", "steve:voip roominfo stored!! roomid:%d, roomkey:%s, time:%d", new Object[] { Integer.valueOf(this.AEX.Exf), Long.valueOf(this.AEX.Exg), Integer.valueOf(this.AEX.CreateTime) });
        com.tencent.mm.plugin.report.service.h.wUl.idkeyStat(500L, 4L, 1L, false);
        com.tencent.mm.plugin.voip.b.d.SL(0);
      }
      AppMethodBeat.o(115122);
      return;
    }
    String str = paramdsb.FZq;
    Object localObject = com.tencent.mm.model.u.axw();
    i = paramdsb.FZh;
    ac.i("MicroMsg.Voip.VoipService", "doTaskCallin self:%s talker:%s type:%d roomid:%d, roomkey:%s, time:%d", new Object[] { localObject, str, Integer.valueOf(i), Integer.valueOf(paramdsb.Exf), Long.valueOf(paramdsb.Exg), Integer.valueOf(paramdsb.CreateTime) });
    if ((this.AEF.eil()) && (!this.AEF.AFp))
    {
      this.AEF.a(paramdsb.Exf, paramdsb.Exg, 2, null, null, str);
      ac.i("MicroMsg.Voip.VoipService", "doTaskCallin invite ignor because voip busy:roomid " + paramdsb.Exf);
      com.tencent.mm.plugin.report.service.h.wUl.a(11525, true, true, new Object[] { Integer.valueOf(paramdsb.Exf), Long.valueOf(paramdsb.Exg), Integer.valueOf(paramdsb.FZh), Integer.valueOf(2), Integer.valueOf(com.tencent.mm.plugin.voip.b.d.getNetType(ai.getContext())), Long.valueOf(System.currentTimeMillis()) });
      com.tencent.mm.plugin.report.service.h.wUl.a(11526, true, true, new Object[] { Integer.valueOf(com.tencent.mm.plugin.voip.c.ehb().AEF.Ayh.ABJ.roomId), Long.valueOf(com.tencent.mm.plugin.voip.c.ehb().AEF.Ayh.ABJ.tIG), Long.valueOf(com.tencent.mm.plugin.voip.c.ehb().AEF.Ayh.eim()), Integer.valueOf(7) });
      com.tencent.mm.plugin.voip.b.d.SL(0);
      AppMethodBeat.o(115122);
      return;
    }
    if (v.ekf())
    {
      this.AEF.a(paramdsb.Exf, paramdsb.Exg, 3, null, null, str);
      ac.e("MicroMsg.Voip.VoipService", "doTaskCallin invite ignor because telephone busy:roomid " + paramdsb.Exf);
      com.tencent.mm.plugin.report.service.h.wUl.a(11525, true, true, new Object[] { Integer.valueOf(paramdsb.Exf), Long.valueOf(paramdsb.Exg), Integer.valueOf(paramdsb.FZh), Integer.valueOf(3), Integer.valueOf(com.tencent.mm.plugin.voip.b.d.getNetType(ai.getContext())), Long.valueOf(System.currentTimeMillis()) });
      com.tencent.mm.plugin.report.service.h.wUl.a(11526, true, true, new Object[] { Integer.valueOf(com.tencent.mm.plugin.voip.c.ehb().AEF.Ayh.ABJ.roomId), Long.valueOf(com.tencent.mm.plugin.voip.c.ehb().AEF.Ayh.ABJ.tIG), Long.valueOf(com.tencent.mm.plugin.voip.c.ehb().AEF.Ayh.eim()), Integer.valueOf(7) });
      com.tencent.mm.plugin.voip.b.d.SL(0);
      AppMethodBeat.o(115122);
      return;
    }
    this.AEF.ekg();
    if (this.AEF.AFr)
    {
      if (this.AEF.Ayh.ABJ.roomId != paramdsb.Exf)
      {
        this.AEF.Ayh.ABj = true;
        this.AEF.Ayh.ABl = false;
        this.AEF.Ayh.ABk = false;
        this.AEF.Ayh.ABJ.AGU = 0;
        this.AEF.Ayh.ABJ.AGT = 0;
        this.AEF.Ayh.setStatus(3);
        this.AEF.Ayh.ABJ.roomId = paramdsb.Exf;
        this.AEF.Ayh.ABJ.tIG = paramdsb.Exg;
        this.AEF.Ayh.ABJ.tIN = 1;
        this.AEF.Ayh.ABK.Sa(i);
      }
      ac.i("MicroMsg.Voip.VoipService", "steve:[simucall]doTaskCallin simulcall auto-accept! mProtocol.roomId=%d, roomInfo.roomId=%d", new Object[] { Integer.valueOf(this.AEF.Ayh.ABJ.roomId), Integer.valueOf(paramdsb.Exf) });
      AppMethodBeat.o(115122);
      return;
    }
    if (!this.AEF.a(paramdsb))
    {
      ac.e("MicroMsg.Voip.VoipService", "doTaskCallin setInviteContent failed!");
      com.tencent.mm.plugin.report.service.h.wUl.a(11525, true, true, new Object[] { Integer.valueOf(paramdsb.Exf), Long.valueOf(paramdsb.Exg), Integer.valueOf(paramdsb.FZh), Integer.valueOf(5), Integer.valueOf(com.tencent.mm.plugin.voip.b.d.getNetType(ai.getContext())), Long.valueOf(System.currentTimeMillis()) });
      com.tencent.mm.plugin.report.service.h.wUl.a(11526, true, true, new Object[] { Integer.valueOf(com.tencent.mm.plugin.voip.c.ehb().AEF.Ayh.ABJ.roomId), Long.valueOf(com.tencent.mm.plugin.voip.c.ehb().AEF.Ayh.ABJ.tIG), Long.valueOf(com.tencent.mm.plugin.voip.c.ehb().AEF.Ayh.eim()), Integer.valueOf(7) });
      com.tencent.mm.plugin.voip.b.d.SL(0);
      AppMethodBeat.o(115122);
      return;
    }
    localObject = ai.getContext();
    if (((com.tencent.mm.plugin.messenger.foundation.a.k)g.ab(com.tencent.mm.plugin.messenger.foundation.a.k.class)).awB().aNt(str) == null)
    {
      this.AEF.a(paramdsb.Exf, paramdsb.Exg, 4, null, null, str);
      ac.d("MicroMsg.Voip.VoipService", "doTaskCallin invite ignor because talker nil:roomid " + paramdsb.Exf);
      com.tencent.mm.plugin.report.service.h.wUl.a(11525, true, true, new Object[] { Integer.valueOf(paramdsb.Exf), Long.valueOf(paramdsb.Exg), Integer.valueOf(paramdsb.FZh), Integer.valueOf(4), Integer.valueOf(com.tencent.mm.plugin.voip.b.d.getNetType(ai.getContext())), Long.valueOf(System.currentTimeMillis()) });
      com.tencent.mm.plugin.report.service.h.wUl.a(11526, true, true, new Object[] { Integer.valueOf(com.tencent.mm.plugin.voip.c.ehb().AEF.Ayh.ABJ.roomId), Long.valueOf(com.tencent.mm.plugin.voip.c.ehb().AEF.Ayh.ABJ.tIG), Long.valueOf(com.tencent.mm.plugin.voip.c.ehb().AEF.Ayh.eim()), Integer.valueOf(7) });
      com.tencent.mm.plugin.voip.b.d.SL(0);
      AppMethodBeat.o(115122);
      return;
    }
    if ((1 == i) || (i == 0)) {
      if (i != 0) {
        break label1808;
      }
    }
    for (bool = true;; bool = false)
    {
      try
      {
        a((Context)localObject, str, false, bool, true);
        if (this.AEF != null) {
          this.AEF.Sz(paramdsb.Exf);
        }
        ac.d("MicroMsg.Voip.VoipService", "doTaskCallin invite startActivity VideoActivity");
      }
      catch (Exception localException)
      {
        for (;;)
        {
          label1808:
          com.tencent.mm.plugin.voip.b.d.SL(2);
        }
      }
      this.AEF.a(paramdsb.Exf, paramdsb.Exg, 1, this.AEF.Ayh.ABJ.field_peerId, this.AEF.Ayh.ABJ.field_capInfo, str);
      com.tencent.mm.plugin.report.service.h.wUl.a(11525, true, true, new Object[] { Integer.valueOf(paramdsb.Exf), Long.valueOf(paramdsb.Exg), Integer.valueOf(paramdsb.FZh), Integer.valueOf(1), Integer.valueOf(com.tencent.mm.plugin.voip.b.d.getNetType(ai.getContext())), Long.valueOf(System.currentTimeMillis()) });
      AppMethodBeat.o(115122);
      return;
    }
  }
  
  public final void dfW()
  {
    AppMethodBeat.i(162308);
    this.AEP = null;
    ((com.tencent.mm.plugin.notification.b.a)g.ad(com.tencent.mm.plugin.notification.b.a.class)).getNotification().cancel(41);
    AppMethodBeat.o(162308);
  }
  
  public final long eim()
  {
    AppMethodBeat.i(210535);
    long l = this.AEF.Ayh.eim();
    AppMethodBeat.o(210535);
    return l;
  }
  
  public final int ejJ()
  {
    AppMethodBeat.i(208381);
    this.AEF.ejJ();
    AppMethodBeat.o(208381);
    return 0;
  }
  
  public final int ejK()
  {
    AppMethodBeat.i(208382);
    this.AEF.ejK();
    AppMethodBeat.o(208382);
    return 0;
  }
  
  public final int ejL()
  {
    return this.AEF.Ayh.ABJ.roomId;
  }
  
  public final long ejM()
  {
    return this.AEF.Ayh.ABJ.tIG;
  }
  
  public final void ejN()
  {
    AppMethodBeat.i(208384);
    n localn = this.AEF.Ayh.ABL;
    if (localn.osJ != null) {
      localn.osJ.cu(true);
    }
    AppMethodBeat.o(208384);
  }
  
  public final void ejO()
  {
    AppMethodBeat.i(208385);
    n localn = this.AEF.Ayh.ABL;
    if (localn.osJ != null) {
      localn.osJ.cu(false);
    }
    AppMethodBeat.o(208385);
  }
  
  public final void ejP()
  {
    AppMethodBeat.i(115135);
    ac.d("MicroMsg.Voip.VoipService", "devin: setCallResult: %d", new Object[] { Integer.valueOf(1) });
    this.AEF.Ayh.ABJ.AIf.ADd = 1;
    AppMethodBeat.o(115135);
  }
  
  public final int ejQ()
  {
    return this.AEF.Ayh.ABL.Ayh.ABJ.field_sendVideoLen;
  }
  
  public final int ejR()
  {
    return this.AEF.Ayh.ABL.Ayh.ABJ.field_recvVideoLen;
  }
  
  public final byte[] ejS()
  {
    return this.AEF.Ayh.ABJ.AHz;
  }
  
  public final boolean ejT()
  {
    bool2 = false;
    AppMethodBeat.i(115143);
    bool1 = bool2;
    try
    {
      if (this.AEF.Ayh.ABJ != null)
      {
        int i = this.AEF.Ayh.ABJ.AGZ;
        bool1 = bool2;
        if ((i & 0x8) != 0) {
          bool1 = true;
        }
      }
    }
    catch (Exception localException)
    {
      for (;;)
      {
        ac.e("MicroMsg.Voip.VoipService", "steve:cannot get CPU usage! error: " + localException.getMessage());
        bool1 = bool2;
      }
    }
    AppMethodBeat.o(115143);
    return bool1;
  }
  
  public final void ejV()
  {
    AppMethodBeat.i(208392);
    this.AEG = null;
    this.AEQ = null;
    this.AER = false;
    this.AET = false;
    this.AES = false;
    this.AEZ = false;
    com.tencent.mm.plugin.voip.c.ehc().qD(true);
    AppMethodBeat.o(208392);
  }
  
  public final void ejW()
  {
    AppMethodBeat.i(115149);
    this.AEF.AFw.au(1000L, 1000L);
    AppMethodBeat.o(115149);
  }
  
  public final int ejX()
  {
    return this.AEF.Ayh.ABJ.AGt;
  }
  
  public final void ejY()
  {
    AppMethodBeat.i(115152);
    this.AEF.Ayh.ABL.eiH();
    AppMethodBeat.o(115152);
  }
  
  public final boolean ejZ()
  {
    AppMethodBeat.i(208395);
    boolean bool = this.AEF.Ayh.ABX.ejG();
    AppMethodBeat.o(208395);
    return bool;
  }
  
  public final void eka()
  {
    AppMethodBeat.i(208396);
    this.AEF.Ayh.ABX = new VoipScoreState();
    AppMethodBeat.o(208396);
  }
  
  public final VoipScoreState ekb()
  {
    return this.AEF.Ayh.ABX;
  }
  
  protected final void finalize()
  {
    AppMethodBeat.i(115114);
    this.AEF.stop();
    this.AEF = null;
    this.AEJ = false;
    g.agQ().b(this.zVK);
    super.finalize();
    AppMethodBeat.o(115114);
  }
  
  public final void i(String paramString, boolean paramBoolean1, boolean paramBoolean2)
  {
    AppMethodBeat.i(115145);
    ac.m("MicroMsg.Voip.VoipService", "bindVoipForegroundIfNeed", new Object[0]);
    if ((com.tencent.mm.compatible.util.d.kZ(26)) && (!this.AEW))
    {
      localObject = q.ADO;
      q.eiS();
      localObject = new Intent();
      ((Intent)localObject).putExtra("isRecalled", paramBoolean2);
      ((Intent)localObject).putExtra("Voip_User", paramString);
      ((Intent)localObject).putExtra("Voip_VideoCall", paramBoolean1);
      ((Intent)localObject).setClass(ai.getContext(), VoipForegroundService.class);
    }
    try
    {
      ai.getContext().startService((Intent)localObject);
      i = 1;
    }
    catch (Exception paramString)
    {
      for (;;)
      {
        int i;
        ac.printErrStackTrace("MicroMsg.Voip.VoipService", paramString, "using start service to bindVoipForegroundIfNeed error: %s", new Object[] { paramString.getMessage() });
        try
        {
          ai.getContext().startForegroundService((Intent)localObject);
          paramString = q.ADO;
          q.eiU();
          i = 0;
        }
        catch (Exception paramString)
        {
          ac.printErrStackTrace("MicroMsg.Voip.VoipService", paramString, "using start foreground service to bindVoipForegroundIfNeed error: %s", new Object[] { paramString.getMessage() });
          i = 0;
        }
      }
    }
    if (i != 0)
    {
      this.AEW = true;
      paramString = q.ADO;
      q.eiT();
    }
    AppMethodBeat.o(115145);
  }
  
  public final int jdMethod_if(int paramInt1, int paramInt2)
  {
    n localn = this.AEF.Ayh.ABL;
    localn.Ayh.ABJ.AHx = paramInt1;
    localn.Ayh.ABJ.AHy = paramInt2;
    return 0;
  }
  
  public final void op(boolean paramBoolean)
  {
    AppMethodBeat.i(115153);
    ac.m("MicroMsg.Voip.VoipService", "setEngineHeadsetPlugged, %s", new Object[] { Boolean.valueOf(paramBoolean) });
    byte[] arrayOfByte = new byte[1];
    if (paramBoolean) {}
    for (int i = 1;; i = 0)
    {
      arrayOfByte[0] = ((byte)i);
      this.AEF.Ayh.ABJ.setAppCmd(425, arrayOfByte, 1);
      if (!paramBoolean) {
        break;
      }
      if (com.tencent.mm.plugin.audio.c.a.bCs()) {
        this.AEF.Ayh.ABJ.setAppCmd(441, arrayOfByte, 1);
      }
      if (!com.tencent.mm.plugin.audio.c.a.bCy()) {
        break label163;
      }
      this.AEF.Ayh.ABJ.setAppCmd(442, arrayOfByte, 1);
      AppMethodBeat.o(115153);
      return;
    }
    this.AEF.Ayh.ABJ.setAppCmd(441, arrayOfByte, 1);
    this.AEF.Ayh.ABJ.setAppCmd(442, arrayOfByte, 1);
    label163:
    AppMethodBeat.o(115153);
  }
  
  public final int sD(boolean paramBoolean)
  {
    AppMethodBeat.i(115138);
    l locall = this.AEF.Ayh;
    if (paramBoolean) {}
    for (int i = locall.ABJ.setAppCmd(412);; i = locall.ABJ.setAppCmd(413))
    {
      if (i < 0) {
        com.tencent.mm.plugin.voip.b.d.Loge("MicroMsg.Voip.VoipContext", "voipContext tryMuteMicrophone ret:".concat(String.valueOf(i)));
      }
      AppMethodBeat.o(115138);
      return i;
    }
  }
  
  public final int sE(boolean paramBoolean)
  {
    AppMethodBeat.i(115139);
    l locall = this.AEF.Ayh;
    if (paramBoolean) {}
    for (int i = locall.ABJ.setAppCmd(401);; i = locall.ABJ.setAppCmd(402))
    {
      if (i < 0) {
        com.tencent.mm.plugin.voip.b.d.Logi("MicroMsg.Voip.VoipContext", "voipContext trySwitchSpeakerPhone ret:".concat(String.valueOf(i)));
      }
      AppMethodBeat.o(115139);
      return i;
    }
  }
  
  public final void sF(boolean paramBoolean)
  {
    AppMethodBeat.i(208391);
    v localv = this.AEF;
    if (localv.oue != null) {
      localv.oue.sX(paramBoolean);
    }
    AppMethodBeat.o(208391);
  }
  
  public final boolean ss(boolean paramBoolean)
  {
    AppMethodBeat.i(115137);
    n localn = this.AEF.Ayh.ABL;
    if (localn.ACs != null)
    {
      paramBoolean = localn.ACs.ss(paramBoolean);
      AppMethodBeat.o(115137);
      return paramBoolean;
    }
    AppMethodBeat.o(115137);
    return false;
  }
  
  public final void stopRing()
  {
    AppMethodBeat.i(210536);
    this.AEF.stopRing();
    AppMethodBeat.o(210536);
  }
  
  public final class a
  {
    dsb AFc;
    boolean cancelled;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.voip.model.u
 * JD-Core Version:    0.7.0.1
 */