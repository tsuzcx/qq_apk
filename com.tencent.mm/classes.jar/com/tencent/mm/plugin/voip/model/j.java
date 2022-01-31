package com.tencent.mm.plugin.voip.model;

import android.content.Context;
import android.net.Proxy;
import android.os.Build;
import android.os.Looper;
import com.tencent.mm.model.bd;
import com.tencent.mm.plugin.voip.a.a;
import com.tencent.mm.plugin.voip.model.a.k;
import com.tencent.mm.protocal.c.bmk;
import com.tencent.mm.protocal.c.bvf;
import com.tencent.mm.protocal.c.cci;
import com.tencent.mm.protocal.c.cec;
import com.tencent.mm.protocal.c.cex;
import com.tencent.mm.protocal.c.cey;
import com.tencent.mm.protocal.c.cfe;
import com.tencent.mm.protocal.c.cfk;
import com.tencent.mm.protocal.c.cfm;
import com.tencent.mm.sdk.f.e;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.ai;
import com.tencent.mm.sdk.platformtools.am;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import java.io.IOException;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.LinkedList;
import java.util.Timer;
import java.util.TimerTask;

public final class j
{
  public static int pQv = 2;
  public boolean bWb = false;
  public Context hxz = null;
  ah mHandler = new j.3(this, Looper.getMainLooper());
  public int mStatus = 1;
  public boolean pPA = false;
  public boolean pPB = false;
  public boolean pPC = false;
  public boolean pPD = false;
  public boolean pPE = false;
  public boolean pPF = false;
  public boolean pPG = false;
  public boolean pPH = false;
  public bvf pPI = new bvf();
  public int pPJ = 0;
  public long pPK = 0L;
  public long pPL = 0L;
  public int pPM = 0;
  public int pPN = 0;
  public boolean pPO = false;
  public boolean pPP = false;
  public boolean pPQ = false;
  public int pPR = 10;
  int pPS = -1;
  private int pPT = -1;
  int pPU = -1;
  private int pPV = -1;
  int pPW = -1;
  public boolean pPX = false;
  private boolean pPY = false;
  private int pPZ = 1;
  private boolean pQa = false;
  private int pQb = 1;
  private int pQc = -1;
  private int pQd = -1;
  public v2protocal pQe = new v2protocal(this.mHandler);
  public u pQf = u.pUd;
  public l pQg = new l(this);
  public t pQh = new t(this);
  public byte[] pQi = null;
  public cfe pQj = null;
  public boolean pQk = false;
  public boolean pQl = false;
  public int pQm = 0;
  public int pQn = 0;
  public int pQo = 0;
  public boolean pQp = false;
  public VoipScoreState pQq = new VoipScoreState();
  public int pQr = 0;
  public am pQs = new am(Looper.getMainLooper(), new j.1(this), true);
  private Timer pQt = null;
  private int pQu = 0;
  private am pQw = new am(Looper.getMainLooper(), new j.8(this), false);
  private j.a pQx = null;
  
