package com.tencent.xweb.extension.video;

import android.view.ViewGroup.LayoutParams;
import android.widget.FrameLayout.LayoutParams;
import android.widget.ImageView;

final class d$4
  implements Runnable
{
  d$4(d paramd, double paramDouble, double[] paramArrayOfDouble) {}
  
  public final void run()
  {
    c localc = d.l(this.xiF);
    double d3 = this.xiJ;
    Object localObject = this.xiK;
    double d1 = 0.0D;
    int i = 0;
    while (i < localObject.length)
    {
      double d2 = d1;
      if (localObject.length > i + 1)
      {
        d2 = d1;
        if (localObject[i] / d3 * 100.0D <= localc.St)
        {
          d2 = d1;
          if (localObject[(i + 1)] / d3 * 100.0D > localc.St) {
            d2 = localObject[(i + 1)] / d3 * 100.0D;
          }
        }
      }
      i += 2;
      d1 = d2;
    }
    localObject = (FrameLayout.LayoutParams)localc.gDX.getLayoutParams();
    ((FrameLayout.LayoutParams)localObject).width = ((int)(d1 / 100.0D * localc.ofp.getWidth()));
    localc.gDX.setLayoutParams((ViewGroup.LayoutParams)localObject);
    localc.gDX.requestLayout();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.xweb.extension.video.d.4
 * JD-Core Version:    0.7.0.1
 */