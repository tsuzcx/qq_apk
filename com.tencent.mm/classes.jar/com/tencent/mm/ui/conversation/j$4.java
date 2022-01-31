package com.tencent.mm.ui.conversation;

import com.tencent.mm.c.a;
import com.tencent.mm.pluginsdk.f.i;
import com.tencent.mm.protocal.c.bxs;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.ai;
import com.tencent.mm.vfs.e;

final class j$4
  implements Runnable
{
  j$4(j paramj, bxs parambxs) {}
  
  public final void run()
  {
    if ((this.vTo != null) && (this.vTo.lnA.equalsIgnoreCase(i.eU(ae.getContext()))))
    {
      if ((e.bK(this.vTo.tNK)) && (a.cd(this.vTo.tNK))) {
        ai.d(new j.4.1(this));
      }
    }
    else {
      return;
    }
    ai.d(new j.4.2(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.ui.conversation.j.4
 * JD-Core Version:    0.7.0.1
 */