  private void bPZ()
  {
    a.Logd("MicroMsg.Voip.VoipContext", "DeviceInfo.mAudioInfo.aecMode:" + com.tencent.mm.compatible.e.q.dye.dvx);
    if (com.tencent.mm.compatible.e.q.dye.duZ == 1) {
      this.pQe.um(410);
    }
    byte[] arrayOfByte1 = new byte[2];
    label120:
    byte[] arrayOfByte2;
    if (com.tencent.mm.compatible.e.q.dye.dvx >= 0)
    {
      arrayOfByte1[0] = ((byte)com.tencent.mm.compatible.e.q.dye.dvx);
      this.pQe.setAppCmd(406, arrayOfByte1, 1);
      if (com.tencent.mm.compatible.e.q.dye.dvy < 0) {
        break label832;
      }
      arrayOfByte1[0] = ((byte)com.tencent.mm.compatible.e.q.dye.dvy);
      this.pQe.setAppCmd(408, arrayOfByte1, 1);
      if (com.tencent.mm.compatible.e.q.dye.dvA < 0) {
        break label874;
      }
      arrayOfByte2 = new byte[5];
      if ((com.tencent.mm.compatible.e.q.dye.dvB >= 0) && (com.tencent.mm.compatible.e.q.dye.dvC >= 0))
      {
        arrayOfByte2[0] = ((byte)com.tencent.mm.compatible.e.q.dye.dvB);
        arrayOfByte2[1] = ((byte)com.tencent.mm.compatible.e.q.dye.dvC);
        if (com.tencent.mm.compatible.e.q.dye.dvD < 0) {
          break label857;
        }
        arrayOfByte2[2] = ((byte)com.tencent.mm.compatible.e.q.dye.dvD);
        arrayOfByte2[3] = ((byte)com.tencent.mm.compatible.e.q.dye.dvA);
        arrayOfByte2[4] = ((byte)com.tencent.mm.compatible.e.q.dye.dvE);
        this.pQe.setAppCmd(404, arrayOfByte2, 5);
      }
    }
    for (;;)
    {
      if ((com.tencent.mm.compatible.e.q.dye.dva >= 0) || (com.tencent.mm.compatible.e.q.dye.dvc >= 0))
      {
        arrayOfByte1[0] = -1;
        arrayOfByte1[1] = -1;
        if (com.tencent.mm.compatible.e.q.dye.dva >= 0) {
          arrayOfByte1[0] = ((byte)com.tencent.mm.compatible.e.q.dye.dva);
        }
        if (com.tencent.mm.compatible.e.q.dye.dvc >= 0) {
          arrayOfByte1[1] = ((byte)com.tencent.mm.compatible.e.q.dye.dvc);
        }
        this.pQe.setAppCmd(414, arrayOfByte1, 2);
      }
      if ((com.tencent.mm.compatible.e.q.dye.dvb >= 0) || (com.tencent.mm.compatible.e.q.dye.dvd >= 0))
      {
        arrayOfByte1[0] = -1;
        arrayOfByte1[1] = -1;
        if (com.tencent.mm.compatible.e.q.dye.dvb >= 0) {
          arrayOfByte1[0] = ((byte)com.tencent.mm.compatible.e.q.dye.dvb);
        }
        if (com.tencent.mm.compatible.e.q.dye.dvd >= 0) {
          arrayOfByte1[1] = ((byte)com.tencent.mm.compatible.e.q.dye.dvd);
        }
        this.pQe.setAppCmd(415, arrayOfByte1, 2);
      }
      if ((com.tencent.mm.compatible.e.q.dye.dve >= 0) || (com.tencent.mm.compatible.e.q.dye.dvf >= 0))
      {
        arrayOfByte1[0] = -1;
        arrayOfByte1[1] = -1;
        if (com.tencent.mm.compatible.e.q.dye.dve >= 0) {
          arrayOfByte1[0] = ((byte)com.tencent.mm.compatible.e.q.dye.dve);
        }
        if (com.tencent.mm.compatible.e.q.dye.dvf >= 0) {
          arrayOfByte1[1] = ((byte)com.tencent.mm.compatible.e.q.dye.dvf);
        }
        this.pQe.setAppCmd(422, arrayOfByte1, 2);
      }
      if (com.tencent.mm.compatible.e.q.dye.dvg >= 0)
      {
        arrayOfByte1[0] = ((byte)com.tencent.mm.compatible.e.q.dye.dvg);
        this.pQe.setAppCmd(416, arrayOfByte1, 1);
      }
      if (com.tencent.mm.compatible.e.q.dye.dvk >= 0)
      {
        arrayOfByte1[0] = ((byte)com.tencent.mm.compatible.e.q.dye.dvk);
        this.pQe.setAppCmd(431, arrayOfByte1, 4);
      }
      if ((com.tencent.mm.compatible.e.q.dye.dvh >= 0) && ((this.pQe.pVn != 0) || (com.tencent.mm.compatible.e.q.dye.dvh != 5)))
      {
        arrayOfByte1[0] = ((byte)com.tencent.mm.compatible.e.q.dye.dvh);
        this.pQe.setAppCmd(417, arrayOfByte1, 1);
      }
      if ((com.tencent.mm.compatible.e.q.dye.dvi >= 0) && ((this.pQe.pVn != 0) || (com.tencent.mm.compatible.e.q.dye.dvi != 5)))
      {
        arrayOfByte1[0] = ((byte)com.tencent.mm.compatible.e.q.dye.dvi);
        this.pQe.setAppCmd(418, arrayOfByte1, 1);
      }
      if (com.tencent.mm.compatible.e.q.dye.dvj >= 0)
      {
        arrayOfByte1[0] = ((byte)com.tencent.mm.compatible.e.q.dye.dvj);
        this.pQe.setAppCmd(419, arrayOfByte1, 1);
      }
      if ((this.pQe.pVn == 1) && ((com.tencent.mm.compatible.e.q.dye.dvh == 5) || (com.tencent.mm.compatible.e.q.dye.dvi == 5))) {
        this.pQe.pUZ = 5;
      }
      if (1 != com.tencent.mm.compatible.e.q.dye.dvH) {
        break label914;
      }
      arrayOfByte2 = new byte[30];
      int n = 0;
      while (n < 15)
      {
        arrayOfByte2[(n * 2)] = ((byte)(com.tencent.mm.compatible.e.q.dye.dvI[n] & 0xFF));
        arrayOfByte2[(n * 2 + 1)] = ((byte)(com.tencent.mm.compatible.e.q.dye.dvI[n] >> 8 & 0xFF));
        n += 1;
      }
      if (com.tencent.mm.compatible.e.q.dye.dvx != -2) {
        break;
      }
      this.pQe.um(407);
      break;
      label832:
      if (com.tencent.mm.compatible.e.q.dye.dvy != -2) {
        break label120;
      }
      this.pQe.um(409);
      break label120;
      label857:
      this.pQe.setAppCmd(404, arrayOfByte2, 2);
      continue;
      label874:
      if (com.tencent.mm.compatible.e.q.dye.dvA == -2) {
        this.pQe.um(405);
      }
    }
    this.pQe.setAppCmd(420, arrayOfByte2, 30);
    label914:
    if (com.tencent.mm.compatible.e.q.dye.dvH == 0) {
      this.pQe.um(421);
    }
    if ((com.tencent.mm.compatible.e.q.dye.dvJ[0] > 0) || (com.tencent.mm.compatible.e.q.dye.dvJ[1] > 0))
    {
      arrayOfByte1[0] = 0;
      arrayOfByte1[1] = 0;
      if ((com.tencent.mm.compatible.e.q.dye.dvJ[0] > 0) && (com.tencent.mm.compatible.e.q.dye.dvJ[0] < 10000)) {
        arrayOfByte1[0] = ((byte)com.tencent.mm.compatible.e.q.dye.dvJ[0]);
      }
      if ((com.tencent.mm.compatible.e.q.dye.dvJ[1] > 0) && (com.tencent.mm.compatible.e.q.dye.dvJ[1] < 10000)) {
        arrayOfByte1[1] = ((byte)com.tencent.mm.compatible.e.q.dye.dvJ[1]);
      }
      this.pQe.setAppCmd(423, arrayOfByte1, 2);
    }
    if (com.tencent.mm.compatible.e.q.dye.dvL > 0)
    {
      arrayOfByte1[0] = ((byte)com.tencent.mm.compatible.e.q.dye.dvL);
      this.pQe.setAppCmd(424, arrayOfByte1, 1);
    }
    if (com.tencent.mm.compatible.e.q.dye.dvT >= 0)
    {
      int i = (byte)com.tencent.mm.compatible.e.q.dye.dvT;
      int j = (byte)com.tencent.mm.compatible.e.q.dye.dvU;
      int k = (byte)com.tencent.mm.compatible.e.q.dye.dvV;
      int m = (byte)com.tencent.mm.compatible.e.q.dye.dvW;
      this.pQe.setAppCmd(426, new byte[] { i, j, k, m }, 4);
    }
  }
  
