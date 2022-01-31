package com.tencent.mm.ui.chatting.gallery;

import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ui.base.MultiTouchImageView;
import com.tencent.mm.ui.base.WxImageView;
import com.tencent.mm.ui.base.g;

final class ImageGalleryUI$7$1
  implements Runnable
{
  ImageGalleryUI$7$1(ImageGalleryUI.7 param7) {}
  
  public final void run()
  {
    AppMethodBeat.i(153862);
    View localView = ImageGalleryUI.a(this.zMH.zME, ImageGalleryUI.j(this.zMH.zME), this.zMH.zME.nga);
    if ((localView != null) && ((localView instanceof g)))
    {
      if ((localView instanceof MultiTouchImageView))
      {
        ((MultiTouchImageView)localView).dDJ();
        AppMethodBeat.o(153862);
        return;
      }
      if ((localView instanceof WxImageView)) {
        ((WxImageView)localView).dDJ();
      }
    }
    AppMethodBeat.o(153862);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.gallery.ImageGalleryUI.7.1
 * JD-Core Version:    0.7.0.1
 */