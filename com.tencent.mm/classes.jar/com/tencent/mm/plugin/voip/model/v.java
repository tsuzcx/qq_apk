package com.tencent.mm.plugin.voip.model;

import android.content.Context;
import android.os.Looper;
import android.telephony.PhoneStateListener;
import android.telephony.SignalStrength;
import android.telephony.TelephonyManager;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.deviceinfo.af;
import com.tencent.mm.plugin.voip.b.g;
import com.tencent.mm.plugin.voip.b.a.a;
import com.tencent.mm.plugin.voip.model.a.g;
import com.tencent.mm.protocal.protobuf.dbt;
import com.tencent.mm.protocal.protobuf.fee;
import com.tencent.mm.sdk.platformtools.ConnectivityCompat;
import com.tencent.mm.sdk.platformtools.ConnectivityCompat.Companion;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.MTimerHandler;
import com.tencent.mm.sdk.platformtools.MTimerHandler.CallBack;
import com.tencent.mm.sdk.platformtools.NetStatusUtil;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.ca;
import com.tencent.mm.storage.cl;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.TimeUnit;

public final class v
  implements l.a
{
  private static int NPJ = -1;
  private static int NPK = 20;
  private static int oLi = -1;
  public l NJk;
  boolean NPE;
  public boolean NPF;
  private Object NPH;
  private int NPI;
  public String NPL;
  private int NPM;
  com.tencent.e.i.d<?> NPN;
  public boolean NPO;
  public int NPP;
  public boolean NPQ;
  public String NPR;
  @Deprecated
  private a NPS;
  private MTimerHandler NPT;
  private byte[] NPU;
  MTimerHandler NPV;
  private MTimerHandler NPW;
  private MTimerHandler NPX;
  com.tencent.mm.plugin.voip.video.e tRS;
  public String toUser;
  
  public v()
  {
    AppMethodBeat.i(115162);
    this.NPH = new Object();
    this.NPI = 0;
    this.NPO = false;
    this.NPP = 0;
    this.NPQ = false;
    this.NPR = null;
    this.toUser = null;
    this.NPF = false;
    this.NPE = false;
    this.NPT = new MTimerHandler(Looper.getMainLooper(), new MTimerHandler.CallBack()
    {
      public final boolean onTimerExpired()
      {
        AppMethodBeat.i(115156);
        if ((v.this.NJk.NMi.NQH == 1) && (v.this.NJk.gyF()))
        {
          com.tencent.mm.plugin.voip.c.e.Logi("MicroMsg.Voip.VoipServiceEx", "call timeout!");
          v.this.NJk.NMi.NSI.NNq = 101;
          com.tencent.mm.plugin.report.service.h.IzE.a(11521, new Object[] { Integer.valueOf(com.tencent.mm.plugin.voip.c.gxs().gAn()), Long.valueOf(com.tencent.mm.plugin.voip.c.gxs().gAo()), Long.valueOf(com.tencent.mm.plugin.voip.c.gxs().gyI()), Integer.valueOf(4), Long.valueOf(System.currentTimeMillis()), Long.valueOf(System.currentTimeMillis()) });
          v.this.alb(4);
          v.this.NJk.NMj.gyd();
        }
        AppMethodBeat.o(115156);
        return false;
      }
    }, false);
    this.NPU = new byte[500];
    this.NPV = new MTimerHandler(Looper.getMainLooper(), new MTimerHandler.CallBack()
    {
      public final boolean onTimerExpired()
      {
        AppMethodBeat.i(115157);
        Object localObject = v.this.NJk;
        ((l)localObject).NMq += 1;
        if (v.this.NJk.NMi.roomId == 0)
        {
          com.tencent.mm.plugin.voip.c.e.Loge("MicroMsg.Voip.VoipServiceEx", com.tencent.mm.compatible.util.f.avD() + "double link switch roomId == 0 ");
          v.a(v.this).stopTimer();
        }
        for (;;)
        {
          AppMethodBeat.o(115157);
          return true;
          v.this.NJk.NMi.app2EngineDataEx(v.this.NJk.NMi.NRZ, v.this.NJk.NMi.NSa, v.this.NJk.NMi.NSb, 0, 0);
          if ((!v.this.NJk.NMp) && (1 == v.this.NJk.NMi.field_mGetValidSample))
          {
            v.this.NJk.NMp = true;
            v.this.NJk.NMr = v.this.NJk.NMq;
          }
          if (1 == v.this.NJk.NLV) {
            v.this.NJk.NLV = 15;
          }
          if ((true == v.this.NJk.NMp) && (v.this.NJk.NMq - v.this.NJk.NMr == v.this.NJk.NLV) && ((v.this.NJk.NMi.NRQ & 0x1) == 0))
          {
            v.this.NJk.NMr = v.this.NJk.NMq;
            int i = v.this.NJk.NMi.isDCSameLan();
            int k = v.this.NJk.NMi.getCurrentConnType();
            if ((1 == i) && (1 == k))
            {
              com.tencent.mm.plugin.voip.c.e.Logi("MicroMsg.Voip.VoipServiceEx", "zhengxue[DOUBLELINK]  In the Same LAN, isDCSameLan = ".concat(String.valueOf(i)));
              localObject = v.this.NJk;
              ((l)localObject).NMq += 1;
              AppMethodBeat.o(115157);
              return true;
            }
            int m = v.this.NJk.NMi.getcurstrategy();
            int n = v.this.NJk.NMi.isRelayConnReady();
            int i1 = v.this.NJk.NMi.isDCReady();
            int j = v.this.NJk.NLV - 3;
            i = j;
            if (j > 15) {
              i = 15;
            }
            v.this.NJk.NMi.app2EngineLinkQualityEx(i, v.b(v.this));
            new com.tencent.mm.plugin.voip.model.a.d(v.this.NJk.NMi.roomId, v.this.NJk.NMi.DPJ, v.this.NJk.NMi.DPQ, k, n, i1, m, v.b(v.this), v.this.NJk.NMi.field_realLinkQualityInfoBuffLen).gAX();
            localObject = v.this.NJk.NMi;
            ((v2protocal)localObject).NRS += 1;
            com.tencent.mm.plugin.voip.c.e.Logi("MicroMsg.Voip.VoipServiceEx", "zhengxue[DOUBLELINK]  doubleLinkSwitchReportStatus " + v.this.NJk.NLV + " isFirstValidSampleSet " + v.this.NJk.NMp + " mGetValidSample " + v.this.NJk.NMi.field_mGetValidSample + "mDoubleLinkSwitchReqCnt " + v.this.NJk.NMi.NRS + "mTimerCounter " + v.this.NJk.NMq + "mLastSwitchTimer " + v.this.NJk.NMr);
          }
        }
      }
    }, true);
    this.NPW = new MTimerHandler(Looper.getMainLooper(), new MTimerHandler.CallBack()
    {
      public final boolean onTimerExpired()
      {
        AppMethodBeat.i(115158);
        if (v.this.NJk.NMi.roomId == 0)
        {
          com.tencent.mm.plugin.voip.c.e.Loge("MicroMsg.Voip.VoipServiceEx", com.tencent.mm.compatible.util.f.avD() + " roomId == 0 ");
          v.c(v.this).stopTimer();
        }
        label136:
        for (;;)
        {
          AppMethodBeat.o(115158);
          return true;
          if (v.this.NJk.mStatus >= 5) {}
          for (int i = 1;; i = 0)
          {
            if (i == 0) {
              break label136;
            }
            new com.tencent.mm.plugin.voip.model.a.f(v.this.NJk.NMi.roomId, v.this.NJk.NMi.DPJ, v.this.NJk.NMx).gAX();
            break;
          }
        }
      }
    }, true);
    this.NPX = new MTimerHandler(Looper.getMainLooper(), new MTimerHandler.CallBack()
    {
      public final boolean onTimerExpired()
      {
        AppMethodBeat.i(115159);
        Log.i("MicroMsg.Voip.VoipServiceEx", "voip called out of time,now destroy...");
        if ((3 == v.this.NJk.mStatus) && (v.d(v.this) != 0) && (v.d(v.this) == v.this.NJk.NMi.roomId))
        {
          v.e(v.this);
          v.this.NJk.J(5, -9000, "");
        }
        AppMethodBeat.o(115159);
        return false;
      }
    }, true);
    this.NJk = m.gza();
    this.NJk.a(this);
    this.tRS = new com.tencent.mm.plugin.voip.video.e(MMApplicationContext.getContext());
    this.NPO = false;
    this.NPP = 0;
    this.NPQ = false;
    this.NPR = null;
    AppMethodBeat.o(115162);
  }
  
  private void gAJ()
  {
    AppMethodBeat.i(115166);
    Log.d("MicroMsg.Voip.VoipServiceEx", "reset");
    this.NPW.stopTimer();
    this.NPT.stopTimer();
    this.NPV.stopTimer();
    this.NPX.stopTimer();
    this.NPI = 0;
    AppMethodBeat.o(115166);
  }
  
  private boolean gAL()
  {
    AppMethodBeat.i(115169);
    boolean bool = false;
    if (this.NJk != null) {
      bool = this.NJk.gyF();
    }
    AppMethodBeat.o(115169);
    return bool;
  }
  
  public static boolean gAM()
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
  
  private void gAR()
  {
    AppMethodBeat.i(237002);
    final TelephonyManager localTelephonyManager = (TelephonyManager)MMApplicationContext.getContext().getSystemService("phone");
    if (localTelephonyManager != null)
    {
      Object localObject = new PhoneStateListener()
      {
        public final void onSignalStrengthsChanged(SignalStrength paramAnonymousSignalStrength)
        {
          int i = 100;
          AppMethodBeat.i(115160);
          super.onSignalStrengthsChanged(paramAnonymousSignalStrength);
          String[] arrayOfString = paramAnonymousSignalStrength.toString().split(" ");
          if (localTelephonyManager.getNetworkType() == 13)
          {
            if ((arrayOfString != null) && (arrayOfString.length >= 10)) {
              v.ald(Util.getInt(arrayOfString[9], -141) + 140);
            }
            v.this.NPL = "LTE";
            if (v.NPJ <= 100) {
              break label156;
            }
            label85:
            v.ald(i);
            if (v.NPJ >= 0) {
              break label163;
            }
          }
          label156:
          label163:
          for (i = 0;; i = v.NPJ)
          {
            v.ald(i);
            v.f(v.this);
            AppMethodBeat.o(115160);
            return;
            int j = paramAnonymousSignalStrength.getGsmSignalStrength();
            if ((paramAnonymousSignalStrength.isGsm()) && (j == 99))
            {
              v.ald(-1);
              break;
            }
            v.ald((int)(j * 3.225807F));
            break;
            i = v.NPJ;
            break label85;
          }
        }
      };
      localObject = com.tencent.mm.hellhoundlib.b.c.a(256, new com.tencent.mm.hellhoundlib.b.a()).bm(localObject);
      com.tencent.mm.hellhoundlib.a.a.b(localTelephonyManager, ((com.tencent.mm.hellhoundlib.b.a)localObject).aFh(), "com/tencent/mm/plugin/voip/model/VoipServiceEx", "VOIPmoileSignalStrength", "()V", "android/telephony/TelephonyManager_EXEC_", "listen", "(Landroid/telephony/PhoneStateListener;I)V");
      localTelephonyManager.listen((PhoneStateListener)((com.tencent.mm.hellhoundlib.b.a)localObject).sf(0), ((Integer)((com.tencent.mm.hellhoundlib.b.a)localObject).sf(1)).intValue());
      com.tencent.mm.hellhoundlib.a.a.c(localTelephonyManager, "com/tencent/mm/plugin/voip/model/VoipServiceEx", "VOIPmoileSignalStrength", "()V", "android/telephony/TelephonyManager_EXEC_", "listen", "(Landroid/telephony/PhoneStateListener;I)V");
    }
    AppMethodBeat.o(237002);
  }
  
  private void gAS()
  {
    AppMethodBeat.i(237005);
    if (this.NPN != null) {
      this.NPN.cancel(false);
    }
    this.NPS = new a();
    this.NPN = com.tencent.e.h.ZvG.a(this.NPS, 0L, TimeUnit.SECONDS.toMillis(NPK));
    AppMethodBeat.o(237005);
  }
  
  private void reset()
  {
    AppMethodBeat.i(115165);
    Log.d("MicroMsg.Voip.VoipServiceEx", "reset");
    this.toUser = null;
    this.NPF = false;
    this.NPE = false;
    this.NJk.reset();
    this.NPW.stopTimer();
    this.NPT.stopTimer();
    this.NPV.stopTimer();
    this.NPX.stopTimer();
    if (this.NPN != null)
    {
      this.NPN.cancel(false);
      this.NPN = null;
    }
    this.NPI = 0;
    com.tencent.mm.plugin.voip.c.gxs().unRegister();
    com.tencent.mm.plugin.voip.c.gxs().NKK = null;
    this.NPO = false;
    this.NPP = 0;
    this.NPQ = false;
    this.NPR = null;
    AppMethodBeat.o(115165);
  }
  
  public final void J(int paramInt1, int paramInt2, String paramString)
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
      this.NJk.NMj.gya();
      paramString = com.tencent.mm.plugin.voip.b.a.NTi;
      com.tencent.mm.plugin.voip.b.a.a(a.a.NTq);
      gAO();
      AppMethodBeat.o(115173);
      return;
      this.NJk.NMj.gyd();
      paramString = com.tencent.mm.plugin.voip.b.a.NTi;
      com.tencent.mm.plugin.voip.b.a.a(a.a.NTp);
      gAO();
      AppMethodBeat.o(115173);
      return;
      this.NJk.NMj.AO(true);
      paramString = com.tencent.mm.plugin.voip.b.a.NTi;
      com.tencent.mm.plugin.voip.b.a.a(a.a.NTm);
      gAO();
      AppMethodBeat.o(115173);
      return;
      this.NJk.NMj.onError(paramInt2, paramString);
      paramString = com.tencent.mm.plugin.voip.b.a.NTi;
      com.tencent.mm.plugin.voip.b.a.a(a.a.NTn);
      gAO();
    }
  }
  
  public final void a(int paramInt1, long paramLong, int paramInt2, byte[] paramArrayOfByte1, byte[] paramArrayOfByte2, String paramString)
  {
    AppMethodBeat.i(115184);
    com.tencent.mm.plugin.voip.c.e.Logi("MicroMsg.Voip.VoipServiceEx", "doAck roomId " + paramInt1 + "  roomKey " + paramLong + " status " + paramInt2);
    if ((paramInt1 != 0) && (paramLong != 0L))
    {
      LinkedList localLinkedList = new LinkedList();
      this.NJk.bR(localLinkedList);
      this.NJk.NMi.NRs = ("ack:" + this.NJk.NMi.NRn + ":" + this.NJk.NMi.NRo);
      new com.tencent.mm.plugin.voip.model.a.a(paramInt1, paramLong, paramInt2, paramArrayOfByte1, paramArrayOfByte2, paramString, localLinkedList).gAX();
    }
    if (com.tencent.mm.plugin.voip.c.gxv()) {
      this.NJk.eVI();
    }
    AppMethodBeat.o(115184);
  }
  
  public final void a(Context paramContext, x paramx)
  {
    AppMethodBeat.i(236951);
    this.NJk.uEJ = paramContext;
    this.NJk.NMj = paramx;
    com.tencent.mm.plugin.voip.c.e.Logd("MicroMsg.Voip.VoipServiceEx", "attach ui........");
    com.tencent.mm.plugin.voip.c.e.gCB();
    AppMethodBeat.o(236951);
  }
  
  public final boolean a(fee paramfee)
  {
    AppMethodBeat.i(115178);
    if (this.NJk.gyH())
    {
      com.tencent.mm.plugin.voip.c.e.Loge("MicroMsg.Voip.VoipServiceEx", "Failed to setInviteContent during calling, status =" + this.NJk.mStatus);
      AppMethodBeat.o(115178);
      return false;
    }
    if (paramfee == null)
    {
      AppMethodBeat.o(115178);
      return false;
    }
    this.NJk.NMi.NSI.NNB = paramfee.UDF;
    Log.d("MicroMsg.Voip.VoipServiceEx", "iRoomType " + this.NJk.NMi.NSI.NNB);
    if (this.NJk.NMi.gBo())
    {
      com.tencent.mm.plugin.voip.c.e.Logw("MicroMsg.Voip.VoipServiceEx", com.tencent.mm.compatible.util.f.avD() + "v2protocal already init.");
      this.NJk.NMi.AZ(false);
      this.NJk.NMi.reset();
    }
    this.NJk.a(paramfee);
    boolean bool = ((com.tencent.c.a.a.a.b)com.tencent.mm.kernel.h.ag(com.tencent.c.a.a.a.b.class)).isAnchorLiving();
    if ((com.tencent.mm.plugin.voip.c.m.gDh()) || (com.tencent.mm.q.a.aAj()) || (com.tencent.mm.plugin.voip.c.m.gDj()) || (com.tencent.mm.q.a.aAl()) || (bool))
    {
      Log.e("MicroMsg.Voip.VoipServiceEx", "setInviteContent, reject, pstn/multitak/f2f talking");
      if ((com.tencent.mm.plugin.voip.c.m.gDh()) || (com.tencent.mm.q.a.aAl()) || (bool))
      {
        a(paramfee.Svu, paramfee.Svv, 2, null, null, paramfee.UDO);
        AppMethodBeat.o(115178);
        return false;
      }
      gAj();
      int i;
      label294:
      String str;
      if (paramfee.UDF == 0)
      {
        i = 1;
        str = paramfee.UDO;
        if (i == 0) {
          break label335;
        }
      }
      label335:
      for (paramfee = ca.VGy;; paramfee = ca.VGx)
      {
        s.b(str, paramfee, 0, 6, MMApplicationContext.getContext().getString(b.g.voip_callfrom_reject_msg));
        break;
        i = 0;
        break label294;
      }
    }
    if (this.NJk.NMi.gid() < 0)
    {
      com.tencent.mm.plugin.voip.c.e.Loge("MicroMsg.Voip.VoipServiceEx", "Failed to init v2protocol.");
      AppMethodBeat.o(115178);
      return false;
    }
    if (v2protocal.NSM != null) {
      v2protocal.NSM.a(this.NJk);
    }
    com.tencent.mm.plugin.report.service.h.IzE.a(11524, true, true, new Object[] { Integer.valueOf(paramfee.Svu), Long.valueOf(paramfee.Svv), Integer.valueOf(paramfee.UDF), Integer.valueOf(0), Long.valueOf(System.currentTimeMillis()) });
    if (!this.NPO) {
      this.NJk.NMj.gxZ();
    }
    AppMethodBeat.o(115178);
    return true;
  }
  
  public final int aT(boolean paramBoolean1, boolean paramBoolean2)
  {
    AppMethodBeat.i(115179);
    gAQ();
    if (!this.NPX.stopped()) {
      this.NPX.stopTimer();
    }
    this.NJk.NMi.NSI.gzi();
    Log.i("MicroMsg.Voip.VoipServiceEx", "accept onlyAudio:".concat(String.valueOf(paramBoolean1)));
    if (!this.NJk.gyG())
    {
      com.tencent.mm.plugin.voip.c.e.Loge("MicroMsg.Voip.VoipServiceEx", "Failed to accept with calling, status =" + this.NJk.mStatus);
      AppMethodBeat.o(115179);
      return -1;
    }
    if (this.NJk.NMi.roomId == 0)
    {
      com.tencent.mm.plugin.voip.c.e.Loge("MicroMsg.Voip.VoipServiceEx", "Failed to accept with roomid = 0. ");
      AppMethodBeat.o(115179);
      return -1;
    }
    LinkedList localLinkedList = new LinkedList();
    this.NJk.bR(localLinkedList);
    this.NJk.NMi.NRs = (this.NJk.NMi.NRs + "|answer:" + this.NJk.NMi.NRn + ":" + this.NJk.NMi.NRo);
    com.tencent.mm.plugin.voip.c.e.Logd("MicroMsg.Voip.VoipServiceEx", com.tencent.mm.compatible.util.f.avD() + "accept invite, roomid:" + this.NJk.NMi.roomId + " nic list size:" + localLinkedList.size());
    this.NPW.startTimer(50000L);
    this.NJk.NMi.NSI.gzj();
    new com.tencent.mm.plugin.voip.model.a.b(1, this.NJk.NMi.netType, this.NJk.NMi.roomId, this.NJk.NMi.field_peerId, this.NJk.NMi.field_capInfo, this.NJk.NMi.DPJ, paramBoolean1, paramBoolean2, localLinkedList).gAX();
    this.NJk.setStatus(4);
    this.NJk.NMk.tQu = 1;
    this.NJk.fQy = true;
    AppMethodBeat.o(115179);
    return 0;
  }
  
  public final void akP(int paramInt)
  {
    AppMethodBeat.i(115187);
    this.NJk.akP(paramInt);
    AppMethodBeat.o(115187);
  }
  
  public final boolean akQ(int paramInt)
  {
    AppMethodBeat.i(236994);
    boolean bool = this.NJk.akQ(paramInt);
    AppMethodBeat.o(236994);
    return bool;
  }
  
  public final void akX(int paramInt)
  {
    AppMethodBeat.i(115167);
    this.NJk.akL(paramInt);
    AppMethodBeat.o(115167);
  }
  
  public final void akY(int paramInt)
  {
    AppMethodBeat.i(236996);
    if ((this.tRS != null) && (paramInt > 0)) {
      this.tRS.a(paramInt, false, 0, false);
    }
    AppMethodBeat.o(236996);
  }
  
  public final void ala(int paramInt)
  {
    AppMethodBeat.i(237008);
    this.NPM = 0;
    if (paramInt > 0) {
      NPK = paramInt;
    }
    gAS();
    gAR();
    AppMethodBeat.o(237008);
  }
  
  public final int alb(int paramInt)
  {
    AppMethodBeat.i(115176);
    if (!this.NJk.gyH())
    {
      com.tencent.mm.plugin.voip.c.e.Loge("MicroMsg.Voip.VoipServiceEx", "Failed to cancel call ,as not in calling.");
      AppMethodBeat.o(115176);
      return -1;
    }
    Log.i("MicroMsg.Voip.VoipServiceEx", "cancelCallEx, roomId:%d, msgID:%d, inviteId:%d, cancelType:%d", new Object[] { Integer.valueOf(this.NJk.NMi.roomId), Integer.valueOf(this.NJk.NMi.NQF), Integer.valueOf(this.NJk.NMi.DPL), Integer.valueOf(paramInt) });
    synchronized (this.NPH)
    {
      if ((this.NJk.NMi.roomId == 0) && (this.NJk.NMi.DPL == 0))
      {
        com.tencent.mm.plugin.voip.c.e.Loge("MicroMsg.Voip.VoipServiceEx", "Failed to cancel call with roomid = 0 and inviteId = 0 ");
        AppMethodBeat.o(115176);
        return -1;
      }
      if (this.NJk.NMi.gBo())
      {
        this.NJk.NMi.AZ(true);
        new com.tencent.mm.plugin.voip.model.a.c(this.NJk.NMi.roomId, this.NJk.NMi.DPJ, this.NJk.NMi.jLI, "", this.NJk.NMi.DPL, paramInt).gAX();
      }
      Object localObject2 = this.NJk.NMi.NSI;
      ((o)localObject2).NNL = ((int)(System.currentTimeMillis() - ((o)localObject2).NNV));
      com.tencent.mm.plugin.voip.c.e.Logd("MicroMsg.VoipDailReport", "devin:cancelInvite:" + ((o)localObject2).NNL);
      if ((this.NJk.NMi.NQY == 0) && (this.NJk.NMi.NQZ == 0)) {
        this.NJk.gyD();
      }
      this.NJk.akN(this.tRS.gDx());
      this.NJk.NMi.NSI.NOa = this.NJk.NMj.gyg();
      if (com.tencent.mm.plugin.voip.c.gxs().NPg != null)
      {
        this.NJk.NMi.NSI.NOb = com.tencent.mm.plugin.voip.c.gxs().NPg.gxq();
        this.NJk.NMi.NSI.NKQ = (com.tencent.mm.plugin.voip.c.gxs().NPg.gxo() / 1000L);
        this.NJk.NMi.NSI.NKR = (com.tencent.mm.plugin.voip.c.gxs().NPg.gxp() / 1000L);
      }
      localObject2 = v2protocal.gBs();
      String str1 = this.NJk.NMi.gBt();
      String str2 = this.NJk.NMi.gBy();
      String str3 = this.NJk.NMi.gBk();
      String str4 = this.NJk.NMi.gBm();
      String[] arrayOfString1 = this.NJk.NMi.gBu();
      String[] arrayOfString2 = this.NJk.NMi.gBv();
      String[] arrayOfString3 = this.NJk.NMi.gBw();
      String[] arrayOfString4 = this.NJk.NMi.gBx();
      if (str1.length() > 0) {
        new com.tencent.mm.plugin.voip.model.a.l((String)localObject2, str1, str3, str2, str4, arrayOfString1, arrayOfString2, arrayOfString3, arrayOfString4).gAX();
      }
      this.NJk.gyB();
      reset();
      this.NJk.NMi.roomId = 0;
      this.NJk.NMi.DPL = 0;
      AppMethodBeat.o(115176);
      return 0;
    }
  }
  
  public final void alc(int paramInt)
  {
    AppMethodBeat.i(115196);
    this.NPI = paramInt;
    if (!this.NPX.stopped()) {
      this.NPX.stopTimer();
    }
    this.NPX.startTimer(70000L);
    AppMethodBeat.o(115196);
  }
  
  public final void b(Context paramContext, x paramx)
  {
    AppMethodBeat.i(236952);
    if ((paramContext != this.NJk.uEJ) || (paramx != this.NJk.NMj))
    {
      com.tencent.mm.plugin.voip.c.e.Logd("MicroMsg.Voip.VoipServiceEx", "cannot detach other's ui.");
      AppMethodBeat.o(236952);
      return;
    }
    this.NJk.uEJ = null;
    this.NJk.NMj = x.NQg;
    com.tencent.mm.plugin.voip.c.e.Logd("MicroMsg.Voip.VoipServiceEx", "detach ui........");
    com.tencent.mm.plugin.voip.c.e.flushLogFile();
    AppMethodBeat.o(236952);
  }
  
  public final int c(int paramInt1, long paramLong, int paramInt2)
  {
    AppMethodBeat.i(115177);
    if (!this.NJk.gyH())
    {
      com.tencent.mm.plugin.voip.c.e.Loge("MicroMsg.Voip.VoipServiceEx", "steve:[simucall]Failed to cancel call ,as not in calling.");
      AppMethodBeat.o(115177);
      return -1;
    }
    Log.i("MicroMsg.Voip.VoipServiceEx", "steve:[simucall] try to cancel my invite due to Simulcall(callee), roomId:%s, roomKey:%s, roomType:%d, msgID:%d, inviteId:%d", new Object[] { Integer.valueOf(paramInt1), Long.valueOf(paramLong), Integer.valueOf(paramInt2), Integer.valueOf(this.NJk.NMi.NQF), Integer.valueOf(this.NJk.NMi.DPL) });
    Object localObject1 = this.NPH;
    if (paramInt1 != 0) {}
    try
    {
      if (this.NJk.NMi.DPL == 0)
      {
        com.tencent.mm.plugin.voip.c.e.Loge("MicroMsg.Voip.VoipServiceEx", "steve:[simucall] Failed to cancel call with roomid = 0 and inviteId = 0 ");
        return -1;
      }
      new com.tencent.mm.plugin.voip.model.a.c(paramInt1, paramLong, this.NJk.NMi.jLI, "", this.NJk.NMi.DPL, 2).gAX();
      com.tencent.mm.plugin.report.service.h.IzE.a(11521, true, true, new Object[] { Integer.valueOf(paramInt1), Long.valueOf(paramLong), Integer.valueOf(paramInt2), Integer.valueOf(2), Long.valueOf(System.currentTimeMillis()), Long.valueOf(System.currentTimeMillis()) });
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
    AppMethodBeat.i(236993);
    paramInt1 = this.NJk.NMk.b(paramByteBuffer, paramInt1, paramInt2, paramInt3, paramInt4, paramInt5);
    AppMethodBeat.o(236993);
    return paramInt1;
  }
  
  public final int c(byte[] paramArrayOfByte, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    AppMethodBeat.i(236992);
    paramInt1 = this.NJk.NMk.b(paramArrayOfByte, paramInt1, paramInt2, paramInt3, paramInt4);
    AppMethodBeat.o(236992);
    return paramInt1;
  }
  
  public final boolean cNL()
  {
    AppMethodBeat.i(115195);
    if (this.tRS != null)
    {
      boolean bool = this.tRS.adI();
      AppMethodBeat.o(115195);
      return bool;
    }
    AppMethodBeat.o(115195);
    return true;
  }
  
  protected final void finalize()
  {
    AppMethodBeat.i(115164);
    stop();
    super.finalize();
    AppMethodBeat.o(115164);
  }
  
  public final boolean gAK()
  {
    AppMethodBeat.i(115168);
    Log.i("MicroMsg.Voip.VoipServiceEx", "isRoomReady, roomId: " + this.NJk.NMi.roomId);
    if ((this.NJk.NMi.roomId != 0) && (!gAL()))
    {
      AppMethodBeat.o(115168);
      return true;
    }
    AppMethodBeat.o(115168);
    return false;
  }
  
  public final void gAN()
  {
    AppMethodBeat.i(115172);
    if (this.NJk.gyH()) {
      com.tencent.mm.plugin.voip.c.e.Loge("MicroMsg.Voip.VoipServiceEx", "checkStartup failed, stauts = " + this.NJk.mStatus);
    }
    com.tencent.mm.plugin.voip.c.e.Loge("MicroMsg.Voip.VoipServiceEx", "checkStartup...devicekey = " + cl.hAM());
    this.NJk.gyC();
    gAJ();
    af.KN(com.tencent.mm.kernel.h.aHG().aHq().hAK());
    AppMethodBeat.o(115172);
  }
  
  public final int gAO()
  {
    AppMethodBeat.i(115182);
    com.tencent.mm.plugin.voip.c.e.Logi("MicroMsg.Voip.VoipServiceEx", "hangUp,status:" + this.NJk.mStatus + " roomid:" + this.NJk.NMi.roomId + ",threadid = " + Thread.currentThread().getId());
    this.NJk.NMk.gzc();
    this.NJk.eVJ();
    if (this.NJk.NMi.NSI.NNA == 1)
    {
      ??? = this.NJk.NMi.NSI;
      if (((o)???).NNR != 0L) {
        break label623;
      }
      ((o)???).NNK = 0;
    }
    for (;;)
    {
      if (((o)???).NNK < 0)
      {
        ((o)???).NNK = 0;
        com.tencent.mm.plugin.voip.c.e.Loge("MicroMsg.VoipDailReport", "devin:endTalk, iCallTime Err, rest 0");
      }
      com.tencent.mm.plugin.voip.c.e.Logi("MicroMsg.VoipDailReport", "devin:endTalk:" + ((o)???).NNK);
      synchronized (this.NPH)
      {
        int i = this.NJk.NMi.NSI.NNC;
        if ((this.NJk.NMi.roomId != 0) || (8 == i) || (9 == i) || (10 == i) || (11 == i) || (12 == i) || (99 == i))
        {
          com.tencent.mm.plugin.voip.c.e.Logi("MicroMsg.Voip.VoipServiceEx", "steve:hangUp, uninitGLRender before protocalUninit first!!");
          if (this.NJk.NMi.gBo())
          {
            this.NJk.NMi.AZ(true);
            new com.tencent.mm.plugin.voip.model.a.i(this.NJk.NMi.roomId, this.NJk.NMi.DPJ, "").gAX();
            com.tencent.mm.plugin.voip.c.e.Loge("MicroMsg.Voip.VoipServiceEx", "devin: shutdown cgi ");
          }
          this.NJk.NMi.NSI.NOa = this.NJk.NMj.gyg();
          if (com.tencent.mm.plugin.voip.c.gxs().NPg != null)
          {
            this.NJk.NMi.NSI.NOb = com.tencent.mm.plugin.voip.c.gxs().NPg.gxq();
            this.NJk.NMi.NSI.NKQ = (com.tencent.mm.plugin.voip.c.gxs().NPg.gxo() / 1000L);
            this.NJk.NMi.NSI.NKR = (com.tencent.mm.plugin.voip.c.gxs().NPg.gxp() / 1000L);
          }
          this.NJk.akN(this.tRS.gDx());
          String str1 = v2protocal.gBs();
          String str2 = this.NJk.NMi.gBt();
          String str3 = this.NJk.NMi.gBy();
          String str4 = this.NJk.NMi.gBk();
          String str5 = this.NJk.NMi.gBm();
          String[] arrayOfString1 = this.NJk.NMi.gBu();
          String[] arrayOfString2 = this.NJk.NMi.gBv();
          String[] arrayOfString3 = this.NJk.NMi.gBw();
          String[] arrayOfString4 = this.NJk.NMi.gBx();
          if (str2.length() > 0)
          {
            new com.tencent.mm.plugin.voip.model.a.l(str1, str2, str4, str3, str5, arrayOfString1, arrayOfString2, arrayOfString3, arrayOfString4).gAX();
            com.tencent.mm.plugin.voip.c.e.Loge("MicroMsg.Voip.VoipServiceEx", "devin: statreport cgi ");
          }
          this.NJk.gyB();
          reset();
          this.NJk.NMi.roomId = 0;
          com.tencent.mm.plugin.voip.c.e.Logd("MicroMsg.Voip.VoipServiceEx", "hangUp over");
          AppMethodBeat.o(115182);
          return 0;
          label623:
          ((o)???).NNK = ((int)((System.currentTimeMillis() - ((o)???).NNR) / 1000L));
          continue;
        }
        com.tencent.mm.plugin.voip.c.e.Loge("MicroMsg.Voip.VoipServiceEx", "call hangUp roomId == 0 ");
      }
    }
  }
  
  public final void gAP()
  {
    AppMethodBeat.i(115185);
    LinkedList localLinkedList = new LinkedList();
    this.NJk.NMi.bS(localLinkedList);
    int j = 0;
    int m = 0;
    int n;
    for (int i = 0; j < localLinkedList.size(); i = n)
    {
      int k = m;
      if (((dbt)localLinkedList.get(j)).SpF == 5) {
        k = m + 1;
      }
      n = i;
      if (((dbt)localLinkedList.get(j)).SpF == 4) {
        n = i + 1;
      }
      j += 1;
      m = k;
    }
    this.NJk.NMi.NRs = (this.NJk.NMi.NRs + "|redirect:" + i + ":" + m);
    new com.tencent.mm.plugin.voip.model.a.h(this.NJk.NMi.roomId, this.NJk.NMi.DPJ, this.NJk.NMi.DPQ, 0, 0, null, localLinkedList).gAX();
    AppMethodBeat.o(115185);
  }
  
  public final void gAQ()
  {
    AppMethodBeat.i(115197);
    if (this.NPT != null)
    {
      com.tencent.mm.plugin.voip.c.e.Logi("MicroMsg.Voip.VoipServiceEx", "devincdai: voip reset timecount");
      this.NPT.stopTimer();
      this.NPT.startTimer(60000L);
    }
    AppMethodBeat.o(115197);
  }
  
  public final int gAh()
  {
    AppMethodBeat.i(115175);
    Log.i("MicroMsg.Voip.VoipServiceEx", "cancelCall, roomId:" + this.NJk.NMi.roomId);
    if ((this.NJk.NMi.roomId == 0) && (this.NJk.NMi.DPL == 0))
    {
      reset();
      AppMethodBeat.o(115175);
      return -1;
    }
    this.NJk.NMi.NSI.NNq = this.NJk.gyE();
    this.NJk.NMi.NSI.NNC = 3;
    if (this.NJk.mStatus < 6) {
      this.NJk.NMi.NSI.NNE = 1;
    }
    com.tencent.mm.plugin.report.service.h.IzE.a(11521, true, true, new Object[] { Integer.valueOf(com.tencent.mm.plugin.voip.c.gxs().gAn()), Long.valueOf(com.tencent.mm.plugin.voip.c.gxs().gAo()), Long.valueOf(com.tencent.mm.plugin.voip.c.gxs().gyI()), Integer.valueOf(1), Long.valueOf(System.currentTimeMillis()), Long.valueOf(System.currentTimeMillis()) });
    int i = alb(1);
    AppMethodBeat.o(115175);
    return i;
  }
  
  public final int gAi()
  {
    AppMethodBeat.i(236965);
    Log.i("MicroMsg.Voip.VoipServiceEx", "cancelCallByPhoneInter, roomId:" + this.NJk.NMi.roomId);
    if (this.NJk.NMi.roomId == 0)
    {
      AppMethodBeat.o(236965);
      return -1;
    }
    this.NJk.NMi.NSI.NNq = 102;
    this.NJk.NMi.NSI.NNC = 6;
    if (com.tencent.mm.plugin.voip.c.gxs().NPg != null)
    {
      this.NJk.NMi.NSI.NOb = com.tencent.mm.plugin.voip.c.gxs().NPg.gxq();
      this.NJk.NMi.NSI.NKQ = (com.tencent.mm.plugin.voip.c.gxs().NPg.gxo() / 1000L);
      this.NJk.NMi.NSI.NKR = (com.tencent.mm.plugin.voip.c.gxs().NPg.gxp() / 1000L);
    }
    com.tencent.mm.plugin.report.service.h.IzE.a(11521, true, true, new Object[] { Integer.valueOf(com.tencent.mm.plugin.voip.c.gxs().gAn()), Long.valueOf(com.tencent.mm.plugin.voip.c.gxs().gAo()), Long.valueOf(com.tencent.mm.plugin.voip.c.gxs().gyI()), Integer.valueOf(3), Long.valueOf(System.currentTimeMillis()), Long.valueOf(System.currentTimeMillis()) });
    int i = alb(3);
    AppMethodBeat.o(236965);
    return i;
  }
  
  public final int gAj()
  {
    AppMethodBeat.i(115180);
    Log.i("MicroMsg.Voip.VoipServiceEx", "reject");
    if (!this.NJk.gyG())
    {
      com.tencent.mm.plugin.voip.c.e.Loge("MicroMsg.Voip.VoipServiceEx", "Failed to reject with calling, status =" + this.NJk.mStatus);
      AppMethodBeat.o(115180);
      return -1;
    }
    synchronized (this.NPH)
    {
      if (this.NJk.NMi.roomId == 0)
      {
        com.tencent.mm.plugin.voip.c.e.Loge("MicroMsg.Voip.VoipServiceEx", "Failed to reject with roomid = 0. ");
        AppMethodBeat.o(115180);
        return -1;
      }
      this.NJk.NMi.NSI.gzj();
      com.tencent.mm.plugin.voip.c.e.Logd("MicroMsg.Voip.VoipServiceEx", " reject, status:" + this.NJk.mStatus + " roomid:" + this.NJk.NMi.roomId);
      int i = this.NJk.NMi.netType;
      int j = this.NJk.NMi.roomId;
      long l = this.NJk.NMi.DPJ;
      new com.tencent.mm.plugin.voip.model.a.b(2, i, j, new byte[0], new byte[0], l, false, false, null).gAX();
      if ((this.NJk.NMi.NQY == 0) && (this.NJk.NMi.NQZ == 0)) {
        this.NJk.gyD();
      }
      this.NJk.akN(this.tRS.gDx());
      this.NJk.NMi.NSI.NOa = this.NJk.NMj.gyg();
      if (com.tencent.mm.plugin.voip.c.gxs().NPg != null)
      {
        this.NJk.NMi.NSI.NOb = com.tencent.mm.plugin.voip.c.gxs().NPg.gxq();
        this.NJk.NMi.NSI.NKQ = (com.tencent.mm.plugin.voip.c.gxs().NPg.gxo() / 1000L);
        this.NJk.NMi.NSI.NKR = (com.tencent.mm.plugin.voip.c.gxs().NPg.gxp() / 1000L);
      }
      if (this.NJk.NMi.gBo()) {
        this.NJk.NMi.AZ(true);
      }
      String str1 = v2protocal.gBs();
      String str2 = this.NJk.NMi.gBt();
      String str3 = this.NJk.NMi.gBy();
      String str4 = this.NJk.NMi.gBk();
      String str5 = this.NJk.NMi.gBm();
      String[] arrayOfString1 = this.NJk.NMi.gBu();
      String[] arrayOfString2 = this.NJk.NMi.gBv();
      String[] arrayOfString3 = this.NJk.NMi.gBw();
      String[] arrayOfString4 = this.NJk.NMi.gBx();
      com.tencent.mm.plugin.voip.c.e.Logd("MicroMsg.Voip.VoipServiceEx", "devin: statreport");
      if (str2.length() > 0)
      {
        com.tencent.mm.plugin.voip.c.e.Logd("MicroMsg.Voip.VoipServiceEx", "devin: reject() newdialInfo.length() > 0");
        new com.tencent.mm.plugin.voip.model.a.l(str1, str2, str4, str3, str5, arrayOfString1, arrayOfString2, arrayOfString3, arrayOfString4).gAX();
        this.NJk.gyB();
        reset();
        this.NJk.NMi.roomId = 0;
        AppMethodBeat.o(115180);
        return 0;
      }
      com.tencent.mm.plugin.voip.c.e.Logd("MicroMsg.Voip.VoipServiceEx", "devin: reject() newdialInfo.length() <= 0");
    }
  }
  
  public final int gAk()
  {
    AppMethodBeat.i(115181);
    Log.i("MicroMsg.Voip.VoipServiceEx", "hangUp");
    if (this.NJk.NMi.roomId == 0)
    {
      this.NJk.NMk.gzc();
      this.NJk.eVJ();
      reset();
      AppMethodBeat.o(115181);
      return 0;
    }
    this.NJk.NMi.NSI.NNq = this.NJk.gyE();
    int i = gAO();
    AppMethodBeat.o(115181);
    return i;
  }
  
  public final int gAl()
  {
    AppMethodBeat.i(236981);
    Log.i("MicroMsg.Voip.VoipServiceEx", "hangUpByPhoneInter");
    if (this.NJk.NMi.roomId == 0)
    {
      this.NJk.NMk.gzc();
      reset();
      AppMethodBeat.o(236981);
      return 0;
    }
    this.NJk.NMi.NSI.NNq = 109;
    this.NJk.NMi.NSI.NNI = 4;
    int i = gAO();
    AppMethodBeat.o(236981);
    return i;
  }
  
  public final int gAm()
  {
    AppMethodBeat.i(115183);
    Log.i("MicroMsg.Voip.VoipServiceEx", "ignoreInvite");
    if (!this.NJk.gyG())
    {
      com.tencent.mm.plugin.voip.c.e.Loge("MicroMsg.Voip.VoipServiceEx", "Failed to ignore with calling, status =" + this.NJk.mStatus);
      AppMethodBeat.o(115183);
      return -1;
    }
    synchronized (this.NPH)
    {
      if (this.NJk.NMi.roomId == 0)
      {
        com.tencent.mm.plugin.voip.c.e.Loge("MicroMsg.Voip.VoipServiceEx", "Failed to reject with roomid = 0. ");
        AppMethodBeat.o(115183);
        return -1;
      }
      int i = this.NJk.NMi.netType;
      int j = this.NJk.NMi.roomId;
      long l = this.NJk.NMi.DPJ;
      new com.tencent.mm.plugin.voip.model.a.b(3, i, j, new byte[0], new byte[0], l, false, false, null).gAX();
      reset();
      this.NJk.NMi.roomId = 0;
      AppMethodBeat.o(115183);
      return 0;
    }
  }
  
  public final int gD(String paramString, int paramInt)
  {
    AppMethodBeat.i(115174);
    Log.i("MicroMsg.Voip.VoipServiceEx", "call username:%s, callType:%d, inviteType:%d", new Object[] { paramString, Integer.valueOf(0), Integer.valueOf(paramInt) });
    if (Util.isNullOrNil(paramString))
    {
      com.tencent.mm.plugin.voip.c.e.Loge("MicroMsg.Voip.VoipServiceEx", "Failed call without valid username.");
      AppMethodBeat.o(115174);
      return -1;
    }
    if (this.NJk.gyH())
    {
      com.tencent.mm.plugin.voip.c.e.Loge("MicroMsg.Voip.VoipServiceEx", "Failed call withing calling.");
      AppMethodBeat.o(115174);
      return -1;
    }
    this.NPR = paramString;
    this.NJk.NMi.NQH = 1;
    this.NJk.NMi.jLI = paramString;
    com.tencent.mm.plugin.voip.c.e.Logd("MicroMsg.Voip.VoipServiceEx", com.tencent.mm.compatible.util.f.avD() + "call username:" + paramString);
    if (this.NJk.NMi.gBo())
    {
      com.tencent.mm.plugin.voip.c.e.Loge("MicroMsg.Voip.VoipServiceEx", com.tencent.mm.compatible.util.f.avD() + "v2protocal already init.");
      this.NJk.NMi.AZ(false);
      this.NJk.NMi.reset();
    }
    if (this.NJk.NMi.gid() < 0)
    {
      com.tencent.mm.plugin.voip.c.e.Loge("MicroMsg.Voip.VoipServiceEx", "Failed to init v2protocol.");
      AppMethodBeat.o(115174);
      return -1;
    }
    if (this.NJk.NMi.NSL != null) {
      this.NJk.NMi.NSL.NJk = this.NJk;
    }
    if (v2protocal.NSM != null) {
      v2protocal.NSM.a(this.NJk);
    }
    this.NPW.startTimer(50000L);
    this.NJk.NMi.DPL = ((int)System.currentTimeMillis());
    LinkedList localLinkedList = new LinkedList();
    this.NJk.bR(localLinkedList);
    this.NJk.NMi.NRs = ("invite:" + this.NJk.NMi.NRn + ":" + this.NJk.NMi.NRo);
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(paramString);
    new g(localArrayList, this.NJk.NMi.field_peerId, this.NJk.NMi.field_capInfo, this.NJk.NMi.netType, paramInt, this.NJk.NMi.DPL, localLinkedList).gAX();
    this.NJk.setStatus(2);
    this.NJk.NMk.tQu = 1;
    this.NPT.startTimer(60000L);
    this.NJk.NMi.NSI.NNV = System.currentTimeMillis();
    this.NJk.NMi.NSI.beginTime = System.currentTimeMillis();
    this.NJk.NMi.NSI.NNB = paramInt;
    Log.d("MicroMsg.Voip.VoipServiceEx", "iRoomType " + this.NJk.NMi.NSI.NNB);
    if (com.tencent.mm.plugin.voip.c.gxv()) {
      this.NJk.eVI();
    }
    AppMethodBeat.o(115174);
    return 0;
  }
  
  public final boolean gyH()
  {
    AppMethodBeat.i(115170);
    if (this.NJk.gyH())
    {
      AppMethodBeat.o(115170);
      return true;
    }
    AppMethodBeat.o(115170);
    return false;
  }
  
  public final int setNetSignalValue(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(115186);
    paramInt1 = this.NJk.NMi.setNetSignalValue(paramInt1, paramInt2);
    AppMethodBeat.o(115186);
    return paramInt1;
  }
  
  public final void stop()
  {
    AppMethodBeat.i(115163);
    Log.i("MicroMsg.Voip.VoipServiceEx", "stop");
    reset();
    this.NJk.a(null);
    AppMethodBeat.o(115163);
  }
  
  public final void stopRing()
  {
    AppMethodBeat.i(115194);
    if (this.tRS != null) {
      this.tRS.stop();
    }
    AppMethodBeat.o(115194);
  }
  
  @Deprecated
  final class a
    implements Runnable
  {
    a() {}
    
    public final void run()
    {
      AppMethodBeat.i(115161);
      Log.d("MicroMsg.Voip.VoipServiceEx", "VOIPwifiStrengthTask");
      if (NetStatusUtil.isWifi(MMApplicationContext.getContext()))
      {
        v.vs(ConnectivityCompat.Companion.getWiFiRssi());
        v.vs(v.chu() * 10);
      }
      while (v.chu() == -1)
      {
        if (v.g(v.this) <= 1) {
          v.ald(-1);
        }
        v.this.setNetSignalValue(1, v.NPJ);
        AppMethodBeat.o(115161);
        return;
        v.vs(-1);
      }
      v.this.setNetSignalValue(2, v.chu());
      AppMethodBeat.o(115161);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.voip.model.v
 * JD-Core Version:    0.7.0.1
 */