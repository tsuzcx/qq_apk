package com.tencent.mm.ui.chatting.a;

import com.tencent.mm.modelvideo.t.a;
import com.tencent.mm.modelvideo.t.a.a;
import com.tencent.mm.sdk.platformtools.ai;
import com.tencent.mm.ui.chatting.viewitems.ak.d;

final class a$4
  implements t.a
{
  a$4(a parama) {}
  
  public final void a(t.a.a parama)
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (parama != null)
    {
      bool1 = bool2;
      if (parama.eHO != 3) {
        if ((parama.eHO != 2) && (parama.eHO != -1))
        {
          bool1 = bool2;
          if (parama.eHO != 1) {}
        }
        else
        {
          bool1 = ak.d.b(parama);
        }
      }
    }
    if (!bool1) {
      ai.d(new a.4.1(this));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.a.a.4
 * JD-Core Version:    0.7.0.1
 */