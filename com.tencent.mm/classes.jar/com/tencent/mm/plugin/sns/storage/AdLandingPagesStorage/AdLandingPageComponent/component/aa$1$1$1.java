package com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component;

import android.text.Html;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.f.a;
import com.tencent.mm.sdk.platformtools.ai;
import com.tencent.mm.sdk.platformtools.y;

final class aa$1$1$1
  implements f.a
{
  aa$1$1$1(aa.1.1 param1) {}
  
  public final void Op(String paramString)
  {
    try
    {
      ai.d(new aa.1.1.1.2(this, Html.fromHtml(this.oIe.oId.oIb, new aa.1.1.1.1(this), null)));
      return;
    }
    catch (Exception paramString)
    {
      y.e("MicroMsg.Sns.AdLandingPageTextComponent", "the backgroundCoverUrl is set error ,because " + paramString.toString());
    }
  }
  
  public final void bCF() {}
  
  public final void bFl() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.aa.1.1.1
 * JD-Core Version:    0.7.0.1
 */