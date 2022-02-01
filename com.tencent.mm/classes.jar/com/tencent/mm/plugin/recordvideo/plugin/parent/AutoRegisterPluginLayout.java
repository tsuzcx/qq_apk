package com.tencent.mm.plugin.recordvideo.plugin.parent;

import android.content.Context;
import android.util.AttributeSet;
import com.tencent.mm.plugin.recordvideo.plugin.v;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.d.f;
import kotlin.g.b.s;
import kotlinx.coroutines.aq;
import kotlinx.coroutines.ar;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/recordvideo/plugin/parent/AutoRegisterPluginLayout;", "Lcom/tencent/mm/plugin/recordvideo/plugin/parent/BasePluginLayout;", "Lcom/tencent/mm/plugin/recordvideo/plugin/parent/IRecordStatus;", "Lkotlinx/coroutines/CoroutineScope;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "coroutineContext", "Lkotlin/coroutines/CoroutineContext;", "getCoroutineContext", "()Lkotlin/coroutines/CoroutineContext;", "register", "", "plugin", "Lcom/tencent/mm/plugin/recordvideo/plugin/IBaseRecordPlugin;", "release", "plugin-recordvideo_release"}, k=1, mv={1, 5, 1}, xi=48)
public abstract class AutoRegisterPluginLayout
  extends BasePluginLayout
  implements a, aq
{
  public AutoRegisterPluginLayout(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  public final void a(v paramv)
  {
    s.u(paramv, "plugin");
    getPluginList().add(paramv);
  }
  
  public f getCoroutineContext()
  {
    return this.bRj.getCoroutineContext();
  }
  
  public void release()
  {
    super.release();
    ar.a((aq)this, null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.recordvideo.plugin.parent.AutoRegisterPluginLayout
 * JD-Core Version:    0.7.0.1
 */