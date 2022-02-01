package com.tencent.mm.plugin.sns.ad.landingpage.helper.anim;

import android.animation.Animator;
import android.animation.ObjectAnimator;
import android.os.Handler;
import androidx.lifecycle.q;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.autogen.a.xu;
import com.tencent.mm.plugin.sns.ad.landingpage.component.comp.AdLandingHBCardComponent;
import com.tencent.mm.plugin.sns.data.m;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.aa;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.ai;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.n;
import com.tencent.mm.plugin.sns.ui.SnsAdNativeLandingPagesUI;
import com.tencent.mm.sdk.event.IListener;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import org.json.JSONObject;

class AdLandingPageEggCardHelper$13
  extends IListener<xu>
{
  AdLandingPageEggCardHelper$13(a parama, q paramq)
  {
    super(paramq);
    AppMethodBeat.i(310888);
    this.__eventId = xu.class.getName().hashCode();
    AppMethodBeat.o(310888);
  }
  
  private boolean haS()
  {
    AppMethodBeat.i(310916);
    Log.i("AdLandingPageEggCardHelper", "callback SnsAdEggCardEncoreEvent");
    Object localObject2 = this.PUe;
    Log.i("AdLandingPageEggCardHelper", "reportShakeActionResult, result=1");
    try
    {
      localObject1 = ((a)localObject2).PTA.hjn();
      Object localObject3 = ((ai)localObject1).QLy;
      Object localObject4 = ((ai)localObject1).uxInfo;
      int i = ((ai)localObject1).source;
      localObject1 = new JSONObject();
      ((JSONObject)localObject1).put("snsid", Util.nullAsNil((String)localObject3));
      ((JSONObject)localObject1).put("uxinfo", Util.nullAsNil((String)localObject4));
      ((JSONObject)localObject1).put("scene", i);
      localObject3 = new JSONObject();
      ((JSONObject)localObject3).put("result", 1);
      if (((a)localObject2).PTG != null)
      {
        localObject4 = ((a)localObject2).PTG.PPM;
        if (localObject4 != null) {
          ((JSONObject)localObject3).put("twistCardId", Util.nullAsNil(((aa)localObject4).PPh));
        }
        localObject2 = ((a)localObject2).PTG.PPO;
        if (localObject2 != null)
        {
          localObject2 = ((AdLandingHBCardComponent)localObject2).haD();
          if (localObject2 != null) {
            ((JSONObject)localObject3).put("hbCard", localObject2);
          }
        }
      }
      ((JSONObject)localObject1).put("extInfo", localObject3);
      m.lU("canvas_shakead_encore_shake_result", ((JSONObject)localObject1).toString());
    }
    catch (Exception localException)
    {
      for (;;)
      {
        Object localObject1;
        Log.e("AdLandingPageEggCardHelper", "reportShakeActionResult, exp=" + localException.toString());
        continue;
        Log.w("AdLandingPageEggCardHelper", "callback SnsAdEggCardEncoreEvent, findAnimCardView==null");
        continue;
        a.g(this.PUe).Dm(false);
        Log.w("AdLandingPageEggCardHelper", "callback SnsAdEggCardEncoreEvent, mEggCardComponent==null");
      }
    }
    if (a.g(this.PUe) != null)
    {
      a.g(this.PUe).Dm(false);
      a.h(this.PUe).removeCallbacksAndMessages(null);
      a.r(this.PUe);
      a.a(this.PUe, "");
      a.b(this.PUe, "");
      a.s(this.PUe);
      this.PUe.haR();
      localObject1 = com.tencent.mm.plugin.sns.ad.landingpage.component.comp.b.b(a.g(this.PUe).PPL);
      if (localObject1 != null)
      {
        localObject2 = a.g(this.PUe);
        if (((com.tencent.mm.plugin.sns.ad.landingpage.component.comp.b)localObject2).PPL != null) {
          ((com.tencent.mm.plugin.sns.ad.landingpage.component.comp.b)localObject2).PPL.hap();
        }
        localObject1 = ObjectAnimator.ofFloat(localObject1, "alpha", new float[] { 1.0F, 0.0F });
        ((ObjectAnimator)localObject1).setDuration(500L);
        ((ObjectAnimator)localObject1).setStartDelay(100L);
        ((ObjectAnimator)localObject1).addListener(new com.tencent.mm.plugin.sns.ad.widget.b()
        {
          public final void onAnimationEnd(Animator paramAnonymousAnimator)
          {
            AppMethodBeat.i(310871);
            if (a.q(AdLandingPageEggCardHelper.13.this.PUe))
            {
              a.t(AdLandingPageEggCardHelper.13.this.PUe);
              AppMethodBeat.o(310871);
              return;
            }
            if (a.u(AdLandingPageEggCardHelper.13.this.PUe)) {
              a.v(AdLandingPageEggCardHelper.13.this.PUe);
            }
            AppMethodBeat.o(310871);
          }
        });
        ((ObjectAnimator)localObject1).start();
        a.g(this.PUe).hah();
        a.a(this.PUe, false);
        AppMethodBeat.o(310916);
        return false;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ad.landingpage.helper.anim.AdLandingPageEggCardHelper.13
 * JD-Core Version:    0.7.0.1
 */