package com.tencent.mm.plugin.recordvideo.plugin;

import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.recordvideo.d.b;
import com.tencent.mm.plugin.recordvideo.plugin.parent.d;
import com.tencent.mm.plugin.recordvideo.plugin.parent.d.b;
import com.tencent.mm.plugin.recordvideo.plugin.parent.d.c;
import com.tencent.mm.ui.am;

@d.l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/plugin/recordvideo/plugin/EditPhotoCropPlugin;", "Landroid/view/View$OnClickListener;", "Lcom/tencent/mm/plugin/recordvideo/plugin/IBaseRecordPlugin;", "view", "Landroid/widget/ImageView;", "status", "Lcom/tencent/mm/plugin/recordvideo/plugin/parent/IRecordStatus;", "(Landroid/widget/ImageView;Lcom/tencent/mm/plugin/recordvideo/plugin/parent/IRecordStatus;)V", "getStatus", "()Lcom/tencent/mm/plugin/recordvideo/plugin/parent/IRecordStatus;", "setStatus", "(Lcom/tencent/mm/plugin/recordvideo/plugin/parent/IRecordStatus;)V", "getView", "()Landroid/widget/ImageView;", "setView", "(Landroid/widget/ImageView;)V", "name", "", "onClick", "", "v", "Landroid/view/View;", "setVisibility", "visibility", "", "plugin-recordvideo_release"})
public final class l
  implements View.OnClickListener, t
{
  private ImageView qkg;
  private d vjo;
  
  public l(ImageView paramImageView, d paramd)
  {
    AppMethodBeat.i(75558);
    this.qkg = paramImageView;
    this.vjo = paramd;
    this.qkg.setVisibility(0);
    this.qkg.setImageDrawable(am.i(this.qkg.getContext(), 2131690370, -1));
    this.qkg.setOnClickListener((View.OnClickListener)this);
    AppMethodBeat.o(75558);
  }
  
  public final void apt() {}
  
  public final boolean dia()
  {
    return false;
  }
  
  public final String name()
  {
    return "plugin_photo_crop";
  }
  
  public final void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(75556);
    d.b.a(this.vjo, d.c.voj);
    paramView = b.vpp;
    b.Ko(10);
    paramView = b.vpp;
    b.alO("KEY_CLICK_CROP_COUNT_INT");
    AppMethodBeat.o(75556);
  }
  
  public final void onDetach() {}
  
  public final void onPause() {}
  
  public final void onResume() {}
  
  public final void release() {}
  
  public final void reset() {}
  
  public final void setVisibility(int paramInt)
  {
    AppMethodBeat.i(75557);
    this.qkg.setVisibility(paramInt);
    AppMethodBeat.o(75557);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.recordvideo.plugin.l
 * JD-Core Version:    0.7.0.1
 */