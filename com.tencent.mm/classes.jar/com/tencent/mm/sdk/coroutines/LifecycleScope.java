package com.tencent.mm.sdk.coroutines;

import androidx.lifecycle.h;
import androidx.lifecycle.h.a;
import androidx.lifecycle.h.b;
import androidx.lifecycle.k;
import androidx.lifecycle.t;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.thread.ThreadKt;
import java.util.concurrent.CancellationException;
import kotlin.d.d;
import kotlin.g;
import kotlin.g.a.a;
import kotlin.g.a.m;
import kotlin.g.b.p;
import kotlin.g.b.q;
import kotlin.x;
import kotlinx.coroutines.ak;
import kotlinx.coroutines.am;
import kotlinx.coroutines.bc;
import kotlinx.coroutines.bn;
import kotlinx.coroutines.by;
import kotlinx.coroutines.cc;
import kotlinx.coroutines.ci;
import kotlinx.coroutines.i;
import kotlinx.coroutines.w;

@kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/sdk/coroutines/LifecycleScope;", "Lkotlinx/coroutines/CoroutineScope;", "Landroidx/lifecycle/LifecycleObserver;", "name", "", "owner", "Landroidx/lifecycle/LifecycleOwner;", "(Ljava/lang/String;Landroidx/lifecycle/LifecycleOwner;)V", "Default", "Lkotlinx/coroutines/ExecutorCoroutineDispatcher;", "getDefault", "()Lkotlinx/coroutines/ExecutorCoroutineDispatcher;", "Default$delegate", "Lkotlin/Lazy;", "coroutineContext", "Lkotlin/coroutines/CoroutineContext;", "getCoroutineContext", "()Lkotlin/coroutines/CoroutineContext;", "getName", "()Ljava/lang/String;", "parentJob", "Lkotlinx/coroutines/CompletableJob;", "launch", "Lkotlinx/coroutines/Job;", "start", "Lkotlinx/coroutines/CoroutineStart;", "block", "Lkotlin/Function2;", "Lkotlin/coroutines/Continuation;", "", "", "Lkotlin/ExtensionFunctionType;", "(Lkotlinx/coroutines/CoroutineStart;Lkotlin/jvm/functions/Function2;)Lkotlinx/coroutines/Job;", "onDestroy", "Companion", "wechat-sdk_release"})
public final class LifecycleScope
  implements k, ak
{
  public static final LifecycleScope.Companion Companion;
  public static final String TAG = "MicroMsg.mvvm.LifecycleScope";
  private final kotlin.f Default$delegate;
  private final String name;
  private final w parentJob;
  
  static
  {
    AppMethodBeat.i(190579);
    Companion = new LifecycleScope.Companion(null);
    AppMethodBeat.o(190579);
  }
  
  public LifecycleScope(String paramString, final androidx.lifecycle.l paraml)
  {
    AppMethodBeat.i(190578);
    this.name = paramString;
    ThreadKt.uiThread((a)new q(paraml)
    {
      public final void invoke()
      {
        AppMethodBeat.i(192748);
        h localh = paraml.getLifecycle();
        p.j(localh, "owner.lifecycle");
        if (localh.jc() != h.b.ZO)
        {
          paraml.getLifecycle().a((k)this.this$0);
          AppMethodBeat.o(192748);
          return;
        }
        Log.i("MicroMsg.mvvm.LifecycleScope", "leak this scope, because lifecycle is already destroy");
        AppMethodBeat.o(192748);
      }
    });
    this.parentJob = cc.b(null);
    this.Default$delegate = g.ar((a)new LifecycleScope.Default.2(this));
    AppMethodBeat.o(190578);
  }
  
  private final bn getDefault()
  {
    AppMethodBeat.i(190562);
    bn localbn = (bn)this.Default$delegate.getValue();
    AppMethodBeat.o(190562);
    return localbn;
  }
  
  public final kotlin.d.f getCoroutineContext()
  {
    AppMethodBeat.i(190551);
    kotlin.d.f localf = bc.iRr().plus((kotlin.d.f)this.parentJob);
    AppMethodBeat.o(190551);
    return localf;
  }
  
  public final String getName()
  {
    return this.name;
  }
  
  public final by launch(am paramam, m<? super ak, ? super d<? super x>, ? extends Object> paramm)
  {
    AppMethodBeat.i(190566);
    p.k(paramam, "start");
    p.k(paramm, "block");
    paramam = i.b(this, (kotlin.d.f)getDefault(), paramam, paramm);
    AppMethodBeat.o(190566);
    return paramam;
  }
  
  @t(jl=h.a.ON_DESTROY)
  public final void onDestroy()
  {
    AppMethodBeat.i(190558);
    Log.i("MicroMsg.mvvm.LifecycleScope", "onDestroy");
    this.parentJob.a(new CancellationException("onDestroy"));
    getDefault().close();
    AppMethodBeat.o(190558);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.sdk.coroutines.LifecycleScope
 * JD-Core Version:    0.7.0.1
 */