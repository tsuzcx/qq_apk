package com.tencent.mm.ui.contact;

import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.br.c;
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.sdk.platformtools.WeChatBrands.Business.Entries;

final class SelectContactUI$26
  implements View.OnClickListener
{
  SelectContactUI$26(SelectContactUI paramSelectContactUI) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(234041);
    b localb = new b();
    localb.bm(paramView);
    a.b("com/tencent/mm/ui/contact/SelectContactUI$9", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.axR());
    if (!WeChatBrands.Business.Entries.ContactOa.checkAvailable(paramView.getContext()))
    {
      a.a(this, "com/tencent/mm/ui/contact/SelectContactUI$9", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(234041);
      return;
    }
    paramView = new Intent();
    paramView.putExtra("list_attr", 16384);
    c.b(this.PZl, "brandservice", ".ui.BrandServiceIndexUI", paramView, 2);
    a.a(this, "com/tencent/mm/ui/contact/SelectContactUI$9", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(234041);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.ui.contact.SelectContactUI.26
 * JD-Core Version:    0.7.0.1
 */