package com.tencent.mm.plugin.zero;

import com.tencent.mm.kernel.e.c;
import com.tencent.mm.kernel.g;
import com.tencent.mm.sdk.platformtools.y;
import java.io.File;

public final class a
  implements com.tencent.mm.kernel.api.bucket.c, com.tencent.mm.plugin.zero.b.a
{
  private com.tencent.mm.m.e rRV = new com.tencent.mm.m.e();
  private com.tencent.mm.m.c rRW = new com.tencent.mm.m.c();
  
  public final com.tencent.mm.m.e AA()
  {
    g.DQ();
    g.DN().CX();
    return this.rRV;
  }
  
  public final com.tencent.mm.m.c AB()
  {
    g.DQ();
    g.DN().CX();
    return this.rRW;
  }
  
  public final void onAccountInitialized(e.c paramc)
  {
    if (paramc.dKL)
    {
      paramc = this.rRW;
      File localFile1 = new File(com.tencent.mm.compatible.util.e.bkH + "configlist/");
      if (localFile1.exists())
      {
        File localFile2 = new File(com.tencent.mm.m.c.dAj);
        if (!localFile2.exists())
        {
          y.d("MicroMsg.ConfigListDecoder", "bugfix");
          paramc.d(localFile1, localFile2);
        }
      }
    }
    this.rRV.mT();
    this.rRW.init();
  }
  
  public final void onAccountRelease() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.zero.a
 * JD-Core Version:    0.7.0.1
 */