package com.tencent.mm.plugin.sns.ui.a;

import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ListView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.av.q;
import com.tencent.mm.g.a.bs;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.brandservice.a.e;
import com.tencent.mm.plugin.brandservice.a.e.a;
import com.tencent.mm.plugin.messenger.foundation.a.l;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.plugin.sns.data.r;
import com.tencent.mm.plugin.sns.model.aj;
import com.tencent.mm.plugin.sns.model.an;
import com.tencent.mm.plugin.sns.storage.SnsInfo;
import com.tencent.mm.plugin.sns.ui.aa;
import com.tencent.mm.plugin.sns.ui.bk;
import com.tencent.mm.plugin.sns.ui.bl;
import com.tencent.mm.protocal.protobuf.SnsObject;
import com.tencent.mm.protocal.protobuf.TimeLineObject;
import com.tencent.mm.protocal.protobuf.adp;
import com.tencent.mm.protocal.protobuf.cli;
import com.tencent.mm.protocal.protobuf.fa;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandler;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.platformtools.WeChatHosts;
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
  implements aa
{
  private static HashMap<Long, a> ESs;
  private static boolean ESt;
  private static int pmM;
  private Vending.d ELF;
  public bk ESp;
  public com.tencent.mm.plugin.sns.ui.a.b.b ESq;
  public boolean ESr;
  private boolean mLoaded;
  
  static
  {
    AppMethodBeat.i(99831);
    ESs = new HashMap();
    ESt = false;
    pmM = 2;
    AppMethodBeat.o(99831);
  }
  
  public c(MMActivity paramMMActivity, ListView paramListView, com.tencent.mm.plugin.sns.ui.d.c paramc, com.tencent.mm.plugin.sns.ui.i parami, String paramString, com.tencent.mm.plugin.sns.ui.a.b.b paramb, Vending.d paramd)
  {
    AppMethodBeat.i(179319);
    this.mLoaded = false;
    this.ELF = new Vending.d()
    {
      public final void fjn()
      {
        AppMethodBeat.i(99813);
        if (!c.a(c.this))
        {
          c.this.notifyDataSetChanged();
          bs localbs = new bs();
          EventCenter.instance.publish(localbs);
        }
        AppMethodBeat.o(99813);
      }
    };
    this.ESp = new bk(paramMMActivity, paramListView, paramc, parami, this);
    this.ESp.EAv = true;
    paramListView = paramb;
    if (paramb == null) {
      paramListView = new com.tencent.mm.plugin.sns.ui.a.b.c();
    }
    this.ESq = paramListView;
    this.ESq.a(paramMMActivity, this.ESp, paramString);
    paramMMActivity = this.ESq;
    com.tencent.mm.vending.f.a.i("Vending.ForwardVending", "Vending.setRangeSize(%s)", new Object[] { Integer.valueOf(10) });
    paramMMActivity.QZi = 10;
    this.ESq.addVendingDataChangedCallback(paramd);
    AppMethodBeat.o(179319);
  }
  
  public static void Z(SnsInfo paramSnsInfo)
  {
    AppMethodBeat.i(99824);
    aj.eJP().post(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(99814);
        long l1;
        c.a locala;
        if (this.DxI != null)
        {
          l1 = this.DxI.field_snsId;
          if (!c.ESs.containsKey(Long.valueOf(l1)))
          {
            locala = new c.a();
            if ((this.DxI.getTimeLine() != null) && (this.DxI.getTimeLine().ContentObj != null) && (this.DxI.getTimeLine().ContentObj.LoU == 1) && (this.DxI.getTimeLine().ContentObj.LoV != null) && (this.DxI.getTimeLine().ContentObj.LoV.size() > 0))
            {
              locala.iAC = this.DxI.getTimeLine().ContentObj.LoV.size();
              locala.ESx = new HashSet();
              locala.ESy = new HashSet();
              locala.ESz = new HashSet();
              locala.ESA = new HashSet();
              locala.id = this.DxI.getTimeLine().Id;
              locala.ESF = this.DxI.getTimeLine().showFlag;
            }
          }
        }
        try
        {
          SnsObject localSnsObject = an.C(this.DxI);
          locala.ESD = localSnsObject.LikeCount;
          locala.ESE = localSnsObject.CommentCount;
        }
        catch (Exception localException1)
        {
          try
          {
            for (;;)
            {
              g.aAi();
              locala.wZj = ((l)g.af(l.class)).eiy().aEM(this.DxI.getUserName());
              long l2 = System.currentTimeMillis();
              g.aAi();
              locala.ESC = ((l2 - ((l)g.af(l.class)).eiy().aEQ(this.DxI.getUserName())) / 1000L);
              c.ESs.put(Long.valueOf(l1), locala);
              AppMethodBeat.o(99814);
              return;
              localException1 = localException1;
              locala.ESD = 0;
              locala.ESE = 0;
            }
          }
          catch (Exception localException2)
          {
            for (;;)
            {
              locala.wZj = 0;
              locala.ESC = 0L;
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
    e locale = (e)g.af(e.class);
    String str2 = paramTimeLineObject.ContentObj.Url;
    int i = pmM;
    if (paramTimeLineObject.AppInfo != null) {}
    for (String str1 = paramTimeLineObject.AppInfo.Id;; str1 = "")
    {
      locale.a(str2, i, str1, paramTimeLineObject.ContentObj.Title, paramTimeLineObject.ContentObj.Desc, "timeline", 1);
      AppMethodBeat.o(99828);
      return;
    }
  }
  
  public static void fkb()
  {
    AppMethodBeat.i(99827);
    aj.eJP().post(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(99817);
        Iterator localIterator = c.ESs.entrySet().iterator();
        while (localIterator.hasNext())
        {
          c.a locala = (c.a)((Map.Entry)localIterator.next()).getValue();
          locala.networkType = r.eZw();
          Log.d("MicroMsg.SnsTimeLineVendingAdapter", "report big pic click, picNum:%d, clickPicNum:%d, firstClickPos:%d, networkType:%d, id:%s", new Object[] { Integer.valueOf(locala.iAC), Integer.valueOf(locala.ESx.size()), Integer.valueOf(locala.ESB), Integer.valueOf(locala.networkType), locala.id });
          Object localObject1 = locala.ESy.iterator();
          for (String str = ""; ((Iterator)localObject1).hasNext(); str = str + localObject2 + "|") {
            localObject2 = (Integer)((Iterator)localObject1).next();
          }
          localObject1 = str;
          if (str.length() >= 2) {
            localObject1 = str.substring(0, str.length() - 1);
          }
          Object localObject2 = locala.ESz.iterator();
          for (str = ""; ((Iterator)localObject2).hasNext(); str = str + localObject3 + "|") {
            localObject3 = (Integer)((Iterator)localObject2).next();
          }
          localObject2 = str;
          if (str.length() >= 2) {
            localObject2 = str.substring(0, str.length() - 1);
          }
          Object localObject3 = locala.ESA.iterator();
          Integer localInteger;
          for (str = ""; ((Iterator)localObject3).hasNext(); str = str + localInteger + "|") {
            localInteger = (Integer)((Iterator)localObject3).next();
          }
          localObject3 = str;
          if (str.length() >= 2) {
            localObject3 = str.substring(0, str.length() - 1);
          }
          h.CyF.a(11599, new Object[] { Integer.valueOf(locala.iAC), Integer.valueOf(locala.ESx.size()), Integer.valueOf(locala.ESB), Integer.valueOf(locala.networkType), Integer.valueOf(0), locala.id, Long.valueOf(locala.ESC), Integer.valueOf(locala.wZj), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(locala.ESD), Integer.valueOf(locala.ESE), Integer.valueOf(0), localObject1, localObject2, localObject3, Integer.valueOf(0), "", Integer.valueOf(locala.ESF) });
        }
        c.ESs.clear();
        AppMethodBeat.o(99817);
      }
    });
    AppMethodBeat.o(99827);
  }
  
  public static void g(SnsInfo paramSnsInfo, final int paramInt)
  {
    AppMethodBeat.i(99825);
    aj.eJP().post(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(99815);
        if (this.DxI != null)
        {
          long l = this.DxI.field_snsId;
          if (c.ESs.containsKey(Long.valueOf(l)))
          {
            c.a locala = (c.a)c.ESs.get(Long.valueOf(l));
            if (locala.ESB == 0) {
              locala.ESB = (paramInt + 1);
            }
            if (locala.ESx == null) {
              locala.ESx = new HashSet();
            }
            locala.ESx.add(Integer.valueOf(paramInt + 1));
          }
        }
        AppMethodBeat.o(99815);
      }
    });
    AppMethodBeat.o(99825);
  }
  
  public static void g(TimeLineObject paramTimeLineObject)
  {
    AppMethodBeat.i(99829);
    if ((TextUtils.isEmpty(paramTimeLineObject.ContentObj.Url)) || (!paramTimeLineObject.ContentObj.Url.contains(WeChatHosts.domainString(2131761726))))
    {
      AppMethodBeat.o(99829);
      return;
    }
    if (paramTimeLineObject.ContentObj.LoY != null) {}
    for (int i = paramTimeLineObject.ContentObj.LoY.iAb;; i = -1)
    {
      ((com.tencent.mm.plugin.brandservice.a.b)g.af(com.tencent.mm.plugin.brandservice.a.b.class)).a(paramTimeLineObject.ContentObj.Url, i, pmM, new Object[] { paramTimeLineObject.Id, null, null, paramTimeLineObject.UserName, Integer.valueOf(paramTimeLineObject.CreateTime), Long.valueOf(((com.tencent.mm.plugin.brandservice.a.b)g.af(com.tencent.mm.plugin.brandservice.a.b.class)).ahy("__sns_timeline__")) });
      if ((!ESt) && (i != -1) && (((com.tencent.mm.plugin.brandservice.a.b)g.af(com.tencent.mm.plugin.brandservice.a.b.class)).CR(24)))
      {
        ESt = true;
        ((com.tencent.mm.plugin.brandservice.a.b)g.af(com.tencent.mm.plugin.brandservice.a.b.class)).CS(pmM);
      }
      if ((i == 5) && (((com.tencent.mm.plugin.brandservice.a.b)g.af(com.tencent.mm.plugin.brandservice.a.b.class)).cld()) && (paramTimeLineObject.ContentObj.LoY != null) && (!Util.isNullOrNil(paramTimeLineObject.ContentObj.LoY.coverUrl)))
      {
        paramTimeLineObject = com.tencent.mm.api.b.u(paramTimeLineObject.ContentObj.LoY.coverUrl, 4);
        Object localObject = com.tencent.mm.pluginsdk.model.s.bdu(paramTimeLineObject);
        if (!com.tencent.mm.vfs.s.YS((String)localObject))
        {
          com.tencent.mm.av.a.a.c.a locala = new com.tencent.mm.av.a.a.c.a();
          locala.jbf = true;
          locala.fullPath = ((String)localObject);
          localObject = locala.bdv();
          q.bcV().a(paramTimeLineObject, (com.tencent.mm.av.a.a.c)localObject, null);
        }
      }
      AppMethodBeat.o(99829);
      return;
    }
  }
  
  public static void h(SnsInfo paramSnsInfo, final int paramInt)
  {
    AppMethodBeat.i(99826);
    aj.eJP().post(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(99816);
        if (this.DxI != null)
        {
          long l = this.DxI.field_snsId;
          if (c.ESs.containsKey(Long.valueOf(l)))
          {
            c.a locala = (c.a)c.ESs.get(Long.valueOf(l));
            if (locala.ESy == null) {
              locala.ESy = new HashSet();
            }
            if (!locala.ESy.contains(Integer.valueOf(paramInt + 1))) {
              locala.ESy.add(Integer.valueOf(paramInt + 1));
            }
          }
        }
        AppMethodBeat.o(99816);
      }
    });
    AppMethodBeat.o(99826);
  }
  
  public final SnsInfo Zv(int paramInt)
  {
    AppMethodBeat.i(99823);
    Object localObject = (bl)this.ESq.get(paramInt);
    if (localObject == null)
    {
      AppMethodBeat.o(99823);
      return null;
    }
    localObject = ((bl)localObject).DqO;
    AppMethodBeat.o(99823);
    return localObject;
  }
  
  public final bl Zw(int paramInt)
  {
    AppMethodBeat.i(203862);
    bl localbl = (bl)this.ESq.get(paramInt);
    AppMethodBeat.o(203862);
    return localbl;
  }
  
  public final void ffM()
  {
    AppMethodBeat.i(258603);
    this.ESq.notifyVendingDataChange();
    AppMethodBeat.o(258603);
  }
  
  public final long fkc()
  {
    AppMethodBeat.i(203863);
    int i = 0;
    int j = getCount() - 1;
    SnsInfo localSnsInfo = Zv(j);
    if ((localSnsInfo != null) && (!localSnsInfo.isSourceExist(32)) && (localSnsInfo.field_snsId != 0L)) {}
    for (long l = localSnsInfo.field_snsId;; l = 0L)
    {
      AppMethodBeat.o(203863);
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
    return this.ESq.mCount;
  }
  
  public final long getItemId(int paramInt)
  {
    return 0L;
  }
  
  public final int getItemViewType(int paramInt)
  {
    AppMethodBeat.i(99821);
    paramInt = this.ESp.getItemViewType(paramInt);
    AppMethodBeat.o(99821);
    return paramInt;
  }
  
  public final View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    AppMethodBeat.i(99820);
    paramView = this.ESp.o(paramInt, paramView);
    AppMethodBeat.o(99820);
    return paramView;
  }
  
  public final int getViewTypeCount()
  {
    return 25;
  }
  
  public final void iS(int paramInt1, int paramInt2)
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
      localObject = Zv(paramInt1 - 1);
      TimeLineObject localTimeLineObject;
      e.a locala;
      if (localObject != null)
      {
        localTimeLineObject = ((SnsInfo)localObject).getTimeLine();
        if ((localTimeLineObject != null) && (localTimeLineObject.ContentObj != null) && (!TextUtils.isEmpty(localTimeLineObject.ContentObj.Url)))
        {
          locala = new e.a();
          locala.url = localTimeLineObject.ContentObj.Url;
          locala.pmM = pmM;
          if (localTimeLineObject.AppInfo == null) {
            break label178;
          }
        }
      }
      label178:
      for (localObject = localTimeLineObject.AppInfo.Id;; localObject = "")
      {
        locala.appId = ((String)localObject);
        locala.title = localTimeLineObject.ContentObj.Title;
        locala.desc = localTimeLineObject.ContentObj.Desc;
        locala.from = "timeline";
        localLinkedList.add(locala);
        paramInt1 += 1;
        break;
      }
    }
    Object localObject = (e)g.af(e.class);
    if ((localObject != null) && (localLinkedList.size() > 0))
    {
      Log.v("MicroMsg.SnsTimeLineVendingAdapter", "[TRACE_PREFETCH] checkPreAuths authInfo size = %s", new Object[] { Integer.valueOf(localLinkedList.size()) });
      ((e)localObject).m(localLinkedList, 1);
    }
    AppMethodBeat.o(160747);
  }
  
  public final long vC(boolean paramBoolean)
  {
    AppMethodBeat.i(179321);
    int i = 0;
    int j = 0;
    for (;;)
    {
      SnsInfo localSnsInfo = Zv(i);
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
  
  public final void vC()
  {
    AppMethodBeat.i(99819);
    if (this.mLoaded)
    {
      AppMethodBeat.o(99819);
      return;
    }
    this.mLoaded = true;
    this.ESq.notifyVendingDataChangeSynchronize();
    AppMethodBeat.o(99819);
  }
  
  static final class a
  {
    HashSet<Integer> ESA;
    int ESB;
    long ESC;
    int ESD;
    int ESE;
    int ESF;
    HashSet<Integer> ESx;
    HashSet<Integer> ESy;
    HashSet<Integer> ESz;
    int iAC;
    String id;
    int networkType;
    int wZj;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.a.c
 * JD-Core Version:    0.7.0.1
 */