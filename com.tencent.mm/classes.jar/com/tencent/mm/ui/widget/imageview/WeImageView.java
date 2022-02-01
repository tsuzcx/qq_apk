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
import com.tencent.mm.cm.a.a;

public class WeImageView
  extends AppCompatImageView
{
  private int Coj;
  private int HHn;
  private float HHo;
  private int HHp;
  private boolean HHq;
  private int mAlpha;
  
  public WeImageView(Context paramContext)
  {
    super(paramContext);
    AppMethodBeat.i(159411);
    this.HHo = 1.0F;
    this.mAlpha = 255;
    this.HHp = 255;
    this.HHq = true;
    init(paramContext, null);
    AppMethodBeat.o(159411);
  }
  
  public WeImageView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(159412);
    this.HHo = 1.0F;
    this.mAlpha = 255;
    this.HHp = 255;
    this.HHq = true;
    init(paramContext, paramAttributeSet);
    AppMethodBeat.o(159412);
  }
  
  public WeImageView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(159413);
    this.HHo = 1.0F;
    this.mAlpha = 255;
    this.HHp = 255;
    this.HHq = true;
    init(paramContext, paramAttributeSet);
    AppMethodBeat.o(159413);
  }
  
  private void init(Context paramContext, AttributeSet paramAttributeSet)
  {
    AppMethodBeat.i(159415);
    this.HHn = paramContext.getResources().getColor(2131099732);
    if (paramAttributeSet != null)
    {
      paramContext = paramContext.obtainStyledAttributes(paramAttributeSet, a.a.WeImageView);
      this.Coj = paramContext.getColor(1, this.HHn);
      this.HHo = paramContext.getFloat(0, 1.0F);
      paramContext.recycle();
      AppMethodBeat.o(159415);
      return;
    }
    this.Coj = this.HHn;
    AppMethodBeat.o(159415);
  }
  
  public void drawableStateChanged()
  {
    AppMethodBeat.i(195239);
    super.drawableStateChanged();
    int i = this.mAlpha;
    if (isPressed()) {
      i = 127;
    }
    for (;;)
    {
      if (i != this.HHp)
      {
        this.HHp = i;
        if (getDrawable() != null) {
          getDrawable().setAlpha(i);
        }
      }
      AppMethodBeat.o(195239);
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
    if ((getDrawable() != null) && (this.HHq))
    {
      int i = this.Coj;
      if (this.Coj != 0) {
        i = this.Coj & 0xFFFFFF | 0xFF000000;
      }
      int j = Color.alpha(this.Coj);
      if (this.HHo != 1.0F) {
        j = (int)(255.0F * this.HHo);
      }
      paramCanvas = new PorterDuffColorFilter(i, PorterDuff.Mode.SRC_ATOP);
      getDrawable().mutate().setColorFilter(paramCanvas);
      if (this.Coj != 0)
      {
        this.mAlpha = j;
        getDrawable().setAlpha(j);
      }
      this.HHq = false;
    }
    AppMethodBeat.o(159416);
  }
  
  public void setIconColor(int paramInt)
  {
    AppMethodBeat.i(159414);
    this.Coj = paramInt;
    this.HHq = true;
    invalidate();
    AppMethodBeat.o(159414);
  }
  
  public final void v(int paramInt, float paramFloat)
  {
    AppMethodBeat.i(186015);
    this.Coj = paramInt;
    this.HHo = paramFloat;
    this.HHq = true;
    invalidate();
    AppMethodBeat.o(186015);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.ui.widget.imageview.WeImageView
 * JD-Core Version:    0.7.0.1
 */