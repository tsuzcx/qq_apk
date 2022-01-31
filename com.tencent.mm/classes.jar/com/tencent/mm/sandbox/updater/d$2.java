package com.tencent.mm.sandbox.updater;

import android.content.Intent;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.ai;
import com.tencent.mm.sdk.platformtools.aq;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.xweb.x5.sdk.f.a;

final class d$2
  implements f.a
{
  d$2(d paramd) {}
  
  public final void onNeedDownloadFinish(boolean paramBoolean, int paramInt)
  {
    boolean bool1 = aq.isWifi(ae.getContext());
    boolean bool2 = this.ucL.intent.getBooleanExtra("intent_extra_download_ignore_network_type", false);
    y.i("MicroMsg.TBSDownloadMgr", "TBS download onNeedDownloadFinish, tbsCoreVersion = %d, needDownload = %b, isWifi = %b, ignoreNetworkType = %b", new Object[] { Integer.valueOf(paramInt), Boolean.valueOf(paramBoolean), Boolean.valueOf(bool1), Boolean.valueOf(bool2) });
    if (((bool1) || (bool2)) && (paramBoolean))
    {
      d.a(this.ucL);
      return;
    }
    ai.l(new d.2.1(this), 500L);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.sandbox.updater.d.2
 * JD-Core Version:    0.7.0.1
 */