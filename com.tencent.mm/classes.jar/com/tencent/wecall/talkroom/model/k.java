package com.tencent.wecall.talkroom.model;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import com.tencent.pb.common.c.d;
import java.io.BufferedOutputStream;

public final class k
{
  static BufferedOutputStream mOutputStream = null;
  public static boolean pZF = false;
  
  public static boolean cSa()
  {
    return getNetType(d.pZI) == 4;
  }
  
  private static int getNetType(Context paramContext)
  {
    try
    {
      paramContext = ((ConnectivityManager)paramContext.getSystemService("connectivity")).getActiveNetworkInfo();
      if (paramContext == null) {
        return 0;
      }
      if (paramContext.getType() == 1) {
        return 4;
      }
      if (paramContext.getSubtype() == 3) {
        return 3;
      }
      if ((paramContext.getSubtype() > 0) && (paramContext.getSubtype() < 5)) {
        return 1;
      }
      if ((paramContext.getSubtype() >= 5) && (paramContext.getSubtype() < 13)) {
        return 3;
      }
      int i = paramContext.getSubtype();
      if (i >= 13) {
        return 5;
      }
      return 2;
    }
    catch (Exception paramContext) {}
    return 2;
  }
  
  public static int ij(Context paramContext)
  {
    try
    {
      paramContext = ((ConnectivityManager)paramContext.getSystemService("connectivity")).getActiveNetworkInfo();
      if (paramContext == null) {
        return 0;
      }
      if (paramContext.getType() == 1) {
        return 4;
      }
      if (paramContext.getSubtype() == 3) {
        return 3;
      }
      if ((paramContext.getSubtype() > 0) && (paramContext.getSubtype() < 5)) {
        return 1;
      }
      if ((paramContext.getSubtype() >= 5) && (paramContext.getSubtype() < 13)) {
        return 3;
      }
      int i = paramContext.getSubtype();
      if (i >= 13) {
        return 5;
      }
      return 2;
    }
    catch (Exception paramContext) {}
    return 2;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.wecall.talkroom.model.k
 * JD-Core Version:    0.7.0.1
 */