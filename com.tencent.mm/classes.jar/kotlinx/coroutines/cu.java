package kotlinx.coroutines;

import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.Metadata;
import kotlin.ah;

@Metadata(d1={""}, d2={"Lkotlinx/coroutines/ResumeUndispatchedRunnable;", "Ljava/lang/Runnable;", "Lkotlinx/coroutines/Runnable;", "dispatcher", "Lkotlinx/coroutines/CoroutineDispatcher;", "continuation", "Lkotlinx/coroutines/CancellableContinuation;", "", "(Lkotlinx/coroutines/CoroutineDispatcher;Lkotlinx/coroutines/CancellableContinuation;)V", "run", "kotlinx-coroutines-core"}, k=1, mv={1, 5, 1}, xi=48)
final class cu
  implements Runnable
{
  private final al bRx;
  private final p<ah> bgf;
  
  public cu(al paramal, p<? super ah> paramp)
  {
    this.bRx = paramal;
    this.bgf = paramp;
  }
  
  public final void run()
  {
    AppMethodBeat.i(188983);
    this.bgf.a(this.bRx, ah.aiuX);
    AppMethodBeat.o(188983);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     kotlinx.coroutines.cu
 * JD-Core Version:    0.7.0.1
 */