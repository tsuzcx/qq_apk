package com.tencent.mm.plugin.profile.ui.tab;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.plugin.brandservice.api.c;
import com.tencent.mm.storage.ad;

final class ContactWidgetTabBizHeaderController$4
  implements View.OnClickListener
{
  ContactWidgetTabBizHeaderController$4(ContactWidgetTabBizHeaderController paramContactWidgetTabBizHeaderController, String paramString) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(305857);
    b localb = new b();
    localb.cH(paramView);
    a.c("com/tencent/mm/plugin/profile/ui/tab/ContactWidgetTabBizHeaderController$12", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aYj());
    int i = ad.getSessionId();
    int j = ((c)com.tencent.mm.kernel.h.ax(c.class)).aiE(ContactWidgetTabBizHeaderController.s(this.Ndz));
    ((c)com.tencent.mm.kernel.h.ax(c.class)).a(ContactWidgetTabBizHeaderController.a(this.Ndz), ContactWidgetTabBizHeaderController.s(this.Ndz), this.NdC, 8, j);
    com.tencent.mm.plugin.report.service.h.OAn.b(23044, new Object[] { Integer.valueOf(2), ContactWidgetTabBizHeaderController.s(this.Ndz), Integer.valueOf(ContactWidgetTabBizHeaderController.h(this.Ndz)), Integer.valueOf(i), this.NdC, Integer.valueOf(j), Integer.valueOf(1), "" });
    a.a(this, "com/tencent/mm/plugin/profile/ui/tab/ContactWidgetTabBizHeaderController$12", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(305857);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.profile.ui.tab.ContactWidgetTabBizHeaderController.4
 * JD-Core Version:    0.7.0.1
 */