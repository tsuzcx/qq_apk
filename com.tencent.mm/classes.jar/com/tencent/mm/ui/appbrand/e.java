package com.tencent.mm.ui.appbrand;

import android.content.Context;
import android.text.TextUtils;
import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R.l;
import com.tencent.mm.an.i;
import com.tencent.mm.an.t;
import com.tencent.mm.f.a.aad;
import com.tencent.mm.f.a.aad.a;
import com.tencent.mm.kernel.h;
import com.tencent.mm.model.bh;
import com.tencent.mm.plugin.appbrand.config.WxaAttributes;
import com.tencent.mm.plugin.appbrand.config.WxaAttributes.a;
import com.tencent.mm.protocal.protobuf.epv;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.event.IEvent;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.ui.base.w;
import java.util.LinkedList;

public final class e
{
  public static String afi(String paramString)
  {
    AppMethodBeat.i(33813);
    if (TextUtils.isEmpty(paramString))
    {
      AppMethodBeat.o(33813);
      return null;
    }
    paramString = ((com.tencent.mm.plugin.appbrand.service.q)h.ae(com.tencent.mm.plugin.appbrand.service.q.class)).aeW(paramString);
    if ((paramString != null) && (paramString.bLF() != null))
    {
      paramString = paramString.field_appId;
      AppMethodBeat.o(33813);
      return paramString;
    }
    Log.e("MicroMsg.AppBrandServiceHelper", "attr is null or getAppInfo return null");
    AppMethodBeat.o(33813);
    return null;
  }
  
  public static String byw(String paramString)
  {
    AppMethodBeat.i(33812);
    if (TextUtils.isEmpty(paramString))
    {
      AppMethodBeat.o(33812);
      return null;
    }
    paramString = ((com.tencent.mm.plugin.appbrand.service.q)h.ae(com.tencent.mm.plugin.appbrand.service.q.class)).aeW(paramString);
    if ((paramString != null) && (paramString.bLF() != null))
    {
      paramString = paramString.bLF().obc;
      AppMethodBeat.o(33812);
      return paramString;
    }
    Log.e("MicroMsg.AppBrandServiceHelper", "attr is null or getAppInfo return null");
    AppMethodBeat.o(33812);
    return null;
  }
  
  public static String byx(String paramString)
  {
    AppMethodBeat.i(33814);
    if (TextUtils.isEmpty(paramString))
    {
      AppMethodBeat.o(33814);
      return null;
    }
    paramString = ((com.tencent.mm.plugin.appbrand.service.q)h.ae(com.tencent.mm.plugin.appbrand.service.q.class)).aeW(paramString);
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
    Object localObject1 = new aad();
    ((aad)localObject1).fZt.fuO = paramString;
    Object localObject2 = ((aad)localObject1).fZt;
    if (paramBoolean)
    {
      i = 2;
      ((aad.a)localObject2).action = i;
      ((aad)localObject1).fZt.option = 2;
      EventCenter.instance.publish((IEvent)localObject1);
      localObject1 = new LinkedList();
      localObject2 = new epv();
      ((epv)localObject2).Usr = paramString;
      if (!paramBoolean) {
        break label163;
      }
    }
    label163:
    for (int i = j;; i = 0)
    {
      ((epv)localObject2).Usq = i;
      ((epv)localObject2).rWu = 3;
      ((LinkedList)localObject1).add(localObject2);
      bh.aGY().a(1176, new i()
      {
        public final void onSceneEnd(int paramAnonymousInt1, int paramAnonymousInt2, String paramAnonymousString, com.tencent.mm.an.q paramAnonymousq)
        {
          int i = 1;
          AppMethodBeat.i(33809);
          bh.aGY().b(1176, this);
          Log.d("MicroMsg.AppBrandServiceHelper", "onSceneEnd(errType : %d, errCode : %d, errMsg : %s, toBan : %s)", new Object[] { Integer.valueOf(paramAnonymousInt1), Integer.valueOf(paramAnonymousInt2), paramAnonymousString, Boolean.TRUE });
          if ((paramAnonymousInt1 != 0) || (paramAnonymousInt2 != 0))
          {
            w.makeText(this.val$context, R.l.eOm, 0).show();
            paramAnonymousString = new aad();
            paramAnonymousString.fZt.fuO = paramString;
            paramAnonymousq = paramAnonymousString.fZt;
            paramAnonymousInt1 = i;
            if (!paramBoolean) {
              paramAnonymousInt1 = 2;
            }
            paramAnonymousq.action = paramAnonymousInt1;
            paramAnonymousString.fZt.option = 2;
            EventCenter.instance.publish(paramAnonymousString);
            AppMethodBeat.o(33809);
            return;
          }
          AppMethodBeat.o(33809);
        }
      });
      paramContext = new com.tencent.mm.modelappbrand.q((LinkedList)localObject1);
      bh.aGY().a(paramContext, 0);
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