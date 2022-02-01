package com.tencent.mm.plugin.wallet_core.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.autogen.b.ii;
import com.tencent.mm.plugin.wallet_core.d.e;
import com.tencent.mm.protocal.protobuf.dus;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.storage.IAutoDBItem;
import com.tencent.mm.sdk.storage.IAutoDBItem.MAutoDBInfo;
import com.tencent.mm.wallet_core.ui.i;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import org.json.JSONArray;
import org.json.JSONObject;

public class z
  extends ii
{
  public static IAutoDBItem.MAutoDBInfo info;
  
  static
  {
    AppMethodBeat.i(70415);
    info = ii.aJm();
    AppMethodBeat.o(70415);
  }
  
  public static void cu(JSONObject paramJSONObject)
  {
    AppMethodBeat.i(70414);
    e locale = u.iiG();
    if ((paramJSONObject != null) && (locale != null))
    {
      Object localObject3 = paramJSONObject.optJSONArray("banner_map");
      localObject1 = paramJSONObject.optJSONArray("banner_content_array");
      Object localObject2 = paramJSONObject.optJSONArray("notice_item_array");
      paramJSONObject = new HashMap();
      HashMap localHashMap1 = new HashMap();
      HashMap localHashMap2 = new HashMap();
      int j;
      int i;
      Object localObject5;
      Object localObject4;
      if (localObject3 != null)
      {
        j = ((JSONArray)localObject3).length();
        i = 0;
        while (i < j)
        {
          localObject5 = ((JSONArray)localObject3).optJSONObject(i);
          if (localObject5 != null)
          {
            localObject4 = ((JSONObject)localObject5).optString("banner_type");
            localObject5 = ((JSONObject)localObject5).optString("banner_template_id");
            Log.i("MicroMsg.WalletBulletin", "sceneid=" + (String)localObject4 + "; contentid=" + (String)localObject5);
            if ((!Util.isNullOrNil((String)localObject4)) && (!Util.isNullOrNil((String)localObject5)))
            {
              paramJSONObject.put(localObject4, localObject5);
              Log.i("MicroMsg.WalletBulletin", "sceneid:" + (String)localObject4 + " map contentid:" + (String)localObject5);
            }
          }
          i += 1;
        }
      }
      if (localObject1 != null)
      {
        j = ((JSONArray)localObject1).length();
        i = 0;
        while (i < j)
        {
          localObject3 = ((JSONArray)localObject1).optJSONObject(i);
          if (localObject3 != null) {
            localHashMap1.put(((JSONObject)localObject3).optString("banner_template_id"), Integer.valueOf(i));
          }
          i += 1;
        }
      }
      if (localObject2 != null)
      {
        i = 0;
        while (i < ((JSONArray)localObject2).length())
        {
          localObject3 = i.cR(((JSONArray)localObject2).optJSONObject(i));
          if (localObject3 != null) {
            localHashMap2.put(((dus)localObject3).YSS, localObject3);
          }
          i += 1;
        }
      }
      if (paramJSONObject.size() > 0)
      {
        localObject2 = paramJSONObject.keySet().iterator();
        while (((Iterator)localObject2).hasNext())
        {
          localObject5 = (String)((Iterator)localObject2).next();
          localObject4 = (String)paramJSONObject.get(localObject5);
          localObject3 = new z();
          ((z)localObject3).field_bulletin_scene = ((String)localObject5);
          if (localHashMap2.containsKey(localObject4))
          {
            localObject5 = (dus)localHashMap2.get(localObject4);
            if (localObject5 != null)
            {
              ((z)localObject3).field_is_show_notice = ((dus)localObject5).abaE;
              ((z)localObject3).field_wording = ((dus)localObject5).wording;
              ((z)localObject3).field_jump_url = ((dus)localObject5).jump_url;
              ((z)localObject3).field_left_icon = ((dus)localObject5).left_icon;
              ((z)localObject3).field_notice_id = ((dus)localObject5).YSS;
              ((z)localObject3).field_type = 2;
            }
          }
          if (localHashMap1.containsKey(localObject4))
          {
            Log.i("MicroMsg.WalletBulletin", "find contentid:" + (String)localObject4 + "in contentMap");
            localObject4 = ((JSONArray)localObject1).optJSONObject(((Integer)localHashMap1.get(localObject4)).intValue());
            ((z)localObject3).field_bulletin_content = ((JSONObject)localObject4).optString("content");
            ((z)localObject3).field_bulletin_url = ((JSONObject)localObject4).optString("url");
            locale.insert((IAutoDBItem)localObject3);
          }
        }
      }
      AppMethodBeat.o(70414);
      return;
    }
    Object localObject1 = new StringBuilder("json==null?");
    if (paramJSONObject == null)
    {
      bool = true;
      paramJSONObject = ((StringBuilder)localObject1).append(bool).append("  stg==null?");
      if (locale != null) {
        break label649;
      }
    }
    label649:
    for (boolean bool = true;; bool = false)
    {
      Log.e("MicroMsg.WalletBulletin", bool);
      AppMethodBeat.o(70414);
      return;
      bool = false;
      break;
    }
  }
  
  public IAutoDBItem.MAutoDBInfo getDBInfo()
  {
    return info;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet_core.model.z
 * JD-Core Version:    0.7.0.1
 */