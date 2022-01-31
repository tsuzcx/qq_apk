package com.tencent.mm.ui.chatting.viewitems;

import android.view.View;
import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.f;
import com.tencent.mm.ai.m;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.aw;
import com.tencent.mm.modelappbrand.s;
import com.tencent.mm.plugin.appbrand.service.i;
import com.tencent.mm.protocal.protobuf.dbr;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.ui.base.t;

final class x$1$2$1
  implements f
{
  x$1$2$1(x.1.2 param2) {}
  
  public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, m paramm)
  {
    AppMethodBeat.i(33124);
    aw.Rc().b(1198, this);
    ab.d("MicroMsg.ChattingItemDyeingTemplate", "onSceneEnd(errType : %d, errCode : %d, errMsg : %s, toBan : %s)", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramString, Boolean.FALSE });
    if (x.a(this.zVn.zVl.zVk) != null)
    {
      x.a(this.zVn.zVl.zVk).dismiss();
      x.a(this.zVn.zVl.zVk, null);
    }
    if ((paramInt1 != 0) || (paramInt2 != 0))
    {
      t.makeText(this.zVn.bTJ.getContext(), 2131301979, 0).show();
      AppMethodBeat.o(33124);
      return;
    }
    paramString = ((s)paramm).acw();
    if (paramString == null)
    {
      t.makeText(this.zVn.bTJ.getContext(), 2131301979, 0).show();
      AppMethodBeat.o(33124);
      return;
    }
    paramString = paramString.yhW;
    ab.i("MicroMsg.ChattingItemDyeingTemplate", "more view clicked, menu item COMPLAIN_APP_BRAND selected, sync attr username %s", new Object[] { this.zVn.vqy });
    ((i)g.E(i.class)).a(this.zVn.vqy, new x.1.2.1.1(this, paramString));
    AppMethodBeat.o(33124);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.viewitems.x.1.2.1
 * JD-Core Version:    0.7.0.1
 */