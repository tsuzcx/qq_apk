package com.tencent.mm.ui.contact;

import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.br.c;
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.hellhoundlib.b.b;

final class k$1
  implements View.OnClickListener
{
  k$1(k paramk) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(37827);
    Object localObject = new b();
    ((b)localObject).bm(paramView);
    a.b("com/tencent/mm/ui/contact/EnterpriseBizViewItem$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((b)localObject).axR());
    localObject = new Intent();
    ((Intent)localObject).putExtra("enterprise_from_scene", 2);
    ((Intent)localObject).putExtra("enterprise_biz_name", k.a(this.PVC));
    c.b(paramView.getContext(), "brandservice", ".ui.EnterpriseBizContactListUI", (Intent)localObject);
    a.a(this, "com/tencent/mm/ui/contact/EnterpriseBizViewItem$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(37827);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.ui.contact.k.1
 * JD-Core Version:    0.7.0.1
 */