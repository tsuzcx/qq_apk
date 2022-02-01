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

@l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/plugin/recordvideo/plugin/RecordFilterPlugin;", "Lcom/tencent/mm/plugin/recordvideo/plugin/IBaseRecordPlugin;", "view", "Landroid/widget/ImageView;", "status", "Lcom/tencent/mm/plugin/recordvideo/plugin/parent/IRecordStatus;", "(Landroid/widget/ImageView;Lcom/tencent/mm/plugin/recordvideo/plugin/parent/IRecordStatus;)V", "enable", "", "pluginEnable", "getStatus", "()Lcom/tencent/mm/plugin/recordvideo/plugin/parent/IRecordStatus;", "getView", "()Landroid/widget/ImageView;", "initConfig", "", "config", "Lcom/tencent/mm/plugin/recordvideo/jumper/RecordConfigProvider;", "setEnable", "setVisibility", "visibility", "", "plugin-recordvideo_release"})
public final class y
  implements t
{
  boolean enable;
  public final ImageView qkg;
  private final d vjo;
  public boolean vkU;
  
  public y(ImageView paramImageView, d paramd)
  {
    AppMethodBeat.i(182853);
    this.qkg = paramImageView;
    this.vjo = paramd;
    this.qkg.setImageDrawable(am.i(this.qkg.getContext(), 2131690401, -1));
    this.qkg.setOnClickListener((View.OnClickListener)new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(182850);
        paramAnonymousView = this.vlj;
        if (!this.vlj.enable) {}
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
  
  public final void apt() {}
  
  public final boolean dia()
  {
    return false;
  }
  
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
    this.vjo.a(d.c.vnC, localBundle);
    AppMethodBeat.o(182852);
  }
  
  public final void setVisibility(int paramInt)
  {
    AppMethodBeat.i(182851);
    if (this.vkU) {
      this.qkg.setVisibility(paramInt);
    }
    AppMethodBeat.o(182851);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.recordvideo.plugin.y
 * JD-Core Version:    0.7.0.1
 */