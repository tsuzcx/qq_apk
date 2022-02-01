package com.tencent.mm.ui.component;

import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.d.d;
import kotlin.d.f;
import kotlin.g.a.m;
import kotlin.g.b.p;
import kotlin.l;
import kotlinx.coroutines.ak;
import kotlinx.coroutines.al;
import kotlinx.coroutines.am;
import kotlinx.coroutines.bc;
import kotlinx.coroutines.ct;
import kotlinx.coroutines.i;
import kotlinx.coroutines.w;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/ui/component/CoroutineViewModel;", "Landroidx/lifecycle/ViewModel;", "()V", "lifecycleScope", "Lkotlinx/coroutines/CoroutineScope;", "getLifecycleScope", "()Lkotlinx/coroutines/CoroutineScope;", "launch", "", "context", "Lkotlin/coroutines/CoroutineContext;", "start", "Lkotlinx/coroutines/CoroutineStart;", "block", "Lkotlin/Function2;", "Lkotlin/coroutines/Continuation;", "", "Lkotlin/ExtensionFunctionType;", "(Lkotlin/coroutines/CoroutineContext;Lkotlinx/coroutines/CoroutineStart;Lkotlin/jvm/functions/Function2;)V", "onCleared", "plugin-uic_release"})
public class b
  extends androidx.lifecycle.x
{
  private final ak Xou;
  
  public b()
  {
    AppMethodBeat.i(231516);
    this.Xou = al.c(ct.iRW().plus((f)bc.iRs()));
    AppMethodBeat.o(231516);
  }
  
  public ak getLifecycleScope()
  {
    return this.Xou;
  }
  
  public final void launch(f paramf, am paramam, m<? super ak, ? super d<? super kotlin.x>, ? extends Object> paramm)
  {
    AppMethodBeat.i(231514);
    p.k(paramf, "context");
    p.k(paramam, "start");
    p.k(paramm, "block");
    i.b(getLifecycleScope(), paramf, paramam, paramm);
    AppMethodBeat.o(231514);
  }
  
  public void onCleared()
  {
    AppMethodBeat.i(231511);
    super.onCleared();
    al.a(getLifecycleScope(), this + " onCleared.");
    AppMethodBeat.o(231511);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.ui.component.b
 * JD-Core Version:    0.7.0.1
 */