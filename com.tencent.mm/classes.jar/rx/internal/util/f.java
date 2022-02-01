package rx.internal.util;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.io.PrintStream;
import java.util.Queue;
import rx.internal.a.c;
import rx.j;

public final class f
  implements j
{
  static int IXY;
  private static final c<Object> akdA;
  public static final int akdB;
  public static final d<Queue<Object>> akdC;
  public static final d<Queue<Object>> akdD;
  
  static
  {
    AppMethodBeat.i(90197);
    akdA = c.kKn();
    IXY = 128;
    if (e.isAndroid()) {
      IXY = 16;
    }
    String str = System.getProperty("rx.ring-buffer.size");
    if (str != null) {}
    try
    {
      IXY = Integer.parseInt(str);
      akdB = IXY;
      akdC = new d() {};
      akdD = new d() {};
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
  
  public final void kKh()
  {
    AppMethodBeat.i(90196);
    AppMethodBeat.o(90196);
    throw null;
  }
  
  public final boolean kKi()
  {
    throw null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes11.jar
 * Qualified Name:     rx.internal.util.f
 * JD-Core Version:    0.7.0.1
 */