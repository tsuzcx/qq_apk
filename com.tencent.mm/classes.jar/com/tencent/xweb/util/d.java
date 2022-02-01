package com.tencent.xweb.util;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.os.Looper;
import android.webkit.WebSettings;
import android.webkit.WebView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import org.xwalk.core.Log;
import org.xwalk.core.XWalkEnvironment;

public final class d
{
  private static int aimy = -1;
  
  private static int bHX(String paramString)
  {
    AppMethodBeat.i(212636);
    if ((paramString == null) || (paramString.isEmpty()))
    {
      AppMethodBeat.o(212636);
      return 0;
    }
    String[] arrayOfString = paramString.split("\\.");
    try
    {
      int i = Integer.parseInt(arrayOfString[0]);
      AppMethodBeat.o(212636);
      return i;
    }
    finally
    {
      Log.e("ChromiumVersionUtil", "getVersionFromVersionName failed, versionName:" + paramString + ", error:" + localObject);
      AppMethodBeat.o(212636);
    }
    return 0;
  }
  
  @Deprecated
  public static int kgg()
  {
    AppMethodBeat.i(212591);
    if (aimy < 0)
    {
      i = khA();
      if (i > 0)
      {
        aimy = i;
        AppMethodBeat.o(212591);
        return i;
      }
    }
    int i = aimy;
    AppMethodBeat.o(212591);
    return i;
  }
  
  private static int khA()
  {
    AppMethodBeat.i(212626);
    if (XWalkEnvironment.getApplicationContext() != null)
    {
      Object localObject1 = XWalkEnvironment.getApplicationContext().getPackageManager();
      try
      {
        localObject1 = ((PackageManager)localObject1).getPackageInfo("com.google.android.webview", 0);
        if (localObject1 != null)
        {
          int i = bHX(((PackageInfo)localObject1).versionName);
          if (i > 0)
          {
            AppMethodBeat.o(212626);
            return i;
          }
        }
      }
      finally
      {
        Log.e("ChromiumVersionUtil", "getChromiumVersionFromPackageInfo failed, Android System WebView not found, error:".concat(String.valueOf(localObject2)));
      }
    }
    AppMethodBeat.o(212626);
    return 0;
  }
  
  public static int khy()
  {
    AppMethodBeat.i(212599);
    if (aimy < 0) {
      aimy = khz();
    }
    int i = aimy;
    AppMethodBeat.o(212599);
    return i;
  }
  
  private static int khz()
  {
    AppMethodBeat.i(212614);
    int i = khA();
    if (i > 0)
    {
      AppMethodBeat.o(212614);
      return i;
    }
    try
    {
      if (Looper.getMainLooper() == Looper.myLooper()) {}
      for (i = 1; i == 0; i = 0)
      {
        Log.e("ChromiumVersionUtil", "getChromiumVersionInternal NOT IN UI THREAD");
        AppMethodBeat.o(212614);
        return 0;
      }
      String str = new WebView(XWalkEnvironment.getApplicationContext()).getSettings().getUserAgentString();
      if (str != null)
      {
        String[] arrayOfString = str.split("Chrome/");
        if ((arrayOfString != null) && (arrayOfString.length != 0))
        {
          if (arrayOfString.length == 1)
          {
            i = arrayOfString[0].length();
            int j = str.length();
            if (i != j) {}
          }
        }
        else
        {
          AppMethodBeat.o(212614);
          return 0;
        }
        i = bHX(arrayOfString[1]);
        AppMethodBeat.o(212614);
        return i;
      }
    }
    finally
    {
      Log.e("ChromiumVersionUtil", "getChromiumVersionInternal failed, Android System WebView not found, error:".concat(String.valueOf(localObject)));
      AppMethodBeat.o(212614);
    }
    return 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.xweb.util.d
 * JD-Core Version:    0.7.0.1
 */