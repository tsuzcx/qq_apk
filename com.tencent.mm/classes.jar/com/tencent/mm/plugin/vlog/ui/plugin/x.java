package com.tencent.mm.plugin.vlog.ui.plugin;

import android.content.Intent;
import android.view.View;
import android.view.ViewGroup;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.recordvideo.plugin.parent.d;
import com.tencent.mm.plugin.recordvideo.plugin.t;
import com.tencent.mm.plugin.recordvideo.plugin.t.a;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/vlog/ui/plugin/NormalModeContainerPlugin;", "Lcom/tencent/mm/plugin/recordvideo/plugin/IBaseRecordPlugin;", "parent", "Landroid/view/ViewGroup;", "status", "Lcom/tencent/mm/plugin/recordvideo/plugin/parent/IRecordStatus;", "(Landroid/view/ViewGroup;Lcom/tencent/mm/plugin/recordvideo/plugin/parent/IRecordStatus;)V", "imageView", "Landroid/view/View;", "kotlin.jvm.PlatformType", "getParent", "()Landroid/view/ViewGroup;", "setParent", "(Landroid/view/ViewGroup;)V", "getStatus", "()Lcom/tencent/mm/plugin/recordvideo/plugin/parent/IRecordStatus;", "setStatus", "(Lcom/tencent/mm/plugin/recordvideo/plugin/parent/IRecordStatus;)V", "videoView", "view", "setVisibility", "", "visibility", "", "setupImage", "setupVideo", "plugin-vlog_release"})
public final class x
  implements t
{
  private final View GIm;
  private final View GIn;
  private ViewGroup parent;
  private View view;
  private d wgr;
  
  public x(ViewGroup paramViewGroup, d paramd)
  {
    AppMethodBeat.i(191452);
    this.parent = paramViewGroup;
    this.wgr = paramd;
    this.GIm = this.parent.findViewById(2131305477);
    this.GIn = this.parent.findViewById(2131309907);
    this.view = this.GIn;
    AppMethodBeat.o(191452);
  }
  
  public final void aSs() {}
  
  public final void fDL()
  {
    this.view = this.GIm;
  }
  
  public final void fDM()
  {
    AppMethodBeat.i(191450);
    View localView = this.GIm;
    p.g(localView, "imageView");
    localView.setVisibility(8);
    this.view = this.GIn;
    AppMethodBeat.o(191450);
  }
  
  public final String name()
  {
    return null;
  }
  
  public final void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent) {}
  
  public final boolean onBackPress()
  {
    return false;
  }
  
  public final void onDetach() {}
  
  public final void onPause() {}
  
  public final void onRequestPermissionsResult(int paramInt, String[] paramArrayOfString, int[] paramArrayOfInt)
  {
    AppMethodBeat.i(191453);
    p.h(paramArrayOfString, "permissions");
    p.h(paramArrayOfInt, "grantResults");
    t.a.a(paramArrayOfString, paramArrayOfInt);
    AppMethodBeat.o(191453);
  }
  
  public final void onResume() {}
  
  public final void release() {}
  
  public final void reset() {}
  
  public final void setVisibility(int paramInt)
  {
    AppMethodBeat.i(191451);
    View localView = this.view;
    p.g(localView, "view");
    localView.setVisibility(paramInt);
    AppMethodBeat.o(191451);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.vlog.ui.plugin.x
 * JD-Core Version:    0.7.0.1
 */