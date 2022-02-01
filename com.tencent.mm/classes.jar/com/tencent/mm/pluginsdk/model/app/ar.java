package com.tencent.mm.pluginsdk.model.app;

import android.net.Uri;

public final class ar
{
  public static ar BRb = null;
  public static long BRc = -1L;
  public String BQZ = "";
  public String[] BRa = null;
  public int code = -1;
  public String[] projection = null;
  public String selection = "";
  public String[] selectionArgs = null;
  public Uri uri = null;
  
  public ar(Uri paramUri, String[] paramArrayOfString1, String paramString1, String[] paramArrayOfString2, String paramString2, int paramInt, String[] paramArrayOfString3)
  {
    this.uri = paramUri;
    this.projection = paramArrayOfString1;
    this.selection = paramString1;
    this.selectionArgs = paramArrayOfString2;
    this.BQZ = paramString2;
    this.code = paramInt;
    this.BRa = paramArrayOfString3;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.model.app.ar
 * JD-Core Version:    0.7.0.1
 */