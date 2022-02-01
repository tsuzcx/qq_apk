package rx.e;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayList;
import java.util.List;
import rx.d.a;

public final class a<T>
  extends b<T, T>
{
  private final rx.internal.a.c<T> abNR;
  final c<T> abRJ;
  
  public a(d.a<T> parama, c<T> paramc)
  {
    super(parama);
    AppMethodBeat.i(90423);
    this.abNR = rx.internal.a.c.iVP();
    this.abRJ = paramc;
    AppMethodBeat.o(90423);
  }
  
  public final void c(Throwable paramThrowable)
  {
    AppMethodBeat.i(90425);
    if (this.abRJ.active)
    {
      Object localObject2 = rx.internal.a.c.T(paramThrowable);
      paramThrowable = null;
      c.b[] arrayOfb = this.abRJ.hi(localObject2);
      int j = arrayOfb.length;
      int i = 0;
      for (;;)
      {
        if (i < j)
        {
          Object localObject1 = arrayOfb[i];
          try
          {
            ((c.b)localObject1).hj(localObject2);
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
      rx.a.b.lM(paramThrowable);
    }
    AppMethodBeat.o(90425);
  }
  
  public final void fUB()
  {
    AppMethodBeat.i(90424);
    if (this.abRJ.active)
    {
      Object localObject = rx.internal.a.c.iVQ();
      c.b[] arrayOfb = this.abRJ.hi(localObject);
      int j = arrayOfb.length;
      int i = 0;
      while (i < j)
      {
        arrayOfb[i].hj(localObject);
        i += 1;
      }
    }
    AppMethodBeat.o(90424);
  }
  
  public final void he(T paramT)
  {
    AppMethodBeat.i(90426);
    c.b[] arrayOfb = ((c.a)this.abRJ.get()).abRR;
    int j = arrayOfb.length;
    int i = 0;
    while (i < j)
    {
      arrayOfb[i].he(paramT);
      i += 1;
    }
    AppMethodBeat.o(90426);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     rx.e.a
 * JD-Core Version:    0.7.0.1
 */