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
import com.tencent.mm.sdk.platformtools.d;

public class TabIconView
  extends ImageView
{
  private Paint aVl;
  private Context mContext;
  private Paint paint;
  private float scale = 1.166667F;
  private int zfA = 0;
  private Bitmap zfu;
  private Bitmap zfv;
  private Bitmap zfw;
  private Rect zfx;
  private Rect zfy;
  private Rect zfz;
  
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
  
  public final void g(int paramInt1, int paramInt2, int paramInt3, boolean paramBoolean)
  {
    AppMethodBeat.i(29922);
    if (paramBoolean) {
      this.scale *= 1.2F;
    }
    this.zfu = d.n(paramInt1, this.scale);
    this.zfv = d.n(paramInt3, this.scale);
    this.zfw = d.n(paramInt2, this.scale);
    this.zfx = new Rect(0, 0, this.zfu.getWidth(), this.zfu.getHeight());
    this.zfy = new Rect(0, 0, this.zfv.getWidth(), this.zfv.getHeight());
    this.zfz = new Rect(0, 0, this.zfw.getWidth(), this.zfw.getHeight());
    this.paint = new Paint(1);
    this.aVl = new Paint(1);
    this.aVl.setColorFilter(new PorterDuffColorFilter(this.mContext.getResources().getColor(2131689766), PorterDuff.Mode.SRC_ATOP));
    this.paint.setColorFilter(new PorterDuffColorFilter(this.mContext.getResources().getColor(2131690701), PorterDuff.Mode.SRC_ATOP));
    AppMethodBeat.o(29922);
  }
  
  protected void onDraw(Canvas paramCanvas)
  {
    AppMethodBeat.i(29924);
    super.onDraw(paramCanvas);
    if (this.paint == null)
    {
      AppMethodBeat.o(29924);
      return;
    }
    if (this.zfA < 128)
    {
      this.paint.setAlpha(255 - this.zfA * 2);
      this.aVl.setAlpha(255 - this.zfA * 2);
      paramCanvas.drawBitmap(this.zfv, null, this.zfy, this.aVl);
      this.paint.setAlpha(this.zfA * 2);
      paramCanvas.drawBitmap(this.zfw, null, this.zfz, this.paint);
      AppMethodBeat.o(29924);
      return;
    }
    this.paint.setAlpha(255 - this.zfA * 2);
    paramCanvas.drawBitmap(this.zfw, null, this.zfz, this.paint);
    this.paint.setAlpha(this.zfA * 2);
    paramCanvas.drawBitmap(this.zfu, null, this.zfx, this.paint);
    AppMethodBeat.o(29924);
  }
  
  public void setFocusAlpha(int paramInt)
  {
    AppMethodBeat.i(29923);
    this.zfA = paramInt;
    invalidate();
    AppMethodBeat.o(29923);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.ui.TabIconView
 * JD-Core Version:    0.7.0.1
 */