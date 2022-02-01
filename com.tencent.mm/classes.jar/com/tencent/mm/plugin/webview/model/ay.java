package com.tencent.mm.plugin.webview.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.bs;
import java.util.HashMap;
import java.util.Map;

public final class ay
{
  private static Map<String, String> CrI;
  
  static
  {
    AppMethodBeat.i(79101);
    CrI = new HashMap();
    AppMethodBeat.o(79101);
  }
  
  public static String aCl(String paramString)
  {
    AppMethodBeat.i(79099);
    ac.i("MicroMsg.WebviewSharedUrlCache", "rawUrl:[%s]", new Object[] { paramString });
    if (bs.isNullOrNil(paramString))
    {
      ac.e("MicroMsg.WebviewSharedUrlCache", "rawUrl is null");
      AppMethodBeat.o(79099);
      return null;
    }
    Object localObject2 = (String)CrI.get(paramString);
    Object localObject1 = localObject2;
    int i;
    if (bs.isNullOrNil((String)localObject2))
    {
      i = paramString.indexOf("#");
      if (i >= 0) {
        break label145;
      }
    }
    label145:
    for (localObject1 = paramString;; localObject1 = paramString.substring(0, i))
    {
      localObject1 = (String)CrI.get(localObject1);
      localObject2 = localObject1;
      if (bs.isNullOrNil((String)localObject1))
      {
        localObject2 = localObject1;
        if (paramString.startsWith("https://mp.weixin.qq.com/"))
        {
          localObject1 = paramString.replaceFirst("https://", "http://");
          localObject2 = (String)CrI.get(localObject1);
        }
      }
      if (!bs.isNullOrNil((String)localObject2)) {
        break;
      }
      AppMethodBeat.o(79099);
      return paramString;
    }
    AppMethodBeat.o(79099);
    return localObject2;
  }
  
  public static void clear()
  {
    AppMethodBeat.i(79100);
    CrI.clear();
    AppMethodBeat.o(79100);
  }
  
  public static void kx(String paramString1, String paramString2)
  {
    AppMethodBeat.i(79098);
    ac.i("MicroMsg.WebviewSharedUrlCache", "rawurl:[%s], shareUrl:[%s]", new Object[] { paramString1, paramString2 });
    if ((bs.isNullOrNil(paramString1)) || (bs.isNullOrNil(paramString2)))
    {
      ac.e("MicroMsg.WebviewSharedUrlCache", "rawurl is null or share url is null");
      AppMethodBeat.o(79098);
      return;
    }
    if (CrI.containsKey(paramString1))
    {
      ac.i("MicroMsg.WebviewSharedUrlCache", "has add this rawurl");
      AppMethodBeat.o(79098);
      return;
    }
    CrI.put(paramString1, paramString2);
    AppMethodBeat.o(79098);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.model.ay
 * JD-Core Version:    0.7.0.1
 */