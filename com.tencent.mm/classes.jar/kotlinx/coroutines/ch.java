package kotlinx.coroutines;

import d.l;
import java.util.concurrent.CancellationException;

@l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lkotlinx/coroutines/TimeoutCancellationException;", "Ljava/util/concurrent/CancellationException;", "Lkotlinx/coroutines/CancellationException;", "Lkotlinx/coroutines/CopyableThrowable;", "message", "", "(Ljava/lang/String;)V", "coroutine", "Lkotlinx/coroutines/Job;", "(Ljava/lang/String;Lkotlinx/coroutines/Job;)V", "createCopy", "kotlinx-coroutines-core"})
public final class ch
  extends CancellationException
  implements z<ch>
{
  public final bo LSn;
  
  private ch(String paramString, bo parambo)
  {
    super(paramString);
    this.LSn = parambo;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     kotlinx.coroutines.ch
 * JD-Core Version:    0.7.0.1
 */