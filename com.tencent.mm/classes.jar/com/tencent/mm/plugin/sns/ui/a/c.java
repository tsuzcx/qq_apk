package com.tencent.mm.plugin.sns.ui.a;

import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ListView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.av.q;
import com.tencent.mm.g.a.bq;
import com.tencent.mm.plugin.brandservice.a.d;
import com.tencent.mm.plugin.brandservice.a.d.a;
import com.tencent.mm.plugin.messenger.foundation.a.l;
import com.tencent.mm.plugin.sns.model.ah;
import com.tencent.mm.plugin.sns.model.al;
import com.tencent.mm.plugin.sns.storage.p;
import com.tencent.mm.plugin.sns.ui.bh;
import com.tencent.mm.plugin.sns.ui.bi;
import com.tencent.mm.plugin.sns.ui.z;
import com.tencent.mm.protocal.protobuf.SnsObject;
import com.tencent.mm.protocal.protobuf.TimeLineObject;
import com.tencent.mm.protocal.protobuf.abo;
import com.tencent.mm.protocal.protobuf.bxq;
import com.tencent.mm.protocal.protobuf.en;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.aq;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.vending.base.Vending.d;
import com.tencent.mm.vfs.o;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Map.Entry;
import java.util.Set;

public final class c
  extends BaseAdapter
  implements z
{
  private static HashMap<Long, a> AIt;
  private static boolean AIu;
  private static int obQ;
  private Vending.d ACe;
  public bh AIq;
  public com.tencent.mm.plugin.sns.ui.a.b.b AIr;
  public boolean AIs;
  private boolean gDr;
  
  static
  {
    AppMethodBeat.i(99831);
    AIt = new HashMap();
    AIu = false;
    obQ = 2;
    AppMethodBeat.o(99831);
  }
  
  public c(MMActivity paramMMActivity, ListView paramListView, com.tencent.mm.plugin.sns.ui.d.c paramc, com.tencent.mm.plugin.sns.ui.i parami, String paramString, com.tencent.mm.plugin.sns.ui.a.b.b paramb, Vending.d paramd)
  {
    AppMethodBeat.i(179319);
    this.gDr = false;
    this.ACe = new Vending.d()
    {
      public final void egL()
      {
        AppMethodBeat.i(99813);
        if (!c.a(c.this))
        {
          c.this.notifyDataSetChanged();
          bq localbq = new bq();
          com.tencent.mm.sdk.b.a.IvT.l(localbq);
        }
        AppMethodBeat.o(99813);
      }
    };
    this.AIq = new bh(paramMMActivity, paramListView, paramc, parami, this);
    this.AIq.Arr = true;
    paramListView = paramb;
    if (paramb == null) {
      paramListView = new com.tencent.mm.plugin.sns.ui.a.b.c();
    }
    this.AIr = paramListView;
    this.AIr.a(paramMMActivity, this.AIq, paramString);
    paramMMActivity = this.AIr;
    com.tencent.mm.vending.f.a.i("Vending.ForwardVending", "Vending.setRangeSize(%s)", new Object[] { Integer.valueOf(10) });
    paramMMActivity.LDN = 10;
    this.AIr.addVendingDataChangedCallback(paramd);
    AppMethodBeat.o(179319);
  }
  
  public static void S(p paramp)
  {
    AppMethodBeat.i(99824);
    ah.dJc().post(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(99814);
        long l1;
        c.a locala;
        if (this.AgF != null)
        {
          l1 = this.AgF.field_snsId;
          if (!c.AIt.containsKey(Long.valueOf(l1)))
          {
            locala = new c.a();
            if ((this.AgF.ebP() != null) && (this.AgF.ebP().HUG != null) && (this.AgF.ebP().HUG.Gtw == 1) && (this.AgF.ebP().HUG.Gtx != null) && (this.AgF.ebP().HUG.Gtx.size() > 0))
            {
              locala.hGu = this.AgF.ebP().HUG.Gtx.size();
              locala.AIy = new HashSet();
              locala.AIz = new HashSet();
              locala.AIA = new HashSet();
              locala.AIB = new HashSet();
              locala.id = this.AgF.ebP().Id;
              locala.AIG = this.AgF.ebP().eQZ;
            }
          }
        }
        try
        {
          SnsObject localSnsObject = al.v(this.AgF);
          locala.AIE = localSnsObject.LikeCount;
          locala.AIF = localSnsObject.CommentCount;
        }
        catch (Exception localException1)
        {
          try
          {
            for (;;)
            {
              com.tencent.mm.kernel.g.ajS();
              locala.tIk = ((l)com.tencent.mm.kernel.g.ab(l.class)).doJ().arr(this.AgF.field_userName);
              long l2 = System.currentTimeMillis();
              com.tencent.mm.kernel.g.ajS();
              locala.AID = ((l2 - ((l)com.tencent.mm.kernel.g.ab(l.class)).doJ().arv(this.AgF.field_userName)) / 1000L);
              c.AIt.put(Long.valueOf(l1), locala);
              AppMethodBeat.o(99814);
              return;
              localException1 = localException1;
              locala.AIE = 0;
              locala.AIF = 0;
            }
          }
          catch (Exception localException2)
          {
            for (;;)
            {
              locala.tIk = 0;
              locala.AID = 0L;
            }
          }
        }
      }
    });
    AppMethodBeat.o(99824);
  }
  
  public static void ehz()
  {
    AppMethodBeat.i(99827);
    ah.dJc().post(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(99817);
        Iterator localIterator = c.AIt.entrySet().iterator();
        while (localIterator.hasNext())
        {
          c.a locala = (c.a)((Map.Entry)localIterator.next()).getValue();
          locala.networkType = com.tencent.mm.plugin.sns.data.r.dWo();
          ae.d("MicroMsg.SnsTimeLineVendingAdapter", "report big pic click, picNum:%d, clickPicNum:%d, firstClickPos:%d, networkType:%d, id:%s", new Object[] { Integer.valueOf(locala.hGu), Integer.valueOf(locala.AIy.size()), Integer.valueOf(locala.AIC), Integer.valueOf(locala.networkType), locala.id });
          Object localObject1 = locala.AIz.iterator();
          for (String str = ""; ((Iterator)localObject1).hasNext(); str = str + localObject2 + "|") {
            localObject2 = (Integer)((Iterator)localObject1).next();
          }
          localObject1 = str;
          if (str.length() >= 2) {
            localObject1 = str.substring(0, str.length() - 1);
          }
          Object localObject2 = locala.AIA.iterator();
          for (str = ""; ((Iterator)localObject2).hasNext(); str = str + localObject3 + "|") {
            localObject3 = (Integer)((Iterator)localObject2).next();
          }
          localObject2 = str;
          if (str.length() >= 2) {
            localObject2 = str.substring(0, str.length() - 1);
          }
          Object localObject3 = locala.AIB.iterator();
          Integer localInteger;
          for (str = ""; ((Iterator)localObject3).hasNext(); str = str + localInteger + "|") {
            localInteger = (Integer)((Iterator)localObject3).next();
          }
          localObject3 = str;
          if (str.length() >= 2) {
            localObject3 = str.substring(0, str.length() - 1);
          }
          com.tencent.mm.plugin.report.service.g.yxI.f(11599, new Object[] { Integer.valueOf(locala.hGu), Integer.valueOf(locala.AIy.size()), Integer.valueOf(locala.AIC), Integer.valueOf(locala.networkType), Integer.valueOf(0), locala.id, Long.valueOf(locala.AID), Integer.valueOf(locala.tIk), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(locala.AIE), Integer.valueOf(locala.AIF), Integer.valueOf(0), localObject1, localObject2, localObject3, Integer.valueOf(0), "", Integer.valueOf(locala.AIG) });
        }
        c.AIt.clear();
        AppMethodBeat.o(99817);
      }
    });
    AppMethodBeat.o(99827);
  }
  
  public static void g(p paramp, final int paramInt)
  {
    AppMethodBeat.i(99825);
    ah.dJc().post(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(99815);
        if (this.AgF != null)
        {
          long l = this.AgF.field_snsId;
          if (c.AIt.containsKey(Long.valueOf(l)))
          {
            c.a locala = (c.a)c.AIt.get(Long.valueOf(l));
            if (locala.AIC == 0) {
              locala.AIC = (paramInt + 1);
            }
            if (locala.AIy == null) {
              locala.AIy = new HashSet();
            }
            locala.AIy.add(Integer.valueOf(paramInt + 1));
          }
        }
        AppMethodBeat.o(99815);
      }
    });
    AppMethodBeat.o(99825);
  }
  
  public static void g(TimeLineObject paramTimeLineObject)
  {
    AppMethodBeat.i(99828);
    if ((paramTimeLineObject.HUG == null) || (TextUtils.isEmpty(paramTimeLineObject.HUG.Url)))
    {
      AppMethodBeat.o(99828);
      return;
    }
    d locald = (d)com.tencent.mm.kernel.g.ab(d.class);
    String str2 = paramTimeLineObject.HUG.Url;
    int i = obQ;
    if (paramTimeLineObject.HUF != null) {}
    for (String str1 = paramTimeLineObject.HUF.Id;; str1 = "")
    {
      locald.a(str2, i, str1, paramTimeLineObject.HUG.Title, paramTimeLineObject.HUG.Desc, "timeline", 1);
      AppMethodBeat.o(99828);
      return;
    }
  }
  
  public static void h(p paramp, final int paramInt)
  {
    AppMethodBeat.i(99826);
    ah.dJc().post(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(99816);
        if (this.AgF != null)
        {
          long l = this.AgF.field_snsId;
          if (c.AIt.containsKey(Long.valueOf(l)))
          {
            c.a locala = (c.a)c.AIt.get(Long.valueOf(l));
            if (locala.AIz == null) {
              locala.AIz = new HashSet();
            }
            if (!locala.AIz.contains(Integer.valueOf(paramInt + 1))) {
              locala.AIz.add(Integer.valueOf(paramInt + 1));
            }
          }
        }
        AppMethodBeat.o(99816);
      }
    });
    AppMethodBeat.o(99826);
  }
  
  public static void h(TimeLineObject paramTimeLineObject)
  {
    AppMethodBeat.i(99829);
    if ((TextUtils.isEmpty(paramTimeLineObject.HUG.Url)) || (!paramTimeLineObject.HUG.Url.contains("mp.weixin.qq.com")))
    {
      AppMethodBeat.o(99829);
      return;
    }
    if (paramTimeLineObject.HUG.GtA != null) {}
    for (int i = paramTimeLineObject.HUG.GtA.hFR;; i = -1)
    {
      ((com.tencent.mm.plugin.brandservice.a.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.brandservice.a.b.class)).a(paramTimeLineObject.HUG.Url, i, obQ, new Object[] { paramTimeLineObject.Id, null, null, paramTimeLineObject.nIJ, Integer.valueOf(paramTimeLineObject.CreateTime), Long.valueOf(((com.tencent.mm.plugin.brandservice.a.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.brandservice.a.b.class)).XB("__sns_timeline__")) });
      if ((!AIu) && (i != -1) && (((com.tencent.mm.plugin.brandservice.a.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.brandservice.a.b.class)).zl(24)))
      {
        AIu = true;
        ((com.tencent.mm.plugin.brandservice.a.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.brandservice.a.b.class)).zm(obQ);
      }
      if ((i == 5) && (((com.tencent.mm.plugin.brandservice.a.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.brandservice.a.b.class)).bOe()) && (paramTimeLineObject.HUG.GtA != null) && (!bu.isNullOrNil(paramTimeLineObject.HUG.GtA.coverUrl)))
      {
        paramTimeLineObject = com.tencent.mm.api.b.t(paramTimeLineObject.HUG.GtA.coverUrl, 4);
        Object localObject = com.tencent.mm.pluginsdk.model.r.aMY(paramTimeLineObject);
        if (!o.fB((String)localObject))
        {
          com.tencent.mm.av.a.a.c.a locala = new com.tencent.mm.av.a.a.c.a();
          locala.igk = true;
          locala.hgD = ((String)localObject);
          localObject = locala.aJu();
          q.aJb().a(paramTimeLineObject, (com.tencent.mm.av.a.a.c)localObject, null);
        }
      }
      AppMethodBeat.o(99829);
      return;
    }
  }
  
  public final p RA(int paramInt)
  {
    AppMethodBeat.i(99823);
    Object localObject = (bi)this.AIr.get(paramInt);
    if (localObject == null)
    {
      AppMethodBeat.o(99823);
      return null;
    }
    localObject = ((bi)localObject).zlW;
    AppMethodBeat.o(99823);
    return localObject;
  }
  
  public final void edu()
  {
    AppMethodBeat.i(224111);
    this.AIr.notifyVendingDataChange();
    AppMethodBeat.o(224111);
  }
  
  public final long ehA()
  {
    AppMethodBeat.i(220071);
    int i = 0;
    int j = getCount() - 1;
    p localp = RA(j);
    if ((localp != null) && (!localp.Rt(32)) && (localp.field_snsId != 0L)) {}
    for (long l = localp.field_snsId;; l = 0L)
    {
      AppMethodBeat.o(220071);
      return l;
      int k = i + 1;
      j -= 1;
      if (j >= 0)
      {
        i = k;
        if (k <= 500) {
          break;
        }
      }
    }
  }
  
  public final int getCount()
  {
    return this.AIr.mCount;
  }
  
  public final long getItemId(int paramInt)
  {
    return 0L;
  }
  
  public final int getItemViewType(int paramInt)
  {
    AppMethodBeat.i(99821);
    paramInt = this.AIq.getItemViewType(paramInt);
    AppMethodBeat.o(99821);
    return paramInt;
  }
  
  public final View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    AppMethodBeat.i(99820);
    paramView = this.AIq.m(paramInt, paramView);
    AppMethodBeat.o(99820);
    return paramView;
  }
  
  public final int getViewTypeCount()
  {
    return 20;
  }
  
  public final void hX(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(160747);
    if (paramInt2 < paramInt1)
    {
      AppMethodBeat.o(160747);
      return;
    }
    LinkedList localLinkedList = new LinkedList();
    if (paramInt1 <= paramInt2)
    {
      localObject = RA(paramInt1 - 1);
      TimeLineObject localTimeLineObject;
      d.a locala;
      if (localObject != null)
      {
        localTimeLineObject = ((p)localObject).ebP();
        if ((localTimeLineObject != null) && (localTimeLineObject.HUG != null) && (!TextUtils.isEmpty(localTimeLineObject.HUG.Url)))
        {
          locala = new d.a();
          locala.url = localTimeLineObject.HUG.Url;
          locala.obQ = obQ;
          if (localTimeLineObject.HUF == null) {
            break label178;
          }
        }
      }
      label178:
      for (localObject = localTimeLineObject.HUF.Id;; localObject = "")
      {
        locala.appId = ((String)localObject);
        locala.title = localTimeLineObject.HUG.Title;
        locala.desc = localTimeLineObject.HUG.Desc;
        locala.dFY = "timeline";
        localLinkedList.add(locala);
        paramInt1 += 1;
        break;
      }
    }
    Object localObject = (d)com.tencent.mm.kernel.g.ab(d.class);
    if ((localObject != null) && (localLinkedList.size() > 0))
    {
      ae.v("MicroMsg.SnsTimeLineVendingAdapter", "[TRACE_PREFETCH] checkPreAuths authInfo size = %s", new Object[] { Integer.valueOf(localLinkedList.size()) });
      ((d)localObject).m(localLinkedList, 1);
    }
    AppMethodBeat.o(160747);
  }
  
  public final long sg(boolean paramBoolean)
  {
    AppMethodBeat.i(179321);
    int i = 0;
    int j = 0;
    for (;;)
    {
      p localp = RA(i);
      long l;
      if (paramBoolean)
      {
        if ((localp == null) || (localp.field_snsId == 0L)) {
          break label87;
        }
        l = localp.field_snsId;
      }
      for (;;)
      {
        AppMethodBeat.o(179321);
        return l;
        if ((localp != null) && (!localp.Rt(32)) && (localp.field_snsId != 0L))
        {
          l = localp.field_snsId;
        }
        else
        {
          label87:
          j += 1;
          i += 1;
          if ((i < getCount()) && (j <= 500)) {
            break;
          }
          l = 0L;
        }
      }
    }
  }
  
  public final void vw()
  {
    AppMethodBeat.i(99819);
    if (this.gDr)
    {
      AppMethodBeat.o(99819);
      return;
    }
    this.gDr = true;
    this.AIr.notifyVendingDataChangeSynchronize();
    AppMethodBeat.o(99819);
  }
  
  static final class a
  {
    HashSet<Integer> AIA;
    HashSet<Integer> AIB;
    int AIC;
    long AID;
    int AIE;
    int AIF;
    int AIG;
    HashSet<Integer> AIy;
    HashSet<Integer> AIz;
    int hGu;
    String id;
    int networkType;
    int tIk;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.a.c
 * JD-Core Version:    0.7.0.1
 */