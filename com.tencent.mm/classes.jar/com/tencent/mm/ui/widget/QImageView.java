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
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;

@RemoteViews.RemoteView
public class QImageView
  extends View
{
  private static final QImageView.a[] AEv = { QImageView.a.AEx, QImageView.a.AEy, QImageView.a.AEz, QImageView.a.AEA, QImageView.a.AEB, QImageView.a.AEC, QImageView.a.AED, QImageView.a.AEE };
  private static final Matrix.ScaleToFit[] AEw = { Matrix.ScaleToFit.FILL, Matrix.ScaleToFit.START, Matrix.ScaleToFit.CENTER, Matrix.ScaleToFit.END };
  private int AEh;
  private QImageView.a AEi;
  private boolean AEj;
  private boolean AEk;
  private int AEl;
  private boolean AEm;
  private boolean AEn;
  private int AEo;
  private int AEp;
  private int AEq;
  private Matrix AEr;
  private final RectF AEs;
  private final RectF AEt;
  private boolean AEu;
  private boolean afZ;
  private int[] hz;
  private int mAlpha;
  private Context mContext;
  private Drawable mDrawable;
  private Matrix mMatrix;
  private int mMaxHeight;
  private int mMaxWidth;
  private Uri mUri;
  private ColorFilter nO;
  
  public QImageView(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
    AppMethodBeat.i(115516);
    this.mContext = paramContext;
    dOO();
    AppMethodBeat.o(115516);
  }
  
  public QImageView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(115517);
    this.AEh = 0;
    this.AEj = false;
    this.AEk = false;
    this.mMaxWidth = 2147483647;
    this.mMaxHeight = 2147483647;
    this.mAlpha = 255;
    this.AEl = 256;
    this.AEm = false;
    this.mDrawable = null;
    this.hz = null;
    this.AEn = false;
    this.AEo = 0;
    this.AEr = null;
    this.AEs = new RectF();
    this.AEt = new RectF();
    this.afZ = false;
    this.mContext = paramContext;
    dOO();
    this.afZ = false;
    setAdjustViewBounds(false);
    setMaxWidth(2147483647);
    setMaxHeight(2147483647);
    this.AEu = false;
    AppMethodBeat.o(115517);
  }
  
  private static Matrix.ScaleToFit a(QImageView.a parama)
  {
    return AEw[(parama.AEF - 1)];
  }
  
  private static int ay(int paramInt1, int paramInt2, int paramInt3)
  {
    AppMethodBeat.i(115538);
    int i = View.MeasureSpec.getMode(paramInt3);
    paramInt3 = View.MeasureSpec.getSize(paramInt3);
    switch (i)
    {
    }
    for (;;)
    {
      AppMethodBeat.o(115538);
      return paramInt1;
      paramInt1 = Math.min(paramInt1, paramInt2);
      continue;
      paramInt1 = Math.min(Math.min(paramInt1, paramInt3), paramInt2);
      continue;
      paramInt1 = paramInt3;
    }
  }
  
  private void dOO()
  {
    AppMethodBeat.i(115518);
    this.mMatrix = new Matrix();
    this.AEi = QImageView.a.AEA;
    AppMethodBeat.o(115518);
  }
  
  private void dOP()
  {
    Object localObject1 = null;
    AppMethodBeat.i(115529);
    if (this.mDrawable != null)
    {
      AppMethodBeat.o(115529);
      return;
    }
    Object localObject2 = getResources();
    if (localObject2 == null)
    {
      AppMethodBeat.o(115529);
      return;
    }
    if (this.AEh != 0) {}
    while (this.mUri != null)
    {
      try
      {
        localObject2 = ((Resources)localObject2).getDrawable(this.AEh);
        localObject1 = localObject2;
      }
      catch (Exception localException)
      {
        for (;;)
        {
          ab.w("ImageView", "Unable to find resource: " + this.AEh, new Object[] { localException });
          this.mUri = null;
        }
      }
      y(localObject1);
      AppMethodBeat.o(115529);
      return;
    }
    AppMethodBeat.o(115529);
  }
  
  private void dOQ()
  {
    AppMethodBeat.i(115536);
    Drawable localDrawable = this.mDrawable;
    if (localDrawable != null)
    {
      int j = localDrawable.getIntrinsicWidth();
      int i = j;
      if (j < 0) {
        i = this.AEp;
      }
      int k = localDrawable.getIntrinsicHeight();
      j = k;
      if (k < 0) {
        j = this.AEq;
      }
      if ((i != this.AEp) || (j != this.AEq))
      {
        this.AEp = i;
        this.AEq = j;
        requestLayout();
      }
    }
    AppMethodBeat.o(115536);
  }
  
  private void dOR()
  {
    AppMethodBeat.i(115540);
    if ((this.mDrawable == null) || (!this.AEj))
    {
      AppMethodBeat.o(115540);
      return;
    }
    int j = this.AEp;
    int k = this.AEq;
    int m = getWidth() - getPaddingLeft() - getPaddingRight();
    int n = getHeight() - getPaddingTop() - getPaddingBottom();
    if (((j < 0) || (m == j)) && ((k < 0) || (n == k))) {}
    for (int i = 1; (j <= 0) || (k <= 0) || (QImageView.a.AEy == this.AEi); i = 0)
    {
      this.mDrawable.setBounds(0, 0, m, n);
      this.AEr = null;
      AppMethodBeat.o(115540);
      return;
    }
    this.mDrawable.setBounds(0, 0, j, k);
    if (QImageView.a.AEx == this.AEi)
    {
      if (this.mMatrix.isIdentity())
      {
        this.AEr = null;
        AppMethodBeat.o(115540);
        return;
      }
      this.AEr = this.mMatrix;
      AppMethodBeat.o(115540);
      return;
    }
    if (i != 0)
    {
      this.AEr = null;
      AppMethodBeat.o(115540);
      return;
    }
    if (QImageView.a.AEC == this.AEi)
    {
      this.AEr = this.mMatrix;
      this.AEr.setTranslate((int)((m - j) * 0.5F + 0.5F), (int)((n - k) * 0.5F + 0.5F));
      AppMethodBeat.o(115540);
      return;
    }
    float f3;
    float f2;
    float f1;
    if (QImageView.a.AED == this.AEi)
    {
      this.AEr = this.mMatrix;
      if (j * n > m * k)
      {
        f3 = n / k;
        f2 = (m - j * f3) * 0.5F;
        f1 = 0.0F;
      }
      for (;;)
      {
        this.AEr.setScale(f3, f3);
        this.AEr.postTranslate((int)(f2 + 0.5F), (int)(f1 + 0.5F));
        AppMethodBeat.o(115540);
        return;
        f3 = m / j;
        f1 = (n - k * f3) * 0.5F;
        f2 = 0.0F;
      }
    }
    if (QImageView.a.AEE == this.AEi)
    {
      this.AEr = this.mMatrix;
      if ((j <= m) && (k <= n)) {}
      for (f1 = 1.0F;; f1 = Math.min(m / j, n / k))
      {
        f2 = (int)((m - j * f1) * 0.5F + 0.5F);
        f3 = (int)((n - k * f1) * 0.5F + 0.5F);
        this.AEr.setScale(f1, f1);
        this.AEr.postTranslate(f2, f3);
        AppMethodBeat.o(115540);
        return;
      }
    }
    this.AEs.set(0.0F, 0.0F, j, k);
    this.AEt.set(0.0F, 0.0F, m, n);
    this.AEr = this.mMatrix;
    this.AEr.setRectToRect(this.AEs, this.AEt, a(this.AEi));
    AppMethodBeat.o(115540);
  }
  
  private void dOS()
  {
    AppMethodBeat.i(115547);
    if ((this.mDrawable != null) && (this.AEm))
    {
      this.mDrawable = this.mDrawable.mutate();
      this.mDrawable.setColorFilter(this.nO);
      this.mDrawable.setAlpha(this.mAlpha * this.AEl >> 8);
    }
    AppMethodBeat.o(115547);
  }
  
  private void y(Drawable paramDrawable)
  {
    AppMethodBeat.i(115535);
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
      paramDrawable.setLevel(this.AEo);
      this.AEp = paramDrawable.getIntrinsicWidth();
      this.AEq = paramDrawable.getIntrinsicHeight();
      dOS();
      dOR();
    }
    AppMethodBeat.o(115535);
  }
  
  protected void drawableStateChanged()
  {
    AppMethodBeat.i(115541);
    super.drawableStateChanged();
    Drawable localDrawable = this.mDrawable;
    if ((localDrawable != null) && (localDrawable.isStateful())) {
      localDrawable.setState(getDrawableState());
    }
    AppMethodBeat.o(115541);
  }
  
  public int getBaseline()
  {
    AppMethodBeat.i(115543);
    if (this.afZ)
    {
      int i = getMeasuredHeight();
      AppMethodBeat.o(115543);
      return i;
    }
    AppMethodBeat.o(115543);
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
    return this.AEi;
  }
  
  public void invalidateDrawable(Drawable paramDrawable)
  {
    AppMethodBeat.i(115520);
    if (paramDrawable == this.mDrawable)
    {
      invalidate();
      AppMethodBeat.o(115520);
      return;
    }
    super.invalidateDrawable(paramDrawable);
    AppMethodBeat.o(115520);
  }
  
  public int[] onCreateDrawableState(int paramInt)
  {
    AppMethodBeat.i(115534);
    if (this.hz == null)
    {
      arrayOfInt = super.onCreateDrawableState(paramInt);
      AppMethodBeat.o(115534);
      return arrayOfInt;
    }
    if (!this.AEn)
    {
      arrayOfInt = this.hz;
      AppMethodBeat.o(115534);
      return arrayOfInt;
    }
    int[] arrayOfInt = mergeDrawableStates(super.onCreateDrawableState(this.hz.length + paramInt), this.hz);
    AppMethodBeat.o(115534);
    return arrayOfInt;
  }
  
  protected void onDetachedFromWindow()
  {
    AppMethodBeat.i(115548);
    super.onDetachedFromWindow();
    AppMethodBeat.o(115548);
  }
  
  protected void onDraw(Canvas paramCanvas)
  {
    AppMethodBeat.i(115542);
    paramCanvas.setDrawFilter(new PaintFlagsDrawFilter(0, 3));
    super.onDraw(paramCanvas);
    if (this.mDrawable == null)
    {
      AppMethodBeat.o(115542);
      return;
    }
    if ((this.AEp == 0) || (this.AEq == 0))
    {
      AppMethodBeat.o(115542);
      return;
    }
    if ((this.AEr == null) && (getPaddingTop() == 0) && (getPaddingLeft() == 0))
    {
      this.mDrawable.draw(paramCanvas);
      AppMethodBeat.o(115542);
      return;
    }
    int i = paramCanvas.getSaveCount();
    paramCanvas.save();
    if (this.AEu)
    {
      int j = getScrollX();
      int k = getScrollY();
      paramCanvas.clipRect(getPaddingLeft() + j, getPaddingTop() + k, j + getRight() - getLeft() - getPaddingRight(), k + getBottom() - getTop() - getPaddingBottom());
    }
    paramCanvas.translate(getPaddingLeft(), getPaddingTop());
    if (this.AEr != null) {
      paramCanvas.concat(this.AEr);
    }
    this.mDrawable.draw(paramCanvas);
    paramCanvas.restoreToCount(i);
    AppMethodBeat.o(115542);
  }
  
  protected void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    AppMethodBeat.i(115539);
    this.AEj = true;
    dOR();
    AppMethodBeat.o(115539);
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(115537);
    dOP();
    float f = 0.0F;
    int k = 0;
    int m = 0;
    int j;
    int i;
    if (this.mDrawable == null)
    {
      this.AEp = -1;
      this.AEq = -1;
      j = 0;
      i = 0;
    }
    label392:
    label403:
    label406:
    label417:
    for (;;)
    {
      int i2 = getPaddingLeft();
      int i3 = getPaddingRight();
      int n = getPaddingTop();
      int i1 = getPaddingBottom();
      if ((k != 0) || (m != 0))
      {
        paramInt1 = ay(j + i2 + i3, this.mMaxWidth, paramInt1);
        paramInt2 = ay(i + n + i1, this.mMaxHeight, paramInt2);
        if ((f == 0.0F) || (Math.abs((paramInt1 - i2 - i3) / (paramInt2 - n - i1) - f) <= 1.0E-007D)) {
          break label406;
        }
        i = 0;
        if (k == 0) {
          break label403;
        }
        j = (int)((paramInt2 - n - i1) * f) + i2 + i3;
        if (j > paramInt1) {
          break label403;
        }
        i = 1;
        paramInt1 = j;
        label184:
        if ((i != 0) || (m == 0)) {
          break label392;
        }
        i = (int)((paramInt1 - i2 - i3) / f) + n + i1;
        if (i > paramInt2) {
          break label392;
        }
        paramInt2 = paramInt1;
        paramInt1 = i;
      }
      for (;;)
      {
        setMeasuredDimension(paramInt2, paramInt1);
        AppMethodBeat.o(115537);
        return;
        i = this.AEp;
        n = this.AEq;
        j = i;
        if (i <= 0) {
          j = 1;
        }
        i = n;
        if (n <= 0) {
          i = 1;
        }
        if (!this.AEk) {
          break label417;
        }
        k = View.MeasureSpec.getMode(paramInt1);
        m = View.MeasureSpec.getMode(paramInt2);
        if (k != 1073741824)
        {
          k = 1;
          label303:
          if (m == 1073741824) {
            break label331;
          }
        }
        label331:
        for (m = 1;; m = 0)
        {
          f = j / i;
          break;
          k = 0;
          break label303;
        }
        j = Math.max(i2 + i3 + j, getSuggestedMinimumWidth());
        k = Math.max(n + i1 + i, getSuggestedMinimumHeight());
        i = resolveSize(j, paramInt1);
        paramInt1 = resolveSize(k, paramInt2);
        paramInt2 = i;
        continue;
        i = paramInt1;
        paramInt1 = paramInt2;
        paramInt2 = i;
        continue;
        break label184;
        i = paramInt1;
        paramInt1 = paramInt2;
        paramInt2 = i;
      }
    }
  }
  
  protected boolean onSetAlpha(int paramInt)
  {
    AppMethodBeat.i(115521);
    if (getBackground() == null)
    {
      paramInt = (paramInt >> 7) + paramInt;
      if (this.AEl != paramInt)
      {
        this.AEl = paramInt;
        this.AEm = true;
        dOS();
      }
      AppMethodBeat.o(115521);
      return true;
    }
    AppMethodBeat.o(115521);
    return false;
  }
  
  public void setAdjustViewBounds(boolean paramBoolean)
  {
    AppMethodBeat.i(115522);
    this.AEk = paramBoolean;
    if (paramBoolean) {
      setScaleType(QImageView.a.AEA);
    }
    AppMethodBeat.o(115522);
  }
  
  public void setAlpha(int paramInt)
  {
    AppMethodBeat.i(115546);
    paramInt &= 0xFF;
    if (this.mAlpha != paramInt)
    {
      this.mAlpha = paramInt;
      this.AEm = true;
      dOS();
      invalidate();
    }
    AppMethodBeat.o(115546);
  }
  
  public void setBackgroundDrawable(Drawable paramDrawable)
  {
    AppMethodBeat.i(115527);
    super.setBackgroundDrawable(paramDrawable);
    AppMethodBeat.o(115527);
  }
  
  public final void setColorFilter(int paramInt)
  {
    AppMethodBeat.i(115544);
    setColorFilter(new PorterDuffColorFilter(paramInt, PorterDuff.Mode.SRC_ATOP));
    AppMethodBeat.o(115544);
  }
  
  public void setColorFilter(ColorFilter paramColorFilter)
  {
    AppMethodBeat.i(115545);
    if (this.nO != paramColorFilter)
    {
      this.nO = paramColorFilter;
      this.AEm = true;
      dOS();
      invalidate();
    }
    AppMethodBeat.o(115545);
  }
  
  public void setImageBitmap(Bitmap paramBitmap)
  {
    AppMethodBeat.i(115528);
    setImageDrawable(new BitmapDrawable(this.mContext.getResources(), paramBitmap));
    AppMethodBeat.o(115528);
  }
  
  public void setImageDrawable(Drawable paramDrawable)
  {
    AppMethodBeat.i(115526);
    if (this.mDrawable != paramDrawable)
    {
      this.AEh = 0;
      this.mUri = null;
      y(paramDrawable);
      invalidate();
    }
    AppMethodBeat.o(115526);
  }
  
  public void setImageLevel(int paramInt)
  {
    AppMethodBeat.i(115531);
    this.AEo = paramInt;
    if (this.mDrawable != null)
    {
      this.mDrawable.setLevel(paramInt);
      dOQ();
    }
    AppMethodBeat.o(115531);
  }
  
  public void setImageMatrix(Matrix paramMatrix)
  {
    AppMethodBeat.i(115533);
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
      dOR();
      invalidate();
    }
    AppMethodBeat.o(115533);
  }
  
  public void setImageResource(int paramInt)
  {
    AppMethodBeat.i(115523);
    if ((this.mUri != null) || (this.AEh != paramInt))
    {
      y(null);
      this.AEh = paramInt;
      this.mUri = null;
      dOP();
      invalidate();
    }
    AppMethodBeat.o(115523);
  }
  
  public void setImageURI(Uri paramUri)
  {
    AppMethodBeat.i(115525);
    if ((this.AEh != 0) || ((this.mUri != paramUri) && ((paramUri == null) || (this.mUri == null) || (!paramUri.equals(this.mUri)))))
    {
      y(null);
      this.AEh = 0;
      this.mUri = paramUri;
      dOP();
      invalidate();
    }
    AppMethodBeat.o(115525);
  }
  
  @TargetApi(11)
  public void setLayerType(int paramInt, Paint paramPaint)
  {
    AppMethodBeat.i(115524);
    if (((getDrawable() instanceof PictureDrawable)) && (paramInt != 1))
    {
      AppMethodBeat.o(115524);
      return;
    }
    super.setLayerType(paramInt, paramPaint);
    AppMethodBeat.o(115524);
  }
  
  public void setMaxHeight(int paramInt)
  {
    this.mMaxHeight = paramInt;
  }
  
  public void setMaxWidth(int paramInt)
  {
    this.mMaxWidth = paramInt;
  }
  
  public void setScaleType(QImageView.a parama)
  {
    AppMethodBeat.i(115532);
    if (parama == null)
    {
      parama = new NullPointerException();
      AppMethodBeat.o(115532);
      throw parama;
    }
    if (this.AEi != parama)
    {
      this.AEi = parama;
      if (this.AEi != QImageView.a.AEC) {
        break label71;
      }
    }
    label71:
    for (boolean bool = true;; bool = false)
    {
      setWillNotCacheDrawing(bool);
      requestLayout();
      invalidate();
      AppMethodBeat.o(115532);
      return;
    }
  }
  
  public void setSelected(boolean paramBoolean)
  {
    AppMethodBeat.i(115530);
    super.setSelected(paramBoolean);
    dOQ();
    AppMethodBeat.o(115530);
  }
  
  protected boolean verifyDrawable(Drawable paramDrawable)
  {
    AppMethodBeat.i(115519);
    if ((this.mDrawable == paramDrawable) || (super.verifyDrawable(paramDrawable)))
    {
      AppMethodBeat.o(115519);
      return true;
    }
    AppMethodBeat.o(115519);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.ui.widget.QImageView
 * JD-Core Version:    0.7.0.1
 */