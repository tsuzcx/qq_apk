package com.tencent.mm.plugin.webview.luggage.jsapi;

import android.content.Context;
import android.content.Intent;
import com.tencent.luggage.d.b.a;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.autogen.b.az;
import com.tencent.mm.br.c;
import com.tencent.mm.contact.d;
import com.tencent.mm.kernel.h;
import com.tencent.mm.plugin.messenger.foundation.a.n;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.au;
import com.tencent.mm.storage.bx;
import org.json.JSONException;
import org.json.JSONObject;

public class am
  extends bv
{
  public final void a(Context paramContext, String paramString, bv.a parama)
  {
    AppMethodBeat.i(78586);
    try
    {
      paramString = new JSONObject(paramString);
      paramString = paramString.optString("username");
      if (Util.isNullOrNil(paramString))
      {
        parama.j("param_err", null);
        AppMethodBeat.o(78586);
        return;
      }
    }
    catch (JSONException paramContext)
    {
      Log.e("MicroMsg.JsApiOpenBizChat", "parase json fail");
      parama.j("fail", null);
      AppMethodBeat.o(78586);
      return;
    }
    Object localObject = ((n)h.ax(n.class)).bzA().JE(paramString);
    if ((localObject == null) || (!((au)localObject).iZC()))
    {
      parama.j("not biz username", null);
      AppMethodBeat.o(78586);
      return;
    }
    if (!d.rs(((az)localObject).field_type))
    {
      parama.j("open_biz_chat", null);
      AppMethodBeat.o(78586);
      return;
    }
    localObject = new Intent();
    ((Intent)localObject).putExtra("Chat_User", paramString);
    ((Intent)localObject).putExtra("finish_direct", true);
    c.g(paramContext, ".ui.chatting.ChattingUI", (Intent)localObject);
    parama.j(null, null);
    AppMethodBeat.o(78586);
  }
  
  public final void b(b.a parama) {}
  
  public final int dgI()
  {
    return 1;
  }
  
  public final String name()
  {
    return "openBizChat";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.luggage.jsapi.am
 * JD-Core Version:    0.7.0.1
 */