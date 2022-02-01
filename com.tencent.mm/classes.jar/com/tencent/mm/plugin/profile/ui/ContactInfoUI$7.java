package com.tencent.mm.plugin.profile.ui;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.sdk.platformtools.Log;

final class ContactInfoUI$7
  implements View.OnClickListener
{
  ContactInfoUI$7(ContactInfoUI paramContactInfoUI) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(305591);
    b localb = new b();
    localb.cH(paramView);
    a.c("com/tencent/mm/plugin/profile/ui/ContactInfoUI$15", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aYj());
    Log.i("MicroMsg.ContactInfoUI", "onClick: actionBarClick action_bar_root");
    ContactInfoUI.w(this.MVT);
    a.a(this, "com/tencent/mm/plugin/profile/ui/ContactInfoUI$15", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(305591);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.profile.ui.ContactInfoUI.7
 * JD-Core Version:    0.7.0.1
 */