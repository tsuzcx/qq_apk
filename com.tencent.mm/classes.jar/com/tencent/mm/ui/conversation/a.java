package com.tencent.mm.ui.conversation;

import android.app.Activity;
import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.aj.p;
import com.tencent.mm.g.a.ai;
import com.tencent.mm.g.a.aj;
import com.tencent.mm.g.a.lg;
import com.tencent.mm.model.av;
import com.tencent.mm.model.az;
import com.tencent.mm.model.b.b.b;
import com.tencent.mm.model.u;
import com.tencent.mm.network.n.a;
import com.tencent.mm.sdk.e.n.b;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.au;
import com.tencent.mm.sdk.platformtools.au.a;
import com.tencent.mm.sdk.platformtools.bs;
import com.tencent.mm.storage.ae;
import com.tencent.mm.ui.conversation.a.j;
import com.tencent.mm.ui.conversation.a.r;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public final class a
  implements com.tencent.mm.aj.e.a, av, n.b
{
  List<com.tencent.mm.pluginsdk.ui.b.b> IAA;
  com.tencent.mm.sdk.b.c IAB;
  com.tencent.mm.sdk.b.c IAC;
  ListView IAD;
  View IAE;
  boolean IAF;
  List<com.tencent.mm.pluginsdk.ui.b.b> IAv;
  List<com.tencent.mm.pluginsdk.ui.b.b> IAw;
  List<com.tencent.mm.pluginsdk.ui.b.b> IAx;
  List<com.tencent.mm.pluginsdk.ui.b.b> IAy;
  List<com.tencent.mm.pluginsdk.ui.b.b> IAz;
  Context context;
  com.tencent.mm.network.n zVK;
  
  public a()
  {
    AppMethodBeat.i(38152);
    this.IAv = new LinkedList();
    this.IAw = new LinkedList();
    this.IAx = new LinkedList();
    this.IAy = new LinkedList();
    this.IAz = new LinkedList();
    this.IAA = new LinkedList();
    this.IAF = false;
    AppMethodBeat.o(38152);
  }
  
  private static void it(List<com.tencent.mm.pluginsdk.ui.b.b> paramList)
  {
    AppMethodBeat.i(38161);
    paramList = paramList.iterator();
    while (paramList.hasNext()) {
      ((com.tencent.mm.pluginsdk.ui.b.b)paramList.next()).setVisibility(8);
    }
    AppMethodBeat.o(38161);
  }
  
  private static void iu(List<com.tencent.mm.pluginsdk.ui.b.b> paramList)
  {
    AppMethodBeat.i(38162);
    paramList = paramList.iterator();
    while (paramList.hasNext()) {
      ((com.tencent.mm.pluginsdk.ui.b.b)paramList.next()).release();
    }
    AppMethodBeat.o(38162);
  }
  
  static void iv(List<com.tencent.mm.pluginsdk.ui.b.b> paramList)
  {
    AppMethodBeat.i(38163);
    Iterator localIterator = paramList.iterator();
    while (localIterator.hasNext()) {
      ((com.tencent.mm.pluginsdk.ui.b.b)localIterator.next()).destroy();
    }
    paramList.clear();
    AppMethodBeat.o(38163);
  }
  
  public final void Af(String paramString)
  {
    AppMethodBeat.i(38156);
    if ((az.agM()) && (!az.afS()) && (bs.nullAsNil(paramString).length() > 0) && (paramString.equals(u.axw()))) {
      frL();
    }
    AppMethodBeat.o(38156);
  }
  
  public final void a(int paramInt, com.tencent.mm.sdk.e.n paramn, Object paramObject)
  {
    AppMethodBeat.i(38157);
    if (az.agM())
    {
      az.ayM();
      if (paramn == com.tencent.mm.model.c.agA())
      {
        paramInt = bs.l(paramObject, 0);
        if (8193 == paramInt) {
          frL();
        }
        if (42 == paramInt) {
          frL();
        }
      }
    }
    AppMethodBeat.o(38157);
  }
  
  public final void a(Context paramContext, ListView paramListView, View paramView)
  {
    AppMethodBeat.i(38153);
    this.context = paramContext;
    this.IAD = paramListView;
    this.IAE = paramView;
    this.IAC = new com.tencent.mm.sdk.b.c() {};
    com.tencent.mm.sdk.b.a.GpY.c(this.IAC);
    paramView = new ai();
    paramView.cZB.activity = ((Activity)paramContext);
    com.tencent.mm.sdk.b.a.GpY.l(paramView);
    paramView = new aj();
    paramView.cZC.cZD = ((com.tencent.mm.pluginsdk.ui.b.b)com.tencent.mm.ui.conversation.a.e.a(this.context, com.tencent.mm.ui.conversation.a.e.a.IHc, null));
    com.tencent.mm.sdk.b.a.GpY.l(paramView);
    paramView = (com.tencent.mm.pluginsdk.ui.b.b)com.tencent.mm.ui.conversation.a.e.a(this.context, com.tencent.mm.ui.conversation.a.e.a.IGT, null);
    Object localObject = new aj();
    ((aj)localObject).cZC.cZD = paramView;
    ((aj)localObject).cZC.level = 1;
    com.tencent.mm.sdk.b.a.GpY.l((com.tencent.mm.sdk.b.b)localObject);
    paramView = (com.tencent.mm.pluginsdk.ui.b.b)com.tencent.mm.ui.conversation.a.e.a(this.context, com.tencent.mm.ui.conversation.a.e.a.IGW, null);
    localObject = new aj();
    ((aj)localObject).cZC.cZD = paramView;
    ((aj)localObject).cZC.level = 1;
    com.tencent.mm.sdk.b.a.GpY.l((com.tencent.mm.sdk.b.b)localObject);
    paramView = (com.tencent.mm.pluginsdk.ui.b.b)com.tencent.mm.ui.conversation.a.e.a(this.context, com.tencent.mm.ui.conversation.a.e.a.IGU, null);
    localObject = new aj();
    ((aj)localObject).cZC.cZD = paramView;
    ((aj)localObject).cZC.independent = false;
    ((aj)localObject).cZC.level = 1;
    com.tencent.mm.sdk.b.a.GpY.l((com.tencent.mm.sdk.b.b)localObject);
    paramView = (r)com.tencent.mm.ui.conversation.a.e.a(this.context, com.tencent.mm.ui.conversation.a.e.a.IHb, null);
    localObject = new aj();
    ((aj)localObject).cZC.cZD = paramView;
    ((aj)localObject).cZC.independent = false;
    ((aj)localObject).cZC.level = 2;
    com.tencent.mm.sdk.b.a.GpY.l((com.tencent.mm.sdk.b.b)localObject);
    paramView = (com.tencent.mm.ui.conversation.a.a)com.tencent.mm.ui.conversation.a.e.a(this.context, com.tencent.mm.ui.conversation.a.e.a.IGY, null);
    localObject = new aj();
    ((aj)localObject).cZC.cZD = paramView;
    ((aj)localObject).cZC.independent = false;
    ((aj)localObject).cZC.level = 3;
    com.tencent.mm.sdk.b.a.GpY.l((com.tencent.mm.sdk.b.b)localObject);
    paramView = (com.tencent.mm.ui.d.a)com.tencent.mm.ui.conversation.a.e.a(this.context, com.tencent.mm.ui.conversation.a.e.a.IHd, new Object[] { b.b.hqw });
    localObject = new aj();
    ((aj)localObject).cZC.cZD = paramView;
    ((aj)localObject).cZC.independent = true;
    com.tencent.mm.sdk.b.a.GpY.l((com.tencent.mm.sdk.b.b)localObject);
    paramView = (com.tencent.mm.pluginsdk.ui.b.b)com.tencent.mm.ui.conversation.a.e.a(this.context, com.tencent.mm.ui.conversation.a.e.a.IGV, null);
    localObject = new aj();
    ((aj)localObject).cZC.cZD = paramView;
    ((aj)localObject).cZC.independent = false;
    ((aj)localObject).cZC.level = 1;
    com.tencent.mm.sdk.b.a.GpY.l((com.tencent.mm.sdk.b.b)localObject);
    com.tencent.mm.sdk.b.a.GpY.d(this.IAC);
    this.IAA.addAll(this.IAv);
    this.IAA.addAll(this.IAw);
    this.IAA.addAll(this.IAx);
    this.IAA.addAll(this.IAy);
    Collections.sort(this.IAA, new Comparator() {});
    paramView = this.IAA.iterator();
    while (paramView.hasNext())
    {
      localObject = (com.tencent.mm.pluginsdk.ui.b.b)paramView.next();
      this.IAD.addHeaderView(((com.tencent.mm.pluginsdk.ui.b.b)localObject).getView());
    }
    new LinkedList();
    paramView = (com.tencent.mm.pluginsdk.ui.b.b)com.tencent.mm.ui.conversation.a.e.a(paramContext, com.tencent.mm.ui.conversation.a.e.a.IGX, null);
    if ((paramView != null) && (paramView.getView() != null)) {
      paramListView.addFooterView(paramView.getView());
    }
    this.IAz.add(paramView);
    paramListView.addFooterView(new j(paramContext).getView(), null, true);
    this.IAz.add(paramView);
    this.zVK = new n.a()
    {
      private final au IAH;
      
      public final void onNetworkChange(int paramAnonymousInt)
      {
        AppMethodBeat.i(38150);
        if (this.IAH != null) {
          this.IAH.au(10L, 10L);
        }
        AppMethodBeat.o(38150);
      }
    };
    az.a(this.zVK);
    this.IAB = new com.tencent.mm.sdk.b.c() {};
    com.tencent.mm.sdk.b.a.GpY.c(this.IAB);
    az.ayM();
    com.tencent.mm.model.c.a(this);
    frL();
    AppMethodBeat.o(38153);
  }
  
  public final void ayD()
  {
    AppMethodBeat.i(38158);
    frL();
    AppMethodBeat.o(38158);
  }
  
  public final void feB()
  {
    AppMethodBeat.i(38154);
    ac.i("MicroMsg.BannerHelper", "releaseBanner");
    if (!this.IAF)
    {
      AppMethodBeat.o(38154);
      return;
    }
    this.IAF = false;
    iu(this.IAv);
    iu(this.IAw);
    iu(this.IAx);
    iu(this.IAy);
    Iterator localIterator = this.IAz.iterator();
    while (localIterator.hasNext())
    {
      com.tencent.mm.pluginsdk.ui.b.b localb = (com.tencent.mm.pluginsdk.ui.b.b)localIterator.next();
      if (localb != null) {
        localb.release();
      }
    }
    if (az.agM()) {
      p.aBh().e(this);
    }
    if (az.agM())
    {
      az.ayM();
      com.tencent.mm.model.c.agA().b(this);
    }
    AppMethodBeat.o(38154);
  }
  
  public final void frL()
  {
    AppMethodBeat.i(38155);
    if ((this.context == null) || (!az.agM()))
    {
      AppMethodBeat.o(38155);
      return;
    }
    ac.i("MicroMsg.BannerHelper", "updateBanner, :%d", new Object[] { Integer.valueOf(hashCode()) });
    boolean bool1 = r(this.IAv, true);
    boolean bool2 = r(this.IAw, true);
    boolean bool3 = r(this.IAx, true);
    boolean bool4 = r(this.IAy, true);
    int i;
    if ((bool1) || (bool2) || (bool3) || (bool4))
    {
      i = 1;
      if (!bool2) {
        break label233;
      }
      it(this.IAx);
      it(this.IAy);
    }
    Object localObject2;
    for (;;)
    {
      localObject1 = new LinkedList();
      localObject2 = this.IAA.iterator();
      while (((Iterator)localObject2).hasNext())
      {
        com.tencent.mm.pluginsdk.ui.b.b localb = (com.tencent.mm.pluginsdk.ui.b.b)((Iterator)localObject2).next();
        if (localb != null)
        {
          View localView = ((ViewGroup)localb.getView()).getChildAt(0);
          if ((localView != null) && (localView.getVisibility() == 0))
          {
            localb.isFirst = false;
            localb.gRm = false;
            ((List)localObject1).add(localb);
          }
        }
      }
      i = 0;
      break;
      label233:
      if (bool3) {
        it(this.IAy);
      }
    }
    if (((List)localObject1).size() > 0)
    {
      ((com.tencent.mm.pluginsdk.ui.b.b)((LinkedList)localObject1).getFirst()).isFirst = true;
      ((com.tencent.mm.pluginsdk.ui.b.b)((LinkedList)localObject1).getLast()).gRm = true;
      localObject1 = ((List)localObject1).iterator();
      while (((Iterator)localObject1).hasNext()) {
        ((com.tencent.mm.pluginsdk.ui.b.b)((Iterator)localObject1).next()).bvU();
      }
    }
    if ((i != 0) && (this.IAD.getVisibility() != 0))
    {
      this.IAD.setVisibility(0);
      this.IAE.setVisibility(8);
    }
    Object localObject1 = this.IAz.iterator();
    while (((Iterator)localObject1).hasNext())
    {
      localObject2 = (com.tencent.mm.pluginsdk.ui.b.b)((Iterator)localObject1).next();
      if (localObject2 != null) {
        ((com.tencent.mm.pluginsdk.ui.b.b)localObject2).bvU();
      }
    }
    AppMethodBeat.o(38155);
  }
  
  final void is(List<com.tencent.mm.pluginsdk.ui.b.b> paramList)
  {
    AppMethodBeat.i(38159);
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      com.tencent.mm.pluginsdk.ui.b.b localb = (com.tencent.mm.pluginsdk.ui.b.b)paramList.next();
      if (localb.getView() != null) {
        this.IAD.removeHeaderView(localb.getView());
      }
    }
    AppMethodBeat.o(38159);
  }
  
  final boolean r(List<com.tencent.mm.pluginsdk.ui.b.b> paramList, boolean paramBoolean)
  {
    AppMethodBeat.i(38160);
    paramList = paramList.iterator();
    boolean bool = false;
    if (paramList.hasNext())
    {
      com.tencent.mm.pluginsdk.ui.b.b localb = (com.tencent.mm.pluginsdk.ui.b.b)paramList.next();
      View localView = ((ViewGroup)localb.getView()).getChildAt(0);
      if (localb.bvU())
      {
        if ((localView != null) && (localView.getVisibility() == 0)) {}
        for (bool = true;; bool = false)
        {
          ac.i("MicroMsg.BannerHelper", "refreshAndReturnIsVisible[true] :%s, checkAll:%b, isVisible:%b, hc:%d", new Object[] { localb, Boolean.valueOf(paramBoolean), Boolean.valueOf(bool), Integer.valueOf(hashCode()) });
          if (paramBoolean) {
            break;
          }
          AppMethodBeat.o(38160);
          return true;
        }
      }
      if ((localView != null) && (localView.getVisibility() == 0)) {
        ac.i("MicroMsg.BannerHelper", "refreshAndReturnIsVisible[false] but visible :%s, checkAll:%b, hc:%d", new Object[] { localb, Boolean.valueOf(paramBoolean), Integer.valueOf(hashCode()) });
      }
    }
    for (;;)
    {
      break;
      AppMethodBeat.o(38160);
      return bool;
      bool = true;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.ui.conversation.a
 * JD-Core Version:    0.7.0.1
 */