package com.tencent.mm.plugin.sns.ui.widget;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PorterDuff.Mode;
import android.graphics.PorterDuffXfermode;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.widget.RelativeLayout;
import com.tencent.mm.cb.a;

public class RoundedCornerRelativeLayout
  extends RelativeLayout
{
  private Paint gaZ;
  private Bitmap maskBitmap;
  private RoundedCornerRelativeLayout.a prb;
  
  public RoundedCornerRelativeLayout(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    eg(paramContext);
  }
  
  public RoundedCornerRelativeLayout(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    eg(paramContext);
  }
  
  private void eg(Context paramContext)
  {
    int i = a.fromDPToPix(paramContext, 8);
    this.prb = new RoundedCornerRelativeLayout.a(this, i, i, i, i);
    this.gaZ = new Paint(1);
    this.gaZ.setColor(-1);
    setWillNotDraw(false);
  }
  
  public void draw(Canvas paramCanvas)
  {
    super.draw(paramCanvas);
    if ((paramCanvas.getWidth() <= 0) || (paramCanvas.getHeight() <= 0)) {
      return;
    }
    if (this.maskBitmap == null)
    {
      int i = paramCanvas.getWidth();
      int j = paramCanvas.getHeight();
      Bitmap localBitmap = Bitmap.createBitmap(i, j, Bitmap.Config.ALPHA_8);
      Canvas localCanvas = new Canvas(localBitmap);
      Paint localPaint = new Paint(1);
      localPaint.setColor(-1);
      localCanvas.drawRect(0.0F, 0.0F, i, j, localPaint);
      localPaint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.CLEAR));
      RectF localRectF1 = new RectF(0.0F, 0.0F, this.prb.prc, this.prb.prc);
      RectF localRectF2 = new RectF(i - this.prb.prd, 0.0F, i, this.prb.prd);
      RectF localRectF3 = new RectF(0.0F, j - this.prb.pre, this.prb.pre, j);
      RectF localRectF4 = new RectF(i - this.prb.prf, j - this.prb.prf, i, j);
      Path localPath = new Path();
      localPath.moveTo(localRectF1.left, localRectF1.bottom);
      localPath.arcTo(localRectF1, 180.0F, 90.0F);
      localPath.lineTo(localRectF2.left, localRectF2.top);
      localPath.arcTo(localRectF2, 270.0F, 90.0F);
      localPath.lineTo(localRectF4.right, localRectF4.top);
      localPath.arcTo(localRectF4, 0.0F, 90.0F);
      localPath.lineTo(localRectF3.right, localRectF3.bottom);
      localPath.arcTo(localRectF3, 90.0F, 90.0F);
      localPath.lineTo(localRectF1.left, localRectF1.bottom);
      localCanvas.drawPath(localPath, localPaint);
      this.maskBitmap = localBitmap;
    }
    paramCanvas.drawBitmap(this.maskBitmap, 0.0F, 0.0F, this.gaZ);
  }
  
  public void setRadius(int paramInt)
  {
    this.prb.prc = a.fromDPToPix(getContext(), paramInt);
    this.prb.prd = a.fromDPToPix(getContext(), paramInt);
    this.prb.pre = a.fromDPToPix(getContext(), paramInt);
    this.prb.prf = a.fromDPToPix(getContext(), paramInt);
    if (this.maskBitmap != null)
    {
      this.maskBitmap = null;
      postInvalidate();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.widget.RoundedCornerRelativeLayout
 * JD-Core Version:    0.7.0.1
 */