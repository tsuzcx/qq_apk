package com.tencent.xweb.x5.sdk;

import android.content.Context;
import android.webkit.ValueCallback;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.smtt.sdk.QbSdk;
import com.tencent.smtt.sdk.TbsDownloader;
import com.tencent.smtt.sdk.TbsListener;
import com.tencent.xweb.x5.a.d;
import java.util.HashMap;
import java.util.Map;

public final class e
  implements a
{
  public final void a(Context paramContext, String paramString, ValueCallback<Boolean> paramValueCallback)
  {
    AppMethodBeat.i(154132);
    TbsDownloader.setAppContext(paramContext);
    QbSdk.canOpenFile(paramContext, paramString, new a.d(paramValueCallback));
    AppMethodBeat.o(154132);
  }
  
  public final void a(h paramh)
  {
    AppMethodBeat.i(154129);
    QbSdk.setTbsListener(new a(paramh));
    AppMethodBeat.o(154129);
  }
  
  public final boolean a(Context paramContext, String paramString, HashMap<String, String> paramHashMap, ValueCallback<String> paramValueCallback)
  {
    AppMethodBeat.i(154131);
    boolean bool = QbSdk.startQbOrMiniQBToLoadUrl(paramContext, paramString, paramHashMap, new a.d(paramValueCallback));
    AppMethodBeat.o(154131);
    return bool;
  }
  
  public final boolean canOpenWebPlus(Context paramContext)
  {
    AppMethodBeat.i(154135);
    boolean bool = QbSdk.canOpenWebPlus(paramContext);
    AppMethodBeat.o(154135);
    return bool;
  }
  
  public final void closeFileReader(Context paramContext)
  {
    AppMethodBeat.i(154136);
    QbSdk.closeFileReader(paramContext);
    AppMethodBeat.o(154136);
  }
  
  public final void disableAutoCreateX5Webview()
  {
    AppMethodBeat.i(194687);
    QbSdk.disableAutoCreateX5Webview();
    AppMethodBeat.o(194687);
  }
  
  public final void forceSysWebView()
  {
    AppMethodBeat.i(154137);
    QbSdk.forceSysWebView();
    AppMethodBeat.o(154137);
  }
  
  public final boolean getTBSInstalling()
  {
    AppMethodBeat.i(154127);
    boolean bool = QbSdk.getTBSInstalling();
    AppMethodBeat.o(154127);
    return bool;
  }
  
  public final int getTbsVersion(Context paramContext)
  {
    AppMethodBeat.i(154128);
    int i = QbSdk.getTbsVersion(paramContext);
    AppMethodBeat.o(154128);
    return i;
  }
  
  public final void initTbsSettings(Map<String, Object> paramMap)
  {
    AppMethodBeat.i(154134);
    QbSdk.initTbsSettings(paramMap);
    AppMethodBeat.o(154134);
  }
  
  public final void reset(Context paramContext)
  {
    AppMethodBeat.i(154126);
    QbSdk.reset(paramContext);
    AppMethodBeat.o(154126);
  }
  
  public final void setUploadCode(Context paramContext, int paramInt)
  {
    AppMethodBeat.i(154138);
    QbSdk.setUploadCode(paramContext, paramInt);
    AppMethodBeat.o(154138);
  }
  
  public final int startMiniQBToLoadUrl(Context paramContext, String paramString, HashMap<String, String> paramHashMap, ValueCallback<String> paramValueCallback)
  {
    AppMethodBeat.i(154130);
    int i = QbSdk.startMiniQBToLoadUrl(paramContext, paramString, paramHashMap, paramValueCallback);
    AppMethodBeat.o(154130);
    return i;
  }
  
  static final class a
    implements TbsListener
  {
    h ISB;
    
    public a(h paramh)
    {
      this.ISB = paramh;
    }
    
    public final void onDownloadFinish(int paramInt)
    {
      AppMethodBeat.i(154121);
      if (this.ISB != null) {
        this.ISB.onDownloadFinish(paramInt);
      }
      AppMethodBeat.o(154121);
    }
    
    public final void onDownloadProgress(int paramInt)
    {
      AppMethodBeat.i(154123);
      if (this.ISB != null) {
        this.ISB.onDownloadProgress(paramInt);
      }
      AppMethodBeat.o(154123);
    }
    
    public final void onInstallFinish(int paramInt)
    {
      AppMethodBeat.i(154122);
      if (this.ISB != null) {
        this.ISB.onInstallFinish(paramInt);
      }
      AppMethodBeat.o(154122);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.xweb.x5.sdk.e
 * JD-Core Version:    0.7.0.1
 */