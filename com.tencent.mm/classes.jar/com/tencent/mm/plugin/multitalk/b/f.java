package com.tencent.mm.plugin.multitalk.b;

import android.os.SystemClock;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.audio.b.c.a;
import com.tencent.mm.compatible.util.f.a;
import com.tencent.mm.plugin.expt.b.b.a;
import com.tencent.mm.plugin.multitalk.b.a.a;
import com.tencent.mm.plugin.voip.model.v2protocal;
import com.tencent.mm.protocal.protobuf.aau;
import com.tencent.mm.protocal.protobuf.aew;
import com.tencent.mm.sdk.platformtools.ar;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.LongBuffer;

public final class f
{
  private static int pcL = 3;
  private int mChannels;
  private boolean mIsPlayMute;
  private int mSampleRate;
  volatile com.tencent.mm.audio.b.c pcI;
  private int pcM;
  private int pcN;
  private int pcO;
  private final Object pcP;
  private int pcQ;
  private int pcR;
  private int pcS;
  private long pcT;
  private int pcV;
  private c.a pcW;
  public g wmm;
  private e wmn;
  private k wmo;
  
  public f(k paramk)
  {
    AppMethodBeat.i(190442);
    this.pcM = 1;
    this.pcN = 92;
    this.pcO = 1;
    this.pcP = new Object();
    this.pcQ = 0;
    this.pcR = 0;
    this.pcS = 1;
    this.pcT = 0L;
    this.mIsPlayMute = false;
    this.mSampleRate = v2protocal.VOICE_SAMPLERATE;
    this.mChannels = 1;
    this.pcV = 20;
    this.pcW = new c.a()
    {
      public final void ch(int paramAnonymousInt1, int paramAnonymousInt2) {}
      
      public final void u(byte[] paramAnonymousArrayOfByte, int paramAnonymousInt)
      {
        int i = -1;
        int j = 0;
        AppMethodBeat.i(190440);
        for (;;)
        {
          synchronized (f.k(f.this))
          {
            if (f.a(f.this) % 50 == 0)
            {
              f.b(f.this);
              com.tencent.mm.sdk.platformtools.ae.v("MicroMsg.Multitalk.ILinkAudioMgr", "hy: syncOnRecPcmDataReady pcm raw length: %d, given len; %d", new Object[] { Integer.valueOf(paramAnonymousArrayOfByte.length), Integer.valueOf(paramAnonymousInt) });
            }
            if (f.c(f.this) == 2)
            {
              paramAnonymousInt = j;
              if (f.d(f.this).wmq.pcA == null) {
                break label404;
              }
              paramAnonymousInt = 1;
              break label404;
            }
            AppMethodBeat.o(190440);
            return;
            if (f.e(f.this) <= 10) {
              f.a(f.this, 92);
            }
            Object localObject2 = f.d(f.this).wmq.pcA;
            if (localObject2 != null)
            {
              paramAnonymousInt = ((com.tencent.mm.plugin.voip.model.c)localObject2).eyz();
              f.a(f.this, (paramAnonymousInt + 24 + f.e(f.this) * 3) / 4);
              if (f.f(f.this) != 1) {
                break label338;
              }
              localObject2 = f.d(f.this).wmq.pcA;
              paramAnonymousInt = i;
              if (localObject2 != null) {
                paramAnonymousInt = ((com.tencent.mm.plugin.voip.model.c)localObject2).eyw();
              }
              i = paramAnonymousInt;
              if (paramAnonymousInt >= f.e(f.this)) {
                i = paramAnonymousInt - f.e(f.this);
              }
              f.a(f.this, i);
              f.g(f.this);
              if (1 != f.h(f.this)) {
                break label350;
              }
              f.i(f.this);
              f.a(f.this, System.currentTimeMillis());
              com.tencent.mm.sdk.platformtools.ae.i("MicroMsg.Multitalk.ILinkAudioMgr", "amyfwang,first record");
              localObject2 = p.wmO;
              p.w(paramAnonymousArrayOfByte, paramAnonymousArrayOfByte.length, f.e(f.this));
            }
          }
          paramAnonymousInt = -1;
          continue;
          label338:
          f.a(f.this, 0);
          continue;
          label350:
          long l1 = System.currentTimeMillis();
          long l2 = l1 - f.j(f.this);
          if (l2 > 1000L) {
            com.tencent.mm.sdk.platformtools.ae.i("MicroMsg.Multitalk.ILinkAudioMgr", "amyfwang,error,deltaTime:".concat(String.valueOf(l2)));
          }
          f.a(f.this, l1);
          continue;
          label404:
          if (paramAnonymousInt != 0) {}
        }
      }
    };
    this.wmn = new e();
    this.wmo = paramk;
    this.wmm = new g();
    AppMethodBeat.o(190442);
  }
  
