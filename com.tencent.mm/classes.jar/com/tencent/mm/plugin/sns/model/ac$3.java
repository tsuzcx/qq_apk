package com.tencent.mm.plugin.sns.model;

import com.tencent.mm.plugin.sns.storage.r;
import com.tencent.mm.plugin.sns.storage.s;
import com.tencent.mm.protocal.c.avn;
import com.tencent.mm.protocal.c.awg;
import com.tencent.mm.sdk.platformtools.y;

final class ac$3
  implements Runnable
{
  ac$3(ac paramac, avn paramavn) {}
  
  public final void run()
  {
    this.orm.trb += 1;
    try
    {
      y.i("MicroMsg.SightCdnUpload", "add try count %d", new Object[] { Integer.valueOf(this.orm.trb) });
      awg localawg = (awg)new awg().aH(this.orn.ori.oLV);
      localawg.tsP = this.orm;
      this.orn.ori.oLV = localawg.toByteArray();
      af.bDu().a(this.orn.ori.oLk, this.orn.ori);
      return;
    }
    catch (Exception localException)
    {
      y.e("MicroMsg.SightCdnUpload", "parseFrom MediaUploadInfo error in checkUploadaddCount %s", new Object[] { localException.getMessage() });
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.model.ac.3
 * JD-Core Version:    0.7.0.1
 */