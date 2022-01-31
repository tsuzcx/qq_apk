package com.tencent.mm.ui.conversation;

import android.annotation.TargetApi;
import android.graphics.drawable.Drawable;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import com.tencent.mm.R.h;

final class h$3
  implements View.OnTouchListener
{
  h$3(h paramh) {}
  
  @TargetApi(21)
  public final boolean onTouch(View paramView, MotionEvent paramMotionEvent)
  {
    paramView.findViewById(R.h.conversation_item_ll).getBackground().setHotspot(paramMotionEvent.getX(), paramMotionEvent.getY());
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.ui.conversation.h.3
 * JD-Core Version:    0.7.0.1
 */