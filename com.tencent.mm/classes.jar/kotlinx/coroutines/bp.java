package kotlinx.coroutines;

import com.tencent.matrix.trace.core.AppMethodBeat;
import d.g.b.k;
import d.l;
import java.util.concurrent.CancellationException;

@l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lkotlinx/coroutines/JobCancellationException;", "Ljava/util/concurrent/CancellationException;", "Lkotlinx/coroutines/CancellationException;", "Lkotlinx/coroutines/CopyableThrowable;", "message", "", "cause", "", "job", "Lkotlinx/coroutines/Job;", "(Ljava/lang/String;Ljava/lang/Throwable;Lkotlinx/coroutines/Job;)V", "createCopy", "equals", "", "other", "", "fillInStackTrace", "hashCode", "", "toString", "kotlinx-coroutines-core"})
public final class bp
  extends CancellationException
  implements z<bp>
{
  public final bo LRS;
  
  public bp(String paramString, Throwable paramThrowable, bo parambo)
  {
    super(paramString);
    AppMethodBeat.i(118151);
    this.LRS = parambo;
    if (paramThrowable != null) {
      initCause(paramThrowable);
    }
    AppMethodBeat.o(118151);
  }
  
  public final boolean equals(Object paramObject)
  {
    AppMethodBeat.i(118149);
    if ((paramObject == (bp)this) || (((paramObject instanceof bp)) && (k.g(((bp)paramObject).getMessage(), getMessage())) && (k.g(((bp)paramObject).LRS, this.LRS)) && (k.g(((bp)paramObject).getCause(), getCause()))))
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
    if (al.getDEBUG())
    {
      localThrowable = super.fillInStackTrace();
      AppMethodBeat.o(118147);
      return localThrowable;
    }
    Throwable localThrowable = (Throwable)this;
    AppMethodBeat.o(118147);
    return localThrowable;
  }
  
  public final int hashCode()
  {
    AppMethodBeat.i(118150);
    Object localObject = getMessage();
    if (localObject == null) {
      k.fOy();
    }
    int j = ((String)localObject).hashCode();
    int k = this.LRS.hashCode();
    localObject = getCause();
    if (localObject != null) {}
    for (int i = ((Throwable)localObject).hashCode();; i = 0)
    {
      AppMethodBeat.o(118150);
      return i + (j * 31 + k) * 31;
    }
  }
  
  public final String toString()
  {
    AppMethodBeat.i(118148);
    String str = super.toString() + "; job=" + this.LRS;
    AppMethodBeat.o(118148);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     kotlinx.coroutines.bp
 * JD-Core Version:    0.7.0.1
 */