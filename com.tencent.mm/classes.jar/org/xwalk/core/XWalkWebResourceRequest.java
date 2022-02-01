package org.xwalk.core;

import android.net.Uri;
import java.util.Map;

public abstract interface XWalkWebResourceRequest
{
  public abstract String getMethod();
  
  public abstract Map<String, String> getRequestHeaders();
  
  public abstract Uri getUrl();
  
  public abstract boolean hasGesture();
  
  public abstract boolean isForMainFrame();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     org.xwalk.core.XWalkWebResourceRequest
 * JD-Core Version:    0.7.0.1
 */