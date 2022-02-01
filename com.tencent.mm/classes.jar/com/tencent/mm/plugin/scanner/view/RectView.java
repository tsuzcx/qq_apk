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
  private Paint xeC;
  private Bitmap xed;
  private Bitmap xee;
  private Bitmap xef;
  private Bitmap xeg;
  int xmM;
  int xmN;
  
  public RectView(Context paramContext)
  {
    super(paramContext);
    AppMethodBeat.i(91085);
    this.xed = null;
    this.xee = null;
    this.xef = null;
    this.xeg = null;
    this.xmM = 0;
    this.xmN = 0;
    this.paint = new Paint();
    this.xeC = new Paint();
    init();
    AppMethodBeat.o(91085);
  }
  
  public RectView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(91086);
    this.xed = null;
    this.xee = null;
    this.xef = null;
    this.xeg = null;
    this.xmM = 0;
    this.xmN = 0;
    this.paint = new Paint();
    this.xeC = new Paint();
    init();
    AppMethodBeat.o(91086);
  }
  
  public RectView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(91087);
    this.xed = null;
    this.xee = null;
    this.xef = null;
    this.xeg = null;
    this.xmM = 0;
    this.xmN = 0;
    this.paint = new Paint();
    this.xeC = new Paint();
    init();
    AppMethodBeat.o(91087);
  }
  
  private void init()
  {
    AppMethodBeat.i(91088);
    this.xed = BitmapFactory.decodeResource(getResources(), 2131233910);
    this.xee = BitmapFactory.decodeResource(getResources(), 2131233911);
    this.xef = BitmapFactory.decodeResource(getResources(), 2131233912);
    this.xeg = BitmapFactory.decodeResource(getResources(), 2131233913);
    this.xmM = this.xed.getWidth();
    this.xmN = this.xed.getHeight();
    this.paint.setAntiAlias(true);
    this.xeC.setAntiAlias(true);
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
    paramCanvas.drawBitmap(this.xed, this.rect.left, this.rect.top, this.xeC);
    paramCanvas.drawBitmap(this.xee, this.rect.right - this.xmM, this.rect.top, this.xeC);
    paramCanvas.drawBitmap(this.xef, this.rect.left, this.rect.bottom - this.xmN, this.xeC);
    paramCanvas.drawBitmap(this.xeg, this.rect.right - this.xmM, this.rect.bottom - this.xmN, this.xeC);
    AppMethodBeat.o(91090);
  }
  
  public void setRect(Rect paramRect)
  {
    this.rect = paramRect;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.scanner.view.RectView
 * JD-Core Version:    0.7.0.1
 */