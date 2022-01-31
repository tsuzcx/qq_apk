package com.tencent.xweb.sys;

import android.annotation.TargetApi;
import android.webkit.WebChromeClient.FileChooserParams;
import com.tencent.xweb.j.a;

public final class c$b
  extends j.a
{
  public WebChromeClient.FileChooserParams xjE;
  
  public c$b(WebChromeClient.FileChooserParams paramFileChooserParams)
  {
    this.xjE = paramFileChooserParams;
  }
  
  @TargetApi(21)
  public final String[] getAcceptTypes()
  {
    if (this.xjE != null) {
      return this.xjE.getAcceptTypes();
    }
    return new String[0];
  }
  
  @TargetApi(21)
  public final int getMode()
  {
    if (this.xjE != null) {
      return this.xjE.getMode();
    }
    return 0;
  }
  
  @TargetApi(21)
  public final boolean isCaptureEnabled()
  {
    if (this.xjE != null) {
      return this.xjE.isCaptureEnabled();
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.xweb.sys.c.b
 * JD-Core Version:    0.7.0.1
 */