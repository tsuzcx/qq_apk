package com.tencent.mm.plugin.qqmail.ui;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.qqmail.b.v;
import com.tencent.mm.plugin.qqmail.stub.ReadMailProxy;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.xweb.b;
import com.tencent.xweb.c;
import java.util.Map;

final class ReadMailUI$2
  implements Runnable
{
  ReadMailUI$2(ReadMailUI paramReadMailUI, b paramb, Runnable paramRunnable) {}
  
  public final void run()
  {
    Object localObject = null;
    AppMethodBeat.i(68420);
    if (this.pOX.isFinishing())
    {
      AppMethodBeat.o(68420);
      return;
    }
    try
    {
      Map localMap = (Map)new ReadMailProxy(ReadMailUI.l(this.pOX), null).REMOTE_CALL("getCookie", new Object[0]);
      localObject = localMap;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        ab.w("MicroMsg.ReadMailUI", "getCookie, ex = %s", new Object[] { localException.getMessage() });
      }
    }
    if (localObject != null)
    {
      this.pOY.setCookie(v.cdK(), "skey=" + (String)localObject.get("skey"));
      this.pOY.setCookie(v.cdK(), "uin=" + (String)localObject.get("uin"));
      this.pOY.setCookie(v.cdK(), "svrid=" + (String)localObject.get("svrid"));
      c.dYi();
      c.sync();
    }
    if ((!this.pOX.isFinishing()) && (ReadMailUI.g(this.pOX) != null)) {
      this.bZt.run();
    }
    AppMethodBeat.o(68420);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.qqmail.ui.ReadMailUI.2
 * JD-Core Version:    0.7.0.1
 */