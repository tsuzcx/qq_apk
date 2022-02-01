package com.tencent.mm.ui.chatting.viewitems;

import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.b;
import com.tencent.mm.al.b.c;
import com.tencent.mm.al.n;
import com.tencent.mm.al.x.a;
import com.tencent.mm.g.a.wa;
import com.tencent.mm.protocal.protobuf.crx;
import com.tencent.mm.protocal.protobuf.dvt;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.ui.base.t;
import com.tencent.mm.ui.chatting.BaseChattingUIFragment;
import java.util.LinkedList;

final class d$8
  implements x.a
{
  d$8(d paramd, LinkedList paramLinkedList) {}
  
  public final int a(int paramInt1, int paramInt2, String paramString, b paramb, n paramn)
  {
    AppMethodBeat.i(191601);
    ad.d("MicroMsg.ChattingItemAppBrandNotifyMsg", "setReceiveOff errType = %d, errCode = %d, errMsg = %s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramString });
    d.f(this.GIp);
    if ((paramInt1 != 0) || (paramInt2 != 0))
    {
      t.makeText(d.b(this.GIp).GzJ.getContext(), 2131761765, 0).show();
      AppMethodBeat.o(191601);
      return 0;
    }
    if ((crx)paramb.gUT.gUX == null) {
      ad.e("MicroMsg.ChattingItemAppBrandNotifyMsg", "setReceiveOff failed, response is null!");
    }
    for (;;)
    {
      AppMethodBeat.o(191601);
      return 0;
      paramInt1 = 0;
      while (paramInt1 < this.fvD.size())
      {
        paramString = (dvt)this.fvD.get(paramInt1);
        if (paramString != null) {
          break label149;
        }
        ad.w("MicroMsg.ChattingItemAppBrandNotifyMsg", "scene end, item is null");
        paramInt1 += 1;
      }
    }
    label149:
    paramb = new wa();
    paramb.dBz.appId = paramString.dlB;
    paramn = paramb.dBz;
    if (paramString.status == 0) {}
    for (boolean bool = true;; bool = false)
    {
      paramn.dbq = bool;
      com.tencent.mm.sdk.b.a.ESL.l(paramb);
      break;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.viewitems.d.8
 * JD-Core Version:    0.7.0.1
 */