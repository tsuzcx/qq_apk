package com.tencent.mm.plugin.traceroute.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.g.a.e;
import com.tencent.mm.sdk.g.d;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeoutException;

public final class b
{
  public static List<Object> J(String[] paramArrayOfString)
  {
    AppMethodBeat.i(25988);
    String str = " ";
    int i = 0;
    while (i < 4)
    {
      localObject = paramArrayOfString[i];
      str = str + (String)localObject + " ";
      i += 1;
    }
    ab.i("MicroMsg.MMTraceRoute", str);
    Object localObject = new ArrayList();
    paramArrayOfString = new b.a(paramArrayOfString, (List)localObject);
    d.g(paramArrayOfString, "MMTraceRouteCMDExecutor_watcher");
    try
    {
      d.ysm.al(paramArrayOfString);
      ab.i("MicroMsg.MMTraceRoute", "watcher thread stopped".concat(String.valueOf(str)));
      label104:
      AppMethodBeat.o(25988);
      return localObject;
    }
    catch (TimeoutException paramArrayOfString)
    {
      break label104;
    }
    catch (ExecutionException paramArrayOfString)
    {
      break label104;
    }
    catch (InterruptedException paramArrayOfString)
    {
      break label104;
    }
  }
  
  public static String aeu(String paramString)
  {
    AppMethodBeat.i(25986);
    ab.i("MicroMsg.MMTraceRoute", "output string: ".concat(String.valueOf(paramString)));
    if ((paramString == null) || (paramString.length() == 0))
    {
      AppMethodBeat.o(25986);
      return null;
    }
    int i = paramString.indexOf("time=");
    if (i < 0)
    {
      AppMethodBeat.o(25986);
      return null;
    }
    i += 5;
    int j = paramString.indexOf(" ", i);
    if (j < 0)
    {
      AppMethodBeat.o(25986);
      return null;
    }
    paramString = paramString.substring(i, j);
    AppMethodBeat.o(25986);
    return paramString;
  }
  
  public static int aev(String paramString)
  {
    AppMethodBeat.i(25987);
    int i = paramString.indexOf("ttl=");
    if (i < 0)
    {
      AppMethodBeat.o(25987);
      return -1;
    }
    i += 4;
    int j = paramString.indexOf(" ", i);
    if (j < 0)
    {
      AppMethodBeat.o(25987);
      return -1;
    }
    i = bo.getInt(paramString.substring(i, j), 0);
    AppMethodBeat.o(25987);
    return i;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.traceroute.b.b
 * JD-Core Version:    0.7.0.1
 */