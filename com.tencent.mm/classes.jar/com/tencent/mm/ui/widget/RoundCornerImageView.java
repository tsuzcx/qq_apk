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
  private Path afVi;
  private RectF afVj;
  public int afVk;
  public int afVl;
  private Paint paint;
  private int roundHeight;
  private int roundWidth;
  public int shadowColor;
  public int shadowRadius;
  private Paint uMn;
  
  public RoundCornerImageView(Context paramContext)
  {
    super(paramContext);
    AppMethodBeat.i(251640);
    this.roundWidth = 8;
    this.roundHeight = 8;
    this.paint = new Paint();
    this.afVi = new Path();
    this.afVj = new RectF();
    this.shadowRadius = 0;
    init(paramContext, null);
    AppMethodBeat.o(251640);
  }
  
  public RoundCornerImageView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(143446);
    this.roundWidth = 8;
    this.roundHeight = 8;
    this.paint = new Paint();
    this.afVi = new Path();
    this.afVj = new RectF();
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
    this.afVi = new Path();
    this.afVj = new RectF();
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
    this.afVj.set(0.0F, 0.0F, getWidth(), getHeight());
    this.afVi.addRoundRect(this.afVj, this.roundWidth, this.roundHeight, Path.Direction.CW);
    this.afVi.setFillType(Path.FillType.INVERSE_WINDING);
    localCanvas.drawPath(this.afVi, this.paint);
    if (this.uMn != null)
    {
      float f = this.uMn.getStrokeWidth() / 2.0F;
      localCanvas.drawRoundRect(new RectF(f, f, getWidth() - f, getHeight() - f), this.roundWidth, this.roundHeight, this.uMn);
    }
    this.paint.reset();
    this.paint.setXfermode(null);
    if (this.shadowRadius > 0) {
      this.paint.setShadowLayer(this.shadowRadius, this.afVk, this.afVl, this.shadowColor);
    }
    paramCanvas.drawBitmap(localBitmap1, 0.0F, 0.0F, this.paint);
    localBitmap1.recycle();
    AppMethodBeat.o(143448);
  }
  
  public final void oI(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(251658);
    this.uMn = new Paint();
    this.uMn.setStyle(Paint.Style.STROKE);
    this.uMn.setStrokeWidth(paramInt1);
    this.uMn.setAntiAlias(true);
    this.uMn.setColor(paramInt2);
    AppMethodBeat.o(251658);
  }
  
  public final void oJ(int paramInt1, int paramInt2)
  {
    this.roundWidth = paramInt1;
    this.roundHeight = paramInt2;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.ui.widget.RoundCornerImageView
 * JD-Core Version:    0.7.0.1
 */