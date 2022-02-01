package kotlin.l.b.a.b.l;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.concurrent.locks.Lock;

public final class c
  implements j
{
  private final Lock KZg;
  
  private c(Lock paramLock)
  {
    AppMethodBeat.i(191514);
    this.KZg = paramLock;
    AppMethodBeat.o(191514);
  }
  
  public final void lock()
  {
    AppMethodBeat.i(191521);
    this.KZg.lock();
    AppMethodBeat.o(191521);
  }
  
  public final void unlock()
  {
    AppMethodBeat.i(191524);
    this.KZg.unlock();
    AppMethodBeat.o(191524);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     kotlin.l.b.a.b.l.c
 * JD-Core Version:    0.7.0.1
 */