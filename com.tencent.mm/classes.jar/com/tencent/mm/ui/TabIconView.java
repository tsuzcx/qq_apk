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
import com.tencent.mm.sdk.platformtools.g;

public class TabIconView
  extends ImageView
{
  private Bitmap Jge;
  private Bitmap Jgf;
  private Bitmap Jgg;
  private Rect Jgh;
  private Rect Jgi;
  private Rect Jgj;
  private int Jgk = 0;
  private Paint bBH;
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
    this.Jge = g.v(paramInt1, this.scale);
    this.Jgf = g.v(paramInt3, this.scale);
    this.Jgg = g.v(paramInt2, this.scale);
    if (this.Jge != null) {
      this.Jgh = new Rect(0, 0, this.Jge.getWidth(), this.Jge.getHeight());
    }
    if (this.Jgf != null) {
      this.Jgi = new Rect(0, 0, this.Jgf.getWidth(), this.Jgf.getHeight());
    }
    if (this.Jgg != null) {
      this.Jgj = new Rect(0, 0, this.Jgg.getWidth(), this.Jgg.getHeight());
    }
    this.paint = new Paint(1);
    this.bBH = new Paint(1);
    this.bBH.setColorFilter(new PorterDuffColorFilter(this.mContext.getResources().getColor(2131099732), PorterDuff.Mode.SRC_ATOP));
    this.paint.setColorFilter(new PorterDuffColorFilter(this.mContext.getResources().getColor(2131101171), PorterDuff.Mode.SRC_ATOP));
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
    if (this.Jgk < 128)
    {
      this.bBH.setAlpha(255 - this.Jgk);
      paramCanvas.drawBitmap(this.Jgf, null, this.Jgi, this.bBH);
      this.paint.setAlpha(this.Jgk);
      paramCanvas.drawBitmap(this.Jgg, null, this.Jgj, this.paint);
      AppMethodBeat.o(33780);
      return;
    }
    this.paint.setAlpha(255 - this.Jgk);
    paramCanvas.drawBitmap(this.Jgg, null, this.Jgj, this.paint);
    this.paint.setAlpha(this.Jgk);
    paramCanvas.drawBitmap(this.Jge, null, this.Jgh, this.paint);
    AppMethodBeat.o(33780);
  }
  
  public void setFocusAlpha(int paramInt)
  {
    AppMethodBeat.i(33779);
    this.Jgk = paramInt;
    invalidate();
    AppMethodBeat.o(33779);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.ui.TabIconView
 * JD-Core Version:    0.7.0.1
 */