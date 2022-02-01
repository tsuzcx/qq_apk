package com.tencent.mm.plugin.voip.model;

import android.media.AudioManager;
import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.audio.b.c.a;
import com.tencent.mm.compatible.deviceinfo.z;
import com.tencent.mm.compatible.util.f;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.ap;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;

public final class n
{
  public static int nPI = 3;
  public static int zjY = 0;
  public static int zjZ = 0;
  volatile com.tencent.mm.audio.b.c nPF;
  public int nPJ;
  int nPK;
  private int nPL;
  public int nPN;
  private int nPP;
  private long nPQ;
  private c.a nPS;
  l zfA;
  volatile c zjI;
  private long zjJ;
  private long zjK;
  private int zjL;
  private int zjM;
  private long zjN;
  private int zjO;
  private int zjP;
  final Object zjQ;
  public boolean zjR;
  public boolean zjS;
  public int zjT;
  private int zjU;
  private long zjV;
  public ap zjW;
  long zjX;
  a zka;
  
  public n(l paraml)
  {
    AppMethodBeat.i(114946);
    this.zjI = null;
    this.nPF = null;
    this.nPJ = 1;
    this.zfA = null;
    this.nPK = 92;
    this.zjJ = 0L;
    this.zjK = 0L;
    this.zjL = 1;
    this.zjM = 0;
    this.nPL = 1;
    this.zjN = 0L;
    this.zjO = 0;
    this.zjP = 0;
    this.zjQ = new Object();
    this.nPN = 0;
    this.zjR = false;
    this.zjS = false;
    this.zjT = 0;
    this.nPP = 1;
    this.zjU = 1;
    this.nPQ = 0L;
    this.zjV = 0L;
    this.zjX = 0L;
    this.nPS = new c.a()
    {
      public final void ch(int paramAnonymousInt1, int paramAnonymousInt2) {}
      
      public final void w(byte[] paramAnonymousArrayOfByte, int paramAnonymousInt)
      {
        AppMethodBeat.i(114941);
        for (;;)
        {
          synchronized (n.n(n.this))
          {
            if (com.tencent.mm.plugin.audio.c.a.bvB().audioManager.isMusicActive()) {
              com.tencent.mm.audio.c.b.a.ih(1);
            }
            com.tencent.mm.audio.c.b.a.e(paramAnonymousInt, paramAnonymousArrayOfByte);
            if ((n.this.nPJ != 2) || (n.a(n.this) == null))
            {
              AppMethodBeat.o(114941);
              return;
            }
            if (n.b(n.this) == 1)
            {
              n.a(n.this, System.currentTimeMillis());
              n.b(n.this, n.c(n.this));
              n.d(n.this);
              if (n.f(n.this) <= 10) {
                n.b(n.this, 92);
              }
              int i = n.a(n.this).dRV();
              n.b(n.this, (i + 24 + n.f(n.this) * 3) / 4);
              if (n.g(n.this) != 1) {
                break label422;
              }
              n.c(n.this, n.a(n.this).dRS());
              if (n.h(n.this) >= n.f(n.this)) {
                n.c(n.this, n.h(n.this) - n.f(n.this));
              }
              n.b(n.this, n.h(n.this));
              n.i(n.this);
              if (1 != n.j(n.this)) {
                break label434;
              }
              n.k(n.this);
              n.c(n.this, System.currentTimeMillis());
              com.tencent.mm.plugin.voip.b.c.Logi("MicroMsg.Voip.VoipDeviceHandler", "amyfwang,first record");
              if (n.m(n.this) == null) {
                continue;
              }
              n.this.zfA.ziZ.znW = n.m(n.this).Oj();
              n.this.zfA.ziZ.recordCallback(paramAnonymousArrayOfByte, paramAnonymousInt, n.f(n.this));
              n.zjZ += 1;
            }
          }
          long l1 = System.currentTimeMillis();
          n.a(n.this, (int)(l1 - n.e(n.this) - n.zjZ * 20));
          n.a(n.this, l1);
          continue;
          label422:
          n.b(n.this, 0);
          continue;
          label434:
          l1 = System.currentTimeMillis();
          long l2 = l1 - n.l(n.this);
          if (l2 > 1000L) {
            com.tencent.mm.plugin.voip.b.c.Logi("MicroMsg.Voip.VoipDeviceHandler", "amyfwang,error,record deltaTime:".concat(String.valueOf(l2)));
          }
          n.c(n.this, l1);
        }
      }
    };
    this.zfA = paraml;
    if ((this.zjW == null) || (this.zjW.isQuit())) {
      this.zjW = new ap("VoipDeviceHandler_stopDev");
    }
    AppMethodBeat.o(114946);
  }
  
