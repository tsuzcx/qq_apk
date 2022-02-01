package com.tencent.mm.plugin.sns.ui.a;

import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ListView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.aw.o;
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
import com.tencent.mm.protocal.protobuf.bnt;
import com.tencent.mm.protocal.protobuf.eh;
import com.tencent.mm.protocal.protobuf.yk;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.ap;
import com.tencent.mm.sdk.platformtools.bt;
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
  private static int mSu;
  private static HashMap<Long, a> xMA;
  private static boolean xMB;
  private boolean gcu;
  private Vending.d xGx;
  public be xMx;
  public com.tencent.mm.plugin.sns.ui.a.b.b xMy;
  public boolean xMz;
  
  static
  {
    AppMethodBeat.i(99831);
    xMA = new HashMap();
    xMB = false;
    mSu = 2;
    AppMethodBeat.o(99831);
  }
  
  public c(MMActivity paramMMActivity, ListView paramListView, com.tencent.mm.plugin.sns.ui.d.b paramb, com.tencent.mm.plugin.sns.ui.i parami, String paramString, com.tencent.mm.plugin.sns.ui.a.b.b paramb1, Vending.d paramd)
  {
    AppMethodBeat.i(179319);
    this.gcu = false;
    this.xGx = new Vending.d()
    {
      public final void dCq()
      {
        AppMethodBeat.i(99813);
        if (!c.a(c.this))
        {
          c.this.notifyDataSetChanged();
          bn localbn = new bn();
          com.tencent.mm.sdk.b.a.ESL.l(localbn);
        }
        AppMethodBeat.o(99813);
      }
    };
    this.xMx = new be(paramMMActivity, paramListView, paramb, parami, this);
    this.xMx.xvU = true;
    paramListView = paramb1;
    if (paramb1 == null) {
      paramListView = new com.tencent.mm.plugin.sns.ui.a.b.c();
    }
    this.xMy = paramListView;
    this.xMy.a(paramMMActivity, this.xMx, paramString);
    paramMMActivity = this.xMy;
    com.tencent.mm.vending.f.a.i("Vending.ForwardVending", "Vending.setRangeSize(%s)", new Object[] { Integer.valueOf(10) });
    paramMMActivity.HPl = 10;
    this.xMy.addVendingDataChangedCallback(paramd);
    AppMethodBeat.o(179319);
  }
  
  public static void P(p paramp)
  {
    AppMethodBeat.i(99824);
    af.dhI().post(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(99814);
        long l1;
        c.a locala;
        if (this.xlw != null)
        {
          l1 = this.xlw.field_snsId;
          if (!c.biV().containsKey(Long.valueOf(l1)))
          {
            locala = new c.a();
            if ((this.xlw.dxy() != null) && (this.xlw.dxy().Etm != null) && (this.xlw.dxy().Etm.DaB == 1) && (this.xlw.dxy().Etm.DaC != null) && (this.xlw.dxy().Etm.DaC.size() > 0))
            {
              locala.gKT = this.xlw.dxy().Etm.DaC.size();
              locala.xMF = new HashSet();
              locala.xMG = new HashSet();
              locala.xMH = new HashSet();
              locala.xMI = new HashSet();
              locala.id = this.xlw.dxy().Id;
              locala.xMN = this.xlw.dxy().evt;
            }
          }
        }
        try
        {
          SnsObject localSnsObject = aj.t(this.xlw);
          locala.xML = localSnsObject.LikeCount;
          locala.xMM = localSnsObject.CommentCount;
        }
        catch (Exception localException1)
        {
          try
          {
            for (;;)
            {
              g.afC();
              locala.rrY = ((k)g.ab(k.class)).cOI().agE(this.xlw.field_userName);
              long l2 = System.currentTimeMillis();
              g.afC();
              locala.xMK = ((l2 - ((k)g.ab(k.class)).cOI().agI(this.xlw.field_userName)) / 1000L);
              c.biV().put(Long.valueOf(l1), locala);
              AppMethodBeat.o(99814);
              return;
              localException1 = localException1;
              locala.xML = 0;
              locala.xMM = 0;
            }
          }
          catch (Exception localException2)
          {
            for (;;)
            {
              locala.rrY = 0;
              locala.xMK = 0L;
            }
          }
        }
      }
    });
    AppMethodBeat.o(99824);
  }
  
  public static void dDb()
  {
    AppMethodBeat.i(99827);
    af.dhI().post(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(99817);
        Iterator localIterator = c.biV().entrySet().iterator();
        while (localIterator.hasNext())
        {
          c.a locala = (c.a)((Map.Entry)localIterator.next()).getValue();
          locala.networkType = q.dsc();
          ad.d("MicroMsg.SnsTimeLineVendingAdapter", "report big pic click, picNum:%d, clickPicNum:%d, firstClickPos:%d, networkType:%d, id:%s", new Object[] { Integer.valueOf(locala.gKT), Integer.valueOf(locala.xMF.size()), Integer.valueOf(locala.xMJ), Integer.valueOf(locala.networkType), locala.id });
          Object localObject1 = locala.xMG.iterator();
          for (String str = ""; ((Iterator)localObject1).hasNext(); str = str + localObject2 + "|") {
            localObject2 = (Integer)((Iterator)localObject1).next();
          }
          localObject1 = str;
          if (str.length() >= 2) {
            localObject1 = str.substring(0, str.length() - 1);
          }
          Object localObject2 = locala.xMH.iterator();
          for (str = ""; ((Iterator)localObject2).hasNext(); str = str + localObject3 + "|") {
            localObject3 = (Integer)((Iterator)localObject2).next();
          }
          localObject2 = str;
          if (str.length() >= 2) {
            localObject2 = str.substring(0, str.length() - 1);
          }
          Object localObject3 = locala.xMI.iterator();
          Integer localInteger;
          for (str = ""; ((Iterator)localObject3).hasNext(); str = str + localInteger + "|") {
            localInteger = (Integer)((Iterator)localObject3).next();
          }
          localObject3 = str;
          if (str.length() >= 2) {
            localObject3 = str.substring(0, str.length() - 1);
          }
          com.tencent.mm.plugin.report.service.h.vKh.f(11599, new Object[] { Integer.valueOf(locala.gKT), Integer.valueOf(locala.xMF.size()), Integer.valueOf(locala.xMJ), Integer.valueOf(locala.networkType), Integer.valueOf(0), locala.id, Long.valueOf(locala.xMK), Integer.valueOf(locala.rrY), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(locala.xML), Integer.valueOf(locala.xMM), Integer.valueOf(0), localObject1, localObject2, localObject3, Integer.valueOf(0), "", Integer.valueOf(locala.xMN) });
        }
        c.biV().clear();
        AppMethodBeat.o(99817);
      }
    });
    AppMethodBeat.o(99827);
  }
  
  public static void f(p paramp, final int paramInt)
  {
    AppMethodBeat.i(99825);
    af.dhI().post(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(99815);
        if (this.xlw != null)
        {
          long l = this.xlw.field_snsId;
          if (c.biV().containsKey(Long.valueOf(l)))
          {
            c.a locala = (c.a)c.biV().get(Long.valueOf(l));
            if (locala.xMJ == 0) {
              locala.xMJ = (paramInt + 1);
            }
            if (locala.xMF == null) {
              locala.xMF = new HashSet();
            }
            locala.xMF.add(Integer.valueOf(paramInt + 1));
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
    af.dhI().post(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(99816);
        if (this.xlw != null)
        {
          long l = this.xlw.field_snsId;
          if (c.biV().containsKey(Long.valueOf(l)))
          {
            c.a locala = (c.a)c.biV().get(Long.valueOf(l));
            if (locala.xMG == null) {
              locala.xMG = new HashSet();
            }
            if (!locala.xMG.contains(Integer.valueOf(paramInt + 1))) {
              locala.xMG.add(Integer.valueOf(paramInt + 1));
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
    AppMethodBeat.i(99828);
    if ((paramTimeLineObject.Etm == null) || (TextUtils.isEmpty(paramTimeLineObject.Etm.Url)))
    {
      AppMethodBeat.o(99828);
      return;
    }
    d locald = (d)g.ab(d.class);
    String str2 = paramTimeLineObject.Etm.Url;
    int i = mSu;
    if (paramTimeLineObject.Etl != null) {}
    for (String str1 = paramTimeLineObject.Etl.Id;; str1 = "")
    {
      locald.a(str2, i, str1, paramTimeLineObject.Etm.Title, paramTimeLineObject.Etm.Desc, "timeline", 1);
      AppMethodBeat.o(99828);
      return;
    }
  }
  
  public static void i(TimeLineObject paramTimeLineObject)
  {
    AppMethodBeat.i(99829);
    if ((TextUtils.isEmpty(paramTimeLineObject.Etm.Url)) || (!paramTimeLineObject.Etm.Url.contains("mp.weixin.qq.com")))
    {
      AppMethodBeat.o(99829);
      return;
    }
    if (paramTimeLineObject.Etm.DaF != null) {}
    for (int i = paramTimeLineObject.Etm.DaF.gKq;; i = -1)
    {
      ((com.tencent.mm.plugin.brandservice.a.b)g.ab(com.tencent.mm.plugin.brandservice.a.b.class)).a(paramTimeLineObject.Etm.Url, i, mSu, new Object[] { paramTimeLineObject.Id, null, null, paramTimeLineObject.mAQ, Integer.valueOf(paramTimeLineObject.CreateTime), Long.valueOf(((com.tencent.mm.plugin.brandservice.a.b)g.ab(com.tencent.mm.plugin.brandservice.a.b.class)).OZ("__sns_timeline__")) });
      if ((!xMB) && (i != -1) && (((com.tencent.mm.plugin.brandservice.a.b)g.ab(com.tencent.mm.plugin.brandservice.a.b.class)).xA(24)))
      {
        xMB = true;
        ((com.tencent.mm.plugin.brandservice.a.b)g.ab(com.tencent.mm.plugin.brandservice.a.b.class)).xB(mSu);
      }
      if ((i == 5) && (((com.tencent.mm.plugin.brandservice.a.b)g.ab(com.tencent.mm.plugin.brandservice.a.b.class)).bBR()) && (paramTimeLineObject.Etm.DaF != null) && (!bt.isNullOrNil(paramTimeLineObject.Etm.DaF.coverUrl)))
      {
        paramTimeLineObject = com.tencent.mm.api.b.q(paramTimeLineObject.Etm.DaF.coverUrl, 4);
        Object localObject = r.aAK(paramTimeLineObject);
        if (!com.tencent.mm.vfs.i.eK((String)localObject))
        {
          com.tencent.mm.aw.a.a.c.a locala = new com.tencent.mm.aw.a.a.c.a();
          locala.hjU = true;
          locala.gjt = ((String)localObject);
          localObject = locala.azc();
          o.ayJ().a(paramTimeLineObject, (com.tencent.mm.aw.a.a.c)localObject, null);
        }
      }
      AppMethodBeat.o(99829);
      return;
    }
  }
  
  public final p Ni(int paramInt)
  {
    AppMethodBeat.i(99823);
    Object localObject = (bf)this.xMy.get(paramInt);
    if (localObject == null)
    {
      AppMethodBeat.o(99823);
      return null;
    }
    localObject = ((bf)localObject).wvM;
    AppMethodBeat.o(99823);
    return localObject;
  }
  
  public final long dDc()
  {
    AppMethodBeat.i(187778);
    int i = 0;
    int j = getCount() - 1;
    p localp = Ni(j);
    if ((localp != null) && (!localp.Nb(32)) && (localp.field_snsId != 0L)) {}
    for (long l = localp.field_snsId;; l = 0L)
    {
      AppMethodBeat.o(187778);
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
  
  public final void dzc()
  {
    AppMethodBeat.i(201289);
    this.xMy.notifyVendingDataChange();
    AppMethodBeat.o(201289);
  }
  
  public final int getCount()
  {
    return this.xMy.mCount;
  }
  
  public final long getItemId(int paramInt)
  {
    return 0L;
  }
  
  public final int getItemViewType(int paramInt)
  {
    AppMethodBeat.i(99821);
    paramInt = this.xMx.getItemViewType(paramInt);
    AppMethodBeat.o(99821);
    return paramInt;
  }
  
  public final View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    AppMethodBeat.i(99820);
    paramView = this.xMx.l(paramInt, paramView);
    AppMethodBeat.o(99820);
    return paramView;
  }
  
  public final int getViewTypeCount()
  {
    return 17;
  }
  
  public final void hu(int paramInt1, int paramInt2)
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
      localObject = Ni(paramInt1 - 1);
      TimeLineObject localTimeLineObject;
      d.a locala;
      if (localObject != null)
      {
        localTimeLineObject = ((p)localObject).dxy();
        if ((localTimeLineObject != null) && (localTimeLineObject.Etm != null) && (!TextUtils.isEmpty(localTimeLineObject.Etm.Url)))
        {
          locala = new d.a();
          locala.url = localTimeLineObject.Etm.Url;
          locala.mSu = mSu;
          if (localTimeLineObject.Etl == null) {
            break label178;
          }
        }
      }
      label178:
      for (localObject = localTimeLineObject.Etl.Id;; localObject = "")
      {
        locala.appId = ((String)localObject);
        locala.title = localTimeLineObject.Etm.Title;
        locala.desc = localTimeLineObject.Etm.Desc;
        locala.dvh = "timeline";
        localLinkedList.add(locala);
        paramInt1 += 1;
        break;
      }
    }
    Object localObject = (d)g.ab(d.class);
    if ((localObject != null) && (localLinkedList.size() > 0))
    {
      ad.v("MicroMsg.SnsTimeLineVendingAdapter", "[TRACE_PREFETCH] checkPreAuths authInfo size = %s", new Object[] { Integer.valueOf(localLinkedList.size()) });
      ((d)localObject).l(localLinkedList, 1);
    }
    AppMethodBeat.o(160747);
  }
  
  public final long qv(boolean paramBoolean)
  {
    AppMethodBeat.i(179321);
    int i = 0;
    int j = 0;
    for (;;)
    {
      p localp = Ni(i);
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
        if ((localp != null) && (!localp.Nb(32)) && (localp.field_snsId != 0L))
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
  
  public final void tP()
  {
    AppMethodBeat.i(99819);
    if (this.gcu)
    {
      AppMethodBeat.o(99819);
      return;
    }
    this.gcu = true;
    this.xMy.notifyVendingDataChangeSynchronize();
    AppMethodBeat.o(99819);
  }
  
  static final class a
  {
    int gKT;
    String id;
    int networkType;
    int rrY;
    HashSet<Integer> xMF;
    HashSet<Integer> xMG;
    HashSet<Integer> xMH;
    HashSet<Integer> xMI;
    int xMJ;
    long xMK;
    int xML;
    int xMM;
    int xMN;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.a.c
 * JD-Core Version:    0.7.0.1
 */