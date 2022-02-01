package com.tencent.mm.plugin.voip.model;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.BatteryManager;
import android.os.Build.VERSION;
import android.os.Looper;
import android.os.PowerManager;
import android.telephony.TelephonyManager;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.deviceinfo.af;
import com.tencent.mm.plugin.voip.SubCoreVoip;
import com.tencent.mm.plugin.voip.b.g;
import com.tencent.mm.plugin.voip.d.c.a;
import com.tencent.mm.plugin.voip.video.e;
import com.tencent.mm.protocal.protobuf.dtl;
import com.tencent.mm.protocal.protobuf.gaq;
import com.tencent.mm.sdk.platformtools.ConnectivityCompat;
import com.tencent.mm.sdk.platformtools.ConnectivityCompat.Companion;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.MTimerHandler;
import com.tencent.mm.sdk.platformtools.MTimerHandler.CallBack;
import com.tencent.mm.sdk.platformtools.NetStatusUtil;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.cc;
import com.tencent.mm.storage.co;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public final class v
  implements l.a
{
  private static int UCj = -1;
  static int UCk = 20;
  static int UCl = 3;
  private static int UCm = 0;
  private static int UCn = 0;
  private static int UCo = 0;
  private static int UCp = 0;
  private static int UCq = -1;
  private static int UCr = -1;
  private static int UCs = -1;
  private static int rPb = -1;
  public boolean OEa;
  b UCA;
  a UCB;
  c UCC;
  private MTimerHandler UCD;
  private byte[] UCE;
  MTimerHandler UCF;
  private MTimerHandler UCG;
  private MTimerHandler UCH;
  private Object UCh;
  private int UCi;
  int UCt;
  com.tencent.threadpool.i.d<?> UCu;
  com.tencent.threadpool.i.d<?> UCv;
  public boolean UCw;
  public int UCx;
  public boolean UCy;
  public String UCz;
  public boolean UvH;
  public l UvO;
  public String toUser;
  public e wVi;
  
  public v()
  {
    AppMethodBeat.i(115162);
    this.UCh = new Object();
    this.UCi = 0;
    this.UCw = false;
    this.UCx = 0;
    this.UCy = false;
    this.UCz = null;
    this.toUser = null;
    this.UvH = false;
    this.OEa = false;
    this.UCD = new MTimerHandler(Looper.getMainLooper(), new MTimerHandler.CallBack()
    {
      public final boolean onTimerExpired()
      {
        AppMethodBeat.i(115157);
        if ((v.this.UvO.UyU.UDt == 1) && (v.this.UvO.hWz()))
        {
          com.tencent.mm.plugin.voip.f.g.Logi("MicroMsg.Voip.VoipServiceEx", "call timeout!");
          v.this.UvO.UyU.UFN.UAh = 101;
          com.tencent.mm.plugin.report.service.h.OAn.b(11521, new Object[] { Integer.valueOf(SubCoreVoip.hVp().hYr()), Long.valueOf(SubCoreVoip.hVp().hVw()), Long.valueOf(SubCoreVoip.hVp().hWC()), Integer.valueOf(4), Long.valueOf(System.currentTimeMillis()), Long.valueOf(System.currentTimeMillis()) });
          v.this.aqv(4);
          v.this.UvO.UyV.fwk();
        }
        AppMethodBeat.o(115157);
        return false;
      }
    }, false);
    this.UCE = new byte[500];
    this.UCF = new MTimerHandler(Looper.getMainLooper(), new MTimerHandler.CallBack()
    {
      public final boolean onTimerExpired()
      {
        AppMethodBeat.i(115158);
        Object localObject = v.this.UvO;
        ((l)localObject).Uzc += 1;
        if (v.this.UvO.UyU.roomId == 0)
        {
          com.tencent.mm.plugin.voip.f.g.Loge("MicroMsg.Voip.VoipServiceEx", com.tencent.mm.compatible.util.f.aPX() + "double link switch roomId == 0 ");
          v.a(v.this).stopTimer();
        }
        for (;;)
        {
          AppMethodBeat.o(115158);
          return true;
          v.this.UvO.UyU.app2EngineDataEx(v.this.UvO.UyU.UFe, v.this.UvO.UyU.UFf, v.this.UvO.UyU.UFg, 0, 0);
          if ((!v.this.UvO.Uzb) && (1 == v.this.UvO.UyU.field_mGetValidSample))
          {
            v.this.UvO.Uzb = true;
            v.this.UvO.Uzd = v.this.UvO.Uzc;
          }
          if (1 == v.this.UvO.UyH) {
            v.this.UvO.UyH = 15;
          }
          if ((true == v.this.UvO.Uzb) && (v.this.UvO.Uzc - v.this.UvO.Uzd == v.this.UvO.UyH) && ((v.this.UvO.UyU.UEV & 0x1) == 0))
          {
            v.this.UvO.Uzd = v.this.UvO.Uzc;
            int i = v.this.UvO.UyU.isDCSameLan();
            int k = v.this.UvO.UyU.getCurrentConnType();
            if ((1 == i) && (1 == k))
            {
              com.tencent.mm.plugin.voip.f.g.Logi("MicroMsg.Voip.VoipServiceEx", "zhengxue[DOUBLELINK]  In the Same LAN, isDCSameLan = ".concat(String.valueOf(i)));
              localObject = v.this.UvO;
              ((l)localObject).Uzc += 1;
              AppMethodBeat.o(115158);
              return true;
            }
            int m = v.this.UvO.UyU.getcurstrategy();
            int n = v.this.UvO.UyU.isRelayConnReady();
            int i1 = v.this.UvO.UyU.isDCReady();
            int j = v.this.UvO.UyH - 3;
            i = j;
            if (j > 15) {
              i = 15;
            }
            v.this.UvO.UyU.app2EngineLinkQualityEx(i, v.b(v.this));
            new com.tencent.mm.plugin.voip.model.a.d(v.this.UvO.UyU.roomId, v.this.UvO.UyU.Hnt, v.this.UvO.UyU.JHb, k, n, i1, m, v.b(v.this), v.this.UvO.UyU.field_realLinkQualityInfoBuffLen).hYW();
            localObject = v.this.UvO.UyU;
            ((v2protocal)localObject).UEX += 1;
            com.tencent.mm.plugin.voip.f.g.Logi("MicroMsg.Voip.VoipServiceEx", "zhengxue[DOUBLELINK]  doubleLinkSwitchReportStatus " + v.this.UvO.UyH + " isFirstValidSampleSet " + v.this.UvO.Uzb + " mGetValidSample " + v.this.UvO.UyU.field_mGetValidSample + "mDoubleLinkSwitchReqCnt " + v.this.UvO.UyU.UEX + "mTimerCounter " + v.this.UvO.Uzc + "mLastSwitchTimer " + v.this.UvO.Uzd);
          }
        }
      }
    }, true);
    this.UCG = new MTimerHandler(Looper.getMainLooper(), new MTimerHandler.CallBack()
    {
      public final boolean onTimerExpired()
      {
        AppMethodBeat.i(115159);
        if (v.this.UvO.UyU.roomId == 0)
        {
          com.tencent.mm.plugin.voip.f.g.Loge("MicroMsg.Voip.VoipServiceEx", com.tencent.mm.compatible.util.f.aPX() + " roomId == 0 ");
          v.c(v.this).stopTimer();
        }
        label157:
        for (;;)
        {
          AppMethodBeat.o(115159);
          return true;
          if (v.this.UvO.mStatus >= 5) {}
          for (int i = 1;; i = 0)
          {
            if (i == 0) {
              break label157;
            }
            com.tencent.mm.plugin.voip.model.a.f localf = new com.tencent.mm.plugin.voip.model.a.f(v.this.UvO.UyU.roomId, v.this.UvO.UyU.Hnt, v.this.UvO.Uzj);
            v.this.UvO.UyU.UFN.UAR = System.currentTimeMillis();
            localf.hYW();
            break;
          }
        }
      }
    }, true);
    this.UCH = new MTimerHandler(Looper.getMainLooper(), new MTimerHandler.CallBack()
    {
      public final boolean onTimerExpired()
      {
        AppMethodBeat.i(293339);
        Log.i("MicroMsg.Voip.VoipServiceEx", "voip called out of time,now destroy...");
        if ((3 == v.this.UvO.mStatus) && (v.d(v.this) != 0) && (v.d(v.this) == v.this.UvO.UyU.roomId))
        {
          v.e(v.this);
          v.this.UvO.S(5, -9000, "");
        }
        AppMethodBeat.o(293339);
        return false;
      }
    }, true);
    this.UvO = m.hWU();
    this.UvO.a(this);
    this.UCw = false;
    this.UCx = 0;
    this.UCy = false;
    this.UCz = null;
    AppMethodBeat.o(115162);
  }
  
  private void hYJ()
  {
    AppMethodBeat.i(115166);
    Log.d("MicroMsg.Voip.VoipServiceEx", "reset");
    this.UCG.stopTimer();
    this.UCD.stopTimer();
    this.UCF.stopTimer();
    this.UCH.stopTimer();
    this.UCi = 0;
    AppMethodBeat.o(115166);
  }
  
  private boolean hYL()
  {
    AppMethodBeat.i(115169);
    boolean bool = false;
    if (this.UvO != null) {
      bool = this.UvO.hWz();
    }
    AppMethodBeat.o(115169);
    return bool;
  }
  
  public static boolean hYM()
  {
    AppMethodBeat.i(115171);
    if (((TelephonyManager)MMApplicationContext.getContext().getSystemService("phone")).getCallState() != 0)
    {
      AppMethodBeat.o(115171);
      return true;
    }
    AppMethodBeat.o(115171);
    return false;
  }
  
  public final void S(int paramInt1, int paramInt2, String paramString)
  {
    AppMethodBeat.i(115173);
    Log.i("MicroMsg.Voip.VoipServiceEx", "onFinishVoIP finishType: ".concat(String.valueOf(paramInt1)));
    switch (paramInt1)
    {
    }
    for (;;)
    {
      AppMethodBeat.o(115173);
      return;
      this.UvO.UyV.fvW();
      paramString = com.tencent.mm.plugin.voip.d.c.UGb;
      com.tencent.mm.plugin.voip.d.c.a(c.a.UGL);
      hYO();
      AppMethodBeat.o(115173);
      return;
      this.UvO.UyV.fwk();
      paramString = com.tencent.mm.plugin.voip.d.c.UGb;
      com.tencent.mm.plugin.voip.d.c.a(c.a.UGK);
      hYO();
      AppMethodBeat.o(115173);
      return;
      this.UvO.UyV.vI(true);
      paramString = com.tencent.mm.plugin.voip.d.c.UGb;
      com.tencent.mm.plugin.voip.d.c.a(c.a.UGH);
      hYO();
      AppMethodBeat.o(115173);
      return;
      this.UvO.UyV.onError(paramInt2, paramString);
      paramString = com.tencent.mm.plugin.voip.d.c.UGb;
      com.tencent.mm.plugin.voip.d.c.a(c.a.UGI);
      hYO();
    }
  }
  
  public final int a(byte[] paramArrayOfByte1, int paramInt1, int paramInt2, int paramInt3, int paramInt4, byte[] paramArrayOfByte2, int paramInt5, int paramInt6, int paramInt7, int paramInt8)
  {
    AppMethodBeat.i(293501);
    paramInt1 = this.UvO.UyW.a(paramArrayOfByte1, paramInt1, paramInt2, paramInt3, paramInt4, paramArrayOfByte2, paramInt5, paramInt6, paramInt7, paramInt8);
    AppMethodBeat.o(293501);
    return paramInt1;
  }
  
  public final void a(int paramInt1, long paramLong, int paramInt2, byte[] paramArrayOfByte1, byte[] paramArrayOfByte2, String paramString)
  {
    AppMethodBeat.i(115184);
    com.tencent.mm.plugin.voip.f.g.Logi("MicroMsg.Voip.VoipServiceEx", "doAck roomId " + paramInt1 + "  roomKey " + paramLong + " status " + paramInt2);
    if ((paramInt1 != 0) && (paramLong != 0L))
    {
      LinkedList localLinkedList = new LinkedList();
      this.UvO.cb(localLinkedList);
      this.UvO.UyU.UEm = ("ack:" + this.UvO.UyU.UEh + ":" + this.UvO.UyU.UEi);
      paramArrayOfByte1 = new com.tencent.mm.plugin.voip.model.a.a(paramInt1, paramLong, paramInt2, paramArrayOfByte1, paramArrayOfByte2, paramString, localLinkedList);
      this.UvO.UyU.UFN.UAO = System.currentTimeMillis();
      paramArrayOfByte1.hYW();
    }
    paramArrayOfByte1 = com.tencent.mm.plugin.voip.d.c.UGb;
    com.tencent.mm.plugin.voip.d.c.a(Integer.valueOf(paramInt1), Long.valueOf(paramLong), paramString);
    paramArrayOfByte1 = com.tencent.mm.plugin.voip.d.f.UGZ;
    com.tencent.mm.plugin.voip.d.f.a(Integer.valueOf(paramInt1), Long.valueOf(paramLong), paramString);
    paramArrayOfByte1 = com.tencent.mm.plugin.voip.d.i.UHA;
    com.tencent.mm.plugin.voip.d.i.bi(SubCoreVoip.hVp().hYr(), SubCoreVoip.hVp().hVw());
    if (SubCoreVoip.hVs()) {
      this.UvO.geA();
    }
    AppMethodBeat.o(115184);
  }
  
  public final void a(Context paramContext, x paramx)
  {
    AppMethodBeat.i(293396);
    this.UvO.xNl = paramContext;
    this.UvO.UyV = paramx;
    com.tencent.mm.plugin.voip.f.g.Logd("MicroMsg.Voip.VoipServiceEx", "attach ui........");
    com.tencent.mm.plugin.voip.f.g.ibt();
    AppMethodBeat.o(293396);
  }
  
  public final boolean a(gaq paramgaq)
  {
    int i = 1;
    AppMethodBeat.i(115178);
    if (this.UvO.hWB())
    {
      com.tencent.mm.plugin.voip.f.g.Loge("MicroMsg.Voip.VoipServiceEx", "Failed to setInviteContent during calling, status =" + this.UvO.mStatus);
      AppMethodBeat.o(115178);
      return false;
    }
    if (paramgaq == null)
    {
      AppMethodBeat.o(115178);
      return false;
    }
    this.UvO.UyU.UFN.UAs = paramgaq.abXQ;
    Log.d("MicroMsg.Voip.VoipServiceEx", "iRoomType " + this.UvO.UyU.UFN.UAs);
    if (this.UvO.UyU.hZm())
    {
      com.tencent.mm.plugin.voip.f.g.Logw("MicroMsg.Voip.VoipServiceEx", com.tencent.mm.compatible.util.f.aPX() + "v2protocal already init.");
      this.UvO.UyU.Gw(false);
      this.UvO.UyU.reset();
    }
    if (!this.UvO.a(paramgaq))
    {
      AppMethodBeat.o(115178);
      return false;
    }
    boolean bool = ((com.tencent.d.a.a.a.b)com.tencent.mm.kernel.h.az(com.tencent.d.a.a.a.b.class)).isAnchorLiving();
    if ((com.tencent.mm.plugin.voip.f.m.icd()) || (com.tencent.mm.n.a.aTe()) || (com.tencent.mm.plugin.voip.f.m.icf()) || (com.tencent.mm.n.a.aTg()) || (bool))
    {
      Log.e("MicroMsg.Voip.VoipServiceEx", "setInviteContent, reject, pstn/multitak/f2f talking");
      if ((com.tencent.mm.plugin.voip.f.m.icd()) || (com.tencent.mm.n.a.aTg()) || (bool))
      {
        a(paramgaq.Zvz, paramgaq.ZvA, 2, null, null, paramgaq.abXZ);
        AppMethodBeat.o(115178);
        return false;
      }
      hYo();
      if (paramgaq.abXQ == 0)
      {
        label304:
        localObject = paramgaq.abXZ;
        if (i == 0) {
          break label346;
        }
      }
      label346:
      for (paramgaq = cc.adkp;; paramgaq = cc.adko)
      {
        s.a((String)localObject, paramgaq, 0, 6, MMApplicationContext.getContext().getString(b.g.voip_callfrom_reject_msg), false);
        break;
        i = 0;
        break label304;
      }
    }
    if (this.UvO.UyU.hCe() < 0)
    {
      com.tencent.mm.plugin.voip.f.g.Loge("MicroMsg.Voip.VoipServiceEx", "Failed to init v2protocol.");
      AppMethodBeat.o(115178);
      return false;
    }
    if (v2protocal.UFS != null) {
      v2protocal.UFS.a(this.UvO);
    }
    com.tencent.mm.plugin.report.service.h.OAn.a(11524, true, true, new Object[] { Integer.valueOf(paramgaq.Zvz), Long.valueOf(paramgaq.ZvA), Integer.valueOf(paramgaq.abXQ), Integer.valueOf(0), Long.valueOf(System.currentTimeMillis()) });
    if (!this.UCw) {
      this.UvO.UyV.fwd();
    }
    Object localObject = com.tencent.mm.plugin.voip.d.c.UGb;
    com.tencent.mm.plugin.voip.d.c.a(Integer.valueOf(SubCoreVoip.hVp().hYr()), Long.valueOf(SubCoreVoip.hVp().hVw()), paramgaq.abXZ);
    localObject = com.tencent.mm.plugin.voip.d.f.UGZ;
    com.tencent.mm.plugin.voip.d.f.a(Integer.valueOf(SubCoreVoip.hVp().hYr()), Long.valueOf(SubCoreVoip.hVp().hVw()), paramgaq.abXZ);
    paramgaq = com.tencent.mm.plugin.voip.d.i.UHA;
    com.tencent.mm.plugin.voip.d.i.bi(SubCoreVoip.hVp().hYr(), SubCoreVoip.hVp().hVw());
    AppMethodBeat.o(115178);
    return true;
  }
  
  public final void aqh(int paramInt)
  {
    AppMethodBeat.i(115187);
    this.UvO.aqh(paramInt);
    AppMethodBeat.o(115187);
  }
  
  public final boolean aqm(int paramInt)
  {
    AppMethodBeat.i(293506);
    boolean bool = this.UvO.aqm(paramInt);
    AppMethodBeat.o(293506);
    return bool;
  }
  
  public final void aqt(int paramInt)
  {
    AppMethodBeat.i(115167);
    this.UvO.aqd(paramInt);
    AppMethodBeat.o(115167);
  }
  
  public final int aqv(int paramInt)
  {
    AppMethodBeat.i(115176);
    if (!this.UvO.hWB())
    {
      com.tencent.mm.plugin.voip.f.g.Loge("MicroMsg.Voip.VoipServiceEx", "Failed to cancel call ,as not in calling.");
      AppMethodBeat.o(115176);
      return -1;
    }
    Log.i("MicroMsg.Voip.VoipServiceEx", "cancelCallEx, roomId:%d, msgID:%d, inviteId:%d, cancelType:%d", new Object[] { Integer.valueOf(this.UvO.UyU.roomId), Integer.valueOf(this.UvO.UyU.UDr), Integer.valueOf(this.UvO.UyU.JGW), Integer.valueOf(paramInt) });
    synchronized (this.UCh)
    {
      if ((this.UvO.UyU.roomId == 0) && (this.UvO.UyU.JGW == 0))
      {
        com.tencent.mm.plugin.voip.f.g.Loge("MicroMsg.Voip.VoipServiceEx", "Failed to cancel call with roomid = 0 and inviteId = 0 ");
        AppMethodBeat.o(115176);
        return -1;
      }
      if (this.UvO.UyU.hZm())
      {
        this.UvO.UyU.Gw(true);
        new com.tencent.mm.plugin.voip.model.a.c(this.UvO.UyU.roomId, this.UvO.UyU.Hnt, this.UvO.UyU.mkQ, "", this.UvO.UyU.JGW, paramInt).hYW();
      }
      Object localObject2 = this.UvO.UyU.UFN;
      ((o)localObject2).UAC = ((int)(System.currentTimeMillis() - ((o)localObject2).UAM));
      com.tencent.mm.plugin.voip.f.g.Logd("MicroMsg.VoipDailReport", "devin:cancelInvite:" + ((o)localObject2).UAC);
      if ((this.UvO.UyU.UDK == 0) && (this.UvO.UyU.UDL == 0)) {
        this.UvO.hWx();
      }
      if (this.wVi != null) {
        this.UvO.aqf(this.wVi.ict());
      }
      this.UvO.UyU.UFN.UAX = this.UvO.UyV.fwn();
      if (SubCoreVoip.hVp().UBF != null)
      {
        this.UvO.UyU.UFN.UAY = SubCoreVoip.hVp().UBF.hVm();
        this.UvO.UyU.UFN.LiJ = (SubCoreVoip.hVp().UBF.hVk() / 1000L);
        this.UvO.UyU.UFN.LiK = (SubCoreVoip.hVp().UBF.hVl() / 1000L);
      }
      localObject2 = v2protocal.hZq();
      String str1 = this.UvO.UyU.hZr();
      String str2 = this.UvO.UyU.hZw();
      String str3 = this.UvO.UyU.hZi();
      String str4 = this.UvO.UyU.hZk();
      String[] arrayOfString1 = this.UvO.UyU.hZs();
      String[] arrayOfString2 = this.UvO.UyU.hZt();
      String[] arrayOfString3 = this.UvO.UyU.hZu();
      String[] arrayOfString4 = this.UvO.UyU.hZv();
      if (str1.length() > 0) {
        new com.tencent.mm.plugin.voip.model.a.l((String)localObject2, str1, str3, str2, str4, arrayOfString1, arrayOfString2, arrayOfString3, arrayOfString4).hYW();
      }
      this.UvO.hWv();
      reset();
      this.UvO.UyU.roomId = 0;
      this.UvO.UyU.JGW = 0;
      AppMethodBeat.o(115176);
      return 0;
    }
  }
  
  public final void aqw(int paramInt)
  {
    AppMethodBeat.i(115196);
    this.UCi = paramInt;
    if (!this.UCH.stopped()) {
      this.UCH.stopTimer();
    }
    this.UCH.startTimer(70000L);
    AppMethodBeat.o(115196);
  }
  
  public final void b(Context paramContext, x paramx)
  {
    AppMethodBeat.i(293400);
    if ((paramContext != this.UvO.xNl) || (paramx != this.UvO.UyV))
    {
      com.tencent.mm.plugin.voip.f.g.Logd("MicroMsg.Voip.VoipServiceEx", "cannot detach other's ui.");
      AppMethodBeat.o(293400);
      return;
    }
    this.UvO.xNl = null;
    this.UvO.UyV = x.UCS;
    com.tencent.mm.plugin.voip.f.g.Logd("MicroMsg.Voip.VoipServiceEx", "detach ui........");
    com.tencent.mm.plugin.voip.f.g.flushLogFile();
    AppMethodBeat.o(293400);
  }
  
  public final int bq(boolean paramBoolean1, boolean paramBoolean2)
  {
    AppMethodBeat.i(115179);
    hYQ();
    if (!this.UCH.stopped()) {
      this.UCH.stopTimer();
    }
    this.UvO.UyU.UFN.hXe();
    Log.i("MicroMsg.Voip.VoipServiceEx", "accept onlyAudio:".concat(String.valueOf(paramBoolean1)));
    if (!this.UvO.hWA())
    {
      com.tencent.mm.plugin.voip.f.g.Loge("MicroMsg.Voip.VoipServiceEx", "Failed to accept with calling, status =" + this.UvO.mStatus);
      AppMethodBeat.o(115179);
      return -1;
    }
    if (this.UvO.UyU.roomId == 0)
    {
      com.tencent.mm.plugin.voip.f.g.Loge("MicroMsg.Voip.VoipServiceEx", "Failed to accept with roomid = 0. ");
      AppMethodBeat.o(115179);
      return -1;
    }
    Object localObject = new LinkedList();
    this.UvO.cb((LinkedList)localObject);
    this.UvO.UyU.UEm = (this.UvO.UyU.UEm + "|answer:" + this.UvO.UyU.UEh + ":" + this.UvO.UyU.UEi);
    com.tencent.mm.plugin.voip.f.g.Logd("MicroMsg.Voip.VoipServiceEx", com.tencent.mm.compatible.util.f.aPX() + "accept invite, roomid:" + this.UvO.UyU.roomId + " nic list size:" + ((LinkedList)localObject).size());
    this.UCG.startTimer(50000L);
    this.UvO.UyU.UFN.hXf();
    localObject = new com.tencent.mm.plugin.voip.model.a.b(1, this.UvO.UyU.netType, this.UvO.UyU.roomId, this.UvO.UyU.field_peerId, this.UvO.UyU.field_capInfo, this.UvO.UyU.Hnt, paramBoolean1, paramBoolean2, (LinkedList)localObject);
    this.UvO.UyU.UFN.UAP = System.currentTimeMillis();
    ((com.tencent.mm.plugin.voip.model.a.b)localObject).hYW();
    this.UvO.setStatus(4);
    this.UvO.UyW.wTK = 1;
    this.UvO.hWt = true;
    AppMethodBeat.o(115179);
    return 0;
  }
  
  public final int e(int paramInt1, long paramLong, int paramInt2)
  {
    AppMethodBeat.i(115177);
    if (!this.UvO.hWB())
    {
      com.tencent.mm.plugin.voip.f.g.Loge("MicroMsg.Voip.VoipServiceEx", "steve:[simucall]Failed to cancel call ,as not in calling.");
      AppMethodBeat.o(115177);
      return -1;
    }
    Log.i("MicroMsg.Voip.VoipServiceEx", "steve:[simucall] try to cancel my invite due to Simulcall(callee), roomId:%s, roomKey:%s, roomType:%d, msgID:%d, inviteId:%d", new Object[] { Integer.valueOf(paramInt1), Long.valueOf(paramLong), Integer.valueOf(paramInt2), Integer.valueOf(this.UvO.UyU.UDr), Integer.valueOf(this.UvO.UyU.JGW) });
    Object localObject1 = this.UCh;
    if (paramInt1 != 0) {}
    try
    {
      if (this.UvO.UyU.JGW == 0)
      {
        com.tencent.mm.plugin.voip.f.g.Loge("MicroMsg.Voip.VoipServiceEx", "steve:[simucall] Failed to cancel call with roomid = 0 and inviteId = 0 ");
        return -1;
      }
      new com.tencent.mm.plugin.voip.model.a.c(paramInt1, paramLong, this.UvO.UyU.mkQ, "", this.UvO.UyU.JGW, 2).hYW();
      com.tencent.mm.plugin.report.service.h.OAn.a(11521, true, true, new Object[] { Integer.valueOf(paramInt1), Long.valueOf(paramLong), Integer.valueOf(paramInt2), Integer.valueOf(2), Long.valueOf(System.currentTimeMillis()), Long.valueOf(System.currentTimeMillis()) });
      Log.i("MicroMsg.Voip.VoipServiceEx", "steve:[simucall] voipcancelinvite sent!");
      return 0;
    }
    finally
    {
      AppMethodBeat.o(115177);
    }
  }
  
  protected final void finalize()
  {
    AppMethodBeat.i(115164);
    stop();
    super.finalize();
    AppMethodBeat.o(115164);
  }
  
  public final boolean hWB()
  {
    AppMethodBeat.i(115170);
    if (this.UvO.hWB())
    {
      AppMethodBeat.o(115170);
      return true;
    }
    AppMethodBeat.o(115170);
    return false;
  }
  
  public final boolean hYK()
  {
    AppMethodBeat.i(115168);
    Log.i("MicroMsg.Voip.VoipServiceEx", "isRoomReady, roomId: " + this.UvO.UyU.roomId);
    if ((this.UvO.UyU.roomId != 0) && (!hYL()))
    {
      AppMethodBeat.o(115168);
      return true;
    }
    AppMethodBeat.o(115168);
    return false;
  }
  
  public final void hYN()
  {
    AppMethodBeat.i(115172);
    if (this.UvO.hWB()) {
      com.tencent.mm.plugin.voip.f.g.Loge("MicroMsg.Voip.VoipServiceEx", "checkStartup failed, stauts = " + this.UvO.mStatus);
    }
    com.tencent.mm.plugin.voip.f.g.Loge("MicroMsg.Voip.VoipServiceEx", "checkStartup...devicekey = " + co.jcP());
    this.UvO.hWw();
    hYJ();
    af.Ds(com.tencent.mm.kernel.h.baE().bao().jcN());
    AppMethodBeat.o(115172);
  }
  
  public final int hYO()
  {
    AppMethodBeat.i(115182);
    com.tencent.mm.plugin.voip.f.g.Logi("MicroMsg.Voip.VoipServiceEx", "hangUp,status:" + this.UvO.mStatus + " roomid:" + this.UvO.UyU.roomId + ",threadid = " + Thread.currentThread().getId());
    this.UvO.UyW.hWX();
    this.UvO.geB();
    if (this.UvO.UyU.UFN.UAr == 1)
    {
      ??? = this.UvO.UyU.UFN;
      if (((o)???).UAI != 0L) {
        break label630;
      }
      ((o)???).UAB = 0;
    }
    for (;;)
    {
      if (((o)???).UAB < 0)
      {
        ((o)???).UAB = 0;
        com.tencent.mm.plugin.voip.f.g.Loge("MicroMsg.VoipDailReport", "devin:endTalk, iCallTime Err, rest 0");
      }
      com.tencent.mm.plugin.voip.f.g.Logi("MicroMsg.VoipDailReport", "devin:endTalk:" + ((o)???).UAB);
      synchronized (this.UCh)
      {
        int i = this.UvO.UyU.UFN.UAt;
        if ((this.UvO.UyU.roomId != 0) || (8 == i) || (9 == i) || (10 == i) || (11 == i) || (12 == i) || (99 == i))
        {
          com.tencent.mm.plugin.voip.f.g.Logi("MicroMsg.Voip.VoipServiceEx", "steve:hangUp, uninitGLRender before protocalUninit first!!");
          if (this.UvO.UyU.hZm())
          {
            this.UvO.UyU.Gw(true);
            new com.tencent.mm.plugin.voip.model.a.i(this.UvO.UyU.roomId, this.UvO.UyU.Hnt, "").hYW();
            com.tencent.mm.plugin.voip.f.g.Loge("MicroMsg.Voip.VoipServiceEx", "devin: shutdown cgi ");
          }
          this.UvO.UyU.UFN.UAX = this.UvO.UyV.fwn();
          if (SubCoreVoip.hVp().UBF != null)
          {
            this.UvO.UyU.UFN.UAY = SubCoreVoip.hVp().UBF.hVm();
            this.UvO.UyU.UFN.LiJ = (SubCoreVoip.hVp().UBF.hVk() / 1000L);
            this.UvO.UyU.UFN.LiK = (SubCoreVoip.hVp().UBF.hVl() / 1000L);
          }
          if (this.wVi != null) {
            this.UvO.aqf(this.wVi.ict());
          }
          String str1 = v2protocal.hZq();
          String str2 = this.UvO.UyU.hZr();
          String str3 = this.UvO.UyU.hZw();
          String str4 = this.UvO.UyU.hZi();
          String str5 = this.UvO.UyU.hZk();
          String[] arrayOfString1 = this.UvO.UyU.hZs();
          String[] arrayOfString2 = this.UvO.UyU.hZt();
          String[] arrayOfString3 = this.UvO.UyU.hZu();
          String[] arrayOfString4 = this.UvO.UyU.hZv();
          if (str2.length() > 0)
          {
            new com.tencent.mm.plugin.voip.model.a.l(str1, str2, str4, str3, str5, arrayOfString1, arrayOfString2, arrayOfString3, arrayOfString4).hYW();
            com.tencent.mm.plugin.voip.f.g.Loge("MicroMsg.Voip.VoipServiceEx", "devin: statreport cgi ");
          }
          this.UvO.hWv();
          reset();
          this.UvO.UyU.roomId = 0;
          com.tencent.mm.plugin.voip.f.g.Logd("MicroMsg.Voip.VoipServiceEx", "hangUp over");
          AppMethodBeat.o(115182);
          return 0;
          label630:
          ((o)???).UAB = ((int)((System.currentTimeMillis() - ((o)???).UAI) / 1000L));
          continue;
        }
        com.tencent.mm.plugin.voip.f.g.Loge("MicroMsg.Voip.VoipServiceEx", "call hangUp roomId == 0 ");
      }
    }
  }
  
  public final void hYP()
  {
    AppMethodBeat.i(115185);
    Object localObject = new LinkedList();
    this.UvO.UyU.cc((LinkedList)localObject);
    int j = 0;
    int m = 0;
    int n;
    for (int i = 0; j < ((LinkedList)localObject).size(); i = n)
    {
      int k;
      if (((dtl)((LinkedList)localObject).get(j)).Zoz != 5)
      {
        k = m;
        if (((dtl)((LinkedList)localObject).get(j)).Zoz != 6) {}
      }
      else
      {
        k = m + 1;
      }
      n = i;
      if (((dtl)((LinkedList)localObject).get(j)).Zoz == 4) {
        n = i + 1;
      }
      j += 1;
      m = k;
    }
    this.UvO.UyU.UEm = (this.UvO.UyU.UEm + "|redirect:" + i + ":" + m);
    localObject = new com.tencent.mm.plugin.voip.model.a.h(this.UvO.UyU.roomId, this.UvO.UyU.Hnt, this.UvO.UyU.JHb, 0, 0, null, (LinkedList)localObject);
    this.UvO.UyU.UFN.UAS = System.currentTimeMillis();
    ((com.tencent.mm.plugin.voip.model.a.h)localObject).hYW();
    AppMethodBeat.o(115185);
  }
  
  public final void hYQ()
  {
    AppMethodBeat.i(115197);
    if (this.UCD != null)
    {
      com.tencent.mm.plugin.voip.f.g.Logi("MicroMsg.Voip.VoipServiceEx", "devincdai: voip reset timecount");
      this.UCD.stopTimer();
      this.UCD.startTimer(60000L);
    }
    AppMethodBeat.o(115197);
  }
  
  public final int hYn()
  {
    AppMethodBeat.i(115175);
    Log.i("MicroMsg.Voip.VoipServiceEx", "cancelCall, roomId:" + this.UvO.UyU.roomId);
    if ((this.UvO.UyU.roomId == 0) && (this.UvO.UyU.JGW == 0))
    {
      reset();
      AppMethodBeat.o(115175);
      return -1;
    }
    this.UvO.UyU.UFN.UAh = this.UvO.hWy();
    this.UvO.UyU.UFN.UAt = 3;
    if (this.UvO.mStatus < 6) {
      this.UvO.UyU.UFN.UAv = 1;
    }
    com.tencent.mm.plugin.report.service.h.OAn.a(11521, true, true, new Object[] { Integer.valueOf(SubCoreVoip.hVp().hYr()), Long.valueOf(SubCoreVoip.hVp().hVw()), Long.valueOf(SubCoreVoip.hVp().hWC()), Integer.valueOf(1), Long.valueOf(System.currentTimeMillis()), Long.valueOf(System.currentTimeMillis()) });
    int i = aqv(1);
    AppMethodBeat.o(115175);
    return i;
  }
  
  public final int hYo()
  {
    AppMethodBeat.i(115180);
    Log.i("MicroMsg.Voip.VoipServiceEx", "reject");
    if (!this.UvO.hWA())
    {
      com.tencent.mm.plugin.voip.f.g.Loge("MicroMsg.Voip.VoipServiceEx", "Failed to reject with calling, status =" + this.UvO.mStatus);
      AppMethodBeat.o(115180);
      return -1;
    }
    synchronized (this.UCh)
    {
      if (this.UvO.UyU.roomId == 0)
      {
        com.tencent.mm.plugin.voip.f.g.Loge("MicroMsg.Voip.VoipServiceEx", "Failed to reject with roomid = 0. ");
        AppMethodBeat.o(115180);
        return -1;
      }
      this.UvO.UyU.UFN.hXf();
      com.tencent.mm.plugin.voip.f.g.Logd("MicroMsg.Voip.VoipServiceEx", " reject, status:" + this.UvO.mStatus + " roomid:" + this.UvO.UyU.roomId);
      int i = this.UvO.UyU.netType;
      int j = this.UvO.UyU.roomId;
      long l = this.UvO.UyU.Hnt;
      Object localObject2 = new com.tencent.mm.plugin.voip.model.a.b(2, i, j, new byte[0], new byte[0], l, false, false, null);
      this.UvO.UyU.UFN.UAP = System.currentTimeMillis();
      ((com.tencent.mm.plugin.voip.model.a.b)localObject2).hYW();
      if ((this.UvO.UyU.UDK == 0) && (this.UvO.UyU.UDL == 0)) {
        this.UvO.hWx();
      }
      if (this.wVi != null) {
        this.UvO.aqf(this.wVi.ict());
      }
      this.UvO.UyU.UFN.UAX = this.UvO.UyV.fwn();
      if (SubCoreVoip.hVp().UBF != null)
      {
        this.UvO.UyU.UFN.UAY = SubCoreVoip.hVp().UBF.hVm();
        this.UvO.UyU.UFN.LiJ = (SubCoreVoip.hVp().UBF.hVk() / 1000L);
        this.UvO.UyU.UFN.LiK = (SubCoreVoip.hVp().UBF.hVl() / 1000L);
      }
      if (this.UvO.UyU.hZm()) {
        this.UvO.UyU.Gw(true);
      }
      localObject2 = v2protocal.hZq();
      String str1 = this.UvO.UyU.hZr();
      String str2 = this.UvO.UyU.hZw();
      String str3 = this.UvO.UyU.hZi();
      String str4 = this.UvO.UyU.hZk();
      String[] arrayOfString1 = this.UvO.UyU.hZs();
      String[] arrayOfString2 = this.UvO.UyU.hZt();
      String[] arrayOfString3 = this.UvO.UyU.hZu();
      String[] arrayOfString4 = this.UvO.UyU.hZv();
      com.tencent.mm.plugin.voip.f.g.Logd("MicroMsg.Voip.VoipServiceEx", "devin: statreport");
      if (str1.length() > 0)
      {
        com.tencent.mm.plugin.voip.f.g.Logd("MicroMsg.Voip.VoipServiceEx", "devin: reject() newdialInfo.length() > 0");
        new com.tencent.mm.plugin.voip.model.a.l((String)localObject2, str1, str3, str2, str4, arrayOfString1, arrayOfString2, arrayOfString3, arrayOfString4).hYW();
        this.UvO.hWv();
        reset();
        this.UvO.UyU.roomId = 0;
        AppMethodBeat.o(115180);
        return 0;
      }
      com.tencent.mm.plugin.voip.f.g.Logd("MicroMsg.Voip.VoipServiceEx", "devin: reject() newdialInfo.length() <= 0");
    }
  }
  
  public final int hYp()
  {
    AppMethodBeat.i(115181);
    Log.i("MicroMsg.Voip.VoipServiceEx", "hangUp");
    if (this.UvO.UyU.roomId == 0)
    {
      this.UvO.UyW.hWX();
      this.UvO.geB();
      reset();
      AppMethodBeat.o(115181);
      return 0;
    }
    this.UvO.UyU.UFN.UAh = this.UvO.hWy();
    int i = hYO();
    AppMethodBeat.o(115181);
    return i;
  }
  
  public final int hYq()
  {
    AppMethodBeat.i(115183);
    Log.i("MicroMsg.Voip.VoipServiceEx", "ignoreInvite");
    if (!this.UvO.hWA())
    {
      com.tencent.mm.plugin.voip.f.g.Loge("MicroMsg.Voip.VoipServiceEx", "Failed to ignore with calling, status =" + this.UvO.mStatus);
      AppMethodBeat.o(115183);
      return -1;
    }
    synchronized (this.UCh)
    {
      if (this.UvO.UyU.roomId == 0)
      {
        com.tencent.mm.plugin.voip.f.g.Loge("MicroMsg.Voip.VoipServiceEx", "Failed to reject with roomid = 0. ");
        AppMethodBeat.o(115183);
        return -1;
      }
      int i = this.UvO.UyU.netType;
      int j = this.UvO.UyU.roomId;
      long l = this.UvO.UyU.Hnt;
      com.tencent.mm.plugin.voip.model.a.b localb = new com.tencent.mm.plugin.voip.model.a.b(3, i, j, new byte[0], new byte[0], l, false, false, null);
      this.UvO.UyU.UFN.UAP = System.currentTimeMillis();
      localb.hYW();
      reset();
      this.UvO.UyU.roomId = 0;
      AppMethodBeat.o(115183);
      return 0;
    }
  }
  
  public final int hy(String paramString, int paramInt)
  {
    AppMethodBeat.i(115174);
    Log.i("MicroMsg.Voip.VoipServiceEx", "call username:%s, callType:%d, inviteType:%d", new Object[] { paramString, Integer.valueOf(0), Integer.valueOf(paramInt) });
    if (Util.isNullOrNil(paramString))
    {
      com.tencent.mm.plugin.voip.f.g.Loge("MicroMsg.Voip.VoipServiceEx", "Failed call without valid username.");
      AppMethodBeat.o(115174);
      return -1;
    }
    if (this.UvO.hWB())
    {
      com.tencent.mm.plugin.voip.f.g.Loge("MicroMsg.Voip.VoipServiceEx", "Failed call withing calling.");
      AppMethodBeat.o(115174);
      return -1;
    }
    this.UCz = paramString;
    this.UvO.UyU.UDt = 1;
    this.UvO.UyU.mkQ = paramString;
    com.tencent.mm.plugin.voip.f.g.Logd("MicroMsg.Voip.VoipServiceEx", com.tencent.mm.compatible.util.f.aPX() + "call username:" + paramString);
    if (this.UvO.UyU.hZm())
    {
      com.tencent.mm.plugin.voip.f.g.Loge("MicroMsg.Voip.VoipServiceEx", com.tencent.mm.compatible.util.f.aPX() + "v2protocal already init.");
      this.UvO.UyU.Gw(false);
      this.UvO.UyU.reset();
    }
    if (this.UvO.UyU.hCe() < 0)
    {
      com.tencent.mm.plugin.voip.f.g.Loge("MicroMsg.Voip.VoipServiceEx", "Failed to init v2protocol.");
      AppMethodBeat.o(115174);
      return -1;
    }
    if (this.UvO.UyU.UFQ != null) {
      this.UvO.UyU.UFQ.UvO = this.UvO;
    }
    if (v2protocal.UFS != null) {
      v2protocal.UFS.a(this.UvO);
    }
    this.UCG.startTimer(50000L);
    this.UvO.UyU.JGW = ((int)System.currentTimeMillis());
    LinkedList localLinkedList = new LinkedList();
    this.UvO.cb(localLinkedList);
    this.UvO.UyU.UEm = ("invite:" + this.UvO.UyU.UEh + ":" + this.UvO.UyU.UEi);
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(paramString);
    new com.tencent.mm.plugin.voip.model.a.g(localArrayList, this.UvO.UyU.field_peerId, this.UvO.UyU.field_capInfo, this.UvO.UyU.netType, paramInt, this.UvO.UyU.JGW, localLinkedList).hYW();
    this.UvO.setStatus(2);
    this.UvO.UyW.wTK = 1;
    this.UCD.startTimer(60000L);
    this.UvO.UyU.UFN.UAM = System.currentTimeMillis();
    this.UvO.UyU.UFN.beginTime = System.currentTimeMillis();
    this.UvO.UyU.UFN.UAs = paramInt;
    Log.d("MicroMsg.Voip.VoipServiceEx", "iRoomType " + this.UvO.UyU.UFN.UAs);
    if (SubCoreVoip.hVs()) {
      this.UvO.geA();
    }
    AppMethodBeat.o(115174);
    return 0;
  }
  
  public final void reset()
  {
    AppMethodBeat.i(115165);
    Log.d("MicroMsg.Voip.VoipServiceEx", "reset");
    this.toUser = null;
    this.UvH = false;
    this.OEa = false;
    this.UvO.reset();
    this.UCG.stopTimer();
    this.UCD.stopTimer();
    this.UCF.stopTimer();
    this.UCH.stopTimer();
    if (this.UCu != null)
    {
      this.UCu.cancel(false);
      this.UCu = null;
    }
    if (this.UCv != null)
    {
      this.UCv.cancel(false);
      this.UCv = null;
    }
    if (this.UCC != null)
    {
      MMApplicationContext.getContext().unregisterReceiver(this.UCC);
      this.UCC = null;
    }
    com.tencent.mm.plugin.voip.f.a.stop();
    this.UCi = 0;
    SubCoreVoip.hVp().unRegister();
    SubCoreVoip.hVp().Uxv = null;
    this.UCw = false;
    this.UCx = 0;
    this.UCy = false;
    this.UCz = null;
    AppMethodBeat.o(115165);
  }
  
  public final int setNetSignalValue(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(115186);
    paramInt1 = this.UvO.UyU.setNetSignalValue(paramInt1, paramInt2);
    AppMethodBeat.o(115186);
    return paramInt1;
  }
  
  public final void stop()
  {
    AppMethodBeat.i(115163);
    Log.i("MicroMsg.Voip.VoipServiceEx", "stop");
    reset();
    this.UvO.a(null);
    AppMethodBeat.o(115163);
  }
  
  final class a
    implements Runnable
  {
    a() {}
    
    public final void run()
    {
      AppMethodBeat.i(293334);
      Log.d("MicroMsg.Voip.VoipServiceEx", "VOIPBatThermalTask");
      int i;
      Object localObject;
      if (v.f(v.this) != null)
      {
        v.f(v.this);
        i = v.c.hYR();
        localObject = ByteBuffer.allocate(4).putInt(i).array();
        v.this.UvO.UyU.setJNIAppCmd(3, (byte[])localObject, localObject.length);
      }
      for (;;)
      {
        localObject = (PowerManager)MMApplicationContext.getContext().getSystemService("power");
        boolean bool;
        if ((localObject != null) && (Build.VERSION.SDK_INT >= 21))
        {
          bool = ((PowerManager)localObject).isPowerSaveMode();
          if (!bool) {
            break label369;
          }
        }
        label369:
        for (int j = 1;; j = 0)
        {
          localObject = ByteBuffer.allocate(4).putInt(j).array();
          v.this.UvO.UyU.setJNIAppCmd(8, (byte[])localObject, localObject.length);
          if (v.gEO() > 0)
          {
            localObject = ByteBuffer.allocate(4).putInt(v.gEO()).array();
            v.this.UvO.UyU.setJNIAppCmd(7, (byte[])localObject, localObject.length);
          }
          localObject = com.tencent.matrix.a.b.b.axq();
          int[] arrayOfInt = com.tencent.mm.compatible.deviceinfo.m.aOM();
          float f2 = 1.0F / com.tencent.mm.compatible.deviceinfo.n.getNumCores();
          float f1 = 0.0F;
          if ((localObject.length > 0) && (arrayOfInt.length > 0))
          {
            k = 0;
            for (;;)
            {
              if (k < localObject.length)
              {
                int m = localObject[k];
                int n = arrayOfInt[k];
                f1 += m * (100.0F * f2) / n;
                k += 1;
                continue;
                bool = false;
                break;
              }
            }
          }
          for (int k = (int)f1;; k = 0)
          {
            localObject = ByteBuffer.allocate(4).putInt(k).array();
            v.this.UvO.UyU.setJNIAppCmd(4, (byte[])localObject, localObject.length);
            Log.i("MicroMsg.Voip.VoipServiceEx", "battery temp %d, totalCpuUsage %d, pidCpuUsage %d, islowpower %d, islowpowermode %d", new Object[] { Integer.valueOf(i), Integer.valueOf(k), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(j) });
            AppMethodBeat.o(293334);
            return;
          }
        }
        i = 0;
      }
    }
  }
  
  final class b
    implements Runnable
  {
    b() {}
    
    public final void run()
    {
      AppMethodBeat.i(115161);
      Log.d("MicroMsg.Voip.VoipServiceEx", "VOIPwifiStrengthTask");
      MMApplicationContext.getContext();
      int i = com.tencent.mm.plugin.voip.f.g.ibq();
      if (NetStatusUtil.isWifi(MMApplicationContext.getContext()))
      {
        v.aqy(ConnectivityCompat.Companion.getWiFiRssi());
        v.this.setNetSignalValue(4, v.rPb);
      }
      MMApplicationContext.getContext();
      int j = com.tencent.mm.plugin.voip.f.g.ibs();
      v.this.setNetSignalValue(j, v.UCj);
      Log.i("MicroMsg.Voip.VoipServiceEx", "nettype %d wifi rssi %d ratiotype %d radio signal value %d", new Object[] { Integer.valueOf(i), Integer.valueOf(v.rPb), Integer.valueOf(j), Integer.valueOf(v.UCj) });
      AppMethodBeat.o(115161);
    }
  }
  
  final class c
    extends BroadcastReceiver
  {
    c() {}
    
    static int hYR()
    {
      AppMethodBeat.i(293332);
      int i = v.bPa();
      AppMethodBeat.o(293332);
      return i;
    }
    
    public final void onReceive(Context paramContext, final Intent paramIntent)
    {
      AppMethodBeat.i(293335);
      com.tencent.threadpool.h.ahAA.g(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(293285);
          v.aqz(paramIntent.getIntExtra("temperature", 0));
          v.Hn(Util.getInt(com.tencent.mm.compatible.deviceinfo.m.aON(), 0));
          v.aqA(com.tencent.mm.compatible.deviceinfo.m.aOK());
          Object localObject = MMApplicationContext.getContext();
          if (Build.VERSION.SDK_INT >= 21) {}
          for (int i = ((BatteryManager)((Context)localObject).getSystemService("batterymanager")).getIntProperty(4);; i = ((Intent)localObject).getIntExtra("level", -1) * 100 / ((Intent)localObject).getIntExtra("scale", -1))
          {
            v.aqB(i);
            v.this.UvO.UyU.UEn = v.bPa();
            v.this.UvO.UyU.UEq = v.ddn();
            v.this.UvO.UyU.UEt = v.alu();
            v.this.UvO.UyU.UEv = v.gEO();
            if (v.this.UvO.UyU.UEo == 0) {
              v.this.UvO.UyU.UEo = v.bPa();
            }
            if (v.this.UvO.UyU.UEr == 0) {
              v.this.UvO.UyU.UEr = v.ddn();
            }
            if (v.this.UvO.UyU.UEu == 0) {
              v.this.UvO.UyU.UEu = v.gEO();
            }
            if (v.bPa() > v.this.UvO.UyU.UEp) {
              v.this.UvO.UyU.UEp = v.bPa();
            }
            if (v.ddn() > v.this.UvO.UyU.UEs) {
              v.this.UvO.UyU.UEs = v.ddn();
            }
            Log.d("MicroMsg.Voip.VoipServiceEx", "onReceive bat cputemp %d, cpuFreq %d", new Object[] { Integer.valueOf(v.bPa()), Integer.valueOf(v.ddn()) });
            AppMethodBeat.o(293285);
            return;
            localObject = ((Context)localObject).registerReceiver(null, new IntentFilter("android.intent.action.BATTERY_CHANGED"));
            ((Intent)localObject).getIntExtra("status", -1);
            ((Intent)localObject).getIntExtra("level", -1);
            ((Intent)localObject).getIntExtra("scale", -1);
          }
        }
      }, "VoipServiceEx-mBatInfoReceiver");
      AppMethodBeat.o(293335);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     com.tencent.mm.plugin.voip.model.v
 * JD-Core Version:    0.7.0.1
 */