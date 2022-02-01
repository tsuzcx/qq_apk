package com.tencent.mm.ui.contact;

import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.sdk.platformtools.Util;

final class SelectContactUI$23
  implements View.OnClickListener
{
  SelectContactUI$23(SelectContactUI paramSelectContactUI) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(37982);
    Object localObject = new b();
    ((b)localObject).bm(paramView);
    com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/ui/contact/SelectContactUI$6", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((b)localObject).axR());
    localObject = new Intent();
    ((Intent)localObject).setClassName(this.PZl, "com.tencent.mm.ui.contact.GroupCardSelectUI");
    ((Intent)localObject).putExtra("group_select_type", true);
    boolean bool = u.hasAttr(SelectContactUI.n(this.PZl), 16384);
    ((Intent)localObject).putExtra("group_select_need_result", bool);
    if (bool) {
      if (SelectContactUI.o(this.PZl) == 14)
      {
        ((Intent)localObject).putExtra("group_multi_select", true);
        ((Intent)localObject).putExtra("already_select_contact", Util.listToString(SelectContactUI.p(this.PZl), ","));
        ((Intent)localObject).putExtra("max_limit_num", this.PZl.getIntent().getIntExtra("max_limit_num", 9));
        this.PZl.startActivityForResult((Intent)localObject, 4);
      }
    }
    for (;;)
    {
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/ui/contact/SelectContactUI$6", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(37982);
      return;
      this.PZl.startActivityForResult((Intent)localObject, 0);
      continue;
      paramView = this.PZl;
      localObject = new com.tencent.mm.hellhoundlib.b.a().bl(localObject);
      com.tencent.mm.hellhoundlib.a.a.a(paramView, ((com.tencent.mm.hellhoundlib.b.a)localObject).axQ(), "com/tencent/mm/ui/contact/SelectContactUI$6", "onClick", "(Landroid/view/View;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      paramView.startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject).pG(0));
      com.tencent.mm.hellhoundlib.a.a.a(paramView, "com/tencent/mm/ui/contact/SelectContactUI$6", "onClick", "(Landroid/view/View;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.ui.contact.SelectContactUI.23
 * JD-Core Version:    0.7.0.1
 */