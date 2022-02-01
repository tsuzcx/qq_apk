package com.tencent.mm.plugin.sns.ad.widget.countdown;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.model.cn;
import com.tencent.mm.plugin.sns.ad.d.m;
import com.tencent.mm.plugin.sns.ad.d.m.a;
import com.tencent.mm.plugin.sns.ad.d.m.b;
import com.tencent.mm.plugin.sns.ad.j.f;
import com.tencent.mm.plugin.sns.ad.j.f.a;
import com.tencent.mm.sdk.platformtools.Log;

public final class b
  implements m.a, d
{
  private m Qfw;
  private f.a Qfx;
  private c Qfy;
  
  public b(long paramLong1, long paramLong2)
  {
    AppMethodBeat.i(310416);
    this.Qfw = new m(paramLong1, paramLong2)
    {
      public final long gZR()
      {
        AppMethodBeat.i(310406);
        long l = cn.bDw();
        AppMethodBeat.o(310406);
        return l;
      }
      
      public final boolean isValid()
      {
        AppMethodBeat.i(310395);
        boolean bool = f.bk(this.mStartTime, this.POg);
        AppMethodBeat.o(310395);
        return bool;
      }
    };
    this.Qfx = new f.a();
    AppMethodBeat.o(310416);
  }
  
  public final void a(c paramc)
  {
    this.Qfy = paramc;
  }
  
  public final void exT()
  {
    AppMethodBeat.i(310429);
    Log.d("SnsAd.CountDownViewModel", "startCountDown is called");
    this.Qfw.a(this);
    AppMethodBeat.o(310429);
  }
  
  public final void exf()
  {
    AppMethodBeat.i(310439);
    Log.d("SnsAd.CountDownViewModel", "stopCountDown is called");
    m localm = this.Qfw;
    if (localm.POi != null)
    {
      localm.POi.cancel();
      localm.POi = null;
    }
    localm.POj = null;
    AppMethodBeat.o(310439);
  }
  
  public final void uo(long paramLong)
  {
    AppMethodBeat.i(310445);
    f.a locala = f.a(paramLong, this.Qfx);
    c localc = this.Qfy;
    if (localc != null) {
      localc.b(paramLong, locala);
    }
    AppMethodBeat.o(310445);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ad.widget.countdown.b
 * JD-Core Version:    0.7.0.1
 */