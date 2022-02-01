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
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.MMActivity.a;
import com.tencent.mm.ui.e.m;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

public class s
  extends br<g>
{
  public final void a(Context paramContext, String paramString, bq.a parama) {}
  
  public final void b(final b<g>.a paramb)
  {
    AppMethodBeat.i(78553);
    ad.i("MicroMsg.JsApiGetBrandWCPayRequest", "invokeInOwn");
    MMActivity localMMActivity = (MMActivity)((g)paramb.chg).mContext;
    Object localObject = new JSONObject();
    try
    {
      ((JSONObject)localObject).put("url", ((g)paramb.chg).getUrl());
      ((JSONObject)localObject).put("pay_scene", 3);
      label59:
      localObject = new WalletJsapiData(paramb.chh.cgn);
      ((WalletJsapiData)localObject).Fme = 1;
      ((WalletJsapiData)localObject).Fml = ((g)paramb.chg).mParams.getString(e.m.IUZ);
      ad.i("MicroMsg.JsApiGetBrandWCPayRequest", "pay channel: %s, scene: %s, adUxInfo: %s", new Object[] { Integer.valueOf(((WalletJsapiData)localObject).dnX), Integer.valueOf(((WalletJsapiData)localObject).dCC), ((WalletJsapiData)localObject).Fml });
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
            paramb.a("", null);
            AppMethodBeat.o(78552);
            return;
          }
          if (paramAnonymousInt2 == 5)
          {
            HashMap localHashMap = new HashMap();
            paramAnonymousInt1 = paramAnonymousIntent.getIntExtra("key_jsapi_pay_err_code", 0);
            paramAnonymousIntent = bt.nullAsNil(paramAnonymousIntent.getStringExtra("key_jsapi_pay_err_msg"));
            localHashMap.put("err_code", Integer.valueOf(paramAnonymousInt1));
            localHashMap.put("err_desc", paramAnonymousIntent);
            ad.e("MicroMsg.JsApiGetBrandWCPayRequest", "errCode: %d, errMsg: %s", new Object[] { Integer.valueOf(paramAnonymousInt1), paramAnonymousIntent });
            paramb.d("fail", localHashMap);
            AppMethodBeat.o(78552);
            return;
          }
          paramb.a("cancel", null);
          AppMethodBeat.o(78552);
        }
      };
      if (!f.a(localMMActivity, (WalletJsapiData)localObject, hashCode() & 0xFFFF, local1)) {
        paramb.a("fail", null);
      }
      AppMethodBeat.o(78553);
      return;
    }
    catch (JSONException localJSONException)
    {
      break label59;
    }
  }
  
  public final int ccO()
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