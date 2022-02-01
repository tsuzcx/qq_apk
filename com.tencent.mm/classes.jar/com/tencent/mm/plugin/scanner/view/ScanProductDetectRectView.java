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

public class ScanProductDetectRectView
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
  
  public ScanProductDetectRectView(Context paramContext)
  {
    super(paramContext);
    AppMethodBeat.i(314014);
    this.Pan = null;
    this.Pao = null;
    this.Pap = null;
    this.Paq = null;
    this.Pku = 0;
    this.Pkv = 0;
    this.paint = new Paint();
    this.PaM = new Paint();
    init();
    AppMethodBeat.o(314014);
  }
  
  public ScanProductDetectRectView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(314023);
    this.Pan = null;
    this.Pao = null;
    this.Pap = null;
    this.Paq = null;
    this.Pku = 0;
    this.Pkv = 0;
    this.paint = new Paint();
    this.PaM = new Paint();
    init();
    AppMethodBeat.o(314023);
  }
  
  public ScanProductDetectRectView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(314027);
    this.Pan = null;
    this.Pao = null;
    this.Pap = null;
    this.Paq = null;
    this.Pku = 0;
    this.Pkv = 0;
    this.paint = new Paint();
    this.PaM = new Paint();
    init();
    AppMethodBeat.o(314027);
  }
  
  private void init()
  {
    AppMethodBeat.i(314031);
    this.Pan = BitmapFactory.decodeResource(getResources(), a.d.scan_product_lt);
    this.Pao = BitmapFactory.decodeResource(getResources(), a.d.scan_product_rt);
    this.Pap = BitmapFactory.decodeResource(getResources(), a.d.scan_product_lb);
    this.Paq = BitmapFactory.decodeResource(getResources(), a.d.scan_product_rb);
    this.Pku = this.Pan.getWidth();
    this.Pkv = this.Pan.getHeight();
    this.paint.setAntiAlias(true);
    this.PaM.setAntiAlias(true);
    AppMethodBeat.o(314031);
  }
  
  public Rect getRect()
  {
    AppMethodBeat.i(314039);
    Rect localRect = new Rect(this.rect);
    AppMethodBeat.o(314039);
    return localRect;
  }
  
  protected void onDraw(Canvas paramCanvas)
  {
    AppMethodBeat.i(314045);
    super.onDraw(paramCanvas);
    paramCanvas.save();
    paramCanvas.clipRect(this.rect, Region.Op.DIFFERENCE);
    paramCanvas.drawRect(this.rect, this.paint);
    paramCanvas.restore();
    paramCanvas.drawBitmap(this.Pan, this.rect.left, this.rect.top, this.PaM);
    paramCanvas.drawBitmap(this.Pao, this.rect.right - this.Pku, this.rect.top, this.PaM);
    paramCanvas.drawBitmap(this.Pap, this.rect.left, this.rect.bottom - this.Pkv, this.PaM);
    paramCanvas.drawBitmap(this.Paq, this.rect.right - this.Pku, this.rect.bottom - this.Pkv, this.PaM);
    AppMethodBeat.o(314045);
  }
  
  public void setRect(Rect paramRect)
  {
    this.rect = paramRect;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.scanner.view.ScanProductDetectRectView
 * JD-Core Version:    0.7.0.1
 */