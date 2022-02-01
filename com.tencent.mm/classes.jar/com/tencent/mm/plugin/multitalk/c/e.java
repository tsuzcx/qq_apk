package com.tencent.mm.plugin.multitalk.c;

import android.os.SystemClock;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.deviceinfo.af;
import com.tencent.mm.compatible.util.f.a;
import com.tencent.mm.kernel.h;
import com.tencent.mm.plugin.multitalk.b.a;
import com.tencent.mm.plugin.multitalk.model.ac;
import com.tencent.mm.plugin.multitalk.model.n;
import com.tencent.mm.plugin.multitalk.model.p;
import com.tencent.mm.plugin.voip.model.v2protocal;
import com.tencent.mm.protocal.protobuf.afi;
import com.tencent.mm.protocal.protobuf.akd;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.LongBuffer;

public final class e
{
  private static int wTJ = 3;
  f LiF;
  private d LiG;
  private j LiH;
  a LiI;
  long LiJ;
  long LiK;
  int LiL;
  private int mChannels;
  private int mSampleRate;
  volatile com.tencent.mm.audio.b.c wTG;
  private int wTK;
  private int wTL;
  private int wTM;
  private final Object wTN;
  private int wTO;
  private int wTP;
  private int wTQ;
  private long wTR;
  private boolean wTS;
  private int wTU;
  private com.tencent.mm.audio.b.c.a wTV;
  
  public e(j paramj)
  {
    AppMethodBeat.i(285142);
    this.wTK = 1;
    this.wTL = 92;
    this.wTM = 1;
    this.wTN = new Object();
    this.wTO = 0;
    this.wTP = 0;
    this.wTQ = 1;
    this.wTR = 0L;
    this.wTS = false;
    this.mSampleRate = v2protocal.VOICE_SAMPLERATE;
    this.mChannels = 1;
    this.wTU = 20;
    this.LiJ = 0L;
    this.LiK = 0L;
    this.LiL = 0;
    this.wTV = new com.tencent.mm.audio.b.c.a()
    {
      public final void ds(int paramAnonymousInt1, int paramAnonymousInt2) {}
      
      public final void u(byte[] paramAnonymousArrayOfByte, int paramAnonymousInt)
      {
        int i = -1;
        AppMethodBeat.i(285200);
        for (;;)
        {
          Object localObject2;
          synchronized (e.k(e.this))
          {
            if (e.a(e.this) % 50 == 0)
            {
              e.b(e.this);
              Log.v("MicroMsg.Multitalk.ILinkAudioMgr", "hy: syncOnRecPcmDataReady pcm raw length: %d, given len; %d", new Object[] { Integer.valueOf(paramAnonymousArrayOfByte.length), Integer.valueOf(paramAnonymousInt) });
            }
            if (e.c(e.this) == 2)
            {
              if (e.d(e.this).Lir != null)
              {
                paramAnonymousInt = 1;
                break label429;
              }
            }
            else
            {
              AppMethodBeat.o(285200);
              return;
            }
            paramAnonymousInt = 0;
            break label429;
            if (e.e(e.this) <= 10) {
              e.a(e.this, 92);
            }
            e.d(e.this);
            if (ac.ggS().LoD == null) {
              break label436;
            }
            localObject2 = ac.ggS().LoD.Lir;
            if (localObject2 == null)
            {
              paramAnonymousInt = -1;
              e.a(e.this, (paramAnonymousInt + 24 + e.e(e.this) * 3) / 4);
              if (e.f(e.this) != 1) {
                break label363;
              }
              e.d(e.this);
              if (ac.ggS().LoD == null) {
                break label441;
              }
              localObject2 = ac.ggS().LoD.Lir;
              if (localObject2 != null) {
                break label354;
              }
              paramAnonymousInt = i;
              i = paramAnonymousInt;
              if (paramAnonymousInt >= e.e(e.this)) {
                i = paramAnonymousInt - e.e(e.this);
              }
              e.a(e.this, i);
              e.g(e.this);
              if (1 != e.h(e.this)) {
                break label375;
              }
              e.i(e.this);
              e.a(e.this, System.currentTimeMillis());
              Log.i("MicroMsg.Multitalk.ILinkAudioMgr", "amyfwang,first record");
              localObject2 = o.Ljn;
              o.G(paramAnonymousArrayOfByte, paramAnonymousArrayOfByte.length, e.e(e.this));
            }
          }
          paramAnonymousInt = ((com.tencent.mm.plugin.voip.model.c)localObject2).hVE();
          continue;
          label354:
          paramAnonymousInt = ((com.tencent.mm.plugin.voip.model.c)localObject2).hVB();
          continue;
          label363:
          e.a(e.this, 0);
          continue;
          label375:
          long l1 = System.currentTimeMillis();
          long l2 = l1 - e.j(e.this);
          if (l2 > 1000L) {
            Log.i("MicroMsg.Multitalk.ILinkAudioMgr", "amyfwang,error,deltaTime:".concat(String.valueOf(l2)));
          }
          e.a(e.this, l1);
          continue;
          label429:
          if (paramAnonymousInt == 0)
          {
            continue;
            label436:
            paramAnonymousInt = 0;
            continue;
            label441:
            paramAnonymousInt = 0;
          }
        }
      }
    };
    this.LiI = new a();
    ac.ggS().LoD = this.LiI;
    this.LiG = new d();
    this.LiH = paramj;
    this.LiF = new f();
    AppMethodBeat.o(285142);
  }
  
