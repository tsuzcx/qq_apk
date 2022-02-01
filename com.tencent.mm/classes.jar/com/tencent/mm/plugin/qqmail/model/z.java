package com.tencent.mm.plugin.qqmail.model;

import android.util.Base64;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.f;
import com.tencent.mm.kernel.h;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.storage.aq;

public final class z
{
  public y Nkq;
  
  public z()
  {
    AppMethodBeat.i(122760);
    String str = (String)h.baE().ban().d(282625, "");
    try
    {
      this.Nkq = new y();
      this.Nkq.parseFrom(Base64.decode(str, 0));
      AppMethodBeat.o(122760);
      return;
    }
    catch (Exception localException)
    {
      Log.printErrStackTrace("MicroMsg.ShareMailInfoMgr", localException, "", new Object[0]);
      Log.w("MicroMsg.ShareMailInfoMgr", "parse from config fail");
      this.Nkq = new y();
      AppMethodBeat.o(122760);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.qqmail.model.z
 * JD-Core Version:    0.7.0.1
 */