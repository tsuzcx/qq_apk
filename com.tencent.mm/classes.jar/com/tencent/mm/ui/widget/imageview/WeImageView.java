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
  private int FlJ;
  private int KYY;
  private float KYZ;
  private int KZa;
  private boolean KZb;
  private boolean KZc;
  private int mAlpha;
  
  public WeImageView(Context paramContext)
  {
    super(paramContext);
    AppMethodBeat.i(159411);
    this.KYZ = 1.0F;
    this.mAlpha = 255;
    this.KZa = 255;
    this.KZb = true;
    this.KZc = false;
    init(paramContext, null);
    AppMethodBeat.o(159411);
  }
  
  public WeImageView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(159412);
    this.KYZ = 1.0F;
    this.mAlpha = 255;
    this.KZa = 255;
    this.KZb = true;
    this.KZc = false;
    init(paramContext, paramAttributeSet);
    AppMethodBeat.o(159412);
  }
  
  public WeImageView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(159413);
    this.KYZ = 1.0F;
    this.mAlpha = 255;
    this.KZa = 255;
    this.KZb = true;
    this.KZc = false;
    init(paramContext, paramAttributeSet);
    AppMethodBeat.o(159413);
  }
  
  private void init(Context paramContext, AttributeSet paramAttributeSet)
  {
    AppMethodBeat.i(159415);
    this.KYY = paramContext.getResources().getColor(2131099732);
    if (paramAttributeSet != null)
    {
      paramContext = paramContext.obtainStyledAttributes(paramAttributeSet, a.a.WeImageView);
      this.FlJ = paramContext.getColor(1, this.KYY);
      this.KYZ = paramContext.getFloat(0, 1.0F);
      paramContext.recycle();
      AppMethodBeat.o(159415);
      return;
    }
    this.FlJ = this.KYY;
    AppMethodBeat.o(159415);
  }
  
  public void drawableStateChanged()
  {
    AppMethodBeat.i(192641);
    super.drawableStateChanged();
    int i = this.mAlpha;
    if (isPressed()) {
      i = 127;
    }
    for (;;)
    {
      if (i != this.KZa)
      {
        this.KZa = i;
        if (getDrawable() != null) {
          getDrawable().setAlpha(i);
        }
      }
      AppMethodBeat.o(192641);
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
    if ((this.KZc) && (this.KZb))
    {
      getDrawable().mutate().clearColorFilter();
      this.KZc = false;
      this.KZb = false;
      AppMethodBeat.o(159416);
      return;
    }
    if ((getDrawable() != null) && (this.KZb))
    {
      int i = this.FlJ;
      if (this.FlJ != 0) {
        i = this.FlJ & 0xFFFFFF | 0xFF000000;
      }
      int j = Color.alpha(this.FlJ);
      if (this.KYZ != 1.0F) {
        j = (int)(255.0F * this.KYZ);
      }
      paramCanvas = new PorterDuffColorFilter(i, PorterDuff.Mode.SRC_ATOP);
      getDrawable().mutate().setColorFilter(paramCanvas);
      if (this.FlJ != 0)
      {
        this.mAlpha = j;
        getDrawable().setAlpha(j);
      }
      this.KZb = false;
    }
    AppMethodBeat.o(159416);
  }
  
  public void setClearColorFilter(boolean paramBoolean)
  {
    AppMethodBeat.i(192640);
    this.KZc = paramBoolean;
    this.KZb = true;
    invalidate();
    AppMethodBeat.o(192640);
  }
  
  public void setIconColor(int paramInt)
  {
    AppMethodBeat.i(159414);
    this.FlJ = paramInt;
    this.KZb = true;
    invalidate();
    AppMethodBeat.o(159414);
  }
  
  public final void x(int paramInt, float paramFloat)
  {
    AppMethodBeat.i(186015);
    this.FlJ = paramInt;
    this.KYZ = paramFloat;
    this.KZb = true;
    invalidate();
    AppMethodBeat.o(186015);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.ui.widget.imageview.WeImageView
 * JD-Core Version:    0.7.0.1
 */