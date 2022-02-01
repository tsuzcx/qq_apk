package com.tencent.mm.plugin.qqmail.d;

import android.util.Base64;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.e;
import com.tencent.mm.kernel.g;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.storage.ao;

public final class aa
{
  public z Bsj;
  
  public aa()
  {
    AppMethodBeat.i(122760);
    String str = (String)g.aAh().azQ().get(282625, "");
    try
    {
      this.Bsj = new z();
      this.Bsj.parseFrom(Base64.decode(str, 0));
      AppMethodBeat.o(122760);
      return;
    }
    catch (Exception localException)
    {
      Log.printErrStackTrace("MicroMsg.ShareMailInfoMgr", localException, "", new Object[0]);
      Log.w("MicroMsg.ShareMailInfoMgr", "parse from config fail");
      this.Bsj = new z();
      AppMethodBeat.o(122760);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.qqmail.d.aa
 * JD-Core Version:    0.7.0.1
 */