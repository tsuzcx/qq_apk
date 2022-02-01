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
    ((b)localObject).bn(paramView);
    com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/ui/contact/SelectContactUI$6", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((b)localObject).aFi());
    localObject = new Intent();
    ((Intent)localObject).setClassName(this.Xwj, "com.tencent.mm.ui.contact.GroupCardSelectUI");
    ((Intent)localObject).putExtra("group_select_type", true);
    boolean bool = w.hasAttr(SelectContactUI.n(this.Xwj), 16384);
    ((Intent)localObject).putExtra("group_select_need_result", bool);
    if (bool) {
      if (SelectContactUI.o(this.Xwj) == 14)
      {
        ((Intent)localObject).putExtra("group_multi_select", true);
        ((Intent)localObject).putExtra("already_select_contact", Util.listToString(SelectContactUI.p(this.Xwj), ","));
        ((Intent)localObject).putExtra("max_limit_num", this.Xwj.getIntent().getIntExtra("max_limit_num", 9));
        this.Xwj.startActivityForResult((Intent)localObject, 4);
      }
    }
    for (;;)
    {
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/ui/contact/SelectContactUI$6", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(37982);
      return;
      this.Xwj.startActivityForResult((Intent)localObject, 0);
      continue;
      paramView = this.Xwj;
      localObject = new com.tencent.mm.hellhoundlib.b.a().bm(localObject);
      com.tencent.mm.hellhoundlib.a.a.b(paramView, ((com.tencent.mm.hellhoundlib.b.a)localObject).aFh(), "com/tencent/mm/ui/contact/SelectContactUI$6", "onClick", "(Landroid/view/View;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      paramView.startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject).sf(0));
      com.tencent.mm.hellhoundlib.a.a.c(paramView, "com/tencent/mm/ui/contact/SelectContactUI$6", "onClick", "(Landroid/view/View;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.ui.contact.SelectContactUI.23
 * JD-Core Version:    0.7.0.1
 */