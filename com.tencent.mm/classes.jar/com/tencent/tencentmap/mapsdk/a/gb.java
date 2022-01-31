package com.tencent.tencentmap.mapsdk.a;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public final class gb
  extends fs
{
  private static gb b = new gb();
  
  private static String a(String paramString, boolean paramBoolean, Map<String, String> paramMap)
  {
    Object localObject = ey.d();
    paramMap.put("A23", em.d);
    gd localgd = new gd();
    localgd.c(paramString);
    localgd.a(System.currentTimeMillis());
    localgd.b(ga.a);
    localgd.a((String)localObject);
    paramMap.put("A1", em.c);
    paramMap.put("A2", hq.a());
    paramMap.put("A4", hq.b());
    paramMap.put("A6", hq.c());
    paramMap.put("A7", hq.e());
    paramMap.put("A23", em.d);
    paramMap.put("A33", ey.f());
    paramMap.put("A10", ga.d);
    paramMap.put("A9", ga.c);
    paramMap.put("A19", localObject);
    localgd.a(paramMap);
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append(hq.a(System.currentTimeMillis(), "yyyy-MM-dd HH:mm:ss.SSS") + "|");
    ((StringBuilder)localObject).append("INFO|");
    ((StringBuilder)localObject).append(ey.a.a() + "|");
    ((StringBuilder)localObject).append(ga.b + "|");
    ((StringBuilder)localObject).append("beacon|");
    ((StringBuilder)localObject).append("1.8.1|");
    paramString = localgd.b();
    try
    {
      paramMap = URLEncoder.encode(localgd.b(), "utf-8");
      paramString = paramMap;
    }
    catch (UnsupportedEncodingException paramMap)
    {
      label310:
      break label310;
    }
    ((StringBuilder)localObject).append(paramString + "|");
    ((StringBuilder)localObject).append("|");
    ((StringBuilder)localObject).append("upload_ip|");
    ((StringBuilder)localObject).append("|");
    ((StringBuilder)localObject).append(localgd.a() + "|");
    ((StringBuilder)localObject).append(localgd.d() + "|");
    ((StringBuilder)localObject).append(paramBoolean + "|");
    ((StringBuilder)localObject).append("0|");
    ((StringBuilder)localObject).append("0|");
    paramString = a(localgd.e());
    ((StringBuilder)localObject).append(paramString + "|");
    ((StringBuilder)localObject).append(hq.a(localgd.c(), "yyyy-MM-dd HH:mm:ss") + "|");
    ((StringBuilder)localObject).append("upload_time");
    return ((StringBuilder)localObject).toString();
  }
  
  private static String a(Map<String, String> paramMap)
  {
    if (paramMap == null) {
      return "";
    }
    Object localObject = paramMap.keySet();
    if (localObject == null) {
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
    return paramMap;
  }
  
  public static gb d()
  {
    return b;
  }
  
  public final int a()
  {
    return ey.a.a("report_insert_new_record_num_limit", 5, 100, 100);
  }
  
  public final void a(String paramString, boolean paramBoolean1, Map<String, String> paramMap, boolean paramBoolean2, boolean paramBoolean3)
  {
    super.a(a(paramString, paramBoolean1, paramMap), paramBoolean2, paramBoolean3);
  }
  
  public final String b()
  {
    return "beacon";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.tencentmap.mapsdk.a.gb
 * JD-Core Version:    0.7.0.1
 */