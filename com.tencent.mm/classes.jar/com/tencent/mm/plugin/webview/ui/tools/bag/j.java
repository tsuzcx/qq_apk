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
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;

public final class j
  extends View
{
  int mHeight;
  private Bitmap mMaskBitmap;
  private Paint mPaint;
  int mWidth;
  boolean uVw;
  private Bitmap vhV;
  private Canvas vhW;
  private Paint vhX;
  private Rect vhY;
  private RectF vhZ;
  private int vib;
  int vic;
  int vid;
  int vie;
  int vif;
  private AnimatorListenerAdapter vig;
  
  public j(Context paramContext, Bitmap paramBitmap)
  {
    super(paramContext);
    AppMethodBeat.i(8181);
    this.vif = -1;
    this.mPaint = new Paint();
    this.vhX = new Paint();
    paramContext = new PorterDuffXfermode(PorterDuff.Mode.DST_IN);
    this.vhX.setXfermode(paramContext);
    this.vhV = paramBitmap;
    this.mWidth = paramBitmap.getWidth();
    this.mHeight = paramBitmap.getHeight();
    this.vhY = new Rect(0, 0, this.mWidth, this.mHeight);
    this.mMaskBitmap = Bitmap.createBitmap(this.mWidth, this.mHeight, Bitmap.Config.ARGB_8888);
    this.vhW = new Canvas(this.mMaskBitmap);
    this.vhZ = new RectF();
    this.vhZ.left = 0.0F;
    this.vhZ.top = 0.0F;
    this.vhZ.right = this.mWidth;
    this.vhZ.bottom = this.mHeight;
    ab.i("MicroMsg.TransformToBagAniMask", String.format("init: mWidth:%d mHeight:%d", new Object[] { Integer.valueOf(this.mWidth), Integer.valueOf(this.mHeight) }));
    AppMethodBeat.o(8181);
  }
  
  protected final void onDraw(Canvas paramCanvas)
  {
    AppMethodBeat.i(8182);
    paramCanvas.save();
    if (this.uVw) {
      paramCanvas.translate(this.vib, 0.0F);
    }
    paramCanvas.clipRect(this.vhZ);
    paramCanvas.drawBitmap(this.vhV, this.vhY, this.vhY, this.mPaint);
    paramCanvas.restore();
    AppMethodBeat.o(8182);
  }
  
  protected final void onMeasure(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(8183);
    super.onMeasure(View.MeasureSpec.makeMeasureSpec(this.mWidth, 1073741824), View.MeasureSpec.makeMeasureSpec(this.mHeight, 1073741824));
    AppMethodBeat.o(8183);
  }
  
  public final void setContentStartPosX(int paramInt)
  {
    this.vif = paramInt;
  }
  
  public final void setListener(AnimatorListenerAdapter paramAnimatorListenerAdapter)
  {
    this.vig = paramAnimatorListenerAdapter;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.ui.tools.bag.j
 * JD-Core Version:    0.7.0.1
 */