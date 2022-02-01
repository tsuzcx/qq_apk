package com.tencent.xweb.x5.a;

import android.content.Context;
import android.os.Bundle;
import android.webkit.ValueCallback;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.smtt.sdk.QbSdk;
import com.tencent.smtt.sdk.TbsDownloader;
import com.tencent.smtt.sdk.TbsListener;
import com.tencent.smtt.sdk.WebView;
import com.tencent.xweb.x5.a.d;
import java.util.HashMap;
import java.util.Map;

public final class f
  implements a
{
  public final void a(Context paramContext, String paramString, ValueCallback<Boolean> paramValueCallback)
  {
    AppMethodBeat.i(154132);
    TbsDownloader.setAppContext(paramContext);
    QbSdk.canOpenFile(paramContext, paramString, new a.d(paramValueCallback));
    AppMethodBeat.o(154132);
  }
  
  public final void a(i parami)
  {
    AppMethodBeat.i(154129);
    QbSdk.setTbsListener(new a(parami));
    AppMethodBeat.o(154129);
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
    AppMethodBeat.i(213157);
    QbSdk.disableAutoCreateX5Webview();
    AppMethodBeat.o(213157);
  }
  
  public final void disableSensitiveApi()
  {
    AppMethodBeat.i(213164);
    QbSdk.disableSensitiveApi();
    AppMethodBeat.o(213164);
  }
  
  public final void forceSysWebView()
  {
    AppMethodBeat.i(154137);
    QbSdk.forceSysWebView();
    AppMethodBeat.o(154137);
  }
  
  public final String getMiniQBVersion(Context paramContext)
  {
    AppMethodBeat.i(213178);
    paramContext = QbSdk.getMiniQBVersion(paramContext);
    AppMethodBeat.o(213178);
    return paramContext;
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
  
  public final void setNewDnsHostList(String paramString)
  {
    AppMethodBeat.i(213192);
    QbSdk.setNewDnsHostList(paramString);
    AppMethodBeat.o(213192);
  }
  
  public final void setUploadCode(Context paramContext, int paramInt)
  {
    AppMethodBeat.i(154138);
    QbSdk.setUploadCode(paramContext, paramInt);
    AppMethodBeat.o(154138);
  }
  
  public final void setUserID(Context paramContext, Bundle paramBundle)
  {
    AppMethodBeat.i(213150);
    QbSdk.setUserID(paramContext, paramBundle);
    AppMethodBeat.o(213150);
  }
  
  public final void setWebContentsDebuggingEnabled(boolean paramBoolean)
  {
    AppMethodBeat.i(213187);
    WebView.setWebContentsDebuggingEnabled(paramBoolean);
    AppMethodBeat.o(213187);
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
    i ainD;
    
    public a(i parami)
    {
      this.ainD = parami;
    }
    
    public final void onDownloadFinish(int paramInt)
    {
      AppMethodBeat.i(154121);
      if (this.ainD != null) {
        this.ainD.onDownloadFinish(paramInt);
      }
      AppMethodBeat.o(154121);
    }
    
    public final void onDownloadProgress(int paramInt)
    {
      AppMethodBeat.i(154123);
      AppMethodBeat.o(154123);
    }
    
    public final void onInstallFinish(int paramInt)
    {
      AppMethodBeat.i(154122);
      if (this.ainD != null) {
        this.ainD.onInstallFinish(paramInt);
      }
      AppMethodBeat.o(154122);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.xweb.x5.a.f
 * JD-Core Version:    0.7.0.1
 */