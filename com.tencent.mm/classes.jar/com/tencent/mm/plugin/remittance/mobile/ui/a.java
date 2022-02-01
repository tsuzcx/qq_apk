package com.tencent.mm.plugin.remittance.mobile.ui;

import android.content.Intent;
import android.view.View;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.br.d;
import com.tencent.mm.kernel.e;
import com.tencent.mm.plugin.remittance.mobile.a.b;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.storage.aj;
import com.tencent.mm.storage.am.a;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.al;
import com.tencent.mm.ui.widget.a.g.a;

public final class a
{
  public static void a(final MMActivity paramMMActivity, final boolean paramBoolean, final String paramString)
  {
    AppMethodBeat.i(189968);
    final com.tencent.mm.ui.widget.a.g localg = new com.tencent.mm.ui.widget.a.g(paramMMActivity, 1, 3);
    localg.c(paramMMActivity.getString(2131761279), paramMMActivity.getString(2131756354));
    View localView = View.inflate(paramMMActivity, 2131496512, null);
    Object localObject = (TextView)localView.findViewById(2131305902);
    al.a(((TextView)localObject).getPaint(), 0.8F);
    if (paramBoolean)
    {
      ((TextView)localObject).setText(2131756355);
      char[] arrayOfChar = paramString.toCharArray();
      paramString = "";
      int i = 0;
      while (i < arrayOfChar.length)
      {
        localObject = paramString;
        if (i % 4 == 0)
        {
          localObject = paramString;
          if (i > 0) {
            localObject = paramString + " ";
          }
        }
        paramString = (String)localObject + arrayOfChar[i];
        i += 1;
      }
      b.OD(4);
    }
    for (;;)
    {
      localObject = View.inflate(paramMMActivity, 2131496511, null);
      ((TextView)((View)localObject).findViewById(2131298739)).setText(paramString);
      localg.a(new g.a()new g.a
      {
        public final void onClick()
        {
          AppMethodBeat.i(189966);
          ae.i("MicroMsg.BankMobile.BankMobileShortCutView", "showBankMobileShortCutView click cancel!");
          this.ylm.bqD();
          if (paramBoolean)
          {
            b.OD(5);
            AppMethodBeat.o(189966);
            return;
          }
          b.OD(2);
          AppMethodBeat.o(189966);
        }
      }, new g.a()
      {
        public final void onClick()
        {
          AppMethodBeat.i(189967);
          ae.i("MicroMsg.BankMobile.BankMobileShortCutView", "showBankMobileShortCutView click confirm!");
          Intent localIntent = new Intent();
          if (this.yln)
          {
            localIntent.putExtra("key_content", paramString);
            d.b(paramMMActivity, "remittance", ".bankcard.ui.BankRemitBankcardInputUI", localIntent);
            b.OD(6);
            localg.bqD();
            AppMethodBeat.o(189967);
            return;
          }
          localIntent.putExtra("key_content", paramString);
          if (com.tencent.mm.kernel.g.ajR().ajA().getBoolean(am.a.JaH, true)) {
            d.b(paramMMActivity, "remittance", ".mobile.ui.MobileRemitWelcomeUI", localIntent);
          }
          for (;;)
          {
            b.OD(3);
            break;
            d.b(paramMMActivity, "remittance", ".mobile.ui.MobileRemitNumberInputUI", localIntent);
          }
        }
      });
      localg.setHeaderView(localView);
      localg.setCustomView((View)localObject);
      localg.cPF();
      AppMethodBeat.o(189968);
      return;
      ((TextView)localObject).setText(2131756356);
      b.OD(1);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.remittance.mobile.ui.a
 * JD-Core Version:    0.7.0.1
 */