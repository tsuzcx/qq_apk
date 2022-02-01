package com.tencent.mm.plugin.sns.ad.timeline.dynamic;

import android.text.TextUtils;
import android.util.ArrayMap;
import android.util.SparseArray;
import android.util.SparseLongArray;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.model.cn;
import com.tencent.mm.plugin.sns.ad.adxml.AdClickActionInfo;
import com.tencent.mm.plugin.sns.ad.adxml.c.a;
import com.tencent.mm.plugin.sns.ad.adxml.i;
import com.tencent.mm.plugin.sns.ad.b.b.a;
import com.tencent.mm.plugin.sns.data.t;
import com.tencent.mm.plugin.sns.storage.ADInfo;
import com.tencent.mm.plugin.sns.storage.ADXml;
import com.tencent.mm.plugin.sns.storage.ADXml.AdCardActionBtnInfo;
import com.tencent.mm.plugin.sns.storage.SnsInfo;
import com.tencent.mm.protocal.protobuf.ch;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class a
{
  static volatile a PYI;
  private static final SparseLongArray PYK;
  private final Map<String, SparseArray<c>> PYJ;
  
  static
  {
    AppMethodBeat.i(311088);
    SparseLongArray localSparseLongArray = new SparseLongArray();
    PYK = localSparseLongArray;
    localSparseLongArray.append(1, 1800000L);
    PYK.append(2, 300000L);
    PYK.append(1000001, 5000L);
    PYK.append(1000003, 60000L);
    PYK.append(3, 3600000L);
    AppMethodBeat.o(311088);
  }
  
  public a()
  {
    AppMethodBeat.i(311004);
    this.PYJ = new ArrayMap();
    AppMethodBeat.o(311004);
  }
  
  private static c a(int paramInt, com.tencent.mm.plugin.sns.ad.adxml.c paramc, c paramc1)
  {
    AppMethodBeat.i(311082);
    Object localObject2 = null;
    Object localObject1 = localObject2;
    if (paramc != null)
    {
      localObject1 = localObject2;
      if (paramc.PMh != null) {
        localObject1 = (c.a)paramc.PMh.get(paramInt);
      }
    }
    long l3 = cn.bDw();
    long l1;
    if (paramc1 == null)
    {
      long l2 = PYK.get(paramInt, 5000L);
      l1 = l2;
      if (localObject1 != null)
      {
        l1 = l2;
        if (((c.a)localObject1).expireTime > 5000L) {
          l1 = ((c.a)localObject1).expireTime;
        }
      }
    }
    for (paramc = new c(l3, l1, paramInt);; paramc = paramc1)
    {
      AppMethodBeat.o(311082);
      return paramc;
      paramc1.vCl = l3;
    }
  }
  
  private void a(int paramInt, SnsInfo paramSnsInfo, boolean paramBoolean)
  {
    AppMethodBeat.i(311025);
    if ((paramSnsInfo == null) || (paramSnsInfo.getAdXml() == null) || (paramSnsInfo.getAdXml().adLiveInfo == null))
    {
      AppMethodBeat.o(311025);
      return;
    }
    i locali = paramSnsInfo.getAdXml().adLiveInfo;
    if (locali.liveType == 0)
    {
      b(paramInt, paramSnsInfo, paramBoolean);
      AppMethodBeat.o(311025);
      return;
    }
    if (locali.liveType == 1)
    {
      a(paramSnsInfo, paramBoolean);
      AppMethodBeat.o(311025);
      return;
    }
    if (locali.liveType == 2) {
      b(paramSnsInfo, paramBoolean);
    }
    AppMethodBeat.o(311025);
  }
  
  private void a(SnsInfo paramSnsInfo, boolean paramBoolean)
  {
    AppMethodBeat.i(311044);
    AdClickActionInfo localAdClickActionInfo = null;
    if (paramSnsInfo.getAdXml().adCardActionBtnInfo != null) {
      localAdClickActionInfo = paramSnsInfo.getAdXml().adCardActionBtnInfo.clickActionInfo;
    }
    if (localAdClickActionInfo == null)
    {
      AppMethodBeat.o(311044);
      return;
    }
    paramSnsInfo = t.x(paramSnsInfo);
    if (!x(paramSnsInfo, 1000001, paramBoolean))
    {
      Log.i("SnsAd.DynamicUpdate", "requestFinderLivingNoticeState: is the time not expired??");
      AppMethodBeat.o(311044);
      return;
    }
    com.tencent.mm.plugin.sns.ad.b.b.a(paramSnsInfo, localAdClickActionInfo.finderUsername, localAdClickActionInfo.PLN, new b.a()
    {
      public final void b(String paramAnonymousString, int paramAnonymousInt1, int paramAnonymousInt2, Object paramAnonymousObject)
      {
        AppMethodBeat.i(311019);
        try
        {
          Log.i("SnsAd.DynamicUpdate", "the requestLivingNoticeState return errorCode is  ".concat(String.valueOf(paramAnonymousInt2)));
          if ((paramAnonymousInt2 == 0) && ((paramAnonymousObject instanceof Integer))) {
            com.tencent.mm.plugin.sns.ad.widget.living.b.gR(paramAnonymousString, ((Integer)paramAnonymousObject).intValue());
          }
          return;
        }
        finally
        {
          AppMethodBeat.o(311019);
        }
      }
    });
    AppMethodBeat.o(311044);
  }
  
  private boolean a(String paramString, int paramInt, com.tencent.mm.plugin.sns.ad.adxml.c paramc, boolean paramBoolean)
  {
    AppMethodBeat.i(311071);
    Object localObject = (SparseArray)this.PYJ.get(paramString);
    if (localObject == null)
    {
      localObject = new SparseArray();
      this.PYJ.put(paramString, localObject);
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
          long l = localc.vCl;
          localObject = localc;
          bool1 = bool2;
          if (cn.bDw() - l < localc.PYM)
          {
            bool1 = false;
            localObject = localc;
          }
        }
      }
      if (bool1) {
        paramString.put(paramInt, a(paramInt, paramc, (c)localObject));
      }
      AppMethodBeat.o(311071);
      return bool1;
    }
  }
  
  private ch[] a(String paramString, ch[] paramArrayOfch, boolean paramBoolean)
  {
    AppMethodBeat.i(311058);
    if (paramArrayOfch == null)
    {
      AppMethodBeat.o(311058);
      return null;
    }
    LinkedList localLinkedList = new LinkedList();
    int j = paramArrayOfch.length;
    int i = 0;
    while (i < j)
    {
      ch localch = paramArrayOfch[i];
      if ((localch != null) && (x(paramString, localch.wuj, paramBoolean))) {
        localLinkedList.add(localch);
      }
      i += 1;
    }
    paramString = (ch[])localLinkedList.toArray(new ch[0]);
    AppMethodBeat.o(311058);
    return paramString;
  }
  
  private void b(int paramInt, SnsInfo paramSnsInfo, boolean paramBoolean)
  {
    AppMethodBeat.i(311035);
    String str2 = t.x(paramSnsInfo);
    String str1 = "";
    ADInfo localADInfo = paramSnsInfo.getAdInfo();
    if (paramInt == 2) {
      localADInfo = paramSnsInfo.getAtAdInfo();
    }
    if (localADInfo != null) {
      str1 = localADInfo.uxInfo;
    }
    paramSnsInfo = a(str2, com.tencent.mm.plugin.sns.ad.widget.living.a.s(paramSnsInfo), paramBoolean);
    if (com.tencent.mm.plugin.sns.ad.j.d.z(paramSnsInfo))
    {
      new com.tencent.mm.plugin.sns.ad.h.d(str2, str1, paramSnsInfo).a(new b()
      {
        public final void c(int paramAnonymousInt, String paramAnonymousString, List<ch> paramAnonymousList)
        {
          AppMethodBeat.i(311022);
          int i = -1;
          if (paramAnonymousInt == 0) {}
          try
          {
            i = com.tencent.mm.plugin.sns.ad.widget.living.b.I(paramAnonymousString, paramAnonymousList);
            Log.d("SnsAd.DynamicUpdate", "doWeAppLivingRequest::sns id is " + paramAnonymousString + ", the status is " + i);
            return;
          }
          finally
          {
            AppMethodBeat.o(311022);
          }
        }
      });
      AppMethodBeat.o(311035);
      return;
    }
    Log.d("SnsAd.DynamicUpdate", "doWeAppLivingRequest::is the time not expired??");
    AppMethodBeat.o(311035);
  }
  
  private void b(SnsInfo paramSnsInfo, boolean paramBoolean)
  {
    AppMethodBeat.i(311049);
    i locali = paramSnsInfo.getAdXml().adLiveInfo;
    paramSnsInfo = t.x(paramSnsInfo);
    if (!x(paramSnsInfo, 1000003, paramBoolean))
    {
      Log.i("SnsAd.DynamicUpdate", "requestFinderLivingState: is the time not expired??");
      AppMethodBeat.o(311049);
      return;
    }
    com.tencent.mm.plugin.sns.ad.b.b.a(paramSnsInfo, locali.finderLiveId, new b.a()
    {
      public final void b(String paramAnonymousString, int paramAnonymousInt1, int paramAnonymousInt2, Object paramAnonymousObject)
      {
        AppMethodBeat.i(311023);
        try
        {
          Log.i("SnsAd.DynamicUpdate", "the requestFinderLivingState return errorCode is  ".concat(String.valueOf(paramAnonymousInt2)));
          if ((paramAnonymousInt2 == 0) && ((paramAnonymousObject instanceof Integer))) {
            com.tencent.mm.plugin.sns.ad.widget.living.b.gR(paramAnonymousString, ((Integer)paramAnonymousObject).intValue());
          }
          return;
        }
        finally
        {
          AppMethodBeat.o(311023);
        }
      }
    });
    AppMethodBeat.o(311049);
  }
  
  public static a hbB()
  {
    AppMethodBeat.i(311013);
    if (PYI == null) {}
    try
    {
      if (PYI == null) {
        PYI = new a();
      }
      a locala = PYI;
      AppMethodBeat.o(311013);
      return locala;
    }
    finally
    {
      AppMethodBeat.o(311013);
    }
  }
  
  private boolean x(String paramString, int paramInt, boolean paramBoolean)
  {
    AppMethodBeat.i(311065);
    paramBoolean = a(paramString, paramInt, null, paramBoolean);
    AppMethodBeat.o(311065);
    return paramBoolean;
  }
  
  public final void a(SnsInfo paramSnsInfo, boolean paramBoolean, a parama)
  {
    AppMethodBeat.i(311107);
    if ((paramSnsInfo == null) || (parama == null) || (paramSnsInfo.getAdXml() == null))
    {
      Log.w("SnsAd.DynamicUpdate", "the sns info or request action is null, please check it !!!");
      AppMethodBeat.o(311107);
      return;
    }
    try
    {
      String str = t.x(paramSnsInfo);
      if ((TextUtils.isEmpty(str)) || ("0".equals(str)))
      {
        Log.w("SnsAd.DynamicUpdate", "the sns id is empty, is it right?");
        return;
      }
      ADXml localADXml = paramSnsInfo.getAdXml();
      if (!a(str, parama.hbC(), localADXml.adDynamicUpdateInfo, paramBoolean))
      {
        Log.i("SnsAd.DynamicUpdate", "the request is too frequently, snsId is ".concat(String.valueOf(str)));
        return;
      }
      Log.d("SnsAd.DynamicUpdate", "it is going to do dynamic request, snsId is ".concat(String.valueOf(str)));
      parama.o(paramSnsInfo);
      return;
    }
    finally
    {
      AppMethodBeat.o(311107);
    }
  }
  
  public final void c(int paramInt, SnsInfo paramSnsInfo)
  {
    AppMethodBeat.i(311095);
    try
    {
      a(paramInt, paramSnsInfo, false);
      return;
    }
    finally
    {
      AppMethodBeat.o(311095);
    }
  }
  
  public final void d(int paramInt, SnsInfo paramSnsInfo)
  {
    AppMethodBeat.i(311103);
    try
    {
      a(paramInt, paramSnsInfo, true);
      return;
    }
    finally
    {
      AppMethodBeat.o(311103);
    }
  }
  
  public static abstract interface a
  {
    public abstract int hbC();
    
    public abstract void o(SnsInfo paramSnsInfo);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ad.timeline.dynamic.a
 * JD-Core Version:    0.7.0.1
 */