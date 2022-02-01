package com.tencent.mm.ui.appbrand;

import android.content.Context;
import android.text.TextUtils;
import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.n;
import com.tencent.mm.g.a.wm;
import com.tencent.mm.g.a.wm.a;
import com.tencent.mm.model.az;
import com.tencent.mm.plugin.appbrand.config.WxaAttributes;
import com.tencent.mm.plugin.appbrand.config.WxaAttributes.a;
import com.tencent.mm.plugin.appbrand.service.m;
import com.tencent.mm.protocal.protobuf.daj;
import com.tencent.mm.sdk.b.a;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.ui.base.t;
import java.util.LinkedList;

public final class e
{
  public static String Gh(String paramString)
  {
    AppMethodBeat.i(33813);
    if (TextUtils.isEmpty(paramString))
    {
      AppMethodBeat.o(33813);
      return null;
    }
    paramString = ((m)com.tencent.mm.kernel.g.ab(m.class)).FW(paramString);
    if ((paramString != null) && (paramString.aTN() != null))
    {
      paramString = paramString.field_appId;
      AppMethodBeat.o(33813);
      return paramString;
    }
    ad.e("MicroMsg.AppBrandServiceHelper", "attr is null or getAppInfo return null");
    AppMethodBeat.o(33813);
    return null;
  }
  
  public static String aKe(String paramString)
  {
    AppMethodBeat.i(33812);
    if (TextUtils.isEmpty(paramString))
    {
      AppMethodBeat.o(33812);
      return null;
    }
    paramString = ((m)com.tencent.mm.kernel.g.ab(m.class)).FW(paramString);
    if ((paramString != null) && (paramString.aTN() != null))
    {
      paramString = paramString.aTN().jfk;
      AppMethodBeat.o(33812);
      return paramString;
    }
    ad.e("MicroMsg.AppBrandServiceHelper", "attr is null or getAppInfo return null");
    AppMethodBeat.o(33812);
    return null;
  }
  
  public static String aKf(String paramString)
  {
    AppMethodBeat.i(33814);
    if (TextUtils.isEmpty(paramString))
    {
      AppMethodBeat.o(33814);
      return null;
    }
    paramString = ((m)com.tencent.mm.kernel.g.ab(m.class)).FW(paramString);
    if (paramString != null)
    {
      paramString = paramString.field_nickname;
      AppMethodBeat.o(33814);
      return paramString;
    }
    ad.e("MicroMsg.AppBrandServiceHelper", "attr is null or getAppInfo return null");
    AppMethodBeat.o(33814);
    return null;
  }
  
  public static void l(Context paramContext, final String paramString, final boolean paramBoolean)
  {
    int j = 1;
    AppMethodBeat.i(33811);
    Object localObject1 = new wm();
    ((wm)localObject1).dBX.dbj = paramString;
    Object localObject2 = ((wm)localObject1).dBX;
    if (paramBoolean)
    {
      i = 2;
      ((wm.a)localObject2).action = i;
      ((wm)localObject1).dBX.option = 2;
      a.ESL.l((b)localObject1);
      localObject1 = new LinkedList();
      localObject2 = new daj();
      ((daj)localObject2).Ese = paramString;
      if (!paramBoolean) {
        break label163;
      }
    }
    label163:
    for (int i = j;; i = 0)
    {
      ((daj)localObject2).Esd = i;
      ((daj)localObject2).mBH = 3;
      ((LinkedList)localObject1).add(localObject2);
      az.aeS().a(1176, new com.tencent.mm.al.g()
      {
        public final void onSceneEnd(int paramAnonymousInt1, int paramAnonymousInt2, String paramAnonymousString, n paramAnonymousn)
        {
          int i = 1;
          AppMethodBeat.i(33809);
          az.aeS().b(1176, this);
          ad.d("MicroMsg.AppBrandServiceHelper", "onSceneEnd(errType : %d, errCode : %d, errMsg : %s, toBan : %s)", new Object[] { Integer.valueOf(paramAnonymousInt1), Integer.valueOf(paramAnonymousInt2), paramAnonymousString, Boolean.TRUE });
          if ((paramAnonymousInt1 != 0) || (paramAnonymousInt2 != 0))
          {
            t.makeText(this.val$context, 2131761756, 0).show();
            paramAnonymousString = new wm();
            paramAnonymousString.dBX.dbj = paramString;
            paramAnonymousn = paramAnonymousString.dBX;
            paramAnonymousInt1 = i;
            if (!paramBoolean) {
              paramAnonymousInt1 = 2;
            }
            paramAnonymousn.action = paramAnonymousInt1;
            paramAnonymousString.dBX.option = 2;
            a.ESL.l(paramAnonymousString);
            AppMethodBeat.o(33809);
            return;
          }
          AppMethodBeat.o(33809);
        }
      });
      paramContext = new com.tencent.mm.modelappbrand.q((LinkedList)localObject1);
      az.aeS().a(paramContext, 0);
      AppMethodBeat.o(33811);
      return;
      i = 1;
      break;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.ui.appbrand.e
 * JD-Core Version:    0.7.0.1
 */