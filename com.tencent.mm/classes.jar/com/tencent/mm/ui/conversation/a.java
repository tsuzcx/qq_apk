package com.tencent.mm.ui.conversation;

import android.app.Activity;
import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.p;
import com.tencent.mm.g.a.ah;
import com.tencent.mm.g.a.ai;
import com.tencent.mm.g.a.kx;
import com.tencent.mm.model.az;
import com.tencent.mm.model.b.b.b;
import com.tencent.mm.model.u;
import com.tencent.mm.network.n.a;
import com.tencent.mm.sdk.e.n.b;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.av.a;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.storage.ab;
import com.tencent.mm.ui.conversation.a.j;
import com.tencent.mm.ui.conversation.a.r;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public final class a
  implements com.tencent.mm.ak.e.a, com.tencent.mm.model.av, n.b
{
  List<com.tencent.mm.pluginsdk.ui.b.b> Had;
  List<com.tencent.mm.pluginsdk.ui.b.b> Hae;
  List<com.tencent.mm.pluginsdk.ui.b.b> Haf;
  List<com.tencent.mm.pluginsdk.ui.b.b> Hag;
  List<com.tencent.mm.pluginsdk.ui.b.b> Hah;
  List<com.tencent.mm.pluginsdk.ui.b.b> Hai;
  com.tencent.mm.sdk.b.c Haj;
  com.tencent.mm.sdk.b.c Hak;
  ListView Hal;
  View Ham;
  boolean Han;
  Context context;
  com.tencent.mm.network.n yIx;
  
  public a()
  {
    AppMethodBeat.i(38152);
    this.Had = new LinkedList();
    this.Hae = new LinkedList();
    this.Haf = new LinkedList();
    this.Hag = new LinkedList();
    this.Hah = new LinkedList();
    this.Hai = new LinkedList();
    this.Han = false;
    AppMethodBeat.o(38152);
  }
  
  private static void ig(List<com.tencent.mm.pluginsdk.ui.b.b> paramList)
  {
    AppMethodBeat.i(38161);
    paramList = paramList.iterator();
    while (paramList.hasNext()) {
      ((com.tencent.mm.pluginsdk.ui.b.b)paramList.next()).setVisibility(8);
    }
    AppMethodBeat.o(38161);
  }
  
  private static void ih(List<com.tencent.mm.pluginsdk.ui.b.b> paramList)
  {
    AppMethodBeat.i(38162);
    paramList = paramList.iterator();
    while (paramList.hasNext()) {
      ((com.tencent.mm.pluginsdk.ui.b.b)paramList.next()).release();
    }
    AppMethodBeat.o(38162);
  }
  
  static void ii(List<com.tencent.mm.pluginsdk.ui.b.b> paramList)
  {
    AppMethodBeat.i(38163);
    Iterator localIterator = paramList.iterator();
    while (localIterator.hasNext()) {
      ((com.tencent.mm.pluginsdk.ui.b.b)localIterator.next()).destroy();
    }
    paramList.clear();
    AppMethodBeat.o(38163);
  }
  
  public final void a(int paramInt, com.tencent.mm.sdk.e.n paramn, Object paramObject)
  {
    AppMethodBeat.i(38157);
    if (az.afw())
    {
      az.arV();
      if (paramn == com.tencent.mm.model.c.afk())
      {
        paramInt = bt.i(paramObject, 0);
        if (8193 == paramInt) {
          fbU();
        }
        if (42 == paramInt) {
          fbU();
        }
      }
    }
    AppMethodBeat.o(38157);
  }
  
  public final void a(Context paramContext, ListView paramListView, View paramView)
  {
    AppMethodBeat.i(38153);
    this.context = paramContext;
    this.Hal = paramListView;
    this.Ham = paramView;
    this.Hak = new com.tencent.mm.sdk.b.c() {};
    com.tencent.mm.sdk.b.a.ESL.c(this.Hak);
    paramView = new ah();
    paramView.dcc.activity = ((Activity)paramContext);
    com.tencent.mm.sdk.b.a.ESL.l(paramView);
    paramView = new ai();
    paramView.dcd.dce = ((com.tencent.mm.pluginsdk.ui.b.b)com.tencent.mm.ui.conversation.a.e.a(this.context, com.tencent.mm.ui.conversation.a.e.a.HgJ, null));
    com.tencent.mm.sdk.b.a.ESL.l(paramView);
    paramView = (com.tencent.mm.pluginsdk.ui.b.b)com.tencent.mm.ui.conversation.a.e.a(this.context, com.tencent.mm.ui.conversation.a.e.a.HgA, null);
    Object localObject = new ai();
    ((ai)localObject).dcd.dce = paramView;
    ((ai)localObject).dcd.level = 1;
    com.tencent.mm.sdk.b.a.ESL.l((com.tencent.mm.sdk.b.b)localObject);
    paramView = (com.tencent.mm.pluginsdk.ui.b.b)com.tencent.mm.ui.conversation.a.e.a(this.context, com.tencent.mm.ui.conversation.a.e.a.HgD, null);
    localObject = new ai();
    ((ai)localObject).dcd.dce = paramView;
    ((ai)localObject).dcd.level = 1;
    com.tencent.mm.sdk.b.a.ESL.l((com.tencent.mm.sdk.b.b)localObject);
    paramView = (com.tencent.mm.pluginsdk.ui.b.b)com.tencent.mm.ui.conversation.a.e.a(this.context, com.tencent.mm.ui.conversation.a.e.a.HgB, null);
    localObject = new ai();
    ((ai)localObject).dcd.dce = paramView;
    ((ai)localObject).dcd.independent = false;
    ((ai)localObject).dcd.level = 1;
    com.tencent.mm.sdk.b.a.ESL.l((com.tencent.mm.sdk.b.b)localObject);
    paramView = (r)com.tencent.mm.ui.conversation.a.e.a(this.context, com.tencent.mm.ui.conversation.a.e.a.HgI, null);
    localObject = new ai();
    ((ai)localObject).dcd.dce = paramView;
    ((ai)localObject).dcd.independent = false;
    ((ai)localObject).dcd.level = 2;
    com.tencent.mm.sdk.b.a.ESL.l((com.tencent.mm.sdk.b.b)localObject);
    paramView = (com.tencent.mm.ui.conversation.a.a)com.tencent.mm.ui.conversation.a.e.a(this.context, com.tencent.mm.ui.conversation.a.e.a.HgF, null);
    localObject = new ai();
    ((ai)localObject).dcd.dce = paramView;
    ((ai)localObject).dcd.independent = false;
    ((ai)localObject).dcd.level = 3;
    com.tencent.mm.sdk.b.a.ESL.l((com.tencent.mm.sdk.b.b)localObject);
    paramView = (com.tencent.mm.ui.d.a)com.tencent.mm.ui.conversation.a.e.a(this.context, com.tencent.mm.ui.conversation.a.e.a.HgK, new Object[] { b.b.gPW });
    localObject = new ai();
    ((ai)localObject).dcd.dce = paramView;
    ((ai)localObject).dcd.independent = true;
    com.tencent.mm.sdk.b.a.ESL.l((com.tencent.mm.sdk.b.b)localObject);
    paramView = (com.tencent.mm.pluginsdk.ui.b.b)com.tencent.mm.ui.conversation.a.e.a(this.context, com.tencent.mm.ui.conversation.a.e.a.HgC, null);
    localObject = new ai();
    ((ai)localObject).dcd.dce = paramView;
    ((ai)localObject).dcd.independent = false;
    ((ai)localObject).dcd.level = 1;
    com.tencent.mm.sdk.b.a.ESL.l((com.tencent.mm.sdk.b.b)localObject);
    com.tencent.mm.sdk.b.a.ESL.d(this.Hak);
    this.Hai.addAll(this.Had);
    this.Hai.addAll(this.Hae);
    this.Hai.addAll(this.Haf);
    this.Hai.addAll(this.Hag);
    Collections.sort(this.Hai, new Comparator() {});
    paramView = this.Hai.iterator();
    while (paramView.hasNext())
    {
      localObject = (com.tencent.mm.pluginsdk.ui.b.b)paramView.next();
      this.Hal.addHeaderView(((com.tencent.mm.pluginsdk.ui.b.b)localObject).getView());
    }
    new LinkedList();
    paramView = (com.tencent.mm.pluginsdk.ui.b.b)com.tencent.mm.ui.conversation.a.e.a(paramContext, com.tencent.mm.ui.conversation.a.e.a.HgE, null);
    if ((paramView != null) && (paramView.getView() != null)) {
      paramListView.addFooterView(paramView.getView());
    }
    this.Hah.add(paramView);
    paramListView.addFooterView(new j(paramContext).getView(), null, true);
    this.Hah.add(paramView);
    this.yIx = new n.a()
    {
      private final com.tencent.mm.sdk.platformtools.av Hap;
      
      public final void onNetworkChange(int paramAnonymousInt)
      {
        AppMethodBeat.i(38150);
        if (this.Hap != null) {
          this.Hap.av(10L, 10L);
        }
        AppMethodBeat.o(38150);
      }
    };
    az.a(this.yIx);
    this.Haj = new com.tencent.mm.sdk.b.c() {};
    com.tencent.mm.sdk.b.a.ESL.c(this.Haj);
    az.arV();
    com.tencent.mm.model.c.a(this);
    fbU();
    AppMethodBeat.o(38153);
  }
  
  public final void arM()
  {
    AppMethodBeat.i(38158);
    fbU();
    AppMethodBeat.o(38158);
  }
  
  public final void eOX()
  {
    AppMethodBeat.i(38154);
    ad.i("MicroMsg.BannerHelper", "releaseBanner");
    if (!this.Han)
    {
      AppMethodBeat.o(38154);
      return;
    }
    this.Han = false;
    ih(this.Had);
    ih(this.Hae);
    ih(this.Haf);
    ih(this.Hag);
    Iterator localIterator = this.Hah.iterator();
    while (localIterator.hasNext())
    {
      com.tencent.mm.pluginsdk.ui.b.b localb = (com.tencent.mm.pluginsdk.ui.b.b)localIterator.next();
      if (localb != null) {
        localb.release();
      }
    }
    if (az.afw()) {
      p.auq().e(this);
    }
    if (az.afw())
    {
      az.arV();
      com.tencent.mm.model.c.afk().b(this);
    }
    AppMethodBeat.o(38154);
  }
  
  public final void fbU()
  {
    AppMethodBeat.i(38155);
    if ((this.context == null) || (!az.afw()))
    {
      AppMethodBeat.o(38155);
      return;
    }
    ad.i("MicroMsg.BannerHelper", "updateBanner, :%d", new Object[] { Integer.valueOf(hashCode()) });
    boolean bool1 = q(this.Had, true);
    boolean bool2 = q(this.Hae, true);
    boolean bool3 = q(this.Haf, true);
    boolean bool4 = q(this.Hag, true);
    int i;
    if ((bool1) || (bool2) || (bool3) || (bool4))
    {
      i = 1;
      if (!bool2) {
        break label233;
      }
      ig(this.Haf);
      ig(this.Hag);
    }
    Object localObject2;
    for (;;)
    {
      localObject1 = new LinkedList();
      localObject2 = this.Hai.iterator();
      while (((Iterator)localObject2).hasNext())
      {
        com.tencent.mm.pluginsdk.ui.b.b localb = (com.tencent.mm.pluginsdk.ui.b.b)((Iterator)localObject2).next();
        if (localb != null)
        {
          View localView = ((ViewGroup)localb.getView()).getChildAt(0);
          if ((localView != null) && (localView.getVisibility() == 0))
          {
            localb.isFirst = false;
            localb.gqE = false;
            ((List)localObject1).add(localb);
          }
        }
      }
      i = 0;
      break;
      label233:
      if (bool3) {
        ig(this.Hag);
      }
    }
    if (((List)localObject1).size() > 0)
    {
      ((com.tencent.mm.pluginsdk.ui.b.b)((LinkedList)localObject1).getFirst()).isFirst = true;
      ((com.tencent.mm.pluginsdk.ui.b.b)((LinkedList)localObject1).getLast()).gqE = true;
      localObject1 = ((List)localObject1).iterator();
      while (((Iterator)localObject1).hasNext()) {
        ((com.tencent.mm.pluginsdk.ui.b.b)((Iterator)localObject1).next()).boZ();
      }
    }
    if ((i != 0) && (this.Hal.getVisibility() != 0))
    {
      this.Hal.setVisibility(0);
      this.Ham.setVisibility(8);
    }
    Object localObject1 = this.Hah.iterator();
    while (((Iterator)localObject1).hasNext())
    {
      localObject2 = (com.tencent.mm.pluginsdk.ui.b.b)((Iterator)localObject1).next();
      if (localObject2 != null) {
        ((com.tencent.mm.pluginsdk.ui.b.b)localObject2).boZ();
      }
    }
    AppMethodBeat.o(38155);
  }
  
  final void jdMethod_if(List<com.tencent.mm.pluginsdk.ui.b.b> paramList)
  {
    AppMethodBeat.i(38159);
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      com.tencent.mm.pluginsdk.ui.b.b localb = (com.tencent.mm.pluginsdk.ui.b.b)paramList.next();
      if (localb.getView() != null) {
        this.Hal.removeHeaderView(localb.getView());
      }
    }
    AppMethodBeat.o(38159);
  }
  
  final boolean q(List<com.tencent.mm.pluginsdk.ui.b.b> paramList, boolean paramBoolean)
  {
    AppMethodBeat.i(38160);
    paramList = paramList.iterator();
    boolean bool = false;
    if (paramList.hasNext())
    {
      com.tencent.mm.pluginsdk.ui.b.b localb = (com.tencent.mm.pluginsdk.ui.b.b)paramList.next();
      View localView = ((ViewGroup)localb.getView()).getChildAt(0);
      if (localb.boZ())
      {
        if ((localView != null) && (localView.getVisibility() == 0)) {}
        for (bool = true;; bool = false)
        {
          ad.i("MicroMsg.BannerHelper", "refreshAndReturnIsVisible[true] :%s, checkAll:%b, isVisible:%b, hc:%d", new Object[] { localb, Boolean.valueOf(paramBoolean), Boolean.valueOf(bool), Integer.valueOf(hashCode()) });
          if (paramBoolean) {
            break;
          }
          AppMethodBeat.o(38160);
          return true;
        }
      }
      if ((localView != null) && (localView.getVisibility() == 0)) {
        ad.i("MicroMsg.BannerHelper", "refreshAndReturnIsVisible[false] but visible :%s, checkAll:%b, hc:%d", new Object[] { localb, Boolean.valueOf(paramBoolean), Integer.valueOf(hashCode()) });
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
  
  public final void vZ(String paramString)
  {
    AppMethodBeat.i(38156);
    if ((az.afw()) && (!az.aeC()) && (bt.nullAsNil(paramString).length() > 0) && (paramString.equals(u.aqG()))) {
      fbU();
    }
    AppMethodBeat.o(38156);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.ui.conversation.a
 * JD-Core Version:    0.7.0.1
 */