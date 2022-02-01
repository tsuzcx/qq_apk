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
import com.tencent.mm.plugin.w.a.c;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.ArrayList;

public class MMEditorCircularProgressBar
  extends View
{
  private boolean LbA;
  private boolean LbB;
  private int Lbl;
  private int Lbm;
  private int Lbn;
  private RectF Lbo;
  private Paint Lbp;
  private Paint Lbq;
  private int Lbr;
  private float Lbs;
  private int Lbt;
  private ArrayList<Float> Lbx;
  private ArrayList<Float> Lby;
  private boolean Lbz;
  private a NWx;
  private int duration;
  private boolean isStart;
  private Context mContext;
  private boolean mGp;
  private float offset;
  private Paint paint;
  private float rsZ;
  private float strokeWidth;
  
  public MMEditorCircularProgressBar(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(279852);
    this.Lbl = Color.parseColor("#1AAD19");
    this.Lbm = Color.parseColor("#FFFFFF");
    this.Lbn = Color.parseColor("#FA5151");
    this.strokeWidth = 0.0F;
    this.offset = 0.0F;
    this.Lbr = 153;
    this.Lbs = 0.0F;
    this.Lbt = 0;
    this.rsZ = 0.0F;
    this.duration = 0;
    this.isStart = false;
    this.Lbx = new ArrayList();
    this.Lby = new ArrayList();
    this.Lbz = false;
    this.LbA = false;
    this.LbB = false;
    this.mGp = false;
    this.mContext = paramContext;
    AppMethodBeat.o(279852);
  }
  
  public MMEditorCircularProgressBar(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(279862);
    this.Lbl = Color.parseColor("#1AAD19");
    this.Lbm = Color.parseColor("#FFFFFF");
    this.Lbn = Color.parseColor("#FA5151");
    this.strokeWidth = 0.0F;
    this.offset = 0.0F;
    this.Lbr = 153;
    this.Lbs = 0.0F;
    this.Lbt = 0;
    this.rsZ = 0.0F;
    this.duration = 0;
    this.isStart = false;
    this.Lbx = new ArrayList();
    this.Lby = new ArrayList();
    this.Lbz = false;
    this.LbA = false;
    this.LbB = false;
    this.mGp = false;
    this.mContext = paramContext;
    AppMethodBeat.o(279862);
  }
  
  public int getDrawWidth()
  {
    AppMethodBeat.i(279871);
    int i = (int)this.Lbo.width();
    AppMethodBeat.o(279871);
    return i;
  }
  
  public ArrayList<Float> getSubProgress()
  {
    return this.Lbx;
  }
  
  protected void onDraw(Canvas paramCanvas)
  {
    AppMethodBeat.i(279902);
    paramCanvas.save();
    paramCanvas.translate(this.offset, this.offset);
    paramCanvas.rotate(180.0F, this.Lbo.right / 2.0F, this.Lbo.bottom / 2.0F);
    if (this.Lbz)
    {
      int i = 0;
      float f = 0.0F;
      if (i < this.Lbx.size())
      {
        if ((this.LbB) && (i == this.Lbx.size() - 1)) {
          paramCanvas.drawArc(this.Lbo, 90.0F + f / this.rsZ * 360.0F, (((Float)this.Lbx.get(i)).floatValue() - f) / this.rsZ * 360.0F, false, this.Lbq);
        }
        for (;;)
        {
          f = ((Float)this.Lbx.get(i)).floatValue();
          paramCanvas.drawArc(this.Lbo, 90.0F + (f - 0.85F) / this.rsZ * 360.0F, 0.85F / this.rsZ * 360.0F, false, this.Lbp);
          i += 1;
          break;
          paramCanvas.drawArc(this.Lbo, 90.0F + f / this.rsZ * 360.0F, (((Float)this.Lbx.get(i)).floatValue() - f) / this.rsZ * 360.0F, false, this.paint);
        }
      }
      paramCanvas.drawArc(this.Lbo, 90.0F + f / this.rsZ * 360.0F, (this.Lbs - f) / this.rsZ * 360.0F, false, this.paint);
    }
    for (;;)
    {
      paramCanvas.restore();
      AppMethodBeat.o(279902);
      return;
      paramCanvas.drawArc(this.Lbo, 90.0F, this.Lbs / this.rsZ * 360.0F, false, this.paint);
    }
  }
  
  protected void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    AppMethodBeat.i(279866);
    super.onLayout(paramBoolean, paramInt1, paramInt2, paramInt3, paramInt4);
    if (!this.mGp)
    {
      this.mGp = true;
      float f = getWidth();
      this.strokeWidth = this.mContext.getResources().getDimensionPixelSize(a.c.mmsight_recorder_progress_circular_thickness);
      this.offset = (this.strokeWidth / 2.0F);
      this.Lbo = new RectF(this.offset, this.offset, f - this.offset, f - this.offset);
      this.paint = new Paint();
      this.paint.setStyle(Paint.Style.STROKE);
      this.paint.setStrokeWidth(this.strokeWidth);
      this.paint.setColor(this.Lbl);
      this.paint.setAlpha(this.Lbr);
      this.paint.setAntiAlias(true);
      this.Lbp = new Paint();
      this.Lbp.setStyle(Paint.Style.STROKE);
      this.Lbp.setStrokeWidth(this.strokeWidth);
      this.Lbp.setColor(this.Lbm);
      this.Lbp.setAlpha(this.Lbr);
      this.Lbp.setAntiAlias(true);
      this.Lbq = new Paint();
      this.Lbq.setStyle(Paint.Style.STROKE);
      this.Lbq.setStrokeWidth(this.strokeWidth);
      this.Lbq.setColor(this.Lbn);
      this.Lbq.setAntiAlias(true);
    }
    AppMethodBeat.o(279866);
  }
  
  public void setCircularColor(int paramInt)
  {
    AppMethodBeat.i(279892);
    this.Lbl = paramInt;
    this.Lbr = 255;
    if ((this.paint != null) && (paramInt != 0)) {
      this.paint.setColor(paramInt);
    }
    AppMethodBeat.o(279892);
  }
  
  public void setCurrentProgress(float paramFloat)
  {
    AppMethodBeat.i(279889);
    this.Lbs = paramFloat;
    invalidate();
    AppMethodBeat.o(279889);
  }
  
  public void setDuration(int paramInt)
  {
    AppMethodBeat.i(279880);
    Log.i("MicroMsg.MMSightCircularProgressBar", "setDuration: %s", new Object[] { Integer.valueOf(paramInt) });
    this.duration = paramInt;
    AppMethodBeat.o(279880);
  }
  
  public void setEnableSubProgress(boolean paramBoolean)
  {
    AppMethodBeat.i(279874);
    Log.i("MicroMsg.MMSightCircularProgressBar", "setEnableSubProgress: %s", new Object[] { Boolean.valueOf(paramBoolean) });
    this.Lbz = paramBoolean;
    AppMethodBeat.o(279874);
  }
  
  public void setInitProgress(int paramInt)
  {
    AppMethodBeat.i(279884);
    Log.i("MicroMsg.MMSightCircularProgressBar", "setInitProgress: %s, isStart: %s", new Object[] { Integer.valueOf(paramInt), Boolean.valueOf(this.isStart) });
    if (!this.isStart) {
      this.Lbt = paramInt;
    }
    AppMethodBeat.o(279884);
  }
  
  public void setMaxProgress(float paramFloat)
  {
    AppMethodBeat.i(279878);
    Log.i("MicroMsg.MMSightCircularProgressBar", "setMaxProgress: %s", new Object[] { Float.valueOf(paramFloat) });
    this.rsZ = paramFloat;
    AppMethodBeat.o(279878);
  }
  
  public void setProgressCallback(a parama)
  {
    this.NWx = parama;
  }
  
  public static abstract interface a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.recordvideo.ui.editor.MMEditorCircularProgressBar
 * JD-Core Version:    0.7.0.1
 */