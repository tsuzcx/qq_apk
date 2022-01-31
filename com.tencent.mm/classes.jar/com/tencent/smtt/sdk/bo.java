package com.tencent.smtt.sdk;

import android.graphics.Bitmap;
import android.webkit.WebIconDatabase.IconListener;
import com.tencent.matrix.trace.core.AppMethodBeat;

class bo
  implements WebIconDatabase.IconListener
{
  bo(WebIconDatabase paramWebIconDatabase, WebIconDatabase.a parama) {}
  
  public void onReceivedIcon(String paramString, Bitmap paramBitmap)
  {
    AppMethodBeat.i(139417);
    this.a.a(paramString, paramBitmap);
    AppMethodBeat.o(139417);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.smtt.sdk.bo
 * JD-Core Version:    0.7.0.1
 */