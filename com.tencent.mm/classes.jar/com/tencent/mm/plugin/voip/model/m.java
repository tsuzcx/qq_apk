package com.tencent.mm.plugin.voip.model;

import android.media.MediaCodec;
import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.audio.b.c.a;
import com.tencent.mm.compatible.b.g;
import com.tencent.mm.plugin.voip.a.a;
import com.tencent.mm.sdk.g.d;
import com.tencent.mm.sdk.platformtools.ab;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;

public final class m
{
  public static int kJE = 3;
  public static int tvS = 0;
  public static int tvT = 0;
  volatile com.tencent.mm.audio.b.c kJB;
  public int kJF;
  int kJG;
  private int kJH;
  private final Object kJI;
  public int kJJ;
  private int kJL;
  private long kJM;
  private c.a kJP;
  public k ttm;
  c tvF;
  private long tvG;
  private long tvH;
  private int tvI;
  private int tvJ;
  private long tvK;
  private int tvL;
  private int tvM;
  public boolean tvN;
  public boolean tvO;
  public int tvP;
  private int tvQ;
  private long tvR;
  m.b tvU;
  
  public m(k paramk)
  {
    AppMethodBeat.i(4441);
    this.tvF = null;
    this.kJB = null;
    this.kJF = 1;
    this.ttm = null;
    this.kJG = 92;
    this.tvG = 0L;
    this.tvH = 0L;
    this.tvI = 1;
    this.tvJ = 0;
    this.kJH = 1;
    this.tvK = 0L;
    this.tvL = 0;
    this.tvM = 0;
    this.kJI = new Object();
    this.kJJ = 0;
    this.tvN = false;
    this.tvO = false;
    this.tvP = 0;
    this.kJL = 1;
    this.tvQ = 1;
    this.kJM = 0L;
    this.tvR = 0L;
    this.kJP = new m.1(this);
    this.ttm = paramk;
    AppMethodBeat.o(4441);
  }
  
