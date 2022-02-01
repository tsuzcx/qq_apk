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
import com.tencent.mm.sdk.platformtools.ae;

@RemoteViews.RemoteView
public class QImageView
  extends View
{
  private static final a[] Lpr = { a.Lpt, a.Lpu, a.Lpv, a.Lpw, a.Lpx, a.Lpy, a.Lpz, a.LpA };
  private static final Matrix.ScaleToFit[] Lps = { Matrix.ScaleToFit.FILL, Matrix.ScaleToFit.START, Matrix.ScaleToFit.CENTER, Matrix.ScaleToFit.END };
  private int Lpb;
  private a Lpc;
  private boolean Lpd;
  private boolean Lpe;
  private int Lpf;
  private boolean Lpg;
  private int[] Lph;
  private boolean Lpi;
  private int Lpj;
  private int Lpk;
  private Matrix Lpl;
  private final RectF Lpm;
  private final RectF Lpn;
  private boolean Lpo;
  private PaintFlagsDrawFilter Lpp;
  private PaintFlagsDrawFilter Lpq;
  private boolean apT;
  private int mAlpha;
  private Context mContext;
  private Drawable mDrawable;
  private int mLevel;
  private Matrix mMatrix;
  private int mMaxHeight;
  private int mMaxWidth;
  private Uri mUri;
  private ColorFilter xh;
  
  public QImageView(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
    AppMethodBeat.i(156564);
    this.mContext = paramContext;
    fPX();
    AppMethodBeat.o(156564);
  }
  
  public QImageView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(156565);
    this.Lpb = 0;
    this.Lpd = false;
    this.Lpe = false;
    this.mMaxWidth = 2147483647;
    this.mMaxHeight = 2147483647;
    this.mAlpha = 255;
    this.Lpf = 256;
    this.Lpg = false;
    this.mDrawable = null;
    this.Lph = null;
    this.Lpi = false;
    this.mLevel = 0;
    this.Lpl = null;
    this.Lpm = new RectF();
    this.Lpn = new RectF();
    this.apT = false;
    this.mContext = paramContext;
    fPX();
    this.apT = false;
    setAdjustViewBounds(false);
    setMaxWidth(2147483647);
    setMaxHeight(2147483647);
    this.Lpo = false;
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
      paramDrawable.setLevel(this.mLevel);
      this.Lpj = paramDrawable.getIntrinsicWidth();
      this.Lpk = paramDrawable.getIntrinsicHeight();
      fQb();
      fQa();
    }
    AppMethodBeat.o(156583);
  }
  
  private static Matrix.ScaleToFit a(a parama)
  {
    return Lps[(parama.LpB - 1)];
  }
  
  private static int aO(int paramInt1, int paramInt2, int paramInt3)
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
  
  private void fPX()
  {
    AppMethodBeat.i(156566);
    this.mMatrix = new Matrix();
    this.Lpc = a.Lpw;
    this.Lpp = new PaintFlagsDrawFilter(0, 3);
    this.Lpq = new PaintFlagsDrawFilter(0, 0);
    AppMethodBeat.o(156566);
  }
  
  private void fPY()
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
    if (this.Lpb != 0) {}
    while (this.mUri != null)
    {
      try
      {
        localObject2 = ((Resources)localObject2).getDrawable(this.Lpb);
        localObject1 = localObject2;
      }
      catch (Exception localException)
      {
        for (;;)
        {
          ae.w("ImageView", "Unable to find resource: " + this.Lpb, new Object[] { localException });
          this.mUri = null;
        }
      }
      H(localObject1);
      AppMethodBeat.o(156577);
      return;
    }
    AppMethodBeat.o(156577);
  }
  
  private void fPZ()
  {
    AppMethodBeat.i(156584);
    Drawable localDrawable = this.mDrawable;
    if (localDrawable != null)
    {
      int j = localDrawable.getIntrinsicWidth();
      int i = j;
      if (j < 0) {
        i = this.Lpj;
      }
      int k = localDrawable.getIntrinsicHeight();
      j = k;
      if (k < 0) {
        j = this.Lpk;
      }
      if ((i != this.Lpj) || (j != this.Lpk))
      {
        this.Lpj = i;
        this.Lpk = j;
        requestLayout();
      }
    }
    AppMethodBeat.o(156584);
  }
  
  private void fQa()
  {
    AppMethodBeat.i(156588);
    if ((this.mDrawable == null) || (!this.Lpd))
    {
      AppMethodBeat.o(156588);
      return;
    }
    int j = this.Lpj;
    int k = this.Lpk;
    int m = getWidth() - getPaddingLeft() - getPaddingRight();
    int n = getHeight() - getPaddingTop() - getPaddingBottom();
    if (((j < 0) || (m == j)) && ((k < 0) || (n == k))) {}
    for (int i = 1; (j <= 0) || (k <= 0) || (a.Lpu == this.Lpc); i = 0)
    {
      this.mDrawable.setBounds(0, 0, m, n);
      this.Lpl = null;
      AppMethodBeat.o(156588);
      return;
    }
    this.mDrawable.setBounds(0, 0, j, k);
    if (a.Lpt == this.Lpc)
    {
      if (this.mMatrix.isIdentity())
      {
        this.Lpl = null;
        AppMethodBeat.o(156588);
        return;
      }
      this.Lpl = this.mMatrix;
      AppMethodBeat.o(156588);
      return;
    }
    if (i != 0)
    {
      this.Lpl = null;
      AppMethodBeat.o(156588);
      return;
    }
    if (a.Lpy == this.Lpc)
    {
      this.Lpl = this.mMatrix;
      this.Lpl.setTranslate((int)((m - j) * 0.5F + 0.5F), (int)((n - k) * 0.5F + 0.5F));
      AppMethodBeat.o(156588);
      return;
    }
    float f3;
    float f2;
    float f1;
    if (a.Lpz == this.Lpc)
    {
      this.Lpl = this.mMatrix;
      if (j * n > m * k)
      {
        f3 = n / k;
        f2 = (m - j * f3) * 0.5F;
        f1 = 0.0F;
      }
      for (;;)
      {
        this.Lpl.setScale(f3, f3);
        this.Lpl.postTranslate((int)(f2 + 0.5F), (int)(f1 + 0.5F));
        AppMethodBeat.o(156588);
        return;
        f3 = m / j;
        f1 = (n - k * f3) * 0.5F;
        f2 = 0.0F;
      }
    }
    if (a.LpA == this.Lpc)
    {
      this.Lpl = this.mMatrix;
      if ((j <= m) && (k <= n)) {}
      for (f1 = 1.0F;; f1 = Math.min(m / j, n / k))
      {
        f2 = (int)((m - j * f1) * 0.5F + 0.5F);
        f3 = (int)((n - k * f1) * 0.5F + 0.5F);
        this.Lpl.setScale(f1, f1);
        this.Lpl.postTranslate(f2, f3);
        AppMethodBeat.o(156588);
        return;
      }
    }
    this.Lpm.set(0.0F, 0.0F, j, k);
    this.Lpn.set(0.0F, 0.0F, m, n);
    this.Lpl = this.mMatrix;
    this.Lpl.setRectToRect(this.Lpm, this.Lpn, a(this.Lpc));
    AppMethodBeat.o(156588);
  }
  
  private void fQb()
  {
    AppMethodBeat.i(156595);
    if ((this.mDrawable != null) && (this.Lpg))
    {
      this.mDrawable = this.mDrawable.mutate();
      this.mDrawable.setColorFilter(this.xh);
      this.mDrawable.setAlpha(this.mAlpha * this.Lpf >> 8);
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
    if (this.apT)
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
  
  public a getScaleType()
  {
    return this.Lpc;
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
    if (this.Lph == null)
    {
      arrayOfInt = super.onCreateDrawableState(paramInt);
      AppMethodBeat.o(156582);
      return arrayOfInt;
    }
    if (!this.Lpi)
    {
      arrayOfInt = this.Lph;
      AppMethodBeat.o(156582);
      return arrayOfInt;
    }
    int[] arrayOfInt = mergeDrawableStates(super.onCreateDrawableState(this.Lph.length + paramInt), this.Lph);
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
    paramCanvas.setDrawFilter(this.Lpp);
    super.onDraw(paramCanvas);
    if (this.mDrawable == null)
    {
      AppMethodBeat.o(156590);
      return;
    }
    if ((this.Lpj == 0) || (this.Lpk == 0))
    {
      AppMethodBeat.o(156590);
      return;
    }
    if ((this.Lpl == null) && (getPaddingTop() == 0) && (getPaddingLeft() == 0)) {
      this.mDrawable.draw(paramCanvas);
    }
    for (;;)
    {
      if (Build.VERSION.SDK_INT > 28) {
        paramCanvas.setDrawFilter(this.Lpq);
      }
      AppMethodBeat.o(156590);
      return;
      int i = paramCanvas.getSaveCount();
      paramCanvas.save();
      if (this.Lpo)
      {
        int j = getScrollX();
        int k = getScrollY();
        paramCanvas.clipRect(getPaddingLeft() + j, getPaddingTop() + k, j + getRight() - getLeft() - getPaddingRight(), k + getBottom() - getTop() - getPaddingBottom());
      }
      paramCanvas.translate(getPaddingLeft(), getPaddingTop());
      if (this.Lpl != null) {
        paramCanvas.concat(this.Lpl);
      }
      this.mDrawable.draw(paramCanvas);
      paramCanvas.restoreToCount(i);
    }
  }
  
  protected void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    AppMethodBeat.i(156587);
    this.Lpd = true;
    fQa();
    AppMethodBeat.o(156587);
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(156585);
    fPY();
    float f = 0.0F;
    int k = 0;
    int m = 0;
    int j;
    int i;
    if (this.mDrawable == null)
    {
      this.Lpj = -1;
      this.Lpk = -1;
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
        paramInt1 = aO(j + i2 + i3, this.mMaxWidth, paramInt1);
        paramInt2 = aO(i + n + i1, this.mMaxHeight, paramInt2);
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
        i = this.Lpj;
        n = this.Lpk;
        j = i;
        if (i <= 0) {
          j = 1;
        }
        i = n;
        if (n <= 0) {
          i = 1;
        }
        if (!this.Lpe) {
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
      if (this.Lpf != paramInt)
      {
        this.Lpf = paramInt;
        this.Lpg = true;
        fQb();
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
    this.Lpe = paramBoolean;
    if (paramBoolean) {
      setScaleType(a.Lpw);
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
      this.Lpg = true;
      fQb();
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
    if (this.xh != paramColorFilter)
    {
      this.xh = paramColorFilter;
      this.Lpg = true;
      fQb();
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
      this.Lpb = 0;
      this.mUri = null;
      H(paramDrawable);
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
      fPZ();
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
      fQa();
      invalidate();
    }
    AppMethodBeat.o(156581);
  }
  
  public void setImageResource(int paramInt)
  {
    AppMethodBeat.i(156571);
    if ((this.mUri != null) || (this.Lpb != paramInt))
    {
      H(null);
      this.Lpb = paramInt;
      this.mUri = null;
      fPY();
      invalidate();
    }
    AppMethodBeat.o(156571);
  }
  
  public void setImageURI(Uri paramUri)
  {
    AppMethodBeat.i(156573);
    if ((this.Lpb != 0) || ((this.mUri != paramUri) && ((paramUri == null) || (this.mUri == null) || (!paramUri.equals(this.mUri)))))
    {
      H(null);
      this.Lpb = 0;
      this.mUri = paramUri;
      fPY();
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
  
  public void setScaleType(a parama)
  {
    AppMethodBeat.i(156580);
    if (parama == null)
    {
      parama = new NullPointerException();
      AppMethodBeat.o(156580);
      throw parama;
    }
    if (this.Lpc != parama)
    {
      this.Lpc = parama;
      if (this.Lpc != a.Lpy) {
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
    fPZ();
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
  
  public static enum a
  {
    final int LpB;
    
    static
    {
      AppMethodBeat.i(156563);
      Lpt = new a("MATRIX", 0, 0);
      Lpu = new a("FIT_XY", 1, 1);
      Lpv = new a("FIT_START", 2, 2);
      Lpw = new a("FIT_CENTER", 3, 3);
      Lpx = new a("FIT_END", 4, 4);
      Lpy = new a("CENTER", 5, 5);
      Lpz = new a("CENTER_CROP", 6, 6);
      LpA = new a("CENTER_INSIDE", 7, 7);
      LpC = new a[] { Lpt, Lpu, Lpv, Lpw, Lpx, Lpy, Lpz, LpA };
      AppMethodBeat.o(156563);
    }
    
    private a(int paramInt)
    {
      this.LpB = paramInt;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.ui.widget.QImageView
 * JD-Core Version:    0.7.0.1
 */