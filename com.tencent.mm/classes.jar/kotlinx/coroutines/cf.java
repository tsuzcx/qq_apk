package kotlinx.coroutines;

import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.l;
import kotlinx.coroutines.internal.v;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"COMPLETING_ALREADY", "Lkotlinx/coroutines/internal/Symbol;", "COMPLETING_ALREADY$annotations", "()V", "COMPLETING_RETRY", "COMPLETING_RETRY$annotations", "COMPLETING_WAITING_CHILDREN", "COMPLETING_WAITING_CHILDREN$annotations", "EMPTY_ACTIVE", "Lkotlinx/coroutines/Empty;", "EMPTY_ACTIVE$annotations", "EMPTY_NEW", "EMPTY_NEW$annotations", "FALSE", "", "RETRY", "SEALED", "SEALED$annotations", "TOO_LATE_TO_CANCEL", "TOO_LATE_TO_CANCEL$annotations", "TRUE", "boxIncomplete", "", "unboxState", "kotlinx-coroutines-core"})
public final class cf
{
  private static final v abxD;
  public static final v abxE;
  private static final v abxF;
  private static final v abxG;
  private static final v abxH;
  private static final bh abxI;
  private static final bh abxJ;
  
  static
  {
    AppMethodBeat.i(118155);
    abxD = new v("COMPLETING_ALREADY");
    abxE = new v("COMPLETING_WAITING_CHILDREN");
    abxF = new v("COMPLETING_RETRY");
    abxG = new v("TOO_LATE_TO_CANCEL");
    abxH = new v("SEALED");
    abxI = new bh(false);
    abxJ = new bh(true);
    AppMethodBeat.o(118155);
  }
  
  public static final Object gk(Object paramObject)
  {
    AppMethodBeat.i(204912);
    if ((paramObject instanceof bt))
    {
      paramObject = new bu((bt)paramObject);
      AppMethodBeat.o(204912);
      return paramObject;
    }
    AppMethodBeat.o(204912);
    return paramObject;
  }
  
  public static final Object gl(Object paramObject)
  {
    if (!(paramObject instanceof bu)) {}
    for (Object localObject = null;; localObject = paramObject)
    {
      localObject = (bu)localObject;
      if (localObject != null)
      {
        localObject = ((bu)localObject).abxq;
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     kotlinx.coroutines.cf
 * JD-Core Version:    0.7.0.1
 */