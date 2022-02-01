package com.tencent.mm.plugin.sns.ad.d;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.model.z;
import com.tencent.mm.plugin.sns.data.k;
import com.tencent.mm.plugin.sns.data.m;
import com.tencent.mm.plugin.sns.data.t;
import com.tencent.mm.plugin.sns.model.al;
import com.tencent.mm.plugin.sns.storage.ADInfo;
import com.tencent.mm.plugin.sns.storage.AdSnsInfo;
import com.tencent.mm.plugin.sns.storage.f;
import com.tencent.mm.plugin.sns.storage.n;
import com.tencent.mm.plugin.sns.storage.p;
import com.tencent.mm.protocal.protobuf.SnsObject;
import com.tencent.mm.protocal.protobuf.ahv;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.LinkedList;

public final class g
{
  public static void c(LinkedList<ahv> paramLinkedList, int paramInt1, int paramInt2)
  {
    int i = 0;
    AppMethodBeat.i(310041);
    Object localObject;
    if (paramInt1 > 0)
    {
      Log.i("AdPullDeleteHelper", "handleAdPullDelete, count=" + paramInt1 + ", scene=" + paramInt2);
      if ((paramLinkedList != null) && (paramLinkedList.size() == paramInt1))
      {
        localObject = new u.a();
        StringBuilder localStringBuilder = new StringBuilder();
        paramInt2 = 0;
        if (paramInt2 < paramInt1)
        {
          long l = ((ahv)paramLinkedList.get(paramInt2)).Id;
          String str = t.uA(l);
          localStringBuilder.append(str).append("|");
          AdSnsInfo localAdSnsInfo;
          if (l != 0L)
          {
            localAdSnsInfo = al.hgE().vd(l);
            if (localAdSnsInfo != null) {
              break label179;
            }
            localStringBuilder.append(1).append(", ");
            ((u.a)localObject).q("", str, 1, 1);
            Log.i("AdPullDeleteHelper", "handleAdPullDelete, adSnsInfo==null, snsId=".concat(String.valueOf(str)));
          }
          for (;;)
          {
            paramInt2 += 1;
            break;
            label179:
            i = un(l);
            ((u.a)localObject).q(localAdSnsInfo.getAdInfo().uxInfo, str, 1, i);
            localStringBuilder.append(i).append(", ");
          }
        }
        ((u.a)localObject).report();
        Log.i("AdPullDeleteHelper", "handleAdPullDelete, ret=" + localStringBuilder.toString());
        AppMethodBeat.o(310041);
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
      AppMethodBeat.o(310041);
      return;
    }
  }
  
  private static int un(long paramLong)
  {
    boolean bool1 = true;
    AppMethodBeat.i(310049);
    AdSnsInfo localAdSnsInfo = al.hgE().vd(paramLong);
    String str = t.uA(paramLong);
    if (localAdSnsInfo == null)
    {
      Log.w("AdPullDeleteHelper", "deleteAd, adSnsInfo==null, snsId=".concat(String.valueOf(str)));
      AppMethodBeat.o(310049);
      return 1;
    }
    try
    {
      SnsObject localSnsObject = (SnsObject)new SnsObject().parseFrom(localAdSnsInfo.field_attrBuf);
      if (localSnsObject == null)
      {
        Log.w("AdPullDeleteHelper", "deleteAd, snsObject==null, snsId=".concat(String.valueOf(str)));
        AppMethodBeat.o(310049);
        return 4;
      }
      boolean bool2 = m.a(localSnsObject, z.bAM());
      if ((localAdSnsInfo.field_localFlag & 0x80) > 0) {}
      for (;;)
      {
        Log.i("AdPullDeleteHelper", "deleteAd, hasCommentLike=" + bool2 + ", isExposure=" + bool1 + ", snsId=" + str);
        if (!bool2) {
          break;
        }
        AppMethodBeat.o(310049);
        return 2;
        bool1 = false;
      }
      al.hgE().delete(paramLong);
      al.hgH().vh(paramLong);
      n.vg(paramLong);
      try
      {
        k.a(0, paramLong, localAdSnsInfo.getAdInfo(), localAdSnsInfo.getAdXml());
        AppMethodBeat.o(310049);
        return 0;
      }
      finally
      {
        for (;;)
        {
          Log.e("AdPullDeleteHelper", "deleteAd, reportAdDel exp=" + localObject.toString());
        }
      }
      return 4;
    }
    catch (Exception localException)
    {
      Log.e("AdPullDeleteHelper", "deleteAD, snsId=" + t.uA(paramLong) + ", exp=" + localException.toString());
      AppMethodBeat.o(310049);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ad.d.g
 * JD-Core Version:    0.7.0.1
 */