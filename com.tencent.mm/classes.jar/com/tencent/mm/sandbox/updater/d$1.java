package com.tencent.mm.sandbox.updater;

import android.content.Intent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.al;
import com.tencent.mm.sdk.platformtools.at;
import com.tencent.xweb.x5.sdk.f.a;

final class d$1
  implements f.a
{
  d$1(d paramd) {}
  
  public final void onNeedDownloadFinish(boolean paramBoolean, int paramInt)
  {
    AppMethodBeat.i(28880);
    boolean bool1 = at.isWifi(ah.getContext());
    boolean bool2 = this.yla.intent.getBooleanExtra("intent_extra_download_ignore_network_type", false);
    ab.i("MicroMsg.TBSDownloadMgr", "TBS download onNeedDownloadFinish, tbsCoreVersion = %d, needDownload = %b, isWifi = %b, ignoreNetworkType = %b", new Object[] { Integer.valueOf(paramInt), Boolean.valueOf(paramBoolean), Boolean.valueOf(bool1), Boolean.valueOf(bool2) });
    if (((bool1) || (bool2)) && (paramBoolean))
    {
      d.a(this.yla);
      AppMethodBeat.o(28880);
      return;
    }
    al.p(new d.1.1(this), 500L);
    AppMethodBeat.o(28880);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.sandbox.updater.d.1
 * JD-Core Version:    0.7.0.1
 */