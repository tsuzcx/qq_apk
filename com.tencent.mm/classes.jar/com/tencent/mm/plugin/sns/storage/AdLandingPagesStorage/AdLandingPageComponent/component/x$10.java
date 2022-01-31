package com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component;

import android.widget.ImageView;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.q;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.h;
import com.tencent.mm.plugin.sns.ui.OfflineVideoView.a;
import com.tencent.mm.pluginsdk.ui.tools.VideoPlayerSeekBar;
import com.tencent.mm.pointers.PString;
import com.tencent.mm.sdk.platformtools.ai;
import com.tencent.mm.vfs.e;

final class x$10
  implements OfflineVideoView.a
{
  x$10(x paramx) {}
  
  public final boolean a(PString paramPString)
  {
    String str1 = x.l(this.oHV).oCX;
    String str2 = h.eT("adId", str1);
    if (e.bK(str2))
    {
      paramPString.value = str2;
      x.m(this.oHV);
      return true;
    }
    h.d("adId", str1, false, 62, new x.10.1(this));
    return false;
  }
  
  public final void onStart(int paramInt)
  {
    boolean bool = false;
    x.p(this.oHV);
    x.b(this.oHV, paramInt);
    if (this.oHV.oGR.getVideoTotalTime() != paramInt) {
      this.oHV.oGR.setVideoTotalTime(x.q(this.oHV));
    }
    this.oHV.oGR.setVisibility(4);
    this.oHV.oGS.setVisibility(0);
    if (this.oHV.oHm != null)
    {
      ac localac = this.oHV.oHm;
      if (this.oHV.oGR.getVisibility() == 0) {
        bool = true;
      }
      localac.jp(bool);
    }
    this.oHV.bFD();
  }
  
  public final void ug()
  {
    x.n(this.oHV);
    x.o(this.oHV);
  }
  
  public final void yg(int paramInt)
  {
    ai.d(new x.10.2(this, paramInt));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.x.10
 * JD-Core Version:    0.7.0.1
 */