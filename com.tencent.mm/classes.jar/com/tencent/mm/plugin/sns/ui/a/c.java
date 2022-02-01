package com.tencent.mm.plugin.sns.ui.a;

import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ListView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.bq;
import com.tencent.mm.plugin.brandservice.a.d;
import com.tencent.mm.plugin.brandservice.a.d.a;
import com.tencent.mm.plugin.messenger.foundation.a.l;
import com.tencent.mm.plugin.sns.model.ag;
import com.tencent.mm.plugin.sns.model.ak;
import com.tencent.mm.plugin.sns.storage.p;
import com.tencent.mm.plugin.sns.ui.bh;
import com.tencent.mm.plugin.sns.ui.bi;
import com.tencent.mm.plugin.sns.ui.z;
import com.tencent.mm.pluginsdk.model.r;
import com.tencent.mm.protocal.protobuf.SnsObject;
import com.tencent.mm.protocal.protobuf.TimeLineObject;
import com.tencent.mm.protocal.protobuf.abf;
import com.tencent.mm.protocal.protobuf.bww;
import com.tencent.mm.protocal.protobuf.en;
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
  implements z
{
  private static HashMap<Long, a> Arf;
  private static boolean Arg;
  private static int nWh;
  private Vending.d AkR;
  public bh Arc;
  public com.tencent.mm.plugin.sns.ui.a.b.b Ard;
  public boolean Are;
  private boolean gAK;
  
  static
  {
    AppMethodBeat.i(99831);
    Arf = new HashMap();
    Arg = false;
    nWh = 2;
    AppMethodBeat.o(99831);
  }
  
  public c(MMActivity paramMMActivity, ListView paramListView, com.tencent.mm.plugin.sns.ui.d.c paramc, com.tencent.mm.plugin.sns.ui.i parami, String paramString, com.tencent.mm.plugin.sns.ui.a.b.b paramb, Vending.d paramd)
  {
    AppMethodBeat.i(179319);
    this.gAK = false;
    this.AkR = new Vending.d()
    {
      public final void ede()
      {
        AppMethodBeat.i(99813);
        if (!c.a(c.this))
        {
          c.this.notifyDataSetChanged();
          bq localbq = new bq();
          com.tencent.mm.sdk.b.a.IbL.l(localbq);
        }
        AppMethodBeat.o(99813);
      }
    };
    this.Arc = new bh(paramMMActivity, paramListView, paramc, parami, this);
    this.Arc.Aae = true;
    paramListView = paramb;
    if (paramb == null) {
      paramListView = new com.tencent.mm.plugin.sns.ui.a.b.c();
    }
    this.Ard = paramListView;
    this.Ard.a(paramMMActivity, this.Arc, paramString);
    paramMMActivity = this.Ard;
    com.tencent.mm.vending.f.a.i("Vending.ForwardVending", "Vending.setRangeSize(%s)", new Object[] { Integer.valueOf(10) });
    paramMMActivity.Lhl = 10;
    this.Ard.addVendingDataChangedCallback(paramd);
    AppMethodBeat.o(179319);
  }
  
  public static void S(p paramp)
  {
    AppMethodBeat.i(99824);
    ag.dFL().post(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(99814);
        long l1;
        c.a locala;
        if (this.zPy != null)
        {
          l1 = this.zPy.field_snsId;
          if (!c.Arf.containsKey(Long.valueOf(l1)))
          {
            locala = new c.a();
            if ((this.zPy.dYl() != null) && (this.zPy.dYl().HAT != null) && (this.zPy.dYl().HAT.GaP == 1) && (this.zPy.dYl().HAT.GaQ != null) && (this.zPy.dYl().HAT.GaQ.size() > 0))
            {
              locala.hDC = this.zPy.dYl().HAT.GaQ.size();
              locala.Ark = new HashSet();
              locala.Arl = new HashSet();
              locala.Arm = new HashSet();
              locala.Arn = new HashSet();
              locala.id = this.zPy.dYl().Id;
              locala.Ars = this.zPy.dYl().ePo;
            }
          }
        }
        try
        {
          SnsObject localSnsObject = ak.v(this.zPy);
          locala.Arq = localSnsObject.LikeCount;
          locala.Arr = localSnsObject.CommentCount;
        }
        catch (Exception localException1)
        {
          try
          {
            for (;;)
            {
              com.tencent.mm.kernel.g.ajD();
              locala.txt = ((l)com.tencent.mm.kernel.g.ab(l.class)).dlK().aqm(this.zPy.field_userName);
              long l2 = System.currentTimeMillis();
              com.tencent.mm.kernel.g.ajD();
              locala.Arp = ((l2 - ((l)com.tencent.mm.kernel.g.ab(l.class)).dlK().aqq(this.zPy.field_userName)) / 1000L);
              c.Arf.put(Long.valueOf(l1), locala);
              AppMethodBeat.o(99814);
              return;
              localException1 = localException1;
              locala.Arq = 0;
              locala.Arr = 0;
            }
          }
          catch (Exception localException2)
          {
            for (;;)
            {
              locala.txt = 0;
              locala.Arp = 0L;
            }
          }
        }
      }
    });
    AppMethodBeat.o(99824);
  }
  
  public static void edS()
  {
    AppMethodBeat.i(99827);
    ag.dFL().post(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(99817);
        Iterator localIterator = c.Arf.entrySet().iterator();
        while (localIterator.hasNext())
        {
          c.a locala = (c.a)((Map.Entry)localIterator.next()).getValue();
          locala.networkType = com.tencent.mm.plugin.sns.data.q.dSO();
          ad.d("MicroMsg.SnsTimeLineVendingAdapter", "report big pic click, picNum:%d, clickPicNum:%d, firstClickPos:%d, networkType:%d, id:%s", new Object[] { Integer.valueOf(locala.hDC), Integer.valueOf(locala.Ark.size()), Integer.valueOf(locala.Aro), Integer.valueOf(locala.networkType), locala.id });
          Object localObject1 = locala.Arl.iterator();
          for (String str = ""; ((Iterator)localObject1).hasNext(); str = str + localObject2 + "|") {
            localObject2 = (Integer)((Iterator)localObject1).next();
          }
          localObject1 = str;
          if (str.length() >= 2) {
            localObject1 = str.substring(0, str.length() - 1);
          }
          Object localObject2 = locala.Arm.iterator();
          for (str = ""; ((Iterator)localObject2).hasNext(); str = str + localObject3 + "|") {
            localObject3 = (Integer)((Iterator)localObject2).next();
          }
          localObject2 = str;
          if (str.length() >= 2) {
            localObject2 = str.substring(0, str.length() - 1);
          }
          Object localObject3 = locala.Arn.iterator();
          Integer localInteger;
          for (str = ""; ((Iterator)localObject3).hasNext(); str = str + localInteger + "|") {
            localInteger = (Integer)((Iterator)localObject3).next();
          }
          localObject3 = str;
          if (str.length() >= 2) {
            localObject3 = str.substring(0, str.length() - 1);
          }
          com.tencent.mm.plugin.report.service.g.yhR.f(11599, new Object[] { Integer.valueOf(locala.hDC), Integer.valueOf(locala.Ark.size()), Integer.valueOf(locala.Aro), Integer.valueOf(locala.networkType), Integer.valueOf(0), locala.id, Long.valueOf(locala.Arp), Integer.valueOf(locala.txt), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(locala.Arq), Integer.valueOf(locala.Arr), Integer.valueOf(0), localObject1, localObject2, localObject3, Integer.valueOf(0), "", Integer.valueOf(locala.Ars) });
        }
        c.Arf.clear();
        AppMethodBeat.o(99817);
      }
    });
    AppMethodBeat.o(99827);
  }
  
  public static void g(p paramp, final int paramInt)
  {
    AppMethodBeat.i(99825);
    ag.dFL().post(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(99815);
        if (this.zPy != null)
        {
          long l = this.zPy.field_snsId;
          if (c.Arf.containsKey(Long.valueOf(l)))
          {
            c.a locala = (c.a)c.Arf.get(Long.valueOf(l));
            if (locala.Aro == 0) {
              locala.Aro = (paramInt + 1);
            }
            if (locala.Ark == null) {
              locala.Ark = new HashSet();
            }
            locala.Ark.add(Integer.valueOf(paramInt + 1));
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
    if ((paramTimeLineObject.HAT == null) || (TextUtils.isEmpty(paramTimeLineObject.HAT.Url)))
    {
      AppMethodBeat.o(99828);
      return;
    }
    d locald = (d)com.tencent.mm.kernel.g.ab(d.class);
    String str2 = paramTimeLineObject.HAT.Url;
    int i = nWh;
    if (paramTimeLineObject.HAS != null) {}
    for (String str1 = paramTimeLineObject.HAS.Id;; str1 = "")
    {
      locald.a(str2, i, str1, paramTimeLineObject.HAT.Title, paramTimeLineObject.HAT.Desc, "timeline", 1);
      AppMethodBeat.o(99828);
      return;
    }
  }
  
  public static void h(p paramp, final int paramInt)
  {
    AppMethodBeat.i(99826);
    ag.dFL().post(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(99816);
        if (this.zPy != null)
        {
          long l = this.zPy.field_snsId;
          if (c.Arf.containsKey(Long.valueOf(l)))
          {
            c.a locala = (c.a)c.Arf.get(Long.valueOf(l));
            if (locala.Arl == null) {
              locala.Arl = new HashSet();
            }
            if (!locala.Arl.contains(Integer.valueOf(paramInt + 1))) {
              locala.Arl.add(Integer.valueOf(paramInt + 1));
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
    if ((TextUtils.isEmpty(paramTimeLineObject.HAT.Url)) || (!paramTimeLineObject.HAT.Url.contains("mp.weixin.qq.com")))
    {
      AppMethodBeat.o(99829);
      return;
    }
    if (paramTimeLineObject.HAT.GaT != null) {}
    for (int i = paramTimeLineObject.HAT.GaT.hCZ;; i = -1)
    {
      ((com.tencent.mm.plugin.brandservice.a.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.brandservice.a.b.class)).a(paramTimeLineObject.HAT.Url, i, nWh, new Object[] { paramTimeLineObject.Id, null, null, paramTimeLineObject.nDo, Integer.valueOf(paramTimeLineObject.CreateTime), Long.valueOf(((com.tencent.mm.plugin.brandservice.a.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.brandservice.a.b.class)).WP("__sns_timeline__")) });
      if ((!Arg) && (i != -1) && (((com.tencent.mm.plugin.brandservice.a.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.brandservice.a.b.class)).zc(24)))
      {
        Arg = true;
        ((com.tencent.mm.plugin.brandservice.a.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.brandservice.a.b.class)).zd(nWh);
      }
      if ((i == 5) && (((com.tencent.mm.plugin.brandservice.a.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.brandservice.a.b.class)).bNg()) && (paramTimeLineObject.HAT.GaT != null) && (!bt.isNullOrNil(paramTimeLineObject.HAT.GaT.coverUrl)))
      {
        paramTimeLineObject = com.tencent.mm.api.b.s(paramTimeLineObject.HAT.GaT.coverUrl, 4);
        Object localObject = r.aLC(paramTimeLineObject);
        if (!com.tencent.mm.vfs.i.fv((String)localObject))
        {
          com.tencent.mm.aw.a.a.c.a locala = new com.tencent.mm.aw.a.a.c.a();
          locala.idr = true;
          locala.hdP = ((String)localObject);
          localObject = locala.aJc();
          com.tencent.mm.aw.q.aIJ().a(paramTimeLineObject, (com.tencent.mm.aw.a.a.c)localObject, null);
        }
      }
      AppMethodBeat.o(99829);
      return;
    }
  }
  
  public final p QT(int paramInt)
  {
    AppMethodBeat.i(99823);
    Object localObject = (bi)this.Ard.get(paramInt);
    if (localObject == null)
    {
      AppMethodBeat.o(99823);
      return null;
    }
    localObject = ((bi)localObject).yVM;
    AppMethodBeat.o(99823);
    return localObject;
  }
  
  public final void dZO()
  {
    AppMethodBeat.i(221353);
    this.Ard.notifyVendingDataChange();
    AppMethodBeat.o(221353);
  }
  
  public final long edT()
  {
    AppMethodBeat.i(198529);
    int i = 0;
    int j = getCount() - 1;
    p localp = QT(j);
    if ((localp != null) && (!localp.QM(32)) && (localp.field_snsId != 0L)) {}
    for (long l = localp.field_snsId;; l = 0L)
    {
      AppMethodBeat.o(198529);
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
    return this.Ard.mCount;
  }
  
  public final long getItemId(int paramInt)
  {
    return 0L;
  }
  
  public final int getItemViewType(int paramInt)
  {
    AppMethodBeat.i(99821);
    paramInt = this.Arc.getItemViewType(paramInt);
    AppMethodBeat.o(99821);
    return paramInt;
  }
  
  public final View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    AppMethodBeat.i(99820);
    paramView = this.Arc.m(paramInt, paramView);
    AppMethodBeat.o(99820);
    return paramView;
  }
  
  public final int getViewTypeCount()
  {
    return 20;
  }
  
  public final void hU(int paramInt1, int paramInt2)
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
      localObject = QT(paramInt1 - 1);
      TimeLineObject localTimeLineObject;
      d.a locala;
      if (localObject != null)
      {
        localTimeLineObject = ((p)localObject).dYl();
        if ((localTimeLineObject != null) && (localTimeLineObject.HAT != null) && (!TextUtils.isEmpty(localTimeLineObject.HAT.Url)))
        {
          locala = new d.a();
          locala.url = localTimeLineObject.HAT.Url;
          locala.nWh = nWh;
          if (localTimeLineObject.HAS == null) {
            break label178;
          }
        }
      }
      label178:
      for (localObject = localTimeLineObject.HAS.Id;; localObject = "")
      {
        locala.appId = ((String)localObject);
        locala.title = localTimeLineObject.HAT.Title;
        locala.desc = localTimeLineObject.HAT.Desc;
        locala.dET = "timeline";
        localLinkedList.add(locala);
        paramInt1 += 1;
        break;
      }
    }
    Object localObject = (d)com.tencent.mm.kernel.g.ab(d.class);
    if ((localObject != null) && (localLinkedList.size() > 0))
    {
      ad.v("MicroMsg.SnsTimeLineVendingAdapter", "[TRACE_PREFETCH] checkPreAuths authInfo size = %s", new Object[] { Integer.valueOf(localLinkedList.size()) });
      ((d)localObject).m(localLinkedList, 1);
    }
    AppMethodBeat.o(160747);
  }
  
  public final long rZ(boolean paramBoolean)
  {
    AppMethodBeat.i(179321);
    int i = 0;
    int j = 0;
    for (;;)
    {
      p localp = QT(i);
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
        if ((localp != null) && (!localp.QM(32)) && (localp.field_snsId != 0L))
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
    if (this.gAK)
    {
      AppMethodBeat.o(99819);
      return;
    }
    this.gAK = true;
    this.Ard.notifyVendingDataChangeSynchronize();
    AppMethodBeat.o(99819);
  }
  
  static final class a
  {
    HashSet<Integer> Ark;
    HashSet<Integer> Arl;
    HashSet<Integer> Arm;
    HashSet<Integer> Arn;
    int Aro;
    long Arp;
    int Arq;
    int Arr;
    int Ars;
    int hDC;
    String id;
    int networkType;
    int txt;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.a.c
 * JD-Core Version:    0.7.0.1
 */