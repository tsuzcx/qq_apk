package com.tencent.mm.ui.widget.imageview;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.PorterDuff.Mode;
import android.graphics.PorterDuffColorFilter;
import android.graphics.drawable.Drawable;
import android.support.v7.widget.AppCompatImageView;
import android.util.AttributeSet;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.cl.a.a;

public class WeImageView
  extends AppCompatImageView
{
  private int DGC;
  private int JhK;
  private float JhL;
  private int JhM;
  private boolean JhN;
  private int mAlpha;
  
  public WeImageView(Context paramContext)
  {
    super(paramContext);
    AppMethodBeat.i(159411);
    this.JhL = 1.0F;
    this.mAlpha = 255;
    this.JhM = 255;
    this.JhN = true;
    init(paramContext, null);
    AppMethodBeat.o(159411);
  }
  
  public WeImageView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(159412);
    this.JhL = 1.0F;
    this.mAlpha = 255;
    this.JhM = 255;
    this.JhN = true;
    init(paramContext, paramAttributeSet);
    AppMethodBeat.o(159412);
  }
  
  public WeImageView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(159413);
    this.JhL = 1.0F;
    this.mAlpha = 255;
    this.JhM = 255;
    this.JhN = true;
    init(paramContext, paramAttributeSet);
    AppMethodBeat.o(159413);
  }
  
  private void init(Context paramContext, AttributeSet paramAttributeSet)
  {
    AppMethodBeat.i(159415);
    this.JhK = paramContext.getResources().getColor(2131099732);
    if (paramAttributeSet != null)
    {
      paramContext = paramContext.obtainStyledAttributes(paramAttributeSet, a.a.WeImageView);
      this.DGC = paramContext.getColor(1, this.JhK);
      this.JhL = paramContext.getFloat(0, 1.0F);
      paramContext.recycle();
      AppMethodBeat.o(159415);
      return;
    }
    this.DGC = this.JhK;
    AppMethodBeat.o(159415);
  }
  
  public void drawableStateChanged()
  {
    AppMethodBeat.i(199709);
    super.drawableStateChanged();
    int i = this.mAlpha;
    if (isPressed()) {
      i = 127;
    }
    for (;;)
    {
      if (i != this.JhM)
      {
        this.JhM = i;
        if (getDrawable() != null) {
          getDrawable().setAlpha(i);
        }
      }
      AppMethodBeat.o(199709);
      return;
      if (isEnabled()) {
        i = this.mAlpha;
      }
    }
  }
  
  protected void onDraw(Canvas paramCanvas)
  {
    AppMethodBeat.i(159416);
    super.onDraw(paramCanvas);
    if ((getDrawable() != null) && (this.JhN))
    {
      int i = this.DGC;
      if (this.DGC != 0) {
        i = this.DGC & 0xFFFFFF | 0xFF000000;
      }
      int j = Color.alpha(this.DGC);
      if (this.JhL != 1.0F) {
        j = (int)(255.0F * this.JhL);
      }
      paramCanvas = new PorterDuffColorFilter(i, PorterDuff.Mode.SRC_ATOP);
      getDrawable().mutate().setColorFilter(paramCanvas);
      if (this.DGC != 0)
      {
        this.mAlpha = j;
        getDrawable().setAlpha(j);
      }
      this.JhN = false;
    }
    AppMethodBeat.o(159416);
  }
  
  public void setIconColor(int paramInt)
  {
    AppMethodBeat.i(159414);
    this.DGC = paramInt;
    this.JhN = true;
    invalidate();
    AppMethodBeat.o(159414);
  }
  
  public final void v(int paramInt, float paramFloat)
  {
    AppMethodBeat.i(186015);
    this.DGC = paramInt;
    this.JhL = paramFloat;
    this.JhN = true;
    invalidate();
    AppMethodBeat.o(186015);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.ui.widget.imageview.WeImageView
 * JD-Core Version:    0.7.0.1
 */