package com.tencent.mm.storage;

import com.tencent.e.h;
import com.tencent.e.i;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.b;
import com.tencent.mm.al.b.c;
import com.tencent.mm.al.n;
import com.tencent.mm.al.x.a;
import com.tencent.mm.protocal.protobuf.my;
import com.tencent.mm.protocal.protobuf.mz;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.ax;

final class u$2
  implements x.a
{
  u$2(my parammy, ax paramax, int paramInt) {}
  
  public final int a(int paramInt1, int paramInt2, final String paramString, b paramb, n paramn)
  {
    AppMethodBeat.i(124658);
    ad.i("MicroMsg.BizTimeLineInfoStorageLogic", "reSortBizMsgIfNeed CGI callback errType=%d, errCode=%d, bitFlag=%d", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Integer.valueOf(this.Ffd.CKC) });
    this.uFq.encode("ReSortBizMsgLastTime", System.currentTimeMillis() / 1000L);
    if ((paramInt1 != 0) || (paramInt2 != 0))
    {
      u.Ws(2);
      u.aPL();
      AppMethodBeat.o(124658);
      return 0;
    }
    u.Ws(1);
    paramString = (mz)paramb.gUT.gUX;
    if (paramString == null)
    {
      u.aPL();
      AppMethodBeat.o(124658);
      return 0;
    }
    if (this.Ffc == u.FeQ) {
      this.uFq.encode("ReSortBizMsgNextForeGroundReqTime", paramString.CKD);
    }
    for (;;)
    {
      this.uFq.encode("ReSortBizMsgMinUnExposedCount", paramString.CKE);
      this.uFq.encode("ReSortBizMsgMinUnReadCount", paramString.CKF);
      this.uFq.encode("ReSortBizMsgLimitTime", paramString.CKG);
      this.uFq.encode("ReSortBizMsgReqCount", paramString.CKH);
      h.Iye.f(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(124657);
          u.a(paramString);
          u.aPL();
          AppMethodBeat.o(124657);
        }
      }, "BizTimeLineInfoStorageThread");
      AppMethodBeat.o(124658);
      return 0;
      this.uFq.encode("ReSortBizMsgNextReqTime", paramString.CKD);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.storage.u.2
 * JD-Core Version:    0.7.0.1
 */