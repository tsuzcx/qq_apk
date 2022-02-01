package com.tencent.mm.plugin.voip.model;

import android.media.AudioManager;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.audio.b.c.a;
import com.tencent.mm.plugin.voip.video.render.i;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.ap;
import com.tencent.mm.sdk.platformtools.bt;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;

public final class n
{
  public static int CbI = 0;
  public static int CbJ = 0;
  public static int oWi = 3;
  l BXC;
  public boolean CbA;
  public boolean CbB;
  public int CbC;
  private int CbD;
  private long CbE;
  public ap CbF;
  long CbG;
  private int CbH;
  a CbK;
  private ByteBuffer CbL;
  volatile c Cbr;
  private long Cbs;
  private long Cbt;
  private int Cbu;
  private int Cbv;
  private long Cbw;
  private int Cbx;
  private int Cby;
  final Object Cbz;
  volatile com.tencent.mm.audio.b.c oWf;
  public int oWj;
  int oWk;
  private int oWl;
  public int oWn;
  private int oWp;
  private long oWq;
  private c.a oWt;
  
  public n(l paraml)
  {
    AppMethodBeat.i(114946);
    this.Cbr = null;
    this.oWf = null;
    this.oWj = 1;
    this.BXC = null;
    this.oWk = 92;
    this.Cbs = 0L;
    this.Cbt = 0L;
    this.Cbu = 1;
    this.Cbv = 0;
    this.oWl = 1;
    this.Cbw = 0L;
    this.Cbx = 0;
    this.Cby = 0;
    this.Cbz = new Object();
    this.oWn = 0;
    this.CbA = false;
    this.CbB = false;
    this.CbC = 0;
    this.oWp = 1;
    this.CbD = 1;
    this.oWq = 0L;
    this.CbE = 0L;
    this.CbG = 0L;
    this.CbH = 0;
    this.oWt = new c.a()
    {
      public final void ch(int paramAnonymousInt1, int paramAnonymousInt2) {}
      
      public final void u(byte[] paramAnonymousArrayOfByte, int paramAnonymousInt)
      {
        AppMethodBeat.i(114941);
        for (;;)
        {
          synchronized (n.n(n.this))
          {
            if (com.tencent.mm.plugin.audio.c.a.bGC().audioManager.isMusicActive()) {
              com.tencent.mm.audio.c.b.a.hY(1);
            }
            com.tencent.mm.audio.c.b.a.e(paramAnonymousInt, paramAnonymousArrayOfByte);
            if ((n.this.oWj != 2) || (n.a(n.this) == null))
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
              int i = n.a(n.this).euT();
              n.b(n.this, (i + 24 + n.f(n.this) * 3) / 4);
              if (n.g(n.this) != 1) {
                break label422;
              }
              n.c(n.this, n.a(n.this).euQ());
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
              com.tencent.mm.plugin.voip.b.f.Logi("MicroMsg.Voip.VoipDeviceHandler", "amyfwang,first record");
              if (n.m(n.this) == null) {
                continue;
              }
              n.this.BXC.CaI.CfL = n.m(n.this).PO();
              n.this.BXC.CaI.recordCallback(paramAnonymousArrayOfByte, paramAnonymousInt, n.f(n.this));
              n.CbJ += 1;
            }
          }
          long l1 = System.currentTimeMillis();
          n.a(n.this, (int)(l1 - n.e(n.this) - n.CbJ * 20));
          n.a(n.this, l1);
          continue;
          label422:
          n.b(n.this, 0);
          continue;
          label434:
          l1 = System.currentTimeMillis();
          long l2 = l1 - n.l(n.this);
          if (l2 > 1000L) {
            com.tencent.mm.plugin.voip.b.f.Logi("MicroMsg.Voip.VoipDeviceHandler", "amyfwang,error,record deltaTime:".concat(String.valueOf(l2)));
          }
          n.c(n.this, l1);
        }
      }
    };
    this.BXC = paraml;
    if ((this.CbF == null) || (this.CbF.isQuit())) {
      this.CbF = new ap("VoipDeviceHandler_stopDev");
    }
    AppMethodBeat.o(114946);
  }
  
  private void ewt()
  {
    AppMethodBeat.i(114951);
    ad.i("MicroMsg.Voip.VoipDeviceHandler", "steve: StopHWEnc!!!");
    this.BXC.CaI.oYd = false;
    this.CbA = false;
    this.CbB = false;
    AppMethodBeat.o(114951);
  }
  
  public final int b(ByteBuffer paramByteBuffer, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5)
  {
    AppMethodBeat.i(216365);
    if (this.oWj != 2)
    {
      AppMethodBeat.o(216365);
      return 0;
    }
    if (!this.BXC.ewe())
    {
      AppMethodBeat.o(216365);
      return 0;
    }
    Object localObject = this.BXC.CaI;
    ((v2protocal)localObject).CgQ += 1;
    if (this.CbB)
    {
      ewt();
      if (this.BXC.CaV) {
        this.BXC.Uf(1);
      }
      this.BXC.a(8, true, false, true);
      localObject = t.CdB;
      t.exk();
    }
    boolean bool2 = this.CbA;
    boolean bool1;
    label280:
    label305:
    long l;
    if ((this.BXC.CaI.oYd) && (this.BXC.CaI.Chj != null))
    {
      this.BXC.CaI.Chj.DoQosSvrCtrl();
      bool1 = this.BXC.CaI.Chj.ENCODING.equalsIgnoreCase("video/avc");
      if ((this.BXC.CaI.Chj.ENCODING.equalsIgnoreCase("video/hevc")) || ((bool1) && (1 == (this.BXC.CaI.Chj.BYq.cRsvd1 & 0x1)) && (this.BXC.CaI.Chj.BYq.cResolution >= 6)))
      {
        this.CbA = true;
        if (this.BXC.CaI.Chj != null)
        {
          localObject = com.tencent.mm.plugin.voip.b.d.Clj;
          if (this.CbA) {
            break label546;
          }
          bool1 = true;
          com.tencent.mm.plugin.voip.b.d.tA(bool1);
        }
        if ((!bool2) || (this.CbA)) {
          break label552;
        }
        localObject = t.CdB;
        t.exk();
        l = System.currentTimeMillis();
        ad.d("MicroMsg.Voip.VoipDeviceHandler", "steve: put video capture in, time:" + l + ", len:" + paramInt1 + ", cnt:" + this.BXC.CaI.CgQ + ", mIsHWEncEnable:" + this.BXC.CaI.oYd + ", mIsHWEncUsing:" + this.CbA);
        if ((!this.CbA) || (this.BXC.CaI.Chj == null)) {
          break label708;
        }
        if (1 != this.CbC >> 8)
        {
          this.CbC |= 0x100;
          this.BXC.CaJ.setHWDecMode(this.CbC);
        }
        if (this.BXC.CaI.Chj == null) {
          break label856;
        }
        l = bt.HI();
        if (paramInt5 != 1) {
          break label588;
        }
        paramInt1 = this.BXC.CaI.Chj.a(paramByteBuffer, paramInt3, paramInt4, paramInt2, false);
        label498:
        paramByteBuffer = i.Csj;
        i.aJ(2, bt.aO(l));
        this.CbL = null;
        if (paramInt1 < 0) {
          break label623;
        }
        paramInt1 = 1;
      }
    }
    for (;;)
    {
      AppMethodBeat.o(216365);
      return paramInt1;
      this.CbA = false;
      break;
      this.CbA = false;
      break;
      label546:
      bool1 = false;
      break label280;
      label552:
      if ((bool2) || (!this.CbA) || (this.BXC.CaI.Chj == null)) {
        break label305;
      }
      localObject = t.CdB;
      t.exj();
      break label305;
      label588:
      if (paramInt5 == 2)
      {
        paramInt1 = 0;
        break label498;
      }
      paramInt1 = this.BXC.CaI.Chj.a(paramByteBuffer, paramInt3, paramInt4, paramInt2, true);
      break label498;
      label623:
      ad.i("MicroMsg.Voip.VoipDeviceHandler", "StopHWEnc!! hw encoder error: " + paramInt1 + "old:" + this.BXC.CaV);
      if (this.BXC.CaV) {
        this.BXC.Uf(1);
      }
      ewt();
      paramByteBuffer = t.CdB;
      t.exk();
      this.BXC.a(8, true, false, true);
      paramInt1 = 0;
      continue;
      label708:
      if (this.CbC >> 8 != 0)
      {
        this.CbC &= 0xFFFFFEFF;
        this.BXC.CaJ.setHWDecMode(this.CbC);
      }
      l = bt.HI();
      if (paramInt5 == 2)
      {
        if ((this.CbL == null) || (this.CbL.capacity() < paramByteBuffer.capacity())) {
          this.CbL = ByteBuffer.allocateDirect(paramByteBuffer.capacity());
        }
        this.CbL.clear();
        paramByteBuffer.clear();
        this.CbL.put(paramByteBuffer).rewind();
        paramByteBuffer = this.CbL;
      }
      for (;;)
      {
        paramInt1 = this.BXC.CaI.videoEncodeToSend2(paramByteBuffer, paramInt1, paramInt3, paramInt4, paramInt2);
        paramByteBuffer = i.Csj;
        i.aJ(1, bt.aO(l));
        break;
      }
      label856:
      paramInt1 = 0;
    }
  }
  
  public final int b(byte[] paramArrayOfByte, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    AppMethodBeat.i(114952);
    if (this.oWj != 2)
    {
      AppMethodBeat.o(114952);
      return 0;
    }
    if (!this.BXC.ewe())
    {
      AppMethodBeat.o(114952);
      return 0;
    }
    Object localObject = this.BXC.CaI;
    ((v2protocal)localObject).CgQ += 1;
    if (this.CbB)
    {
      ewt();
      if (this.BXC.CaV) {
        this.BXC.Uf(1);
      }
      this.BXC.a(8, true, false, true);
      localObject = t.CdB;
      t.exk();
    }
    boolean bool1 = this.CbA;
    label272:
    long l1;
    int i;
    long l2;
    if ((this.BXC.CaI.oYd) && (this.BXC.CaI.Chj != null))
    {
      this.BXC.CaI.Chj.DoQosSvrCtrl();
      boolean bool2 = this.BXC.CaI.Chj.ENCODING.equalsIgnoreCase("video/avc");
      if ((this.BXC.CaI.Chj.ENCODING.equalsIgnoreCase("video/hevc")) || ((bool2) && (1 == (this.BXC.CaI.Chj.BYq.cRsvd1 & 0x1)) && (this.BXC.CaI.Chj.BYq.cResolution >= 6)))
      {
        this.CbA = true;
        if ((!bool1) || (this.CbA)) {
          break label545;
        }
        localObject = t.CdB;
        t.exk();
        l1 = System.currentTimeMillis();
        ad.d("MicroMsg.Voip.VoipDeviceHandler", "steve: put video capture in, time:" + l1 + ", len:" + paramInt1 + ", cnt:" + this.BXC.CaI.CgQ + ", mIsHWEncEnable:" + this.BXC.CaI.oYd + ", mIsHWEncUsing:" + this.CbA);
        i = 0;
        if ((!this.CbA) || (this.BXC.CaI.Chj == null)) {
          break label683;
        }
        if (1 != this.CbC >> 8)
        {
          this.CbC |= 0x100;
          this.BXC.CaJ.setHWDecMode(this.CbC);
        }
        paramInt1 = i;
        if (this.BXC.CaI.Chj != null)
        {
          if ((this.BXC.CaI.Chj.BYq.cSkipFlag != 0) && (this.CbH <= 10)) {
            break label667;
          }
          this.CbH = 0;
          l1 = System.currentTimeMillis();
          paramInt1 = this.BXC.CaI.Chj.b(paramArrayOfByte, paramInt3, paramInt4, paramInt2);
          l2 = System.currentTimeMillis();
          paramArrayOfByte = i.Csj;
          i.aJ(2, l2 - l1);
          if (paramInt1 < 0) {
            break label581;
          }
          paramInt1 = 1;
        }
      }
    }
    for (;;)
    {
      AppMethodBeat.o(114952);
      return paramInt1;
      this.CbA = false;
      break;
      this.CbA = false;
      break;
      label545:
      if ((bool1) || (!this.CbA) || (this.BXC.CaI.Chj == null)) {
        break label272;
      }
      localObject = t.CdB;
      t.exj();
      break label272;
      label581:
      ad.i("MicroMsg.Voip.VoipDeviceHandler", "StopHWEnc!! hw encoder error: " + paramInt1 + "old:" + this.BXC.CaV);
      if (this.BXC.CaV) {
        this.BXC.Uf(1);
      }
      ewt();
      paramArrayOfByte = t.CdB;
      t.exk();
      this.BXC.a(8, true, false, true);
      paramInt1 = i;
      continue;
      label667:
      this.CbH += 1;
      paramInt1 = i;
      continue;
      label683:
      if (this.CbC >> 8 != 0)
      {
        this.CbC &= 0xFFFFFEFF;
        this.BXC.CaJ.setHWDecMode(this.CbC);
      }
      l1 = System.currentTimeMillis();
      paramInt1 = this.BXC.CaI.videoEncodeToSend(paramArrayOfByte, paramInt1, paramInt3, paramInt4, paramInt2);
      l2 = System.currentTimeMillis();
      paramArrayOfByte = i.Csj;
      i.aJ(1, l2 - l1);
    }
  }
  
  public final int euV()
  {
    AppMethodBeat.i(114947);
    if ((this.Cbr != null) && (this.BXC.CaI.Chg.Ccc == 1))
    {
      int i = this.Cbr.euV();
      AppMethodBeat.o(114947);
      return i;
    }
    AppMethodBeat.o(114947);
    return 0;
  }
  
  public final int ewq()
  {
    if ((this.oWf != null) && (this.BXC.CaI.Chg.Ccc == 1)) {
      return this.oWf.dgL;
    }
    return 0;
  }
  
  public final void ewr()
  {
    int j = 0;
    for (;;)
    {
      try
      {
        AppMethodBeat.i(114948);
        ad.i("MicroMsg.Voip.VoipDeviceHandler", "stopDev, recorder: %s", new Object[] { this.oWf });
        if (this.oWj == oWi)
        {
          com.tencent.mm.plugin.voip.b.f.Loge("MicroMsg.Voip.VoipDeviceHandler", "devcie stoped already.");
          ews();
          AppMethodBeat.o(114948);
          return;
        }
        com.tencent.mm.plugin.voip.b.f.Logi("MicroMsg.Voip.VoipDeviceHandler", "stop device..");
        this.oWj = oWi;
        if (this.CbK != null)
        {
          com.tencent.mm.plugin.voip.b.f.Logd("MicroMsg.Voip.VoipDeviceHandler", "stop videodecode thread..");
          this.CbK.CbO = true;
          this.CbK.cancel();
          this.CbK = null;
        }
        this.oWl = 1;
        this.Cbx = 0;
        this.oWp = 1;
        this.CbD = 1;
        this.oWq = 0L;
        this.CbE = 0L;
        this.oWk = 92;
        this.Cbs = 0L;
        this.Cbt = 0L;
        this.Cbu = 1;
        this.Cbv = 0;
        this.oWn = 0;
        this.BXC.CaI.Cfx = ewq();
        this.BXC.CaI.Cfy = euV();
        v2protocal localv2protocal = this.BXC.CaI;
        if ((this.oWf != null) && (this.BXC.CaI.Chg.Ccc == 1))
        {
          i = this.oWf.PS();
          localv2protocal.CfB = i;
          localv2protocal = this.BXC.CaI;
          if ((this.Cbr == null) || (this.BXC.CaI.Chg.Ccc != 1)) {
            break label419;
          }
          c localc = this.Cbr;
          ad.d("MicroMsg.Voip.AudioPlayer", "AudioPlayer  mAudioPlayNum:" + localc.BYi);
          i = localc.BYi;
          localv2protocal.CfC = i;
          localv2protocal = this.BXC.CaI;
          i = j;
          if (this.Cbr != null)
          {
            i = j;
            if (this.BXC.CaI.Chg.Ccc == 1) {
              i = this.Cbr.aNs();
            }
          }
          float f = com.tencent.mm.plugin.audio.c.a.getStreamMaxVolume(i);
          localv2protocal.CfJ = ((int)(com.tencent.mm.plugin.audio.c.a.getStreamVolume(i) / f * 100.0F));
          ews();
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
  
  public final void ews()
  {
    AppMethodBeat.i(114949);
    ad.m("MicroMsg.Voip.VoipDeviceHandler", "forceCleanRecord, recorder %s", new Object[] { this.oWf });
    if (this.CbF != null) {
      synchronized (this.Cbz)
      {
        if ((this.Cbr != null) || (this.oWf != null))
        {
          ad.i("MicroMsg.Voip.VoipDeviceHandler", "forceCleanRecord process post runnable");
          if (this.CbF != null)
          {
            this.CbF.removeCallbacksAndMessages(null);
            this.CbF.post(new Runnable()
            {
              public final void run()
              {
                AppMethodBeat.i(114944);
                ad.i("MicroMsg.Voip.VoipDeviceHandler", "forceCleanRecord process post success and wait running");
                if (n.a(n.this) != null)
                {
                  n.a(n.this).euU();
                  n.a(n.this).euR();
                  n.s(n.this);
                  ad.i("MicroMsg.Voip.VoipDeviceHandler", "finish stopRecord and release player");
                }
                ad.i("MicroMsg.Voip.VoipDeviceHandler", "do stopRecord");
                if (n.m(n.this) != null)
                {
                  n.m(n.this).PG();
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
    boolean CbN = false;
    boolean CbO = false;
    byte[] CbP = null;
    ByteBuffer CbQ = null;
    int CbR = 0;
    
    a() {}
    
    public final String getKey()
    {
      return "stop_video_decode_runnable";
    }
    
    public final void run()
    {
      AppMethodBeat.i(114945);
      if ((n.this.oWj == 2) && (!this.CbO))
      {
        long l1 = System.currentTimeMillis();
        int i;
        int j;
        boolean bool1;
        boolean bool2;
        Object localObject1;
        if (n.this.BXC.ewf())
        {
          if (this.CbP == null)
          {
            this.CbQ = ByteBuffer.allocateDirect(n.this.BXC.CaI.defaultWidth * n.this.BXC.CaI.defaultHeight * 4).order(ByteOrder.nativeOrder());
            this.CbQ.position(0);
            this.CbP = new byte[this.CbQ.remaining()];
            ad.i("MicroMsg.Voip.VoipDeviceHandler", "init remoteImageByteBuffer, defaultWidth:%s, defaultHeight:%s", new Object[] { Integer.valueOf(n.this.BXC.CaI.defaultWidth), Integer.valueOf(n.this.BXC.CaI.defaultHeight) });
          }
          i = 0;
          if (this.CbQ != null)
          {
            this.CbQ.clear();
            i = n.this.BXC.CaI.videoDecodeBB(this.CbQ);
          }
          if (i == 1)
          {
            this.CbR += 1;
            this.CbQ.get(this.CbP);
            i = n.this.BXC.CaI.field_remoteImgWidth;
            j = n.this.BXC.CaI.field_remoteImgHeight;
            if ((i != 0) || (j >= 3)) {
              break label561;
            }
            bool1 = true;
            if (this.CbR % 200 == 10) {
              ad.i("MicroMsg.Voip.VoipDeviceHandler", "steve: dec statistics: total:%d, soft:%d, size:%dx%d, HW:%b", new Object[] { Integer.valueOf(this.CbR), Integer.valueOf(n.this.BXC.CaI.CgU), Integer.valueOf(i), Integer.valueOf(j), Boolean.valueOf(bool1) });
            }
            bool2 = false;
            if (!bool1) {
              break label604;
            }
            if (!this.CbN)
            {
              localObject1 = n.this;
              ((n)localObject1).CbC |= 0x1;
              n.this.BXC.CaJ.setHWDecMode(n.this.CbC);
              bool2 = true;
              ad.i("MicroMsg.Voip.VoipDeviceHandler", "steve: change to HW dec, restart decoder!");
              localObject1 = t.CdB;
              t.exh();
            }
            if (v2protocal.Chk == null) {}
          }
        }
        for (;;)
        {
          try
          {
            for (;;)
            {
              i = n.this.BXC.CaI.field_remoteImgLength;
              ad.d("MicroMsg.Voip.VoipDeviceHandler", "steve:video decode successfully!..len=".concat(String.valueOf(i)));
              j = n.this.BXC.CaI.field_remoteImgHeight;
              localObject1 = new byte[i];
              System.arraycopy(this.CbP, 0, localObject1, 0, i);
              v2protocal.Chk.f((byte[])localObject1, j, bool2);
              long l2 = System.currentTimeMillis();
              ad.d("MicroMsg.Voip.VoipDeviceHandler", "steve: fill in AvcDecoder take time = " + (l2 - l1) + ", startTime = " + l1);
              this.CbN = bool1;
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
          if (this.CbN)
          {
            localObject2 = n.this;
            ((n)localObject2).CbC &= 0xFFFFFFFE;
            if (v2protocal.Chk != null) {
              v2protocal.Chk.waL = false;
            }
            n.this.BXC.CaJ.setHWDecMode(n.this.CbC);
            ad.i("MicroMsg.Voip.VoipDeviceHandler", "steve: change to SW dec");
            localObject2 = t.CdB;
            t.exi();
          }
          int k = n.this.BXC.CaI.field_remoteImgLength;
          if ((k > 0) && (n.this.BXC.CaJ != null))
          {
            localObject2 = n.this.BXC.CaI;
            ((v2protocal)localObject2).CgU += 1;
            n.this.BXC.CaJ.d(i, j, this.CbP);
            if (n.this.BXC.CaI.CgU % 100 == 0)
            {
              localObject2 = new byte[5];
              int m = i * 33 + 33;
              int n = i * 34 - 34;
              int i1 = i * j / 2 + i / 2;
              int i2 = (j - 34) * i + 33;
              int i3 = (j - 34) * i + i - 34;
              if ((this.CbP != null) && (i3 < this.CbP.length))
              {
                localObject2[0] = this.CbP[m];
                localObject2[1] = this.CbP[n];
                localObject2[2] = this.CbP[i1];
                localObject2[3] = this.CbP[i2];
                localObject2[4] = this.CbP[i3];
                ad.i("MicroMsg.Voip.VoipDeviceHandler", "steve: SW dec to render: cnt:%d, size:%dx%d, outlen:%d, samples:%d,%d,%d,%d,%d", new Object[] { Integer.valueOf(n.this.BXC.CaI.CgU), Integer.valueOf(i), Integer.valueOf(j), Integer.valueOf(k), Byte.valueOf(localObject2[0]), Byte.valueOf(localObject2[1]), Byte.valueOf(localObject2[2]), Byte.valueOf(localObject2[3]), Byte.valueOf(localObject2[4]) });
                ad.i("MicroMsg.Voip.VoipDeviceHandler", "steve: first 5 samples:%d,%d,%d,%d,%d", new Object[] { Byte.valueOf(this.CbP[0]), Byte.valueOf(this.CbP[1]), Byte.valueOf(this.CbP[2]), Byte.valueOf(this.CbP[3]), Byte.valueOf(this.CbP[4]) });
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
                  localObject2 = t.CdB;
                  t.exp();
                }
              }
              else
              {
                ad.i("MicroMsg.Voip.VoipDeviceHandler", "steve: dec null pointer or out of memory! size:%dx%d, idx:%d,%d,%d,%d,%d, len:%d ", new Object[] { Integer.valueOf(i), Integer.valueOf(j), Integer.valueOf(m), Integer.valueOf(n), Integer.valueOf(i1), Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(this.CbP.length) });
              }
            }
          }
        }
      }
      AppMethodBeat.o(114945);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.voip.model.n
 * JD-Core Version:    0.7.0.1
 */