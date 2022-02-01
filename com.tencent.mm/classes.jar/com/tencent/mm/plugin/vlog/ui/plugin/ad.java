package com.tencent.mm.plugin.vlog.ui.plugin;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.plugin.recordvideo.b.b;
import com.tencent.mm.plugin.recordvideo.b.e;
import com.tencent.mm.plugin.recordvideo.b.g;
import com.tencent.mm.plugin.recordvideo.plugin.parent.a.c;
import com.tencent.mm.ui.bb;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/vlog/ui/plugin/VLogCropVideoPlugin;", "Lcom/tencent/mm/plugin/recordvideo/plugin/AutoRegisterPlugin;", "layout", "Landroid/view/View;", "status", "Lcom/tencent/mm/plugin/recordvideo/plugin/parent/IRecordStatus;", "(Landroid/view/View;Lcom/tencent/mm/plugin/recordvideo/plugin/parent/IRecordStatus;)V", "cropBtn", "Landroid/widget/ImageView;", "getLayout", "()Landroid/view/View;", "setVisibility", "", "visibility", "", "plugin-vlog_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class ad
  extends com.tencent.mm.plugin.recordvideo.plugin.a
{
  private final ImageView NLP;
  private final View doN;
  
  public ad(View paramView, com.tencent.mm.plugin.recordvideo.plugin.parent.a parama)
  {
    super(parama);
    AppMethodBeat.i(282692);
    this.doN = paramView;
    paramView = this.doN.findViewById(b.e.editor_crop_video);
    s.s(paramView, "layout.findViewById(R.id.editor_crop_video)");
    this.NLP = ((ImageView)paramView);
    this.NLP.setImageDrawable(bb.m(this.doN.getContext(), b.g.icons_filled_crop, com.tencent.mm.cd.a.w(this.doN.getContext(), b.b.video_editor_white_color)));
    this.NLP.setOnClickListener(new ad..ExternalSyntheticLambda0(parama));
    AppMethodBeat.o(282692);
  }
  
  private static final void a(com.tencent.mm.plugin.recordvideo.plugin.parent.a parama, View paramView)
  {
    AppMethodBeat.i(282702);
    Object localObject = new Object();
    b localb = new b();
    localb.cH(parama);
    localb.cH(paramView);
    com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/vlog/ui/plugin/VLogCropVideoPlugin", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", localObject, localb.aYj());
    s.u(parama, "$status");
    paramView = new Bundle();
    parama.a(a.c.NOH, paramView);
    com.tencent.mm.hellhoundlib.a.a.a(new Object(), "com/tencent/mm/plugin/vlog/ui/plugin/VLogCropVideoPlugin", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(282702);
  }
  
  public final void setVisibility(int paramInt)
  {
    AppMethodBeat.i(282720);
    this.NLP.setVisibility(paramInt);
    AppMethodBeat.o(282720);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.vlog.ui.plugin.ad
 * JD-Core Version:    0.7.0.1
 */