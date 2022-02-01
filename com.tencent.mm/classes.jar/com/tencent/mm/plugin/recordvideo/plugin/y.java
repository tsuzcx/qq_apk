package com.tencent.mm.plugin.recordvideo.plugin;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.plugin.recordvideo.plugin.parent.d;
import com.tencent.mm.plugin.recordvideo.plugin.parent.d.c;
import com.tencent.mm.ui.ar;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/recordvideo/plugin/RecordFilterPlugin;", "Lcom/tencent/mm/plugin/recordvideo/plugin/IBaseRecordPlugin;", "view", "Landroid/widget/ImageView;", "status", "Lcom/tencent/mm/plugin/recordvideo/plugin/parent/IRecordStatus;", "(Landroid/widget/ImageView;Lcom/tencent/mm/plugin/recordvideo/plugin/parent/IRecordStatus;)V", "enable", "", "pluginEnable", "getStatus", "()Lcom/tencent/mm/plugin/recordvideo/plugin/parent/IRecordStatus;", "getView", "()Landroid/widget/ImageView;", "initConfig", "", "config", "Lcom/tencent/mm/plugin/recordvideo/jumper/RecordConfigProvider;", "setEnable", "setVisibility", "visibility", "", "plugin-recordvideo_release"})
public final class y
  implements t
{
  boolean enable;
  public final ImageView tkI;
  public boolean wgN;
  private final d wgr;
  
  public y(ImageView paramImageView, d paramd)
  {
    AppMethodBeat.i(182853);
    this.tkI = paramImageView;
    this.wgr = paramd;
    this.tkI.setImageDrawable(ar.m(this.tkI.getContext(), 2131690554, -1));
    this.tkI.setOnClickListener((View.OnClickListener)new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(182850);
        b localb = new b();
        localb.bm(paramAnonymousView);
        a.b("com/tencent/mm/plugin/recordvideo/plugin/RecordFilterPlugin$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.axR());
        paramAnonymousView = this.BRK;
        if (!this.BRK.enable) {}
        for (boolean bool = true;; bool = false)
        {
          paramAnonymousView.setEnable(bool);
          a.a(this, "com/tencent/mm/plugin/recordvideo/plugin/RecordFilterPlugin$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(182850);
          return;
        }
      }
    });
    AppMethodBeat.o(182853);
  }
  
  public final void aSs() {}
  
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
    AppMethodBeat.i(237346);
    p.h(paramArrayOfString, "permissions");
    p.h(paramArrayOfInt, "grantResults");
    t.a.a(paramArrayOfString, paramArrayOfInt);
    AppMethodBeat.o(237346);
  }
  
  public final void onResume() {}
  
  public final void release() {}
  
  public final void reset() {}
  
  public final void setEnable(boolean paramBoolean)
  {
    AppMethodBeat.i(182852);
    this.enable = paramBoolean;
    Bundle localBundle = new Bundle();
    localBundle.putBoolean("PARAM_BEAUTIFY_ENABLE", paramBoolean);
    this.wgr.a(d.c.BUF, localBundle);
    AppMethodBeat.o(182852);
  }
  
  public final void setVisibility(int paramInt)
  {
    AppMethodBeat.i(182851);
    if (this.wgN) {
      this.tkI.setVisibility(paramInt);
    }
    AppMethodBeat.o(182851);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.recordvideo.plugin.y
 * JD-Core Version:    0.7.0.1
 */