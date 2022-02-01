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
    AppMethodBeat.i(261906);
    AUTHORITY = WeChatAuthorities.AUTHORITIES_PLUGIN_NORMSG_NMINFO();
    CONTENT_URI = Uri.parse("content://" + AUTHORITY);
    AppMethodBeat.o(261906);
  }
  
  private boolean aQe(String paramString)
  {
    AppMethodBeat.i(261894);
    try
    {
      String str = getCallingPackage();
      Log.i("MicroMsg.NormsgIP", "isReqFrom " + str + "; expectPkg " + paramString);
      if ((str != null) && (str.equals(paramString)))
      {
        AppMethodBeat.o(261894);
        return true;
      }
      AppMethodBeat.o(261894);
      return false;
    }
    catch (Exception paramString)
    {
      Log.e("MicroMsg.NormsgIP", "isReqFrom error:" + paramString.toString());
      AppMethodBeat.o(261894);
    }
    return false;
  }
  
  private Bundle gtz()
  {
    AppMethodBeat.i(261901);
    if (!aQe(b.MtE.aQf(".!\"f=/%' (3n,-!51;.)")))
    {
      AppMethodBeat.o(261901);
      return null;
    }
    for (;;)
    {
      try
      {
        String str = d.MtP.gtK();
        if (str == null)
        {
          str = "";
          localBundle = new Bundle();
          localBundle.putString("STR_RESULT", str);
        }
      }
      finally
      {
        Bundle localBundle;
        AppMethodBeat.o(261901);
        return null;
      }
    }
  }
  
  public final Bundle call(String paramString1, String paramString2, Bundle paramBundle)
  {
    AppMethodBeat.i(261919);
    Log.i("MicroMsg.NormsgIP", "invoke: %s, with arg: %s", new Object[] { paramString1, paramString2 });
    if ("m0".equals(paramString1))
    {
      paramString1 = gtz();
      AppMethodBeat.o(261919);
      return paramString1;
    }
    Log.w("MicroMsg.NormsgIP", "unknown method: %s", new Object[] { paramString1 });
    AppMethodBeat.o(261919);
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
    AppMethodBeat.i(261912);
    d.a(b.MtE);
    AppMethodBeat.o(261912);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.normsg.NormsgInfoProvider
 * JD-Core Version:    0.7.0.1
 */