package com.tencent.mm.plugin.sns.ui.widget;

import android.content.Context;
import android.text.TextUtils;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.messenger.a.b;
import com.tencent.mm.plugin.sns.i.j;
import com.tencent.mm.plugin.sns.model.af;
import com.tencent.mm.pluginsdk.ui.d.k;
import com.tencent.mm.pluginsdk.ui.d.o;
import com.tencent.mm.protocal.c.btd;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.storage.ad;
import com.tencent.mm.storage.bd;

public final class c
{
  public static CharSequence a(Context paramContext, btd parambtd, com.tencent.mm.plugin.sns.ui.j paramj, int paramInt1, String paramString, int paramInt2)
  {
    String str3 = "";
    Object localObject1 = af.bDt().abk(parambtd.sxM);
    String str1;
    String str2;
    int j;
    int k;
    label52:
    Object localObject2;
    label141:
    int i;
    if (localObject1 != null)
    {
      str1 = ((com.tencent.mm.n.a)localObject1).Bq();
      localObject1 = "";
      Object localObject3 = null;
      str2 = null;
      j = 0;
      if (paramInt1 != 21) {
        break label368;
      }
      k = 3;
      String str4 = bk.pm(parambtd.kVs);
      localObject2 = null;
      if (!bk.bl(paramString))
      {
        g.DQ();
        localObject2 = ((com.tencent.mm.plugin.messenger.foundation.a.j)g.r(com.tencent.mm.plugin.messenger.foundation.a.j.class)).Fw().abj(paramString);
      }
      if (paramInt2 == 1) {
        localObject1 = str1;
      }
      if (parambtd.tJz != 1) {
        break label414;
      }
      if (localObject2 == null) {
        break label384;
      }
      if ((localObject2 != null) && (!TextUtils.isEmpty(((ad)localObject2).Bq()))) {
        break label374;
      }
      localObject2 = paramString;
      localObject1 = (String)localObject1 + paramContext.getString(i.j.sns_at);
      i = ((String)localObject1).length();
      localObject1 = (String)localObject1 + (String)localObject2;
      localObject1 = "" + (String)localObject1 + ": ";
      localObject3 = localObject2;
      localObject2 = str2;
      label232:
      paramContext = com.tencent.mm.pluginsdk.ui.d.j.a(paramContext, (String)localObject1 + str4, com.tencent.mm.cb.a.fromDPToPix(paramContext, (int)(15.0F * com.tencent.mm.cb.a.cJ(paramContext))), 2);
      if (paramInt1 != 21) {
        break label769;
      }
      paramInt1 = 3;
      label278:
      paramContext = new k(paramContext);
      if (paramInt2 == 1) {
        paramContext.a(new o(parambtd.sxM, paramj, paramInt1), str1, 0);
      }
      if (bk.bl(localObject3)) {
        break label774;
      }
      paramContext.a(new o(paramString, paramj, k), localObject3, i);
    }
    label368:
    label374:
    while (bk.bl((String)localObject2))
    {
      return paramContext;
      if (parambtd.tqh != null)
      {
        str1 = parambtd.tqh;
        break;
      }
      str1 = parambtd.sxM;
      break;
      k = 2;
      break label52;
      localObject2 = ((ad)localObject2).Bq();
      break label141;
      y.w("SnsCommentUtil", "feedContact null by feedOwnUserName %s", new Object[] { paramString });
      i = 0;
      localObject2 = str2;
      localObject1 = str3;
      break label232;
      if (parambtd.tJz == 8)
      {
        str2 = ((b)g.r(b.class)).gV(parambtd.tJO);
        localObject2 = localObject1;
        if (!bk.bl((String)localObject1)) {
          localObject2 = (String)localObject1 + ": ";
        }
        localObject1 = (String)localObject2 + paramContext.getString(i.j.sns_at);
        j = ((String)localObject1).length();
        localObject1 = (String)localObject1 + str2;
        localObject1 = "" + (String)localObject1 + " ";
        i = 0;
        localObject2 = str2;
        break label232;
      }
      if (!bk.bl(parambtd.tJO))
      {
        localObject2 = af.bDt().abk(parambtd.tJO);
        if (localObject2 == null) {}
        for (localObject2 = parambtd.tJO;; localObject2 = ((ad)localObject2).Bq())
        {
          localObject1 = (String)localObject1 + paramContext.getString(i.j.sns_reply);
          j = ((String)localObject1).length();
          localObject1 = (String)localObject1 + (String)localObject2;
          localObject1 = "" + (String)localObject1 + ": ";
          i = 0;
          break;
        }
      }
      localObject2 = localObject1;
      if (!bk.bl((String)localObject1)) {
        localObject2 = (String)localObject1 + ": ";
      }
      localObject1 = "" + (String)localObject2;
      i = 0;
      localObject2 = str2;
      break label232;
      paramInt1 = 2;
      break label278;
    }
    label384:
    label414:
    paramContext.a(new o(parambtd.tJO, paramj, k), (CharSequence)localObject2, j);
    label769:
    label774:
    return paramContext;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.widget.c
 * JD-Core Version:    0.7.0.1
 */