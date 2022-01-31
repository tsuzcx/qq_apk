package com.tencent.mm.plugin.sns.ui.previewimageview;

import android.animation.ObjectAnimator;
import android.graphics.Color;
import android.graphics.Rect;
import android.os.Build.VERSION;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;
import java.util.ArrayList;
import java.util.HashMap;

final class e$1
  implements DynamicGridView.e
{
  e$1(e parame, DynamicGridView paramDynamicGridView) {}
  
  public final void Fn(int paramInt)
  {
    AppMethodBeat.i(40318);
    ab.i("DynamicGrid", "drag started at position ".concat(String.valueOf(paramInt)));
    if (Build.VERSION.SDK_INT >= 21)
    {
      this.skN.skF = this.skM.getElevation();
      this.skM.setElevation(100.0F);
    }
    for (;;)
    {
      Object localObject = this.skN;
      ((e)localObject).skG.setVisibility(0);
      localObject = ObjectAnimator.ofFloat(((e)localObject).skG, "translationY", new float[] { ((e)localObject).skG.getHeight(), 0.0F });
      ((ObjectAnimator)localObject).setDuration(200L);
      ((ObjectAnimator)localObject).start();
      e.a(this.skN);
      AppMethodBeat.o(40318);
      return;
      this.skM.bringToFront();
    }
  }
  
  public final void Fo(int paramInt)
  {
    AppMethodBeat.i(40319);
    ab.i("DynamicGrid", "drag to del ".concat(String.valueOf(paramInt)));
    c localc = this.skN.skC;
    Object localObject = localc.getItem(paramInt);
    localc.mItems.remove(localObject);
    localc.skt.remove(localObject);
    localc.notifyDataSetChanged();
    if (localc.sky != null)
    {
      int i = localc.sku;
      localc.sky.removeItem(paramInt - i);
    }
    AppMethodBeat.o(40319);
  }
  
  public final void cxc()
  {
    AppMethodBeat.i(40321);
    e locale = this.skN;
    ObjectAnimator localObjectAnimator = ObjectAnimator.ofFloat(locale.skG, "translationY", new float[] { 0.0F, locale.skG.getHeight() });
    localObjectAnimator.setDuration(200L);
    localObjectAnimator.addListener(new e.8(locale));
    localObjectAnimator.start();
    this.skN.skC.cwZ();
    AppMethodBeat.o(40321);
  }
  
  public final void m(Rect paramRect)
  {
    AppMethodBeat.i(40320);
    if (n(paramRect))
    {
      paramRect = this.skN;
      paramRect.skG.setBackgroundColor(Color.parseColor("#ce3c39"));
      paramRect.skH.setImageResource(2131232007);
      paramRect.rHh.setText("松手即可删除");
      AppMethodBeat.o(40320);
      return;
    }
    e.b(this.skN);
    AppMethodBeat.o(40320);
  }
  
  public final boolean n(Rect paramRect)
  {
    AppMethodBeat.i(40322);
    boolean bool = e.a(this.skN, paramRect);
    AppMethodBeat.o(40322);
    return bool;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.previewimageview.e.1
 * JD-Core Version:    0.7.0.1
 */