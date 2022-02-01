package com.tencent.mm.ui.conversation;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.b;
import com.tencent.mm.ak.b.c;
import com.tencent.mm.ak.n;
import com.tencent.mm.ak.x.a;
import com.tencent.mm.protocal.protobuf.ckj;
import com.tencent.mm.protocal.protobuf.pg;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.ay;
import com.tencent.mm.sdk.platformtools.bu;

final class NewBizConversationUI$13
  implements x.a
{
  NewBizConversationUI$13(NewBizConversationUI paramNewBizConversationUI) {}
  
  public final int a(int paramInt1, int paramInt2, String paramString, b paramb, n paramn)
  {
    AppMethodBeat.i(38676);
    ae.i("MicroMsg.NewBizConversationUI", "doBizStrategy callback %d/%d %s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramString });
    if ((paramInt1 != 0) && (paramInt2 != 0))
    {
      AppMethodBeat.o(38676);
      return 0;
    }
    paramString = (pg)paramb.hQE.hQJ;
    if ((paramString.GcQ != null) && (!bu.isNullOrNil(paramString.GcQ.HwT)))
    {
      paramb = ay.aRX("brandService");
      paramInt1 = paramb.decodeInt(NewBizConversationUI.fNL(), 0);
      paramb.encode("PaySubscribeEntryUrl", paramString.GcQ.HwT);
      paramb.encode(NewBizConversationUI.fNL(), paramString.GcQ.HwS);
      if (paramInt1 != paramString.GcQ.HwS) {
        NewBizConversationUI.a(this.KTD);
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