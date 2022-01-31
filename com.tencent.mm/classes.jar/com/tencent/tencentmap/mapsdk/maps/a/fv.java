package com.tencent.tencentmap.mapsdk.maps.a;

import android.os.Handler;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.concurrent.Executor;

public class fv
  implements ge
{
  private final Executor a;
  
  public fv(Handler paramHandler)
  {
    AppMethodBeat.i(147966);
    this.a = new fv.1(this, paramHandler);
    AppMethodBeat.o(147966);
  }
  
  public void a(gb<?> paramgb, gd<?> paramgd)
  {
    AppMethodBeat.i(147967);
    a(paramgb, paramgd, null);
    AppMethodBeat.o(147967);
  }
  
  public void a(gb<?> paramgb, gd<?> paramgd, Runnable paramRunnable)
  {
    AppMethodBeat.i(147968);
    paramgb.r();
    paramgb.a("post-response");
    this.a.execute(new fv.a(this, paramgb, paramgd, paramRunnable));
    AppMethodBeat.o(147968);
  }
  
  public void a(gb<?> paramgb, gi paramgi)
  {
    AppMethodBeat.i(147969);
    paramgb.a("post-error");
    paramgi = gd.a(paramgi);
    this.a.execute(new fv.a(this, paramgb, paramgi, null));
    AppMethodBeat.o(147969);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.tencentmap.mapsdk.maps.a.fv
 * JD-Core Version:    0.7.0.1
 */