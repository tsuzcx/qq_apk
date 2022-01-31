package com.tencent.mm.ui.chatting.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.ui.chatting.ChattingFooterMoreBtnBar;
import com.tencent.mm.ui.chatting.c.b.z;
import com.tencent.mm.ui.chatting.d.a;
import com.tencent.mm.ui.chatting.u;
import com.tencent.mm.ui.tools.q.b;

final class j$8
  implements q.b
{
  String naT = null;
  
  j$8(j paramj) {}
  
  public final void apN()
  {
    AppMethodBeat.i(31333);
    ab.v("MicroMsg.ChattingMoreBtnBarHelper", "onQuitSearch");
    com.tencent.mm.ui.chatting.c.b.h localh = (com.tencent.mm.ui.chatting.c.b.h)this.zET.caz.ay(com.tencent.mm.ui.chatting.c.b.h.class);
    if (localh.isInEditMode())
    {
      ((z)this.zET.caz.ay(z.class)).dIY();
      j.b(this.zET).setVisibility(0);
      j.b(this.zET).Pr(localh.ces());
    }
    AppMethodBeat.o(31333);
  }
  
  public final void apO()
  {
    AppMethodBeat.i(31334);
    ab.v("MicroMsg.ChattingMoreBtnBarHelper", "onEnterSearch");
    com.tencent.mm.plugin.report.service.h.qsU.idkeyStat(219L, 21L, 1L, true);
    if (((com.tencent.mm.ui.chatting.c.b.h)this.zET.caz.ay(com.tencent.mm.ui.chatting.c.b.h.class)).isInEditMode())
    {
      ((z)this.zET.caz.ay(z.class)).dIX();
      j.b(this.zET).setVisibility(8);
    }
    AppMethodBeat.o(31334);
  }
  
  public final void apP() {}
  
  public final void apQ() {}
  
  public final boolean wR(String paramString)
  {
    return false;
  }
  
  public final void wS(String paramString)
  {
    AppMethodBeat.i(31332);
    ab.v("MicroMsg.ChattingMoreBtnBarHelper", "on edit change");
    Object localObject = (z)this.zET.caz.ay(z.class);
    if (bo.isNullOrNil(paramString)) {
      if (((z)localObject).dJf())
      {
        if (((z)localObject).dJa() != null) {
          ((z)localObject).dJa().wQ("");
        }
        ((z)localObject).PI(-1);
      }
    }
    for (;;)
    {
      this.naT = paramString;
      AppMethodBeat.o(31332);
      return;
      if (j.g(this.zET))
      {
        if (this.naT != null)
        {
          ((z)localObject).dIY();
          j.b(this.zET).setVisibility(0);
          localObject = (com.tencent.mm.ui.chatting.c.b.h)this.zET.caz.ay(com.tencent.mm.ui.chatting.c.b.h.class);
          j.b(this.zET).Pr(((com.tencent.mm.ui.chatting.c.b.h)localObject).ces());
        }
      }
      else
      {
        ((z)localObject).dIY();
        j.b(this.zET).setVisibility(8);
        continue;
        ab.v("MicroMsg.ChattingMoreBtnBarHelper", "enter search mode");
        j.b(this.zET).setVisibility(8);
        ((z)localObject).dIX();
        if (((z)localObject).dJa() != null) {
          ((z)localObject).dJa().wQ(paramString);
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.c.j.8
 * JD-Core Version:    0.7.0.1
 */