package com.tencent.mm.plugin.subapp.ui.gallery;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.hellhoundlib.b.b;

final class GestureGalleryUI$15
  implements View.OnClickListener
{
  GestureGalleryUI$15(GestureGalleryUI paramGestureGalleryUI) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(292167);
    b localb = new b();
    localb.cH(paramView);
    a.c("com/tencent/mm/plugin/subapp/ui/gallery/GestureGalleryUI$23", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aYj());
    GestureGalleryUI.c(this.SHm);
    a.a(this, "com/tencent/mm/plugin/subapp/ui/gallery/GestureGalleryUI$23", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(292167);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.subapp.ui.gallery.GestureGalleryUI.15
 * JD-Core Version:    0.7.0.1
 */