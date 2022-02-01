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
import com.tencent.mm.plugin.al.a.d;

public class RectView
  extends View
{
  private Paint PaM;
  private Bitmap Pan;
  private Bitmap Pao;
  private Bitmap Pap;
  private Bitmap Paq;
  int Pku;
  int Pkv;
  private Paint paint;
  private Rect rect;
  
  public RectView(Context paramContext)
  {
    super(paramContext);
    AppMethodBeat.i(91085);
    this.Pan = null;
    this.Pao = null;
    this.Pap = null;
    this.Paq = null;
    this.Pku = 0;
    this.Pkv = 0;
    this.paint = new Paint();
    this.PaM = new Paint();
    init();
    AppMethodBeat.o(91085);
  }
  
  public RectView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(91086);
    this.Pan = null;
    this.Pao = null;
    this.Pap = null;
    this.Paq = null;
    this.Pku = 0;
    this.Pkv = 0;
    this.paint = new Paint();
    this.PaM = new Paint();
    init();
    AppMethodBeat.o(91086);
  }
  
  public RectView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(91087);
    this.Pan = null;
    this.Pao = null;
    this.Pap = null;
    this.Paq = null;
    this.Pku = 0;
    this.Pkv = 0;
    this.paint = new Paint();
    this.PaM = new Paint();
    init();
    AppMethodBeat.o(91087);
  }
  
  private void init()
  {
    AppMethodBeat.i(91088);
    this.Pan = BitmapFactory.decodeResource(getResources(), a.d.scanqr1);
    this.Pao = BitmapFactory.decodeResource(getResources(), a.d.scanqr2);
    this.Pap = BitmapFactory.decodeResource(getResources(), a.d.scanqr3);
    this.Paq = BitmapFactory.decodeResource(getResources(), a.d.scanqr4);
    this.Pku = this.Pan.getWidth();
    this.Pkv = this.Pan.getHeight();
    this.paint.setAntiAlias(true);
    this.PaM.setAntiAlias(true);
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
    paramCanvas.drawBitmap(this.Pan, this.rect.left, this.rect.top, this.PaM);
    paramCanvas.drawBitmap(this.Pao, this.rect.right - this.Pku, this.rect.top, this.PaM);
    paramCanvas.drawBitmap(this.Pap, this.rect.left, this.rect.bottom - this.Pkv, this.PaM);
    paramCanvas.drawBitmap(this.Paq, this.rect.right - this.Pku, this.rect.bottom - this.Pkv, this.PaM);
    AppMethodBeat.o(91090);
  }
  
  public void setRect(Rect paramRect)
  {
    this.rect = paramRect;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.scanner.view.RectView
 * JD-Core Version:    0.7.0.1
 */