package com.tencent.mm.sdk.platformtools;

import android.content.Intent;
import android.os.Bundle;
import android.os.Parcelable;
import com.tencent.matrix.trace.core.AppMethodBeat;

public class y
{
  public static void b(Intent paramIntent, String paramString, boolean paramBoolean)
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
      ad.printErrStackTrace("MicroMsg.IntentUtil", paramIntent, "", new Object[0]);
      AppMethodBeat.o(157573);
    }
  }
  
  public static Bundle bk(Intent paramIntent)
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
        ad.e("MicroMsg.IntentUtil", "getExtras exception:%s", new Object[] { paramIntent.getMessage() });
        paramIntent = localObject;
      }
    }
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
        ad.e("MicroMsg.IntentUtil", "getBooleanExtra exception:%s", new Object[] { paramIntent.getMessage() });
      }
    }
    AppMethodBeat.o(157568);
    return paramBoolean;
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
        ad.e("MicroMsg.IntentUtil", "getIntExtra exception:%s", new Object[] { paramIntent.getMessage() });
      }
    }
    AppMethodBeat.o(157564);
    return paramInt;
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
        ad.e("MicroMsg.IntentUtil", "getStringExtra exception:%s", new Object[] { paramIntent.getMessage() });
        paramIntent = localObject;
      }
    }
  }
  
  public static int k(Bundle paramBundle, String paramString)
  {
    int i = 0;
    AppMethodBeat.i(157565);
    if (paramBundle == null)
    {
      AppMethodBeat.o(157565);
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
        ad.e("MicroMsg.IntentUtil", "getIntExtra exception:%s", new Object[] { paramBundle.getMessage() });
      }
    }
    AppMethodBeat.o(157565);
    return i;
  }
  
  public static boolean l(Bundle paramBundle, String paramString)
  {
    boolean bool1 = false;
    AppMethodBeat.i(182935);
    if (paramBundle == null)
    {
      AppMethodBeat.o(182935);
      return false;
    }
    try
    {
      boolean bool2 = paramBundle.getBoolean(paramString, false);
      bool1 = bool2;
    }
    catch (Exception paramBundle)
    {
      for (;;)
      {
        ad.e("MicroMsg.IntentUtil", "getBooleanExtra exception:%s", new Object[] { paramBundle.getMessage() });
      }
    }
    AppMethodBeat.o(182935);
    return bool1;
  }
  
  public static String m(Bundle paramBundle, String paramString)
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
        ad.e("MicroMsg.IntentUtil", "getStringExtra exception:%s", new Object[] { paramBundle.getMessage() });
        paramBundle = localObject;
      }
    }
  }
  
  public static long p(Intent paramIntent, String paramString)
  {
    long l1 = 0L;
    AppMethodBeat.i(157566);
    if (paramIntent == null)
    {
      AppMethodBeat.o(157566);
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
        ad.e("MicroMsg.IntentUtil", "getIntExtra exception:%s", new Object[] { paramIntent.getMessage() });
      }
    }
    AppMethodBeat.o(157566);
    return l1;
  }
  
  public static byte[] q(Intent paramIntent, String paramString)
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
        ad.e("MicroMsg.IntentUtil", "getByteArrayExtra exception:%s", new Object[] { paramIntent.getMessage() });
        paramIntent = localObject;
      }
    }
  }
  
  public static Parcelable r(Intent paramIntent, String paramString)
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
        ad.e("MicroMsg.IntentUtil", "getParcelableExtra exception:%s", new Object[] { paramIntent.getMessage() });
        paramIntent = localObject;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.sdk.platformtools.y
 * JD-Core Version:    0.7.0.1
 */