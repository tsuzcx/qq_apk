package com.tencent.mm.plugin.webview.luggage.jsapi;

import android.content.Context;
import android.content.pm.PackageInfo;
import com.tencent.luggage.bridge.k;
import com.tencent.luggage.d.a.a;
import com.tencent.luggage.d.e;
import com.tencent.luggage.d.n;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.aa.b;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONObject;

public class t
  extends bn<n>
{
  public final void a(Context paramContext, String paramString, bn.a parama) {}
  
  public final void b(final com.tencent.luggage.d.a<n>.a parama)
  {
    AppMethodBeat.i(78555);
    ad.i("MicroMsg.JsApiGetInstallState", "invokeInOwn");
    com.tencent.mm.cj.a.post(new Runnable()
    {
      public final void run()
      {
        int i = 0;
        AppMethodBeat.i(78554);
        Object localObject1 = parama.bZV.bZb;
        Object localObject3 = ((n)parama.bZU).mContext;
        JSONArray localJSONArray = ((JSONObject)localObject1).optJSONArray("packageName");
        Object localObject4;
        JSONObject localJSONObject;
        int m;
        int j;
        int k;
        if (localJSONArray != null)
        {
          localObject4 = new JSONObject();
          localJSONObject = new JSONObject();
          m = 0;
          i = 0;
          j = i;
          k = i;
        }
        for (;;)
        {
          try
          {
            if (m >= localJSONArray.length()) {
              continue;
            }
            j = i;
            String str = localJSONArray.optString(m);
            j = i;
            localObject1 = b.getPackageInfo((Context)localObject3, str);
            if (localObject1 == null)
            {
              n = 0;
              break label501;
              j = i;
              ad.i("MicroMsg.JsApiGetInstallState", "getInstallState, packageName = " + str + ", version = " + n + ", versionName = " + (String)localObject1);
              k = i;
              if (i == 0)
              {
                k = i;
                if (n > 0) {
                  k = 1;
                }
              }
              j = k;
              ((JSONObject)localObject4).put(str, n);
              j = k;
              localJSONObject.put(str, localObject1);
              m += 1;
              i = k;
              break;
            }
            j = i;
            int n = ((PackageInfo)localObject1).versionCode;
          }
          catch (Exception localException)
          {
            k = j;
            localObject2 = new HashMap();
            ((HashMap)localObject2).put("result", ((JSONObject)localObject4).toString());
            ((HashMap)localObject2).put("versionName", localJSONObject.toString());
            if (k == 0) {
              continue;
            }
            parama.c("get_install_state:yes", (Map)localObject2);
            AppMethodBeat.o(78554);
            return;
            parama.a("get_install_state:no", null);
            AppMethodBeat.o(78554);
            return;
          }
          j = i;
          localObject1 = ((PackageInfo)localObject1).versionName;
          continue;
          localObject4 = ((JSONObject)localObject2).optString("packageName");
          if (bt.isNullOrNil((String)localObject4))
          {
            ad.i("MicroMsg.JsApiGetInstallState", "packageName is null or nil");
            parama.a("get_install_state:no_null_packageName", null);
            AppMethodBeat.o(78554);
            return;
          }
          localObject3 = b.getPackageInfo((Context)localObject3, (String)localObject4);
          if (localObject3 == null) {
            if (localObject3 != null) {
              break label446;
            }
          }
          label446:
          for (Object localObject2 = "null";; localObject2 = ((PackageInfo)localObject3).versionName)
          {
            ad.i("MicroMsg.JsApiGetInstallState", "doGetInstallState, packageName = " + (String)localObject4 + ", version = " + i + ", versionName = " + (String)localObject2);
            if (localObject3 != null) {
              break label456;
            }
            parama.a("get_install_state:no", null);
            AppMethodBeat.o(78554);
            return;
            i = ((PackageInfo)localObject3).versionCode;
            break;
          }
          label456:
          localObject3 = new HashMap();
          ((Map)localObject3).put("versionName", localObject2);
          parama.c("get_install_state:yes_".concat(String.valueOf(i)), (Map)localObject3);
          AppMethodBeat.o(78554);
          return;
          label501:
          if (localObject2 == null) {
            localObject2 = "null";
          }
        }
      }
    });
    AppMethodBeat.o(78555);
  }
  
  public final int bQV()
  {
    return 0;
  }
  
  public final String name()
  {
    return "getInstallState";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.luggage.jsapi.t
 * JD-Core Version:    0.7.0.1
 */