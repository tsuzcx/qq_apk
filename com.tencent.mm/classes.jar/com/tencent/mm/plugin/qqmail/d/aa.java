package com.tencent.mm.plugin.qqmail.d;

import android.util.Base64;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.f;
import com.tencent.mm.kernel.h;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.storage.ao;

public final class aa
{
  public z HmC;
  
  public aa()
  {
    AppMethodBeat.i(122760);
    String str = (String)h.aHG().aHp().b(282625, "");
    try
    {
      this.HmC = new z();
      this.HmC.parseFrom(Base64.decode(str, 0));
      AppMethodBeat.o(122760);
      return;
    }
    catch (Exception localException)
    {
      Log.printErrStackTrace("MicroMsg.ShareMailInfoMgr", localException, "", new Object[0]);
      Log.w("MicroMsg.ShareMailInfoMgr", "parse from config fail");
      this.HmC = new z();
      AppMethodBeat.o(122760);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.qqmail.d.aa
 * JD-Core Version:    0.7.0.1
 */