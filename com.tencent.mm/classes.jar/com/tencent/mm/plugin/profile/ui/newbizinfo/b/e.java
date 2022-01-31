package com.tencent.mm.plugin.profile.ui.newbizinfo.b;

import com.tencent.mm.sdk.platformtools.y;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;

public final class e
{
  public String ceb;
  public int egq;
  public String id;
  public String key;
  public String name;
  public List<e> nap;
  public int type;
  public String value;
  
  public static e af(JSONObject paramJSONObject)
  {
    if (paramJSONObject == null)
    {
      y.e("MicroMsg.ServiceInfo", "json is null, err");
      paramJSONObject = null;
    }
    for (;;)
    {
      return paramJSONObject;
      locale = new e();
      try
      {
        locale.id = paramJSONObject.optString("id", "");
        locale.type = paramJSONObject.optInt("type");
        locale.name = paramJSONObject.optString("name");
        locale.key = paramJSONObject.optString("key");
        locale.value = paramJSONObject.optString("value");
        locale.egq = paramJSONObject.optInt("acttype", -1);
        locale.ceb = paramJSONObject.optString("native_url");
        locale.nap = new ArrayList();
        JSONArray localJSONArray = paramJSONObject.optJSONArray("sub_button_list");
        paramJSONObject = locale;
        if (localJSONArray == null) {
          continue;
        }
        int i = 0;
        for (;;)
        {
          paramJSONObject = locale;
          if (i >= localJSONArray.length()) {
            break;
          }
          paramJSONObject = af(localJSONArray.optJSONObject(i));
          if (paramJSONObject != null) {
            locale.nap.add(paramJSONObject);
          }
          i += 1;
        }
        return locale;
      }
      catch (Exception paramJSONObject)
      {
        y.b("MicroMsg.ServiceInfo", "", new Object[] { paramJSONObject });
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.profile.ui.newbizinfo.b.e
 * JD-Core Version:    0.7.0.1
 */