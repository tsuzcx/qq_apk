package com.tencent.mm.plugin.webview.ui.tools.bag;

import android.animation.AnimatorListenerAdapter;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PorterDuff.Mode;
import android.graphics.PorterDuffXfermode;
import android.graphics.Rect;
import android.graphics.RectF;
import android.view.View;
import android.view.View.MeasureSpec;
import com.tencent.mm.sdk.platformtools.y;

public final class j
  extends View
{
  int mHeight;
  private Bitmap mMaskBitmap;
  private Paint mPaint = new Paint();
  int mWidth;
  private Bitmap rrQ;
  private Canvas rrR;
  private Paint rrS = new Paint();
  private Rect rrT;
  private RectF rrU;
  private int rrV;
  int rrW;
  int rrX;
  int rrY;
  int rrZ = -1;
  boolean rsa;
  private AnimatorListenerAdapter rsb;
  
  public j(Context paramContext, Bitmap paramBitmap)
  {
    super(paramContext);
    paramContext = new PorterDuffXfermode(PorterDuff.Mode.DST_IN);
    this.rrS.setXfermode(paramContext);
    this.rrQ = paramBitmap;
    this.mWidth = paramBitmap.getWidth();
    this.mHeight = paramBitmap.getHeight();
    this.rrT = new Rect(0, 0, this.mWidth, this.mHeight);
    this.mMaskBitmap = Bitmap.createBitmap(this.mWidth, this.mHeight, Bitmap.Config.ARGB_8888);
    this.rrR = new Canvas(this.mMaskBitmap);
    this.rrU = new RectF();
    this.rrU.left = 0.0F;
    this.rrU.top = 0.0F;
    this.rrU.right = this.mWidth;
    this.rrU.bottom = this.mHeight;
    y.i("MicroMsg.TransformToBagAniMask", String.format("init: mWidth:%d mHeight:%d", new Object[] { Integer.valueOf(this.mWidth), Integer.valueOf(this.mHeight) }));
  }
  
  protected final void onDraw(Canvas paramCanvas)
  {
    paramCanvas.save();
    if (this.rsa) {
      paramCanvas.translate(this.rrV, 0.0F);
    }
    paramCanvas.clipRect(this.rrU);
    paramCanvas.drawBitmap(this.rrQ, this.rrT, this.rrT, this.mPaint);
    paramCanvas.restore();
  }
  
  protected final void onMeasure(int paramInt1, int paramInt2)
  {
    super.onMeasure(View.MeasureSpec.makeMeasureSpec(this.mWidth, 1073741824), View.MeasureSpec.makeMeasureSpec(this.mHeight, 1073741824));
  }
  
  public final void setContentStartPosX(int paramInt)
  {
    this.rrZ = paramInt;
  }
  
  public final void setListener(AnimatorListenerAdapter paramAnimatorListenerAdapter)
  {
    this.rsb = paramAnimatorListenerAdapter;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.ui.tools.bag.j
 * JD-Core Version:    0.7.0.1
 */