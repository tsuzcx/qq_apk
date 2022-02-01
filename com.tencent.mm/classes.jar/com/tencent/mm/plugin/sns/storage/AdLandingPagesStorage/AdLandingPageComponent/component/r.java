package com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component;

import android.annotation.TargetApi;
import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.Color;
import android.graphics.drawable.ClipDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.graphics.drawable.LayerDrawable;
import android.graphics.drawable.StateListDrawable;
import android.net.Uri;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.Button;
import android.widget.RelativeLayout.LayoutParams;
import com.tencent.mars.comm.NetStatusUtil;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.sns.data.j;
import com.tencent.mm.plugin.sns.device.appstore.a;
import com.tencent.mm.plugin.sns.model.AdLandingPagesProxy;
import com.tencent.mm.plugin.sns.model.AdLandingPagesProxy.a;
import com.tencent.mm.plugin.sns.model.AdLandingPagesProxy.e;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.a.d.a;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.ae;
import com.tencent.mm.plugin.sns.ui.widget.SnsTextProgressBar;
import com.tencent.mm.sdk.d.c;
import com.tencent.mm.sdk.d.d.c;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aq;
import com.tencent.mm.sdk.platformtools.bt;
import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

public final class r
  extends o
  implements Serializable
{
  String appId;
  String dFy;
  String dzb;
  private View zEn;
  Button zEo;
  private SnsTextProgressBar zEp;
  a zEq;
  private HandlerThread zEr;
  private b zEs;
  boolean zEt;
  boolean zEu;
  private View.OnClickListener zEv;
  AdLandingPagesProxy.e zEw;
  String zeg;
  
  public r(Context paramContext, com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.b paramb, ViewGroup paramViewGroup)
  {
    super(paramContext, paramb, paramViewGroup);
    AppMethodBeat.i(96554);
    this.zEu = true;
    this.appId = "";
    this.dFy = "";
    this.zeg = "";
    this.dzb = "";
    this.zEv = new r.1(this);
    this.zEw = new r.2(this);
    ad.d("MicroMsg.AdLandingPageDownloadApkBtnComp.state", "component create, new BtnStateMachine");
    this.zEr = com.tencent.e.c.d.aZD("apkStateMachine");
    this.zEr.start();
    this.zEq = new a("apkStateMachine", this.zEr.getLooper());
    if ((paramContext instanceof Activity))
    {
      this.zEt = ((Activity)paramContext).getIntent().getBooleanExtra("sns_landing_pages_auto_download_for_action_btn", false);
      this.zEu = true;
      ad.i("MicroMsg.AdLandingPageDownloadApkBtnComp", "autoDownloadFromActionBtn=" + this.zEt + ", activity=" + paramContext + ", idx=" + ((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.b)this.zDK).zyq + ", appId=" + ((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.b)this.zDK).duW + ", wxAppid=" + ((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.b)this.zDK).zyb + ", useGameDownloader=" + ((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.b)this.zDK).zyc + ", pkg=" + ((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.b)this.zDK).Lw);
    }
    this.zEb.bl("platform", paramb.zyf);
    this.zEb.jB("appid", paramb.duW);
    this.zEb.jB("channelId", paramb.channelId);
    this.zEb.jB("pkg", paramb.Lw);
    this.zEb.jB("appPageUrlAndroid", paramb.zve);
    try
    {
      this.appId = bt.nullAsNil(((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.b)this.zDK).duW);
      this.dFy = bt.nullAsNil(dWZ().dFy);
      this.zeg = bt.nullAsNil(dWZ().zeg);
      this.dzb = dWZ().getSnsId();
      AppMethodBeat.o(96554);
      return;
    }
    catch (Throwable paramContext)
    {
      ad.e("MicroMsg.AdLandingPageDownloadApkBtnComp.DownloadToastReport", paramContext.toString());
      AppMethodBeat.o(96554);
    }
  }
  
  private static String jz(String paramString1, String paramString2)
  {
    AppMethodBeat.i(96561);
    if (bt.isNullOrNil(paramString1))
    {
      AppMethodBeat.o(96561);
      return paramString2;
    }
    if (paramString1.matches("#[0-9A-Fa-f]{6}([0-9A-Fa-f]{2})?"))
    {
      AppMethodBeat.o(96561);
      return paramString1;
    }
    AppMethodBeat.o(96561);
    return paramString2;
  }
  
  @TargetApi(17)
  public final void dRk()
  {
    AppMethodBeat.i(96556);
    this.clickCount = 0;
    Object localObject = this.contentView;
    this.zEn = ((View)localObject).findViewById(2131299227);
    this.zEo = ((Button)((View)localObject).findViewById(2131299195));
    this.zEo.setOnClickListener(this.zEv);
    this.zEp = ((SnsTextProgressBar)((View)localObject).findViewById(2131299215));
    this.zEp.setProgress(0);
    this.zEp.setVisibility(8);
    this.zEp.setOnClickListener(this.zEv);
    ad.d("MicroMsg.AdLandingPageDownloadApkBtnComp.state", "createView, BtnStateMachine start");
    this.zEq.start();
    try
    {
      localObject = (com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.b)this.zDK;
      if (((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.b)localObject).zyt > 0)
      {
        if (!a.aJ(((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.b)localObject).zyu)) {
          break label167;
        }
        k.a(dWZ(), 4, "0", "");
      }
      for (;;)
      {
        k.a(dWZ(), 1, "1", "");
        AppMethodBeat.o(96556);
        return;
        label167:
        k.a(dWZ(), 4, "1", "");
      }
      return;
    }
    catch (Exception localException)
    {
      ad.w("MicroMsg.AdLandingPageDownloadApkBtnComp", "report19790 has something wrong");
      AppMethodBeat.o(96556);
    }
  }
  
  protected final void dRl()
  {
    AppMethodBeat.i(96555);
    Object localObject1 = new HashMap();
    ((Map)localObject1).put("fontNormalColor", jz(((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.b)this.zDK).zyn, "#FFFFFF"));
    ((Map)localObject1).put("fontDisableColor", jz(((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.b)this.zDK).zyo, "#4CFFFFFF"));
    ((Map)localObject1).put("fontPressedColor", jz(((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.b)this.zDK).zyp, "#99FFFFFF"));
    ((Map)localObject1).put("NormalColor", jz(((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.b)this.zDK).zyh, "#1AAD19"));
    ((Map)localObject1).put("PressedColor", jz(((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.b)this.zDK).zyj, "#179B16"));
    ((Map)localObject1).put("DisableColor", jz(((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.b)this.zDK).zyi, "#661AAD19"));
    ((Map)localObject1).put("borderNormalColor", jz(((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.b)this.zDK).zyk, "#179E16"));
    ((Map)localObject1).put("borderPressedColor", jz(((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.b)this.zDK).zym, "#158E14"));
    ((Map)localObject1).put("borderDisableColor", jz(((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.b)this.zDK).zyl, "#00179E16"));
    int j = Color.parseColor((String)((Map)localObject1).get("fontNormalColor"));
    int k = Color.parseColor((String)((Map)localObject1).get("fontDisableColor"));
    int m = Color.parseColor((String)((Map)localObject1).get("fontPressedColor"));
    int n = Color.parseColor((String)((Map)localObject1).get("NormalColor"));
    int i1 = Color.parseColor((String)((Map)localObject1).get("PressedColor"));
    int i2 = Color.parseColor((String)((Map)localObject1).get("DisableColor"));
    int i3 = (int)((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.b)this.zDK).zyW;
    int i4 = Color.parseColor((String)((Map)localObject1).get("borderNormalColor"));
    int i5 = Color.parseColor((String)((Map)localObject1).get("borderPressedColor"));
    int i6 = Color.parseColor((String)((Map)localObject1).get("borderDisableColor"));
    int i = this.context.getResources().getDimensionPixelSize(2131165207);
    if (((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.b)this.zDK).tm > 0.0F) {
      i = (int)((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.b)this.zDK).tm;
    }
    localObject1 = new GradientDrawable();
    ((GradientDrawable)localObject1).setShape(0);
    ((GradientDrawable)localObject1).setCornerRadius(i);
    ((GradientDrawable)localObject1).setColor(i2);
    ((GradientDrawable)localObject1).setStroke(i3, i6);
    Object localObject2 = new GradientDrawable();
    ((GradientDrawable)localObject2).setShape(0);
    ((GradientDrawable)localObject2).setCornerRadius(i);
    ((GradientDrawable)localObject2).setColor(i1);
    ((GradientDrawable)localObject2).setStroke(i3, i5);
    GradientDrawable localGradientDrawable = new GradientDrawable();
    localGradientDrawable.setShape(0);
    localGradientDrawable.setCornerRadius(i);
    localGradientDrawable.setColor(n);
    localGradientDrawable.setStroke(i3, i4);
    StateListDrawable localStateListDrawable = new StateListDrawable();
    localStateListDrawable.addState(new int[] { -16842910 }, (Drawable)localObject1);
    localStateListDrawable.addState(new int[] { 16842919 }, (Drawable)localObject2);
    localStateListDrawable.addState(new int[] { 16842910 }, localGradientDrawable);
    this.zEo.setBackground(localStateListDrawable);
    localObject1 = new int[] { -16842910 };
    this.zEo.setTextColor(new ColorStateList(new int[][] { localObject1, { 16842919 }, { 16842910 } }, new int[] { k, m, j }));
    if (((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.b)this.zDK).fontSize > 0.0F) {
      this.zEo.setTextSize(0, ((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.b)this.zDK).fontSize);
    }
    localObject1 = new GradientDrawable();
    ((GradientDrawable)localObject1).setShape(0);
    ((GradientDrawable)localObject1).setCornerRadius(i);
    ((GradientDrawable)localObject1).setColor(i1);
    ((GradientDrawable)localObject1).setStroke(i3, i5);
    localObject2 = new GradientDrawable();
    ((GradientDrawable)localObject2).setShape(0);
    ((GradientDrawable)localObject2).setCornerRadius(i);
    ((GradientDrawable)localObject2).setColor(n);
    localObject2 = new ClipDrawable((Drawable)localObject2, 3, 1);
    localGradientDrawable = new GradientDrawable();
    localGradientDrawable.setShape(0);
    localGradientDrawable.setCornerRadius(i);
    localGradientDrawable.setColor(n);
    localObject1 = new LayerDrawable(new Drawable[] { localObject1, localObject2, new ClipDrawable(localGradientDrawable, 3, 1) });
    ((LayerDrawable)localObject1).setId(0, 16908288);
    ((LayerDrawable)localObject1).setId(1, 16908303);
    ((LayerDrawable)localObject1).setId(2, 16908301);
    this.zEp.setProgressDrawable((Drawable)localObject1);
    this.zEp.setPaintColor(((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.b)this.zDK).zyp);
    if (((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.b)this.zDK).height > 0.0F)
    {
      localObject1 = (RelativeLayout.LayoutParams)this.zEn.getLayoutParams();
      ((RelativeLayout.LayoutParams)localObject1).height = ((int)((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.b)this.zDK).height);
      this.zEn.setLayoutParams((ViewGroup.LayoutParams)localObject1);
    }
    this.zEo.setText(((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.b)this.zDK).title);
    ad.d("MicroMsg.AdLandingPageDownloadApkBtnComp.state", "fillItem, sendMsg=11");
    this.zEq.aaA(11);
    AppMethodBeat.o(96555);
  }
  
  public final void dRm()
  {
    AppMethodBeat.i(96557);
    super.dRm();
    ad.d("MicroMsg.AdLandingPageDownloadApkBtnComp.state", "viewWillAppear, sendMsg=2");
    this.zEq.aaA(2);
    AdLandingPagesProxy.getInstance().addReportInfo(((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.b)this.zDK).duW, dWZ().zuP, dWZ().jSR, dWZ().dFy);
    AppMethodBeat.o(96557);
  }
  
  public final void dRo()
  {
    AppMethodBeat.i(96558);
    super.dRo();
    ad.i("MicroMsg.AdLandingPageDownloadApkBtnComp", "view destroy");
    this.zEr.quit();
    if (this.zEs != null)
    {
      this.context.unregisterReceiver(this.zEs);
      this.zEs = null;
    }
    AppMethodBeat.o(96558);
  }
  
  public final void dXh()
  {
    AppMethodBeat.i(96560);
    ad.d("MicroMsg.AdLandingPageDownloadApkBtnComp", "writing deferred deep link");
    AdLandingPagesProxy.getInstance().writeDeferredDeepLink(((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.b)this.zDK).Lw, ((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.b)this.zDK).zve);
    j.jg(((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.b)this.zDK).Lw, ((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.b)this.zDK).zve);
    AppMethodBeat.o(96560);
  }
  
  protected final int getLayout()
  {
    return 2131495490;
  }
  
  final class a
    extends com.tencent.mm.sdk.d.d
    implements Serializable
  {
    c zEA;
    c zEB;
    c zEC;
    c zED;
    c zEE;
    c zEF;
    c zEG;
    c zEy;
    c zEz;
    
    protected a(String paramString, Looper paramLooper)
    {
      super(paramLooper);
      AppMethodBeat.i(96551);
      this.zEy = new c();
      this.zEz = new g();
      this.zEA = new e();
      this.zEB = new h();
      this.zEC = new i();
      this.zED = new f();
      this.zEE = new b();
      this.zEF = new a();
      this.zEG = new d();
      a(this.zEz);
      a(this.zEy);
      a(this.zEA);
      a(this.zEB);
      a(this.zEC);
      a(this.zED);
      a(this.zEE);
      a(this.zEF);
      a(this.zEG);
      b(this.zEG);
      AppMethodBeat.o(96551);
    }
    
    final class a
      extends com.tencent.mm.sdk.d.b
    {
      a() {}
      
      public final void enter()
      {
        AppMethodBeat.i(96513);
        super.enter();
        ad.d("MicroMsg.AdLandingPageDownloadApkBtnComp.state", "DisableUnsupportPlatformState enter, idx=" + r.b(r.this).zyq);
        aq.f(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(96512);
            r.c(r.this).setVisibility(8);
            r.d(r.this).setEnabled(false);
            Button localButton = r.d(r.this);
            if (!TextUtils.isEmpty(r.b(r.this).zyg)) {}
            for (String str = r.b(r.this).zyg;; str = "暂不支持安卓手机")
            {
              localButton.setText(str);
              r.d(r.this).setVisibility(0);
              AppMethodBeat.o(96512);
              return;
            }
          }
        });
        AppMethodBeat.o(96513);
      }
    }
    
    final class b
      extends com.tencent.mm.sdk.d.b
    {
      b() {}
      
      public final void enter()
      {
        AppMethodBeat.i(96515);
        super.enter();
        ad.d("MicroMsg.AdLandingPageDownloadApkBtnComp.state", "DoNetSceneState enter, idx=" + r.b(r.this).zyq);
        AdLandingPagesProxy.getInstance().doAdChannelScene(r.b(r.this).Lw, r.b(r.this).channelId, r.this.zEw, r.b(r.this).zyc);
        ad.i("LogStateTransitionState", "[DoNetSceneState], appid=" + r.b(r.this).duW + ", pkg=" + r.b(r.this).Lw + ", channelId=" + r.b(r.this).channelId + ", useGameDownloadWidget=" + r.b(r.this).zyc + ", hash=" + hashCode());
        AppMethodBeat.o(96515);
      }
      
      public final boolean k(Message paramMessage)
      {
        AppMethodBeat.i(96514);
        ad.d("MicroMsg.AdLandingPageDownloadApkBtnComp.state", "DoNetSceneState msg=" + paramMessage.what + ", idx=" + r.b(r.this).zyq);
        ad.i("LogStateTransitionState", hashCode() + "[DoNetSceneState]recv msg.what " + paramMessage.what);
        if (AdLandingPagesProxy.getInstance().isApkExist(r.b(r.this).duW))
        {
          r.a.this.b(r.a.this.zEB);
          AppMethodBeat.o(96514);
          return true;
        }
        switch (paramMessage.what)
        {
        case 7: 
        case 8: 
        case 9: 
        default: 
          AppMethodBeat.o(96514);
          return false;
        case 6: 
          r.a.this.b(r.a.this.zEz);
          AppMethodBeat.o(96514);
          return true;
        case 5: 
          r.a.a(r.a.this, r.this.context.getString(2131763750));
          r.a.this.b(r.a.this.zED);
          AppMethodBeat.o(96514);
          return true;
        }
        r.a.this.b(r.a.this.zEz);
        AppMethodBeat.o(96514);
        return true;
      }
    }
    
    final class c
      extends com.tencent.mm.sdk.d.b
    {
      AdLandingPagesProxy.a zEL;
      
      c() {}
      
      public final void enter()
      {
        AppMethodBeat.i(96527);
        super.enter();
        ad.d("MicroMsg.AdLandingPageDownloadApkBtnComp.state", "DownloadingState enter, idx=" + r.b(r.this).zyq);
        aq.f(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(96516);
            r.d(r.this).setVisibility(8);
            r.c(r.this).setVisibility(0);
            AppMethodBeat.o(96516);
          }
        });
        if ((AdLandingPagesProxy.getInstance().isPaused(r.b(r.this).duW)) || (AdLandingPagesProxy.getInstance().isDownloading(r.b(r.this).duW)))
        {
          if (this.zEL == null) {
            this.zEL = new a((byte)0);
          }
          aq.f(new Runnable()
          {
            public final void run()
            {
              AppMethodBeat.i(96517);
              r.c(r.this).setProgress(AdLandingPagesProxy.getInstance().getTaskProgress(r.b(r.this).duW));
              AppMethodBeat.o(96517);
            }
          });
          if (!AdLandingPagesProxy.getInstance().resumeTask(r.b(r.this).duW, this.zEL, r.this.dWZ().zuP, r.this.dWZ().jSR, r.this.dWZ().dFy))
          {
            AdLandingPagesProxy.getInstance().stopTask(r.b(r.this).duW);
            r.a.this.b(r.a.this.zEy);
            AppMethodBeat.o(96527);
          }
        }
        else
        {
          if (TextUtils.isEmpty(r.b(r.this).downloadUrl))
          {
            r.a.this.b(r.a.this.zEE);
            AppMethodBeat.o(96527);
            return;
          }
          if (AdLandingPagesProxy.getInstance().isApkExist(r.b(r.this).duW))
          {
            aq.f(new Runnable()
            {
              public final void run()
              {
                AppMethodBeat.i(96518);
                r.c(r.this).setProgress(100);
                AppMethodBeat.o(96518);
              }
            });
            r.a.this.b(r.a.this.zEB);
            AppMethodBeat.o(96527);
            return;
          }
          AdLandingPagesProxy.getInstance().stopTask(r.b(r.this).duW);
          this.zEL = new a((byte)0);
          AdLandingPagesProxy.getInstance().startDownload(r.b(r.this).duW, r.b(r.this).zyb, r.b(r.this).Lw, r.b(r.this).md5, r.b(r.this).downloadUrl, r.b(r.this).zyd, r.b(r.this).zye, this.zEL, r.this.dWZ().zuP, r.this.dWZ().jSR, r.this.dWZ().dFy, r.b(r.this).zyc);
        }
        AppMethodBeat.o(96527);
      }
      
      public final boolean k(Message paramMessage)
      {
        AppMethodBeat.i(96528);
        if (paramMessage.what != 1) {
          ad.d("MicroMsg.AdLandingPageDownloadApkBtnComp.state", "DownloadingState, msg=" + paramMessage.what + ", idx=" + r.b(r.this).zyq);
        }
        ad.i("LogStateTransitionState", hashCode() + "[DownloadingState] recv msg.what " + paramMessage.what);
        switch (paramMessage.what)
        {
        case 2: 
        case 4: 
        case 5: 
        case 6: 
        default: 
          AppMethodBeat.o(96528);
          return false;
        case 0: 
          if ((AdLandingPagesProxy.getInstance().pauseTask(r.b(r.this).duW)) && (AdLandingPagesProxy.getInstance().isPaused(r.b(r.this).duW))) {
            r.a.this.b(r.a.this.zEA);
          }
          AppMethodBeat.o(96528);
          return true;
        case 1: 
          aq.f(new Runnable()
          {
            public final void run()
            {
              AppMethodBeat.i(96519);
              if (this.val$progress >= 0) {
                r.c(r.this).setProgress(this.val$progress);
              }
              AppMethodBeat.o(96519);
            }
          });
          AppMethodBeat.o(96528);
          return true;
        case 3: 
          r.a.this.b(r.a.this.zEC);
          AppMethodBeat.o(96528);
          return true;
        case 7: 
          r.a.this.b(r.a.this.zEA);
          AppMethodBeat.o(96528);
          return true;
        case 8: 
          r.a.a(r.a.this, r.this.context.getString(2131763750));
          r.a.this.b(r.a.this.zED);
          AppMethodBeat.o(96528);
          return true;
        }
        r.this.dXh();
        r.a.this.b(r.a.this.zEB);
        AppMethodBeat.o(96528);
        return true;
      }
      
      final class a
        implements AdLandingPagesProxy.a
      {
        private a() {}
        
        public final void PN(int paramInt)
        {
          AppMethodBeat.i(96521);
          if (paramInt % 20 == 0) {
            ad.d("MicroMsg.AdLandingPageDownloadApkBtnComp.callback", "progress:" + paramInt + ", idx=" + r.b(r.this).zyq);
          }
          r.a locala = r.a(r.this);
          d.c localc = locala.IgU;
          if (localc != null) {
            localc.sendMessage(Message.obtain(locala.IgU, 1, paramInt, 0));
          }
          AppMethodBeat.o(96521);
        }
        
        public final void dTh()
        {
          AppMethodBeat.i(96522);
          ad.d("MicroMsg.AdLandingPageDownloadApkBtnComp.callback", "paused, idx=" + r.b(r.this).zyq);
          r.a(r.this).aaA(7);
          AppMethodBeat.o(96522);
        }
        
        public final void dTi()
        {
          AppMethodBeat.i(96523);
          ad.d("MicroMsg.AdLandingPageDownloadApkBtnComp.callback", "stopped, idx=" + r.b(r.this).zyq);
          AppMethodBeat.o(96523);
        }
        
        public final void dTj()
        {
          AppMethodBeat.i(96524);
          ad.d("MicroMsg.AdLandingPageDownloadApkBtnComp.callback", "succeed, idx=" + r.b(r.this).zyq);
          r.a(r.this).aaA(9);
          AppMethodBeat.o(96524);
        }
        
        public final void dTk()
        {
          AppMethodBeat.i(96525);
          ad.d("MicroMsg.AdLandingPageDownloadApkBtnComp.callback", "failed, idx=" + r.b(r.this).zyq);
          r.a(r.this).aaA(8);
          AppMethodBeat.o(96525);
        }
        
        public final void dTl()
        {
          AppMethodBeat.i(96526);
          ad.d("MicroMsg.AdLandingPageDownloadApkBtnComp.callback", "resumed, idx=" + r.b(r.this).zyq);
          r.a(r.this).aaA(13);
          AppMethodBeat.o(96526);
        }
        
        public final void start()
        {
          AppMethodBeat.i(96520);
          ad.d("MicroMsg.AdLandingPageDownloadApkBtnComp.callback", "start, idx=" + r.b(r.this).zyq);
          AppMethodBeat.o(96520);
        }
      }
    }
    
    final class d
      extends com.tencent.mm.sdk.d.b
    {
      d() {}
      
      public final void enter()
      {
        AppMethodBeat.i(96529);
        super.enter();
        ad.d("MicroMsg.AdLandingPageDownloadApkBtnComp.state", "InitState enter, idx=" + r.b(r.this).zyq);
        com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.b localb = r.b(r.this);
        int i;
        if ((localb.zyf == 0) || (localb.zyf == 2)) {
          i = 1;
        }
        while (i != 0) {
          if (AdLandingPagesProxy.getInstance().isApkExist(r.b(r.this).duW))
          {
            r.a.this.b(r.a.this.zEB);
            AppMethodBeat.o(96529);
            return;
            i = 0;
          }
          else
          {
            if (AdLandingPagesProxy.getInstance().isPkgInstalled(r.b(r.this).Lw))
            {
              r.a.this.b(r.a.this.zEC);
              AppMethodBeat.o(96529);
              return;
            }
            r.a.this.b(r.a.this.zEE);
            AppMethodBeat.o(96529);
            return;
          }
        }
        r.a.this.b(r.a.this.zEF);
        AppMethodBeat.o(96529);
      }
    }
    
    final class e
      extends com.tencent.mm.sdk.d.b
    {
      e() {}
      
      public final void enter()
      {
        AppMethodBeat.i(96532);
        super.enter();
        ad.d("MicroMsg.AdLandingPageDownloadApkBtnComp.state", "PauseState enter, idx=" + r.b(r.this).zyq);
        aq.f(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(96530);
            r.c(r.this).setVisibility(8);
            r.d(r.this).setVisibility(0);
            r.d(r.this).setText(2131763749);
            AppMethodBeat.o(96530);
          }
        });
        AppMethodBeat.o(96532);
      }
      
      public final boolean k(Message paramMessage)
      {
        AppMethodBeat.i(96533);
        ad.d("MicroMsg.AdLandingPageDownloadApkBtnComp.state", "PauseState, msg=" + paramMessage.what + ", idx=" + r.b(r.this).zyq);
        ad.i("LogStateTransitionState", hashCode() + "[PauseState] recv msg.what " + paramMessage.what);
        switch (paramMessage.what)
        {
        default: 
          AppMethodBeat.o(96533);
          return false;
        case 0: 
          if (AdLandingPagesProxy.getInstance().isDownloading(r.b(r.this).duW)) {
            r.a.a(r.a.this, r.this.context.getString(2131763748));
          }
          for (;;)
          {
            AppMethodBeat.o(96533);
            return true;
            if (!NetStatusUtil.isWifi(r.this.context))
            {
              ad.i("LogStateTransitionState", "download not in wifi!");
              com.tencent.mm.plugin.sns.data.h.a(r.this.dzb, r.this.appId, 0, 1, r.this.dFy, r.this.zeg, 1);
              com.tencent.mm.ui.base.h.a(r.this.context, 2131766086, 2131766087, new DialogInterface.OnClickListener()
              {
                public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
                {
                  AppMethodBeat.i(96531);
                  r.a.this.aaA(12);
                  com.tencent.mm.plugin.sns.data.h.a(r.f(r.this), r.g(r.this), 1, 1, r.h(r.this), r.i(r.this), 1);
                  com.tencent.mm.modelstat.d.d(10, "AdLandingPageDownloadApkBtnComp_PAUSE_MSG_BTN_CLICK", r.a.e.this.hashCode());
                  AppMethodBeat.o(96531);
                }
              }, null);
            }
            else
            {
              int i = r.b(r.this).zys;
              ad.i("MicroMsg.AdLandingPageDownloadApkBtnComp.GroceryDownload", "showDownloadTip = ".concat(String.valueOf(i)));
              if (i == 1) {
                r.a.a(r.a.this, 1);
              } else {
                r.a.this.aaA(12);
              }
            }
          }
        case 3: 
          r.a.this.b(r.a.this.zEC);
          AppMethodBeat.o(96533);
          return true;
        case 8: 
          r.a.a(r.a.this, r.this.context.getString(2131763750));
          r.a.this.b(r.a.this.zED);
          AppMethodBeat.o(96533);
          return true;
        case 12: 
          r.a.this.b(r.a.this.zEy);
          AppMethodBeat.o(96533);
          return true;
        }
        r.a.this.b(r.a.this.zEy);
        AppMethodBeat.o(96533);
        return true;
      }
    }
    
    final class f
      extends com.tencent.mm.sdk.d.b
    {
      f() {}
      
      public final void enter()
      {
        AppMethodBeat.i(96535);
        super.enter();
        ad.d("MicroMsg.AdLandingPageDownloadApkBtnComp.state", "ReDownloadState enter, idx=" + r.b(r.this).zyq);
        aq.f(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(96534);
            r.c(r.this).setVisibility(8);
            r.d(r.this).setVisibility(0);
            r.d(r.this).setText(2131763755);
            AppMethodBeat.o(96534);
          }
        });
        AppMethodBeat.o(96535);
      }
      
      public final boolean k(Message paramMessage)
      {
        AppMethodBeat.i(96536);
        ad.d("MicroMsg.AdLandingPageDownloadApkBtnComp.state", "ReDownloadState, msg=" + paramMessage.what + ", idx=" + r.b(r.this).zyq);
        ad.i("LogStateTransitionState", hashCode() + "[ReDownloadState] recv msg.what " + paramMessage.what);
        switch (paramMessage.what)
        {
        default: 
          AppMethodBeat.o(96536);
          return false;
        }
        r.a.this.b(r.a.this.zEE);
        AppMethodBeat.o(96536);
        return true;
      }
    }
    
    final class g
      extends com.tencent.mm.sdk.d.b
    {
      g() {}
      
      public final void enter()
      {
        AppMethodBeat.i(96543);
        super.enter();
        ad.d("MicroMsg.AdLandingPageDownloadApkBtnComp.state", "ToDownloadState enter, idx=" + r.b(r.this).zyq);
        aq.f(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(96537);
            if (r.e(r.this) == null)
            {
              r.a(r.this, new r.b(r.this, (byte)0));
              IntentFilter localIntentFilter = new IntentFilter();
              localIntentFilter.addAction("android.intent.action.PACKAGE_ADDED");
              localIntentFilter.addAction("android.intent.action.PACKAGE_REMOVED");
              localIntentFilter.addDataScheme("package");
              r.this.context.registerReceiver(r.e(r.this), localIntentFilter);
            }
            AppMethodBeat.o(96537);
          }
        });
        if (AdLandingPagesProxy.getInstance().isPkgInstalled(r.b(r.this).Lw))
        {
          r.a.this.b(r.a.this.zEC);
          AppMethodBeat.o(96543);
          return;
        }
        if (AdLandingPagesProxy.getInstance().isApkExist(r.b(r.this).duW))
        {
          r.a.this.b(r.a.this.zEB);
          AppMethodBeat.o(96543);
          return;
        }
        if (AdLandingPagesProxy.getInstance().isDownloading(r.b(r.this).duW))
        {
          r.a.this.b(r.a.this.zEy);
          AppMethodBeat.o(96543);
          return;
        }
        if (AdLandingPagesProxy.getInstance().isPaused(r.b(r.this).duW))
        {
          r.a.this.b(r.a.this.zEA);
          AppMethodBeat.o(96543);
          return;
        }
        aq.f(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(96538);
            r.c(r.this).setVisibility(8);
            r.d(r.this).setVisibility(0);
            r.d(r.this).setText(r.b(r.this).title);
            AppMethodBeat.o(96538);
          }
        });
        boolean bool;
        if (r.this.zEt) {
          if (r.this.dWZ().zAQ) {
            bool = r.b(r.this).zyr;
          }
        }
        for (;;)
        {
          if ((bool) && (r.this.zEu))
          {
            r.this.zEu = false;
            aq.o(new Runnable()
            {
              public final void run()
              {
                AppMethodBeat.i(96540);
                try
                {
                  double d = (float)r.b(r.this).fileSize / 1024.0F / 1024.0F;
                  if (d > 0.0D) {
                    str = String.format("%.1f", new Object[] { Double.valueOf(d) });
                  }
                  for (String str = r.this.context.getString(2131763738, new Object[] { r.b(r.this).zyd, str });; str = r.this.context.getString(2131763737, new Object[] { r.b(r.this).zyd }))
                  {
                    com.tencent.mm.plugin.sns.data.h.a(r.f(r.this), r.g(r.this), 0, 0, r.h(r.this), r.i(r.this), 1);
                    com.tencent.mm.ui.base.h.a(r.this.context, str, "", new DialogInterface.OnClickListener()
                    {
                      public final void onClick(DialogInterface paramAnonymous2DialogInterface, int paramAnonymous2Int)
                      {
                        AppMethodBeat.i(96539);
                        r.a(r.this).aaA(0);
                        com.tencent.mm.plugin.sns.data.h.a(r.f(r.this), r.g(r.this), 1, 0, r.h(r.this), r.i(r.this), 1);
                        AppMethodBeat.o(96539);
                      }
                    }, null);
                    AppMethodBeat.o(96540);
                    return;
                  }
                  return;
                }
                catch (Exception localException)
                {
                  ad.e("LogStateTransitionState", "showAutoDownloadDialog exp=" + localException.toString());
                  AppMethodBeat.o(96540);
                }
              }
            }, 800L);
          }
          AppMethodBeat.o(96543);
          return;
          if (r.b(r.this).zyq == 0)
          {
            bool = true;
          }
          else
          {
            bool = false;
            continue;
            bool = false;
          }
        }
      }
      
      public final boolean k(Message paramMessage)
      {
        AppMethodBeat.i(96544);
        ad.d("MicroMsg.AdLandingPageDownloadApkBtnComp.state", "ToDownloadState, msg=" + paramMessage.what + ", idx=" + r.b(r.this).zyq);
        ad.i("LogStateTransitionState", hashCode() + "[ToDownloadState]recv msg.what " + paramMessage.what);
        switch (paramMessage.what)
        {
        default: 
          AppMethodBeat.o(96544);
          return false;
        case 0: 
          if (AdLandingPagesProxy.getInstance().isDownloading(r.b(r.this).duW)) {
            r.a.a(r.a.this, r.this.context.getString(2131763748));
          }
          for (;;)
          {
            AppMethodBeat.o(96544);
            return true;
            aq.f(new Runnable()
            {
              public final void run()
              {
                AppMethodBeat.i(96542);
                if (!NetStatusUtil.isWifi(r.this.context))
                {
                  ad.i("LogStateTransitionState", "download not in wifi!");
                  com.tencent.mm.plugin.sns.data.h.a(r.f(r.this), r.g(r.this), 0, 0, r.h(r.this), r.i(r.this), 1);
                  com.tencent.mm.ui.base.h.a(r.this.context, 2131766086, 2131766087, new DialogInterface.OnClickListener()
                  {
                    public final void onClick(DialogInterface paramAnonymous2DialogInterface, int paramAnonymous2Int)
                    {
                      AppMethodBeat.i(96541);
                      r.a(r.this).aaA(12);
                      com.tencent.mm.plugin.sns.data.h.a(r.f(r.this), r.g(r.this), 1, 0, r.h(r.this), r.i(r.this), 1);
                      com.tencent.mm.modelstat.d.d(10, "AdLandingPageDownloadApkBtnComp_TODOWLOAD_MSG_BTN_CLICK", r.a.g.this.hashCode());
                      AppMethodBeat.o(96541);
                    }
                  }, null);
                  AppMethodBeat.o(96542);
                  return;
                }
                int i = r.b(r.this).zys;
                ad.i("MicroMsg.AdLandingPageDownloadApkBtnComp.GroceryDownload", "showDownloadTip = ".concat(String.valueOf(i)));
                if (i == 1)
                {
                  if (AdLandingPagesProxy.getInstance().isPaused(r.b(r.this).duW))
                  {
                    r.a.a(r.a.this, 1);
                    AppMethodBeat.o(96542);
                    return;
                  }
                  r.a.a(r.a.this, 0);
                  AppMethodBeat.o(96542);
                  return;
                }
                r.a(r.this).aaA(12);
                AppMethodBeat.o(96542);
              }
            });
          }
        case 3: 
          r.a.this.b(r.a.this.zEC);
          AppMethodBeat.o(96544);
          return true;
        case 11: 
          r.a.this.b(r.a.this.zEz);
          AppMethodBeat.o(96544);
          return true;
        }
        r.a.this.b(r.a.this.zEy);
        AppMethodBeat.o(96544);
        return true;
      }
    }
    
    final class h
      extends com.tencent.mm.sdk.d.b
    {
      private boolean zES;
      
      h() {}
      
      public final void enter()
      {
        AppMethodBeat.i(96546);
        ad.d("MicroMsg.AdLandingPageDownloadApkBtnComp.state", "ToInstallState enter, idx=" + r.b(r.this).zyq);
        super.enter();
        if (!AdLandingPagesProxy.getInstance().isApkExist(r.b(r.this).duW))
        {
          r.a.this.b(r.a.this.zEz);
          AppMethodBeat.o(96546);
          return;
        }
        aq.f(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(96545);
            r.c(r.this).setVisibility(8);
            r.d(r.this).setVisibility(0);
            r.d(r.this).setText(2131763751);
            AppMethodBeat.o(96545);
          }
        });
        this.zES = true;
        AppMethodBeat.o(96546);
      }
      
      public final boolean k(Message paramMessage)
      {
        AppMethodBeat.i(96547);
        ad.d("MicroMsg.AdLandingPageDownloadApkBtnComp.state", "ToInstallState, msg=" + paramMessage.what + ", idx=" + r.b(r.this).zyq);
        ad.i("LogStateTransitionState", hashCode() + "[ToInstallState] recv msg.what " + paramMessage.what);
        switch (paramMessage.what)
        {
        case 1: 
        default: 
          AppMethodBeat.o(96547);
          return false;
        case 0: 
          if (AdLandingPagesProxy.getInstance().installApp(r.this.context, r.b(r.this).duW, r.b(r.this).Lw, r.b(r.this).md5, r.b(r.this).downloadUrl))
          {
            this.zES = true;
            AppMethodBeat.o(96547);
            return true;
          }
          r.a.a(r.a.this, r.this.context.getString(2131763752));
          r.a.this.b(r.a.this.zED);
          AppMethodBeat.o(96547);
          return true;
        case 2: 
          if (!AdLandingPagesProxy.getInstance().isApkExist(r.b(r.this).duW)) {
            r.a.this.b(r.a.this.zEz);
          }
          AppMethodBeat.o(96547);
          return true;
        }
        if (this.zES) {
          this.zES = false;
        }
        r.a.this.b(r.a.this.zEC);
        AppMethodBeat.o(96547);
        return true;
      }
    }
    
    final class i
      extends com.tencent.mm.sdk.d.b
    {
      i() {}
      
      public final void enter()
      {
        AppMethodBeat.i(96549);
        super.enter();
        ad.d("MicroMsg.AdLandingPageDownloadApkBtnComp.state", "ToOpenState enter, idx=" + r.b(r.this).zyq);
        if (AdLandingPagesProxy.getInstance().isPkgInstalled(r.b(r.this).Lw))
        {
          aq.f(new Runnable()
          {
            public final void run()
            {
              AppMethodBeat.i(96548);
              r.c(r.this).setVisibility(8);
              r.d(r.this).setVisibility(0);
              r.d(r.this).setText(2131763753);
              AppMethodBeat.o(96548);
            }
          });
          AppMethodBeat.o(96549);
          return;
        }
        r.a.this.b(r.a.this.zEB);
        AppMethodBeat.o(96549);
      }
      
      public final boolean k(Message paramMessage)
      {
        AppMethodBeat.i(96550);
        ad.d("MicroMsg.AdLandingPageDownloadApkBtnComp.state", "ToOpenState, msg=" + paramMessage.what + ", idx=" + r.b(r.this).zyq);
        ad.i("LogStateTransitionState", hashCode() + "[ToOpenState] recv msg.what " + paramMessage.what);
        switch (paramMessage.what)
        {
        default: 
          AppMethodBeat.o(96550);
          return false;
        case 0: 
          if (j.a(r.this.context, r.b(r.this).duW, r.b(r.this).Lw, "", r.b(r.this).zve, r.this.dFy, r.this.zeg, r.this.dzb, 1, 2))
          {
            AppMethodBeat.o(96550);
            return true;
          }
          r.a.a(r.a.this, r.this.context.getString(2131763754));
          r.a.this.b(r.a.this.zEC);
          AppMethodBeat.o(96550);
          return true;
        }
        r.a.this.b(r.a.this.zEz);
        AppMethodBeat.o(96550);
        return true;
      }
    }
  }
  
  final class b
    extends BroadcastReceiver
    implements Serializable
  {
    private b() {}
    
    public final void onReceive(Context paramContext, Intent paramIntent)
    {
      AppMethodBeat.i(96553);
      if (paramIntent != null)
      {
        paramContext = paramIntent.getAction();
        if ("android.intent.action.PACKAGE_ADDED".equals(paramContext))
        {
          paramContext = paramIntent.getData().getSchemeSpecificPart();
          if ((!TextUtils.isEmpty(paramContext)) && (paramContext.equals(r.b(r.this).Lw))) {
            r.this.zEq.aaA(3);
          }
          AppMethodBeat.o(96553);
          return;
        }
        if ("android.intent.action.PACKAGE_REMOVED".equals(paramContext))
        {
          paramContext = paramIntent.getData().getSchemeSpecificPart();
          if ((!TextUtils.isEmpty(paramContext)) && (paramContext.equals(r.b(r.this).Lw))) {
            r.this.zEq.aaA(4);
          }
        }
      }
      AppMethodBeat.o(96553);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.r
 * JD-Core Version:    0.7.0.1
 */