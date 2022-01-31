package com.tencent.mm.plugin.voip.model;

import android.content.Context;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import android.os.Looper;
import android.telephony.TelephonyManager;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.e.ac;
import com.tencent.mm.kernel.e;
import com.tencent.mm.plugin.voip.model.a.c;
import com.tencent.mm.plugin.voip.model.a.i;
import com.tencent.mm.protocal.protobuf.csp;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.ap;
import com.tencent.mm.sdk.platformtools.ap.a;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.storage.bi;
import com.tencent.mm.storage.bs;
import java.util.ArrayList;
import java.util.List;
import java.util.Timer;

public final class u
  implements k.a
{
  private static int hIe = -1;
  private static int tzn = -1;
  static int tzo = 20;
  WifiManager bsO;
  public k ttm;
  private Object tzk;
  com.tencent.mm.plugin.voip.video.h tzl;
  private int tzm;
  public String tzp;
  int tzq;
  Timer tzr;
  WifiInfo tzs;
  private ap tzt;
  private byte[] tzu;
  ap tzv;
  private ap tzw;
  private ap tzx;
  
  public u()
  {
    AppMethodBeat.i(4649);
    this.tzk = new Object();
    this.tzm = 0;
    this.tzr = null;
    this.tzt = new ap(Looper.getMainLooper(), new u.1(this), false);
    this.tzu = new byte[500];
    this.tzv = new ap(Looper.getMainLooper(), new u.2(this), true);
    this.tzw = new ap(Looper.getMainLooper(), new u.3(this), true);
    this.tzx = new ap(Looper.getMainLooper(), new ap.a()
    {
      public final boolean onTimerExpired()
      {
        AppMethodBeat.i(4646);
        ab.i("MicroMsg.Voip.VoipServiceEx", "voip called out of time,now destroy...");
        if ((3 == u.this.ttm.mStatus) && (u.d(u.this) != 0) && (u.d(u.this) == u.this.ttm.tvj.nMZ))
        {
          u.e(u.this);
          u.this.ttm.y(5, -9000, "");
        }
        AppMethodBeat.o(4646);
        return false;
      }
    }, true);
    this.ttm = l.cMn();
    this.ttm.a(this);
    this.tzl = new com.tencent.mm.plugin.voip.video.h(ah.getContext());
    AppMethodBeat.o(4649);
  }
  
  public static void a(int paramInt1, long paramLong, int paramInt2, byte[] paramArrayOfByte1, byte[] paramArrayOfByte2, String paramString)
  {
    AppMethodBeat.i(4668);
    com.tencent.mm.plugin.voip.a.a.Logi("MicroMsg.Voip.VoipServiceEx", "doAck roomId " + paramInt1 + "  roomKey " + paramLong + " status " + paramInt2);
    if ((paramInt1 != 0) && (paramLong != 0L)) {
      new com.tencent.mm.plugin.voip.model.a.a(paramInt1, paramLong, paramInt2, paramArrayOfByte1, paramArrayOfByte2, paramString).cOs();
    }
    AppMethodBeat.o(4668);
  }
  
  private void cOb()
  {
    AppMethodBeat.i(4653);
    ab.d("MicroMsg.Voip.VoipServiceEx", "reset");
    this.tzw.stopTimer();
    this.tzt.stopTimer();
    this.tzv.stopTimer();
    this.tzx.stopTimer();
    this.tzm = 0;
    AppMethodBeat.o(4653);
  }
  
  public static boolean cOd()
  {
    AppMethodBeat.i(4656);
    if (((TelephonyManager)ah.getContext().getSystemService("phone")).getCallState() != 0)
    {
      AppMethodBeat.o(4656);
      return true;
    }
    AppMethodBeat.o(4656);
    return false;
  }
  
  public final void HA(int paramInt)
  {
    AppMethodBeat.i(4675);
    if (this.tzl != null) {
      this.tzl.HA(paramInt);
    }
    AppMethodBeat.o(4675);
  }
  
  public final void HB(int paramInt)
  {
    AppMethodBeat.i(4679);
    this.tzm = paramInt;
    if (!this.tzx.dtj()) {
      this.tzx.stopTimer();
    }
    this.tzx.ag(70000L, 70000L);
    AppMethodBeat.o(4679);
  }
  
  public final void Hk(int paramInt)
  {
    AppMethodBeat.i(4670);
    this.ttm.Hk(paramInt);
    AppMethodBeat.o(4670);
  }
  
  public final void Hz(int paramInt)
  {
    AppMethodBeat.i(4654);
    this.ttm.Hg(paramInt);
    AppMethodBeat.o(4654);
  }
  
  public final int T(boolean paramBoolean1, boolean paramBoolean2)
  {
    AppMethodBeat.i(4663);
    cOn();
    if (!this.tzx.dtj()) {
      this.tzx.stopTimer();
    }
    this.ttm.tvj.tBN.cMu();
    ab.i("MicroMsg.Voip.VoipServiceEx", "accept onlyAudio:".concat(String.valueOf(paramBoolean1)));
    if (!this.ttm.cLZ())
    {
      com.tencent.mm.plugin.voip.a.a.Loge("MicroMsg.Voip.VoipServiceEx", "Failed to accept with calling, status =" + this.ttm.mStatus);
      AppMethodBeat.o(4663);
      return -1;
    }
    if (this.ttm.tvj.nMZ == 0)
    {
      com.tencent.mm.plugin.voip.a.a.Loge("MicroMsg.Voip.VoipServiceEx", "Failed to accept with roomid = 0. ");
      AppMethodBeat.o(4663);
      return -1;
    }
    com.tencent.mm.plugin.voip.a.a.Logd("MicroMsg.Voip.VoipServiceEx", com.tencent.mm.compatible.util.g.Ml() + "accept invite, roomid:" + this.ttm.tvj.nMZ);
    this.tzw.ag(50000L, 50000L);
    this.ttm.tvj.tBN.cMv();
    new com.tencent.mm.plugin.voip.model.a.b(1, this.ttm.tvj.netType, this.ttm.tvj.nMZ, this.ttm.tvj.field_peerId, this.ttm.tvj.field_capInfo, this.ttm.tvj.nNa, paramBoolean1, paramBoolean2).cOs();
    this.ttm.setStatus(4);
    this.ttm.tvl.kJF = 1;
    this.ttm.cDO = true;
    AppMethodBeat.o(4663);
    return 0;
  }
  
  public final boolean a(csp paramcsp)
  {
    int i = 1;
    AppMethodBeat.i(4662);
    if (this.ttm.cMa())
    {
      com.tencent.mm.plugin.voip.a.a.Loge("MicroMsg.Voip.VoipServiceEx", "Failed to setInviteContent during calling, status =" + this.ttm.mStatus);
      AppMethodBeat.o(4662);
      return false;
    }
    if (paramcsp == null)
    {
      AppMethodBeat.o(4662);
      return false;
    }
    this.ttm.tvj.tBN.twm = paramcsp.yaX;
    ab.d("MicroMsg.Voip.VoipServiceEx", "iRoomType " + this.ttm.tvj.tBN.twm);
    if (this.ttm.tvj.cOG())
    {
      com.tencent.mm.plugin.voip.a.a.Logw("MicroMsg.Voip.VoipServiceEx", com.tencent.mm.compatible.util.g.Ml() + "v2protocal already init.");
      this.ttm.tvj.mX(false);
      this.ttm.tvj.reset();
    }
    this.ttm.a(paramcsp);
    if ((com.tencent.mm.plugin.voip.a.d.cPu()) || (com.tencent.mm.r.a.Ok()) || (com.tencent.mm.plugin.voip.a.d.cPw()))
    {
      ab.e("MicroMsg.Voip.VoipServiceEx", "setInviteContent, reject, pstn/multitak/f2f talking");
      if (com.tencent.mm.plugin.voip.a.d.cPu())
      {
        a(paramcsp.wQP, paramcsp.wQQ, 2, null, null, paramcsp.ybf);
        AppMethodBeat.o(4662);
        return false;
      }
      cOh();
      label258:
      String str;
      if (paramcsp.yaX == 0)
      {
        str = paramcsp.ybf;
        if (i == 0) {
          break label297;
        }
      }
      label297:
      for (paramcsp = bi.yOc;; paramcsp = bi.yOb)
      {
        r.a(str, paramcsp, 0, 6, ah.getContext().getString(2131304631));
        break;
        i = 0;
        break label258;
      }
    }
    if (this.ttm.tvj.cHn() < 0)
    {
      com.tencent.mm.plugin.voip.a.a.Loge("MicroMsg.Voip.VoipServiceEx", "Failed to init v2protocol.");
      AppMethodBeat.o(4662);
      return false;
    }
    if (v2protocal.tBP != null) {
      v2protocal.tBP.a(this.ttm);
    }
    com.tencent.mm.plugin.report.service.h.qsU.a(11524, true, true, new Object[] { Integer.valueOf(paramcsp.wQP), Long.valueOf(paramcsp.wQQ), Integer.valueOf(paramcsp.yaX), Integer.valueOf(0), Long.valueOf(System.currentTimeMillis()) });
    this.ttm.tvk.cMX();
    AppMethodBeat.o(4662);
    return true;
  }
  
  public final int cLL()
  {
    AppMethodBeat.i(156771);
    int i = this.ttm.cLL();
    AppMethodBeat.o(156771);
    return i;
  }
  
  public final boolean cMa()
  {
    AppMethodBeat.i(4655);
    if (this.ttm.cMa())
    {
      AppMethodBeat.o(4655);
      return true;
    }
    AppMethodBeat.o(4655);
    return false;
  }
  
  public final boolean cOc()
  {
    return this.ttm.tvj.nMZ != 0;
  }
  
  public final void cOe()
  {
    AppMethodBeat.i(4657);
    if (this.ttm.cMa()) {
      com.tencent.mm.plugin.voip.a.a.Loge("MicroMsg.Voip.VoipServiceEx", "checkStartup failed, stauts = " + this.ttm.mStatus);
    }
    com.tencent.mm.plugin.voip.a.a.Loge("MicroMsg.Voip.VoipServiceEx", "checkStartup...devicekey = " + bs.dyO());
    this.ttm.cLW();
    cOb();
    ac.ll(com.tencent.mm.kernel.g.RL().Rv().dyM());
    AppMethodBeat.o(4657);
  }
  
  public final int cOf()
  {
    int i = 2;
    AppMethodBeat.i(4660);
    ab.i("MicroMsg.Voip.VoipServiceEx", "cancelCall, roomId:" + this.ttm.tvj.nMZ);
    if ((this.ttm.tvj.nMZ == 0) && (this.ttm.tvj.nNc == 0))
    {
      reset();
      AppMethodBeat.o(4660);
      return -1;
    }
    this.ttm.tvj.tBN.twb = this.ttm.cLY();
    this.ttm.tvj.tBN.twn = 3;
    if (this.ttm.mStatus < 6) {
      this.ttm.tvj.tBN.twp = 1;
    }
    com.tencent.mm.plugin.report.service.h localh = com.tencent.mm.plugin.report.service.h.qsU;
    int j = com.tencent.mm.plugin.voip.b.cLC().cNU();
    long l1 = com.tencent.mm.plugin.voip.b.cLC().cNV();
    long l2 = com.tencent.mm.plugin.voip.b.cLC().cMb();
    if (this.ttm.mStatus == 5) {}
    for (;;)
    {
      localh.a(11521, true, true, new Object[] { Integer.valueOf(j), Long.valueOf(l1), Long.valueOf(l2), Integer.valueOf(i), Long.valueOf(System.currentTimeMillis()), Long.valueOf(System.currentTimeMillis()) });
      i = cOg();
      AppMethodBeat.o(4660);
      return i;
      i = 1;
    }
  }
  
  public final int cOg()
  {
    AppMethodBeat.i(4661);
    if (!this.ttm.cMa())
    {
      com.tencent.mm.plugin.voip.a.a.Loge("MicroMsg.Voip.VoipServiceEx", "Failed to cancel call ,as not in calling.");
      AppMethodBeat.o(4661);
      return -1;
    }
    ab.i("MicroMsg.Voip.VoipServiceEx", "cancelCallEx, roomId:%d, msgID:%d, inviteId:%d", new Object[] { Integer.valueOf(this.ttm.tvj.nMZ), Integer.valueOf(this.ttm.tvj.tzY), Integer.valueOf(this.ttm.tvj.nNc) });
    synchronized (this.tzk)
    {
      if ((this.ttm.tvj.nMZ == 0) && (this.ttm.tvj.nNc == 0))
      {
        com.tencent.mm.plugin.voip.a.a.Loge("MicroMsg.Voip.VoipServiceEx", "Failed to cancel call with roomid = 0 and inviteId = 0 ");
        AppMethodBeat.o(4661);
        return -1;
      }
      if (this.ttm.tvj.cOG())
      {
        localObject2 = this.ttm.tvj.mX(true);
        if (((String)localObject2).length() > 0) {
          new c(this.ttm.tvj.nMZ, this.ttm.tvj.nNa, this.ttm.tvj.ocN, (String)localObject2, this.ttm.tvj.nNc).cOs();
        }
      }
      Object localObject2 = this.ttm.tvj.tBN;
      ((n)localObject2).tww = ((int)(System.currentTimeMillis() - ((n)localObject2).twG));
      com.tencent.mm.plugin.voip.a.a.Logd("MicroMsg.VoipDailReport", "devin:cancelInvite:" + ((n)localObject2).tww);
      if ((this.ttm.tvj.tAr == 0) && (this.ttm.tvj.tAs == 0)) {
        this.ttm.cLX();
      }
      this.ttm.Hi(this.tzl.cPO());
      this.ttm.tvj.tBN.twL = this.ttm.tvk.cNf();
      if (com.tencent.mm.plugin.voip.b.cLC().tyS != null)
      {
        this.ttm.tvj.tBN.twO = com.tencent.mm.plugin.voip.b.cLC().tyS.txR;
        this.ttm.tvj.tBN.twM = (com.tencent.mm.plugin.voip.b.cLC().tyS.twM / 1000L);
        this.ttm.tvj.tBN.twN = (com.tencent.mm.plugin.voip.b.cLC().tyS.twN / 1000L);
      }
      localObject2 = v2protocal.cOK();
      String str1 = this.ttm.tvj.cOL();
      String str2 = this.ttm.tvj.cON();
      String str3 = this.ttm.tvj.cOC();
      String str4 = this.ttm.tvj.cOE();
      String[] arrayOfString = this.ttm.tvj.cOM();
      if (str1.length() > 0) {
        new com.tencent.mm.plugin.voip.model.a.l((String)localObject2, str1, str3, str2, str4, arrayOfString).cOs();
      }
      this.ttm.cLV();
      reset();
      this.ttm.tvj.nMZ = 0;
      this.ttm.tvj.nNc = 0;
      AppMethodBeat.o(4661);
      return 0;
    }
  }
  
  public final int cOh()
  {
    AppMethodBeat.i(4664);
    ab.i("MicroMsg.Voip.VoipServiceEx", "reject");
    if (!this.ttm.cLZ())
    {
      com.tencent.mm.plugin.voip.a.a.Loge("MicroMsg.Voip.VoipServiceEx", "Failed to reject with calling, status =" + this.ttm.mStatus);
      AppMethodBeat.o(4664);
      return -1;
    }
    synchronized (this.tzk)
    {
      if (this.ttm.tvj.nMZ == 0)
      {
        com.tencent.mm.plugin.voip.a.a.Loge("MicroMsg.Voip.VoipServiceEx", "Failed to reject with roomid = 0. ");
        AppMethodBeat.o(4664);
        return -1;
      }
      this.ttm.tvj.tBN.cMv();
      com.tencent.mm.plugin.voip.a.a.Logd("MicroMsg.Voip.VoipServiceEx", " reject, status:" + this.ttm.mStatus + " roomid:" + this.ttm.tvj.nMZ);
      int i = this.ttm.tvj.netType;
      int j = this.ttm.tvj.nMZ;
      long l = this.ttm.tvj.nNa;
      new com.tencent.mm.plugin.voip.model.a.b(2, i, j, new byte[0], new byte[0], l, false, false).cOs();
      if ((this.ttm.tvj.tAr == 0) && (this.ttm.tvj.tAs == 0)) {
        this.ttm.cLX();
      }
      this.ttm.Hi(this.tzl.cPO());
      this.ttm.tvj.tBN.twL = this.ttm.tvk.cNf();
      if (com.tencent.mm.plugin.voip.b.cLC().tyS != null)
      {
        this.ttm.tvj.tBN.twO = com.tencent.mm.plugin.voip.b.cLC().tyS.txR;
        this.ttm.tvj.tBN.twM = (com.tencent.mm.plugin.voip.b.cLC().tyS.twM / 1000L);
        this.ttm.tvj.tBN.twN = (com.tencent.mm.plugin.voip.b.cLC().tyS.twN / 1000L);
      }
      if (this.ttm.tvj.cOG()) {
        this.ttm.tvj.mX(true);
      }
      String str1 = v2protocal.cOK();
      String str2 = this.ttm.tvj.cOL();
      String str3 = this.ttm.tvj.cON();
      String str4 = this.ttm.tvj.cOC();
      String str5 = this.ttm.tvj.cOE();
      String[] arrayOfString = this.ttm.tvj.cOM();
      com.tencent.mm.plugin.voip.a.a.Logd("MicroMsg.Voip.VoipServiceEx", "devin: statreport");
      if (str2.length() > 0)
      {
        com.tencent.mm.plugin.voip.a.a.Logd("MicroMsg.Voip.VoipServiceEx", "devin: reject() newdialInfo.length() > 0");
        new com.tencent.mm.plugin.voip.model.a.l(str1, str2, str4, str3, str5, arrayOfString).cOs();
        this.ttm.cLV();
        reset();
        this.ttm.tvj.nMZ = 0;
        AppMethodBeat.o(4664);
        return 0;
      }
      com.tencent.mm.plugin.voip.a.a.Logd("MicroMsg.Voip.VoipServiceEx", "devin: reject() newdialInfo.length() <= 0");
    }
  }
  
  public final int cOi()
  {
    AppMethodBeat.i(4665);
    ab.i("MicroMsg.Voip.VoipServiceEx", "hangUp");
    if (this.ttm.tvj.nMZ == 0)
    {
      this.ttm.tvl.cMp();
      reset();
      AppMethodBeat.o(4665);
      return 0;
    }
    this.ttm.tvj.tBN.twb = this.ttm.cLY();
    int i = cOj();
    AppMethodBeat.o(4665);
    return i;
  }
  
  public final int cOj()
  {
    AppMethodBeat.i(4666);
    com.tencent.mm.plugin.voip.a.a.Logi("MicroMsg.Voip.VoipServiceEx", "hangUp,status:" + this.ttm.mStatus + " roomid:" + this.ttm.tvj.nMZ + ",threadid = " + Thread.currentThread().getId());
    this.ttm.tvl.cMp();
    if (this.ttm.tvj.tBN.twl == 1)
    {
      ??? = this.ttm.tvj.tBN;
      if (((n)???).twC != 0L) {
        break label591;
      }
      ((n)???).twv = 0;
    }
    for (;;)
    {
      if (((n)???).twv < 0)
      {
        ((n)???).twv = 0;
        com.tencent.mm.plugin.voip.a.a.Loge("MicroMsg.VoipDailReport", "devin:endTalk, iCallTime Err, rest 0");
      }
      com.tencent.mm.plugin.voip.a.a.Logi("MicroMsg.VoipDailReport", "devin:endTalk:" + ((n)???).twv);
      synchronized (this.tzk)
      {
        int i = this.ttm.tvj.tBN.twn;
        if ((this.ttm.tvj.nMZ != 0) || (8 == i) || (9 == i) || (10 == i) || (11 == i) || (12 == i) || (99 == i))
        {
          this.ttm.tvk.cNc();
          com.tencent.mm.plugin.voip.a.a.Logi("MicroMsg.Voip.VoipServiceEx", "steve:hangUp, uninitGLRender before protocalUninit first!!");
          if (this.ttm.tvj.cOG())
          {
            str1 = this.ttm.tvj.mX(true);
            if (str1.length() > 0)
            {
              new i(this.ttm.tvj.nMZ, this.ttm.tvj.nNa, str1).cOs();
              com.tencent.mm.plugin.voip.a.a.Loge("MicroMsg.Voip.VoipServiceEx", "devin: shutdown cgi ");
            }
          }
          this.ttm.tvj.tBN.twL = this.ttm.tvk.cNf();
          if (com.tencent.mm.plugin.voip.b.cLC().tyS != null)
          {
            this.ttm.tvj.tBN.twO = com.tencent.mm.plugin.voip.b.cLC().tyS.txR;
            this.ttm.tvj.tBN.twM = (com.tencent.mm.plugin.voip.b.cLC().tyS.twM / 1000L);
            this.ttm.tvj.tBN.twN = (com.tencent.mm.plugin.voip.b.cLC().tyS.twN / 1000L);
          }
          this.ttm.Hi(this.tzl.cPO());
          String str1 = v2protocal.cOK();
          String str2 = this.ttm.tvj.cOL();
          String str3 = this.ttm.tvj.cON();
          String str4 = this.ttm.tvj.cOC();
          String str5 = this.ttm.tvj.cOE();
          String[] arrayOfString = this.ttm.tvj.cOM();
          if (str2.length() > 0)
          {
            new com.tencent.mm.plugin.voip.model.a.l(str1, str2, str4, str3, str5, arrayOfString).cOs();
            com.tencent.mm.plugin.voip.a.a.Loge("MicroMsg.Voip.VoipServiceEx", "devin: statreport cgi ");
          }
          this.ttm.cLV();
          reset();
          this.ttm.tvj.nMZ = 0;
          com.tencent.mm.plugin.voip.a.a.Logd("MicroMsg.Voip.VoipServiceEx", "hangUp over");
          AppMethodBeat.o(4666);
          return 0;
          label591:
          ((n)???).twv = ((int)((System.currentTimeMillis() - ((n)???).twC) / 1000L));
          continue;
        }
        com.tencent.mm.plugin.voip.a.a.Loge("MicroMsg.Voip.VoipServiceEx", "call hangUp roomId == 0 ");
      }
    }
  }
  
  public final int cOk()
  {
    AppMethodBeat.i(4667);
    ab.i("MicroMsg.Voip.VoipServiceEx", "ignoreInvite");
    if (!this.ttm.cLZ())
    {
      com.tencent.mm.plugin.voip.a.a.Loge("MicroMsg.Voip.VoipServiceEx", "Failed to ignore with calling, status =" + this.ttm.mStatus);
      AppMethodBeat.o(4667);
      return -1;
    }
    synchronized (this.tzk)
    {
      if (this.ttm.tvj.nMZ == 0)
      {
        com.tencent.mm.plugin.voip.a.a.Loge("MicroMsg.Voip.VoipServiceEx", "Failed to reject with roomid = 0. ");
        AppMethodBeat.o(4667);
        return -1;
      }
      int i = this.ttm.tvj.netType;
      int j = this.ttm.tvj.nMZ;
      long l = this.ttm.tvj.nNa;
      new com.tencent.mm.plugin.voip.model.a.b(3, i, j, new byte[0], new byte[0], l, false, false).cOs();
      reset();
      this.ttm.tvj.nMZ = 0;
      AppMethodBeat.o(4667);
      return 0;
    }
  }
  
  public final void cOl()
  {
    AppMethodBeat.i(4676);
    if (this.tzl != null) {
      this.tzl.r(2131232179, 0, false);
    }
    AppMethodBeat.o(4676);
  }
  
  public final boolean cOm()
  {
    AppMethodBeat.i(4678);
    if (this.tzl != null)
    {
      boolean bool = this.tzl.Dt();
      AppMethodBeat.o(4678);
      return bool;
    }
    AppMethodBeat.o(4678);
    return true;
  }
  
  public final void cOn()
  {
    AppMethodBeat.i(4680);
    com.tencent.mm.plugin.voip.a.a.Logi("MicroMsg.Voip.VoipServiceEx", "devincdai: voip reset timecount");
    this.tzt.stopTimer();
    this.tzt.ag(60000L, 60000L);
    AppMethodBeat.o(4680);
  }
  
  public final int dB(String paramString, int paramInt)
  {
    AppMethodBeat.i(4659);
    ab.i("MicroMsg.Voip.VoipServiceEx", "call username:%s, callType:%d, inviteType:%d", new Object[] { paramString, Integer.valueOf(0), Integer.valueOf(paramInt) });
    if (bo.isNullOrNil(paramString))
    {
      com.tencent.mm.plugin.voip.a.a.Loge("MicroMsg.Voip.VoipServiceEx", "Failed call without valid username.");
      AppMethodBeat.o(4659);
      return -1;
    }
    if (this.ttm.cMa())
    {
      com.tencent.mm.plugin.voip.a.a.Loge("MicroMsg.Voip.VoipServiceEx", "Failed call withing calling.");
      AppMethodBeat.o(4659);
      return -1;
    }
    this.ttm.tvj.tAa = 1;
    this.ttm.tvj.ocN = paramString;
    com.tencent.mm.plugin.voip.a.a.Logd("MicroMsg.Voip.VoipServiceEx", com.tencent.mm.compatible.util.g.Ml() + "call username:" + paramString);
    if (this.ttm.tvj.cOG())
    {
      com.tencent.mm.plugin.voip.a.a.Loge("MicroMsg.Voip.VoipServiceEx", com.tencent.mm.compatible.util.g.Ml() + "v2protocal already init.");
      this.ttm.tvj.mX(false);
      this.ttm.tvj.reset();
    }
    if (this.ttm.tvj.cHn() < 0)
    {
      com.tencent.mm.plugin.voip.a.a.Loge("MicroMsg.Voip.VoipServiceEx", "Failed to init v2protocol.");
      AppMethodBeat.o(4659);
      return -1;
    }
    if (this.ttm.tvj.tBO != null) {
      this.ttm.tvj.tBO.ttm = this.ttm;
    }
    if (v2protocal.tBP != null) {
      v2protocal.tBP.a(this.ttm);
    }
    this.tzw.ag(50000L, 50000L);
    this.ttm.tvj.nNc = ((int)System.currentTimeMillis());
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(paramString);
    new com.tencent.mm.plugin.voip.model.a.g(localArrayList, this.ttm.tvj.field_peerId, this.ttm.tvj.field_capInfo, this.ttm.tvj.netType, paramInt, this.ttm.tvj.nNc).cOs();
    this.ttm.setStatus(2);
    this.ttm.tvl.kJF = 1;
    this.tzt.ag(60000L, 60000L);
    this.ttm.tvj.tBN.twG = System.currentTimeMillis();
    this.ttm.tvj.tBN.beginTime = System.currentTimeMillis();
    this.ttm.tvj.tBN.twm = paramInt;
    ab.d("MicroMsg.Voip.VoipServiceEx", "iRoomType " + this.ttm.tvj.tBN.twm);
    AppMethodBeat.o(4659);
    return 0;
  }
  
  protected final void finalize()
  {
    AppMethodBeat.i(4651);
    stop();
    super.finalize();
    AppMethodBeat.o(4651);
  }
  
  public final boolean mJ(boolean paramBoolean)
  {
    AppMethodBeat.i(4672);
    paramBoolean = this.ttm.tvl.mJ(paramBoolean);
    AppMethodBeat.o(4672);
    return paramBoolean;
  }
  
  public final int mO(boolean paramBoolean)
  {
    AppMethodBeat.i(4673);
    int i = this.ttm.mO(paramBoolean);
    AppMethodBeat.o(4673);
    return i;
  }
  
  public final int mP(boolean paramBoolean)
  {
    AppMethodBeat.i(4674);
    int i = this.ttm.mP(paramBoolean);
    AppMethodBeat.o(4674);
    return i;
  }
  
  public final void reset()
  {
    AppMethodBeat.i(4652);
    ab.d("MicroMsg.Voip.VoipServiceEx", "reset");
    this.ttm.reset();
    this.tzw.stopTimer();
    this.tzt.stopTimer();
    this.tzv.stopTimer();
    this.tzx.stopTimer();
    if (this.tzr != null)
    {
      this.tzr.cancel();
      this.tzr = null;
    }
    this.tzm = 0;
    com.tencent.mm.plugin.voip.b.cLC().txI = null;
    AppMethodBeat.o(4652);
  }
  
  public final int setNetSignalValue(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(4669);
    paramInt1 = this.ttm.tvj.setNetSignalValue(paramInt1, paramInt2);
    AppMethodBeat.o(4669);
    return paramInt1;
  }
  
  public final void stop()
  {
    AppMethodBeat.i(4650);
    ab.i("MicroMsg.Voip.VoipServiceEx", "stop");
    reset();
    this.ttm.a(null);
    AppMethodBeat.o(4650);
  }
  
  public final void stopRing()
  {
    AppMethodBeat.i(4677);
    if (this.tzl != null) {
      this.tzl.stop();
    }
    AppMethodBeat.o(4677);
  }
  
  public final void y(int paramInt1, int paramInt2, String paramString)
  {
    AppMethodBeat.i(4658);
    ab.i("MicroMsg.Voip.VoipServiceEx", "onFinishVoIP finishType: ".concat(String.valueOf(paramInt1)));
    switch (paramInt1)
    {
    }
    for (;;)
    {
      AppMethodBeat.o(4658);
      return;
      cOj();
      this.ttm.tvk.onReject();
      AppMethodBeat.o(4658);
      return;
      cOj();
      this.ttm.tvk.cMZ();
      AppMethodBeat.o(4658);
      return;
      cOj();
      this.ttm.tvk.cNb();
      AppMethodBeat.o(4658);
      return;
      cOj();
      this.ttm.tvk.onError(paramInt2, paramString);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.voip.model.u
 * JD-Core Version:    0.7.0.1
 */