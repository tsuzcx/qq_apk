package com.tencent.mm.plugin.remittance.mobile.ui;

import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.br.d;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.remittance.mobile.a.b;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.storage.ae;
import com.tencent.mm.storage.ah.a;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.l;
import com.tencent.mm.ui.base.n.c;

public final class a
{
  public static void a(final MMActivity paramMMActivity, final boolean paramBoolean, final String paramString)
  {
    int i = 0;
    AppMethodBeat.i(67677);
    final com.tencent.mm.ui.widget.a.e locale = new com.tencent.mm.ui.widget.a.e(paramMMActivity, 1, false);
    final View localView = paramMMActivity.getLayoutInflater().inflate(2131493148, null);
    localView.findViewById(2131297123).setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(67674);
        ac.i("MicroMsg.BankMobile.BankMobileShortCutView", "showBankMobileShortCutView click cancel!");
        this.iEb.bmi();
        if (paramBoolean)
        {
          b.Mv(5);
          AppMethodBeat.o(67674);
          return;
        }
        b.Mv(2);
        AppMethodBeat.o(67674);
      }
    });
    if (paramBoolean)
    {
      ((TextView)localView.findViewById(2131305902)).setText(2131756355);
      char[] arrayOfChar = paramString.toCharArray();
      paramString = "";
      while (i < arrayOfChar.length)
      {
        String str = paramString;
        if (i % 4 == 0)
        {
          str = paramString;
          if (i > 0) {
            str = paramString + " ";
          }
        }
        paramString = str + arrayOfChar[i];
        i += 1;
      }
      b.Mv(4);
    }
    for (;;)
    {
      ((TextView)localView.findViewById(2131298739)).setText(paramString);
      localView.findViewById(2131297124).setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(67675);
          ac.i("MicroMsg.BankMobile.BankMobileShortCutView", "showBankMobileShortCutView click confirm!");
          paramAnonymousView = new Intent();
          if (this.wHM)
          {
            paramAnonymousView.putExtra("key_content", paramString);
            d.b(paramMMActivity, "remittance", ".bankcard.ui.BankRemitBankcardInputUI", paramAnonymousView);
            b.Mv(6);
            locale.bmi();
            AppMethodBeat.o(67675);
            return;
          }
          paramAnonymousView.putExtra("key_content", paramString);
          if (g.agR().agA().getBoolean(ah.a.GTC, true)) {
            d.b(paramMMActivity, "remittance", ".mobile.ui.MobileRemitWelcomeUI", paramAnonymousView);
          }
          for (;;)
          {
            b.Mv(3);
            break;
            d.b(paramMMActivity, "remittance", ".mobile.ui.MobileRemitNumberInputUI", paramAnonymousView);
          }
        }
      });
      locale.ISu = new n.c()
      {
        public final void onCreateMMMenu(l paramAnonymousl)
        {
          AppMethodBeat.i(67676);
          paramAnonymousl.clear();
          this.iEb.setFooterView(null);
          this.iEb.setFooterView(localView);
          AppMethodBeat.o(67676);
        }
      };
      locale.fvq();
      locale.cED();
      AppMethodBeat.o(67677);
      return;
      ((TextView)localView.findViewById(2131305902)).setText(2131756356);
      b.Mv(1);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.remittance.mobile.ui.a
 * JD-Core Version:    0.7.0.1
 */