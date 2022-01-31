package com.tencent.mm.ui.chatting.b;

import android.os.Bundle;
import com.tencent.mm.h.c.cs;
import com.tencent.mm.ui.chatting.ah;
import com.tencent.mm.ui.chatting.c.a;

final class r$2
  implements Runnable
{
  r$2(r paramr) {}
  
  public final void run()
  {
    Bundle localBundle = new Bundle();
    localBundle.putLong("MSG_ID", r.a(this.vqB).field_msgId);
    this.vqB.byx.vtB.an(localBundle);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.b.r.2
 * JD-Core Version:    0.7.0.1
 */