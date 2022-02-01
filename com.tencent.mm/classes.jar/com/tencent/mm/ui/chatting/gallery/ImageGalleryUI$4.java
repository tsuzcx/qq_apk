package com.tencent.mm.ui.chatting.gallery;

import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.model.y;
import com.tencent.mm.model.y.b;

final class ImageGalleryUI$4
  implements View.OnTouchListener
{
  ImageGalleryUI$4(ImageGalleryUI paramImageGalleryUI) {}
  
  public final boolean onTouch(View paramView, MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(196554);
    switch (paramMotionEvent.getAction())
    {
    }
    for (;;)
    {
      AppMethodBeat.o(196554);
      return false;
      paramView = y.ayq().F("basescanui@datacenter", true);
      paramView.l("key_basescanui_screen_x", Integer.valueOf((int)paramMotionEvent.getRawX()));
      paramView.l("key_basescanui_screen_y", Integer.valueOf((int)paramMotionEvent.getRawY()));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.gallery.ImageGalleryUI.4
 * JD-Core Version:    0.7.0.1
 */