package com.tencent.mm.pluginsdk.ui;

import android.graphics.drawable.Drawable;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;

final class MMPhoneNumberEditText$1
  implements View.OnTouchListener
{
  MMPhoneNumberEditText$1(MMPhoneNumberEditText paramMMPhoneNumberEditText) {}
  
  public final boolean onTouch(View paramView, MotionEvent paramMotionEvent)
  {
    paramView = this.saj;
    if (paramView.getCompoundDrawables()[2] == null) {}
    do
    {
      do
      {
        return false;
      } while ((paramMotionEvent.getAction() != 1) || (paramMotionEvent.getX() <= paramView.getWidth() - paramView.getPaddingRight() - this.saj.saf.getIntrinsicWidth()));
      if (paramView.isFocused())
      {
        paramView.setText("");
        MMPhoneNumberEditText.a(paramView);
        return false;
      }
    } while (MMPhoneNumberEditText.b(this.saj) == null);
    MMPhoneNumberEditText.b(this.saj).f(paramView);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.ui.MMPhoneNumberEditText.1
 * JD-Core Version:    0.7.0.1
 */