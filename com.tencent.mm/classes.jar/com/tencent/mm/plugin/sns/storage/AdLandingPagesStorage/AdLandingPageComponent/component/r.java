package com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component;

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
import com.tencent.mm.am.c.a;
import com.tencent.mm.am.c.b;
import com.tencent.mm.am.c.c;
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.ipcinvoker.wx_extension.IPCRunCgi;
import com.tencent.mm.ipcinvoker.wx_extension.IPCRunCgi.a;
import com.tencent.mm.plugin.appbrand.config.WxaExposedParams.a;
import com.tencent.mm.plugin.sns.ad.d.s;
import com.tencent.mm.plugin.sns.b.a;
import com.tencent.mm.plugin.sns.b.f;
import com.tencent.mm.plugin.sns.b.g;
import com.tencent.mm.plugin.sns.b.j;
import com.tencent.mm.plugin.sns.data.m;
import com.tencent.mm.plugin.sns.data.t;
import com.tencent.mm.plugin.sns.model.AdLandingPagesProxy;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageChattingTask;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.ad;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.b.h.a;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.i;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.i.a;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.l;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.o;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.g.a;
import com.tencent.mm.plugin.sns.ui.SnsAdNativeLandingPagesUI;
import com.tencent.mm.pluginsdk.ui.span.e;
import com.tencent.mm.pluginsdk.ui.span.e.a;
import com.tencent.mm.protocal.protobuf.csz;
import com.tencent.mm.protocal.protobuf.cta;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.sdk.platformtools.NetStatusUtil;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.MMActivity.a;
import com.tencent.mm.ui.widget.RoundedCornerFrameLayout;
import com.tencent.mm.ui.widget.a.f.b;
import java.util.List;
import org.json.JSONObject;

