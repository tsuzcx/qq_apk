package kotlin.n;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import kotlin.Metadata;
import kotlin.a.p;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lkotlin/text/Regex;", "Ljava/io/Serializable;", "Lkotlin/io/Serializable;", "pattern", "", "(Ljava/lang/String;)V", "option", "Lkotlin/text/RegexOption;", "(Ljava/lang/String;Lkotlin/text/RegexOption;)V", "options", "", "(Ljava/lang/String;Ljava/util/Set;)V", "nativePattern", "Ljava/util/regex/Pattern;", "(Ljava/util/regex/Pattern;)V", "_options", "getOptions", "()Ljava/util/Set;", "getPattern", "()Ljava/lang/String;", "containsMatchIn", "", "input", "", "find", "Lkotlin/text/MatchResult;", "startIndex", "", "findAll", "Lkotlin/sequences/Sequence;", "matchAt", "index", "matchEntire", "matches", "matchesAt", "replace", "transform", "Lkotlin/Function1;", "replacement", "replaceFirst", "split", "", "limit", "splitToSequence", "toPattern", "toString", "writeReplace", "", "Companion", "Serialized", "kotlin-stdlib"}, k=1, mv={1, 5, 1})
public final class k
  implements Serializable
{
  public static final k.a ajuS;
  public final Pattern ajuR;
  
  static
  {
    AppMethodBeat.i(129433);
    ajuS = new k.a((byte)0);
    AppMethodBeat.o(129433);
  }
  
  public k(String paramString)
  {
    this(paramString);
    AppMethodBeat.i(129432);
    AppMethodBeat.o(129432);
  }
  
  private k(Pattern paramPattern)
  {
    AppMethodBeat.i(129431);
    this.ajuR = paramPattern;
    AppMethodBeat.o(129431);
  }
  
  public final boolean bm(CharSequence paramCharSequence)
  {
    AppMethodBeat.i(129423);
    s.u(paramCharSequence, "input");
    boolean bool = this.ajuR.matcher(paramCharSequence).matches();
    AppMethodBeat.o(129423);
    return bool;
  }
  
  public final boolean bn(CharSequence paramCharSequence)
  {
    AppMethodBeat.i(190935);
    s.u(paramCharSequence, "input");
    boolean bool = this.ajuR.matcher(paramCharSequence).find();
    AppMethodBeat.o(190935);
    return bool;
  }
  
  public final i bo(CharSequence paramCharSequence)
  {
    AppMethodBeat.i(190940);
    s.u(paramCharSequence, "input");
    Matcher localMatcher = this.ajuR.matcher(paramCharSequence);
    s.s(localMatcher, "nativePattern.matcher(input)");
    paramCharSequence = l.a(localMatcher, paramCharSequence);
    AppMethodBeat.o(190940);
    return paramCharSequence;
  }
  
  public final String e(CharSequence paramCharSequence, String paramString)
  {
    AppMethodBeat.i(129426);
    s.u(paramCharSequence, "input");
    s.u(paramString, "replacement");
    paramCharSequence = this.ajuR.matcher(paramCharSequence).replaceAll(paramString);
    s.s(paramCharSequence, "nativePattern.matcher(in…).replaceAll(replacement)");
    AppMethodBeat.o(129426);
    return paramCharSequence;
  }
  
  public final String f(CharSequence paramCharSequence, String paramString)
  {
    AppMethodBeat.i(129427);
    s.u(paramCharSequence, "input");
    s.u(paramString, "replacement");
    paramCharSequence = this.ajuR.matcher(paramCharSequence).replaceFirst(paramString);
    s.s(paramCharSequence, "nativePattern.matcher(in…replaceFirst(replacement)");
    AppMethodBeat.o(129427);
    return paramCharSequence;
  }
  
  public final i n(CharSequence paramCharSequence, int paramInt)
  {
    AppMethodBeat.i(190937);
    s.u(paramCharSequence, "input");
    Matcher localMatcher = this.ajuR.matcher(paramCharSequence);
    s.s(localMatcher, "nativePattern.matcher(input)");
    paramCharSequence = l.a(localMatcher, paramInt, paramCharSequence);
    AppMethodBeat.o(190937);
    return paramCharSequence;
  }
  
  public final List<String> o(CharSequence paramCharSequence, int paramInt)
  {
    int i = 10;
    AppMethodBeat.i(129428);
    s.u(paramCharSequence, "input");
    n.aMA(paramInt);
    Matcher localMatcher = this.ajuR.matcher(paramCharSequence);
    if ((paramInt == 1) || (!localMatcher.find()))
    {
      paramCharSequence = p.listOf(paramCharSequence.toString());
      AppMethodBeat.o(129428);
      return paramCharSequence;
    }
    if (paramInt > 0) {
      i = kotlin.k.k.qv(paramInt, 10);
    }
    ArrayList localArrayList = new ArrayList(i);
    i = 0;
    int j = paramInt - 1;
    paramInt = i;
    do
    {
      localArrayList.add(paramCharSequence.subSequence(paramInt, localMatcher.start()).toString());
      i = localMatcher.end();
      if ((j >= 0) && (localArrayList.size() == j)) {
        break;
      }
      paramInt = i;
    } while (localMatcher.find());
    localArrayList.add(paramCharSequence.subSequence(i, paramCharSequence.length()).toString());
    paramCharSequence = (List)localArrayList;
    AppMethodBeat.o(129428);
    return paramCharSequence;
  }
  
  public final String toString()
  {
    AppMethodBeat.i(129429);
    String str = this.ajuR.toString();
    s.s(str, "nativePattern.toString()");
    AppMethodBeat.o(129429);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     kotlin.n.k
 * JD-Core Version:    0.7.0.1
 */