  public final boolean PO()
  {
    AppMethodBeat.i(190444);
    com.tencent.mm.sdk.platformtools.ae.i("MicroMsg.Multitalk.ILinkAudioMgr", "hy: trigger start play");
    if (this.pcM != 2) {
      com.tencent.mm.sdk.platformtools.ae.e("MicroMsg.Multitalk.ILinkAudioMgr", "hy: not init when start listen!");
    }
    synchronized (this.pcP)
    {
      if (!this.pcI.PO())
      {
        if (this.pcI.dhN != 13) {
          this.pcQ = 1;
        }
        AppMethodBeat.o(190444);
        return false;
      }
      com.tencent.mm.sdk.platformtools.ae.d("MicroMsg.Multitalk.ILinkAudioMgr", "VoipDeivceHandler.m_iAudioDevErr:" + this.pcQ);
      AppMethodBeat.o(190444);
      return true;
    }
  }
  
  final void a(aau paramaau)
  {
    if (paramaau != null)
    {
      this.mSampleRate = paramaau.Gsh.Gva;
      this.mChannels = paramaau.Gsh.channels;
      this.pcV = paramaau.Gsh.Gvb;
    }
  }
  
  public final boolean cbu()
  {
    AppMethodBeat.i(190443);
    if (this.pcM != 2)
    {
      com.tencent.mm.sdk.platformtools.ae.e("MicroMsg.Multitalk.ILinkAudioMgr", "hy: error not init when start record!");
      AppMethodBeat.o(190443);
      return false;
    }
    if (this.wmm.a(new com.tencent.mm.plugin.voip.model.b()
    {
      public final int O(byte[] paramAnonymousArrayOfByte, int paramAnonymousInt)
      {
        AppMethodBeat.i(190441);
        if (f.c(f.this) != 2)
        {
          AppMethodBeat.o(190441);
          return -1;
        }
        p localp = p.wmO;
        paramAnonymousInt = p.Q(paramAnonymousArrayOfByte, paramAnonymousInt);
        if (!f.l(f.this))
        {
          if (paramAnonymousInt < 0)
          {
            AppMethodBeat.o(190441);
            return -1;
          }
        }
        else
        {
          AppMethodBeat.o(190441);
          return -10086;
        }
        AppMethodBeat.o(190441);
        return 0;
      }
    }, this.mSampleRate, this.mChannels, this.pcV) <= 0)
    {
      this.pcQ = 1;
      AppMethodBeat.o(190443);
      return false;
    }
    AppMethodBeat.o(190443);
    return true;
  }
  
  public final int drH()
  {
    AppMethodBeat.i(190445);
    com.tencent.mm.plugin.voip.model.c localc = this.wmm.wmq.pcA;
    if (localc != null)
    {
      int i = localc.eyB();
      AppMethodBeat.o(190445);
      return i;
    }
    AppMethodBeat.o(190445);
    return 0;
  }
  