  private void bQe()
  {
    m localm;
    if (this.mStatus == 5)
    {
      setStatus(6);
      localm = this.pQe.pWi;
      if (localm.beginTime != 0L) {
        break label125;
      }
    }
    label125:
    for (localm.pQX = 0;; localm.pQX = ((int)(System.currentTimeMillis() - localm.beginTime)))
    {
      a.Logi("MicroMsg.VoipDailReport", "devin:beginTime:" + localm.beginTime + ", CurrentTime: " + System.currentTimeMillis());
      a.Logi("MicroMsg.VoipDailReport", "devin:endDial:" + localm.pQX);
      a.Logi("MicroMsg.Voip.VoipContext", "talking  now .......!");
      this.mHandler.post(new j.4(this));
      return;
    }
  }
  
  private void bQf()
  {
    ai.d(new j.6(this));
  }
  
  public final void Aa(int paramInt)
  {
    this.pQe.pVB = paramInt;
  }
  
  public final void Ab(int paramInt)
  {
    this.pQe.pVu = paramInt;
  }
  
  public final void Ac(int paramInt)
  {
    this.pQe.pWi.pRa = 1;
    this.pQe.channelStrategy = paramInt;
  }
  
  public final void Ad(int paramInt)
  {
    this.pQe.pUI = paramInt;
  }
  
  public final void a(j.a parama)
  {
    if (parama != null) {
      this.pQx = parama;
    }
  }
  
  public final void a(cec paramcec1, cec paramcec2, cec paramcec3, LinkedList<cfk> paramLinkedList)
  {
    String str = Proxy.getDefaultHost();
    int i = Proxy.getDefaultPort();
    cfm localcfm;
    if ((str != null) && (str.length() > 0) && (i > 0)) {
      localcfm = new cfm();
    }
    do
    {
      try
      {
        localcfm.tUF = 1;
        localcfm.tUG = i;
        localcfm.tUH = 0;
        localcfm.userName = "";
        localcfm.foj = "";
        localcfm.tUG = a.Gh(InetAddress.getByName(str).getHostAddress());
        return;
      }
      catch (UnknownHostException localUnknownHostException)
      {
        y.printErrStackTrace("MicroMsg.Voip.VoipContext", localUnknownHostException, "", new Object[0]);
        return;
      }
      finally
      {
        if (this.pQe.a(paramcec1, paramcec2, paramcec3, localcfm, paramLinkedList) != 0) {
          y.i("MicroMsg.Voip.VoipContext", "setIp fail!");
        }
      }
      localcfm = new cfm();
      localcfm.tUF = 0;
      localcfm.tUG = 0;
      localcfm.tUH = 0;
      localcfm.userName = "";
      localcfm.foj = "";
    } while (this.pQe.a(paramcec1, paramcec2, paramcec3, localcfm, paramLinkedList) == 0);
    y.i("MicroMsg.Voip.VoipContext", "setIp fail!");
  }
  
  public final void a(byte[] paramArrayOfByte1, int paramInt1, int paramInt2, byte[] paramArrayOfByte2)
  {
    this.pQe.pUE = paramInt1;
    this.pQe.pUF = paramArrayOfByte1;
    this.pQe.pVz = paramInt2;
    this.pQe.pVA = paramArrayOfByte2;
  }
  
  public final void aR(byte[] paramArrayOfByte)
  {
    y.i("MicroMsg.Voip.VoipContext", "updateRemotePid");
    this.pQe.pWi.pQZ = 1;
    this.pQe.pWi.pQY = 1;
    this.pQe.pUB = paramArrayOfByte;
  }
  
  public final void aS(byte[] paramArrayOfByte)
  {
    y.i("MicroMsg.Voip.VoipContext", "updateRemoteCapInfo, isGotCapInfo: %s", new Object[] { Byte.valueOf(this.pQe.pWi.pRd) });
    if ((this.pQe.pWi.pRd == 1) || (paramArrayOfByte == null)) {}
    int i;
    do
    {
      return;
      this.pQe.pWi.pRd = 1;
      this.pQe.pUC = paramArrayOfByte;
      i = this.pQe.exchangeCabInfo(this.pQe.pUC, this.pQe.pUC.length);
    } while (i >= 0);
    a.Loge("MicroMsg.Voip.VoipContext", "protocal exchangecabinfo failed ret:" + i);
    this.pQe.pWi.pQU = 15;
    s(1, -9003, "");
  }
  
