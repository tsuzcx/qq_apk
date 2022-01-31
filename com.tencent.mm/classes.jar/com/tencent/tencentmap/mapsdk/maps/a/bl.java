package com.tencent.tencentmap.mapsdk.maps.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

final class bl
  implements Runnable
{
  bl(bg parambg) {}
  
  public final void run()
  {
    AppMethodBeat.i(147295);
    if (bg.f(this.a).size() == 0)
    {
      bg.g(this.a).incrementAndGet();
      bg.a(this.a, false, true);
      AppMethodBeat.o(147295);
      return;
    }
    bg.b(this.a, true, true);
    AppMethodBeat.o(147295);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.tencentmap.mapsdk.maps.a.bl
 * JD-Core Version:    0.7.0.1
 */