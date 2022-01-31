package com.tencent.mm.ui.widget;

import android.content.Context;
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
import android.widget.RelativeLayout;
import com.tencent.matrix.trace.core.AppMethodBeat;

public class RoundedCornerRelativeLayout
  extends RelativeLayout
{
  private RoundedCornerRelativeLayout.a AEH;
  private Bitmap AEI;
  private Paint paint;
  
  public RoundedCornerRelativeLayout(Context paramContext)
  {
    super(paramContext);
    AppMethodBeat.i(107959);
    dOT();
    AppMethodBeat.o(107959);
  }
  
  public RoundedCornerRelativeLayout(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(107960);
    dOT();
    AppMethodBeat.o(107960);
  }
  
  public RoundedCornerRelativeLayout(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(107961);
    dOT();
    AppMethodBeat.o(107961);
  }
  
  private void dOT()
  {
    AppMethodBeat.i(107962);
    this.AEH = new RoundedCornerRelativeLayout.a(this);
    this.paint = new Paint(1);
    this.paint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.DST_IN));
    setWillNotDraw(false);
    AppMethodBeat.o(107962);
  }
  
  public void draw(Canvas paramCanvas)
  {
    AppMethodBeat.i(107964);
    if ((paramCanvas.getWidth() <= 0) || (paramCanvas.getHeight() <= 0))
    {
      AppMethodBeat.o(107964);
      return;
    }
    int i = paramCanvas.saveLayer(new RectF(0.0F, 0.0F, paramCanvas.getWidth(), paramCanvas.getHeight()), null, 31);
    super.draw(paramCanvas);
    if ((this.AEH.AEJ > 0.0F) || (this.AEH.AEK > 0.0F) || (this.AEH.AEL > 0.0F) || (this.AEH.AEM > 0.0F))
    {
      if (this.AEI == null)
      {
        int j = paramCanvas.getWidth();
        int k = paramCanvas.getHeight();
        Bitmap localBitmap = Bitmap.createBitmap(j, k, Bitmap.Config.ALPHA_8);
        Canvas localCanvas = new Canvas(localBitmap);
        Path localPath = new Path();
        RectF localRectF = new RectF(0.0F, 0.0F, j, k);
        float f1 = this.AEH.AEJ;
        float f2 = this.AEH.AEJ;
        float f3 = this.AEH.AEK;
        float f4 = this.AEH.AEK;
        float f5 = this.AEH.AEM;
        float f6 = this.AEH.AEM;
        float f7 = this.AEH.AEL;
        float f8 = this.AEH.AEL;
        Path.Direction localDirection = Path.Direction.CCW;
        localPath.addRoundRect(localRectF, new float[] { f1, f2, f3, f4, f5, f6, f7, f8 }, localDirection);
        localPath.setFillType(Path.FillType.WINDING);
        localCanvas.drawPath(localPath, new Paint(1));
        this.AEI = localBitmap;
      }
      paramCanvas.drawBitmap(this.AEI, 0.0F, 0.0F, this.paint);
    }
    paramCanvas.restoreToCount(i);
    AppMethodBeat.o(107964);
  }
  
  public void setRadius(float paramFloat)
  {
    AppMethodBeat.i(107963);
    this.AEH.AEJ = paramFloat;
    this.AEH.AEK = paramFloat;
    this.AEH.AEL = paramFloat;
    this.AEH.AEM = paramFloat;
    if (this.AEI != null)
    {
      this.AEI = null;
      postInvalidate();
    }
    AppMethodBeat.o(107963);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.ui.widget.RoundedCornerRelativeLayout
 * JD-Core Version:    0.7.0.1
 */