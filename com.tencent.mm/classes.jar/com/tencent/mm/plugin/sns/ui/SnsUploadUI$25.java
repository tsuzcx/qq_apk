package com.tencent.mm.plugin.sns.ui;

import android.view.View;
import android.view.View.OnLongClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.hellhoundlib.b.b;

final class SnsUploadUI$25
  implements View.OnLongClickListener
{
  SnsUploadUI$25(SnsUploadUI paramSnsUploadUI) {}
  
  public final boolean onLongClick(View paramView)
  {
    AppMethodBeat.i(176384);
    b localb = new b();
    localb.bm(paramView);
    a.b("com/tencent/mm/plugin/sns/ui/SnsUploadUI$9", "android/view/View$OnLongClickListener", "onLongClick", "(Landroid/view/View;)Z", this, localb.axR());
    SnsUploadUI.p(this.EPZ);
    a.a(false, this, "com/tencent/mm/plugin/sns/ui/SnsUploadUI$9", "android/view/View$OnLongClickListener", "onLongClick", "(Landroid/view/View;)Z");
    AppMethodBeat.o(176384);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.SnsUploadUI.25
 * JD-Core Version:    0.7.0.1
 */