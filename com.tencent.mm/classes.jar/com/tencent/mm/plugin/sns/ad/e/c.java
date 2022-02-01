package com.tencent.mm.plugin.sns.ad.e;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.model.z;
import com.tencent.mm.plugin.sns.data.k;
import com.tencent.mm.plugin.sns.data.r;
import com.tencent.mm.plugin.sns.model.aj;
import com.tencent.mm.plugin.sns.storage.ADInfo;
import com.tencent.mm.plugin.sns.storage.AdSnsInfo;
import com.tencent.mm.plugin.sns.storage.g;
import com.tencent.mm.protocal.protobuf.SnsObject;
import com.tencent.mm.protocal.protobuf.aez;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.LinkedList;

public final class c
{
  private static int IN(long paramLong)
  {
    boolean bool1 = true;
    AppMethodBeat.i(201900);
    AdSnsInfo localAdSnsInfo = aj.faR().JE(paramLong);
    String str = r.Jb(paramLong);
    if (localAdSnsInfo == null)
    {
      Log.w("AdPullDeleteHelper", "deleteAd, adSnsInfo==null, snsId=".concat(String.valueOf(str)));
      AppMethodBeat.o(201900);
      return 1;
    }
    try
    {
      SnsObject localSnsObject = (SnsObject)new SnsObject().parseFrom(localAdSnsInfo.field_attrBuf);
      if (localSnsObject == null)
      {
        Log.w("AdPullDeleteHelper", "deleteAd, snsObject==null, snsId=".concat(String.valueOf(str)));
        AppMethodBeat.o(201900);
        return 4;
      }
      boolean bool2 = k.a(localSnsObject, z.aTY());
      if ((localAdSnsInfo.field_localFlag & 0x80) > 0) {}
      for (;;)
      {
        Log.i("AdPullDeleteHelper", "deleteAd, hasCommentLike=" + bool2 + ", isExposure=" + bool1 + ", snsId=" + str);
        if (!bool2) {
          break;
        }
        AppMethodBeat.o(201900);
        return 2;
        bool1 = false;
      }
      if (bool1)
      {
        AppMethodBeat.o(201900);
        return 3;
      }
      aj.faR().delete(paramLong);
      aj.faT().JI(paramLong);
      g.JH(paramLong);
      try
      {
        com.tencent.mm.plugin.sns.data.i.a(0, paramLong, localAdSnsInfo.getAdInfo(), localAdSnsInfo.getAdXml());
        AppMethodBeat.o(201900);
        return 0;
      }
      catch (Throwable localThrowable)
      {
        for (;;)
        {
          Log.e("AdPullDeleteHelper", "deleteAd, reportAdDel exp=" + localThrowable.toString());
        }
      }
      return 4;
    }
    catch (Exception localException)
    {
      Log.e("AdPullDeleteHelper", "deleteAD, snsId=" + r.Jb(paramLong) + ", exp=" + localException.toString());
      AppMethodBeat.o(201900);
    }
  }
  
  public static void c(LinkedList<aez> paramLinkedList, int paramInt1, int paramInt2)
  {
    int i = 0;
    AppMethodBeat.i(201899);
    Object localObject;
    if (paramInt1 > 0)
    {
      Log.i("AdPullDeleteHelper", "handleAdPullDelete, count=" + paramInt1 + ", scene=" + paramInt2);
      if ((paramLinkedList != null) && (paramLinkedList.size() == paramInt1))
      {
        localObject = new l.a();
        StringBuilder localStringBuilder = new StringBuilder();
        paramInt2 = 0;
        if (paramInt2 < paramInt1)
        {
          long l = ((aez)paramLinkedList.get(paramInt2)).Id;
          String str = r.Jb(l);
          localStringBuilder.append(str).append("|");
          AdSnsInfo localAdSnsInfo;
          if (l != 0L)
          {
            localAdSnsInfo = aj.faR().JE(l);
            if (localAdSnsInfo != null) {
              break label179;
            }
            localStringBuilder.append(1).append(", ");
            ((l.a)localObject).m("", str, 1, 1);
            Log.i("AdPullDeleteHelper", "handleAdPullDelete, adSnsInfo==null, snsId=".concat(String.valueOf(str)));
          }
          for (;;)
          {
            paramInt2 += 1;
            break;
            label179:
            i = IN(l);
            ((l.a)localObject).m(localAdSnsInfo.getAdInfo().uxInfo, str, 1, i);
            localStringBuilder.append(i).append(", ");
          }
        }
        ((l.a)localObject).report();
        Log.i("AdPullDeleteHelper", "handleAdPullDelete, ret=" + localStringBuilder.toString());
        AppMethodBeat.o(201899);
        return;
      }
      localObject = new StringBuilder("handleAdPullDelete, count=").append(paramInt1).append(", list.size=");
      if (paramLinkedList != null) {
        break label300;
      }
    }
    label300:
    for (paramInt1 = i;; paramInt1 = paramLinkedList.size())
    {
      Log.e("AdPullDeleteHelper", paramInt1);
      AppMethodBeat.o(201899);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ad.e.c
 * JD-Core Version:    0.7.0.1
 */