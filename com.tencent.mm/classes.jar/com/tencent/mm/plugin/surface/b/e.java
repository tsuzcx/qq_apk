package com.tencent.mm.plugin.surface.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.ab;
import com.tencent.mm.plugin.appbrand.jsapi.f;
import com.tencent.mm.plugin.report.service.h;
import kotlin.Metadata;
import kotlin.g.b.s;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/surface/jsapi/JsApiReportKeyValue;", "Lcom/tencent/mm/plugin/appbrand/jsapi/AppBrandSyncJsApi;", "Lcom/tencent/mm/plugin/appbrand/jsapi/AppBrandComponent;", "()V", "invoke", "", "env", "data", "Lorg/json/JSONObject;", "Companion", "plugin-surface-app_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class e
  extends ab<f>
{
  public static final String NAME = "reportKeyValue";
  public static final a SKN;
  
  static
  {
    AppMethodBeat.i(265088);
    SKN = new a((byte)0);
    AppMethodBeat.o(265088);
  }
  
  public final String a(f paramf, JSONObject paramJSONObject)
  {
    AppMethodBeat.i(265096);
    for (;;)
    {
      int j;
      try
      {
        s.checkNotNull(paramJSONObject);
        paramf = paramJSONObject.getJSONArray("dataArray");
        i = 0;
        int k = paramf.length();
        if (k > 0)
        {
          j = i + 1;
          paramJSONObject = paramf.getJSONObject(i);
          String str = paramJSONObject.getString("key");
          s.s(str, "jsonObject.getString(\"key\")");
          i = Integer.parseInt(str);
          paramJSONObject = paramJSONObject.getString("value");
          h.OAn.kvStat(i, paramJSONObject);
          if (j < k) {}
        }
        else
        {
          paramf = ZP("ok");
          s.s(paramf, "makeReturnJson(\"ok\")");
          AppMethodBeat.o(265096);
          return paramf;
        }
      }
      catch (JSONException paramf)
      {
        paramf = ZP("fail");
        s.s(paramf, "makeReturnJson(\"fail\")");
        AppMethodBeat.o(265096);
        return paramf;
      }
      int i = j;
    }
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/surface/jsapi/JsApiReportKeyValue$Companion;", "", "()V", "NAME", "", "TAG", "plugin-surface-app_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.surface.b.e
 * JD-Core Version:    0.7.0.1
 */