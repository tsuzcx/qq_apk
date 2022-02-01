package com.tencent.mm.ui.contact;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.br.c;
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.plugin.report.service.h;

final class SelectContactUI$24
  implements View.OnClickListener
{
  SelectContactUI$24(SelectContactUI paramSelectContactUI) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(37983);
    b localb = new b();
    localb.bm(paramView);
    a.b("com/tencent/mm/ui/contact/SelectContactUI$7", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.axR());
    h.CyF.a(11140, new Object[] { Integer.valueOf(0) });
    c.V(this.PZl, "pwdgroup", ".ui.FacingCreateChatRoomAllInOneUI");
    a.a(this, "com/tencent/mm/ui/contact/SelectContactUI$7", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(37983);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.ui.contact.SelectContactUI.24
 * JD-Core Version:    0.7.0.1
 */