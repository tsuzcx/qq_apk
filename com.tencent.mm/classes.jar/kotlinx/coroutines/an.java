package kotlinx.coroutines;

import a.c.c;
import a.c.e;
import a.c.e.c;
import a.l;
import a.p;
import a.v;
import a.y;
import kotlinx.coroutines.a.o;
import kotlinx.coroutines.c.i;
import kotlinx.coroutines.c.j;

@l(eaO={1, 1, 13}, eaP={""}, eaQ={"Lkotlinx/coroutines/DispatchedTask;", "T", "Lkotlinx/coroutines/scheduling/Task;", "Lkotlinx/coroutines/SchedulerTask;", "resumeMode", "", "(I)V", "delegate", "Lkotlin/coroutines/Continuation;", "getDelegate", "()Lkotlin/coroutines/Continuation;", "getExceptionalResult", "", "state", "", "getSuccessfulResult", "(Ljava/lang/Object;)Ljava/lang/Object;", "run", "", "takeState", "kotlinx-coroutines-core"})
public abstract class an<T>
  extends i
{
  public int CHQ;
  
  public an(int paramInt)
  {
    this.CHQ = paramInt;
  }
  
  public static Throwable eb(Object paramObject)
  {
    Object localObject = null;
    if (!(paramObject instanceof q)) {
      paramObject = null;
    }
    for (;;)
    {
      q localq = (q)paramObject;
      paramObject = localObject;
      if (localq != null) {
        paramObject = localq.cause;
      }
      return paramObject;
    }
  }
  
  public <T> T dX(Object paramObject)
  {
    return paramObject;
  }
  
  public abstract Object epm();
  
  public abstract c<T> epp();
  
  public final void run()
  {
    j localj = this.CKA;
    try
    {
      c localc1 = epp();
      if (localc1 == null) {
        throw new v("null cannot be cast to non-null type kotlinx.coroutines.DispatchedContinuation<T>");
      }
    }
    catch (Throwable localThrowable)
    {
      throw ((Throwable)new ak("Unexpected exception running ".concat(String.valueOf(this)), localThrowable));
    }
    finally
    {
      localj.eqH();
    }
    Object localObject5 = (al)localObject1;
    c localc2 = ((al)localObject5).CHO;
    e locale = localc2.eaV();
    Object localObject2;
    Object localObject6;
    if (bo.Wg(this.CHQ))
    {
      localObject2 = (bc)locale.get((e.c)bc.CIk);
      localObject6 = epm();
      localObject5 = o.b(locale, ((al)localObject5).CHM);
      if (localObject2 == null) {
        break label183;
      }
    }
    for (;;)
    {
      try
      {
        if (!((bc)localObject2).isActive())
        {
          localObject2 = (Throwable)((bc)localObject2).epQ();
          localObject6 = p.BLX;
          localc2.dg(p.de(a.q.n((Throwable)localObject2)));
          localObject2 = y.BMg;
          o.a(locale, localObject5);
          localj.eqH();
          return;
          localObject2 = null;
          break;
        }
        label183:
        localObject2 = eb(localObject6);
        if (localObject2 != null)
        {
          localObject6 = p.BLX;
          localc2.dg(p.de(a.q.n((Throwable)localObject2)));
          continue;
        }
        localObject4 = dX(localObject6);
      }
      finally
      {
        o.a(locale, localObject5);
      }
      Object localObject4;
      localObject6 = p.BLX;
      localc2.dg(p.de(localObject4));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     kotlinx.coroutines.an
 * JD-Core Version:    0.7.0.1
 */