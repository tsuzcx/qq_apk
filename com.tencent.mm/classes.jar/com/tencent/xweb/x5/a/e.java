package com.tencent.xweb.x5.a;

import android.content.Context;
import android.os.Bundle;
import android.webkit.ValueCallback;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.HashMap;
import java.util.Map;
import org.xwalk.core.Log;
import org.xwalk.core.XWalkEnvironment;

public final class e
{
  private static a ainB;
  private static boolean ainC;
  
  static
  {
    AppMethodBeat.i(157148);
    XWalkEnvironment.initInterface();
    ainC = false;
    AppMethodBeat.o(157148);
  }
  
  public static void a(Context paramContext, String paramString, ValueCallback<Boolean> paramValueCallback)
  {
    AppMethodBeat.i(157141);
    if (ainB != null)
    {
      ainB.a(paramContext, paramString, paramValueCallback);
      AppMethodBeat.o(157141);
      return;
    }
    Log.e("QbSdk", "canOpenFile: sImp is null");
    AppMethodBeat.o(157141);
  }
  
  public static void a(a parama)
  {
    ainB = parama;
  }
  
  public static void a(i parami)
  {
    AppMethodBeat.i(157138);
    if (ainB != null)
    {
      ainB.a(parami);
      AppMethodBeat.o(157138);
      return;
    }
    Log.e("QbSdk", "setTbsListener: sImp is null");
    AppMethodBeat.o(157138);
  }
  
  public static boolean canOpenWebPlus(Context paramContext)
  {
    AppMethodBeat.i(157144);
    if (ainB != null)
    {
      boolean bool = ainB.canOpenWebPlus(paramContext);
      AppMethodBeat.o(157144);
      return bool;
    }
    Log.e("QbSdk", "canOpenWebPlus: sImp is null");
    AppMethodBeat.o(157144);
    return false;
  }
  
  public static void closeFileReader(Context paramContext)
  {
    AppMethodBeat.i(157145);
    if (ainB != null)
    {
      ainB.closeFileReader(paramContext);
      AppMethodBeat.o(157145);
      return;
    }
    Log.e("QbSdk", "closeFileReader: sImp is null");
    AppMethodBeat.o(157145);
  }
  
  public static void disableAutoCreateX5Webview()
  {
    AppMethodBeat.i(213173);
    if (ainB != null)
    {
      ainB.disableAutoCreateX5Webview();
      AppMethodBeat.o(213173);
      return;
    }
    Log.e("QbSdk", "disableAutoCreateX5Webview: sImp is null");
    AppMethodBeat.o(213173);
  }
  
  public static void disableSensitiveApi()
  {
    AppMethodBeat.i(213188);
    if (ainB != null)
    {
      ainB.disableSensitiveApi();
      AppMethodBeat.o(213188);
      return;
    }
    Log.e("QbSdk", "disableSensitiveApi: sImp is null");
    AppMethodBeat.o(213188);
  }
  
  public static void forceSysWebView()
  {
    AppMethodBeat.i(157146);
    ainC = true;
    if (ainB != null)
    {
      ainB.forceSysWebView();
      AppMethodBeat.o(157146);
      return;
    }
    Log.e("QbSdk", "forceSysWebView: sImp is null");
    AppMethodBeat.o(157146);
  }
  
  public static String getMiniQBVersion(Context paramContext)
  {
    AppMethodBeat.i(213214);
    if (ainB != null)
    {
      paramContext = ainB.getMiniQBVersion(paramContext);
      AppMethodBeat.o(213214);
      return paramContext;
    }
    Log.e("QbSdk", "getMiniQBVersion: sImp is null");
    AppMethodBeat.o(213214);
    return null;
  }
  
  public static boolean getTBSInstalling()
  {
    AppMethodBeat.i(157136);
    if (ainB != null)
    {
      boolean bool = ainB.getTBSInstalling();
      AppMethodBeat.o(157136);
      return bool;
    }
    Log.e("QbSdk", "getTBSInstalling: sImp is null");
    AppMethodBeat.o(157136);
    return false;
  }
  
  public static int getTbsVersion(Context paramContext)
  {
    AppMethodBeat.i(157137);
    if (ainB != null)
    {
      int i = ainB.getTbsVersion(paramContext);
      AppMethodBeat.o(157137);
      return i;
    }
    Log.e("QbSdk", "getTbsVersion: sImp is null");
    AppMethodBeat.o(157137);
    return 0;
  }
  
  public static void initTbsSettings(Map<String, Object> paramMap)
  {
    AppMethodBeat.i(157143);
    if (ainB != null)
    {
      ainB.initTbsSettings(paramMap);
      AppMethodBeat.o(157143);
      return;
    }
    Log.e("QbSdk", "initTbsSettings: sImp is null");
    AppMethodBeat.o(157143);
  }
  
  public static boolean kiZ()
  {
    return true;
  }
  
  public static void reset(Context paramContext)
  {
    AppMethodBeat.i(157135);
    if (ainB != null)
    {
      ainB.reset(paramContext);
      AppMethodBeat.o(157135);
      return;
    }
    Log.e("QbSdk", "reset: sImp is null");
    AppMethodBeat.o(157135);
  }
  
  public static void setNewDnsHostList(String paramString)
  {
    AppMethodBeat.i(213236);
    if (ainB != null)
    {
      ainB.setNewDnsHostList(paramString);
      AppMethodBeat.o(213236);
      return;
    }
    Log.e("QbSdk", "setNewDnsHostList: sImp is null");
    AppMethodBeat.o(213236);
  }
  
  public static void setUploadCode(Context paramContext, int paramInt)
  {
    AppMethodBeat.i(157147);
    if (ainB != null)
    {
      ainB.setUploadCode(paramContext, paramInt);
      AppMethodBeat.o(157147);
      return;
    }
    Log.e("QbSdk", "setUploadCode: sImp is null");
    AppMethodBeat.o(157147);
  }
  
  public static void setUserID(Context paramContext, Bundle paramBundle)
  {
    AppMethodBeat.i(213221);
    if (ainB != null)
    {
      ainB.setUserID(paramContext, paramBundle);
      AppMethodBeat.o(213221);
      return;
    }
    Log.e("QbSdk", "setUserID: sImp is null");
    AppMethodBeat.o(213221);
  }
  
  public static void setWebContentsDebuggingEnabled(boolean paramBoolean)
  {
    AppMethodBeat.i(213226);
    if (ainB != null)
    {
      ainB.setWebContentsDebuggingEnabled(paramBoolean);
      AppMethodBeat.o(213226);
      return;
    }
    Log.e("QbSdk", "setWebContentsDebuggingEnabled: sImp is null");
    AppMethodBeat.o(213226);
  }
  
  public static int startMiniQBToLoadUrl(Context paramContext, String paramString, HashMap<String, String> paramHashMap, ValueCallback<String> paramValueCallback)
  {
    AppMethodBeat.i(157139);
    if (ainB != null)
    {
      int i = ainB.startMiniQBToLoadUrl(paramContext, paramString, paramHashMap, paramValueCallback);
      AppMethodBeat.o(157139);
      return i;
    }
    Log.e("QbSdk", "startMiniQBToLoadUrl: sImp is null");
    AppMethodBeat.o(157139);
    return 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.xweb.x5.a.e
 * JD-Core Version:    0.7.0.1
 */