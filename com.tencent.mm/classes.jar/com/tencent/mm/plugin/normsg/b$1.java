package com.tencent.mm.plugin.normsg;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.a;
import com.tencent.mm.kernel.e;
import com.tencent.mm.kernel.g;
import com.tencent.mm.normsg.c.p;
import com.tencent.mm.plugin.normsg.c.d;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.storage.aj;
import java.net.Inet4Address;
import java.net.InetAddress;

final class b$1
  implements Runnable
{
  b$1(b paramb) {}
  
  public final void run()
  {
    AppMethodBeat.i(148938);
    if (!g.ajM())
    {
      AppMethodBeat.o(148938);
      return;
    }
    try
    {
      long l1 = System.currentTimeMillis();
      Object localObject = ak.getContext().getApplicationInfo().sourceDir;
      g.ajP();
      localObject = c.p.ae(a.getUin());
      g.ajP();
      byte[] arrayOfByte = c.p.af(a.getUin());
      long l2 = System.currentTimeMillis();
      String str = String.format("<k25>%s</k25>", new Object[] { d.B((byte[])localObject, 0, localObject.length) });
      localObject = str;
      if (arrayOfByte != null)
      {
        if (arrayOfByte.length != 8) {
          break label336;
        }
        int i = arrayOfByte[0];
        arrayOfByte[0] = arrayOfByte[3];
        arrayOfByte[3] = i;
        i = arrayOfByte[1];
        arrayOfByte[1] = arrayOfByte[2];
        arrayOfByte[2] = i;
        i = arrayOfByte[4];
        arrayOfByte[4] = arrayOfByte[7];
        arrayOfByte[7] = i;
        i = arrayOfByte[5];
        arrayOfByte[5] = arrayOfByte[6];
        arrayOfByte[6] = i;
      }
      for (localObject = str + String.format("<k28>%s</k28><k29>%s</k29>", new Object[] { d.B(arrayOfByte, 0, 4), d.B(arrayOfByte, 4, 8) });; localObject = str + String.format("<k27>%s</k27>", new Object[] { d.B(arrayOfByte, 0, arrayOfByte.length) }))
      {
        try
        {
          str = Inet4Address.getByName("mp.weixin.qq.com").getHostAddress();
          str = (String)localObject + String.format("<k32>%s</k32>", new Object[] { bu.nullAsNil(str) });
          localObject = str;
        }
        catch (Exception localException2)
        {
          for (;;)
          {
            label336:
            ae.e("MicroMsg.NormsgSourceImpl", "exception:%s", new Object[] { bu.o(localException2) });
          }
        }
        ae.i("MicroMsg.NormsgSourceImpl", "checkSoftType2 [time: " + (l2 - l1) + ", value: " + (String)localObject + "]");
        g.ajR().ajA().set(79, localObject);
        AppMethodBeat.o(148938);
        return;
      }
      return;
    }
    catch (Exception localException1)
    {
      ae.printErrStackTrace("MicroMsg.NormsgSourceImpl", localException1, "Failed checkSoftType2.", new Object[0]);
      AppMethodBeat.o(148938);
    }
  }
  
  public final String toString()
  {
    AppMethodBeat.i(148939);
    String str = super.toString() + "|checkSoftTypeExtra";
    AppMethodBeat.o(148939);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.normsg.b.1
 * JD-Core Version:    0.7.0.1
 */