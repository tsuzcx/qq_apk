package com.tencent.mm.plugin.webview.luggage.jsapi;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import com.tencent.luggage.bridge.k;
import com.tencent.luggage.d.a;
import com.tencent.luggage.d.a.a;
import com.tencent.luggage.d.e;
import com.tencent.luggage.d.n;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.pluginsdk.wallet.WalletJsapiData;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.bs;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.MMActivity.a;
import com.tencent.mm.ui.e.m;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

public class s
  extends bo<com.tencent.mm.plugin.webview.luggage.f>
{
  public final void a(Context paramContext, String paramString, bn.a parama) {}
  
  public final void b(final a<com.tencent.mm.plugin.webview.luggage.f>.a parama)
  {
    AppMethodBeat.i(78553);
    ac.i("MicroMsg.JsApiGetBrandWCPayRequest", "invokeInOwn");
    MMActivity localMMActivity = (MMActivity)((com.tencent.mm.plugin.webview.luggage.f)parama.bWR).mContext;
    Object localObject = new JSONObject();
    try
    {
      ((JSONObject)localObject).put("url", ((com.tencent.mm.plugin.webview.luggage.f)parama.bWR).getUrl());
      ((JSONObject)localObject).put("pay_scene", 3);
      label59:
      localObject = new WalletJsapiData(parama.bWS.bVY);
      ((WalletJsapiData)localObject).DGX = 1;
      ((WalletJsapiData)localObject).DHe = ((com.tencent.mm.plugin.webview.luggage.f)parama.bWR).mParams.getString(e.m.HhJ);
      ac.i("MicroMsg.JsApiGetBrandWCPayRequest", "pay channel: %s, scene: %s, adUxInfo: %s", new Object[] { Integer.valueOf(((WalletJsapiData)localObject).dcB), Integer.valueOf(((WalletJsapiData)localObject).dqL), ((WalletJsapiData)localObject).DHe });
      MMActivity.a local1 = new MMActivity.a()
      {
        public final void c(int paramAnonymousInt1, int paramAnonymousInt2, Intent paramAnonymousIntent)
        {
          AppMethodBeat.i(78552);
          if (paramAnonymousInt1 != (s.this.hashCode() & 0xFFFF))
          {
            AppMethodBeat.o(78552);
            return;
          }
          if (paramAnonymousInt2 == -1)
          {
            parama.a("", null);
            AppMethodBeat.o(78552);
            return;
          }
          if (paramAnonymousInt2 == 5)
          {
            HashMap localHashMap = new HashMap();
            paramAnonymousInt1 = paramAnonymousIntent.getIntExtra("key_jsapi_pay_err_code", 0);
            paramAnonymousIntent = bs.nullAsNil(paramAnonymousIntent.getStringExtra("key_jsapi_pay_err_msg"));
            localHashMap.put("err_code", Integer.valueOf(paramAnonymousInt1));
            localHashMap.put("err_desc", paramAnonymousIntent);
            ac.e("MicroMsg.JsApiGetBrandWCPayRequest", "errCode: %d, errMsg: %s", new Object[] { Integer.valueOf(paramAnonymousInt1), paramAnonymousIntent });
            parama.c("fail", localHashMap);
            AppMethodBeat.o(78552);
            return;
          }
          parama.a("cancel", null);
          AppMethodBeat.o(78552);
        }
      };
      if (!com.tencent.mm.pluginsdk.wallet.f.a(localMMActivity, (WalletJsapiData)localObject, hashCode() & 0xFFFF, local1)) {
        parama.a("fail", null);
      }
      AppMethodBeat.o(78553);
      return;
    }
    catch (JSONException localJSONException)
    {
      break label59;
    }
  }
  
  public final int bYk()
  {
    return 0;
  }
  
  public final String name()
  {
    return "getBrandWCPayRequest";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.luggage.jsapi.s
 * JD-Core Version:    0.7.0.1
 */