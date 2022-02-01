package com.tencent.smtt.sdk;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.smtt.export.external.interfaces.IX5CoreWebStorage;
import java.util.Map;

public class WebStorage
  extends z
{
  private static WebStorage a;
  
  private static WebStorage a()
  {
    try
    {
      AppMethodBeat.i(54332);
      if (a == null) {
        a = new WebStorage();
      }
      WebStorage localWebStorage = a;
      AppMethodBeat.o(54332);
      return localWebStorage;
    }
    finally {}
  }
  
  public static WebStorage getInstance()
  {
    AppMethodBeat.i(54331);
    WebStorage localWebStorage = a();
    AppMethodBeat.o(54331);
    return localWebStorage;
  }
  
  public void deleteAllData()
  {
    AppMethodBeat.i(54330);
    if (isX5Core())
    {
      getWebStorageImpl().deleteAllData();
      AppMethodBeat.o(54330);
      return;
    }
    android.webkit.WebStorage.getInstance().deleteAllData();
    AppMethodBeat.o(54330);
  }
  
  public void deleteOrigin(String paramString)
  {
    AppMethodBeat.i(54329);
    if (isX5Core())
    {
      getWebStorageImpl().deleteOrigin(paramString);
      AppMethodBeat.o(54329);
      return;
    }
    android.webkit.WebStorage.getInstance().deleteOrigin(paramString);
    AppMethodBeat.o(54329);
  }
  
  public void getOrigins(ValueCallback<Map> paramValueCallback)
  {
    AppMethodBeat.i(54325);
    if (isX5Core())
    {
      getWebStorageImpl().getOrigins(paramValueCallback);
      AppMethodBeat.o(54325);
      return;
    }
    android.webkit.WebStorage.getInstance().getOrigins(paramValueCallback);
    AppMethodBeat.o(54325);
  }
  
  public void getQuotaForOrigin(String paramString, ValueCallback<Long> paramValueCallback)
  {
    AppMethodBeat.i(54327);
    if (isX5Core())
    {
      getWebStorageImpl().getUsageForOrigin(paramString, paramValueCallback);
      AppMethodBeat.o(54327);
      return;
    }
    android.webkit.WebStorage.getInstance().getQuotaForOrigin(paramString, paramValueCallback);
    AppMethodBeat.o(54327);
  }
  
  public void getUsageForOrigin(String paramString, ValueCallback<Long> paramValueCallback)
  {
    AppMethodBeat.i(54326);
    if (isX5Core())
    {
      getWebStorageImpl().getUsageForOrigin(paramString, paramValueCallback);
      AppMethodBeat.o(54326);
      return;
    }
    android.webkit.WebStorage.getInstance().getUsageForOrigin(paramString, paramValueCallback);
    AppMethodBeat.o(54326);
  }
  
  @Deprecated
  public void setQuotaForOrigin(String paramString, long paramLong)
  {
    AppMethodBeat.i(54328);
    if (isX5Core())
    {
      getWebStorageImpl().setQuotaForOrigin(paramString, paramLong);
      AppMethodBeat.o(54328);
      return;
    }
    android.webkit.WebStorage.getInstance().setQuotaForOrigin(paramString, paramLong);
    AppMethodBeat.o(54328);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.smtt.sdk.WebStorage
 * JD-Core Version:    0.7.0.1
 */