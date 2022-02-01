package com.tencent.mm.plugin.sns.ui.a;

import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ListView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ay.q;
import com.tencent.mm.f.a.bx;
import com.tencent.mm.plugin.brandservice.a.f;
import com.tencent.mm.plugin.brandservice.a.f.a;
import com.tencent.mm.plugin.messenger.foundation.a.n;
import com.tencent.mm.plugin.sns.data.t;
import com.tencent.mm.plugin.sns.i.j;
import com.tencent.mm.plugin.sns.model.aj;
import com.tencent.mm.plugin.sns.model.an;
import com.tencent.mm.plugin.sns.storage.SnsInfo;
import com.tencent.mm.plugin.sns.ui.ac;
import com.tencent.mm.plugin.sns.ui.bm;
import com.tencent.mm.plugin.sns.ui.bn;
import com.tencent.mm.pluginsdk.model.w;
import com.tencent.mm.protocal.protobuf.SnsObject;
import com.tencent.mm.protocal.protobuf.TimeLineObject;
import com.tencent.mm.protocal.protobuf.adw;
import com.tencent.mm.protocal.protobuf.cuf;
import com.tencent.mm.protocal.protobuf.ex;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandler;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.platformtools.WeChatHosts;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.vending.base.Vending.d;
import com.tencent.mm.vfs.u;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Map.Entry;
import java.util.Set;

