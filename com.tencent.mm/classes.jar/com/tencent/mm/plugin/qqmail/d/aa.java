package com.tencent.mm.plugin.qqmail.d;

import android.util.Base64;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.e;
import com.tencent.mm.kernel.g;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.storage.ai;

public final class aa
{
  public z xco;
  
  public aa()
  {
    AppMethodBeat.i(122760);
    String str = (String)g.ajC().ajl().get(282625, "");
    try
    {
      this.xco = new z();
      this.xco.parseFrom(Base64.decode(str, 0));
      AppMethodBeat.o(122760);
      return;
    }
    catch (Exception localException)
    {
      ad.printErrStackTrace("MicroMsg.ShareMailInfoMgr", localException, "", new Object[0]);
      ad.w("MicroMsg.ShareMailInfoMgr", "parse from config fail");
      this.xco = new z();
      AppMethodBeat.o(122760);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.qqmail.d.aa
 * JD-Core Version:    0.7.0.1
 */