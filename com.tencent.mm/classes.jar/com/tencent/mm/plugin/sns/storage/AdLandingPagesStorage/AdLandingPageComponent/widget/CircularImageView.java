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
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.sns.i.a;

public class CircularImageView
  extends ImageView
{
  private static final String TAG;
  private int borderWidth;
  private boolean isSelected;
  private boolean lW;
  private float lw;
  private float lx;
  private Paint paint;
  private int shadowColor;
  private float shadowRadius;
  private Bitmap zJA;
  private Paint zJB;
  private Paint zJC;
  private ColorFilter zJD;
  private boolean zJv;
  private boolean zJw;
  private int zJx;
  private int zJy;
  private BitmapShader zJz;
  
  static
  {
    AppMethodBeat.i(97178);
    TAG = CircularImageView.class.getSimpleName();
    AppMethodBeat.o(97178);
  }
  
  public CircularImageView(Context paramContext)
  {
    this(paramContext, null, 0);
  }
  
  public CircularImageView(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public CircularImageView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(97162);
    this.paint = new Paint();
    this.paint.setAntiAlias(true);
    this.zJB = new Paint();
    this.zJB.setAntiAlias(true);
    this.zJB.setStyle(Paint.Style.STROKE);
    this.zJC = new Paint();
    this.zJC.setAntiAlias(true);
    if (Build.VERSION.SDK_INT >= 11) {
      setLayerType(1, null);
    }
    paramAttributeSet = paramContext.obtainStyledAttributes(paramAttributeSet, i.a.CircularImageView, paramInt, 0);
    this.zJv = paramAttributeSet.getBoolean(0, false);
    this.zJw = paramAttributeSet.getBoolean(3, false);
    this.lW = paramAttributeSet.getBoolean(7, false);
    if (this.zJv)
    {
      setBorderWidth(paramAttributeSet.getDimensionPixelOffset(2, (int)(paramContext.getResources().getDisplayMetrics().density * 2.0F + 0.5F)));
      setBorderColor(paramAttributeSet.getColor(1, -1));
    }
    if (this.zJw)
    {
      paramInt = (int)(paramContext.getResources().getDisplayMetrics().density * 2.0F + 0.5F);
      setSelectorColor(paramAttributeSet.getColor(4, 0));
      setSelectorStrokeWidth(paramAttributeSet.getDimensionPixelOffset(6, paramInt));
      setSelectorStrokeColor(paramAttributeSet.getColor(5, -16776961));
    }
    if (this.lW)
    {
      this.shadowRadius = paramAttributeSet.getFloat(11, 4.0F);
      this.lw = paramAttributeSet.getFloat(9, 0.0F);
      this.lx = paramAttributeSet.getFloat(10, 2.0F);
      this.shadowColor = paramAttributeSet.getColor(8, -16777216);
      setShadowEnabled(true);
    }
    paramAttributeSet.recycle();
    AppMethodBeat.o(97162);
  }
  
  private void dXR()
  {
    AppMethodBeat.i(97177);
    if (this.zJA == null)
    {
      AppMethodBeat.o(97177);
      return;
    }
    Object localObject = this.zJA;
    Shader.TileMode localTileMode = Shader.TileMode.CLAMP;
    this.zJz = new BitmapShader((Bitmap)localObject, localTileMode, localTileMode);
    if ((this.zJx != this.zJA.getWidth()) || (this.zJx != this.zJA.getHeight()))
    {
      localObject = new Matrix();
      float f = this.zJx / this.zJA.getWidth();
      ((Matrix)localObject).setScale(f, f);
      this.zJz.setLocalMatrix((Matrix)localObject);
    }
    AppMethodBeat.o(97177);
  }
  
  private static Bitmap drawableToBitmap(Drawable paramDrawable)
  {
    AppMethodBeat.i(97176);
    if (paramDrawable == null)
    {
      AppMethodBeat.o(97176);
      return null;
    }
    if ((paramDrawable instanceof BitmapDrawable))
    {
      paramDrawable = ((BitmapDrawable)paramDrawable).getBitmap();
      AppMethodBeat.o(97176);
      return paramDrawable;
    }
    int i = paramDrawable.getIntrinsicWidth();
    int j = paramDrawable.getIntrinsicHeight();
    if ((i <= 0) || (j <= 0))
    {
      AppMethodBeat.o(97176);
      return null;
    }
    try
    {
      Bitmap localBitmap = Bitmap.createBitmap(i, j, Bitmap.Config.ARGB_8888);
      Canvas localCanvas = new Canvas(localBitmap);
      paramDrawable.setBounds(0, 0, localCanvas.getWidth(), localCanvas.getHeight());
      paramDrawable.draw(localCanvas);
      AppMethodBeat.o(97176);
      return localBitmap;
    }
    catch (OutOfMemoryError paramDrawable)
    {
      AppMethodBeat.o(97176);
    }
    return null;
  }
  
  public boolean dispatchTouchEvent(MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(97170);
    boolean bool;
    if (!isClickable())
    {
      this.isSelected = false;
      bool = super.onTouchEvent(paramMotionEvent);
      AppMethodBeat.o(97170);
      return bool;
    }
    switch (paramMotionEvent.getAction())
    {
    }
    for (;;)
    {
      invalidate();
      bool = super.dispatchTouchEvent(paramMotionEvent);
      AppMethodBeat.o(97170);
      return bool;
      this.isSelected = true;
      continue;
      this.isSelected = false;
    }
  }
  
  public boolean isSelected()
  {
    return this.isSelected;
  }
  
  public void onDraw(Canvas paramCanvas)
  {
    int j = 0;
    AppMethodBeat.i(97169);
    if (this.zJA == null)
    {
      AppMethodBeat.o(97169);
      return;
    }
    if ((this.zJA.getHeight() == 0) || (this.zJA.getWidth() == 0))
    {
      AppMethodBeat.o(97169);
      return;
    }
    int k = this.zJx;
    int i;
    if (getWidth() < getHeight())
    {
      i = getWidth();
      this.zJx = i;
      if (k != this.zJx) {
        dXR();
      }
      this.paint.setShader(this.zJz);
      i = this.zJx / 2;
      if ((!this.zJw) || (!this.isSelected)) {
        break label224;
      }
      j = this.zJy;
      i = (this.zJx - j * 2) / 2;
      this.paint.setColorFilter(this.zJD);
      paramCanvas.drawCircle(i + j, i + j, (this.zJx - j * 2) / 2 + j - 4.0F, this.zJC);
    }
    for (;;)
    {
      paramCanvas.drawCircle(i + j, i + j, (this.zJx - j * 2) / 2, this.paint);
      AppMethodBeat.o(97169);
      return;
      i = getHeight();
      break;
      label224:
      if (this.zJv)
      {
        j = this.borderWidth;
        i = (this.zJx - j * 2) / 2;
        this.paint.setColorFilter(null);
        paramCanvas.drawArc(new RectF(j / 2 + 0, j / 2 + 0, this.zJx - j / 2, this.zJx - j / 2), 360.0F, 360.0F, false, this.zJB);
      }
      else
      {
        this.paint.setColorFilter(null);
      }
    }
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(97175);
    int i = View.MeasureSpec.getMode(paramInt1);
    paramInt1 = View.MeasureSpec.getSize(paramInt1);
    if (i == 1073741824)
    {
      i = View.MeasureSpec.getMode(paramInt2);
      paramInt2 = View.MeasureSpec.getSize(paramInt2);
      if (i != 1073741824) {
        break label70;
      }
    }
    for (;;)
    {
      setMeasuredDimension(paramInt1, paramInt2 + 2);
      AppMethodBeat.o(97175);
      return;
      if (i == -2147483648) {
        break;
      }
      paramInt1 = this.zJx;
      break;
      label70:
      if (i != -2147483648) {
        paramInt2 = this.zJx;
      }
    }
  }
  
  public void setBorderColor(int paramInt)
  {
    AppMethodBeat.i(97164);
    if (this.zJB != null) {
      this.zJB.setColor(paramInt);
    }
    invalidate();
    AppMethodBeat.o(97164);
  }
  
  public void setBorderWidth(int paramInt)
  {
    AppMethodBeat.i(97163);
    this.borderWidth = paramInt;
    if (this.zJB != null) {
      this.zJB.setStrokeWidth(paramInt);
    }
    requestLayout();
    invalidate();
    AppMethodBeat.o(97163);
  }
  
  public void setIconModeEnabled(boolean paramBoolean) {}
  
  public void setImageBitmap(Bitmap paramBitmap)
  {
    AppMethodBeat.i(97174);
    super.setImageBitmap(paramBitmap);
    this.zJA = paramBitmap;
    if (this.zJx > 0) {
      dXR();
    }
    AppMethodBeat.o(97174);
  }
  
  public void setImageDrawable(Drawable paramDrawable)
  {
    AppMethodBeat.i(97173);
    super.setImageDrawable(paramDrawable);
    this.zJA = drawableToBitmap(getDrawable());
    if (this.zJx > 0) {
      dXR();
    }
    AppMethodBeat.o(97173);
  }
  
  public void setImageResource(int paramInt)
  {
    AppMethodBeat.i(97172);
    super.setImageResource(paramInt);
    this.zJA = drawableToBitmap(getDrawable());
    if (this.zJx > 0) {
      dXR();
    }
    AppMethodBeat.o(97172);
  }
  
  public void setImageURI(Uri paramUri)
  {
    AppMethodBeat.i(97171);
    super.setImageURI(paramUri);
    this.zJA = drawableToBitmap(getDrawable());
    if (this.zJx > 0) {
      dXR();
    }
    AppMethodBeat.o(97171);
  }
  
  public void setSelectorColor(int paramInt)
  {
    AppMethodBeat.i(97165);
    this.zJD = new PorterDuffColorFilter(paramInt, PorterDuff.Mode.SRC_ATOP);
    invalidate();
    AppMethodBeat.o(97165);
  }
  
  public void setSelectorStrokeColor(int paramInt)
  {
    AppMethodBeat.i(97167);
    if (this.zJC != null) {
      this.zJC.setColor(paramInt);
    }
    invalidate();
    AppMethodBeat.o(97167);
  }
  
  public void setSelectorStrokeWidth(int paramInt)
  {
    AppMethodBeat.i(97166);
    this.zJy = paramInt;
    requestLayout();
    invalidate();
    AppMethodBeat.o(97166);
  }
  
  public void setShadowEnabled(boolean paramBoolean)
  {
    AppMethodBeat.i(97168);
    this.lW = paramBoolean;
    if (this.lW) {}
    for (float f = this.shadowRadius;; f = 0.0F)
    {
      this.zJB.setShadowLayer(f, this.lw, this.lx, this.shadowColor);
      this.zJC.setShadowLayer(f, this.lw, this.lx, this.shadowColor);
      AppMethodBeat.o(97168);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.widget.CircularImageView
 * JD-Core Version:    0.7.0.1
 */