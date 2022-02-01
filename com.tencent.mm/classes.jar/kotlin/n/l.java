package kotlin.n;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.regex.Matcher;
import kotlin.Metadata;

@Metadata(d1={""}, d2={"fromInt", "", "T", "Lkotlin/text/FlagEnum;", "", "value", "", "findNext", "Lkotlin/text/MatchResult;", "Ljava/util/regex/Matcher;", "from", "input", "", "matchEntire", "range", "Lkotlin/ranges/IntRange;", "Ljava/util/regex/MatchResult;", "groupIndex", "toInt", "", "kotlin-stdlib"}, k=2, mv={1, 5, 1})
public final class l
{
  static final i a(Matcher paramMatcher, int paramInt, CharSequence paramCharSequence)
  {
    AppMethodBeat.i(190911);
    if (!paramMatcher.find(paramInt))
    {
      AppMethodBeat.o(190911);
      return null;
    }
    paramMatcher = (i)new j(paramMatcher, paramCharSequence);
    AppMethodBeat.o(190911);
    return paramMatcher;
  }
  
  static final i a(Matcher paramMatcher, CharSequence paramCharSequence)
  {
    AppMethodBeat.i(190914);
    if (!paramMatcher.matches())
    {
      AppMethodBeat.o(190914);
      return null;
    }
    paramMatcher = (i)new j(paramMatcher, paramCharSequence);
    AppMethodBeat.o(190914);
    return paramMatcher;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     kotlin.n.l
 * JD-Core Version:    0.7.0.1
 */