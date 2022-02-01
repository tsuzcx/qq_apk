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
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import androidx.appcompat.widget.AppCompatImageView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ah.a.m;

public class RoundCornerImageView
  extends AppCompatImageView
{
  private Path Ydr;
  private RectF Yds;
  public int Ydt;
  public int Ydu;
  private Paint borderPaint;
  private Paint paint;
  private int roundHeight;
  private int roundWidth;
  public int shadowColor;
  public int shadowRadius;
  
  public RoundCornerImageView(Context paramContext)
  {
    super(paramContext);
    AppMethodBeat.i(221873);
    this.roundWidth = 8;
    this.roundHeight = 8;
    this.paint = new Paint();
    this.Ydr = new Path();
    this.Yds = new RectF();
    this.shadowRadius = 0;
    init(paramContext, null);
    AppMethodBeat.o(221873);
  }
  
  public RoundCornerImageView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(143446);
    this.roundWidth = 8;
    this.roundHeight = 8;
    this.paint = new Paint();
    this.Ydr = new Path();
    this.Yds = new RectF();
    this.shadowRadius = 0;
    init(paramContext, paramAttributeSet);
    AppMethodBeat.o(143446);
  }
  
  public RoundCornerImageView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(143445);
    this.roundWidth = 8;
    this.roundHeight = 8;
    this.paint = new Paint();
    this.Ydr = new Path();
    this.Yds = new RectF();
    this.shadowRadius = 0;
    init(paramContext, paramAttributeSet);
    AppMethodBeat.o(143445);
  }
  
  private void init(Context paramContext, AttributeSet paramAttributeSet)
  {
    AppMethodBeat.i(143447);
    if (paramAttributeSet != null)
    {
      paramContext = paramContext.obtainStyledAttributes(paramAttributeSet, a.m.RoundCornerImageView);
      this.roundWidth = paramContext.getDimensionPixelSize(a.m.RoundCornerImageView_roundWidth, this.roundWidth);
      this.roundHeight = paramContext.getDimensionPixelSize(a.m.RoundCornerImageView_roundHeight, this.roundHeight);
      paramContext.recycle();
      AppMethodBeat.o(143447);
      return;
    }
    float f = paramContext.getResources().getDisplayMetrics().density;
    this.roundWidth = ((int)(this.roundWidth * f));
    this.roundHeight = ((int)(f * this.roundHeight));
    AppMethodBeat.o(143447);
  }
  
  public void draw(Canvas paramCanvas)
  {
    AppMethodBeat.i(143448);
    if ((getWidth() <= 0) || (getHeight() <= 0))
    {
      super.draw(paramCanvas);
      AppMethodBeat.o(143448);
      return;
    }
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
    this.Yds.set(0.0F, 0.0F, getWidth(), getHeight());
    this.Ydr.addRoundRect(this.Yds, this.roundWidth, this.roundHeight, Path.Direction.CW);
    this.Ydr.setFillType(Path.FillType.INVERSE_WINDING);
    localCanvas.drawPath(this.Ydr, this.paint);
    if (this.borderPaint != null)
    {
      float f = this.borderPaint.getStrokeWidth() / 2.0F;
      localCanvas.drawRoundRect(new RectF(f, f, getWidth() - f, getHeight() - f), this.roundWidth, this.roundHeight, this.borderPaint);
    }
    this.paint.reset();
    this.paint.setXfermode(null);
    if (this.shadowRadius > 0) {
      this.paint.setShadowLayer(this.shadowRadius, this.Ydt, this.Ydu, this.shadowColor);
    }
    paramCanvas.drawBitmap(localBitmap1, 0.0F, 0.0F, this.paint);
    localBitmap1.recycle();
    AppMethodBeat.o(143448);
  }
  
  public final void mP(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(221882);
    this.borderPaint = new Paint();
    this.borderPaint.setStyle(Paint.Style.STROKE);
    this.borderPaint.setStrokeWidth(paramInt1);
    this.borderPaint.setAntiAlias(true);
    this.borderPaint.setColor(paramInt2);
    AppMethodBeat.o(221882);
  }
  
  public final void mQ(int paramInt1, int paramInt2)
  {
    this.roundWidth = paramInt1;
    this.roundHeight = paramInt2;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.ui.widget.RoundCornerImageView
 * JD-Core Version:    0.7.0.1
 */