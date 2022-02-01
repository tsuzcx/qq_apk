package com.tencent.mm.ui.contact;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.hellhoundlib.b.b;

final class ContactRemarkInfoModUI$a
  implements View.OnClickListener
{
  private ContactRemarkInfoModUI$a(ContactRemarkInfoModUI paramContactRemarkInfoModUI) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(37767);
    b localb = new b();
    localb.bm(paramView);
    a.b("com/tencent/mm/ui/contact/ContactRemarkInfoModUI$LabelEditOnClickListener", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.axR());
    ContactRemarkInfoModUI.c(this.PVk);
    a.a(this, "com/tencent/mm/ui/contact/ContactRemarkInfoModUI$LabelEditOnClickListener", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(37767);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.ui.contact.ContactRemarkInfoModUI.a
 * JD-Core Version:    0.7.0.1
 */