package com.tencent.smtt.sdk;

import android.content.Intent;
import com.tencent.smtt.export.external.interfaces.IX5WebChromeClient.FileChooserParams;

class u
  extends WebChromeClient.FileChooserParams
{
  u(q paramq, IX5WebChromeClient.FileChooserParams paramFileChooserParams) {}
  
  public Intent createIntent()
  {
    return this.a.createIntent();
  }
  
  public String[] getAcceptTypes()
  {
    return this.a.getAcceptTypes();
  }
  
  public String getFilenameHint()
  {
    return this.a.getFilenameHint();
  }
  
  public int getMode()
  {
    return this.a.getMode();
  }
  
  public CharSequence getTitle()
  {
    return this.a.getTitle();
  }
  
  public boolean isCaptureEnabled()
  {
    return this.a.isCaptureEnabled();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.smtt.sdk.u
 * JD-Core Version:    0.7.0.1
 */