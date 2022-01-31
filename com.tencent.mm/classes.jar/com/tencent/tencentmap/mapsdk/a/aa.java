package com.tencent.tencentmap.mapsdk.a;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import java.util.Arrays;
import java.util.LinkedHashSet;
import java.util.Set;

public class aa
{
  private static volatile aa a;
  private SharedPreferences b;
  
  private aa(Context paramContext)
  {
    this.b = paramContext.getSharedPreferences("com.tencent.tencentmap.vector.dynamic", 0);
  }
  
  public static aa a(Context paramContext)
  {
    if (a == null) {}
    try
    {
      if (a == null) {
        a = new aa(paramContext);
      }
      return a;
    }
    finally {}
  }
  
  public boolean a(String paramString)
  {
    if (paramString == null) {}
    do
    {
      return false;
      if (this.b.getString("supportVectorOtaVersions", null) == null) {
        return this.b.edit().putString("supportVectorOtaVersions", paramString).commit();
      }
      localObject = a();
    } while (localObject == null);
    Object localObject = new LinkedHashSet(Arrays.asList((Object[])localObject));
    ((Set)localObject).add(paramString);
    return a((String[])((Set)localObject).toArray(new String[((Set)localObject).size()]));
  }
  
  public boolean a(String[] paramArrayOfString)
  {
    int i = 0;
    if ((paramArrayOfString == null) || (paramArrayOfString.length == 0)) {
      return false;
    }
    StringBuffer localStringBuffer = new StringBuffer();
    while (i < paramArrayOfString.length - 1)
    {
      localStringBuffer.append(paramArrayOfString[i] + ";");
      i += 1;
    }
    localStringBuffer.append(paramArrayOfString[(paramArrayOfString.length - 1)]);
    return this.b.edit().putString("supportVectorOtaVersions", localStringBuffer.toString()).commit();
  }
  
  public String[] a()
  {
    String str = this.b.getString("supportVectorOtaVersions", null);
    if (str == null) {
      return null;
    }
    return str.split(";");
  }
  
  public String b()
  {
    return this.b.getString("vectorMapConfigMd5", null);
  }
  
  public boolean b(String paramString)
  {
    return this.b.edit().putString("vectorMapConfigMd5", paramString).commit();
  }
  
  public String c()
  {
    return this.b.getString("vectorMapPoiIconMd5", null);
  }
  
  public boolean c(String paramString)
  {
    return this.b.edit().putString("vectorMapPoiIconMd5", paramString).commit();
  }
  
  public String d()
  {
    return this.b.getString("dynamicMapSdkVectorVersion", "");
  }
  
  public boolean d(String paramString)
  {
    return this.b.edit().putString("dynamicMapSdkVectorVersion", paramString).commit();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.tencentmap.mapsdk.a.aa
 * JD-Core Version:    0.7.0.1
 */