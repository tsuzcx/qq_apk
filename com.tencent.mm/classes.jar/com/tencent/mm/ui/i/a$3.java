package com.tencent.mm.ui.i;

import android.os.Message;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.y;
import org.c.d.c;
import org.c.d.g;
import org.c.d.j;
import org.c.e.b;

final class a$3
  implements Runnable
{
  a$3(a parama) {}
  
  public final void run()
  {
    Object localObject = a.c.wiq;
    if (this.win.wih == null) {
      localObject = a.c.wir;
    }
    for (;;)
    {
      localObject = this.win.oNg.obtainMessage(1010, localObject);
      this.win.oNg.sendMessage((Message)localObject);
      return;
      c localc1 = new c(j.xuL, "https://api.twitter.com/1.1/account/verify_credentials.json");
      this.win.wig.a(this.win.wih, localc1);
      try
      {
        if (localc1.cUY().code != 200) {
          localObject = a.c.wir;
        }
      }
      catch (Exception localException)
      {
        y.printErrStackTrace("MicroMsg.Twitter", localException, "request error.", new Object[0]);
        a.c localc = a.c.wir;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.ui.i.a.3
 * JD-Core Version:    0.7.0.1
 */