package com.tencent.mm.plugin.multitalk.b;

import android.os.SystemClock;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.audio.b.c.a;
import com.tencent.mm.compatible.deviceinfo.af;
import com.tencent.mm.compatible.util.f.a;
import com.tencent.mm.kernel.h;
import com.tencent.mm.plugin.expt.b.b.a;
import com.tencent.mm.plugin.multitalk.a.a;
import com.tencent.mm.plugin.multitalk.model.ad;
import com.tencent.mm.plugin.multitalk.model.q;
import com.tencent.mm.plugin.voip.model.v2protocal;
import com.tencent.mm.protocal.protobuf.ada;
import com.tencent.mm.protocal.protobuf.ahm;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.LongBuffer;

public final class e
{
  private static int tQt = 3;
  public f FmB;
  private d FmC;
  private j FmD;
  a FmE;
  private int mChannels;
  private int mSampleRate;
  private int tQA;
  private long tQB;
  private boolean tQC;
  private int tQE;
  private c.a tQF;
  volatile com.tencent.mm.audio.b.c tQq;
  private int tQu;
  private int tQv;
  private int tQw;
  private final Object tQx;
  private int tQy;
  private int tQz;
  
  public e(j paramj)
  {
    AppMethodBeat.i(202183);
    this.tQu = 1;
    this.tQv = 92;
    this.tQw = 1;
    this.tQx = new Object();
    this.tQy = 0;
    this.tQz = 0;
    this.tQA = 1;
    this.tQB = 0L;
    this.tQC = false;
    this.mSampleRate = v2protocal.VOICE_SAMPLERATE;
    this.mChannels = 1;
    this.tQE = 20;
    this.tQF = new c.a()
    {
      public final void cC(int paramAnonymousInt1, int paramAnonymousInt2) {}
      
      public final void w(byte[] paramAnonymousArrayOfByte, int paramAnonymousInt)
      {
        int i = -1;
        int j = 0;
        AppMethodBeat.i(202824);
        for (;;)
        {
          synchronized (e.k(e.this))
          {
            if (e.a(e.this) % 50 == 0)
            {
              e.b(e.this);
              Log.v("MicroMsg.Multitalk.ILinkAudioMgr", "hy: syncOnRecPcmDataReady pcm raw length: %d, given len; %d", new Object[] { Integer.valueOf(paramAnonymousArrayOfByte.length), Integer.valueOf(paramAnonymousInt) });
            }
            if (e.c(e.this) == 2)
            {
              e.d(e.this);
              paramAnonymousInt = j;
              if (ad.eYc().Fsp.Fmm == null) {
                break label416;
              }
              paramAnonymousInt = 1;
              break label416;
            }
            AppMethodBeat.o(202824);
            return;
            if (e.e(e.this) <= 10) {
              e.a(e.this, 92);
            }
            e.d(e.this);
            Object localObject2 = ad.eYc().Fsp.Fmm;
            if (localObject2 != null)
            {
              paramAnonymousInt = ((com.tencent.mm.plugin.voip.model.c)localObject2).gxC();
              e.a(e.this, (paramAnonymousInt + 24 + e.e(e.this) * 3) / 4);
              if (e.f(e.this) != 1) {
                break label350;
              }
              e.d(e.this);
              localObject2 = ad.eYc().Fsp.Fmm;
              paramAnonymousInt = i;
              if (localObject2 != null) {
                paramAnonymousInt = ((com.tencent.mm.plugin.voip.model.c)localObject2).gxz();
              }
              i = paramAnonymousInt;
              if (paramAnonymousInt >= e.e(e.this)) {
                i = paramAnonymousInt - e.e(e.this);
              }
              e.a(e.this, i);
              e.g(e.this);
              if (1 != e.h(e.this)) {
                break label362;
              }
              e.i(e.this);
              e.a(e.this, System.currentTimeMillis());
              Log.i("MicroMsg.Multitalk.ILinkAudioMgr", "amyfwang,first record");
              localObject2 = o.Fne;
              o.I(paramAnonymousArrayOfByte, paramAnonymousArrayOfByte.length, e.e(e.this));
            }
          }
          paramAnonymousInt = -1;
          continue;
          label350:
          e.a(e.this, 0);
          continue;
          label362:
          long l1 = System.currentTimeMillis();
          long l2 = l1 - e.j(e.this);
          if (l2 > 1000L) {
            Log.i("MicroMsg.Multitalk.ILinkAudioMgr", "amyfwang,error,deltaTime:".concat(String.valueOf(l2)));
          }
          e.a(e.this, l1);
          continue;
          label416:
          if (paramAnonymousInt != 0) {}
        }
      }
    };
    this.FmE = new a();
    ad.eYc().Fsp = this.FmE;
    this.FmC = new d();
    this.FmD = paramj;
    this.FmB = new f();
    AppMethodBeat.o(202183);
  }
  
