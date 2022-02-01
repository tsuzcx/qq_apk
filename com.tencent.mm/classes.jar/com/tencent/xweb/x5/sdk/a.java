package com.tencent.xweb.x5.sdk;

import android.content.Context;
import android.webkit.ValueCallback;
import java.util.HashMap;
import java.util.Map;

public abstract interface a
{
  public abstract void a(Context paramContext, String paramString, ValueCallback<Boolean> paramValueCallback);
  
  public abstract void a(h paramh);
  
  public abstract boolean canOpenWebPlus(Context paramContext);
  
  public abstract void closeFileReader(Context paramContext);
  
  public abstract void disableAutoCreateX5Webview();
  
  public abstract void disableSensitiveApi();
  
  public abstract void forceSysWebView();
  
  public abstract String getMiniQBVersion(Context paramContext);
  
  public abstract boolean getTBSInstalling();
  
  public abstract int getTbsVersion(Context paramContext);
  
  public abstract void initTbsSettings(Map<String, Object> paramMap);
  
  public abstract void reset(Context paramContext);
  
  public abstract void setNewDnsHostList(String paramString);
  
  public abstract void setUploadCode(Context paramContext, int paramInt);
  
  public abstract void setWebContentsDebuggingEnabled(boolean paramBoolean);
  
  public abstract int startMiniQBToLoadUrl(Context paramContext, String paramString, HashMap<String, String> paramHashMap, ValueCallback<String> paramValueCallback);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.xweb.x5.sdk.a
 * JD-Core Version:    0.7.0.1
 */