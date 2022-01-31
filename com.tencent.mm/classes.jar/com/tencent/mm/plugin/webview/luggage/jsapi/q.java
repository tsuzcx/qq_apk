package com.tencent.mm.plugin.webview.luggage.jsapi;

import android.content.Context;
import android.content.pm.PackageInfo;
import com.tencent.luggage.bridge.k;
import com.tencent.luggage.d.a;
import com.tencent.luggage.d.a.a;
import com.tencent.luggage.d.e;
import com.tencent.luggage.d.n;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.s.b;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONObject;

public class q
  extends bh<n>
{
  public final void a(Context paramContext, String paramString, bh.a parama) {}
  
  public final void b(a<n>.a parama)
  {
    AppMethodBeat.i(6310);
    ab.i("Micromsg.JsApiGetInstallState", "invokeInOwn");
    Object localObject1 = parama.byF.bxK;
    Object localObject3 = ((n)parama.byE).mContext;
    JSONArray localJSONArray = ((JSONObject)localObject1).optJSONArray("packageName");
    Object localObject4;
    JSONObject localJSONObject;
    int i;
    int m;
    int j;
    int k;
    if (localJSONArray != null)
    {
      localObject4 = new JSONObject();
      localJSONObject = new JSONObject();
      i = 0;
      m = 0;
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
          break label502;
          j = i;
          ab.i("Micromsg.JsApiGetInstallState", "getInstallState, packageName = " + str + ", version = " + n + ", versionName = " + (String)localObject1);
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
        AppMethodBeat.o(6310);
        return;
        parama.a("get_install_state:no", null);
        AppMethodBeat.o(6310);
        return;
      }
      j = i;
      localObject1 = ((PackageInfo)localObject1).versionName;
      continue;
      localObject4 = ((JSONObject)localObject2).optString("packageName");
      if (bo.isNullOrNil((String)localObject4))
      {
        ab.i("Micromsg.JsApiGetInstallState", "packageName is null or nil");
        parama.a("get_install_state:no_null_packageName", null);
        AppMethodBeat.o(6310);
        return;
      }
      localObject3 = b.getPackageInfo((Context)localObject3, (String)localObject4);
      if (localObject3 == null)
      {
        i = 0;
        if (localObject3 != null) {
          break label449;
        }
      }
      label449:
      for (Object localObject2 = "null";; localObject2 = ((PackageInfo)localObject3).versionName)
      {
        ab.i("Micromsg.JsApiGetInstallState", "doGetInstallState, packageName = " + (String)localObject4 + ", version = " + i + ", versionName = " + (String)localObject2);
        if (localObject3 != null) {
          break label459;
        }
        parama.a("get_install_state:no", null);
        AppMethodBeat.o(6310);
        return;
        i = ((PackageInfo)localObject3).versionCode;
        break;
      }
      label459:
      localObject3 = new HashMap();
      ((Map)localObject3).put("versionName", localObject2);
      parama.c("get_install_state:yes_".concat(String.valueOf(i)), (Map)localObject3);
      AppMethodBeat.o(6310);
      return;
      label502:
      if (localObject2 == null) {
        localObject2 = "null";
      }
    }
  }
  
  public final int bjL()
  {
    return 0;
  }
  
  public final String name()
  {
    return "getInstallState";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.luggage.jsapi.q
 * JD-Core Version:    0.7.0.1
 */