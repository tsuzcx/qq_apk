package rx.e;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayList;
import java.util.List;
import rx.d.a;

public final class a<T>
  extends b<T, T>
{
  private final rx.internal.a.c<T> KoR;
  final c<T> KsR;
  
  public a(d.a<T> parama, c<T> paramc)
  {
    super(parama);
    AppMethodBeat.i(90423);
    this.KoR = rx.internal.a.c.fNC();
    this.KsR = paramc;
    AppMethodBeat.o(90423);
  }
  
  public final void fNs()
  {
    AppMethodBeat.i(90424);
    if (this.KsR.active)
    {
      Object localObject = rx.internal.a.c.fND();
      c.b[] arrayOfb = this.KsR.fY(localObject);
      int j = arrayOfb.length;
      int i = 0;
      while (i < j)
      {
        arrayOfb[i].fZ(localObject);
        i += 1;
      }
    }
    AppMethodBeat.o(90424);
  }
  
  public final void fV(T paramT)
  {
    AppMethodBeat.i(90426);
    c.b[] arrayOfb = ((c.a)this.KsR.get()).KsZ;
    int j = arrayOfb.length;
    int i = 0;
    while (i < j)
    {
      arrayOfb[i].fV(paramT);
      i += 1;
    }
    AppMethodBeat.o(90426);
  }
  
  public final void onError(Throwable paramThrowable)
  {
    AppMethodBeat.i(90425);
    if (this.KsR.active)
    {
      Object localObject2 = rx.internal.a.c.K(paramThrowable);
      paramThrowable = null;
      c.b[] arrayOfb = this.KsR.fY(localObject2);
      int j = arrayOfb.length;
      int i = 0;
      for (;;)
      {
        if (i < j)
        {
          Object localObject1 = arrayOfb[i];
          try
          {
            ((c.b)localObject1).fZ(localObject2);
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
      rx.a.b.iV(paramThrowable);
    }
    AppMethodBeat.o(90425);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     rx.e.a
 * JD-Core Version:    0.7.0.1
 */