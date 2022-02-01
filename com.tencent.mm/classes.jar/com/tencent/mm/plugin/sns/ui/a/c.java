package com.tencent.mm.plugin.sns.ui.a;

import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ListView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.autogen.a.cg;
import com.tencent.mm.modelimage.r;
import com.tencent.mm.plugin.brandservice.api.h.a;
import com.tencent.mm.plugin.messenger.foundation.a.n;
import com.tencent.mm.plugin.sns.b.j;
import com.tencent.mm.plugin.sns.data.t;
import com.tencent.mm.plugin.sns.model.al;
import com.tencent.mm.plugin.sns.model.ap;
import com.tencent.mm.plugin.sns.storage.SnsInfo;
import com.tencent.mm.plugin.sns.ui.ad;
import com.tencent.mm.plugin.sns.ui.bn;
import com.tencent.mm.plugin.sns.ui.bo;
import com.tencent.mm.protocal.protobuf.SnsObject;
import com.tencent.mm.protocal.protobuf.TimeLineObject;
import com.tencent.mm.protocal.protobuf.agh;
import com.tencent.mm.protocal.protobuf.dll;
import com.tencent.mm.protocal.protobuf.fr;
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
  implements ad
{
  private static HashMap<Long, a> RGF;
  private static boolean RGG;
  private static int vAZ;
  public bn RGC;
  public com.tencent.mm.plugin.sns.ui.a.b.b RGD;
  public boolean RGE;
  private Vending.d RzG;
  private boolean mLoaded;
  
  static
  {
    AppMethodBeat.i(99831);
    RGF = new HashMap();
    RGG = false;
    vAZ = 2;
    AppMethodBeat.o(99831);
  }
  
  public c(MMActivity paramMMActivity, ListView paramListView, com.tencent.mm.plugin.sns.ui.listener.c paramc, com.tencent.mm.plugin.sns.ui.i parami, String paramString, com.tencent.mm.plugin.sns.ui.a.b.b paramb, Vending.d paramd)
  {
    AppMethodBeat.i(179319);
    this.mLoaded = false;
    this.RzG = new Vending.d()
    {
      public final void hpU()
      {
        AppMethodBeat.i(99813);
        if (!c.a(c.this))
        {
          c.this.notifyDataSetChanged();
          new cg().publish();
        }
        AppMethodBeat.o(99813);
      }
    };
    this.RGC = new bn(paramMMActivity, paramListView, paramc, parami, this);
    this.RGC.Roa = true;
    paramListView = paramb;
    if (paramb == null) {
      paramListView = new com.tencent.mm.plugin.sns.ui.a.b.c();
    }
    this.RGD = paramListView;
    this.RGD.a(paramMMActivity, this.RGC, paramString);
    paramMMActivity = this.RGD;
    com.tencent.mm.vending.f.a.i("Vending.ForwardVending", "Vending.setRangeSize(%s)", new Object[] { Integer.valueOf(10) });
    paramMMActivity.agtW = 10;
    this.RGD.addVendingDataChangedCallback(paramd);
    AppMethodBeat.o(179319);
  }
  
  public static void ac(SnsInfo paramSnsInfo)
  {
    AppMethodBeat.i(99824);
    al.gHI().post(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(99814);
        long l1;
        c.a locala;
        if (c.this != null)
        {
          l1 = c.this.field_snsId;
          if (!c.RGF.containsKey(Long.valueOf(l1)))
          {
            locala = new c.a();
            if ((c.this.getTimeLine() != null) && (c.this.getTimeLine().ContentObj != null) && (c.this.getTimeLine().ContentObj.Zpq == 1) && (c.this.getTimeLine().ContentObj.Zpr != null) && (c.this.getTimeLine().ContentObj.Zpr.size() > 0))
            {
              locala.nVc = c.this.getTimeLine().ContentObj.Zpr.size();
              locala.RGK = new HashSet();
              locala.RGL = new HashSet();
              locala.RGM = new HashSet();
              locala.RGN = new HashSet();
              locala.id = c.this.getTimeLine().Id;
              locala.RGS = c.this.getTimeLine().showFlag;
            }
          }
        }
        try
        {
          SnsObject localSnsObject = ap.E(c.this);
          locala.RGQ = localSnsObject.LikeCount;
          locala.RGR = localSnsObject.CommentCount;
        }
        catch (Exception localException1)
        {
          try
          {
            for (;;)
            {
              com.tencent.mm.kernel.h.baF();
              locala.Hwb = ((n)com.tencent.mm.kernel.h.ax(n.class)).gaZ().aLW(c.this.getUserName());
              long l2 = System.currentTimeMillis();
              com.tencent.mm.kernel.h.baF();
              locala.RGP = ((l2 - ((n)com.tencent.mm.kernel.h.ax(n.class)).gaZ().Hq(c.this.getUserName())) / 1000L);
              c.RGF.put(Long.valueOf(l1), locala);
              AppMethodBeat.o(99814);
              return;
              localException1 = localException1;
              locala.RGQ = 0;
              locala.RGR = 0;
            }
          }
          catch (Exception localException2)
          {
            for (;;)
            {
              locala.Hwb = 0;
              locala.RGP = 0L;
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
    com.tencent.mm.plugin.brandservice.api.h localh = (com.tencent.mm.plugin.brandservice.api.h)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.brandservice.api.h.class);
    String str2 = paramTimeLineObject.ContentObj.Url;
    int i = vAZ;
    if (paramTimeLineObject.AppInfo != null) {}
    for (String str1 = paramTimeLineObject.AppInfo.Id;; str1 = "")
    {
      localh.a(str2, i, str1, paramTimeLineObject.ContentObj.hAP, paramTimeLineObject.ContentObj.IGG, "timeline", 1);
      AppMethodBeat.o(99828);
      return;
    }
  }
  
  public static void g(TimeLineObject paramTimeLineObject)
  {
    AppMethodBeat.i(99829);
    if ((TextUtils.isEmpty(paramTimeLineObject.ContentObj.Url)) || (!paramTimeLineObject.ContentObj.Url.contains(WeChatHosts.domainString(b.j.host_mp_weixin_qq_com))))
    {
      AppMethodBeat.o(99829);
      return;
    }
    if (paramTimeLineObject.ContentObj.Zpu != null) {}
    for (int i = paramTimeLineObject.ContentObj.Zpu.nUA;; i = -1)
    {
      ((com.tencent.mm.plugin.brandservice.api.c)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.brandservice.api.c.class)).a(paramTimeLineObject.ContentObj.Url, i, vAZ, new Object[] { paramTimeLineObject.Id, null, null, paramTimeLineObject.UserName, Integer.valueOf(paramTimeLineObject.CreateTime), Long.valueOf(((com.tencent.mm.plugin.brandservice.api.c)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.brandservice.api.c.class)).aiB("__sns_timeline__")) });
      if ((!RGG) && (i != -1) && (((com.tencent.mm.plugin.brandservice.api.c)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.brandservice.api.c.class)).GV(24)))
      {
        RGG = true;
        ((com.tencent.mm.plugin.brandservice.api.c)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.brandservice.api.c.class)).GW(vAZ);
      }
      if ((i == 16) && (paramTimeLineObject.ContentObj.Zpu != null) && (!Util.isNullOrNil(paramTimeLineObject.ContentObj.Zpu.coverUrl)))
      {
        paramTimeLineObject = com.tencent.mm.api.b.U(paramTimeLineObject.ContentObj.Zpu.coverUrl, 4);
        Object localObject = com.tencent.mm.pluginsdk.model.y.bpF(paramTimeLineObject);
        if (!com.tencent.mm.vfs.y.ZC((String)localObject))
        {
          com.tencent.mm.modelimage.loader.a.c.a locala = new com.tencent.mm.modelimage.loader.a.c.a();
          locala.oKp = true;
          locala.fullPath = ((String)localObject);
          localObject = locala.bKx();
          r.bKe().a(paramTimeLineObject, (com.tencent.mm.modelimage.loader.a.c)localObject, null);
        }
      }
      AppMethodBeat.o(99829);
      return;
    }
  }
  
  public static void hqI()
  {
    AppMethodBeat.i(99827);
    al.gHI().post(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(99817);
        Iterator localIterator = c.RGF.entrySet().iterator();
        while (localIterator.hasNext())
        {
          c.a locala = (c.a)((Map.Entry)localIterator.next()).getValue();
          locala.networkType = t.heQ();
          Log.d("MicroMsg.SnsTimeLineVendingAdapter", "report big pic click, picNum:%d, clickPicNum:%d, firstClickPos:%d, networkType:%d, id:%s", new Object[] { Integer.valueOf(locala.nVc), Integer.valueOf(locala.RGK.size()), Integer.valueOf(locala.RGO), Integer.valueOf(locala.networkType), locala.id });
          Object localObject1 = locala.RGL.iterator();
          for (String str = ""; ((Iterator)localObject1).hasNext(); str = str + localObject2 + "|") {
            localObject2 = (Integer)((Iterator)localObject1).next();
          }
          localObject1 = str;
          if (str.length() >= 2) {
            localObject1 = str.substring(0, str.length() - 1);
          }
          Object localObject2 = locala.RGM.iterator();
          for (str = ""; ((Iterator)localObject2).hasNext(); str = str + localObject3 + "|") {
            localObject3 = (Integer)((Iterator)localObject2).next();
          }
          localObject2 = str;
          if (str.length() >= 2) {
            localObject2 = str.substring(0, str.length() - 1);
          }
          Object localObject3 = locala.RGN.iterator();
          Integer localInteger;
          for (str = ""; ((Iterator)localObject3).hasNext(); str = str + localInteger + "|") {
            localInteger = (Integer)((Iterator)localObject3).next();
          }
          localObject3 = str;
          if (str.length() >= 2) {
            localObject3 = str.substring(0, str.length() - 1);
          }
          com.tencent.mm.plugin.report.service.h.OAn.b(11599, new Object[] { Integer.valueOf(locala.nVc), Integer.valueOf(locala.RGK.size()), Integer.valueOf(locala.RGO), Integer.valueOf(locala.networkType), Integer.valueOf(0), locala.id, Long.valueOf(locala.RGP), Integer.valueOf(locala.Hwb), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(locala.RGQ), Integer.valueOf(locala.RGR), Integer.valueOf(0), localObject1, localObject2, localObject3, Integer.valueOf(0), "", Integer.valueOf(locala.RGS) });
        }
        c.RGF.clear();
        AppMethodBeat.o(99817);
      }
    });
    AppMethodBeat.o(99827);
  }
  
  public static void i(SnsInfo paramSnsInfo, final int paramInt)
  {
    AppMethodBeat.i(99825);
    al.gHI().post(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(99815);
        if (c.this != null)
        {
          long l = c.this.field_snsId;
          if (c.RGF.containsKey(Long.valueOf(l)))
          {
            c.a locala = (c.a)c.RGF.get(Long.valueOf(l));
            if (locala.RGO == 0) {
              locala.RGO = (paramInt + 1);
            }
            if (locala.RGK == null) {
              locala.RGK = new HashSet();
            }
            locala.RGK.add(Integer.valueOf(paramInt + 1));
          }
        }
        AppMethodBeat.o(99815);
      }
    });
    AppMethodBeat.o(99825);
  }
  
  public static void j(SnsInfo paramSnsInfo, final int paramInt)
  {
    AppMethodBeat.i(99826);
    al.gHI().post(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(99816);
        if (c.this != null)
        {
          long l = c.this.field_snsId;
          if (c.RGF.containsKey(Long.valueOf(l)))
          {
            c.a locala = (c.a)c.RGF.get(Long.valueOf(l));
            if (locala.RGL == null) {
              locala.RGL = new HashSet();
            }
            if (!locala.RGL.contains(Integer.valueOf(paramInt + 1))) {
              locala.RGL.add(Integer.valueOf(paramInt + 1));
            }
          }
        }
        AppMethodBeat.o(99816);
      }
    });
    AppMethodBeat.o(99826);
  }
  
  public final long Et(boolean paramBoolean)
  {
    AppMethodBeat.i(179321);
    int i = 0;
    int j = 0;
    for (;;)
    {
      SnsInfo localSnsInfo = alF(i);
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
  
  public final void Td()
  {
    AppMethodBeat.i(99819);
    if (this.mLoaded)
    {
      AppMethodBeat.o(99819);
      return;
    }
    this.mLoaded = true;
    this.RGD.notifyVendingDataChangeSynchronize();
    AppMethodBeat.o(99819);
  }
  
  public final SnsInfo alF(int paramInt)
  {
    AppMethodBeat.i(99823);
    Object localObject = (bo)this.RGD.get(paramInt);
    if (localObject == null)
    {
      AppMethodBeat.o(99823);
      return null;
    }
    localObject = ((bo)localObject).PJQ;
    AppMethodBeat.o(99823);
    return localObject;
  }
  
  public final bo alG(int paramInt)
  {
    AppMethodBeat.i(308352);
    bo localbo = (bo)this.RGD.get(paramInt);
    AppMethodBeat.o(308352);
    return localbo;
  }
  
  public final int getCount()
  {
    return this.RGD.mCount;
  }
  
  public final long getItemId(int paramInt)
  {
    return 0L;
  }
  
  public final int getItemViewType(int paramInt)
  {
    AppMethodBeat.i(99821);
    paramInt = this.RGC.getItemViewType(paramInt);
    AppMethodBeat.o(99821);
    return paramInt;
  }
  
  public final View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    AppMethodBeat.i(99820);
    paramView = this.RGC.y(paramInt, paramView);
    AppMethodBeat.o(99820);
    return paramView;
  }
  
  public final int getViewTypeCount()
  {
    return 34;
  }
  
  public final void hmc()
  {
    AppMethodBeat.i(369939);
    this.RGD.notifyVendingDataChange();
    AppMethodBeat.o(369939);
  }
  
  public final long hqJ()
  {
    AppMethodBeat.i(308356);
    int i = 0;
    int j = getCount() - 1;
    SnsInfo localSnsInfo = alF(j);
    if ((localSnsInfo != null) && (!localSnsInfo.isSourceExist(32)) && (localSnsInfo.field_snsId != 0L)) {}
    for (long l = localSnsInfo.field_snsId;; l = 0L)
    {
      AppMethodBeat.o(308356);
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
  
  public final void lO(int paramInt1, int paramInt2)
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
      localObject = alF(paramInt1 - 1);
      TimeLineObject localTimeLineObject;
      h.a locala;
      if (localObject != null)
      {
        localTimeLineObject = ((SnsInfo)localObject).getTimeLine();
        if ((localTimeLineObject != null) && (localTimeLineObject.ContentObj != null) && (!TextUtils.isEmpty(localTimeLineObject.ContentObj.Url)))
        {
          locala = new h.a();
          locala.url = localTimeLineObject.ContentObj.Url;
          locala.vAZ = vAZ;
          if (localTimeLineObject.AppInfo == null) {
            break label178;
          }
        }
      }
      label178:
      for (localObject = localTimeLineObject.AppInfo.Id;; localObject = "")
      {
        locala.appId = ((String)localObject);
        locala.title = localTimeLineObject.ContentObj.hAP;
        locala.desc = localTimeLineObject.ContentObj.IGG;
        locala.from = "timeline";
        localLinkedList.add(locala);
        paramInt1 += 1;
        break;
      }
    }
    Object localObject = (com.tencent.mm.plugin.brandservice.api.h)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.brandservice.api.h.class);
    if ((localObject != null) && (localLinkedList.size() > 0))
    {
      Log.v("MicroMsg.SnsTimeLineVendingAdapter", "[TRACE_PREFETCH] checkPreAuths authInfo size = %s", new Object[] { Integer.valueOf(localLinkedList.size()) });
      ((com.tencent.mm.plugin.brandservice.api.h)localObject).z(localLinkedList, 1);
    }
    AppMethodBeat.o(160747);
  }
  
  static final class a
  {
    int Hwb;
    HashSet<Integer> RGK;
    HashSet<Integer> RGL;
    HashSet<Integer> RGM;
    HashSet<Integer> RGN;
    int RGO;
    long RGP;
    int RGQ;
    int RGR;
    int RGS;
    String id;
    int nVc;
    int networkType;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.a.c
 * JD-Core Version:    0.7.0.1
 */