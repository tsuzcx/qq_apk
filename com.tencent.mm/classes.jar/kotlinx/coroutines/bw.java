package kotlinx.coroutines;

import com.tencent.matrix.trace.core.AppMethodBeat;
import d.l;
import kotlinx.coroutines.internal.t;

@l(gfx={1, 1, 16}, gfy={""}, gfz={"COMPLETING_ALREADY", "Lkotlinx/coroutines/internal/Symbol;", "COMPLETING_ALREADY$annotations", "()V", "COMPLETING_RETRY", "COMPLETING_RETRY$annotations", "COMPLETING_WAITING_CHILDREN", "COMPLETING_WAITING_CHILDREN$annotations", "EMPTY_ACTIVE", "Lkotlinx/coroutines/Empty;", "EMPTY_ACTIVE$annotations", "EMPTY_NEW", "EMPTY_NEW$annotations", "FALSE", "", "RETRY", "SEALED", "SEALED$annotations", "TOO_LATE_TO_CANCEL", "TOO_LATE_TO_CANCEL$annotations", "TRUE", "boxIncomplete", "", "unboxState", "kotlinx-coroutines-core"})
public final class bw
{
  private static final t NIX;
  public static final t NIY;
  private static final t NIZ;
  private static final t NJa;
  private static final t NJb;
  private static final bc NJc;
  private static final bc NJd;
  
  static
  {
    AppMethodBeat.i(118155);
    NIX = new t("COMPLETING_ALREADY");
    NIY = new t("COMPLETING_WAITING_CHILDREN");
    NIZ = new t("COMPLETING_RETRY");
    NJa = new t("TOO_LATE_TO_CANCEL");
    NJb = new t("SEALED");
    NJc = new bc(false);
    NJd = new bc(true);
    AppMethodBeat.o(118155);
  }
  
  public static final Object fU(Object paramObject)
  {
    AppMethodBeat.i(190796);
    if ((paramObject instanceof bm))
    {
      paramObject = new bn((bm)paramObject);
      AppMethodBeat.o(190796);
      return paramObject;
    }
    AppMethodBeat.o(190796);
    return paramObject;
  }
  
  public static final Object fV(Object paramObject)
  {
    if (!(paramObject instanceof bn)) {}
    for (Object localObject = null;; localObject = paramObject)
    {
      localObject = (bn)localObject;
      if (localObject != null)
      {
        localObject = ((bn)localObject).NIK;
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     kotlinx.coroutines.bw
 * JD-Core Version:    0.7.0.1
 */