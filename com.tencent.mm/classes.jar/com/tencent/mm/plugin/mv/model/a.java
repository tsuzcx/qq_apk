package com.tencent.mm.plugin.mv.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.music.model.g;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.vfs.ah;
import com.tencent.mm.vfs.u;
import com.tencent.mm.vfs.y;
import java.util.LinkedHashMap;
import kotlin.Metadata;
import kotlin.g.b.s;
import org.json.JSONArray;
import org.json.JSONObject;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/mv/model/DefaultPagInfo;", "", "id", "", "nameObj", "Lorg/json/JSONObject;", "wxamPath", "pagPath", "isShowInPanel", "", "(Ljava/lang/String;Lorg/json/JSONObject;Ljava/lang/String;Ljava/lang/String;Z)V", "getId", "()Ljava/lang/String;", "()Z", "setShowInPanel", "(Z)V", "getNameObj", "()Lorg/json/JSONObject;", "getPagPath", "setPagPath", "(Ljava/lang/String;)V", "getWxamPath", "getPagName", "Companion", "plugin-mv_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class a
{
  public static final a LWK;
  private static final LinkedHashMap<String, a> LWP;
  public final JSONObject LWL;
  public final String LWM;
  public String LWN;
  private boolean LWO;
  public final String id;
  
  static
  {
    AppMethodBeat.i(286096);
    LWK = new a((byte)0);
    LWP = new LinkedHashMap();
    Object localObject = g.LMs;
    localObject = g.gnX();
    if (y.ZC((String)localObject)) {
      a.aPw((String)localObject);
    }
    AppMethodBeat.o(286096);
  }
  
  public a(String paramString1, JSONObject paramJSONObject, String paramString2, String paramString3, boolean paramBoolean)
  {
    AppMethodBeat.i(286079);
    this.id = paramString1;
    this.LWL = paramJSONObject;
    this.LWM = paramString2;
    this.LWN = paramString3;
    this.LWO = paramBoolean;
    AppMethodBeat.o(286079);
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/mv/model/DefaultPagInfo$Companion;", "", "()V", "TAG", "", "mvPagInfoList", "Ljava/util/LinkedHashMap;", "Lcom/tencent/mm/plugin/mv/model/DefaultPagInfo;", "Lkotlin/collections/LinkedHashMap;", "getMvPagInfoList", "()Ljava/util/LinkedHashMap;", "fillPagInfoList", "", "folder", "plugin-mv_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class a
  {
    public static void aPw(String paramString)
    {
      AppMethodBeat.i(286169);
      s.u(paramString, "folder");
      for (;;)
      {
        Object localObject1;
        Object localObject3;
        try
        {
          JSONArray localJSONArray = new JSONArray(y.bEn(ah.v(new u(new u(paramString), "config.conf").jKT())));
          int k = localJSONArray.length();
          int j;
          if (k > 0)
          {
            i = 0;
            j = i + 1;
            JSONObject localJSONObject2 = localJSONArray.optJSONObject(i);
            if (localJSONObject2 != null)
            {
              String str = localJSONObject2.optString("id");
              JSONObject localJSONObject1 = localJSONObject2.optJSONObject("name");
              localObject1 = paramString + '/' + str + ".pag";
              if (!y.ZC((String)localObject1)) {
                continue;
              }
              break label289;
              localObject1 = paramString + '/' + str + ".wxam";
              if (!y.ZC((String)localObject1)) {
                continue;
              }
              break label305;
              if (localJSONObject2.optInt("is_show_in_panel", 0) != 1) {
                continue;
              }
              bool = true;
              if ((str != null) && (localJSONObject1 != null))
              {
                localObject1 = a.LWK;
                a.gpt().put(str, new a(str, localJSONObject1, (String)localObject3, (String)localObject2, bool));
              }
            }
            if (j < k) {
              break label284;
            }
            AppMethodBeat.o(286169);
            return;
            localObject1 = null;
            break label289;
            localObject1 = null;
            break label305;
            boolean bool = false;
            continue;
          }
          int i = j;
        }
        catch (Exception paramString)
        {
          Log.printErrStackTrace("MicroMsg.Mv.DefaultPagInfo", (Throwable)paramString, "fillPagInfoList", new Object[0]);
          AppMethodBeat.o(286169);
          return;
        }
        label284:
        continue;
        label289:
        Object localObject2 = localObject1;
        if (localObject1 == null)
        {
          localObject2 = "";
          continue;
          label305:
          localObject3 = localObject1;
          if (localObject1 == null) {
            localObject3 = "";
          }
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.mv.model.a
 * JD-Core Version:    0.7.0.1
 */