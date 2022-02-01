package com.tencent.mm.plugin.sns.ui.a;

import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ListView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.av.o;
import com.tencent.mm.g.a.bn;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.brandservice.a.d;
import com.tencent.mm.plugin.brandservice.a.d.a;
import com.tencent.mm.plugin.messenger.foundation.a.k;
import com.tencent.mm.plugin.sns.data.q;
import com.tencent.mm.plugin.sns.model.af;
import com.tencent.mm.plugin.sns.model.aj;
import com.tencent.mm.plugin.sns.storage.p;
import com.tencent.mm.plugin.sns.ui.be;
import com.tencent.mm.plugin.sns.ui.bf;
import com.tencent.mm.plugin.sns.ui.y;
import com.tencent.mm.pluginsdk.model.r;
import com.tencent.mm.protocal.protobuf.SnsObject;
import com.tencent.mm.protocal.protobuf.TimeLineObject;
import com.tencent.mm.protocal.protobuf.bsj;
import com.tencent.mm.protocal.protobuf.ej;
import com.tencent.mm.protocal.protobuf.zf;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ao;
import com.tencent.mm.sdk.platformtools.bs;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.vending.base.Vending.d;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Map.Entry;
import java.util.Set;

public final class c
  extends BaseAdapter
  implements y
{
  private static int nuJ;
  private static HashMap<Long, a> yZp;
  private static boolean yZq;
  private boolean gha;
  private Vending.d yTk;
  public be yZm;
  public com.tencent.mm.plugin.sns.ui.a.b.b yZn;
  public boolean yZo;
  
  static
  {
    AppMethodBeat.i(99831);
    yZp = new HashMap();
    yZq = false;
    nuJ = 2;
    AppMethodBeat.o(99831);
  }
  
  public c(MMActivity paramMMActivity, ListView paramListView, com.tencent.mm.plugin.sns.ui.d.b paramb, com.tencent.mm.plugin.sns.ui.i parami, String paramString, com.tencent.mm.plugin.sns.ui.a.b.b paramb1, Vending.d paramd)
  {
    AppMethodBeat.i(179319);
    this.gha = false;
    this.yTk = new Vending.d()
    {
      public final void dQM()
      {
        AppMethodBeat.i(99813);
        if (!c.a(c.this))
        {
          c.this.notifyDataSetChanged();
          bn localbn = new bn();
          com.tencent.mm.sdk.b.a.GpY.l(localbn);
        }
        AppMethodBeat.o(99813);
      }
    };
    this.yZm = new be(paramMMActivity, paramListView, paramb, parami, this);
    this.yZm.yIK = true;
    paramListView = paramb1;
    if (paramb1 == null) {
      paramListView = new com.tencent.mm.plugin.sns.ui.a.b.c();
    }
    this.yZn = paramListView;
    this.yZn.a(paramMMActivity, this.yZm, paramString);
    paramMMActivity = this.yZn;
    com.tencent.mm.vending.f.a.i("Vending.ForwardVending", "Vending.setRangeSize(%s)", new Object[] { Integer.valueOf(10) });
    paramMMActivity.JpG = 10;
    this.yZn.addVendingDataChangedCallback(paramd);
    AppMethodBeat.o(179319);
  }
  
  public static void Q(p paramp)
  {
    AppMethodBeat.i(99824);
    af.dvq().post(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(99814);
        long l1;
        c.a locala;
        if (this.yyo != null)
        {
          l1 = this.yyo.field_snsId;
          if (!c.yZp.containsKey(Long.valueOf(l1)))
          {
            locala = new c.a();
            if ((this.yyo.dLV() != null) && (this.yyo.dLV().FQo != null) && (this.yyo.dLV().FQo.Ety == 1) && (this.yyo.dLV().FQo.Etz != null) && (this.yyo.dLV().FQo.Etz.size() > 0))
            {
              locala.hlt = this.yyo.dLV().FQo.Etz.size();
              locala.yZu = new HashSet();
              locala.yZv = new HashSet();
              locala.yZw = new HashSet();
              locala.yZx = new HashSet();
              locala.id = this.yyo.dLV().Id;
              locala.yZC = this.yyo.dLV().exP;
            }
          }
        }
        try
        {
          SnsObject localSnsObject = aj.t(this.yyo);
          locala.yZA = localSnsObject.LikeCount;
          locala.yZB = localSnsObject.CommentCount;
        }
        catch (Exception localException1)
        {
          try
          {
            for (;;)
            {
              g.agS();
              locala.sAS = ((k)g.ab(k.class)).dcr().aly(this.yyo.field_userName);
              long l2 = System.currentTimeMillis();
              g.agS();
              locala.yZz = ((l2 - ((k)g.ab(k.class)).dcr().alC(this.yyo.field_userName)) / 1000L);
              c.yZp.put(Long.valueOf(l1), locala);
              AppMethodBeat.o(99814);
              return;
              localException1 = localException1;
              locala.yZA = 0;
              locala.yZB = 0;
            }
          }
          catch (Exception localException2)
          {
            for (;;)
            {
              locala.sAS = 0;
              locala.yZz = 0L;
            }
          }
        }
      }
    });
    AppMethodBeat.o(99824);
  }
  
  public static void dRy()
  {
    AppMethodBeat.i(99827);
    af.dvq().post(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(99817);
        Iterator localIterator = c.yZp.entrySet().iterator();
        while (localIterator.hasNext())
        {
          c.a locala = (c.a)((Map.Entry)localIterator.next()).getValue();
          locala.networkType = q.dGB();
          ac.d("MicroMsg.SnsTimeLineVendingAdapter", "report big pic click, picNum:%d, clickPicNum:%d, firstClickPos:%d, networkType:%d, id:%s", new Object[] { Integer.valueOf(locala.hlt), Integer.valueOf(locala.yZu.size()), Integer.valueOf(locala.yZy), Integer.valueOf(locala.networkType), locala.id });
          Object localObject1 = locala.yZv.iterator();
          for (String str = ""; ((Iterator)localObject1).hasNext(); str = str + localObject2 + "|") {
            localObject2 = (Integer)((Iterator)localObject1).next();
          }
          localObject1 = str;
          if (str.length() >= 2) {
            localObject1 = str.substring(0, str.length() - 1);
          }
          Object localObject2 = locala.yZw.iterator();
          for (str = ""; ((Iterator)localObject2).hasNext(); str = str + localObject3 + "|") {
            localObject3 = (Integer)((Iterator)localObject2).next();
          }
          localObject2 = str;
          if (str.length() >= 2) {
            localObject2 = str.substring(0, str.length() - 1);
          }
          Object localObject3 = locala.yZx.iterator();
          Integer localInteger;
          for (str = ""; ((Iterator)localObject3).hasNext(); str = str + localInteger + "|") {
            localInteger = (Integer)((Iterator)localObject3).next();
          }
          localObject3 = str;
          if (str.length() >= 2) {
            localObject3 = str.substring(0, str.length() - 1);
          }
          com.tencent.mm.plugin.report.service.h.wUl.f(11599, new Object[] { Integer.valueOf(locala.hlt), Integer.valueOf(locala.yZu.size()), Integer.valueOf(locala.yZy), Integer.valueOf(locala.networkType), Integer.valueOf(0), locala.id, Long.valueOf(locala.yZz), Integer.valueOf(locala.sAS), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(locala.yZA), Integer.valueOf(locala.yZB), Integer.valueOf(0), localObject1, localObject2, localObject3, Integer.valueOf(0), "", Integer.valueOf(locala.yZC) });
        }
        c.yZp.clear();
        AppMethodBeat.o(99817);
      }
    });
    AppMethodBeat.o(99827);
  }
  
  public static void f(p paramp, final int paramInt)
  {
    AppMethodBeat.i(99825);
    af.dvq().post(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(99815);
        if (this.yyo != null)
        {
          long l = this.yyo.field_snsId;
          if (c.yZp.containsKey(Long.valueOf(l)))
          {
            c.a locala = (c.a)c.yZp.get(Long.valueOf(l));
            if (locala.yZy == 0) {
              locala.yZy = (paramInt + 1);
            }
            if (locala.yZu == null) {
              locala.yZu = new HashSet();
            }
            locala.yZu.add(Integer.valueOf(paramInt + 1));
          }
        }
        AppMethodBeat.o(99815);
      }
    });
    AppMethodBeat.o(99825);
  }
  
  public static void g(p paramp, final int paramInt)
  {
    AppMethodBeat.i(99826);
    af.dvq().post(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(99816);
        if (this.yyo != null)
        {
          long l = this.yyo.field_snsId;
          if (c.yZp.containsKey(Long.valueOf(l)))
          {
            c.a locala = (c.a)c.yZp.get(Long.valueOf(l));
            if (locala.yZv == null) {
              locala.yZv = new HashSet();
            }
            if (!locala.yZv.contains(Integer.valueOf(paramInt + 1))) {
              locala.yZv.add(Integer.valueOf(paramInt + 1));
            }
          }
        }
        AppMethodBeat.o(99816);
      }
    });
    AppMethodBeat.o(99826);
  }
  
  public static void g(TimeLineObject paramTimeLineObject)
  {
    AppMethodBeat.i(99828);
    if ((paramTimeLineObject.FQo == null) || (TextUtils.isEmpty(paramTimeLineObject.FQo.Url)))
    {
      AppMethodBeat.o(99828);
      return;
    }
    d locald = (d)g.ab(d.class);
    String str2 = paramTimeLineObject.FQo.Url;
    int i = nuJ;
    if (paramTimeLineObject.FQn != null) {}
    for (String str1 = paramTimeLineObject.FQn.Id;; str1 = "")
    {
      locald.a(str2, i, str1, paramTimeLineObject.FQo.Title, paramTimeLineObject.FQo.Desc, "timeline", 1);
      AppMethodBeat.o(99828);
      return;
    }
  }
  
  public static void h(TimeLineObject paramTimeLineObject)
  {
    AppMethodBeat.i(99829);
    if ((TextUtils.isEmpty(paramTimeLineObject.FQo.Url)) || (!paramTimeLineObject.FQo.Url.contains("mp.weixin.qq.com")))
    {
      AppMethodBeat.o(99829);
      return;
    }
    if (paramTimeLineObject.FQo.EtC != null) {}
    for (int i = paramTimeLineObject.FQo.EtC.hkQ;; i = -1)
    {
      ((com.tencent.mm.plugin.brandservice.a.b)g.ab(com.tencent.mm.plugin.brandservice.a.b.class)).a(paramTimeLineObject.FQo.Url, i, nuJ, new Object[] { paramTimeLineObject.Id, null, null, paramTimeLineObject.ncR, Integer.valueOf(paramTimeLineObject.CreateTime), Long.valueOf(((com.tencent.mm.plugin.brandservice.a.b)g.ab(com.tencent.mm.plugin.brandservice.a.b.class)).Tj("__sns_timeline__")) });
      if ((!yZq) && (i != -1) && (((com.tencent.mm.plugin.brandservice.a.b)g.ab(com.tencent.mm.plugin.brandservice.a.b.class)).ys(24)))
      {
        yZq = true;
        ((com.tencent.mm.plugin.brandservice.a.b)g.ab(com.tencent.mm.plugin.brandservice.a.b.class)).yt(nuJ);
      }
      if ((i == 5) && (((com.tencent.mm.plugin.brandservice.a.b)g.ab(com.tencent.mm.plugin.brandservice.a.b.class)).bIP()) && (paramTimeLineObject.FQo.EtC != null) && (!bs.isNullOrNil(paramTimeLineObject.FQo.EtC.coverUrl)))
      {
        paramTimeLineObject = com.tencent.mm.api.b.q(paramTimeLineObject.FQo.EtC.coverUrl, 4);
        Object localObject = r.aGc(paramTimeLineObject);
        if (!com.tencent.mm.vfs.i.eA((String)localObject))
        {
          com.tencent.mm.av.a.a.c.a locala = new com.tencent.mm.av.a.a.c.a();
          locala.hKx = true;
          locala.gKe = ((String)localObject);
          localObject = locala.aFT();
          o.aFB().a(paramTimeLineObject, (com.tencent.mm.av.a.a.c)localObject, null);
        }
      }
      AppMethodBeat.o(99829);
      return;
    }
  }
  
  public final p Pl(int paramInt)
  {
    AppMethodBeat.i(99823);
    Object localObject = (bf)this.yZn.get(paramInt);
    if (localObject == null)
    {
      AppMethodBeat.o(99823);
      return null;
    }
    localObject = ((bf)localObject).xHc;
    AppMethodBeat.o(99823);
    return localObject;
  }
  
  public final void dNz()
  {
    AppMethodBeat.i(210274);
    this.yZn.notifyVendingDataChange();
    AppMethodBeat.o(210274);
  }
  
  public final long dRz()
  {
    AppMethodBeat.i(200647);
    int i = 0;
    int j = getCount() - 1;
    p localp = Pl(j);
    if ((localp != null) && (!localp.Pe(32)) && (localp.field_snsId != 0L)) {}
    for (long l = localp.field_snsId;; l = 0L)
    {
      AppMethodBeat.o(200647);
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
    return this.yZn.mCount;
  }
  
  public final long getItemId(int paramInt)
  {
    return 0L;
  }
  
  public final int getItemViewType(int paramInt)
  {
    AppMethodBeat.i(99821);
    paramInt = this.yZm.getItemViewType(paramInt);
    AppMethodBeat.o(99821);
    return paramInt;
  }
  
  public final View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    AppMethodBeat.i(99820);
    paramView = this.yZm.l(paramInt, paramView);
    AppMethodBeat.o(99820);
    return paramView;
  }
  
  public final int getViewTypeCount()
  {
    return 17;
  }
  
  public final void hD(int paramInt1, int paramInt2)
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
      localObject = Pl(paramInt1 - 1);
      TimeLineObject localTimeLineObject;
      d.a locala;
      if (localObject != null)
      {
        localTimeLineObject = ((p)localObject).dLV();
        if ((localTimeLineObject != null) && (localTimeLineObject.FQo != null) && (!TextUtils.isEmpty(localTimeLineObject.FQo.Url)))
        {
          locala = new d.a();
          locala.url = localTimeLineObject.FQo.Url;
          locala.nuJ = nuJ;
          if (localTimeLineObject.FQn == null) {
            break label178;
          }
        }
      }
      label178:
      for (localObject = localTimeLineObject.FQn.Id;; localObject = "")
      {
        locala.appId = ((String)localObject);
        locala.title = localTimeLineObject.FQo.Title;
        locala.desc = localTimeLineObject.FQo.Desc;
        locala.dsT = "timeline";
        localLinkedList.add(locala);
        paramInt1 += 1;
        break;
      }
    }
    Object localObject = (d)g.ab(d.class);
    if ((localObject != null) && (localLinkedList.size() > 0))
    {
      ac.v("MicroMsg.SnsTimeLineVendingAdapter", "[TRACE_PREFETCH] checkPreAuths authInfo size = %s", new Object[] { Integer.valueOf(localLinkedList.size()) });
      ((d)localObject).l(localLinkedList, 1);
    }
    AppMethodBeat.o(160747);
  }
  
  public final long rt(boolean paramBoolean)
  {
    AppMethodBeat.i(179321);
    int i = 0;
    int j = 0;
    for (;;)
    {
      p localp = Pl(i);
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
        if ((localp != null) && (!localp.Pe(32)) && (localp.field_snsId != 0L))
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
  
  public final void tX()
  {
    AppMethodBeat.i(99819);
    if (this.gha)
    {
      AppMethodBeat.o(99819);
      return;
    }
    this.gha = true;
    this.yZn.notifyVendingDataChangeSynchronize();
    AppMethodBeat.o(99819);
  }
  
  static final class a
  {
    int hlt;
    String id;
    int networkType;
    int sAS;
    int yZA;
    int yZB;
    int yZC;
    HashSet<Integer> yZu;
    HashSet<Integer> yZv;
    HashSet<Integer> yZw;
    HashSet<Integer> yZx;
    int yZy;
    long yZz;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.a.c
 * JD-Core Version:    0.7.0.1
 */