  private void dTw()
  {
    AppMethodBeat.i(114951);
    ad.i("MicroMsg.Voip.VoipDeviceHandler", "steve: StopHWEnc!!!");
    this.zfA.ziZ.nRs = false;
    this.zjR = false;
    this.zjS = false;
    AppMethodBeat.o(114951);
  }
  
  public final int b(byte[] paramArrayOfByte, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    AppMethodBeat.i(114952);
    if (this.nPJ != 2)
    {
      AppMethodBeat.o(114952);
      return 0;
    }
    if (!this.zfA.dTh())
    {
      AppMethodBeat.o(114952);
      return 0;
    }
    Object localObject1 = this.zfA.ziZ;
    ((v2protocal)localObject1).zpa += 1;
    if (this.zjS)
    {
      dTw();
      if (this.zfA.zjm) {
        this.zfA.Qe(1);
      }
      this.zfA.b(8, true, false, true);
      localObject1 = t.zlN;
      t.dUn();
    }
    boolean bool1 = this.zjR;
    int i;
    if ((this.zfA.ziZ.nRs) && (this.zfA.ziZ.zpt != null))
    {
      localObject1 = this.zfA.ziZ.zpt;
      if ((((e)localObject1).zfA != null) && (((e)localObject1).zfA.ziZ != null))
      {
        Object localObject2;
        if (((e)localObject1).zfA.ziZ.setAppCmd(e.EMethodGetQosPara, ((e)localObject1).zgJ.s2p, ((e)localObject1).zgJ.s2p.length) >= 0)
        {
          localObject2 = ((e)localObject1).zgJ;
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
          localObject2 = ((e)localObject1).zgJ;
          ad.d("MeidaCodec[HWEnc]", "raw S2P:" + ((e.a)localObject2).s2p);
          ad.d("MeidaCodec[HWEnc]", "-S2P- iKbps:" + ((e.a)localObject2).iKbps + ", fps:" + ((e.a)localObject2).cFps + ", IP:" + ((e.a)localObject2).cIPeriod + ", RS:" + ((e.a)localObject2).cRSLevel + ", QPMin:" + ((e.a)localObject2).cQPmin + ", QPMax:" + ((e.a)localObject2).cQPmax + ", HPP:" + ((e.a)localObject2).cHPPMaxLyr + ", SWitch:" + ((e.a)localObject2).cSwitch + ", Reso:" + ((e.a)localObject2).cResolution + ", Rsvd1:" + ((e.a)localObject2).cRsvd1 + ", Rsvd2:" + ((e.a)localObject2).cRsvd2 + ", Skip:" + ((e.a)localObject2).cSkipFlag + ", IReq:" + ((e.a)localObject2).cIReqFlag);
        }
        int k = ((e)localObject1).zgJ.iKbps;
        if (((e)localObject1).nQf != 8) {
          break label1194;
        }
        i = 1;
        int j = k;
        if (i == 0)
        {
          double d = 1.0D * Math.max(Math.min(((e)localObject1).zfA.ziZ.zom, 30), 0) / 100.0D;
          j = (int)(k * (1.0D + d));
        }
        if (((e)localObject1).m_br_kbps != j)
        {
          ((e)localObject1).SetBitRate(j);
          ad.i("MeidaCodec[HWEnc]", "steve[QoS]: Update BR! frameID: " + e.frameID + ", new_br: " + ((e)localObject1).m_br_kbps + ", tuneBR:" + j + ", tuneRatio:" + ((e)localObject1).zfA.ziZ.zom);
          ((e)localObject1).m_br_kbps = j;
        }
        if ((1 == ((e)localObject1).zgJ.cIReqFlag) && (e.frameID > 0))
        {
          if (((e)localObject1).nPY != null)
          {
            ad.v("MeidaCodec[HWEnc]", "steve: Sync frame request soon!");
            localObject2 = new Bundle();
            ((Bundle)localObject2).putInt("request-sync", 0);
            ((e)localObject1).nPY.setParameters((Bundle)localObject2);
          }
          ad.i("MeidaCodec[HWEnc]", "steve[QoS]: Force I Frame! frameID: " + e.frameID);
        }
        if (((e)localObject1).zgJ.cFps != ((e)localObject1).m_framerate) {
          ((e)localObject1).m_framerate = ((e)localObject1).zgJ.cFps;
        }
      }
      boolean bool2 = this.zfA.ziZ.zpt.ENCODING.equalsIgnoreCase("video/avc");
      if ((this.zfA.ziZ.zpt.ENCODING.equalsIgnoreCase("video/hevc")) || ((bool2) && (1 == (this.zfA.ziZ.zpt.zgJ.cRsvd1 & 0x1)) && (this.zfA.ziZ.zpt.zgJ.cResolution >= 6)))
      {
        this.zjR = true;
        label973:
        if ((!bool1) || (this.zjR)) {
          break label1216;
        }
        localObject1 = t.zlN;
        t.dUn();
        label993:
        long l = System.currentTimeMillis();
        ad.d("MicroMsg.Voip.VoipDeviceHandler", "steve: put video capture in, time:" + l + ", len:" + paramInt1 + ", cnt:" + this.zfA.ziZ.zpa + ", mIsHWEncEnable:" + this.zfA.ziZ.nRs + ", mIsHWEncUsing:" + this.zjR);
        i = 0;
        if ((!this.zjR) || (this.zfA.ziZ.zpt == null)) {
          break label1338;
        }
        if (1 != this.zjT >> 8)
        {
          this.zjT |= 0x100;
          this.zfA.zja.setHWDecMode(this.zjT);
        }
        paramInt1 = i;
        if (this.zfA.ziZ.zpt != null)
        {
          paramInt1 = this.zfA.ziZ.zpt.b(paramArrayOfByte, paramInt3, paramInt4, paramInt2);
          if (paramInt1 < 0) {
            break label1252;
          }
          paramInt1 = 1;
        }
      }
    }
    for (;;)
    {
      AppMethodBeat.o(114952);
      return paramInt1;
      label1194:
      i = 0;
      break;
      this.zjR = false;
      break label973;
      this.zjR = false;
      break label973;
      label1216:
      if ((bool1) || (!this.zjR) || (this.zfA.ziZ.zpt == null)) {
        break label993;
      }
      localObject1 = t.zlN;
      t.dUm();
      break label993;
      label1252:
      ad.i("MicroMsg.Voip.VoipDeviceHandler", "StopHWEnc!! hw encoder error: " + paramInt1 + "old:" + this.zfA.zjm);
      if (this.zfA.zjm) {
        this.zfA.Qe(1);
      }
      dTw();
      paramArrayOfByte = t.zlN;
      t.dUn();
      this.zfA.b(8, true, false, true);
      paramInt1 = i;
      continue;
      label1338:
      if (this.zjT >> 8 != 0)
      {
        this.zjT &= 0xFFFFFEFF;
        this.zfA.zja.setHWDecMode(this.zjT);
      }
      paramInt1 = this.zfA.ziZ.videoEncodeToSend(paramArrayOfByte, paramInt1, paramInt3, paramInt4, paramInt2);
    }
  }
  
