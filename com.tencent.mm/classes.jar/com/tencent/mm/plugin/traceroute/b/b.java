package com.tencent.mm.plugin.traceroute.b;

import com.tencent.mm.sdk.f.e;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import java.util.ArrayList;
import java.util.List;

public final class b
{
  public static List<Object> B(String[] paramArrayOfString)
  {
    String str = " ";
    int i = 0;
    while (i < 4)
    {
      localObject = paramArrayOfString[i];
      str = str + (String)localObject + " ";
      i += 1;
    }
    y.i("MicroMsg.MMTraceRoute", str);
    Object localObject = new ArrayList();
    paramArrayOfString = new b.a(paramArrayOfString, (List)localObject);
    e.a(paramArrayOfString, "MMTraceRouteCMDExecutor_watcher");
    try
    {
      e.ac(paramArrayOfString);
      y.i("MicroMsg.MMTraceRoute", "watcher thread stopped" + str);
      return localObject;
    }
    catch (InterruptedException localInterruptedException)
    {
      e.Y(paramArrayOfString);
      y.i("MicroMsg.MMTraceRoute", "interrupt thread" + str);
    }
    return localObject;
  }
  
  public static String PR(String paramString)
  {
    y.i("MicroMsg.MMTraceRoute", "output string: " + paramString);
    if ((paramString == null) || (paramString.length() == 0)) {}
    int i;
    int j;
    do
    {
      do
      {
        return null;
        i = paramString.indexOf("time=");
      } while (i < 0);
      i += 5;
      j = paramString.indexOf(" ", i);
    } while (j < 0);
    return paramString.substring(i, j);
  }
  
  public static int PS(String paramString)
  {
    int i = paramString.indexOf("ttl=");
    if (i < 0) {}
    int j;
    do
    {
      return -1;
      i += 4;
      j = paramString.indexOf(" ", i);
    } while (j < 0);
    return bk.getInt(paramString.substring(i, j), 0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.traceroute.b.b
 * JD-Core Version:    0.7.0.1
 */