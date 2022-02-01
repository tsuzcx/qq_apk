package d.n;

import com.tencent.matrix.trace.core.AppMethodBeat;
import d.g.a.m;
import d.g.b.a.a;
import d.k.d;
import d.l;
import d.o;
import java.util.Iterator;

@l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lkotlin/text/DelimitedRangesSequence;", "Lkotlin/sequences/Sequence;", "Lkotlin/ranges/IntRange;", "input", "", "startIndex", "", "limit", "getNextMatch", "Lkotlin/Function2;", "Lkotlin/ParameterName;", "name", "currentIndex", "Lkotlin/Pair;", "Lkotlin/ExtensionFunctionType;", "(Ljava/lang/CharSequence;IILkotlin/jvm/functions/Function2;)V", "iterator", "", "kotlin-stdlib"})
final class e
  implements d.m.h<d>
{
  final CharSequence LPY;
  final m<CharSequence, Integer, o<Integer, Integer>> LPZ;
  final int limit;
  final int startIndex;
  
  public e(CharSequence paramCharSequence, m<? super CharSequence, ? super Integer, o<Integer, Integer>> paramm)
  {
    AppMethodBeat.i(129456);
    this.LPY = paramCharSequence;
    this.startIndex = 0;
    this.limit = 0;
    this.LPZ = paramm;
    AppMethodBeat.o(129456);
  }
  
  public final Iterator<d> iterator()
  {
    AppMethodBeat.i(129455);
    Iterator localIterator = (Iterator)new a(this);
    AppMethodBeat.o(129455);
    return localIterator;
  }
  
  @l(fNY={1, 1, 16}, fNZ={""}, fOa={"kotlin/text/DelimitedRangesSequence$iterator$1", "", "Lkotlin/ranges/IntRange;", "counter", "", "getCounter", "()I", "setCounter", "(I)V", "currentStartIndex", "getCurrentStartIndex", "setCurrentStartIndex", "nextItem", "getNextItem", "()Lkotlin/ranges/IntRange;", "setNextItem", "(Lkotlin/ranges/IntRange;)V", "nextSearchIndex", "getNextSearchIndex", "setNextSearchIndex", "nextState", "getNextState", "setNextState", "calcNext", "", "hasNext", "", "next", "kotlin-stdlib"})
  public static final class a
    implements a, Iterator<d>
  {
    private int LPD;
    private int LQa;
    private int LQb;
    private d LQc;
    private int fqZ;
    
    a()
    {
      AppMethodBeat.i(129463);
      this.LPD = -1;
      this.LQa = d.k.h.aZ(localObject.startIndex, 0, localObject.LPY.length());
      this.LQb = this.LQa;
      AppMethodBeat.o(129463);
    }
    
    private final void gcZ()
    {
      AppMethodBeat.i(129460);
      if (this.LQb < 0)
      {
        this.LPD = 0;
        this.LQc = null;
        AppMethodBeat.o(129460);
        return;
      }
      if (this.LQd.limit > 0)
      {
        this.fqZ += 1;
        if (this.fqZ >= this.LQd.limit) {}
      }
      else
      {
        if (this.LQb <= this.LQd.LPY.length()) {
          break label122;
        }
      }
      this.LQc = new d(this.LQa, n.aG(this.LQd.LPY));
      label122:
      o localo;
      for (this.LQb = -1;; this.LQb = -1)
      {
        this.LPD = 1;
        AppMethodBeat.o(129460);
        return;
        localo = (o)this.LQd.LPZ.n(this.LQd.LPY, Integer.valueOf(this.LQb));
        if (localo != null) {
          break;
        }
        this.LQc = new d(this.LQa, n.aG(this.LQd.LPY));
      }
      int j = ((Number)localo.first).intValue();
      int i = ((Number)localo.second).intValue();
      this.LQc = d.k.h.kZ(this.LQa, j);
      this.LQa = (j + i);
      j = this.LQa;
      if (i == 0) {}
      for (i = 1;; i = 0)
      {
        this.LQb = (i + j);
        break;
      }
    }
    
    public final boolean hasNext()
    {
      AppMethodBeat.i(129462);
      if (this.LPD == -1) {
        gcZ();
      }
      if (this.LPD == 1)
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