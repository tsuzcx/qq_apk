package com.tencent.mm.ui.widget;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ImageView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.BackwardSupportUtil.BitmapFactory;
import com.tencent.mm.sdk.platformtools.MMHandler;

public class VolumeMeter
  extends ImageView
  implements Runnable
{
  private float EoA;
  private float EoB;
  private boolean Eok;
  private View Eol;
  private int Eom;
  private int Eon;
  private MMHandler Eoo;
  private float Eop;
  private float Eoq;
  private float Eor;
  private float Eos;
  private int Eot;
  private int Eou;
  private float Eov;
  private float Eow;
  private int Eox;
  private float Eoy;
  private float Eoz;
  private boolean lKg;
  private Context mContext;
  private Paint paint;
  private float radius;
  
  public VolumeMeter(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(143500);
    this.lKg = false;
    this.Eok = false;
    this.Eom = -1;
    this.Eon = -1;
    this.Eoo = null;
    this.Eot = -6751336;
    this.Eou = 70;
    this.Eov = 0.5F;
    this.Eow = 0.001F;
    this.Eox = 20;
    this.radius = 0.0F;
    this.EoA = 40.0F;
    this.EoB = 30.0F;
    this.mContext = paramContext;
    init();
    AppMethodBeat.o(143500);
  }
  
  public VolumeMeter(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(143499);
    this.lKg = false;
    this.Eok = false;
    this.Eom = -1;
    this.Eon = -1;
    this.Eoo = null;
    this.Eot = -6751336;
    this.Eou = 70;
    this.Eov = 0.5F;
    this.Eow = 0.001F;
    this.Eox = 20;
    this.radius = 0.0F;
    this.EoA = 40.0F;
    this.EoB = 30.0F;
    this.mContext = paramContext;
    init();
    AppMethodBeat.o(143499);
  }
  
  private void init()
  {
    AppMethodBeat.i(143501);
    this.paint = new Paint();
    AppMethodBeat.o(143501);
  }
  
  protected void onDraw(Canvas paramCanvas)
  {
    AppMethodBeat.i(143502);
    super.onDraw(paramCanvas);
    getWidth();
    getHeight();
    if ((this.Eol == null) || (this.Eol.getVisibility() == 4)) {}
    while ((this.Eom < 0) || (this.Eon < 0))
    {
      AppMethodBeat.o(143502);
      return;
      int[] arrayOfInt = new int[2];
      this.Eol.getLocationInWindow(arrayOfInt);
      if ((arrayOfInt[0] != 0) && (arrayOfInt[1] != 0))
      {
        int i = this.Eol.getWidth();
        int j = this.Eol.getHeight();
        if ((i != 0) && (j != 0))
        {
          int k = BackwardSupportUtil.BitmapFactory.fromDPToPix(this.mContext, 50.0F);
          this.Eom = (arrayOfInt[0] + i / 2);
          this.Eon = (arrayOfInt[1] + j / 2 - k / 2);
          this.Eoz = (i / 2);
          this.Eoy = (i / 2 * 2.0F);
        }
      }
    }
    this.paint.setColor(this.Eot);
    this.paint.setAlpha(this.Eou);
    float f2 = BackwardSupportUtil.BitmapFactory.fromDPToPix(this.mContext, this.radius);
    float f1 = f2;
    if (f2 > this.Eoy) {
      f1 = this.Eoy;
    }
    f2 = f1;
    if (f1 < this.Eoz) {
      f2 = this.Eoz;
    }
    paramCanvas.drawCircle(this.Eom, this.Eon, f2, this.paint);
    AppMethodBeat.o(143502);
  }
  
  public void run()
  {
    AppMethodBeat.i(143498);
    float f2;
    float f3;
    float f1;
    if (this.lKg)
    {
      f2 = this.Eor;
      if (this.Eoq <= this.Eop) {
        break label147;
      }
      f3 = (this.Eoq - this.Eop) / this.EoB;
      if (f3 <= this.Eov) {
        break label128;
      }
      f1 = this.Eov;
      f1 += f2;
    }
    for (;;)
    {
      this.Eor = f1;
      this.Eos = this.Eor;
      this.radius = ((float)(260.0D * Math.sqrt(this.Eor) - 130.0F * this.Eor) / 1.5F);
      postInvalidate();
      this.Eoo.postDelayed(this, this.Eox);
      AppMethodBeat.o(143498);
      return;
      label128:
      f1 = f3;
      if (f3 >= this.Eow) {
        break;
      }
      f1 = this.Eow;
      break;
      label147:
      if (this.Eoq <= this.Eop)
      {
        f3 = (this.Eop - this.Eoq) / this.EoA;
        if (f3 > this.Eov) {
          f1 = this.Eov;
        }
        for (;;)
        {
          f1 = f2 - f1;
          break;
          f1 = f3;
          if (f3 < this.Eow) {
            f1 = this.Eow;
          }
        }
      }
      f1 = f2;
    }
  }
  
  public void setArchView(View paramView)
  {
    this.Eol = paramView;
  }
  
  public void setVolume(float paramFloat)
  {
    this.Eop = this.Eoq;
    this.Eoq = paramFloat;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.ui.widget.VolumeMeter
 * JD-Core Version:    0.7.0.1
 */