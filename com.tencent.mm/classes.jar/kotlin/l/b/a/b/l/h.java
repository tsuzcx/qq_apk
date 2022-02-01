package kotlin.l.b.a.b.l;

import com.tencent.matrix.trace.core.AppMethodBeat;

final class h<T>
{
  private final Thread thread;
  final T value;
  
  h(T paramT)
  {
    AppMethodBeat.i(186264);
    this.value = paramT;
    this.thread = Thread.currentThread();
    AppMethodBeat.o(186264);
  }
  
  public final boolean hasValue()
  {
    AppMethodBeat.i(186265);
    if (this.thread == Thread.currentThread())
    {
      AppMethodBeat.o(186265);
      return true;
    }
    AppMethodBeat.o(186265);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     kotlin.l.b.a.b.l.h
 * JD-Core Version:    0.7.0.1
 */