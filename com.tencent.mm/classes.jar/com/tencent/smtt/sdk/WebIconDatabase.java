package com.tencent.smtt.sdk;

import android.content.ContentResolver;
import android.graphics.Bitmap;
import android.webkit.WebIconDatabase.IconListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.smtt.export.external.interfaces.IX5CoreWebIconDB;
import com.tencent.smtt.export.external.interfaces.IconListener;

@Deprecated
public class WebIconDatabase
  extends z
{
  private static WebIconDatabase a;
  
  private static WebIconDatabase a()
  {
    try
    {
      AppMethodBeat.i(54686);
      if (a == null) {
        a = new WebIconDatabase();
      }
      WebIconDatabase localWebIconDatabase = a;
      AppMethodBeat.o(54686);
      return localWebIconDatabase;
    }
    finally {}
  }
  
  public static WebIconDatabase getInstance()
  {
    AppMethodBeat.i(54685);
    WebIconDatabase localWebIconDatabase = a();
    AppMethodBeat.o(54685);
    return localWebIconDatabase;
  }
  
  public void bulkRequestIconForPageUrl(ContentResolver paramContentResolver, String paramString, a parama) {}
  
  public void close()
  {
    AppMethodBeat.i(54680);
    if (isX5Core())
    {
      getWebIconDBImpl().close();
      AppMethodBeat.o(54680);
      return;
    }
    android.webkit.WebIconDatabase.getInstance().close();
    AppMethodBeat.o(54680);
  }
  
  public void open(String paramString)
  {
    AppMethodBeat.i(54679);
    if (isX5Core())
    {
      getWebIconDBImpl().open(paramString);
      AppMethodBeat.o(54679);
      return;
    }
    android.webkit.WebIconDatabase.getInstance().open(paramString);
    AppMethodBeat.o(54679);
  }
  
  public void releaseIconForPageUrl(String paramString)
  {
    AppMethodBeat.i(54684);
    if (isX5Core())
    {
      getWebIconDBImpl().releaseIconForPageUrl(paramString);
      AppMethodBeat.o(54684);
      return;
    }
    android.webkit.WebIconDatabase.getInstance().releaseIconForPageUrl(paramString);
    AppMethodBeat.o(54684);
  }
  
  public void removeAllIcons()
  {
    AppMethodBeat.i(54681);
    if (isX5Core())
    {
      getWebIconDBImpl().removeAllIcons();
      AppMethodBeat.o(54681);
      return;
    }
    android.webkit.WebIconDatabase.getInstance().removeAllIcons();
    AppMethodBeat.o(54681);
  }
  
  public void requestIconForPageUrl(String paramString, final a parama)
  {
    AppMethodBeat.i(54682);
    if (isX5Core())
    {
      getWebIconDBImpl().requestIconForPageUrl(paramString, new IconListener()
      {
        public void onReceivedIcon(String paramAnonymousString, Bitmap paramAnonymousBitmap)
        {
          AppMethodBeat.i(54625);
          parama.a(paramAnonymousString, paramAnonymousBitmap);
          AppMethodBeat.o(54625);
        }
      });
      AppMethodBeat.o(54682);
      return;
    }
    android.webkit.WebIconDatabase.getInstance().requestIconForPageUrl(paramString, new WebIconDatabase.IconListener()
    {
      public void onReceivedIcon(String paramAnonymousString, Bitmap paramAnonymousBitmap)
      {
        AppMethodBeat.i(54563);
        parama.a(paramAnonymousString, paramAnonymousBitmap);
        AppMethodBeat.o(54563);
      }
    });
    AppMethodBeat.o(54682);
  }
  
  public void retainIconForPageUrl(String paramString)
  {
    AppMethodBeat.i(54683);
    if (isX5Core())
    {
      getWebIconDBImpl().retainIconForPageUrl(paramString);
      AppMethodBeat.o(54683);
      return;
    }
    android.webkit.WebIconDatabase.getInstance().retainIconForPageUrl(paramString);
    AppMethodBeat.o(54683);
  }
  
  @Deprecated
  public static abstract interface a
  {
    public abstract void a(String paramString, Bitmap paramBitmap);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.smtt.sdk.WebIconDatabase
 * JD-Core Version:    0.7.0.1
 */