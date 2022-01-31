package com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component;

import android.text.Html;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.f.a;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.al;

final class ab$1$1$1
  implements f.a
{
  ab$1$1$1(ab.1.1 param1) {}
  
  public final void abi(String paramString)
  {
    AppMethodBeat.i(37335);
    try
    {
      al.d(new ab.1.1.1.2(this, Html.fromHtml(this.rxZ.rxY.rxW, new ab.1.1.1.1(this), null)));
      AppMethodBeat.o(37335);
      return;
    }
    catch (Exception paramString)
    {
      ab.e("MicroMsg.Sns.AdLandingPageTextComponent", "the backgroundCoverUrl is set error ,because " + paramString.toString());
      AppMethodBeat.o(37335);
    }
  }
  
  public final void coe() {}
  
  public final void cqU() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.ab.1.1.1
 * JD-Core Version:    0.7.0.1
 */