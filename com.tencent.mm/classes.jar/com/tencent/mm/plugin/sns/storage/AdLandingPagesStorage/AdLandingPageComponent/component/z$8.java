package com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component;

import android.view.View;
import android.widget.ImageView;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.w;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.h;
import com.tencent.mm.plugin.sns.ui.OfflineVideoView;
import com.tencent.mm.plugin.sns.ui.OfflineVideoView.a;
import com.tencent.mm.pluginsdk.ui.tools.VideoPlayerSeekBar;
import com.tencent.mm.pointers.PString;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.ai;
import com.tencent.mm.vfs.e;

final class z$8
  implements OfflineVideoView.a
{
  z$8(z paramz) {}
  
  public final boolean a(PString paramPString)
  {
    String str1 = z.a(this.oHY).oCZ;
    String str2 = h.eT("adId", str1);
    if (e.bK(str2))
    {
      paramPString.value = str2;
      this.oHY.oHS = true;
      return true;
    }
    h.a("adId", str1, false, 62, new z.8.1(this));
    return false;
  }
  
  public final void onStart(int paramInt)
  {
    boolean bool = false;
    this.oHY.dDs = true;
    this.oHY.oHM = paramInt;
    if (this.oHY.oGR.getVideoTotalTime() != paramInt) {
      this.oHY.oGR.setVideoTotalTime(this.oHY.oHM);
    }
    this.oHY.oGR.setVisibility(0);
    this.oHY.oGS.setVisibility(0);
    if (this.oHY.oHm != null)
    {
      localObject = this.oHY.oHm;
      if (this.oHY.oGR.getVisibility() == 0) {
        bool = true;
      }
      ((ac)localObject).jp(bool);
    }
    Object localObject = this.oHY;
    if ((((z)localObject).oHK != null) && (((z)localObject).oGR != null) && (Math.abs(((z)localObject).oHK.getCurrentPosition() - ((z)localObject).oGR.getmPosition()) > 1)) {
      ((z)localObject).oHK.X(((z)localObject).oGR.getmPosition(), true);
    }
  }
  
  public final void ug()
  {
    boolean bool = false;
    Object localObject = this.oHY;
    ((z)localObject).oHj += 1;
    this.oHY.oGR.setVisibility(0);
    this.oHY.oGS.setVisibility(0);
    this.oHY.hoY.setVisibility(0);
    if (this.oHY.oHm != null)
    {
      localObject = this.oHY.oHm;
      if (this.oHY.oGR.getVisibility() == 0) {
        bool = true;
      }
      ((ac)localObject).jp(bool);
    }
    this.oHY.dPi.post(new z.8.2(this));
    if (this.oHY.mxx != 0L)
    {
      this.oHY.oHi = ((int)(this.oHY.oHi + (System.currentTimeMillis() - this.oHY.mxx)));
      this.oHY.mxx = 0L;
    }
    this.oHY.oHh = 5;
  }
  
  public final void yg(int paramInt)
  {
    ai.d(new z.8.3(this, paramInt));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.z.8
 * JD-Core Version:    0.7.0.1
 */