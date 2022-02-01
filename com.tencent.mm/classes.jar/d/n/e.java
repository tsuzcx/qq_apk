package d.n;

import com.tencent.matrix.trace.core.AppMethodBeat;
import d.g.a.m;
import d.g.b.a.a;
import d.k.f;
import d.k.j;
import d.l;
import d.m.h;
import d.o;
import java.util.Iterator;

@l(gjZ={1, 1, 16}, gka={""}, gkb={"Lkotlin/text/DelimitedRangesSequence;", "Lkotlin/sequences/Sequence;", "Lkotlin/ranges/IntRange;", "input", "", "startIndex", "", "limit", "getNextMatch", "Lkotlin/Function2;", "Lkotlin/ParameterName;", "name", "currentIndex", "Lkotlin/Pair;", "Lkotlin/ExtensionFunctionType;", "(Ljava/lang/CharSequence;IILkotlin/jvm/functions/Function2;)V", "iterator", "", "kotlin-stdlib"})
final class e
  implements h<f>
{
  final CharSequence OdZ;
  final m<CharSequence, Integer, o<Integer, Integer>> Oea;
  final int limit;
  final int startIndex;
  
  public e(CharSequence paramCharSequence, m<? super CharSequence, ? super Integer, o<Integer, Integer>> paramm)
  {
    AppMethodBeat.i(129456);
    this.OdZ = paramCharSequence;
    this.startIndex = 0;
    this.limit = 0;
    this.Oea = paramm;
    AppMethodBeat.o(129456);
  }
  
  public final Iterator<f> iterator()
  {
    AppMethodBeat.i(129455);
    Iterator localIterator = (Iterator)new a(this);
    AppMethodBeat.o(129455);
    return localIterator;
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"kotlin/text/DelimitedRangesSequence$iterator$1", "", "Lkotlin/ranges/IntRange;", "counter", "", "getCounter", "()I", "setCounter", "(I)V", "currentStartIndex", "getCurrentStartIndex", "setCurrentStartIndex", "nextItem", "getNextItem", "()Lkotlin/ranges/IntRange;", "setNextItem", "(Lkotlin/ranges/IntRange;)V", "nextSearchIndex", "getNextSearchIndex", "setNextSearchIndex", "nextState", "getNextState", "setNextState", "calcNext", "", "hasNext", "", "next", "kotlin-stdlib"})
  public static final class a
    implements a, Iterator<f>
  {
    private int OdE;
    private int Oeb;
    private int Oec;
    private f Oed;
    private int cpF;
    
    a()
    {
      AppMethodBeat.i(129463);
      this.OdE = -1;
      this.Oeb = j.bb(localObject.startIndex, 0, localObject.OdZ.length());
      this.Oec = this.Oeb;
      AppMethodBeat.o(129463);
    }
    
    private final void gzb()
    {
      AppMethodBeat.i(129460);
      if (this.Oec < 0)
      {
        this.OdE = 0;
        this.Oed = null;
        AppMethodBeat.o(129460);
        return;
      }
      if (this.Oee.limit > 0)
      {
        this.cpF += 1;
        if (this.cpF >= this.Oee.limit) {}
      }
      else
      {
        if (this.Oec <= this.Oee.OdZ.length()) {
          break label122;
        }
      }
      this.Oed = new f(this.Oeb, n.aG(this.Oee.OdZ));
      label122:
      o localo;
      for (this.Oec = -1;; this.Oec = -1)
      {
        this.OdE = 1;
        AppMethodBeat.o(129460);
        return;
        localo = (o)this.Oee.Oea.p(this.Oee.OdZ, Integer.valueOf(this.Oec));
        if (localo != null) {
          break;
        }
        this.Oed = new f(this.Oeb, n.aG(this.Oee.OdZ));
      }
      int j = ((Number)localo.first).intValue();
      int i = ((Number)localo.second).intValue();
      this.Oed = j.lv(this.Oeb, j);
      this.Oeb = (j + i);
      j = this.Oeb;
      if (i == 0) {}
      for (i = 1;; i = 0)
      {
        this.Oec = (i + j);
        break;
      }
    }
    
    public final boolean hasNext()
    {
      AppMethodBeat.i(129462);
      if (this.OdE == -1) {
        gzb();
      }
      if (this.OdE == 1)
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