package com.tencent.mm.plugin.wallet_payu.a;

import android.content.Context;
import android.text.SpannableString;
import android.text.method.LinkMovementMethod;
import android.view.View;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.wallet_core.ui.n;
import com.tencent.mm.plugin.wallet_core.ui.n.a;
import com.tencent.mm.plugin.wxpay.a.i;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.wallet_core.ui.i;
import junit.framework.Assert;

public final class c
{
  public static void a(Context paramContext, TextView paramTextView)
  {
    AppMethodBeat.i(72053);
    if (paramTextView != null) {}
    for (boolean bool = true;; bool = false)
    {
      Assert.assertTrue(bool);
      n localn1 = new n(paramContext);
      localn1.VPb = new n.a()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(72051);
          Log.i("MicroMsg.PayUUtil", "hy: user clicked the span");
          i.bC(c.this, "https://www.payu.co.za/wechat/terms-and-conditions/");
          AppMethodBeat.o(72051);
        }
      };
      n localn2 = new n(paramContext);
      localn2.VPb = new n.a()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(72052);
          Log.i("MicroMsg.PayUUtil", "hy: user clicked the tos span");
          i.bC(c.this, com.tencent.mm.pluginsdk.wallet.c.YvO);
          AppMethodBeat.o(72052);
        }
      };
      paramContext = paramContext.getText(a.i.wallet_payu_start_introduction).toString();
      SpannableString localSpannableString = new SpannableString(paramContext);
      localSpannableString.setSpan(localn1, 94, 115, 33);
      localSpannableString.setSpan(localn2, paramContext.length() - 3, paramContext.length(), 33);
      paramTextView.setText(localSpannableString);
      paramTextView.setMovementMethod(LinkMovementMethod.getInstance());
      AppMethodBeat.o(72053);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet_payu.a.c
 * JD-Core Version:    0.7.0.1
 */