  public final void b(int paramInt, byte[] paramArrayOfByte1, byte[] paramArrayOfByte2)
  {
    this.pQe.pVG = paramInt;
    this.pQe.pVH = paramArrayOfByte1;
    this.pQe.pVI = paramArrayOfByte2;
  }
  
  public final void bPR()
  {
    int k = 0;
    if ((this.pPA == true) && (this.pPJ == 0))
    {
      this.pPJ = 1;
      if (this.pQe.field_speedTestInfoLength < 8) {
        a.Loge("MicroMsg.Voip.VoipContext", "Herohe StartVoipSpeedTest failed! bufsize=" + this.pQe.field_speedTestInfoLength);
      }
    }
    else
    {
      a.Loge("MicroMsg.Voip.VoipContext", "StartVoipSpeedTest fail for status is wrong: isChannelStartConnect=" + this.pPA + " ,mSpeedTestStatus=" + this.pPJ);
      return;
    }
    int i = this.pQe.pWg[1];
    if (i + 2 > this.pQe.field_speedTestInfoLength)
    {
      a.Loge("MicroMsg.Voip.VoipContext", "Herohe StartVoipSpeedTest failed! C2CRttCnt=" + i + ", bufsize=" + this.pQe.field_speedTestInfoLength);
      return;
    }
    int j = this.pQe.pWg[(i + 2 + 1)];
    if (i + 6 + j != this.pQe.field_speedTestInfoLength)
    {
      a.Loge("MicroMsg.Voip.VoipContext", "Herohe StartVoipSpeedTest failed! C2CRttCnt=" + i + ", C2SRttCnt=" + j + ", bufsize=" + this.pQe.field_speedTestInfoLength);
      return;
    }
    this.pPK = this.pQe.lpE;
    this.pPM = this.pQe.netType;
    this.pPN = this.pQe.lpD;
    this.pPI.sST = this.pQe.lpD;
    this.pPI.tLL = this.pQe.pUM;
    this.pPI.sNU = this.pQe.netType;
    bvf localbvf = this.pPI;
    if (this.pPA == true)
    {
      i = 1;
      localbvf.tLM = i;
      localbvf = this.pPI;
      if (this.pPC != true) {
        break label448;
      }
    }
    label448:
    for (i = 1;; i = 0)
    {
      localbvf.tLN = i;
      this.pPI.tLO = this.pQe.pWg[0];
      this.pPI.tLP = this.pQe.pWg[1];
      j = 0;
      i = 2;
      while (j < this.pPI.tLP)
      {
        this.pPI.tLQ.add(Integer.valueOf(this.pQe.pWg[i]));
        j += 1;
        i += 1;
      }
      i = 0;
      break;
    }
    localbvf = this.pPI;
    int[] arrayOfInt = this.pQe.pWg;
    j = i + 1;
    localbvf.tLR = arrayOfInt[i];
    localbvf = this.pPI;
    arrayOfInt = this.pQe.pWg;
    i = j + 1;
    localbvf.tLS = arrayOfInt[j];
    j = k;
    while (j < this.pPI.tLS)
    {
      this.pPI.tLT.add(Integer.valueOf(this.pQe.pWg[i]));
      j += 1;
      i += 1;
    }
    this.pPI.tLU = this.pQe.pWg[i];
    this.pPI.tLV = this.pQe.pWg[(i + 1)];
    new k(this.pPI).bRB();
  }
  
  public final void bPS()
  {
    if (this.pPJ == 0) {
      return;
    }
    if (this.pPJ == 1)
    {
      this.pPJ = 0;
      this.pQe.pVQ = 0L;
      return;
    }
    this.pPJ = 0;
    v2protocal localv2protocal = this.pQe;
    a.Logi("MicroMsg.Voip", "v2protocal StopVoipSpeedTest!");
    localv2protocal.StopSpeedTest();
    localv2protocal.pVQ = 0L;
  }
  
  public final void bPT()
  {
    this.pQe.pUP = this.pQg.bQk();
    this.pQe.pUQ = this.pQg.bPG();
  }
  
  public final int bPU()
  {
    int i = 2;
    if (this.mStatus == 1) {
      i = 0;
    }
    do
    {
      return i;
      if ((this.mStatus == 2) || (this.mStatus == 3)) {
        return 1;
      }
    } while (this.mStatus == 4);
    return 3;
  }
  
  public final boolean bPV()
  {
    return this.mStatus == 3;
  }
  
  public final boolean bPW()
  {
    y.d("MicroMsg.Voip.VoipContext", "isWorking, status: %d", new Object[] { Integer.valueOf(this.mStatus) });
    return this.mStatus != 1;
  }
  
  public final boolean bPX()
  {
    if (this.pPQ) {
      return false;
    }
    switch (this.pPS)
    {
    }
    do
    {
      do
      {
        do
        {
          return true;
          return true;
        } while (4 == this.pPT);
        return false;
      } while ((4 == this.pPT) || (-1 == this.pPT));
      return false;
      if ((5 == this.pPT) || (6 == this.pPT)) {
        break;
      }
    } while (7 != this.pPT);
    return false;
  }
  
