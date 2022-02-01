package com.tencent.mm.ui.widget;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.graphics.Path;
import android.graphics.Path.Direction;
import android.graphics.Path.FillType;
import android.graphics.PorterDuff.Mode;
import android.graphics.PorterDuffXfermode;
import android.graphics.RectF;
import android.support.v7.widget.AppCompatImageView;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ae.a.a;

public class RoundCornerImageView
  extends AppCompatImageView
{
  private int JbY;
  private int JbZ;
  private Path Jca;
  private RectF Jcb;
  private Paint borderPaint;
  private Paint paint;
  public int shadowColor;
  public int shadowDx;
  public int shadowDy;
  public int shadowRadius;
  
  public RoundCornerImageView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(143446);
    this.JbY = 8;
    this.JbZ = 8;
    this.paint = new Paint();
    this.Jca = new Path();
    this.Jcb = new RectF();
    this.shadowRadius = 0;
    init(paramContext, paramAttributeSet);
    AppMethodBeat.o(143446);
  }
  
  public RoundCornerImageView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(143445);
    this.JbY = 8;
    this.JbZ = 8;
    this.paint = new Paint();
    this.Jca = new Path();
    this.Jcb = new RectF();
    this.shadowRadius = 0;
    init(paramContext, paramAttributeSet);
    AppMethodBeat.o(143445);
  }
  
  private void init(Context paramContext, AttributeSet paramAttributeSet)
  {
    AppMethodBeat.i(143447);
    if (paramAttributeSet != null)
    {
      paramContext = paramContext.obtainStyledAttributes(paramAttributeSet, a.a.RoundCornerImageView);
      this.JbY = paramContext.getDimensionPixelSize(1, this.JbY);
      this.JbZ = paramContext.getDimensionPixelSize(0, this.JbZ);
      paramContext.recycle();
      AppMethodBeat.o(143447);
      return;
    }
    float f = paramContext.getResources().getDisplayMetrics().density;
    this.JbY = ((int)(this.JbY * f));
    this.JbZ = ((int)(f * this.JbZ));
    AppMethodBeat.o(143447);
  }
  
  public void draw(Canvas paramCanvas)
  {
    AppMethodBeat.i(143448);
    Bitmap localBitmap2 = Bitmap.createBitmap(getWidth(), getHeight(), Bitmap.Config.ARGB_8888);
    Canvas localCanvas = new Canvas(localBitmap2);
    Bitmap localBitmap1 = localBitmap2;
    if (localBitmap2.isRecycled())
    {
      localBitmap1 = Bitmap.createBitmap(getWidth(), getHeight(), Bitmap.Config.ARGB_8888);
      localCanvas = new Canvas(localBitmap1);
    }
    super.draw(localCanvas);
    this.paint.setAntiAlias(true);
    this.paint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.CLEAR));
    this.Jcb.set(0.0F, 0.0F, getWidth(), getHeight());
    this.Jca.addRoundRect(this.Jcb, this.JbY, this.JbZ, Path.Direction.CW);
    this.Jca.setFillType(Path.FillType.INVERSE_WINDING);
    localCanvas.drawPath(this.Jca, this.paint);
    if (this.borderPaint != null)
    {
      float f = this.borderPaint.getStrokeWidth() / 2.0F;
      localCanvas.drawRoundRect(new RectF(f, f, getWidth() - f, getHeight() - f), this.JbY, this.JbZ, this.borderPaint);
    }
    this.paint.reset();
    this.paint.setXfermode(null);
    if (this.shadowRadius > 0) {
      this.paint.setShadowLayer(this.shadowRadius, this.shadowDx, this.shadowDy, this.shadowColor);
    }
    paramCanvas.drawBitmap(localBitmap1, 0.0F, 0.0F, this.paint);
    localBitmap1.recycle();
    AppMethodBeat.o(143448);
  }
  
  public final void jS(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(197234);
    this.borderPaint = new Paint();
    this.borderPaint.setStyle(Paint.Style.STROKE);
    this.borderPaint.setStrokeWidth(paramInt1);
    this.borderPaint.setAntiAlias(true);
    this.borderPaint.setColor(paramInt2);
    AppMethodBeat.o(197234);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.ui.widget.RoundCornerImageView
 * JD-Core Version:    0.7.0.1
 */