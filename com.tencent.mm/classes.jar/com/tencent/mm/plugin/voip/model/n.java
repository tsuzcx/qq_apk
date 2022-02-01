package com.tencent.mm.plugin.voip.model;

import android.media.AudioManager;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.audio.b.c.a;
import com.tencent.mm.compatible.util.f;
import com.tencent.mm.plugin.voip.f.g;
import com.tencent.mm.plugin.voip.f.h;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandler;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.util.b.a;
import java.nio.ByteBuffer;

public final class n
{
  public static int UzU = 0;
  public static int UzV = 0;
  public static int UzX = 60;
  public static int wTJ = 3;
  public l UvO;
  public final int UwF;
  volatile c UzC;
  private long UzD;
  private long UzE;
  private int UzF;
  private int UzG;
  private long UzH;
  private int UzI;
  private int UzJ;
  final Object UzK;
  public boolean UzL;
  public boolean UzM;
  public int UzN;
  private int UzO;
  private long UzP;
  public MMHandler UzQ;
  long UzR;
  private int UzS;
  private int UzT;
  n.a UzW;
  private ByteBuffer UzY;
  volatile com.tencent.mm.audio.b.c wTG;
  public int wTK;
  int wTL;
  private int wTM;
  public int wTO;
  private int wTQ;
  private long wTR;
  private c.a wTV;
  
