package com.tencent.mm.plugin.subapp.ui.gallery;

import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.cg;
import com.tencent.mm.sdk.b.a;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.ui.widget.b.d;

final class GestureGalleryUI$3
  implements View.OnClickListener
{
  GestureGalleryUI$3(GestureGalleryUI paramGestureGalleryUI) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(153671);
    ab.i("MicroMsg.GestureGalleryUI", "request deal QBAR string");
    if (GestureGalleryUI.i(this.sYB).isShowing()) {
      GestureGalleryUI.i(this.sYB).cre();
    }
    paramView = new cg();
    paramView.cpD.activity = this.sYB;
    paramView.cpD.cnR = GestureGalleryUI.m(this.sYB);
    paramView.cpD.cpE = GestureGalleryUI.o(this.sYB);
    paramView.cpD.cpF = GestureGalleryUI.p(this.sYB);
    paramView.cpD.scene = GestureGalleryUI.q(this.sYB);
    paramView.cpD.cpJ = this.sYB.getIntent().getBundleExtra("_stat_obj");
    a.ymk.l(paramView);
    AppMethodBeat.o(153671);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.subapp.ui.gallery.GestureGalleryUI.3
 * JD-Core Version:    0.7.0.1
 */