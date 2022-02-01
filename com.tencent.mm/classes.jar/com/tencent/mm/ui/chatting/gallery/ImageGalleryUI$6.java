package com.tencent.mm.ui.chatting.gallery;

import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.model.z;
import com.tencent.mm.model.z.b;

final class ImageGalleryUI$6
  implements View.OnTouchListener
{
  ImageGalleryUI$6(ImageGalleryUI paramImageGalleryUI) {}
  
  public final boolean onTouch(View paramView, MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(187495);
    b localb = new b();
    localb.bd(paramView);
    localb.bd(paramMotionEvent);
    a.b("com/tencent/mm/ui/chatting/gallery/ImageGalleryUI$14", "android/view/View$OnTouchListener", "onTouch", "(Landroid/view/View;Landroid/view/MotionEvent;)Z", this, localb.ahF());
    switch (paramMotionEvent.getAction())
    {
    }
    for (;;)
    {
      a.a(false, this, "com/tencent/mm/ui/chatting/gallery/ImageGalleryUI$14", "android/view/View$OnTouchListener", "onTouch", "(Landroid/view/View;Landroid/view/MotionEvent;)Z");
      AppMethodBeat.o(187495);
      return false;
      paramView = z.aBG().F("basescanui@datacenter", true);
      paramView.k("key_basescanui_screen_x", Integer.valueOf((int)paramMotionEvent.getRawX()));
      paramView.k("key_basescanui_screen_y", Integer.valueOf((int)paramMotionEvent.getRawY()));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.gallery.ImageGalleryUI.6
 * JD-Core Version:    0.7.0.1
 */