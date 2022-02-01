package com.tencent.mm.plugin.recordvideo.plugin.parent;

import android.content.Context;
import android.content.Intent;
import android.util.AttributeSet;
import android.widget.RelativeLayout;
import com.tencent.mm.media.widget.camerarecordview.b.b;
import com.tencent.mm.plugin.recordvideo.activity.a;
import com.tencent.mm.plugin.recordvideo.jumper.RecordConfigProvider;
import com.tencent.mm.plugin.recordvideo.plugin.t;
import d.l;
import java.util.ArrayList;
import java.util.Iterator;

@l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/plugin/recordvideo/plugin/parent/BasePluginLayout;", "Landroid/widget/RelativeLayout;", "Lcom/tencent/mm/plugin/recordvideo/plugin/IBaseRecordPlugin;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "pluginList", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "getPluginList", "()Ljava/util/ArrayList;", "initLogic", "", "navigator", "Lcom/tencent/mm/plugin/recordvideo/activity/IRecordUINavigation;", "configProvider", "Lcom/tencent/mm/plugin/recordvideo/jumper/RecordConfigProvider;", "loadCurrentPage", "info", "Lcom/tencent/mm/media/widget/camerarecordview/data/MediaCaptureInfo;", "onActivityResult", "requestCode", "", "resultCode", "data", "Landroid/content/Intent;", "onAttach", "onBackPress", "", "onDetach", "onPause", "onResume", "release", "reset", "setVisibility", "visibility", "Companion", "plugin-recordvideo_release"})
public abstract class BasePluginLayout
  extends RelativeLayout
  implements t
{
  public static final a vng = new a((byte)0);
  private final ArrayList<t> vnf = new ArrayList();
  
  public BasePluginLayout(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  public void a(b paramb)
  {
    apt();
    reset();
    setVisibility(0);
  }
  
  public abstract void a(a parama, RecordConfigProvider paramRecordConfigProvider);
  
  public final void apt()
  {
    Iterator localIterator = ((Iterable)this.vnf).iterator();
    while (localIterator.hasNext()) {
      ((t)localIterator.next()).apt();
    }
  }
  
  public boolean dia()
  {
    Iterator localIterator = ((Iterable)this.vnf).iterator();
    while (localIterator.hasNext()) {
      if (((t)localIterator.next()).dia()) {
        return true;
      }
    }
    return false;
  }
  
  protected final ArrayList<t> getPluginList()
  {
    return this.vnf;
  }
  
  public final String name()
  {
    return null;
  }
  
  public final void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    Iterator localIterator = ((Iterable)this.vnf).iterator();
    while (localIterator.hasNext()) {
      ((t)localIterator.next()).onActivityResult(paramInt1, paramInt2, paramIntent);
    }
  }
  
  public void onDetach()
  {
    Iterator localIterator = ((Iterable)this.vnf).iterator();
    while (localIterator.hasNext()) {
      ((t)localIterator.next()).onDetach();
    }
  }
  
  public void onPause()
  {
    Iterator localIterator = ((Iterable)this.vnf).iterator();
    while (localIterator.hasNext()) {
      ((t)localIterator.next()).onPause();
    }
  }
  
  public void onResume()
  {
    Iterator localIterator = ((Iterable)this.vnf).iterator();
    while (localIterator.hasNext()) {
      ((t)localIterator.next()).onResume();
    }
  }
  
  public void release()
  {
    Iterator localIterator = ((Iterable)this.vnf).iterator();
    while (localIterator.hasNext()) {
      ((t)localIterator.next()).release();
    }
  }
  
  public void reset()
  {
    Iterator localIterator = ((Iterable)this.vnf).iterator();
    while (localIterator.hasNext()) {
      ((t)localIterator.next()).reset();
    }
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
  
  @l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/plugin/recordvideo/plugin/parent/BasePluginLayout$Companion;", "", "()V", "TAG", "", "plugin-recordvideo_release"})
  public static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.recordvideo.plugin.parent.BasePluginLayout
 * JD-Core Version:    0.7.0.1
 */