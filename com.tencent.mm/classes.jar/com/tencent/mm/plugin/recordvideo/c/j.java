package com.tencent.mm.plugin.recordvideo.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.h;
import com.tencent.mm.plugin.expt.b.c;
import com.tencent.mm.plugin.expt.b.c.a;
import kotlin.Metadata;
import kotlin.g.b.s;
import org.json.JSONArray;
import org.json.JSONObject;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/recordvideo/config/VideoGenerateRestriction;", "", "()V", "GLOBAL_SCENE", "", "KEY_SCENE", "", "KEY_VIDEO_HEIGHT", "KEY_VIDEO_MAX_DURATION_MS", "KEY_VIDEO_WIDTH", "getVideoGenerateRestriction", "Lorg/json/JSONObject;", "scene", "getVideoHeight", "restriction", "getVideoMaxDurationMs", "getVideoWidth", "plugin-recordvideo_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class j
{
  public static final j NHe;
  
  static
  {
    AppMethodBeat.i(279712);
    NHe = new j();
    AppMethodBeat.o(279712);
  }
  
  public static JSONObject agv(int paramInt)
  {
    AppMethodBeat.i(279702);
    Object localObject1 = ((c)h.ax(c.class)).a(c.a.znv, "");
    for (;;)
    {
      int k;
      int i;
      int j;
      try
      {
        JSONArray localJSONArray = new JSONArray((String)localObject1);
        k = localJSONArray.length();
        if (k <= 0) {
          break label125;
        }
        i = 0;
        localObject1 = null;
        j = i + 1;
        JSONObject localJSONObject = localJSONArray.getJSONObject(i);
        if (localJSONObject.optInt("scene") == paramInt)
        {
          AppMethodBeat.o(279702);
          return localJSONObject;
        }
        if (localJSONObject.optInt("scene") != -1) {
          break label117;
        }
        localObject1 = localJSONObject;
      }
      catch (Exception localException)
      {
        label100:
        AppMethodBeat.o(279702);
        return null;
      }
      AppMethodBeat.o(279702);
      return localObject1;
      label117:
      label125:
      while (j < k)
      {
        i = j;
        break;
        Object localObject2 = null;
        break label100;
      }
    }
  }
  
  public static int bI(JSONObject paramJSONObject)
  {
    AppMethodBeat.i(279705);
    s.u(paramJSONObject, "restriction");
    int i = paramJSONObject.optInt("video-width", -1);
    AppMethodBeat.o(279705);
    return i;
  }
  
  public static int bJ(JSONObject paramJSONObject)
  {
    AppMethodBeat.i(279708);
    s.u(paramJSONObject, "restriction");
    int i = paramJSONObject.optInt("video-height", -1);
    AppMethodBeat.o(279708);
    return i;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.recordvideo.c.j
 * JD-Core Version:    0.7.0.1
 */