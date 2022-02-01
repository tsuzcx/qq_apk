package kotlinx.coroutines.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.Metadata;
import kotlin.ah;
import kotlin.g.a.b;
import kotlinx.coroutines.internal.v;
import kotlinx.coroutines.p;

@Metadata(d1={""}, d2={"Lkotlinx/coroutines/channels/SendElementWithUndeliveredHandler;", "E", "Lkotlinx/coroutines/channels/SendElement;", "pollResult", "cont", "Lkotlinx/coroutines/CancellableContinuation;", "", "onUndeliveredElement", "Lkotlin/Function1;", "Lkotlinx/coroutines/internal/OnUndeliveredElement;", "(Ljava/lang/Object;Lkotlinx/coroutines/CancellableContinuation;Lkotlin/jvm/functions/Function1;)V", "remove", "", "undeliveredElement", "kotlinx-coroutines-core"}, k=1, mv={1, 5, 1}, xi=48)
public final class ad<E>
  extends ac<E>
{
  public final b<E, ah> ajxf;
  
  public ad(E paramE, p<? super ah> paramp, b<? super E, ah> paramb)
  {
    super(paramE, paramp);
    this.ajxf = paramb;
  }
  
  public final void kDv()
  {
    AppMethodBeat.i(189315);
    v.a(this.ajxf, kDg(), this.ajwe.getContext());
    AppMethodBeat.o(189315);
  }
  
  public final boolean remove()
  {
    AppMethodBeat.i(189308);
    if (!super.remove())
    {
      AppMethodBeat.o(189308);
      return false;
    }
    kDv();
    AppMethodBeat.o(189308);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     kotlinx.coroutines.a.ad
 * JD-Core Version:    0.7.0.1
 */