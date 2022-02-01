package kotlinx.coroutines;

import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.d.a.a;
import kotlin.d.f;
import kotlin.g.a.m;
import kotlin.g.b.ah.f;
import kotlin.g.b.s;
import kotlinx.coroutines.c.b;
import kotlinx.coroutines.internal.y;

@Metadata(d1={""}, d2={"TimeoutCancellationException", "Lkotlinx/coroutines/TimeoutCancellationException;", "time", "", "coroutine", "Lkotlinx/coroutines/Job;", "setupTimeout", "", "U", "T", "Lkotlinx/coroutines/TimeoutCoroutine;", "block", "Lkotlin/Function2;", "Lkotlinx/coroutines/CoroutineScope;", "Lkotlin/coroutines/Continuation;", "Lkotlin/ExtensionFunctionType;", "(Lkotlinx/coroutines/TimeoutCoroutine;Lkotlin/jvm/functions/Function2;)Ljava/lang/Object;", "withTimeout", "timeMillis", "(JLkotlin/jvm/functions/Function2;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "timeout", "Lkotlin/time/Duration;", "withTimeout-KLykuaI", "withTimeoutOrNull", "withTimeoutOrNull-KLykuaI", "kotlinx-coroutines-core"}, k=2, mv={1, 5, 1}, xi=48)
public final class dc
{
  public static final <T> Object a(long paramLong, m<? super aq, ? super kotlin.d.d<? super T>, ? extends Object> paramm, kotlin.d.d<? super T> paramd)
  {
    AppMethodBeat.i(188994);
    if (paramLong <= 0L)
    {
      paramm = new da("Timed out immediately");
      AppMethodBeat.o(188994);
      throw paramm;
    }
    paramm = a(new db(paramLong, paramd), paramm);
    if (paramm == a.aiwj) {
      s.u(paramd, "frame");
    }
    AppMethodBeat.o(188994);
    return paramm;
  }
  
  private static final <U, T extends U> Object a(db<U, ? super T> paramdb, m<? super aq, ? super kotlin.d.d<? super T>, ? extends Object> paramm)
  {
    AppMethodBeat.i(189007);
    f localf = paramdb.ajzY.getContext();
    cf.a((cb)paramdb, bb.e(localf).a(paramdb.time, (Runnable)paramdb, paramdb.getContext()));
    paramdb = b.b((y)paramdb, paramdb, paramm);
    AppMethodBeat.o(189007);
    return paramdb;
  }
  
  public static final <T> Object b(long paramLong, m<? super aq, ? super kotlin.d.d<? super T>, ? extends Object> paramm, kotlin.d.d<? super T> paramd)
  {
    AppMethodBeat.i(189000);
    a locala;
    if ((paramd instanceof a))
    {
      locala = (a)paramd;
      if ((locala.label & 0x80000000) != 0) {
        locala.label += -2147483648;
      }
    }
    a locala1;
    for (;;)
    {
      paramd = locala.result;
      locala1 = a.aiwj;
      switch (locala.label)
      {
      default: 
        paramm = new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        AppMethodBeat.o(189000);
        throw paramm;
        locala = new a(paramd);
      }
    }
    ResultKt.throwOnFailure(paramd);
    if (paramLong <= 0L)
    {
      AppMethodBeat.o(189000);
      return null;
    }
    paramd = new ah.f();
    try
    {
      locala.L$0 = paramm;
      locala.Uf = paramd;
      locala.Yx = paramLong;
      locala.label = 1;
      db localdb = new db(paramLong, (kotlin.d.d)locala);
      paramd.aqH = localdb;
      paramm = a(localdb, paramm);
      if (paramm == a.aiwj) {
        s.u((kotlin.d.d)locala, "frame");
      }
      if (paramm == locala1)
      {
        AppMethodBeat.o(189000);
        return locala1;
      }
    }
    catch (da localda)
    {
      try
      {
        ResultKt.throwOnFailure(paramd);
      }
      catch (da paramd)
      {
        label245:
        break label245;
      }
      try
      {
        AppMethodBeat.o(189000);
        return paramd;
      }
      catch (da paramd)
      {
        break label245;
      }
      localda = localda;
      paramm = paramd;
      paramd = localda;
      if (paramd.ajwP == paramm.aqH)
      {
        AppMethodBeat.o(189000);
        return null;
      }
      AppMethodBeat.o(189000);
      throw paramd;
    }
    kotlin.d.d<? super T> locald;
    for (paramm = (ah.f)locala.Uf;; paramm = locald)
    {
      locald = paramd;
      paramd = paramm;
    }
  }
  
  @Metadata(k=3, mv={1, 5, 1}, xi=48)
  static final class a<T>
    extends kotlin.d.b.a.d
  {
    Object L$0;
    Object Uf;
    long Yx;
    int label;
    
    a(kotlin.d.d<? super a> paramd)
    {
      super();
    }
    
    public final Object invokeSuspend(Object paramObject)
    {
      AppMethodBeat.i(188880);
      this.result = paramObject;
      this.label |= 0x80000000;
      paramObject = dc.b(0L, null, (kotlin.d.d)this);
      AppMethodBeat.o(188880);
      return paramObject;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     kotlinx.coroutines.dc
 * JD-Core Version:    0.7.0.1
 */