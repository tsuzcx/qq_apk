package com.tencent.mm.storage;

import com.tencent.e.h;
import com.tencent.e.i;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.b;
import com.tencent.mm.al.b.c;
import com.tencent.mm.al.n;
import com.tencent.mm.al.x.a;
import com.tencent.mm.protocal.protobuf.ob;
import com.tencent.mm.protocal.protobuf.oc;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.ax;

final class y$2
  implements x.a
{
  y$2(ob paramob, ax paramax, int paramInt) {}
  
  public final int a(int paramInt1, int paramInt2, final String paramString, b paramb, n paramn)
  {
    AppMethodBeat.i(124658);
    ad.i("MicroMsg.BizTimeLineInfoStorageLogic", "reSortBizMsgIfNeed CGI callback errType=%d, errCode=%d, bitFlag=%d", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Integer.valueOf(this.Ipd.FJk) });
    this.wVq.encode("ReSortBizMsgLastTime", System.currentTimeMillis() / 1000L);
    if ((paramInt1 != 0) || (paramInt2 != 0))
    {
      y.aaL(2);
      y.aZZ();
      AppMethodBeat.o(124658);
      return 0;
    }
    y.aaL(1);
    paramString = (oc)paramb.hNL.hNQ;
    if (paramString == null)
    {
      y.aZZ();
      AppMethodBeat.o(124658);
      return 0;
    }
    if (this.Ipc == y.IoQ) {
      this.wVq.encode("ReSortBizMsgNextForeGroundReqTime", paramString.FJl);
    }
    for (;;)
    {
      this.wVq.encode("ReSortBizMsgMinUnExposedCount", paramString.FJm);
      this.wVq.encode("ReSortBizMsgMinUnReadCount", paramString.FJn);
      this.wVq.encode("ReSortBizMsgLimitTime", paramString.FJo);
      this.wVq.encode("ReSortBizMsgReqCount", paramString.FJp);
      h.LTJ.f(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(124657);
          y.a(paramString);
          y.aZZ();
          AppMethodBeat.o(124657);
        }
      }, "BizTimeLineInfoStorageThread");
      AppMethodBeat.o(124658);
      return 0;
      this.wVq.encode("ReSortBizMsgNextReqTime", paramString.FJl);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.storage.y.2
 * JD-Core Version:    0.7.0.1
 */