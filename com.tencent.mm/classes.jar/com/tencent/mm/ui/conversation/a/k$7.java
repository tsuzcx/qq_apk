package com.tencent.mm.ui.conversation.a;

import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mm.br.d;
import com.tencent.mm.model.bc;
import com.tencent.mm.model.q;
import com.tencent.mm.plugin.report.service.h;
import java.lang.ref.WeakReference;

final class k$7
  implements View.OnClickListener
{
  k$7(k paramk, int paramInt1, int paramInt2) {}
  
  public final void onClick(View paramView)
  {
    bc.HI().bi(this.bns, this.uJr);
    paramView = (Context)this.vUP.sdy.get();
    int i;
    if ((q.Gu() & 0x10000) == 0)
    {
      i = 1;
      if (i == 0) {
        break label85;
      }
      d.x(paramView, "masssend", ".ui.MassSendHistoryUI");
    }
    for (;;)
    {
      h.nFQ.f(11002, new Object[] { Integer.valueOf(11), Integer.valueOf(1) });
      return;
      i = 0;
      break;
      label85:
      d.b(paramView, "profile", ".ui.ContactInfoUI", new Intent().putExtra("Contact_User", "masssendapp"));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.ui.conversation.a.k.7
 * JD-Core Version:    0.7.0.1
 */