  final void a(afi paramafi)
  {
    if (paramafi != null)
    {
      this.mSampleRate = paramafi.ZnF.Zrl;
      this.mChannels = paramafi.ZnF.channels;
      this.wTU = paramafi.ZnF.Zrm;
    }
  }
  
  public final boolean drq()
  {
    AppMethodBeat.i(285222);
    if ((this.wTK != 2) || (this.LiF == null))
    {
      Log.e("MicroMsg.Multitalk.ILinkAudioMgr", "hy: error not init when startplay, devStatus:" + this.wTK);
      AppMethodBeat.o(285222);
      return false;
    }
    if (this.LiF.a(new com.tencent.mm.plugin.voip.model.b()
    {
      public final int PlayDevDataCallBack(byte[] paramAnonymousArrayOfByte, int paramAnonymousInt)
      {
        AppMethodBeat.i(285198);
        if (e.c(e.this) != 2)
        {
          AppMethodBeat.o(285198);
          return -1;
        }
        o localo = o.Ljn;
        paramAnonymousInt = o.T(paramAnonymousArrayOfByte, paramAnonymousInt);
        if (!e.l(e.this))
        {
          if (paramAnonymousInt < 0)
          {
            AppMethodBeat.o(285198);
            return -1;
          }
        }
        else
        {
          AppMethodBeat.o(285198);
          return -10086;
        }
        AppMethodBeat.o(285198);
        return 0;
      }
    }, this.mSampleRate, this.mChannels, this.wTU) <= 0)
    {
      this.wTO = 1;
      AppMethodBeat.o(285222);
      return false;
    }
    ac.ggR().gfs();
    AppMethodBeat.o(285222);
    return true;
  }
  
  public final int gef()
  {
    if (this.wTG == null) {
      return 0;
    }
    return this.wTG.hwc;
  }
  
  public final int geg()
  {
    AppMethodBeat.i(285244);
    if (this.LiF == null)
    {
      AppMethodBeat.o(285244);
      return 0;
    }
    if (ac.ggS().LoD != null)
    {
      int i = ac.ggS().LoD.gdY();
      AppMethodBeat.o(285244);
      return i;
    }
    AppMethodBeat.o(285244);
    return 0;
  }
  
  public final boolean hT(boolean paramBoolean)
  {
    boolean bool = false;
    AppMethodBeat.i(285233);
    Log.i("MicroMsg.Multitalk.ILinkAudioMgr", "hy: trigger startrecord, isMicEnable:%b", new Object[] { Boolean.valueOf(paramBoolean) });
    if ((this.wTK != 2) || (this.wTG == null))
    {
      Log.e("MicroMsg.Multitalk.ILinkAudioMgr", "hy: not init when startrecord! devStatus:" + this.wTK);
      AppMethodBeat.o(285233);
      return false;
    }
    synchronized (this.wTN)
    {
      if (!this.wTG.aGR())
      {
        if (this.wTG.hwc != 13) {
          this.wTO = 1;
        }
        AppMethodBeat.o(285233);
        return false;
      }
      o.Ljn.nt(paramBoolean);
      o.Ljn.Lks = paramBoolean;
      if (!paramBoolean) {
        bool = true;
      }
      yK(bool);
      Log.d("MicroMsg.Multitalk.ILinkAudioMgr", "VoipDeivceHandler.m_iAudioDevErr:" + this.wTO);
      AppMethodBeat.o(285233);
      return true;
    }
  }
  
