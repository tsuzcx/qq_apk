package com.tencent.mm.ui.widget;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ImageView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.BackwardSupportUtil.b;
import com.tencent.mm.sdk.platformtools.ak;

public class VolumeMeter
  extends ImageView
  implements Runnable
{
  private boolean fAK;
  private Context mContext;
  private float maxRadius;
  private boolean oeI;
  private View oeJ;
  private int oeK;
  private int oeL;
  private ak oeM;
  private float oeN;
  private float oeO;
  private float oeP;
  private float oeQ;
  private int oeR;
  private int oeS;
  private float oeT;
  private float oeU;
  private int oeV;
  private float oeW;
  private float oeX;
  private float oeY;
  private Paint paint;
  private float radius;
  
  public VolumeMeter(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(108004);
    this.fAK = false;
    this.oeI = false;
    this.oeK = -1;
    this.oeL = -1;
    this.oeM = null;
    this.oeR = -6751336;
    this.oeS = 70;
    this.oeT = 0.5F;
    this.oeU = 0.001F;
    this.oeV = 20;
    this.radius = 0.0F;
    this.oeX = 40.0F;
    this.oeY = 30.0F;
    this.mContext = paramContext;
    init();
    AppMethodBeat.o(108004);
  }
  
  public VolumeMeter(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(108003);
    this.fAK = false;
    this.oeI = false;
    this.oeK = -1;
    this.oeL = -1;
    this.oeM = null;
    this.oeR = -6751336;
    this.oeS = 70;
    this.oeT = 0.5F;
    this.oeU = 0.001F;
    this.oeV = 20;
    this.radius = 0.0F;
    this.oeX = 40.0F;
    this.oeY = 30.0F;
    this.mContext = paramContext;
    init();
    AppMethodBeat.o(108003);
  }
  
  private void init()
  {
    AppMethodBeat.i(108005);
    this.paint = new Paint();
    AppMethodBeat.o(108005);
  }
  
  protected void onDraw(Canvas paramCanvas)
  {
    AppMethodBeat.i(108006);
    super.onDraw(paramCanvas);
    getWidth();
    getHeight();
    if ((this.oeJ == null) || (this.oeJ.getVisibility() == 4)) {}
    while ((this.oeK < 0) || (this.oeL < 0))
    {
      AppMethodBeat.o(108006);
      return;
      int[] arrayOfInt = new int[2];
      this.oeJ.getLocationInWindow(arrayOfInt);
      if ((arrayOfInt[0] != 0) && (arrayOfInt[1] != 0))
      {
        int i = this.oeJ.getWidth();
        int j = this.oeJ.getHeight();
        if ((i != 0) && (j != 0))
        {
          int k = BackwardSupportUtil.b.b(this.mContext, 50.0F);
          this.oeK = (arrayOfInt[0] + i / 2);
          this.oeL = (arrayOfInt[1] + j / 2 - k / 2);
          this.oeW = (i / 2);
          this.maxRadius = (i / 2 * 2.0F);
        }
      }
    }
    this.paint.setColor(this.oeR);
    this.paint.setAlpha(this.oeS);
    float f2 = BackwardSupportUtil.b.b(this.mContext, this.radius);
    float f1 = f2;
    if (f2 > this.maxRadius) {
      f1 = this.maxRadius;
    }
    f2 = f1;
    if (f1 < this.oeW) {
      f2 = this.oeW;
    }
    paramCanvas.drawCircle(this.oeK, this.oeL, f2, this.paint);
    AppMethodBeat.o(108006);
  }
  
  public void run()
  {
    AppMethodBeat.i(108002);
    float f2;
    float f3;
    float f1;
    if (this.fAK)
    {
      f2 = this.oeP;
      if (this.oeO <= this.oeN) {
        break label147;
      }
      f3 = (this.oeO - this.oeN) / this.oeY;
      if (f3 <= this.oeT) {
        break label128;
      }
      f1 = this.oeT;
      f1 += f2;
    }
    for (;;)
    {
      this.oeP = f1;
      this.oeQ = this.oeP;
      this.radius = ((float)(260.0D * Math.sqrt(this.oeP) - 130.0F * this.oeP) / 1.5F);
      postInvalidate();
      this.oeM.postDelayed(this, this.oeV);
      AppMethodBeat.o(108002);
      return;
      label128:
      f1 = f3;
      if (f3 >= this.oeU) {
        break;
      }
      f1 = this.oeU;
      break;
      label147:
      if (this.oeO <= this.oeN)
      {
        f3 = (this.oeN - this.oeO) / this.oeX;
        if (f3 > this.oeT) {
          f1 = this.oeT;
        }
        for (;;)
        {
          f1 = f2 - f1;
          break;
          f1 = f3;
          if (f3 < this.oeU) {
            f1 = this.oeU;
          }
        }
      }
      f1 = f2;
    }
  }
  
  public void setArchView(View paramView)
  {
    this.oeJ = paramView;
  }
  
  public void setVolume(float paramFloat)
  {
    this.oeN = this.oeO;
    this.oeO = paramFloat;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.ui.widget.VolumeMeter
 * JD-Core Version:    0.7.0.1
 */