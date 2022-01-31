package com.tencent.smtt.sdk;

import android.graphics.Bitmap;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.smtt.export.external.interfaces.IconListener;

class bn
  implements IconListener
{
  bn(WebIconDatabase paramWebIconDatabase, WebIconDatabase.a parama) {}
  
  public void onReceivedIcon(String paramString, Bitmap paramBitmap)
  {
    AppMethodBeat.i(139416);
    this.a.a(paramString, paramBitmap);
    AppMethodBeat.o(139416);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.smtt.sdk.bn
 * JD-Core Version:    0.7.0.1
 */