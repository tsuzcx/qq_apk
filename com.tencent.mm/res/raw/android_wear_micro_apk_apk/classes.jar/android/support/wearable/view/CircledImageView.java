package android.support.wearable.view;

import android.animation.ArgbEvaluator;
import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import android.annotation.TargetApi;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.graphics.RadialGradient;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Shader.TileMode;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.Drawable.Callback;
import android.support.wearable.k;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.MeasureSpec;

@TargetApi(21)
public class CircledImageView
  extends View
{
  private static final ArgbEvaluator AP = new ArgbEvaluator();
  private final RectF AQ;
  private ColorStateList AR;
  private float AS;
  private float AT;
  private float AU;
  private float AV;
  private float AW;
  private int AX;
  private float AY;
  private float AZ = 1.0F;
  private final float Ba;
  private float Bb;
  private boolean Bc = false;
  private float Bd;
  private boolean Be = false;
  private s Bf;
  private Rect Bg = new Rect();
  private long Bh = 0L;
  private float Bi = 1.0F;
  private float Bj = 0.0F;
  private Integer Bk;
  private Integer Bl;
  private final Drawable.Callback Bm = new Drawable.Callback()
  {
    public final void invalidateDrawable(Drawable paramAnonymousDrawable)
    {
      CircledImageView.this.invalidate();
    }
    
    public final void scheduleDrawable(Drawable paramAnonymousDrawable, Runnable paramAnonymousRunnable, long paramAnonymousLong) {}
    
    public final void unscheduleDrawable(Drawable paramAnonymousDrawable, Runnable paramAnonymousRunnable) {}
  };
  private final ValueAnimator.AnimatorUpdateListener Bn = new ValueAnimator.AnimatorUpdateListener()
  {
    public final void onAnimationUpdate(ValueAnimator paramAnonymousValueAnimator)
    {
      int i = ((Integer)paramAnonymousValueAnimator.getAnimatedValue()).intValue();
      if (i != CircledImageView.a(CircledImageView.this))
      {
        CircledImageView.a(CircledImageView.this, i);
        CircledImageView.this.invalidate();
      }
    }
  };
  private ValueAnimator Bo;
  private boolean eS;
  private int gc;
  private Drawable gh;
  private final Paint nC;
  
  public CircledImageView(Context paramContext)
  {
    this(paramContext, null);
  }
  
  public CircledImageView(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public CircledImageView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    paramContext = getContext().obtainStyledAttributes(paramAttributeSet, k.xs);
    this.gh = paramContext.getDrawable(k.xt);
    this.AR = paramContext.getColorStateList(k.xu);
    if (this.AR == null) {
      this.AR = ColorStateList.valueOf(17170432);
    }
    this.AS = paramContext.getDimension(k.xv, 0.0F);
    this.Bd = this.AS;
    this.AU = paramContext.getDimension(k.xw, this.AS);
    this.AX = paramContext.getColor(k.xy, -16777216);
    this.AY = paramContext.getDimension(k.xx, 0.0F);
    if (this.AY > 0.0F) {
      this.AW += this.AY;
    }
    float f = paramContext.getDimension(k.xz, 0.0F);
    if (f > 0.0F) {
      this.AW = (f + this.AW);
    }
    this.Ba = paramContext.getDimension(k.xA, 0.0F);
    this.Bi = paramContext.getFloat(k.xB, 0.0F);
    this.Bj = paramContext.getFloat(k.xC, 0.0F);
    if (paramContext.hasValue(k.xD)) {
      this.Bk = Integer.valueOf(paramContext.getColor(k.xD, 0));
    }
    if (paramContext.hasValue(k.xG)) {
      this.Bl = Integer.valueOf(paramContext.getInt(k.xG, 0));
    }
    this.AT = paramContext.getFraction(k.xE, 1, 1, 0.0F);
    this.AV = paramContext.getFraction(k.xF, 1, 1, this.AT);
    paramContext.recycle();
    this.AQ = new RectF();
    this.nC = new Paint();
    this.nC.setAntiAlias(true);
    this.Bf = new s();
    this.Bf.setCallback(this.Bm);
    setWillNotDraw(false);
    eL();
  }
  
  private void eL()
  {
    int i = this.AR.getColorForState(getDrawableState(), this.AR.getDefaultColor());
    if (this.Bh > 0L) {
      if (this.Bo != null)
      {
        this.Bo.cancel();
        this.Bo.setIntValues(new int[] { this.gc, i });
        this.Bo.setEvaluator(AP);
        this.Bo.setDuration(this.Bh);
        this.Bo.addUpdateListener(this.Bn);
        this.Bo.start();
      }
    }
    while (i == this.gc) {
      for (;;)
      {
        return;
        this.Bo = new ValueAnimator();
      }
    }
    this.gc = i;
    invalidate();
  }
  
  private float eN()
  {
    float f2 = this.AS;
    float f1 = f2;
    if (this.AS <= 0.0F)
    {
      f1 = f2;
      if (this.AT > 0.0F) {
        f1 = Math.max(getMeasuredHeight(), getMeasuredWidth()) * this.AT;
      }
    }
    return f1 - this.AW;
  }
  
  private void s(boolean paramBoolean)
  {
    this.eS = paramBoolean;
    if (this.Bf != null)
    {
      if (paramBoolean) {
        this.Bf.fq();
      }
    }
    else {
      return;
    }
    this.Bf.fr();
  }
  
  protected void drawableStateChanged()
  {
    super.drawableStateChanged();
    eL();
  }
  
  public final void eM()
  {
    Drawable localDrawable1 = getContext().getDrawable(2130837507);
    int i;
    if (localDrawable1 != this.gh)
    {
      Drawable localDrawable2 = this.gh;
      this.gh = localDrawable1;
      if ((localDrawable1 == null) || (localDrawable2 == null) || (localDrawable2.getIntrinsicHeight() != localDrawable1.getIntrinsicHeight()) || (localDrawable2.getIntrinsicWidth() != localDrawable1.getIntrinsicWidth())) {
        break label81;
      }
      i = 1;
      if (i == 0) {
        break label86;
      }
      this.gh.setBounds(localDrawable2.getBounds());
    }
    for (;;)
    {
      invalidate();
      return;
      label81:
      i = 0;
      break;
      label86:
      requestLayout();
    }
  }
  
  public final void eO()
  {
    if (28.0F != this.AS)
    {
      this.AS = 28.0F;
      invalidate();
    }
  }
  
  public final void eP()
  {
    this.AX = -1;
  }
  
  public final void eQ()
  {
    if (5.0F != this.AY)
    {
      this.AY = 5.0F;
      invalidate();
    }
  }
  
  protected void onDraw(Canvas paramCanvas)
  {
    int i = getPaddingLeft();
    int j = getPaddingTop();
    float f1;
    if (this.Be)
    {
      float f2 = this.AU;
      f1 = f2;
      if (this.AU <= 0.0F)
      {
        f1 = f2;
        if (this.AV > 0.0F) {
          f1 = Math.max(getMeasuredHeight(), getMeasuredWidth()) * this.AV;
        }
      }
      f1 -= this.AW;
      if ((this.Ba > 0.0F) && (this.Bb > 0.0F))
      {
        this.AQ.set(i, j, getWidth() - getPaddingRight(), getHeight() - getPaddingBottom());
        f2 = this.AY + f1 + this.Ba * this.Bb;
        this.nC.setColor(-16777216);
        this.nC.setAlpha(Math.round(this.nC.getAlpha() * getAlpha()));
        this.nC.setStyle(Paint.Style.FILL);
        Paint localPaint = this.nC;
        float f3 = this.AQ.centerX();
        float f4 = this.AQ.centerY();
        Shader.TileMode localTileMode = Shader.TileMode.MIRROR;
        localPaint.setShader(new RadialGradient(f3, f4, f2, new int[] { -16777216, 0 }, new float[] { 0.6F, 1.0F }, localTileMode));
        paramCanvas.drawCircle(this.AQ.centerX(), this.AQ.centerY(), f2, this.nC);
        this.nC.setShader(null);
      }
      if (this.AY > 0.0F)
      {
        this.AQ.set(i, j, getWidth() - getPaddingRight(), getHeight() - getPaddingBottom());
        this.AQ.set(this.AQ.centerX() - f1, this.AQ.centerY() - f1, this.AQ.centerX() + f1, this.AQ.centerY() + f1);
        this.nC.setColor(this.AX);
        this.nC.setAlpha(Math.round(this.nC.getAlpha() * getAlpha()));
        this.nC.setStyle(Paint.Style.STROKE);
        this.nC.setStrokeWidth(this.AY);
        if (!this.eS) {
          break label661;
        }
        this.AQ.roundOut(this.Bg);
        this.Bf.setBounds(this.Bg);
        this.Bf.aW(this.AX);
        this.Bf.x(this.AY);
        this.Bf.draw(paramCanvas);
      }
    }
    for (;;)
    {
      if (!this.Bc)
      {
        this.AQ.set(i, j, getWidth() - getPaddingRight(), getHeight() - getPaddingBottom());
        this.nC.setColor(this.gc);
        this.nC.setAlpha(Math.round(this.nC.getAlpha() * getAlpha()));
        this.nC.setStyle(Paint.Style.FILL);
        paramCanvas.drawCircle(this.AQ.centerX(), this.AQ.centerY(), f1, this.nC);
      }
      if (this.gh != null)
      {
        this.gh.setAlpha(Math.round(getAlpha() * 255.0F));
        if (this.Bk != null) {
          this.gh.setTint(this.Bk.intValue());
        }
        this.gh.draw(paramCanvas);
      }
      super.onDraw(paramCanvas);
      return;
      f1 = eN();
      break;
      label661:
      paramCanvas.drawArc(this.AQ, -90.0F, this.AZ * 360.0F, false, this.nC);
    }
  }
  
  protected void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    int j;
    int m;
    int k;
    int i;
    float f1;
    if (this.gh != null)
    {
      j = this.gh.getIntrinsicWidth();
      m = this.gh.getIntrinsicHeight();
      k = getMeasuredWidth();
      i = getMeasuredHeight();
      if (this.Bi <= 0.0F) {
        break label190;
      }
      f2 = this.Bi;
      if (j == 0.0F) {
        break label196;
      }
      f1 = k * f2 / j;
      label72:
      if (m == 0.0F) {
        break label202;
      }
    }
    label190:
    label196:
    label202:
    for (float f2 = i * f2 / m;; f2 = 1.0F)
    {
      f1 = Math.min(1.0F, Math.min(f1, f2));
      j = Math.round(j * f1);
      m = Math.round(f1 * m);
      k = (k - j) / 2 + Math.round(this.Bj * j);
      i = (i - m) / 2;
      this.gh.setBounds(k, i, j + k, m + i);
      super.onLayout(paramBoolean, paramInt1, paramInt2, paramInt3, paramInt4);
      return;
      f2 = 1.0F;
      break;
      f1 = 1.0F;
      break label72;
    }
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    float f2 = eN() + this.AY + this.Ba * this.Bb;
    float f1 = f2 * 2.0F;
    f2 = 2.0F * f2;
    int j = View.MeasureSpec.getMode(paramInt1);
    paramInt1 = View.MeasureSpec.getSize(paramInt1);
    int i = View.MeasureSpec.getMode(paramInt2);
    paramInt2 = View.MeasureSpec.getSize(paramInt2);
    if (j == 1073741824)
    {
      if (i != 1073741824) {
        break label160;
      }
      label70:
      if (this.Bl != null) {}
      switch (this.Bl.intValue())
      {
      default: 
        i = paramInt2;
        paramInt2 = paramInt1;
        paramInt1 = i;
      }
    }
    for (;;)
    {
      super.onMeasure(View.MeasureSpec.makeMeasureSpec(paramInt2, 1073741824), View.MeasureSpec.makeMeasureSpec(paramInt1, 1073741824));
      return;
      if (j == -2147483648)
      {
        paramInt1 = (int)Math.min(f1, paramInt1);
        break;
      }
      paramInt1 = (int)f1;
      break;
      label160:
      if (i == -2147483648)
      {
        paramInt2 = (int)Math.min(f2, paramInt2);
        break label70;
      }
      paramInt2 = (int)f2;
      break label70;
      paramInt1 = paramInt2;
      continue;
      paramInt2 = paramInt1;
      i = paramInt1;
      paramInt1 = paramInt2;
      paramInt2 = i;
    }
  }
  
  protected boolean onSetAlpha(int paramInt)
  {
    return true;
  }
  
  protected void onVisibilityChanged(View paramView, int paramInt)
  {
    super.onVisibilityChanged(paramView, paramInt);
    if (paramInt != 0) {
      s(false);
    }
    while (!this.eS) {
      return;
    }
    s(true);
  }
  
  public void setPressed(boolean paramBoolean)
  {
    super.setPressed(paramBoolean);
    if (paramBoolean != this.Be)
    {
      this.Be = paramBoolean;
      invalidate();
    }
  }
  
  public final void setProgress(float paramFloat)
  {
    if (paramFloat != this.AZ)
    {
      this.AZ = paramFloat;
      invalidate();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\res\raw\android_wear_micro_apk_apk\classes.jar
 * Qualified Name:     android.support.wearable.view.CircledImageView
 * JD-Core Version:    0.7.0.1
 */