package com.tencent.xweb.x5.sdk;

import android.content.Context;
import android.webkit.ValueCallback;
import com.tencent.smtt.sdk.QbSdk;
import com.tencent.xweb.x5.a.d;
import java.util.HashMap;
import java.util.Map;

public final class e
  implements a
{
  public final void a(Context paramContext, d.a parama)
  {
    QbSdk.preInit(paramContext, new e.b(parama));
  }
  
  public final void a(Context paramContext, String paramString, ValueCallback<Boolean> paramValueCallback)
  {
    QbSdk.canOpenFile(paramContext, paramString, new a.d(paramValueCallback));
  }
  
  public final void a(h paramh)
  {
    QbSdk.setTbsListener(new e.a(paramh));
  }
  
  public final boolean a(Context paramContext, String paramString, HashMap<String, String> paramHashMap, ValueCallback<String> paramValueCallback)
  {
    return QbSdk.startQbOrMiniQBToLoadUrl(paramContext, paramString, paramHashMap, new a.d(paramValueCallback));
  }
  
  public final boolean canOpenWebPlus(Context paramContext)
  {
    return QbSdk.canOpenWebPlus(paramContext);
  }
  
  public final void closeFileReader(Context paramContext)
  {
    QbSdk.closeFileReader(paramContext);
  }
  
  public final void forceSysWebView() {}
  
  public final boolean getTBSInstalling()
  {
    return QbSdk.getTBSInstalling();
  }
  
  public final int getTbsVersion(Context paramContext)
  {
    return QbSdk.getTbsVersion(paramContext);
  }
  
  public final void initTbsSettings(Map<String, Object> paramMap)
  {
    QbSdk.initTbsSettings(paramMap);
  }
  
  public final boolean isTbsCoreInited()
  {
    return QbSdk.isTbsCoreInited();
  }
  
  public final void reset(Context paramContext)
  {
    QbSdk.reset(paramContext);
  }
  
  public final void setUploadCode(Context paramContext, int paramInt)
  {
    QbSdk.setUploadCode(paramContext, paramInt);
  }
  
  public final int startMiniQBToLoadUrl(Context paramContext, String paramString, HashMap<String, String> paramHashMap, ValueCallback<String> paramValueCallback)
  {
    return QbSdk.startMiniQBToLoadUrl(paramContext, paramString, paramHashMap, paramValueCallback);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.xweb.x5.sdk.e
 * JD-Core Version:    0.7.0.1
 */