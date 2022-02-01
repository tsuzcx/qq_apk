package rx.internal.util;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.io.PrintStream;
import java.util.Queue;
import rx.internal.a.c;
import rx.j;

public final class f
  implements j
{
  private static final c<Object> KrI;
  public static final d<Queue<Object>> KrK;
  public static final d<Queue<Object>> KrL;
  public static final int SIZE;
  static int sok;
  private final d<Queue<Object>> KrJ;
  private Queue<Object> cWm;
  
  static
  {
    AppMethodBeat.i(90197);
    KrI = c.fNC();
    sok = 128;
    if (e.isAndroid()) {
      sok = 16;
    }
    String str = System.getProperty("rx.ring-buffer.size");
    if (str != null) {}
    try
    {
      sok = Integer.parseInt(str);
      SIZE = sok;
      KrK = new d() {};
      KrL = new d() {};
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
  
  public final void fNw()
  {
    AppMethodBeat.i(90196);
    Queue localQueue = this.cWm;
    d locald = this.KrJ;
    if ((locald != null) && (localQueue != null))
    {
      localQueue.clear();
      this.cWm = null;
      if (localQueue != null) {
        locald.aGt.offer(localQueue);
      }
    }
    AppMethodBeat.o(90196);
  }
  
  public final boolean fNx()
  {
    return this.cWm == null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     rx.internal.util.f
 * JD-Core Version:    0.7.0.1
 */