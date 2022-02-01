package com.tencent.mm.plugin.remittance.ui;

import android.text.Layout;
import android.text.Spannable;
import android.text.Spannable.Factory;
import android.text.style.ClickableSpan;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import android.view.ViewConfiguration;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.b.b;

public final class a
  implements View.OnTouchListener
{
  private a xZH;
  
  public static a dJj()
  {
    AppMethodBeat.i(67915);
    a locala = new a();
    AppMethodBeat.o(67915);
    return locala;
  }
  
  public final boolean onTouch(View paramView, MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(67916);
    Object localObject1 = new b();
    ((b)localObject1).bd(paramView);
    ((b)localObject1).bd(paramMotionEvent);
    com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/remittance/ui/ClickMovementMethod", "android/view/View$OnTouchListener", "onTouch", "(Landroid/view/View;Landroid/view/MotionEvent;)Z", this, ((b)localObject1).ahq());
    if (this.xZH == null) {
      this.xZH = new a(paramView);
    }
    localObject1 = (TextView)paramView;
    ((TextView)localObject1).setMovementMethod(null);
    Object localObject2 = ((TextView)localObject1).getText();
    localObject2 = Spannable.Factory.getInstance().newSpannable((CharSequence)localObject2);
    int i = paramMotionEvent.getAction();
    if ((i == 0) || (i == 1))
    {
      int j = (int)paramMotionEvent.getX();
      int k = (int)paramMotionEvent.getY();
      int m = ((TextView)localObject1).getTotalPaddingLeft();
      int n = ((TextView)localObject1).getTotalPaddingTop();
      int i1 = ((TextView)localObject1).getScrollX();
      int i2 = ((TextView)localObject1).getScrollY();
      paramMotionEvent = ((TextView)localObject1).getLayout();
      j = paramMotionEvent.getOffsetForHorizontal(paramMotionEvent.getLineForVertical(k - n + i2), j - m + i1);
      paramMotionEvent = (ClickableSpan[])((Spannable)localObject2).getSpans(j, j, ClickableSpan.class);
      if (paramMotionEvent.length != 0)
      {
        if (i == 0) {
          paramView.postDelayed(this.xZH, ViewConfiguration.getLongPressTimeout());
        }
        for (;;)
        {
          com.tencent.mm.hellhoundlib.a.a.a(true, this, "com/tencent/mm/plugin/remittance/ui/ClickMovementMethod", "android/view/View$OnTouchListener", "onTouch", "(Landroid/view/View;Landroid/view/MotionEvent;)Z");
          AppMethodBeat.o(67916);
          return true;
          paramView.removeCallbacks(this.xZH);
          paramMotionEvent[0].onClick((View)localObject1);
        }
      }
    }
    else if (i == 3)
    {
      paramView.removeCallbacks(this.xZH);
    }
    com.tencent.mm.hellhoundlib.a.a.a(false, this, "com/tencent/mm/plugin/remittance/ui/ClickMovementMethod", "android/view/View$OnTouchListener", "onTouch", "(Landroid/view/View;Landroid/view/MotionEvent;)Z");
    AppMethodBeat.o(67916);
    return false;
  }
  
  static final class a
    implements Runnable
  {
    private View view;
    
    a(View paramView)
    {
      this.view = paramView;
    }
    
    public final void run()
    {
      AppMethodBeat.i(67914);
      View localView = this.view;
      for (boolean bool = localView.performLongClick(); !bool; bool = localView.performLongClick())
      {
        localView = (View)localView.getParent();
        if (localView == null) {
          break;
        }
      }
      AppMethodBeat.o(67914);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.remittance.ui.a
 * JD-Core Version:    0.7.0.1
 */