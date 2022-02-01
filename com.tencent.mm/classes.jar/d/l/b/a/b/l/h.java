package d.l.b.a.b.l;

import com.tencent.matrix.trace.core.AppMethodBeat;

final class h<T>
{
  private final Thread thread;
  final T value;
  
  h(T paramT)
  {
    AppMethodBeat.i(187787);
    this.value = paramT;
    this.thread = Thread.currentThread();
    AppMethodBeat.o(187787);
  }
  
  public final boolean hasValue()
  {
    AppMethodBeat.i(187788);
    if (this.thread == Thread.currentThread())
    {
      AppMethodBeat.o(187788);
      return true;
    }
    AppMethodBeat.o(187788);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     d.l.b.a.b.l.h
 * JD-Core Version:    0.7.0.1
 */