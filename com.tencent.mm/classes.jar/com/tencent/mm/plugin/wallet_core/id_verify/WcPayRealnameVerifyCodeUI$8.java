package com.tencent.mm.plugin.wallet_core.id_verify;

import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.ui.base.l;
import com.tencent.mm.ui.base.n.d;
import com.tencent.mm.ui.widget.a.e;

final class WcPayRealnameVerifyCodeUI$8
  implements View.OnClickListener
{
  WcPayRealnameVerifyCodeUI$8(WcPayRealnameVerifyCodeUI paramWcPayRealnameVerifyCodeUI) {}
  
  public final void onClick(final View paramView)
  {
    AppMethodBeat.i(174466);
    Object localObject = new b();
    ((b)localObject).bd(paramView);
    a.b("com/tencent/mm/plugin/wallet_core/id_verify/WcPayRealnameVerifyCodeUI$8", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((b)localObject).ahq());
    ad.d("MicroMsg.WcPayRealNameVerifyCodeUI", "click verify code fail tv");
    paramView = new e(this.CRh.getContext(), 1, false);
    localObject = this.CRh.getLayoutInflater().inflate(2131496064, null);
    ((Button)((View)localObject).findViewById(2131300871)).setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(174464);
        b localb = new b();
        localb.bd(paramAnonymousView);
        a.b("com/tencent/mm/plugin/wallet_core/id_verify/WcPayRealnameVerifyCodeUI$8$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahq());
        paramView.bpT();
        a.a(this, "com/tencent/mm/plugin/wallet_core/id_verify/WcPayRealnameVerifyCodeUI$8$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(174464);
      }
    });
    paramView.KJy = new n.d()
    {
      public final void onCreateMMMenu(l paramAnonymousl)
      {
        AppMethodBeat.i(174465);
        paramAnonymousl.clear();
        paramView.setFooterView(null);
        paramView.setFooterView(this.CRj);
        AppMethodBeat.o(174465);
      }
    };
    paramView.fMc();
    paramView.cMW();
    a.a(this, "com/tencent/mm/plugin/wallet_core/id_verify/WcPayRealnameVerifyCodeUI$8", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(174466);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet_core.id_verify.WcPayRealnameVerifyCodeUI.8
 * JD-Core Version:    0.7.0.1
 */