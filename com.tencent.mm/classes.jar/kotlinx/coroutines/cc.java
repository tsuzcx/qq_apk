package kotlinx.coroutines;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.concurrent.CancellationException;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lkotlinx/coroutines/JobCancellationException;", "Ljava/util/concurrent/CancellationException;", "Lkotlinx/coroutines/CancellationException;", "Lkotlinx/coroutines/CopyableThrowable;", "message", "", "cause", "", "job", "Lkotlinx/coroutines/Job;", "(Ljava/lang/String;Ljava/lang/Throwable;Lkotlinx/coroutines/Job;)V", "createCopy", "equals", "", "other", "", "fillInStackTrace", "hashCode", "", "toString", "kotlinx-coroutines-core"}, k=1, mv={1, 5, 1}, xi=48)
public final class cc
  extends CancellationException
  implements aj<cc>
{
  public final cb job;
  
  public cc(String paramString, Throwable paramThrowable, cb paramcb)
  {
    super(paramString);
    AppMethodBeat.i(118151);
    this.job = paramcb;
    if (paramThrowable != null) {
      initCause(paramThrowable);
    }
    AppMethodBeat.o(118151);
  }
  
  public final boolean equals(Object paramObject)
  {
    AppMethodBeat.i(118149);
    if ((paramObject == this) || (((paramObject instanceof cc)) && (s.p(((cc)paramObject).getMessage(), getMessage())) && (s.p(((cc)paramObject).job, this.job)) && (s.p(((cc)paramObject).getCause(), getCause()))))
    {
      AppMethodBeat.o(118149);
      return true;
    }
    AppMethodBeat.o(118149);
    return false;
  }
  
  public final Throwable fillInStackTrace()
  {
    AppMethodBeat.i(118147);
    if (au.DEBUG)
    {
      localThrowable = super.fillInStackTrace();
      AppMethodBeat.o(118147);
      return localThrowable;
    }
    setStackTrace((StackTraceElement[])new StackTraceElement[0]);
    Throwable localThrowable = (Throwable)this;
    AppMethodBeat.o(118147);
    return localThrowable;
  }
  
  public final int hashCode()
  {
    AppMethodBeat.i(118150);
    Object localObject = getMessage();
    s.checkNotNull(localObject);
    int j = ((String)localObject).hashCode();
    int k = this.job.hashCode();
    localObject = getCause();
    if (localObject == null) {}
    for (int i = 0;; i = ((Throwable)localObject).hashCode())
    {
      AppMethodBeat.o(118150);
      return i + (j * 31 + k) * 31;
    }
  }
  
  public final String toString()
  {
    AppMethodBeat.i(118148);
    String str = super.toString() + "; job=" + this.job;
    AppMethodBeat.o(118148);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     kotlinx.coroutines.cc
 * JD-Core Version:    0.7.0.1
 */