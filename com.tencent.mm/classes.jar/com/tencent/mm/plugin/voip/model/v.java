package com.tencent.mm.plugin.voip.model;

import android.content.Context;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import android.os.Looper;
import android.telephony.TelephonyManager;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.deviceinfo.ae;
import com.tencent.mm.kernel.e;
import com.tencent.mm.plugin.voip.b.k;
import com.tencent.mm.plugin.voip.model.a.b;
import com.tencent.mm.protocal.protobuf.bso;
import com.tencent.mm.protocal.protobuf.dmk;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.sdk.platformtools.av;
import com.tencent.mm.sdk.platformtools.av.a;
import com.tencent.mm.storage.bl;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.TimerTask;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;

public final class v
  implements l.a
{
  private static int jLs = -1;
  private static int zmv = -1;
  private static int zmw = 20;
  private WifiManager bVj;
  public l zfA;
  ScheduledFuture<?> zmA;
  private WifiInfo zmB;
  public boolean zmC;
  public int zmD;
  public boolean zmE;
  private a zmF;
  private av zmG;
  private byte[] zmH;
  av zmI;
  private av zmJ;
  private av zmK;
  private Object zms;
  com.tencent.mm.plugin.voip.video.i zmt;
  private int zmu;
  public String zmx;
  private int zmy;
  ScheduledExecutorService zmz;
  
  public v()
  {
    AppMethodBeat.i(115162);
    this.zms = new Object();
    this.zmu = 0;
    this.zmz = Executors.newScheduledThreadPool(1);
    this.zmC = false;
    this.zmD = 0;
    this.zmE = false;
    this.zmG = new av(Looper.getMainLooper(), new av.a()
    {
      public final boolean onTimerExpired()
      {
        AppMethodBeat.i(115156);
        if ((v.this.zfA.ziZ.znr == 1) && (v.this.zfA.dSX()))
        {
          com.tencent.mm.plugin.voip.b.c.Logi("MicroMsg.Voip.VoipServiceEx", "call timeout!");
          v.this.zfA.ziZ.zpq.zkh = 101;
          com.tencent.mm.plugin.report.service.h.vKh.f(11521, new Object[] { Integer.valueOf(com.tencent.mm.plugin.voip.c.dRQ().dUz()), Long.valueOf(com.tencent.mm.plugin.voip.c.dRQ().dUA()), Long.valueOf(com.tencent.mm.plugin.voip.c.dRQ().dTa()), Integer.valueOf(4), Long.valueOf(System.currentTimeMillis()), Long.valueOf(System.currentTimeMillis()) });
          v.this.Qp(4);
          v.this.zfA.zja.dSx();
        }
        AppMethodBeat.o(115156);
        return false;
      }
    }, false);
    this.zmH = new byte[500];
    this.zmI = new av(Looper.getMainLooper(), new av.a()
    {
      public final boolean onTimerExpired()
      {
        AppMethodBeat.i(115157);
        Object localObject = v.this.zfA;
        ((l)localObject).zjh += 1;
        if (v.this.zfA.ziZ.roomId == 0)
        {
          com.tencent.mm.plugin.voip.b.c.Loge("MicroMsg.Voip.VoipServiceEx", com.tencent.mm.compatible.util.f.XJ() + "double link switch roomId == 0 ");
          v.a(v.this).stopTimer();
        }
        for (;;)
        {
          AppMethodBeat.o(115157);
          return true;
          v.this.zfA.ziZ.app2EngineDataEx(v.this.zfA.ziZ.zoI, v.this.zfA.ziZ.zoJ, v.this.zfA.ziZ.zoK, 0, 0);
          if ((!v.this.zfA.zjg) && (1 == v.this.zfA.ziZ.field_mGetValidSample))
          {
            v.this.zfA.zjg = true;
            v.this.zfA.zji = v.this.zfA.zjh;
          }
          if (1 == v.this.zfA.ziM) {
            v.this.zfA.ziM = 15;
          }
          if ((true == v.this.zfA.zjg) && (v.this.zfA.zjh - v.this.zfA.zji == v.this.zfA.ziM) && ((v.this.zfA.ziZ.zoz & 0x1) == 0))
          {
            v.this.zfA.zji = v.this.zfA.zjh;
            int i = v.this.zfA.ziZ.isDCSameLan();
            int k = v.this.zfA.ziZ.getCurrentConnType();
            if ((1 == i) && (1 == k))
            {
              com.tencent.mm.plugin.voip.b.c.Logi("MicroMsg.Voip.VoipServiceEx", "zhengxue[DOUBLELINK]  In the Same LAN, isDCSameLan = ".concat(String.valueOf(i)));
              localObject = v.this.zfA;
              ((l)localObject).zjh += 1;
              AppMethodBeat.o(115157);
              return true;
            }
            int m = v.this.zfA.ziZ.getcurstrategy();
            int n = v.this.zfA.ziZ.isRelayConnReady();
            int i1 = v.this.zfA.ziZ.isDCReady();
            int j = v.this.zfA.ziM - 3;
            i = j;
            if (j > 15) {
              i = 15;
            }
            v.this.zfA.ziZ.app2EngineLinkQualityEx(i, v.b(v.this));
            new com.tencent.mm.plugin.voip.model.a.d(v.this.zfA.ziZ.roomId, v.this.zfA.ziZ.sAY, v.this.zfA.ziZ.sBf, k, n, i1, m, v.b(v.this), v.this.zfA.ziZ.field_realLinkQualityInfoBuffLen).dVj();
            localObject = v.this.zfA.ziZ;
            ((v2protocal)localObject).zoB += 1;
            com.tencent.mm.plugin.voip.b.c.Logi("MicroMsg.Voip.VoipServiceEx", "zhengxue[DOUBLELINK]  doubleLinkSwitchReportStatus " + v.this.zfA.ziM + " isFirstValidSampleSet " + v.this.zfA.zjg + " mGetValidSample " + v.this.zfA.ziZ.field_mGetValidSample + "mDoubleLinkSwitchReqCnt " + v.this.zfA.ziZ.zoB + "mTimerCounter " + v.this.zfA.zjh + "mLastSwitchTimer " + v.this.zfA.zji);
          }
        }
      }
    }, true);
    this.zmJ = new av(Looper.getMainLooper(), new av.a()
    {
      public final boolean onTimerExpired()
      {
        AppMethodBeat.i(115158);
        if (v.this.zfA.ziZ.roomId == 0)
        {
          com.tencent.mm.plugin.voip.b.c.Loge("MicroMsg.Voip.VoipServiceEx", com.tencent.mm.compatible.util.f.XJ() + " roomId == 0 ");
          v.c(v.this).stopTimer();
        }
        label136:
        for (;;)
        {
          AppMethodBeat.o(115158);
          return true;
          if (v.this.zfA.mStatus >= 5) {}
          for (int i = 1;; i = 0)
          {
            if (i == 0) {
              break label136;
            }
            new com.tencent.mm.plugin.voip.model.a.f(v.this.zfA.ziZ.roomId, v.this.zfA.ziZ.sAY, v.this.zfA.zjr).dVj();
            break;
          }
        }
      }
    }, true);
    this.zmK = new av(Looper.getMainLooper(), new av.a()
    {
      public final boolean onTimerExpired()
      {
        AppMethodBeat.i(115159);
        ad.i("MicroMsg.Voip.VoipServiceEx", "voip called out of time,now destroy...");
        if ((3 == v.this.zfA.mStatus) && (v.d(v.this) != 0) && (v.d(v.this) == v.this.zfA.ziZ.roomId))
        {
          v.e(v.this);
          v.this.zfA.I(5, -9000, "");
        }
        AppMethodBeat.o(115159);
        return false;
      }
    }, true);
    this.zfA = m.dTs();
    this.zfA.a(this);
    this.zmt = new com.tencent.mm.plugin.voip.video.i(aj.getContext());
    this.zmC = false;
    this.zmD = 0;
    this.zmE = false;
    AppMethodBeat.o(115162);
  }
  
  private void dUQ()
  {
    AppMethodBeat.i(115166);
    ad.d("MicroMsg.Voip.VoipServiceEx", "reset");
    this.zmJ.stopTimer();
    this.zmG.stopTimer();
    this.zmI.stopTimer();
    this.zmK.stopTimer();
    this.zmu = 0;
    AppMethodBeat.o(115166);
  }
  
  private boolean dUS()
  {
    AppMethodBeat.i(115169);
    boolean bool = false;
    if (this.zfA != null) {
      bool = this.zfA.dSX();
    }
    AppMethodBeat.o(115169);
    return bool;
  }
  
  public static boolean dUT()
  {
    AppMethodBeat.i(115171);
    if (((TelephonyManager)aj.getContext().getSystemService("phone")).getCallState() != 0)
    {
      AppMethodBeat.o(115171);
      return true;
    }
    AppMethodBeat.o(115171);
    return false;
  }
  
  private void dVd()
  {
    AppMethodBeat.i(192076);
    TelephonyManager localTelephonyManager = (TelephonyManager)aj.getContext().getSystemService("phone");
    if (localTelephonyManager != null) {
      localTelephonyManager.listen(new v.5(this, localTelephonyManager), 256);
    }
    AppMethodBeat.o(192076);
  }
  
  private void dVe()
  {
    AppMethodBeat.i(192077);
    this.bVj = ((WifiManager)aj.getContext().getApplicationContext().getSystemService("wifi"));
    if (this.zmF != null) {
      this.zmF.cancel();
    }
    this.zmF = new a();
    this.zmA = this.zmz.scheduleAtFixedRate(this.zmF, 0L, zmw, TimeUnit.SECONDS);
    AppMethodBeat.o(192077);
  }
  
  private void reset()
  {
    AppMethodBeat.i(115165);
    ad.d("MicroMsg.Voip.VoipServiceEx", "reset");
    this.zfA.reset();
    this.zmJ.stopTimer();
    this.zmG.stopTimer();
    this.zmI.stopTimer();
    this.zmK.stopTimer();
    if (this.zmF != null) {
      this.zmF.cancel();
    }
    if (this.zmA != null)
    {
      this.zmA.cancel(false);
      this.zmA = null;
    }
    this.zmu = 0;
    com.tencent.mm.plugin.voip.c.dRQ().aAo();
    com.tencent.mm.plugin.voip.c.dRQ().zhw = null;
    this.zmC = false;
    this.zmD = 0;
    this.zmE = false;
    AppMethodBeat.o(115165);
  }
  
  public final void I(int paramInt1, int paramInt2, String paramString)
  {
    AppMethodBeat.i(115173);
    ad.i("MicroMsg.Voip.VoipServiceEx", "onFinishVoIP finishType: ".concat(String.valueOf(paramInt1)));
    switch (paramInt1)
    {
    }
    for (;;)
    {
      AppMethodBeat.o(115173);
      return;
      dUZ();
      this.zfA.zja.onReject();
      AppMethodBeat.o(115173);
      return;
      dUZ();
      this.zfA.zja.dSx();
      AppMethodBeat.o(115173);
      return;
      dUZ();
      this.zfA.zja.dSz();
      AppMethodBeat.o(115173);
      return;
      dUZ();
      this.zfA.zja.onError(paramInt2, paramString);
    }
  }
  
  public final void Qd(int paramInt)
  {
    AppMethodBeat.i(115187);
    this.zfA.Qd(paramInt);
    AppMethodBeat.o(115187);
  }
  
  public final void Ql(int paramInt)
  {
    AppMethodBeat.i(115167);
    this.zfA.PZ(paramInt);
    AppMethodBeat.o(115167);
  }
  
  public final void Qo(int paramInt)
  {
    AppMethodBeat.i(192078);
    this.bVj = null;
    this.zmB = null;
    this.zmy = 0;
    if (paramInt > 0) {
      zmw = paramInt;
    }
    dVe();
    dVd();
    AppMethodBeat.o(192078);
  }
  
  public final int Qp(int paramInt)
  {
    AppMethodBeat.i(115176);
    if (!this.zfA.dSZ())
    {
      com.tencent.mm.plugin.voip.b.c.Loge("MicroMsg.Voip.VoipServiceEx", "Failed to cancel call ,as not in calling.");
      AppMethodBeat.o(115176);
      return -1;
    }
    ad.i("MicroMsg.Voip.VoipServiceEx", "cancelCallEx, roomId:%d, msgID:%d, inviteId:%d, cancelType:%d", new Object[] { Integer.valueOf(this.zfA.ziZ.roomId), Integer.valueOf(this.zfA.ziZ.znp), Integer.valueOf(this.zfA.ziZ.sBa), Integer.valueOf(paramInt) });
    synchronized (this.zms)
    {
      if ((this.zfA.ziZ.roomId == 0) && (this.zfA.ziZ.sBa == 0))
      {
        com.tencent.mm.plugin.voip.b.c.Loge("MicroMsg.Voip.VoipServiceEx", "Failed to cancel call with roomid = 0 and inviteId = 0 ");
        AppMethodBeat.o(115176);
        return -1;
      }
      if (this.zfA.ziZ.dVA())
      {
        this.zfA.ziZ.rG(true);
        new com.tencent.mm.plugin.voip.model.a.c(this.zfA.ziZ.roomId, this.zfA.ziZ.sAY, this.zfA.ziZ.fPP, "", this.zfA.ziZ.sBa, paramInt).dVj();
      }
      Object localObject2 = this.zfA.ziZ.zpq;
      ((o)localObject2).zkC = ((int)(System.currentTimeMillis() - ((o)localObject2).zkM));
      com.tencent.mm.plugin.voip.b.c.Logd("MicroMsg.VoipDailReport", "devin:cancelInvite:" + ((o)localObject2).zkC);
      if ((this.zfA.ziZ.znJ == 0) && (this.zfA.ziZ.znK == 0)) {
        this.zfA.dSV();
      }
      this.zfA.Qb(this.zmt.dXo());
      this.zfA.ziZ.zpq.zkR = this.zfA.zja.dSB();
      if (com.tencent.mm.plugin.voip.c.dRQ().zlS != null)
      {
        this.zfA.ziZ.zpq.zkS = com.tencent.mm.plugin.voip.c.dRQ().zlS.dRO();
        this.zfA.ziZ.zpq.zhF = (com.tencent.mm.plugin.voip.c.dRQ().zlS.dRM() / 1000L);
        this.zfA.ziZ.zpq.zhG = (com.tencent.mm.plugin.voip.c.dRQ().zlS.dRN() / 1000L);
      }
      localObject2 = v2protocal.dVD();
      String str1 = this.zfA.ziZ.dVE();
      String str2 = this.zfA.ziZ.dVJ();
      String str3 = this.zfA.ziZ.dVw();
      String str4 = this.zfA.ziZ.dVy();
      String[] arrayOfString1 = this.zfA.ziZ.dVF();
      String[] arrayOfString2 = this.zfA.ziZ.dVG();
      String[] arrayOfString3 = this.zfA.ziZ.dVH();
      String[] arrayOfString4 = this.zfA.ziZ.dVI();
      if (str1.length() > 0) {
        new com.tencent.mm.plugin.voip.model.a.l((String)localObject2, str1, str3, str2, str4, arrayOfString1, arrayOfString2, arrayOfString3, arrayOfString4).dVj();
      }
      this.zfA.dST();
      reset();
      this.zfA.ziZ.roomId = 0;
      this.zfA.ziZ.sBa = 0;
      AppMethodBeat.o(115176);
      return 0;
    }
  }
  
  public final void Qq(int paramInt)
  {
    AppMethodBeat.i(115196);
    this.zmu = paramInt;
    if (!this.zmK.eFX()) {
      this.zmK.stopTimer();
    }
    this.zmK.av(70000L, 70000L);
    AppMethodBeat.o(115196);
  }
  
  public final void a(int paramInt1, long paramLong, int paramInt2, byte[] paramArrayOfByte1, byte[] paramArrayOfByte2, String paramString)
  {
    AppMethodBeat.i(115184);
    com.tencent.mm.plugin.voip.b.c.Logi("MicroMsg.Voip.VoipServiceEx", "doAck roomId " + paramInt1 + "  roomKey " + paramLong + " status " + paramInt2);
    if ((paramInt1 != 0) && (paramLong != 0L))
    {
      LinkedList localLinkedList = new LinkedList();
      this.zfA.aP(localLinkedList);
      this.zfA.ziZ.zob = ("ack:" + this.zfA.ziZ.znX + ":" + this.zfA.ziZ.znY);
      new com.tencent.mm.plugin.voip.model.a.a(paramInt1, paramLong, paramInt2, paramArrayOfByte1, paramArrayOfByte2, paramString, localLinkedList).dVj();
    }
    this.zfA.dTe();
    AppMethodBeat.o(115184);
  }
  
  public final void a(Context paramContext, x paramx)
  {
    AppMethodBeat.i(192071);
    this.zfA.mfC = paramContext;
    this.zfA.zja = paramx;
    com.tencent.mm.plugin.voip.b.c.Logd("MicroMsg.Voip.VoipServiceEx", "attach ui........");
    com.tencent.mm.plugin.voip.b.c.dWs();
    AppMethodBeat.o(192071);
  }
  
  public final boolean a(dmk paramdmk)
  {
    int i = 1;
    AppMethodBeat.i(115178);
    if (this.zfA.dSZ())
    {
      com.tencent.mm.plugin.voip.b.c.Loge("MicroMsg.Voip.VoipServiceEx", "Failed to setInviteContent during calling, status =" + this.zfA.mStatus);
      AppMethodBeat.o(115178);
      return false;
    }
    if (paramdmk == null)
    {
      AppMethodBeat.o(115178);
      return false;
    }
    this.zfA.ziZ.zpq.zks = paramdmk.EBU;
    ad.d("MicroMsg.Voip.VoipServiceEx", "iRoomType " + this.zfA.ziZ.zpq.zks);
    if (this.zfA.ziZ.dVA())
    {
      com.tencent.mm.plugin.voip.b.c.Logw("MicroMsg.Voip.VoipServiceEx", com.tencent.mm.compatible.util.f.XJ() + "v2protocal already init.");
      this.zfA.ziZ.rG(false);
      this.zfA.ziZ.reset();
    }
    this.zfA.a(paramdmk);
    if ((k.dWP()) || (com.tencent.mm.r.a.aad()) || (k.dWR()) || (com.tencent.mm.r.a.ccn()))
    {
      ad.e("MicroMsg.Voip.VoipServiceEx", "setInviteContent, reject, pstn/multitak/f2f talking");
      if ((k.dWP()) || (com.tencent.mm.r.a.ccn()))
      {
        a(paramdmk.DdZ, paramdmk.Dea, 2, null, null, paramdmk.ECd);
        AppMethodBeat.o(115178);
        return false;
      }
      dUX();
      label271:
      String str;
      if (paramdmk.EBU == 0)
      {
        str = paramdmk.ECd;
        if (i == 0) {
          break label310;
        }
      }
      label310:
      for (paramdmk = bl.FzN;; paramdmk = bl.FzM)
      {
        s.c(str, paramdmk, 0, 6, aj.getContext().getString(2131764807));
        break;
        i = 0;
        break label271;
      }
    }
    if (this.zfA.ziZ.dMH() < 0)
    {
      com.tencent.mm.plugin.voip.b.c.Loge("MicroMsg.Voip.VoipServiceEx", "Failed to init v2protocol.");
      AppMethodBeat.o(115178);
      return false;
    }
    if (v2protocal.zpu != null) {
      v2protocal.zpu.a(this.zfA);
    }
    com.tencent.mm.plugin.report.service.h.vKh.a(11524, true, true, new Object[] { Integer.valueOf(paramdmk.DdZ), Long.valueOf(paramdmk.Dea), Integer.valueOf(paramdmk.EBU), Integer.valueOf(0), Long.valueOf(System.currentTimeMillis()) });
    if (!this.zmC) {
      this.zfA.zja.dSu();
    }
    AppMethodBeat.o(115178);
    return true;
  }
  
  public final int an(boolean paramBoolean1, boolean paramBoolean2)
  {
    AppMethodBeat.i(115179);
    dVc();
    if (!this.zmK.eFX()) {
      this.zmK.stopTimer();
    }
    this.zfA.ziZ.zpq.dTA();
    ad.i("MicroMsg.Voip.VoipServiceEx", "accept onlyAudio:".concat(String.valueOf(paramBoolean1)));
    if (!this.zfA.dSY())
    {
      com.tencent.mm.plugin.voip.b.c.Loge("MicroMsg.Voip.VoipServiceEx", "Failed to accept with calling, status =" + this.zfA.mStatus);
      AppMethodBeat.o(115179);
      return -1;
    }
    if (this.zfA.ziZ.roomId == 0)
    {
      com.tencent.mm.plugin.voip.b.c.Loge("MicroMsg.Voip.VoipServiceEx", "Failed to accept with roomid = 0. ");
      AppMethodBeat.o(115179);
      return -1;
    }
    LinkedList localLinkedList = new LinkedList();
    this.zfA.aP(localLinkedList);
    this.zfA.ziZ.zob = (this.zfA.ziZ.zob + "|answer:" + this.zfA.ziZ.znX + ":" + this.zfA.ziZ.znY);
    com.tencent.mm.plugin.voip.b.c.Logd("MicroMsg.Voip.VoipServiceEx", com.tencent.mm.compatible.util.f.XJ() + "accept invite, roomid:" + this.zfA.ziZ.roomId + " nic list size:" + localLinkedList.size());
    this.zmJ.av(50000L, 50000L);
    this.zfA.ziZ.zpq.dTB();
    new b(1, this.zfA.ziZ.netType, this.zfA.ziZ.roomId, this.zfA.ziZ.field_peerId, this.zfA.ziZ.field_capInfo, this.zfA.ziZ.sAY, paramBoolean1, paramBoolean2, localLinkedList).dVj();
    this.zfA.setStatus(4);
    this.zfA.zjb.nPJ = 1;
    this.zfA.duq = true;
    AppMethodBeat.o(115179);
    return 0;
  }
  
  public final int b(int paramInt1, long paramLong, int paramInt2)
  {
    AppMethodBeat.i(115177);
    if (!this.zfA.dSZ())
    {
      com.tencent.mm.plugin.voip.b.c.Loge("MicroMsg.Voip.VoipServiceEx", "steve:[simucall]Failed to cancel call ,as not in calling.");
      AppMethodBeat.o(115177);
      return -1;
    }
    ad.i("MicroMsg.Voip.VoipServiceEx", "steve:[simucall] try to cancel my invite due to Simulcall(callee), roomId:%s, roomKey:%s, roomType:%d, msgID:%d, inviteId:%d", new Object[] { Integer.valueOf(paramInt1), Long.valueOf(paramLong), Integer.valueOf(paramInt2), Integer.valueOf(this.zfA.ziZ.znp), Integer.valueOf(this.zfA.ziZ.sBa) });
    Object localObject1 = this.zms;
    if (paramInt1 != 0) {}
    try
    {
      if (this.zfA.ziZ.sBa == 0)
      {
        com.tencent.mm.plugin.voip.b.c.Loge("MicroMsg.Voip.VoipServiceEx", "steve:[simucall] Failed to cancel call with roomid = 0 and inviteId = 0 ");
        return -1;
      }
      new com.tencent.mm.plugin.voip.model.a.c(paramInt1, paramLong, this.zfA.ziZ.fPP, "", this.zfA.ziZ.sBa, 2).dVj();
      com.tencent.mm.plugin.report.service.h.vKh.a(11521, true, true, new Object[] { Integer.valueOf(paramInt1), Long.valueOf(paramLong), Integer.valueOf(paramInt2), Integer.valueOf(2), Long.valueOf(System.currentTimeMillis()), Long.valueOf(System.currentTimeMillis()) });
      ad.i("MicroMsg.Voip.VoipServiceEx", "steve:[simucall] voipcancelinvite sent!");
      return 0;
    }
    finally
    {
      AppMethodBeat.o(115177);
    }
  }
  
  public final void b(Context paramContext, x paramx)
  {
    AppMethodBeat.i(192072);
    if ((paramContext != this.zfA.mfC) || (paramx != this.zfA.zja))
    {
      com.tencent.mm.plugin.voip.b.c.Logd("MicroMsg.Voip.VoipServiceEx", "cannot detach other's ui.");
      AppMethodBeat.o(192072);
      return;
    }
    this.zfA.mfC = null;
    this.zfA.zja = x.zmT;
    com.tencent.mm.plugin.voip.b.c.Logd("MicroMsg.Voip.VoipServiceEx", "detach ui........");
    com.tencent.mm.plugin.voip.b.c.flushLogFile();
    AppMethodBeat.o(192072);
  }
  
  public final int c(byte[] paramArrayOfByte, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    AppMethodBeat.i(192075);
    paramInt1 = this.zfA.zjb.b(paramArrayOfByte, paramInt1, paramInt2, paramInt3, paramInt4);
    AppMethodBeat.o(192075);
    return paramInt1;
  }
  
  public final boolean cSx()
  {
    AppMethodBeat.i(115195);
    if (this.zmt != null)
    {
      boolean bool = this.zmt.Nc();
      AppMethodBeat.o(115195);
      return bool;
    }
    AppMethodBeat.o(115195);
    return true;
  }
  
  public final boolean dSZ()
  {
    AppMethodBeat.i(115170);
    if (this.zfA.dSZ())
    {
      AppMethodBeat.o(115170);
      return true;
    }
    AppMethodBeat.o(115170);
    return false;
  }
  
  public final boolean dUR()
  {
    AppMethodBeat.i(115168);
    ad.i("MicroMsg.Voip.VoipServiceEx", "isRoomReady, roomId: " + this.zfA.ziZ.roomId);
    if ((this.zfA.ziZ.roomId != 0) && (!dUS()))
    {
      AppMethodBeat.o(115168);
      return true;
    }
    AppMethodBeat.o(115168);
    return false;
  }
  
  public final void dUU()
  {
    AppMethodBeat.i(115172);
    if (this.zfA.dSZ()) {
      com.tencent.mm.plugin.voip.b.c.Loge("MicroMsg.Voip.VoipServiceEx", "checkStartup failed, stauts = " + this.zfA.mStatus);
    }
    com.tencent.mm.plugin.voip.b.c.Loge("MicroMsg.Voip.VoipServiceEx", "checkStartup...devicekey = " + com.tencent.mm.storage.bt.eMY());
    this.zfA.dSU();
    dUQ();
    ae.ph(com.tencent.mm.kernel.g.afB().afl().eMW());
    AppMethodBeat.o(115172);
  }
  
  public final int dUV()
  {
    AppMethodBeat.i(115175);
    ad.i("MicroMsg.Voip.VoipServiceEx", "cancelCall, roomId:" + this.zfA.ziZ.roomId);
    if ((this.zfA.ziZ.roomId == 0) && (this.zfA.ziZ.sBa == 0))
    {
      reset();
      AppMethodBeat.o(115175);
      return -1;
    }
    this.zfA.ziZ.zpq.zkh = this.zfA.dSW();
    this.zfA.ziZ.zpq.zkt = 3;
    if (this.zfA.mStatus < 6) {
      this.zfA.ziZ.zpq.zkv = 1;
    }
    com.tencent.mm.plugin.report.service.h.vKh.a(11521, true, true, new Object[] { Integer.valueOf(com.tencent.mm.plugin.voip.c.dRQ().dUz()), Long.valueOf(com.tencent.mm.plugin.voip.c.dRQ().dUA()), Long.valueOf(com.tencent.mm.plugin.voip.c.dRQ().dTa()), Integer.valueOf(1), Long.valueOf(System.currentTimeMillis()), Long.valueOf(System.currentTimeMillis()) });
    int i = Qp(1);
    AppMethodBeat.o(115175);
    return i;
  }
  
  public final int dUW()
  {
    AppMethodBeat.i(192073);
    ad.i("MicroMsg.Voip.VoipServiceEx", "cancelCallByPhoneInter, roomId:" + this.zfA.ziZ.roomId);
    if (this.zfA.ziZ.roomId == 0)
    {
      AppMethodBeat.o(192073);
      return -1;
    }
    this.zfA.ziZ.zpq.zkh = 102;
    this.zfA.ziZ.zpq.zkt = 6;
    if (com.tencent.mm.plugin.voip.c.dRQ().zlS != null)
    {
      this.zfA.ziZ.zpq.zkS = com.tencent.mm.plugin.voip.c.dRQ().zlS.dRO();
      this.zfA.ziZ.zpq.zhF = (com.tencent.mm.plugin.voip.c.dRQ().zlS.dRM() / 1000L);
      this.zfA.ziZ.zpq.zhG = (com.tencent.mm.plugin.voip.c.dRQ().zlS.dRN() / 1000L);
    }
    com.tencent.mm.plugin.report.service.h.vKh.a(11521, true, true, new Object[] { Integer.valueOf(com.tencent.mm.plugin.voip.c.dRQ().dUz()), Long.valueOf(com.tencent.mm.plugin.voip.c.dRQ().dUA()), Long.valueOf(com.tencent.mm.plugin.voip.c.dRQ().dTa()), Integer.valueOf(3), Long.valueOf(System.currentTimeMillis()), Long.valueOf(System.currentTimeMillis()) });
    int i = Qp(3);
    AppMethodBeat.o(192073);
    return i;
  }
  
  public final int dUX()
  {
    AppMethodBeat.i(115180);
    ad.i("MicroMsg.Voip.VoipServiceEx", "reject");
    if (!this.zfA.dSY())
    {
      com.tencent.mm.plugin.voip.b.c.Loge("MicroMsg.Voip.VoipServiceEx", "Failed to reject with calling, status =" + this.zfA.mStatus);
      AppMethodBeat.o(115180);
      return -1;
    }
    synchronized (this.zms)
    {
      if (this.zfA.ziZ.roomId == 0)
      {
        com.tencent.mm.plugin.voip.b.c.Loge("MicroMsg.Voip.VoipServiceEx", "Failed to reject with roomid = 0. ");
        AppMethodBeat.o(115180);
        return -1;
      }
      this.zfA.ziZ.zpq.dTB();
      com.tencent.mm.plugin.voip.b.c.Logd("MicroMsg.Voip.VoipServiceEx", " reject, status:" + this.zfA.mStatus + " roomid:" + this.zfA.ziZ.roomId);
      int i = this.zfA.ziZ.netType;
      int j = this.zfA.ziZ.roomId;
      long l = this.zfA.ziZ.sAY;
      new b(2, i, j, new byte[0], new byte[0], l, false, false, null).dVj();
      if ((this.zfA.ziZ.znJ == 0) && (this.zfA.ziZ.znK == 0)) {
        this.zfA.dSV();
      }
      this.zfA.Qb(this.zmt.dXo());
      this.zfA.ziZ.zpq.zkR = this.zfA.zja.dSB();
      if (com.tencent.mm.plugin.voip.c.dRQ().zlS != null)
      {
        this.zfA.ziZ.zpq.zkS = com.tencent.mm.plugin.voip.c.dRQ().zlS.dRO();
        this.zfA.ziZ.zpq.zhF = (com.tencent.mm.plugin.voip.c.dRQ().zlS.dRM() / 1000L);
        this.zfA.ziZ.zpq.zhG = (com.tencent.mm.plugin.voip.c.dRQ().zlS.dRN() / 1000L);
      }
      if (this.zfA.ziZ.dVA()) {
        this.zfA.ziZ.rG(true);
      }
      String str1 = v2protocal.dVD();
      String str2 = this.zfA.ziZ.dVE();
      String str3 = this.zfA.ziZ.dVJ();
      String str4 = this.zfA.ziZ.dVw();
      String str5 = this.zfA.ziZ.dVy();
      String[] arrayOfString1 = this.zfA.ziZ.dVF();
      String[] arrayOfString2 = this.zfA.ziZ.dVG();
      String[] arrayOfString3 = this.zfA.ziZ.dVH();
      String[] arrayOfString4 = this.zfA.ziZ.dVI();
      com.tencent.mm.plugin.voip.b.c.Logd("MicroMsg.Voip.VoipServiceEx", "devin: statreport");
      if (str2.length() > 0)
      {
        com.tencent.mm.plugin.voip.b.c.Logd("MicroMsg.Voip.VoipServiceEx", "devin: reject() newdialInfo.length() > 0");
        new com.tencent.mm.plugin.voip.model.a.l(str1, str2, str4, str3, str5, arrayOfString1, arrayOfString2, arrayOfString3, arrayOfString4).dVj();
        this.zfA.dST();
        reset();
        this.zfA.ziZ.roomId = 0;
        AppMethodBeat.o(115180);
        return 0;
      }
      com.tencent.mm.plugin.voip.b.c.Logd("MicroMsg.Voip.VoipServiceEx", "devin: reject() newdialInfo.length() <= 0");
    }
  }
  
  public final int dUY()
  {
    AppMethodBeat.i(115181);
    ad.i("MicroMsg.Voip.VoipServiceEx", "hangUp");
    if (this.zfA.ziZ.roomId == 0)
    {
      this.zfA.zjb.dTu();
      this.zfA.dTf();
      reset();
      AppMethodBeat.o(115181);
      return 0;
    }
    this.zfA.ziZ.zpq.zkh = this.zfA.dSW();
    int i = dUZ();
    AppMethodBeat.o(115181);
    return i;
  }
  
  public final int dUZ()
  {
    AppMethodBeat.i(115182);
    com.tencent.mm.plugin.voip.b.c.Logi("MicroMsg.Voip.VoipServiceEx", "hangUp,status:" + this.zfA.mStatus + " roomid:" + this.zfA.ziZ.roomId + ",threadid = " + Thread.currentThread().getId());
    this.zfA.zjb.dTu();
    this.zfA.dTf();
    if (this.zfA.ziZ.zpq.zkr == 1)
    {
      ??? = this.zfA.ziZ.zpq;
      if (((o)???).zkI != 0L) {
        break label623;
      }
      ((o)???).zkB = 0;
    }
    for (;;)
    {
      if (((o)???).zkB < 0)
      {
        ((o)???).zkB = 0;
        com.tencent.mm.plugin.voip.b.c.Loge("MicroMsg.VoipDailReport", "devin:endTalk, iCallTime Err, rest 0");
      }
      com.tencent.mm.plugin.voip.b.c.Logi("MicroMsg.VoipDailReport", "devin:endTalk:" + ((o)???).zkB);
      synchronized (this.zms)
      {
        int i = this.zfA.ziZ.zpq.zkt;
        if ((this.zfA.ziZ.roomId != 0) || (8 == i) || (9 == i) || (10 == i) || (11 == i) || (12 == i) || (99 == i))
        {
          com.tencent.mm.plugin.voip.b.c.Logi("MicroMsg.Voip.VoipServiceEx", "steve:hangUp, uninitGLRender before protocalUninit first!!");
          if (this.zfA.ziZ.dVA())
          {
            this.zfA.ziZ.rG(true);
            new com.tencent.mm.plugin.voip.model.a.i(this.zfA.ziZ.roomId, this.zfA.ziZ.sAY, "").dVj();
            com.tencent.mm.plugin.voip.b.c.Loge("MicroMsg.Voip.VoipServiceEx", "devin: shutdown cgi ");
          }
          this.zfA.ziZ.zpq.zkR = this.zfA.zja.dSB();
          if (com.tencent.mm.plugin.voip.c.dRQ().zlS != null)
          {
            this.zfA.ziZ.zpq.zkS = com.tencent.mm.plugin.voip.c.dRQ().zlS.dRO();
            this.zfA.ziZ.zpq.zhF = (com.tencent.mm.plugin.voip.c.dRQ().zlS.dRM() / 1000L);
            this.zfA.ziZ.zpq.zhG = (com.tencent.mm.plugin.voip.c.dRQ().zlS.dRN() / 1000L);
          }
          this.zfA.Qb(this.zmt.dXo());
          String str1 = v2protocal.dVD();
          String str2 = this.zfA.ziZ.dVE();
          String str3 = this.zfA.ziZ.dVJ();
          String str4 = this.zfA.ziZ.dVw();
          String str5 = this.zfA.ziZ.dVy();
          String[] arrayOfString1 = this.zfA.ziZ.dVF();
          String[] arrayOfString2 = this.zfA.ziZ.dVG();
          String[] arrayOfString3 = this.zfA.ziZ.dVH();
          String[] arrayOfString4 = this.zfA.ziZ.dVI();
          if (str2.length() > 0)
          {
            new com.tencent.mm.plugin.voip.model.a.l(str1, str2, str4, str3, str5, arrayOfString1, arrayOfString2, arrayOfString3, arrayOfString4).dVj();
            com.tencent.mm.plugin.voip.b.c.Loge("MicroMsg.Voip.VoipServiceEx", "devin: statreport cgi ");
          }
          this.zfA.dST();
          reset();
          this.zfA.ziZ.roomId = 0;
          com.tencent.mm.plugin.voip.b.c.Logd("MicroMsg.Voip.VoipServiceEx", "hangUp over");
          AppMethodBeat.o(115182);
          return 0;
          label623:
          ((o)???).zkB = ((int)((System.currentTimeMillis() - ((o)???).zkI) / 1000L));
          continue;
        }
        com.tencent.mm.plugin.voip.b.c.Loge("MicroMsg.Voip.VoipServiceEx", "call hangUp roomId == 0 ");
      }
    }
  }
  
  public final int dUx()
  {
    AppMethodBeat.i(192074);
    ad.i("MicroMsg.Voip.VoipServiceEx", "hangUpByPhoneInter");
    if (this.zfA.ziZ.roomId == 0)
    {
      this.zfA.zjb.dTu();
      reset();
      AppMethodBeat.o(192074);
      return 0;
    }
    this.zfA.ziZ.zpq.zkh = 109;
    this.zfA.ziZ.zpq.zkz = 4;
    int i = dUZ();
    AppMethodBeat.o(192074);
    return i;
  }
  
  public final int dUy()
  {
    AppMethodBeat.i(115183);
    ad.i("MicroMsg.Voip.VoipServiceEx", "ignoreInvite");
    if (!this.zfA.dSY())
    {
      com.tencent.mm.plugin.voip.b.c.Loge("MicroMsg.Voip.VoipServiceEx", "Failed to ignore with calling, status =" + this.zfA.mStatus);
      AppMethodBeat.o(115183);
      return -1;
    }
    synchronized (this.zms)
    {
      if (this.zfA.ziZ.roomId == 0)
      {
        com.tencent.mm.plugin.voip.b.c.Loge("MicroMsg.Voip.VoipServiceEx", "Failed to reject with roomid = 0. ");
        AppMethodBeat.o(115183);
        return -1;
      }
      int i = this.zfA.ziZ.netType;
      int j = this.zfA.ziZ.roomId;
      long l = this.zfA.ziZ.sAY;
      new b(3, i, j, new byte[0], new byte[0], l, false, false, null).dVj();
      reset();
      this.zfA.ziZ.roomId = 0;
      AppMethodBeat.o(115183);
      return 0;
    }
  }
  
  public final void dVa()
  {
    AppMethodBeat.i(115185);
    LinkedList localLinkedList = new LinkedList();
    this.zfA.ziZ.aQ(localLinkedList);
    int j = 0;
    int m = 0;
    int n;
    for (int i = 0; j < localLinkedList.size(); i = n)
    {
      int k = m;
      if (((bso)localLinkedList.get(j)).DPK == 5) {
        k = m + 1;
      }
      n = i;
      if (((bso)localLinkedList.get(j)).DPK == 4) {
        n = i + 1;
      }
      j += 1;
      m = k;
    }
    this.zfA.ziZ.zob = (this.zfA.ziZ.zob + "|redirect:" + i + ":" + m);
    new com.tencent.mm.plugin.voip.model.a.h(this.zfA.ziZ.roomId, this.zfA.ziZ.sAY, this.zfA.ziZ.sBf, 0, 0, null, localLinkedList).dVj();
    AppMethodBeat.o(115185);
  }
  
  public final void dVb()
  {
    AppMethodBeat.i(115193);
    if (this.zmt != null) {
      this.zmt.a(2131691389, false, 0, false);
    }
    AppMethodBeat.o(115193);
  }
  
  public final void dVc()
  {
    AppMethodBeat.i(115197);
    if (this.zmG != null)
    {
      com.tencent.mm.plugin.voip.b.c.Logi("MicroMsg.Voip.VoipServiceEx", "devincdai: voip reset timecount");
      this.zmG.stopTimer();
      this.zmG.av(60000L, 60000L);
    }
    AppMethodBeat.o(115197);
  }
  
  public final int eJ(String paramString, int paramInt)
  {
    AppMethodBeat.i(115174);
    ad.i("MicroMsg.Voip.VoipServiceEx", "call username:%s, callType:%d, inviteType:%d", new Object[] { paramString, Integer.valueOf(0), Integer.valueOf(paramInt) });
    if (com.tencent.mm.sdk.platformtools.bt.isNullOrNil(paramString))
    {
      com.tencent.mm.plugin.voip.b.c.Loge("MicroMsg.Voip.VoipServiceEx", "Failed call without valid username.");
      AppMethodBeat.o(115174);
      return -1;
    }
    if (this.zfA.dSZ())
    {
      com.tencent.mm.plugin.voip.b.c.Loge("MicroMsg.Voip.VoipServiceEx", "Failed call withing calling.");
      AppMethodBeat.o(115174);
      return -1;
    }
    this.zfA.ziZ.znr = 1;
    this.zfA.ziZ.fPP = paramString;
    com.tencent.mm.plugin.voip.b.c.Logd("MicroMsg.Voip.VoipServiceEx", com.tencent.mm.compatible.util.f.XJ() + "call username:" + paramString);
    if (this.zfA.ziZ.dVA())
    {
      com.tencent.mm.plugin.voip.b.c.Loge("MicroMsg.Voip.VoipServiceEx", com.tencent.mm.compatible.util.f.XJ() + "v2protocal already init.");
      this.zfA.ziZ.rG(false);
      this.zfA.ziZ.reset();
    }
    if (this.zfA.ziZ.dMH() < 0)
    {
      com.tencent.mm.plugin.voip.b.c.Loge("MicroMsg.Voip.VoipServiceEx", "Failed to init v2protocol.");
      AppMethodBeat.o(115174);
      return -1;
    }
    if (this.zfA.ziZ.zpt != null) {
      this.zfA.ziZ.zpt.zfA = this.zfA;
    }
    if (v2protocal.zpu != null) {
      v2protocal.zpu.a(this.zfA);
    }
    this.zmJ.av(50000L, 50000L);
    this.zfA.ziZ.sBa = ((int)System.currentTimeMillis());
    LinkedList localLinkedList = new LinkedList();
    this.zfA.aP(localLinkedList);
    this.zfA.ziZ.zob = ("invite:" + this.zfA.ziZ.znX + ":" + this.zfA.ziZ.znY);
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(paramString);
    new com.tencent.mm.plugin.voip.model.a.g(localArrayList, this.zfA.ziZ.field_peerId, this.zfA.ziZ.field_capInfo, this.zfA.ziZ.netType, paramInt, this.zfA.ziZ.sBa, localLinkedList).dVj();
    this.zfA.setStatus(2);
    this.zfA.zjb.nPJ = 1;
    this.zmG.av(60000L, 60000L);
    this.zfA.ziZ.zpq.zkM = System.currentTimeMillis();
    this.zfA.ziZ.zpq.beginTime = System.currentTimeMillis();
    this.zfA.ziZ.zpq.zks = paramInt;
    ad.d("MicroMsg.Voip.VoipServiceEx", "iRoomType " + this.zfA.ziZ.zpq.zks);
    this.zfA.dTe();
    AppMethodBeat.o(115174);
    return 0;
  }
  
  protected final void finalize()
  {
    AppMethodBeat.i(115164);
    stop();
    super.finalize();
    AppMethodBeat.o(115164);
  }
  
  public final int setNetSignalValue(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(115186);
    paramInt1 = this.zfA.ziZ.setNetSignalValue(paramInt1, paramInt2);
    AppMethodBeat.o(115186);
    return paramInt1;
  }
  
  public final void stop()
  {
    AppMethodBeat.i(115163);
    ad.i("MicroMsg.Voip.VoipServiceEx", "stop");
    reset();
    this.zfA.a(null);
    AppMethodBeat.o(115163);
  }
  
  public final void stopRing()
  {
    AppMethodBeat.i(115194);
    if (this.zmt != null) {
      this.zmt.stop();
    }
    AppMethodBeat.o(115194);
  }
  
  final class a
    extends TimerTask
  {
    a() {}
    
    public final void run()
    {
      int i = 10;
      AppMethodBeat.i(115161);
      if (v.g(v.this) != null) {
        v.a(v.this, v.g(v.this).getConnectionInfo());
      }
      if ((v.h(v.this) != null) && (v.h(v.this).getBSSID() != null) && (v.g(v.this) != null))
      {
        v.g(v.this);
        v.Qs(WifiManager.calculateSignalLevel(v.h(v.this).getRssi(), 10));
        if (v.bxP() > 10)
        {
          v.Qs(i);
          if (v.bxP() >= 0) {
            break label180;
          }
          i = 0;
          label117:
          v.Qs(i);
          v.Qs(v.bxP() * 10);
        }
      }
      for (;;)
      {
        if (v.bxP() != -1) {
          break label195;
        }
        if (v.i(v.this) <= 1) {
          v.Qr(-1);
        }
        v.this.setNetSignalValue(1, v.zmv);
        AppMethodBeat.o(115161);
        return;
        i = v.bxP();
        break;
        label180:
        i = v.bxP();
        break label117;
        v.Qs(-1);
      }
      label195:
      v.this.setNetSignalValue(2, v.bxP());
      AppMethodBeat.o(115161);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.voip.model.v
 * JD-Core Version:    0.7.0.1
 */