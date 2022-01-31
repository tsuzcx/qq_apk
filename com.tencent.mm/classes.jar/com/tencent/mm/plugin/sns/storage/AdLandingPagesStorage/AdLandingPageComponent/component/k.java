package com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component;

import android.annotation.TargetApi;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.Typeface;
import android.graphics.drawable.GradientDrawable;
import android.os.Bundle;
import android.os.Parcelable;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.b.a;
import com.tencent.mm.ai.b.b;
import com.tencent.mm.bq.d;
import com.tencent.mm.modelsns.SnsAdClick;
import com.tencent.mm.plugin.appbrand.config.WxaExposedParams.a;
import com.tencent.mm.plugin.appbrand.ipc.AppBrandMainProcessService;
import com.tencent.mm.plugin.sns.model.AdLandingPagesProxy;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageChattingTask;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.e;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.f;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.f.a;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.l;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.x;
import com.tencent.mm.plugin.sns.storage.v;
import com.tencent.mm.plugin.sns.ui.SnsAdNativeLandingPagesUI;
import com.tencent.mm.plugin.sns.ui.SnsAdProxyUI;
import com.tencent.mm.pluginsdk.ui.d.c;
import com.tencent.mm.pluginsdk.ui.d.c.a;
import com.tencent.mm.protocal.protobuf.aqf;
import com.tencent.mm.protocal.protobuf.aqg;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.at;
import com.tencent.mm.sdk.platformtools.bo;
import java.util.List;

