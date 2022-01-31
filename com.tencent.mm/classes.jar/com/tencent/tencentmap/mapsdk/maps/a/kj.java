package com.tencent.tencentmap.mapsdk.maps.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.tencentmap.mapsdk.a.dp;
import com.tencent.tencentmap.mapsdk.a.dq;
import navsns.RttResponse;

public class kj
  extends jd
{
  private static kj a;
  
  public static kj a()
  {
    try
    {
      AppMethodBeat.i(148954);
      if (a == null) {
        a = new kj();
      }
      kj localkj = a;
      AppMethodBeat.o(148954);
      return localkj;
    }
    finally {}
  }
  
  private RttResponse a(String paramString, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(148956);
    int i = 0;
    label95:
    for (;;)
    {
      if (i < 3) {}
      try
      {
        Object localObject = dp.a().a(paramString, "sosomap navsns", paramArrayOfByte);
        if ((localObject == null) || (((dq)localObject).a == null)) {
          break label95;
        }
        e locale = new e();
        locale.a("UTF-8");
        locale.a(((dq)localObject).a);
        localObject = (RttResponse)locale.b("res");
        AppMethodBeat.o(148956);
        return localObject;
      }
      catch (Exception localException)
      {
        i += 1;
      }
      AppMethodBeat.o(148956);
      return null;
    }
  }
  
  private byte[] a(RttResponse paramRttResponse)
  {
    if (paramRttResponse == null) {
      return null;
    }
    return paramRttResponse.result;
  }
  
  public byte[] a(byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(148955);
    if (paramArrayOfByte != null) {}
    try
    {
      int i = paramArrayOfByte.length;
      if (i == 0)
      {
        AppMethodBeat.o(148955);
        return null;
      }
      paramArrayOfByte = a(a(b(), paramArrayOfByte));
      AppMethodBeat.o(148955);
      return paramArrayOfByte;
    }
    catch (Throwable paramArrayOfByte)
    {
      AppMethodBeat.o(148955);
    }
    return null;
  }
  
  public String b()
  {
    return "https://tafrtt.map.qq.com/rttserverex/";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.tencentmap.mapsdk.maps.a.kj
 * JD-Core Version:    0.7.0.1
 */