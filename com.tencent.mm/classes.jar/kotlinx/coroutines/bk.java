package kotlinx.coroutines;

import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.Metadata;

@Metadata(d1={""}, d2={"Lkotlinx/coroutines/DisposeOnCompletion;", "Lkotlinx/coroutines/JobNode;", "handle", "Lkotlinx/coroutines/DisposableHandle;", "(Lkotlinx/coroutines/DisposableHandle;)V", "invoke", "", "cause", "", "kotlinx-coroutines-core"}, k=1, mv={1, 5, 1}, xi=48)
public final class bk
  extends ch
{
  private final bi ajvj;
  
  public bk(bi parambi)
  {
    this.ajvj = parambi;
  }
  
  public final void N(Throwable paramThrowable)
  {
    AppMethodBeat.i(188850);
    this.ajvj.dispose();
    AppMethodBeat.o(188850);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     kotlinx.coroutines.bk
 * JD-Core Version:    0.7.0.1
 */