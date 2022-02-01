package com.tencent.mm.plugin.subapp.ui.gallery;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.hellhoundlib.b.b;

final class GestureGalleryUI$18
  implements View.OnClickListener
{
  GestureGalleryUI$18(GestureGalleryUI paramGestureGalleryUI)
  {
    AppMethodBeat.i(161448);
    AppMethodBeat.o(161448);
  }
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(186657);
    b localb = new b();
    localb.bd(paramView);
    a.b("com/tencent/mm/plugin/subapp/ui/gallery/GestureGalleryUI$27", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahF());
    GestureGalleryUI.Z(this.BBc);
    a.a(this, "com/tencent/mm/plugin/subapp/ui/gallery/GestureGalleryUI$27", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(186657);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.subapp.ui.gallery.GestureGalleryUI.18
 * JD-Core Version:    0.7.0.1
 */