package com.tencent.mm.plugin.webview.luggage.jsapi;

import android.content.Context;
import android.content.Intent;
import com.tencent.luggage.d.b.a;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.webview.a.a;
import com.tencent.mm.pluginsdk.m;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.MMActivity.a;
import org.json.JSONException;
import org.json.JSONObject;

public class ad
  extends br
{
  public final void a(Context paramContext, String paramString, final bq.a parama)
  {
    AppMethodBeat.i(78569);
    try
    {
      Object localObject = new JSONObject(paramString);
      paramString = ((JSONObject)localObject).optString("tousername");
      String str1 = ((JSONObject)localObject).optString("extmsg");
      com.tencent.mm.sdk.platformtools.ad.d("MicroMsg.JsApiJumpToBizProfile", "doJumpToBizProfile %s, %s", new Object[] { paramString, str1 });
      String str2 = ((JSONObject)localObject).optString("currentUrl");
      localObject = new Intent();
      ((Intent)localObject).putExtra("toUserName", paramString);
      ((Intent)localObject).putExtra("extInfo", str1);
      ((Intent)localObject).putExtra("fromURL", str2);
      ((Intent)localObject).putExtra("source", 2);
      paramString = new MMActivity.a()
      {
        public final void c(int paramAnonymousInt1, int paramAnonymousInt2, Intent paramAnonymousIntent)
        {
          AppMethodBeat.i(78568);
          if (paramAnonymousInt1 == (ad.this.hashCode() & 0xFFFF)) {
            com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.JsApiJumpToBizProfile", "request jumpToBizProfile, resultCode = ".concat(String.valueOf(paramAnonymousInt2)));
          }
          switch (paramAnonymousInt2)
          {
          case 1: 
          default: 
            parama.f("fail", null);
            com.tencent.mm.sdk.platformtools.ad.e("MicroMsg.JsApiJumpToBizProfile", "unknown resultCode");
            AppMethodBeat.o(78568);
            return;
          case -1: 
            parama.f(null, null);
            AppMethodBeat.o(78568);
            return;
          case 0: 
            parama.f("cancel", null);
            AppMethodBeat.o(78568);
            return;
          }
          parama.f("check_fail", null);
          AppMethodBeat.o(78568);
        }
      };
      a.iRG.a((Intent)localObject, hashCode() & 0xFFFF, paramString, (MMActivity)paramContext);
      AppMethodBeat.o(78569);
      return;
    }
    catch (JSONException paramContext)
    {
      com.tencent.mm.sdk.platformtools.ad.e("MicroMsg.JsApiJumpToBizProfile", "parase json fail");
      parama.f("fail", null);
      AppMethodBeat.o(78569);
    }
  }
  
  public final void b(b.a parama) {}
  
  public final int ccO()
  {
    return 2;
  }
  
  public final String name()
  {
    return "jumpToBizProfile";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.luggage.jsapi.ad
 * JD-Core Version:    0.7.0.1
 */