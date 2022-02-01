package com.tencent.mm.plugin.remittance.mobile.ui;

import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bs.d;
import com.tencent.mm.kernel.g;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.storage.ai;
import com.tencent.mm.storage.al.a;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.l;
import com.tencent.mm.ui.base.n.d;

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
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.bd(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/remittance/mobile/ui/BankMobileShortCutView$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahq());
        ad.i("MicroMsg.BankMobile.BankMobileShortCutView", "showBankMobileShortCutView click cancel!");
        this.fPn.bpT();
        if (paramBoolean) {
          com.tencent.mm.plugin.remittance.mobile.a.b.NX(5);
        }
        for (;;)
        {
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/remittance/mobile/ui/BankMobileShortCutView$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(67674);
          return;
          com.tencent.mm.plugin.remittance.mobile.a.b.NX(2);
        }
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
      com.tencent.mm.plugin.remittance.mobile.a.b.NX(4);
    }
    for (;;)
    {
      ((TextView)localView.findViewById(2131298739)).setText(paramString);
      localView.findViewById(2131297124).setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(67675);
          com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
          localb.bd(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/remittance/mobile/ui/BankMobileShortCutView$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahq());
          ad.i("MicroMsg.BankMobile.BankMobileShortCutView", "showBankMobileShortCutView click confirm!");
          paramAnonymousView = new Intent();
          if (this.xVt)
          {
            paramAnonymousView.putExtra("key_content", paramString);
            d.b(paramMMActivity, "remittance", ".bankcard.ui.BankRemitBankcardInputUI", paramAnonymousView);
            com.tencent.mm.plugin.remittance.mobile.a.b.NX(6);
            locale.bpT();
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/remittance/mobile/ui/BankMobileShortCutView$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(67675);
            return;
          }
          paramAnonymousView.putExtra("key_content", paramString);
          if (g.ajC().ajl().getBoolean(al.a.IGh, true)) {
            d.b(paramMMActivity, "remittance", ".mobile.ui.MobileRemitWelcomeUI", paramAnonymousView);
          }
          for (;;)
          {
            com.tencent.mm.plugin.remittance.mobile.a.b.NX(3);
            break;
            d.b(paramMMActivity, "remittance", ".mobile.ui.MobileRemitNumberInputUI", paramAnonymousView);
          }
        }
      });
      locale.KJy = new n.d()
      {
        public final void onCreateMMMenu(l paramAnonymousl)
        {
          AppMethodBeat.i(67676);
          paramAnonymousl.clear();
          this.fPn.setFooterView(null);
          this.fPn.setFooterView(localView);
          AppMethodBeat.o(67676);
        }
      };
      locale.fMc();
      locale.cMW();
      AppMethodBeat.o(67677);
      return;
      ((TextView)localView.findViewById(2131305902)).setText(2131756356);
      com.tencent.mm.plugin.remittance.mobile.a.b.NX(1);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.remittance.mobile.ui.a
 * JD-Core Version:    0.7.0.1
 */