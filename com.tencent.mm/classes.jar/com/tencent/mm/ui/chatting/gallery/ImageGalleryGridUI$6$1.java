package com.tencent.mm.ui.chatting.gallery;

import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class ImageGalleryGridUI$6$1
  implements Runnable
{
  ImageGalleryGridUI$6$1(ImageGalleryGridUI.6 param6) {}
  
  public final void run()
  {
    AppMethodBeat.i(32040);
    Animation localAnimation = AnimationUtils.loadAnimation(this.zKW.zKU.getContext(), 2131034182);
    ImageGalleryGridUI.b(this.zKW.zKU).startAnimation(localAnimation);
    ImageGalleryGridUI.b(this.zKW.zKU).setVisibility(8);
    AppMethodBeat.o(32040);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.gallery.ImageGalleryGridUI.6.1
 * JD-Core Version:    0.7.0.1
 */