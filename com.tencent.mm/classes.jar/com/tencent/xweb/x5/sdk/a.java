package com.tencent.xweb.x5.sdk;

import android.content.Context;
import android.webkit.ValueCallback;
import java.util.HashMap;
import java.util.Map;

public abstract interface a
{
  public abstract void a(Context paramContext, d.a parama);
  
  public abstract void a(Context paramContext, String paramString, ValueCallback<Boolean> paramValueCallback);
  
  public abstract void a(h paramh);
  
  public abstract boolean a(Context paramContext, String paramString, HashMap<String, String> paramHashMap, ValueCallback<String> paramValueCallback);
  
  public abstract boolean canOpenWebPlus(Context paramContext);
  
  public abstract void closeFileReader(Context paramContext);
  
  public abstract void forceSysWebView();
  
  public abstract boolean getTBSInstalling();
  
  public abstract int getTbsVersion(Context paramContext);
  
  public abstract void initTbsSettings(Map<String, Object> paramMap);
  
  public abstract boolean isTbsCoreInited();
  
  public abstract void reset(Context paramContext);
  
  public abstract void setUploadCode(Context paramContext, int paramInt);
  
  public abstract int startMiniQBToLoadUrl(Context paramContext, String paramString, HashMap<String, String> paramHashMap, ValueCallback<String> paramValueCallback);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.xweb.x5.sdk.a
 * JD-Core Version:    0.7.0.1
 */