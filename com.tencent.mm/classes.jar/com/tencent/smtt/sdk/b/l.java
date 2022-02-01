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
    AppMethodBeat.i(197204);
    paramContext = this.a.invokeStaticMethod("com.tencent.tbs.tbsshell.WebCoreProxy", "canOpenFile", new Class[] { Context.class, String.class }, new Object[] { paramContext, paramString });
    if ((paramContext instanceof Boolean))
    {
      boolean bool = ((Boolean)paramContext).booleanValue();
      AppMethodBeat.o(197204);
      return bool;
    }
    AppMethodBeat.o(197204);
    return false;
  }
  
  public void checkTrim(int paramInt) {}
  
  public void clearAdWebviewInfo() {}
  
  public void clearAllPermanentPermission() {}
  
  public void closeFileReader()
  {
    AppMethodBeat.i(197206);
    this.a.invokeStaticMethod("com.tencent.tbs.tbsshell.WebCoreProxy", "closeFileReader", new Class[0], new Object[0]);
    AppMethodBeat.o(197206);
  }
  
  public void closeMiniQB() {}
  
  public void createCacheWebView(Context paramContext)
  {
    AppMethodBeat.i(197227);
    this.a.invokeStaticMethod("com.tencent.tbs.tbsshell.WebCoreProxy", "createCacheWebView", new Class[] { Context.class }, new Object[] { paramContext });
    AppMethodBeat.o(197227);
  }
  
  public IX5DateSorter createDateSorter(Context paramContext)
  {
    AppMethodBeat.i(197167);
    paramContext = this.a.invokeStaticMethod("com.tencent.tbs.tbsshell.WebCoreProxy", "createDateSorter", new Class[] { Context.class }, new Object[] { paramContext });
    if (paramContext == null)
    {
      AppMethodBeat.o(197167);
      return null;
    }
    paramContext = (IX5DateSorter)paramContext;
    AppMethodBeat.o(197167);
    return paramContext;
  }
  
  public IX5WebChromeClient createDefaultX5WebChromeClient()
  {
    AppMethodBeat.i(197158);
    if (this.a == null)
    {
      AppMethodBeat.o(197158);
      return null;
    }
    Object localObject = this.a.invokeStaticMethod("com.tencent.tbs.tbsshell.WebCoreProxy", "createDefaultX5WebChromeClient", new Class[0], new Object[0]);
    if (localObject == null)
    {
      AppMethodBeat.o(197158);
      return null;
    }
    localObject = (IX5WebChromeClient)localObject;
    AppMethodBeat.o(197158);
    return localObject;
  }
  
  public IX5WebViewClientExtension createDefaultX5WebChromeClientExtension()
  {
    AppMethodBeat.i(197163);
    Object localObject = this.a.invokeStaticMethod("com.tencent.tbs.tbsshell.WebCoreProxy", "createDefaultX5WebChromeClientExtension", new Class[0], new Object[0]);
    if (localObject == null)
    {
      AppMethodBeat.o(197163);
      return null;
    }
    localObject = (IX5WebViewClientExtension)localObject;
    AppMethodBeat.o(197163);
    return localObject;
  }
  
  public IX5WebViewClient createDefaultX5WebViewClient()
  {
    AppMethodBeat.i(197160);
    Object localObject = this.a.invokeStaticMethod("com.tencent.tbs.tbsshell.WebCoreProxy", "createDefaultX5WebViewClient", new Class[0], new Object[0]);
    if (localObject == null)
    {
      AppMethodBeat.o(197160);
      return null;
    }
    localObject = (IX5WebViewClient)localObject;
    AppMethodBeat.o(197160);
    return localObject;
  }
  
  public IEaselView createEaselView(Context paramContext)
  {
    return null;
  }
  
  public boolean createMiniQBShortCut(Context paramContext, String paramString1, String paramString2, Bitmap paramBitmap)
  {
    AppMethodBeat.i(197210);
    TbsLog.e("X5CoreMessyImpl", "qbsdk createMiniQBShortCut");
    paramContext = this.a.invokeStaticMethod("com.tencent.tbs.tbsshell.WebCoreProxy", "createMiniQBShortCut", new Class[] { Context.class, String.class, String.class, Bitmap.class }, new Object[] { paramContext, paramString1, paramString2, paramBitmap });
    TbsLog.e("X5CoreMessyImpl", "qbsdk after createMiniQBShortCut ret: ".concat(String.valueOf(paramContext)));
    if (paramContext != null)
    {
      AppMethodBeat.o(197210);
      return true;
    }
    AppMethodBeat.o(197210);
    return false;
  }
  
  public void destoryScaleManager() {}
  
  public void doSearch(Context paramContext, String paramString1, IX5WebViewBase paramIX5WebViewBase, String paramString2) {}
  
  public void doWupTask() {}
  
  public void fileInfoDetect(Context paramContext, String paramString, ValueCallback<String> paramValueCallback)
  {
    AppMethodBeat.i(197240);
    try
    {
      this.a.invokeStaticMethod("com.tencent.tbs.tbsshell.WebCoreProxy", "fileInfoDetect", new Class[] { Context.class, String.class, ValueCallback.class }, new Object[] { paramContext, paramString, paramValueCallback });
      AppMethodBeat.o(197240);
      return;
    }
    catch (Throwable paramContext)
    {
      AppMethodBeat.o(197240);
    }
  }
  
  public Bundle getAdWebViewInfoFromX5Core()
  {
    AppMethodBeat.i(197177);
    Bundle localBundle = (Bundle)this.a.invokeStaticMethod("com.tencent.tbs.tbsshell.WebCoreProxy", "getAdWebViewInfoFromX5Core", new Class[0], new Object[0]);
    AppMethodBeat.o(197177);
    return localBundle;
  }
  
  public String getCrashExtraMessage()
  {
    String str = null;
    AppMethodBeat.i(197186);
    Object localObject1 = this.a;
    Object localObject2 = Boolean.TYPE;
    Boolean localBoolean = Boolean.TRUE;
    Object[] arrayOfObject = new Object[0];
    localObject2 = ((DexLoader)localObject1).invokeStaticMethod("com.tencent.tbs.tbsshell.WebCoreProxy", "invokeStaticMethod", new Class[] { localObject2, String.class, String.class, [Ljava.lang.Class.class, [Ljava.lang.Object.class }, new Object[] { localBoolean, "com.tencent.smtt.util.CrashTracker", "getCrashExtraInfo", null, arrayOfObject });
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
      AppMethodBeat.o(197186);
      return "X5 core get nothing...";
    }
    AppMethodBeat.o(197186);
    return str;
  }
  
  public IX5WebViewBase getCurrentMainWebviewJustForQQandWechat()
  {
    return null;
  }
  
  public String getDefaultUserAgent(Context paramContext)
  {
    AppMethodBeat.i(197175);
    paramContext = this.a.invokeStaticMethod("com.tencent.tbs.tbsshell.WebCoreProxy", "getDefaultUserAgent", new Class[] { Context.class }, new Object[] { paramContext });
    if ((paramContext instanceof String))
    {
      paramContext = (String)paramContext;
      AppMethodBeat.o(197175);
      return paramContext;
    }
    AppMethodBeat.o(197175);
    return null;
  }
  
  public String getExtendRule(Context paramContext, String paramString)
  {
    return null;
  }
  
  public String getGUID()
  {
    AppMethodBeat.i(197224);
    Object localObject = this.a.invokeStaticMethod("com.tencent.tbs.tbsshell.WebCoreProxy", "getGUID", new Class[0], new Object[0]);
    if ((localObject != null) && ((localObject instanceof String)))
    {
      localObject = (String)localObject;
      AppMethodBeat.o(197224);
      return localObject;
    }
    AppMethodBeat.o(197224);
    return null;
  }
  
  public String getMiniQBVersion()
  {
    AppMethodBeat.i(197220);
    Object localObject = this.a.invokeStaticMethod("com.tencent.tbs.tbsshell.WebCoreProxy", "getMiniQBVersion", new Class[0], new Object[0]);
    if (localObject == null)
    {
      AppMethodBeat.o(197220);
      return null;
    }
    localObject = (String)localObject;
    AppMethodBeat.o(197220);
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
    AppMethodBeat.i(197217);
    paramContext = this.a.invokeStaticMethod("com.tencent.tbs.tbsshell.WebCoreProxy", "installLocalQbApk", new Class[] { Context.class, String.class, String.class, Bundle.class }, new Object[] { paramContext, paramString1, paramString2, paramBundle });
    if (paramContext == null)
    {
      AppMethodBeat.o(197217);
      return false;
    }
    boolean bool = ((Boolean)paramContext).booleanValue();
    AppMethodBeat.o(197217);
    return bool;
  }
  
  public boolean isMiniQBShortCutExist(Context paramContext, String paramString)
  {
    AppMethodBeat.i(197214);
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
      AppMethodBeat.o(197214);
      return bool;
      AppMethodBeat.o(197214);
      return false;
    }
  }
  
  public boolean isWritingWebCoreLogToFile()
  {
    return false;
  }
  
  public String mimeTypeMapGetExtensionFromMimeType(String paramString)
  {
    AppMethodBeat.i(197201);
    paramString = this.a.invokeStaticMethod("com.tencent.tbs.tbsshell.WebCoreProxy", "mimeTypeMapGetMimeTypeFromExtension", new Class[] { String.class }, new Object[] { paramString });
    if (paramString == null)
    {
      AppMethodBeat.o(197201);
      return null;
    }
    paramString = (String)paramString;
    AppMethodBeat.o(197201);
    return paramString;
  }
  
  public String mimeTypeMapGetFileExtensionFromUrl(String paramString)
  {
    AppMethodBeat.i(197189);
    paramString = this.a.invokeStaticMethod("com.tencent.tbs.tbsshell.WebCoreProxy", "mimeTypeMapGetFileExtensionFromUrl", new Class[] { String.class }, new Object[] { paramString });
    if (paramString == null)
    {
      AppMethodBeat.o(197189);
      return null;
    }
    paramString = (String)paramString;
    AppMethodBeat.o(197189);
    return paramString;
  }
  
  public String mimeTypeMapGetMimeTypeFromExtension(String paramString)
  {
    AppMethodBeat.i(197195);
    paramString = this.a.invokeStaticMethod("com.tencent.tbs.tbsshell.WebCoreProxy", "mimeTypeMapGetMimeTypeFromExtension", new Class[] { String.class }, new Object[] { paramString });
    if (paramString == null)
    {
      AppMethodBeat.o(197195);
      return null;
    }
    paramString = (String)paramString;
    AppMethodBeat.o(197195);
    return paramString;
  }
  
  public boolean mimeTypeMapHasExtension(String paramString)
  {
    AppMethodBeat.i(197198);
    paramString = this.a.invokeStaticMethod("com.tencent.tbs.tbsshell.WebCoreProxy", "mimeTypeMapHasExtension", new Class[] { String.class }, new Object[] { paramString });
    if (paramString == null)
    {
      AppMethodBeat.o(197198);
      return false;
    }
    boolean bool = ((Boolean)paramString).booleanValue();
    AppMethodBeat.o(197198);
    return bool;
  }
  
  public boolean mimeTypeMapHasMimeType(String paramString)
  {
    AppMethodBeat.i(197192);
    paramString = this.a.invokeStaticMethod("com.tencent.tbs.tbsshell.WebCoreProxy", "mimeTypeMapHasMimeType", new Class[] { String.class }, new Object[] { paramString });
    if (paramString == null)
    {
      AppMethodBeat.o(197192);
      return false;
    }
    boolean bool = ((Boolean)paramString).booleanValue();
    AppMethodBeat.o(197192);
    return bool;
  }
  
  public Uri[] parseFileChooserResult(int paramInt, Intent paramIntent)
  {
    AppMethodBeat.i(197164);
    paramIntent = this.a.invokeStaticMethod("com.tencent.tbs.tbsshell.WebCoreProxy", "parseFileChooserResult", new Class[] { Integer.TYPE, Intent.class }, new Object[] { Integer.valueOf(paramInt), paramIntent });
    if (paramIntent == null)
    {
      AppMethodBeat.o(197164);
      return null;
    }
    paramIntent = (Uri[])paramIntent;
    AppMethodBeat.o(197164);
    return paramIntent;
  }
  
  public void prefetchResource(Context paramContext, String paramString, Map<String, String> paramMap)
  {
    AppMethodBeat.i(197235);
    this.a.invokeStaticMethod("com.tencent.tbs.tbsshell.WebCoreProxy", "prefetchResource", new Class[] { Context.class, String.class, Map.class }, new Object[] { paramContext, paramString, paramMap });
    AppMethodBeat.o(197235);
  }
  
  public void pvUploadNotifybyUI() {}
  
  public void refreshJavaCoreApnState() {}
  
  public void setAdWebviewInfo(int paramInt1, String paramString1, String paramString2, String paramString3, int paramInt2, String paramString4, int paramInt3, int paramInt4) {}
  
  public void setAdWebviewShouldShow(boolean paramBoolean) {}
  
  public void setGuidToTbs(byte[] paramArrayOfByte1, byte[] paramArrayOfByte2, long paramLong) {}
  
  public void setQBSmttService(Object paramObject) {}
  
  public void setTbsInitPerformanceData(int paramInt, Map<String, String> paramMap)
  {
    AppMethodBeat.i(197222);
    this.a.invokeStaticMethod("com.tencent.tbs.tbsshell.WebCoreProxy", "setTbsInitPerformanceData", new Class[] { Integer.TYPE, Map.class }, new Object[] { Integer.valueOf(paramInt), paramMap });
    AppMethodBeat.o(197222);
  }
  
  public void setWebContentsDebuggingEnabled(boolean paramBoolean)
  {
    AppMethodBeat.i(197156);
    this.a.invokeStaticMethod("com.tencent.tbs.tbsshell.WebCoreProxy", "webview_setWebContentsDebuggingEnabled", new Class[] { Boolean.TYPE }, new Object[] { Boolean.valueOf(paramBoolean) });
    AppMethodBeat.o(197156);
  }
  
  public void setWebCoreLogWrite2FileFlag(boolean paramBoolean, String paramString) {}
  
  public void setWebViewPoolSize(Context paramContext, int paramInt)
  {
    AppMethodBeat.i(197231);
    this.a.invokeStaticMethod("com.tencent.tbs.tbsshell.WebCoreProxy", "setWebViewPoolSize", new Class[] { Context.class, Integer.TYPE }, new Object[] { paramContext, Integer.valueOf(paramInt) });
    AppMethodBeat.o(197231);
  }
  
  public void setX5RenderPerformDebug(boolean paramBoolean) {}
  
  public int startMiniQB(Context paramContext, String paramString, Map<String, String> paramMap, ValueCallback<String> paramValueCallback)
  {
    AppMethodBeat.i(197203);
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
      AppMethodBeat.o(197203);
      return -3;
    }
    int i = ((Integer)paramMap).intValue();
    AppMethodBeat.o(197203);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.smtt.sdk.b.l
 * JD-Core Version:    0.7.0.1
 */