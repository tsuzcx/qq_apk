package com.tencent.mm.ui.component;

import androidx.lifecycle.af;
import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.Metadata;
import kotlin.ah;
import kotlin.d.d;
import kotlin.d.f;
import kotlin.g.a.m;
import kotlin.g.b.s;
import kotlinx.coroutines.ac;
import kotlinx.coroutines.aq;
import kotlinx.coroutines.ar;
import kotlinx.coroutines.as;
import kotlinx.coroutines.bg;
import kotlinx.coroutines.cb;
import kotlinx.coroutines.cx;
import kotlinx.coroutines.l;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/ui/component/CoroutineViewModel;", "Landroidx/lifecycle/ViewModel;", "()V", "lifecycleScope", "Lkotlinx/coroutines/CoroutineScope;", "getLifecycleScope", "()Lkotlinx/coroutines/CoroutineScope;", "mainScope", "getMainScope", "launch", "Lkotlinx/coroutines/Job;", "context", "Lkotlin/coroutines/CoroutineContext;", "start", "Lkotlinx/coroutines/CoroutineStart;", "block", "Lkotlin/Function2;", "Lkotlin/coroutines/Continuation;", "", "", "Lkotlin/ExtensionFunctionType;", "(Lkotlin/coroutines/CoroutineContext;Lkotlinx/coroutines/CoroutineStart;Lkotlin/jvm/functions/Function2;)Lkotlinx/coroutines/Job;", "onCleared", "plugin-uic_release"}, k=1, mv={1, 5, 1}, xi=48)
public class e
  extends af
{
  private final aq lifecycleScope;
  private final aq mainScope;
  
  public e()
  {
    AppMethodBeat.i(250406);
    this.lifecycleScope = ar.d(cx.g(null).plus((f)bg.kCi()));
    this.mainScope = ar.d(cx.g(null).plus((f)bg.kCh()));
    AppMethodBeat.o(250406);
  }
  
  public aq getLifecycleScope()
  {
    return this.lifecycleScope;
  }
  
  public aq getMainScope()
  {
    return this.mainScope;
  }
  
  public final cb launch(f paramf, as paramas, m<? super aq, ? super d<? super ah>, ? extends Object> paramm)
  {
    AppMethodBeat.i(250440);
    s.u(paramf, "context");
    s.u(paramas, "start");
    s.u(paramm, "block");
    paramf = l.b(getLifecycleScope(), paramf, paramas, paramm);
    AppMethodBeat.o(250440);
    return paramf;
  }
  
  public void onCleared()
  {
    AppMethodBeat.i(250432);
    super.onCleared();
    ar.a(getLifecycleScope(), this + " onCleared.");
    ar.a(getMainScope(), this + " onCleared.");
    AppMethodBeat.o(250432);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.ui.component.e
 * JD-Core Version:    0.7.0.1
 */