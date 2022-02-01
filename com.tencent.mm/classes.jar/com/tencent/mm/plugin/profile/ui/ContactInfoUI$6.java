package com.tencent.mm.plugin.profile.ui;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.sdk.platformtools.Log;

final class ContactInfoUI$6
  implements View.OnClickListener
{
  ContactInfoUI$6(ContactInfoUI paramContactInfoUI) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(305598);
    b localb = new b();
    localb.cH(paramView);
    a.c("com/tencent/mm/plugin/profile/ui/ContactInfoUI$14", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aYj());
    Log.i("MicroMsg.ContactInfoUI", "onClick: NormalProfileHeaderPreference");
    ContactInfoUI.w(this.MVT);
    a.a(this, "com/tencent/mm/plugin/profile/ui/ContactInfoUI$14", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(305598);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.profile.ui.ContactInfoUI.6
 * JD-Core Version:    0.7.0.1
 */