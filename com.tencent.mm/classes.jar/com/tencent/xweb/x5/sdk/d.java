package com.tencent.xweb.x5.sdk;

import android.content.Context;
import android.webkit.ValueCallback;
import com.tencent.xweb.t;
import java.util.HashMap;
import java.util.Map;
import org.xwalk.core.Log;

public final class d
{
  static a xkR;
  static boolean xkS = false;
  
  static {}
  
  /* Error */
  public static void a(Context paramContext, d.a parama)
  {
    // Byte code:
    //   0: ldc 2
    //   2: monitorenter
    //   3: getstatic 24	com/tencent/xweb/x5/sdk/d:xkR	Lcom/tencent/xweb/x5/sdk/a;
    //   6: ifnull +17 -> 23
    //   9: getstatic 24	com/tencent/xweb/x5/sdk/d:xkR	Lcom/tencent/xweb/x5/sdk/a;
    //   12: aload_0
    //   13: aload_1
    //   14: invokeinterface 28 3 0
    //   19: ldc 2
    //   21: monitorexit
    //   22: return
    //   23: ldc 30
    //   25: ldc 32
    //   27: invokestatic 38	org/xwalk/core/Log:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   30: goto -11 -> 19
    //   33: astore_0
    //   34: ldc 2
    //   36: monitorexit
    //   37: aload_0
    //   38: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	39	0	paramContext	Context
    //   0	39	1	parama	d.a
    // Exception table:
    //   from	to	target	type
    //   3	19	33	finally
    //   23	30	33	finally
  }
  
  public static void a(Context paramContext, String paramString, ValueCallback<Boolean> paramValueCallback)
  {
    if (xkR != null)
    {
      xkR.a(paramContext, paramString, paramValueCallback);
      return;
    }
    Log.e("TbsDownloader", "canOpenFile: sImp is null");
  }
  
  public static void a(a parama)
  {
    xkR = parama;
  }
  
  public static void a(h paramh)
  {
    if (xkR != null)
    {
      xkR.a(paramh);
      return;
    }
    Log.e("TbsDownloader", "setTbsListener: sImp is null");
  }
  
  public static boolean a(Context paramContext, String paramString, HashMap<String, String> paramHashMap, ValueCallback<String> paramValueCallback)
  {
    if (xkR != null) {
      return xkR.a(paramContext, paramString, paramHashMap, paramValueCallback);
    }
    Log.e("TbsDownloader", "startQbOrMiniQBToLoadUrl: sImp is null");
    return false;
  }
  
  public static boolean canOpenWebPlus(Context paramContext)
  {
    if (xkR != null) {
      return xkR.canOpenWebPlus(paramContext);
    }
    Log.e("TbsDownloader", "canOpenWebPlus: sImp is null");
    return false;
  }
  
  public static void closeFileReader(Context paramContext)
  {
    if (xkR != null)
    {
      xkR.closeFileReader(paramContext);
      return;
    }
    Log.e("TbsDownloader", "closeFileReader: sImp is null");
  }
  
  public static void forceSysWebView()
  {
    xkS = true;
    if (xkR != null)
    {
      xkR.forceSysWebView();
      return;
    }
    Log.e("TbsDownloader", "forceSysWebView: sImp is null");
  }
  
  public static boolean getTBSInstalling()
  {
    if (xkR != null) {
      return xkR.getTBSInstalling();
    }
    Log.e("TbsDownloader", "getTBSInstalling: sImp is null");
    return false;
  }
  
  public static int getTbsVersion(Context paramContext)
  {
    if (xkR != null) {
      return xkR.getTbsVersion(paramContext);
    }
    Log.e("TbsDownloader", "getTbsVersion: sImp is null");
    return 0;
  }
  
  public static void initTbsSettings(Map<String, Object> paramMap)
  {
    if (xkR != null)
    {
      xkR.initTbsSettings(paramMap);
      return;
    }
    Log.e("TbsDownloader", "initTbsSettings: sImp is null");
  }
  
  public static boolean isTbsCoreInited()
  {
    if (xkR != null) {
      return xkR.isTbsCoreInited();
    }
    Log.e("TbsDownloader", "isTbsCoreInited: sImp is null");
    return false;
  }
  
  public static void reset(Context paramContext)
  {
    if (xkR != null)
    {
      xkR.reset(paramContext);
      return;
    }
    Log.e("TbsDownloader", "reset: sImp is null");
  }
  
  public static void setUploadCode(Context paramContext, int paramInt)
  {
    if (xkR != null)
    {
      xkR.setUploadCode(paramContext, paramInt);
      return;
    }
    Log.e("TbsDownloader", "forceSysWebView: sImp is null");
  }
  
  public static int startMiniQBToLoadUrl(Context paramContext, String paramString, HashMap<String, String> paramHashMap, ValueCallback<String> paramValueCallback)
  {
    if (xkR != null) {
      return xkR.startMiniQBToLoadUrl(paramContext, paramString, paramHashMap, paramValueCallback);
    }
    Log.e("TbsDownloader", "startMiniQBToLoadUrl: sImp is null");
    return 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.xweb.x5.sdk.d
 * JD-Core Version:    0.7.0.1
 */