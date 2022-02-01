package com.tencent.mm.ui.chatting.gallery;

import android.animation.TimeInterpolator;
import android.os.Build.VERSION;
import android.view.View;
import android.view.ViewPropertyAnimator;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ap;

final class ImageGalleryGridUI$7
  implements Runnable
{
  ImageGalleryGridUI$7(ImageGalleryGridUI paramImageGalleryGridUI, View paramView, TimeInterpolator paramTimeInterpolator) {}
  
  public final void run()
  {
    AppMethodBeat.i(35960);
    if (Build.VERSION.SDK_INT >= 16)
    {
      this.GBq.animate().setDuration(500L).alpha(0.0F).withEndAction(this.GBn.GBf).withLayer().setInterpolator(this.GBr);
      AppMethodBeat.o(35960);
      return;
    }
    if (this.GBn.handler == null)
    {
      AppMethodBeat.o(35960);
      return;
    }
    this.GBq.animate().setDuration(500L).alpha(0.0F).setInterpolator(this.GBr);
    this.GBn.handler.postDelayed(this.GBn.GBf, 500L);
    AppMethodBeat.o(35960);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.gallery.ImageGalleryGridUI.7
 * JD-Core Version:    0.7.0.1
 */