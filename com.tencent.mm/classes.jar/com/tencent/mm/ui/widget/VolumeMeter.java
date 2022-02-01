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
  private boolean KgQ;
  private View KgR;
  private int KgS;
  private int KgT;
  private MMHandler KgU;
  private float KgV;
  private float KgW;
  private float KgX;
  private float KgY;
  private int KgZ;
  private int Kha;
  private float Khb;
  private float Khc;
  private int Khd;
  private float Khe;
  private float Khf;
  private float Khg;
  private float Khh;
  private Context mContext;
  private boolean oCI;
  private Paint paint;
  private float radius;
  
  public VolumeMeter(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(143500);
    this.oCI = false;
    this.KgQ = false;
    this.KgS = -1;
    this.KgT = -1;
    this.KgU = null;
    this.KgZ = -6751336;
    this.Kha = 70;
    this.Khb = 0.5F;
    this.Khc = 0.001F;
    this.Khd = 20;
    this.radius = 0.0F;
    this.Khg = 40.0F;
    this.Khh = 30.0F;
    this.mContext = paramContext;
    init();
    AppMethodBeat.o(143500);
  }
  
  public VolumeMeter(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(143499);
    this.oCI = false;
    this.KgQ = false;
    this.KgS = -1;
    this.KgT = -1;
    this.KgU = null;
    this.KgZ = -6751336;
    this.Kha = 70;
    this.Khb = 0.5F;
    this.Khc = 0.001F;
    this.Khd = 20;
    this.radius = 0.0F;
    this.Khg = 40.0F;
    this.Khh = 30.0F;
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
    if ((this.KgR == null) || (this.KgR.getVisibility() == 4)) {}
    while ((this.KgS < 0) || (this.KgT < 0))
    {
      AppMethodBeat.o(143502);
      return;
      int[] arrayOfInt = new int[2];
      this.KgR.getLocationInWindow(arrayOfInt);
      if ((arrayOfInt[0] != 0) && (arrayOfInt[1] != 0))
      {
        int i = this.KgR.getWidth();
        int j = this.KgR.getHeight();
        if ((i != 0) && (j != 0))
        {
          int k = BackwardSupportUtil.BitmapFactory.fromDPToPix(this.mContext, 50.0F);
          this.KgS = (arrayOfInt[0] + i / 2);
          this.KgT = (arrayOfInt[1] + j / 2 - k / 2);
          this.Khf = (i / 2);
          this.Khe = (i / 2 * 2.0F);
        }
      }
    }
    this.paint.setColor(this.KgZ);
    this.paint.setAlpha(this.Kha);
    float f2 = BackwardSupportUtil.BitmapFactory.fromDPToPix(this.mContext, this.radius);
    float f1 = f2;
    if (f2 > this.Khe) {
      f1 = this.Khe;
    }
    f2 = f1;
    if (f1 < this.Khf) {
      f2 = this.Khf;
    }
    paramCanvas.drawCircle(this.KgS, this.KgT, f2, this.paint);
    AppMethodBeat.o(143502);
  }
  
  public void run()
  {
    AppMethodBeat.i(143498);
    float f2;
    float f3;
    float f1;
    if (this.oCI)
    {
      f2 = this.KgX;
      if (this.KgW <= this.KgV) {
        break label147;
      }
      f3 = (this.KgW - this.KgV) / this.Khh;
      if (f3 <= this.Khb) {
        break label128;
      }
      f1 = this.Khb;
      f1 += f2;
    }
    for (;;)
    {
      this.KgX = f1;
      this.KgY = this.KgX;
      this.radius = ((float)(260.0D * Math.sqrt(this.KgX) - 130.0F * this.KgX) / 1.5F);
      postInvalidate();
      this.KgU.postDelayed(this, this.Khd);
      AppMethodBeat.o(143498);
      return;
      label128:
      f1 = f3;
      if (f3 >= this.Khc) {
        break;
      }
      f1 = this.Khc;
      break;
      label147:
      if (this.KgW <= this.KgV)
      {
        f3 = (this.KgV - this.KgW) / this.Khg;
        if (f3 > this.Khb) {
          f1 = this.Khb;
        }
        for (;;)
        {
          f1 = f2 - f1;
          break;
          f1 = f3;
          if (f3 < this.Khc) {
            f1 = this.Khc;
          }
        }
      }
      f1 = f2;
    }
  }
  
  public void setArchView(View paramView)
  {
    this.KgR = paramView;
  }
  
  public void setVolume(float paramFloat)
  {
    this.KgV = this.KgW;
    this.KgW = paramFloat;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.ui.widget.VolumeMeter
 * JD-Core Version:    0.7.0.1
 */