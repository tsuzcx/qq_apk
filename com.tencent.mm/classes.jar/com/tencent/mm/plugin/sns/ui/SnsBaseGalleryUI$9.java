package com.tencent.mm.plugin.sns.ui;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.hellhoundlib.b.b;

final class SnsBaseGalleryUI$9
  implements View.OnClickListener
{
  SnsBaseGalleryUI$9(SnsBaseGalleryUI paramSnsBaseGalleryUI) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(212014);
    b localb = new b();
    localb.bn(paramView);
    a.c("com/tencent/mm/plugin/sns/ui/SnsBaseGalleryUI$5", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aFi());
    this.KOi.fVO();
    SnsBaseGalleryUI.d(this.KOi);
    a.a(this, "com/tencent/mm/plugin/sns/ui/SnsBaseGalleryUI$5", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(212014);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.SnsBaseGalleryUI.9
 * JD-Core Version:    0.7.0.1
 */