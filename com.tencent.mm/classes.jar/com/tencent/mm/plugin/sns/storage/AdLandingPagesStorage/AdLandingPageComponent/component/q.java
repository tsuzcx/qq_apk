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
import com.tencent.mm.an.d;
import com.tencent.mm.an.d.a;
import com.tencent.mm.an.d.b;
import com.tencent.mm.an.d.c;
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.ipcinvoker.wx_extension.IPCRunCgi;
import com.tencent.mm.ipcinvoker.wx_extension.IPCRunCgi.a;
import com.tencent.mm.plugin.appbrand.config.WxaExposedParams.a;
import com.tencent.mm.plugin.sns.data.m;
import com.tencent.mm.plugin.sns.data.t;
import com.tencent.mm.plugin.sns.i.f;
import com.tencent.mm.plugin.sns.i.g;
import com.tencent.mm.plugin.sns.i.j;
import com.tencent.mm.plugin.sns.model.AdLandingPagesProxy;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageChattingTask;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.a.g.a;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.aa;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.ad;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.ai;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.g;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.k;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.l;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.r;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.f.a;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.h;
import com.tencent.mm.plugin.sns.storage.y;
import com.tencent.mm.plugin.sns.ui.SnsAdNativeLandingPagesUI;
import com.tencent.mm.pluginsdk.ui.span.e;
import com.tencent.mm.pluginsdk.ui.span.e.a;
import com.tencent.mm.protocal.protobuf.cdj;
import com.tencent.mm.protocal.protobuf.cdk;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.sdk.platformtools.NetStatusUtil;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.MMActivity.a;
import com.tencent.mm.ui.base.w;
import com.tencent.mm.ui.widget.RoundedCornerFrameLayout;
import com.tencent.mm.ui.widget.a.e.b;
import java.util.List;
import org.json.JSONObject;

