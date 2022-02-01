package com.tencent.mm.plugin.subapp.ui.gallery;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.hellhoundlib.b.b;

final class GestureGalleryUI$13
  implements View.OnClickListener
{
  GestureGalleryUI$13(GestureGalleryUI paramGestureGalleryUI) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(179710);
    b localb = new b();
    localb.bd(paramView);
    a.b("com/tencent/mm/plugin/subapp/ui/gallery/GestureGalleryUI$22", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahq());
    GestureGalleryUI.b(this.BjD);
    a.a(this, "com/tencent/mm/plugin/subapp/ui/gallery/GestureGalleryUI$22", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(179710);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.subapp.ui.gallery.GestureGalleryUI.13
 * JD-Core Version:    0.7.0.1
 */