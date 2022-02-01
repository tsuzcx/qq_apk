package kotlinx.coroutines;

import com.tencent.matrix.trace.core.AppMethodBeat;
import d.l;
import kotlinx.coroutines.internal.t;

@l(gjZ={1, 1, 16}, gka={""}, gkb={"COMPLETING_ALREADY", "Lkotlinx/coroutines/internal/Symbol;", "COMPLETING_ALREADY$annotations", "()V", "COMPLETING_RETRY", "COMPLETING_RETRY$annotations", "COMPLETING_WAITING_CHILDREN", "COMPLETING_WAITING_CHILDREN$annotations", "EMPTY_ACTIVE", "Lkotlinx/coroutines/Empty;", "EMPTY_ACTIVE$annotations", "EMPTY_NEW", "EMPTY_NEW$annotations", "FALSE", "", "RETRY", "SEALED", "SEALED$annotations", "TOO_LATE_TO_CANCEL", "TOO_LATE_TO_CANCEL$annotations", "TRUE", "boxIncomplete", "", "unboxState", "kotlinx-coroutines-core"})
public final class bw
{
  private static final t Ogd;
  public static final t Oge;
  private static final t Ogf;
  private static final t Ogg;
  private static final t Ogh;
  private static final bc Ogi;
  private static final bc Ogj;
  
  static
  {
    AppMethodBeat.i(118155);
    Ogd = new t("COMPLETING_ALREADY");
    Oge = new t("COMPLETING_WAITING_CHILDREN");
    Ogf = new t("COMPLETING_RETRY");
    Ogg = new t("TOO_LATE_TO_CANCEL");
    Ogh = new t("SEALED");
    Ogi = new bc(false);
    Ogj = new bc(true);
    AppMethodBeat.o(118155);
  }
  
  public static final Object fX(Object paramObject)
  {
    AppMethodBeat.i(209287);
    if ((paramObject instanceof bm))
    {
      paramObject = new bn((bm)paramObject);
      AppMethodBeat.o(209287);
      return paramObject;
    }
    AppMethodBeat.o(209287);
    return paramObject;
  }
  
  public static final Object fY(Object paramObject)
  {
    if (!(paramObject instanceof bn)) {}
    for (Object localObject = null;; localObject = paramObject)
    {
      localObject = (bn)localObject;
      if (localObject != null)
      {
        localObject = ((bn)localObject).OfQ;
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