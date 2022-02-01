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
  private Bitmap FSD;
  private Bitmap FSE;
  private Bitmap FSF;
  private Rect FSG;
  private Rect FSH;
  private Rect FSI;
  private int FSJ = 0;
  private Paint bto;
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
  
  public final void g(int paramInt1, int paramInt2, int paramInt3, boolean paramBoolean)
  {
    AppMethodBeat.i(33778);
    if (paramBoolean) {
      this.scale *= 1.2F;
    }
    this.FSD = f.t(paramInt1, this.scale);
    this.FSE = f.t(paramInt3, this.scale);
    this.FSF = f.t(paramInt2, this.scale);
    if (this.FSD != null) {
      this.FSG = new Rect(0, 0, this.FSD.getWidth(), this.FSD.getHeight());
    }
    if (this.FSE != null) {
      this.FSH = new Rect(0, 0, this.FSE.getWidth(), this.FSE.getHeight());
    }
    if (this.FSF != null) {
      this.FSI = new Rect(0, 0, this.FSF.getWidth(), this.FSF.getHeight());
    }
    this.paint = new Paint(1);
    this.bto = new Paint(1);
    this.bto.setColorFilter(new PorterDuffColorFilter(ao.aD(this.mContext, 2130968584), PorterDuff.Mode.SRC_ATOP));
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
    if (this.FSJ < 128)
    {
      this.bto.setAlpha(255 - this.FSJ);
      paramCanvas.drawBitmap(this.FSE, null, this.FSH, this.bto);
      this.paint.setAlpha(this.FSJ);
      paramCanvas.drawBitmap(this.FSF, null, this.FSI, this.paint);
      AppMethodBeat.o(33780);
      return;
    }
    this.paint.setAlpha(255 - this.FSJ);
    paramCanvas.drawBitmap(this.FSF, null, this.FSI, this.paint);
    this.paint.setAlpha(this.FSJ);
    paramCanvas.drawBitmap(this.FSD, null, this.FSG, this.paint);
    AppMethodBeat.o(33780);
  }
  
  public void setFocusAlpha(int paramInt)
  {
    AppMethodBeat.i(33779);
    this.FSJ = paramInt;
    invalidate();
    AppMethodBeat.o(33779);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.ui.TabIconView
 * JD-Core Version:    0.7.0.1
 */