package com.tencent.mm.plugin.sns.model;

import com.tencent.mm.ah.p;
import com.tencent.mm.kernel.b;
import com.tencent.mm.kernel.g;
import com.tencent.mm.protocal.c.awe;
import com.tencent.mm.sdk.platformtools.y;

final class aw$5
  implements Runnable
{
  aw$5(aw paramaw, int paramInt1, String paramString, boolean paramBoolean, awe paramawe, int paramInt2) {}
  
  public final void run()
  {
    if (af.bDo())
    {
      y.e("MicroMsg.UploadManager", "is invalid to getSnsInfoStorage");
      return;
    }
    z localz = new z(this.ouk, this.oul, this.oum, this.oun);
    af.bDE().dM(this.ouk, localz.hashCode());
    g.DQ();
    g.DO().dJT.a(localz, 0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.model.aw.5
 * JD-Core Version:    0.7.0.1
 */