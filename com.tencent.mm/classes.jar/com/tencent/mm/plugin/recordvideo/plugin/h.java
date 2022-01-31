package com.tencent.mm.plugin.recordvideo.plugin;

import a.l;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.recordvideo.c.b;
import com.tencent.mm.plugin.recordvideo.plugin.parent.d;
import com.tencent.mm.plugin.recordvideo.plugin.parent.d.b;
import com.tencent.mm.plugin.recordvideo.plugin.parent.d.c;
import com.tencent.mm.ui.aj;

@l(eaO={1, 1, 13}, eaP={""}, eaQ={"Lcom/tencent/mm/plugin/recordvideo/plugin/EditPhotoCropPlugin;", "Landroid/view/View$OnClickListener;", "Lcom/tencent/mm/plugin/recordvideo/plugin/IBaseRecordPlugin;", "view", "Landroid/widget/ImageView;", "status", "Lcom/tencent/mm/plugin/recordvideo/plugin/parent/IRecordStatus;", "(Landroid/widget/ImageView;Lcom/tencent/mm/plugin/recordvideo/plugin/parent/IRecordStatus;)V", "getStatus", "()Lcom/tencent/mm/plugin/recordvideo/plugin/parent/IRecordStatus;", "setStatus", "(Lcom/tencent/mm/plugin/recordvideo/plugin/parent/IRecordStatus;)V", "getView", "()Landroid/widget/ImageView;", "setView", "(Landroid/widget/ImageView;)V", "onClick", "", "v", "Landroid/view/View;", "setVisibility", "visibility", "", "plugin-recordvideo_release"})
public final class h
  implements View.OnClickListener, q
{
  private ImageView mCy;
  private d qbI;
  
  public h(ImageView paramImageView, d paramd)
  {
    AppMethodBeat.i(150647);
    this.mCy = paramImageView;
    this.qbI = paramd;
    this.mCy.setVisibility(0);
    this.mCy.setImageDrawable(aj.g(this.mCy.getContext(), 2131231203, -1));
    this.mCy.setOnClickListener((View.OnClickListener)this);
    AppMethodBeat.o(150647);
  }
  
  public final boolean cgq()
  {
    return false;
  }
  
  public final String name()
  {
    return null;
  }
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(150645);
    d.b.a(this.qbI, d.c.qeP);
    paramView = b.qfu;
    b.Cs(10);
    paramView = b.qfu;
    b.Ya("KEY_CLICK_CROP_COUNT_INT");
    AppMethodBeat.o(150645);
  }
  
  public final void onPause() {}
  
  public final void onResume() {}
  
  public final void release() {}
  
  public final void reset() {}
  
  public final void setVisibility(int paramInt)
  {
    AppMethodBeat.i(150646);
    this.mCy.setVisibility(paramInt);
    AppMethodBeat.o(150646);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.recordvideo.plugin.h
 * JD-Core Version:    0.7.0.1
 */