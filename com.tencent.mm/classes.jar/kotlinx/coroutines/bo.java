package kotlinx.coroutines;

import a.c.c;
import a.f.b.j;
import a.l;
import a.p;
import a.p.a;
import a.q;
import a.y;
import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlinx.coroutines.a.o;

@l(eaO={1, 1, 13}, eaP={""}, eaQ={"MODE_ATOMIC_DEFAULT", "", "MODE_ATOMIC_DEFAULT$annotations", "()V", "MODE_CANCELLABLE", "MODE_CANCELLABLE$annotations", "MODE_DIRECT", "MODE_DIRECT$annotations", "MODE_IGNORE", "MODE_IGNORE$annotations", "MODE_UNDISPATCHED", "MODE_UNDISPATCHED$annotations", "isCancellableMode", "", "(I)Z", "isDispatchedMode", "resumeMode", "", "T", "Lkotlin/coroutines/Continuation;", "value", "mode", "(Lkotlin/coroutines/Continuation;Ljava/lang/Object;I)V", "resumeUninterceptedMode", "resumeUninterceptedWithExceptionMode", "exception", "", "resumeWithExceptionMode", "kotlinx-coroutines-core"})
public final class bo
{
  public static final boolean Wg(int paramInt)
  {
    return paramInt == 1;
  }
  
  public static final <T> void a(c<? super T> paramc, T paramT, int paramInt)
  {
    AppMethodBeat.i(118527);
    j.q(paramc, "receiver$0");
    Object localObject1;
    switch (paramInt)
    {
    default: 
      paramc = (Throwable)new IllegalStateException("Invalid mode ".concat(String.valueOf(paramInt)).toString());
      AppMethodBeat.o(118527);
      throw paramc;
    case 0: 
      localObject1 = p.BLX;
      paramc.dg(p.de(paramT));
      AppMethodBeat.o(118527);
      return;
    case 1: 
      am.a(paramc, paramT);
      AppMethodBeat.o(118527);
      return;
    case 2: 
      am.b(paramc, paramT);
      AppMethodBeat.o(118527);
      return;
    case 3: 
      Object localObject2 = (al)paramc;
      paramc = ((al)localObject2).eaV();
      localObject1 = o.b(paramc, ((al)localObject2).CHM);
      try
      {
        localObject2 = ((al)localObject2).CHO;
        p.a locala = p.BLX;
        ((c)localObject2).dg(p.de(paramT));
        paramT = y.BMg;
        return;
      }
      finally
      {
        o.a(paramc, localObject1);
        AppMethodBeat.o(118527);
      }
    }
    AppMethodBeat.o(118527);
  }
  
  public static final <T> void a(c<? super T> paramc, Throwable paramThrowable, int paramInt)
  {
    AppMethodBeat.i(118528);
    j.q(paramc, "receiver$0");
    j.q(paramThrowable, "exception");
    Object localObject1;
    switch (paramInt)
    {
    default: 
      paramc = (Throwable)new IllegalStateException("Invalid mode ".concat(String.valueOf(paramInt)).toString());
      AppMethodBeat.o(118528);
      throw paramc;
    case 0: 
      localObject1 = p.BLX;
      paramc.dg(p.de(q.n(paramThrowable)));
      AppMethodBeat.o(118528);
      return;
    case 1: 
      am.a(paramc, paramThrowable);
      AppMethodBeat.o(118528);
      return;
    case 2: 
      am.b(paramc, paramThrowable);
      AppMethodBeat.o(118528);
      return;
    case 3: 
      Object localObject2 = (al)paramc;
      paramc = ((al)localObject2).eaV();
      localObject1 = o.b(paramc, ((al)localObject2).CHM);
      try
      {
        localObject2 = ((al)localObject2).CHO;
        p.a locala = p.BLX;
        ((c)localObject2).dg(p.de(q.n(paramThrowable)));
        paramThrowable = y.BMg;
        return;
      }
      finally
      {
        o.a(paramc, localObject1);
        AppMethodBeat.o(118528);
      }
    }
    AppMethodBeat.o(118528);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     kotlinx.coroutines.bo
 * JD-Core Version:    0.7.0.1
 */