package d.n;

import com.tencent.matrix.trace.core.AppMethodBeat;
import d.g.a.m;
import d.g.b.a.a;
import d.k.d;
import d.l;
import d.o;
import java.util.Iterator;

@l(fvt={1, 1, 16}, fvu={""}, fvv={"Lkotlin/text/DelimitedRangesSequence;", "Lkotlin/sequences/Sequence;", "Lkotlin/ranges/IntRange;", "input", "", "startIndex", "", "limit", "getNextMatch", "Lkotlin/Function2;", "Lkotlin/ParameterName;", "name", "currentIndex", "Lkotlin/Pair;", "Lkotlin/ExtensionFunctionType;", "(Ljava/lang/CharSequence;IILkotlin/jvm/functions/Function2;)V", "iterator", "", "kotlin-stdlib"})
final class e
  implements d.m.h<d>
{
  final CharSequence KcD;
  final m<CharSequence, Integer, o<Integer, Integer>> KcE;
  final int limit;
  final int startIndex;
  
  public e(CharSequence paramCharSequence, m<? super CharSequence, ? super Integer, o<Integer, Integer>> paramm)
  {
    AppMethodBeat.i(129456);
    this.KcD = paramCharSequence;
    this.startIndex = 0;
    this.limit = 0;
    this.KcE = paramm;
    AppMethodBeat.o(129456);
  }
  
  public final Iterator<d> iterator()
  {
    AppMethodBeat.i(129455);
    Iterator localIterator = (Iterator)new a(this);
    AppMethodBeat.o(129455);
    return localIterator;
  }
  
  @l(fvt={1, 1, 16}, fvu={""}, fvv={"kotlin/text/DelimitedRangesSequence$iterator$1", "", "Lkotlin/ranges/IntRange;", "counter", "", "getCounter", "()I", "setCounter", "(I)V", "currentStartIndex", "getCurrentStartIndex", "setCurrentStartIndex", "nextItem", "getNextItem", "()Lkotlin/ranges/IntRange;", "setNextItem", "(Lkotlin/ranges/IntRange;)V", "nextSearchIndex", "getNextSearchIndex", "setNextSearchIndex", "nextState", "getNextState", "setNextState", "calcNext", "", "hasNext", "", "next", "kotlin-stdlib"})
  public static final class a
    implements a, Iterator<d>
  {
    private int KcF;
    private int KcG;
    private d KcH;
    private int Kci;
    private int fnF;
    
    a()
    {
      AppMethodBeat.i(129463);
      this.Kci = -1;
      this.KcF = d.k.h.aX(localObject.startIndex, 0, localObject.KcD.length());
      this.KcG = this.KcF;
      AppMethodBeat.o(129463);
    }
    
    private final void fKw()
    {
      AppMethodBeat.i(129460);
      if (this.KcG < 0)
      {
        this.Kci = 0;
        this.KcH = null;
        AppMethodBeat.o(129460);
        return;
      }
      if (this.KcI.limit > 0)
      {
        this.fnF += 1;
        if (this.fnF >= this.KcI.limit) {}
      }
      else
      {
        if (this.KcG <= this.KcI.KcD.length()) {
          break label122;
        }
      }
      this.KcH = new d(this.KcF, n.aF(this.KcI.KcD));
      label122:
      o localo;
      for (this.KcG = -1;; this.KcG = -1)
      {
        this.Kci = 1;
        AppMethodBeat.o(129460);
        return;
        localo = (o)this.KcI.KcE.n(this.KcI.KcD, Integer.valueOf(this.KcG));
        if (localo != null) {
          break;
        }
        this.KcH = new d(this.KcF, n.aF(this.KcI.KcD));
      }
      int j = ((Number)localo.first).intValue();
      int i = ((Number)localo.second).intValue();
      this.KcH = d.k.h.kJ(this.KcF, j);
      this.KcF = (j + i);
      j = this.KcF;
      if (i == 0) {}
      for (i = 1;; i = 0)
      {
        this.KcG = (i + j);
        break;
      }
    }
    
    public final boolean hasNext()
    {
      AppMethodBeat.i(129462);
      if (this.Kci == -1) {
        fKw();
      }
      if (this.Kci == 1)
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