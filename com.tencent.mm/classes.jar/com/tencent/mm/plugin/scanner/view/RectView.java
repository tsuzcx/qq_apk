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
  int yAN;
  int yAO;
  private Paint ysE;
  private Bitmap ysf;
  private Bitmap ysg;
  private Bitmap ysh;
  private Bitmap ysi;
  
  public RectView(Context paramContext)
  {
    super(paramContext);
    AppMethodBeat.i(91085);
    this.ysf = null;
    this.ysg = null;
    this.ysh = null;
    this.ysi = null;
    this.yAN = 0;
    this.yAO = 0;
    this.paint = new Paint();
    this.ysE = new Paint();
    init();
    AppMethodBeat.o(91085);
  }
  
  public RectView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(91086);
    this.ysf = null;
    this.ysg = null;
    this.ysh = null;
    this.ysi = null;
    this.yAN = 0;
    this.yAO = 0;
    this.paint = new Paint();
    this.ysE = new Paint();
    init();
    AppMethodBeat.o(91086);
  }
  
  public RectView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(91087);
    this.ysf = null;
    this.ysg = null;
    this.ysh = null;
    this.ysi = null;
    this.yAN = 0;
    this.yAO = 0;
    this.paint = new Paint();
    this.ysE = new Paint();
    init();
    AppMethodBeat.o(91087);
  }
  
  private void init()
  {
    AppMethodBeat.i(91088);
    this.ysf = BitmapFactory.decodeResource(getResources(), 2131233910);
    this.ysg = BitmapFactory.decodeResource(getResources(), 2131233911);
    this.ysh = BitmapFactory.decodeResource(getResources(), 2131233912);
    this.ysi = BitmapFactory.decodeResource(getResources(), 2131233913);
    this.yAN = this.ysf.getWidth();
    this.yAO = this.ysf.getHeight();
    this.paint.setAntiAlias(true);
    this.ysE.setAntiAlias(true);
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
    paramCanvas.drawBitmap(this.ysf, this.rect.left, this.rect.top, this.ysE);
    paramCanvas.drawBitmap(this.ysg, this.rect.right - this.yAN, this.rect.top, this.ysE);
    paramCanvas.drawBitmap(this.ysh, this.rect.left, this.rect.bottom - this.yAO, this.ysE);
    paramCanvas.drawBitmap(this.ysi, this.rect.right - this.yAN, this.rect.bottom - this.yAO, this.ysE);
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