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

final class t$b$2
  implements k.a
{
  t$b$2(t.b paramb, t.d paramd, a parama) {}
  
  public final void a(String paramString, cmn paramcmn)
  {
    AppMethodBeat.i(33054);
    ab.d("MicroMsg.ChattingItemAppMsgWxaDynamicTo", "ShareKey:%s UpdatableMsgInfo:%s", new Object[] { paramString, paramcmn.content });
    if (this.zUB.zUG == null)
    {
      ab.w("MicroMsg.ChattingItemAppMsgWxaDynamicTo", "viewHolder.appbrandUpdateTv is null, return");
      AppMethodBeat.o(33054);
      return;
    }
    String str = (String)this.zUB.zUG.getTag();
    if (bo.isNullOrNil(str))
    {
      ab.w("MicroMsg.ChattingItemAppMsgWxaDynamicTo", "oriShareKey is null, return");
      AppMethodBeat.o(33054);
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
            AppMethodBeat.o(33054);
            return;
          }
          this.zUB.zUH.setVisibility(0);
          this.zUB.zUH.setText(this.zUD.ffl);
        }
      }
    }
    AppMethodBeat.o(33054);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.viewitems.t.b.2
 * JD-Core Version:    0.7.0.1
 */