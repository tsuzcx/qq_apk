package rx.internal.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Arrays;
import rx.a.a;
import rx.a.b;
import rx.e;

final class i$1
  extends rx.i<T>
{
  private boolean done;
  
  i$1(i parami, rx.i parami1, rx.i parami2)
  {
    super(parami1);
  }
  
  public final void c(Throwable paramThrowable)
  {
    AppMethodBeat.i(90265);
    b.R(paramThrowable);
    if (this.done)
    {
      AppMethodBeat.o(90265);
      return;
    }
    this.done = true;
    try
    {
      this.abOr.abOp.c(paramThrowable);
      this.abOq.c(paramThrowable);
      AppMethodBeat.o(90265);
      return;
    }
    catch (Throwable localThrowable)
    {
      b.R(localThrowable);
      this.abOq.c(new a(Arrays.asList(new Throwable[] { paramThrowable, localThrowable }), (byte)0));
      AppMethodBeat.o(90265);
    }
  }
  
  public final void fUB()
  {
    AppMethodBeat.i(90264);
    if (this.done)
    {
      AppMethodBeat.o(90264);
      return;
    }
    try
    {
      this.abOr.abOp.fUB();
      this.done = true;
      this.abOq.fUB();
      AppMethodBeat.o(90264);
      return;
    }
    catch (Throwable localThrowable)
    {
      b.a(localThrowable, this);
      AppMethodBeat.o(90264);
    }
  }
  
  public final void he(T paramT)
  {
    AppMethodBeat.i(90266);
    if (this.done)
    {
      AppMethodBeat.o(90266);
      return;
    }
    try
    {
      this.abOr.abOp.he(paramT);
      this.abOq.he(paramT);
      AppMethodBeat.o(90266);
      return;
    }
    catch (Throwable localThrowable)
    {
      b.a(localThrowable, this, paramT);
      AppMethodBeat.o(90266);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     rx.internal.a.i.1
 * JD-Core Version:    0.7.0.1
 */