  public final void init()
  {
    AppMethodBeat.i(285287);
    if (this.wTK == 2)
    {
      Log.e("MicroMsg.Multitalk.ILinkAudioMgr", "dev start already...");
      AppMethodBeat.o(285287);
      return;
    }
    MMHandlerThread.postToMainThread(new f.1(this.LiF));
    Log.i("MicroMsg.Multitalk.ILinkAudioMgr", "start device......");
    this.wTK = 2;
    af.lXZ.aQ();
    Object localObject2 = new byte[1];
    localObject2[0] = 0;
    Object localObject1 = new byte[2];
    Log.i("MicroMsg.Multitalk.ILinkAudioCompatHelper", "hy: audio info dump begin");
    af.lXZ.aQ();
    Object localObject3;
    byte b;
    label399:
    label535:
    long l;
    label927:
    label1240:
    int i;
    int j;
    int k;
    if (af.lXZ.lRG >= 0)
    {
      localObject1[0] = ((byte)af.lXZ.lRG);
      localObject3 = o.Ljn;
      o.e(406, (byte[])localObject1, 1);
      m = ((com.tencent.mm.plugin.expt.b.c)h.ax(com.tencent.mm.plugin.expt.b.c.class)).a(com.tencent.mm.plugin.expt.b.c.a.zjm, -1);
      Log.i("MicroMsg.Multitalk.ILinkAudioCompatHelper", "qipengfeng, x_agc_paras = %d", new Object[] { Integer.valueOf(m) });
      if (m > 0)
      {
        b = (byte)(m & 0x1);
        Log.i("MicroMsg.Multitalk.ILinkAudioCompatHelper", "qipengfeng, agc_switch = %d", new Object[] { Byte.valueOf(b) });
        if (b <= 0) {
          break label2145;
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
        localo = o.Ljn;
        o.e(404, (byte[])localObject3, 7);
      }
      if (af.lXZ.lRL < 0) {
        break label2181;
      }
      localObject3 = new byte[7];
      if ((af.lXZ.lRM >= 0) && (af.lXZ.lRN >= 0))
      {
        localObject3[0] = ((byte)af.lXZ.lRM);
        localObject3[1] = ((byte)af.lXZ.lRN);
        if (af.lXZ.lRO < 0) {
          break label2163;
        }
        localObject3[2] = ((byte)af.lXZ.lRO);
        localObject3[3] = ((byte)af.lXZ.lRL);
        localObject3[4] = ((byte)af.lXZ.lRP);
        localObject3[5] = ((byte)af.lXZ.lRQ);
        localObject3[6] = ((byte)af.lXZ.lRR);
        localo = o.Ljn;
        o.e(404, (byte[])localObject3, 7);
      }
      l = ((com.tencent.mm.plugin.expt.b.c)h.ax(com.tencent.mm.plugin.expt.b.c.class)).a(com.tencent.mm.plugin.expt.b.c.a.zjr, -1L);
      Log.i("MicroMsg.Multitalk.ILinkAudioCompatHelper", "qipengfeng, x-expt settings, wave_agc_paras: %d", new Object[] { Long.valueOf(l) });
      if (l > -1L)
      {
        localObject3 = new byte[11];
        localObject3[0] = ((byte)(int)(0x3 & l));
        Log.i("MicroMsg.Multitalk.ILinkAudioCompatHelper", "qipengfeng, x-expt settings, wave agc mode: %d", new Object[] { Byte.valueOf(localObject3[0]) });
        if (localObject3[0] != 1) {
          break label2210;
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
        localo = o.Ljn;
        o.e(461, (byte[])localObject3, 11);
        Log.i("MicroMsg.Multitalk.ILinkAudioCompatHelper", "qipengfeng, x-expt settings, wave agc paras: %d, %d, %d, %d, %d, %d, %d, %d, %d, %d", new Object[] { Byte.valueOf(localObject3[1]), Byte.valueOf(localObject3[2]), Byte.valueOf(localObject3[3]), Byte.valueOf(localObject3[4]), Byte.valueOf(localObject3[5]), Byte.valueOf(localObject3[6]), Byte.valueOf(localObject3[7]), Byte.valueOf(localObject3[8]), Byte.valueOf(localObject3[9]), Byte.valueOf(localObject3[10]) });
      }
      Log.i("MicroMsg.Multitalk.ILinkAudioCompatHelper", "qipengfeng, device-model config, SrvDeviceInfo.mAudioInfo.waveAgcMode: %d", new Object[] { Integer.valueOf(af.lXZ.lRS) });
      if (af.lXZ.lRS >= 0)
      {
        localObject3 = new byte[11];
        localObject3[0] = ((byte)af.lXZ.lRS);
        if (localObject3[0] != 1) {
          break label2427;
        }
        localObject3[1] = ((byte)af.lXZ.lRZ);
        localObject3[2] = ((byte)af.lXZ.lSa);
        localObject3[3] = ((byte)af.lXZ.lSb);
        localObject3[4] = ((byte)af.lXZ.lRW);
        localObject3[5] = ((byte)af.lXZ.lRX);
        localObject3[6] = ((byte)af.lXZ.lRY);
        localObject3[7] = ((byte)af.lXZ.lSc);
        localObject3[8] = ((byte)af.lXZ.lRT);
        localObject3[9] = ((byte)af.lXZ.lRU);
        localObject3[10] = ((byte)af.lXZ.lRV);
        localo = o.Ljn;
        o.e(461, (byte[])localObject3, 11);
        Log.i("MicroMsg.Multitalk.ILinkAudioCompatHelper", "qipengfeng, device-model config, wave agc paras: %d, %d, %d, %d, %d, %d, %d, %d, %d, %d", new Object[] { Byte.valueOf(localObject3[1]), Byte.valueOf(localObject3[2]), Byte.valueOf(localObject3[3]), Byte.valueOf(localObject3[4]), Byte.valueOf(localObject3[5]), Byte.valueOf(localObject3[6]), Byte.valueOf(localObject3[7]), Byte.valueOf(localObject3[8]), Byte.valueOf(localObject3[9]), Byte.valueOf(localObject3[10]) });
      }
      m = ((com.tencent.mm.plugin.expt.b.c)h.ax(com.tencent.mm.plugin.expt.b.c.class)).a(com.tencent.mm.plugin.expt.b.c.a.zie, 1002);
      if (m <= 0) {
        break label2621;
      }
      b = (byte)(m & 0xFF);
      i = (byte)(m >> 8 & 0xFF);
      j = (byte)(m >> 16 & 0xFF);
      k = (byte)(m >> 24 & 0xFF);
      localObject3 = o.Ljn;
      o.e(408, new byte[] { b, i, j, k }, 4);
      label1342:
      m = af.lXZ.lRI;
      Log.i("MicroMsg.Multitalk.ILinkAudioCompatHelper", "kerrizhang SrvDeviceInfo.mAudioInfo.nsModeNewMulti %d", new Object[] { Integer.valueOf(m) });
      if (af.lXZ.lRI < 0) {
        break label2689;
      }
      if (m <= 0) {
        break label2655;
      }
      int n = (int)Math.floor(m / 1000.0D) % 100;
      Log.i("MicroMsg.Multitalk.ILinkAudioCompatHelper", "kerrizhang SrvDeviceInfo.mAudioInfo.iflag %d", new Object[] { Integer.valueOf(n) });
      if (n > 0)
      {
        b = (byte)(m & 0xFF);
        i = (byte)(m >> 8 & 0xFF);
        j = (byte)(m >> 16 & 0xFF);
        k = (byte)(m >> 24 & 0xFF);
        localObject3 = o.Ljn;
        o.e(408, new byte[] { b, i, j, k }, 4);
      }
    }
    label2689:
    for (;;)
    {
      if ((af.lXZ.lSh[0] > 0) || (af.lXZ.lSh[1] > 0))
      {
        localObject1[0] = 0;
        localObject1[1] = 0;
        if ((af.lXZ.lSh[0] > 0) && (af.lXZ.lSh[0] < 10000)) {
          localObject1[0] = ((byte)af.lXZ.lSh[0]);
        }
        if ((af.lXZ.lSh[1] > 0) && (af.lXZ.lSh[1] < 10000)) {
          localObject1[1] = ((byte)af.lXZ.lSh[1]);
        }
        localObject3 = o.Ljn;
        o.e(423, (byte[])localObject1, 2);
      }
      if ((af.lXZ.lRf >= 0) || (af.lXZ.lRh >= 0))
      {
        localObject1[0] = -1;
        localObject1[1] = -1;
        if (af.lXZ.lRf >= 0) {
          localObject1[0] = ((byte)af.lXZ.lRf);
        }
        if (af.lXZ.lRh >= 0) {
          localObject1[1] = ((byte)af.lXZ.lRh);
        }
        localObject3 = o.Ljn;
        o.e(414, (byte[])localObject1, 2);
      }
      if ((af.lXZ.lRg >= 0) || (af.lXZ.lRi >= 0))
      {
        localObject1[0] = -1;
        localObject1[1] = -1;
        if (af.lXZ.lRg >= 0) {
          localObject1[0] = ((byte)af.lXZ.lRg);
        }
        if (af.lXZ.lRi >= 0) {
          localObject1[1] = ((byte)af.lXZ.lRi);
        }
        localObject3 = o.Ljn;
        o.e(415, (byte[])localObject1, 2);
      }
      if ((af.lXZ.lRj >= 0) || (af.lXZ.lRk >= 0))
      {
        localObject1[0] = -1;
        localObject1[1] = -1;
        if (af.lXZ.lRj >= 0) {
          localObject1[0] = ((byte)af.lXZ.lRj);
        }
        if (af.lXZ.lRk >= 0) {
          localObject1[1] = ((byte)af.lXZ.lRk);
        }
        localObject3 = o.Ljn;
        o.e(422, (byte[])localObject1, 2);
      }
      if (af.lXZ.lRp >= 0)
      {
        localObject1[0] = ((byte)af.lXZ.lRp);
        localObject3 = o.Ljn;
        o.e(416, (byte[])localObject1, 1);
      }
      if ((af.lXZ.lRq >= 0) && (af.lXZ.lRq != 5))
      {
        localObject1[0] = ((byte)af.lXZ.lRq);
        localObject3 = o.Ljn;
        o.e(417, (byte[])localObject1, 1);
      }
      if ((af.lXZ.lRr >= 0) && (af.lXZ.lRr != 5))
      {
        localObject1[0] = ((byte)af.lXZ.lRr);
        localObject3 = o.Ljn;
        o.e(418, (byte[])localObject1, 1);
      }
      if (af.lXZ.lRs >= 0)
      {
        localObject1[0] = ((byte)af.lXZ.lRs);
        localObject3 = o.Ljn;
        o.e(419, (byte[])localObject1, 1);
      }
      if (1 != af.lXZ.lSf) {
        break label2745;
      }
      localObject3 = new byte[30];
      m = 0;
      while (m < 15)
      {
        localObject3[(m * 2)] = ((byte)(af.lXZ.lSg[m] & 0xFF));
        localObject3[(m * 2 + 1)] = ((byte)(af.lXZ.lSg[m] >> 8 & 0xFF));
        m += 1;
      }
      if (af.lXZ.lRG != -2) {
        break;
      }
      localObject3 = o.Ljn;
      o.e(407, (byte[])localObject2, 1);
      break;
      label2145:
      localObject3 = o.Ljn;
      o.e(405, (byte[])localObject2, 1);
      break label399;
      label2163:
      localo = o.Ljn;
      o.e(404, (byte[])localObject3, 2);
      break label535;
      label2181:
      if (af.lXZ.lRL != -2) {
        break label535;
      }
      localObject3 = o.Ljn;
      o.e(405, (byte[])localObject2, 1);
      break label535;
      label2210:
      if (localObject3[0] == 2)
      {
        localObject3[1] = ((byte)(int)(l >> 2 & 0x1F));
        localObject3[2] = ((byte)(int)(l >> 7 & 0x1F));
        localObject3[3] = ((byte)(int)(l >> 12 & 0x1F));
        localObject3[4] = ((byte)(int)(l >> 17 & 0x1F));
        localObject3[5] = ((byte)(int)(l >> 22 & 0xF));
        localObject3[6] = ((byte)(int)(l >> 26 & 0xF));
        localo = o.Ljn;
        o.e(461, (byte[])localObject3, 7);
        Log.i("MicroMsg.Multitalk.ILinkAudioCompatHelper", "qipengfeng, x-expt settings, wave agc paras: %d, %d, %d, %d, %d, %d", new Object[] { Byte.valueOf(localObject3[1]), Byte.valueOf(localObject3[2]), Byte.valueOf(localObject3[3]), Byte.valueOf(localObject3[4]), Byte.valueOf(localObject3[5]), Byte.valueOf(localObject3[6]) });
        break label927;
      }
      if (localObject3[0] != 0) {
        break label927;
      }
      localo = o.Ljn;
      o.e(462, (byte[])localObject3, 1);
      break label927;
      label2427:
      if (localObject3[0] == 2)
      {
        localObject3[1] = ((byte)af.lXZ.lRT);
        localObject3[2] = ((byte)af.lXZ.lRU);
        localObject3[3] = ((byte)af.lXZ.lRV);
        localObject3[4] = ((byte)af.lXZ.lRW);
        localObject3[5] = ((byte)af.lXZ.lRX);
        localObject3[6] = ((byte)af.lXZ.lRY);
        localo = o.Ljn;
        o.e(461, (byte[])localObject3, 7);
        Log.i("MicroMsg.Multitalk.ILinkAudioCompatHelper", "qipengfeng, device-model config, wave agc paras: %d, %d, %d, %d, %d, %d", new Object[] { Byte.valueOf(localObject3[1]), Byte.valueOf(localObject3[2]), Byte.valueOf(localObject3[3]), Byte.valueOf(localObject3[4]), Byte.valueOf(localObject3[5]), Byte.valueOf(localObject3[6]) });
        break label1240;
      }
      if (localObject3[0] != 0) {
        break label1240;
      }
      localo = o.Ljn;
      o.e(462, (byte[])localObject3, 1);
      break label1240;
      label2621:
      if (m != 0) {
        break label1342;
      }
      localObject2[0] = ((byte)(m & 0xFF));
      localObject3 = o.Ljn;
      o.e(409, (byte[])localObject2, 1);
      break label1342;
      label2655:
      if (m == 0)
      {
        localObject2[0] = ((byte)(m & 0xFF));
        localObject3 = o.Ljn;
        o.e(409, (byte[])localObject2, 1);
        continue;
        if (af.lXZ.lRI == -2)
        {
          localObject2[0] = ((byte)(m & 0xFF));
          localObject3 = o.Ljn;
          o.e(409, (byte[])localObject2, 1);
        }
      }
    }
    o localo = o.Ljn;
    o.e(420, (byte[])localObject3, 30);
    label2745:
    if (af.lXZ.lSf == 0)
    {
      localObject3 = o.Ljn;
      o.e(421, (byte[])localObject2, 1);
    }
    if (af.lXZ.lSj > 0)
    {
      localObject1[0] = ((byte)af.lXZ.lSj);
      localObject2 = o.Ljn;
      o.e(424, (byte[])localObject1, 1);
    }
    if (af.lXZ.lRt > 0)
    {
      localObject1[0] = ((byte)af.lXZ.lRt);
      localObject2 = o.Ljn;
      o.e(431, (byte[])localObject1, 4);
    }
    int m = ((com.tencent.mm.plugin.expt.b.c)h.ax(com.tencent.mm.plugin.expt.b.c.class)).a(com.tencent.mm.plugin.expt.b.c.a.zjn, -1);
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
        localObject2 = o.Ljn;
        o.e(426, (byte[])localObject1, 4);
        Log.i("MicroMsg.Multitalk.ILinkAudioCompatHelper", "qipengfeng, agc rx para: %d, %d, %d, %d", new Object[] { Byte.valueOf(localObject1[0]), Byte.valueOf(localObject1[1]), Byte.valueOf(localObject1[2]), Byte.valueOf(localObject1[3]) });
      }
    }
    if (af.lXZ.lSr >= 0)
    {
      b = (byte)af.lXZ.lSr;
      i = (byte)af.lXZ.lSs;
      j = (byte)af.lXZ.lSt;
      k = (byte)af.lXZ.lSu;
      localObject1 = o.Ljn;
      o.e(426, new byte[] { b, i, j, k }, 4);
    }
    m = ((com.tencent.mm.plugin.expt.b.c)h.ax(com.tencent.mm.plugin.expt.b.c.class)).a(com.tencent.mm.plugin.expt.b.c.a.ziH, -1);
    Log.i("MicroMsg.Multitalk.ILinkAudioCompatHelper", "kerrizhang, multi_play_fadeinfadeout_switch = %d", new Object[] { Integer.valueOf(m) });
    localObject1 = new byte[1];
    localObject1[0] = 0;
    if (m > 0) {
      localObject1[0] = ((byte)m);
    }
    localObject2 = o.Ljn;
    o.e(451, (byte[])localObject1, 1);
    m = ((com.tencent.mm.plugin.expt.b.c)h.ax(com.tencent.mm.plugin.expt.b.c.class)).a(com.tencent.mm.plugin.expt.b.c.a.ziI, -1);
    Log.i("MicroMsg.Multitalk.ILinkAudioCompatHelper", "kerrizhang, multi_play_fadeinfadeout_thresh = %d", new Object[] { Integer.valueOf(m) });
    localObject1[0] = 0;
    if (m > 0) {
      localObject1[0] = ((byte)m);
    }
    localObject2 = o.Ljn;
    o.e(452, (byte[])localObject1, 1);
    localObject1 = new long[21];
    localObject1[0] = ((com.tencent.mm.plugin.expt.b.c)h.ax(com.tencent.mm.plugin.expt.b.c.class)).a(com.tencent.mm.plugin.expt.b.c.a.ziK, -1L);
    localObject1[1] = ((com.tencent.mm.plugin.expt.b.c)h.ax(com.tencent.mm.plugin.expt.b.c.class)).a(com.tencent.mm.plugin.expt.b.c.a.ziL, -1L);
    localObject1[2] = ((com.tencent.mm.plugin.expt.b.c)h.ax(com.tencent.mm.plugin.expt.b.c.class)).a(com.tencent.mm.plugin.expt.b.c.a.ziM, -1L);
    localObject1[3] = ((com.tencent.mm.plugin.expt.b.c)h.ax(com.tencent.mm.plugin.expt.b.c.class)).a(com.tencent.mm.plugin.expt.b.c.a.ziN, -1L);
    localObject1[4] = ((com.tencent.mm.plugin.expt.b.c)h.ax(com.tencent.mm.plugin.expt.b.c.class)).a(com.tencent.mm.plugin.expt.b.c.a.ziO, -1L);
    localObject1[5] = ((com.tencent.mm.plugin.expt.b.c)h.ax(com.tencent.mm.plugin.expt.b.c.class)).a(com.tencent.mm.plugin.expt.b.c.a.ziP, -1L);
    localObject1[6] = ((com.tencent.mm.plugin.expt.b.c)h.ax(com.tencent.mm.plugin.expt.b.c.class)).a(com.tencent.mm.plugin.expt.b.c.a.ziQ, -1L);
    localObject1[7] = ((com.tencent.mm.plugin.expt.b.c)h.ax(com.tencent.mm.plugin.expt.b.c.class)).a(com.tencent.mm.plugin.expt.b.c.a.ziR, -1L);
    localObject1[8] = ((com.tencent.mm.plugin.expt.b.c)h.ax(com.tencent.mm.plugin.expt.b.c.class)).a(com.tencent.mm.plugin.expt.b.c.a.ziS, -1L);
    localObject1[9] = ((com.tencent.mm.plugin.expt.b.c)h.ax(com.tencent.mm.plugin.expt.b.c.class)).a(com.tencent.mm.plugin.expt.b.c.a.ziT, -1L);
    localObject1[10] = ((com.tencent.mm.plugin.expt.b.c)h.ax(com.tencent.mm.plugin.expt.b.c.class)).a(com.tencent.mm.plugin.expt.b.c.a.ziU, -1L);
    localObject1[11] = ((com.tencent.mm.plugin.expt.b.c)h.ax(com.tencent.mm.plugin.expt.b.c.class)).a(com.tencent.mm.plugin.expt.b.c.a.ziV, -1L);
    localObject1[12] = ((com.tencent.mm.plugin.expt.b.c)h.ax(com.tencent.mm.plugin.expt.b.c.class)).a(com.tencent.mm.plugin.expt.b.c.a.ziW, -1L);
    localObject1[13] = ((com.tencent.mm.plugin.expt.b.c)h.ax(com.tencent.mm.plugin.expt.b.c.class)).a(com.tencent.mm.plugin.expt.b.c.a.ziX, -1L);
    localObject1[14] = ((com.tencent.mm.plugin.expt.b.c)h.ax(com.tencent.mm.plugin.expt.b.c.class)).a(com.tencent.mm.plugin.expt.b.c.a.ziY, -1L);
    localObject1[15] = ((com.tencent.mm.plugin.expt.b.c)h.ax(com.tencent.mm.plugin.expt.b.c.class)).a(com.tencent.mm.plugin.expt.b.c.a.ziZ, -1L);
    localObject1[16] = ((com.tencent.mm.plugin.expt.b.c)h.ax(com.tencent.mm.plugin.expt.b.c.class)).a(com.tencent.mm.plugin.expt.b.c.a.zja, -1L);
    localObject1[17] = ((com.tencent.mm.plugin.expt.b.c)h.ax(com.tencent.mm.plugin.expt.b.c.class)).a(com.tencent.mm.plugin.expt.b.c.a.zjb, -1L);
    localObject1[18] = ((com.tencent.mm.plugin.expt.b.c)h.ax(com.tencent.mm.plugin.expt.b.c.class)).a(com.tencent.mm.plugin.expt.b.c.a.zjc, -1L);
    localObject1[19] = ((com.tencent.mm.plugin.expt.b.c)h.ax(com.tencent.mm.plugin.expt.b.c.class)).a(com.tencent.mm.plugin.expt.b.c.a.zjd, -1L);
    localObject1[20] = ((com.tencent.mm.plugin.expt.b.c)h.ax(com.tencent.mm.plugin.expt.b.c.class)).a(com.tencent.mm.plugin.expt.b.c.a.zje, -1L);
    localObject2 = ByteBuffer.allocate(168).order(ByteOrder.LITTLE_ENDIAN);
    ((ByteBuffer)localObject2).asLongBuffer().put((long[])localObject1);
    localObject2 = ((ByteBuffer)localObject2).array();
    Log.i("MicroMsg.Multitalk.ILinkAudioCompatHelper", "kerrizhang, multi_loss_control[0] %d,multi_loss_control[1] %d multi_loss_control[2] %d", new Object[] { Long.valueOf(localObject1[0]), Long.valueOf(localObject1[1]), Long.valueOf(localObject1[2]) });
    localObject1 = o.Ljn;
    o.e(453, (byte[])localObject2, localObject2.length);
    m = ((com.tencent.mm.plugin.expt.b.c)h.ax(com.tencent.mm.plugin.expt.b.c.class)).a(com.tencent.mm.plugin.expt.b.c.a.zjf, -1);
    Log.i("MicroMsg.Multitalk.ILinkAudioCompatHelper", "kerrizhang, rcnnvad_switch = %d", new Object[] { Integer.valueOf(m) });
    if (m > 0)
    {
      b = (byte)m;
      localObject1 = o.Ljn;
      o.e(454, new byte[] { b }, 1);
    }
    m = ((com.tencent.mm.plugin.expt.b.c)h.ax(com.tencent.mm.plugin.expt.b.c.class)).a(com.tencent.mm.plugin.expt.b.c.a.zjl, 0);
    Log.i("MicroMsg.Multitalk.ILinkAudioCompatHelper", "dennyliang, voip aec_value = %d", new Object[] { Integer.valueOf(m) });
    if (m > 0)
    {
      b = (byte)(m & 0xFF);
      i = (byte)(m >> 8 & 0xFF);
      j = (byte)(m >> 16 & 0xFF);
      k = (byte)(m >> 24 & 0xFF);
      localObject1 = o.Ljn;
      o.e(460, new byte[] { b, i, j, k }, 4);
    }
    m = ((com.tencent.mm.plugin.expt.b.c)h.ax(com.tencent.mm.plugin.expt.b.c.class)).a(com.tencent.mm.plugin.expt.b.c.a.zjs, -1);
    Log.i("MicroMsg.Multitalk.ILinkAudioCompatHelper", "qipengfeng, iLink updateAudioAdaption, frz_sta_p_x = %d", new Object[] { Integer.valueOf(m) });
    if (m > 0)
    {
      b = (byte)(m & 0xFF);
      i = (byte)(m >> 8 & 0xFF);
      j = (byte)(m >> 16 & 0xFF);
      k = (byte)(m >> 24 & 0xFF);
      localObject1 = o.Ljn;
      o.e(464, new byte[] { b, i, j, k }, 4);
    }
    m = ((com.tencent.mm.plugin.expt.b.c)h.ax(com.tencent.mm.plugin.expt.b.c.class)).a(com.tencent.mm.plugin.expt.b.c.a.ziJ, -1);
    Log.i("MicroMsg.Multitalk.ILinkAudioCompatHelper", "qipengfeng, updateAudioAdaption, net_state_xexpt = %d", new Object[] { Integer.valueOf(m) });
    localObject1 = new byte[1];
    localObject1[0] = 0;
    if (m == 1) {
      localObject1[0] = 1;
    }
    localObject2 = o.Ljn;
    o.e(936, (byte[])localObject1, 1);
    m = ((com.tencent.mm.plugin.expt.b.c)h.ax(com.tencent.mm.plugin.expt.b.c.class)).a(com.tencent.mm.plugin.expt.b.c.a.ziE, -1);
    Log.i("MicroMsg.Multitalk.ILinkAudioCompatHelper", "qipengfeng, updateAudioAdaption, switch_flag_x = %d", new Object[] { Integer.valueOf(m) });
    localObject1 = new byte[1];
    localObject1[0] = 0;
    if (m > 0) {
      localObject1[0] = 1;
    }
    localObject2 = o.Ljn;
    o.e(450, (byte[])localObject1, 1);
    if (this.wTL <= 10)
    {
      if (this.wTL <= 0) {
        this.wTO = 1;
      }
      this.wTL = 92;
    }
    this.wTG = new com.tencent.mm.audio.b.c(this.mSampleRate, this.mChannels, 1);
    this.wTG.ok(this.wTU);
    this.wTG.ep(true);
    this.wTG.aGP();
    this.wTG.hwn = -19;
    this.wTG.O(1, false);
    this.wTG.eo(true);
    this.wTG.hwy = this.wTV;
    AppMethodBeat.o(285287);
  }
  
