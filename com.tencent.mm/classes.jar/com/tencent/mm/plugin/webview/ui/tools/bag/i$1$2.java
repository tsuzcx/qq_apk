package com.tencent.mm.plugin.webview.ui.tools.bag;

import android.animation.PropertyValuesHolder;
import android.animation.TimeInterpolator;
import android.animation.ValueAnimator;
import android.graphics.Bitmap;
import android.graphics.Point;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.animation.LinearInterpolator;
import com.tencent.mm.sdk.platformtools.c;
import com.tencent.mm.sdk.platformtools.y;

final class i$1$2
  implements Runnable
{
  i$1$2(i.1 param1) {}
  
  public final void run()
  {
    Object localObject2 = this.rrN.rrK;
    Object localObject3 = this.rrN.rrL;
    float f = this.rrN.rrM;
    e locale = this.rrN.rrJ;
    y.i("MicroMsg.TransformToBagAniHelper", "doMaskAnimation bogPos x:%d, y:%d lastSwipePosX:%f", new Object[] { Integer.valueOf(((Point)localObject3).x), Integer.valueOf(((Point)localObject3).y), Float.valueOf(f) });
    if (((g)localObject2).getContentView() == null)
    {
      y.w("MicroMsg.TransformToBagAniHelper", "doMaskAnimation getSwipeBackLayout null");
      locale.ceX();
      return;
    }
    ViewGroup localViewGroup = ((g)localObject2).cbn();
    Object localObject1 = c.dz(((g)localObject2).getContentView());
    localObject1 = new j(((g)localObject2).getActivity(), (Bitmap)localObject1);
    ((j)localObject1).setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
    int i = ((Point)localObject3).x;
    int j = ((Point)localObject3).y;
    int k = b.rrj;
    int m = b.rrl / 2;
    ((j)localObject1).rrX = i;
    ((j)localObject1).rrY = (j + k);
    ((j)localObject1).rrW = m;
    ((j)localObject1).setContentStartPosX((int)f);
    ((j)localObject1).setListener(new i.2((j)localObject1, locale));
    localViewGroup.addView((View)localObject1, localViewGroup.getChildCount());
    ((g)localObject2).getContentView().setVisibility(8);
    localObject2 = new LinearInterpolator();
    boolean bool;
    if (((j)localObject1).rrZ > 0)
    {
      bool = true;
      ((j)localObject1).rsa = bool;
      if (((j)localObject1).rrZ >= ((j)localObject1).rrX) {
        break label531;
      }
      i = ((j)localObject1).rrZ;
      label292:
      localObject3 = PropertyValuesHolder.ofInt("canvasTranslationX", new int[] { ((j)localObject1).rrZ, i });
      i = ((j)localObject1).rrX;
      if (((j)localObject1).rsa) {
        if (((j)localObject1).rrZ >= ((j)localObject1).rrX) {
          break label540;
        }
      }
    }
    label531:
    label540:
    for (i = ((j)localObject1).rrX - ((j)localObject1).rrZ;; i = 0)
    {
      localObject3 = ValueAnimator.ofPropertyValuesHolder(new PropertyValuesHolder[] { PropertyValuesHolder.ofInt("translationX", new int[] { 0, i }), PropertyValuesHolder.ofInt("translationY", new int[] { 0, ((j)localObject1).rrY }), PropertyValuesHolder.ofFloat("scaleX", new float[] { 1.0F, ((j)localObject1).rrW * 2.0F / ((j)localObject1).mWidth }), PropertyValuesHolder.ofFloat("scaleY", new float[] { 1.0F, ((j)localObject1).rrW * 2.0F / ((j)localObject1).mHeight }), localObject3 });
      ((ValueAnimator)localObject3).setDuration(300L);
      ((ValueAnimator)localObject3).setInterpolator((TimeInterpolator)localObject2);
      ((ValueAnimator)localObject3).addUpdateListener(new j.1((j)localObject1));
      ((ValueAnimator)localObject3).addListener(new j.2((j)localObject1));
      ((ValueAnimator)localObject3).start();
      return;
      bool = false;
      break;
      i = ((j)localObject1).rrX;
      break label292;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.ui.tools.bag.i.1.2
 * JD-Core Version:    0.7.0.1
 */