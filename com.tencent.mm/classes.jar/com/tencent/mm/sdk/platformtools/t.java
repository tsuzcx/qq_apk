package com.tencent.mm.sdk.platformtools;

import android.content.Intent;
import android.os.Bundle;
import android.os.Parcelable;

public final class t
{
  public static int a(Intent paramIntent, String paramString, int paramInt)
  {
    if (paramIntent == null) {
      return paramInt;
    }
    try
    {
      int i = paramIntent.getIntExtra(paramString, paramInt);
      return i;
    }
    catch (Exception paramIntent)
    {
      y.e("MicroMsg.IntentUtil", "getIntExtra exception:%s", new Object[] { paramIntent.getMessage() });
    }
    return paramInt;
  }
  
  public static boolean a(Intent paramIntent, String paramString, boolean paramBoolean)
  {
    if (paramIntent == null) {
      return paramBoolean;
    }
    try
    {
      boolean bool = paramIntent.getBooleanExtra(paramString, paramBoolean);
      return bool;
    }
    catch (Exception paramIntent)
    {
      y.e("MicroMsg.IntentUtil", "getBooleanExtra exception:%s", new Object[] { paramIntent.getMessage() });
    }
    return paramBoolean;
  }
  
  public static Bundle al(Intent paramIntent)
  {
    if (paramIntent == null) {
      return null;
    }
    try
    {
      paramIntent = paramIntent.getExtras();
      return paramIntent;
    }
    catch (Exception paramIntent)
    {
      y.e("MicroMsg.IntentUtil", "getExtras exception:%s", new Object[] { paramIntent.getMessage() });
    }
    return null;
  }
  
  public static void b(Intent paramIntent, String paramString, boolean paramBoolean)
  {
    try
    {
      paramIntent.putExtra(paramString, paramBoolean);
      return;
    }
    catch (Exception paramIntent)
    {
      y.printErrStackTrace("MicroMsg.IntentUtil", paramIntent, "", new Object[0]);
    }
  }
  
  public static long i(Intent paramIntent, String paramString)
  {
    if (paramIntent == null) {
      return 0L;
    }
    try
    {
      long l = paramIntent.getLongExtra(paramString, 0L);
      return l;
    }
    catch (Exception paramIntent)
    {
      y.e("MicroMsg.IntentUtil", "getIntExtra exception:%s", new Object[] { paramIntent.getMessage() });
    }
    return 0L;
  }
  
  public static int j(Bundle paramBundle, String paramString)
  {
    if (paramBundle == null) {
      return 0;
    }
    try
    {
      int i = paramBundle.getInt(paramString, 0);
      return i;
    }
    catch (Exception paramBundle)
    {
      y.e("MicroMsg.IntentUtil", "getIntExtra exception:%s", new Object[] { paramBundle.getMessage() });
    }
    return 0;
  }
  
  public static String j(Intent paramIntent, String paramString)
  {
    if (paramIntent == null) {
      return null;
    }
    try
    {
      paramIntent = paramIntent.getStringExtra(paramString);
      return paramIntent;
    }
    catch (Exception paramIntent)
    {
      y.e("MicroMsg.IntentUtil", "getStringExtra exception:%s", new Object[] { paramIntent.getMessage() });
    }
    return null;
  }
  
  public static String k(Bundle paramBundle, String paramString)
  {
    if (paramBundle == null) {
      return null;
    }
    try
    {
      paramBundle = paramBundle.getString(paramString);
      return paramBundle;
    }
    catch (Exception paramBundle)
    {
      y.e("MicroMsg.IntentUtil", "getStringExtra exception:%s", new Object[] { paramBundle.getMessage() });
    }
    return null;
  }
  
  public static byte[] k(Intent paramIntent, String paramString)
  {
    if (paramIntent == null) {
      return null;
    }
    try
    {
      paramIntent = paramIntent.getByteArrayExtra(paramString);
      return paramIntent;
    }
    catch (Exception paramIntent)
    {
      y.e("MicroMsg.IntentUtil", "getByteArrayExtra exception:%s", new Object[] { paramIntent.getMessage() });
    }
    return null;
  }
  
  public static Parcelable l(Intent paramIntent, String paramString)
  {
    if (paramIntent == null) {
      return null;
    }
    try
    {
      paramIntent = paramIntent.getParcelableExtra(paramString);
      return paramIntent;
    }
    catch (Exception paramIntent)
    {
      y.e("MicroMsg.IntentUtil", "getParcelableExtra exception:%s", new Object[] { paramIntent.getMessage() });
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.sdk.platformtools.t
 * JD-Core Version:    0.7.0.1
 */