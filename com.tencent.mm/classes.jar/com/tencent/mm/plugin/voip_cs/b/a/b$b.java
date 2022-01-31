package com.tencent.mm.plugin.voip_cs.b.a;

import android.os.Message;
import com.tencent.mm.sdk.f.e;
import com.tencent.mm.sdk.platformtools.ah;

final class b$b
  implements Runnable
{
  b$b(b paramb) {}
  
  public final void run()
  {
    this.qeI.qeH = b.Qg(this.qeI.qeG);
    Message localMessage = new Message();
    localMessage.what = 12;
    b.t(this.qeI).sendMessage(localMessage);
    e.remove(this.qeI.qeF);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.voip_cs.b.a.b.b
 * JD-Core Version:    0.7.0.1
 */