package com.tencent.mm.plugin.wepkg.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.protobuf.adp;
import com.tencent.mm.protocal.protobuf.cwh;
import com.tencent.mm.sdk.platformtools.bo;
import java.io.File;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import org.json.JSONArray;
import org.json.JSONObject;

final class g$1$1
  implements Runnable
{
  g$1$1(g.1 param1) {}
  
  public final void run()
  {
    AppMethodBeat.i(63551);
    JSONArray localJSONArray;
    for (;;)
    {
      JSONObject localJSONObject2;
      Object localObject4;
      try
      {
        JSONObject localJSONObject1 = new JSONObject();
        localJSONObject1.put("rootDir", this.vGr.vGo);
        Object localObject1 = new HashMap();
        g.a(this.vGr.vGp, (Map)localObject1);
        localJSONArray = new JSONArray();
        localObject1 = ((Map)localObject1).entrySet().iterator();
        if (!((Iterator)localObject1).hasNext()) {
          break;
        }
        localObject3 = (Map.Entry)((Iterator)localObject1).next();
        if (((List)((Map.Entry)localObject3).getValue()).size() == 0) {
          continue;
        }
        localJSONObject2 = new JSONObject();
        localJSONObject2.put("pkgId", ((Map.Entry)localObject3).getKey());
        localObject2 = h.akF((String)((Map.Entry)localObject3).getKey());
        if (localObject2 != null) {
          localJSONObject2.put("controlInfo", ((WepkgVersion)localObject2).dkD());
        }
        localObject4 = h.akJ((String)((Map.Entry)localObject3).getKey());
        if (!bo.es((List)localObject4))
        {
          localObject2 = new JSONArray();
          localObject4 = ((List)localObject4).iterator();
          if (((Iterator)localObject4).hasNext())
          {
            ((JSONArray)localObject2).put(((WepkgPreloadFile)((Iterator)localObject4).next()).dkD());
            continue;
          }
          localJSONObject2.put("preloadFilesInfo", localObject2);
        }
      }
      catch (Exception localException)
      {
        if (this.vGr.vGq != null) {
          this.vGr.vGq.ac(null);
        }
        AppMethodBeat.o(63551);
        return;
      }
      Object localObject2 = new JSONArray();
      Object localObject3 = ((List)((Map.Entry)localObject3).getValue()).iterator();
      while (((Iterator)localObject3).hasNext())
      {
        Object localObject5 = (g.b)((Iterator)localObject3).next();
        localObject4 = new JSONObject();
        ((JSONObject)localObject4).put("version", ((g.b)localObject5).version);
        if (!bo.isNullOrNil(((g.b)localObject5).rEA))
        {
          localObject6 = new File(((g.b)localObject5).rEA);
          if ((!((File)localObject6).exists()) || (!((File)localObject6).isFile())) {
            continue;
          }
          ((JSONObject)localObject4).put("md5", com.tencent.mm.a.g.r((File)localObject6));
          ((JSONObject)localObject4).put("size", ((File)localObject6).length());
          Object localObject7 = new e((File)localObject6).vFY;
          if (localObject7 != null)
          {
            ((JSONObject)localObject4).put("charset", ((cwh)localObject7).yew);
            ((JSONObject)localObject4).put("desc", ((cwh)localObject7).Desc);
            if (((cwh)localObject7).yev != null)
            {
              localObject6 = new JSONArray();
              localObject7 = ((cwh)localObject7).yev.iterator();
              while (((Iterator)localObject7).hasNext())
              {
                adp localadp = (adp)((Iterator)localObject7).next();
                JSONObject localJSONObject3 = new JSONObject();
                localJSONObject3.put("rid", localadp.wWA);
                localJSONObject3.put("offset", localadp.wWB);
                localJSONObject3.put("size", localadp.jKn);
                localJSONObject3.put("mimeType", localadp.wWC);
                ((JSONArray)localObject6).put(localJSONObject3);
              }
              ((JSONObject)localObject4).put("resList", localObject6);
            }
          }
        }
        Object localObject6 = ((g.b)localObject5).vGt;
        if (!bo.es((List)localObject6))
        {
          localObject5 = new JSONArray();
          localObject6 = ((List)localObject6).iterator();
          while (((Iterator)localObject6).hasNext()) {
            ((JSONArray)localObject5).put((String)((Iterator)localObject6).next());
          }
          ((JSONObject)localObject4).put("preloadFiles", localObject5);
        }
        ((JSONArray)localObject2).put(localObject4);
      }
      localJSONObject2.put("versionList", localObject2);
      localJSONArray.put(localJSONObject2);
    }
    localException.put("pkgList", localJSONArray);
    if (this.vGr.vGq != null) {
      this.vGr.vGq.ac(localException);
    }
    AppMethodBeat.o(63551);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.wepkg.model.g.1.1
 * JD-Core Version:    0.7.0.1
 */