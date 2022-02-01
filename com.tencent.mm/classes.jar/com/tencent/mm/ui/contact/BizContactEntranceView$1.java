package com.tencent.mm.ui.contact;

import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.api.q;
import com.tencent.mm.by.c;
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.kernel.h;
import com.tencent.mm.sdk.platformtools.WeChatBrands.Business.Entries;

final class BizContactEntranceView$1
  implements View.OnClickListener
{
  BizContactEntranceView$1(BizContactEntranceView paramBizContactEntranceView) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(37657);
    Object localObject = new com.tencent.mm.hellhoundlib.b.b();
    ((com.tencent.mm.hellhoundlib.b.b)localObject).bn(paramView);
    a.c("com/tencent/mm/ui/contact/BizContactEntranceView$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).aFi());
    if (!WeChatBrands.Business.Entries.ContactOa.checkAvailable(paramView.getContext()))
    {
      a.a(this, "com/tencent/mm/ui/contact/BizContactEntranceView$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(37657);
      return;
    }
    if (((q)h.ae(q.class)).ZO())
    {
      ((com.tencent.mm.plugin.teenmode.a.b)h.ae(com.tencent.mm.plugin.teenmode.a.b.class)).ir(BizContactEntranceView.a(this.XqO));
      ((q)h.ae(q.class)).p(8, "");
      a.a(this, "com/tencent/mm/ui/contact/BizContactEntranceView$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(37657);
      return;
    }
    localObject = new Intent();
    ((Intent)localObject).putExtra("intent_service_type", 251658241);
    c.b(paramView.getContext(), "brandservice", ".ui.BrandServiceIndexUI", (Intent)localObject);
    a.a(this, "com/tencent/mm/ui/contact/BizContactEntranceView$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(37657);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.ui.contact.BizContactEntranceView.1
 * JD-Core Version:    0.7.0.1
 */