  public final int dRX()
  {
    AppMethodBeat.i(114947);
    if ((this.zjI != null) && (this.zfA.ziZ.zpq.zkr == 1))
    {
      int i = this.zjI.dRX();
      AppMethodBeat.o(114947);
      return i;
    }
    AppMethodBeat.o(114947);
    return 0;
  }
  
  public final int dTt()
  {
    if ((this.nPF != null) && (this.zfA.ziZ.zpq.zkr == 1)) {
      return this.nPF.cXZ;
    }
    return 0;
  }
  
  public final void dTu()
  {
    int j = 0;
    for (;;)
    {
      try
      {
        AppMethodBeat.i(114948);
        ad.i("MicroMsg.Voip.VoipDeviceHandler", "stopDev, recorder: %s", new Object[] { this.nPF });
        if (this.nPJ == nPI)
        {
          com.tencent.mm.plugin.voip.b.c.Loge("MicroMsg.Voip.VoipDeviceHandler", "devcie stoped already.");
          dTv();
          AppMethodBeat.o(114948);
          return;
        }
        com.tencent.mm.plugin.voip.b.c.Logi("MicroMsg.Voip.VoipDeviceHandler", "stop device..");
        this.nPJ = nPI;
        if (this.zka != null)
        {
          com.tencent.mm.plugin.voip.b.c.Logd("MicroMsg.Voip.VoipDeviceHandler", "stop videodecode thread..");
          this.zka.zkd = true;
          this.zka.cancel();
          this.zka = null;
        }
        this.nPL = 1;
        this.zjO = 0;
        this.nPP = 1;
        this.zjU = 1;
        this.nPQ = 0L;
        this.zjV = 0L;
        this.nPK = 92;
        this.zjJ = 0L;
        this.zjK = 0L;
        this.zjL = 1;
        this.zjM = 0;
        this.nPN = 0;
        this.zfA.ziZ.znJ = dTt();
        this.zfA.ziZ.znK = dRX();
        v2protocal localv2protocal = this.zfA.ziZ;
        int i;
        if ((this.nPF != null) && (this.zfA.ziZ.zpq.zkr == 1))
        {
          i = this.nPF.On();
          localv2protocal.znN = i;
          localv2protocal = this.zfA.ziZ;
          i = j;
          if (this.zjI != null)
          {
            i = j;
            if (this.zfA.ziZ.zpq.zkr == 1) {
              i = this.zjI.aDs();
            }
          }
          float f = com.tencent.mm.plugin.audio.c.a.getStreamMaxVolume(i);
          localv2protocal.znU = ((int)(com.tencent.mm.plugin.audio.c.a.getStreamVolume(i) / f * 100.0F));
          dTv();
          AppMethodBeat.o(114948);
        }
        else
        {
          i = -2;
        }
      }
      finally {}
    }
  }
  
