package com.tencent.mm.ui.chatting.gallery;

import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.TextView;
import com.tencent.mm.R.a;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.s;

final class ImageGalleryGridUI$6$1
  implements Runnable
{
  ImageGalleryGridUI$6$1(ImageGalleryGridUI.6 param6) {}
  
  public final void run()
  {
    Animation localAnimation = AnimationUtils.loadAnimation(this.vuV.vuT.mController.uMN, R.a.fast_faded_out);
    ImageGalleryGridUI.b(this.vuV.vuT).startAnimation(localAnimation);
    ImageGalleryGridUI.b(this.vuV.vuT).setVisibility(8);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.gallery.ImageGalleryGridUI.6.1
 * JD-Core Version:    0.7.0.1
 */