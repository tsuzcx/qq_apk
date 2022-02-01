package kotlinx.coroutines;

import d.l;
import java.util.concurrent.CancellationException;

@l(gfx={1, 1, 16}, gfy={""}, gfz={"Lkotlinx/coroutines/TimeoutCancellationException;", "Ljava/util/concurrent/CancellationException;", "Lkotlinx/coroutines/CancellationException;", "Lkotlinx/coroutines/CopyableThrowable;", "message", "", "(Ljava/lang/String;)V", "coroutine", "Lkotlinx/coroutines/Job;", "(Ljava/lang/String;Lkotlinx/coroutines/Job;)V", "createCopy", "kotlinx-coroutines-core"})
public final class cl
  extends CancellationException
  implements aa<cl>
{
  public final br NJj;
  
  private cl(String paramString, br parambr)
  {
    super(paramString);
    this.NJj = parambr;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     kotlinx.coroutines.cl
 * JD-Core Version:    0.7.0.1
 */