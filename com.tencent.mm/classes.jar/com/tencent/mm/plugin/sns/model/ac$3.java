package com.tencent.mm.plugin.sns.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.sns.storage.r;
import com.tencent.mm.plugin.sns.storage.s;
import com.tencent.mm.protocal.protobuf.bby;
import com.tencent.mm.protocal.protobuf.bcv;
import com.tencent.mm.sdk.platformtools.ab;

final class ac$3
  implements Runnable
{
  ac$3(ac paramac, bby parambby) {}
  
  public final void run()
  {
    AppMethodBeat.i(36373);
    this.rfY.xrb += 1;
    try
    {
      ab.i("MicroMsg.SightCdnUpload", "add try count %d", new Object[] { Integer.valueOf(this.rfY.xrb) });
      bcv localbcv = (bcv)new bcv().parseFrom(this.rfZ.rfU.rDG);
      localbcv.xsQ = this.rfY;
      this.rfZ.rfU.rDG = localbcv.toByteArray();
      ag.coU().a(this.rfZ.rfU.rCV, this.rfZ.rfU);
      AppMethodBeat.o(36373);
      return;
    }
    catch (Exception localException)
    {
      ab.e("MicroMsg.SightCdnUpload", "parseFrom MediaUploadInfo error in checkUploadaddCount %s", new Object[] { localException.getMessage() });
      AppMethodBeat.o(36373);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.model.ac.3
 * JD-Core Version:    0.7.0.1
 */