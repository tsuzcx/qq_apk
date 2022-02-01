package kotlin.n;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.g.a.m;
import kotlin.g.b.a.a;
import kotlin.k.g;
import kotlin.k.k;
import kotlin.m.h;
import kotlin.r;

@Metadata(d1={""}, d2={"Lkotlin/text/DelimitedRangesSequence;", "Lkotlin/sequences/Sequence;", "Lkotlin/ranges/IntRange;", "input", "", "startIndex", "", "limit", "getNextMatch", "Lkotlin/Function2;", "Lkotlin/ParameterName;", "name", "currentIndex", "Lkotlin/Pair;", "Lkotlin/ExtensionFunctionType;", "(Ljava/lang/CharSequence;IILkotlin/jvm/functions/Function2;)V", "iterator", "", "kotlin-stdlib"}, k=1, mv={1, 5, 1})
final class e
  implements h<g>
{
  private final CharSequence ajuE;
  private final m<CharSequence, Integer, r<Integer, Integer>> ajuF;
  private final int limit;
  private final int startIndex;
  
  public e(CharSequence paramCharSequence, int paramInt, m<? super CharSequence, ? super Integer, r<Integer, Integer>> paramm)
  {
    AppMethodBeat.i(190906);
    this.ajuE = paramCharSequence;
    this.startIndex = 0;
    this.limit = paramInt;
    this.ajuF = paramm;
    AppMethodBeat.o(190906);
  }
  
  public final Iterator<g> iterator()
  {
    AppMethodBeat.i(129455);
    Iterator localIterator = (Iterator)new a(this);
    AppMethodBeat.o(129455);
    return localIterator;
  }
  
  @Metadata(d1={""}, d2={"kotlin/text/DelimitedRangesSequence$iterator$1", "", "Lkotlin/ranges/IntRange;", "counter", "", "getCounter", "()I", "setCounter", "(I)V", "currentStartIndex", "getCurrentStartIndex", "setCurrentStartIndex", "nextItem", "getNextItem", "()Lkotlin/ranges/IntRange;", "setNextItem", "(Lkotlin/ranges/IntRange;)V", "nextSearchIndex", "getNextSearchIndex", "setNextSearchIndex", "nextState", "getNextState", "setNextState", "calcNext", "", "hasNext", "", "next", "kotlin-stdlib"}, k=1, mv={1, 5, 1})
  public static final class a
    implements Iterator<g>, a
  {
    private int ajuG;
    private int ajuH;
    private g ajuI;
    private int ajuc;
    private int evg;
    
    a()
    {
      AppMethodBeat.i(129463);
      this.ajuc = -1;
      this.ajuG = k.bQ(e.d(locale), 0, e.b(locale).length());
      this.ajuH = this.ajuG;
      AppMethodBeat.o(129463);
    }
    
    private final void kBk()
    {
      AppMethodBeat.i(129460);
      if (this.ajuH < 0)
      {
        this.ajuc = 0;
        this.ajuI = null;
        AppMethodBeat.o(129460);
        return;
      }
      if (e.a(this.ajuJ) > 0)
      {
        this.evg += 1;
        if (this.evg >= e.a(this.ajuJ)) {}
      }
      else
      {
        if (this.ajuH <= e.b(this.ajuJ).length()) {
          break label122;
        }
      }
      this.ajuI = new g(this.ajuG, n.bt(e.b(this.ajuJ)));
      label122:
      r localr;
      for (this.ajuH = -1;; this.ajuH = -1)
      {
        this.ajuc = 1;
        AppMethodBeat.o(129460);
        return;
        localr = (r)e.c(this.ajuJ).invoke(e.b(this.ajuJ), Integer.valueOf(this.ajuH));
        if (localr != null) {
          break;
        }
        this.ajuI = new g(this.ajuG, n.bt(e.b(this.ajuJ)));
      }
      int j = ((Number)localr.bsC).intValue();
      int i = ((Number)localr.bsD).intValue();
      this.ajuI = k.qt(this.ajuG, j);
      this.ajuG = (j + i);
      j = this.ajuG;
      if (i == 0) {}
      for (i = 1;; i = 0)
      {
        this.ajuH = (i + j);
        break;
      }
    }
    
    public final boolean hasNext()
    {
      AppMethodBeat.i(129462);
      if (this.ajuc == -1) {
        kBk();
      }
      if (this.ajuc == 1)
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     kotlin.n.e
 * JD-Core Version:    0.7.0.1
 */