  public final void dTv()
  {
    AppMethodBeat.i(114949);
    ad.m("MicroMsg.Voip.VoipDeviceHandler", "forceCleanRecord, recorder %s", new Object[] { this.nPF });
    if (this.zjW != null) {
      synchronized (this.zjQ)
      {
        if ((this.zjI != null) || (this.nPF != null))
        {
          ad.i("MicroMsg.Voip.VoipDeviceHandler", "forceCleanRecord process post runnable");
          if (this.zjW != null)
          {
            this.zjW.removeCallbacksAndMessages(null);
            this.zjW.post(new Runnable()
            {
              public final void run()
              {
                AppMethodBeat.i(114944);
                ad.i("MicroMsg.Voip.VoipDeviceHandler", "forceCleanRecord process post success and wait running");
                if (n.a(n.this) != null)
                {
                  n.a(n.this).dRW();
                  n.a(n.this).dRT();
                  n.s(n.this);
                  ad.i("MicroMsg.Voip.VoipDeviceHandler", "finish stopRecord and release player");
                }
                ad.i("MicroMsg.Voip.VoipDeviceHandler", "do stopRecord");
                if (n.m(n.this) != null)
                {
                  n.m(n.this).Ob();
                  n.t(n.this);
                  ad.i("MicroMsg.Voip.VoipDeviceHandler", "finish stopRecord and release recorder");
                }
                ad.i("MicroMsg.Voip.VoipDeviceHandler", "forceCleanRecord process post success and quitSafely");
                AppMethodBeat.o(114944);
              }
            });
          }
        }
        AppMethodBeat.o(114949);
        return;
      }
    }
    ad.i("MicroMsg.Voip.VoipDeviceHandler", "forceCleanRecord failed but mDevHandler is null");
    AppMethodBeat.o(114949);
  }
  
