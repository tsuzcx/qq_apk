package rx.e;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayList;
import java.util.List;
import rx.d.a;

public final class a<T>
  extends b<T, T>
{
  private final rx.internal.a.c<T> Ukv;
  final c<T> Uov;
  
  public a(d.a<T> parama, c<T> paramc)
  {
    super(parama);
    AppMethodBeat.i(90423);
    this.Ukv = rx.internal.a.c.hQG();
    this.Uov = paramc;
    AppMethodBeat.o(90423);
  }
  
  public final void gL(T paramT)
  {
    AppMethodBeat.i(90426);
    c.b[] arrayOfb = ((c.a)this.Uov.get()).UoD;
    int j = arrayOfb.length;
    int i = 0;
    while (i < j)
    {
      arrayOfb[i].gL(paramT);
      i += 1;
    }
    AppMethodBeat.o(90426);
  }
  
  public final void hQw()
  {
    AppMethodBeat.i(90424);
    if (this.Uov.active)
    {
      Object localObject = rx.internal.a.c.hQH();
      c.b[] arrayOfb = this.Uov.gO(localObject);
      int j = arrayOfb.length;
      int i = 0;
      while (i < j)
      {
        arrayOfb[i].gP(localObject);
        i += 1;
      }
    }
    AppMethodBeat.o(90424);
  }
  
  public final void onError(Throwable paramThrowable)
  {
    AppMethodBeat.i(90425);
    if (this.Uov.active)
    {
      Object localObject2 = rx.internal.a.c.P(paramThrowable);
      paramThrowable = null;
      c.b[] arrayOfb = this.Uov.gO(localObject2);
      int j = arrayOfb.length;
      int i = 0;
      for (;;)
      {
        if (i < j)
        {
          Object localObject1 = arrayOfb[i];
          try
          {
            ((c.b)localObject1).gP(localObject2);
            i += 1;
          }
          catch (Throwable localThrowable)
          {
            for (;;)
            {
              localObject1 = paramThrowable;
              if (paramThrowable == null) {
                localObject1 = new ArrayList();
              }
              ((List)localObject1).add(localThrowable);
              paramThrowable = (Throwable)localObject1;
            }
          }
        }
      }
      rx.a.b.kP(paramThrowable);
    }
    AppMethodBeat.o(90425);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     rx.e.a
 * JD-Core Version:    0.7.0.1
 */