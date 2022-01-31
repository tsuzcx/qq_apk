package com.tencent.tencentmap.mapsdk.a;

import android.text.TextUtils;
import java.util.concurrent.ThreadPoolExecutor;

public final class eg
  implements ed
{
  private static eg a = new eg();
  
  public static eg a()
  {
    return a;
  }
  
  private ej a(boolean paramBoolean, ei paramei, ec paramec)
  {
    paramei.h = paramec;
    paramei.n = System.currentTimeMillis();
    ey.a.a("app_http_use_proxy", 0, 1, 1);
    paramec = new el(paramei);
    paramei.i = paramec;
    int i;
    if (paramBoolean) {
      if (paramei.k <= 0)
      {
        paramei.a(paramec.a());
        i = 0;
        paramec = paramei.c();
        if (i != 0) {
          paramei.m = true;
        }
        if (paramec != null) {
          break label185;
        }
      }
    }
    label185:
    for (paramei = new fp(-14, "force return timeout:" + paramei.k, 0);; paramei = paramec)
    {
      return new ej(paramei);
      fb.a().b().execute(new eh(this, paramec, paramei));
      if (!paramei.a())
      {
        i = 1;
        break;
      }
      i = 0;
      break;
      paramec = new ej(paramec.a());
      if (!paramei.j) {
        paramei.h.a(paramei, paramec);
      }
      return null;
    }
  }
  
  public final ee a(String paramString, byte[] paramArrayOfByte)
  {
    if (TextUtils.isEmpty(paramString)) {
      throw new IllegalArgumentException("url is empty");
    }
    return new ei(paramString, paramArrayOfByte);
  }
  
  public final ef a(ee paramee)
  {
    if (paramee == null) {
      throw new RuntimeException("execute...IHttpRequest is null");
    }
    if (!(paramee instanceof ei)) {
      throw new RuntimeException("execute...IHttpRequest should be create by API:createRequest");
    }
    return a(true, (ei)paramee, null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.tencentmap.mapsdk.a.eg
 * JD-Core Version:    0.7.0.1
 */