package kotlinx.coroutines.e;

import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.Metadata;
import kotlinx.coroutines.internal.ac;

@Metadata(d1={""}, d2={"EMPTY_LOCKED", "Lkotlinx/coroutines/sync/Empty;", "getEMPTY_LOCKED$annotations", "()V", "EMPTY_UNLOCKED", "getEMPTY_UNLOCKED$annotations", "LOCKED", "Lkotlinx/coroutines/internal/Symbol;", "getLOCKED$annotations", "LOCK_FAIL", "getLOCK_FAIL$annotations", "UNLOCKED", "getUNLOCKED$annotations", "UNLOCK_FAIL", "getUNLOCK_FAIL$annotations", "Mutex", "Lkotlinx/coroutines/sync/Mutex;", "locked", "", "withLock", "T", "owner", "", "action", "Lkotlin/Function0;", "(Lkotlinx/coroutines/sync/Mutex;Ljava/lang/Object;Lkotlin/jvm/functions/Function0;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "kotlinx-coroutines-core"}, k=2, mv={1, 5, 1}, xi=48)
public final class e
{
  private static final ac ajCa;
  private static final ac ajCb;
  private static final ac ajCc;
  private static final ac ajCd;
  private static final b ajCe;
  private static final b ajCf;
  
  static
  {
    AppMethodBeat.i(188997);
    ajCa = new ac("LOCK_FAIL");
    ajCb = new ac("UNLOCK_FAIL");
    ajCc = new ac("LOCKED");
    ajCd = new ac("UNLOCKED");
    ajCe = new b(ajCc);
    ajCf = new b(ajCd);
    AppMethodBeat.o(188997);
  }
  
  public static final c kEL()
  {
    AppMethodBeat.i(188943);
    c localc = (c)new d(false);
    AppMethodBeat.o(188943);
    return localc;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     kotlinx.coroutines.e.e
 * JD-Core Version:    0.7.0.1
 */