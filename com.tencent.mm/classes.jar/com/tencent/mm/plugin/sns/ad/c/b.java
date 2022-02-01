package com.tencent.mm.plugin.sns.ad.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.model.v;
import com.tencent.mm.plugin.sns.data.r;
import com.tencent.mm.plugin.sns.model.ah;
import com.tencent.mm.plugin.sns.storage.a;
import com.tencent.mm.plugin.sns.storage.e;
import com.tencent.mm.plugin.sns.storage.f;
import com.tencent.mm.protocal.protobuf.SnsObject;
import com.tencent.mm.protocal.protobuf.acw;
import com.tencent.mm.sdk.platformtools.ae;
import java.util.LinkedList;

public final class b
{
  public static void c(LinkedList<acw> paramLinkedList, int paramInt1, int paramInt2)
  {
    int i = 0;
    AppMethodBeat.i(218998);
    Object localObject;
    if (paramInt1 > 0)
    {
      ae.i("AdPullDeleteHelper", "handleAdPullDelete, count=" + paramInt1 + ", scene=" + paramInt2);
      if ((paramLinkedList != null) && (paramLinkedList.size() == paramInt1))
      {
        localObject = new f.a();
        StringBuilder localStringBuilder = new StringBuilder();
        paramInt2 = 0;
        if (paramInt2 < paramInt1)
        {
          long l = ((acw)paramLinkedList.get(paramInt2)).Id;
          String str = r.zV(l);
          localStringBuilder.append(str).append("|");
          e locale;
          if (l != 0L)
          {
            locale = ah.dXH().Ax(l);
            if (locale != null) {
              break label179;
            }
            localStringBuilder.append(1).append(", ");
            ((f.a)localObject).m("", str, 1, 1);
            ae.i("AdPullDeleteHelper", "handleAdPullDelete, adSnsInfo==null, snsId=".concat(String.valueOf(str)));
          }
          for (;;)
          {
            paramInt2 += 1;
            break;
            label179:
            i = zJ(l);
            ((f.a)localObject).m(locale.dVi().dGD, str, 1, i);
            localStringBuilder.append(i).append(", ");
          }
        }
        ((f.a)localObject).report();
        ae.i("AdPullDeleteHelper", "handleAdPullDelete, ret=" + localStringBuilder.toString());
        AppMethodBeat.o(218998);
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
      ae.e("AdPullDeleteHelper", paramInt1);
      AppMethodBeat.o(218998);
      return;
    }
  }
  
  private static int zJ(long paramLong)
  {
    boolean bool1 = true;
    AppMethodBeat.i(218999);
    e locale = ah.dXH().Ax(paramLong);
    String str = r.zV(paramLong);
    if (locale == null)
    {
      ae.w("AdPullDeleteHelper", "deleteAd, adSnsInfo==null, snsId=".concat(String.valueOf(str)));
      AppMethodBeat.o(218999);
      return 1;
    }
    try
    {
      SnsObject localSnsObject = (SnsObject)new SnsObject().parseFrom(locale.field_attrBuf);
      if (localSnsObject == null)
      {
        ae.w("AdPullDeleteHelper", "deleteAd, snsObject==null, snsId=".concat(String.valueOf(str)));
        AppMethodBeat.o(218999);
        return 4;
      }
      boolean bool2 = com.tencent.mm.plugin.sns.data.k.a(localSnsObject, v.aAC());
      if ((locale.field_localFlag & 0x80) > 0) {}
      for (;;)
      {
        ae.i("AdPullDeleteHelper", "deleteAd, hasCommentLike=" + bool2 + ", isExposure=" + bool1 + ", snsId=" + str);
        if (!bool2) {
          break;
        }
        AppMethodBeat.o(218999);
        return 2;
        bool1 = false;
      }
      if (bool1)
      {
        AppMethodBeat.o(218999);
        return 3;
      }
      ah.dXH().delete(paramLong);
      ah.dXJ().AB(paramLong);
      com.tencent.mm.plugin.sns.storage.i.AA(paramLong);
      try
      {
        com.tencent.mm.plugin.sns.data.i.a(0, paramLong, locale.dVi(), locale.dVj());
        AppMethodBeat.o(218999);
        return 0;
      }
      catch (Throwable localThrowable)
      {
        for (;;)
        {
          ae.e("AdPullDeleteHelper", "deleteAd, reportAdDel exp=" + localThrowable.toString());
        }
      }
      return 4;
    }
    catch (Exception localException)
    {
      ae.e("AdPullDeleteHelper", "deleteAD, snsId=" + r.zV(paramLong) + ", exp=" + localException.toString());
      AppMethodBeat.o(218999);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ad.c.b
 * JD-Core Version:    0.7.0.1
 */