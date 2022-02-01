package com.tencent.mm.plugin.mmsight.ui;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.ar;
import java.util.ArrayList;

public class MMSightCircularProgressBar
  extends View
{
  int duration;
  private boolean gHg;
  boolean isStart;
  private Context mContext;
  private float offset;
  private Paint paint;
  private float strokeWidth;
  c wgA;
  private a wgB;
  ArrayList<Float> wgC;
  private ArrayList<Float> wgD;
  private boolean wgE;
  private boolean wgF;
  boolean wgG;
  private int wgq;
  private int wgr;
  private int wgs;
  private RectF wgt;
  private Paint wgu;
  private Paint wgv;
  private int wgw;
  float wgx;
  int wgy;
  int wgz;
  
  public MMSightCircularProgressBar(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(94519);
    this.wgq = Color.parseColor("#1AAD19");
    this.wgr = Color.parseColor("#FFFFFF");
    this.wgs = Color.parseColor("#FA5151");
    this.strokeWidth = 0.0F;
    this.offset = 0.0F;
    this.wgw = 153;
    this.wgx = 0.0F;
    this.wgy = 0;
    this.wgz = 0;
    this.duration = 0;
    this.isStart = false;
    this.wgC = new ArrayList();
    this.wgD = new ArrayList();
    this.wgE = false;
    this.wgF = false;
    this.wgG = false;
    this.gHg = false;
    this.mContext = paramContext;
    AppMethodBeat.o(94519);
  }
  
  public MMSightCircularProgressBar(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(94520);
    this.wgq = Color.parseColor("#1AAD19");
    this.wgr = Color.parseColor("#FFFFFF");
    this.wgs = Color.parseColor("#FA5151");
    this.strokeWidth = 0.0F;
    this.offset = 0.0F;
    this.wgw = 153;
    this.wgx = 0.0F;
    this.wgy = 0;
    this.wgz = 0;
    this.duration = 0;
    this.isStart = false;
    this.wgC = new ArrayList();
    this.wgD = new ArrayList();
    this.wgE = false;
    this.wgF = false;
    this.wgG = false;
    this.gHg = false;
    this.mContext = paramContext;
    AppMethodBeat.o(94520);
  }
  
  public int getDrawWidth()
  {
    AppMethodBeat.i(189034);
    int i = (int)this.wgt.width();
    AppMethodBeat.o(189034);
    return i;
  }
  
  public ArrayList<Float> getSubProgress()
  {
    return this.wgC;
  }
  
  protected void onDraw(Canvas paramCanvas)
  {
    AppMethodBeat.i(94526);
    paramCanvas.save();
    paramCanvas.translate(this.offset, this.offset);
    paramCanvas.rotate(180.0F, this.wgt.right / 2.0F, this.wgt.bottom / 2.0F);
    if (this.wgE)
    {
      int i = 0;
      float f = 0.0F;
      if (i < this.wgC.size())
      {
        if ((this.wgG) && (i == this.wgC.size() - 1)) {
          paramCanvas.drawArc(this.wgt, 90.0F + f / this.wgz * 360.0F, (((Float)this.wgC.get(i)).floatValue() - f) / this.wgz * 360.0F, false, this.wgv);
        }
        for (;;)
        {
          f = ((Float)this.wgC.get(i)).floatValue();
          paramCanvas.drawArc(this.wgt, 90.0F + (f - 0.85F) / this.wgz * 360.0F, 0.85F / this.wgz * 360.0F, false, this.wgu);
          i += 1;
          break;
          paramCanvas.drawArc(this.wgt, 90.0F + f / this.wgz * 360.0F, (((Float)this.wgC.get(i)).floatValue() - f) / this.wgz * 360.0F, false, this.paint);
        }
      }
      paramCanvas.drawArc(this.wgt, 90.0F + f / this.wgz * 360.0F, (this.wgx - f) / this.wgz * 360.0F, false, this.paint);
    }
    for (;;)
    {
      paramCanvas.restore();
      AppMethodBeat.o(94526);
      return;
      paramCanvas.drawArc(this.wgt, 90.0F, this.wgx / this.wgz * 360.0F, false, this.paint);
    }
  }
  
  protected void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    AppMethodBeat.i(189033);
    super.onLayout(paramBoolean, paramInt1, paramInt2, paramInt3, paramInt4);
    if (!this.gHg)
    {
      this.gHg = true;
      float f = getWidth();
      this.strokeWidth = this.mContext.getResources().getDimensionPixelSize(2131166581);
      this.offset = (this.strokeWidth / 2.0F);
      this.wgt = new RectF(this.offset, this.offset, f - this.offset, f - this.offset);
      this.paint = new Paint();
      this.paint.setStyle(Paint.Style.STROKE);
      this.paint.setStrokeWidth(this.strokeWidth);
      this.paint.setColor(this.wgq);
      this.paint.setAlpha(this.wgw);
      this.paint.setAntiAlias(true);
      this.wgu = new Paint();
      this.wgu.setStyle(Paint.Style.STROKE);
      this.wgu.setStrokeWidth(this.strokeWidth);
      this.wgu.setColor(this.wgr);
      this.wgu.setAlpha(this.wgw);
      this.wgu.setAntiAlias(true);
      this.wgv = new Paint();
      this.wgv.setStyle(Paint.Style.STROKE);
      this.wgv.setStrokeWidth(this.strokeWidth);
      this.wgv.setColor(this.wgs);
      this.wgv.setAntiAlias(true);
    }
    AppMethodBeat.o(189033);
  }
  
  public final void reset()
  {
    AppMethodBeat.i(189036);
    ae.i("MicroMsg.MMSightCircularProgressBar", "reset");
    this.wgB = null;
    this.wgy = 0;
    this.wgz = 100;
    this.duration = 0;
    this.isStart = false;
    this.wgC.clear();
    this.wgx = 0.0F;
    if (this.wgA != null)
    {
      this.wgA.cancel();
      this.wgA = null;
    }
    invalidate();
    AppMethodBeat.o(189036);
  }
  
  public void setCircularColor(int paramInt)
  {
    AppMethodBeat.i(94525);
    this.wgq = paramInt;
    this.wgw = 255;
    if ((this.paint != null) && (paramInt != 0)) {
      this.paint.setColor(paramInt);
    }
    AppMethodBeat.o(94525);
  }
  
  public void setDuration(int paramInt)
  {
    AppMethodBeat.i(94523);
    ae.i("MicroMsg.MMSightCircularProgressBar", "setDuration: %s", new Object[] { Integer.valueOf(paramInt) });
    this.duration = paramInt;
    AppMethodBeat.o(94523);
  }
  
  public void setEnableSubProgress(boolean paramBoolean)
  {
    AppMethodBeat.i(189035);
    ae.i("MicroMsg.MMSightCircularProgressBar", "setEnableSubProgress: %s", new Object[] { Boolean.valueOf(paramBoolean) });
    this.wgE = paramBoolean;
    AppMethodBeat.o(189035);
  }
  
  public void setInitProgress(int paramInt)
  {
    AppMethodBeat.i(94524);
    ae.i("MicroMsg.MMSightCircularProgressBar", "setInitProgress: %s, isStart: %s", new Object[] { Integer.valueOf(paramInt), Boolean.valueOf(this.isStart) });
    if (!this.isStart) {
      this.wgy = paramInt;
    }
    AppMethodBeat.o(94524);
  }
  
  public void setMaxProgress(int paramInt)
  {
    AppMethodBeat.i(94522);
    ae.i("MicroMsg.MMSightCircularProgressBar", "setMaxProgress: %s", new Object[] { Integer.valueOf(paramInt) });
    this.wgz = paramInt;
    AppMethodBeat.o(94522);
  }
  
  public void setProgressCallback(a parama)
  {
    this.wgB = parama;
  }
  
  public static abstract interface a
  {
    public abstract void S(ArrayList<Float> paramArrayList);
    
    public abstract void kI(boolean paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.mmsight.ui.MMSightCircularProgressBar
 * JD-Core Version:    0.7.0.1
 */