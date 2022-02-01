package com.tencent.mm.ui.conversation;

import android.app.Activity;
import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.ak;
import com.tencent.mm.g.a.al;
import com.tencent.mm.g.a.mg;
import com.tencent.mm.model.b.b.b;
import com.tencent.mm.model.bc;
import com.tencent.mm.model.bg;
import com.tencent.mm.model.c;
import com.tencent.mm.model.z;
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
import com.tencent.mm.ui.conversation.a.j;
import com.tencent.mm.ui.conversation.a.r;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public final class a
  implements com.tencent.mm.aj.e.a, bc, MStorageEx.IOnStorageChange
{
  com.tencent.mm.network.p FPE;
  List<b> QaV;
  List<b> QaW;
  List<b> QaX;
  List<b> QaY;
  List<b> QaZ;
  List<b> Qba;
  IListener Qbb;
  IListener Qbc;
  ListView Qbd;
  private View Qbe;
  boolean Qbf;
  Context context;
  
  public a()
  {
    AppMethodBeat.i(38152);
    this.QaV = new LinkedList();
    this.QaW = new LinkedList();
    this.QaX = new LinkedList();
    this.QaY = new LinkedList();
    this.QaZ = new LinkedList();
    this.Qba = new LinkedList();
    this.Qbf = false;
    AppMethodBeat.o(38152);
  }
  
  private static void jS(List<b> paramList)
  {
    AppMethodBeat.i(38161);
    paramList = paramList.iterator();
    while (paramList.hasNext()) {
      ((b)paramList.next()).setVisibility(8);
    }
    AppMethodBeat.o(38161);
  }
  
  private static void jT(List<b> paramList)
  {
    AppMethodBeat.i(38162);
    paramList = paramList.iterator();
    while (paramList.hasNext()) {
      ((b)paramList.next()).release();
    }
    AppMethodBeat.o(38162);
  }
  
  static void jU(List<b> paramList)
  {
    AppMethodBeat.i(38163);
    Iterator localIterator = paramList.iterator();
    while (localIterator.hasNext()) {
      ((b)localIterator.next()).destroy();
    }
    paramList.clear();
    AppMethodBeat.o(38163);
  }
  
  final boolean A(List<b> paramList, boolean paramBoolean)
  {
    AppMethodBeat.i(38160);
    paramList = paramList.iterator();
    boolean bool = false;
    if (paramList.hasNext())
    {
      b localb = (b)paramList.next();
      View localView = ((ViewGroup)localb.getView()).getChildAt(0);
      if (localb.bYa())
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
  
  public final void Mr(String paramString)
  {
    AppMethodBeat.i(38156);
    if ((bg.aAc()) && (!bg.azj()) && (Util.nullAsNil(paramString).length() > 0) && (paramString.equals(z.aTY()))) {
      gVm();
    }
    AppMethodBeat.o(38156);
  }
  
  public final void a(Context paramContext, ListView paramListView, View paramView)
  {
    AppMethodBeat.i(38153);
    this.context = paramContext;
    this.Qbd = paramListView;
    this.Qbe = paramView;
    this.Qbc = new IListener() {};
    EventCenter.instance.addListener(this.Qbc);
    paramView = new ak();
    paramView.dDl.activity = ((Activity)paramContext);
    EventCenter.instance.publish(paramView);
    paramView = new al();
    paramView.dDm.dDn = ((b)com.tencent.mm.ui.conversation.a.e.a(this.context, com.tencent.mm.ui.conversation.a.e.a.QhS, null));
    EventCenter.instance.publish(paramView);
    paramView = (b)com.tencent.mm.ui.conversation.a.e.a(this.context, com.tencent.mm.ui.conversation.a.e.a.QhJ, null);
    Object localObject = new al();
    ((al)localObject).dDm.dDn = paramView;
    ((al)localObject).dDm.level = 1;
    EventCenter.instance.publish((IEvent)localObject);
    paramView = (b)com.tencent.mm.ui.conversation.a.e.a(this.context, com.tencent.mm.ui.conversation.a.e.a.QhM, null);
    localObject = new al();
    ((al)localObject).dDm.dDn = paramView;
    ((al)localObject).dDm.level = 1;
    EventCenter.instance.publish((IEvent)localObject);
    paramView = (b)com.tencent.mm.ui.conversation.a.e.a(this.context, com.tencent.mm.ui.conversation.a.e.a.QhK, null);
    localObject = new al();
    ((al)localObject).dDm.dDn = paramView;
    ((al)localObject).dDm.independent = false;
    ((al)localObject).dDm.level = 1;
    EventCenter.instance.publish((IEvent)localObject);
    paramView = (r)com.tencent.mm.ui.conversation.a.e.a(this.context, com.tencent.mm.ui.conversation.a.e.a.QhR, null);
    localObject = new al();
    ((al)localObject).dDm.dDn = paramView;
    ((al)localObject).dDm.independent = false;
    ((al)localObject).dDm.level = 2;
    EventCenter.instance.publish((IEvent)localObject);
    paramView = (com.tencent.mm.ui.conversation.a.a)com.tencent.mm.ui.conversation.a.e.a(this.context, com.tencent.mm.ui.conversation.a.e.a.QhO, null);
    localObject = new al();
    ((al)localObject).dDm.dDn = paramView;
    ((al)localObject).dDm.independent = false;
    ((al)localObject).dDm.level = 3;
    EventCenter.instance.publish((IEvent)localObject);
    paramView = (com.tencent.mm.ui.d.a)com.tencent.mm.ui.conversation.a.e.a(this.context, com.tencent.mm.ui.conversation.a.e.a.QhT, new Object[] { b.b.iGJ });
    localObject = new al();
    ((al)localObject).dDm.dDn = paramView;
    ((al)localObject).dDm.independent = true;
    EventCenter.instance.publish((IEvent)localObject);
    paramView = (b)com.tencent.mm.ui.conversation.a.e.a(this.context, com.tencent.mm.ui.conversation.a.e.a.QhL, null);
    localObject = new al();
    ((al)localObject).dDm.dDn = paramView;
    ((al)localObject).dDm.independent = false;
    ((al)localObject).dDm.level = 1;
    EventCenter.instance.publish((IEvent)localObject);
    EventCenter.instance.removeListener(this.Qbc);
    this.Qba.addAll(this.QaV);
    this.Qba.addAll(this.QaW);
    this.Qba.addAll(this.QaX);
    this.Qba.addAll(this.QaY);
    Collections.sort(this.Qba, new Comparator() {});
    paramView = this.Qba.iterator();
    while (paramView.hasNext())
    {
      localObject = (b)paramView.next();
      this.Qbd.addHeaderView(((b)localObject).getView());
    }
    new LinkedList();
    paramView = (b)com.tencent.mm.ui.conversation.a.e.a(paramContext, com.tencent.mm.ui.conversation.a.e.a.QhN, null);
    if ((paramView != null) && (paramView.getView() != null)) {
      paramListView.addFooterView(paramView.getView());
    }
    this.QaZ.add(paramView);
    paramListView.addFooterView(new j(paramContext).getView(), null, true);
    this.QaZ.add(paramView);
    this.FPE = new p.a()
    {
      private final MTimerHandler Qbh;
      
      public final void onNetworkChange(int paramAnonymousInt)
      {
        AppMethodBeat.i(38150);
        if (this.Qbh != null) {
          this.Qbh.startTimer(10L);
        }
        AppMethodBeat.o(38150);
      }
    };
    bg.a(this.FPE);
    this.Qbb = new IListener() {};
    EventCenter.instance.addListener(this.Qbb);
    bg.aVF();
    c.a(this);
    gVm();
    AppMethodBeat.o(38153);
  }
  
  public final void aVw()
  {
    AppMethodBeat.i(38158);
    gVm();
    AppMethodBeat.o(38158);
  }
  
  public final void gGx()
  {
    AppMethodBeat.i(38154);
    Log.i("MicroMsg.BannerHelper", "releaseBanner");
    if (!this.Qbf)
    {
      AppMethodBeat.o(38154);
      return;
    }
    this.Qbf = false;
    jT(this.QaV);
    jT(this.QaW);
    jT(this.QaX);
    jT(this.QaY);
    Iterator localIterator = this.QaZ.iterator();
    while (localIterator.hasNext())
    {
      b localb = (b)localIterator.next();
      if (localb != null) {
        localb.release();
      }
    }
    if (bg.aAc()) {
      com.tencent.mm.aj.p.aYn().e(this);
    }
    if (bg.aAc())
    {
      bg.aVF();
      c.azQ().remove(this);
    }
    AppMethodBeat.o(38154);
  }
  
  public final void gVm()
  {
    AppMethodBeat.i(38155);
    if ((this.context == null) || (!bg.aAc()))
    {
      AppMethodBeat.o(38155);
      return;
    }
    Log.i("MicroMsg.BannerHelper", "updateBanner, :%d", new Object[] { Integer.valueOf(hashCode()) });
    boolean bool1 = A(this.QaV, true);
    boolean bool2 = A(this.QaW, true);
    boolean bool3 = A(this.QaX, true);
    boolean bool4 = A(this.QaY, true);
    int i;
    if ((bool1) || (bool2) || (bool3) || (bool4))
    {
      i = 1;
      if (!bool2) {
        break label232;
      }
      jS(this.QaX);
      jS(this.QaY);
    }
    Object localObject2;
    for (;;)
    {
      localObject1 = new LinkedList();
      localObject2 = this.Qba.iterator();
      while (((Iterator)localObject2).hasNext())
      {
        b localb = (b)((Iterator)localObject2).next();
        if (localb != null)
        {
          View localView = ((ViewGroup)localb.getView()).getChildAt(0);
          if ((localView != null) && (localView.getVisibility() == 0))
          {
            localb.isFirst = false;
            localb.ifo = false;
            ((List)localObject1).add(localb);
          }
        }
      }
      i = 0;
      break;
      label232:
      if (bool3) {
        jS(this.QaY);
      }
    }
    if (((List)localObject1).size() > 0)
    {
      ((b)((LinkedList)localObject1).getFirst()).isFirst = true;
      ((b)((LinkedList)localObject1).getLast()).ifo = true;
      localObject1 = ((List)localObject1).iterator();
      while (((Iterator)localObject1).hasNext()) {
        ((b)((Iterator)localObject1).next()).bYa();
      }
    }
    if ((i != 0) && (this.Qbd.getVisibility() != 0))
    {
      this.Qbd.setVisibility(0);
      this.Qbe.setVisibility(8);
    }
    Object localObject1 = this.QaZ.iterator();
    while (((Iterator)localObject1).hasNext())
    {
      localObject2 = (b)((Iterator)localObject1).next();
      if (localObject2 != null) {
        ((b)localObject2).bYa();
      }
    }
    AppMethodBeat.o(38155);
  }
  
  final void jR(List<b> paramList)
  {
    AppMethodBeat.i(38159);
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      b localb = (b)paramList.next();
      if (localb.getView() != null) {
        this.Qbd.removeHeaderView(localb.getView());
      }
    }
    AppMethodBeat.o(38159);
  }
  
  public final void onNotifyChange(int paramInt, MStorageEx paramMStorageEx, Object paramObject)
  {
    AppMethodBeat.i(38157);
    if (bg.aAc())
    {
      bg.aVF();
      if (paramMStorageEx == c.azQ())
      {
        paramInt = Util.nullAsInt(paramObject, 0);
        if (8193 == paramInt) {
          gVm();
        }
        if (42 == paramInt) {
          gVm();
        }
      }
    }
    AppMethodBeat.o(38157);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.ui.conversation.a
 * JD-Core Version:    0.7.0.1
 */