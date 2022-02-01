package com.tencent.smtt.export.external.interfaces;

import android.webkit.ValueCallback;
import java.util.Map;

public abstract interface IX5CoreWebStorage
{
  public abstract void deleteAllData();
  
  public abstract void deleteOrigin(String paramString);
  
  public abstract void getOrigins(ValueCallback<Map> paramValueCallback);
  
  public abstract void getQuotaForOrigin(String paramString, ValueCallback<Long> paramValueCallback);
  
  public abstract void getUsageForOrigin(String paramString, ValueCallback<Long> paramValueCallback);
  
  public abstract void setQuotaForOrigin(String paramString, long paramLong);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.smtt.export.external.interfaces.IX5CoreWebStorage
 * JD-Core Version:    0.7.0.1
 */