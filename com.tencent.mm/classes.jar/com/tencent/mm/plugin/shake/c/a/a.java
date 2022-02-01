package com.tencent.mm.plugin.shake.c.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.h;
import com.tencent.mm.am.p;
import com.tencent.mm.audio.b.c;
import com.tencent.mm.audio.b.c.a;
import com.tencent.mm.model.bh;
import com.tencent.mm.plugin.appbrand.af.o;
import com.tencent.mm.protocal.protobuf.dlk;
import com.tencent.mm.protocal.protobuf.esc;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.LinkedList;

public final class a
  implements h
{
  private int EuH;
  private int PAN;
  private int PAO;
  private int PAP;
  private long PAQ;
  private int PAR;
  private k.a PAS;
  k.b PAT;
  private volatile byte[] PAU;
  private boolean PAV;
  private int crd;
  private c hvI;
  private c.a hwR;
  private volatile boolean pdm;
  
  public a()
  {
    AppMethodBeat.i(273598);
    this.PAN = 400;
    this.PAO = 8194;
    this.PAP = 0;
    this.PAQ = 0L;
    this.PAR = 1;
    this.PAS = null;
    this.PAU = new byte[this.PAO];
    this.EuH = 0;
    this.crd = 0;
    this.PAV = false;
    this.hwR = new c.a()
    {
      public final void ds(int paramAnonymousInt1, int paramAnonymousInt2) {}
      
      public final void u(byte[] paramAnonymousArrayOfByte, int paramAnonymousInt)
      {
        AppMethodBeat.i(273644);
        k.b localb;
        double d;
        if (a.a(a.this) != null)
        {
          localb = a.a(a.this);
          com.tencent.mm.plugin.shake.d.a locala = com.tencent.mm.plugin.shake.d.a.PEO;
          kotlin.g.b.s.u(paramAnonymousArrayOfByte, "data");
          if (paramAnonymousInt == 0) {
            break label145;
          }
          d = com.tencent.mm.plugin.shake.d.a.h(com.tencent.mm.plugin.shake.d.a.E(paramAnonymousArrayOfByte, paramAnonymousInt / 2), paramAnonymousInt / 2);
          if (d < 50.0D) {
            break label145;
          }
          if (d >= 300.0D) {
            break label125;
          }
          i = 1;
        }
        label145:
        for (;;)
        {
          localb.amplitudeCallback(i);
          if (paramAnonymousArrayOfByte.length > 0) {
            break;
          }
          Log.e("MicroMsg.MusicAndSingRecorder", "pcm data is <= 0, length: %d, maxLength: %d", new Object[] { Integer.valueOf(paramAnonymousArrayOfByte.length) });
          a.b(a.this);
          a.c(a.this);
          AppMethodBeat.o(273644);
          return;
          label125:
          if (d < 800.0D)
          {
            i = 2;
          }
          else
          {
            i = 3;
            continue;
            i = 0;
          }
        }
        int i = paramAnonymousInt;
        if (a.d(a.this) + paramAnonymousInt >= a.e(a.this))
        {
          Log.e("MicroMsg.MusicAndSingRecorder", "pcm data is too max, length: %d, pcm length: %d, maxLength: %d", new Object[] { Integer.valueOf(a.d(a.this)), Integer.valueOf(paramAnonymousInt), Integer.valueOf(a.e(a.this)) });
          i = a.e(a.this) - a.d(a.this);
        }
        Log.i("MicroMsg.MusicAndSingRecorder", "before copy currentPosition: %d", new Object[] { Integer.valueOf(a.d(a.this)) });
        if (a.d(a.this) + i <= a.e(a.this))
        {
          System.arraycopy(paramAnonymousArrayOfByte, 0, a.f(a.this), a.d(a.this), i);
          a.a(a.this, i);
        }
        for (;;)
        {
          long l = Util.nowMilliSecond() - a.g(a.this);
          Log.i("MicroMsg.MusicAndSingRecorder", "after copy currentPosition: %d, duration: %d", new Object[] { Integer.valueOf(a.d(a.this)), Long.valueOf(l) });
          if ((l >= a.h(a.this) * a.i(a.this)) && (!a.j(a.this)))
          {
            Log.i("MicroMsg.MusicAndSingRecorder", "duration is reach，duration: %d, rangeTime: %d", new Object[] { Long.valueOf(l), Integer.valueOf(a.h(a.this)) });
            paramAnonymousArrayOfByte = new byte[a.d(a.this)];
            System.arraycopy(a.f(a.this), 0, paramAnonymousArrayOfByte, 0, a.d(a.this));
            if (l > 11000L)
            {
              a.k(a.this);
              Log.i("MicroMsg.MusicAndSingRecorder", "record time is max, duration: %d", new Object[] { Long.valueOf(l) });
            }
            a.a(a.this, l, paramAnonymousArrayOfByte, a.l(a.this));
            a.m(a.this);
            a.a(a.this, new byte[a.e(a.this)]);
            if (a.j(a.this)) {
              a.b(a.this);
            }
          }
          AppMethodBeat.o(273644);
          return;
          Log.e("MicroMsg.MusicAndSingRecorder", "data copy refuse, is too long");
        }
      }
    };
    AppMethodBeat.o(273598);
  }
  
  private void c(long paramLong, byte[] paramArrayOfByte, int paramInt)
  {
    AppMethodBeat.i(273603);
    bh.baH().postToWorker(new a..ExternalSyntheticLambda1(this, paramArrayOfByte, paramLong, paramInt));
    AppMethodBeat.o(273603);
  }
  
  private void c(esc paramesc)
  {
    AppMethodBeat.i(273604);
    o.runOnUiThread(new a..ExternalSyntheticLambda0(this, paramesc));
    AppMethodBeat.o(273604);
  }
  
  private void reset()
  {
    AppMethodBeat.i(273601);
    Log.d("MicroMsg.MusicAndSingRecorder", "reset recorder clientId: %d", new Object[] { Integer.valueOf(this.PAP) });
    if (this.hvI != null)
    {
      this.hvI.aGH();
      this.hvI = null;
    }
    AppMethodBeat.o(273601);
  }
  
  public final boolean a(k.a parama)
  {
    AppMethodBeat.i(273652);
    bh.aZW().a(5245, this);
    this.PAP = ((int)Util.nowMilliSecond());
    this.PAS = parama;
    this.hvI = new c(8000, 1, 4);
    this.hvI.hwn = -19;
    this.hvI.hwy = this.hwR;
    if (!this.hvI.aGR())
    {
      Log.e("MicroMsg.MusicAndSingRecorder", "start record failed clientId: %d", new Object[] { Integer.valueOf(this.PAP) });
      reset();
      AppMethodBeat.o(273652);
      return false;
    }
    this.PAQ = Util.nowMilliSecond();
    this.pdm = false;
    this.EuH = 0;
    this.PAR = 1;
    this.crd = 0;
    this.PAV = false;
    AppMethodBeat.o(273652);
    return true;
  }
  
  public final boolean aGH()
  {
    AppMethodBeat.i(273656);
    bh.aZW().b(5245, this);
    if (this.hvI != null)
    {
      this.hvI.aGH();
      this.hvI = null;
    }
    AppMethodBeat.o(273656);
    return true;
  }
  
  public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, p paramp)
  {
    AppMethodBeat.i(273663);
    if (paramp.getType() != 5245)
    {
      AppMethodBeat.o(273663);
      return;
    }
    Log.i("MicroMsg.MusicAndSingRecorder", "clientId: %d, onSceneEnd >> errType: %d, errCode: %d", new Object[] { Integer.valueOf(this.PAP), Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
    if ((paramInt1 == 0) && (paramInt2 == 0) && (((f)paramp).gXF() != null))
    {
      paramString = (dlk)((f)paramp).gXF();
      this.PAN = paramString.interval;
      this.PAO = paramString.aaRz;
      Log.i("MicroMsg.MusicAndSingRecorder", "onSceneEnd: pullInterval: %d, maxPacketSize: %d", new Object[] { Integer.valueOf(this.PAN), Integer.valueOf(this.PAO) });
      if (paramString.aaRx == 1)
      {
        if ((paramString.aaRA != null) && (paramString.aaRA.size() > 0))
        {
          Log.i("MicroMsg.MusicAndSingRecorder", "NetSceneShakeMedia isRecoSuccess stop now ! clientId: %d", new Object[] { Integer.valueOf(this.PAP) });
          aGH();
          c(paramString);
          AppMethodBeat.o(273663);
          return;
        }
        Log.i("MicroMsg.MusicAndSingRecorder", "NetSceneShakeMedia isRecoFailed stop now clientId: %d", new Object[] { Integer.valueOf(this.PAP) });
        aGH();
        c(null);
        AppMethodBeat.o(273663);
        return;
      }
      if (this.pdm)
      {
        this.crd += 1;
        if (this.crd >= 5)
        {
          Log.i("MicroMsg.MusicAndSingRecorder", "null package count is max");
          c(null);
          AppMethodBeat.o(273663);
          return;
        }
        long l1 = Util.nowMilliSecond();
        long l2 = this.PAQ;
        paramString = new byte[1];
        paramInt1 = this.PAR;
        this.PAR = (paramInt1 + 1);
        c(l1 - l2, paramString, paramInt1);
      }
      AppMethodBeat.o(273663);
      return;
    }
    Log.e("MicroMsg.MusicAndSingRecorder", "network error, errType: %d, errCode: %d", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
    reset();
    c(null);
    AppMethodBeat.o(273663);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes11.jar
 * Qualified Name:     com.tencent.mm.plugin.shake.c.a.a
 * JD-Core Version:    0.7.0.1
 */