  public n(l paraml)
  {
    AppMethodBeat.i(114946);
    this.UzC = null;
    this.wTG = null;
    this.wTK = 1;
    this.UvO = null;
    this.wTL = 92;
    this.UzD = 0L;
    this.UzE = 0L;
    this.UzF = 1;
    this.UzG = 0;
    this.wTM = 1;
    this.UzH = 0L;
    this.UzI = 0;
    this.UzJ = 0;
    this.UzK = new Object();
    this.wTO = 0;
    this.UzL = false;
    this.UzM = false;
    this.UzN = 0;
    this.wTQ = 1;
    this.UzO = 1;
    this.wTR = 0L;
    this.UzP = 0L;
    this.UzR = 0L;
    this.UzS = 0;
    this.UzT = h.ibK();
    this.wTV = new c.a()
    {
      public final void ds(int paramAnonymousInt1, int paramAnonymousInt2) {}
      
      public final void u(byte[] paramAnonymousArrayOfByte, int paramAnonymousInt)
      {
        AppMethodBeat.i(114941);
        for (;;)
        {
          synchronized (n.n(n.this))
          {
            if (com.tencent.mm.plugin.audio.c.a.cTW().audioManager.isMusicActive()) {
              com.tencent.mm.audio.c.b.a.ov(1);
            }
            com.tencent.mm.audio.c.b.a.e(paramAnonymousInt, paramAnonymousArrayOfByte);
            Object localObject2 = n.a(n.this);
            if ((n.this.wTK != 2) || (localObject2 == null))
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
              int i = ((c)localObject2).hVE();
              n.b(n.this, (i + 24 + n.f(n.this) * 3) / 4);
              if (n.g(n.this) != 1) {
                break label407;
              }
              n.c(n.this, ((c)localObject2).hVB());
              if (n.h(n.this) >= n.f(n.this)) {
                n.d(n.this, n.f(n.this));
              }
              n.b(n.this, n.h(n.this));
              n.i(n.this);
              if (1 != n.j(n.this)) {
                break label419;
              }
              n.k(n.this);
              n.c(n.this, System.currentTimeMillis());
              g.Logi("MicroMsg.Voip.VoipDeviceHandler", "amyfwang,first record");
              localObject2 = n.m(n.this);
              if (localObject2 == null) {
                continue;
              }
              n.this.UvO.UyU.UEg = ((com.tencent.mm.audio.b.c)localObject2).aGQ();
              n.this.UvO.UyU.recordCallback(paramAnonymousArrayOfByte, paramAnonymousInt, n.f(n.this));
              n.UzV += 1;
            }
          }
          long l1 = System.currentTimeMillis();
          n.a(n.this, (int)(l1 - n.e(n.this) - n.UzV * 20));
          n.a(n.this, l1);
          continue;
          label407:
          n.b(n.this, 0);
          continue;
          label419:
          l1 = System.currentTimeMillis();
          long l2 = l1 - n.l(n.this);
          if (l2 > 1000L) {
            g.Logi("MicroMsg.Voip.VoipDeviceHandler", "amyfwang,error,record deltaTime:".concat(String.valueOf(l2)));
          }
          n.c(n.this, l1);
        }
      }
    };
    com.tencent.mm.util.i locali = com.tencent.mm.util.i.agtt;
    this.UwF = com.tencent.mm.util.i.a(b.a.agsJ, 0);
    this.UvO = paraml;
    if ((this.UzQ == null) || (this.UzQ.isQuit())) {
      this.UzQ = new MMHandler("VoipDeviceHandler_stopDev");
    }
    AppMethodBeat.o(114946);
  }
  
  private void hWZ()
  {
    AppMethodBeat.i(114951);
    Log.i("MicroMsg.Voip.VoipDeviceHandler", "steve: StopHWEnc!!!");
    this.UvO.UyU.wVN = false;
    this.UzL = false;
    this.UzM = false;
    AppMethodBeat.o(114951);
  }
  
  public final int a(ByteBuffer paramByteBuffer, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5)
  {
    AppMethodBeat.i(293399);
    if (this.wTK != 2)
    {
      AppMethodBeat.o(293399);
      return 0;
    }
    if (!this.UvO.hWH())
    {
      AppMethodBeat.o(293399);
      return 0;
    }
    if ((paramInt3 == 1) || (paramInt4 == 1))
    {
      AppMethodBeat.o(293399);
      return 0;
    }
    Object localObject = this.UvO.UyU;
    ((v2protocal)localObject).UFx += 1;
    if (this.UzM)
    {
      hWZ();
      if (this.UvO.Uzh) {
        this.UvO.aqn(1);
      }
      this.UvO.c(8, true, false, true);
      localObject = t.UBA;
      t.hYd();
    }
    boolean bool2 = this.UzL;
    boolean bool1;
    label290:
    label307:
    label333:
    label355:
    long l;
    label406:
    int i;
    if ((this.UvO.UyU.wVN) && (this.UvO.UyU.UFQ != null))
    {
      this.UvO.UyU.UFQ.DoQosSvrCtrl();
      bool1 = this.UvO.UyU.UFQ.ENCODING.equalsIgnoreCase("video/avc");
      if ((this.UvO.UyU.UFQ.ENCODING.equalsIgnoreCase("video/hevc")) || ((bool1) && (1 == (this.UvO.UyU.UFQ.UwG.cRsvd1 & 0x1)) && (this.UvO.UyU.UFQ.UwG.cResolution >= 6)))
      {
        this.UzL = true;
        if (this.UzT != 0)
        {
          if (this.UzT != 1) {
            break label687;
          }
          bool1 = true;
          this.UzL = bool1;
          if (this.UzT == 1) {
            break label693;
          }
          bool1 = true;
          this.UzM = bool1;
          localObject = this.UvO.UyU;
          if (this.UzT != 1) {
            break label699;
          }
          bool1 = true;
          ((v2protocal)localObject).wVN = bool1;
        }
        localObject = com.tencent.mm.plugin.voip.f.e.ULA;
        if (this.UzL) {
          break label705;
        }
        bool1 = true;
        com.tencent.mm.plugin.voip.f.e.GN(bool1);
        if ((!bool2) || (this.UzL)) {
          break label711;
        }
        localObject = t.UBA;
        t.hYd();
        if (this.UvO.UyU.UFQ != null) {
          this.UvO.UyU.UFQ.gfg();
        }
        l = System.currentTimeMillis();
        Log.d("MicroMsg.Voip.VoipDeviceHandler", "steve: put video capture in, time:" + l + ", len:" + paramInt1 + ", cnt:" + this.UvO.UyU.UFx + ", mIsHWEncEnable:" + this.UvO.UyU.wVN + ", mIsHWEncUsing:" + this.UzL);
        i = 0;
        if ((!this.UzL) || (this.UvO.UyU.UFQ == null)) {
          break label942;
        }
        if (1 != this.UzN >> 8)
        {
          this.UzN |= 0x100;
          this.UvO.UyV.setHWDecMode(this.UzN);
        }
        paramInt1 = i;
        if (this.UvO.UyU.UFQ != null)
        {
          l = Util.currentTicks();
          if (paramInt5 != 1) {
            break label767;
          }
          if (!h.ibI()) {
            break label747;
          }
          paramInt1 = this.UvO.UyU.UFQ.UwJ;
          paramInt4 = this.UvO.UyU.UFQ.UwK;
        }
      }
    }
    for (;;)
    {
      for (paramInt1 = this.UvO.UyU.UFQ.a(paramByteBuffer, paramInt1, paramInt4, paramInt2, false);; paramInt1 = 0)
      {
        paramByteBuffer = com.tencent.mm.plugin.voip.video.render.i.USW;
        com.tencent.mm.plugin.voip.video.render.i.bj(2, Util.ticksToNow(l));
        this.UzY = null;
        if (paramInt1 < 0) {
          break label856;
        }
        paramInt1 = 1;
        label663:
        AppMethodBeat.o(293399);
        return paramInt1;
        this.UzL = false;
        break;
        this.UzL = false;
        break;
        label687:
        bool1 = false;
        break label290;
        label693:
        bool1 = false;
        break label307;
        label699:
        bool1 = false;
        break label333;
        label705:
        bool1 = false;
        break label355;
        label711:
        if ((bool2) || (!this.UzL) || (this.UvO.UyU.UFQ == null)) {
          break label406;
        }
        localObject = t.UBA;
        t.hYc();
        break label406;
        label747:
        if ((paramInt3 > 1) && (paramInt4 > 1)) {
          break label1125;
        }
        AppMethodBeat.o(293399);
        return 0;
        label767:
        if (paramInt5 != 2) {
          break label778;
        }
      }
      label778:
      if (h.ibI())
      {
        paramInt1 = this.UvO.UyU.UFQ.UwJ;
        paramInt4 = this.UvO.UyU.UFQ.UwK;
      }
      for (;;)
      {
        paramInt1 = this.UvO.UyU.UFQ.a(paramByteBuffer, paramInt1, paramInt4, paramInt2, true);
        break;
        if ((paramInt3 <= 1) || (paramInt4 <= 1))
        {
          AppMethodBeat.o(293399);
          return 0;
          label856:
          Log.i("MicroMsg.Voip.VoipDeviceHandler", "StopHWEnc!! hw encoder error: " + paramInt1 + "old:" + this.UvO.Uzh);
          if (this.UvO.Uzh) {
            this.UvO.aqn(1);
          }
          hWZ();
          paramByteBuffer = t.UBA;
          t.hYd();
          this.UvO.c(8, true, false, true);
          paramInt1 = i;
          break label663;
          label942:
          if ((paramInt3 <= 1) || (paramInt4 <= 1))
          {
            AppMethodBeat.o(293399);
            return 0;
          }
          if (this.UzN >> 8 != 0)
          {
            this.UzN &= 0xFFFFFEFF;
            this.UvO.UyV.setHWDecMode(this.UzN);
          }
          l = Util.currentTicks();
          if (paramInt5 == 2)
          {
            if ((this.UzY == null) || (this.UzY.capacity() < paramByteBuffer.capacity())) {
              this.UzY = ByteBuffer.allocateDirect(paramByteBuffer.capacity());
            }
            this.UzY.clear();
            paramByteBuffer.clear();
            this.UzY.put(paramByteBuffer).rewind();
            paramByteBuffer = this.UzY;
          }
          for (;;)
          {
            if (paramByteBuffer != null) {}
            for (paramInt1 = this.UvO.UyU.videoEncodeToSend2(paramByteBuffer, paramInt1, paramInt3, paramInt4, paramInt2);; paramInt1 = 0)
            {
              paramByteBuffer = com.tencent.mm.plugin.voip.video.render.i.USW;
              com.tencent.mm.plugin.voip.video.render.i.bj(1, Util.ticksToNow(l));
              break;
            }
          }
        }
        paramInt1 = paramInt3;
      }
      label1125:
      paramInt1 = paramInt3;
    }
  }
  
  public final int a(byte[] paramArrayOfByte1, int paramInt1, int paramInt2, int paramInt3, int paramInt4, byte[] paramArrayOfByte2, int paramInt5, int paramInt6, int paramInt7, int paramInt8)
  {
    AppMethodBeat.i(293383);
    if (this.wTK == wTJ)
    {
      AppMethodBeat.o(293383);
      return -1;
    }
    if (!this.UvO.UyU.hZm())
    {
      AppMethodBeat.o(293383);
      return -1;
    }
    if (!this.UvO.hWH())
    {
      AppMethodBeat.o(293383);
      return -2;
    }
    paramInt1 = this.UvO.UyU.videoRorate90D(paramArrayOfByte1, paramInt1, paramInt2, paramInt3, paramInt4, paramArrayOfByte2, paramInt5, paramInt6, paramInt7, paramInt8);
    AppMethodBeat.o(293383);
    return paramInt1;
  }
  
  public final int b(byte[] paramArrayOfByte, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    AppMethodBeat.i(114952);
    if (this.wTK != 2)
    {
      AppMethodBeat.o(114952);
      return 0;
    }
    if (!this.UvO.hWH())
    {
      AppMethodBeat.o(114952);
      return 0;
    }
    if (paramArrayOfByte.length < paramInt3 * paramInt4 * 3 / 2) {
      Log.e("MicroMsg.Voip.VoipDeviceHandler", "buffer length = %d, w = %d, h = %d\n", new Object[] { Integer.valueOf(paramArrayOfByte.length), Integer.valueOf(paramInt3), Integer.valueOf(paramInt4) });
    }
    Object localObject = this.UvO.UyU;
    ((v2protocal)localObject).UFx += 1;
    if (this.UzM)
    {
      hWZ();
      if (this.UvO.Uzh) {
        this.UvO.aqn(1);
      }
      this.UvO.c(8, true, false, true);
      localObject = t.UBA;
      t.hYd();
    }
    boolean bool1 = this.UzL;
    label322:
    long l1;
    int i;
    long l2;
    if ((this.UvO.UyU.wVN) && (this.UvO.UyU.UFQ != null))
    {
      this.UvO.UyU.UFQ.DoQosSvrCtrl();
      boolean bool2 = this.UvO.UyU.UFQ.ENCODING.equalsIgnoreCase("video/avc");
      if ((this.UvO.UyU.UFQ.ENCODING.equalsIgnoreCase("video/hevc")) || ((bool2) && (1 == (this.UvO.UyU.UFQ.UwG.cRsvd1 & 0x1)) && (this.UvO.UyU.UFQ.UwG.cResolution >= 6)))
      {
        this.UzL = true;
        if ((!bool1) || (this.UzL)) {
          break label595;
        }
        localObject = t.UBA;
        t.hYd();
        l1 = System.currentTimeMillis();
        Log.d("MicroMsg.Voip.VoipDeviceHandler", "steve: put video capture in, time:" + l1 + ", len:" + paramInt1 + ", cnt:" + this.UvO.UyU.UFx + ", mIsHWEncEnable:" + this.UvO.UyU.wVN + ", mIsHWEncUsing:" + this.UzL);
        i = 0;
        if ((!this.UzL) || (this.UvO.UyU.UFQ == null)) {
          break label733;
        }
        if (1 != this.UzN >> 8)
        {
          this.UzN |= 0x100;
          this.UvO.UyV.setHWDecMode(this.UzN);
        }
        paramInt1 = i;
        if (this.UvO.UyU.UFQ != null)
        {
          if ((this.UvO.UyU.UFQ.UwG.cSkipFlag != 0) && (this.UzS <= 10)) {
            break label717;
          }
          this.UzS = 0;
          l1 = System.currentTimeMillis();
          paramInt1 = this.UvO.UyU.UFQ.d(paramArrayOfByte, paramInt3, paramInt4, paramInt2);
          l2 = System.currentTimeMillis();
          paramArrayOfByte = com.tencent.mm.plugin.voip.video.render.i.USW;
          com.tencent.mm.plugin.voip.video.render.i.bj(2, l2 - l1);
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
      this.UzL = false;
      break;
      this.UzL = false;
      break;
      label595:
      if ((bool1) || (!this.UzL) || (this.UvO.UyU.UFQ == null)) {
        break label322;
      }
      localObject = t.UBA;
      t.hYc();
      break label322;
      label631:
      Log.i("MicroMsg.Voip.VoipDeviceHandler", "StopHWEnc!! hw encoder error: " + paramInt1 + "old:" + this.UvO.Uzh);
      if (this.UvO.Uzh) {
        this.UvO.aqn(1);
      }
      hWZ();
      paramArrayOfByte = t.UBA;
      t.hYd();
      this.UvO.c(8, true, false, true);
      paramInt1 = i;
      continue;
      label717:
      this.UzS += 1;
      paramInt1 = i;
      continue;
      label733:
      if (this.UzN >> 8 != 0)
      {
        this.UzN &= 0xFFFFFEFF;
        this.UvO.UyV.setHWDecMode(this.UzN);
      }
      l1 = System.currentTimeMillis();
      paramInt1 = this.UvO.UyU.videoEncodeToSend(paramArrayOfByte, paramInt1, paramInt3, paramInt4, paramInt2);
      l2 = System.currentTimeMillis();
      paramArrayOfByte = com.tencent.mm.plugin.voip.video.render.i.USW;
      com.tencent.mm.plugin.voip.video.render.i.bj(1, l2 - l1);
    }
  }
  
  public final int hVG()
  {
    AppMethodBeat.i(114947);
    if ((this.UzC != null) && (this.UvO.UyU.UFN.UAr == 1))
    {
      int i = this.UzC.hVG();
      AppMethodBeat.o(114947);
      return i;
    }
    AppMethodBeat.o(114947);
    return 0;
  }
  
  public final void hWV()
  {
    AppMethodBeat.i(293356);
    synchronized (this.UzK)
    {
      this.UzQ.post(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(114942);
          try
          {
            if (n.m(n.this) != null)
            {
              n.m(n.this).aGH();
              n.o(n.this);
              Log.i("MicroMsg.Voip.VoipDeviceHandler", "finish stopRecord and release recorder");
            }
            n.p(n.this);
            AppMethodBeat.o(114942);
            return;
          }
          catch (Exception localException)
          {
            Log.e("MicroMsg.Voip.VoipDeviceHandler", "start record error: %s", new Object[] { localException.getMessage() });
            n.this.wTO = 1;
            n.this.UvO.aqe(n.this.wTO);
            AppMethodBeat.o(114942);
          }
        }
      });
      AppMethodBeat.o(293356);
      return;
    }
  }
  
  public final int hWW()
  {
    if ((this.wTG != null) && (this.UvO.UyU.UFN.UAr == 1)) {
      return this.wTG.hwc;
    }
    return 0;
  }
  
  public final void hWX()
  {
    int j = -1;
    int k = 0;
    for (;;)
    {
      try
      {
        AppMethodBeat.i(114948);
        Log.i("MicroMsg.Voip.VoipDeviceHandler", "stopDev, recorder: %s", new Object[] { this.wTG });
        if (this.wTK == wTJ)
        {
          g.Loge("MicroMsg.Voip.VoipDeviceHandler", "devcie stoped already.");
          hWY();
          AppMethodBeat.o(114948);
          return;
        }
        g.Logi("MicroMsg.Voip.VoipDeviceHandler", "stop device..");
        this.wTK = wTJ;
        if (this.UzW != null)
        {
          g.Logd("MicroMsg.Voip.VoipDeviceHandler", "stop videodecode thread..");
          this.UzW.hXa();
          this.UzW.cancel();
          this.UzW = null;
        }
        this.UzT = h.ibK();
        this.wTM = 1;
        this.UzI = 0;
        this.wTQ = 1;
        this.UzO = 1;
        this.wTR = 0L;
        this.UzP = 0L;
        this.wTL = 92;
        this.UzD = 0L;
        this.UzE = 0L;
        this.UzF = 1;
        this.UzG = 0;
        this.wTO = 0;
        this.UvO.UyU.UDK = hWW();
        this.UvO.UyU.UDL = hVG();
        v2protocal localv2protocal = this.UvO.UyU;
        if ((this.wTG != null) && (this.UvO.UyU.UFN.UAr == 1))
        {
          i = this.wTG.aGV();
          localv2protocal.UDO = i;
          localv2protocal = this.UvO.UyU;
          if ((this.UzC == null) || (this.UvO.UyU.UFN.UAr != 1)) {
            break label505;
          }
          c localc = this.UzC;
          Log.d("MicroMsg.Voip.AudioPlayer", "AudioPlayer  mAudioPlayNum:" + localc.Uwv);
          i = localc.Uwv;
          localv2protocal.UDP = i;
          localv2protocal = this.UvO.UyU;
          i = k;
          if (this.UzC != null)
          {
            i = k;
            if (this.UvO.UyU.UFN.UAr == 1) {
              i = this.UzC.gdZ();
            }
          }
          float f = com.tencent.mm.plugin.audio.c.a.getStreamMaxVolume(i);
          localv2protocal.UEe = ((int)(com.tencent.mm.plugin.audio.c.a.getStreamVolume(i) / f * 100.0F));
          this.UvO.UyU.UDY = com.tencent.mm.plugin.audio.c.a.getMode();
          localv2protocal = this.UvO.UyU;
          if (this.wTG == null) {
            break label510;
          }
          i = this.wTG.aGT();
          localv2protocal.UEa = i;
          localv2protocal = this.UvO.UyU;
          i = j;
          if (this.UzC != null) {
            i = this.UzC.gdZ();
          }
          localv2protocal.UEc = i;
          hWY();
          AppMethodBeat.o(114948);
          continue;
        }
        i = -2;
      }
      finally {}
      continue;
      label505:
      int i = 0;
      continue;
      label510:
      i = -1;
    }
  }
  
  public final void hWY()
  {
    AppMethodBeat.i(114949);
    Log.printInfoStack("MicroMsg.Voip.VoipDeviceHandler", "forceCleanRecord, recorder %s", new Object[] { this.wTG });
    if (this.UzQ != null) {
      synchronized (this.UzK)
      {
        if ((this.UzC != null) || (this.wTG != null))
        {
          Log.i("MicroMsg.Voip.VoipDeviceHandler", "forceCleanRecord process post runnable");
          if (this.UzQ != null)
          {
            this.UzQ.removeCallbacksAndMessages(null);
            this.UzQ.post(new Runnable()
            {
              public final void run()
              {
                AppMethodBeat.i(114944);
                Log.i("MicroMsg.Voip.VoipDeviceHandler", "forceCleanRecord process post success and wait running");
                if (n.a(n.this) != null)
                {
                  n.a(n.this).hVF();
                  n.a(n.this).hVC();
                  n.t(n.this);
                  Log.i("MicroMsg.Voip.VoipDeviceHandler", "finish stopRecord and release player");
                }
                Log.i("MicroMsg.Voip.VoipDeviceHandler", "do stopRecord");
                if (n.m(n.this) != null)
                {
                  n.m(n.this).aGH();
                  n.o(n.this);
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
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     com.tencent.mm.plugin.voip.model.n
 * JD-Core Version:    0.7.0.1
 */