package kotlinx.coroutines;

import com.tencent.matrix.trace.core.AppMethodBeat;
import d.l;
import kotlinx.coroutines.internal.s;

@l(fNY={1, 1, 16}, fNZ={""}, fOa={"COMPLETING_ALREADY", "Lkotlinx/coroutines/internal/Symbol;", "COMPLETING_ALREADY$annotations", "()V", "COMPLETING_RETRY", "COMPLETING_RETRY$annotations", "COMPLETING_WAITING_CHILDREN", "COMPLETING_WAITING_CHILDREN$annotations", "EMPTY_ACTIVE", "Lkotlinx/coroutines/Empty;", "EMPTY_ACTIVE$annotations", "EMPTY_NEW", "EMPTY_NEW$annotations", "FALSE", "", "RETRY", "SEALED", "SEALED$annotations", "TOO_LATE_TO_CANCEL", "TOO_LATE_TO_CANCEL$annotations", "TRUE", "boxIncomplete", "", "unboxState", "kotlinx-coroutines-core"})
public final class bt
{
  private static final s LSb;
  public static final s LSc;
  private static final s LSd;
  private static final s LSe;
  private static final s LSf;
  private static final bb LSg;
  private static final bb LSh;
  
  static
  {
    AppMethodBeat.i(118155);
    LSb = new s("COMPLETING_ALREADY");
    LSc = new s("COMPLETING_WAITING_CHILDREN");
    LSd = new s("COMPLETING_RETRY");
    LSe = new s("TOO_LATE_TO_CANCEL");
    LSf = new s("SEALED");
    LSg = new bb(false);
    LSh = new bb(true);
    AppMethodBeat.o(118155);
  }
  
  public static final Object fR(Object paramObject)
  {
    AppMethodBeat.i(191185);
    if ((paramObject instanceof bj))
    {
      paramObject = new bk((bj)paramObject);
      AppMethodBeat.o(191185);
      return paramObject;
    }
    AppMethodBeat.o(191185);
    return paramObject;
  }
  
  public static final Object fS(Object paramObject)
  {
    if (!(paramObject instanceof bk)) {}
    for (Object localObject = null;; localObject = paramObject)
    {
      localObject = (bk)localObject;
      if (localObject != null)
      {
        localObject = ((bk)localObject).LRO;
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
 * Qualified Name:     kotlinx.coroutines.bt
 * JD-Core Version:    0.7.0.1
 */