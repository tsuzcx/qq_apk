package com.tencent.mm.plugin.product.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;

public final class n
{
  public String name;
  public List<n.a> puH;
  
  public n()
  {
    AppMethodBeat.i(44007);
    this.puH = new ArrayList();
    AppMethodBeat.o(44007);
  }
  
  public static List<n> parse(String paramString)
  {
    AppMethodBeat.i(44008);
    ArrayList localArrayList = new ArrayList();
    try
    {
      paramString = new JSONObject(paramString).getJSONArray("group_list");
      int k = paramString.length();
      int i = 0;
      while (i < k)
      {
        Object localObject = paramString.getJSONObject(i);
        n localn = new n();
        localn.name = ((JSONObject)localObject).getString("name");
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
          localn.puH.add(locala);
          j += 1;
        }
        localArrayList.add(localn);
        i += 1;
      }
      AppMethodBeat.o(44008);
    }
    catch (Exception paramString)
    {
      AppMethodBeat.o(44008);
      return null;
    }
    return localArrayList;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.product.b.n
 * JD-Core Version:    0.7.0.1
 */