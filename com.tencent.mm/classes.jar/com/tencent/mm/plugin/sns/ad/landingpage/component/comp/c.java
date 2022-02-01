package com.tencent.mm.plugin.sns.ad.landingpage.component.comp;

import android.content.Context;
import android.view.ViewGroup;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.sns.ad.landingpage.component.info.d;
import com.tencent.mm.plugin.sns.model.AdLandingPagesProxy;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.ai;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.b.h.a;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.r;
import com.tencent.mm.sdk.platformtools.Log;

public final class c
  extends r
{
  private final d PPQ;
  
  public c(Context paramContext, d paramd, ViewGroup paramViewGroup)
  {
    super(paramContext, paramd, paramViewGroup);
    AppMethodBeat.i(310702);
    this.PPQ = paramd;
    this.QPl.mx("finderExportId", this.PPQ.PMe);
    this.QPl.mx("finderUsername", this.PPQ.finderUsername);
    AppMethodBeat.o(310702);
  }
  
  public final void hac()
  {
    AppMethodBeat.i(310708);
    try
    {
      String str1 = hjn().uxInfo;
      String str2 = hjn().getSnsId();
      int i = hjn().source;
      Log.i("AdLandingFinderFeedsBtnComp", "doBtnClick, uxInfo = " + str1 + ", snsId = " + str2 + ", source = " + i);
      AdLandingPagesProxy.getInstance().doJumpToFinderFeedsDetailUI(this.PPQ.finderUsername, this.PPQ.PMd, this.PPQ.PMe, str1, str2, i, 5);
      AppMethodBeat.o(310708);
      return;
    }
    finally
    {
      Log.e("AdLandingFinderFeedsBtnComp", "doBtnClick, exp=" + localObject.toString());
      AppMethodBeat.o(310708);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ad.landingpage.component.comp.c
 * JD-Core Version:    0.7.0.1
 */