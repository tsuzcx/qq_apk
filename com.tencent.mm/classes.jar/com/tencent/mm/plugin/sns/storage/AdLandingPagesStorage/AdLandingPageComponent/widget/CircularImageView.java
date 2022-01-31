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
  private boolean gDG;
  private Paint paint;
  private boolean rzM;
  private boolean rzN;
  private int rzO;
  private int rzP;
  private boolean rzQ;
  private BitmapShader rzR;
  private Bitmap rzS;
  private Paint rzT;
  private Paint rzU;
  private ColorFilter rzV;
  private int shadowColor;
  private float shadowDx;
  private float shadowDy;
  private float shadowRadius;
  
  static
  {
    AppMethodBeat.i(37681);
    TAG = CircularImageView.class.getSimpleName();
    AppMethodBeat.o(37681);
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
    AppMethodBeat.i(37665);
    this.paint = new Paint();
    this.paint.setAntiAlias(true);
    this.rzT = new Paint();
    this.rzT.setAntiAlias(true);
    this.rzT.setStyle(Paint.Style.STROKE);
    this.rzU = new Paint();
    this.rzU.setAntiAlias(true);
    if (Build.VERSION.SDK_INT >= 11) {
      setLayerType(1, null);
    }
    paramAttributeSet = paramContext.obtainStyledAttributes(paramAttributeSet, i.a.CircularImageView, paramInt, 0);
    this.rzM = paramAttributeSet.getBoolean(0, false);
    this.rzN = paramAttributeSet.getBoolean(3, false);
    this.rzQ = paramAttributeSet.getBoolean(7, false);
    if (this.rzM)
    {
      setBorderWidth(paramAttributeSet.getDimensionPixelOffset(2, (int)(paramContext.getResources().getDisplayMetrics().density * 2.0F + 0.5F)));
      setBorderColor(paramAttributeSet.getColor(1, -1));
    }
    if (this.rzN)
    {
      paramInt = (int)(paramContext.getResources().getDisplayMetrics().density * 2.0F + 0.5F);
      setSelectorColor(paramAttributeSet.getColor(4, 0));
      setSelectorStrokeWidth(paramAttributeSet.getDimensionPixelOffset(6, paramInt));
      setSelectorStrokeColor(paramAttributeSet.getColor(5, -16776961));
    }
    if (this.rzQ)
    {
      this.shadowRadius = paramAttributeSet.getFloat(8, 4.0F);
      this.shadowDx = paramAttributeSet.getFloat(9, 0.0F);
      this.shadowDy = paramAttributeSet.getFloat(10, 2.0F);
      this.shadowColor = paramAttributeSet.getColor(11, -16777216);
      setShadowEnabled(true);
    }
    paramAttributeSet.recycle();
    AppMethodBeat.o(37665);
  }
  
  private void crM()
  {
    AppMethodBeat.i(37680);
    if (this.rzS == null)
    {
      AppMethodBeat.o(37680);
      return;
    }
    Object localObject = this.rzS;
    Shader.TileMode localTileMode = Shader.TileMode.CLAMP;
    this.rzR = new BitmapShader((Bitmap)localObject, localTileMode, localTileMode);
    if ((this.rzO != this.rzS.getWidth()) || (this.rzO != this.rzS.getHeight()))
    {
      localObject = new Matrix();
      float f = this.rzO / this.rzS.getWidth();
      ((Matrix)localObject).setScale(f, f);
      this.rzR.setLocalMatrix((Matrix)localObject);
    }
    AppMethodBeat.o(37680);
  }
  
  private static Bitmap drawableToBitmap(Drawable paramDrawable)
  {
    AppMethodBeat.i(37679);
    if (paramDrawable == null)
    {
      AppMethodBeat.o(37679);
      return null;
    }
    if ((paramDrawable instanceof BitmapDrawable))
    {
      paramDrawable = ((BitmapDrawable)paramDrawable).getBitmap();
      AppMethodBeat.o(37679);
      return paramDrawable;
    }
    int i = paramDrawable.getIntrinsicWidth();
    int j = paramDrawable.getIntrinsicHeight();
    if ((i <= 0) || (j <= 0))
    {
      AppMethodBeat.o(37679);
      return null;
    }
    try
    {
      Bitmap localBitmap = Bitmap.createBitmap(i, j, Bitmap.Config.ARGB_8888);
      Canvas localCanvas = new Canvas(localBitmap);
      paramDrawable.setBounds(0, 0, localCanvas.getWidth(), localCanvas.getHeight());
      paramDrawable.draw(localCanvas);
      AppMethodBeat.o(37679);
      return localBitmap;
    }
    catch (OutOfMemoryError paramDrawable)
    {
      AppMethodBeat.o(37679);
    }
    return null;
  }
  
  public boolean dispatchTouchEvent(MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(37673);
    boolean bool;
    if (!isClickable())
    {
      this.gDG = false;
      bool = super.onTouchEvent(paramMotionEvent);
      AppMethodBeat.o(37673);
      return bool;
    }
    switch (paramMotionEvent.getAction())
    {
    }
    for (;;)
    {
      invalidate();
      bool = super.dispatchTouchEvent(paramMotionEvent);
      AppMethodBeat.o(37673);
      return bool;
      this.gDG = true;
      continue;
      this.gDG = false;
    }
  }
  
  public boolean isSelected()
  {
    return this.gDG;
  }
  
  public void onDraw(Canvas paramCanvas)
  {
    int j = 0;
    AppMethodBeat.i(37672);
    if (this.rzS == null)
    {
      AppMethodBeat.o(37672);
      return;
    }
    if ((this.rzS.getHeight() == 0) || (this.rzS.getWidth() == 0))
    {
      AppMethodBeat.o(37672);
      return;
    }
    int k = this.rzO;
    int i;
    if (getWidth() < getHeight())
    {
      i = getWidth();
      this.rzO = i;
      if (k != this.rzO) {
        crM();
      }
      this.paint.setShader(this.rzR);
      i = this.rzO / 2;
      if ((!this.rzN) || (!this.gDG)) {
        break label224;
      }
      j = this.rzP;
      i = (this.rzO - j * 2) / 2;
      this.paint.setColorFilter(this.rzV);
      paramCanvas.drawCircle(i + j, i + j, (this.rzO - j * 2) / 2 + j - 4.0F, this.rzU);
    }
    for (;;)
    {
      paramCanvas.drawCircle(i + j, i + j, (this.rzO - j * 2) / 2, this.paint);
      AppMethodBeat.o(37672);
      return;
      i = getHeight();
      break;
      label224:
      if (this.rzM)
      {
        j = this.borderWidth;
        i = (this.rzO - j * 2) / 2;
        this.paint.setColorFilter(null);
        paramCanvas.drawArc(new RectF(j / 2 + 0, j / 2 + 0, this.rzO - j / 2, this.rzO - j / 2), 360.0F, 360.0F, false, this.rzT);
      }
      else
      {
        this.paint.setColorFilter(null);
      }
    }
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(37678);
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
      AppMethodBeat.o(37678);
      return;
      if (i == -2147483648) {
        break;
      }
      paramInt1 = this.rzO;
      break;
      label70:
      if (i != -2147483648) {
        paramInt2 = this.rzO;
      }
    }
  }
  
  public void setBorderColor(int paramInt)
  {
    AppMethodBeat.i(37667);
    if (this.rzT != null) {
      this.rzT.setColor(paramInt);
    }
    invalidate();
    AppMethodBeat.o(37667);
  }
  
  public void setBorderWidth(int paramInt)
  {
    AppMethodBeat.i(37666);
    this.borderWidth = paramInt;
    if (this.rzT != null) {
      this.rzT.setStrokeWidth(paramInt);
    }
    requestLayout();
    invalidate();
    AppMethodBeat.o(37666);
  }
  
  public void setIconModeEnabled(boolean paramBoolean) {}
  
  public void setImageBitmap(Bitmap paramBitmap)
  {
    AppMethodBeat.i(37677);
    super.setImageBitmap(paramBitmap);
    this.rzS = paramBitmap;
    if (this.rzO > 0) {
      crM();
    }
    AppMethodBeat.o(37677);
  }
  
  public void setImageDrawable(Drawable paramDrawable)
  {
    AppMethodBeat.i(37676);
    super.setImageDrawable(paramDrawable);
    this.rzS = drawableToBitmap(getDrawable());
    if (this.rzO > 0) {
      crM();
    }
    AppMethodBeat.o(37676);
  }
  
  public void setImageResource(int paramInt)
  {
    AppMethodBeat.i(37675);
    super.setImageResource(paramInt);
    this.rzS = drawableToBitmap(getDrawable());
    if (this.rzO > 0) {
      crM();
    }
    AppMethodBeat.o(37675);
  }
  
  public void setImageURI(Uri paramUri)
  {
    AppMethodBeat.i(37674);
    super.setImageURI(paramUri);
    this.rzS = drawableToBitmap(getDrawable());
    if (this.rzO > 0) {
      crM();
    }
    AppMethodBeat.o(37674);
  }
  
  public void setSelectorColor(int paramInt)
  {
    AppMethodBeat.i(37668);
    this.rzV = new PorterDuffColorFilter(paramInt, PorterDuff.Mode.SRC_ATOP);
    invalidate();
    AppMethodBeat.o(37668);
  }
  
  public void setSelectorStrokeColor(int paramInt)
  {
    AppMethodBeat.i(37670);
    if (this.rzU != null) {
      this.rzU.setColor(paramInt);
    }
    invalidate();
    AppMethodBeat.o(37670);
  }
  
  public void setSelectorStrokeWidth(int paramInt)
  {
    AppMethodBeat.i(37669);
    this.rzP = paramInt;
    requestLayout();
    invalidate();
    AppMethodBeat.o(37669);
  }
  
  public void setShadowEnabled(boolean paramBoolean)
  {
    AppMethodBeat.i(37671);
    this.rzQ = paramBoolean;
    if (this.rzQ) {}
    for (float f = this.shadowRadius;; f = 0.0F)
    {
      this.rzT.setShadowLayer(f, this.shadowDx, this.shadowDy, this.shadowColor);
      this.rzU.setShadowLayer(f, this.shadowDx, this.shadowDy, this.shadowColor);
      AppMethodBeat.o(37671);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.widget.CircularImageView
 * JD-Core Version:    0.7.0.1
 */