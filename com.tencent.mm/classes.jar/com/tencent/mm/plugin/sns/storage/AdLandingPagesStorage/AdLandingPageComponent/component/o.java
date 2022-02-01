package com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component;

import android.annotation.TargetApi;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnLongClickListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.Button;
import android.widget.FrameLayout.LayoutParams;
import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.b;
import com.tencent.mm.al.b.a;
import com.tencent.mm.al.b.b;
import com.tencent.mm.al.b.c;
import com.tencent.mm.ipcinvoker.wx_extension.IPCRunCgi;
import com.tencent.mm.ipcinvoker.wx_extension.IPCRunCgi.a;
import com.tencent.mm.plugin.appbrand.config.WxaExposedParams.a;
import com.tencent.mm.plugin.appbrand.ipc.AppBrandMainProcessService;
import com.tencent.mm.plugin.sns.data.q;
import com.tencent.mm.plugin.sns.model.AdLandingPagesProxy;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageChattingTask;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.f;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.h.a;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.k;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.m;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.p;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.f.a;
import com.tencent.mm.plugin.sns.ui.SnsAdNativeLandingPagesUI;
import com.tencent.mm.protocal.protobuf.bau;
import com.tencent.mm.protocal.protobuf.bav;
import com.tencent.mm.sdk.platformtools.aq;
import com.tencent.mm.sdk.platformtools.ay;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.MMActivity.a;
import com.tencent.mm.ui.base.t;
import com.tencent.mm.ui.widget.RoundedCornerFrameLayout;
import com.tencent.mm.ui.widget.a.e.b;
import java.util.List;
import org.json.JSONObject;

