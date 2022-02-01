package com.tencent.mm.plugin.scanner.view;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.Region.Op;
import android.util.AttributeSet;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;

public class RectView
  extends View
{
  private Paint paint;
  private Rect rect;
  private Paint vTR;
  private Bitmap vTs;
  private Bitmap vTt;
  private Bitmap vTu;
  private Bitmap vTv;
  int wbF;
  int wbG;
  
  public RectView(Context paramContext)
  {
    super(paramContext);
    AppMethodBeat.i(91085);
    this.vTs = null;
    this.vTt = null;
    this.vTu = null;
    this.vTv = null;
    this.wbF = 0;
    this.wbG = 0;
    this.paint = new Paint();
    this.vTR = new Paint();
    init();
    AppMethodBeat.o(91085);
  }
  
  public RectView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(91086);
    this.vTs = null;
    this.vTt = null;
    this.vTu = null;
    this.vTv = null;
    this.wbF = 0;
    this.wbG = 0;
    this.paint = new Paint();
    this.vTR = new Paint();
    init();
    AppMethodBeat.o(91086);
  }
  
  public RectView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(91087);
    this.vTs = null;
    this.vTt = null;
    this.vTu = null;
    this.vTv = null;
    this.wbF = 0;
    this.wbG = 0;
    this.paint = new Paint();
    this.vTR = new Paint();
    init();
    AppMethodBeat.o(91087);
  }
  
  private void init()
  {
    AppMethodBeat.i(91088);
    this.vTs = BitmapFactory.decodeResource(getResources(), 2131233910);
    this.vTt = BitmapFactory.decodeResource(getResources(), 2131233911);
    this.vTu = BitmapFactory.decodeResource(getResources(), 2131233912);
    this.vTv = BitmapFactory.decodeResource(getResources(), 2131233913);
    this.wbF = this.vTs.getWidth();
    this.wbG = this.vTs.getHeight();
    this.paint.setAntiAlias(true);
    this.vTR.setAntiAlias(true);
    AppMethodBeat.o(91088);
  }
  
  public Rect getRect()
  {
    AppMethodBeat.i(91089);
    Rect localRect = new Rect(this.rect);
    AppMethodBeat.o(91089);
    return localRect;
  }
  
  protected void onDraw(Canvas paramCanvas)
  {
    AppMethodBeat.i(91090);
    super.onDraw(paramCanvas);
    paramCanvas.save();
    paramCanvas.clipRect(this.rect, Region.Op.DIFFERENCE);
    paramCanvas.drawRect(this.rect, this.paint);
    paramCanvas.restore();
    paramCanvas.drawBitmap(this.vTs, this.rect.left, this.rect.top, this.vTR);
    paramCanvas.drawBitmap(this.vTt, this.rect.right - this.wbF, this.rect.top, this.vTR);
    paramCanvas.drawBitmap(this.vTu, this.rect.left, this.rect.bottom - this.wbG, this.vTR);
    paramCanvas.drawBitmap(this.vTv, this.rect.right - this.wbF, this.rect.bottom - this.wbG, this.vTR);
    AppMethodBeat.o(91090);
  }
  
  public void setRect(Rect paramRect)
  {
    this.rect = paramRect;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.scanner.view.RectView
 * JD-Core Version:    0.7.0.1
 */