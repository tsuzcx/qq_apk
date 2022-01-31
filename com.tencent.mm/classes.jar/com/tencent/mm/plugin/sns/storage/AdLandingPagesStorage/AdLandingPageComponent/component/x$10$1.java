package com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component;

import android.view.View;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.f.a;
import com.tencent.mm.plugin.sns.ui.OfflineVideoView;
import com.tencent.mm.pluginsdk.ui.tools.VideoPlayerSeekBar;
import com.tencent.mm.sdk.platformtools.y;

final class x$10$1
  implements f.a
{
  x$10$1(x.10 param10) {}
  
  public final void Op(String paramString)
  {
    y.v("MicroMsg.Sns.AdLandingPageSightVideoComponent", "video view height " + this.oHX.oHV.contentView.getHeight() + ", player height " + x.a(this.oHX.oHV).getHeight());
    x.a(this.oHX.oHV, false);
    x.a(this.oHX.oHV, paramString);
    if (this.oHX.oHV.oGR.bNU)
    {
      x.a(this.oHX.oHV).Df(paramString);
      x.m(this.oHX.oHV);
    }
  }
  
  public final void bCF()
  {
    y.e("MicroMsg.Sns.AdLandingPageSightVideoComponent", "video download fail");
    x.a(this.oHX.oHV, true);
  }
  
  public final void bFl() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.x.10.1
 * JD-Core Version:    0.7.0.1
 */