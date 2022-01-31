package com.tencent.mm.ui.conversation.a;

import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.model.aw;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.ui.contact.SelectContactUI;
import com.tencent.mm.ui.contact.t;
import java.lang.ref.WeakReference;

final class f$1
  implements View.OnClickListener
{
  f$1(f paramf) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(34650);
    paramView = new Intent((Context)this.AmB.vUD.get(), SelectContactUI.class);
    paramView.putExtra("list_attr", t.hJ(t.AdS, 256));
    paramView.putExtra("list_type", 10);
    paramView.putExtra("received_card_name", this.AmB.zwh);
    paramView.putExtra("recommend_friends", true);
    paramView.putExtra("titile", ((Context)this.AmB.vUD.get()).getString(2131296502));
    ((Context)this.AmB.vUD.get()).startActivity(paramView);
    aw.aaz().YY().pS(this.AmB.zwh);
    aw.aaz().YY().pS(this.AmB.AmA);
    h.qsU.e(11003, new Object[] { this.AmB.zwh, Integer.valueOf(2), Integer.valueOf(0) });
    AppMethodBeat.o(34650);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.ui.conversation.a.f.1
 * JD-Core Version:    0.7.0.1
 */