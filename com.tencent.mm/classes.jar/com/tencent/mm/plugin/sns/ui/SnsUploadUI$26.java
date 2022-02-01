package com.tencent.mm.plugin.sns.ui;

import android.view.View;
import android.view.View.OnLongClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.hellhoundlib.b.b;

final class SnsUploadUI$26
  implements View.OnLongClickListener
{
  SnsUploadUI$26(SnsUploadUI paramSnsUploadUI) {}
  
  public final boolean onLongClick(View paramView)
  {
    AppMethodBeat.i(176384);
    b localb = new b();
    localb.bn(paramView);
    a.c("com/tencent/mm/plugin/sns/ui/SnsUploadUI$9", "android/view/View$OnLongClickListener", "onLongClick", "(Landroid/view/View;)Z", this, localb.aFi());
    SnsUploadUI.p(this.LdU);
    a.a(false, this, "com/tencent/mm/plugin/sns/ui/SnsUploadUI$9", "android/view/View$OnLongClickListener", "onLongClick", "(Landroid/view/View;)Z");
    AppMethodBeat.o(176384);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.SnsUploadUI.26
 * JD-Core Version:    0.7.0.1
 */