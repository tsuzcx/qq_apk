package com.tencent.mm.plugin.traceroute.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import java.util.List;

final class a$h
  implements Runnable
{
  private String ip;
  private int tne;
  
  public a$h(a parama, String paramString, int paramInt)
  {
    this.ip = paramString;
    this.tne = paramInt;
  }
  
  public final void run()
  {
    int j = 1;
    AppMethodBeat.i(25976);
    ab.i("MicroMsg.MMTraceRoute", "ttl= " + this.tne);
    a locala = this.tmW;
    String str1 = this.ip;
    int m = this.tne;
    Object localObject = b.J(new String[] { "ping", "-c 1", "-t " + String.valueOf(m), str1 });
    if (((List)localObject).size() != 2) {
      locala.a(str1, String.format("%d : can not get roupter ip\n", new Object[] { Integer.valueOf(m) }), Integer.valueOf(m + 1));
    }
    for (;;)
    {
      int i = 0;
      for (;;)
      {
        label141:
        if (i == 0) {
          break label570;
        }
        AppMethodBeat.o(25976);
        return;
        String str2 = (String)((List)localObject).get(0);
        if (str2.length() == 0)
        {
          ab.e("MicroMsg.MMTraceRoute", "runcommand err");
          break;
        }
        int k = str2.indexOf("From ");
        i = k;
        if (k < 0)
        {
          k = str2.indexOf("from ");
          i = k;
          if (k < 0) {
            localObject = null;
          }
        }
        for (;;)
        {
          if (!bo.isNullOrNil((String)localObject)) {
            break label363;
          }
          i = j;
          if (b.aev(str2) > 0) {
            break label141;
          }
          localObject = String.format("%d : can not get roupter ip\n", new Object[] { Integer.valueOf(m) });
          ab.e("MicroMsg.MMTraceRoute", "can not get route ip and ttl".concat(String.valueOf(str1)));
          locala.a(str1, (String)localObject, Integer.valueOf(m + 1));
          break;
          k = str2.indexOf(" ", i);
          if (k < 0)
          {
            k = str2.indexOf(":", i);
            i = k;
            if (k < 0) {
              localObject = null;
            }
          }
          else
          {
            i = k;
          }
          i += 1;
          k = str2.indexOf(" ", i);
          if (k < 0) {
            localObject = null;
          } else {
            localObject = str2.substring(i, k).replace(":", "");
          }
        }
        label363:
        if (str1.equals(localObject))
        {
          locala.a(str1, String.format("%d : FIN %s\n\n", new Object[] { Integer.valueOf(m), localObject }), Integer.valueOf(m + 1));
          i = j;
        }
        else
        {
          if (b.aev(str2) <= 0) {
            break label498;
          }
          locala.a(str1, String.format("%d : FIN %s\n\n ", new Object[] { Integer.valueOf(m), localObject }), Integer.valueOf(m + 1));
          i = j;
          if (a.tmM != null)
          {
            a.tmM.execute(new a.g(locala, (String)localObject, str1, true, Integer.valueOf(m + 1)));
            i = j;
          }
        }
      }
      label498:
      locala.a(str1, String.format("%d : %s", new Object[] { Integer.valueOf(m), localObject }), Integer.valueOf(m + 1));
      if (a.tmM != null) {
        a.tmM.execute(new a.g(locala, (String)localObject, str1, false, Integer.valueOf(m + 1)));
      }
    }
    label570:
    AppMethodBeat.o(25976);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.traceroute.b.a.h
 * JD-Core Version:    0.7.0.1
 */