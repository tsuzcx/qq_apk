package com.tencent.mm.plugin.sns.ui;

import android.content.Context;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnTouchListener;
import android.view.animation.ScaleAnimation;
import android.widget.ListView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.sns.model.ag;
import com.tencent.mm.plugin.sns.model.aq.b;
import com.tencent.mm.plugin.sns.storage.n;
import com.tencent.mm.plugin.sns.ui.item.BaseTimeLineItem;
import com.tencent.mm.plugin.sns.ui.item.BaseTimeLineItem.BaseViewHolder;
import com.tencent.mm.plugin.sns.ui.item.a.a;
import com.tencent.mm.plugin.sns.ui.item.c.a;
import com.tencent.mm.plugin.sns.ui.item.d;
import com.tencent.mm.plugin.sns.ui.item.e;
import com.tencent.mm.plugin.sns.ui.item.f;
import com.tencent.mm.plugin.sns.ui.item.g;
import com.tencent.mm.plugin.sns.ui.item.g.a;
import com.tencent.mm.plugin.sns.ui.item.h;
import com.tencent.mm.plugin.sns.ui.item.h.a;
import com.tencent.mm.plugin.sns.ui.item.i.a;
import com.tencent.mm.plugin.sns.ui.item.j.b;
import com.tencent.mm.plugin.sns.ui.item.k;
import com.tencent.mm.plugin.sns.ui.widget.SnsCommentCollapseLayout;
import com.tencent.mm.pluginsdk.m;
import com.tencent.mm.protocal.protobuf.TimeLineObject;
import com.tencent.mm.protocal.protobuf.du;
import com.tencent.mm.protocal.protobuf.vi;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.tools.l;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Set;

