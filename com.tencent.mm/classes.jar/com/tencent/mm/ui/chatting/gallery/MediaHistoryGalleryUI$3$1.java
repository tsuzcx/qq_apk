package com.tencent.mm.ui.chatting.gallery;

import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.TextView;
import com.tencent.mm.R.a;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.s;

final class MediaHistoryGalleryUI$3$1
  implements Runnable
{
  MediaHistoryGalleryUI$3$1(MediaHistoryGalleryUI.3 param3) {}
  
  public final void run()
  {
    Animation localAnimation = AnimationUtils.loadAnimation(this.vxL.vxK.mController.uMN, R.a.fast_faded_out);
    MediaHistoryGalleryUI.b(this.vxL.vxK).startAnimation(localAnimation);
    MediaHistoryGalleryUI.b(this.vxL.vxK).setVisibility(8);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.gallery.MediaHistoryGalleryUI.3.1
 * JD-Core Version:    0.7.0.1
 */