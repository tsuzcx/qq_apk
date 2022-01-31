package com.tencent.mm.ui.conversation;

import android.app.Activity;
import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ah.d.a;
import com.tencent.mm.g.a.ae;
import com.tencent.mm.g.a.af;
import com.tencent.mm.model.as;
import com.tencent.mm.model.aw;
import com.tencent.mm.model.b.b.b;
import com.tencent.mm.model.r;
import com.tencent.mm.platformtools.ah;
import com.tencent.mm.sdk.e.n.b;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.ui.conversation.a.e;
import com.tencent.mm.ui.conversation.a.e.a;
import com.tencent.mm.ui.conversation.a.j;
import com.tencent.mm.ui.conversation.a.q;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public final class a
  implements d.a, as, n.b
{
  List<com.tencent.mm.pluginsdk.ui.b.b> AgF;
  List<com.tencent.mm.pluginsdk.ui.b.b> AgG;
  List<com.tencent.mm.pluginsdk.ui.b.b> AgH;
  List<com.tencent.mm.pluginsdk.ui.b.b> AgI;
  List<com.tencent.mm.pluginsdk.ui.b.b> AgJ;
  List<com.tencent.mm.pluginsdk.ui.b.b> AgK;
  com.tencent.mm.sdk.b.c AgL;
  com.tencent.mm.sdk.b.c AgM;
  ListView AgN;
  View AgO;
  Context context;
  com.tencent.mm.network.n qwx;
  
  public a()
  {
    AppMethodBeat.i(34034);
    this.AgF = new LinkedList();
    this.AgG = new LinkedList();
    this.AgH = new LinkedList();
    this.AgI = new LinkedList();
    this.AgJ = new LinkedList();
    this.AgK = new LinkedList();
    AppMethodBeat.o(34034);
  }
  
  private static void fC(List<com.tencent.mm.pluginsdk.ui.b.b> paramList)
  {
    AppMethodBeat.i(34042);
    paramList = paramList.iterator();
    while (paramList.hasNext()) {
      ((com.tencent.mm.pluginsdk.ui.b.b)paramList.next()).setVisibility(8);
    }
    AppMethodBeat.o(34042);
  }
  
  static void fD(List<com.tencent.mm.pluginsdk.ui.b.b> paramList)
  {
    AppMethodBeat.i(34043);
    paramList = paramList.iterator();
    while (paramList.hasNext()) {
      ((com.tencent.mm.pluginsdk.ui.b.b)paramList.next()).release();
    }
    AppMethodBeat.o(34043);
  }
  
  static void fE(List<com.tencent.mm.pluginsdk.ui.b.b> paramList)
  {
    AppMethodBeat.i(34044);
    Iterator localIterator = paramList.iterator();
    while (localIterator.hasNext()) {
      ((com.tencent.mm.pluginsdk.ui.b.b)localIterator.next()).destroy();
    }
    paramList.clear();
    AppMethodBeat.o(34044);
  }
  
  public final void a(int paramInt, com.tencent.mm.sdk.e.n paramn, Object paramObject)
  {
    AppMethodBeat.i(34038);
    if (aw.RG())
    {
      aw.aaz();
      if (paramn == com.tencent.mm.model.c.Ru())
      {
        paramInt = ah.aW(paramObject);
        if (8193 == paramInt) {
          dMn();
        }
        if (42 == paramInt) {
          dMn();
        }
      }
    }
    AppMethodBeat.o(34038);
  }
  
  public final void a(Context paramContext, ListView paramListView, View paramView)
  {
    AppMethodBeat.i(34035);
    this.context = paramContext;
    this.AgN = paramListView;
    this.AgO = paramView;
    this.AgM = new a.1(this);
    com.tencent.mm.sdk.b.a.ymk.c(this.AgM);
    paramView = new ae();
    paramView.cnk.activity = ((Activity)paramContext);
    com.tencent.mm.sdk.b.a.ymk.l(paramView);
    paramView = new af();
    paramView.cnl.cnn = ((com.tencent.mm.pluginsdk.ui.b.b)e.a(this.context, e.a.Amx, null));
    com.tencent.mm.sdk.b.a.ymk.l(paramView);
    paramView = (com.tencent.mm.pluginsdk.ui.b.b)e.a(this.context, e.a.Amp, null);
    Object localObject = new af();
    ((af)localObject).cnl.cnn = paramView;
    ((af)localObject).cnl.level = 1;
    com.tencent.mm.sdk.b.a.ymk.l((com.tencent.mm.sdk.b.b)localObject);
    paramView = (com.tencent.mm.pluginsdk.ui.b.b)e.a(this.context, e.a.Amq, null);
    localObject = new af();
    ((af)localObject).cnl.cnn = paramView;
    ((af)localObject).cnl.cnm = false;
    ((af)localObject).cnl.level = 1;
    com.tencent.mm.sdk.b.a.ymk.l((com.tencent.mm.sdk.b.b)localObject);
    paramView = (q)e.a(this.context, e.a.Amw, null);
    localObject = new af();
    ((af)localObject).cnl.cnn = paramView;
    ((af)localObject).cnl.cnm = false;
    ((af)localObject).cnl.level = 2;
    com.tencent.mm.sdk.b.a.ymk.l((com.tencent.mm.sdk.b.b)localObject);
    paramView = (com.tencent.mm.ui.conversation.a.a)e.a(this.context, e.a.Amt, null);
    localObject = new af();
    ((af)localObject).cnl.cnn = paramView;
    ((af)localObject).cnl.cnm = false;
    ((af)localObject).cnl.level = 3;
    com.tencent.mm.sdk.b.a.ymk.l((com.tencent.mm.sdk.b.b)localObject);
    paramView = (com.tencent.mm.ui.d.a)e.a(this.context, e.a.Amy, new Object[] { b.b.fou });
    localObject = new af();
    ((af)localObject).cnl.cnn = paramView;
    ((af)localObject).cnl.cnm = true;
    com.tencent.mm.sdk.b.a.ymk.l((com.tencent.mm.sdk.b.b)localObject);
    paramView = (com.tencent.mm.pluginsdk.ui.b.b)e.a(this.context, e.a.Amr, null);
    localObject = new af();
    ((af)localObject).cnl.cnn = paramView;
    ((af)localObject).cnl.cnm = false;
    ((af)localObject).cnl.level = 1;
    com.tencent.mm.sdk.b.a.ymk.l((com.tencent.mm.sdk.b.b)localObject);
    com.tencent.mm.sdk.b.a.ymk.d(this.AgM);
    this.AgK.addAll(this.AgF);
    this.AgK.addAll(this.AgG);
    this.AgK.addAll(this.AgH);
    this.AgK.addAll(this.AgI);
    Collections.sort(this.AgK, new a.2(this));
    paramView = this.AgK.iterator();
    while (paramView.hasNext())
    {
      localObject = (com.tencent.mm.pluginsdk.ui.b.b)paramView.next();
      this.AgN.addHeaderView(((com.tencent.mm.pluginsdk.ui.b.b)localObject).getView());
    }
    new LinkedList();
    paramView = (com.tencent.mm.pluginsdk.ui.b.b)e.a(paramContext, e.a.Ams, null);
    if ((paramView != null) && (paramView.getView() != null)) {
      paramListView.addFooterView(paramView.getView());
    }
    this.AgJ.add(paramView);
    paramListView.addFooterView(new j(paramContext).getView(), null, true);
    this.AgJ.add(paramView);
    this.qwx = new a.3(this);
    aw.a(this.qwx);
    this.AgL = new a.4(this);
    com.tencent.mm.sdk.b.a.ymk.c(this.AgL);
    aw.aaz();
    com.tencent.mm.model.c.a(this);
    dMn();
    AppMethodBeat.o(34035);
  }
  
  public final void aaq()
  {
    AppMethodBeat.i(34039);
    dMn();
    AppMethodBeat.o(34039);
  }
  
  public final void dMn()
  {
    AppMethodBeat.i(34036);
    if ((this.context == null) || (!aw.RG()))
    {
      AppMethodBeat.o(34036);
      return;
    }
    ab.i("MicroMsg.BannerHelper", "updateBanner, :%d", new Object[] { Integer.valueOf(hashCode()) });
    boolean bool1 = o(this.AgF, true);
    boolean bool2 = o(this.AgG, true);
    boolean bool3 = o(this.AgH, true);
    boolean bool4 = o(this.AgI, true);
    int i;
    if ((bool1) || (bool2) || (bool3) || (bool4))
    {
      i = 1;
      if (!bool2) {
        break label233;
      }
      fC(this.AgH);
      fC(this.AgI);
    }
    Object localObject2;
    for (;;)
    {
      localObject1 = new LinkedList();
      localObject2 = this.AgK.iterator();
      while (((Iterator)localObject2).hasNext())
      {
        com.tencent.mm.pluginsdk.ui.b.b localb = (com.tencent.mm.pluginsdk.ui.b.b)((Iterator)localObject2).next();
        if (localb != null)
        {
          View localView = ((ViewGroup)localb.getView()).getChildAt(0);
          if ((localView != null) && (localView.getVisibility() == 0))
          {
            localb.nwf = false;
            localb.eUx = false;
            ((List)localObject1).add(localb);
          }
        }
      }
      i = 0;
      break;
      label233:
      if (bool3) {
        fC(this.AgI);
      }
    }
    if (((List)localObject1).size() > 0)
    {
      ((com.tencent.mm.pluginsdk.ui.b.b)((LinkedList)localObject1).getFirst()).nwf = true;
      ((com.tencent.mm.pluginsdk.ui.b.b)((LinkedList)localObject1).getLast()).eUx = true;
      localObject1 = ((List)localObject1).iterator();
      while (((Iterator)localObject1).hasNext()) {
        ((com.tencent.mm.pluginsdk.ui.b.b)((Iterator)localObject1).next()).aMK();
      }
    }
    if ((i != 0) && (this.AgN.getVisibility() != 0))
    {
      this.AgN.setVisibility(0);
      this.AgO.setVisibility(8);
    }
    Object localObject1 = this.AgJ.iterator();
    while (((Iterator)localObject1).hasNext())
    {
      localObject2 = (com.tencent.mm.pluginsdk.ui.b.b)((Iterator)localObject1).next();
      if (localObject2 != null) {
        ((com.tencent.mm.pluginsdk.ui.b.b)localObject2).aMK();
      }
    }
    AppMethodBeat.o(34036);
  }
  
  final void fB(List<com.tencent.mm.pluginsdk.ui.b.b> paramList)
  {
    AppMethodBeat.i(34040);
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      com.tencent.mm.pluginsdk.ui.b.b localb = (com.tencent.mm.pluginsdk.ui.b.b)paramList.next();
      if (localb.getView() != null) {
        this.AgN.removeHeaderView(localb.getView());
      }
    }
    AppMethodBeat.o(34040);
  }
  
  final boolean o(List<com.tencent.mm.pluginsdk.ui.b.b> paramList, boolean paramBoolean)
  {
    AppMethodBeat.i(34041);
    paramList = paramList.iterator();
    boolean bool = false;
    if (paramList.hasNext())
    {
      com.tencent.mm.pluginsdk.ui.b.b localb = (com.tencent.mm.pluginsdk.ui.b.b)paramList.next();
      View localView = ((ViewGroup)localb.getView()).getChildAt(0);
      if (localb.aMK())
      {
        if ((localView != null) && (localView.getVisibility() == 0)) {}
        for (bool = true;; bool = false)
        {
          ab.i("MicroMsg.BannerHelper", "refreshAndReturnIsVisible[true] :%s, checkAll:%b, isVisible:%b, hc:%d", new Object[] { localb, Boolean.valueOf(paramBoolean), Boolean.valueOf(bool), Integer.valueOf(hashCode()) });
          if (paramBoolean) {
            break;
          }
          AppMethodBeat.o(34041);
          return true;
        }
      }
      if ((localView != null) && (localView.getVisibility() == 0)) {
        ab.i("MicroMsg.BannerHelper", "refreshAndReturnIsVisible[false] but visible :%s, checkAll:%b, hc:%d", new Object[] { localb, Boolean.valueOf(paramBoolean), Integer.valueOf(hashCode()) });
      }
    }
    for (;;)
    {
      break;
      AppMethodBeat.o(34041);
      return bool;
      bool = true;
    }
  }
  
  public final void re(String paramString)
  {
    AppMethodBeat.i(34037);
    if ((aw.RG()) && (!aw.QP()) && (ah.nullAsNil(paramString).length() > 0) && (paramString.equals(r.Zn()))) {
      dMn();
    }
    AppMethodBeat.o(34037);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.ui.conversation.a
 * JD-Core Version:    0.7.0.1
 */