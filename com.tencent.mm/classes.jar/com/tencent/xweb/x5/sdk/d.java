package com.tencent.xweb.x5.sdk;

import android.content.Context;
import android.webkit.ValueCallback;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.xweb.al;
import java.util.HashMap;
import java.util.Map;
import org.xwalk.core.Log;

public final class d
{
  static a aagV;
  static boolean aagW;
  
  static
  {
    AppMethodBeat.i(157148);
    al.initInterface();
    aagW = false;
    AppMethodBeat.o(157148);
  }
  
  public static void a(Context paramContext, String paramString, ValueCallback<Boolean> paramValueCallback)
  {
    AppMethodBeat.i(157141);
    if (aagV != null)
    {
      aagV.a(paramContext, paramString, paramValueCallback);
      AppMethodBeat.o(157141);
      return;
    }
    Log.e("TbsDownloader", "canOpenFile: sImp is null");
    AppMethodBeat.o(157141);
  }
  
  public static void a(a parama)
  {
    aagV = parama;
  }
  
  public static void a(h paramh)
  {
    AppMethodBeat.i(157138);
    if (aagV != null)
    {
      aagV.a(paramh);
      AppMethodBeat.o(157138);
      return;
    }
    Log.e("TbsDownloader", "setTbsListener: sImp is null");
    AppMethodBeat.o(157138);
  }
  
  public static boolean canOpenWebPlus(Context paramContext)
  {
    AppMethodBeat.i(157144);
    if (aagV != null)
    {
      boolean bool = aagV.canOpenWebPlus(paramContext);
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
    if (aagV != null)
    {
      aagV.closeFileReader(paramContext);
      AppMethodBeat.o(157145);
      return;
    }
    Log.e("TbsDownloader", "closeFileReader: sImp is null");
    AppMethodBeat.o(157145);
  }
  
  public static void disableAutoCreateX5Webview()
  {
    AppMethodBeat.i(197066);
    if (aagV != null)
    {
      aagV.disableAutoCreateX5Webview();
      AppMethodBeat.o(197066);
      return;
    }
    Log.e("TbsDownloader", "disableAutoCreateX5Webview: sImp is null");
    AppMethodBeat.o(197066);
  }
  
  public static void disableSensitiveApi()
  {
    AppMethodBeat.i(197070);
    if (aagV != null)
    {
      aagV.disableSensitiveApi();
      AppMethodBeat.o(197070);
      return;
    }
    Log.e("TbsDownloader", "disableSensitiveApi: sImp is null");
    AppMethodBeat.o(197070);
  }
  
  public static void forceSysWebView()
  {
    AppMethodBeat.i(157146);
    aagW = true;
    if (aagV != null)
    {
      aagV.forceSysWebView();
      AppMethodBeat.o(157146);
      return;
    }
    Log.e("TbsDownloader", "forceSysWebView: sImp is null");
    AppMethodBeat.o(157146);
  }
  
  public static String getMiniQBVersion(Context paramContext)
  {
    AppMethodBeat.i(197076);
    if (aagV != null)
    {
      paramContext = aagV.getMiniQBVersion(paramContext);
      AppMethodBeat.o(197076);
      return paramContext;
    }
    Log.e("TbsDownloader", "forceSysWebView: sImp is null");
    AppMethodBeat.o(197076);
    return null;
  }
  
  public static boolean getTBSInstalling()
  {
    AppMethodBeat.i(157136);
    if (aagV != null)
    {
      boolean bool = aagV.getTBSInstalling();
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
    if (aagV != null)
    {
      int i = aagV.getTbsVersion(paramContext);
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
    if (aagV != null)
    {
      aagV.initTbsSettings(paramMap);
      AppMethodBeat.o(157143);
      return;
    }
    Log.e("TbsDownloader", "initTbsSettings: sImp is null");
    AppMethodBeat.o(157143);
  }
  
  public static boolean iyx()
  {
    return true;
  }
  
  public static void reset(Context paramContext)
  {
    AppMethodBeat.i(157135);
    if (aagV != null)
    {
      aagV.reset(paramContext);
      AppMethodBeat.o(157135);
      return;
    }
    Log.e("TbsDownloader", "reset: sImp is null");
    AppMethodBeat.o(157135);
  }
  
  public static void setNewDnsHostList(String paramString)
  {
    AppMethodBeat.i(197085);
    if (aagV != null)
    {
      aagV.setNewDnsHostList(paramString);
      AppMethodBeat.o(197085);
      return;
    }
    Log.e("TbsDownloader", "setNewDnsHostList: sImp is null");
    AppMethodBeat.o(197085);
  }
  
  public static void setUploadCode(Context paramContext, int paramInt)
  {
    AppMethodBeat.i(157147);
    if (aagV != null)
    {
      aagV.setUploadCode(paramContext, paramInt);
      AppMethodBeat.o(157147);
      return;
    }
    Log.e("TbsDownloader", "forceSysWebView: sImp is null");
    AppMethodBeat.o(157147);
  }
  
  public static void setWebContentsDebuggingEnabled(boolean paramBoolean)
  {
    AppMethodBeat.i(197081);
    if (aagV != null)
    {
      aagV.setWebContentsDebuggingEnabled(paramBoolean);
      AppMethodBeat.o(197081);
      return;
    }
    Log.e("TbsDownloader", "setWebContentsDebuggingEnabled: sImp is null");
    AppMethodBeat.o(197081);
  }
  
  public static int startMiniQBToLoadUrl(Context paramContext, String paramString, HashMap<String, String> paramHashMap, ValueCallback<String> paramValueCallback)
  {
    AppMethodBeat.i(157139);
    if (aagV != null)
    {
      int i = aagV.startMiniQBToLoadUrl(paramContext, paramString, paramHashMap, paramValueCallback);
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