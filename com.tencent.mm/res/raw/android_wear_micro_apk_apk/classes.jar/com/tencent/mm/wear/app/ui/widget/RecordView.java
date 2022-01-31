package com.tencent.mm.wear.app.ui.widget;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.graphics.PorterDuff.Mode;
import android.graphics.RectF;
import android.util.AttributeSet;
import com.tencent.mm.wear.a.b.a;

public class RecordView
  extends MMCustomSurfaceView
{
  private g ail;
  private b aim;
  private Bitmap ain;
  private Bitmap aio;
  private Paint aip;
  private Paint aiq;
  private boolean air;
  private float ais;
  private int ait;
  private int aiu = 0;
  private int centerX;
  private int centerY;
  private int height;
  private int status = 0;
  private int width;
  
  public RecordView(Context paramContext)
  {
    super(paramContext);
    nB();
  }
  
  public RecordView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    nB();
  }
  
  public RecordView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    nB();
  }
  
  private void b(Canvas paramCanvas)
  {
    this.ail.a(paramCanvas, this.status);
  }
  
  private void nB()
  {
    if (isFocusable()) {}
    for (this.ain = BitmapFactory.decodeResource(getResources(), 2130837603);; this.ain = BitmapFactory.decodeResource(getResources(), 2130837602))
    {
      this.aio = BitmapFactory.decodeResource(getResources(), 2130837507);
      this.aip = nE();
      this.aiq = nE();
      this.aiq.setStyle(Paint.Style.FILL);
      return;
    }
  }
  
  private static Paint nE()
  {
    Paint localPaint = new Paint();
    localPaint.setAntiAlias(true);
    localPaint.setStyle(Paint.Style.STROKE);
    localPaint.setStrokeWidth(2.0F);
    localPaint.setColor(-1);
    return localPaint;
  }
  
  protected final void a(Canvas paramCanvas)
  {
    if (!this.air)
    {
      this.air = true;
      this.width = getMeasuredWidth();
      this.height = getMeasuredHeight();
      this.centerX = (this.width / 2);
      this.centerY = (this.height / 2);
      this.ais = ((float)Math.pow(this.width * this.width + this.height * this.height, 0.5D));
      this.ail = new g(this.width, this.height);
    }
    paramCanvas.drawColor(0, PorterDuff.Mode.CLEAR);
    switch (this.status)
    {
    case -3: 
    case -2: 
    case -1: 
    case 0: 
    case 1: 
    case 6: 
    case 7: 
    default: 
      return;
    case 2: 
    case 3: 
      b(paramCanvas);
      return;
    case 5: 
      this.ail.a(paramCanvas, this.status);
      int i = this.centerX - this.aio.getWidth() / 2;
      int j = this.height - this.aio.getHeight() - 60;
      paramCanvas.drawArc(new RectF(i - 3, j - 3, this.aio.getWidth() + i + 3, this.aio.getHeight() + j + 3), -90.0F, this.aiu, true, this.aiq);
      this.aiu += this.ait;
      if (this.aiu > 370) {
        setStatus(6);
      }
      paramCanvas.drawBitmap(this.aio, i, j, this.aip);
      return;
    }
    if (isFocusable())
    {
      b(paramCanvas);
      return;
    }
    this.ail.a(paramCanvas, this.status);
  }
  
  public final void a(b paramb)
  {
    this.aim = paramb;
  }
  
  public final void cb(int paramInt)
  {
    if (this.ail != null) {
      this.ail.cd(paramInt);
    }
  }
  
  public final void cc(int paramInt)
  {
    this.ait = paramInt;
  }
  
  public final int getStatus()
  {
    return this.status;
  }
  
  public final void setStatus(int paramInt)
  {
    if (this.status != paramInt)
    {
      int i = this.status;
      this.status = paramInt;
      a.aiT.post(new f(this, this.status, i));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\res\raw\android_wear_micro_apk_apk\classes.jar
 * Qualified Name:     com.tencent.mm.wear.app.ui.widget.RecordView
 * JD-Core Version:    0.7.0.1
 */