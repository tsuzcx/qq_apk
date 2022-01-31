package com.tencent.mm.pluginsdk.ui;

import android.graphics.drawable.Drawable;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class MMPhoneNumberEditText$1
  implements View.OnTouchListener
{
  MMPhoneNumberEditText$1(MMPhoneNumberEditText paramMMPhoneNumberEditText) {}
  
  public final boolean onTouch(View paramView, MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(27491);
    paramView = this.vQZ;
    if (paramView.getCompoundDrawables()[2] == null)
    {
      AppMethodBeat.o(27491);
      return false;
    }
    if ((paramMotionEvent.getAction() == 1) && (paramMotionEvent.getX() > paramView.getWidth() - paramView.getPaddingRight() - this.vQZ.vQV.getIntrinsicWidth()))
    {
      if (!paramView.isFocused()) {
        break label90;
      }
      paramView.setText("");
      MMPhoneNumberEditText.a(paramView);
    }
    for (;;)
    {
      AppMethodBeat.o(27491);
      return false;
      label90:
      if (MMPhoneNumberEditText.b(this.vQZ) != null) {
        MMPhoneNumberEditText.b(this.vQZ).f(paramView);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.ui.MMPhoneNumberEditText.1
 * JD-Core Version:    0.7.0.1
 */