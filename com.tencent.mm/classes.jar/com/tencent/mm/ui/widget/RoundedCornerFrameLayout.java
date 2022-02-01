package com.tencent.mm.ui.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Path.Direction;
import android.graphics.Path.FillType;
import android.graphics.PorterDuff.Mode;
import android.graphics.PorterDuffXfermode;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.widget.FrameLayout;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ae.a.a;

public class RoundedCornerFrameLayout
  extends FrameLayout
{
  private a LpI;
  private Bitmap LpJ;
  private Paint paint;
  
  public RoundedCornerFrameLayout(Context paramContext)
  {
    super(paramContext);
    AppMethodBeat.i(143450);
    c(paramContext, null, 0);
    AppMethodBeat.o(143450);
  }
  
  public RoundedCornerFrameLayout(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(143451);
    c(paramContext, paramAttributeSet, 0);
    AppMethodBeat.o(143451);
  }
  
  public RoundedCornerFrameLayout(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(143452);
    c(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.o(143452);
  }
  
  private void c(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    AppMethodBeat.i(143453);
    float f = paramContext.obtainStyledAttributes(paramAttributeSet, a.a.RoundedCornerFrameLayout, paramInt, 0).getDimension(0, 0.0F);
    this.LpI = new a(f, f, f, f);
    this.paint = new Paint(1);
    this.paint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.DST_IN));
    setWillNotDraw(false);
    AppMethodBeat.o(143453);
  }
  
  public void draw(Canvas paramCanvas)
  {
    AppMethodBeat.i(143457);
    if ((paramCanvas.getWidth() <= 0) || (paramCanvas.getHeight() <= 0))
    {
      AppMethodBeat.o(143457);
      return;
    }
    int i = paramCanvas.saveLayer(new RectF(0.0F, 0.0F, paramCanvas.getWidth(), paramCanvas.getHeight()), null, 31);
    super.draw(paramCanvas);
    if ((this.LpI.LpK > 0.0F) || (this.LpI.LpL > 0.0F) || (this.LpI.LpM > 0.0F) || (this.LpI.LpN > 0.0F))
    {
      if (this.LpJ == null)
      {
        int j = paramCanvas.getWidth();
        int k = paramCanvas.getHeight();
        Bitmap localBitmap = Bitmap.createBitmap(j, k, Bitmap.Config.ALPHA_8);
        Canvas localCanvas = new Canvas(localBitmap);
        Path localPath = new Path();
        RectF localRectF = new RectF(0.0F, 0.0F, j, k);
        float f1 = this.LpI.LpK;
        float f2 = this.LpI.LpK;
        float f3 = this.LpI.LpL;
        float f4 = this.LpI.LpL;
        float f5 = this.LpI.LpN;
        float f6 = this.LpI.LpN;
        float f7 = this.LpI.LpM;
        float f8 = this.LpI.LpM;
        Path.Direction localDirection = Path.Direction.CCW;
        localPath.addRoundRect(localRectF, new float[] { f1, f2, f3, f4, f5, f6, f7, f8 }, localDirection);
        localPath.setFillType(Path.FillType.WINDING);
        localCanvas.drawPath(localPath, new Paint(1));
        this.LpJ = localBitmap;
      }
      paramCanvas.drawBitmap(this.LpJ, 0.0F, 0.0F, this.paint);
    }
    paramCanvas.restoreToCount(i);
    AppMethodBeat.o(143457);
  }
  
  protected void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    AppMethodBeat.i(143456);
    super.onLayout(paramBoolean, paramInt1, paramInt2, paramInt3, paramInt4);
    this.LpJ = null;
    AppMethodBeat.o(143456);
  }
  
  public final void p(float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4)
  {
    AppMethodBeat.i(143455);
    this.LpI.LpK = paramFloat1;
    this.LpI.LpL = paramFloat2;
    this.LpI.LpM = paramFloat3;
    this.LpI.LpN = paramFloat4;
    if (this.LpJ != null)
    {
      this.LpJ = null;
      postInvalidate();
    }
    AppMethodBeat.o(143455);
  }
  
  public void setRadius(float paramFloat)
  {
    AppMethodBeat.i(143454);
    p(paramFloat, paramFloat, paramFloat, paramFloat);
    AppMethodBeat.o(143454);
  }
  
  final class a
  {
    float LpK;
    float LpL;
    float LpM;
    float LpN;
    
    a(float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4)
    {
      this.LpK = paramFloat1;
      this.LpL = paramFloat2;
      this.LpM = paramFloat3;
      this.LpN = paramFloat4;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.ui.widget.RoundedCornerFrameLayout
 * JD-Core Version:    0.7.0.1
 */