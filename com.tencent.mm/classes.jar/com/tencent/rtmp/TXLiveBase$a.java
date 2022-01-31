package com.tencent.rtmp;

import com.tencent.liteav.basic.log.TXCLog.a;
import com.tencent.matrix.trace.core.AppMethodBeat;

class TXLiveBase$a
  implements TXCLog.a
{
  public void a(int paramInt, String paramString1, String paramString2)
  {
    AppMethodBeat.i(65931);
    if (TXLiveBase.access$100() != null) {
      TXLiveBase.access$100().OnLog(paramInt, paramString1, paramString2);
    }
    AppMethodBeat.o(65931);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.rtmp.TXLiveBase.a
 * JD-Core Version:    0.7.0.1
 */