public class q
  extends p
{
  protected RoundedCornerFrameLayout KqR;
  public Button KqS;
  View KqT;
  public boolean KqU;
  public boolean KqV;
  
  public q(Context paramContext, r paramr, ViewGroup paramViewGroup)
  {
    super(paramContext, paramr, paramViewGroup);
  }
  
  final void a(final com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.o paramo, String paramString)
  {
    AppMethodBeat.i(96499);
    try
    {
      final AdLandingPageChattingTask localAdLandingPageChattingTask = new AdLandingPageChattingTask();
      Object localObject2 = paramo.uMJ;
      Object localObject1 = localObject2;
      if (localObject2 == null) {
        localObject1 = "";
      }
      final WxaExposedParams.a locala = new WxaExposedParams.a();
      locala.appId = paramo.KlC;
      locala.username = ((String)localObject1);
      locala.nickname = "";
      locala.iconUrl = "";
      locala.nHY = 0;
      locala.pkgVersion = 0;
      locala.obW = "";
      locala.from = 14;
      locala.pageId = "";
      locala.obX = "";
      localObject2 = paramString;
      if (TextUtils.isEmpty(paramString)) {
        localObject2 = localObject1;
      }
      localAdLandingPageChattingTask.username = ((String)localObject2);
      localAdLandingPageChattingTask.nickname = "";
      localAdLandingPageChattingTask.oOB = paramo.oOB;
      localAdLandingPageChattingTask.otv = new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(96495);
          localIntent = new Intent();
          localIntent.setFlags(67108864);
          localIntent.putExtra("Chat_User", localAdLandingPageChattingTask.username);
          localIntent.putExtra("app_brand_chatting_from_scene", 3);
          localIntent.putExtra("app_brand_chatting_expose_params", locala.bLN());
          localIntent.putExtra("key_temp_session_from", localAdLandingPageChattingTask.oOB);
          localIntent.putExtra("finish_direct", true);
          localIntent.putExtra("key_need_send_video", false);
          localIntent.putExtra("app_brand_chatting_from_scene_new", 4);
          try
          {
            if (paramo.KlD != 1) {
              break label287;
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
                ((JSONObject)localObject1).put("uxInfo", q.this.fRp().uxInfo);
                localObject1 = ((JSONObject)localObject1).toString();
                localIntent.putExtra("sns_landing_pages_ux_info", (String)localObject1);
                Object localObject2 = (MMActivity)q.this.context;
                ((MMActivity)localObject2).mmSetOnActivityResultCallback(new MMActivity.a()
                {
                  public final void d(int paramAnonymous2Int1, int paramAnonymous2Int2, Intent paramAnonymous2Intent)
                  {
                    AppMethodBeat.i(96494);
                    if (paramAnonymous2Int1 == 1) {
                      q.7.this.KqZ.bPk();
                    }
                    AppMethodBeat.o(96494);
                  }
                });
                Log.i("MicroMsg.Sns.AdLandingPageBtnComponent", "open ServiceChattingUI， uxInfo=".concat(String.valueOf(localObject1)));
                com.tencent.mm.by.c.d((Context)localObject2, ".ui.chatting.AppBrandServiceChattingUI", localIntent, 1);
                AppMethodBeat.o(96495);
                return;
                int i = 0;
                continue;
                localIntent.putExtra("showMessageCard", false);
                continue;
                localThrowable = localThrowable;
                localIntent.putExtra("showMessageCard", false);
                Log.e("MicroMsg.Sns.AdLandingPageBtnComponent", localThrowable.toString());
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
          localObject1 = paramo.oOK;
          localObject2 = paramo.oOL;
          str2 = paramo.oOM;
          if (i != 0) {
            if (!Util.isNullOrNil(new String[] { localObject1, str2, localObject2 }))
            {
              localIntent.putExtra("showMessageCard", true);
              localIntent.putExtra("sendMessageTitle", (String)localObject1);
              localIntent.putExtra("sendMessagePath", (String)localObject2);
              localIntent.putExtra("sendMessageImg", str2);
            }
          }
        }
      };
      localAdLandingPageChattingTask.bsM();
      AppMethodBeat.o(96499);
      return;
    }
    catch (Exception paramo)
    {
      Log.e("MicroMsg.Sns.AdLandingPageBtnComponent", "doEnterChatting exp:" + paramo.toString());
      AppMethodBeat.o(96499);
    }
  }
  
  protected void fKd()
  {
    AppMethodBeat.i(270134);
    Object localObject1 = (r)this.KqB;
    long l = 0L;
    int i;
    if ((this.context instanceof Activity))
    {
      l = y.aYS(((Activity)this.context).getIntent().getStringExtra("sns_landing_pages_share_sns_id"));
      i = ((Activity)this.context).getIntent().getIntExtra("sns_landig_pages_from_source", 0);
      ((Activity)this.context).getIntent().getIntExtra("sns_landing_pages_adType", 0);
    }
    for (;;)
    {
      Object localObject2;
      if (((r)localObject1).subType == 4)
      {
        localObject1 = (g)localObject1;
        localObject2 = new Intent();
        ((Intent)localObject2).putExtra("key_card_id", ((g)localObject1).toN);
        if (!Util.isNullOrNil(fRp().baR(((g)localObject1).toN))) {
          ((g)localObject1).tpJ = fRp().baR(((g)localObject1).toN);
        }
        ((Intent)localObject2).putExtra("key_card_ext", ((g)localObject1).tpJ);
        ((Intent)localObject2).putExtra("key_from_scene", 21);
        ((Intent)localObject2).putExtra("key_stastic_scene", 15);
        com.tencent.mm.by.c.b(this.context, "card", ".ui.CardDetailUI", (Intent)localObject2);
        fRu();
        this.KqQ.kQ("cardTpId", ((g)localObject1).toN);
        this.KqQ.kQ("cardExt", ((g)localObject1).tpJ);
        AppMethodBeat.o(270134);
        return;
      }
      if (((r)localObject1).subType == 8) {
        if (((r)this.KqB instanceof l))
        {
          localObject2 = "";
          if ((!(this.context instanceof Activity)) || (fRp().bizId != 2)) {
            break label1494;
          }
          localObject2 = ((Activity)this.context).getIntent().getStringExtra("sns_landing_pages_sessionId");
        }
      }
      label964:
      label1494:
      for (localObject1 = ((Activity)this.context).getIntent().getStringExtra("sns_landing_pages_ad_buffer");; localObject1 = "")
      {
        localObject1 = String.format("%s:%s:%s:%s:%d:%s:%s:%d", new Object[] { localObject2, localObject1, ((l)(r)this.KqB).KmB, String.valueOf(System.currentTimeMillis() / 1000L), Integer.valueOf(fRp().bizId), fRp().uxInfo, Long.valueOf(l), Integer.valueOf(i) });
        localObject2 = (l)this.KqB;
        t.a(((l)localObject2).username, ((l)localObject2).fWP, "", fRp().aid, fRp().nTp, (String)localObject1, fRp().uxInfo, 1084);
        this.KqQ.kQ("weappUserName", ((l)localObject2).username);
        this.KqQ.kQ("weappPath", ((l)localObject2).fWP);
        AppMethodBeat.o(270134);
        return;
        if (((r)localObject1).subType == 9)
        {
          localObject1 = (com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.i)localObject1;
          localObject2 = new Intent();
          ((Intent)localObject2).putExtra("map_view_type", 1);
          ((Intent)localObject2).putExtra("kwebmap_slat", ((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.i)localObject1).Klu.Ejn);
          ((Intent)localObject2).putExtra("kwebmap_lng", ((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.i)localObject1).Klu.Ejo);
          ((Intent)localObject2).putExtra("kwebmap_scale", ((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.i)localObject1).Klu.fKJ);
          ((Intent)localObject2).putExtra("kPoiName", ((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.i)localObject1).Klu.fPN);
          ((Intent)localObject2).putExtra("Kwebmap_locaion", ((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.i)localObject1).Klu.Ejq);
          Log.i("MicroMsg.Sns.AdLandingPageBtnComponent", "locatint to slat " + ((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.i)localObject1).Klu.Ejn + ", slong " + ((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.i)localObject1).Klu.Ejo + ", " + ((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.i)localObject1).Klu.fPN);
          com.tencent.mm.by.c.b(this.context, "location", ".ui.RedirectUI", (Intent)localObject2, 2002);
          AppMethodBeat.o(270134);
          return;
        }
        if (((r)localObject1).subType == 10)
        {
          if (e.a.RrL == null)
          {
            AppMethodBeat.o(270134);
            return;
          }
          localObject1 = (k)localObject1;
          if (((k)localObject1).Kle.size() > 1)
          {
            e.a.RrL.a(this.context, ((k)localObject1).Kle, new e.b()
            {
              public final void onDismiss()
              {
                AppMethodBeat.i(96490);
                ao.ic(q.this.context);
                AppMethodBeat.o(96490);
              }
            });
            this.KqQ.kQ("phonenumber", (String)((k)localObject1).Kle.get(0));
            AppMethodBeat.o(270134);
            return;
          }
          if (((k)localObject1).Kle.size() > 0)
          {
            AdLandingPagesProxy.getInstance().confirmDialPhoneNum((Activity)this.context, (String)((k)localObject1).Kle.get(0));
            this.KqQ.kQ("phonenumber", (String)((k)localObject1).Kle.get(0));
          }
          AppMethodBeat.o(270134);
          return;
        }
        Object localObject4;
        if (((r)localObject1).subType == 11)
        {
          String str1;
          String str2;
          String str3;
          boolean bool1;
          boolean bool2;
          if ((this.context instanceof SnsAdNativeLandingPagesUI))
          {
            localObject2 = (SnsAdNativeLandingPagesUI)this.context;
            localObject4 = ((r)localObject1).Kma;
            str1 = ((r)localObject1).KlX;
            str2 = ((r)localObject1).KlY;
            str3 = ((r)localObject1).KlZ;
            if (((r)localObject1).KlV != 1) {
              break label1006;
            }
            bool1 = true;
            if (((r)localObject1).KlW != 1) {
              break label1012;
            }
            bool2 = true;
            if (((r)this.KqB).KlU != 1) {
              break label1018;
            }
          }
          label1006:
          label1012:
          label1018:
          for (boolean bool3 = true;; bool3 = false)
          {
            ((SnsAdNativeLandingPagesUI)localObject2).a((aa)localObject4, str1, str2, str3, bool1, bool2, bool3);
            AppMethodBeat.o(270134);
            return;
            bool1 = false;
            break;
            bool2 = false;
            break label964;
          }
        }
        Object localObject3;
        if (((r)localObject1).subType == 12)
        {
          localObject1 = (com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.o)localObject1;
          Log.i("MicroMsg.Sns.AdLandingPageBtnComponent", "openServiceChat:".concat(String.valueOf(localObject1)));
          try
          {
            if (TextUtils.isEmpty(((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.o)localObject1).businessId)) {
              a((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.o)localObject1, "");
            }
            for (;;)
            {
              this.KqQ.kQ("weappid", ((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.o)localObject1).KlC);
              this.KqQ.kQ("weappUserName", ((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.o)localObject1).uMJ);
              this.KqQ.kQ("businessId", ((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.o)localObject1).businessId);
              AppMethodBeat.o(270134);
              return;
              if (!TextUtils.isEmpty(((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.o)localObject1).uMJ))
              {
                if (NetStatusUtil.isNetworkConnected(this.context)) {
                  break;
                }
                w.makeText(this.context, i.j.sns_ad_open_service_chat_failed, 0).show();
              }
            }
          }
          catch (Exception localException)
          {
            for (;;)
            {
              Log.e("MicroMsg.Sns.AdLandingPageBtnComponent", "openServiceChat exp:" + localException.toString());
              continue;
              localObject3 = new d.a();
              ((d.a)localObject3).lBU = new cdj();
              ((d.a)localObject3).lBV = new cdk();
              ((d.a)localObject3).uri = "/cgi-bin/mmbiz-bin/wxausrevent/getsubbusinessinfo";
              ((d.a)localObject3).funcId = 1303;
              ((d.a)localObject3).lBW = 0;
              ((d.a)localObject3).respCmdId = 0;
              localObject3 = ((d.a)localObject3).bgN();
              localObject4 = (cdj)d.b.b(((d)localObject3).lBR);
              ((cdj)localObject4).username = ((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.o)localObject1).uMJ;
              ((cdj)localObject4).Tlg = ((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.o)localObject1).businessId;
              IPCRunCgi.a((d)localObject3, new IPCRunCgi.a()
              {
                public final void a(int paramAnonymousInt1, int paramAnonymousInt2, final String paramAnonymousString, d paramAnonymousd)
                {
                  AppMethodBeat.i(96493);
                  if ((paramAnonymousInt1 != 0) || (paramAnonymousInt2 != 0) || (d.c.b(paramAnonymousd.lBS) == null))
                  {
                    Log.e("MicroMsg.Sns.AdLandingPageBtnComponent", "getsubbusinessinfo cgi failed, errType = %d, errCode = %d, errMsg = %s, rr.resp = %s", new Object[] { Integer.valueOf(paramAnonymousInt1), Integer.valueOf(paramAnonymousInt2), paramAnonymousString, d.c.b(paramAnonymousd.lBS) });
                    MMHandlerThread.postToMainThread(new Runnable()
                    {
                      public final void run()
                      {
                        AppMethodBeat.i(96491);
                        w.makeText(q.this.context, i.j.sns_ad_open_service_chat_failed, 0).show();
                        AppMethodBeat.o(96491);
                      }
                    });
                    AppMethodBeat.o(96493);
                    return;
                  }
                  paramAnonymousString = (cdk)d.c.b(paramAnonymousd.lBS);
                  Log.i("MicroMsg.Sns.AdLandingPageBtnComponent", "getsubbusinessinfo cgi success, subBusinessUsername:%s", new Object[] { paramAnonymousString.Tlh });
                  MMHandlerThread.postToMainThread(new Runnable()
                  {
                    public final void run()
                    {
                      AppMethodBeat.i(96492);
                      q.this.a(q.6.this.KqX, paramAnonymousString.Tlh);
                      AppMethodBeat.o(96492);
                    }
                  });
                  AppMethodBeat.o(96493);
                }
              });
            }
          }
        }
        if (((r)localObject1).subType == 16)
        {
          localObject3 = (ad)localObject1;
          if (((ad)localObject3).KmV != null)
          {
            localObject1 = fRp().fQE();
            if (TextUtils.isEmpty((CharSequence)localObject1))
            {
              localObject1 = fRp().uxInfo;
              Log.i("MicroMsg.Sns.AdLandingPageBtnComponent", "jumpScanUI, use old uxInfo=".concat(String.valueOf(localObject1)));
            }
            for (;;)
            {
              com.tencent.mm.plugin.sns.ad.d.o.a(this.context, ((ad)localObject3).KmV, (String)localObject1);
              AppMethodBeat.o(270134);
              return;
              Log.i("MicroMsg.Sns.AdLandingPageBtnComponent", "jumpScanUI, use new uxInfo=".concat(String.valueOf(localObject1)));
            }
          }
          Log.e("MicroMsg.Sns.AdLandingPageBtnComponent", "scanJumpInfo == null");
          AppMethodBeat.o(270134);
          return;
        }
        localObject1 = ((r)localObject1).KlK;
        this.KqQ.kQ("btnJumpUrl", (String)localObject1);
        m.a(this.context, (String)localObject1, fRp(), i, l, ((r)this.KqB).KmB);
        fRu();
        AppMethodBeat.o(270134);
        return;
      }
      i = 0;
    }
  }
  
  @TargetApi(17)
  protected void fKe()
  {
    AppMethodBeat.i(96496);
    this.clickCount = 0;
    int i = this.pEj;
    int k = i;
    int j;
    if (((r)this.KqB).KmD > 0.0F)
    {
      k = i;
      if (((r)this.KqB).KmD <= i)
      {
        i = (int)((r)this.KqB).KmD;
        j = (int)((r)this.KqB).paddingLeft;
        k = (int)((r)this.KqB).paddingRight + (i + j);
      }
    }
    this.KqR.setBackgroundColor(this.backgroundColor);
    if (!Util.isNullOrNil(((r)this.KqB).KlS))
    {
      h.a("adId", ((r)this.KqB).KlS, new f.a()
      {
        @TargetApi(16)
        public final void aYs(String paramAnonymousString)
        {
          AppMethodBeat.i(96486);
          try
          {
            Log.i("MicroMsg.Sns.AdLandingPageBtnComponent", "onDownloaded, path=".concat(String.valueOf(paramAnonymousString)));
            paramAnonymousString = com.tencent.mm.plugin.sns.ad.i.c.a(q.this.KqS.getResources(), paramAnonymousString);
            q.this.KqS.setBackground(paramAnonymousString);
            if ((paramAnonymousString != null) && (((r)q.this.KqB).height > 0.0F) && (paramAnonymousString.getIntrinsicHeight() > 0))
            {
              float f = ((r)q.this.KqB).height * paramAnonymousString.getIntrinsicWidth() / paramAnonymousString.getIntrinsicHeight();
              q.this.KqS.setLayoutParams(new FrameLayout.LayoutParams((int)f, (int)((r)q.this.KqB).height));
            }
            AppMethodBeat.o(96486);
            return;
          }
          catch (Throwable paramAnonymousString)
          {
            Log.e("MicroMsg.Sns.AdLandingPageBtnComponent", "the backgroundCoverUrl is set error ,because " + paramAnonymousString.toString());
            AppMethodBeat.o(96486);
          }
        }
        
        public final void fJU() {}
        
        public final void fJV() {}
      });
      j = 0;
    }
    for (;;)
    {
      this.KqS.setText(((r)this.KqB).title);
      if (((r)this.KqB).KlO == 1)
      {
        this.KqS.setTypeface(Typeface.defaultFromStyle(1));
        label186:
        this.KqS.setOnClickListener(new View.OnClickListener()
        {
          public final void onClick(View paramAnonymousView)
          {
            AppMethodBeat.i(96489);
            b localb = new b();
            localb.bn(paramAnonymousView);
            a.c("com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/component/AdLandingPageBtnComponent$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aFi());
            q.this.fRt();
            q.this.fRb();
            a.a(this, "com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/component/AdLandingPageBtnComponent$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(96489);
          }
        });
        if (((r)this.KqB).fontSize > 0.0F) {
          this.KqS.setTextSize(0, ((r)this.KqB).fontSize);
        }
        if ((((r)this.KqB).KlM == null) || (((r)this.KqB).KlM.length() <= 0)) {}
      }
      try
      {
        i = Color.parseColor(((r)this.KqB).KlM);
        this.KqS.setTextColor(i);
      }
      catch (Exception localException1)
      {
        try
        {
          for (;;)
          {
            for (;;)
            {
              this.KqS.setTextAlignment(4);
              if (((r)this.KqB).height <= 0.0F) {
                break label784;
              }
              this.KqS.setLayoutParams(new FrameLayout.LayoutParams(k - (int)((r)this.KqB).paddingLeft - (int)((r)this.KqB).paddingRight, (int)((r)this.KqB).height));
              if (((r)this.KqB).KlT != 1) {
                break label836;
              }
              this.KqT.setLayoutParams(new FrameLayout.LayoutParams(k - (int)((r)this.KqB).paddingLeft - (int)((r)this.KqB).paddingRight, this.KqT.getLayoutParams().height));
              this.KqT.setVisibility(0);
              this.KqT.setOnLongClickListener(new View.OnLongClickListener()
              {
                public final boolean onLongClick(View paramAnonymousView)
                {
                  AppMethodBeat.i(96487);
                  Object localObject = new b();
                  ((b)localObject).bn(paramAnonymousView);
                  a.c("com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/component/AdLandingPageBtnComponent$2", "android/view/View$OnLongClickListener", "onLongClick", "(Landroid/view/View;)Z", this, ((b)localObject).aFi());
                  paramAnonymousView = q.this;
                  aa localaa;
                  String str1;
                  String str2;
                  String str3;
                  boolean bool1;
                  boolean bool2;
                  if ((paramAnonymousView.context instanceof SnsAdNativeLandingPagesUI))
                  {
                    localObject = (SnsAdNativeLandingPagesUI)paramAnonymousView.context;
                    localaa = ((r)paramAnonymousView.KqB).Kma;
                    str1 = ((r)paramAnonymousView.KqB).KlX;
                    str2 = ((r)paramAnonymousView.KqB).KlY;
                    str3 = ((r)paramAnonymousView.KqB).KlZ;
                    if (((r)paramAnonymousView.KqB).KlV != 1) {
                      break label203;
                    }
                    bool1 = true;
                    if (((r)paramAnonymousView.KqB).KlW != 1) {
                      break label208;
                    }
                    bool2 = true;
                    label141:
                    if (((r)paramAnonymousView.KqB).KlU != 1) {
                      break label213;
                    }
                  }
                  label203:
                  label208:
                  label213:
                  for (boolean bool3 = true;; bool3 = false)
                  {
                    ((SnsAdNativeLandingPagesUI)localObject).a(localaa, str1, str2, str3, bool1, bool2, bool3);
                    paramAnonymousView.KqT.setPressed(false);
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
              this.KqT.setOnClickListener(new View.OnClickListener()
              {
                public final void onClick(View paramAnonymousView)
                {
                  AppMethodBeat.i(96488);
                  b localb = new b();
                  localb.bn(paramAnonymousView);
                  a.c("com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/component/AdLandingPageBtnComponent$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aFi());
                  q.this.fRt();
                  q.this.fRb();
                  a.a(this, "com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/component/AdLandingPageBtnComponent$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                  AppMethodBeat.o(96488);
                }
              });
              if (j == 0) {
                this.KqR.setRadius(((r)this.KqB).bDI);
              }
              com.tencent.mm.plugin.sns.ad.d.i.a(this.context, (r)this.KqB, this.KqS);
              AppMethodBeat.o(96496);
              return;
              GradientDrawable localGradientDrawable = new GradientDrawable();
              localGradientDrawable.setShape(0);
              if ((Util.isNullOrNil(((r)this.KqB).KlR)) || (((r)this.KqB).KlN <= 0.0F)) {
                break label848;
              }
              try
              {
                i = Color.parseColor(((r)this.KqB).KlR);
                localGradientDrawable.setStroke((int)((r)this.KqB).KlN, i);
                if (((r)this.KqB).bDI > 0.0F) {
                  localGradientDrawable.setCornerRadius(((r)this.KqB).bDI);
                }
                j = 1;
                i = 1;
                m = j;
                if (Util.isNullOrNil(((r)this.KqB).KlQ)) {}
              }
              catch (Exception localException3)
              {
                try
                {
                  j = Color.parseColor(((r)this.KqB).KlQ);
                  localGradientDrawable.setColor(j);
                  int m = 1;
                  j = i;
                  if (m == 0) {
                    break;
                  }
                  this.KqS.setBackgroundDrawable(localGradientDrawable);
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
            if (((r)this.KqB).KlO != 2) {
              break label186;
            }
            this.KqS.setTypeface(Typeface.defaultFromStyle(2));
            break label186;
            localException1 = localException1;
            Log.e("MicroMsg.Sns.AdLandingPageBtnComponent", "invalid color! %s", new Object[] { ((r)this.KqB).KlM });
          }
        }
        catch (Exception localException2)
        {
          for (;;)
          {
            Log.e("MicroMsg.Sns.AdLandingPageBtnComponent", "the device has no method btn.setTextAlignment");
            continue;
            label784:
            this.KqS.setLayoutParams(new FrameLayout.LayoutParams(k - (int)((r)this.KqB).paddingLeft - (int)((r)this.KqB).paddingRight, this.KqS.getLayoutParams().height));
            continue;
            label836:
            this.KqT.setVisibility(8);
            continue;
            label848:
            j = 0;
            i = 0;
          }
        }
      }
    }
  }
  
  @TargetApi(17)
  public void fKp()
  {
    AppMethodBeat.i(96498);
    View localView = this.contentView;
    this.KqR = ((RoundedCornerFrameLayout)localView.findViewById(i.f.sns_ad_native_landing_pages_item_btn_relative));
    this.KqS = ((Button)localView.findViewById(i.f.sns_ad_native_landing_pages_item_btn_btn));
    this.KqT = localView.findViewById(i.f.sns_ad_native_landing_pages_item_gray_cover);
    AppMethodBeat.o(96498);
  }
  
  protected void fRb()
  {
    AppMethodBeat.i(96497);
    try
    {
      fKd();
      fRc();
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
  
  protected final void fRu()
  {
    AppMethodBeat.i(270135);
    if ((this.KqV) && ((this.context instanceof Activity))) {
      ((Activity)this.context).overridePendingTransition(com.tencent.mm.plugin.sns.i.a.push_up_in, com.tencent.mm.plugin.sns.i.a.anim_not_change);
    }
    AppMethodBeat.o(270135);
  }
  
  protected final int getLayout()
  {
    return i.g.sns_ad_native_landing_pages_item_btn;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.q
 * JD-Core Version:    0.7.0.1
 */