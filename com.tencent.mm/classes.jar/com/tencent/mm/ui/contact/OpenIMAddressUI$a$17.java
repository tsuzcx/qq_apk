package com.tencent.mm.ui.contact;

import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;

final class OpenIMAddressUI$a$17
  implements View.OnTouchListener
{
  OpenIMAddressUI$a$17(OpenIMAddressUI.a parama) {}
  
  public final boolean onTouch(View paramView, MotionEvent paramMotionEvent)
  {
    switch (paramMotionEvent.getAction())
    {
    }
    for (;;)
    {
      return false;
      this.vMP.hideVKB();
      OpenIMAddressUI.a.a(this.vMP, (int)paramMotionEvent.getRawX());
      OpenIMAddressUI.a.b(this.vMP, (int)paramMotionEvent.getRawY());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.ui.contact.OpenIMAddressUI.a.17
 * JD-Core Version:    0.7.0.1
 */