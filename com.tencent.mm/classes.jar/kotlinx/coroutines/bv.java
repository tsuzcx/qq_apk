package kotlinx.coroutines;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.concurrent.CancellationException;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lkotlinx/coroutines/JobCancellationException;", "Ljava/util/concurrent/CancellationException;", "Lkotlinx/coroutines/CancellationException;", "Lkotlinx/coroutines/CopyableThrowable;", "message", "", "cause", "", "job", "Lkotlinx/coroutines/Job;", "(Ljava/lang/String;Ljava/lang/Throwable;Lkotlinx/coroutines/Job;)V", "createCopy", "equals", "", "other", "", "fillInStackTrace", "hashCode", "", "toString", "kotlinx-coroutines-core"})
public final class bv
  extends CancellationException
  implements ab<bv>
{
  public final bu TUQ;
  
  public bv(String paramString, Throwable paramThrowable, bu parambu)
  {
    super(paramString);
    AppMethodBeat.i(118151);
    this.TUQ = parambu;
    if (paramThrowable != null) {
      initCause(paramThrowable);
    }
    AppMethodBeat.o(118151);
  }
  
  public final boolean equals(Object paramObject)
  {
    AppMethodBeat.i(118149);
    if ((paramObject == (bv)this) || (((paramObject instanceof bv)) && (p.j(((bv)paramObject).getMessage(), getMessage())) && (p.j(((bv)paramObject).TUQ, this.TUQ)) && (p.j(((bv)paramObject).getCause(), getCause()))))
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
    if (an.getDEBUG())
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
      p.hyc();
    }
    int j = ((String)localObject).hashCode();
    int k = this.TUQ.hashCode();
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
    String str = super.toString() + "; job=" + this.TUQ;
    AppMethodBeat.o(118148);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     kotlinx.coroutines.bv
 * JD-Core Version:    0.7.0.1
 */