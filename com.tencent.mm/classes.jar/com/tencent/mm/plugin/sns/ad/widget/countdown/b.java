package com.tencent.mm.plugin.sns.ad.widget.countdown;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.model.cl;
import com.tencent.mm.plugin.sns.ad.e.g;
import com.tencent.mm.plugin.sns.ad.e.g.a;
import com.tencent.mm.plugin.sns.ad.e.g.b;
import com.tencent.mm.plugin.sns.ad.i.e;
import com.tencent.mm.plugin.sns.ad.i.e.a;
import com.tencent.mm.sdk.platformtools.Log;

public final class b
  implements g.a, d
{
  private g DAs;
  private e.a DAt;
  private c DAu;
  
  public b(long paramLong1, long paramLong2)
  {
    AppMethodBeat.i(202397);
    this.DAs = new g(paramLong1, paramLong2)
    {
      public final long eWP()
      {
        AppMethodBeat.i(202396);
        long l = cl.aWA();
        AppMethodBeat.o(202396);
        return l;
      }
      
      public final boolean isValid()
      {
        AppMethodBeat.i(202395);
        boolean bool = e.ap(this.mStartTime, this.DsM);
        AppMethodBeat.o(202395);
        return bool;
      }
    };
    this.DAt = new e.a();
    AppMethodBeat.o(202397);
  }
  
  public final void IO(long paramLong)
  {
    AppMethodBeat.i(202400);
    e.a locala = e.a(paramLong, this.DAt);
    c localc = this.DAu;
    if (localc != null) {
      localc.b(paramLong, locala);
    }
    AppMethodBeat.o(202400);
  }
  
  public final void a(c paramc)
  {
    this.DAu = paramc;
  }
  
  public final void eYr()
  {
    AppMethodBeat.i(202398);
    Log.d("SnsAd.CountDownViewModel", "startCountDown is called");
    this.DAs.a(this);
    AppMethodBeat.o(202398);
  }
  
  public final void eYs()
  {
    AppMethodBeat.i(202399);
    Log.d("SnsAd.CountDownViewModel", "stopCountDown is called");
    g localg = this.DAs;
    if (localg.DsO != null)
    {
      localg.DsO.cancel();
      localg.DsO = null;
    }
    localg.DsP = null;
    AppMethodBeat.o(202399);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ad.widget.countdown.b
 * JD-Core Version:    0.7.0.1
 */