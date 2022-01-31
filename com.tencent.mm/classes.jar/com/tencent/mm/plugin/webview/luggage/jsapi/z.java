package com.tencent.mm.plugin.webview.luggage.jsapi;

import android.content.Context;
import android.content.Intent;
import com.tencent.luggage.d.a.a;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.webview.a.a;
import com.tencent.mm.pluginsdk.n;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.ui.MMActivity;
import org.json.JSONException;
import org.json.JSONObject;

public class z
  extends bi
{
  public final void a(Context paramContext, String paramString, bh.a parama)
  {
    AppMethodBeat.i(6321);
    try
    {
      Object localObject = new JSONObject(paramString);
      paramString = ((JSONObject)localObject).optString("tousername");
      String str1 = ((JSONObject)localObject).optString("extmsg");
      ab.d("MicroMsg.JsApiJumpToBizProfile", "doJumpToBizProfile %s, %s", new Object[] { paramString, str1 });
      String str2 = ((JSONObject)localObject).optString("currentUrl");
      localObject = new Intent();
      ((Intent)localObject).putExtra("toUserName", paramString);
      ((Intent)localObject).putExtra("extInfo", str1);
      ((Intent)localObject).putExtra("fromURL", str2);
      ((Intent)localObject).putExtra("source", 2);
      paramString = new z.1(this, parama);
      a.gmO.a((Intent)localObject, hashCode() & 0xFFFF, paramString, (MMActivity)paramContext);
      AppMethodBeat.o(6321);
      return;
    }
    catch (JSONException paramContext)
    {
      ab.e("MicroMsg.JsApiJumpToBizProfile", "parase json fail");
      parama.c("fail", null);
      AppMethodBeat.o(6321);
    }
  }
  
  public final void b(a.a parama) {}
  
  public final int bjL()
  {
    return 2;
  }
  
  public final String name()
  {
    return "jumpToBizProfile";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.luggage.jsapi.z
 * JD-Core Version:    0.7.0.1
 */