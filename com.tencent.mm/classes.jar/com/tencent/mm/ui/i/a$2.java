package com.tencent.mm.ui.i;

import android.os.Message;
import com.tencent.mm.sdk.platformtools.ah;
import org.c.e.b;

final class a$2
  implements Runnable
{
  a$2(a parama) {}
  
  public final void run()
  {
    try
    {
      this.win.wii = this.win.wig.cVd();
      Object localObject1 = this.win.wig.b(this.win.wii);
      localObject1 = this.win.oNg.obtainMessage(1000, localObject1);
      this.win.oNg.sendMessage((Message)localObject1);
      return;
    }
    catch (org.c.b.a locala)
    {
      for (;;)
      {
        Object localObject2 = null;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.ui.i.a.2
 * JD-Core Version:    0.7.0.1
 */