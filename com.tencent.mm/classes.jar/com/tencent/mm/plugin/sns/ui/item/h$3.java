package com.tencent.mm.plugin.sns.ui.item;

import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.widget.ImageView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.widget.SphereImageView.GLTextureView;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.widget.SphereImageView.GLTextureView.i;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.widget.SphereImageView.SphereImageView;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.widget.SphereImageView.SphereImageView.b;
import com.tencent.mm.plugin.sns.storage.b.e;
import com.tencent.mm.plugin.sns.storage.n;
import com.tencent.mm.plugin.sns.ui.av;
import com.tencent.mm.protocal.protobuf.TimeLineObject;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.ui.widget.MMPinProgressBtn;
import java.net.URLEncoder;
import org.json.JSONObject;

final class h$3
  implements SphereImageView.b
{
  h$3(h paramh) {}
  
  public final void abk(final String paramString)
  {
    AppMethodBeat.i(145732);
    if (this.siv.sgq != null) {}
    for (Object localObject = this.siv.sgq.rrf; (paramString != null) && (!paramString.equals(localObject)); localObject = "")
    {
      ab.e("MicroMsg.SphereImageView.SphereCardAdTimeLineItem", "onUpdateImage, url != CardInfo.sphereImageUrl, url=" + paramString + ", info.url=" + (String)localObject);
      AppMethodBeat.o(145732);
      return;
    }
    localObject = this.siv.sin;
    if (localObject == null)
    {
      ab.e("MicroMsg.SphereImageView.SphereCardAdTimeLineItem", "onUpdateImage, viewHolder==null");
      AppMethodBeat.o(145732);
      return;
    }
    ab.i("MicroMsg.SphereImageView.SphereCardAdTimeLineItem", "onUpdateImage, isFirstUpdateImage=" + this.siv.sio + ", visiable=" + ((h.a)localObject).siA.getVisibility());
    if (this.siv.sio)
    {
      if (((h.a)localObject).siA.getVisibility() == 0)
      {
        AlphaAnimation localAlphaAnimation = new AlphaAnimation(1.0F, 0.0F);
        localAlphaAnimation.setDuration(350L);
        localAlphaAnimation.setAnimationListener(new Animation.AnimationListener()
        {
          public final void onAnimationEnd(Animation paramAnonymousAnimation)
          {
            AppMethodBeat.i(145729);
            this.siu.siA.setVisibility(8);
            this.siu.siA.setImageResource(2130838904);
            AppMethodBeat.o(145729);
          }
          
          public final void onAnimationRepeat(Animation paramAnonymousAnimation) {}
          
          public final void onAnimationStart(Animation paramAnonymousAnimation) {}
        });
        ab.i("MicroMsg.SphereImageView.SphereCardAdTimeLineItem", "do maskImage anim");
        ((h.a)localObject).siA.startAnimation(localAlphaAnimation);
      }
      if ((this.siv.sgq == null) || (com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.widget.SphereImageView.a.gw(this.siv.sgq.rrf, "scene_timeline"))) {
        break label328;
      }
      ab.i("MicroMsg.SphereImageView.SphereCardAdTimeLineItem", "disable touch before shot");
      ((h.a)localObject).siz.setTouchEnabled(false);
      ((h.a)localObject).siz.crT();
      ((h.a)localObject).siz.rzX.requestRender();
      this.siv.loX.postDelayed(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(145730);
          String str;
          if (h.3.this.siv.sgq != null)
          {
            str = h.3.this.siv.sgq.rrf;
            if ((paramString == null) || (!paramString.equals(str))) {
              break label158;
            }
            ab.i("MicroMsg.SphereImageView.SphereCardAdTimeLineItem", "do shot");
            com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.widget.SphereImageView.a.a(this.siu.siz, str, "scene_timeline");
            h.3.this.siv.sio = false;
          }
          for (;;)
          {
            ab.i("MicroMsg.SphereImageView.SphereCardAdTimeLineItem", "enable touch and sensor after shot, isInLowPriority=" + h.3.this.siv.sis);
            if (!h.3.this.siv.sis) {
              this.siu.siz.setSensorEnabled(true);
            }
            this.siu.siz.setTouchEnabled(true);
            AppMethodBeat.o(145730);
            return;
            str = "";
            break;
            label158:
            ab.e("MicroMsg.SphereImageView.SphereCardAdTimeLineItem", "before do shot, url != CardInfo.sphereImageUrl, url=" + paramString + ", info.url=" + str);
          }
        }
      }, 800L);
    }
    for (;;)
    {
      if (((h.a)localObject).siB.getVisibility() == 0)
      {
        ab.i("MicroMsg.SphereImageView.SphereCardAdTimeLineItem", "hide progressView");
        ((h.a)localObject).siB.setVisibility(8);
      }
      AppMethodBeat.o(145732);
      return;
      label328:
      ab.i("MicroMsg.SphereImageView.SphereCardAdTimeLineItem", "don't need shot, enable sensor, isInLowPriority=" + this.siv.sis);
      if (!this.siv.sis) {
        ((h.a)localObject).siz.setSensorEnabled(true);
      }
      this.siv.sio = false;
    }
  }
  
  public final void crv() {}
  
  public final void crw() {}
  
  public final void crx()
  {
    AppMethodBeat.i(145731);
    h.a(this.siv);
    AppMethodBeat.o(145731);
  }
  
  public final void onDetachedFromWindow()
  {
    int i = 0;
    AppMethodBeat.i(145733);
    ab.i("MicroMsg.SphereImageView.SphereCardAdTimeLineItem", "onDetachedFromWindow reset");
    this.siv.sio = true;
    this.siv.sip = true;
    this.siv.siq = null;
    this.siv.loX.removeCallbacksAndMessages(null);
    try
    {
      Object localObject = new JSONObject();
      ((JSONObject)localObject).put("panCount", h.b(this.siv));
      ((JSONObject)localObject).put("type", 1);
      String str2 = URLEncoder.encode(((JSONObject)localObject).toString(), "UTF-8");
      n localn = this.siv.rkX.EE(this.siv.sin.position);
      String str1 = localn.csM();
      localObject = str1;
      if (str1 == null) {
        localObject = "";
      }
      com.tencent.mm.plugin.report.service.h.qsU.e(17539, new Object[] { localn.csh().Id, localObject, localn.csd().cFe, Integer.valueOf(1), str2 });
      localObject = new StringBuilder("KVReport, id=17539, touchCount=").append(str2).append(", snsInfo.hash=");
      if (localn != null) {
        i = localn.hashCode();
      }
      ab.i("MicroMsg.SphereImageView.SphereCardAdTimeLineItem", i);
    }
    catch (Exception localException)
    {
      for (;;)
      {
        ab.e("MicroMsg.SphereImageView.SphereCardAdTimeLineItem", "kvStat exp:" + localException.toString());
      }
    }
    h.c(this.siv);
    AppMethodBeat.o(145733);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.item.h.3
 * JD-Core Version:    0.7.0.1
 */