package kotlinx.coroutines;

import java.util.concurrent.CancellationException;
import kotlin.Metadata;

@Metadata(d1={""}, d2={"Lkotlinx/coroutines/TimeoutCancellationException;", "Ljava/util/concurrent/CancellationException;", "Lkotlinx/coroutines/CancellationException;", "Lkotlinx/coroutines/CopyableThrowable;", "message", "", "(Ljava/lang/String;)V", "coroutine", "Lkotlinx/coroutines/Job;", "(Ljava/lang/String;Lkotlinx/coroutines/Job;)V", "createCopy", "kotlinx-coroutines-core"}, k=1, mv={1, 5, 1}, xi=48)
public final class da
  extends CancellationException
  implements aj<da>
{
  public final cb ajwP;
  
  public da(String paramString)
  {
    this(paramString, null);
  }
  
  public da(String paramString, cb paramcb)
  {
    super(paramString);
    this.ajwP = paramcb;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     kotlinx.coroutines.da
 * JD-Core Version:    0.7.0.1
 */