package com.tencent.xweb;

import android.net.Uri;
import java.util.Map;

public abstract interface WebResourceRequest
{
  public abstract String getMethod();
  
  public abstract Map<String, String> getRequestHeaders();
  
  public abstract Uri getUrl();
  
  public abstract boolean hasGesture();
  
  public abstract boolean isForMainFrame();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.xweb.WebResourceRequest
 * JD-Core Version:    0.7.0.1
 */