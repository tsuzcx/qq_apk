package kotlinx.coroutines.c;

import a.l;
import com.tencent.matrix.trace.core.AppMethodBeat;

@l(eaO={1, 1, 13}, eaP={""}, eaQ={"Lkotlinx/coroutines/scheduling/CoroutineScheduler$WorkerState;", "", "(Ljava/lang/String;I)V", "CPU_ACQUIRED", "BLOCKING", "PARKING", "RETIRING", "TERMINATED", "kotlinx-coroutines-core"})
public enum a$c
{
  static
  {
    AppMethodBeat.i(118336);
    c localc1 = new c("CPU_ACQUIRED", 0);
    CKj = localc1;
    c localc2 = new c("BLOCKING", 1);
    CKk = localc2;
    c localc3 = new c("PARKING", 2);
    CKl = localc3;
    c localc4 = new c("RETIRING", 3);
    CKm = localc4;
    c localc5 = new c("TERMINATED", 4);
    CKn = localc5;
    CKo = new c[] { localc1, localc2, localc3, localc4, localc5 };
    AppMethodBeat.o(118336);
  }
  
  private a$c() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     kotlinx.coroutines.c.a.c
 * JD-Core Version:    0.7.0.1
 */