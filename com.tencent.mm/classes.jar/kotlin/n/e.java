package kotlin.n;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Iterator;
import kotlin.g.a.m;
import kotlin.g.b.a.a;
import kotlin.k.f;
import kotlin.k.j;
import kotlin.l;
import kotlin.m.h;
import kotlin.o;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lkotlin/text/DelimitedRangesSequence;", "Lkotlin/sequences/Sequence;", "Lkotlin/ranges/IntRange;", "input", "", "startIndex", "", "limit", "getNextMatch", "Lkotlin/Function2;", "Lkotlin/ParameterName;", "name", "currentIndex", "Lkotlin/Pair;", "Lkotlin/ExtensionFunctionType;", "(Ljava/lang/CharSequence;IILkotlin/jvm/functions/Function2;)V", "iterator", "", "kotlin-stdlib"})
final class e
  implements h<f>
{
  final CharSequence TST;
  final m<CharSequence, Integer, o<Integer, Integer>> TSU;
  final int limit;
  final int startIndex;
  
  public e(CharSequence paramCharSequence, int paramInt1, int paramInt2, m<? super CharSequence, ? super Integer, o<Integer, Integer>> paramm)
  {
    AppMethodBeat.i(206250);
    this.TST = paramCharSequence;
    this.startIndex = 0;
    this.limit = paramInt2;
    this.TSU = paramm;
    AppMethodBeat.o(206250);
  }
  
  public final Iterator<f> iterator()
  {
    AppMethodBeat.i(129455);
    Iterator localIterator = (Iterator)new a(this);
    AppMethodBeat.o(129455);
    return localIterator;
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"kotlin/text/DelimitedRangesSequence$iterator$1", "", "Lkotlin/ranges/IntRange;", "counter", "", "getCounter", "()I", "setCounter", "(I)V", "currentStartIndex", "getCurrentStartIndex", "setCurrentStartIndex", "nextItem", "getNextItem", "()Lkotlin/ranges/IntRange;", "setNextItem", "(Lkotlin/ranges/IntRange;)V", "nextSearchIndex", "getNextSearchIndex", "setNextSearchIndex", "nextState", "getNextState", "setNextState", "calcNext", "", "hasNext", "", "next", "kotlin-stdlib"})
  public static final class a
    implements Iterator<f>, a
  {
    private int TSV;
    private int TSW;
    private f TSX;
    private int TSy;
    private int cBY;
    
    a()
    {
      AppMethodBeat.i(129463);
      this.TSy = -1;
      this.TSV = j.bh(localObject.startIndex, 0, localObject.TST.length());
      this.TSW = this.TSV;
      AppMethodBeat.o(129463);
    }
    
    private final void hMe()
    {
      AppMethodBeat.i(129460);
      if (this.TSW < 0)
      {
        this.TSy = 0;
        this.TSX = null;
        AppMethodBeat.o(129460);
        return;
      }
      if (this.TSY.limit > 0)
      {
        this.cBY += 1;
        if (this.cBY >= this.TSY.limit) {}
      }
      else
      {
        if (this.TSW <= this.TSY.TST.length()) {
          break label122;
        }
      }
      this.TSX = new f(this.TSV, n.aO(this.TSY.TST));
      label122:
      o localo;
      for (this.TSW = -1;; this.TSW = -1)
      {
        this.TSy = 1;
        AppMethodBeat.o(129460);
        return;
        localo = (o)this.TSY.TSU.invoke(this.TSY.TST, Integer.valueOf(this.TSW));
        if (localo != null) {
          break;
        }
        this.TSX = new f(this.TSV, n.aO(this.TSY.TST));
      }
      int j = ((Number)localo.first).intValue();
      int i = ((Number)localo.second).intValue();
      this.TSX = j.mY(this.TSV, j);
      this.TSV = (j + i);
      j = this.TSV;
      if (i == 0) {}
      for (i = 1;; i = 0)
      {
        this.TSW = (i + j);
        break;
      }
    }
    
    public final boolean hasNext()
    {
      AppMethodBeat.i(129462);
      if (this.TSy == -1) {
        hMe();
      }
      if (this.TSy == 1)
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