package com.tencent.mm.plugin.voip.model;

import android.content.Context;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import android.os.Looper;
import android.telephony.PhoneStateListener;
import android.telephony.TelephonyManager;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.deviceinfo.ae;
import com.tencent.mm.plugin.i.a.aj;
import com.tencent.mm.plugin.voip.model.a.b;
import com.tencent.mm.plugin.voip.model.a.i;
import com.tencent.mm.protocal.protobuf.csu;
import com.tencent.mm.protocal.protobuf.ett;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.MTimerHandler;
import com.tencent.mm.sdk.platformtools.MTimerHandler.CallBack;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.ca;
import com.tencent.mm.storage.ck;
import java.nio.ByteBuffer;
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
  private static int GZx = -1;
  private static int GZy = 20;
  private static int lOO = -1;
  public l GSZ;
  private int GZA;
  ScheduledExecutorService GZB;
  ScheduledFuture<?> GZC;
  private WifiInfo GZD;
  public boolean GZE;
  public int GZF;
  public boolean GZG;
  public String GZH;
  private a GZI;
  private MTimerHandler GZJ;
  private byte[] GZK;
  MTimerHandler GZL;
  private MTimerHandler GZM;
  private MTimerHandler GZN;
  boolean GZs;
  public boolean GZt;
  private Object GZv;
  private int GZw;
  public String GZz;
  private WifiManager cnK;
  com.tencent.mm.plugin.voip.video.e qtg;
  public String toUser;
  
  public v()
  {
    AppMethodBeat.i(115162);
    this.GZv = new Object();
    this.GZw = 0;
    this.GZB = Executors.newScheduledThreadPool(1);
    this.GZE = false;
    this.GZF = 0;
    this.GZG = false;
    this.GZH = null;
    this.toUser = null;
    this.GZt = false;
    this.GZs = false;
    this.GZJ = new MTimerHandler(Looper.getMainLooper(), new MTimerHandler.CallBack()
    {
      public final boolean onTimerExpired()
      {
        AppMethodBeat.i(115156);
        if ((v.this.GSZ.GVV.Hav == 1) && (v.this.GSZ.fGr()))
        {
          com.tencent.mm.plugin.voip.b.e.Logi("MicroMsg.Voip.VoipServiceEx", "call timeout!");
          v.this.GSZ.GVV.Hcw.GXc = 101;
          com.tencent.mm.plugin.report.service.h.CyF.a(11521, new Object[] { Integer.valueOf(com.tencent.mm.plugin.voip.c.fFg().fHU()), Long.valueOf(com.tencent.mm.plugin.voip.c.fFg().fHV()), Long.valueOf(com.tencent.mm.plugin.voip.c.fFg().fGu()), Integer.valueOf(4), Long.valueOf(System.currentTimeMillis()), Long.valueOf(System.currentTimeMillis()) });
          v.this.adr(4);
          v.this.GSZ.GVW.fFR();
        }
        AppMethodBeat.o(115156);
        return false;
      }
    }, false);
    this.GZK = new byte[500];
    this.GZL = new MTimerHandler(Looper.getMainLooper(), new MTimerHandler.CallBack()
    {
      public final boolean onTimerExpired()
      {
        AppMethodBeat.i(115157);
        Object localObject = v.this.GSZ;
        ((l)localObject).GWd += 1;
        if (v.this.GSZ.GVV.roomId == 0)
        {
          com.tencent.mm.plugin.voip.b.e.Loge("MicroMsg.Voip.VoipServiceEx", com.tencent.mm.compatible.util.f.apq() + "double link switch roomId == 0 ");
          v.a(v.this).stopTimer();
        }
        for (;;)
        {
          AppMethodBeat.o(115157);
          return true;
          v.this.GSZ.GVV.app2EngineDataEx(v.this.GSZ.GVV.HbN, v.this.GSZ.GVV.HbO, v.this.GSZ.GVV.HbP, 0, 0);
          if ((!v.this.GSZ.GWc) && (1 == v.this.GSZ.GVV.field_mGetValidSample))
          {
            v.this.GSZ.GWc = true;
            v.this.GSZ.GWe = v.this.GSZ.GWd;
          }
          if (1 == v.this.GSZ.GVI) {
            v.this.GSZ.GVI = 15;
          }
          if ((true == v.this.GSZ.GWc) && (v.this.GSZ.GWd - v.this.GSZ.GWe == v.this.GSZ.GVI) && ((v.this.GSZ.GVV.HbE & 0x1) == 0))
          {
            v.this.GSZ.GWe = v.this.GSZ.GWd;
            int i = v.this.GSZ.GVV.isDCSameLan();
            int k = v.this.GSZ.GVV.getCurrentConnType();
            if ((1 == i) && (1 == k))
            {
              com.tencent.mm.plugin.voip.b.e.Logi("MicroMsg.Voip.VoipServiceEx", "zhengxue[DOUBLELINK]  In the Same LAN, isDCSameLan = ".concat(String.valueOf(i)));
              localObject = v.this.GSZ;
              ((l)localObject).GWd += 1;
              AppMethodBeat.o(115157);
              return true;
            }
            int m = v.this.GSZ.GVV.getcurstrategy();
            int n = v.this.GSZ.GVV.isRelayConnReady();
            int i1 = v.this.GSZ.GVV.isDCReady();
            int j = v.this.GSZ.GVI - 3;
            i = j;
            if (j > 15) {
              i = 15;
            }
            v.this.GSZ.GVV.app2EngineLinkQualityEx(i, v.b(v.this));
            new com.tencent.mm.plugin.voip.model.a.d(v.this.GSZ.GVV.roomId, v.this.GSZ.GVV.ypH, v.this.GSZ.GVV.ypO, k, n, i1, m, v.b(v.this), v.this.GSZ.GVV.field_realLinkQualityInfoBuffLen).fII();
            localObject = v.this.GSZ.GVV;
            ((v2protocal)localObject).HbG += 1;
            com.tencent.mm.plugin.voip.b.e.Logi("MicroMsg.Voip.VoipServiceEx", "zhengxue[DOUBLELINK]  doubleLinkSwitchReportStatus " + v.this.GSZ.GVI + " isFirstValidSampleSet " + v.this.GSZ.GWc + " mGetValidSample " + v.this.GSZ.GVV.field_mGetValidSample + "mDoubleLinkSwitchReqCnt " + v.this.GSZ.GVV.HbG + "mTimerCounter " + v.this.GSZ.GWd + "mLastSwitchTimer " + v.this.GSZ.GWe);
          }
        }
      }
    }, true);
    this.GZM = new MTimerHandler(Looper.getMainLooper(), new MTimerHandler.CallBack()
    {
      public final boolean onTimerExpired()
      {
        AppMethodBeat.i(115158);
        if (v.this.GSZ.GVV.roomId == 0)
        {
          com.tencent.mm.plugin.voip.b.e.Loge("MicroMsg.Voip.VoipServiceEx", com.tencent.mm.compatible.util.f.apq() + " roomId == 0 ");
          v.c(v.this).stopTimer();
        }
        label136:
        for (;;)
        {
          AppMethodBeat.o(115158);
          return true;
          if (v.this.GSZ.mStatus >= 5) {}
          for (int i = 1;; i = 0)
          {
            if (i == 0) {
              break label136;
            }
            new com.tencent.mm.plugin.voip.model.a.f(v.this.GSZ.GVV.roomId, v.this.GSZ.GVV.ypH, v.this.GSZ.GWk).fII();
            break;
          }
        }
      }
    }, true);
    this.GZN = new MTimerHandler(Looper.getMainLooper(), new MTimerHandler.CallBack()
    {
      public final boolean onTimerExpired()
      {
        AppMethodBeat.i(115159);
        Log.i("MicroMsg.Voip.VoipServiceEx", "voip called out of time,now destroy...");
        if ((3 == v.this.GSZ.mStatus) && (v.d(v.this) != 0) && (v.d(v.this) == v.this.GSZ.GVV.roomId))
        {
          v.e(v.this);
          v.this.GSZ.K(5, -9000, "");
        }
        AppMethodBeat.o(115159);
        return false;
      }
    }, true);
    this.GSZ = m.fGM();
    this.GSZ.a(this);
    this.qtg = new com.tencent.mm.plugin.voip.video.e(MMApplicationContext.getContext());
    this.GZE = false;
    this.GZF = 0;
    this.GZG = false;
    this.GZH = null;
    AppMethodBeat.o(115162);
  }
  
  private void fIC()
  {
    AppMethodBeat.i(235700);
    TelephonyManager localTelephonyManager = (TelephonyManager)MMApplicationContext.getContext().getSystemService("phone");
    if (localTelephonyManager != null)
    {
      Object localObject = new v.5(this, localTelephonyManager);
      localObject = com.tencent.mm.hellhoundlib.b.c.a(256, new com.tencent.mm.hellhoundlib.b.a()).bl(localObject);
      com.tencent.mm.hellhoundlib.a.a.a(localTelephonyManager, ((com.tencent.mm.hellhoundlib.b.a)localObject).axQ(), "com/tencent/mm/plugin/voip/model/VoipServiceEx", "VOIPmoileSignalStrength", "()V", "android/telephony/TelephonyManager_EXEC_", "listen", "(Landroid/telephony/PhoneStateListener;I)V");
      localTelephonyManager.listen((PhoneStateListener)((com.tencent.mm.hellhoundlib.b.a)localObject).pG(0), ((Integer)((com.tencent.mm.hellhoundlib.b.a)localObject).pG(1)).intValue());
      com.tencent.mm.hellhoundlib.a.a.a(localTelephonyManager, "com/tencent/mm/plugin/voip/model/VoipServiceEx", "VOIPmoileSignalStrength", "()V", "android/telephony/TelephonyManager_EXEC_", "listen", "(Landroid/telephony/PhoneStateListener;I)V");
    }
    AppMethodBeat.o(235700);
  }
  
  private void fID()
  {
    AppMethodBeat.i(235701);
    this.cnK = ((WifiManager)MMApplicationContext.getContext().getApplicationContext().getSystemService("wifi"));
    if (this.GZI != null) {
      this.GZI.cancel();
    }
    this.GZI = new a();
    this.GZC = this.GZB.scheduleAtFixedRate(this.GZI, 0L, GZy, TimeUnit.SECONDS);
    AppMethodBeat.o(235701);
  }
  
  private void fIp()
  {
    AppMethodBeat.i(115166);
    Log.d("MicroMsg.Voip.VoipServiceEx", "reset");
    this.GZM.stopTimer();
    this.GZJ.stopTimer();
    this.GZL.stopTimer();
    this.GZN.stopTimer();
    this.GZw = 0;
    AppMethodBeat.o(115166);
  }
  
  private boolean fIr()
  {
    AppMethodBeat.i(115169);
    boolean bool = false;
    if (this.GSZ != null) {
      bool = this.GSZ.fGr();
    }
    AppMethodBeat.o(115169);
    return bool;
  }
  
  public static boolean fIs()
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
  
  private void reset()
  {
    AppMethodBeat.i(115165);
    Log.d("MicroMsg.Voip.VoipServiceEx", "reset");
    this.toUser = null;
    this.GZt = false;
    this.GZs = false;
    this.GSZ.reset();
    this.GZM.stopTimer();
    this.GZJ.stopTimer();
    this.GZL.stopTimer();
    this.GZN.stopTimer();
    if (this.GZI != null) {
      this.GZI.cancel();
    }
    if (this.GZC != null)
    {
      this.GZC.cancel(false);
      this.GZC = null;
    }
    this.GZw = 0;
    com.tencent.mm.plugin.voip.c.fFg().unRegister();
    com.tencent.mm.plugin.voip.c.fFg().GUy = null;
    this.GZE = false;
    this.GZF = 0;
    this.GZG = false;
    this.GZH = null;
    AppMethodBeat.o(115165);
  }
  
  public final void K(int paramInt1, int paramInt2, String paramString)
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
      this.GSZ.GVW.onReject();
      fIy();
      AppMethodBeat.o(115173);
      return;
      this.GSZ.GVW.fFR();
      fIy();
      AppMethodBeat.o(115173);
      return;
      this.GSZ.GVW.wW(true);
      fIy();
      AppMethodBeat.o(115173);
      return;
      this.GSZ.GVW.onError(paramInt2, paramString);
      fIy();
    }
  }
  
  public final void a(int paramInt1, long paramLong, int paramInt2, byte[] paramArrayOfByte1, byte[] paramArrayOfByte2, String paramString)
  {
    AppMethodBeat.i(115184);
    com.tencent.mm.plugin.voip.b.e.Logi("MicroMsg.Voip.VoipServiceEx", "doAck roomId " + paramInt1 + "  roomKey " + paramLong + " status " + paramInt2);
    if ((paramInt1 != 0) && (paramLong != 0L))
    {
      LinkedList localLinkedList = new LinkedList();
      this.GSZ.bu(localLinkedList);
      this.GSZ.GVV.Hbg = ("ack:" + this.GSZ.GVV.Hbb + ":" + this.GSZ.GVV.Hbc);
      new com.tencent.mm.plugin.voip.model.a.a(paramInt1, paramLong, paramInt2, paramArrayOfByte1, paramArrayOfByte2, paramString, localLinkedList).fII();
    }
    this.GSZ.elV();
    AppMethodBeat.o(115184);
  }
  
  public final void a(Context paramContext, x paramx)
  {
    AppMethodBeat.i(235694);
    this.GSZ.owO = paramContext;
    this.GSZ.GVW = paramx;
    com.tencent.mm.plugin.voip.b.e.Logd("MicroMsg.Voip.VoipServiceEx", "attach ui........");
    com.tencent.mm.plugin.voip.b.e.fKc();
    AppMethodBeat.o(235694);
  }
  
  public final boolean a(ett paramett)
  {
    AppMethodBeat.i(115178);
    if (this.GSZ.fGt())
    {
      com.tencent.mm.plugin.voip.b.e.Loge("MicroMsg.Voip.VoipServiceEx", "Failed to setInviteContent during calling, status =" + this.GSZ.mStatus);
      AppMethodBeat.o(115178);
      return false;
    }
    if (paramett == null)
    {
      AppMethodBeat.o(115178);
      return false;
    }
    this.GSZ.GVV.Hcw.GXn = paramett.NqJ;
    Log.d("MicroMsg.Voip.VoipServiceEx", "iRoomType " + this.GSZ.GVV.Hcw.GXn);
    if (this.GSZ.GVV.fIZ())
    {
      com.tencent.mm.plugin.voip.b.e.Logw("MicroMsg.Voip.VoipServiceEx", com.tencent.mm.compatible.util.f.apq() + "v2protocal already init.");
      this.GSZ.GVV.xh(false);
      this.GSZ.GVV.reset();
    }
    this.GSZ.a(paramett);
    boolean bool = ((aj)com.tencent.mm.kernel.g.ah(aj.class)).isAnchorLiving();
    if ((com.tencent.mm.plugin.voip.b.m.fKH()) || (com.tencent.mm.q.a.att()) || (com.tencent.mm.plugin.voip.b.m.fKJ()) || (com.tencent.mm.q.a.atu()) || (bool))
    {
      Log.e("MicroMsg.Voip.VoipServiceEx", "setInviteContent, reject, pstn/multitak/f2f talking");
      if ((com.tencent.mm.plugin.voip.b.m.fKH()) || (com.tencent.mm.q.a.atu()) || (bool))
      {
        a(paramett.LsZ, paramett.Lta, 2, null, null, paramett.NqS);
        AppMethodBeat.o(115178);
        return false;
      }
      fIw();
      int i;
      label298:
      String str;
      if (paramett.NqJ == 0)
      {
        i = 1;
        str = paramett.NqS;
        if (i == 0) {
          break label339;
        }
      }
      label339:
      for (paramett = ca.OqC;; paramett = ca.OqB)
      {
        s.c(str, paramett, 0, 6, MMApplicationContext.getContext().getString(2131767245));
        break;
        i = 0;
        break label298;
      }
    }
    if (this.GSZ.GVV.ftD() < 0)
    {
      com.tencent.mm.plugin.voip.b.e.Loge("MicroMsg.Voip.VoipServiceEx", "Failed to init v2protocol.");
      AppMethodBeat.o(115178);
      return false;
    }
    if (v2protocal.HcA != null) {
      v2protocal.HcA.a(this.GSZ);
    }
    com.tencent.mm.plugin.report.service.h.CyF.a(11524, true, true, new Object[] { Integer.valueOf(paramett.LsZ), Long.valueOf(paramett.Lta), Integer.valueOf(paramett.NqJ), Integer.valueOf(0), Long.valueOf(System.currentTimeMillis()) });
    if (!this.GZE) {
      this.GSZ.GVW.fFO();
    }
    AppMethodBeat.o(115178);
    return true;
  }
  
  public final int aH(boolean paramBoolean1, boolean paramBoolean2)
  {
    AppMethodBeat.i(115179);
    fIB();
    if (!this.GZN.stopped()) {
      this.GZN.stopTimer();
    }
    this.GSZ.GVV.Hcw.fGU();
    Log.i("MicroMsg.Voip.VoipServiceEx", "accept onlyAudio:".concat(String.valueOf(paramBoolean1)));
    if (!this.GSZ.fGs())
    {
      com.tencent.mm.plugin.voip.b.e.Loge("MicroMsg.Voip.VoipServiceEx", "Failed to accept with calling, status =" + this.GSZ.mStatus);
      AppMethodBeat.o(115179);
      return -1;
    }
    if (this.GSZ.GVV.roomId == 0)
    {
      com.tencent.mm.plugin.voip.b.e.Loge("MicroMsg.Voip.VoipServiceEx", "Failed to accept with roomid = 0. ");
      AppMethodBeat.o(115179);
      return -1;
    }
    LinkedList localLinkedList = new LinkedList();
    this.GSZ.bu(localLinkedList);
    this.GSZ.GVV.Hbg = (this.GSZ.GVV.Hbg + "|answer:" + this.GSZ.GVV.Hbb + ":" + this.GSZ.GVV.Hbc);
    com.tencent.mm.plugin.voip.b.e.Logd("MicroMsg.Voip.VoipServiceEx", com.tencent.mm.compatible.util.f.apq() + "accept invite, roomid:" + this.GSZ.GVV.roomId + " nic list size:" + localLinkedList.size());
    this.GZM.startTimer(50000L);
    this.GSZ.GVV.Hcw.fGV();
    new b(1, this.GSZ.GVV.netType, this.GSZ.GVV.roomId, this.GSZ.GVV.field_peerId, this.GSZ.GVV.field_capInfo, this.GSZ.GVV.ypH, paramBoolean1, paramBoolean2, localLinkedList).fII();
    this.GSZ.setStatus(4);
    this.GSZ.GVX.qrL = 1;
    this.GSZ.dWM = true;
    AppMethodBeat.o(115179);
    return 0;
  }
  
  public final void adf(int paramInt)
  {
    AppMethodBeat.i(115187);
    this.GSZ.adf(paramInt);
    AppMethodBeat.o(115187);
  }
  
  public final void adn(int paramInt)
  {
    AppMethodBeat.i(115167);
    this.GSZ.ada(paramInt);
    AppMethodBeat.o(115167);
  }
  
  public final void adq(int paramInt)
  {
    AppMethodBeat.i(235702);
    this.cnK = null;
    this.GZD = null;
    this.GZA = 0;
    if (paramInt > 0) {
      GZy = paramInt;
    }
    fID();
    fIC();
    AppMethodBeat.o(235702);
  }
  
  public final int adr(int paramInt)
  {
    AppMethodBeat.i(115176);
    if (!this.GSZ.fGt())
    {
      com.tencent.mm.plugin.voip.b.e.Loge("MicroMsg.Voip.VoipServiceEx", "Failed to cancel call ,as not in calling.");
      AppMethodBeat.o(115176);
      return -1;
    }
    Log.i("MicroMsg.Voip.VoipServiceEx", "cancelCallEx, roomId:%d, msgID:%d, inviteId:%d, cancelType:%d", new Object[] { Integer.valueOf(this.GSZ.GVV.roomId), Integer.valueOf(this.GSZ.GVV.Hat), Integer.valueOf(this.GSZ.GVV.ypJ), Integer.valueOf(paramInt) });
    synchronized (this.GZv)
    {
      if ((this.GSZ.GVV.roomId == 0) && (this.GSZ.GVV.ypJ == 0))
      {
        com.tencent.mm.plugin.voip.b.e.Loge("MicroMsg.Voip.VoipServiceEx", "Failed to cancel call with roomid = 0 and inviteId = 0 ");
        AppMethodBeat.o(115176);
        return -1;
      }
      if (this.GSZ.GVV.fIZ())
      {
        this.GSZ.GVV.xh(true);
        new com.tencent.mm.plugin.voip.model.a.c(this.GSZ.GVV.roomId, this.GSZ.GVV.ypH, this.GSZ.GVV.haD, "", this.GSZ.GVV.ypJ, paramInt).fII();
      }
      Object localObject2 = this.GSZ.GVV.Hcw;
      ((o)localObject2).GXx = ((int)(System.currentTimeMillis() - ((o)localObject2).GXH));
      com.tencent.mm.plugin.voip.b.e.Logd("MicroMsg.VoipDailReport", "devin:cancelInvite:" + ((o)localObject2).GXx);
      if ((this.GSZ.GVV.HaM == 0) && (this.GSZ.GVV.HaN == 0)) {
        this.GSZ.fGp();
      }
      this.GSZ.adc(this.qtg.fKX());
      this.GSZ.GVV.Hcw.GXM = this.GSZ.GVW.fFU();
      if (com.tencent.mm.plugin.voip.c.fFg().GYT != null)
      {
        this.GSZ.GVV.Hcw.GXN = com.tencent.mm.plugin.voip.c.fFg().GYT.fFe();
        this.GSZ.GVV.Hcw.GUE = (com.tencent.mm.plugin.voip.c.fFg().GYT.fFc() / 1000L);
        this.GSZ.GVV.Hcw.GUF = (com.tencent.mm.plugin.voip.c.fFg().GYT.fFd() / 1000L);
      }
      localObject2 = v2protocal.fJc();
      String str1 = this.GSZ.GVV.fJd();
      String str2 = this.GSZ.GVV.fJi();
      String str3 = this.GSZ.GVV.fIV();
      String str4 = this.GSZ.GVV.fIX();
      String[] arrayOfString1 = this.GSZ.GVV.fJe();
      String[] arrayOfString2 = this.GSZ.GVV.fJf();
      String[] arrayOfString3 = this.GSZ.GVV.fJg();
      String[] arrayOfString4 = this.GSZ.GVV.fJh();
      if (str1.length() > 0) {
        new com.tencent.mm.plugin.voip.model.a.l((String)localObject2, str1, str3, str2, str4, arrayOfString1, arrayOfString2, arrayOfString3, arrayOfString4).fII();
      }
      this.GSZ.fGn();
      reset();
      this.GSZ.GVV.roomId = 0;
      this.GSZ.GVV.ypJ = 0;
      AppMethodBeat.o(115176);
      return 0;
    }
  }
  
  public final void ads(int paramInt)
  {
    AppMethodBeat.i(115196);
    this.GZw = paramInt;
    if (!this.GZN.stopped()) {
      this.GZN.stopTimer();
    }
    this.GZN.startTimer(70000L);
    AppMethodBeat.o(115196);
  }
  
  public final void b(Context paramContext, x paramx)
  {
    AppMethodBeat.i(235695);
    if ((paramContext != this.GSZ.owO) || (paramx != this.GSZ.GVW))
    {
      com.tencent.mm.plugin.voip.b.e.Logd("MicroMsg.Voip.VoipServiceEx", "cannot detach other's ui.");
      AppMethodBeat.o(235695);
      return;
    }
    this.GSZ.owO = null;
    this.GSZ.GVW = x.GZW;
    com.tencent.mm.plugin.voip.b.e.Logd("MicroMsg.Voip.VoipServiceEx", "detach ui........");
    com.tencent.mm.plugin.voip.b.e.flushLogFile();
    AppMethodBeat.o(235695);
  }
  
  public final int c(int paramInt1, long paramLong, int paramInt2)
  {
    AppMethodBeat.i(115177);
    if (!this.GSZ.fGt())
    {
      com.tencent.mm.plugin.voip.b.e.Loge("MicroMsg.Voip.VoipServiceEx", "steve:[simucall]Failed to cancel call ,as not in calling.");
      AppMethodBeat.o(115177);
      return -1;
    }
    Log.i("MicroMsg.Voip.VoipServiceEx", "steve:[simucall] try to cancel my invite due to Simulcall(callee), roomId:%s, roomKey:%s, roomType:%d, msgID:%d, inviteId:%d", new Object[] { Integer.valueOf(paramInt1), Long.valueOf(paramLong), Integer.valueOf(paramInt2), Integer.valueOf(this.GSZ.GVV.Hat), Integer.valueOf(this.GSZ.GVV.ypJ) });
    Object localObject1 = this.GZv;
    if (paramInt1 != 0) {}
    try
    {
      if (this.GSZ.GVV.ypJ == 0)
      {
        com.tencent.mm.plugin.voip.b.e.Loge("MicroMsg.Voip.VoipServiceEx", "steve:[simucall] Failed to cancel call with roomid = 0 and inviteId = 0 ");
        return -1;
      }
      new com.tencent.mm.plugin.voip.model.a.c(paramInt1, paramLong, this.GSZ.GVV.haD, "", this.GSZ.GVV.ypJ, 2).fII();
      com.tencent.mm.plugin.report.service.h.CyF.a(11521, true, true, new Object[] { Integer.valueOf(paramInt1), Long.valueOf(paramLong), Integer.valueOf(paramInt2), Integer.valueOf(2), Long.valueOf(System.currentTimeMillis()), Long.valueOf(System.currentTimeMillis()) });
      Log.i("MicroMsg.Voip.VoipServiceEx", "steve:[simucall] voipcancelinvite sent!");
      return 0;
    }
    finally
    {
      AppMethodBeat.o(115177);
    }
  }
  
  public final int c(ByteBuffer paramByteBuffer, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5)
  {
    AppMethodBeat.i(235699);
    paramInt1 = this.GSZ.GVX.b(paramByteBuffer, paramInt1, paramInt2, paramInt3, paramInt4, paramInt5);
    AppMethodBeat.o(235699);
    return paramInt1;
  }
  
  public final int c(byte[] paramArrayOfByte, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    AppMethodBeat.i(235698);
    paramInt1 = this.GSZ.GVX.b(paramArrayOfByte, paramInt1, paramInt2, paramInt3, paramInt4);
    AppMethodBeat.o(235698);
    return paramInt1;
  }
  
  public final boolean czl()
  {
    AppMethodBeat.i(115195);
    if (this.qtg != null)
    {
      boolean bool = this.qtg.YZ();
      AppMethodBeat.o(115195);
      return bool;
    }
    AppMethodBeat.o(115195);
    return true;
  }
  
  public final boolean fGt()
  {
    AppMethodBeat.i(115170);
    if (this.GSZ.fGt())
    {
      AppMethodBeat.o(115170);
      return true;
    }
    AppMethodBeat.o(115170);
    return false;
  }
  
  public final int fHS()
  {
    AppMethodBeat.i(235697);
    Log.i("MicroMsg.Voip.VoipServiceEx", "hangUpByPhoneInter");
    if (this.GSZ.GVV.roomId == 0)
    {
      this.GSZ.GVX.fGO();
      reset();
      AppMethodBeat.o(235697);
      return 0;
    }
    this.GSZ.GVV.Hcw.GXc = 109;
    this.GSZ.GVV.Hcw.GXu = 4;
    int i = fIy();
    AppMethodBeat.o(235697);
    return i;
  }
  
  public final int fHT()
  {
    AppMethodBeat.i(115183);
    Log.i("MicroMsg.Voip.VoipServiceEx", "ignoreInvite");
    if (!this.GSZ.fGs())
    {
      com.tencent.mm.plugin.voip.b.e.Loge("MicroMsg.Voip.VoipServiceEx", "Failed to ignore with calling, status =" + this.GSZ.mStatus);
      AppMethodBeat.o(115183);
      return -1;
    }
    synchronized (this.GZv)
    {
      if (this.GSZ.GVV.roomId == 0)
      {
        com.tencent.mm.plugin.voip.b.e.Loge("MicroMsg.Voip.VoipServiceEx", "Failed to reject with roomid = 0. ");
        AppMethodBeat.o(115183);
        return -1;
      }
      int i = this.GSZ.GVV.netType;
      int j = this.GSZ.GVV.roomId;
      long l = this.GSZ.GVV.ypH;
      new b(3, i, j, new byte[0], new byte[0], l, false, false, null).fII();
      reset();
      this.GSZ.GVV.roomId = 0;
      AppMethodBeat.o(115183);
      return 0;
    }
  }
  
  public final void fIA()
  {
    AppMethodBeat.i(115193);
    if (this.qtg != null) {
      this.qtg.a(2131689973, false, 0, false);
    }
    AppMethodBeat.o(115193);
  }
  
  public final void fIB()
  {
    AppMethodBeat.i(115197);
    if (this.GZJ != null)
    {
      com.tencent.mm.plugin.voip.b.e.Logi("MicroMsg.Voip.VoipServiceEx", "devincdai: voip reset timecount");
      this.GZJ.stopTimer();
      this.GZJ.startTimer(60000L);
    }
    AppMethodBeat.o(115197);
  }
  
  public final boolean fIq()
  {
    AppMethodBeat.i(115168);
    Log.i("MicroMsg.Voip.VoipServiceEx", "isRoomReady, roomId: " + this.GSZ.GVV.roomId);
    if ((this.GSZ.GVV.roomId != 0) && (!fIr()))
    {
      AppMethodBeat.o(115168);
      return true;
    }
    AppMethodBeat.o(115168);
    return false;
  }
  
  public final void fIt()
  {
    AppMethodBeat.i(115172);
    if (this.GSZ.fGt()) {
      com.tencent.mm.plugin.voip.b.e.Loge("MicroMsg.Voip.VoipServiceEx", "checkStartup failed, stauts = " + this.GSZ.mStatus);
    }
    com.tencent.mm.plugin.voip.b.e.Loge("MicroMsg.Voip.VoipServiceEx", "checkStartup...devicekey = " + ck.getFingerprint());
    this.GSZ.fGo();
    fIp();
    ae.DV(com.tencent.mm.kernel.g.aAh().azR().gEu());
    AppMethodBeat.o(115172);
  }
  
  public final int fIu()
  {
    AppMethodBeat.i(115175);
    Log.i("MicroMsg.Voip.VoipServiceEx", "cancelCall, roomId:" + this.GSZ.GVV.roomId);
    if ((this.GSZ.GVV.roomId == 0) && (this.GSZ.GVV.ypJ == 0))
    {
      reset();
      AppMethodBeat.o(115175);
      return -1;
    }
    this.GSZ.GVV.Hcw.GXc = this.GSZ.fGq();
    this.GSZ.GVV.Hcw.GXo = 3;
    if (this.GSZ.mStatus < 6) {
      this.GSZ.GVV.Hcw.GXq = 1;
    }
    com.tencent.mm.plugin.report.service.h.CyF.a(11521, true, true, new Object[] { Integer.valueOf(com.tencent.mm.plugin.voip.c.fFg().fHU()), Long.valueOf(com.tencent.mm.plugin.voip.c.fFg().fHV()), Long.valueOf(com.tencent.mm.plugin.voip.c.fFg().fGu()), Integer.valueOf(1), Long.valueOf(System.currentTimeMillis()), Long.valueOf(System.currentTimeMillis()) });
    int i = adr(1);
    AppMethodBeat.o(115175);
    return i;
  }
  
  public final int fIv()
  {
    AppMethodBeat.i(235696);
    Log.i("MicroMsg.Voip.VoipServiceEx", "cancelCallByPhoneInter, roomId:" + this.GSZ.GVV.roomId);
    if (this.GSZ.GVV.roomId == 0)
    {
      AppMethodBeat.o(235696);
      return -1;
    }
    this.GSZ.GVV.Hcw.GXc = 102;
    this.GSZ.GVV.Hcw.GXo = 6;
    if (com.tencent.mm.plugin.voip.c.fFg().GYT != null)
    {
      this.GSZ.GVV.Hcw.GXN = com.tencent.mm.plugin.voip.c.fFg().GYT.fFe();
      this.GSZ.GVV.Hcw.GUE = (com.tencent.mm.plugin.voip.c.fFg().GYT.fFc() / 1000L);
      this.GSZ.GVV.Hcw.GUF = (com.tencent.mm.plugin.voip.c.fFg().GYT.fFd() / 1000L);
    }
    com.tencent.mm.plugin.report.service.h.CyF.a(11521, true, true, new Object[] { Integer.valueOf(com.tencent.mm.plugin.voip.c.fFg().fHU()), Long.valueOf(com.tencent.mm.plugin.voip.c.fFg().fHV()), Long.valueOf(com.tencent.mm.plugin.voip.c.fFg().fGu()), Integer.valueOf(3), Long.valueOf(System.currentTimeMillis()), Long.valueOf(System.currentTimeMillis()) });
    int i = adr(3);
    AppMethodBeat.o(235696);
    return i;
  }
  
  public final int fIw()
  {
    AppMethodBeat.i(115180);
    Log.i("MicroMsg.Voip.VoipServiceEx", "reject");
    if (!this.GSZ.fGs())
    {
      com.tencent.mm.plugin.voip.b.e.Loge("MicroMsg.Voip.VoipServiceEx", "Failed to reject with calling, status =" + this.GSZ.mStatus);
      AppMethodBeat.o(115180);
      return -1;
    }
    synchronized (this.GZv)
    {
      if (this.GSZ.GVV.roomId == 0)
      {
        com.tencent.mm.plugin.voip.b.e.Loge("MicroMsg.Voip.VoipServiceEx", "Failed to reject with roomid = 0. ");
        AppMethodBeat.o(115180);
        return -1;
      }
      this.GSZ.GVV.Hcw.fGV();
      com.tencent.mm.plugin.voip.b.e.Logd("MicroMsg.Voip.VoipServiceEx", " reject, status:" + this.GSZ.mStatus + " roomid:" + this.GSZ.GVV.roomId);
      int i = this.GSZ.GVV.netType;
      int j = this.GSZ.GVV.roomId;
      long l = this.GSZ.GVV.ypH;
      new b(2, i, j, new byte[0], new byte[0], l, false, false, null).fII();
      if ((this.GSZ.GVV.HaM == 0) && (this.GSZ.GVV.HaN == 0)) {
        this.GSZ.fGp();
      }
      this.GSZ.adc(this.qtg.fKX());
      this.GSZ.GVV.Hcw.GXM = this.GSZ.GVW.fFU();
      if (com.tencent.mm.plugin.voip.c.fFg().GYT != null)
      {
        this.GSZ.GVV.Hcw.GXN = com.tencent.mm.plugin.voip.c.fFg().GYT.fFe();
        this.GSZ.GVV.Hcw.GUE = (com.tencent.mm.plugin.voip.c.fFg().GYT.fFc() / 1000L);
        this.GSZ.GVV.Hcw.GUF = (com.tencent.mm.plugin.voip.c.fFg().GYT.fFd() / 1000L);
      }
      if (this.GSZ.GVV.fIZ()) {
        this.GSZ.GVV.xh(true);
      }
      String str1 = v2protocal.fJc();
      String str2 = this.GSZ.GVV.fJd();
      String str3 = this.GSZ.GVV.fJi();
      String str4 = this.GSZ.GVV.fIV();
      String str5 = this.GSZ.GVV.fIX();
      String[] arrayOfString1 = this.GSZ.GVV.fJe();
      String[] arrayOfString2 = this.GSZ.GVV.fJf();
      String[] arrayOfString3 = this.GSZ.GVV.fJg();
      String[] arrayOfString4 = this.GSZ.GVV.fJh();
      com.tencent.mm.plugin.voip.b.e.Logd("MicroMsg.Voip.VoipServiceEx", "devin: statreport");
      if (str2.length() > 0)
      {
        com.tencent.mm.plugin.voip.b.e.Logd("MicroMsg.Voip.VoipServiceEx", "devin: reject() newdialInfo.length() > 0");
        new com.tencent.mm.plugin.voip.model.a.l(str1, str2, str4, str3, str5, arrayOfString1, arrayOfString2, arrayOfString3, arrayOfString4).fII();
        this.GSZ.fGn();
        reset();
        this.GSZ.GVV.roomId = 0;
        AppMethodBeat.o(115180);
        return 0;
      }
      com.tencent.mm.plugin.voip.b.e.Logd("MicroMsg.Voip.VoipServiceEx", "devin: reject() newdialInfo.length() <= 0");
    }
  }
  
  public final int fIx()
  {
    AppMethodBeat.i(115181);
    Log.i("MicroMsg.Voip.VoipServiceEx", "hangUp");
    if (this.GSZ.GVV.roomId == 0)
    {
      this.GSZ.GVX.fGO();
      this.GSZ.elW();
      reset();
      AppMethodBeat.o(115181);
      return 0;
    }
    this.GSZ.GVV.Hcw.GXc = this.GSZ.fGq();
    int i = fIy();
    AppMethodBeat.o(115181);
    return i;
  }
  
  public final int fIy()
  {
    AppMethodBeat.i(115182);
    com.tencent.mm.plugin.voip.b.e.Logi("MicroMsg.Voip.VoipServiceEx", "hangUp,status:" + this.GSZ.mStatus + " roomid:" + this.GSZ.GVV.roomId + ",threadid = " + Thread.currentThread().getId());
    this.GSZ.GVX.fGO();
    this.GSZ.elW();
    if (this.GSZ.GVV.Hcw.GXm == 1)
    {
      ??? = this.GSZ.GVV.Hcw;
      if (((o)???).GXD != 0L) {
        break label628;
      }
      ((o)???).GXw = 0;
    }
    for (;;)
    {
      if (((o)???).GXw < 0)
      {
        ((o)???).GXw = 0;
        com.tencent.mm.plugin.voip.b.e.Loge("MicroMsg.VoipDailReport", "devin:endTalk, iCallTime Err, rest 0");
      }
      com.tencent.mm.plugin.voip.b.e.Logi("MicroMsg.VoipDailReport", "devin:endTalk:" + ((o)???).GXw);
      synchronized (this.GZv)
      {
        int i = this.GSZ.GVV.Hcw.GXo;
        if ((this.GSZ.GVV.roomId != 0) || (8 == i) || (9 == i) || (10 == i) || (11 == i) || (12 == i) || (99 == i))
        {
          com.tencent.mm.plugin.voip.b.e.Logi("MicroMsg.Voip.VoipServiceEx", "steve:hangUp, uninitGLRender before protocalUninit first!!");
          if (this.GSZ.GVV.fIZ())
          {
            this.GSZ.GVV.xh(true);
            new i(this.GSZ.GVV.roomId, this.GSZ.GVV.ypH, "").fII();
            com.tencent.mm.plugin.voip.b.e.Loge("MicroMsg.Voip.VoipServiceEx", "devin: shutdown cgi ");
          }
          this.GSZ.GVV.Hcw.GXM = this.GSZ.GVW.fFU();
          if (com.tencent.mm.plugin.voip.c.fFg().GYT != null)
          {
            this.GSZ.GVV.Hcw.GXN = com.tencent.mm.plugin.voip.c.fFg().GYT.fFe();
            this.GSZ.GVV.Hcw.GUE = (com.tencent.mm.plugin.voip.c.fFg().GYT.fFc() / 1000L);
            this.GSZ.GVV.Hcw.GUF = (com.tencent.mm.plugin.voip.c.fFg().GYT.fFd() / 1000L);
          }
          this.GSZ.adc(this.qtg.fKX());
          String str1 = v2protocal.fJc();
          String str2 = this.GSZ.GVV.fJd();
          String str3 = this.GSZ.GVV.fJi();
          String str4 = this.GSZ.GVV.fIV();
          String str5 = this.GSZ.GVV.fIX();
          String[] arrayOfString1 = this.GSZ.GVV.fJe();
          String[] arrayOfString2 = this.GSZ.GVV.fJf();
          String[] arrayOfString3 = this.GSZ.GVV.fJg();
          String[] arrayOfString4 = this.GSZ.GVV.fJh();
          if (str2.length() > 0)
          {
            new com.tencent.mm.plugin.voip.model.a.l(str1, str2, str4, str3, str5, arrayOfString1, arrayOfString2, arrayOfString3, arrayOfString4).fII();
            com.tencent.mm.plugin.voip.b.e.Loge("MicroMsg.Voip.VoipServiceEx", "devin: statreport cgi ");
          }
          this.GSZ.fGn();
          reset();
          this.GSZ.GVV.roomId = 0;
          com.tencent.mm.plugin.voip.b.e.Logd("MicroMsg.Voip.VoipServiceEx", "hangUp over");
          AppMethodBeat.o(115182);
          return 0;
          label628:
          ((o)???).GXw = ((int)((System.currentTimeMillis() - ((o)???).GXD) / 1000L));
          continue;
        }
        com.tencent.mm.plugin.voip.b.e.Loge("MicroMsg.Voip.VoipServiceEx", "call hangUp roomId == 0 ");
      }
    }
  }
  
  public final void fIz()
  {
    AppMethodBeat.i(115185);
    LinkedList localLinkedList = new LinkedList();
    this.GSZ.GVV.bv(localLinkedList);
    int j = 0;
    int m = 0;
    int n;
    for (int i = 0; j < localLinkedList.size(); i = n)
    {
      int k = m;
      if (((csu)localLinkedList.get(j)).Loh == 5) {
        k = m + 1;
      }
      n = i;
      if (((csu)localLinkedList.get(j)).Loh == 4) {
        n = i + 1;
      }
      j += 1;
      m = k;
    }
    this.GSZ.GVV.Hbg = (this.GSZ.GVV.Hbg + "|redirect:" + i + ":" + m);
    new com.tencent.mm.plugin.voip.model.a.h(this.GSZ.GVV.roomId, this.GSZ.GVV.ypH, this.GSZ.GVV.ypO, 0, 0, null, localLinkedList).fII();
    AppMethodBeat.o(115185);
  }
  
  public final int fU(String paramString, int paramInt)
  {
    AppMethodBeat.i(115174);
    Log.i("MicroMsg.Voip.VoipServiceEx", "call username:%s, callType:%d, inviteType:%d", new Object[] { paramString, Integer.valueOf(0), Integer.valueOf(paramInt) });
    if (Util.isNullOrNil(paramString))
    {
      com.tencent.mm.plugin.voip.b.e.Loge("MicroMsg.Voip.VoipServiceEx", "Failed call without valid username.");
      AppMethodBeat.o(115174);
      return -1;
    }
    if (this.GSZ.fGt())
    {
      com.tencent.mm.plugin.voip.b.e.Loge("MicroMsg.Voip.VoipServiceEx", "Failed call withing calling.");
      AppMethodBeat.o(115174);
      return -1;
    }
    this.GZH = paramString;
    this.GSZ.GVV.Hav = 1;
    this.GSZ.GVV.haD = paramString;
    com.tencent.mm.plugin.voip.b.e.Logd("MicroMsg.Voip.VoipServiceEx", com.tencent.mm.compatible.util.f.apq() + "call username:" + paramString);
    if (this.GSZ.GVV.fIZ())
    {
      com.tencent.mm.plugin.voip.b.e.Loge("MicroMsg.Voip.VoipServiceEx", com.tencent.mm.compatible.util.f.apq() + "v2protocal already init.");
      this.GSZ.GVV.xh(false);
      this.GSZ.GVV.reset();
    }
    if (this.GSZ.GVV.ftD() < 0)
    {
      com.tencent.mm.plugin.voip.b.e.Loge("MicroMsg.Voip.VoipServiceEx", "Failed to init v2protocol.");
      AppMethodBeat.o(115174);
      return -1;
    }
    if (this.GSZ.GVV.Hcz != null) {
      this.GSZ.GVV.Hcz.GSZ = this.GSZ;
    }
    if (v2protocal.HcA != null) {
      v2protocal.HcA.a(this.GSZ);
    }
    this.GZM.startTimer(50000L);
    this.GSZ.GVV.ypJ = ((int)System.currentTimeMillis());
    LinkedList localLinkedList = new LinkedList();
    this.GSZ.bu(localLinkedList);
    this.GSZ.GVV.Hbg = ("invite:" + this.GSZ.GVV.Hbb + ":" + this.GSZ.GVV.Hbc);
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(paramString);
    new com.tencent.mm.plugin.voip.model.a.g(localArrayList, this.GSZ.GVV.field_peerId, this.GSZ.GVV.field_capInfo, this.GSZ.GVV.netType, paramInt, this.GSZ.GVV.ypJ, localLinkedList).fII();
    this.GSZ.setStatus(2);
    this.GSZ.GVX.qrL = 1;
    this.GZJ.startTimer(60000L);
    this.GSZ.GVV.Hcw.GXH = System.currentTimeMillis();
    this.GSZ.GVV.Hcw.beginTime = System.currentTimeMillis();
    this.GSZ.GVV.Hcw.GXn = paramInt;
    Log.d("MicroMsg.Voip.VoipServiceEx", "iRoomType " + this.GSZ.GVV.Hcw.GXn);
    this.GSZ.elV();
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
    paramInt1 = this.GSZ.GVV.setNetSignalValue(paramInt1, paramInt2);
    AppMethodBeat.o(115186);
    return paramInt1;
  }
  
  public final void stop()
  {
    AppMethodBeat.i(115163);
    Log.i("MicroMsg.Voip.VoipServiceEx", "stop");
    reset();
    this.GSZ.a(null);
    AppMethodBeat.o(115163);
  }
  
  public final void stopRing()
  {
    AppMethodBeat.i(115194);
    if (this.qtg != null) {
      this.qtg.stop();
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
        v.adu(WifiManager.calculateSignalLevel(v.h(v.this).getRssi(), 10));
        if (v.cgL() > 10)
        {
          v.adu(i);
          if (v.cgL() >= 0) {
            break label180;
          }
          i = 0;
          label117:
          v.adu(i);
          v.adu(v.cgL() * 10);
        }
      }
      for (;;)
      {
        if (v.cgL() != -1) {
          break label195;
        }
        if (v.i(v.this) <= 1) {
          v.adt(-1);
        }
        v.this.setNetSignalValue(1, v.GZx);
        AppMethodBeat.o(115161);
        return;
        i = v.cgL();
        break;
        label180:
        i = v.cgL();
        break label117;
        v.adu(-1);
      }
      label195:
      v.this.setNetSignalValue(2, v.cgL());
      AppMethodBeat.o(115161);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.voip.model.v
 * JD-Core Version:    0.7.0.1
 */