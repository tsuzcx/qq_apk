package com.tencent.mm.plugin.sns.ad.landingpage.component.comp;

import android.content.Context;
import android.view.ViewGroup;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.sns.ad.landingpage.component.info.c;
import com.tencent.mm.plugin.sns.model.AdLandingPagesProxy;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.ai;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.b.h.a;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.r;
import com.tencent.mm.sdk.platformtools.Log;

public final class e
  extends r
{
  private final c PQc;
  
  public e(Context paramContext, c paramc, ViewGroup paramViewGroup)
  {
    super(paramContext, paramc, paramViewGroup);
    AppMethodBeat.i(310709);
    this.PQc = paramc;
    this.QPl.mx("finderUsername", this.PQc.finderUsername);
    AppMethodBeat.o(310709);
  }
  
  public final void hac()
  {
    AppMethodBeat.i(310721);
    try
    {
      String str1 = hjn().uxInfo;
      String str2 = hjn().getSnsId();
      Log.i("AdLandingFinderProfileBtnComp", "doBtnClick, uxInfo=" + str1 + ", snsId=" + str2);
      AdLandingPagesProxy.getInstance().doJumpToFinderProfileUI(this.PQc.finderUsername, str1, str2, 5);
      AppMethodBeat.o(310721);
      return;
    }
    finally
    {
      Log.e("AdLandingFinderProfileBtnComp", "doBtnClick, exp=" + localObject.toString());
      AppMethodBeat.o(310721);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ad.landingpage.component.comp.e
 * JD-Core Version:    0.7.0.1
 */