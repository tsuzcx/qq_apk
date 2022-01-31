package com.tencent.mm.plugin.webview.modeltools;

import android.os.Bundle;
import com.tencent.mm.ah.b;
import com.tencent.mm.ah.b.c;
import com.tencent.mm.ipcinvoker.wx_extension.b.a;
import com.tencent.mm.protocal.c.bsk;
import com.tencent.mm.sdk.platformtools.y;
import java.util.concurrent.CountDownLatch;

final class f$1
  implements b.a
{
  f$1(CountDownLatch paramCountDownLatch, Bundle paramBundle) {}
  
  public final void a(int paramInt1, int paramInt2, String paramString, b paramb)
  {
    y.i("MicroMsg.SmartPickWordHelper", "onSceneEnd errType = %d, errCode = %d ,errMsg = %s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramString });
    if ((paramInt1 != 0) || (paramInt2 != 0))
    {
      this.rie.countDown();
      return;
    }
    paramString = (bsk)paramb.ecF.ecN;
    this.rif.putString("PickedWord", paramString.tIU);
    this.rif.putInt("PrefixOffset", paramString.tIX);
    this.rif.putInt("SuffixOffset", paramString.tIY);
    this.rif.putString("PrefixText", paramString.tIV);
    this.rif.putString("SuffixText", paramString.tIW);
    f.KB(paramString.tIU);
    y.i("MicroMsg.SmartPickWordHelper", "response: PrefixText: %s, PickedWord: %s, SuffixText: %s, %d, %d", new Object[] { paramString.tIV, paramString.tIU, paramString.tIW, Integer.valueOf(paramString.tIX), Integer.valueOf(paramString.tIY) });
    this.rie.countDown();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.modeltools.f.1
 * JD-Core Version:    0.7.0.1
 */