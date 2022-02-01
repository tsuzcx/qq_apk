package rx.internal.util;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.io.PrintStream;
import java.util.Queue;
import rx.internal.a.c;
import rx.j;

public final class f
  implements j
{
  private static final c<Object> Mfr;
  public static final d<Queue<Object>> Mft;
  public static final d<Queue<Object>> Mfu;
  public static final int SIZE;
  static int twd;
  private final d<Queue<Object>> Mfs;
  private Queue<Object> cTI;
  
  static
  {
    AppMethodBeat.i(90197);
    Mfr = c.ggs();
    twd = 128;
    if (e.isAndroid()) {
      twd = 16;
    }
    String str = System.getProperty("rx.ring-buffer.size");
    if (str != null) {}
    try
    {
      twd = Integer.parseInt(str);
      SIZE = twd;
      Mft = new d() {};
      Mfu = new d() {};
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
  
  public final void ggm()
  {
    AppMethodBeat.i(90196);
    Queue localQueue = this.cTI;
    d locald = this.Mfs;
    if ((locald != null) && (localQueue != null))
    {
      localQueue.clear();
      this.cTI = null;
      if (localQueue != null) {
        locald.aHj.offer(localQueue);
      }
    }
    AppMethodBeat.o(90196);
  }
  
  public final boolean ggn()
  {
    return this.cTI == null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     rx.internal.util.f
 * JD-Core Version:    0.7.0.1
 */