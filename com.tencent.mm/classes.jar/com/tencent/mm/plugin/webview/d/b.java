package com.tencent.mm.plugin.webview.d;

import android.net.Uri;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.bs;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.Iterator;
import java.util.List;

public final class b
{
  private static String aOO(String paramString)
  {
    AppMethodBeat.i(79103);
    if (!com.tencent.mm.plugin.webview.luggage.c.b.Rp(paramString))
    {
      AppMethodBeat.o(79103);
      return null;
    }
    Object localObject1 = paramString;
    localObject2 = paramString;
    try
    {
      Object localObject3 = new URI(paramString);
      localObject1 = paramString;
      localObject2 = paramString;
      String str3 = bs.nullAsNil(((URI)localObject3).getScheme()).toLowerCase();
      localObject1 = paramString;
      localObject2 = paramString;
      String str4 = bs.nullAsNil(((URI)localObject3).getHost()).toLowerCase();
      localObject1 = paramString;
      localObject2 = paramString;
      boolean bool = bs.isNullOrNil(str4);
      if (bool)
      {
        AppMethodBeat.o(79103);
        return null;
      }
      localObject1 = paramString;
      localObject2 = paramString;
      int i;
      String str1;
      if (((URI)localObject3).getPort() == -1)
      {
        localObject1 = paramString;
        localObject2 = paramString;
        if (str3.equalsIgnoreCase("http"))
        {
          i = 80;
          localObject1 = paramString;
          localObject2 = paramString;
          if (!bs.isNullOrNil(((URI)localObject3).getQuery())) {
            break label326;
          }
          str1 = "";
          label144:
          localObject1 = paramString;
          localObject2 = paramString;
          if (!bs.isNullOrNil(((URI)localObject3).getFragment())) {
            break label356;
          }
        }
      }
      for (String str2 = "";; str2 = "#" + ((URI)localObject3).getFragment())
      {
        localObject1 = paramString;
        localObject2 = paramString;
        localObject3 = bs.nullAsNil(((URI)localObject3).getPath());
        localObject1 = paramString;
        localObject2 = paramString;
        str1 = str3 + "://" + str4 + ":" + i + "/" + (String)localObject3 + str1 + str2;
        paramString = str1;
        localObject1 = str1;
        localObject2 = str1;
        if (str1.endsWith("/"))
        {
          localObject1 = str1;
          localObject2 = str1;
          paramString = str1 + "/";
        }
        localObject1 = paramString;
        localObject2 = paramString;
        paramString = aTO(paramString);
        AppMethodBeat.o(79103);
        return paramString;
        i = 443;
        break;
        localObject1 = paramString;
        localObject2 = paramString;
        i = ((URI)localObject3).getPort();
        break;
        label326:
        localObject1 = paramString;
        localObject2 = paramString;
        str1 = "?" + ((URI)localObject3).getQuery();
        break label144;
        label356:
        localObject1 = paramString;
        localObject2 = paramString;
      }
      return localObject2;
    }
    catch (URISyntaxException paramString)
    {
      ac.e("MicroMsg.WebViewCacheUtils", "getFormattedHttpURL URISyntaxException : %s", new Object[] { paramString.getMessage() });
      AppMethodBeat.o(79103);
      return localObject1;
    }
    catch (Exception paramString)
    {
      ac.e("MicroMsg.WebViewCacheUtils", "getFormattedHttpURL normal : %s", new Object[] { paramString.getMessage() });
      AppMethodBeat.o(79103);
    }
  }
  
  private static String aTO(String paramString)
  {
    AppMethodBeat.i(79104);
    Uri localUri = Uri.parse(paramString);
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(localUri.getScheme()).append("://");
    localStringBuilder.append(localUri.getHost()).append(":").append(localUri.getPort());
    if (bs.gY(localUri.getPathSegments())) {
      localStringBuilder.append("/");
    }
    for (;;)
    {
      if (!bs.isNullOrNil(localUri.getQuery())) {
        localStringBuilder.append("?").append(localUri.getQuery());
      }
      if (!bs.isNullOrNil(localUri.getFragment())) {
        localStringBuilder.append("#").append(localUri.getFragment());
      }
      if (paramString.endsWith("/")) {
        localStringBuilder.append("/");
      }
      paramString = localStringBuilder.toString();
      AppMethodBeat.o(79104);
      return paramString;
      Iterator localIterator = localUri.getPathSegments().iterator();
      while (localIterator.hasNext())
      {
        String str = (String)localIterator.next();
        localStringBuilder.append("/").append(str);
      }
    }
  }
  
  public static String aTP(String paramString)
  {
    AppMethodBeat.i(79105);
    paramString = aOO(paramString);
    if (bs.isNullOrNil(paramString))
    {
      AppMethodBeat.o(79105);
      return null;
    }
    paramString = Uri.parse(paramString).getHost();
    AppMethodBeat.o(79105);
    return paramString;
  }
  
  public static String aXG(String paramString)
  {
    AppMethodBeat.i(79106);
    Object localObject1 = aOO(paramString);
    if (bs.isNullOrNil((String)localObject1))
    {
      ac.e("MicroMsg.WebViewCacheUtils", "evaluateResURLWithScheme, original url is invalid = %s", new Object[] { paramString });
      AppMethodBeat.o(79106);
      return null;
    }
    Object localObject2 = Uri.parse((String)localObject1);
    localObject1 = new StringBuilder();
    ((StringBuilder)localObject1).append(((Uri)localObject2).getScheme()).append("://").append(((Uri)localObject2).getHost()).append(":").append(((Uri)localObject2).getPort());
    if (!bs.gY(((Uri)localObject2).getPathSegments()))
    {
      localObject2 = ((Uri)localObject2).getPathSegments().iterator();
      while (((Iterator)localObject2).hasNext())
      {
        String str = (String)((Iterator)localObject2).next();
        ((StringBuilder)localObject1).append("/").append(bs.nullAsNil(str));
      }
    }
    if (paramString.endsWith("/")) {
      ((StringBuilder)localObject1).append("/");
    }
    paramString = ((StringBuilder)localObject1).toString();
    AppMethodBeat.o(79106);
    return paramString;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.d.b
 * JD-Core Version:    0.7.0.1
 */