package com.tencent.mm.ui.chatting.viewitems;

import android.view.View;
import android.widget.LinearLayout;
import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.g;
import com.tencent.mm.ak.n;
import com.tencent.mm.ak.q;
import com.tencent.mm.g.a.wx;
import com.tencent.mm.g.c.dy;
import com.tencent.mm.model.az;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.ui.base.t;
import com.tencent.mm.ui.chatting.BaseChattingUIFragment;

final class ah$13
  implements g
{
  ah$13(ah paramah, com.tencent.mm.storage.bo parambo, bo parambo1, boolean paramBoolean, String paramString) {}
  
  public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, n paramn)
  {
    boolean bool = true;
    AppMethodBeat.i(169889);
    az.agi().b(1176, this);
    ac.d("MicroMsg.ChattingItemDyeingTemplate", "onSceneEnd(errType : %d, errCode : %d, errMsg : %s, toBan : %s)", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramString, Boolean.TRUE });
    if (this.hmq != this.InM.IrQ.getTag(2131302745))
    {
      ac.w("MicroMsg.ChattingItemDyeingTemplate", "item msg(%s) has changed.", new Object[] { Long.valueOf(this.hmq.field_msgId) });
      AppMethodBeat.o(169889);
      return;
    }
    if ((paramInt1 != 0) || (paramInt2 != 0))
    {
      paramString = this.InM.Irn;
      if (this.InN)
      {
        paramInt1 = 8;
        paramString.setVisibility(paramInt1);
        t.makeText(ah.b(this.Inu).HZF.getContext(), 2131761756, 0).show();
        paramString = new wx();
        paramString.dzL.cYF = this.CIt;
        paramn = paramString.dzL;
        if (!this.InN) {
          break label242;
        }
      }
      label242:
      for (paramInt1 = 2;; paramInt1 = 1)
      {
        paramn.action = paramInt1;
        paramString.dzL.option = 1;
        com.tencent.mm.sdk.b.a.GpY.l(paramString);
        if (ah.b(this.Inu) != null) {
          ah.b(this.Inu).bJU();
        }
        AppMethodBeat.o(169889);
        return;
        paramInt1 = 0;
        break;
      }
    }
    if (ah.j(this.Inu) != null)
    {
      paramString = ah.j(this.Inu);
      paramn = this.CIt;
      if (this.InN) {
        break label292;
      }
    }
    for (;;)
    {
      paramString.Z(paramn, bool);
      AppMethodBeat.o(169889);
      return;
      label292:
      bool = false;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.viewitems.ah.13
 * JD-Core Version:    0.7.0.1
 */