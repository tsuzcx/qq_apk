package com.tencent.mm.plugin.recordvideo.plugin;

import android.content.Intent;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import com.tencent.mm.plugin.recordvideo.jumper.RecordConfigProvider;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/recordvideo/plugin/AutoRegisterPlugin;", "Lcom/tencent/mm/plugin/recordvideo/plugin/IBaseRecordPlugin;", "status", "Lcom/tencent/mm/plugin/recordvideo/plugin/parent/IRecordStatus;", "customName", "", "(Lcom/tencent/mm/plugin/recordvideo/plugin/parent/IRecordStatus;Ljava/lang/String;)V", "getCustomName", "()Ljava/lang/String;", "setCustomName", "(Ljava/lang/String;)V", "getStatus", "()Lcom/tencent/mm/plugin/recordvideo/plugin/parent/IRecordStatus;", "setStatus", "(Lcom/tencent/mm/plugin/recordvideo/plugin/parent/IRecordStatus;)V", "getView", "T", "Landroid/view/View;", "resId", "", "(I)Landroid/view/View;", "name", "plugin-recordvideo_release"}, k=1, mv={1, 5, 1}, xi=48)
public abstract class a
  implements v
{
  public com.tencent.mm.plugin.recordvideo.plugin.parent.a GrC;
  private String NJz;
  
  public a(com.tencent.mm.plugin.recordvideo.plugin.parent.a parama, String paramString)
  {
    this.GrC = parama;
    this.NJz = paramString;
    this.GrC.a((v)this);
  }
  
  public final <T extends View> T UH(int paramInt)
  {
    View localView = ((ViewGroup)this.GrC).findViewById(paramInt);
    s.s(localView, "status as ViewGroup).findViewById(resId)");
    return localView;
  }
  
  public void a(RecordConfigProvider paramRecordConfigProvider)
  {
    v.a.a(this, paramRecordConfigProvider);
  }
  
  public final void aTb(String paramString)
  {
    this.NJz = paramString;
  }
  
  public void bwk()
  {
    s.u(this, "this");
  }
  
  public final String name()
  {
    if (TextUtils.isEmpty((CharSequence)this.NJz)) {
      return getClass().getName();
    }
    return this.NJz;
  }
  
  public final void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    s.u(this, "this");
  }
  
  public boolean onBackPress()
  {
    s.u(this, "this");
    return false;
  }
  
  public void onDetach()
  {
    s.u(this, "this");
  }
  
  public void onPause()
  {
    s.u(this, "this");
  }
  
  public void onRequestPermissionsResult(int paramInt, String[] paramArrayOfString, int[] paramArrayOfInt)
  {
    v.a.a(this, paramArrayOfString, paramArrayOfInt);
  }
  
  public void onResume()
  {
    s.u(this, "this");
  }
  
  public void release()
  {
    s.u(this, "this");
  }
  
  public void reset()
  {
    s.u(this, "this");
  }
  
  public void setVisibility(int paramInt)
  {
    s.u(this, "this");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.recordvideo.plugin.a
 * JD-Core Version:    0.7.0.1
 */