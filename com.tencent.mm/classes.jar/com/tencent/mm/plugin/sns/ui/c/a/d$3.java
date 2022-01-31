package com.tencent.mm.plugin.sns.ui.c.a;

import android.view.animation.AlphaAnimation;
import android.widget.ImageView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.widget.SphereImageView.GLTextureView;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.widget.SphereImageView.GLTextureView.i;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.widget.SphereImageView.SphereImageView;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.widget.SphereImageView.SphereImageView.b;
import com.tencent.mm.plugin.sns.storage.b.e;
import com.tencent.mm.plugin.sns.storage.n;
import com.tencent.mm.protocal.protobuf.TimeLineObject;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.al;
import com.tencent.mm.ui.widget.MMPinProgressBtn;
import java.net.URLEncoder;
import org.json.JSONObject;

final class d$3
  implements SphereImageView.b
{
  d$3(d paramd) {}
  
  public final void abk(final String paramString)
  {
    AppMethodBeat.i(145722);
    if (this.sgt.rxK.getVisibility() == 0)
    {
      AlphaAnimation localAlphaAnimation = new AlphaAnimation(1.0F, 0.0F);
      localAlphaAnimation.setDuration(350L);
      localAlphaAnimation.setAnimationListener(new d.3.1(this));
      ab.i("MicroMsg.SphereImageView.SphereCardAdDetailItem", "do maskImage anim");
      this.sgt.rxK.startAnimation(localAlphaAnimation);
    }
    if ((this.sgt.sgq != null) && (!com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.widget.SphereImageView.a.gw(this.sgt.sgq.rrf, "scene_timeline")))
    {
      ab.i("MicroMsg.SphereImageView.SphereCardAdDetailItem", "disable touch before shot");
      this.sgt.rxI.setTouchEnabled(false);
      this.sgt.rxI.crT();
      this.sgt.rxI.rzX.requestRender();
      al.p(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(145721);
          String str;
          if (d.3.this.sgt.sgq != null)
          {
            str = d.3.this.sgt.sgq.rrf;
            if ((paramString == null) || (!paramString.equals(str))) {
              break label120;
            }
            ab.i("MicroMsg.SphereImageView.SphereCardAdDetailItem", "do shot");
            com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.widget.SphereImageView.a.a(d.3.this.sgt.rxI, str, "scene_timeline");
          }
          for (;;)
          {
            ab.i("MicroMsg.SphereImageView.SphereCardAdDetailItem", "enable touch and sensor after shot");
            d.3.this.sgt.rxI.setSensorEnabled(true);
            d.3.this.sgt.rxI.setTouchEnabled(true);
            AppMethodBeat.o(145721);
            return;
            str = "";
            break;
            label120:
            ab.e("MicroMsg.SphereImageView.SphereCardAdDetailItem", "before do shot, url != CardInfo.sphereImageUrl, url=" + paramString + ", info.url=" + str);
          }
        }
      }, 800L);
    }
    for (;;)
    {
      if (this.sgt.sgp.getVisibility() == 0)
      {
        this.sgt.sgp.setVisibility(8);
        ab.i("MicroMsg.SphereImageView.SphereCardAdDetailItem", "hide progressView");
      }
      AppMethodBeat.o(145722);
      return;
      this.sgt.rxI.setSensorEnabled(true);
      this.sgt.rxI.setTouchEnabled(true);
    }
  }
  
  public final void crv() {}
  
  public final void crw() {}
  
  public final void crx()
  {
    d locald = this.sgt;
    locald.rxM += 1;
  }
  
  public final void onDetachedFromWindow()
  {
    AppMethodBeat.i(145723);
    ab.i("MicroMsg.SphereImageView.SphereCardAdDetailItem", "onDetachedFromWindow, hash=" + this.sgt.rxI.hashCode());
    try
    {
      Object localObject = new JSONObject();
      ((JSONObject)localObject).put("panCount", this.sgt.rxM);
      ((JSONObject)localObject).put("type", 1);
      String str2 = URLEncoder.encode(((JSONObject)localObject).toString(), "UTF-8");
      String str1 = this.sgt.rMD.csM();
      localObject = str1;
      if (str1 == null) {
        localObject = "";
      }
      h.qsU.e(17539, new Object[] { this.sgt.rMD.csh().Id, localObject, this.sgt.rMD.csd().cFe, Integer.valueOf(2), str2 });
      ab.i("MicroMsg.SphereImageView.SphereCardAdDetailItem", "KVReport, id=17539, touchCount=".concat(String.valueOf(str2)));
    }
    catch (Exception localException)
    {
      for (;;)
      {
        ab.e("MicroMsg.SphereImageView.SphereCardAdDetailItem", "kvStat exp:" + localException.toString());
      }
    }
    this.sgt.rxM = 0;
    this.sgt.sgr = null;
    AppMethodBeat.o(145723);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.c.a.d.3
 * JD-Core Version:    0.7.0.1
 */