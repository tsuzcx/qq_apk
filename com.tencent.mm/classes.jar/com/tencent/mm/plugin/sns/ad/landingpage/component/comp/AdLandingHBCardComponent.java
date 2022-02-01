package com.tencent.mm.plugin.sns.ad.landingpage.component.comp;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.AnimatorSet.Builder;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import androidx.lifecycle.j;
import androidx.lifecycle.j.a;
import androidx.lifecycle.p;
import androidx.lifecycle.q;
import androidx.lifecycle.z;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.sns.ad.d.a.c;
import com.tencent.mm.plugin.sns.ad.landingpage.a.2;
import com.tencent.mm.plugin.sns.ad.landingpage.component.info.g.a;
import com.tencent.mm.plugin.sns.b.e;
import com.tencent.mm.plugin.sns.b.f;
import com.tencent.mm.plugin.sns.b.g;
import com.tencent.mm.plugin.sns.b.j;
import com.tencent.mm.plugin.sns.data.m;
import com.tencent.mm.plugin.sns.data.t;
import com.tencent.mm.plugin.sns.model.AdLandingPagesProxy;
import com.tencent.mm.plugin.sns.model.AdLandingPagesProxy.e;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.ai;
import com.tencent.mm.plugin.sns.ui.SnsAdNativeLandingPagesUI;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.threadpool.h;
import com.tencent.threadpool.i;
import java.lang.ref.WeakReference;
import org.json.JSONArray;
import org.json.JSONObject;

