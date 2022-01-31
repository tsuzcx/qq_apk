package com.tencent.mm.ui.contact;

import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;

final class AddressUI$a$4
  implements View.OnTouchListener
{
  AddressUI$a$4(AddressUI.a parama) {}
  
  public final boolean onTouch(View paramView, MotionEvent paramMotionEvent)
  {
    switch (paramMotionEvent.getAction())
    {
    }
    for (;;)
    {
      return false;
      this.vJs.hideVKB();
      AddressUI.a.a(this.vJs, (int)paramMotionEvent.getRawX());
      AddressUI.a.b(this.vJs, (int)paramMotionEvent.getRawY());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.ui.contact.AddressUI.a.4
 * JD-Core Version:    0.7.0.1
 */