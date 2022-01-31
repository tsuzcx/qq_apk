package com.tencent.mm.ui.chatting.viewitems;

import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ay.a;
import com.tencent.mm.ay.a.b;
import com.tencent.mm.pluginsdk.ui.d.n;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.storage.bi;

final class ah$1
  extends n
{
  ah$1(ah paramah, int paramInt1, int paramInt2, a parama, a.b paramb, aj.b paramb1, bi parambi, int paramInt3, int paramInt4)
  {
    super(paramInt1, paramInt2);
  }
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(33268);
    ab.i("MicroMsg.ChattingItemNewXmlSysImpl", "[onClick] pBaseNewXmlMsg:%s", new Object[] { this.zHh });
    this.zWw.a(this.zWx.ngZ, this.fkH, this.zHh, this.jYp);
    AppMethodBeat.o(33268);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.viewitems.ah.1
 * JD-Core Version:    0.7.0.1
 */