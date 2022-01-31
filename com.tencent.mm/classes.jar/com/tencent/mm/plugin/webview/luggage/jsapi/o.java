package com.tencent.mm.plugin.webview.luggage.jsapi;

import android.content.Context;
import android.content.pm.PackageInfo;
import com.tencent.luggage.bridge.k;
import com.tencent.luggage.e.a;
import com.tencent.luggage.e.a.a;
import com.tencent.luggage.e.e;
import com.tencent.luggage.e.n;
import com.tencent.mm.pluginsdk.model.app.p;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONObject;

public class o
  extends aw<n>
{
  public final void a(Context paramContext, String paramString, aw.a parama) {}
  
  public final int aGj()
  {
    return 0;
  }
  
  public final void b(a<n>.a parama)
  {
    int i = 0;
    y.i("Micromsg.JsApiGetInstallState", "invokeInOwn");
    Object localObject1 = parama.bih.bhk;
    Object localObject3 = ((n)parama.big).mContext;
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
        localObject1 = p.getPackageInfo((Context)localObject3, str);
        if (localObject1 == null)
        {
          n = 0;
          break label473;
          j = i;
          y.i("Micromsg.JsApiGetInstallState", "getInstallState, packageName = " + str + ", version = " + n + ", versionName = " + (String)localObject1);
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
        return;
        parama.a("get_install_state:no", null);
        return;
      }
      j = i;
      localObject1 = ((PackageInfo)localObject1).versionName;
      continue;
      localObject4 = ((JSONObject)localObject2).optString("packageName");
      if (bk.bl((String)localObject4))
      {
        y.i("Micromsg.JsApiGetInstallState", "packageName is null or nil");
        parama.a("get_install_state:no_null_packageName", null);
        return;
      }
      localObject3 = p.getPackageInfo((Context)localObject3, (String)localObject4);
      if (localObject3 == null) {
        if (localObject3 != null) {
          break label419;
        }
      }
      label419:
      for (Object localObject2 = "null";; localObject2 = ((PackageInfo)localObject3).versionName)
      {
        y.i("Micromsg.JsApiGetInstallState", "doGetInstallState, packageName = " + (String)localObject4 + ", version = " + i + ", versionName = " + (String)localObject2);
        if (localObject3 != null) {
          break label429;
        }
        parama.a("get_install_state:no", null);
        return;
        i = ((PackageInfo)localObject3).versionCode;
        break;
      }
      label429:
      localObject3 = new HashMap();
      ((Map)localObject3).put("versionName", localObject2);
      parama.c("get_install_state:yes_" + i, (Map)localObject3);
      return;
      label473:
      if (localObject2 == null) {
        localObject2 = "null";
      }
    }
  }
  
  public final String name()
  {
    return "getInstallState";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.luggage.jsapi.o
 * JD-Core Version:    0.7.0.1
 */