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
  private boolean iTN;
  private Context mContext;
  private Paint paint;
  private float radius;
  private int yKA;
  private int yKB;
  private float yKC;
  private float yKD;
  private int yKE;
  private float yKF;
  private float yKG;
  private float yKH;
  private float yKI;
  private boolean yKr;
  private View yKs;
  private int yKt;
  private int yKu;
  private MMHandler yKv;
  private float yKw;
  private float yKx;
  private float yKy;
  private float yKz;
  
  public VolumeMeter(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(143500);
    this.iTN = false;
    this.yKr = false;
    this.yKt = -1;
    this.yKu = -1;
    this.yKv = null;
    this.yKA = -6751336;
    this.yKB = 70;
    this.yKC = 0.5F;
    this.yKD = 0.001F;
    this.yKE = 20;
    this.radius = 0.0F;
    this.yKH = 40.0F;
    this.yKI = 30.0F;
    this.mContext = paramContext;
    init();
    AppMethodBeat.o(143500);
  }
  
  public VolumeMeter(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(143499);
    this.iTN = false;
    this.yKr = false;
    this.yKt = -1;
    this.yKu = -1;
    this.yKv = null;
    this.yKA = -6751336;
    this.yKB = 70;
    this.yKC = 0.5F;
    this.yKD = 0.001F;
    this.yKE = 20;
    this.radius = 0.0F;
    this.yKH = 40.0F;
    this.yKI = 30.0F;
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
    if ((this.yKs == null) || (this.yKs.getVisibility() == 4)) {}
    while ((this.yKt < 0) || (this.yKu < 0))
    {
      AppMethodBeat.o(143502);
      return;
      int[] arrayOfInt = new int[2];
      this.yKs.getLocationInWindow(arrayOfInt);
      if ((arrayOfInt[0] != 0) && (arrayOfInt[1] != 0))
      {
        int i = this.yKs.getWidth();
        int j = this.yKs.getHeight();
        if ((i != 0) && (j != 0))
        {
          int k = BackwardSupportUtil.BitmapFactory.fromDPToPix(this.mContext, 50.0F);
          this.yKt = (arrayOfInt[0] + i / 2);
          this.yKu = (arrayOfInt[1] + j / 2 - k / 2);
          this.yKG = (i / 2);
          this.yKF = (i / 2 * 2.0F);
        }
      }
    }
    this.paint.setColor(this.yKA);
    this.paint.setAlpha(this.yKB);
    float f2 = BackwardSupportUtil.BitmapFactory.fromDPToPix(this.mContext, this.radius);
    float f1 = f2;
    if (f2 > this.yKF) {
      f1 = this.yKF;
    }
    f2 = f1;
    if (f1 < this.yKG) {
      f2 = this.yKG;
    }
    paramCanvas.drawCircle(this.yKt, this.yKu, f2, this.paint);
    AppMethodBeat.o(143502);
  }
  
  public void run()
  {
    AppMethodBeat.i(143498);
    float f2;
    float f3;
    float f1;
    if (this.iTN)
    {
      f2 = this.yKy;
      if (this.yKx <= this.yKw) {
        break label147;
      }
      f3 = (this.yKx - this.yKw) / this.yKI;
      if (f3 <= this.yKC) {
        break label128;
      }
      f1 = this.yKC;
      f1 += f2;
    }
    for (;;)
    {
      this.yKy = f1;
      this.yKz = this.yKy;
      this.radius = ((float)(260.0D * Math.sqrt(this.yKy) - 130.0F * this.yKy) / 1.5F);
      postInvalidate();
      this.yKv.postDelayed(this, this.yKE);
      AppMethodBeat.o(143498);
      return;
      label128:
      f1 = f3;
      if (f3 >= this.yKD) {
        break;
      }
      f1 = this.yKD;
      break;
      label147:
      if (this.yKx <= this.yKw)
      {
        f3 = (this.yKw - this.yKx) / this.yKH;
        if (f3 > this.yKC) {
          f1 = this.yKC;
        }
        for (;;)
        {
          f1 = f2 - f1;
          break;
          f1 = f3;
          if (f3 < this.yKD) {
            f1 = this.yKD;
          }
        }
      }
      f1 = f2;
    }
  }
  
  public void setArchView(View paramView)
  {
    this.yKs = paramView;
  }
  
  public void setVolume(float paramFloat)
  {
    this.yKw = this.yKx;
    this.yKx = paramFloat;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.ui.widget.VolumeMeter
 * JD-Core Version:    0.7.0.1
 */