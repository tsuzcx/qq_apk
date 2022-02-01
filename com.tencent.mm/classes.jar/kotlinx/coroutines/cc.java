package kotlinx.coroutines;

import d.l;
import java.util.concurrent.CancellationException;

@l(fvt={1, 1, 16}, fvu={""}, fvv={"Lkotlinx/coroutines/TimeoutCancellationException;", "Ljava/util/concurrent/CancellationException;", "Lkotlinx/coroutines/CancellationException;", "Lkotlinx/coroutines/CopyableThrowable;", "message", "", "(Ljava/lang/String;)V", "coroutine", "Lkotlinx/coroutines/Job;", "(Ljava/lang/String;Lkotlinx/coroutines/Job;)V", "createCopy", "kotlinx-coroutines-core"})
public final class cc
  extends CancellationException
  implements w<cc>
{
  public final bj KeN;
  
  private cc(String paramString, bj parambj)
  {
    super(paramString);
    this.KeN = parambj;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     kotlinx.coroutines.cc
 * JD-Core Version:    0.7.0.1
 */