public final class av
  implements x
{
  public MMActivity cmc;
  public l contextMenuHelper;
  private ListView gMh;
  com.tencent.mm.sdk.b.c hCe;
  protected ak handler;
  public com.tencent.mm.ui.widget.c.a jVd;
  protected HashMap<String, Integer> rFT;
  public View.OnTouchListener rGO;
  public boolean rNW;
  public aq rOF;
  private int rOI;
  public j rOK;
  public bd rON;
  protected ScaleAnimation rOy;
  protected ScaleAnimation rOz;
  com.tencent.mm.sdk.b.c rPf;
  com.tencent.mm.sdk.b.c rPg;
  com.tencent.mm.sdk.b.c rPh;
  protected w rWO;
  public i rWP;
  protected LinkedList<SnsCommentCollapseLayout> rWQ;
  public HashMap<Integer, WeakReference<View>> rWR;
  View rWS;
  public int rWT;
  int rWU;
  protected HashMap<Integer, View> rWV;
  public HashMap<String, String> rWW;
  private HashMap<Integer, Class<? extends BaseTimeLineItem.BaseViewHolder>> rWX;
  public View.OnClickListener rWY;
  public View.OnClickListener rWZ;
  public View.OnClickListener rXa;
  private HashMap<String, Boolean> rXb;
  private av.c rXc;
  protected int requestType;
  public com.tencent.mm.plugin.sns.ui.d.b rks;
  
  public av(MMActivity paramMMActivity, ListView paramListView, com.tencent.mm.plugin.sns.ui.d.b paramb, i parami, w paramw)
  {
    AppMethodBeat.i(39422);
    this.rWQ = new LinkedList();
    this.rWR = new HashMap();
    this.rNW = false;
    this.rOI = 0;
    this.rWT = -1;
    this.rWU = 0;
    this.rFT = new HashMap();
    this.rWV = new HashMap();
    this.requestType = 0;
    this.handler = new ak();
    this.rWW = new HashMap();
    this.rPg = new av.1(this);
    this.rPf = new av.3(this);
    this.rPh = new av.4(this);
    this.rWX = new HashMap();
    this.rWX.put(Integer.valueOf(6), i.a.class);
    this.rWX.put(Integer.valueOf(2), g.a.class);
    this.rWX.put(Integer.valueOf(3), g.a.class);
    this.rWX.put(Integer.valueOf(4), g.a.class);
    this.rWX.put(Integer.valueOf(5), g.a.class);
    this.rWX.put(Integer.valueOf(0), g.a.class);
    this.rWX.put(Integer.valueOf(1), g.a.class);
    this.rWX.put(Integer.valueOf(7), g.a.class);
    this.rWX.put(Integer.valueOf(8), g.a.class);
    this.rWX.put(Integer.valueOf(9), g.a.class);
    this.rWX.put(Integer.valueOf(11), j.b.class);
    this.rWX.put(Integer.valueOf(13), a.a.class);
    this.rWX.put(Integer.valueOf(14), c.a.class);
    this.rWX.put(Integer.valueOf(15), h.a.class);
    this.rWX.put(Integer.valueOf(10), g.a.class);
    this.rWX.put(Integer.valueOf(12), g.a.class);
    this.rWY = new av.5(this);
    this.rWZ = new av.6(this);
    this.rXa = new av.7(this);
    this.rGO = bo.dtW();
    this.rXb = new HashMap();
    this.rXc = new av.c();
    this.hCe = new av.2(this);
    this.rWO = paramw;
    this.rWP = parami;
    ab.d("MicroMsg.SnsTimeLineBaseAdapter", "SnsTimeLineAdapter 2");
    this.gMh = paramListView;
    ag.cpc();
    this.cmc = paramMMActivity;
    this.rks = paramb;
    this.contextMenuHelper = new l(paramMMActivity);
    this.jVd = new com.tencent.mm.ui.widget.c.a(paramMMActivity);
    this.rOF = new aq(paramMMActivity);
    this.rOy = new ScaleAnimation(0.0F, 1.0F, 1.0F, 1.0F, 1, 1.0F, 1, 0.0F);
    this.rOy.setDuration(150L);
    this.rOz = new ScaleAnimation(1.0F, 0.0F, 1.0F, 1.0F, 1, 1.0F, 1, 0.0F);
    this.rOz.setDuration(150L);
    this.rOK = new j(paramMMActivity, 0, parami.rFl);
    this.requestType = 10;
    this.rON = new bd(paramMMActivity, new av.8(this, paramw), 0, parami.rFl);
    com.tencent.mm.sdk.b.a.ymk.c(this.hCe);
    AppMethodBeat.o(39422);
  }
  
  public static int D(n paramn)
  {
    AppMethodBeat.i(156760);
    int i = b(paramn, true);
    AppMethodBeat.o(156760);
    return i;
  }
  
  public static String a(TimeLineObject paramTimeLineObject, Context paramContext)
  {
    AppMethodBeat.i(39429);
    paramTimeLineObject = com.tencent.mm.plugin.sns.c.a.gmP.f(paramContext, paramTimeLineObject.xTR.Id, "timeline");
    AppMethodBeat.o(39429);
    return paramTimeLineObject;
  }
  
  public static String acj(String paramString)
  {
    AppMethodBeat.i(39428);
    if (bo.isNullOrNil(paramString))
    {
      AppMethodBeat.o(39428);
      return paramString;
    }
    int i = paramString.indexOf("://");
    String str = paramString;
    if (i != -1) {
      str = paramString.substring(i + 3);
    }
    i = str.indexOf("/");
    paramString = str;
    if (i != -1) {
      paramString = str.substring(0, i);
    }
    AppMethodBeat.o(39428);
    return paramString;
  }
  
  public static String ack(String paramString)
  {
    AppMethodBeat.i(39430);
    ab.d("MicroMsg.SnsTimeLineBaseAdapter", "url:".concat(String.valueOf(paramString)));
    paramString = com.tencent.mm.plugin.sns.c.a.gmP.H(paramString, "timeline");
    AppMethodBeat.o(39430);
    return paramString;
  }
  
  protected static int b(n paramn, boolean paramBoolean)
  {
    AppMethodBeat.i(39426);
    TimeLineObject localTimeLineObject = paramn.csh();
    if (localTimeLineObject.xTS.wNZ == 1)
    {
      if ((paramBoolean) && (localTimeLineObject.dqG == 1))
      {
        AppMethodBeat.o(39426);
        return 12;
      }
      if ((paramn.Ex(32)) && (paramn.csb() != null))
      {
        if (paramn.csb().cqp())
        {
          AppMethodBeat.o(39426);
          return 13;
        }
        if (paramn.cqq())
        {
          AppMethodBeat.o(39426);
          return 14;
        }
        if (paramn.csU())
        {
          AppMethodBeat.o(39426);
          return 15;
        }
      }
      int i = localTimeLineObject.xTS.wOa.size();
      if (i <= 1)
      {
        AppMethodBeat.o(39426);
        return 2;
      }
      if (i <= 3)
      {
        AppMethodBeat.o(39426);
        return 3;
      }
      if (i <= 6)
      {
        AppMethodBeat.o(39426);
        return 4;
      }
      AppMethodBeat.o(39426);
      return 5;
    }
    switch (localTimeLineObject.xTS.wNZ)
    {
    default: 
      AppMethodBeat.o(39426);
      return 1;
    case 4: 
      AppMethodBeat.o(39426);
      return 0;
    case 5: 
      if ((paramn.Ex(32)) && (paramn.csb() != null))
      {
        if (paramn.csb().cqp())
        {
          AppMethodBeat.o(39426);
          return 13;
        }
        if (paramn.cqq())
        {
          AppMethodBeat.o(39426);
          return 14;
        }
        if (paramn.csU())
        {
          AppMethodBeat.o(39426);
          return 15;
        }
      }
      AppMethodBeat.o(39426);
      return 1;
    case 2: 
      AppMethodBeat.o(39426);
      return 6;
    case 8: 
      AppMethodBeat.o(39426);
      return 3;
    case 7: 
      AppMethodBeat.o(39426);
      return 2;
    case 14: 
      AppMethodBeat.o(39426);
      return 7;
    case 15: 
      if ((paramBoolean) && (localTimeLineObject.xTZ == 1))
      {
        AppMethodBeat.o(39426);
        return 12;
      }
      if ((paramn.Ex(32)) && (paramn.csb() != null))
      {
        if (paramn.csb().cqp())
        {
          AppMethodBeat.o(39426);
          return 13;
        }
        if (paramn.cqq())
        {
          AppMethodBeat.o(39426);
          return 14;
        }
        if (paramn.csU())
        {
          AppMethodBeat.o(39426);
          return 15;
        }
      }
      AppMethodBeat.o(39426);
      return 9;
    case 21: 
      AppMethodBeat.o(39426);
      return 10;
    }
    AppMethodBeat.o(39426);
    return 11;
  }
  
  public final n EE(int paramInt)
  {
    AppMethodBeat.i(39433);
    n localn = this.rWO.EE(paramInt);
    AppMethodBeat.o(39433);
    return localn;
  }
  
  public final boolean EF(int paramInt)
  {
    AppMethodBeat.i(39435);
    if ((paramInt < this.gMh.getFirstVisiblePosition() - 1) || (paramInt > this.gMh.getLastVisiblePosition() - 1))
    {
      AppMethodBeat.o(39435);
      return false;
    }
    AppMethodBeat.o(39435);
    return true;
  }
  
  public final void W(Runnable paramRunnable)
  {
    AppMethodBeat.i(39431);
    this.rWO.ctD();
    paramRunnable.run();
    AppMethodBeat.o(39431);
  }
  
  public final void a(SnsCommentCollapseLayout paramSnsCommentCollapseLayout)
  {
    AppMethodBeat.i(39418);
    this.rWQ.add(paramSnsCommentCollapseLayout);
    AppMethodBeat.o(39418);
  }
  
  public final void cvS()
  {
    AppMethodBeat.i(39416);
    this.rFT.clear();
    AppMethodBeat.o(39416);
  }
  
  public final t cvT()
  {
    if ((this.cmc instanceof t)) {
      return (t)this.cmc;
    }
    return null;
  }
  
  public final SnsCommentCollapseLayout cvU()
  {
    AppMethodBeat.i(39417);
    if (this.rWQ.size() == 0)
    {
      localSnsCommentCollapseLayout = new SnsCommentCollapseLayout(this.cmc);
      AppMethodBeat.o(39417);
      return localSnsCommentCollapseLayout;
    }
    SnsCommentCollapseLayout localSnsCommentCollapseLayout = (SnsCommentCollapseLayout)this.rWQ.removeFirst();
    AppMethodBeat.o(39417);
    return localSnsCommentCollapseLayout;
  }
  
  public final boolean cvV()
  {
    AppMethodBeat.i(39419);
    if (this.rWQ != null) {
      this.rWQ.clear();
    }
    if (this.rWX != null) {
      this.rWX.clear();
    }
    com.tencent.mm.pluginsdk.ui.d.j.clearCache();
    com.tencent.mm.kiss.widget.textview.c.eLm.SJ();
    AppMethodBeat.o(39419);
    return true;
  }
  
  public final void cvW()
  {
    AppMethodBeat.i(39421);
    this.rWO.ctD();
    AppMethodBeat.o(39421);
  }
  
  public final void cvX()
  {
    AppMethodBeat.i(39423);
    int i = this.gMh.getFirstVisiblePosition() - this.gMh.getHeaderViewsCount();
    int j = this.gMh.getLastVisiblePosition() - this.gMh.getHeaderViewsCount();
    ab.i("MicroMsg.SnsTimeLineBaseAdapter", "reConverItem start ~ end" + i + " " + j);
    int k = this.rWO.getCount();
    if ((i <= j) && (i < k))
    {
      n localn = EE(i);
      Object localObject = (View)this.rWV.get(Integer.valueOf(i));
      if ((localObject == null) || (localn == null) || (((View)localObject).getTag() == null)) {
        ab.e("MicroMsg.SnsTimeLineBaseAdapter", " passe ".concat(String.valueOf(i)));
      }
      for (;;)
      {
        i += 1;
        break;
        localObject = (BaseTimeLineItem.BaseViewHolder)((View)localObject).getTag();
        ab.i("MicroMsg.SnsTimeLineBaseAdapter", "reConverItem " + i + " " + ((BaseTimeLineItem.BaseViewHolder)localObject).position);
        ((BaseTimeLineItem.BaseViewHolder)localObject).shL.a((BaseTimeLineItem.BaseViewHolder)localObject, i, localn);
      }
    }
    AppMethodBeat.o(39423);
  }
  
  public final w cvY()
  {
    return this.rWO;
  }
  
  public final void dR(View paramView)
  {
    AppMethodBeat.i(39432);
    if (!(paramView.getTag() instanceof BaseTimeLineItem.BaseViewHolder))
    {
      AppMethodBeat.o(39432);
      return;
    }
    ab.d("MicroMsg.SnsTimeLineBaseAdapter", "close comment v");
    if ((this.rWS != null) && (this.rWS.getVisibility() == 0))
    {
      this.rWS.startAnimation(this.rOz);
      this.rOz.setAnimationListener(new av.10(this));
    }
    AppMethodBeat.o(39432);
  }
  
  public final int getCount()
  {
    AppMethodBeat.i(39434);
    int i = this.rWO.getCount();
    AppMethodBeat.o(39434);
    return i;
  }
  
  public final int getItemViewType(int paramInt)
  {
    AppMethodBeat.i(39425);
    paramInt = b(this.rWO.EE(paramInt), true);
    AppMethodBeat.o(39425);
    return paramInt;
  }
  
  public final View h(int paramInt, View paramView)
  {
    AppMethodBeat.i(39424);
    n localn = this.rWO.EE(paramInt);
    TimeLineObject localTimeLineObject = localn.csh();
    int j = b(localn, true);
    Object localObject1 = null;
    localObject3 = null;
    Object localObject4 = localObject1;
    Object localObject2 = localObject3;
    int i;
    if (paramView != null)
    {
      localObject2 = paramView.getTag(2131828140);
      if (!(localObject2 instanceof Integer)) {
        break label426;
      }
      i = ((Integer)localObject2).intValue();
      localObject4 = localObject1;
      localObject2 = localObject3;
      if (i == j)
      {
        localObject2 = (BaseTimeLineItem.BaseViewHolder)paramView.getTag();
        localObject4 = ((BaseTimeLineItem.BaseViewHolder)localObject2).shL;
      }
    }
    localObject1 = localObject2;
    localObject3 = paramView;
    if (localObject2 == null) {
      switch (j)
      {
      default: 
        localObject1 = new f();
      }
    }
    for (;;)
    {
      for (;;)
      {
        Iterator localIterator;
        Object localObject6;
        label426:
        try
        {
          if (this.rWX.get(Integer.valueOf(j)) != null)
          {
            localObject3 = (BaseTimeLineItem.BaseViewHolder)((Class)this.rWX.get(Integer.valueOf(j))).newInstance();
            localObject2 = localObject3;
            localObject3 = paramView;
          }
        }
        catch (Exception localException1) {}
        try
        {
          ((BaseTimeLineItem.BaseViewHolder)localObject2).shL = ((BaseTimeLineItem)localObject1);
          localObject3 = paramView;
          ((BaseTimeLineItem.BaseViewHolder)localObject2).timeLineObject = localTimeLineObject;
          localObject3 = paramView;
          paramView = ((BaseTimeLineItem)localObject1).a(this.cmc, (BaseTimeLineItem.BaseViewHolder)localObject2, j, this, localn);
          localObject3 = paramView;
          paramView.setTag(2131828140, Integer.valueOf(j));
          localObject4 = localObject1;
          localObject3 = paramView;
          localObject1 = localObject2;
          ((BaseTimeLineItem)localObject4).setIsFromMainTimeline(this.rNW);
          paramView = localn.getSnsId();
          localObject2 = new ArrayList();
          if (com.tencent.mm.plugin.sns.model.aq.cpH().size() <= 0) {
            break label669;
          }
          localIterator = com.tencent.mm.plugin.sns.model.aq.cpH().keySet().iterator();
          if (!localIterator.hasNext()) {
            break label669;
          }
          localObject6 = (String)localIterator.next();
          if (((String)localObject6).startsWith(paramView))
          {
            localObject6 = (aq.b)com.tencent.mm.plugin.sns.model.aq.cpH().get(localObject6);
            if (com.tencent.mm.plugin.sns.model.aq.c((aq.b)localObject6))
            {
              ((ArrayList)localObject2).add(localObject6);
              continue;
              i = -1;
            }
          }
        }
        catch (Exception localException2)
        {
          for (;;)
          {
            Object localObject5;
            paramView = (View)localObject3;
          }
        }
      }
      localObject1 = new com.tencent.mm.plugin.sns.ui.item.i();
      continue;
      localObject1 = new g();
      continue;
      localObject1 = new g();
      continue;
      localObject1 = new g();
      continue;
      localObject1 = new g();
      continue;
      localObject1 = new e();
      continue;
      localObject1 = new f();
      continue;
      localObject1 = new f();
      continue;
      localObject1 = new f();
      continue;
      localObject1 = new k();
      continue;
      localObject1 = new d();
      continue;
      localObject1 = new com.tencent.mm.plugin.sns.ui.item.j();
      continue;
      localObject1 = new com.tencent.mm.plugin.sns.ui.item.b();
      continue;
      localObject1 = new com.tencent.mm.plugin.sns.ui.item.a();
      continue;
      localObject1 = new com.tencent.mm.plugin.sns.ui.item.c();
      continue;
      localObject1 = new h();
      continue;
      localObject3 = new g.a();
      localObject2 = localObject3;
      continue;
      ab.printErrStackTrace("MicroMsg.SnsTimeLineBaseAdapter", localException1, "create holder error", new Object[0]);
      localObject5 = localObject1;
      localObject1 = localObject2;
      localObject3 = paramView;
    }
    label669:
    localObject5.sgH = ((ArrayList)localObject2);
    localObject5.a((BaseTimeLineItem.BaseViewHolder)localObject1, paramInt, localn, localTimeLineObject, j, this);
    if (com.tencent.mm.plugin.sns.model.aq.dn(localn.getSnsId(), 2))
    {
      paramView = com.tencent.mm.plugin.sns.model.aq.aaD(localn.getSnsId());
      if (localn.field_snsId == 0L) {
        paramView = new aq.b();
      }
      if (paramView.fon) {
        if (!paramView.frX) {
          BaseTimeLineItem.a(paramView, (BaseTimeLineItem.BaseViewHolder)localObject1, paramView.result, paramView.fwM);
        }
      }
    }
    for (;;)
    {
      this.rWV.put(Integer.valueOf(paramInt), localObject3);
      AppMethodBeat.o(39424);
      return localObject3;
      BaseTimeLineItem.f((BaseTimeLineItem.BaseViewHolder)localObject1);
      com.tencent.mm.plugin.sns.model.aq.dm(paramView.id, 2);
      continue;
      BaseTimeLineItem.e((BaseTimeLineItem.BaseViewHolder)localObject1);
      continue;
      BaseTimeLineItem.f((BaseTimeLineItem.BaseViewHolder)localObject1);
    }
  }
  
  public final void notifyDataSetChanged()
  {
    AppMethodBeat.i(39420);
    this.rWO.notifyDataSetChanged();
    AppMethodBeat.o(39420);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.av
 * JD-Core Version:    0.7.0.1
 */