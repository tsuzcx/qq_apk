package com.tencent.mm.plugin.multitalk.b;

import android.os.SystemClock;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.audio.b.c.a;
import com.tencent.mm.compatible.deviceinfo.ae;
import com.tencent.mm.compatible.util.f.a;
import com.tencent.mm.plugin.expt.b.b.a;
import com.tencent.mm.plugin.multitalk.b.a.a;
import com.tencent.mm.plugin.multitalk.model.ac;
import com.tencent.mm.plugin.multitalk.model.o;
import com.tencent.mm.plugin.voip.model.v2protocal;
import com.tencent.mm.protocal.protobuf.acs;
import com.tencent.mm.protocal.protobuf.aha;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.LongBuffer;

public final class f
{
  private static int qrK = 3;
  private int mChannels;
  private int mSampleRate;
  volatile com.tencent.mm.audio.b.c qrH;
  private int qrL;
  private int qrM;
  private int qrN;
  private final Object qrO;
  private int qrP;
  private int qrQ;
  private int qrR;
  private long qrS;
  private boolean qrT;
  private int qrV;
  private c.a qrW;
  public g zHq;
  private e zHr;
  private k zHs;
  
  public f(k paramk)
  {
    AppMethodBeat.i(239015);
    this.qrL = 1;
    this.qrM = 92;
    this.qrN = 1;
    this.qrO = new Object();
    this.qrP = 0;
    this.qrQ = 0;
    this.qrR = 1;
    this.qrS = 0L;
    this.qrT = false;
    this.mSampleRate = v2protocal.VOICE_SAMPLERATE;
    this.mChannels = 1;
    this.qrV = 20;
    this.qrW = new c.a()
    {
      public final void cj(int paramAnonymousInt1, int paramAnonymousInt2) {}
      
      public final void w(byte[] paramAnonymousArrayOfByte, int paramAnonymousInt)
      {
        int i = -1;
        int j = 0;
        AppMethodBeat.i(239013);
        for (;;)
        {
          synchronized (f.k(f.this))
          {
            if (f.a(f.this) % 50 == 0)
            {
              f.b(f.this);
              Log.v("MicroMsg.Multitalk.ILinkAudioMgr", "hy: syncOnRecPcmDataReady pcm raw length: %d, given len; %d", new Object[] { Integer.valueOf(paramAnonymousArrayOfByte.length), Integer.valueOf(paramAnonymousInt) });
            }
            if (f.c(f.this) == 2)
            {
              paramAnonymousInt = j;
              if (f.d(f.this).zHu.qrz == null) {
                break label404;
              }
              paramAnonymousInt = 1;
              break label404;
            }
            AppMethodBeat.o(239013);
            return;
            if (f.e(f.this) <= 10) {
              f.a(f.this, 92);
            }
            Object localObject2 = f.d(f.this).zHu.qrz;
            if (localObject2 != null)
            {
              paramAnonymousInt = ((com.tencent.mm.plugin.voip.model.c)localObject2).fFq();
              f.a(f.this, (paramAnonymousInt + 24 + f.e(f.this) * 3) / 4);
              if (f.f(f.this) != 1) {
                break label338;
              }
              localObject2 = f.d(f.this).zHu.qrz;
              paramAnonymousInt = i;
              if (localObject2 != null) {
                paramAnonymousInt = ((com.tencent.mm.plugin.voip.model.c)localObject2).fFn();
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
              Log.i("MicroMsg.Multitalk.ILinkAudioMgr", "amyfwang,first record");
              localObject2 = p.zHS;
              p.G(paramAnonymousArrayOfByte, paramAnonymousArrayOfByte.length, f.e(f.this));
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
            Log.i("MicroMsg.Multitalk.ILinkAudioMgr", "amyfwang,error,deltaTime:".concat(String.valueOf(l2)));
          }
          f.a(f.this, l1);
          continue;
          label404:
          if (paramAnonymousInt != 0) {}
        }
      }
    };
    this.zHr = new e();
    this.zHs = paramk;
    this.zHq = new g();
    AppMethodBeat.o(239015);
  }
  
  final void a(acs paramacs)
  {
    if (paramacs != null)
    {
      this.mSampleRate = paramacs.Lnx.LqF;
      this.mChannels = paramacs.Lnx.channels;
      this.qrV = paramacs.Lnx.LqG;
    }
  }
  
  public final boolean aai()
  {
    AppMethodBeat.i(239017);
    Log.i("MicroMsg.Multitalk.ILinkAudioMgr", "hy: trigger startrecord");
    if ((this.qrL != 2) || (this.qrH == null))
    {
      Log.e("MicroMsg.Multitalk.ILinkAudioMgr", "hy: not init when startrecord! devStatus:" + this.qrL);
      AppMethodBeat.o(239017);
      return false;
    }
    synchronized (this.qrO)
    {
      if (!this.qrH.aai())
      {
        if (this.qrH.dyZ != 13) {
          this.qrP = 1;
        }
        AppMethodBeat.o(239017);
        return false;
      }
      Log.d("MicroMsg.Multitalk.ILinkAudioMgr", "VoipDeivceHandler.m_iAudioDevErr:" + this.qrP);
      AppMethodBeat.o(239017);
      return true;
    }
  }
  
  public final boolean czm()
  {
    AppMethodBeat.i(239016);
    if ((this.qrL != 2) || (this.zHq == null))
    {
      Log.e("MicroMsg.Multitalk.ILinkAudioMgr", "hy: error not init when startplay, devStatus:" + this.qrL);
      AppMethodBeat.o(239016);
      return false;
    }
    if (this.zHq.a(new com.tencent.mm.plugin.voip.model.b()
    {
      public final int Q(byte[] paramAnonymousArrayOfByte, int paramAnonymousInt)
      {
        AppMethodBeat.i(239014);
        if (f.c(f.this) != 2)
        {
          AppMethodBeat.o(239014);
          return -1;
        }
        p localp = p.zHS;
        paramAnonymousInt = p.S(paramAnonymousArrayOfByte, paramAnonymousInt);
        if (!f.l(f.this))
        {
          if (paramAnonymousInt < 0)
          {
            AppMethodBeat.o(239014);
            return -1;
          }
        }
        else
        {
          AppMethodBeat.o(239014);
          return -10086;
        }
        AppMethodBeat.o(239014);
        return 0;
      }
    }, this.mSampleRate, this.mChannels, this.qrV) <= 0)
    {
      this.qrP = 1;
      AppMethodBeat.o(239016);
      return false;
    }
    ac.eol().emK();
    AppMethodBeat.o(239016);
    return true;
  }
  
  public final int elD()
  {
    if (this.qrH == null) {
      return 0;
    }
    return this.qrH.dyZ;
  }
  
  public final int elE()
  {
    AppMethodBeat.i(239018);
    if (this.zHq == null)
    {
      AppMethodBeat.o(239018);
      return 0;
    }
    com.tencent.mm.plugin.voip.model.c localc = this.zHq.zHu.qrz;
    if (localc != null)
    {
      int i = localc.fFs();
      AppMethodBeat.o(239018);
      return i;
    }
    AppMethodBeat.o(239018);
    return 0;
  }
  
  public final void init()
  {
    AppMethodBeat.i(239019);
    if (this.qrL == 2)
    {
      Log.e("MicroMsg.Multitalk.ILinkAudioMgr", "dev start already...");
      AppMethodBeat.o(239019);
      return;
    }
    MMHandlerThread.postToMainThread(new g.1(this.zHq));
    Log.i("MicroMsg.Multitalk.ILinkAudioMgr", "start device......");
    this.qrL = 2;
    ae.gKu.dump();
    Object localObject2 = new byte[1];
    localObject2[0] = 0;
    Object localObject1 = new byte[2];
    Log.i("MicroMsg.Multitalk.ILinkAudioCompatHelper", "hy: audio info dump begin");
    ae.gKu.dump();
    Object localObject3;
    byte b;
    label390:
    label526:
    long l;
    label915:
    label1226:
    int i;
    int j;
    int k;
    if (ae.gKu.gEo >= 0)
    {
      localObject1[0] = ((byte)ae.gKu.gEo);
      localObject3 = p.zHS;
      p.f(406, (byte[])localObject1, 1);
      m = ((com.tencent.mm.plugin.expt.b.b)com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.sgI, -1);
      Log.i("MicroMsg.Multitalk.ILinkAudioCompatHelper", "qipengfeng, x_agc_paras = %d", new Object[] { Integer.valueOf(m) });
      if (m > 0)
      {
        b = (byte)(m & 0x1);
        Log.i("MicroMsg.Multitalk.ILinkAudioCompatHelper", "qipengfeng, agc_switch = %d", new Object[] { Byte.valueOf(b) });
        if (b <= 0) {
          break label2135;
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
        localp = p.zHS;
        p.f(404, (byte[])localObject3, 7);
      }
      if (ae.gKu.gEt < 0) {
        break label2171;
      }
      localObject3 = new byte[7];
      if ((ae.gKu.gEu >= 0) && (ae.gKu.gEv >= 0))
      {
        localObject3[0] = ((byte)ae.gKu.gEu);
        localObject3[1] = ((byte)ae.gKu.gEv);
        if (ae.gKu.gEw < 0) {
          break label2153;
        }
        localObject3[2] = ((byte)ae.gKu.gEw);
        localObject3[3] = ((byte)ae.gKu.gEt);
        localObject3[4] = ((byte)ae.gKu.gEx);
        localObject3[5] = ((byte)ae.gKu.gEy);
        localObject3[6] = ((byte)ae.gKu.gEz);
        localp = p.zHS;
        p.f(404, (byte[])localObject3, 7);
      }
      l = ((com.tencent.mm.plugin.expt.b.b)com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.sgN, -1L);
      Log.i("MicroMsg.Multitalk.ILinkAudioCompatHelper", "qipengfeng, x-expt settings, wave_agc_paras: %d", new Object[] { Long.valueOf(l) });
      if (l > -1L)
      {
        localObject3 = new byte[11];
        localObject3[0] = ((byte)(int)(0x3 & l));
        Log.i("MicroMsg.Multitalk.ILinkAudioCompatHelper", "qipengfeng, x-expt settings, wave agc mode: %d", new Object[] { Byte.valueOf(localObject3[0]) });
        if (localObject3[0] != 1) {
          break label2200;
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
        localp = p.zHS;
        p.f(461, (byte[])localObject3, 11);
        Log.i("MicroMsg.Multitalk.ILinkAudioCompatHelper", "qipengfeng, x-expt settings, wave agc paras: %d, %d, %d, %d, %d, %d, %d, %d, %d, %d", new Object[] { Byte.valueOf(localObject3[1]), Byte.valueOf(localObject3[2]), Byte.valueOf(localObject3[3]), Byte.valueOf(localObject3[4]), Byte.valueOf(localObject3[5]), Byte.valueOf(localObject3[6]), Byte.valueOf(localObject3[7]), Byte.valueOf(localObject3[8]), Byte.valueOf(localObject3[9]), Byte.valueOf(localObject3[10]) });
      }
      Log.i("MicroMsg.Multitalk.ILinkAudioCompatHelper", "qipengfeng, device-model config, SrvDeviceInfo.mAudioInfo.waveAgcMode: %d", new Object[] { Integer.valueOf(ae.gKu.gEA) });
      if (ae.gKu.gEA >= 0)
      {
        localObject3 = new byte[11];
        localObject3[0] = ((byte)ae.gKu.gEA);
        if (localObject3[0] != 1) {
          break label2416;
        }
        localObject3[1] = ((byte)ae.gKu.gEH);
        localObject3[2] = ((byte)ae.gKu.gEI);
        localObject3[3] = ((byte)ae.gKu.gEJ);
        localObject3[4] = ((byte)ae.gKu.gEE);
        localObject3[5] = ((byte)ae.gKu.gEF);
        localObject3[6] = ((byte)ae.gKu.gEG);
        localObject3[7] = ((byte)ae.gKu.gEK);
        localObject3[8] = ((byte)ae.gKu.gEB);
        localObject3[9] = ((byte)ae.gKu.gEC);
        localObject3[10] = ((byte)ae.gKu.gED);
        localp = p.zHS;
        p.f(461, (byte[])localObject3, 11);
        Log.i("MicroMsg.Multitalk.ILinkAudioCompatHelper", "qipengfeng, device-model config, wave agc paras: %d, %d, %d, %d, %d, %d, %d, %d, %d, %d", new Object[] { Byte.valueOf(localObject3[1]), Byte.valueOf(localObject3[2]), Byte.valueOf(localObject3[3]), Byte.valueOf(localObject3[4]), Byte.valueOf(localObject3[5]), Byte.valueOf(localObject3[6]), Byte.valueOf(localObject3[7]), Byte.valueOf(localObject3[8]), Byte.valueOf(localObject3[9]), Byte.valueOf(localObject3[10]) });
      }
      m = ((com.tencent.mm.plugin.expt.b.b)com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.sfJ, 1002);
      if (m <= 0) {
        break label2609;
      }
      b = (byte)(m & 0xFF);
      i = (byte)(m >> 8 & 0xFF);
      j = (byte)(m >> 16 & 0xFF);
      k = (byte)(m >> 24 & 0xFF);
      localObject3 = p.zHS;
      p.f(408, (byte[])new byte[] { b, i, j, k }, 4);
      label1331:
      m = ae.gKu.gEq;
      Log.i("MicroMsg.Multitalk.ILinkAudioCompatHelper", "kerrizhang SrvDeviceInfo.mAudioInfo.nsModeNewMulti %d", new Object[] { Integer.valueOf(m) });
      if (ae.gKu.gEq < 0) {
        break label2677;
      }
      if (m <= 0) {
        break label2643;
      }
      int n = (int)Math.floor(m / 1000.0D) % 100;
      Log.i("MicroMsg.Multitalk.ILinkAudioCompatHelper", "kerrizhang SrvDeviceInfo.mAudioInfo.iflag %d", new Object[] { Integer.valueOf(n) });
      if (n > 0)
      {
        b = (byte)(m & 0xFF);
        i = (byte)(m >> 8 & 0xFF);
        j = (byte)(m >> 16 & 0xFF);
        k = (byte)(m >> 24 & 0xFF);
        localObject3 = p.zHS;
        p.f(408, (byte[])new byte[] { b, i, j, k }, 4);
      }
    }
    for (;;)
    {
      if ((ae.gKu.gEP[0] > 0) || (ae.gKu.gEP[1] > 0))
      {
        localObject1[0] = 0;
        localObject1[1] = 0;
        if ((ae.gKu.gEP[0] > 0) && (ae.gKu.gEP[0] < 10000)) {
          localObject1[0] = ((byte)ae.gKu.gEP[0]);
        }
        if ((ae.gKu.gEP[1] > 0) && (ae.gKu.gEP[1] < 10000)) {
          localObject1[1] = ((byte)ae.gKu.gEP[1]);
        }
        localObject3 = p.zHS;
        p.f(423, (byte[])localObject1, 2);
      }
      if ((ae.gKu.gDN >= 0) || (ae.gKu.gDP >= 0))
      {
        localObject1[0] = -1;
        localObject1[1] = -1;
        if (ae.gKu.gDN >= 0) {
          localObject1[0] = ((byte)ae.gKu.gDN);
        }
        if (ae.gKu.gDP >= 0) {
          localObject1[1] = ((byte)ae.gKu.gDP);
        }
        localObject3 = p.zHS;
        p.f(414, (byte[])localObject1, 2);
      }
      if ((ae.gKu.gDO >= 0) || (ae.gKu.gDQ >= 0))
      {
        localObject1[0] = -1;
        localObject1[1] = -1;
        if (ae.gKu.gDO >= 0) {
          localObject1[0] = ((byte)ae.gKu.gDO);
        }
        if (ae.gKu.gDQ >= 0) {
          localObject1[1] = ((byte)ae.gKu.gDQ);
        }
        localObject3 = p.zHS;
        p.f(415, (byte[])localObject1, 2);
      }
      if ((ae.gKu.gDR >= 0) || (ae.gKu.gDS >= 0))
      {
        localObject1[0] = -1;
        localObject1[1] = -1;
        if (ae.gKu.gDR >= 0) {
          localObject1[0] = ((byte)ae.gKu.gDR);
        }
        if (ae.gKu.gDS >= 0) {
          localObject1[1] = ((byte)ae.gKu.gDS);
        }
        localObject3 = p.zHS;
        p.f(422, (byte[])localObject1, 2);
      }
      if (ae.gKu.gDX >= 0)
      {
        localObject1[0] = ((byte)ae.gKu.gDX);
        localObject3 = p.zHS;
        p.f(416, (byte[])localObject1, 1);
      }
      if ((ae.gKu.gDY >= 0) && (ae.gKu.gDY != 5))
      {
        localObject1[0] = ((byte)ae.gKu.gDY);
        localObject3 = p.zHS;
        p.f(417, (byte[])localObject1, 1);
      }
      if ((ae.gKu.gDZ >= 0) && (ae.gKu.gDZ != 5))
      {
        localObject1[0] = ((byte)ae.gKu.gDZ);
        localObject3 = p.zHS;
        p.f(418, (byte[])localObject1, 1);
      }
      if (ae.gKu.gEa >= 0)
      {
        localObject1[0] = ((byte)ae.gKu.gEa);
        localObject3 = p.zHS;
        p.f(419, (byte[])localObject1, 1);
      }
      if (1 != ae.gKu.gEN) {
        break label2733;
      }
      localObject3 = new byte[30];
      m = 0;
      while (m < 15)
      {
        localObject3[(m * 2)] = ((byte)(ae.gKu.gEO[m] & 0xFF));
        localObject3[(m * 2 + 1)] = ((byte)(ae.gKu.gEO[m] >> 8 & 0xFF));
        m += 1;
      }
      if (ae.gKu.gEo != -2) {
        break;
      }
      localObject3 = p.zHS;
      p.f(407, (byte[])localObject2, 1);
      break;
      label2135:
      localObject3 = p.zHS;
      p.f(405, (byte[])localObject2, 1);
      break label390;
      label2153:
      localp = p.zHS;
      p.f(404, (byte[])localObject3, 2);
      break label526;
      label2171:
      if (ae.gKu.gEt != -2) {
        break label526;
      }
      localObject3 = p.zHS;
      p.f(405, (byte[])localObject2, 1);
      break label526;
      label2200:
      if (localObject3[0] == 2)
      {
        localObject3[1] = ((byte)(int)(l >> 2 & 0x1F));
        localObject3[2] = ((byte)(int)(l >> 7 & 0x1F));
        localObject3[3] = ((byte)(int)(l >> 12 & 0x1F));
        localObject3[4] = ((byte)(int)(l >> 17 & 0x1F));
        localObject3[5] = ((byte)(int)(l >> 22 & 0xF));
        localObject3[6] = ((byte)(int)(l >> 26 & 0xF));
        localp = p.zHS;
        p.f(461, (byte[])localObject3, 7);
        Log.i("MicroMsg.Multitalk.ILinkAudioCompatHelper", "qipengfeng, x-expt settings, wave agc paras: %d, %d, %d, %d, %d, %d", new Object[] { Byte.valueOf(localObject3[1]), Byte.valueOf(localObject3[2]), Byte.valueOf(localObject3[3]), Byte.valueOf(localObject3[4]), Byte.valueOf(localObject3[5]), Byte.valueOf(localObject3[6]) });
        break label915;
      }
      if (localObject3[0] != 0) {
        break label915;
      }
      localp = p.zHS;
      p.f(462, (byte[])localObject3, 1);
      break label915;
      label2416:
      if (localObject3[0] == 2)
      {
        localObject3[1] = ((byte)ae.gKu.gEB);
        localObject3[2] = ((byte)ae.gKu.gEC);
        localObject3[3] = ((byte)ae.gKu.gED);
        localObject3[4] = ((byte)ae.gKu.gEE);
        localObject3[5] = ((byte)ae.gKu.gEF);
        localObject3[6] = ((byte)ae.gKu.gEG);
        localp = p.zHS;
        p.f(461, (byte[])localObject3, 7);
        Log.i("MicroMsg.Multitalk.ILinkAudioCompatHelper", "qipengfeng, device-model config, wave agc paras: %d, %d, %d, %d, %d, %d", new Object[] { Byte.valueOf(localObject3[1]), Byte.valueOf(localObject3[2]), Byte.valueOf(localObject3[3]), Byte.valueOf(localObject3[4]), Byte.valueOf(localObject3[5]), Byte.valueOf(localObject3[6]) });
        break label1226;
      }
      if (localObject3[0] != 0) {
        break label1226;
      }
      localp = p.zHS;
      p.f(462, (byte[])localObject3, 1);
      break label1226;
      label2609:
      if (m != 0) {
        break label1331;
      }
      localObject2[0] = ((byte)(m & 0xFF));
      localObject3 = p.zHS;
      p.f(409, (byte[])localObject2, 1);
      break label1331;
      label2643:
      if (m == 0)
      {
        localObject2[0] = ((byte)(m & 0xFF));
        localObject3 = p.zHS;
        p.f(409, (byte[])localObject2, 1);
        continue;
        label2677:
        if (ae.gKu.gEq == -2)
        {
          localObject2[0] = ((byte)(m & 0xFF));
          localObject3 = p.zHS;
          p.f(409, (byte[])localObject2, 1);
        }
      }
    }
    p localp = p.zHS;
    p.f(420, (byte[])localObject3, 30);
    label2733:
    if (ae.gKu.gEN == 0)
    {
      localObject3 = p.zHS;
      p.f(421, (byte[])localObject2, 1);
    }
    if (ae.gKu.gER > 0)
    {
      localObject1[0] = ((byte)ae.gKu.gER);
      localObject2 = p.zHS;
      p.f(424, (byte[])localObject1, 1);
    }
    if (ae.gKu.gEb > 0)
    {
      localObject1[0] = ((byte)ae.gKu.gEb);
      localObject2 = p.zHS;
      p.f(431, (byte[])localObject1, 4);
    }
    int m = ((com.tencent.mm.plugin.expt.b.b)com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.sgJ, -1);
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
        localObject2 = p.zHS;
        p.f(426, (byte[])localObject1, 4);
        Log.i("MicroMsg.Multitalk.ILinkAudioCompatHelper", "qipengfeng, agc rx para: %d, %d, %d, %d", new Object[] { Byte.valueOf(localObject1[0]), Byte.valueOf(localObject1[1]), Byte.valueOf(localObject1[2]), Byte.valueOf(localObject1[3]) });
      }
    }
    if (ae.gKu.gEZ >= 0)
    {
      b = (byte)ae.gKu.gEZ;
      i = (byte)ae.gKu.gFa;
      j = (byte)ae.gKu.gFb;
      k = (byte)ae.gKu.gFc;
      localObject1 = p.zHS;
      p.f(426, new byte[] { b, i, j, k }, 4);
    }
    m = ((com.tencent.mm.plugin.expt.b.b)com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.sgh, -1);
    Log.i("MicroMsg.Multitalk.ILinkAudioCompatHelper", "kerrizhang, multi_play_fadeinfadeout_switch = %d", new Object[] { Integer.valueOf(m) });
    localObject1 = new byte[1];
    localObject1[0] = 0;
    if (m > 0) {
      localObject1[0] = ((byte)m);
    }
    localObject2 = p.zHS;
    p.f(451, (byte[])localObject1, 1);
    m = ((com.tencent.mm.plugin.expt.b.b)com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.sgi, -1);
    Log.i("MicroMsg.Multitalk.ILinkAudioCompatHelper", "kerrizhang, multi_play_fadeinfadeout_thresh = %d", new Object[] { Integer.valueOf(m) });
    localObject1[0] = 0;
    if (m > 0) {
      localObject1[0] = ((byte)m);
    }
    localObject2 = p.zHS;
    p.f(452, (byte[])localObject1, 1);
    localObject1 = new long[21];
    localObject1[0] = ((com.tencent.mm.plugin.expt.b.b)com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.sgj, -1L);
    localObject1[1] = ((com.tencent.mm.plugin.expt.b.b)com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.sgk, -1L);
    localObject1[2] = ((com.tencent.mm.plugin.expt.b.b)com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.sgl, -1L);
    localObject1[3] = ((com.tencent.mm.plugin.expt.b.b)com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.sgm, -1L);
    localObject1[4] = ((com.tencent.mm.plugin.expt.b.b)com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.sgn, -1L);
    localObject1[5] = ((com.tencent.mm.plugin.expt.b.b)com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.sgo, -1L);
    localObject1[6] = ((com.tencent.mm.plugin.expt.b.b)com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.sgp, -1L);
    localObject1[7] = ((com.tencent.mm.plugin.expt.b.b)com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.sgq, -1L);
    localObject1[8] = ((com.tencent.mm.plugin.expt.b.b)com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.sgr, -1L);
    localObject1[9] = ((com.tencent.mm.plugin.expt.b.b)com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.sgs, -1L);
    localObject1[10] = ((com.tencent.mm.plugin.expt.b.b)com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.sgt, -1L);
    localObject1[11] = ((com.tencent.mm.plugin.expt.b.b)com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.sgu, -1L);
    localObject1[12] = ((com.tencent.mm.plugin.expt.b.b)com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.sgv, -1L);
    localObject1[13] = ((com.tencent.mm.plugin.expt.b.b)com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.sgw, -1L);
    localObject1[14] = ((com.tencent.mm.plugin.expt.b.b)com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.sgx, -1L);
    localObject1[15] = ((com.tencent.mm.plugin.expt.b.b)com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.sgy, -1L);
    localObject1[16] = ((com.tencent.mm.plugin.expt.b.b)com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.sgz, -1L);
    localObject1[17] = ((com.tencent.mm.plugin.expt.b.b)com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.sgA, -1L);
    localObject1[18] = ((com.tencent.mm.plugin.expt.b.b)com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.sgB, -1L);
    localObject1[19] = ((com.tencent.mm.plugin.expt.b.b)com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.sgC, -1L);
    localObject1[20] = ((com.tencent.mm.plugin.expt.b.b)com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.sgD, -1L);
    localObject2 = ByteBuffer.allocate(168).order(ByteOrder.LITTLE_ENDIAN);
    ((ByteBuffer)localObject2).asLongBuffer().put((long[])localObject1);
    localObject2 = ((ByteBuffer)localObject2).array();
    Log.i("MicroMsg.Multitalk.ILinkAudioCompatHelper", "kerrizhang, multi_loss_control[0] %d,multi_loss_control[1] %d multi_loss_control[2] %d", new Object[] { Long.valueOf(localObject1[0]), Long.valueOf(localObject1[1]), Long.valueOf(localObject1[2]) });
    localObject1 = p.zHS;
    p.f(453, (byte[])localObject2, localObject2.length);
    m = ((com.tencent.mm.plugin.expt.b.b)com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.sgE, -1);
    Log.i("MicroMsg.Multitalk.ILinkAudioCompatHelper", "kerrizhang, rcnnvad_switch = %d", new Object[] { Integer.valueOf(m) });
    if (m > 0)
    {
      b = (byte)m;
      localObject1 = p.zHS;
      p.f(454, new byte[] { b }, 1);
    }
    m = ((com.tencent.mm.plugin.expt.b.b)com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.sgH, 0);
    Log.i("MicroMsg.Multitalk.ILinkAudioCompatHelper", "dennyliang, voip aec_value = %d", new Object[] { Integer.valueOf(m) });
    if (m > 0)
    {
      b = (byte)(m & 0xFF);
      i = (byte)(m >> 8 & 0xFF);
      j = (byte)(m >> 16 & 0xFF);
      k = (byte)(m >> 24 & 0xFF);
      localObject1 = p.zHS;
      p.f(460, new byte[] { b, i, j, k }, 4);
    }
    m = ((com.tencent.mm.plugin.expt.b.b)com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.sgO, -1);
    Log.i("MicroMsg.Multitalk.ILinkAudioCompatHelper", "qipengfeng, iLink updateAudioAdaption, frz_sta_p_x = %d", new Object[] { Integer.valueOf(m) });
    if (m > 0)
    {
      b = (byte)(m & 0xFF);
      i = (byte)(m >> 8 & 0xFF);
      j = (byte)(m >> 16 & 0xFF);
      k = (byte)(m >> 24 & 0xFF);
      localObject1 = p.zHS;
      p.f(464, new byte[] { b, i, j, k }, 4);
    }
    m = ((com.tencent.mm.plugin.expt.b.b)com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.sge, -1);
    Log.i("MicroMsg.Multitalk.ILinkAudioCompatHelper", "qipengfeng, updateAudioAdaption, switch_flag_x = %d", new Object[] { Integer.valueOf(m) });
    localObject1 = new byte[1];
    localObject1[0] = 0;
    if (m > 0) {
      localObject1[0] = 1;
    }
    localObject2 = p.zHS;
    p.f(450, (byte[])localObject1, 1);
    if (this.qrM <= 10)
    {
      if (this.qrM <= 0) {
        this.qrP = 1;
      }
      this.qrM = 92;
    }
    this.qrH = new com.tencent.mm.audio.b.c(this.mSampleRate, this.mChannels, 1);
    this.qrH.jk(this.qrV);
    this.qrH.dd(true);
    this.qrH.aag();
    this.qrH.dzk = -19;
    this.qrH.x(1, false);
    this.qrH.dc(true);
    this.qrH.dzv = this.qrW;
    AppMethodBeat.o(239019);
  }
  
  public final void release()
  {
    AppMethodBeat.i(239020);
    g localg;
    if (this.zHq != null) {
      localg = this.zHq;
    }
    synchronized (localg.qrY)
    {
      Log.i("MicroMsg.Multitalk.ILinkAudioPlayer", "stopPlay, isStart: %s %s", new Object[] { Boolean.valueOf(localg.isStart), Integer.valueOf(localg.hashCode()) });
      if (localg.isStart)
      {
        a locala = localg.zHu;
        com.tencent.mm.plugin.voip.model.c localc = locala.qrz;
        if (localc != null)
        {
          localc.fFr();
          localc.fFo();
          locala.qrz = null;
        }
        localg.qsa.gLm = SystemClock.elapsedRealtime();
        Log.i("MicroMsg.Multitalk.ILinkAudioPlayer", "stopPlaying cost: " + localg.qsa.apr());
        localg.isStart = false;
      }
      ac.eol().emL();
      this.qrT = false;
      if (this.qrH != null)
      {
        this.qrH.ZZ();
        this.qrH = null;
        Log.i("MicroMsg.Multitalk.ILinkAudioMgr", "finish pauseRecord");
      }
      this.qrL = qrK;
      if (this.zHq != null)
      {
        ??? = this.zHq.zHu;
        ((a)???).cdV();
        ((a)???).agq("openvoice");
        ((a)???).jvG.apm();
        a.unInit();
      }
      ac.eol().emL();
      AppMethodBeat.o(239020);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.multitalk.b.f
 * JD-Core Version:    0.7.0.1
 */