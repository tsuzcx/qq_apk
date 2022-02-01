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
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import java.util.ArrayList;

public class MMSightCircularProgressBar
  extends View
{
  int duration;
  private boolean htU;
  boolean isStart;
  private Context mContext;
  private float offset;
  private Paint paint;
  private float strokeWidth;
  private int zAQ;
  private int zAR;
  private int zAS;
  private RectF zAT;
  private Paint zAU;
  private Paint zAV;
  private int zAW;
  float zAX;
  int zAY;
  int zAZ;
  c zBa;
  private a zBb;
  ArrayList<Float> zBc;
  private ArrayList<Float> zBd;
  private boolean zBe;
  private boolean zBf;
  boolean zBg;
  
  public MMSightCircularProgressBar(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(94519);
    this.zAQ = Color.parseColor("#1AAD19");
    this.zAR = Color.parseColor("#FFFFFF");
    this.zAS = Color.parseColor("#FA5151");
    this.strokeWidth = 0.0F;
    this.offset = 0.0F;
    this.zAW = 153;
    this.zAX = 0.0F;
    this.zAY = 0;
    this.zAZ = 0;
    this.duration = 0;
    this.isStart = false;
    this.zBc = new ArrayList();
    this.zBd = new ArrayList();
    this.zBe = false;
    this.zBf = false;
    this.zBg = false;
    this.htU = false;
    this.mContext = paramContext;
    AppMethodBeat.o(94519);
  }
  
  public MMSightCircularProgressBar(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(94520);
    this.zAQ = Color.parseColor("#1AAD19");
    this.zAR = Color.parseColor("#FFFFFF");
    this.zAS = Color.parseColor("#FA5151");
    this.strokeWidth = 0.0F;
    this.offset = 0.0F;
    this.zAW = 153;
    this.zAX = 0.0F;
    this.zAY = 0;
    this.zAZ = 0;
    this.duration = 0;
    this.isStart = false;
    this.zBc = new ArrayList();
    this.zBd = new ArrayList();
    this.zBe = false;
    this.zBf = false;
    this.zBg = false;
    this.htU = false;
    this.mContext = paramContext;
    AppMethodBeat.o(94520);
  }
  
  public int getDrawWidth()
  {
    AppMethodBeat.i(187079);
    int i = (int)this.zAT.width();
    AppMethodBeat.o(187079);
    return i;
  }
  
  public ArrayList<Float> getSubProgress()
  {
    return this.zBc;
  }
  
  protected void onDraw(Canvas paramCanvas)
  {
    AppMethodBeat.i(94526);
    paramCanvas.save();
    paramCanvas.translate(this.offset, this.offset);
    paramCanvas.rotate(180.0F, this.zAT.right / 2.0F, this.zAT.bottom / 2.0F);
    if (this.zBe)
    {
      int i = 0;
      float f = 0.0F;
      if (i < this.zBc.size())
      {
        if ((this.zBg) && (i == this.zBc.size() - 1)) {
          paramCanvas.drawArc(this.zAT, 90.0F + f / this.zAZ * 360.0F, (((Float)this.zBc.get(i)).floatValue() - f) / this.zAZ * 360.0F, false, this.zAV);
        }
        for (;;)
        {
          f = ((Float)this.zBc.get(i)).floatValue();
          paramCanvas.drawArc(this.zAT, 90.0F + (f - 0.85F) / this.zAZ * 360.0F, 0.85F / this.zAZ * 360.0F, false, this.zAU);
          i += 1;
          break;
          paramCanvas.drawArc(this.zAT, 90.0F + f / this.zAZ * 360.0F, (((Float)this.zBc.get(i)).floatValue() - f) / this.zAZ * 360.0F, false, this.paint);
        }
      }
      if (this.zAZ > 0) {
        paramCanvas.drawArc(this.zAT, 90.0F + f / this.zAZ * 360.0F, (this.zAX - f) / this.zAZ * 360.0F, false, this.paint);
      }
    }
    for (;;)
    {
      paramCanvas.restore();
      AppMethodBeat.o(94526);
      return;
      paramCanvas.drawArc(this.zAT, 90.0F, this.zAX / this.zAZ * 360.0F, false, this.paint);
    }
  }
  
  protected void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    AppMethodBeat.i(187078);
    super.onLayout(paramBoolean, paramInt1, paramInt2, paramInt3, paramInt4);
    if (!this.htU)
    {
      this.htU = true;
      float f = getWidth();
      this.strokeWidth = this.mContext.getResources().getDimensionPixelSize(2131166697);
      this.offset = (this.strokeWidth / 2.0F);
      this.zAT = new RectF(this.offset, this.offset, f - this.offset, f - this.offset);
      this.paint = new Paint();
      this.paint.setStyle(Paint.Style.STROKE);
      this.paint.setStrokeWidth(this.strokeWidth);
      this.paint.setColor(this.zAQ);
      this.paint.setAlpha(this.zAW);
      this.paint.setAntiAlias(true);
      this.zAU = new Paint();
      this.zAU.setStyle(Paint.Style.STROKE);
      this.zAU.setStrokeWidth(this.strokeWidth);
      this.zAU.setColor(this.zAR);
      this.zAU.setAlpha(this.zAW);
      this.zAU.setAntiAlias(true);
      this.zAV = new Paint();
      this.zAV.setStyle(Paint.Style.STROKE);
      this.zAV.setStrokeWidth(this.strokeWidth);
      this.zAV.setColor(this.zAS);
      this.zAV.setAntiAlias(true);
    }
    AppMethodBeat.o(187078);
  }
  
  public final void reset()
  {
    AppMethodBeat.i(187081);
    Log.i("MicroMsg.MMSightCircularProgressBar", "reset");
    this.zBb = null;
    this.zAY = 0;
    this.zAZ = 100;
    this.duration = 0;
    this.isStart = false;
    this.zBc.clear();
    this.zAX = 0.0F;
    if (this.zBa != null)
    {
      this.zBa.cancel();
      this.zBa = null;
    }
    invalidate();
    AppMethodBeat.o(187081);
  }
  
  public void setCircularColor(int paramInt)
  {
    AppMethodBeat.i(94525);
    this.zAQ = paramInt;
    this.zAW = 255;
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
    AppMethodBeat.i(187080);
    Log.i("MicroMsg.MMSightCircularProgressBar", "setEnableSubProgress: %s", new Object[] { Boolean.valueOf(paramBoolean) });
    this.zBe = paramBoolean;
    AppMethodBeat.o(187080);
  }
  
  public void setInitProgress(int paramInt)
  {
    AppMethodBeat.i(94524);
    Log.i("MicroMsg.MMSightCircularProgressBar", "setInitProgress: %s, isStart: %s", new Object[] { Integer.valueOf(paramInt), Boolean.valueOf(this.isStart) });
    if (!this.isStart) {
      this.zAY = paramInt;
    }
    AppMethodBeat.o(94524);
  }
  
  public void setMaxProgress(int paramInt)
  {
    AppMethodBeat.i(94522);
    Log.i("MicroMsg.MMSightCircularProgressBar", "setMaxProgress: %s", new Object[] { Integer.valueOf(paramInt) });
    this.zAZ = paramInt;
    AppMethodBeat.o(94522);
  }
  
  public void setProgressCallback(a parama)
  {
    this.zBb = parama;
  }
  
  public static abstract interface a
  {
    public abstract void Z(ArrayList<Float> paramArrayList);
    
    public abstract void lK(boolean paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.mmsight.ui.MMSightCircularProgressBar
 * JD-Core Version:    0.7.0.1
 */