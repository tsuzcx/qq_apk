package com.tencent.mm.plugin.sns.ad.d;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.model.z;
import com.tencent.mm.plugin.sns.data.k;
import com.tencent.mm.plugin.sns.data.m;
import com.tencent.mm.plugin.sns.data.t;
import com.tencent.mm.plugin.sns.model.aj;
import com.tencent.mm.plugin.sns.storage.ADInfo;
import com.tencent.mm.plugin.sns.storage.AdSnsInfo;
import com.tencent.mm.plugin.sns.storage.c;
import com.tencent.mm.plugin.sns.storage.g;
import com.tencent.mm.plugin.sns.storage.i;
import com.tencent.mm.protocal.protobuf.SnsObject;
import com.tencent.mm.protocal.protobuf.afi;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.LinkedList;

public final class f
{
  private static int Qg(long paramLong)
  {
    boolean bool1 = true;
    AppMethodBeat.i(204370);
    AdSnsInfo localAdSnsInfo = aj.fOL().QX(paramLong);
    String str = t.Qu(paramLong);
    if (localAdSnsInfo == null)
    {
      Log.w("AdPullDeleteHelper", "deleteAd, adSnsInfo==null, snsId=".concat(String.valueOf(str)));
      AppMethodBeat.o(204370);
      return 1;
    }
    try
    {
      SnsObject localSnsObject = (SnsObject)new SnsObject().parseFrom(localAdSnsInfo.field_attrBuf);
      if (localSnsObject == null)
      {
        Log.w("AdPullDeleteHelper", "deleteAd, snsObject==null, snsId=".concat(String.valueOf(str)));
        AppMethodBeat.o(204370);
        return 4;
      }
      boolean bool2 = m.a(localSnsObject, z.bcZ());
      if ((localAdSnsInfo.field_localFlag & 0x80) > 0) {}
      for (;;)
      {
        Log.i("AdPullDeleteHelper", "deleteAd, hasCommentLike=" + bool2 + ", isExposure=" + bool1 + ", snsId=" + str);
        if (!bool2) {
          break;
        }
        AppMethodBeat.o(204370);
        return 2;
        bool1 = false;
      }
      aj.fOL().delete(paramLong);
      aj.fON().Rb(paramLong);
      g.Ra(paramLong);
      try
      {
        k.a(0, paramLong, localAdSnsInfo.getAdInfo(), localAdSnsInfo.getAdXml());
        AppMethodBeat.o(204370);
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
      Log.e("AdPullDeleteHelper", "deleteAD, snsId=" + t.Qu(paramLong) + ", exp=" + localException.toString());
      AppMethodBeat.o(204370);
    }
  }
  
  public static void c(LinkedList<afi> paramLinkedList, int paramInt1, int paramInt2)
  {
    int i = 0;
    AppMethodBeat.i(204367);
    Object localObject;
    if (paramInt1 > 0)
    {
      Log.i("AdPullDeleteHelper", "handleAdPullDelete, count=" + paramInt1 + ", scene=" + paramInt2);
      if ((paramLinkedList != null) && (paramLinkedList.size() == paramInt1))
      {
        localObject = new q.a();
        StringBuilder localStringBuilder = new StringBuilder();
        paramInt2 = 0;
        if (paramInt2 < paramInt1)
        {
          long l = ((afi)paramLinkedList.get(paramInt2)).Id;
          String str = t.Qu(l);
          localStringBuilder.append(str).append("|");
          AdSnsInfo localAdSnsInfo;
          if (l != 0L)
          {
            localAdSnsInfo = aj.fOL().QX(l);
            if (localAdSnsInfo != null) {
              break label179;
            }
            localStringBuilder.append(1).append(", ");
            ((q.a)localObject).m("", str, 1, 1);
            Log.i("AdPullDeleteHelper", "handleAdPullDelete, adSnsInfo==null, snsId=".concat(String.valueOf(str)));
          }
          for (;;)
          {
            paramInt2 += 1;
            break;
            label179:
            i = Qg(l);
            ((q.a)localObject).m(localAdSnsInfo.getAdInfo().uxInfo, str, 1, i);
            localStringBuilder.append(i).append(", ");
          }
        }
        ((q.a)localObject).report();
        Log.i("AdPullDeleteHelper", "handleAdPullDelete, ret=" + localStringBuilder.toString());
        AppMethodBeat.o(204367);
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
      AppMethodBeat.o(204367);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ad.d.f
 * JD-Core Version:    0.7.0.1
 */