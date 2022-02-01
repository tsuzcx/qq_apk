package com.tencent.mm.ui.contact;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.hellhoundlib.b.b;

final class ModRemarkNameUI$a
  implements View.OnClickListener
{
  private ModRemarkNameUI$a(ModRemarkNameUI paramModRemarkNameUI) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(37868);
    b localb = new b();
    localb.bn(paramView);
    a.c("com/tencent/mm/ui/contact/ModRemarkNameUI$LabelEditOnClickListener", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aFi());
    ModRemarkNameUI.k(this.Xug);
    a.a(this, "com/tencent/mm/ui/contact/ModRemarkNameUI$LabelEditOnClickListener", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(37868);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.ui.contact.ModRemarkNameUI.a
 * JD-Core Version:    0.7.0.1
 */