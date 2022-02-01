package kotlinx.coroutines.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.ah;
import kotlin.d.a.a;
import kotlin.d.d<-Lkotlin.ah;>;
import kotlin.g.a.b;
import kotlin.g.a.m;
import kotlin.g.b.ah.f;
import kotlinx.coroutines.b.a.u;

@Metadata(d1={""}, d2={"Lkotlinx/coroutines/flow/DistinctFlowImpl;", "T", "Lkotlinx/coroutines/flow/Flow;", "upstream", "keySelector", "Lkotlin/Function1;", "", "areEquivalent", "Lkotlin/Function2;", "Lkotlin/ParameterName;", "name", "old", "new", "", "(Lkotlinx/coroutines/flow/Flow;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function2;)V", "collect", "", "collector", "Lkotlinx/coroutines/flow/FlowCollector;", "(Lkotlinx/coroutines/flow/FlowCollector;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "kotlinx-coroutines-core"}, k=1, mv={1, 5, 1}, xi=48)
final class f<T>
  implements g<T>
{
  public final b<T, Object> ajxV;
  public final m<Object, Object, Boolean> ajxW;
  private final g<T> bSe;
  
  public f(g<? extends T> paramg, b<? super T, ? extends Object> paramb, m<Object, Object, Boolean> paramm)
  {
    this.bSe = paramg;
    this.ajxV = paramb;
    this.ajxW = paramm;
  }
  
  public final Object a(final h<? super T> paramh, kotlin.d.d<? super ah> paramd)
  {
    AppMethodBeat.i(189114);
    final ah.f localf = new ah.f();
    localf.aqH = u.ajzN;
    paramh = this.bSe.a((h)new a(this, localf, paramh), paramd);
    if (paramh == a.aiwj)
    {
      AppMethodBeat.o(189114);
      return paramh;
    }
    paramh = ah.aiuX;
    AppMethodBeat.o(189114);
    return paramh;
  }
  
  @Metadata(d1={""}, d2={"kotlinx/coroutines/flow/FlowKt__CollectKt$collect$3", "Lkotlinx/coroutines/flow/FlowCollector;", "emit", "", "value", "(Ljava/lang/Object;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "kotlinx-coroutines-core"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class a
    implements h<T>
  {
    public a(f paramf, ah.f paramf1, h paramh) {}
    
    public final Object a(T paramT, kotlin.d.d<? super ah> paramd)
    {
      AppMethodBeat.i(189083);
      Object localObject1;
      if ((paramd instanceof 1))
      {
        localObject1 = (1)paramd;
        if ((((1)localObject1).label & 0x80000000) != 0) {
          ((1)localObject1).label += -2147483648;
        }
      }
      for (paramd = (kotlin.d.d<? super ah>)localObject1;; paramd = new kotlin.d.b.a.d(paramd)
          {
            int label;
            
            public final Object invokeSuspend(Object paramAnonymousObject)
            {
              AppMethodBeat.i(189145);
              this.result = paramAnonymousObject;
              this.label |= 0x80000000;
              paramAnonymousObject = this.ajya.a(null, (kotlin.d.d)this);
              AppMethodBeat.o(189145);
              return paramAnonymousObject;
            }
          })
      {
        localObject2 = paramd.result;
        localObject1 = a.aiwj;
        switch (paramd.label)
        {
        default: 
          paramT = new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
          AppMethodBeat.o(189083);
          throw paramT;
        }
      }
      ResultKt.throwOnFailure(localObject2);
      Object localObject2 = this.ajxX.ajxV.invoke(paramT);
      if ((localf.aqH == u.ajzN) || (!((Boolean)this.ajxX.ajxW.invoke(localf.aqH, localObject2)).booleanValue()))
      {
        localf.aqH = localObject2;
        localObject2 = paramh;
        paramd.label = 1;
        if (((h)localObject2).a(paramT, paramd) == localObject1)
        {
          AppMethodBeat.o(189083);
          return localObject1;
          ResultKt.throwOnFailure(localObject2);
        }
      }
      paramT = ah.aiuX;
      AppMethodBeat.o(189083);
      return paramT;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     kotlinx.coroutines.b.f
 * JD-Core Version:    0.7.0.1
 */