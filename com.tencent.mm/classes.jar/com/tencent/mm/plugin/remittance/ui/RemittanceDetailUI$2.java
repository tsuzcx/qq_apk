package com.tencent.mm.plugin.remittance.ui;

import android.text.SpannableString;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.order.c.a.a;
import com.tencent.mm.plugin.remittance.model.x;
import com.tencent.mm.plugin.remittance.model.x.a;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.ui.tools.o;

final class RemittanceDetailUI$2
  implements Runnable
{
  RemittanceDetailUI$2(RemittanceDetailUI paramRemittanceDetailUI, x paramx) {}
  
  public final void run()
  {
    AppMethodBeat.i(44997);
    int i = RemittanceResultNewUI.m(this.qpY, this.qqb.qkB.fBq, RemittanceDetailUI.j(this.qpY).getWidth());
    if (!bo.hl(i, this.qqb.qkB.fBq.length()))
    {
      String str1 = this.qpY.getString(2131296829);
      String str2 = this.qqb.qkB.fBq.substring(0, i) + "... ";
      SpannableString localSpannableString = new SpannableString(str2 + str1);
      com.tencent.mm.plugin.order.c.a locala = new com.tencent.mm.plugin.order.c.a(this.qpY);
      locala.prW = new a.a()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(44995);
          RemittanceDetailUI.k(RemittanceDetailUI.2.this.qpY).setVisibility(8);
          RemittanceDetailUI.l(RemittanceDetailUI.2.this.qpY).setVisibility(0);
          o.a(RemittanceDetailUI.2.this.qpY, (ScrollView)RemittanceDetailUI.2.this.qpY.findViewById(2131820898), RemittanceDetailUI.2.this.qpY.findViewById(2131827243), RemittanceDetailUI.2.this.qpY.findViewById(2131827247), RemittanceDetailUI.2.this.qpY.findViewById(2131827281));
          AppMethodBeat.o(44995);
        }
      };
      localSpannableString.setSpan(locala, str2.length(), str2.length() + str1.length(), 33);
      RemittanceDetailUI.k(this.qpY).setOnTouchListener(a.cgY());
      RemittanceDetailUI.k(this.qpY).setText(localSpannableString);
      str1 = this.qpY.getString(2131296825);
      str2 = this.qqb.qkB.fBq + "  ";
      localSpannableString = new SpannableString(str2 + str1);
      locala = new com.tencent.mm.plugin.order.c.a(this.qpY);
      locala.prW = new RemittanceDetailUI.2.2(this);
      i = str2.length();
      int j = str2.length();
      localSpannableString.setSpan(locala, i, str1.length() + j, 33);
      RemittanceDetailUI.l(this.qpY).setOnTouchListener(a.cgY());
      RemittanceDetailUI.l(this.qpY).setText(localSpannableString);
    }
    for (;;)
    {
      RemittanceDetailUI.k(this.qpY).setVisibility(0);
      RemittanceDetailUI.l(this.qpY).setVisibility(8);
      RemittanceDetailUI.m(this.qpY).setOnLongClickListener(RemittanceDetailUI.g(this.qpY));
      RemittanceDetailUI.m(this.qpY).setOnTouchListener(RemittanceDetailUI.i(this.qpY));
      AppMethodBeat.o(44997);
      return;
      RemittanceDetailUI.k(this.qpY).setText(this.qqb.qkB.fBq);
      RemittanceDetailUI.l(this.qpY).setText(this.qqb.qkB.fBq);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.remittance.ui.RemittanceDetailUI.2
 * JD-Core Version:    0.7.0.1
 */