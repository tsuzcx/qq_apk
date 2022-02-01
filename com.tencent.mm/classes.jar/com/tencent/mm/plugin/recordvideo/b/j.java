package com.tencent.mm.plugin.recordvideo.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.h;
import com.tencent.mm.plugin.expt.b.b;
import com.tencent.mm.plugin.expt.b.b.a;
import kotlin.g.b.p;
import kotlin.l;
import org.json.JSONArray;
import org.json.JSONObject;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/recordvideo/config/VideoGenerateRestriction;", "", "()V", "GLOBAL_SCENE", "", "KEY_SCENE", "", "KEY_VIDEO_HEIGHT", "KEY_VIDEO_MAX_DURATION_MS", "KEY_VIDEO_WIDTH", "getVideoGenerateRestriction", "Lorg/json/JSONObject;", "scene", "getVideoHeight", "restriction", "getVideoMaxDurationMs", "getVideoWidth", "plugin-recordvideo_release"})
public final class j
{
  public static final j HKg;
  
  static
  {
    AppMethodBeat.i(225640);
    HKg = new j();
    AppMethodBeat.o(225640);
  }
  
  public static JSONObject aci(int paramInt)
  {
    AppMethodBeat.i(225632);
    Object localObject = ((b)h.ae(b.class)).a(b.a.vUR, "");
    for (;;)
    {
      int i;
      try
      {
        JSONArray localJSONArray = new JSONArray((String)localObject);
        int j = localJSONArray.length();
        i = 0;
        localObject = null;
        if (i < j)
        {
          JSONObject localJSONObject = localJSONArray.getJSONObject(i);
          if (localJSONObject.optInt("scene") == paramInt)
          {
            AppMethodBeat.o(225632);
            return localJSONObject;
          }
          if (localJSONObject.optInt("scene") == -1)
          {
            localObject = localJSONObject;
            break label111;
          }
        }
        else
        {
          AppMethodBeat.o(225632);
          return localObject;
        }
      }
      catch (Exception localException)
      {
        AppMethodBeat.o(225632);
        return null;
      }
      label111:
      i += 1;
    }
  }
  
  public static int br(JSONObject paramJSONObject)
  {
    AppMethodBeat.i(225634);
    p.k(paramJSONObject, "restriction");
    int i = paramJSONObject.optInt("video-width", -1);
    AppMethodBeat.o(225634);
    return i;
  }
  
  public static int bs(JSONObject paramJSONObject)
  {
    AppMethodBeat.i(225638);
    p.k(paramJSONObject, "restriction");
    int i = paramJSONObject.optInt("video-height", -1);
    AppMethodBeat.o(225638);
    return i;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.recordvideo.b.j
 * JD-Core Version:    0.7.0.1
 */