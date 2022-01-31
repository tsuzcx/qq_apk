package com.tencent.tencentmap.mapsdk.a;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Arrays;
import java.util.LinkedHashSet;
import java.util.Set;

public class y
{
  private static volatile y a;
  private SharedPreferences b;
  
  private y(Context paramContext)
  {
    AppMethodBeat.i(150406);
    this.b = paramContext.getSharedPreferences("com.tencent.tencentmap.vector.dynamic", 0);
    AppMethodBeat.o(150406);
  }
  
  public static y a(Context paramContext)
  {
    AppMethodBeat.i(150407);
    if (a == null) {}
    try
    {
      if (a == null) {
        a = new y(paramContext);
      }
      paramContext = a;
      AppMethodBeat.o(150407);
      return paramContext;
    }
    finally
    {
      AppMethodBeat.o(150407);
    }
  }
  
  public boolean a(String paramString)
  {
    AppMethodBeat.i(150410);
    if (paramString == null)
    {
      AppMethodBeat.o(150410);
      return false;
    }
    if (this.b.getString("supportVectorOtaVersions", null) == null)
    {
      bool = this.b.edit().putString("supportVectorOtaVersions", paramString).commit();
      AppMethodBeat.o(150410);
      return bool;
    }
    Object localObject = a();
    if (localObject == null)
    {
      AppMethodBeat.o(150410);
      return false;
    }
    localObject = new LinkedHashSet(Arrays.asList((Object[])localObject));
    ((Set)localObject).add(paramString);
    boolean bool = a((String[])((Set)localObject).toArray(new String[((Set)localObject).size()]));
    AppMethodBeat.o(150410);
    return bool;
  }
  
  public boolean a(String[] paramArrayOfString)
  {
    int i = 0;
    AppMethodBeat.i(150408);
    if ((paramArrayOfString == null) || (paramArrayOfString.length == 0))
    {
      AppMethodBeat.o(150408);
      return false;
    }
    StringBuffer localStringBuffer = new StringBuffer();
    while (i < paramArrayOfString.length - 1)
    {
      localStringBuffer.append(paramArrayOfString[i] + ";");
      i += 1;
    }
    localStringBuffer.append(paramArrayOfString[(paramArrayOfString.length - 1)]);
    boolean bool = this.b.edit().putString("supportVectorOtaVersions", localStringBuffer.toString()).commit();
    AppMethodBeat.o(150408);
    return bool;
  }
  
  public String[] a()
  {
    AppMethodBeat.i(150409);
    Object localObject = this.b.getString("supportVectorOtaVersions", null);
    if (localObject == null)
    {
      AppMethodBeat.o(150409);
      return null;
    }
    localObject = ((String)localObject).split(";");
    AppMethodBeat.o(150409);
    return localObject;
  }
  
  public String b()
  {
    AppMethodBeat.i(150412);
    String str = this.b.getString("vectorMapConfigMd5", null);
    AppMethodBeat.o(150412);
    return str;
  }
  
  public boolean b(String paramString)
  {
    AppMethodBeat.i(150411);
    boolean bool = this.b.edit().putString("vectorMapConfigMd5", paramString).commit();
    AppMethodBeat.o(150411);
    return bool;
  }
  
  public String c()
  {
    AppMethodBeat.i(150414);
    String str = this.b.getString("vectorMapPoiIconMd5", null);
    AppMethodBeat.o(150414);
    return str;
  }
  
  public boolean c(String paramString)
  {
    AppMethodBeat.i(150413);
    boolean bool = this.b.edit().putString("vectorMapPoiIconMd5", paramString).commit();
    AppMethodBeat.o(150413);
    return bool;
  }
  
  public String d()
  {
    AppMethodBeat.i(150415);
    String str = this.b.getString("dynamicMapSdkVectorVersion", "");
    AppMethodBeat.o(150415);
    return str;
  }
  
  public boolean d(String paramString)
  {
    AppMethodBeat.i(150416);
    boolean bool = this.b.edit().putString("dynamicMapSdkVectorVersion", paramString).commit();
    AppMethodBeat.o(150416);
    return bool;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.tencentmap.mapsdk.a.y
 * JD-Core Version:    0.7.0.1
 */