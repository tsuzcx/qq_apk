package kotlin.n;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Iterator;
import java.util.List;
import java.util.regex.MatchResult;
import java.util.regex.Matcher;
import kotlin.a.a;
import kotlin.g.b.p;
import kotlin.g.b.q;
import kotlin.k.d;
import kotlin.l;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lkotlin/text/MatcherMatchResult;", "Lkotlin/text/MatchResult;", "matcher", "Ljava/util/regex/Matcher;", "input", "", "(Ljava/util/regex/Matcher;Ljava/lang/CharSequence;)V", "groupValues", "", "", "getGroupValues", "()Ljava/util/List;", "groupValues_", "groups", "Lkotlin/text/MatchGroupCollection;", "getGroups", "()Lkotlin/text/MatchGroupCollection;", "matchResult", "Ljava/util/regex/MatchResult;", "getMatchResult", "()Ljava/util/regex/MatchResult;", "range", "Lkotlin/ranges/IntRange;", "getRange", "()Lkotlin/ranges/IntRange;", "value", "getValue", "()Ljava/lang/String;", "next", "kotlin-stdlib"})
final class j
  implements i
{
  private final CharSequence TST;
  private final g TTb;
  private List<String> TTc;
  final Matcher TTd;
  
  public j(Matcher paramMatcher, CharSequence paramCharSequence)
  {
    AppMethodBeat.i(129453);
    this.TTd = paramMatcher;
    this.TST = paramCharSequence;
    this.TTb = ((g)new b(this));
    AppMethodBeat.o(129453);
  }
  
  public final String getValue()
  {
    AppMethodBeat.i(129451);
    String str = ((MatchResult)this.TTd).group();
    p.g(str, "matchResult.group()");
    AppMethodBeat.o(129451);
    return str;
  }
  
  public final kotlin.k.f hMg()
  {
    AppMethodBeat.i(206251);
    Object localObject = (MatchResult)this.TTd;
    localObject = kotlin.k.j.mY(((MatchResult)localObject).start(), ((MatchResult)localObject).end());
    AppMethodBeat.o(206251);
    return localObject;
  }
  
  public final g hMh()
  {
    return this.TTb;
  }
  
  public final List<String> hMi()
  {
    AppMethodBeat.i(129452);
    if (this.TTc == null) {
      this.TTc = ((List)new a(this));
    }
    List localList = this.TTc;
    if (localList == null) {
      p.hyc();
    }
    AppMethodBeat.o(129452);
    return localList;
  }
  
  public final i.a hMj()
  {
    AppMethodBeat.i(129454);
    i.a locala = new i.a(this);
    AppMethodBeat.o(129454);
    return locala;
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"kotlin/text/MatcherMatchResult$groupValues$1", "Lkotlin/collections/AbstractList;", "", "size", "", "getSize", "()I", "get", "index", "kotlin-stdlib"})
  public static final class a
    extends kotlin.a.b<String>
  {
    public final int getSize()
    {
      AppMethodBeat.i(129360);
      int i = ((MatchResult)this.TTe.TTd).groupCount();
      AppMethodBeat.o(129360);
      return i + 1;
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"kotlin/text/MatcherMatchResult$groups$1", "Lkotlin/text/MatchNamedGroupCollection;", "Lkotlin/collections/AbstractCollection;", "Lkotlin/text/MatchGroup;", "size", "", "getSize", "()I", "get", "index", "name", "", "isEmpty", "", "iterator", "", "kotlin-stdlib"})
  public static final class b
    extends a<f>
    implements h
  {
    public final f avS(int paramInt)
    {
      AppMethodBeat.i(129437);
      Object localObject = (MatchResult)this.TTe.TTd;
      localObject = kotlin.k.j.mY(((MatchResult)localObject).start(paramInt), ((MatchResult)localObject).end(paramInt));
      if (((d)localObject).SYU >= 0)
      {
        String str = ((MatchResult)this.TTe.TTd).group(paramInt);
        p.g(str, "matchResult.group(index)");
        localObject = new f(str, (kotlin.k.f)localObject);
        AppMethodBeat.o(129437);
        return localObject;
      }
      AppMethodBeat.o(129437);
      return null;
    }
    
    public final int getSize()
    {
      AppMethodBeat.i(129435);
      int i = ((MatchResult)this.TTe.TTd).groupCount();
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
      Iterator localIterator = kotlin.m.i.d(kotlin.a.j.z((Iterable)kotlin.a.j.r(this)), (kotlin.g.a.b)new a(this)).iterator();
      AppMethodBeat.o(129436);
      return localIterator;
    }
    
    @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "Lkotlin/text/MatchGroup;", "it", "", "invoke"})
    static final class a
      extends q
      implements kotlin.g.a.b<Integer, f>
    {
      a(j.b paramb)
      {
        super();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     kotlin.n.j
 * JD-Core Version:    0.7.0.1
 */