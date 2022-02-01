package com.tencent.mm.ui.widget.imageview;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.PorterDuff.Mode;
import android.graphics.PorterDuffColorFilter;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import androidx.appcompat.widget.AppCompatImageView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ck.a.c;
import com.tencent.mm.ck.a.k;

public class WeImageView
  extends AppCompatImageView
{
  private int Yvv;
  private int agid;
  private float agie;
  private int agif;
  private boolean agig;
  private boolean agih;
  private boolean agii;
  private int mAlpha;
  
  public WeImageView(Context paramContext)
  {
    super(paramContext);
    AppMethodBeat.i(159411);
    this.agie = 1.0F;
    this.mAlpha = 255;
    this.agif = 255;
    this.agig = true;
    this.agih = false;
    this.agii = true;
    init(paramContext, null);
    AppMethodBeat.o(159411);
  }
  
  public WeImageView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(159412);
    this.agie = 1.0F;
    this.mAlpha = 255;
    this.agif = 255;
    this.agig = true;
    this.agih = false;
    this.agii = true;
    init(paramContext, paramAttributeSet);
    AppMethodBeat.o(159412);
  }
  
  public WeImageView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(159413);
    this.agie = 1.0F;
    this.mAlpha = 255;
    this.agif = 255;
    this.agig = true;
    this.agih = false;
    this.agii = true;
    init(paramContext, paramAttributeSet);
    AppMethodBeat.o(159413);
  }
  
  private void init(Context paramContext, AttributeSet paramAttributeSet)
  {
    AppMethodBeat.i(159415);
    this.agid = paramContext.getResources().getColor(a.c.FG_0);
    if (paramAttributeSet != null)
    {
      paramContext = paramContext.obtainStyledAttributes(paramAttributeSet, a.k.WeImageView);
      this.Yvv = paramContext.getColor(a.k.WeImageView_iconColor, this.agid);
      this.agie = paramContext.getFloat(a.k.WeImageView_iconAlpha, 1.0F);
      paramContext.recycle();
      AppMethodBeat.o(159415);
      return;
    }
    this.Yvv = this.agid;
    AppMethodBeat.o(159415);
  }
  
  public final void F(int paramInt, float paramFloat)
  {
    AppMethodBeat.i(186015);
    this.Yvv = paramInt;
    this.agie = paramFloat;
    this.agig = true;
    invalidate();
    AppMethodBeat.o(186015);
  }
  
  public void drawableStateChanged()
  {
    AppMethodBeat.i(251646);
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
      if (i != this.agif)
      {
        this.agif = i;
        if (getDrawable() != null) {
          getDrawable().setAlpha(i);
        }
      }
      AppMethodBeat.o(251646);
      return;
      if (isEnabled()) {
        i = this.mAlpha;
      }
    }
  }
  
  public int getIconColor()
  {
    return this.Yvv;
  }
  
  public final void oR(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(251650);
    setImageResource(paramInt1);
    setIconColor(getContext().getResources().getColor(paramInt2));
    AppMethodBeat.o(251650);
  }
  
  protected void onDraw(Canvas paramCanvas)
  {
    AppMethodBeat.i(159416);
    super.onDraw(paramCanvas);
    if ((this.agih) && (this.agig))
    {
      getDrawable().mutate().clearColorFilter();
      this.agih = false;
      this.agig = false;
      AppMethodBeat.o(159416);
      return;
    }
    if ((!this.agii) && (getDrawable() != null) && (this.agig))
    {
      getDrawable().mutate().clearColorFilter();
      this.agig = false;
      AppMethodBeat.o(159416);
      return;
    }
    if ((this.agii) && (getDrawable() != null) && (this.agig))
    {
      int i = this.Yvv;
      if (this.Yvv != 0) {
        i = this.Yvv & 0xFFFFFF | 0xFF000000;
      }
      int j = Color.alpha(this.Yvv);
      if (this.agie != 1.0F) {
        j = (int)(255.0F * this.agie);
      }
      paramCanvas = new PorterDuffColorFilter(i, PorterDuff.Mode.SRC_ATOP);
      getDrawable().mutate().setColorFilter(paramCanvas);
      if (this.Yvv != 0)
      {
        this.mAlpha = j;
        getDrawable().setAlpha(j);
      }
      this.agig = false;
    }
    AppMethodBeat.o(159416);
  }
  
  public void setClearColorFilter(boolean paramBoolean)
  {
    AppMethodBeat.i(251621);
    this.agih = paramBoolean;
    this.agig = true;
    invalidate();
    AppMethodBeat.o(251621);
  }
  
  public void setEnableColorFilter(boolean paramBoolean)
  {
    AppMethodBeat.i(251628);
    if (this.agii != paramBoolean)
    {
      this.agii = paramBoolean;
      this.agig = true;
      invalidate();
    }
    AppMethodBeat.o(251628);
  }
  
  public void setIconColor(int paramInt)
  {
    AppMethodBeat.i(159414);
    this.Yvv = paramInt;
    this.agig = true;
    invalidate();
    AppMethodBeat.o(159414);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     com.tencent.mm.ui.widget.imageview.WeImageView
 * JD-Core Version:    0.7.0.1
 */