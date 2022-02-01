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
  private float iH;
  private float iI;
  private boolean ira;
  private boolean jh;
  private Paint paint;
  private int shadowColor;
  private float shadowRadius;
  private boolean xfA;
  private int xfB;
  private int xfC;
  private BitmapShader xfD;
  private Bitmap xfE;
  private Paint xfF;
  private Paint xfG;
  private ColorFilter xfH;
  private boolean xfz;
  
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
    this.xfF = new Paint();
    this.xfF.setAntiAlias(true);
    this.xfF.setStyle(Paint.Style.STROKE);
    this.xfG = new Paint();
    this.xfG.setAntiAlias(true);
    if (Build.VERSION.SDK_INT >= 11) {
      setLayerType(1, null);
    }
    paramAttributeSet = paramContext.obtainStyledAttributes(paramAttributeSet, i.a.CircularImageView, paramInt, 0);
    this.xfz = paramAttributeSet.getBoolean(0, false);
    this.xfA = paramAttributeSet.getBoolean(3, false);
    this.jh = paramAttributeSet.getBoolean(7, false);
    if (this.xfz)
    {
      setBorderWidth(paramAttributeSet.getDimensionPixelOffset(2, (int)(paramContext.getResources().getDisplayMetrics().density * 2.0F + 0.5F)));
      setBorderColor(paramAttributeSet.getColor(1, -1));
    }
    if (this.xfA)
    {
      paramInt = (int)(paramContext.getResources().getDisplayMetrics().density * 2.0F + 0.5F);
      setSelectorColor(paramAttributeSet.getColor(4, 0));
      setSelectorStrokeWidth(paramAttributeSet.getDimensionPixelOffset(6, paramInt));
      setSelectorStrokeColor(paramAttributeSet.getColor(5, -16776961));
    }
    if (this.jh)
    {
      this.shadowRadius = paramAttributeSet.getFloat(11, 4.0F);
      this.iH = paramAttributeSet.getFloat(9, 0.0F);
      this.iI = paramAttributeSet.getFloat(10, 2.0F);
      this.shadowColor = paramAttributeSet.getColor(8, -16777216);
      setShadowEnabled(true);
    }
    paramAttributeSet.recycle();
    AppMethodBeat.o(97162);
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
  
  private void dxc()
  {
    AppMethodBeat.i(97177);
    if (this.xfE == null)
    {
      AppMethodBeat.o(97177);
      return;
    }
    Object localObject = this.xfE;
    Shader.TileMode localTileMode = Shader.TileMode.CLAMP;
    this.xfD = new BitmapShader((Bitmap)localObject, localTileMode, localTileMode);
    if ((this.xfB != this.xfE.getWidth()) || (this.xfB != this.xfE.getHeight()))
    {
      localObject = new Matrix();
      float f = this.xfB / this.xfE.getWidth();
      ((Matrix)localObject).setScale(f, f);
      this.xfD.setLocalMatrix((Matrix)localObject);
    }
    AppMethodBeat.o(97177);
  }
  
  public boolean dispatchTouchEvent(MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(97170);
    boolean bool;
    if (!isClickable())
    {
      this.ira = false;
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
      this.ira = true;
      continue;
      this.ira = false;
    }
  }
  
  public boolean isSelected()
  {
    return this.ira;
  }
  
  public void onDraw(Canvas paramCanvas)
  {
    int j = 0;
    AppMethodBeat.i(97169);
    if (this.xfE == null)
    {
      AppMethodBeat.o(97169);
      return;
    }
    if ((this.xfE.getHeight() == 0) || (this.xfE.getWidth() == 0))
    {
      AppMethodBeat.o(97169);
      return;
    }
    int k = this.xfB;
    int i;
    if (getWidth() < getHeight())
    {
      i = getWidth();
      this.xfB = i;
      if (k != this.xfB) {
        dxc();
      }
      this.paint.setShader(this.xfD);
      i = this.xfB / 2;
      if ((!this.xfA) || (!this.ira)) {
        break label224;
      }
      j = this.xfC;
      i = (this.xfB - j * 2) / 2;
      this.paint.setColorFilter(this.xfH);
      paramCanvas.drawCircle(i + j, i + j, (this.xfB - j * 2) / 2 + j - 4.0F, this.xfG);
    }
    for (;;)
    {
      paramCanvas.drawCircle(i + j, i + j, (this.xfB - j * 2) / 2, this.paint);
      AppMethodBeat.o(97169);
      return;
      i = getHeight();
      break;
      label224:
      if (this.xfz)
      {
        j = this.borderWidth;
        i = (this.xfB - j * 2) / 2;
        this.paint.setColorFilter(null);
        paramCanvas.drawArc(new RectF(j / 2 + 0, j / 2 + 0, this.xfB - j / 2, this.xfB - j / 2), 360.0F, 360.0F, false, this.xfF);
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
      paramInt1 = this.xfB;
      break;
      label70:
      if (i != -2147483648) {
        paramInt2 = this.xfB;
      }
    }
  }
  
  public void setBorderColor(int paramInt)
  {
    AppMethodBeat.i(97164);
    if (this.xfF != null) {
      this.xfF.setColor(paramInt);
    }
    invalidate();
    AppMethodBeat.o(97164);
  }
  
  public void setBorderWidth(int paramInt)
  {
    AppMethodBeat.i(97163);
    this.borderWidth = paramInt;
    if (this.xfF != null) {
      this.xfF.setStrokeWidth(paramInt);
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
    this.xfE = paramBitmap;
    if (this.xfB > 0) {
      dxc();
    }
    AppMethodBeat.o(97174);
  }
  
  public void setImageDrawable(Drawable paramDrawable)
  {
    AppMethodBeat.i(97173);
    super.setImageDrawable(paramDrawable);
    this.xfE = drawableToBitmap(getDrawable());
    if (this.xfB > 0) {
      dxc();
    }
    AppMethodBeat.o(97173);
  }
  
  public void setImageResource(int paramInt)
  {
    AppMethodBeat.i(97172);
    super.setImageResource(paramInt);
    this.xfE = drawableToBitmap(getDrawable());
    if (this.xfB > 0) {
      dxc();
    }
    AppMethodBeat.o(97172);
  }
  
  public void setImageURI(Uri paramUri)
  {
    AppMethodBeat.i(97171);
    super.setImageURI(paramUri);
    this.xfE = drawableToBitmap(getDrawable());
    if (this.xfB > 0) {
      dxc();
    }
    AppMethodBeat.o(97171);
  }
  
  public void setSelectorColor(int paramInt)
  {
    AppMethodBeat.i(97165);
    this.xfH = new PorterDuffColorFilter(paramInt, PorterDuff.Mode.SRC_ATOP);
    invalidate();
    AppMethodBeat.o(97165);
  }
  
  public void setSelectorStrokeColor(int paramInt)
  {
    AppMethodBeat.i(97167);
    if (this.xfG != null) {
      this.xfG.setColor(paramInt);
    }
    invalidate();
    AppMethodBeat.o(97167);
  }
  
  public void setSelectorStrokeWidth(int paramInt)
  {
    AppMethodBeat.i(97166);
    this.xfC = paramInt;
    requestLayout();
    invalidate();
    AppMethodBeat.o(97166);
  }
  
  public void setShadowEnabled(boolean paramBoolean)
  {
    AppMethodBeat.i(97168);
    this.jh = paramBoolean;
    if (this.jh) {}
    for (float f = this.shadowRadius;; f = 0.0F)
    {
      this.xfF.setShadowLayer(f, this.iH, this.iI, this.shadowColor);
      this.xfG.setShadowLayer(f, this.iH, this.iI, this.shadowColor);
      AppMethodBeat.o(97168);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.widget.CircularImageView
 * JD-Core Version:    0.7.0.1
 */