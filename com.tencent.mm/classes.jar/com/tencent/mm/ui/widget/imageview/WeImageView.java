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
import com.tencent.mm.cr.a.c;
import com.tencent.mm.cr.a.k;

public class WeImageView
  extends AppCompatImageView
{
  private int RyZ;
  private int YpQ;
  private float YpR;
  private int YpS;
  private boolean YpT;
  private boolean YpU;
  private boolean YpV;
  private int mAlpha;
  
  public WeImageView(Context paramContext)
  {
    super(paramContext);
    AppMethodBeat.i(159411);
    this.YpR = 1.0F;
    this.mAlpha = 255;
    this.YpS = 255;
    this.YpT = true;
    this.YpU = false;
    this.YpV = true;
    init(paramContext, null);
    AppMethodBeat.o(159411);
  }
  
  public WeImageView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(159412);
    this.YpR = 1.0F;
    this.mAlpha = 255;
    this.YpS = 255;
    this.YpT = true;
    this.YpU = false;
    this.YpV = true;
    init(paramContext, paramAttributeSet);
    AppMethodBeat.o(159412);
  }
  
  public WeImageView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(159413);
    this.YpR = 1.0F;
    this.mAlpha = 255;
    this.YpS = 255;
    this.YpT = true;
    this.YpU = false;
    this.YpV = true;
    init(paramContext, paramAttributeSet);
    AppMethodBeat.o(159413);
  }
  
  private void init(Context paramContext, AttributeSet paramAttributeSet)
  {
    AppMethodBeat.i(159415);
    this.YpQ = paramContext.getResources().getColor(a.c.FG_0);
    if (paramAttributeSet != null)
    {
      paramContext = paramContext.obtainStyledAttributes(paramAttributeSet, a.k.WeImageView);
      this.RyZ = paramContext.getColor(a.k.WeImageView_iconColor, this.YpQ);
      this.YpR = paramContext.getFloat(a.k.WeImageView_iconAlpha, 1.0F);
      paramContext.recycle();
      AppMethodBeat.o(159415);
      return;
    }
    this.RyZ = this.YpQ;
    AppMethodBeat.o(159415);
  }
  
  public final void C(int paramInt, float paramFloat)
  {
    AppMethodBeat.i(186015);
    this.RyZ = paramInt;
    this.YpR = paramFloat;
    this.YpT = true;
    invalidate();
    AppMethodBeat.o(186015);
  }
  
  public void drawableStateChanged()
  {
    AppMethodBeat.i(251005);
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
      if (i != this.YpS)
      {
        this.YpS = i;
        if (getDrawable() != null) {
          getDrawable().setAlpha(i);
        }
      }
      AppMethodBeat.o(251005);
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
    if ((this.YpU) && (this.YpT))
    {
      getDrawable().mutate().clearColorFilter();
      this.YpU = false;
      this.YpT = false;
      AppMethodBeat.o(159416);
      return;
    }
    if ((!this.YpV) && (getDrawable() != null) && (this.YpT))
    {
      getDrawable().mutate().clearColorFilter();
      this.YpT = false;
      AppMethodBeat.o(159416);
      return;
    }
    if ((this.YpV) && (getDrawable() != null) && (this.YpT))
    {
      int i = this.RyZ;
      if (this.RyZ != 0) {
        i = this.RyZ & 0xFFFFFF | 0xFF000000;
      }
      int j = Color.alpha(this.RyZ);
      if (this.YpR != 1.0F) {
        j = (int)(255.0F * this.YpR);
      }
      paramCanvas = new PorterDuffColorFilter(i, PorterDuff.Mode.SRC_ATOP);
      getDrawable().mutate().setColorFilter(paramCanvas);
      if (this.RyZ != 0)
      {
        this.mAlpha = j;
        getDrawable().setAlpha(j);
      }
      this.YpT = false;
    }
    AppMethodBeat.o(159416);
  }
  
  public void setClearColorFilter(boolean paramBoolean)
  {
    AppMethodBeat.i(250995);
    this.YpU = paramBoolean;
    this.YpT = true;
    invalidate();
    AppMethodBeat.o(250995);
  }
  
  public void setEnableColorFilter(boolean paramBoolean)
  {
    AppMethodBeat.i(250997);
    if (this.YpV != paramBoolean)
    {
      this.YpV = paramBoolean;
      this.YpT = true;
      invalidate();
    }
    AppMethodBeat.o(250997);
  }
  
  public void setIconColor(int paramInt)
  {
    AppMethodBeat.i(159414);
    this.RyZ = paramInt;
    this.YpT = true;
    invalidate();
    AppMethodBeat.o(159414);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.ui.widget.imageview.WeImageView
 * JD-Core Version:    0.7.0.1
 */