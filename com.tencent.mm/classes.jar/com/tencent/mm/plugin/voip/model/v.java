package com.tencent.mm.plugin.voip.model;

import android.content.Context;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import android.os.Looper;
import android.telephony.PhoneStateListener;
import android.telephony.SignalStrength;
import android.telephony.TelephonyManager;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.deviceinfo.ae;
import com.tencent.mm.kernel.e;
import com.tencent.mm.plugin.voip.model.a.b;
import com.tencent.mm.plugin.voip.model.a.h;
import com.tencent.mm.protocal.protobuf.cbv;
import com.tencent.mm.protocal.protobuf.dxv;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.sdk.platformtools.av;
import com.tencent.mm.sdk.platformtools.av.a;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.storage.bu;
import com.tencent.mm.storage.cc;
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
  private static int Cei = -1;
  private static int Cej = 20;
  private static int kGT = -1;
  public l BXC;
  private Object Ceg;
  private int Ceh;
  public String Cek;
  private int Cel;
  ScheduledExecutorService Cem;
  ScheduledFuture<?> Cen;
  private WifiInfo Ceo;
  public boolean Cep;
  public int Ceq;
  public boolean Cer;
  public String Ces;
  private a Cet;
  private av Ceu;
  private byte[] Cev;
  av Cew;
  private av Cex;
  private av Cey;
  private WifiManager cde;
  com.tencent.mm.plugin.voip.video.i oXA;
  
  public v()
  {
    AppMethodBeat.i(115162);
    this.Ceg = new Object();
    this.Ceh = 0;
    this.Cem = Executors.newScheduledThreadPool(1);
    this.Cep = false;
    this.Ceq = 0;
    this.Cer = false;
    this.Ces = null;
    this.Ceu = new av(Looper.getMainLooper(), new av.a()
    {
      public final boolean onTimerExpired()
      {
        AppMethodBeat.i(115156);
        if ((v.this.BXC.CaI.Cff == 1) && (v.this.BXC.evU()))
        {
          com.tencent.mm.plugin.voip.b.f.Logi("MicroMsg.Voip.VoipServiceEx", "call timeout!");
          v.this.BXC.CaI.Chg.CbS = 101;
          com.tencent.mm.plugin.report.service.g.yhR.f(11521, new Object[] { Integer.valueOf(com.tencent.mm.plugin.voip.c.euM().exw()), Long.valueOf(com.tencent.mm.plugin.voip.c.euM().exx()), Long.valueOf(com.tencent.mm.plugin.voip.c.euM().evX()), Integer.valueOf(4), Long.valueOf(System.currentTimeMillis()), Long.valueOf(System.currentTimeMillis()) });
          v.this.Uq(4);
          v.this.BXC.CaJ.evu();
        }
        AppMethodBeat.o(115156);
        return false;
      }
    }, false);
    this.Cev = new byte[500];
    this.Cew = new av(Looper.getMainLooper(), new av.a()
    {
      public final boolean onTimerExpired()
      {
        AppMethodBeat.i(115157);
        Object localObject = v.this.BXC;
        ((l)localObject).CaQ += 1;
        if (v.this.BXC.CaI.roomId == 0)
        {
          com.tencent.mm.plugin.voip.b.f.Loge("MicroMsg.Voip.VoipServiceEx", com.tencent.mm.compatible.util.f.abi() + "double link switch roomId == 0 ");
          v.a(v.this).stopTimer();
        }
        for (;;)
        {
          AppMethodBeat.o(115157);
          return true;
          v.this.BXC.CaI.app2EngineDataEx(v.this.BXC.CaI.Cgy, v.this.BXC.CaI.Cgz, v.this.BXC.CaI.CgA, 0, 0);
          if ((!v.this.BXC.CaP) && (1 == v.this.BXC.CaI.field_mGetValidSample))
          {
            v.this.BXC.CaP = true;
            v.this.BXC.CaR = v.this.BXC.CaQ;
          }
          if (1 == v.this.BXC.Cav) {
            v.this.BXC.Cav = 15;
          }
          if ((true == v.this.BXC.CaP) && (v.this.BXC.CaQ - v.this.BXC.CaR == v.this.BXC.Cav) && ((v.this.BXC.CaI.Cgp & 0x1) == 0))
          {
            v.this.BXC.CaR = v.this.BXC.CaQ;
            int i = v.this.BXC.CaI.isDCSameLan();
            int k = v.this.BXC.CaI.getCurrentConnType();
            if ((1 == i) && (1 == k))
            {
              com.tencent.mm.plugin.voip.b.f.Logi("MicroMsg.Voip.VoipServiceEx", "zhengxue[DOUBLELINK]  In the Same LAN, isDCSameLan = ".concat(String.valueOf(i)));
              localObject = v.this.BXC;
              ((l)localObject).CaQ += 1;
              AppMethodBeat.o(115157);
              return true;
            }
            int m = v.this.BXC.CaI.getcurstrategy();
            int n = v.this.BXC.CaI.isRelayConnReady();
            int i1 = v.this.BXC.CaI.isDCReady();
            int j = v.this.BXC.Cav - 3;
            i = j;
            if (j > 15) {
              i = 15;
            }
            v.this.BXC.CaI.app2EngineLinkQualityEx(i, v.b(v.this));
            new com.tencent.mm.plugin.voip.model.a.d(v.this.BXC.CaI.roomId, v.this.BXC.CaI.uLt, v.this.BXC.CaI.uLA, k, n, i1, m, v.b(v.this), v.this.BXC.CaI.field_realLinkQualityInfoBuffLen).eyg();
            localObject = v.this.BXC.CaI;
            ((v2protocal)localObject).Cgr += 1;
            com.tencent.mm.plugin.voip.b.f.Logi("MicroMsg.Voip.VoipServiceEx", "zhengxue[DOUBLELINK]  doubleLinkSwitchReportStatus " + v.this.BXC.Cav + " isFirstValidSampleSet " + v.this.BXC.CaP + " mGetValidSample " + v.this.BXC.CaI.field_mGetValidSample + "mDoubleLinkSwitchReqCnt " + v.this.BXC.CaI.Cgr + "mTimerCounter " + v.this.BXC.CaQ + "mLastSwitchTimer " + v.this.BXC.CaR);
          }
        }
      }
    }, true);
    this.Cex = new av(Looper.getMainLooper(), new av.a()
    {
      public final boolean onTimerExpired()
      {
        AppMethodBeat.i(115158);
        if (v.this.BXC.CaI.roomId == 0)
        {
          com.tencent.mm.plugin.voip.b.f.Loge("MicroMsg.Voip.VoipServiceEx", com.tencent.mm.compatible.util.f.abi() + " roomId == 0 ");
          v.c(v.this).stopTimer();
        }
        label136:
        for (;;)
        {
          AppMethodBeat.o(115158);
          return true;
          if (v.this.BXC.mStatus >= 5) {}
          for (int i = 1;; i = 0)
          {
            if (i == 0) {
              break label136;
            }
            new com.tencent.mm.plugin.voip.model.a.f(v.this.BXC.CaI.roomId, v.this.BXC.CaI.uLt, v.this.BXC.Cba).eyg();
            break;
          }
        }
      }
    }, true);
    this.Cey = new av(Looper.getMainLooper(), new av.a()
    {
      public final boolean onTimerExpired()
      {
        AppMethodBeat.i(115159);
        ad.i("MicroMsg.Voip.VoipServiceEx", "voip called out of time,now destroy...");
        if ((3 == v.this.BXC.mStatus) && (v.d(v.this) != 0) && (v.d(v.this) == v.this.BXC.CaI.roomId))
        {
          v.e(v.this);
          v.this.BXC.J(5, -9000, "");
        }
        AppMethodBeat.o(115159);
        return false;
      }
    }, true);
    this.BXC = m.ewp();
    this.BXC.a(this);
    this.oXA = new com.tencent.mm.plugin.voip.video.i(aj.getContext());
    this.Cep = false;
    this.Ceq = 0;
    this.Cer = false;
    this.Ces = null;
    AppMethodBeat.o(115162);
  }
  
  private void exN()
  {
    AppMethodBeat.i(115166);
    ad.d("MicroMsg.Voip.VoipServiceEx", "reset");
    this.Cex.stopTimer();
    this.Ceu.stopTimer();
    this.Cew.stopTimer();
    this.Cey.stopTimer();
    this.Ceh = 0;
    AppMethodBeat.o(115166);
  }
  
  private boolean exP()
  {
    AppMethodBeat.i(115169);
    boolean bool = false;
    if (this.BXC != null) {
      bool = this.BXC.evU();
    }
    AppMethodBeat.o(115169);
    return bool;
  }
  
  public static boolean exQ()
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
  
  private void eya()
  {
    AppMethodBeat.i(216440);
    final TelephonyManager localTelephonyManager = (TelephonyManager)aj.getContext().getSystemService("phone");
    if (localTelephonyManager != null) {
      localTelephonyManager.listen(new PhoneStateListener()
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
              v.Us(bt.getInt(arrayOfString[9], -141) + 140);
            }
            v.this.Cek = "LTE";
            if (v.Cei <= 100) {
              break label156;
            }
            label85:
            v.Us(i);
            if (v.Cei >= 0) {
              break label163;
            }
          }
          label156:
          label163:
          for (i = 0;; i = v.Cei)
          {
            v.Us(i);
            v.f(v.this);
            AppMethodBeat.o(115160);
            return;
            int j = paramAnonymousSignalStrength.getGsmSignalStrength();
            if ((paramAnonymousSignalStrength.isGsm()) && (j == 99))
            {
              v.Us(-1);
              break;
            }
            v.Us((int)(j * 3.225807F));
            break;
            i = v.Cei;
            break label85;
          }
        }
      }, 256);
    }
    AppMethodBeat.o(216440);
  }
  
  private void eyb()
  {
    AppMethodBeat.i(216441);
    this.cde = ((WifiManager)aj.getContext().getApplicationContext().getSystemService("wifi"));
    if (this.Cet != null) {
      this.Cet.cancel();
    }
    this.Cet = new a();
    this.Cen = this.Cem.scheduleAtFixedRate(this.Cet, 0L, Cej, TimeUnit.SECONDS);
    AppMethodBeat.o(216441);
  }
  
  private void reset()
  {
    AppMethodBeat.i(115165);
    ad.d("MicroMsg.Voip.VoipServiceEx", "reset");
    this.BXC.reset();
    this.Cex.stopTimer();
    this.Ceu.stopTimer();
    this.Cew.stopTimer();
    this.Cey.stopTimer();
    if (this.Cet != null) {
      this.Cet.cancel();
    }
    if (this.Cen != null)
    {
      this.Cen.cancel(false);
      this.Cen = null;
    }
    this.Ceh = 0;
    com.tencent.mm.plugin.voip.c.euM().aKp();
    com.tencent.mm.plugin.voip.c.euM().BZf = null;
    this.Cep = false;
    this.Ceq = 0;
    this.Cer = false;
    this.Ces = null;
    AppMethodBeat.o(115165);
  }
  
  public final void J(int paramInt1, int paramInt2, String paramString)
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
      exW();
      this.BXC.CaJ.onReject();
      AppMethodBeat.o(115173);
      return;
      exW();
      this.BXC.CaJ.evu();
      AppMethodBeat.o(115173);
      return;
      exW();
      this.BXC.CaJ.evw();
      AppMethodBeat.o(115173);
      return;
      exW();
      this.BXC.CaJ.onError(paramInt2, paramString);
    }
  }
  
  public final void Ue(int paramInt)
  {
    AppMethodBeat.i(115187);
    this.BXC.Ue(paramInt);
    AppMethodBeat.o(115187);
  }
  
  public final void Um(int paramInt)
  {
    AppMethodBeat.i(115167);
    this.BXC.Ua(paramInt);
    AppMethodBeat.o(115167);
  }
  
  public final void Up(int paramInt)
  {
    AppMethodBeat.i(216442);
    this.cde = null;
    this.Ceo = null;
    this.Cel = 0;
    if (paramInt > 0) {
      Cej = paramInt;
    }
    eyb();
    eya();
    AppMethodBeat.o(216442);
  }
  
  public final int Uq(int paramInt)
  {
    AppMethodBeat.i(115176);
    if (!this.BXC.evW())
    {
      com.tencent.mm.plugin.voip.b.f.Loge("MicroMsg.Voip.VoipServiceEx", "Failed to cancel call ,as not in calling.");
      AppMethodBeat.o(115176);
      return -1;
    }
    ad.i("MicroMsg.Voip.VoipServiceEx", "cancelCallEx, roomId:%d, msgID:%d, inviteId:%d, cancelType:%d", new Object[] { Integer.valueOf(this.BXC.CaI.roomId), Integer.valueOf(this.BXC.CaI.Cfd), Integer.valueOf(this.BXC.CaI.uLv), Integer.valueOf(paramInt) });
    synchronized (this.Ceg)
    {
      if ((this.BXC.CaI.roomId == 0) && (this.BXC.CaI.uLv == 0))
      {
        com.tencent.mm.plugin.voip.b.f.Loge("MicroMsg.Voip.VoipServiceEx", "Failed to cancel call with roomid = 0 and inviteId = 0 ");
        AppMethodBeat.o(115176);
        return -1;
      }
      if (this.BXC.CaI.eyx())
      {
        this.BXC.CaI.tq(true);
        new com.tencent.mm.plugin.voip.model.a.c(this.BXC.CaI.roomId, this.BXC.CaI.uLt, this.BXC.CaI.gno, "", this.BXC.CaI.uLv, paramInt).eyg();
      }
      Object localObject2 = this.BXC.CaI.Chg;
      ((o)localObject2).Ccn = ((int)(System.currentTimeMillis() - ((o)localObject2).Ccx));
      com.tencent.mm.plugin.voip.b.f.Logd("MicroMsg.VoipDailReport", "devin:cancelInvite:" + ((o)localObject2).Ccn);
      if ((this.BXC.CaI.Cfx == 0) && (this.BXC.CaI.Cfy == 0)) {
        this.BXC.evS();
      }
      this.BXC.Uc(this.oXA.eAH());
      this.BXC.CaI.Chg.CcC = this.BXC.CaJ.evy();
      if (com.tencent.mm.plugin.voip.c.euM().CdG != null)
      {
        this.BXC.CaI.Chg.CcD = com.tencent.mm.plugin.voip.c.euM().CdG.euK();
        this.BXC.CaI.Chg.BZo = (com.tencent.mm.plugin.voip.c.euM().CdG.euI() / 1000L);
        this.BXC.CaI.Chg.BZp = (com.tencent.mm.plugin.voip.c.euM().CdG.euJ() / 1000L);
      }
      localObject2 = v2protocal.eyA();
      String str1 = this.BXC.CaI.eyB();
      String str2 = this.BXC.CaI.eyG();
      String str3 = this.BXC.CaI.eyt();
      String str4 = this.BXC.CaI.eyv();
      String[] arrayOfString1 = this.BXC.CaI.eyC();
      String[] arrayOfString2 = this.BXC.CaI.eyD();
      String[] arrayOfString3 = this.BXC.CaI.eyE();
      String[] arrayOfString4 = this.BXC.CaI.eyF();
      if (str1.length() > 0) {
        new com.tencent.mm.plugin.voip.model.a.l((String)localObject2, str1, str3, str2, str4, arrayOfString1, arrayOfString2, arrayOfString3, arrayOfString4).eyg();
      }
      this.BXC.evQ();
      reset();
      this.BXC.CaI.roomId = 0;
      this.BXC.CaI.uLv = 0;
      AppMethodBeat.o(115176);
      return 0;
    }
  }
  
  public final void Ur(int paramInt)
  {
    AppMethodBeat.i(115196);
    this.Ceh = paramInt;
    if (!this.Cey.fkZ()) {
      this.Cey.stopTimer();
    }
    this.Cey.az(70000L, 70000L);
    AppMethodBeat.o(115196);
  }
  
  public final void a(int paramInt1, long paramLong, int paramInt2, byte[] paramArrayOfByte1, byte[] paramArrayOfByte2, String paramString)
  {
    AppMethodBeat.i(115184);
    com.tencent.mm.plugin.voip.b.f.Logi("MicroMsg.Voip.VoipServiceEx", "doAck roomId " + paramInt1 + "  roomKey " + paramLong + " status " + paramInt2);
    if ((paramInt1 != 0) && (paramLong != 0L))
    {
      LinkedList localLinkedList = new LinkedList();
      this.BXC.aX(localLinkedList);
      this.BXC.CaI.CfR = ("ack:" + this.BXC.CaI.CfM + ":" + this.BXC.CaI.CfN);
      new com.tencent.mm.plugin.voip.model.a.a(paramInt1, paramLong, paramInt2, paramArrayOfByte1, paramArrayOfByte2, paramString, localLinkedList).eyg();
    }
    this.BXC.ewb();
    AppMethodBeat.o(115184);
  }
  
  public final void a(Context paramContext, x paramx)
  {
    AppMethodBeat.i(216434);
    this.BXC.nhZ = paramContext;
    this.BXC.CaJ = paramx;
    com.tencent.mm.plugin.voip.b.f.Logd("MicroMsg.Voip.VoipServiceEx", "attach ui........");
    com.tencent.mm.plugin.voip.b.f.ezD();
    AppMethodBeat.o(216434);
  }
  
  public final boolean a(dxv paramdxv)
  {
    int i = 1;
    AppMethodBeat.i(115178);
    if (this.BXC.evW())
    {
      com.tencent.mm.plugin.voip.b.f.Loge("MicroMsg.Voip.VoipServiceEx", "Failed to setInviteContent during calling, status =" + this.BXC.mStatus);
      AppMethodBeat.o(115178);
      return false;
    }
    if (paramdxv == null)
    {
      AppMethodBeat.o(115178);
      return false;
    }
    this.BXC.CaI.Chg.Ccd = paramdxv.HKd;
    ad.d("MicroMsg.Voip.VoipServiceEx", "iRoomType " + this.BXC.CaI.Chg.Ccd);
    if (this.BXC.CaI.eyx())
    {
      com.tencent.mm.plugin.voip.b.f.Logw("MicroMsg.Voip.VoipServiceEx", com.tencent.mm.compatible.util.f.abi() + "v2protocal already init.");
      this.BXC.CaI.tq(false);
      this.BXC.CaI.reset();
    }
    this.BXC.a(paramdxv);
    if ((com.tencent.mm.plugin.voip.b.n.eAe()) || (com.tencent.mm.s.a.adC()) || (com.tencent.mm.plugin.voip.b.n.eAg()) || (com.tencent.mm.s.a.adD()))
    {
      ad.e("MicroMsg.Voip.VoipServiceEx", "setInviteContent, reject, pstn/multitak/f2f talking");
      if ((com.tencent.mm.plugin.voip.b.n.eAe()) || (com.tencent.mm.s.a.adD()))
      {
        a(paramdxv.GeI, paramdxv.GeJ, 2, null, null, paramdxv.HKm);
        AppMethodBeat.o(115178);
        return false;
      }
      exU();
      label271:
      String str;
      if (paramdxv.HKd == 0)
      {
        str = paramdxv.HKm;
        if (i == 0) {
          break label310;
        }
      }
      label310:
      for (paramdxv = bu.IMe;; paramdxv = bu.IMd)
      {
        s.c(str, paramdxv, 0, 6, aj.getContext().getString(2131764807));
        break;
        i = 0;
        break label271;
      }
    }
    if (this.BXC.CaI.eny() < 0)
    {
      com.tencent.mm.plugin.voip.b.f.Loge("MicroMsg.Voip.VoipServiceEx", "Failed to init v2protocol.");
      AppMethodBeat.o(115178);
      return false;
    }
    if (v2protocal.Chk != null) {
      v2protocal.Chk.a(this.BXC);
    }
    com.tencent.mm.plugin.report.service.g.yhR.a(11524, true, true, new Object[] { Integer.valueOf(paramdxv.GeI), Long.valueOf(paramdxv.GeJ), Integer.valueOf(paramdxv.HKd), Integer.valueOf(0), Long.valueOf(System.currentTimeMillis()) });
    if (!this.Cep) {
      this.BXC.CaJ.evr();
    }
    AppMethodBeat.o(115178);
    return true;
  }
  
  public final int aw(boolean paramBoolean1, boolean paramBoolean2)
  {
    AppMethodBeat.i(115179);
    exZ();
    if (!this.Cey.fkZ()) {
      this.Cey.stopTimer();
    }
    this.BXC.CaI.Chg.ewx();
    ad.i("MicroMsg.Voip.VoipServiceEx", "accept onlyAudio:".concat(String.valueOf(paramBoolean1)));
    if (!this.BXC.evV())
    {
      com.tencent.mm.plugin.voip.b.f.Loge("MicroMsg.Voip.VoipServiceEx", "Failed to accept with calling, status =" + this.BXC.mStatus);
      AppMethodBeat.o(115179);
      return -1;
    }
    if (this.BXC.CaI.roomId == 0)
    {
      com.tencent.mm.plugin.voip.b.f.Loge("MicroMsg.Voip.VoipServiceEx", "Failed to accept with roomid = 0. ");
      AppMethodBeat.o(115179);
      return -1;
    }
    LinkedList localLinkedList = new LinkedList();
    this.BXC.aX(localLinkedList);
    this.BXC.CaI.CfR = (this.BXC.CaI.CfR + "|answer:" + this.BXC.CaI.CfM + ":" + this.BXC.CaI.CfN);
    com.tencent.mm.plugin.voip.b.f.Logd("MicroMsg.Voip.VoipServiceEx", com.tencent.mm.compatible.util.f.abi() + "accept invite, roomid:" + this.BXC.CaI.roomId + " nic list size:" + localLinkedList.size());
    this.Cex.az(50000L, 50000L);
    this.BXC.CaI.Chg.ewy();
    new b(1, this.BXC.CaI.netType, this.BXC.CaI.roomId, this.BXC.CaI.field_peerId, this.BXC.CaI.field_capInfo, this.BXC.CaI.uLt, paramBoolean1, paramBoolean2, localLinkedList).eyg();
    this.BXC.setStatus(4);
    this.BXC.CaK.oWj = 1;
    this.BXC.dDV = true;
    AppMethodBeat.o(115179);
    return 0;
  }
  
  public final void b(Context paramContext, x paramx)
  {
    AppMethodBeat.i(216435);
    if ((paramContext != this.BXC.nhZ) || (paramx != this.BXC.CaJ))
    {
      com.tencent.mm.plugin.voip.b.f.Logd("MicroMsg.Voip.VoipServiceEx", "cannot detach other's ui.");
      AppMethodBeat.o(216435);
      return;
    }
    this.BXC.nhZ = null;
    this.BXC.CaJ = x.CeH;
    com.tencent.mm.plugin.voip.b.f.Logd("MicroMsg.Voip.VoipServiceEx", "detach ui........");
    com.tencent.mm.plugin.voip.b.f.flushLogFile();
    AppMethodBeat.o(216435);
  }
  
  public final int c(int paramInt1, long paramLong, int paramInt2)
  {
    AppMethodBeat.i(115177);
    if (!this.BXC.evW())
    {
      com.tencent.mm.plugin.voip.b.f.Loge("MicroMsg.Voip.VoipServiceEx", "steve:[simucall]Failed to cancel call ,as not in calling.");
      AppMethodBeat.o(115177);
      return -1;
    }
    ad.i("MicroMsg.Voip.VoipServiceEx", "steve:[simucall] try to cancel my invite due to Simulcall(callee), roomId:%s, roomKey:%s, roomType:%d, msgID:%d, inviteId:%d", new Object[] { Integer.valueOf(paramInt1), Long.valueOf(paramLong), Integer.valueOf(paramInt2), Integer.valueOf(this.BXC.CaI.Cfd), Integer.valueOf(this.BXC.CaI.uLv) });
    Object localObject1 = this.Ceg;
    if (paramInt1 != 0) {}
    try
    {
      if (this.BXC.CaI.uLv == 0)
      {
        com.tencent.mm.plugin.voip.b.f.Loge("MicroMsg.Voip.VoipServiceEx", "steve:[simucall] Failed to cancel call with roomid = 0 and inviteId = 0 ");
        return -1;
      }
      new com.tencent.mm.plugin.voip.model.a.c(paramInt1, paramLong, this.BXC.CaI.gno, "", this.BXC.CaI.uLv, 2).eyg();
      com.tencent.mm.plugin.report.service.g.yhR.a(11521, true, true, new Object[] { Integer.valueOf(paramInt1), Long.valueOf(paramLong), Integer.valueOf(paramInt2), Integer.valueOf(2), Long.valueOf(System.currentTimeMillis()), Long.valueOf(System.currentTimeMillis()) });
      ad.i("MicroMsg.Voip.VoipServiceEx", "steve:[simucall] voipcancelinvite sent!");
      return 0;
    }
    finally
    {
      AppMethodBeat.o(115177);
    }
  }
  
  public final int c(ByteBuffer paramByteBuffer, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5)
  {
    AppMethodBeat.i(216439);
    paramInt1 = this.BXC.CaK.b(paramByteBuffer, paramInt1, paramInt2, paramInt3, paramInt4, paramInt5);
    AppMethodBeat.o(216439);
    return paramInt1;
  }
  
  public final int c(byte[] paramArrayOfByte, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    AppMethodBeat.i(216438);
    paramInt1 = this.BXC.CaK.b(paramArrayOfByte, paramInt1, paramInt2, paramInt3, paramInt4);
    AppMethodBeat.o(216438);
    return paramInt1;
  }
  
  public final boolean cae()
  {
    AppMethodBeat.i(115195);
    if (this.oXA != null)
    {
      boolean bool = this.oXA.OJ();
      AppMethodBeat.o(115195);
      return bool;
    }
    AppMethodBeat.o(115195);
    return true;
  }
  
  public final boolean evW()
  {
    AppMethodBeat.i(115170);
    if (this.BXC.evW())
    {
      AppMethodBeat.o(115170);
      return true;
    }
    AppMethodBeat.o(115170);
    return false;
  }
  
  public final boolean exO()
  {
    AppMethodBeat.i(115168);
    ad.i("MicroMsg.Voip.VoipServiceEx", "isRoomReady, roomId: " + this.BXC.CaI.roomId);
    if ((this.BXC.CaI.roomId != 0) && (!exP()))
    {
      AppMethodBeat.o(115168);
      return true;
    }
    AppMethodBeat.o(115168);
    return false;
  }
  
  public final void exR()
  {
    AppMethodBeat.i(115172);
    if (this.BXC.evW()) {
      com.tencent.mm.plugin.voip.b.f.Loge("MicroMsg.Voip.VoipServiceEx", "checkStartup failed, stauts = " + this.BXC.mStatus);
    }
    com.tencent.mm.plugin.voip.b.f.Loge("MicroMsg.Voip.VoipServiceEx", "checkStartup...devicekey = " + cc.fsJ());
    this.BXC.evR();
    exN();
    ae.vi(com.tencent.mm.kernel.g.ajC().ajm().fsH());
    AppMethodBeat.o(115172);
  }
  
  public final int exS()
  {
    AppMethodBeat.i(115175);
    ad.i("MicroMsg.Voip.VoipServiceEx", "cancelCall, roomId:" + this.BXC.CaI.roomId);
    if ((this.BXC.CaI.roomId == 0) && (this.BXC.CaI.uLv == 0))
    {
      reset();
      AppMethodBeat.o(115175);
      return -1;
    }
    this.BXC.CaI.Chg.CbS = this.BXC.evT();
    this.BXC.CaI.Chg.Cce = 3;
    if (this.BXC.mStatus < 6) {
      this.BXC.CaI.Chg.Ccg = 1;
    }
    com.tencent.mm.plugin.report.service.g.yhR.a(11521, true, true, new Object[] { Integer.valueOf(com.tencent.mm.plugin.voip.c.euM().exw()), Long.valueOf(com.tencent.mm.plugin.voip.c.euM().exx()), Long.valueOf(com.tencent.mm.plugin.voip.c.euM().evX()), Integer.valueOf(1), Long.valueOf(System.currentTimeMillis()), Long.valueOf(System.currentTimeMillis()) });
    int i = Uq(1);
    AppMethodBeat.o(115175);
    return i;
  }
  
  public final int exT()
  {
    AppMethodBeat.i(216436);
    ad.i("MicroMsg.Voip.VoipServiceEx", "cancelCallByPhoneInter, roomId:" + this.BXC.CaI.roomId);
    if (this.BXC.CaI.roomId == 0)
    {
      AppMethodBeat.o(216436);
      return -1;
    }
    this.BXC.CaI.Chg.CbS = 102;
    this.BXC.CaI.Chg.Cce = 6;
    if (com.tencent.mm.plugin.voip.c.euM().CdG != null)
    {
      this.BXC.CaI.Chg.CcD = com.tencent.mm.plugin.voip.c.euM().CdG.euK();
      this.BXC.CaI.Chg.BZo = (com.tencent.mm.plugin.voip.c.euM().CdG.euI() / 1000L);
      this.BXC.CaI.Chg.BZp = (com.tencent.mm.plugin.voip.c.euM().CdG.euJ() / 1000L);
    }
    com.tencent.mm.plugin.report.service.g.yhR.a(11521, true, true, new Object[] { Integer.valueOf(com.tencent.mm.plugin.voip.c.euM().exw()), Long.valueOf(com.tencent.mm.plugin.voip.c.euM().exx()), Long.valueOf(com.tencent.mm.plugin.voip.c.euM().evX()), Integer.valueOf(3), Long.valueOf(System.currentTimeMillis()), Long.valueOf(System.currentTimeMillis()) });
    int i = Uq(3);
    AppMethodBeat.o(216436);
    return i;
  }
  
  public final int exU()
  {
    AppMethodBeat.i(115180);
    ad.i("MicroMsg.Voip.VoipServiceEx", "reject");
    if (!this.BXC.evV())
    {
      com.tencent.mm.plugin.voip.b.f.Loge("MicroMsg.Voip.VoipServiceEx", "Failed to reject with calling, status =" + this.BXC.mStatus);
      AppMethodBeat.o(115180);
      return -1;
    }
    synchronized (this.Ceg)
    {
      if (this.BXC.CaI.roomId == 0)
      {
        com.tencent.mm.plugin.voip.b.f.Loge("MicroMsg.Voip.VoipServiceEx", "Failed to reject with roomid = 0. ");
        AppMethodBeat.o(115180);
        return -1;
      }
      this.BXC.CaI.Chg.ewy();
      com.tencent.mm.plugin.voip.b.f.Logd("MicroMsg.Voip.VoipServiceEx", " reject, status:" + this.BXC.mStatus + " roomid:" + this.BXC.CaI.roomId);
      int i = this.BXC.CaI.netType;
      int j = this.BXC.CaI.roomId;
      long l = this.BXC.CaI.uLt;
      new b(2, i, j, new byte[0], new byte[0], l, false, false, null).eyg();
      if ((this.BXC.CaI.Cfx == 0) && (this.BXC.CaI.Cfy == 0)) {
        this.BXC.evS();
      }
      this.BXC.Uc(this.oXA.eAH());
      this.BXC.CaI.Chg.CcC = this.BXC.CaJ.evy();
      if (com.tencent.mm.plugin.voip.c.euM().CdG != null)
      {
        this.BXC.CaI.Chg.CcD = com.tencent.mm.plugin.voip.c.euM().CdG.euK();
        this.BXC.CaI.Chg.BZo = (com.tencent.mm.plugin.voip.c.euM().CdG.euI() / 1000L);
        this.BXC.CaI.Chg.BZp = (com.tencent.mm.plugin.voip.c.euM().CdG.euJ() / 1000L);
      }
      if (this.BXC.CaI.eyx()) {
        this.BXC.CaI.tq(true);
      }
      String str1 = v2protocal.eyA();
      String str2 = this.BXC.CaI.eyB();
      String str3 = this.BXC.CaI.eyG();
      String str4 = this.BXC.CaI.eyt();
      String str5 = this.BXC.CaI.eyv();
      String[] arrayOfString1 = this.BXC.CaI.eyC();
      String[] arrayOfString2 = this.BXC.CaI.eyD();
      String[] arrayOfString3 = this.BXC.CaI.eyE();
      String[] arrayOfString4 = this.BXC.CaI.eyF();
      com.tencent.mm.plugin.voip.b.f.Logd("MicroMsg.Voip.VoipServiceEx", "devin: statreport");
      if (str2.length() > 0)
      {
        com.tencent.mm.plugin.voip.b.f.Logd("MicroMsg.Voip.VoipServiceEx", "devin: reject() newdialInfo.length() > 0");
        new com.tencent.mm.plugin.voip.model.a.l(str1, str2, str4, str3, str5, arrayOfString1, arrayOfString2, arrayOfString3, arrayOfString4).eyg();
        this.BXC.evQ();
        reset();
        this.BXC.CaI.roomId = 0;
        AppMethodBeat.o(115180);
        return 0;
      }
      com.tencent.mm.plugin.voip.b.f.Logd("MicroMsg.Voip.VoipServiceEx", "devin: reject() newdialInfo.length() <= 0");
    }
  }
  
  public final int exV()
  {
    AppMethodBeat.i(115181);
    ad.i("MicroMsg.Voip.VoipServiceEx", "hangUp");
    if (this.BXC.CaI.roomId == 0)
    {
      this.BXC.CaK.ewr();
      this.BXC.ewc();
      reset();
      AppMethodBeat.o(115181);
      return 0;
    }
    this.BXC.CaI.Chg.CbS = this.BXC.evT();
    int i = exW();
    AppMethodBeat.o(115181);
    return i;
  }
  
  public final int exW()
  {
    AppMethodBeat.i(115182);
    com.tencent.mm.plugin.voip.b.f.Logi("MicroMsg.Voip.VoipServiceEx", "hangUp,status:" + this.BXC.mStatus + " roomid:" + this.BXC.CaI.roomId + ",threadid = " + Thread.currentThread().getId());
    this.BXC.CaK.ewr();
    this.BXC.ewc();
    if (this.BXC.CaI.Chg.Ccc == 1)
    {
      ??? = this.BXC.CaI.Chg;
      if (((o)???).Cct != 0L) {
        break label623;
      }
      ((o)???).Ccm = 0;
    }
    for (;;)
    {
      if (((o)???).Ccm < 0)
      {
        ((o)???).Ccm = 0;
        com.tencent.mm.plugin.voip.b.f.Loge("MicroMsg.VoipDailReport", "devin:endTalk, iCallTime Err, rest 0");
      }
      com.tencent.mm.plugin.voip.b.f.Logi("MicroMsg.VoipDailReport", "devin:endTalk:" + ((o)???).Ccm);
      synchronized (this.Ceg)
      {
        int i = this.BXC.CaI.Chg.Cce;
        if ((this.BXC.CaI.roomId != 0) || (8 == i) || (9 == i) || (10 == i) || (11 == i) || (12 == i) || (99 == i))
        {
          com.tencent.mm.plugin.voip.b.f.Logi("MicroMsg.Voip.VoipServiceEx", "steve:hangUp, uninitGLRender before protocalUninit first!!");
          if (this.BXC.CaI.eyx())
          {
            this.BXC.CaI.tq(true);
            new com.tencent.mm.plugin.voip.model.a.i(this.BXC.CaI.roomId, this.BXC.CaI.uLt, "").eyg();
            com.tencent.mm.plugin.voip.b.f.Loge("MicroMsg.Voip.VoipServiceEx", "devin: shutdown cgi ");
          }
          this.BXC.CaI.Chg.CcC = this.BXC.CaJ.evy();
          if (com.tencent.mm.plugin.voip.c.euM().CdG != null)
          {
            this.BXC.CaI.Chg.CcD = com.tencent.mm.plugin.voip.c.euM().CdG.euK();
            this.BXC.CaI.Chg.BZo = (com.tencent.mm.plugin.voip.c.euM().CdG.euI() / 1000L);
            this.BXC.CaI.Chg.BZp = (com.tencent.mm.plugin.voip.c.euM().CdG.euJ() / 1000L);
          }
          this.BXC.Uc(this.oXA.eAH());
          String str1 = v2protocal.eyA();
          String str2 = this.BXC.CaI.eyB();
          String str3 = this.BXC.CaI.eyG();
          String str4 = this.BXC.CaI.eyt();
          String str5 = this.BXC.CaI.eyv();
          String[] arrayOfString1 = this.BXC.CaI.eyC();
          String[] arrayOfString2 = this.BXC.CaI.eyD();
          String[] arrayOfString3 = this.BXC.CaI.eyE();
          String[] arrayOfString4 = this.BXC.CaI.eyF();
          if (str2.length() > 0)
          {
            new com.tencent.mm.plugin.voip.model.a.l(str1, str2, str4, str3, str5, arrayOfString1, arrayOfString2, arrayOfString3, arrayOfString4).eyg();
            com.tencent.mm.plugin.voip.b.f.Loge("MicroMsg.Voip.VoipServiceEx", "devin: statreport cgi ");
          }
          this.BXC.evQ();
          reset();
          this.BXC.CaI.roomId = 0;
          com.tencent.mm.plugin.voip.b.f.Logd("MicroMsg.Voip.VoipServiceEx", "hangUp over");
          AppMethodBeat.o(115182);
          return 0;
          label623:
          ((o)???).Ccm = ((int)((System.currentTimeMillis() - ((o)???).Cct) / 1000L));
          continue;
        }
        com.tencent.mm.plugin.voip.b.f.Loge("MicroMsg.Voip.VoipServiceEx", "call hangUp roomId == 0 ");
      }
    }
  }
  
  public final void exX()
  {
    AppMethodBeat.i(115185);
    LinkedList localLinkedList = new LinkedList();
    this.BXC.CaI.aY(localLinkedList);
    int j = 0;
    int m = 0;
    int n;
    for (int i = 0; j < localLinkedList.size(); i = n)
    {
      int k = m;
      if (((cbv)localLinkedList.get(j)).GVK == 5) {
        k = m + 1;
      }
      n = i;
      if (((cbv)localLinkedList.get(j)).GVK == 4) {
        n = i + 1;
      }
      j += 1;
      m = k;
    }
    this.BXC.CaI.CfR = (this.BXC.CaI.CfR + "|redirect:" + i + ":" + m);
    new h(this.BXC.CaI.roomId, this.BXC.CaI.uLt, this.BXC.CaI.uLA, 0, 0, null, localLinkedList).eyg();
    AppMethodBeat.o(115185);
  }
  
  public final void exY()
  {
    AppMethodBeat.i(115193);
    if (this.oXA != null) {
      this.oXA.a(2131691389, false, 0, false);
    }
    AppMethodBeat.o(115193);
  }
  
  public final void exZ()
  {
    AppMethodBeat.i(115197);
    if (this.Ceu != null)
    {
      com.tencent.mm.plugin.voip.b.f.Logi("MicroMsg.Voip.VoipServiceEx", "devincdai: voip reset timecount");
      this.Ceu.stopTimer();
      this.Ceu.az(60000L, 60000L);
    }
    AppMethodBeat.o(115197);
  }
  
  public final int exu()
  {
    AppMethodBeat.i(216437);
    ad.i("MicroMsg.Voip.VoipServiceEx", "hangUpByPhoneInter");
    if (this.BXC.CaI.roomId == 0)
    {
      this.BXC.CaK.ewr();
      reset();
      AppMethodBeat.o(216437);
      return 0;
    }
    this.BXC.CaI.Chg.CbS = 109;
    this.BXC.CaI.Chg.Cck = 4;
    int i = exW();
    AppMethodBeat.o(216437);
    return i;
  }
  
  public final int exv()
  {
    AppMethodBeat.i(115183);
    ad.i("MicroMsg.Voip.VoipServiceEx", "ignoreInvite");
    if (!this.BXC.evV())
    {
      com.tencent.mm.plugin.voip.b.f.Loge("MicroMsg.Voip.VoipServiceEx", "Failed to ignore with calling, status =" + this.BXC.mStatus);
      AppMethodBeat.o(115183);
      return -1;
    }
    synchronized (this.Ceg)
    {
      if (this.BXC.CaI.roomId == 0)
      {
        com.tencent.mm.plugin.voip.b.f.Loge("MicroMsg.Voip.VoipServiceEx", "Failed to reject with roomid = 0. ");
        AppMethodBeat.o(115183);
        return -1;
      }
      int i = this.BXC.CaI.netType;
      int j = this.BXC.CaI.roomId;
      long l = this.BXC.CaI.uLt;
      new b(3, i, j, new byte[0], new byte[0], l, false, false, null).eyg();
      reset();
      this.BXC.CaI.roomId = 0;
      AppMethodBeat.o(115183);
      return 0;
    }
  }
  
  protected final void finalize()
  {
    AppMethodBeat.i(115164);
    stop();
    super.finalize();
    AppMethodBeat.o(115164);
  }
  
  public final int fk(String paramString, int paramInt)
  {
    AppMethodBeat.i(115174);
    ad.i("MicroMsg.Voip.VoipServiceEx", "call username:%s, callType:%d, inviteType:%d", new Object[] { paramString, Integer.valueOf(0), Integer.valueOf(paramInt) });
    if (bt.isNullOrNil(paramString))
    {
      com.tencent.mm.plugin.voip.b.f.Loge("MicroMsg.Voip.VoipServiceEx", "Failed call without valid username.");
      AppMethodBeat.o(115174);
      return -1;
    }
    if (this.BXC.evW())
    {
      com.tencent.mm.plugin.voip.b.f.Loge("MicroMsg.Voip.VoipServiceEx", "Failed call withing calling.");
      AppMethodBeat.o(115174);
      return -1;
    }
    this.Ces = paramString;
    this.BXC.CaI.Cff = 1;
    this.BXC.CaI.gno = paramString;
    com.tencent.mm.plugin.voip.b.f.Logd("MicroMsg.Voip.VoipServiceEx", com.tencent.mm.compatible.util.f.abi() + "call username:" + paramString);
    if (this.BXC.CaI.eyx())
    {
      com.tencent.mm.plugin.voip.b.f.Loge("MicroMsg.Voip.VoipServiceEx", com.tencent.mm.compatible.util.f.abi() + "v2protocal already init.");
      this.BXC.CaI.tq(false);
      this.BXC.CaI.reset();
    }
    if (this.BXC.CaI.eny() < 0)
    {
      com.tencent.mm.plugin.voip.b.f.Loge("MicroMsg.Voip.VoipServiceEx", "Failed to init v2protocol.");
      AppMethodBeat.o(115174);
      return -1;
    }
    if (this.BXC.CaI.Chj != null) {
      this.BXC.CaI.Chj.BXC = this.BXC;
    }
    if (v2protocal.Chk != null) {
      v2protocal.Chk.a(this.BXC);
    }
    this.Cex.az(50000L, 50000L);
    this.BXC.CaI.uLv = ((int)System.currentTimeMillis());
    LinkedList localLinkedList = new LinkedList();
    this.BXC.aX(localLinkedList);
    this.BXC.CaI.CfR = ("invite:" + this.BXC.CaI.CfM + ":" + this.BXC.CaI.CfN);
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(paramString);
    new com.tencent.mm.plugin.voip.model.a.g(localArrayList, this.BXC.CaI.field_peerId, this.BXC.CaI.field_capInfo, this.BXC.CaI.netType, paramInt, this.BXC.CaI.uLv, localLinkedList).eyg();
    this.BXC.setStatus(2);
    this.BXC.CaK.oWj = 1;
    this.Ceu.az(60000L, 60000L);
    this.BXC.CaI.Chg.Ccx = System.currentTimeMillis();
    this.BXC.CaI.Chg.beginTime = System.currentTimeMillis();
    this.BXC.CaI.Chg.Ccd = paramInt;
    ad.d("MicroMsg.Voip.VoipServiceEx", "iRoomType " + this.BXC.CaI.Chg.Ccd);
    this.BXC.ewb();
    AppMethodBeat.o(115174);
    return 0;
  }
  
  public final int setNetSignalValue(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(115186);
    paramInt1 = this.BXC.CaI.setNetSignalValue(paramInt1, paramInt2);
    AppMethodBeat.o(115186);
    return paramInt1;
  }
  
  public final void stop()
  {
    AppMethodBeat.i(115163);
    ad.i("MicroMsg.Voip.VoipServiceEx", "stop");
    reset();
    this.BXC.a(null);
    AppMethodBeat.o(115163);
  }
  
  public final void stopRing()
  {
    AppMethodBeat.i(115194);
    if (this.oXA != null) {
      this.oXA.stop();
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
        v.zt(WifiManager.calculateSignalLevel(v.h(v.this).getRssi(), 10));
        if (v.bIU() > 10)
        {
          v.zt(i);
          if (v.bIU() >= 0) {
            break label180;
          }
          i = 0;
          label117:
          v.zt(i);
          v.zt(v.bIU() * 10);
        }
      }
      for (;;)
      {
        if (v.bIU() != -1) {
          break label195;
        }
        if (v.i(v.this) <= 1) {
          v.Us(-1);
        }
        v.this.setNetSignalValue(1, v.Cei);
        AppMethodBeat.o(115161);
        return;
        i = v.bIU();
        break;
        label180:
        i = v.bIU();
        break label117;
        v.zt(-1);
      }
      label195:
      v.this.setNetSignalValue(2, v.bIU());
      AppMethodBeat.o(115161);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.voip.model.v
 * JD-Core Version:    0.7.0.1
 */