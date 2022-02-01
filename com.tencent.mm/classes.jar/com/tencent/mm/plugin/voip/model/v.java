package com.tencent.mm.plugin.voip.model;

import android.content.Context;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import android.os.Looper;
import android.telephony.TelephonyManager;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.deviceinfo.ae;
import com.tencent.mm.kernel.e;
import com.tencent.mm.plugin.voip.model.a.b;
import com.tencent.mm.protocal.protobuf.bxf;
import com.tencent.mm.protocal.protobuf.dsb;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ai;
import com.tencent.mm.sdk.platformtools.au;
import com.tencent.mm.sdk.platformtools.au.a;
import com.tencent.mm.sdk.platformtools.bs;
import com.tencent.mm.storage.bo;
import com.tencent.mm.storage.bw;
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
  private static int AFi = -1;
  private static int AFj = 20;
  private static int klT = -1;
  private Object AFg;
  private int AFh;
  public String AFk;
  private int AFl;
  ScheduledExecutorService AFm;
  ScheduledFuture<?> AFn;
  private WifiInfo AFo;
  public boolean AFp;
  public int AFq;
  public boolean AFr;
  public String AFs;
  private a AFt;
  private au AFu;
  private byte[] AFv;
  au AFw;
  private au AFx;
  private au AFy;
  public l Ayh;
  private WifiManager bSR;
  com.tencent.mm.plugin.voip.video.i oue;
  
  public v()
  {
    AppMethodBeat.i(115162);
    this.AFg = new Object();
    this.AFh = 0;
    this.AFm = Executors.newScheduledThreadPool(1);
    this.AFp = false;
    this.AFq = 0;
    this.AFr = false;
    this.AFs = null;
    this.AFu = new au(Looper.getMainLooper(), new au.a()
    {
      public final boolean onTimerExpired()
      {
        AppMethodBeat.i(115156);
        if ((v.this.Ayh.ABJ.AGf == 1) && (v.this.Ayh.eij()))
        {
          com.tencent.mm.plugin.voip.b.d.Logi("MicroMsg.Voip.VoipServiceEx", "call timeout!");
          v.this.Ayh.ABJ.AIf.ACR = 101;
          com.tencent.mm.plugin.report.service.h.wUl.f(11521, new Object[] { Integer.valueOf(com.tencent.mm.plugin.voip.c.ehb().ejL()), Long.valueOf(com.tencent.mm.plugin.voip.c.ehb().ejM()), Long.valueOf(com.tencent.mm.plugin.voip.c.ehb().eim()), Integer.valueOf(4), Long.valueOf(System.currentTimeMillis()), Long.valueOf(System.currentTimeMillis()) });
          v.this.Sy(4);
          v.this.Ayh.ABK.ehJ();
        }
        AppMethodBeat.o(115156);
        return false;
      }
    }, false);
    this.AFv = new byte[500];
    this.AFw = new au(Looper.getMainLooper(), new au.a()
    {
      public final boolean onTimerExpired()
      {
        AppMethodBeat.i(115157);
        Object localObject = v.this.Ayh;
        ((l)localObject).ABR += 1;
        if (v.this.Ayh.ABJ.roomId == 0)
        {
          com.tencent.mm.plugin.voip.b.d.Loge("MicroMsg.Voip.VoipServiceEx", com.tencent.mm.compatible.util.f.YG() + "double link switch roomId == 0 ");
          v.a(v.this).stopTimer();
        }
        for (;;)
        {
          AppMethodBeat.o(115157);
          return true;
          v.this.Ayh.ABJ.app2EngineDataEx(v.this.Ayh.ABJ.AHx, v.this.Ayh.ABJ.AHy, v.this.Ayh.ABJ.AHz, 0, 0);
          if ((!v.this.Ayh.ABQ) && (1 == v.this.Ayh.ABJ.field_mGetValidSample))
          {
            v.this.Ayh.ABQ = true;
            v.this.Ayh.ABS = v.this.Ayh.ABR;
          }
          if (1 == v.this.Ayh.ABw) {
            v.this.Ayh.ABw = 15;
          }
          if ((true == v.this.Ayh.ABQ) && (v.this.Ayh.ABR - v.this.Ayh.ABS == v.this.Ayh.ABw) && ((v.this.Ayh.ABJ.AHo & 0x1) == 0))
          {
            v.this.Ayh.ABS = v.this.Ayh.ABR;
            int i = v.this.Ayh.ABJ.isDCSameLan();
            int k = v.this.Ayh.ABJ.getCurrentConnType();
            if ((1 == i) && (1 == k))
            {
              com.tencent.mm.plugin.voip.b.d.Logi("MicroMsg.Voip.VoipServiceEx", "zhengxue[DOUBLELINK]  In the Same LAN, isDCSameLan = ".concat(String.valueOf(i)));
              localObject = v.this.Ayh;
              ((l)localObject).ABR += 1;
              AppMethodBeat.o(115157);
              return true;
            }
            int m = v.this.Ayh.ABJ.getcurstrategy();
            int n = v.this.Ayh.ABJ.isRelayConnReady();
            int i1 = v.this.Ayh.ABJ.isDCReady();
            int j = v.this.Ayh.ABw - 3;
            i = j;
            if (j > 15) {
              i = 15;
            }
            v.this.Ayh.ABJ.app2EngineLinkQualityEx(i, v.b(v.this));
            new com.tencent.mm.plugin.voip.model.a.d(v.this.Ayh.ABJ.roomId, v.this.Ayh.ABJ.tIG, v.this.Ayh.ABJ.tIN, k, n, i1, m, v.b(v.this), v.this.Ayh.ABJ.field_realLinkQualityInfoBuffLen).ekv();
            localObject = v.this.Ayh.ABJ;
            ((v2protocal)localObject).AHq += 1;
            com.tencent.mm.plugin.voip.b.d.Logi("MicroMsg.Voip.VoipServiceEx", "zhengxue[DOUBLELINK]  doubleLinkSwitchReportStatus " + v.this.Ayh.ABw + " isFirstValidSampleSet " + v.this.Ayh.ABQ + " mGetValidSample " + v.this.Ayh.ABJ.field_mGetValidSample + "mDoubleLinkSwitchReqCnt " + v.this.Ayh.ABJ.AHq + "mTimerCounter " + v.this.Ayh.ABR + "mLastSwitchTimer " + v.this.Ayh.ABS);
          }
        }
      }
    }, true);
    this.AFx = new au(Looper.getMainLooper(), new au.a()
    {
      public final boolean onTimerExpired()
      {
        AppMethodBeat.i(115158);
        if (v.this.Ayh.ABJ.roomId == 0)
        {
          com.tencent.mm.plugin.voip.b.d.Loge("MicroMsg.Voip.VoipServiceEx", com.tencent.mm.compatible.util.f.YG() + " roomId == 0 ");
          v.c(v.this).stopTimer();
        }
        label136:
        for (;;)
        {
          AppMethodBeat.o(115158);
          return true;
          if (v.this.Ayh.mStatus >= 5) {}
          for (int i = 1;; i = 0)
          {
            if (i == 0) {
              break label136;
            }
            new com.tencent.mm.plugin.voip.model.a.f(v.this.Ayh.ABJ.roomId, v.this.Ayh.ABJ.tIG, v.this.Ayh.ACb).ekv();
            break;
          }
        }
      }
    }, true);
    this.AFy = new au(Looper.getMainLooper(), new au.a()
    {
      public final boolean onTimerExpired()
      {
        AppMethodBeat.i(115159);
        ac.i("MicroMsg.Voip.VoipServiceEx", "voip called out of time,now destroy...");
        if ((3 == v.this.Ayh.mStatus) && (v.d(v.this) != 0) && (v.d(v.this) == v.this.Ayh.ABJ.roomId))
        {
          v.e(v.this);
          v.this.Ayh.H(5, -9000, "");
        }
        AppMethodBeat.o(115159);
        return false;
      }
    }, true);
    this.Ayh = m.eiE();
    this.Ayh.a(this);
    this.oue = new com.tencent.mm.plugin.voip.video.i(ai.getContext());
    this.AFp = false;
    this.AFq = 0;
    this.AFr = false;
    this.AFs = null;
    AppMethodBeat.o(115162);
  }
  
  private void ekc()
  {
    AppMethodBeat.i(115166);
    ac.d("MicroMsg.Voip.VoipServiceEx", "reset");
    this.AFx.stopTimer();
    this.AFu.stopTimer();
    this.AFw.stopTimer();
    this.AFy.stopTimer();
    this.AFh = 0;
    AppMethodBeat.o(115166);
  }
  
  private boolean eke()
  {
    AppMethodBeat.i(115169);
    boolean bool = false;
    if (this.Ayh != null) {
      bool = this.Ayh.eij();
    }
    AppMethodBeat.o(115169);
    return bool;
  }
  
  public static boolean ekf()
  {
    AppMethodBeat.i(115171);
    if (((TelephonyManager)ai.getContext().getSystemService("phone")).getCallState() != 0)
    {
      AppMethodBeat.o(115171);
      return true;
    }
    AppMethodBeat.o(115171);
    return false;
  }
  
  private void ekp()
  {
    AppMethodBeat.i(208403);
    TelephonyManager localTelephonyManager = (TelephonyManager)ai.getContext().getSystemService("phone");
    if (localTelephonyManager != null) {
      localTelephonyManager.listen(new v.5(this, localTelephonyManager), 256);
    }
    AppMethodBeat.o(208403);
  }
  
  private void ekq()
  {
    AppMethodBeat.i(208404);
    this.bSR = ((WifiManager)ai.getContext().getApplicationContext().getSystemService("wifi"));
    if (this.AFt != null) {
      this.AFt.cancel();
    }
    this.AFt = new a();
    this.AFn = this.AFm.scheduleAtFixedRate(this.AFt, 0L, AFj, TimeUnit.SECONDS);
    AppMethodBeat.o(208404);
  }
  
  private void reset()
  {
    AppMethodBeat.i(115165);
    ac.d("MicroMsg.Voip.VoipServiceEx", "reset");
    this.Ayh.reset();
    this.AFx.stopTimer();
    this.AFu.stopTimer();
    this.AFw.stopTimer();
    this.AFy.stopTimer();
    if (this.AFt != null) {
      this.AFt.cancel();
    }
    if (this.AFn != null)
    {
      this.AFn.cancel(false);
      this.AFn = null;
    }
    this.AFh = 0;
    com.tencent.mm.plugin.voip.c.ehb().aHe();
    com.tencent.mm.plugin.voip.c.ehb().AAf = null;
    this.AFp = false;
    this.AFq = 0;
    this.AFr = false;
    this.AFs = null;
    AppMethodBeat.o(115165);
  }
  
  public final void H(int paramInt1, int paramInt2, String paramString)
  {
    AppMethodBeat.i(115173);
    ac.i("MicroMsg.Voip.VoipServiceEx", "onFinishVoIP finishType: ".concat(String.valueOf(paramInt1)));
    switch (paramInt1)
    {
    }
    for (;;)
    {
      AppMethodBeat.o(115173);
      return;
      ekl();
      this.Ayh.ABK.onReject();
      AppMethodBeat.o(115173);
      return;
      ekl();
      this.Ayh.ABK.ehJ();
      AppMethodBeat.o(115173);
      return;
      ekl();
      this.Ayh.ABK.ehL();
      AppMethodBeat.o(115173);
      return;
      ekl();
      this.Ayh.ABK.onError(paramInt2, paramString);
    }
  }
  
  public final void Sm(int paramInt)
  {
    AppMethodBeat.i(115187);
    this.Ayh.Sm(paramInt);
    AppMethodBeat.o(115187);
  }
  
  public final void Su(int paramInt)
  {
    AppMethodBeat.i(115167);
    this.Ayh.Si(paramInt);
    AppMethodBeat.o(115167);
  }
  
  public final void Sx(int paramInt)
  {
    AppMethodBeat.i(208405);
    this.bSR = null;
    this.AFo = null;
    this.AFl = 0;
    if (paramInt > 0) {
      AFj = paramInt;
    }
    ekq();
    ekp();
    AppMethodBeat.o(208405);
  }
  
  public final int Sy(int paramInt)
  {
    AppMethodBeat.i(115176);
    if (!this.Ayh.eil())
    {
      com.tencent.mm.plugin.voip.b.d.Loge("MicroMsg.Voip.VoipServiceEx", "Failed to cancel call ,as not in calling.");
      AppMethodBeat.o(115176);
      return -1;
    }
    ac.i("MicroMsg.Voip.VoipServiceEx", "cancelCallEx, roomId:%d, msgID:%d, inviteId:%d, cancelType:%d", new Object[] { Integer.valueOf(this.Ayh.ABJ.roomId), Integer.valueOf(this.Ayh.ABJ.AGd), Integer.valueOf(this.Ayh.ABJ.tII), Integer.valueOf(paramInt) });
    synchronized (this.AFg)
    {
      if ((this.Ayh.ABJ.roomId == 0) && (this.Ayh.ABJ.tII == 0))
      {
        com.tencent.mm.plugin.voip.b.d.Loge("MicroMsg.Voip.VoipServiceEx", "Failed to cancel call with roomid = 0 and inviteId = 0 ");
        AppMethodBeat.o(115176);
        return -1;
      }
      if (this.Ayh.ABJ.ekM())
      {
        this.Ayh.ABJ.sH(true);
        new com.tencent.mm.plugin.voip.model.a.c(this.Ayh.ABJ.roomId, this.Ayh.ABJ.tIG, this.Ayh.ABJ.fTK, "", this.Ayh.ABJ.tII, paramInt).ekv();
      }
      Object localObject2 = this.Ayh.ABJ.AIf;
      ((o)localObject2).ADm = ((int)(System.currentTimeMillis() - ((o)localObject2).ADw));
      com.tencent.mm.plugin.voip.b.d.Logd("MicroMsg.VoipDailReport", "devin:cancelInvite:" + ((o)localObject2).ADm);
      if ((this.Ayh.ABJ.AGx == 0) && (this.Ayh.ABJ.AGy == 0)) {
        this.Ayh.eih();
      }
      this.Ayh.Sk(this.oue.emJ());
      this.Ayh.ABJ.AIf.ADB = this.Ayh.ABK.ehN();
      if (com.tencent.mm.plugin.voip.c.ehb().AEG != null)
      {
        this.Ayh.ABJ.AIf.ADC = com.tencent.mm.plugin.voip.c.ehb().AEG.egZ();
        this.Ayh.ABJ.AIf.AAo = (com.tencent.mm.plugin.voip.c.ehb().AEG.egX() / 1000L);
        this.Ayh.ABJ.AIf.AAp = (com.tencent.mm.plugin.voip.c.ehb().AEG.egY() / 1000L);
      }
      localObject2 = v2protocal.ekP();
      String str1 = this.Ayh.ABJ.ekQ();
      String str2 = this.Ayh.ABJ.ekV();
      String str3 = this.Ayh.ABJ.ekI();
      String str4 = this.Ayh.ABJ.ekK();
      String[] arrayOfString1 = this.Ayh.ABJ.ekR();
      String[] arrayOfString2 = this.Ayh.ABJ.ekS();
      String[] arrayOfString3 = this.Ayh.ABJ.ekT();
      String[] arrayOfString4 = this.Ayh.ABJ.ekU();
      if (str1.length() > 0) {
        new com.tencent.mm.plugin.voip.model.a.l((String)localObject2, str1, str3, str2, str4, arrayOfString1, arrayOfString2, arrayOfString3, arrayOfString4).ekv();
      }
      this.Ayh.eif();
      reset();
      this.Ayh.ABJ.roomId = 0;
      this.Ayh.ABJ.tII = 0;
      AppMethodBeat.o(115176);
      return 0;
    }
  }
  
  public final void Sz(int paramInt)
  {
    AppMethodBeat.i(115196);
    this.AFh = paramInt;
    if (!this.AFy.eVs()) {
      this.AFy.stopTimer();
    }
    this.AFy.au(70000L, 70000L);
    AppMethodBeat.o(115196);
  }
  
  public final void a(int paramInt1, long paramLong, int paramInt2, byte[] paramArrayOfByte1, byte[] paramArrayOfByte2, String paramString)
  {
    AppMethodBeat.i(115184);
    com.tencent.mm.plugin.voip.b.d.Logi("MicroMsg.Voip.VoipServiceEx", "doAck roomId " + paramInt1 + "  roomKey " + paramLong + " status " + paramInt2);
    if ((paramInt1 != 0) && (paramLong != 0L))
    {
      LinkedList localLinkedList = new LinkedList();
      this.Ayh.aW(localLinkedList);
      this.Ayh.ABJ.AGQ = ("ack:" + this.Ayh.ABJ.AGL + ":" + this.Ayh.ABJ.AGM);
      new com.tencent.mm.plugin.voip.model.a.a(paramInt1, paramLong, paramInt2, paramArrayOfByte1, paramArrayOfByte2, paramString, localLinkedList).ekv();
    }
    this.Ayh.eiq();
    AppMethodBeat.o(115184);
  }
  
  public final void a(Context paramContext, x paramx)
  {
    AppMethodBeat.i(208397);
    this.Ayh.mHB = paramContext;
    this.Ayh.ABK = paramx;
    com.tencent.mm.plugin.voip.b.d.Logd("MicroMsg.Voip.VoipServiceEx", "attach ui........");
    com.tencent.mm.plugin.voip.b.d.elK();
    AppMethodBeat.o(208397);
  }
  
  public final boolean a(dsb paramdsb)
  {
    int i = 1;
    AppMethodBeat.i(115178);
    if (this.Ayh.eil())
    {
      com.tencent.mm.plugin.voip.b.d.Loge("MicroMsg.Voip.VoipServiceEx", "Failed to setInviteContent during calling, status =" + this.Ayh.mStatus);
      AppMethodBeat.o(115178);
      return false;
    }
    if (paramdsb == null)
    {
      AppMethodBeat.o(115178);
      return false;
    }
    this.Ayh.ABJ.AIf.ADc = paramdsb.FZh;
    ac.d("MicroMsg.Voip.VoipServiceEx", "iRoomType " + this.Ayh.ABJ.AIf.ADc);
    if (this.Ayh.ABJ.ekM())
    {
      com.tencent.mm.plugin.voip.b.d.Logw("MicroMsg.Voip.VoipServiceEx", com.tencent.mm.compatible.util.f.YG() + "v2protocal already init.");
      this.Ayh.ABJ.sH(false);
      this.Ayh.ABJ.reset();
    }
    this.Ayh.a(paramdsb);
    if ((com.tencent.mm.plugin.voip.b.l.emj()) || (com.tencent.mm.r.a.aaZ()) || (com.tencent.mm.plugin.voip.b.l.eml()) || (com.tencent.mm.r.a.aba()))
    {
      ac.e("MicroMsg.Voip.VoipServiceEx", "setInviteContent, reject, pstn/multitak/f2f talking");
      if ((com.tencent.mm.plugin.voip.b.l.emj()) || (com.tencent.mm.r.a.aba()))
      {
        a(paramdsb.Exf, paramdsb.Exg, 2, null, null, paramdsb.FZq);
        AppMethodBeat.o(115178);
        return false;
      }
      ekj();
      label271:
      String str;
      if (paramdsb.FZh == 0)
      {
        str = paramdsb.FZq;
        if (i == 0) {
          break label310;
        }
      }
      label310:
      for (paramdsb = bo.GYP;; paramdsb = bo.GYO)
      {
        s.c(str, paramdsb, 0, 6, ai.getContext().getString(2131764807));
        break;
        i = 0;
        break label271;
      }
    }
    if (this.Ayh.ABJ.ebh() < 0)
    {
      com.tencent.mm.plugin.voip.b.d.Loge("MicroMsg.Voip.VoipServiceEx", "Failed to init v2protocol.");
      AppMethodBeat.o(115178);
      return false;
    }
    if (v2protocal.AIj != null) {
      v2protocal.AIj.a(this.Ayh);
    }
    com.tencent.mm.plugin.report.service.h.wUl.a(11524, true, true, new Object[] { Integer.valueOf(paramdsb.Exf), Long.valueOf(paramdsb.Exg), Integer.valueOf(paramdsb.FZh), Integer.valueOf(0), Long.valueOf(System.currentTimeMillis()) });
    if (!this.AFp) {
      this.Ayh.ABK.ehG();
    }
    AppMethodBeat.o(115178);
    return true;
  }
  
  public final int ar(boolean paramBoolean1, boolean paramBoolean2)
  {
    AppMethodBeat.i(115179);
    eko();
    if (!this.AFy.eVs()) {
      this.AFy.stopTimer();
    }
    this.Ayh.ABJ.AIf.eiM();
    ac.i("MicroMsg.Voip.VoipServiceEx", "accept onlyAudio:".concat(String.valueOf(paramBoolean1)));
    if (!this.Ayh.eik())
    {
      com.tencent.mm.plugin.voip.b.d.Loge("MicroMsg.Voip.VoipServiceEx", "Failed to accept with calling, status =" + this.Ayh.mStatus);
      AppMethodBeat.o(115179);
      return -1;
    }
    if (this.Ayh.ABJ.roomId == 0)
    {
      com.tencent.mm.plugin.voip.b.d.Loge("MicroMsg.Voip.VoipServiceEx", "Failed to accept with roomid = 0. ");
      AppMethodBeat.o(115179);
      return -1;
    }
    LinkedList localLinkedList = new LinkedList();
    this.Ayh.aW(localLinkedList);
    this.Ayh.ABJ.AGQ = (this.Ayh.ABJ.AGQ + "|answer:" + this.Ayh.ABJ.AGL + ":" + this.Ayh.ABJ.AGM);
    com.tencent.mm.plugin.voip.b.d.Logd("MicroMsg.Voip.VoipServiceEx", com.tencent.mm.compatible.util.f.YG() + "accept invite, roomid:" + this.Ayh.ABJ.roomId + " nic list size:" + localLinkedList.size());
    this.AFx.au(50000L, 50000L);
    this.Ayh.ABJ.AIf.eiN();
    new b(1, this.Ayh.ABJ.netType, this.Ayh.ABJ.roomId, this.Ayh.ABJ.field_peerId, this.Ayh.ABJ.field_capInfo, this.Ayh.ABJ.tIG, paramBoolean1, paramBoolean2, localLinkedList).ekv();
    this.Ayh.setStatus(4);
    this.Ayh.ABL.osN = 1;
    this.Ayh.dsb = true;
    AppMethodBeat.o(115179);
    return 0;
  }
  
  public final int b(ByteBuffer paramByteBuffer, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    AppMethodBeat.i(208402);
    paramInt1 = this.Ayh.ABL.a(paramByteBuffer, paramInt1, paramInt2, paramInt3, paramInt4);
    AppMethodBeat.o(208402);
    return paramInt1;
  }
  
  public final void b(Context paramContext, x paramx)
  {
    AppMethodBeat.i(208398);
    if ((paramContext != this.Ayh.mHB) || (paramx != this.Ayh.ABK))
    {
      com.tencent.mm.plugin.voip.b.d.Logd("MicroMsg.Voip.VoipServiceEx", "cannot detach other's ui.");
      AppMethodBeat.o(208398);
      return;
    }
    this.Ayh.mHB = null;
    this.Ayh.ABK = x.AFH;
    com.tencent.mm.plugin.voip.b.d.Logd("MicroMsg.Voip.VoipServiceEx", "detach ui........");
    com.tencent.mm.plugin.voip.b.d.flushLogFile();
    AppMethodBeat.o(208398);
  }
  
  public final boolean bVB()
  {
    AppMethodBeat.i(115195);
    if (this.oue != null)
    {
      boolean bool = this.oue.Na();
      AppMethodBeat.o(115195);
      return bool;
    }
    AppMethodBeat.o(115195);
    return true;
  }
  
  public final int c(int paramInt1, long paramLong, int paramInt2)
  {
    AppMethodBeat.i(115177);
    if (!this.Ayh.eil())
    {
      com.tencent.mm.plugin.voip.b.d.Loge("MicroMsg.Voip.VoipServiceEx", "steve:[simucall]Failed to cancel call ,as not in calling.");
      AppMethodBeat.o(115177);
      return -1;
    }
    ac.i("MicroMsg.Voip.VoipServiceEx", "steve:[simucall] try to cancel my invite due to Simulcall(callee), roomId:%s, roomKey:%s, roomType:%d, msgID:%d, inviteId:%d", new Object[] { Integer.valueOf(paramInt1), Long.valueOf(paramLong), Integer.valueOf(paramInt2), Integer.valueOf(this.Ayh.ABJ.AGd), Integer.valueOf(this.Ayh.ABJ.tII) });
    Object localObject1 = this.AFg;
    if (paramInt1 != 0) {}
    try
    {
      if (this.Ayh.ABJ.tII == 0)
      {
        com.tencent.mm.plugin.voip.b.d.Loge("MicroMsg.Voip.VoipServiceEx", "steve:[simucall] Failed to cancel call with roomid = 0 and inviteId = 0 ");
        return -1;
      }
      new com.tencent.mm.plugin.voip.model.a.c(paramInt1, paramLong, this.Ayh.ABJ.fTK, "", this.Ayh.ABJ.tII, 2).ekv();
      com.tencent.mm.plugin.report.service.h.wUl.a(11521, true, true, new Object[] { Integer.valueOf(paramInt1), Long.valueOf(paramLong), Integer.valueOf(paramInt2), Integer.valueOf(2), Long.valueOf(System.currentTimeMillis()), Long.valueOf(System.currentTimeMillis()) });
      ac.i("MicroMsg.Voip.VoipServiceEx", "steve:[simucall] voipcancelinvite sent!");
      return 0;
    }
    finally
    {
      AppMethodBeat.o(115177);
    }
  }
  
  public final int c(byte[] paramArrayOfByte, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    AppMethodBeat.i(208401);
    paramInt1 = this.Ayh.ABL.b(paramArrayOfByte, paramInt1, paramInt2, paramInt3, paramInt4);
    AppMethodBeat.o(208401);
    return paramInt1;
  }
  
  public final int eR(String paramString, int paramInt)
  {
    AppMethodBeat.i(115174);
    ac.i("MicroMsg.Voip.VoipServiceEx", "call username:%s, callType:%d, inviteType:%d", new Object[] { paramString, Integer.valueOf(0), Integer.valueOf(paramInt) });
    if (bs.isNullOrNil(paramString))
    {
      com.tencent.mm.plugin.voip.b.d.Loge("MicroMsg.Voip.VoipServiceEx", "Failed call without valid username.");
      AppMethodBeat.o(115174);
      return -1;
    }
    if (this.Ayh.eil())
    {
      com.tencent.mm.plugin.voip.b.d.Loge("MicroMsg.Voip.VoipServiceEx", "Failed call withing calling.");
      AppMethodBeat.o(115174);
      return -1;
    }
    this.AFs = paramString;
    this.Ayh.ABJ.AGf = 1;
    this.Ayh.ABJ.fTK = paramString;
    com.tencent.mm.plugin.voip.b.d.Logd("MicroMsg.Voip.VoipServiceEx", com.tencent.mm.compatible.util.f.YG() + "call username:" + paramString);
    if (this.Ayh.ABJ.ekM())
    {
      com.tencent.mm.plugin.voip.b.d.Loge("MicroMsg.Voip.VoipServiceEx", com.tencent.mm.compatible.util.f.YG() + "v2protocal already init.");
      this.Ayh.ABJ.sH(false);
      this.Ayh.ABJ.reset();
    }
    if (this.Ayh.ABJ.ebh() < 0)
    {
      com.tencent.mm.plugin.voip.b.d.Loge("MicroMsg.Voip.VoipServiceEx", "Failed to init v2protocol.");
      AppMethodBeat.o(115174);
      return -1;
    }
    if (this.Ayh.ABJ.AIi != null) {
      this.Ayh.ABJ.AIi.Ayh = this.Ayh;
    }
    if (v2protocal.AIj != null) {
      v2protocal.AIj.a(this.Ayh);
    }
    this.AFx.au(50000L, 50000L);
    this.Ayh.ABJ.tII = ((int)System.currentTimeMillis());
    LinkedList localLinkedList = new LinkedList();
    this.Ayh.aW(localLinkedList);
    this.Ayh.ABJ.AGQ = ("invite:" + this.Ayh.ABJ.AGL + ":" + this.Ayh.ABJ.AGM);
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(paramString);
    new com.tencent.mm.plugin.voip.model.a.g(localArrayList, this.Ayh.ABJ.field_peerId, this.Ayh.ABJ.field_capInfo, this.Ayh.ABJ.netType, paramInt, this.Ayh.ABJ.tII, localLinkedList).ekv();
    this.Ayh.setStatus(2);
    this.Ayh.ABL.osN = 1;
    this.AFu.au(60000L, 60000L);
    this.Ayh.ABJ.AIf.ADw = System.currentTimeMillis();
    this.Ayh.ABJ.AIf.beginTime = System.currentTimeMillis();
    this.Ayh.ABJ.AIf.ADc = paramInt;
    ac.d("MicroMsg.Voip.VoipServiceEx", "iRoomType " + this.Ayh.ABJ.AIf.ADc);
    this.Ayh.eiq();
    AppMethodBeat.o(115174);
    return 0;
  }
  
  public final boolean eil()
  {
    AppMethodBeat.i(115170);
    if (this.Ayh.eil())
    {
      AppMethodBeat.o(115170);
      return true;
    }
    AppMethodBeat.o(115170);
    return false;
  }
  
  public final int ejJ()
  {
    AppMethodBeat.i(208400);
    ac.i("MicroMsg.Voip.VoipServiceEx", "hangUpByPhoneInter");
    if (this.Ayh.ABJ.roomId == 0)
    {
      this.Ayh.ABL.eiG();
      reset();
      AppMethodBeat.o(208400);
      return 0;
    }
    this.Ayh.ABJ.AIf.ACR = 109;
    this.Ayh.ABJ.AIf.ADj = 4;
    int i = ekl();
    AppMethodBeat.o(208400);
    return i;
  }
  
  public final int ejK()
  {
    AppMethodBeat.i(115183);
    ac.i("MicroMsg.Voip.VoipServiceEx", "ignoreInvite");
    if (!this.Ayh.eik())
    {
      com.tencent.mm.plugin.voip.b.d.Loge("MicroMsg.Voip.VoipServiceEx", "Failed to ignore with calling, status =" + this.Ayh.mStatus);
      AppMethodBeat.o(115183);
      return -1;
    }
    synchronized (this.AFg)
    {
      if (this.Ayh.ABJ.roomId == 0)
      {
        com.tencent.mm.plugin.voip.b.d.Loge("MicroMsg.Voip.VoipServiceEx", "Failed to reject with roomid = 0. ");
        AppMethodBeat.o(115183);
        return -1;
      }
      int i = this.Ayh.ABJ.netType;
      int j = this.Ayh.ABJ.roomId;
      long l = this.Ayh.ABJ.tIG;
      new b(3, i, j, new byte[0], new byte[0], l, false, false, null).ekv();
      reset();
      this.Ayh.ABJ.roomId = 0;
      AppMethodBeat.o(115183);
      return 0;
    }
  }
  
  public final boolean ekd()
  {
    AppMethodBeat.i(115168);
    ac.i("MicroMsg.Voip.VoipServiceEx", "isRoomReady, roomId: " + this.Ayh.ABJ.roomId);
    if ((this.Ayh.ABJ.roomId != 0) && (!eke()))
    {
      AppMethodBeat.o(115168);
      return true;
    }
    AppMethodBeat.o(115168);
    return false;
  }
  
  public final void ekg()
  {
    AppMethodBeat.i(115172);
    if (this.Ayh.eil()) {
      com.tencent.mm.plugin.voip.b.d.Loge("MicroMsg.Voip.VoipServiceEx", "checkStartup failed, stauts = " + this.Ayh.mStatus);
    }
    com.tencent.mm.plugin.voip.b.d.Loge("MicroMsg.Voip.VoipServiceEx", "checkStartup...devicekey = " + bw.fcC());
    this.Ayh.eig();
    ekc();
    ae.st(com.tencent.mm.kernel.g.agR().agB().fcA());
    AppMethodBeat.o(115172);
  }
  
  public final int ekh()
  {
    AppMethodBeat.i(115175);
    ac.i("MicroMsg.Voip.VoipServiceEx", "cancelCall, roomId:" + this.Ayh.ABJ.roomId);
    if ((this.Ayh.ABJ.roomId == 0) && (this.Ayh.ABJ.tII == 0))
    {
      reset();
      AppMethodBeat.o(115175);
      return -1;
    }
    this.Ayh.ABJ.AIf.ACR = this.Ayh.eii();
    this.Ayh.ABJ.AIf.ADd = 3;
    if (this.Ayh.mStatus < 6) {
      this.Ayh.ABJ.AIf.ADf = 1;
    }
    com.tencent.mm.plugin.report.service.h.wUl.a(11521, true, true, new Object[] { Integer.valueOf(com.tencent.mm.plugin.voip.c.ehb().ejL()), Long.valueOf(com.tencent.mm.plugin.voip.c.ehb().ejM()), Long.valueOf(com.tencent.mm.plugin.voip.c.ehb().eim()), Integer.valueOf(1), Long.valueOf(System.currentTimeMillis()), Long.valueOf(System.currentTimeMillis()) });
    int i = Sy(1);
    AppMethodBeat.o(115175);
    return i;
  }
  
  public final int eki()
  {
    AppMethodBeat.i(208399);
    ac.i("MicroMsg.Voip.VoipServiceEx", "cancelCallByPhoneInter, roomId:" + this.Ayh.ABJ.roomId);
    if (this.Ayh.ABJ.roomId == 0)
    {
      AppMethodBeat.o(208399);
      return -1;
    }
    this.Ayh.ABJ.AIf.ACR = 102;
    this.Ayh.ABJ.AIf.ADd = 6;
    if (com.tencent.mm.plugin.voip.c.ehb().AEG != null)
    {
      this.Ayh.ABJ.AIf.ADC = com.tencent.mm.plugin.voip.c.ehb().AEG.egZ();
      this.Ayh.ABJ.AIf.AAo = (com.tencent.mm.plugin.voip.c.ehb().AEG.egX() / 1000L);
      this.Ayh.ABJ.AIf.AAp = (com.tencent.mm.plugin.voip.c.ehb().AEG.egY() / 1000L);
    }
    com.tencent.mm.plugin.report.service.h.wUl.a(11521, true, true, new Object[] { Integer.valueOf(com.tencent.mm.plugin.voip.c.ehb().ejL()), Long.valueOf(com.tencent.mm.plugin.voip.c.ehb().ejM()), Long.valueOf(com.tencent.mm.plugin.voip.c.ehb().eim()), Integer.valueOf(3), Long.valueOf(System.currentTimeMillis()), Long.valueOf(System.currentTimeMillis()) });
    int i = Sy(3);
    AppMethodBeat.o(208399);
    return i;
  }
  
  public final int ekj()
  {
    AppMethodBeat.i(115180);
    ac.i("MicroMsg.Voip.VoipServiceEx", "reject");
    if (!this.Ayh.eik())
    {
      com.tencent.mm.plugin.voip.b.d.Loge("MicroMsg.Voip.VoipServiceEx", "Failed to reject with calling, status =" + this.Ayh.mStatus);
      AppMethodBeat.o(115180);
      return -1;
    }
    synchronized (this.AFg)
    {
      if (this.Ayh.ABJ.roomId == 0)
      {
        com.tencent.mm.plugin.voip.b.d.Loge("MicroMsg.Voip.VoipServiceEx", "Failed to reject with roomid = 0. ");
        AppMethodBeat.o(115180);
        return -1;
      }
      this.Ayh.ABJ.AIf.eiN();
      com.tencent.mm.plugin.voip.b.d.Logd("MicroMsg.Voip.VoipServiceEx", " reject, status:" + this.Ayh.mStatus + " roomid:" + this.Ayh.ABJ.roomId);
      int i = this.Ayh.ABJ.netType;
      int j = this.Ayh.ABJ.roomId;
      long l = this.Ayh.ABJ.tIG;
      new b(2, i, j, new byte[0], new byte[0], l, false, false, null).ekv();
      if ((this.Ayh.ABJ.AGx == 0) && (this.Ayh.ABJ.AGy == 0)) {
        this.Ayh.eih();
      }
      this.Ayh.Sk(this.oue.emJ());
      this.Ayh.ABJ.AIf.ADB = this.Ayh.ABK.ehN();
      if (com.tencent.mm.plugin.voip.c.ehb().AEG != null)
      {
        this.Ayh.ABJ.AIf.ADC = com.tencent.mm.plugin.voip.c.ehb().AEG.egZ();
        this.Ayh.ABJ.AIf.AAo = (com.tencent.mm.plugin.voip.c.ehb().AEG.egX() / 1000L);
        this.Ayh.ABJ.AIf.AAp = (com.tencent.mm.plugin.voip.c.ehb().AEG.egY() / 1000L);
      }
      if (this.Ayh.ABJ.ekM()) {
        this.Ayh.ABJ.sH(true);
      }
      String str1 = v2protocal.ekP();
      String str2 = this.Ayh.ABJ.ekQ();
      String str3 = this.Ayh.ABJ.ekV();
      String str4 = this.Ayh.ABJ.ekI();
      String str5 = this.Ayh.ABJ.ekK();
      String[] arrayOfString1 = this.Ayh.ABJ.ekR();
      String[] arrayOfString2 = this.Ayh.ABJ.ekS();
      String[] arrayOfString3 = this.Ayh.ABJ.ekT();
      String[] arrayOfString4 = this.Ayh.ABJ.ekU();
      com.tencent.mm.plugin.voip.b.d.Logd("MicroMsg.Voip.VoipServiceEx", "devin: statreport");
      if (str2.length() > 0)
      {
        com.tencent.mm.plugin.voip.b.d.Logd("MicroMsg.Voip.VoipServiceEx", "devin: reject() newdialInfo.length() > 0");
        new com.tencent.mm.plugin.voip.model.a.l(str1, str2, str4, str3, str5, arrayOfString1, arrayOfString2, arrayOfString3, arrayOfString4).ekv();
        this.Ayh.eif();
        reset();
        this.Ayh.ABJ.roomId = 0;
        AppMethodBeat.o(115180);
        return 0;
      }
      com.tencent.mm.plugin.voip.b.d.Logd("MicroMsg.Voip.VoipServiceEx", "devin: reject() newdialInfo.length() <= 0");
    }
  }
  
  public final int ekk()
  {
    AppMethodBeat.i(115181);
    ac.i("MicroMsg.Voip.VoipServiceEx", "hangUp");
    if (this.Ayh.ABJ.roomId == 0)
    {
      this.Ayh.ABL.eiG();
      this.Ayh.eir();
      reset();
      AppMethodBeat.o(115181);
      return 0;
    }
    this.Ayh.ABJ.AIf.ACR = this.Ayh.eii();
    int i = ekl();
    AppMethodBeat.o(115181);
    return i;
  }
  
  public final int ekl()
  {
    AppMethodBeat.i(115182);
    com.tencent.mm.plugin.voip.b.d.Logi("MicroMsg.Voip.VoipServiceEx", "hangUp,status:" + this.Ayh.mStatus + " roomid:" + this.Ayh.ABJ.roomId + ",threadid = " + Thread.currentThread().getId());
    this.Ayh.ABL.eiG();
    this.Ayh.eir();
    if (this.Ayh.ABJ.AIf.ADb == 1)
    {
      ??? = this.Ayh.ABJ.AIf;
      if (((o)???).ADs != 0L) {
        break label623;
      }
      ((o)???).ADl = 0;
    }
    for (;;)
    {
      if (((o)???).ADl < 0)
      {
        ((o)???).ADl = 0;
        com.tencent.mm.plugin.voip.b.d.Loge("MicroMsg.VoipDailReport", "devin:endTalk, iCallTime Err, rest 0");
      }
      com.tencent.mm.plugin.voip.b.d.Logi("MicroMsg.VoipDailReport", "devin:endTalk:" + ((o)???).ADl);
      synchronized (this.AFg)
      {
        int i = this.Ayh.ABJ.AIf.ADd;
        if ((this.Ayh.ABJ.roomId != 0) || (8 == i) || (9 == i) || (10 == i) || (11 == i) || (12 == i) || (99 == i))
        {
          com.tencent.mm.plugin.voip.b.d.Logi("MicroMsg.Voip.VoipServiceEx", "steve:hangUp, uninitGLRender before protocalUninit first!!");
          if (this.Ayh.ABJ.ekM())
          {
            this.Ayh.ABJ.sH(true);
            new com.tencent.mm.plugin.voip.model.a.i(this.Ayh.ABJ.roomId, this.Ayh.ABJ.tIG, "").ekv();
            com.tencent.mm.plugin.voip.b.d.Loge("MicroMsg.Voip.VoipServiceEx", "devin: shutdown cgi ");
          }
          this.Ayh.ABJ.AIf.ADB = this.Ayh.ABK.ehN();
          if (com.tencent.mm.plugin.voip.c.ehb().AEG != null)
          {
            this.Ayh.ABJ.AIf.ADC = com.tencent.mm.plugin.voip.c.ehb().AEG.egZ();
            this.Ayh.ABJ.AIf.AAo = (com.tencent.mm.plugin.voip.c.ehb().AEG.egX() / 1000L);
            this.Ayh.ABJ.AIf.AAp = (com.tencent.mm.plugin.voip.c.ehb().AEG.egY() / 1000L);
          }
          this.Ayh.Sk(this.oue.emJ());
          String str1 = v2protocal.ekP();
          String str2 = this.Ayh.ABJ.ekQ();
          String str3 = this.Ayh.ABJ.ekV();
          String str4 = this.Ayh.ABJ.ekI();
          String str5 = this.Ayh.ABJ.ekK();
          String[] arrayOfString1 = this.Ayh.ABJ.ekR();
          String[] arrayOfString2 = this.Ayh.ABJ.ekS();
          String[] arrayOfString3 = this.Ayh.ABJ.ekT();
          String[] arrayOfString4 = this.Ayh.ABJ.ekU();
          if (str2.length() > 0)
          {
            new com.tencent.mm.plugin.voip.model.a.l(str1, str2, str4, str3, str5, arrayOfString1, arrayOfString2, arrayOfString3, arrayOfString4).ekv();
            com.tencent.mm.plugin.voip.b.d.Loge("MicroMsg.Voip.VoipServiceEx", "devin: statreport cgi ");
          }
          this.Ayh.eif();
          reset();
          this.Ayh.ABJ.roomId = 0;
          com.tencent.mm.plugin.voip.b.d.Logd("MicroMsg.Voip.VoipServiceEx", "hangUp over");
          AppMethodBeat.o(115182);
          return 0;
          label623:
          ((o)???).ADl = ((int)((System.currentTimeMillis() - ((o)???).ADs) / 1000L));
          continue;
        }
        com.tencent.mm.plugin.voip.b.d.Loge("MicroMsg.Voip.VoipServiceEx", "call hangUp roomId == 0 ");
      }
    }
  }
  
  public final void ekm()
  {
    AppMethodBeat.i(115185);
    LinkedList localLinkedList = new LinkedList();
    this.Ayh.ABJ.aX(localLinkedList);
    int j = 0;
    int m = 0;
    int n;
    for (int i = 0; j < localLinkedList.size(); i = n)
    {
      int k = m;
      if (((bxf)localLinkedList.get(j)).Fmb == 5) {
        k = m + 1;
      }
      n = i;
      if (((bxf)localLinkedList.get(j)).Fmb == 4) {
        n = i + 1;
      }
      j += 1;
      m = k;
    }
    this.Ayh.ABJ.AGQ = (this.Ayh.ABJ.AGQ + "|redirect:" + i + ":" + m);
    new com.tencent.mm.plugin.voip.model.a.h(this.Ayh.ABJ.roomId, this.Ayh.ABJ.tIG, this.Ayh.ABJ.tIN, 0, 0, null, localLinkedList).ekv();
    AppMethodBeat.o(115185);
  }
  
  public final void ekn()
  {
    AppMethodBeat.i(115193);
    if (this.oue != null) {
      this.oue.a(2131691389, false, 0, false);
    }
    AppMethodBeat.o(115193);
  }
  
  public final void eko()
  {
    AppMethodBeat.i(115197);
    if (this.AFu != null)
    {
      com.tencent.mm.plugin.voip.b.d.Logi("MicroMsg.Voip.VoipServiceEx", "devincdai: voip reset timecount");
      this.AFu.stopTimer();
      this.AFu.au(60000L, 60000L);
    }
    AppMethodBeat.o(115197);
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
    paramInt1 = this.Ayh.ABJ.setNetSignalValue(paramInt1, paramInt2);
    AppMethodBeat.o(115186);
    return paramInt1;
  }
  
  public final void stop()
  {
    AppMethodBeat.i(115163);
    ac.i("MicroMsg.Voip.VoipServiceEx", "stop");
    reset();
    this.Ayh.a(null);
    AppMethodBeat.o(115163);
  }
  
  public final void stopRing()
  {
    AppMethodBeat.i(115194);
    if (this.oue != null) {
      this.oue.stop();
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
        v.SB(WifiManager.calculateSignalLevel(v.h(v.this).getRssi(), 10));
        if (v.bEL() > 10)
        {
          v.SB(i);
          if (v.bEL() >= 0) {
            break label180;
          }
          i = 0;
          label117:
          v.SB(i);
          v.SB(v.bEL() * 10);
        }
      }
      for (;;)
      {
        if (v.bEL() != -1) {
          break label195;
        }
        if (v.i(v.this) <= 1) {
          v.SA(-1);
        }
        v.this.setNetSignalValue(1, v.AFi);
        AppMethodBeat.o(115161);
        return;
        i = v.bEL();
        break;
        label180:
        i = v.bEL();
        break label117;
        v.SB(-1);
      }
      label195:
      v.this.setNetSignalValue(2, v.bEL());
      AppMethodBeat.o(115161);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.voip.model.v
 * JD-Core Version:    0.7.0.1
 */