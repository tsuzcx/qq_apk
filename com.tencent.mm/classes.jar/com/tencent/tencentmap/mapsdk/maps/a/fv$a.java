package com.tencent.tencentmap.mapsdk.maps.a;

import com.tencent.matrix.trace.core.AppMethodBeat;

class fv$a
  implements Runnable
{
  private final gb b;
  private final gd c;
  private final Runnable d;
  
  public fv$a(fv paramfv, gb paramgb, gd paramgd, Runnable paramRunnable)
  {
    this.b = paramgb;
    this.c = paramgd;
    this.d = paramRunnable;
  }
  
  public void run()
  {
    AppMethodBeat.i(147965);
    if (this.b.d())
    {
      this.b.b("canceled-at-delivery");
      AppMethodBeat.o(147965);
      return;
    }
    if (this.c.a())
    {
      this.b.a(this.c.a);
      if (!this.c.c) {
        break label112;
      }
      this.b.a("intermediate-response");
    }
    for (;;)
    {
      if (this.d != null) {
        this.d.run();
      }
      AppMethodBeat.o(147965);
      return;
      this.b.b(this.c.b);
      break;
      label112:
      this.b.b("done");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.tencentmap.mapsdk.maps.a.fv.a
 * JD-Core Version:    0.7.0.1
 */