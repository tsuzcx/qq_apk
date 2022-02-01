package com.tencent.mm.plugin.normsg;

import android.content.ContentProvider;
import android.content.ContentValues;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ae;

public final class NormsgInfoProvider
  extends ContentProvider
{
  public static final Uri CONTENT_URI;
  
  static
  {
    AppMethodBeat.i(189706);
    CONTENT_URI = Uri.parse("content://com.tencent.mm.plugin.normsg.NMInfo");
    AppMethodBeat.o(189706);
  }
  
  private boolean auz(String paramString)
  {
    AppMethodBeat.i(189703);
    try
    {
      String str = getCallingPackage();
      ae.i("MicroMsg.NormsgIP", "isReqFrom " + str + "; expectPkg " + paramString);
      if ((str != null) && (str.equals(paramString)))
      {
        AppMethodBeat.o(189703);
        return true;
      }
      AppMethodBeat.o(189703);
      return false;
    }
    catch (Exception paramString)
    {
      ae.e("MicroMsg.NormsgIP", "isReqFrom error:" + paramString.toString());
      AppMethodBeat.o(189703);
    }
    return false;
  }
  
  private Bundle dxX()
  {
    AppMethodBeat.i(189704);
    if (!auz(b.wJi.auA(".!\"f=/%' (3n,-!51;.)")))
    {
      AppMethodBeat.o(189704);
      return null;
    }
    for (;;)
    {
      try
      {
        String str = com.tencent.mm.plugin.normsg.a.b.wJt.dyk();
        if (str == null)
        {
          str = "";
          Bundle localBundle = new Bundle();
          localBundle.putString("STR_RESULT", str);
          AppMethodBeat.o(189704);
          return localBundle;
        }
      }
      catch (Throwable localThrowable)
      {
        AppMethodBeat.o(189704);
        return null;
      }
    }
  }
  
  public final Bundle call(String paramString1, String paramString2, Bundle paramBundle)
  {
    AppMethodBeat.i(189705);
    ae.i("MicroMsg.NormsgIP", "invoke: %s, with arg: %s", new Object[] { paramString1, paramString2 });
    if ("m0".equals(paramString1))
    {
      paramString1 = dxX();
      AppMethodBeat.o(189705);
      return paramString1;
    }
    ae.w("MicroMsg.NormsgIP", "unknown method: %s", new Object[] { paramString1 });
    AppMethodBeat.o(189705);
    return null;
  }
  
  public final int delete(Uri paramUri, String paramString, String[] paramArrayOfString)
  {
    return 0;
  }
  
  public final String getType(Uri paramUri)
  {
    return null;
  }
  
  public final Uri insert(Uri paramUri, ContentValues paramContentValues)
  {
    return null;
  }
  
  public final boolean onCreate()
  {
    AppMethodBeat.i(189702);
    com.tencent.mm.plugin.normsg.a.b.a(b.wJi);
    AppMethodBeat.o(189702);
    return true;
  }
  
  public final Cursor query(Uri paramUri, String[] paramArrayOfString1, String paramString1, String[] paramArrayOfString2, String paramString2)
  {
    return null;
  }
  
  public final int update(Uri paramUri, ContentValues paramContentValues, String paramString, String[] paramArrayOfString)
  {
    return 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.normsg.NormsgInfoProvider
 * JD-Core Version:    0.7.0.1
 */