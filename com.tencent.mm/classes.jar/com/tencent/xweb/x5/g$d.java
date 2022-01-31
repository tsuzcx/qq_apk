package com.tencent.xweb.x5;

import com.tencent.smtt.sdk.WebChromeClient.FileChooserParams;
import com.tencent.xweb.j.a;

public final class g$d
  extends j.a
{
  public WebChromeClient.FileChooserParams xku;
  
  public g$d(WebChromeClient.FileChooserParams paramFileChooserParams)
  {
    this.xku = paramFileChooserParams;
  }
  
  public final String[] getAcceptTypes()
  {
    if (this.xku != null) {
      return this.xku.getAcceptTypes();
    }
    return new String[0];
  }
  
  public final int getMode()
  {
    if (this.xku != null) {
      return this.xku.getMode();
    }
    return 0;
  }
  
  public final boolean isCaptureEnabled()
  {
    if (this.xku != null) {
      return this.xku.isCaptureEnabled();
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.xweb.x5.g.d
 * JD-Core Version:    0.7.0.1
 */