  public final void release()
  {
    AppMethodBeat.i(285292);
    this.LiI = null;
    f localf;
    if (this.LiF != null) {
      localf = this.LiF;
    }
    synchronized (localf.wTX)
    {
      Log.i("MicroMsg.Multitalk.ILinkAudioPlayer", "stopPlay, isStart: %s %s", new Object[] { Boolean.valueOf(localf.isStart), Integer.valueOf(localf.hashCode()) });
      if (localf.isStart)
      {
        if (localf.Lir != null)
        {
          localf.Lir.hVF();
          localf.Lir.hVC();
          localf.Lir = null;
          if (ac.ggS().LoD != null) {
            ac.ggS().LoD.Lir = null;
          }
        }
        if (ac.ggS().LoD != null) {
          ac.ggS().LoD.ged();
        }
        localf.wTZ.lYS = SystemClock.elapsedRealtime();
        Log.i("MicroMsg.Multitalk.ILinkAudioPlayer", "stopPlaying cost: " + localf.wTZ.aPY());
        localf.isStart = false;
      }
      ac.ggR().gft();
      this.wTS = false;
      Log.i("MicroMsg.Multitalk.ILinkAudioMgr", "stopRecord.");
      if (this.wTG != null)
      {
        this.wTG.aGH();
        this.wTG = null;
        Log.i("MicroMsg.Multitalk.ILinkAudioMgr", "finish pauseRecord");
      }
      o.Ljn.nt(false);
      this.wTK = wTJ;
      if (this.LiF != null)
      {
        if (ac.ggS().LoD != null) {
          ac.ggS().LoD.ged();
        }
        if (ac.ggS().LoD != null)
        {
          ac.ggS();
          com.tencent.mm.plugin.multitalk.b.b.unInit();
        }
      }
      ac.ggR().gft();
      AppMethodBeat.o(285292);
      return;
    }
  }
  
  final boolean yK(boolean paramBoolean)
  {
    AppMethodBeat.i(285250);
    if (this.wTG != null)
    {
      this.wTG.eq(paramBoolean);
      AppMethodBeat.o(285250);
      return true;
    }
    AppMethodBeat.o(285250);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.multitalk.c.e
 * JD-Core Version:    0.7.0.1
 */