package com.tencent.shadow.core.b.a;

import java.io.File;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONObject;

public class j
{
  public int a;
  public int[] b;
  public String c;
  public String d;
  public a e;
  public a f;
  public Map<String, b> g = new HashMap();
  public File h;
  
  private static a a(JSONObject paramJSONObject, File paramFile)
  {
    String str = paramJSONObject.getString("apkName");
    paramJSONObject = paramJSONObject.getString("hash");
    return new a(new File(paramFile, str), paramJSONObject);
  }
  
  public static j a(String paramString, File paramFile)
  {
    Object localObject1 = new JSONObject(paramString);
    paramString = new j();
    paramString.a = ((JSONObject)localObject1).getInt("version");
    Object localObject2 = ((JSONObject)localObject1).optJSONArray("compact_version");
    int j = 0;
    int i;
    if ((localObject2 != null) && (((JSONArray)localObject2).length() > 0))
    {
      paramString.b = new int[((JSONArray)localObject2).length()];
      i = 0;
      while (i < ((JSONArray)localObject2).length())
      {
        paramString.b[i] = ((JSONArray)localObject2).getInt(i);
        i += 1;
      }
    }
    paramString.c = ((JSONObject)localObject1).getString("UUID");
    paramString.d = ((JSONObject)localObject1).getString("UUID_NickName");
    localObject2 = ((JSONObject)localObject1).optJSONObject("pluginLoader");
    if (localObject2 != null) {
      paramString.e = a((JSONObject)localObject2, paramFile);
    }
    localObject2 = ((JSONObject)localObject1).optJSONObject("runtime");
    if (localObject2 != null) {
      paramString.f = a((JSONObject)localObject2, paramFile);
    }
    localObject1 = ((JSONObject)localObject1).optJSONArray("plugins");
    if ((localObject1 != null) && (((JSONArray)localObject1).length() > 0))
    {
      i = j;
      while (i < ((JSONArray)localObject1).length())
      {
        localObject2 = ((JSONArray)localObject1).getJSONObject(i);
        String str = ((JSONObject)localObject2).getString("partKey");
        paramString.g.put(str, b((JSONObject)localObject2, paramFile));
        i += 1;
      }
    }
    paramString.h = paramFile;
    return paramString;
  }
  
  private static String[] a(JSONObject paramJSONObject, String paramString)
  {
    JSONArray localJSONArray = paramJSONObject.optJSONArray(paramString);
    int i = 0;
    if (localJSONArray != null)
    {
      paramString = new String[localJSONArray.length()];
      for (;;)
      {
        paramJSONObject = paramString;
        if (i >= localJSONArray.length()) {
          break;
        }
        paramString[i] = localJSONArray.getString(i);
        i += 1;
      }
    }
    paramJSONObject = new String[0];
    return paramJSONObject;
  }
  
  private static b b(JSONObject paramJSONObject, File paramFile)
  {
    return new b(paramJSONObject.optString("businessName", ""), a(paramJSONObject, paramFile), a(paramJSONObject, "dependsOn"), a(paramJSONObject, "hostWhiteList"));
  }
  
  static class a
  {
    File a;
    String b;
    
    a(File paramFile, String paramString)
    {
      this.a = paramFile;
      this.b = paramString;
    }
  }
  
  static class b
    extends j.a
  {
    final String[] c;
    final String[] d;
    final String e;
    
    b(String paramString, j.a parama, String[] paramArrayOfString1, String[] paramArrayOfString2)
    {
      this(paramString, parama.a, parama.b, paramArrayOfString1, paramArrayOfString2);
    }
    
    b(String paramString1, File paramFile, String paramString2, String[] paramArrayOfString1, String[] paramArrayOfString2)
    {
      super(paramString2);
      this.e = paramString1;
      this.c = paramArrayOfString1;
      this.d = paramArrayOfString2;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\assets\live_shopping_manager_apk\classes.jar
 * Qualified Name:     com.tencent.shadow.core.b.a.j
 * JD-Core Version:    0.7.0.1
 */