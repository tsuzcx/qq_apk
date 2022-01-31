package com.tencent.mm.ui.chatting.viewitems;

import android.view.View;
import android.widget.LinearLayout;
import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.f;
import com.tencent.mm.ai.m;
import com.tencent.mm.ai.p;
import com.tencent.mm.g.a.un;
import com.tencent.mm.g.c.dd;
import com.tencent.mm.model.aw;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.storage.bi;
import com.tencent.mm.ui.base.t;
import com.tencent.mm.ui.chatting.BaseChattingUIFragment;

final class x$2
  implements f
{
  x$2(x paramx, bi parambi, be parambe, boolean paramBoolean, String paramString) {}
  
  public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, m paramm)
  {
    AppMethodBeat.i(33128);
    aw.Rc().b(1176, this);
    ab.d("MicroMsg.ChattingItemDyeingTemplate", "onSceneEnd(errType : %d, errCode : %d, errMsg : %s, toBan : %s)", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramString, Boolean.TRUE });
    if (this.fkH != this.zVq.zZG.getTag(2131822566))
    {
      ab.w("MicroMsg.ChattingItemDyeingTemplate", "item msg(%s) has changed.", new Object[] { Long.valueOf(this.fkH.field_msgId) });
      AppMethodBeat.o(33128);
      return;
    }
    if ((paramInt1 != 0) || (paramInt2 != 0))
    {
      paramString = this.zVq.zZc;
      if (this.zVr)
      {
        paramInt1 = 8;
        paramString.setVisibility(paramInt1);
        t.makeText(x.b(this.zVk).zJz.getContext(), 2131301984, 0).show();
        paramString = new un();
        paramString.cLa.cmx = this.vqy;
        paramm = paramString.cLa;
        if (!this.zVr) {
          break label239;
        }
      }
      label239:
      for (paramInt1 = 2;; paramInt1 = 1)
      {
        paramm.action = paramInt1;
        paramString.cLa.option = 1;
        com.tencent.mm.sdk.b.a.ymk.l(paramString);
        if (x.b(this.zVk) != null) {
          x.b(this.zVk).aWN();
        }
        AppMethodBeat.o(33128);
        return;
        paramInt1 = 0;
        break;
      }
    }
    AppMethodBeat.o(33128);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.viewitems.x.2
 * JD-Core Version:    0.7.0.1
 */