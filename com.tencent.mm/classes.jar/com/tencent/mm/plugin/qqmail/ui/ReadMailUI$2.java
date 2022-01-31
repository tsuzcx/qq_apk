package com.tencent.mm.plugin.qqmail.ui;

import com.tencent.mm.plugin.qqmail.b.v;
import com.tencent.mm.plugin.qqmail.stub.ReadMailProxy;
import com.tencent.mm.sdk.platformtools.y;
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
    if (this.njK.isFinishing()) {}
    do
    {
      return;
      try
      {
        Map localMap = (Map)new ReadMailProxy(ReadMailUI.l(this.njK), null).REMOTE_CALL("getCookie", new Object[0]);
        localObject = localMap;
      }
      catch (Exception localException)
      {
        for (;;)
        {
          y.w("MicroMsg.ReadMailUI", "getCookie, ex = %s", new Object[] { localException.getMessage() });
        }
      }
      if (localObject != null)
      {
        this.njL.setCookie(v.btz(), "skey=" + (String)localObject.get("skey"));
        this.njL.setCookie(v.btz(), "uin=" + (String)localObject.get("uin"));
        this.njL.setCookie(v.btz(), "svrid=" + (String)localObject.get("svrid"));
        c.cSg();
        c.sync();
      }
    } while ((this.njK.isFinishing()) || (ReadMailUI.g(this.njK) == null));
    this.bxs.run();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.qqmail.ui.ReadMailUI.2
 * JD-Core Version:    0.7.0.1
 */