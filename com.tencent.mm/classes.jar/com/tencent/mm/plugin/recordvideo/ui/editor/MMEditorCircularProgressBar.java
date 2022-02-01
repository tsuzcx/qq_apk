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
  private int FfL;
  private int FfM;
  private int FfN;
  private RectF FfO;
  private Paint FfP;
  private Paint FfQ;
  private int FfR;
  private float FfS;
  private int FfT;
  private ArrayList<Float> FfX;
  private ArrayList<Float> FfY;
  private boolean FfZ;
  private boolean Fga;
  private boolean Fgb;
  private a HZV;
  private int duration;
  private boolean isStart;
  private boolean kfR;
  private Context mContext;
  private float offset;
  private float opr;
  private Paint paint;
  private float strokeWidth;
  
  public MMEditorCircularProgressBar(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(216541);
    this.FfL = Color.parseColor("#1AAD19");
    this.FfM = Color.parseColor("#FFFFFF");
    this.FfN = Color.parseColor("#FA5151");
    this.strokeWidth = 0.0F;
    this.offset = 0.0F;
    this.FfR = 153;
    this.FfS = 0.0F;
    this.FfT = 0;
    this.opr = 0.0F;
    this.duration = 0;
    this.isStart = false;
    this.FfX = new ArrayList();
    this.FfY = new ArrayList();
    this.FfZ = false;
    this.Fga = false;
    this.Fgb = false;
    this.kfR = false;
    this.mContext = paramContext;
    AppMethodBeat.o(216541);
  }
  
  public MMEditorCircularProgressBar(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(216542);
    this.FfL = Color.parseColor("#1AAD19");
    this.FfM = Color.parseColor("#FFFFFF");
    this.FfN = Color.parseColor("#FA5151");
    this.strokeWidth = 0.0F;
    this.offset = 0.0F;
    this.FfR = 153;
    this.FfS = 0.0F;
    this.FfT = 0;
    this.opr = 0.0F;
    this.duration = 0;
    this.isStart = false;
    this.FfX = new ArrayList();
    this.FfY = new ArrayList();
    this.FfZ = false;
    this.Fga = false;
    this.Fgb = false;
    this.kfR = false;
    this.mContext = paramContext;
    AppMethodBeat.o(216542);
  }
  
  public int getDrawWidth()
  {
    AppMethodBeat.i(216545);
    int i = (int)this.FfO.width();
    AppMethodBeat.o(216545);
    return i;
  }
  
  public ArrayList<Float> getSubProgress()
  {
    return this.FfX;
  }
  
  protected void onDraw(Canvas paramCanvas)
  {
    AppMethodBeat.i(216553);
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
          paramCanvas.drawArc(this.FfO, 90.0F + f / this.opr * 360.0F, (((Float)this.FfX.get(i)).floatValue() - f) / this.opr * 360.0F, false, this.FfQ);
        }
        for (;;)
        {
          f = ((Float)this.FfX.get(i)).floatValue();
          paramCanvas.drawArc(this.FfO, 90.0F + (f - 0.85F) / this.opr * 360.0F, 0.85F / this.opr * 360.0F, false, this.FfP);
          i += 1;
          break;
          paramCanvas.drawArc(this.FfO, 90.0F + f / this.opr * 360.0F, (((Float)this.FfX.get(i)).floatValue() - f) / this.opr * 360.0F, false, this.paint);
        }
      }
      paramCanvas.drawArc(this.FfO, 90.0F + f / this.opr * 360.0F, (this.FfS - f) / this.opr * 360.0F, false, this.paint);
    }
    for (;;)
    {
      paramCanvas.restore();
      AppMethodBeat.o(216553);
      return;
      paramCanvas.drawArc(this.FfO, 90.0F, this.FfS / this.opr * 360.0F, false, this.paint);
    }
  }
  
  protected void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    AppMethodBeat.i(216543);
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
    AppMethodBeat.o(216543);
  }
  
  public void setCircularColor(int paramInt)
  {
    AppMethodBeat.i(216552);
    this.FfL = paramInt;
    this.FfR = 255;
    if ((this.paint != null) && (paramInt != 0)) {
      this.paint.setColor(paramInt);
    }
    AppMethodBeat.o(216552);
  }
  
  public void setCurrentProgress(float paramFloat)
  {
    AppMethodBeat.i(216551);
    this.FfS = paramFloat;
    invalidate();
    AppMethodBeat.o(216551);
  }
  
  public void setDuration(int paramInt)
  {
    AppMethodBeat.i(216549);
    Log.i("MicroMsg.MMSightCircularProgressBar", "setDuration: %s", new Object[] { Integer.valueOf(paramInt) });
    this.duration = paramInt;
    AppMethodBeat.o(216549);
  }
  
  public void setEnableSubProgress(boolean paramBoolean)
  {
    AppMethodBeat.i(216546);
    Log.i("MicroMsg.MMSightCircularProgressBar", "setEnableSubProgress: %s", new Object[] { Boolean.valueOf(paramBoolean) });
    this.FfZ = paramBoolean;
    AppMethodBeat.o(216546);
  }
  
  public void setInitProgress(int paramInt)
  {
    AppMethodBeat.i(216550);
    Log.i("MicroMsg.MMSightCircularProgressBar", "setInitProgress: %s, isStart: %s", new Object[] { Integer.valueOf(paramInt), Boolean.valueOf(this.isStart) });
    if (!this.isStart) {
      this.FfT = paramInt;
    }
    AppMethodBeat.o(216550);
  }
  
  public void setMaxProgress(float paramFloat)
  {
    AppMethodBeat.i(216548);
    Log.i("MicroMsg.MMSightCircularProgressBar", "setMaxProgress: %s", new Object[] { Float.valueOf(paramFloat) });
    this.opr = paramFloat;
    AppMethodBeat.o(216548);
  }
  
  public void setProgressCallback(a parama)
  {
    this.HZV = parama;
  }
  
  public static abstract interface a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.recordvideo.ui.editor.MMEditorCircularProgressBar
 * JD-Core Version:    0.7.0.1
 */