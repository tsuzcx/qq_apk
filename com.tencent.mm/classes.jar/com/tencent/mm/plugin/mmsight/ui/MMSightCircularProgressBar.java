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
import com.tencent.mm.sdk.platformtools.MTimerHandler;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.ArrayList;

public class MMSightCircularProgressBar
  extends View
{
  private boolean LbA;
  boolean LbB;
  private int Lbl;
  private int Lbm;
  private int Lbn;
  private RectF Lbo;
  private Paint Lbp;
  private Paint Lbq;
  private int Lbr;
  float Lbs;
  private int Lbt;
  private int Lbu;
  c Lbv;
  private a Lbw;
  ArrayList<Float> Lbx;
  private ArrayList<Float> Lby;
  private boolean Lbz;
  private int duration;
  private boolean isStart;
  private Context mContext;
  private boolean mGp;
  private float offset;
  private Paint paint;
  private float strokeWidth;
  
  public MMSightCircularProgressBar(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(94519);
    this.Lbl = Color.parseColor("#1AAD19");
    this.Lbm = Color.parseColor("#FFFFFF");
    this.Lbn = Color.parseColor("#FA5151");
    this.strokeWidth = 0.0F;
    this.offset = 0.0F;
    this.Lbr = 153;
    this.Lbs = 0.0F;
    this.Lbt = 0;
    this.Lbu = 0;
    this.duration = 0;
    this.isStart = false;
    this.Lbx = new ArrayList();
    this.Lby = new ArrayList();
    this.Lbz = false;
    this.LbA = false;
    this.LbB = false;
    this.mGp = false;
    this.mContext = paramContext;
    AppMethodBeat.o(94519);
  }
  
  public MMSightCircularProgressBar(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(94520);
    this.Lbl = Color.parseColor("#1AAD19");
    this.Lbm = Color.parseColor("#FFFFFF");
    this.Lbn = Color.parseColor("#FA5151");
    this.strokeWidth = 0.0F;
    this.offset = 0.0F;
    this.Lbr = 153;
    this.Lbs = 0.0F;
    this.Lbt = 0;
    this.Lbu = 0;
    this.duration = 0;
    this.isStart = false;
    this.Lbx = new ArrayList();
    this.Lby = new ArrayList();
    this.Lbz = false;
    this.LbA = false;
    this.LbB = false;
    this.mGp = false;
    this.mContext = paramContext;
    AppMethodBeat.o(94520);
  }
  
  public int getDrawWidth()
  {
    AppMethodBeat.i(303646);
    int i = (int)this.Lbo.width();
    AppMethodBeat.o(303646);
    return i;
  }
  
  public ArrayList<Float> getSubProgress()
  {
    return this.Lbx;
  }
  
  protected void onDraw(Canvas paramCanvas)
  {
    AppMethodBeat.i(94526);
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
          paramCanvas.drawArc(this.Lbo, 90.0F + f / this.Lbu * 360.0F, (((Float)this.Lbx.get(i)).floatValue() - f) / this.Lbu * 360.0F, false, this.Lbq);
        }
        for (;;)
        {
          f = ((Float)this.Lbx.get(i)).floatValue();
          paramCanvas.drawArc(this.Lbo, 90.0F + (f - 0.85F) / this.Lbu * 360.0F, 0.85F / this.Lbu * 360.0F, false, this.Lbp);
          i += 1;
          break;
          paramCanvas.drawArc(this.Lbo, 90.0F + f / this.Lbu * 360.0F, (((Float)this.Lbx.get(i)).floatValue() - f) / this.Lbu * 360.0F, false, this.paint);
        }
      }
      if (this.Lbu > 0) {
        paramCanvas.drawArc(this.Lbo, 90.0F + f / this.Lbu * 360.0F, (this.Lbs - f) / this.Lbu * 360.0F, false, this.paint);
      }
    }
    for (;;)
    {
      paramCanvas.restore();
      AppMethodBeat.o(94526);
      return;
      paramCanvas.drawArc(this.Lbo, 90.0F, this.Lbs / this.Lbu * 360.0F, false, this.paint);
    }
  }
  
  protected void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    AppMethodBeat.i(303644);
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
    AppMethodBeat.o(303644);
  }
  
  public final void reset()
  {
    AppMethodBeat.i(303658);
    Log.i("MicroMsg.MMSightCircularProgressBar", "reset");
    this.Lbw = null;
    this.Lbt = 0;
    this.Lbu = 100;
    this.duration = 0;
    this.isStart = false;
    this.Lbx.clear();
    this.Lbs = 0.0F;
    if (this.Lbv != null)
    {
      this.Lbv.cancel();
      this.Lbv = null;
    }
    invalidate();
    AppMethodBeat.o(303658);
  }
  
  public void setCircularColor(int paramInt)
  {
    AppMethodBeat.i(94525);
    this.Lbl = paramInt;
    this.Lbr = 255;
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
    AppMethodBeat.i(303648);
    Log.i("MicroMsg.MMSightCircularProgressBar", "setEnableSubProgress: %s", new Object[] { Boolean.valueOf(paramBoolean) });
    this.Lbz = paramBoolean;
    AppMethodBeat.o(303648);
  }
  
  public void setInitProgress(int paramInt)
  {
    AppMethodBeat.i(94524);
    Log.i("MicroMsg.MMSightCircularProgressBar", "setInitProgress: %s, isStart: %s", new Object[] { Integer.valueOf(paramInt), Boolean.valueOf(this.isStart) });
    if (!this.isStart) {
      this.Lbt = paramInt;
    }
    AppMethodBeat.o(94524);
  }
  
  public void setMaxProgress(int paramInt)
  {
    AppMethodBeat.i(94522);
    Log.i("MicroMsg.MMSightCircularProgressBar", "setMaxProgress: %s", new Object[] { Integer.valueOf(paramInt) });
    this.Lbu = paramInt;
    AppMethodBeat.o(94522);
  }
  
  public void setProgressCallback(a parama)
  {
    this.Lbw = parama;
  }
  
  public final void start()
  {
    AppMethodBeat.i(303662);
    Log.i("MicroMsg.MMSightCircularProgressBar", "start, initProgress: %s, maxProgress: %s, duration: %s currentProgress:%s", new Object[] { Integer.valueOf(this.Lbt), Integer.valueOf(this.Lbu), Integer.valueOf(this.duration), Float.valueOf(this.Lbs) });
    this.isStart = true;
    if (this.Lbv != null)
    {
      this.Lbv.cancel();
      this.Lbv = null;
    }
    this.Lbv = new c(this.Lbs, this.Lbu, this.duration);
    c localc = this.Lbv;
    c.a local1 = new c.a()
    {
      public final void cB(float paramAnonymousFloat)
      {
        AppMethodBeat.i(94517);
        if (paramAnonymousFloat > 100.0F)
        {
          AppMethodBeat.o(94517);
          return;
        }
        MMSightCircularProgressBar.a(MMSightCircularProgressBar.this, paramAnonymousFloat);
        if (MMSightCircularProgressBar.a(MMSightCircularProgressBar.this) != null)
        {
          MMSightCircularProgressBar.b(MMSightCircularProgressBar.this).clear();
          MMSightCircularProgressBar.b(MMSightCircularProgressBar.this).addAll(MMSightCircularProgressBar.c(MMSightCircularProgressBar.this));
          MMSightCircularProgressBar.b(MMSightCircularProgressBar.this).add(Float.valueOf(MMSightCircularProgressBar.d(MMSightCircularProgressBar.this)));
          MMSightCircularProgressBar.a(MMSightCircularProgressBar.this).ad(MMSightCircularProgressBar.b(MMSightCircularProgressBar.this));
        }
        MMSightCircularProgressBar.this.invalidate();
        AppMethodBeat.o(94517);
      }
      
      public final void onAnimationEnd()
      {
        AppMethodBeat.i(94518);
        Log.i("MicroMsg.MMSightCircularProgressBar", "onAnimationEnd %b", new Object[] { Boolean.valueOf(MMSightCircularProgressBar.e(MMSightCircularProgressBar.this)) });
        MMHandlerThread.postToMainThread(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(94516);
            if (MMSightCircularProgressBar.a(MMSightCircularProgressBar.this) != null) {
              MMSightCircularProgressBar.a(MMSightCircularProgressBar.this).ov(true);
            }
            AppMethodBeat.o(94516);
          }
        });
        AppMethodBeat.o(94518);
      }
    };
    Log.i("MicroMsg.ProgressHandlerAnimator", "setAnimationCallback: %s", new Object[] { local1 });
    localc.Ldg = local1;
    localc = this.Lbv;
    Log.i("MicroMsg.ProgressHandlerAnimator", "Start");
    localc.isStart = true;
    localc.moe = Util.currentTicks();
    localc.oNL.startTimer(20L);
    AppMethodBeat.o(303662);
  }
  
  public static abstract interface a
  {
    public abstract void ad(ArrayList<Float> paramArrayList);
    
    public abstract void ov(boolean paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.mmsight.ui.MMSightCircularProgressBar
 * JD-Core Version:    0.7.0.1
 */