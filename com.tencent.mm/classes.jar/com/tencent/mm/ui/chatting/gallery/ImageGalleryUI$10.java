package com.tencent.mm.ui.chatting.gallery;

import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.cg;
import com.tencent.mm.sdk.b.a;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.ui.widget.b.d;

final class ImageGalleryUI$10
  implements View.OnClickListener
{
  ImageGalleryUI$10(ImageGalleryUI paramImageGalleryUI)
  {
    AppMethodBeat.i(32206);
    AppMethodBeat.o(32206);
  }
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(153868);
    ab.i("MicroMsg.ImageGalleryUI", "request deal QBAR string");
    if (ImageGalleryUI.a(this.zME).isShowing()) {
      ImageGalleryUI.a(this.zME).cre();
    }
    paramView = new cg();
    paramView.cpD.activity = this.zME;
    paramView.cpD.cnR = ImageGalleryUI.c(this.zME);
    paramView.cpD.cpE = ImageGalleryUI.B(this.zME);
    paramView.cpD.cpF = ImageGalleryUI.C(this.zME);
    paramView.cpD.scene = 37;
    paramView.cpD.cpJ = this.zME.getIntent().getBundleExtra("_stat_obj");
    ImageGalleryUI.a(this.zME, paramView);
    ImageGalleryUI.b(this.zME, paramView);
    a.ymk.l(paramView);
    AppMethodBeat.o(153868);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.gallery.ImageGalleryUI.10
 * JD-Core Version:    0.7.0.1
 */