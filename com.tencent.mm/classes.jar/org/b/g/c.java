package org.b.g;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.regex.Pattern;
import org.b.b.b;

public final class c
{
  private static String CHARSET;
  private static final Map<String, String> UiM;
  
  static
  {
    AppMethodBeat.i(40580);
    CHARSET = "UTF-8";
    HashMap localHashMap = new HashMap();
    localHashMap.put("*", "%2A");
    localHashMap.put("+", "%20");
    localHashMap.put("%7E", "~");
    UiM = Collections.unmodifiableMap(localHashMap);
    AppMethodBeat.o(40580);
  }
  
  public static String decode(String paramString)
  {
    AppMethodBeat.i(40582);
    d.j(paramString, "Cannot decode null object");
    try
    {
      paramString = URLDecoder.decode(paramString, CHARSET);
      AppMethodBeat.o(40582);
      return paramString;
    }
    catch (UnsupportedEncodingException paramString)
    {
      paramString = new b("Charset not found while decoding string: " + CHARSET, paramString);
      AppMethodBeat.o(40582);
      throw paramString;
    }
  }
  
  public static String encode(String paramString)
  {
    AppMethodBeat.i(40581);
    d.j(paramString, "Cannot encode null object");
    for (;;)
    {
      Iterator localIterator;
      try
      {
        paramString = URLEncoder.encode(paramString, CHARSET);
        localIterator = UiM.entrySet().iterator();
        if (!localIterator.hasNext())
        {
          AppMethodBeat.o(40581);
          return paramString;
        }
      }
      catch (UnsupportedEncodingException paramString)
      {
        paramString = new b("Charset not found while encoding string: " + CHARSET, paramString);
        AppMethodBeat.o(40581);
        throw paramString;
      }
      Object localObject = (Map.Entry)localIterator.next();
      String str = (String)((Map.Entry)localObject).getKey();
      localObject = (String)((Map.Entry)localObject).getValue();
      paramString = paramString.replaceAll(Pattern.quote(str), (String)localObject);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     org.b.g.c
 * JD-Core Version:    0.7.0.1
 */