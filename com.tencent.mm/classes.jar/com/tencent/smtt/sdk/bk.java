package com.tencent.smtt.sdk;

import android.graphics.Bitmap;
import com.tencent.smtt.export.external.interfaces.IconListener;

class bk
  implements IconListener
{
  bk(WebIconDatabase paramWebIconDatabase, WebIconDatabase.a parama) {}
  
  public void onReceivedIcon(String paramString, Bitmap paramBitmap)
  {
    this.a.a(paramString, paramBitmap);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.smtt.sdk.bk
 * JD-Core Version:    0.7.0.1
 */