package com.tencent.smtt.sdk;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Map;

public class WebStorage
{
  private static WebStorage a;
  
  private static WebStorage a()
  {
    try
    {
      AppMethodBeat.i(64830);
      if (a == null) {
        a = new WebStorage();
      }
      WebStorage localWebStorage = a;
      AppMethodBeat.o(64830);
      return localWebStorage;
    }
    finally {}
  }
  
  public static WebStorage getInstance()
  {
    AppMethodBeat.i(64829);
    WebStorage localWebStorage = a();
    AppMethodBeat.o(64829);
    return localWebStorage;
  }
  
  public void deleteAllData()
  {
    AppMethodBeat.i(64828);
    bz localbz = bz.a();
    if ((localbz != null) && (localbz.b()))
    {
      localbz.c().n();
      AppMethodBeat.o(64828);
      return;
    }
    android.webkit.WebStorage.getInstance().deleteAllData();
    AppMethodBeat.o(64828);
  }
  
  public void deleteOrigin(String paramString)
  {
    AppMethodBeat.i(64827);
    bz localbz = bz.a();
    if ((localbz != null) && (localbz.b()))
    {
      localbz.c().e(paramString);
      AppMethodBeat.o(64827);
      return;
    }
    android.webkit.WebStorage.getInstance().deleteOrigin(paramString);
    AppMethodBeat.o(64827);
  }
  
  public void getOrigins(ValueCallback<Map> paramValueCallback)
  {
    AppMethodBeat.i(64823);
    bz localbz = bz.a();
    if ((localbz != null) && (localbz.b()))
    {
      localbz.c().a(paramValueCallback);
      AppMethodBeat.o(64823);
      return;
    }
    android.webkit.WebStorage.getInstance().getOrigins(paramValueCallback);
    AppMethodBeat.o(64823);
  }
  
  public void getQuotaForOrigin(String paramString, ValueCallback<Long> paramValueCallback)
  {
    AppMethodBeat.i(64825);
    bz localbz = bz.a();
    if ((localbz != null) && (localbz.b()))
    {
      localbz.c().b(paramString, paramValueCallback);
      AppMethodBeat.o(64825);
      return;
    }
    android.webkit.WebStorage.getInstance().getQuotaForOrigin(paramString, paramValueCallback);
    AppMethodBeat.o(64825);
  }
  
  public void getUsageForOrigin(String paramString, ValueCallback<Long> paramValueCallback)
  {
    AppMethodBeat.i(64824);
    bz localbz = bz.a();
    if ((localbz != null) && (localbz.b()))
    {
      localbz.c().a(paramString, paramValueCallback);
      AppMethodBeat.o(64824);
      return;
    }
    android.webkit.WebStorage.getInstance().getUsageForOrigin(paramString, paramValueCallback);
    AppMethodBeat.o(64824);
  }
  
  @Deprecated
  public void setQuotaForOrigin(String paramString, long paramLong)
  {
    AppMethodBeat.i(64826);
    bz localbz = bz.a();
    if ((localbz != null) && (localbz.b()))
    {
      localbz.c().a(paramString, paramLong);
      AppMethodBeat.o(64826);
      return;
    }
    android.webkit.WebStorage.getInstance().setQuotaForOrigin(paramString, paramLong);
    AppMethodBeat.o(64826);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.smtt.sdk.WebStorage
 * JD-Core Version:    0.7.0.1
 */