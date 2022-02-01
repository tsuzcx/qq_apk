package kotlinx.coroutines.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.concurrent.CancellationException;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.ah;
import kotlin.d.a.a;
import kotlin.d.b.a.k;
import kotlin.d.d<-Lkotlin.ah;>;
import kotlin.d.f;
import kotlin.g.a.m;
import kotlin.g.a.q;
import kotlin.g.b.ah.f;
import kotlinx.coroutines.aq;
import kotlinx.coroutines.as;
import kotlinx.coroutines.au;
import kotlinx.coroutines.cb;

@Metadata(d1={""}, d2={"Lkotlinx/coroutines/flow/internal/ChannelFlowTransformLatest;", "T", "R", "Lkotlinx/coroutines/flow/internal/ChannelFlowOperator;", "transform", "Lkotlin/Function3;", "Lkotlinx/coroutines/flow/FlowCollector;", "Lkotlin/ParameterName;", "name", "value", "Lkotlin/coroutines/Continuation;", "", "", "Lkotlin/ExtensionFunctionType;", "flow", "Lkotlinx/coroutines/flow/Flow;", "context", "Lkotlin/coroutines/CoroutineContext;", "capacity", "", "onBufferOverflow", "Lkotlinx/coroutines/channels/BufferOverflow;", "(Lkotlin/jvm/functions/Function3;Lkotlinx/coroutines/flow/Flow;Lkotlin/coroutines/CoroutineContext;ILkotlinx/coroutines/channels/BufferOverflow;)V", "Lkotlin/jvm/functions/Function3;", "create", "Lkotlinx/coroutines/flow/internal/ChannelFlow;", "flowCollect", "collector", "(Lkotlinx/coroutines/flow/FlowCollector;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "kotlinx-coroutines-core"}, k=1, mv={1, 5, 1}, xi=48)
public final class j<T, R>
  extends h<T, R>
{
  final q<kotlinx.coroutines.b.h<? super R>, T, kotlin.d.d<? super ah>, Object> ajzw;
  
  private j(q<? super kotlinx.coroutines.b.h<? super R>, ? super T, ? super kotlin.d.d<? super ah>, ? extends Object> paramq, kotlinx.coroutines.b.g<? extends T> paramg, f paramf, int paramInt, kotlinx.coroutines.a.g paramg1)
  {
    super(paramg, paramf, paramInt, paramg1);
    this.ajzw = paramq;
  }
  
  protected final e<R> a(f paramf, int paramInt, kotlinx.coroutines.a.g paramg)
  {
    AppMethodBeat.i(189223);
    paramf = (e)new j(this.ajzw, this.bLH, paramf, paramInt, paramg);
    AppMethodBeat.o(189223);
    return paramf;
  }
  
  protected final Object c(final kotlinx.coroutines.b.h<? super R> paramh, kotlin.d.d<? super ah> paramd)
  {
    AppMethodBeat.i(189233);
    if ((au.ASSERTIONS_ENABLED) && (!(paramh instanceof y)))
    {
      paramh = new AssertionError();
      AppMethodBeat.o(189233);
      throw paramh;
    }
    paramh = p.d((m)new a(this, paramh, null), paramd);
    if (paramh == a.aiwj)
    {
      AppMethodBeat.o(189233);
      return paramh;
    }
    paramh = ah.aiuX;
    AppMethodBeat.o(189233);
    return paramh;
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "", "T", "R", "Lkotlinx/coroutines/CoroutineScope;"}, k=3, mv={1, 5, 1}, xi=48)
  static final class a
    extends k
    implements m<aq, kotlin.d.d<? super ah>, Object>
  {
    int label;
    
    a(j<T, R> paramj, kotlinx.coroutines.b.h<? super R> paramh, kotlin.d.d<? super a> paramd)
    {
      super(paramd);
    }
    
    public final kotlin.d.d<ah> create(Object paramObject, kotlin.d.d<?> paramd)
    {
      AppMethodBeat.i(189194);
      paramd = new a(this.ajzx, paramh, paramd);
      paramd.L$0 = paramObject;
      paramObject = (kotlin.d.d)paramd;
      AppMethodBeat.o(189194);
      return paramObject;
    }
    
    public final Object invokeSuspend(Object paramObject)
    {
      AppMethodBeat.i(189183);
      a locala = a.aiwj;
      switch (this.label)
      {
      default: 
        paramObject = new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        AppMethodBeat.o(189183);
        throw paramObject;
      case 0: 
        ResultKt.throwOnFailure(paramObject);
        Object localObject1 = (aq)this.L$0;
        Object localObject2 = new ah.f();
        paramObject = this.ajzx.bLH;
        localObject1 = (kotlinx.coroutines.b.h)new b((ah.f)localObject2, (aq)localObject1, this.ajzx, paramh);
        localObject2 = (kotlin.d.d)this;
        this.label = 1;
        if (paramObject.a((kotlinx.coroutines.b.h)localObject1, (kotlin.d.d)localObject2) == locala)
        {
          AppMethodBeat.o(189183);
          return locala;
        }
        break;
      case 1: 
        ResultKt.throwOnFailure(paramObject);
      }
      paramObject = ah.aiuX;
      AppMethodBeat.o(189183);
      return paramObject;
    }
    
    @Metadata(d1={""}, d2={"<anonymous>", "", "T", "R", "Lkotlinx/coroutines/CoroutineScope;"}, k=3, mv={1, 5, 1}, xi=48)
    static final class a
      extends k
      implements m<aq, kotlin.d.d<? super ah>, Object>
    {
      int label;
      
      a(j<T, R> paramj, kotlinx.coroutines.b.h<? super R> paramh, T paramT, kotlin.d.d<? super a> paramd)
      {
        super(paramd);
      }
      
      public final kotlin.d.d<ah> create(Object paramObject, kotlin.d.d<?> paramd)
      {
        AppMethodBeat.i(189172);
        paramObject = (kotlin.d.d)new a(this.ajzx, this.ajzk, this.amI, paramd);
        AppMethodBeat.o(189172);
        return paramObject;
      }
      
      public final Object invokeSuspend(Object paramObject)
      {
        AppMethodBeat.i(189159);
        a locala = a.aiwj;
        switch (this.label)
        {
        default: 
          paramObject = new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
          AppMethodBeat.o(189159);
          throw paramObject;
        case 0: 
          ResultKt.throwOnFailure(paramObject);
          paramObject = this.ajzx.ajzw;
          kotlinx.coroutines.b.h localh = this.ajzk;
          Object localObject = this.amI;
          this.label = 1;
          if (paramObject.invoke(localh, localObject, this) == locala)
          {
            AppMethodBeat.o(189159);
            return locala;
          }
          break;
        case 1: 
          ResultKt.throwOnFailure(paramObject);
        }
        paramObject = ah.aiuX;
        AppMethodBeat.o(189159);
        return paramObject;
      }
    }
    
    @Metadata(d1={""}, d2={"kotlinx/coroutines/flow/FlowKt__CollectKt$collect$3", "Lkotlinx/coroutines/flow/FlowCollector;", "emit", "", "value", "(Ljava/lang/Object;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "kotlinx-coroutines-core"}, k=1, mv={1, 5, 1}, xi=48)
    public static final class b
      implements kotlinx.coroutines.b.h<T>
    {
      public b(ah.f paramf, aq paramaq, j paramj, kotlinx.coroutines.b.h paramh) {}
      
      public final Object a(T paramT, kotlin.d.d<? super ah> paramd)
      {
        AppMethodBeat.i(189166);
        if ((paramd instanceof 1))
        {
          localObject1 = (1)paramd;
          if ((((1)localObject1).label & 0x80000000) != 0) {
            ((1)localObject1).label += -2147483648;
          }
        }
        a locala;
        for (paramd = (kotlin.d.d<? super ah>)localObject1;; paramd = new kotlin.d.b.a.d(paramd)
            {
              Object L$0;
              Object Uf;
              Object VC;
              int label;
              
              public final Object invokeSuspend(Object paramAnonymousObject)
              {
                AppMethodBeat.i(189164);
                this.result = paramAnonymousObject;
                this.label |= 0x80000000;
                paramAnonymousObject = this.ajzA.a(null, (kotlin.d.d)this);
                AppMethodBeat.o(189164);
                return paramAnonymousObject;
              }
            })
        {
          localObject2 = paramd.result;
          locala = a.aiwj;
          switch (paramd.label)
          {
          default: 
            paramT = new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            AppMethodBeat.o(189166);
            throw paramT;
          }
        }
        ResultKt.throwOnFailure(localObject2);
        Object localObject2 = (cb)this.ajzy.aqH;
        b localb = this;
        Object localObject1 = paramT;
        if (localObject2 != null)
        {
          ((cb)localObject2).a((CancellationException)new l());
          paramd.L$0 = this;
          paramd.Uf = paramT;
          paramd.VC = localObject2;
          paramd.label = 1;
          localb = this;
          localObject1 = paramT;
          if (((cb)localObject2).ay(paramd) == locala)
          {
            AppMethodBeat.o(189166);
            return locala;
            localObject1 = paramd.Uf;
            localb = (b)paramd.L$0;
            ResultKt.throwOnFailure(localObject2);
          }
        }
        localb.ajzy.aqH = kotlinx.coroutines.j.a(localb.ajzz, null, as.ajvN, (m)new j.a.a(localb.ajzx, localb.ajxZ, localObject1, null), 1);
        paramT = ah.aiuX;
        AppMethodBeat.o(189166);
        return paramT;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     kotlinx.coroutines.b.a.j
 * JD-Core Version:    0.7.0.1
 */