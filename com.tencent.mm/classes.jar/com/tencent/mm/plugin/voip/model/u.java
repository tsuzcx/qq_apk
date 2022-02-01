package com.tencent.mm.plugin.voip.model;

import android.app.ActivityManager;
import android.app.ActivityManager.RunningTaskInfo;
import android.app.KeyguardManager;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Point;
import android.os.Build.VERSION;
import android.os.Looper;
import android.widget.RemoteViews;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.app.AppForegroundDelegate;
import com.tencent.mm.b.f;
import com.tencent.mm.f.a.aaq;
import com.tencent.mm.f.a.lm;
import com.tencent.mm.f.c.ax;
import com.tencent.mm.model.aa;
import com.tencent.mm.model.ay;
import com.tencent.mm.model.z;
import com.tencent.mm.n.g;
import com.tencent.mm.network.p;
import com.tencent.mm.plugin.expt.b.b.a;
import com.tencent.mm.plugin.voip.b.c;
import com.tencent.mm.plugin.voip.b.d;
import com.tencent.mm.plugin.voip.b.e;
import com.tencent.mm.plugin.voip.b.g;
import com.tencent.mm.plugin.voip.ui.VideoActivity;
import com.tencent.mm.plugin.voip.widget.VoipForegroundService;
import com.tencent.mm.protocal.protobuf.cpc;
import com.tencent.mm.protocal.protobuf.epx;
import com.tencent.mm.protocal.protobuf.ezo;
import com.tencent.mm.protocal.protobuf.fee;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.event.IEvent;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.sdk.platformtools.MTimerHandler;
import com.tencent.mm.sdk.platformtools.MTimerHandler.CallBack;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.bv;
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
  private static final f<Integer, p.a> jla;
  public MTimerHandler Fsy;
  private p MjF;
  public String NKK;
  public long NKx;
  public boolean NPA;
  List<a> NPB;
  public HashMap<Long, Boolean> NPC;
  public v NPf;
  public com.tencent.mm.plugin.voip.a NPg;
  public boolean NPh;
  public boolean NPi;
  public boolean NPj;
  public boolean NPk;
  private long NPl;
  public Map<Integer, Long> NPm;
  public int NPn;
  public long NPo;
  public long NPp;
  public volatile u.b NPq;
  private Point NPr;
  public boolean NPs;
  boolean NPt;
  boolean NPu;
  public boolean NPv;
  public boolean NPw;
  public boolean NPx;
  public fee NPy;
  public long NPz;
  public boolean fqP;
  private com.tencent.mm.plugin.misc.a.a.a lHE;
  private boolean tKK;
  public String talker;
  
  static
  {
    AppMethodBeat.i(115155);
    jla = new com.tencent.mm.memory.a.c(5);
    AppMethodBeat.o(115155);
  }
  
  public u()
  {
    AppMethodBeat.i(115113);
    this.fqP = false;
    this.NPh = false;
    this.NPi = false;
    this.NPj = false;
    this.NPk = false;
    this.talker = null;
    this.NPl = 0L;
    this.NPm = new HashMap();
    this.NPn = -1;
    this.NPo = 0L;
    this.NPp = 0L;
    this.NPs = false;
    this.NPt = false;
    this.NPu = false;
    this.NPv = false;
    this.NPw = false;
    this.tKK = false;
    this.NPx = true;
    this.NPy = null;
    this.NPz = 0L;
    this.NKK = null;
    this.NPA = false;
    this.NKx = 0L;
    this.MjF = new com.tencent.mm.network.p.a()
    {
      public final void onNetworkChange(int paramAnonymousInt)
      {
        AppMethodBeat.i(115109);
        Log.d("MicroMsg.Voip.VoipService", "network status change from ".concat(String.valueOf(paramAnonymousInt)));
        l locall;
        if ((u.a(u.this)) && (paramAnonymousInt == 4))
        {
          locall = u.this.NPf.NJk;
          if (locall.NMt == 0) {
            locall.NMt = locall.NMi.NQG;
          }
          paramAnonymousInt = com.tencent.mm.plugin.voip.c.e.getNetType(MMApplicationContext.getContext());
          if (paramAnonymousInt != locall.NMt) {
            com.tencent.mm.plugin.voip.c.e.Logi("MicroMsg.Voip.VoipContext", "steve: onVoipLocalNetTypeChange: local network type change from " + locall.NMt + " to " + paramAnonymousInt);
          }
        }
        try
        {
          byte[] arrayOfByte = new byte[4];
          arrayOfByte[0] = ((byte)paramAnonymousInt);
          int i = locall.NMi.setAppCmd(301, arrayOfByte, 4);
          if (i < 0) {
            com.tencent.mm.plugin.voip.c.e.Logi("MicroMsg.Voip.VoipContext", "steve:[ENGINE]IMVQQEngine::SetAppCmd[EMethodSetLocalNetType] update local network type" + paramAnonymousInt + "fail:" + i + ", [roomid=" + locall.NMi.DPQ + ", roomkey=" + locall.NMi.DPJ + "]");
          }
          ezo localezo = new ezo();
          localezo.UzP = 3;
          localezo.UzQ = new com.tencent.mm.cd.b(arrayOfByte, 0, 1);
          locall.NMi.SendRUDP(localezo.toByteArray(), localezo.toByteArray().length);
        }
        catch (Exception localException)
        {
          for (;;)
          {
            com.tencent.mm.plugin.voip.c.e.Logi("MicroMsg.Voip.VoipContext", "onVoipLocalNetTypeChange Error");
          }
        }
        locall.NMt = paramAnonymousInt;
        u.this.NPf.gAP();
        AppMethodBeat.o(115109);
      }
    };
    this.lHE = new com.tencent.mm.plugin.misc.a.a.a()
    {
      public final void dM(int paramAnonymousInt1, int paramAnonymousInt2)
      {
        AppMethodBeat.i(235927);
        Log.d("MicroMsg.Voip.VoipService", "simtype " + paramAnonymousInt1 + " reason " + paramAnonymousInt2);
        if ((paramAnonymousInt2 == 3) && (paramAnonymousInt1 == 1))
        {
          paramAnonymousInt1 = u.this.NPf.NJk.NMi.handleCommand(2, null, 0);
          if (paramAnonymousInt1 < 0) {
            com.tencent.mm.plugin.voip.c.e.Loge("MicroMsg.Voip.VoipService", "v2protocal handlecommand failed ret:".concat(String.valueOf(paramAnonymousInt1)));
          }
        }
        AppMethodBeat.o(235927);
      }
    };
    this.Fsy = new MTimerHandler(Looper.getMainLooper(), new MTimerHandler.CallBack()
    {
      public final boolean onTimerExpired()
      {
        AppMethodBeat.i(241322);
        Log.v("MicroMsg.Voip.VoipService", "voip repeat check is foreground");
        if (u.e(u.this) == null)
        {
          u.f(u.this);
          u.g(u.this).stopTimer();
          AppMethodBeat.o(241322);
          return false;
        }
        if (u.iG(MMApplicationContext.getContext()))
        {
          u.this.aZ(u.e(u.this).Svu, u.e(u.this).Svv);
          Log.i("MicroMsg.Voip.VoipService", "steve:voip callin in mRepeatCheckHandler, roomid:%d, roomkey:%s, time:%d", new Object[] { Integer.valueOf(u.e(u.this).Svu), Long.valueOf(u.e(u.this).Svv), Integer.valueOf(u.e(u.this).CreateTime) });
          u.this.c(u.e(u.this));
          u.h(u.this);
          u.f(u.this);
          u.g(u.this).stopTimer();
          com.tencent.mm.plugin.report.service.h.IzE.idkeyStat(500L, 5L, 1L, false);
          AppMethodBeat.o(241322);
          return false;
        }
        if (System.currentTimeMillis() - u.i(u.this) < 60000L)
        {
          AppMethodBeat.o(241322);
          return true;
        }
        u.h(u.this);
        u.f(u.this);
        u.g(u.this).stopTimer();
        AppMethodBeat.o(241322);
        return false;
      }
    }, true);
    this.NPB = null;
    this.NPC = new HashMap();
    this.NPf = new v();
    this.NKx = 0L;
    this.fqP = false;
    this.NPh = false;
    this.NPi = false;
    this.talker = null;
    this.NPk = false;
    this.NPj = false;
    this.NKK = null;
    com.tencent.mm.kernel.h.aHF().a(this.MjF);
    ((com.tencent.mm.plugin.misc.a.a)com.tencent.mm.kernel.h.ae(com.tencent.mm.plugin.misc.a.a.class)).a(this.lHE);
    AppMethodBeat.o(115113);
  }
  
  public static float AY(boolean paramBoolean)
  {
    AppMethodBeat.i(115148);
    float f1 = 0.7476636F;
    float f2 = f1;
    for (;;)
    {
      try
      {
        localObject = com.tencent.mm.plugin.voip.c.gxs();
        if (!paramBoolean) {
          continue;
        }
        f2 = f1;
        localObject = ((u)localObject).NPf.NJk.NMi.field_capInfo;
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
          Log.d("MicroMsg.Voip.VoipService", "use rate: %s, changed: %s", new Object[] { Float.valueOf(f1), Boolean.valueOf(paramBoolean) });
          f2 = f1;
        }
      }
      catch (Exception localException)
      {
        Object localObject;
        Log.e("MicroMsg.Voip.VoipService", "update failed: " + localException.getMessage());
        continue;
      }
      AppMethodBeat.o(115148);
      return f2;
      f2 = f1;
      localObject = ((u)localObject).NPf.NJk.NMi.NQK;
    }
  }
  
  private static byte[] aQ(Map<Integer, Long> paramMap)
  {
    AppMethodBeat.i(115126);
    epx localepx = new epx();
    LinkedList localLinkedList = new LinkedList();
    Iterator localIterator = paramMap.keySet().iterator();
    while (localIterator.hasNext())
    {
      Integer localInteger = (Integer)localIterator.next();
      cpc localcpc = new cpc();
      localcpc.IyZ = localInteger.intValue();
      localcpc.TwN = ((Long)paramMap.get(localInteger)).intValue();
      localLinkedList.push(localcpc);
    }
    localepx.Ukq = localLinkedList;
    localepx.Ukp = localLinkedList.size();
    try
    {
      paramMap = localepx.toByteArray();
      AppMethodBeat.o(115126);
      return paramMap;
    }
    catch (IOException paramMap)
    {
      Log.printErrStackTrace("MicroMsg.Voip.VoipService", paramMap, "", new Object[0]);
      AppMethodBeat.o(115126);
    }
    return null;
  }
  
  public static byte[] af(byte[] paramArrayOfByte, int paramInt)
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
  
  private int b(fee paramfee)
  {
    int j = -1;
    boolean bool1 = true;
    AppMethodBeat.i(115120);
    Object localObject = z.bcZ();
    String str2;
    int i;
    String str1;
    if (paramfee != null)
    {
      str2 = paramfee.UDO;
      k = paramfee.UDF;
      Log.i("MicroMsg.Voip.VoipService", "steve:[simucall] being called! roomid:%d, myname:%s, remoteInviteName:%s,myInviteName:%s, calltype:%d, working:%b, dialing:%b, isSimulCall:%b", new Object[] { Integer.valueOf(paramfee.Svu), localObject, str2, this.NPf.NPR, Integer.valueOf(k), Boolean.valueOf(this.NPf.gyH()), Boolean.valueOf(this.NPf.NJk.gyF()), Boolean.valueOf(this.NPf.NPO) });
      i = j;
      if (!this.NPf.gyH()) {
        break label628;
      }
      i = j;
      if (this.NPf.NJk == null) {
        break label628;
      }
      i = j;
      if (!this.NPf.NJk.gyF()) {
        break label628;
      }
      i = j;
      if (this.NPf.NPO) {
        break label628;
      }
      str1 = this.NPf.NPR;
      if ((str2 == null) || (str1 == null))
      {
        Log.e("MicroMsg.Voip.VoipService", "steve:[simucall] name null! myname:%s, remoteInviteName:%s, myInviteName:%s", new Object[] { localObject, str2, str1 });
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
    Log.i("MicroMsg.Voip.VoipService", "steve:[simucall]  mutualCalling:%s", new Object[] { Boolean.valueOf(bool2) });
    if (bool2)
    {
      this.NPf.NPO = true;
      i = str1.compareTo((String)localObject);
      boolean bool3 = str1.contains("@");
      if ((i < 0) || (bool3))
      {
        i = 1;
        localObject = this.NPf.NJk.NMi;
        ((v2protocal)localObject).NSJ |= 0x2;
        if (!this.NPg.gxl()) {
          break label662;
        }
        j = 0;
        label347:
        if ((k != 1) && (j != 1)) {
          break label722;
        }
      }
    }
    label662:
    label722:
    for (int k = 1;; k = 0)
    {
      if ((this.NPg.gxl()) && (k == 1))
      {
        Log.i("MicroMsg.Voip.VoipService", "steve:[simucall]audio room, close camera first! myInviteType:%d, finalRoomType:%d", new Object[] { Integer.valueOf(j), Integer.valueOf(k) });
        this.NPf.NPF = false;
        gAz();
        this.NPf.NJk.NMj.akA(1);
      }
      paramfee.UDF = k;
      this.NPf.NPP = k;
      Log.i("MicroMsg.Voip.VoipService", "steve:[simucall]myInviteName:%s, mutualCalling:%s,caller:%d,myInviteType:%d,finalType:%d", new Object[] { str1, Boolean.valueOf(bool2), Integer.valueOf(i), Integer.valueOf(j), Integer.valueOf(k) });
      if (i == 2)
      {
        Log.i("MicroMsg.Voip.VoipService", "steve:[simucall] i'm callee, cancel my previous invite!");
        this.NPf.NPQ = true;
        if ((this.NPf.NJk.NMi != null) && (this.NPf.NJk.NMi.roomId != 0) && (this.NPf.NJk.NMi.DPJ != 0L) && (this.NPf.NJk.NMi.roomId != paramfee.Svu)) {
          b(this.NPf.NJk.NMi.roomId, this.NPf.NJk.NMi.DPJ, j);
        }
        if (k == 0) {
          label619:
          this.NPg.AI(bool1);
        }
      }
      for (;;)
      {
        label628:
        if (this.NPf.NPO) {
          paramfee.UDF = this.NPf.NPP;
        }
        AppMethodBeat.o(115120);
        return i;
        i = 2;
        break;
        j = 1;
        break label347;
        bool1 = false;
        break label619;
        this.NPf.NPQ = false;
        Log.i("MicroMsg.Voip.VoipService", "steve:[simucall] i'm caller, do NOT answer others' invite!");
        continue;
        Log.i("MicroMsg.Voip.VoipService", "steve:[simucall] myInviteName:%s, mutualCalling:%s", new Object[] { str1, Boolean.valueOf(bool2) });
        i = j;
      }
    }
  }
  
  public static p.a bge(String paramString)
  {
    AppMethodBeat.i(115124);
    if ((paramString == null) || (paramString.length() == 0))
    {
      AppMethodBeat.o(115124);
      return null;
    }
    int i = paramString.hashCode();
    p.a locala = (p.a)jla.get(Integer.valueOf(i));
    if (locala != null)
    {
      AppMethodBeat.o(115124);
      return locala;
    }
    locala = new p.a();
    if (!locala.bgd(paramString))
    {
      AppMethodBeat.o(115124);
      return null;
    }
    jla.q(Integer.valueOf(i), locala);
    AppMethodBeat.o(115124);
    return locala;
  }
  
  private static Map<Integer, Long> cB(byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(115125);
    if (Util.isNullOrNil(paramArrayOfByte))
    {
      AppMethodBeat.o(115125);
      return null;
    }
    try
    {
      paramArrayOfByte = (epx)new epx().parseFrom(paramArrayOfByte);
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
    Log.d("MicroMsg.Voip.VoipService", "dkpush : keyCount:" + paramArrayOfByte.Ukp);
    LinkedList localLinkedList = paramArrayOfByte.Ukq;
    if (localLinkedList.size() != paramArrayOfByte.Ukp)
    {
      AppMethodBeat.o(115125);
      return null;
    }
    HashMap localHashMap = new HashMap();
    int i = 0;
    while (i < paramArrayOfByte.Ukp)
    {
      localHashMap.put(Integer.valueOf(((cpc)localLinkedList.get(i)).IyZ), Long.valueOf(0xFFFFFFFF & ((cpc)localLinkedList.get(i)).TwN));
      i += 1;
    }
    if (localHashMap.size() != paramArrayOfByte.Ukp)
    {
      AppMethodBeat.o(115125);
      return null;
    }
    AppMethodBeat.o(115125);
    return localHashMap;
  }
  
  private static String cC(byte[] paramArrayOfByte)
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
  
  private void gAA()
  {
    AppMethodBeat.i(115146);
    Log.printInfoStack("MicroMsg.Voip.VoipService", "unbindVoiceServiceIfNeed", new Object[0]);
    if (com.tencent.mm.compatible.util.d.qV(26)) {}
    try
    {
      Object localObject = new Intent();
      ((Intent)localObject).setClass(MMApplicationContext.getContext(), VoipForegroundService.class);
      MMApplicationContext.getContext().stopService((Intent)localObject);
      localObject = q.NOm;
      q.gzu();
      i = 1;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        Log.printErrStackTrace("MicroMsg.Voip.VoipService", localException, "unBind vidoeforeground error: %s", new Object[] { localException.getMessage() });
        int i = 0;
      }
    }
    if (i != 0) {
      this.tKK = false;
    }
    AppMethodBeat.o(115146);
  }
  
  public static boolean gAI()
  {
    if ((v2protocal.Fno >= 900) && (!v2protocal.Fnp))
    {
      v2protocal.Fnp = true;
      return true;
    }
    return false;
  }
  
  private static void gAf()
  {
    AppMethodBeat.i(115119);
    aaq localaaq = new aaq();
    localaaq.fZM.fDn = 7;
    EventCenter.instance.publish(localaaq);
    AppMethodBeat.o(115119);
  }
  
  public static boolean gAt()
  {
    return v2protocal.NQB;
  }
  
  public static boolean gAu()
  {
    return v2protocal.NQD;
  }
  
  private static boolean isAppOnForeground(Context paramContext)
  {
    AppMethodBeat.i(115150);
    Object localObject = ((ActivityManager)paramContext.getSystemService("activity")).getRunningTasks(1);
    if ((localObject != null) && (!((List)localObject).isEmpty()))
    {
      localObject = ((ActivityManager.RunningTaskInfo)((List)localObject).get(0)).topActivity;
      Log.d("MicroMsg.Voip.VoipService", "topActivity:" + ((ComponentName)localObject).flattenToString());
      if (!((ComponentName)localObject).getPackageName().equals(paramContext.getPackageName()))
      {
        Log.i("MicroMsg.Voip.VoipService", "is in backGround.");
        AppMethodBeat.o(115150);
        return false;
      }
    }
    if (((KeyguardManager)MMApplicationContext.getContext().getSystemService("keyguard")).inKeyguardRestrictedInputMode())
    {
      AppMethodBeat.o(115150);
      return false;
    }
    Log.i("MicroMsg.Voip.VoipService", "is in foreGround.");
    AppMethodBeat.o(115150);
    return true;
  }
  
  public final boolean AK(boolean paramBoolean)
  {
    AppMethodBeat.i(115137);
    n localn = this.NPf.NJk.NMk;
    if (localn.NMO != null)
    {
      paramBoolean = localn.NMO.AK(paramBoolean);
      AppMethodBeat.o(115137);
      return paramBoolean;
    }
    AppMethodBeat.o(115137);
    return false;
  }
  
  public final int AV(boolean paramBoolean)
  {
    AppMethodBeat.i(115138);
    l locall = this.NPf.NJk;
    if (paramBoolean) {}
    for (int i = locall.NMi.setAppCmd(412);; i = locall.NMi.setAppCmd(413))
    {
      if (i < 0) {
        com.tencent.mm.plugin.voip.c.e.Loge("MicroMsg.Voip.VoipContext", "voipContext tryMuteMicrophone ret:".concat(String.valueOf(i)));
      }
      AppMethodBeat.o(115138);
      return i;
    }
  }
  
  public final int AW(boolean paramBoolean)
  {
    AppMethodBeat.i(115139);
    l locall = this.NPf.NJk;
    if (paramBoolean) {}
    for (int i = locall.NMi.setAppCmd(401);; i = locall.NMi.setAppCmd(402))
    {
      if (i < 0) {
        com.tencent.mm.plugin.voip.c.e.Logi("MicroMsg.Voip.VoipContext", "voipContext trySwitchSpeakerPhone ret:".concat(String.valueOf(i)));
      }
      AppMethodBeat.o(115139);
      return i;
    }
  }
  
  public final void AX(boolean paramBoolean)
  {
    AppMethodBeat.i(237824);
    v localv = this.NPf;
    if (localv.tRS != null) {
      localv.tRS.Bo(paramBoolean);
    }
    AppMethodBeat.o(237824);
  }
  
  public final void K(int paramInt1, int paramInt2, boolean paramBoolean)
  {
    AppMethodBeat.i(237819);
    v localv = this.NPf;
    if ((localv.tRS != null) && (paramInt1 > 0)) {
      localv.tRS.M(paramInt1, paramInt2, paramBoolean);
    }
    AppMethodBeat.o(237819);
  }
  
  public final int a(byte[] paramArrayOfByte1, int paramInt1, int paramInt2, int paramInt3, int paramInt4, byte[] paramArrayOfByte2, int paramInt5, int paramInt6, int paramInt7, int paramInt8)
  {
    AppMethodBeat.i(237804);
    n localn = this.NPf.NJk.NMk;
    if (localn.tQu == n.tQt)
    {
      AppMethodBeat.o(237804);
      return -1;
    }
    if (!localn.NJk.NMi.gBo())
    {
      AppMethodBeat.o(237804);
      return -1;
    }
    if (!localn.NJk.gyN())
    {
      AppMethodBeat.o(237804);
      return -2;
    }
    paramInt1 = localn.NJk.NMi.videoRorate90D(paramArrayOfByte1, paramInt1, paramInt2, paramInt3, paramInt4, paramArrayOfByte2, paramInt5, paramInt6, paramInt7, paramInt8);
    AppMethodBeat.o(237804);
    return paramInt1;
  }
  
  public final int a(byte[] paramArrayOfByte, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int[] paramArrayOfInt, boolean paramBoolean)
  {
    AppMethodBeat.i(115136);
    n localn = this.NPf.NJk.NMk;
    int i;
    if (localn.tQu == n.tQt)
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
    if (!localn.NJk.NMi.gBo())
    {
      AppMethodBeat.o(115136);
      return -1;
    }
    paramInt1 = localn.NJk.NMi.videoEncodeToLocal(paramArrayOfByte, paramInt1, paramInt3, paramInt4, paramInt2, 0, 75, paramArrayOfInt);
    AppMethodBeat.o(115136);
    return paramInt1;
  }
  
  public final void a(Context paramContext, x paramx)
  {
    AppMethodBeat.i(237764);
    this.NPf.a(paramContext, paramx);
    AppMethodBeat.o(237764);
  }
  
  public final void a(Context paramContext, String paramString, long paramLong, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3)
  {
    AppMethodBeat.i(237828);
    if (paramContext == null) {
      paramContext = MMApplicationContext.getContext();
    }
    for (;;)
    {
      this.NPf.toUser = paramString;
      this.NPf.NPE = paramBoolean1;
      this.NPf.NPF = paramBoolean2;
      eXr();
      long l = System.currentTimeMillis();
      Object localObject1 = new lm();
      ((lm)localObject1).fJm.fJp = false;
      ((lm)localObject1).fJm.fJo = l;
      ((lm)localObject1).fJm.fJn = paramContext;
      EventCenter.instance.publish((IEvent)localObject1);
      Log.printInfoStack("MicroMsg.Voip.VoipService", "start VideoActivity in foreground,%s", new Object[] { Boolean.valueOf(AppForegroundDelegate.fby.cQt) });
      int i;
      Intent localIntent;
      Object localObject2;
      if ((com.tencent.mm.compatible.util.d.qX(28)) || (Build.VERSION.CODENAME.equals("Q")))
      {
        i = 1;
        String str = null;
        localIntent = new Intent(paramContext, VideoActivity.class);
        localIntent.putExtra("Voip_User", paramString);
        localIntent.putExtra("Voip_Outcall", paramBoolean1);
        localIntent.putExtra("Voip_VideoCall", paramBoolean2);
        localIntent.putExtra("Voip_LastPage_Hash", l);
        localIntent.putExtra("Voip_CallRoomKey", paramLong);
        Object localObject3 = "";
        localObject2 = str;
        localObject1 = localObject3;
        if (!paramBoolean1)
        {
          localObject2 = str;
          localObject1 = localObject3;
          if (i != 0)
          {
            localObject2 = str;
            localObject1 = localObject3;
            if (!AppForegroundDelegate.fby.cQt)
            {
              this.NPq = new u.b(this, paramBoolean2, paramString, paramBoolean3, paramLong);
              str = aa.PJ(((com.tencent.mm.plugin.messenger.foundation.a.n)com.tencent.mm.kernel.h.ae(com.tencent.mm.plugin.messenger.foundation.a.n.class)).bbL().RG(localIntent.getStringExtra("Voip_User")).field_username);
              localObject2 = new RemoteViews(MMApplicationContext.getPackageName(), b.e.voip_calling_notification);
              ((RemoteViews)localObject2).setTextViewText(b.d.notification_name, str);
              if (!localIntent.getBooleanExtra("Voip_VideoCall", true)) {
                break label509;
              }
              localObject1 = MMApplicationContext.getResources().getString(b.g.voip_invited_video_tip);
              ((RemoteViews)localObject2).setTextViewText(b.d.notification_type, (CharSequence)localObject1);
              ((RemoteViews)localObject2).setImageViewResource(b.d.notification_icon, b.c.video_call);
              label381:
              localObject3 = com.tencent.mm.am.d.a(paramString, false, 6, null);
              ((RemoteViews)localObject2).setImageViewBitmap(b.d.notification_avatar, (Bitmap)localObject3);
              ((RemoteViews)localObject2).setImageViewResource(b.d.wechat_icon, b.c.wechat_appicon);
              localObject1 = str + (String)localObject1;
            }
          }
        }
        if (paramBoolean3)
        {
          localIntent.setFlags(603979776);
          localIntent.addFlags(268435456);
        }
        if (localObject2 != null) {
          break label544;
        }
        e(paramString, paramBoolean2, paramLong);
        paramString = com.tencent.mm.plugin.voip.c.d.NXJ;
        com.tencent.mm.plugin.voip.c.d.gCt();
      }
      for (;;)
      {
        com.tencent.mm.util.a.a(paramContext, localIntent, (RemoteViews)localObject2, (String)localObject1, VideoActivity.class.getCanonicalName(), com.tencent.mm.bx.a.hfu());
        AppMethodBeat.o(237828);
        return;
        i = 0;
        break;
        label509:
        localObject1 = MMApplicationContext.getResources().getString(b.g.voip_invited_audio_tip);
        ((RemoteViews)localObject2).setTextViewText(b.d.notification_type, (CharSequence)localObject1);
        ((RemoteViews)localObject2).setImageViewResource(b.d.notification_icon, b.c.voice_call);
        break label381;
        label544:
        paramString = com.tencent.mm.plugin.voip.c.d.NXJ;
        com.tencent.mm.plugin.voip.c.d.gCs();
      }
    }
  }
  
  public final void aS(boolean paramBoolean1, boolean paramBoolean2)
  {
    AppMethodBeat.i(115116);
    this.NPv = paramBoolean1;
    this.NPw = paramBoolean2;
    Log.d("MicroMsg.Voip.VoipService", "isMinimize: %b, miniOnlyHideVoip: %b", new Object[] { Boolean.valueOf(paramBoolean1), Boolean.valueOf(paramBoolean2) });
    AppMethodBeat.o(115116);
  }
  
  public final int aT(boolean paramBoolean1, boolean paramBoolean2)
  {
    AppMethodBeat.i(115129);
    int i = this.NPf.aT(paramBoolean1, paramBoolean2);
    AppMethodBeat.o(115129);
    return i;
  }
  
  public final void aZ(final int paramInt, final long paramLong)
  {
    AppMethodBeat.i(115121);
    MMHandlerThread.postToMainThread(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(234908);
        Log.i("MicroMsg.Voip.VoipService", "onDelayInvite, roomId:%s, roomKey:%s", new Object[] { Integer.valueOf(paramInt), Long.valueOf(paramLong) });
        if ((!g.awi()) && (!u.iG(MMApplicationContext.getContext())))
        {
          Log.i("MicroMsg.Voip.VoipService", "background now and notification Is closed.");
          AppMethodBeat.o(234908);
          return;
        }
        if (u.this.NPf.gAK())
        {
          Log.i("MicroMsg.Voip.VoipService", "room is ready, ingore the msg and ack busy");
          if ((u.this.NPf.NJk.NMi.roomId != paramInt) && (u.this.NPf.NJk.NMi.DPJ != paramLong))
          {
            Log.i("MicroMsg.Voip.VoipService", "not match current room id and roomkey: %s %s %s %s", new Object[] { Integer.valueOf(paramInt), Long.valueOf(paramLong), Integer.valueOf(u.this.NPf.NJk.NMi.roomId), Long.valueOf(u.this.NPf.NJk.NMi.DPJ) });
            u.this.NPf.a(paramInt, paramLong, 2, null, null, u.b(u.this));
          }
          AppMethodBeat.o(234908);
          return;
        }
        new com.tencent.mm.plugin.voip.model.a.e(paramInt, paramLong, "").gAX();
        Log.i("MicroMsg.Voip.VoipService", "onDelayInvite, send getroominfo cgi done! roomId:%d, roomKey:%s", new Object[] { Integer.valueOf(paramInt), Long.valueOf(paramLong) });
        if (!u.c(u.this))
        {
          com.tencent.mm.plugin.voip.c.e.c(paramInt, paramLong, 1, 2);
          u.d(u.this);
        }
        AppMethodBeat.o(234908);
      }
    });
    AppMethodBeat.o(115121);
  }
  
  public final void akP(int paramInt)
  {
    AppMethodBeat.i(115130);
    this.NPf.akP(paramInt);
    AppMethodBeat.o(115130);
  }
  
  public final boolean akQ(int paramInt)
  {
    AppMethodBeat.i(237818);
    boolean bool = this.NPf.akQ(paramInt);
    AppMethodBeat.o(237818);
    return bool;
  }
  
  public final void akS(int paramInt)
  {
    AppMethodBeat.i(115151);
    this.NPf.NJk.akS(paramInt);
    AppMethodBeat.o(115151);
  }
  
  public final void akX(int paramInt)
  {
    AppMethodBeat.i(115134);
    Log.d("MicroMsg.Voip.VoipService", "devin: camera errcode: %d", new Object[] { Integer.valueOf(paramInt) });
    this.NPf.akX(paramInt);
    AppMethodBeat.o(115134);
  }
  
  public final void akY(int paramInt)
  {
    AppMethodBeat.i(237821);
    this.NPf.akY(paramInt);
    AppMethodBeat.o(237821);
  }
  
  public final void akZ(int paramInt)
  {
    AppMethodBeat.i(237833);
    k localk = k.NLD;
    k.a(this.NPf.NJk.NMi, paramInt);
    this.NPf.NJk.NMi.gBf();
    AppMethodBeat.o(237833);
  }
  
  public final void ala(int paramInt)
  {
    AppMethodBeat.i(237835);
    this.NPf.ala(paramInt);
    AppMethodBeat.o(237835);
  }
  
  public final int b(int paramInt1, long paramLong, int paramInt2)
  {
    AppMethodBeat.i(115132);
    paramInt1 = this.NPf.c(paramInt1, paramLong, paramInt2);
    AppMethodBeat.o(115132);
    return paramInt1;
  }
  
  /* Error */
  public final int b(byte[] paramArrayOfByte, int paramInt, long paramLong)
  {
    // Byte code:
    //   0: ldc_w 1098
    //   3: invokestatic 81	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
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
    //   21: ldc 251
    //   23: ldc_w 1100
    //   26: invokestatic 474	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   29: aload_0
    //   30: getfield 175	com/tencent/mm/plugin/voip/model/u:NPf	Lcom/tencent/mm/plugin/voip/model/v;
    //   33: getfield 211	com/tencent/mm/plugin/voip/model/v:NJk	Lcom/tencent/mm/plugin/voip/model/l;
    //   36: getfield 1103	com/tencent/mm/plugin/voip/model/l:NMm	[B
    //   39: invokestatic 1105	com/tencent/mm/plugin/voip/model/u:cB	([B)Ljava/util/Map;
    //   42: astore 24
    //   44: aload 24
    //   46: ifnonnull +331 -> 377
    //   49: ldc 251
    //   51: ldc_w 1107
    //   54: invokestatic 474	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   57: lconst_0
    //   58: lstore 14
    //   60: ldc 251
    //   62: new 275	java/lang/StringBuilder
    //   65: dup
    //   66: ldc_w 1109
    //   69: invokespecial 280	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   72: lload 18
    //   74: invokevirtual 1112	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   77: ldc_w 1114
    //   80: invokevirtual 288	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   83: lload 16
    //   85: invokevirtual 1112	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   88: ldc_w 1116
    //   91: invokevirtual 288	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   94: lload 14
    //   96: invokevirtual 1112	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   99: invokevirtual 291	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   102: invokestatic 474	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   105: new 1118	com/tencent/mm/protocal/protobuf/fea
    //   108: dup
    //   109: invokespecial 1119	com/tencent/mm/protocal/protobuf/fea:<init>	()V
    //   112: aload_1
    //   113: invokevirtual 1120	com/tencent/mm/protocal/protobuf/fea:parseFrom	([B)Lcom/tencent/mm/cd/a;
    //   116: checkcast 1118	com/tencent/mm/protocal/protobuf/fea
    //   119: astore 24
    //   121: iconst_0
    //   122: istore 5
    //   124: lload 12
    //   126: lstore 6
    //   128: iload 5
    //   130: aload 24
    //   132: getfield 1123	com/tencent/mm/protocal/protobuf/fea:UDH	Ljava/util/LinkedList;
    //   135: invokevirtual 361	java/util/LinkedList:size	()I
    //   138: if_icmpge +1156 -> 1294
    //   141: aload 24
    //   143: getfield 1123	com/tencent/mm/protocal/protobuf/fea:UDH	Ljava/util/LinkedList;
    //   146: iload 5
    //   148: invokevirtual 542	java/util/LinkedList:get	(I)Ljava/lang/Object;
    //   151: checkcast 1125	com/tencent/mm/protocal/protobuf/fdz
    //   154: astore 25
    //   156: ldc 251
    //   158: new 275	java/lang/StringBuilder
    //   161: dup
    //   162: ldc_w 1127
    //   165: invokespecial 280	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   168: aload 25
    //   170: getfield 1130	com/tencent/mm/protocal/protobuf/fdz:SnG	I
    //   173: invokevirtual 537	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   176: invokevirtual 291	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   179: invokestatic 474	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   182: aload 25
    //   184: getfield 1130	com/tencent/mm/protocal/protobuf/fdz:SnG	I
    //   187: iconst_1
    //   188: if_icmpne +452 -> 640
    //   191: new 1132	com/tencent/mm/protocal/protobuf/ffg
    //   194: dup
    //   195: invokespecial 1133	com/tencent/mm/protocal/protobuf/ffg:<init>	()V
    //   198: aload 25
    //   200: getfield 1137	com/tencent/mm/protocal/protobuf/fdz:RNM	Lcom/tencent/mm/protocal/protobuf/eae;
    //   203: getfield 1143	com/tencent/mm/protocal/protobuf/eae:Tkb	Lcom/tencent/mm/cd/b;
    //   206: getfield 1148	com/tencent/mm/cd/b:UH	[B
    //   209: invokevirtual 1149	com/tencent/mm/protocal/protobuf/ffg:parseFrom	([B)Lcom/tencent/mm/cd/a;
    //   212: checkcast 1132	com/tencent/mm/protocal/protobuf/ffg
    //   215: astore_1
    //   216: aload_1
    //   217: ifnull +404 -> 621
    //   220: ldc 251
    //   222: new 275	java/lang/StringBuilder
    //   225: dup
    //   226: ldc_w 1151
    //   229: invokespecial 280	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   232: aload_1
    //   233: getfield 1154	com/tencent/mm/protocal/protobuf/ffg:rVU	I
    //   236: invokevirtual 537	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   239: invokevirtual 291	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   242: invokestatic 474	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   245: lload 8
    //   247: lstore 12
    //   249: lload 8
    //   251: aload 25
    //   253: getfield 1155	com/tencent/mm/protocal/protobuf/fdz:IyZ	I
    //   256: i2l
    //   257: lcmp
    //   258: ifge +11 -> 269
    //   261: aload 25
    //   263: getfield 1155	com/tencent/mm/protocal/protobuf/fdz:IyZ	I
    //   266: i2l
    //   267: lstore 12
    //   269: lload 12
    //   271: lstore 8
    //   273: aload 25
    //   275: getfield 1155	com/tencent/mm/protocal/protobuf/fdz:IyZ	I
    //   278: i2l
    //   279: lload 18
    //   281: lcmp
    //   282: ifle +347 -> 629
    //   285: ldc 251
    //   287: new 275	java/lang/StringBuilder
    //   290: dup
    //   291: ldc_w 1157
    //   294: invokespecial 280	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   297: aload 25
    //   299: getfield 1155	com/tencent/mm/protocal/protobuf/fdz:IyZ	I
    //   302: invokevirtual 537	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   305: ldc_w 1159
    //   308: invokevirtual 288	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   311: lload 18
    //   313: invokevirtual 1112	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   316: ldc_w 1161
    //   319: invokevirtual 288	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   322: aload_1
    //   323: getfield 1154	com/tencent/mm/protocal/protobuf/ffg:rVU	I
    //   326: invokevirtual 537	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   329: ldc_w 1163
    //   332: invokevirtual 288	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   335: invokevirtual 291	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   338: invokestatic 474	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   341: aload_0
    //   342: getfield 175	com/tencent/mm/plugin/voip/model/u:NPf	Lcom/tencent/mm/plugin/voip/model/v;
    //   345: getfield 211	com/tencent/mm/plugin/voip/model/v:NJk	Lcom/tencent/mm/plugin/voip/model/l;
    //   348: getfield 1167	com/tencent/mm/plugin/voip/model/l:NMl	Lcom/tencent/mm/plugin/voip/model/w;
    //   351: aload_1
    //   352: iconst_1
    //   353: invokevirtual 1172	com/tencent/mm/plugin/voip/model/w:a	(Lcom/tencent/mm/protocal/protobuf/ffg;I)V
    //   356: lload 10
    //   358: lstore 22
    //   360: iload 5
    //   362: iconst_1
    //   363: iadd
    //   364: istore 5
    //   366: lload 22
    //   368: lstore 10
    //   370: lload 12
    //   372: lstore 8
    //   374: goto -246 -> 128
    //   377: aload 24
    //   379: invokeinterface 313 1 0
    //   384: invokeinterface 319 1 0
    //   389: astore 25
    //   391: lconst_0
    //   392: lstore 6
    //   394: aload 25
    //   396: invokeinterface 325 1 0
    //   401: ifeq +1124 -> 1525
    //   404: aload 25
    //   406: invokeinterface 329 1 0
    //   411: checkcast 331	java/lang/Integer
    //   414: astore 26
    //   416: aload 24
    //   418: aload 26
    //   420: invokeinterface 344 2 0
    //   425: checkcast 346	java/lang/Long
    //   428: astore 27
    //   430: aload 26
    //   432: invokevirtual 337	java/lang/Integer:intValue	()I
    //   435: tableswitch	default:+25 -> 460, 1:+65->500, 2:+75->510, 3:+85->520
    //   461: <illegal opcode>
    //   462: new 275	java/lang/StringBuilder
    //   465: dup
    //   466: ldc_w 1174
    //   469: invokespecial 280	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   472: aload 26
    //   474: invokevirtual 337	java/lang/Integer:intValue	()I
    //   477: invokevirtual 537	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   480: ldc_w 1176
    //   483: invokevirtual 288	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   486: aload 27
    //   488: invokevirtual 1179	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   491: invokevirtual 291	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   494: invokestatic 474	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   497: goto -103 -> 394
    //   500: aload 27
    //   502: invokevirtual 1182	java/lang/Long:longValue	()J
    //   505: lstore 18
    //   507: goto -113 -> 394
    //   510: aload 27
    //   512: invokevirtual 1182	java/lang/Long:longValue	()J
    //   515: lstore 16
    //   517: goto -123 -> 394
    //   520: aload 27
    //   522: invokevirtual 1182	java/lang/Long:longValue	()J
    //   525: lstore 6
    //   527: goto -133 -> 394
    //   530: astore 24
    //   532: ldc 251
    //   534: aload 24
    //   536: ldc_w 370
    //   539: iconst_0
    //   540: anewarray 4	java/lang/Object
    //   543: invokestatic 374	com/tencent/mm/sdk/platformtools/Log:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   546: aload_1
    //   547: invokestatic 1184	com/tencent/mm/plugin/voip/model/u:cC	([B)Ljava/lang/String;
    //   550: astore 24
    //   552: ldc 251
    //   554: new 275	java/lang/StringBuilder
    //   557: dup
    //   558: ldc_w 1186
    //   561: invokespecial 280	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   564: aload_1
    //   565: arraylength
    //   566: invokevirtual 537	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   569: ldc_w 1188
    //   572: invokevirtual 288	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   575: aload 24
    //   577: invokevirtual 288	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   580: invokevirtual 291	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   583: invokestatic 474	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   586: ldc_w 1098
    //   589: invokestatic 91	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   592: iconst_0
    //   593: ireturn
    //   594: astore_1
    //   595: ldc 251
    //   597: ldc_w 1190
    //   600: invokestatic 474	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   603: ldc 251
    //   605: aload_1
    //   606: ldc_w 370
    //   609: iconst_0
    //   610: anewarray 4	java/lang/Object
    //   613: invokestatic 374	com/tencent/mm/sdk/platformtools/Log:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   616: aconst_null
    //   617: astore_1
    //   618: goto -402 -> 216
    //   621: ldc 251
    //   623: ldc_w 1190
    //   626: invokestatic 474	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   629: lload 10
    //   631: lstore 22
    //   633: lload 8
    //   635: lstore 12
    //   637: goto -277 -> 360
    //   640: aload 25
    //   642: getfield 1130	com/tencent/mm/protocal/protobuf/fdz:SnG	I
    //   645: iconst_2
    //   646: if_icmpne +421 -> 1067
    //   649: new 1192	com/tencent/mm/protocal/protobuf/fev
    //   652: dup
    //   653: invokespecial 1193	com/tencent/mm/protocal/protobuf/fev:<init>	()V
    //   656: aload 25
    //   658: getfield 1137	com/tencent/mm/protocal/protobuf/fdz:RNM	Lcom/tencent/mm/protocal/protobuf/eae;
    //   661: getfield 1143	com/tencent/mm/protocal/protobuf/eae:Tkb	Lcom/tencent/mm/cd/b;
    //   664: getfield 1148	com/tencent/mm/cd/b:UH	[B
    //   667: invokevirtual 1194	com/tencent/mm/protocal/protobuf/fev:parseFrom	([B)Lcom/tencent/mm/cd/a;
    //   670: checkcast 1192	com/tencent/mm/protocal/protobuf/fev
    //   673: astore_1
    //   674: aload_1
    //   675: ifnull +373 -> 1048
    //   678: ldc 251
    //   680: new 275	java/lang/StringBuilder
    //   683: dup
    //   684: ldc_w 1196
    //   687: invokespecial 280	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   690: aload_1
    //   691: getfield 1199	com/tencent/mm/protocal/protobuf/fev:rWu	I
    //   694: invokevirtual 537	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   697: invokevirtual 291	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   700: invokestatic 474	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   703: lload 10
    //   705: lstore 12
    //   707: lload 10
    //   709: aload 25
    //   711: getfield 1155	com/tencent/mm/protocal/protobuf/fdz:IyZ	I
    //   714: i2l
    //   715: lcmp
    //   716: ifge +11 -> 727
    //   719: aload 25
    //   721: getfield 1155	com/tencent/mm/protocal/protobuf/fdz:IyZ	I
    //   724: i2l
    //   725: lstore 12
    //   727: aload 25
    //   729: getfield 1155	com/tencent/mm/protocal/protobuf/fdz:IyZ	I
    //   732: i2l
    //   733: lload 16
    //   735: lcmp
    //   736: ifle +258 -> 994
    //   739: ldc 251
    //   741: new 275	java/lang/StringBuilder
    //   744: dup
    //   745: ldc_w 1201
    //   748: invokespecial 280	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   751: aload 25
    //   753: getfield 1155	com/tencent/mm/protocal/protobuf/fdz:IyZ	I
    //   756: invokevirtual 537	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   759: ldc_w 1203
    //   762: invokevirtual 288	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   765: lload 16
    //   767: invokevirtual 1112	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   770: ldc_w 1163
    //   773: invokevirtual 288	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   776: invokevirtual 291	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   779: invokestatic 474	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   782: aload_1
    //   783: getfield 1199	com/tencent/mm/protocal/protobuf/fev:rWu	I
    //   786: iconst_5
    //   787: if_icmpne +55 -> 842
    //   790: aload_0
    //   791: getfield 175	com/tencent/mm/plugin/voip/model/u:NPf	Lcom/tencent/mm/plugin/voip/model/v;
    //   794: getfield 211	com/tencent/mm/plugin/voip/model/v:NJk	Lcom/tencent/mm/plugin/voip/model/l;
    //   797: getfield 1167	com/tencent/mm/plugin/voip/model/l:NMl	Lcom/tencent/mm/plugin/voip/model/w;
    //   800: aload_1
    //   801: invokevirtual 1206	com/tencent/mm/plugin/voip/model/w:a	(Lcom/tencent/mm/protocal/protobuf/fev;)V
    //   804: lload 12
    //   806: lstore 22
    //   808: lload 8
    //   810: lstore 12
    //   812: goto -452 -> 360
    //   815: astore_1
    //   816: ldc 251
    //   818: ldc_w 1208
    //   821: invokestatic 474	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   824: ldc 251
    //   826: aload_1
    //   827: ldc_w 370
    //   830: iconst_0
    //   831: anewarray 4	java/lang/Object
    //   834: invokestatic 374	com/tencent/mm/sdk/platformtools/Log:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   837: aconst_null
    //   838: astore_1
    //   839: goto -165 -> 674
    //   842: aload_1
    //   843: getfield 1199	com/tencent/mm/protocal/protobuf/fev:rWu	I
    //   846: iconst_1
    //   847: if_icmpne +28 -> 875
    //   850: aload_0
    //   851: getfield 175	com/tencent/mm/plugin/voip/model/u:NPf	Lcom/tencent/mm/plugin/voip/model/v;
    //   854: getfield 211	com/tencent/mm/plugin/voip/model/v:NJk	Lcom/tencent/mm/plugin/voip/model/l;
    //   857: getfield 1167	com/tencent/mm/plugin/voip/model/l:NMl	Lcom/tencent/mm/plugin/voip/model/w;
    //   860: aload_1
    //   861: invokevirtual 1210	com/tencent/mm/plugin/voip/model/w:b	(Lcom/tencent/mm/protocal/protobuf/fev;)V
    //   864: lload 12
    //   866: lstore 22
    //   868: lload 8
    //   870: lstore 12
    //   872: goto -512 -> 360
    //   875: aload_1
    //   876: getfield 1199	com/tencent/mm/protocal/protobuf/fev:rWu	I
    //   879: bipush 6
    //   881: if_icmpne +77 -> 958
    //   884: aload_1
    //   885: getfield 1211	com/tencent/mm/protocal/protobuf/fev:RNM	Lcom/tencent/mm/protocal/protobuf/eae;
    //   888: getfield 1143	com/tencent/mm/protocal/protobuf/eae:Tkb	Lcom/tencent/mm/cd/b;
    //   891: invokevirtual 1212	com/tencent/mm/cd/b:toByteArray	()[B
    //   894: astore_1
    //   895: new 1214	com/tencent/mm/protocal/protobuf/feo
    //   898: dup
    //   899: invokespecial 1215	com/tencent/mm/protocal/protobuf/feo:<init>	()V
    //   902: aload_1
    //   903: invokevirtual 1216	com/tencent/mm/protocal/protobuf/feo:parseFrom	([B)Lcom/tencent/mm/cd/a;
    //   906: checkcast 1214	com/tencent/mm/protocal/protobuf/feo
    //   909: astore_1
    //   910: aload_1
    //   911: ifnull +17 -> 928
    //   914: aload_0
    //   915: getfield 175	com/tencent/mm/plugin/voip/model/u:NPf	Lcom/tencent/mm/plugin/voip/model/v;
    //   918: getfield 211	com/tencent/mm/plugin/voip/model/v:NJk	Lcom/tencent/mm/plugin/voip/model/l;
    //   921: getfield 1167	com/tencent/mm/plugin/voip/model/l:NMl	Lcom/tencent/mm/plugin/voip/model/w;
    //   924: aload_1
    //   925: invokevirtual 1219	com/tencent/mm/plugin/voip/model/w:a	(Lcom/tencent/mm/protocal/protobuf/feo;)V
    //   928: lload 12
    //   930: lstore 22
    //   932: lload 8
    //   934: lstore 12
    //   936: goto -576 -> 360
    //   939: astore_1
    //   940: ldc 251
    //   942: aload_1
    //   943: ldc_w 370
    //   946: iconst_0
    //   947: anewarray 4	java/lang/Object
    //   950: invokestatic 374	com/tencent/mm/sdk/platformtools/Log:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   953: aconst_null
    //   954: astore_1
    //   955: goto -45 -> 910
    //   958: ldc 251
    //   960: new 275	java/lang/StringBuilder
    //   963: dup
    //   964: ldc_w 1221
    //   967: invokespecial 280	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   970: aload_1
    //   971: getfield 1199	com/tencent/mm/protocal/protobuf/fev:rWu	I
    //   974: invokevirtual 537	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   977: invokevirtual 291	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   980: invokestatic 474	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   983: lload 12
    //   985: lstore 22
    //   987: lload 8
    //   989: lstore 12
    //   991: goto -631 -> 360
    //   994: ldc 251
    //   996: new 275	java/lang/StringBuilder
    //   999: dup
    //   1000: ldc_w 1223
    //   1003: invokespecial 280	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   1006: aload 25
    //   1008: getfield 1155	com/tencent/mm/protocal/protobuf/fdz:IyZ	I
    //   1011: invokevirtual 537	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1014: ldc_w 1225
    //   1017: invokevirtual 288	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1020: lload 16
    //   1022: invokevirtual 1112	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   1025: ldc_w 1163
    //   1028: invokevirtual 288	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1031: invokevirtual 291	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1034: invokestatic 474	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   1037: lload 12
    //   1039: lstore 22
    //   1041: lload 8
    //   1043: lstore 12
    //   1045: goto -685 -> 360
    //   1048: ldc 251
    //   1050: ldc_w 1208
    //   1053: invokestatic 474	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   1056: lload 10
    //   1058: lstore 22
    //   1060: lload 8
    //   1062: lstore 12
    //   1064: goto -704 -> 360
    //   1067: aload 25
    //   1069: getfield 1130	com/tencent/mm/protocal/protobuf/fdz:SnG	I
    //   1072: iconst_3
    //   1073: if_icmpne +441 -> 1514
    //   1076: new 1139	com/tencent/mm/protocal/protobuf/eae
    //   1079: dup
    //   1080: invokespecial 1226	com/tencent/mm/protocal/protobuf/eae:<init>	()V
    //   1083: aload 25
    //   1085: getfield 1137	com/tencent/mm/protocal/protobuf/fdz:RNM	Lcom/tencent/mm/protocal/protobuf/eae;
    //   1088: getfield 1143	com/tencent/mm/protocal/protobuf/eae:Tkb	Lcom/tencent/mm/cd/b;
    //   1091: getfield 1148	com/tencent/mm/cd/b:UH	[B
    //   1094: invokevirtual 1230	com/tencent/mm/protocal/protobuf/eae:dd	([B)Lcom/tencent/mm/protocal/protobuf/eae;
    //   1097: astore_1
    //   1098: aload_1
    //   1099: ifnull +415 -> 1514
    //   1102: lload 6
    //   1104: aload 25
    //   1106: getfield 1155	com/tencent/mm/protocal/protobuf/fdz:IyZ	I
    //   1109: i2l
    //   1110: lcmp
    //   1111: ifge +396 -> 1507
    //   1114: aload 25
    //   1116: getfield 1155	com/tencent/mm/protocal/protobuf/fdz:IyZ	I
    //   1119: i2l
    //   1120: lstore 20
    //   1122: lload 20
    //   1124: lstore 6
    //   1126: lload 10
    //   1128: lstore 22
    //   1130: lload 8
    //   1132: lstore 12
    //   1134: aload 25
    //   1136: getfield 1155	com/tencent/mm/protocal/protobuf/fdz:IyZ	I
    //   1139: i2l
    //   1140: lload 14
    //   1142: lcmp
    //   1143: ifle -783 -> 360
    //   1146: ldc 251
    //   1148: new 275	java/lang/StringBuilder
    //   1151: dup
    //   1152: ldc_w 1232
    //   1155: invokespecial 280	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   1158: aload 25
    //   1160: getfield 1155	com/tencent/mm/protocal/protobuf/fdz:IyZ	I
    //   1163: invokevirtual 537	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1166: ldc_w 1234
    //   1169: invokevirtual 288	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1172: lload 14
    //   1174: invokevirtual 1112	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   1177: ldc_w 1163
    //   1180: invokevirtual 288	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1183: invokevirtual 291	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1186: invokestatic 474	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   1189: aload_0
    //   1190: getfield 175	com/tencent/mm/plugin/voip/model/u:NPf	Lcom/tencent/mm/plugin/voip/model/v;
    //   1193: getfield 211	com/tencent/mm/plugin/voip/model/v:NJk	Lcom/tencent/mm/plugin/voip/model/l;
    //   1196: getfield 1167	com/tencent/mm/plugin/voip/model/l:NMl	Lcom/tencent/mm/plugin/voip/model/w;
    //   1199: aload_1
    //   1200: invokevirtual 1237	com/tencent/mm/plugin/voip/model/w:c	(Lcom/tencent/mm/protocal/protobuf/eae;)V
    //   1203: lload 20
    //   1205: lstore 6
    //   1207: lload 10
    //   1209: lstore 22
    //   1211: lload 8
    //   1213: lstore 12
    //   1215: aload_0
    //   1216: getfield 136	com/tencent/mm/plugin/voip/model/u:NPy	Lcom/tencent/mm/protocal/protobuf/fee;
    //   1219: ifnull -859 -> 360
    //   1222: lload 20
    //   1224: lstore 6
    //   1226: lload 10
    //   1228: lstore 22
    //   1230: lload 8
    //   1232: lstore 12
    //   1234: aload_1
    //   1235: getfield 1143	com/tencent/mm/protocal/protobuf/eae:Tkb	Lcom/tencent/mm/cd/b;
    //   1238: invokevirtual 1212	com/tencent/mm/cd/b:toByteArray	()[B
    //   1241: invokestatic 1241	com/tencent/mm/plugin/voip/c/e:cE	([B)I
    //   1244: sipush 255
    //   1247: iand
    //   1248: iconst_1
    //   1249: if_icmpne -889 -> 360
    //   1252: aload_0
    //   1253: getfield 136	com/tencent/mm/plugin/voip/model/u:NPy	Lcom/tencent/mm/protocal/protobuf/fee;
    //   1256: iconst_1
    //   1257: putfield 394	com/tencent/mm/protocal/protobuf/fee:UDF	I
    //   1260: lload 20
    //   1262: lstore 6
    //   1264: lload 10
    //   1266: lstore 22
    //   1268: lload 8
    //   1270: lstore 12
    //   1272: goto -912 -> 360
    //   1275: astore_1
    //   1276: ldc 251
    //   1278: aload_1
    //   1279: ldc_w 370
    //   1282: iconst_0
    //   1283: anewarray 4	java/lang/Object
    //   1286: invokestatic 374	com/tencent/mm/sdk/platformtools/Log:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   1289: aconst_null
    //   1290: astore_1
    //   1291: goto -193 -> 1098
    //   1294: lload 8
    //   1296: lload 18
    //   1298: lcmp
    //   1299: ifle +201 -> 1500
    //   1302: lload 10
    //   1304: lload 16
    //   1306: lcmp
    //   1307: ifle +186 -> 1493
    //   1310: lload 6
    //   1312: lload 14
    //   1314: lcmp
    //   1315: ifle +171 -> 1486
    //   1318: new 111	java/util/HashMap
    //   1321: dup
    //   1322: invokespecial 112	java/util/HashMap:<init>	()V
    //   1325: astore_1
    //   1326: aload_1
    //   1327: iconst_1
    //   1328: invokestatic 402	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   1331: lload 8
    //   1333: invokestatic 547	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   1336: invokeinterface 551 3 0
    //   1341: pop
    //   1342: aload_1
    //   1343: iconst_2
    //   1344: invokestatic 402	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   1347: lload 10
    //   1349: invokestatic 547	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   1352: invokeinterface 551 3 0
    //   1357: pop
    //   1358: aload_1
    //   1359: iconst_3
    //   1360: invokestatic 402	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   1363: lload 6
    //   1365: invokestatic 547	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   1368: invokeinterface 551 3 0
    //   1373: pop
    //   1374: aload_1
    //   1375: invokestatic 1243	com/tencent/mm/plugin/voip/model/u:aQ	(Ljava/util/Map;)[B
    //   1378: astore_1
    //   1379: iload_2
    //   1380: aload_0
    //   1381: getfield 175	com/tencent/mm/plugin/voip/model/u:NPf	Lcom/tencent/mm/plugin/voip/model/v;
    //   1384: getfield 211	com/tencent/mm/plugin/voip/model/v:NJk	Lcom/tencent/mm/plugin/voip/model/l;
    //   1387: getfield 217	com/tencent/mm/plugin/voip/model/l:NMi	Lcom/tencent/mm/plugin/voip/model/v2protocal;
    //   1390: getfield 480	com/tencent/mm/plugin/voip/model/v2protocal:roomId	I
    //   1393: if_icmpne +77 -> 1470
    //   1396: lload_3
    //   1397: aload_0
    //   1398: getfield 175	com/tencent/mm/plugin/voip/model/u:NPf	Lcom/tencent/mm/plugin/voip/model/v;
    //   1401: getfield 211	com/tencent/mm/plugin/voip/model/v:NJk	Lcom/tencent/mm/plugin/voip/model/l;
    //   1404: getfield 217	com/tencent/mm/plugin/voip/model/l:NMi	Lcom/tencent/mm/plugin/voip/model/v2protocal;
    //   1407: getfield 483	com/tencent/mm/plugin/voip/model/v2protocal:DPJ	J
    //   1410: lcmp
    //   1411: ifne +59 -> 1470
    //   1414: aload_0
    //   1415: getfield 175	com/tencent/mm/plugin/voip/model/u:NPf	Lcom/tencent/mm/plugin/voip/model/v;
    //   1418: getfield 211	com/tencent/mm/plugin/voip/model/v:NJk	Lcom/tencent/mm/plugin/voip/model/l;
    //   1421: aload_1
    //   1422: putfield 1103	com/tencent/mm/plugin/voip/model/l:NMm	[B
    //   1425: ldc 251
    //   1427: new 275	java/lang/StringBuilder
    //   1430: dup
    //   1431: ldc_w 1245
    //   1434: invokespecial 280	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   1437: lload 8
    //   1439: invokevirtual 1112	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   1442: ldc_w 1247
    //   1445: invokevirtual 288	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1448: lload 10
    //   1450: invokevirtual 1112	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   1453: ldc_w 1247
    //   1456: invokevirtual 288	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1459: lload 6
    //   1461: invokevirtual 1112	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   1464: invokevirtual 291	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1467: invokestatic 474	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   1470: ldc 251
    //   1472: ldc_w 1249
    //   1475: invokestatic 474	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   1478: ldc_w 1098
    //   1481: invokestatic 91	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   1484: iconst_0
    //   1485: ireturn
    //   1486: lload 14
    //   1488: lstore 6
    //   1490: goto -172 -> 1318
    //   1493: lload 16
    //   1495: lstore 10
    //   1497: goto -187 -> 1310
    //   1500: lload 18
    //   1502: lstore 8
    //   1504: goto -202 -> 1302
    //   1507: lload 6
    //   1509: lstore 20
    //   1511: goto -389 -> 1122
    //   1514: lload 10
    //   1516: lstore 22
    //   1518: lload 8
    //   1520: lstore 12
    //   1522: goto -1162 -> 360
    //   1525: lload 6
    //   1527: lstore 14
    //   1529: goto -1469 -> 60
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	1532	0	this	u
    //   0	1532	1	paramArrayOfByte	byte[]
    //   0	1532	2	paramInt	int
    //   0	1532	3	paramLong	long
    //   122	243	5	i	int
    //   126	1400	6	l1	long
    //   13	1506	8	l2	long
    //   16	1499	10	l3	long
    //   19	1502	12	l4	long
    //   58	1470	14	l5	long
    //   10	1484	16	l6	long
    //   7	1494	18	l7	long
    //   1120	390	20	l8	long
    //   358	1159	22	l9	long
    //   42	375	24	localObject1	Object
    //   530	5	24	localException	Exception
    //   550	26	24	str	String
    //   154	1005	25	localObject2	Object
    //   414	59	26	localInteger	Integer
    //   428	93	27	localLong	Long
    // Exception table:
    //   from	to	target	type
    //   105	121	530	java/lang/Exception
    //   191	216	594	java/io/IOException
    //   649	674	815	java/io/IOException
    //   895	910	939	java/io/IOException
    //   1076	1098	1275	java/io/IOException
  }
  
  public final void b(Context paramContext, x paramx)
  {
    AppMethodBeat.i(237766);
    this.NPf.b(paramContext, paramx);
    AppMethodBeat.o(237766);
  }
  
  public final void bW(Context paramContext, String paramString)
  {
    AppMethodBeat.i(115117);
    Log.i("MicroMsg.Voip.VoipService", "startVoiceCall, toUser:".concat(String.valueOf(paramString)));
    if ((Util.isNullOrNil(paramString)) || ((System.currentTimeMillis() - this.NPl < 2000L) && (System.currentTimeMillis() - this.NPl > 0L)))
    {
      AppMethodBeat.o(115117);
      return;
    }
    if ((System.currentTimeMillis() - this.NPo < this.NPp) && (System.currentTimeMillis() - this.NPo > 0L))
    {
      Log.i("MicroMsg.Voip.VoipService", "fail! cuz overloadInterval fail!");
      com.tencent.mm.ui.base.h.a(paramContext, b.g.voip_server_not_available, b.g.voip_warnning_title, null);
      AppMethodBeat.o(115117);
      return;
    }
    this.NPl = System.currentTimeMillis();
    if (((com.tencent.mm.plugin.messenger.foundation.a.n)com.tencent.mm.kernel.h.ae(com.tencent.mm.plugin.messenger.foundation.a.n.class)).bbL().RG(paramString) == null)
    {
      AppMethodBeat.o(115117);
      return;
    }
    a(paramContext, paramString, this.NPf.NJk.NMi.DPJ, true, false, false);
    gAf();
    AppMethodBeat.o(115117);
  }
  
  public final void bX(Context paramContext, String paramString)
  {
    AppMethodBeat.i(115118);
    Log.i("MicroMsg.Voip.VoipService", "startVideoCall, toUser:".concat(String.valueOf(paramString)));
    if ((Util.isNullOrNil(paramString)) || ((System.currentTimeMillis() - this.NPl < 2000L) && (System.currentTimeMillis() - this.NPl > 0L)))
    {
      AppMethodBeat.o(115118);
      return;
    }
    if ((System.currentTimeMillis() - this.NPo < this.NPp) && (System.currentTimeMillis() - this.NPo > 0L))
    {
      Log.i("MicroMsg.Voip.VoipService", "fail! cuz overloadInterval fail!");
      com.tencent.mm.ui.base.h.a(paramContext, b.g.voip_server_not_available, b.g.voip_warnning_title, null);
      AppMethodBeat.o(115118);
      return;
    }
    this.NPl = System.currentTimeMillis();
    if (((com.tencent.mm.plugin.messenger.foundation.a.n)com.tencent.mm.kernel.h.ae(com.tencent.mm.plugin.messenger.foundation.a.n.class)).bbL().RG(paramString) == null)
    {
      AppMethodBeat.o(115118);
      return;
    }
    a(paramContext, paramString, this.NPf.NJk.NMi.DPJ, true, true, false);
    gAf();
    AppMethodBeat.o(115118);
  }
  
  public final int bgf(String paramString)
  {
    AppMethodBeat.i(237767);
    int i = this.NPf.gD(paramString, 1);
    AppMethodBeat.o(237767);
    return i;
  }
  
  public final int bgg(String paramString)
  {
    AppMethodBeat.i(237769);
    int i = this.NPf.gD(paramString, 0);
    AppMethodBeat.o(237769);
    return i;
  }
  
  public final int c(ByteBuffer paramByteBuffer, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5)
  {
    AppMethodBeat.i(237812);
    paramInt1 = this.NPf.c(paramByteBuffer, paramInt1, paramInt2, paramInt3, paramInt4, paramInt5);
    AppMethodBeat.o(237812);
    return paramInt1;
  }
  
  public final int c(byte[] paramArrayOfByte, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    AppMethodBeat.i(237806);
    paramInt1 = this.NPf.c(paramArrayOfByte, paramInt1, paramInt2, paramInt3, paramInt4);
    AppMethodBeat.o(237806);
    return paramInt1;
  }
  
  public final void c(fee paramfee)
  {
    AppMethodBeat.i(115122);
    if (this.NPf.NJk.NMi.NSJ != 0)
    {
      Log.i("MicroMsg.Voip.VoipService", "steve:[simucall]doTaskCallin simulcall already processed, return! VoipGetRoomInfoResp roomid:%d, roomType:%d, mProtocol.roomId:%d, iSimulCallStatus:%d ", new Object[] { Integer.valueOf(paramfee.Svu), Integer.valueOf(paramfee.UDF), Integer.valueOf(this.NPf.NJk.NMi.roomId), Integer.valueOf(this.NPf.NJk.NMi.NSJ) });
      AppMethodBeat.o(115122);
      return;
    }
    int j = paramfee.UDF;
    boolean bool = ((com.tencent.mm.plugin.expt.b.b)com.tencent.mm.kernel.h.ae(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.vDA, false);
    Log.i("MicroMsg.Voip.VoipService", "steve:[simucall]doTaskCallin bNewSimulCallSwitch:%b ", new Object[] { Boolean.valueOf(bool) });
    int i = -1;
    if (bool) {
      i = b(paramfee);
    }
    if (i == 1)
    {
      this.NPf.a(paramfee.Svu, paramfee.Svv, 5, null, null, paramfee.UDO);
      Log.i("MicroMsg.Voip.VoipService", "steve:[simucall]doTaskCallin simulcall caller send ack roomid:%d, finalRoomType:%d, orgRoomType:%d ", new Object[] { Integer.valueOf(paramfee.Svu), Integer.valueOf(paramfee.UDF), Integer.valueOf(j) });
      com.tencent.mm.plugin.report.service.h.IzE.a(11525, true, true, new Object[] { Integer.valueOf(paramfee.Svu), Long.valueOf(paramfee.Svv), Integer.valueOf(j), Integer.valueOf(6), Integer.valueOf(com.tencent.mm.plugin.voip.c.e.getNetType(MMApplicationContext.getContext())), Long.valueOf(System.currentTimeMillis()) });
      AppMethodBeat.o(115122);
      return;
    }
    if ((!g.awi()) && (!isAppOnForeground(MMApplicationContext.getContext())))
    {
      Log.i("MicroMsg.Voip.VoipService", "NotificationConfig.isNewVoipMsgNotification() is false and is not in foreground, now return.");
      if ((this.NPy == null) && (this.Fsy.stopped()))
      {
        Log.i("MicroMsg.Voip.VoipService", "voipGetRoomInfoResp is null and time is stopped.");
        this.NPy = paramfee;
        this.Fsy.startTimer(2000L);
        this.NPz = System.currentTimeMillis();
        Log.i("MicroMsg.Voip.VoipService", "steve:voip roominfo stored!! roomid:%d, roomkey:%s, time:%d", new Object[] { Integer.valueOf(this.NPy.Svu), Long.valueOf(this.NPy.Svv), Integer.valueOf(this.NPy.CreateTime) });
        com.tencent.mm.plugin.report.service.h.IzE.idkeyStat(500L, 4L, 1L, false);
        com.tencent.mm.plugin.voip.c.e.alt(0);
      }
      AppMethodBeat.o(115122);
      return;
    }
    String str = paramfee.UDO;
    Object localObject = z.bcZ();
    i = paramfee.UDF;
    Log.i("MicroMsg.Voip.VoipService", "doTaskCallin self:%s talker:%s type:%d roomid:%d, roomkey:%s, time:%d", new Object[] { localObject, str, Integer.valueOf(i), Integer.valueOf(paramfee.Svu), Long.valueOf(paramfee.Svv), Integer.valueOf(paramfee.CreateTime) });
    if ((this.NPf.gyH()) && (!this.NPf.NPO))
    {
      this.NPf.a(paramfee.Svu, paramfee.Svv, 2, null, null, str);
      Log.i("MicroMsg.Voip.VoipService", "doTaskCallin invite ignor because voip busy:roomid " + paramfee.Svu);
      com.tencent.mm.plugin.report.service.h.IzE.a(11525, true, true, new Object[] { Integer.valueOf(paramfee.Svu), Long.valueOf(paramfee.Svv), Integer.valueOf(paramfee.UDF), Integer.valueOf(2), Integer.valueOf(com.tencent.mm.plugin.voip.c.e.getNetType(MMApplicationContext.getContext())), Long.valueOf(System.currentTimeMillis()) });
      com.tencent.mm.plugin.report.service.h.IzE.a(11526, true, true, new Object[] { Integer.valueOf(com.tencent.mm.plugin.voip.c.gxs().NPf.NJk.NMi.roomId), Long.valueOf(com.tencent.mm.plugin.voip.c.gxs().NPf.NJk.NMi.DPJ), Long.valueOf(com.tencent.mm.plugin.voip.c.gxs().NPf.NJk.gyI()), Integer.valueOf(7) });
      com.tencent.mm.plugin.voip.c.e.alt(0);
      AppMethodBeat.o(115122);
      return;
    }
    if (v.gAM())
    {
      this.NPf.a(paramfee.Svu, paramfee.Svv, 3, null, null, str);
      Log.e("MicroMsg.Voip.VoipService", "doTaskCallin invite ignor because telephone busy:roomid " + paramfee.Svu);
      com.tencent.mm.plugin.report.service.h.IzE.a(11525, true, true, new Object[] { Integer.valueOf(paramfee.Svu), Long.valueOf(paramfee.Svv), Integer.valueOf(paramfee.UDF), Integer.valueOf(3), Integer.valueOf(com.tencent.mm.plugin.voip.c.e.getNetType(MMApplicationContext.getContext())), Long.valueOf(System.currentTimeMillis()) });
      com.tencent.mm.plugin.report.service.h.IzE.a(11526, true, true, new Object[] { Integer.valueOf(com.tencent.mm.plugin.voip.c.gxs().NPf.NJk.NMi.roomId), Long.valueOf(com.tencent.mm.plugin.voip.c.gxs().NPf.NJk.NMi.DPJ), Long.valueOf(com.tencent.mm.plugin.voip.c.gxs().NPf.NJk.gyI()), Integer.valueOf(7) });
      com.tencent.mm.plugin.voip.c.e.alt(0);
      AppMethodBeat.o(115122);
      return;
    }
    this.NPf.gAN();
    if (this.NPf.NPQ)
    {
      if (this.NPf.NJk.NMi.roomId != paramfee.Svu)
      {
        this.NPf.NJk.NLI = true;
        this.NPf.NJk.NLK = false;
        this.NPf.NJk.NLJ = false;
        this.NPf.NJk.NMi.NRw = 0;
        this.NPf.NJk.NMi.NRv = 0;
        this.NPf.NJk.setStatus(3);
        this.NPf.NJk.NMi.roomId = paramfee.Svu;
        this.NPf.NJk.NMi.DPJ = paramfee.Svv;
        this.NPf.NJk.NMi.DPQ = 1;
        this.NPf.NJk.NMj.akD(i);
      }
      Log.i("MicroMsg.Voip.VoipService", "steve:[simucall]doTaskCallin simulcall auto-accept! mProtocol.roomId=%d, roomInfo.roomId=%d", new Object[] { Integer.valueOf(this.NPf.NJk.NMi.roomId), Integer.valueOf(paramfee.Svu) });
      AppMethodBeat.o(115122);
      return;
    }
    if (!this.NPf.a(paramfee))
    {
      Log.e("MicroMsg.Voip.VoipService", "doTaskCallin setInviteContent failed!");
      com.tencent.mm.plugin.report.service.h.IzE.a(11525, true, true, new Object[] { Integer.valueOf(paramfee.Svu), Long.valueOf(paramfee.Svv), Integer.valueOf(paramfee.UDF), Integer.valueOf(5), Integer.valueOf(com.tencent.mm.plugin.voip.c.e.getNetType(MMApplicationContext.getContext())), Long.valueOf(System.currentTimeMillis()) });
      com.tencent.mm.plugin.report.service.h.IzE.a(11526, true, true, new Object[] { Integer.valueOf(com.tencent.mm.plugin.voip.c.gxs().NPf.NJk.NMi.roomId), Long.valueOf(com.tencent.mm.plugin.voip.c.gxs().NPf.NJk.NMi.DPJ), Long.valueOf(com.tencent.mm.plugin.voip.c.gxs().NPf.NJk.gyI()), Integer.valueOf(7) });
      com.tencent.mm.plugin.voip.c.e.alt(0);
      AppMethodBeat.o(115122);
      return;
    }
    localObject = MMApplicationContext.getContext();
    if (((com.tencent.mm.plugin.messenger.foundation.a.n)com.tencent.mm.kernel.h.ae(com.tencent.mm.plugin.messenger.foundation.a.n.class)).bbL().RG(str) == null)
    {
      this.NPf.a(paramfee.Svu, paramfee.Svv, 4, null, null, str);
      Log.d("MicroMsg.Voip.VoipService", "doTaskCallin invite ignor because talker nil:roomid " + paramfee.Svu);
      com.tencent.mm.plugin.report.service.h.IzE.a(11525, true, true, new Object[] { Integer.valueOf(paramfee.Svu), Long.valueOf(paramfee.Svv), Integer.valueOf(paramfee.UDF), Integer.valueOf(4), Integer.valueOf(com.tencent.mm.plugin.voip.c.e.getNetType(MMApplicationContext.getContext())), Long.valueOf(System.currentTimeMillis()) });
      com.tencent.mm.plugin.report.service.h.IzE.a(11526, true, true, new Object[] { Integer.valueOf(com.tencent.mm.plugin.voip.c.gxs().NPf.NJk.NMi.roomId), Long.valueOf(com.tencent.mm.plugin.voip.c.gxs().NPf.NJk.NMi.DPJ), Long.valueOf(com.tencent.mm.plugin.voip.c.gxs().NPf.NJk.gyI()), Integer.valueOf(7) });
      com.tencent.mm.plugin.voip.c.e.alt(0);
      AppMethodBeat.o(115122);
      return;
    }
    if ((1 == i) || (i == 0)) {}
    for (;;)
    {
      try
      {
        long l = this.NPf.NJk.NMi.DPJ;
        if (i != 0) {
          continue;
        }
        bool = true;
        a((Context)localObject, str, l, false, bool, true);
        if (this.NPf != null) {
          this.NPf.alc(paramfee.Svu);
        }
        Log.d("MicroMsg.Voip.VoipService", "doTaskCallin invite startActivity VideoActivity");
      }
      catch (Exception localException)
      {
        com.tencent.mm.plugin.voip.c.e.alt(2);
        continue;
      }
      this.NPf.a(paramfee.Svu, paramfee.Svv, 1, this.NPf.NJk.NMi.field_peerId, this.NPf.NJk.NMi.field_capInfo, str);
      com.tencent.mm.plugin.report.service.h.IzE.a(11525, true, true, new Object[] { Integer.valueOf(paramfee.Svu), Long.valueOf(paramfee.Svv), Integer.valueOf(paramfee.UDF), Integer.valueOf(1), Integer.valueOf(com.tencent.mm.plugin.voip.c.e.getNetType(MMApplicationContext.getContext())), Long.valueOf(System.currentTimeMillis()) });
      AppMethodBeat.o(115122);
      return;
      bool = false;
    }
  }
  
  public final void c(boolean paramBoolean1, boolean paramBoolean2, String paramString)
  {
    AppMethodBeat.i(115115);
    Log.i("MicroMsg.Voip.VoipService", "setCalling " + paramBoolean1 + "  videoCall " + paramBoolean2 + "username " + paramString);
    this.fqP = paramBoolean1;
    if (paramBoolean2)
    {
      this.NPh = paramBoolean1;
      this.NPf.NJk.NMi.NQW = 0;
    }
    for (;;)
    {
      this.talker = paramString;
      this.NPf.NJk.NMi.NSI.myn = paramString;
      AppMethodBeat.o(115115);
      return;
      this.NPf.NJk.NMi.NQW = 1;
      this.NPi = paramBoolean1;
    }
  }
  
  public final boolean cNL()
  {
    AppMethodBeat.i(293171);
    boolean bool = this.NPf.cNL();
    AppMethodBeat.o(293171);
    return bool;
  }
  
  public final void e(String paramString, boolean paramBoolean, long paramLong)
  {
    AppMethodBeat.i(237830);
    Log.printInfoStack("MicroMsg.Voip.VoipService", "bindVoipForegroundIfNeed", new Object[0]);
    if ((com.tencent.mm.compatible.util.d.qV(26)) && (!this.tKK))
    {
      localObject = q.NOm;
      q.gzo();
      localObject = new Intent();
      ((Intent)localObject).putExtra("isRecalled", false);
      ((Intent)localObject).putExtra("Voip_User", paramString);
      ((Intent)localObject).putExtra("Voip_CallRoomKey", paramLong);
      ((Intent)localObject).putExtra("Voip_VideoCall", paramBoolean);
      ((Intent)localObject).setClass(MMApplicationContext.getContext(), VoipForegroundService.class);
    }
    try
    {
      MMApplicationContext.getContext().startService((Intent)localObject);
      i = 1;
    }
    catch (Exception paramString)
    {
      for (;;)
      {
        int i;
        Log.printErrStackTrace("MicroMsg.Voip.VoipService", paramString, "using start service to bindVoipForegroundIfNeed error: %s", new Object[] { paramString.getMessage() });
        try
        {
          MMApplicationContext.getContext().startForegroundService((Intent)localObject);
          paramString = q.NOm;
          q.gzq();
          i = 0;
        }
        catch (Exception paramString)
        {
          Log.printErrStackTrace("MicroMsg.Voip.VoipService", paramString, "using start foreground service to bindVoipForegroundIfNeed error: %s", new Object[] { paramString.getMessage() });
          i = 0;
        }
      }
    }
    if (i != 0)
    {
      this.tKK = true;
      paramString = q.NOm;
      q.gzp();
    }
    AppMethodBeat.o(237830);
  }
  
  public final void eXr()
  {
    AppMethodBeat.i(162308);
    this.NPq = null;
    ((com.tencent.mm.plugin.notification.b.a)com.tencent.mm.kernel.h.ag(com.tencent.mm.plugin.notification.b.a.class)).getNotification().cancel(41);
    AppMethodBeat.o(162308);
  }
  
  protected final void finalize()
  {
    AppMethodBeat.i(115114);
    this.NPf.stop();
    this.NPf = null;
    this.NPj = false;
    this.NPk = false;
    com.tencent.mm.kernel.h.aHF().b(this.MjF);
    ((com.tencent.mm.plugin.misc.a.a)com.tencent.mm.kernel.h.ae(com.tencent.mm.plugin.misc.a.a.class)).b(this.lHE);
    super.finalize();
    AppMethodBeat.o(115114);
  }
  
  public final void gAB()
  {
    AppMethodBeat.i(237831);
    this.NPg = null;
    this.NPr = null;
    this.NPs = false;
    this.NPu = false;
    this.NPt = false;
    this.NPA = false;
    com.tencent.mm.plugin.voip.c.gxt().ic(true);
    AppMethodBeat.o(237831);
  }
  
  public final void gAC()
  {
    AppMethodBeat.i(115149);
    this.NPf.NPV.startTimer(1000L);
    AppMethodBeat.o(115149);
  }
  
  public final int gAD()
  {
    return this.NPf.NJk.NMi.NQV;
  }
  
  public final void gAE()
  {
    AppMethodBeat.i(115152);
    this.NPf.NJk.NMk.gzd();
    AppMethodBeat.o(115152);
  }
  
  public final boolean gAF()
  {
    AppMethodBeat.i(237838);
    boolean bool = this.NPf.NJk.NMw.gAd();
    AppMethodBeat.o(237838);
    return bool;
  }
  
  public final void gAG()
  {
    AppMethodBeat.i(237839);
    this.NPf.NJk.NMw = new VoipScoreState();
    AppMethodBeat.o(237839);
  }
  
  public final VoipScoreState gAH()
  {
    return this.NPf.NJk.NMw;
  }
  
  public final void gAg()
  {
    AppMethodBeat.i(237761);
    if ((this.NPB == null) || (this.NPB.isEmpty()))
    {
      AppMethodBeat.o(237761);
      return;
    }
    Iterator localIterator = this.NPB.iterator();
    while (localIterator.hasNext()) {
      if ((a)localIterator.next() != null)
      {
        AppMethodBeat.o(237761);
        throw null;
      }
    }
    AppMethodBeat.o(237761);
  }
  
  public final int gAh()
  {
    AppMethodBeat.i(237770);
    com.tencent.mm.plugin.voip.b.a locala = com.tencent.mm.plugin.voip.b.a.NTi;
    com.tencent.mm.plugin.voip.b.a.a(com.tencent.mm.plugin.voip.b.a.a.NTk);
    int i = this.NPf.gAh();
    AppMethodBeat.o(237770);
    return i;
  }
  
  public final int gAi()
  {
    AppMethodBeat.i(237772);
    com.tencent.mm.plugin.voip.b.a locala = com.tencent.mm.plugin.voip.b.a.NTi;
    com.tencent.mm.plugin.voip.b.a.a(com.tencent.mm.plugin.voip.b.a.a.NTo);
    int i = this.NPf.gAi();
    AppMethodBeat.o(237772);
    return i;
  }
  
  public final int gAj()
  {
    AppMethodBeat.i(237773);
    com.tencent.mm.plugin.voip.b.a locala = com.tencent.mm.plugin.voip.b.a.NTi;
    com.tencent.mm.plugin.voip.b.a.a(com.tencent.mm.plugin.voip.b.a.a.NTq);
    int i = this.NPf.gAj();
    AppMethodBeat.o(237773);
    return i;
  }
  
  public final int gAk()
  {
    AppMethodBeat.i(237775);
    com.tencent.mm.plugin.voip.b.a locala = com.tencent.mm.plugin.voip.b.a.NTi;
    com.tencent.mm.plugin.voip.b.a.a(com.tencent.mm.plugin.voip.b.a.a.NTk);
    int i = this.NPf.gAk();
    AppMethodBeat.o(237775);
    return i;
  }
  
  public final int gAl()
  {
    AppMethodBeat.i(237777);
    com.tencent.mm.plugin.voip.b.a locala = com.tencent.mm.plugin.voip.b.a.NTi;
    com.tencent.mm.plugin.voip.b.a.a(com.tencent.mm.plugin.voip.b.a.a.NTo);
    this.NPf.gAl();
    AppMethodBeat.o(237777);
    return 0;
  }
  
  public final int gAm()
  {
    AppMethodBeat.i(237778);
    this.NPf.gAm();
    AppMethodBeat.o(237778);
    return 0;
  }
  
  public final int gAn()
  {
    return this.NPf.NJk.NMi.roomId;
  }
  
  public final long gAo()
  {
    return this.NPf.NJk.NMi.DPJ;
  }
  
  public final void gAp()
  {
    AppMethodBeat.i(237789);
    n localn = this.NPf.NJk.NMk;
    if (localn.tQq != null) {
      localn.tQq.dE(true);
    }
    AppMethodBeat.o(237789);
  }
  
  public final void gAq()
  {
    AppMethodBeat.i(237792);
    n localn = this.NPf.NJk.NMk;
    if (localn.tQq != null) {
      localn.tQq.dE(false);
    }
    AppMethodBeat.o(237792);
  }
  
  public final void gAr()
  {
    AppMethodBeat.i(115135);
    Log.d("MicroMsg.Voip.VoipService", "devin: setCallResult: %d", new Object[] { Integer.valueOf(1) });
    this.NPf.NJk.NMi.NSI.NNC = 1;
    AppMethodBeat.o(115135);
  }
  
  public final void gAs()
  {
    AppMethodBeat.i(237809);
    Object localObject = this.NPf.NJk.NMk;
    if ((((n)localObject).NJk != null) && (((n)localObject).NJk.NMi != null))
    {
      byte[] arrayOfByte = new byte[4];
      if (((n)localObject).NJk.NMi.setAppCmd(n.NKa, arrayOfByte, 4) >= 0)
      {
        int i = Util.byteArrayToInt(arrayOfByte);
        int k = i >> 16;
        int m = i & 0xFFFF;
        int j = k;
        i = m;
        if (!v2protocal.NQB) {
          if (k < 1280)
          {
            j = k;
            i = m;
            if (m < 1280) {}
          }
          else
          {
            j = ((k >> 1) + 8) / 16 * 16;
            i = ((m >> 1) + 8) / 16 * 16;
          }
        }
        localObject = com.tencent.mm.plugin.voip.c.c.NXF;
        com.tencent.mm.plugin.voip.c.c.eA(j, i);
        localObject = com.tencent.mm.plugin.voip.c.c.NXF;
        com.tencent.mm.plugin.voip.c.c.Bj(false);
      }
      AppMethodBeat.o(237809);
      return;
    }
    localObject = com.tencent.mm.plugin.voip.c.c.NXF;
    com.tencent.mm.plugin.voip.c.c.clear();
    AppMethodBeat.o(237809);
  }
  
  public final int gAv()
  {
    return this.NPf.NJk.NMk.NJk.NMi.field_sendVideoLen;
  }
  
  public final int gAw()
  {
    return this.NPf.NJk.NMk.NJk.NMi.field_recvVideoLen;
  }
  
  public final byte[] gAx()
  {
    return this.NPf.NJk.NMi.NSb;
  }
  
  public final boolean gAy()
  {
    bool2 = false;
    AppMethodBeat.i(115143);
    bool1 = bool2;
    try
    {
      if (this.NPf.NJk.NMi != null)
      {
        int i = this.NPf.NJk.NMi.NRB;
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
        Log.e("MicroMsg.Voip.VoipService", "steve:cannot get CPU usage! error: " + localException.getMessage());
        bool1 = bool2;
      }
    }
    AppMethodBeat.o(115143);
    return bool1;
  }
  
  public final void gAz()
  {
    AppMethodBeat.i(237829);
    u.b localb = this.NPq;
    if (localb != null)
    {
      Log.i("MicroMsg.Voip.VoipService", "resetFullscreenIntent ");
      String str = this.NPf.toUser;
      boolean bool1 = this.NPf.NPE;
      boolean bool2 = this.NPf.NPF;
      long l = localb.DPJ;
      eXr();
      a(MMApplicationContext.getContext(), str, l, bool1, bool2, true);
      AppMethodBeat.o(237829);
      return;
    }
    Log.i("MicroMsg.Voip.VoipService", "do not need voip resume");
    AppMethodBeat.o(237829);
  }
  
  public final int gxF()
  {
    AppMethodBeat.i(185953);
    n localn = this.NPf.NJk.NMk;
    if (localn.NMO != null)
    {
      int i = localn.NMO.gxF();
      AppMethodBeat.o(185953);
      return i;
    }
    AppMethodBeat.o(185953);
    return 0;
  }
  
  public final long gyI()
  {
    AppMethodBeat.i(293169);
    long l = this.NPf.NJk.gyI();
    AppMethodBeat.o(293169);
    return l;
  }
  
  public final int kO(int paramInt1, int paramInt2)
  {
    n localn = this.NPf.NJk.NMk;
    localn.NJk.NMi.NRZ = paramInt1;
    localn.NJk.NMi.NSa = paramInt2;
    return 0;
  }
  
  public final void kP(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(237820);
    v localv = this.NPf;
    if ((localv.tRS != null) && (paramInt1 > 0)) {
      localv.tRS.i(paramInt1, false, paramInt2);
    }
    AppMethodBeat.o(237820);
  }
  
  public final void stopRing()
  {
    AppMethodBeat.i(293170);
    this.NPf.stopRing();
    AppMethodBeat.o(293170);
  }
  
  public final void uB(boolean paramBoolean)
  {
    AppMethodBeat.i(115153);
    Log.printInfoStack("MicroMsg.Voip.VoipService", "setEngineHeadsetPlugged, %s", new Object[] { Boolean.valueOf(paramBoolean) });
    byte[] arrayOfByte = new byte[1];
    if (paramBoolean) {}
    for (int i = 1;; i = 0)
    {
      arrayOfByte[0] = ((byte)i);
      this.NPf.NJk.NMi.setAppCmd(425, arrayOfByte, 1);
      if (!paramBoolean) {
        break;
      }
      if (com.tencent.mm.plugin.audio.c.a.crh()) {
        this.NPf.NJk.NMi.setAppCmd(441, arrayOfByte, 1);
      }
      if (!com.tencent.mm.plugin.audio.c.a.cro()) {
        break label163;
      }
      this.NPf.NJk.NMi.setAppCmd(442, arrayOfByte, 1);
      AppMethodBeat.o(115153);
      return;
    }
    this.NPf.NJk.NMi.setAppCmd(441, arrayOfByte, 1);
    this.NPf.NJk.NMi.setAppCmd(442, arrayOfByte, 1);
    label163:
    AppMethodBeat.o(115153);
  }
  
  public final void unRegister()
  {
    AppMethodBeat.i(115142);
    Log.i("MicroMsg.Voip.VoipService", "unRegister and remove all notification and voip foreground service");
    this.NPj = false;
    this.NPk = false;
    gAA();
    eXr();
    ((com.tencent.mm.plugin.notification.b.a)com.tencent.mm.kernel.h.ag(com.tencent.mm.plugin.notification.b.a.class)).getNotification().cancel(40);
    AppMethodBeat.o(115142);
  }
  
  public final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.voip.model.u
 * JD-Core Version:    0.7.0.1
 */