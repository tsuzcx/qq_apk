package com.tencent.mm.ui.chatting.viewitems;

import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.af.a;
import com.tencent.mm.af.a.b;
import com.tencent.mm.kernel.g;
import com.tencent.mm.modelappbrand.k;
import com.tencent.mm.modelappbrand.k.a;
import com.tencent.mm.protocal.protobuf.cmn;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;

final class t$a$2
  implements k.a
{
  t$a$2(t.a parama, t.d paramd, a parama1) {}
  
  public final void a(String paramString, cmn paramcmn)
  {
    AppMethodBeat.i(33046);
    ab.d("MicroMsg.ChattingItemAppMsgWxaDynamicFrom", "ShareKey:%s UpdatableMsgInfo:%s", new Object[] { paramString, paramcmn.content });
    if (this.zUB.zUG == null)
    {
      ab.w("MicroMsg.ChattingItemAppMsgWxaDynamicFrom", "viewHolder.appbrandUpdateTv is null, return");
      AppMethodBeat.o(33046);
      return;
    }
    String str = (String)this.zUB.zUG.getTag();
    if (bo.isNullOrNil(str))
    {
      ab.w("MicroMsg.ChattingItemAppMsgWxaDynamicFrom", "oriShareKey is null, return");
      AppMethodBeat.o(33046);
      return;
    }
    if (str.equals(paramString))
    {
      this.zUB.zUG.setVisibility(0);
      this.zUB.zUG.setText(paramcmn.content);
      this.zUB.zUG.setTextColor(bo.bS(paramcmn.xMC, this.zUB.zUG.getCurrentTextColor()));
      if (paramcmn.state == 1)
      {
        paramString = ((k)g.E(k.class)).qj(paramString);
        if ((paramString != null) && (paramString.field_btnState == 1))
        {
          if (bo.isNullOrNil(this.zUD.ffl))
          {
            this.zUB.zUH.setVisibility(8);
            AppMethodBeat.o(33046);
            return;
          }
          this.zUB.zUH.setVisibility(0);
          this.zUB.zUH.setText(this.zUD.ffl);
        }
      }
    }
    AppMethodBeat.o(33046);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.viewitems.t.a.2
 * JD-Core Version:    0.7.0.1
 */