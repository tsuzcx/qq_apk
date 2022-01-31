package com.tencent.mmkv;

import android.app.ActivityManager;
import android.app.ActivityManager.RunningAppProcessInfo;
import android.content.ComponentName;
import android.content.ContentProvider;
import android.content.ContentValues;
import android.content.Context;
import android.content.pm.PackageManager;
import android.content.pm.ProviderInfo;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Iterator;
import java.util.List;

public class MMKVContentProvider
  extends ContentProvider
{
  private static Uri AZO;
  
  protected static String aE(Context paramContext, int paramInt)
  {
    AppMethodBeat.i(124040);
    paramContext = (ActivityManager)paramContext.getSystemService("activity");
    if (paramContext != null)
    {
      paramContext = paramContext.getRunningAppProcesses().iterator();
      while (paramContext.hasNext())
      {
        ActivityManager.RunningAppProcessInfo localRunningAppProcessInfo = (ActivityManager.RunningAppProcessInfo)paramContext.next();
        if (localRunningAppProcessInfo.pid == paramInt)
        {
          paramContext = localRunningAppProcessInfo.processName;
          AppMethodBeat.o(124040);
          return paramContext;
        }
      }
    }
    AppMethodBeat.o(124040);
    return "";
  }
  
  private static String gS(Context paramContext)
  {
    AppMethodBeat.i(124038);
    try
    {
      ComponentName localComponentName = new ComponentName(paramContext, MMKVContentProvider.class.getName());
      paramContext = paramContext.getPackageManager();
      if (paramContext != null)
      {
        paramContext = paramContext.getProviderInfo(localComponentName, 0);
        if (paramContext != null)
        {
          paramContext = paramContext.authority;
          AppMethodBeat.o(124038);
          return paramContext;
        }
      }
    }
    catch (Exception paramContext)
    {
      AppMethodBeat.o(124038);
    }
    return null;
  }
  
  protected static Uri iP(Context paramContext)
  {
    AppMethodBeat.i(124037);
    if (AZO != null)
    {
      paramContext = AZO;
      AppMethodBeat.o(124037);
      return paramContext;
    }
    if (paramContext == null)
    {
      AppMethodBeat.o(124037);
      return null;
    }
    paramContext = gS(paramContext);
    if (paramContext == null)
    {
      AppMethodBeat.o(124037);
      return null;
    }
    paramContext = Uri.parse("content://".concat(String.valueOf(paramContext)));
    AZO = paramContext;
    AppMethodBeat.o(124037);
    return paramContext;
  }
  
  public Bundle call(String paramString1, String paramString2, Bundle paramBundle)
  {
    AppMethodBeat.i(124041);
    if ((paramString1.equals("mmkvFromAshmemID")) && (paramBundle != null))
    {
      int i = paramBundle.getInt("KEY_SIZE");
      int j = paramBundle.getInt("KEY_MODE");
      paramString1 = paramBundle.getString("KEY_CRYPT");
      paramBundle = MMKV.mmkvWithAshmemID(getContext(), paramString2, i, j, paramString1);
      if (paramBundle != null)
      {
        paramString1 = new ParcelableMMKV(paramBundle);
        new StringBuilder().append(paramString2).append(" fd = ").append(paramBundle.ashmemFD()).append(", meta fd = ").append(paramBundle.ashmemMetaFD());
        paramString2 = new Bundle();
        paramString2.putParcelable("KEY", paramString1);
        AppMethodBeat.o(124041);
        return paramString2;
      }
      AppMethodBeat.o(124041);
      return null;
    }
    AppMethodBeat.o(124041);
    return null;
  }
  
  public int delete(Uri paramUri, String paramString, String[] paramArrayOfString)
  {
    AppMethodBeat.i(124044);
    paramUri = new UnsupportedOperationException("Not implement in MMKV");
    AppMethodBeat.o(124044);
    throw paramUri;
  }
  
  public String getType(Uri paramUri)
  {
    return null;
  }
  
  public Uri insert(Uri paramUri, ContentValues paramContentValues)
  {
    AppMethodBeat.i(124045);
    paramUri = new UnsupportedOperationException("Not implement in MMKV");
    AppMethodBeat.o(124045);
    throw paramUri;
  }
  
  public boolean onCreate()
  {
    AppMethodBeat.i(124039);
    Object localObject = getContext();
    if (localObject == null)
    {
      AppMethodBeat.o(124039);
      return false;
    }
    localObject = gS((Context)localObject);
    if (localObject == null)
    {
      AppMethodBeat.o(124039);
      return false;
    }
    if (AZO == null) {
      AZO = Uri.parse("content://".concat(String.valueOf(localObject)));
    }
    AppMethodBeat.o(124039);
    return true;
  }
  
  public Cursor query(Uri paramUri, String[] paramArrayOfString1, String paramString1, String[] paramArrayOfString2, String paramString2)
  {
    AppMethodBeat.i(124042);
    paramUri = new UnsupportedOperationException("Not implement in MMKV");
    AppMethodBeat.o(124042);
    throw paramUri;
  }
  
  public int update(Uri paramUri, ContentValues paramContentValues, String paramString, String[] paramArrayOfString)
  {
    AppMethodBeat.i(124043);
    paramUri = new UnsupportedOperationException("Not implement in MMKV");
    AppMethodBeat.o(124043);
    throw paramUri;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mmkv.MMKVContentProvider
 * JD-Core Version:    0.7.0.1
 */