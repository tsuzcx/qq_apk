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
  private g alN;
  private b alO;
  private Bitmap alP;
  private Bitmap alQ;
  private Paint alR;
  private Paint alS;
  private boolean alT;
  private float alU;
  private int alV;
  private int alW = 0;
  private int centerX;
  private int centerY;
  private int height;
  private int status = 0;
  private int width;
  
  public RecordView(Context paramContext)
  {
    super(paramContext);
    op();
  }
  
  public RecordView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    op();
  }
  
  public RecordView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    op();
  }
  
  private void b(Canvas paramCanvas)
  {
    this.alN.a(paramCanvas, this.status);
  }
  
  private void op()
  {
    if (isFocusable()) {}
    for (this.alP = BitmapFactory.decodeResource(getResources(), 2130837603);; this.alP = BitmapFactory.decodeResource(getResources(), 2130837602))
    {
      this.alQ = BitmapFactory.decodeResource(getResources(), 2130837507);
      this.alR = os();
      this.alS = os();
      this.alS.setStyle(Paint.Style.FILL);
      return;
    }
  }
  
  private static Paint os()
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
    if (!this.alT)
    {
      this.alT = true;
      this.width = getMeasuredWidth();
      this.height = getMeasuredHeight();
      this.centerX = (this.width / 2);
      this.centerY = (this.height / 2);
      this.alU = ((float)Math.pow(this.width * this.width + this.height * this.height, 0.5D));
      this.alN = new g(this.width, this.height);
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
      this.alN.a(paramCanvas, this.status);
      int i = this.centerX - this.alQ.getWidth() / 2;
      int j = this.height - this.alQ.getHeight() - 60;
      paramCanvas.drawArc(new RectF(i - 3, j - 3, this.alQ.getWidth() + i + 3, this.alQ.getHeight() + j + 3), -90.0F, this.alW, true, this.alS);
      this.alW += this.alV;
      if (this.alW > 370) {
        setStatus(6);
      }
      paramCanvas.drawBitmap(this.alQ, i, j, this.alR);
      return;
    }
    if (isFocusable())
    {
      b(paramCanvas);
      return;
    }
    this.alN.a(paramCanvas, this.status);
  }
  
  public final void a(b paramb)
  {
    this.alO = paramb;
  }
  
  public final void cx(int paramInt)
  {
    if (this.alN != null) {
      this.alN.cz(paramInt);
    }
  }
  
  public final void cy(int paramInt)
  {
    this.alV = paramInt;
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
      a.amv.post(new f(this, this.status, i));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\res\raw\android_wear_micro_apk_apk\classes.jar
 * Qualified Name:     com.tencent.mm.wear.app.ui.widget.RecordView
 * JD-Core Version:    0.7.0.1
 */