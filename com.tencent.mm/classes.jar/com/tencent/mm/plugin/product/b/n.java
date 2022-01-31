package com.tencent.mm.plugin.product.b;

import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;

public final class n
{
  public List<n.a> mSB = new ArrayList();
  public String name;
  
  public static List<n> parse(String paramString)
  {
    ArrayList localArrayList = new ArrayList();
    try
    {
      JSONArray localJSONArray = new JSONObject(paramString).getJSONArray("group_list");
      int k = localJSONArray.length();
      int i = 0;
      for (;;)
      {
        paramString = localArrayList;
        if (i >= k) {
          break;
        }
        Object localObject = localJSONArray.getJSONObject(i);
        paramString = new n();
        paramString.name = ((JSONObject)localObject).getString("name");
        localObject = ((JSONObject)localObject).getJSONArray("item_list");
        int m = ((JSONArray)localObject).length();
        int j = 0;
        while (j < m)
        {
          JSONObject localJSONObject = ((JSONArray)localObject).getJSONObject(j);
          n.a locala = new n.a();
          locala.title = localJSONObject.getString("title");
          locala.type = localJSONObject.getInt("jump_type");
          locala.data = localJSONObject.getString("native_url_args");
          locala.iconUrl = localJSONObject.getString("icon_url");
          locala.url = localJSONObject.getString("h5_url");
          paramString.mSB.add(locala);
          j += 1;
        }
        localArrayList.add(paramString);
        i += 1;
      }
      return paramString;
    }
    catch (Exception paramString)
    {
      paramString = null;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.product.b.n
 * JD-Core Version:    0.7.0.1
 */