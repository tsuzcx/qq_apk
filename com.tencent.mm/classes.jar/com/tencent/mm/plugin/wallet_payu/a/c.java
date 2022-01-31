package com.tencent.mm.plugin.wallet_payu.a;

import android.content.Context;
import android.content.Intent;
import android.text.SpannableString;
import android.text.method.LinkMovementMethod;
import android.view.View;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bq.d;
import com.tencent.mm.plugin.wallet_core.ui.j;
import com.tencent.mm.plugin.wallet_core.ui.j.a;
import com.tencent.mm.sdk.platformtools.ab;
import junit.framework.Assert;

public final class c
{
  public static void a(Context paramContext, TextView paramTextView)
  {
    AppMethodBeat.i(48412);
    if (paramTextView != null) {}
    for (boolean bool = true;; bool = false)
    {
      Assert.assertTrue(bool);
      j localj1 = new j(paramContext);
      localj1.uqj = new j.a()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(48410);
          ab.i("MicroMsg.PayUUtil", "hy: user clicked the span");
          paramAnonymousView = new Intent();
          paramAnonymousView.putExtra("rawUrl", "https://www.payu.co.za/wechat/terms-and-conditions/");
          paramAnonymousView.putExtra("showShare", false);
          d.b(this.val$context, "webview", ".ui.tools.WebViewUI", paramAnonymousView);
          AppMethodBeat.o(48410);
        }
      };
      j localj2 = new j(paramContext);
      localj2.uqj = new j.a()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(48411);
          ab.i("MicroMsg.PayUUtil", "hy: user clicked the tos span");
          paramAnonymousView = new Intent();
          paramAnonymousView.putExtra("rawUrl", "https://weixin.qq.com/cgi-bin/readtemplate?lang=en_US&check=false&t=weixin_agreement&s=terms");
          paramAnonymousView.putExtra("showShare", false);
          d.b(this.val$context, "webview", ".ui.tools.WebViewUI", paramAnonymousView);
          AppMethodBeat.o(48411);
        }
      };
      paramContext = paramContext.getText(2131305513).toString();
      SpannableString localSpannableString = new SpannableString(paramContext);
      localSpannableString.setSpan(localj1, 94, 115, 33);
      localSpannableString.setSpan(localj2, paramContext.length() - 3, paramContext.length(), 33);
      paramTextView.setText(localSpannableString);
      paramTextView.setMovementMethod(LinkMovementMethod.getInstance());
      AppMethodBeat.o(48412);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet_payu.a.c
 * JD-Core Version:    0.7.0.1
 */