package com.tencent.mm.ui.tools;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ui.widget.imageview.WeImageView;
import junit.framework.Assert;

public class PressAlphaImageView
  extends WeImageView
{
  private float QvL;
  
  public PressAlphaImageView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(143206);
    this.QvL = 0.7F;
    super.setOnTouchListener(new View.OnTouchListener()
    {
      public final boolean onTouch(View paramAnonymousView, MotionEvent paramAnonymousMotionEvent)
      {
        AppMethodBeat.i(143205);
        switch (paramAnonymousMotionEvent.getAction())
        {
        }
        while ((!PressAlphaImageView.this.isClickable()) && (!PressAlphaImageView.this.isLongClickable()))
        {
          AppMethodBeat.o(143205);
          return true;
          paramAnonymousView.setAlpha(PressAlphaImageView.a(PressAlphaImageView.this));
          continue;
          paramAnonymousView.setAlpha(1.0F);
        }
        AppMethodBeat.o(143205);
        return false;
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
    this.QvL = paramFloat;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.ui.tools.PressAlphaImageView
 * JD-Core Version:    0.7.0.1
 */