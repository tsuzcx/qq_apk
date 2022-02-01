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

@l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/plugin/vlog/ui/plugin/VLogCropVideoPlugin;", "Lcom/tencent/mm/plugin/recordvideo/plugin/IBaseRecordPlugin;", "layout", "Landroid/view/View;", "status", "Lcom/tencent/mm/plugin/recordvideo/plugin/parent/IRecordStatus;", "(Landroid/view/View;Lcom/tencent/mm/plugin/recordvideo/plugin/parent/IRecordStatus;)V", "cropBtn", "Landroid/widget/ImageView;", "getLayout", "()Landroid/view/View;", "getStatus", "()Lcom/tencent/mm/plugin/recordvideo/plugin/parent/IRecordStatus;", "setVisibility", "", "visibility", "", "plugin-vlog_release"})
public final class e
  implements t
{
  private final View qe;
  final d rTT;
  private final ImageView wuv;
  
  public e(View paramView, d paramd)
  {
    AppMethodBeat.i(207812);
    this.qe = paramView;
    this.rTT = paramd;
    paramView = this.qe.findViewById(2131299289);
    k.g(paramView, "layout.findViewById(R.id.editor_crop_video)");
    this.wuv = ((ImageView)paramView);
    this.wuv.setImageDrawable(am.k(this.qe.getContext(), 2131690382, -1));
    this.wuv.setOnClickListener((View.OnClickListener)new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(207810);
        paramAnonymousView = new Bundle();
        this.Atm.rTT.a(d.c.wwF, paramAnonymousView);
        AppMethodBeat.o(207810);
      }
    });
    AppMethodBeat.o(207812);
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
  
  public final void setVisibility(int paramInt)
  {
    AppMethodBeat.i(207811);
    this.wuv.setVisibility(paramInt);
    AppMethodBeat.o(207811);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.vlog.ui.plugin.e
 * JD-Core Version:    0.7.0.1
 */