  public final void init()
  {
    AppMethodBeat.i(190446);
    if (this.pcM == 2)
    {
      com.tencent.mm.sdk.platformtools.ae.e("MicroMsg.Multitalk.ILinkAudioMgr", "dev start already...");
      AppMethodBeat.o(190446);
      return;
    }
    ar.f(new g.1(this.wmm));
    com.tencent.mm.sdk.platformtools.ae.i("MicroMsg.Multitalk.ILinkAudioMgr", "start device......");
    this.pcM = 2;
    com.tencent.mm.compatible.deviceinfo.ae.geN.dump();
    Object localObject2 = new byte[1];
    localObject2[0] = 0;
    Object localObject1 = new byte[2];
    com.tencent.mm.sdk.platformtools.ae.i("MicroMsg.Multitalk.ILinkAudioCompatHelper", "hy: audio info dump begin");
    com.tencent.mm.compatible.deviceinfo.ae.geN.dump();
    Object localObject3;
    byte b;
    label389:
    label525:
    long l;
    label913:
    label1224:
    int i;
    int j;
    int k;
    if (com.tencent.mm.compatible.deviceinfo.ae.geN.fYX >= 0)
    {
      localObject1[0] = ((byte)com.tencent.mm.compatible.deviceinfo.ae.geN.fYX);
      localObject3 = p.wmO;
      p.f(406, (byte[])localObject1, 1);
      m = ((com.tencent.mm.plugin.expt.b.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.qKO, -1);
      com.tencent.mm.sdk.platformtools.ae.i("MicroMsg.Multitalk.ILinkAudioCompatHelper", "qipengfeng, x_agc_paras = %d", new Object[] { Integer.valueOf(m) });
      if (m > 0)
      {
        b = (byte)(m & 0x1);
        com.tencent.mm.sdk.platformtools.ae.i("MicroMsg.Multitalk.ILinkAudioCompatHelper", "qipengfeng, agc_switch = %d", new Object[] { Byte.valueOf(b) });
        if (b <= 0) {
          break label2132;
        }
        localObject3 = new byte[7];
        localObject3[0] = ((byte)(m >> 1 & 0x1F));
        localObject3[1] = ((byte)(m >> 6 & 0x1F));
        localObject3[2] = ((byte)(m >> 11 & 0x3));
        localObject3[3] = ((byte)(m >> 13 & 0x3));
        localObject3[4] = ((byte)(m >> 15 & 0x1));
        localObject3[5] = ((byte)(m >> 16 & 0x7));
        localObject3[6] = ((byte)(m >> 19 & 0xF));
        com.tencent.mm.sdk.platformtools.ae.i("MicroMsg.Multitalk.ILinkAudioCompatHelper", "qipengfeng, agc para: %d, %d, %d, %d, %d, %d, %d", new Object[] { Byte.valueOf(localObject3[0]), Byte.valueOf(localObject3[1]), Byte.valueOf(localObject3[2]), Byte.valueOf(localObject3[3]), Byte.valueOf(localObject3[4]), Byte.valueOf(localObject3[5]), Byte.valueOf(localObject3[6]) });
        localp = p.wmO;
        p.f(404, (byte[])localObject3, 7);
      }
      if (com.tencent.mm.compatible.deviceinfo.ae.geN.fZc < 0) {
        break label2168;
      }
      localObject3 = new byte[7];
      if ((com.tencent.mm.compatible.deviceinfo.ae.geN.fZd >= 0) && (com.tencent.mm.compatible.deviceinfo.ae.geN.fZe >= 0))
      {
        localObject3[0] = ((byte)com.tencent.mm.compatible.deviceinfo.ae.geN.fZd);
        localObject3[1] = ((byte)com.tencent.mm.compatible.deviceinfo.ae.geN.fZe);
        if (com.tencent.mm.compatible.deviceinfo.ae.geN.fZf < 0) {
          break label2150;
        }
        localObject3[2] = ((byte)com.tencent.mm.compatible.deviceinfo.ae.geN.fZf);
        localObject3[3] = ((byte)com.tencent.mm.compatible.deviceinfo.ae.geN.fZc);
        localObject3[4] = ((byte)com.tencent.mm.compatible.deviceinfo.ae.geN.fZg);
        localObject3[5] = ((byte)com.tencent.mm.compatible.deviceinfo.ae.geN.fZh);
        localObject3[6] = ((byte)com.tencent.mm.compatible.deviceinfo.ae.geN.fZi);
        localp = p.wmO;
        p.f(404, (byte[])localObject3, 7);
      }
      l = ((com.tencent.mm.plugin.expt.b.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.qKT, -1L);
      com.tencent.mm.sdk.platformtools.ae.i("MicroMsg.Multitalk.ILinkAudioCompatHelper", "qipengfeng, x-expt settings, wave_agc_paras: %d", new Object[] { Long.valueOf(l) });
      if (l > -1L)
      {
        localObject3 = new byte[11];
        localObject3[0] = ((byte)(int)(0x3 & l));
        com.tencent.mm.sdk.platformtools.ae.i("MicroMsg.Multitalk.ILinkAudioCompatHelper", "qipengfeng, x-expt settings, wave agc mode: %d", new Object[] { Byte.valueOf(localObject3[0]) });
        if (localObject3[0] != 1) {
          break label2197;
        }
        localObject3[1] = ((byte)(int)(l >> 2 & 0x1F));
        localObject3[2] = ((byte)(int)(l >> 7 & 0x1F));
        localObject3[3] = ((byte)(int)(l >> 12 & 0x1F));
        localObject3[4] = ((byte)(int)(l >> 17 & 0x1F));
        localObject3[5] = ((byte)(int)(l >> 22 & 0xF));
        localObject3[6] = ((byte)(int)(l >> 26 & 0xF));
        localObject3[7] = ((byte)(int)(l >> 30 & 1L));
        localObject3[8] = ((byte)(int)(l >> 31 & 0x1F));
        localObject3[9] = ((byte)(int)(l >> 36 & 0x1F));
        localObject3[10] = ((byte)(int)(l >> 41 & 0x1F));
        localp = p.wmO;
        p.f(461, (byte[])localObject3, 11);
        com.tencent.mm.sdk.platformtools.ae.i("MicroMsg.Multitalk.ILinkAudioCompatHelper", "qipengfeng, x-expt settings, wave agc paras: %d, %d, %d, %d, %d, %d, %d, %d, %d, %d", new Object[] { Byte.valueOf(localObject3[1]), Byte.valueOf(localObject3[2]), Byte.valueOf(localObject3[3]), Byte.valueOf(localObject3[4]), Byte.valueOf(localObject3[5]), Byte.valueOf(localObject3[6]), Byte.valueOf(localObject3[7]), Byte.valueOf(localObject3[8]), Byte.valueOf(localObject3[9]), Byte.valueOf(localObject3[10]) });
      }
      com.tencent.mm.sdk.platformtools.ae.i("MicroMsg.Multitalk.ILinkAudioCompatHelper", "qipengfeng, device-model config, SrvDeviceInfo.mAudioInfo.waveAgcMode: %d", new Object[] { Integer.valueOf(com.tencent.mm.compatible.deviceinfo.ae.geN.fZj) });
      if (com.tencent.mm.compatible.deviceinfo.ae.geN.fZj >= 0)
      {
        localObject3 = new byte[11];
        localObject3[0] = ((byte)com.tencent.mm.compatible.deviceinfo.ae.geN.fZj);
        if (localObject3[0] != 1) {
          break label2413;
        }
        localObject3[1] = ((byte)com.tencent.mm.compatible.deviceinfo.ae.geN.fZq);
        localObject3[2] = ((byte)com.tencent.mm.compatible.deviceinfo.ae.geN.fZr);
        localObject3[3] = ((byte)com.tencent.mm.compatible.deviceinfo.ae.geN.fZs);
        localObject3[4] = ((byte)com.tencent.mm.compatible.deviceinfo.ae.geN.fZn);
        localObject3[5] = ((byte)com.tencent.mm.compatible.deviceinfo.ae.geN.fZo);
        localObject3[6] = ((byte)com.tencent.mm.compatible.deviceinfo.ae.geN.fZp);
        localObject3[7] = ((byte)com.tencent.mm.compatible.deviceinfo.ae.geN.fZt);
        localObject3[8] = ((byte)com.tencent.mm.compatible.deviceinfo.ae.geN.fZk);
        localObject3[9] = ((byte)com.tencent.mm.compatible.deviceinfo.ae.geN.fZl);
        localObject3[10] = ((byte)com.tencent.mm.compatible.deviceinfo.ae.geN.fZm);
        localp = p.wmO;
        p.f(461, (byte[])localObject3, 11);
        com.tencent.mm.sdk.platformtools.ae.i("MicroMsg.Multitalk.ILinkAudioCompatHelper", "qipengfeng, device-model config, wave agc paras: %d, %d, %d, %d, %d, %d, %d, %d, %d, %d", new Object[] { Byte.valueOf(localObject3[1]), Byte.valueOf(localObject3[2]), Byte.valueOf(localObject3[3]), Byte.valueOf(localObject3[4]), Byte.valueOf(localObject3[5]), Byte.valueOf(localObject3[6]), Byte.valueOf(localObject3[7]), Byte.valueOf(localObject3[8]), Byte.valueOf(localObject3[9]), Byte.valueOf(localObject3[10]) });
      }
      m = ((com.tencent.mm.plugin.expt.b.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.qJP, 1002);
      if (m <= 0) {
        break label2606;
      }
      b = (byte)(m & 0xFF);
      i = (byte)(m >> 8 & 0xFF);
      j = (byte)(m >> 16 & 0xFF);
      k = (byte)(m >> 24 & 0xFF);
      localObject3 = p.wmO;
      p.f(408, (byte[])new byte[] { b, i, j, k }, 4);
      label1328:
      m = com.tencent.mm.compatible.deviceinfo.ae.geN.fYZ;
      com.tencent.mm.sdk.platformtools.ae.i("MicroMsg.Multitalk.ILinkAudioCompatHelper", "kerrizhang SrvDeviceInfo.mAudioInfo.nsModeNewMulti %d", new Object[] { Integer.valueOf(m) });
      if (com.tencent.mm.compatible.deviceinfo.ae.geN.fYZ < 0) {
        break label2674;
      }
      if (m <= 0) {
        break label2640;
      }
      int n = (int)Math.floor(m / 1000.0D) % 100;
      com.tencent.mm.sdk.platformtools.ae.i("MicroMsg.Multitalk.ILinkAudioCompatHelper", "kerrizhang SrvDeviceInfo.mAudioInfo.iflag %d", new Object[] { Integer.valueOf(n) });
      if (n > 0)
      {
        b = (byte)(m & 0xFF);
        i = (byte)(m >> 8 & 0xFF);
        j = (byte)(m >> 16 & 0xFF);
        k = (byte)(m >> 24 & 0xFF);
        localObject3 = p.wmO;
        p.f(408, (byte[])new byte[] { b, i, j, k }, 4);
      }
    }
    for (;;)
    {
      if ((com.tencent.mm.compatible.deviceinfo.ae.geN.fZy[0] > 0) || (com.tencent.mm.compatible.deviceinfo.ae.geN.fZy[1] > 0))
      {
        localObject1[0] = 0;
        localObject1[1] = 0;
        if ((com.tencent.mm.compatible.deviceinfo.ae.geN.fZy[0] > 0) && (com.tencent.mm.compatible.deviceinfo.ae.geN.fZy[0] < 10000)) {
          localObject1[0] = ((byte)com.tencent.mm.compatible.deviceinfo.ae.geN.fZy[0]);
        }
        if ((com.tencent.mm.compatible.deviceinfo.ae.geN.fZy[1] > 0) && (com.tencent.mm.compatible.deviceinfo.ae.geN.fZy[1] < 10000)) {
          localObject1[1] = ((byte)com.tencent.mm.compatible.deviceinfo.ae.geN.fZy[1]);
        }
        localObject3 = p.wmO;
        p.f(423, (byte[])localObject1, 2);
      }
      if ((com.tencent.mm.compatible.deviceinfo.ae.geN.fYA >= 0) || (com.tencent.mm.compatible.deviceinfo.ae.geN.fYC >= 0))
      {
        localObject1[0] = -1;
        localObject1[1] = -1;
        if (com.tencent.mm.compatible.deviceinfo.ae.geN.fYA >= 0) {
          localObject1[0] = ((byte)com.tencent.mm.compatible.deviceinfo.ae.geN.fYA);
        }
        if (com.tencent.mm.compatible.deviceinfo.ae.geN.fYC >= 0) {
          localObject1[1] = ((byte)com.tencent.mm.compatible.deviceinfo.ae.geN.fYC);
        }
        localObject3 = p.wmO;
        p.f(414, (byte[])localObject1, 2);
      }
      if ((com.tencent.mm.compatible.deviceinfo.ae.geN.fYB >= 0) || (com.tencent.mm.compatible.deviceinfo.ae.geN.fYD >= 0))
      {
        localObject1[0] = -1;
        localObject1[1] = -1;
        if (com.tencent.mm.compatible.deviceinfo.ae.geN.fYB >= 0) {
          localObject1[0] = ((byte)com.tencent.mm.compatible.deviceinfo.ae.geN.fYB);
        }
        if (com.tencent.mm.compatible.deviceinfo.ae.geN.fYD >= 0) {
          localObject1[1] = ((byte)com.tencent.mm.compatible.deviceinfo.ae.geN.fYD);
        }
        localObject3 = p.wmO;
        p.f(415, (byte[])localObject1, 2);
      }
      if ((com.tencent.mm.compatible.deviceinfo.ae.geN.fYE >= 0) || (com.tencent.mm.compatible.deviceinfo.ae.geN.fYF >= 0))
      {
        localObject1[0] = -1;
        localObject1[1] = -1;
        if (com.tencent.mm.compatible.deviceinfo.ae.geN.fYE >= 0) {
          localObject1[0] = ((byte)com.tencent.mm.compatible.deviceinfo.ae.geN.fYE);
        }
        if (com.tencent.mm.compatible.deviceinfo.ae.geN.fYF >= 0) {
          localObject1[1] = ((byte)com.tencent.mm.compatible.deviceinfo.ae.geN.fYF);
        }
        localObject3 = p.wmO;
        p.f(422, (byte[])localObject1, 2);
      }
      if (com.tencent.mm.compatible.deviceinfo.ae.geN.fYG >= 0)
      {
        localObject1[0] = ((byte)com.tencent.mm.compatible.deviceinfo.ae.geN.fYG);
        localObject3 = p.wmO;
        p.f(416, (byte[])localObject1, 1);
      }
      if ((com.tencent.mm.compatible.deviceinfo.ae.geN.fYH >= 0) && (com.tencent.mm.compatible.deviceinfo.ae.geN.fYH != 5))
      {
        localObject1[0] = ((byte)com.tencent.mm.compatible.deviceinfo.ae.geN.fYH);
        localObject3 = p.wmO;
        p.f(417, (byte[])localObject1, 1);
      }
      if ((com.tencent.mm.compatible.deviceinfo.ae.geN.fYI >= 0) && (com.tencent.mm.compatible.deviceinfo.ae.geN.fYI != 5))
      {
        localObject1[0] = ((byte)com.tencent.mm.compatible.deviceinfo.ae.geN.fYI);
        localObject3 = p.wmO;
        p.f(418, (byte[])localObject1, 1);
      }
      if (com.tencent.mm.compatible.deviceinfo.ae.geN.fYJ >= 0)
      {
        localObject1[0] = ((byte)com.tencent.mm.compatible.deviceinfo.ae.geN.fYJ);
        localObject3 = p.wmO;
        p.f(419, (byte[])localObject1, 1);
      }
      if (1 != com.tencent.mm.compatible.deviceinfo.ae.geN.fZw) {
        break label2730;
      }
      localObject3 = new byte[30];
      m = 0;
      while (m < 15)
      {
        localObject3[(m * 2)] = ((byte)(com.tencent.mm.compatible.deviceinfo.ae.geN.fZx[m] & 0xFF));
        localObject3[(m * 2 + 1)] = ((byte)(com.tencent.mm.compatible.deviceinfo.ae.geN.fZx[m] >> 8 & 0xFF));
        m += 1;
      }
      if (com.tencent.mm.compatible.deviceinfo.ae.geN.fYX != -2) {
        break;
      }
      localObject3 = p.wmO;
      p.f(407, (byte[])localObject2, 1);
      break;
      label2132:
      localObject3 = p.wmO;
      p.f(405, (byte[])localObject2, 1);
      break label389;
      label2150:
      localp = p.wmO;
      p.f(404, (byte[])localObject3, 2);
      break label525;
      label2168:
      if (com.tencent.mm.compatible.deviceinfo.ae.geN.fZc != -2) {
        break label525;
      }
      localObject3 = p.wmO;
      p.f(405, (byte[])localObject2, 1);
      break label525;
      label2197:
      if (localObject3[0] == 2)
      {
        localObject3[1] = ((byte)(int)(l >> 2 & 0x1F));
        localObject3[2] = ((byte)(int)(l >> 7 & 0x1F));
        localObject3[3] = ((byte)(int)(l >> 12 & 0x1F));
        localObject3[4] = ((byte)(int)(l >> 17 & 0x1F));
        localObject3[5] = ((byte)(int)(l >> 22 & 0xF));
        localObject3[6] = ((byte)(int)(l >> 26 & 0xF));
        localp = p.wmO;
        p.f(461, (byte[])localObject3, 7);
        com.tencent.mm.sdk.platformtools.ae.i("MicroMsg.Multitalk.ILinkAudioCompatHelper", "qipengfeng, x-expt settings, wave agc paras: %d, %d, %d, %d, %d, %d", new Object[] { Byte.valueOf(localObject3[1]), Byte.valueOf(localObject3[2]), Byte.valueOf(localObject3[3]), Byte.valueOf(localObject3[4]), Byte.valueOf(localObject3[5]), Byte.valueOf(localObject3[6]) });
        break label913;
      }
      if (localObject3[0] != 0) {
        break label913;
      }
      localp = p.wmO;
      p.f(462, (byte[])localObject3, 1);
      break label913;
      label2413:
      if (localObject3[0] == 2)
      {
        localObject3[1] = ((byte)com.tencent.mm.compatible.deviceinfo.ae.geN.fZk);
        localObject3[2] = ((byte)com.tencent.mm.compatible.deviceinfo.ae.geN.fZl);
        localObject3[3] = ((byte)com.tencent.mm.compatible.deviceinfo.ae.geN.fZm);
        localObject3[4] = ((byte)com.tencent.mm.compatible.deviceinfo.ae.geN.fZn);
        localObject3[5] = ((byte)com.tencent.mm.compatible.deviceinfo.ae.geN.fZo);
        localObject3[6] = ((byte)com.tencent.mm.compatible.deviceinfo.ae.geN.fZp);
        localp = p.wmO;
        p.f(461, (byte[])localObject3, 7);
        com.tencent.mm.sdk.platformtools.ae.i("MicroMsg.Multitalk.ILinkAudioCompatHelper", "qipengfeng, device-model config, wave agc paras: %d, %d, %d, %d, %d, %d", new Object[] { Byte.valueOf(localObject3[1]), Byte.valueOf(localObject3[2]), Byte.valueOf(localObject3[3]), Byte.valueOf(localObject3[4]), Byte.valueOf(localObject3[5]), Byte.valueOf(localObject3[6]) });
        break label1224;
      }
      if (localObject3[0] != 0) {
        break label1224;
      }
      localp = p.wmO;
      p.f(462, (byte[])localObject3, 1);
      break label1224;
      label2606:
      if (m != 0) {
        break label1328;
      }
      localObject2[0] = ((byte)(m & 0xFF));
      localObject3 = p.wmO;
      p.f(409, (byte[])localObject2, 1);
      break label1328;
      label2640:
      if (m == 0)
      {
        localObject2[0] = ((byte)(m & 0xFF));
        localObject3 = p.wmO;
        p.f(409, (byte[])localObject2, 1);
        continue;
        label2674:
        if (com.tencent.mm.compatible.deviceinfo.ae.geN.fYZ == -2)
        {
          localObject2[0] = ((byte)(m & 0xFF));
          localObject3 = p.wmO;
          p.f(409, (byte[])localObject2, 1);
        }
      }
    }
    p localp = p.wmO;
    p.f(420, (byte[])localObject3, 30);
    label2730:
    if (com.tencent.mm.compatible.deviceinfo.ae.geN.fZw == 0)
    {
      localObject3 = p.wmO;
      p.f(421, (byte[])localObject2, 1);
    }
    if (com.tencent.mm.compatible.deviceinfo.ae.geN.fZA > 0)
    {
      localObject1[0] = ((byte)com.tencent.mm.compatible.deviceinfo.ae.geN.fZA);
      localObject2 = p.wmO;
      p.f(424, (byte[])localObject1, 1);
    }
    if (com.tencent.mm.compatible.deviceinfo.ae.geN.fYK > 0)
    {
      localObject1[0] = ((byte)com.tencent.mm.compatible.deviceinfo.ae.geN.fYK);
      localObject2 = p.wmO;
      p.f(431, (byte[])localObject1, 4);
    }
    int m = ((com.tencent.mm.plugin.expt.b.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.qKP, -1);
    com.tencent.mm.sdk.platformtools.ae.i("MicroMsg.Multitalk.ILinkAudioCompatHelper", "qipengfeng, x_agcrx_paras: %d", new Object[] { Integer.valueOf(m) });
    if (m > 0)
    {
      b = (byte)(m & 0x1);
      com.tencent.mm.sdk.platformtools.ae.i("MicroMsg.Multitalk.ILinkAudioCompatHelper", "qipengfeng, agcrx_switch: %d", new Object[] { Byte.valueOf(b) });
      if (b > 0)
      {
        localObject1 = new byte[4];
        localObject1[0] = ((byte)(m >> 1 & 0x3));
        localObject1[1] = ((byte)(m >> 3 & 0x1F));
        localObject1[2] = ((byte)(m >> 8 & 0x1F));
        localObject1[3] = ((byte)(m >> 13 & 0x1));
        localObject2 = p.wmO;
        p.f(426, (byte[])localObject1, 4);
        com.tencent.mm.sdk.platformtools.ae.i("MicroMsg.Multitalk.ILinkAudioCompatHelper", "qipengfeng, agc rx para: %d, %d, %d, %d", new Object[] { Byte.valueOf(localObject1[0]), Byte.valueOf(localObject1[1]), Byte.valueOf(localObject1[2]), Byte.valueOf(localObject1[3]) });
      }
    }
    if (com.tencent.mm.compatible.deviceinfo.ae.geN.fZI >= 0)
    {
      b = (byte)com.tencent.mm.compatible.deviceinfo.ae.geN.fZI;
      i = (byte)com.tencent.mm.compatible.deviceinfo.ae.geN.fZJ;
      j = (byte)com.tencent.mm.compatible.deviceinfo.ae.geN.fZK;
      k = (byte)com.tencent.mm.compatible.deviceinfo.ae.geN.fZL;
      localObject1 = p.wmO;
      p.f(426, new byte[] { b, i, j, k }, 4);
    }
    m = ((com.tencent.mm.plugin.expt.b.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.qKn, -1);
    com.tencent.mm.sdk.platformtools.ae.i("MicroMsg.Multitalk.ILinkAudioCompatHelper", "kerrizhang, multi_play_fadeinfadeout_switch = %d", new Object[] { Integer.valueOf(m) });
    localObject1 = new byte[1];
    localObject1[0] = 0;
    if (m > 0) {
      localObject1[0] = ((byte)m);
    }
    localObject2 = p.wmO;
    p.f(451, (byte[])localObject1, 1);
    m = ((com.tencent.mm.plugin.expt.b.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.qKo, -1);
    com.tencent.mm.sdk.platformtools.ae.i("MicroMsg.Multitalk.ILinkAudioCompatHelper", "kerrizhang, multi_play_fadeinfadeout_thresh = %d", new Object[] { Integer.valueOf(m) });
    localObject1[0] = 0;
    if (m > 0) {
      localObject1[0] = ((byte)m);
    }
    localObject2 = p.wmO;
    p.f(452, (byte[])localObject1, 1);
    localObject1 = new long[21];
    localObject1[0] = ((com.tencent.mm.plugin.expt.b.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.qKp, -1L);
    localObject1[1] = ((com.tencent.mm.plugin.expt.b.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.qKq, -1L);
    localObject1[2] = ((com.tencent.mm.plugin.expt.b.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.qKr, -1L);
    localObject1[3] = ((com.tencent.mm.plugin.expt.b.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.qKs, -1L);
    localObject1[4] = ((com.tencent.mm.plugin.expt.b.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.qKt, -1L);
    localObject1[5] = ((com.tencent.mm.plugin.expt.b.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.qKu, -1L);
    localObject1[6] = ((com.tencent.mm.plugin.expt.b.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.qKv, -1L);
    localObject1[7] = ((com.tencent.mm.plugin.expt.b.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.qKw, -1L);
    localObject1[8] = ((com.tencent.mm.plugin.expt.b.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.qKx, -1L);
    localObject1[9] = ((com.tencent.mm.plugin.expt.b.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.qKy, -1L);
    localObject1[10] = ((com.tencent.mm.plugin.expt.b.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.qKz, -1L);
    localObject1[11] = ((com.tencent.mm.plugin.expt.b.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.qKA, -1L);
    localObject1[12] = ((com.tencent.mm.plugin.expt.b.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.qKB, -1L);
    localObject1[13] = ((com.tencent.mm.plugin.expt.b.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.qKC, -1L);
    localObject1[14] = ((com.tencent.mm.plugin.expt.b.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.qKD, -1L);
    localObject1[15] = ((com.tencent.mm.plugin.expt.b.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.qKE, -1L);
    localObject1[16] = ((com.tencent.mm.plugin.expt.b.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.qKF, -1L);
    localObject1[17] = ((com.tencent.mm.plugin.expt.b.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.qKG, -1L);
    localObject1[18] = ((com.tencent.mm.plugin.expt.b.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.qKH, -1L);
    localObject1[19] = ((com.tencent.mm.plugin.expt.b.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.qKI, -1L);
    localObject1[20] = ((com.tencent.mm.plugin.expt.b.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.qKJ, -1L);
    localObject2 = ByteBuffer.allocate(168).order(ByteOrder.LITTLE_ENDIAN);
    ((ByteBuffer)localObject2).asLongBuffer().put((long[])localObject1);
    localObject2 = ((ByteBuffer)localObject2).array();
    com.tencent.mm.sdk.platformtools.ae.i("MicroMsg.Multitalk.ILinkAudioCompatHelper", "kerrizhang, multi_loss_control[0] %d,multi_loss_control[1] %d multi_loss_control[2] %d", new Object[] { Long.valueOf(localObject1[0]), Long.valueOf(localObject1[1]), Long.valueOf(localObject1[2]) });
    localObject1 = p.wmO;
    p.f(453, (byte[])localObject2, localObject2.length);
    m = ((com.tencent.mm.plugin.expt.b.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.qKK, -1);
    com.tencent.mm.sdk.platformtools.ae.i("MicroMsg.Multitalk.ILinkAudioCompatHelper", "kerrizhang, rcnnvad_switch = %d", new Object[] { Integer.valueOf(m) });
    if (m > 0)
    {
      b = (byte)m;
      localObject1 = p.wmO;
      p.f(454, new byte[] { b }, 1);
    }
    m = ((com.tencent.mm.plugin.expt.b.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.qKN, 0);
    com.tencent.mm.sdk.platformtools.ae.i("MicroMsg.Multitalk.ILinkAudioCompatHelper", "dennyliang, voip aec_value = %d", new Object[] { Integer.valueOf(m) });
    if (m > 0)
    {
      b = (byte)(m & 0xFF);
      i = (byte)(m >> 8 & 0xFF);
      j = (byte)(m >> 16 & 0xFF);
      k = (byte)(m >> 24 & 0xFF);
      localObject1 = p.wmO;
      p.f(460, new byte[] { b, i, j, k }, 4);
    }
    m = ((com.tencent.mm.plugin.expt.b.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.qKk, -1);
    com.tencent.mm.sdk.platformtools.ae.i("MicroMsg.Multitalk.ILinkAudioCompatHelper", "qipengfeng, updateAudioAdaption, switch_flag_x = %d", new Object[] { Integer.valueOf(m) });
    localObject1 = new byte[1];
    localObject1[0] = 0;
    if (m > 0) {
      localObject1[0] = 1;
    }
    localObject2 = p.wmO;
    p.f(450, (byte[])localObject1, 1);
    if (this.pcN <= 10)
    {
      if (this.pcN <= 0) {
        this.pcQ = 1;
      }
      this.pcN = 92;
    }
    this.pcI = new com.tencent.mm.audio.b.c(this.mSampleRate, this.mChannels, 1);
    this.pcI.hQ(this.pcV);
    this.pcI.cv(true);
    this.pcI.PM();
    this.pcI.dhY = -19;
    this.pcI.t(1, false);
    this.pcI.cu(true);
    localObject1 = p.wmO;
    p.f(401, new byte[1], 1);
    this.pcI.dij = this.pcW;
    AppMethodBeat.o(190446);
  }
  
  public final void release()
  {
    AppMethodBeat.i(190447);
    g localg;
    if (this.wmm != null) {
      localg = this.wmm;
    }
    synchronized (localg.pcY)
    {
      com.tencent.mm.sdk.platformtools.ae.i("MicroMsg.Multitalk.ILinkAudioPlayer", "stopPlay, isStart: %s %s", new Object[] { Boolean.valueOf(localg.isStart), Integer.valueOf(localg.hashCode()) });
      if (localg.isStart)
      {
        a locala = localg.wmq;
        com.tencent.mm.plugin.voip.model.c localc = locala.pcA;
        if (localc != null)
        {
          localc.eyA();
          localc.eyx();
          locala.pcA = null;
        }
        localg.pda.gfF = SystemClock.elapsedRealtime();
        com.tencent.mm.sdk.platformtools.ae.i("MicroMsg.Multitalk.ILinkAudioPlayer", "stopPlaying cost: " + localg.pda.abs());
        localg.isStart = false;
      }
      this.mIsPlayMute = false;
      if (this.pcI != null)
      {
        this.pcI.PF();
        this.pcI = null;
        com.tencent.mm.sdk.platformtools.ae.i("MicroMsg.Multitalk.ILinkAudioMgr", "finish pauseRecord");
      }
      this.pcM = pcL;
      ??? = this.wmm.wmq;
      ((a)???).bHs();
      ((a)???).Wv("openvoice");
      ((a)???).iAr.abn();
      a.unInit();
      AppMethodBeat.o(190447);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.multitalk.b.f
 * JD-Core Version:    0.7.0.1
 */