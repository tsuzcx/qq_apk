package com.tencent.mm.plugin.profile.ui;

import android.content.Intent;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.kernel.h;
import com.tencent.mm.plugin.textstatus.a.f;
import com.tencent.mm.sdk.platformtools.Log;

final class ContactInfoUI$8
  implements View.OnClickListener
{
  ContactInfoUI$8(ContactInfoUI paramContactInfoUI) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(305589);
    b localb = new b();
    localb.cH(paramView);
    com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/profile/ui/ContactInfoUI$16", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aYj());
    Log.i("MicroMsg.ContactInfoUI", "onClick: actionBarClick action_bar_root2");
    if (TextUtils.equals(this.MVT.getIntent().getStringExtra("Contact_User"), com.tencent.mm.plugin.auth.a.a.cUx())) {
      ((f)h.az(f.class)).goUnReadMsgPage(this.MVT);
    }
    com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/profile/ui/ContactInfoUI$16", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(305589);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.profile.ui.ContactInfoUI.8
 * JD-Core Version:    0.7.0.1
 */