package com.tencent.mm.plugin.websearch.widget.view;

import android.support.v4.view.ViewPager;
import android.support.v4.view.ViewPager.OnPageChangeListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.cb.a;
import com.tencent.mm.plugin.websearch.api.WidgetData;
import com.tencent.mm.plugin.websearch.api.WidgetData.Style;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.ui.MMActivity;
import java.util.List;

public final class ServiceWidgetView$2
  implements ViewPager.OnPageChangeListener
{
  public ServiceWidgetView$2(ServiceWidgetView paramServiceWidgetView) {}
  
  public final void onPageScrollStateChanged(int paramInt) {}
  
  public final void onPageScrolled(int paramInt1, float paramFloat, int paramInt2) {}
  
  public final void onPageSelected(int paramInt)
  {
    int j = 1;
    AppMethodBeat.i(91482);
    ab.i("ServiceWidgetView", "opPageSelected %d", new Object[] { Integer.valueOf(paramInt) });
    this.uMQ.JC(paramInt);
    Object localObject = this.uMQ;
    int i = 0;
    if (i < ((ServiceWidgetView)localObject).dataList.size())
    {
      b localb = ((ServiceWidgetView)localObject).uMN.JF(i);
      if (localb != null) {
        if (i != ((ServiceWidgetView)localObject).rwj.getCurrentItem()) {
          break label100;
        }
      }
      label100:
      for (boolean bool = true;; bool = false)
      {
        localb.setSelected(bool);
        i += 1;
        break;
      }
    }
    this.uMQ.uMN.JF(paramInt).e((WidgetData)this.uMQ.dataList.get(paramInt));
    localObject = this.uMQ.uMN.JF(paramInt);
    if ((!((b)localObject).isLoading) && (((b)localObject).uNh == ((b)localObject).uNg)) {}
    for (i = j;; i = 0)
    {
      if (i != 0) {
        ServiceWidgetView.a(this.uMQ);
      }
      this.uMQ.JD(a.fromDPToPix(this.uMQ.hwZ.getContext(), ((WidgetData)this.uMQ.dataList.get(paramInt)).uKB.height + 131));
      AppMethodBeat.o(91482);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.websearch.widget.view.ServiceWidgetView.2
 * JD-Core Version:    0.7.0.1
 */