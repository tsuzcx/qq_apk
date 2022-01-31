package com.tencent.mm.ui.chatting.gallery;

import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import com.tencent.mm.model.u;
import com.tencent.mm.model.u.b;

final class ImageGalleryUI$18
  implements View.OnTouchListener
{
  ImageGalleryUI$18(ImageGalleryUI paramImageGalleryUI) {}
  
  public final boolean onTouch(View paramView, MotionEvent paramMotionEvent)
  {
    switch (paramMotionEvent.getAction())
    {
    }
    for (;;)
    {
      return false;
      paramView = u.Hc().v("basescanui@datacenter", true);
      paramView.h("key_basescanui_screen_x", Integer.valueOf((int)paramMotionEvent.getRawX()));
      paramView.h("key_basescanui_screen_y", Integer.valueOf((int)paramMotionEvent.getRawY()));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.gallery.ImageGalleryUI.18
 * JD-Core Version:    0.7.0.1
 */