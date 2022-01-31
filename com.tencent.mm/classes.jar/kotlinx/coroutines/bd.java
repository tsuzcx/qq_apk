package kotlinx.coroutines;

import a.f.b.j;
import a.l;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.concurrent.CancellationException;

@l(eaO={1, 1, 13}, eaP={""}, eaQ={"Lkotlinx/coroutines/JobCancellationException;", "Ljava/util/concurrent/CancellationException;", "Lkotlinx/coroutines/CancellationException;", "message", "", "cause", "", "job", "Lkotlinx/coroutines/Job;", "(Ljava/lang/String;Ljava/lang/Throwable;Lkotlinx/coroutines/Job;)V", "equals", "", "other", "", "fillInStackTrace", "hashCode", "", "toString", "kotlinx-coroutines-core"})
public final class bd
  extends CancellationException
{
  public final bc CIm;
  
  public bd(String paramString, Throwable paramThrowable, bc parambc)
  {
    super(paramString);
    AppMethodBeat.i(118468);
    this.CIm = parambc;
    if (paramThrowable != null) {
      initCause(paramThrowable);
    }
    AppMethodBeat.o(118468);
  }
  
  public final boolean equals(Object paramObject)
  {
    AppMethodBeat.i(118466);
    if ((paramObject == (bd)this) || (((paramObject instanceof bd)) && (j.e(((bd)paramObject).getMessage(), getMessage())) && (j.e(((bd)paramObject).CIm, this.CIm)) && (j.e(((bd)paramObject).getCause(), getCause()))))
    {
      AppMethodBeat.o(118466);
      return true;
    }
    AppMethodBeat.o(118466);
    return false;
  }
  
  public final Throwable fillInStackTrace()
  {
    AppMethodBeat.i(118464);
    if (af.epy())
    {
      localThrowable = super.fillInStackTrace();
      j.p(localThrowable, "super.fillInStackTrace()");
      AppMethodBeat.o(118464);
      return localThrowable;
    }
    Throwable localThrowable = (Throwable)this;
    AppMethodBeat.o(118464);
    return localThrowable;
  }
  
  public final int hashCode()
  {
    AppMethodBeat.i(118467);
    Object localObject = getMessage();
    if (localObject == null) {
      j.ebi();
    }
    int j = ((String)localObject).hashCode();
    int k = this.CIm.hashCode();
    localObject = getCause();
    if (localObject != null) {}
    for (int i = ((Throwable)localObject).hashCode();; i = 0)
    {
      AppMethodBeat.o(118467);
      return i + (j * 31 + k) * 31;
    }
  }
  
  public final String toString()
  {
    AppMethodBeat.i(118465);
    String str = super.toString() + "; job=" + this.CIm;
    AppMethodBeat.o(118465);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     kotlinx.coroutines.bd
 * JD-Core Version:    0.7.0.1
 */