public class k
  extends j
{
  RelativeLayout odi;
  Button rvr;
  View rvs;
  
  public k(Context paramContext, l paraml, ViewGroup paramViewGroup)
  {
    super(paramContext, paraml, paramViewGroup);
  }
  
  final void a(com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.k paramk, String paramString)
  {
    AppMethodBeat.i(145302);
    try
    {
      AdLandingPageChattingTask localAdLandingPageChattingTask = new AdLandingPageChattingTask();
      Object localObject2 = paramk.loD;
      Object localObject1 = localObject2;
      if (localObject2 == null) {
        localObject1 = "";
      }
      WxaExposedParams.a locala = new WxaExposedParams.a();
      locala.appId = paramk.rsb;
      locala.username = ((String)localObject1);
      locala.nickname = "";
      locala.iconUrl = "";
      locala.gXe = 0;
      locala.gXf = 0;
      locala.hko = "";
      locala.from = 14;
      locala.pageId = "";
      locala.hkp = "";
      localObject2 = paramString;
      if (TextUtils.isEmpty(paramString)) {
        localObject2 = localObject1;
      }
      localAdLandingPageChattingTask.username = ((String)localObject2);
      localAdLandingPageChattingTask.nickname = "";
      localAdLandingPageChattingTask.sessionFrom = paramk.sessionFrom;
      localAdLandingPageChattingTask.hxp = new k.7(this, localAdLandingPageChattingTask, locala);
      localAdLandingPageChattingTask.aBj();
      AppBrandMainProcessService.a(localAdLandingPageChattingTask);
      AppMethodBeat.o(145302);
      return;
    }
    catch (Exception paramk)
    {
      ab.e("MicroMsg.Sns.AdLandingPageBtnComponent", "doEnterChatting exp:" + paramk.toString());
      AppMethodBeat.o(145302);
    }
  }
  
  @TargetApi(17)
  public final void cqK()
  {
    AppMethodBeat.i(37094);
    View localView = this.contentView;
    this.odi = ((RelativeLayout)localView.findViewById(2131827850));
    this.rvr = ((Button)localView.findViewById(2131827851));
    this.rvs = localView.findViewById(2131827852);
    AppMethodBeat.o(37094);
  }
  
  @TargetApi(17)
  protected final void cqP()
  {
    AppMethodBeat.i(37091);
    this.clickCount = 0;
    int j = this.iiW;
    int i;
    if (((l)this.rve).rsK > 0.0F)
    {
      i = (int)((l)this.rve).rsK;
      j = (int)((l)this.rve).paddingLeft;
      j = (int)((l)this.rve).paddingRight + (i + j);
    }
    this.odi.setBackgroundColor(this.backgroundColor);
    if (!bo.isNullOrNil(((l)this.rve).rsl))
    {
      com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.h.c("adId", ((l)this.rve).rsl, false, 0, new k.1(this));
      this.rvr.setText(((l)this.rve).title);
      if (((l)this.rve).rsi != 1) {
        break label583;
      }
      this.rvr.setTypeface(Typeface.defaultFromStyle(1));
      label164:
      e(this.rvr);
      this.rvr.setTextSize(0, ((l)this.rve).fontSize);
      if ((((l)this.rve).rsg == null) || (((l)this.rve).rsg.length() <= 0)) {}
    }
    for (;;)
    {
      try
      {
        i = Color.parseColor(((l)this.rve).rsg);
        this.rvr.setTextColor(i);
      }
      catch (Exception localException1)
      {
        try
        {
          for (;;)
          {
            this.rvr.setTextAlignment(4);
            if (((l)this.rve).height <= 0.0F) {
              break label652;
            }
            this.rvr.setLayoutParams(new RelativeLayout.LayoutParams(j - (int)((l)this.rve).paddingLeft - (int)((l)this.rve).paddingRight, (int)((l)this.rve).height));
            if (((l)this.rve).rsm != 1) {
              break label704;
            }
            this.rvs.setLayoutParams(new RelativeLayout.LayoutParams(j - (int)((l)this.rve).paddingLeft - (int)((l)this.rve).paddingRight, this.rvs.getLayoutParams().height));
            this.rvs.setVisibility(0);
            this.rvs.setOnLongClickListener(new k.2(this));
            this.rvs.setOnClickListener(new k.3(this));
            AppMethodBeat.o(37091);
            return;
            GradientDrawable localGradientDrawable = new GradientDrawable();
            localGradientDrawable.setShape(0);
            if ((bo.isNullOrNil(((l)this.rve).rsk)) || (((l)this.rve).rsh <= 0.0F)) {
              break label719;
            }
            try
            {
              i = Color.parseColor(((l)this.rve).rsk);
              localGradientDrawable.setStroke((int)((l)this.rve).rsh, i);
              i = 1;
              if (bo.isNullOrNil(((l)this.rve).rsj)) {}
            }
            catch (Exception localException3)
            {
              try
              {
                i = Color.parseColor(((l)this.rve).rsj);
                localGradientDrawable.setColor(i);
                i = 1;
                if (i == 0) {
                  break;
                }
                this.rvr.setBackgroundDrawable(localGradientDrawable);
                break;
                localException3 = localException3;
                ab.e("MicroMsg.Sns.AdLandingPageBtnComponent", bo.l(localException3));
                i = 0;
              }
              catch (Exception localException4)
              {
                for (;;)
                {
                  ab.e("MicroMsg.Sns.AdLandingPageBtnComponent", bo.l(localException4));
                  i = 0;
                }
              }
            }
          }
          label583:
          if (((l)this.rve).rsi != 2) {
            break label164;
          }
          this.rvr.setTypeface(Typeface.defaultFromStyle(2));
          break label164;
          localException1 = localException1;
          ab.e("MicroMsg.Sns.AdLandingPageBtnComponent", "invalid color! %s", new Object[] { ((l)this.rve).rsg });
          continue;
        }
        catch (Exception localException2)
        {
          ab.e("MicroMsg.Sns.AdLandingPageBtnComponent", "the device has no method btn.setTextAlignment");
          continue;
          label652:
          this.rvr.setLayoutParams(new RelativeLayout.LayoutParams(j - (int)((l)this.rve).paddingLeft - (int)((l)this.rve).paddingRight, this.rvr.getLayoutParams().height));
          continue;
          label704:
          this.rvs.setVisibility(8);
          AppMethodBeat.o(37091);
          return;
        }
      }
      label719:
      i = 0;
    }
  }
  
  protected final l cri()
  {
    return (l)this.rve;
  }
  
  protected final void crj()
  {
    AppMethodBeat.i(37093);
    Object localObject1 = (l)this.rve;
    long l = 0L;
    int i;
    if ((this.context instanceof Activity))
    {
      l = v.abO(((Activity)this.context).getIntent().getStringExtra("sns_landing_pages_share_sns_id"));
      i = ((Activity)this.context).getIntent().getIntExtra("sns_landig_pages_from_source", 0);
      ((Activity)this.context).getIntent().getIntExtra("sns_landing_pages_adType", 0);
    }
    for (;;)
    {
      Object localObject3;
      if (((l)localObject1).subType == 4)
      {
        localObject1 = (e)localObject1;
        localObject3 = new Intent();
        ((Intent)localObject3).putExtra("key_card_id", ((e)localObject1).knc);
        if (!bo.isNullOrNil(crc().abh(((e)localObject1).knc))) {
          ((e)localObject1).knR = crc().abh(((e)localObject1).knc);
        }
        ((Intent)localObject3).putExtra("key_card_ext", ((e)localObject1).knR);
        ((Intent)localObject3).putExtra("key_from_scene", 21);
        ((Intent)localObject3).putExtra("key_stastic_scene", 15);
        d.b(this.context, "card", ".ui.CardDetailUI", (Intent)localObject3);
        AppMethodBeat.o(37093);
        return;
      }
      if (((l)localObject1).subType == 8) {
        if (((l)this.rve instanceof com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.i))
        {
          localObject3 = "";
          if ((!(this.context instanceof Activity)) || (crc().rth != 2)) {
            break label1723;
          }
          localObject1 = ((Activity)this.context).getIntent().getStringExtra("sns_landing_pages_sessionId");
          localObject3 = ((Activity)this.context).getIntent().getStringExtra("sns_landing_pages_ad_buffer");
        }
      }
      for (;;)
      {
        localObject1 = String.format("%s:%s:%s:%s:%d:%s:%s:%d", new Object[] { localObject1, localObject3, ((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.i)(l)this.rve).rsI, String.valueOf(System.currentTimeMillis() / 1000L), Integer.valueOf(crc().rth), crc().cFe, Long.valueOf(l), Integer.valueOf(i) });
        localObject3 = (com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.i)this.rve;
        Object localObject4 = com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.i.n(((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.i)localObject3).cIS, new String[] { String.format("gdt_vid=%s", new Object[] { crc().heu }), String.format("weixinadinfo=%s.%s.0.0", new Object[] { crc().rpv, crc().heu }) });
        Object localObject5 = new Intent();
        ((Intent)localObject5).putExtra("username", ((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.i)localObject3).username);
        ((Intent)localObject5).putExtra("url", (String)localObject4);
        ((Intent)localObject5).putExtra("sceneNote", (String)localObject1);
        ((Intent)localObject5).setClass(this.context, SnsAdProxyUI.class);
        this.context.startActivity((Intent)localObject5);
        AppMethodBeat.o(37093);
        return;
        if (((l)localObject1).subType == 9)
        {
          localObject1 = (f)localObject1;
          localObject3 = new Intent();
          ((Intent)localObject3).putExtra("map_view_type", 1);
          ((Intent)localObject3).putExtra("kwebmap_slat", ((f)localObject1).rrU.nZV);
          ((Intent)localObject3).putExtra("kwebmap_lng", ((f)localObject1).rrU.nZW);
          ((Intent)localObject3).putExtra("kwebmap_scale", ((f)localObject1).rrU.cyX);
          ((Intent)localObject3).putExtra("kPoiName", ((f)localObject1).rrU.cDl);
          ((Intent)localObject3).putExtra("Kwebmap_locaion", ((f)localObject1).rrU.nZY);
          ab.i("MicroMsg.Sns.AdLandingPageBtnComponent", "locatint to slat " + ((f)localObject1).rrU.nZV + ", slong " + ((f)localObject1).rrU.nZW + ", " + ((f)localObject1).rrU.cDl);
          d.b(this.context, "location", ".ui.RedirectUI", (Intent)localObject3, 2);
          AppMethodBeat.o(37093);
          return;
        }
        if (((l)localObject1).subType == 10)
        {
          if (c.a.wbU == null)
          {
            AppMethodBeat.o(37093);
            return;
          }
          localObject1 = (com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.h)localObject1;
          if (((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.h)localObject1).rrT.size() > 1)
          {
            c.a.wbU.a(this.context, ((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.h)localObject1).rrT, new k.5(this));
            AppMethodBeat.o(37093);
            return;
          }
          if (((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.h)localObject1).rrT.size() > 0) {
            AdLandingPagesProxy.getInstance().confirmDialPhoneNum((Activity)this.context, (String)((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.h)localObject1).rrT.get(0));
          }
          AppMethodBeat.o(37093);
          return;
        }
        boolean bool1;
        if (((l)localObject1).subType == 11)
        {
          String str1;
          String str2;
          boolean bool2;
          if ((this.context instanceof SnsAdNativeLandingPagesUI))
          {
            localObject3 = (SnsAdNativeLandingPagesUI)this.context;
            localObject4 = ((l)localObject1).rst;
            localObject5 = ((l)localObject1).rsq;
            str1 = ((l)localObject1).rsr;
            str2 = ((l)localObject1).rss;
            if (((l)localObject1).rso != 1) {
              break label1000;
            }
            bool1 = true;
            if (((l)localObject1).rsp != 1) {
              break label1006;
            }
            bool2 = true;
            label957:
            if (((l)this.rve).rsn != 1) {
              break label1012;
            }
          }
          label1000:
          label1006:
          label1012:
          for (boolean bool3 = true;; bool3 = false)
          {
            ((SnsAdNativeLandingPagesUI)localObject3).a((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.t)localObject4, (String)localObject5, str1, str2, bool1, bool2, bool3);
            AppMethodBeat.o(37093);
            return;
            bool1 = false;
            break;
            bool2 = false;
            break label957;
          }
        }
        if (((l)localObject1).subType == 12)
        {
          localObject1 = (com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.k)localObject1;
          ab.i("MicroMsg.Sns.AdLandingPageBtnComponent", "openServiceChat:".concat(String.valueOf(localObject1)));
          try
          {
            if (TextUtils.isEmpty(((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.k)localObject1).hKu))
            {
              a((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.k)localObject1, "");
              AppMethodBeat.o(37093);
              return;
            }
          }
          catch (Exception localException)
          {
            ab.e("MicroMsg.Sns.AdLandingPageBtnComponent", "openServiceChat exp:" + localException.toString());
            AppMethodBeat.o(37093);
            return;
          }
          bool1 = TextUtils.isEmpty(localException.loD);
          if (bool1)
          {
            AppMethodBeat.o(37093);
            return;
          }
          if (!at.isNetworkConnected(this.context))
          {
            com.tencent.mm.ui.base.t.makeText(this.context, 2131303755, 0).show();
            AppMethodBeat.o(37093);
            return;
          }
          localObject3 = new b.a();
          ((b.a)localObject3).fsX = new aqf();
          ((b.a)localObject3).fsY = new aqg();
          ((b.a)localObject3).uri = "/cgi-bin/mmbiz-bin/wxausrevent/getsubbusinessinfo";
          ((b.a)localObject3).funcId = 1303;
          ((b.a)localObject3).reqCmdId = 0;
          ((b.a)localObject3).respCmdId = 0;
          localObject3 = ((b.a)localObject3).ado();
          localObject4 = (aqf)((com.tencent.mm.ai.b)localObject3).fsV.fta;
          ((aqf)localObject4).username = localException.loD;
          ((aqf)localObject4).xfD = localException.hKu;
          com.tencent.mm.ipcinvoker.wx_extension.b.a((com.tencent.mm.ai.b)localObject3, new k.6(this, localException));
          AppMethodBeat.o(37093);
          return;
        }
        localObject4 = new Intent();
        localObject3 = localException.rse;
        Object localObject2 = localObject3;
        if (!TextUtils.isEmpty(crc().heu))
        {
          localObject2 = localObject3;
          if (!TextUtils.isEmpty(crc().rpv)) {
            localObject2 = ae.m((String)localObject3, new String[] { "traceid=" + crc().heu + "&aid=" + crc().rpv });
          }
        }
        localObject3 = crc().cFe;
        localObject2 = com.tencent.mm.plugin.sns.data.i.gg((String)localObject2, (String)localObject3);
        ab.i("MicroMsg.Sns.AdLandingPageBtnComponent", "open url %s", new Object[] { localObject2 });
        ((Intent)localObject4).putExtra("rawUrl", (String)localObject2);
        ((Intent)localObject4).putExtra("useJs", true);
        ((Intent)localObject4).putExtra("type", -255);
        ((Intent)localObject4).putExtra("geta8key_scene", 2);
        if (crc().rth == 0)
        {
          localObject2 = new SnsAdClick(i, l);
          localObject5 = new Bundle();
          ((Bundle)localObject5).putParcelable("KSnsAdTag", (Parcelable)localObject2);
          if (!TextUtils.isEmpty((CharSequence)localObject3)) {
            ((Bundle)localObject5).putString("KAnsUxInfo", (String)localObject3);
          }
          ((Intent)localObject4).putExtra("jsapiargs", (Bundle)localObject5);
        }
        if (((this.context instanceof Activity)) && (crc().rth == 2))
        {
          localObject3 = ((Activity)this.context).getIntent().getStringExtra("sns_landing_pages_sessionId");
          localObject2 = ((Activity)this.context).getIntent().getStringExtra("sns_landing_pages_ad_buffer");
          if (!bo.isNullOrNil((String)localObject3))
          {
            l = System.currentTimeMillis() / 1000L;
            if (bo.isNullOrNil((String)localObject2)) {
              break label1716;
            }
          }
        }
        for (;;)
        {
          localObject2 = String.format("official_mall_%s_%s_%s_%s", new Object[] { localObject2, localObject3, ((l)this.rve).rsI, String.valueOf(l) });
          ((Intent)localObject4).putExtra("prePublishId", (String)localObject2);
          ((Intent)localObject4).putExtra("KPublisherId", (String)localObject2);
          ((Intent)localObject4).putExtra("pay_channel", 47);
          d.b(this.context, "webview", ".ui.tools.WebViewUI", (Intent)localObject4);
          AppMethodBeat.o(37093);
          return;
          label1716:
          localObject2 = "";
        }
        label1723:
        localObject2 = "";
      }
      i = 0;
    }
  }
  
  protected void e(Button paramButton)
  {
    AppMethodBeat.i(37092);
    paramButton.setOnClickListener(new k.4(this));
    AppMethodBeat.o(37092);
  }
  
  protected final int getLayout()
  {
    return 2130970779;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.k
 * JD-Core Version:    0.7.0.1
 */