  public final int b(byte[] paramArrayOfByte, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    AppMethodBeat.i(4446);
    if (this.kJF != 2)
    {
      AppMethodBeat.o(4446);
      return 0;
    }
    if (!this.ttm.cMg())
    {
      AppMethodBeat.o(4446);
      return 0;
    }
    Object localObject1 = this.ttm.tvj;
    ((v2protocal)localObject1).tBx += 1;
    if (this.tvO)
    {
      ab.i("MicroMsg.Voip.VoipDeviceHandler", "steve: StopHWEnc!!!");
      this.ttm.tvj.kLn = false;
      this.tvN = false;
      this.tvO = false;
      this.ttm.Hl(1);
      localObject1 = s.tyN;
      s.cNL();
    }
    boolean bool1 = this.tvN;
    int i;
    if ((this.ttm.tvj.kLn) && (this.ttm.tvj.tBO != null))
    {
      localObject1 = this.ttm.tvj.tBO;
      if ((((e)localObject1).ttm != null) && (((e)localObject1).ttm.tvj != null))
      {
        Object localObject2;
        if (((e)localObject1).ttm.tvj.setAppCmd(e.EMethodGetQosPara, ((e)localObject1).tus.s2p, ((e)localObject1).tus.s2p.length) >= 0)
        {
          localObject2 = ((e)localObject1).tus;
          ByteBuffer localByteBuffer = ByteBuffer.wrap(((e.a)localObject2).s2p);
          localByteBuffer.order(ByteOrder.LITTLE_ENDIAN);
          ((e.a)localObject2).iKbps = localByteBuffer.getShort();
          ((e.a)localObject2).cFps = localByteBuffer.get();
          ((e.a)localObject2).cIPeriod = localByteBuffer.get();
          ((e.a)localObject2).cRSLevel = localByteBuffer.get();
          ((e.a)localObject2).cQPmin = localByteBuffer.get();
          ((e.a)localObject2).cQPmax = localByteBuffer.get();
          ((e.a)localObject2).cHPPMaxLyr = localByteBuffer.get();
          ((e.a)localObject2).cSwitch = localByteBuffer.get();
          ((e.a)localObject2).cResolution = localByteBuffer.get();
          ((e.a)localObject2).cRsvd1 = localByteBuffer.get();
          ((e.a)localObject2).cRsvd2 = localByteBuffer.get();
          ((e.a)localObject2).cSkipFlag = localByteBuffer.get();
          ((e.a)localObject2).cIReqFlag = localByteBuffer.get();
          localObject2 = ((e)localObject1).tus;
          ab.d("MeidaCodec[HWEnc]", "raw S2P:" + ((e.a)localObject2).s2p);
          ab.d("MeidaCodec[HWEnc]", "-S2P- iKbps:" + ((e.a)localObject2).iKbps + ", fps:" + ((e.a)localObject2).cFps + ", IP:" + ((e.a)localObject2).cIPeriod + ", RS:" + ((e.a)localObject2).cRSLevel + ", QPMin:" + ((e.a)localObject2).cQPmin + ", QPMax:" + ((e.a)localObject2).cQPmax + ", HPP:" + ((e.a)localObject2).cHPPMaxLyr + ", SWitch:" + ((e.a)localObject2).cSwitch + ", Reso:" + ((e.a)localObject2).cResolution + ", Rsvd1:" + ((e.a)localObject2).cRsvd1 + ", Rsvd2:" + ((e.a)localObject2).cRsvd2 + ", Skip:" + ((e.a)localObject2).cSkipFlag + ", IReq:" + ((e.a)localObject2).cIReqFlag);
        }
        int k = ((e)localObject1).tus.iKbps;
        if (((e)localObject1).kKe != 8) {
          break label1179;
        }
        i = 1;
        int j = k;
        if (i == 0)
        {
          double d = 1.0D * Math.max(Math.min(((e)localObject1).ttm.tvj.tAN, 30), 0) / 100.0D;
          j = (int)(k * (1.0D + d));
        }
        if (((e)localObject1).m_br_kbps != j)
        {
          ((e)localObject1).SetBitRate(j);
          ab.i("MeidaCodec[HWEnc]", "steve[QoS]: Update BR! frameID: " + e.frameID + ", new_br: " + ((e)localObject1).m_br_kbps + ", tuneBR:" + j + ", tuneRatio:" + ((e)localObject1).ttm.tvj.tAN);
          ((e)localObject1).m_br_kbps = j;
        }
        if ((1 == ((e)localObject1).tus.cIReqFlag) && (e.frameID > 0))
        {
          if (((e)localObject1).mediaCodec != null)
          {
            ab.v("MeidaCodec[HWEnc]", "steve: Sync frame request soon!");
            localObject2 = new Bundle();
            ((Bundle)localObject2).putInt("request-sync", 0);
            ((e)localObject1).mediaCodec.setParameters((Bundle)localObject2);
          }
          ab.i("MeidaCodec[HWEnc]", "steve[QoS]: Force I Frame! frameID: " + e.frameID);
        }
        if (((e)localObject1).tus.cFps != ((e)localObject1).m_framerate) {
          ((e)localObject1).m_framerate = ((e)localObject1).tus.cFps;
        }
      }
      boolean bool2 = this.ttm.tvj.tBO.ENCODING.equalsIgnoreCase("video/avc");
      if ((this.ttm.tvj.tBO.ENCODING.equalsIgnoreCase("video/hevc")) || ((bool2) && (1 == (this.ttm.tvj.tBO.tus.cRsvd1 & 0x1)) && (this.ttm.tvj.tBO.tus.cResolution >= 6)))
      {
        this.tvN = true;
        label974:
        if ((!bool1) || (this.tvN)) {
          break label1201;
        }
        localObject1 = s.tyN;
        s.cNL();
        label994:
        long l = System.currentTimeMillis();
        ab.d("MicroMsg.Voip.VoipDeviceHandler", "steve: put video capture in, time:" + l + ", len:" + paramInt1 + ", cnt:" + this.ttm.tvj.tBx + ", mIsHWEncEnable:" + this.ttm.tvj.kLn + ", mIsHWEncUsing:" + this.tvN);
        i = 0;
        if ((!this.tvN) || (this.ttm.tvj.tBO == null)) {
          break label1263;
        }
        if (1 != this.tvP >> 8)
        {
          this.tvP |= 0x100;
          this.ttm.tvk.setHWDecMode(this.tvP);
        }
        paramInt1 = this.ttm.tvj.tBO.b(paramArrayOfByte, paramInt3, paramInt4, paramInt2);
        if (paramInt1 < 0) {
          break label1237;
        }
        paramInt1 = 1;
      }
    }
    for (;;)
    {
      AppMethodBeat.o(4446);
      return paramInt1;
      label1179:
      i = 0;
      break;
      this.tvN = false;
      break label974;
      this.tvN = false;
      break label974;
      label1201:
      if ((bool1) || (!this.tvN) || (this.ttm.tvj.tBO == null)) {
        break label994;
      }
      localObject1 = s.tyN;
      s.cNK();
      break label994;
      label1237:
      ab.i("MicroMsg.Voip.VoipDeviceHandler", "StopHWEnc!! hw encoder error: ".concat(String.valueOf(paramInt1)));
      this.tvO = true;
      paramInt1 = i;
      continue;
      label1263:
      if (this.tvP >> 8 != 0)
      {
        this.tvP &= 0xFFFFFEFF;
        this.ttm.tvk.setHWDecMode(this.tvP);
      }
      paramInt1 = this.ttm.tvj.videoEncodeToSend(paramArrayOfByte, paramInt1, paramInt3, paramInt4, paramInt2);
    }
  }
  
