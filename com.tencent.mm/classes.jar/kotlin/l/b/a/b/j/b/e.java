package kotlin.l.b.a.b.j.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Arrays;
import kotlin.g.b.s;

public final class e
  extends o<Character>
{
  public e(char paramChar)
  {
    super(Character.valueOf(paramChar));
    AppMethodBeat.i(60049);
    AppMethodBeat.o(60049);
  }
  
  public final String toString()
  {
    AppMethodBeat.i(60048);
    int j = ((Character)getValue()).charValue();
    char c = ((Character)getValue()).charValue();
    String str;
    if (c == '\b') {
      str = "\\b";
    }
    for (;;)
    {
      str = String.format("\\u%04X ('%s')", Arrays.copyOf(new Object[] { Integer.valueOf(j), str }, 2));
      s.s(str, "java.lang.String.format(this, *args)");
      AppMethodBeat.o(60048);
      return str;
      if (c == '\t')
      {
        str = "\\t";
      }
      else if (c == '\n')
      {
        str = "\\n";
      }
      else if (c == '\f')
      {
        str = "\\f";
      }
      else if (c == '\r')
      {
        str = "\\r";
      }
      else
      {
        int i = (byte)Character.getType(c);
        if ((i != 0) && (i != 13) && (i != 14) && (i != 15) && (i != 16) && (i != 18) && (i != 19)) {}
        for (i = 1;; i = 0)
        {
          if (i == 0) {
            break label197;
          }
          str = String.valueOf(c);
          break;
        }
        label197:
        str = "?";
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes11.jar
 * Qualified Name:     kotlin.l.b.a.b.j.b.e
 * JD-Core Version:    0.7.0.1
 */