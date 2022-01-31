package com.tencent.mm.ui.conversation;

import android.app.Activity;
import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import com.tencent.mm.ag.d.a;
import com.tencent.mm.h.a.ad;
import com.tencent.mm.h.a.ae;
import com.tencent.mm.h.a.jl;
import com.tencent.mm.model.aq;
import com.tencent.mm.model.au;
import com.tencent.mm.model.b.b.b;
import com.tencent.mm.model.q;
import com.tencent.mm.network.n;
import com.tencent.mm.platformtools.ah;
import com.tencent.mm.pluginsdk.ui.b.b;
import com.tencent.mm.sdk.e.m;
import com.tencent.mm.sdk.e.m.b;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.ui.conversation.a.e;
import com.tencent.mm.ui.conversation.a.e.a;
import com.tencent.mm.ui.conversation.a.i;
import com.tencent.mm.ui.conversation.a.o;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public final class a
  implements d.a, aq, m.b
{
  Context context;
  n nIV;
  List<b> vOV = new LinkedList();
  List<b> vOW = new LinkedList();
  List<b> vOX = new LinkedList();
  List<b> vOY = new LinkedList();
  List<b> vOZ = new LinkedList();
  com.tencent.mm.sdk.b.c vPa;
  com.tencent.mm.sdk.b.c vPb;
  ListView vPc;
  View vPd;
  
  private void eo(List<b> paramList)
  {
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      b localb = (b)paramList.next();
      this.vPc.addHeaderView(localb.getView());
    }
  }
  
  private static void eq(List<b> paramList)
  {
    paramList = paramList.iterator();
    while (paramList.hasNext()) {
      ((b)paramList.next()).setVisibility(8);
    }
  }
  
  static void er(List<b> paramList)
  {
    paramList = paramList.iterator();
    while (paramList.hasNext()) {
      ((b)paramList.next()).release();
    }
  }
  
  static void es(List<b> paramList)
  {
    Iterator localIterator = paramList.iterator();
    while (localIterator.hasNext()) {
      ((b)localIterator.next()).destroy();
    }
    paramList.clear();
  }
  
  public final void Hn()
  {
    cHT();
  }
  
  public final void a(int paramInt, m paramm, Object paramObject)
  {
    if (au.DK())
    {
      au.Hx();
      if (paramm == com.tencent.mm.model.c.Dz())
      {
        paramInt = ah.aD(paramObject);
        if (8193 == paramInt) {
          cHT();
        }
        if (42 == paramInt) {
          cHT();
        }
      }
    }
  }
  
  public final void a(Context paramContext, ListView paramListView, View paramView)
  {
    this.context = paramContext;
    this.vPc = paramListView;
    this.vPd = paramView;
    this.vPb = new a.1(this);
    com.tencent.mm.sdk.b.a.udP.c(this.vPb);
    paramView = new ad();
    paramView.bGb.activity = ((Activity)paramContext);
    com.tencent.mm.sdk.b.a.udP.m(paramView);
    paramView = new ae();
    paramView.bGc.bGe = ((b)e.a(this.context, e.a.vUz, null));
    com.tencent.mm.sdk.b.a.udP.m(paramView);
    paramView = (b)e.a(this.context, e.a.vUt, null);
    ae localae = new ae();
    localae.bGc.bGe = paramView;
    localae.bGc.bGd = false;
    localae.bGc.level = 1;
    com.tencent.mm.sdk.b.a.udP.m(localae);
    paramView = (o)e.a(this.context, e.a.vUy, null);
    localae = new ae();
    localae.bGc.bGe = paramView;
    localae.bGc.bGd = false;
    localae.bGc.level = 2;
    com.tencent.mm.sdk.b.a.udP.m(localae);
    paramView = (com.tencent.mm.ui.conversation.a.a)e.a(this.context, e.a.vUv, null);
    localae = new ae();
    localae.bGc.bGe = paramView;
    localae.bGc.bGd = false;
    localae.bGc.level = 3;
    com.tencent.mm.sdk.b.a.udP.m(localae);
    paramView = (com.tencent.mm.ui.d.a)e.a(this.context, e.a.vUA, new Object[] { b.b.dYq });
    localae = new ae();
    localae.bGc.bGe = paramView;
    localae.bGc.bGd = true;
    com.tencent.mm.sdk.b.a.udP.m(localae);
    com.tencent.mm.sdk.b.a.udP.d(this.vPb);
    paramView = new LinkedList();
    paramView.addAll(this.vOV);
    paramView.addAll(this.vOW);
    paramView.addAll(this.vOX);
    paramView.addAll(this.vOY);
    Collections.sort(paramView, new a.2(this));
    eo(paramView);
    new LinkedList();
    paramView = (b)e.a(paramContext, e.a.vUu, null);
    if ((paramView != null) && (paramView.getView() != null)) {
      paramListView.addFooterView(paramView.getView());
    }
    this.vOZ.add(paramView);
    paramListView.addFooterView(new i(paramContext).getView(), null, true);
    this.vOZ.add(paramView);
    this.nIV = new a.3(this);
    au.a(this.nIV);
    this.vPa = new com.tencent.mm.sdk.b.c() {};
    com.tencent.mm.sdk.b.a.udP.c(this.vPa);
    au.Hx();
    com.tencent.mm.model.c.a(this);
    cHT();
  }
  
  public final void cHT()
  {
    int j = 1;
    if ((this.context == null) || (!au.DK())) {
      return;
    }
    y.i("MicroMsg.BannerHelper", "updateBanner, :%d", new Object[] { Integer.valueOf(hashCode()) });
    boolean bool1 = k(this.vOV, true);
    boolean bool2 = k(this.vOW, true);
    boolean bool3 = k(this.vOX, true);
    boolean bool4 = k(this.vOY, true);
    int i = j;
    if (!bool1)
    {
      i = j;
      if (!bool2)
      {
        i = j;
        if (!bool3)
        {
          if (!bool4) {
            break label206;
          }
          i = j;
        }
      }
    }
    label109:
    if (bool2)
    {
      eq(this.vOX);
      eq(this.vOY);
    }
    for (;;)
    {
      if ((i != 0) && (this.vPc.getVisibility() != 0))
      {
        this.vPc.setVisibility(0);
        this.vPd.setVisibility(8);
      }
      Iterator localIterator = this.vOZ.iterator();
      while (localIterator.hasNext())
      {
        b localb = (b)localIterator.next();
        if (localb != null) {
          localb.apu();
        }
      }
      break;
      label206:
      i = 0;
      break label109;
      if (bool3) {
        eq(this.vOY);
      }
    }
  }
  
  final void ep(List<b> paramList)
  {
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      b localb = (b)paramList.next();
      if (localb.getView() != null) {
        this.vPc.removeHeaderView(localb.getView());
      }
    }
  }
  
  final boolean k(List<b> paramList, boolean paramBoolean)
  {
    paramList = paramList.iterator();
    boolean bool = false;
    if (paramList.hasNext())
    {
      b localb = (b)paramList.next();
      View localView = ((ViewGroup)localb.getView()).getChildAt(0);
      if (localb.apu())
      {
        if ((localView != null) && (localView.getVisibility() == 0)) {}
        for (bool = true;; bool = false)
        {
          y.i("MicroMsg.BannerHelper", "refreshAndReturnIsVisible[true] :%s, checkAll:%b, isVisible:%b, hc:%d", new Object[] { localb, Boolean.valueOf(paramBoolean), Boolean.valueOf(bool), Integer.valueOf(hashCode()) });
          if (paramBoolean) {
            break;
          }
          return true;
        }
      }
      if ((localView != null) && (localView.getVisibility() == 0)) {
        y.i("MicroMsg.BannerHelper", "refreshAndReturnIsVisible[false] but visible :%s, checkAll:%b, hc:%d", new Object[] { localb, Boolean.valueOf(paramBoolean), Integer.valueOf(hashCode()) });
      }
    }
    for (;;)
    {
      break;
      return bool;
      bool = true;
    }
  }
  
  public final void kk(String paramString)
  {
    if ((au.DK()) && (!au.CW()) && (ah.pm(paramString).length() > 0) && (paramString.equals(q.Gj()))) {
      cHT();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.ui.conversation.a
 * JD-Core Version:    0.7.0.1
 */