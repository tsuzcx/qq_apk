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
import com.tencent.mm.ak.d;
import com.tencent.mm.ak.d.a;
import com.tencent.mm.ak.d.b;
import com.tencent.mm.ak.d.c;
import com.tencent.mm.br.c;
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.ipcinvoker.wx_extension.IPCRunCgi;
import com.tencent.mm.ipcinvoker.wx_extension.IPCRunCgi.a;
import com.tencent.mm.plugin.appbrand.config.WxaExposedParams.a;
import com.tencent.mm.plugin.appbrand.ipc.AppBrandMainProcessService;
import com.tencent.mm.plugin.sns.data.r;
import com.tencent.mm.plugin.sns.model.AdLandingPagesProxy;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageChattingTask;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.a.g.a;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.ac;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.ah;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.h.a;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.j;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.n;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.z;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.f.a;
import com.tencent.mm.plugin.sns.storage.y;
import com.tencent.mm.plugin.sns.ui.SnsAdNativeLandingPagesUI;
import com.tencent.mm.pluginsdk.ui.span.e;
import com.tencent.mm.pluginsdk.ui.span.e.a;
import com.tencent.mm.protocal.protobuf.bvr;
import com.tencent.mm.protocal.protobuf.bvs;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.sdk.platformtools.NetStatusUtil;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.MMActivity.a;
import com.tencent.mm.ui.base.u;
import com.tencent.mm.ui.widget.RoundedCornerFrameLayout;
import com.tencent.mm.ui.widget.a.e.b;
import java.util.List;
import org.json.JSONObject;

