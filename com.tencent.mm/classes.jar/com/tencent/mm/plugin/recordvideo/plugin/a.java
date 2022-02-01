package com.tencent.mm.plugin.recordvideo.plugin;

import android.content.Intent;
import android.text.TextUtils;
import com.tencent.mm.plugin.recordvideo.plugin.parent.d;
import kotlin.g.b.p;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/recordvideo/plugin/AutoRegisterPlugin;", "Lcom/tencent/mm/plugin/recordvideo/plugin/IBaseRecordPlugin;", "status", "Lcom/tencent/mm/plugin/recordvideo/plugin/parent/IRecordStatus;", "customName", "", "(Lcom/tencent/mm/plugin/recordvideo/plugin/parent/IRecordStatus;Ljava/lang/String;)V", "getCustomName", "()Ljava/lang/String;", "setCustomName", "(Ljava/lang/String;)V", "name", "plugin-recordvideo_release"})
public abstract class a
  implements u
{
  private String HMC = null;
  
  private a(d paramd)
  {
    paramd.a((u)this);
  }
  
  public final void aVU(String paramString)
  {
    this.HMC = paramString;
  }
  
  public void bbp() {}
  
  public final String name()
  {
    if (TextUtils.isEmpty((CharSequence)this.HMC)) {
      return getClass().getName();
    }
    return this.HMC;
  }
  
  public final void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent) {}
  
  public boolean onBackPress()
  {
    return false;
  }
  
  public void onDetach() {}
  
  public void onPause() {}
  
  public void onRequestPermissionsResult(int paramInt, String[] paramArrayOfString, int[] paramArrayOfInt)
  {
    p.k(paramArrayOfString, "permissions");
    p.k(paramArrayOfInt, "grantResults");
    u.a.a(paramArrayOfString, paramArrayOfInt);
  }
  
  public void onResume() {}
  
  public void release() {}
  
  public void reset() {}
  
  public void setVisibility(int paramInt) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.recordvideo.plugin.a
 * JD-Core Version:    0.7.0.1
 */