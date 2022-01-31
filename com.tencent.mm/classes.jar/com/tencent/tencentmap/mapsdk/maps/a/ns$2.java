package com.tencent.tencentmap.mapsdk.maps.a;

import com.tencent.map.lib.d;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.tencentmap.mapsdk.a.dp;
import com.tencent.tencentmap.mapsdk.a.dq;
import java.io.UnsupportedEncodingException;
import java.util.HashMap;

class ns$2
  implements Runnable
{
  ns$2(ns paramns, String paramString) {}
  
  public void run()
  {
    AppMethodBeat.i(149564);
    d.a("statistic data:" + this.a);
    try
    {
      Object localObject = this.a.getBytes("UTF-8");
      try
      {
        HashMap localHashMap = new HashMap();
        localHashMap.put("Content-Type", "application/json");
        localObject = dp.a().a(ns.b(this.b), "QQ Map Mobile", (byte[])localObject, 1, localHashMap, null);
        if (localObject == null) {
          break label154;
        }
        d.b("Post statistic data with response:" + new String(((dq)localObject).a, ((dq)localObject).b));
        i = 1;
      }
      catch (Exception localException)
      {
        for (;;)
        {
          byte[] arrayOfByte;
          d.b(localException.getMessage());
          int i = 0;
        }
      }
      if (i == 0) {
        ns.a(this.b, this.a);
      }
      AppMethodBeat.o(149564);
      return;
    }
    catch (UnsupportedEncodingException localUnsupportedEncodingException)
    {
      for (;;)
      {
        arrayOfByte = this.a.getBytes();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.tencentmap.mapsdk.maps.a.ns.2
 * JD-Core Version:    0.7.0.1
 */