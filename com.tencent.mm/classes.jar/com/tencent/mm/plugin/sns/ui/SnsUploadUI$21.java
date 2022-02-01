package com.tencent.mm.plugin.sns.ui;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.hellhoundlib.b.b;

final class SnsUploadUI$21
  implements View.OnClickListener
{
  SnsUploadUI$21(SnsUploadUI paramSnsUploadUI) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(176383);
    b localb = new b();
    localb.bd(paramView);
    a.b("com/tencent/mm/plugin/sns/ui/SnsUploadUI$8", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahF());
    SnsUploadUI.p(this.AGr);
    a.a(this, "com/tencent/mm/plugin/sns/ui/SnsUploadUI$8", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(176383);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.SnsUploadUI.21
 * JD-Core Version:    0.7.0.1
 */