public class q
  extends p
{
  protected RoundedCornerFrameLayout Edo;
  public Button Edp;
  View Edq;
  public boolean Edr;
  public boolean Eds;
  
  public q(Context paramContext, com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.q paramq, ViewGroup paramViewGroup)
  {
    super(paramContext, paramq, paramViewGroup);
  }
  
  final void a(final n paramn, String paramString)
  {
    AppMethodBeat.i(96499);
    try
    {
      final AdLandingPageChattingTask localAdLandingPageChattingTask = new AdLandingPageChattingTask();
      Object localObject2 = paramn.weappUserName;
      Object localObject1 = localObject2;
      if (localObject2 == null) {
        localObject1 = "";
      }
      final WxaExposedParams.a locala = new WxaExposedParams.a();
      locala.appId = paramn.DYj;
      locala.username = ((String)localObject1);
      locala.nickname = "";
      locala.iconUrl = "";
      locala.kNW = 0;
      locala.pkgVersion = 0;
      locala.lhn = "";
      locala.from = 14;
      locala.pageId = "";
      locala.lho = "";
      localObject2 = paramString;
      if (TextUtils.isEmpty(paramString)) {
        localObject2 = localObject1;
      }
      localAdLandingPageChattingTask.username = ((String)localObject2);
      localAdLandingPageChattingTask.nickname = "";
      localAdLandingPageChattingTask.lRW = paramn.lRW;
      localAdLandingPageChattingTask.lyv = new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(96495);
          localIntent = new Intent();
          localIntent.setFlags(67108864);
          localIntent.putExtra("Chat_User", localAdLandingPageChattingTask.username);
          localIntent.putExtra("app_brand_chatting_from_scene", 3);
          localIntent.putExtra("app_brand_chatting_expose_params", locala.bAv());
          localIntent.putExtra("key_temp_session_from", localAdLandingPageChattingTask.lRW);
          localIntent.putExtra("finish_direct", true);
          localIntent.putExtra("key_need_send_video", false);
          try
          {
            if (paramn.DYk != 1) {
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
                ((JSONObject)localObject1).put("uxInfo", q.this.fds().uxInfo);
                localObject1 = ((JSONObject)localObject1).toString();
                localIntent.putExtra("sns_landing_pages_ux_info", (String)localObject1);
                Object localObject2 = (MMActivity)q.this.context;
                ((MMActivity)localObject2).mmSetOnActivityResultCallback(new MMActivity.a()
                {
                  public final void d(int paramAnonymous2Int1, int paramAnonymous2Int2, Intent paramAnonymous2Intent)
                  {
                    AppMethodBeat.i(96494);
                    if (paramAnonymous2Int1 == 1) {
                      q.7.this.Edw.bDK();
                    }
                    AppMethodBeat.o(96494);
                  }
                });
                Log.i("MicroMsg.Sns.AdLandingPageBtnComponent", "open ServiceChattingUI， uxInfo=".concat(String.valueOf(localObject1)));
                c.c((Context)localObject2, ".ui.chatting.AppBrandServiceChattingUI", localIntent, 1);
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
          localObject1 = paramn.lSf;
          localObject2 = paramn.lSg;
          str2 = paramn.lSh;
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
      localAdLandingPageChattingTask.bDJ();
      AppBrandMainProcessService.a(localAdLandingPageChattingTask);
      AppMethodBeat.o(96499);
      return;
    }
    catch (Exception paramn)
    {
      Log.e("MicroMsg.Sns.AdLandingPageBtnComponent", "doEnterChatting exp:" + paramn.toString());
      AppMethodBeat.o(96499);
    }
  }
  
  protected void eWS()
  {
    AppMethodBeat.i(202938);
    Object localObject1 = (com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.q)this.EcX;
    long l = 0L;
    int i;
    if ((this.context instanceof Activity))
    {
      l = y.aOa(((Activity)this.context).getIntent().getStringExtra("sns_landing_pages_share_sns_id"));
      i = ((Activity)this.context).getIntent().getIntExtra("sns_landig_pages_from_source", 0);
      ((Activity)this.context).getIntent().getIntExtra("sns_landing_pages_adType", 0);
    }
    for (;;)
    {
      Object localObject2;
      if (((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.q)localObject1).subType == 4)
      {
        localObject1 = (com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.f)localObject1;
        localObject2 = new Intent();
        ((Intent)localObject2).putExtra("key_card_id", ((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.f)localObject1).cardTpId);
        if (!Util.isNullOrNil(fds().aPU(((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.f)localObject1).cardTpId))) {
          ((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.f)localObject1).cardExt = fds().aPU(((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.f)localObject1).cardTpId);
        }
        ((Intent)localObject2).putExtra("key_card_ext", ((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.f)localObject1).cardExt);
        ((Intent)localObject2).putExtra("key_from_scene", 21);
        ((Intent)localObject2).putExtra("key_stastic_scene", 15);
        c.b(this.context, "card", ".ui.CardDetailUI", (Intent)localObject2);
        fdy();
        this.Edn.kv("cardTpId", ((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.f)localObject1).cardTpId);
        this.Edn.kv("cardExt", ((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.f)localObject1).cardExt);
        AppMethodBeat.o(202938);
        return;
      }
      if (((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.q)localObject1).subType == 8) {
        if (((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.q)this.EcX instanceof com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.k))
        {
          localObject2 = "";
          if ((!(this.context instanceof Activity)) || (fds().bizId != 2)) {
            break label1500;
          }
          localObject2 = ((Activity)this.context).getIntent().getStringExtra("sns_landing_pages_sessionId");
        }
      }
      label970:
      label1500:
      for (localObject1 = ((Activity)this.context).getIntent().getStringExtra("sns_landing_pages_ad_buffer");; localObject1 = "")
      {
        localObject1 = String.format("%s:%s:%s:%s:%d:%s:%s:%d", new Object[] { localObject2, localObject1, ((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.k)(com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.q)this.EcX).DZi, String.valueOf(System.currentTimeMillis() / 1000L), Integer.valueOf(fds().bizId), fds().uxInfo, Long.valueOf(l), Integer.valueOf(i) });
        localObject2 = (com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.k)this.EcX;
        r.a(((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.k)localObject2).username, ((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.k)localObject2).ecK, "", fds().aid, fds().kZe, (String)localObject1, fds().uxInfo, 1084);
        this.Edn.kv("weappUserName", ((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.k)localObject2).username);
        this.Edn.kv("weappPath", ((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.k)localObject2).ecK);
        AppMethodBeat.o(202938);
        return;
        if (((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.q)localObject1).subType == 9)
        {
          localObject1 = (com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.h)localObject1;
          localObject2 = new Intent();
          ((Intent)localObject2).putExtra("map_view_type", 1);
          ((Intent)localObject2).putExtra("kwebmap_slat", ((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.h)localObject1).DYb.yFu);
          ((Intent)localObject2).putExtra("kwebmap_lng", ((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.h)localObject1).DYb.yFv);
          ((Intent)localObject2).putExtra("kwebmap_scale", ((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.h)localObject1).DYb.dRt);
          ((Intent)localObject2).putExtra("kPoiName", ((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.h)localObject1).DYb.dWi);
          ((Intent)localObject2).putExtra("Kwebmap_locaion", ((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.h)localObject1).DYb.yFx);
          Log.i("MicroMsg.Sns.AdLandingPageBtnComponent", "locatint to slat " + ((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.h)localObject1).DYb.yFu + ", slong " + ((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.h)localObject1).DYb.yFv + ", " + ((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.h)localObject1).DYb.dWi);
          c.b(this.context, "location", ".ui.RedirectUI", (Intent)localObject2, 2002);
          AppMethodBeat.o(202938);
          return;
        }
        if (((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.q)localObject1).subType == 10)
        {
          if (e.a.KqE == null)
          {
            AppMethodBeat.o(202938);
            return;
          }
          localObject1 = (j)localObject1;
          if (((j)localObject1).DXU.size() > 1)
          {
            e.a.KqE.a(this.context, ((j)localObject1).DXU, new e.b()
            {
              public final void onDismiss()
              {
                AppMethodBeat.i(96490);
                ap.hb(q.this.context);
                AppMethodBeat.o(96490);
              }
            });
            this.Edn.kv("phonenumber", (String)((j)localObject1).DXU.get(0));
            AppMethodBeat.o(202938);
            return;
          }
          if (((j)localObject1).DXU.size() > 0)
          {
            AdLandingPagesProxy.getInstance().confirmDialPhoneNum((Activity)this.context, (String)((j)localObject1).DXU.get(0));
            this.Edn.kv("phonenumber", (String)((j)localObject1).DXU.get(0));
          }
          AppMethodBeat.o(202938);
          return;
        }
        Object localObject4;
        if (((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.q)localObject1).subType == 11)
        {
          String str1;
          String str2;
          String str3;
          boolean bool1;
          boolean bool2;
          if ((this.context instanceof SnsAdNativeLandingPagesUI))
          {
            localObject2 = (SnsAdNativeLandingPagesUI)this.context;
            localObject4 = ((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.q)localObject1).DYG;
            str1 = ((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.q)localObject1).DYD;
            str2 = ((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.q)localObject1).DYE;
            str3 = ((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.q)localObject1).DYF;
            if (((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.q)localObject1).DYB != 1) {
              break label1012;
            }
            bool1 = true;
            if (((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.q)localObject1).DYC != 1) {
              break label1018;
            }
            bool2 = true;
            if (((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.q)this.EcX).DYA != 1) {
              break label1024;
            }
          }
          for (boolean bool3 = true;; bool3 = false)
          {
            ((SnsAdNativeLandingPagesUI)localObject2).a((z)localObject4, str1, str2, str3, bool1, bool2, bool3);
            AppMethodBeat.o(202938);
            return;
            label1012:
            bool1 = false;
            break;
            label1018:
            bool2 = false;
            break label970;
          }
        }
        Object localObject3;
        if (((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.q)localObject1).subType == 12)
        {
          localObject1 = (n)localObject1;
          Log.i("MicroMsg.Sns.AdLandingPageBtnComponent", "openServiceChat:".concat(String.valueOf(localObject1)));
          try
          {
            if (TextUtils.isEmpty(((n)localObject1).businessId)) {
              a((n)localObject1, "");
            }
            for (;;)
            {
              this.Edn.kv("weappid", ((n)localObject1).DYj);
              this.Edn.kv("weappUserName", ((n)localObject1).weappUserName);
              this.Edn.kv("businessId", ((n)localObject1).businessId);
              AppMethodBeat.o(202938);
              return;
              if (!TextUtils.isEmpty(((n)localObject1).weappUserName))
              {
                if (NetStatusUtil.isNetworkConnected(this.context)) {
                  break;
                }
                u.makeText(this.context, 2131765979, 0).show();
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
              ((d.a)localObject3).iLN = new bvr();
              ((d.a)localObject3).iLO = new bvs();
              ((d.a)localObject3).uri = "/cgi-bin/mmbiz-bin/wxausrevent/getsubbusinessinfo";
              ((d.a)localObject3).funcId = 1303;
              ((d.a)localObject3).iLP = 0;
              ((d.a)localObject3).respCmdId = 0;
              localObject3 = ((d.a)localObject3).aXF();
              localObject4 = (bvr)((d)localObject3).iLK.iLR;
              ((bvr)localObject4).username = ((n)localObject1).weappUserName;
              ((bvr)localObject4).MbE = ((n)localObject1).businessId;
              IPCRunCgi.a((d)localObject3, new IPCRunCgi.a()
              {
                public final void a(int paramAnonymousInt1, int paramAnonymousInt2, final String paramAnonymousString, d paramAnonymousd)
                {
                  AppMethodBeat.i(96493);
                  if ((paramAnonymousInt1 != 0) || (paramAnonymousInt2 != 0) || (paramAnonymousd.iLL.iLR == null))
                  {
                    Log.e("MicroMsg.Sns.AdLandingPageBtnComponent", "getsubbusinessinfo cgi failed, errType = %d, errCode = %d, errMsg = %s, rr.resp = %s", new Object[] { Integer.valueOf(paramAnonymousInt1), Integer.valueOf(paramAnonymousInt2), paramAnonymousString, paramAnonymousd.iLL.iLR });
                    MMHandlerThread.postToMainThread(new Runnable()
                    {
                      public final void run()
                      {
                        AppMethodBeat.i(96491);
                        u.makeText(q.this.context, 2131765979, 0).show();
                        AppMethodBeat.o(96491);
                      }
                    });
                    AppMethodBeat.o(96493);
                    return;
                  }
                  paramAnonymousString = (bvs)paramAnonymousd.iLL.iLR;
                  Log.i("MicroMsg.Sns.AdLandingPageBtnComponent", "getsubbusinessinfo cgi success, subBusinessUsername:%s", new Object[] { paramAnonymousString.MbF });
                  MMHandlerThread.postToMainThread(new Runnable()
                  {
                    public final void run()
                    {
                      AppMethodBeat.i(96492);
                      q.this.a(q.6.this.Edu, paramAnonymousString.MbF);
                      AppMethodBeat.o(96492);
                    }
                  });
                  AppMethodBeat.o(96493);
                }
              });
            }
          }
        }
        if (((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.q)localObject1).subType == 16)
        {
          localObject3 = (ac)localObject1;
          if (((ac)localObject3).DZA != null)
          {
            localObject1 = fds().DZW;
            if (TextUtils.isEmpty((CharSequence)localObject1))
            {
              localObject1 = fds().uxInfo;
              Log.i("MicroMsg.Sns.AdLandingPageBtnComponent", "jumpScanUI, use old uxInfo=".concat(String.valueOf(localObject1)));
            }
            for (;;)
            {
              com.tencent.mm.plugin.sns.ad.e.k.a(this.context, ((ac)localObject3).DZA, (String)localObject1);
              AppMethodBeat.o(202938);
              return;
              Log.i("MicroMsg.Sns.AdLandingPageBtnComponent", "jumpScanUI, use new uxInfo=".concat(String.valueOf(localObject1)));
            }
          }
          Log.e("MicroMsg.Sns.AdLandingPageBtnComponent", "scanJumpInfo == null");
          AppMethodBeat.o(202938);
          return;
        }
        localObject1 = ((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.q)localObject1).DYr;
        this.Edn.kv("btnJumpUrl", (String)localObject1);
        com.tencent.mm.plugin.sns.data.k.a(this.context, (String)localObject1, fds(), i, l, ((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.q)this.EcX).DZi);
        fdy();
        AppMethodBeat.o(202938);
        return;
      }
      label1024:
      i = 0;
    }
  }
  
  @TargetApi(17)
  protected void eWT()
  {
    AppMethodBeat.i(96496);
    this.clickCount = 0;
    int i = this.mEX;
    int k = i;
    int j;
    if (((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.q)this.EcX).DZk > 0.0F)
    {
      k = i;
      if (((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.q)this.EcX).DZk <= i)
      {
        i = (int)((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.q)this.EcX).DZk;
        j = (int)((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.q)this.EcX).paddingLeft;
        k = (int)((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.q)this.EcX).paddingRight + (i + j);
      }
    }
    this.Edo.setBackgroundColor(this.backgroundColor);
    if (!Util.isNullOrNil(((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.q)this.EcX).DYy))
    {
      com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.h.a("adId", ((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.q)this.EcX).DYy, false, 0, new f.a()
      {
        @TargetApi(16)
        public final void aNH(String paramAnonymousString)
        {
          AppMethodBeat.i(96486);
          try
          {
            Log.i("MicroMsg.Sns.AdLandingPageBtnComponent", "onDownloaded, path=".concat(String.valueOf(paramAnonymousString)));
            paramAnonymousString = com.tencent.mm.plugin.sns.ad.i.b.a(q.this.Edp.getResources(), paramAnonymousString);
            q.this.Edp.setBackground(paramAnonymousString);
            if ((paramAnonymousString != null) && (q.this.fdx().height > 0.0F) && (paramAnonymousString.getIntrinsicHeight() > 0))
            {
              float f = q.this.fdx().height * paramAnonymousString.getIntrinsicWidth() / paramAnonymousString.getIntrinsicHeight();
              q.this.Edp.setLayoutParams(new FrameLayout.LayoutParams((int)f, (int)q.this.fdx().height));
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
        
        public final void eWN() {}
        
        public final void eWO() {}
      });
      j = 0;
    }
    for (;;)
    {
      this.Edp.setText(((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.q)this.EcX).title);
      if (((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.q)this.EcX).DYv == 1)
      {
        this.Edp.setTypeface(Typeface.defaultFromStyle(1));
        label188:
        this.Edp.setOnClickListener(new View.OnClickListener()
        {
          public final void onClick(View paramAnonymousView)
          {
            AppMethodBeat.i(96489);
            com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
            localb.bm(paramAnonymousView);
            a.b("com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/component/AdLandingPageBtnComponent$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.axR());
            q.this.fdw();
            q.this.fde();
            a.a(this, "com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/component/AdLandingPageBtnComponent$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(96489);
          }
        });
        if (((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.q)this.EcX).fontSize > 0.0F) {
          this.Edp.setTextSize(0, ((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.q)this.EcX).fontSize);
        }
        if ((((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.q)this.EcX).DYt == null) || (((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.q)this.EcX).DYt.length() <= 0)) {}
      }
      try
      {
        i = Color.parseColor(((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.q)this.EcX).DYt);
        this.Edp.setTextColor(i);
      }
      catch (Exception localException1)
      {
        try
        {
          for (;;)
          {
            for (;;)
            {
              this.Edp.setTextAlignment(4);
              if (((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.q)this.EcX).height <= 0.0F) {
                break label786;
              }
              this.Edp.setLayoutParams(new FrameLayout.LayoutParams(k - (int)((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.q)this.EcX).paddingLeft - (int)((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.q)this.EcX).paddingRight, (int)((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.q)this.EcX).height));
              if (((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.q)this.EcX).DYz != 1) {
                break label838;
              }
              this.Edq.setLayoutParams(new FrameLayout.LayoutParams(k - (int)((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.q)this.EcX).paddingLeft - (int)((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.q)this.EcX).paddingRight, this.Edq.getLayoutParams().height));
              this.Edq.setVisibility(0);
              this.Edq.setOnLongClickListener(new View.OnLongClickListener()
              {
                public final boolean onLongClick(View paramAnonymousView)
                {
                  AppMethodBeat.i(96487);
                  com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
                  localb.bm(paramAnonymousView);
                  a.b("com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/component/AdLandingPageBtnComponent$2", "android/view/View$OnLongClickListener", "onLongClick", "(Landroid/view/View;)Z", this, localb.axR());
                  q.a(q.this);
                  a.a(true, this, "com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/component/AdLandingPageBtnComponent$2", "android/view/View$OnLongClickListener", "onLongClick", "(Landroid/view/View;)Z");
                  AppMethodBeat.o(96487);
                  return true;
                }
              });
              this.Edq.setOnClickListener(new View.OnClickListener()
              {
                public final void onClick(View paramAnonymousView)
                {
                  AppMethodBeat.i(96488);
                  com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
                  localb.bm(paramAnonymousView);
                  a.b("com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/component/AdLandingPageBtnComponent$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.axR());
                  q.this.fdw();
                  q.this.fde();
                  a.a(this, "com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/component/AdLandingPageBtnComponent$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                  AppMethodBeat.o(96488);
                }
              });
              if (j == 0) {
                this.Edo.setRadius(((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.q)this.EcX).tt);
              }
              com.tencent.mm.plugin.sns.ad.e.f.a(this.context, (com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.q)this.EcX, this.Edp);
              AppMethodBeat.o(96496);
              return;
              GradientDrawable localGradientDrawable = new GradientDrawable();
              localGradientDrawable.setShape(0);
              if ((Util.isNullOrNil(((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.q)this.EcX).DYx)) || (((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.q)this.EcX).DYu <= 0.0F)) {
                break label850;
              }
              try
              {
                i = Color.parseColor(((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.q)this.EcX).DYx);
                localGradientDrawable.setStroke((int)((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.q)this.EcX).DYu, i);
                if (((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.q)this.EcX).tt > 0.0F) {
                  localGradientDrawable.setCornerRadius(((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.q)this.EcX).tt);
                }
                j = 1;
                i = 1;
                m = j;
                if (Util.isNullOrNil(((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.q)this.EcX).DYw)) {}
              }
              catch (Exception localException3)
              {
                try
                {
                  j = Color.parseColor(((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.q)this.EcX).DYw);
                  localGradientDrawable.setColor(j);
                  int m = 1;
                  j = i;
                  if (m == 0) {
                    break;
                  }
                  this.Edp.setBackgroundDrawable(localGradientDrawable);
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
            if (((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.q)this.EcX).DYv != 2) {
              break label188;
            }
            this.Edp.setTypeface(Typeface.defaultFromStyle(2));
            break label188;
            localException1 = localException1;
            Log.e("MicroMsg.Sns.AdLandingPageBtnComponent", "invalid color! %s", new Object[] { ((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.q)this.EcX).DYt });
          }
        }
        catch (Exception localException2)
        {
          for (;;)
          {
            Log.e("MicroMsg.Sns.AdLandingPageBtnComponent", "the device has no method btn.setTextAlignment");
            continue;
            label786:
            this.Edp.setLayoutParams(new FrameLayout.LayoutParams(k - (int)((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.q)this.EcX).paddingLeft - (int)((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.q)this.EcX).paddingRight, this.Edp.getLayoutParams().height));
            continue;
            label838:
            this.Edq.setVisibility(8);
            continue;
            label850:
            j = 0;
            i = 0;
          }
        }
      }
    }
  }
  
  @TargetApi(17)
  public void eXe()
  {
    AppMethodBeat.i(96498);
    View localView = this.contentView;
    this.Edo = ((RoundedCornerFrameLayout)localView.findViewById(2131308039));
    this.Edp = ((Button)localView.findViewById(2131308038));
    this.Edq = localView.findViewById(2131308041);
    AppMethodBeat.o(96498);
  }
  
  protected void fde()
  {
    AppMethodBeat.i(96497);
    try
    {
      eWS();
      fdf();
      AppMethodBeat.o(96497);
      return;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        Log.e("MicroMsg.Sns.AdLandingPageBtnComponent", "onBtnClick exp=" + localException.toString());
      }
    }
  }
  
  protected final com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.q fdx()
  {
    return (com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.q)this.EcX;
  }
  
  protected final void fdy()
  {
    AppMethodBeat.i(202939);
    if ((this.Eds) && ((this.context instanceof Activity))) {
      ((Activity)this.context).overridePendingTransition(2130772132, 2130771986);
    }
    AppMethodBeat.o(202939);
  }
  
  protected final int getLayout()
  {
    return 2131496381;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.q
 * JD-Core Version:    0.7.0.1
 */