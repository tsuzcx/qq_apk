package com.tencent.mm.plugin.voip.model;

import android.media.AudioManager;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.audio.b.c.a;
import com.tencent.mm.compatible.util.f;
import com.tencent.mm.plugin.voip.video.render.i;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandler;
import com.tencent.mm.sdk.platformtools.Util;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;

public final class n
{
  public static int GTO = 60;
  public static int GWS;
  public static int GWT;
  public static int qrK = 3;
  l GSZ;
  volatile c GWB;
  private long GWC;
  private long GWD;
  private int GWE;
  private int GWF;
  private long GWG;
  private int GWH;
  private int GWI;
  final Object GWJ;
  public boolean GWK;
  public boolean GWL;
  public int GWM;
  private int GWN;
  private long GWO;
  public MMHandler GWP;
  long GWQ;
  private int GWR;
  a GWU;
  private ByteBuffer GWV;
  volatile com.tencent.mm.audio.b.c qrH;
  public int qrL;
  int qrM;
  private int qrN;
  public int qrP;
  private int qrR;
  private long qrS;
  private c.a qrW;
  
  static
  {
    GWS = 0;
    GWT = 0;
  }
  
  public n(l paraml)
  {
    AppMethodBeat.i(114946);
    this.GWB = null;
    this.qrH = null;
    this.qrL = 1;
    this.GSZ = null;
    this.qrM = 92;
    this.GWC = 0L;
    this.GWD = 0L;
    this.GWE = 1;
    this.GWF = 0;
    this.qrN = 1;
    this.GWG = 0L;
    this.GWH = 0;
    this.GWI = 0;
    this.GWJ = new Object();
    this.qrP = 0;
    this.GWK = false;
    this.GWL = false;
    this.GWM = 0;
    this.qrR = 1;
    this.GWN = 1;
    this.qrS = 0L;
    this.GWO = 0L;
    this.GWQ = 0L;
    this.GWR = 0;
    this.qrW = new c.a()
    {
      public final void cj(int paramAnonymousInt1, int paramAnonymousInt2) {}
      
      public final void w(byte[] paramAnonymousArrayOfByte, int paramAnonymousInt)
      {
        AppMethodBeat.i(114941);
        for (;;)
        {
          synchronized (n.n(n.this))
          {
            if (com.tencent.mm.plugin.audio.c.a.cea().audioManager.isMusicActive()) {
              com.tencent.mm.audio.c.b.a.ju(1);
            }
            com.tencent.mm.audio.c.b.a.e(paramAnonymousInt, paramAnonymousArrayOfByte);
            if ((n.this.qrL != 2) || (n.a(n.this) == null))
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
              int i = n.a(n.this).fFq();
              n.b(n.this, (i + 24 + n.f(n.this) * 3) / 4);
              if (n.g(n.this) != 1) {
                break label422;
              }
              n.c(n.this, n.a(n.this).fFn());
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
              com.tencent.mm.plugin.voip.b.e.Logi("MicroMsg.Voip.VoipDeviceHandler", "amyfwang,first record");
              if (n.m(n.this) == null) {
                continue;
              }
              n.this.GSZ.GVV.Hba = n.m(n.this).aah();
              n.this.GSZ.GVV.recordCallback(paramAnonymousArrayOfByte, paramAnonymousInt, n.f(n.this));
              n.GWT += 1;
            }
          }
          long l1 = System.currentTimeMillis();
          n.a(n.this, (int)(l1 - n.e(n.this) - n.GWT * 20));
          n.a(n.this, l1);
          continue;
          label422:
          n.b(n.this, 0);
          continue;
          label434:
          l1 = System.currentTimeMillis();
          long l2 = l1 - n.l(n.this);
          if (l2 > 1000L) {
            com.tencent.mm.plugin.voip.b.e.Logi("MicroMsg.Voip.VoipDeviceHandler", "amyfwang,error,record deltaTime:".concat(String.valueOf(l2)));
          }
          n.c(n.this, l1);
        }
      }
    };
    this.GSZ = paraml;
    if ((this.GWP == null) || (this.GWP.isQuit())) {
      this.GWP = new MMHandler("VoipDeviceHandler_stopDev");
    }
    AppMethodBeat.o(114946);
  }
  
  private void fGQ()
  {
    AppMethodBeat.i(114951);
    Log.i("MicroMsg.Voip.VoipDeviceHandler", "steve: StopHWEnc!!!");
    this.GSZ.GVV.qtK = false;
    this.GWK = false;
    this.GWL = false;
    AppMethodBeat.o(114951);
  }
  
  public final int b(ByteBuffer paramByteBuffer, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5)
  {
    AppMethodBeat.i(235611);
    if (this.qrL != 2)
    {
      AppMethodBeat.o(235611);
      return 0;
    }
    if (!this.GSZ.fGz())
    {
      AppMethodBeat.o(235611);
      return 0;
    }
    Object localObject = this.GSZ.GVV;
    ((v2protocal)localObject).Hcg += 1;
    if (this.GWL)
    {
      fGQ();
      if (this.GSZ.GWi) {
        this.GSZ.adg(1);
      }
      this.GSZ.c(8, true, false, true);
      localObject = t.GYO;
      t.fHI();
    }
    boolean bool2 = this.GWK;
    boolean bool1;
    label280:
    label305:
    long l;
    if ((this.GSZ.GVV.qtK) && (this.GSZ.GVV.Hcz != null))
    {
      this.GSZ.GVV.Hcz.DoQosSvrCtrl();
      bool1 = this.GSZ.GVV.Hcz.ENCODING.equalsIgnoreCase("video/avc");
      if ((this.GSZ.GVV.Hcz.ENCODING.equalsIgnoreCase("video/hevc")) || ((bool1) && (1 == (this.GSZ.GVV.Hcz.GTN.cRsvd1 & 0x1)) && (this.GSZ.GVV.Hcz.GTN.cResolution >= 6)))
      {
        this.GWK = true;
        if (this.GSZ.GVV.Hcz != null)
        {
          localObject = com.tencent.mm.plugin.voip.b.c.HgQ;
          if (this.GWK) {
            break label546;
          }
          bool1 = true;
          com.tencent.mm.plugin.voip.b.c.xr(bool1);
        }
        if ((!bool2) || (this.GWK)) {
          break label552;
        }
        localObject = t.GYO;
        t.fHI();
        l = System.currentTimeMillis();
        Log.d("MicroMsg.Voip.VoipDeviceHandler", "steve: put video capture in, time:" + l + ", len:" + paramInt1 + ", cnt:" + this.GSZ.GVV.Hcg + ", mIsHWEncEnable:" + this.GSZ.GVV.qtK + ", mIsHWEncUsing:" + this.GWK);
        if ((!this.GWK) || (this.GSZ.GVV.Hcz == null)) {
          break label708;
        }
        if (1 != this.GWM >> 8)
        {
          this.GWM |= 0x100;
          this.GSZ.GVW.setHWDecMode(this.GWM);
        }
        if (this.GSZ.GVV.Hcz == null) {
          break label856;
        }
        l = Util.currentTicks();
        if (paramInt5 != 1) {
          break label588;
        }
        paramInt1 = this.GSZ.GVV.Hcz.a(paramByteBuffer, paramInt3, paramInt4, paramInt2, false);
        label498:
        paramByteBuffer = i.HnR;
        i.aO(2, Util.ticksToNow(l));
        this.GWV = null;
        if (paramInt1 < 0) {
          break label623;
        }
        paramInt1 = 1;
      }
    }
    for (;;)
    {
      AppMethodBeat.o(235611);
      return paramInt1;
      this.GWK = false;
      break;
      this.GWK = false;
      break;
      label546:
      bool1 = false;
      break label280;
      label552:
      if ((bool2) || (!this.GWK) || (this.GSZ.GVV.Hcz == null)) {
        break label305;
      }
      localObject = t.GYO;
      t.fHH();
      break label305;
      label588:
      if (paramInt5 == 2)
      {
        paramInt1 = 0;
        break label498;
      }
      paramInt1 = this.GSZ.GVV.Hcz.a(paramByteBuffer, paramInt3, paramInt4, paramInt2, true);
      break label498;
      label623:
      Log.i("MicroMsg.Voip.VoipDeviceHandler", "StopHWEnc!! hw encoder error: " + paramInt1 + "old:" + this.GSZ.GWi);
      if (this.GSZ.GWi) {
        this.GSZ.adg(1);
      }
      fGQ();
      paramByteBuffer = t.GYO;
      t.fHI();
      this.GSZ.c(8, true, false, true);
      paramInt1 = 0;
      continue;
      label708:
      if (this.GWM >> 8 != 0)
      {
        this.GWM &= 0xFFFFFEFF;
        this.GSZ.GVW.setHWDecMode(this.GWM);
      }
      l = Util.currentTicks();
      if (paramInt5 == 2)
      {
        if ((this.GWV == null) || (this.GWV.capacity() < paramByteBuffer.capacity())) {
          this.GWV = ByteBuffer.allocateDirect(paramByteBuffer.capacity());
        }
        this.GWV.clear();
        paramByteBuffer.clear();
        this.GWV.put(paramByteBuffer).rewind();
        paramByteBuffer = this.GWV;
      }
      for (;;)
      {
        paramInt1 = this.GSZ.GVV.videoEncodeToSend2(paramByteBuffer, paramInt1, paramInt3, paramInt4, paramInt2);
        paramByteBuffer = i.HnR;
        i.aO(1, Util.ticksToNow(l));
        break;
      }
      label856:
      paramInt1 = 0;
    }
  }
  
  public final int b(byte[] paramArrayOfByte, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    AppMethodBeat.i(114952);
    if (this.qrL != 2)
    {
      AppMethodBeat.o(114952);
      return 0;
    }
    if (!this.GSZ.fGz())
    {
      AppMethodBeat.o(114952);
      return 0;
    }
    if (paramArrayOfByte.length < paramInt3 * paramInt4 * 3 / 2) {
      Log.e("MicroMsg.Voip.VoipDeviceHandler", "buffer length = %d, w = %d, h = %d\n", new Object[] { Integer.valueOf(paramArrayOfByte.length), Integer.valueOf(paramInt3), Integer.valueOf(paramInt4) });
    }
    Object localObject = this.GSZ.GVV;
    ((v2protocal)localObject).Hcg += 1;
    if (this.GWL)
    {
      fGQ();
      if (this.GSZ.GWi) {
        this.GSZ.adg(1);
      }
      this.GSZ.c(8, true, false, true);
      localObject = t.GYO;
      t.fHI();
    }
    boolean bool1 = this.GWK;
    label322:
    long l1;
    int i;
    long l2;
    if ((this.GSZ.GVV.qtK) && (this.GSZ.GVV.Hcz != null))
    {
      this.GSZ.GVV.Hcz.DoQosSvrCtrl();
      boolean bool2 = this.GSZ.GVV.Hcz.ENCODING.equalsIgnoreCase("video/avc");
      if ((this.GSZ.GVV.Hcz.ENCODING.equalsIgnoreCase("video/hevc")) || ((bool2) && (1 == (this.GSZ.GVV.Hcz.GTN.cRsvd1 & 0x1)) && (this.GSZ.GVV.Hcz.GTN.cResolution >= 6)))
      {
        this.GWK = true;
        if ((!bool1) || (this.GWK)) {
          break label595;
        }
        localObject = t.GYO;
        t.fHI();
        l1 = System.currentTimeMillis();
        Log.d("MicroMsg.Voip.VoipDeviceHandler", "steve: put video capture in, time:" + l1 + ", len:" + paramInt1 + ", cnt:" + this.GSZ.GVV.Hcg + ", mIsHWEncEnable:" + this.GSZ.GVV.qtK + ", mIsHWEncUsing:" + this.GWK);
        i = 0;
        if ((!this.GWK) || (this.GSZ.GVV.Hcz == null)) {
          break label733;
        }
        if (1 != this.GWM >> 8)
        {
          this.GWM |= 0x100;
          this.GSZ.GVW.setHWDecMode(this.GWM);
        }
        paramInt1 = i;
        if (this.GSZ.GVV.Hcz != null)
        {
          if ((this.GSZ.GVV.Hcz.GTN.cSkipFlag != 0) && (this.GWR <= 10)) {
            break label717;
          }
          this.GWR = 0;
          l1 = System.currentTimeMillis();
          paramInt1 = this.GSZ.GVV.Hcz.b(paramArrayOfByte, paramInt3, paramInt4, paramInt2);
          l2 = System.currentTimeMillis();
          paramArrayOfByte = i.HnR;
          i.aO(2, l2 - l1);
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
      this.GWK = false;
      break;
      this.GWK = false;
      break;
      label595:
      if ((bool1) || (!this.GWK) || (this.GSZ.GVV.Hcz == null)) {
        break label322;
      }
      localObject = t.GYO;
      t.fHH();
      break label322;
      label631:
      Log.i("MicroMsg.Voip.VoipDeviceHandler", "StopHWEnc!! hw encoder error: " + paramInt1 + "old:" + this.GSZ.GWi);
      if (this.GSZ.GWi) {
        this.GSZ.adg(1);
      }
      fGQ();
      paramArrayOfByte = t.GYO;
      t.fHI();
      this.GSZ.c(8, true, false, true);
      paramInt1 = i;
      continue;
      label717:
      this.GWR += 1;
      paramInt1 = i;
      continue;
      label733:
      if (this.GWM >> 8 != 0)
      {
        this.GWM &= 0xFFFFFEFF;
        this.GSZ.GVW.setHWDecMode(this.GWM);
      }
      l1 = System.currentTimeMillis();
      paramInt1 = this.GSZ.GVV.videoEncodeToSend(paramArrayOfByte, paramInt1, paramInt3, paramInt4, paramInt2);
      l2 = System.currentTimeMillis();
      paramArrayOfByte = i.HnR;
      i.aO(1, l2 - l1);
    }
  }
  
  public final int fFs()
  {
    AppMethodBeat.i(114947);
    if ((this.GWB != null) && (this.GSZ.GVV.Hcw.GXm == 1))
    {
      int i = this.GWB.fFs();
      AppMethodBeat.o(114947);
      return i;
    }
    AppMethodBeat.o(114947);
    return 0;
  }
  
  public final int fGN()
  {
    if ((this.qrH != null) && (this.GSZ.GVV.Hcw.GXm == 1)) {
      return this.qrH.dyZ;
    }
    return 0;
  }
  
  public final void fGO()
  {
    int j = 0;
    for (;;)
    {
      try
      {
        AppMethodBeat.i(114948);
        Log.i("MicroMsg.Voip.VoipDeviceHandler", "stopDev, recorder: %s", new Object[] { this.qrH });
        if (this.qrL == qrK)
        {
          com.tencent.mm.plugin.voip.b.e.Loge("MicroMsg.Voip.VoipDeviceHandler", "devcie stoped already.");
          fGP();
          AppMethodBeat.o(114948);
          return;
        }
        com.tencent.mm.plugin.voip.b.e.Logi("MicroMsg.Voip.VoipDeviceHandler", "stop device..");
        this.qrL = qrK;
        if (this.GWU != null)
        {
          com.tencent.mm.plugin.voip.b.e.Logd("MicroMsg.Voip.VoipDeviceHandler", "stop videodecode thread..");
          this.GWU.GWY = true;
          this.GWU.cancel();
          this.GWU = null;
        }
        this.qrN = 1;
        this.GWH = 0;
        this.qrR = 1;
        this.GWN = 1;
        this.qrS = 0L;
        this.GWO = 0L;
        this.qrM = 92;
        this.GWC = 0L;
        this.GWD = 0L;
        this.GWE = 1;
        this.GWF = 0;
        this.qrP = 0;
        this.GSZ.GVV.HaM = fGN();
        this.GSZ.GVV.HaN = fFs();
        v2protocal localv2protocal = this.GSZ.GVV;
        if ((this.qrH != null) && (this.GSZ.GVV.Hcw.GXm == 1))
        {
          i = this.qrH.aal();
          localv2protocal.HaQ = i;
          localv2protocal = this.GSZ.GVV;
          if ((this.GWB == null) || (this.GSZ.GVV.Hcw.GXm != 1)) {
            break label419;
          }
          c localc = this.GWB;
          Log.d("MicroMsg.Voip.AudioPlayer", "AudioPlayer  mAudioPlayNum:" + localc.GTF);
          i = localc.GTF;
          localv2protocal.HaR = i;
          localv2protocal = this.GSZ.GVV;
          i = j;
          if (this.GWB != null)
          {
            i = j;
            if (this.GSZ.GVV.Hcw.GXm == 1) {
              i = this.GWB.bhV();
            }
          }
          float f = com.tencent.mm.plugin.audio.c.a.getStreamMaxVolume(i);
          localv2protocal.HaY = ((int)(com.tencent.mm.plugin.audio.c.a.getStreamVolume(i) / f * 100.0F));
          fGP();
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
  
  public final void fGP()
  {
    AppMethodBeat.i(114949);
    Log.printInfoStack("MicroMsg.Voip.VoipDeviceHandler", "forceCleanRecord, recorder %s", new Object[] { this.qrH });
    if (this.GWP != null) {
      synchronized (this.GWJ)
      {
        if ((this.GWB != null) || (this.qrH != null))
        {
          Log.i("MicroMsg.Voip.VoipDeviceHandler", "forceCleanRecord process post runnable");
          if (this.GWP != null)
          {
            this.GWP.removeCallbacksAndMessages(null);
            this.GWP.post(new Runnable()
            {
              public final void run()
              {
                AppMethodBeat.i(114944);
                Log.i("MicroMsg.Voip.VoipDeviceHandler", "forceCleanRecord process post success and wait running");
                if (n.a(n.this) != null)
                {
                  n.a(n.this).fFr();
                  n.a(n.this).fFo();
                  n.s(n.this);
                  Log.i("MicroMsg.Voip.VoipDeviceHandler", "finish stopRecord and release player");
                }
                Log.i("MicroMsg.Voip.VoipDeviceHandler", "do stopRecord");
                if (n.m(n.this) != null)
                {
                  n.m(n.this).ZZ();
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
    extends com.tencent.f.i.b
  {
    boolean GWX = false;
    boolean GWY = false;
    byte[] GWZ = null;
    ByteBuffer GXa = null;
    int GXb = 0;
    
    a() {}
    
    public final String getKey()
    {
      return "stop_video_decode_runnable";
    }
    
    public final void run()
    {
      AppMethodBeat.i(114945);
      if ((n.this.qrL == 2) && (!this.GWY))
      {
        long l1 = System.currentTimeMillis();
        int i;
        int j;
        boolean bool1;
        boolean bool2;
        Object localObject1;
        if (n.this.GSZ.fGA())
        {
          if (this.GXa == null)
          {
            this.GXa = ByteBuffer.allocateDirect((n.this.GSZ.GVV.defaultWidth + 64) * (n.this.GSZ.GVV.defaultHeight + 64) * 4).order(ByteOrder.nativeOrder());
            this.GXa.position(0);
            this.GWZ = new byte[this.GXa.remaining()];
            Log.i("MicroMsg.Voip.VoipDeviceHandler", "init remoteImageByteBuffer, defaultWidth:%s, defaultHeight:%s", new Object[] { Integer.valueOf(n.this.GSZ.GVV.defaultWidth), Integer.valueOf(n.this.GSZ.GVV.defaultHeight) });
          }
          i = 0;
          if (this.GXa != null)
          {
            this.GXa.clear();
            i = n.this.GSZ.GVV.videoDecodeBB(this.GXa);
          }
          if (i == 1)
          {
            this.GXb += 1;
            i = n.this.GSZ.GVV.field_remoteImgWidth;
            j = n.this.GSZ.GVV.field_remoteImgHeight;
            if ((i != 0) || (j >= 3)) {
              break label564;
            }
            bool1 = true;
            if (this.GXb % 200 == 10) {
              Log.i("MicroMsg.Voip.VoipDeviceHandler", "steve: dec statistics: total:%d, soft:%d, size:%dx%d, HW:%b", new Object[] { Integer.valueOf(this.GXb), Integer.valueOf(n.this.GSZ.GVV.Hck), Integer.valueOf(i), Integer.valueOf(j), Boolean.valueOf(bool1) });
            }
            bool2 = false;
            if (!bool1) {
              break label607;
            }
            if (!this.GWX)
            {
              localObject1 = n.this;
              ((n)localObject1).GWM |= 0x1;
              n.this.GSZ.GVW.setHWDecMode(n.this.GWM);
              bool2 = true;
              Log.i("MicroMsg.Voip.VoipDeviceHandler", "steve: change to HW dec, restart decoder!");
              localObject1 = t.GYO;
              t.fHF();
            }
            if (v2protocal.HcA == null) {}
          }
        }
        for (;;)
        {
          try
          {
            for (;;)
            {
              i = n.this.GSZ.GVV.field_remoteImgLength;
              Log.d("MicroMsg.Voip.VoipDeviceHandler", "steve:video decode successfully!..len=".concat(String.valueOf(i)));
              j = n.this.GSZ.GVV.field_remoteImgHeight;
              localObject1 = new byte[i];
              System.arraycopy(this.GXa.array(), this.GXa.arrayOffset(), localObject1, 0, i);
              v2protocal.HcA.f((byte[])localObject1, j, bool2);
              long l2 = System.currentTimeMillis();
              Log.d("MicroMsg.Voip.VoipDeviceHandler", "steve: fill in AvcDecoder take time = " + (l2 - l1) + ", startTime = " + l1);
              this.GWX = bool1;
              try
              {
                Thread.sleep(10L);
              }
              catch (InterruptedException localInterruptedException)
              {
                Log.printErrStackTrace("MicroMsg.Voip.VoipDeviceHandler", localInterruptedException, "", new Object[0]);
              }
            }
            break;
            label564:
            bool1 = false;
          }
          catch (Exception localException)
          {
            Log.e("EncodeDecode", "interrupted while waiting");
            Log.e("MicroMsg.Voip.VoipDeviceHandler", " error:" + localException.toString());
            continue;
          }
          label607:
          Object localObject2;
          if (this.GWX)
          {
            localObject2 = n.this;
            ((n)localObject2).GWM &= 0xFFFFFFFE;
            if (v2protocal.HcA != null) {
              v2protocal.HcA.zLw = false;
            }
            n.this.GSZ.GVW.setHWDecMode(n.this.GWM);
            Log.i("MicroMsg.Voip.VoipDeviceHandler", "steve: change to SW dec");
            localObject2 = t.GYO;
            t.fHG();
          }
          int k = n.this.GSZ.GVV.field_remoteImgLength;
          if ((k > 0) && (n.this.GSZ.GVW != null))
          {
            localObject2 = n.this.GSZ.GVV;
            ((v2protocal)localObject2).Hck += 1;
            int m = i * j * 3 / 2;
            System.arraycopy(this.GXa.array(), this.GXa.arrayOffset(), this.GWZ, 0, m);
            n.this.GSZ.GVW.e(i, j, this.GWZ);
            if (n.this.GSZ.GVV.Hck % 100 == 0)
            {
              localObject2 = new byte[5];
              m = i * 33 + 33;
              int n = i * 34 - 34;
              int i1 = i * j / 2 + i / 2;
              int i2 = (j - 34) * i + 33;
              int i3 = (j - 34) * i + i - 34;
              if ((this.GWZ != null) && (i3 < this.GWZ.length))
              {
                localObject2[0] = this.GWZ[m];
                localObject2[1] = this.GWZ[n];
                localObject2[2] = this.GWZ[i1];
                localObject2[3] = this.GWZ[i2];
                localObject2[4] = this.GWZ[i3];
                Log.i("MicroMsg.Voip.VoipDeviceHandler", "steve: SW dec to render: cnt:%d, size:%dx%d, outlen:%d, samples:%d,%d,%d,%d,%d", new Object[] { Integer.valueOf(n.this.GSZ.GVV.Hck), Integer.valueOf(i), Integer.valueOf(j), Integer.valueOf(k), Byte.valueOf(localObject2[0]), Byte.valueOf(localObject2[1]), Byte.valueOf(localObject2[2]), Byte.valueOf(localObject2[3]), Byte.valueOf(localObject2[4]) });
                Log.i("MicroMsg.Voip.VoipDeviceHandler", "steve: first 5 samples:%d,%d,%d,%d,%d", new Object[] { Byte.valueOf(this.GWZ[0]), Byte.valueOf(this.GWZ[1]), Byte.valueOf(this.GWZ[2]), Byte.valueOf(this.GWZ[3]), Byte.valueOf(this.GWZ[4]) });
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
                  localObject2 = t.GYO;
                  t.fHN();
                }
              }
              else
              {
                Log.i("MicroMsg.Voip.VoipDeviceHandler", "steve: dec null pointer or out of memory! size:%dx%d, idx:%d,%d,%d,%d,%d, len:%d ", new Object[] { Integer.valueOf(i), Integer.valueOf(j), Integer.valueOf(m), Integer.valueOf(n), Integer.valueOf(i1), Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(this.GWZ.length) });
              }
            }
          }
        }
      }
      AppMethodBeat.o(114945);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.voip.model.n
 * JD-Core Version:    0.7.0.1
 */