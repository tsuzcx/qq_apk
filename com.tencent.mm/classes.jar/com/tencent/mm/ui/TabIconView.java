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
import com.tencent.mm.sdk.platformtools.BitmapUtil;

public class TabIconView
  extends ImageView
{
  private int OLA = 0;
  private Bitmap OLu;
  private Bitmap OLv;
  private Bitmap OLw;
  private Rect OLx;
  private Rect OLy;
  private Rect OLz;
  private Paint bBJ;
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
    this.OLu = BitmapUtil.getBitmapNative(paramInt1, this.scale);
    this.OLv = BitmapUtil.getBitmapNative(paramInt3, this.scale);
    this.OLw = BitmapUtil.getBitmapNative(paramInt2, this.scale);
    if (this.OLu != null) {
      this.OLx = new Rect(0, 0, this.OLu.getWidth(), this.OLu.getHeight());
    }
    if (this.OLv != null) {
      this.OLy = new Rect(0, 0, this.OLv.getWidth(), this.OLv.getHeight());
    }
    if (this.OLw != null) {
      this.OLz = new Rect(0, 0, this.OLw.getWidth(), this.OLw.getHeight());
    }
    this.paint = new Paint(1);
    this.bBJ = new Paint(1);
    this.bBJ.setColorFilter(new PorterDuffColorFilter(this.mContext.getResources().getColor(2131099746), PorterDuff.Mode.SRC_ATOP));
    this.paint.setColorFilter(new PorterDuffColorFilter(this.mContext.getResources().getColor(2131101414), PorterDuff.Mode.SRC_ATOP));
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
    if (this.OLA < 128)
    {
      this.bBJ.setAlpha(255 - this.OLA);
      paramCanvas.drawBitmap(this.OLv, null, this.OLy, this.bBJ);
      this.paint.setAlpha(this.OLA);
      paramCanvas.drawBitmap(this.OLw, null, this.OLz, this.paint);
      AppMethodBeat.o(33780);
      return;
    }
    this.paint.setAlpha(255 - this.OLA);
    paramCanvas.drawBitmap(this.OLw, null, this.OLz, this.paint);
    this.paint.setAlpha(this.OLA);
    paramCanvas.drawBitmap(this.OLu, null, this.OLx, this.paint);
    AppMethodBeat.o(33780);
  }
  
  public void setFocusAlpha(int paramInt)
  {
    AppMethodBeat.i(33779);
    this.OLA = paramInt;
    invalidate();
    AppMethodBeat.o(33779);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.ui.TabIconView
 * JD-Core Version:    0.7.0.1
 */