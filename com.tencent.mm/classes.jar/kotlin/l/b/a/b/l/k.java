package kotlin.l.b.a.b.l;

import com.tencent.matrix.trace.core.AppMethodBeat;

final class k<T>
{
  private final Thread thread;
  final T value;
  
  k(T paramT)
  {
    AppMethodBeat.i(191513);
    this.value = paramT;
    this.thread = Thread.currentThread();
    AppMethodBeat.o(191513);
  }
  
  public final boolean ktm()
  {
    AppMethodBeat.i(191515);
    if (this.thread == Thread.currentThread())
    {
      AppMethodBeat.o(191515);
      return true;
    }
    AppMethodBeat.o(191515);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     kotlin.l.b.a.b.l.k
 * JD-Core Version:    0.7.0.1
 */