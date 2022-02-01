package com.tencent.mm.ui.appbrand;

import android.content.Context;
import android.text.TextUtils;
import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.f;
import com.tencent.mm.ak.n;
import com.tencent.mm.g.a.xu;
import com.tencent.mm.g.a.xu.a;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.bc;
import com.tencent.mm.plugin.appbrand.config.WxaAttributes;
import com.tencent.mm.plugin.appbrand.config.WxaAttributes.a;
import com.tencent.mm.plugin.appbrand.service.o;
import com.tencent.mm.protocal.protobuf.dmf;
import com.tencent.mm.sdk.b.a;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.ui.base.t;
import java.util.LinkedList;

public final class e
{
  public static String Om(String paramString)
  {
    AppMethodBeat.i(33813);
    if (TextUtils.isEmpty(paramString))
    {
      AppMethodBeat.o(33813);
      return null;
    }
    paramString = ((o)g.ab(o.class)).Ob(paramString);
    if ((paramString != null) && (paramString.beT() != null))
    {
      paramString = paramString.field_appId;
      AppMethodBeat.o(33813);
      return paramString;
    }
    ae.e("MicroMsg.AppBrandServiceHelper", "attr is null or getAppInfo return null");
    AppMethodBeat.o(33813);
    return null;
  }
  
  public static String aWX(String paramString)
  {
    AppMethodBeat.i(33812);
    if (TextUtils.isEmpty(paramString))
    {
      AppMethodBeat.o(33812);
      return null;
    }
    paramString = ((o)g.ab(o.class)).Ob(paramString);
    if ((paramString != null) && (paramString.beT() != null))
    {
      paramString = paramString.beT().kcV;
      AppMethodBeat.o(33812);
      return paramString;
    }
    ae.e("MicroMsg.AppBrandServiceHelper", "attr is null or getAppInfo return null");
    AppMethodBeat.o(33812);
    return null;
  }
  
  public static String aWY(String paramString)
  {
    AppMethodBeat.i(33814);
    if (TextUtils.isEmpty(paramString))
    {
      AppMethodBeat.o(33814);
      return null;
    }
    paramString = ((o)g.ab(o.class)).Ob(paramString);
    if (paramString != null)
    {
      paramString = paramString.field_nickname;
      AppMethodBeat.o(33814);
      return paramString;
    }
    ae.e("MicroMsg.AppBrandServiceHelper", "attr is null or getAppInfo return null");
    AppMethodBeat.o(33814);
    return null;
  }
  
  public static void l(Context paramContext, final String paramString, final boolean paramBoolean)
  {
    int j = 1;
    AppMethodBeat.i(33811);
    Object localObject1 = new xu();
    ((xu)localObject1).dNm.dkZ = paramString;
    Object localObject2 = ((xu)localObject1).dNm;
    if (paramBoolean)
    {
      i = 2;
      ((xu.a)localObject2).action = i;
      ((xu)localObject1).dNm.option = 2;
      a.IvT.l((b)localObject1);
      localObject1 = new LinkedList();
      localObject2 = new dmf();
      ((dmf)localObject2).HTE = paramString;
      if (!paramBoolean) {
        break label163;
      }
    }
    label163:
    for (int i = j;; i = 0)
    {
      ((dmf)localObject2).HTD = i;
      ((dmf)localObject2).nJA = 3;
      ((LinkedList)localObject1).add(localObject2);
      bc.ajj().a(1176, new f()
      {
        public final void onSceneEnd(int paramAnonymousInt1, int paramAnonymousInt2, String paramAnonymousString, n paramAnonymousn)
        {
          int i = 1;
          AppMethodBeat.i(33809);
          bc.ajj().b(1176, this);
          ae.d("MicroMsg.AppBrandServiceHelper", "onSceneEnd(errType : %d, errCode : %d, errMsg : %s, toBan : %s)", new Object[] { Integer.valueOf(paramAnonymousInt1), Integer.valueOf(paramAnonymousInt2), paramAnonymousString, Boolean.TRUE });
          if ((paramAnonymousInt1 != 0) || (paramAnonymousInt2 != 0))
          {
            t.makeText(this.val$context, 2131761756, 0).show();
            paramAnonymousString = new xu();
            paramAnonymousString.dNm.dkZ = paramString;
            paramAnonymousn = paramAnonymousString.dNm;
            paramAnonymousInt1 = i;
            if (!paramBoolean) {
              paramAnonymousInt1 = 2;
            }
            paramAnonymousn.action = paramAnonymousInt1;
            paramAnonymousString.dNm.option = 2;
            a.IvT.l(paramAnonymousString);
            AppMethodBeat.o(33809);
            return;
          }
          AppMethodBeat.o(33809);
        }
      });
      paramContext = new com.tencent.mm.modelappbrand.q((LinkedList)localObject1);
      bc.ajj().a(paramContext, 0);
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