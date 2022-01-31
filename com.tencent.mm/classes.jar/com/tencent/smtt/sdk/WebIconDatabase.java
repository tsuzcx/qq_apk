package com.tencent.smtt.sdk;

import android.content.ContentResolver;

@Deprecated
public class WebIconDatabase
{
  private static WebIconDatabase a;
  
  private static WebIconDatabase a()
  {
    try
    {
      if (a == null) {
        a = new WebIconDatabase();
      }
      WebIconDatabase localWebIconDatabase = a;
      return localWebIconDatabase;
    }
    finally {}
  }
  
  public static WebIconDatabase getInstance()
  {
    return a();
  }
  
  public void bulkRequestIconForPageUrl(ContentResolver paramContentResolver, String paramString, WebIconDatabase.a parama) {}
  
  public void close()
  {
    bv localbv = bv.a();
    if ((localbv != null) && (localbv.b()))
    {
      localbv.c().m();
      return;
    }
    android.webkit.WebIconDatabase.getInstance().close();
  }
  
  public void open(String paramString)
  {
    bv localbv = bv.a();
    if ((localbv != null) && (localbv.b()))
    {
      localbv.c().b(paramString);
      return;
    }
    android.webkit.WebIconDatabase.getInstance().open(paramString);
  }
  
  public void releaseIconForPageUrl(String paramString)
  {
    bv localbv = bv.a();
    if ((localbv != null) && (localbv.b()))
    {
      localbv.c().d(paramString);
      return;
    }
    android.webkit.WebIconDatabase.getInstance().releaseIconForPageUrl(paramString);
  }
  
  public void removeAllIcons()
  {
    bv localbv = bv.a();
    if ((localbv != null) && (localbv.b()))
    {
      localbv.c().l();
      return;
    }
    android.webkit.WebIconDatabase.getInstance().removeAllIcons();
  }
  
  public void requestIconForPageUrl(String paramString, WebIconDatabase.a parama)
  {
    bv localbv = bv.a();
    if ((localbv != null) && (localbv.b()))
    {
      localbv.c().a(paramString, new bk(this, parama));
      return;
    }
    android.webkit.WebIconDatabase.getInstance().requestIconForPageUrl(paramString, new bl(this, parama));
  }
  
  public void retainIconForPageUrl(String paramString)
  {
    bv localbv = bv.a();
    if ((localbv != null) && (localbv.b()))
    {
      localbv.c().c(paramString);
      return;
    }
    android.webkit.WebIconDatabase.getInstance().retainIconForPageUrl(paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.smtt.sdk.WebIconDatabase
 * JD-Core Version:    0.7.0.1
 */