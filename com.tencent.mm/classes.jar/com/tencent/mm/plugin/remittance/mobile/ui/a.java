package com.tencent.mm.plugin.remittance.mobile.ui;

import android.content.Intent;
import android.view.View;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.by.c;
import com.tencent.mm.kernel.f;
import com.tencent.mm.kernel.h;
import com.tencent.mm.plugin.remittance.mobile.a.b;
import com.tencent.mm.plugin.wxpay.a.f;
import com.tencent.mm.plugin.wxpay.a.g;
import com.tencent.mm.plugin.wxpay.a.i;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.storage.ao;
import com.tencent.mm.storage.ar.a;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.ar;
import com.tencent.mm.ui.widget.a.g;
import com.tencent.mm.ui.widget.a.g.a;

public final class a
{
  public static void a(final MMActivity paramMMActivity, final boolean paramBoolean, final String paramString)
  {
    AppMethodBeat.i(187636);
    final g localg = new g(paramMMActivity, 1, 3);
    localg.d(paramMMActivity.getString(a.i.mobile_remit_number_input_cancel), paramMMActivity.getString(a.i.bank_mobile_remit_dialog_ok));
    View localView = View.inflate(paramMMActivity, a.g.bank_mobile_remit_short_cut_dialog_title, null);
    Object localObject = (TextView)localView.findViewById(a.f.title);
    ar.a(((TextView)localObject).getPaint(), 0.8F);
    if (paramBoolean)
    {
      ((TextView)localObject).setText(a.i.bank_mobile_remit_dialog_title_bank);
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
      b.acM(4);
    }
    for (;;)
    {
      localObject = View.inflate(paramMMActivity, a.g.bank_mobile_remit_short_cut_dialog_content, null);
      ((TextView)((View)localObject).findViewById(a.f.content)).setText(paramString);
      localg.a(new g.a()new g.a
      {
        public final void onClick()
        {
          AppMethodBeat.i(201146);
          Log.i("MicroMsg.BankMobile.BankMobileShortCutView", "showBankMobileShortCutView click cancel!");
          this.Ijf.bYF();
          if (paramBoolean)
          {
            b.acM(5);
            AppMethodBeat.o(201146);
            return;
          }
          b.acM(2);
          AppMethodBeat.o(201146);
        }
      }, new g.a()
      {
        public final void onClick()
        {
          AppMethodBeat.i(193716);
          Log.i("MicroMsg.BankMobile.BankMobileShortCutView", "showBankMobileShortCutView click confirm!");
          Intent localIntent = new Intent();
          if (this.Ijg)
          {
            localIntent.putExtra("key_content", paramString);
            c.b(paramMMActivity, "remittance", ".bankcard.ui.BankRemitBankcardInputUI", localIntent);
            b.acM(6);
            localg.bYF();
            AppMethodBeat.o(193716);
            return;
          }
          localIntent.putExtra("key_content", paramString);
          if (h.aHG().aHp().getBoolean(ar.a.VxD, true)) {
            c.b(paramMMActivity, "remittance", ".mobile.ui.MobileRemitWelcomeUI", localIntent);
          }
          for (;;)
          {
            b.acM(3);
            break;
            c.b(paramMMActivity, "remittance", ".mobile.ui.MobileRemitNumberInputUI", localIntent);
          }
        }
      });
      localg.setHeaderView(localView);
      localg.setCustomView((View)localObject);
      localg.eik();
      AppMethodBeat.o(187636);
      return;
      ((TextView)localObject).setText(a.i.bank_mobile_remit_dialog_title_mobile);
      b.acM(1);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.remittance.mobile.ui.a
 * JD-Core Version:    0.7.0.1
 */