package com.tencent.mm.ui.contact;

import android.text.Editable;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.EditText;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.hellhoundlib.b.b;

final class ModRemarkNameUI$6
  implements View.OnClickListener
{
  ModRemarkNameUI$6(ModRemarkNameUI paramModRemarkNameUI) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(293336);
    b localb = new b();
    localb.bn(paramView);
    a.c("com/tencent/mm/ui/contact/ModRemarkNameUI$6", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aFi());
    ModRemarkNameUI.g(this.Xug).setVisibility(0);
    ModRemarkNameUI.h(this.Xug).setVisibility(8);
    ModRemarkNameUI.j(this.Xug).requestFocus();
    ModRemarkNameUI.j(this.Xug).setSelection(ModRemarkNameUI.j(this.Xug).getText().length());
    this.Xug.showVKB();
    a.a(this, "com/tencent/mm/ui/contact/ModRemarkNameUI$6", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(293336);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.ui.contact.ModRemarkNameUI.6
 * JD-Core Version:    0.7.0.1
 */