public class o
  extends n
{
  RoundedCornerFrameLayout xat;
  Button xau;
  View xav;
  
  public o(Context paramContext, p paramp, ViewGroup paramViewGroup)
  {
    super(paramContext, paramp, paramViewGroup);
  }
  
  final void a(m paramm, String paramString)
  {
    AppMethodBeat.i(96499);
    try
    {
      final AdLandingPageChattingTask localAdLandingPageChattingTask = new AdLandingPageChattingTask();
      Object localObject2 = paramm.oER;
      Object localObject1 = localObject2;
      if (localObject2 == null) {
        localObject1 = "";
      }
      final WxaExposedParams.a locala = new WxaExposedParams.a();
      locala.appId = paramm.wVP;
      locala.username = ((String)localObject1);
      locala.nickname = "";
      locala.iconUrl = "";
      locala.iOQ = 0;
      locala.pkgVersion = 0;
      locala.jfT = "";
      locala.from = 14;
      locala.pageId = "";
      locala.jfU = "";
      localObject2 = paramString;
      if (TextUtils.isEmpty(paramString)) {
        localObject2 = localObject1;
      }
      localAdLandingPageChattingTask.username = ((String)localObject2);
      localAdLandingPageChattingTask.nickname = "";
      localAdLandingPageChattingTask.jOo = paramm.jOo;
      localAdLandingPageChattingTask.jwt = new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(96495);
          Intent localIntent = new Intent();
          localIntent.setFlags(67108864);
          localIntent.putExtra("Chat_User", localAdLandingPageChattingTask.username);
          localIntent.putExtra("app_brand_chatting_from_scene", 3);
          localIntent.putExtra("app_brand_chatting_expose_params", locala.aTV());
          localIntent.putExtra("key_temp_session_from", localAdLandingPageChattingTask.jOo);
          localIntent.putExtra("finish_direct", true);
          localIntent.putExtra("key_need_send_video", false);
          localIntent.putExtra("showMessageCard", false);
          try
          {
            Object localObject = new JSONObject();
            ((JSONObject)localObject).put("uxInfo", o.this.dwi().dvK);
            localObject = ((JSONObject)localObject).toString();
            localIntent.putExtra("sns_landing_pages_ux_info", (String)localObject);
            MMActivity localMMActivity = (MMActivity)o.this.context;
            localMMActivity.mmSetOnActivityResultCallback(new MMActivity.a()
            {
              public final void c(int paramAnonymous2Int1, int paramAnonymous2Int2, Intent paramAnonymous2Intent)
              {
                AppMethodBeat.i(96494);
                if (paramAnonymous2Int1 == 1) {
                  o.7.this.xaz.aXn();
                }
                AppMethodBeat.o(96494);
              }
            });
            com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.Sns.AdLandingPageBtnComponent", "open ServiceChattingUI， uxInfo=".concat(String.valueOf(localObject)));
            com.tencent.mm.bs.d.c(localMMActivity, ".ui.chatting.AppBrandServiceChattingUI", localIntent, 1);
            AppMethodBeat.o(96495);
            return;
          }
          catch (Exception localException)
          {
            for (;;)
            {
              String str = "";
            }
          }
        }
      };
      localAdLandingPageChattingTask.aXm();
      AppBrandMainProcessService.a(localAdLandingPageChattingTask);
      AppMethodBeat.o(96499);
      return;
    }
    catch (Exception paramm)
    {
      com.tencent.mm.sdk.platformtools.ad.e("MicroMsg.Sns.AdLandingPageBtnComponent", "doEnterChatting exp:" + paramm.toString());
      AppMethodBeat.o(96499);
    }
  }
  
  @TargetApi(17)
  protected void dvN()
  {
    AppMethodBeat.i(96496);
    this.clickCount = 0;
    int i = this.kvn;
    int k = i;
    int j;
    if (((p)this.xab).wWG > 0.0F)
    {
      k = i;
      if (((p)this.xab).wWG <= i)
      {
        i = (int)((p)this.xab).wWG;
        j = (int)((p)this.xab).paddingLeft;
        k = (int)((p)this.xab).paddingRight + (i + j);
      }
    }
    this.xat.setBackgroundColor(this.backgroundColor);
    if (!bt.isNullOrNil(((p)this.xab).wWe))
    {
      com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.h.c("adId", ((p)this.xab).wWe, false, 0, new f.a()
      {
        @TargetApi(16)
        public final void apm(String paramAnonymousString)
        {
          AppMethodBeat.i(96486);
          try
          {
            paramAnonymousString = Drawable.createFromPath(paramAnonymousString);
            o.this.xau.setBackground(paramAnonymousString);
            if ((paramAnonymousString != null) && (o.this.dwo().height > 0.0F) && (paramAnonymousString.getIntrinsicHeight() > 0))
            {
              float f = o.this.dwo().height * paramAnonymousString.getIntrinsicWidth() / paramAnonymousString.getIntrinsicHeight();
              o.this.xau.setLayoutParams(new FrameLayout.LayoutParams((int)f, (int)o.this.dwo().height));
            }
            AppMethodBeat.o(96486);
            return;
          }
          catch (Exception paramAnonymousString)
          {
            com.tencent.mm.sdk.platformtools.ad.e("MicroMsg.Sns.AdLandingPageBtnComponent", "the backgroundCoverUrl is set error ,because " + paramAnonymousString.toString());
            AppMethodBeat.o(96486);
          }
        }
        
        public final void dsA() {}
        
        public final void duP() {}
      });
      j = 0;
    }
    for (;;)
    {
      this.xau.setText(((p)this.xab).title);
      if (((p)this.xab).wWb == 1)
      {
        this.xau.setTypeface(Typeface.defaultFromStyle(1));
        label186:
        this.xau.setOnClickListener(new View.OnClickListener()
        {
          public final void onClick(View paramAnonymousView)
          {
            AppMethodBeat.i(96489);
            o.this.dwm();
            o.this.dwp();
            AppMethodBeat.o(96489);
          }
        });
        if (((p)this.xab).buK > 0.0F) {
          this.xau.setTextSize(0, ((p)this.xab).buK);
        }
        if ((((p)this.xab).wVZ == null) || (((p)this.xab).wVZ.length() <= 0)) {}
      }
      try
      {
        i = Color.parseColor(((p)this.xab).wVZ);
        this.xau.setTextColor(i);
      }
      catch (Exception localException1)
      {
        try
        {
          for (;;)
          {
            for (;;)
            {
              this.xau.setTextAlignment(4);
              if (((p)this.xab).height <= 0.0F) {
                break label765;
              }
              this.xau.setLayoutParams(new FrameLayout.LayoutParams(k - (int)((p)this.xab).paddingLeft - (int)((p)this.xab).paddingRight, (int)((p)this.xab).height));
              if (((p)this.xab).wWf != 1) {
                break label817;
              }
              this.xav.setLayoutParams(new FrameLayout.LayoutParams(k - (int)((p)this.xab).paddingLeft - (int)((p)this.xab).paddingRight, this.xav.getLayoutParams().height));
              this.xav.setVisibility(0);
              this.xav.setOnLongClickListener(new View.OnLongClickListener()
              {
                public final boolean onLongClick(View paramAnonymousView)
                {
                  AppMethodBeat.i(96487);
                  o.a(o.this);
                  AppMethodBeat.o(96487);
                  return true;
                }
              });
              this.xav.setOnClickListener(new View.OnClickListener()
              {
                public final void onClick(View paramAnonymousView)
                {
                  AppMethodBeat.i(96488);
                  o.this.dwm();
                  o.this.dwp();
                  AppMethodBeat.o(96488);
                }
              });
              if (j == 0) {
                this.xat.setRadius(((p)this.xab).qs);
              }
              AppMethodBeat.o(96496);
              return;
              GradientDrawable localGradientDrawable = new GradientDrawable();
              localGradientDrawable.setShape(0);
              if ((bt.isNullOrNil(((p)this.xab).wWd)) || (((p)this.xab).wWa <= 0.0F)) {
                break label829;
              }
              try
              {
                i = Color.parseColor(((p)this.xab).wWd);
                localGradientDrawable.setStroke((int)((p)this.xab).wWa, i);
                if (((p)this.xab).qs > 0.0F) {
                  localGradientDrawable.setCornerRadius(((p)this.xab).qs);
                }
                j = 1;
                i = 1;
                m = j;
                if (bt.isNullOrNil(((p)this.xab).wWc)) {}
              }
              catch (Exception localException3)
              {
                try
                {
                  j = Color.parseColor(((p)this.xab).wWc);
                  localGradientDrawable.setColor(j);
                  int m = 1;
                  j = i;
                  if (m == 0) {
                    break;
                  }
                  this.xau.setBackgroundDrawable(localGradientDrawable);
                  j = i;
                  break;
                  localException3 = localException3;
                  com.tencent.mm.sdk.platformtools.ad.e("MicroMsg.Sns.AdLandingPageBtnComponent", bt.m(localException3));
                  i = 0;
                }
                catch (Exception localException4)
                {
                  for (;;)
                  {
                    com.tencent.mm.sdk.platformtools.ad.e("MicroMsg.Sns.AdLandingPageBtnComponent", bt.m(localException4));
                    j = 0;
                  }
                }
              }
            }
            if (((p)this.xab).wWb != 2) {
              break label186;
            }
            this.xau.setTypeface(Typeface.defaultFromStyle(2));
            break label186;
            localException1 = localException1;
            com.tencent.mm.sdk.platformtools.ad.e("MicroMsg.Sns.AdLandingPageBtnComponent", "invalid color! %s", new Object[] { ((p)this.xab).wVZ });
          }
        }
        catch (Exception localException2)
        {
          for (;;)
          {
            com.tencent.mm.sdk.platformtools.ad.e("MicroMsg.Sns.AdLandingPageBtnComponent", "the device has no method btn.setTextAlignment");
            continue;
            label765:
            this.xau.setLayoutParams(new FrameLayout.LayoutParams(k - (int)((p)this.xab).paddingLeft - (int)((p)this.xab).paddingRight, this.xau.getLayoutParams().height));
            continue;
            label817:
            this.xav.setVisibility(8);
            continue;
            label829:
            j = 0;
            i = 0;
          }
        }
      }
    }
  }
  
  protected void dvW()
  {
    AppMethodBeat.i(187407);
    Object localObject1 = (p)this.xab;
    long l = 0L;
    int i;
    if ((this.context instanceof Activity))
    {
      l = com.tencent.mm.plugin.sns.storage.x.anz(((Activity)this.context).getIntent().getStringExtra("sns_landing_pages_share_sns_id"));
      i = ((Activity)this.context).getIntent().getIntExtra("sns_landig_pages_from_source", 0);
      ((Activity)this.context).getIntent().getIntExtra("sns_landing_pages_adType", 0);
    }
    for (;;)
    {
      Object localObject2;
      if (((p)localObject1).subType == 4)
      {
        localObject1 = (f)localObject1;
        localObject2 = new Intent();
        ((Intent)localObject2).putExtra("key_card_id", ((f)localObject1).nsh);
        if (!bt.isNullOrNil(dwi().aps(((f)localObject1).nsh))) {
          ((f)localObject1).ntf = dwi().aps(((f)localObject1).nsh);
        }
        ((Intent)localObject2).putExtra("key_card_ext", ((f)localObject1).ntf);
        ((Intent)localObject2).putExtra("key_from_scene", 21);
        ((Intent)localObject2).putExtra("key_stastic_scene", 15);
        com.tencent.mm.bs.d.b(this.context, "card", ".ui.CardDetailUI", (Intent)localObject2);
        this.xas.iQ("cardTpId", ((f)localObject1).nsh);
        this.xas.iQ("cardExt", ((f)localObject1).ntf);
        AppMethodBeat.o(187407);
        return;
      }
      if (((p)localObject1).subType == 8) {
        if (((p)this.xab instanceof k))
        {
          localObject2 = "";
          if ((!(this.context instanceof Activity)) || (dwi().bizId != 2)) {
            break label1384;
          }
          localObject2 = ((Activity)this.context).getIntent().getStringExtra("sns_landing_pages_sessionId");
        }
      }
      label975:
      label1384:
      for (localObject1 = ((Activity)this.context).getIntent().getStringExtra("sns_landing_pages_ad_buffer");; localObject1 = "")
      {
        localObject1 = String.format("%s:%s:%s:%s:%d:%s:%s:%d", new Object[] { localObject2, localObject1, ((k)(p)this.xab).wWE, String.valueOf(System.currentTimeMillis() / 1000L), Integer.valueOf(dwi().bizId), dwi().dvK, Long.valueOf(l), Integer.valueOf(i) });
        localObject2 = (k)this.xab;
        q.a(((k)localObject2).username, ((k)localObject2).dzJ, "", dwi().wSi, dwi().iYE, (String)localObject1, dwi().dvK, 1084);
        this.xas.iQ("weappUserName", ((k)localObject2).username);
        this.xas.iQ("weappPath", ((k)localObject2).dzJ);
        AppMethodBeat.o(187407);
        return;
        if (((p)localObject1).subType == 9)
        {
          localObject1 = (com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.h)localObject1;
          localObject2 = new Intent();
          ((Intent)localObject2).putExtra("map_view_type", 1);
          ((Intent)localObject2).putExtra("kwebmap_slat", ((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.h)localObject1).wVI.sOv);
          ((Intent)localObject2).putExtra("kwebmap_lng", ((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.h)localObject1).wVI.sOw);
          ((Intent)localObject2).putExtra("kwebmap_scale", ((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.h)localObject1).wVI.dpd);
          ((Intent)localObject2).putExtra("kPoiName", ((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.h)localObject1).wVI.dtN);
          ((Intent)localObject2).putExtra("Kwebmap_locaion", ((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.h)localObject1).wVI.sOy);
          com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.Sns.AdLandingPageBtnComponent", "locatint to slat " + ((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.h)localObject1).wVI.sOv + ", slong " + ((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.h)localObject1).wVI.sOw + ", " + ((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.h)localObject1).wVI.dtN);
          com.tencent.mm.bs.d.b(this.context, "location", ".ui.RedirectUI", (Intent)localObject2, 2);
          AppMethodBeat.o(187407);
          return;
        }
        if (((p)localObject1).subType == 10)
        {
          if (com.tencent.mm.pluginsdk.ui.span.d.a.CjG == null)
          {
            AppMethodBeat.o(187407);
            return;
          }
          localObject1 = (com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.j)localObject1;
          if (((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.j)localObject1).wVB.size() > 1)
          {
            com.tencent.mm.pluginsdk.ui.span.d.a.CjG.a(this.context, ((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.j)localObject1).wVB, new e.b()
            {
              public final void onDismiss()
              {
                AppMethodBeat.i(96490);
                al.fV(o.this.context);
                AppMethodBeat.o(96490);
              }
            });
            this.xas.iQ("phonenumber", (String)((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.j)localObject1).wVB.get(0));
            AppMethodBeat.o(187407);
            return;
          }
          if (((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.j)localObject1).wVB.size() > 0)
          {
            AdLandingPagesProxy.getInstance().confirmDialPhoneNum((Activity)this.context, (String)((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.j)localObject1).wVB.get(0));
            this.xas.iQ("phonenumber", (String)((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.j)localObject1).wVB.get(0));
          }
          AppMethodBeat.o(187407);
          return;
        }
        Object localObject4;
        if (((p)localObject1).subType == 11)
        {
          String str1;
          String str2;
          String str3;
          boolean bool1;
          boolean bool2;
          if ((this.context instanceof SnsAdNativeLandingPagesUI))
          {
            localObject2 = (SnsAdNativeLandingPagesUI)this.context;
            localObject4 = ((p)localObject1).wWm;
            str1 = ((p)localObject1).wWj;
            str2 = ((p)localObject1).wWk;
            str3 = ((p)localObject1).wWl;
            if (((p)localObject1).wWh != 1) {
              break label1018;
            }
            bool1 = true;
            if (((p)localObject1).wWi != 1) {
              break label1024;
            }
            bool2 = true;
            if (((p)this.xab).wWg != 1) {
              break label1030;
            }
          }
          for (boolean bool3 = true;; bool3 = false)
          {
            ((SnsAdNativeLandingPagesUI)localObject2).a((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.x)localObject4, str1, str2, str3, bool1, bool2, bool3);
            AppMethodBeat.o(187407);
            return;
            label1018:
            bool1 = false;
            break;
            bool2 = false;
            break label975;
          }
        }
        if (((p)localObject1).subType == 12)
        {
          localObject1 = (m)localObject1;
          com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.Sns.AdLandingPageBtnComponent", "openServiceChat:".concat(String.valueOf(localObject1)));
          try
          {
            if (TextUtils.isEmpty(((m)localObject1).jOx)) {
              a((m)localObject1, "");
            }
            for (;;)
            {
              this.xas.iQ("weappid", ((m)localObject1).wVP);
              this.xas.iQ("weappUserName", ((m)localObject1).oER);
              this.xas.iQ("businessId", ((m)localObject1).jOx);
              AppMethodBeat.o(187407);
              return;
              if (!TextUtils.isEmpty(((m)localObject1).oER))
              {
                if (ay.isNetworkConnected(this.context)) {
                  break;
                }
                t.makeText(this.context, 2131763758, 0).show();
              }
            }
          }
          catch (Exception localException)
          {
            for (;;)
            {
              com.tencent.mm.sdk.platformtools.ad.e("MicroMsg.Sns.AdLandingPageBtnComponent", "openServiceChat exp:" + localException.toString());
              continue;
              Object localObject3 = new b.a();
              ((b.a)localObject3).gUU = new bau();
              ((b.a)localObject3).gUV = new bav();
              ((b.a)localObject3).uri = "/cgi-bin/mmbiz-bin/wxausrevent/getsubbusinessinfo";
              ((b.a)localObject3).funcId = 1303;
              ((b.a)localObject3).reqCmdId = 0;
              ((b.a)localObject3).respCmdId = 0;
              localObject3 = ((b.a)localObject3).atI();
              localObject4 = (bau)((b)localObject3).gUS.gUX;
              ((bau)localObject4).username = ((m)localObject1).oER;
              ((bau)localObject4).Dyy = ((m)localObject1).jOx;
              IPCRunCgi.a((b)localObject3, new IPCRunCgi.a()
              {
                public final void a(int paramAnonymousInt1, int paramAnonymousInt2, final String paramAnonymousString, b paramAnonymousb)
                {
                  AppMethodBeat.i(96493);
                  if ((paramAnonymousInt1 != 0) || (paramAnonymousInt2 != 0) || (paramAnonymousb.gUT.gUX == null))
                  {
                    com.tencent.mm.sdk.platformtools.ad.e("MicroMsg.Sns.AdLandingPageBtnComponent", "getsubbusinessinfo cgi failed, errType = %d, errCode = %d, errMsg = %s, rr.resp = %s", new Object[] { Integer.valueOf(paramAnonymousInt1), Integer.valueOf(paramAnonymousInt2), paramAnonymousString, paramAnonymousb.gUT.gUX });
                    aq.f(new Runnable()
                    {
                      public final void run()
                      {
                        AppMethodBeat.i(96491);
                        t.makeText(o.this.context, 2131763758, 0).show();
                        AppMethodBeat.o(96491);
                      }
                    });
                    AppMethodBeat.o(96493);
                    return;
                  }
                  paramAnonymousString = (bav)paramAnonymousb.gUT.gUX;
                  com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.Sns.AdLandingPageBtnComponent", "getsubbusinessinfo cgi success, subBusinessUsername:%s", new Object[] { paramAnonymousString.Dyz });
                  aq.f(new Runnable()
                  {
                    public final void run()
                    {
                      AppMethodBeat.i(96492);
                      o.this.a(o.6.this.xax, paramAnonymousString.Dyz);
                      AppMethodBeat.o(96492);
                    }
                  });
                  AppMethodBeat.o(96493);
                }
              });
            }
          }
        }
        localObject1 = ((p)localObject1).wVX;
        this.xas.iQ("btnJumpUrl", (String)localObject1);
        com.tencent.mm.plugin.sns.data.j.a(this.context, (String)localObject1, dwi(), i, l, ((p)this.xab).wWE);
        AppMethodBeat.o(187407);
        return;
      }
      label1024:
      label1030:
      i = 0;
    }
  }
  
  @TargetApi(17)
  public void dvx()
  {
    AppMethodBeat.i(96498);
    View localView = this.contentView;
    this.xat = ((RoundedCornerFrameLayout)localView.findViewById(2131304903));
    this.xau = ((Button)localView.findViewById(2131304902));
    this.xav = localView.findViewById(2131304905);
    AppMethodBeat.o(96498);
  }
  
  protected final p dwo()
  {
    return (p)this.xab;
  }
  
  protected void dwp()
  {
    AppMethodBeat.i(96497);
    try
    {
      dvW();
      dwn();
      AppMethodBeat.o(96497);
      return;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        com.tencent.mm.sdk.platformtools.ad.e("MicroMsg.Sns.AdLandingPageBtnComponent", "onBtnClick exp=" + localException.toString());
      }
    }
  }
  
  protected final int getLayout()
  {
    return 2131495498;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.o
 * JD-Core Version:    0.7.0.1
 */