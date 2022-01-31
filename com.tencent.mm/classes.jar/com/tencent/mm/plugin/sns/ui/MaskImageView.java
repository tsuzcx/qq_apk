package com.tencent.mm.plugin.sns.ui;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.os.Looper;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ak;

public class MaskImageView
  extends TagImageView
{
  private int a;
  private int b;
  private boolean enable;
  private int g;
  private int r;
  private ak rER;
  private Runnable rES;
  
  public MaskImageView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(38309);
    this.a = 90;
    this.r = 0;
    this.g = 0;
    this.b = 0;
    this.enable = true;
    this.rER = new ak(Looper.getMainLooper());
    this.rES = new MaskImageView.1(this);
    super.setOnTouchListener(new MaskImageView.2(this));
    super.setContentDescription(getContext().getResources().getString(2131303840));
    AppMethodBeat.o(38309);
  }
  
  public final boolean d(View paramView, MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(38310);
    switch (paramMotionEvent.getAction())
    {
    }
    while ((!isClickable()) && (!isLongClickable()))
    {
      AppMethodBeat.o(38310);
      return true;
      paramView.setPressed(true);
      paramView.invalidate();
      this.rER.removeCallbacks(this.rES);
      continue;
      this.rER.post(this.rES);
    }
    AppMethodBeat.o(38310);
    return false;
  }
  
  public void onAttachedToWindow()
  {
    AppMethodBeat.i(38312);
    super.onAttachedToWindow();
    AppMethodBeat.o(38312);
  }
  
  public void onDetachedFromWindow()
  {
    AppMethodBeat.i(38313);
    super.onDetachedFromWindow();
    AppMethodBeat.o(38313);
  }
  
  public void onDraw(Canvas paramCanvas)
  {
    AppMethodBeat.i(38311);
    super.onDraw(paramCanvas);
    if (isPressed()) {
      paramCanvas.drawARGB(this.a, this.r, this.g, this.b);
    }
    AppMethodBeat.o(38311);
  }
  
  public void settouchEnable(boolean paramBoolean)
  {
    this.enable = paramBoolean;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.MaskImageView
 * JD-Core Version:    0.7.0.1
 */