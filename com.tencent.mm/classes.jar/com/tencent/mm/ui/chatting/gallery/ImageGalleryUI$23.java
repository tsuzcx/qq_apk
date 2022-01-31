package com.tencent.mm.ui.chatting.gallery;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.ap;
import com.tencent.mm.sdk.b.a;

final class ImageGalleryUI$23
  implements View.OnClickListener
{
  ImageGalleryUI$23(ImageGalleryUI paramImageGalleryUI) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(153884);
    paramView = new ap();
    paramView.cnT.scene = 1;
    paramView.cnT.cnU = ImageGalleryUI.h(this.zME);
    a.ymk.l(paramView);
    ImageGalleryUI.g(this.zME);
    ImageGalleryUI.i(this.zME);
    AppMethodBeat.o(153884);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.gallery.ImageGalleryUI.23
 * JD-Core Version:    0.7.0.1
 */