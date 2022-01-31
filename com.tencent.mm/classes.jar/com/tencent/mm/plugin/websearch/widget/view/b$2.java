package com.tencent.mm.plugin.websearch.widget.view;

import android.support.v4.view.ViewPager;
import android.support.v4.view.ViewPager.e;
import com.tencent.mm.cb.a;
import com.tencent.mm.plugin.websearch.api.WidgetData;
import com.tencent.mm.plugin.websearch.api.WidgetData.Style;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.s;
import java.util.List;

public final class b$2
  implements ViewPager.e
{
  public b$2(b paramb) {}
  
  public final void Q(int paramInt) {}
  
  public final void R(int paramInt)
  {
    int j = 1;
    y.i("ServiceWidgetView", "opPageSelected %d", new Object[] { Integer.valueOf(paramInt) });
    this.qXC.BK(paramInt);
    Object localObject = this.qXC;
    int i = 0;
    if (i < ((b)localObject).dataList.size())
    {
      c localc = ((b)localObject).qXy.BN(i);
      if (localc != null) {
        if (i != ((b)localObject).oGu.getCurrentItem()) {
          break label95;
        }
      }
      label95:
      for (boolean bool = true;; bool = false)
      {
        localc.setSelected(bool);
        i += 1;
        break;
      }
    }
    this.qXC.qXy.BN(paramInt).e((WidgetData)this.qXC.dataList.get(paramInt));
    localObject = this.qXC.qXy.BN(paramInt);
    if ((!((c)localObject).isLoading) && (((c)localObject).qXT == ((c)localObject).qXS)) {}
    for (i = j;; i = 0)
    {
      if (i != 0) {
        b.a(this.qXC);
      }
      this.qXC.BL(a.fromDPToPix(this.qXC.gfb.mController.uMN, ((WidgetData)this.qXC.dataList.get(paramInt)).qVp.height + 131));
      return;
    }
  }
  
  public final void a(int paramInt1, float paramFloat, int paramInt2) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.websearch.widget.view.b.2
 * JD-Core Version:    0.7.0.1
 */