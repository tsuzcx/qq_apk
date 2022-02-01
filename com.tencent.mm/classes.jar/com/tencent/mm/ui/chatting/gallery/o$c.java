package com.tencent.mm.ui.chatting.gallery;

import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.model.bh;
import com.tencent.mm.model.c;
import com.tencent.mm.storage.ao;
import com.tencent.mm.storage.ar.a;
import kotlin.ResultKt;
import kotlin.d.a.a;
import kotlin.d.b.a.j;
import kotlin.d.d;
import kotlin.g.a.m;
import kotlin.g.b.aa.f;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.t;
import kotlin.x;
import kotlinx.coroutines.ak;
import kotlinx.coroutines.bc;
import kotlinx.coroutines.i;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;", "invoke", "(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;"})
final class o$c
  extends j
  implements m<ak, d<? super x>, Object>
{
  Object L$0;
  int label;
  private ak p$;
  int rdc;
  
  o$c(aa.f paramf, TextView paramTextView, d paramd)
  {
    super(2, paramd);
  }
  
  public final d<x> create(Object paramObject, d<?> paramd)
  {
    AppMethodBeat.i(279209);
    p.k(paramd, "completion");
    paramd = new c(this.xSu, this.kJl, paramd);
    paramd.p$ = ((ak)paramObject);
    AppMethodBeat.o(279209);
    return paramd;
  }
  
  public final Object invoke(Object paramObject1, Object paramObject2)
  {
    AppMethodBeat.i(279210);
    paramObject1 = ((c)create(paramObject1, (d)paramObject2)).invokeSuspend(x.aazN);
    AppMethodBeat.o(279210);
    return paramObject1;
  }
  
  public final Object invokeSuspend(Object paramObject)
  {
    AppMethodBeat.i(279208);
    a locala = a.aaAA;
    switch (this.label)
    {
    default: 
      paramObject = new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
      AppMethodBeat.o(279208);
      throw paramObject;
    case 0: 
      ResultKt.throwOnFailure(paramObject);
      paramObject = this.p$;
      p.j(bh.beI(), "MMCore.getAccStg()");
      localObject = c.aHp().get(ar.a.VmY, Integer.valueOf(0));
      if (localObject == null)
      {
        paramObject = new t("null cannot be cast to non-null type kotlin.Int");
        AppMethodBeat.o(279208);
        throw paramObject;
      }
      int i = ((Integer)localObject).intValue();
      if (i != 1) {
        break label205;
      }
      localObject = (kotlin.d.f)bc.iRs();
      m localm = (m)new a(this, null);
      this.L$0 = paramObject;
      this.rdc = i;
      this.label = 1;
      localObject = i.a((kotlin.d.f)localObject, localm, this);
      paramObject = localObject;
      if (localObject == locala)
      {
        AppMethodBeat.o(279208);
        return locala;
      }
      break;
    case 1: 
      ResultKt.throwOnFailure(paramObject);
    }
    paramObject = (String)paramObject;
    Object localObject = this.kJl;
    ((TextView)localObject).setVisibility(0);
    ((TextView)localObject).setText((CharSequence)paramObject);
    label205:
    paramObject = x.aazN;
    AppMethodBeat.o(279208);
    return paramObject;
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "kotlin.jvm.PlatformType", "Lkotlinx/coroutines/CoroutineScope;", "invoke", "(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;"})
  static final class a
    extends j
    implements m<ak, d<? super String>, Object>
  {
    int label;
    private ak p$;
    
    a(o.c paramc, d paramd)
    {
      super(paramd);
    }
    
    public final d<x> create(Object paramObject, d<?> paramd)
    {
      AppMethodBeat.i(290466);
      p.k(paramd, "completion");
      paramd = new a(this.WVh, paramd);
      paramd.p$ = ((ak)paramObject);
      AppMethodBeat.o(290466);
      return paramd;
    }
    
    public final Object invoke(Object paramObject1, Object paramObject2)
    {
      AppMethodBeat.i(290467);
      paramObject1 = ((a)create(paramObject1, (d)paramObject2)).invokeSuspend(x.aazN);
      AppMethodBeat.o(290467);
      return paramObject1;
    }
    
    public final Object invokeSuspend(Object paramObject)
    {
      AppMethodBeat.i(290465);
      a locala = a.aaAA;
      switch (this.label)
      {
      default: 
        paramObject = new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        AppMethodBeat.o(290465);
        throw paramObject;
      }
      ResultKt.throwOnFailure(paramObject);
      paramObject = com.tencent.mm.plugin.sight.base.f.aPw((String)this.WVh.xSu.aaBC);
      AppMethodBeat.o(290465);
      return paramObject;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.gallery.o.c
 * JD-Core Version:    0.7.0.1
 */