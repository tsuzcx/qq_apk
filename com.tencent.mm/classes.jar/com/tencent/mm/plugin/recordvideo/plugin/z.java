package com.tencent.mm.plugin.recordvideo.plugin;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.recordvideo.plugin.parent.d;
import com.tencent.mm.plugin.recordvideo.plugin.parent.d.c;
import com.tencent.mm.ui.am;
import d.l;

@l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/plugin/recordvideo/plugin/RecordFilterPlugin;", "Lcom/tencent/mm/plugin/recordvideo/plugin/IBaseRecordPlugin;", "view", "Landroid/widget/ImageView;", "status", "Lcom/tencent/mm/plugin/recordvideo/plugin/parent/IRecordStatus;", "(Landroid/widget/ImageView;Lcom/tencent/mm/plugin/recordvideo/plugin/parent/IRecordStatus;)V", "enable", "", "pluginEnable", "getStatus", "()Lcom/tencent/mm/plugin/recordvideo/plugin/parent/IRecordStatus;", "getView", "()Landroid/widget/ImageView;", "initConfig", "", "config", "Lcom/tencent/mm/plugin/recordvideo/jumper/RecordConfigProvider;", "setEnable", "setVisibility", "visibility", "", "plugin-recordvideo_release"})
public final class z
  implements t
{
  boolean enable;
  public final ImageView qSI;
  public boolean rTN;
  private final d rTT;
  
  public z(ImageView paramImageView, d paramd)
  {
    AppMethodBeat.i(182853);
    this.qSI = paramImageView;
    this.rTT = paramd;
    this.qSI.setImageDrawable(am.k(this.qSI.getContext(), 2131690401, -1));
    this.qSI.setOnClickListener((View.OnClickListener)new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(182850);
        paramAnonymousView = this.wtP;
        if (!this.wtP.enable) {}
        for (boolean bool = true;; bool = false)
        {
          paramAnonymousView.setEnable(bool);
          AppMethodBeat.o(182850);
          return;
        }
      }
    });
    AppMethodBeat.o(182853);
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
  
  public final void setEnable(boolean paramBoolean)
  {
    AppMethodBeat.i(182852);
    this.enable = paramBoolean;
    Bundle localBundle = new Bundle();
    localBundle.putBoolean("PARAM_BEAUTIFY_ENABLE", paramBoolean);
    this.rTT.a(d.c.wwd, localBundle);
    AppMethodBeat.o(182852);
  }
  
  public final void setVisibility(int paramInt)
  {
    AppMethodBeat.i(182851);
    if (this.rTN) {
      this.qSI.setVisibility(paramInt);
    }
    AppMethodBeat.o(182851);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.recordvideo.plugin.z
 * JD-Core Version:    0.7.0.1
 */