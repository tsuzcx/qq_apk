package com.tencent.mm.ui.contact;

import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.platformtools.WeChatBrands.Business.Entries;
import com.tencent.mm.storage.as;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

final class SelectContactUI$4
  implements View.OnClickListener
{
  SelectContactUI$4(SelectContactUI paramSelectContactUI) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(234022);
    Object localObject = new b();
    ((b)localObject).bm(paramView);
    a.b("com/tencent/mm/ui/contact/SelectContactUI$12", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((b)localObject).axR());
    if (!WeChatBrands.Business.Entries.ContactWeCom.checkAvailable(paramView.getContext()))
    {
      a.a(this, "com/tencent/mm/ui/contact/SelectContactUI$12", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(234022);
      return;
    }
    paramView = new Intent(this.PZl.getIntent());
    paramView.setClass(this.PZl.getContext(), OpenIMSelectContactUI.class);
    paramView.removeExtra("titile");
    paramView.putExtra("openim_appid", "3552365301");
    localObject = new ArrayList();
    Iterator localIterator = SelectContactUI.q(this.PZl).iterator();
    while (localIterator.hasNext())
    {
      String str = (String)localIterator.next();
      if (as.bjp(str)) {
        ((ArrayList)localObject).add(str);
      }
    }
    paramView.putExtra("already_select_contact", Util.listToString((List)localObject, ","));
    this.PZl.startActivityForResult(paramView, 5);
    a.a(this, "com/tencent/mm/ui/contact/SelectContactUI$12", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(234022);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.ui.contact.SelectContactUI.4
 * JD-Core Version:    0.7.0.1
 */