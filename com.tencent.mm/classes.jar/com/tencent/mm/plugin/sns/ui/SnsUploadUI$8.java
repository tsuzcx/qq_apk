package com.tencent.mm.plugin.sns.ui;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.hellhoundlib.b.b;

final class SnsUploadUI$8
  implements View.OnClickListener
{
  SnsUploadUI$8(SnsUploadUI paramSnsUploadUI) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(369952);
    b localb = new b();
    localb.cH(paramView);
    a.c("com/tencent/mm/plugin/sns/ui/SnsUploadUI$16", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aYj());
    SnsUploadUI.N(this.REd);
    a.a(this, "com/tencent/mm/plugin/sns/ui/SnsUploadUI$16", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(369952);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.SnsUploadUI.8
 * JD-Core Version:    0.7.0.1
 */