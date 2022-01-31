package com.tencent.mm.plugin.wepkg.model;

import com.tencent.mm.a.g;
import com.tencent.mm.protocal.c.ciu;
import com.tencent.mm.protocal.c.ze;
import com.tencent.mm.sdk.platformtools.bk;
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

final class e$3$1
  implements Runnable
{
  e$3$1(e.3 param3) {}
  
  public final void run()
  {
    do
    {
      JSONArray localJSONArray;
      for (;;)
      {
        JSONObject localJSONObject2;
        Object localObject4;
        try
        {
          JSONObject localJSONObject1 = new JSONObject();
          localJSONObject1.put("rootDir", this.rPA.rPx);
          Object localObject1 = new HashMap();
          e.a(this.rPA.rPy, (Map)localObject1);
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
          localObject2 = f.Vj((String)((Map.Entry)localObject3).getKey());
          if (localObject2 != null) {
            localJSONObject2.put("controlInfo", ((WepkgVersion)localObject2).cjZ());
          }
          localObject4 = f.Vm((String)((Map.Entry)localObject3).getKey());
          if (!bk.dk((List)localObject4))
          {
            localObject2 = new JSONArray();
            localObject4 = ((List)localObject4).iterator();
            if (((Iterator)localObject4).hasNext())
            {
              ((JSONArray)localObject2).put(((WepkgPreloadFile)((Iterator)localObject4).next()).cjZ());
              continue;
            }
            localJSONObject2.put("preloadFilesInfo", localObject2);
          }
        }
        catch (Exception localException)
        {
          if (this.rPA.rPz != null) {
            this.rPA.rPz.R(null);
          }
          return;
        }
        Object localObject2 = new JSONArray();
        Object localObject3 = ((List)((Map.Entry)localObject3).getValue()).iterator();
        while (((Iterator)localObject3).hasNext())
        {
          Object localObject5 = (e.c)((Iterator)localObject3).next();
          localObject4 = new JSONObject();
          ((JSONObject)localObject4).put("version", ((e.c)localObject5).version);
          if (!bk.bl(((e.c)localObject5).oMP))
          {
            localObject6 = new File(((e.c)localObject5).oMP);
            if ((!((File)localObject6).exists()) || (!((File)localObject6).isFile())) {
              continue;
            }
            ((JSONObject)localObject4).put("md5", g.m((File)localObject6));
            ((JSONObject)localObject4).put("size", ((File)localObject6).length());
            Object localObject7 = new c((File)localObject6).rPg;
            if (localObject7 != null)
            {
              ((JSONObject)localObject4).put("charset", ((ciu)localObject7).tXb);
              ((JSONObject)localObject4).put("desc", ((ciu)localObject7).kRN);
              if (((ciu)localObject7).tXa != null)
              {
                localObject6 = new JSONArray();
                localObject7 = ((ciu)localObject7).tXa.iterator();
                while (((Iterator)localObject7).hasNext())
                {
                  ze localze = (ze)((Iterator)localObject7).next();
                  JSONObject localJSONObject3 = new JSONObject();
                  localJSONObject3.put("rid", localze.sYw);
                  localJSONObject3.put("offset", localze.sYx);
                  localJSONObject3.put("size", localze.hQL);
                  localJSONObject3.put("mimeType", localze.sYy);
                  ((JSONArray)localObject6).put(localJSONObject3);
                }
                ((JSONObject)localObject4).put("resList", localObject6);
              }
            }
          }
          Object localObject6 = ((e.c)localObject5).rPC;
          if (!bk.dk((List)localObject6))
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
    } while (this.rPA.rPz == null);
    this.rPA.rPz.R(localException);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.wepkg.model.e.3.1
 * JD-Core Version:    0.7.0.1
 */