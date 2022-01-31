package com.tencent.mm.plugin.voip.model;

import android.media.MediaCodec;
import android.os.Bundle;
import com.tencent.mm.compatible.b.f;
import com.tencent.mm.compatible.util.g;
import com.tencent.mm.f.b.c;
import com.tencent.mm.f.b.c.a;
import com.tencent.mm.sdk.f.e;
import com.tencent.mm.sdk.platformtools.y;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;

public final class l
{
  public static int iEt = 3;
  public static int pQO = 0;
  public static int pQP = 0;
  private long iEA = 0L;
  private c.a iED = new l.1(this);
  volatile c iEq = null;
  public int iEu = 1;
  int iEv = 92;
  private int iEw = 1;
  final Object iEx = new Object();
  public int iEy = 0;
  private int iEz = 1;
  public j pNq = null;
  b pQB = null;
  private long pQC = 0L;
  private long pQD = 0L;
  private int pQE = 1;
  private int pQF = 0;
  private long pQG = 0L;
  private int pQH = 0;
  private int pQI = 0;
  public boolean pQJ = false;
  public boolean pQK = false;
  public int pQL = 0;
  private int pQM = 1;
  private long pQN = 0L;
  l.b pQQ;
  
  public l(j paramj)
  {
    this.pNq = paramj;
  }
  
  public final int b(byte[] paramArrayOfByte, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    if (this.iEu != 2) {
      return 0;
    }
    if (!this.pNq.bQc()) {
      return 0;
    }
    Object localObject1 = this.pNq.pQe;
    ((v2protocal)localObject1).pVS += 1;
    if (this.pQK)
    {
      y.i("MicroMsg.Voip.VoipDeviceHandler", "steve: StopHWEnc!!!");
      this.pNq.pQe.pWn = false;
      this.pQJ = false;
      this.pQK = false;
      this.pNq.zZ(1);
    }
    int i;
    if ((this.pNq.pQe.pWn) && (this.pNq.pQe.pWj != null))
    {
      localObject1 = this.pNq.pQe.pWj;
      if ((((d)localObject1).pNq != null) && (((d)localObject1).pNq.pQe != null))
      {
        Object localObject2;
        if (((d)localObject1).pNq.pQe.setAppCmd(d.pOZ, ((d)localObject1).pOU.pPn, ((d)localObject1).pOU.pPn.length) >= 0)
        {
          localObject2 = ((d)localObject1).pOU;
          ByteBuffer localByteBuffer = ByteBuffer.wrap(((d.a)localObject2).pPn);
          localByteBuffer.order(ByteOrder.LITTLE_ENDIAN);
          ((d.a)localObject2).pPa = localByteBuffer.getShort();
          ((d.a)localObject2).pPb = localByteBuffer.get();
          ((d.a)localObject2).pPc = localByteBuffer.get();
          ((d.a)localObject2).pPd = localByteBuffer.get();
          ((d.a)localObject2).pPe = localByteBuffer.get();
          ((d.a)localObject2).pPf = localByteBuffer.get();
          ((d.a)localObject2).pPg = localByteBuffer.get();
          ((d.a)localObject2).pPh = localByteBuffer.get();
          ((d.a)localObject2).pPi = localByteBuffer.get();
          ((d.a)localObject2).pPj = localByteBuffer.get();
          ((d.a)localObject2).pPk = localByteBuffer.get();
          ((d.a)localObject2).pPl = localByteBuffer.get();
          ((d.a)localObject2).pPm = localByteBuffer.get();
          localObject2 = ((d)localObject1).pOU;
          y.d("MeidaCodec[HWEnc]", "raw S2P:" + ((d.a)localObject2).pPn);
          y.d("MeidaCodec[HWEnc]", "-S2P- iKbps:" + ((d.a)localObject2).pPa + ", fps:" + ((d.a)localObject2).pPb + ", IP:" + ((d.a)localObject2).pPc + ", RS:" + ((d.a)localObject2).pPd + ", QPMin:" + ((d.a)localObject2).pPe + ", QPMax:" + ((d.a)localObject2).pPf + ", HPP:" + ((d.a)localObject2).pPg + ", SWitch:" + ((d.a)localObject2).pPh + ", Reso:" + ((d.a)localObject2).pPi + ", Rsvd1:" + ((d.a)localObject2).pPj + ", Rsvd2:" + ((d.a)localObject2).pPk + ", Skip:" + ((d.a)localObject2).pPl + ", IReq:" + ((d.a)localObject2).pPm);
        }
        int k = ((d)localObject1).pOU.pPa;
        if (((d)localObject1).pOQ != 8) {
          break label1116;
        }
        i = 1;
        int j = k;
        if (i == 0)
        {
          double d = 1.0D * Math.max(Math.min(((d)localObject1).pNq.pQe.pVl, 30), 0) / 100.0D;
          j = (int)(k * (1.0D + d));
        }
        if (((d)localObject1).pOA != j)
        {
          ((d)localObject1).zP(j);
          y.i("MeidaCodec[HWEnc]", "steve[QoS]: Update BR! frameID: " + d.pOI + ", new_br: " + ((d)localObject1).pOA + ", tuneBR:" + j + ", tuneRatio:" + ((d)localObject1).pNq.pQe.pVl);
          ((d)localObject1).pOA = j;
        }
        if ((1 == ((d)localObject1).pOU.pPm) && (d.pOI > 0))
        {
          if (((d)localObject1).pOw != null)
          {
            y.v("MeidaCodec[HWEnc]", "steve: Sync frame request soon!");
            localObject2 = new Bundle();
            ((Bundle)localObject2).putInt("request-sync", 0);
            ((d)localObject1).pOw.setParameters((Bundle)localObject2);
          }
          y.i("MeidaCodec[HWEnc]", "steve[QoS]: Force I Frame! frameID: " + d.pOI);
        }
        if (((d)localObject1).pOU.pPb != ((d)localObject1).pOz) {
          ((d)localObject1).pOz = ((d)localObject1).pOU.pPb;
        }
      }
      boolean bool = this.pNq.pQe.pWj.ENCODING.equalsIgnoreCase("video/avc");
      if ((this.pNq.pQe.pWj.ENCODING.equalsIgnoreCase("video/hevc")) || ((bool) && (1 == (this.pNq.pQe.pWj.pOU.pPj & 0x1)) && (this.pNq.pQe.pWj.pOU.pPi >= 6))) {
        this.pQJ = true;
      }
    }
    for (;;)
    {
      long l = System.currentTimeMillis();
      y.d("MicroMsg.Voip.VoipDeviceHandler", "steve: put video capture in, time:" + l + ", len:" + paramInt1 + ", cnt:" + this.pNq.pQe.pVS + ", mIsHWEncEnable:" + this.pNq.pQe.pWn + ", mIsHWEncUsing:" + this.pQJ);
      if ((!this.pQJ) || (this.pNq.pQe.pWj == null)) {
        break label1167;
      }
      if (1 != this.pQL >> 8)
      {
        this.pQL |= 0x100;
        this.pNq.pQf.setHWDecMode(this.pQL);
      }
      paramInt1 = this.pNq.pQe.pWj.e(paramArrayOfByte, paramInt3, paramInt4, paramInt2);
      if (paramInt1 < 0) {
        break label1138;
      }
      return 1;
      label1116:
      i = 0;
      break;
      this.pQJ = false;
      continue;
      this.pQJ = false;
    }
    label1138:
    y.d("MicroMsg.Voip.VoipDeviceHandler", "StopHWEnc!! hw encoder error: " + paramInt1);
    this.pQK = true;
    return 0;
    label1167:
    if (this.pQL >> 8 != 0)
    {
      this.pQL &= 0xFFFFFEFF;
      this.pNq.pQf.setHWDecMode(this.pQL);
    }
    return this.pNq.pQe.videoEncodeToSend(paramArrayOfByte, paramInt1, paramInt3, paramInt4, paramInt2);
  }
  
