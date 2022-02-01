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
  int duration;
  private boolean gEz;
  boolean isStart;
  private Context mContext;
  private float offset;
  private Paint paint;
  private float strokeWidth;
  private boolean vUA;
  private boolean vUB;
  boolean vUC;
  private int vUm;
  private int vUn;
  private int vUo;
  private RectF vUp;
  private Paint vUq;
  private Paint vUr;
  private int vUs;
  float vUt;
  int vUu;
  int vUv;
  c vUw;
  private a vUx;
  ArrayList<Float> vUy;
  private ArrayList<Float> vUz;
  
  public MMSightCircularProgressBar(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(94519);
    this.vUm = Color.parseColor("#1AAD19");
    this.vUn = Color.parseColor("#FFFFFF");
    this.vUo = Color.parseColor("#FA5151");
    this.strokeWidth = 0.0F;
    this.offset = 0.0F;
    this.vUs = 153;
    this.vUt = 0.0F;
    this.vUu = 0;
    this.vUv = 0;
    this.duration = 0;
    this.isStart = false;
    this.vUy = new ArrayList();
    this.vUz = new ArrayList();
    this.vUA = false;
    this.vUB = false;
    this.vUC = false;
    this.gEz = false;
    this.mContext = paramContext;
    AppMethodBeat.o(94519);
  }
  
  public MMSightCircularProgressBar(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(94520);
    this.vUm = Color.parseColor("#1AAD19");
    this.vUn = Color.parseColor("#FFFFFF");
    this.vUo = Color.parseColor("#FA5151");
    this.strokeWidth = 0.0F;
    this.offset = 0.0F;
    this.vUs = 153;
    this.vUt = 0.0F;
    this.vUu = 0;
    this.vUv = 0;
    this.duration = 0;
    this.isStart = false;
    this.vUy = new ArrayList();
    this.vUz = new ArrayList();
    this.vUA = false;
    this.vUB = false;
    this.vUC = false;
    this.gEz = false;
    this.mContext = paramContext;
    AppMethodBeat.o(94520);
  }
  
  public int getDrawWidth()
  {
    AppMethodBeat.i(214498);
    int i = (int)this.vUp.width();
    AppMethodBeat.o(214498);
    return i;
  }
  
  public ArrayList<Float> getSubProgress()
  {
    return this.vUy;
  }
  
  protected void onDraw(Canvas paramCanvas)
  {
    AppMethodBeat.i(94526);
    paramCanvas.save();
    paramCanvas.translate(this.offset, this.offset);
    paramCanvas.rotate(180.0F, this.vUp.right / 2.0F, this.vUp.bottom / 2.0F);
    if (this.vUA)
    {
      int i = 0;
      float f = 0.0F;
      if (i < this.vUy.size())
      {
        if ((this.vUC) && (i == this.vUy.size() - 1)) {
          paramCanvas.drawArc(this.vUp, 90.0F + f / this.vUv * 360.0F, (((Float)this.vUy.get(i)).floatValue() - f) / this.vUv * 360.0F, false, this.vUr);
        }
        for (;;)
        {
          f = ((Float)this.vUy.get(i)).floatValue();
          paramCanvas.drawArc(this.vUp, 90.0F + (f - 0.85F) / this.vUv * 360.0F, 0.85F / this.vUv * 360.0F, false, this.vUq);
          i += 1;
          break;
          paramCanvas.drawArc(this.vUp, 90.0F + f / this.vUv * 360.0F, (((Float)this.vUy.get(i)).floatValue() - f) / this.vUv * 360.0F, false, this.paint);
        }
      }
      paramCanvas.drawArc(this.vUp, 90.0F + f / this.vUv * 360.0F, (this.vUt - f) / this.vUv * 360.0F, false, this.paint);
    }
    for (;;)
    {
      paramCanvas.restore();
      AppMethodBeat.o(94526);
      return;
      paramCanvas.drawArc(this.vUp, 90.0F, this.vUt / this.vUv * 360.0F, false, this.paint);
    }
  }
  
  protected void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    AppMethodBeat.i(214497);
    super.onLayout(paramBoolean, paramInt1, paramInt2, paramInt3, paramInt4);
    if (!this.gEz)
    {
      this.gEz = true;
      float f = getWidth();
      this.strokeWidth = this.mContext.getResources().getDimensionPixelSize(2131166581);
      this.offset = (this.strokeWidth / 2.0F);
      this.vUp = new RectF(this.offset, this.offset, f - this.offset, f - this.offset);
      this.paint = new Paint();
      this.paint.setStyle(Paint.Style.STROKE);
      this.paint.setStrokeWidth(this.strokeWidth);
      this.paint.setColor(this.vUm);
      this.paint.setAlpha(this.vUs);
      this.paint.setAntiAlias(true);
      this.vUq = new Paint();
      this.vUq.setStyle(Paint.Style.STROKE);
      this.vUq.setStrokeWidth(this.strokeWidth);
      this.vUq.setColor(this.vUn);
      this.vUq.setAlpha(this.vUs);
      this.vUq.setAntiAlias(true);
      this.vUr = new Paint();
      this.vUr.setStyle(Paint.Style.STROKE);
      this.vUr.setStrokeWidth(this.strokeWidth);
      this.vUr.setColor(this.vUo);
      this.vUr.setAntiAlias(true);
    }
    AppMethodBeat.o(214497);
  }
  
  public final void reset()
  {
    AppMethodBeat.i(214500);
    ad.i("MicroMsg.MMSightCircularProgressBar", "reset");
    this.vUx = null;
    this.vUu = 0;
    this.vUv = 100;
    this.duration = 0;
    this.isStart = false;
    this.vUy.clear();
    this.vUt = 0.0F;
    if (this.vUw != null)
    {
      this.vUw.cancel();
      this.vUw = null;
    }
    invalidate();
    AppMethodBeat.o(214500);
  }
  
  public void setCircularColor(int paramInt)
  {
    AppMethodBeat.i(94525);
    this.vUm = paramInt;
    this.vUs = 255;
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
    AppMethodBeat.i(214499);
    ad.i("MicroMsg.MMSightCircularProgressBar", "setEnableSubProgress: %s", new Object[] { Boolean.valueOf(paramBoolean) });
    this.vUA = paramBoolean;
    AppMethodBeat.o(214499);
  }
  
  public void setInitProgress(int paramInt)
  {
    AppMethodBeat.i(94524);
    ad.i("MicroMsg.MMSightCircularProgressBar", "setInitProgress: %s, isStart: %s", new Object[] { Integer.valueOf(paramInt), Boolean.valueOf(this.isStart) });
    if (!this.isStart) {
      this.vUu = paramInt;
    }
    AppMethodBeat.o(94524);
  }
  
  public void setMaxProgress(int paramInt)
  {
    AppMethodBeat.i(94522);
    ad.i("MicroMsg.MMSightCircularProgressBar", "setMaxProgress: %s", new Object[] { Integer.valueOf(paramInt) });
    this.vUv = paramInt;
    AppMethodBeat.o(94522);
  }
  
  public void setProgressCallback(a parama)
  {
    this.vUx = parama;
  }
  
  public static abstract interface a
  {
    public abstract void S(ArrayList<Float> paramArrayList);
    
    public abstract void kH(boolean paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.mmsight.ui.MMSightCircularProgressBar
 * JD-Core Version:    0.7.0.1
 */