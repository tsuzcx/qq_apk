package com.tencent.mm.ui.conversation;

import android.app.Activity;
import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.app.f;
import com.tencent.mm.autogen.a.ao;
import com.tencent.mm.autogen.a.ap;
import com.tencent.mm.model.b.b.b;
import com.tencent.mm.model.bd;
import com.tencent.mm.model.bh;
import com.tencent.mm.model.c;
import com.tencent.mm.model.z;
import com.tencent.mm.modelavatar.AvatarStorage;
import com.tencent.mm.modelavatar.AvatarStorage.a;
import com.tencent.mm.modelavatar.q;
import com.tencent.mm.network.p.a;
import com.tencent.mm.pluginsdk.ui.a.b;
import com.tencent.mm.sdk.event.IListener;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MTimerHandler;
import com.tencent.mm.sdk.platformtools.MTimerHandler.CallBack;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.storage.MStorageEx;
import com.tencent.mm.sdk.storage.MStorageEx.IOnStorageChange;
import com.tencent.mm.storage.aq;
import com.tencent.mm.ui.conversation.banner.e;
import com.tencent.mm.ui.conversation.banner.e.a;
import com.tencent.mm.ui.conversation.banner.i;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public final class a
  implements bd, AvatarStorage.a, MStorageEx.IOnStorageChange
{
  List<b> aflP;
  List<b> aflQ;
  List<b> aflR;
  List<b> aflS;
  List<b> aflT;
  List<b> aflU;
  IListener aflV;
  IListener aflW;
  ListView aflX;
  private View aflY;
  boolean aflZ;
  Context context;
  com.tencent.mm.network.p mPf;
  
  public a()
  {
    AppMethodBeat.i(38152);
    this.aflP = new LinkedList();
    this.aflQ = new LinkedList();
    this.aflR = new LinkedList();
    this.aflS = new LinkedList();
    this.aflT = new LinkedList();
    this.aflU = new LinkedList();
    this.aflZ = false;
    AppMethodBeat.o(38152);
  }
  
  private static void of(List<b> paramList)
  {
    AppMethodBeat.i(38161);
    paramList = paramList.iterator();
    while (paramList.hasNext()) {
      ((b)paramList.next()).setVisibility(8);
    }
    AppMethodBeat.o(38161);
  }
  
  private static void og(List<b> paramList)
  {
    AppMethodBeat.i(38162);
    paramList = paramList.iterator();
    while (paramList.hasNext()) {
      ((b)paramList.next()).release();
    }
    AppMethodBeat.o(38162);
  }
  
  static void oh(List<b> paramList)
  {
    AppMethodBeat.i(38163);
    Iterator localIterator = paramList.iterator();
    while (localIterator.hasNext()) {
      ((b)localIterator.next()).destroy();
    }
    paramList.clear();
    AppMethodBeat.o(38163);
  }
  
  public final void LM(String paramString)
  {
    AppMethodBeat.i(38156);
    if ((bh.baz()) && (!bh.aZG()) && (Util.nullAsNil(paramString).length() > 0) && (paramString.equals(z.bAM()))) {
      ery();
    }
    AppMethodBeat.o(38156);
  }
  
  final boolean R(List<b> paramList, boolean paramBoolean)
  {
    AppMethodBeat.i(38160);
    paramList = paramList.iterator();
    boolean bool = false;
    if (paramList.hasNext())
    {
      b localb = (b)paramList.next();
      View localView = ((ViewGroup)localb.getView()).getChildAt(0);
      if (localb.cMa())
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
  
  public final void a(Context paramContext, ListView paramListView, View paramView)
  {
    AppMethodBeat.i(38153);
    this.context = paramContext;
    this.aflX = paramListView;
    this.aflY = paramView;
    this.aflW = new BannerHelper.1(this, f.hfK);
    this.aflW.alive();
    paramView = new ao();
    paramView.hAm.activity = ((Activity)paramContext);
    paramView.publish();
    paramView = new ap();
    paramView.hAn.hAo = ((b)e.a(this.context, e.a.afta, null));
    paramView.publish();
    paramView = (b)e.a(this.context, e.a.afsR, null);
    Object localObject = new ap();
    ((ap)localObject).hAn.hAo = paramView;
    ((ap)localObject).hAn.level = 1;
    ((ap)localObject).publish();
    paramView = (b)e.a(this.context, e.a.afsS, null);
    localObject = new ap();
    ((ap)localObject).hAn.hAo = paramView;
    ((ap)localObject).hAn.independent = false;
    ((ap)localObject).hAn.level = 1;
    ((ap)localObject).publish();
    paramView = (com.tencent.mm.ui.conversation.banner.p)e.a(this.context, e.a.afsZ, null);
    localObject = new ap();
    ((ap)localObject).hAn.hAo = paramView;
    ((ap)localObject).hAn.independent = false;
    ((ap)localObject).hAn.level = 2;
    ((ap)localObject).publish();
    paramView = (com.tencent.mm.ui.conversation.banner.a)e.a(this.context, e.a.afsW, null);
    localObject = new ap();
    ((ap)localObject).hAn.hAo = paramView;
    ((ap)localObject).hAn.independent = false;
    ((ap)localObject).hAn.level = 3;
    ((ap)localObject).publish();
    paramView = (com.tencent.mm.ui.c.a)e.a(this.context, e.a.aftb, new Object[] { b.b.ook });
    localObject = new ap();
    ((ap)localObject).hAn.hAo = paramView;
    ((ap)localObject).hAn.independent = true;
    ((ap)localObject).publish();
    this.aflW.dead();
    this.aflU.addAll(this.aflP);
    this.aflU.addAll(this.aflQ);
    this.aflU.addAll(this.aflR);
    this.aflU.addAll(this.aflS);
    Collections.sort(this.aflU, new Comparator() {});
    paramView = this.aflU.iterator();
    while (paramView.hasNext())
    {
      localObject = (b)paramView.next();
      this.aflX.addHeaderView(((b)localObject).getView());
    }
    new LinkedList();
    paramView = (b)e.a(paramContext, e.a.afsV, null);
    if ((paramView != null) && (paramView.getView() != null)) {
      paramListView.addFooterView(paramView.getView());
    }
    this.aflT.add(paramView);
    paramListView.addFooterView(new i(paramContext).getView(), null, true);
    this.aflT.add(paramView);
    this.mPf = new p.a()
    {
      private final MTimerHandler afmb;
      
      public final void onNetworkChange(int paramAnonymousInt)
      {
        AppMethodBeat.i(38150);
        if (this.afmb != null) {
          this.afmb.startTimer(10L);
        }
        AppMethodBeat.o(38150);
      }
    };
    bh.a(this.mPf);
    this.aflV = new BannerHelper.4(this, f.hfK);
    this.aflV.alive();
    bh.bCz();
    c.a(this);
    ery();
    AppMethodBeat.o(38153);
  }
  
  public final void ery()
  {
    AppMethodBeat.i(38155);
    if ((this.context == null) || (!bh.baz()))
    {
      AppMethodBeat.o(38155);
      return;
    }
    Log.i("MicroMsg.BannerHelper", "updateBanner, :%d", new Object[] { Integer.valueOf(hashCode()) });
    boolean bool1 = R(this.aflP, true);
    boolean bool2 = R(this.aflQ, true);
    boolean bool3 = R(this.aflR, true);
    boolean bool4 = R(this.aflS, true);
    int i;
    if ((bool1) || (bool2) || (bool3) || (bool4))
    {
      i = 1;
      if (!bool2) {
        break label232;
      }
      of(this.aflR);
      of(this.aflS);
    }
    Object localObject2;
    for (;;)
    {
      localObject1 = new LinkedList();
      localObject2 = this.aflU.iterator();
      while (((Iterator)localObject2).hasNext())
      {
        b localb = (b)((Iterator)localObject2).next();
        if (localb != null)
        {
          View localView = ((ViewGroup)localb.getView()).getChildAt(0);
          if ((localView != null) && (localView.getVisibility() == 0))
          {
            localb.isFirst = false;
            localb.nzL = false;
            ((List)localObject1).add(localb);
          }
        }
      }
      i = 0;
      break;
      label232:
      if (bool3) {
        of(this.aflS);
      }
    }
    if (((List)localObject1).size() > 0)
    {
      ((b)((LinkedList)localObject1).getFirst()).isFirst = true;
      ((b)((LinkedList)localObject1).getLast()).nzL = true;
      localObject1 = ((List)localObject1).iterator();
      while (((Iterator)localObject1).hasNext()) {
        ((b)((Iterator)localObject1).next()).cMa();
      }
    }
    if ((i != 0) && (this.aflX.getVisibility() != 0))
    {
      this.aflX.setVisibility(0);
      this.aflY.setVisibility(8);
    }
    Object localObject1 = this.aflT.iterator();
    while (((Iterator)localObject1).hasNext())
    {
      localObject2 = (b)((Iterator)localObject1).next();
      if (localObject2 != null) {
        ((b)localObject2).cMa();
      }
    }
    AppMethodBeat.o(38155);
  }
  
  public final void jhq()
  {
    AppMethodBeat.i(38154);
    Log.i("MicroMsg.BannerHelper", "releaseBanner");
    if (!this.aflZ)
    {
      AppMethodBeat.o(38154);
      return;
    }
    this.aflZ = false;
    og(this.aflP);
    og(this.aflQ);
    og(this.aflR);
    og(this.aflS);
    Iterator localIterator = this.aflT.iterator();
    while (localIterator.hasNext())
    {
      b localb = (b)localIterator.next();
      if (localb != null) {
        localb.release();
      }
    }
    if (bh.baz()) {
      q.bFp().e(this);
    }
    if (bh.baz())
    {
      bh.bCz();
      c.ban().remove(this);
    }
    AppMethodBeat.o(38154);
  }
  
  final void oe(List<b> paramList)
  {
    AppMethodBeat.i(38159);
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      b localb = (b)paramList.next();
      if (localb.getView() != null) {
        this.aflX.removeHeaderView(localb.getView());
      }
    }
    AppMethodBeat.o(38159);
  }
  
  public final void onNotifyChange(int paramInt, MStorageEx paramMStorageEx, Object paramObject)
  {
    AppMethodBeat.i(38157);
    if (bh.baz())
    {
      bh.bCz();
      if (paramMStorageEx == c.ban())
      {
        paramInt = Util.nullAsInt(paramObject, 0);
        if (8193 == paramInt) {
          ery();
        }
        if (42 == paramInt) {
          ery();
        }
      }
    }
    AppMethodBeat.o(38157);
  }
  
  public final void onNotifyUserStatusChange()
  {
    AppMethodBeat.i(38158);
    ery();
    AppMethodBeat.o(38158);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.ui.conversation.a
 * JD-Core Version:    0.7.0.1
 */