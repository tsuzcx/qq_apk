package com.tencent.mm.pluginsdk.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import kotlin.Metadata;
import kotlin.g.b.s;
import org.json.JSONException;
import org.json.JSONObject;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/pluginsdk/model/BizFinderLiveNativeExtraData;", "Lcom/tencent/mm/plugin/appbrand/api/IWeAppOpenNativeExtraData;", "()V", "bypass", "", "getBypass", "()Ljava/lang/String;", "setBypass", "(Ljava/lang/String;)V", "dataBuffer", "getDataBuffer", "setDataBuffer", "scene", "", "getScene", "()I", "setScene", "(I)V", "toJsonString", "Companion", "plugin-biz_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class d
  implements com.tencent.mm.plugin.appbrand.api.d
{
  public static final a XQn;
  String XQo = "";
  int scene;
  String vPX = "";
  
  static
  {
    AppMethodBeat.i(244719);
    XQn = new a((byte)0);
    AppMethodBeat.o(244719);
  }
  
  public final String toJsonString()
  {
    AppMethodBeat.i(244727);
    try
    {
      Object localObject = new JSONObject();
      ((JSONObject)localObject).put("dataBuffer", Util.nullAsNil(this.vPX));
      ((JSONObject)localObject).put("enterScene", this.scene);
      ((JSONObject)localObject).put("bypass", this.XQo);
      localObject = new JSONObject().put("bizFinderLiveInfo", localObject).toString();
      s.s(localObject, "{\n            val obj = …obj).toString()\n        }");
      AppMethodBeat.o(244727);
      return localObject;
    }
    catch (JSONException localJSONException)
    {
      for (;;)
      {
        Log.printErrStackTrace("MicroMsg.BizFinderLiveNativeExtraData", (Throwable)localJSONException, "", new Object[0]);
        String str = "{}";
      }
    }
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/pluginsdk/model/BizFinderLiveNativeExtraData$Companion;", "", "()V", "TAG", "", "plugin-biz_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.model.d
 * JD-Core Version:    0.7.0.1
 */