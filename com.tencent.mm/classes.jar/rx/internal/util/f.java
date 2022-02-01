package rx.internal.util;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.io.PrintStream;
import java.util.Queue;
import rx.internal.a.c;
import rx.j;

public final class f
  implements j
{
  public static final d<Queue<Object>> OxA;
  public static final d<Queue<Object>> OxB;
  private static final c<Object> Oxy;
  public static final int SIZE;
  static int uGO;
  private final d<Queue<Object>> Oxz;
  private Queue<Object> dga;
  
  static
  {
    AppMethodBeat.i(90197);
    Oxy = c.gDy();
    uGO = 128;
    if (e.isAndroid()) {
      uGO = 16;
    }
    String str = System.getProperty("rx.ring-buffer.size");
    if (str != null) {}
    try
    {
      uGO = Integer.parseInt(str);
      SIZE = uGO;
      OxA = new d() {};
      OxB = new d() {};
      AppMethodBeat.o(90197);
      return;
    }
    catch (NumberFormatException localNumberFormatException)
    {
      for (;;)
      {
        System.err.println("Failed to set 'rx.buffer.size' with value " + str + " => " + localNumberFormatException.getMessage());
      }
    }
  }
  
  public final void gDs()
  {
    AppMethodBeat.i(90196);
    Queue localQueue = this.dga;
    d locald = this.Oxz;
    if ((locald != null) && (localQueue != null))
    {
      localQueue.clear();
      this.dga = null;
      if (localQueue != null) {
        locald.aJa.offer(localQueue);
      }
    }
    AppMethodBeat.o(90196);
  }
  
  public final boolean gDt()
  {
    return this.dga == null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     rx.internal.util.f
 * JD-Core Version:    0.7.0.1
 */