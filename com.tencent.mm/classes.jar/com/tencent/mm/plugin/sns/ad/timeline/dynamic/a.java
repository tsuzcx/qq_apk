package com.tencent.mm.plugin.sns.ad.timeline.dynamic;

import android.text.TextUtils;
import android.util.ArrayMap;
import android.util.SparseArray;
import android.util.SparseLongArray;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.model.cl;
import com.tencent.mm.plugin.sns.ad.a.g;
import com.tencent.mm.plugin.sns.data.r;
import com.tencent.mm.plugin.sns.storage.ADInfo;
import com.tencent.mm.plugin.sns.storage.ADXml;
import com.tencent.mm.plugin.sns.storage.ADXml.AdCardActionBtnInfo;
import com.tencent.mm.plugin.sns.storage.SnsInfo;
import com.tencent.mm.protocal.protobuf.bz;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class a
{
  static volatile a DxO;
  private static final SparseLongArray DxQ;
  private final Map<String, SparseArray<c>> DxP;
  
  static
  {
    AppMethodBeat.i(202139);
    SparseLongArray localSparseLongArray = new SparseLongArray();
    DxQ = localSparseLongArray;
    localSparseLongArray.append(1, 1800000L);
    DxQ.append(2, 300000L);
    DxQ.append(1000001, 5000L);
    DxQ.append(1000003, 60000L);
    DxQ.append(3, 3600000L);
    AppMethodBeat.o(202139);
  }
  
  public a()
  {
    AppMethodBeat.i(202126);
    this.DxP = new ArrayMap();
    AppMethodBeat.o(202126);
  }
  
  private static c a(int paramInt, com.tencent.mm.plugin.sns.ad.a.b paramb, c paramc)
  {
    AppMethodBeat.i(202138);
    Object localObject2 = null;
    Object localObject1 = localObject2;
    if (paramb != null)
    {
      localObject1 = localObject2;
      if (paramb.DrN != null) {
        localObject1 = (com.tencent.mm.plugin.sns.ad.a.b.a)paramb.DrN.get(paramInt);
      }
    }
    long l3 = cl.aWA();
    long l1;
    if (paramc == null)
    {
      long l2 = DxQ.get(paramInt, 5000L);
      l1 = l2;
      if (localObject1 != null)
      {
        l1 = l2;
        if (((com.tencent.mm.plugin.sns.ad.a.b.a)localObject1).DrO > 5000L) {
          l1 = ((com.tencent.mm.plugin.sns.ad.a.b.a)localObject1).DrO;
        }
      }
    }
    for (paramb = new c(l3, l1, paramInt);; paramb = paramc)
    {
      AppMethodBeat.o(202138);
      return paramb;
      paramc.pnE = l3;
    }
  }
  
  private void a(int paramInt, SnsInfo paramSnsInfo, boolean paramBoolean)
  {
    AppMethodBeat.i(202131);
    if ((paramSnsInfo == null) || (paramSnsInfo.getAdXml() == null) || (paramSnsInfo.getAdXml().adLiveInfo == null))
    {
      AppMethodBeat.o(202131);
      return;
    }
    g localg = paramSnsInfo.getAdXml().adLiveInfo;
    if (localg.liveType == 0)
    {
      b(paramInt, paramSnsInfo, paramBoolean);
      AppMethodBeat.o(202131);
      return;
    }
    if (localg.liveType == 1)
    {
      a(paramSnsInfo, paramBoolean);
      AppMethodBeat.o(202131);
      return;
    }
    if (localg.liveType == 2) {
      b(paramSnsInfo, paramBoolean);
    }
    AppMethodBeat.o(202131);
  }
  
  private void a(SnsInfo paramSnsInfo, boolean paramBoolean)
  {
    AppMethodBeat.i(202133);
    ADXml.AdCardActionBtnInfo localAdCardActionBtnInfo = paramSnsInfo.getAdXml().adCardActionBtnInfo;
    if (localAdCardActionBtnInfo == null)
    {
      AppMethodBeat.o(202133);
      return;
    }
    paramSnsInfo = r.v(paramSnsInfo);
    if (!r(paramSnsInfo, 1000001, paramBoolean))
    {
      Log.i("SnsAd.DynamicUpdate", "requestFinderLivingNoticeState: is the time not expired??");
      AppMethodBeat.o(202133);
      return;
    }
    com.tencent.mm.plugin.sns.ad.c.b.a(paramSnsInfo, localAdCardActionBtnInfo.finderUsername, localAdCardActionBtnInfo.finderLiveNoticeId, new com.tencent.mm.plugin.sns.ad.c.b.a()
    {
      public final void b(String paramAnonymousString, int paramAnonymousInt, Object paramAnonymousObject)
      {
        AppMethodBeat.i(202124);
        try
        {
          Log.i("SnsAd.DynamicUpdate", "the requestLivingNoticeState return errorCode is  ".concat(String.valueOf(paramAnonymousInt)));
          if ((paramAnonymousInt == 0) && ((paramAnonymousObject instanceof Integer))) {
            com.tencent.mm.plugin.sns.ad.widget.living.b.fv(paramAnonymousString, ((Integer)paramAnonymousObject).intValue());
          }
          AppMethodBeat.o(202124);
          return;
        }
        catch (Throwable paramAnonymousString)
        {
          AppMethodBeat.o(202124);
        }
      }
    });
    AppMethodBeat.o(202133);
  }
  
  private boolean a(String paramString, int paramInt, com.tencent.mm.plugin.sns.ad.a.b paramb, boolean paramBoolean)
  {
    AppMethodBeat.i(202137);
    Object localObject = (SparseArray)this.DxP.get(paramString);
    if (localObject == null)
    {
      localObject = new SparseArray();
      this.DxP.put(paramString, localObject);
    }
    for (paramString = (String)localObject;; paramString = (String)localObject)
    {
      localObject = null;
      boolean bool2 = true;
      boolean bool1 = bool2;
      if (paramBoolean)
      {
        c localc = (c)paramString.get(paramInt);
        localObject = localc;
        bool1 = bool2;
        if (localc != null)
        {
          long l = localc.pnE;
          localObject = localc;
          bool1 = bool2;
          if (cl.aWA() - l < localc.DxS)
          {
            bool1 = false;
            localObject = localc;
          }
        }
      }
      if (bool1) {
        paramString.put(paramInt, a(paramInt, paramb, (c)localObject));
      }
      AppMethodBeat.o(202137);
      return bool1;
    }
  }
  
  private bz[] a(String paramString, bz[] paramArrayOfbz, boolean paramBoolean)
  {
    AppMethodBeat.i(202135);
    if (paramArrayOfbz == null)
    {
      AppMethodBeat.o(202135);
      return null;
    }
    LinkedList localLinkedList = new LinkedList();
    int j = paramArrayOfbz.length;
    int i = 0;
    while (i < j)
    {
      bz localbz = paramArrayOfbz[i];
      if ((localbz != null) && (r(paramString, localbz.pTI, paramBoolean))) {
        localLinkedList.add(localbz);
      }
      i += 1;
    }
    paramString = (bz[])localLinkedList.toArray(new bz[0]);
    AppMethodBeat.o(202135);
    return paramString;
  }
  
  private void b(int paramInt, SnsInfo paramSnsInfo, boolean paramBoolean)
  {
    AppMethodBeat.i(202132);
    String str2 = r.v(paramSnsInfo);
    String str1 = "";
    ADInfo localADInfo = paramSnsInfo.getAdInfo();
    if (paramInt == 2) {
      localADInfo = paramSnsInfo.getAtAdInfo();
    }
    if (localADInfo != null) {
      str1 = localADInfo.uxInfo;
    }
    paramSnsInfo = a(str2, com.tencent.mm.plugin.sns.ad.widget.living.a.q(paramSnsInfo), paramBoolean);
    if (com.tencent.mm.plugin.sns.ad.i.c.x(paramSnsInfo))
    {
      new com.tencent.mm.plugin.sns.ad.h.c(str2, str1, paramSnsInfo).a(new b()
      {
        public final void c(int paramAnonymousInt, String paramAnonymousString, List<bz> paramAnonymousList)
        {
          AppMethodBeat.i(202123);
          int i = -1;
          if (paramAnonymousInt == 0) {}
          try
          {
            i = com.tencent.mm.plugin.sns.ad.widget.living.b.C(paramAnonymousString, paramAnonymousList);
            Log.d("SnsAd.DynamicUpdate", "doWeAppLivingRequest::sns id is " + paramAnonymousString + ", the status is " + i);
            AppMethodBeat.o(202123);
            return;
          }
          catch (Throwable paramAnonymousString)
          {
            AppMethodBeat.o(202123);
          }
        }
      });
      AppMethodBeat.o(202132);
      return;
    }
    Log.d("SnsAd.DynamicUpdate", "doWeAppLivingRequest::is the time not expired??");
    AppMethodBeat.o(202132);
  }
  
  private void b(SnsInfo paramSnsInfo, boolean paramBoolean)
  {
    AppMethodBeat.i(202134);
    g localg = paramSnsInfo.getAdXml().adLiveInfo;
    paramSnsInfo = r.v(paramSnsInfo);
    if (!r(paramSnsInfo, 1000003, paramBoolean))
    {
      Log.i("SnsAd.DynamicUpdate", "requestFinderLivingState: is the time not expired??");
      AppMethodBeat.o(202134);
      return;
    }
    com.tencent.mm.plugin.sns.ad.c.b.a(paramSnsInfo, localg.finderLiveId, new com.tencent.mm.plugin.sns.ad.c.b.a()
    {
      public final void b(String paramAnonymousString, int paramAnonymousInt, Object paramAnonymousObject)
      {
        AppMethodBeat.i(202125);
        try
        {
          Log.i("SnsAd.DynamicUpdate", "the requestFinderLivingState return errorCode is  ".concat(String.valueOf(paramAnonymousInt)));
          if ((paramAnonymousInt == 0) && ((paramAnonymousObject instanceof Integer))) {
            com.tencent.mm.plugin.sns.ad.widget.living.b.fv(paramAnonymousString, ((Integer)paramAnonymousObject).intValue());
          }
          AppMethodBeat.o(202125);
          return;
        }
        catch (Throwable paramAnonymousString)
        {
          AppMethodBeat.o(202125);
        }
      }
    });
    AppMethodBeat.o(202134);
  }
  
  public static a eXI()
  {
    AppMethodBeat.i(202127);
    if (DxO == null) {}
    try
    {
      if (DxO == null) {
        DxO = new a();
      }
      a locala = DxO;
      AppMethodBeat.o(202127);
      return locala;
    }
    finally
    {
      AppMethodBeat.o(202127);
    }
  }
  
  private boolean r(String paramString, int paramInt, boolean paramBoolean)
  {
    AppMethodBeat.i(202136);
    paramBoolean = a(paramString, paramInt, null, paramBoolean);
    AppMethodBeat.o(202136);
    return paramBoolean;
  }
  
  public final void a(int paramInt, SnsInfo paramSnsInfo)
  {
    AppMethodBeat.i(202128);
    try
    {
      a(paramInt, paramSnsInfo, false);
      AppMethodBeat.o(202128);
      return;
    }
    catch (Throwable paramSnsInfo)
    {
      AppMethodBeat.o(202128);
    }
  }
  
  public final void a(SnsInfo paramSnsInfo, boolean paramBoolean, a parama)
  {
    AppMethodBeat.i(202130);
    if ((paramSnsInfo == null) || (parama == null) || (paramSnsInfo.getAdXml() == null))
    {
      Log.w("SnsAd.DynamicUpdate", "the sns info or request action is null, please check it !!!");
      AppMethodBeat.o(202130);
      return;
    }
    try
    {
      String str = r.v(paramSnsInfo);
      if ((TextUtils.isEmpty(str)) || ("0".equals(str)))
      {
        Log.w("SnsAd.DynamicUpdate", "the sns id is empty, is it right?");
        AppMethodBeat.o(202130);
        return;
      }
      if (!a(str, 3, paramSnsInfo.getAdXml().adDynamicUpdateInfo, paramBoolean))
      {
        Log.i("SnsAd.DynamicUpdate", "the request is too frequently, snsId is ".concat(String.valueOf(str)));
        AppMethodBeat.o(202130);
        return;
      }
      Log.d("SnsAd.DynamicUpdate", "it is going to do dynamic request, snsId is ".concat(String.valueOf(str)));
      parama.m(paramSnsInfo);
      AppMethodBeat.o(202130);
      return;
    }
    catch (Throwable paramSnsInfo)
    {
      AppMethodBeat.o(202130);
    }
  }
  
  public final void b(int paramInt, SnsInfo paramSnsInfo)
  {
    AppMethodBeat.i(202129);
    try
    {
      a(paramInt, paramSnsInfo, true);
      AppMethodBeat.o(202129);
      return;
    }
    catch (Throwable paramSnsInfo)
    {
      AppMethodBeat.o(202129);
    }
  }
  
  public static abstract interface a
  {
    public abstract void m(SnsInfo paramSnsInfo);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ad.timeline.dynamic.a
 * JD-Core Version:    0.7.0.1
 */