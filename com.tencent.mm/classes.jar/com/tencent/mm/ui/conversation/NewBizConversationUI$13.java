package com.tencent.mm.ui.conversation;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.b;
import com.tencent.mm.al.b.c;
import com.tencent.mm.al.n;
import com.tencent.mm.al.x.a;
import com.tencent.mm.protocal.protobuf.cjp;
import com.tencent.mm.protocal.protobuf.pe;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.ax;
import com.tencent.mm.sdk.platformtools.bt;

final class NewBizConversationUI$13
  implements x.a
{
  NewBizConversationUI$13(NewBizConversationUI paramNewBizConversationUI) {}
  
  public final int a(int paramInt1, int paramInt2, String paramString, b paramb, n paramn)
  {
    AppMethodBeat.i(38676);
    ad.i("MicroMsg.NewBizConversationUI", "doBizStrategy callback %d/%d %s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramString });
    if ((paramInt1 != 0) && (paramInt2 != 0))
    {
      AppMethodBeat.o(38676);
      return 0;
    }
    paramString = (pe)paramb.hNL.hNQ;
    if ((paramString.FKr != null) && (!bt.isNullOrNil(paramString.FKr.Hdt)))
    {
      paramb = ax.aQA("brandService");
      paramInt1 = paramb.decodeInt(NewBizConversationUI.fJu(), 0);
      paramb.encode("PaySubscribeEntryUrl", paramString.FKr.Hdt);
      paramb.encode(NewBizConversationUI.fJu(), paramString.FKr.Hds);
      if (paramInt1 != paramString.FKr.Hds) {
        NewBizConversationUI.a(this.Kxj);
      }
    }
    AppMethodBeat.o(38676);
    return 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.ui.conversation.NewBizConversationUI.13
 * JD-Core Version:    0.7.0.1
 */