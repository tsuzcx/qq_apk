package kotlinx.coroutines;

import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.Metadata;
import kotlinx.coroutines.internal.ac;

@Metadata(d1={""}, d2={"COMPLETING_ALREADY", "Lkotlinx/coroutines/internal/Symbol;", "getCOMPLETING_ALREADY$annotations", "()V", "COMPLETING_RETRY", "getCOMPLETING_RETRY$annotations", "COMPLETING_WAITING_CHILDREN", "getCOMPLETING_WAITING_CHILDREN$annotations", "EMPTY_ACTIVE", "Lkotlinx/coroutines/Empty;", "getEMPTY_ACTIVE$annotations", "EMPTY_NEW", "getEMPTY_NEW$annotations", "FALSE", "", "RETRY", "SEALED", "getSEALED$annotations", "TOO_LATE_TO_CANCEL", "getTOO_LATE_TO_CANCEL$annotations", "TRUE", "boxIncomplete", "", "unboxState", "kotlinx-coroutines-core"}, k=2, mv={1, 5, 1}, xi=48)
public final class cj
{
  private static final ac ajwD;
  public static final ac ajwE;
  private static final ac ajwF;
  private static final ac ajwG;
  private static final ac ajwH;
  private static final bl ajwI;
  private static final bl ajwJ;
  
  static
  {
    AppMethodBeat.i(118155);
    ajwD = new ac("COMPLETING_ALREADY");
    ajwE = new ac("COMPLETING_WAITING_CHILDREN");
    ajwF = new ac("COMPLETING_RETRY");
    ajwG = new ac("TOO_LATE_TO_CANCEL");
    ajwH = new ac("SEALED");
    ajwI = new bl(false);
    ajwJ = new bl(true);
    AppMethodBeat.o(118155);
  }
  
  public static final Object iM(Object paramObject)
  {
    AppMethodBeat.i(188798);
    if ((paramObject instanceof bw))
    {
      paramObject = new bx((bw)paramObject);
      AppMethodBeat.o(188798);
      return paramObject;
    }
    AppMethodBeat.o(188798);
    return paramObject;
  }
  
  public static final Object iN(Object paramObject)
  {
    if ((paramObject instanceof bx)) {}
    for (bx localbx = (bx)paramObject; localbx == null; localbx = null) {
      return paramObject;
    }
    return localbx.ajwq;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     kotlinx.coroutines.cj
 * JD-Core Version:    0.7.0.1
 */