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
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.d;

final class i$1$2
  implements Runnable
{
  i$1$2(i.1 param1) {}
  
  public final void run()
  {
    AppMethodBeat.i(8173);
    Object localObject2 = this.vhS.vhP;
    Object localObject3 = this.vhS.vhQ;
    float f = this.vhS.vhR;
    e locale = this.vhS.vhO;
    ab.i("MicroMsg.TransformToBagAniHelper", "doMaskAnimation bogPos x:%d, y:%d lastSwipePosX:%f", new Object[] { Integer.valueOf(((Point)localObject3).x), Integer.valueOf(((Point)localObject3).y), Float.valueOf(f) });
    if (((g)localObject2).getContentView() == null)
    {
      ab.w("MicroMsg.TransformToBagAniHelper", "doMaskAnimation getSwipeBackLayout null");
      locale.dfe();
      AppMethodBeat.o(8173);
      return;
    }
    ViewGroup localViewGroup = ((g)localObject2).bTL();
    Object localObject1 = d.eH(((g)localObject2).getContentView());
    localObject1 = new j(((g)localObject2).getActivity(), (Bitmap)localObject1);
    ((j)localObject1).setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
    int i = ((Point)localObject3).x;
    int j = ((Point)localObject3).y;
    int k = b.vho;
    int m = b.vhq / 2;
    ((j)localObject1).vid = i;
    ((j)localObject1).vie = (j + k);
    ((j)localObject1).vic = m;
    ((j)localObject1).setContentStartPosX((int)f);
    ((j)localObject1).setListener(new i.2((j)localObject1, locale));
    localViewGroup.addView((View)localObject1, localViewGroup.getChildCount());
    ((g)localObject2).getContentView().setVisibility(8);
    localObject2 = new LinearInterpolator();
    boolean bool;
    if (((j)localObject1).vif > 0)
    {
      bool = true;
      ((j)localObject1).uVw = bool;
      if (((j)localObject1).vif >= ((j)localObject1).vid) {
        break label549;
      }
      i = ((j)localObject1).vif;
      label304:
      localObject3 = PropertyValuesHolder.ofInt("canvasTranslationX", new int[] { ((j)localObject1).vif, i });
      i = ((j)localObject1).vid;
      if (((j)localObject1).uVw) {
        if (((j)localObject1).vif >= ((j)localObject1).vid) {
          break label558;
        }
      }
    }
    label549:
    label558:
    for (i = ((j)localObject1).vid - ((j)localObject1).vif;; i = 0)
    {
      localObject3 = ValueAnimator.ofPropertyValuesHolder(new PropertyValuesHolder[] { PropertyValuesHolder.ofInt("translationX", new int[] { 0, i }), PropertyValuesHolder.ofInt("translationY", new int[] { 0, ((j)localObject1).vie }), PropertyValuesHolder.ofFloat("scaleX", new float[] { 1.0F, 2.0F * ((j)localObject1).vic / ((j)localObject1).mWidth }), PropertyValuesHolder.ofFloat("scaleY", new float[] { 1.0F, 2.0F * ((j)localObject1).vic / ((j)localObject1).mHeight }), localObject3 });
      ((ValueAnimator)localObject3).setDuration(300L);
      ((ValueAnimator)localObject3).setInterpolator((TimeInterpolator)localObject2);
      ((ValueAnimator)localObject3).addUpdateListener(new j.1((j)localObject1));
      ((ValueAnimator)localObject3).addListener(new j.2((j)localObject1));
      ((ValueAnimator)localObject3).start();
      AppMethodBeat.o(8173);
      return;
      bool = false;
      break;
      i = ((j)localObject1).vid;
      break label304;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.ui.tools.bag.i.1.2
 * JD-Core Version:    0.7.0.1
 */