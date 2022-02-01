package com.tencent.mm.plugin.webview.luggage.jsapi;

import android.content.Context;
import android.content.Intent;
import com.tencent.luggage.d.a.a;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.br.d;
import com.tencent.mm.g.c.av;
import com.tencent.mm.kernel.g;
import com.tencent.mm.n.b;
import com.tencent.mm.plugin.messenger.foundation.a.k;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.bs;
import com.tencent.mm.storage.ai;
import com.tencent.mm.storage.bj;
import org.json.JSONException;
import org.json.JSONObject;

public class aj
  extends bn
{
  public final void a(Context paramContext, String paramString, bn.a parama)
  {
    AppMethodBeat.i(78586);
    try
    {
      paramString = new JSONObject(paramString);
      paramString = paramString.optString("username");
      if (bs.isNullOrNil(paramString))
      {
        parama.f("param_err", null);
        AppMethodBeat.o(78586);
        return;
      }
    }
    catch (JSONException paramContext)
    {
      ac.e("MicroMsg.JsApiOpenBizChat", "parase json fail");
      parama.f("fail", null);
      AppMethodBeat.o(78586);
      return;
    }
    Object localObject = ((k)g.ab(k.class)).awB().aNt(paramString);
    if ((localObject == null) || (!((ai)localObject).fad()))
    {
      parama.f("not biz username", null);
      AppMethodBeat.o(78586);
      return;
    }
    if (!b.ln(((av)localObject).field_type))
    {
      parama.f("open_biz_chat", null);
      AppMethodBeat.o(78586);
      return;
    }
    localObject = new Intent();
    ((Intent)localObject).putExtra("Chat_User", paramString);
    ((Intent)localObject).putExtra("finish_direct", true);
    d.e(paramContext, ".ui.chatting.ChattingUI", (Intent)localObject);
    parama.f(null, null);
    AppMethodBeat.o(78586);
  }
  
  public final void b(a.a parama) {}
  
  public final int bYk()
  {
    return 1;
  }
  
  public final String name()
  {
    return "openBizChat";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.luggage.jsapi.aj
 * JD-Core Version:    0.7.0.1
 */