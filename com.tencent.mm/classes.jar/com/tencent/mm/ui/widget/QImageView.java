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
import com.tencent.mm.sdk.platformtools.Log;

@RemoteViews.RemoteView
public class QImageView
  extends View
{
  private static final QImageView.a[] Yde = { QImageView.a.Ydg, QImageView.a.Ydh, QImageView.a.Ydi, QImageView.a.Ydj, QImageView.a.Ydk, QImageView.a.Ydl, QImageView.a.Ydm, QImageView.a.Ydn };
  private static final Matrix.ScaleToFit[] Ydf = { Matrix.ScaleToFit.FILL, Matrix.ScaleToFit.START, Matrix.ScaleToFit.CENTER, Matrix.ScaleToFit.END };
  private int EK;
  private int YcO;
  private QImageView.a YcP;
  private boolean YcQ;
  private boolean YcR;
  private int YcS;
  private boolean YcT;
  private int[] YcU;
  private boolean YcV;
  private int YcW;
  private int YcX;
  private Matrix YcY;
  private final RectF YcZ;
  private final RectF Yda;
  private boolean Ydb;
  private PaintFlagsDrawFilter Ydc;
  private PaintFlagsDrawFilter Ydd;
  private Matrix aqj;
  private ColorFilter jC;
  private int mAlpha;
  private Context mContext;
  private Drawable mDrawable;
  private int mLevel;
  private Uri mUri;
  private boolean sH;
  private int uJ;
  
  public QImageView(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
    AppMethodBeat.i(156564);
    this.mContext = paramContext;
    hZR();
    AppMethodBeat.o(156564);
  }
  
  public QImageView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(156565);
    this.YcO = 0;
    this.YcQ = false;
    this.YcR = false;
    this.uJ = 2147483647;
    this.EK = 2147483647;
    this.mAlpha = 255;
    this.YcS = 256;
    this.YcT = false;
    this.mDrawable = null;
    this.YcU = null;
    this.YcV = false;
    this.mLevel = 0;
    this.YcY = null;
    this.YcZ = new RectF();
    this.Yda = new RectF();
    this.sH = false;
    this.mContext = paramContext;
    hZR();
    this.sH = false;
    setAdjustViewBounds(false);
    setMaxWidth(2147483647);
    setMaxHeight(2147483647);
    this.Ydb = false;
    AppMethodBeat.o(156565);
  }
  
  private void M(Drawable paramDrawable)
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
      paramDrawable.setLevel(this.mLevel);
      this.YcW = paramDrawable.getIntrinsicWidth();
      this.YcX = paramDrawable.getIntrinsicHeight();
      hZV();
      hZU();
    }
    AppMethodBeat.o(156583);
  }
  
  private static Matrix.ScaleToFit a(QImageView.a parama)
  {
    return Ydf[(parama.Ydo - 1)];
  }
  
  private static int aY(int paramInt1, int paramInt2, int paramInt3)
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
  
  private void hZR()
  {
    AppMethodBeat.i(156566);
    this.aqj = new Matrix();
    this.YcP = QImageView.a.Ydj;
    this.Ydc = new PaintFlagsDrawFilter(0, 3);
    this.Ydd = new PaintFlagsDrawFilter(0, 0);
    AppMethodBeat.o(156566);
  }
  
  private void hZS()
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
    if (this.YcO != 0) {}
    while (this.mUri != null)
    {
      try
      {
        localObject2 = ((Resources)localObject2).getDrawable(this.YcO);
        localObject1 = localObject2;
      }
      catch (Exception localException)
      {
        for (;;)
        {
          Log.w("ImageView", "Unable to find resource: " + this.YcO, new Object[] { localException });
          this.mUri = null;
        }
      }
      M(localObject1);
      AppMethodBeat.o(156577);
      return;
    }
    AppMethodBeat.o(156577);
  }
  
  private void hZT()
  {
    AppMethodBeat.i(156584);
    Drawable localDrawable = this.mDrawable;
    if (localDrawable != null)
    {
      int j = localDrawable.getIntrinsicWidth();
      int i = j;
      if (j < 0) {
        i = this.YcW;
      }
      int k = localDrawable.getIntrinsicHeight();
      j = k;
      if (k < 0) {
        j = this.YcX;
      }
      if ((i != this.YcW) || (j != this.YcX))
      {
        this.YcW = i;
        this.YcX = j;
        requestLayout();
      }
    }
    AppMethodBeat.o(156584);
  }
  
  private void hZU()
  {
    AppMethodBeat.i(156588);
    if ((this.mDrawable == null) || (!this.YcQ))
    {
      AppMethodBeat.o(156588);
      return;
    }
    int j = this.YcW;
    int k = this.YcX;
    int m = getWidth() - getPaddingLeft() - getPaddingRight();
    int n = getHeight() - getPaddingTop() - getPaddingBottom();
    if (((j < 0) || (m == j)) && ((k < 0) || (n == k))) {}
    for (int i = 1; (j <= 0) || (k <= 0) || (QImageView.a.Ydh == this.YcP); i = 0)
    {
      this.mDrawable.setBounds(0, 0, m, n);
      this.YcY = null;
      AppMethodBeat.o(156588);
      return;
    }
    this.mDrawable.setBounds(0, 0, j, k);
    if (QImageView.a.Ydg == this.YcP)
    {
      if (this.aqj.isIdentity())
      {
        this.YcY = null;
        AppMethodBeat.o(156588);
        return;
      }
      this.YcY = this.aqj;
      AppMethodBeat.o(156588);
      return;
    }
    if (i != 0)
    {
      this.YcY = null;
      AppMethodBeat.o(156588);
      return;
    }
    if (QImageView.a.Ydl == this.YcP)
    {
      this.YcY = this.aqj;
      this.YcY.setTranslate((int)((m - j) * 0.5F + 0.5F), (int)((n - k) * 0.5F + 0.5F));
      AppMethodBeat.o(156588);
      return;
    }
    float f3;
    float f2;
    float f1;
    if (QImageView.a.Ydm == this.YcP)
    {
      this.YcY = this.aqj;
      if (j * n > m * k)
      {
        f3 = n / k;
        f2 = (m - j * f3) * 0.5F;
        f1 = 0.0F;
      }
      for (;;)
      {
        this.YcY.setScale(f3, f3);
        this.YcY.postTranslate((int)(f2 + 0.5F), (int)(f1 + 0.5F));
        AppMethodBeat.o(156588);
        return;
        f3 = m / j;
        f1 = (n - k * f3) * 0.5F;
        f2 = 0.0F;
      }
    }
    if (QImageView.a.Ydn == this.YcP)
    {
      this.YcY = this.aqj;
      if ((j <= m) && (k <= n)) {}
      for (f1 = 1.0F;; f1 = Math.min(m / j, n / k))
      {
        f2 = (int)((m - j * f1) * 0.5F + 0.5F);
        f3 = (int)((n - k * f1) * 0.5F + 0.5F);
        this.YcY.setScale(f1, f1);
        this.YcY.postTranslate(f2, f3);
        AppMethodBeat.o(156588);
        return;
      }
    }
    this.YcZ.set(0.0F, 0.0F, j, k);
    this.Yda.set(0.0F, 0.0F, m, n);
    this.YcY = this.aqj;
    this.YcY.setRectToRect(this.YcZ, this.Yda, a(this.YcP));
    AppMethodBeat.o(156588);
  }
  
  private void hZV()
  {
    AppMethodBeat.i(156595);
    if ((this.mDrawable != null) && (this.YcT))
    {
      this.mDrawable = this.mDrawable.mutate();
      this.mDrawable.setColorFilter(this.jC);
      this.mDrawable.setAlpha(this.mAlpha * this.YcS >> 8);
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
    if (this.sH)
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
    return this.aqj;
  }
  
  public QImageView.a getScaleType()
  {
    return this.YcP;
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
    if (this.YcU == null)
    {
      arrayOfInt = super.onCreateDrawableState(paramInt);
      AppMethodBeat.o(156582);
      return arrayOfInt;
    }
    if (!this.YcV)
    {
      arrayOfInt = this.YcU;
      AppMethodBeat.o(156582);
      return arrayOfInt;
    }
    int[] arrayOfInt = mergeDrawableStates(super.onCreateDrawableState(this.YcU.length + paramInt), this.YcU);
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
    paramCanvas.setDrawFilter(this.Ydc);
    super.onDraw(paramCanvas);
    if (this.mDrawable == null)
    {
      AppMethodBeat.o(156590);
      return;
    }
    if ((this.YcW == 0) || (this.YcX == 0))
    {
      AppMethodBeat.o(156590);
      return;
    }
    if ((this.YcY == null) && (getPaddingTop() == 0) && (getPaddingLeft() == 0)) {
      this.mDrawable.draw(paramCanvas);
    }
    for (;;)
    {
      if (Build.VERSION.SDK_INT > 28) {
        paramCanvas.setDrawFilter(this.Ydd);
      }
      AppMethodBeat.o(156590);
      return;
      int i = paramCanvas.getSaveCount();
      paramCanvas.save();
      if (this.Ydb)
      {
        int j = getScrollX();
        int k = getScrollY();
        paramCanvas.clipRect(getPaddingLeft() + j, getPaddingTop() + k, j + getRight() - getLeft() - getPaddingRight(), k + getBottom() - getTop() - getPaddingBottom());
      }
      paramCanvas.translate(getPaddingLeft(), getPaddingTop());
      if (this.YcY != null) {
        paramCanvas.concat(this.YcY);
      }
      this.mDrawable.draw(paramCanvas);
      paramCanvas.restoreToCount(i);
    }
  }
  
  protected void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    AppMethodBeat.i(156587);
    this.YcQ = true;
    hZU();
    AppMethodBeat.o(156587);
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(156585);
    hZS();
    float f = 0.0F;
    int k = 0;
    int m = 0;
    int j;
    int i;
    if (this.mDrawable == null)
    {
      this.YcW = -1;
      this.YcX = -1;
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
        paramInt1 = aY(j + i2 + i3, this.uJ, paramInt1);
        paramInt2 = aY(i + n + i1, this.EK, paramInt2);
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
        i = this.YcW;
        n = this.YcX;
        j = i;
        if (i <= 0) {
          j = 1;
        }
        i = n;
        if (n <= 0) {
          i = 1;
        }
        if (!this.YcR) {
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
      if (this.YcS != paramInt)
      {
        this.YcS = paramInt;
        this.YcT = true;
        hZV();
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
    this.YcR = paramBoolean;
    if (paramBoolean) {
      setScaleType(QImageView.a.Ydj);
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
      this.YcT = true;
      hZV();
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
    if (this.jC != paramColorFilter)
    {
      this.jC = paramColorFilter;
      this.YcT = true;
      hZV();
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
      this.YcO = 0;
      this.mUri = null;
      M(paramDrawable);
      invalidate();
    }
    AppMethodBeat.o(156574);
  }
  
  public void setImageLevel(int paramInt)
  {
    AppMethodBeat.i(156579);
    this.mLevel = paramInt;
    if (this.mDrawable != null)
    {
      this.mDrawable.setLevel(paramInt);
      hZT();
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
    if (((localMatrix == null) && (!this.aqj.isIdentity())) || ((localMatrix != null) && (!this.aqj.equals(localMatrix))))
    {
      this.aqj.set(localMatrix);
      hZU();
      invalidate();
    }
    AppMethodBeat.o(156581);
  }
  
  public void setImageResource(int paramInt)
  {
    AppMethodBeat.i(156571);
    if ((this.mUri != null) || (this.YcO != paramInt))
    {
      M(null);
      this.YcO = paramInt;
      this.mUri = null;
      hZS();
      invalidate();
    }
    AppMethodBeat.o(156571);
  }
  
  public void setImageURI(Uri paramUri)
  {
    AppMethodBeat.i(156573);
    if ((this.YcO != 0) || ((this.mUri != paramUri) && ((paramUri == null) || (this.mUri == null) || (!paramUri.equals(this.mUri)))))
    {
      M(null);
      this.YcO = 0;
      this.mUri = paramUri;
      hZS();
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
    this.EK = paramInt;
  }
  
  public void setMaxWidth(int paramInt)
  {
    this.uJ = paramInt;
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
    if (this.YcP != parama)
    {
      this.YcP = parama;
      if (this.YcP != QImageView.a.Ydl) {
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
    hZT();
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.ui.widget.QImageView
 * JD-Core Version:    0.7.0.1
 */