  public final boolean bPY()
  {
    if (this.pPQ) {
      return false;
    }
    switch (this.pPS)
    {
    }
    do
    {
      do
      {
        do
        {
          return true;
          return true;
        } while (4 == this.pPT);
        return false;
      } while ((4 == this.pPU) || (this.pPU == 0) || (-1 == this.pPU));
      return false;
      if ((5 == this.pPU) || (6 == this.pPU)) {
        break;
      }
    } while (7 != this.pPU);
    return false;
  }
  
  public final void bQa()
  {
    a.Logi("MicroMsg.Voip.VoipContext", "tryStartTalk: try start talk");
    if ((this.pPE != true) || (this.pPC != true))
    {
      a.Logi("MicroMsg.Voip.VoipContext", "tryStartTalk: fail isCanSendData " + this.pPE + ", isChannelConnectedSuccess " + this.pPC);
      return;
    }
    a.Logi("MicroMsg.Voip.VoipContext", "Voip tryStartTalk, channel setActive");
    this.pQe.setActive();
    if (this.pPH == true)
    {
      a.Logi("MicroMsg.Voip.VoipContext", "tryStartTalk: engine already started, isEngineStarted " + this.pPH);
      return;
    }
    label156:
    label214:
    int j;
    int k;
    label581:
    int m;
    int n;
    label1349:
    label1380:
    label1390:
    v2protocal localv2protocal;
    boolean bool;
    if (this.pQe.startEngine() == 0)
    {
      this.pQe.pWi.pRu = 0;
      bPZ();
      if ((bPX()) || (bPY())) {
        break label1761;
      }
      bQe();
      this.pQf.bQL();
      localObject = this.pQg;
      if (((l)localObject).iEu != 2) {
        break label1819;
      }
      a.Loge("MicroMsg.Voip.VoipDeviceHandler", "dev start already...");
      localObject = this.pQe.pWi;
      if (((m)localObject).beginTime != 0L) {
        break label2107;
      }
      ((m)localObject).pRn = 0;
      a.Logi("MicroMsg.VoipDailReport", "devin:beginTime:" + ((m)localObject).beginTime + ", CurrentTime: " + System.currentTimeMillis());
      a.Logi("MicroMsg.VoipDailReport", "devin:endNewDial:" + ((m)localObject).pRn);
      this.pQf.onConnected();
      this.mStatus = 5;
      localObject = this.pQe.pWi;
      ((m)localObject).pRv = System.currentTimeMillis();
      a.Logi("MicroMsg.VoipDailReport", "devin:beginTalk:" + ((m)localObject).pRv);
      this.pQe.setSvrConfig(202, this.pQe.pVf, this.pQe.pVg, 0, 0, 0, 0);
      this.pQe.setSvrConfig(203, 0, 0, this.pQe.pVk, 0, 0, 0);
      this.pQe.setSvrConfig(206, 0, 0, this.pQe.pVo, 0, 0, 0);
      this.pQe.setSvrConfig(103, this.pQe.pVh, this.pQe.pVi, this.pQe.pVj, this.pQe.pVm, 0, 0);
      this.pQe.setSvrConfig(205, 0, 0, this.pQe.pVC, 0, 0, 0);
      this.pQe.setSvrConfig(207, 0, 0, this.pQe.pUJ, 0, 0, 0);
      a.Logi("MicroMsg.Voip.VoipContext", "bothSideGeneralSwitch = " + this.pQe.pVC + " SwitchFlag = " + this.pQe.pUJ);
      j = this.pQe.pVp >> 2 & 0x3;
      k = this.pQe.pVp & 0x3;
      if (this.pQe.lpL != 0) {
        break label2125;
      }
      j = (j << 2) + k;
      this.pQe.setSvrConfig(502, 0, 0, j, 0, 0, 0);
      this.pQe.setSvrConfig(503, 0, 0, this.pQe.pVq, this.pQe.pVr, this.pQe.pVs, this.pQe.pVt);
      if ((this.pQe.pVH != null) && (this.pQe.pVI != null))
      {
        this.pQe.setSvrConfig(504, 0, 0, this.pQe.pVG, 0, 0, 0);
        this.pQe.setSvrConfig(505, 0, 0, this.pQe.pVH[0], this.pQe.pVH[1], this.pQe.pVH[2], this.pQe.pVH[3]);
        this.pQe.setSvrConfig(506, 0, 0, this.pQe.pVI[0], this.pQe.pVI[1], 0, 0);
        a.Logi("MicroMsg.Voip.VoipContext", "FECSvrCtr = " + this.pQe.pVG + ",FECKeyPara1 = " + this.pQe.pVH[0] + "," + this.pQe.pVH[1] + "," + this.pQe.pVH[2] + "," + this.pQe.pVH[3] + ",FECKeyPara2 = " + this.pQe.pVI[0] + "," + this.pQe.pVI[1]);
      }
      k = this.pQe.pVu;
      m = this.pQe.pVu;
      n = this.pQe.pVu;
      this.pQe.setSvrConfig(507, 0, 0, (k & 0x4) >> 2, (m & 0x2) >> 1, n & 0x1, 0);
      this.pQe.setjbmbitraterssvrparam();
      a.Logi("MicroMsg.Voip.VoipContext", "zhengxue[Logic] setSvrConfig brefore onStartTalk: audioTsdfBeyond3G = " + this.pQe.pVf + ",audioTsdEdge = " + this.pQe.pVg + ",passthroughQosAlgorithm = " + this.pQe.pVh + ",fastPlayRepair = " + this.pQe.pVi + ", audioDTX = " + this.pQe.pVk + ", mARQFlag = " + j + ", mQosStrategy = " + this.pQe.pVu + ", mSvrCfgListV = " + this.pQe.pVj + ", maxBRForRelay = " + this.pQe.pVm);
      localObject = new byte[2];
      localObject[0] = ((byte)com.tencent.mm.compatible.e.q.dyd.dwz);
      localObject[1] = -1;
      a.Logd("MicroMsg.Voip.VoipContext", "steve: Model Name: " + Build.MODEL);
      a.Logd("MicroMsg.Voip.VoipContext", "steve: Image Enhancement for Android Capture!!, mode: " + localObject[0]);
      this.pQe.setAppCmd(15, (byte[])localObject, 1);
      a.Logd("MicroMsg.Voip.VoipContext", "anlin: ClientVersion: " + com.tencent.mm.protocal.d.spa);
      localObject = ByteBuffer.allocate(4);
      ((ByteBuffer)localObject).order(ByteOrder.LITTLE_ENDIAN).putInt(com.tencent.mm.protocal.d.spa);
      localObject = ((ByteBuffer)localObject).array();
      this.pQe.setAppCmd(505, (byte[])localObject, 4);
      localObject = new byte[4];
      this.pQe.setAppCmd(26, (byte[])localObject, 4);
      localObject = ByteBuffer.wrap((byte[])localObject);
      ((ByteBuffer)localObject).order(ByteOrder.LITTLE_ENDIAN);
      m = ((ByteBuffer)localObject).getInt();
      a.Logd("MicroMsg.Voip.VoipContext", "steve: iHW: " + m);
      if (((this.pQe.pVj & 0x4) == 0) && (com.tencent.mm.compatible.e.q.dyd.dwB <= 0)) {
        break label2134;
      }
      j = 1;
      if ((j == 0) && (this.pQe.pWn))
      {
        a.Logi("MicroMsg.Voip.VoipContext", "steve:[HW]:Server Disable HW enc/dec!!");
        if ((m & 0x4) == 0) {
          break label2139;
        }
        j = 1;
        if ((m & 0x8) == 0) {
          break label2144;
        }
        k = 1;
        if ((j != 0) || (k != 0))
        {
          this.pQg.pQK = true;
          bQb();
        }
        this.pQe.pWn = false;
      }
      if (this.pQe.pWn)
      {
        localv2protocal = this.pQe;
        n = com.tencent.mm.compatible.e.q.dyd.dwB;
        bool = false;
        if ((m & 0x4) == 0) {
          break label2149;
        }
        j = 1;
        label1454:
        if ((m & 0x8) == 0) {
          break label2154;
        }
        k = 1;
        label1464:
        if ((j != 0) || (k != 0)) {
          if (j == 0) {
            break label2159;
          }
        }
      }
    }
    label1761:
    label2149:
    label2154:
    label2159:
    for (Object localObject = "video/hevc";; localObject = "video/avc")
    {
      localv2protocal.pWj = new d(localv2protocal.width, localv2protocal.height, localv2protocal.pWl, localv2protocal.bitrate, n, (String)localObject);
      a.Logi("MicroMsg.Voip", "steve : create HW encoder successfully:" + (String)localObject);
      if (v2protocal.pWm != null)
      {
        v2protocal.pWk = new c(v2protocal.pWm);
        a.Logi("MicroMsg.Voip", "steve : create HW decoder successfully!");
      }
      bool = true;
      if ((localv2protocal.pWj == null) || (v2protocal.pWk == null))
      {
        localv2protocal.pWn = false;
        bool = false;
      }
      a.Logi("MicroMsg.Voip.VoipContext", "steve: HW encoder/decoder init ret: " + bool + ", iHW:" + m);
      if (!this.pQe.pWn)
      {
        a.Logi("MicroMsg.Voip.VoipContext", "steve: HW dec/enc NOT supported for both sides,end HWEnc!!");
        this.pQg.pQK = true;
        bQb();
      }
      if (this.pQe.pWj != null) {
        this.pQe.pWj.pNq = this;
      }
      if (v2protocal.pWk != null) {
        v2protocal.pWk.a(this);
      }
      this.pPH = true;
      this.pQp = false;
      localObject = this.pQq;
      ((VoipScoreState)localObject).lrc = bd.HM();
      y.i("MicroMsg.VoipScoreState", "markStartTalk, startTalkTime:%s", new Object[] { Long.valueOf(((VoipScoreState)localObject).lrc) });
      return;
      this.pPH = false;
      this.pQe.pWi.pRu = 1;
      break;
      if (this.pQt != null)
      {
        bQe();
        break label156;
      }
      this.pQt = new Timer();
      this.pQu = 0;
      localObject = new j.5(this);
      this.pQt.schedule((TimerTask)localObject, 200L, 200L);
      break label156;
      a.Logi("MicroMsg.Voip.VoipDeviceHandler", "start device......");
      ((l)localObject).iEu = 2;
      ((l)localObject).pQK = false;
      ((l)localObject).pQL = 0;
      if (((l)localObject).pQQ != null)
      {
        a.Logd("MicroMsg.Voip.VoipDeviceHandler", "stop videodecode thread..");
        ((l)localObject).pQQ.pQT = true;
        e.remove(((l)localObject).pQQ);
        ((l)localObject).pQQ = null;
      }
      ((l)localObject).pQQ = new l.b((l)localObject);
      e.post(((l)localObject).pQQ, "VoipDeviceHandler_decode");
      a.Logd("MicroMsg.Voip.VoipDeviceHandler", "start video decode thread..");
      com.tencent.mm.compatible.e.q.dye.dump();
      ((l)localObject).pQB = new b();
      ((l)localObject).pQB.z(v2protocal.VOICE_SAMPLERATE, 1, 20, 0);
      ((l)localObject).iEv = ((l)localObject).pQB.t(((l)localObject).pNq.hxz, true);
      if (((l)localObject).pQB.pNp == true) {}
      for (j = 1;; j = 0)
      {
        int i = (byte)j;
        ((l)localObject).pNq.pQe.setAppCmd(502, new byte[] { i }, 1);
        if (((l)localObject).iEv <= 10)
        {
          if (((l)localObject).iEv <= 0) {
            ((l)localObject).iEy = 1;
          }
          ((l)localObject).iEv = 92;
        }
        ((l)localObject).pQB.pNy = new l.2((l)localObject);
        if (((l)localObject).pQB.bPD() <= 0) {
          ((l)localObject).iEy = 1;
        }
        e.a(new l.3((l)localObject), "voip_start_record", 10);
        break;
      }
      ((m)localObject).pRn = ((int)(System.currentTimeMillis() - ((m)localObject).beginTime));
      break label214;
      j = (k << 2) + j;
      break label581;
      j = 0;
      break label1349;
      j = 0;
      break label1380;
      k = 0;
      break label1390;
      j = 0;
      break label1454;
      k = 0;
      break label1464;
    }
  }
  
