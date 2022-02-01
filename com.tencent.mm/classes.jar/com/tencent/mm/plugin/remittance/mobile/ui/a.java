package com.tencent.mm.plugin.remittance.mobile.ui;

import android.content.Intent;
import android.view.View;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.br.c;
import com.tencent.mm.kernel.e;
import com.tencent.mm.plugin.remittance.mobile.a.b;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.storage.ar.a;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.widget.a.g.a;

public final class a
{
  public static void a(final MMActivity paramMMActivity, final boolean paramBoolean, final String paramString)
  {
    AppMethodBeat.i(213712);
    final com.tencent.mm.ui.widget.a.g localg = new com.tencent.mm.ui.widget.a.g(paramMMActivity, 1, 3);
    localg.b(paramMMActivity.getString(2131763105), paramMMActivity.getString(2131756489));
    View localView = View.inflate(paramMMActivity, 2131493193, null);
    Object localObject = (TextView)localView.findViewById(2131309195);
    com.tencent.mm.ui.ao.a(((TextView)localObject).getPaint(), 0.8F);
    if (paramBoolean)
    {
      ((TextView)localObject).setText(2131756490);
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
      b.VY(4);
    }
    for (;;)
    {
      localObject = View.inflate(paramMMActivity, 2131493192, null);
      ((TextView)((View)localObject).findViewById(2131299180)).setText(paramString);
      localg.a(new g.a()new g.a
      {
        public final void onClick()
        {
          AppMethodBeat.i(213710);
          Log.i("MicroMsg.BankMobile.BankMobileShortCutView", "showBankMobileShortCutView click cancel!");
          this.Cmm.bMo();
          if (paramBoolean)
          {
            b.VY(5);
            AppMethodBeat.o(213710);
            return;
          }
          b.VY(2);
          AppMethodBeat.o(213710);
        }
      }, new g.a()
      {
        public final void onClick()
        {
          AppMethodBeat.i(213711);
          Log.i("MicroMsg.BankMobile.BankMobileShortCutView", "showBankMobileShortCutView click confirm!");
          Intent localIntent = new Intent();
          if (this.Cmn)
          {
            localIntent.putExtra("key_content", paramString);
            c.b(paramMMActivity, "remittance", ".bankcard.ui.BankRemitBankcardInputUI", localIntent);
            b.VY(6);
            localg.bMo();
            AppMethodBeat.o(213711);
            return;
          }
          localIntent.putExtra("key_content", paramString);
          if (com.tencent.mm.kernel.g.aAh().azQ().getBoolean(ar.a.Ojn, true)) {
            c.b(paramMMActivity, "remittance", ".mobile.ui.MobileRemitWelcomeUI", localIntent);
          }
          for (;;)
          {
            b.VY(3);
            break;
            c.b(paramMMActivity, "remittance", ".mobile.ui.MobileRemitNumberInputUI", localIntent);
          }
        }
      });
      localg.setHeaderView(localView);
      localg.setCustomView((View)localObject);
      localg.dGm();
      AppMethodBeat.o(213712);
      return;
      ((TextView)localObject).setText(2131756491);
      b.VY(1);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.remittance.mobile.ui.a
 * JD-Core Version:    0.7.0.1
 */