  final void a(ada paramada)
  {
    if (paramada != null)
    {
      this.mSampleRate = paramada.SoS.Ssd;
      this.mChannels = paramada.SoS.channels;
      this.tQE = paramada.SoS.Sse;
    }
  }
  
  public final boolean aeU()
  {
    AppMethodBeat.i(202196);
    Log.i("MicroMsg.Multitalk.ILinkAudioMgr", "hy: trigger startrecord");
    if ((this.tQu != 2) || (this.tQq == null))
    {
      Log.e("MicroMsg.Multitalk.ILinkAudioMgr", "hy: not init when startrecord! devStatus:" + this.tQu);
      AppMethodBeat.o(202196);
      return false;
    }
    synchronized (this.tQx)
    {
      if (!this.tQq.aeU())
      {
        if (this.tQq.frO != 13) {
          this.tQy = 1;
        }
        AppMethodBeat.o(202196);
        return false;
      }
      o.Fne.lY(true);
      Log.d("MicroMsg.Multitalk.ILinkAudioMgr", "VoipDeivceHandler.m_iAudioDevErr:" + this.tQy);
      AppMethodBeat.o(202196);
      return true;
    }
  }
  
  public final boolean cNM()
  {
    AppMethodBeat.i(202189);
    if ((this.tQu != 2) || (this.FmB == null))
    {
      Log.e("MicroMsg.Multitalk.ILinkAudioMgr", "hy: error not init when startplay, devStatus:" + this.tQu);
      AppMethodBeat.o(202189);
      return false;
    }
    if (this.FmB.a(new com.tencent.mm.plugin.voip.model.b()
    {
      public final int R(byte[] paramAnonymousArrayOfByte, int paramAnonymousInt)
      {
        AppMethodBeat.i(196558);
        if (e.c(e.this) != 2)
        {
          AppMethodBeat.o(196558);
          return -1;
        }
        o localo = o.Fne;
        paramAnonymousInt = o.V(paramAnonymousArrayOfByte, paramAnonymousInt);
        if (!e.l(e.this))
        {
          if (paramAnonymousInt < 0)
          {
            AppMethodBeat.o(196558);
            return -1;
          }
        }
        else
        {
          AppMethodBeat.o(196558);
          return -10086;
        }
        AppMethodBeat.o(196558);
        return 0;
      }
    }, this.mSampleRate, this.mChannels, this.tQE) <= 0)
    {
      this.tQy = 1;
      AppMethodBeat.o(202189);
      return false;
    }
    ad.eYb().eWz();
    AppMethodBeat.o(202189);
    return true;
  }
  
  public final int eVo()
  {
    if (this.tQq == null) {
      return 0;
    }
    return this.tQq.frO;
  }
  
  public final int eVp()
  {
    AppMethodBeat.i(202202);
    if (this.FmB == null)
    {
      AppMethodBeat.o(202202);
      return 0;
    }
    int i = ad.eYc().Fsp.eVj();
    AppMethodBeat.o(202202);
    return i;
  }
  
