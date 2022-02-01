package d.n;

import com.tencent.matrix.trace.core.AppMethodBeat;
import d.a.j;
import d.g.b.p;
import d.k.h;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@d.l(gfx={1, 1, 16}, gfy={""}, gfz={"Lkotlin/text/Regex;", "Ljava/io/Serializable;", "Lkotlin/io/Serializable;", "pattern", "", "(Ljava/lang/String;)V", "option", "Lkotlin/text/RegexOption;", "(Ljava/lang/String;Lkotlin/text/RegexOption;)V", "options", "", "(Ljava/lang/String;Ljava/util/Set;)V", "nativePattern", "Ljava/util/regex/Pattern;", "(Ljava/util/regex/Pattern;)V", "_options", "getOptions", "()Ljava/util/Set;", "getPattern", "()Ljava/lang/String;", "containsMatchIn", "", "input", "", "find", "Lkotlin/text/MatchResult;", "startIndex", "", "findAll", "Lkotlin/sequences/Sequence;", "matchEntire", "matches", "replace", "transform", "Lkotlin/Function1;", "replacement", "replaceFirst", "split", "", "limit", "toPattern", "toString", "writeReplace", "", "Companion", "Serialized", "kotlin-stdlib"})
public final class k
  implements Serializable
{
  public static final a NHh;
  public final Pattern NHg;
  
  static
  {
    AppMethodBeat.i(129433);
    NHh = new a((byte)0);
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
    this.NHg = paramPattern;
    AppMethodBeat.o(129431);
  }
  
  private final Object writeReplace()
  {
    AppMethodBeat.i(129430);
    Object localObject = this.NHg.pattern();
    p.g(localObject, "nativePattern.pattern()");
    localObject = new b((String)localObject, this.NHg.flags());
    AppMethodBeat.o(129430);
    return localObject;
  }
  
  public final boolean aC(CharSequence paramCharSequence)
  {
    AppMethodBeat.i(129423);
    p.h(paramCharSequence, "input");
    boolean bool = this.NHg.matcher(paramCharSequence).matches();
    AppMethodBeat.o(129423);
    return bool;
  }
  
  public final i aD(CharSequence paramCharSequence)
  {
    AppMethodBeat.i(129424);
    p.h(paramCharSequence, "input");
    Matcher localMatcher = this.NHg.matcher(paramCharSequence);
    p.g(localMatcher, "nativePattern.matcher(input)");
    paramCharSequence = l.a(localMatcher, paramCharSequence);
    AppMethodBeat.o(129424);
    return paramCharSequence;
  }
  
  public final String e(CharSequence paramCharSequence, String paramString)
  {
    AppMethodBeat.i(129426);
    p.h(paramCharSequence, "input");
    p.h(paramString, "replacement");
    paramCharSequence = this.NHg.matcher(paramCharSequence).replaceAll(paramString);
    p.g(paramCharSequence, "nativePattern.matcher(in…).replaceAll(replacement)");
    AppMethodBeat.o(129426);
    return paramCharSequence;
  }
  
  public final String f(CharSequence paramCharSequence, String paramString)
  {
    AppMethodBeat.i(129427);
    p.h(paramCharSequence, "input");
    p.h(paramString, "replacement");
    paramCharSequence = this.NHg.matcher(paramCharSequence).replaceFirst(paramString);
    p.g(paramCharSequence, "nativePattern.matcher(in…replaceFirst(replacement)");
    AppMethodBeat.o(129427);
    return paramCharSequence;
  }
  
  public final List<String> q(CharSequence paramCharSequence, int paramInt)
  {
    int j = 10;
    AppMethodBeat.i(129428);
    p.h(paramCharSequence, "input");
    if (paramInt >= 0) {}
    for (int i = 1; i == 0; i = 0)
    {
      paramCharSequence = (Throwable)new IllegalArgumentException(("Limit must be non-negative, but was " + paramInt + '.').toString());
      AppMethodBeat.o(129428);
      throw paramCharSequence;
    }
    Matcher localMatcher = this.NHg.matcher(paramCharSequence);
    if ((!localMatcher.find()) || (paramInt == 1))
    {
      paramCharSequence = j.listOf(paramCharSequence.toString());
      AppMethodBeat.o(129428);
      return paramCharSequence;
    }
    i = j;
    if (paramInt > 0) {
      i = h.lq(paramInt, 10);
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
  
  public final String toString()
  {
    AppMethodBeat.i(129429);
    String str = this.NHg.toString();
    p.g(str, "nativePattern.toString()");
    AppMethodBeat.o(129429);
    return str;
  }
  
  @d.l(gfx={1, 1, 16}, gfy={""}, gfz={"Lkotlin/text/Regex$Companion;", "", "()V", "ensureUnicodeCase", "", "flags", "escape", "", "literal", "escapeReplacement", "fromLiteral", "Lkotlin/text/Regex;", "kotlin-stdlib"})
  public static final class a {}
  
  @d.l(gfx={1, 1, 16}, gfy={""}, gfz={"Lkotlin/text/Regex$Serialized;", "Ljava/io/Serializable;", "Lkotlin/io/Serializable;", "pattern", "", "flags", "", "(Ljava/lang/String;I)V", "getFlags", "()I", "getPattern", "()Ljava/lang/String;", "readResolve", "", "Companion", "kotlin-stdlib"})
  static final class b
    implements Serializable
  {
    public static final a NHi;
    private final String Iff;
    private final int flags;
    
    static
    {
      AppMethodBeat.i(129358);
      NHi = new a((byte)0);
      AppMethodBeat.o(129358);
    }
    
    public b(String paramString, int paramInt)
    {
      AppMethodBeat.i(129357);
      this.Iff = paramString;
      this.flags = paramInt;
      AppMethodBeat.o(129357);
    }
    
    private final Object readResolve()
    {
      AppMethodBeat.i(129356);
      Object localObject = Pattern.compile(this.Iff, this.flags);
      p.g(localObject, "Pattern.compile(pattern, flags)");
      localObject = new k((Pattern)localObject);
      AppMethodBeat.o(129356);
      return localObject;
    }
    
    @d.l(gfx={1, 1, 16}, gfy={""}, gfz={"Lkotlin/text/Regex$Serialized$Companion;", "", "()V", "serialVersionUID", "", "kotlin-stdlib"})
    public static final class a {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     d.n.k
 * JD-Core Version:    0.7.0.1
 */