package com.tencent.mm.ui.component.support;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ui.component.p;
import java.util.Iterator;
import java.util.LinkedList;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.d.a.a;
import kotlin.d.b.a.k;
import kotlin.d.d<-Lkotlin.ah;>;
import kotlin.g.a.m;
import kotlin.g.b.s;
import kotlinx.coroutines.aq;
import kotlinx.coroutines.b.ad;
import kotlinx.coroutines.b.h;
import kotlinx.coroutines.b.t;
import kotlinx.coroutines.b.w;
import kotlinx.coroutines.b.w<TT;>;
import kotlinx.coroutines.b.x;
import kotlinx.coroutines.j;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/ui/component/support/StateTransform;", "T", "Lcom/tencent/mm/ui/component/support/IStateTransform;", "()V", "states", "Ljava/util/LinkedList;", "Lcom/tencent/mm/ui/component/UicState;", "addSource", "Lcom/tencent/mm/ui/component/support/StateTransform$StateBuilder1;", "S", "uicState", "(Lcom/tencent/mm/ui/component/UicState;)Lcom/tencent/mm/ui/component/support/StateTransform$StateBuilder1;", "asSharedFlow", "Lkotlinx/coroutines/flow/MutableSharedFlow;", "lifecycleScope", "Lkotlinx/coroutines/CoroutineScope;", "replay", "", "asStateFlow", "Lkotlinx/coroutines/flow/MutableStateFlow;", "defaultValue", "(Lkotlinx/coroutines/CoroutineScope;Ljava/lang/Object;)Lkotlinx/coroutines/flow/MutableStateFlow;", "BaseStateBuilder", "StateBuilder1", "StateBuilder2", "StateBuilder3", "StateBuilder4", "StateBuilder5", "StateBuilder6", "plugin-uic_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class c<T>
  implements b<T>
{
  final LinkedList<p> afai;
  
  public c()
  {
    AppMethodBeat.i(250342);
    this.afai = new LinkedList();
    AppMethodBeat.o(250342);
  }
  
  public final <S extends p> b<T, S> a(S paramS)
  {
    AppMethodBeat.i(250347);
    s.u(paramS, "uicState");
    this.afai.add(paramS);
    paramS = new b(this);
    AppMethodBeat.o(250347);
    return paramS;
  }
  
  public final w<T> a(aq paramaq, int paramInt)
  {
    AppMethodBeat.i(250356);
    s.u(paramaq, "lifecycleScope");
    paramaq = ad.a(paramInt, 2147483647, kotlinx.coroutines.a.g.ajxy);
    AppMethodBeat.o(250356);
    return paramaq;
  }
  
  public final x<T> a(aq paramaq, T paramT)
  {
    AppMethodBeat.i(250362);
    s.u(paramaq, "lifecycleScope");
    paramaq = kotlinx.coroutines.b.ah.ji(paramT);
    AppMethodBeat.o(250362);
    return paramaq;
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/ui/component/support/StateTransform$BaseStateBuilder;", "T", "Lcom/tencent/mm/ui/component/support/IStateTransform;", "stateTransform", "Lcom/tencent/mm/ui/component/support/StateTransform;", "(Lcom/tencent/mm/ui/component/support/StateTransform;)V", "getStateTransform", "()Lcom/tencent/mm/ui/component/support/StateTransform;", "asSharedFlow", "Lkotlinx/coroutines/flow/MutableSharedFlow;", "lifecycleScope", "Lkotlinx/coroutines/CoroutineScope;", "replay", "", "asStateFlow", "Lkotlinx/coroutines/flow/MutableStateFlow;", "defaultValue", "(Lkotlinx/coroutines/CoroutineScope;Ljava/lang/Object;)Lkotlinx/coroutines/flow/MutableStateFlow;", "bindFlow", "", "flow", "(Lkotlinx/coroutines/flow/MutableSharedFlow;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "plugin-uic_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static abstract class a<T>
    implements b<T>
  {
    final c<T> afaj;
    
    public a(c<T> paramc)
    {
      this.afaj = paramc;
    }
    
    public abstract Object a(w<T> paramw, kotlin.d.d<? super kotlin.ah> paramd);
    
    public final w<T> a(aq paramaq, int paramInt)
    {
      s.u(paramaq, "lifecycleScope");
      final w localw = this.afaj.a(paramaq, paramInt);
      j.a(paramaq, null, null, (m)new a(this, localw, null), 3);
      return localw;
    }
    
    public final x<T> a(aq paramaq, final T paramT)
    {
      s.u(paramaq, "lifecycleScope");
      paramT = this.afaj.a(paramaq, paramT);
      j.a(paramaq, null, null, (m)new b(this, paramT, null), 3);
      return paramT;
    }
    
    @Metadata(d1={""}, d2={"<anonymous>", "", "T", "Lkotlinx/coroutines/CoroutineScope;"}, k=3, mv={1, 5, 1}, xi=48)
    static final class a
      extends k
      implements m<aq, kotlin.d.d<? super kotlin.ah>, Object>
    {
      int label;
      
      a(c.a<T> parama, w<T> paramw, kotlin.d.d<? super a> paramd)
      {
        super(paramd);
      }
      
      public final kotlin.d.d<kotlin.ah> create(Object paramObject, kotlin.d.d<?> paramd)
      {
        AppMethodBeat.i(250322);
        paramObject = (kotlin.d.d)new a(this.afak, localw, paramd);
        AppMethodBeat.o(250322);
        return paramObject;
      }
      
      public final Object invokeSuspend(Object paramObject)
      {
        AppMethodBeat.i(250318);
        a locala = a.aiwj;
        switch (this.label)
        {
        default: 
          paramObject = new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
          AppMethodBeat.o(250318);
          throw paramObject;
        case 0: 
          ResultKt.throwOnFailure(paramObject);
          paramObject = this.afak;
          w localw = localw;
          kotlin.d.d locald = (kotlin.d.d)this;
          this.label = 1;
          if (paramObject.a(localw, locald) == locala)
          {
            AppMethodBeat.o(250318);
            return locala;
          }
          break;
        case 1: 
          ResultKt.throwOnFailure(paramObject);
        }
        paramObject = kotlin.ah.aiuX;
        AppMethodBeat.o(250318);
        return paramObject;
      }
    }
    
    @Metadata(d1={""}, d2={"<anonymous>", "", "T", "Lkotlinx/coroutines/CoroutineScope;"}, k=3, mv={1, 5, 1}, xi=48)
    static final class b
      extends k
      implements m<aq, kotlin.d.d<? super kotlin.ah>, Object>
    {
      int label;
      
      b(c.a<T> parama, x<T> paramx, kotlin.d.d<? super b> paramd)
      {
        super(paramd);
      }
      
      public final kotlin.d.d<kotlin.ah> create(Object paramObject, kotlin.d.d<?> paramd)
      {
        AppMethodBeat.i(250321);
        paramObject = (kotlin.d.d)new b(this.afak, paramT, paramd);
        AppMethodBeat.o(250321);
        return paramObject;
      }
      
      public final Object invokeSuspend(Object paramObject)
      {
        AppMethodBeat.i(250317);
        a locala = a.aiwj;
        switch (this.label)
        {
        default: 
          paramObject = new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
          AppMethodBeat.o(250317);
          throw paramObject;
        case 0: 
          ResultKt.throwOnFailure(paramObject);
          paramObject = this.afak;
          w localw = (w)paramT;
          kotlin.d.d locald = (kotlin.d.d)this;
          this.label = 1;
          if (paramObject.a(localw, locald) == locala)
          {
            AppMethodBeat.o(250317);
            return locala;
          }
          break;
        case 1: 
          ResultKt.throwOnFailure(paramObject);
        }
        paramObject = kotlin.ah.aiuX;
        AppMethodBeat.o(250317);
        return paramObject;
      }
    }
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/ui/component/support/StateTransform$StateBuilder1;", "T", "S1", "Lcom/tencent/mm/ui/component/UicState;", "Lcom/tencent/mm/ui/component/support/StateTransform$BaseStateBuilder;", "stateTransform", "Lcom/tencent/mm/ui/component/support/StateTransform;", "(Lcom/tencent/mm/ui/component/support/StateTransform;)V", "adapterCall", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", "state", "obverseEachCall", "s", "", "adapter", "Lcom/tencent/mm/ui/component/support/IStateTransform;", "call", "addSource", "Lcom/tencent/mm/ui/component/support/StateTransform$StateBuilder2;", "S2", "uicState", "(Lcom/tencent/mm/ui/component/UicState;)Lcom/tencent/mm/ui/component/support/StateTransform$StateBuilder2;", "bindFlow", "flow", "Lkotlinx/coroutines/flow/MutableSharedFlow;", "(Lkotlinx/coroutines/flow/MutableSharedFlow;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "obverseEach", "plugin-uic_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class b<T, S1 extends p>
    extends c.a<T>
  {
    kotlin.g.a.b<? super p, ? extends T> afan;
    
    public b(c<T> paramc)
    {
      super();
      AppMethodBeat.i(250329);
      AppMethodBeat.o(250329);
    }
    
    public final Object a(w<T> paramw, kotlin.d.d<? super kotlin.ah> paramd)
    {
      AppMethodBeat.i(250344);
      if ((paramd instanceof a))
      {
        localObject1 = (a)paramd;
        if ((((a)localObject1).label & 0x80000000) != 0) {
          ((a)localObject1).label += -2147483648;
        }
      }
      a locala;
      for (paramd = (kotlin.d.d<? super kotlin.ah>)localObject1;; paramd = new a(this, paramd))
      {
        localObject3 = paramd.result;
        locala = a.aiwj;
        switch (paramd.label)
        {
        default: 
          paramw = new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
          AppMethodBeat.o(250344);
          throw paramw;
        }
      }
      ResultKt.throwOnFailure(localObject3);
      Object localObject3 = ((Iterable)this.afaj.afai).iterator();
      Object localObject2 = paramw;
      Object localObject1 = this;
      paramw = (w<T>)localObject3;
      if (paramw.hasNext())
      {
        localObject3 = (kotlinx.coroutines.b.g)t.a(((p)paramw.next()).jxP());
        h localh = (h)new b((b)localObject1, (w)localObject2);
        paramd.L$0 = localObject1;
        paramd.Uf = localObject2;
        paramd.VC = paramw;
        paramd.label = 1;
        if (((kotlinx.coroutines.b.g)localObject3).a(localh, paramd) != locala) {
          break label268;
        }
        AppMethodBeat.o(250344);
        return locala;
        paramw = (Iterator)paramd.VC;
        localObject2 = (w)paramd.Uf;
        localObject1 = (b)paramd.L$0;
        ResultKt.throwOnFailure(localObject3);
      }
      label268:
      for (;;)
      {
        break;
        paramw = kotlin.ah.aiuX;
        AppMethodBeat.o(250344);
        return paramw;
      }
    }
    
    public final <S2 extends p> c.c<T, S1, S2> b(S2 paramS2)
    {
      AppMethodBeat.i(250336);
      s.u(paramS2, "uicState");
      this.afaj.afai.add(paramS2);
      paramS2 = new c.c(this.afaj);
      AppMethodBeat.o(250336);
      return paramS2;
    }
    
    @Metadata(k=3, mv={1, 5, 1}, xi=48)
    static final class a
      extends kotlin.d.b.a.d
    {
      Object L$0;
      Object Uf;
      Object VC;
      int label;
      
      a(c.b<T, S1> paramb, kotlin.d.d<? super a> paramd)
      {
        super();
      }
      
      public final Object invokeSuspend(Object paramObject)
      {
        AppMethodBeat.i(250348);
        this.result = paramObject;
        this.label |= 0x80000000;
        paramObject = this.afao.a(null, (kotlin.d.d)this);
        AppMethodBeat.o(250348);
        return paramObject;
      }
    }
    
    @Metadata(d1={""}, d2={"kotlinx/coroutines/flow/FlowKt__CollectKt$collect$3", "Lkotlinx/coroutines/flow/FlowCollector;", "emit", "", "value", "(Ljava/lang/Object;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "kotlinx-coroutines-core"}, k=1, mv={1, 5, 1}, xi=48)
    public static final class b
      implements h<p>
    {
      public b(c.b paramb, w paramw) {}
      
      public final Object a(p paramp, kotlin.d.d<? super kotlin.ah> paramd)
      {
        paramp = null;
        AppMethodBeat.i(250354);
        paramd = this.afao.afan;
        if (paramd == null) {}
        while (paramp == a.aiwj)
        {
          AppMethodBeat.o(250354);
          return paramp;
          Object localObject = this.afao.afaj.afai.get(0);
          s.s(localObject, "stateTransform.states[0]");
          paramd = paramd.invoke(localObject);
          if (paramd != null)
          {
            this.afap.jc(paramd);
            paramp = kotlin.ah.aiuX;
          }
        }
        paramp = kotlin.ah.aiuX;
        AppMethodBeat.o(250354);
        return paramp;
      }
    }
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/ui/component/support/StateTransform$StateBuilder2;", "T", "S1", "Lcom/tencent/mm/ui/component/UicState;", "S2", "Lcom/tencent/mm/ui/component/support/StateTransform$BaseStateBuilder;", "stateTransform", "Lcom/tencent/mm/ui/component/support/StateTransform;", "(Lcom/tencent/mm/ui/component/support/StateTransform;)V", "adapterCall", "Lkotlin/Function2;", "Lkotlin/ParameterName;", "name", "state", "state2", "obverseEachCall", "Lkotlin/Function1;", "s", "", "adapter", "Lcom/tencent/mm/ui/component/support/IStateTransform;", "call", "addSource", "Lcom/tencent/mm/ui/component/support/StateTransform$StateBuilder3;", "S", "uicState", "(Lcom/tencent/mm/ui/component/UicState;)Lcom/tencent/mm/ui/component/support/StateTransform$StateBuilder3;", "bindFlow", "flow", "Lkotlinx/coroutines/flow/MutableSharedFlow;", "(Lkotlinx/coroutines/flow/MutableSharedFlow;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "obverseEach", "plugin-uic_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class c<T, S1 extends p, S2 extends p>
    extends c.a<T>
  {
    m<? super S1, ? super S2, ? extends T> afaq;
    kotlin.g.a.b<? super p, kotlin.ah> afar;
    
    public c(c<T> paramc)
    {
      super();
      AppMethodBeat.i(250331);
      AppMethodBeat.o(250331);
    }
    
    public final Object a(w<T> paramw, kotlin.d.d<? super kotlin.ah> paramd)
    {
      AppMethodBeat.i(250352);
      if ((paramd instanceof a))
      {
        localObject1 = (a)paramd;
        if ((((a)localObject1).label & 0x80000000) != 0) {
          ((a)localObject1).label += -2147483648;
        }
      }
      a locala;
      for (paramd = (kotlin.d.d<? super kotlin.ah>)localObject1;; paramd = new a(this, paramd))
      {
        localObject3 = paramd.result;
        locala = a.aiwj;
        switch (paramd.label)
        {
        default: 
          paramw = new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
          AppMethodBeat.o(250352);
          throw paramw;
        }
      }
      ResultKt.throwOnFailure(localObject3);
      Object localObject3 = ((Iterable)this.afaj.afai).iterator();
      Object localObject2 = paramw;
      Object localObject1 = this;
      paramw = (w<T>)localObject3;
      if (paramw.hasNext())
      {
        localObject3 = (kotlinx.coroutines.b.g)t.a(((p)paramw.next()).jxP());
        h localh = (h)new b((c)localObject1, (w)localObject2);
        paramd.L$0 = localObject1;
        paramd.Uf = localObject2;
        paramd.VC = paramw;
        paramd.label = 1;
        if (((kotlinx.coroutines.b.g)localObject3).a(localh, paramd) != locala) {
          break label268;
        }
        AppMethodBeat.o(250352);
        return locala;
        paramw = (Iterator)paramd.VC;
        localObject2 = (w)paramd.Uf;
        localObject1 = (c)paramd.L$0;
        ResultKt.throwOnFailure(localObject3);
      }
      label268:
      for (;;)
      {
        break;
        paramw = kotlin.ah.aiuX;
        AppMethodBeat.o(250352);
        return paramw;
      }
    }
    
    public final c<T, S1, S2> aU(kotlin.g.a.b<? super p, kotlin.ah> paramb)
    {
      AppMethodBeat.i(250335);
      s.u(paramb, "call");
      this.afar = paramb;
      AppMethodBeat.o(250335);
      return this;
    }
    
    public final b<T> v(m<? super S1, ? super S2, ? extends T> paramm)
    {
      AppMethodBeat.i(250340);
      s.u(paramm, "call");
      this.afaq = paramm;
      paramm = (b)this;
      AppMethodBeat.o(250340);
      return paramm;
    }
    
    @Metadata(k=3, mv={1, 5, 1}, xi=48)
    static final class a
      extends kotlin.d.b.a.d
    {
      Object L$0;
      Object Uf;
      Object VC;
      int label;
      
      a(c.c<T, S1, S2> paramc, kotlin.d.d<? super a> paramd)
      {
        super();
      }
      
      public final Object invokeSuspend(Object paramObject)
      {
        AppMethodBeat.i(250316);
        this.result = paramObject;
        this.label |= 0x80000000;
        paramObject = this.afas.a(null, (kotlin.d.d)this);
        AppMethodBeat.o(250316);
        return paramObject;
      }
    }
    
    @Metadata(d1={""}, d2={"kotlinx/coroutines/flow/FlowKt__CollectKt$collect$3", "Lkotlinx/coroutines/flow/FlowCollector;", "emit", "", "value", "(Ljava/lang/Object;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "kotlinx-coroutines-core"}, k=1, mv={1, 5, 1}, xi=48)
    public static final class b
      implements h<p>
    {
      public b(c.c paramc, w paramw) {}
      
      public final Object a(p paramp, kotlin.d.d<? super kotlin.ah> paramd)
      {
        paramd = null;
        AppMethodBeat.i(250324);
        paramp = (p)paramp;
        Object localObject = this.afas.afar;
        if (localObject != null) {
          ((kotlin.g.a.b)localObject).invoke(paramp);
        }
        paramp = this.afas.afaq;
        if (paramp == null) {
          paramp = paramd;
        }
        while (paramp == a.aiwj)
        {
          AppMethodBeat.o(250324);
          return paramp;
          localObject = paramp.invoke(this.afas.afaj.afai.get(0), this.afas.afaj.afai.get(1));
          paramp = paramd;
          if (localObject != null)
          {
            this.afap.jc(localObject);
            paramp = kotlin.ah.aiuX;
          }
        }
        paramp = kotlin.ah.aiuX;
        AppMethodBeat.o(250324);
        return paramp;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.ui.component.support.c
 * JD-Core Version:    0.7.0.1
 */