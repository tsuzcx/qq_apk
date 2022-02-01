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
  static a SFG;
  static boolean SFH;
  
  static
  {
    AppMethodBeat.i(157148);
    aj.initInterface();
    SFH = false;
    AppMethodBeat.o(157148);
  }
  
  public static void a(Context paramContext, String paramString, ValueCallback<Boolean> paramValueCallback)
  {
    AppMethodBeat.i(157141);
    if (SFG != null)
    {
      SFG.a(paramContext, paramString, paramValueCallback);
      AppMethodBeat.o(157141);
      return;
    }
    Log.e("TbsDownloader", "canOpenFile: sImp is null");
    AppMethodBeat.o(157141);
  }
  
  public static void a(a parama)
  {
    SFG = parama;
  }
  
  public static void a(h paramh)
  {
    AppMethodBeat.i(157138);
    if (SFG != null)
    {
      SFG.a(paramh);
      AppMethodBeat.o(157138);
      return;
    }
    Log.e("TbsDownloader", "setTbsListener: sImp is null");
    AppMethodBeat.o(157138);
  }
  
  public static boolean a(Context paramContext, String paramString, HashMap<String, String> paramHashMap, ValueCallback<String> paramValueCallback)
  {
    AppMethodBeat.i(157140);
    if (SFG != null)
    {
      boolean bool = SFG.a(paramContext, paramString, paramHashMap, paramValueCallback);
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
    if (SFG != null)
    {
      boolean bool = SFG.canOpenWebPlus(paramContext);
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
    if (SFG != null)
    {
      SFG.closeFileReader(paramContext);
      AppMethodBeat.o(157145);
      return;
    }
    Log.e("TbsDownloader", "closeFileReader: sImp is null");
    AppMethodBeat.o(157145);
  }
  
  public static void disableAutoCreateX5Webview()
  {
    AppMethodBeat.i(219098);
    if (SFG != null)
    {
      SFG.disableAutoCreateX5Webview();
      AppMethodBeat.o(219098);
      return;
    }
    Log.e("TbsDownloader", "disableAutoCreateX5Webview: sImp is null");
    AppMethodBeat.o(219098);
  }
  
  public static void forceSysWebView()
  {
    AppMethodBeat.i(157146);
    SFH = true;
    if (SFG != null)
    {
      SFG.forceSysWebView();
      AppMethodBeat.o(157146);
      return;
    }
    Log.e("TbsDownloader", "forceSysWebView: sImp is null");
    AppMethodBeat.o(157146);
  }
  
  public static String getMiniQBVersion(Context paramContext)
  {
    AppMethodBeat.i(219099);
    if (SFG != null)
    {
      paramContext = SFG.getMiniQBVersion(paramContext);
      AppMethodBeat.o(219099);
      return paramContext;
    }
    Log.e("TbsDownloader", "forceSysWebView: sImp is null");
    AppMethodBeat.o(219099);
    return null;
  }
  
  public static boolean getTBSInstalling()
  {
    AppMethodBeat.i(157136);
    if (SFG != null)
    {
      boolean bool = SFG.getTBSInstalling();
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
    if (SFG != null)
    {
      int i = SFG.getTbsVersion(paramContext);
      AppMethodBeat.o(157137);
      return i;
    }
    Log.e("TbsDownloader", "getTbsVersion: sImp is null");
    AppMethodBeat.o(157137);
    return 0;
  }
  
  public static boolean huK()
  {
    return true;
  }
  
  public static void initTbsSettings(Map<String, Object> paramMap)
  {
    AppMethodBeat.i(157143);
    if (SFG != null)
    {
      SFG.initTbsSettings(paramMap);
      AppMethodBeat.o(157143);
      return;
    }
    Log.e("TbsDownloader", "initTbsSettings: sImp is null");
    AppMethodBeat.o(157143);
  }
  
  public static void reset(Context paramContext)
  {
    AppMethodBeat.i(157135);
    if (SFG != null)
    {
      SFG.reset(paramContext);
      AppMethodBeat.o(157135);
      return;
    }
    Log.e("TbsDownloader", "reset: sImp is null");
    AppMethodBeat.o(157135);
  }
  
  public static void setNewDnsHostList(String paramString)
  {
    AppMethodBeat.i(219101);
    if (SFG != null)
    {
      SFG.setNewDnsHostList(paramString);
      AppMethodBeat.o(219101);
      return;
    }
    Log.e("TbsDownloader", "setNewDnsHostList: sImp is null");
    AppMethodBeat.o(219101);
  }
  
  public static void setUploadCode(Context paramContext, int paramInt)
  {
    AppMethodBeat.i(157147);
    if (SFG != null)
    {
      SFG.setUploadCode(paramContext, paramInt);
      AppMethodBeat.o(157147);
      return;
    }
    Log.e("TbsDownloader", "forceSysWebView: sImp is null");
    AppMethodBeat.o(157147);
  }
  
  public static void setWebContentsDebuggingEnabled(boolean paramBoolean)
  {
    AppMethodBeat.i(219100);
    if (SFG != null)
    {
      SFG.setWebContentsDebuggingEnabled(paramBoolean);
      AppMethodBeat.o(219100);
      return;
    }
    Log.e("TbsDownloader", "setWebContentsDebuggingEnabled: sImp is null");
    AppMethodBeat.o(219100);
  }
  
  public static int startMiniQBToLoadUrl(Context paramContext, String paramString, HashMap<String, String> paramHashMap, ValueCallback<String> paramValueCallback)
  {
    AppMethodBeat.i(157139);
    if (SFG != null)
    {
      int i = SFG.startMiniQBToLoadUrl(paramContext, paramString, paramHashMap, paramValueCallback);
      AppMethodBeat.o(157139);
      return i;
    }
    Log.e("TbsDownloader", "startMiniQBToLoadUrl: sImp is null");
    AppMethodBeat.o(157139);
    return 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.xweb.x5.sdk.d
 * JD-Core Version:    0.7.0.1
 */