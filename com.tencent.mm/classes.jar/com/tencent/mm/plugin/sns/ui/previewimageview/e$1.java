package com.tencent.mm.plugin.sns.ui.previewimageview;

import android.animation.ObjectAnimator;
import android.graphics.Color;
import android.graphics.Rect;
import android.os.Build.VERSION;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mm.plugin.sns.i.i;
import com.tencent.mm.sdk.platformtools.y;
import java.util.ArrayList;
import java.util.HashMap;

final class e$1
  implements DynamicGridView.e
{
  e$1(e parame, DynamicGridView paramDynamicGridView) {}
  
  public final void bKp()
  {
    e locale = this.ppV;
    ObjectAnimator localObjectAnimator = ObjectAnimator.ofFloat(locale.ppO, "translationY", new float[] { 0.0F, locale.ppO.getHeight() });
    localObjectAnimator.setDuration(200L);
    localObjectAnimator.addListener(new e.8(locale));
    localObjectAnimator.start();
    this.ppV.ppK.bKm();
  }
  
  public final void k(Rect paramRect)
  {
    if (l(paramRect))
    {
      paramRect = this.ppV;
      paramRect.ppO.setBackgroundColor(Color.parseColor("#ce3c39"));
      paramRect.ppP.setImageResource(i.i.sns_img_highlight_delete);
      paramRect.oPv.setText("松手即可删除");
      return;
    }
    e.b(this.ppV);
  }
  
  public final boolean l(Rect paramRect)
  {
    e locale = this.ppV;
    if (paramRect == null) {
      return false;
    }
    if (locale.ppT == null) {
      locale.ppT = new Rect(locale.ppO.getLeft(), locale.ppO.getTop(), locale.ppO.getRight(), locale.ppO.getBottom());
    }
    y.d("DynamicGrid", "del area " + locale.ppT + ", test rect " + paramRect);
    return locale.ppT.intersects(paramRect.left, paramRect.top, paramRect.right, paramRect.bottom);
  }
  
  public final void zc(int paramInt)
  {
    y.i("DynamicGrid", "drag started at position " + paramInt);
    if (Build.VERSION.SDK_INT >= 21)
    {
      this.ppV.ppN = this.ppU.getElevation();
      this.ppU.setElevation(100.0F);
    }
    for (;;)
    {
      Object localObject = this.ppV;
      ((e)localObject).ppO.setVisibility(0);
      localObject = ObjectAnimator.ofFloat(((e)localObject).ppO, "translationY", new float[] { ((e)localObject).ppO.getHeight(), 0.0F });
      ((ObjectAnimator)localObject).setDuration(200L);
      ((ObjectAnimator)localObject).start();
      e.a(this.ppV);
      return;
      this.ppU.bringToFront();
    }
  }
  
  public final void zd(int paramInt)
  {
    y.i("DynamicGrid", "drag to del " + paramInt);
    c localc = this.ppV.ppK;
    Object localObject = localc.getItem(paramInt);
    localc.dU.remove(localObject);
    localc.ppB.remove(localObject);
    localc.notifyDataSetChanged();
    if (localc.ppG != null)
    {
      int i = localc.ppC;
      localc.ppG.removeItem(paramInt - i);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.previewimageview.e.1
 * JD-Core Version:    0.7.0.1
 */