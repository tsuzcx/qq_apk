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
  private int Kxl;
  private int QRf;
  private float QRg;
  private int QRh;
  private boolean QRi;
  private boolean QRj;
  private boolean QRk;
  private int mAlpha;
  
  public WeImageView(Context paramContext)
  {
    super(paramContext);
    AppMethodBeat.i(159411);
    this.QRg = 1.0F;
    this.mAlpha = 255;
    this.QRh = 255;
    this.QRi = true;
    this.QRj = false;
    this.QRk = true;
    init(paramContext, null);
    AppMethodBeat.o(159411);
  }
  
  public WeImageView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(159412);
    this.QRg = 1.0F;
    this.mAlpha = 255;
    this.QRh = 255;
    this.QRi = true;
    this.QRj = false;
    this.QRk = true;
    init(paramContext, paramAttributeSet);
    AppMethodBeat.o(159412);
  }
  
  public WeImageView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(159413);
    this.QRg = 1.0F;
    this.mAlpha = 255;
    this.QRh = 255;
    this.QRi = true;
    this.QRj = false;
    this.QRk = true;
    init(paramContext, paramAttributeSet);
    AppMethodBeat.o(159413);
  }
  
  private void init(Context paramContext, AttributeSet paramAttributeSet)
  {
    AppMethodBeat.i(159415);
    this.QRf = paramContext.getResources().getColor(2131099746);
    if (paramAttributeSet != null)
    {
      paramContext = paramContext.obtainStyledAttributes(paramAttributeSet, a.a.WeImageView);
      this.Kxl = paramContext.getColor(1, this.QRf);
      this.QRg = paramContext.getFloat(0, 1.0F);
      paramContext.recycle();
      AppMethodBeat.o(159415);
      return;
    }
    this.Kxl = this.QRf;
    AppMethodBeat.o(159415);
  }
  
  public final void C(int paramInt, float paramFloat)
  {
    AppMethodBeat.i(186015);
    this.Kxl = paramInt;
    this.QRg = paramFloat;
    this.QRi = true;
    invalidate();
    AppMethodBeat.o(186015);
  }
  
  public void drawableStateChanged()
  {
    AppMethodBeat.i(198351);
    super.drawableStateChanged();
    int i = this.mAlpha;
    if (isPressed()) {
      i = 127;
    }
    for (;;)
    {
      if ((!isEnabled()) || (!isFocusable())) {
        i = 255;
      }
      if (i != this.QRh)
      {
        this.QRh = i;
        if (getDrawable() != null) {
          getDrawable().setAlpha(i);
        }
      }
      AppMethodBeat.o(198351);
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
    if ((this.QRj) && (this.QRi))
    {
      getDrawable().mutate().clearColorFilter();
      this.QRj = false;
      this.QRi = false;
      AppMethodBeat.o(159416);
      return;
    }
    if ((!this.QRk) && (getDrawable() != null) && (this.QRi))
    {
      getDrawable().mutate().clearColorFilter();
      this.QRi = false;
      AppMethodBeat.o(159416);
      return;
    }
    if ((this.QRk) && (getDrawable() != null) && (this.QRi))
    {
      int i = this.Kxl;
      if (this.Kxl != 0) {
        i = this.Kxl & 0xFFFFFF | 0xFF000000;
      }
      int j = Color.alpha(this.Kxl);
      if (this.QRg != 1.0F) {
        j = (int)(255.0F * this.QRg);
      }
      paramCanvas = new PorterDuffColorFilter(i, PorterDuff.Mode.SRC_ATOP);
      getDrawable().mutate().setColorFilter(paramCanvas);
      if (this.Kxl != 0)
      {
        this.mAlpha = j;
        getDrawable().setAlpha(j);
      }
      this.QRi = false;
    }
    AppMethodBeat.o(159416);
  }
  
  public void setClearColorFilter(boolean paramBoolean)
  {
    AppMethodBeat.i(198349);
    this.QRj = paramBoolean;
    this.QRi = true;
    invalidate();
    AppMethodBeat.o(198349);
  }
  
  public void setEnableColorFilter(boolean paramBoolean)
  {
    AppMethodBeat.i(198350);
    if (this.QRk != paramBoolean)
    {
      this.QRk = paramBoolean;
      this.QRi = true;
      invalidate();
    }
    AppMethodBeat.o(198350);
  }
  
  public void setIconColor(int paramInt)
  {
    AppMethodBeat.i(159414);
    this.Kxl = paramInt;
    this.QRi = true;
    invalidate();
    AppMethodBeat.o(159414);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.ui.widget.imageview.WeImageView
 * JD-Core Version:    0.7.0.1
 */