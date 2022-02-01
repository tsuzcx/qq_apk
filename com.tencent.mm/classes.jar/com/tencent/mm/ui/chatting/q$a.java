package com.tencent.mm.ui.chatting;

import android.graphics.Color;
import android.graphics.PorterDuff.Mode;
import android.graphics.drawable.Drawable;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import android.widget.ImageView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.hellhoundlib.b.b;

public final class q$a
  implements View.OnTouchListener
{
  private int mColor;
  
  public q$a()
  {
    this(Color.argb(255, 136, 136, 136));
    AppMethodBeat.i(34564);
    AppMethodBeat.o(34564);
  }
  
  private q$a(int paramInt)
  {
    this.mColor = paramInt;
  }
  
  public final boolean onTouch(View paramView, MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(34565);
    b localb = new b();
    localb.bd(paramView);
    localb.bd(paramMotionEvent);
    a.b("com/tencent/mm/ui/chatting/ChattingItemAvatarOnHoverHelper$ChangeViewBgOnTouchListener", "android/view/View$OnTouchListener", "onTouch", "(Landroid/view/View;Landroid/view/MotionEvent;)Z", this, localb.ahq());
    int i = paramMotionEvent.getAction();
    if ((paramView instanceof ImageView))
    {
      paramView = ((ImageView)paramView).getDrawable();
      if (paramView != null)
      {
        if (i != 0) {
          break label110;
        }
        paramView.setColorFilter(this.mColor, PorterDuff.Mode.MULTIPLY);
      }
    }
    for (;;)
    {
      a.a(false, this, "com/tencent/mm/ui/chatting/ChattingItemAvatarOnHoverHelper$ChangeViewBgOnTouchListener", "android/view/View$OnTouchListener", "onTouch", "(Landroid/view/View;Landroid/view/MotionEvent;)Z");
      AppMethodBeat.o(34565);
      return false;
      paramView = paramView.getBackground();
      break;
      label110:
      if ((i == 3) || (i == 1)) {
        paramView.clearColorFilter();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.q.a
 * JD-Core Version:    0.7.0.1
 */