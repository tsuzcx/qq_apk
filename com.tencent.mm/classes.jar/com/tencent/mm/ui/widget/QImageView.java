package com.tencent.mm.ui.widget;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Matrix;
import android.graphics.Matrix.ScaleToFit;
import android.graphics.Paint;
import android.graphics.PaintFlagsDrawFilter;
import android.graphics.PorterDuff.Mode;
import android.graphics.PorterDuffColorFilter;
import android.graphics.RectF;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.PictureDrawable;
import android.net.Uri;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.MeasureSpec;
import android.widget.RemoteViews.RemoteView;
import com.tencent.mm.sdk.platformtools.y;

@RemoteViews.RemoteView
public class QImageView
  extends View
{
  private static final QImageView.a[] wkK = { QImageView.a.wkM, QImageView.a.wkN, QImageView.a.wkO, QImageView.a.wkP, QImageView.a.wkQ, QImageView.a.wkR, QImageView.a.wkS, QImageView.a.wkT };
  private static final Matrix.ScaleToFit[] wkL = { Matrix.ScaleToFit.FILL, Matrix.ScaleToFit.START, Matrix.ScaleToFit.CENTER, Matrix.ScaleToFit.END };
  private int JB = 255;
  private boolean adK = false;
  private int eg = 2147483647;
  private int[] gG = null;
  private Context mContext;
  private Drawable mDrawable = null;
  private Matrix mMatrix;
  private ColorFilter mR;
  private Uri mUri;
  private int sfR = 2147483647;
  private int wkA = 256;
  private boolean wkB = false;
  private boolean wkC = false;
  private int wkD = 0;
  private int wkE;
  private int wkF;
  private Matrix wkG = null;
  private final RectF wkH = new RectF();
  private final RectF wkI = new RectF();
  private boolean wkJ;
  private int wkw = 0;
  private QImageView.a wkx;
  private boolean wky = false;
  private boolean wkz = false;
  
  public QImageView(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
    this.mContext = paramContext;
    cJV();
  }
  
  public QImageView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    this.mContext = paramContext;
    cJV();
    this.adK = false;
    setAdjustViewBounds(false);
    setMaxWidth(2147483647);
    setMaxHeight(2147483647);
    this.wkJ = false;
  }
  
  private static int am(int paramInt1, int paramInt2, int paramInt3)
  {
    int i = View.MeasureSpec.getMode(paramInt3);
    paramInt3 = View.MeasureSpec.getSize(paramInt3);
    switch (i)
    {
    default: 
      return paramInt1;
    case 0: 
      return Math.min(paramInt1, paramInt2);
    case -2147483648: 
      return Math.min(Math.min(paramInt1, paramInt3), paramInt2);
    }
    return paramInt3;
  }
  
  private void cJV()
  {
    this.mMatrix = new Matrix();
    this.wkx = QImageView.a.wkP;
  }
  
  private void cJW()
  {
    Object localObject1 = null;
    if (this.mDrawable != null) {}
    Object localObject2;
    do
    {
      return;
      localObject2 = getResources();
    } while (localObject2 == null);
    if (this.wkw != 0) {}
    while (this.mUri != null)
    {
      try
      {
        localObject2 = ((Resources)localObject2).getDrawable(this.wkw);
        localObject1 = localObject2;
      }
      catch (Exception localException)
      {
        for (;;)
        {
          y.w("ImageView", "Unable to find resource: " + this.wkw, new Object[] { localException });
          this.mUri = null;
        }
      }
      t(localObject1);
      return;
    }
  }
  
  private void cJX()
  {
    Drawable localDrawable = this.mDrawable;
    if (localDrawable != null)
    {
      int j = localDrawable.getIntrinsicWidth();
      int i = j;
      if (j < 0) {
        i = this.wkE;
      }
      int k = localDrawable.getIntrinsicHeight();
      j = k;
      if (k < 0) {
        j = this.wkF;
      }
      if ((i != this.wkE) || (j != this.wkF))
      {
        this.wkE = i;
        this.wkF = j;
        requestLayout();
      }
    }
  }
  
  private void cJY()
  {
    if ((this.mDrawable == null) || (!this.wky)) {
      return;
    }
    int j = this.wkE;
    int k = this.wkF;
    int m = getWidth() - getPaddingLeft() - getPaddingRight();
    int n = getHeight() - getPaddingTop() - getPaddingBottom();
    if (((j < 0) || (m == j)) && ((k < 0) || (n == k))) {}
    for (int i = 1; (j <= 0) || (k <= 0) || (QImageView.a.wkN == this.wkx); i = 0)
    {
      this.mDrawable.setBounds(0, 0, m, n);
      this.wkG = null;
      return;
    }
    this.mDrawable.setBounds(0, 0, j, k);
    if (QImageView.a.wkM == this.wkx)
    {
      if (this.mMatrix.isIdentity())
      {
        this.wkG = null;
        return;
      }
      this.wkG = this.mMatrix;
      return;
    }
    if (i != 0)
    {
      this.wkG = null;
      return;
    }
    if (QImageView.a.wkR == this.wkx)
    {
      this.wkG = this.mMatrix;
      this.wkG.setTranslate((int)((m - j) * 0.5F + 0.5F), (int)((n - k) * 0.5F + 0.5F));
      return;
    }
    float f3;
    float f2;
    float f1;
    if (QImageView.a.wkS == this.wkx)
    {
      this.wkG = this.mMatrix;
      if (j * n > m * k)
      {
        f3 = n / k;
        f2 = (m - j * f3) * 0.5F;
        f1 = 0.0F;
      }
      for (;;)
      {
        this.wkG.setScale(f3, f3);
        this.wkG.postTranslate((int)(f2 + 0.5F), (int)(f1 + 0.5F));
        return;
        f3 = m / j;
        f1 = (n - k * f3) * 0.5F;
        f2 = 0.0F;
      }
    }
    if (QImageView.a.wkT == this.wkx)
    {
      this.wkG = this.mMatrix;
      if ((j <= m) && (k <= n)) {}
      for (f1 = 1.0F;; f1 = Math.min(m / j, n / k))
      {
        f2 = (int)((m - j * f1) * 0.5F + 0.5F);
        f3 = (int)((n - k * f1) * 0.5F + 0.5F);
        this.wkG.setScale(f1, f1);
        this.wkG.postTranslate(f2, f3);
        return;
      }
    }
    this.wkH.set(0.0F, 0.0F, j, k);
    this.wkI.set(0.0F, 0.0F, m, n);
    this.wkG = this.mMatrix;
    Matrix localMatrix = this.wkG;
    RectF localRectF1 = this.wkH;
    RectF localRectF2 = this.wkI;
    QImageView.a locala = this.wkx;
    localMatrix.setRectToRect(localRectF1, localRectF2, wkL[(locala.wkU - 1)]);
  }
  
  private void cJZ()
  {
    if ((this.mDrawable != null) && (this.wkB))
    {
      this.mDrawable = this.mDrawable.mutate();
      this.mDrawable.setColorFilter(this.mR);
      this.mDrawable.setAlpha(this.JB * this.wkA >> 8);
    }
  }
  
  private void t(Drawable paramDrawable)
  {
    if (this.mDrawable != null)
    {
      this.mDrawable.setCallback(null);
      unscheduleDrawable(this.mDrawable);
    }
    this.mDrawable = paramDrawable;
    if (paramDrawable != null)
    {
      paramDrawable.setCallback(this);
      if (paramDrawable.isStateful()) {
        paramDrawable.setState(getDrawableState());
      }
      paramDrawable.setLevel(this.wkD);
      this.wkE = paramDrawable.getIntrinsicWidth();
      this.wkF = paramDrawable.getIntrinsicHeight();
      cJZ();
      cJY();
    }
  }
  
  protected void drawableStateChanged()
  {
    super.drawableStateChanged();
    Drawable localDrawable = this.mDrawable;
    if ((localDrawable != null) && (localDrawable.isStateful())) {
      localDrawable.setState(getDrawableState());
    }
  }
  
  public int getBaseline()
  {
    if (this.adK) {
      return getMeasuredHeight();
    }
    return -1;
  }
  
  public Drawable getDrawable()
  {
    return this.mDrawable;
  }
  
  public Matrix getImageMatrix()
  {
    return this.mMatrix;
  }
  
  public QImageView.a getScaleType()
  {
    return this.wkx;
  }
  
  public void invalidateDrawable(Drawable paramDrawable)
  {
    if (paramDrawable == this.mDrawable)
    {
      invalidate();
      return;
    }
    super.invalidateDrawable(paramDrawable);
  }
  
  public int[] onCreateDrawableState(int paramInt)
  {
    if (this.gG == null) {
      return super.onCreateDrawableState(paramInt);
    }
    if (!this.wkC) {
      return this.gG;
    }
    return mergeDrawableStates(super.onCreateDrawableState(this.gG.length + paramInt), this.gG);
  }
  
  public void onDetachedFromWindow()
  {
    super.onDetachedFromWindow();
  }
  
  public void onDraw(Canvas paramCanvas)
  {
    paramCanvas.setDrawFilter(new PaintFlagsDrawFilter(0, 3));
    super.onDraw(paramCanvas);
    if (this.mDrawable == null) {}
    while ((this.wkE == 0) || (this.wkF == 0)) {
      return;
    }
    if ((this.wkG == null) && (getPaddingTop() == 0) && (getPaddingLeft() == 0))
    {
      this.mDrawable.draw(paramCanvas);
      return;
    }
    int i = paramCanvas.getSaveCount();
    paramCanvas.save();
    if (this.wkJ)
    {
      int j = getScrollX();
      int k = getScrollY();
      paramCanvas.clipRect(getPaddingLeft() + j, getPaddingTop() + k, j + getRight() - getLeft() - getPaddingRight(), k + getBottom() - getTop() - getPaddingBottom());
    }
    paramCanvas.translate(getPaddingLeft(), getPaddingTop());
    if (this.wkG != null) {
      paramCanvas.concat(this.wkG);
    }
    this.mDrawable.draw(paramCanvas);
    paramCanvas.restoreToCount(i);
  }
  
  public void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    this.wky = true;
    cJY();
  }
  
  public void onMeasure(int paramInt1, int paramInt2)
  {
    cJW();
    float f = 0.0F;
    int k = 0;
    int m = 0;
    int j;
    int i;
    if (this.mDrawable == null)
    {
      this.wkE = -1;
      this.wkF = -1;
      j = 0;
      i = 0;
    }
    label391:
    label394:
    label405:
    for (;;)
    {
      int i2 = getPaddingLeft();
      int i3 = getPaddingRight();
      int n = getPaddingTop();
      int i1 = getPaddingBottom();
      if ((k != 0) || (m != 0))
      {
        paramInt1 = am(i + i2 + i3, this.eg, paramInt1);
        paramInt2 = am(j + n + i1, this.sfR, paramInt2);
        if ((f == 0.0F) || (Math.abs((paramInt1 - i2 - i3) / (paramInt2 - n - i1) - f) <= 1.0E-007D)) {
          break label394;
        }
        i = 0;
        if (k == 0) {
          break label391;
        }
        j = (int)((paramInt2 - n - i1) * f) + i2 + i3;
        if (j > paramInt1) {
          break label391;
        }
        i = 1;
        paramInt1 = j;
        label178:
        if ((i != 0) || (m == 0)) {
          break label380;
        }
        i = (int)((paramInt1 - i2 - i3) / f) + n + i1;
        if (i > paramInt2) {
          break label380;
        }
        paramInt2 = paramInt1;
        paramInt1 = i;
      }
      for (;;)
      {
        setMeasuredDimension(paramInt2, paramInt1);
        return;
        j = this.wkE;
        n = this.wkF;
        i = j;
        if (j <= 0) {
          i = 1;
        }
        j = n;
        if (n <= 0) {
          j = 1;
        }
        if (!this.wkz) {
          break label405;
        }
        k = View.MeasureSpec.getMode(paramInt1);
        m = View.MeasureSpec.getMode(paramInt2);
        if (k != 1073741824)
        {
          k = 1;
          label291:
          if (m == 1073741824) {
            break label319;
          }
        }
        label319:
        for (m = 1;; m = 0)
        {
          f = i / j;
          break;
          k = 0;
          break label291;
        }
        i = Math.max(i2 + i3 + i, getSuggestedMinimumWidth());
        j = Math.max(j + (n + i1), getSuggestedMinimumHeight());
        i = resolveSize(i, paramInt1);
        paramInt1 = resolveSize(j, paramInt2);
        paramInt2 = i;
        continue;
        label380:
        i = paramInt1;
        paramInt1 = paramInt2;
        paramInt2 = i;
        continue;
        break label178;
        i = paramInt1;
        paramInt1 = paramInt2;
        paramInt2 = i;
      }
    }
  }
  
  protected boolean onSetAlpha(int paramInt)
  {
    if (getBackground() == null)
    {
      paramInt = (paramInt >> 7) + paramInt;
      if (this.wkA != paramInt)
      {
        this.wkA = paramInt;
        this.wkB = true;
        cJZ();
      }
      return true;
    }
    return false;
  }
  
  public void setAdjustViewBounds(boolean paramBoolean)
  {
    this.wkz = paramBoolean;
    if (paramBoolean) {
      setScaleType(QImageView.a.wkP);
    }
  }
  
  public void setAlpha(int paramInt)
  {
    paramInt &= 0xFF;
    if (this.JB != paramInt)
    {
      this.JB = paramInt;
      this.wkB = true;
      cJZ();
      invalidate();
    }
  }
  
  public void setBackgroundDrawable(Drawable paramDrawable)
  {
    super.setBackgroundDrawable(paramDrawable);
  }
  
  public final void setColorFilter(int paramInt)
  {
    setColorFilter(new PorterDuffColorFilter(paramInt, PorterDuff.Mode.SRC_ATOP));
  }
  
  public void setColorFilter(ColorFilter paramColorFilter)
  {
    if (this.mR != paramColorFilter)
    {
      this.mR = paramColorFilter;
      this.wkB = true;
      cJZ();
      invalidate();
    }
  }
  
  public void setImageBitmap(Bitmap paramBitmap)
  {
    setImageDrawable(new BitmapDrawable(this.mContext.getResources(), paramBitmap));
  }
  
  public void setImageDrawable(Drawable paramDrawable)
  {
    if (this.mDrawable != paramDrawable)
    {
      this.wkw = 0;
      this.mUri = null;
      t(paramDrawable);
      invalidate();
    }
  }
  
  public void setImageLevel(int paramInt)
  {
    this.wkD = paramInt;
    if (this.mDrawable != null)
    {
      this.mDrawable.setLevel(paramInt);
      cJX();
    }
  }
  
  public void setImageMatrix(Matrix paramMatrix)
  {
    Matrix localMatrix = paramMatrix;
    if (paramMatrix != null)
    {
      localMatrix = paramMatrix;
      if (paramMatrix.isIdentity()) {
        localMatrix = null;
      }
    }
    if (((localMatrix == null) && (!this.mMatrix.isIdentity())) || ((localMatrix != null) && (!this.mMatrix.equals(localMatrix))))
    {
      this.mMatrix.set(localMatrix);
      cJY();
      invalidate();
    }
  }
  
  public void setImageResource(int paramInt)
  {
    if ((this.mUri != null) || (this.wkw != paramInt))
    {
      t(null);
      this.wkw = paramInt;
      this.mUri = null;
      cJW();
      invalidate();
    }
  }
  
  public void setImageURI(Uri paramUri)
  {
    if ((this.wkw != 0) || ((this.mUri != paramUri) && ((paramUri == null) || (this.mUri == null) || (!paramUri.equals(this.mUri)))))
    {
      t(null);
      this.wkw = 0;
      this.mUri = paramUri;
      cJW();
      invalidate();
    }
  }
  
  @TargetApi(11)
  public void setLayerType(int paramInt, Paint paramPaint)
  {
    if (((getDrawable() instanceof PictureDrawable)) && (paramInt != 1)) {
      return;
    }
    super.setLayerType(paramInt, paramPaint);
  }
  
  public void setMaxHeight(int paramInt)
  {
    this.sfR = paramInt;
  }
  
  public void setMaxWidth(int paramInt)
  {
    this.eg = paramInt;
  }
  
  public void setScaleType(QImageView.a parama)
  {
    if (parama == null) {
      throw new NullPointerException();
    }
    if (this.wkx != parama)
    {
      this.wkx = parama;
      if (this.wkx != QImageView.a.wkR) {
        break label51;
      }
    }
    label51:
    for (boolean bool = true;; bool = false)
    {
      setWillNotCacheDrawing(bool);
      requestLayout();
      invalidate();
      return;
    }
  }
  
  public void setSelected(boolean paramBoolean)
  {
    super.setSelected(paramBoolean);
    cJX();
  }
  
  protected boolean verifyDrawable(Drawable paramDrawable)
  {
    return (this.mDrawable == paramDrawable) || (super.verifyDrawable(paramDrawable));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.ui.widget.QImageView
 * JD-Core Version:    0.7.0.1
 */