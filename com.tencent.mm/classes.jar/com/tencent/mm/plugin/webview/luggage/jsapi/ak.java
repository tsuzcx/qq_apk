package com.tencent.mm.plugin.webview.luggage.jsapi;

import android.content.Context;
import android.content.Intent;
import com.tencent.luggage.d.b.a;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.by.c;
import com.tencent.mm.contact.d;
import com.tencent.mm.f.c.ax;
import com.tencent.mm.kernel.h;
import com.tencent.mm.plugin.messenger.foundation.a.n;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.as;
import com.tencent.mm.storage.bv;
import org.json.JSONException;
import org.json.JSONObject;

public class ak
  extends br
{
  public final void a(Context paramContext, String paramString, br.a parama)
  {
    AppMethodBeat.i(78586);
    try
    {
      paramString = new JSONObject(paramString);
      paramString = paramString.optString("username");
      if (Util.isNullOrNil(paramString))
      {
        parama.i("param_err", null);
        AppMethodBeat.o(78586);
        return;
      }
    }
    catch (JSONException paramContext)
    {
      Log.e("MicroMsg.JsApiOpenBizChat", "parase json fail");
      parama.i("fail", null);
      AppMethodBeat.o(78586);
      return;
    }
    Object localObject = ((n)h.ae(n.class)).bbL().RG(paramString);
    if ((localObject == null) || (!((as)localObject).hxX()))
    {
      parama.i("not biz username", null);
      AppMethodBeat.o(78586);
      return;
    }
    if (!d.rk(((ax)localObject).field_type))
    {
      parama.i("open_biz_chat", null);
      AppMethodBeat.o(78586);
      return;
    }
    localObject = new Intent();
    ((Intent)localObject).putExtra("Chat_User", paramString);
    ((Intent)localObject).putExtra("finish_direct", true);
    c.f(paramContext, ".ui.chatting.ChattingUI", (Intent)localObject);
    parama.i(null, null);
    AppMethodBeat.o(78586);
  }
  
  public final void b(b.a parama) {}
  
  public final int cDj()
  {
    return 1;
  }
  
  public final String name()
  {
    return "openBizChat";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.luggage.jsapi.ak
 * JD-Core Version:    0.7.0.1
 */