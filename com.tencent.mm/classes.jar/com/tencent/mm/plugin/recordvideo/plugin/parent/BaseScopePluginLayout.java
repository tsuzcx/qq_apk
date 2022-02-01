package com.tencent.mm.plugin.recordvideo.plugin.parent;

import android.content.Context;
import android.util.AttributeSet;
import com.tencent.mm.plugin.recordvideo.plugin.v;
import kotlin.Metadata;
import kotlin.d.f;
import kotlinx.coroutines.ac;
import kotlinx.coroutines.aq;
import kotlinx.coroutines.ar;
import kotlinx.coroutines.bg;
import kotlinx.coroutines.cx;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/recordvideo/plugin/parent/BaseScopePluginLayout;", "Lcom/tencent/mm/plugin/recordvideo/plugin/parent/BasePluginLayout;", "Lcom/tencent/mm/plugin/recordvideo/plugin/parent/IRecordStatus;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "scope", "Lkotlinx/coroutines/CoroutineScope;", "getScope", "()Lkotlinx/coroutines/CoroutineScope;", "async", "Lkotlinx/coroutines/Deferred;", "T", "Lkotlin/coroutines/CoroutineContext;", "start", "Lkotlinx/coroutines/CoroutineStart;", "block", "Lkotlin/Function2;", "Lkotlin/coroutines/Continuation;", "", "Lkotlin/ExtensionFunctionType;", "(Lkotlin/coroutines/CoroutineContext;Lkotlinx/coroutines/CoroutineStart;Lkotlin/jvm/functions/Function2;)Lkotlinx/coroutines/Deferred;", "launch", "Lkotlinx/coroutines/Job;", "", "(Lkotlin/coroutines/CoroutineContext;Lkotlinx/coroutines/CoroutineStart;Lkotlin/jvm/functions/Function2;)Lkotlinx/coroutines/Job;", "release", "plugin-recordvideo_release"}, k=1, mv={1, 5, 1}, xi=48)
public abstract class BaseScopePluginLayout
  extends BasePluginLayout
  implements a
{
  private final aq scope = ar.d(cx.g(null).plus((f)bg.kCi()));
  
  public BaseScopePluginLayout(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  public final void a(v paramv)
  {
    a.b.a(this, paramv);
  }
  
  protected final aq getScope()
  {
    return this.scope;
  }
  
  public void release()
  {
    super.release();
    ar.a(this.scope, this + " release.");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.recordvideo.plugin.parent.BaseScopePluginLayout
 * JD-Core Version:    0.7.0.1
 */