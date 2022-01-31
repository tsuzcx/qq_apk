package com.tencent.smtt.sdk;

import android.content.Intent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.smtt.export.external.interfaces.IX5WebChromeClient.FileChooserParams;

class v
  extends WebChromeClient.FileChooserParams
{
  v(r paramr, IX5WebChromeClient.FileChooserParams paramFileChooserParams) {}
  
  public Intent createIntent()
  {
    AppMethodBeat.i(139067);
    Intent localIntent = this.a.createIntent();
    AppMethodBeat.o(139067);
    return localIntent;
  }
  
  public String[] getAcceptTypes()
  {
    AppMethodBeat.i(139063);
    String[] arrayOfString = this.a.getAcceptTypes();
    AppMethodBeat.o(139063);
    return arrayOfString;
  }
  
  public String getFilenameHint()
  {
    AppMethodBeat.i(139066);
    String str = this.a.getFilenameHint();
    AppMethodBeat.o(139066);
    return str;
  }
  
  public int getMode()
  {
    AppMethodBeat.i(139062);
    int i = this.a.getMode();
    AppMethodBeat.o(139062);
    return i;
  }
  
  public CharSequence getTitle()
  {
    AppMethodBeat.i(139065);
    CharSequence localCharSequence = this.a.getTitle();
    AppMethodBeat.o(139065);
    return localCharSequence;
  }
  
  public boolean isCaptureEnabled()
  {
    AppMethodBeat.i(139064);
    boolean bool = this.a.isCaptureEnabled();
    AppMethodBeat.o(139064);
    return bool;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.smtt.sdk.v
 * JD-Core Version:    0.7.0.1
 */