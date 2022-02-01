package com.tencent.mm.plugin.recordvideo.plugin;

import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.recordvideo.d.c;
import com.tencent.mm.plugin.recordvideo.plugin.parent.d;
import com.tencent.mm.plugin.recordvideo.plugin.parent.d.b;
import com.tencent.mm.plugin.recordvideo.plugin.parent.d.c;
import com.tencent.mm.ui.am;
import d.l;

@l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/plugin/recordvideo/plugin/EditBackToRecordPlugin;", "Landroid/view/View$OnClickListener;", "Lcom/tencent/mm/plugin/recordvideo/plugin/IBaseRecordPlugin;", "view", "Landroid/widget/ImageView;", "status", "Lcom/tencent/mm/plugin/recordvideo/plugin/parent/IRecordStatus;", "(Landroid/widget/ImageView;Lcom/tencent/mm/plugin/recordvideo/plugin/parent/IRecordStatus;)V", "getStatus", "()Lcom/tencent/mm/plugin/recordvideo/plugin/parent/IRecordStatus;", "setStatus", "(Lcom/tencent/mm/plugin/recordvideo/plugin/parent/IRecordStatus;)V", "getView", "()Landroid/widget/ImageView;", "setView", "(Landroid/widget/ImageView;)V", "name", "", "onClick", "", "v", "Landroid/view/View;", "setVisibility", "visibility", "", "plugin-recordvideo_release"})
public final class e
  implements View.OnClickListener, t
{
  private ImageView qSI;
  private d rTT;
  
  public e(ImageView paramImageView, d paramd)
  {
    AppMethodBeat.i(75485);
    this.qSI = paramImageView;
    this.rTT = paramd;
    this.qSI.setImageDrawable(am.k(this.qSI.getContext(), 2131690463, -1));
    this.qSI.setOnClickListener((View.OnClickListener)this);
    AppMethodBeat.o(75485);
  }
  
  public final boolean alO()
  {
    return false;
  }
  
  public final void awk() {}
  
  public final String name()
  {
    return "plugin_back";
  }
  
  public final void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(75483);
    d.b.a(this.rTT, d.c.wwl);
    paramView = c.wyg;
    c.Mn(11);
    paramView = c.wyg;
    c.Mo(12);
    AppMethodBeat.o(75483);
  }
  
  public final void onDetach() {}
  
  public final void onPause() {}
  
  public final void onResume() {}
  
  public final void release() {}
  
  public final void reset() {}
  
  public final void setVisibility(int paramInt)
  {
    AppMethodBeat.i(75484);
    this.qSI.setVisibility(paramInt);
    AppMethodBeat.o(75484);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.recordvideo.plugin.e
 * JD-Core Version:    0.7.0.1
 */