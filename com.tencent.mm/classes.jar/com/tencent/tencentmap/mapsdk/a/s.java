package com.tencent.tencentmap.mapsdk.a;

import android.content.Context;
import com.tencent.map.lib.util.StringUtil;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.io.File;
import java.util.HashMap;
import java.util.Map;

public class s
  extends q
{
  private static Map<String, q> b;
  
  static
  {
    AppMethodBeat.i(147073);
    b = new HashMap();
    AppMethodBeat.o(147073);
  }
  
  private s(Context paramContext, String paramString)
  {
    AppMethodBeat.i(147070);
    this.a = paramContext.getSharedPreferences("Tencent_MapSDK_SUB_CONFIG_".concat(String.valueOf(paramString)), 0);
    AppMethodBeat.o(147070);
  }
  
  public static q a(Context paramContext, String paramString)
  {
    AppMethodBeat.i(147069);
    if (StringUtil.isEmpty(paramString))
    {
      paramContext = u.a(paramContext);
      AppMethodBeat.o(147069);
      return paramContext;
    }
    if (b.get(paramString) == null) {}
    try
    {
      if (b.get(paramString) == null)
      {
        paramContext = new s(paramContext, paramString);
        b.put(paramString, paramContext);
        return paramContext;
      }
      paramContext = (q)b.get(paramString);
      AppMethodBeat.o(147069);
      return paramContext;
    }
    finally
    {
      AppMethodBeat.o(147069);
    }
  }
  
  public static void a(Context paramContext)
  {
    AppMethodBeat.i(147071);
    try
    {
      paramContext = new File(paramContext.getFilesDir().getParent() + File.separator + "shared_prefs").listFiles();
      if (paramContext == null)
      {
        AppMethodBeat.o(147071);
        return;
      }
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
      AppMethodBeat.o(147071);
      return;
    }
    catch (Exception paramContext)
    {
      AppMethodBeat.o(147071);
    }
  }
  
  public static void c()
  {
    AppMethodBeat.i(147072);
    if (b != null) {
      b.clear();
    }
    AppMethodBeat.o(147072);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.tencentmap.mapsdk.a.s
 * JD-Core Version:    0.7.0.1
 */