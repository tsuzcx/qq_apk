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
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.aa;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.ae;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.f;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.h.a;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.k;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.m;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.f.a;
import com.tencent.mm.plugin.sns.ui.SnsAdNativeLandingPagesUI;
import com.tencent.mm.protocal.protobuf.biu;
import com.tencent.mm.protocal.protobuf.biv;
import com.tencent.mm.sdk.platformtools.ad;
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

public class p
  extends o
{
  RoundedCornerFrameLayout zEc;
  public Button zEd;
  View zEe;
  public boolean zEf;
  
  public p(Context paramContext, com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.p paramp, ViewGroup paramViewGroup)
  {
    super(paramContext, paramp, paramViewGroup);
  }
  
  final void a(final m paramm, String paramString)
  {
    AppMethodBeat.i(96499);
    try
    {
      final AdLandingPageChattingTask localAdLandingPageChattingTask = new AdLandingPageChattingTask();
      Object localObject2 = paramm.pLS;
      Object localObject1 = localObject2;
      if (localObject2 == null) {
        localObject1 = "";
      }
      final WxaExposedParams.a locala = new WxaExposedParams.a();
      locala.appId = paramm.zyL;
      locala.username = ((String)localObject1);
      locala.nickname = "";
      locala.iconUrl = "";
      locala.jIU = 0;
      locala.pkgVersion = 0;
      locala.kar = "";
      locala.from = 14;
      locala.pageId = "";
      locala.kas = "";
      localObject2 = paramString;
      if (TextUtils.isEmpty(paramString)) {
        localObject2 = localObject1;
      }
      localAdLandingPageChattingTask.username = ((String)localObject2);
      localAdLandingPageChattingTask.nickname = "";
      localAdLandingPageChattingTask.kJP = paramm.kJP;
      localAdLandingPageChattingTask.krg = new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(96495);
          localIntent = new Intent();
          localIntent.setFlags(67108864);
          localIntent.putExtra("Chat_User", localAdLandingPageChattingTask.username);
          localIntent.putExtra("app_brand_chatting_from_scene", 3);
          localIntent.putExtra("app_brand_chatting_expose_params", locala.bet());
          localIntent.putExtra("key_temp_session_from", localAdLandingPageChattingTask.kJP);
          localIntent.putExtra("finish_direct", true);
          localIntent.putExtra("key_need_send_video", false);
          try
          {
            if (paramm.zyM != 1) {
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
                ((JSONObject)localObject1).put("uxInfo", p.this.dWZ().dFy);
                localObject1 = ((JSONObject)localObject1).toString();
                localIntent.putExtra("sns_landing_pages_ux_info", (String)localObject1);
                Object localObject2 = (MMActivity)p.this.context;
                ((MMActivity)localObject2).mmSetOnActivityResultCallback(new MMActivity.a()
                {
                  public final void c(int paramAnonymous2Int1, int paramAnonymous2Int2, Intent paramAnonymous2Intent)
                  {
                    AppMethodBeat.i(96494);
                    if (paramAnonymous2Int1 == 1) {
                      p.7.this.zEj.bhO();
                    }
                    AppMethodBeat.o(96494);
                  }
                });
                ad.i("MicroMsg.Sns.AdLandingPageBtnComponent", "open ServiceChattingUI， uxInfo=".concat(String.valueOf(localObject1)));
                com.tencent.mm.bs.d.c((Context)localObject2, ".ui.chatting.AppBrandServiceChattingUI", localIntent, 1);
                AppMethodBeat.o(96495);
                return;
                int i = 0;
                continue;
                localIntent.putExtra("showMessageCard", false);
                continue;
                localThrowable = localThrowable;
                localIntent.putExtra("showMessageCard", false);
                ad.e("MicroMsg.Sns.AdLandingPageBtnComponent", localThrowable.toString());
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
          localObject1 = paramm.kJZ;
          localObject2 = paramm.kKa;
          str2 = paramm.kKb;
          if (i != 0) {
            if (!bt.V(new String[] { localObject1, str2, localObject2 }))
            {
              localIntent.putExtra("showMessageCard", true);
              localIntent.putExtra("sendMessageTitle", (String)localObject1);
              localIntent.putExtra("sendMessagePath", (String)localObject2);
              localIntent.putExtra("sendMessageImg", str2);
            }
          }
        }
      };
      localAdLandingPageChattingTask.bhN();
      AppBrandMainProcessService.a(localAdLandingPageChattingTask);
      AppMethodBeat.o(96499);
      return;
    }
    catch (Exception paramm)
    {
      ad.e("MicroMsg.Sns.AdLandingPageBtnComponent", "doEnterChatting exp:" + paramm.toString());
      AppMethodBeat.o(96499);
    }
  }
  
  @TargetApi(17)
  public void dRk()
  {
    AppMethodBeat.i(96498);
    View localView = this.contentView;
    this.zEc = ((RoundedCornerFrameLayout)localView.findViewById(2131304903));
    this.zEd = ((Button)localView.findViewById(2131304902));
    this.zEe = localView.findViewById(2131304905);
    AppMethodBeat.o(96498);
  }
  
  @TargetApi(17)
  protected void dRl()
  {
    AppMethodBeat.i(96496);
    this.clickCount = 0;
    int i = this.ltA;
    int k = i;
    int j;
    if (((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.p)this.zDK).zAi > 0.0F)
    {
      k = i;
      if (((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.p)this.zDK).zAi <= i)
      {
        i = (int)((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.p)this.zDK).zAi;
        j = (int)((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.p)this.zDK).paddingLeft;
        k = (int)((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.p)this.zDK).paddingRight + (i + j);
      }
    }
    this.zEc.setBackgroundColor(this.backgroundColor);
    if (!bt.isNullOrNil(((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.p)this.zDK).zzA))
    {
      com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.h.c("adId", ((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.p)this.zDK).zzA, false, 0, new f.a()
      {
        @TargetApi(16)
        public final void axG(String paramAnonymousString)
        {
          AppMethodBeat.i(96486);
          try
          {
            ad.i("MicroMsg.Sns.AdLandingPageBtnComponent", "onDownloaded, path=".concat(String.valueOf(paramAnonymousString)));
            paramAnonymousString = com.tencent.mm.plugin.sns.ad.e.a.a(p.this.zEd.getResources(), paramAnonymousString);
            p.this.zEd.setBackground(paramAnonymousString);
            if ((paramAnonymousString != null) && (p.this.dXf().height > 0.0F) && (paramAnonymousString.getIntrinsicHeight() > 0))
            {
              float f = p.this.dXf().height * paramAnonymousString.getIntrinsicWidth() / paramAnonymousString.getIntrinsicHeight();
              p.this.zEd.setLayoutParams(new FrameLayout.LayoutParams((int)f, (int)p.this.dXf().height));
            }
            AppMethodBeat.o(96486);
            return;
          }
          catch (Throwable paramAnonymousString)
          {
            ad.e("MicroMsg.Sns.AdLandingPageBtnComponent", "the backgroundCoverUrl is set error ,because " + paramAnonymousString.toString());
            AppMethodBeat.o(96486);
          }
        }
        
        public final void dRW() {}
        
        public final void dRX() {}
      });
      j = 0;
    }
    for (;;)
    {
      this.zEd.setText(((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.p)this.zDK).title);
      if (((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.p)this.zDK).zyX == 1)
      {
        this.zEd.setTypeface(Typeface.defaultFromStyle(1));
        label187:
        this.zEd.setOnClickListener(new View.OnClickListener()
        {
          public final void onClick(View paramAnonymousView)
          {
            AppMethodBeat.i(96489);
            com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
            localb.bd(paramAnonymousView);
            com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/component/AdLandingPageBtnComponent$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahq());
            p.this.dXd();
            p.this.dXg();
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/component/AdLandingPageBtnComponent$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(96489);
          }
        });
        if (((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.p)this.zDK).fontSize > 0.0F) {
          this.zEd.setTextSize(0, ((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.p)this.zDK).fontSize);
        }
        if ((((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.p)this.zDK).zyV == null) || (((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.p)this.zDK).zyV.length() <= 0)) {}
      }
      try
      {
        i = Color.parseColor(((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.p)this.zDK).zyV);
        this.zEd.setTextColor(i);
      }
      catch (Exception localException1)
      {
        try
        {
          for (;;)
          {
            for (;;)
            {
              this.zEd.setTextAlignment(4);
              if (((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.p)this.zDK).height <= 0.0F) {
                break label766;
              }
              this.zEd.setLayoutParams(new FrameLayout.LayoutParams(k - (int)((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.p)this.zDK).paddingLeft - (int)((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.p)this.zDK).paddingRight, (int)((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.p)this.zDK).height));
              if (((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.p)this.zDK).zzB != 1) {
                break label818;
              }
              this.zEe.setLayoutParams(new FrameLayout.LayoutParams(k - (int)((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.p)this.zDK).paddingLeft - (int)((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.p)this.zDK).paddingRight, this.zEe.getLayoutParams().height));
              this.zEe.setVisibility(0);
              this.zEe.setOnLongClickListener(new View.OnLongClickListener()
              {
                public final boolean onLongClick(View paramAnonymousView)
                {
                  AppMethodBeat.i(96487);
                  com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
                  localb.bd(paramAnonymousView);
                  com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/component/AdLandingPageBtnComponent$2", "android/view/View$OnLongClickListener", "onLongClick", "(Landroid/view/View;)Z", this, localb.ahq());
                  p.a(p.this);
                  com.tencent.mm.hellhoundlib.a.a.a(true, this, "com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/component/AdLandingPageBtnComponent$2", "android/view/View$OnLongClickListener", "onLongClick", "(Landroid/view/View;)Z");
                  AppMethodBeat.o(96487);
                  return true;
                }
              });
              this.zEe.setOnClickListener(new View.OnClickListener()
              {
                public final void onClick(View paramAnonymousView)
                {
                  AppMethodBeat.i(96488);
                  com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
                  localb.bd(paramAnonymousView);
                  com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/component/AdLandingPageBtnComponent$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahq());
                  p.this.dXd();
                  p.this.dXg();
                  com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/component/AdLandingPageBtnComponent$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                  AppMethodBeat.o(96488);
                }
              });
              if (j == 0) {
                this.zEc.setRadius(((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.p)this.zDK).tm);
              }
              AppMethodBeat.o(96496);
              return;
              GradientDrawable localGradientDrawable = new GradientDrawable();
              localGradientDrawable.setShape(0);
              if ((bt.isNullOrNil(((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.p)this.zDK).zyZ)) || (((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.p)this.zDK).zyW <= 0.0F)) {
                break label830;
              }
              try
              {
                i = Color.parseColor(((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.p)this.zDK).zyZ);
                localGradientDrawable.setStroke((int)((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.p)this.zDK).zyW, i);
                if (((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.p)this.zDK).tm > 0.0F) {
                  localGradientDrawable.setCornerRadius(((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.p)this.zDK).tm);
                }
                j = 1;
                i = 1;
                m = j;
                if (bt.isNullOrNil(((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.p)this.zDK).zyY)) {}
              }
              catch (Exception localException3)
              {
                try
                {
                  j = Color.parseColor(((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.p)this.zDK).zyY);
                  localGradientDrawable.setColor(j);
                  int m = 1;
                  j = i;
                  if (m == 0) {
                    break;
                  }
                  this.zEd.setBackgroundDrawable(localGradientDrawable);
                  j = i;
                  break;
                  localException3 = localException3;
                  ad.e("MicroMsg.Sns.AdLandingPageBtnComponent", bt.n(localException3));
                  i = 0;
                }
                catch (Exception localException4)
                {
                  for (;;)
                  {
                    ad.e("MicroMsg.Sns.AdLandingPageBtnComponent", bt.n(localException4));
                    j = 0;
                  }
                }
              }
            }
            if (((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.p)this.zDK).zyX != 2) {
              break label187;
            }
            this.zEd.setTypeface(Typeface.defaultFromStyle(2));
            break label187;
            localException1 = localException1;
            ad.e("MicroMsg.Sns.AdLandingPageBtnComponent", "invalid color! %s", new Object[] { ((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.p)this.zDK).zyV });
          }
        }
        catch (Exception localException2)
        {
          for (;;)
          {
            ad.e("MicroMsg.Sns.AdLandingPageBtnComponent", "the device has no method btn.setTextAlignment");
            continue;
            label766:
            this.zEd.setLayoutParams(new FrameLayout.LayoutParams(k - (int)((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.p)this.zDK).paddingLeft - (int)((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.p)this.zDK).paddingRight, this.zEd.getLayoutParams().height));
            continue;
            label818:
            this.zEe.setVisibility(8);
            continue;
            label830:
            j = 0;
            i = 0;
          }
        }
      }
    }
  }
  
  protected void dWN()
  {
    AppMethodBeat.i(197978);
    Object localObject1 = (com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.p)this.zDK;
    long l = 0L;
    int i;
    if ((this.context instanceof Activity))
    {
      l = com.tencent.mm.plugin.sns.storage.x.axN(((Activity)this.context).getIntent().getStringExtra("sns_landing_pages_share_sns_id"));
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
        ((Intent)localObject2).putExtra("key_card_id", ((f)localObject1).oyC);
        if (!bt.isNullOrNil(dWZ().azK(((f)localObject1).oyC))) {
          ((f)localObject1).ozz = dWZ().azK(((f)localObject1).oyC);
        }
        ((Intent)localObject2).putExtra("key_card_ext", ((f)localObject1).ozz);
        ((Intent)localObject2).putExtra("key_from_scene", 21);
        ((Intent)localObject2).putExtra("key_stastic_scene", 15);
        com.tencent.mm.bs.d.b(this.context, "card", ".ui.CardDetailUI", (Intent)localObject2);
        this.zEb.jB("cardTpId", ((f)localObject1).oyC);
        this.zEb.jB("cardExt", ((f)localObject1).ozz);
        AppMethodBeat.o(197978);
        return;
      }
      if (((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.p)localObject1).subType == 8) {
        if (((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.p)this.zDK instanceof k))
        {
          localObject2 = "";
          if ((!(this.context instanceof Activity)) || (dWZ().bizId != 2)) {
            break label1506;
          }
          localObject2 = ((Activity)this.context).getIntent().getStringExtra("sns_landing_pages_sessionId");
        }
      }
      label975:
      label1506:
      for (localObject1 = ((Activity)this.context).getIntent().getStringExtra("sns_landing_pages_ad_buffer");; localObject1 = "")
      {
        localObject1 = String.format("%s:%s:%s:%s:%d:%s:%s:%d", new Object[] { localObject2, localObject1, ((k)(com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.p)this.zDK).zAg, String.valueOf(System.currentTimeMillis() / 1000L), Integer.valueOf(dWZ().bizId), dWZ().dFy, Long.valueOf(l), Integer.valueOf(i) });
        localObject2 = (k)this.zDK;
        q.a(((k)localObject2).username, ((k)localObject2).dJH, "", dWZ().zuP, dWZ().jSR, (String)localObject1, dWZ().dFy, 1084);
        this.zEb.jB("weappUserName", ((k)localObject2).username);
        this.zEb.jB("weappPath", ((k)localObject2).dJH);
        AppMethodBeat.o(197978);
        return;
        if (((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.p)localObject1).subType == 9)
        {
          localObject1 = (com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.h)localObject1;
          localObject2 = new Intent();
          ((Intent)localObject2).putExtra("map_view_type", 1);
          ((Intent)localObject2).putExtra("kwebmap_slat", ((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.h)localObject1).zyE.uZr);
          ((Intent)localObject2).putExtra("kwebmap_lng", ((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.h)localObject1).zyE.uZs);
          ((Intent)localObject2).putExtra("kwebmap_scale", ((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.h)localObject1).zyE.dyB);
          ((Intent)localObject2).putExtra("kPoiName", ((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.h)localObject1).zyE.dDq);
          ((Intent)localObject2).putExtra("Kwebmap_locaion", ((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.h)localObject1).zyE.uZu);
          ad.i("MicroMsg.Sns.AdLandingPageBtnComponent", "locatint to slat " + ((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.h)localObject1).zyE.uZr + ", slong " + ((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.h)localObject1).zyE.uZs + ", " + ((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.h)localObject1).zyE.dDq);
          com.tencent.mm.bs.d.b(this.context, "location", ".ui.RedirectUI", (Intent)localObject2, 2);
          AppMethodBeat.o(197978);
          return;
        }
        if (((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.p)localObject1).subType == 10)
        {
          if (com.tencent.mm.pluginsdk.ui.span.d.a.Fhe == null)
          {
            AppMethodBeat.o(197978);
            return;
          }
          localObject1 = (com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.j)localObject1;
          if (((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.j)localObject1).zyx.size() > 1)
          {
            com.tencent.mm.pluginsdk.ui.span.d.a.Fhe.a(this.context, ((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.j)localObject1).zyx, new e.b()
            {
              public final void onDismiss()
              {
                AppMethodBeat.i(96490);
                am.gl(p.this.context);
                AppMethodBeat.o(96490);
              }
            });
            this.zEb.jB("phonenumber", (String)((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.j)localObject1).zyx.get(0));
            AppMethodBeat.o(197978);
            return;
          }
          if (((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.j)localObject1).zyx.size() > 0)
          {
            AdLandingPagesProxy.getInstance().confirmDialPhoneNum((Activity)this.context, (String)((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.j)localObject1).zyx.get(0));
            this.zEb.jB("phonenumber", (String)((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.j)localObject1).zyx.get(0));
          }
          AppMethodBeat.o(197978);
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
            localObject4 = ((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.p)localObject1).zzI;
            str1 = ((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.p)localObject1).zzF;
            str2 = ((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.p)localObject1).zzG;
            str3 = ((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.p)localObject1).zzH;
            if (((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.p)localObject1).zzD != 1) {
              break label1018;
            }
            bool1 = true;
            if (((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.p)localObject1).zzE != 1) {
              break label1024;
            }
            bool2 = true;
            if (((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.p)this.zDK).zzC != 1) {
              break label1030;
            }
          }
          for (boolean bool3 = true;; bool3 = false)
          {
            ((SnsAdNativeLandingPagesUI)localObject2).a((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.x)localObject4, str1, str2, str3, bool1, bool2, bool3);
            AppMethodBeat.o(197978);
            return;
            label1018:
            bool1 = false;
            break;
            bool2 = false;
            break label975;
          }
        }
        Object localObject3;
        if (((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.p)localObject1).subType == 12)
        {
          localObject1 = (m)localObject1;
          ad.i("MicroMsg.Sns.AdLandingPageBtnComponent", "openServiceChat:".concat(String.valueOf(localObject1)));
          try
          {
            if (TextUtils.isEmpty(((m)localObject1).kJY)) {
              a((m)localObject1, "");
            }
            for (;;)
            {
              this.zEb.jB("weappid", ((m)localObject1).zyL);
              this.zEb.jB("weappUserName", ((m)localObject1).pLS);
              this.zEb.jB("businessId", ((m)localObject1).kJY);
              AppMethodBeat.o(197978);
              return;
              if (!TextUtils.isEmpty(((m)localObject1).pLS))
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
              ad.e("MicroMsg.Sns.AdLandingPageBtnComponent", "openServiceChat exp:" + localException.toString());
              continue;
              localObject3 = new b.a();
              ((b.a)localObject3).hNM = new biu();
              ((b.a)localObject3).hNN = new biv();
              ((b.a)localObject3).uri = "/cgi-bin/mmbiz-bin/wxausrevent/getsubbusinessinfo";
              ((b.a)localObject3).funcId = 1303;
              ((b.a)localObject3).hNO = 0;
              ((b.a)localObject3).respCmdId = 0;
              localObject3 = ((b.a)localObject3).aDC();
              localObject4 = (biu)((com.tencent.mm.al.b)localObject3).hNK.hNQ;
              ((biu)localObject4).username = ((m)localObject1).pLS;
              ((biu)localObject4).GDr = ((m)localObject1).kJY;
              IPCRunCgi.a((com.tencent.mm.al.b)localObject3, new IPCRunCgi.a()
              {
                public final void a(int paramAnonymousInt1, int paramAnonymousInt2, final String paramAnonymousString, com.tencent.mm.al.b paramAnonymousb)
                {
                  AppMethodBeat.i(96493);
                  if ((paramAnonymousInt1 != 0) || (paramAnonymousInt2 != 0) || (paramAnonymousb.hNL.hNQ == null))
                  {
                    ad.e("MicroMsg.Sns.AdLandingPageBtnComponent", "getsubbusinessinfo cgi failed, errType = %d, errCode = %d, errMsg = %s, rr.resp = %s", new Object[] { Integer.valueOf(paramAnonymousInt1), Integer.valueOf(paramAnonymousInt2), paramAnonymousString, paramAnonymousb.hNL.hNQ });
                    aq.f(new Runnable()
                    {
                      public final void run()
                      {
                        AppMethodBeat.i(96491);
                        t.makeText(p.this.context, 2131763758, 0).show();
                        AppMethodBeat.o(96491);
                      }
                    });
                    AppMethodBeat.o(96493);
                    return;
                  }
                  paramAnonymousString = (biv)paramAnonymousb.hNL.hNQ;
                  ad.i("MicroMsg.Sns.AdLandingPageBtnComponent", "getsubbusinessinfo cgi success, subBusinessUsername:%s", new Object[] { paramAnonymousString.GDs });
                  aq.f(new Runnable()
                  {
                    public final void run()
                    {
                      AppMethodBeat.i(96492);
                      p.this.a(p.6.this.zEh, paramAnonymousString.GDs);
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
          localObject3 = (aa)localObject1;
          if (((aa)localObject3).zAu != null)
          {
            localObject1 = dWZ().zAP;
            if (TextUtils.isEmpty((CharSequence)localObject1))
            {
              localObject1 = dWZ().dFy;
              ad.i("MicroMsg.Sns.AdLandingPageBtnComponent", "jumpScanUI, use old uxInfo=".concat(String.valueOf(localObject1)));
            }
            for (;;)
            {
              com.tencent.mm.plugin.sns.ad.b.b.a(this.context, ((aa)localObject3).zAu, (String)localObject1);
              AppMethodBeat.o(197978);
              return;
              ad.i("MicroMsg.Sns.AdLandingPageBtnComponent", "jumpScanUI, use new uxInfo=".concat(String.valueOf(localObject1)));
            }
          }
          ad.e("MicroMsg.Sns.AdLandingPageBtnComponent", "scanJumpInfo == null");
          AppMethodBeat.o(197978);
          return;
        }
        localObject1 = ((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.p)localObject1).zyT;
        this.zEb.jB("btnJumpUrl", (String)localObject1);
        com.tencent.mm.plugin.sns.data.j.a(this.context, (String)localObject1, dWZ(), i, l, ((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.p)this.zDK).zAg);
        AppMethodBeat.o(197978);
        return;
      }
      label1024:
      label1030:
      i = 0;
    }
  }
  
  protected final com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.p dXf()
  {
    return (com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.p)this.zDK;
  }
  
  protected void dXg()
  {
    AppMethodBeat.i(96497);
    try
    {
      dWN();
      dXe();
      AppMethodBeat.o(96497);
      return;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        ad.e("MicroMsg.Sns.AdLandingPageBtnComponent", "onBtnClick exp=" + localException.toString());
      }
    }
  }
  
  protected final int getLayout()
  {
    return 2131495498;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.p
 * JD-Core Version:    0.7.0.1
 */