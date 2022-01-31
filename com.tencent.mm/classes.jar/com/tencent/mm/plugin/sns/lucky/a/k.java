package com.tencent.mm.plugin.sns.lucky.a;

import com.tencent.mm.kernel.e;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.sns.g.i;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.storage.ac.a;
import com.tencent.mm.storage.z;
import java.nio.charset.Charset;

public final class k
{
  public static i h(ac.a parama)
  {
    localObject = new i();
    g.DQ();
    parama = (String)g.DP().Dz().get(parama, null);
    if (parama == null)
    {
      y.i("MicroMsg.RedDotUtil", "load: redDotList data empty");
      return localObject;
    }
    for (;;)
    {
      try
      {
        i locali = (i)new i().aH(parama.getBytes(Charset.forName("ISO-8859-1")));
        parama = locali;
        if (locali != null) {}
      }
      catch (Exception localException)
      {
        try
        {
          parama = new i();
          localObject = parama;
          if (parama != null) {
            break;
          }
          return new i();
        }
        catch (Exception parama)
        {
          for (;;)
          {
            localObject = localException;
            ac.a locala = parama;
            parama = (ac.a)localObject;
          }
        }
        localException = localException;
        parama = (ac.a)localObject;
      }
      y.e("MicroMsg.RedDotUtil", "getRedDotList " + localException.getMessage());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.lucky.a.k
 * JD-Core Version:    0.7.0.1
 */