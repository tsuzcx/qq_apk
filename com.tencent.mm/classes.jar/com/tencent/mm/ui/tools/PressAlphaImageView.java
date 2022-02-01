package com.tencent.mm.ui.tools;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.ui.widget.imageview.WeImageView;
import junit.framework.Assert;

public class PressAlphaImageView
  extends WeImageView
{
  private float KKt;
  
  public PressAlphaImageView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(143206);
    this.KKt = 0.7F;
    super.setOnTouchListener(new View.OnTouchListener()
    {
      public final boolean onTouch(View paramAnonymousView, MotionEvent paramAnonymousMotionEvent)
      {
        AppMethodBeat.i(143205);
        b localb = new b();
        localb.bd(paramAnonymousView);
        localb.bd(paramAnonymousMotionEvent);
        a.b("com/tencent/mm/ui/tools/PressAlphaImageView$1", "android/view/View$OnTouchListener", "onTouch", "(Landroid/view/View;Landroid/view/MotionEvent;)Z", this, localb.ahq());
        switch (paramAnonymousMotionEvent.getAction())
        {
        case 2: 
        default: 
          if ((PressAlphaImageView.this.isClickable()) || (PressAlphaImageView.this.isLongClickable())) {
            break;
          }
        }
        for (boolean bool = true;; bool = false)
        {
          a.a(bool, this, "com/tencent/mm/ui/tools/PressAlphaImageView$1", "android/view/View$OnTouchListener", "onTouch", "(Landroid/view/View;Landroid/view/MotionEvent;)Z");
          AppMethodBeat.o(143205);
          return bool;
          paramAnonymousView.setAlpha(PressAlphaImageView.a(PressAlphaImageView.this));
          break;
          paramAnonymousView.setAlpha(1.0F);
          break;
        }
      }
    });
    AppMethodBeat.o(143206);
  }
  
  @Deprecated
  public void setOnTouchListener(View.OnTouchListener paramOnTouchListener)
  {
    AppMethodBeat.i(143207);
    Assert.assertTrue(false);
    AppMethodBeat.o(143207);
  }
  
  public void setPressAlpha(float paramFloat)
  {
    this.KKt = paramFloat;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.ui.tools.PressAlphaImageView
 * JD-Core Version:    0.7.0.1
 */