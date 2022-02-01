package com.tencent.xweb.x5.sdk;

import android.content.Context;
import android.webkit.ValueCallback;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.xweb.aj;
import java.util.HashMap;
import java.util.Map;
import org.xwalk.core.Log;

public final class d
{
  static a KEW;
  static boolean KEX;
  
  static
  {
    AppMethodBeat.i(157148);
    aj.initInterface();
    KEX = false;
    AppMethodBeat.o(157148);
  }
  
  public static void a(Context paramContext, String paramString, ValueCallback<Boolean> paramValueCallback)
  {
    AppMethodBeat.i(157141);
    if (KEW != null)
    {
      KEW.a(paramContext, paramString, paramValueCallback);
      AppMethodBeat.o(157141);
      return;
    }
    Log.e("TbsDownloader", "canOpenFile: sImp is null");
    AppMethodBeat.o(157141);
  }
  
  public static void a(a parama)
  {
    KEW = parama;
  }
  
  public static void a(h paramh)
  {
    AppMethodBeat.i(157138);
    if (KEW != null)
    {
      KEW.a(paramh);
      AppMethodBeat.o(157138);
      return;
    }
    Log.e("TbsDownloader", "setTbsListener: sImp is null");
    AppMethodBeat.o(157138);
  }
  
  public static boolean a(Context paramContext, String paramString, HashMap<String, String> paramHashMap, ValueCallback<String> paramValueCallback)
  {
    AppMethodBeat.i(157140);
    if (KEW != null)
    {
      boolean bool = KEW.a(paramContext, paramString, paramHashMap, paramValueCallback);
      AppMethodBeat.o(157140);
      return bool;
    }
    Log.e("TbsDownloader", "startQbOrMiniQBToLoadUrl: sImp is null");
    AppMethodBeat.o(157140);
    return false;
  }
  
  public static boolean canOpenWebPlus(Context paramContext)
  {
    AppMethodBeat.i(157144);
    if (KEW != null)
    {
      boolean bool = KEW.canOpenWebPlus(paramContext);
      AppMethodBeat.o(157144);
      return bool;
    }
    Log.e("TbsDownloader", "canOpenWebPlus: sImp is null");
    AppMethodBeat.o(157144);
    return false;
  }
  
  public static void closeFileReader(Context paramContext)
  {
    AppMethodBeat.i(157145);
    if (KEW != null)
    {
      KEW.closeFileReader(paramContext);
      AppMethodBeat.o(157145);
      return;
    }
    Log.e("TbsDownloader", "closeFileReader: sImp is null");
    AppMethodBeat.o(157145);
  }
  
  public static void disableAutoCreateX5Webview()
  {
    AppMethodBeat.i(205103);
    if (KEW != null)
    {
      KEW.disableAutoCreateX5Webview();
      AppMethodBeat.o(205103);
      return;
    }
    Log.e("TbsDownloader", "disableAutoCreateX5Webview: sImp is null");
    AppMethodBeat.o(205103);
  }
  
  public static void forceSysWebView()
  {
    AppMethodBeat.i(157146);
    KEX = true;
    if (KEW != null)
    {
      KEW.forceSysWebView();
      AppMethodBeat.o(157146);
      return;
    }
    Log.e("TbsDownloader", "forceSysWebView: sImp is null");
    AppMethodBeat.o(157146);
  }
  
  public static boolean getTBSInstalling()
  {
    AppMethodBeat.i(157136);
    if (KEW != null)
    {
      boolean bool = KEW.getTBSInstalling();
      AppMethodBeat.o(157136);
      return bool;
    }
    Log.e("TbsDownloader", "getTBSInstalling: sImp is null");
    AppMethodBeat.o(157136);
    return false;
  }
  
  public static int getTbsVersion(Context paramContext)
  {
    AppMethodBeat.i(157137);
    if (KEW != null)
    {
      int i = KEW.getTbsVersion(paramContext);
      AppMethodBeat.o(157137);
      return i;
    }
    Log.e("TbsDownloader", "getTbsVersion: sImp is null");
    AppMethodBeat.o(157137);
    return 0;
  }
  
  public static void initTbsSettings(Map<String, Object> paramMap)
  {
    AppMethodBeat.i(157143);
    if (KEW != null)
    {
      KEW.initTbsSettings(paramMap);
      AppMethodBeat.o(157143);
      return;
    }
    Log.e("TbsDownloader", "initTbsSettings: sImp is null");
    AppMethodBeat.o(157143);
  }
  
  public static void reset(Context paramContext)
  {
    AppMethodBeat.i(157135);
    if (KEW != null)
    {
      KEW.reset(paramContext);
      AppMethodBeat.o(157135);
      return;
    }
    Log.e("TbsDownloader", "reset: sImp is null");
    AppMethodBeat.o(157135);
  }
  
  public static void setUploadCode(Context paramContext, int paramInt)
  {
    AppMethodBeat.i(157147);
    if (KEW != null)
    {
      KEW.setUploadCode(paramContext, paramInt);
      AppMethodBeat.o(157147);
      return;
    }
    Log.e("TbsDownloader", "forceSysWebView: sImp is null");
    AppMethodBeat.o(157147);
  }
  
  public static int startMiniQBToLoadUrl(Context paramContext, String paramString, HashMap<String, String> paramHashMap, ValueCallback<String> paramValueCallback)
  {
    AppMethodBeat.i(157139);
    if (KEW != null)
    {
      int i = KEW.startMiniQBToLoadUrl(paramContext, paramString, paramHashMap, paramValueCallback);
      AppMethodBeat.o(157139);
      return i;
    }
    Log.e("TbsDownloader", "startMiniQBToLoadUrl: sImp is null");
    AppMethodBeat.o(157139);
    return 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.xweb.x5.sdk.d
 * JD-Core Version:    0.7.0.1
 */