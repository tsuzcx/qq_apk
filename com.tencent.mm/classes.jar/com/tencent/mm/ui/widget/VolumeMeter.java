package com.tencent.mm.ui.widget;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ImageView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.BackwardSupportUtil.b;
import com.tencent.mm.sdk.platformtools.ap;

public class VolumeMeter
  extends ImageView
  implements Runnable
{
  private boolean hVX;
  private Context mContext;
  private Paint paint;
  private float radius;
  private int veA;
  private int veB;
  private float veC;
  private float veD;
  private int veE;
  private float veF;
  private float veG;
  private float veH;
  private float veI;
  private boolean veq;
  private View ves;
  private int vet;
  private int veu;
  private ap vev;
  private float vew;
  private float vex;
  private float vey;
  private float vez;
  
  public VolumeMeter(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(143500);
    this.hVX = false;
    this.veq = false;
    this.vet = -1;
    this.veu = -1;
    this.vev = null;
    this.veA = -6751336;
    this.veB = 70;
    this.veC = 0.5F;
    this.veD = 0.001F;
    this.veE = 20;
    this.radius = 0.0F;
    this.veH = 40.0F;
    this.veI = 30.0F;
    this.mContext = paramContext;
    init();
    AppMethodBeat.o(143500);
  }
  
  public VolumeMeter(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(143499);
    this.hVX = false;
    this.veq = false;
    this.vet = -1;
    this.veu = -1;
    this.vev = null;
    this.veA = -6751336;
    this.veB = 70;
    this.veC = 0.5F;
    this.veD = 0.001F;
    this.veE = 20;
    this.radius = 0.0F;
    this.veH = 40.0F;
    this.veI = 30.0F;
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
    if ((this.ves == null) || (this.ves.getVisibility() == 4)) {}
    while ((this.vet < 0) || (this.veu < 0))
    {
      AppMethodBeat.o(143502);
      return;
      int[] arrayOfInt = new int[2];
      this.ves.getLocationInWindow(arrayOfInt);
      if ((arrayOfInt[0] != 0) && (arrayOfInt[1] != 0))
      {
        int i = this.ves.getWidth();
        int j = this.ves.getHeight();
        if ((i != 0) && (j != 0))
        {
          int k = BackwardSupportUtil.b.g(this.mContext, 50.0F);
          this.vet = (arrayOfInt[0] + i / 2);
          this.veu = (arrayOfInt[1] + j / 2 - k / 2);
          this.veG = (i / 2);
          this.veF = (i / 2 * 2.0F);
        }
      }
    }
    this.paint.setColor(this.veA);
    this.paint.setAlpha(this.veB);
    float f2 = BackwardSupportUtil.b.g(this.mContext, this.radius);
    float f1 = f2;
    if (f2 > this.veF) {
      f1 = this.veF;
    }
    f2 = f1;
    if (f1 < this.veG) {
      f2 = this.veG;
    }
    paramCanvas.drawCircle(this.vet, this.veu, f2, this.paint);
    AppMethodBeat.o(143502);
  }
  
  public void run()
  {
    AppMethodBeat.i(143498);
    float f2;
    float f3;
    float f1;
    if (this.hVX)
    {
      f2 = this.vey;
      if (this.vex <= this.vew) {
        break label147;
      }
      f3 = (this.vex - this.vew) / this.veI;
      if (f3 <= this.veC) {
        break label128;
      }
      f1 = this.veC;
      f1 += f2;
    }
    for (;;)
    {
      this.vey = f1;
      this.vez = this.vey;
      this.radius = ((float)(260.0D * Math.sqrt(this.vey) - 130.0F * this.vey) / 1.5F);
      postInvalidate();
      this.vev.postDelayed(this, this.veE);
      AppMethodBeat.o(143498);
      return;
      label128:
      f1 = f3;
      if (f3 >= this.veD) {
        break;
      }
      f1 = this.veD;
      break;
      label147:
      if (this.vex <= this.vew)
      {
        f3 = (this.vew - this.vex) / this.veH;
        if (f3 > this.veC) {
          f1 = this.veC;
        }
        for (;;)
        {
          f1 = f2 - f1;
          break;
          f1 = f3;
          if (f3 < this.veD) {
            f1 = this.veD;
          }
        }
      }
      f1 = f2;
    }
  }
  
  public void setArchView(View paramView)
  {
    this.ves = paramView;
  }
  
  public void setVolume(float paramFloat)
  {
    this.vew = this.vex;
    this.vex = paramFloat;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.ui.widget.VolumeMeter
 * JD-Core Version:    0.7.0.1
 */