package d.l.b.a.b.l;

import com.tencent.matrix.trace.core.AppMethodBeat;

final class h<T>
{
  private final Thread thread;
  final T value;
  
  h(T paramT)
  {
    AppMethodBeat.i(193311);
    this.value = paramT;
    this.thread = Thread.currentThread();
    AppMethodBeat.o(193311);
  }
  
  public final boolean hasValue()
  {
    AppMethodBeat.i(193312);
    if (this.thread == Thread.currentThread())
    {
      AppMethodBeat.o(193312);
      return true;
    }
    AppMethodBeat.o(193312);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     d.l.b.a.b.l.h
 * JD-Core Version:    0.7.0.1
 */