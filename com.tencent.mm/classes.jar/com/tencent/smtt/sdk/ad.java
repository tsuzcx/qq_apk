package com.tencent.smtt.sdk;

import android.content.Intent;
import com.tencent.matrix.trace.core.AppMethodBeat;

class ad
  extends WebChromeClient.FileChooserParams
{
  ad(SystemWebChromeClient paramSystemWebChromeClient, android.webkit.WebChromeClient.FileChooserParams paramFileChooserParams) {}
  
  public Intent createIntent()
  {
    AppMethodBeat.i(139137);
    Intent localIntent = this.a.createIntent();
    AppMethodBeat.o(139137);
    return localIntent;
  }
  
  public String[] getAcceptTypes()
  {
    AppMethodBeat.i(139133);
    String[] arrayOfString = this.a.getAcceptTypes();
    AppMethodBeat.o(139133);
    return arrayOfString;
  }
  
  public String getFilenameHint()
  {
    AppMethodBeat.i(139136);
    String str = this.a.getFilenameHint();
    AppMethodBeat.o(139136);
    return str;
  }
  
  public int getMode()
  {
    AppMethodBeat.i(139132);
    int i = this.a.getMode();
    AppMethodBeat.o(139132);
    return i;
  }
  
  public CharSequence getTitle()
  {
    AppMethodBeat.i(139135);
    CharSequence localCharSequence = this.a.getTitle();
    AppMethodBeat.o(139135);
    return localCharSequence;
  }
  
  public boolean isCaptureEnabled()
  {
    AppMethodBeat.i(139134);
    boolean bool = this.a.isCaptureEnabled();
    AppMethodBeat.o(139134);
    return bool;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.smtt.sdk.ad
 * JD-Core Version:    0.7.0.1
 */