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
  private static final ArgbEvaluator CE = new ArgbEvaluator();
  private final RectF CF;
  private ColorStateList CG;
  private float CH;
  private float CI;
  private float CJ;
  private float CK;
  private float CL;
  private int CM;
  private float CN;
  private float CO = 1.0F;
  private final float CP;
  private float CQ;
  private boolean CR = false;
  private float CS;
  private boolean CT = false;
  private s CU;
  private Rect CV = new Rect();
  private long CW = 0L;
  private float CX = 1.0F;
  private float CY = 0.0F;
  private Integer CZ;
  private Integer Da;
  private final Drawable.Callback Db = new Drawable.Callback()
  {
    public final void invalidateDrawable(Drawable paramAnonymousDrawable)
    {
      CircledImageView.this.invalidate();
    }
    
    public final void scheduleDrawable(Drawable paramAnonymousDrawable, Runnable paramAnonymousRunnable, long paramAnonymousLong) {}
    
    public final void unscheduleDrawable(Drawable paramAnonymousDrawable, Runnable paramAnonymousRunnable) {}
  };
  private final ValueAnimator.AnimatorUpdateListener Dc = new ValueAnimator.AnimatorUpdateListener()
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
  private ValueAnimator Dd;
  private boolean gH;
  private int hY;
  private Drawable ie;
  private final Paint pq;
  
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
    paramContext = getContext().obtainStyledAttributes(paramAttributeSet, k.zh);
    this.ie = paramContext.getDrawable(k.zi);
    this.CG = paramContext.getColorStateList(k.zj);
    if (this.CG == null) {
      this.CG = ColorStateList.valueOf(17170432);
    }
    this.CH = paramContext.getDimension(k.zk, 0.0F);
    this.CS = this.CH;
    this.CJ = paramContext.getDimension(k.zl, this.CH);
    this.CM = paramContext.getColor(k.zn, -16777216);
    this.CN = paramContext.getDimension(k.zm, 0.0F);
    if (this.CN > 0.0F) {
      this.CL += this.CN;
    }
    float f = paramContext.getDimension(k.zo, 0.0F);
    if (f > 0.0F) {
      this.CL = (f + this.CL);
    }
    this.CP = paramContext.getDimension(k.zp, 0.0F);
    this.CX = paramContext.getFloat(k.zq, 0.0F);
    this.CY = paramContext.getFloat(k.zr, 0.0F);
    if (paramContext.hasValue(k.zs)) {
      this.CZ = Integer.valueOf(paramContext.getColor(k.zs, 0));
    }
    if (paramContext.hasValue(k.zv)) {
      this.Da = Integer.valueOf(paramContext.getInt(k.zv, 0));
    }
    this.CI = paramContext.getFraction(k.zt, 1, 1, 0.0F);
    this.CK = paramContext.getFraction(k.zu, 1, 1, this.CI);
    paramContext.recycle();
    this.CF = new RectF();
    this.pq = new Paint();
    this.pq.setAntiAlias(true);
    this.CU = new s();
    this.CU.setCallback(this.Db);
    setWillNotDraw(false);
    fb();
  }
  
  private void fb()
  {
    int i = this.CG.getColorForState(getDrawableState(), this.CG.getDefaultColor());
    if (this.CW > 0L) {
      if (this.Dd != null)
      {
        this.Dd.cancel();
        this.Dd.setIntValues(new int[] { this.hY, i });
        this.Dd.setEvaluator(CE);
        this.Dd.setDuration(this.CW);
        this.Dd.addUpdateListener(this.Dc);
        this.Dd.start();
      }
    }
    while (i == this.hY) {
      for (;;)
      {
        return;
        this.Dd = new ValueAnimator();
      }
    }
    this.hY = i;
    invalidate();
  }
  
  private float fd()
  {
    float f2 = this.CH;
    float f1 = f2;
    if (this.CH <= 0.0F)
    {
      f1 = f2;
      if (this.CI > 0.0F) {
        f1 = Math.max(getMeasuredHeight(), getMeasuredWidth()) * this.CI;
      }
    }
    return f1 - this.CL;
  }
  
  private void v(boolean paramBoolean)
  {
    this.gH = paramBoolean;
    if (this.CU != null)
    {
      if (paramBoolean) {
        this.CU.fz();
      }
    }
    else {
      return;
    }
    this.CU.fA();
  }
  
  protected void drawableStateChanged()
  {
    super.drawableStateChanged();
    fb();
  }
  
  public final void fc()
  {
    Drawable localDrawable1 = getContext().getDrawable(2130837507);
    int i;
    if (localDrawable1 != this.ie)
    {
      Drawable localDrawable2 = this.ie;
      this.ie = localDrawable1;
      if ((localDrawable1 == null) || (localDrawable2 == null) || (localDrawable2.getIntrinsicHeight() != localDrawable1.getIntrinsicHeight()) || (localDrawable2.getIntrinsicWidth() != localDrawable1.getIntrinsicWidth())) {
        break label81;
      }
      i = 1;
      if (i == 0) {
        break label86;
      }
      this.ie.setBounds(localDrawable2.getBounds());
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
  
  public final void fe()
  {
    if (28.0F != this.CH)
    {
      this.CH = 28.0F;
      invalidate();
    }
  }
  
  public final void ff()
  {
    this.CM = -1;
  }
  
  public final void fg()
  {
    if (5.0F != this.CN)
    {
      this.CN = 5.0F;
      invalidate();
    }
  }
  
  protected void onDraw(Canvas paramCanvas)
  {
    int i = getPaddingLeft();
    int j = getPaddingTop();
    float f1;
    if (this.CT)
    {
      float f2 = this.CJ;
      f1 = f2;
      if (this.CJ <= 0.0F)
      {
        f1 = f2;
        if (this.CK > 0.0F) {
          f1 = Math.max(getMeasuredHeight(), getMeasuredWidth()) * this.CK;
        }
      }
      f1 -= this.CL;
      if ((this.CP > 0.0F) && (this.CQ > 0.0F))
      {
        this.CF.set(i, j, getWidth() - getPaddingRight(), getHeight() - getPaddingBottom());
        f2 = this.CN + f1 + this.CP * this.CQ;
        this.pq.setColor(-16777216);
        this.pq.setAlpha(Math.round(this.pq.getAlpha() * getAlpha()));
        this.pq.setStyle(Paint.Style.FILL);
        Paint localPaint = this.pq;
        float f3 = this.CF.centerX();
        float f4 = this.CF.centerY();
        Shader.TileMode localTileMode = Shader.TileMode.MIRROR;
        localPaint.setShader(new RadialGradient(f3, f4, f2, new int[] { -16777216, 0 }, new float[] { 0.6F, 1.0F }, localTileMode));
        paramCanvas.drawCircle(this.CF.centerX(), this.CF.centerY(), f2, this.pq);
        this.pq.setShader(null);
      }
      if (this.CN > 0.0F)
      {
        this.CF.set(i, j, getWidth() - getPaddingRight(), getHeight() - getPaddingBottom());
        this.CF.set(this.CF.centerX() - f1, this.CF.centerY() - f1, this.CF.centerX() + f1, this.CF.centerY() + f1);
        this.pq.setColor(this.CM);
        this.pq.setAlpha(Math.round(this.pq.getAlpha() * getAlpha()));
        this.pq.setStyle(Paint.Style.STROKE);
        this.pq.setStrokeWidth(this.CN);
        if (!this.gH) {
          break label661;
        }
        this.CF.roundOut(this.CV);
        this.CU.setBounds(this.CV);
        this.CU.bq(this.CM);
        this.CU.y(this.CN);
        this.CU.draw(paramCanvas);
      }
    }
    for (;;)
    {
      if (!this.CR)
      {
        this.CF.set(i, j, getWidth() - getPaddingRight(), getHeight() - getPaddingBottom());
        this.pq.setColor(this.hY);
        this.pq.setAlpha(Math.round(this.pq.getAlpha() * getAlpha()));
        this.pq.setStyle(Paint.Style.FILL);
        paramCanvas.drawCircle(this.CF.centerX(), this.CF.centerY(), f1, this.pq);
      }
      if (this.ie != null)
      {
        this.ie.setAlpha(Math.round(getAlpha() * 255.0F));
        if (this.CZ != null) {
          this.ie.setTint(this.CZ.intValue());
        }
        this.ie.draw(paramCanvas);
      }
      super.onDraw(paramCanvas);
      return;
      f1 = fd();
      break;
      label661:
      paramCanvas.drawArc(this.CF, -90.0F, this.CO * 360.0F, false, this.pq);
    }
  }
  
  protected void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    int j;
    int m;
    int k;
    int i;
    float f1;
    if (this.ie != null)
    {
      j = this.ie.getIntrinsicWidth();
      m = this.ie.getIntrinsicHeight();
      k = getMeasuredWidth();
      i = getMeasuredHeight();
      if (this.CX <= 0.0F) {
        break label190;
      }
      f2 = this.CX;
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
      k = (k - j) / 2 + Math.round(this.CY * j);
      i = (i - m) / 2;
      this.ie.setBounds(k, i, j + k, m + i);
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
    float f2 = fd() + this.CN + this.CP * this.CQ;
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
      if (this.Da != null) {}
      switch (this.Da.intValue())
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
      v(false);
    }
    while (!this.gH) {
      return;
    }
    v(true);
  }
  
  public void setPressed(boolean paramBoolean)
  {
    super.setPressed(paramBoolean);
    if (paramBoolean != this.CT)
    {
      this.CT = paramBoolean;
      invalidate();
    }
  }
  
  public final void setProgress(float paramFloat)
  {
    if (paramFloat != this.CO)
    {
      this.CO = paramFloat;
      invalidate();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\res\raw\android_wear_micro_apk_apk\classes.jar
 * Qualified Name:     android.support.wearable.view.CircledImageView
 * JD-Core Version:    0.7.0.1
 */