public class AdLandingHBCardComponent
  extends com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.n
  implements p
{
  Bitmap IYf;
  com.tencent.mm.plugin.sns.ad.landingpage.component.info.g POK;
  com.tencent.mm.plugin.sns.ad.d.a.b PQV;
  com.tencent.mm.plugin.sns.ad.d.a.b PQW;
  FrameLayout PQX;
  int PQY;
  public String PQZ;
  String PRa;
  g.a PRb;
  c PRc;
  com.tencent.mm.plugin.sns.ad.d.a.a PRd;
  View.OnClickListener PRe;
  private boolean PRf;
  View.OnClickListener PRg;
  View.OnClickListener PRh;
  
  public AdLandingHBCardComponent(Context paramContext, com.tencent.mm.plugin.sns.ad.landingpage.component.info.g paramg, ViewGroup paramViewGroup)
  {
    super(paramContext, paramg, paramViewGroup);
    AppMethodBeat.i(310757);
    this.PQY = -1;
    this.PQZ = "";
    this.PRa = "";
    this.PRe = new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(310696);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.cH(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/sns/ad/landingpage/component/comp/AdLandingHBCardComponent$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aYj());
        Log.i("AdLandingHBCardComponent", "onInviteLinkClick, subType=" + AdLandingHBCardComponent.b(AdLandingHBCardComponent.this));
        if ((AdLandingHBCardComponent.c(AdLandingHBCardComponent.this) instanceof SnsAdNativeLandingPagesUI))
        {
          ((SnsAdNativeLandingPagesUI)AdLandingHBCardComponent.d(AdLandingHBCardComponent.this)).hnw();
          if (AdLandingHBCardComponent.b(AdLandingHBCardComponent.this) == 3) {
            break label135;
          }
          AdLandingHBCardComponent.e(AdLandingHBCardComponent.this).n(AdLandingHBCardComponent.b(AdLandingHBCardComponent.this), false, 3);
        }
        for (;;)
        {
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/sns/ad/landingpage/component/comp/AdLandingHBCardComponent$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(310696);
          return;
          label135:
          AdLandingHBCardComponent.e(AdLandingHBCardComponent.this).n(1, true, 3);
        }
      }
    };
    this.PRf = false;
    this.PRg = new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(310722);
        Object localObject = new com.tencent.mm.hellhoundlib.b.b();
        ((com.tencent.mm.hellhoundlib.b.b)localObject).cH(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/sns/ad/landingpage/component/comp/AdLandingHBCardComponent$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).aYj());
        Log.i("AdLandingHBCardComponent", "onGetHbBtnClick, subType=" + AdLandingHBCardComponent.b(AdLandingHBCardComponent.this));
        if (AdLandingHBCardComponent.b(AdLandingHBCardComponent.this) != 3) {
          AdLandingHBCardComponent.e(AdLandingHBCardComponent.this).n(AdLandingHBCardComponent.b(AdLandingHBCardComponent.this), false, 1);
        }
        while (AdLandingHBCardComponent.b(AdLandingHBCardComponent.this) == 4) {
          if (AdLandingHBCardComponent.a(AdLandingHBCardComponent.this, AdLandingHBCardComponent.f(AdLandingHBCardComponent.this)))
          {
            AdLandingHBCardComponent.g(AdLandingHBCardComponent.this).Dl(false);
            AdLandingHBCardComponent.g(AdLandingHBCardComponent.this).aWr(AdLandingHBCardComponent.f(AdLandingHBCardComponent.this).PSh);
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/sns/ad/landingpage/component/comp/AdLandingHBCardComponent$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(310722);
            return;
            AdLandingHBCardComponent.e(AdLandingHBCardComponent.this).n(1, true, 1);
          }
          else
          {
            localObject = AdLandingHBCardComponent.this;
            paramAnonymousView = AdLandingHBCardComponent.h(AdLandingHBCardComponent.this).getString(b.j.sns_ad_loading2);
            if ((((AdLandingHBCardComponent)localObject).context instanceof SnsAdNativeLandingPagesUI))
            {
              localObject = ((SnsAdNativeLandingPagesUI)((AdLandingHBCardComponent)localObject).context).Rma;
              h.ahAA.bk(new a.2((com.tencent.mm.plugin.sns.ad.landingpage.a)localObject, paramAnonymousView));
            }
            AdLandingHBCardComponent.this.a(AdLandingHBCardComponent.g(AdLandingHBCardComponent.this), AdLandingHBCardComponent.f(AdLandingHBCardComponent.this), 1);
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/sns/ad/landingpage/component/comp/AdLandingHBCardComponent$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(310722);
            return;
          }
        }
        if (AdLandingHBCardComponent.b(AdLandingHBCardComponent.this) == 3) {
          AdLandingHBCardComponent.i(AdLandingHBCardComponent.this);
        }
        AdLandingHBCardComponent.this.aWz(AdLandingHBCardComponent.j(AdLandingHBCardComponent.this));
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/sns/ad/landingpage/component/comp/AdLandingHBCardComponent$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(310722);
      }
    };
    this.PRh = new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(310713);
        Object localObject1 = new com.tencent.mm.hellhoundlib.b.b();
        ((com.tencent.mm.hellhoundlib.b.b)localObject1).cH(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/sns/ad/landingpage/component/comp/AdLandingHBCardComponent$5", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject1).aYj());
        String str1;
        Object localObject2;
        if ((AdLandingHBCardComponent.k(AdLandingHBCardComponent.this) instanceof SnsAdNativeLandingPagesUI))
        {
          paramAnonymousView = AdLandingHBCardComponent.l(AdLandingHBCardComponent.this);
          localObject1 = new StringBuilder();
          ((StringBuilder)localObject1).append("<giveHBCardInfo>");
          ((StringBuilder)localObject1).append("<twistCardId>");
          ((StringBuilder)localObject1).append(paramAnonymousView.PPh);
          ((StringBuilder)localObject1).append("</twistCardId>");
          ((StringBuilder)localObject1).append("<giveCardId>");
          ((StringBuilder)localObject1).append(paramAnonymousView.POQ);
          ((StringBuilder)localObject1).append("</giveCardId>");
          ((StringBuilder)localObject1).append("<senderUserName>");
          ((StringBuilder)localObject1).append(AdLandingPagesProxy.getInstance().getSelfUserName());
          ((StringBuilder)localObject1).append("</senderUserName>");
          ((StringBuilder)localObject1).append("<senderNickName>");
          ((StringBuilder)localObject1).append(AdLandingPagesProxy.getInstance().getSelfNickName());
          ((StringBuilder)localObject1).append("</senderNickName>");
          ((StringBuilder)localObject1).append("<subCardType>");
          ((StringBuilder)localObject1).append(4);
          ((StringBuilder)localObject1).append("</subCardType>");
          ((StringBuilder)localObject1).append("<shareTime>");
          ((StringBuilder)localObject1).append(AdLandingPagesProxy.getInstance().getSyncServerTimeSecond());
          ((StringBuilder)localObject1).append("</shareTime>");
          ((StringBuilder)localObject1).append("</giveHBCardInfo>");
          str1 = ((StringBuilder)localObject1).toString();
          localObject1 = AdLandingHBCardComponent.l(AdLandingHBCardComponent.this).svG;
          localObject2 = AdLandingPagesProxy.getInstance().getSelfNickName();
          paramAnonymousView = (View)localObject1;
          if (TextUtils.isEmpty((CharSequence)localObject1)) {
            paramAnonymousView = AdLandingHBCardComponent.m(AdLandingHBCardComponent.this).getString(b.j.sns_ad_hb_card_share_title);
          }
          if (TextUtils.isEmpty((CharSequence)localObject2)) {
            break label623;
          }
          paramAnonymousView = (String)localObject2 + paramAnonymousView;
        }
        label623:
        for (;;)
        {
          Log.i("AdLandingHBCardComponent", "onShareGiveCard, xml=" + str1 + ", shareTitle=" + paramAnonymousView);
          localObject2 = AdLandingHBCardComponent.l(AdLandingHBCardComponent.this).PSa;
          localObject1 = localObject2;
          if (TextUtils.isEmpty((CharSequence)localObject2))
          {
            Log.i("AdLandingHBCardComponent", "shareThumbUrl is empty");
            localObject1 = AdLandingHBCardComponent.l(AdLandingHBCardComponent.this).PRX;
          }
          SnsAdNativeLandingPagesUI localSnsAdNativeLandingPagesUI = (SnsAdNativeLandingPagesUI)AdLandingHBCardComponent.n(AdLandingHBCardComponent.this);
          String str2 = AdLandingHBCardComponent.l(AdLandingHBCardComponent.this).title;
          Object localObject3 = localSnsAdNativeLandingPagesUI.Ee(false);
          localObject2 = localObject3;
          if (!TextUtils.isEmpty(str1)) {
            localObject2 = ((String)localObject3).replace("<adCanvasInfo>", "<adCanvasInfo>".concat(String.valueOf(str1)));
          }
          localObject3 = localSnsAdNativeLandingPagesUI.Rln;
          ((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.n)localObject3).AcD += 1;
          String str3 = localSnsAdNativeLandingPagesUI.hnP();
          str1 = t.lY(localSnsAdNativeLandingPagesUI.ytZ, localSnsAdNativeLandingPagesUI.uxInfo);
          localObject3 = str1;
          if (!str1.contains("isInteractiveCanvas")) {
            if (!localSnsAdNativeLandingPagesUI.RlY)
            {
              localObject3 = str1;
              if (!((String)localObject2).contains("isInteractiveCanvas")) {}
            }
            else
            {
              localObject3 = t.aT(str1, "isInteractiveCanvas", "1");
            }
          }
          Log.i("MicroMsg.SnsAdNativeLandingPagesUI", "doTransimtForHBCard, shareUrl=".concat(String.valueOf(localObject3)));
          AdLandingPagesProxy.getInstance().doTransimt(localSnsAdNativeLandingPagesUI, (String)localObject2, paramAnonymousView, (String)localObject1, str2, (String)localObject3, str3, Util.nullAsNil(localSnsAdNativeLandingPagesUI.uxInfo), Util.nullAsNil(localSnsAdNativeLandingPagesUI.Rln.rzx));
          if (AdLandingHBCardComponent.b(AdLandingHBCardComponent.this) != 3) {
            AdLandingHBCardComponent.e(AdLandingHBCardComponent.this).n(AdLandingHBCardComponent.b(AdLandingHBCardComponent.this), false, 2);
          }
          for (;;)
          {
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/sns/ad/landingpage/component/comp/AdLandingHBCardComponent$5", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(310713);
            return;
            AdLandingHBCardComponent.e(AdLandingHBCardComponent.this).n(2, true, 2);
          }
        }
      }
    };
    this.POK = paramg;
    this.PRd = new com.tencent.mm.plugin.sns.ad.d.a.a((SnsAdNativeLandingPagesUI)paramContext, this, this.POK);
    AppMethodBeat.o(310757);
  }
  
  private void a(com.tencent.mm.plugin.sns.ad.d.a.b paramb)
  {
    AppMethodBeat.i(310777);
    paramb.contentView.setLayoutParams(haB());
    paramb.POS.setLayoutParams(haB());
    AppMethodBeat.o(310777);
  }
  
  private FrameLayout.LayoutParams haB()
  {
    AppMethodBeat.i(310769);
    FrameLayout.LayoutParams localLayoutParams = new FrameLayout.LayoutParams((int)this.QOV.QKI, (int)this.QOV.QKJ);
    localLayoutParams.gravity = 1;
    localLayoutParams.topMargin = ((int)this.QOV.paddingTop);
    localLayoutParams.bottomMargin = ((int)this.QOV.paddingBottom);
    localLayoutParams.leftMargin = ((int)this.QOV.paddingLeft);
    localLayoutParams.rightMargin = ((int)this.QOV.paddingRight);
    AppMethodBeat.o(310769);
    return localLayoutParams;
  }
  
  public final void Gs()
  {
    AppMethodBeat.i(310875);
    this.PQX = ((FrameLayout)this.contentView.findViewById(b.f.hb_card_container));
    this.PQV = com.tencent.mm.plugin.sns.ad.d.a.b.a(this.context, this.PQX, 1);
    this.PQW = com.tencent.mm.plugin.sns.ad.d.a.b.a(this.context, this.PQX, 2);
    a(this.PQW);
    this.PQX.addView(this.PQW.lBX, new FrameLayout.LayoutParams(-1, -1));
    this.PQW.lBX.setVisibility(4);
    a(this.PQV);
    this.PQX.addView(this.PQV.lBX, new FrameLayout.LayoutParams(-1, -1));
    this.PQV.lBX.setVisibility(4);
    this.PQV.a(this.POK);
    this.PQW.a(this.POK);
    this.PQW.contentView.setBackgroundResource(b.e.ad_hb_card_border_decoration_bg);
    View localView = this.PQW.POS;
    int i = com.tencent.mm.cd.a.fromDPToPix(this.context, 7);
    FrameLayout.LayoutParams localLayoutParams = haB();
    localLayoutParams.bottomMargin += i;
    localLayoutParams.rightMargin += i;
    localLayoutParams.topMargin += i;
    localLayoutParams.leftMargin += i;
    localLayoutParams.width -= i * 2;
    localLayoutParams.height -= i * 2;
    localView.setLayoutParams(localLayoutParams);
    this.PQV.contentView.setClickable(true);
    if ((this.context instanceof q)) {
      ((q)this.context).getLifecycle().addObserver(this);
    }
    AppMethodBeat.o(310875);
  }
  
  public final void a(com.tencent.mm.plugin.sns.ad.d.a.b paramb, g.a parama, int paramInt)
  {
    AppMethodBeat.i(310943);
    Object localObject = hjn();
    int i = ((ai)localObject).source;
    String str1 = Util.nullAsNil(((ai)localObject).uxInfo);
    localObject = Util.nullAsNil(((ai)localObject).rzx);
    String str2 = this.POK.PPh;
    String str3 = this.POK.POQ;
    paramb = new a(this, paramb, parama, paramInt);
    AdLandingPagesProxy.getInstance().getTwistAdCardStatus(str1, i, (String)localObject, str2, str3, paramInt, paramb);
    AppMethodBeat.o(310943);
  }
  
  protected final void aWz(String paramString)
  {
    AppMethodBeat.i(310908);
    if (TextUtils.isEmpty(paramString)) {}
    for (String str1 = this.POK.jumpUrl;; str1 = paramString)
    {
      ai localai = hjn();
      String str2 = localai.QLy;
      long l = Util.safeParseLong(str2);
      Log.i("AdLandingHBCardComponent", "doGetHBCover, subType=" + this.PQY + ", jumpUrl=" + str1 + ", dynamicUrl=" + paramString + ", snsId=" + str2);
      m.a(this.context, str1, localai, localai.source, l, this.POK.QKG);
      AppMethodBeat.o(310908);
      return;
    }
  }
  
  final boolean b(g.a parama)
  {
    boolean bool2 = false;
    boolean bool1 = false;
    AppMethodBeat.i(310900);
    if (this.PRc != null)
    {
      int j = AdLandingPagesProxy.getInstance().getSyncServerTimeSecond();
      int i = 86400;
      if ((parama != null) && (parama.expireTime > 0))
      {
        i = parama.expireTime;
        if (this.PRc.PPk + i < j) {
          bool1 = true;
        }
        Log.i("AdLandingHBCardComponent", "isHBExpired, shareTime=" + this.PRc.PPk + ", expireTime=" + i + ", now=" + j + ", sys.now=" + System.currentTimeMillis() / 1000L);
      }
    }
    for (;;)
    {
      AppMethodBeat.o(310900);
      return bool1;
      Log.e("AdLandingHBCardComponent", "isHBExpired, use Default");
      break;
      Log.e("AdLandingHBCardComponent", "isHBExpired, mShareInfo==null");
      bool1 = bool2;
    }
  }
  
  public final boolean bP(JSONObject paramJSONObject)
  {
    AppMethodBeat.i(310950);
    if (!super.bP(paramJSONObject))
    {
      AppMethodBeat.o(310950);
      return false;
    }
    try
    {
      Object localObject = this.PRd;
      JSONArray localJSONArray = new JSONArray();
      JSONObject localJSONObject = ((com.tencent.mm.plugin.sns.ad.d.a.a)localObject).bB(1, false);
      if (localJSONObject != null) {
        localJSONArray.put(localJSONObject);
      }
      localJSONObject = ((com.tencent.mm.plugin.sns.ad.d.a.a)localObject).bB(2, false);
      if (localJSONObject != null) {
        localJSONArray.put(localJSONObject);
      }
      localJSONObject = ((com.tencent.mm.plugin.sns.ad.d.a.a)localObject).bB(1, true);
      if (localJSONObject != null) {
        localJSONArray.put(localJSONObject);
      }
      localJSONObject = ((com.tencent.mm.plugin.sns.ad.d.a.a)localObject).bB(2, true);
      if (localJSONObject != null) {
        localJSONArray.put(localJSONObject);
      }
      localObject = ((com.tencent.mm.plugin.sns.ad.d.a.a)localObject).bB(4, false);
      if (localObject != null) {
        localJSONArray.put(localObject);
      }
      if (localJSONArray.length() > 0) {}
      for (;;)
      {
        if (localJSONArray != null)
        {
          paramJSONObject.put("exposureCount", this.PRd.POH);
          paramJSONObject.put("hbCard", localJSONArray);
        }
        Log.i("AdLandingHBCardComponent", "kv13387:" + paramJSONObject.toString());
        AppMethodBeat.o(310950);
        return true;
        localJSONArray = null;
      }
      return false;
    }
    catch (Exception paramJSONObject)
    {
      Log.e("AdLandingHBCardComponent", "setComponentKVReportData, exp=" + paramJSONObject.toString());
      AppMethodBeat.o(310950);
    }
  }
  
  public final int getLayout()
  {
    return b.g.sns_ad_native_landing_pages_item_hb_card;
  }
  
  public final void haC() {}
  
  public final JSONObject haD()
  {
    AppMethodBeat.i(310958);
    for (;;)
    {
      try
      {
        JSONObject localJSONObject = new JSONObject();
        if (this.PQY != 3)
        {
          localJSONObject.put("subType", this.PQY);
          localJSONObject.put("isDoubleCard", 0);
          if (localJSONObject.optInt("subType") != 1) {
            localJSONObject.put("giveCardId", this.POK.POQ);
          }
          AppMethodBeat.o(310958);
          return localJSONObject;
        }
        localJSONObject.put("isDoubleCard", 1);
        if (this.PQV.lBX.getVisibility() == 0)
        {
          localJSONObject.put("subType", 1);
          continue;
        }
        if (this.PQW.lBX.getVisibility() != 0) {
          continue;
        }
      }
      catch (Exception localException)
      {
        Log.e("AdLandingHBCardComponent", "getCurrentShowCardStatInfo, exp=" + localException.toString());
        AppMethodBeat.o(310958);
        return null;
      }
      localException.put("subType", 2);
    }
  }
  
  public final void had()
  {
    AppMethodBeat.i(310891);
    super.had();
    AppMethodBeat.o(310891);
  }
  
  public final void hal() {}
  
  @z(Ho=j.a.ON_DESTROY)
  public void onUIDestroy()
  {
    AppMethodBeat.i(310934);
    Log.i("AdLandingHBCardComponent", "onUIDestroy");
    AppMethodBeat.o(310934);
  }
  
  @z(Ho=j.a.ON_PAUSE)
  public void onUIPause()
  {
    AppMethodBeat.i(310927);
    Log.i("AdLandingHBCardComponent", "onUIPause");
    AppMethodBeat.o(310927);
  }
  
  @z(Ho=j.a.ON_RESUME)
  public void onUIResume()
  {
    AppMethodBeat.i(310917);
    Log.i("AdLandingHBCardComponent", "onUIResume");
    if (this.PRf)
    {
      this.PRf = false;
      if (this.PQV.lBX.getVisibility() == 0) {
        h.ahAA.o(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(310707);
            AdLandingHBCardComponent localAdLandingHBCardComponent = AdLandingHBCardComponent.this;
            Object localObject1;
            Object localObject2;
            if ((localAdLandingHBCardComponent.PQY == 3) && (localAdLandingHBCardComponent.PQW != null) && (localAdLandingHBCardComponent.PQV != null))
            {
              localObject1 = localAdLandingHBCardComponent.PQV.lBX;
              localObject2 = localAdLandingHBCardComponent.PQW.lBX;
              if ((localObject1 != null) && (localObject2 != null)) {
                break label75;
              }
            }
            for (;;)
            {
              localAdLandingHBCardComponent.PRd.bA(2, true);
              AppMethodBeat.o(310707);
              return;
              label75:
              ObjectAnimator localObjectAnimator1 = ObjectAnimator.ofFloat(localObject1, "translationX", new float[] { 0.0F, -com.tencent.mm.cd.a.fromDPToPix(localAdLandingHBCardComponent.context, 300) });
              localObjectAnimator1.setDuration(500L);
              ObjectAnimator localObjectAnimator2 = ObjectAnimator.ofFloat(localObject1, "alpha", new float[] { 1.0F, 0.0F });
              localObjectAnimator2.setDuration(500L);
              localObjectAnimator2.addListener(new AdLandingHBCardComponent.2(localAdLandingHBCardComponent, (View)localObject1));
              localObject1 = ObjectAnimator.ofFloat(localObject2, "scaleX", new float[] { 1.0F, 1.05F });
              ((ObjectAnimator)localObject1).setDuration(250L);
              ObjectAnimator localObjectAnimator3 = ObjectAnimator.ofFloat(localObject2, "scaleY", new float[] { 1.0F, 1.05F });
              localObjectAnimator3.setDuration(250L);
              ObjectAnimator localObjectAnimator4 = ObjectAnimator.ofFloat(localObject2, "scaleX", new float[] { 1.05F, 1.0F });
              localObjectAnimator4.setDuration(250L);
              ObjectAnimator localObjectAnimator5 = ObjectAnimator.ofFloat(localObject2, "scaleY", new float[] { 1.05F, 1.0F });
              localObjectAnimator5.setDuration(250L);
              localObject2 = ObjectAnimator.ofFloat(localObject2, "Rotation", new float[] { 5.0F, 0.0F });
              ((ObjectAnimator)localObject2).setDuration(500L);
              AnimatorSet localAnimatorSet = new AnimatorSet();
              localAnimatorSet.play(localObjectAnimator1).with(localObjectAnimator2).with((Animator)localObject2);
              localAnimatorSet.play((Animator)localObject1).with(localObjectAnimator3);
              localAnimatorSet.play(localObjectAnimator4).with(localObjectAnimator5);
              localAnimatorSet.play(localObjectAnimator4).after((Animator)localObject1);
              localAnimatorSet.start();
            }
          }
        }, 500L);
      }
    }
    AppMethodBeat.o(310917);
  }
  
  static final class a
    implements AdLandingPagesProxy.e
  {
    private WeakReference<com.tencent.mm.plugin.sns.ad.d.a.b> PRn;
    private g.a PRo;
    private long PRp;
    private WeakReference<AdLandingHBCardComponent> hml;
    private int opType;
    
    public a(AdLandingHBCardComponent paramAdLandingHBCardComponent, com.tencent.mm.plugin.sns.ad.d.a.b paramb, g.a parama, int paramInt)
    {
      AppMethodBeat.i(310671);
      this.hml = new WeakReference(paramAdLandingHBCardComponent);
      this.PRn = new WeakReference(paramb);
      this.PRo = parama;
      this.opType = paramInt;
      this.PRp = System.currentTimeMillis();
      AppMethodBeat.o(310671);
    }
    
    public final void h(int paramInt1, int paramInt2, Object paramObject)
    {
      AppMethodBeat.i(310695);
      Object localObject1 = com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.b.g.k(paramInt1, paramInt2, paramObject);
      final int i = ((Bundle)localObject1).getInt("status", -1);
      Object localObject2 = ((Bundle)localObject1).getString("card_id", "");
      String str = ((Bundle)localObject1).getString("give_card_id", "");
      localObject1 = ((Bundle)localObject1).getString("receive_url", "");
      long l1 = System.currentTimeMillis();
      long l2 = this.PRp;
      Log.i("AdLandingHBCardComponent", "getHBStatus rsp, errType=" + paramInt1 + ", errNo=" + paramInt2 + ", status=" + i + ", cardId=" + (String)localObject2 + ", giveCardId=" + str + ", timeCost=" + (l1 - l2) + ", opType=" + this.opType + ", jumpUrl=" + (String)localObject1);
      localObject2 = (AdLandingHBCardComponent)this.hml.get();
      final com.tencent.mm.plugin.sns.ad.d.a.b localb = (com.tencent.mm.plugin.sns.ad.d.a.b)this.PRn.get();
      if ((localObject2 == null) || (localb == null))
      {
        Log.e("AdLandingHBCardComponent", "onCallback, hbComp==null or showCard==null");
        AppMethodBeat.o(310695);
        return;
      }
      if ((((AdLandingHBCardComponent)localObject2).context instanceof SnsAdNativeLandingPagesUI)) {
        ((SnsAdNativeLandingPagesUI)((AdLandingHBCardComponent)localObject2).context).Rma.hideLoading();
      }
      com.tencent.mm.plugin.sns.ad.landingpage.component.info.g localg = (com.tencent.mm.plugin.sns.ad.landingpage.component.info.g)((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.n)localObject2).QOV;
      final Context localContext = AdLandingHBCardComponent.o((AdLandingHBCardComponent)localObject2);
      if ((paramInt1 != 0) || (paramInt2 != 0) || (paramObject == null))
      {
        if (this.opType == 1) {
          h.ahAA.bk(new Runnable()
          {
            public final void run()
            {
              AppMethodBeat.i(310659);
              com.tencent.mm.ui.base.aa.da(localContext, localContext.getString(b.j.sns_ad_hb_card_cover_network_err));
              AppMethodBeat.o(310659);
            }
          });
        }
        AppMethodBeat.o(310695);
        return;
      }
      if ((localg != null) && (localg.POQ != null) && (localg.POQ.equals(str)) && (this.PRo != null)) {
        h.ahAA.bk(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(310657);
            if (i == 1)
            {
              localb.Dl(true);
              localb.aWr(AdLandingHBCardComponent.a.a(AdLandingHBCardComponent.a.this).btnTitle);
              if (AdLandingHBCardComponent.a.b(AdLandingHBCardComponent.a.this) == 1)
              {
                this.PRt.aWz(this.PRu);
                AppMethodBeat.o(310657);
              }
            }
            else if (i == 2)
            {
              localb.Dl(false);
              localb.aWr(AdLandingHBCardComponent.a.a(AdLandingHBCardComponent.a.this).PSi);
              if (AdLandingHBCardComponent.a.b(AdLandingHBCardComponent.a.this) == 1) {
                com.tencent.mm.ui.base.aa.da(localContext, localContext.getString(b.j.sns_ad_hb_card_cover_disable));
              }
            }
            AppMethodBeat.o(310657);
          }
        });
      }
      AppMethodBeat.o(310695);
    }
    
    public final void onCallback(Object paramObject) {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ad.landingpage.component.comp.AdLandingHBCardComponent
 * JD-Core Version:    0.7.0.1
 */