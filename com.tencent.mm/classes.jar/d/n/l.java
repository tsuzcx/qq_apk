package d.n;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.regex.Matcher;

@d.l(gjZ={1, 1, 16}, gka={""}, gkb={"fromInt", "", "T", "Lkotlin/text/FlagEnum;", "", "value", "", "findNext", "Lkotlin/text/MatchResult;", "Ljava/util/regex/Matcher;", "from", "input", "", "matchEntire", "range", "Lkotlin/ranges/IntRange;", "Ljava/util/regex/MatchResult;", "groupIndex", "toInt", "", "kotlin-stdlib"})
public final class l
{
  static final i a(Matcher paramMatcher, CharSequence paramCharSequence)
  {
    AppMethodBeat.i(129439);
    if (!paramMatcher.find(0))
    {
      AppMethodBeat.o(129439);
      return null;
    }
    paramMatcher = (i)new j(paramMatcher, paramCharSequence);
    AppMethodBeat.o(129439);
    return paramMatcher;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     d.n.l
 * JD-Core Version:    0.7.0.1
 */