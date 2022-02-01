package rx.e;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayList;
import java.util.List;
import rx.d.a;

public final class a<T>
  extends b<T, T>
{
  private final rx.internal.a.c<T> McA;
  final c<T> MgA;
  
  public a(d.a<T> parama, c<T> paramc)
  {
    super(parama);
    AppMethodBeat.i(90423);
    this.McA = rx.internal.a.c.ggs();
    this.MgA = paramc;
    AppMethodBeat.o(90423);
  }
  
  public final void gd(T paramT)
  {
    AppMethodBeat.i(90426);
    c.b[] arrayOfb = ((c.a)this.MgA.get()).MgI;
    int j = arrayOfb.length;
    int i = 0;
    while (i < j)
    {
      arrayOfb[i].gd(paramT);
      i += 1;
    }
    AppMethodBeat.o(90426);
  }
  
  public final void ggi()
  {
    AppMethodBeat.i(90424);
    if (this.MgA.active)
    {
      Object localObject = rx.internal.a.c.ggt();
      c.b[] arrayOfb = this.MgA.gg(localObject);
      int j = arrayOfb.length;
      int i = 0;
      while (i < j)
      {
        arrayOfb[i].gh(localObject);
        i += 1;
      }
    }
    AppMethodBeat.o(90424);
  }
  
  public final void onError(Throwable paramThrowable)
  {
    AppMethodBeat.i(90425);
    if (this.MgA.active)
    {
      Object localObject2 = rx.internal.a.c.L(paramThrowable);
      paramThrowable = null;
      c.b[] arrayOfb = this.MgA.gg(localObject2);
      int j = arrayOfb.length;
      int i = 0;
      for (;;)
      {
        if (i < j)
        {
          Object localObject1 = arrayOfb[i];
          try
          {
            ((c.b)localObject1).gh(localObject2);
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
      rx.a.b.jl(paramThrowable);
    }
    AppMethodBeat.o(90425);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     rx.e.a
 * JD-Core Version:    0.7.0.1
 */