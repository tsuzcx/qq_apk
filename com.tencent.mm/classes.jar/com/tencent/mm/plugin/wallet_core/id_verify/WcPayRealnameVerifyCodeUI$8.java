package com.tencent.mm.plugin.wallet_core.id_verify;

import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.plugin.wxpay.a.f;
import com.tencent.mm.plugin.wxpay.a.g;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.ui.base.s;
import com.tencent.mm.ui.base.u.g;
import com.tencent.mm.ui.widget.a.f;

final class WcPayRealnameVerifyCodeUI$8
  implements View.OnClickListener
{
  WcPayRealnameVerifyCodeUI$8(WcPayRealnameVerifyCodeUI paramWcPayRealnameVerifyCodeUI) {}
  
  public final void onClick(final View paramView)
  {
    AppMethodBeat.i(174466);
    Object localObject = new b();
    ((b)localObject).cH(paramView);
    a.c("com/tencent/mm/plugin/wallet_core/id_verify/WcPayRealnameVerifyCodeUI$8", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((b)localObject).aYj());
    Log.d("MicroMsg.WcPayRealNameVerifyCodeUI", "click verify code fail tv");
    paramView = new f(this.VzX.getContext(), 1, false);
    localObject = this.VzX.getLayoutInflater().inflate(a.g.wc_pay_realname_verify_code_fail_dialog, null);
    ((Button)((View)localObject).findViewById(a.f.i_know_btn)).setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(174464);
        b localb = new b();
        localb.cH(paramAnonymousView);
        a.c("com/tencent/mm/plugin/wallet_core/id_verify/WcPayRealnameVerifyCodeUI$8$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aYj());
        paramView.cyW();
        a.a(this, "com/tencent/mm/plugin/wallet_core/id_verify/WcPayRealnameVerifyCodeUI$8$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(174464);
      }
    });
    paramView.Vtg = new u.g()
    {
      public final void onCreateMMMenu(s paramAnonymouss)
      {
        AppMethodBeat.i(174465);
        paramAnonymouss.clear();
        paramView.setFooterView(null);
        paramView.setFooterView(this.VzZ);
        AppMethodBeat.o(174465);
      }
    };
    paramView.uR(true);
    paramView.dDn();
    a.a(this, "com/tencent/mm/plugin/wallet_core/id_verify/WcPayRealnameVerifyCodeUI$8", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(174466);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet_core.id_verify.WcPayRealnameVerifyCodeUI.8
 * JD-Core Version:    0.7.0.1
 */