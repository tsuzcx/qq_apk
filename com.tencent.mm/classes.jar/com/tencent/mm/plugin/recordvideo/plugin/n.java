package com.tencent.mm.plugin.recordvideo.plugin;

import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.plugin.recordvideo.b.g;
import com.tencent.mm.plugin.recordvideo.b.h;
import com.tencent.mm.plugin.recordvideo.f.c;
import com.tencent.mm.plugin.recordvideo.jumper.RecordConfigProvider;
import com.tencent.mm.plugin.recordvideo.plugin.parent.a.b;
import com.tencent.mm.plugin.recordvideo.plugin.parent.a.c;
import com.tencent.mm.ui.bb;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/recordvideo/plugin/EditPhotoCropPlugin;", "Landroid/view/View$OnClickListener;", "Lcom/tencent/mm/plugin/recordvideo/plugin/IBaseRecordPlugin;", "view", "Landroid/widget/ImageView;", "status", "Lcom/tencent/mm/plugin/recordvideo/plugin/parent/IRecordStatus;", "(Landroid/widget/ImageView;Lcom/tencent/mm/plugin/recordvideo/plugin/parent/IRecordStatus;)V", "getStatus", "()Lcom/tencent/mm/plugin/recordvideo/plugin/parent/IRecordStatus;", "setStatus", "(Lcom/tencent/mm/plugin/recordvideo/plugin/parent/IRecordStatus;)V", "getView", "()Landroid/widget/ImageView;", "setView", "(Landroid/widget/ImageView;)V", "onClick", "", "v", "Landroid/view/View;", "setVisibility", "visibility", "", "plugin-recordvideo_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class n
  implements View.OnClickListener, v
{
  private com.tencent.mm.plugin.recordvideo.plugin.parent.a GrC;
  private ImageView cqj;
  
  public n(ImageView paramImageView, com.tencent.mm.plugin.recordvideo.plugin.parent.a parama)
  {
    AppMethodBeat.i(75558);
    this.cqj = paramImageView;
    this.GrC = parama;
    this.cqj.setVisibility(0);
    this.cqj.setImageDrawable(bb.m(this.cqj.getContext(), b.g.icons_filled_clip, -1));
    this.cqj.setOnClickListener((View.OnClickListener)this);
    AppMethodBeat.o(75558);
  }
  
  public final void a(RecordConfigProvider paramRecordConfigProvider)
  {
    AppMethodBeat.i(280603);
    v.a.a(this, paramRecordConfigProvider);
    AppMethodBeat.o(280603);
  }
  
  public final void bwk()
  {
    AppMethodBeat.i(280620);
    s.u(this, "this");
    AppMethodBeat.o(280620);
  }
  
  public final String name()
  {
    AppMethodBeat.i(280610);
    String str = v.a.b(this);
    AppMethodBeat.o(280610);
    return str;
  }
  
  public final void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    AppMethodBeat.i(280616);
    s.u(this, "this");
    AppMethodBeat.o(280616);
  }
  
  public final boolean onBackPress()
  {
    AppMethodBeat.i(280628);
    s.u(this, "this");
    AppMethodBeat.o(280628);
    return false;
  }
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(75556);
    b localb = new b();
    localb.cH(paramView);
    com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/recordvideo/plugin/EditPhotoCropPlugin", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aYj());
    a.b.a(this.GrC, a.c.NOV);
    paramView = c.NRf;
    c.agG(10);
    paramView = c.NRf;
    c.aTg("KEY_CLICK_CROP_COUNT_INT");
    this.cqj.announceForAccessibility((CharSequence)com.tencent.mm.cd.a.bt(this.cqj.getContext(), b.h.aging_crop_photo));
    com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/recordvideo/plugin/EditPhotoCropPlugin", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(75556);
  }
  
  public final void onDetach()
  {
    AppMethodBeat.i(280636);
    s.u(this, "this");
    AppMethodBeat.o(280636);
  }
  
  public final void onPause()
  {
    AppMethodBeat.i(280645);
    s.u(this, "this");
    AppMethodBeat.o(280645);
  }
  
  public final void onRequestPermissionsResult(int paramInt, String[] paramArrayOfString, int[] paramArrayOfInt)
  {
    AppMethodBeat.i(280651);
    v.a.a(this, paramArrayOfString, paramArrayOfInt);
    AppMethodBeat.o(280651);
  }
  
  public final void onResume()
  {
    AppMethodBeat.i(280661);
    s.u(this, "this");
    AppMethodBeat.o(280661);
  }
  
  public final void release()
  {
    AppMethodBeat.i(280667);
    s.u(this, "this");
    AppMethodBeat.o(280667);
  }
  
  public final void reset()
  {
    AppMethodBeat.i(280677);
    s.u(this, "this");
    AppMethodBeat.o(280677);
  }
  
  public final void setVisibility(int paramInt)
  {
    AppMethodBeat.i(75557);
    this.cqj.setVisibility(paramInt);
    AppMethodBeat.o(75557);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.recordvideo.plugin.n
 * JD-Core Version:    0.7.0.1
 */