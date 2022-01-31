package com.tencent.mm.plugin.websearch.widget.view;

import android.app.Activity;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.cb.a;
import com.tencent.mm.g.b.a.ah;
import com.tencent.mm.plugin.websearch.api.WidgetData;
import com.tencent.mm.plugin.websearch.api.WidgetData.Info;
import com.tencent.mm.plugin.websearch.api.WidgetData.Style;
import com.tencent.mm.plugin.websearch.api.g;
import com.tencent.mm.plugin.websearch.api.i;
import com.tencent.mm.plugin.websearch.api.q;
import com.tencent.mm.plugin.websearch.api.y;
import com.tencent.mm.plugin.websearch.widget.d;
import com.tencent.mm.plugin.websearch.widget.f;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.al;
import com.tencent.mm.ui.MMActivity;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public final class ServiceWidgetView
  implements i
{
  List<WidgetData> dataList;
  public View hrR;
  public MMActivity hwZ;
  public LinearLayout jja;
  g mYf;
  private int maxWidth;
  public ViewPager rwj;
  public ServiceWidgetView.a uMN;
  List<y> uMO;
  b.b uMP;
  
  public ServiceWidgetView(LinearLayout paramLinearLayout, int paramInt, Activity paramActivity, g paramg)
  {
    AppMethodBeat.i(91496);
    this.uMP = new ServiceWidgetView.1(this);
    this.jja = paramLinearLayout;
    this.hwZ = ((MMActivity)paramActivity);
    this.maxWidth = paramInt;
    this.mYf = paramg;
    AppMethodBeat.o(91496);
  }
  
  private void dag()
  {
    AppMethodBeat.i(91500);
    int i = 0;
    while (i < this.uMN.getCount())
    {
      b localb = this.uMN.JF(i);
      if (localb != null) {
        localb.bdM();
      }
      i += 1;
    }
    AppMethodBeat.o(91500);
  }
  
  final void JB(int paramInt)
  {
    AppMethodBeat.i(91497);
    int i = this.rwj.getCurrentItem();
    Object localObject1 = (WidgetData)this.dataList.get(i);
    if ((paramInt < 0) || (paramInt > this.dataList.size() - 1))
    {
      f.a(3, (WidgetData)localObject1, null);
      AppMethodBeat.o(91497);
      return;
    }
    f.a(2, (WidgetData)localObject1, (WidgetData)this.dataList.get(paramInt));
    if (paramInt == this.dataList.indexOf(localObject1))
    {
      localObject2 = new ah().fJ(((WidgetData)localObject1).uKA.fqf).fK(((WidgetData)localObject1).uKA.fqf);
      ((ah)localObject2).cUt = 0L;
      ((ah)localObject2).fH(((WidgetData)localObject1).query).fI(((WidgetData)localObject1).uKD).ake();
      AppMethodBeat.o(91497);
      return;
    }
    ab.i("ServiceWidgetView", "switch widget to %d", new Object[] { Integer.valueOf(paramInt) });
    Object localObject2 = (WidgetData)this.dataList.get(paramInt);
    localObject1 = new ah().fJ(((WidgetData)localObject1).uKA.fqf).fK(((WidgetData)localObject2).uKA.fqf);
    ((ah)localObject1).cUt = 1L;
    ((ah)localObject1).fH(((WidgetData)localObject2).query).fI(((WidgetData)localObject2).uKD).ake();
    this.rwj.setCurrentItem(paramInt, true);
    JC(paramInt);
    AppMethodBeat.o(91497);
  }
  
  final void JC(int paramInt)
  {
    AppMethodBeat.i(91498);
    int i = 0;
    if (i < this.uMO.size())
    {
      y localy = (y)this.uMO.get(i);
      if (i == paramInt) {}
      for (localy.gDG = true;; localy.gDG = false)
      {
        i += 1;
        break;
      }
    }
    AppMethodBeat.o(91498);
  }
  
  final void JD(int paramInt)
  {
    AppMethodBeat.i(91504);
    ab.i("ServiceWidgetView", "update viewpager height %d", new Object[] { Integer.valueOf(paramInt) });
    Object localObject = (WidgetData)this.dataList.get(this.rwj.getCurrentItem());
    int i = paramInt;
    if (localObject != null)
    {
      i = paramInt;
      if (!((WidgetData)localObject).uKA.uKM) {
        i = paramInt - a.fromDPToPix(this.hwZ.getContext(), 46);
      }
    }
    localObject = (LinearLayout.LayoutParams)this.rwj.getLayoutParams();
    ((LinearLayout.LayoutParams)localObject).height = i;
    this.rwj.setLayoutParams((ViewGroup.LayoutParams)localObject);
    AppMethodBeat.o(91504);
  }
  
  public final void a(int paramInt, q paramq)
  {
    AppMethodBeat.i(91503);
    if ((paramq == this.uMN.JF(this.rwj.getCurrentItem())) && (paramInt != this.rwj.getHeight())) {
      al.d(new ServiceWidgetView.3(this, paramInt));
    }
    AppMethodBeat.o(91503);
  }
  
  public final void cZf()
  {
    AppMethodBeat.i(91501);
    JB(this.rwj.getCurrentItem() + 1);
    AppMethodBeat.o(91501);
  }
  
  public final void cZg()
  {
    AppMethodBeat.i(91502);
    this.rwj.setCurrentItem(this.rwj.getCurrentItem() - 1);
    AppMethodBeat.o(91502);
  }
  
  public final void d(List<WidgetData> paramList, String paramString1, String paramString2)
  {
    AppMethodBeat.i(91499);
    this.dataList = paramList;
    if ((paramList == null) || (paramList.isEmpty()))
    {
      JD(0);
      hide();
      dag();
      AppMethodBeat.o(91499);
      return;
    }
    Iterator localIterator = paramList.iterator();
    WidgetData localWidgetData;
    while (localIterator.hasNext())
    {
      localWidgetData = (WidgetData)localIterator.next();
      d.dab();
      if (!d.a(localWidgetData))
      {
        ab.i("ServiceWidgetView", "widget forbidden %s", new Object[] { localWidgetData });
        localIterator.remove();
      }
    }
    if (paramList.isEmpty())
    {
      JD(0);
      hide();
      dag();
      AppMethodBeat.o(91499);
      return;
    }
    this.dataList = paramList;
    localIterator = paramList.iterator();
    while (localIterator.hasNext())
    {
      localWidgetData = (WidgetData)localIterator.next();
      if (localWidgetData != null)
      {
        localWidgetData.uKD = paramString1;
        localWidgetData.query = paramString2;
        i = localWidgetData.uKB.width;
        if (i != this.maxWidth)
        {
          localWidgetData.uKB.width = this.maxWidth;
          localWidgetData.uKB.height = (localWidgetData.uKB.height * this.maxWidth / i);
          localWidgetData.uKB.uKQ = (localWidgetData.uKB.uKQ * this.maxWidth / i);
        }
      }
    }
    ab.i("ServiceWidgetView", "update with %s", new Object[] { paramList });
    this.uMN.kQw = paramList;
    this.uMN.notifyDataSetChanged();
    if (this.uMO == null) {
      this.uMO = new ArrayList();
    }
    this.uMO.clear();
    int i = 0;
    if (i < this.dataList.size())
    {
      paramString1 = (WidgetData)this.dataList.get(i);
      if (paramString1 != null)
      {
        paramString2 = new y();
        paramString2.iconUrl = paramString1.uKA.iconUrl;
        paramString2.title = paramString1.uKA.blZ;
        if (i != 0) {
          break label442;
        }
      }
      label442:
      for (boolean bool = true;; bool = false)
      {
        paramString2.gDG = bool;
        paramString2.desc = paramString1.uKA.label;
        this.uMO.add(paramString2);
        i += 1;
        break;
      }
    }
    this.rwj.setCurrentItem(0, false);
    i = 0;
    while (i < paramList.size())
    {
      paramString1 = this.uMN.JF(i);
      if (paramString1 != null) {
        paramString1.e((WidgetData)this.dataList.get(i));
      }
      i += 1;
    }
    JD(a.fromDPToPix(this.hwZ.getContext(), ((WidgetData)this.dataList.get(0)).uKB.height + 131));
    AppMethodBeat.o(91499);
  }
  
  public final void hide()
  {
    AppMethodBeat.i(91505);
    this.jja.setVisibility(8);
    this.hrR.setVisibility(8);
    b localb = this.uMN.JF(this.rwj.getCurrentItem());
    if ((localb != null) && (localb.uNg != null)) {
      localb.hide();
    }
    AppMethodBeat.o(91505);
  }
  
  public final void onDestroy()
  {
    AppMethodBeat.i(91509);
    b localb = this.uMN.JF(this.rwj.getCurrentItem());
    if ((localb != null) && (localb.uNg != null)) {
      localb.onDestroy();
    }
    this.jja = null;
    this.hwZ = null;
    AppMethodBeat.o(91509);
  }
  
  public final void onPause()
  {
    AppMethodBeat.i(91508);
    b localb = this.uMN.JF(this.rwj.getCurrentItem());
    if ((localb != null) && (localb.uNg != null)) {
      localb.onPause();
    }
    AppMethodBeat.o(91508);
  }
  
  public final void onResume()
  {
    AppMethodBeat.i(91507);
    b localb = this.uMN.JF(this.rwj.getCurrentItem());
    if ((localb != null) && (localb.uNg != null)) {
      localb.onResume();
    }
    AppMethodBeat.o(91507);
  }
  
  public final void show()
  {
    AppMethodBeat.i(91506);
    if ((this.dataList == null) || (this.dataList.isEmpty()))
    {
      AppMethodBeat.o(91506);
      return;
    }
    this.hrR.setVisibility(0);
    this.jja.setVisibility(0);
    b localb = this.uMN.JF(this.rwj.getCurrentItem());
    if ((localb != null) && (localb.uNg != null) && (localb.gDG)) {
      localb.onResume();
    }
    AppMethodBeat.o(91506);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.websearch.widget.view.ServiceWidgetView
 * JD-Core Version:    0.7.0.1
 */