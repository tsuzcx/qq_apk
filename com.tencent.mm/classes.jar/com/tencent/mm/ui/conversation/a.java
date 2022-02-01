package com.tencent.mm.ui.conversation;

import android.app.Activity;
import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.aj.p;
import com.tencent.mm.g.a.ai;
import com.tencent.mm.g.a.lq;
import com.tencent.mm.model.ay;
import com.tencent.mm.model.b.b.b;
import com.tencent.mm.model.bc;
import com.tencent.mm.model.v;
import com.tencent.mm.network.n.a;
import com.tencent.mm.sdk.e.n.b;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.aw;
import com.tencent.mm.sdk.platformtools.aw.a;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.ui.conversation.a.j;
import com.tencent.mm.ui.conversation.a.r;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public final class a
  implements com.tencent.mm.aj.e.a, ay, n.b
{
  com.tencent.mm.network.n BEN;
  List<com.tencent.mm.pluginsdk.ui.b.b> KNV;
  List<com.tencent.mm.pluginsdk.ui.b.b> KNW;
  List<com.tencent.mm.pluginsdk.ui.b.b> KNX;
  List<com.tencent.mm.pluginsdk.ui.b.b> KNY;
  List<com.tencent.mm.pluginsdk.ui.b.b> KNZ;
  List<com.tencent.mm.pluginsdk.ui.b.b> KOa;
  com.tencent.mm.sdk.b.c KOb;
  com.tencent.mm.sdk.b.c KOc;
  ListView KOd;
  View KOe;
  boolean KOf;
  Context context;
  
  public a()
  {
    AppMethodBeat.i(38152);
    this.KNV = new LinkedList();
    this.KNW = new LinkedList();
    this.KNX = new LinkedList();
    this.KNY = new LinkedList();
    this.KNZ = new LinkedList();
    this.KOa = new LinkedList();
    this.KOf = false;
    AppMethodBeat.o(38152);
  }
  
  private static void iP(List<com.tencent.mm.pluginsdk.ui.b.b> paramList)
  {
    AppMethodBeat.i(38161);
    paramList = paramList.iterator();
    while (paramList.hasNext()) {
      ((com.tencent.mm.pluginsdk.ui.b.b)paramList.next()).setVisibility(8);
    }
    AppMethodBeat.o(38161);
  }
  
  private static void iQ(List<com.tencent.mm.pluginsdk.ui.b.b> paramList)
  {
    AppMethodBeat.i(38162);
    paramList = paramList.iterator();
    while (paramList.hasNext()) {
      ((com.tencent.mm.pluginsdk.ui.b.b)paramList.next()).release();
    }
    AppMethodBeat.o(38162);
  }
  
  static void iR(List<com.tencent.mm.pluginsdk.ui.b.b> paramList)
  {
    AppMethodBeat.i(38163);
    Iterator localIterator = paramList.iterator();
    while (localIterator.hasNext()) {
      ((com.tencent.mm.pluginsdk.ui.b.b)localIterator.next()).destroy();
    }
    paramList.clear();
    AppMethodBeat.o(38163);
  }
  
  public final void DG(String paramString)
  {
    AppMethodBeat.i(38156);
    if ((bc.ajM()) && (!bc.aiT()) && (bu.nullAsNil(paramString).length() > 0) && (paramString.equals(v.aAC()))) {
      fMS();
    }
    AppMethodBeat.o(38156);
  }
  
  public final void a(int paramInt, com.tencent.mm.sdk.e.n paramn, Object paramObject)
  {
    AppMethodBeat.i(38157);
    if (bc.ajM())
    {
      bc.aCg();
      if (paramn == com.tencent.mm.model.c.ajA())
      {
        paramInt = bu.m(paramObject, 0);
        if (8193 == paramInt) {
          fMS();
        }
        if (42 == paramInt) {
          fMS();
        }
      }
    }
    AppMethodBeat.o(38157);
  }
  
  public final void a(Context paramContext, ListView paramListView, View paramView)
  {
    AppMethodBeat.i(38153);
    this.context = paramContext;
    this.KOd = paramListView;
    this.KOe = paramView;
    this.KOc = new com.tencent.mm.sdk.b.c() {};
    com.tencent.mm.sdk.b.a.IvT.c(this.KOc);
    paramView = new ai();
    paramView.dlV.activity = ((Activity)paramContext);
    com.tencent.mm.sdk.b.a.IvT.l(paramView);
    paramView = new com.tencent.mm.g.a.aj();
    paramView.dlW.dlX = ((com.tencent.mm.pluginsdk.ui.b.b)com.tencent.mm.ui.conversation.a.e.a(this.context, com.tencent.mm.ui.conversation.a.e.a.KUC, null));
    com.tencent.mm.sdk.b.a.IvT.l(paramView);
    paramView = (com.tencent.mm.pluginsdk.ui.b.b)com.tencent.mm.ui.conversation.a.e.a(this.context, com.tencent.mm.ui.conversation.a.e.a.KUt, null);
    Object localObject = new com.tencent.mm.g.a.aj();
    ((com.tencent.mm.g.a.aj)localObject).dlW.dlX = paramView;
    ((com.tencent.mm.g.a.aj)localObject).dlW.level = 1;
    com.tencent.mm.sdk.b.a.IvT.l((com.tencent.mm.sdk.b.b)localObject);
    paramView = (com.tencent.mm.pluginsdk.ui.b.b)com.tencent.mm.ui.conversation.a.e.a(this.context, com.tencent.mm.ui.conversation.a.e.a.KUw, null);
    localObject = new com.tencent.mm.g.a.aj();
    ((com.tencent.mm.g.a.aj)localObject).dlW.dlX = paramView;
    ((com.tencent.mm.g.a.aj)localObject).dlW.level = 1;
    com.tencent.mm.sdk.b.a.IvT.l((com.tencent.mm.sdk.b.b)localObject);
    paramView = (com.tencent.mm.pluginsdk.ui.b.b)com.tencent.mm.ui.conversation.a.e.a(this.context, com.tencent.mm.ui.conversation.a.e.a.KUu, null);
    localObject = new com.tencent.mm.g.a.aj();
    ((com.tencent.mm.g.a.aj)localObject).dlW.dlX = paramView;
    ((com.tencent.mm.g.a.aj)localObject).dlW.independent = false;
    ((com.tencent.mm.g.a.aj)localObject).dlW.level = 1;
    com.tencent.mm.sdk.b.a.IvT.l((com.tencent.mm.sdk.b.b)localObject);
    paramView = (r)com.tencent.mm.ui.conversation.a.e.a(this.context, com.tencent.mm.ui.conversation.a.e.a.KUB, null);
    localObject = new com.tencent.mm.g.a.aj();
    ((com.tencent.mm.g.a.aj)localObject).dlW.dlX = paramView;
    ((com.tencent.mm.g.a.aj)localObject).dlW.independent = false;
    ((com.tencent.mm.g.a.aj)localObject).dlW.level = 2;
    com.tencent.mm.sdk.b.a.IvT.l((com.tencent.mm.sdk.b.b)localObject);
    paramView = (com.tencent.mm.ui.conversation.a.a)com.tencent.mm.ui.conversation.a.e.a(this.context, com.tencent.mm.ui.conversation.a.e.a.KUy, null);
    localObject = new com.tencent.mm.g.a.aj();
    ((com.tencent.mm.g.a.aj)localObject).dlW.dlX = paramView;
    ((com.tencent.mm.g.a.aj)localObject).dlW.independent = false;
    ((com.tencent.mm.g.a.aj)localObject).dlW.level = 3;
    com.tencent.mm.sdk.b.a.IvT.l((com.tencent.mm.sdk.b.b)localObject);
    paramView = (com.tencent.mm.ui.d.a)com.tencent.mm.ui.conversation.a.e.a(this.context, com.tencent.mm.ui.conversation.a.e.a.KUD, new Object[] { b.b.hLH });
    localObject = new com.tencent.mm.g.a.aj();
    ((com.tencent.mm.g.a.aj)localObject).dlW.dlX = paramView;
    ((com.tencent.mm.g.a.aj)localObject).dlW.independent = true;
    com.tencent.mm.sdk.b.a.IvT.l((com.tencent.mm.sdk.b.b)localObject);
    paramView = (com.tencent.mm.pluginsdk.ui.b.b)com.tencent.mm.ui.conversation.a.e.a(this.context, com.tencent.mm.ui.conversation.a.e.a.KUv, null);
    localObject = new com.tencent.mm.g.a.aj();
    ((com.tencent.mm.g.a.aj)localObject).dlW.dlX = paramView;
    ((com.tencent.mm.g.a.aj)localObject).dlW.independent = false;
    ((com.tencent.mm.g.a.aj)localObject).dlW.level = 1;
    com.tencent.mm.sdk.b.a.IvT.l((com.tencent.mm.sdk.b.b)localObject);
    com.tencent.mm.sdk.b.a.IvT.d(this.KOc);
    this.KOa.addAll(this.KNV);
    this.KOa.addAll(this.KNW);
    this.KOa.addAll(this.KNX);
    this.KOa.addAll(this.KNY);
    Collections.sort(this.KOa, new Comparator() {});
    paramView = this.KOa.iterator();
    while (paramView.hasNext())
    {
      localObject = (com.tencent.mm.pluginsdk.ui.b.b)paramView.next();
      this.KOd.addHeaderView(((com.tencent.mm.pluginsdk.ui.b.b)localObject).getView());
    }
    new LinkedList();
    paramView = (com.tencent.mm.pluginsdk.ui.b.b)com.tencent.mm.ui.conversation.a.e.a(paramContext, com.tencent.mm.ui.conversation.a.e.a.KUx, null);
    if ((paramView != null) && (paramView.getView() != null)) {
      paramListView.addFooterView(paramView.getView());
    }
    this.KNZ.add(paramView);
    paramListView.addFooterView(new j(paramContext).getView(), null, true);
    this.KNZ.add(paramView);
    this.BEN = new n.a()
    {
      private final aw KOh;
      
      public final void onNetworkChange(int paramAnonymousInt)
      {
        AppMethodBeat.i(38150);
        if (this.KOh != null) {
          this.KOh.ay(10L, 10L);
        }
        AppMethodBeat.o(38150);
      }
    };
    bc.a(this.BEN);
    this.KOb = new com.tencent.mm.sdk.b.c() {};
    com.tencent.mm.sdk.b.a.IvT.c(this.KOb);
    bc.aCg();
    com.tencent.mm.model.c.a(this);
    fMS();
    AppMethodBeat.o(38153);
  }
  
  public final void aBX()
  {
    AppMethodBeat.i(38158);
    fMS();
    AppMethodBeat.o(38158);
  }
  
  public final void fMS()
  {
    AppMethodBeat.i(38155);
    if ((this.context == null) || (!bc.ajM()))
    {
      AppMethodBeat.o(38155);
      return;
    }
    ae.i("MicroMsg.BannerHelper", "updateBanner, :%d", new Object[] { Integer.valueOf(hashCode()) });
    boolean bool1 = t(this.KNV, true);
    boolean bool2 = t(this.KNW, true);
    boolean bool3 = t(this.KNX, true);
    boolean bool4 = t(this.KNY, true);
    int i;
    if ((bool1) || (bool2) || (bool3) || (bool4))
    {
      i = 1;
      if (!bool2) {
        break label233;
      }
      iP(this.KNX);
      iP(this.KNY);
    }
    Object localObject2;
    for (;;)
    {
      localObject1 = new LinkedList();
      localObject2 = this.KOa.iterator();
      while (((Iterator)localObject2).hasNext())
      {
        com.tencent.mm.pluginsdk.ui.b.b localb = (com.tencent.mm.pluginsdk.ui.b.b)((Iterator)localObject2).next();
        if (localb != null)
        {
          View localView = ((ViewGroup)localb.getView()).getChildAt(0);
          if ((localView != null) && (localView.getVisibility() == 0))
          {
            localb.isFirst = false;
            localb.hms = false;
            ((List)localObject1).add(localb);
          }
        }
      }
      i = 0;
      break;
      label233:
      if (bool3) {
        iP(this.KNY);
      }
    }
    if (((List)localObject1).size() > 0)
    {
      ((com.tencent.mm.pluginsdk.ui.b.b)((LinkedList)localObject1).getFirst()).isFirst = true;
      ((com.tencent.mm.pluginsdk.ui.b.b)((LinkedList)localObject1).getLast()).hms = true;
      localObject1 = ((List)localObject1).iterator();
      while (((Iterator)localObject1).hasNext()) {
        ((com.tencent.mm.pluginsdk.ui.b.b)((Iterator)localObject1).next()).bAV();
      }
    }
    if ((i != 0) && (this.KOd.getVisibility() != 0))
    {
      this.KOd.setVisibility(0);
      this.KOe.setVisibility(8);
    }
    Object localObject1 = this.KNZ.iterator();
    while (((Iterator)localObject1).hasNext())
    {
      localObject2 = (com.tencent.mm.pluginsdk.ui.b.b)((Iterator)localObject1).next();
      if (localObject2 != null) {
        ((com.tencent.mm.pluginsdk.ui.b.b)localObject2).bAV();
      }
    }
    AppMethodBeat.o(38155);
  }
  
  public final void fyJ()
  {
    AppMethodBeat.i(38154);
    ae.i("MicroMsg.BannerHelper", "releaseBanner");
    if (!this.KOf)
    {
      AppMethodBeat.o(38154);
      return;
    }
    this.KOf = false;
    iQ(this.KNV);
    iQ(this.KNW);
    iQ(this.KNX);
    iQ(this.KNY);
    Iterator localIterator = this.KNZ.iterator();
    while (localIterator.hasNext())
    {
      com.tencent.mm.pluginsdk.ui.b.b localb = (com.tencent.mm.pluginsdk.ui.b.b)localIterator.next();
      if (localb != null) {
        localb.release();
      }
    }
    if (bc.ajM()) {
      p.aEA().e(this);
    }
    if (bc.ajM())
    {
      bc.aCg();
      com.tencent.mm.model.c.ajA().b(this);
    }
    AppMethodBeat.o(38154);
  }
  
  final void iO(List<com.tencent.mm.pluginsdk.ui.b.b> paramList)
  {
    AppMethodBeat.i(38159);
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      com.tencent.mm.pluginsdk.ui.b.b localb = (com.tencent.mm.pluginsdk.ui.b.b)paramList.next();
      if (localb.getView() != null) {
        this.KOd.removeHeaderView(localb.getView());
      }
    }
    AppMethodBeat.o(38159);
  }
  
  final boolean t(List<com.tencent.mm.pluginsdk.ui.b.b> paramList, boolean paramBoolean)
  {
    AppMethodBeat.i(38160);
    paramList = paramList.iterator();
    boolean bool = false;
    if (paramList.hasNext())
    {
      com.tencent.mm.pluginsdk.ui.b.b localb = (com.tencent.mm.pluginsdk.ui.b.b)paramList.next();
      View localView = ((ViewGroup)localb.getView()).getChildAt(0);
      if (localb.bAV())
      {
        if ((localView != null) && (localView.getVisibility() == 0)) {}
        for (bool = true;; bool = false)
        {
          ae.i("MicroMsg.BannerHelper", "refreshAndReturnIsVisible[true] :%s, checkAll:%b, isVisible:%b, hc:%d", new Object[] { localb, Boolean.valueOf(paramBoolean), Boolean.valueOf(bool), Integer.valueOf(hashCode()) });
          if (paramBoolean) {
            break;
          }
          AppMethodBeat.o(38160);
          return true;
        }
      }
      if ((localView != null) && (localView.getVisibility() == 0)) {
        ae.i("MicroMsg.BannerHelper", "refreshAndReturnIsVisible[false] but visible :%s, checkAll:%b, hc:%d", new Object[] { localb, Boolean.valueOf(paramBoolean), Integer.valueOf(hashCode()) });
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