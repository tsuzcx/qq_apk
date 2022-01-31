package com.tencent.mm.ui.contact;

import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import com.tencent.mm.ui.MMActivity;

final class BizContactEntranceView$2
  implements View.OnTouchListener
{
  BizContactEntranceView$2(BizContactEntranceView paramBizContactEntranceView) {}
  
  public final boolean onTouch(View paramView, MotionEvent paramMotionEvent)
  {
    if ((BizContactEntranceView.a(this.vJY) instanceof MMActivity)) {
      ((MMActivity)BizContactEntranceView.a(this.vJY)).XM();
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.ui.contact.BizContactEntranceView.2
 * JD-Core Version:    0.7.0.1
 */