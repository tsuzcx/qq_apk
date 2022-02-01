package com.tencent.mm.plugin.voip.model;

import android.content.Context;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import android.os.Looper;
import android.telephony.TelephonyManager;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.e;
import com.tencent.mm.plugin.voip.model.a.b;
import com.tencent.mm.plugin.voip.model.a.h;
import com.tencent.mm.protocal.protobuf.ccp;
import com.tencent.mm.protocal.protobuf.dzm;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.aw;
import com.tencent.mm.sdk.platformtools.aw.a;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.storage.bv;
import com.tencent.mm.storage.cd;
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
  private static int CvJ = -1;
  private static int CvK = 20;
  private static int kKi = -1;
  public l Cpd;
  private Object CvH;
  private int CvI;
  public String CvL;
  private int CvM;
  ScheduledExecutorService CvN;
  ScheduledFuture<?> CvO;
  private WifiInfo CvP;
  public boolean CvQ;
  public int CvR;
  public boolean CvS;
  public String CvT;
  private a CvU;
  private aw CvV;
  private byte[] CvW;
  aw CvX;
  private aw CvY;
  private aw CvZ;
  private WifiManager cde;
  com.tencent.mm.plugin.voip.video.i ped;
  
  public v()
  {
    AppMethodBeat.i(115162);
    this.CvH = new Object();
    this.CvI = 0;
    this.CvN = Executors.newScheduledThreadPool(1);
    this.CvQ = false;
    this.CvR = 0;
    this.CvS = false;
    this.CvT = null;
    this.CvV = new aw(Looper.getMainLooper(), new aw.a()
    {
      public final boolean onTimerExpired()
      {
        AppMethodBeat.i(115156);
        if ((v.this.Cpd.Csj.CwG == 1) && (v.this.Cpd.ezB()))
        {
          com.tencent.mm.plugin.voip.b.f.Logi("MicroMsg.Voip.VoipServiceEx", "call timeout!");
          v.this.Cpd.Csj.CyH.Ctt = 101;
          com.tencent.mm.plugin.report.service.g.yxI.f(11521, new Object[] { Integer.valueOf(com.tencent.mm.plugin.voip.c.eys().eBd()), Long.valueOf(com.tencent.mm.plugin.voip.c.eys().eBe()), Long.valueOf(com.tencent.mm.plugin.voip.c.eys().ezE()), Integer.valueOf(4), Long.valueOf(System.currentTimeMillis()), Long.valueOf(System.currentTimeMillis()) });
          v.this.UX(4);
          v.this.Cpd.Csk.ezb();
        }
        AppMethodBeat.o(115156);
        return false;
      }
    }, false);
    this.CvW = new byte[500];
    this.CvX = new aw(Looper.getMainLooper(), new aw.a()
    {
      public final boolean onTimerExpired()
      {
        AppMethodBeat.i(115157);
        Object localObject = v.this.Cpd;
        ((l)localObject).Csr += 1;
        if (v.this.Cpd.Csj.roomId == 0)
        {
          com.tencent.mm.plugin.voip.b.f.Loge("MicroMsg.Voip.VoipServiceEx", com.tencent.mm.compatible.util.f.abr() + "double link switch roomId == 0 ");
          v.a(v.this).stopTimer();
        }
        for (;;)
        {
          AppMethodBeat.o(115157);
          return true;
          v.this.Cpd.Csj.app2EngineDataEx(v.this.Cpd.Csj.CxZ, v.this.Cpd.Csj.Cya, v.this.Cpd.Csj.Cyb, 0, 0);
          if ((!v.this.Cpd.Csq) && (1 == v.this.Cpd.Csj.field_mGetValidSample))
          {
            v.this.Cpd.Csq = true;
            v.this.Cpd.Css = v.this.Cpd.Csr;
          }
          if (1 == v.this.Cpd.CrW) {
            v.this.Cpd.CrW = 15;
          }
          if ((true == v.this.Cpd.Csq) && (v.this.Cpd.Csr - v.this.Cpd.Css == v.this.Cpd.CrW) && ((v.this.Cpd.Csj.CxQ & 0x1) == 0))
          {
            v.this.Cpd.Css = v.this.Cpd.Csr;
            int i = v.this.Cpd.Csj.isDCSameLan();
            int k = v.this.Cpd.Csj.getCurrentConnType();
            if ((1 == i) && (1 == k))
            {
              com.tencent.mm.plugin.voip.b.f.Logi("MicroMsg.Voip.VoipServiceEx", "zhengxue[DOUBLELINK]  In the Same LAN, isDCSameLan = ".concat(String.valueOf(i)));
              localObject = v.this.Cpd;
              ((l)localObject).Csr += 1;
              AppMethodBeat.o(115157);
              return true;
            }
            int m = v.this.Cpd.Csj.getcurstrategy();
            int n = v.this.Cpd.Csj.isRelayConnReady();
            int i1 = v.this.Cpd.Csj.isDCReady();
            int j = v.this.Cpd.CrW - 3;
            i = j;
            if (j > 15) {
              i = 15;
            }
            v.this.Cpd.Csj.app2EngineLinkQualityEx(i, v.b(v.this));
            new com.tencent.mm.plugin.voip.model.a.d(v.this.Cpd.Csj.roomId, v.this.Cpd.Csj.uXg, v.this.Cpd.Csj.uXn, k, n, i1, m, v.b(v.this), v.this.Cpd.Csj.field_realLinkQualityInfoBuffLen).eBO();
            localObject = v.this.Cpd.Csj;
            ((v2protocal)localObject).CxS += 1;
            com.tencent.mm.plugin.voip.b.f.Logi("MicroMsg.Voip.VoipServiceEx", "zhengxue[DOUBLELINK]  doubleLinkSwitchReportStatus " + v.this.Cpd.CrW + " isFirstValidSampleSet " + v.this.Cpd.Csq + " mGetValidSample " + v.this.Cpd.Csj.field_mGetValidSample + "mDoubleLinkSwitchReqCnt " + v.this.Cpd.Csj.CxS + "mTimerCounter " + v.this.Cpd.Csr + "mLastSwitchTimer " + v.this.Cpd.Css);
          }
        }
      }
    }, true);
    this.CvY = new aw(Looper.getMainLooper(), new aw.a()
    {
      public final boolean onTimerExpired()
      {
        AppMethodBeat.i(115158);
        if (v.this.Cpd.Csj.roomId == 0)
        {
          com.tencent.mm.plugin.voip.b.f.Loge("MicroMsg.Voip.VoipServiceEx", com.tencent.mm.compatible.util.f.abr() + " roomId == 0 ");
          v.c(v.this).stopTimer();
        }
        label136:
        for (;;)
        {
          AppMethodBeat.o(115158);
          return true;
          if (v.this.Cpd.mStatus >= 5) {}
          for (int i = 1;; i = 0)
          {
            if (i == 0) {
              break label136;
            }
            new com.tencent.mm.plugin.voip.model.a.f(v.this.Cpd.Csj.roomId, v.this.Cpd.Csj.uXg, v.this.Cpd.CsB).eBO();
            break;
          }
        }
      }
    }, true);
    this.CvZ = new aw(Looper.getMainLooper(), new aw.a()
    {
      public final boolean onTimerExpired()
      {
        AppMethodBeat.i(115159);
        com.tencent.mm.sdk.platformtools.ae.i("MicroMsg.Voip.VoipServiceEx", "voip called out of time,now destroy...");
        if ((3 == v.this.Cpd.mStatus) && (v.d(v.this) != 0) && (v.d(v.this) == v.this.Cpd.Csj.roomId))
        {
          v.e(v.this);
          v.this.Cpd.J(5, -9000, "");
        }
        AppMethodBeat.o(115159);
        return false;
      }
    }, true);
    this.Cpd = m.ezW();
    this.Cpd.a(this);
    this.ped = new com.tencent.mm.plugin.voip.video.i(ak.getContext());
    this.CvQ = false;
    this.CvR = 0;
    this.CvS = false;
    this.CvT = null;
    AppMethodBeat.o(115162);
  }
  
  private void eBI()
  {
    AppMethodBeat.i(210119);
    TelephonyManager localTelephonyManager = (TelephonyManager)ak.getContext().getSystemService("phone");
    if (localTelephonyManager != null) {
      localTelephonyManager.listen(new v.5(this, localTelephonyManager), 256);
    }
    AppMethodBeat.o(210119);
  }
  
  private void eBJ()
  {
    AppMethodBeat.i(210120);
    this.cde = ((WifiManager)ak.getContext().getApplicationContext().getSystemService("wifi"));
    if (this.CvU != null) {
      this.CvU.cancel();
    }
    this.CvU = new a();
    this.CvO = this.CvN.scheduleAtFixedRate(this.CvU, 0L, CvK, TimeUnit.SECONDS);
    AppMethodBeat.o(210120);
  }
  
  private void eBv()
  {
    AppMethodBeat.i(115166);
    com.tencent.mm.sdk.platformtools.ae.d("MicroMsg.Voip.VoipServiceEx", "reset");
    this.CvY.stopTimer();
    this.CvV.stopTimer();
    this.CvX.stopTimer();
    this.CvZ.stopTimer();
    this.CvI = 0;
    AppMethodBeat.o(115166);
  }
  
  private boolean eBx()
  {
    AppMethodBeat.i(115169);
    boolean bool = false;
    if (this.Cpd != null) {
      bool = this.Cpd.ezB();
    }
    AppMethodBeat.o(115169);
    return bool;
  }
  
  public static boolean eBy()
  {
    AppMethodBeat.i(115171);
    if (((TelephonyManager)ak.getContext().getSystemService("phone")).getCallState() != 0)
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
    com.tencent.mm.sdk.platformtools.ae.d("MicroMsg.Voip.VoipServiceEx", "reset");
    this.Cpd.reset();
    this.CvY.stopTimer();
    this.CvV.stopTimer();
    this.CvX.stopTimer();
    this.CvZ.stopTimer();
    if (this.CvU != null) {
      this.CvU.cancel();
    }
    if (this.CvO != null)
    {
      this.CvO.cancel(false);
      this.CvO = null;
    }
    this.CvI = 0;
    com.tencent.mm.plugin.voip.c.eys().aKI();
    com.tencent.mm.plugin.voip.c.eys().CqG = null;
    this.CvQ = false;
    this.CvR = 0;
    this.CvS = false;
    this.CvT = null;
    AppMethodBeat.o(115165);
  }
  
  public final void J(int paramInt1, int paramInt2, String paramString)
  {
    AppMethodBeat.i(115173);
    com.tencent.mm.sdk.platformtools.ae.i("MicroMsg.Voip.VoipServiceEx", "onFinishVoIP finishType: ".concat(String.valueOf(paramInt1)));
    switch (paramInt1)
    {
    }
    for (;;)
    {
      AppMethodBeat.o(115173);
      return;
      eBE();
      this.Cpd.Csk.onReject();
      AppMethodBeat.o(115173);
      return;
      eBE();
      this.Cpd.Csk.ezb();
      AppMethodBeat.o(115173);
      return;
      eBE();
      this.Cpd.Csk.ezd();
      AppMethodBeat.o(115173);
      return;
      eBE();
      this.Cpd.Csk.onError(paramInt2, paramString);
    }
  }
  
  public final void UL(int paramInt)
  {
    AppMethodBeat.i(115187);
    this.Cpd.UL(paramInt);
    AppMethodBeat.o(115187);
  }
  
  public final void UT(int paramInt)
  {
    AppMethodBeat.i(115167);
    this.Cpd.UH(paramInt);
    AppMethodBeat.o(115167);
  }
  
  public final void UW(int paramInt)
  {
    AppMethodBeat.i(210121);
    this.cde = null;
    this.CvP = null;
    this.CvM = 0;
    if (paramInt > 0) {
      CvK = paramInt;
    }
    eBJ();
    eBI();
    AppMethodBeat.o(210121);
  }
  
  public final int UX(int paramInt)
  {
    AppMethodBeat.i(115176);
    if (!this.Cpd.ezD())
    {
      com.tencent.mm.plugin.voip.b.f.Loge("MicroMsg.Voip.VoipServiceEx", "Failed to cancel call ,as not in calling.");
      AppMethodBeat.o(115176);
      return -1;
    }
    com.tencent.mm.sdk.platformtools.ae.i("MicroMsg.Voip.VoipServiceEx", "cancelCallEx, roomId:%d, msgID:%d, inviteId:%d, cancelType:%d", new Object[] { Integer.valueOf(this.Cpd.Csj.roomId), Integer.valueOf(this.Cpd.Csj.CwE), Integer.valueOf(this.Cpd.Csj.uXi), Integer.valueOf(paramInt) });
    synchronized (this.CvH)
    {
      if ((this.Cpd.Csj.roomId == 0) && (this.Cpd.Csj.uXi == 0))
      {
        com.tencent.mm.plugin.voip.b.f.Loge("MicroMsg.Voip.VoipServiceEx", "Failed to cancel call with roomid = 0 and inviteId = 0 ");
        AppMethodBeat.o(115176);
        return -1;
      }
      if (this.Cpd.Csj.eCf())
      {
        this.Cpd.Csj.tx(true);
        new com.tencent.mm.plugin.voip.model.a.c(this.Cpd.Csj.roomId, this.Cpd.Csj.uXg, this.Cpd.Csj.gpK, "", this.Cpd.Csj.uXi, paramInt).eBO();
      }
      Object localObject2 = this.Cpd.Csj.CyH;
      ((o)localObject2).CtO = ((int)(System.currentTimeMillis() - ((o)localObject2).CtY));
      com.tencent.mm.plugin.voip.b.f.Logd("MicroMsg.VoipDailReport", "devin:cancelInvite:" + ((o)localObject2).CtO);
      if ((this.Cpd.Csj.CwY == 0) && (this.Cpd.Csj.CwZ == 0)) {
        this.Cpd.ezz();
      }
      this.Cpd.UJ(this.ped.eEp());
      this.Cpd.Csj.CyH.Cud = this.Cpd.Csk.ezf();
      if (com.tencent.mm.plugin.voip.c.eys().Cvh != null)
      {
        this.Cpd.Csj.CyH.Cue = com.tencent.mm.plugin.voip.c.eys().Cvh.eyq();
        this.Cpd.Csj.CyH.CqP = (com.tencent.mm.plugin.voip.c.eys().Cvh.eyo() / 1000L);
        this.Cpd.Csj.CyH.CqQ = (com.tencent.mm.plugin.voip.c.eys().Cvh.eyp() / 1000L);
      }
      localObject2 = v2protocal.eCi();
      String str1 = this.Cpd.Csj.eCj();
      String str2 = this.Cpd.Csj.eCo();
      String str3 = this.Cpd.Csj.eCb();
      String str4 = this.Cpd.Csj.eCd();
      String[] arrayOfString1 = this.Cpd.Csj.eCk();
      String[] arrayOfString2 = this.Cpd.Csj.eCl();
      String[] arrayOfString3 = this.Cpd.Csj.eCm();
      String[] arrayOfString4 = this.Cpd.Csj.eCn();
      if (str1.length() > 0) {
        new com.tencent.mm.plugin.voip.model.a.l((String)localObject2, str1, str3, str2, str4, arrayOfString1, arrayOfString2, arrayOfString3, arrayOfString4).eBO();
      }
      this.Cpd.ezx();
      reset();
      this.Cpd.Csj.roomId = 0;
      this.Cpd.Csj.uXi = 0;
      AppMethodBeat.o(115176);
      return 0;
    }
  }
  
  public final void UY(int paramInt)
  {
    AppMethodBeat.i(115196);
    this.CvI = paramInt;
    if (!this.CvZ.foU()) {
      this.CvZ.stopTimer();
    }
    this.CvZ.ay(70000L, 70000L);
    AppMethodBeat.o(115196);
  }
  
  public final void a(int paramInt1, long paramLong, int paramInt2, byte[] paramArrayOfByte1, byte[] paramArrayOfByte2, String paramString)
  {
    AppMethodBeat.i(115184);
    com.tencent.mm.plugin.voip.b.f.Logi("MicroMsg.Voip.VoipServiceEx", "doAck roomId " + paramInt1 + "  roomKey " + paramLong + " status " + paramInt2);
    if ((paramInt1 != 0) && (paramLong != 0L))
    {
      LinkedList localLinkedList = new LinkedList();
      this.Cpd.aY(localLinkedList);
      this.Cpd.Csj.Cxs = ("ack:" + this.Cpd.Csj.Cxn + ":" + this.Cpd.Csj.Cxo);
      new com.tencent.mm.plugin.voip.model.a.a(paramInt1, paramLong, paramInt2, paramArrayOfByte1, paramArrayOfByte2, paramString, localLinkedList).eBO();
    }
    this.Cpd.ezI();
    AppMethodBeat.o(115184);
  }
  
  public final void a(Context paramContext, x paramx)
  {
    AppMethodBeat.i(210113);
    this.Cpd.nnh = paramContext;
    this.Cpd.Csk = paramx;
    com.tencent.mm.plugin.voip.b.f.Logd("MicroMsg.Voip.VoipServiceEx", "attach ui........");
    com.tencent.mm.plugin.voip.b.f.eDl();
    AppMethodBeat.o(210113);
  }
  
  public final boolean a(dzm paramdzm)
  {
    int i = 1;
    AppMethodBeat.i(115178);
    if (this.Cpd.ezD())
    {
      com.tencent.mm.plugin.voip.b.f.Loge("MicroMsg.Voip.VoipServiceEx", "Failed to setInviteContent during calling, status =" + this.Cpd.mStatus);
      AppMethodBeat.o(115178);
      return false;
    }
    if (paramdzm == null)
    {
      AppMethodBeat.o(115178);
      return false;
    }
    this.Cpd.Csj.CyH.CtE = paramdzm.Iel;
    com.tencent.mm.sdk.platformtools.ae.d("MicroMsg.Voip.VoipServiceEx", "iRoomType " + this.Cpd.Csj.CyH.CtE);
    if (this.Cpd.Csj.eCf())
    {
      com.tencent.mm.plugin.voip.b.f.Logw("MicroMsg.Voip.VoipServiceEx", com.tencent.mm.compatible.util.f.abr() + "v2protocal already init.");
      this.Cpd.Csj.tx(false);
      this.Cpd.Csj.reset();
    }
    this.Cpd.a(paramdzm);
    if ((com.tencent.mm.plugin.voip.b.n.eDM()) || (com.tencent.mm.r.a.adO()) || (com.tencent.mm.plugin.voip.b.n.eDO()) || (com.tencent.mm.r.a.adP()))
    {
      com.tencent.mm.sdk.platformtools.ae.e("MicroMsg.Voip.VoipServiceEx", "setInviteContent, reject, pstn/multitak/f2f talking");
      if ((com.tencent.mm.plugin.voip.b.n.eDM()) || (com.tencent.mm.r.a.adP()))
      {
        a(paramdzm.Gxq, paramdzm.Gxr, 2, null, null, paramdzm.Ieu);
        AppMethodBeat.o(115178);
        return false;
      }
      eBC();
      label271:
      String str;
      if (paramdzm.Iel == 0)
      {
        str = paramdzm.Ieu;
        if (i == 0) {
          break label310;
        }
      }
      label310:
      for (paramdzm = bv.JgL;; paramdzm = bv.JgK)
      {
        s.c(str, paramdzm, 0, 6, ak.getContext().getString(2131764807));
        break;
        i = 0;
        break label271;
      }
    }
    if (this.Cpd.Csj.erf() < 0)
    {
      com.tencent.mm.plugin.voip.b.f.Loge("MicroMsg.Voip.VoipServiceEx", "Failed to init v2protocol.");
      AppMethodBeat.o(115178);
      return false;
    }
    if (v2protocal.CyL != null) {
      v2protocal.CyL.a(this.Cpd);
    }
    com.tencent.mm.plugin.report.service.g.yxI.a(11524, true, true, new Object[] { Integer.valueOf(paramdzm.Gxq), Long.valueOf(paramdzm.Gxr), Integer.valueOf(paramdzm.Iel), Integer.valueOf(0), Long.valueOf(System.currentTimeMillis()) });
    if (!this.CvQ) {
      this.Cpd.Csk.eyY();
    }
    AppMethodBeat.o(115178);
    return true;
  }
  
  public final int av(boolean paramBoolean1, boolean paramBoolean2)
  {
    AppMethodBeat.i(115179);
    eBH();
    if (!this.CvZ.foU()) {
      this.CvZ.stopTimer();
    }
    this.Cpd.Csj.CyH.eAe();
    com.tencent.mm.sdk.platformtools.ae.i("MicroMsg.Voip.VoipServiceEx", "accept onlyAudio:".concat(String.valueOf(paramBoolean1)));
    if (!this.Cpd.ezC())
    {
      com.tencent.mm.plugin.voip.b.f.Loge("MicroMsg.Voip.VoipServiceEx", "Failed to accept with calling, status =" + this.Cpd.mStatus);
      AppMethodBeat.o(115179);
      return -1;
    }
    if (this.Cpd.Csj.roomId == 0)
    {
      com.tencent.mm.plugin.voip.b.f.Loge("MicroMsg.Voip.VoipServiceEx", "Failed to accept with roomid = 0. ");
      AppMethodBeat.o(115179);
      return -1;
    }
    LinkedList localLinkedList = new LinkedList();
    this.Cpd.aY(localLinkedList);
    this.Cpd.Csj.Cxs = (this.Cpd.Csj.Cxs + "|answer:" + this.Cpd.Csj.Cxn + ":" + this.Cpd.Csj.Cxo);
    com.tencent.mm.plugin.voip.b.f.Logd("MicroMsg.Voip.VoipServiceEx", com.tencent.mm.compatible.util.f.abr() + "accept invite, roomid:" + this.Cpd.Csj.roomId + " nic list size:" + localLinkedList.size());
    this.CvY.ay(50000L, 50000L);
    this.Cpd.Csj.CyH.eAf();
    new b(1, this.Cpd.Csj.netType, this.Cpd.Csj.roomId, this.Cpd.Csj.field_peerId, this.Cpd.Csj.field_capInfo, this.Cpd.Csj.uXg, paramBoolean1, paramBoolean2, localLinkedList).eBO();
    this.Cpd.setStatus(4);
    this.Cpd.Csl.pcM = 1;
    this.Cpd.dFa = true;
    AppMethodBeat.o(115179);
    return 0;
  }
  
  public final void b(Context paramContext, x paramx)
  {
    AppMethodBeat.i(210114);
    if ((paramContext != this.Cpd.nnh) || (paramx != this.Cpd.Csk))
    {
      com.tencent.mm.plugin.voip.b.f.Logd("MicroMsg.Voip.VoipServiceEx", "cannot detach other's ui.");
      AppMethodBeat.o(210114);
      return;
    }
    this.Cpd.nnh = null;
    this.Cpd.Csk = x.Cwi;
    com.tencent.mm.plugin.voip.b.f.Logd("MicroMsg.Voip.VoipServiceEx", "detach ui........");
    com.tencent.mm.plugin.voip.b.f.flushLogFile();
    AppMethodBeat.o(210114);
  }
  
  public final int c(int paramInt1, long paramLong, int paramInt2)
  {
    AppMethodBeat.i(115177);
    if (!this.Cpd.ezD())
    {
      com.tencent.mm.plugin.voip.b.f.Loge("MicroMsg.Voip.VoipServiceEx", "steve:[simucall]Failed to cancel call ,as not in calling.");
      AppMethodBeat.o(115177);
      return -1;
    }
    com.tencent.mm.sdk.platformtools.ae.i("MicroMsg.Voip.VoipServiceEx", "steve:[simucall] try to cancel my invite due to Simulcall(callee), roomId:%s, roomKey:%s, roomType:%d, msgID:%d, inviteId:%d", new Object[] { Integer.valueOf(paramInt1), Long.valueOf(paramLong), Integer.valueOf(paramInt2), Integer.valueOf(this.Cpd.Csj.CwE), Integer.valueOf(this.Cpd.Csj.uXi) });
    Object localObject1 = this.CvH;
    if (paramInt1 != 0) {}
    try
    {
      if (this.Cpd.Csj.uXi == 0)
      {
        com.tencent.mm.plugin.voip.b.f.Loge("MicroMsg.Voip.VoipServiceEx", "steve:[simucall] Failed to cancel call with roomid = 0 and inviteId = 0 ");
        return -1;
      }
      new com.tencent.mm.plugin.voip.model.a.c(paramInt1, paramLong, this.Cpd.Csj.gpK, "", this.Cpd.Csj.uXi, 2).eBO();
      com.tencent.mm.plugin.report.service.g.yxI.a(11521, true, true, new Object[] { Integer.valueOf(paramInt1), Long.valueOf(paramLong), Integer.valueOf(paramInt2), Integer.valueOf(2), Long.valueOf(System.currentTimeMillis()), Long.valueOf(System.currentTimeMillis()) });
      com.tencent.mm.sdk.platformtools.ae.i("MicroMsg.Voip.VoipServiceEx", "steve:[simucall] voipcancelinvite sent!");
      return 0;
    }
    finally
    {
      AppMethodBeat.o(115177);
    }
  }
  
  public final int c(ByteBuffer paramByteBuffer, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5)
  {
    AppMethodBeat.i(210118);
    paramInt1 = this.Cpd.Csl.b(paramByteBuffer, paramInt1, paramInt2, paramInt3, paramInt4, paramInt5);
    AppMethodBeat.o(210118);
    return paramInt1;
  }
  
  public final int c(byte[] paramArrayOfByte, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    AppMethodBeat.i(210117);
    paramInt1 = this.Cpd.Csl.b(paramArrayOfByte, paramInt1, paramInt2, paramInt3, paramInt4);
    AppMethodBeat.o(210117);
    return paramInt1;
  }
  
  public final boolean cbt()
  {
    AppMethodBeat.i(115195);
    if (this.ped != null)
    {
      boolean bool = this.ped.OH();
      AppMethodBeat.o(115195);
      return bool;
    }
    AppMethodBeat.o(115195);
    return true;
  }
  
  public final int eBA()
  {
    AppMethodBeat.i(115175);
    com.tencent.mm.sdk.platformtools.ae.i("MicroMsg.Voip.VoipServiceEx", "cancelCall, roomId:" + this.Cpd.Csj.roomId);
    if ((this.Cpd.Csj.roomId == 0) && (this.Cpd.Csj.uXi == 0))
    {
      reset();
      AppMethodBeat.o(115175);
      return -1;
    }
    this.Cpd.Csj.CyH.Ctt = this.Cpd.ezA();
    this.Cpd.Csj.CyH.CtF = 3;
    if (this.Cpd.mStatus < 6) {
      this.Cpd.Csj.CyH.CtH = 1;
    }
    com.tencent.mm.plugin.report.service.g.yxI.a(11521, true, true, new Object[] { Integer.valueOf(com.tencent.mm.plugin.voip.c.eys().eBd()), Long.valueOf(com.tencent.mm.plugin.voip.c.eys().eBe()), Long.valueOf(com.tencent.mm.plugin.voip.c.eys().ezE()), Integer.valueOf(1), Long.valueOf(System.currentTimeMillis()), Long.valueOf(System.currentTimeMillis()) });
    int i = UX(1);
    AppMethodBeat.o(115175);
    return i;
  }
  
  public final int eBB()
  {
    AppMethodBeat.i(210115);
    com.tencent.mm.sdk.platformtools.ae.i("MicroMsg.Voip.VoipServiceEx", "cancelCallByPhoneInter, roomId:" + this.Cpd.Csj.roomId);
    if (this.Cpd.Csj.roomId == 0)
    {
      AppMethodBeat.o(210115);
      return -1;
    }
    this.Cpd.Csj.CyH.Ctt = 102;
    this.Cpd.Csj.CyH.CtF = 6;
    if (com.tencent.mm.plugin.voip.c.eys().Cvh != null)
    {
      this.Cpd.Csj.CyH.Cue = com.tencent.mm.plugin.voip.c.eys().Cvh.eyq();
      this.Cpd.Csj.CyH.CqP = (com.tencent.mm.plugin.voip.c.eys().Cvh.eyo() / 1000L);
      this.Cpd.Csj.CyH.CqQ = (com.tencent.mm.plugin.voip.c.eys().Cvh.eyp() / 1000L);
    }
    com.tencent.mm.plugin.report.service.g.yxI.a(11521, true, true, new Object[] { Integer.valueOf(com.tencent.mm.plugin.voip.c.eys().eBd()), Long.valueOf(com.tencent.mm.plugin.voip.c.eys().eBe()), Long.valueOf(com.tencent.mm.plugin.voip.c.eys().ezE()), Integer.valueOf(3), Long.valueOf(System.currentTimeMillis()), Long.valueOf(System.currentTimeMillis()) });
    int i = UX(3);
    AppMethodBeat.o(210115);
    return i;
  }
  
  public final int eBC()
  {
    AppMethodBeat.i(115180);
    com.tencent.mm.sdk.platformtools.ae.i("MicroMsg.Voip.VoipServiceEx", "reject");
    if (!this.Cpd.ezC())
    {
      com.tencent.mm.plugin.voip.b.f.Loge("MicroMsg.Voip.VoipServiceEx", "Failed to reject with calling, status =" + this.Cpd.mStatus);
      AppMethodBeat.o(115180);
      return -1;
    }
    synchronized (this.CvH)
    {
      if (this.Cpd.Csj.roomId == 0)
      {
        com.tencent.mm.plugin.voip.b.f.Loge("MicroMsg.Voip.VoipServiceEx", "Failed to reject with roomid = 0. ");
        AppMethodBeat.o(115180);
        return -1;
      }
      this.Cpd.Csj.CyH.eAf();
      com.tencent.mm.plugin.voip.b.f.Logd("MicroMsg.Voip.VoipServiceEx", " reject, status:" + this.Cpd.mStatus + " roomid:" + this.Cpd.Csj.roomId);
      int i = this.Cpd.Csj.netType;
      int j = this.Cpd.Csj.roomId;
      long l = this.Cpd.Csj.uXg;
      new b(2, i, j, new byte[0], new byte[0], l, false, false, null).eBO();
      if ((this.Cpd.Csj.CwY == 0) && (this.Cpd.Csj.CwZ == 0)) {
        this.Cpd.ezz();
      }
      this.Cpd.UJ(this.ped.eEp());
      this.Cpd.Csj.CyH.Cud = this.Cpd.Csk.ezf();
      if (com.tencent.mm.plugin.voip.c.eys().Cvh != null)
      {
        this.Cpd.Csj.CyH.Cue = com.tencent.mm.plugin.voip.c.eys().Cvh.eyq();
        this.Cpd.Csj.CyH.CqP = (com.tencent.mm.plugin.voip.c.eys().Cvh.eyo() / 1000L);
        this.Cpd.Csj.CyH.CqQ = (com.tencent.mm.plugin.voip.c.eys().Cvh.eyp() / 1000L);
      }
      if (this.Cpd.Csj.eCf()) {
        this.Cpd.Csj.tx(true);
      }
      String str1 = v2protocal.eCi();
      String str2 = this.Cpd.Csj.eCj();
      String str3 = this.Cpd.Csj.eCo();
      String str4 = this.Cpd.Csj.eCb();
      String str5 = this.Cpd.Csj.eCd();
      String[] arrayOfString1 = this.Cpd.Csj.eCk();
      String[] arrayOfString2 = this.Cpd.Csj.eCl();
      String[] arrayOfString3 = this.Cpd.Csj.eCm();
      String[] arrayOfString4 = this.Cpd.Csj.eCn();
      com.tencent.mm.plugin.voip.b.f.Logd("MicroMsg.Voip.VoipServiceEx", "devin: statreport");
      if (str2.length() > 0)
      {
        com.tencent.mm.plugin.voip.b.f.Logd("MicroMsg.Voip.VoipServiceEx", "devin: reject() newdialInfo.length() > 0");
        new com.tencent.mm.plugin.voip.model.a.l(str1, str2, str4, str3, str5, arrayOfString1, arrayOfString2, arrayOfString3, arrayOfString4).eBO();
        this.Cpd.ezx();
        reset();
        this.Cpd.Csj.roomId = 0;
        AppMethodBeat.o(115180);
        return 0;
      }
      com.tencent.mm.plugin.voip.b.f.Logd("MicroMsg.Voip.VoipServiceEx", "devin: reject() newdialInfo.length() <= 0");
    }
  }
  
  public final int eBD()
  {
    AppMethodBeat.i(115181);
    com.tencent.mm.sdk.platformtools.ae.i("MicroMsg.Voip.VoipServiceEx", "hangUp");
    if (this.Cpd.Csj.roomId == 0)
    {
      this.Cpd.Csl.ezY();
      this.Cpd.ezJ();
      reset();
      AppMethodBeat.o(115181);
      return 0;
    }
    this.Cpd.Csj.CyH.Ctt = this.Cpd.ezA();
    int i = eBE();
    AppMethodBeat.o(115181);
    return i;
  }
  
  public final int eBE()
  {
    AppMethodBeat.i(115182);
    com.tencent.mm.plugin.voip.b.f.Logi("MicroMsg.Voip.VoipServiceEx", "hangUp,status:" + this.Cpd.mStatus + " roomid:" + this.Cpd.Csj.roomId + ",threadid = " + Thread.currentThread().getId());
    this.Cpd.Csl.ezY();
    this.Cpd.ezJ();
    if (this.Cpd.Csj.CyH.CtD == 1)
    {
      ??? = this.Cpd.Csj.CyH;
      if (((o)???).CtU != 0L) {
        break label623;
      }
      ((o)???).CtN = 0;
    }
    for (;;)
    {
      if (((o)???).CtN < 0)
      {
        ((o)???).CtN = 0;
        com.tencent.mm.plugin.voip.b.f.Loge("MicroMsg.VoipDailReport", "devin:endTalk, iCallTime Err, rest 0");
      }
      com.tencent.mm.plugin.voip.b.f.Logi("MicroMsg.VoipDailReport", "devin:endTalk:" + ((o)???).CtN);
      synchronized (this.CvH)
      {
        int i = this.Cpd.Csj.CyH.CtF;
        if ((this.Cpd.Csj.roomId != 0) || (8 == i) || (9 == i) || (10 == i) || (11 == i) || (12 == i) || (99 == i))
        {
          com.tencent.mm.plugin.voip.b.f.Logi("MicroMsg.Voip.VoipServiceEx", "steve:hangUp, uninitGLRender before protocalUninit first!!");
          if (this.Cpd.Csj.eCf())
          {
            this.Cpd.Csj.tx(true);
            new com.tencent.mm.plugin.voip.model.a.i(this.Cpd.Csj.roomId, this.Cpd.Csj.uXg, "").eBO();
            com.tencent.mm.plugin.voip.b.f.Loge("MicroMsg.Voip.VoipServiceEx", "devin: shutdown cgi ");
          }
          this.Cpd.Csj.CyH.Cud = this.Cpd.Csk.ezf();
          if (com.tencent.mm.plugin.voip.c.eys().Cvh != null)
          {
            this.Cpd.Csj.CyH.Cue = com.tencent.mm.plugin.voip.c.eys().Cvh.eyq();
            this.Cpd.Csj.CyH.CqP = (com.tencent.mm.plugin.voip.c.eys().Cvh.eyo() / 1000L);
            this.Cpd.Csj.CyH.CqQ = (com.tencent.mm.plugin.voip.c.eys().Cvh.eyp() / 1000L);
          }
          this.Cpd.UJ(this.ped.eEp());
          String str1 = v2protocal.eCi();
          String str2 = this.Cpd.Csj.eCj();
          String str3 = this.Cpd.Csj.eCo();
          String str4 = this.Cpd.Csj.eCb();
          String str5 = this.Cpd.Csj.eCd();
          String[] arrayOfString1 = this.Cpd.Csj.eCk();
          String[] arrayOfString2 = this.Cpd.Csj.eCl();
          String[] arrayOfString3 = this.Cpd.Csj.eCm();
          String[] arrayOfString4 = this.Cpd.Csj.eCn();
          if (str2.length() > 0)
          {
            new com.tencent.mm.plugin.voip.model.a.l(str1, str2, str4, str3, str5, arrayOfString1, arrayOfString2, arrayOfString3, arrayOfString4).eBO();
            com.tencent.mm.plugin.voip.b.f.Loge("MicroMsg.Voip.VoipServiceEx", "devin: statreport cgi ");
          }
          this.Cpd.ezx();
          reset();
          this.Cpd.Csj.roomId = 0;
          com.tencent.mm.plugin.voip.b.f.Logd("MicroMsg.Voip.VoipServiceEx", "hangUp over");
          AppMethodBeat.o(115182);
          return 0;
          label623:
          ((o)???).CtN = ((int)((System.currentTimeMillis() - ((o)???).CtU) / 1000L));
          continue;
        }
        com.tencent.mm.plugin.voip.b.f.Loge("MicroMsg.Voip.VoipServiceEx", "call hangUp roomId == 0 ");
      }
    }
  }
  
  public final void eBF()
  {
    AppMethodBeat.i(115185);
    LinkedList localLinkedList = new LinkedList();
    this.Cpd.Csj.aZ(localLinkedList);
    int j = 0;
    int m = 0;
    int n;
    for (int i = 0; j < localLinkedList.size(); i = n)
    {
      int k = m;
      if (((ccp)localLinkedList.get(j)).GsP == 5) {
        k = m + 1;
      }
      n = i;
      if (((ccp)localLinkedList.get(j)).GsP == 4) {
        n = i + 1;
      }
      j += 1;
      m = k;
    }
    this.Cpd.Csj.Cxs = (this.Cpd.Csj.Cxs + "|redirect:" + i + ":" + m);
    new h(this.Cpd.Csj.roomId, this.Cpd.Csj.uXg, this.Cpd.Csj.uXn, 0, 0, null, localLinkedList).eBO();
    AppMethodBeat.o(115185);
  }
  
  public final void eBG()
  {
    AppMethodBeat.i(115193);
    if (this.ped != null) {
      this.ped.a(2131691389, false, 0, false);
    }
    AppMethodBeat.o(115193);
  }
  
  public final void eBH()
  {
    AppMethodBeat.i(115197);
    if (this.CvV != null)
    {
      com.tencent.mm.plugin.voip.b.f.Logi("MicroMsg.Voip.VoipServiceEx", "devincdai: voip reset timecount");
      this.CvV.stopTimer();
      this.CvV.ay(60000L, 60000L);
    }
    AppMethodBeat.o(115197);
  }
  
  public final int eBb()
  {
    AppMethodBeat.i(210116);
    com.tencent.mm.sdk.platformtools.ae.i("MicroMsg.Voip.VoipServiceEx", "hangUpByPhoneInter");
    if (this.Cpd.Csj.roomId == 0)
    {
      this.Cpd.Csl.ezY();
      reset();
      AppMethodBeat.o(210116);
      return 0;
    }
    this.Cpd.Csj.CyH.Ctt = 109;
    this.Cpd.Csj.CyH.CtL = 4;
    int i = eBE();
    AppMethodBeat.o(210116);
    return i;
  }
  
  public final int eBc()
  {
    AppMethodBeat.i(115183);
    com.tencent.mm.sdk.platformtools.ae.i("MicroMsg.Voip.VoipServiceEx", "ignoreInvite");
    if (!this.Cpd.ezC())
    {
      com.tencent.mm.plugin.voip.b.f.Loge("MicroMsg.Voip.VoipServiceEx", "Failed to ignore with calling, status =" + this.Cpd.mStatus);
      AppMethodBeat.o(115183);
      return -1;
    }
    synchronized (this.CvH)
    {
      if (this.Cpd.Csj.roomId == 0)
      {
        com.tencent.mm.plugin.voip.b.f.Loge("MicroMsg.Voip.VoipServiceEx", "Failed to reject with roomid = 0. ");
        AppMethodBeat.o(115183);
        return -1;
      }
      int i = this.Cpd.Csj.netType;
      int j = this.Cpd.Csj.roomId;
      long l = this.Cpd.Csj.uXg;
      new b(3, i, j, new byte[0], new byte[0], l, false, false, null).eBO();
      reset();
      this.Cpd.Csj.roomId = 0;
      AppMethodBeat.o(115183);
      return 0;
    }
  }
  
  public final boolean eBw()
  {
    AppMethodBeat.i(115168);
    com.tencent.mm.sdk.platformtools.ae.i("MicroMsg.Voip.VoipServiceEx", "isRoomReady, roomId: " + this.Cpd.Csj.roomId);
    if ((this.Cpd.Csj.roomId != 0) && (!eBx()))
    {
      AppMethodBeat.o(115168);
      return true;
    }
    AppMethodBeat.o(115168);
    return false;
  }
  
  public final void eBz()
  {
    AppMethodBeat.i(115172);
    if (this.Cpd.ezD()) {
      com.tencent.mm.plugin.voip.b.f.Loge("MicroMsg.Voip.VoipServiceEx", "checkStartup failed, stauts = " + this.Cpd.mStatus);
    }
    com.tencent.mm.plugin.voip.b.f.Loge("MicroMsg.Voip.VoipServiceEx", "checkStartup...devicekey = " + cd.fwK());
    this.Cpd.ezy();
    eBv();
    com.tencent.mm.compatible.deviceinfo.ae.vE(com.tencent.mm.kernel.g.ajR().ajB().fwI());
    AppMethodBeat.o(115172);
  }
  
  public final boolean ezD()
  {
    AppMethodBeat.i(115170);
    if (this.Cpd.ezD())
    {
      AppMethodBeat.o(115170);
      return true;
    }
    AppMethodBeat.o(115170);
    return false;
  }
  
  protected final void finalize()
  {
    AppMethodBeat.i(115164);
    stop();
    super.finalize();
    AppMethodBeat.o(115164);
  }
  
  public final int ft(String paramString, int paramInt)
  {
    AppMethodBeat.i(115174);
    com.tencent.mm.sdk.platformtools.ae.i("MicroMsg.Voip.VoipServiceEx", "call username:%s, callType:%d, inviteType:%d", new Object[] { paramString, Integer.valueOf(0), Integer.valueOf(paramInt) });
    if (bu.isNullOrNil(paramString))
    {
      com.tencent.mm.plugin.voip.b.f.Loge("MicroMsg.Voip.VoipServiceEx", "Failed call without valid username.");
      AppMethodBeat.o(115174);
      return -1;
    }
    if (this.Cpd.ezD())
    {
      com.tencent.mm.plugin.voip.b.f.Loge("MicroMsg.Voip.VoipServiceEx", "Failed call withing calling.");
      AppMethodBeat.o(115174);
      return -1;
    }
    this.CvT = paramString;
    this.Cpd.Csj.CwG = 1;
    this.Cpd.Csj.gpK = paramString;
    com.tencent.mm.plugin.voip.b.f.Logd("MicroMsg.Voip.VoipServiceEx", com.tencent.mm.compatible.util.f.abr() + "call username:" + paramString);
    if (this.Cpd.Csj.eCf())
    {
      com.tencent.mm.plugin.voip.b.f.Loge("MicroMsg.Voip.VoipServiceEx", com.tencent.mm.compatible.util.f.abr() + "v2protocal already init.");
      this.Cpd.Csj.tx(false);
      this.Cpd.Csj.reset();
    }
    if (this.Cpd.Csj.erf() < 0)
    {
      com.tencent.mm.plugin.voip.b.f.Loge("MicroMsg.Voip.VoipServiceEx", "Failed to init v2protocol.");
      AppMethodBeat.o(115174);
      return -1;
    }
    if (this.Cpd.Csj.CyK != null) {
      this.Cpd.Csj.CyK.Cpd = this.Cpd;
    }
    if (v2protocal.CyL != null) {
      v2protocal.CyL.a(this.Cpd);
    }
    this.CvY.ay(50000L, 50000L);
    this.Cpd.Csj.uXi = ((int)System.currentTimeMillis());
    LinkedList localLinkedList = new LinkedList();
    this.Cpd.aY(localLinkedList);
    this.Cpd.Csj.Cxs = ("invite:" + this.Cpd.Csj.Cxn + ":" + this.Cpd.Csj.Cxo);
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(paramString);
    new com.tencent.mm.plugin.voip.model.a.g(localArrayList, this.Cpd.Csj.field_peerId, this.Cpd.Csj.field_capInfo, this.Cpd.Csj.netType, paramInt, this.Cpd.Csj.uXi, localLinkedList).eBO();
    this.Cpd.setStatus(2);
    this.Cpd.Csl.pcM = 1;
    this.CvV.ay(60000L, 60000L);
    this.Cpd.Csj.CyH.CtY = System.currentTimeMillis();
    this.Cpd.Csj.CyH.beginTime = System.currentTimeMillis();
    this.Cpd.Csj.CyH.CtE = paramInt;
    com.tencent.mm.sdk.platformtools.ae.d("MicroMsg.Voip.VoipServiceEx", "iRoomType " + this.Cpd.Csj.CyH.CtE);
    this.Cpd.ezI();
    AppMethodBeat.o(115174);
    return 0;
  }
  
  public final int setNetSignalValue(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(115186);
    paramInt1 = this.Cpd.Csj.setNetSignalValue(paramInt1, paramInt2);
    AppMethodBeat.o(115186);
    return paramInt1;
  }
  
  public final void stop()
  {
    AppMethodBeat.i(115163);
    com.tencent.mm.sdk.platformtools.ae.i("MicroMsg.Voip.VoipServiceEx", "stop");
    reset();
    this.Cpd.a(null);
    AppMethodBeat.o(115163);
  }
  
  public final void stopRing()
  {
    AppMethodBeat.i(115194);
    if (this.ped != null) {
      this.ped.stop();
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
        v.zC(WifiManager.calculateSignalLevel(v.h(v.this).getRssi(), 10));
        if (v.bJS() > 10)
        {
          v.zC(i);
          if (v.bJS() >= 0) {
            break label180;
          }
          i = 0;
          label117:
          v.zC(i);
          v.zC(v.bJS() * 10);
        }
      }
      for (;;)
      {
        if (v.bJS() != -1) {
          break label195;
        }
        if (v.i(v.this) <= 1) {
          v.UZ(-1);
        }
        v.this.setNetSignalValue(1, v.CvJ);
        AppMethodBeat.o(115161);
        return;
        i = v.bJS();
        break;
        label180:
        i = v.bJS();
        break label117;
        v.zC(-1);
      }
      label195:
      v.this.setNetSignalValue(2, v.bJS());
      AppMethodBeat.o(115161);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.voip.model.v
 * JD-Core Version:    0.7.0.1
 */