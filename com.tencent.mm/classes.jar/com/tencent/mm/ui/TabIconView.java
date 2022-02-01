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
import com.tencent.mm.sdk.platformtools.h;

public class TabIconView
  extends ImageView
{
  private Bitmap JAP;
  private Bitmap JAQ;
  private Bitmap JAR;
  private Rect JAS;
  private Rect JAT;
  private Rect JAU;
  private int JAV = 0;
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
    this.JAP = h.u(paramInt1, this.scale);
    this.JAQ = h.u(paramInt3, this.scale);
    this.JAR = h.u(paramInt2, this.scale);
    if (this.JAP != null) {
      this.JAS = new Rect(0, 0, this.JAP.getWidth(), this.JAP.getHeight());
    }
    if (this.JAQ != null) {
      this.JAT = new Rect(0, 0, this.JAQ.getWidth(), this.JAQ.getHeight());
    }
    if (this.JAR != null) {
      this.JAU = new Rect(0, 0, this.JAR.getWidth(), this.JAR.getHeight());
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
    if (this.JAV < 128)
    {
      this.bBH.setAlpha(255 - this.JAV);
      paramCanvas.drawBitmap(this.JAQ, null, this.JAT, this.bBH);
      this.paint.setAlpha(this.JAV);
      paramCanvas.drawBitmap(this.JAR, null, this.JAU, this.paint);
      AppMethodBeat.o(33780);
      return;
    }
    this.paint.setAlpha(255 - this.JAV);
    paramCanvas.drawBitmap(this.JAR, null, this.JAU, this.paint);
    this.paint.setAlpha(this.JAV);
    paramCanvas.drawBitmap(this.JAP, null, this.JAS, this.paint);
    AppMethodBeat.o(33780);
  }
  
  public void setFocusAlpha(int paramInt)
  {
    AppMethodBeat.i(33779);
    this.JAV = paramInt;
    invalidate();
    AppMethodBeat.o(33779);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.ui.TabIconView
 * JD-Core Version:    0.7.0.1
 */