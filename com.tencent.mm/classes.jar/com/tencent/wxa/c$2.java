package com.tencent.wxa;

import com.tencent.matrix.trace.core.AppMethodBeat;
import io.flutter.embedding.engine.FlutterEngine;

public final class c$2
  implements Runnable
{
  public c$2(c paramc, int paramInt) {}
  
  public final void run()
  {
    AppMethodBeat.i(210468);
    if ((c.a(this.aidy) != null) && (this.aidy.d(c.a(this.aidy)) == this.aidz))
    {
      c.a(this.aidy).destroy();
      c.b(this.aidy);
    }
    if (c.c(this.aidy) != null)
    {
      c.c(this.aidy).destroy();
      c.d(this.aidy);
    }
    AppMethodBeat.o(210468);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.wxa.c.2
 * JD-Core Version:    0.7.0.1
 */