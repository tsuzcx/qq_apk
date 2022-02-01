package com.tencent.mm.storage;

import com.tencent.e.h;
import com.tencent.e.i;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.b;
import com.tencent.mm.ak.b.c;
import com.tencent.mm.ak.n;
import com.tencent.mm.ak.x.a;
import com.tencent.mm.protocal.protobuf.od;
import com.tencent.mm.protocal.protobuf.oe;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.ay;

final class y$2
  implements x.a
{
  y$2(od paramod, ay paramay, int paramInt) {}
  
  public final int a(int paramInt1, int paramInt2, final String paramString, b paramb, n paramn)
  {
    AppMethodBeat.i(124658);
    ae.i("MicroMsg.BizTimeLineInfoStorageLogic", "reSortBizMsgIfNeed CGI callback errType=%d, errCode=%d, bitFlag=%d", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Integer.valueOf(this.IJv.GbJ) });
    this.xlh.encode("ReSortBizMsgLastTime", System.currentTimeMillis() / 1000L);
    if ((paramInt1 != 0) || (paramInt2 != 0))
    {
      y.abt(2);
      y.bay();
      AppMethodBeat.o(124658);
      return 0;
    }
    y.abt(1);
    paramString = (oe)paramb.hQE.hQJ;
    if (paramString == null)
    {
      y.bay();
      AppMethodBeat.o(124658);
      return 0;
    }
    if (this.IJu == y.IJg) {
      this.xlh.encode("ReSortBizMsgNextForeGroundReqTime", paramString.GbK);
    }
    for (;;)
    {
      this.xlh.encode("ReSortBizMsgMinUnExposedCount", paramString.GbL);
      this.xlh.encode("ReSortBizMsgMinUnReadCount", paramString.GbM);
      this.xlh.encode("ReSortBizMsgLimitTime", paramString.GbN);
      this.xlh.encode("ReSortBizMsgReqCount", paramString.GbO);
      h.MqF.f(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(124657);
          y.a(paramString);
          y.bay();
          AppMethodBeat.o(124657);
        }
      }, "BizTimeLineInfoStorageThread");
      AppMethodBeat.o(124658);
      return 0;
      this.xlh.encode("ReSortBizMsgNextReqTime", paramString.GbK);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.storage.y.2
 * JD-Core Version:    0.7.0.1
 */