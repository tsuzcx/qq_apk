package com.tencent.wecall.talkroom.model;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.pb.common.c.d;
import java.io.BufferedOutputStream;

public final class k
{
  static BufferedOutputStream mOutputStream = null;
  public static boolean tFf = false;
  
  public static boolean dXX()
  {
    AppMethodBeat.i(128006);
    if (getNetType(d.tFk) == 4)
    {
      AppMethodBeat.o(128006);
      return true;
    }
    AppMethodBeat.o(128006);
    return false;
  }
  
  private static int getNetType(Context paramContext)
  {
    AppMethodBeat.i(128005);
    try
    {
      paramContext = ((ConnectivityManager)paramContext.getSystemService("connectivity")).getActiveNetworkInfo();
      if (paramContext == null)
      {
        AppMethodBeat.o(128005);
        return 0;
      }
      int i = paramContext.getType();
      if (i == 1)
      {
        AppMethodBeat.o(128005);
        return 4;
      }
      i = paramContext.getSubtype();
      if (i == 3)
      {
        AppMethodBeat.o(128005);
        return 3;
      }
      if (paramContext.getSubtype() > 0)
      {
        i = paramContext.getSubtype();
        if (i < 5)
        {
          AppMethodBeat.o(128005);
          return 1;
        }
      }
      if (paramContext.getSubtype() >= 5)
      {
        i = paramContext.getSubtype();
        if (i < 13)
        {
          AppMethodBeat.o(128005);
          return 3;
        }
      }
      i = paramContext.getSubtype();
      if (i >= 13)
      {
        AppMethodBeat.o(128005);
        return 5;
      }
      AppMethodBeat.o(128005);
      return 2;
    }
    catch (Exception paramContext)
    {
      AppMethodBeat.o(128005);
    }
    return 2;
  }
  
  public static int jN(Context paramContext)
  {
    AppMethodBeat.i(128004);
    try
    {
      paramContext = ((ConnectivityManager)paramContext.getSystemService("connectivity")).getActiveNetworkInfo();
      if (paramContext == null)
      {
        AppMethodBeat.o(128004);
        return 0;
      }
      int i = paramContext.getType();
      if (i == 1)
      {
        AppMethodBeat.o(128004);
        return 4;
      }
      i = paramContext.getSubtype();
      if (i == 3)
      {
        AppMethodBeat.o(128004);
        return 3;
      }
      if (paramContext.getSubtype() > 0)
      {
        i = paramContext.getSubtype();
        if (i < 5)
        {
          AppMethodBeat.o(128004);
          return 1;
        }
      }
      if (paramContext.getSubtype() >= 5)
      {
        i = paramContext.getSubtype();
        if (i < 13)
        {
          AppMethodBeat.o(128004);
          return 3;
        }
      }
      i = paramContext.getSubtype();
      if (i >= 13)
      {
        AppMethodBeat.o(128004);
        return 5;
      }
      AppMethodBeat.o(128004);
      return 2;
    }
    catch (Exception paramContext)
    {
      AppMethodBeat.o(128004);
    }
    return 2;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.wecall.talkroom.model.k
 * JD-Core Version:    0.7.0.1
 */