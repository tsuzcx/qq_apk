package com.tencent.mm.plugin.remittance.mobile.ui;

import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bs.d;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.remittance.mobile.a.b;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.storage.ab;
import com.tencent.mm.storage.ae.a;
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
        ad.i("MicroMsg.BankMobile.BankMobileShortCutView", "showBankMobileShortCutView click cancel!");
        this.idS.bfo();
        if (paramBoolean)
        {
          b.Kw(5);
          AppMethodBeat.o(67674);
          return;
        }
        b.Kw(2);
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
      b.Kw(4);
    }
    for (;;)
    {
      ((TextView)localView.findViewById(2131298739)).setText(paramString);
      localView.findViewById(2131297124).setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(67675);
          ad.i("MicroMsg.BankMobile.BankMobileShortCutView", "showBankMobileShortCutView click confirm!");
          paramAnonymousView = new Intent();
          if (this.vxH)
          {
            paramAnonymousView.putExtra("key_content", paramString);
            d.b(paramMMActivity, "remittance", ".bankcard.ui.BankRemitBankcardInputUI", paramAnonymousView);
            b.Kw(6);
            locale.bfo();
            AppMethodBeat.o(67675);
            return;
          }
          paramAnonymousView.putExtra("key_content", paramString);
          if (g.afB().afk().getBoolean(ae.a.FvI, true)) {
            d.b(paramMMActivity, "remittance", ".mobile.ui.MobileRemitWelcomeUI", paramAnonymousView);
          }
          for (;;)
          {
            b.Kw(3);
            break;
            d.b(paramMMActivity, "remittance", ".mobile.ui.MobileRemitNumberInputUI", paramAnonymousView);
          }
        }
      });
      locale.HrX = new n.c()
      {
        public final void onCreateMMMenu(l paramAnonymousl)
        {
          AppMethodBeat.i(67676);
          paramAnonymousl.clear();
          this.idS.setFooterView(null);
          this.idS.setFooterView(localView);
          AppMethodBeat.o(67676);
        }
      };
      locale.ffu();
      locale.csG();
      AppMethodBeat.o(67677);
      return;
      ((TextView)localView.findViewById(2131305902)).setText(2131756356);
      b.Kw(1);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.remittance.mobile.ui.a
 * JD-Core Version:    0.7.0.1
 */