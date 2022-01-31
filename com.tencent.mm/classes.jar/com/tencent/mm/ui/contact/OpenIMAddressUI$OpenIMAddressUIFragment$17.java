package com.tencent.mm.ui.contact;

import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class OpenIMAddressUI$OpenIMAddressUIFragment$17
  implements View.OnTouchListener
{
  OpenIMAddressUI$OpenIMAddressUIFragment$17(OpenIMAddressUI.OpenIMAddressUIFragment paramOpenIMAddressUIFragment) {}
  
  public final boolean onTouch(View paramView, MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(33782);
    switch (paramMotionEvent.getAction())
    {
    }
    for (;;)
    {
      AppMethodBeat.o(33782);
      return false;
      this.Aes.hideVKB();
      OpenIMAddressUI.OpenIMAddressUIFragment.a(this.Aes, (int)paramMotionEvent.getRawX());
      OpenIMAddressUI.OpenIMAddressUIFragment.b(this.Aes, (int)paramMotionEvent.getRawY());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.ui.contact.OpenIMAddressUI.OpenIMAddressUIFragment.17
 * JD-Core Version:    0.7.0.1
 */