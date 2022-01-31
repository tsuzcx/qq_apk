package com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.widget;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.BitmapShader;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.graphics.PorterDuff.Mode;
import android.graphics.PorterDuffColorFilter;
import android.graphics.RectF;
import android.graphics.Shader.TileMode;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Build.VERSION;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.MotionEvent;
import android.view.View.MeasureSpec;
import android.widget.ImageView;
import com.tencent.mm.plugin.sns.i.l;

public class CircularImageView
  extends ImageView
{
  private static final String TAG = CircularImageView.class.getSimpleName();
  private int borderWidth;
  private boolean fmm;
  private Paint gaZ = new Paint();
  private boolean oJS;
  private boolean oJT;
  private int oJU;
  private int oJV;
  private boolean oJW;
  private float oJX;
  private BitmapShader oJY;
  private Bitmap oJZ;
  private Paint oKa;
  private Paint oKb;
  private ColorFilter oKc;
  private int shadowColor;
  private float shadowDx;
  private float shadowDy;
  
  public CircularImageView(Context paramContext)
  {
    this(paramContext, null, i.l.CircularImageViewStyle_circularImageViewDefault);
  }
  
  public CircularImageView(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, i.l.CircularImageViewStyle_circularImageViewDefault);
  }
  
  public CircularImageView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    this.gaZ.setAntiAlias(true);
    this.oKa = new Paint();
    this.oKa.setAntiAlias(true);
    this.oKa.setStyle(Paint.Style.STROKE);
    this.oKb = new Paint();
    this.oKb.setAntiAlias(true);
    if (Build.VERSION.SDK_INT >= 11) {
      setLayerType(1, null);
    }
    paramAttributeSet = paramContext.obtainStyledAttributes(paramAttributeSet, i.l.CircularImageView, paramInt, 0);
    this.oJS = paramAttributeSet.getBoolean(i.l.CircularImageView_civ_border, false);
    this.oJT = paramAttributeSet.getBoolean(i.l.CircularImageView_civ_selector, false);
    this.oJW = paramAttributeSet.getBoolean(i.l.CircularImageView_civ_shadow, false);
    if (this.oJS)
    {
      paramInt = (int)(paramContext.getResources().getDisplayMetrics().density * 2.0F + 0.5F);
      setBorderWidth(paramAttributeSet.getDimensionPixelOffset(i.l.CircularImageView_civ_borderWidth, paramInt));
      setBorderColor(paramAttributeSet.getColor(i.l.CircularImageView_civ_borderColor, -1));
    }
    if (this.oJT)
    {
      paramInt = (int)(paramContext.getResources().getDisplayMetrics().density * 2.0F + 0.5F);
      setSelectorColor(paramAttributeSet.getColor(i.l.CircularImageView_civ_selectorColor, 0));
      setSelectorStrokeWidth(paramAttributeSet.getDimensionPixelOffset(i.l.CircularImageView_civ_selectorStrokeWidth, paramInt));
      setSelectorStrokeColor(paramAttributeSet.getColor(i.l.CircularImageView_civ_selectorStrokeColor, -16776961));
    }
    if (this.oJW)
    {
      this.oJX = paramAttributeSet.getFloat(i.l.CircularImageView_civ_shadowRadius, 4.0F);
      this.shadowDx = paramAttributeSet.getFloat(i.l.CircularImageView_civ_shadowDx, 0.0F);
      this.shadowDy = paramAttributeSet.getFloat(i.l.CircularImageView_civ_shadowDy, 2.0F);
      this.shadowColor = paramAttributeSet.getColor(i.l.CircularImageView_civ_shadowColor, -16777216);
      setShadowEnabled(true);
    }
    paramAttributeSet.recycle();
  }
  
  private void bFS()
  {
    if (this.oJZ == null) {}
    do
    {
      return;
      this.oJY = new BitmapShader(this.oJZ, Shader.TileMode.CLAMP, Shader.TileMode.CLAMP);
    } while ((this.oJU == this.oJZ.getWidth()) && (this.oJU == this.oJZ.getHeight()));
    Matrix localMatrix = new Matrix();
    float f = this.oJU / this.oJZ.getWidth();
    localMatrix.setScale(f, f);
    this.oJY.setLocalMatrix(localMatrix);
  }
  
  private static Bitmap drawableToBitmap(Drawable paramDrawable)
  {
    if (paramDrawable == null) {}
    int i;
    int j;
    do
    {
      return null;
      if ((paramDrawable instanceof BitmapDrawable)) {
        return ((BitmapDrawable)paramDrawable).getBitmap();
      }
      i = paramDrawable.getIntrinsicWidth();
      j = paramDrawable.getIntrinsicHeight();
    } while ((i <= 0) || (j <= 0));
    try
    {
      Bitmap localBitmap = Bitmap.createBitmap(i, j, Bitmap.Config.ARGB_8888);
      Canvas localCanvas = new Canvas(localBitmap);
      paramDrawable.setBounds(0, 0, localCanvas.getWidth(), localCanvas.getHeight());
      paramDrawable.draw(localCanvas);
      return localBitmap;
    }
    catch (OutOfMemoryError paramDrawable) {}
    return null;
  }
  
  public boolean dispatchTouchEvent(MotionEvent paramMotionEvent)
  {
    if (!isClickable())
    {
      this.fmm = false;
      return super.onTouchEvent(paramMotionEvent);
    }
    switch (paramMotionEvent.getAction())
    {
    }
    for (;;)
    {
      invalidate();
      return super.dispatchTouchEvent(paramMotionEvent);
      this.fmm = true;
      continue;
      this.fmm = false;
    }
  }
  
  public boolean isSelected()
  {
    return this.fmm;
  }
  
  public void onDraw(Canvas paramCanvas)
  {
    int j = 0;
    if (this.oJZ == null) {}
    while ((this.oJZ.getHeight() == 0) || (this.oJZ.getWidth() == 0)) {
      return;
    }
    int k = this.oJU;
    int i;
    if (getWidth() < getHeight())
    {
      i = getWidth();
      this.oJU = i;
      if (k != this.oJU) {
        bFS();
      }
      this.gaZ.setShader(this.oJY);
      i = this.oJU / 2;
      if ((!this.oJT) || (!this.fmm)) {
        break label199;
      }
      j = this.oJV;
      i = (this.oJU - j * 2) / 2;
      this.gaZ.setColorFilter(this.oKc);
      paramCanvas.drawCircle(i + j, i + j, (this.oJU - j * 2) / 2 + j - 4.0F, this.oKb);
    }
    for (;;)
    {
      paramCanvas.drawCircle(i + j, i + j, (this.oJU - j * 2) / 2, this.gaZ);
      return;
      i = getHeight();
      break;
      label199:
      if (this.oJS)
      {
        j = this.borderWidth;
        i = (this.oJU - j * 2) / 2;
        this.gaZ.setColorFilter(null);
        paramCanvas.drawArc(new RectF(j / 2 + 0, j / 2 + 0, this.oJU - j / 2, this.oJU - j / 2), 360.0F, 360.0F, false, this.oKa);
      }
      else
      {
        this.gaZ.setColorFilter(null);
      }
    }
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    int i = View.MeasureSpec.getMode(paramInt1);
    paramInt1 = View.MeasureSpec.getSize(paramInt1);
    if (i == 1073741824)
    {
      i = View.MeasureSpec.getMode(paramInt2);
      paramInt2 = View.MeasureSpec.getSize(paramInt2);
      if (i != 1073741824) {
        break label58;
      }
    }
    for (;;)
    {
      setMeasuredDimension(paramInt1, paramInt2 + 2);
      return;
      if (i == -2147483648) {
        break;
      }
      paramInt1 = this.oJU;
      break;
      label58:
      if (i != -2147483648) {
        paramInt2 = this.oJU;
      }
    }
  }
  
  public void setBorderColor(int paramInt)
  {
    if (this.oKa != null) {
      this.oKa.setColor(paramInt);
    }
    invalidate();
  }
  
  public void setBorderWidth(int paramInt)
  {
    this.borderWidth = paramInt;
    if (this.oKa != null) {
      this.oKa.setStrokeWidth(paramInt);
    }
    requestLayout();
    invalidate();
  }
  
  public void setIconModeEnabled(boolean paramBoolean) {}
  
  public void setImageBitmap(Bitmap paramBitmap)
  {
    super.setImageBitmap(paramBitmap);
    this.oJZ = paramBitmap;
    if (this.oJU > 0) {
      bFS();
    }
  }
  
  public void setImageDrawable(Drawable paramDrawable)
  {
    super.setImageDrawable(paramDrawable);
    this.oJZ = drawableToBitmap(getDrawable());
    if (this.oJU > 0) {
      bFS();
    }
  }
  
  public void setImageResource(int paramInt)
  {
    super.setImageResource(paramInt);
    this.oJZ = drawableToBitmap(getDrawable());
    if (this.oJU > 0) {
      bFS();
    }
  }
  
  public void setImageURI(Uri paramUri)
  {
    super.setImageURI(paramUri);
    this.oJZ = drawableToBitmap(getDrawable());
    if (this.oJU > 0) {
      bFS();
    }
  }
  
  public void setSelectorColor(int paramInt)
  {
    this.oKc = new PorterDuffColorFilter(paramInt, PorterDuff.Mode.SRC_ATOP);
    invalidate();
  }
  
  public void setSelectorStrokeColor(int paramInt)
  {
    if (this.oKb != null) {
      this.oKb.setColor(paramInt);
    }
    invalidate();
  }
  
  public void setSelectorStrokeWidth(int paramInt)
  {
    this.oJV = paramInt;
    requestLayout();
    invalidate();
  }
  
  public void setShadowEnabled(boolean paramBoolean)
  {
    this.oJW = paramBoolean;
    if (this.oJW) {}
    for (float f = this.oJX;; f = 0.0F)
    {
      this.oKa.setShadowLayer(f, this.shadowDx, this.shadowDy, this.shadowColor);
      this.oKb.setShadowLayer(f, this.shadowDx, this.shadowDy, this.shadowColor);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.widget.CircularImageView
 * JD-Core Version:    0.7.0.1
 */