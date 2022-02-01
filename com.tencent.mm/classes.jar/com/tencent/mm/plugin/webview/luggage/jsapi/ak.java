package com.tencent.mm.plugin.webview.luggage.jsapi;

import android.content.Context;
import android.content.Intent;
import com.tencent.luggage.d.b.a;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.br.d;
import com.tencent.mm.contact.c;
import com.tencent.mm.g.c.aw;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.messenger.foundation.a.l;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.storage.an;
import org.json.JSONException;
import org.json.JSONObject;

public class ak
  extends bq
{
  public final void a(Context paramContext, String paramString, bq.a parama)
  {
    AppMethodBeat.i(78586);
    try
    {
      paramString = new JSONObject(paramString);
      paramString = paramString.optString("username");
      if (bu.isNullOrNil(paramString))
      {
        parama.f("param_err", null);
        AppMethodBeat.o(78586);
        return;
      }
    }
    catch (JSONException paramContext)
    {
      ae.e("MicroMsg.JsApiOpenBizChat", "parase json fail");
      parama.f("fail", null);
      AppMethodBeat.o(78586);
      return;
    }
    Object localObject = ((l)g.ab(l.class)).azF().BH(paramString);
    if ((localObject == null) || (!((an)localObject).fug()))
    {
      parama.f("not biz username", null);
      AppMethodBeat.o(78586);
      return;
    }
    if (!c.lO(((aw)localObject).field_type))
    {
      parama.f("open_biz_chat", null);
      AppMethodBeat.o(78586);
      return;
    }
    localObject = new Intent();
    ((Intent)localObject).putExtra("Chat_User", paramString);
    ((Intent)localObject).putExtra("finish_direct", true);
    d.f(paramContext, ".ui.chatting.ChattingUI", (Intent)localObject);
    parama.f(null, null);
    AppMethodBeat.o(78586);
  }
  
  public final void b(b.a parama) {}
  
  public final int ced()
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