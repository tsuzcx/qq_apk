package com.tencent.mm.ui;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PorterDuff.Mode;
import android.graphics.PorterDuffColorFilter;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.widget.ImageView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R.e;
import com.tencent.mm.sdk.platformtools.BitmapUtil;

public class TabIconView
  extends ImageView
{
  private Bitmap adKA;
  private Bitmap adKB;
  private Bitmap adKC;
  private Rect adKD;
  private Rect adKE;
  private Rect adKF;
  private int adKG = 0;
  private Paint dfh;
  private Context mContext;
  private Paint paint;
  private float scale = 1.166667F;
  
  public TabIconView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    this.mContext = paramContext;
  }
  
  public TabIconView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    this.mContext = paramContext;
  }
  
  public final void h(int paramInt1, int paramInt2, int paramInt3, boolean paramBoolean)
  {
    AppMethodBeat.i(33778);
    if (paramBoolean) {
      this.scale *= 1.2F;
    }
    this.adKA = BitmapUtil.getBitmapNative(paramInt1, this.scale);
    this.adKB = BitmapUtil.getBitmapNative(paramInt3, this.scale);
    this.adKC = BitmapUtil.getBitmapNative(paramInt2, this.scale);
    if (this.adKA != null) {
      this.adKD = new Rect(0, 0, this.adKA.getWidth(), this.adKA.getHeight());
    }
    if (this.adKB != null) {
      this.adKE = new Rect(0, 0, this.adKB.getWidth(), this.adKB.getHeight());
    }
    if (this.adKC != null) {
      this.adKF = new Rect(0, 0, this.adKC.getWidth(), this.adKC.getHeight());
    }
    this.paint = new Paint(1);
    this.dfh = new Paint(1);
    this.dfh.setColorFilter(new PorterDuffColorFilter(this.mContext.getResources().getColor(R.e.FG_0), PorterDuff.Mode.SRC_ATOP));
    this.paint.setColorFilter(new PorterDuffColorFilter(this.mContext.getResources().getColor(R.e.wechat_green), PorterDuff.Mode.SRC_ATOP));
    AppMethodBeat.o(33778);
  }
  
  protected void onDraw(Canvas paramCanvas)
  {
    AppMethodBeat.i(33780);
    super.onDraw(paramCanvas);
    if (this.paint == null)
    {
      AppMethodBeat.o(33780);
      return;
    }
    if (this.adKG < 128)
    {
      this.dfh.setAlpha(255 - this.adKG);
      paramCanvas.drawBitmap(this.adKB, null, this.adKE, this.dfh);
      this.paint.setAlpha(this.adKG);
      paramCanvas.drawBitmap(this.adKC, null, this.adKF, this.paint);
      AppMethodBeat.o(33780);
      return;
    }
    this.paint.setAlpha(255 - this.adKG);
    paramCanvas.drawBitmap(this.adKC, null, this.adKF, this.paint);
    this.paint.setAlpha(this.adKG);
    paramCanvas.drawBitmap(this.adKA, null, this.adKD, this.paint);
    AppMethodBeat.o(33780);
  }
  
  public void setFocusAlpha(int paramInt)
  {
    AppMethodBeat.i(33779);
    this.adKG = paramInt;
    invalidate();
    AppMethodBeat.o(33779);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.ui.TabIconView
 * JD-Core Version:    0.7.0.1
 */