package com.tencent.mm.plugin.recordvideo.plugin;

import android.content.Intent;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.widget.RelativeLayout.LayoutParams;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.recordvideo.plugin.parent.d;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.ui.ap;
import d.l;

@l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/plugin/recordvideo/plugin/EditPhotoShadowPlugin;", "Lcom/tencent/mm/plugin/recordvideo/plugin/IBaseRecordPlugin;", "view", "Landroid/view/View;", "status", "Lcom/tencent/mm/plugin/recordvideo/plugin/parent/IRecordStatus;", "(Landroid/view/View;Lcom/tencent/mm/plugin/recordvideo/plugin/parent/IRecordStatus;)V", "TAG", "", "getStatus", "()Lcom/tencent/mm/plugin/recordvideo/plugin/parent/IRecordStatus;", "setStatus", "(Lcom/tencent/mm/plugin/recordvideo/plugin/parent/IRecordStatus;)V", "getView", "()Landroid/view/View;", "setView", "(Landroid/view/View;)V", "plugin-recordvideo_release"})
public final class n
  implements t
{
  private final String TAG;
  private d rTT;
  private View view;
  
  public n(View paramView, d paramd)
  {
    AppMethodBeat.i(75563);
    this.view = paramView;
    this.rTT = paramd;
    this.TAG = "MicroMsg.EditPhotoShadowPlugin";
    ac.i(this.TAG, "status bar : " + ap.ej(this.view.getContext()));
    paramView = new RelativeLayout.LayoutParams(-1, this.view.getLayoutParams().height + ap.ej(this.view.getContext()));
    paramView.addRule(12, -1);
    this.view.setLayoutParams((ViewGroup.LayoutParams)paramView);
    this.view.invalidate();
    AppMethodBeat.o(75563);
  }
  
  public final boolean alO()
  {
    return false;
  }
  
  public final void awk() {}
  
  public final String name()
  {
    return null;
  }
  
  public final void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent) {}
  
  public final void onDetach() {}
  
  public final void onPause() {}
  
  public final void onResume() {}
  
  public final void release() {}
  
  public final void reset() {}
  
  public final void setVisibility(int paramInt) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.recordvideo.plugin.n
 * JD-Core Version:    0.7.0.1
 */