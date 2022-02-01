package com.tencent.mm.plugin.recordvideo.ui.editor;

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
import java.util.ArrayList;

public class MMEditorCircularProgressBar
  extends View
{
  private int duration;
  private boolean gHg;
  private boolean isStart;
  private float kqK;
  private Context mContext;
  private float offset;
  private Paint paint;
  private float strokeWidth;
  private ArrayList<Float> wgC;
  private ArrayList<Float> wgD;
  private boolean wgE;
  private boolean wgF;
  private boolean wgG;
  private int wgq;
  private int wgr;
  private int wgs;
  private RectF wgt;
  private Paint wgu;
  private Paint wgv;
  private int wgw;
  private float wgx;
  private int wgy;
  private a ycD;
  
  public MMEditorCircularProgressBar(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(206499);
    this.wgq = Color.parseColor("#1AAD19");
    this.wgr = Color.parseColor("#FFFFFF");
    this.wgs = Color.parseColor("#FA5151");
    this.strokeWidth = 0.0F;
    this.offset = 0.0F;
    this.wgw = 153;
    this.wgx = 0.0F;
    this.wgy = 0;
    this.kqK = 0.0F;
    this.duration = 0;
    this.isStart = false;
    this.wgC = new ArrayList();
    this.wgD = new ArrayList();
    this.wgE = false;
    this.wgF = false;
    this.wgG = false;
    this.gHg = false;
    this.mContext = paramContext;
    AppMethodBeat.o(206499);
  }
  
  public MMEditorCircularProgressBar(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(206500);
    this.wgq = Color.parseColor("#1AAD19");
    this.wgr = Color.parseColor("#FFFFFF");
    this.wgs = Color.parseColor("#FA5151");
    this.strokeWidth = 0.0F;
    this.offset = 0.0F;
    this.wgw = 153;
    this.wgx = 0.0F;
    this.wgy = 0;
    this.kqK = 0.0F;
    this.duration = 0;
    this.isStart = false;
    this.wgC = new ArrayList();
    this.wgD = new ArrayList();
    this.wgE = false;
    this.wgF = false;
    this.wgG = false;
    this.gHg = false;
    this.mContext = paramContext;
    AppMethodBeat.o(206500);
  }
  
  public int getDrawWidth()
  {
    AppMethodBeat.i(206502);
    int i = (int)this.wgt.width();
    AppMethodBeat.o(206502);
    return i;
  }
  
  public ArrayList<Float> getSubProgress()
  {
    return this.wgC;
  }
  
  protected void onDraw(Canvas paramCanvas)
  {
    AppMethodBeat.i(206509);
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
          paramCanvas.drawArc(this.wgt, 90.0F + f / this.kqK * 360.0F, (((Float)this.wgC.get(i)).floatValue() - f) / this.kqK * 360.0F, false, this.wgv);
        }
        for (;;)
        {
          f = ((Float)this.wgC.get(i)).floatValue();
          paramCanvas.drawArc(this.wgt, 90.0F + (f - 0.85F) / this.kqK * 360.0F, 0.85F / this.kqK * 360.0F, false, this.wgu);
          i += 1;
          break;
          paramCanvas.drawArc(this.wgt, 90.0F + f / this.kqK * 360.0F, (((Float)this.wgC.get(i)).floatValue() - f) / this.kqK * 360.0F, false, this.paint);
        }
      }
      paramCanvas.drawArc(this.wgt, 90.0F + f / this.kqK * 360.0F, (this.wgx - f) / this.kqK * 360.0F, false, this.paint);
    }
    for (;;)
    {
      paramCanvas.restore();
      AppMethodBeat.o(206509);
      return;
      paramCanvas.drawArc(this.wgt, 90.0F, this.wgx / this.kqK * 360.0F, false, this.paint);
    }
  }
  
  protected void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    AppMethodBeat.i(206501);
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
    AppMethodBeat.o(206501);
  }
  
  public void setCircularColor(int paramInt)
  {
    AppMethodBeat.i(206508);
    this.wgq = paramInt;
    this.wgw = 255;
    if ((this.paint != null) && (paramInt != 0)) {
      this.paint.setColor(paramInt);
    }
    AppMethodBeat.o(206508);
  }
  
  public void setCurrentProgress(float paramFloat)
  {
    AppMethodBeat.i(206507);
    this.wgx = paramFloat;
    invalidate();
    AppMethodBeat.o(206507);
  }
  
  public void setDuration(int paramInt)
  {
    AppMethodBeat.i(206505);
    ae.i("MicroMsg.MMSightCircularProgressBar", "setDuration: %s", new Object[] { Integer.valueOf(paramInt) });
    this.duration = paramInt;
    AppMethodBeat.o(206505);
  }
  
  public void setEnableSubProgress(boolean paramBoolean)
  {
    AppMethodBeat.i(206503);
    ae.i("MicroMsg.MMSightCircularProgressBar", "setEnableSubProgress: %s", new Object[] { Boolean.valueOf(paramBoolean) });
    this.wgE = paramBoolean;
    AppMethodBeat.o(206503);
  }
  
  public void setInitProgress(int paramInt)
  {
    AppMethodBeat.i(206506);
    ae.i("MicroMsg.MMSightCircularProgressBar", "setInitProgress: %s, isStart: %s", new Object[] { Integer.valueOf(paramInt), Boolean.valueOf(this.isStart) });
    if (!this.isStart) {
      this.wgy = paramInt;
    }
    AppMethodBeat.o(206506);
  }
  
  public void setMaxProgress(float paramFloat)
  {
    AppMethodBeat.i(206504);
    ae.i("MicroMsg.MMSightCircularProgressBar", "setMaxProgress: %s", new Object[] { Float.valueOf(paramFloat) });
    this.kqK = paramFloat;
    AppMethodBeat.o(206504);
  }
  
  public void setProgressCallback(a parama)
  {
    this.ycD = parama;
  }
  
  public static abstract interface a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.recordvideo.ui.editor.MMEditorCircularProgressBar
 * JD-Core Version:    0.7.0.1
 */