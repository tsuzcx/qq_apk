package com.tencent.smtt.export.external.interfaces;

import android.webkit.ValueCallback;
import java.util.Set;

public abstract interface IX5CoreGeolocationPermissions
{
  public abstract void allow(String paramString);
  
  public abstract void clear(String paramString);
  
  public abstract void clearAll();
  
  public abstract void getAllowed(String paramString, ValueCallback<Boolean> paramValueCallback);
  
  public abstract void getOrigins(ValueCallback<Set<String>> paramValueCallback);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.smtt.export.external.interfaces.IX5CoreGeolocationPermissions
 * JD-Core Version:    0.7.0.1
 */