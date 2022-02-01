package com.tencent.mm.plugin.vlog.ui.plugin;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.plugin.recordvideo.plugin.parent.d;
import com.tencent.mm.plugin.recordvideo.plugin.parent.d.c;
import com.tencent.mm.plugin.recordvideo.plugin.t;
import com.tencent.mm.plugin.recordvideo.plugin.t.a;
import com.tencent.mm.ui.ao;
import d.g.b.p;
import d.l;

@l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/vlog/ui/plugin/VLogCropVideoPlugin;", "Lcom/tencent/mm/plugin/recordvideo/plugin/IBaseRecordPlugin;", "layout", "Landroid/view/View;", "status", "Lcom/tencent/mm/plugin/recordvideo/plugin/parent/IRecordStatus;", "(Landroid/view/View;Lcom/tencent/mm/plugin/recordvideo/plugin/parent/IRecordStatus;)V", "cropBtn", "Landroid/widget/ImageView;", "getLayout", "()Landroid/view/View;", "getStatus", "()Lcom/tencent/mm/plugin/recordvideo/plugin/parent/IRecordStatus;", "setVisibility", "", "visibility", "", "plugin-vlog_release"})
public final class ab
  implements t
{
  private final View rY;
  final d sQE;
  private final ImageView xCr;
  
  public ab(View paramView, d paramd)
  {
    AppMethodBeat.i(196393);
    this.rY = paramView;
    this.sQE = paramd;
    paramView = this.rY.findViewById(2131299289);
    p.g(paramView, "layout.findViewById(R.id.editor_crop_video)");
    this.xCr = ((ImageView)paramView);
    this.xCr.setImageDrawable(ao.k(this.rY.getContext(), 2131690382, -1));
    this.xCr.setOnClickListener((View.OnClickListener)new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(196391);
        b localb = new b();
        localb.bd(paramAnonymousView);
        a.b("com/tencent/mm/plugin/vlog/ui/plugin/VLogCropVideoPlugin$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahq());
        paramAnonymousView = new Bundle();
        this.BOB.sQE.a(d.c.xEO, paramAnonymousView);
        a.a(this, "com/tencent/mm/plugin/vlog/ui/plugin/VLogCropVideoPlugin$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(196391);
      }
    });
    AppMethodBeat.o(196393);
  }
  
  public final boolean aoB()
  {
    return false;
  }
  
  public final void ayX() {}
  
  public final String name()
  {
    return null;
  }
  
  public final void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent) {}
  
  public final void onDetach() {}
  
  public final void onPause() {}
  
  public final void onRequestPermissionsResult(int paramInt, String[] paramArrayOfString, int[] paramArrayOfInt)
  {
    AppMethodBeat.i(196394);
    p.h(paramArrayOfString, "permissions");
    p.h(paramArrayOfInt, "grantResults");
    t.a.a(paramArrayOfString, paramArrayOfInt);
    AppMethodBeat.o(196394);
  }
  
  public final void onResume() {}
  
  public final void release() {}
  
  public final void reset() {}
  
  public final void setVisibility(int paramInt)
  {
    AppMethodBeat.i(196392);
    this.xCr.setVisibility(paramInt);
    AppMethodBeat.o(196392);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.vlog.ui.plugin.ab
 * JD-Core Version:    0.7.0.1
 */