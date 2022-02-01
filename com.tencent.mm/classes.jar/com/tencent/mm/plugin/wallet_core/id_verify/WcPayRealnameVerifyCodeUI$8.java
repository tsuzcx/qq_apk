package com.tencent.mm.plugin.wallet_core.id_verify;

import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.ui.base.m;
import com.tencent.mm.ui.base.o.f;
import com.tencent.mm.ui.widget.a.e;

final class WcPayRealnameVerifyCodeUI$8
  implements View.OnClickListener
{
  WcPayRealnameVerifyCodeUI$8(WcPayRealnameVerifyCodeUI paramWcPayRealnameVerifyCodeUI) {}
  
  public final void onClick(final View paramView)
  {
    AppMethodBeat.i(174466);
    Object localObject = new b();
    ((b)localObject).bm(paramView);
    a.b("com/tencent/mm/plugin/wallet_core/id_verify/WcPayRealnameVerifyCodeUI$8", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((b)localObject).axR());
    Log.d("MicroMsg.WcPayRealNameVerifyCodeUI", "click verify code fail tv");
    paramView = new e(this.HSe.getContext(), 1, false);
    localObject = this.HSe.getLayoutInflater().inflate(2131497044, null);
    ((Button)((View)localObject).findViewById(2131302465)).setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(174464);
        b localb = new b();
        localb.bm(paramAnonymousView);
        a.b("com/tencent/mm/plugin/wallet_core/id_verify/WcPayRealnameVerifyCodeUI$8$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.axR());
        paramView.bMo();
        a.a(this, "com/tencent/mm/plugin/wallet_core/id_verify/WcPayRealnameVerifyCodeUI$8$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(174464);
      }
    });
    paramView.HLX = new o.f()
    {
      public final void onCreateMMMenu(m paramAnonymousm)
      {
        AppMethodBeat.i(174465);
        paramAnonymousm.clear();
        paramView.setFooterView(null);
        paramView.setFooterView(this.HSg);
        AppMethodBeat.o(174465);
      }
    };
    paramView.Dm(true);
    paramView.dGm();
    a.a(this, "com/tencent/mm/plugin/wallet_core/id_verify/WcPayRealnameVerifyCodeUI$8", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(174466);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet_core.id_verify.WcPayRealnameVerifyCodeUI.8
 * JD-Core Version:    0.7.0.1
 */