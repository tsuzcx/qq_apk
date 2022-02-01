package kotlinx.coroutines;

import com.tencent.matrix.trace.core.AppMethodBeat;
import d.g.b.k;
import d.l;
import java.util.concurrent.CancellationException;

@l(fvt={1, 1, 16}, fvu={""}, fvv={"Lkotlinx/coroutines/JobCancellationException;", "Ljava/util/concurrent/CancellationException;", "Lkotlinx/coroutines/CancellationException;", "Lkotlinx/coroutines/CopyableThrowable;", "message", "", "cause", "", "job", "Lkotlinx/coroutines/Job;", "(Ljava/lang/String;Ljava/lang/Throwable;Lkotlinx/coroutines/Job;)V", "createCopy", "equals", "", "other", "", "fillInStackTrace", "hashCode", "", "toString", "kotlinx-coroutines-core"})
public final class bk
  extends CancellationException
  implements w<bk>
{
  public final bj Kes;
  
  public bk(String paramString, Throwable paramThrowable, bj parambj)
  {
    super(paramString);
    AppMethodBeat.i(118151);
    this.Kes = parambj;
    if (paramThrowable != null) {
      initCause(paramThrowable);
    }
    AppMethodBeat.o(118151);
  }
  
  public final boolean equals(Object paramObject)
  {
    AppMethodBeat.i(118149);
    if ((paramObject == (bk)this) || (((paramObject instanceof bk)) && (k.g(((bk)paramObject).getMessage(), getMessage())) && (k.g(((bk)paramObject).Kes, this.Kes)) && (k.g(((bk)paramObject).getCause(), getCause()))))
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
    if (ah.getDEBUG())
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
      k.fvU();
    }
    int j = ((String)localObject).hashCode();
    int k = this.Kes.hashCode();
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
    String str = super.toString() + "; job=" + this.Kes;
    AppMethodBeat.o(118148);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     kotlinx.coroutines.bk
 * JD-Core Version:    0.7.0.1
 */