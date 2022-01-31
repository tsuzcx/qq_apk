package com.tencent.mm.plugin.websearch.widget.view;

import android.view.View;
import android.widget.LinearLayout;
import com.tencent.mm.cb.a;
import com.tencent.mm.modelappbrand.u;
import com.tencent.mm.plugin.websearch.api.WidgetData;
import com.tencent.mm.plugin.websearch.api.f;
import com.tencent.mm.plugin.websearch.api.i;
import com.tencent.mm.plugin.websearch.api.r;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.s;

final class c$3
  implements r
{
  c$3(c paramc) {}
  
  public final void Rr(String paramString)
  {
    if (paramString.equals(this.qXZ.qXI)) {
      c.c(this.qXZ);
    }
  }
  
  public final void a(String paramString1, boolean paramBoolean, String paramString2, String paramString3)
  {
    u.i("WidgetView", "on tap callback eventId %s, consume %b, errMsg %s", new Object[] { paramString1, Boolean.valueOf(paramBoolean), paramString2 });
    if ((paramString3.equals(this.qXZ.qXI)) && (paramString1.equals(this.qXZ.qXJ)))
    {
      if (paramBoolean) {
        break label75;
      }
      c.b(this.qXZ);
    }
    for (;;)
    {
      this.qXZ.qXJ = null;
      return;
      label75:
      y.i("WidgetView", "click event %s consumed by widget", new Object[] { this.qXZ.qXJ });
    }
  }
  
  public final void addView(View paramView)
  {
    this.qXZ.qXG.removeAllViews();
    this.qXZ.qXG.addView(paramView);
  }
  
  public final void bZn()
  {
    c.c(this.qXZ);
  }
  
  public final void cJ(String paramString, int paramInt)
  {
    if (paramInt == 3)
    {
      if (this.qXZ.iHI) {
        break label112;
      }
      this.qXZ.qXF.setVisibility(0);
      this.qXZ.qXG.setVisibility(8);
      this.qXZ.qXL.setVisibility(8);
    }
    for (;;)
    {
      if (paramInt != 1)
      {
        this.qXZ.isLoading = false;
        if (this.qXZ.qXB != null) {
          this.qXZ.qXB.a(this.qXZ);
        }
        if (!this.qXZ.fmm) {
          this.qXZ.qXH.onPause();
        }
      }
      return;
      label112:
      this.qXZ.qXF.setVisibility(8);
      this.qXZ.qXG.setVisibility(8);
      this.qXZ.qXW.setVisibility(0);
      this.qXZ.qXL.setVisibility(8);
    }
  }
  
  public final void cK(String paramString, int paramInt)
  {
    this.qXZ.qXS.qVp.height = paramInt;
    this.qXZ.qXH.a(this.qXZ.qXS, this.qXZ.qXI);
    this.qXZ.kBU.a(a.fromDPToPix(this.qXZ.gfb.mController.uMN, paramInt + 131), this.qXZ);
  }
  
  public final void e(String paramString1, boolean paramBoolean, String paramString2)
  {
    a(paramString1, paramBoolean, "", paramString2);
  }
  
  public final void fo(String paramString1, String paramString2)
  {
    y.i("WidgetView", "onSearchWAWidgetDataPush %s", new Object[] { paramString1 });
  }
  
  public final void g(String paramString1, String paramString2, String paramString3, int paramInt)
  {
    if (paramString1.equals(this.qXZ.qXI))
    {
      this.qXZ.H(paramString2, paramString3, paramInt);
      return;
    }
    y.e("WidgetView", "callback for expired widget %s", new Object[] { paramString1 });
  }
  
  public final void removeView(View paramView)
  {
    this.qXZ.qXG.removeAllViews();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.websearch.widget.view.c.3
 * JD-Core Version:    0.7.0.1
 */