package com.tencent.mm.ui.conversation;

import android.app.Activity;
import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.f;
import com.tencent.mm.am.f.a;
import com.tencent.mm.f.a.al;
import com.tencent.mm.f.a.am;
import com.tencent.mm.f.a.my;
import com.tencent.mm.model.b.b.b;
import com.tencent.mm.model.bd;
import com.tencent.mm.model.bh;
import com.tencent.mm.model.c;
import com.tencent.mm.model.z;
import com.tencent.mm.network.p;
import com.tencent.mm.network.p.a;
import com.tencent.mm.pluginsdk.ui.b.b;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.event.IEvent;
import com.tencent.mm.sdk.event.IListener;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MTimerHandler;
import com.tencent.mm.sdk.platformtools.MTimerHandler.CallBack;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.storage.MStorageEx;
import com.tencent.mm.sdk.storage.MStorageEx.IOnStorageChange;
import com.tencent.mm.storage.ao;
import com.tencent.mm.ui.conversation.a.e;
import com.tencent.mm.ui.conversation.a.e.a;
import com.tencent.mm.ui.conversation.a.i;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public final class a
  implements f.a, bd, MStorageEx.IOnStorageChange
{
  p MjF;
  List<b> Xzi;
  List<b> Xzj;
  List<b> Xzk;
  List<b> Xzl;
  List<b> Xzm;
  List<b> Xzn;
  IListener Xzo;
  IListener Xzp;
  ListView Xzq;
  private View Xzr;
  boolean Xzs;
  Context context;
  
  public a()
  {
    AppMethodBeat.i(38152);
    this.Xzi = new LinkedList();
    this.Xzj = new LinkedList();
    this.Xzk = new LinkedList();
    this.Xzl = new LinkedList();
    this.Xzm = new LinkedList();
    this.Xzn = new LinkedList();
    this.Xzs = false;
    AppMethodBeat.o(38152);
  }
  
  private static void kN(List<b> paramList)
  {
    AppMethodBeat.i(38161);
    paramList = paramList.iterator();
    while (paramList.hasNext()) {
      ((b)paramList.next()).setVisibility(8);
    }
    AppMethodBeat.o(38161);
  }
  
  private static void kO(List<b> paramList)
  {
    AppMethodBeat.i(38162);
    paramList = paramList.iterator();
    while (paramList.hasNext()) {
      ((b)paramList.next()).release();
    }
    AppMethodBeat.o(38162);
  }
  
  static void kP(List<b> paramList)
  {
    AppMethodBeat.i(38163);
    Iterator localIterator = paramList.iterator();
    while (localIterator.hasNext()) {
      ((b)localIterator.next()).destroy();
    }
    paramList.clear();
    AppMethodBeat.o(38163);
  }
  
  final boolean C(List<b> paramList, boolean paramBoolean)
  {
    AppMethodBeat.i(38160);
    paramList = paramList.iterator();
    boolean bool = false;
    if (paramList.hasNext())
    {
      b localb = (b)paramList.next();
      View localView = ((ViewGroup)localb.getView()).getChildAt(0);
      if (localb.ckL())
      {
        if ((localView != null) && (localView.getVisibility() == 0)) {}
        for (bool = true;; bool = false)
        {
          Log.i("MicroMsg.BannerHelper", "refreshAndReturnIsVisible[true] :%s, checkAll:%b, isVisible:%b, hc:%d", new Object[] { localb, Boolean.valueOf(paramBoolean), Boolean.valueOf(bool), Integer.valueOf(hashCode()) });
          if (paramBoolean) {
            break;
          }
          AppMethodBeat.o(38160);
          return true;
        }
      }
      if ((localView != null) && (localView.getVisibility() == 0)) {
        Log.i("MicroMsg.BannerHelper", "refreshAndReturnIsVisible[false] but visible :%s, checkAll:%b, hc:%d", new Object[] { localb, Boolean.valueOf(paramBoolean), Integer.valueOf(hashCode()) });
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
  
  public final void TM(String paramString)
  {
    AppMethodBeat.i(38156);
    if ((bh.aHB()) && (!bh.aGE()) && (Util.nullAsNil(paramString).length() > 0) && (paramString.equals(z.bcZ()))) {
      hVT();
    }
    AppMethodBeat.o(38156);
  }
  
  public final void a(Context paramContext, ListView paramListView, View paramView)
  {
    AppMethodBeat.i(38153);
    this.context = paramContext;
    this.Xzq = paramListView;
    this.Xzr = paramView;
    this.Xzp = new IListener() {};
    EventCenter.instance.addListener(this.Xzp);
    paramView = new al();
    paramView.fvR.activity = ((Activity)paramContext);
    EventCenter.instance.publish(paramView);
    paramView = new am();
    paramView.fvS.fvT = ((b)e.a(this.context, e.a.XFd, null));
    EventCenter.instance.publish(paramView);
    paramView = (b)e.a(this.context, e.a.XEU, null);
    Object localObject = new am();
    ((am)localObject).fvS.fvT = paramView;
    ((am)localObject).fvS.level = 1;
    EventCenter.instance.publish((IEvent)localObject);
    paramView = (b)e.a(this.context, e.a.XEX, null);
    localObject = new am();
    ((am)localObject).fvS.fvT = paramView;
    ((am)localObject).fvS.level = 1;
    EventCenter.instance.publish((IEvent)localObject);
    paramView = (b)e.a(this.context, e.a.XEV, null);
    localObject = new am();
    ((am)localObject).fvS.fvT = paramView;
    ((am)localObject).fvS.independent = false;
    ((am)localObject).fvS.level = 1;
    EventCenter.instance.publish((IEvent)localObject);
    paramView = (com.tencent.mm.ui.conversation.a.q)e.a(this.context, e.a.XFc, null);
    localObject = new am();
    ((am)localObject).fvS.fvT = paramView;
    ((am)localObject).fvS.independent = false;
    ((am)localObject).fvS.level = 2;
    EventCenter.instance.publish((IEvent)localObject);
    paramView = (com.tencent.mm.ui.conversation.a.a)e.a(this.context, e.a.XEZ, null);
    localObject = new am();
    ((am)localObject).fvS.fvT = paramView;
    ((am)localObject).fvS.independent = false;
    ((am)localObject).fvS.level = 3;
    EventCenter.instance.publish((IEvent)localObject);
    paramView = (com.tencent.mm.ui.d.a)e.a(this.context, e.a.XFe, new Object[] { b.b.lwL });
    localObject = new am();
    ((am)localObject).fvS.fvT = paramView;
    ((am)localObject).fvS.independent = true;
    EventCenter.instance.publish((IEvent)localObject);
    EventCenter.instance.removeListener(this.Xzp);
    this.Xzn.addAll(this.Xzi);
    this.Xzn.addAll(this.Xzj);
    this.Xzn.addAll(this.Xzk);
    this.Xzn.addAll(this.Xzl);
    Collections.sort(this.Xzn, new Comparator() {});
    paramView = this.Xzn.iterator();
    while (paramView.hasNext())
    {
      localObject = (b)paramView.next();
      this.Xzq.addHeaderView(((b)localObject).getView());
    }
    new LinkedList();
    paramView = (b)e.a(paramContext, e.a.XEY, null);
    if ((paramView != null) && (paramView.getView() != null)) {
      paramListView.addFooterView(paramView.getView());
    }
    this.Xzm.add(paramView);
    paramListView.addFooterView(new i(paramContext).getView(), null, true);
    this.Xzm.add(paramView);
    this.MjF = new p.a()
    {
      private final MTimerHandler Xzu;
      
      public final void onNetworkChange(int paramAnonymousInt)
      {
        AppMethodBeat.i(38150);
        if (this.Xzu != null) {
          this.Xzu.startTimer(10L);
        }
        AppMethodBeat.o(38150);
      }
    };
    bh.a(this.MjF);
    this.Xzo = new IListener() {};
    EventCenter.instance.addListener(this.Xzo);
    bh.beI();
    c.a(this);
    hVT();
    AppMethodBeat.o(38153);
  }
  
  public final void bez()
  {
    AppMethodBeat.i(38158);
    hVT();
    AppMethodBeat.o(38158);
  }
  
  public final void hFe()
  {
    AppMethodBeat.i(38154);
    Log.i("MicroMsg.BannerHelper", "releaseBanner");
    if (!this.Xzs)
    {
      AppMethodBeat.o(38154);
      return;
    }
    this.Xzs = false;
    kO(this.Xzi);
    kO(this.Xzj);
    kO(this.Xzk);
    kO(this.Xzl);
    Iterator localIterator = this.Xzm.iterator();
    while (localIterator.hasNext())
    {
      b localb = (b)localIterator.next();
      if (localb != null) {
        localb.release();
      }
    }
    if (bh.aHB()) {
      com.tencent.mm.am.q.bhz().e(this);
    }
    if (bh.aHB())
    {
      bh.beI();
      c.aHp().remove(this);
    }
    AppMethodBeat.o(38154);
  }
  
  public final void hVT()
  {
    AppMethodBeat.i(38155);
    if ((this.context == null) || (!bh.aHB()))
    {
      AppMethodBeat.o(38155);
      return;
    }
    Log.i("MicroMsg.BannerHelper", "updateBanner, :%d", new Object[] { Integer.valueOf(hashCode()) });
    boolean bool1 = C(this.Xzi, true);
    boolean bool2 = C(this.Xzj, true);
    boolean bool3 = C(this.Xzk, true);
    boolean bool4 = C(this.Xzl, true);
    int i;
    if ((bool1) || (bool2) || (bool3) || (bool4))
    {
      i = 1;
      if (!bool2) {
        break label232;
      }
      kN(this.Xzk);
      kN(this.Xzl);
    }
    Object localObject2;
    for (;;)
    {
      localObject1 = new LinkedList();
      localObject2 = this.Xzn.iterator();
      while (((Iterator)localObject2).hasNext())
      {
        b localb = (b)((Iterator)localObject2).next();
        if (localb != null)
        {
          View localView = ((ViewGroup)localb.getView()).getChildAt(0);
          if ((localView != null) && (localView.getVisibility() == 0))
          {
            localb.isFirst = false;
            localb.kUc = false;
            ((List)localObject1).add(localb);
          }
        }
      }
      i = 0;
      break;
      label232:
      if (bool3) {
        kN(this.Xzl);
      }
    }
    if (((List)localObject1).size() > 0)
    {
      ((b)((LinkedList)localObject1).getFirst()).isFirst = true;
      ((b)((LinkedList)localObject1).getLast()).kUc = true;
      localObject1 = ((List)localObject1).iterator();
      while (((Iterator)localObject1).hasNext()) {
        ((b)((Iterator)localObject1).next()).ckL();
      }
    }
    if ((i != 0) && (this.Xzq.getVisibility() != 0))
    {
      this.Xzq.setVisibility(0);
      this.Xzr.setVisibility(8);
    }
    Object localObject1 = this.Xzm.iterator();
    while (((Iterator)localObject1).hasNext())
    {
      localObject2 = (b)((Iterator)localObject1).next();
      if (localObject2 != null) {
        ((b)localObject2).ckL();
      }
    }
    AppMethodBeat.o(38155);
  }
  
  final void kM(List<b> paramList)
  {
    AppMethodBeat.i(38159);
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      b localb = (b)paramList.next();
      if (localb.getView() != null) {
        this.Xzq.removeHeaderView(localb.getView());
      }
    }
    AppMethodBeat.o(38159);
  }
  
  public final void onNotifyChange(int paramInt, MStorageEx paramMStorageEx, Object paramObject)
  {
    AppMethodBeat.i(38157);
    if (bh.aHB())
    {
      bh.beI();
      if (paramMStorageEx == c.aHp())
      {
        paramInt = Util.nullAsInt(paramObject, 0);
        if (8193 == paramInt) {
          hVT();
        }
        if (42 == paramInt) {
          hVT();
        }
      }
    }
    AppMethodBeat.o(38157);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.ui.conversation.a
 * JD-Core Version:    0.7.0.1
 */