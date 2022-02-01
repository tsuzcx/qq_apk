package kotlin.n;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.regex.Matcher;

@kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"fromInt", "", "T", "Lkotlin/text/FlagEnum;", "", "value", "", "findNext", "Lkotlin/text/MatchResult;", "Ljava/util/regex/Matcher;", "from", "input", "", "matchEntire", "range", "Lkotlin/ranges/IntRange;", "Ljava/util/regex/MatchResult;", "groupIndex", "toInt", "", "kotlin-stdlib"})
public final class l
{
  static final i a(Matcher paramMatcher, int paramInt, CharSequence paramCharSequence)
  {
    AppMethodBeat.i(206248);
    if (!paramMatcher.find(paramInt))
    {
      AppMethodBeat.o(206248);
      return null;
    }
    paramMatcher = (i)new j(paramMatcher, paramCharSequence);
    AppMethodBeat.o(206248);
    return paramMatcher;
  }
  
  static final i a(Matcher paramMatcher, CharSequence paramCharSequence)
  {
    AppMethodBeat.i(206249);
    if (!paramMatcher.matches())
    {
      AppMethodBeat.o(206249);
      return null;
    }
    paramMatcher = (i)new j(paramMatcher, paramCharSequence);
    AppMethodBeat.o(206249);
    return paramMatcher;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     kotlin.n.l
 * JD-Core Version:    0.7.0.1
 */