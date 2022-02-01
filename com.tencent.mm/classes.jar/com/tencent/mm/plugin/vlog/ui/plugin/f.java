package com.tencent.mm.plugin.vlog.ui.plugin;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.recordvideo.plugin.parent.d;
import com.tencent.mm.plugin.recordvideo.plugin.parent.d.c;
import com.tencent.mm.plugin.recordvideo.plugin.t;
import com.tencent.mm.ui.am;
import d.g.b.k;
import d.l;

@l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/plugin/vlog/ui/plugin/VLogCropVideoPlugin;", "Lcom/tencent/mm/plugin/recordvideo/plugin/IBaseRecordPlugin;", "layout", "Landroid/view/View;", "status", "Lcom/tencent/mm/plugin/recordvideo/plugin/parent/IRecordStatus;", "(Landroid/view/View;Lcom/tencent/mm/plugin/recordvideo/plugin/parent/IRecordStatus;)V", "cropBtn", "Landroid/widget/ImageView;", "getLayout", "()Landroid/view/View;", "getStatus", "()Lcom/tencent/mm/plugin/recordvideo/plugin/parent/IRecordStatus;", "setVisibility", "", "visibility", "", "plugin-vlog_release"})
public final class f
  implements t
{
  private final View pf;
  final d vjo;
  private final ImageView vlP;
  
  public f(View paramView, d paramd)
  {
    AppMethodBeat.i(201129);
    this.pf = paramView;
    this.vjo = paramd;
    paramView = this.pf.findViewById(2131299289);
    k.g(paramView, "layout.findViewById(R.id.editor_crop_video)");
    this.vlP = ((ImageView)paramView);
    this.vlP.setImageDrawable(am.i(this.pf.getContext(), 2131690382, -1));
    this.vlP.setOnClickListener((View.OnClickListener)new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(201127);
        paramAnonymousView = new Bundle();
        this.LtU.vjo.a(d.c.vnY, paramAnonymousView);
        AppMethodBeat.o(201127);
      }
    });
    AppMethodBeat.o(201129);
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
  
  public final void setVisibility(int paramInt)
  {
    AppMethodBeat.i(201128);
    this.vlP.setVisibility(paramInt);
    AppMethodBeat.o(201128);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.vlog.ui.plugin.f
 * JD-Core Version:    0.7.0.1
 */