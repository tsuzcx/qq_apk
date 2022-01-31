package com.tencent.mm.ui.base;

import android.content.Context;
import android.widget.Button;
import android.widget.TextView;
import com.tencent.mm.ac.a.k;
import com.tencent.mm.sdk.platformtools.am;
import com.tencent.mm.sdk.platformtools.am.a;

final class MMFormVerifyCodeInputView$3
  implements am.a
{
  MMFormVerifyCodeInputView$3(MMFormVerifyCodeInputView paramMMFormVerifyCodeInputView) {}
  
  public final boolean tC()
  {
    MMFormVerifyCodeInputView.f(this.uVg);
    MMFormVerifyCodeInputView.h(this.uVg).setText(this.uVg.getContext().getString(a.k.mobile_input_send_sms_timer_title, new Object[] { Integer.valueOf(MMFormVerifyCodeInputView.g(this.uVg)) }));
    if (MMFormVerifyCodeInputView.g(this.uVg) == 0)
    {
      MMFormVerifyCodeInputView.i(this.uVg).stopTimer();
      MMFormVerifyCodeInputView.a(this.uVg, MMFormVerifyCodeInputView.j(this.uVg));
      MMFormVerifyCodeInputView.k(this.uVg).setVisibility(0);
      MMFormVerifyCodeInputView.h(this.uVg).setVisibility(8);
    }
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.ui.base.MMFormVerifyCodeInputView.3
 * JD-Core Version:    0.7.0.1
 */