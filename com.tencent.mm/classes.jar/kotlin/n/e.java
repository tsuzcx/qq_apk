package kotlin.n;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Iterator;
import kotlin.g.a.m;
import kotlin.g.b.a.a;
import kotlin.k.i;
import kotlin.l;
import kotlin.m.h;
import kotlin.o;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lkotlin/text/DelimitedRangesSequence;", "Lkotlin/sequences/Sequence;", "Lkotlin/ranges/IntRange;", "input", "", "startIndex", "", "limit", "getNextMatch", "Lkotlin/Function2;", "Lkotlin/ParameterName;", "name", "currentIndex", "Lkotlin/Pair;", "Lkotlin/ExtensionFunctionType;", "(Ljava/lang/CharSequence;IILkotlin/jvm/functions/Function2;)V", "iterator", "", "kotlin-stdlib"})
final class e
  implements h<kotlin.k.e>
{
  final CharSequence abvw;
  final m<CharSequence, Integer, o<Integer, Integer>> abvx;
  final int limit;
  final int startIndex;
  
  public e(CharSequence paramCharSequence, int paramInt1, int paramInt2, m<? super CharSequence, ? super Integer, o<Integer, Integer>> paramm)
  {
    AppMethodBeat.i(218047);
    this.abvw = paramCharSequence;
    this.startIndex = 0;
    this.limit = paramInt2;
    this.abvx = paramm;
    AppMethodBeat.o(218047);
  }
  
  public final Iterator<kotlin.k.e> iterator()
  {
    AppMethodBeat.i(129455);
    Iterator localIterator = (Iterator)new a(this);
    AppMethodBeat.o(129455);
    return localIterator;
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"kotlin/text/DelimitedRangesSequence$iterator$1", "", "Lkotlin/ranges/IntRange;", "counter", "", "getCounter", "()I", "setCounter", "(I)V", "currentStartIndex", "getCurrentStartIndex", "setCurrentStartIndex", "nextItem", "getNextItem", "()Lkotlin/ranges/IntRange;", "setNextItem", "(Lkotlin/ranges/IntRange;)V", "nextSearchIndex", "getNextSearchIndex", "setNextSearchIndex", "nextState", "getNextState", "setNextState", "calcNext", "", "hasNext", "", "next", "kotlin-stdlib"})
  public static final class a
    implements Iterator<kotlin.k.e>, a
  {
    private int abuX;
    private kotlin.k.e abvA;
    private int abvy;
    private int abvz;
    private int cCC;
    
    a()
    {
      AppMethodBeat.i(129463);
      this.abuX = -1;
      this.abvy = i.bm(localObject.startIndex, 0, localObject.abvw.length());
      this.abvz = this.abvy;
      AppMethodBeat.o(129463);
    }
    
    private final void iQw()
    {
      AppMethodBeat.i(129460);
      if (this.abvz < 0)
      {
        this.abuX = 0;
        this.abvA = null;
        AppMethodBeat.o(129460);
        return;
      }
      if (this.abvB.limit > 0)
      {
        this.cCC += 1;
        if (this.cCC >= this.abvB.limit) {}
      }
      else
      {
        if (this.abvz <= this.abvB.abvw.length()) {
          break label122;
        }
      }
      this.abvA = new kotlin.k.e(this.abvy, n.be(this.abvB.abvw));
      label122:
      o localo;
      for (this.abvz = -1;; this.abvz = -1)
      {
        this.abuX = 1;
        AppMethodBeat.o(129460);
        return;
        localo = (o)this.abvB.abvx.invoke(this.abvB.abvw, Integer.valueOf(this.abvz));
        if (localo != null) {
          break;
        }
        this.abvA = new kotlin.k.e(this.abvy, n.be(this.abvB.abvw));
      }
      int j = ((Number)localo.Mx).intValue();
      int i = ((Number)localo.My).intValue();
      this.abvA = i.ou(this.abvy, j);
      this.abvy = (j + i);
      j = this.abvy;
      if (i == 0) {}
      for (i = 1;; i = 0)
      {
        this.abvz = (i + j);
        break;
      }
    }
    
    public final boolean hasNext()
    {
      AppMethodBeat.i(129462);
      if (this.abuX == -1) {
        iQw();
      }
      if (this.abuX == 1)
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
 * Qualified Name:     kotlin.n.e
 * JD-Core Version:    0.7.0.1
 */