package com.tencent.mm.plugin.recordvideo.plugin;

import a.l;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.recordvideo.plugin.parent.d;
import com.tencent.mm.ui.aj;

@l(eaO={1, 1, 13}, eaP={""}, eaQ={"Lcom/tencent/mm/plugin/recordvideo/plugin/RecordAlbumPlugin;", "Landroid/view/View$OnClickListener;", "Lcom/tencent/mm/plugin/recordvideo/plugin/IBaseRecordPlugin;", "view", "Landroid/widget/ImageView;", "status", "Lcom/tencent/mm/plugin/recordvideo/plugin/parent/IRecordStatus;", "(Landroid/widget/ImageView;Lcom/tencent/mm/plugin/recordvideo/plugin/parent/IRecordStatus;)V", "enable", "", "getView", "()Landroid/widget/ImageView;", "setView", "(Landroid/widget/ImageView;)V", "onClick", "", "v", "Landroid/view/View;", "setEnable", "setVisibility", "visibility", "", "Companion", "plugin-recordvideo_release"})
public final class r
  implements View.OnClickListener, q
{
  public static final r.a qcO;
  public boolean enable;
  private ImageView mCy;
  
  static
  {
    AppMethodBeat.i(150695);
    qcO = new r.a((byte)0);
    AppMethodBeat.o(150695);
  }
  
  public r(ImageView paramImageView, d paramd)
  {
    AppMethodBeat.i(150694);
    this.mCy = paramImageView;
    this.mCy.setOnClickListener((View.OnClickListener)this);
    this.mCy.setImageDrawable(aj.g(this.mCy.getContext(), 2131231436, -1));
    this.enable = true;
    AppMethodBeat.o(150694);
  }
  
  public final boolean cgq()
  {
    return false;
  }
  
  public final String name()
  {
    return null;
  }
  
  public final void onClick(View paramView) {}
  
  public final void onPause() {}
  
  public final void onResume() {}
  
  public final void release() {}
  
  public final void reset() {}
  
  public final void setVisibility(int paramInt)
  {
    AppMethodBeat.i(150693);
    if (this.enable) {
      this.mCy.setVisibility(paramInt);
    }
    AppMethodBeat.o(150693);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.recordvideo.plugin.r
 * JD-Core Version:    0.7.0.1
 */