package kotlinx.a.c.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lkotlinx/serialization/json/internal/EscapeCharMappings;", "", "()V", "ESCAPE_2_CHAR", "", "initC2ESC", "", "c", "", "esc", "", "kotlinx-serialization-runtime"})
public final class c
{
  public static final char[] abDv;
  public static final c abDw;
  
  static
  {
    AppMethodBeat.i(256153);
    abDw = new c();
    abDv = new char[117];
    int i = 0;
    while (i <= 31)
    {
      a(i, 'u');
      i += 1;
    }
    a(8, 'b');
    a(9, 't');
    a(10, 'n');
    a(12, 'f');
    a(13, 'r');
    a(47, '/');
    a(34, '"');
    a(92, '\\');
    AppMethodBeat.o(256153);
  }
  
  private static void a(int paramInt, char paramChar)
  {
    if (paramChar != 'u') {
      abDv[paramChar] = ((char)paramInt);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     kotlinx.a.c.a.c
 * JD-Core Version:    0.7.0.1
 */