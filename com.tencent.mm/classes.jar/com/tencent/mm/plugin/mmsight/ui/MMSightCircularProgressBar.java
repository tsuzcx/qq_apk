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
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aq;
import java.util.ArrayList;

public class MMSightCircularProgressBar
  extends View
{
  private int LmL;
  private int LmM;
  private Paint LmN;
  private Paint LmO;
  private int LmP;
  ArrayList<Float> LmQ;
  private ArrayList<Float> LmR;
  private boolean LmS;
  private boolean LmT;
  boolean LmU;
  int duration;
  private boolean ggj;
  boolean isStart;
  private Context mContext;
  private float offset;
  private Paint paint;
  private float strokeWidth;
  float tIG;
  int tIH;
  int tII;
  private RectF tIJ;
  c tIK;
  private a tIL;
  private int tIM;
  
  public MMSightCircularProgressBar(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(94519);
    this.tIM = Color.parseColor("#1AAD19");
    this.LmL = Color.parseColor("#FFFFFF");
    this.LmM = Color.parseColor("#FA5151");
    this.strokeWidth = 0.0F;
    this.offset = 0.0F;
    this.LmP = 153;
    this.tIG = 0.0F;
    this.tIH = 0;
    this.tII = 0;
    this.duration = 0;
    this.isStart = false;
    this.LmQ = new ArrayList();
    this.LmR = new ArrayList();
    this.LmS = false;
    this.LmT = false;
    this.LmU = false;
    this.ggj = false;
    this.mContext = paramContext;
    AppMethodBeat.o(94519);
  }
  
  public MMSightCircularProgressBar(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(94520);
    this.tIM = Color.parseColor("#1AAD19");
    this.LmL = Color.parseColor("#FFFFFF");
    this.LmM = Color.parseColor("#FA5151");
    this.strokeWidth = 0.0F;
    this.offset = 0.0F;
    this.LmP = 153;
    this.tIG = 0.0F;
    this.tIH = 0;
    this.tII = 0;
    this.duration = 0;
    this.isStart = false;
    this.LmQ = new ArrayList();
    this.LmR = new ArrayList();
    this.LmS = false;
    this.LmT = false;
    this.LmU = false;
    this.ggj = false;
    this.mContext = paramContext;
    AppMethodBeat.o(94520);
  }
  
  public int getDrawWidth()
  {
    AppMethodBeat.i(205854);
    int i = (int)this.tIJ.width();
    AppMethodBeat.o(205854);
    return i;
  }
  
  public ArrayList<Float> getSubProgress()
  {
    return this.LmQ;
  }
  
  protected void onDraw(Canvas paramCanvas)
  {
    AppMethodBeat.i(94526);
    paramCanvas.save();
    paramCanvas.translate(this.offset, this.offset);
    paramCanvas.rotate(180.0F, this.tIJ.right / 2.0F, this.tIJ.bottom / 2.0F);
    if (this.LmS)
    {
      int i = 0;
      float f = 0.0F;
      if (i < this.LmQ.size())
      {
        if ((this.LmU) && (i == this.LmQ.size() - 1)) {
          paramCanvas.drawArc(this.tIJ, 90.0F + f / this.tII * 360.0F, (((Float)this.LmQ.get(i)).floatValue() - f) / this.tII * 360.0F, false, this.LmO);
        }
        for (;;)
        {
          f = ((Float)this.LmQ.get(i)).floatValue();
          paramCanvas.drawArc(this.tIJ, 90.0F + (f - 0.85F) / this.tII * 360.0F, 0.85F / this.tII * 360.0F, false, this.LmN);
          i += 1;
          break;
          paramCanvas.drawArc(this.tIJ, 90.0F + f / this.tII * 360.0F, (((Float)this.LmQ.get(i)).floatValue() - f) / this.tII * 360.0F, false, this.paint);
        }
      }
      paramCanvas.drawArc(this.tIJ, 90.0F + f / this.tII * 360.0F, (this.tIG - f) / this.tII * 360.0F, false, this.paint);
    }
    for (;;)
    {
      paramCanvas.restore();
      AppMethodBeat.o(94526);
      return;
      paramCanvas.drawArc(this.tIJ, 90.0F, this.tIG / this.tII * 360.0F, false, this.paint);
    }
  }
  
  protected void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    AppMethodBeat.i(205853);
    super.onLayout(paramBoolean, paramInt1, paramInt2, paramInt3, paramInt4);
    if (!this.ggj)
    {
      this.ggj = true;
      float f = getWidth();
      this.strokeWidth = this.mContext.getResources().getDimensionPixelSize(2131166581);
      this.offset = (this.strokeWidth / 2.0F);
      this.tIJ = new RectF(this.offset, this.offset, f - this.offset, f - this.offset);
      this.paint = new Paint();
      this.paint.setStyle(Paint.Style.STROKE);
      this.paint.setStrokeWidth(this.strokeWidth);
      this.paint.setColor(this.tIM);
      this.paint.setAlpha(this.LmP);
      this.paint.setAntiAlias(true);
      this.LmN = new Paint();
      this.LmN.setStyle(Paint.Style.STROKE);
      this.LmN.setStrokeWidth(this.strokeWidth);
      this.LmN.setColor(this.LmL);
      this.LmN.setAlpha(this.LmP);
      this.LmN.setAntiAlias(true);
      this.LmO = new Paint();
      this.LmO.setStyle(Paint.Style.STROKE);
      this.LmO.setStrokeWidth(this.strokeWidth);
      this.LmO.setColor(this.LmM);
      this.LmO.setAntiAlias(true);
    }
    AppMethodBeat.o(205853);
  }
  
  public final void reset()
  {
    AppMethodBeat.i(205856);
    ad.i("MicroMsg.MMSightCircularProgressBar", "reset");
    this.tIL = null;
    this.tIH = 0;
    this.tII = 100;
    this.duration = 0;
    this.isStart = false;
    this.LmQ.clear();
    this.tIG = 0.0F;
    if (this.tIK != null)
    {
      this.tIK.cancel();
      this.tIK = null;
    }
    invalidate();
    AppMethodBeat.o(205856);
  }
  
  public void setCircularColor(int paramInt)
  {
    AppMethodBeat.i(94525);
    this.tIM = paramInt;
    this.LmP = 255;
    if ((this.paint != null) && (paramInt != 0)) {
      this.paint.setColor(paramInt);
    }
    AppMethodBeat.o(94525);
  }
  
  public void setDuration(int paramInt)
  {
    AppMethodBeat.i(94523);
    ad.i("MicroMsg.MMSightCircularProgressBar", "setDuration: %s", new Object[] { Integer.valueOf(paramInt) });
    this.duration = paramInt;
    AppMethodBeat.o(94523);
  }
  
  public void setEnableSubProgress(boolean paramBoolean)
  {
    AppMethodBeat.i(205855);
    ad.i("MicroMsg.MMSightCircularProgressBar", "setEnableSubProgress: %s", new Object[] { Boolean.valueOf(paramBoolean) });
    this.LmS = paramBoolean;
    AppMethodBeat.o(205855);
  }
  
  public void setInitProgress(int paramInt)
  {
    AppMethodBeat.i(94524);
    ad.i("MicroMsg.MMSightCircularProgressBar", "setInitProgress: %s, isStart: %s", new Object[] { Integer.valueOf(paramInt), Boolean.valueOf(this.isStart) });
    if (!this.isStart) {
      this.tIH = paramInt;
    }
    AppMethodBeat.o(94524);
  }
  
  public void setMaxProgress(int paramInt)
  {
    AppMethodBeat.i(94522);
    ad.i("MicroMsg.MMSightCircularProgressBar", "setMaxProgress: %s", new Object[] { Integer.valueOf(paramInt) });
    this.tII = paramInt;
    AppMethodBeat.o(94522);
  }
  
  public void setProgressCallback(a parama)
  {
    this.tIL = parama;
  }
  
  public static abstract interface a
  {
    public abstract void aV(ArrayList<Float> paramArrayList);
    
    public abstract void yw(boolean paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.mmsight.ui.MMSightCircularProgressBar
 * JD-Core Version:    0.7.0.1
 */