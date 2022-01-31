package com.tencent.tencentmap.mapsdk.a;

import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import com.tencent.map.lib.util.StringUtil;

public abstract class q
{
  protected SharedPreferences a = null;
  
  public String a(String paramString)
  {
    if (this.a == null) {
      return null;
    }
    return this.a.getString(paramString, null);
  }
  
  public boolean a()
  {
    return a(new String[] { "mapConfigVersion", "poiIconVersion", "mapIconVersion", "rttConfigVersion", "mapConfigIndoorVersion", "mapPoiIconIndoorVersion", "closeRoadSytleNomalModeVersion", "closeRoadStyleTrafficModeVersion", "offlineCityListVersion", "mapConfigZipMd5", "mapPoiIconZipMd5", "mapIconZipMd5", "rttConfigMd5", "mapConfigIndoorMd5", "poiIconIndoorMd5", "closeRoadSytleNomalModeMd5", "closeRoadStyleTrafficModeMd5", "offlineCityListMd5" });
  }
  
  public boolean a(String paramString, int paramInt)
  {
    if (this.a == null) {
      return false;
    }
    return this.a.edit().putInt(paramString, paramInt).commit();
  }
  
  public boolean a(String paramString, long paramLong)
  {
    if (this.a == null) {
      return false;
    }
    return this.a.edit().putLong(paramString, paramLong).commit();
  }
  
  public boolean a(String paramString1, String paramString2)
  {
    if (this.a == null) {
      return false;
    }
    return this.a.edit().putString(paramString1, paramString2).commit();
  }
  
  public boolean a(String paramString, boolean paramBoolean)
  {
    if (this.a == null) {
      return false;
    }
    return this.a.edit().putBoolean(paramString, paramBoolean).commit();
  }
  
  public boolean a(String[] paramArrayOfString)
  {
    int i = 0;
    if (this.a == null) {
      return false;
    }
    SharedPreferences.Editor localEditor = this.a.edit();
    int j = paramArrayOfString.length;
    while (i < j)
    {
      localEditor.remove(paramArrayOfString[i]);
      i += 1;
    }
    return localEditor.commit();
  }
  
  public int b(String paramString)
  {
    if (this.a == null) {
      return -1;
    }
    return this.a.getInt(paramString, -1);
  }
  
  public String b()
  {
    int i = b("mapConfigVersion");
    String str3 = a("mapConfigZipMd5");
    String str1 = String.valueOf(b("mapConfigIndoorPremiumVersion"));
    Object localObject2 = a("mapConfigIndoorPremiumMd5");
    int j = b("mapConfigIndoorVersion");
    Object localObject1 = a("mapConfigIndoorMd5");
    if (!StringUtil.isEmpty((String)localObject2)) {}
    String str2;
    for (localObject1 = "indoormap_config_premium";; localObject1 = str2)
    {
      return String.format("mapconfig-%s-%s,%s-%s-%s", new Object[] { String.valueOf(i), str3, localObject1, str1, localObject2 });
      str2 = "indoormap_config";
      localObject2 = localObject1;
      str1 = String.valueOf(j);
    }
  }
  
  public boolean c(String paramString)
  {
    if (this.a == null) {
      return false;
    }
    return this.a.getBoolean(paramString, false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.tencentmap.mapsdk.a.q
 * JD-Core Version:    0.7.0.1
 */