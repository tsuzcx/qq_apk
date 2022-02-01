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
import com.tencent.mm.plugin.ak.a.d;

public class RectView
  extends View
{
  private Paint IRR;
  private Bitmap IRs;
  private Bitmap IRt;
  private Bitmap IRu;
  private Bitmap IRv;
  int JaA;
  int JaB;
  private Rect byG;
  private Paint paint;
  
  public RectView(Context paramContext)
  {
    super(paramContext);
    AppMethodBeat.i(91085);
    this.IRs = null;
    this.IRt = null;
    this.IRu = null;
    this.IRv = null;
    this.JaA = 0;
    this.JaB = 0;
    this.paint = new Paint();
    this.IRR = new Paint();
    init();
    AppMethodBeat.o(91085);
  }
  
  public RectView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(91086);
    this.IRs = null;
    this.IRt = null;
    this.IRu = null;
    this.IRv = null;
    this.JaA = 0;
    this.JaB = 0;
    this.paint = new Paint();
    this.IRR = new Paint();
    init();
    AppMethodBeat.o(91086);
  }
  
  public RectView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(91087);
    this.IRs = null;
    this.IRt = null;
    this.IRu = null;
    this.IRv = null;
    this.JaA = 0;
    this.JaB = 0;
    this.paint = new Paint();
    this.IRR = new Paint();
    init();
    AppMethodBeat.o(91087);
  }
  
  private void init()
  {
    AppMethodBeat.i(91088);
    this.IRs = BitmapFactory.decodeResource(getResources(), a.d.scanqr1);
    this.IRt = BitmapFactory.decodeResource(getResources(), a.d.scanqr2);
    this.IRu = BitmapFactory.decodeResource(getResources(), a.d.scanqr3);
    this.IRv = BitmapFactory.decodeResource(getResources(), a.d.scanqr4);
    this.JaA = this.IRs.getWidth();
    this.JaB = this.IRs.getHeight();
    this.paint.setAntiAlias(true);
    this.IRR.setAntiAlias(true);
    AppMethodBeat.o(91088);
  }
  
  public Rect getRect()
  {
    AppMethodBeat.i(91089);
    Rect localRect = new Rect(this.byG);
    AppMethodBeat.o(91089);
    return localRect;
  }
  
  protected void onDraw(Canvas paramCanvas)
  {
    AppMethodBeat.i(91090);
    super.onDraw(paramCanvas);
    paramCanvas.save();
    paramCanvas.clipRect(this.byG, Region.Op.DIFFERENCE);
    paramCanvas.drawRect(this.byG, this.paint);
    paramCanvas.restore();
    paramCanvas.drawBitmap(this.IRs, this.byG.left, this.byG.top, this.IRR);
    paramCanvas.drawBitmap(this.IRt, this.byG.right - this.JaA, this.byG.top, this.IRR);
    paramCanvas.drawBitmap(this.IRu, this.byG.left, this.byG.bottom - this.JaB, this.IRR);
    paramCanvas.drawBitmap(this.IRv, this.byG.right - this.JaA, this.byG.bottom - this.JaB, this.IRR);
    AppMethodBeat.o(91090);
  }
  
  public void setRect(Rect paramRect)
  {
    this.byG = paramRect;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.scanner.view.RectView
 * JD-Core Version:    0.7.0.1
 */