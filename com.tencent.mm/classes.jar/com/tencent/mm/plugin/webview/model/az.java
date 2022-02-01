package com.tencent.mm.plugin.webview.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bu;
import java.util.HashMap;
import java.util.Map;

public final class az
{
  private static Map<String, String> Enl;
  
  static
  {
    AppMethodBeat.i(79101);
    Enl = new HashMap();
    AppMethodBeat.o(79101);
  }
  
  public static String aJe(String paramString)
  {
    AppMethodBeat.i(79099);
    ae.i("MicroMsg.WebviewSharedUrlCache", "rawUrl:[%s]", new Object[] { paramString });
    if (bu.isNullOrNil(paramString))
    {
      ae.e("MicroMsg.WebviewSharedUrlCache", "rawUrl is null");
      AppMethodBeat.o(79099);
      return null;
    }
    Object localObject2 = (String)Enl.get(paramString);
    Object localObject1 = localObject2;
    int i;
    if (bu.isNullOrNil((String)localObject2))
    {
      i = paramString.indexOf("#");
      if (i >= 0) {
        break label145;
      }
    }
    label145:
    for (localObject1 = paramString;; localObject1 = paramString.substring(0, i))
    {
      localObject1 = (String)Enl.get(localObject1);
      localObject2 = localObject1;
      if (bu.isNullOrNil((String)localObject1))
      {
        localObject2 = localObject1;
        if (paramString.startsWith("https://mp.weixin.qq.com/"))
        {
          localObject1 = paramString.replaceFirst("https://", "http://");
          localObject2 = (String)Enl.get(localObject1);
        }
      }
      if (!bu.isNullOrNil((String)localObject2)) {
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
    Enl.clear();
    AppMethodBeat.o(79100);
  }
  
  public static void lc(String paramString1, String paramString2)
  {
    AppMethodBeat.i(79098);
    ae.i("MicroMsg.WebviewSharedUrlCache", "rawurl:[%s], shareUrl:[%s]", new Object[] { paramString1, paramString2 });
    if ((bu.isNullOrNil(paramString1)) || (bu.isNullOrNil(paramString2)))
    {
      ae.e("MicroMsg.WebviewSharedUrlCache", "rawurl is null or share url is null");
      AppMethodBeat.o(79098);
      return;
    }
    if (Enl.containsKey(paramString1))
    {
      ae.i("MicroMsg.WebviewSharedUrlCache", "has add this rawurl");
      AppMethodBeat.o(79098);
      return;
    }
    Enl.put(paramString1, paramString2);
    AppMethodBeat.o(79098);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.model.az
 * JD-Core Version:    0.7.0.1
 */