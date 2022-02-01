package com.tencent.mm.plugin.sns.ad.timeline.dynamic;

import android.text.TextUtils;
import android.util.ArrayMap;
import android.util.SparseArray;
import android.util.SparseLongArray;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.model.cm;
import com.tencent.mm.plugin.sns.ad.adxml.AdClickActionInfo;
import com.tencent.mm.plugin.sns.ad.adxml.g;
import com.tencent.mm.plugin.sns.ad.i.d;
import com.tencent.mm.plugin.sns.data.t;
import com.tencent.mm.plugin.sns.storage.ADInfo;
import com.tencent.mm.plugin.sns.storage.ADXml;
import com.tencent.mm.plugin.sns.storage.ADXml.AdCardActionBtnInfo;
import com.tencent.mm.plugin.sns.storage.SnsInfo;
import com.tencent.mm.protocal.protobuf.bx;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class a
{
  static volatile a JHH;
  private static final SparseLongArray JHJ;
  private final Map<String, SparseArray<c>> JHI;
  
  static
  {
    AppMethodBeat.i(269660);
    SparseLongArray localSparseLongArray = new SparseLongArray();
    JHJ = localSparseLongArray;
    localSparseLongArray.append(1, 1800000L);
    JHJ.append(2, 300000L);
    JHJ.append(1000001, 5000L);
    JHJ.append(1000003, 60000L);
    JHJ.append(3, 3600000L);
    AppMethodBeat.o(269660);
  }
  
  public a()
  {
    AppMethodBeat.i(269647);
    this.JHI = new ArrayMap();
    AppMethodBeat.o(269647);
  }
  
  private static c a(int paramInt, com.tencent.mm.plugin.sns.ad.adxml.b paramb, c paramc)
  {
    AppMethodBeat.i(269659);
    Object localObject2 = null;
    Object localObject1 = localObject2;
    if (paramb != null)
    {
      localObject1 = localObject2;
      if (paramb.Jyi != null) {
        localObject1 = (com.tencent.mm.plugin.sns.ad.adxml.b.a)paramb.Jyi.get(paramInt);
      }
    }
    long l3 = cm.bfE();
    long l1;
    if (paramc == null)
    {
      long l2 = JHJ.get(paramInt, 5000L);
      l1 = l2;
      if (localObject1 != null)
      {
        l1 = l2;
        if (((com.tencent.mm.plugin.sns.ad.adxml.b.a)localObject1).expireTime > 5000L) {
          l1 = ((com.tencent.mm.plugin.sns.ad.adxml.b.a)localObject1).expireTime;
        }
      }
    }
    for (paramb = new c(l3, l1, paramInt);; paramb = paramc)
    {
      AppMethodBeat.o(269659);
      return paramb;
      paramc.swE = l3;
    }
  }
  
  private void a(int paramInt, SnsInfo paramSnsInfo, boolean paramBoolean)
  {
    AppMethodBeat.i(269652);
    if ((paramSnsInfo == null) || (paramSnsInfo.getAdXml() == null) || (paramSnsInfo.getAdXml().adLiveInfo == null))
    {
      AppMethodBeat.o(269652);
      return;
    }
    g localg = paramSnsInfo.getAdXml().adLiveInfo;
    if (localg.liveType == 0)
    {
      b(paramInt, paramSnsInfo, paramBoolean);
      AppMethodBeat.o(269652);
      return;
    }
    if (localg.liveType == 1)
    {
      a(paramSnsInfo, paramBoolean);
      AppMethodBeat.o(269652);
      return;
    }
    if (localg.liveType == 2) {
      b(paramSnsInfo, paramBoolean);
    }
    AppMethodBeat.o(269652);
  }
  
  private void a(SnsInfo paramSnsInfo, boolean paramBoolean)
  {
    AppMethodBeat.i(269654);
    AdClickActionInfo localAdClickActionInfo = null;
    if (paramSnsInfo.getAdXml().adCardActionBtnInfo != null) {
      localAdClickActionInfo = paramSnsInfo.getAdXml().adCardActionBtnInfo.clickActionInfo;
    }
    if (localAdClickActionInfo == null)
    {
      AppMethodBeat.o(269654);
      return;
    }
    paramSnsInfo = t.w(paramSnsInfo);
    if (!v(paramSnsInfo, 1000001, paramBoolean))
    {
      Log.i("SnsAd.DynamicUpdate", "requestFinderLivingNoticeState: is the time not expired??");
      AppMethodBeat.o(269654);
      return;
    }
    com.tencent.mm.plugin.sns.ad.b.b.a(paramSnsInfo, localAdClickActionInfo.finderUsername, localAdClickActionInfo.JxY, new com.tencent.mm.plugin.sns.ad.b.b.a()
    {
      public final void b(String paramAnonymousString, int paramAnonymousInt1, int paramAnonymousInt2, Object paramAnonymousObject)
      {
        AppMethodBeat.i(267101);
        try
        {
          Log.i("SnsAd.DynamicUpdate", "the requestLivingNoticeState return errorCode is  ".concat(String.valueOf(paramAnonymousInt2)));
          if ((paramAnonymousInt2 == 0) && ((paramAnonymousObject instanceof Integer))) {
            com.tencent.mm.plugin.sns.ad.widget.living.b.fY(paramAnonymousString, ((Integer)paramAnonymousObject).intValue());
          }
          AppMethodBeat.o(267101);
          return;
        }
        catch (Throwable paramAnonymousString)
        {
          AppMethodBeat.o(267101);
        }
      }
    });
    AppMethodBeat.o(269654);
  }
  
  private boolean a(String paramString, int paramInt, com.tencent.mm.plugin.sns.ad.adxml.b paramb, boolean paramBoolean)
  {
    AppMethodBeat.i(269658);
    Object localObject = (SparseArray)this.JHI.get(paramString);
    if (localObject == null)
    {
      localObject = new SparseArray();
      this.JHI.put(paramString, localObject);
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
          long l = localc.swE;
          localObject = localc;
          bool1 = bool2;
          if (cm.bfE() - l < localc.JHL)
          {
            bool1 = false;
            localObject = localc;
          }
        }
      }
      if (bool1) {
        paramString.put(paramInt, a(paramInt, paramb, (c)localObject));
      }
      AppMethodBeat.o(269658);
      return bool1;
    }
  }
  
  private bx[] a(String paramString, bx[] paramArrayOfbx, boolean paramBoolean)
  {
    AppMethodBeat.i(269656);
    if (paramArrayOfbx == null)
    {
      AppMethodBeat.o(269656);
      return null;
    }
    LinkedList localLinkedList = new LinkedList();
    int j = paramArrayOfbx.length;
    int i = 0;
    while (i < j)
    {
      bx localbx = paramArrayOfbx[i];
      if ((localbx != null) && (v(paramString, localbx.tpK, paramBoolean))) {
        localLinkedList.add(localbx);
      }
      i += 1;
    }
    paramString = (bx[])localLinkedList.toArray(new bx[0]);
    AppMethodBeat.o(269656);
    return paramString;
  }
  
  private void b(int paramInt, SnsInfo paramSnsInfo, boolean paramBoolean)
  {
    AppMethodBeat.i(269653);
    String str2 = t.w(paramSnsInfo);
    String str1 = "";
    ADInfo localADInfo = paramSnsInfo.getAdInfo();
    if (paramInt == 2) {
      localADInfo = paramSnsInfo.getAtAdInfo();
    }
    if (localADInfo != null) {
      str1 = localADInfo.uxInfo;
    }
    paramSnsInfo = a(str2, com.tencent.mm.plugin.sns.ad.widget.living.a.q(paramSnsInfo), paramBoolean);
    if (d.x(paramSnsInfo))
    {
      new com.tencent.mm.plugin.sns.ad.g.c(str2, str1, paramSnsInfo).a(new b()
      {
        public final void c(int paramAnonymousInt, String paramAnonymousString, List<bx> paramAnonymousList)
        {
          AppMethodBeat.i(196666);
          int i = -1;
          if (paramAnonymousInt == 0) {}
          try
          {
            i = com.tencent.mm.plugin.sns.ad.widget.living.b.C(paramAnonymousString, paramAnonymousList);
            Log.d("SnsAd.DynamicUpdate", "doWeAppLivingRequest::sns id is " + paramAnonymousString + ", the status is " + i);
            AppMethodBeat.o(196666);
            return;
          }
          catch (Throwable paramAnonymousString)
          {
            AppMethodBeat.o(196666);
          }
        }
      });
      AppMethodBeat.o(269653);
      return;
    }
    Log.d("SnsAd.DynamicUpdate", "doWeAppLivingRequest::is the time not expired??");
    AppMethodBeat.o(269653);
  }
  
  private void b(SnsInfo paramSnsInfo, boolean paramBoolean)
  {
    AppMethodBeat.i(269655);
    g localg = paramSnsInfo.getAdXml().adLiveInfo;
    paramSnsInfo = t.w(paramSnsInfo);
    if (!v(paramSnsInfo, 1000003, paramBoolean))
    {
      Log.i("SnsAd.DynamicUpdate", "requestFinderLivingState: is the time not expired??");
      AppMethodBeat.o(269655);
      return;
    }
    com.tencent.mm.plugin.sns.ad.b.b.a(paramSnsInfo, localg.finderLiveId, new com.tencent.mm.plugin.sns.ad.b.b.a()
    {
      public final void b(String paramAnonymousString, int paramAnonymousInt1, int paramAnonymousInt2, Object paramAnonymousObject)
      {
        AppMethodBeat.i(243577);
        try
        {
          Log.i("SnsAd.DynamicUpdate", "the requestFinderLivingState return errorCode is  ".concat(String.valueOf(paramAnonymousInt2)));
          if ((paramAnonymousInt2 == 0) && ((paramAnonymousObject instanceof Integer))) {
            com.tencent.mm.plugin.sns.ad.widget.living.b.fY(paramAnonymousString, ((Integer)paramAnonymousObject).intValue());
          }
          AppMethodBeat.o(243577);
          return;
        }
        catch (Throwable paramAnonymousString)
        {
          AppMethodBeat.o(243577);
        }
      }
    });
    AppMethodBeat.o(269655);
  }
  
  public static a fLk()
  {
    AppMethodBeat.i(269648);
    if (JHH == null) {}
    try
    {
      if (JHH == null) {
        JHH = new a();
      }
      a locala = JHH;
      AppMethodBeat.o(269648);
      return locala;
    }
    finally
    {
      AppMethodBeat.o(269648);
    }
  }
  
  private boolean v(String paramString, int paramInt, boolean paramBoolean)
  {
    AppMethodBeat.i(269657);
    paramBoolean = a(paramString, paramInt, null, paramBoolean);
    AppMethodBeat.o(269657);
    return paramBoolean;
  }
  
  public final void a(int paramInt, SnsInfo paramSnsInfo)
  {
    AppMethodBeat.i(269649);
    try
    {
      a(paramInt, paramSnsInfo, false);
      AppMethodBeat.o(269649);
      return;
    }
    catch (Throwable paramSnsInfo)
    {
      AppMethodBeat.o(269649);
    }
  }
  
  public final void a(SnsInfo paramSnsInfo, boolean paramBoolean, a parama)
  {
    AppMethodBeat.i(269651);
    if ((paramSnsInfo == null) || (parama == null) || (paramSnsInfo.getAdXml() == null))
    {
      Log.w("SnsAd.DynamicUpdate", "the sns info or request action is null, please check it !!!");
      AppMethodBeat.o(269651);
      return;
    }
    try
    {
      String str = t.w(paramSnsInfo);
      if ((TextUtils.isEmpty(str)) || ("0".equals(str)))
      {
        Log.w("SnsAd.DynamicUpdate", "the sns id is empty, is it right?");
        AppMethodBeat.o(269651);
        return;
      }
      if (!a(str, 3, paramSnsInfo.getAdXml().adDynamicUpdateInfo, paramBoolean))
      {
        Log.i("SnsAd.DynamicUpdate", "the request is too frequently, snsId is ".concat(String.valueOf(str)));
        AppMethodBeat.o(269651);
        return;
      }
      Log.d("SnsAd.DynamicUpdate", "it is going to do dynamic request, snsId is ".concat(String.valueOf(str)));
      parama.m(paramSnsInfo);
      AppMethodBeat.o(269651);
      return;
    }
    catch (Throwable paramSnsInfo)
    {
      AppMethodBeat.o(269651);
    }
  }
  
  public final void b(int paramInt, SnsInfo paramSnsInfo)
  {
    AppMethodBeat.i(269650);
    try
    {
      a(paramInt, paramSnsInfo, true);
      AppMethodBeat.o(269650);
      return;
    }
    catch (Throwable paramSnsInfo)
    {
      AppMethodBeat.o(269650);
    }
  }
  
  public static abstract interface a
  {
    public abstract void m(SnsInfo paramSnsInfo);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ad.timeline.dynamic.a
 * JD-Core Version:    0.7.0.1
 */