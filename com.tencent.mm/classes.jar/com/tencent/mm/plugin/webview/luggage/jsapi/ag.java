package com.tencent.mm.plugin.webview.luggage.jsapi;

import android.content.Context;
import android.content.Intent;
import com.tencent.luggage.d.a.a;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bq.d;
import com.tencent.mm.g.c.aq;
import com.tencent.mm.kernel.g;
import com.tencent.mm.n.a;
import com.tencent.mm.plugin.messenger.foundation.a.j;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.storage.ad;
import com.tencent.mm.storage.bd;
import org.json.JSONException;
import org.json.JSONObject;

public class ag
  extends bh
{
  public final void a(Context paramContext, String paramString, bh.a parama)
  {
    AppMethodBeat.i(6338);
    try
    {
      paramString = new JSONObject(paramString);
      paramString = paramString.optString("username");
      if (bo.isNullOrNil(paramString))
      {
        parama.c("param_err", null);
        AppMethodBeat.o(6338);
        return;
      }
    }
    catch (JSONException paramContext)
    {
      ab.e("MicroMsg.JsApiOpenBizChat", "parase json fail");
      parama.c("fail", null);
      AppMethodBeat.o(6338);
      return;
    }
    Object localObject = ((j)g.E(j.class)).YA().arw(paramString);
    if ((localObject == null) || (!((ad)localObject).dwz()))
    {
      parama.c("not biz username", null);
      AppMethodBeat.o(6338);
      return;
    }
    if (!a.je(((aq)localObject).field_type))
    {
      parama.c("open_biz_chat", null);
      AppMethodBeat.o(6338);
      return;
    }
    localObject = new Intent();
    ((Intent)localObject).putExtra("Chat_User", paramString);
    ((Intent)localObject).putExtra("finish_direct", true);
    d.f(paramContext, ".ui.chatting.ChattingUI", (Intent)localObject);
    parama.c(null, null);
    AppMethodBeat.o(6338);
  }
  
  public final void b(a.a parama) {}
  
  public final int bjL()
  {
    return 1;
  }
  
  public final String name()
  {
    return "openBizChat";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.luggage.jsapi.ag
 * JD-Core Version:    0.7.0.1
 */