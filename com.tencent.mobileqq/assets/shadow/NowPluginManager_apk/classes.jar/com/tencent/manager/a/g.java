package com.tencent.manager.a;

import java.util.HashMap;
import org.json.JSONArray;
import org.json.JSONObject;

public class g
{
  public static int a = 1;
  public boolean b;
  public boolean c;
  public int d;
  public int e;
  public int f;
  public int g;
  public int h = 1;
  private HashMap<Integer, a> i = new HashMap();
  private HashMap<Integer, a> j = new HashMap();
  
  private a a(JSONObject paramJSONObject)
  {
    a locala = new a();
    locala.a = Integer.parseInt(paramJSONObject.getString("type"));
    locala.b = paramJSONObject.getString("packageName");
    locala.c = paramJSONObject.getString("url");
    locala.d = paramJSONObject.getString("hash");
    locala.f = Integer.parseInt(paramJSONObject.getString("size"));
    locala.e = paramJSONObject.getBoolean("enablepreload");
    locala.g = Integer.parseInt(paramJSONObject.getString("downloadengine"));
    return locala;
  }
  
  private void a(HashMap<Integer, a> paramHashMap, JSONObject paramJSONObject)
  {
    paramJSONObject = paramJSONObject.getJSONArray("content");
    int k = 0;
    while (k < paramJSONObject.length())
    {
      a locala = a(paramJSONObject.getJSONObject(k));
      paramHashMap.put(Integer.valueOf(locala.a), locala);
      k += 1;
    }
  }
  
  public int a()
  {
    return this.e;
  }
  
  public a a(String paramString, int paramInt)
  {
    a locala = null;
    if (paramString.equals(String.valueOf(this.e))) {
      locala = (a)this.j.get(Integer.valueOf(paramInt));
    }
    for (;;)
    {
      paramString = locala;
      if (locala == null) {
        paramString = (a)this.j.get(Integer.valueOf(paramInt));
      }
      return paramString;
      if (paramString.equals(String.valueOf(this.f))) {
        locala = (a)this.i.get(Integer.valueOf(paramInt));
      }
    }
  }
  
  public String a(String paramString)
  {
    try
    {
      paramString = new JSONObject(paramString);
      this.g = paramString.getInt("errCode");
      paramString = paramString.getJSONObject("data");
      this.b = paramString.getBoolean("curversionexist");
      this.c = paramString.getBoolean("newversionexist");
      this.d = paramString.getInt("lazytime");
      try
      {
        this.h = paramString.getInt("load_retry");
        this.f = Integer.parseInt(paramString.getString("curversionno"));
        JSONObject localJSONObject;
        if (this.b)
        {
          localJSONObject = paramString.getJSONObject("curversion");
          a(this.i, localJSONObject);
        }
        if (this.c)
        {
          localJSONObject = paramString.getJSONObject("targetversion");
          a(this.j, localJSONObject);
          this.e = Integer.parseInt(paramString.getString("newversionno"));
        }
      }
      catch (Exception paramString)
      {
        return paramString.toString();
      }
      paramString = paramString.getJSONObject("curversion");
      a(this.j, paramString);
    }
    catch (Exception paramString)
    {
      return paramString.toString();
    }
    return null;
  }
  
  public class a
  {
    public int a;
    public String b;
    public String c;
    public String d;
    public boolean e;
    public int f;
    public int g;
    
    public a() {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\assets\shadow\NowPluginManager_apk\classes.jar
 * Qualified Name:     com.tencent.manager.a.g
 * JD-Core Version:    0.7.0.1
 */