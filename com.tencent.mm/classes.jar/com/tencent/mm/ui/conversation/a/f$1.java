package com.tencent.mm.ui.conversation.a;

import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mm.R.l;
import com.tencent.mm.model.au;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.ui.contact.SelectContactUI;
import com.tencent.mm.ui.contact.s;
import java.lang.ref.WeakReference;

final class f$1
  implements View.OnClickListener
{
  f$1(f paramf) {}
  
  public final void onClick(View paramView)
  {
    paramView = new Intent((Context)this.vUE.sdy.get(), SelectContactUI.class);
    paramView.putExtra("list_attr", s.fB(s.vMq, 256));
    paramView.putExtra("list_type", 10);
    paramView.putExtra("received_card_name", this.vUE.vUC);
    paramView.putExtra("recommend_friends", true);
    paramView.putExtra("titile", ((Context)this.vUE.sdy.get()).getString(R.l.address_title_select_contact));
    ((Context)this.vUE.sdy.get()).startActivity(paramView);
    au.Hx().FX().je(this.vUE.vUC);
    au.Hx().FX().je(this.vUE.vUD);
    h.nFQ.f(11003, new Object[] { this.vUE.vUC, Integer.valueOf(2), Integer.valueOf(0) });
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.ui.conversation.a.f.1
 * JD-Core Version:    0.7.0.1
 */