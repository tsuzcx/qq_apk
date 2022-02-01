package com.tencent.mm.plugin.sns.ad.f.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.lite.api.e.a;
import com.tencent.mm.plugin.sns.ad.d.r;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import org.json.JSONObject;

public class a
  extends com.tencent.mm.plugin.lite.api.e
{
  public final void a(String paramString, JSONObject paramJSONObject, boolean paramBoolean)
  {
    AppMethodBeat.i(309645);
    if ((!paramJSONObject.has("canvasId")) || (!paramJSONObject.has("uxInfo")))
    {
      Log.e("LiteAppJsApiOpenAdCanvas", "data not has key canvasId or uxInfo");
      r.gZX();
      this.JZj.aJV("data not has key canvasId or uxInfo");
      AppMethodBeat.o(309645);
      return;
    }
    try
    {
      paramString = Util.nullAsNil(paramJSONObject.getString("canvasId"));
      paramJSONObject = Util.nullAsNil(paramJSONObject.getString("uxInfo"));
      if (Util.isNullOrNil(new String[] { paramString, paramJSONObject }))
      {
        Log.e("LiteAppJsApiOpenAdCanvas", "canvasId or uxInfo is null or nil");
        r.gZX();
        this.JZj.aJV("canvasId or uxInfo is null or nil");
        AppMethodBeat.o(309645);
        return;
      }
      com.tencent.mm.plugin.report.service.h.OAn.kJ(1706, 27);
      paramJSONObject = ((com.tencent.mm.plugin.sns.c.e)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.sns.c.e.class)).aWg(paramJSONObject);
      ((com.tencent.mm.plugin.sns.c.e)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.sns.c.e.class)).a(Util.safeParseLong(paramString), paramJSONObject, "", 31);
      this.JZj.fTW();
      AppMethodBeat.o(309645);
      return;
    }
    finally
    {
      Log.printErrStackTrace("LiteAppJsApiOpenAdCanvas", paramString, "open ad canvas", new Object[0]);
      AppMethodBeat.o(309645);
    }
  }
  
  public final int fEx()
  {
    return 1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ad.f.a.a
 * JD-Core Version:    0.7.0.1
 */