public class r
  extends q
{
  protected RoundedCornerFrameLayout QPm;
  public Button QPn;
  View QPo;
  public boolean QPp;
  public boolean QPq;
  
  public r(Context paramContext, com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.r paramr, ViewGroup paramViewGroup)
  {
    super(paramContext, paramr, paramViewGroup);
  }
  
  private void b(Button paramButton)
  {
    AppMethodBeat.i(307186);
    paramButton.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(96489);
        b localb = new b();
        localb.cH(paramAnonymousView);
        a.c("com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/component/AdLandingPageBtnComponent$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aYj());
        r.this.hjr();
        r.this.hiZ();
        a.a(this, "com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/component/AdLandingPageBtnComponent$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(96489);
      }
    });
    AppMethodBeat.o(307186);
  }
  
  public void Gs()
  {
    AppMethodBeat.i(96498);
    View localView = this.contentView;
    this.QPm = ((RoundedCornerFrameLayout)localView.findViewById(b.f.sns_ad_native_landing_pages_item_btn_relative));
    this.QPn = ((Button)localView.findViewById(b.f.sns_ad_native_landing_pages_item_btn_btn));
    this.QPo = localView.findViewById(b.f.sns_ad_native_landing_pages_item_gray_cover);
    AppMethodBeat.o(96498);
  }
  
  final void a(final o paramo, String paramString)
  {
    AppMethodBeat.i(96499);
    try
    {
      final AdLandingPageChattingTask localAdLandingPageChattingTask = new AdLandingPageChattingTask();
      Object localObject2 = paramo.xVm;
      Object localObject1 = localObject2;
      if (localObject2 == null) {
        localObject1 = "";
      }
      final WxaExposedParams.a locala = new WxaExposedParams.a();
      locala.appId = paramo.QJJ;
      locala.username = ((String)localObject1);
      locala.nickname = "";
      locala.iconUrl = "";
      locala.qHO = 0;
      locala.pkgVersion = 0;
      locala.rcM = "";
      locala.from = 14;
      locala.hUf = "";
      locala.rcN = "";
      localObject2 = paramString;
      if (TextUtils.isEmpty(paramString)) {
        localObject2 = localObject1;
      }
      localAdLandingPageChattingTask.username = ((String)localObject2);
      localAdLandingPageChattingTask.nickname = "";
      localAdLandingPageChattingTask.rSr = paramo.rSr;
      localAdLandingPageChattingTask.rxj = new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(96495);
          localIntent = new Intent();
          localIntent.setFlags(67108864);
          localIntent.putExtra("Chat_User", localAdLandingPageChattingTask.username);
          localIntent.putExtra("app_brand_chatting_from_scene", 3);
          localIntent.putExtra("app_brand_chatting_expose_params", locala.cll());
          localIntent.putExtra("key_temp_session_from", localAdLandingPageChattingTask.rSr);
          localIntent.putExtra("finish_direct", true);
          localObject1 = com.tencent.mm.plugin.appbrand.config.g.qWE;
          if (!com.tencent.mm.plugin.appbrand.config.g.ckz()) {
            localIntent.putExtra("key_need_send_video", false);
          }
          localIntent.putExtra("app_brand_chatting_from_scene_new", 4);
          try
          {
            if (paramo.QJK != 1) {
              break label297;
            }
            i = 1;
          }
          finally
          {
            try
            {
              for (;;)
              {
                String str2;
                localObject1 = new JSONObject();
                ((JSONObject)localObject1).put("uxInfo", r.this.hjn().uxInfo);
                localObject1 = ((JSONObject)localObject1).toString();
                localIntent.putExtra("sns_landing_pages_ux_info", (String)localObject1);
                Object localObject3 = (MMActivity)r.this.context;
                ((MMActivity)localObject3).mmSetOnActivityResultCallback(new MMActivity.a()
                {
                  public final void mmOnActivityResult(int paramAnonymous2Int1, int paramAnonymous2Int2, Intent paramAnonymous2Intent)
                  {
                    AppMethodBeat.i(96494);
                    if (paramAnonymous2Int1 == 1) {
                      r.7.this.QPu.cpx();
                    }
                    AppMethodBeat.o(96494);
                  }
                });
                Log.i("MicroMsg.Sns.AdLandingPageBtnComponent", "open ServiceChattingUI， uxInfo=".concat(String.valueOf(localObject1)));
                com.tencent.mm.br.c.d((Context)localObject3, ".ui.chatting.AppBrandServiceChattingUI", localIntent, 1);
                AppMethodBeat.o(96495);
                return;
                int i = 0;
                continue;
                localIntent.putExtra("showMessageCard", false);
                continue;
                localObject2 = finally;
                localIntent.putExtra("showMessageCard", false);
                Log.e("MicroMsg.Sns.AdLandingPageBtnComponent", localObject2.toString());
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
          localObject1 = paramo.rSy;
          localObject3 = paramo.rSz;
          str2 = paramo.rSA;
          if (i != 0) {
            if (!Util.isNullOrNil(new String[] { localObject1, str2, localObject3 }))
            {
              localIntent.putExtra("showMessageCard", true);
              localIntent.putExtra("sendMessageTitle", (String)localObject1);
              localIntent.putExtra("sendMessagePath", (String)localObject3);
              localIntent.putExtra("sendMessageImg", str2);
            }
          }
        }
      };
      localAdLandingPageChattingTask.bQt();
      AppMethodBeat.o(96499);
      return;
    }
    catch (Exception paramo)
    {
      Log.e("MicroMsg.Sns.AdLandingPageBtnComponent", "doEnterChatting exp:" + paramo.toString());
      AppMethodBeat.o(96499);
    }
  }
  
  protected final int getLayout()
  {
    return b.g.sns_ad_native_landing_pages_item_btn;
  }
  
  protected void hac()
  {
    AppMethodBeat.i(307223);
    Object localObject1 = (com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.r)this.QOV;
    long l = 0L;
    int i;
    if ((this.context instanceof Activity))
    {
      l = com.tencent.mm.plugin.sns.storage.ai.aXe(((Activity)this.context).getIntent().getStringExtra("sns_landing_pages_share_sns_id"));
      i = ((Activity)this.context).getIntent().getIntExtra("sns_landig_pages_from_source", 0);
      ((Activity)this.context).getIntent().getIntExtra("sns_landing_pages_adType", 0);
    }
    for (;;)
    {
      Object localObject2;
      if (((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.r)localObject1).subType == 4)
      {
        localObject1 = (com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.g)localObject1;
        localObject2 = new Intent();
        ((Intent)localObject2).putExtra("key_card_id", ((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.g)localObject1).wtm);
        if (!Util.isNullOrNil(hjn().aZs(((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.g)localObject1).wtm))) {
          ((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.g)localObject1).wui = hjn().aZs(((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.g)localObject1).wtm);
        }
        ((Intent)localObject2).putExtra("key_card_ext", ((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.g)localObject1).wui);
        ((Intent)localObject2).putExtra("key_from_scene", 21);
        ((Intent)localObject2).putExtra("key_stastic_scene", 15);
        com.tencent.mm.br.c.b(this.context, "card", ".ui.CardDetailUI", (Intent)localObject2);
        hjt();
        this.QPl.mx("cardTpId", ((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.g)localObject1).wtm);
        this.QPl.mx("cardExt", ((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.g)localObject1).wui);
        AppMethodBeat.o(307223);
        return;
      }
      if (((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.r)localObject1).subType == 8) {
        if (((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.r)this.QOV instanceof l))
        {
          localObject2 = "";
          if ((!(this.context instanceof Activity)) || (hjn().bizId != 2)) {
            break label1533;
          }
          localObject2 = ((Activity)this.context).getIntent().getStringExtra("sns_landing_pages_sessionId");
        }
      }
      label1001:
      label1533:
      for (localObject1 = ((Activity)this.context).getIntent().getStringExtra("sns_landing_pages_ad_buffer");; localObject1 = "")
      {
        localObject1 = String.format("%s:%s:%s:%s:%d:%s:%s:%d", new Object[] { localObject2, localObject1, ((l)(com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.r)this.QOV).QKG, String.valueOf(System.currentTimeMillis() / 1000L), Integer.valueOf(hjn().bizId), hjn().uxInfo, Long.valueOf(l), Integer.valueOf(i) });
        localObject2 = (l)this.QOV;
        boolean bool1 = AdLandingPagesProxy.getInstance().isWeAppAppendClickTime(hjn().getSnsId(), i);
        ((l)localObject2).icO = m.cW(((l)localObject2).icO, bool1);
        t.a(((l)localObject2).username, ((l)localObject2).icO, "", hjn().aid, hjn().qTb, (String)localObject1, hjn().uxInfo, 1084);
        this.QPl.mx("weappUserName", ((l)localObject2).username);
        this.QPl.mx("weappPath", ((l)localObject2).icO);
        AppMethodBeat.o(307223);
        return;
        if (((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.r)localObject1).subType == 9)
        {
          localObject1 = (i)localObject1;
          localObject2 = new Intent();
          ((Intent)localObject2).putExtra("map_view_type", 1);
          ((Intent)localObject2).putExtra("kwebmap_slat", ((i)localObject1).QJB.KbW);
          ((Intent)localObject2).putExtra("kwebmap_lng", ((i)localObject1).QJB.KbX);
          ((Intent)localObject2).putExtra("kwebmap_scale", ((i)localObject1).QJB.hQp);
          ((Intent)localObject2).putExtra("kPoiName", ((i)localObject1).QJB.hVI);
          ((Intent)localObject2).putExtra("Kwebmap_locaion", ((i)localObject1).QJB.KbZ);
          Log.i("MicroMsg.Sns.AdLandingPageBtnComponent", "locatint to slat " + ((i)localObject1).QJB.KbW + ", slong " + ((i)localObject1).QJB.KbX + ", " + ((i)localObject1).QJB.hVI);
          com.tencent.mm.br.c.b(this.context, "location", ".ui.RedirectUI", (Intent)localObject2, 2002);
          AppMethodBeat.o(307223);
          return;
        }
        if (((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.r)localObject1).subType == 10)
        {
          if (e.a.YnZ == null)
          {
            AppMethodBeat.o(307223);
            return;
          }
          localObject1 = (com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.k)localObject1;
          if (((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.k)localObject1).QJl.size() > 1)
          {
            e.a.YnZ.a(this.context, ((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.k)localObject1).QJl, new f.b()
            {
              public final void onDismiss()
              {
                AppMethodBeat.i(96490);
                ar.jS(r.this.context);
                AppMethodBeat.o(96490);
              }
            });
            this.QPl.mx("phonenumber", (String)((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.k)localObject1).QJl.get(0));
            AppMethodBeat.o(307223);
            return;
          }
          if (((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.k)localObject1).QJl.size() > 0)
          {
            AdLandingPagesProxy.getInstance().confirmDialPhoneNum((Activity)this.context, (String)((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.k)localObject1).QJl.get(0));
            this.QPl.mx("phonenumber", (String)((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.k)localObject1).QJl.get(0));
          }
          AppMethodBeat.o(307223);
          return;
        }
        Object localObject4;
        if (((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.r)localObject1).subType == 11)
        {
          String str1;
          String str2;
          String str3;
          boolean bool2;
          if ((this.context instanceof SnsAdNativeLandingPagesUI))
          {
            localObject2 = (SnsAdNativeLandingPagesUI)this.context;
            localObject4 = ((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.r)localObject1).QKe;
            str1 = ((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.r)localObject1).QKb;
            str2 = ((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.r)localObject1).QKc;
            str3 = ((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.r)localObject1).QKd;
            if (((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.r)localObject1).QJZ != 1) {
              break label1043;
            }
            bool1 = true;
            if (((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.r)localObject1).QKa != 1) {
              break label1049;
            }
            bool2 = true;
            if (((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.r)this.QOV).QJY != 1) {
              break label1055;
            }
          }
          for (boolean bool3 = true;; bool3 = false)
          {
            ((SnsAdNativeLandingPagesUI)localObject2).a((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.aa)localObject4, str1, str2, str3, bool1, bool2, bool3);
            AppMethodBeat.o(307223);
            return;
            bool1 = false;
            break;
            bool2 = false;
            break label1001;
          }
        }
        Object localObject3;
        if (((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.r)localObject1).subType == 12)
        {
          localObject1 = (o)localObject1;
          Log.i("MicroMsg.Sns.AdLandingPageBtnComponent", "openServiceChat:".concat(String.valueOf(localObject1)));
          try
          {
            if (TextUtils.isEmpty(((o)localObject1).businessId)) {
              a((o)localObject1, "");
            }
            for (;;)
            {
              this.QPl.mx("weappid", ((o)localObject1).QJJ);
              this.QPl.mx("weappUserName", ((o)localObject1).xVm);
              this.QPl.mx("businessId", ((o)localObject1).businessId);
              AppMethodBeat.o(307223);
              return;
              if (!TextUtils.isEmpty(((o)localObject1).xVm))
              {
                if (NetStatusUtil.isNetworkConnected(this.context)) {
                  break;
                }
                com.tencent.mm.ui.base.aa.makeText(this.context, b.j.sns_ad_open_service_chat_failed, 0).show();
              }
            }
          }
          catch (Exception localException)
          {
            for (;;)
            {
              Log.e("MicroMsg.Sns.AdLandingPageBtnComponent", "openServiceChat exp:" + localException.toString());
              continue;
              localObject3 = new c.a();
              ((c.a)localObject3).otE = new csz();
              ((c.a)localObject3).otF = new cta();
              ((c.a)localObject3).uri = "/cgi-bin/mmbiz-bin/wxausrevent/getsubbusinessinfo";
              ((c.a)localObject3).funcId = 1303;
              ((c.a)localObject3).otG = 0;
              ((c.a)localObject3).respCmdId = 0;
              localObject3 = ((c.a)localObject3).bEF();
              localObject4 = (csz)c.b.b(((com.tencent.mm.am.c)localObject3).otB);
              ((csz)localObject4).username = ((o)localObject1).xVm;
              ((csz)localObject4).aayQ = ((o)localObject1).businessId;
              IPCRunCgi.a((com.tencent.mm.am.c)localObject3, new IPCRunCgi.a()
              {
                public final void callback(int paramAnonymousInt1, int paramAnonymousInt2, final String paramAnonymousString, com.tencent.mm.am.c paramAnonymousc)
                {
                  AppMethodBeat.i(96493);
                  if ((paramAnonymousInt1 != 0) || (paramAnonymousInt2 != 0) || (c.c.b(paramAnonymousc.otC) == null))
                  {
                    Log.e("MicroMsg.Sns.AdLandingPageBtnComponent", "getsubbusinessinfo cgi failed, errType = %d, errCode = %d, errMsg = %s, rr.resp = %s", new Object[] { Integer.valueOf(paramAnonymousInt1), Integer.valueOf(paramAnonymousInt2), paramAnonymousString, c.c.b(paramAnonymousc.otC) });
                    MMHandlerThread.postToMainThread(new Runnable()
                    {
                      public final void run()
                      {
                        AppMethodBeat.i(96491);
                        com.tencent.mm.ui.base.aa.makeText(r.this.context, b.j.sns_ad_open_service_chat_failed, 0).show();
                        AppMethodBeat.o(96491);
                      }
                    });
                    AppMethodBeat.o(96493);
                    return;
                  }
                  paramAnonymousString = (cta)c.c.b(paramAnonymousc.otC);
                  Log.i("MicroMsg.Sns.AdLandingPageBtnComponent", "getsubbusinessinfo cgi success, subBusinessUsername:%s", new Object[] { paramAnonymousString.aayR });
                  MMHandlerThread.postToMainThread(new Runnable()
                  {
                    public final void run()
                    {
                      AppMethodBeat.i(96492);
                      r.this.a(r.6.this.QPs, paramAnonymousString.aayR);
                      AppMethodBeat.o(96492);
                    }
                  });
                  AppMethodBeat.o(96493);
                }
              });
            }
          }
        }
        if (((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.r)localObject1).subType == 16)
        {
          localObject3 = (ad)localObject1;
          if (((ad)localObject3).QLa != null)
          {
            localObject1 = hjn().hiC();
            if (TextUtils.isEmpty((CharSequence)localObject1))
            {
              localObject1 = hjn().uxInfo;
              Log.i("MicroMsg.Sns.AdLandingPageBtnComponent", "jumpScanUI, use old uxInfo=".concat(String.valueOf(localObject1)));
            }
            for (;;)
            {
              s.a(this.context, ((ad)localObject3).QLa, (String)localObject1, 8);
              AppMethodBeat.o(307223);
              return;
              Log.i("MicroMsg.Sns.AdLandingPageBtnComponent", "jumpScanUI, use new uxInfo=".concat(String.valueOf(localObject1)));
            }
          }
          Log.e("MicroMsg.Sns.AdLandingPageBtnComponent", "scanJumpInfo == null");
          AppMethodBeat.o(307223);
          return;
        }
        localObject1 = ((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.r)localObject1).QJP;
        this.QPl.mx("btnJumpUrl", (String)localObject1);
        m.a(this.context, (String)localObject1, hjn(), i, l, ((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.r)this.QOV).QKG);
        hjt();
        AppMethodBeat.o(307223);
        return;
      }
      label1043:
      label1049:
      label1055:
      i = 0;
    }
  }
  
  protected void had()
  {
    AppMethodBeat.i(96496);
    this.clickCount = 0;
    hjs();
    AppMethodBeat.o(96496);
  }
  
  protected void hiZ()
  {
    AppMethodBeat.i(96497);
    try
    {
      hac();
      hja();
      AppMethodBeat.o(96497);
      return;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        Log.e("MicroMsg.Sns.AdLandingPageBtnComponent", "doBtnClick exp=" + localException.toString());
      }
    }
  }
  
  protected final void hjs()
  {
    AppMethodBeat.i(307203);
    int i = this.sJv;
    int k = i;
    int j;
    if (((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.r)this.QOV).QKI > 0.0F)
    {
      k = i;
      if (((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.r)this.QOV).QKI <= i)
      {
        i = (int)((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.r)this.QOV).QKI;
        j = (int)((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.r)this.QOV).paddingLeft;
        k = (int)((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.r)this.QOV).paddingRight + (i + j);
      }
    }
    this.QPm.setBackgroundColor(this.backgroundColor);
    if (!Util.isNullOrNil(((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.r)this.QOV).QJW))
    {
      com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.k.b("adId", ((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.r)this.QOV).QJW, new g.a()
      {
        public final void aWn(String paramAnonymousString)
        {
          AppMethodBeat.i(96486);
          try
          {
            Log.i("MicroMsg.Sns.AdLandingPageBtnComponent", "onDownloaded, path=".concat(String.valueOf(paramAnonymousString)));
            paramAnonymousString = com.tencent.mm.plugin.sns.ad.j.c.a(r.this.QPn.getResources(), paramAnonymousString);
            r.this.QPn.setBackground(paramAnonymousString);
            if ((paramAnonymousString != null) && (((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.r)r.this.QOV).height > 0.0F) && (paramAnonymousString.getIntrinsicHeight() > 0))
            {
              float f = ((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.r)r.this.QOV).height * paramAnonymousString.getIntrinsicWidth() / paramAnonymousString.getIntrinsicHeight();
              r.this.QPn.setLayoutParams(new FrameLayout.LayoutParams((int)f, (int)((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.r)r.this.QOV).height));
            }
            AppMethodBeat.o(96486);
            return;
          }
          finally
          {
            Log.e("MicroMsg.Sns.AdLandingPageBtnComponent", "the backgroundCoverUrl is set error ,because " + paramAnonymousString.toString());
            AppMethodBeat.o(96486);
          }
        }
        
        public final void gZM() {}
        
        public final void gZN() {}
      });
      j = 0;
    }
    for (;;)
    {
      this.QPn.setText(((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.r)this.QOV).title);
      if (((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.r)this.QOV).QJT == 1)
      {
        this.QPn.setTypeface(Typeface.defaultFromStyle(1));
        label181:
        b(this.QPn);
        if (((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.r)this.QOV).fontSize > 0.0F) {
          this.QPn.setTextSize(0, ((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.r)this.QOV).fontSize);
        }
        if ((((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.r)this.QOV).QJR == null) || (((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.r)this.QOV).QJR.length() <= 0)) {}
      }
      try
      {
        i = Color.parseColor(((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.r)this.QOV).QJR);
        this.QPn.setTextColor(i);
      }
      catch (Exception localException1)
      {
        try
        {
          for (;;)
          {
            for (;;)
            {
              this.QPn.setTextAlignment(4);
              if (((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.r)this.QOV).height <= 0.0F) {
                break label772;
              }
              this.QPn.setLayoutParams(new FrameLayout.LayoutParams(k - (int)((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.r)this.QOV).paddingLeft - (int)((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.r)this.QOV).paddingRight, (int)((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.r)this.QOV).height));
              if (((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.r)this.QOV).QJX != 1) {
                break label824;
              }
              this.QPo.setLayoutParams(new FrameLayout.LayoutParams(k - (int)((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.r)this.QOV).paddingLeft - (int)((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.r)this.QOV).paddingRight, this.QPo.getLayoutParams().height));
              this.QPo.setVisibility(0);
              this.QPo.setOnLongClickListener(new View.OnLongClickListener()
              {
                public final boolean onLongClick(View paramAnonymousView)
                {
                  AppMethodBeat.i(96487);
                  Object localObject = new b();
                  ((b)localObject).cH(paramAnonymousView);
                  a.c("com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/component/AdLandingPageBtnComponent$2", "android/view/View$OnLongClickListener", "onLongClick", "(Landroid/view/View;)Z", this, ((b)localObject).aYj());
                  paramAnonymousView = r.this;
                  com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.aa localaa;
                  String str1;
                  String str2;
                  String str3;
                  boolean bool1;
                  boolean bool2;
                  if ((paramAnonymousView.context instanceof SnsAdNativeLandingPagesUI))
                  {
                    localObject = (SnsAdNativeLandingPagesUI)paramAnonymousView.context;
                    localaa = ((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.r)paramAnonymousView.QOV).QKe;
                    str1 = ((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.r)paramAnonymousView.QOV).QKb;
                    str2 = ((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.r)paramAnonymousView.QOV).QKc;
                    str3 = ((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.r)paramAnonymousView.QOV).QKd;
                    if (((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.r)paramAnonymousView.QOV).QJZ != 1) {
                      break label203;
                    }
                    bool1 = true;
                    if (((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.r)paramAnonymousView.QOV).QKa != 1) {
                      break label208;
                    }
                    bool2 = true;
                    label141:
                    if (((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.r)paramAnonymousView.QOV).QJY != 1) {
                      break label213;
                    }
                  }
                  label203:
                  label208:
                  label213:
                  for (boolean bool3 = true;; bool3 = false)
                  {
                    ((SnsAdNativeLandingPagesUI)localObject).a(localaa, str1, str2, str3, bool1, bool2, bool3);
                    paramAnonymousView.QPo.setPressed(false);
                    a.a(true, this, "com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/component/AdLandingPageBtnComponent$2", "android/view/View$OnLongClickListener", "onLongClick", "(Landroid/view/View;)Z");
                    AppMethodBeat.o(96487);
                    return true;
                    bool1 = false;
                    break;
                    bool2 = false;
                    break label141;
                  }
                }
              });
              this.QPo.setOnClickListener(new View.OnClickListener()
              {
                public final void onClick(View paramAnonymousView)
                {
                  AppMethodBeat.i(96488);
                  b localb = new b();
                  localb.cH(paramAnonymousView);
                  a.c("com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/component/AdLandingPageBtnComponent$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aYj());
                  r.this.hjr();
                  r.this.hiZ();
                  a.a(this, "com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/component/AdLandingPageBtnComponent$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                  AppMethodBeat.o(96488);
                }
              });
              if (j == 0) {
                this.QPm.setRadius(((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.r)this.QOV).dwJ);
              }
              com.tencent.mm.plugin.sns.ad.d.k.a(this.context, (com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.r)this.QOV, this.QPn);
              AppMethodBeat.o(307203);
              return;
              GradientDrawable localGradientDrawable = new GradientDrawable();
              localGradientDrawable.setShape(0);
              if ((Util.isNullOrNil(((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.r)this.QOV).QJV)) || (((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.r)this.QOV).QJS <= 0.0F)) {
                break label836;
              }
              try
              {
                i = Color.parseColor(((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.r)this.QOV).QJV);
                localGradientDrawable.setStroke((int)((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.r)this.QOV).QJS, i);
                if (((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.r)this.QOV).dwJ > 0.0F) {
                  localGradientDrawable.setCornerRadius(((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.r)this.QOV).dwJ);
                }
                j = 1;
                i = 1;
                m = j;
                if (Util.isNullOrNil(((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.r)this.QOV).PSc)) {}
              }
              catch (Exception localException3)
              {
                try
                {
                  j = Color.parseColor(((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.r)this.QOV).PSc);
                  localGradientDrawable.setColor(j);
                  int m = 1;
                  j = i;
                  if (m == 0) {
                    break;
                  }
                  this.QPn.setBackgroundDrawable(localGradientDrawable);
                  j = i;
                  break;
                  localException3 = localException3;
                  Log.e("MicroMsg.Sns.AdLandingPageBtnComponent", Util.stackTraceToString(localException3));
                  i = 0;
                }
                catch (Exception localException4)
                {
                  for (;;)
                  {
                    Log.e("MicroMsg.Sns.AdLandingPageBtnComponent", Util.stackTraceToString(localException4));
                    j = 0;
                  }
                }
              }
            }
            if (((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.r)this.QOV).QJT != 2) {
              break label181;
            }
            this.QPn.setTypeface(Typeface.defaultFromStyle(2));
            break label181;
            localException1 = localException1;
            Log.e("MicroMsg.Sns.AdLandingPageBtnComponent", "invalid color! %s", new Object[] { ((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.r)this.QOV).QJR });
          }
        }
        catch (Exception localException2)
        {
          for (;;)
          {
            Log.e("MicroMsg.Sns.AdLandingPageBtnComponent", "the device has no method btn.setTextAlignment");
            continue;
            label772:
            this.QPn.setLayoutParams(new FrameLayout.LayoutParams(k - (int)((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.r)this.QOV).paddingLeft - (int)((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.r)this.QOV).paddingRight, this.QPn.getLayoutParams().height));
            continue;
            label824:
            this.QPo.setVisibility(8);
            continue;
            label836:
            j = 0;
            i = 0;
          }
        }
      }
    }
  }
  
  protected final void hjt()
  {
    AppMethodBeat.i(307241);
    if ((this.QPq) && ((this.context instanceof Activity))) {
      ((Activity)this.context).overridePendingTransition(b.a.push_up_in, b.a.anim_not_change);
    }
    AppMethodBeat.o(307241);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.r
 * JD-Core Version:    0.7.0.1
 */