package com.tencent.mm.plugin.wallet_core.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.c.gu;
import com.tencent.mm.plugin.wallet_core.d.e;
import com.tencent.mm.sdk.e.c.a;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bu;
import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import org.json.JSONArray;
import org.json.JSONObject;

public final class y
  extends gu
{
  public static c.a info;
  
  static
  {
    AppMethodBeat.i(70415);
    c.a locala = new c.a();
    locala.IBL = new Field[3];
    locala.columns = new String[4];
    StringBuilder localStringBuilder = new StringBuilder();
    locala.columns[0] = "bulletin_scene";
    locala.IBN.put("bulletin_scene", "TEXT PRIMARY KEY ");
    localStringBuilder.append(" bulletin_scene TEXT PRIMARY KEY ");
    localStringBuilder.append(", ");
    locala.IBM = "bulletin_scene";
    locala.columns[1] = "bulletin_content";
    locala.IBN.put("bulletin_content", "TEXT");
    localStringBuilder.append(" bulletin_content TEXT");
    localStringBuilder.append(", ");
    locala.columns[2] = "bulletin_url";
    locala.IBN.put("bulletin_url", "TEXT");
    localStringBuilder.append(" bulletin_url TEXT");
    locala.columns[3] = "rowid";
    locala.sql = localStringBuilder.toString();
    info = locala;
    AppMethodBeat.o(70415);
  }
  
  public static void bn(JSONObject paramJSONObject)
  {
    boolean bool3 = true;
    boolean bool2 = true;
    int j = 0;
    AppMethodBeat.i(70414);
    Object localObject1 = t.eJj();
    if ((paramJSONObject != null) && (localObject1 != null))
    {
      Object localObject3 = paramJSONObject.optJSONArray("banner_map");
      paramJSONObject = paramJSONObject.optJSONArray("banner_content_array");
      localObject2 = new HashMap();
      HashMap localHashMap = new HashMap();
      if ((localObject3 != null) && (paramJSONObject != null))
      {
        int k = ((JSONArray)localObject3).length();
        int i = 0;
        Object localObject4;
        String str;
        while (i < k)
        {
          localObject4 = ((JSONArray)localObject3).optJSONObject(i);
          if (localObject4 != null)
          {
            str = ((JSONObject)localObject4).optString("banner_type");
            localObject4 = ((JSONObject)localObject4).optString("banner_template_id");
            ae.i("MicroMsg.WalletBulletin", "sceneid=" + str + "; contentid=" + (String)localObject4);
            if ((!bu.isNullOrNil(str)) && (!bu.isNullOrNil((String)localObject4)))
            {
              ((Map)localObject2).put(str, localObject4);
              ae.i("MicroMsg.WalletBulletin", "sceneid:" + str + " map contentid:" + (String)localObject4);
            }
          }
          i += 1;
        }
        k = paramJSONObject.length();
        i = j;
        while (i < k)
        {
          localObject3 = paramJSONObject.optJSONObject(i);
          if (localObject3 != null) {
            localHashMap.put(((JSONObject)localObject3).optString("banner_template_id"), Integer.valueOf(i));
          }
          i += 1;
        }
        if (((Map)localObject2).size() > 0)
        {
          localObject3 = ((Map)localObject2).keySet().iterator();
          while (((Iterator)localObject3).hasNext())
          {
            str = (String)((Iterator)localObject3).next();
            localObject4 = (String)((Map)localObject2).get(str);
            if (localHashMap.containsKey(localObject4))
            {
              ae.i("MicroMsg.WalletBulletin", "find contentid:" + (String)localObject4 + "in contentMap");
              localObject4 = paramJSONObject.optJSONObject(((Integer)localHashMap.get(localObject4)).intValue());
              y localy = new y();
              localy.field_bulletin_scene = str;
              localy.field_bulletin_content = ((JSONObject)localObject4).optString("content");
              localy.field_bulletin_url = ((JSONObject)localObject4).optString("url");
              ((e)localObject1).insert(localy);
            }
            else
            {
              ae.e("MicroMsg.WalletBulletin", "can not find contentid:" + (String)localObject4 + "in contentMap");
            }
          }
        }
        AppMethodBeat.o(70414);
        return;
      }
      localObject1 = new StringBuilder("scenes==null?");
      if (localObject3 == null)
      {
        bool1 = true;
        localObject1 = ((StringBuilder)localObject1).append(bool1).append("  contents==null?");
        if (paramJSONObject != null) {
          break label537;
        }
      }
      label537:
      for (bool1 = bool2;; bool1 = false)
      {
        ae.e("MicroMsg.WalletBulletin", bool1);
        AppMethodBeat.o(70414);
        return;
        bool1 = false;
        break;
      }
    }
    Object localObject2 = new StringBuilder("json==null?");
    if (paramJSONObject == null)
    {
      bool1 = true;
      paramJSONObject = ((StringBuilder)localObject2).append(bool1).append("  stg==null?");
      if (localObject1 != null) {
        break label609;
      }
    }
    label609:
    for (boolean bool1 = bool3;; bool1 = false)
    {
      ae.e("MicroMsg.WalletBulletin", bool1);
      AppMethodBeat.o(70414);
      return;
      bool1 = false;
      break;
    }
  }
  
  public final c.a getDBInfo()
  {
    return info;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet_core.model.y
 * JD-Core Version:    0.7.0.1
 */