package com.tencent.mm.plugin.sns.ui;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.hellhoundlib.b.b;

final class SnsUploadUI$7
  implements View.OnClickListener
{
  SnsUploadUI$7(SnsUploadUI paramSnsUploadUI) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(176368);
    b localb = new b();
    localb.bd(paramView);
    a.b("com/tencent/mm/plugin/sns/ui/SnsUploadUI$15", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahF());
    SnsUploadUI.M(this.AGr);
    a.a(this, "com/tencent/mm/plugin/sns/ui/SnsUploadUI$15", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(176368);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.SnsUploadUI.7
 * JD-Core Version:    0.7.0.1
 */