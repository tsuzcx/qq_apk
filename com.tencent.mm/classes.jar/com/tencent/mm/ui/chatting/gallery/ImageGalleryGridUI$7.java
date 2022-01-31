package com.tencent.mm.ui.chatting.gallery;

import android.animation.TimeInterpolator;
import android.os.Build.VERSION;
import android.view.View;
import android.view.ViewPropertyAnimator;
import com.tencent.mm.sdk.platformtools.ah;

final class ImageGalleryGridUI$7
  implements Runnable
{
  ImageGalleryGridUI$7(ImageGalleryGridUI paramImageGalleryGridUI, View paramView, TimeInterpolator paramTimeInterpolator) {}
  
  public final void run()
  {
    if (Build.VERSION.SDK_INT >= 16) {
      this.vuW.animate().setDuration(500L).alpha(0.0F).withEndAction(this.vuT.vuL).withLayer().setInterpolator(this.vuX);
    }
    while (this.vuT.handler == null) {
      return;
    }
    this.vuW.animate().setDuration(500L).alpha(0.0F).setInterpolator(this.vuX);
    this.vuT.handler.postDelayed(this.vuT.vuL, 500L);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.gallery.ImageGalleryGridUI.7
 * JD-Core Version:    0.7.0.1
 */