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
  private Paint yIE;
  private Bitmap yIf;
  private Bitmap yIg;
  private Bitmap yIh;
  private Bitmap yIi;
  int yQN;
  int yQO;
  
  public RectView(Context paramContext)
  {
    super(paramContext);
    AppMethodBeat.i(91085);
    this.yIf = null;
    this.yIg = null;
    this.yIh = null;
    this.yIi = null;
    this.yQN = 0;
    this.yQO = 0;
    this.paint = new Paint();
    this.yIE = new Paint();
    init();
    AppMethodBeat.o(91085);
  }
  
  public RectView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(91086);
    this.yIf = null;
    this.yIg = null;
    this.yIh = null;
    this.yIi = null;
    this.yQN = 0;
    this.yQO = 0;
    this.paint = new Paint();
    this.yIE = new Paint();
    init();
    AppMethodBeat.o(91086);
  }
  
  public RectView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(91087);
    this.yIf = null;
    this.yIg = null;
    this.yIh = null;
    this.yIi = null;
    this.yQN = 0;
    this.yQO = 0;
    this.paint = new Paint();
    this.yIE = new Paint();
    init();
    AppMethodBeat.o(91087);
  }
  
  private void init()
  {
    AppMethodBeat.i(91088);
    this.yIf = BitmapFactory.decodeResource(getResources(), 2131233910);
    this.yIg = BitmapFactory.decodeResource(getResources(), 2131233911);
    this.yIh = BitmapFactory.decodeResource(getResources(), 2131233912);
    this.yIi = BitmapFactory.decodeResource(getResources(), 2131233913);
    this.yQN = this.yIf.getWidth();
    this.yQO = this.yIf.getHeight();
    this.paint.setAntiAlias(true);
    this.yIE.setAntiAlias(true);
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
    paramCanvas.drawBitmap(this.yIf, this.rect.left, this.rect.top, this.yIE);
    paramCanvas.drawBitmap(this.yIg, this.rect.right - this.yQN, this.rect.top, this.yIE);
    paramCanvas.drawBitmap(this.yIh, this.rect.left, this.rect.bottom - this.yQO, this.yIE);
    paramCanvas.drawBitmap(this.yIi, this.rect.right - this.yQN, this.rect.bottom - this.yQO, this.yIE);
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