  public final void bQb()
  {
    zZ(2);
    if (this.pQe != null)
    {
      a.Logi("MicroMsg.Voip.VoipContext", "steve:[HW]:closeRemoteHWEnc: Set P2S HW Flag False!!");
      int i = pQv;
      ByteBuffer localByteBuffer = ByteBuffer.allocate(4);
      localByteBuffer.order(ByteOrder.LITTLE_ENDIAN);
      localByteBuffer.putInt(i);
      this.pQe.setAppCmd(27, localByteBuffer.array(), 4);
      localByteBuffer = ByteBuffer.allocate(4);
      localByteBuffer.order(ByteOrder.LITTLE_ENDIAN);
      localByteBuffer.putInt(6);
      a.Logi("MicroMsg.Voip.VoipContext", "steve:[HW]:closeRemoteHWEnc:reset maxsizeformat: 6");
      this.pQe.setAppCmd(30, localByteBuffer.array(), 4);
    }
  }
  
  public final boolean bQc()
  {
    boolean bool = bPX();
    int i = 0;
    if (bool) {
      i = 1;
    }
    if ((this.pQc == -1) || (this.pQc != i))
    {
      this.pQc = i;
      if (bool)
      {
        a.Logd("MicroMsg.Voip.VoipContext", "setAppCmd: set start video Out.......!");
        this.pQe.um(203);
      }
    }
    else
    {
      return bool;
    }
    a.Logd("MicroMsg.Voip.VoipContext", "setAppCmd: set stop video Out.......!");
    this.pQe.um(202);
    return bool;
  }
  
