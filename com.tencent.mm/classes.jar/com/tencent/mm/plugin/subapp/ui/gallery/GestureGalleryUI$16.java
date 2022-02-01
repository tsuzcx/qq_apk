package com.tencent.mm.plugin.subapp.ui.gallery;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.hellhoundlib.b.b;

final class GestureGalleryUI$16
  implements View.OnClickListener
{
  GestureGalleryUI$16(GestureGalleryUI paramGestureGalleryUI) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(292153);
    b localb = new b();
    localb.cH(paramView);
    a.c("com/tencent/mm/plugin/subapp/ui/gallery/GestureGalleryUI$24", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aYj());
    GestureGalleryUI.f(this.SHm, 4);
    GestureGalleryUI.w(this.SHm);
    a.a(this, "com/tencent/mm/plugin/subapp/ui/gallery/GestureGalleryUI$24", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(292153);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.subapp.ui.gallery.GestureGalleryUI.16
 * JD-Core Version:    0.7.0.1
 */