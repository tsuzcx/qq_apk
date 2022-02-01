package com.tencent.mm.ui.transmit;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.hellhoundlib.b.b;

final class ShareImageSelectorUI$1
  implements View.OnClickListener
{
  ShareImageSelectorUI$1(ShareImageSelectorUI paramShareImageSelectorUI) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(39454);
    b localb = new b();
    localb.bn(paramView);
    a.c("com/tencent/mm/ui/transmit/ShareImageSelectorUI$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aFi());
    ShareImageSelectorUI.a(this.XYR);
    a.a(this, "com/tencent/mm/ui/transmit/ShareImageSelectorUI$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(39454);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.ui.transmit.ShareImageSelectorUI.1
 * JD-Core Version:    0.7.0.1
 */