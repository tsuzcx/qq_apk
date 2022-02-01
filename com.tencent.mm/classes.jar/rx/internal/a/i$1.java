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
  
  public final void fvq()
  {
    AppMethodBeat.i(90264);
    if (this.done)
    {
      AppMethodBeat.o(90264);
      return;
    }
    try
    {
      this.akbk.akbi.fvq();
      this.done = true;
      this.akbj.fvq();
      AppMethodBeat.o(90264);
      return;
    }
    finally
    {
      b.a(localThrowable, this);
      AppMethodBeat.o(90264);
    }
  }
  
  public final void jV(T paramT)
  {
    AppMethodBeat.i(90266);
    if (this.done)
    {
      AppMethodBeat.o(90266);
      return;
    }
    try
    {
      this.akbk.akbi.jV(paramT);
      this.akbj.jV(paramT);
      AppMethodBeat.o(90266);
      return;
    }
    finally
    {
      b.a(localThrowable, this, paramT);
      AppMethodBeat.o(90266);
    }
  }
  
  public final void l(Throwable paramThrowable)
  {
    AppMethodBeat.i(90265);
    b.ai(paramThrowable);
    if (this.done)
    {
      AppMethodBeat.o(90265);
      return;
    }
    this.done = true;
    try
    {
      this.akbk.akbi.l(paramThrowable);
      this.akbj.l(paramThrowable);
      AppMethodBeat.o(90265);
      return;
    }
    finally
    {
      b.ai(localThrowable);
      this.akbj.l(new a(Arrays.asList(new Throwable[] { paramThrowable, localThrowable }), (byte)0));
      AppMethodBeat.o(90265);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes11.jar
 * Qualified Name:     rx.internal.a.i.1
 * JD-Core Version:    0.7.0.1
 */