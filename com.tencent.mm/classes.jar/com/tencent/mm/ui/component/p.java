package com.tencent.mm.ui.component;

import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.Metadata;
import kotlin.g.a.a;
import kotlin.g.b.u;
import kotlin.j;
import kotlin.k;
import kotlinx.coroutines.b.w;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/ui/component/UicState;", "", "()V", "flow", "Lkotlinx/coroutines/flow/MutableSharedFlow;", "getFlow", "()Lkotlinx/coroutines/flow/MutableSharedFlow;", "flow$delegate", "Lkotlin/Lazy;", "asFlow", "Lkotlinx/coroutines/flow/SharedFlow;", "update", "", "plugin-uic-annotation"}, k=1, mv={1, 5, 1}, xi=48)
public class p
{
  private final j aeZV;
  
  public p()
  {
    AppMethodBeat.i(250367);
    this.aeZV = k.cm((a)a.aeZW);
    AppMethodBeat.o(250367);
  }
  
  public final w<p> jxP()
  {
    AppMethodBeat.i(250375);
    w localw = (w)this.aeZV.getValue();
    AppMethodBeat.o(250375);
    return localw;
  }
  
  public final boolean jxQ()
  {
    AppMethodBeat.i(250379);
    boolean bool = jxP().jc(this);
    AppMethodBeat.o(250379);
    return bool;
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "Lkotlinx/coroutines/flow/MutableSharedFlow;", "Lcom/tencent/mm/ui/component/UicState;"}, k=3, mv={1, 5, 1}, xi=48)
  static final class a
    extends u
    implements a<w<p>>
  {
    public static final a aeZW;
    
    static
    {
      AppMethodBeat.i(250417);
      aeZW = new a();
      AppMethodBeat.o(250417);
    }
    
    a()
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.ui.component.p
 * JD-Core Version:    0.7.0.1
 */