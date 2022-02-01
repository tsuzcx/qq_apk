package rx.internal.util;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.io.PrintStream;
import java.util.Queue;
import rx.internal.a.c;
import rx.j;

public final class f
  implements j
{
  private static final c<Object> Oat;
  public static final d<Queue<Object>> Oav;
  public static final d<Queue<Object>> Oaw;
  public static final int SIZE;
  static int uvp;
  private final d<Queue<Object>> Oau;
  private Queue<Object> deY;
  
  static
  {
    AppMethodBeat.i(90197);
    Oat = c.gyW();
    uvp = 128;
    if (e.isAndroid()) {
      uvp = 16;
    }
    String str = System.getProperty("rx.ring-buffer.size");
    if (str != null) {}
    try
    {
      uvp = Integer.parseInt(str);
      SIZE = uvp;
      Oav = new d() {};
      Oaw = new d() {};
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
  
  public final void gyQ()
  {
    AppMethodBeat.i(90196);
    Queue localQueue = this.deY;
    d locald = this.Oau;
    if ((locald != null) && (localQueue != null))
    {
      localQueue.clear();
      this.deY = null;
      if (localQueue != null) {
        locald.aJa.offer(localQueue);
      }
    }
    AppMethodBeat.o(90196);
  }
  
  public final boolean gyR()
  {
    return this.deY == null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     rx.internal.util.f
 * JD-Core Version:    0.7.0.1
 */