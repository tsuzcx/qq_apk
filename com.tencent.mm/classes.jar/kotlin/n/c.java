package kotlin.n;

import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.Metadata;

@Metadata(d1={""}, d2={"digitToChar", "", "", "radix", "digitToInt", "digitToIntOrNull", "(C)Ljava/lang/Integer;", "(CI)Ljava/lang/Integer;", "equals", "", "other", "ignoreCase", "isSurrogate", "plus", "", "titlecase", "kotlin-stdlib"}, k=5, mv={1, 5, 1}, xi=1, xs="kotlin/text/CharsKt")
public class c
  extends b
{
  public static final boolean J(char paramChar)
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
    paramChar1 = Character.toUpperCase(paramChar1);
    paramChar2 = Character.toUpperCase(paramChar2);
    if ((paramChar1 == paramChar2) || (Character.toLowerCase(paramChar1) == Character.toLowerCase(paramChar2)))
    {
      AppMethodBeat.o(129450);
      return true;
    }
    AppMethodBeat.o(129450);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     kotlin.n.c
 * JD-Core Version:    0.7.0.1
 */