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
import com.tencent.mm.sdk.platformtools.f;

public class TabIconView
  extends ImageView
{
  private Bitmap Hss;
  private Bitmap Hst;
  private Bitmap Hsu;
  private Rect Hsv;
  private Rect Hsw;
  private Rect Hsx;
  private int Hsy = 0;
  private Paint brn;
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
    this.Hss = f.t(paramInt1, this.scale);
    this.Hst = f.t(paramInt3, this.scale);
    this.Hsu = f.t(paramInt2, this.scale);
    if (this.Hss != null) {
      this.Hsv = new Rect(0, 0, this.Hss.getWidth(), this.Hss.getHeight());
    }
    if (this.Hst != null) {
      this.Hsw = new Rect(0, 0, this.Hst.getWidth(), this.Hst.getHeight());
    }
    if (this.Hsu != null) {
      this.Hsx = new Rect(0, 0, this.Hsu.getWidth(), this.Hsu.getHeight());
    }
    this.paint = new Paint(1);
    this.brn = new Paint(1);
    this.brn.setColorFilter(new PorterDuffColorFilter(ao.aJ(this.mContext, 2130968584), PorterDuff.Mode.SRC_ATOP));
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
    if (this.Hsy < 128)
    {
      this.brn.setAlpha(255 - this.Hsy);
      paramCanvas.drawBitmap(this.Hst, null, this.Hsw, this.brn);
      this.paint.setAlpha(this.Hsy);
      paramCanvas.drawBitmap(this.Hsu, null, this.Hsx, this.paint);
      AppMethodBeat.o(33780);
      return;
    }
    this.paint.setAlpha(255 - this.Hsy);
    paramCanvas.drawBitmap(this.Hsu, null, this.Hsx, this.paint);
    this.paint.setAlpha(this.Hsy);
    paramCanvas.drawBitmap(this.Hss, null, this.Hsv, this.paint);
    AppMethodBeat.o(33780);
  }
  
  public void setFocusAlpha(int paramInt)
  {
    AppMethodBeat.i(33779);
    this.Hsy = paramInt;
    invalidate();
    AppMethodBeat.o(33779);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.ui.TabIconView
 * JD-Core Version:    0.7.0.1
 */