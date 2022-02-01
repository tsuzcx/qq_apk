package kotlinx.coroutines;

import com.tencent.matrix.trace.core.AppMethodBeat;
import d.l;
import kotlinx.coroutines.a.m;

@l(fvt={1, 1, 16}, fvu={""}, fvv={"COMPLETING_ALREADY", "Lkotlinx/coroutines/internal/Symbol;", "COMPLETING_ALREADY$annotations", "()V", "COMPLETING_RETRY", "COMPLETING_RETRY$annotations", "COMPLETING_WAITING_CHILDREN", "COMPLETING_WAITING_CHILDREN$annotations", "EMPTY_ACTIVE", "Lkotlinx/coroutines/Empty;", "EMPTY_ACTIVE$annotations", "EMPTY_NEW", "EMPTY_NEW$annotations", "FALSE", "", "RETRY", "SEALED", "SEALED$annotations", "TOO_LATE_TO_CANCEL", "TOO_LATE_TO_CANCEL$annotations", "TRUE", "boxIncomplete", "", "unboxState", "kotlinx-coroutines-core"})
public final class bo
{
  private static final m KeB;
  public static final m KeC;
  private static final m KeD;
  private static final m KeE;
  private static final m KeF;
  private static final aw KeG;
  private static final aw KeH;
  
  static
  {
    AppMethodBeat.i(118155);
    KeB = new m("COMPLETING_ALREADY");
    KeC = new m("COMPLETING_WAITING_CHILDREN");
    KeD = new m("COMPLETING_RETRY");
    KeE = new m("TOO_LATE_TO_CANCEL");
    KeF = new m("SEALED");
    KeG = new aw(false);
    KeH = new aw(true);
    AppMethodBeat.o(118155);
  }
  
  public static final Object fJ(Object paramObject)
  {
    AppMethodBeat.i(190061);
    if ((paramObject instanceof be))
    {
      paramObject = new bf((be)paramObject);
      AppMethodBeat.o(190061);
      return paramObject;
    }
    AppMethodBeat.o(190061);
    return paramObject;
  }
  
  public static final Object fK(Object paramObject)
  {
    if (!(paramObject instanceof bf)) {}
    for (Object localObject = null;; localObject = paramObject)
    {
      localObject = (bf)localObject;
      if (localObject != null)
      {
        localObject = ((bf)localObject).Keo;
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     kotlinx.coroutines.bo
 * JD-Core Version:    0.7.0.1
 */