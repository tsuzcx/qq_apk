package com.tencent.mm.plugin.webview.luggage.jsapi;

import android.content.Context;
import android.content.Intent;
import com.tencent.luggage.d.a.a;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.qr;
import com.tencent.mm.g.c.aq;
import com.tencent.mm.ipcinvoker.l;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.ao.a;
import com.tencent.mm.model.ao.b;
import com.tencent.mm.plugin.messenger.foundation.a.j;
import com.tencent.mm.pluginsdk.n;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.storage.ad;
import com.tencent.mm.storage.bd;
import com.tencent.mm.ui.base.h;
import org.json.JSONException;
import org.json.JSONObject;

public class ap
  extends bi
{
  public final void a(Context paramContext, String paramString, bh.a parama)
  {
    AppMethodBeat.i(6353);
    Object localObject2;
    try
    {
      localObject3 = new JSONObject(paramString);
      localObject2 = ((JSONObject)localObject3).optString("username");
      if ((localObject2 == null) || (((String)localObject2).length() == 0))
      {
        ab.e("MicroMsg.JsApiProfile", "doProfile fail, username is null");
        parama.c("fail", null);
        AppMethodBeat.o(6353);
        return;
      }
    }
    catch (JSONException paramContext)
    {
      ab.e("MicroMsg.JsApiProfile", "parase json fail");
      parama.c("fail", null);
      AppMethodBeat.o(6353);
      return;
    }
    if (bo.isNullOrNil((String)localObject2))
    {
      l.q(new ap.1(this));
      parama.c("fail", null);
      AppMethodBeat.o(6353);
      return;
    }
    g.RJ();
    if (!com.tencent.mm.kernel.a.QT())
    {
      ab.e("MicroMsg.JsApiProfile", "doProfile, MMCore.hasCfgDefaultUin() is false");
      parama.c("fail", null);
      AppMethodBeat.o(6353);
      return;
    }
    Object localObject1 = ((j)g.E(j.class)).YA().arw((String)localObject2);
    if (localObject1 != null)
    {
      paramString = (String)localObject1;
      if ((int)((com.tencent.mm.n.a)localObject1).euF > 0) {}
    }
    else
    {
      paramString = ((j)g.E(j.class)).YA().ars((String)localObject2);
    }
    localObject1 = new Intent();
    Object localObject3 = ((JSONObject)localObject3).optString("profileReportInfo");
    if (!bo.isNullOrNil((String)localObject3)) {
      ((Intent)localObject1).putExtra("key_add_contact_report_info", (String)localObject3);
    }
    if ((paramString != null) && ((int)paramString.euF > 0))
    {
      ((Intent)localObject1).addFlags(268435456);
      ((Intent)localObject1).putExtra("Contact_User", paramString.field_username);
      if (paramString.dwz()) {
        ((Intent)localObject1).putExtra("Contact_Scene", 42);
      }
      if (com.tencent.mm.n.a.je(paramString.field_type))
      {
        localObject2 = new qr();
        ((qr)localObject2).cHh.intent = ((Intent)localObject1);
        ((qr)localObject2).cHh.username = paramString.field_username;
        com.tencent.mm.sdk.b.a.ymk.l((b)localObject2);
      }
      com.tencent.mm.plugin.webview.a.a.gmO.c((Intent)localObject1, paramContext);
      parama.c(null, null);
      AppMethodBeat.o(6353);
      return;
    }
    paramContext.getString(2131297087);
    paramString = h.b(paramContext, paramContext.getString(2131297112), true, new ap.2(this, (String)localObject2, parama));
    ao.a.flI.a((String)localObject2, "", new ap.3(this, paramContext, parama, paramString, (Intent)localObject1));
    AppMethodBeat.o(6353);
  }
  
  public final void b(a.a parama) {}
  
  public final int bjL()
  {
    return 2;
  }
  
  public final String name()
  {
    return "profile";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.luggage.jsapi.ap
 * JD-Core Version:    0.7.0.1
 */