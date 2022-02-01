package kotlin.l.b.a.b.l;

import com.tencent.matrix.trace.core.AppMethodBeat;

final class h<T>
{
  private final Thread thread;
  final T value;
  
  h(T paramT)
  {
    AppMethodBeat.i(269678);
    this.value = paramT;
    this.thread = Thread.currentThread();
    AppMethodBeat.o(269678);
  }
  
  public final boolean iIU()
  {
    AppMethodBeat.i(269680);
    if (this.thread == Thread.currentThread())
    {
      AppMethodBeat.o(269680);
      return true;
    }
    AppMethodBeat.o(269680);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     kotlin.l.b.a.b.l.h
 * JD-Core Version:    0.7.0.1
 */