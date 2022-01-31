package com.tencent.mm.plugin.voip.model;

import android.content.Context;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import android.os.Looper;
import android.telephony.TelephonyManager;
import com.tencent.mm.compatible.e.q;
import com.tencent.mm.kernel.e;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.am;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.storage.bs;
import java.util.ArrayList;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

public final class s
  implements j.a
{
  private static int goh = -1;
  private static int pTL = -1;
  static int pTM = 20;
  WifiManager bci;
  public j pNq = k.bQj();
  private Object pTI = new Object();
  com.tencent.mm.plugin.voip.video.i pTJ;
  int pTK = 0;
  public String pTN;
  int pTO;
  Timer pTP = null;
  WifiInfo pTQ;
  private am pTR = new am(Looper.getMainLooper(), new s.1(this), false);
  private byte[] pTS = new byte[500];
  am pTT = new am(Looper.getMainLooper(), new s.2(this), true);
  am pTU = new am(Looper.getMainLooper(), new s.3(this), true);
  am pTV = new am(Looper.getMainLooper(), new s.4(this), true);
  
  public s()
  {
    this.pNq.a(this);
    this.pTJ = new com.tencent.mm.plugin.voip.video.i(ae.getContext());
  }
  
  public static void a(int paramInt1, long paramLong, int paramInt2, byte[] paramArrayOfByte1, byte[] paramArrayOfByte2, String paramString)
  {
    com.tencent.mm.plugin.voip.a.a.Logi("MicroMsg.Voip.VoipServiceEx", "doAck roomId " + paramInt1 + "  roomKey " + paramLong + " status " + paramInt2);
    if ((paramInt1 != 0) && (paramLong != 0L)) {
      new com.tencent.mm.plugin.voip.model.a.a(paramInt1, paramLong, paramInt2, paramArrayOfByte1, paramArrayOfByte2, paramString).bRB();
    }
  }
  
  public static boolean bRq()
  {
    return ((TelephonyManager)ae.getContext().getSystemService("phone")).getCallState() != 0;
  }
  
  public final boolean bPW()
  {
    return this.pNq.bPW();
  }
  
  public final boolean bRp()
  {
    return this.pNq.pQe.lpD != 0;
  }
  
  public final void bRr()
  {
    if (this.pNq.bPW()) {
      com.tencent.mm.plugin.voip.a.a.Loge("MicroMsg.Voip.VoipServiceEx", "checkStartup failed, stauts = " + this.pNq.mStatus);
    }
    com.tencent.mm.plugin.voip.a.a.Loge("MicroMsg.Voip.VoipServiceEx", "checkStartup...devicekey = " + bs.cwc());
    this.pNq.bPS();
    y.d("MicroMsg.Voip.VoipServiceEx", "reset");
    this.pNq.reset();
    this.pTU.stopTimer();
    this.pTR.stopTimer();
    this.pTT.stopTimer();
    this.pTV.stopTimer();
    this.pTK = 0;
    q.fa(com.tencent.mm.kernel.g.DP().DA().cwa());
  }
  
  public final int bRs()
  {
    if (!this.pNq.bPW())
    {
      com.tencent.mm.plugin.voip.a.a.Loge("MicroMsg.Voip.VoipServiceEx", "Failed to cancel call ,as not in calling.");
      return -1;
    }
    y.i("MicroMsg.Voip.VoipServiceEx", "cancelCallEx, roomId:%d, msgID:%d, inviteId:%d", new Object[] { Integer.valueOf(this.pNq.pQe.lpD), Integer.valueOf(this.pNq.pQe.pUw), Integer.valueOf(this.pNq.pQe.lpG) });
    synchronized (this.pTI)
    {
      if ((this.pNq.pQe.lpD == 0) && (this.pNq.pQe.lpG == 0))
      {
        com.tencent.mm.plugin.voip.a.a.Loge("MicroMsg.Voip.VoipServiceEx", "Failed to cancel call with roomid = 0 and inviteId = 0 ");
        return -1;
      }
    }
    Object localObject3 = this.pNq.pQe.kb(true);
    int i;
    long l;
    if (((String)localObject3).length() > 0)
    {
      i = this.pNq.pQe.lpD;
      l = this.pNq.pQe.lpE;
      int j = this.pNq.pQe.pUw;
      new com.tencent.mm.plugin.voip.model.a.c(i, l, this.pNq.pQe.lFA, (String)localObject3, this.pNq.pQe.lpG).bRB();
    }
    localObject3 = this.pNq.pQe.pWi;
    ((m)localObject3).pRp = ((int)(System.currentTimeMillis() - ((m)localObject3).pRz));
    com.tencent.mm.plugin.voip.a.a.Logd("MicroMsg.VoipDailReport", "devin:cancelInvite:" + ((m)localObject3).pRp);
    if ((this.pNq.pQe.pUP == 0) && (this.pNq.pQe.pUQ == 0)) {
      this.pNq.bPT();
    }
    this.pNq.zX(this.pTJ.bSB());
    this.pNq.pQe.pWi.pRE = this.pNq.pQf.bQN();
    if (com.tencent.mm.plugin.voip.b.bPx().pTr != null)
    {
      this.pNq.pQe.pWi.pRH = com.tencent.mm.plugin.voip.b.bPx().pTr.pSI;
      this.pNq.pQe.pWi.pRF = (com.tencent.mm.plugin.voip.b.bPx().pTr.pRF / 1000L);
      this.pNq.pQe.pWi.pRG = (com.tencent.mm.plugin.voip.b.bPx().pTr.pRG / 1000L);
    }
    localObject3 = v2protocal.bRL();
    String str1 = this.pNq.pQe.bRM();
    String str2 = this.pNq.pQe.bRP();
    String str3 = this.pNq.pQe.bRN();
    String str4 = this.pNq.pQe.bRQ();
    String[] arrayOfString = this.pNq.pQe.bRO();
    if (str1.length() > 0)
    {
      i = this.pNq.pQe.lpD;
      l = this.pNq.pQe.lpE;
      i = this.pNq.pQe.pUw;
      String str5 = this.pNq.pQe.lFA;
      new com.tencent.mm.plugin.voip.model.a.l((String)localObject3, str1, str3, str2, str4, arrayOfString).bRB();
    }
    this.pNq.bPR();
    reset();
    this.pNq.pQe.lpD = 0;
    this.pNq.pQe.lpG = 0;
    return 0;
  }
  
  public final int bRt()
  {
    y.i("MicroMsg.Voip.VoipServiceEx", "reject");
    if (!this.pNq.bPV())
    {
      com.tencent.mm.plugin.voip.a.a.Loge("MicroMsg.Voip.VoipServiceEx", "Failed to reject with calling, status =" + this.pNq.mStatus);
      return -1;
    }
    synchronized (this.pTI)
    {
      if (this.pNq.pQe.lpD == 0)
      {
        com.tencent.mm.plugin.voip.a.a.Loge("MicroMsg.Voip.VoipServiceEx", "Failed to reject with roomid = 0. ");
        return -1;
      }
    }
    this.pNq.pQe.pWi.bQm();
    com.tencent.mm.plugin.voip.a.a.Logd("MicroMsg.Voip.VoipServiceEx", " reject, status:" + this.pNq.mStatus + " roomid:" + this.pNq.pQe.lpD);
    int i = this.pNq.pQe.netType;
    int j = this.pNq.pQe.lpD;
    long l = this.pNq.pQe.lpE;
    new com.tencent.mm.plugin.voip.model.a.b(2, i, j, new byte[0], new byte[0], l, false, false).bRB();
    if ((this.pNq.pQe.pUP == 0) && (this.pNq.pQe.pUQ == 0)) {
      this.pNq.bPT();
    }
    this.pNq.zX(this.pTJ.bSB());
    this.pNq.pQe.pWi.pRE = this.pNq.pQf.bQN();
    if (com.tencent.mm.plugin.voip.b.bPx().pTr != null)
    {
      this.pNq.pQe.pWi.pRH = com.tencent.mm.plugin.voip.b.bPx().pTr.pSI;
      this.pNq.pQe.pWi.pRF = (com.tencent.mm.plugin.voip.b.bPx().pTr.pRF / 1000L);
      this.pNq.pQe.pWi.pRG = (com.tencent.mm.plugin.voip.b.bPx().pTr.pRG / 1000L);
    }
    this.pNq.pQe.kb(true);
    String str1 = v2protocal.bRL();
    String str2 = this.pNq.pQe.bRM();
    String str3 = this.pNq.pQe.bRP();
    String str4 = this.pNq.pQe.bRN();
    String str5 = this.pNq.pQe.bRQ();
    String[] arrayOfString = this.pNq.pQe.bRO();
    com.tencent.mm.plugin.voip.a.a.Logd("MicroMsg.Voip.VoipServiceEx", "devin: statreport");
    if (str2.length() > 0)
    {
      com.tencent.mm.plugin.voip.a.a.Logd("MicroMsg.Voip.VoipServiceEx", "devin: reject() newdialInfo.length() > 0");
      i = this.pNq.pQe.lpD;
      l = this.pNq.pQe.lpE;
      i = this.pNq.pQe.pUw;
      String str6 = this.pNq.pQe.lFA;
      new com.tencent.mm.plugin.voip.model.a.l(str1, str2, str4, str3, str5, arrayOfString).bRB();
    }
    for (;;)
    {
      this.pNq.bPR();
      reset();
      this.pNq.pQe.lpD = 0;
      return 0;
      com.tencent.mm.plugin.voip.a.a.Logd("MicroMsg.Voip.VoipServiceEx", "devin: reject() newdialInfo.length() <= 0");
    }
  }
  
  public final int bRu()
  {
    com.tencent.mm.plugin.voip.a.a.Logi("MicroMsg.Voip.VoipServiceEx", "hangUp,status:" + this.pNq.mStatus + " roomid:" + this.pNq.pQe.lpD + ",threadid = " + Thread.currentThread().getId());
    this.pNq.pQg.bQl();
    if (this.pNq.pQe.pWi.pRe == 1)
    {
      ??? = this.pNq.pQe.pWi;
      if (((m)???).pRv != 0L) {
        break label625;
      }
      ((m)???).pRo = 0;
    }
    for (;;)
    {
      if (((m)???).pRo < 0)
      {
        ((m)???).pRo = 0;
        com.tencent.mm.plugin.voip.a.a.Loge("MicroMsg.VoipDailReport", "devin:endTalk, iCallTime Err, rest 0");
      }
      com.tencent.mm.plugin.voip.a.a.Logi("MicroMsg.VoipDailReport", "devin:endTalk:" + ((m)???).pRo);
      synchronized (this.pTI)
      {
        int i = this.pNq.pQe.pWi.pRg;
        if ((this.pNq.pQe.lpD != 0) || (8 == i) || (9 == i) || (10 == i) || (11 == i) || (12 == i) || (99 == i))
        {
          this.pNq.pQf.bQK();
          com.tencent.mm.plugin.voip.a.a.Logi("MicroMsg.Voip.VoipServiceEx", "steve:hangUp, uninitGLRender before protocalUninit first!!");
          String str1 = this.pNq.pQe.kb(true);
          if (str1.length() > 0)
          {
            new com.tencent.mm.plugin.voip.model.a.i(this.pNq.pQe.lpD, this.pNq.pQe.lpE, str1).bRB();
            com.tencent.mm.plugin.voip.a.a.Loge("MicroMsg.Voip.VoipServiceEx", "devin: shutdown cgi ");
          }
          this.pNq.pQe.pWi.pRE = this.pNq.pQf.bQN();
          if (com.tencent.mm.plugin.voip.b.bPx().pTr != null)
          {
            this.pNq.pQe.pWi.pRH = com.tencent.mm.plugin.voip.b.bPx().pTr.pSI;
            this.pNq.pQe.pWi.pRF = (com.tencent.mm.plugin.voip.b.bPx().pTr.pRF / 1000L);
            this.pNq.pQe.pWi.pRG = (com.tencent.mm.plugin.voip.b.bPx().pTr.pRG / 1000L);
          }
          this.pNq.zX(this.pTJ.bSB());
          str1 = v2protocal.bRL();
          String str2 = this.pNq.pQe.bRM();
          String str3 = this.pNq.pQe.bRP();
          String str4 = this.pNq.pQe.bRN();
          String str5 = this.pNq.pQe.bRQ();
          String[] arrayOfString = this.pNq.pQe.bRO();
          if (str2.length() > 0)
          {
            i = this.pNq.pQe.lpD;
            long l = this.pNq.pQe.lpE;
            i = this.pNq.pQe.pUw;
            String str6 = this.pNq.pQe.lFA;
            new com.tencent.mm.plugin.voip.model.a.l(str1, str2, str4, str3, str5, arrayOfString).bRB();
            com.tencent.mm.plugin.voip.a.a.Loge("MicroMsg.Voip.VoipServiceEx", "devin: statreport cgi ");
          }
          this.pNq.bPR();
          reset();
          this.pNq.pQe.lpD = 0;
          com.tencent.mm.plugin.voip.a.a.Logd("MicroMsg.Voip.VoipServiceEx", "hangUp over");
          return 0;
          label625:
          ((m)???).pRo = ((int)((System.currentTimeMillis() - ((m)???).pRv) / 1000L));
          continue;
        }
        com.tencent.mm.plugin.voip.a.a.Loge("MicroMsg.Voip.VoipServiceEx", "call hangUp roomId == 0 ");
      }
    }
  }
  
  public final int bRv()
  {
    y.i("MicroMsg.Voip.VoipServiceEx", "ignoreInvite");
    if (!this.pNq.bPV())
    {
      com.tencent.mm.plugin.voip.a.a.Loge("MicroMsg.Voip.VoipServiceEx", "Failed to ignore with calling, status =" + this.pNq.mStatus);
      return -1;
    }
    synchronized (this.pTI)
    {
      if (this.pNq.pQe.lpD == 0)
      {
        com.tencent.mm.plugin.voip.a.a.Loge("MicroMsg.Voip.VoipServiceEx", "Failed to reject with roomid = 0. ");
        return -1;
      }
    }
    int i = this.pNq.pQe.netType;
    int j = this.pNq.pQe.lpD;
    long l = this.pNq.pQe.lpE;
    new com.tencent.mm.plugin.voip.model.a.b(3, i, j, new byte[0], new byte[0], l, false, false).bRB();
    reset();
    this.pNq.pQe.lpD = 0;
    return 0;
  }
  
  public final void bRw()
  {
    com.tencent.mm.plugin.voip.a.a.Logi("MicroMsg.Voip.VoipServiceEx", "devincdai: voip reset timecount");
    this.pTR.stopTimer();
    this.pTR.S(60000L, 60000L);
  }
  
  public final int cC(String paramString, int paramInt)
  {
    y.i("MicroMsg.Voip.VoipServiceEx", "call username:%s, callType:%d, inviteType:%d", new Object[] { paramString, Integer.valueOf(0), Integer.valueOf(paramInt) });
    if (bk.bl(paramString))
    {
      com.tencent.mm.plugin.voip.a.a.Loge("MicroMsg.Voip.VoipServiceEx", "Failed call without valid username.");
      return -1;
    }
    if (this.pNq.bPW())
    {
      com.tencent.mm.plugin.voip.a.a.Loge("MicroMsg.Voip.VoipServiceEx", "Failed call withing calling.");
      return -1;
    }
    this.pNq.pQe.pUz = 1;
    this.pNq.pQe.lFA = paramString;
    com.tencent.mm.plugin.voip.a.a.Logd("MicroMsg.Voip.VoipServiceEx", com.tencent.mm.compatible.util.g.zI() + "call username:" + paramString);
    if (this.pNq.pQe.isInited)
    {
      com.tencent.mm.plugin.voip.a.a.Loge("MicroMsg.Voip.VoipServiceEx", com.tencent.mm.compatible.util.g.zI() + "v2protocal already init.");
      this.pNq.pQe.kb(false);
      this.pNq.pQe.reset();
    }
    if (this.pNq.pQe.bMo() < 0)
    {
      com.tencent.mm.plugin.voip.a.a.Loge("MicroMsg.Voip.VoipServiceEx", "Failed to init v2protocol.");
      return -1;
    }
    if (this.pNq.pQe.pWj != null) {
      this.pNq.pQe.pWj.pNq = this.pNq;
    }
    if (v2protocal.pWk != null) {
      v2protocal.pWk.a(this.pNq);
    }
    this.pTU.S(50000L, 50000L);
    this.pNq.pQe.lpG = ((int)System.currentTimeMillis());
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(paramString);
    new com.tencent.mm.plugin.voip.model.a.g(localArrayList, this.pNq.pQe.field_peerId, this.pNq.pQe.field_capInfo, this.pNq.pQe.netType, paramInt, this.pNq.pQe.lpG).bRB();
    this.pNq.setStatus(2);
    this.pNq.pQg.iEu = 1;
    this.pTR.S(60000L, 60000L);
    this.pNq.pQe.pWi.pRz = System.currentTimeMillis();
    this.pNq.pQe.pWi.beginTime = System.currentTimeMillis();
    this.pNq.pQe.pWi.pRf = paramInt;
    y.d("MicroMsg.Voip.VoipServiceEx", "iRoomType " + this.pNq.pQe.pWi.pRf);
    return 0;
  }
  
  protected final void finalize()
  {
    stop();
    super.finalize();
  }
  
  public final void reset()
  {
    y.d("MicroMsg.Voip.VoipServiceEx", "reset");
    this.pNq.reset();
    this.pTU.stopTimer();
    this.pTR.stopTimer();
    this.pTT.stopTimer();
    this.pTV.stopTimer();
    if (this.pTP != null)
    {
      this.pTP.cancel();
      this.pTP = null;
    }
    this.pTK = 0;
    com.tencent.mm.plugin.voip.b.bPx().pSz = null;
  }
  
  public final void s(int paramInt1, int paramInt2, String paramString)
  {
    y.i("MicroMsg.Voip.VoipServiceEx", "onFinishVoIP finishType: " + paramInt1);
    switch (paramInt1)
    {
    case 2: 
    case 3: 
    default: 
      return;
    case 4: 
      bRu();
      this.pNq.pQf.onReject();
      return;
    case 5: 
      bRu();
      this.pNq.pQf.bQH();
      return;
    case 6: 
      bRu();
      this.pNq.pQf.bQJ();
      return;
    }
    bRu();
    this.pNq.pQf.onError(paramInt2, paramString);
  }
  
  public final int setNetSignalValue(int paramInt1, int paramInt2)
  {
    return this.pNq.pQe.setNetSignalValue(paramInt1, paramInt2);
  }
  
  public final void stop()
  {
    y.i("MicroMsg.Voip.VoipServiceEx", "stop");
    reset();
    this.pNq.a(null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.voip.model.s
 * JD-Core Version:    0.7.0.1
 */