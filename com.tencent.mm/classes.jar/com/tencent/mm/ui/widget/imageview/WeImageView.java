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
import com.tencent.mm.ck.a.a;

public class WeImageView
  extends AppCompatImageView
{
  private int FEh;
  private boolean LvA;
  private int Lvw;
  private float Lvx;
  private int Lvy;
  private boolean Lvz;
  private int mAlpha;
  
  public WeImageView(Context paramContext)
  {
    super(paramContext);
    AppMethodBeat.i(159411);
    this.Lvx = 1.0F;
    this.mAlpha = 255;
    this.Lvy = 255;
    this.Lvz = true;
    this.LvA = false;
    init(paramContext, null);
    AppMethodBeat.o(159411);
  }
  
  public WeImageView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(159412);
    this.Lvx = 1.0F;
    this.mAlpha = 255;
    this.Lvy = 255;
    this.Lvz = true;
    this.LvA = false;
    init(paramContext, paramAttributeSet);
    AppMethodBeat.o(159412);
  }
  
  public WeImageView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(159413);
    this.Lvx = 1.0F;
    this.mAlpha = 255;
    this.Lvy = 255;
    this.Lvz = true;
    this.LvA = false;
    init(paramContext, paramAttributeSet);
    AppMethodBeat.o(159413);
  }
  
  private void init(Context paramContext, AttributeSet paramAttributeSet)
  {
    AppMethodBeat.i(159415);
    this.Lvw = paramContext.getResources().getColor(2131099732);
    if (paramAttributeSet != null)
    {
      paramContext = paramContext.obtainStyledAttributes(paramAttributeSet, a.a.WeImageView);
      this.FEh = paramContext.getColor(1, this.Lvw);
      this.Lvx = paramContext.getFloat(0, 1.0F);
      paramContext.recycle();
      AppMethodBeat.o(159415);
      return;
    }
    this.FEh = this.Lvw;
    AppMethodBeat.o(159415);
  }
  
  public void drawableStateChanged()
  {
    AppMethodBeat.i(200406);
    super.drawableStateChanged();
    int i = this.mAlpha;
    if (isPressed()) {
      i = 127;
    }
    for (;;)
    {
      if (i != this.Lvy)
      {
        this.Lvy = i;
        if (getDrawable() != null) {
          getDrawable().setAlpha(i);
        }
      }
      AppMethodBeat.o(200406);
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
    if ((this.LvA) && (this.Lvz))
    {
      getDrawable().mutate().clearColorFilter();
      this.LvA = false;
      this.Lvz = false;
      AppMethodBeat.o(159416);
      return;
    }
    if ((getDrawable() != null) && (this.Lvz))
    {
      int i = this.FEh;
      if (this.FEh != 0) {
        i = this.FEh & 0xFFFFFF | 0xFF000000;
      }
      int j = Color.alpha(this.FEh);
      if (this.Lvx != 1.0F) {
        j = (int)(255.0F * this.Lvx);
      }
      paramCanvas = new PorterDuffColorFilter(i, PorterDuff.Mode.SRC_ATOP);
      getDrawable().mutate().setColorFilter(paramCanvas);
      if (this.FEh != 0)
      {
        this.mAlpha = j;
        getDrawable().setAlpha(j);
      }
      this.Lvz = false;
    }
    AppMethodBeat.o(159416);
  }
  
  public void setClearColorFilter(boolean paramBoolean)
  {
    AppMethodBeat.i(200405);
    this.LvA = paramBoolean;
    this.Lvz = true;
    invalidate();
    AppMethodBeat.o(200405);
  }
  
  public void setIconColor(int paramInt)
  {
    AppMethodBeat.i(159414);
    this.FEh = paramInt;
    this.Lvz = true;
    invalidate();
    AppMethodBeat.o(159414);
  }
  
  public final void w(int paramInt, float paramFloat)
  {
    AppMethodBeat.i(186015);
    this.FEh = paramInt;
    this.Lvx = paramFloat;
    this.Lvz = true;
    invalidate();
    AppMethodBeat.o(186015);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.ui.widget.imageview.WeImageView
 * JD-Core Version:    0.7.0.1
 */