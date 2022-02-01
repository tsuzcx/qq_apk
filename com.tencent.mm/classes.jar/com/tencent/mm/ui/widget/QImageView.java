package com.tencent.mm.ui.widget;

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
  private static final a[] afUU = { a.afUW, a.afUX, a.afUY, a.afUZ, a.afVa, a.afVb, a.afVc, a.afVd };
  private static final Matrix.ScaleToFit[] afUV = { Matrix.ScaleToFit.FILL, Matrix.ScaleToFit.START, Matrix.ScaleToFit.CENTER, Matrix.ScaleToFit.END };
  private int afUE;
  private a afUF;
  private boolean afUG;
  private boolean afUH;
  private int afUI;
  private boolean afUJ;
  private int[] afUK;
  private boolean afUL;
  private int afUM;
  private int afUN;
  private Matrix afUO;
  private final RectF afUP;
  private final RectF afUQ;
  private boolean afUR;
  private PaintFlagsDrawFilter afUS;
  private PaintFlagsDrawFilter afUT;
  private Matrix avQ;
  private int bkR;
  private Drawable kD;
  private ColorFilter kx;
  private int mAlpha;
  private Context mContext;
  private int mLevel;
  private Uri mUri;
  private boolean tG;
  private int vF;
  
  public QImageView(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
    AppMethodBeat.i(156564);
    this.mContext = paramContext;
    initImageView();
    AppMethodBeat.o(156564);
  }
  
  public QImageView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(156565);
    this.afUE = 0;
    this.afUG = false;
    this.afUH = false;
    this.vF = 2147483647;
    this.bkR = 2147483647;
    this.mAlpha = 255;
    this.afUI = 256;
    this.afUJ = false;
    this.kD = null;
    this.afUK = null;
    this.afUL = false;
    this.mLevel = 0;
    this.afUO = null;
    this.afUP = new RectF();
    this.afUQ = new RectF();
    this.tG = false;
    this.mContext = paramContext;
    initImageView();
    this.tG = false;
    setAdjustViewBounds(false);
    setMaxWidth(2147483647);
    setMaxHeight(2147483647);
    this.afUR = false;
    AppMethodBeat.o(156565);
  }
  
  private void W(Drawable paramDrawable)
  {
    AppMethodBeat.i(156583);
    if (this.kD != null)
    {
      this.kD.setCallback(null);
      unscheduleDrawable(this.kD);
    }
    this.kD = paramDrawable;
    if (paramDrawable != null)
    {
      paramDrawable.setCallback(this);
      if (paramDrawable.isStateful()) {
        paramDrawable.setState(getDrawableState());
      }
      paramDrawable.setLevel(this.mLevel);
      this.afUM = paramDrawable.getIntrinsicWidth();
      this.afUN = paramDrawable.getIntrinsicHeight();
      jFb();
      jFa();
    }
    AppMethodBeat.o(156583);
  }
  
  private static Matrix.ScaleToFit a(a parama)
  {
    return afUV[(parama.afVe - 1)];
  }
  
  private static int bz(int paramInt1, int paramInt2, int paramInt3)
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
  
  private void initImageView()
  {
    AppMethodBeat.i(156566);
    this.avQ = new Matrix();
    this.afUF = a.afUZ;
    this.afUS = new PaintFlagsDrawFilter(0, 3);
    this.afUT = new PaintFlagsDrawFilter(0, 0);
    AppMethodBeat.o(156566);
  }
  
  private void jEY()
  {
    Object localObject1 = null;
    AppMethodBeat.i(156577);
    if (this.kD != null)
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
    if (this.afUE != 0) {}
    while (this.mUri != null)
    {
      try
      {
        localObject2 = ((Resources)localObject2).getDrawable(this.afUE);
        localObject1 = localObject2;
      }
      catch (Exception localException)
      {
        for (;;)
        {
          Log.w("ImageView", "Unable to find resource: " + this.afUE, new Object[] { localException });
          this.mUri = null;
        }
      }
      W(localObject1);
      AppMethodBeat.o(156577);
      return;
    }
    AppMethodBeat.o(156577);
  }
  
  private void jEZ()
  {
    AppMethodBeat.i(156584);
    Drawable localDrawable = this.kD;
    if (localDrawable != null)
    {
      int j = localDrawable.getIntrinsicWidth();
      int i = j;
      if (j < 0) {
        i = this.afUM;
      }
      int k = localDrawable.getIntrinsicHeight();
      j = k;
      if (k < 0) {
        j = this.afUN;
      }
      if ((i != this.afUM) || (j != this.afUN))
      {
        this.afUM = i;
        this.afUN = j;
        requestLayout();
      }
    }
    AppMethodBeat.o(156584);
  }
  
  private void jFa()
  {
    AppMethodBeat.i(156588);
    if ((this.kD == null) || (!this.afUG))
    {
      AppMethodBeat.o(156588);
      return;
    }
    int j = this.afUM;
    int k = this.afUN;
    int m = getWidth() - getPaddingLeft() - getPaddingRight();
    int n = getHeight() - getPaddingTop() - getPaddingBottom();
    if (((j < 0) || (m == j)) && ((k < 0) || (n == k))) {}
    for (int i = 1; (j <= 0) || (k <= 0) || (a.afUX == this.afUF); i = 0)
    {
      this.kD.setBounds(0, 0, m, n);
      this.afUO = null;
      AppMethodBeat.o(156588);
      return;
    }
    this.kD.setBounds(0, 0, j, k);
    if (a.afUW == this.afUF)
    {
      if (this.avQ.isIdentity())
      {
        this.afUO = null;
        AppMethodBeat.o(156588);
        return;
      }
      this.afUO = this.avQ;
      AppMethodBeat.o(156588);
      return;
    }
    if (i != 0)
    {
      this.afUO = null;
      AppMethodBeat.o(156588);
      return;
    }
    if (a.afVb == this.afUF)
    {
      this.afUO = this.avQ;
      this.afUO.setTranslate((int)((m - j) * 0.5F + 0.5F), (int)((n - k) * 0.5F + 0.5F));
      AppMethodBeat.o(156588);
      return;
    }
    float f3;
    float f2;
    float f1;
    if (a.afVc == this.afUF)
    {
      this.afUO = this.avQ;
      if (j * n > m * k)
      {
        f3 = n / k;
        f2 = (m - j * f3) * 0.5F;
        f1 = 0.0F;
      }
      for (;;)
      {
        this.afUO.setScale(f3, f3);
        this.afUO.postTranslate((int)(f2 + 0.5F), (int)(f1 + 0.5F));
        AppMethodBeat.o(156588);
        return;
        f3 = m / j;
        f1 = (n - k * f3) * 0.5F;
        f2 = 0.0F;
      }
    }
    if (a.afVd == this.afUF)
    {
      this.afUO = this.avQ;
      if ((j <= m) && (k <= n)) {}
      for (f1 = 1.0F;; f1 = Math.min(m / j, n / k))
      {
        f2 = (int)((m - j * f1) * 0.5F + 0.5F);
        f3 = (int)((n - k * f1) * 0.5F + 0.5F);
        this.afUO.setScale(f1, f1);
        this.afUO.postTranslate(f2, f3);
        AppMethodBeat.o(156588);
        return;
      }
    }
    this.afUP.set(0.0F, 0.0F, j, k);
    this.afUQ.set(0.0F, 0.0F, m, n);
    this.afUO = this.avQ;
    this.afUO.setRectToRect(this.afUP, this.afUQ, a(this.afUF));
    AppMethodBeat.o(156588);
  }
  
  private void jFb()
  {
    AppMethodBeat.i(156595);
    if ((this.kD != null) && (this.afUJ))
    {
      this.kD = this.kD.mutate();
      this.kD.setColorFilter(this.kx);
      this.kD.setAlpha(this.mAlpha * this.afUI >> 8);
    }
    AppMethodBeat.o(156595);
  }
  
  protected void drawableStateChanged()
  {
    AppMethodBeat.i(156589);
    super.drawableStateChanged();
    Drawable localDrawable = this.kD;
    if ((localDrawable != null) && (localDrawable.isStateful())) {
      localDrawable.setState(getDrawableState());
    }
    AppMethodBeat.o(156589);
  }
  
  public int getBaseline()
  {
    AppMethodBeat.i(156591);
    if (this.tG)
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
    return this.kD;
  }
  
  public Matrix getImageMatrix()
  {
    return this.avQ;
  }
  
  public a getScaleType()
  {
    return this.afUF;
  }
  
  public void invalidateDrawable(Drawable paramDrawable)
  {
    AppMethodBeat.i(156568);
    if (paramDrawable == this.kD)
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
    if (this.afUK == null)
    {
      arrayOfInt = super.onCreateDrawableState(paramInt);
      AppMethodBeat.o(156582);
      return arrayOfInt;
    }
    if (!this.afUL)
    {
      arrayOfInt = this.afUK;
      AppMethodBeat.o(156582);
      return arrayOfInt;
    }
    int[] arrayOfInt = mergeDrawableStates(super.onCreateDrawableState(this.afUK.length + paramInt), this.afUK);
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
    paramCanvas.setDrawFilter(this.afUS);
    super.onDraw(paramCanvas);
    if (this.kD == null)
    {
      AppMethodBeat.o(156590);
      return;
    }
    if ((this.afUM == 0) || (this.afUN == 0))
    {
      AppMethodBeat.o(156590);
      return;
    }
    if ((this.afUO == null) && (getPaddingTop() == 0) && (getPaddingLeft() == 0)) {
      this.kD.draw(paramCanvas);
    }
    for (;;)
    {
      if (Build.VERSION.SDK_INT > 28) {
        paramCanvas.setDrawFilter(this.afUT);
      }
      AppMethodBeat.o(156590);
      return;
      int i = paramCanvas.getSaveCount();
      paramCanvas.save();
      if (this.afUR)
      {
        int j = getScrollX();
        int k = getScrollY();
        paramCanvas.clipRect(getPaddingLeft() + j, getPaddingTop() + k, j + getRight() - getLeft() - getPaddingRight(), k + getBottom() - getTop() - getPaddingBottom());
      }
      paramCanvas.translate(getPaddingLeft(), getPaddingTop());
      if (this.afUO != null) {
        paramCanvas.concat(this.afUO);
      }
      this.kD.draw(paramCanvas);
      paramCanvas.restoreToCount(i);
    }
  }
  
  protected void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    AppMethodBeat.i(156587);
    this.afUG = true;
    jFa();
    AppMethodBeat.o(156587);
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(156585);
    jEY();
    float f = 0.0F;
    int k = 0;
    int m = 0;
    int j;
    int i;
    if (this.kD == null)
    {
      this.afUM = -1;
      this.afUN = -1;
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
        paramInt1 = bz(j + i2 + i3, this.vF, paramInt1);
        paramInt2 = bz(i + n + i1, this.bkR, paramInt2);
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
        i = this.afUM;
        n = this.afUN;
        j = i;
        if (i <= 0) {
          j = 1;
        }
        i = n;
        if (n <= 0) {
          i = 1;
        }
        if (!this.afUH) {
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
      if (this.afUI != paramInt)
      {
        this.afUI = paramInt;
        this.afUJ = true;
        jFb();
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
    this.afUH = paramBoolean;
    if (paramBoolean) {
      setScaleType(a.afUZ);
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
      this.afUJ = true;
      jFb();
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
    if (this.kx != paramColorFilter)
    {
      this.kx = paramColorFilter;
      this.afUJ = true;
      jFb();
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
    if (this.kD != paramDrawable)
    {
      this.afUE = 0;
      this.mUri = null;
      W(paramDrawable);
      invalidate();
    }
    AppMethodBeat.o(156574);
  }
  
  public void setImageLevel(int paramInt)
  {
    AppMethodBeat.i(156579);
    this.mLevel = paramInt;
    if (this.kD != null)
    {
      this.kD.setLevel(paramInt);
      jEZ();
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
    if (((localMatrix == null) && (!this.avQ.isIdentity())) || ((localMatrix != null) && (!this.avQ.equals(localMatrix))))
    {
      this.avQ.set(localMatrix);
      jFa();
      invalidate();
    }
    AppMethodBeat.o(156581);
  }
  
  public void setImageResource(int paramInt)
  {
    AppMethodBeat.i(156571);
    if ((this.mUri != null) || (this.afUE != paramInt))
    {
      W(null);
      this.afUE = paramInt;
      this.mUri = null;
      jEY();
      invalidate();
    }
    AppMethodBeat.o(156571);
  }
  
  public void setImageURI(Uri paramUri)
  {
    AppMethodBeat.i(156573);
    if ((this.afUE != 0) || ((this.mUri != paramUri) && ((paramUri == null) || (this.mUri == null) || (!paramUri.equals(this.mUri)))))
    {
      W(null);
      this.afUE = 0;
      this.mUri = paramUri;
      jEY();
      invalidate();
    }
    AppMethodBeat.o(156573);
  }
  
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
    this.bkR = paramInt;
  }
  
  public void setMaxWidth(int paramInt)
  {
    this.vF = paramInt;
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
    if (this.afUF != parama)
    {
      this.afUF = parama;
      if (this.afUF != a.afVb) {
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
    jEZ();
    AppMethodBeat.o(156578);
  }
  
  protected boolean verifyDrawable(Drawable paramDrawable)
  {
    AppMethodBeat.i(156567);
    if ((this.kD == paramDrawable) || (super.verifyDrawable(paramDrawable)))
    {
      AppMethodBeat.o(156567);
      return true;
    }
    AppMethodBeat.o(156567);
    return false;
  }
  
  public static enum a
  {
    final int afVe;
    
    static
    {
      AppMethodBeat.i(156563);
      afUW = new a("MATRIX", 0, 0);
      afUX = new a("FIT_XY", 1, 1);
      afUY = new a("FIT_START", 2, 2);
      afUZ = new a("FIT_CENTER", 3, 3);
      afVa = new a("FIT_END", 4, 4);
      afVb = new a("CENTER", 5, 5);
      afVc = new a("CENTER_CROP", 6, 6);
      afVd = new a("CENTER_INSIDE", 7, 7);
      afVf = new a[] { afUW, afUX, afUY, afUZ, afVa, afVb, afVc, afVd };
      AppMethodBeat.o(156563);
    }
    
    private a(int paramInt)
    {
      this.afVe = paramInt;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     com.tencent.mm.ui.widget.QImageView
 * JD-Core Version:    0.7.0.1
 */