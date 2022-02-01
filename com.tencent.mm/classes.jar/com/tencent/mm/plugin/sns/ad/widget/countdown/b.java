package com.tencent.mm.plugin.sns.ad.widget.countdown;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.model.cm;
import com.tencent.mm.plugin.sns.ad.d.k;
import com.tencent.mm.plugin.sns.ad.d.k.a;
import com.tencent.mm.plugin.sns.ad.d.k.b;
import com.tencent.mm.plugin.sns.ad.i.f;
import com.tencent.mm.plugin.sns.ad.i.f.a;
import com.tencent.mm.sdk.platformtools.Log;

public final class b
  implements k.a, d
{
  private k JLV;
  private f.a JLW;
  private c JLX;
  
  public b(long paramLong1, long paramLong2)
  {
    AppMethodBeat.i(241965);
    this.JLV = new k(paramLong1, paramLong2)
    {
      public final long fJZ()
      {
        AppMethodBeat.i(231498);
        long l = cm.bfE();
        AppMethodBeat.o(231498);
        return l;
      }
      
      public final boolean isValid()
      {
        AppMethodBeat.i(231497);
        boolean bool = f.aA(this.mStartTime, this.Jzz);
        AppMethodBeat.o(231497);
        return bool;
      }
    };
    this.JLW = new f.a();
    AppMethodBeat.o(241965);
  }
  
  public final void Qh(long paramLong)
  {
    AppMethodBeat.i(241971);
    f.a locala = f.a(paramLong, this.JLW);
    c localc = this.JLX;
    if (localc != null) {
      localc.b(paramLong, locala);
    }
    AppMethodBeat.o(241971);
  }
  
  public final void a(c paramc)
  {
    this.JLX = paramc;
  }
  
  public final void dFU()
  {
    AppMethodBeat.i(241969);
    Log.d("SnsAd.CountDownViewModel", "stopCountDown is called");
    k localk = this.JLV;
    if (localk.JzB != null)
    {
      localk.JzB.cancel();
      localk.JzB = null;
    }
    localk.JzC = null;
    AppMethodBeat.o(241969);
  }
  
  public final void fMb()
  {
    AppMethodBeat.i(241968);
    Log.d("SnsAd.CountDownViewModel", "startCountDown is called");
    this.JLV.a(this);
    AppMethodBeat.o(241968);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ad.widget.countdown.b
 * JD-Core Version:    0.7.0.1
 */