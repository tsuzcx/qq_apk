package com.tencent.mm.wallet_core.keyboard;

import android.view.KeyEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.EditText;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.bo;

final class WcPayKeyboard$1
  implements View.OnClickListener
{
  WcPayKeyboard$1(WcPayKeyboard paramWcPayKeyboard) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(49014);
    if (WcPayKeyboard.a(this.AVV) == null)
    {
      AppMethodBeat.o(49014);
      return;
    }
    int i;
    if (paramView.getId() == 2131829489) {
      i = 7;
    }
    for (;;)
    {
      if (!bo.hl(i, 0)) {
        paramView.performHapticFeedback(0, 2);
      }
      WcPayKeyboard.a(this.AVV).dispatchKeyEvent(new KeyEvent(0, i));
      WcPayKeyboard.a(this.AVV).dispatchKeyEvent(new KeyEvent(1, i));
      AppMethodBeat.o(49014);
      return;
      if (paramView.getId() == 2131829478) {
        i = 8;
      } else if (paramView.getId() == 2131829479) {
        i = 9;
      } else if (paramView.getId() == 2131829480) {
        i = 10;
      } else if (paramView.getId() == 2131829482) {
        i = 11;
      } else if (paramView.getId() == 2131829483) {
        i = 12;
      } else if (paramView.getId() == 2131829484) {
        i = 13;
      } else if (paramView.getId() == 2131829486) {
        i = 14;
      } else if (paramView.getId() == 2131829487) {
        i = 15;
      } else if (paramView.getId() == 2131829488) {
        i = 16;
      } else if (paramView.getId() == 2131829481) {
        i = 67;
      } else if (paramView.getId() == 2131829490) {
        i = 56;
      } else if ((paramView.getId() == 2131829485) || (paramView.getId() == 2131829491)) {
        i = 66;
      } else {
        i = 0;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.wallet_core.keyboard.WcPayKeyboard.1
 * JD-Core Version:    0.7.0.1
 */