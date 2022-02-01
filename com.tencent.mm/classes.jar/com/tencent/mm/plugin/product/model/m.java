package com.tencent.mm.plugin.product.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;

public final class m
{
  public List<a> Mcs;
  public String name;
  
  public m()
  {
    AppMethodBeat.i(66913);
    this.Mcs = new ArrayList();
    AppMethodBeat.o(66913);
  }
  
  public static List<m> asJ(String paramString)
  {
    AppMethodBeat.i(66914);
    ArrayList localArrayList = new ArrayList();
    try
    {
      paramString = new JSONObject(paramString).getJSONArray("group_list");
      int k = paramString.length();
      int i = 0;
      while (i < k)
      {
        Object localObject = paramString.getJSONObject(i);
        m localm = new m();
        localm.name = ((JSONObject)localObject).getString("name");
        localObject = ((JSONObject)localObject).getJSONArray("item_list");
        int m = ((JSONArray)localObject).length();
        int j = 0;
        while (j < m)
        {
          JSONObject localJSONObject = ((JSONArray)localObject).getJSONObject(j);
          a locala = new a();
          locala.title = localJSONObject.getString("title");
          locala.type = localJSONObject.getInt("jump_type");
          locala.data = localJSONObject.getString("native_url_args");
          locala.iconUrl = localJSONObject.getString("icon_url");
          locala.url = localJSONObject.getString("h5_url");
          localm.Mcs.add(locala);
          j += 1;
        }
        localArrayList.add(localm);
        i += 1;
      }
      AppMethodBeat.o(66914);
    }
    catch (Exception paramString)
    {
      AppMethodBeat.o(66914);
      return null;
    }
    return localArrayList;
  }
  
  public static final class a
  {
    public String data;
    public String iconUrl;
    public String title;
    public int type;
    public String url;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.product.model.m
 * JD-Core Version:    0.7.0.1
 */