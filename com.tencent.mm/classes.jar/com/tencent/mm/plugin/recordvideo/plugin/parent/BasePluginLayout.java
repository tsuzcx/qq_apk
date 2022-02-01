package com.tencent.mm.plugin.recordvideo.plugin.parent;

import android.content.Context;
import android.content.Intent;
import android.util.AttributeSet;
import android.widget.RelativeLayout;
import com.tencent.mm.media.widget.camerarecordview.b.b;
import com.tencent.mm.plugin.recordvideo.activity.a;
import com.tencent.mm.plugin.recordvideo.jumper.RecordConfigProvider;
import com.tencent.mm.plugin.recordvideo.plugin.u;
import com.tencent.mm.plugin.recordvideo.plugin.u.a;
import java.util.ArrayList;
import java.util.Iterator;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.t;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/recordvideo/plugin/parent/BasePluginLayout;", "Landroid/widget/RelativeLayout;", "Lcom/tencent/mm/plugin/recordvideo/plugin/IBaseRecordPlugin;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "isAttached", "", "()Z", "setAttached", "(Z)V", "pluginList", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "getPluginList", "()Ljava/util/ArrayList;", "findPluginByClass", "T", "clazz", "Ljava/lang/Class;", "(Ljava/lang/Class;)Lcom/tencent/mm/plugin/recordvideo/plugin/IBaseRecordPlugin;", "findPluginByName", "name", "", "(Ljava/lang/String;)Lcom/tencent/mm/plugin/recordvideo/plugin/IBaseRecordPlugin;", "initLogic", "", "navigator", "Lcom/tencent/mm/plugin/recordvideo/activity/IRecordUINavigation;", "configProvider", "Lcom/tencent/mm/plugin/recordvideo/jumper/RecordConfigProvider;", "loadCurrentPage", "info", "Lcom/tencent/mm/media/widget/camerarecordview/data/MediaCaptureInfo;", "onActivityResult", "requestCode", "", "resultCode", "data", "Landroid/content/Intent;", "onAttach", "onBackPress", "onDetach", "onPause", "onRequestPermissionsResult", "permissions", "", "grantResults", "", "(I[Ljava/lang/String;[I)V", "onResume", "registerPlugin", "plugin", "release", "reset", "setVisibility", "visibility", "Companion", "plugin-recordvideo_release"})
public abstract class BasePluginLayout
  extends RelativeLayout
  implements u
{
  public static final a HQP = new a((byte)0);
  private boolean ljV;
  private final ArrayList<u> pluginList = new ArrayList();
  
  public BasePluginLayout(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  public void a(b paramb)
  {
    bbp();
    reset();
    setVisibility(0);
  }
  
  public abstract void a(a parama, RecordConfigProvider paramRecordConfigProvider);
  
  public void bbp()
  {
    this.ljV = true;
    Iterator localIterator = ((Iterable)this.pluginList).iterator();
    while (localIterator.hasNext()) {
      ((u)localIterator.next()).bbp();
    }
  }
  
  public final <T extends u> T bp(Class<T> paramClass)
  {
    p.k(paramClass, "clazz");
    Iterator localIterator = ((Iterable)this.pluginList).iterator();
    while (localIterator.hasNext())
    {
      u localu = (u)localIterator.next();
      if (p.h(localu.name(), paramClass.getName()))
      {
        paramClass = localu;
        if (localu != null) {
          return paramClass;
        }
        throw new t("null cannot be cast to non-null type T");
      }
    }
    paramClass = null;
    return paramClass;
  }
  
  protected final ArrayList<u> getPluginList()
  {
    return this.pluginList;
  }
  
  public final boolean isAttached()
  {
    return this.ljV;
  }
  
  public final String name()
  {
    return getClass().getName();
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    Iterator localIterator = ((Iterable)this.pluginList).iterator();
    while (localIterator.hasNext()) {
      ((u)localIterator.next()).onActivityResult(paramInt1, paramInt2, paramIntent);
    }
  }
  
  public boolean onBackPress()
  {
    Iterator localIterator = ((Iterable)this.pluginList).iterator();
    while (localIterator.hasNext()) {
      if (((u)localIterator.next()).onBackPress()) {
        return true;
      }
    }
    return false;
  }
  
  public void onDetach()
  {
    this.ljV = false;
    Iterator localIterator = ((Iterable)this.pluginList).iterator();
    while (localIterator.hasNext()) {
      ((u)localIterator.next()).onDetach();
    }
  }
  
  public void onPause()
  {
    Iterator localIterator = ((Iterable)this.pluginList).iterator();
    while (localIterator.hasNext()) {
      ((u)localIterator.next()).onPause();
    }
  }
  
  public void onRequestPermissionsResult(int paramInt, String[] paramArrayOfString, int[] paramArrayOfInt)
  {
    p.k(paramArrayOfString, "permissions");
    p.k(paramArrayOfInt, "grantResults");
    u.a.a(paramArrayOfString, paramArrayOfInt);
    Iterator localIterator = ((Iterable)this.pluginList).iterator();
    while (localIterator.hasNext()) {
      ((u)localIterator.next()).onRequestPermissionsResult(paramInt, paramArrayOfString, paramArrayOfInt);
    }
  }
  
  public void onResume()
  {
    Iterator localIterator = ((Iterable)this.pluginList).iterator();
    while (localIterator.hasNext()) {
      ((u)localIterator.next()).onResume();
    }
  }
  
  public void release()
  {
    Iterator localIterator = ((Iterable)this.pluginList).iterator();
    while (localIterator.hasNext()) {
      ((u)localIterator.next()).release();
    }
  }
  
  public void reset()
  {
    Iterator localIterator = ((Iterable)this.pluginList).iterator();
    while (localIterator.hasNext()) {
      ((u)localIterator.next()).reset();
    }
  }
  
  protected final void setAttached(boolean paramBoolean)
  {
    this.ljV = paramBoolean;
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
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/recordvideo/plugin/parent/BasePluginLayout$Companion;", "", "()V", "TAG", "", "plugin-recordvideo_release"})
  public static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.recordvideo.plugin.parent.BasePluginLayout
 * JD-Core Version:    0.7.0.1
 */