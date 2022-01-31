package com.tencent.tencentmap.mapsdk.a;

import android.content.Context;
import com.tencent.map.lib.util.StringUtil;
import java.io.File;
import java.util.HashMap;
import java.util.Map;

public class u
  extends s
{
  private static Map<String, s> b = new HashMap();
  
  private u(Context paramContext, String paramString)
  {
    this.a = paramContext.getSharedPreferences("Tencent_MapSDK_SUB_CONFIG_" + paramString, 0);
  }
  
  public static s a(Context paramContext, String paramString)
  {
    if (StringUtil.isEmpty(paramString)) {
      return w.a(paramContext);
    }
    if (b.get(paramString) == null) {
      try
      {
        if (b.get(paramString) == null)
        {
          paramContext = new u(paramContext, paramString);
          b.put(paramString, paramContext);
          return paramContext;
        }
      }
      finally {}
    }
    return (s)b.get(paramString);
  }
  
  public static void a(Context paramContext)
  {
    try
    {
      paramContext = new File(paramContext.getFilesDir().getParent() + File.separator + "shared_prefs").listFiles();
      int j = paramContext.length;
      int i = 0;
      while (i < j)
      {
        Object localObject = paramContext[i];
        if (localObject.getName().startsWith("Tencent_MapSDK_SUB_CONFIG")) {
          localObject.delete();
        }
        i += 1;
      }
      return;
    }
    catch (Exception paramContext) {}
  }
  
  public static void b()
  {
    if (b != null) {
      b.clear();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.tencentmap.mapsdk.a.u
 * JD-Core Version:    0.7.0.1
 */