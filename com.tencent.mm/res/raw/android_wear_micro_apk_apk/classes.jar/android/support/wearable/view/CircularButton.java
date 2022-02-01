package android.support.wearable.view;

import android.animation.Animator;
import android.animation.ObjectAnimator;
import android.animation.StateListAnimator;
import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.RippleDrawable;
import android.graphics.drawable.ShapeDrawable;
import android.graphics.drawable.shapes.OvalShape;
import android.support.wearable.k;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.Interpolator;

@SuppressLint({"ClickableViewAccessibility"})
@TargetApi(21)
public class CircularButton
  extends View
{
  private static final double Df = Math.sqrt(2.0D);
  private int Dg = -1;
  private ShapeDrawable Dh = new ShapeDrawable(new OvalShape());
  private RippleDrawable Di;
  private ColorStateList Dj;
  private Drawable Dk;
  private int Dl;
  private int Dm;
  private Interpolator mInterpolator;
  
  public CircularButton(Context paramContext)
  {
    this(paramContext, null);
  }
  
  public CircularButton(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public CircularButton(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    this(paramContext, paramAttributeSet, paramInt, (byte)0);
  }
  
  private CircularButton(Context paramContext, AttributeSet paramAttributeSet, int paramInt, byte paramByte)
  {
    super(paramContext, paramAttributeSet, paramInt, 0);
    this.Dh.getPaint().setColor(-3355444);
    super.setBackgroundDrawable(this.Dh);
    setOutlineProvider(new e(this, (byte)0));
    this.mInterpolator = new AccelerateInterpolator(2.0F);
    this.Dm = 0;
    paramContext = paramContext.obtainStyledAttributes(paramAttributeSet, k.zw, paramInt, 0);
    paramInt = paramByte;
    if (paramInt < paramContext.getIndexCount())
    {
      paramByte = paramContext.getIndex(paramInt);
      if (paramByte == k.zy)
      {
        this.Dj = paramContext.getColorStateList(paramByte);
        this.Dh.getPaint().setColor(this.Dj.getDefaultColor());
      }
      for (;;)
      {
        paramInt += 1;
        break;
        if (paramByte == k.zx) {
          this.Dk = paramContext.getDrawable(paramByte);
        } else if (paramByte == k.zA) {
          bl(paramContext.getColor(paramByte, -1));
        } else if (paramByte == k.zB) {
          v(paramContext.getDimension(paramByte, 0.0F));
        } else if (paramByte == k.zz) {
          this.Dm = paramContext.getInt(paramByte, this.Dm);
        }
      }
    }
    paramContext.recycle();
    setClickable(true);
  }
  
  private Animator c(Animator paramAnimator)
  {
    paramAnimator.setInterpolator(this.mInterpolator);
    return paramAnimator;
  }
  
  private static boolean c(Drawable paramDrawable)
  {
    return (paramDrawable != null) && (paramDrawable.getIntrinsicHeight() > 0) && (paramDrawable.getIntrinsicWidth() > 0);
  }
  
  public final void bj(int paramInt)
  {
    this.Dm = paramInt;
    if (this.Dk != null)
    {
      invalidate();
      requestLayout();
    }
  }
  
  public final void bl(int paramInt)
  {
    this.Dg = paramInt;
    if (this.Di != null)
    {
      this.Di.setColor(ColorStateList.valueOf(paramInt));
      return;
    }
    if ((this.Dg != -1) && (!isInEditMode()))
    {
      this.Di = new RippleDrawable(ColorStateList.valueOf(paramInt), this.Dh, this.Dh);
      super.setBackgroundDrawable(this.Di);
      return;
    }
    this.Di = null;
    super.setBackgroundDrawable(this.Dh);
  }
  
  protected void drawableStateChanged()
  {
    super.drawableStateChanged();
    if ((this.Dj != null) && (this.Dj.isStateful()))
    {
      this.Dh.getPaint().setColor(this.Dj.getColorForState(getDrawableState(), this.Dj.getDefaultColor()));
      this.Dh.invalidateSelf();
    }
  }
  
  public final Drawable fh()
  {
    return this.Dk;
  }
  
  public final int fi()
  {
    return this.Dm;
  }
  
  protected void onDraw(Canvas paramCanvas)
  {
    super.onDraw(paramCanvas);
    if (this.Dk != null) {
      this.Dk.draw(paramCanvas);
    }
  }
  
  protected void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    super.onLayout(paramBoolean, paramInt1, paramInt2, paramInt3, paramInt4);
    int i;
    int j;
    if (this.Dk != null)
    {
      i = this.Dk.getIntrinsicWidth();
      j = this.Dk.getIntrinsicHeight();
      if ((this.Dm != 0) && (c(this.Dk))) {
        break label218;
      }
      paramInt2 = (int)Math.floor(this.Dl / 2 * Df);
      paramInt1 = (this.Dl - paramInt2) / 2;
      if (!c(this.Dk)) {
        this.Dk.setBounds(paramInt1, paramInt1, paramInt1 + paramInt2, paramInt2 + paramInt1);
      }
    }
    else
    {
      return;
    }
    if (i == j)
    {
      i = paramInt1;
      j = paramInt2;
      paramInt4 = paramInt1;
      paramInt3 = paramInt2;
      paramInt2 = j;
      paramInt1 = i;
    }
    for (;;)
    {
      this.Dk.setBounds(paramInt1, paramInt4, paramInt1 + paramInt3, paramInt2 + paramInt4);
      return;
      float f = i / j;
      if (i > j)
      {
        i = (int)(paramInt2 / f);
        paramInt4 = (int)((paramInt2 - i) / 2.0F);
        paramInt3 = paramInt2;
        paramInt2 = i;
      }
      else
      {
        paramInt3 = (int)(f * paramInt2);
        i = (int)((paramInt2 - paramInt3) / 2.0F);
        paramInt4 = paramInt1;
        paramInt1 = i;
      }
    }
    label218:
    paramInt1 = (int)((paramInt3 - paramInt1 - i) / 2.0F);
    paramInt2 = (int)((paramInt4 - paramInt2 - j) / 2.0F);
    this.Dk.setBounds(paramInt1, paramInt2, i + paramInt1, j + paramInt2);
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    int j = View.MeasureSpec.getMode(paramInt1);
    paramInt1 = View.MeasureSpec.getSize(paramInt1);
    int k = View.MeasureSpec.getMode(paramInt2);
    int i = View.MeasureSpec.getSize(paramInt2);
    if ((j == 1073741824) && (k == 1073741824)) {
      this.Dl = Math.min(paramInt1, i);
    }
    for (;;)
    {
      setMeasuredDimension(this.Dl, this.Dl);
      return;
      if (j == 1073741824)
      {
        this.Dl = paramInt1;
      }
      else if (k == 1073741824)
      {
        this.Dl = i;
      }
      else
      {
        if (c(this.Dk))
        {
          paramInt2 = Math.max(this.Dk.getIntrinsicHeight(), this.Dk.getIntrinsicWidth());
          label120:
          if ((j != -2147483648) && (k != -2147483648)) {
            break label212;
          }
          if (j == -2147483648) {
            break label192;
          }
          paramInt1 = i;
        }
        for (;;)
        {
          this.Dl = Math.min(paramInt1, (int)Math.floor(paramInt2 / Df) * 2);
          break;
          paramInt2 = (int)Math.ceil(TypedValue.applyDimension(1, 48.0F, getResources().getDisplayMetrics()));
          break label120;
          label192:
          if (k == -2147483648) {
            paramInt1 = Math.min(paramInt1, i);
          }
        }
        label212:
        this.Dl = paramInt2;
      }
    }
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    boolean bool = super.onTouchEvent(paramMotionEvent);
    if (bool) {}
    switch (paramMotionEvent.getAction() & 0xFF)
    {
    default: 
      return bool;
    }
    getBackground().setHotspot(paramMotionEvent.getX(), paramMotionEvent.getY());
    return bool;
  }
  
  public void setBackgroundDrawable(Drawable paramDrawable) {}
  
  public final void setColor(int paramInt)
  {
    this.Dj = ColorStateList.valueOf(0);
    this.Dh.getPaint().setColor(this.Dj.getDefaultColor());
  }
  
  public final void setColor(ColorStateList paramColorStateList)
  {
    this.Dj = paramColorStateList;
    this.Dh.getPaint().setColor(this.Dj.getDefaultColor());
  }
  
  public final void setImageDrawable(Drawable paramDrawable)
  {
    if (this.Dk != null) {
      this.Dk.setCallback(null);
    }
    if (this.Dk != paramDrawable)
    {
      this.Dk = paramDrawable;
      requestLayout();
      invalidate();
    }
    if (this.Dk != null) {
      this.Dk.setCallback(this);
    }
  }
  
  public final void v(float paramFloat)
  {
    StateListAnimator localStateListAnimator = new StateListAnimator();
    localStateListAnimator.addState(PRESSED_ENABLED_STATE_SET, c(ObjectAnimator.ofFloat(this, "translationZ", new float[] { paramFloat })));
    localStateListAnimator.addState(ENABLED_FOCUSED_STATE_SET, c(ObjectAnimator.ofFloat(this, "translationZ", new float[] { paramFloat })));
    localStateListAnimator.addState(EMPTY_STATE_SET, c(ObjectAnimator.ofFloat(this, "translationZ", new float[] { getElevation() })));
    setStateListAnimator(localStateListAnimator);
  }
  
  protected boolean verifyDrawable(Drawable paramDrawable)
  {
    return (this.Dk == paramDrawable) || (super.verifyDrawable(paramDrawable));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\res\raw\android_wear_micro_apk_apk\classes.jar
 * Qualified Name:     android.support.wearable.view.CircularButton
 * JD-Core Version:    0.7.0.1
 */