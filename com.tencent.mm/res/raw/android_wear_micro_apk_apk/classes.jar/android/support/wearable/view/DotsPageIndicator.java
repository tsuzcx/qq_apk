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
  private i BC;
  private int DJ;
  private float DK;
  private float DL;
  private int DM;
  private int DN;
  private boolean DO;
  private int DP;
  private int DQ;
  private int DR;
  private float DS;
  private float DT;
  private float DU;
  private int DV;
  private int DW;
  private int DX;
  private int DY;
  private int DZ;
  private final Paint Ea;
  private final Paint Eb;
  private final Paint Ec;
  private final Paint Ed;
  private boolean Ee;
  private GridViewPager Ef;
  private o Eg;
  private n Eh;
  
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
    paramContext = getContext().obtainStyledAttributes(paramAttributeSet, k.zE, 0, j.yy);
    this.DJ = paramContext.getDimensionPixelOffset(k.zF, 0);
    this.DK = paramContext.getDimension(k.zG, 0.0F);
    this.DL = paramContext.getDimension(k.zH, 0.0F);
    this.DM = paramContext.getColor(k.zI, 0);
    this.DN = paramContext.getColor(k.zJ, 0);
    this.DP = paramContext.getInt(k.zL, 0);
    this.DQ = paramContext.getInt(k.zM, 0);
    this.DR = paramContext.getInt(k.zN, 0);
    this.DO = paramContext.getBoolean(k.zK, false);
    this.DS = paramContext.getDimension(k.zQ, 0.0F);
    this.DT = paramContext.getDimension(k.zR, 0.0F);
    this.DU = paramContext.getDimension(k.zP, 0.0F);
    this.DV = paramContext.getColor(k.zO, 0);
    paramContext.recycle();
    this.Ea = new Paint(1);
    this.Ea.setColor(this.DM);
    this.Ea.setStyle(Paint.Style.FILL);
    this.Ec = new Paint(1);
    this.Ec.setColor(this.DN);
    this.Ec.setStyle(Paint.Style.FILL);
    this.Eb = new Paint(1);
    this.Ed = new Paint(1);
    this.DZ = 0;
    if (isInEditMode())
    {
      this.DW = 5;
      this.DX = 2;
      this.DO = false;
    }
    if (this.DO)
    {
      this.Ee = false;
      animate().alpha(0.0F).setStartDelay(2000L).setDuration(this.DQ).start();
    }
    for (;;)
    {
      a(this.Ea, this.Eb, this.DK, this.DU, this.DM, this.DV);
      a(this.Ec, this.Ed, this.DL, this.DU, this.DN, this.DV);
      return;
      animate().cancel();
      setAlpha(1.0F);
    }
  }
  
  private void O(int paramInt1, int paramInt2)
  {
    this.DY = paramInt1;
    if (2 != this.DW)
    {
      this.DW = 2;
      this.DX = paramInt2;
      requestLayout();
    }
    while (paramInt2 == this.DX) {
      return;
    }
    this.DX = paramInt2;
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
  
  private void c(long paramLong)
  {
    this.Ee = false;
    animate().cancel();
    animate().alpha(0.0F).setStartDelay(paramLong).setDuration(this.DQ).start();
  }
  
  private void fo()
  {
    this.Ee = true;
    animate().cancel();
    animate().alpha(1.0F).setStartDelay(0L).setDuration(this.DR).setListener(new u()
    {
      public final void fp()
      {
        DotsPageIndicator.a(DotsPageIndicator.this);
        DotsPageIndicator.this.animate().alpha(0.0F).setListener(null).setStartDelay(DotsPageIndicator.c(DotsPageIndicator.this)).setDuration(DotsPageIndicator.b(DotsPageIndicator.this)).start();
      }
    }).start();
  }
  
  public final void J(int paramInt)
  {
    if (this.DZ != paramInt)
    {
      this.DZ = paramInt;
      if ((this.DO) && (paramInt == 0))
      {
        if (!this.Ee) {
          break label58;
        }
        c(this.DP);
      }
    }
    for (;;)
    {
      if (this.Eg != null) {
        this.Eg.J(paramInt);
      }
      return;
      label58:
      fo();
    }
  }
  
  public final void N(int paramInt1, int paramInt2)
  {
    if (paramInt1 != this.DY) {
      O(paramInt1, paramInt2);
    }
    for (;;)
    {
      if (this.Eg != null) {
        this.Eg.N(paramInt1, paramInt2);
      }
      return;
      if (paramInt2 != this.DX)
      {
        this.DX = paramInt2;
        invalidate();
      }
    }
  }
  
  public final void a(int paramInt1, int paramInt2, float paramFloat1, float paramFloat2, int paramInt3, int paramInt4)
  {
    if ((this.DO) && (this.DZ == 1))
    {
      if (paramFloat2 == 0.0F) {
        break label90;
      }
      if (!this.Ee)
      {
        this.Ee = true;
        animate().cancel();
        animate().alpha(1.0F).setStartDelay(0L).setDuration(this.DR).start();
      }
    }
    for (;;)
    {
      if (this.Eg != null) {
        this.Eg.a(paramInt1, paramInt2, paramFloat1, paramFloat2, paramInt3, paramInt4);
      }
      return;
      label90:
      if (this.Ee) {
        c(0L);
      }
    }
  }
  
  public final void a(GridViewPager paramGridViewPager)
  {
    if (this.Ef != paramGridViewPager)
    {
      if (this.Ef != null)
      {
        this.Ef.a(null);
        this.Ef.a(null);
        this.Ef = null;
      }
      this.Ef = paramGridViewPager;
      if (this.Ef != null)
      {
        this.Ef.a(this);
        this.Ef.a(this);
        this.BC = this.Ef.ft();
      }
    }
    if (this.BC != null) {
      O(0, 0);
    }
  }
  
  public final void a(i parami1, i parami2)
  {
    this.BC = parami2;
    if (this.BC != null)
    {
      O(0, 0);
      if (this.DO) {
        fo();
      }
    }
    if (this.Eh != null) {
      this.Eh.a(parami1, parami2);
    }
  }
  
  public final void fm()
  {
    if (this.DM != 2131427362)
    {
      this.DM = 2131427362;
      invalidate();
    }
  }
  
  public final void fn()
  {
    if (this.DN != 2131427363)
    {
      this.DN = 2131427363;
      invalidate();
    }
  }
  
  public final void onDataSetChanged()
  {
    if (this.BC != null) {
      O(0, 0);
    }
    if (this.Eh != null) {
      this.Eh.onDataSetChanged();
    }
  }
  
  protected void onDraw(Canvas paramCanvas)
  {
    super.onDraw(paramCanvas);
    if (this.DW > 1)
    {
      float f1 = getPaddingLeft();
      float f2 = this.DJ / 2.0F;
      float f3 = getHeight() / 2.0F;
      paramCanvas.save();
      paramCanvas.translate(f1 + f2, f3);
      int i = 0;
      if (i < this.DW)
      {
        if (i == this.DX)
        {
          f1 = this.DL;
          f2 = this.DU;
          paramCanvas.drawCircle(this.DS, this.DT, f1 + f2, this.Ed);
          paramCanvas.drawCircle(0.0F, 0.0F, this.DL, this.Ec);
        }
        for (;;)
        {
          paramCanvas.translate(this.DJ, 0.0F);
          i += 1;
          break;
          f1 = this.DK;
          f2 = this.DU;
          paramCanvas.drawCircle(this.DS, this.DT, f1 + f2, this.Eb);
          paramCanvas.drawCircle(0.0F, 0.0F, this.DK, this.Ea);
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
    for (int j = View.MeasureSpec.getSize(paramInt2);; j = (int)((int)Math.ceil(Math.max(this.DK + this.DU, this.DL + this.DU) * 2.0F) + this.DT) + getPaddingTop() + getPaddingBottom())
    {
      setMeasuredDimension(resolveSizeAndState(i, paramInt1, 0), resolveSizeAndState(j, paramInt2, 0));
      return;
      i = this.DW * this.DJ + getPaddingLeft() + getPaddingRight();
      break;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\res\raw\android_wear_micro_apk_apk\classes.jar
 * Qualified Name:     android.support.wearable.view.DotsPageIndicator
 * JD-Core Version:    0.7.0.1
 */