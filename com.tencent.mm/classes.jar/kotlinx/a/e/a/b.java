package kotlinx.a.e.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.Metadata;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lkotlinx/serialization/json/internal/EscapeCharMappings;", "", "()V", "ESCAPE_2_CHAR", "", "initC2ESC", "", "c", "", "esc", "", "kotlinx-serialization-runtime"}, k=1, mv={1, 4, 0})
public final class b
{
  public static final char[] ajEo;
  public static final b ajEp;
  
  static
  {
    AppMethodBeat.i(188522);
    ajEp = new b();
    ajEo = new char[117];
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
    AppMethodBeat.o(188522);
  }
  
  private static void a(int paramInt, char paramChar)
  {
    if (paramChar != 'u') {
      ajEo[paramChar] = ((char)paramInt);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     kotlinx.a.e.a.b
 * JD-Core Version:    0.7.0.1
 */