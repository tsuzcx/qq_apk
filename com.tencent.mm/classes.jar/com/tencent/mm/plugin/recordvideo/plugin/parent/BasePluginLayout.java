package com.tencent.mm.plugin.recordvideo.plugin.parent;

import android.content.Context;
import android.content.Intent;
import android.util.AttributeSet;
import android.widget.RelativeLayout;
import com.tencent.mm.media.widget.camerarecordview.b.b;
import com.tencent.mm.plugin.recordvideo.activity.a;
import com.tencent.mm.plugin.recordvideo.jumper.RecordConfigProvider;
import com.tencent.mm.plugin.recordvideo.plugin.v;
import com.tencent.mm.plugin.recordvideo.plugin.v.a;
import java.util.ArrayList;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/recordvideo/plugin/parent/BasePluginLayout;", "Landroid/widget/RelativeLayout;", "Lcom/tencent/mm/plugin/recordvideo/plugin/IBaseRecordPlugin;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "browserTimeMs", "", "getBrowserTimeMs", "()J", "setBrowserTimeMs", "(J)V", "isAttached", "", "()Z", "setAttached", "(Z)V", "pluginList", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "getPluginList", "()Ljava/util/ArrayList;", "startTimeMs", "getStartTimeMs", "setStartTimeMs", "findPluginByClass", "T", "clazz", "Ljava/lang/Class;", "(Ljava/lang/Class;)Lcom/tencent/mm/plugin/recordvideo/plugin/IBaseRecordPlugin;", "findPluginByName", "name", "", "(Ljava/lang/String;)Lcom/tencent/mm/plugin/recordvideo/plugin/IBaseRecordPlugin;", "initLogic", "", "navigator", "Lcom/tencent/mm/plugin/recordvideo/activity/IRecordUINavigation;", "configProvider", "Lcom/tencent/mm/plugin/recordvideo/jumper/RecordConfigProvider;", "loadCurrentPage", "info", "Lcom/tencent/mm/media/widget/camerarecordview/data/MediaCaptureInfo;", "onActivityResult", "requestCode", "", "resultCode", "data", "Landroid/content/Intent;", "onAttach", "onBackPress", "onDetach", "onPause", "onRequestPermissionsResult", "permissions", "", "grantResults", "", "(I[Ljava/lang/String;[I)V", "onResume", "registerPlugin", "plugin", "release", "reset", "setVisibility", "visibility", "Companion", "plugin-recordvideo_release"}, k=1, mv={1, 5, 1}, xi=48)
public abstract class BasePluginLayout
  extends RelativeLayout
  implements v
{
  public static final BasePluginLayout.a NNq = new BasePluginLayout.a((byte)0);
  private final ArrayList<v> NNr = new ArrayList();
  private long NNs;
  private boolean nOG;
  private long startTimeMs;
  
  public BasePluginLayout(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  public void a(b paramb)
  {
    bwk();
    reset();
    setVisibility(0);
  }
  
  public void a(a parama, RecordConfigProvider paramRecordConfigProvider)
  {
    s.u(parama, "navigator");
    s.u(paramRecordConfigProvider, "configProvider");
    parama = ((Iterable)this.NNr).iterator();
    while (parama.hasNext()) {
      ((v)parama.next()).a(paramRecordConfigProvider);
    }
  }
  
  public final void a(RecordConfigProvider paramRecordConfigProvider)
  {
    v.a.a(this, paramRecordConfigProvider);
  }
  
  public final <T extends v> T bZ(Class<T> paramClass)
  {
    s.u(paramClass, "clazz");
    Iterator localIterator = ((Iterable)this.NNr).iterator();
    while (localIterator.hasNext())
    {
      v localv = (v)localIterator.next();
      if (s.p(localv.name(), paramClass.getName())) {
        return localv;
      }
    }
    return null;
  }
  
  public void bwk()
  {
    s.u((v)this, "this");
    this.nOG = true;
    Iterator localIterator = ((Iterable)this.NNr).iterator();
    while (localIterator.hasNext()) {
      ((v)localIterator.next()).bwk();
    }
  }
  
  public final long getBrowserTimeMs()
  {
    return this.NNs;
  }
  
  protected final ArrayList<v> getPluginList()
  {
    return this.NNr;
  }
  
  protected final long getStartTimeMs()
  {
    return this.startTimeMs;
  }
  
  public final boolean isAttached()
  {
    return this.nOG;
  }
  
  public final String name()
  {
    return v.a.b(this);
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    s.u((v)this, "this");
    Iterator localIterator = ((Iterable)this.NNr).iterator();
    while (localIterator.hasNext()) {
      ((v)localIterator.next()).onActivityResult(paramInt1, paramInt2, paramIntent);
    }
  }
  
  public boolean onBackPress()
  {
    Iterator localIterator = ((Iterable)this.NNr).iterator();
    while (localIterator.hasNext()) {
      if (((v)localIterator.next()).onBackPress()) {
        return true;
      }
    }
    return false;
  }
  
  public void onDetach()
  {
    this.NNs = (System.currentTimeMillis() - this.startTimeMs);
    s.u((v)this, "this");
    this.nOG = false;
    Iterator localIterator = ((Iterable)this.NNr).iterator();
    while (localIterator.hasNext()) {
      ((v)localIterator.next()).onDetach();
    }
  }
  
  public void onPause()
  {
    Iterator localIterator = ((Iterable)this.NNr).iterator();
    while (localIterator.hasNext()) {
      ((v)localIterator.next()).onPause();
    }
  }
  
  public void onRequestPermissionsResult(int paramInt, String[] paramArrayOfString, int[] paramArrayOfInt)
  {
    s.u(paramArrayOfString, "permissions");
    s.u(paramArrayOfInt, "grantResults");
    v.a.a((v)this, paramArrayOfString, paramArrayOfInt);
    Iterator localIterator = ((Iterable)this.NNr).iterator();
    while (localIterator.hasNext()) {
      ((v)localIterator.next()).onRequestPermissionsResult(paramInt, paramArrayOfString, paramArrayOfInt);
    }
  }
  
  public void onResume()
  {
    this.startTimeMs = System.currentTimeMillis();
    Iterator localIterator = ((Iterable)this.NNr).iterator();
    while (localIterator.hasNext()) {
      ((v)localIterator.next()).onResume();
    }
  }
  
  public void release()
  {
    Iterator localIterator = ((Iterable)this.NNr).iterator();
    while (localIterator.hasNext()) {
      ((v)localIterator.next()).release();
    }
  }
  
  public void reset()
  {
    s.u((v)this, "this");
    Iterator localIterator = ((Iterable)this.NNr).iterator();
    while (localIterator.hasNext()) {
      ((v)localIterator.next()).reset();
    }
  }
  
  protected final void setAttached(boolean paramBoolean)
  {
    this.nOG = paramBoolean;
  }
  
  public final void setBrowserTimeMs(long paramLong)
  {
    this.NNs = paramLong;
  }
  
  protected final void setStartTimeMs(long paramLong)
  {
    this.startTimeMs = paramLong;
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.recordvideo.plugin.parent.BasePluginLayout
 * JD-Core Version:    0.7.0.1
 */