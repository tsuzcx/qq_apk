package com.tencent.wecall.talkroom.model;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.pb.common.c.c;
import java.io.BufferedOutputStream;

public final class j
{
  public static boolean ULJ = false;
  static BufferedOutputStream mOutputStream = null;
  
  private static int getNetType(Context paramContext)
  {
    AppMethodBeat.i(62690);
    try
    {
      paramContext = ((ConnectivityManager)paramContext.getSystemService("connectivity")).getActiveNetworkInfo();
      if (paramContext == null)
      {
        AppMethodBeat.o(62690);
        return 0;
      }
      int i = paramContext.getType();
      if (i == 1)
      {
        AppMethodBeat.o(62690);
        return 4;
      }
      i = paramContext.getSubtype();
      if (i == 3)
      {
        AppMethodBeat.o(62690);
        return 3;
      }
      if (paramContext.getSubtype() > 0)
      {
        i = paramContext.getSubtype();
        if (i < 5)
        {
          AppMethodBeat.o(62690);
          return 1;
        }
      }
      if (paramContext.getSubtype() >= 5)
      {
        i = paramContext.getSubtype();
        if (i < 13)
        {
          AppMethodBeat.o(62690);
          return 3;
        }
      }
      i = paramContext.getSubtype();
      if (i >= 13)
      {
        AppMethodBeat.o(62690);
        return 5;
      }
      AppMethodBeat.o(62690);
      return 2;
    }
    catch (Exception paramContext)
    {
      AppMethodBeat.o(62690);
    }
    return 2;
  }
  
  public static boolean keG()
  {
    AppMethodBeat.i(62691);
    if (getNetType(c.UMe) == 4)
    {
      AppMethodBeat.o(62691);
      return true;
    }
    AppMethodBeat.o(62691);
    return false;
  }
  
  public static int oL(Context paramContext)
  {
    AppMethodBeat.i(62689);
    try
    {
      paramContext = ((ConnectivityManager)paramContext.getSystemService("connectivity")).getActiveNetworkInfo();
      if (paramContext == null)
      {
        AppMethodBeat.o(62689);
        return 0;
      }
      int i = paramContext.getType();
      if (i == 1)
      {
        AppMethodBeat.o(62689);
        return 4;
      }
      i = paramContext.getSubtype();
      if (i == 3)
      {
        AppMethodBeat.o(62689);
        return 3;
      }
      if (paramContext.getSubtype() > 0)
      {
        i = paramContext.getSubtype();
        if (i < 5)
        {
          AppMethodBeat.o(62689);
          return 1;
        }
      }
      if (paramContext.getSubtype() >= 5)
      {
        i = paramContext.getSubtype();
        if (i < 13)
        {
          AppMethodBeat.o(62689);
          return 3;
        }
      }
      i = paramContext.getSubtype();
      if (i >= 13)
      {
        AppMethodBeat.o(62689);
        return 5;
      }
      AppMethodBeat.o(62689);
      return 2;
    }
    catch (Exception paramContext)
    {
      AppMethodBeat.o(62689);
    }
    return 2;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.wecall.talkroom.model.j
 * JD-Core Version:    0.7.0.1
 */