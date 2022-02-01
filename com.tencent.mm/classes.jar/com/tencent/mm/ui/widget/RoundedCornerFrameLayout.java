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
import com.tencent.mm.ah.a.m;

public class RoundedCornerFrameLayout
  extends FrameLayout
{
  private Bitmap LGM;
  private a afVn;
  private Paint paint;
  
  public RoundedCornerFrameLayout(Context paramContext)
  {
    super(paramContext);
    AppMethodBeat.i(143450);
    b(paramContext, null, 0);
    AppMethodBeat.o(143450);
  }
  
  public RoundedCornerFrameLayout(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(143451);
    b(paramContext, paramAttributeSet, 0);
    AppMethodBeat.o(143451);
  }
  
  public RoundedCornerFrameLayout(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(143452);
    b(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.o(143452);
  }
  
  private void b(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    AppMethodBeat.i(143453);
    float f = paramContext.obtainStyledAttributes(paramAttributeSet, a.m.RoundedCornerFrameLayout, paramInt, 0).getDimension(a.m.RoundedCornerFrameLayout_cornerRadius, 0.0F);
    this.afVn = new a(f, f, f, f);
    this.paint = new Paint(1);
    this.paint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.DST_IN));
    setWillNotDraw(false);
    AppMethodBeat.o(143453);
  }
  
  public final void A(float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4)
  {
    AppMethodBeat.i(143455);
    this.afVn.BbO = paramFloat1;
    this.afVn.BbP = paramFloat2;
    this.afVn.BbQ = paramFloat3;
    this.afVn.BbR = paramFloat4;
    if (this.LGM != null)
    {
      this.LGM = null;
      postInvalidate();
    }
    AppMethodBeat.o(143455);
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
    if ((this.afVn.BbO > 0.0F) || (this.afVn.BbP > 0.0F) || (this.afVn.BbQ > 0.0F) || (this.afVn.BbR > 0.0F))
    {
      if (this.LGM == null)
      {
        int j = paramCanvas.getWidth();
        int k = paramCanvas.getHeight();
        Bitmap localBitmap = Bitmap.createBitmap(j, k, Bitmap.Config.ALPHA_8);
        Canvas localCanvas = new Canvas(localBitmap);
        Path localPath = new Path();
        RectF localRectF = new RectF(0.0F, 0.0F, j, k);
        float f1 = this.afVn.BbO;
        float f2 = this.afVn.BbO;
        float f3 = this.afVn.BbP;
        float f4 = this.afVn.BbP;
        float f5 = this.afVn.BbR;
        float f6 = this.afVn.BbR;
        float f7 = this.afVn.BbQ;
        float f8 = this.afVn.BbQ;
        Path.Direction localDirection = Path.Direction.CCW;
        localPath.addRoundRect(localRectF, new float[] { f1, f2, f3, f4, f5, f6, f7, f8 }, localDirection);
        localPath.setFillType(Path.FillType.WINDING);
        localCanvas.drawPath(localPath, new Paint(1));
        this.LGM = localBitmap;
      }
      paramCanvas.drawBitmap(this.LGM, 0.0F, 0.0F, this.paint);
    }
    paramCanvas.restoreToCount(i);
    AppMethodBeat.o(143457);
  }
  
  protected void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    AppMethodBeat.i(143456);
    super.onLayout(paramBoolean, paramInt1, paramInt2, paramInt3, paramInt4);
    this.LGM = null;
    AppMethodBeat.o(143456);
  }
  
  public void setRadius(float paramFloat)
  {
    AppMethodBeat.i(143454);
    A(paramFloat, paramFloat, paramFloat, paramFloat);
    AppMethodBeat.o(143454);
  }
  
  final class a
  {
    float BbO;
    float BbP;
    float BbQ;
    float BbR;
    
    a(float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4)
    {
      this.BbO = paramFloat1;
      this.BbP = paramFloat2;
      this.BbQ = paramFloat3;
      this.BbR = paramFloat4;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.ui.widget.RoundedCornerFrameLayout
 * JD-Core Version:    0.7.0.1
 */