package com.tencent.mm.plugin.webview.d;

import android.net.Uri;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.Iterator;
import java.util.List;

public final class b
{
  private static String ahv(String paramString)
  {
    AppMethodBeat.i(6868);
    if (!com.tencent.mm.plugin.webview.luggage.c.b.Fl(paramString))
    {
      AppMethodBeat.o(6868);
      return null;
    }
    Object localObject1 = paramString;
    localObject2 = paramString;
    try
    {
      Object localObject3 = new URI(paramString);
      localObject1 = paramString;
      localObject2 = paramString;
      String str3 = bo.nullAsNil(((URI)localObject3).getScheme()).toLowerCase();
      localObject1 = paramString;
      localObject2 = paramString;
      String str4 = bo.nullAsNil(((URI)localObject3).getHost()).toLowerCase();
      localObject1 = paramString;
      localObject2 = paramString;
      boolean bool = bo.isNullOrNil(str4);
      if (bool)
      {
        AppMethodBeat.o(6868);
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
          if (!bo.isNullOrNil(((URI)localObject3).getQuery())) {
            break label330;
          }
          str1 = "";
          label147:
          localObject1 = paramString;
          localObject2 = paramString;
          if (!bo.isNullOrNil(((URI)localObject3).getFragment())) {
            break label360;
          }
        }
      }
      for (String str2 = "";; str2 = "#" + ((URI)localObject3).getFragment())
      {
        localObject1 = paramString;
        localObject2 = paramString;
        localObject3 = bo.nullAsNil(((URI)localObject3).getPath());
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
        paramString = ahw(paramString);
        AppMethodBeat.o(6868);
        return paramString;
        i = 443;
        break;
        localObject1 = paramString;
        localObject2 = paramString;
        i = ((URI)localObject3).getPort();
        break;
        label330:
        localObject1 = paramString;
        localObject2 = paramString;
        str1 = "?" + ((URI)localObject3).getQuery();
        break label147;
        label360:
        localObject1 = paramString;
        localObject2 = paramString;
      }
      return localObject2;
    }
    catch (URISyntaxException paramString)
    {
      ab.e("MicroMsg.WebViewCacheUtils", "getFormattedHttpURL URISyntaxException : %s", new Object[] { paramString.getMessage() });
      AppMethodBeat.o(6868);
      return localObject1;
    }
    catch (Exception paramString)
    {
      ab.e("MicroMsg.WebViewCacheUtils", "getFormattedHttpURL normal : %s", new Object[] { paramString.getMessage() });
      AppMethodBeat.o(6868);
    }
  }
  
  private static String ahw(String paramString)
  {
    AppMethodBeat.i(6869);
    Uri localUri = Uri.parse(paramString);
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(localUri.getScheme()).append("://");
    localStringBuilder.append(localUri.getHost()).append(":").append(localUri.getPort());
    if (bo.es(localUri.getPathSegments())) {
      localStringBuilder.append("/");
    }
    for (;;)
    {
      if (!bo.isNullOrNil(localUri.getQuery())) {
        localStringBuilder.append("?").append(localUri.getQuery());
      }
      if (!bo.isNullOrNil(localUri.getFragment())) {
        localStringBuilder.append("#").append(localUri.getFragment());
      }
      if (paramString.endsWith("/")) {
        localStringBuilder.append("/");
      }
      paramString = localStringBuilder.toString();
      AppMethodBeat.o(6869);
      return paramString;
      Iterator localIterator = localUri.getPathSegments().iterator();
      while (localIterator.hasNext())
      {
        String str = (String)localIterator.next();
        localStringBuilder.append("/").append(str);
      }
    }
  }
  
  public static String ahx(String paramString)
  {
    AppMethodBeat.i(6870);
    paramString = ahv(paramString);
    if (bo.isNullOrNil(paramString))
    {
      AppMethodBeat.o(6870);
      return null;
    }
    paramString = Uri.parse(paramString).getHost();
    AppMethodBeat.o(6870);
    return paramString;
  }
  
  public static String asL(String paramString)
  {
    AppMethodBeat.i(6872);
    Object localObject1 = ahv(paramString);
    if (bo.isNullOrNil((String)localObject1))
    {
      ab.e("MicroMsg.WebViewCacheUtils", "evaluateResURLWithScheme, original url is invalid = %s", new Object[] { paramString });
      AppMethodBeat.o(6872);
      return null;
    }
    Object localObject2 = Uri.parse((String)localObject1);
    localObject1 = new StringBuilder();
    ((StringBuilder)localObject1).append(((Uri)localObject2).getScheme()).append("://").append(((Uri)localObject2).getHost()).append(":").append(((Uri)localObject2).getPort());
    if (!bo.es(((Uri)localObject2).getPathSegments()))
    {
      localObject2 = ((Uri)localObject2).getPathSegments().iterator();
      while (((Iterator)localObject2).hasNext())
      {
        String str = (String)((Iterator)localObject2).next();
        ((StringBuilder)localObject1).append("/").append(bo.nullAsNil(str));
      }
    }
    if (paramString.endsWith("/")) {
      ((StringBuilder)localObject1).append("/");
    }
    paramString = ((StringBuilder)localObject1).toString();
    AppMethodBeat.o(6872);
    return paramString;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.d.b
 * JD-Core Version:    0.7.0.1
 */