package com.tencent.mm.ui.applet;

import android.os.MessageQueue.IdleHandler;
import java.util.LinkedList;

final class b$1
  implements MessageQueue.IdleHandler
{
  b$1(b paramb) {}
  
  public final boolean queueIdle()
  {
    while (this.uSc.uSa.size() > 0)
    {
      String str = (String)this.uSc.uSa.removeFirst();
      this.uSc.uSb.pM(str);
    }
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.ui.applet.b.1
 * JD-Core Version:    0.7.0.1
 */