  public final boolean bQd()
  {
    boolean bool = bPY();
    int i = 0;
    if (bool) {
      i = 1;
    }
    if ((this.pQd == -1) || (this.pQd != i))
    {
      this.pQd = i;
      if (bool)
      {
        a.Logd("MicroMsg.Voip.VoipContext", "setAppCmd: set start video In.......!");
        this.pQe.um(201);
      }
    }
    else
    {
      return bool;
    }
    a.Logd("MicroMsg.Voip.VoipContext", "setAppCmd: set stop video In.......!");
    this.pQe.um(200);
    return bool;
  }
  
  public final void bQg()
  {
    boolean bool;
    if (!bk.bE(this.pQe.pUB))
    {
      bool = true;
      a.Logi("MicroMsg.Voip.VoipContext", "channel:try start connect, hasRemotePid:" + bool + ",mStatus:" + this.mStatus + ",isPreConnect:" + this.pPG + ",isRemoteAccepted:" + this.pPD + ",isLocalAccept:" + this.bWb);
      this.pQe.pWi.pRg = 7;
      if ((bool) && ((this.mStatus == 4) || (this.mStatus == 5) || (this.mStatus == 6) || ((this.mStatus == 2) && (this.pPG == true)) || ((this.mStatus == 3) && (this.pPG == true))))
      {
        if ((this.mStatus == 2) || (this.mStatus == 3) || (this.mStatus == 4) || (this.mStatus == 5) || (this.mStatus == 6)) {
          break label234;
        }
        a.Logi("MicroMsg.Voip.VoipContext", "startConnect status fail, status:" + this.mStatus);
      }
    }
    label234:
    do
    {
      return;
      bool = false;
      break;
      if ((this.pPD) || (this.bWb)) {
        break label267;
      }
    } while ((!this.pPG) || (this.pPA));
    bQf();
    return;
    label267:
    if (!this.pPA) {
      bQf();
    }
    ai.d(new j.7(this));
  }
  
