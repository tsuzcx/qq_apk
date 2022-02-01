package d.n;

import com.tencent.matrix.trace.core.AppMethodBeat;
import d.k.f;
import d.l;

@l(gjZ={1, 1, 16}, gka={""}, gkb={"category", "Lkotlin/text/CharCategory;", "", "getCategory", "(C)Lkotlin/text/CharCategory;", "directionality", "Lkotlin/text/CharDirectionality;", "getDirectionality", "(C)Lkotlin/text/CharDirectionality;", "checkRadix", "", "radix", "digitOf", "char", "isDefined", "", "isDigit", "isHighSurrogate", "isISOControl", "isIdentifierIgnorable", "isJavaIdentifierPart", "isJavaIdentifierStart", "isLetter", "isLetterOrDigit", "isLowSurrogate", "isLowerCase", "isTitleCase", "isUpperCase", "isWhitespace", "toLowerCase", "toTitleCase", "toUpperCase", "kotlin-stdlib"}, gkc=1)
public class b
{
  public static final int ami(int paramInt)
  {
    AppMethodBeat.i(129422);
    if ((2 > paramInt) || (36 < paramInt))
    {
      Throwable localThrowable = (Throwable)new IllegalArgumentException("radix " + paramInt + " was not in valid range " + new f(2, 36));
      AppMethodBeat.o(129422);
      throw localThrowable;
    }
    AppMethodBeat.o(129422);
    return paramInt;
  }
  
  public static final boolean isWhitespace(char paramChar)
  {
    AppMethodBeat.i(129421);
    if ((Character.isWhitespace(paramChar)) || (Character.isSpaceChar(paramChar)))
    {
      AppMethodBeat.o(129421);
      return true;
    }
    AppMethodBeat.o(129421);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     d.n.b
 * JD-Core Version:    0.7.0.1
 */