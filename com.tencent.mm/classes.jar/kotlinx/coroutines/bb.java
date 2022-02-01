package kotlinx.coroutines;

import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.ah;
import kotlin.d.a.a;
import kotlin.d.a.b;
import kotlin.d.d<*>;
import kotlin.d.e;
import kotlin.d.f.c;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"delay", "Lkotlinx/coroutines/Delay;", "Lkotlin/coroutines/CoroutineContext;", "getDelay", "(Lkotlin/coroutines/CoroutineContext;)Lkotlinx/coroutines/Delay;", "awaitCancellation", "", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "", "timeMillis", "", "(JLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "duration", "Lkotlin/time/Duration;", "delay-VtjQ1oo", "toDelayMillis", "toDelayMillis-LRDsOJo", "(J)J", "kotlinx-coroutines-core"}, k=2, mv={1, 5, 1}, xi=48)
public final class bb
{
  public static final Object ax(kotlin.d.d<?> paramd)
  {
    AppMethodBeat.i(188828);
    Object localObject1;
    if ((paramd instanceof a))
    {
      localObject1 = (a)paramd;
      if ((((a)localObject1).label & 0x80000000) != 0) {
        ((a)localObject1).label += -2147483648;
      }
    }
    for (paramd = (kotlin.d.d<?>)localObject1;; paramd = new a(paramd))
    {
      localObject2 = paramd.result;
      localObject1 = a.aiwj;
      switch (paramd.label)
      {
      default: 
        paramd = new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        AppMethodBeat.o(188828);
        throw paramd;
      }
    }
    ResultKt.throwOnFailure(localObject2);
    paramd.label = 1;
    Object localObject2 = new q(b.au((kotlin.d.d)paramd), 1);
    ((q)localObject2).kBA();
    localObject2 = ((q)localObject2).getResult();
    if (localObject2 == a.aiwj) {
      s.u((kotlin.d.d)paramd, "frame");
    }
    if (localObject2 == localObject1)
    {
      AppMethodBeat.o(188828);
      return localObject1;
      ResultKt.throwOnFailure(localObject2);
    }
    paramd = new kotlin.f();
    AppMethodBeat.o(188828);
    throw paramd;
  }
  
  public static final Object e(long paramLong, kotlin.d.d<? super ah> paramd)
  {
    AppMethodBeat.i(118246);
    if (paramLong <= 0L)
    {
      paramd = ah.aiuX;
      AppMethodBeat.o(118246);
      return paramd;
    }
    Object localObject = new q(b.au(paramd), 1);
    ((q)localObject).kBA();
    p localp = (p)localObject;
    if (paramLong < 9223372036854775807L) {
      e(localp.getContext()).a(paramLong, localp);
    }
    localObject = ((q)localObject).getResult();
    if (localObject == a.aiwj) {
      s.u(paramd, "frame");
    }
    if (localObject == a.aiwj)
    {
      AppMethodBeat.o(118246);
      return localObject;
    }
    paramd = ah.aiuX;
    AppMethodBeat.o(118246);
    return paramd;
  }
  
  public static final ba e(kotlin.d.f paramf)
  {
    AppMethodBeat.i(118247);
    paramf = paramf.get((f.c)e.aiwc);
    if ((paramf instanceof ba)) {}
    for (paramf = (ba)paramf; paramf == null; paramf = null)
    {
      paramf = ax.kCf();
      AppMethodBeat.o(118247);
      return paramf;
    }
    AppMethodBeat.o(118247);
    return paramf;
  }
  
  @Metadata(k=3, mv={1, 5, 1}, xi=48)
  static final class a
    extends kotlin.d.b.a.d
  {
    int label;
    
    a(kotlin.d.d<? super a> paramd)
    {
      super();
    }
    
    public final Object invokeSuspend(Object paramObject)
    {
      AppMethodBeat.i(188894);
      this.result = paramObject;
      this.label |= 0x80000000;
      paramObject = bb.ax((kotlin.d.d)this);
      AppMethodBeat.o(188894);
      return paramObject;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     kotlinx.coroutines.bb
 * JD-Core Version:    0.7.0.1
 */