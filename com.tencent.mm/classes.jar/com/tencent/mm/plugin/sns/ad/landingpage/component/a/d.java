package com.tencent.mm.plugin.sns.ad.landingpage.component.a;

import android.content.Context;
import android.view.ViewGroup;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.sns.ad.landingpage.component.b.c;
import com.tencent.mm.plugin.sns.model.AdLandingPagesProxy;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.a.g.a;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.ai;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.q;
import com.tencent.mm.sdk.platformtools.Log;

public final class d
  extends q
{
  private final c JAu;
  
  public d(Context paramContext, c paramc, ViewGroup paramViewGroup)
  {
    super(paramContext, paramc, paramViewGroup);
    AppMethodBeat.i(226923);
    this.JAu = paramc;
    this.KqQ.kQ("finderUsername", this.JAu.finderUsername);
    AppMethodBeat.o(226923);
  }
  
  public final void fKd()
  {
    AppMethodBeat.i(226931);
    try
    {
      String str1 = fRp().uxInfo;
      String str2 = fRp().getSnsId();
      Log.i("AdLandingFinderProfileBtnComp", "doBtnClick, uxInfo=" + str1 + ", snsId=" + str2);
      AdLandingPagesProxy.getInstance().doJumpToFinderProfileUI(this.JAu.finderUsername, str1, str2, 5);
      AppMethodBeat.o(226931);
      return;
    }
    catch (Throwable localThrowable)
    {
      Log.e("AdLandingFinderProfileBtnComp", "doBtnClick, exp=" + localThrowable.toString());
      AppMethodBeat.o(226931);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ad.landingpage.component.a.d
 * JD-Core Version:    0.7.0.1
 */