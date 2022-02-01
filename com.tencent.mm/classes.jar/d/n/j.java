package d.n;

import com.tencent.matrix.trace.core.AppMethodBeat;
import d.a.a;
import d.g.b.k;
import d.k.d;
import java.util.Iterator;
import java.util.List;
import java.util.regex.MatchResult;
import java.util.regex.Matcher;

@d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lkotlin/text/MatcherMatchResult;", "Lkotlin/text/MatchResult;", "matcher", "Ljava/util/regex/Matcher;", "input", "", "(Ljava/util/regex/Matcher;Ljava/lang/CharSequence;)V", "groupValues", "", "", "getGroupValues", "()Ljava/util/List;", "groupValues_", "groups", "Lkotlin/text/MatchGroupCollection;", "getGroups", "()Lkotlin/text/MatchGroupCollection;", "matchResult", "Ljava/util/regex/MatchResult;", "getMatchResult", "()Ljava/util/regex/MatchResult;", "range", "Lkotlin/ranges/IntRange;", "getRange", "()Lkotlin/ranges/IntRange;", "value", "getValue", "()Ljava/lang/String;", "next", "kotlin-stdlib"})
public final class j
  implements i
{
  private final CharSequence LPY;
  private final g LQg;
  private List<String> LQh;
  final Matcher LQi;
  
  public j(Matcher paramMatcher, CharSequence paramCharSequence)
  {
    AppMethodBeat.i(129453);
    this.LQi = paramMatcher;
    this.LPY = paramCharSequence;
    this.LQg = ((g)new b(this));
    AppMethodBeat.o(129453);
  }
  
  public final g gdb()
  {
    return this.LQg;
  }
  
  public final List<String> gdc()
  {
    AppMethodBeat.i(129452);
    if (this.LQh == null) {
      this.LQh = ((List)new a(this));
    }
    List localList = this.LQh;
    if (localList == null) {
      k.fOy();
    }
    AppMethodBeat.o(129452);
    return localList;
  }
  
  public final i.a gdd()
  {
    AppMethodBeat.i(129454);
    i.a locala = new i.a(this);
    AppMethodBeat.o(129454);
    return locala;
  }
  
  public final String getValue()
  {
    AppMethodBeat.i(129451);
    String str = ((MatchResult)this.LQi).group();
    k.g(str, "matchResult.group()");
    AppMethodBeat.o(129451);
    return str;
  }
  
  @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"kotlin/text/MatcherMatchResult$groupValues$1", "Lkotlin/collections/AbstractList;", "", "size", "", "getSize", "()I", "get", "index", "kotlin-stdlib"})
  public static final class a
    extends d.a.b<String>
  {
    public final int getSize()
    {
      AppMethodBeat.i(129360);
      int i = ((MatchResult)this.LQj.LQi).groupCount();
      AppMethodBeat.o(129360);
      return i + 1;
    }
  }
  
  @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"kotlin/text/MatcherMatchResult$groups$1", "Lkotlin/text/MatchNamedGroupCollection;", "Lkotlin/collections/AbstractCollection;", "Lkotlin/text/MatchGroup;", "size", "", "getSize", "()I", "get", "index", "name", "", "isEmpty", "", "iterator", "", "kotlin-stdlib"})
  public static final class b
    extends a<f>
    implements h
  {
    public final f aiY(int paramInt)
    {
      AppMethodBeat.i(129437);
      Object localObject = (MatchResult)this.LQj.LQi;
      localObject = d.k.h.kZ(((MatchResult)localObject).start(paramInt), ((MatchResult)localObject).end(paramInt));
      if (((d.k.b)localObject).KVb >= 0)
      {
        String str = ((MatchResult)this.LQj.LQi).group(paramInt);
        k.g(str, "matchResult.group(index)");
        localObject = new f(str, (d)localObject);
        AppMethodBeat.o(129437);
        return localObject;
      }
      AppMethodBeat.o(129437);
      return null;
    }
    
    public final int getSize()
    {
      AppMethodBeat.i(129435);
      int i = ((MatchResult)this.LQj.LQi).groupCount();
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
      Iterator localIterator = d.m.i.d(d.a.j.t((Iterable)d.a.j.o(this)), (d.g.a.b)new a(this)).iterator();
      AppMethodBeat.o(129436);
      return localIterator;
    }
    
    @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "Lkotlin/text/MatchGroup;", "it", "", "invoke"})
    static final class a
      extends d.g.b.l
      implements d.g.a.b<Integer, f>
    {
      a(j.b paramb)
      {
        super();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     d.n.j
 * JD-Core Version:    0.7.0.1
 */