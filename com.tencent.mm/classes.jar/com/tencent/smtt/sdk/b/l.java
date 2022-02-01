package com.tencent.smtt.sdk.b;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.webkit.ValueCallback;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.smtt.export.external.DexLoader;
import com.tencent.smtt.export.external.easel.interfaces.IEaselView;
import com.tencent.smtt.export.external.extension.interfaces.IX5WebViewClientExtension;
import com.tencent.smtt.export.external.interfaces.IX5CoreMessy;
import com.tencent.smtt.export.external.interfaces.IX5DateSorter;
import com.tencent.smtt.export.external.interfaces.IX5WebChromeClient;
import com.tencent.smtt.export.external.interfaces.IX5WebViewBase;
import com.tencent.smtt.export.external.interfaces.IX5WebViewClient;
import com.tencent.smtt.sdk.TbsReaderView;
import com.tencent.smtt.utils.TbsLog;
import java.util.Map;

public class l
  implements IX5CoreMessy
{
  private DexLoader a;
  
  l(DexLoader paramDexLoader, Context paramContext)
  {
    this.a = paramDexLoader;
  }
  
  public boolean canOpenFile(Context paramContext, String paramString)
  {
    AppMethodBeat.i(188479);
    paramContext = this.a.invokeStaticMethod("com.tencent.tbs.tbsshell.WebCoreProxy", "canOpenFile", new Class[] { Context.class, String.class }, new Object[] { paramContext, paramString });
    if ((paramContext instanceof Boolean))
    {
      boolean bool = ((Boolean)paramContext).booleanValue();
      AppMethodBeat.o(188479);
      return bool;
    }
    AppMethodBeat.o(188479);
    return false;
  }
  
  public void checkTrim(int paramInt) {}
  
  public void clearAdWebviewInfo() {}
  
  public void clearAllPermanentPermission() {}
  
  public void closeFileReader()
  {
    AppMethodBeat.i(188480);
    this.a.invokeStaticMethod("com.tencent.tbs.tbsshell.WebCoreProxy", "closeFileReader", new Class[0], new Object[0]);
    AppMethodBeat.o(188480);
  }
  
  public void closeMiniQB() {}
  
  public void createCacheWebView(Context paramContext)
  {
    AppMethodBeat.i(188487);
    this.a.invokeStaticMethod("com.tencent.tbs.tbsshell.WebCoreProxy", "createCacheWebView", new Class[] { Context.class }, new Object[] { paramContext });
    AppMethodBeat.o(188487);
  }
  
  public IX5DateSorter createDateSorter(Context paramContext)
  {
    AppMethodBeat.i(188469);
    paramContext = this.a.invokeStaticMethod("com.tencent.tbs.tbsshell.WebCoreProxy", "createDateSorter", new Class[] { Context.class }, new Object[] { paramContext });
    if (paramContext == null)
    {
      AppMethodBeat.o(188469);
      return null;
    }
    paramContext = (IX5DateSorter)paramContext;
    AppMethodBeat.o(188469);
    return paramContext;
  }
  
  public IX5WebChromeClient createDefaultX5WebChromeClient()
  {
    AppMethodBeat.i(188465);
    if (this.a == null)
    {
      AppMethodBeat.o(188465);
      return null;
    }
    Object localObject = this.a.invokeStaticMethod("com.tencent.tbs.tbsshell.WebCoreProxy", "createDefaultX5WebChromeClient", new Class[0], new Object[0]);
    if (localObject == null)
    {
      AppMethodBeat.o(188465);
      return null;
    }
    localObject = (IX5WebChromeClient)localObject;
    AppMethodBeat.o(188465);
    return localObject;
  }
  
  public IX5WebViewClientExtension createDefaultX5WebChromeClientExtension()
  {
    AppMethodBeat.i(188467);
    Object localObject = this.a.invokeStaticMethod("com.tencent.tbs.tbsshell.WebCoreProxy", "createDefaultX5WebChromeClientExtension", new Class[0], new Object[0]);
    if (localObject == null)
    {
      AppMethodBeat.o(188467);
      return null;
    }
    localObject = (IX5WebViewClientExtension)localObject;
    AppMethodBeat.o(188467);
    return localObject;
  }
  
  public IX5WebViewClient createDefaultX5WebViewClient()
  {
    AppMethodBeat.i(188466);
    Object localObject = this.a.invokeStaticMethod("com.tencent.tbs.tbsshell.WebCoreProxy", "createDefaultX5WebViewClient", new Class[0], new Object[0]);
    if (localObject == null)
    {
      AppMethodBeat.o(188466);
      return null;
    }
    localObject = (IX5WebViewClient)localObject;
    AppMethodBeat.o(188466);
    return localObject;
  }
  
  public IEaselView createEaselView(Context paramContext)
  {
    return null;
  }
  
  public boolean createMiniQBShortCut(Context paramContext, String paramString1, String paramString2, Bitmap paramBitmap)
  {
    AppMethodBeat.i(188481);
    TbsLog.e("X5CoreMessyImpl", "qbsdk createMiniQBShortCut");
    paramContext = this.a.invokeStaticMethod("com.tencent.tbs.tbsshell.WebCoreProxy", "createMiniQBShortCut", new Class[] { Context.class, String.class, String.class, Bitmap.class }, new Object[] { paramContext, paramString1, paramString2, paramBitmap });
    TbsLog.e("X5CoreMessyImpl", "qbsdk after createMiniQBShortCut ret: ".concat(String.valueOf(paramContext)));
    if (paramContext != null)
    {
      AppMethodBeat.o(188481);
      return true;
    }
    AppMethodBeat.o(188481);
    return false;
  }
  
  public void destoryScaleManager() {}
  
  public void doSearch(Context paramContext, String paramString1, IX5WebViewBase paramIX5WebViewBase, String paramString2) {}
  
  public void doWupTask() {}
  
  public void fileInfoDetect(Context paramContext, String paramString, ValueCallback<String> paramValueCallback)
  {
    AppMethodBeat.i(188490);
    try
    {
      this.a.invokeStaticMethod("com.tencent.tbs.tbsshell.WebCoreProxy", "fileInfoDetect", new Class[] { Context.class, String.class, ValueCallback.class }, new Object[] { paramContext, paramString, paramValueCallback });
      AppMethodBeat.o(188490);
      return;
    }
    catch (Throwable paramContext)
    {
      AppMethodBeat.o(188490);
    }
  }
  
  public Bundle getAdWebViewInfoFromX5Core()
  {
    AppMethodBeat.i(188471);
    Bundle localBundle = (Bundle)this.a.invokeStaticMethod("com.tencent.tbs.tbsshell.WebCoreProxy", "getAdWebViewInfoFromX5Core", new Class[0], new Object[0]);
    AppMethodBeat.o(188471);
    return localBundle;
  }
  
  public String getCrashExtraMessage()
  {
    String str = null;
    AppMethodBeat.i(188472);
    Object localObject1 = this.a;
    Object localObject2 = Boolean.TYPE;
    Boolean localBoolean = Boolean.TRUE;
    localObject2 = ((DexLoader)localObject1).invokeStaticMethod("com.tencent.tbs.tbsshell.WebCoreProxy", "invokeStaticMethod", new Class[] { localObject2, String.class, String.class, [Ljava.lang.Class.class, [Ljava.lang.Object.class }, new Object[] { localBoolean, "com.tencent.smtt.util.CrashTracker", "getCrashExtraInfo", null, new Object[0] });
    localObject1 = localObject2;
    if (localObject2 == null) {
      localObject1 = this.a.invokeStaticMethod("com.tencent.smtt.util.CrashTracker", "getCrashExtraInfo", null, new Object[0]);
    }
    if (localObject1 != null)
    {
      localObject1 = String.valueOf(localObject1);
      str = (String)localObject1 + " ReaderPackName=" + TbsReaderView.gReaderPackName + " ReaderPackVersion=" + TbsReaderView.gReaderPackVersion;
    }
    if (str == null)
    {
      AppMethodBeat.o(188472);
      return "X5 core get nothing...";
    }
    AppMethodBeat.o(188472);
    return str;
  }
  
  public IX5WebViewBase getCurrentMainWebviewJustForQQandWechat()
  {
    return null;
  }
  
  public String getDefaultUserAgent(Context paramContext)
  {
    AppMethodBeat.i(188470);
    paramContext = this.a.invokeStaticMethod("com.tencent.tbs.tbsshell.WebCoreProxy", "getDefaultUserAgent", new Class[] { Context.class }, new Object[] { paramContext });
    if ((paramContext instanceof String))
    {
      paramContext = (String)paramContext;
      AppMethodBeat.o(188470);
      return paramContext;
    }
    AppMethodBeat.o(188470);
    return null;
  }
  
  public String getExtendRule(Context paramContext, String paramString)
  {
    return null;
  }
  
  public String getGUID()
  {
    AppMethodBeat.i(188486);
    Object localObject = this.a.invokeStaticMethod("com.tencent.tbs.tbsshell.WebCoreProxy", "getGUID", new Class[0], new Object[0]);
    if ((localObject != null) && ((localObject instanceof String)))
    {
      localObject = (String)localObject;
      AppMethodBeat.o(188486);
      return localObject;
    }
    AppMethodBeat.o(188486);
    return null;
  }
  
  public String getMiniQBVersion()
  {
    AppMethodBeat.i(188484);
    Object localObject = this.a.invokeStaticMethod("com.tencent.tbs.tbsshell.WebCoreProxy", "getMiniQBVersion", new Class[0], new Object[0]);
    if (localObject == null)
    {
      AppMethodBeat.o(188484);
      return null;
    }
    localObject = (String)localObject;
    AppMethodBeat.o(188484);
    return localObject;
  }
  
  public String getTbsVersion()
  {
    return null;
  }
  
  public boolean getX5RenderPerformDebug()
  {
    return false;
  }
  
  public boolean installLocalQbApk(Context paramContext, String paramString1, String paramString2, Bundle paramBundle)
  {
    AppMethodBeat.i(188483);
    paramContext = this.a.invokeStaticMethod("com.tencent.tbs.tbsshell.WebCoreProxy", "installLocalQbApk", new Class[] { Context.class, String.class, String.class, Bundle.class }, new Object[] { paramContext, paramString1, paramString2, paramBundle });
    if (paramContext == null)
    {
      AppMethodBeat.o(188483);
      return false;
    }
    boolean bool = ((Boolean)paramContext).booleanValue();
    AppMethodBeat.o(188483);
    return bool;
  }
  
  public boolean isMiniQBShortCutExist(Context paramContext, String paramString)
  {
    AppMethodBeat.i(188482);
    paramString = this.a.invokeStaticMethod("com.tencent.tbs.tbsshell.WebCoreProxy", "isMiniQBShortCutExist", new Class[] { Context.class, String.class }, new Object[] { paramContext, paramString });
    if (paramString != null)
    {
      paramContext = Boolean.FALSE;
      if (!(paramString instanceof Boolean)) {
        break label82;
      }
      paramContext = (Boolean)paramString;
    }
    label82:
    for (;;)
    {
      boolean bool = paramContext.booleanValue();
      AppMethodBeat.o(188482);
      return bool;
      AppMethodBeat.o(188482);
      return false;
    }
  }
  
  public boolean isWritingWebCoreLogToFile()
  {
    return false;
  }
  
  public String mimeTypeMapGetExtensionFromMimeType(String paramString)
  {
    AppMethodBeat.i(188477);
    paramString = this.a.invokeStaticMethod("com.tencent.tbs.tbsshell.WebCoreProxy", "mimeTypeMapGetMimeTypeFromExtension", new Class[] { String.class }, new Object[] { paramString });
    if (paramString == null)
    {
      AppMethodBeat.o(188477);
      return null;
    }
    paramString = (String)paramString;
    AppMethodBeat.o(188477);
    return paramString;
  }
  
  public String mimeTypeMapGetFileExtensionFromUrl(String paramString)
  {
    AppMethodBeat.i(188473);
    paramString = this.a.invokeStaticMethod("com.tencent.tbs.tbsshell.WebCoreProxy", "mimeTypeMapGetFileExtensionFromUrl", new Class[] { String.class }, new Object[] { paramString });
    if (paramString == null)
    {
      AppMethodBeat.o(188473);
      return null;
    }
    paramString = (String)paramString;
    AppMethodBeat.o(188473);
    return paramString;
  }
  
  public String mimeTypeMapGetMimeTypeFromExtension(String paramString)
  {
    AppMethodBeat.i(188475);
    paramString = this.a.invokeStaticMethod("com.tencent.tbs.tbsshell.WebCoreProxy", "mimeTypeMapGetMimeTypeFromExtension", new Class[] { String.class }, new Object[] { paramString });
    if (paramString == null)
    {
      AppMethodBeat.o(188475);
      return null;
    }
    paramString = (String)paramString;
    AppMethodBeat.o(188475);
    return paramString;
  }
  
  public boolean mimeTypeMapHasExtension(String paramString)
  {
    AppMethodBeat.i(188476);
    paramString = this.a.invokeStaticMethod("com.tencent.tbs.tbsshell.WebCoreProxy", "mimeTypeMapHasExtension", new Class[] { String.class }, new Object[] { paramString });
    if (paramString == null)
    {
      AppMethodBeat.o(188476);
      return false;
    }
    boolean bool = ((Boolean)paramString).booleanValue();
    AppMethodBeat.o(188476);
    return bool;
  }
  
  public boolean mimeTypeMapHasMimeType(String paramString)
  {
    AppMethodBeat.i(188474);
    paramString = this.a.invokeStaticMethod("com.tencent.tbs.tbsshell.WebCoreProxy", "mimeTypeMapHasMimeType", new Class[] { String.class }, new Object[] { paramString });
    if (paramString == null)
    {
      AppMethodBeat.o(188474);
      return false;
    }
    boolean bool = ((Boolean)paramString).booleanValue();
    AppMethodBeat.o(188474);
    return bool;
  }
  
  public Uri[] parseFileChooserResult(int paramInt, Intent paramIntent)
  {
    AppMethodBeat.i(188468);
    paramIntent = this.a.invokeStaticMethod("com.tencent.tbs.tbsshell.WebCoreProxy", "parseFileChooserResult", new Class[] { Integer.TYPE, Intent.class }, new Object[] { Integer.valueOf(paramInt), paramIntent });
    if (paramIntent == null)
    {
      AppMethodBeat.o(188468);
      return null;
    }
    paramIntent = (Uri[])paramIntent;
    AppMethodBeat.o(188468);
    return paramIntent;
  }
  
  public void prefetchResource(Context paramContext, String paramString, Map<String, String> paramMap)
  {
    AppMethodBeat.i(188489);
    this.a.invokeStaticMethod("com.tencent.tbs.tbsshell.WebCoreProxy", "prefetchResource", new Class[] { Context.class, String.class, Map.class }, new Object[] { paramContext, paramString, paramMap });
    AppMethodBeat.o(188489);
  }
  
  public void pvUploadNotifybyUI() {}
  
  public void refreshJavaCoreApnState() {}
  
  public void setAdWebviewInfo(int paramInt1, String paramString1, String paramString2, String paramString3, int paramInt2, String paramString4, int paramInt3, int paramInt4) {}
  
  public void setAdWebviewShouldShow(boolean paramBoolean) {}
  
  public void setGuidToTbs(byte[] paramArrayOfByte1, byte[] paramArrayOfByte2, long paramLong) {}
  
  public void setQBSmttService(Object paramObject) {}
  
  public void setTbsInitPerformanceData(int paramInt, Map<String, String> paramMap)
  {
    AppMethodBeat.i(188485);
    this.a.invokeStaticMethod("com.tencent.tbs.tbsshell.WebCoreProxy", "setTbsInitPerformanceData", new Class[] { Integer.TYPE, Map.class }, new Object[] { Integer.valueOf(paramInt), paramMap });
    AppMethodBeat.o(188485);
  }
  
  public void setWebContentsDebuggingEnabled(boolean paramBoolean)
  {
    AppMethodBeat.i(188464);
    this.a.invokeStaticMethod("com.tencent.tbs.tbsshell.WebCoreProxy", "webview_setWebContentsDebuggingEnabled", new Class[] { Boolean.TYPE }, new Object[] { Boolean.valueOf(paramBoolean) });
    AppMethodBeat.o(188464);
  }
  
  public void setWebCoreLogWrite2FileFlag(boolean paramBoolean, String paramString) {}
  
  public void setWebViewPoolSize(Context paramContext, int paramInt)
  {
    AppMethodBeat.i(188488);
    this.a.invokeStaticMethod("com.tencent.tbs.tbsshell.WebCoreProxy", "setWebViewPoolSize", new Class[] { Context.class, Integer.TYPE }, new Object[] { paramContext, Integer.valueOf(paramInt) });
    AppMethodBeat.o(188488);
  }
  
  public void setX5RenderPerformDebug(boolean paramBoolean) {}
  
  public int startMiniQB(Context paramContext, String paramString, Map<String, String> paramMap, ValueCallback<String> paramValueCallback)
  {
    AppMethodBeat.i(188478);
    Object localObject = this.a.invokeStaticMethod("com.tencent.tbs.tbsshell.WebCoreProxy", "startMiniQB", new Class[] { Context.class, String.class, Map.class, ValueCallback.class }, new Object[] { paramContext, paramString, paramMap, paramValueCallback });
    paramValueCallback = localObject;
    if (localObject == null) {
      paramValueCallback = this.a.invokeStaticMethod("com.tencent.tbs.tbsshell.WebCoreProxy", "startMiniQB", new Class[] { Context.class, String.class, Map.class }, new Object[] { paramContext, paramString, paramMap });
    }
    paramMap = paramValueCallback;
    if (paramValueCallback == null) {
      paramMap = this.a.invokeStaticMethod("com.tencent.tbs.tbsshell.WebCoreProxy", "startMiniQB", new Class[] { Context.class, String.class }, new Object[] { paramContext, paramString });
    }
    if (paramMap == null)
    {
      AppMethodBeat.o(188478);
      return -3;
    }
    int i = ((Integer)paramMap).intValue();
    AppMethodBeat.o(188478);
    return i;
  }
  
  public int startQBWeb(Context paramContext, String paramString1, String paramString2, Map<String, String> paramMap)
  {
    return 0;
  }
  
  public void switchContext(IX5WebViewBase paramIX5WebViewBase, Context paramContext) {}
  
  public void traceBegin(int paramInt, String paramString) {}
  
  public void traceEnd(int paramInt, String paramString) {}
  
  public void uploadWebCoreLog2Server() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.smtt.sdk.b.l
 * JD-Core Version:    0.7.0.1
 */