package com.tencent.mm.plugin.mv.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.music.model.g;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.vfs.q;
import com.tencent.mm.vfs.u;
import java.util.LinkedHashMap;
import kotlin.g.b.p;
import kotlin.l;
import org.json.JSONArray;
import org.json.JSONObject;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/mv/model/DefaultPagInfo;", "", "id", "", "nameObj", "Lorg/json/JSONObject;", "wxamPath", "pagPath", "isShowInPanel", "", "(Ljava/lang/String;Lorg/json/JSONObject;Ljava/lang/String;Ljava/lang/String;Z)V", "getId", "()Ljava/lang/String;", "()Z", "setShowInPanel", "(Z)V", "getNameObj", "()Lorg/json/JSONObject;", "getPagPath", "setPagPath", "(Ljava/lang/String;)V", "getWxamPath", "getPagName", "Companion", "plugin-mv_release"})
public final class a
{
  private static final LinkedHashMap<String, a> GaO;
  public static final a GaP;
  public final JSONObject GaK;
  public final String GaL;
  public String GaM;
  private boolean GaN;
  public final String id;
  
  static
  {
    AppMethodBeat.i(231741);
    GaP = new a((byte)0);
    GaO = new LinkedHashMap();
    Object localObject = g.FRy;
    localObject = g.feQ();
    if (u.agG((String)localObject)) {
      a.aSC((String)localObject);
    }
    AppMethodBeat.o(231741);
  }
  
  public a(String paramString1, JSONObject paramJSONObject, String paramString2, String paramString3, boolean paramBoolean)
  {
    AppMethodBeat.i(231740);
    this.id = paramString1;
    this.GaK = paramJSONObject;
    this.GaL = paramString2;
    this.GaM = paramString3;
    this.GaN = paramBoolean;
    AppMethodBeat.o(231740);
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/mv/model/DefaultPagInfo$Companion;", "", "()V", "TAG", "", "mvPagInfoList", "Ljava/util/LinkedHashMap;", "Lcom/tencent/mm/plugin/mv/model/DefaultPagInfo;", "Lkotlin/collections/LinkedHashMap;", "getMvPagInfoList", "()Ljava/util/LinkedHashMap;", "fillPagInfoList", "", "folder", "plugin-mv_release"})
  public static final class a
  {
    public static void aSC(String paramString)
    {
      AppMethodBeat.i(229261);
      p.k(paramString, "folder");
      for (;;)
      {
        Object localObject1;
        Object localObject2;
        Object localObject3;
        try
        {
          JSONArray localJSONArray = new JSONArray(u.bBS(new q(new q(paramString), "config.conf").bOF()));
          int j = localJSONArray.length();
          int i = 0;
          if (i < j)
          {
            JSONObject localJSONObject2 = localJSONArray.optJSONObject(i);
            if (localJSONObject2 != null)
            {
              String str = localJSONObject2.optString("id");
              JSONObject localJSONObject1 = localJSONObject2.optJSONObject("name");
              localObject1 = paramString + '/' + str + ".pag";
              if (!u.agG((String)localObject1)) {
                continue;
              }
              break label281;
              localObject1 = paramString + '/' + str + ".wxam";
              if (!u.agG((String)localObject1)) {
                continue;
              }
              break label297;
              if (localJSONObject2.optInt("is_show_in_panel", 0) != 1) {
                continue;
              }
              bool = true;
              if ((str != null) && (localJSONObject1 != null) && (localObject2 != null) && (localObject3 != null))
              {
                localObject1 = a.GaP;
                a.ffQ().put(str, new a(str, localJSONObject1, (String)localObject3, (String)localObject2, bool));
              }
            }
            i += 1;
            continue;
            localObject1 = null;
            break label281;
            localObject1 = null;
            break label297;
            boolean bool = false;
            continue;
          }
          localObject2 = localObject1;
        }
        catch (Exception paramString)
        {
          Log.printErrStackTrace("MicroMsg.Mv.DefaultPagInfo", (Throwable)paramString, "fillPagInfoList", new Object[0]);
          AppMethodBeat.o(229261);
          return;
        }
        label281:
        if (localObject1 == null)
        {
          localObject2 = "";
          continue;
          label297:
          localObject3 = localObject1;
          if (localObject1 == null) {
            localObject3 = "";
          }
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.mv.model.a
 * JD-Core Version:    0.7.0.1
 */