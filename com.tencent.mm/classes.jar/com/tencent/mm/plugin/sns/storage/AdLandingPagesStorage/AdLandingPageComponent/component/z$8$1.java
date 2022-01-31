package com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component;

import android.view.View;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.c.a;
import com.tencent.mm.plugin.sns.ui.OfflineVideoView;
import com.tencent.mm.pluginsdk.ui.tools.VideoPlayerSeekBar;
import com.tencent.mm.sdk.platformtools.y;

final class z$8$1
  implements c.a
{
  z$8$1(z.8 param8) {}
  
  public final void Oq(String paramString)
  {
    y.v("MicroMsg.Sns.AdLandingPageStreamVideoComponentOnlinePlayer", "video view height " + this.oIa.oHY.contentView.getHeight() + ", player height " + this.oIa.oHY.oHK.getHeight());
    this.oIa.oHY.oHe = false;
    this.oIa.oHY.goK = paramString;
    if (this.oIa.oHY.oGR.bNU)
    {
      this.oIa.oHY.oHK.Df(paramString);
      this.oIa.oHY.oHS = true;
    }
  }
  
  public final void cu(String paramString, int paramInt) {}
  
  public final void uv(String paramString)
  {
    y.e("MicroMsg.Sns.AdLandingPageStreamVideoComponentOnlinePlayer", "video download fail %s", new Object[] { paramString });
    this.oIa.oHY.oHe = true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.z.8.1
 * JD-Core Version:    0.7.0.1
 */