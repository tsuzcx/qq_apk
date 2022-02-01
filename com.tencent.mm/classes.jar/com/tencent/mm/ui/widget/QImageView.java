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
import android.os.Build.VERSION;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.MeasureSpec;
import android.widget.RemoteViews.RemoteView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ad;

@RemoteViews.RemoteView
public class QImageView
  extends View
{
  private static final QImageView.a[] HBq = { QImageView.a.HBs, QImageView.a.HBt, QImageView.a.HBu, QImageView.a.HBv, QImageView.a.HBw, QImageView.a.HBx, QImageView.a.HBy, QImageView.a.HBz };
  private static final Matrix.ScaleToFit[] HBr = { Matrix.ScaleToFit.FILL, Matrix.ScaleToFit.START, Matrix.ScaleToFit.CENTER, Matrix.ScaleToFit.END };
  private int HAZ;
  private QImageView.a HBa;
  private boolean HBb;
  private boolean HBc;
  private int HBd;
  private boolean HBe;
  private int[] HBf;
  private boolean HBg;
  private int HBh;
  private int HBi;
  private int HBj;
  private Matrix HBk;
  private final RectF HBl;
  private final RectF HBm;
  private boolean HBn;
  private PaintFlagsDrawFilter HBo;
  private PaintFlagsDrawFilter HBp;
  private boolean ang;
  private int mAlpha;
  private Context mContext;
  private Drawable mDrawable;
  private Matrix mMatrix;
  private int mMaxHeight;
  private int mMaxWidth;
  private Uri mUri;
  private ColorFilter up;
  
  public QImageView(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
    AppMethodBeat.i(156564);
    this.mContext = paramContext;
    feV();
    AppMethodBeat.o(156564);
  }
  
  public QImageView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(156565);
    this.HAZ = 0;
    this.HBb = false;
    this.HBc = false;
    this.mMaxWidth = 2147483647;
    this.mMaxHeight = 2147483647;
    this.mAlpha = 255;
    this.HBd = 256;
    this.HBe = false;
    this.mDrawable = null;
    this.HBf = null;
    this.HBg = false;
    this.HBh = 0;
    this.HBk = null;
    this.HBl = new RectF();
    this.HBm = new RectF();
    this.ang = false;
    this.mContext = paramContext;
    feV();
    this.ang = false;
    setAdjustViewBounds(false);
    setMaxWidth(2147483647);
    setMaxHeight(2147483647);
    this.HBn = false;
    AppMethodBeat.o(156565);
  }
  
  private void H(Drawable paramDrawable)
  {
    AppMethodBeat.i(156583);
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
      paramDrawable.setLevel(this.HBh);
      this.HBi = paramDrawable.getIntrinsicWidth();
      this.HBj = paramDrawable.getIntrinsicHeight();
      feZ();
      feY();
    }
    AppMethodBeat.o(156583);
  }
  
  private static Matrix.ScaleToFit a(QImageView.a parama)
  {
    return HBr[(parama.HBA - 1)];
  }
  
  private static int aK(int paramInt1, int paramInt2, int paramInt3)
  {
    AppMethodBeat.i(156586);
    int i = View.MeasureSpec.getMode(paramInt3);
    paramInt3 = View.MeasureSpec.getSize(paramInt3);
    switch (i)
    {
    }
    for (;;)
    {
      AppMethodBeat.o(156586);
      return paramInt1;
      paramInt1 = Math.min(paramInt1, paramInt2);
      continue;
      paramInt1 = Math.min(Math.min(paramInt1, paramInt3), paramInt2);
      continue;
      paramInt1 = paramInt3;
    }
  }
  
  private void feV()
  {
    AppMethodBeat.i(156566);
    this.mMatrix = new Matrix();
    this.HBa = QImageView.a.HBv;
    this.HBo = new PaintFlagsDrawFilter(0, 3);
    this.HBp = new PaintFlagsDrawFilter(0, 0);
    AppMethodBeat.o(156566);
  }
  
  private void feW()
  {
    Object localObject1 = null;
    AppMethodBeat.i(156577);
    if (this.mDrawable != null)
    {
      AppMethodBeat.o(156577);
      return;
    }
    Object localObject2 = getResources();
    if (localObject2 == null)
    {
      AppMethodBeat.o(156577);
      return;
    }
    if (this.HAZ != 0) {}
    while (this.mUri != null)
    {
      try
      {
        localObject2 = ((Resources)localObject2).getDrawable(this.HAZ);
        localObject1 = localObject2;
      }
      catch (Exception localException)
      {
        for (;;)
        {
          ad.w("ImageView", "Unable to find resource: " + this.HAZ, new Object[] { localException });
          this.mUri = null;
        }
      }
      H(localObject1);
      AppMethodBeat.o(156577);
      return;
    }
    AppMethodBeat.o(156577);
  }
  
  private void feX()
  {
    AppMethodBeat.i(156584);
    Drawable localDrawable = this.mDrawable;
    if (localDrawable != null)
    {
      int j = localDrawable.getIntrinsicWidth();
      int i = j;
      if (j < 0) {
        i = this.HBi;
      }
      int k = localDrawable.getIntrinsicHeight();
      j = k;
      if (k < 0) {
        j = this.HBj;
      }
      if ((i != this.HBi) || (j != this.HBj))
      {
        this.HBi = i;
        this.HBj = j;
        requestLayout();
      }
    }
    AppMethodBeat.o(156584);
  }
  
  private void feY()
  {
    AppMethodBeat.i(156588);
    if ((this.mDrawable == null) || (!this.HBb))
    {
      AppMethodBeat.o(156588);
      return;
    }
    int j = this.HBi;
    int k = this.HBj;
    int m = getWidth() - getPaddingLeft() - getPaddingRight();
    int n = getHeight() - getPaddingTop() - getPaddingBottom();
    if (((j < 0) || (m == j)) && ((k < 0) || (n == k))) {}
    for (int i = 1; (j <= 0) || (k <= 0) || (QImageView.a.HBt == this.HBa); i = 0)
    {
      this.mDrawable.setBounds(0, 0, m, n);
      this.HBk = null;
      AppMethodBeat.o(156588);
      return;
    }
    this.mDrawable.setBounds(0, 0, j, k);
    if (QImageView.a.HBs == this.HBa)
    {
      if (this.mMatrix.isIdentity())
      {
        this.HBk = null;
        AppMethodBeat.o(156588);
        return;
      }
      this.HBk = this.mMatrix;
      AppMethodBeat.o(156588);
      return;
    }
    if (i != 0)
    {
      this.HBk = null;
      AppMethodBeat.o(156588);
      return;
    }
    if (QImageView.a.HBx == this.HBa)
    {
      this.HBk = this.mMatrix;
      this.HBk.setTranslate((int)((m - j) * 0.5F + 0.5F), (int)((n - k) * 0.5F + 0.5F));
      AppMethodBeat.o(156588);
      return;
    }
    float f3;
    float f2;
    float f1;
    if (QImageView.a.HBy == this.HBa)
    {
      this.HBk = this.mMatrix;
      if (j * n > m * k)
      {
        f3 = n / k;
        f2 = (m - j * f3) * 0.5F;
        f1 = 0.0F;
      }
      for (;;)
      {
        this.HBk.setScale(f3, f3);
        this.HBk.postTranslate((int)(f2 + 0.5F), (int)(f1 + 0.5F));
        AppMethodBeat.o(156588);
        return;
        f3 = m / j;
        f1 = (n - k * f3) * 0.5F;
        f2 = 0.0F;
      }
    }
    if (QImageView.a.HBz == this.HBa)
    {
      this.HBk = this.mMatrix;
      if ((j <= m) && (k <= n)) {}
      for (f1 = 1.0F;; f1 = Math.min(m / j, n / k))
      {
        f2 = (int)((m - j * f1) * 0.5F + 0.5F);
        f3 = (int)((n - k * f1) * 0.5F + 0.5F);
        this.HBk.setScale(f1, f1);
        this.HBk.postTranslate(f2, f3);
        AppMethodBeat.o(156588);
        return;
      }
    }
    this.HBl.set(0.0F, 0.0F, j, k);
    this.HBm.set(0.0F, 0.0F, m, n);
    this.HBk = this.mMatrix;
    this.HBk.setRectToRect(this.HBl, this.HBm, a(this.HBa));
    AppMethodBeat.o(156588);
  }
  
  private void feZ()
  {
    AppMethodBeat.i(156595);
    if ((this.mDrawable != null) && (this.HBe))
    {
      this.mDrawable = this.mDrawable.mutate();
      this.mDrawable.setColorFilter(this.up);
      this.mDrawable.setAlpha(this.mAlpha * this.HBd >> 8);
    }
    AppMethodBeat.o(156595);
  }
  
  protected void drawableStateChanged()
  {
    AppMethodBeat.i(156589);
    super.drawableStateChanged();
    Drawable localDrawable = this.mDrawable;
    if ((localDrawable != null) && (localDrawable.isStateful())) {
      localDrawable.setState(getDrawableState());
    }
    AppMethodBeat.o(156589);
  }
  
  public int getBaseline()
  {
    AppMethodBeat.i(156591);
    if (this.ang)
    {
      int i = getMeasuredHeight();
      AppMethodBeat.o(156591);
      return i;
    }
    AppMethodBeat.o(156591);
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
    return this.HBa;
  }
  
  public void invalidateDrawable(Drawable paramDrawable)
  {
    AppMethodBeat.i(156568);
    if (paramDrawable == this.mDrawable)
    {
      invalidate();
      AppMethodBeat.o(156568);
      return;
    }
    super.invalidateDrawable(paramDrawable);
    AppMethodBeat.o(156568);
  }
  
  public int[] onCreateDrawableState(int paramInt)
  {
    AppMethodBeat.i(156582);
    if (this.HBf == null)
    {
      arrayOfInt = super.onCreateDrawableState(paramInt);
      AppMethodBeat.o(156582);
      return arrayOfInt;
    }
    if (!this.HBg)
    {
      arrayOfInt = this.HBf;
      AppMethodBeat.o(156582);
      return arrayOfInt;
    }
    int[] arrayOfInt = mergeDrawableStates(super.onCreateDrawableState(this.HBf.length + paramInt), this.HBf);
    AppMethodBeat.o(156582);
    return arrayOfInt;
  }
  
  protected void onDetachedFromWindow()
  {
    AppMethodBeat.i(156596);
    super.onDetachedFromWindow();
    AppMethodBeat.o(156596);
  }
  
  protected void onDraw(Canvas paramCanvas)
  {
    AppMethodBeat.i(156590);
    paramCanvas.setDrawFilter(this.HBo);
    super.onDraw(paramCanvas);
    if (this.mDrawable == null)
    {
      AppMethodBeat.o(156590);
      return;
    }
    if ((this.HBi == 0) || (this.HBj == 0))
    {
      AppMethodBeat.o(156590);
      return;
    }
    if ((this.HBk == null) && (getPaddingTop() == 0) && (getPaddingLeft() == 0)) {
      this.mDrawable.draw(paramCanvas);
    }
    for (;;)
    {
      if (Build.VERSION.SDK_INT > 28) {
        paramCanvas.setDrawFilter(this.HBp);
      }
      AppMethodBeat.o(156590);
      return;
      int i = paramCanvas.getSaveCount();
      paramCanvas.save();
      if (this.HBn)
      {
        int j = getScrollX();
        int k = getScrollY();
        paramCanvas.clipRect(getPaddingLeft() + j, getPaddingTop() + k, j + getRight() - getLeft() - getPaddingRight(), k + getBottom() - getTop() - getPaddingBottom());
      }
      paramCanvas.translate(getPaddingLeft(), getPaddingTop());
      if (this.HBk != null) {
        paramCanvas.concat(this.HBk);
      }
      this.mDrawable.draw(paramCanvas);
      paramCanvas.restoreToCount(i);
    }
  }
  
  protected void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    AppMethodBeat.i(156587);
    this.HBb = true;
    feY();
    AppMethodBeat.o(156587);
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(156585);
    feW();
    float f = 0.0F;
    int k = 0;
    int m = 0;
    int j;
    int i;
    if (this.mDrawable == null)
    {
      this.HBi = -1;
      this.HBj = -1;
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
        paramInt1 = aK(j + i2 + i3, this.mMaxWidth, paramInt1);
        paramInt2 = aK(i + n + i1, this.mMaxHeight, paramInt2);
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
        AppMethodBeat.o(156585);
        return;
        i = this.HBi;
        n = this.HBj;
        j = i;
        if (i <= 0) {
          j = 1;
        }
        i = n;
        if (n <= 0) {
          i = 1;
        }
        if (!this.HBc) {
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
    AppMethodBeat.i(156569);
    if (getBackground() == null)
    {
      paramInt = (paramInt >> 7) + paramInt;
      if (this.HBd != paramInt)
      {
        this.HBd = paramInt;
        this.HBe = true;
        feZ();
      }
      AppMethodBeat.o(156569);
      return true;
    }
    AppMethodBeat.o(156569);
    return false;
  }
  
  public void setAdjustViewBounds(boolean paramBoolean)
  {
    AppMethodBeat.i(156570);
    this.HBc = paramBoolean;
    if (paramBoolean) {
      setScaleType(QImageView.a.HBv);
    }
    AppMethodBeat.o(156570);
  }
  
  public void setAlpha(int paramInt)
  {
    AppMethodBeat.i(156594);
    paramInt &= 0xFF;
    if (this.mAlpha != paramInt)
    {
      this.mAlpha = paramInt;
      this.HBe = true;
      feZ();
      invalidate();
    }
    AppMethodBeat.o(156594);
  }
  
  public void setBackgroundDrawable(Drawable paramDrawable)
  {
    AppMethodBeat.i(156575);
    super.setBackgroundDrawable(paramDrawable);
    AppMethodBeat.o(156575);
  }
  
  public final void setColorFilter(int paramInt)
  {
    AppMethodBeat.i(156592);
    setColorFilter(new PorterDuffColorFilter(paramInt, PorterDuff.Mode.SRC_ATOP));
    AppMethodBeat.o(156592);
  }
  
  public void setColorFilter(ColorFilter paramColorFilter)
  {
    AppMethodBeat.i(156593);
    if (this.up != paramColorFilter)
    {
      this.up = paramColorFilter;
      this.HBe = true;
      feZ();
      invalidate();
    }
    AppMethodBeat.o(156593);
  }
  
  public void setImageBitmap(Bitmap paramBitmap)
  {
    AppMethodBeat.i(156576);
    setImageDrawable(new BitmapDrawable(this.mContext.getResources(), paramBitmap));
    AppMethodBeat.o(156576);
  }
  
  public void setImageDrawable(Drawable paramDrawable)
  {
    AppMethodBeat.i(156574);
    if (this.mDrawable != paramDrawable)
    {
      this.HAZ = 0;
      this.mUri = null;
      H(paramDrawable);
      invalidate();
    }
    AppMethodBeat.o(156574);
  }
  
  public void setImageLevel(int paramInt)
  {
    AppMethodBeat.i(156579);
    this.HBh = paramInt;
    if (this.mDrawable != null)
    {
      this.mDrawable.setLevel(paramInt);
      feX();
    }
    AppMethodBeat.o(156579);
  }
  
  public void setImageMatrix(Matrix paramMatrix)
  {
    AppMethodBeat.i(156581);
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
      feY();
      invalidate();
    }
    AppMethodBeat.o(156581);
  }
  
  public void setImageResource(int paramInt)
  {
    AppMethodBeat.i(156571);
    if ((this.mUri != null) || (this.HAZ != paramInt))
    {
      H(null);
      this.HAZ = paramInt;
      this.mUri = null;
      feW();
      invalidate();
    }
    AppMethodBeat.o(156571);
  }
  
  public void setImageURI(Uri paramUri)
  {
    AppMethodBeat.i(156573);
    if ((this.HAZ != 0) || ((this.mUri != paramUri) && ((paramUri == null) || (this.mUri == null) || (!paramUri.equals(this.mUri)))))
    {
      H(null);
      this.HAZ = 0;
      this.mUri = paramUri;
      feW();
      invalidate();
    }
    AppMethodBeat.o(156573);
  }
  
  @TargetApi(11)
  public void setLayerType(int paramInt, Paint paramPaint)
  {
    AppMethodBeat.i(156572);
    if (((getDrawable() instanceof PictureDrawable)) && (paramInt != 1))
    {
      AppMethodBeat.o(156572);
      return;
    }
    super.setLayerType(paramInt, paramPaint);
    AppMethodBeat.o(156572);
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
    AppMethodBeat.i(156580);
    if (parama == null)
    {
      parama = new NullPointerException();
      AppMethodBeat.o(156580);
      throw parama;
    }
    if (this.HBa != parama)
    {
      this.HBa = parama;
      if (this.HBa != QImageView.a.HBx) {
        break label71;
      }
    }
    label71:
    for (boolean bool = true;; bool = false)
    {
      setWillNotCacheDrawing(bool);
      requestLayout();
      invalidate();
      AppMethodBeat.o(156580);
      return;
    }
  }
  
  public void setSelected(boolean paramBoolean)
  {
    AppMethodBeat.i(156578);
    super.setSelected(paramBoolean);
    feX();
    AppMethodBeat.o(156578);
  }
  
  protected boolean verifyDrawable(Drawable paramDrawable)
  {
    AppMethodBeat.i(156567);
    if ((this.mDrawable == paramDrawable) || (super.verifyDrawable(paramDrawable)))
    {
      AppMethodBeat.o(156567);
      return true;
    }
    AppMethodBeat.o(156567);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.ui.widget.QImageView
 * JD-Core Version:    0.7.0.1
 */