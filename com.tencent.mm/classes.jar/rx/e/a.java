package rx.e;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayList;
import java.util.List;
import rx.d.a;

public final class a<T>
  extends b<T, T>
{
  private final rx.internal.a.c<T> OuH;
  final c<T> OyH;
  
  public a(d.a<T> parama, c<T> paramc)
  {
    super(parama);
    AppMethodBeat.i(90423);
    this.OuH = rx.internal.a.c.gDy();
    this.OyH = paramc;
    AppMethodBeat.o(90423);
  }
  
  public final void gC(T paramT)
  {
    AppMethodBeat.i(90426);
    c.b[] arrayOfb = ((c.a)this.OyH.get()).OyP;
    int j = arrayOfb.length;
    int i = 0;
    while (i < j)
    {
      arrayOfb[i].gC(paramT);
      i += 1;
    }
    AppMethodBeat.o(90426);
  }
  
  public final void gDo()
  {
    AppMethodBeat.i(90424);
    if (this.OyH.active)
    {
      Object localObject = rx.internal.a.c.gDz();
      c.b[] arrayOfb = this.OyH.gF(localObject);
      int j = arrayOfb.length;
      int i = 0;
      while (i < j)
      {
        arrayOfb[i].gG(localObject);
        i += 1;
      }
    }
    AppMethodBeat.o(90424);
  }
  
  public final void onError(Throwable paramThrowable)
  {
    AppMethodBeat.i(90425);
    if (this.OyH.active)
    {
      Object localObject2 = rx.internal.a.c.N(paramThrowable);
      paramThrowable = null;
      c.b[] arrayOfb = this.OyH.gF(localObject2);
      int j = arrayOfb.length;
      int i = 0;
      for (;;)
      {
        if (i < j)
        {
          Object localObject1 = arrayOfb[i];
          try
          {
            ((c.b)localObject1).gG(localObject2);
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
      rx.a.b.jI(paramThrowable);
    }
    AppMethodBeat.o(90425);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     rx.e.a
 * JD-Core Version:    0.7.0.1
 */