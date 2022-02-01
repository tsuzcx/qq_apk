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
  private Bitmap CLS;
  private Bitmap CLT;
  private Bitmap CLU;
  private Bitmap CLV;
  private Paint CMr;
  int CVa;
  int CVb;
  private Paint paint;
  private Rect rect;
  
  public RectView(Context paramContext)
  {
    super(paramContext);
    AppMethodBeat.i(91085);
    this.CLS = null;
    this.CLT = null;
    this.CLU = null;
    this.CLV = null;
    this.CVa = 0;
    this.CVb = 0;
    this.paint = new Paint();
    this.CMr = new Paint();
    init();
    AppMethodBeat.o(91085);
  }
  
  public RectView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(91086);
    this.CLS = null;
    this.CLT = null;
    this.CLU = null;
    this.CLV = null;
    this.CVa = 0;
    this.CVb = 0;
    this.paint = new Paint();
    this.CMr = new Paint();
    init();
    AppMethodBeat.o(91086);
  }
  
  public RectView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(91087);
    this.CLS = null;
    this.CLT = null;
    this.CLU = null;
    this.CLV = null;
    this.CVa = 0;
    this.CVb = 0;
    this.paint = new Paint();
    this.CMr = new Paint();
    init();
    AppMethodBeat.o(91087);
  }
  
  private void init()
  {
    AppMethodBeat.i(91088);
    this.CLS = BitmapFactory.decodeResource(getResources(), 2131234738);
    this.CLT = BitmapFactory.decodeResource(getResources(), 2131234739);
    this.CLU = BitmapFactory.decodeResource(getResources(), 2131234740);
    this.CLV = BitmapFactory.decodeResource(getResources(), 2131234741);
    this.CVa = this.CLS.getWidth();
    this.CVb = this.CLS.getHeight();
    this.paint.setAntiAlias(true);
    this.CMr.setAntiAlias(true);
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
    paramCanvas.drawBitmap(this.CLS, this.rect.left, this.rect.top, this.CMr);
    paramCanvas.drawBitmap(this.CLT, this.rect.right - this.CVa, this.rect.top, this.CMr);
    paramCanvas.drawBitmap(this.CLU, this.rect.left, this.rect.bottom - this.CVb, this.CMr);
    paramCanvas.drawBitmap(this.CLV, this.rect.right - this.CVa, this.rect.bottom - this.CVb, this.CMr);
    AppMethodBeat.o(91090);
  }
  
  public void setRect(Rect paramRect)
  {
    this.rect = paramRect;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.scanner.view.RectView
 * JD-Core Version:    0.7.0.1
 */