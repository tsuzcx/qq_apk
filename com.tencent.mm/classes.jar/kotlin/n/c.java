package kotlin.n;

import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"equals", "", "", "other", "ignoreCase", "isSurrogate", "plus", "", "kotlin-stdlib"}, iBN=1)
public class c
  extends b
{
  public static final boolean P(char paramChar)
  {
    if (55296 > paramChar) {}
    while (57343 < paramChar) {
      return false;
    }
    return true;
  }
  
  public static final boolean a(char paramChar1, char paramChar2, boolean paramBoolean)
  {
    AppMethodBeat.i(129450);
    if (paramChar1 == paramChar2)
    {
      AppMethodBeat.o(129450);
      return true;
    }
    if (!paramBoolean)
    {
      AppMethodBeat.o(129450);
      return false;
    }
    if (Character.toUpperCase(paramChar1) == Character.toUpperCase(paramChar2))
    {
      AppMethodBeat.o(129450);
      return true;
    }
    if (Character.toLowerCase(paramChar1) == Character.toLowerCase(paramChar2))
    {
      AppMethodBeat.o(129450);
      return true;
    }
    AppMethodBeat.o(129450);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     kotlin.n.c
 * JD-Core Version:    0.7.0.1
 */