public final class c
  extends BaseAdapter
  implements ac
{
  private static HashMap<Long, a> Lgv;
  private static boolean Lgw;
  private static int svv;
  private Vending.d KZG;
  public bm Lgs;
  public com.tencent.mm.plugin.sns.ui.a.b.b Lgt;
  public boolean Lgu;
  private boolean mLoaded;
  
  static
  {
    AppMethodBeat.i(99831);
    Lgv = new HashMap();
    Lgw = false;
    svv = 2;
    AppMethodBeat.o(99831);
  }
  
  public c(MMActivity paramMMActivity, ListView paramListView, com.tencent.mm.plugin.sns.ui.d.c paramc, com.tencent.mm.plugin.sns.ui.i parami, String paramString, com.tencent.mm.plugin.sns.ui.a.b.b paramb, Vending.d paramd)
  {
    AppMethodBeat.i(179319);
    this.mLoaded = false;
    this.KZG = new Vending.d()
    {
      public final void fXA()
      {
        AppMethodBeat.i(99813);
        if (!c.a(c.this))
        {
          c.this.notifyDataSetChanged();
          bx localbx = new bx();
          EventCenter.instance.publish(localbx);
        }
        AppMethodBeat.o(99813);
      }
    };
    this.Lgs = new bm(paramMMActivity, paramListView, paramc, parami, this);
    this.Lgs.KOn = true;
    paramListView = paramb;
    if (paramb == null) {
      paramListView = new com.tencent.mm.plugin.sns.ui.a.b.c();
    }
    this.Lgt = paramListView;
    this.Lgt.a(paramMMActivity, this.Lgs, paramString);
    paramMMActivity = this.Lgt;
    com.tencent.mm.vending.f.a.i("Vending.ForwardVending", "Vending.setRangeSize(%s)", new Object[] { Integer.valueOf(10) });
    paramMMActivity.Yzy = 10;
    this.Lgt.addVendingDataChangedCallback(paramd);
    AppMethodBeat.o(179319);
  }
  
  public static void aa(SnsInfo paramSnsInfo)
  {
    AppMethodBeat.i(99824);
    aj.fwa().post(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(99814);
        long l1;
        c.a locala;
        if (this.JHl != null)
        {
          l1 = this.JHl.field_snsId;
          if (!c.Lgv.containsKey(Long.valueOf(l1)))
          {
            locala = new c.a();
            if ((this.JHl.getTimeLine() != null) && (this.JHl.getTimeLine().ContentObj != null) && (this.JHl.getTimeLine().ContentObj.Sqq == 1) && (this.JHl.getTimeLine().ContentObj.Sqr != null) && (this.JHl.getTimeLine().ContentObj.Sqr.size() > 0))
            {
              locala.lqa = this.JHl.getTimeLine().ContentObj.Sqr.size();
              locala.LgA = new HashSet();
              locala.LgB = new HashSet();
              locala.LgC = new HashSet();
              locala.LgD = new HashSet();
              locala.id = this.JHl.getTimeLine().Id;
              locala.LgI = this.JHl.getTimeLine().showFlag;
            }
          }
        }
        try
        {
          SnsObject localSnsObject = an.D(this.JHl);
          locala.LgG = localSnsObject.LikeCount;
          locala.LgH = localSnsObject.CommentCount;
        }
        catch (Exception localException1)
        {
          try
          {
            for (;;)
            {
              com.tencent.mm.kernel.h.aHH();
              locala.BLi = ((n)com.tencent.mm.kernel.h.ae(n.class)).eSe().aOW(this.JHl.getUserName());
              long l2 = System.currentTimeMillis();
              com.tencent.mm.kernel.h.aHH();
              locala.LgF = ((l2 - ((n)com.tencent.mm.kernel.h.ae(n.class)).eSe().aPa(this.JHl.getUserName())) / 1000L);
              c.Lgv.put(Long.valueOf(l1), locala);
              AppMethodBeat.o(99814);
              return;
              localException1 = localException1;
              locala.LgG = 0;
              locala.LgH = 0;
            }
          }
          catch (Exception localException2)
          {
            for (;;)
            {
              locala.BLi = 0;
              locala.LgF = 0L;
            }
          }
        }
      }
    });
    AppMethodBeat.o(99824);
  }
  
  public static void f(TimeLineObject paramTimeLineObject)
  {
    AppMethodBeat.i(99828);
    if ((paramTimeLineObject.ContentObj == null) || (TextUtils.isEmpty(paramTimeLineObject.ContentObj.Url)))
    {
      AppMethodBeat.o(99828);
      return;
    }
    f localf = (f)com.tencent.mm.kernel.h.ae(f.class);
    String str2 = paramTimeLineObject.ContentObj.Url;
    int i = svv;
    if (paramTimeLineObject.AppInfo != null) {}
    for (String str1 = paramTimeLineObject.AppInfo.Id;; str1 = "")
    {
      localf.a(str2, i, str1, paramTimeLineObject.ContentObj.fwr, paramTimeLineObject.ContentObj.CMB, "timeline", 1);
      AppMethodBeat.o(99828);
      return;
    }
  }
  
  public static void fYk()
  {
    AppMethodBeat.i(99827);
    aj.fwa().post(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(99817);
        Iterator localIterator = c.Lgv.entrySet().iterator();
        while (localIterator.hasNext())
        {
          c.a locala = (c.a)((Map.Entry)localIterator.next()).getValue();
          locala.networkType = t.fNo();
          Log.d("MicroMsg.SnsTimeLineVendingAdapter", "report big pic click, picNum:%d, clickPicNum:%d, firstClickPos:%d, networkType:%d, id:%s", new Object[] { Integer.valueOf(locala.lqa), Integer.valueOf(locala.LgA.size()), Integer.valueOf(locala.LgE), Integer.valueOf(locala.networkType), locala.id });
          Object localObject1 = locala.LgB.iterator();
          for (String str = ""; ((Iterator)localObject1).hasNext(); str = str + localObject2 + "|") {
            localObject2 = (Integer)((Iterator)localObject1).next();
          }
          localObject1 = str;
          if (str.length() >= 2) {
            localObject1 = str.substring(0, str.length() - 1);
          }
          Object localObject2 = locala.LgC.iterator();
          for (str = ""; ((Iterator)localObject2).hasNext(); str = str + localObject3 + "|") {
            localObject3 = (Integer)((Iterator)localObject2).next();
          }
          localObject2 = str;
          if (str.length() >= 2) {
            localObject2 = str.substring(0, str.length() - 1);
          }
          Object localObject3 = locala.LgD.iterator();
          Integer localInteger;
          for (str = ""; ((Iterator)localObject3).hasNext(); str = str + localInteger + "|") {
            localInteger = (Integer)((Iterator)localObject3).next();
          }
          localObject3 = str;
          if (str.length() >= 2) {
            localObject3 = str.substring(0, str.length() - 1);
          }
          com.tencent.mm.plugin.report.service.h.IzE.a(11599, new Object[] { Integer.valueOf(locala.lqa), Integer.valueOf(locala.LgA.size()), Integer.valueOf(locala.LgE), Integer.valueOf(locala.networkType), Integer.valueOf(0), locala.id, Long.valueOf(locala.LgF), Integer.valueOf(locala.BLi), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(locala.LgG), Integer.valueOf(locala.LgH), Integer.valueOf(0), localObject1, localObject2, localObject3, Integer.valueOf(0), "", Integer.valueOf(locala.LgI) });
        }
        c.Lgv.clear();
        AppMethodBeat.o(99817);
      }
    });
    AppMethodBeat.o(99827);
  }
  
  public static void g(TimeLineObject paramTimeLineObject)
  {
    AppMethodBeat.i(99829);
    if ((TextUtils.isEmpty(paramTimeLineObject.ContentObj.Url)) || (!paramTimeLineObject.ContentObj.Url.contains(WeChatHosts.domainString(i.j.host_mp_weixin_qq_com))))
    {
      AppMethodBeat.o(99829);
      return;
    }
    if (paramTimeLineObject.ContentObj.Squ != null) {}
    for (int i = paramTimeLineObject.ContentObj.Squ.lpx;; i = -1)
    {
      ((com.tencent.mm.plugin.brandservice.a.c)com.tencent.mm.kernel.h.ae(com.tencent.mm.plugin.brandservice.a.c.class)).a(paramTimeLineObject.ContentObj.Url, i, svv, new Object[] { paramTimeLineObject.Id, null, null, paramTimeLineObject.UserName, Integer.valueOf(paramTimeLineObject.CreateTime), Long.valueOf(((com.tencent.mm.plugin.brandservice.a.c)com.tencent.mm.kernel.h.ae(com.tencent.mm.plugin.brandservice.a.c.class)).ape("__sns_timeline__")) });
      if ((!Lgw) && (i != -1) && (((com.tencent.mm.plugin.brandservice.a.c)com.tencent.mm.kernel.h.ae(com.tencent.mm.plugin.brandservice.a.c.class)).Gw(24)))
      {
        Lgw = true;
        ((com.tencent.mm.plugin.brandservice.a.c)com.tencent.mm.kernel.h.ae(com.tencent.mm.plugin.brandservice.a.c.class)).Gx(svv);
      }
      if ((i == 5) && (paramTimeLineObject.ContentObj.Squ != null) && (!Util.isNullOrNil(paramTimeLineObject.ContentObj.Squ.coverUrl)))
      {
        paramTimeLineObject = com.tencent.mm.api.b.M(paramTimeLineObject.ContentObj.Squ.coverUrl, 4);
        Object localObject = w.bpO(paramTimeLineObject);
        if (!u.agG((String)localObject))
        {
          com.tencent.mm.ay.a.a.c.a locala = new com.tencent.mm.ay.a.a.c.a();
          locala.lRD = true;
          locala.fullPath = ((String)localObject);
          localObject = locala.bmL();
          q.bml().a(paramTimeLineObject, (com.tencent.mm.ay.a.a.c)localObject, null);
        }
      }
      AppMethodBeat.o(99829);
      return;
    }
  }
  
  public static void h(SnsInfo paramSnsInfo, final int paramInt)
  {
    AppMethodBeat.i(99825);
    aj.fwa().post(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(99815);
        if (this.JHl != null)
        {
          long l = this.JHl.field_snsId;
          if (c.Lgv.containsKey(Long.valueOf(l)))
          {
            c.a locala = (c.a)c.Lgv.get(Long.valueOf(l));
            if (locala.LgE == 0) {
              locala.LgE = (paramInt + 1);
            }
            if (locala.LgA == null) {
              locala.LgA = new HashSet();
            }
            locala.LgA.add(Integer.valueOf(paramInt + 1));
          }
        }
        AppMethodBeat.o(99815);
      }
    });
    AppMethodBeat.o(99825);
  }
  
  public static void i(SnsInfo paramSnsInfo, final int paramInt)
  {
    AppMethodBeat.i(99826);
    aj.fwa().post(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(99816);
        if (this.JHl != null)
        {
          long l = this.JHl.field_snsId;
          if (c.Lgv.containsKey(Long.valueOf(l)))
          {
            c.a locala = (c.a)c.Lgv.get(Long.valueOf(l));
            if (locala.LgB == null) {
              locala.LgB = new HashSet();
            }
            if (!locala.LgB.contains(Integer.valueOf(paramInt + 1))) {
              locala.LgB.add(Integer.valueOf(paramInt + 1));
            }
          }
        }
        AppMethodBeat.o(99816);
      }
    });
    AppMethodBeat.o(99826);
  }
  
  public final SnsInfo agM(int paramInt)
  {
    AppMethodBeat.i(99823);
    Object localObject = (bn)this.Lgt.get(paramInt);
    if (localObject == null)
    {
      AppMethodBeat.o(99823);
      return null;
    }
    localObject = ((bn)localObject).Jws;
    AppMethodBeat.o(99823);
    return localObject;
  }
  
  public final bn agN(int paramInt)
  {
    AppMethodBeat.i(195235);
    bn localbn = (bn)this.Lgt.get(paramInt);
    AppMethodBeat.o(195235);
    return localbn;
  }
  
  public final void fTJ()
  {
    AppMethodBeat.i(292720);
    this.Lgt.notifyVendingDataChange();
    AppMethodBeat.o(292720);
  }
  
  public final long fYl()
  {
    AppMethodBeat.i(195248);
    int i = 0;
    int j = getCount() - 1;
    SnsInfo localSnsInfo = agM(j);
    if ((localSnsInfo != null) && (!localSnsInfo.isSourceExist(32)) && (localSnsInfo.field_snsId != 0L)) {}
    for (long l = localSnsInfo.field_snsId;; l = 0L)
    {
      AppMethodBeat.o(195248);
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
    return this.Lgt.mCount;
  }
  
  public final long getItemId(int paramInt)
  {
    return 0L;
  }
  
  public final int getItemViewType(int paramInt)
  {
    AppMethodBeat.i(99821);
    paramInt = this.Lgs.getItemViewType(paramInt);
    AppMethodBeat.o(99821);
    return paramInt;
  }
  
  public final View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    AppMethodBeat.i(99820);
    paramView = this.Lgs.r(paramInt, paramView);
    AppMethodBeat.o(99820);
    return paramView;
  }
  
  public final int getViewTypeCount()
  {
    return 32;
  }
  
  public final void kb(int paramInt1, int paramInt2)
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
      localObject = agM(paramInt1 - 1);
      TimeLineObject localTimeLineObject;
      f.a locala;
      if (localObject != null)
      {
        localTimeLineObject = ((SnsInfo)localObject).getTimeLine();
        if ((localTimeLineObject != null) && (localTimeLineObject.ContentObj != null) && (!TextUtils.isEmpty(localTimeLineObject.ContentObj.Url)))
        {
          locala = new f.a();
          locala.url = localTimeLineObject.ContentObj.Url;
          locala.svv = svv;
          if (localTimeLineObject.AppInfo == null) {
            break label178;
          }
        }
      }
      label178:
      for (localObject = localTimeLineObject.AppInfo.Id;; localObject = "")
      {
        locala.appId = ((String)localObject);
        locala.title = localTimeLineObject.ContentObj.fwr;
        locala.desc = localTimeLineObject.ContentObj.CMB;
        locala.from = "timeline";
        localLinkedList.add(locala);
        paramInt1 += 1;
        break;
      }
    }
    Object localObject = (f)com.tencent.mm.kernel.h.ae(f.class);
    if ((localObject != null) && (localLinkedList.size() > 0))
    {
      Log.v("MicroMsg.SnsTimeLineVendingAdapter", "[TRACE_PREFETCH] checkPreAuths authInfo size = %s", new Object[] { Integer.valueOf(localLinkedList.size()) });
      ((f)localObject).m(localLinkedList, 1);
    }
    AppMethodBeat.o(160747);
  }
  
  public final void tA()
  {
    AppMethodBeat.i(99819);
    if (this.mLoaded)
    {
      AppMethodBeat.o(99819);
      return;
    }
    this.mLoaded = true;
    this.Lgt.notifyVendingDataChangeSynchronize();
    AppMethodBeat.o(99819);
  }
  
  public final long zg(boolean paramBoolean)
  {
    AppMethodBeat.i(179321);
    int i = 0;
    int j = 0;
    for (;;)
    {
      SnsInfo localSnsInfo = agM(i);
      long l;
      if (paramBoolean)
      {
        if ((localSnsInfo == null) || (localSnsInfo.field_snsId == 0L)) {
          break label87;
        }
        l = localSnsInfo.field_snsId;
      }
      for (;;)
      {
        AppMethodBeat.o(179321);
        return l;
        if ((localSnsInfo != null) && (!localSnsInfo.isSourceExist(32)) && (localSnsInfo.field_snsId != 0L))
        {
          l = localSnsInfo.field_snsId;
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
  
  static final class a
  {
    int BLi;
    HashSet<Integer> LgA;
    HashSet<Integer> LgB;
    HashSet<Integer> LgC;
    HashSet<Integer> LgD;
    int LgE;
    long LgF;
    int LgG;
    int LgH;
    int LgI;
    String id;
    int lqa;
    int networkType;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.a.c
 * JD-Core Version:    0.7.0.1
 */