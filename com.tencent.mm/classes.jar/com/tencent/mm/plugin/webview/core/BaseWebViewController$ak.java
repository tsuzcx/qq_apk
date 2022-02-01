package com.tencent.mm.plugin.webview.core;

import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.ResultKt;
import kotlin.d.a.a;
import kotlin.d.b.a.f;
import kotlin.d.b.a.j;
import kotlin.d.d;
import kotlin.g.a.m;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.x;
import kotlinx.coroutines.ai;

@f(c="com.tencent.mm.plugin.webview.core.BaseWebViewController$start$1", f="BaseWebViewController.kt", hxM={}, m="invokeSuspend")
@l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;", "invoke", "(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;"})
final class BaseWebViewController$ak
  extends j
  implements m<ai, d<? super x>, Object>
{
  int label;
  private ai p$;
  
  BaseWebViewController$ak(BaseWebViewController paramBaseWebViewController, d paramd)
  {
    super(2, paramd);
  }
  
  public final d<x> create(Object paramObject, d<?> paramd)
  {
    AppMethodBeat.i(225021);
    p.h(paramd, "completion");
    paramd = new ak(this.IKR, paramd);
    paramd.p$ = ((ai)paramObject);
    AppMethodBeat.o(225021);
    return paramd;
  }
  
  public final Object invoke(Object paramObject1, Object paramObject2)
  {
    AppMethodBeat.i(225022);
    paramObject1 = ((ak)create(paramObject1, (d)paramObject2)).invokeSuspend(x.SXb);
    AppMethodBeat.o(225022);
    return paramObject1;
  }
  
  public final Object invokeSuspend(Object paramObject)
  {
    AppMethodBeat.i(225020);
    a locala = a.SXO;
    switch (this.label)
    {
    default: 
      paramObject = new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
      AppMethodBeat.o(225020);
      throw paramObject;
    }
    ResultKt.throwOnFailure(paramObject);
    this.IKR.afH(this.IKR.IKk);
    paramObject = x.SXb;
    AppMethodBeat.o(225020);
    return paramObject;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.core.BaseWebViewController.ak
 * JD-Core Version:    0.7.0.1
 */