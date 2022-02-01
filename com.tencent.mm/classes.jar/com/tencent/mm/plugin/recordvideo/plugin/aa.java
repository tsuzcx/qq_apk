package com.tencent.mm.plugin.recordvideo.plugin;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.plugin.recordvideo.b.g;
import com.tencent.mm.plugin.recordvideo.jumper.RecordConfigProvider;
import com.tencent.mm.plugin.recordvideo.plugin.parent.a.c;
import com.tencent.mm.ui.bb;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/recordvideo/plugin/RecordFilterPlugin;", "Lcom/tencent/mm/plugin/recordvideo/plugin/IBaseRecordPlugin;", "view", "Landroid/widget/ImageView;", "status", "Lcom/tencent/mm/plugin/recordvideo/plugin/parent/IRecordStatus;", "(Landroid/widget/ImageView;Lcom/tencent/mm/plugin/recordvideo/plugin/parent/IRecordStatus;)V", "enable", "", "pluginEnable", "getStatus", "()Lcom/tencent/mm/plugin/recordvideo/plugin/parent/IRecordStatus;", "getView", "()Landroid/widget/ImageView;", "initConfig", "", "config", "Lcom/tencent/mm/plugin/recordvideo/jumper/RecordConfigProvider;", "setEnable", "setVisibility", "visibility", "", "plugin-recordvideo_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class aa
  implements v
{
  private final com.tencent.mm.plugin.recordvideo.plugin.parent.a GrC;
  public boolean Gsz;
  public final ImageView cqj;
  private boolean enable;
  
  public aa(ImageView paramImageView, com.tencent.mm.plugin.recordvideo.plugin.parent.a parama)
  {
    AppMethodBeat.i(182853);
    this.cqj = paramImageView;
    this.GrC = parama;
    this.cqj.setImageDrawable(bb.m(this.cqj.getContext(), b.g.icons_filled_filters, -1));
    this.cqj.setOnClickListener(new aa..ExternalSyntheticLambda0(this));
    AppMethodBeat.o(182853);
  }
  
  private static final void a(aa paramaa, View paramView)
  {
    AppMethodBeat.i(280692);
    Object localObject = new Object();
    b localb = new b();
    localb.cH(paramaa);
    localb.cH(paramView);
    com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/recordvideo/plugin/RecordFilterPlugin", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", localObject, localb.aYj());
    s.u(paramaa, "this$0");
    if (!paramaa.enable) {}
    for (boolean bool = true;; bool = false)
    {
      paramaa.setEnable(bool);
      com.tencent.mm.hellhoundlib.a.a.a(new Object(), "com/tencent/mm/plugin/recordvideo/plugin/RecordFilterPlugin", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(280692);
      return;
    }
  }
  
  public final void a(RecordConfigProvider paramRecordConfigProvider)
  {
    AppMethodBeat.i(280710);
    v.a.a(this, paramRecordConfigProvider);
    AppMethodBeat.o(280710);
  }
  
  public final void bwk()
  {
    AppMethodBeat.i(280728);
    s.u(this, "this");
    AppMethodBeat.o(280728);
  }
  
  public final String name()
  {
    AppMethodBeat.i(280715);
    String str = v.a.b(this);
    AppMethodBeat.o(280715);
    return str;
  }
  
  public final void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    AppMethodBeat.i(280722);
    s.u(this, "this");
    AppMethodBeat.o(280722);
  }
  
  public final boolean onBackPress()
  {
    AppMethodBeat.i(280735);
    s.u(this, "this");
    AppMethodBeat.o(280735);
    return false;
  }
  
  public final void onDetach()
  {
    AppMethodBeat.i(280745);
    s.u(this, "this");
    AppMethodBeat.o(280745);
  }
  
  public final void onPause()
  {
    AppMethodBeat.i(280751);
    s.u(this, "this");
    AppMethodBeat.o(280751);
  }
  
  public final void onRequestPermissionsResult(int paramInt, String[] paramArrayOfString, int[] paramArrayOfInt)
  {
    AppMethodBeat.i(280760);
    v.a.a(this, paramArrayOfString, paramArrayOfInt);
    AppMethodBeat.o(280760);
  }
  
  public final void onResume()
  {
    AppMethodBeat.i(280771);
    s.u(this, "this");
    AppMethodBeat.o(280771);
  }
  
  public final void release()
  {
    AppMethodBeat.i(280780);
    s.u(this, "this");
    AppMethodBeat.o(280780);
  }
  
  public final void reset()
  {
    AppMethodBeat.i(280789);
    s.u(this, "this");
    AppMethodBeat.o(280789);
  }
  
  public final void setEnable(boolean paramBoolean)
  {
    AppMethodBeat.i(182852);
    this.enable = paramBoolean;
    Bundle localBundle = new Bundle();
    localBundle.putBoolean("PARAM_BEAUTIFY_ENABLE", paramBoolean);
    this.GrC.a(a.c.NNW, localBundle);
    AppMethodBeat.o(182852);
  }
  
  public final void setVisibility(int paramInt)
  {
    AppMethodBeat.i(182851);
    if (this.Gsz) {
      this.cqj.setVisibility(paramInt);
    }
    AppMethodBeat.o(182851);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.recordvideo.plugin.aa
 * JD-Core Version:    0.7.0.1
 */