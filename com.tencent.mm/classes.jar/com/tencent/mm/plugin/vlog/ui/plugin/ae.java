package com.tencent.mm.plugin.vlog.ui.plugin;

import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.plugin.recordvideo.b.b;
import com.tencent.mm.plugin.recordvideo.b.e;
import com.tencent.mm.plugin.recordvideo.b.g;
import com.tencent.mm.plugin.recordvideo.plugin.parent.d;
import com.tencent.mm.plugin.recordvideo.plugin.parent.d.c;
import com.tencent.mm.ui.au;
import kotlin.g.b.p;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/vlog/ui/plugin/VLogCropVideoPlugin;", "Lcom/tencent/mm/plugin/recordvideo/plugin/AutoRegisterPlugin;", "layout", "Landroid/view/View;", "status", "Lcom/tencent/mm/plugin/recordvideo/plugin/parent/IRecordStatus;", "(Landroid/view/View;Lcom/tencent/mm/plugin/recordvideo/plugin/parent/IRecordStatus;)V", "cropBtn", "Landroid/widget/ImageView;", "getLayout", "()Landroid/view/View;", "getStatus", "()Lcom/tencent/mm/plugin/recordvideo/plugin/parent/IRecordStatus;", "setVisibility", "", "visibility", "", "plugin-vlog_release"})
public final class ae
  extends com.tencent.mm.plugin.recordvideo.plugin.a
{
  final d APl;
  private final ImageView HPg;
  private final View bvK;
  
  public ae(View paramView, d paramd)
  {
    super(paramd, (byte)0);
    AppMethodBeat.i(248341);
    this.bvK = paramView;
    this.APl = paramd;
    paramView = this.bvK.findViewById(b.e.editor_crop_video);
    p.j(paramView, "layout.findViewById(R.id.editor_crop_video)");
    this.HPg = ((ImageView)paramView);
    this.HPg.setImageDrawable(au.o(this.bvK.getContext(), b.g.icons_filled_crop, com.tencent.mm.ci.a.w(this.bvK.getContext(), b.b.video_editor_white_color)));
    this.HPg.setOnClickListener((View.OnClickListener)new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(234821);
        b localb = new b();
        localb.bn(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/vlog/ui/plugin/VLogCropVideoPlugin$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aFi());
        paramAnonymousView = new Bundle();
        this.NwH.APl.a(d.c.HSb, paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/vlog/ui/plugin/VLogCropVideoPlugin$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(234821);
      }
    });
    AppMethodBeat.o(248341);
  }
  
  public final void setVisibility(int paramInt)
  {
    AppMethodBeat.i(248338);
    this.HPg.setVisibility(paramInt);
    AppMethodBeat.o(248338);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.vlog.ui.plugin.ae
 * JD-Core Version:    0.7.0.1
 */