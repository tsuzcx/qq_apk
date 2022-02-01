package com.tencent.mm.plugin.wallet_payu.a;

import android.content.Context;
import android.text.SpannableString;
import android.text.method.LinkMovementMethod;
import android.view.View;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.wallet_core.ui.l;
import com.tencent.mm.plugin.wallet_core.ui.l.a;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.wallet_core.ui.f;
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
      l locall1 = new l(paramContext);
      locall1.Dxw = new l.a()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(72051);
          ae.i("MicroMsg.PayUUtil", "hy: user clicked the span");
          f.aY(this.val$context, "https://www.payu.co.za/wechat/terms-and-conditions/");
          AppMethodBeat.o(72051);
        }
      };
      l locall2 = new l(paramContext);
      locall2.Dxw = new l.a()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(72052);
          ae.i("MicroMsg.PayUUtil", "hy: user clicked the tos span");
          f.aY(this.val$context, "https://weixin.qq.com/cgi-bin/readtemplate?lang=en_US&check=false&t=weixin_agreement&s=terms");
          AppMethodBeat.o(72052);
        }
      };
      paramContext = paramContext.getText(2131765728).toString();
      SpannableString localSpannableString = new SpannableString(paramContext);
      localSpannableString.setSpan(locall1, 94, 115, 33);
      localSpannableString.setSpan(locall2, paramContext.length() - 3, paramContext.length(), 33);
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