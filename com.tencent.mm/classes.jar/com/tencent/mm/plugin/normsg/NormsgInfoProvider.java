package com.tencent.mm.plugin.normsg;

import android.content.ContentProvider;
import android.content.ContentValues;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ad;

public final class NormsgInfoProvider
  extends ContentProvider
{
  public static final Uri CONTENT_URI;
  
  static
  {
    AppMethodBeat.i(219058);
    CONTENT_URI = Uri.parse("content://com.tencent.mm.plugin.normsg.NMInfo");
    AppMethodBeat.o(219058);
  }
  
  private boolean atm(String paramString)
  {
    AppMethodBeat.i(219055);
    try
    {
      String str = getCallingPackage();
      ad.i("MicroMsg.NormsgIP", "isReqFrom " + str + "; expectPkg " + paramString);
      if ((str != null) && (str.equals(paramString)))
      {
        AppMethodBeat.o(219055);
        return true;
      }
      AppMethodBeat.o(219055);
      return false;
    }
    catch (Exception paramString)
    {
      ad.e("MicroMsg.NormsgIP", "isReqFrom error:" + paramString.toString());
      AppMethodBeat.o(219055);
    }
    return false;
  }
  
  private Bundle duH()
  {
    AppMethodBeat.i(219056);
    if (!atm(b.wty.atn(".!\"f=/%' (3n,-!51;.)")))
    {
      AppMethodBeat.o(219056);
      return null;
    }
    for (;;)
    {
      try
      {
        String str = com.tencent.mm.plugin.normsg.a.b.wtJ.duU();
        if (str == null)
        {
          str = "";
          Bundle localBundle = new Bundle();
          localBundle.putString("STR_RESULT", str);
          AppMethodBeat.o(219056);
          return localBundle;
        }
      }
      catch (Throwable localThrowable)
      {
        AppMethodBeat.o(219056);
        return null;
      }
    }
  }
  
  public final Bundle call(String paramString1, String paramString2, Bundle paramBundle)
  {
    AppMethodBeat.i(219057);
    ad.i("MicroMsg.NormsgIP", "invoke: %s, with arg: %s", new Object[] { paramString1, paramString2 });
    if ("m0".equals(paramString1))
    {
      paramString1 = duH();
      AppMethodBeat.o(219057);
      return paramString1;
    }
    ad.w("MicroMsg.NormsgIP", "unknown method: %s", new Object[] { paramString1 });
    AppMethodBeat.o(219057);
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
    AppMethodBeat.i(219054);
    com.tencent.mm.plugin.normsg.a.b.a(b.wty);
    AppMethodBeat.o(219054);
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