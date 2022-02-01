package com.tencent.mm.ui.chatting.gallery;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.pluginsdk.ui.tools.j;

final class i$1
  implements View.OnClickListener
{
  i$1(i parami, k paramk) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(36089);
    com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
    localb.bm(paramView);
    a.b("com/tencent/mm/ui/chatting/gallery/ImageGallerySightHandler$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.axR());
    this.PwL.gTd().PAG.E(this.Pyv.Pwu.Pwv.getContext(), true);
    a.a(this, "com/tencent/mm/ui/chatting/gallery/ImageGallerySightHandler$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(36089);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.gallery.i.1
 * JD-Core Version:    0.7.0.1
 */