package kotlin.n;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Iterator;
import java.util.List;
import java.util.regex.MatchResult;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import kotlin.Metadata;
import kotlin.a.a;
import kotlin.a.p;
import kotlin.g.b.s;
import kotlin.g.b.u;
import kotlin.k.e;

@Metadata(d1={""}, d2={"Lkotlin/text/MatcherMatchResult;", "Lkotlin/text/MatchResult;", "matcher", "Ljava/util/regex/Matcher;", "input", "", "(Ljava/util/regex/Matcher;Ljava/lang/CharSequence;)V", "groupValues", "", "", "getGroupValues", "()Ljava/util/List;", "groupValues_", "groups", "Lkotlin/text/MatchGroupCollection;", "getGroups", "()Lkotlin/text/MatchGroupCollection;", "matchResult", "Ljava/util/regex/MatchResult;", "getMatchResult", "()Ljava/util/regex/MatchResult;", "range", "Lkotlin/ranges/IntRange;", "getRange", "()Lkotlin/ranges/IntRange;", "value", "getValue", "()Ljava/lang/String;", "next", "kotlin-stdlib"}, k=1, mv={1, 5, 1})
final class j
  implements i
{
  private final CharSequence ajuE;
  private final g ajuM;
  private List<String> ajuN;
  private final Matcher ajuO;
  
  public j(Matcher paramMatcher, CharSequence paramCharSequence)
  {
    AppMethodBeat.i(129453);
    this.ajuO = paramMatcher;
    this.ajuE = paramCharSequence;
    this.ajuM = ((g)new b(this));
    AppMethodBeat.o(129453);
  }
  
  public final String getValue()
  {
    AppMethodBeat.i(129451);
    String str = ((MatchResult)this.ajuO).group();
    s.s(str, "matchResult.group()");
    AppMethodBeat.o(129451);
    return str;
  }
  
  public final kotlin.k.g kBn()
  {
    AppMethodBeat.i(190908);
    Object localObject = (MatchResult)this.ajuO;
    localObject = kotlin.k.k.qt(((MatchResult)localObject).start(), ((MatchResult)localObject).end());
    AppMethodBeat.o(190908);
    return localObject;
  }
  
  public final g kBo()
  {
    return this.ajuM;
  }
  
  public final List<String> kBp()
  {
    AppMethodBeat.i(129452);
    if (this.ajuN == null) {
      this.ajuN = ((List)new a(this));
    }
    List localList = this.ajuN;
    s.checkNotNull(localList);
    AppMethodBeat.o(129452);
    return localList;
  }
  
  public final i.a kBq()
  {
    AppMethodBeat.i(129454);
    i.a locala = new i.a(this);
    AppMethodBeat.o(129454);
    return locala;
  }
  
  public final i kBr()
  {
    AppMethodBeat.i(190920);
    int j = ((MatchResult)this.ajuO).end();
    if (((MatchResult)this.ajuO).end() == ((MatchResult)this.ajuO).start()) {}
    for (int i = 1;; i = 0)
    {
      i += j;
      if (i > this.ajuE.length()) {
        break;
      }
      Object localObject = this.ajuO.pattern().matcher(this.ajuE);
      s.s(localObject, "matcher.pattern().matcher(input)");
      localObject = l.a((Matcher)localObject, i, this.ajuE);
      AppMethodBeat.o(190920);
      return localObject;
    }
    AppMethodBeat.o(190920);
    return null;
  }
  
  @Metadata(d1={""}, d2={"kotlin/text/MatcherMatchResult$groupValues$1", "Lkotlin/collections/AbstractList;", "", "size", "", "getSize", "()I", "get", "index", "kotlin-stdlib"}, k=1, mv={1, 5, 1})
  public static final class a
    extends kotlin.a.b<String>
  {
    public final int getSize()
    {
      AppMethodBeat.i(129360);
      int i = j.a(this.ajuP).groupCount();
      AppMethodBeat.o(129360);
      return i + 1;
    }
  }
  
  @Metadata(d1={""}, d2={"kotlin/text/MatcherMatchResult$groups$1", "Lkotlin/text/MatchNamedGroupCollection;", "Lkotlin/collections/AbstractCollection;", "Lkotlin/text/MatchGroup;", "size", "", "getSize", "()I", "get", "index", "name", "", "isEmpty", "", "iterator", "", "kotlin-stdlib"}, k=1, mv={1, 5, 1})
  public static final class b
    extends a<f>
    implements h
  {
    public final f aMz(int paramInt)
    {
      AppMethodBeat.i(129437);
      Object localObject = j.a(this.ajuP);
      localObject = kotlin.k.k.qt(((MatchResult)localObject).start(paramInt), ((MatchResult)localObject).end(paramInt));
      if (((e)localObject).fIj >= 0)
      {
        String str = j.a(this.ajuP).group(paramInt);
        s.s(str, "matchResult.group(index)");
        localObject = new f(str, (kotlin.k.g)localObject);
        AppMethodBeat.o(129437);
        return localObject;
      }
      AppMethodBeat.o(129437);
      return null;
    }
    
    public final int getSize()
    {
      AppMethodBeat.i(129435);
      int i = j.a(this.ajuP).groupCount();
      AppMethodBeat.o(129435);
      return i + 1;
    }
    
    public final boolean isEmpty()
    {
      return false;
    }
    
    public final Iterator<f> iterator()
    {
      AppMethodBeat.i(129436);
      Iterator localIterator = kotlin.m.k.d(p.A((Iterable)p.F(this)), (kotlin.g.a.b)new a(this)).iterator();
      AppMethodBeat.o(129436);
      return localIterator;
    }
    
    @Metadata(d1={""}, d2={"<anonymous>", "Lkotlin/text/MatchGroup;", "it", "", "invoke"}, k=3, mv={1, 5, 1})
    static final class a
      extends u
      implements kotlin.g.a.b<Integer, f>
    {
      a(j.b paramb)
      {
        super();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     kotlin.n.j
 * JD-Core Version:    0.7.0.1
 */