package com.tencent.mm.plugin.recordvideo.plugin.parent;

import android.content.Context;
import android.util.AttributeSet;
import com.tencent.mm.plugin.recordvideo.plugin.u;
import java.util.ArrayList;
import kotlin.g.b.p;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/recordvideo/plugin/parent/AutoRegisterPluginLayout;", "Lcom/tencent/mm/plugin/recordvideo/plugin/parent/BasePluginLayout;", "Lcom/tencent/mm/plugin/recordvideo/plugin/parent/IRecordStatus;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "register", "", "plugin", "Lcom/tencent/mm/plugin/recordvideo/plugin/IBaseRecordPlugin;", "plugin-recordvideo_release"})
public abstract class AutoRegisterPluginLayout
  extends BasePluginLayout
  implements d
{
  public AutoRegisterPluginLayout(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  public final void a(u paramu)
  {
    p.k(paramu, "plugin");
    getPluginList().add(paramu);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.recordvideo.plugin.parent.AutoRegisterPluginLayout
 * JD-Core Version:    0.7.0.1
 */