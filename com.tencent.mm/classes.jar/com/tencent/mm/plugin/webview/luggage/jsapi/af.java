package com.tencent.mm.plugin.webview.luggage.jsapi;

import android.content.Context;
import android.content.Intent;
import com.tencent.luggage.d.b.a;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.webview.a.a;
import com.tencent.mm.pluginsdk.m;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.MMActivity.a;
import org.json.JSONException;
import org.json.JSONObject;

public class af
  extends bw
{
  public final void a(Context paramContext, String paramString, final bv.a parama)
  {
    AppMethodBeat.i(78569);
    try
    {
      Object localObject = new JSONObject(paramString);
      paramString = ((JSONObject)localObject).optString("tousername");
      String str1 = ((JSONObject)localObject).optString("extmsg");
      Log.d("MicroMsg.JsApiJumpToBizProfile", "doJumpToBizProfile %s, %s", new Object[] { paramString, str1 });
      String str2 = ((JSONObject)localObject).optString("currentUrl");
      localObject = new Intent();
      ((Intent)localObject).putExtra("toUserName", paramString);
      ((Intent)localObject).putExtra("extInfo", str1);
      ((Intent)localObject).putExtra("fromURL", str2);
      ((Intent)localObject).putExtra("source", 2);
      paramString = new MMActivity.a()
      {
        public final void mmOnActivityResult(int paramAnonymousInt1, int paramAnonymousInt2, Intent paramAnonymousIntent)
        {
          AppMethodBeat.i(78568);
          if (paramAnonymousInt1 == (af.this.hashCode() & 0xFFFF)) {
            Log.i("MicroMsg.JsApiJumpToBizProfile", "request jumpToBizProfile, resultCode = ".concat(String.valueOf(paramAnonymousInt2)));
          }
          switch (paramAnonymousInt2)
          {
          case 1: 
          default: 
            parama.j("fail", null);
            Log.e("MicroMsg.JsApiJumpToBizProfile", "unknown resultCode");
            AppMethodBeat.o(78568);
            return;
          case -1: 
            parama.j(null, null);
            AppMethodBeat.o(78568);
            return;
          case 0: 
            parama.j("cancel", null);
            AppMethodBeat.o(78568);
            return;
          }
          parama.j("check_fail", null);
          AppMethodBeat.o(78568);
        }
      };
      a.pFn.a((Intent)localObject, hashCode() & 0xFFFF, paramString, (MMActivity)paramContext);
      AppMethodBeat.o(78569);
      return;
    }
    catch (JSONException paramContext)
    {
      Log.e("MicroMsg.JsApiJumpToBizProfile", "parase json fail");
      parama.j("fail", null);
      AppMethodBeat.o(78569);
    }
  }
  
  public final void b(b.a parama) {}
  
  public final int dgI()
  {
    return 2;
  }
  
  public final String name()
  {
    return "jumpToBizProfile";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.luggage.jsapi.af
 * JD-Core Version:    0.7.0.1
 */