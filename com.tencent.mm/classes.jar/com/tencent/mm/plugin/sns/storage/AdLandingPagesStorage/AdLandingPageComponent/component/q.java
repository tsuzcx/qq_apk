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
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.Button;
import android.widget.FrameLayout.LayoutParams;
import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.b.a;
import com.tencent.mm.ak.b.b;
import com.tencent.mm.ak.b.c;
import com.tencent.mm.ipcinvoker.wx_extension.IPCRunCgi;
import com.tencent.mm.ipcinvoker.wx_extension.IPCRunCgi.a;
import com.tencent.mm.plugin.appbrand.config.WxaExposedParams.a;
import com.tencent.mm.plugin.appbrand.ipc.AppBrandMainProcessService;
import com.tencent.mm.plugin.sns.ad.c.e;
import com.tencent.mm.plugin.sns.data.r;
import com.tencent.mm.plugin.sns.model.AdLandingPagesProxy;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageChattingTask;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.ab;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.af;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.f;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.h.a;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.j;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.m;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.y;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.f.a;
import com.tencent.mm.plugin.sns.storage.x;
import com.tencent.mm.plugin.sns.ui.SnsAdNativeLandingPagesUI;
import com.tencent.mm.protocal.protobuf.bjm;
import com.tencent.mm.protocal.protobuf.bjn;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.ar;
import com.tencent.mm.sdk.platformtools.az;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.MMActivity.a;
import com.tencent.mm.ui.base.t;
import com.tencent.mm.ui.widget.RoundedCornerFrameLayout;
import com.tencent.mm.ui.widget.a.e.b;
import java.util.List;
import org.json.JSONObject;

