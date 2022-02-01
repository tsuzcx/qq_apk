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
import com.tencent.mm.ak.b;
import com.tencent.mm.ak.b.a;
import com.tencent.mm.ak.b.b;
import com.tencent.mm.ak.b.c;
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
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.p;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.f.a;
import com.tencent.mm.plugin.sns.ui.SnsAdNativeLandingPagesUI;
import com.tencent.mm.protocal.protobuf.bem;
import com.tencent.mm.protocal.protobuf.ben;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ap;
import com.tencent.mm.sdk.platformtools.ax;
import com.tencent.mm.sdk.platformtools.bs;
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
  RoundedCornerFrameLayout yni;
  Button ynj;
  View ynk;
  
  public o(Context paramContext, p paramp, ViewGroup paramViewGroup)
  {
    super(paramContext, paramp, paramViewGroup);
  }
  
  final void a(final m paramm, String paramString)
  {
    AppMethodBeat.i(96499);
    try
    {
      final AdLandingPageChattingTask localAdLandingPageChattingTask = new AdLandingPageChattingTask();
      Object localObject2 = paramm.pis;
      Object localObject1 = localObject2;
      if (localObject2 == null) {
        localObject1 = "";
      }
      final WxaExposedParams.a locala = new WxaExposedParams.a();
      locala.appId = paramm.yiD;
      locala.username = ((String)localObject1);
      locala.nickname = "";
      locala.iconUrl = "";
      locala.jpa = 0;
      locala.pkgVersion = 0;
      locala.jGi = "";
      locala.from = 14;
      locala.pageId = "";
      locala.jGj = "";
      localObject2 = paramString;
      if (TextUtils.isEmpty(paramString)) {
        localObject2 = localObject1;
      }
      localAdLandingPageChattingTask.username = ((String)localObject2);
      localAdLandingPageChattingTask.nickname = "";
      localAdLandingPageChattingTask.koP = paramm.koP;
      localAdLandingPageChattingTask.jWP = new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(96495);
          localIntent = new Intent();
          localIntent.setFlags(67108864);
          localIntent.putExtra("Chat_User", localAdLandingPageChattingTask.username);
          localIntent.putExtra("app_brand_chatting_from_scene", 3);
          localIntent.putExtra("app_brand_chatting_expose_params", locala.baT());
          localIntent.putExtra("key_temp_session_from", localAdLandingPageChattingTask.koP);
          localIntent.putExtra("finish_direct", true);
          localIntent.putExtra("key_need_send_video", false);
          try
          {
            if (paramm.yiE != 1) {
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
                ((JSONObject)localObject1).put("uxInfo", o.this.dKH().dtx);
                localObject1 = ((JSONObject)localObject1).toString();
                localIntent.putExtra("sns_landing_pages_ux_info", (String)localObject1);
                Object localObject2 = (MMActivity)o.this.context;
                ((MMActivity)localObject2).mmSetOnActivityResultCallback(new MMActivity.a()
                {
                  public final void c(int paramAnonymous2Int1, int paramAnonymous2Int2, Intent paramAnonymous2Intent)
                  {
                    AppMethodBeat.i(96494);
                    if (paramAnonymous2Int1 == 1) {
                      o.7.this.yno.bek();
                    }
                    AppMethodBeat.o(96494);
                  }
                });
                ac.i("MicroMsg.Sns.AdLandingPageBtnComponent", "open ServiceChattingUI， uxInfo=".concat(String.valueOf(localObject1)));
                com.tencent.mm.br.d.c((Context)localObject2, ".ui.chatting.AppBrandServiceChattingUI", localIntent, 1);
                AppMethodBeat.o(96495);
                return;
                int i = 0;
                continue;
                localIntent.putExtra("showMessageCard", false);
                continue;
                localThrowable = localThrowable;
                localIntent.putExtra("showMessageCard", false);
                ac.e("MicroMsg.Sns.AdLandingPageBtnComponent", localThrowable.toString());
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
          localObject1 = paramm.koZ;
          localObject2 = paramm.kpa;
          str2 = paramm.kpb;
          if (i != 0) {
            if (!bs.T(new String[] { localObject1, str2, localObject2 }))
            {
              localIntent.putExtra("showMessageCard", true);
              localIntent.putExtra("sendMessageTitle", (String)localObject1);
              localIntent.putExtra("sendMessagePath", (String)localObject2);
              localIntent.putExtra("sendMessageImg", str2);
            }
          }
        }
      };
      localAdLandingPageChattingTask.bej();
      AppBrandMainProcessService.a(localAdLandingPageChattingTask);
      AppMethodBeat.o(96499);
      return;
    }
    catch (Exception paramm)
    {
      ac.e("MicroMsg.Sns.AdLandingPageBtnComponent", "doEnterChatting exp:" + paramm.toString());
      AppMethodBeat.o(96499);
    }
  }
  
  @TargetApi(17)
  public void dJW()
  {
    AppMethodBeat.i(96498);
    View localView = this.contentView;
    this.yni = ((RoundedCornerFrameLayout)localView.findViewById(2131304903));
    this.ynj = ((Button)localView.findViewById(2131304902));
    this.ynk = localView.findViewById(2131304905);
    AppMethodBeat.o(96498);
  }
  
  protected final p dKN()
  {
    return (p)this.ymQ;
  }
  
  protected void dKO()
  {
    AppMethodBeat.i(96497);
    try
    {
      dKv();
      dKM();
      AppMethodBeat.o(96497);
      return;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        ac.e("MicroMsg.Sns.AdLandingPageBtnComponent", "onBtnClick exp=" + localException.toString());
      }
    }
  }
  
  @TargetApi(17)
  protected void dKm()
  {
    AppMethodBeat.i(96496);
    this.clickCount = 0;
    int i = this.kWB;
    int k = i;
    int j;
    if (((p)this.ymQ).yju > 0.0F)
    {
      k = i;
      if (((p)this.ymQ).yju <= i)
      {
        i = (int)((p)this.ymQ).yju;
        j = (int)((p)this.ymQ).paddingLeft;
        k = (int)((p)this.ymQ).paddingRight + (i + j);
      }
    }
    this.yni.setBackgroundColor(this.backgroundColor);
    if (!bs.isNullOrNil(((p)this.ymQ).yiS))
    {
      com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.h.c("adId", ((p)this.ymQ).yiS, false, 0, new f.a()
      {
        @TargetApi(16)
        public final void asD(String paramAnonymousString)
        {
          AppMethodBeat.i(96486);
          try
          {
            ac.i("MicroMsg.Sns.AdLandingPageBtnComponent", "onDownloaded, path=".concat(String.valueOf(paramAnonymousString)));
            paramAnonymousString = com.tencent.mm.plugin.sns.ad.e.a.a(o.this.ynj.getResources(), paramAnonymousString);
            o.this.ynj.setBackground(paramAnonymousString);
            if ((paramAnonymousString != null) && (o.this.dKN().height > 0.0F) && (paramAnonymousString.getIntrinsicHeight() > 0))
            {
              float f = o.this.dKN().height * paramAnonymousString.getIntrinsicWidth() / paramAnonymousString.getIntrinsicHeight();
              o.this.ynj.setLayoutParams(new FrameLayout.LayoutParams((int)f, (int)o.this.dKN().height));
            }
            AppMethodBeat.o(96486);
            return;
          }
          catch (Throwable paramAnonymousString)
          {
            ac.e("MicroMsg.Sns.AdLandingPageBtnComponent", "the backgroundCoverUrl is set error ,because " + paramAnonymousString.toString());
            AppMethodBeat.o(96486);
          }
        }
        
        public final void dFC() {}
        
        public final void dFD() {}
      });
      j = 0;
    }
    for (;;)
    {
      this.ynj.setText(((p)this.ymQ).title);
      if (((p)this.ymQ).yiP == 1)
      {
        this.ynj.setTypeface(Typeface.defaultFromStyle(1));
        label187:
        this.ynj.setOnClickListener(new View.OnClickListener()
        {
          public final void onClick(View paramAnonymousView)
          {
            AppMethodBeat.i(96489);
            o.this.dKL();
            o.this.dKO();
            AppMethodBeat.o(96489);
          }
        });
        if (((p)this.ymQ).bsJ > 0.0F) {
          this.ynj.setTextSize(0, ((p)this.ymQ).bsJ);
        }
        if ((((p)this.ymQ).yiN == null) || (((p)this.ymQ).yiN.length() <= 0)) {}
      }
      try
      {
        i = Color.parseColor(((p)this.ymQ).yiN);
        this.ynj.setTextColor(i);
      }
      catch (Exception localException1)
      {
        try
        {
          for (;;)
          {
            for (;;)
            {
              this.ynj.setTextAlignment(4);
              if (((p)this.ymQ).height <= 0.0F) {
                break label766;
              }
              this.ynj.setLayoutParams(new FrameLayout.LayoutParams(k - (int)((p)this.ymQ).paddingLeft - (int)((p)this.ymQ).paddingRight, (int)((p)this.ymQ).height));
              if (((p)this.ymQ).yiT != 1) {
                break label818;
              }
              this.ynk.setLayoutParams(new FrameLayout.LayoutParams(k - (int)((p)this.ymQ).paddingLeft - (int)((p)this.ymQ).paddingRight, this.ynk.getLayoutParams().height));
              this.ynk.setVisibility(0);
              this.ynk.setOnLongClickListener(new View.OnLongClickListener()
              {
                public final boolean onLongClick(View paramAnonymousView)
                {
                  AppMethodBeat.i(96487);
                  o.a(o.this);
                  AppMethodBeat.o(96487);
                  return true;
                }
              });
              this.ynk.setOnClickListener(new View.OnClickListener()
              {
                public final void onClick(View paramAnonymousView)
                {
                  AppMethodBeat.i(96488);
                  o.this.dKL();
                  o.this.dKO();
                  AppMethodBeat.o(96488);
                }
              });
              if (j == 0) {
                this.yni.setRadius(((p)this.ymQ).rs);
              }
              AppMethodBeat.o(96496);
              return;
              GradientDrawable localGradientDrawable = new GradientDrawable();
              localGradientDrawable.setShape(0);
              if ((bs.isNullOrNil(((p)this.ymQ).yiR)) || (((p)this.ymQ).yiO <= 0.0F)) {
                break label830;
              }
              try
              {
                i = Color.parseColor(((p)this.ymQ).yiR);
                localGradientDrawable.setStroke((int)((p)this.ymQ).yiO, i);
                if (((p)this.ymQ).rs > 0.0F) {
                  localGradientDrawable.setCornerRadius(((p)this.ymQ).rs);
                }
                j = 1;
                i = 1;
                m = j;
                if (bs.isNullOrNil(((p)this.ymQ).yiQ)) {}
              }
              catch (Exception localException3)
              {
                try
                {
                  j = Color.parseColor(((p)this.ymQ).yiQ);
                  localGradientDrawable.setColor(j);
                  int m = 1;
                  j = i;
                  if (m == 0) {
                    break;
                  }
                  this.ynj.setBackgroundDrawable(localGradientDrawable);
                  j = i;
                  break;
                  localException3 = localException3;
                  ac.e("MicroMsg.Sns.AdLandingPageBtnComponent", bs.m(localException3));
                  i = 0;
                }
                catch (Exception localException4)
                {
                  for (;;)
                  {
                    ac.e("MicroMsg.Sns.AdLandingPageBtnComponent", bs.m(localException4));
                    j = 0;
                  }
                }
              }
            }
            if (((p)this.ymQ).yiP != 2) {
              break label187;
            }
            this.ynj.setTypeface(Typeface.defaultFromStyle(2));
            break label187;
            localException1 = localException1;
            ac.e("MicroMsg.Sns.AdLandingPageBtnComponent", "invalid color! %s", new Object[] { ((p)this.ymQ).yiN });
          }
        }
        catch (Exception localException2)
        {
          for (;;)
          {
            ac.e("MicroMsg.Sns.AdLandingPageBtnComponent", "the device has no method btn.setTextAlignment");
            continue;
            label766:
            this.ynj.setLayoutParams(new FrameLayout.LayoutParams(k - (int)((p)this.ymQ).paddingLeft - (int)((p)this.ymQ).paddingRight, this.ynj.getLayoutParams().height));
            continue;
            label818:
            this.ynk.setVisibility(8);
            continue;
            label830:
            j = 0;
            i = 0;
          }
        }
      }
    }
  }
  
  protected void dKv()
  {
    AppMethodBeat.i(200207);
    Object localObject1 = (p)this.ymQ;
    long l = 0L;
    int i;
    if ((this.context instanceof Activity))
    {
      l = com.tencent.mm.plugin.sns.storage.x.asL(((Activity)this.context).getIntent().getStringExtra("sns_landing_pages_share_sns_id"));
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
        ((Intent)localObject2).putExtra("key_card_id", ((f)localObject1).nVh);
        if (!bs.isNullOrNil(dKH().auD(((f)localObject1).nVh))) {
          ((f)localObject1).nWf = dKH().auD(((f)localObject1).nVh);
        }
        ((Intent)localObject2).putExtra("key_card_ext", ((f)localObject1).nWf);
        ((Intent)localObject2).putExtra("key_from_scene", 21);
        ((Intent)localObject2).putExtra("key_stastic_scene", 15);
        com.tencent.mm.br.d.b(this.context, "card", ".ui.CardDetailUI", (Intent)localObject2);
        this.ynh.jo("cardTpId", ((f)localObject1).nVh);
        this.ynh.jo("cardExt", ((f)localObject1).nWf);
        AppMethodBeat.o(200207);
        return;
      }
      if (((p)localObject1).subType == 8) {
        if (((p)this.ymQ instanceof k))
        {
          localObject2 = "";
          if ((!(this.context instanceof Activity)) || (dKH().bizId != 2)) {
            break label1506;
          }
          localObject2 = ((Activity)this.context).getIntent().getStringExtra("sns_landing_pages_sessionId");
        }
      }
      label975:
      label1506:
      for (localObject1 = ((Activity)this.context).getIntent().getStringExtra("sns_landing_pages_ad_buffer");; localObject1 = "")
      {
        localObject1 = String.format("%s:%s:%s:%s:%d:%s:%s:%d", new Object[] { localObject2, localObject1, ((k)(p)this.ymQ).yjs, String.valueOf(System.currentTimeMillis() / 1000L), Integer.valueOf(dKH().bizId), dKH().dtx, Long.valueOf(l), Integer.valueOf(i) });
        localObject2 = (k)this.ymQ;
        q.a(((k)localObject2).username, ((k)localObject2).dxv, "", dKH().yeO, dKH().jyU, (String)localObject1, dKH().dtx, 1084);
        this.ynh.jo("weappUserName", ((k)localObject2).username);
        this.ynh.jo("weappPath", ((k)localObject2).dxv);
        AppMethodBeat.o(200207);
        return;
        if (((p)localObject1).subType == 9)
        {
          localObject1 = (com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.h)localObject1;
          localObject2 = new Intent();
          ((Intent)localObject2).putExtra("map_view_type", 1);
          ((Intent)localObject2).putExtra("kwebmap_slat", ((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.h)localObject1).yiw.tWI);
          ((Intent)localObject2).putExtra("kwebmap_lng", ((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.h)localObject1).yiw.tWJ);
          ((Intent)localObject2).putExtra("kwebmap_scale", ((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.h)localObject1).yiw.dmN);
          ((Intent)localObject2).putExtra("kPoiName", ((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.h)localObject1).yiw.dry);
          ((Intent)localObject2).putExtra("Kwebmap_locaion", ((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.h)localObject1).yiw.tWL);
          ac.i("MicroMsg.Sns.AdLandingPageBtnComponent", "locatint to slat " + ((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.h)localObject1).yiw.tWI + ", slong " + ((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.h)localObject1).yiw.tWJ + ", " + ((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.h)localObject1).yiw.dry);
          com.tencent.mm.br.d.b(this.context, "location", ".ui.RedirectUI", (Intent)localObject2, 2);
          AppMethodBeat.o(200207);
          return;
        }
        if (((p)localObject1).subType == 10)
        {
          if (com.tencent.mm.pluginsdk.ui.span.d.a.DBX == null)
          {
            AppMethodBeat.o(200207);
            return;
          }
          localObject1 = (com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.j)localObject1;
          if (((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.j)localObject1).yip.size() > 1)
          {
            com.tencent.mm.pluginsdk.ui.span.d.a.DBX.a(this.context, ((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.j)localObject1).yip, new e.b()
            {
              public final void onDismiss()
              {
                AppMethodBeat.i(96490);
                al.gh(o.this.context);
                AppMethodBeat.o(96490);
              }
            });
            this.ynh.jo("phonenumber", (String)((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.j)localObject1).yip.get(0));
            AppMethodBeat.o(200207);
            return;
          }
          if (((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.j)localObject1).yip.size() > 0)
          {
            AdLandingPagesProxy.getInstance().confirmDialPhoneNum((Activity)this.context, (String)((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.j)localObject1).yip.get(0));
            this.ynh.jo("phonenumber", (String)((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.j)localObject1).yip.get(0));
          }
          AppMethodBeat.o(200207);
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
            localObject4 = ((p)localObject1).yja;
            str1 = ((p)localObject1).yiX;
            str2 = ((p)localObject1).yiY;
            str3 = ((p)localObject1).yiZ;
            if (((p)localObject1).yiV != 1) {
              break label1018;
            }
            bool1 = true;
            if (((p)localObject1).yiW != 1) {
              break label1024;
            }
            bool2 = true;
            if (((p)this.ymQ).yiU != 1) {
              break label1030;
            }
          }
          for (boolean bool3 = true;; bool3 = false)
          {
            ((SnsAdNativeLandingPagesUI)localObject2).a((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.x)localObject4, str1, str2, str3, bool1, bool2, bool3);
            AppMethodBeat.o(200207);
            return;
            label1018:
            bool1 = false;
            break;
            bool2 = false;
            break label975;
          }
        }
        Object localObject3;
        if (((p)localObject1).subType == 12)
        {
          localObject1 = (m)localObject1;
          ac.i("MicroMsg.Sns.AdLandingPageBtnComponent", "openServiceChat:".concat(String.valueOf(localObject1)));
          try
          {
            if (TextUtils.isEmpty(((m)localObject1).koY)) {
              a((m)localObject1, "");
            }
            for (;;)
            {
              this.ynh.jo("weappid", ((m)localObject1).yiD);
              this.ynh.jo("weappUserName", ((m)localObject1).pis);
              this.ynh.jo("businessId", ((m)localObject1).koY);
              AppMethodBeat.o(200207);
              return;
              if (!TextUtils.isEmpty(((m)localObject1).pis))
              {
                if (ax.isNetworkConnected(this.context)) {
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
              ac.e("MicroMsg.Sns.AdLandingPageBtnComponent", "openServiceChat exp:" + localException.toString());
              continue;
              localObject3 = new b.a();
              ((b.a)localObject3).hvt = new bem();
              ((b.a)localObject3).hvu = new ben();
              ((b.a)localObject3).uri = "/cgi-bin/mmbiz-bin/wxausrevent/getsubbusinessinfo";
              ((b.a)localObject3).funcId = 1303;
              ((b.a)localObject3).reqCmdId = 0;
              ((b.a)localObject3).respCmdId = 0;
              localObject3 = ((b.a)localObject3).aAz();
              localObject4 = (bem)((b)localObject3).hvr.hvw;
              ((bem)localObject4).username = ((m)localObject1).pis;
              ((bem)localObject4).ETU = ((m)localObject1).koY;
              IPCRunCgi.a((b)localObject3, new IPCRunCgi.a()
              {
                public final void a(int paramAnonymousInt1, int paramAnonymousInt2, final String paramAnonymousString, b paramAnonymousb)
                {
                  AppMethodBeat.i(96493);
                  if ((paramAnonymousInt1 != 0) || (paramAnonymousInt2 != 0) || (paramAnonymousb.hvs.hvw == null))
                  {
                    ac.e("MicroMsg.Sns.AdLandingPageBtnComponent", "getsubbusinessinfo cgi failed, errType = %d, errCode = %d, errMsg = %s, rr.resp = %s", new Object[] { Integer.valueOf(paramAnonymousInt1), Integer.valueOf(paramAnonymousInt2), paramAnonymousString, paramAnonymousb.hvs.hvw });
                    ap.f(new Runnable()
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
                  paramAnonymousString = (ben)paramAnonymousb.hvs.hvw;
                  ac.i("MicroMsg.Sns.AdLandingPageBtnComponent", "getsubbusinessinfo cgi success, subBusinessUsername:%s", new Object[] { paramAnonymousString.ETV });
                  ap.f(new Runnable()
                  {
                    public final void run()
                    {
                      AppMethodBeat.i(96492);
                      o.this.a(o.6.this.ynm, paramAnonymousString.ETV);
                      AppMethodBeat.o(96492);
                    }
                  });
                  AppMethodBeat.o(96493);
                }
              });
            }
          }
        }
        if (((p)localObject1).subType == 16)
        {
          localObject3 = (aa)localObject1;
          if (((aa)localObject3).yjF != null)
          {
            localObject1 = dKH().yka;
            if (TextUtils.isEmpty((CharSequence)localObject1))
            {
              localObject1 = dKH().dtx;
              ac.i("MicroMsg.Sns.AdLandingPageBtnComponent", "jumpScanUI, use old uxInfo=".concat(String.valueOf(localObject1)));
            }
            for (;;)
            {
              com.tencent.mm.plugin.sns.ad.a.a.a(this.context, ((aa)localObject3).yjF, (String)localObject1);
              AppMethodBeat.o(200207);
              return;
              ac.i("MicroMsg.Sns.AdLandingPageBtnComponent", "jumpScanUI, use new uxInfo=".concat(String.valueOf(localObject1)));
            }
          }
          ac.e("MicroMsg.Sns.AdLandingPageBtnComponent", "scanJumpInfo == null");
          AppMethodBeat.o(200207);
          return;
        }
        localObject1 = ((p)localObject1).yiL;
        this.ynh.jo("btnJumpUrl", (String)localObject1);
        com.tencent.mm.plugin.sns.data.j.a(this.context, (String)localObject1, dKH(), i, l, ((p)this.ymQ).yjs);
        AppMethodBeat.o(200207);
        return;
      }
      label1024:
      label1030:
      i = 0;
    }
  }
  
  protected final int getLayout()
  {
    return 2131495498;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.o
 * JD-Core Version:    0.7.0.1
 */