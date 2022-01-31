package com.tencent.mm.plugin.webview.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.b;
import com.tencent.mm.ai.b.c;
import com.tencent.mm.ipcinvoker.wx_extension.b.a;
import com.tencent.mm.protocal.protobuf.sx;
import com.tencent.mm.sdk.platformtools.ab;
import java.util.concurrent.CountDownLatch;

final class h$1
  implements b.a
{
  h$1(h paramh, int[] paramArrayOfInt, CountDownLatch paramCountDownLatch) {}
  
  public final void a(int paramInt1, int paramInt2, String paramString, b paramb)
  {
    AppMethodBeat.i(153130);
    ab.i("MicroMsg.NetSceneCheckTextLanguage", "onSceneEnd errType = %d, errCode = %d ,errMsg = %s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramString });
    this.tbI[0] = 2;
    if ((paramInt1 != 0) || (paramInt2 != 0))
    {
      this.val$countDownWait.countDown();
      AppMethodBeat.o(153130);
      return;
    }
    paramString = (sx)paramb.fsW.fta;
    if (paramString.wLr == 1) {
      this.tbI[0] = 0;
    }
    for (;;)
    {
      this.val$countDownWait.countDown();
      AppMethodBeat.o(153130);
      return;
      if (paramString.wLr == 2) {
        this.tbI[0] = 1;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.model.h.1
 * JD-Core Version:    0.7.0.1
 */