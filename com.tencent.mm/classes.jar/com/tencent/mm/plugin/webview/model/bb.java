package com.tencent.mm.plugin.webview.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.webview.c.i;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.platformtools.WeChatHosts;
import java.util.HashMap;
import java.util.Map;

public final class bb
{
  private static Map<String, String> PWG;
  
  static
  {
    AppMethodBeat.i(79101);
    PWG = new HashMap();
    AppMethodBeat.o(79101);
  }
  
  public static String bld(String paramString)
  {
    AppMethodBeat.i(79099);
    Log.i("MicroMsg.WebviewSharedUrlCache", "rawUrl:[%s]", new Object[] { paramString });
    if (Util.isNullOrNil(paramString))
    {
      Log.e("MicroMsg.WebviewSharedUrlCache", "rawUrl is null");
      AppMethodBeat.o(79099);
      return null;
    }
    Object localObject2 = (String)PWG.get(paramString);
    Object localObject1 = localObject2;
    int i;
    if (Util.isNullOrNil((String)localObject2))
    {
      i = paramString.indexOf("#");
      if (i >= 0) {
        break label169;
      }
    }
    label169:
    for (localObject1 = paramString;; localObject1 = paramString.substring(0, i))
    {
      localObject1 = (String)PWG.get(localObject1);
      localObject2 = localObject1;
      if (Util.isNullOrNil((String)localObject1))
      {
        localObject2 = localObject1;
        if (paramString.startsWith("https://" + WeChatHosts.domainString(c.i.host_mp_weixin_qq_com) + "/"))
        {
          localObject1 = paramString.replaceFirst("https://", "http://");
          localObject2 = (String)PWG.get(localObject1);
        }
      }
      if (!Util.isNullOrNil((String)localObject2)) {
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
    PWG.clear();
    AppMethodBeat.o(79100);
  }
  
  public static void mB(String paramString1, String paramString2)
  {
    AppMethodBeat.i(79098);
    Log.i("MicroMsg.WebviewSharedUrlCache", "rawurl:[%s], shareUrl:[%s]", new Object[] { paramString1, paramString2 });
    if ((Util.isNullOrNil(paramString1)) || (Util.isNullOrNil(paramString2)))
    {
      Log.e("MicroMsg.WebviewSharedUrlCache", "rawurl is null or share url is null");
      AppMethodBeat.o(79098);
      return;
    }
    if (PWG.containsKey(paramString1))
    {
      Log.i("MicroMsg.WebviewSharedUrlCache", "has add this rawurl");
      AppMethodBeat.o(79098);
      return;
    }
    PWG.put(paramString1, paramString2);
    AppMethodBeat.o(79098);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.model.bb
 * JD-Core Version:    0.7.0.1
 */