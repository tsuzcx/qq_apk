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
import com.tencent.mm.plugin.w.a.c;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import java.util.ArrayList;

public class MMSightCircularProgressBar
  extends View
{
  private int FfL;
  private int FfM;
  private int FfN;
  private RectF FfO;
  private Paint FfP;
  private Paint FfQ;
  private int FfR;
  float FfS;
  int FfT;
  int FfU;
  c FfV;
  private a FfW;
  ArrayList<Float> FfX;
  private ArrayList<Float> FfY;
  private boolean FfZ;
  private boolean Fga;
  boolean Fgb;
  int duration;
  boolean isStart;
  private boolean kfR;
  private Context mContext;
  private float offset;
  private Paint paint;
  private float strokeWidth;
  
  public MMSightCircularProgressBar(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(94519);
    this.FfL = Color.parseColor("#1AAD19");
    this.FfM = Color.parseColor("#FFFFFF");
    this.FfN = Color.parseColor("#FA5151");
    this.strokeWidth = 0.0F;
    this.offset = 0.0F;
    this.FfR = 153;
    this.FfS = 0.0F;
    this.FfT = 0;
    this.FfU = 0;
    this.duration = 0;
    this.isStart = false;
    this.FfX = new ArrayList();
    this.FfY = new ArrayList();
    this.FfZ = false;
    this.Fga = false;
    this.Fgb = false;
    this.kfR = false;
    this.mContext = paramContext;
    AppMethodBeat.o(94519);
  }
  
  public MMSightCircularProgressBar(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(94520);
    this.FfL = Color.parseColor("#1AAD19");
    this.FfM = Color.parseColor("#FFFFFF");
    this.FfN = Color.parseColor("#FA5151");
    this.strokeWidth = 0.0F;
    this.offset = 0.0F;
    this.FfR = 153;
    this.FfS = 0.0F;
    this.FfT = 0;
    this.FfU = 0;
    this.duration = 0;
    this.isStart = false;
    this.FfX = new ArrayList();
    this.FfY = new ArrayList();
    this.FfZ = false;
    this.Fga = false;
    this.Fgb = false;
    this.kfR = false;
    this.mContext = paramContext;
    AppMethodBeat.o(94520);
  }
  
  public int getDrawWidth()
  {
    AppMethodBeat.i(248923);
    int i = (int)this.FfO.width();
    AppMethodBeat.o(248923);
    return i;
  }
  
  public ArrayList<Float> getSubProgress()
  {
    return this.FfX;
  }
  
  protected void onDraw(Canvas paramCanvas)
  {
    AppMethodBeat.i(94526);
    paramCanvas.save();
    paramCanvas.translate(this.offset, this.offset);
    paramCanvas.rotate(180.0F, this.FfO.right / 2.0F, this.FfO.bottom / 2.0F);
    if (this.FfZ)
    {
      int i = 0;
      float f = 0.0F;
      if (i < this.FfX.size())
      {
        if ((this.Fgb) && (i == this.FfX.size() - 1)) {
          paramCanvas.drawArc(this.FfO, 90.0F + f / this.FfU * 360.0F, (((Float)this.FfX.get(i)).floatValue() - f) / this.FfU * 360.0F, false, this.FfQ);
        }
        for (;;)
        {
          f = ((Float)this.FfX.get(i)).floatValue();
          paramCanvas.drawArc(this.FfO, 90.0F + (f - 0.85F) / this.FfU * 360.0F, 0.85F / this.FfU * 360.0F, false, this.FfP);
          i += 1;
          break;
          paramCanvas.drawArc(this.FfO, 90.0F + f / this.FfU * 360.0F, (((Float)this.FfX.get(i)).floatValue() - f) / this.FfU * 360.0F, false, this.paint);
        }
      }
      if (this.FfU > 0) {
        paramCanvas.drawArc(this.FfO, 90.0F + f / this.FfU * 360.0F, (this.FfS - f) / this.FfU * 360.0F, false, this.paint);
      }
    }
    for (;;)
    {
      paramCanvas.restore();
      AppMethodBeat.o(94526);
      return;
      paramCanvas.drawArc(this.FfO, 90.0F, this.FfS / this.FfU * 360.0F, false, this.paint);
    }
  }
  
  protected void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    AppMethodBeat.i(248921);
    super.onLayout(paramBoolean, paramInt1, paramInt2, paramInt3, paramInt4);
    if (!this.kfR)
    {
      this.kfR = true;
      float f = getWidth();
      this.strokeWidth = this.mContext.getResources().getDimensionPixelSize(a.c.mmsight_recorder_progress_circular_thickness);
      this.offset = (this.strokeWidth / 2.0F);
      this.FfO = new RectF(this.offset, this.offset, f - this.offset, f - this.offset);
      this.paint = new Paint();
      this.paint.setStyle(Paint.Style.STROKE);
      this.paint.setStrokeWidth(this.strokeWidth);
      this.paint.setColor(this.FfL);
      this.paint.setAlpha(this.FfR);
      this.paint.setAntiAlias(true);
      this.FfP = new Paint();
      this.FfP.setStyle(Paint.Style.STROKE);
      this.FfP.setStrokeWidth(this.strokeWidth);
      this.FfP.setColor(this.FfM);
      this.FfP.setAlpha(this.FfR);
      this.FfP.setAntiAlias(true);
      this.FfQ = new Paint();
      this.FfQ.setStyle(Paint.Style.STROKE);
      this.FfQ.setStrokeWidth(this.strokeWidth);
      this.FfQ.setColor(this.FfN);
      this.FfQ.setAntiAlias(true);
    }
    AppMethodBeat.o(248921);
  }
  
  public final void reset()
  {
    AppMethodBeat.i(248926);
    Log.i("MicroMsg.MMSightCircularProgressBar", "reset");
    this.FfW = null;
    this.FfT = 0;
    this.FfU = 100;
    this.duration = 0;
    this.isStart = false;
    this.FfX.clear();
    this.FfS = 0.0F;
    if (this.FfV != null)
    {
      this.FfV.cancel();
      this.FfV = null;
    }
    invalidate();
    AppMethodBeat.o(248926);
  }
  
  public void setCircularColor(int paramInt)
  {
    AppMethodBeat.i(94525);
    this.FfL = paramInt;
    this.FfR = 255;
    if ((this.paint != null) && (paramInt != 0)) {
      this.paint.setColor(paramInt);
    }
    AppMethodBeat.o(94525);
  }
  
  public void setDuration(int paramInt)
  {
    AppMethodBeat.i(94523);
    Log.i("MicroMsg.MMSightCircularProgressBar", "setDuration: %s", new Object[] { Integer.valueOf(paramInt) });
    this.duration = paramInt;
    AppMethodBeat.o(94523);
  }
  
  public void setEnableSubProgress(boolean paramBoolean)
  {
    AppMethodBeat.i(248924);
    Log.i("MicroMsg.MMSightCircularProgressBar", "setEnableSubProgress: %s", new Object[] { Boolean.valueOf(paramBoolean) });
    this.FfZ = paramBoolean;
    AppMethodBeat.o(248924);
  }
  
  public void setInitProgress(int paramInt)
  {
    AppMethodBeat.i(94524);
    Log.i("MicroMsg.MMSightCircularProgressBar", "setInitProgress: %s, isStart: %s", new Object[] { Integer.valueOf(paramInt), Boolean.valueOf(this.isStart) });
    if (!this.isStart) {
      this.FfT = paramInt;
    }
    AppMethodBeat.o(94524);
  }
  
  public void setMaxProgress(int paramInt)
  {
    AppMethodBeat.i(94522);
    Log.i("MicroMsg.MMSightCircularProgressBar", "setMaxProgress: %s", new Object[] { Integer.valueOf(paramInt) });
    this.FfU = paramInt;
    AppMethodBeat.o(94522);
  }
  
  public void setProgressCallback(a parama)
  {
    this.FfW = parama;
  }
  
  public static abstract interface a
  {
    public abstract void Z(ArrayList<Float> paramArrayList);
    
    public abstract void mV(boolean paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.mmsight.ui.MMSightCircularProgressBar
 * JD-Core Version:    0.7.0.1
 */