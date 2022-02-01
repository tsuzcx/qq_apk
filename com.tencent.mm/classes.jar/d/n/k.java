package d.n;

import com.tencent.matrix.trace.core.AppMethodBeat;
import d.g.b.p;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@d.l(gjZ={1, 1, 16}, gka={""}, gkb={"Lkotlin/text/Regex;", "Ljava/io/Serializable;", "Lkotlin/io/Serializable;", "pattern", "", "(Ljava/lang/String;)V", "option", "Lkotlin/text/RegexOption;", "(Ljava/lang/String;Lkotlin/text/RegexOption;)V", "options", "", "(Ljava/lang/String;Ljava/util/Set;)V", "nativePattern", "Ljava/util/regex/Pattern;", "(Ljava/util/regex/Pattern;)V", "_options", "getOptions", "()Ljava/util/Set;", "getPattern", "()Ljava/lang/String;", "containsMatchIn", "", "input", "", "find", "Lkotlin/text/MatchResult;", "startIndex", "", "findAll", "Lkotlin/sequences/Sequence;", "matchEntire", "matches", "replace", "transform", "Lkotlin/Function1;", "replacement", "replaceFirst", "split", "", "limit", "toPattern", "toString", "writeReplace", "", "Companion", "Serialized", "kotlin-stdlib"})
public final class k
  implements Serializable
{
  public static final a Oen;
  public final Pattern Oem;
  
  static
  {
    AppMethodBeat.i(129433);
    Oen = new a((byte)0);
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
    this.Oem = paramPattern;
    AppMethodBeat.o(129431);
  }
  
  private final Object writeReplace()
  {
    AppMethodBeat.i(129430);
    Object localObject = this.Oem.pattern();
    p.g(localObject, "nativePattern.pattern()");
    localObject = new b((String)localObject, this.Oem.flags());
    AppMethodBeat.o(129430);
    return localObject;
  }
  
  public final boolean aB(CharSequence paramCharSequence)
  {
    AppMethodBeat.i(129423);
    p.h(paramCharSequence, "input");
    boolean bool = this.Oem.matcher(paramCharSequence).matches();
    AppMethodBeat.o(129423);
    return bool;
  }
  
  public final i aC(CharSequence paramCharSequence)
  {
    AppMethodBeat.i(129424);
    p.h(paramCharSequence, "input");
    Matcher localMatcher = this.Oem.matcher(paramCharSequence);
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
    paramCharSequence = this.Oem.matcher(paramCharSequence).replaceAll(paramString);
    p.g(paramCharSequence, "nativePattern.matcher(in…).replaceAll(replacement)");
    AppMethodBeat.o(129426);
    return paramCharSequence;
  }
  
  public final String f(CharSequence paramCharSequence, String paramString)
  {
    AppMethodBeat.i(129427);
    p.h(paramCharSequence, "input");
    p.h(paramString, "replacement");
    paramCharSequence = this.Oem.matcher(paramCharSequence).replaceFirst(paramString);
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
    Matcher localMatcher = this.Oem.matcher(paramCharSequence);
    if ((!localMatcher.find()) || (paramInt == 1))
    {
      paramCharSequence = d.a.j.listOf(paramCharSequence.toString());
      AppMethodBeat.o(129428);
      return paramCharSequence;
    }
    i = j;
    if (paramInt > 0) {
      i = d.k.j.lx(paramInt, 10);
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
    String str = this.Oem.toString();
    p.g(str, "nativePattern.toString()");
    AppMethodBeat.o(129429);
    return str;
  }
  
  @d.l(gjZ={1, 1, 16}, gka={""}, gkb={"Lkotlin/text/Regex$Companion;", "", "()V", "ensureUnicodeCase", "", "flags", "escape", "", "literal", "escapeReplacement", "fromLiteral", "Lkotlin/text/Regex;", "kotlin-stdlib"})
  public static final class a {}
  
  @d.l(gjZ={1, 1, 16}, gka={""}, gkb={"Lkotlin/text/Regex$Serialized;", "Ljava/io/Serializable;", "Lkotlin/io/Serializable;", "pattern", "", "flags", "", "(Ljava/lang/String;I)V", "getFlags", "()I", "getPattern", "()Ljava/lang/String;", "readResolve", "", "Companion", "kotlin-stdlib"})
  static final class b
    implements Serializable
  {
    public static final a Oeo;
    private final String Izq;
    private final int flags;
    
    static
    {
      AppMethodBeat.i(129358);
      Oeo = new a((byte)0);
      AppMethodBeat.o(129358);
    }
    
    public b(String paramString, int paramInt)
    {
      AppMethodBeat.i(129357);
      this.Izq = paramString;
      this.flags = paramInt;
      AppMethodBeat.o(129357);
    }
    
    private final Object readResolve()
    {
      AppMethodBeat.i(129356);
      Object localObject = Pattern.compile(this.Izq, this.flags);
      p.g(localObject, "Pattern.compile(pattern, flags)");
      localObject = new k((Pattern)localObject);
      AppMethodBeat.o(129356);
      return localObject;
    }
    
    @d.l(gjZ={1, 1, 16}, gka={""}, gkb={"Lkotlin/text/Regex$Serialized$Companion;", "", "()V", "serialVersionUID", "", "kotlin-stdlib"})
    public static final class a {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     d.n.k
 * JD-Core Version:    0.7.0.1
 */