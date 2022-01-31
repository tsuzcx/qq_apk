package com.tencent.mm.sdk.platformtools;

import android.content.Intent;
import android.os.Bundle;
import android.os.Parcelable;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class w
{
  public static int a(Intent paramIntent, String paramString, int paramInt)
  {
    AppMethodBeat.i(52008);
    if (paramIntent == null)
    {
      AppMethodBeat.o(52008);
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
        ab.e("MicroMsg.IntentUtil", "getIntExtra exception:%s", new Object[] { paramIntent.getMessage() });
      }
    }
    AppMethodBeat.o(52008);
    return paramInt;
  }
  
  public static boolean a(Intent paramIntent, String paramString, boolean paramBoolean)
  {
    AppMethodBeat.i(52012);
    if (paramIntent == null)
    {
      AppMethodBeat.o(52012);
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
        ab.e("MicroMsg.IntentUtil", "getBooleanExtra exception:%s", new Object[] { paramIntent.getMessage() });
      }
    }
    AppMethodBeat.o(52012);
    return paramBoolean;
  }
  
  public static Bundle aL(Intent paramIntent)
  {
    Object localObject = null;
    AppMethodBeat.i(52011);
    if (paramIntent == null)
    {
      AppMethodBeat.o(52011);
      return null;
    }
    try
    {
      paramIntent = paramIntent.getExtras();
      AppMethodBeat.o(52011);
      return paramIntent;
    }
    catch (Exception paramIntent)
    {
      for (;;)
      {
        ab.e("MicroMsg.IntentUtil", "getExtras exception:%s", new Object[] { paramIntent.getMessage() });
        paramIntent = localObject;
      }
    }
  }
  
  public static void b(Intent paramIntent, String paramString, boolean paramBoolean)
  {
    AppMethodBeat.i(52017);
    try
    {
      paramIntent.putExtra(paramString, paramBoolean);
      AppMethodBeat.o(52017);
      return;
    }
    catch (Exception paramIntent)
    {
      ab.printErrStackTrace("MicroMsg.IntentUtil", paramIntent, "", new Object[0]);
      AppMethodBeat.o(52017);
    }
  }
  
  public static int k(Bundle paramBundle, String paramString)
  {
    int i = 0;
    AppMethodBeat.i(52009);
    if (paramBundle == null)
    {
      AppMethodBeat.o(52009);
      return 0;
    }
    try
    {
      int j = paramBundle.getInt(paramString, 0);
      i = j;
    }
    catch (Exception paramBundle)
    {
      for (;;)
      {
        ab.e("MicroMsg.IntentUtil", "getIntExtra exception:%s", new Object[] { paramBundle.getMessage() });
      }
    }
    AppMethodBeat.o(52009);
    return i;
  }
  
  public static String l(Bundle paramBundle, String paramString)
  {
    Object localObject = null;
    AppMethodBeat.i(52014);
    if (paramBundle == null)
    {
      AppMethodBeat.o(52014);
      return null;
    }
    try
    {
      paramBundle = paramBundle.getString(paramString);
      AppMethodBeat.o(52014);
      return paramBundle;
    }
    catch (Exception paramBundle)
    {
      for (;;)
      {
        ab.e("MicroMsg.IntentUtil", "getStringExtra exception:%s", new Object[] { paramBundle.getMessage() });
        paramBundle = localObject;
      }
    }
  }
  
  public static long m(Intent paramIntent, String paramString)
  {
    long l1 = 0L;
    AppMethodBeat.i(52010);
    if (paramIntent == null)
    {
      AppMethodBeat.o(52010);
      return 0L;
    }
    try
    {
      long l2 = paramIntent.getLongExtra(paramString, 0L);
      l1 = l2;
    }
    catch (Exception paramIntent)
    {
      for (;;)
      {
        ab.e("MicroMsg.IntentUtil", "getIntExtra exception:%s", new Object[] { paramIntent.getMessage() });
      }
    }
    AppMethodBeat.o(52010);
    return l1;
  }
  
  public static String n(Intent paramIntent, String paramString)
  {
    Object localObject = null;
    AppMethodBeat.i(52013);
    if (paramIntent == null)
    {
      AppMethodBeat.o(52013);
      return null;
    }
    try
    {
      paramIntent = paramIntent.getStringExtra(paramString);
      AppMethodBeat.o(52013);
      return paramIntent;
    }
    catch (Exception paramIntent)
    {
      for (;;)
      {
        ab.e("MicroMsg.IntentUtil", "getStringExtra exception:%s", new Object[] { paramIntent.getMessage() });
        paramIntent = localObject;
      }
    }
  }
  
  public static byte[] o(Intent paramIntent, String paramString)
  {
    Object localObject = null;
    AppMethodBeat.i(52015);
    if (paramIntent == null)
    {
      AppMethodBeat.o(52015);
      return null;
    }
    try
    {
      paramIntent = paramIntent.getByteArrayExtra(paramString);
      AppMethodBeat.o(52015);
      return paramIntent;
    }
    catch (Exception paramIntent)
    {
      for (;;)
      {
        ab.e("MicroMsg.IntentUtil", "getByteArrayExtra exception:%s", new Object[] { paramIntent.getMessage() });
        paramIntent = localObject;
      }
    }
  }
  
  public static Parcelable p(Intent paramIntent, String paramString)
  {
    Object localObject = null;
    AppMethodBeat.i(52016);
    if (paramIntent == null)
    {
      AppMethodBeat.o(52016);
      return null;
    }
    try
    {
      paramIntent = paramIntent.getParcelableExtra(paramString);
      AppMethodBeat.o(52016);
      return paramIntent;
    }
    catch (Exception paramIntent)
    {
      for (;;)
      {
        ab.e("MicroMsg.IntentUtil", "getParcelableExtra exception:%s", new Object[] { paramIntent.getMessage() });
        paramIntent = localObject;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.sdk.platformtools.w
 * JD-Core Version:    0.7.0.1
 */