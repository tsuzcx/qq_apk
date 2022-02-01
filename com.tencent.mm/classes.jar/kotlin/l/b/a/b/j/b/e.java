package kotlin.l.b.a.b.j.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Arrays;

public final class e
  extends p<Character>
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
    int i;
    String str;
    switch (c)
    {
    case '\013': 
    default: 
      i = (byte)Character.getType(c);
      if ((i != 0) && (i != 13) && (i != 14) && (i != 15) && (i != 16) && (i != 18) && (i != 19))
      {
        i = 1;
        if (i == 0) {
          break label208;
        }
        str = String.valueOf(c);
      }
      break;
    }
    for (;;)
    {
      str = String.format("\\u%04X ('%s')", Arrays.copyOf(new Object[] { Integer.valueOf(j), str }, 2));
      kotlin.g.b.p.g(str, "java.lang.String.format(this, *args)");
      AppMethodBeat.o(60048);
      return str;
      str = "\\b";
      continue;
      str = "\\t";
      continue;
      str = "\\n";
      continue;
      str = "\\f";
      continue;
      str = "\\r";
      continue;
      i = 0;
      break;
      label208:
      str = "?";
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     kotlin.l.b.a.b.j.b.e
 * JD-Core Version:    0.7.0.1
 */