package kotlinx.coroutines;

import java.util.concurrent.CancellationException;
import kotlin.l;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lkotlinx/coroutines/TimeoutCancellationException;", "Ljava/util/concurrent/CancellationException;", "Lkotlinx/coroutines/CancellationException;", "Lkotlinx/coroutines/CopyableThrowable;", "message", "", "(Ljava/lang/String;)V", "coroutine", "Lkotlinx/coroutines/Job;", "(Ljava/lang/String;Lkotlinx/coroutines/Job;)V", "createCopy", "kotlinx-coroutines-core"})
public final class cs
  extends CancellationException
  implements ab<cs>
{
  public final bu TVm;
  
  public cs(String paramString)
  {
    this(paramString, null);
  }
  
  public cs(String paramString, bu parambu)
  {
    super(paramString);
    this.TVm = parambu;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     kotlinx.coroutines.cs
 * JD-Core Version:    0.7.0.1
 */