package com.tencent.mm.plugin.traceroute.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import java.util.List;

final class a$i
  implements Runnable
{
  private String ip;
  
  public a$i(a parama, String paramString)
  {
    this.ip = paramString;
  }
  
  public final void run()
  {
    int k = 1;
    AppMethodBeat.i(25977);
    Object localObject2 = b.J(new String[] { "ping", "-c 1", "-t 64", this.ip });
    if (((List)localObject2).size() != 2)
    {
      this.tmW.a(this.ip, "failed to ping: \n" + this.ip, Integer.valueOf(0));
      AppMethodBeat.o(25977);
      return;
    }
    Object localObject1 = (String)((List)localObject2).get(0);
    if (bo.isNullOrNil((String)localObject1))
    {
      this.tmW.a(this.ip, "failed to ping: \n" + this.ip, Integer.valueOf(0));
      ab.e("MicroMsg.MMTraceRoute", "runcommand err");
      AppMethodBeat.o(25977);
      return;
    }
    int i = b.aev((String)localObject1);
    if (i <= 0)
    {
      ab.e("MicroMsg.MMTraceRoute", "failed to touch server:" + this.ip);
      this.tmW.a(this.ip, "failed to touch server: " + this.ip + "\n", Integer.valueOf(0));
      AppMethodBeat.o(25977);
      return;
    }
    localObject2 = ((List)localObject2).get(1).toString();
    localObject1 = b.aeu((String)localObject1);
    if (!bo.isNullOrNil((String)localObject1)) {
      localObject1 = String.format("server: %s, TTL: %d, Time = %sms", new Object[] { this.ip, Integer.valueOf(i), localObject1 });
    }
    for (;;)
    {
      this.tmW.a(this.ip, (String)localObject1 + "\n", Integer.valueOf(0));
      int m = 64 - i + 5;
      i = m;
      int j = k;
      if (m < 0)
      {
        i = 64;
        j = k;
      }
      while ((j < i) && (!this.tmW.cKF()))
      {
        localObject1 = new a.h(this.tmW, this.ip, j);
        if (a.tmM != null) {
          a.tmM.execute((Runnable)localObject1);
        }
        j += 1;
      }
      if (!bo.isNullOrNil((String)localObject2)) {
        localObject1 = String.format("server: %s, TTL: %d, Time = %sms", new Object[] { this.ip, Integer.valueOf(i), localObject2 });
      } else {
        localObject1 = String.format("server: %s, TTL: %d, Time = %sms", new Object[] { this.ip, Integer.valueOf(i), "unknown" });
      }
    }
    AppMethodBeat.o(25977);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.traceroute.b.a.i
 * JD-Core Version:    0.7.0.1
 */