  public final void init()
  {
    AppMethodBeat.i(202277);
    if (this.tQu == 2)
    {
      Log.e("MicroMsg.Multitalk.ILinkAudioMgr", "dev start already...");
      AppMethodBeat.o(202277);
      return;
    }
    MMHandlerThread.postToMainThread(new f.1(this.FmB));
    Log.i("MicroMsg.Multitalk.ILinkAudioMgr", "start device......");
    this.tQu = 2;
    af.juI.Y();
    Object localObject2 = new byte[1];
    localObject2[0] = 0;
    Object localObject1 = new byte[2];
    Log.i("MicroMsg.Multitalk.ILinkAudioCompatHelper", "hy: audio info dump begin");
    af.juI.Y();
    Object localObject3;
    byte b;
    label395:
    label531:
    long l;
    label923:
    label1236:
    int i;
    int j;
    int k;
    if (af.juI.joy >= 0)
    {
      localObject1[0] = ((byte)af.juI.joy);
      localObject3 = o.Fne;
      o.f(406, (byte[])localObject1, 1);
      m = ((com.tencent.mm.plugin.expt.b.b)h.ae(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.vQD, -1);
      Log.i("MicroMsg.Multitalk.ILinkAudioCompatHelper", "qipengfeng, x_agc_paras = %d", new Object[] { Integer.valueOf(m) });
      if (m > 0)
      {
        b = (byte)(m & 0x1);
        Log.i("MicroMsg.Multitalk.ILinkAudioCompatHelper", "qipengfeng, agc_switch = %d", new Object[] { Byte.valueOf(b) });
        if (b <= 0) {
          break label2147;
        }
        localObject3 = new byte[7];
        localObject3[0] = ((byte)(m >> 1 & 0x1F));
        localObject3[1] = ((byte)(m >> 6 & 0x1F));
        localObject3[2] = ((byte)(m >> 11 & 0x3));
        localObject3[3] = ((byte)(m >> 13 & 0x3));
        localObject3[4] = ((byte)(m >> 15 & 0x1));
        localObject3[5] = ((byte)(m >> 16 & 0x7));
        localObject3[6] = ((byte)(m >> 19 & 0xF));
        Log.i("MicroMsg.Multitalk.ILinkAudioCompatHelper", "qipengfeng, agc para: %d, %d, %d, %d, %d, %d, %d", new Object[] { Byte.valueOf(localObject3[0]), Byte.valueOf(localObject3[1]), Byte.valueOf(localObject3[2]), Byte.valueOf(localObject3[3]), Byte.valueOf(localObject3[4]), Byte.valueOf(localObject3[5]), Byte.valueOf(localObject3[6]) });
        localo = o.Fne;
        o.f(404, (byte[])localObject3, 7);
      }
      if (af.juI.joD < 0) {
        break label2183;
      }
      localObject3 = new byte[7];
      if ((af.juI.joE >= 0) && (af.juI.joF >= 0))
      {
        localObject3[0] = ((byte)af.juI.joE);
        localObject3[1] = ((byte)af.juI.joF);
        if (af.juI.joG < 0) {
          break label2165;
        }
        localObject3[2] = ((byte)af.juI.joG);
        localObject3[3] = ((byte)af.juI.joD);
        localObject3[4] = ((byte)af.juI.joH);
        localObject3[5] = ((byte)af.juI.joI);
        localObject3[6] = ((byte)af.juI.joJ);
        localo = o.Fne;
        o.f(404, (byte[])localObject3, 7);
      }
      l = ((com.tencent.mm.plugin.expt.b.b)h.ae(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.vQI, -1L);
      Log.i("MicroMsg.Multitalk.ILinkAudioCompatHelper", "qipengfeng, x-expt settings, wave_agc_paras: %d", new Object[] { Long.valueOf(l) });
      if (l > -1L)
      {
        localObject3 = new byte[11];
        localObject3[0] = ((byte)(int)(0x3 & l));
        Log.i("MicroMsg.Multitalk.ILinkAudioCompatHelper", "qipengfeng, x-expt settings, wave agc mode: %d", new Object[] { Byte.valueOf(localObject3[0]) });
        if (localObject3[0] != 1) {
          break label2212;
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
        localo = o.Fne;
        o.f(461, (byte[])localObject3, 11);
        Log.i("MicroMsg.Multitalk.ILinkAudioCompatHelper", "qipengfeng, x-expt settings, wave agc paras: %d, %d, %d, %d, %d, %d, %d, %d, %d, %d", new Object[] { Byte.valueOf(localObject3[1]), Byte.valueOf(localObject3[2]), Byte.valueOf(localObject3[3]), Byte.valueOf(localObject3[4]), Byte.valueOf(localObject3[5]), Byte.valueOf(localObject3[6]), Byte.valueOf(localObject3[7]), Byte.valueOf(localObject3[8]), Byte.valueOf(localObject3[9]), Byte.valueOf(localObject3[10]) });
      }
      Log.i("MicroMsg.Multitalk.ILinkAudioCompatHelper", "qipengfeng, device-model config, SrvDeviceInfo.mAudioInfo.waveAgcMode: %d", new Object[] { Integer.valueOf(af.juI.joK) });
      if (af.juI.joK >= 0)
      {
        localObject3 = new byte[11];
        localObject3[0] = ((byte)af.juI.joK);
        if (localObject3[0] != 1) {
          break label2429;
        }
        localObject3[1] = ((byte)af.juI.joR);
        localObject3[2] = ((byte)af.juI.joS);
        localObject3[3] = ((byte)af.juI.joT);
        localObject3[4] = ((byte)af.juI.joO);
        localObject3[5] = ((byte)af.juI.joP);
        localObject3[6] = ((byte)af.juI.joQ);
        localObject3[7] = ((byte)af.juI.joU);
        localObject3[8] = ((byte)af.juI.joL);
        localObject3[9] = ((byte)af.juI.joM);
        localObject3[10] = ((byte)af.juI.joN);
        localo = o.Fne;
        o.f(461, (byte[])localObject3, 11);
        Log.i("MicroMsg.Multitalk.ILinkAudioCompatHelper", "qipengfeng, device-model config, wave agc paras: %d, %d, %d, %d, %d, %d, %d, %d, %d, %d", new Object[] { Byte.valueOf(localObject3[1]), Byte.valueOf(localObject3[2]), Byte.valueOf(localObject3[3]), Byte.valueOf(localObject3[4]), Byte.valueOf(localObject3[5]), Byte.valueOf(localObject3[6]), Byte.valueOf(localObject3[7]), Byte.valueOf(localObject3[8]), Byte.valueOf(localObject3[9]), Byte.valueOf(localObject3[10]) });
      }
      m = ((com.tencent.mm.plugin.expt.b.b)h.ae(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.vPz, 1002);
      if (m <= 0) {
        break label2623;
      }
      b = (byte)(m & 0xFF);
      i = (byte)(m >> 8 & 0xFF);
      j = (byte)(m >> 16 & 0xFF);
      k = (byte)(m >> 24 & 0xFF);
      localObject3 = o.Fne;
      o.f(408, (byte[])new byte[] { b, i, j, k }, 4);
      label1341:
      m = af.juI.joA;
      Log.i("MicroMsg.Multitalk.ILinkAudioCompatHelper", "kerrizhang SrvDeviceInfo.mAudioInfo.nsModeNewMulti %d", new Object[] { Integer.valueOf(m) });
      if (af.juI.joA < 0) {
        break label2691;
      }
      if (m <= 0) {
        break label2657;
      }
      int n = (int)Math.floor(m / 1000.0D) % 100;
      Log.i("MicroMsg.Multitalk.ILinkAudioCompatHelper", "kerrizhang SrvDeviceInfo.mAudioInfo.iflag %d", new Object[] { Integer.valueOf(n) });
      if (n > 0)
      {
        b = (byte)(m & 0xFF);
        i = (byte)(m >> 8 & 0xFF);
        j = (byte)(m >> 16 & 0xFF);
        k = (byte)(m >> 24 & 0xFF);
        localObject3 = o.Fne;
        o.f(408, (byte[])new byte[] { b, i, j, k }, 4);
      }
    }
    label2691:
    for (;;)
    {
      if ((af.juI.joZ[0] > 0) || (af.juI.joZ[1] > 0))
      {
        localObject1[0] = 0;
        localObject1[1] = 0;
        if ((af.juI.joZ[0] > 0) && (af.juI.joZ[0] < 10000)) {
          localObject1[0] = ((byte)af.juI.joZ[0]);
        }
        if ((af.juI.joZ[1] > 0) && (af.juI.joZ[1] < 10000)) {
          localObject1[1] = ((byte)af.juI.joZ[1]);
        }
        localObject3 = o.Fne;
        o.f(423, (byte[])localObject1, 2);
      }
      if ((af.juI.jnX >= 0) || (af.juI.jnZ >= 0))
      {
        localObject1[0] = -1;
        localObject1[1] = -1;
        if (af.juI.jnX >= 0) {
          localObject1[0] = ((byte)af.juI.jnX);
        }
        if (af.juI.jnZ >= 0) {
          localObject1[1] = ((byte)af.juI.jnZ);
        }
        localObject3 = o.Fne;
        o.f(414, (byte[])localObject1, 2);
      }
      if ((af.juI.jnY >= 0) || (af.juI.joa >= 0))
      {
        localObject1[0] = -1;
        localObject1[1] = -1;
        if (af.juI.jnY >= 0) {
          localObject1[0] = ((byte)af.juI.jnY);
        }
        if (af.juI.joa >= 0) {
          localObject1[1] = ((byte)af.juI.joa);
        }
        localObject3 = o.Fne;
        o.f(415, (byte[])localObject1, 2);
      }
      if ((af.juI.job >= 0) || (af.juI.joc >= 0))
      {
        localObject1[0] = -1;
        localObject1[1] = -1;
        if (af.juI.job >= 0) {
          localObject1[0] = ((byte)af.juI.job);
        }
        if (af.juI.joc >= 0) {
          localObject1[1] = ((byte)af.juI.joc);
        }
        localObject3 = o.Fne;
        o.f(422, (byte[])localObject1, 2);
      }
      if (af.juI.joh >= 0)
      {
        localObject1[0] = ((byte)af.juI.joh);
        localObject3 = o.Fne;
        o.f(416, (byte[])localObject1, 1);
      }
      if ((af.juI.joi >= 0) && (af.juI.joi != 5))
      {
        localObject1[0] = ((byte)af.juI.joi);
        localObject3 = o.Fne;
        o.f(417, (byte[])localObject1, 1);
      }
      if ((af.juI.joj >= 0) && (af.juI.joj != 5))
      {
        localObject1[0] = ((byte)af.juI.joj);
        localObject3 = o.Fne;
        o.f(418, (byte[])localObject1, 1);
      }
      if (af.juI.jok >= 0)
      {
        localObject1[0] = ((byte)af.juI.jok);
        localObject3 = o.Fne;
        o.f(419, (byte[])localObject1, 1);
      }
      if (1 != af.juI.joX) {
        break label2747;
      }
      localObject3 = new byte[30];
      m = 0;
      while (m < 15)
      {
        localObject3[(m * 2)] = ((byte)(af.juI.joY[m] & 0xFF));
        localObject3[(m * 2 + 1)] = ((byte)(af.juI.joY[m] >> 8 & 0xFF));
        m += 1;
      }
      if (af.juI.joy != -2) {
        break;
      }
      localObject3 = o.Fne;
      o.f(407, (byte[])localObject2, 1);
      break;
      label2147:
      localObject3 = o.Fne;
      o.f(405, (byte[])localObject2, 1);
      break label395;
      label2165:
      localo = o.Fne;
      o.f(404, (byte[])localObject3, 2);
      break label531;
      label2183:
      if (af.juI.joD != -2) {
        break label531;
      }
      localObject3 = o.Fne;
      o.f(405, (byte[])localObject2, 1);
      break label531;
      label2212:
      if (localObject3[0] == 2)
      {
        localObject3[1] = ((byte)(int)(l >> 2 & 0x1F));
        localObject3[2] = ((byte)(int)(l >> 7 & 0x1F));
        localObject3[3] = ((byte)(int)(l >> 12 & 0x1F));
        localObject3[4] = ((byte)(int)(l >> 17 & 0x1F));
        localObject3[5] = ((byte)(int)(l >> 22 & 0xF));
        localObject3[6] = ((byte)(int)(l >> 26 & 0xF));
        localo = o.Fne;
        o.f(461, (byte[])localObject3, 7);
        Log.i("MicroMsg.Multitalk.ILinkAudioCompatHelper", "qipengfeng, x-expt settings, wave agc paras: %d, %d, %d, %d, %d, %d", new Object[] { Byte.valueOf(localObject3[1]), Byte.valueOf(localObject3[2]), Byte.valueOf(localObject3[3]), Byte.valueOf(localObject3[4]), Byte.valueOf(localObject3[5]), Byte.valueOf(localObject3[6]) });
        break label923;
      }
      if (localObject3[0] != 0) {
        break label923;
      }
      localo = o.Fne;
      o.f(462, (byte[])localObject3, 1);
      break label923;
      label2429:
      if (localObject3[0] == 2)
      {
        localObject3[1] = ((byte)af.juI.joL);
        localObject3[2] = ((byte)af.juI.joM);
        localObject3[3] = ((byte)af.juI.joN);
        localObject3[4] = ((byte)af.juI.joO);
        localObject3[5] = ((byte)af.juI.joP);
        localObject3[6] = ((byte)af.juI.joQ);
        localo = o.Fne;
        o.f(461, (byte[])localObject3, 7);
        Log.i("MicroMsg.Multitalk.ILinkAudioCompatHelper", "qipengfeng, device-model config, wave agc paras: %d, %d, %d, %d, %d, %d", new Object[] { Byte.valueOf(localObject3[1]), Byte.valueOf(localObject3[2]), Byte.valueOf(localObject3[3]), Byte.valueOf(localObject3[4]), Byte.valueOf(localObject3[5]), Byte.valueOf(localObject3[6]) });
        break label1236;
      }
      if (localObject3[0] != 0) {
        break label1236;
      }
      localo = o.Fne;
      o.f(462, (byte[])localObject3, 1);
      break label1236;
      label2623:
      if (m != 0) {
        break label1341;
      }
      localObject2[0] = ((byte)(m & 0xFF));
      localObject3 = o.Fne;
      o.f(409, (byte[])localObject2, 1);
      break label1341;
      label2657:
      if (m == 0)
      {
        localObject2[0] = ((byte)(m & 0xFF));
        localObject3 = o.Fne;
        o.f(409, (byte[])localObject2, 1);
        continue;
        if (af.juI.joA == -2)
        {
          localObject2[0] = ((byte)(m & 0xFF));
          localObject3 = o.Fne;
          o.f(409, (byte[])localObject2, 1);
        }
      }
    }
    o localo = o.Fne;
    o.f(420, (byte[])localObject3, 30);
    label2747:
    if (af.juI.joX == 0)
    {
      localObject3 = o.Fne;
      o.f(421, (byte[])localObject2, 1);
    }
    if (af.juI.jpb > 0)
    {
      localObject1[0] = ((byte)af.juI.jpb);
      localObject2 = o.Fne;
      o.f(424, (byte[])localObject1, 1);
    }
    if (af.juI.jol > 0)
    {
      localObject1[0] = ((byte)af.juI.jol);
      localObject2 = o.Fne;
      o.f(431, (byte[])localObject1, 4);
    }
    int m = ((com.tencent.mm.plugin.expt.b.b)h.ae(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.vQE, -1);
    Log.i("MicroMsg.Multitalk.ILinkAudioCompatHelper", "qipengfeng, x_agcrx_paras: %d", new Object[] { Integer.valueOf(m) });
    if (m > 0)
    {
      b = (byte)(m & 0x1);
      Log.i("MicroMsg.Multitalk.ILinkAudioCompatHelper", "qipengfeng, agcrx_switch: %d", new Object[] { Byte.valueOf(b) });
      if (b > 0)
      {
        localObject1 = new byte[4];
        localObject1[0] = ((byte)(m >> 1 & 0x3));
        localObject1[1] = ((byte)(m >> 3 & 0x1F));
        localObject1[2] = ((byte)(m >> 8 & 0x1F));
        localObject1[3] = ((byte)(m >> 13 & 0x1));
        localObject2 = o.Fne;
        o.f(426, (byte[])localObject1, 4);
        Log.i("MicroMsg.Multitalk.ILinkAudioCompatHelper", "qipengfeng, agc rx para: %d, %d, %d, %d", new Object[] { Byte.valueOf(localObject1[0]), Byte.valueOf(localObject1[1]), Byte.valueOf(localObject1[2]), Byte.valueOf(localObject1[3]) });
      }
    }
    if (af.juI.jpj >= 0)
    {
      b = (byte)af.juI.jpj;
      i = (byte)af.juI.jpk;
      j = (byte)af.juI.jpl;
      k = (byte)af.juI.jpm;
      localObject1 = o.Fne;
      o.f(426, new byte[] { b, i, j, k }, 4);
    }
    m = ((com.tencent.mm.plugin.expt.b.b)h.ae(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.vPZ, -1);
    Log.i("MicroMsg.Multitalk.ILinkAudioCompatHelper", "kerrizhang, multi_play_fadeinfadeout_switch = %d", new Object[] { Integer.valueOf(m) });
    localObject1 = new byte[1];
    localObject1[0] = 0;
    if (m > 0) {
      localObject1[0] = ((byte)m);
    }
    localObject2 = o.Fne;
    o.f(451, (byte[])localObject1, 1);
    m = ((com.tencent.mm.plugin.expt.b.b)h.ae(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.vQa, -1);
    Log.i("MicroMsg.Multitalk.ILinkAudioCompatHelper", "kerrizhang, multi_play_fadeinfadeout_thresh = %d", new Object[] { Integer.valueOf(m) });
    localObject1[0] = 0;
    if (m > 0) {
      localObject1[0] = ((byte)m);
    }
    localObject2 = o.Fne;
    o.f(452, (byte[])localObject1, 1);
    localObject1 = new long[21];
    localObject1[0] = ((com.tencent.mm.plugin.expt.b.b)h.ae(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.vQb, -1L);
    localObject1[1] = ((com.tencent.mm.plugin.expt.b.b)h.ae(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.vQc, -1L);
    localObject1[2] = ((com.tencent.mm.plugin.expt.b.b)h.ae(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.vQd, -1L);
    localObject1[3] = ((com.tencent.mm.plugin.expt.b.b)h.ae(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.vQe, -1L);
    localObject1[4] = ((com.tencent.mm.plugin.expt.b.b)h.ae(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.vQf, -1L);
    localObject1[5] = ((com.tencent.mm.plugin.expt.b.b)h.ae(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.vQg, -1L);
    localObject1[6] = ((com.tencent.mm.plugin.expt.b.b)h.ae(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.vQh, -1L);
    localObject1[7] = ((com.tencent.mm.plugin.expt.b.b)h.ae(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.vQi, -1L);
    localObject1[8] = ((com.tencent.mm.plugin.expt.b.b)h.ae(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.vQj, -1L);
    localObject1[9] = ((com.tencent.mm.plugin.expt.b.b)h.ae(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.vQk, -1L);
    localObject1[10] = ((com.tencent.mm.plugin.expt.b.b)h.ae(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.vQl, -1L);
    localObject1[11] = ((com.tencent.mm.plugin.expt.b.b)h.ae(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.vQm, -1L);
    localObject1[12] = ((com.tencent.mm.plugin.expt.b.b)h.ae(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.vQn, -1L);
    localObject1[13] = ((com.tencent.mm.plugin.expt.b.b)h.ae(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.vQo, -1L);
    localObject1[14] = ((com.tencent.mm.plugin.expt.b.b)h.ae(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.vQp, -1L);
    localObject1[15] = ((com.tencent.mm.plugin.expt.b.b)h.ae(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.vQq, -1L);
    localObject1[16] = ((com.tencent.mm.plugin.expt.b.b)h.ae(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.vQr, -1L);
    localObject1[17] = ((com.tencent.mm.plugin.expt.b.b)h.ae(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.vQs, -1L);
    localObject1[18] = ((com.tencent.mm.plugin.expt.b.b)h.ae(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.vQt, -1L);
    localObject1[19] = ((com.tencent.mm.plugin.expt.b.b)h.ae(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.vQu, -1L);
    localObject1[20] = ((com.tencent.mm.plugin.expt.b.b)h.ae(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.vQv, -1L);
    localObject2 = ByteBuffer.allocate(168).order(ByteOrder.LITTLE_ENDIAN);
    ((ByteBuffer)localObject2).asLongBuffer().put((long[])localObject1);
    localObject2 = ((ByteBuffer)localObject2).array();
    Log.i("MicroMsg.Multitalk.ILinkAudioCompatHelper", "kerrizhang, multi_loss_control[0] %d,multi_loss_control[1] %d multi_loss_control[2] %d", new Object[] { Long.valueOf(localObject1[0]), Long.valueOf(localObject1[1]), Long.valueOf(localObject1[2]) });
    localObject1 = o.Fne;
    o.f(453, (byte[])localObject2, localObject2.length);
    m = ((com.tencent.mm.plugin.expt.b.b)h.ae(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.vQw, -1);
    Log.i("MicroMsg.Multitalk.ILinkAudioCompatHelper", "kerrizhang, rcnnvad_switch = %d", new Object[] { Integer.valueOf(m) });
    if (m > 0)
    {
      b = (byte)m;
      localObject1 = o.Fne;
      o.f(454, new byte[] { b }, 1);
    }
    m = ((com.tencent.mm.plugin.expt.b.b)h.ae(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.vQC, 0);
    Log.i("MicroMsg.Multitalk.ILinkAudioCompatHelper", "dennyliang, voip aec_value = %d", new Object[] { Integer.valueOf(m) });
    if (m > 0)
    {
      b = (byte)(m & 0xFF);
      i = (byte)(m >> 8 & 0xFF);
      j = (byte)(m >> 16 & 0xFF);
      k = (byte)(m >> 24 & 0xFF);
      localObject1 = o.Fne;
      o.f(460, new byte[] { b, i, j, k }, 4);
    }
    m = ((com.tencent.mm.plugin.expt.b.b)h.ae(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.vQJ, -1);
    Log.i("MicroMsg.Multitalk.ILinkAudioCompatHelper", "qipengfeng, iLink updateAudioAdaption, frz_sta_p_x = %d", new Object[] { Integer.valueOf(m) });
    if (m > 0)
    {
      b = (byte)(m & 0xFF);
      i = (byte)(m >> 8 & 0xFF);
      j = (byte)(m >> 16 & 0xFF);
      k = (byte)(m >> 24 & 0xFF);
      localObject1 = o.Fne;
      o.f(464, new byte[] { b, i, j, k }, 4);
    }
    m = ((com.tencent.mm.plugin.expt.b.b)h.ae(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.vPW, -1);
    Log.i("MicroMsg.Multitalk.ILinkAudioCompatHelper", "qipengfeng, updateAudioAdaption, switch_flag_x = %d", new Object[] { Integer.valueOf(m) });
    localObject1 = new byte[1];
    localObject1[0] = 0;
    if (m > 0) {
      localObject1[0] = 1;
    }
    localObject2 = o.Fne;
    o.f(450, (byte[])localObject1, 1);
    if (this.tQv <= 10)
    {
      if (this.tQv <= 0) {
        this.tQy = 1;
      }
      this.tQv = 92;
    }
    this.tQq = new com.tencent.mm.audio.b.c(this.mSampleRate, this.mChannels, 1);
    this.tQq.kD(this.tQE);
    this.tQq.dD(true);
    this.tQq.aeR();
    this.tQq.frZ = -19;
    this.tQq.z(1, false);
    this.tQq.dC(true);
    this.tQq.fsk = this.tQF;
    AppMethodBeat.o(202277);
  }
  
  public final void release()
  {
    AppMethodBeat.i(202287);
    this.FmE = null;
    f localf;
    if (this.FmB != null) {
      localf = this.FmB;
    }
    synchronized (localf.tQH)
    {
      Log.i("MicroMsg.Multitalk.ILinkAudioPlayer", "stopPlay, isStart: %s %s", new Object[] { Boolean.valueOf(localf.isStart), Integer.valueOf(localf.hashCode()) });
      if (localf.isStart)
      {
        if (localf.Fmm != null)
        {
          localf.Fmm.gxD();
          localf.Fmm.gxA();
          localf.Fmm = null;
          ad.eYc().Fsp.Fmm = null;
        }
        ad.eYc().Fsp.eVm();
        localf.tQJ.jvB = SystemClock.elapsedRealtime();
        Log.i("MicroMsg.Multitalk.ILinkAudioPlayer", "stopPlaying cost: " + localf.tQJ.avE());
        localf.isStart = false;
      }
      ad.eYb().eWA();
      this.tQC = false;
      if (this.tQq != null)
      {
        this.tQq.aeJ();
        this.tQq = null;
        Log.i("MicroMsg.Multitalk.ILinkAudioMgr", "finish pauseRecord");
      }
      o.Fne.lY(false);
      this.tQu = tQt;
      if (this.FmB != null)
      {
        ad.eYc().Fsp.eVm();
        ad.eYc();
        com.tencent.mm.plugin.multitalk.a.b.unInit();
      }
      ad.eYb().eWA();
      AppMethodBeat.o(202287);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.multitalk.b.e
 * JD-Core Version:    0.7.0.1
 */