  public final int cLK()
  {
    AppMethodBeat.i(4442);
    if ((this.tvF != null) && (this.ttm.tvj.tBN.twl == 1))
    {
      int i = this.tvF.cLK();
      AppMethodBeat.o(4442);
      return i;
    }
    AppMethodBeat.o(4442);
    return 0;
  }
  
  public final int cMo()
  {
    if ((this.kJB != null) && (this.ttm.tvj.tBN.twl == 1)) {
      return this.kJB.cjh;
    }
    return 0;
  }
  
  public final void cMp()
  {
    int j = 0;
    for (;;)
    {
      try
      {
        AppMethodBeat.i(4443);
        ab.i("MicroMsg.Voip.VoipDeviceHandler", "stopDev, recorder: %s", new Object[] { this.kJB });
        if (this.kJF == kJE)
        {
          a.Loge("MicroMsg.Voip.VoipDeviceHandler", "devcie stoped already.");
          synchronized (this.kJI)
          {
            if (this.kJB != null)
            {
              ab.e("MicroMsg.Voip.VoipDeviceHandler", "status DEV_STOP, but recorder still not null!!");
              this.kJB.Et();
              this.kJB = null;
            }
            AppMethodBeat.o(4443);
            return;
          }
        }
        a.Logi("MicroMsg.Voip.VoipDeviceHandler", "stop device..");
      }
      finally {}
      this.kJF = kJE;
      if (this.tvU != null)
      {
        a.Logd("MicroMsg.Voip.VoipDeviceHandler", "stop videodecode thread..");
        this.tvU.tvX = true;
        d.ysm.remove(this.tvU);
        this.tvU = null;
      }
      this.kJH = 1;
      this.tvL = 0;
      this.kJL = 1;
      this.tvQ = 1;
      this.kJM = 0L;
      this.tvR = 0L;
      this.kJG = 92;
      this.tvG = 0L;
      this.tvH = 0L;
      this.tvI = 1;
      this.tvJ = 0;
      this.kJJ = 0;
      this.ttm.tvj.tAr = cMo();
      this.ttm.tvj.tAs = cLK();
      ??? = this.ttm.tvj;
      int i;
      if ((this.kJB != null) && (this.ttm.tvj.tBN.twl == 1))
      {
        i = this.kJB.EF();
        ((v2protocal)???).tAv = i;
        ??? = this.ttm.tvj;
        i = j;
        if (this.tvF != null)
        {
          i = j;
          if (this.ttm.tvj.tBN.twl == 1) {
            i = this.tvF.cLL();
          }
        }
        float f = g.KC().getStreamMaxVolume(i);
        ((v2protocal)???).tAC = ((int)(g.KC().getStreamVolume(i) / f * 100.0F));
      }
      synchronized (this.kJI)
      {
        if ((this.tvF != null) && (this.kJB != null))
        {
          d.f(new a(this.tvF, this.kJB), "VoipDeviceHandler_stopDev");
          ab.i("MicroMsg.Voip.VoipDeviceHandler", "do stop record");
          this.tvF = null;
          this.kJB = null;
        }
        AppMethodBeat.o(4443);
        continue;
        i = -2;
      }
    }
  }
  
  public final void cMq()
  {
    AppMethodBeat.i(4444);
    ab.b("MicroMsg.Voip.VoipDeviceHandler", "forceCleanRecord, recorder %s", new Object[] { this.kJB });
    synchronized (this.kJI)
    {
      if (this.kJB != null)
      {
        ab.i("MicroMsg.Voip.VoipDeviceHandler", "do stop record");
        this.kJB.Et();
        this.kJB = null;
      }
      AppMethodBeat.o(4444);
      return;
    }
  }
  
  public final boolean mJ(boolean paramBoolean)
  {
    AppMethodBeat.i(4445);
    if (this.tvF != null)
    {
      paramBoolean = this.tvF.mJ(paramBoolean);
      AppMethodBeat.o(4445);
      return paramBoolean;
    }
    AppMethodBeat.o(4445);
    return false;
  }
  
  final class a
    implements Runnable
  {
    private c nNJ = null;
    private com.tencent.mm.audio.b.c nNY = null;
    
    public a(c paramc, com.tencent.mm.audio.b.c paramc1)
    {
      this.nNJ = paramc;
      this.nNY = paramc1;
    }
    
    public final void run()
    {
      AppMethodBeat.i(4439);
      if (this.nNJ != null)
      {
        this.nNJ.cLJ();
        this.nNJ.cLG();
        this.nNJ = null;
      }
      ab.i("MicroMsg.Voip.VoipDeviceHandler", "do stopRecord");
      if (this.nNY != null)
      {
        this.nNY.Et();
        this.nNY = null;
        ab.i("MicroMsg.Voip.VoipDeviceHandler", "finish stopRecord");
      }
      AppMethodBeat.o(4439);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.voip.model.m
 * JD-Core Version:    0.7.0.1
 */