package com.tencent.mm.plugin.recordvideo.plugin.parent;

import android.content.Context;
import android.content.Intent;
import android.util.AttributeSet;
import android.widget.RelativeLayout;
import com.tencent.mm.media.widget.camerarecordview.b.b;
import com.tencent.mm.plugin.recordvideo.activity.a;
import com.tencent.mm.plugin.recordvideo.jumper.RecordConfigProvider;
import com.tencent.mm.plugin.recordvideo.plugin.t;
import com.tencent.mm.plugin.recordvideo.plugin.t.a;
import d.g.b.p;
import d.l;
import java.util.ArrayList;
import java.util.Iterator;

@l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/recordvideo/plugin/parent/BasePluginLayout;", "Landroid/widget/RelativeLayout;", "Lcom/tencent/mm/plugin/recordvideo/plugin/IBaseRecordPlugin;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "pluginList", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "getPluginList", "()Ljava/util/ArrayList;", "initLogic", "", "navigator", "Lcom/tencent/mm/plugin/recordvideo/activity/IRecordUINavigation;", "configProvider", "Lcom/tencent/mm/plugin/recordvideo/jumper/RecordConfigProvider;", "loadCurrentPage", "info", "Lcom/tencent/mm/media/widget/camerarecordview/data/MediaCaptureInfo;", "onActivityResult", "requestCode", "", "resultCode", "data", "Landroid/content/Intent;", "onAttach", "onBackPress", "", "onDetach", "onPause", "onRequestPermissionsResult", "permissions", "", "", "grantResults", "", "(I[Ljava/lang/String;[I)V", "onResume", "registerPlugin", "plugin", "release", "reset", "setVisibility", "visibility", "Companion", "plugin-recordvideo_release"})
public abstract class BasePluginLayout
  extends RelativeLayout
  implements t
{
  public static final BasePluginLayout.a xDK = new BasePluginLayout.a((byte)0);
  private final ArrayList<t> hab = new ArrayList();
  
  public BasePluginLayout(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  public void a(b paramb)
  {
    ayX();
    reset();
    setVisibility(0);
  }
  
  public abstract void a(a parama, RecordConfigProvider paramRecordConfigProvider);
  
  public boolean aoB()
  {
    Iterator localIterator = ((Iterable)this.hab).iterator();
    while (localIterator.hasNext()) {
      if (((t)localIterator.next()).aoB()) {
        return true;
      }
    }
    return false;
  }
  
  public final void ayX()
  {
    Iterator localIterator = ((Iterable)this.hab).iterator();
    while (localIterator.hasNext()) {
      ((t)localIterator.next()).ayX();
    }
  }
  
  protected final ArrayList<t> getPluginList()
  {
    return this.hab;
  }
  
  public final String name()
  {
    return null;
  }
  
  public final void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    Iterator localIterator = ((Iterable)this.hab).iterator();
    while (localIterator.hasNext()) {
      ((t)localIterator.next()).onActivityResult(paramInt1, paramInt2, paramIntent);
    }
  }
  
  public void onDetach()
  {
    Iterator localIterator = ((Iterable)this.hab).iterator();
    while (localIterator.hasNext()) {
      ((t)localIterator.next()).onDetach();
    }
  }
  
  public void onPause()
  {
    Iterator localIterator = ((Iterable)this.hab).iterator();
    while (localIterator.hasNext()) {
      ((t)localIterator.next()).onPause();
    }
  }
  
  public void onRequestPermissionsResult(int paramInt, String[] paramArrayOfString, int[] paramArrayOfInt)
  {
    p.h(paramArrayOfString, "permissions");
    p.h(paramArrayOfInt, "grantResults");
    t.a.a(paramArrayOfString, paramArrayOfInt);
    Iterator localIterator = ((Iterable)this.hab).iterator();
    while (localIterator.hasNext()) {
      ((t)localIterator.next()).onRequestPermissionsResult(paramInt, paramArrayOfString, paramArrayOfInt);
    }
  }
  
  public void onResume()
  {
    Iterator localIterator = ((Iterable)this.hab).iterator();
    while (localIterator.hasNext()) {
      ((t)localIterator.next()).onResume();
    }
  }
  
  public void release()
  {
    Iterator localIterator = ((Iterable)this.hab).iterator();
    while (localIterator.hasNext()) {
      ((t)localIterator.next()).release();
    }
  }
  
  public void reset()
  {
    Iterator localIterator = ((Iterable)this.hab).iterator();
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
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.recordvideo.plugin.parent.BasePluginLayout
 * JD-Core Version:    0.7.0.1
 */