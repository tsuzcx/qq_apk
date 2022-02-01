package com.tencent.mm.plugin.sns.ui;

import android.view.View;
import android.view.View.OnLongClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.hellhoundlib.b.b;

final class SnsUploadUI$2
  implements View.OnLongClickListener
{
  SnsUploadUI$2(SnsUploadUI paramSnsUploadUI) {}
  
  public final boolean onLongClick(View paramView)
  {
    AppMethodBeat.i(369959);
    b localb = new b();
    localb.cH(paramView);
    a.c("com/tencent/mm/plugin/sns/ui/SnsUploadUI$10", "android/view/View$OnLongClickListener", "onLongClick", "(Landroid/view/View;)Z", this, localb.aYj());
    SnsUploadUI.p(this.REd);
    a.a(false, this, "com/tencent/mm/plugin/sns/ui/SnsUploadUI$10", "android/view/View$OnLongClickListener", "onLongClick", "(Landroid/view/View;)Z");
    AppMethodBeat.o(369959);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.SnsUploadUI.2
 * JD-Core Version:    0.7.0.1
 */