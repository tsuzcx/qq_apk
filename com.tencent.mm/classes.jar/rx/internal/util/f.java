package rx.internal.util;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.io.PrintStream;
import java.util.Queue;
import rx.internal.a.c;
import rx.j;

public final class f
  implements j
{
  static int DdH;
  private static final c<Object> abQI;
  public static final int abQJ;
  public static final d<Queue<Object>> abQK;
  public static final d<Queue<Object>> abQL;
  
  static
  {
    AppMethodBeat.i(90197);
    abQI = c.iVP();
    DdH = 128;
    if (e.isAndroid()) {
      DdH = 16;
    }
    String str = System.getProperty("rx.ring-buffer.size");
    if (str != null) {}
    try
    {
      DdH = Integer.parseInt(str);
      abQJ = DdH;
      abQK = new d() {};
      abQL = new d() {};
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
  
  public final void iVJ()
  {
    AppMethodBeat.i(90196);
    AppMethodBeat.o(90196);
    throw null;
  }
  
  public final boolean iVK()
  {
    throw null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     rx.internal.util.f
 * JD-Core Version:    0.7.0.1
 */