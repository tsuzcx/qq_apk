package com.tencent.mm.plugin.sns.model;

import com.tencent.mm.h.a.qs;
import com.tencent.mm.kernel.e;
import com.tencent.mm.plugin.sns.g.i;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.storage.ac.a;
import com.tencent.mm.storage.z;
import java.io.IOException;
import java.nio.charset.Charset;

final class af$28
  extends c<qs>
{
  af$28(af paramaf)
  {
    this.udX = qs.class.getName().hashCode();
  }
  
  private static boolean bDU()
  {
    com.tencent.mm.plugin.sns.lucky.a.g.bCu();
    ac.a locala = ac.a.urH;
    i locali = new i();
    try
    {
      com.tencent.mm.kernel.g.DQ();
      com.tencent.mm.kernel.g.DP().Dz().c(locala, new String(locali.toByteArray(), Charset.forName("ISO-8859-1")));
      return false;
    }
    catch (IOException localIOException)
    {
      for (;;)
      {
        y.w("MicroMsg.RedDotUtil", "mardRedotList save exception:" + localIOException.getLocalizedMessage());
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.model.af.28
 * JD-Core Version:    0.7.0.1
 */