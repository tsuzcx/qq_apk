package com.tencent.mm.plugin.websearch.widget.view;

import android.app.Activity;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import com.tencent.mm.cb.a;
import com.tencent.mm.h.b.a.t;
import com.tencent.mm.plugin.websearch.api.WidgetData;
import com.tencent.mm.plugin.websearch.api.WidgetData.Info;
import com.tencent.mm.plugin.websearch.api.WidgetData.Style;
import com.tencent.mm.plugin.websearch.api.g;
import com.tencent.mm.plugin.websearch.api.i;
import com.tencent.mm.plugin.websearch.api.q;
import com.tencent.mm.plugin.websearch.widget.d;
import com.tencent.mm.sdk.platformtools.ai;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.s;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public final class b
  implements i
{
  List<WidgetData> dataList;
  public LinearLayout fXV;
  public MMActivity gfb;
  g kCj;
  private int maxWidth;
  public ViewPager oGu;
  List<com.tencent.mm.plugin.websearch.api.y> qXA;
  c.b qXB = new b.1(this);
  public b.b qXy;
  public View qXz;
  
  public b(LinearLayout paramLinearLayout, int paramInt, Activity paramActivity, g paramg)
  {
    this.fXV = paramLinearLayout;
    this.gfb = ((MMActivity)paramActivity);
    this.maxWidth = paramInt;
    this.kCj = paramg;
  }
  
  private void cal()
  {
    int i = 0;
    while (i < this.qXy.getCount())
    {
      c localc = this.qXy.BN(i);
      if (localc != null) {
        localc.qXH.Rp(localc.qXI);
      }
      i += 1;
    }
  }
  
  final void BJ(int paramInt)
  {
    int i = this.oGu.getCurrentItem();
    WidgetData localWidgetData = (WidgetData)this.dataList.get(i);
    if ((paramInt < 0) || (paramInt > this.dataList.size() - 1))
    {
      com.tencent.mm.plugin.websearch.widget.f.a(3, localWidgetData, null);
      return;
    }
    com.tencent.mm.plugin.websearch.widget.f.a(2, localWidgetData, (WidgetData)this.dataList.get(paramInt));
    if (paramInt == this.dataList.indexOf(localWidgetData))
    {
      localObject = new t();
      ((t)localObject).cjG = localWidgetData.qVo.dZY;
      ((t)localObject).cjH = localWidgetData.qVo.dZY;
      ((t)localObject).cjF = 0L;
      ((t)localObject).cjD = localWidgetData.bVk;
      ((t)localObject).cjE = localWidgetData.qVr;
      ((t)localObject).QX();
      return;
    }
    com.tencent.mm.sdk.platformtools.y.i("ServiceWidgetView", "switch widget to %d", new Object[] { Integer.valueOf(paramInt) });
    Object localObject = (WidgetData)this.dataList.get(paramInt);
    t localt = new t();
    localt.cjG = localWidgetData.qVo.dZY;
    localt.cjH = ((WidgetData)localObject).qVo.dZY;
    localt.cjF = 1L;
    localt.cjD = ((WidgetData)localObject).bVk;
    localt.cjE = ((WidgetData)localObject).qVr;
    localt.QX();
    this.oGu.m(paramInt, true);
    BK(paramInt);
  }
  
  final void BK(int paramInt)
  {
    int i = 0;
    if (i < this.qXA.size())
    {
      com.tencent.mm.plugin.websearch.api.y localy = (com.tencent.mm.plugin.websearch.api.y)this.qXA.get(i);
      if (i == paramInt) {}
      for (localy.fmm = true;; localy.fmm = false)
      {
        i += 1;
        break;
      }
    }
  }
  
  final void BL(int paramInt)
  {
    com.tencent.mm.sdk.platformtools.y.i("ServiceWidgetView", "update viewpager height %d", new Object[] { Integer.valueOf(paramInt) });
    Object localObject = (WidgetData)this.dataList.get(this.oGu.getCurrentItem());
    int i = paramInt;
    if (localObject != null)
    {
      i = paramInt;
      if (!((WidgetData)localObject).qVo.qVA) {
        i = paramInt - a.fromDPToPix(this.gfb.mController.uMN, 46);
      }
    }
    localObject = (LinearLayout.LayoutParams)this.oGu.getLayoutParams();
    ((LinearLayout.LayoutParams)localObject).height = i;
    this.oGu.setLayoutParams((ViewGroup.LayoutParams)localObject);
  }
  
  public final void a(int paramInt, q paramq)
  {
    if ((paramq == this.qXy.BN(this.oGu.getCurrentItem())) && (paramInt != this.oGu.getHeight())) {
      ai.d(new b.3(this, paramInt));
    }
  }
  
  public final void bZl()
  {
    BJ(this.oGu.getCurrentItem() + 1);
  }
  
  public final void bZm()
  {
    this.oGu.setCurrentItem(this.oGu.getCurrentItem() - 1);
  }
  
  public final void c(List<WidgetData> paramList, String paramString1, String paramString2)
  {
    this.dataList = paramList;
    if ((paramList == null) || (paramList.isEmpty()))
    {
      BL(0);
      hide();
      cal();
      return;
    }
    Iterator localIterator = paramList.iterator();
    WidgetData localWidgetData;
    while (localIterator.hasNext())
    {
      localWidgetData = (WidgetData)localIterator.next();
      d.caf();
      if (!d.a(localWidgetData))
      {
        com.tencent.mm.sdk.platformtools.y.i("ServiceWidgetView", "widget forbidden %s", new Object[] { localWidgetData });
        localIterator.remove();
      }
    }
    if (paramList.isEmpty())
    {
      BL(0);
      hide();
      cal();
      return;
    }
    this.dataList = paramList;
    localIterator = paramList.iterator();
    while (localIterator.hasNext())
    {
      localWidgetData = (WidgetData)localIterator.next();
      if (localWidgetData != null)
      {
        localWidgetData.qVr = paramString1;
        localWidgetData.bVk = paramString2;
        i = localWidgetData.qVp.width;
        if (i != this.maxWidth)
        {
          localWidgetData.qVp.width = this.maxWidth;
          localWidgetData.qVp.height = (localWidgetData.qVp.height * this.maxWidth / i);
          localWidgetData.qVp.qVE = (localWidgetData.qVp.qVE * this.maxWidth / i);
        }
      }
    }
    com.tencent.mm.sdk.platformtools.y.i("ServiceWidgetView", "update with %s", new Object[] { paramList });
    this.qXy.iJQ = paramList;
    this.qXy.notifyDataSetChanged();
    if (this.qXA == null) {
      this.qXA = new ArrayList();
    }
    this.qXA.clear();
    int i = 0;
    if (i < this.dataList.size())
    {
      paramString1 = (WidgetData)this.dataList.get(i);
      if (paramString1 != null)
      {
        paramString2 = new com.tencent.mm.plugin.websearch.api.y();
        paramString2.iconUrl = paramString1.qVo.iconUrl;
        paramString2.title = paramString1.qVo.aVr;
        if (i != 0) {
          break label427;
        }
      }
      label427:
      for (boolean bool = true;; bool = false)
      {
        paramString2.fmm = bool;
        paramString2.desc = paramString1.qVo.label;
        this.qXA.add(paramString2);
        i += 1;
        break;
      }
    }
    this.oGu.m(0, false);
    i = 0;
    while (i < paramList.size())
    {
      paramString1 = this.qXy.BN(i);
      if (paramString1 != null) {
        paramString1.e((WidgetData)this.dataList.get(i));
      }
      i += 1;
    }
    BL(a.fromDPToPix(this.gfb.mController.uMN, ((WidgetData)this.dataList.get(0)).qVp.height + 131));
  }
  
  public final void hide()
  {
    this.fXV.setVisibility(8);
    this.qXz.setVisibility(8);
    c localc = this.qXy.BN(this.oGu.getCurrentItem());
    if ((localc != null) && (localc.qXS != null) && (localc.fmm)) {
      localc.onPause();
    }
  }
  
  public final void onDestroy()
  {
    c localc = this.qXy.BN(this.oGu.getCurrentItem());
    if ((localc != null) && (localc.qXS != null)) {
      localc.onDestroy();
    }
    this.fXV = null;
    this.gfb = null;
  }
  
  public final void onPause()
  {
    c localc = this.qXy.BN(this.oGu.getCurrentItem());
    if ((localc != null) && (localc.qXS != null)) {
      localc.onPause();
    }
  }
  
  public final void onResume()
  {
    c localc = this.qXy.BN(this.oGu.getCurrentItem());
    if ((localc != null) && (localc.qXS != null)) {
      localc.onResume();
    }
  }
  
  public final void show()
  {
    if ((this.dataList == null) || (this.dataList.isEmpty())) {}
    c localc;
    do
    {
      return;
      this.qXz.setVisibility(0);
      this.fXV.setVisibility(0);
      localc = this.qXy.BN(this.oGu.getCurrentItem());
    } while ((localc == null) || (localc.qXS == null) || (!localc.fmm));
    localc.onResume();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.websearch.widget.view.b
 * JD-Core Version:    0.7.0.1
 */