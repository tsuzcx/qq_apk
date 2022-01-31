package com.tencent.smtt.sdk;

import android.content.ContentResolver;
import com.tencent.matrix.trace.core.AppMethodBeat;

@Deprecated
public class WebIconDatabase
{
  private static WebIconDatabase a;
  
  private static WebIconDatabase a()
  {
    try
    {
      AppMethodBeat.i(64708);
      if (a == null) {
        a = new WebIconDatabase();
      }
      WebIconDatabase localWebIconDatabase = a;
      AppMethodBeat.o(64708);
      return localWebIconDatabase;
    }
    finally {}
  }
  
  public static WebIconDatabase getInstance()
  {
    AppMethodBeat.i(64707);
    WebIconDatabase localWebIconDatabase = a();
    AppMethodBeat.o(64707);
    return localWebIconDatabase;
  }
  
  public void bulkRequestIconForPageUrl(ContentResolver paramContentResolver, String paramString, WebIconDatabase.a parama) {}
  
  public void close()
  {
    AppMethodBeat.i(64702);
    bz localbz = bz.a();
    if ((localbz != null) && (localbz.b()))
    {
      localbz.c().m();
      AppMethodBeat.o(64702);
      return;
    }
    android.webkit.WebIconDatabase.getInstance().close();
    AppMethodBeat.o(64702);
  }
  
  public void open(String paramString)
  {
    AppMethodBeat.i(64701);
    bz localbz = bz.a();
    if ((localbz != null) && (localbz.b()))
    {
      localbz.c().b(paramString);
      AppMethodBeat.o(64701);
      return;
    }
    android.webkit.WebIconDatabase.getInstance().open(paramString);
    AppMethodBeat.o(64701);
  }
  
  public void releaseIconForPageUrl(String paramString)
  {
    AppMethodBeat.i(64706);
    bz localbz = bz.a();
    if ((localbz != null) && (localbz.b()))
    {
      localbz.c().d(paramString);
      AppMethodBeat.o(64706);
      return;
    }
    android.webkit.WebIconDatabase.getInstance().releaseIconForPageUrl(paramString);
    AppMethodBeat.o(64706);
  }
  
  public void removeAllIcons()
  {
    AppMethodBeat.i(64703);
    bz localbz = bz.a();
    if ((localbz != null) && (localbz.b()))
    {
      localbz.c().l();
      AppMethodBeat.o(64703);
      return;
    }
    android.webkit.WebIconDatabase.getInstance().removeAllIcons();
    AppMethodBeat.o(64703);
  }
  
  public void requestIconForPageUrl(String paramString, WebIconDatabase.a parama)
  {
    AppMethodBeat.i(64704);
    bz localbz = bz.a();
    if ((localbz != null) && (localbz.b()))
    {
      localbz.c().a(paramString, new bn(this, parama));
      AppMethodBeat.o(64704);
      return;
    }
    android.webkit.WebIconDatabase.getInstance().requestIconForPageUrl(paramString, new bo(this, parama));
    AppMethodBeat.o(64704);
  }
  
  public void retainIconForPageUrl(String paramString)
  {
    AppMethodBeat.i(64705);
    bz localbz = bz.a();
    if ((localbz != null) && (localbz.b()))
    {
      localbz.c().c(paramString);
      AppMethodBeat.o(64705);
      return;
    }
    android.webkit.WebIconDatabase.getInstance().retainIconForPageUrl(paramString);
    AppMethodBeat.o(64705);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.smtt.sdk.WebIconDatabase
 * JD-Core Version:    0.7.0.1
 */