package rx.internal.util;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.io.PrintStream;
import java.util.Queue;
import rx.internal.a.c;
import rx.j;

public final class f
  implements j
{
  public static final int SIZE;
  private static final c<Object> Unm;
  public static final d<Queue<Object>> Uno;
  public static final d<Queue<Object>> Unp;
  static int xZa;
  private final d<Queue<Object>> Unn;
  private Queue<Object> dxk;
  
  static
  {
    AppMethodBeat.i(90197);
    Unm = c.hQG();
    xZa = 128;
    if (e.isAndroid()) {
      xZa = 16;
    }
    String str = System.getProperty("rx.ring-buffer.size");
    if (str != null) {}
    try
    {
      xZa = Integer.parseInt(str);
      SIZE = xZa;
      Uno = new d() {};
      Unp = new d() {};
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
  
  public final void hQA()
  {
    AppMethodBeat.i(90196);
    Queue localQueue = this.dxk;
    d locald = this.Unn;
    if ((locald != null) && (localQueue != null))
    {
      localQueue.clear();
      this.dxk = null;
      if (localQueue != null) {
        locald.aIT.offer(localQueue);
      }
    }
    AppMethodBeat.o(90196);
  }
  
  public final boolean hQB()
  {
    return this.dxk == null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     rx.internal.util.f
 * JD-Core Version:    0.7.0.1
 */