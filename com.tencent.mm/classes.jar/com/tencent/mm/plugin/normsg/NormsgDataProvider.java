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
import com.tencent.mm.plugin.normsg.a.b;
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
  
  private String ajo(String paramString)
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
  
  private static boolean cWM()
  {
    AppMethodBeat.i(190941);
    try
    {
      boolean bool = b.ufs.cWY();
      AppMethodBeat.o(190941);
      return bool;
    }
    catch (Throwable localThrowable)
    {
      AppMethodBeat.o(190941);
    }
    return false;
  }
  
  public static String getAPKName(Context paramContext, String paramString)
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
  
  public static boolean getPhoneState(Context paramContext)
  {
    AppMethodBeat.i(190940);
    paramContext = paramContext.getContentResolver().call(CONTENT_URI, "m1", null, null);
    if (paramContext != null)
    {
      boolean bool = paramContext.getBoolean("result", false);
      AppMethodBeat.o(190940);
      return bool;
    }
    AppMethodBeat.o(190940);
    return false;
  }
  
  public final Bundle call(String paramString1, String paramString2, Bundle paramBundle)
  {
    AppMethodBeat.i(148936);
    ad.i("MicroMsg.NormsgDP", "invoke method: %s, with arg: %s, extras: %s", new Object[] { paramString1, paramString2, paramBundle });
    if ("m0".equals(paramString1))
    {
      paramString1 = new Bundle();
      paramString1.putString("result", ajo(paramString2));
      AppMethodBeat.o(148936);
      return paramString1;
    }
    if ("m1".equals(paramString1))
    {
      paramString1 = new Bundle();
      paramString1.putBoolean("result", cWM());
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.normsg.NormsgDataProvider
 * JD-Core Version:    0.7.0.1
 */