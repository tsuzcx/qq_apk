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
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ap;
import java.util.ArrayList;

public class MMSightCircularProgressBar
  extends View
{
  int duration;
  private boolean gkP;
  boolean isStart;
  private Context mContext;
  private float offset;
  private Paint paint;
  private float strokeWidth;
  private int uRc;
  private int uRd;
  private int uRe;
  private RectF uRf;
  private Paint uRg;
  private Paint uRh;
  private int uRi;
  float uRj;
  int uRk;
  int uRl;
  c uRm;
  private a uRn;
  ArrayList<Float> uRo;
  private ArrayList<Float> uRp;
  private boolean uRq;
  private boolean uRr;
  boolean uRs;
  
  public MMSightCircularProgressBar(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(94519);
    this.uRc = Color.parseColor("#1AAD19");
    this.uRd = Color.parseColor("#FFFFFF");
    this.uRe = Color.parseColor("#FA5151");
    this.strokeWidth = 0.0F;
    this.offset = 0.0F;
    this.uRi = 153;
    this.uRj = 0.0F;
    this.uRk = 0;
    this.uRl = 0;
    this.duration = 0;
    this.isStart = false;
    this.uRo = new ArrayList();
    this.uRp = new ArrayList();
    this.uRq = false;
    this.uRr = false;
    this.uRs = false;
    this.gkP = false;
    this.mContext = paramContext;
    AppMethodBeat.o(94519);
  }
  
  public MMSightCircularProgressBar(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(94520);
    this.uRc = Color.parseColor("#1AAD19");
    this.uRd = Color.parseColor("#FFFFFF");
    this.uRe = Color.parseColor("#FA5151");
    this.strokeWidth = 0.0F;
    this.offset = 0.0F;
    this.uRi = 153;
    this.uRj = 0.0F;
    this.uRk = 0;
    this.uRl = 0;
    this.duration = 0;
    this.isStart = false;
    this.uRo = new ArrayList();
    this.uRp = new ArrayList();
    this.uRq = false;
    this.uRr = false;
    this.uRs = false;
    this.gkP = false;
    this.mContext = paramContext;
    AppMethodBeat.o(94520);
  }
  
  public int getDrawWidth()
  {
    AppMethodBeat.i(209937);
    int i = (int)this.uRf.width();
    AppMethodBeat.o(209937);
    return i;
  }
  
  public ArrayList<Float> getSubProgress()
  {
    return this.uRo;
  }
  
  protected void onDraw(Canvas paramCanvas)
  {
    AppMethodBeat.i(94526);
    paramCanvas.save();
    paramCanvas.translate(this.offset, this.offset);
    paramCanvas.rotate(180.0F, this.uRf.right / 2.0F, this.uRf.bottom / 2.0F);
    if (this.uRq)
    {
      int i = 0;
      float f = 0.0F;
      if (i < this.uRo.size())
      {
        if ((this.uRs) && (i == this.uRo.size() - 1)) {
          paramCanvas.drawArc(this.uRf, 90.0F + f / this.uRl * 360.0F, (((Float)this.uRo.get(i)).floatValue() - f) / this.uRl * 360.0F, false, this.uRh);
        }
        for (;;)
        {
          f = ((Float)this.uRo.get(i)).floatValue();
          paramCanvas.drawArc(this.uRf, 90.0F + (f - 0.85F) / this.uRl * 360.0F, 0.85F / this.uRl * 360.0F, false, this.uRg);
          i += 1;
          break;
          paramCanvas.drawArc(this.uRf, 90.0F + f / this.uRl * 360.0F, (((Float)this.uRo.get(i)).floatValue() - f) / this.uRl * 360.0F, false, this.paint);
        }
      }
      paramCanvas.drawArc(this.uRf, 90.0F + f / this.uRl * 360.0F, (this.uRj - f) / this.uRl * 360.0F, false, this.paint);
    }
    for (;;)
    {
      paramCanvas.restore();
      AppMethodBeat.o(94526);
      return;
      paramCanvas.drawArc(this.uRf, 90.0F, this.uRj / this.uRl * 360.0F, false, this.paint);
    }
  }
  
  protected void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    AppMethodBeat.i(209936);
    super.onLayout(paramBoolean, paramInt1, paramInt2, paramInt3, paramInt4);
    if (!this.gkP)
    {
      this.gkP = true;
      float f = getWidth();
      this.strokeWidth = this.mContext.getResources().getDimensionPixelSize(2131166581);
      this.offset = (this.strokeWidth / 2.0F);
      this.uRf = new RectF(this.offset, this.offset, f - this.offset, f - this.offset);
      this.paint = new Paint();
      this.paint.setStyle(Paint.Style.STROKE);
      this.paint.setStrokeWidth(this.strokeWidth);
      this.paint.setColor(this.uRc);
      this.paint.setAlpha(this.uRi);
      this.paint.setAntiAlias(true);
      this.uRg = new Paint();
      this.uRg.setStyle(Paint.Style.STROKE);
      this.uRg.setStrokeWidth(this.strokeWidth);
      this.uRg.setColor(this.uRd);
      this.uRg.setAlpha(this.uRi);
      this.uRg.setAntiAlias(true);
      this.uRh = new Paint();
      this.uRh.setStyle(Paint.Style.STROKE);
      this.uRh.setStrokeWidth(this.strokeWidth);
      this.uRh.setColor(this.uRe);
      this.uRh.setAntiAlias(true);
    }
    AppMethodBeat.o(209936);
  }
  
  public final void reset()
  {
    AppMethodBeat.i(209939);
    ac.i("MicroMsg.MMSightCircularProgressBar", "reset");
    this.uRn = null;
    this.uRk = 0;
    this.uRl = 100;
    this.duration = 0;
    this.isStart = false;
    this.uRo.clear();
    this.uRj = 0.0F;
    if (this.uRm != null)
    {
      this.uRm.cancel();
      this.uRm = null;
    }
    invalidate();
    AppMethodBeat.o(209939);
  }
  
  public void setCircularColor(int paramInt)
  {
    AppMethodBeat.i(94525);
    this.uRc = paramInt;
    this.uRi = 255;
    if ((this.paint != null) && (paramInt != 0)) {
      this.paint.setColor(paramInt);
    }
    AppMethodBeat.o(94525);
  }
  
  public void setDuration(int paramInt)
  {
    AppMethodBeat.i(94523);
    ac.i("MicroMsg.MMSightCircularProgressBar", "setDuration: %s", new Object[] { Integer.valueOf(paramInt) });
    this.duration = paramInt;
    AppMethodBeat.o(94523);
  }
  
  public void setEnableSubProgress(boolean paramBoolean)
  {
    AppMethodBeat.i(209938);
    ac.i("MicroMsg.MMSightCircularProgressBar", "setEnableSubProgress: %s", new Object[] { Boolean.valueOf(paramBoolean) });
    this.uRq = paramBoolean;
    AppMethodBeat.o(209938);
  }
  
  public void setInitProgress(int paramInt)
  {
    AppMethodBeat.i(94524);
    ac.i("MicroMsg.MMSightCircularProgressBar", "setInitProgress: %s, isStart: %s", new Object[] { Integer.valueOf(paramInt), Boolean.valueOf(this.isStart) });
    if (!this.isStart) {
      this.uRk = paramInt;
    }
    AppMethodBeat.o(94524);
  }
  
  public void setMaxProgress(int paramInt)
  {
    AppMethodBeat.i(94522);
    ac.i("MicroMsg.MMSightCircularProgressBar", "setMaxProgress: %s", new Object[] { Integer.valueOf(paramInt) });
    this.uRl = paramInt;
    AppMethodBeat.o(94522);
  }
  
  public void setProgressCallback(a parama)
  {
    this.uRn = parama;
  }
  
  public static abstract interface a
  {
    public abstract void S(ArrayList<Float> paramArrayList);
    
    public abstract void kw(boolean paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.mmsight.ui.MMSightCircularProgressBar
 * JD-Core Version:    0.7.0.1
 */