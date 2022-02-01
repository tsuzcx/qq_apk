package kotlinx.a.c.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.l;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lkotlinx/serialization/json/internal/EscapeCharMappings;", "", "()V", "ESCAPE_2_CHAR", "", "initC2ESC", "", "c", "", "esc", "", "kotlinx-serialization-runtime"})
public final class c
{
  public static final char[] Uah;
  public static final c Uai;
  
  static
  {
    AppMethodBeat.i(225712);
    Uai = new c();
    Uah = new char[117];
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
    AppMethodBeat.o(225712);
  }
  
  private static void a(int paramInt, char paramChar)
  {
    if (paramChar != 'u') {
      Uah[paramChar] = ((char)paramInt);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     kotlinx.a.c.a.c
 * JD-Core Version:    0.7.0.1
 */