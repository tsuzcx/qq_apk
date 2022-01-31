package com.tencent.tencentmap.mapsdk.maps.a;

import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.concurrent.ThreadPoolExecutor;

public final class w
  implements t
{
  private static w a;
  
  static
  {
    AppMethodBeat.i(149619);
    a = new w();
    AppMethodBeat.o(149619);
  }
  
  public static w a()
  {
    return a;
  }
  
  private z a(boolean paramBoolean, y paramy, s params)
  {
    AppMethodBeat.i(149618);
    paramy.h = params;
    paramy.n = System.currentTimeMillis();
    an.a.a("app_http_use_proxy", 0, 1, 1);
    params = new ab(paramy);
    paramy.i = params;
    int i;
    if (paramBoolean) {
      if (paramy.k <= 0)
      {
        paramy.a(params.a());
        i = 0;
        params = paramy.c();
        if (i != 0) {
          paramy.m = true;
        }
        if (params != null) {
          break label202;
        }
      }
    }
    label202:
    for (paramy = new be(-14, "force return timeout:" + paramy.k, 0);; paramy = params)
    {
      paramy = new z(paramy);
      AppMethodBeat.o(149618);
      return paramy;
      aq.a().b().execute(new x(this, params, paramy));
      if (!paramy.a())
      {
        i = 1;
        break;
      }
      i = 0;
      break;
      params = new z(params.a());
      if (!paramy.j) {
        paramy.h.a(paramy, params);
      }
      AppMethodBeat.o(149618);
      return null;
    }
  }
  
  public final u a(String paramString, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(149616);
    if (TextUtils.isEmpty(paramString))
    {
      paramString = new IllegalArgumentException("url is empty");
      AppMethodBeat.o(149616);
      throw paramString;
    }
    paramString = new y(paramString, paramArrayOfByte);
    AppMethodBeat.o(149616);
    return paramString;
  }
  
  public final v a(u paramu)
  {
    AppMethodBeat.i(149617);
    if (paramu == null)
    {
      paramu = new RuntimeException("execute...IHttpRequest is null");
      AppMethodBeat.o(149617);
      throw paramu;
    }
    if (!(paramu instanceof y))
    {
      paramu = new RuntimeException("execute...IHttpRequest should be create by API:createRequest");
      AppMethodBeat.o(149617);
      throw paramu;
    }
    paramu = a(true, (y)paramu, null);
    AppMethodBeat.o(149617);
    return paramu;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.tencentmap.mapsdk.maps.a.w
 * JD-Core Version:    0.7.0.1
 */