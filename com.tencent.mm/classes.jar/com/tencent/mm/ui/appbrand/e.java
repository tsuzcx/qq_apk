package com.tencent.mm.ui.appbrand;

import android.content.Context;
import android.text.TextUtils;
import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.f;
import com.tencent.mm.g.a.xq;
import com.tencent.mm.g.a.xq.a;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.ba;
import com.tencent.mm.plugin.appbrand.config.WxaAttributes;
import com.tencent.mm.plugin.appbrand.config.WxaAttributes.a;
import com.tencent.mm.protocal.protobuf.dli;
import com.tencent.mm.sdk.b.a;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.ui.base.t;
import java.util.LinkedList;

public final class e
{
  public static String NE(String paramString)
  {
    AppMethodBeat.i(33813);
    if (TextUtils.isEmpty(paramString))
    {
      AppMethodBeat.o(33813);
      return null;
    }
    paramString = ((com.tencent.mm.plugin.appbrand.service.n)g.ab(com.tencent.mm.plugin.appbrand.service.n.class)).Nt(paramString);
    if ((paramString != null) && (paramString.bel() != null))
    {
      paramString = paramString.field_appId;
      AppMethodBeat.o(33813);
      return paramString;
    }
    ad.e("MicroMsg.AppBrandServiceHelper", "attr is null or getAppInfo return null");
    AppMethodBeat.o(33813);
    return null;
  }
  
  public static String aVw(String paramString)
  {
    AppMethodBeat.i(33812);
    if (TextUtils.isEmpty(paramString))
    {
      AppMethodBeat.o(33812);
      return null;
    }
    paramString = ((com.tencent.mm.plugin.appbrand.service.n)g.ab(com.tencent.mm.plugin.appbrand.service.n.class)).Nt(paramString);
    if ((paramString != null) && (paramString.bel() != null))
    {
      paramString = paramString.bel().jZE;
      AppMethodBeat.o(33812);
      return paramString;
    }
    ad.e("MicroMsg.AppBrandServiceHelper", "attr is null or getAppInfo return null");
    AppMethodBeat.o(33812);
    return null;
  }
  
  public static String aVx(String paramString)
  {
    AppMethodBeat.i(33814);
    if (TextUtils.isEmpty(paramString))
    {
      AppMethodBeat.o(33814);
      return null;
    }
    paramString = ((com.tencent.mm.plugin.appbrand.service.n)g.ab(com.tencent.mm.plugin.appbrand.service.n.class)).Nt(paramString);
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
  
  public static void k(Context paramContext, final String paramString, final boolean paramBoolean)
  {
    int j = 1;
    AppMethodBeat.i(33811);
    Object localObject1 = new xq();
    ((xq)localObject1).dLX.djX = paramString;
    Object localObject2 = ((xq)localObject1).dLX;
    if (paramBoolean)
    {
      i = 2;
      ((xq.a)localObject2).action = i;
      ((xq)localObject1).dLX.option = 2;
      a.IbL.l((b)localObject1);
      localObject1 = new LinkedList();
      localObject2 = new dli();
      ((dli)localObject2).HzR = paramString;
      if (!paramBoolean) {
        break label163;
      }
    }
    label163:
    for (int i = j;; i = 0)
    {
      ((dli)localObject2).HzQ = i;
      ((dli)localObject2).nEf = 3;
      ((LinkedList)localObject1).add(localObject2);
      ba.aiU().a(1176, new f()
      {
        public final void onSceneEnd(int paramAnonymousInt1, int paramAnonymousInt2, String paramAnonymousString, com.tencent.mm.al.n paramAnonymousn)
        {
          int i = 1;
          AppMethodBeat.i(33809);
          ba.aiU().b(1176, this);
          ad.d("MicroMsg.AppBrandServiceHelper", "onSceneEnd(errType : %d, errCode : %d, errMsg : %s, toBan : %s)", new Object[] { Integer.valueOf(paramAnonymousInt1), Integer.valueOf(paramAnonymousInt2), paramAnonymousString, Boolean.TRUE });
          if ((paramAnonymousInt1 != 0) || (paramAnonymousInt2 != 0))
          {
            t.makeText(this.val$context, 2131761756, 0).show();
            paramAnonymousString = new xq();
            paramAnonymousString.dLX.djX = paramString;
            paramAnonymousn = paramAnonymousString.dLX;
            paramAnonymousInt1 = i;
            if (!paramBoolean) {
              paramAnonymousInt1 = 2;
            }
            paramAnonymousn.action = paramAnonymousInt1;
            paramAnonymousString.dLX.option = 2;
            a.IbL.l(paramAnonymousString);
            AppMethodBeat.o(33809);
            return;
          }
          AppMethodBeat.o(33809);
        }
      });
      paramContext = new com.tencent.mm.modelappbrand.q((LinkedList)localObject1);
      ba.aiU().a(paramContext, 0);
      AppMethodBeat.o(33811);
      return;
      i = 1;
      break;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.ui.appbrand.e
 * JD-Core Version:    0.7.0.1
 */