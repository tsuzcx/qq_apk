package com.tencent.mm.plugin.voip.model;

import android.media.AudioManager;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.audio.b.c.a;
import com.tencent.mm.plugin.voip.b.d;
import com.tencent.mm.plugin.voip.video.render.i;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.aq;
import com.tencent.mm.sdk.platformtools.bu;
import java.nio.ByteBuffer;

public final class n
{
  public static int Ctj = 0;
  public static int Ctk = 0;
  public static int pcL = 3;
  l Cpd;
  volatile c CsS;
  private long CsT;
  private long CsU;
  private int CsV;
  private int CsW;
  private long CsX;
  private int CsY;
  private int CsZ;
  final Object Cta;
  public boolean Ctb;
  public boolean Ctc;
  public int Ctd;
  private int Cte;
  private long Ctf;
  public aq Ctg;
  long Cth;
  private int Cti;
  n.a Ctl;
  private ByteBuffer Ctm;
  volatile com.tencent.mm.audio.b.c pcI;
  public int pcM;
  int pcN;
  private int pcO;
  public int pcQ;
  private int pcS;
  private long pcT;
  private c.a pcW;
  
  public n(l paraml)
  {
    AppMethodBeat.i(114946);
    this.CsS = null;
    this.pcI = null;
    this.pcM = 1;
    this.Cpd = null;
    this.pcN = 92;
    this.CsT = 0L;
    this.CsU = 0L;
    this.CsV = 1;
    this.CsW = 0;
    this.pcO = 1;
    this.CsX = 0L;
    this.CsY = 0;
    this.CsZ = 0;
    this.Cta = new Object();
    this.pcQ = 0;
    this.Ctb = false;
    this.Ctc = false;
    this.Ctd = 0;
    this.pcS = 1;
    this.Cte = 1;
    this.pcT = 0L;
    this.Ctf = 0L;
    this.Cth = 0L;
    this.Cti = 0;
    this.pcW = new c.a()
    {
      public final void ch(int paramAnonymousInt1, int paramAnonymousInt2) {}
      
      public final void u(byte[] paramAnonymousArrayOfByte, int paramAnonymousInt)
      {
        AppMethodBeat.i(114941);
        for (;;)
        {
          synchronized (n.n(n.this))
          {
            if (com.tencent.mm.plugin.audio.c.a.bHy().audioManager.isMusicActive()) {
              com.tencent.mm.audio.c.b.a.ia(1);
            }
            com.tencent.mm.audio.c.b.a.e(paramAnonymousInt, paramAnonymousArrayOfByte);
            if ((n.this.pcM != 2) || (n.a(n.this) == null))
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
              int i = n.a(n.this).eyz();
              n.b(n.this, (i + 24 + n.f(n.this) * 3) / 4);
              if (n.g(n.this) != 1) {
                break label422;
              }
              n.c(n.this, n.a(n.this).eyw());
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
              n.this.Cpd.Csj.Cxm = n.m(n.this).PN();
              n.this.Cpd.Csj.recordCallback(paramAnonymousArrayOfByte, paramAnonymousInt, n.f(n.this));
              n.Ctk += 1;
            }
          }
          long l1 = System.currentTimeMillis();
          n.a(n.this, (int)(l1 - n.e(n.this) - n.Ctk * 20));
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
    this.Cpd = paraml;
    if ((this.Ctg == null) || (this.Ctg.isQuit())) {
      this.Ctg = new aq("VoipDeviceHandler_stopDev");
    }
    AppMethodBeat.o(114946);
  }
  
  private void eAa()
  {
    AppMethodBeat.i(114951);
    ae.i("MicroMsg.Voip.VoipDeviceHandler", "steve: StopHWEnc!!!");
    this.Cpd.Csj.peH = false;
    this.Ctb = false;
    this.Ctc = false;
    AppMethodBeat.o(114951);
  }
  
  public final int b(ByteBuffer paramByteBuffer, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5)
  {
    AppMethodBeat.i(210044);
    if (this.pcM != 2)
    {
      AppMethodBeat.o(210044);
      return 0;
    }
    if (!this.Cpd.ezL())
    {
      AppMethodBeat.o(210044);
      return 0;
    }
    Object localObject = this.Cpd.Csj;
    ((v2protocal)localObject).Cyr += 1;
    if (this.Ctc)
    {
      eAa();
      if (this.Cpd.Csw) {
        this.Cpd.UM(1);
      }
      this.Cpd.b(8, true, false, true);
      localObject = t.Cvc;
      t.eAR();
    }
    boolean bool2 = this.Ctb;
    boolean bool1;
    label280:
    label305:
    long l;
    if ((this.Cpd.Csj.peH) && (this.Cpd.Csj.CyK != null))
    {
      this.Cpd.Csj.CyK.DoQosSvrCtrl();
      bool1 = this.Cpd.Csj.CyK.ENCODING.equalsIgnoreCase("video/avc");
      if ((this.Cpd.Csj.CyK.ENCODING.equalsIgnoreCase("video/hevc")) || ((bool1) && (1 == (this.Cpd.Csj.CyK.CpR.cRsvd1 & 0x1)) && (this.Cpd.Csj.CyK.CpR.cResolution >= 6)))
      {
        this.Ctb = true;
        if (this.Cpd.Csj.CyK != null)
        {
          localObject = d.CCN;
          if (this.Ctb) {
            break label546;
          }
          bool1 = true;
          d.tH(bool1);
        }
        if ((!bool2) || (this.Ctb)) {
          break label552;
        }
        localObject = t.Cvc;
        t.eAR();
        l = System.currentTimeMillis();
        ae.d("MicroMsg.Voip.VoipDeviceHandler", "steve: put video capture in, time:" + l + ", len:" + paramInt1 + ", cnt:" + this.Cpd.Csj.Cyr + ", mIsHWEncEnable:" + this.Cpd.Csj.peH + ", mIsHWEncUsing:" + this.Ctb);
        if ((!this.Ctb) || (this.Cpd.Csj.CyK == null)) {
          break label708;
        }
        if (1 != this.Ctd >> 8)
        {
          this.Ctd |= 0x100;
          this.Cpd.Csk.setHWDecMode(this.Ctd);
        }
        if (this.Cpd.Csj.CyK == null) {
          break label856;
        }
        l = bu.HQ();
        if (paramInt5 != 1) {
          break label588;
        }
        paramInt1 = this.Cpd.Csj.CyK.a(paramByteBuffer, paramInt3, paramInt4, paramInt2, false);
        label498:
        paramByteBuffer = i.CJN;
        i.aJ(2, bu.aO(l));
        this.Ctm = null;
        if (paramInt1 < 0) {
          break label623;
        }
        paramInt1 = 1;
      }
    }
    for (;;)
    {
      AppMethodBeat.o(210044);
      return paramInt1;
      this.Ctb = false;
      break;
      this.Ctb = false;
      break;
      label546:
      bool1 = false;
      break label280;
      label552:
      if ((bool2) || (!this.Ctb) || (this.Cpd.Csj.CyK == null)) {
        break label305;
      }
      localObject = t.Cvc;
      t.eAQ();
      break label305;
      label588:
      if (paramInt5 == 2)
      {
        paramInt1 = 0;
        break label498;
      }
      paramInt1 = this.Cpd.Csj.CyK.a(paramByteBuffer, paramInt3, paramInt4, paramInt2, true);
      break label498;
      label623:
      ae.i("MicroMsg.Voip.VoipDeviceHandler", "StopHWEnc!! hw encoder error: " + paramInt1 + "old:" + this.Cpd.Csw);
      if (this.Cpd.Csw) {
        this.Cpd.UM(1);
      }
      eAa();
      paramByteBuffer = t.Cvc;
      t.eAR();
      this.Cpd.b(8, true, false, true);
      paramInt1 = 0;
      continue;
      label708:
      if (this.Ctd >> 8 != 0)
      {
        this.Ctd &= 0xFFFFFEFF;
        this.Cpd.Csk.setHWDecMode(this.Ctd);
      }
      l = bu.HQ();
      if (paramInt5 == 2)
      {
        if ((this.Ctm == null) || (this.Ctm.capacity() < paramByteBuffer.capacity())) {
          this.Ctm = ByteBuffer.allocateDirect(paramByteBuffer.capacity());
        }
        this.Ctm.clear();
        paramByteBuffer.clear();
        this.Ctm.put(paramByteBuffer).rewind();
        paramByteBuffer = this.Ctm;
      }
      for (;;)
      {
        paramInt1 = this.Cpd.Csj.videoEncodeToSend2(paramByteBuffer, paramInt1, paramInt3, paramInt4, paramInt2);
        paramByteBuffer = i.CJN;
        i.aJ(1, bu.aO(l));
        break;
      }
      label856:
      paramInt1 = 0;
    }
  }
  
  public final int b(byte[] paramArrayOfByte, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    AppMethodBeat.i(114952);
    if (this.pcM != 2)
    {
      AppMethodBeat.o(114952);
      return 0;
    }
    if (!this.Cpd.ezL())
    {
      AppMethodBeat.o(114952);
      return 0;
    }
    Object localObject = this.Cpd.Csj;
    ((v2protocal)localObject).Cyr += 1;
    if (this.Ctc)
    {
      eAa();
      if (this.Cpd.Csw) {
        this.Cpd.UM(1);
      }
      this.Cpd.b(8, true, false, true);
      localObject = t.Cvc;
      t.eAR();
    }
    boolean bool1 = this.Ctb;
    label272:
    long l1;
    int i;
    long l2;
    if ((this.Cpd.Csj.peH) && (this.Cpd.Csj.CyK != null))
    {
      this.Cpd.Csj.CyK.DoQosSvrCtrl();
      boolean bool2 = this.Cpd.Csj.CyK.ENCODING.equalsIgnoreCase("video/avc");
      if ((this.Cpd.Csj.CyK.ENCODING.equalsIgnoreCase("video/hevc")) || ((bool2) && (1 == (this.Cpd.Csj.CyK.CpR.cRsvd1 & 0x1)) && (this.Cpd.Csj.CyK.CpR.cResolution >= 6)))
      {
        this.Ctb = true;
        if ((!bool1) || (this.Ctb)) {
          break label545;
        }
        localObject = t.Cvc;
        t.eAR();
        l1 = System.currentTimeMillis();
        ae.d("MicroMsg.Voip.VoipDeviceHandler", "steve: put video capture in, time:" + l1 + ", len:" + paramInt1 + ", cnt:" + this.Cpd.Csj.Cyr + ", mIsHWEncEnable:" + this.Cpd.Csj.peH + ", mIsHWEncUsing:" + this.Ctb);
        i = 0;
        if ((!this.Ctb) || (this.Cpd.Csj.CyK == null)) {
          break label683;
        }
        if (1 != this.Ctd >> 8)
        {
          this.Ctd |= 0x100;
          this.Cpd.Csk.setHWDecMode(this.Ctd);
        }
        paramInt1 = i;
        if (this.Cpd.Csj.CyK != null)
        {
          if ((this.Cpd.Csj.CyK.CpR.cSkipFlag != 0) && (this.Cti <= 10)) {
            break label667;
          }
          this.Cti = 0;
          l1 = System.currentTimeMillis();
          paramInt1 = this.Cpd.Csj.CyK.b(paramArrayOfByte, paramInt3, paramInt4, paramInt2);
          l2 = System.currentTimeMillis();
          paramArrayOfByte = i.CJN;
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
      this.Ctb = false;
      break;
      this.Ctb = false;
      break;
      label545:
      if ((bool1) || (!this.Ctb) || (this.Cpd.Csj.CyK == null)) {
        break label272;
      }
      localObject = t.Cvc;
      t.eAQ();
      break label272;
      label581:
      ae.i("MicroMsg.Voip.VoipDeviceHandler", "StopHWEnc!! hw encoder error: " + paramInt1 + "old:" + this.Cpd.Csw);
      if (this.Cpd.Csw) {
        this.Cpd.UM(1);
      }
      eAa();
      paramArrayOfByte = t.Cvc;
      t.eAR();
      this.Cpd.b(8, true, false, true);
      paramInt1 = i;
      continue;
      label667:
      this.Cti += 1;
      paramInt1 = i;
      continue;
      label683:
      if (this.Ctd >> 8 != 0)
      {
        this.Ctd &= 0xFFFFFEFF;
        this.Cpd.Csk.setHWDecMode(this.Ctd);
      }
      l1 = System.currentTimeMillis();
      paramInt1 = this.Cpd.Csj.videoEncodeToSend(paramArrayOfByte, paramInt1, paramInt3, paramInt4, paramInt2);
      l2 = System.currentTimeMillis();
      paramArrayOfByte = i.CJN;
      i.aJ(1, l2 - l1);
    }
  }
  
  public final int eyB()
  {
    AppMethodBeat.i(114947);
    if ((this.CsS != null) && (this.Cpd.Csj.CyH.CtD == 1))
    {
      int i = this.CsS.eyB();
      AppMethodBeat.o(114947);
      return i;
    }
    AppMethodBeat.o(114947);
    return 0;
  }
  
  public final int ezX()
  {
    if ((this.pcI != null) && (this.Cpd.Csj.CyH.CtD == 1)) {
      return this.pcI.dhN;
    }
    return 0;
  }
  
  public final void ezY()
  {
    int j = 0;
    for (;;)
    {
      try
      {
        AppMethodBeat.i(114948);
        ae.i("MicroMsg.Voip.VoipDeviceHandler", "stopDev, recorder: %s", new Object[] { this.pcI });
        if (this.pcM == pcL)
        {
          com.tencent.mm.plugin.voip.b.f.Loge("MicroMsg.Voip.VoipDeviceHandler", "devcie stoped already.");
          ezZ();
          AppMethodBeat.o(114948);
          return;
        }
        com.tencent.mm.plugin.voip.b.f.Logi("MicroMsg.Voip.VoipDeviceHandler", "stop device..");
        this.pcM = pcL;
        if (this.Ctl != null)
        {
          com.tencent.mm.plugin.voip.b.f.Logd("MicroMsg.Voip.VoipDeviceHandler", "stop videodecode thread..");
          this.Ctl.Ctp = true;
          this.Ctl.cancel();
          this.Ctl = null;
        }
        this.pcO = 1;
        this.CsY = 0;
        this.pcS = 1;
        this.Cte = 1;
        this.pcT = 0L;
        this.Ctf = 0L;
        this.pcN = 92;
        this.CsT = 0L;
        this.CsU = 0L;
        this.CsV = 1;
        this.CsW = 0;
        this.pcQ = 0;
        this.Cpd.Csj.CwY = ezX();
        this.Cpd.Csj.CwZ = eyB();
        v2protocal localv2protocal = this.Cpd.Csj;
        if ((this.pcI != null) && (this.Cpd.Csj.CyH.CtD == 1))
        {
          i = this.pcI.PR();
          localv2protocal.Cxc = i;
          localv2protocal = this.Cpd.Csj;
          if ((this.CsS == null) || (this.Cpd.Csj.CyH.CtD != 1)) {
            break label419;
          }
          c localc = this.CsS;
          ae.d("MicroMsg.Voip.AudioPlayer", "AudioPlayer  mAudioPlayNum:" + localc.CpJ);
          i = localc.CpJ;
          localv2protocal.Cxd = i;
          localv2protocal = this.Cpd.Csj;
          i = j;
          if (this.CsS != null)
          {
            i = j;
            if (this.Cpd.Csj.CyH.CtD == 1) {
              i = this.CsS.aNQ();
            }
          }
          float f = com.tencent.mm.plugin.audio.c.a.getStreamMaxVolume(i);
          localv2protocal.Cxk = ((int)(com.tencent.mm.plugin.audio.c.a.getStreamVolume(i) / f * 100.0F));
          ezZ();
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
  
  public final void ezZ()
  {
    AppMethodBeat.i(114949);
    ae.m("MicroMsg.Voip.VoipDeviceHandler", "forceCleanRecord, recorder %s", new Object[] { this.pcI });
    if (this.Ctg != null) {
      synchronized (this.Cta)
      {
        if ((this.CsS != null) || (this.pcI != null))
        {
          ae.i("MicroMsg.Voip.VoipDeviceHandler", "forceCleanRecord process post runnable");
          if (this.Ctg != null)
          {
            this.Ctg.removeCallbacksAndMessages(null);
            this.Ctg.post(new Runnable()
            {
              public final void run()
              {
                AppMethodBeat.i(114944);
                ae.i("MicroMsg.Voip.VoipDeviceHandler", "forceCleanRecord process post success and wait running");
                if (n.a(n.this) != null)
                {
                  n.a(n.this).eyA();
                  n.a(n.this).eyx();
                  n.s(n.this);
                  ae.i("MicroMsg.Voip.VoipDeviceHandler", "finish stopRecord and release player");
                }
                ae.i("MicroMsg.Voip.VoipDeviceHandler", "do stopRecord");
                if (n.m(n.this) != null)
                {
                  n.m(n.this).PF();
                  n.t(n.this);
                  ae.i("MicroMsg.Voip.VoipDeviceHandler", "finish stopRecord and release recorder");
                }
                ae.i("MicroMsg.Voip.VoipDeviceHandler", "forceCleanRecord process post success and quitSafely");
                AppMethodBeat.o(114944);
              }
            });
          }
        }
        AppMethodBeat.o(114949);
        return;
      }
    }
    ae.i("MicroMsg.Voip.VoipDeviceHandler", "forceCleanRecord failed but mDevHandler is null");
    AppMethodBeat.o(114949);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.voip.model.n
 * JD-Core Version:    0.7.0.1
 */