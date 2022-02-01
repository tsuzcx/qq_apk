package com.tencent.mm.sdk.platformtools;

import android.content.Intent;
import android.os.Bundle;
import android.os.Parcelable;
import com.tencent.matrix.trace.core.AppMethodBeat;

public class IntentUtil
{
  private static final String TAG = "MicroMsg.IntentUtil";
  
  public static boolean getBoolean(Bundle paramBundle, String paramString, boolean paramBoolean)
  {
    AppMethodBeat.i(243558);
    if (paramBundle == null)
    {
      AppMethodBeat.o(243558);
      return paramBoolean;
    }
    try
    {
      boolean bool = paramBundle.getBoolean(paramString, paramBoolean);
      paramBoolean = bool;
    }
    catch (Exception paramBundle)
    {
      for (;;)
      {
        Log.e("MicroMsg.IntentUtil", "getBooleanExtra exception:%s", new Object[] { paramBundle.getMessage() });
      }
    }
    AppMethodBeat.o(243558);
    return paramBoolean;
  }
  
  public static boolean getBooleanExtra(Intent paramIntent, String paramString, boolean paramBoolean)
  {
    AppMethodBeat.i(157568);
    if (paramIntent == null)
    {
      AppMethodBeat.o(157568);
      return paramBoolean;
    }
    try
    {
      boolean bool = paramIntent.getBooleanExtra(paramString, paramBoolean);
      paramBoolean = bool;
    }
    catch (Exception paramIntent)
    {
      for (;;)
      {
        Log.e("MicroMsg.IntentUtil", "getBooleanExtra exception:%s", new Object[] { paramIntent.getMessage() });
      }
    }
    AppMethodBeat.o(157568);
    return paramBoolean;
  }
  
  public static byte[] getByteArray(Bundle paramBundle, String paramString)
  {
    Object localObject = null;
    AppMethodBeat.i(243577);
    if (paramBundle == null)
    {
      AppMethodBeat.o(243577);
      return null;
    }
    try
    {
      paramBundle = paramBundle.getByteArray(paramString);
      AppMethodBeat.o(243577);
      return paramBundle;
    }
    catch (Exception paramBundle)
    {
      for (;;)
      {
        Log.e("MicroMsg.IntentUtil", "getByteArrayExtra exception:%s", new Object[] { paramBundle.getMessage() });
        paramBundle = localObject;
      }
    }
  }
  
  public static byte[] getByteArrayExtra(Intent paramIntent, String paramString)
  {
    Object localObject = null;
    AppMethodBeat.i(157571);
    if (paramIntent == null)
    {
      AppMethodBeat.o(157571);
      return null;
    }
    try
    {
      paramIntent = paramIntent.getByteArrayExtra(paramString);
      AppMethodBeat.o(157571);
      return paramIntent;
    }
    catch (Exception paramIntent)
    {
      for (;;)
      {
        Log.e("MicroMsg.IntentUtil", "getByteArrayExtra exception:%s", new Object[] { paramIntent.getMessage() });
        paramIntent = localObject;
      }
    }
  }
  
  public static Bundle getExtras(Intent paramIntent)
  {
    Object localObject = null;
    AppMethodBeat.i(157567);
    if (paramIntent == null)
    {
      AppMethodBeat.o(157567);
      return null;
    }
    try
    {
      paramIntent = paramIntent.getExtras();
      AppMethodBeat.o(157567);
      return paramIntent;
    }
    catch (Exception paramIntent)
    {
      for (;;)
      {
        Log.e("MicroMsg.IntentUtil", "getExtras exception:%s", new Object[] { paramIntent.getMessage() });
        paramIntent = localObject;
      }
    }
  }
  
  public static int getInt(Bundle paramBundle, String paramString, int paramInt)
  {
    AppMethodBeat.i(243531);
    if (paramBundle == null)
    {
      AppMethodBeat.o(243531);
      return paramInt;
    }
    try
    {
      int i = paramBundle.getInt(paramString, paramInt);
      paramInt = i;
    }
    catch (Exception paramBundle)
    {
      for (;;)
      {
        Log.e("MicroMsg.IntentUtil", "getIntExtra exception:%s", new Object[] { paramBundle.getMessage() });
      }
    }
    AppMethodBeat.o(243531);
    return paramInt;
  }
  
