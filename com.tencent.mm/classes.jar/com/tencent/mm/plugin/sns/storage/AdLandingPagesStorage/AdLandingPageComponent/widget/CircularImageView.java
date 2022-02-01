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
import com.tencent.mm.plugin.sns.b.l;

public class CircularImageView
  extends ImageView
{
  private static final String TAG;
  private boolean QUL;
  private boolean QUM;
  private int QUN;
  private int QUO;
  private BitmapShader QUP;
  private Bitmap QUQ;
  private Paint QUR;
  private Paint QUS;
  private ColorFilter QUT;
  private int borderWidth;
  private float dwq;
  private float dwr;
  private boolean dxd;
  private boolean isSelected;
  private Paint paint;
  private int shadowColor;
  private float shadowRadius;
  
  static
  {
    AppMethodBeat.i(97178);
    TAG = CircularImageView.class.getSimpleName();
    AppMethodBeat.o(97178);
  }
  
  public CircularImageView(Context paramContext)
  {
    this(paramContext, null, b.l.CircularImageViewStyle_circularImageViewDefault);
  }
  
  public CircularImageView(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, b.l.CircularImageViewStyle_circularImageViewDefault);
  }
  
  public CircularImageView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(97162);
    this.paint = new Paint();
    this.paint.setAntiAlias(true);
    this.QUR = new Paint();
    this.QUR.setAntiAlias(true);
    this.QUR.setStyle(Paint.Style.STROKE);
    this.QUS = new Paint();
    this.QUS.setAntiAlias(true);
    if (Build.VERSION.SDK_INT >= 11) {
      setLayerType(1, null);
    }
    paramAttributeSet = paramContext.obtainStyledAttributes(paramAttributeSet, b.l.CircularImageView, paramInt, 0);
    this.QUL = paramAttributeSet.getBoolean(b.l.CircularImageView_civ_border, false);
    this.QUM = paramAttributeSet.getBoolean(b.l.CircularImageView_civ_selector, false);
    this.dxd = paramAttributeSet.getBoolean(b.l.CircularImageView_civ_shadow, false);
    if (this.QUL)
    {
      paramInt = (int)(paramContext.getResources().getDisplayMetrics().density * 2.0F + 0.5F);
      setBorderWidth(paramAttributeSet.getDimensionPixelOffset(b.l.CircularImageView_civ_borderWidth, paramInt));
      setBorderColor(paramAttributeSet.getColor(b.l.CircularImageView_civ_borderColor, -1));
    }
    if (this.QUM)
    {
      paramInt = (int)(paramContext.getResources().getDisplayMetrics().density * 2.0F + 0.5F);
      setSelectorColor(paramAttributeSet.getColor(b.l.CircularImageView_civ_selectorColor, 0));
      setSelectorStrokeWidth(paramAttributeSet.getDimensionPixelOffset(b.l.CircularImageView_civ_selectorStrokeWidth, paramInt));
      setSelectorStrokeColor(paramAttributeSet.getColor(b.l.CircularImageView_civ_selectorStrokeColor, -16776961));
    }
    if (this.dxd)
    {
      this.shadowRadius = paramAttributeSet.getFloat(b.l.CircularImageView_civ_shadowRadius, 4.0F);
      this.dwq = paramAttributeSet.getFloat(b.l.CircularImageView_civ_shadowDx, 0.0F);
      this.dwr = paramAttributeSet.getFloat(b.l.CircularImageView_civ_shadowDy, 2.0F);
      this.shadowColor = paramAttributeSet.getColor(b.l.CircularImageView_civ_shadowColor, -16777216);
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
  
  private void hkl()
  {
    AppMethodBeat.i(97177);
    if (this.QUQ == null)
    {
      AppMethodBeat.o(97177);
      return;
    }
    Object localObject = this.QUQ;
    Shader.TileMode localTileMode = Shader.TileMode.CLAMP;
    this.QUP = new BitmapShader((Bitmap)localObject, localTileMode, localTileMode);
    if ((this.QUN != this.QUQ.getWidth()) || (this.QUN != this.QUQ.getHeight()))
    {
      localObject = new Matrix();
      float f = this.QUN / this.QUQ.getWidth();
      ((Matrix)localObject).setScale(f, f);
      this.QUP.setLocalMatrix((Matrix)localObject);
    }
    AppMethodBeat.o(97177);
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
    if (this.QUQ == null)
    {
      AppMethodBeat.o(97169);
      return;
    }
    if ((this.QUQ.getHeight() == 0) || (this.QUQ.getWidth() == 0))
    {
      AppMethodBeat.o(97169);
      return;
    }
    int k = this.QUN;
    int i;
    if (getWidth() < getHeight())
    {
      i = getWidth();
      this.QUN = i;
      if (k != this.QUN) {
        hkl();
      }
      this.paint.setShader(this.QUP);
      i = this.QUN / 2;
      if ((!this.QUM) || (!this.isSelected)) {
        break label224;
      }
      j = this.QUO;
      i = (this.QUN - j * 2) / 2;
      this.paint.setColorFilter(this.QUT);
      paramCanvas.drawCircle(i + j, i + j, (this.QUN - j * 2) / 2 + j - 4.0F, this.QUS);
    }
    for (;;)
    {
      paramCanvas.drawCircle(i + j, i + j, (this.QUN - j * 2) / 2, this.paint);
      AppMethodBeat.o(97169);
      return;
      i = getHeight();
      break;
      label224:
      if (this.QUL)
      {
        j = this.borderWidth;
        i = (this.QUN - j * 2) / 2;
        this.paint.setColorFilter(null);
        paramCanvas.drawArc(new RectF(j / 2 + 0, j / 2 + 0, this.QUN - j / 2, this.QUN - j / 2), 360.0F, 360.0F, false, this.QUR);
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
      paramInt1 = this.QUN;
      break;
      label70:
      if (i != -2147483648) {
        paramInt2 = this.QUN;
      }
    }
  }
  
  public void setBorderColor(int paramInt)
  {
    AppMethodBeat.i(97164);
    if (this.QUR != null) {
      this.QUR.setColor(paramInt);
    }
    invalidate();
    AppMethodBeat.o(97164);
  }
  
  public void setBorderWidth(int paramInt)
  {
    AppMethodBeat.i(97163);
    this.borderWidth = paramInt;
    if (this.QUR != null) {
      this.QUR.setStrokeWidth(paramInt);
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
    this.QUQ = paramBitmap;
    if (this.QUN > 0) {
      hkl();
    }
    AppMethodBeat.o(97174);
  }
  
  public void setImageDrawable(Drawable paramDrawable)
  {
    AppMethodBeat.i(97173);
    super.setImageDrawable(paramDrawable);
    this.QUQ = drawableToBitmap(getDrawable());
    if (this.QUN > 0) {
      hkl();
    }
    AppMethodBeat.o(97173);
  }
  
  public void setImageResource(int paramInt)
  {
    AppMethodBeat.i(97172);
    super.setImageResource(paramInt);
    this.QUQ = drawableToBitmap(getDrawable());
    if (this.QUN > 0) {
      hkl();
    }
    AppMethodBeat.o(97172);
  }
  
  public void setImageURI(Uri paramUri)
  {
    AppMethodBeat.i(97171);
    super.setImageURI(paramUri);
    this.QUQ = drawableToBitmap(getDrawable());
    if (this.QUN > 0) {
      hkl();
    }
    AppMethodBeat.o(97171);
  }
  
  public void setSelectorColor(int paramInt)
  {
    AppMethodBeat.i(97165);
    this.QUT = new PorterDuffColorFilter(paramInt, PorterDuff.Mode.SRC_ATOP);
    invalidate();
    AppMethodBeat.o(97165);
  }
  
  public void setSelectorStrokeColor(int paramInt)
  {
    AppMethodBeat.i(97167);
    if (this.QUS != null) {
      this.QUS.setColor(paramInt);
    }
    invalidate();
    AppMethodBeat.o(97167);
  }
  
  public void setSelectorStrokeWidth(int paramInt)
  {
    AppMethodBeat.i(97166);
    this.QUO = paramInt;
    requestLayout();
    invalidate();
    AppMethodBeat.o(97166);
  }
  
  public void setShadowEnabled(boolean paramBoolean)
  {
    AppMethodBeat.i(97168);
    this.dxd = paramBoolean;
    if (this.dxd) {}
    for (float f = this.shadowRadius;; f = 0.0F)
    {
      this.QUR.setShadowLayer(f, this.dwq, this.dwr, this.shadowColor);
      this.QUS.setShadowLayer(f, this.dwq, this.dwr, this.shadowColor);
      AppMethodBeat.o(97168);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.widget.CircularImageView
 * JD-Core Version:    0.7.0.1
 */