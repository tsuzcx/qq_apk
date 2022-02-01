package com.tencent.mm.ui.conversation;

import android.app.Activity;
import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.p;
import com.tencent.mm.g.a.aj;
import com.tencent.mm.g.a.lp;
import com.tencent.mm.model.aw;
import com.tencent.mm.model.b.b.b;
import com.tencent.mm.model.ba;
import com.tencent.mm.model.u;
import com.tencent.mm.network.n.a;
import com.tencent.mm.sdk.e.n.b;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.av;
import com.tencent.mm.sdk.platformtools.av.a;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.ui.conversation.a.j;
import com.tencent.mm.ui.conversation.a.r;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public final class a
  implements com.tencent.mm.ak.e.a, aw, n.b
{
  com.tencent.mm.network.n Bno;
  List<com.tencent.mm.pluginsdk.ui.b.b> KrB;
  List<com.tencent.mm.pluginsdk.ui.b.b> KrC;
  List<com.tencent.mm.pluginsdk.ui.b.b> KrD;
  List<com.tencent.mm.pluginsdk.ui.b.b> KrE;
  List<com.tencent.mm.pluginsdk.ui.b.b> KrF;
  List<com.tencent.mm.pluginsdk.ui.b.b> KrG;
  com.tencent.mm.sdk.b.c KrH;
  com.tencent.mm.sdk.b.c KrI;
  ListView KrJ;
  View KrK;
  boolean KrL;
  Context context;
  
  public a()
  {
    AppMethodBeat.i(38152);
    this.KrB = new LinkedList();
    this.KrC = new LinkedList();
    this.KrD = new LinkedList();
    this.KrE = new LinkedList();
    this.KrF = new LinkedList();
    this.KrG = new LinkedList();
    this.KrL = false;
    AppMethodBeat.o(38152);
  }
  
  private static void iF(List<com.tencent.mm.pluginsdk.ui.b.b> paramList)
  {
    AppMethodBeat.i(38161);
    paramList = paramList.iterator();
    while (paramList.hasNext()) {
      ((com.tencent.mm.pluginsdk.ui.b.b)paramList.next()).setVisibility(8);
    }
    AppMethodBeat.o(38161);
  }
  
  private static void iG(List<com.tencent.mm.pluginsdk.ui.b.b> paramList)
  {
    AppMethodBeat.i(38162);
    paramList = paramList.iterator();
    while (paramList.hasNext()) {
      ((com.tencent.mm.pluginsdk.ui.b.b)paramList.next()).release();
    }
    AppMethodBeat.o(38162);
  }
  
  static void iH(List<com.tencent.mm.pluginsdk.ui.b.b> paramList)
  {
    AppMethodBeat.i(38163);
    Iterator localIterator = paramList.iterator();
    while (localIterator.hasNext()) {
      ((com.tencent.mm.pluginsdk.ui.b.b)localIterator.next()).destroy();
    }
    paramList.clear();
    AppMethodBeat.o(38163);
  }
  
  public final void De(String paramString)
  {
    AppMethodBeat.i(38156);
    if ((ba.ajx()) && (!ba.aiE()) && (bt.nullAsNil(paramString).length() > 0) && (paramString.equals(u.aAm()))) {
      fIA();
    }
    AppMethodBeat.o(38156);
  }
  
  public final void a(int paramInt, com.tencent.mm.sdk.e.n paramn, Object paramObject)
  {
    AppMethodBeat.i(38157);
    if (ba.ajx())
    {
      ba.aBQ();
      if (paramn == com.tencent.mm.model.c.ajl())
      {
        paramInt = bt.m(paramObject, 0);
        if (8193 == paramInt) {
          fIA();
        }
        if (42 == paramInt) {
          fIA();
        }
      }
    }
    AppMethodBeat.o(38157);
  }
  
  public final void a(Context paramContext, ListView paramListView, View paramView)
  {
    AppMethodBeat.i(38153);
    this.context = paramContext;
    this.KrJ = paramListView;
    this.KrK = paramView;
    this.KrI = new com.tencent.mm.sdk.b.c() {};
    com.tencent.mm.sdk.b.a.IbL.c(this.KrI);
    paramView = new com.tencent.mm.g.a.ai();
    paramView.dkT.activity = ((Activity)paramContext);
    com.tencent.mm.sdk.b.a.IbL.l(paramView);
    paramView = new aj();
    paramView.dkU.dkV = ((com.tencent.mm.pluginsdk.ui.b.b)com.tencent.mm.ui.conversation.a.e.a(this.context, com.tencent.mm.ui.conversation.a.e.a.Kyi, null));
    com.tencent.mm.sdk.b.a.IbL.l(paramView);
    paramView = (com.tencent.mm.pluginsdk.ui.b.b)com.tencent.mm.ui.conversation.a.e.a(this.context, com.tencent.mm.ui.conversation.a.e.a.KxZ, null);
    Object localObject = new aj();
    ((aj)localObject).dkU.dkV = paramView;
    ((aj)localObject).dkU.level = 1;
    com.tencent.mm.sdk.b.a.IbL.l((com.tencent.mm.sdk.b.b)localObject);
    paramView = (com.tencent.mm.pluginsdk.ui.b.b)com.tencent.mm.ui.conversation.a.e.a(this.context, com.tencent.mm.ui.conversation.a.e.a.Kyc, null);
    localObject = new aj();
    ((aj)localObject).dkU.dkV = paramView;
    ((aj)localObject).dkU.level = 1;
    com.tencent.mm.sdk.b.a.IbL.l((com.tencent.mm.sdk.b.b)localObject);
    paramView = (com.tencent.mm.pluginsdk.ui.b.b)com.tencent.mm.ui.conversation.a.e.a(this.context, com.tencent.mm.ui.conversation.a.e.a.Kya, null);
    localObject = new aj();
    ((aj)localObject).dkU.dkV = paramView;
    ((aj)localObject).dkU.independent = false;
    ((aj)localObject).dkU.level = 1;
    com.tencent.mm.sdk.b.a.IbL.l((com.tencent.mm.sdk.b.b)localObject);
    paramView = (r)com.tencent.mm.ui.conversation.a.e.a(this.context, com.tencent.mm.ui.conversation.a.e.a.Kyh, null);
    localObject = new aj();
    ((aj)localObject).dkU.dkV = paramView;
    ((aj)localObject).dkU.independent = false;
    ((aj)localObject).dkU.level = 2;
    com.tencent.mm.sdk.b.a.IbL.l((com.tencent.mm.sdk.b.b)localObject);
    paramView = (com.tencent.mm.ui.conversation.a.a)com.tencent.mm.ui.conversation.a.e.a(this.context, com.tencent.mm.ui.conversation.a.e.a.Kye, null);
    localObject = new aj();
    ((aj)localObject).dkU.dkV = paramView;
    ((aj)localObject).dkU.independent = false;
    ((aj)localObject).dkU.level = 3;
    com.tencent.mm.sdk.b.a.IbL.l((com.tencent.mm.sdk.b.b)localObject);
    paramView = (com.tencent.mm.ui.d.a)com.tencent.mm.ui.conversation.a.e.a(this.context, com.tencent.mm.ui.conversation.a.e.a.Kyj, new Object[] { b.b.hIO });
    localObject = new aj();
    ((aj)localObject).dkU.dkV = paramView;
    ((aj)localObject).dkU.independent = true;
    com.tencent.mm.sdk.b.a.IbL.l((com.tencent.mm.sdk.b.b)localObject);
    paramView = (com.tencent.mm.pluginsdk.ui.b.b)com.tencent.mm.ui.conversation.a.e.a(this.context, com.tencent.mm.ui.conversation.a.e.a.Kyb, null);
    localObject = new aj();
    ((aj)localObject).dkU.dkV = paramView;
    ((aj)localObject).dkU.independent = false;
    ((aj)localObject).dkU.level = 1;
    com.tencent.mm.sdk.b.a.IbL.l((com.tencent.mm.sdk.b.b)localObject);
    com.tencent.mm.sdk.b.a.IbL.d(this.KrI);
    this.KrG.addAll(this.KrB);
    this.KrG.addAll(this.KrC);
    this.KrG.addAll(this.KrD);
    this.KrG.addAll(this.KrE);
    Collections.sort(this.KrG, new Comparator() {});
    paramView = this.KrG.iterator();
    while (paramView.hasNext())
    {
      localObject = (com.tencent.mm.pluginsdk.ui.b.b)paramView.next();
      this.KrJ.addHeaderView(((com.tencent.mm.pluginsdk.ui.b.b)localObject).getView());
    }
    new LinkedList();
    paramView = (com.tencent.mm.pluginsdk.ui.b.b)com.tencent.mm.ui.conversation.a.e.a(paramContext, com.tencent.mm.ui.conversation.a.e.a.Kyd, null);
    if ((paramView != null) && (paramView.getView() != null)) {
      paramListView.addFooterView(paramView.getView());
    }
    this.KrF.add(paramView);
    paramListView.addFooterView(new j(paramContext).getView(), null, true);
    this.KrF.add(paramView);
    this.Bno = new n.a()
    {
      private final av KrN;
      
      public final void onNetworkChange(int paramAnonymousInt)
      {
        AppMethodBeat.i(38150);
        if (this.KrN != null) {
          this.KrN.az(10L, 10L);
        }
        AppMethodBeat.o(38150);
      }
    };
    ba.a(this.Bno);
    this.KrH = new com.tencent.mm.sdk.b.c() {};
    com.tencent.mm.sdk.b.a.IbL.c(this.KrH);
    ba.aBQ();
    com.tencent.mm.model.c.a(this);
    fIA();
    AppMethodBeat.o(38153);
  }
  
  public final void aBH()
  {
    AppMethodBeat.i(38158);
    fIA();
    AppMethodBeat.o(38158);
  }
  
  public final void fIA()
  {
    AppMethodBeat.i(38155);
    if ((this.context == null) || (!ba.ajx()))
    {
      AppMethodBeat.o(38155);
      return;
    }
    ad.i("MicroMsg.BannerHelper", "updateBanner, :%d", new Object[] { Integer.valueOf(hashCode()) });
    boolean bool1 = t(this.KrB, true);
    boolean bool2 = t(this.KrC, true);
    boolean bool3 = t(this.KrD, true);
    boolean bool4 = t(this.KrE, true);
    int i;
    if ((bool1) || (bool2) || (bool3) || (bool4))
    {
      i = 1;
      if (!bool2) {
        break label233;
      }
      iF(this.KrD);
      iF(this.KrE);
    }
    Object localObject2;
    for (;;)
    {
      localObject1 = new LinkedList();
      localObject2 = this.KrG.iterator();
      while (((Iterator)localObject2).hasNext())
      {
        com.tencent.mm.pluginsdk.ui.b.b localb = (com.tencent.mm.pluginsdk.ui.b.b)((Iterator)localObject2).next();
        if (localb != null)
        {
          View localView = ((ViewGroup)localb.getView()).getChildAt(0);
          if ((localView != null) && (localView.getVisibility() == 0))
          {
            localb.isFirst = false;
            localb.hjE = false;
            ((List)localObject1).add(localb);
          }
        }
      }
      i = 0;
      break;
      label233:
      if (bool3) {
        iF(this.KrE);
      }
    }
    if (((List)localObject1).size() > 0)
    {
      ((com.tencent.mm.pluginsdk.ui.b.b)((LinkedList)localObject1).getFirst()).isFirst = true;
      ((com.tencent.mm.pluginsdk.ui.b.b)((LinkedList)localObject1).getLast()).hjE = true;
      localObject1 = ((List)localObject1).iterator();
      while (((Iterator)localObject1).hasNext()) {
        ((com.tencent.mm.pluginsdk.ui.b.b)((Iterator)localObject1).next()).bAa();
      }
    }
    if ((i != 0) && (this.KrJ.getVisibility() != 0))
    {
      this.KrJ.setVisibility(0);
      this.KrK.setVisibility(8);
    }
    Object localObject1 = this.KrF.iterator();
    while (((Iterator)localObject1).hasNext())
    {
      localObject2 = (com.tencent.mm.pluginsdk.ui.b.b)((Iterator)localObject1).next();
      if (localObject2 != null) {
        ((com.tencent.mm.pluginsdk.ui.b.b)localObject2).bAa();
      }
    }
    AppMethodBeat.o(38155);
  }
  
  public final void fuI()
  {
    AppMethodBeat.i(38154);
    ad.i("MicroMsg.BannerHelper", "releaseBanner");
    if (!this.KrL)
    {
      AppMethodBeat.o(38154);
      return;
    }
    this.KrL = false;
    iG(this.KrB);
    iG(this.KrC);
    iG(this.KrD);
    iG(this.KrE);
    Iterator localIterator = this.KrF.iterator();
    while (localIterator.hasNext())
    {
      com.tencent.mm.pluginsdk.ui.b.b localb = (com.tencent.mm.pluginsdk.ui.b.b)localIterator.next();
      if (localb != null) {
        localb.release();
      }
    }
    if (ba.ajx()) {
      p.aEk().e(this);
    }
    if (ba.ajx())
    {
      ba.aBQ();
      com.tencent.mm.model.c.ajl().b(this);
    }
    AppMethodBeat.o(38154);
  }
  
  final void iE(List<com.tencent.mm.pluginsdk.ui.b.b> paramList)
  {
    AppMethodBeat.i(38159);
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      com.tencent.mm.pluginsdk.ui.b.b localb = (com.tencent.mm.pluginsdk.ui.b.b)paramList.next();
      if (localb.getView() != null) {
        this.KrJ.removeHeaderView(localb.getView());
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
      if (localb.bAa())
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
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.ui.conversation.a
 * JD-Core Version:    0.7.0.1
 */