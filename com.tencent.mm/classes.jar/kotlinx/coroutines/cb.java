package kotlinx.coroutines;

import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.l;
import kotlinx.coroutines.internal.u;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"COMPLETING_ALREADY", "Lkotlinx/coroutines/internal/Symbol;", "COMPLETING_ALREADY$annotations", "()V", "COMPLETING_RETRY", "COMPLETING_RETRY$annotations", "COMPLETING_WAITING_CHILDREN", "COMPLETING_WAITING_CHILDREN$annotations", "EMPTY_ACTIVE", "Lkotlinx/coroutines/Empty;", "EMPTY_ACTIVE$annotations", "EMPTY_NEW", "EMPTY_NEW$annotations", "FALSE", "", "RETRY", "SEALED", "SEALED$annotations", "TOO_LATE_TO_CANCEL", "TOO_LATE_TO_CANCEL$annotations", "TRUE", "boxIncomplete", "", "unboxState", "kotlinx-coroutines-core"})
public final class cb
{
  private static final u TVa;
  public static final u TVb;
  private static final u TVc;
  private static final u TVd;
  private static final u TVe;
  private static final bf TVf;
  private static final bf TVg;
  
  static
  {
    AppMethodBeat.i(118155);
    TVa = new u("COMPLETING_ALREADY");
    TVb = new u("COMPLETING_WAITING_CHILDREN");
    TVc = new u("COMPLETING_RETRY");
    TVd = new u("TOO_LATE_TO_CANCEL");
    TVe = new u("SEALED");
    TVf = new bf(false);
    TVg = new bf(true);
    AppMethodBeat.o(118155);
  }
  
  public static final Object gc(Object paramObject)
  {
    AppMethodBeat.i(192429);
    if ((paramObject instanceof bp))
    {
      paramObject = new bq((bp)paramObject);
      AppMethodBeat.o(192429);
      return paramObject;
    }
    AppMethodBeat.o(192429);
    return paramObject;
  }
  
  public static final Object gd(Object paramObject)
  {
    if (!(paramObject instanceof bq)) {}
    for (Object localObject = null;; localObject = paramObject)
    {
      localObject = (bq)localObject;
      if (localObject != null)
      {
        localObject = ((bq)localObject).TUM;
        if (localObject != null) {}
      }
      else
      {
        return paramObject;
      }
      return localObject;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     kotlinx.coroutines.cb
 * JD-Core Version:    0.7.0.1
 */