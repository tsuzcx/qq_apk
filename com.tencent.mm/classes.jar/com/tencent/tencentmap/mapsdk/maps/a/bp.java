package com.tencent.tencentmap.mapsdk.maps.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public final class bp
  extends bg
{
  private static bp b;
  
  static
  {
    AppMethodBeat.i(147303);
    b = new bp();
    AppMethodBeat.o(147303);
  }
  
  private static String a(String paramString, boolean paramBoolean, Map<String, String> paramMap)
  {
    AppMethodBeat.i(147301);
    Object localObject = an.d();
    paramMap.put("A23", ac.d);
    br localbr = new br();
    localbr.c(String.valueOf(paramString));
    localbr.a(System.currentTimeMillis());
    localbr.b(bo.a);
    localbr.a((String)localObject);
    paramMap.put("A1", ac.c);
    paramMap.put("A2", dd.a());
    paramMap.put("A4", dd.b());
    paramMap.put("A6", dd.c());
    paramMap.put("A7", dd.e());
    paramMap.put("A23", ac.d);
    paramMap.put("A33", an.f());
    paramMap.put("A10", bo.d);
    paramMap.put("A9", bo.c);
    paramMap.put("A19", localObject);
    localbr.a(paramMap);
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append(dd.a(System.currentTimeMillis(), "yyyy-MM-dd HH:mm:ss.SSS") + "|");
    ((StringBuilder)localObject).append("INFO|");
    ((StringBuilder)localObject).append(an.a.a() + "|");
    ((StringBuilder)localObject).append(bo.b + "|");
    ((StringBuilder)localObject).append("beacon|");
    ((StringBuilder)localObject).append("1.8.1|");
    paramString = localbr.b();
    try
    {
      paramMap = URLEncoder.encode(localbr.b(), "utf-8");
      paramString = paramMap;
    }
    catch (UnsupportedEncodingException paramMap)
    {
      label318:
      break label318;
    }
    ((StringBuilder)localObject).append(paramString + "|");
    ((StringBuilder)localObject).append("|");
    ((StringBuilder)localObject).append("upload_ip|");
    ((StringBuilder)localObject).append("|");
    ((StringBuilder)localObject).append(localbr.a() + "|");
    ((StringBuilder)localObject).append(localbr.d() + "|");
    ((StringBuilder)localObject).append(paramBoolean + "|");
    ((StringBuilder)localObject).append("0|");
    ((StringBuilder)localObject).append("0|");
    paramString = a(localbr.e());
    ((StringBuilder)localObject).append(paramString + "|");
    ((StringBuilder)localObject).append(dd.a(localbr.c(), "yyyy-MM-dd HH:mm:ss") + "|");
    ((StringBuilder)localObject).append("upload_time");
    paramString = ((StringBuilder)localObject).toString();
    AppMethodBeat.o(147301);
    return paramString;
  }
  
  private static String a(Map<String, String> paramMap)
  {
    AppMethodBeat.i(147302);
    if (paramMap == null)
    {
      AppMethodBeat.o(147302);
      return "";
    }
    Object localObject = paramMap.keySet();
    if (localObject == null)
    {
      AppMethodBeat.o(147302);
      return "";
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localObject = ((Set)localObject).iterator();
    while (((Iterator)localObject).hasNext())
    {
      String str = (String)((Iterator)localObject).next();
      localStringBuilder.append("&");
      localStringBuilder.append(str);
      localStringBuilder.append("=");
      localStringBuilder.append((String)paramMap.get(str));
    }
    paramMap = localStringBuilder.substring(1);
    localStringBuilder.setLength(0);
    AppMethodBeat.o(147302);
    return paramMap;
  }
  
  public static bp d()
  {
    return b;
  }
  
  public final int a()
  {
    AppMethodBeat.i(147299);
    int i = an.a.a("report_insert_new_record_num_limit", 5, 100, 100);
    AppMethodBeat.o(147299);
    return i;
  }
  
  public final void a(String paramString, boolean paramBoolean1, Map<String, String> paramMap, boolean paramBoolean2, boolean paramBoolean3)
  {
    AppMethodBeat.i(147300);
    super.a(a(paramString, paramBoolean1, paramMap), paramBoolean2, paramBoolean3);
    AppMethodBeat.o(147300);
  }
  
  public final String b()
  {
    return "beacon";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.tencentmap.mapsdk.maps.a.bp
 * JD-Core Version:    0.7.0.1
 */