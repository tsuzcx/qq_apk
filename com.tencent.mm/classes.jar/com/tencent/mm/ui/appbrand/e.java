package com.tencent.mm.ui.appbrand;

import android.content.Context;
import android.text.TextUtils;
import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R.l;
import com.tencent.mm.am.p;
import com.tencent.mm.autogen.a.abz;
import com.tencent.mm.autogen.a.abz.a;
import com.tencent.mm.model.bh;
import com.tencent.mm.modelappbrand.q;
import com.tencent.mm.plugin.appbrand.config.WxaAttributes;
import com.tencent.mm.plugin.appbrand.config.WxaAttributes.a;
import com.tencent.mm.protocal.protobuf.fku;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.ui.base.aa;
import java.util.LinkedList;

public final class e
{
  public static String XJ(String paramString)
  {
    AppMethodBeat.i(33813);
    if (TextUtils.isEmpty(paramString))
    {
      AppMethodBeat.o(33813);
      return null;
    }
    paramString = ((com.tencent.mm.plugin.appbrand.service.s)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.appbrand.service.s.class)).Xy(paramString);
    if ((paramString != null) && (paramString.cld() != null))
    {
      paramString = paramString.field_appId;
      AppMethodBeat.o(33813);
      return paramString;
    }
    Log.e("MicroMsg.AppBrandServiceHelper", "attr is null or getAppInfo return null");
    AppMethodBeat.o(33813);
    return null;
  }
  
  public static String bzU(String paramString)
  {
    AppMethodBeat.i(33812);
    if (TextUtils.isEmpty(paramString))
    {
      AppMethodBeat.o(33812);
      return null;
    }
    paramString = ((com.tencent.mm.plugin.appbrand.service.s)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.appbrand.service.s.class)).Xy(paramString);
    if ((paramString != null) && (paramString.cld() != null))
    {
      paramString = paramString.cld().rbO;
      AppMethodBeat.o(33812);
      return paramString;
    }
    Log.e("MicroMsg.AppBrandServiceHelper", "attr is null or getAppInfo return null");
    AppMethodBeat.o(33812);
    return null;
  }
  
  public static String bzV(String paramString)
  {
    AppMethodBeat.i(33814);
    if (TextUtils.isEmpty(paramString))
    {
      AppMethodBeat.o(33814);
      return null;
    }
    paramString = ((com.tencent.mm.plugin.appbrand.service.s)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.appbrand.service.s.class)).Xy(paramString);
    if (paramString != null)
    {
      paramString = paramString.field_nickname;
      AppMethodBeat.o(33814);
      return paramString;
    }
    Log.e("MicroMsg.AppBrandServiceHelper", "attr is null or getAppInfo return null");
    AppMethodBeat.o(33814);
    return null;
  }
  
  public static void l(Context paramContext, final String paramString, final boolean paramBoolean)
  {
    int j = 1;
    AppMethodBeat.i(33811);
    Object localObject1 = new abz();
    ((abz)localObject1).ify.hzi = paramString;
    Object localObject2 = ((abz)localObject1).ify;
    if (paramBoolean)
    {
      i = 2;
      ((abz.a)localObject2).action = i;
      ((abz)localObject1).ify.option = 2;
      ((abz)localObject1).publish();
      localObject1 = new LinkedList();
      localObject2 = new fku();
      ((fku)localObject2).abLu = paramString;
      if (!paramBoolean) {
        break label160;
      }
    }
    label160:
    for (int i = j;; i = 0)
    {
      ((fku)localObject2).abLt = i;
      ((fku)localObject2).vhJ = 3;
      ((LinkedList)localObject1).add(localObject2);
      bh.aZW().a(1176, new com.tencent.mm.am.h()
      {
        public final void onSceneEnd(int paramAnonymousInt1, int paramAnonymousInt2, String paramAnonymousString, p paramAnonymousp)
        {
          int i = 1;
          AppMethodBeat.i(33809);
          bh.aZW().b(1176, this);
          Log.d("MicroMsg.AppBrandServiceHelper", "onSceneEnd(errType : %d, errCode : %d, errMsg : %s, toBan : %s)", new Object[] { Integer.valueOf(paramAnonymousInt1), Integer.valueOf(paramAnonymousInt2), paramAnonymousString, Boolean.TRUE });
          if ((paramAnonymousInt1 != 0) || (paramAnonymousInt2 != 0))
          {
            aa.makeText(e.this, R.l.gQz, 0).show();
            paramAnonymousString = new abz();
            paramAnonymousString.ify.hzi = paramString;
            paramAnonymousp = paramAnonymousString.ify;
            paramAnonymousInt1 = i;
            if (!paramBoolean) {
              paramAnonymousInt1 = 2;
            }
            paramAnonymousp.action = paramAnonymousInt1;
            paramAnonymousString.ify.option = 2;
            paramAnonymousString.publish();
            AppMethodBeat.o(33809);
            return;
          }
          AppMethodBeat.o(33809);
        }
      });
      paramContext = new q((LinkedList)localObject1);
      bh.aZW().a(paramContext, 0);
      AppMethodBeat.o(33811);
      return;
      i = 1;
      break;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.ui.appbrand.e
 * JD-Core Version:    0.7.0.1
 */