package com.tencent.smtt.sdk;

import android.content.Intent;
import com.tencent.matrix.trace.core.AppMethodBeat;

class SystemWebChromeClient$5
  extends WebChromeClient.FileChooserParams
{
  SystemWebChromeClient$5(SystemWebChromeClient paramSystemWebChromeClient, android.webkit.WebChromeClient.FileChooserParams paramFileChooserParams) {}
  
  public Intent createIntent()
  {
    AppMethodBeat.i(54062);
    Intent localIntent = this.a.createIntent();
    AppMethodBeat.o(54062);
    return localIntent;
  }
  
  public String[] getAcceptTypes()
  {
    AppMethodBeat.i(54058);
    String[] arrayOfString = this.a.getAcceptTypes();
    AppMethodBeat.o(54058);
    return arrayOfString;
  }
  
  public String getFilenameHint()
  {
    AppMethodBeat.i(54061);
    String str = this.a.getFilenameHint();
    AppMethodBeat.o(54061);
    return str;
  }
  
  public int getMode()
  {
    AppMethodBeat.i(54057);
    int i = this.a.getMode();
    AppMethodBeat.o(54057);
    return i;
  }
  
  public CharSequence getTitle()
  {
    AppMethodBeat.i(54060);
    CharSequence localCharSequence = this.a.getTitle();
    AppMethodBeat.o(54060);
    return localCharSequence;
  }
  
  public boolean isCaptureEnabled()
  {
    AppMethodBeat.i(54059);
    boolean bool = this.a.isCaptureEnabled();
    AppMethodBeat.o(54059);
    return bool;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.smtt.sdk.SystemWebChromeClient.5
 * JD-Core Version:    0.7.0.1
 */