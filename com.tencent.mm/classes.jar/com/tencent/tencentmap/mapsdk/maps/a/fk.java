package com.tencent.tencentmap.mapsdk.maps.a;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.tencentmap.mapsdk.a.b;
import java.io.UnsupportedEncodingException;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.net.URLDecoder;

public class fk
{
  private static gc a;
  
  private static String a(String paramString, fn paramfn)
  {
    AppMethodBeat.i(147941);
    if (paramString == null)
    {
      AppMethodBeat.o(147941);
      return null;
    }
    try
    {
      localObject = new URL(URLDecoder.decode(paramString, "UTF-8"));
      localObject = new URI(((URL)localObject).getProtocol(), ((URL)localObject).getUserInfo(), ((URL)localObject).getHost(), ((URL)localObject).getPort(), ((URL)localObject).getPath(), ((URL)localObject).getQuery(), ((URL)localObject).getRef()).toASCIIString();
      paramString = (String)localObject;
    }
    catch (UnsupportedEncodingException localUnsupportedEncodingException)
    {
      Object localObject;
      break label71;
    }
    catch (MalformedURLException localMalformedURLException)
    {
      break label71;
    }
    catch (URISyntaxException localURISyntaxException)
    {
      for (;;)
      {
        label71:
        continue;
        paramString = "?";
      }
    }
    localObject = paramString;
    if (paramfn != null)
    {
      paramfn = paramfn.a().trim();
      localObject = paramString;
      if (!paramfn.equals(""))
      {
        localObject = paramString;
        if (!paramfn.equals("?"))
        {
          localObject = new StringBuilder().append(paramString);
          if (!paramString.contains("?")) {
            break label178;
          }
          paramString = "&";
          paramString = paramString;
          localObject = paramString + paramfn;
        }
      }
    }
    AppMethodBeat.o(147941);
    return localObject;
  }
  
  public static <T> void a(Context paramContext, String paramString, fn paramfn, Class<T> paramClass, b paramb)
  {
    AppMethodBeat.i(147940);
    if (a == null) {
      a = gr.a(paramContext.getApplicationContext());
    }
    fr.b("url:".concat(String.valueOf(paramString)));
    if (paramfn != null) {
      fr.b(paramfn.toString());
    }
    paramContext = new gq(a(paramString, paramfn), new fk.1(paramClass, paramb), new fk.2(paramb));
    a.a(paramContext);
    AppMethodBeat.o(147940);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.tencentmap.mapsdk.maps.a.fk
 * JD-Core Version:    0.7.0.1
 */