  public final void bQh()
  {
    if ((this.pPB) && (!bk.bE(this.pQe.pUD)))
    {
      int i = this.pQe.handleCommand(this.pQe.pUD, this.pQe.pUD.length);
      if (i < 0) {
        a.Loge("MicroMsg.Voip.VoipContext", "v2protocal handlecommand failed ret:" + i);
      }
      this.pQe.pUD = null;
    }
  }
  
  public final void bQi()
  {
    y.i("MicroMsg.Voip.VoipContext", "stop repeat voip sync");
    this.pQs.stopTimer();
  }
  
  public final void h(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5)
  {
    this.pQe.pVp = paramInt1;
    this.pQe.pVq = paramInt2;
    this.pQe.pVr = paramInt3;
    this.pQe.pVs = paramInt4;
    this.pQe.pVt = paramInt5;
  }
  
  public final void reset()
  {
    y.i("MicroMsg.Voip.VoipContext", "reset");
    this.pQf.bQK();
    if (this.pQe.isInited) {
      this.pQe.kb(false);
    }
    this.pQe.reset();
    this.pPS = -1;
    this.pPT = -1;
    this.pPU = -1;
    this.pPV = -1;
    this.pPW = -1;
    this.pQg.bQl();
    this.pQe.pUT = 0;
    this.pQw.stopTimer();
    this.pQh.bRx();
    this.pQs.stopTimer();
    this.pPA = false;
    this.pPC = false;
    this.pPB = false;
    this.pPD = false;
    this.bWb = false;
    this.pPE = false;
    this.pQi = null;
    this.pQj = null;
    this.pPO = false;
    this.pPP = false;
    this.pPQ = false;
    this.pPX = false;
    this.pPY = false;
    this.pQa = false;
    this.pPZ = 1;
    this.pQb = 1;
    this.pQk = false;
    this.pQc = -1;
    this.pQd = -1;
    this.pPF = false;
    this.pPG = false;
    this.pPE = false;
    this.pPA = false;
    this.pPH = false;
    this.pPR = 10;
    this.mStatus = 1;
    this.pQo = 0;
    this.pQr = 0;
    this.pQp = false;
  }
  
  public final void s(int paramInt1, int paramInt2, String paramString)
  {
    bQi();
    if (this.pQx != null) {
      this.pQx.s(paramInt1, paramInt2, paramString);
    }
  }
  
  public final void setStatus(int paramInt)
  {
    if (paramInt == this.mStatus) {
      return;
    }
    if (paramInt == 4) {
      this.pQw.S(60000L, 60000L);
    }
    this.mStatus = paramInt;
  }
  
  public final void shutdown()
  {
    bQi();
    this.mHandler.post(new j.2(this));
  }
  
  public final void zW(int paramInt)
  {
    this.pQe.pUO = Math.abs(paramInt);
  }
  
  public final void zX(int paramInt)
  {
    this.pQe.pUR = paramInt;
  }
  
  public final void zY(int paramInt)
  {
    if ((8 == paramInt) || (9 == paramInt)) {
      this.pPV = paramInt;
    }
    for (;;)
    {
      t localt = this.pQh;
      Object localObject2 = a.Aq(paramInt);
      Object localObject1 = new bmk();
      ((bmk)localObject1).bs((byte[])localObject2);
      localObject2 = new bmk();
      try
      {
        ((bmk)localObject2).bs(((bmk)localObject1).toByteArray());
        localObject1 = new cex();
        ((cex)localObject1).sOA = 3;
        ((cex)localObject1).sOB = ((bmk)localObject2);
        ((cex)localObject1).kWn = com.tencent.mm.model.q.Gj();
        localObject2 = new cey();
        ((cey)localObject2).hPS = 1;
        ((cey)localObject2).hPT.add(localObject1);
        localt.a((cey)localObject2, false, 4);
        return;
      }
      catch (IOException localIOException)
      {
        y.printErrStackTrace("MicroMsg.Voip.VoipSyncHandle", localIOException, "", new Object[0]);
      }
      this.pPS = paramInt;
      this.pPT = paramInt;
    }
  }
  
  public final void zZ(int paramInt)
  {
    try
    {
      cci localcci = new cci();
      localcci.tRC = paramInt;
      if (1 == paramInt)
      {
        a.Logi("MicroMsg.Voip.VoipContext", "steve:[HW]:send maxsizeformat: !!6");
        ByteBuffer localByteBuffer = ByteBuffer.allocate(4);
        localByteBuffer.order(ByteOrder.LITTLE_ENDIAN);
        localByteBuffer.putInt(6);
        localcci.tRD = new com.tencent.mm.bv.b(localByteBuffer.array());
        this.pQe.setAppCmd(32, localByteBuffer.array(), 4);
      }
      for (;;)
      {
        this.pQe.SendRUDP(localcci.toByteArray(), localcci.toByteArray().length);
        a.Logi("MicroMsg.Voip.VoipContext", "steve:[HW]:OnTransportChannelData: send RUDP data to close remote HW encoding!Type:" + paramInt);
        return;
        localcci.tRD = null;
      }
      return;
    }
    catch (Exception localException)
    {
      a.Logi("MicroMsg.Voip.VoipContext", "onVoipSendCloseHWEncCmd Error");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.voip.model.j
 * JD-Core Version:    0.7.0.1
 */