  public static int getIntExtra(Intent paramIntent, String paramString, int paramInt)
  {
    AppMethodBeat.i(157564);
    if (paramIntent == null)
    {
      AppMethodBeat.o(157564);
      return paramInt;
    }
    try
    {
      int i = paramIntent.getIntExtra(paramString, paramInt);
      paramInt = i;
    }
    catch (Exception paramIntent)
    {
      for (;;)
      {
        Log.e("MicroMsg.IntentUtil", "getIntExtra exception:%s", new Object[] { paramIntent.getMessage() });
      }
    }
    AppMethodBeat.o(157564);
    return paramInt;
  }
  
  public static long getLong(Bundle paramBundle, String paramString, long paramLong)
  {
    AppMethodBeat.i(243543);
    if (paramBundle == null)
    {
      AppMethodBeat.o(243543);
      return paramLong;
    }
    try
    {
      long l = paramBundle.getLong(paramString, paramLong);
      paramLong = l;
    }
    catch (Exception paramBundle)
    {
      for (;;)
      {
        Log.e("MicroMsg.IntentUtil", "getIntExtra exception:%s", new Object[] { paramBundle.getMessage() });
      }
    }
    AppMethodBeat.o(243543);
    return paramLong;
  }
  
  public static long getLongExtra(Intent paramIntent, String paramString, long paramLong)
  {
    AppMethodBeat.i(243537);
    if (paramIntent == null)
    {
      AppMethodBeat.o(243537);
      return paramLong;
    }
    try
    {
      long l = paramIntent.getLongExtra(paramString, paramLong);
      paramLong = l;
    }
    catch (Exception paramIntent)
    {
      for (;;)
      {
        Log.e("MicroMsg.IntentUtil", "getIntExtra exception:%s", new Object[] { paramIntent.getMessage() });
      }
    }
    AppMethodBeat.o(243537);
    return paramLong;
  }
  
  public static Parcelable getParcelableExtra(Intent paramIntent, String paramString)
  {
    Object localObject = null;
    AppMethodBeat.i(157572);
    if (paramIntent == null)
    {
      AppMethodBeat.o(157572);
      return null;
    }
    try
    {
      paramIntent = paramIntent.getParcelableExtra(paramString);
      AppMethodBeat.o(157572);
      return paramIntent;
    }
    catch (Exception paramIntent)
    {
      for (;;)
      {
        Log.e("MicroMsg.IntentUtil", "getParcelableExtra exception:%s", new Object[] { paramIntent.getMessage() });
        paramIntent = localObject;
      }
    }
  }
  
  public static String getString(Bundle paramBundle, String paramString)
  {
    Object localObject = null;
    AppMethodBeat.i(157570);
    if (paramBundle == null)
    {
      AppMethodBeat.o(157570);
      return null;
    }
    try
    {
      paramBundle = paramBundle.getString(paramString);
      AppMethodBeat.o(157570);
      return paramBundle;
    }
    catch (Exception paramBundle)
    {
      for (;;)
      {
        Log.e("MicroMsg.IntentUtil", "getStringExtra exception:%s", new Object[] { paramBundle.getMessage() });
        paramBundle = localObject;
      }
    }
  }
  
  public static String getStringExtra(Intent paramIntent, String paramString)
  {
    Object localObject = null;
    AppMethodBeat.i(157569);
    if (paramIntent == null)
    {
      AppMethodBeat.o(157569);
      return null;
    }
    try
    {
      paramIntent = paramIntent.getStringExtra(paramString);
      AppMethodBeat.o(157569);
      return paramIntent;
    }
    catch (Exception paramIntent)
    {
      for (;;)
      {
        Log.e("MicroMsg.IntentUtil", "getStringExtra exception:%s", new Object[] { paramIntent.getMessage() });
        paramIntent = localObject;
      }
    }
  }
  
  public static void putExtra(Intent paramIntent, String paramString, int paramInt)
  {
    AppMethodBeat.i(243587);
    try
    {
      paramIntent.putExtra(paramString, paramInt);
      AppMethodBeat.o(243587);
      return;
    }
    catch (Exception paramIntent)
    {
      Log.printErrStackTrace("MicroMsg.IntentUtil", paramIntent, "", new Object[0]);
      AppMethodBeat.o(243587);
    }
  }
  
  public static void putExtra(Intent paramIntent, String paramString, boolean paramBoolean)
  {
    AppMethodBeat.i(157573);
    try
    {
      paramIntent.putExtra(paramString, paramBoolean);
      AppMethodBeat.o(157573);
      return;
    }
    catch (Exception paramIntent)
    {
      Log.printErrStackTrace("MicroMsg.IntentUtil", paramIntent, "", new Object[0]);
      AppMethodBeat.o(157573);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.sdk.platformtools.IntentUtil
 * JD-Core Version:    0.7.0.1
 */