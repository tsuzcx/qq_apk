package com.tencent.xweb.x5.sdk;

import android.content.Context;
import android.webkit.ValueCallback;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.xweb.ac;
import java.util.HashMap;
import java.util.Map;
import org.xwalk.core.Log;

public final class d
{
  static a BIx;
  static boolean BIy;
  
  static
  {
    AppMethodBeat.i(4149);
    ac.initInterface();
    BIy = false;
    AppMethodBeat.o(4149);
  }
  
  /* Error */
  public static void a(Context paramContext, d.a parama)
  {
    // Byte code:
    //   0: ldc 2
    //   2: monitorenter
    //   3: sipush 4135
    //   6: invokestatic 18	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   9: getstatic 33	com/tencent/xweb/x5/sdk/d:BIx	Lcom/tencent/xweb/x5/sdk/a;
    //   12: ifnull +23 -> 35
    //   15: getstatic 33	com/tencent/xweb/x5/sdk/d:BIx	Lcom/tencent/xweb/x5/sdk/a;
    //   18: aload_0
    //   19: aload_1
    //   20: invokeinterface 37 3 0
    //   25: sipush 4135
    //   28: invokestatic 28	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   31: ldc 2
    //   33: monitorexit
    //   34: return
    //   35: ldc 39
    //   37: ldc 41
    //   39: invokestatic 47	org/xwalk/core/Log:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   42: sipush 4135
    //   45: invokestatic 28	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   48: goto -17 -> 31
    //   51: astore_0
    //   52: ldc 2
    //   54: monitorexit
    //   55: aload_0
    //   56: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	57	0	paramContext	Context
    //   0	57	1	parama	d.a
    // Exception table:
    //   from	to	target	type
    //   3	31	51	finally
    //   35	48	51	finally
  }
  
  public static void a(Context paramContext, String paramString, ValueCallback<Boolean> paramValueCallback)
  {
    AppMethodBeat.i(4142);
    if (BIx != null)
    {
      BIx.a(paramContext, paramString, paramValueCallback);
      AppMethodBeat.o(4142);
      return;
    }
    Log.e("TbsDownloader", "canOpenFile: sImp is null");
    AppMethodBeat.o(4142);
  }
  
  public static void a(a parama)
  {
    BIx = parama;
  }
  
  public static void a(h paramh)
  {
    AppMethodBeat.i(4139);
    if (BIx != null)
    {
      BIx.a(paramh);
      AppMethodBeat.o(4139);
      return;
    }
    Log.e("TbsDownloader", "setTbsListener: sImp is null");
    AppMethodBeat.o(4139);
  }
  
  public static boolean a(Context paramContext, String paramString, HashMap<String, String> paramHashMap, ValueCallback<String> paramValueCallback)
  {
    AppMethodBeat.i(4141);
    if (BIx != null)
    {
      boolean bool = BIx.a(paramContext, paramString, paramHashMap, paramValueCallback);
      AppMethodBeat.o(4141);
      return bool;
    }
    Log.e("TbsDownloader", "startQbOrMiniQBToLoadUrl: sImp is null");
    AppMethodBeat.o(4141);
    return false;
  }
  
  public static boolean canOpenWebPlus(Context paramContext)
  {
    AppMethodBeat.i(4145);
    if (BIx != null)
    {
      boolean bool = BIx.canOpenWebPlus(paramContext);
      AppMethodBeat.o(4145);
      return bool;
    }
    Log.e("TbsDownloader", "canOpenWebPlus: sImp is null");
    AppMethodBeat.o(4145);
    return false;
  }
  
  public static void closeFileReader(Context paramContext)
  {
    AppMethodBeat.i(4146);
    if (BIx != null)
    {
      BIx.closeFileReader(paramContext);
      AppMethodBeat.o(4146);
      return;
    }
    Log.e("TbsDownloader", "closeFileReader: sImp is null");
    AppMethodBeat.o(4146);
  }
  
  public static void forceSysWebView()
  {
    AppMethodBeat.i(4147);
    BIy = true;
    if (BIx != null)
    {
      BIx.forceSysWebView();
      AppMethodBeat.o(4147);
      return;
    }
    Log.e("TbsDownloader", "forceSysWebView: sImp is null");
    AppMethodBeat.o(4147);
  }
  
  public static boolean getTBSInstalling()
  {
    AppMethodBeat.i(4137);
    if (BIx != null)
    {
      boolean bool = BIx.getTBSInstalling();
      AppMethodBeat.o(4137);
      return bool;
    }
    Log.e("TbsDownloader", "getTBSInstalling: sImp is null");
    AppMethodBeat.o(4137);
    return false;
  }
  
  public static int getTbsVersion(Context paramContext)
  {
    AppMethodBeat.i(4138);
    if (BIx != null)
    {
      int i = BIx.getTbsVersion(paramContext);
      AppMethodBeat.o(4138);
      return i;
    }
    Log.e("TbsDownloader", "getTbsVersion: sImp is null");
    AppMethodBeat.o(4138);
    return 0;
  }
  
  public static void initTbsSettings(Map<String, Object> paramMap)
  {
    AppMethodBeat.i(4144);
    if (BIx != null)
    {
      BIx.initTbsSettings(paramMap);
      AppMethodBeat.o(4144);
      return;
    }
    Log.e("TbsDownloader", "initTbsSettings: sImp is null");
    AppMethodBeat.o(4144);
  }
  
  public static boolean isTbsCoreInited()
  {
    AppMethodBeat.i(4143);
    if (BIx != null)
    {
      boolean bool = BIx.isTbsCoreInited();
      AppMethodBeat.o(4143);
      return bool;
    }
    Log.e("TbsDownloader", "isTbsCoreInited: sImp is null");
    AppMethodBeat.o(4143);
    return false;
  }
  
  public static void reset(Context paramContext)
  {
    AppMethodBeat.i(4136);
    if (BIx != null)
    {
      BIx.reset(paramContext);
      AppMethodBeat.o(4136);
      return;
    }
    Log.e("TbsDownloader", "reset: sImp is null");
    AppMethodBeat.o(4136);
  }
  
  public static void setUploadCode(Context paramContext, int paramInt)
  {
    AppMethodBeat.i(4148);
    if (BIx != null)
    {
      BIx.setUploadCode(paramContext, paramInt);
      AppMethodBeat.o(4148);
      return;
    }
    Log.e("TbsDownloader", "forceSysWebView: sImp is null");
    AppMethodBeat.o(4148);
  }
  
  public static int startMiniQBToLoadUrl(Context paramContext, String paramString, HashMap<String, String> paramHashMap, ValueCallback<String> paramValueCallback)
  {
    AppMethodBeat.i(4140);
    if (BIx != null)
    {
      int i = BIx.startMiniQBToLoadUrl(paramContext, paramString, paramHashMap, paramValueCallback);
      AppMethodBeat.o(4140);
      return i;
    }
    Log.e("TbsDownloader", "startMiniQBToLoadUrl: sImp is null");
    AppMethodBeat.o(4140);
    return 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.xweb.x5.sdk.d
 * JD-Core Version:    0.7.0.1
 */