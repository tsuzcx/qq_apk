package com.tencent.smtt.sdk;

import android.content.Intent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.smtt.export.external.interfaces.IX5WebChromeClient.FileChooserParams;

class j$4
  extends WebChromeClient.FileChooserParams
{
  j$4(j paramj, IX5WebChromeClient.FileChooserParams paramFileChooserParams) {}
  
  public Intent createIntent()
  {
    AppMethodBeat.i(188182);
    Intent localIntent = this.a.createIntent();
    AppMethodBeat.o(188182);
    return localIntent;
  }
  
  public String[] getAcceptTypes()
  {
    AppMethodBeat.i(188178);
    String[] arrayOfString = this.a.getAcceptTypes();
    AppMethodBeat.o(188178);
    return arrayOfString;
  }
  
  public String getFilenameHint()
  {
    AppMethodBeat.i(188181);
    String str = this.a.getFilenameHint();
    AppMethodBeat.o(188181);
    return str;
  }
  
  public int getMode()
  {
    AppMethodBeat.i(188177);
    int i = this.a.getMode();
    AppMethodBeat.o(188177);
    return i;
  }
  
  public CharSequence getTitle()
  {
    AppMethodBeat.i(188180);
    CharSequence localCharSequence = this.a.getTitle();
    AppMethodBeat.o(188180);
    return localCharSequence;
  }
  
  public boolean isCaptureEnabled()
  {
    AppMethodBeat.i(188179);
    boolean bool = this.a.isCaptureEnabled();
    AppMethodBeat.o(188179);
    return bool;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.smtt.sdk.j.4
 * JD-Core Version:    0.7.0.1
 */