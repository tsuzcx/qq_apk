package d.n;

import com.tencent.matrix.trace.core.AppMethodBeat;
import d.g.a.m;
import d.g.b.a.a;
import d.k.d;
import d.l;
import d.o;
import java.util.Iterator;

@l(gfx={1, 1, 16}, gfy={""}, gfz={"Lkotlin/text/DelimitedRangesSequence;", "Lkotlin/sequences/Sequence;", "Lkotlin/ranges/IntRange;", "input", "", "startIndex", "", "limit", "getNextMatch", "Lkotlin/Function2;", "Lkotlin/ParameterName;", "name", "currentIndex", "Lkotlin/Pair;", "Lkotlin/ExtensionFunctionType;", "(Ljava/lang/CharSequence;IILkotlin/jvm/functions/Function2;)V", "iterator", "", "kotlin-stdlib"})
final class e
  implements d.m.h<d>
{
  final CharSequence NGT;
  final m<CharSequence, Integer, o<Integer, Integer>> NGU;
  final int limit;
  final int startIndex;
  
  public e(CharSequence paramCharSequence, m<? super CharSequence, ? super Integer, o<Integer, Integer>> paramm)
  {
    AppMethodBeat.i(129456);
    this.NGT = paramCharSequence;
    this.startIndex = 0;
    this.limit = 0;
    this.NGU = paramm;
    AppMethodBeat.o(129456);
  }
  
  public final Iterator<d> iterator()
  {
    AppMethodBeat.i(129455);
    Iterator localIterator = (Iterator)new a(this);
    AppMethodBeat.o(129455);
    return localIterator;
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"kotlin/text/DelimitedRangesSequence$iterator$1", "", "Lkotlin/ranges/IntRange;", "counter", "", "getCounter", "()I", "setCounter", "(I)V", "currentStartIndex", "getCurrentStartIndex", "setCurrentStartIndex", "nextItem", "getNextItem", "()Lkotlin/ranges/IntRange;", "setNextItem", "(Lkotlin/ranges/IntRange;)V", "nextSearchIndex", "getNextSearchIndex", "setNextSearchIndex", "nextState", "getNextState", "setNextState", "calcNext", "", "hasNext", "", "next", "kotlin-stdlib"})
  public static final class a
    implements a, Iterator<d>
  {
    private int NGV;
    private int NGW;
    private d NGX;
    private int NGy;
    private int fJg;
    
    a()
    {
      AppMethodBeat.i(129463);
      this.NGy = -1;
      this.NGV = d.k.h.ba(localObject.startIndex, 0, localObject.NGT.length());
      this.NGW = this.NGV;
      AppMethodBeat.o(129463);
    }
    
    private final void guz()
    {
      AppMethodBeat.i(129460);
      if (this.NGW < 0)
      {
        this.NGy = 0;
        this.NGX = null;
        AppMethodBeat.o(129460);
        return;
      }
      if (this.NGY.limit > 0)
      {
        this.fJg += 1;
        if (this.fJg >= this.NGY.limit) {}
      }
      else
      {
        if (this.NGW <= this.NGY.NGT.length()) {
          break label122;
        }
      }
      this.NGX = new d(this.NGV, n.aH(this.NGY.NGT));
      label122:
      o localo;
      for (this.NGW = -1;; this.NGW = -1)
      {
        this.NGy = 1;
        AppMethodBeat.o(129460);
        return;
        localo = (o)this.NGY.NGU.p(this.NGY.NGT, Integer.valueOf(this.NGW));
        if (localo != null) {
          break;
        }
        this.NGX = new d(this.NGV, n.aH(this.NGY.NGT));
      }
      int j = ((Number)localo.first).intValue();
      int i = ((Number)localo.second).intValue();
      this.NGX = d.k.h.lo(this.NGV, j);
      this.NGV = (j + i);
      j = this.NGV;
      if (i == 0) {}
      for (i = 1;; i = 0)
      {
        this.NGW = (i + j);
        break;
      }
    }
    
    public final boolean hasNext()
    {
      AppMethodBeat.i(129462);
      if (this.NGy == -1) {
        guz();
      }
      if (this.NGy == 1)
      {
        AppMethodBeat.o(129462);
        return true;
      }
      AppMethodBeat.o(129462);
      return false;
    }
    
    public final void remove()
    {
      AppMethodBeat.i(129464);
      UnsupportedOperationException localUnsupportedOperationException = new UnsupportedOperationException("Operation is not supported for read-only collection");
      AppMethodBeat.o(129464);
      throw localUnsupportedOperationException;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     d.n.e
 * JD-Core Version:    0.7.0.1
 */