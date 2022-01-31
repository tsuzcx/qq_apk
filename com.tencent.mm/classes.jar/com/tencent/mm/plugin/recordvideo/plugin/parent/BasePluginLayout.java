package com.tencent.mm.plugin.recordvideo.plugin.parent;

import a.l;
import android.content.Context;
import android.util.AttributeSet;
import android.widget.RelativeLayout;
import com.tencent.mm.plugin.recordvideo.plugin.q;
import java.util.ArrayList;
import java.util.Iterator;

@l(eaO={1, 1, 13}, eaP={""}, eaQ={"Lcom/tencent/mm/plugin/recordvideo/plugin/parent/BasePluginLayout;", "Landroid/widget/RelativeLayout;", "Lcom/tencent/mm/plugin/recordvideo/plugin/IBaseRecordPlugin;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "isCurrentState", "", "()Z", "setCurrentState", "(Z)V", "pluginList", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "getPluginList", "()Ljava/util/ArrayList;", "onBackPress", "onPause", "", "onResume", "release", "reset", "setVisibility", "visibility", "", "Companion", "plugin-recordvideo_release"})
public abstract class BasePluginLayout
  extends RelativeLayout
  implements q
{
  public static final BasePluginLayout.a qdJ = new BasePluginLayout.a((byte)0);
  private final ArrayList<q> qdH = new ArrayList();
  private boolean qdI;
  
  public BasePluginLayout(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  public boolean cgq()
  {
    Iterator localIterator = ((Iterable)this.qdH).iterator();
    while (localIterator.hasNext()) {
      if (((q)localIterator.next()).cgq()) {
        return true;
      }
    }
    return false;
  }
  
  protected final ArrayList<q> getPluginList()
  {
    return this.qdH;
  }
  
  public final String name()
  {
    return null;
  }
  
  public void onPause()
  {
    this.qdI = false;
    Iterator localIterator = ((Iterable)this.qdH).iterator();
    while (localIterator.hasNext()) {
      ((q)localIterator.next()).onPause();
    }
  }
  
  public void onResume()
  {
    this.qdI = true;
    Iterator localIterator = ((Iterable)this.qdH).iterator();
    while (localIterator.hasNext()) {
      ((q)localIterator.next()).onResume();
    }
  }
  
  public void release()
  {
    Iterator localIterator = ((Iterable)this.qdH).iterator();
    while (localIterator.hasNext()) {
      ((q)localIterator.next()).release();
    }
  }
  
  public void reset()
  {
    Iterator localIterator = ((Iterable)this.qdH).iterator();
    while (localIterator.hasNext()) {
      ((q)localIterator.next()).reset();
    }
  }
  
  protected final void setCurrentState(boolean paramBoolean)
  {
    this.qdI = paramBoolean;
  }
  
  public void setVisibility(int paramInt)
  {
    super.setVisibility(paramInt);
    if (paramInt == 0)
    {
      onResume();
      return;
    }
    onPause();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.recordvideo.plugin.parent.BasePluginLayout
 * JD-Core Version:    0.7.0.1
 */