public class q
  extends p
{
  RoundedCornerFrameLayout zVh;
  public Button zVi;
  View zVj;
  public boolean zVk;
  public boolean zVl;
  
  public q(Context paramContext, com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.p paramp, ViewGroup paramViewGroup)
  {
    super(paramContext, paramp, paramViewGroup);
  }
  
  final void a(final m paramm, String paramString)
  {
    AppMethodBeat.i(96499);
    try
    {
      final AdLandingPageChattingTask localAdLandingPageChattingTask = new AdLandingPageChattingTask();
      Object localObject2 = paramm.pSx;
      Object localObject1 = localObject2;
      if (localObject2 == null) {
        localObject1 = "";
      }
      final WxaExposedParams.a locala = new WxaExposedParams.a();
      locala.appId = paramm.zQk;
      locala.username = ((String)localObject1);
      locala.nickname = "";
      locala.iconUrl = "";
      locala.jLV = 0;
      locala.pkgVersion = 0;
      locala.kdI = "";
      locala.from = 14;
      locala.pageId = "";
      locala.kdJ = "";
      localObject2 = paramString;
      if (TextUtils.isEmpty(paramString)) {
        localObject2 = localObject1;
      }
      localAdLandingPageChattingTask.username = ((String)localObject2);
      localAdLandingPageChattingTask.nickname = "";
      localAdLandingPageChattingTask.kNe = paramm.kNe;
      localAdLandingPageChattingTask.kuv = new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(96495);
          localIntent = new Intent();
          localIntent.setFlags(67108864);
          localIntent.putExtra("Chat_User", localAdLandingPageChattingTask.username);
          localIntent.putExtra("app_brand_chatting_from_scene", 3);
          localIntent.putExtra("app_brand_chatting_expose_params", locala.bfb());
          localIntent.putExtra("key_temp_session_from", localAdLandingPageChattingTask.kNe);
          localIntent.putExtra("finish_direct", true);
          localIntent.putExtra("key_need_send_video", false);
          try
          {
            if (paramm.zQl != 1) {
              break label279;
            }
            i = 1;
          }
          catch (Throwable localThrowable)
          {
            try
            {
              for (;;)
              {
                String str2;
                Object localObject1 = new JSONObject();
                ((JSONObject)localObject1).put("uxInfo", q.this.eaD().dGD);
                localObject1 = ((JSONObject)localObject1).toString();
                localIntent.putExtra("sns_landing_pages_ux_info", (String)localObject1);
                Object localObject2 = (MMActivity)q.this.context;
                ((MMActivity)localObject2).mmSetOnActivityResultCallback(new MMActivity.a()
                {
                  public final void c(int paramAnonymous2Int1, int paramAnonymous2Int2, Intent paramAnonymous2Intent)
                  {
                    AppMethodBeat.i(96494);
                    if (paramAnonymous2Int1 == 1) {
                      q.7.this.zVp.bix();
                    }
                    AppMethodBeat.o(96494);
                  }
                });
                ae.i("MicroMsg.Sns.AdLandingPageBtnComponent", "open ServiceChattingUI， uxInfo=".concat(String.valueOf(localObject1)));
                com.tencent.mm.br.d.c((Context)localObject2, ".ui.chatting.AppBrandServiceChattingUI", localIntent, 1);
                AppMethodBeat.o(96495);
                return;
                int i = 0;
                continue;
                localIntent.putExtra("showMessageCard", false);
                continue;
                localThrowable = localThrowable;
                localIntent.putExtra("showMessageCard", false);
                ae.e("MicroMsg.Sns.AdLandingPageBtnComponent", localThrowable.toString());
              }
            }
            catch (Exception localException)
            {
              for (;;)
              {
                String str1 = "";
              }
            }
          }
          localObject1 = paramm.kNo;
          localObject2 = paramm.kNp;
          str2 = paramm.kNq;
          if (i != 0) {
            if (!bu.V(new String[] { localObject1, str2, localObject2 }))
            {
              localIntent.putExtra("showMessageCard", true);
              localIntent.putExtra("sendMessageTitle", (String)localObject1);
              localIntent.putExtra("sendMessagePath", (String)localObject2);
              localIntent.putExtra("sendMessageImg", str2);
            }
          }
        }
      };
      localAdLandingPageChattingTask.biw();
      AppBrandMainProcessService.a(localAdLandingPageChattingTask);
      AppMethodBeat.o(96499);
      return;
    }
    catch (Exception paramm)
    {
      ae.e("MicroMsg.Sns.AdLandingPageBtnComponent", "doEnterChatting exp:" + paramm.toString());
      AppMethodBeat.o(96499);
    }
  }
  
  @TargetApi(17)
  public void dUI()
  {
    AppMethodBeat.i(96498);
    View localView = this.contentView;
    this.zVh = ((RoundedCornerFrameLayout)localView.findViewById(2131304903));
    this.zVi = ((Button)localView.findViewById(2131304902));
    this.zVj = localView.findViewById(2131304905);
    AppMethodBeat.o(96498);
  }
  
  @TargetApi(17)
  protected void dUJ()
  {
    AppMethodBeat.i(96496);
    this.clickCount = 0;
    int i = this.lxZ;
    int k = i;
    int j;
    if (((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.p)this.zUP).zRi > 0.0F)
    {
      k = i;
      if (((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.p)this.zUP).zRi <= i)
      {
        i = (int)((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.p)this.zUP).zRi;
        j = (int)((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.p)this.zUP).paddingLeft;
        k = (int)((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.p)this.zUP).paddingRight + (i + j);
      }
    }
    this.zVh.setBackgroundColor(this.backgroundColor);
    if (!bu.isNullOrNil(((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.p)this.zUP).zQz))
    {
      com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.h.c("adId", ((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.p)this.zUP).zQz, false, 0, new f.a()
      {
        @TargetApi(16)
        public final void ayY(String paramAnonymousString)
        {
          AppMethodBeat.i(96486);
          try
          {
            ae.i("MicroMsg.Sns.AdLandingPageBtnComponent", "onDownloaded, path=".concat(String.valueOf(paramAnonymousString)));
            paramAnonymousString = com.tencent.mm.plugin.sns.ad.f.b.a(q.this.zVi.getResources(), paramAnonymousString);
            q.this.zVi.setBackground(paramAnonymousString);
            if ((paramAnonymousString != null) && (q.this.eaI().height > 0.0F) && (paramAnonymousString.getIntrinsicHeight() > 0))
            {
              float f = q.this.eaI().height * paramAnonymousString.getIntrinsicWidth() / paramAnonymousString.getIntrinsicHeight();
              q.this.zVi.setLayoutParams(new FrameLayout.LayoutParams((int)f, (int)q.this.eaI().height));
            }
            AppMethodBeat.o(96486);
            return;
          }
          catch (Throwable paramAnonymousString)
          {
            ae.e("MicroMsg.Sns.AdLandingPageBtnComponent", "the backgroundCoverUrl is set error ,because " + paramAnonymousString.toString());
            AppMethodBeat.o(96486);
          }
        }
        
        public final void dVu() {}
        
        public final void dVv() {}
      });
      j = 0;
    }
    for (;;)
    {
      this.zVi.setText(((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.p)this.zUP).title);
      if (((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.p)this.zUP).zQw == 1)
      {
        this.zVi.setTypeface(Typeface.defaultFromStyle(1));
        label186:
        this.zVi.setOnClickListener(new q.4(this));
        if (((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.p)this.zUP).fontSize > 0.0F) {
          this.zVi.setTextSize(0, ((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.p)this.zUP).fontSize);
        }
        if ((((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.p)this.zUP).zQu == null) || (((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.p)this.zUP).zQu.length() <= 0)) {}
      }
      try
      {
        i = Color.parseColor(((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.p)this.zUP).zQu);
        this.zVi.setTextColor(i);
      }
      catch (Exception localException1)
      {
        try
        {
          for (;;)
          {
            for (;;)
            {
              this.zVi.setTextAlignment(4);
              if (((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.p)this.zUP).height <= 0.0F) {
                break label765;
              }
              this.zVi.setLayoutParams(new FrameLayout.LayoutParams(k - (int)((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.p)this.zUP).paddingLeft - (int)((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.p)this.zUP).paddingRight, (int)((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.p)this.zUP).height));
              if (((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.p)this.zUP).zQA != 1) {
                break label817;
              }
              this.zVj.setLayoutParams(new FrameLayout.LayoutParams(k - (int)((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.p)this.zUP).paddingLeft - (int)((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.p)this.zUP).paddingRight, this.zVj.getLayoutParams().height));
              this.zVj.setVisibility(0);
              this.zVj.setOnLongClickListener(new q.2(this));
              this.zVj.setOnClickListener(new q.3(this));
              if (j == 0) {
                this.zVh.setRadius(((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.p)this.zUP).tm);
              }
              AppMethodBeat.o(96496);
              return;
              GradientDrawable localGradientDrawable = new GradientDrawable();
              localGradientDrawable.setShape(0);
              if ((bu.isNullOrNil(((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.p)this.zUP).zQy)) || (((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.p)this.zUP).zQv <= 0.0F)) {
                break label829;
              }
              try
              {
                i = Color.parseColor(((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.p)this.zUP).zQy);
                localGradientDrawable.setStroke((int)((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.p)this.zUP).zQv, i);
                if (((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.p)this.zUP).tm > 0.0F) {
                  localGradientDrawable.setCornerRadius(((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.p)this.zUP).tm);
                }
                j = 1;
                i = 1;
                m = j;
                if (bu.isNullOrNil(((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.p)this.zUP).zQx)) {}
              }
              catch (Exception localException3)
              {
                try
                {
                  j = Color.parseColor(((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.p)this.zUP).zQx);
                  localGradientDrawable.setColor(j);
                  int m = 1;
                  j = i;
                  if (m == 0) {
                    break;
                  }
                  this.zVi.setBackgroundDrawable(localGradientDrawable);
                  j = i;
                  break;
                  localException3 = localException3;
                  ae.e("MicroMsg.Sns.AdLandingPageBtnComponent", bu.o(localException3));
                  i = 0;
                }
                catch (Exception localException4)
                {
                  for (;;)
                  {
                    ae.e("MicroMsg.Sns.AdLandingPageBtnComponent", bu.o(localException4));
                    j = 0;
                  }
                }
              }
            }
            if (((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.p)this.zUP).zQw != 2) {
              break label186;
            }
            this.zVi.setTypeface(Typeface.defaultFromStyle(2));
            break label186;
            localException1 = localException1;
            ae.e("MicroMsg.Sns.AdLandingPageBtnComponent", "invalid color! %s", new Object[] { ((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.p)this.zUP).zQu });
          }
        }
        catch (Exception localException2)
        {
          for (;;)
          {
            ae.e("MicroMsg.Sns.AdLandingPageBtnComponent", "the device has no method btn.setTextAlignment");
            continue;
            label765:
            this.zVi.setLayoutParams(new FrameLayout.LayoutParams(k - (int)((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.p)this.zUP).paddingLeft - (int)((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.p)this.zUP).paddingRight, this.zVi.getLayoutParams().height));
            continue;
            label817:
            this.zVj.setVisibility(8);
            continue;
            label829:
            j = 0;
            i = 0;
          }
        }
      }
    }
  }
  
  protected final com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.p eaI()
  {
    return (com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.p)this.zUP;
  }
  
  protected final void eaJ()
  {
    AppMethodBeat.i(219485);
    if ((this.zVl) && ((this.context instanceof Activity))) {
      ((Activity)this.context).overridePendingTransition(2130772108, 2130771986);
    }
    AppMethodBeat.o(219485);
  }
  
  protected void eap()
  {
    AppMethodBeat.i(96497);
    try
    {
      ear();
      eaq();
      AppMethodBeat.o(96497);
      return;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        ae.e("MicroMsg.Sns.AdLandingPageBtnComponent", "onBtnClick exp=" + localException.toString());
      }
    }
  }
  
  protected void ear()
  {
    AppMethodBeat.i(219484);
    Object localObject1 = (com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.p)this.zUP;
    long l = 0L;
    int i;
    if ((this.context instanceof Activity))
    {
      l = x.aze(((Activity)this.context).getIntent().getStringExtra("sns_landing_pages_share_sns_id"));
      i = ((Activity)this.context).getIntent().getIntExtra("sns_landig_pages_from_source", 0);
      ((Activity)this.context).getIntent().getIntExtra("sns_landing_pages_adType", 0);
    }
    for (;;)
    {
      Object localObject2;
      if (((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.p)localObject1).subType == 4)
      {
        localObject1 = (f)localObject1;
        localObject2 = new Intent();
        ((Intent)localObject2).putExtra("key_card_id", ((f)localObject1).oFe);
        if (!bu.isNullOrNil(eaD().aBb(((f)localObject1).oFe))) {
          ((f)localObject1).oGb = eaD().aBb(((f)localObject1).oFe);
        }
        ((Intent)localObject2).putExtra("key_card_ext", ((f)localObject1).oGb);
        ((Intent)localObject2).putExtra("key_from_scene", 21);
        ((Intent)localObject2).putExtra("key_stastic_scene", 15);
        com.tencent.mm.br.d.b(this.context, "card", ".ui.CardDetailUI", (Intent)localObject2);
        eaJ();
        this.zVg.jH("cardTpId", ((f)localObject1).oFe);
        this.zVg.jH("cardExt", ((f)localObject1).oGb);
        AppMethodBeat.o(219484);
        return;
      }
      if (((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.p)localObject1).subType == 8) {
        if (((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.p)this.zUP instanceof com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.k))
        {
          localObject2 = "";
          if ((!(this.context instanceof Activity)) || (eaD().bizId != 2)) {
            break label1516;
          }
          localObject2 = ((Activity)this.context).getIntent().getStringExtra("sns_landing_pages_sessionId");
        }
      }
      label981:
      label1516:
      for (localObject1 = ((Activity)this.context).getIntent().getStringExtra("sns_landing_pages_ad_buffer");; localObject1 = "")
      {
        localObject1 = String.format("%s:%s:%s:%s:%d:%s:%s:%d", new Object[] { localObject2, localObject1, ((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.k)(com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.p)this.zUP).zRg, String.valueOf(System.currentTimeMillis() / 1000L), Integer.valueOf(eaD().bizId), eaD().dGD, Long.valueOf(l), Integer.valueOf(i) });
        localObject2 = (com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.k)this.zUP;
        r.a(((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.k)localObject2).username, ((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.k)localObject2).dKV, "", eaD().zMk, eaD().jWi, (String)localObject1, eaD().dGD, 1084);
        this.zVg.jH("weappUserName", ((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.k)localObject2).username);
        this.zVg.jH("weappPath", ((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.k)localObject2).dKV);
        AppMethodBeat.o(219484);
        return;
        if (((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.p)localObject1).subType == 9)
        {
          localObject1 = (com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.h)localObject1;
          localObject2 = new Intent();
          ((Intent)localObject2).putExtra("map_view_type", 1);
          ((Intent)localObject2).putExtra("kwebmap_slat", ((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.h)localObject1).zQd.vlC);
          ((Intent)localObject2).putExtra("kwebmap_lng", ((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.h)localObject1).zQd.vlD);
          ((Intent)localObject2).putExtra("kwebmap_scale", ((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.h)localObject1).zQd.dzG);
          ((Intent)localObject2).putExtra("kPoiName", ((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.h)localObject1).zQd.dEv);
          ((Intent)localObject2).putExtra("Kwebmap_locaion", ((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.h)localObject1).zQd.vlF);
          ae.i("MicroMsg.Sns.AdLandingPageBtnComponent", "locatint to slat " + ((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.h)localObject1).zQd.vlC + ", slong " + ((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.h)localObject1).zQd.vlD + ", " + ((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.h)localObject1).zQd.dEv);
          com.tencent.mm.br.d.b(this.context, "location", ".ui.RedirectUI", (Intent)localObject2, 2002);
          AppMethodBeat.o(219484);
          return;
        }
        if (((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.p)localObject1).subType == 10)
        {
          if (com.tencent.mm.pluginsdk.ui.span.d.a.FzC == null)
          {
            AppMethodBeat.o(219484);
            return;
          }
          localObject1 = (j)localObject1;
          if (((j)localObject1).zPW.size() > 1)
          {
            com.tencent.mm.pluginsdk.ui.span.d.a.FzC.a(this.context, ((j)localObject1).zPW, new e.b()
            {
              public final void onDismiss()
              {
                AppMethodBeat.i(96490);
                an.gq(q.this.context);
                AppMethodBeat.o(96490);
              }
            });
            this.zVg.jH("phonenumber", (String)((j)localObject1).zPW.get(0));
            AppMethodBeat.o(219484);
            return;
          }
          if (((j)localObject1).zPW.size() > 0)
          {
            AdLandingPagesProxy.getInstance().confirmDialPhoneNum((Activity)this.context, (String)((j)localObject1).zPW.get(0));
            this.zVg.jH("phonenumber", (String)((j)localObject1).zPW.get(0));
          }
          AppMethodBeat.o(219484);
          return;
        }
        Object localObject4;
        if (((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.p)localObject1).subType == 11)
        {
          String str1;
          String str2;
          String str3;
          boolean bool1;
          boolean bool2;
          if ((this.context instanceof SnsAdNativeLandingPagesUI))
          {
            localObject2 = (SnsAdNativeLandingPagesUI)this.context;
            localObject4 = ((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.p)localObject1).zQH;
            str1 = ((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.p)localObject1).zQE;
            str2 = ((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.p)localObject1).zQF;
            str3 = ((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.p)localObject1).zQG;
            if (((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.p)localObject1).zQC != 1) {
              break label1024;
            }
            bool1 = true;
            if (((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.p)localObject1).zQD != 1) {
              break label1030;
            }
            bool2 = true;
            if (((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.p)this.zUP).zQB != 1) {
              break label1036;
            }
          }
          for (boolean bool3 = true;; bool3 = false)
          {
            ((SnsAdNativeLandingPagesUI)localObject2).a((y)localObject4, str1, str2, str3, bool1, bool2, bool3);
            AppMethodBeat.o(219484);
            return;
            bool1 = false;
            break;
            bool2 = false;
            break label981;
          }
        }
        Object localObject3;
        if (((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.p)localObject1).subType == 12)
        {
          localObject1 = (m)localObject1;
          ae.i("MicroMsg.Sns.AdLandingPageBtnComponent", "openServiceChat:".concat(String.valueOf(localObject1)));
          try
          {
            if (TextUtils.isEmpty(((m)localObject1).kNn)) {
              a((m)localObject1, "");
            }
            for (;;)
            {
              this.zVg.jH("weappid", ((m)localObject1).zQk);
              this.zVg.jH("weappUserName", ((m)localObject1).pSx);
              this.zVg.jH("businessId", ((m)localObject1).kNn);
              AppMethodBeat.o(219484);
              return;
              if (!TextUtils.isEmpty(((m)localObject1).pSx))
              {
                if (az.isNetworkConnected(this.context)) {
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
              ae.e("MicroMsg.Sns.AdLandingPageBtnComponent", "openServiceChat exp:" + localException.toString());
              continue;
              localObject3 = new b.a();
              ((b.a)localObject3).hQF = new bjm();
              ((b.a)localObject3).hQG = new bjn();
              ((b.a)localObject3).uri = "/cgi-bin/mmbiz-bin/wxausrevent/getsubbusinessinfo";
              ((b.a)localObject3).funcId = 1303;
              ((b.a)localObject3).hQH = 0;
              ((b.a)localObject3).respCmdId = 0;
              localObject3 = ((b.a)localObject3).aDS();
              localObject4 = (bjm)((com.tencent.mm.ak.b)localObject3).hQD.hQJ;
              ((bjm)localObject4).username = ((m)localObject1).pSx;
              ((bjm)localObject4).GWU = ((m)localObject1).kNn;
              IPCRunCgi.a((com.tencent.mm.ak.b)localObject3, new IPCRunCgi.a()
              {
                public final void a(int paramAnonymousInt1, int paramAnonymousInt2, final String paramAnonymousString, com.tencent.mm.ak.b paramAnonymousb)
                {
                  AppMethodBeat.i(96493);
                  if ((paramAnonymousInt1 != 0) || (paramAnonymousInt2 != 0) || (paramAnonymousb.hQE.hQJ == null))
                  {
                    ae.e("MicroMsg.Sns.AdLandingPageBtnComponent", "getsubbusinessinfo cgi failed, errType = %d, errCode = %d, errMsg = %s, rr.resp = %s", new Object[] { Integer.valueOf(paramAnonymousInt1), Integer.valueOf(paramAnonymousInt2), paramAnonymousString, paramAnonymousb.hQE.hQJ });
                    ar.f(new Runnable()
                    {
                      public final void run()
                      {
                        AppMethodBeat.i(96491);
                        t.makeText(q.this.context, 2131763758, 0).show();
                        AppMethodBeat.o(96491);
                      }
                    });
                    AppMethodBeat.o(96493);
                    return;
                  }
                  paramAnonymousString = (bjn)paramAnonymousb.hQE.hQJ;
                  ae.i("MicroMsg.Sns.AdLandingPageBtnComponent", "getsubbusinessinfo cgi success, subBusinessUsername:%s", new Object[] { paramAnonymousString.GWV });
                  ar.f(new Runnable()
                  {
                    public final void run()
                    {
                      AppMethodBeat.i(96492);
                      q.this.a(q.6.this.zVn, paramAnonymousString.GWV);
                      AppMethodBeat.o(96492);
                    }
                  });
                  AppMethodBeat.o(96493);
                }
              });
            }
          }
        }
        if (((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.p)localObject1).subType == 16)
        {
          localObject3 = (ab)localObject1;
          if (((ab)localObject3).zRu != null)
          {
            localObject1 = eaD().zRP;
            if (TextUtils.isEmpty((CharSequence)localObject1))
            {
              localObject1 = eaD().dGD;
              ae.i("MicroMsg.Sns.AdLandingPageBtnComponent", "jumpScanUI, use old uxInfo=".concat(String.valueOf(localObject1)));
            }
            for (;;)
            {
              e.a(this.context, ((ab)localObject3).zRu, (String)localObject1);
              AppMethodBeat.o(219484);
              return;
              ae.i("MicroMsg.Sns.AdLandingPageBtnComponent", "jumpScanUI, use new uxInfo=".concat(String.valueOf(localObject1)));
            }
          }
          ae.e("MicroMsg.Sns.AdLandingPageBtnComponent", "scanJumpInfo == null");
          AppMethodBeat.o(219484);
          return;
        }
        localObject1 = ((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.p)localObject1).zQs;
        this.zVg.jH("btnJumpUrl", (String)localObject1);
        com.tencent.mm.plugin.sns.data.k.a(this.context, (String)localObject1, eaD(), i, l, ((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.p)this.zUP).zRg);
        eaJ();
        AppMethodBeat.o(219484);
        return;
      }
      label1024:
      label1030:
      label1036:
      i = 0;
    }
  }
  
  protected final int getLayout()
  {
    return 2131495498;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.q
 * JD-Core Version:    0.7.0.1
 */