  final class a
    extends com.tencent.e.i.b
  {
    boolean zkc = false;
    boolean zkd = false;
    byte[] zke = null;
    ByteBuffer zkf = null;
    int zkg = 0;
    
    a() {}
    
    public final String getKey()
    {
      return "stop_video_decode_runnable";
    }
    
    public final void run()
    {
      AppMethodBeat.i(114945);
      if ((n.this.nPJ == 2) && (!this.zkd))
      {
        long l1 = System.currentTimeMillis();
        int i;
        int j;
        boolean bool1;
        boolean bool2;
        Object localObject1;
        if (n.this.zfA.dTi())
        {
          if (this.zke == null)
          {
            this.zkf = ByteBuffer.allocateDirect(n.this.zfA.ziZ.defaultWidth * n.this.zfA.ziZ.defaultHeight * 4).order(ByteOrder.nativeOrder());
            this.zkf.position(0);
            this.zke = new byte[this.zkf.remaining()];
            ad.i("MicroMsg.Voip.VoipDeviceHandler", "init remoteImageByteBuffer, defaultWidth:%s, defaultHeight:%s", new Object[] { Integer.valueOf(n.this.zfA.ziZ.defaultWidth), Integer.valueOf(n.this.zfA.ziZ.defaultHeight) });
          }
          i = 0;
          if (this.zkf != null)
          {
            this.zkf.clear();
            i = n.this.zfA.ziZ.videoDecodeBB(this.zkf);
          }
          if (i == 1)
          {
            this.zkg += 1;
            this.zkf.get(this.zke);
            i = n.this.zfA.ziZ.field_remoteImgWidth;
            j = n.this.zfA.ziZ.field_remoteImgHeight;
            if ((i != 0) || (j >= 3)) {
              break label561;
            }
            bool1 = true;
            if (this.zkg % 200 == 10) {
              ad.i("MicroMsg.Voip.VoipDeviceHandler", "steve: dec statistics: total:%d, soft:%d, size:%dx%d, HW:%b", new Object[] { Integer.valueOf(this.zkg), Integer.valueOf(n.this.zfA.ziZ.zpe), Integer.valueOf(i), Integer.valueOf(j), Boolean.valueOf(bool1) });
            }
            bool2 = false;
            if (!bool1) {
              break label604;
            }
            if (!this.zkc)
            {
              localObject1 = n.this;
              ((n)localObject1).zjT |= 0x1;
              n.this.zfA.zja.setHWDecMode(n.this.zjT);
              bool2 = true;
              ad.i("MicroMsg.Voip.VoipDeviceHandler", "steve: change to HW dec, restart decoder!");
              localObject1 = t.zlN;
              t.dUk();
            }
            if (v2protocal.zpu == null) {}
          }
        }
        for (;;)
        {
          try
          {
            for (;;)
            {
              i = n.this.zfA.ziZ.field_remoteImgLength;
              ad.d("MicroMsg.Voip.VoipDeviceHandler", "steve:video decode successfully!..len=".concat(String.valueOf(i)));
              j = n.this.zfA.ziZ.field_remoteImgHeight;
              localObject1 = new byte[i];
              System.arraycopy(this.zke, 0, localObject1, 0, i);
              v2protocal.zpu.f((byte[])localObject1, j, bool2);
              long l2 = System.currentTimeMillis();
              ad.d("MicroMsg.Voip.VoipDeviceHandler", "steve: fill in AvcDecoder take time = " + (l2 - l1) + ", startTime = " + l1);
              this.zkc = bool1;
              try
              {
                Thread.sleep(10L);
              }
              catch (InterruptedException localInterruptedException)
              {
                ad.printErrStackTrace("MicroMsg.Voip.VoipDeviceHandler", localInterruptedException, "", new Object[0]);
              }
            }
            break;
            label561:
            bool1 = false;
          }
          catch (Exception localException)
          {
            ad.e("EncodeDecode", "interrupted while waiting");
            ad.e("MicroMsg.Voip.VoipDeviceHandler", " error:" + localException.toString());
            continue;
          }
          label604:
          Object localObject2;
          if (this.zkc)
          {
            localObject2 = n.this;
            ((n)localObject2).zjT &= 0xFFFFFFFE;
            if (v2protocal.zpu != null) {
              v2protocal.zpu.zgw = false;
            }
            n.this.zfA.zja.setHWDecMode(n.this.zjT);
            ad.i("MicroMsg.Voip.VoipDeviceHandler", "steve: change to SW dec");
            localObject2 = t.zlN;
            t.dUl();
          }
          int k = n.this.zfA.ziZ.field_remoteImgLength;
          if ((k > 0) && (n.this.zfA.zja != null))
          {
            localObject2 = n.this.zfA.ziZ;
            ((v2protocal)localObject2).zpe += 1;
            n.this.zfA.zja.d(i, j, this.zke);
            if (n.this.zfA.ziZ.zpe % 100 == 0)
            {
              localObject2 = new byte[5];
              int m = i * 33 + 33;
              int n = i * 34 - 34;
              int i1 = i * j / 2 + i / 2;
              int i2 = (j - 34) * i + 33;
              int i3 = (j - 34) * i + i - 34;
              if ((this.zke != null) && (i3 < this.zke.length))
              {
                localObject2[0] = this.zke[m];
                localObject2[1] = this.zke[n];
                localObject2[2] = this.zke[i1];
                localObject2[3] = this.zke[i2];
                localObject2[4] = this.zke[i3];
                ad.i("MicroMsg.Voip.VoipDeviceHandler", "steve: SW dec to render: cnt:%d, size:%dx%d, outlen:%d, samples:%d,%d,%d,%d,%d", new Object[] { Integer.valueOf(n.this.zfA.ziZ.zpe), Integer.valueOf(i), Integer.valueOf(j), Integer.valueOf(k), Byte.valueOf(localObject2[0]), Byte.valueOf(localObject2[1]), Byte.valueOf(localObject2[2]), Byte.valueOf(localObject2[3]), Byte.valueOf(localObject2[4]) });
                ad.i("MicroMsg.Voip.VoipDeviceHandler", "steve: first 5 samples:%d,%d,%d,%d,%d", new Object[] { Byte.valueOf(this.zke[0]), Byte.valueOf(this.zke[1]), Byte.valueOf(this.zke[2]), Byte.valueOf(this.zke[3]), Byte.valueOf(this.zke[4]) });
                j = 0;
                i = 0;
                while (i < 5)
                {
                  k = j;
                  if (localObject2[i] == 0) {
                    k = j + 1;
                  }
                  i += 1;
                  j = k;
                }
                if (j >= 5)
                {
                  localObject2 = t.zlN;
                  t.dUs();
                }
              }
              else
              {
                ad.i("MicroMsg.Voip.VoipDeviceHandler", "steve: dec null pointer or out of memory! size:%dx%d, idx:%d,%d,%d,%d,%d, len:%d ", new Object[] { Integer.valueOf(i), Integer.valueOf(j), Integer.valueOf(m), Integer.valueOf(n), Integer.valueOf(i1), Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(this.zke.length) });
              }
            }
          }
        }
      }
      AppMethodBeat.o(114945);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.voip.model.n
 * JD-Core Version:    0.7.0.1
 */