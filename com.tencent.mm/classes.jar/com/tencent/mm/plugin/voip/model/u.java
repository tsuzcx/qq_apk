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
import com.tencent.mm.g.a.kg;
import com.tencent.mm.g.a.yh;
import com.tencent.mm.model.at;
import com.tencent.mm.model.w;
import com.tencent.mm.network.n.a;
import com.tencent.mm.plugin.expt.b.b.a;
import com.tencent.mm.plugin.voip.ui.VideoActivity;
import com.tencent.mm.plugin.voip.video.i;
import com.tencent.mm.plugin.voip.widget.VoipForegroundService;
import com.tencent.mm.protocal.protobuf.btl;
import com.tencent.mm.protocal.protobuf.dmh;
import com.tencent.mm.protocal.protobuf.dvc;
import com.tencent.mm.protocal.protobuf.dzm;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.ar;
import com.tencent.mm.sdk.platformtools.aw.a;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.storage.bq;
import com.tencent.mm.ui.base.h;
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
  private static final com.tencent.mm.b.f<Integer, p.a> fVO;
  private com.tencent.mm.network.n BEN;
  public String CqG;
  public boolean CvA;
  List<a> CvB;
  public v Cvg;
  public com.tencent.mm.plugin.voip.a Cvh;
  public boolean Cvi;
  public boolean Cvj;
  public boolean Cvk;
  private long Cvl;
  public Map<Integer, Long> Cvm;
  public int Cvn;
  public long Cvo;
  public long Cvp;
  public volatile u.b Cvq;
  private Point Cvr;
  public boolean Cvs;
  boolean Cvt;
  boolean Cvu;
  public boolean Cvv;
  public boolean Cvw;
  private boolean Cvx;
  public dzm Cvy;
  public long Cvz;
  public boolean dgR;
  public String talker;
  public com.tencent.mm.sdk.platformtools.aw wrr;
  
  static
  {
    AppMethodBeat.i(115155);
    fVO = new com.tencent.mm.memory.a.c(5);
    AppMethodBeat.o(115155);
  }
  
  public u()
  {
    AppMethodBeat.i(115113);
    this.dgR = false;
    this.Cvi = false;
    this.Cvj = false;
    this.Cvk = false;
    this.talker = null;
    this.Cvl = 0L;
    this.Cvm = new HashMap();
    this.Cvn = -1;
    this.Cvo = 0L;
    this.Cvp = 0L;
    this.Cvs = false;
    this.Cvt = false;
    this.Cvu = false;
    this.Cvv = false;
    this.Cvw = false;
    this.Cvx = false;
    this.Cvy = null;
    this.Cvz = 0L;
    this.CqG = null;
    this.CvA = false;
    this.BEN = new n.a()
    {
      public final void onNetworkChange(int paramAnonymousInt)
      {
        AppMethodBeat.i(115109);
        ae.d("MicroMsg.Voip.VoipService", "network status change from ".concat(String.valueOf(paramAnonymousInt)));
        l locall;
        if ((u.a(u.this)) && (paramAnonymousInt == 4))
        {
          locall = u.this.Cvg.Cpd;
          if (locall.Csu == 0) {
            locall.Csu = locall.Csj.CwF;
          }
          paramAnonymousInt = com.tencent.mm.plugin.voip.b.f.getNetType(ak.getContext());
          if (paramAnonymousInt != locall.Csu) {
            com.tencent.mm.plugin.voip.b.f.Logi("MicroMsg.Voip.VoipContext", "steve: onVoipLocalNetTypeChange: local network type change from " + locall.Csu + " to " + paramAnonymousInt);
          }
        }
        try
        {
          byte[] arrayOfByte = new byte[4];
          arrayOfByte[0] = ((byte)paramAnonymousInt);
          int i = locall.Csj.setAppCmd(301, arrayOfByte, 4);
          if (i < 0) {
            com.tencent.mm.plugin.voip.b.f.Logi("MicroMsg.Voip.VoipContext", "steve:[ENGINE]IMVQQEngine::SetAppCmd[EMethodSetLocalNetType] update local network type" + paramAnonymousInt + "fail:" + i + ", [roomid=" + locall.Csj.uXn + ", roomkey=" + locall.Csj.uXg + "]");
          }
          dvc localdvc = new dvc();
          localdvc.IaM = 3;
          localdvc.IaN = new com.tencent.mm.bw.b(arrayOfByte, 0, 1);
          locall.Csj.SendRUDP(localdvc.toByteArray(), localdvc.toByteArray().length);
        }
        catch (Exception localException)
        {
          for (;;)
          {
            com.tencent.mm.plugin.voip.b.f.Logi("MicroMsg.Voip.VoipContext", "onVoipLocalNetTypeChange Error");
          }
        }
        locall.Csu = paramAnonymousInt;
        u.this.Cvg.eBF();
        AppMethodBeat.o(115109);
      }
    };
    this.wrr = new com.tencent.mm.sdk.platformtools.aw(Looper.getMainLooper(), new aw.a()
    {
      public final boolean onTimerExpired()
      {
        AppMethodBeat.i(115111);
        ae.v("MicroMsg.Voip.VoipService", "voip repeat check is foreground");
        if (u.e(u.this) == null)
        {
          u.f(u.this);
          u.g(u.this).stopTimer();
          AppMethodBeat.o(115111);
          return false;
        }
        if (u.gG(ak.getContext()))
        {
          u.this.aI(u.e(u.this).Gxq, u.e(u.this).Gxr);
          ae.i("MicroMsg.Voip.VoipService", "steve:voip callin in mRepeatCheckHandler, roomid:%d, roomkey:%s, time:%d", new Object[] { Integer.valueOf(u.e(u.this).Gxq), Long.valueOf(u.e(u.this).Gxr), Integer.valueOf(u.e(u.this).CreateTime) });
          u.this.c(u.e(u.this));
          u.h(u.this);
          u.f(u.this);
          u.g(u.this).stopTimer();
          com.tencent.mm.plugin.report.service.g.yxI.idkeyStat(500L, 5L, 1L, false);
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
    this.CvB = null;
    this.Cvg = new v();
    this.dgR = false;
    this.Cvi = false;
    this.Cvj = false;
    this.talker = null;
    this.Cvk = false;
    this.CqG = null;
    com.tencent.mm.kernel.g.ajQ().a(this.BEN);
    AppMethodBeat.o(115113);
  }
  
  public static p.a aEY(String paramString)
  {
    AppMethodBeat.i(115124);
    if ((paramString == null) || (paramString.length() == 0))
    {
      AppMethodBeat.o(115124);
      return null;
    }
    int i = paramString.hashCode();
    p.a locala = (p.a)fVO.get(Integer.valueOf(i));
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
    fVO.q(Integer.valueOf(i), locala);
    AppMethodBeat.o(115124);
    return locala;
  }
  
  private static byte[] aX(Map<Integer, Long> paramMap)
  {
    AppMethodBeat.i(115126);
    dmh localdmh = new dmh();
    LinkedList localLinkedList = new LinkedList();
    Iterator localIterator = paramMap.keySet().iterator();
    while (localIterator.hasNext())
    {
      Integer localInteger = (Integer)localIterator.next();
      btl localbtl = new btl();
      localbtl.yxe = localInteger.intValue();
      localbtl.HgL = ((Long)paramMap.get(localInteger)).intValue();
      localLinkedList.push(localbtl);
    }
    localdmh.HMl = localLinkedList;
    localdmh.HMk = localLinkedList.size();
    try
    {
      paramMap = localdmh.toByteArray();
      AppMethodBeat.o(115126);
      return paramMap;
    }
    catch (IOException paramMap)
    {
      ae.printErrStackTrace("MicroMsg.Voip.VoipService", paramMap, "", new Object[0]);
      AppMethodBeat.o(115126);
    }
    return null;
  }
  
  public static byte[] ab(byte[] paramArrayOfByte, int paramInt)
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
  
  private int b(dzm paramdzm)
  {
    int j = -1;
    boolean bool1 = true;
    AppMethodBeat.i(115120);
    Object localObject = com.tencent.mm.model.v.aAC();
    String str2;
    int i;
    String str1;
    if (paramdzm != null)
    {
      str2 = paramdzm.Ieu;
      k = paramdzm.Iel;
      ae.i("MicroMsg.Voip.VoipService", "steve:[simucall] being called! roomid:%d, myname:%s, remoteInviteName:%s,myInviteName:%s, calltype:%d, working:%b, dialing:%b, isSimulCall:%b", new Object[] { Integer.valueOf(paramdzm.Gxq), localObject, str2, this.Cvg.CvT, Integer.valueOf(k), Boolean.valueOf(this.Cvg.ezD()), Boolean.valueOf(this.Cvg.Cpd.ezB()), Boolean.valueOf(this.Cvg.CvQ) });
      i = j;
      if (!this.Cvg.ezD()) {
        break label622;
      }
      i = j;
      if (this.Cvg.Cpd == null) {
        break label622;
      }
      i = j;
      if (!this.Cvg.Cpd.ezB()) {
        break label622;
      }
      i = j;
      if (this.Cvg.CvQ) {
        break label622;
      }
      str1 = this.Cvg.CvT;
      if ((str2 == null) || (str1 == null))
      {
        ae.e("MicroMsg.Voip.VoipService", "steve:[simucall] name null! myname:%s, remoteInviteName:%s, myInviteName:%s", new Object[] { localObject, str2, str1 });
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
    ae.i("MicroMsg.Voip.VoipService", "steve:[simucall]  mutualCalling:%s", new Object[] { Boolean.valueOf(bool2) });
    if (bool2)
    {
      this.Cvg.CvQ = true;
      i = str1.compareTo((String)localObject);
      boolean bool3 = str1.contains("@");
      if ((i < 0) || (bool3))
      {
        i = 1;
        localObject = this.Cvg.Cpd.Csj;
        ((v2protocal)localObject).CyI |= 0x2;
        if (!this.Cvh.eyl()) {
          break label656;
        }
        j = 0;
        label350:
        if ((k != 1) && (j != 1)) {
          break label718;
        }
      }
    }
    label656:
    label718:
    for (int k = 1;; k = 0)
    {
      if ((this.Cvh.eyl()) && (k == 1))
      {
        ae.i("MicroMsg.Voip.VoipService", "steve:[simucall]audio room, close camera first! myInviteType:%d, finalRoomType:%d", new Object[] { Integer.valueOf(j), Integer.valueOf(k) });
        this.Cvg.Cpd.Csk.Ux(1);
      }
      paramdzm.Iel = k;
      this.Cvg.CvR = k;
      ae.i("MicroMsg.Voip.VoipService", "steve:[simucall]myInviteName:%s, mutualCalling:%s,caller:%d,myInviteType:%d,finalType:%d", new Object[] { str1, Boolean.valueOf(bool2), Integer.valueOf(i), Integer.valueOf(j), Integer.valueOf(k) });
      if (i == 2)
      {
        ae.i("MicroMsg.Voip.VoipService", "steve:[simucall] i'm callee, cancel my previous invite!");
        this.Cvg.CvS = true;
        if ((this.Cvg.Cpd.Csj != null) && (this.Cvg.Cpd.Csj.roomId != 0) && (this.Cvg.Cpd.Csj.uXg != 0L) && (this.Cvg.Cpd.Csj.roomId != paramdzm.Gxq)) {
          b(this.Cvg.Cpd.Csj.roomId, this.Cvg.Cpd.Csj.uXg, j);
        }
        if (k == 0) {
          label613:
          this.Cvh.th(bool1);
        }
      }
      for (;;)
      {
        label622:
        if (this.Cvg.CvQ) {
          paramdzm.Iel = this.Cvg.CvR;
        }
        AppMethodBeat.o(115120);
        return i;
        i = 2;
        break;
        j = 1;
        break label350;
        bool1 = false;
        break label613;
        this.Cvg.CvS = false;
        ae.i("MicroMsg.Voip.VoipService", "steve:[simucall] i'm caller, do NOT answer others' invite!");
        continue;
        ae.i("MicroMsg.Voip.VoipService", "steve:[simucall] myInviteName:%s, mutualCalling:%s", new Object[] { str1, Boolean.valueOf(bool2) });
        i = j;
      }
    }
  }
  
  private static Map<Integer, Long> bV(byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(115125);
    if (bu.cF(paramArrayOfByte))
    {
      AppMethodBeat.o(115125);
      return null;
    }
    try
    {
      paramArrayOfByte = (dmh)new dmh().parseFrom(paramArrayOfByte);
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
    ae.d("MicroMsg.Voip.VoipService", "dkpush : keyCount:" + paramArrayOfByte.HMk);
    LinkedList localLinkedList = paramArrayOfByte.HMl;
    if (localLinkedList.size() != paramArrayOfByte.HMk)
    {
      AppMethodBeat.o(115125);
      return null;
    }
    HashMap localHashMap = new HashMap();
    int i = 0;
    while (i < paramArrayOfByte.HMk)
    {
      localHashMap.put(Integer.valueOf(((btl)localLinkedList.get(i)).yxe), Long.valueOf(0xFFFFFFFF & ((btl)localLinkedList.get(i)).HgL));
      i += 1;
    }
    if (localHashMap.size() != paramArrayOfByte.HMk)
    {
      AppMethodBeat.o(115125);
      return null;
    }
    AppMethodBeat.o(115125);
    return localHashMap;
  }
  
  private static String bW(byte[] paramArrayOfByte)
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
  
  private static boolean cJ(Context paramContext)
  {
    AppMethodBeat.i(115150);
    Object localObject = ((ActivityManager)paramContext.getSystemService("activity")).getRunningTasks(1);
    if ((localObject != null) && (!((List)localObject).isEmpty()))
    {
      localObject = ((ActivityManager.RunningTaskInfo)((List)localObject).get(0)).topActivity;
      ae.d("MicroMsg.Voip.VoipService", "topActivity:" + ((ComponentName)localObject).flattenToString());
      if (!((ComponentName)localObject).getPackageName().equals(paramContext.getPackageName()))
      {
        ae.i("MicroMsg.Voip.VoipService", "is in backGround.");
        AppMethodBeat.o(115150);
        return false;
      }
    }
    if (((KeyguardManager)ak.getContext().getSystemService("keyguard")).inKeyguardRestrictedInputMode())
    {
      AppMethodBeat.o(115150);
      return false;
    }
    ae.i("MicroMsg.Voip.VoipService", "is in foreGround.");
    AppMethodBeat.o(115150);
    return true;
  }
  
  private static void eBa()
  {
    AppMethodBeat.i(115119);
    yh localyh = new yh();
    localyh.dNE.dto = 7;
    com.tencent.mm.sdk.b.a.IvT.l(localyh);
    AppMethodBeat.o(115119);
  }
  
  private void eBn()
  {
    AppMethodBeat.i(115146);
    ae.m("MicroMsg.Voip.VoipService", "unbindVoiceServiceIfNeed", new Object[0]);
    if (com.tencent.mm.compatible.util.d.lA(26)) {}
    try
    {
      Object localObject = new Intent();
      ((Intent)localObject).setClass(ak.getContext(), VoipForegroundService.class);
      ak.getContext().stopService((Intent)localObject);
      localObject = q.Cup;
      q.eAq();
      i = 1;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        ae.printErrStackTrace("MicroMsg.Voip.VoipService", localException, "unBind vidoeforeground error: %s", new Object[] { localException.getMessage() });
        int i = 0;
      }
    }
    if (i != 0) {
      this.Cvx = false;
    }
    AppMethodBeat.o(115146);
  }
  
  public static float tw(boolean paramBoolean)
  {
    AppMethodBeat.i(115148);
    float f1 = 0.7476636F;
    float f2 = f1;
    for (;;)
    {
      try
      {
        localObject = com.tencent.mm.plugin.voip.c.eys();
        if (!paramBoolean) {
          continue;
        }
        f2 = f1;
        localObject = ((u)localObject).Cvg.Cpd.Csj.field_capInfo;
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
          ae.d("MicroMsg.Voip.VoipService", "use rate: %s, changed: %s", new Object[] { Float.valueOf(f1), Boolean.valueOf(paramBoolean) });
          f2 = f1;
        }
      }
      catch (Exception localException)
      {
        Object localObject;
        ae.e("MicroMsg.Voip.VoipService", "update failed: " + localException.getMessage());
        continue;
      }
      AppMethodBeat.o(115148);
      return f2;
      f2 = f1;
      localObject = ((u)localObject).Cvg.Cpd.Csj.CwJ;
    }
  }
  
  public final void UL(int paramInt)
  {
    AppMethodBeat.i(115130);
    this.Cvg.UL(paramInt);
    AppMethodBeat.o(115130);
  }
  
  public final void UN(int paramInt)
  {
    AppMethodBeat.i(115151);
    this.Cvg.Cpd.UN(paramInt);
    AppMethodBeat.o(115151);
  }
  
  public final void US(int paramInt)
  {
    AppMethodBeat.i(115123);
    if ((this.CvB == null) || (this.CvB.isEmpty()))
    {
      AppMethodBeat.o(115123);
      return;
    }
    Iterator localIterator = this.CvB.iterator();
    while (localIterator.hasNext())
    {
      a locala = (a)localIterator.next();
      if ((locala != null) && (locala.CvD != null) && (locala.CvD.Gxq == paramInt))
      {
        locala.cancelled = true;
        AppMethodBeat.o(115123);
        return;
      }
    }
    AppMethodBeat.o(115123);
  }
  
  public final void UT(int paramInt)
  {
    AppMethodBeat.i(115134);
    ae.d("MicroMsg.Voip.VoipService", "devin: camera errcode: %d", new Object[] { Integer.valueOf(paramInt) });
    this.Cvg.UT(paramInt);
    AppMethodBeat.o(115134);
  }
  
  public final void UU(int paramInt)
  {
    AppMethodBeat.i(115141);
    v localv = this.Cvg;
    if (localv.ped != null) {
      localv.ped.X(false, paramInt);
    }
    AppMethodBeat.o(115141);
  }
  
  public final void UV(int paramInt)
  {
    AppMethodBeat.i(210109);
    k localk = k.CrE;
    k.a(this.Cvg.Cpd.Csj, paramInt);
    this.Cvg.Cpd.Csj.eBW();
    AppMethodBeat.o(210109);
  }
  
  public final void UW(int paramInt)
  {
    AppMethodBeat.i(210110);
    this.Cvg.UW(paramInt);
    AppMethodBeat.o(210110);
  }
  
  public final int a(byte[] paramArrayOfByte1, int paramInt1, int paramInt2, int paramInt3, int paramInt4, byte[] paramArrayOfByte2, int paramInt5, int paramInt6, int paramInt7, int paramInt8)
  {
    AppMethodBeat.i(210099);
    n localn = this.Cvg.Cpd.Csl;
    if (localn.pcM == n.pcL)
    {
      AppMethodBeat.o(210099);
      return -1;
    }
    if (!localn.Cpd.Csj.eCf())
    {
      AppMethodBeat.o(210099);
      return -1;
    }
    if (!localn.Cpd.ezL())
    {
      AppMethodBeat.o(210099);
      return -2;
    }
    paramInt1 = localn.Cpd.Csj.videoRorate90D(paramArrayOfByte1, paramInt1, paramInt2, paramInt3, paramInt4, paramArrayOfByte2, paramInt5, paramInt6, paramInt7, paramInt8);
    AppMethodBeat.o(210099);
    return paramInt1;
  }
  
  public final int a(byte[] paramArrayOfByte, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int[] paramArrayOfInt, boolean paramBoolean)
  {
    AppMethodBeat.i(115136);
    n localn = this.Cvg.Cpd.Csl;
    int i;
    if (localn.pcM == n.pcL)
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
    if (!localn.Cpd.Csj.eCf())
    {
      AppMethodBeat.o(115136);
      return -1;
    }
    paramInt1 = localn.Cpd.Csj.videoEncodeToLocal(paramArrayOfByte, paramInt1, paramInt3, paramInt4, paramInt2, 0, 75, paramArrayOfInt);
    AppMethodBeat.o(115136);
    return paramInt1;
  }
  
  public final void a(Context paramContext, x paramx)
  {
    AppMethodBeat.i(210090);
    this.Cvg.a(paramContext, paramx);
    AppMethodBeat.o(210090);
  }
  
  public final void a(Context paramContext, String paramString, long paramLong, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3)
  {
    AppMethodBeat.i(210106);
    Context localContext = paramContext;
    if (paramContext == null) {
      localContext = ak.getContext();
    }
    dtg();
    long l = System.currentTimeMillis();
    paramContext = new kg();
    paramContext.dyo.dyr = false;
    paramContext.dyo.dyq = l;
    paramContext.dyo.dyp = localContext;
    com.tencent.mm.sdk.b.a.IvT.l(paramContext);
    ae.m("MicroMsg.Voip.VoipService", "start VideoActivity in foreground,%s", new Object[] { Boolean.valueOf(AppForegroundDelegate.cTA.cBB) });
    int i;
    Intent localIntent;
    RemoteViews localRemoteViews;
    if ((com.tencent.mm.compatible.util.d.lC(28)) || (Build.VERSION.CODENAME.equals("Q")))
    {
      i = 1;
      localIntent = new Intent(localContext, VideoActivity.class);
      localIntent.putExtra("Voip_User", paramString);
      localIntent.putExtra("Voip_Outcall", paramBoolean1);
      localIntent.putExtra("Voip_VideoCall", paramBoolean2);
      localIntent.putExtra("Voip_LastPage_Hash", l);
      localIntent.putExtra("Voip_CallRoomKey", paramLong);
      if ((paramBoolean1) || (i == 0) || (AppForegroundDelegate.cTA.cBB)) {
        break label473;
      }
      this.Cvq = new u.b(this, paramBoolean2, paramString, paramBoolean3, paramLong);
      String str = w.zP(((com.tencent.mm.plugin.messenger.foundation.a.l)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.messenger.foundation.a.l.class)).azF().BH(localIntent.getStringExtra("Voip_User")).field_username);
      localRemoteViews = new RemoteViews(ak.getPackageName(), 2131495877);
      localRemoteViews.setTextViewText(2131302962, str);
      if (!localIntent.getBooleanExtra("Voip_VideoCall", true)) {
        break label430;
      }
      paramContext = ak.getResources().getString(2131764876);
      localRemoteViews.setTextViewText(2131302963, paramContext);
      localRemoteViews.setImageViewResource(2131302957, 2131234460);
      label323:
      localRemoteViews.setImageViewResource(2131306948, 2131234752);
      paramContext = str + paramContext;
    }
    for (;;)
    {
      if (paramBoolean3)
      {
        localIntent.setFlags(603979776);
        localIntent.addFlags(268435456);
      }
      if (localRemoteViews == null)
      {
        a(paramString, paramBoolean2, false, paramLong);
        paramString = com.tencent.mm.plugin.voip.b.e.CCR;
        com.tencent.mm.plugin.voip.b.e.eDj();
      }
      for (;;)
      {
        com.tencent.mm.util.a.a(localContext, localIntent, localRemoteViews, paramContext, VideoActivity.class.getCanonicalName(), com.tencent.mm.bq.a.fcs());
        AppMethodBeat.o(210106);
        return;
        i = 0;
        break;
        label430:
        paramContext = ak.getResources().getString(2131764875);
        localRemoteViews.setTextViewText(2131302963, paramContext);
        localRemoteViews.setImageViewResource(2131302957, 2131234488);
        break label323;
        paramString = com.tencent.mm.plugin.voip.b.e.CCR;
        com.tencent.mm.plugin.voip.b.e.eDi();
      }
      label473:
      paramContext = "";
      localRemoteViews = null;
    }
  }
  
  public final void a(String paramString, boolean paramBoolean1, boolean paramBoolean2, long paramLong)
  {
    AppMethodBeat.i(210107);
    ae.m("MicroMsg.Voip.VoipService", "bindVoipForegroundIfNeed", new Object[0]);
    if ((com.tencent.mm.compatible.util.d.lA(26)) && (!this.Cvx))
    {
      localObject = q.Cup;
      q.eAk();
      localObject = new Intent();
      ((Intent)localObject).putExtra("isRecalled", paramBoolean2);
      ((Intent)localObject).putExtra("Voip_User", paramString);
      ((Intent)localObject).putExtra("Voip_CallRoomKey", paramLong);
      ((Intent)localObject).putExtra("Voip_VideoCall", paramBoolean1);
      ((Intent)localObject).setClass(ak.getContext(), VoipForegroundService.class);
    }
    try
    {
      ak.getContext().startService((Intent)localObject);
      i = 1;
    }
    catch (Exception paramString)
    {
      for (;;)
      {
        int i;
        ae.printErrStackTrace("MicroMsg.Voip.VoipService", paramString, "using start service to bindVoipForegroundIfNeed error: %s", new Object[] { paramString.getMessage() });
        try
        {
          ak.getContext().startForegroundService((Intent)localObject);
          paramString = q.Cup;
          q.eAm();
          i = 0;
        }
        catch (Exception paramString)
        {
          ae.printErrStackTrace("MicroMsg.Voip.VoipService", paramString, "using start foreground service to bindVoipForegroundIfNeed error: %s", new Object[] { paramString.getMessage() });
          i = 0;
        }
      }
    }
    if (i != 0)
    {
      this.Cvx = true;
      paramString = q.Cup;
      q.eAl();
    }
    AppMethodBeat.o(210107);
  }
  
  public final int aEZ(String paramString)
  {
    AppMethodBeat.i(210092);
    int i = this.Cvg.ft(paramString, 1);
    AppMethodBeat.o(210092);
    return i;
  }
  
  public final int aFa(String paramString)
  {
    AppMethodBeat.i(210093);
    int i = this.Cvg.ft(paramString, 0);
    AppMethodBeat.o(210093);
    return i;
  }
  
  public final void aI(final int paramInt, final long paramLong)
  {
    AppMethodBeat.i(115121);
    ar.f(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(115110);
        ae.i("MicroMsg.Voip.VoipService", "onDelayInvite, roomId:%s, roomKey:%s", new Object[] { Integer.valueOf(paramInt), Long.valueOf(paramLong) });
        if ((!com.tencent.mm.n.f.abQ()) && (!u.gG(ak.getContext())))
        {
          ae.i("MicroMsg.Voip.VoipService", "background now and notification Is closed.");
          AppMethodBeat.o(115110);
          return;
        }
        if (u.this.Cvg.eBw())
        {
          ae.i("MicroMsg.Voip.VoipService", "room is ready, ingore the msg and ack busy");
          if ((u.this.Cvg.Cpd.Csj.roomId != paramInt) && (u.this.Cvg.Cpd.Csj.uXg != paramLong))
          {
            ae.i("MicroMsg.Voip.VoipService", "not match current room id and roomkey: %s %s %s %s", new Object[] { Integer.valueOf(paramInt), Long.valueOf(paramLong), Integer.valueOf(u.this.Cvg.Cpd.Csj.roomId), Long.valueOf(u.this.Cvg.Cpd.Csj.uXg) });
            u.this.Cvg.a(paramInt, paramLong, 2, null, null, u.b(u.this));
          }
          AppMethodBeat.o(115110);
          return;
        }
        new com.tencent.mm.plugin.voip.model.a.e(paramInt, paramLong, "").eBO();
        ae.i("MicroMsg.Voip.VoipService", "onDelayInvite, send getroominfo cgi done! roomId:%d, roomKey:%s", new Object[] { Integer.valueOf(paramInt), Long.valueOf(paramLong) });
        if (!u.c(u.this))
        {
          com.tencent.mm.plugin.voip.b.f.c(paramInt, paramLong, 1, 2);
          u.d(u.this);
        }
        AppMethodBeat.o(115110);
      }
    });
    AppMethodBeat.o(115121);
  }
  
  public final void aKI()
  {
    AppMethodBeat.i(115142);
    ae.i("MicroMsg.Voip.VoipService", "unRegister and remove all notification and voip foreground service");
    this.Cvk = false;
    eBn();
    dtg();
    ((com.tencent.mm.plugin.notification.b.a)com.tencent.mm.kernel.g.ad(com.tencent.mm.plugin.notification.b.a.class)).getNotification().cancel(40);
    AppMethodBeat.o(115142);
  }
  
  public final int aNQ()
  {
    AppMethodBeat.i(185953);
    n localn = this.Cvg.Cpd.Csl;
    if (localn.CsS != null)
    {
      int i = localn.CsS.aNQ();
      AppMethodBeat.o(185953);
      return i;
    }
    AppMethodBeat.o(185953);
    return 0;
  }
  
  public final void aT(int paramInt, boolean paramBoolean)
  {
    AppMethodBeat.i(115140);
    v localv = this.Cvg;
    if (localv.ped != null) {
      localv.ped.aU(paramInt, paramBoolean);
    }
    AppMethodBeat.o(115140);
  }
  
  public final void au(boolean paramBoolean1, boolean paramBoolean2)
  {
    AppMethodBeat.i(115116);
    this.Cvv = paramBoolean1;
    this.Cvw = paramBoolean2;
    ae.d("MicroMsg.Voip.VoipService", "isMinimize: %b, miniOnlyHideVoip: %b", new Object[] { Boolean.valueOf(paramBoolean1), Boolean.valueOf(paramBoolean2) });
    AppMethodBeat.o(115116);
  }
  
  public final int av(boolean paramBoolean1, boolean paramBoolean2)
  {
    AppMethodBeat.i(115129);
    int i = this.Cvg.av(paramBoolean1, paramBoolean2);
    AppMethodBeat.o(115129);
    return i;
  }
  
  public final int b(int paramInt1, long paramLong, int paramInt2)
  {
    AppMethodBeat.i(115132);
    paramInt1 = this.Cvg.c(paramInt1, paramLong, paramInt2);
    AppMethodBeat.o(115132);
    return paramInt1;
  }
  
  /* Error */
  public final int b(byte[] paramArrayOfByte, int paramInt, long paramLong)
  {
    // Byte code:
    //   0: ldc_w 1033
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
    //   21: ldc_w 270
    //   24: ldc_w 1035
    //   27: invokestatic 388	com/tencent/mm/sdk/platformtools/ae:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   30: aload_0
    //   31: getfield 154	com/tencent/mm/plugin/voip/model/u:Cvg	Lcom/tencent/mm/plugin/voip/model/v;
    //   34: getfield 319	com/tencent/mm/plugin/voip/model/v:Cpd	Lcom/tencent/mm/plugin/voip/model/l;
    //   37: getfield 1038	com/tencent/mm/plugin/voip/model/l:Csn	[B
    //   40: invokestatic 1040	com/tencent/mm/plugin/voip/model/u:bV	([B)Ljava/util/Map;
    //   43: astore 24
    //   45: aload 24
    //   47: ifnonnull +333 -> 380
    //   50: ldc_w 270
    //   53: ldc_w 1042
    //   56: invokestatic 388	com/tencent/mm/sdk/platformtools/ae:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   59: lconst_0
    //   60: lstore 14
    //   62: ldc_w 270
    //   65: new 426	java/lang/StringBuilder
    //   68: dup
    //   69: ldc_w 1044
    //   72: invokespecial 431	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   75: lload 18
    //   77: invokevirtual 1047	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   80: ldc_w 1049
    //   83: invokevirtual 475	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   86: lload 16
    //   88: invokevirtual 1047	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   91: ldc_w 1051
    //   94: invokevirtual 475	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   97: lload 14
    //   99: invokevirtual 1047	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   102: invokevirtual 438	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   105: invokestatic 388	com/tencent/mm/sdk/platformtools/ae:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   108: new 1053	com/tencent/mm/protocal/protobuf/dzi
    //   111: dup
    //   112: invokespecial 1054	com/tencent/mm/protocal/protobuf/dzi:<init>	()V
    //   115: aload_1
    //   116: invokevirtual 1055	com/tencent/mm/protocal/protobuf/dzi:parseFrom	([B)Lcom/tencent/mm/bw/a;
    //   119: checkcast 1053	com/tencent/mm/protocal/protobuf/dzi
    //   122: astore 24
    //   124: iconst_0
    //   125: istore 5
    //   127: lload 12
    //   129: lstore 6
    //   131: iload 5
    //   133: aload 24
    //   135: getfield 1058	com/tencent/mm/protocal/protobuf/dzi:Ien	Ljava/util/LinkedList;
    //   138: invokevirtual 261	java/util/LinkedList:size	()I
    //   141: if_icmpge +1167 -> 1308
    //   144: aload 24
    //   146: getfield 1058	com/tencent/mm/protocal/protobuf/dzi:Ien	Ljava/util/LinkedList;
    //   149: iload 5
    //   151: invokevirtual 444	java/util/LinkedList:get	(I)Ljava/lang/Object;
    //   154: checkcast 1060	com/tencent/mm/protocal/protobuf/dzh
    //   157: astore 25
    //   159: ldc_w 270
    //   162: new 426	java/lang/StringBuilder
    //   165: dup
    //   166: ldc_w 1062
    //   169: invokespecial 431	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   172: aload 25
    //   174: getfield 1065	com/tencent/mm/protocal/protobuf/dzh:Gru	I
    //   177: invokevirtual 435	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   180: invokevirtual 438	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   183: invokestatic 388	com/tencent/mm/sdk/platformtools/ae:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   186: aload 25
    //   188: getfield 1065	com/tencent/mm/protocal/protobuf/dzh:Gru	I
    //   191: iconst_1
    //   192: if_icmpne +458 -> 650
    //   195: new 1067	com/tencent/mm/protocal/protobuf/eao
    //   198: dup
    //   199: invokespecial 1068	com/tencent/mm/protocal/protobuf/eao:<init>	()V
    //   202: aload 25
    //   204: getfield 1072	com/tencent/mm/protocal/protobuf/dzh:FTj	Lcom/tencent/mm/protocal/protobuf/SKBuiltinBuffer_t;
    //   207: invokevirtual 1077	com/tencent/mm/protocal/protobuf/SKBuiltinBuffer_t:getBufferToBytes	()[B
    //   210: invokevirtual 1078	com/tencent/mm/protocal/protobuf/eao:parseFrom	([B)Lcom/tencent/mm/bw/a;
    //   213: checkcast 1067	com/tencent/mm/protocal/protobuf/eao
    //   216: astore_1
    //   217: aload_1
    //   218: ifnull +412 -> 630
    //   221: ldc_w 270
    //   224: new 426	java/lang/StringBuilder
    //   227: dup
    //   228: ldc_w 1080
    //   231: invokespecial 431	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   234: aload_1
    //   235: getfield 1083	com/tencent/mm/protocal/protobuf/eao:nJb	I
    //   238: invokevirtual 435	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   241: invokevirtual 438	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   244: invokestatic 388	com/tencent/mm/sdk/platformtools/ae:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   247: lload 8
    //   249: lstore 12
    //   251: lload 8
    //   253: aload 25
    //   255: getfield 1084	com/tencent/mm/protocal/protobuf/dzh:yxe	I
    //   258: i2l
    //   259: lcmp
    //   260: ifge +11 -> 271
    //   263: aload 25
    //   265: getfield 1084	com/tencent/mm/protocal/protobuf/dzh:yxe	I
    //   268: i2l
    //   269: lstore 12
    //   271: lload 12
    //   273: lstore 8
    //   275: aload 25
    //   277: getfield 1084	com/tencent/mm/protocal/protobuf/dzh:yxe	I
    //   280: i2l
    //   281: lload 18
    //   283: lcmp
    //   284: ifle +355 -> 639
    //   287: ldc_w 270
    //   290: new 426	java/lang/StringBuilder
    //   293: dup
    //   294: ldc_w 1086
    //   297: invokespecial 431	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   300: aload 25
    //   302: getfield 1084	com/tencent/mm/protocal/protobuf/dzh:yxe	I
    //   305: invokevirtual 435	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   308: ldc_w 1088
    //   311: invokevirtual 475	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   314: lload 18
    //   316: invokevirtual 1047	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   319: ldc_w 1090
    //   322: invokevirtual 475	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   325: aload_1
    //   326: getfield 1083	com/tencent/mm/protocal/protobuf/eao:nJb	I
    //   329: invokevirtual 435	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   332: ldc_w 1092
    //   335: invokevirtual 475	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   338: invokevirtual 438	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   341: invokestatic 388	com/tencent/mm/sdk/platformtools/ae:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   344: aload_0
    //   345: getfield 154	com/tencent/mm/plugin/voip/model/u:Cvg	Lcom/tencent/mm/plugin/voip/model/v;
    //   348: getfield 319	com/tencent/mm/plugin/voip/model/v:Cpd	Lcom/tencent/mm/plugin/voip/model/l;
    //   351: getfield 1096	com/tencent/mm/plugin/voip/model/l:Csm	Lcom/tencent/mm/plugin/voip/model/w;
    //   354: aload_1
    //   355: iconst_1
    //   356: invokevirtual 1101	com/tencent/mm/plugin/voip/model/w:a	(Lcom/tencent/mm/protocal/protobuf/eao;I)V
    //   359: lload 10
    //   361: lstore 22
    //   363: iload 5
    //   365: iconst_1
    //   366: iadd
    //   367: istore 5
    //   369: lload 22
    //   371: lstore 10
    //   373: lload 12
    //   375: lstore 8
    //   377: goto -246 -> 131
    //   380: aload 24
    //   382: invokeinterface 218 1 0
    //   387: invokeinterface 224 1 0
    //   392: astore 25
    //   394: lconst_0
    //   395: lstore 6
    //   397: aload 25
    //   399: invokeinterface 230 1 0
    //   404: ifeq +1137 -> 1541
    //   407: aload 25
    //   409: invokeinterface 234 1 0
    //   414: checkcast 180	java/lang/Integer
    //   417: astore 26
    //   419: aload 24
    //   421: aload 26
    //   423: invokeinterface 244 2 0
    //   428: checkcast 246	java/lang/Long
    //   431: astore 27
    //   433: aload 26
    //   435: invokevirtual 240	java/lang/Integer:intValue	()I
    //   438: tableswitch	default:+26 -> 464, 1:+67->505, 2:+77->515, 3:+87->525
    //   465: aconst_null
    //   466: dconst_0
    //   467: new 426	java/lang/StringBuilder
    //   470: dup
    //   471: ldc_w 1103
    //   474: invokespecial 431	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   477: aload 26
    //   479: invokevirtual 240	java/lang/Integer:intValue	()I
    //   482: invokevirtual 435	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   485: ldc_w 1105
    //   488: invokevirtual 475	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   491: aload 27
    //   493: invokevirtual 1108	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   496: invokevirtual 438	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   499: invokestatic 388	com/tencent/mm/sdk/platformtools/ae:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   502: goto -105 -> 397
    //   505: aload 27
    //   507: invokevirtual 1111	java/lang/Long:longValue	()J
    //   510: lstore 18
    //   512: goto -115 -> 397
    //   515: aload 27
    //   517: invokevirtual 1111	java/lang/Long:longValue	()J
    //   520: lstore 16
    //   522: goto -125 -> 397
    //   525: aload 27
    //   527: invokevirtual 1111	java/lang/Long:longValue	()J
    //   530: lstore 6
    //   532: goto -135 -> 397
    //   535: astore 24
    //   537: ldc_w 270
    //   540: aload 24
    //   542: ldc_w 272
    //   545: iconst_0
    //   546: anewarray 4	java/lang/Object
    //   549: invokestatic 278	com/tencent/mm/sdk/platformtools/ae:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   552: aload_1
    //   553: invokestatic 1113	com/tencent/mm/plugin/voip/model/u:bW	([B)Ljava/lang/String;
    //   556: astore 24
    //   558: ldc_w 270
    //   561: new 426	java/lang/StringBuilder
    //   564: dup
    //   565: ldc_w 1115
    //   568: invokespecial 431	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   571: aload_1
    //   572: arraylength
    //   573: invokevirtual 435	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   576: ldc_w 1117
    //   579: invokevirtual 475	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   582: aload 24
    //   584: invokevirtual 475	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   587: invokevirtual 438	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   590: invokestatic 388	com/tencent/mm/sdk/platformtools/ae:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   593: ldc_w 1033
    //   596: invokestatic 81	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   599: iconst_0
    //   600: ireturn
    //   601: astore_1
    //   602: ldc_w 270
    //   605: ldc_w 1119
    //   608: invokestatic 388	com/tencent/mm/sdk/platformtools/ae:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   611: ldc_w 270
    //   614: aload_1
    //   615: ldc_w 272
    //   618: iconst_0
    //   619: anewarray 4	java/lang/Object
    //   622: invokestatic 278	com/tencent/mm/sdk/platformtools/ae:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   625: aconst_null
    //   626: astore_1
    //   627: goto -410 -> 217
    //   630: ldc_w 270
    //   633: ldc_w 1119
    //   636: invokestatic 388	com/tencent/mm/sdk/platformtools/ae:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   639: lload 10
    //   641: lstore 22
    //   643: lload 8
    //   645: lstore 12
    //   647: goto -284 -> 363
    //   650: aload 25
    //   652: getfield 1065	com/tencent/mm/protocal/protobuf/dzh:Gru	I
    //   655: iconst_2
    //   656: if_icmpne +426 -> 1082
    //   659: new 1121	com/tencent/mm/protocal/protobuf/ead
    //   662: dup
    //   663: invokespecial 1122	com/tencent/mm/protocal/protobuf/ead:<init>	()V
    //   666: aload 25
    //   668: getfield 1072	com/tencent/mm/protocal/protobuf/dzh:FTj	Lcom/tencent/mm/protocal/protobuf/SKBuiltinBuffer_t;
    //   671: invokevirtual 1077	com/tencent/mm/protocal/protobuf/SKBuiltinBuffer_t:getBufferToBytes	()[B
    //   674: invokevirtual 1123	com/tencent/mm/protocal/protobuf/ead:parseFrom	([B)Lcom/tencent/mm/bw/a;
    //   677: checkcast 1121	com/tencent/mm/protocal/protobuf/ead
    //   680: astore_1
    //   681: aload_1
    //   682: ifnull +380 -> 1062
    //   685: ldc_w 270
    //   688: new 426	java/lang/StringBuilder
    //   691: dup
    //   692: ldc_w 1125
    //   695: invokespecial 431	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   698: aload_1
    //   699: getfield 1128	com/tencent/mm/protocal/protobuf/ead:nJA	I
    //   702: invokevirtual 435	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   705: invokevirtual 438	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   708: invokestatic 388	com/tencent/mm/sdk/platformtools/ae:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   711: lload 10
    //   713: lstore 12
    //   715: lload 10
    //   717: aload 25
    //   719: getfield 1084	com/tencent/mm/protocal/protobuf/dzh:yxe	I
    //   722: i2l
    //   723: lcmp
    //   724: ifge +11 -> 735
    //   727: aload 25
    //   729: getfield 1084	com/tencent/mm/protocal/protobuf/dzh:yxe	I
    //   732: i2l
    //   733: lstore 12
    //   735: aload 25
    //   737: getfield 1084	com/tencent/mm/protocal/protobuf/dzh:yxe	I
    //   740: i2l
    //   741: lload 16
    //   743: lcmp
    //   744: ifle +263 -> 1007
    //   747: ldc_w 270
    //   750: new 426	java/lang/StringBuilder
    //   753: dup
    //   754: ldc_w 1130
    //   757: invokespecial 431	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   760: aload 25
    //   762: getfield 1084	com/tencent/mm/protocal/protobuf/dzh:yxe	I
    //   765: invokevirtual 435	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   768: ldc_w 1132
    //   771: invokevirtual 475	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   774: lload 16
    //   776: invokevirtual 1047	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   779: ldc_w 1092
    //   782: invokevirtual 475	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   785: invokevirtual 438	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   788: invokestatic 388	com/tencent/mm/sdk/platformtools/ae:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   791: aload_1
    //   792: getfield 1128	com/tencent/mm/protocal/protobuf/ead:nJA	I
    //   795: iconst_5
    //   796: if_icmpne +57 -> 853
    //   799: aload_0
    //   800: getfield 154	com/tencent/mm/plugin/voip/model/u:Cvg	Lcom/tencent/mm/plugin/voip/model/v;
    //   803: getfield 319	com/tencent/mm/plugin/voip/model/v:Cpd	Lcom/tencent/mm/plugin/voip/model/l;
    //   806: getfield 1096	com/tencent/mm/plugin/voip/model/l:Csm	Lcom/tencent/mm/plugin/voip/model/w;
    //   809: aload_1
    //   810: invokevirtual 1135	com/tencent/mm/plugin/voip/model/w:a	(Lcom/tencent/mm/protocal/protobuf/ead;)V
    //   813: lload 12
    //   815: lstore 22
    //   817: lload 8
    //   819: lstore 12
    //   821: goto -458 -> 363
    //   824: astore_1
    //   825: ldc_w 270
    //   828: ldc_w 1137
    //   831: invokestatic 388	com/tencent/mm/sdk/platformtools/ae:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   834: ldc_w 270
    //   837: aload_1
    //   838: ldc_w 272
    //   841: iconst_0
    //   842: anewarray 4	java/lang/Object
    //   845: invokestatic 278	com/tencent/mm/sdk/platformtools/ae:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   848: aconst_null
    //   849: astore_1
    //   850: goto -169 -> 681
    //   853: aload_1
    //   854: getfield 1128	com/tencent/mm/protocal/protobuf/ead:nJA	I
    //   857: iconst_1
    //   858: if_icmpne +28 -> 886
    //   861: aload_0
    //   862: getfield 154	com/tencent/mm/plugin/voip/model/u:Cvg	Lcom/tencent/mm/plugin/voip/model/v;
    //   865: getfield 319	com/tencent/mm/plugin/voip/model/v:Cpd	Lcom/tencent/mm/plugin/voip/model/l;
    //   868: getfield 1096	com/tencent/mm/plugin/voip/model/l:Csm	Lcom/tencent/mm/plugin/voip/model/w;
    //   871: aload_1
    //   872: invokevirtual 1139	com/tencent/mm/plugin/voip/model/w:b	(Lcom/tencent/mm/protocal/protobuf/ead;)V
    //   875: lload 12
    //   877: lstore 22
    //   879: lload 8
    //   881: lstore 12
    //   883: goto -520 -> 363
    //   886: aload_1
    //   887: getfield 1128	com/tencent/mm/protocal/protobuf/ead:nJA	I
    //   890: bipush 6
    //   892: if_icmpne +78 -> 970
    //   895: aload_1
    //   896: getfield 1140	com/tencent/mm/protocal/protobuf/ead:FTj	Lcom/tencent/mm/protocal/protobuf/SKBuiltinBuffer_t;
    //   899: invokevirtual 1144	com/tencent/mm/protocal/protobuf/SKBuiltinBuffer_t:getBuffer	()Lcom/tencent/mm/bw/b;
    //   902: invokevirtual 1147	com/tencent/mm/bw/b:toByteArray	()[B
    //   905: astore_1
    //   906: new 1149	com/tencent/mm/protocal/protobuf/dzw
    //   909: dup
    //   910: invokespecial 1150	com/tencent/mm/protocal/protobuf/dzw:<init>	()V
    //   913: aload_1
    //   914: invokevirtual 1151	com/tencent/mm/protocal/protobuf/dzw:parseFrom	([B)Lcom/tencent/mm/bw/a;
    //   917: checkcast 1149	com/tencent/mm/protocal/protobuf/dzw
    //   920: astore_1
    //   921: aload_1
    //   922: ifnull +17 -> 939
    //   925: aload_0
    //   926: getfield 154	com/tencent/mm/plugin/voip/model/u:Cvg	Lcom/tencent/mm/plugin/voip/model/v;
    //   929: getfield 319	com/tencent/mm/plugin/voip/model/v:Cpd	Lcom/tencent/mm/plugin/voip/model/l;
    //   932: getfield 1096	com/tencent/mm/plugin/voip/model/l:Csm	Lcom/tencent/mm/plugin/voip/model/w;
    //   935: aload_1
    //   936: invokevirtual 1154	com/tencent/mm/plugin/voip/model/w:a	(Lcom/tencent/mm/protocal/protobuf/dzw;)V
    //   939: lload 12
    //   941: lstore 22
    //   943: lload 8
    //   945: lstore 12
    //   947: goto -584 -> 363
    //   950: astore_1
    //   951: ldc_w 270
    //   954: aload_1
    //   955: ldc_w 272
    //   958: iconst_0
    //   959: anewarray 4	java/lang/Object
    //   962: invokestatic 278	com/tencent/mm/sdk/platformtools/ae:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   965: aconst_null
    //   966: astore_1
    //   967: goto -46 -> 921
    //   970: ldc_w 270
    //   973: new 426	java/lang/StringBuilder
    //   976: dup
    //   977: ldc_w 1156
    //   980: invokespecial 431	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   983: aload_1
    //   984: getfield 1128	com/tencent/mm/protocal/protobuf/ead:nJA	I
    //   987: invokevirtual 435	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   990: invokevirtual 438	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   993: invokestatic 388	com/tencent/mm/sdk/platformtools/ae:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   996: lload 12
    //   998: lstore 22
    //   1000: lload 8
    //   1002: lstore 12
    //   1004: goto -641 -> 363
    //   1007: ldc_w 270
    //   1010: new 426	java/lang/StringBuilder
    //   1013: dup
    //   1014: ldc_w 1158
    //   1017: invokespecial 431	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   1020: aload 25
    //   1022: getfield 1084	com/tencent/mm/protocal/protobuf/dzh:yxe	I
    //   1025: invokevirtual 435	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1028: ldc_w 1160
    //   1031: invokevirtual 475	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1034: lload 16
    //   1036: invokevirtual 1047	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   1039: ldc_w 1092
    //   1042: invokevirtual 475	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1045: invokevirtual 438	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1048: invokestatic 388	com/tencent/mm/sdk/platformtools/ae:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   1051: lload 12
    //   1053: lstore 22
    //   1055: lload 8
    //   1057: lstore 12
    //   1059: goto -696 -> 363
    //   1062: ldc_w 270
    //   1065: ldc_w 1137
    //   1068: invokestatic 388	com/tencent/mm/sdk/platformtools/ae:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   1071: lload 10
    //   1073: lstore 22
    //   1075: lload 8
    //   1077: lstore 12
    //   1079: goto -716 -> 363
    //   1082: aload 25
    //   1084: getfield 1065	com/tencent/mm/protocal/protobuf/dzh:Gru	I
    //   1087: iconst_3
    //   1088: if_icmpne +442 -> 1530
    //   1091: new 1074	com/tencent/mm/protocal/protobuf/SKBuiltinBuffer_t
    //   1094: dup
    //   1095: invokespecial 1161	com/tencent/mm/protocal/protobuf/SKBuiltinBuffer_t:<init>	()V
    //   1098: aload 25
    //   1100: getfield 1072	com/tencent/mm/protocal/protobuf/dzh:FTj	Lcom/tencent/mm/protocal/protobuf/SKBuiltinBuffer_t;
    //   1103: invokevirtual 1077	com/tencent/mm/protocal/protobuf/SKBuiltinBuffer_t:getBufferToBytes	()[B
    //   1106: invokevirtual 1164	com/tencent/mm/protocal/protobuf/SKBuiltinBuffer_t:parseFrom	([B)Lcom/tencent/mm/protocal/protobuf/SKBuiltinBuffer_t;
    //   1109: astore_1
    //   1110: aload_1
    //   1111: ifnull +419 -> 1530
    //   1114: lload 6
    //   1116: aload 25
    //   1118: getfield 1084	com/tencent/mm/protocal/protobuf/dzh:yxe	I
    //   1121: i2l
    //   1122: lcmp
    //   1123: ifge +400 -> 1523
    //   1126: aload 25
    //   1128: getfield 1084	com/tencent/mm/protocal/protobuf/dzh:yxe	I
    //   1131: i2l
    //   1132: lstore 20
    //   1134: lload 20
    //   1136: lstore 6
    //   1138: lload 10
    //   1140: lstore 22
    //   1142: lload 8
    //   1144: lstore 12
    //   1146: aload 25
    //   1148: getfield 1084	com/tencent/mm/protocal/protobuf/dzh:yxe	I
    //   1151: i2l
    //   1152: lload 14
    //   1154: lcmp
    //   1155: ifle -792 -> 363
    //   1158: ldc_w 270
    //   1161: new 426	java/lang/StringBuilder
    //   1164: dup
    //   1165: ldc_w 1166
    //   1168: invokespecial 431	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   1171: aload 25
    //   1173: getfield 1084	com/tencent/mm/protocal/protobuf/dzh:yxe	I
    //   1176: invokevirtual 435	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1179: ldc_w 1168
    //   1182: invokevirtual 475	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1185: lload 14
    //   1187: invokevirtual 1047	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   1190: ldc_w 1092
    //   1193: invokevirtual 475	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1196: invokevirtual 438	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1199: invokestatic 388	com/tencent/mm/sdk/platformtools/ae:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   1202: aload_0
    //   1203: getfield 154	com/tencent/mm/plugin/voip/model/u:Cvg	Lcom/tencent/mm/plugin/voip/model/v;
    //   1206: getfield 319	com/tencent/mm/plugin/voip/model/v:Cpd	Lcom/tencent/mm/plugin/voip/model/l;
    //   1209: getfield 1096	com/tencent/mm/plugin/voip/model/l:Csm	Lcom/tencent/mm/plugin/voip/model/w;
    //   1212: aload_1
    //   1213: invokevirtual 1171	com/tencent/mm/plugin/voip/model/w:c	(Lcom/tencent/mm/protocal/protobuf/SKBuiltinBuffer_t;)V
    //   1216: lload 20
    //   1218: lstore 6
    //   1220: lload 10
    //   1222: lstore 22
    //   1224: lload 8
    //   1226: lstore 12
    //   1228: aload_0
    //   1229: getfield 122	com/tencent/mm/plugin/voip/model/u:Cvy	Lcom/tencent/mm/protocal/protobuf/dzm;
    //   1232: ifnull -869 -> 363
    //   1235: lload 20
    //   1237: lstore 6
    //   1239: lload 10
    //   1241: lstore 22
    //   1243: lload 8
    //   1245: lstore 12
    //   1247: aload_1
    //   1248: invokevirtual 1144	com/tencent/mm/protocal/protobuf/SKBuiltinBuffer_t:getBuffer	()Lcom/tencent/mm/bw/b;
    //   1251: invokevirtual 1147	com/tencent/mm/bw/b:toByteArray	()[B
    //   1254: invokestatic 1177	com/tencent/mm/plugin/voip/b/f:bY	([B)I
    //   1257: sipush 255
    //   1260: iand
    //   1261: iconst_1
    //   1262: if_icmpne -899 -> 363
    //   1265: aload_0
    //   1266: getfield 122	com/tencent/mm/plugin/voip/model/u:Cvy	Lcom/tencent/mm/protocal/protobuf/dzm;
    //   1269: iconst_1
    //   1270: putfield 299	com/tencent/mm/protocal/protobuf/dzm:Iel	I
    //   1273: lload 20
    //   1275: lstore 6
    //   1277: lload 10
    //   1279: lstore 22
    //   1281: lload 8
    //   1283: lstore 12
    //   1285: goto -922 -> 363
    //   1288: astore_1
    //   1289: ldc_w 270
    //   1292: aload_1
    //   1293: ldc_w 272
    //   1296: iconst_0
    //   1297: anewarray 4	java/lang/Object
    //   1300: invokestatic 278	com/tencent/mm/sdk/platformtools/ae:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   1303: aconst_null
    //   1304: astore_1
    //   1305: goto -195 -> 1110
    //   1308: lload 8
    //   1310: lload 18
    //   1312: lcmp
    //   1313: ifle +203 -> 1516
    //   1316: lload 10
    //   1318: lload 16
    //   1320: lcmp
    //   1321: ifle +188 -> 1509
    //   1324: lload 6
    //   1326: lload 14
    //   1328: lcmp
    //   1329: ifle +173 -> 1502
    //   1332: new 99	java/util/HashMap
    //   1335: dup
    //   1336: invokespecial 100	java/util/HashMap:<init>	()V
    //   1339: astore_1
    //   1340: aload_1
    //   1341: iconst_1
    //   1342: invokestatic 184	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   1345: lload 8
    //   1347: invokestatic 449	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   1350: invokeinterface 453 3 0
    //   1355: pop
    //   1356: aload_1
    //   1357: iconst_2
    //   1358: invokestatic 184	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   1361: lload 10
    //   1363: invokestatic 449	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   1366: invokeinterface 453 3 0
    //   1371: pop
    //   1372: aload_1
    //   1373: iconst_3
    //   1374: invokestatic 184	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   1377: lload 6
    //   1379: invokestatic 449	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   1382: invokeinterface 453 3 0
    //   1387: pop
    //   1388: aload_1
    //   1389: invokestatic 1179	com/tencent/mm/plugin/voip/model/u:aX	(Ljava/util/Map;)[B
    //   1392: astore_1
    //   1393: iload_2
    //   1394: aload_0
    //   1395: getfield 154	com/tencent/mm/plugin/voip/model/u:Cvg	Lcom/tencent/mm/plugin/voip/model/v;
    //   1398: getfield 319	com/tencent/mm/plugin/voip/model/v:Cpd	Lcom/tencent/mm/plugin/voip/model/l;
    //   1401: getfield 355	com/tencent/mm/plugin/voip/model/l:Csj	Lcom/tencent/mm/plugin/voip/model/v2protocal;
    //   1404: getfield 394	com/tencent/mm/plugin/voip/model/v2protocal:roomId	I
    //   1407: if_icmpne +78 -> 1485
    //   1410: lload_3
    //   1411: aload_0
    //   1412: getfield 154	com/tencent/mm/plugin/voip/model/u:Cvg	Lcom/tencent/mm/plugin/voip/model/v;
    //   1415: getfield 319	com/tencent/mm/plugin/voip/model/v:Cpd	Lcom/tencent/mm/plugin/voip/model/l;
    //   1418: getfield 355	com/tencent/mm/plugin/voip/model/l:Csj	Lcom/tencent/mm/plugin/voip/model/v2protocal;
    //   1421: getfield 397	com/tencent/mm/plugin/voip/model/v2protocal:uXg	J
    //   1424: lcmp
    //   1425: ifne +60 -> 1485
    //   1428: aload_0
    //   1429: getfield 154	com/tencent/mm/plugin/voip/model/u:Cvg	Lcom/tencent/mm/plugin/voip/model/v;
    //   1432: getfield 319	com/tencent/mm/plugin/voip/model/v:Cpd	Lcom/tencent/mm/plugin/voip/model/l;
    //   1435: aload_1
    //   1436: putfield 1038	com/tencent/mm/plugin/voip/model/l:Csn	[B
    //   1439: ldc_w 270
    //   1442: new 426	java/lang/StringBuilder
    //   1445: dup
    //   1446: ldc_w 1181
    //   1449: invokespecial 431	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   1452: lload 8
    //   1454: invokevirtual 1047	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   1457: ldc_w 1183
    //   1460: invokevirtual 475	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1463: lload 10
    //   1465: invokevirtual 1047	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   1468: ldc_w 1183
    //   1471: invokevirtual 475	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1474: lload 6
    //   1476: invokevirtual 1047	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   1479: invokevirtual 438	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1482: invokestatic 388	com/tencent/mm/sdk/platformtools/ae:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   1485: ldc_w 270
    //   1488: ldc_w 1185
    //   1491: invokestatic 388	com/tencent/mm/sdk/platformtools/ae:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   1494: ldc_w 1033
    //   1497: invokestatic 81	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   1500: iconst_0
    //   1501: ireturn
    //   1502: lload 14
    //   1504: lstore 6
    //   1506: goto -174 -> 1332
    //   1509: lload 16
    //   1511: lstore 10
    //   1513: goto -189 -> 1324
    //   1516: lload 18
    //   1518: lstore 8
    //   1520: goto -204 -> 1316
    //   1523: lload 6
    //   1525: lstore 20
    //   1527: goto -393 -> 1134
    //   1530: lload 10
    //   1532: lstore 22
    //   1534: lload 8
    //   1536: lstore 12
    //   1538: goto -1175 -> 363
    //   1541: lload 6
    //   1543: lstore 14
    //   1545: goto -1483 -> 62
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	1548	0	this	u
    //   0	1548	1	paramArrayOfByte	byte[]
    //   0	1548	2	paramInt	int
    //   0	1548	3	paramLong	long
    //   125	243	5	i	int
    //   129	1413	6	l1	long
    //   13	1522	8	l2	long
    //   16	1515	10	l3	long
    //   19	1518	12	l4	long
    //   60	1484	14	l5	long
    //   10	1500	16	l6	long
    //   7	1510	18	l7	long
    //   1132	394	20	l8	long
    //   361	1172	22	l9	long
    //   43	377	24	localObject1	Object
    //   535	6	24	localException	Exception
    //   556	27	24	str	String
    //   157	1015	25	localObject2	Object
    //   417	61	26	localInteger	Integer
    //   431	95	27	localLong	Long
    // Exception table:
    //   from	to	target	type
    //   108	124	535	java/lang/Exception
    //   195	217	601	java/io/IOException
    //   659	681	824	java/io/IOException
    //   906	921	950	java/io/IOException
    //   1091	1110	1288	java/io/IOException
  }
  
  public final void b(Context paramContext, x paramx)
  {
    AppMethodBeat.i(210091);
    this.Cvg.b(paramContext, paramx);
    AppMethodBeat.o(210091);
  }
  
  public final void bs(Context paramContext, String paramString)
  {
    AppMethodBeat.i(115117);
    ae.i("MicroMsg.Voip.VoipService", "startVoiceCall, toUser:".concat(String.valueOf(paramString)));
    if ((bu.isNullOrNil(paramString)) || ((System.currentTimeMillis() - this.Cvl < 2000L) && (System.currentTimeMillis() - this.Cvl > 0L)))
    {
      AppMethodBeat.o(115117);
      return;
    }
    if ((System.currentTimeMillis() - this.Cvo < this.Cvp) && (System.currentTimeMillis() - this.Cvo > 0L))
    {
      ae.i("MicroMsg.Voip.VoipService", "fail! cuz overloadInterval fail!");
      h.a(paramContext, 2131764916, 2131764950, null);
      AppMethodBeat.o(115117);
      return;
    }
    this.Cvl = System.currentTimeMillis();
    if (((com.tencent.mm.plugin.messenger.foundation.a.l)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.messenger.foundation.a.l.class)).azF().BH(paramString) == null)
    {
      AppMethodBeat.o(115117);
      return;
    }
    a(paramContext, paramString, this.Cvg.Cpd.Csj.uXg, true, false, false);
    eBa();
    AppMethodBeat.o(115117);
  }
  
  public final void bt(Context paramContext, String paramString)
  {
    AppMethodBeat.i(115118);
    ae.i("MicroMsg.Voip.VoipService", "startVideoCall, toUser:".concat(String.valueOf(paramString)));
    if ((bu.isNullOrNil(paramString)) || ((System.currentTimeMillis() - this.Cvl < 2000L) && (System.currentTimeMillis() - this.Cvl > 0L)))
    {
      AppMethodBeat.o(115118);
      return;
    }
    if ((System.currentTimeMillis() - this.Cvo < this.Cvp) && (System.currentTimeMillis() - this.Cvo > 0L))
    {
      ae.i("MicroMsg.Voip.VoipService", "fail! cuz overloadInterval fail!");
      h.a(paramContext, 2131764916, 2131764950, null);
      AppMethodBeat.o(115118);
      return;
    }
    this.Cvl = System.currentTimeMillis();
    if (((com.tencent.mm.plugin.messenger.foundation.a.l)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.messenger.foundation.a.l.class)).azF().BH(paramString) == null)
    {
      AppMethodBeat.o(115118);
      return;
    }
    a(paramContext, paramString, this.Cvg.Cpd.Csj.uXg, true, true, false);
    eBa();
    AppMethodBeat.o(115118);
  }
  
  public final int c(ByteBuffer paramByteBuffer, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5)
  {
    AppMethodBeat.i(210102);
    paramInt1 = this.Cvg.c(paramByteBuffer, paramInt1, paramInt2, paramInt3, paramInt4, paramInt5);
    AppMethodBeat.o(210102);
    return paramInt1;
  }
  
  public final int c(byte[] paramArrayOfByte, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    AppMethodBeat.i(210100);
    paramInt1 = this.Cvg.c(paramArrayOfByte, paramInt1, paramInt2, paramInt3, paramInt4);
    AppMethodBeat.o(210100);
    return paramInt1;
  }
  
  public final void c(dzm paramdzm)
  {
    AppMethodBeat.i(115122);
    if (this.Cvg.Cpd.Csj.CyI != 0)
    {
      ae.i("MicroMsg.Voip.VoipService", "steve:[simucall]doTaskCallin simulcall already processed, return! VoipGetRoomInfoResp roomid:%d, roomType:%d, mProtocol.roomId:%d, iSimulCallStatus:%d ", new Object[] { Integer.valueOf(paramdzm.Gxq), Integer.valueOf(paramdzm.Iel), Integer.valueOf(this.Cvg.Cpd.Csj.roomId), Integer.valueOf(this.Cvg.Cpd.Csj.CyI) });
      AppMethodBeat.o(115122);
      return;
    }
    int j = paramdzm.Iel;
    boolean bool = ((com.tencent.mm.plugin.expt.b.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.qDO, false);
    ae.i("MicroMsg.Voip.VoipService", "steve:[simucall]doTaskCallin bNewSimulCallSwitch:%b ", new Object[] { Boolean.valueOf(bool) });
    int i = -1;
    if (bool) {
      i = b(paramdzm);
    }
    if (i == 1)
    {
      this.Cvg.a(paramdzm.Gxq, paramdzm.Gxr, 5, null, null, paramdzm.Ieu);
      ae.i("MicroMsg.Voip.VoipService", "steve:[simucall]doTaskCallin simulcall caller send ack roomid:%d, finalRoomType:%d, orgRoomType:%d ", new Object[] { Integer.valueOf(paramdzm.Gxq), Integer.valueOf(paramdzm.Iel), Integer.valueOf(j) });
      com.tencent.mm.plugin.report.service.g.yxI.a(11525, true, true, new Object[] { Integer.valueOf(paramdzm.Gxq), Long.valueOf(paramdzm.Gxr), Integer.valueOf(j), Integer.valueOf(6), Integer.valueOf(com.tencent.mm.plugin.voip.b.f.getNetType(ak.getContext())), Long.valueOf(System.currentTimeMillis()) });
      AppMethodBeat.o(115122);
      return;
    }
    if ((!com.tencent.mm.n.f.abQ()) && (!cJ(ak.getContext())))
    {
      ae.i("MicroMsg.Voip.VoipService", "NotificationConfig.isNewVoipMsgNotification() is false and is not in foreground, now return.");
      if ((this.Cvy == null) && (this.wrr.foU()))
      {
        ae.i("MicroMsg.Voip.VoipService", "voipGetRoomInfoResp is null and time is stopped.");
        this.Cvy = paramdzm;
        this.wrr.ay(2000L, 2000L);
        this.Cvz = System.currentTimeMillis();
        ae.i("MicroMsg.Voip.VoipService", "steve:voip roominfo stored!! roomid:%d, roomkey:%s, time:%d", new Object[] { Integer.valueOf(this.Cvy.Gxq), Long.valueOf(this.Cvy.Gxr), Integer.valueOf(this.Cvy.CreateTime) });
        com.tencent.mm.plugin.report.service.g.yxI.idkeyStat(500L, 4L, 1L, false);
        com.tencent.mm.plugin.voip.b.f.Vl(0);
      }
      AppMethodBeat.o(115122);
      return;
    }
    String str = paramdzm.Ieu;
    Object localObject = com.tencent.mm.model.v.aAC();
    i = paramdzm.Iel;
    ae.i("MicroMsg.Voip.VoipService", "doTaskCallin self:%s talker:%s type:%d roomid:%d, roomkey:%s, time:%d", new Object[] { localObject, str, Integer.valueOf(i), Integer.valueOf(paramdzm.Gxq), Long.valueOf(paramdzm.Gxr), Integer.valueOf(paramdzm.CreateTime) });
    if ((this.Cvg.ezD()) && (!this.Cvg.CvQ))
    {
      this.Cvg.a(paramdzm.Gxq, paramdzm.Gxr, 2, null, null, str);
      ae.i("MicroMsg.Voip.VoipService", "doTaskCallin invite ignor because voip busy:roomid " + paramdzm.Gxq);
      com.tencent.mm.plugin.report.service.g.yxI.a(11525, true, true, new Object[] { Integer.valueOf(paramdzm.Gxq), Long.valueOf(paramdzm.Gxr), Integer.valueOf(paramdzm.Iel), Integer.valueOf(2), Integer.valueOf(com.tencent.mm.plugin.voip.b.f.getNetType(ak.getContext())), Long.valueOf(System.currentTimeMillis()) });
      com.tencent.mm.plugin.report.service.g.yxI.a(11526, true, true, new Object[] { Integer.valueOf(com.tencent.mm.plugin.voip.c.eys().Cvg.Cpd.Csj.roomId), Long.valueOf(com.tencent.mm.plugin.voip.c.eys().Cvg.Cpd.Csj.uXg), Long.valueOf(com.tencent.mm.plugin.voip.c.eys().Cvg.Cpd.ezE()), Integer.valueOf(7) });
      com.tencent.mm.plugin.voip.b.f.Vl(0);
      AppMethodBeat.o(115122);
      return;
    }
    if (v.eBy())
    {
      this.Cvg.a(paramdzm.Gxq, paramdzm.Gxr, 3, null, null, str);
      ae.e("MicroMsg.Voip.VoipService", "doTaskCallin invite ignor because telephone busy:roomid " + paramdzm.Gxq);
      com.tencent.mm.plugin.report.service.g.yxI.a(11525, true, true, new Object[] { Integer.valueOf(paramdzm.Gxq), Long.valueOf(paramdzm.Gxr), Integer.valueOf(paramdzm.Iel), Integer.valueOf(3), Integer.valueOf(com.tencent.mm.plugin.voip.b.f.getNetType(ak.getContext())), Long.valueOf(System.currentTimeMillis()) });
      com.tencent.mm.plugin.report.service.g.yxI.a(11526, true, true, new Object[] { Integer.valueOf(com.tencent.mm.plugin.voip.c.eys().Cvg.Cpd.Csj.roomId), Long.valueOf(com.tencent.mm.plugin.voip.c.eys().Cvg.Cpd.Csj.uXg), Long.valueOf(com.tencent.mm.plugin.voip.c.eys().Cvg.Cpd.ezE()), Integer.valueOf(7) });
      com.tencent.mm.plugin.voip.b.f.Vl(0);
      AppMethodBeat.o(115122);
      return;
    }
    this.Cvg.eBz();
    if (this.Cvg.CvS)
    {
      if (this.Cvg.Cpd.Csj.roomId != paramdzm.Gxq)
      {
        this.Cvg.Cpd.CrJ = true;
        this.Cvg.Cpd.CrL = false;
        this.Cvg.Cpd.CrK = false;
        this.Cvg.Cpd.Csj.Cxw = 0;
        this.Cvg.Cpd.Csj.Cxv = 0;
        this.Cvg.Cpd.setStatus(3);
        this.Cvg.Cpd.Csj.roomId = paramdzm.Gxq;
        this.Cvg.Cpd.Csj.uXg = paramdzm.Gxr;
        this.Cvg.Cpd.Csj.uXn = 1;
        this.Cvg.Cpd.Csk.Uz(i);
      }
      ae.i("MicroMsg.Voip.VoipService", "steve:[simucall]doTaskCallin simulcall auto-accept! mProtocol.roomId=%d, roomInfo.roomId=%d", new Object[] { Integer.valueOf(this.Cvg.Cpd.Csj.roomId), Integer.valueOf(paramdzm.Gxq) });
      AppMethodBeat.o(115122);
      return;
    }
    if (!this.Cvg.a(paramdzm))
    {
      ae.e("MicroMsg.Voip.VoipService", "doTaskCallin setInviteContent failed!");
      com.tencent.mm.plugin.report.service.g.yxI.a(11525, true, true, new Object[] { Integer.valueOf(paramdzm.Gxq), Long.valueOf(paramdzm.Gxr), Integer.valueOf(paramdzm.Iel), Integer.valueOf(5), Integer.valueOf(com.tencent.mm.plugin.voip.b.f.getNetType(ak.getContext())), Long.valueOf(System.currentTimeMillis()) });
      com.tencent.mm.plugin.report.service.g.yxI.a(11526, true, true, new Object[] { Integer.valueOf(com.tencent.mm.plugin.voip.c.eys().Cvg.Cpd.Csj.roomId), Long.valueOf(com.tencent.mm.plugin.voip.c.eys().Cvg.Cpd.Csj.uXg), Long.valueOf(com.tencent.mm.plugin.voip.c.eys().Cvg.Cpd.ezE()), Integer.valueOf(7) });
      com.tencent.mm.plugin.voip.b.f.Vl(0);
      AppMethodBeat.o(115122);
      return;
    }
    localObject = ak.getContext();
    if (((com.tencent.mm.plugin.messenger.foundation.a.l)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.messenger.foundation.a.l.class)).azF().BH(str) == null)
    {
      this.Cvg.a(paramdzm.Gxq, paramdzm.Gxr, 4, null, null, str);
      ae.d("MicroMsg.Voip.VoipService", "doTaskCallin invite ignor because talker nil:roomid " + paramdzm.Gxq);
      com.tencent.mm.plugin.report.service.g.yxI.a(11525, true, true, new Object[] { Integer.valueOf(paramdzm.Gxq), Long.valueOf(paramdzm.Gxr), Integer.valueOf(paramdzm.Iel), Integer.valueOf(4), Integer.valueOf(com.tencent.mm.plugin.voip.b.f.getNetType(ak.getContext())), Long.valueOf(System.currentTimeMillis()) });
      com.tencent.mm.plugin.report.service.g.yxI.a(11526, true, true, new Object[] { Integer.valueOf(com.tencent.mm.plugin.voip.c.eys().Cvg.Cpd.Csj.roomId), Long.valueOf(com.tencent.mm.plugin.voip.c.eys().Cvg.Cpd.Csj.uXg), Long.valueOf(com.tencent.mm.plugin.voip.c.eys().Cvg.Cpd.ezE()), Integer.valueOf(7) });
      com.tencent.mm.plugin.voip.b.f.Vl(0);
      AppMethodBeat.o(115122);
      return;
    }
    if ((1 == i) || (i == 0)) {}
    for (;;)
    {
      try
      {
        long l = this.Cvg.Cpd.Csj.uXg;
        if (i != 0) {
          continue;
        }
        bool = true;
        a((Context)localObject, str, l, false, bool, true);
        if (this.Cvg != null) {
          this.Cvg.UY(paramdzm.Gxq);
        }
        ae.d("MicroMsg.Voip.VoipService", "doTaskCallin invite startActivity VideoActivity");
      }
      catch (Exception localException)
      {
        com.tencent.mm.plugin.voip.b.f.Vl(2);
        continue;
      }
      this.Cvg.a(paramdzm.Gxq, paramdzm.Gxr, 1, this.Cvg.Cpd.Csj.field_peerId, this.Cvg.Cpd.Csj.field_capInfo, str);
      com.tencent.mm.plugin.report.service.g.yxI.a(11525, true, true, new Object[] { Integer.valueOf(paramdzm.Gxq), Long.valueOf(paramdzm.Gxr), Integer.valueOf(paramdzm.Iel), Integer.valueOf(1), Integer.valueOf(com.tencent.mm.plugin.voip.b.f.getNetType(ak.getContext())), Long.valueOf(System.currentTimeMillis()) });
      AppMethodBeat.o(115122);
      return;
      bool = false;
    }
  }
  
  public final void c(boolean paramBoolean1, boolean paramBoolean2, String paramString)
  {
    AppMethodBeat.i(115115);
    ae.i("MicroMsg.Voip.VoipService", "setCalling " + paramBoolean1 + "  videoCall " + paramBoolean2 + "username " + paramString);
    this.dgR = paramBoolean1;
    if (paramBoolean2)
    {
      this.Cvi = paramBoolean1;
      this.Cvg.Cpd.Csj.CwV = 0;
    }
    for (;;)
    {
      this.talker = paramString;
      this.Cvg.Cpd.Csj.CyH.iKD = paramString;
      AppMethodBeat.o(115115);
      return;
      this.Cvg.Cpd.Csj.CwV = 1;
      this.Cvj = paramBoolean1;
    }
  }
  
  public final boolean cbt()
  {
    AppMethodBeat.i(224117);
    boolean bool = this.Cvg.cbt();
    AppMethodBeat.o(224117);
    return bool;
  }
  
  public final void dtg()
  {
    AppMethodBeat.i(162308);
    this.Cvq = null;
    ((com.tencent.mm.plugin.notification.b.a)com.tencent.mm.kernel.g.ad(com.tencent.mm.plugin.notification.b.a.class)).getNotification().cancel(41);
    AppMethodBeat.o(162308);
  }
  
  public final int eBb()
  {
    AppMethodBeat.i(210094);
    this.Cvg.eBb();
    AppMethodBeat.o(210094);
    return 0;
  }
  
  public final int eBc()
  {
    AppMethodBeat.i(210095);
    this.Cvg.eBc();
    AppMethodBeat.o(210095);
    return 0;
  }
  
  public final int eBd()
  {
    return this.Cvg.Cpd.Csj.roomId;
  }
  
  public final long eBe()
  {
    return this.Cvg.Cpd.Csj.uXg;
  }
  
  public final void eBf()
  {
    AppMethodBeat.i(210097);
    n localn = this.Cvg.Cpd.Csl;
    if (localn.pcI != null) {
      localn.pcI.cw(true);
    }
    AppMethodBeat.o(210097);
  }
  
  public final void eBg()
  {
    AppMethodBeat.i(210098);
    n localn = this.Cvg.Cpd.Csl;
    if (localn.pcI != null) {
      localn.pcI.cw(false);
    }
    AppMethodBeat.o(210098);
  }
  
  public final void eBh()
  {
    AppMethodBeat.i(115135);
    ae.d("MicroMsg.Voip.VoipService", "devin: setCallResult: %d", new Object[] { Integer.valueOf(1) });
    this.Cvg.Cpd.Csj.CyH.CtF = 1;
    AppMethodBeat.o(115135);
  }
  
  public final void eBi()
  {
    AppMethodBeat.i(210101);
    Object localObject = this.Cvg.Cpd.Csl;
    com.tencent.mm.plugin.voip.b.d locald = com.tencent.mm.plugin.voip.b.d.CCN;
    if (com.tencent.mm.plugin.voip.b.d.eDe())
    {
      if ((((n)localObject).Cpd.Csj != null) && (((n)localObject).Cpd.Csj.CyK != null))
      {
        ((n)localObject).Cpd.Csj.CyK.eyC();
        AppMethodBeat.o(210101);
        return;
      }
      localObject = com.tencent.mm.plugin.voip.b.d.CCN;
      com.tencent.mm.plugin.voip.b.d.clear();
    }
    AppMethodBeat.o(210101);
  }
  
  public final int eBj()
  {
    return this.Cvg.Cpd.Csl.Cpd.Csj.field_sendVideoLen;
  }
  
  public final int eBk()
  {
    return this.Cvg.Cpd.Csl.Cpd.Csj.field_recvVideoLen;
  }
  
  public final byte[] eBl()
  {
    return this.Cvg.Cpd.Csj.Cyb;
  }
  
  public final boolean eBm()
  {
    bool2 = false;
    AppMethodBeat.i(115143);
    bool1 = bool2;
    try
    {
      if (this.Cvg.Cpd.Csj != null)
      {
        int i = this.Cvg.Cpd.Csj.CxB;
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
        ae.e("MicroMsg.Voip.VoipService", "steve:cannot get CPU usage! error: " + localException.getMessage());
        bool1 = bool2;
      }
    }
    AppMethodBeat.o(115143);
    return bool1;
  }
  
  public final void eBo()
  {
    AppMethodBeat.i(210108);
    this.Cvh = null;
    this.Cvr = null;
    this.Cvs = false;
    this.Cvu = false;
    this.Cvt = false;
    this.CvA = false;
    com.tencent.mm.plugin.voip.c.eyt().rm(true);
    AppMethodBeat.o(210108);
  }
  
  public final void eBp()
  {
    AppMethodBeat.i(115149);
    this.Cvg.CvX.ay(1000L, 1000L);
    AppMethodBeat.o(115149);
  }
  
  public final int eBq()
  {
    return this.Cvg.Cpd.Csj.CwU;
  }
  
  public final void eBr()
  {
    AppMethodBeat.i(115152);
    this.Cvg.Cpd.Csl.ezZ();
    AppMethodBeat.o(115152);
  }
  
  public final boolean eBs()
  {
    AppMethodBeat.i(210111);
    boolean bool = this.Cvg.Cpd.Csx.eAY();
    AppMethodBeat.o(210111);
    return bool;
  }
  
  public final void eBt()
  {
    AppMethodBeat.i(210112);
    this.Cvg.Cpd.Csx = new VoipScoreState();
    AppMethodBeat.o(210112);
  }
  
  public final VoipScoreState eBu()
  {
    return this.Cvg.Cpd.Csx;
  }
  
  public final long ezE()
  {
    AppMethodBeat.i(224115);
    long l = this.Cvg.Cpd.ezE();
    AppMethodBeat.o(224115);
    return l;
  }
  
  protected final void finalize()
  {
    AppMethodBeat.i(115114);
    this.Cvg.stop();
    this.Cvg = null;
    this.Cvk = false;
    com.tencent.mm.kernel.g.ajQ().b(this.BEN);
    super.finalize();
    AppMethodBeat.o(115114);
  }
  
  public final int iw(int paramInt1, int paramInt2)
  {
    n localn = this.Cvg.Cpd.Csl;
    localn.Cpd.Csj.CxZ = paramInt1;
    localn.Cpd.Csj.Cya = paramInt2;
    return 0;
  }
  
  public final void oQ(boolean paramBoolean)
  {
    AppMethodBeat.i(115153);
    ae.m("MicroMsg.Voip.VoipService", "setEngineHeadsetPlugged, %s", new Object[] { Boolean.valueOf(paramBoolean) });
    byte[] arrayOfByte = new byte[1];
    if (paramBoolean) {}
    for (int i = 1;; i = 0)
    {
      arrayOfByte[0] = ((byte)i);
      this.Cvg.Cpd.Csj.setAppCmd(425, arrayOfByte, 1);
      if (!paramBoolean) {
        break;
      }
      if (com.tencent.mm.plugin.audio.c.a.bHt()) {
        this.Cvg.Cpd.Csj.setAppCmd(441, arrayOfByte, 1);
      }
      if (!com.tencent.mm.plugin.audio.c.a.bHz()) {
        break label164;
      }
      this.Cvg.Cpd.Csj.setAppCmd(442, arrayOfByte, 1);
      AppMethodBeat.o(115153);
      return;
    }
    this.Cvg.Cpd.Csj.setAppCmd(441, arrayOfByte, 1);
    this.Cvg.Cpd.Csj.setAppCmd(442, arrayOfByte, 1);
    label164:
    AppMethodBeat.o(115153);
  }
  
  public final void stopRing()
  {
    AppMethodBeat.i(224116);
    this.Cvg.stopRing();
    AppMethodBeat.o(224116);
  }
  
  public final boolean ti(boolean paramBoolean)
  {
    AppMethodBeat.i(115137);
    n localn = this.Cvg.Cpd.Csl;
    if (localn.CsS != null)
    {
      paramBoolean = localn.CsS.ti(paramBoolean);
      AppMethodBeat.o(115137);
      return paramBoolean;
    }
    AppMethodBeat.o(115137);
    return false;
  }
  
  public final int tt(boolean paramBoolean)
  {
    AppMethodBeat.i(115138);
    l locall = this.Cvg.Cpd;
    if (paramBoolean) {}
    for (int i = locall.Csj.setAppCmd(412);; i = locall.Csj.setAppCmd(413))
    {
      if (i < 0) {
        com.tencent.mm.plugin.voip.b.f.Loge("MicroMsg.Voip.VoipContext", "voipContext tryMuteMicrophone ret:".concat(String.valueOf(i)));
      }
      AppMethodBeat.o(115138);
      return i;
    }
  }
  
  public final int tu(boolean paramBoolean)
  {
    AppMethodBeat.i(115139);
    l locall = this.Cvg.Cpd;
    if (paramBoolean) {}
    for (int i = locall.Csj.setAppCmd(401);; i = locall.Csj.setAppCmd(402))
    {
      if (i < 0) {
        com.tencent.mm.plugin.voip.b.f.Logi("MicroMsg.Voip.VoipContext", "voipContext trySwitchSpeakerPhone ret:".concat(String.valueOf(i)));
      }
      AppMethodBeat.o(115139);
      return i;
    }
  }
  
  public final void tv(boolean paramBoolean)
  {
    AppMethodBeat.i(210105);
    v localv = this.Cvg;
    if (localv.ped != null) {
      localv.ped.tO(paramBoolean);
    }
    AppMethodBeat.o(210105);
  }
  
  public final class a
  {
    dzm CvD;
    boolean cancelled;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.voip.model.u
 * JD-Core Version:    0.7.0.1
 */