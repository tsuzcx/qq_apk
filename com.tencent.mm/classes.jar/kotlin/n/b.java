package kotlin.n;

import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.Metadata;
import kotlin.k.g;

@Metadata(d1={""}, d2={"category", "Lkotlin/text/CharCategory;", "", "getCategory", "(C)Lkotlin/text/CharCategory;", "directionality", "Lkotlin/text/CharDirectionality;", "getDirectionality", "(C)Lkotlin/text/CharDirectionality;", "checkRadix", "", "radix", "digitOf", "char", "isDefined", "", "isDigit", "isHighSurrogate", "isISOControl", "isIdentifierIgnorable", "isJavaIdentifierPart", "isJavaIdentifierStart", "isLetter", "isLetterOrDigit", "isLowSurrogate", "isLowerCase", "isTitleCase", "isUpperCase", "isWhitespace", "lowercase", "", "locale", "Ljava/util/Locale;", "lowercaseChar", "titlecase", "titlecaseChar", "toLowerCase", "toTitleCase", "toUpperCase", "uppercase", "uppercaseChar", "kotlin-stdlib"}, k=5, mv={1, 5, 1}, xi=1, xs="kotlin/text/CharsKt")
public class b
{
  public static final boolean I(char paramChar)
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
  
  public static final int aMy(int paramInt)
  {
    AppMethodBeat.i(129422);
    if ((2 > paramInt) || (36 < paramInt))
    {
      Throwable localThrowable = (Throwable)new IllegalArgumentException("radix " + paramInt + " was not in valid range " + new g(2, 36));
      AppMethodBeat.o(129422);
      throw localThrowable;
    }
    AppMethodBeat.o(129422);
    return paramInt;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     kotlin.n.b
 * JD-Core Version:    0.7.0.1
 */