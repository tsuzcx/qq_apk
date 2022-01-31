package com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component;

import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.sns.model.AdLandingPagesProxy;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.ac;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.x;
import com.tencent.mm.plugin.webview.ui.tools.widget.d;

final class g$1
  implements d
{
  g$1(g paramg) {}
  
  public final boolean e(int paramInt, Bundle paramBundle)
  {
    AppMethodBeat.i(37061);
    switch (paramInt)
    {
    }
    for (;;)
    {
      AppMethodBeat.o(37061);
      return false;
      ac localac = (ac)this.rvd.crb();
      paramInt = paramBundle.getInt("sns_landing_pages_ad_vote_index");
      AdLandingPagesProxy.getInstance().saveAdVoteInfo(localac.url, this.rvd.crc().cFe, this.rvd.crc().uin, paramInt, 0);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.g.1
 * JD-Core Version:    0.7.0.1
 */