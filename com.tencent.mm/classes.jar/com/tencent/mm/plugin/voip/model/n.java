package com.tencent.mm.plugin.voip.model;

import android.media.AudioManager;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.audio.b.c.a;
import com.tencent.mm.compatible.util.f;
import com.tencent.mm.plugin.voip.b.d;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ao;
import java.nio.ByteBuffer;

public final class n
{
  public static int ACI = 0;
  public static int ACJ = 0;
  public static int osM = 3;
  final Object ACA;
  public boolean ACB;
  public boolean ACC;
  public int ACD;
  private int ACE;
  private long ACF;
  public ao ACG;
  long ACH;
  n.a ACK;
  volatile c ACs;
  private long ACt;
  private long ACu;
  private int ACv;
  private int ACw;
  private long ACx;
  private int ACy;
  private int ACz;
  l Ayh;
  volatile com.tencent.mm.audio.b.c osJ;
  public int osN;
  int osO;
  private int osP;
  public int osR;
  private int osT;
  private long osU;
  private c.a osX;
  
  public n(l paraml)
  {
    AppMethodBeat.i(114946);
    this.ACs = null;
    this.osJ = null;
    this.osN = 1;
    this.Ayh = null;
    this.osO = 92;
    this.ACt = 0L;
    this.ACu = 0L;
    this.ACv = 1;
    this.ACw = 0;
    this.osP = 1;
    this.ACx = 0L;
    this.ACy = 0;
    this.ACz = 0;
    this.ACA = new Object();
    this.osR = 0;
    this.ACB = false;
    this.ACC = false;
    this.ACD = 0;
    this.osT = 1;
    this.ACE = 1;
    this.osU = 0L;
    this.ACF = 0L;
    this.ACH = 0L;
    this.osX = new c.a()
    {
      public final void cf(int paramAnonymousInt1, int paramAnonymousInt2) {}
      
      public final void u(byte[] paramAnonymousArrayOfByte, int paramAnonymousInt)
      {
        AppMethodBeat.i(114941);
        for (;;)
        {
          synchronized (n.n(n.this))
          {
            if (com.tencent.mm.plugin.audio.c.a.bCx().audioManager.isMusicActive()) {
              com.tencent.mm.audio.c.b.a.hR(1);
            }
            com.tencent.mm.audio.c.b.a.e(paramAnonymousInt, paramAnonymousArrayOfByte);
            if ((n.this.osN != 2) || (n.a(n.this) == null))
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
              int i = n.a(n.this).ehh();
              n.b(n.this, (i + 24 + n.f(n.this) * 3) / 4);
              if (n.g(n.this) != 1) {
                break label422;
              }
              n.c(n.this, n.a(n.this).ehe());
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
              d.Logi("MicroMsg.Voip.VoipDeviceHandler", "amyfwang,first record");
              if (n.m(n.this) == null) {
                continue;
              }
              n.this.Ayh.ABJ.AGK = n.m(n.this).Of();
              n.this.Ayh.ABJ.recordCallback(paramAnonymousArrayOfByte, paramAnonymousInt, n.f(n.this));
              n.ACJ += 1;
            }
          }
          long l1 = System.currentTimeMillis();
          n.a(n.this, (int)(l1 - n.e(n.this) - n.ACJ * 20));
          n.a(n.this, l1);
          continue;
          label422:
          n.b(n.this, 0);
          continue;
          label434:
          l1 = System.currentTimeMillis();
          long l2 = l1 - n.l(n.this);
          if (l2 > 1000L) {
            d.Logi("MicroMsg.Voip.VoipDeviceHandler", "amyfwang,error,record deltaTime:".concat(String.valueOf(l2)));
          }
          n.c(n.this, l1);
        }
      }
    };
    this.Ayh = paraml;
    if ((this.ACG == null) || (this.ACG.isQuit())) {
      this.ACG = new ao("VoipDeviceHandler_stopDev");
    }
    AppMethodBeat.o(114946);
  }
  
  private void eiI()
  {
    AppMethodBeat.i(114951);
    ac.i("MicroMsg.Voip.VoipDeviceHandler", "steve: StopHWEnc!!!");
    this.Ayh.ABJ.ouI = false;
    this.ACB = false;
    this.ACC = false;
    AppMethodBeat.o(114951);
  }
  
  public final int a(ByteBuffer paramByteBuffer, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    int i = 1;
    AppMethodBeat.i(208332);
    if (this.osN != 2)
    {
      AppMethodBeat.o(208332);
      return 0;
    }
    if (!this.Ayh.eit())
    {
      AppMethodBeat.o(208332);
      return 0;
    }
    Object localObject = this.Ayh.ABJ;
    ((v2protocal)localObject).AHP += 1;
    if (this.ACC)
    {
      eiI();
      if (this.Ayh.ABW) {
        this.Ayh.Sn(1);
      }
      this.Ayh.b(8, true, false, true);
      localObject = t.AEB;
      t.ejz();
    }
    boolean bool1 = this.ACB;
    if ((this.Ayh.ABJ.ouI) && (this.Ayh.ABJ.AIi != null))
    {
      this.Ayh.ABJ.AIi.DoQosSvrCtrl();
      boolean bool2 = this.Ayh.ABJ.AIi.ENCODING.equalsIgnoreCase("video/avc");
      if ((this.Ayh.ABJ.AIi.ENCODING.equalsIgnoreCase("video/hevc")) || ((bool2) && (1 == (this.Ayh.ABJ.AIi.Azs.cRsvd1 & 0x1)) && (this.Ayh.ABJ.AIi.Azs.cResolution >= 6)))
      {
        this.ACB = true;
        if ((!bool1) || (this.ACB)) {
          break label487;
        }
        localObject = t.AEB;
        t.ejz();
        label275:
        long l = System.currentTimeMillis();
        ac.d("MicroMsg.Voip.VoipDeviceHandler", "steve: put video capture in, time:" + l + ", len:" + paramInt1 + ", cnt:" + this.Ayh.ABJ.AHP + ", mIsHWEncEnable:" + this.Ayh.ABJ.ouI + ", mIsHWEncUsing:" + this.ACB);
        if ((!this.ACB) || (this.Ayh.ABJ.AIi == null)) {
          break label608;
        }
        if (1 != this.ACD >> 8)
        {
          this.ACD |= 0x100;
          this.Ayh.ABK.setHWDecMode(this.ACD);
        }
        if (this.Ayh.ABJ.AIi == null) {
          break label667;
        }
        paramInt1 = this.Ayh.ABJ.AIi.a(paramByteBuffer, paramInt3, paramInt4, paramInt2);
        if (paramInt1 < 0) {
          break label523;
        }
        paramInt1 = i;
      }
    }
    for (;;)
    {
      AppMethodBeat.o(208332);
      return paramInt1;
      this.ACB = false;
      break;
      this.ACB = false;
      break;
      label487:
      if ((bool1) || (!this.ACB) || (this.Ayh.ABJ.AIi == null)) {
        break label275;
      }
      localObject = t.AEB;
      t.ejy();
      break label275;
      label523:
      ac.i("MicroMsg.Voip.VoipDeviceHandler", "StopHWEnc!! hw encoder error: " + paramInt1 + "old:" + this.Ayh.ABW);
      if (this.Ayh.ABW) {
        this.Ayh.Sn(1);
      }
      eiI();
      paramByteBuffer = t.AEB;
      t.ejz();
      this.Ayh.b(8, true, false, true);
      paramInt1 = 0;
      continue;
      label608:
      if (this.ACD >> 8 != 0)
      {
        this.ACD &= 0xFFFFFEFF;
        this.Ayh.ABK.setHWDecMode(this.ACD);
      }
      paramInt1 = this.Ayh.ABJ.videoEncodeToSend2(paramByteBuffer, paramInt1, paramInt3, paramInt4, paramInt2);
      continue;
      label667:
      paramInt1 = 0;
    }
  }
  
  public final int b(byte[] paramArrayOfByte, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    int i = 1;
    AppMethodBeat.i(114952);
    if (this.osN != 2)
    {
      AppMethodBeat.o(114952);
      return 0;
    }
    if (!this.Ayh.eit())
    {
      AppMethodBeat.o(114952);
      return 0;
    }
    Object localObject = this.Ayh.ABJ;
    ((v2protocal)localObject).AHP += 1;
    if (this.ACC)
    {
      eiI();
      if (this.Ayh.ABW) {
        this.Ayh.Sn(1);
      }
      this.Ayh.b(8, true, false, true);
      localObject = t.AEB;
      t.ejz();
    }
    boolean bool1 = this.ACB;
    if ((this.Ayh.ABJ.ouI) && (this.Ayh.ABJ.AIi != null))
    {
      this.Ayh.ABJ.AIi.DoQosSvrCtrl();
      boolean bool2 = this.Ayh.ABJ.AIi.ENCODING.equalsIgnoreCase("video/avc");
      if ((this.Ayh.ABJ.AIi.ENCODING.equalsIgnoreCase("video/hevc")) || ((bool2) && (1 == (this.Ayh.ABJ.AIi.Azs.cRsvd1 & 0x1)) && (this.Ayh.ABJ.AIi.Azs.cResolution >= 6)))
      {
        this.ACB = true;
        if ((!bool1) || (this.ACB)) {
          break label487;
        }
        localObject = t.AEB;
        t.ejz();
        label275:
        long l = System.currentTimeMillis();
        ac.d("MicroMsg.Voip.VoipDeviceHandler", "steve: put video capture in, time:" + l + ", len:" + paramInt1 + ", cnt:" + this.Ayh.ABJ.AHP + ", mIsHWEncEnable:" + this.Ayh.ABJ.ouI + ", mIsHWEncUsing:" + this.ACB);
        if ((!this.ACB) || (this.Ayh.ABJ.AIi == null)) {
          break label608;
        }
        if (1 != this.ACD >> 8)
        {
          this.ACD |= 0x100;
          this.Ayh.ABK.setHWDecMode(this.ACD);
        }
        if (this.Ayh.ABJ.AIi == null) {
          break label667;
        }
        paramInt1 = this.Ayh.ABJ.AIi.b(paramArrayOfByte, paramInt3, paramInt4, paramInt2);
        if (paramInt1 < 0) {
          break label523;
        }
        paramInt1 = i;
      }
    }
    for (;;)
    {
      AppMethodBeat.o(114952);
      return paramInt1;
      this.ACB = false;
      break;
      this.ACB = false;
      break;
      label487:
      if ((bool1) || (!this.ACB) || (this.Ayh.ABJ.AIi == null)) {
        break label275;
      }
      localObject = t.AEB;
      t.ejy();
      break label275;
      label523:
      ac.i("MicroMsg.Voip.VoipDeviceHandler", "StopHWEnc!! hw encoder error: " + paramInt1 + "old:" + this.Ayh.ABW);
      if (this.Ayh.ABW) {
        this.Ayh.Sn(1);
      }
      eiI();
      paramArrayOfByte = t.AEB;
      t.ejz();
      this.Ayh.b(8, true, false, true);
      paramInt1 = 0;
      continue;
      label608:
      if (this.ACD >> 8 != 0)
      {
        this.ACD &= 0xFFFFFEFF;
        this.Ayh.ABK.setHWDecMode(this.ACD);
      }
      paramInt1 = this.Ayh.ABJ.videoEncodeToSend(paramArrayOfByte, paramInt1, paramInt3, paramInt4, paramInt2);
      continue;
      label667:
      paramInt1 = 0;
    }
  }
  
  public final int ehj()
  {
    AppMethodBeat.i(114947);
    if ((this.ACs != null) && (this.Ayh.ABJ.AIf.ADb == 1))
    {
      int i = this.ACs.ehj();
      AppMethodBeat.o(114947);
      return i;
    }
    AppMethodBeat.o(114947);
    return 0;
  }
  
  public final int eiF()
  {
    if ((this.osJ != null) && (this.Ayh.ABJ.AIf.ADb == 1)) {
      return this.osJ.cVv;
    }
    return 0;
  }
  
  public final void eiG()
  {
    int j = 0;
    for (;;)
    {
      try
      {
        AppMethodBeat.i(114948);
        ac.i("MicroMsg.Voip.VoipDeviceHandler", "stopDev, recorder: %s", new Object[] { this.osJ });
        if (this.osN == osM)
        {
          d.Loge("MicroMsg.Voip.VoipDeviceHandler", "devcie stoped already.");
          eiH();
          AppMethodBeat.o(114948);
          return;
        }
        d.Logi("MicroMsg.Voip.VoipDeviceHandler", "stop device..");
        this.osN = osM;
        if (this.ACK != null)
        {
          d.Logd("MicroMsg.Voip.VoipDeviceHandler", "stop videodecode thread..");
          this.ACK.ACN = true;
          this.ACK.cancel();
          this.ACK = null;
        }
        this.osP = 1;
        this.ACy = 0;
        this.osT = 1;
        this.ACE = 1;
        this.osU = 0L;
        this.ACF = 0L;
        this.osO = 92;
        this.ACt = 0L;
        this.ACu = 0L;
        this.ACv = 1;
        this.ACw = 0;
        this.osR = 0;
        this.Ayh.ABJ.AGx = eiF();
        this.Ayh.ABJ.AGy = ehj();
        v2protocal localv2protocal = this.Ayh.ABJ;
        int i;
        if ((this.osJ != null) && (this.Ayh.ABJ.AIf.ADb == 1))
        {
          i = this.osJ.Oj();
          localv2protocal.AGB = i;
          localv2protocal = this.Ayh.ABJ;
          i = j;
          if (this.ACs != null)
          {
            i = j;
            if (this.Ayh.ABJ.AIf.ADb == 1) {
              i = this.ACs.aKj();
            }
          }
          float f = com.tencent.mm.plugin.audio.c.a.getStreamMaxVolume(i);
          localv2protocal.AGI = ((int)(com.tencent.mm.plugin.audio.c.a.getStreamVolume(i) / f * 100.0F));
          eiH();
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
  
  public final void eiH()
  {
    AppMethodBeat.i(114949);
    ac.m("MicroMsg.Voip.VoipDeviceHandler", "forceCleanRecord, recorder %s", new Object[] { this.osJ });
    if (this.ACG != null) {
      synchronized (this.ACA)
      {
        if ((this.ACs != null) || (this.osJ != null))
        {
          ac.i("MicroMsg.Voip.VoipDeviceHandler", "forceCleanRecord process post runnable");
          if (this.ACG != null)
          {
            this.ACG.removeCallbacksAndMessages(null);
            this.ACG.post(new Runnable()
            {
              public final void run()
              {
                AppMethodBeat.i(114944);
                ac.i("MicroMsg.Voip.VoipDeviceHandler", "forceCleanRecord process post success and wait running");
                if (n.a(n.this) != null)
                {
                  n.a(n.this).ehi();
                  n.a(n.this).ehf();
                  n.s(n.this);
                  ac.i("MicroMsg.Voip.VoipDeviceHandler", "finish stopRecord and release player");
                }
                ac.i("MicroMsg.Voip.VoipDeviceHandler", "do stopRecord");
                if (n.m(n.this) != null)
                {
                  n.m(n.this).NX();
                  n.t(n.this);
                  ac.i("MicroMsg.Voip.VoipDeviceHandler", "finish stopRecord and release recorder");
                }
                ac.i("MicroMsg.Voip.VoipDeviceHandler", "forceCleanRecord process post success and quitSafely");
                AppMethodBeat.o(114944);
              }
            });
          }
        }
        AppMethodBeat.o(114949);
        return;
      }
    }
    ac.i("MicroMsg.Voip.VoipDeviceHandler", "forceCleanRecord failed but mDevHandler is null");
    AppMethodBeat.o(114949);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.voip.model.n
 * JD-Core Version:    0.7.0.1
 */