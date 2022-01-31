package com.tencent.mm.ui.chatting.b;

import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.ui.chatting.ChattingFooterMoreBtnBar;
import com.tencent.mm.ui.chatting.b.b.g;
import com.tencent.mm.ui.chatting.c.a;
import com.tencent.mm.ui.chatting.v;
import com.tencent.mm.ui.tools.n.b;

final class j$8
  implements n.b
{
  String kEv = null;
  
  j$8(j paramj) {}
  
  public final void Wl()
  {
    com.tencent.mm.sdk.platformtools.y.v("MicroMsg.ChattingMoreBtnBarHelper", "onQuitSearch");
    g localg = (g)this.vpr.byx.ac(g.class);
    if (localg.isInEditMode())
    {
      ((com.tencent.mm.ui.chatting.b.b.y)this.vpr.byx.ac(com.tencent.mm.ui.chatting.b.b.y.class)).cFg();
      j.b(this.vpr).setVisibility(0);
      j.b(this.vpr).GQ(localg.bug());
    }
  }
  
  public final void Wm()
  {
    com.tencent.mm.sdk.platformtools.y.v("MicroMsg.ChattingMoreBtnBarHelper", "onEnterSearch");
    h.nFQ.a(219L, 21L, 1L, true);
    if (((g)this.vpr.byx.ac(g.class)).isInEditMode())
    {
      ((com.tencent.mm.ui.chatting.b.b.y)this.vpr.byx.ac(com.tencent.mm.ui.chatting.b.b.y.class)).cFf();
      j.b(this.vpr).setVisibility(8);
    }
  }
  
  public final void Wn() {}
  
  public final void Wo() {}
  
  public final boolean pB(String paramString)
  {
    return false;
  }
  
  public final void pC(String paramString)
  {
    com.tencent.mm.sdk.platformtools.y.v("MicroMsg.ChattingMoreBtnBarHelper", "on edit change");
    Object localObject = (com.tencent.mm.ui.chatting.b.b.y)this.vpr.byx.ac(com.tencent.mm.ui.chatting.b.b.y.class);
    if (bk.bl(paramString)) {
      if (((com.tencent.mm.ui.chatting.b.b.y)localObject).cFm())
      {
        if (((com.tencent.mm.ui.chatting.b.b.y)localObject).cFi() != null) {
          ((com.tencent.mm.ui.chatting.b.b.y)localObject).cFi().pA("");
        }
        ((com.tencent.mm.ui.chatting.b.b.y)localObject).He(-1);
      }
    }
    for (;;)
    {
      this.kEv = paramString;
      return;
      if (j.h(this.vpr))
      {
        if (this.kEv != null)
        {
          ((com.tencent.mm.ui.chatting.b.b.y)localObject).cFg();
          j.b(this.vpr).setVisibility(0);
          localObject = (g)this.vpr.byx.ac(g.class);
          j.b(this.vpr).GQ(((g)localObject).bug());
        }
      }
      else
      {
        ((com.tencent.mm.ui.chatting.b.b.y)localObject).cFg();
        j.b(this.vpr).setVisibility(8);
        continue;
        com.tencent.mm.sdk.platformtools.y.v("MicroMsg.ChattingMoreBtnBarHelper", "enter search mode");
        j.b(this.vpr).setVisibility(8);
        ((com.tencent.mm.ui.chatting.b.b.y)localObject).cFf();
        if (((com.tencent.mm.ui.chatting.b.b.y)localObject).cFi() != null) {
          ((com.tencent.mm.ui.chatting.b.b.y)localObject).cFi().pA(paramString);
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.b.j.8
 * JD-Core Version:    0.7.0.1
 */