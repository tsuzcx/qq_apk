package com.tencent.mm.plugin.normsg;

import android.content.ContentProvider;
import android.content.ContentResolver;
import android.content.ContentValues;
import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ad;

public final class NormsgDataProvider
  extends ContentProvider
{
  public static final Uri CONTENT_URI;
  
  static
  {
    AppMethodBeat.i(148937);
    CONTENT_URI = Uri.parse("content://com.tencent.mm.plugin.normsg.NMData");
    AppMethodBeat.o(148937);
  }
  
  public static String G(Context paramContext, String paramString)
  {
    AppMethodBeat.i(148934);
    paramContext = paramContext.getContentResolver().call(CONTENT_URI, "m0", paramString, null);
    if (paramContext != null)
    {
      paramContext = paramContext.getString("result", "");
      AppMethodBeat.o(148934);
      return paramContext;
    }
    AppMethodBeat.o(148934);
    return "";
  }
  
  private String atl(String paramString)
  {
    AppMethodBeat.i(148935);
    try
    {
      PackageManager localPackageManager = getContext().getPackageManager();
      paramString = localPackageManager.getApplicationInfo(paramString, 0).loadLabel(localPackageManager).toString();
      AppMethodBeat.o(148935);
      return paramString;
    }
    catch (Throwable paramString)
    {
      AppMethodBeat.o(148935);
    }
    return "";
  }
  
  public static boolean cQ(Context paramContext)
  {
    AppMethodBeat.i(219052);
    paramContext = paramContext.getContentResolver().call(CONTENT_URI, "m1", null, null);
    if (paramContext != null)
    {
      boolean bool = paramContext.getBoolean("result", false);
      AppMethodBeat.o(219052);
      return bool;
    }
    AppMethodBeat.o(219052);
    return false;
  }
  
  private static boolean duG()
  {
    AppMethodBeat.i(219053);
    try
    {
      boolean bool = com.tencent.mm.plugin.normsg.a.b.wtJ.duS();
      AppMethodBeat.o(219053);
      return bool;
    }
    catch (Throwable localThrowable)
    {
      AppMethodBeat.o(219053);
    }
    return false;
  }
  
  public final Bundle call(String paramString1, String paramString2, Bundle paramBundle)
  {
    AppMethodBeat.i(148936);
    ad.i("MicroMsg.NormsgDP", "invoke method: %s, with arg: %s, extras: %s", new Object[] { paramString1, paramString2, paramBundle });
    if ("m0".equals(paramString1))
    {
      paramString1 = new Bundle();
      paramString1.putString("result", atl(paramString2));
      AppMethodBeat.o(148936);
      return paramString1;
    }
    if ("m1".equals(paramString1))
    {
      paramString1 = new Bundle();
      paramString1.putBoolean("result", duG());
      AppMethodBeat.o(148936);
      return paramString1;
    }
    ad.w("MicroMsg.NormsgDP", "unknown method: %s", new Object[] { paramString1 });
    AppMethodBeat.o(148936);
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
    AppMethodBeat.i(219051);
    com.tencent.mm.plugin.normsg.a.b.a(b.wty);
    AppMethodBeat.o(219051);
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
 * Qualified Name:     com.tencent.mm.plugin.normsg.NormsgDataProvider
 * JD-Core Version:    0.7.0.1
 */