package kotlinx.coroutines;

import java.util.concurrent.CancellationException;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lkotlinx/coroutines/TimeoutCancellationException;", "Ljava/util/concurrent/CancellationException;", "Lkotlinx/coroutines/CancellationException;", "Lkotlinx/coroutines/CopyableThrowable;", "message", "", "(Ljava/lang/String;)V", "coroutine", "Lkotlinx/coroutines/Job;", "(Ljava/lang/String;Lkotlinx/coroutines/Job;)V", "createCopy", "kotlinx-coroutines-core"})
public final class cy
  extends CancellationException
  implements ad<cy>
{
  public final by abxQ;
  
  public cy(String paramString)
  {
    this(paramString, null);
  }
  
  public cy(String paramString, by paramby)
  {
    super(paramString);
    this.abxQ = paramby;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     kotlinx.coroutines.cy
 * JD-Core Version:    0.7.0.1
 */