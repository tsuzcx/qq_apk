package com.tencent.mm.plugin.voip.model;

import android.media.AudioManager;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.audio.b.c.a;
import com.tencent.mm.compatible.util.f;
import com.tencent.mm.plugin.voip.video.render.j;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandler;
import com.tencent.mm.sdk.platformtools.Util;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;

public final class n
{
  public static int NKa = 60;
  public static int NNf;
  public static int NNg;
  public static int tQt = 3;
  l NJk;
  volatile c NMO;
  private long NMP;
  private long NMQ;
  private int NMR;
  private int NMS;
  private long NMT;
  private int NMU;
  private int NMV;
  final Object NMW;
  public boolean NMX;
  public boolean NMY;
  public int NMZ;
  private int NNa;
  private long NNb;
  public MMHandler NNc;
  long NNd;
  private int NNe;
  a NNh;
  private ByteBuffer NNi;
  private int tQA;
  private long tQB;
  private c.a tQF;
  volatile com.tencent.mm.audio.b.c tQq;
  public int tQu;
  int tQv;
  private int tQw;
  public int tQy;
  
  static
  {
    NNf = 0;
    NNg = 0;
  }
  
  public n(l paraml)
  {
    AppMethodBeat.i(114946);
    this.NMO = null;
    this.tQq = null;
    this.tQu = 1;
    this.NJk = null;
    this.tQv = 92;
    this.NMP = 0L;
    this.NMQ = 0L;
    this.NMR = 1;
    this.NMS = 0;
    this.tQw = 1;
    this.NMT = 0L;
    this.NMU = 0;
    this.NMV = 0;
    this.NMW = new Object();
    this.tQy = 0;
    this.NMX = false;
    this.NMY = false;
    this.NMZ = 0;
    this.tQA = 1;
    this.NNa = 1;
    this.tQB = 0L;
    this.NNb = 0L;
    this.NNd = 0L;
    this.NNe = 0;
    this.tQF = new c.a()
    {
      public final void cC(int paramAnonymousInt1, int paramAnonymousInt2) {}
      
      public final void w(byte[] paramAnonymousArrayOfByte, int paramAnonymousInt)
      {
        AppMethodBeat.i(114941);
        for (;;)
        {
          synchronized (n.n(n.this))
          {
            if (com.tencent.mm.plugin.audio.c.a.crn().audioManager.isMusicActive()) {
              com.tencent.mm.audio.c.b.a.kO(1);
            }
            com.tencent.mm.audio.c.b.a.e(paramAnonymousInt, paramAnonymousArrayOfByte);
            if ((n.this.tQu != 2) || (n.a(n.this) == null))
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
              int i = n.a(n.this).gxC();
              n.b(n.this, (i + 24 + n.f(n.this) * 3) / 4);
              if (n.g(n.this) != 1) {
                break label422;
              }
              n.c(n.this, n.a(n.this).gxz());
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
              com.tencent.mm.plugin.voip.c.e.Logi("MicroMsg.Voip.VoipDeviceHandler", "amyfwang,first record");
              if (n.m(n.this) == null) {
                continue;
              }
              n.this.NJk.NMi.NRm = n.m(n.this).aeS();
              n.this.NJk.NMi.recordCallback(paramAnonymousArrayOfByte, paramAnonymousInt, n.f(n.this));
              n.NNg += 1;
            }
          }
          long l1 = System.currentTimeMillis();
          n.a(n.this, (int)(l1 - n.e(n.this) - n.NNg * 20));
          n.a(n.this, l1);
          continue;
          label422:
          n.b(n.this, 0);
          continue;
          label434:
          l1 = System.currentTimeMillis();
          long l2 = l1 - n.l(n.this);
          if (l2 > 1000L) {
            com.tencent.mm.plugin.voip.c.e.Logi("MicroMsg.Voip.VoipDeviceHandler", "amyfwang,error,record deltaTime:".concat(String.valueOf(l2)));
          }
          n.c(n.this, l1);
        }
      }
    };
    this.NJk = paraml;
    if ((this.NNc == null) || (this.NNc.isQuit())) {
      this.NNc = new MMHandler("VoipDeviceHandler_stopDev");
    }
    AppMethodBeat.o(114946);
  }
  
  private void gze()
  {
    AppMethodBeat.i(114951);
    Log.i("MicroMsg.Voip.VoipDeviceHandler", "steve: StopHWEnc!!!");
    this.NJk.NMi.tSw = false;
    this.NMX = false;
    this.NMY = false;
    AppMethodBeat.o(114951);
  }
  
  public final int b(ByteBuffer paramByteBuffer, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5)
  {
    AppMethodBeat.i(245152);
    if (this.tQu != 2)
    {
      AppMethodBeat.o(245152);
      return 0;
    }
    if (!this.NJk.gyN())
    {
      AppMethodBeat.o(245152);
      return 0;
    }
    if ((paramInt3 == 1) || (paramInt4 == 1))
    {
      AppMethodBeat.o(245152);
      return 0;
    }
    Object localObject = this.NJk.NMi;
    ((v2protocal)localObject).NSs += 1;
    if (this.NMY)
    {
      gze();
      if (this.NJk.NMv) {
        this.NJk.akR(1);
      }
      this.NJk.c(8, true, false, true);
      localObject = t.NPb;
      t.gzW();
    }
    boolean bool2 = this.NMX;
    boolean bool1;
    label300:
    label325:
    int i;
    if ((this.NJk.NMi.tSw) && (this.NJk.NMi.NSL != null))
    {
      this.NJk.NMi.NSL.DoQosSvrCtrl();
      bool1 = this.NJk.NMi.NSL.ENCODING.equalsIgnoreCase("video/avc");
      if ((this.NJk.NMi.NSL.ENCODING.equalsIgnoreCase("video/hevc")) || ((bool1) && (1 == (this.NJk.NMi.NSL.NJZ.cRsvd1 & 0x1)) && (this.NJk.NMi.NSL.NJZ.cResolution >= 6)))
      {
        this.NMX = true;
        if (this.NJk.NMi.NSL != null)
        {
          localObject = com.tencent.mm.plugin.voip.c.c.NXF;
          if (this.NMX) {
            break label572;
          }
          bool1 = true;
          com.tencent.mm.plugin.voip.c.c.Bj(bool1);
        }
        if ((!bool2) || (this.NMX)) {
          break label578;
        }
        localObject = t.NPb;
        t.gzW();
        l = System.currentTimeMillis();
        Log.d("MicroMsg.Voip.VoipDeviceHandler", "steve: put video capture in, time:" + l + ", len:" + paramInt1 + ", cnt:" + this.NJk.NMi.NSs + ", mIsHWEncEnable:" + this.NJk.NMi.tSw + ", mIsHWEncUsing:" + this.NMX);
        i = 0;
        if ((!this.NMX) || (this.NJk.NMi.NSL == null)) {
          break label735;
        }
        if (1 != this.NMZ >> 8)
        {
          this.NMZ |= 0x100;
          this.NJk.NMj.setHWDecMode(this.NMZ);
        }
        paramInt1 = i;
        if (this.NJk.NMi.NSL != null)
        {
          l = Util.currentTicks();
          if (paramInt5 != 1) {
            break label614;
          }
          paramInt1 = this.NJk.NMi.NSL.a(paramByteBuffer, paramInt3, paramInt4, paramInt2, false);
          label524:
          paramByteBuffer = j.OeL;
          j.ba(2, Util.ticksToNow(l));
          this.NNi = null;
          if (paramInt1 < 0) {
            break label649;
          }
        }
      }
    }
    for (paramInt1 = 1;; paramInt1 = i)
    {
      AppMethodBeat.o(245152);
      return paramInt1;
      this.NMX = false;
      break;
      this.NMX = false;
      break;
      label572:
      bool1 = false;
      break label300;
      label578:
      if ((bool2) || (!this.NMX) || (this.NJk.NMi.NSL == null)) {
        break label325;
      }
      localObject = t.NPb;
      t.gzV();
      break label325;
      label614:
      if (paramInt5 == 2)
      {
        paramInt1 = 0;
        break label524;
      }
      paramInt1 = this.NJk.NMi.NSL.a(paramByteBuffer, paramInt3, paramInt4, paramInt2, true);
      break label524;
      label649:
      Log.i("MicroMsg.Voip.VoipDeviceHandler", "StopHWEnc!! hw encoder error: " + paramInt1 + "old:" + this.NJk.NMv);
      if (this.NJk.NMv) {
        this.NJk.akR(1);
      }
      gze();
      paramByteBuffer = t.NPb;
      t.gzW();
      this.NJk.c(8, true, false, true);
    }
    label735:
    if (this.NMZ >> 8 != 0)
    {
      this.NMZ &= 0xFFFFFEFF;
      this.NJk.NMj.setHWDecMode(this.NMZ);
    }
    long l = Util.currentTicks();
    if (paramInt5 == 2)
    {
      if ((this.NNi == null) || (this.NNi.capacity() < paramByteBuffer.capacity())) {
        this.NNi = ByteBuffer.allocateDirect(paramByteBuffer.capacity());
      }
      this.NNi.clear();
      paramByteBuffer.clear();
      this.NNi.put(paramByteBuffer).rewind();
      paramByteBuffer = this.NNi;
    }
    for (;;)
    {
      if (paramByteBuffer != null) {}
      for (paramInt1 = this.NJk.NMi.videoEncodeToSend2(paramByteBuffer, paramInt1, paramInt3, paramInt4, paramInt2);; paramInt1 = 0)
      {
        paramByteBuffer = j.OeL;
        j.ba(1, Util.ticksToNow(l));
        break;
      }
    }
  }
  
  public final int b(byte[] paramArrayOfByte, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    AppMethodBeat.i(114952);
    if (this.tQu != 2)
    {
      AppMethodBeat.o(114952);
      return 0;
    }
    if (!this.NJk.gyN())
    {
      AppMethodBeat.o(114952);
      return 0;
    }
    if (paramArrayOfByte.length < paramInt3 * paramInt4 * 3 / 2) {
      Log.e("MicroMsg.Voip.VoipDeviceHandler", "buffer length = %d, w = %d, h = %d\n", new Object[] { Integer.valueOf(paramArrayOfByte.length), Integer.valueOf(paramInt3), Integer.valueOf(paramInt4) });
    }
    Object localObject = this.NJk.NMi;
    ((v2protocal)localObject).NSs += 1;
    if (this.NMY)
    {
      gze();
      if (this.NJk.NMv) {
        this.NJk.akR(1);
      }
      this.NJk.c(8, true, false, true);
      localObject = t.NPb;
      t.gzW();
    }
    boolean bool1 = this.NMX;
    label322:
    long l1;
    int i;
    long l2;
    if ((this.NJk.NMi.tSw) && (this.NJk.NMi.NSL != null))
    {
      this.NJk.NMi.NSL.DoQosSvrCtrl();
      boolean bool2 = this.NJk.NMi.NSL.ENCODING.equalsIgnoreCase("video/avc");
      if ((this.NJk.NMi.NSL.ENCODING.equalsIgnoreCase("video/hevc")) || ((bool2) && (1 == (this.NJk.NMi.NSL.NJZ.cRsvd1 & 0x1)) && (this.NJk.NMi.NSL.NJZ.cResolution >= 6)))
      {
        this.NMX = true;
        if ((!bool1) || (this.NMX)) {
          break label595;
        }
        localObject = t.NPb;
        t.gzW();
        l1 = System.currentTimeMillis();
        Log.d("MicroMsg.Voip.VoipDeviceHandler", "steve: put video capture in, time:" + l1 + ", len:" + paramInt1 + ", cnt:" + this.NJk.NMi.NSs + ", mIsHWEncEnable:" + this.NJk.NMi.tSw + ", mIsHWEncUsing:" + this.NMX);
        i = 0;
        if ((!this.NMX) || (this.NJk.NMi.NSL == null)) {
          break label733;
        }
        if (1 != this.NMZ >> 8)
        {
          this.NMZ |= 0x100;
          this.NJk.NMj.setHWDecMode(this.NMZ);
        }
        paramInt1 = i;
        if (this.NJk.NMi.NSL != null)
        {
          if ((this.NJk.NMi.NSL.NJZ.cSkipFlag != 0) && (this.NNe <= 10)) {
            break label717;
          }
          this.NNe = 0;
          l1 = System.currentTimeMillis();
          paramInt1 = this.NJk.NMi.NSL.b(paramArrayOfByte, paramInt3, paramInt4, paramInt2);
          l2 = System.currentTimeMillis();
          paramArrayOfByte = j.OeL;
          j.ba(2, l2 - l1);
          if (paramInt1 < 0) {
            break label631;
          }
          paramInt1 = 1;
        }
      }
    }
    for (;;)
    {
      AppMethodBeat.o(114952);
      return paramInt1;
      this.NMX = false;
      break;
      this.NMX = false;
      break;
      label595:
      if ((bool1) || (!this.NMX) || (this.NJk.NMi.NSL == null)) {
        break label322;
      }
      localObject = t.NPb;
      t.gzV();
      break label322;
      label631:
      Log.i("MicroMsg.Voip.VoipDeviceHandler", "StopHWEnc!! hw encoder error: " + paramInt1 + "old:" + this.NJk.NMv);
      if (this.NJk.NMv) {
        this.NJk.akR(1);
      }
      gze();
      paramArrayOfByte = t.NPb;
      t.gzW();
      this.NJk.c(8, true, false, true);
      paramInt1 = i;
      continue;
      label717:
      this.NNe += 1;
      paramInt1 = i;
      continue;
      label733:
      if (this.NMZ >> 8 != 0)
      {
        this.NMZ &= 0xFFFFFEFF;
        this.NJk.NMj.setHWDecMode(this.NMZ);
      }
      l1 = System.currentTimeMillis();
      paramInt1 = this.NJk.NMi.videoEncodeToSend(paramArrayOfByte, paramInt1, paramInt3, paramInt4, paramInt2);
      l2 = System.currentTimeMillis();
      paramArrayOfByte = j.OeL;
      j.ba(1, l2 - l1);
    }
  }
  
  public final int gxE()
  {
    AppMethodBeat.i(114947);
    if ((this.NMO != null) && (this.NJk.NMi.NSI.NNA == 1))
    {
      int i = this.NMO.gxE();
      AppMethodBeat.o(114947);
      return i;
    }
    AppMethodBeat.o(114947);
    return 0;
  }
  
  public final int gzb()
  {
    if ((this.tQq != null) && (this.NJk.NMi.NSI.NNA == 1)) {
      return this.tQq.frO;
    }
    return 0;
  }
  
  public final void gzc()
  {
    int j = 0;
    for (;;)
    {
      try
      {
        AppMethodBeat.i(114948);
        Log.i("MicroMsg.Voip.VoipDeviceHandler", "stopDev, recorder: %s", new Object[] { this.tQq });
        if (this.tQu == tQt)
        {
          com.tencent.mm.plugin.voip.c.e.Loge("MicroMsg.Voip.VoipDeviceHandler", "devcie stoped already.");
          gzd();
          AppMethodBeat.o(114948);
          return;
        }
        com.tencent.mm.plugin.voip.c.e.Logi("MicroMsg.Voip.VoipDeviceHandler", "stop device..");
        this.tQu = tQt;
        if (this.NNh != null)
        {
          com.tencent.mm.plugin.voip.c.e.Logd("MicroMsg.Voip.VoipDeviceHandler", "stop videodecode thread..");
          this.NNh.NNl = true;
          this.NNh.cancel();
          this.NNh = null;
        }
        this.tQw = 1;
        this.NMU = 0;
        this.tQA = 1;
        this.NNa = 1;
        this.tQB = 0L;
        this.NNb = 0L;
        this.tQv = 92;
        this.NMP = 0L;
        this.NMQ = 0L;
        this.NMR = 1;
        this.NMS = 0;
        this.tQy = 0;
        this.NJk.NMi.NQY = gzb();
        this.NJk.NMi.NQZ = gxE();
        v2protocal localv2protocal = this.NJk.NMi;
        if ((this.tQq != null) && (this.NJk.NMi.NSI.NNA == 1))
        {
          i = this.tQq.aeX();
          localv2protocal.NRc = i;
          localv2protocal = this.NJk.NMi;
          if ((this.NMO == null) || (this.NJk.NMi.NSI.NNA != 1)) {
            break label419;
          }
          c localc = this.NMO;
          Log.d("MicroMsg.Voip.AudioPlayer", "AudioPlayer  mAudioPlayNum:" + localc.NJR);
          i = localc.NJR;
          localv2protocal.NRd = i;
          localv2protocal = this.NJk.NMi;
          i = j;
          if (this.NMO != null)
          {
            i = j;
            if (this.NJk.NMi.NSI.NNA == 1) {
              i = this.NMO.gxF();
            }
          }
          float f = com.tencent.mm.plugin.audio.c.a.getStreamMaxVolume(i);
          localv2protocal.NRk = ((int)(com.tencent.mm.plugin.audio.c.a.getStreamVolume(i) / f * 100.0F));
          gzd();
          AppMethodBeat.o(114948);
          continue;
        }
        i = -2;
      }
      finally {}
      continue;
      label419:
      int i = 0;
    }
  }
  
  public final void gzd()
  {
    AppMethodBeat.i(114949);
    Log.printInfoStack("MicroMsg.Voip.VoipDeviceHandler", "forceCleanRecord, recorder %s", new Object[] { this.tQq });
    if (this.NNc != null) {
      synchronized (this.NMW)
      {
        if ((this.NMO != null) || (this.tQq != null))
        {
          Log.i("MicroMsg.Voip.VoipDeviceHandler", "forceCleanRecord process post runnable");
          if (this.NNc != null)
          {
            this.NNc.removeCallbacksAndMessages(null);
            this.NNc.post(new Runnable()
            {
              public final void run()
              {
                AppMethodBeat.i(114944);
                Log.i("MicroMsg.Voip.VoipDeviceHandler", "forceCleanRecord process post success and wait running");
                if (n.a(n.this) != null)
                {
                  n.a(n.this).gxD();
                  n.a(n.this).gxA();
                  n.s(n.this);
                  Log.i("MicroMsg.Voip.VoipDeviceHandler", "finish stopRecord and release player");
                }
                Log.i("MicroMsg.Voip.VoipDeviceHandler", "do stopRecord");
                if (n.m(n.this) != null)
                {
                  n.m(n.this).aeJ();
                  n.t(n.this);
                  Log.i("MicroMsg.Voip.VoipDeviceHandler", "finish stopRecord and release recorder");
                }
                Log.i("MicroMsg.Voip.VoipDeviceHandler", "forceCleanRecord process post success and quitSafely");
                AppMethodBeat.o(114944);
              }
            });
          }
        }
        AppMethodBeat.o(114949);
        return;
      }
    }
    Log.i("MicroMsg.Voip.VoipDeviceHandler", "forceCleanRecord failed but mDevHandler is null");
    AppMethodBeat.o(114949);
  }
  
  final class a
    extends com.tencent.e.i.b
  {
    boolean NNk = false;
    boolean NNl = false;
    byte[] NNm = null;
    ByteBuffer NNn = null;
    int NNo = 0;
    int NNp = 0;
    
    a() {}
    
    public final String getKey()
    {
      return "stop_video_decode_runnable";
    }
    
    public final void run()
    {
      AppMethodBeat.i(114945);
      if ((n.this.tQu == 2) && (!this.NNl))
      {
        long l1 = System.currentTimeMillis();
        int i;
        int j;
        int k;
        int n;
        boolean bool1;
        label291:
        boolean bool2;
        Object localObject1;
        if (n.this.NJk.gyO())
        {
          if (this.NNn == null)
          {
            this.NNn = ByteBuffer.allocateDirect((n.this.NJk.NMi.defaultWidth + 64) * (n.this.NJk.NMi.defaultHeight + 64) * 4).order(ByteOrder.nativeOrder());
            this.NNn.position(0);
            this.NNm = new byte[this.NNn.remaining()];
            Log.i("MicroMsg.Voip.VoipDeviceHandler.VideoRunnable", "init remoteImageByteBuffer, defaultWidth:%s, defaultHeight:%s", new Object[] { Integer.valueOf(n.this.NJk.NMi.defaultWidth), Integer.valueOf(n.this.NJk.NMi.defaultHeight) });
          }
          i = 0;
          if (this.NNn != null)
          {
            this.NNn.clear();
            i = n.this.NJk.NMi.videoDecodeBB(this.NNn);
          }
          if (i == 1)
          {
            this.NNo += 1;
            j = n.this.NJk.NMi.field_remoteImgWidth;
            k = n.this.NJk.NMi.field_remoteImgHeight;
            n = n.this.NJk.NMi.field_remoteImgOrien;
            i = 0;
            if (this.NNp != n)
            {
              i = 1;
              this.NNp = n;
            }
            if ((j != 0) || (k >= 3)) {
              break label619;
            }
            bool1 = true;
            if (this.NNo % 200 == 10) {
              Log.i("MicroMsg.Voip.VoipDeviceHandler.VideoRunnable", "steve: dec statistics: total:%d, soft:%d, size:%dx%d, HW:%b", new Object[] { Integer.valueOf(this.NNo), Integer.valueOf(n.this.NJk.NMi.NSw), Integer.valueOf(j), Integer.valueOf(k), Boolean.valueOf(bool1) });
            }
            bool2 = false;
            if (!bool1) {
              break label665;
            }
            if (!this.NNk)
            {
              localObject1 = n.this;
              ((n)localObject1).NMZ |= 0x1;
              n.this.NJk.NMj.setHWDecMode(n.this.NMZ);
              bool2 = true;
              Log.i("MicroMsg.Voip.VoipDeviceHandler.VideoRunnable", "steve: change to HW dec, restart decoder!");
              localObject1 = t.NPb;
              t.gzT();
            }
            if (v2protocal.NSM == null) {}
          }
        }
        label665:
        label1333:
        for (;;)
        {
          for (;;)
          {
            try
            {
              j = n.this.NJk.NMi.field_remoteImgLength;
              Log.d("MicroMsg.Voip.VoipDeviceHandler.VideoRunnable", "steve:video decode successfully!..len=".concat(String.valueOf(j)));
              k = n.this.NJk.NMi.field_remoteImgHeight;
              localObject1 = new byte[j];
              System.arraycopy(this.NNn.array(), this.NNn.arrayOffset(), localObject1, 0, j);
              v2protocal.NSM.f((byte[])localObject1, k, bool2);
              long l2 = System.currentTimeMillis();
              Log.d("MicroMsg.Voip.VoipDeviceHandler.VideoRunnable", "steve: fill in AvcDecoder take time = " + (l2 - l1) + ", startTime = " + l1);
              if (i != 0) {
                n.this.NJk.NMj.akB(n);
              }
            }
            catch (Exception localException)
            {
              Log.e("EncodeDecode", "interrupted while waiting");
              Log.e("MicroMsg.Voip.VoipDeviceHandler.VideoRunnable", " error:" + localException.toString());
              continue;
            }
            this.NNk = bool1;
            try
            {
              Thread.sleep(10L);
            }
            catch (InterruptedException localInterruptedException)
            {
              Log.printErrStackTrace("MicroMsg.Voip.VoipDeviceHandler.VideoRunnable", localInterruptedException, "", new Object[0]);
            }
          }
          break;
          label619:
          bool1 = false;
          break label291;
          Object localObject2;
          if (this.NNk)
          {
            localObject2 = n.this;
            ((n)localObject2).NMZ &= 0xFFFFFFFE;
            if (v2protocal.NSM != null) {
              v2protocal.NSM.FqN = false;
            }
            n.this.NJk.NMj.setHWDecMode(n.this.NMZ);
            Log.i("MicroMsg.Voip.VoipDeviceHandler.VideoRunnable", "steve: change to SW dec");
            localObject2 = t.NPb;
            t.gzU();
          }
          int m = n.this.NJk.NMi.field_remoteImgLength;
          if ((m > 0) && (n.this.NJk.NMj != null))
          {
            localObject2 = n.this.NJk.NMi;
            ((v2protocal)localObject2).NSw += 1;
            int i1 = j * k * 3 / 2;
            System.arraycopy(this.NNn.array(), this.NNn.arrayOffset(), this.NNm, 0, i1);
            n.this.NJk.NMj.e(j, k, this.NNm);
            int i2;
            int i3;
            int i4;
            int i5;
            if (n.this.NJk.NMi.NSw % 100 == 0)
            {
              localObject2 = new byte[5];
              i1 = j * 33 + 33;
              i2 = j * 34 - 34;
              i3 = j * k / 2 + j / 2;
              i4 = (k - 34) * j + 33;
              i5 = (k - 34) * j + j - 34;
              if ((this.NNm == null) || (i5 >= this.NNm.length)) {
                break label1252;
              }
              localObject2[0] = this.NNm[i1];
              localObject2[1] = this.NNm[i2];
              localObject2[2] = this.NNm[i3];
              localObject2[3] = this.NNm[i4];
              localObject2[4] = this.NNm[i5];
              Log.i("MicroMsg.Voip.VoipDeviceHandler.VideoRunnable", "steve: SW dec to render: cnt:%d, size:%dx%d, outlen:%d, samples:%d,%d,%d,%d,%d", new Object[] { Integer.valueOf(n.this.NJk.NMi.NSw), Integer.valueOf(j), Integer.valueOf(k), Integer.valueOf(m), Byte.valueOf(localObject2[0]), Byte.valueOf(localObject2[1]), Byte.valueOf(localObject2[2]), Byte.valueOf(localObject2[3]), Byte.valueOf(localObject2[4]) });
              Log.i("MicroMsg.Voip.VoipDeviceHandler.VideoRunnable", "steve: first 5 samples:%d,%d,%d,%d,%d", new Object[] { Byte.valueOf(this.NNm[0]), Byte.valueOf(this.NNm[1]), Byte.valueOf(this.NNm[2]), Byte.valueOf(this.NNm[3]), Byte.valueOf(this.NNm[4]) });
              k = 0;
              j = 0;
              while (j < 5)
              {
                m = k;
                if (localObject2[j] == 0) {
                  m = k + 1;
                }
                j += 1;
                k = m;
              }
              if (k >= 5)
              {
                localObject2 = t.NPb;
                t.gAb();
              }
            }
            for (;;)
            {
              if (i == 0) {
                break label1333;
              }
              n.this.NJk.NMj.akB(n);
              break;
              label1252:
              Log.i("MicroMsg.Voip.VoipDeviceHandler.VideoRunnable", "steve: dec null pointer or out of memory! size:%dx%d, idx:%d,%d,%d,%d,%d, len:%d ", new Object[] { Integer.valueOf(j), Integer.valueOf(k), Integer.valueOf(i1), Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), Integer.valueOf(i5), Integer.valueOf(this.NNm.length) });
            }
          }
        }
      }
      AppMethodBeat.o(114945);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.voip.model.n
 * JD-Core Version:    0.7.0.1
 */