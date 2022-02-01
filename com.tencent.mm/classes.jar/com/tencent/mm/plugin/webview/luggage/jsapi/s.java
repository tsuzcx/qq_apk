package com.tencent.mm.plugin.webview.luggage.jsapi;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import com.tencent.luggage.bridge.k;
import com.tencent.luggage.d.b;
import com.tencent.luggage.d.b.a;
import com.tencent.luggage.d.h;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.webview.luggage.g;
import com.tencent.mm.pluginsdk.wallet.WalletJsapiData;
import com.tencent.mm.pluginsdk.wallet.f;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.MMActivity.a;
import com.tencent.mm.ui.e.p;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

public class s
  extends bs<g>
{
  public final void a(Context paramContext, String paramString, br.a parama) {}
  
  public final void b(final b<g>.a paramb)
  {
    AppMethodBeat.i(78553);
    Log.i("MicroMsg.JsApiGetBrandWCPayRequest", "invokeInOwn");
    MMActivity localMMActivity = (MMActivity)((g)paramb.cta).mContext;
    Object localObject = new JSONObject();
    try
    {
      ((JSONObject)localObject).put("url", ((g)paramb.cta).getUrl());
      ((JSONObject)localObject).put("pay_scene", 3);
      label59:
      localObject = new WalletJsapiData(paramb.ctb.csi);
      ((WalletJsapiData)localObject).KxH = 1;
      ((WalletJsapiData)localObject).KxO = ((g)paramb.cta).mParams.getString(e.p.OzI);
      Log.i("MicroMsg.JsApiGetBrandWCPayRequest", "pay channel: %s, scene: %s, adUxInfo: %s", new Object[] { Integer.valueOf(((WalletJsapiData)localObject).payChannel), Integer.valueOf(((WalletJsapiData)localObject).dVv), ((WalletJsapiData)localObject).KxO });
      MMActivity.a local1 = new MMActivity.a()
      {
        public final void d(int paramAnonymousInt1, int paramAnonymousInt2, Intent paramAnonymousIntent)
        {
          AppMethodBeat.i(78552);
          if (paramAnonymousInt1 != (s.this.hashCode() & 0xFFFF))
          {
            AppMethodBeat.o(78552);
            return;
          }
          if (paramAnonymousInt2 == -1)
          {
            paramb.c("", null);
            AppMethodBeat.o(78552);
            return;
          }
          if (paramAnonymousInt2 == 5)
          {
            HashMap localHashMap = new HashMap();
            paramAnonymousInt1 = paramAnonymousIntent.getIntExtra("key_jsapi_pay_err_code", 0);
            paramAnonymousIntent = Util.nullAsNil(paramAnonymousIntent.getStringExtra("key_jsapi_pay_err_msg"));
            localHashMap.put("err_code", Integer.valueOf(paramAnonymousInt1));
            localHashMap.put("err_desc", paramAnonymousIntent);
            Log.e("MicroMsg.JsApiGetBrandWCPayRequest", "errCode: %d, errMsg: %s", new Object[] { Integer.valueOf(paramAnonymousInt1), paramAnonymousIntent });
            paramb.e("fail", localHashMap);
            AppMethodBeat.o(78552);
            return;
          }
          paramb.c("cancel", null);
          AppMethodBeat.o(78552);
        }
      };
      if (!f.a(localMMActivity, (WalletJsapiData)localObject, hashCode() & 0xFFFF, local1)) {
        paramb.c("fail", null);
      }
      AppMethodBeat.o(78553);
      return;
    }
    catch (JSONException localJSONException)
    {
      break label59;
    }
  }
  
  public final int dTs()
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