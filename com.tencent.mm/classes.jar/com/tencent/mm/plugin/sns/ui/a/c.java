package com.tencent.mm.plugin.sns.ui.a;

import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ListView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.at.o;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.messenger.foundation.a.j;
import com.tencent.mm.plugin.sns.model.ak;
import com.tencent.mm.plugin.sns.storage.n;
import com.tencent.mm.plugin.sns.ui.av;
import com.tencent.mm.plugin.sns.ui.aw;
import com.tencent.mm.plugin.sns.ui.w;
import com.tencent.mm.pluginsdk.model.p;
import com.tencent.mm.protocal.protobuf.SnsObject;
import com.tencent.mm.protocal.protobuf.TimeLineObject;
import com.tencent.mm.protocal.protobuf.bbs;
import com.tencent.mm.protocal.protobuf.vi;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.vending.base.Vending.a;
import com.tencent.mm.vfs.e;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Map.Entry;
import java.util.Set;

public final class c
  extends BaseAdapter
  implements w
{
  private static HashMap<Long, a> sdv;
  private static boolean sdw;
  private boolean eHo;
  public av sdr;
  public com.tencent.mm.plugin.sns.ui.a.b.b sds;
  public boolean sdt;
  public Vending.a sdu;
  
  static
  {
    AppMethodBeat.i(39947);
    sdv = new HashMap();
    sdw = false;
    AppMethodBeat.o(39947);
  }
  
  public c(MMActivity paramMMActivity, ListView paramListView, com.tencent.mm.plugin.sns.ui.d.b paramb, com.tencent.mm.plugin.sns.ui.i parami, String paramString, com.tencent.mm.plugin.sns.ui.a.b.b paramb1)
  {
    AppMethodBeat.i(39933);
    this.eHo = false;
    this.sdu = new c.1(this);
    this.sdr = new av(paramMMActivity, paramListView, paramb, parami, this);
    this.sdr.rNW = true;
    paramListView = paramb1;
    if (paramb1 == null) {
      paramListView = new com.tencent.mm.plugin.sns.ui.a.b.c();
    }
    this.sds = paramListView;
    this.sds.a(paramMMActivity, this.sdr, paramString);
    paramMMActivity = this.sds;
    com.tencent.mm.vending.f.a.i("Vending.ForwardVending", "Vending.setRangeSize(%s)", new Object[] { Integer.valueOf(10) });
    paramMMActivity.a = 10;
    this.sds.addVendingDataChangedCallback(this.sdu);
    AppMethodBeat.o(39933);
  }
  
  public static void E(n paramn)
  {
    AppMethodBeat.i(39939);
    long l1;
    a locala;
    if (paramn != null)
    {
      l1 = paramn.field_snsId;
      if (!sdv.containsKey(Long.valueOf(l1)))
      {
        locala = new a();
        if ((paramn.csh() != null) && (paramn.csh().xTS != null) && (paramn.csh().xTS.wNZ == 1) && (paramn.csh().xTS.wOa != null) && (paramn.csh().xTS.wOa.size() > 0))
        {
          locala.fjZ = paramn.csh().xTS.wOa.size();
          locala.sdy = new HashSet();
          locala.sdz = new HashSet();
          locala.sdA = new HashSet();
          locala.sdB = new HashSet();
          locala.id = paramn.csh().Id;
          locala.sdG = paramn.csh().dqG;
        }
      }
    }
    try
    {
      SnsObject localSnsObject = ak.q(paramn);
      locala.sdE = localSnsObject.LikeCount;
      locala.sdF = localSnsObject.CommentCount;
    }
    catch (Exception localException)
    {
      try
      {
        for (;;)
        {
          g.RM();
          locala.mVg = ((j)g.E(j.class)).bPQ().TA(paramn.field_userName);
          long l2 = System.currentTimeMillis();
          g.RM();
          locala.sdD = ((l2 - ((j)g.E(j.class)).bPQ().TE(paramn.field_userName)) / 1000L);
          sdv.put(Long.valueOf(l1), locala);
          AppMethodBeat.o(39939);
          return;
          localException = localException;
          locala.sdE = 0;
          locala.sdF = 0;
        }
      }
      catch (Exception paramn)
      {
        for (;;)
        {
          locala.mVg = 0;
          locala.sdD = 0L;
        }
      }
    }
  }
  
  public static void b(n paramn, int paramInt)
  {
    AppMethodBeat.i(39940);
    if (paramn != null)
    {
      long l = paramn.field_snsId;
      if (sdv.containsKey(Long.valueOf(l)))
      {
        paramn = (a)sdv.get(Long.valueOf(l));
        if (paramn.sdC == 0) {
          paramn.sdC = (paramInt + 1);
        }
        if (paramn.sdy == null) {
          paramn.sdy = new HashSet();
        }
        paramn.sdy.add(Integer.valueOf(paramInt + 1));
      }
    }
    AppMethodBeat.o(39940);
  }
  
  public static void c(n paramn, int paramInt)
  {
    AppMethodBeat.i(39941);
    if (paramn != null)
    {
      long l = paramn.field_snsId;
      if (sdv.containsKey(Long.valueOf(l)))
      {
        paramn = (a)sdv.get(Long.valueOf(l));
        if (paramn.sdz == null) {
          paramn.sdz = new HashSet();
        }
        if (!paramn.sdz.contains(Integer.valueOf(paramInt + 1))) {
          paramn.sdz.add(Integer.valueOf(paramInt + 1));
        }
      }
    }
    AppMethodBeat.o(39941);
  }
  
  public static void cwL()
  {
    AppMethodBeat.i(39944);
    Iterator localIterator = sdv.entrySet().iterator();
    while (localIterator.hasNext())
    {
      a locala = (a)((Map.Entry)localIterator.next()).getValue();
      locala.networkType = com.tencent.mm.plugin.sns.data.i.cnS();
      ab.d("MicroMsg.SnsTimeLineVendingAdapter", "report big pic click, picNum:%d, clickPicNum:%d, firstClickPos:%d, networkType:%d, id:%s", new Object[] { Integer.valueOf(locala.fjZ), Integer.valueOf(locala.sdy.size()), Integer.valueOf(locala.sdC), Integer.valueOf(locala.networkType), locala.id });
      Object localObject1 = locala.sdz.iterator();
      for (String str = ""; ((Iterator)localObject1).hasNext(); str = str + localObject2 + "|") {
        localObject2 = (Integer)((Iterator)localObject1).next();
      }
      localObject1 = str;
      if (str.length() >= 2) {
        localObject1 = str.substring(0, str.length() - 1);
      }
      Object localObject2 = locala.sdA.iterator();
      for (str = ""; ((Iterator)localObject2).hasNext(); str = str + localObject3 + "|") {
        localObject3 = (Integer)((Iterator)localObject2).next();
      }
      localObject2 = str;
      if (str.length() >= 2) {
        localObject2 = str.substring(0, str.length() - 1);
      }
      Object localObject3 = locala.sdB.iterator();
      Integer localInteger;
      for (str = ""; ((Iterator)localObject3).hasNext(); str = str + localInteger + "|") {
        localInteger = (Integer)((Iterator)localObject3).next();
      }
      localObject3 = str;
      if (str.length() >= 2) {
        localObject3 = str.substring(0, str.length() - 1);
      }
      com.tencent.mm.plugin.report.service.h.qsU.e(11599, new Object[] { Integer.valueOf(locala.fjZ), Integer.valueOf(locala.sdy.size()), Integer.valueOf(locala.sdC), Integer.valueOf(locala.networkType), Integer.valueOf(0), locala.id, Long.valueOf(locala.sdD), Integer.valueOf(locala.mVg), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(locala.sdE), Integer.valueOf(locala.sdF), Integer.valueOf(0), localObject1, localObject2, localObject3, Integer.valueOf(0), "", Integer.valueOf(locala.sdG) });
    }
    sdv.clear();
    AppMethodBeat.o(39944);
  }
  
  public static void d(n paramn, int paramInt)
  {
    AppMethodBeat.i(39942);
    if (paramn != null)
    {
      long l = paramn.field_snsId;
      if (sdv.containsKey(Long.valueOf(l)))
      {
        paramn = (a)sdv.get(Long.valueOf(l));
        if (paramn.sdA == null) {
          paramn.sdA = new HashSet();
        }
        if (!paramn.sdA.contains(Integer.valueOf(paramInt + 1))) {
          paramn.sdA.add(Integer.valueOf(paramInt + 1));
        }
      }
    }
    AppMethodBeat.o(39942);
  }
  
  public static void d(TimeLineObject paramTimeLineObject)
  {
    AppMethodBeat.i(39945);
    if ((TextUtils.isEmpty(paramTimeLineObject.xTS.Url)) || (!paramTimeLineObject.xTS.Url.contains("mp.weixin.qq.com")))
    {
      AppMethodBeat.o(39945);
      return;
    }
    if (paramTimeLineObject.xTS.wOd != null) {}
    for (int i = paramTimeLineObject.xTS.wOd.wqp;; i = -1)
    {
      ((com.tencent.mm.plugin.brandservice.a.b)g.E(com.tencent.mm.plugin.brandservice.a.b.class)).a(paramTimeLineObject.xTS.Url, i, 2, new Object[] { paramTimeLineObject.Id, null, null, paramTimeLineObject.jJA, Integer.valueOf(paramTimeLineObject.CreateTime), Long.valueOf(((com.tencent.mm.plugin.brandservice.a.b)g.E(com.tencent.mm.plugin.brandservice.a.b.class)).GK("__sns_timeline__")) });
      if ((!sdw) && (i != -1) && (((com.tencent.mm.plugin.brandservice.a.b)g.E(com.tencent.mm.plugin.brandservice.a.b.class)).rU(24)))
      {
        sdw = true;
        ((com.tencent.mm.plugin.brandservice.a.b)g.E(com.tencent.mm.plugin.brandservice.a.b.class)).rV(2);
      }
      if ((i == 5) && (((com.tencent.mm.plugin.brandservice.a.b)g.E(com.tencent.mm.plugin.brandservice.a.b.class)).aWm()) && (paramTimeLineObject.xTS.wOd != null) && (!bo.isNullOrNil(paramTimeLineObject.xTS.wOd.lHo)))
      {
        paramTimeLineObject = paramTimeLineObject.xTS.wOd.lHo;
        Object localObject = p.aln(paramTimeLineObject);
        if (!e.cN((String)localObject))
        {
          com.tencent.mm.at.a.a.c.a locala = new com.tencent.mm.at.a.a.c.a();
          locala.eNM = true;
          locala.eNO = ((String)localObject);
          localObject = locala.ahY();
          o.ahG().a(paramTimeLineObject, (com.tencent.mm.at.a.a.c)localObject, null);
        }
      }
      AppMethodBeat.o(39945);
      return;
    }
  }
  
  public static void e(n paramn, int paramInt)
  {
    AppMethodBeat.i(39943);
    if (paramn != null)
    {
      long l = paramn.field_snsId;
      if (sdv.containsKey(Long.valueOf(l)))
      {
        paramn = (a)sdv.get(Long.valueOf(l));
        if (paramn.sdB == null) {
          paramn.sdB = new HashSet();
        }
        if (!paramn.sdB.contains(Integer.valueOf(paramInt + 1))) {
          paramn.sdB.add(Integer.valueOf(paramInt + 1));
        }
      }
    }
    AppMethodBeat.o(39943);
  }
  
  public final n EE(int paramInt)
  {
    AppMethodBeat.i(39938);
    Object localObject = (aw)this.sds.get(paramInt);
    if (localObject == null)
    {
      AppMethodBeat.o(39938);
      return null;
    }
    localObject = ((aw)localObject).qXp;
    AppMethodBeat.o(39938);
    return localObject;
  }
  
  public final void ctD()
  {
    AppMethodBeat.i(156762);
    this.sds.notifyVendingDataChange();
    AppMethodBeat.o(156762);
  }
  
  public final int getCount()
  {
    return this.sds.c;
  }
  
  public final long getItemId(int paramInt)
  {
    return 0L;
  }
  
  public final int getItemViewType(int paramInt)
  {
    AppMethodBeat.i(39936);
    paramInt = this.sdr.getItemViewType(paramInt);
    AppMethodBeat.o(39936);
    return paramInt;
  }
  
  public final View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    AppMethodBeat.i(39935);
    paramView = this.sdr.h(paramInt, paramView);
    AppMethodBeat.o(39935);
    return paramView;
  }
  
  public final int getViewTypeCount()
  {
    return 16;
  }
  
  public final void ph()
  {
    AppMethodBeat.i(39934);
    if (this.eHo)
    {
      AppMethodBeat.o(39934);
      return;
    }
    this.eHo = true;
    this.sds.notifyVendingDataChangeSynchronize();
    AppMethodBeat.o(39934);
  }
  
  static final class a
  {
    int fjZ;
    String id;
    int mVg;
    int networkType;
    HashSet<Integer> sdA;
    HashSet<Integer> sdB;
    int sdC;
    long sdD;
    int sdE;
    int sdF;
    int sdG;
    HashSet<Integer> sdy;
    HashSet<Integer> sdz;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.a.c
 * JD-Core Version:    0.7.0.1
 */