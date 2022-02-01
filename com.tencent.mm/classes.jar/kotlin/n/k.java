package kotlin.n;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import kotlin.a.j;
import kotlin.g.b.p;

@kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"Lkotlin/text/Regex;", "Ljava/io/Serializable;", "Lkotlin/io/Serializable;", "pattern", "", "(Ljava/lang/String;)V", "option", "Lkotlin/text/RegexOption;", "(Ljava/lang/String;Lkotlin/text/RegexOption;)V", "options", "", "(Ljava/lang/String;Ljava/util/Set;)V", "nativePattern", "Ljava/util/regex/Pattern;", "(Ljava/util/regex/Pattern;)V", "_options", "getOptions", "()Ljava/util/Set;", "getPattern", "()Ljava/lang/String;", "containsMatchIn", "", "input", "", "find", "Lkotlin/text/MatchResult;", "startIndex", "", "findAll", "Lkotlin/sequences/Sequence;", "matchEntire", "matches", "replace", "transform", "Lkotlin/Function1;", "replacement", "replaceFirst", "split", "", "limit", "toPattern", "toString", "writeReplace", "", "Companion", "Serialized", "kotlin-stdlib"})
public final class k
  implements Serializable
{
  public static final a abvK;
  private final Pattern abvJ;
  
  static
  {
    AppMethodBeat.i(129433);
    abvK = new a((byte)0);
    AppMethodBeat.o(129433);
  }
  
  public k(String paramString)
  {
    this(paramString);
    AppMethodBeat.i(129432);
    AppMethodBeat.o(129432);
  }
  
  public k(Pattern paramPattern)
  {
    AppMethodBeat.i(129431);
    this.abvJ = paramPattern;
    AppMethodBeat.o(129431);
  }
  
  private final Object writeReplace()
  {
    AppMethodBeat.i(129430);
    Object localObject = this.abvJ.pattern();
    p.j(localObject, "nativePattern.pattern()");
    localObject = new b((String)localObject, this.abvJ.flags());
    AppMethodBeat.o(129430);
    return localObject;
  }
  
  public final boolean aY(CharSequence paramCharSequence)
  {
    AppMethodBeat.i(129423);
    p.k(paramCharSequence, "input");
    boolean bool = this.abvJ.matcher(paramCharSequence).matches();
    AppMethodBeat.o(129423);
    return bool;
  }
  
  public final i aZ(CharSequence paramCharSequence)
  {
    AppMethodBeat.i(218158);
    p.k(paramCharSequence, "input");
    Matcher localMatcher = this.abvJ.matcher(paramCharSequence);
    p.j(localMatcher, "nativePattern.matcher(input)");
    paramCharSequence = l.a(localMatcher, paramCharSequence);
    AppMethodBeat.o(218158);
    return paramCharSequence;
  }
  
  public final String e(CharSequence paramCharSequence, String paramString)
  {
    AppMethodBeat.i(129426);
    p.k(paramCharSequence, "input");
    p.k(paramString, "replacement");
    paramCharSequence = this.abvJ.matcher(paramCharSequence).replaceAll(paramString);
    p.j(paramCharSequence, "nativePattern.matcher(in…).replaceAll(replacement)");
    AppMethodBeat.o(129426);
    return paramCharSequence;
  }
  
  public final String f(CharSequence paramCharSequence, String paramString)
  {
    AppMethodBeat.i(129427);
    p.k(paramCharSequence, "input");
    p.k(paramString, "replacement");
    paramCharSequence = this.abvJ.matcher(paramCharSequence).replaceFirst(paramString);
    p.j(paramCharSequence, "nativePattern.matcher(in…replaceFirst(replacement)");
    AppMethodBeat.o(129427);
    return paramCharSequence;
  }
  
  public final i t(CharSequence paramCharSequence, int paramInt)
  {
    AppMethodBeat.i(218155);
    p.k(paramCharSequence, "input");
    Matcher localMatcher = this.abvJ.matcher(paramCharSequence);
    p.j(localMatcher, "nativePattern.matcher(input)");
    paramCharSequence = l.a(localMatcher, paramInt, paramCharSequence);
    AppMethodBeat.o(218155);
    return paramCharSequence;
  }
  
  public final String toString()
  {
    AppMethodBeat.i(129429);
    String str = this.abvJ.toString();
    p.j(str, "nativePattern.toString()");
    AppMethodBeat.o(129429);
    return str;
  }
  
  public final List<String> u(CharSequence paramCharSequence, int paramInt)
  {
    int j = 10;
    AppMethodBeat.i(129428);
    p.k(paramCharSequence, "input");
    if (paramInt >= 0) {}
    for (int i = 1; i == 0; i = 0)
    {
      paramCharSequence = (Throwable)new IllegalArgumentException(("Limit must be non-negative, but was " + paramInt + '.').toString());
      AppMethodBeat.o(129428);
      throw paramCharSequence;
    }
    Matcher localMatcher = this.abvJ.matcher(paramCharSequence);
    if ((!localMatcher.find()) || (paramInt == 1))
    {
      paramCharSequence = j.listOf(paramCharSequence.toString());
      AppMethodBeat.o(129428);
      return paramCharSequence;
    }
    i = j;
    if (paramInt > 0) {
      i = kotlin.k.i.ow(paramInt, 10);
    }
    ArrayList localArrayList = new ArrayList(i);
    j = paramInt - 1;
    paramInt = 0;
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
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"Lkotlin/text/Regex$Companion;", "", "()V", "ensureUnicodeCase", "", "flags", "escape", "", "literal", "escapeReplacement", "fromLiteral", "Lkotlin/text/Regex;", "kotlin-stdlib"})
  public static final class a {}
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"Lkotlin/text/Regex$Serialized;", "Ljava/io/Serializable;", "Lkotlin/io/Serializable;", "pattern", "", "flags", "", "(Ljava/lang/String;I)V", "getFlags", "()I", "getPattern", "()Ljava/lang/String;", "readResolve", "", "Companion", "kotlin-stdlib"})
  static final class b
    implements Serializable
  {
    public static final a abvL;
    private final int flags;
    private final String pattern;
    
    static
    {
      AppMethodBeat.i(129358);
      abvL = new a((byte)0);
      AppMethodBeat.o(129358);
    }
    
    public b(String paramString, int paramInt)
    {
      AppMethodBeat.i(129357);
      this.pattern = paramString;
      this.flags = paramInt;
      AppMethodBeat.o(129357);
    }
    
    private final Object readResolve()
    {
      AppMethodBeat.i(129356);
      Object localObject = Pattern.compile(this.pattern, this.flags);
      p.j(localObject, "Pattern.compile(pattern, flags)");
      localObject = new k((Pattern)localObject);
      AppMethodBeat.o(129356);
      return localObject;
    }
    
    @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"Lkotlin/text/Regex$Serialized$Companion;", "", "()V", "serialVersionUID", "", "kotlin-stdlib"})
    public static final class a {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     kotlin.n.k
 * JD-Core Version:    0.7.0.1
 */