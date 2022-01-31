package android.support.wearable.view;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.graphics.RadialGradient;
import android.graphics.Shader.TileMode;
import android.support.wearable.j;
import android.support.wearable.k;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.ViewPropertyAnimator;

@TargetApi(20)
public class DotsPageIndicator
  extends View
  implements n, o
{
  private int BU;
  private float BV;
  private float BW;
  private int BX;
  private int BY;
  private boolean BZ;
  private int Ca;
  private int Cb;
  private int Cc;
  private float Cd;
  private float Ce;
  private float Cf;
  private int Cg;
  private int Ch;
  private int Ci;
  private int Cj;
  private int Ck;
  private final Paint Cl;
  private final Paint Cm;
  private final Paint Cn;
  private final Paint Co;
  private boolean Cp;
  private GridViewPager Cq;
  private o Cr;
  private n Cs;
  private i zN;
  
  public DotsPageIndicator(Context paramContext)
  {
    this(paramContext, null);
  }
  
  public DotsPageIndicator(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public DotsPageIndicator(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    paramContext = getContext().obtainStyledAttributes(paramAttributeSet, k.xP, 0, j.wJ);
    this.BU = paramContext.getDimensionPixelOffset(k.xQ, 0);
    this.BV = paramContext.getDimension(k.xR, 0.0F);
    this.BW = paramContext.getDimension(k.xS, 0.0F);
    this.BX = paramContext.getColor(k.xT, 0);
    this.BY = paramContext.getColor(k.xU, 0);
    this.Ca = paramContext.getInt(k.xW, 0);
    this.Cb = paramContext.getInt(k.xX, 0);
    this.Cc = paramContext.getInt(k.xY, 0);
    this.BZ = paramContext.getBoolean(k.xV, false);
    this.Cd = paramContext.getDimension(k.yb, 0.0F);
    this.Ce = paramContext.getDimension(k.yc, 0.0F);
    this.Cf = paramContext.getDimension(k.ya, 0.0F);
    this.Cg = paramContext.getColor(k.xZ, 0);
    paramContext.recycle();
    this.Cl = new Paint(1);
    this.Cl.setColor(this.BX);
    this.Cl.setStyle(Paint.Style.FILL);
    this.Cn = new Paint(1);
    this.Cn.setColor(this.BY);
    this.Cn.setStyle(Paint.Style.FILL);
    this.Cm = new Paint(1);
    this.Co = new Paint(1);
    this.Ck = 0;
    if (isInEditMode())
    {
      this.Ch = 5;
      this.Ci = 2;
      this.BZ = false;
    }
    if (this.BZ)
    {
      this.Cp = false;
      animate().alpha(0.0F).setStartDelay(2000L).setDuration(this.Cb).start();
    }
    for (;;)
    {
      a(this.Cl, this.Cm, this.BV, this.Cf, this.BX, this.Cg);
      a(this.Cn, this.Co, this.BW, this.Cf, this.BY, this.Cg);
      return;
      animate().cancel();
      setAlpha(1.0F);
    }
  }
  
  private void M(int paramInt1, int paramInt2)
  {
    this.Cj = paramInt1;
    this.zN.fa();
    if (2 != this.Ch)
    {
      this.Ch = 2;
      this.Ci = paramInt2;
      requestLayout();
    }
    while (paramInt2 == this.Ci) {
      return;
    }
    this.Ci = paramInt2;
    invalidate();
  }
  
  private static void a(Paint paramPaint1, Paint paramPaint2, float paramFloat1, float paramFloat2, int paramInt1, int paramInt2)
  {
    paramFloat2 = paramFloat1 + paramFloat2;
    paramFloat1 /= paramFloat2;
    Shader.TileMode localTileMode = Shader.TileMode.CLAMP;
    paramPaint2.setShader(new RadialGradient(0.0F, 0.0F, paramFloat2, new int[] { paramInt2, paramInt2, 0 }, new float[] { 0.0F, paramFloat1, 1.0F }, localTileMode));
    paramPaint1.setColor(paramInt1);
    paramPaint1.setStyle(Paint.Style.FILL);
  }
  
  private void b(long paramLong)
  {
    this.Cp = false;
    animate().cancel();
    animate().alpha(0.0F).setStartDelay(paramLong).setDuration(this.Cb).start();
  }
  
  private void eY()
  {
    this.Cp = true;
    animate().cancel();
    animate().alpha(1.0F).setStartDelay(0L).setDuration(this.Cc).setListener(new u()
    {
      public final void eZ()
      {
        DotsPageIndicator.a(DotsPageIndicator.this);
        DotsPageIndicator.this.animate().alpha(0.0F).setListener(null).setStartDelay(DotsPageIndicator.c(DotsPageIndicator.this)).setDuration(DotsPageIndicator.b(DotsPageIndicator.this)).start();
      }
    }).start();
  }
  
  public final void L(int paramInt1, int paramInt2)
  {
    if (paramInt1 != this.Cj) {
      M(paramInt1, paramInt2);
    }
    for (;;)
    {
      if (this.Cr != null) {
        this.Cr.L(paramInt1, paramInt2);
      }
      return;
      if (paramInt2 != this.Ci)
      {
        this.Ci = paramInt2;
        invalidate();
      }
    }
  }
  
  public final void a(int paramInt1, int paramInt2, float paramFloat1, float paramFloat2, int paramInt3, int paramInt4)
  {
    if ((this.BZ) && (this.Ck == 1))
    {
      if (paramFloat2 == 0.0F) {
        break label90;
      }
      if (!this.Cp)
      {
        this.Cp = true;
        animate().cancel();
        animate().alpha(1.0F).setStartDelay(0L).setDuration(this.Cc).start();
      }
    }
    for (;;)
    {
      if (this.Cr != null) {
        this.Cr.a(paramInt1, paramInt2, paramFloat1, paramFloat2, paramInt3, paramInt4);
      }
      return;
      label90:
      if (this.Cp) {
        b(0L);
      }
    }
  }
  
  public final void a(GridViewPager paramGridViewPager)
  {
    if (this.Cq != paramGridViewPager)
    {
      if (this.Cq != null)
      {
        this.Cq.a(null);
        this.Cq.a(null);
        this.Cq = null;
      }
      this.Cq = paramGridViewPager;
      if (this.Cq != null)
      {
        this.Cq.a(this);
        this.Cq.a(this);
        this.zN = this.Cq.fk();
      }
    }
    if (this.zN != null)
    {
      this.zN.getRowCount();
      M(0, 0);
    }
  }
  
  public final void a(i parami1, i parami2)
  {
    this.zN = parami2;
    if (this.zN != null)
    {
      M(0, 0);
      if (this.BZ) {
        eY();
      }
    }
    if (this.Cs != null) {
      this.Cs.a(parami1, parami2);
    }
  }
  
  public final void eW()
  {
    if (this.BX != 2131427362)
    {
      this.BX = 2131427362;
      invalidate();
    }
  }
  
  public final void eX()
  {
    if (this.BY != 2131427363)
    {
      this.BY = 2131427363;
      invalidate();
    }
  }
  
  public final void onDataSetChanged()
  {
    if (this.zN != null)
    {
      this.zN.getRowCount();
      M(0, 0);
    }
    if (this.Cs != null) {
      this.Cs.onDataSetChanged();
    }
  }
  
  protected void onDraw(Canvas paramCanvas)
  {
    super.onDraw(paramCanvas);
    if (this.Ch > 1)
    {
      float f1 = getPaddingLeft();
      float f2 = this.BU / 2.0F;
      float f3 = getHeight() / 2.0F;
      paramCanvas.save();
      paramCanvas.translate(f1 + f2, f3);
      int i = 0;
      if (i < this.Ch)
      {
        if (i == this.Ci)
        {
          f1 = this.BW;
          f2 = this.Cf;
          paramCanvas.drawCircle(this.Cd, this.Ce, f1 + f2, this.Co);
          paramCanvas.drawCircle(0.0F, 0.0F, this.BW, this.Cn);
        }
        for (;;)
        {
          paramCanvas.translate(this.BU, 0.0F);
          i += 1;
          break;
          f1 = this.BV;
          f2 = this.Cf;
          paramCanvas.drawCircle(this.Cd, this.Ce, f1 + f2, this.Cm);
          paramCanvas.drawCircle(0.0F, 0.0F, this.BV, this.Cl);
        }
      }
      paramCanvas.restore();
    }
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    int i;
    if (View.MeasureSpec.getMode(paramInt1) == 1073741824)
    {
      i = View.MeasureSpec.getSize(paramInt1);
      if (View.MeasureSpec.getMode(paramInt2) != 1073741824) {
        break label72;
      }
    }
    label72:
    for (int j = View.MeasureSpec.getSize(paramInt2);; j = (int)((int)Math.ceil(Math.max(this.BV + this.Cf, this.BW + this.Cf) * 2.0F) + this.Ce) + getPaddingTop() + getPaddingBottom())
    {
      setMeasuredDimension(resolveSizeAndState(i, paramInt1, 0), resolveSizeAndState(j, paramInt2, 0));
      return;
      i = this.Ch * this.BU + getPaddingLeft() + getPaddingRight();
      break;
    }
  }
  
  public final void y(int paramInt)
  {
    if (this.Ck != paramInt)
    {
      this.Ck = paramInt;
      if ((this.BZ) && (paramInt == 0))
      {
        if (!this.Cp) {
          break label58;
        }
        b(this.Ca);
      }
    }
    for (;;)
    {
      if (this.Cr != null) {
        this.Cr.y(paramInt);
      }
      return;
      label58:
      eY();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\res\raw\android_wear_micro_apk_apk\classes.jar
 * Qualified Name:     android.support.wearable.view.DotsPageIndicator
 * JD-Core Version:    0.7.0.1
 */