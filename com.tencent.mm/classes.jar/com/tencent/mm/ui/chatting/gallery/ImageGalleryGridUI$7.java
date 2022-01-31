package com.tencent.mm.ui.chatting.gallery;

import android.animation.TimeInterpolator;
import android.os.Build.VERSION;
import android.view.View;
import android.view.ViewPropertyAnimator;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ak;

final class ImageGalleryGridUI$7
  implements Runnable
{
  ImageGalleryGridUI$7(ImageGalleryGridUI paramImageGalleryGridUI, View paramView, TimeInterpolator paramTimeInterpolator) {}
  
  public final void run()
  {
    AppMethodBeat.i(32045);
    if (Build.VERSION.SDK_INT >= 16)
    {
      this.zKX.animate().setDuration(500L).alpha(0.0F).withEndAction(this.zKU.zKM).withLayer().setInterpolator(this.zKY);
      AppMethodBeat.o(32045);
      return;
    }
    if (this.zKU.handler == null)
    {
      AppMethodBeat.o(32045);
      return;
    }
    this.zKX.animate().setDuration(500L).alpha(0.0F).setInterpolator(this.zKY);
    this.zKU.handler.postDelayed(this.zKU.zKM, 500L);
    AppMethodBeat.o(32045);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.gallery.ImageGalleryGridUI.7
 * JD-Core Version:    0.7.0.1
 */