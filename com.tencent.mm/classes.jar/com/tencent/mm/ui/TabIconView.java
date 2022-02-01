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
  private Bitmap WeT;
  private Bitmap WeU;
  private Bitmap WeV;
  private Rect WeW;
  private Rect WeX;
  private Rect WeY;
  private int WeZ = 0;
  private Paint bll;
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
  
  public final void i(int paramInt1, int paramInt2, int paramInt3, boolean paramBoolean)
  {
    AppMethodBeat.i(33778);
    if (paramBoolean) {
      this.scale *= 1.2F;
    }
    this.WeT = BitmapUtil.getBitmapNative(paramInt1, this.scale);
    this.WeU = BitmapUtil.getBitmapNative(paramInt3, this.scale);
    this.WeV = BitmapUtil.getBitmapNative(paramInt2, this.scale);
    if (this.WeT != null) {
      this.WeW = new Rect(0, 0, this.WeT.getWidth(), this.WeT.getHeight());
    }
    if (this.WeU != null) {
      this.WeX = new Rect(0, 0, this.WeU.getWidth(), this.WeU.getHeight());
    }
    if (this.WeV != null) {
      this.WeY = new Rect(0, 0, this.WeV.getWidth(), this.WeV.getHeight());
    }
    this.paint = new Paint(1);
    this.bll = new Paint(1);
    this.bll.setColorFilter(new PorterDuffColorFilter(this.mContext.getResources().getColor(R.e.FG_0), PorterDuff.Mode.SRC_ATOP));
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
    if (this.WeZ < 128)
    {
      this.bll.setAlpha(255 - this.WeZ);
      paramCanvas.drawBitmap(this.WeU, null, this.WeX, this.bll);
      this.paint.setAlpha(this.WeZ);
      paramCanvas.drawBitmap(this.WeV, null, this.WeY, this.paint);
      AppMethodBeat.o(33780);
      return;
    }
    this.paint.setAlpha(255 - this.WeZ);
    paramCanvas.drawBitmap(this.WeV, null, this.WeY, this.paint);
    this.paint.setAlpha(this.WeZ);
    paramCanvas.drawBitmap(this.WeT, null, this.WeW, this.paint);
    AppMethodBeat.o(33780);
  }
  
  public void setFocusAlpha(int paramInt)
  {
    AppMethodBeat.i(33779);
    this.WeZ = paramInt;
    invalidate();
    AppMethodBeat.o(33779);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.ui.TabIconView
 * JD-Core Version:    0.7.0.1
 */