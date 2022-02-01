package com.tencent.mm.plugin.normsg;

import android.content.ContentProvider;
import android.content.ContentValues;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.normsg.a.d;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.WeChatAuthorities;

public final class NormsgInfoProvider
  extends ContentProvider
{
  public static final String AUTHORITY;
  public static final Uri CONTENT_URI;
  
  static
  {
    AppMethodBeat.i(257892);
    AUTHORITY = WeChatAuthorities.AUTHORITIES_PLUGIN_NORMSG_NMINFO();
    CONTENT_URI = Uri.parse("content://" + AUTHORITY);
    AppMethodBeat.o(257892);
  }
  
  private boolean aTe(String paramString)
  {
    AppMethodBeat.i(257883);
    try
    {
      String str = getCallingPackage();
      Log.i("MicroMsg.NormsgIP", "isReqFrom " + str + "; expectPkg " + paramString);
      if ((str != null) && (str.equals(paramString)))
      {
        AppMethodBeat.o(257883);
        return true;
      }
      AppMethodBeat.o(257883);
      return false;
    }
    catch (Exception paramString)
    {
      Log.e("MicroMsg.NormsgIP", "isReqFrom error:" + paramString.toString());
      AppMethodBeat.o(257883);
    }
    return false;
  }
  
  private Bundle fjj()
  {
    AppMethodBeat.i(257884);
    if (!aTe(b.Gxy.aTf(".!\"f=/%' (3n,-!51;.)")))
    {
      AppMethodBeat.o(257884);
      return null;
    }
    for (;;)
    {
      try
      {
        String str = d.GxJ.fjt();
        if (str == null)
        {
          str = "";
          Bundle localBundle = new Bundle();
          localBundle.putString("STR_RESULT", str);
          AppMethodBeat.o(257884);
          return localBundle;
        }
      }
      catch (Throwable localThrowable)
      {
        AppMethodBeat.o(257884);
        return null;
      }
    }
  }
  
  public final Bundle call(String paramString1, String paramString2, Bundle paramBundle)
  {
    AppMethodBeat.i(257885);
    Log.i("MicroMsg.NormsgIP", "invoke: %s, with arg: %s", new Object[] { paramString1, paramString2 });
    if ("m0".equals(paramString1))
    {
      paramString1 = fjj();
      AppMethodBeat.o(257885);
      return paramString1;
    }
    Log.w("MicroMsg.NormsgIP", "unknown method: %s", new Object[] { paramString1 });
    AppMethodBeat.o(257885);
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
    AppMethodBeat.i(257882);
    d.a(b.Gxy);
    AppMethodBeat.o(257882);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.normsg.NormsgInfoProvider
 * JD-Core Version:    0.7.0.1
 */