  public final int bPG()
  {
    if ((this.pQB != null) && (this.pNq.pQe.pWi.pRe == 1)) {
      return this.pQB.bPG();
    }
    return 0;
  }
  
  public final int bQk()
  {
    if ((this.iEq != null) && (this.pNq.pQe.pWi.pRe == 1)) {
      return this.iEq.bCt;
    }
    return 0;
  }
  
  public final void bQl()
  {
    int j = 0;
    try
    {
      y.i("MicroMsg.Voip.VoipDeviceHandler", "stopDev, recorder: %s", new Object[] { this.iEq });
      if (this.iEu == iEt)
      {
        com.tencent.mm.plugin.voip.a.a.Loge("MicroMsg.Voip.VoipDeviceHandler", "devcie stoped already.");
        synchronized (this.iEx)
        {
          if (this.iEq != null)
          {
            y.e("MicroMsg.Voip.VoipDeviceHandler", "status DEV_STOP, but recorder still not null!!");
            this.iEq.uh();
            this.iEq = null;
          }
          return;
        }
      }
      com.tencent.mm.plugin.voip.a.a.Logi("MicroMsg.Voip.VoipDeviceHandler", "stop device..");
    }
    finally {}
    this.iEu = iEt;
    if (this.pQQ != null)
    {
      com.tencent.mm.plugin.voip.a.a.Logd("MicroMsg.Voip.VoipDeviceHandler", "stop videodecode thread..");
      this.pQQ.pQT = true;
      e.remove(this.pQQ);
      this.pQQ = null;
    }
    this.iEw = 1;
    this.pQH = 0;
    this.iEz = 1;
    this.pQM = 1;
    this.iEA = 0L;
    this.pQN = 0L;
    this.iEv = 92;
    this.pQC = 0L;
    this.pQD = 0L;
    this.pQE = 1;
    this.pQF = 0;
    this.iEy = 0;
    this.pNq.pQe.pUP = bQk();
    this.pNq.pQe.pUQ = bPG();
    ??? = this.pNq.pQe;
    if ((this.iEq != null) && (this.pNq.pQe.pWi.pRe == 1)) {}
    for (int i = this.iEq.us();; i = -2) {
      for (;;)
      {
        ((v2protocal)???).pUT = i;
        ??? = this.pNq.pQe;
        i = j;
        if (this.pQB != null)
        {
          i = j;
          if (this.pNq.pQe.pWi.pRe == 1) {
            i = this.pQB.bPH();
          }
        }
        float f = f.yi().getStreamMaxVolume(i);
        ((v2protocal)???).pVa = ((int)(f.yi().getStreamVolume(i) / f * 100.0F));
        synchronized (this.iEx)
        {
          if ((this.pQB != null) && (this.iEq != null))
          {
            e.a(new l.a(this, this.pQB, this.iEq), "VoipDeviceHandler_stopDev", 10);
            y.i("MicroMsg.Voip.VoipDeviceHandler", "do stop record");
            this.pQB = null;
            this.iEq = null;
          }
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.voip.model.l
 * JD-Core Version:    0.7.0.1
 */