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
import com.tencent.mm.plugin.sns.device.appstore.a;
import com.tencent.mm.plugin.sns.model.AdLandingPagesProxy;
import com.tencent.mm.plugin.sns.model.AdLandingPagesProxy.a;
import com.tencent.mm.plugin.sns.model.AdLandingPagesProxy.e;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.a.d.a;
import com.tencent.mm.plugin.sns.ui.widget.SnsTextProgressBar;
import com.tencent.mm.sdk.d.c;
import com.tencent.mm.sdk.d.d.c;
import com.tencent.mm.sdk.platformtools.aq;
import com.tencent.mm.sdk.platformtools.bt;
import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

public final class q
  extends n
  implements Serializable
{
  String appId;
  String dpC;
  String dvK;
  String wBR;
  private View xaD;
  Button xaE;
  private SnsTextProgressBar xaF;
  a xaG;
  private HandlerThread xaH;
  private b xaI;
  boolean xaJ;
  boolean xaK;
  private View.OnClickListener xaL;
  AdLandingPagesProxy.e xaM;
  
  public q(Context paramContext, com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.b paramb, ViewGroup paramViewGroup)
  {
    super(paramContext, paramb, paramViewGroup);
    AppMethodBeat.i(96554);
    this.xaK = true;
    this.appId = "";
    this.dvK = "";
    this.wBR = "";
    this.dpC = "";
    this.xaL = new q.1(this);
    this.xaM = new q.2(this);
    com.tencent.mm.sdk.platformtools.ad.d("MicroMsg.AdLandingPageDownloadApkBtnComp.state", "component create, new BtnStateMachine");
    this.xaH = com.tencent.e.c.d.aOa("apkStateMachine");
    this.xaH.start();
    this.xaG = new a("apkStateMachine", this.xaH.getLooper());
    if ((paramContext instanceof Activity))
    {
      this.xaJ = ((Activity)paramContext).getIntent().getBooleanExtra("sns_landing_pages_auto_download_for_action_btn", false);
      this.xaK = true;
      com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.AdLandingPageDownloadApkBtnComp", "autoDownloadFromActionBtn=" + this.xaJ + ", activity=" + paramContext + ", idx=" + ((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.b)this.xab).wVu + ", appId=" + ((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.b)this.xab).dlB + ", wxAppid=" + ((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.b)this.xab).wVf + ", useGameDownloader=" + ((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.b)this.xab).wVg + ", pkg=" + ((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.b)this.xab).IK);
    }
    this.xas.bg("platform", paramb.wVj);
    this.xas.iQ("appid", paramb.dlB);
    this.xas.iQ("channelId", paramb.channelId);
    this.xas.iQ("pkg", paramb.IK);
    this.xas.iQ("appPageUrlAndroid", paramb.wSw);
    try
    {
      this.appId = bt.nullAsNil(((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.b)this.xab).dlB);
      this.dvK = bt.nullAsNil(dwi().dvK);
      this.wBR = bt.nullAsNil(dwi().wBR);
      this.dpC = dwi().getSnsId();
      AppMethodBeat.o(96554);
      return;
    }
    catch (Throwable paramContext)
    {
      com.tencent.mm.sdk.platformtools.ad.e("MicroMsg.AdLandingPageDownloadApkBtnComp.DownloadToastReport", paramContext.toString());
      AppMethodBeat.o(96554);
    }
  }
  
  private static String iP(String paramString1, String paramString2)
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
  
  protected final void dvN()
  {
    AppMethodBeat.i(96555);
    Object localObject1 = new HashMap();
    ((Map)localObject1).put("fontNormalColor", iP(((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.b)this.xab).wVr, "#FFFFFF"));
    ((Map)localObject1).put("fontDisableColor", iP(((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.b)this.xab).wVs, "#4CFFFFFF"));
    ((Map)localObject1).put("fontPressedColor", iP(((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.b)this.xab).wVt, "#99FFFFFF"));
    ((Map)localObject1).put("NormalColor", iP(((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.b)this.xab).wVl, "#1AAD19"));
    ((Map)localObject1).put("PressedColor", iP(((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.b)this.xab).wVn, "#179B16"));
    ((Map)localObject1).put("DisableColor", iP(((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.b)this.xab).wVm, "#661AAD19"));
    ((Map)localObject1).put("borderNormalColor", iP(((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.b)this.xab).wVo, "#179E16"));
    ((Map)localObject1).put("borderPressedColor", iP(((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.b)this.xab).wVq, "#158E14"));
    ((Map)localObject1).put("borderDisableColor", iP(((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.b)this.xab).wVp, "#00179E16"));
    int j = Color.parseColor((String)((Map)localObject1).get("fontNormalColor"));
    int k = Color.parseColor((String)((Map)localObject1).get("fontDisableColor"));
    int m = Color.parseColor((String)((Map)localObject1).get("fontPressedColor"));
    int n = Color.parseColor((String)((Map)localObject1).get("NormalColor"));
    int i1 = Color.parseColor((String)((Map)localObject1).get("PressedColor"));
    int i2 = Color.parseColor((String)((Map)localObject1).get("DisableColor"));
    int i3 = (int)((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.b)this.xab).wWa;
    int i4 = Color.parseColor((String)((Map)localObject1).get("borderNormalColor"));
    int i5 = Color.parseColor((String)((Map)localObject1).get("borderPressedColor"));
    int i6 = Color.parseColor((String)((Map)localObject1).get("borderDisableColor"));
    int i = this.context.getResources().getDimensionPixelSize(2131165207);
    if (((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.b)this.xab).qs > 0.0F) {
      i = (int)((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.b)this.xab).qs;
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
    this.xaE.setBackground(localStateListDrawable);
    localObject1 = new int[] { 16842919 };
    this.xaE.setTextColor(new ColorStateList(new int[][] { { -16842910 }, localObject1, { 16842910 } }, new int[] { k, m, j }));
    if (((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.b)this.xab).buK > 0.0F) {
      this.xaE.setTextSize(0, ((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.b)this.xab).buK);
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
    this.xaF.setProgressDrawable((Drawable)localObject1);
    this.xaF.setPaintColor(((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.b)this.xab).wVt);
    if (((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.b)this.xab).height > 0.0F)
    {
      localObject1 = (RelativeLayout.LayoutParams)this.xaD.getLayoutParams();
      ((RelativeLayout.LayoutParams)localObject1).height = ((int)((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.b)this.xab).height);
      this.xaD.setLayoutParams((ViewGroup.LayoutParams)localObject1);
    }
    this.xaE.setText(((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.b)this.xab).title);
    com.tencent.mm.sdk.platformtools.ad.d("MicroMsg.AdLandingPageDownloadApkBtnComp.state", "fillItem, sendMsg=11");
    this.xaG.Wm(11);
    AppMethodBeat.o(96555);
  }
  
  @TargetApi(17)
  public final void dvx()
  {
    AppMethodBeat.i(96556);
    this.clickCount = 0;
    Object localObject = this.contentView;
    this.xaD = ((View)localObject).findViewById(2131299227);
    this.xaE = ((Button)((View)localObject).findViewById(2131299195));
    this.xaE.setOnClickListener(this.xaL);
    this.xaF = ((SnsTextProgressBar)((View)localObject).findViewById(2131299215));
    this.xaF.setProgress(0);
    this.xaF.setVisibility(8);
    this.xaF.setOnClickListener(this.xaL);
    com.tencent.mm.sdk.platformtools.ad.d("MicroMsg.AdLandingPageDownloadApkBtnComp.state", "createView, BtnStateMachine start");
    this.xaG.start();
    try
    {
      localObject = (com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.b)this.xab;
      if (((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.b)localObject).wVx > 0)
      {
        if (!a.aC(((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.b)localObject).wVy)) {
          break label167;
        }
        j.a(dwi(), 4, "0", "");
      }
      for (;;)
      {
        j.a(dwi(), 1, "1", "");
        AppMethodBeat.o(96556);
        return;
        label167:
        j.a(dwi(), 4, "1", "");
      }
      return;
    }
    catch (Exception localException)
    {
      com.tencent.mm.sdk.platformtools.ad.w("MicroMsg.AdLandingPageDownloadApkBtnComp", "report19790 has something wrong");
      AppMethodBeat.o(96556);
    }
  }
  
  public final void dvy()
  {
    AppMethodBeat.i(96558);
    super.dvy();
    com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.AdLandingPageDownloadApkBtnComp", "view destroy");
    this.xaH.quit();
    if (this.xaI != null)
    {
      this.context.unregisterReceiver(this.xaI);
      this.xaI = null;
    }
    AppMethodBeat.o(96558);
  }
  
  public final void dvz()
  {
    AppMethodBeat.i(96557);
    super.dvz();
    com.tencent.mm.sdk.platformtools.ad.d("MicroMsg.AdLandingPageDownloadApkBtnComp.state", "viewWillAppear, sendMsg=2");
    this.xaG.Wm(2);
    AdLandingPagesProxy.getInstance().addReportInfo(((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.b)this.xab).dlB, dwi().wSi, dwi().iYE, dwi().dvK);
    AppMethodBeat.o(96557);
  }
  
  public final void dwq()
  {
    AppMethodBeat.i(96560);
    com.tencent.mm.sdk.platformtools.ad.d("MicroMsg.AdLandingPageDownloadApkBtnComp", "writing deferred deep link");
    AdLandingPagesProxy.getInstance().writeDeferredDeepLink(((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.b)this.xab).IK, ((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.b)this.xab).wSw);
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
    c xaO;
    c xaP;
    c xaQ;
    c xaR;
    c xaS;
    c xaT;
    c xaU;
    c xaV;
    c xaW;
    
    protected a(String paramString, Looper paramLooper)
    {
      super(paramLooper);
      AppMethodBeat.i(96551);
      this.xaO = new c();
      this.xaP = new g();
      this.xaQ = new e();
      this.xaR = new h();
      this.xaS = new i();
      this.xaT = new f();
      this.xaU = new b();
      this.xaV = new a();
      this.xaW = new d();
      a(this.xaP);
      a(this.xaO);
      a(this.xaQ);
      a(this.xaR);
      a(this.xaS);
      a(this.xaT);
      a(this.xaU);
      a(this.xaV);
      a(this.xaW);
      b(this.xaW);
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
        com.tencent.mm.sdk.platformtools.ad.d("MicroMsg.AdLandingPageDownloadApkBtnComp.state", "DisableUnsupportPlatformState enter, idx=" + q.b(q.this).wVu);
        aq.f(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(96512);
            q.c(q.this).setVisibility(8);
            q.d(q.this).setEnabled(false);
            Button localButton = q.d(q.this);
            if (!TextUtils.isEmpty(q.b(q.this).wVk)) {}
            for (String str = q.b(q.this).wVk;; str = "暂不支持安卓手机")
            {
              localButton.setText(str);
              q.d(q.this).setVisibility(0);
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
        com.tencent.mm.sdk.platformtools.ad.d("MicroMsg.AdLandingPageDownloadApkBtnComp.state", "DoNetSceneState enter, idx=" + q.b(q.this).wVu);
        AdLandingPagesProxy.getInstance().doAdChannelScene(q.b(q.this).IK, q.b(q.this).channelId, q.this.xaM, q.b(q.this).wVg);
        com.tencent.mm.sdk.platformtools.ad.i("LogStateTransitionState", "[DoNetSceneState], appid=" + q.b(q.this).dlB + ", pkg=" + q.b(q.this).IK + ", channelId=" + q.b(q.this).channelId + ", useGameDownloadWidget=" + q.b(q.this).wVg + ", hash=" + hashCode());
        AppMethodBeat.o(96515);
      }
      
      public final boolean k(Message paramMessage)
      {
        AppMethodBeat.i(96514);
        com.tencent.mm.sdk.platformtools.ad.d("MicroMsg.AdLandingPageDownloadApkBtnComp.state", "DoNetSceneState msg=" + paramMessage.what + ", idx=" + q.b(q.this).wVu);
        com.tencent.mm.sdk.platformtools.ad.i("LogStateTransitionState", hashCode() + "[DoNetSceneState]recv msg.what " + paramMessage.what);
        if (AdLandingPagesProxy.getInstance().isApkExist(q.b(q.this).dlB))
        {
          q.a.this.b(q.a.this.xaR);
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
          q.a.this.b(q.a.this.xaP);
          AppMethodBeat.o(96514);
          return true;
        case 5: 
          q.a.a(q.a.this, q.this.context.getString(2131763750));
          q.a.this.b(q.a.this.xaT);
          AppMethodBeat.o(96514);
          return true;
        }
        q.a.this.b(q.a.this.xaP);
        AppMethodBeat.o(96514);
        return true;
      }
    }
    
    final class c
      extends com.tencent.mm.sdk.d.b
    {
      AdLandingPagesProxy.a xbb;
      
      c() {}
      
      public final void enter()
      {
        AppMethodBeat.i(96527);
        super.enter();
        com.tencent.mm.sdk.platformtools.ad.d("MicroMsg.AdLandingPageDownloadApkBtnComp.state", "DownloadingState enter, idx=" + q.b(q.this).wVu);
        aq.f(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(96516);
            q.d(q.this).setVisibility(8);
            q.c(q.this).setVisibility(0);
            AppMethodBeat.o(96516);
          }
        });
        if ((AdLandingPagesProxy.getInstance().isPaused(q.b(q.this).dlB)) || (AdLandingPagesProxy.getInstance().isDownloading(q.b(q.this).dlB)))
        {
          if (this.xbb == null) {
            this.xbb = new a((byte)0);
          }
          aq.f(new Runnable()
          {
            public final void run()
            {
              AppMethodBeat.i(96517);
              q.c(q.this).setProgress(AdLandingPagesProxy.getInstance().getTaskProgress(q.b(q.this).dlB));
              AppMethodBeat.o(96517);
            }
          });
          if (!AdLandingPagesProxy.getInstance().resumeTask(q.b(q.this).dlB, this.xbb, q.this.dwi().wSi, q.this.dwi().iYE, q.this.dwi().dvK))
          {
            AdLandingPagesProxy.getInstance().stopTask(q.b(q.this).dlB);
            q.a.this.b(q.a.this.xaO);
            AppMethodBeat.o(96527);
          }
        }
        else
        {
          if (TextUtils.isEmpty(q.b(q.this).downloadUrl))
          {
            q.a.this.b(q.a.this.xaU);
            AppMethodBeat.o(96527);
            return;
          }
          if (AdLandingPagesProxy.getInstance().isApkExist(q.b(q.this).dlB))
          {
            aq.f(new Runnable()
            {
              public final void run()
              {
                AppMethodBeat.i(96518);
                q.c(q.this).setProgress(100);
                AppMethodBeat.o(96518);
              }
            });
            q.a.this.b(q.a.this.xaR);
            AppMethodBeat.o(96527);
            return;
          }
          AdLandingPagesProxy.getInstance().stopTask(q.b(q.this).dlB);
          this.xbb = new a((byte)0);
          AdLandingPagesProxy.getInstance().startDownload(q.b(q.this).dlB, q.b(q.this).wVf, q.b(q.this).IK, q.b(q.this).md5, q.b(q.this).downloadUrl, q.b(q.this).wVh, q.b(q.this).wVi, this.xbb, q.this.dwi().wSi, q.this.dwi().iYE, q.this.dwi().dvK, q.b(q.this).wVg);
        }
        AppMethodBeat.o(96527);
      }
      
      public final boolean k(Message paramMessage)
      {
        AppMethodBeat.i(96528);
        if (paramMessage.what != 1) {
          com.tencent.mm.sdk.platformtools.ad.d("MicroMsg.AdLandingPageDownloadApkBtnComp.state", "DownloadingState, msg=" + paramMessage.what + ", idx=" + q.b(q.this).wVu);
        }
        com.tencent.mm.sdk.platformtools.ad.i("LogStateTransitionState", hashCode() + "[DownloadingState] recv msg.what " + paramMessage.what);
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
          if ((AdLandingPagesProxy.getInstance().pauseTask(q.b(q.this).dlB)) && (AdLandingPagesProxy.getInstance().isPaused(q.b(q.this).dlB))) {
            q.a.this.b(q.a.this.xaQ);
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
                q.c(q.this).setProgress(this.val$progress);
              }
              AppMethodBeat.o(96519);
            }
          });
          AppMethodBeat.o(96528);
          return true;
        case 3: 
          q.a.this.b(q.a.this.xaS);
          AppMethodBeat.o(96528);
          return true;
        case 7: 
          q.a.this.b(q.a.this.xaQ);
          AppMethodBeat.o(96528);
          return true;
        case 8: 
          q.a.a(q.a.this, q.this.context.getString(2131763750));
          q.a.this.b(q.a.this.xaT);
          AppMethodBeat.o(96528);
          return true;
        }
        q.this.dwq();
        q.a.this.b(q.a.this.xaR);
        AppMethodBeat.o(96528);
        return true;
      }
      
      final class a
        implements AdLandingPagesProxy.a
      {
        private a() {}
        
        public final void Me(int paramInt)
        {
          AppMethodBeat.i(96521);
          if (paramInt % 20 == 0) {
            com.tencent.mm.sdk.platformtools.ad.d("MicroMsg.AdLandingPageDownloadApkBtnComp.callback", "progress:" + paramInt + ", idx=" + q.b(q.this).wVu);
          }
          q.a locala = q.a(q.this);
          d.c localc = locala.EXN;
          if (localc != null) {
            localc.sendMessage(Message.obtain(locala.EXN, 1, paramInt, 0));
          }
          AppMethodBeat.o(96521);
        }
        
        public final void dsv()
        {
          AppMethodBeat.i(96522);
          com.tencent.mm.sdk.platformtools.ad.d("MicroMsg.AdLandingPageDownloadApkBtnComp.callback", "paused, idx=" + q.b(q.this).wVu);
          q.a(q.this).Wm(7);
          AppMethodBeat.o(96522);
        }
        
        public final void dsw()
        {
          AppMethodBeat.i(96523);
          com.tencent.mm.sdk.platformtools.ad.d("MicroMsg.AdLandingPageDownloadApkBtnComp.callback", "stopped, idx=" + q.b(q.this).wVu);
          AppMethodBeat.o(96523);
        }
        
        public final void dsx()
        {
          AppMethodBeat.i(96524);
          com.tencent.mm.sdk.platformtools.ad.d("MicroMsg.AdLandingPageDownloadApkBtnComp.callback", "succeed, idx=" + q.b(q.this).wVu);
          q.a(q.this).Wm(9);
          AppMethodBeat.o(96524);
        }
        
        public final void dsy()
        {
          AppMethodBeat.i(96525);
          com.tencent.mm.sdk.platformtools.ad.d("MicroMsg.AdLandingPageDownloadApkBtnComp.callback", "failed, idx=" + q.b(q.this).wVu);
          q.a(q.this).Wm(8);
          AppMethodBeat.o(96525);
        }
        
        public final void dsz()
        {
          AppMethodBeat.i(96526);
          com.tencent.mm.sdk.platformtools.ad.d("MicroMsg.AdLandingPageDownloadApkBtnComp.callback", "resumed, idx=" + q.b(q.this).wVu);
          q.a(q.this).Wm(13);
          AppMethodBeat.o(96526);
        }
        
        public final void start()
        {
          AppMethodBeat.i(96520);
          com.tencent.mm.sdk.platformtools.ad.d("MicroMsg.AdLandingPageDownloadApkBtnComp.callback", "start, idx=" + q.b(q.this).wVu);
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
        com.tencent.mm.sdk.platformtools.ad.d("MicroMsg.AdLandingPageDownloadApkBtnComp.state", "InitState enter, idx=" + q.b(q.this).wVu);
        com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.b localb = q.b(q.this);
        int i;
        if ((localb.wVj == 0) || (localb.wVj == 2)) {
          i = 1;
        }
        while (i != 0) {
          if (AdLandingPagesProxy.getInstance().isApkExist(q.b(q.this).dlB))
          {
            q.a.this.b(q.a.this.xaR);
            AppMethodBeat.o(96529);
            return;
            i = 0;
          }
          else
          {
            if (AdLandingPagesProxy.getInstance().isPkgInstalled(q.b(q.this).IK))
            {
              q.a.this.b(q.a.this.xaS);
              AppMethodBeat.o(96529);
              return;
            }
            q.a.this.b(q.a.this.xaU);
            AppMethodBeat.o(96529);
            return;
          }
        }
        q.a.this.b(q.a.this.xaV);
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
        com.tencent.mm.sdk.platformtools.ad.d("MicroMsg.AdLandingPageDownloadApkBtnComp.state", "PauseState enter, idx=" + q.b(q.this).wVu);
        aq.f(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(96530);
            q.c(q.this).setVisibility(8);
            q.d(q.this).setVisibility(0);
            q.d(q.this).setText(2131763749);
            AppMethodBeat.o(96530);
          }
        });
        AppMethodBeat.o(96532);
      }
      
      public final boolean k(Message paramMessage)
      {
        AppMethodBeat.i(96533);
        com.tencent.mm.sdk.platformtools.ad.d("MicroMsg.AdLandingPageDownloadApkBtnComp.state", "PauseState, msg=" + paramMessage.what + ", idx=" + q.b(q.this).wVu);
        com.tencent.mm.sdk.platformtools.ad.i("LogStateTransitionState", hashCode() + "[PauseState] recv msg.what " + paramMessage.what);
        switch (paramMessage.what)
        {
        default: 
          AppMethodBeat.o(96533);
          return false;
        case 0: 
          if (AdLandingPagesProxy.getInstance().isDownloading(q.b(q.this).dlB)) {
            q.a.a(q.a.this, q.this.context.getString(2131763748));
          }
          for (;;)
          {
            AppMethodBeat.o(96533);
            return true;
            if (!NetStatusUtil.isWifi(q.this.context))
            {
              com.tencent.mm.sdk.platformtools.ad.i("LogStateTransitionState", "download not in wifi!");
              com.tencent.mm.plugin.sns.data.h.a(q.this.dpC, q.this.appId, 0, 1, q.this.dvK, q.this.wBR);
              com.tencent.mm.ui.base.h.a(q.this.context, 2131766086, 2131766087, new DialogInterface.OnClickListener()
              {
                public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
                {
                  AppMethodBeat.i(96531);
                  q.a.this.Wm(12);
                  com.tencent.mm.plugin.sns.data.h.a(q.f(q.this), q.g(q.this), 1, 1, q.h(q.this), q.i(q.this));
                  com.tencent.mm.modelstat.d.c(10, "AdLandingPageDownloadApkBtnComp_PAUSE_MSG_BTN_CLICK", q.a.e.this.hashCode());
                  AppMethodBeat.o(96531);
                }
              }, null);
            }
            else
            {
              int i = q.b(q.this).wVw;
              com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.AdLandingPageDownloadApkBtnComp.GroceryDownload", "showDownloadTip = ".concat(String.valueOf(i)));
              if (i == 1) {
                q.a.a(q.a.this, 1);
              } else {
                q.a.this.Wm(12);
              }
            }
          }
        case 3: 
          q.a.this.b(q.a.this.xaS);
          AppMethodBeat.o(96533);
          return true;
        case 8: 
          q.a.a(q.a.this, q.this.context.getString(2131763750));
          q.a.this.b(q.a.this.xaT);
          AppMethodBeat.o(96533);
          return true;
        case 12: 
          q.a.this.b(q.a.this.xaO);
          AppMethodBeat.o(96533);
          return true;
        }
        q.a.this.b(q.a.this.xaO);
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
        com.tencent.mm.sdk.platformtools.ad.d("MicroMsg.AdLandingPageDownloadApkBtnComp.state", "ReDownloadState enter, idx=" + q.b(q.this).wVu);
        aq.f(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(96534);
            q.c(q.this).setVisibility(8);
            q.d(q.this).setVisibility(0);
            q.d(q.this).setText(2131763755);
            AppMethodBeat.o(96534);
          }
        });
        AppMethodBeat.o(96535);
      }
      
      public final boolean k(Message paramMessage)
      {
        AppMethodBeat.i(96536);
        com.tencent.mm.sdk.platformtools.ad.d("MicroMsg.AdLandingPageDownloadApkBtnComp.state", "ReDownloadState, msg=" + paramMessage.what + ", idx=" + q.b(q.this).wVu);
        com.tencent.mm.sdk.platformtools.ad.i("LogStateTransitionState", hashCode() + "[ReDownloadState] recv msg.what " + paramMessage.what);
        switch (paramMessage.what)
        {
        default: 
          AppMethodBeat.o(96536);
          return false;
        }
        q.a.this.b(q.a.this.xaU);
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
        com.tencent.mm.sdk.platformtools.ad.d("MicroMsg.AdLandingPageDownloadApkBtnComp.state", "ToDownloadState enter, idx=" + q.b(q.this).wVu);
        aq.f(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(96537);
            if (q.e(q.this) == null)
            {
              q.a(q.this, new q.b(q.this, (byte)0));
              IntentFilter localIntentFilter = new IntentFilter();
              localIntentFilter.addAction("android.intent.action.PACKAGE_ADDED");
              localIntentFilter.addAction("android.intent.action.PACKAGE_REMOVED");
              localIntentFilter.addDataScheme("package");
              q.this.context.registerReceiver(q.e(q.this), localIntentFilter);
            }
            AppMethodBeat.o(96537);
          }
        });
        if (AdLandingPagesProxy.getInstance().isPkgInstalled(q.b(q.this).IK))
        {
          q.a.this.b(q.a.this.xaS);
          AppMethodBeat.o(96543);
          return;
        }
        if (AdLandingPagesProxy.getInstance().isApkExist(q.b(q.this).dlB))
        {
          q.a.this.b(q.a.this.xaR);
          AppMethodBeat.o(96543);
          return;
        }
        if (AdLandingPagesProxy.getInstance().isDownloading(q.b(q.this).dlB))
        {
          q.a.this.b(q.a.this.xaO);
          AppMethodBeat.o(96543);
          return;
        }
        if (AdLandingPagesProxy.getInstance().isPaused(q.b(q.this).dlB))
        {
          q.a.this.b(q.a.this.xaQ);
          AppMethodBeat.o(96543);
          return;
        }
        aq.f(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(96538);
            q.c(q.this).setVisibility(8);
            q.d(q.this).setVisibility(0);
            q.d(q.this).setText(q.b(q.this).title);
            AppMethodBeat.o(96538);
          }
        });
        boolean bool;
        if (q.this.xaJ) {
          if (q.this.dwi().wXn) {
            bool = q.b(q.this).wVv;
          }
        }
        for (;;)
        {
          if ((bool) && (q.this.xaK))
          {
            q.this.xaK = false;
            aq.n(new Runnable()
            {
              public final void run()
              {
                AppMethodBeat.i(96540);
                try
                {
                  double d = (float)q.b(q.this).fileSize / 1024.0F / 1024.0F;
                  if (d > 0.0D) {
                    str = String.format("%.1f", new Object[] { Double.valueOf(d) });
                  }
                  for (String str = q.this.context.getString(2131763738, new Object[] { q.b(q.this).wVh, str });; str = q.this.context.getString(2131763737, new Object[] { q.b(q.this).wVh }))
                  {
                    com.tencent.mm.plugin.sns.data.h.a(q.f(q.this), q.g(q.this), 0, 0, q.h(q.this), q.i(q.this));
                    com.tencent.mm.ui.base.h.a(q.this.context, str, "", new DialogInterface.OnClickListener()
                    {
                      public final void onClick(DialogInterface paramAnonymous2DialogInterface, int paramAnonymous2Int)
                      {
                        AppMethodBeat.i(96539);
                        q.a(q.this).Wm(0);
                        com.tencent.mm.plugin.sns.data.h.a(q.f(q.this), q.g(q.this), 1, 0, q.h(q.this), q.i(q.this));
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
                  com.tencent.mm.sdk.platformtools.ad.e("LogStateTransitionState", "showAutoDownloadDialog exp=" + localException.toString());
                  AppMethodBeat.o(96540);
                }
              }
            }, 800L);
          }
          AppMethodBeat.o(96543);
          return;
          if (q.b(q.this).wVu == 0)
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
        com.tencent.mm.sdk.platformtools.ad.d("MicroMsg.AdLandingPageDownloadApkBtnComp.state", "ToDownloadState, msg=" + paramMessage.what + ", idx=" + q.b(q.this).wVu);
        com.tencent.mm.sdk.platformtools.ad.i("LogStateTransitionState", hashCode() + "[ToDownloadState]recv msg.what " + paramMessage.what);
        switch (paramMessage.what)
        {
        default: 
          AppMethodBeat.o(96544);
          return false;
        case 0: 
          if (AdLandingPagesProxy.getInstance().isDownloading(q.b(q.this).dlB)) {
            q.a.a(q.a.this, q.this.context.getString(2131763748));
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
                if (!NetStatusUtil.isWifi(q.this.context))
                {
                  com.tencent.mm.sdk.platformtools.ad.i("LogStateTransitionState", "download not in wifi!");
                  com.tencent.mm.plugin.sns.data.h.a(q.f(q.this), q.g(q.this), 0, 0, q.h(q.this), q.i(q.this));
                  com.tencent.mm.ui.base.h.a(q.this.context, 2131766086, 2131766087, new DialogInterface.OnClickListener()
                  {
                    public final void onClick(DialogInterface paramAnonymous2DialogInterface, int paramAnonymous2Int)
                    {
                      AppMethodBeat.i(96541);
                      q.a(q.this).Wm(12);
                      com.tencent.mm.plugin.sns.data.h.a(q.f(q.this), q.g(q.this), 1, 0, q.h(q.this), q.i(q.this));
                      com.tencent.mm.modelstat.d.c(10, "AdLandingPageDownloadApkBtnComp_TODOWLOAD_MSG_BTN_CLICK", q.a.g.this.hashCode());
                      AppMethodBeat.o(96541);
                    }
                  }, null);
                  AppMethodBeat.o(96542);
                  return;
                }
                int i = q.b(q.this).wVw;
                com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.AdLandingPageDownloadApkBtnComp.GroceryDownload", "showDownloadTip = ".concat(String.valueOf(i)));
                if (i == 1)
                {
                  if (AdLandingPagesProxy.getInstance().isPaused(q.b(q.this).dlB))
                  {
                    q.a.a(q.a.this, 1);
                    AppMethodBeat.o(96542);
                    return;
                  }
                  q.a.a(q.a.this, 0);
                  AppMethodBeat.o(96542);
                  return;
                }
                q.a(q.this).Wm(12);
                AppMethodBeat.o(96542);
              }
            });
          }
        case 3: 
          q.a.this.b(q.a.this.xaS);
          AppMethodBeat.o(96544);
          return true;
        case 11: 
          q.a.this.b(q.a.this.xaP);
          AppMethodBeat.o(96544);
          return true;
        }
        q.a.this.b(q.a.this.xaO);
        AppMethodBeat.o(96544);
        return true;
      }
    }
    
    final class h
      extends com.tencent.mm.sdk.d.b
    {
      private boolean xbi;
      
      h() {}
      
      public final void enter()
      {
        AppMethodBeat.i(96546);
        com.tencent.mm.sdk.platformtools.ad.d("MicroMsg.AdLandingPageDownloadApkBtnComp.state", "ToInstallState enter, idx=" + q.b(q.this).wVu);
        super.enter();
        if (!AdLandingPagesProxy.getInstance().isApkExist(q.b(q.this).dlB))
        {
          q.a.this.b(q.a.this.xaP);
          AppMethodBeat.o(96546);
          return;
        }
        aq.f(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(96545);
            q.c(q.this).setVisibility(8);
            q.d(q.this).setVisibility(0);
            q.d(q.this).setText(2131763751);
            AppMethodBeat.o(96545);
          }
        });
        this.xbi = true;
        AppMethodBeat.o(96546);
      }
      
      public final boolean k(Message paramMessage)
      {
        AppMethodBeat.i(96547);
        com.tencent.mm.sdk.platformtools.ad.d("MicroMsg.AdLandingPageDownloadApkBtnComp.state", "ToInstallState, msg=" + paramMessage.what + ", idx=" + q.b(q.this).wVu);
        com.tencent.mm.sdk.platformtools.ad.i("LogStateTransitionState", hashCode() + "[ToInstallState] recv msg.what " + paramMessage.what);
        switch (paramMessage.what)
        {
        case 1: 
        default: 
          AppMethodBeat.o(96547);
          return false;
        case 0: 
          if (AdLandingPagesProxy.getInstance().installApp(q.this.context, q.b(q.this).dlB, q.b(q.this).IK, q.b(q.this).md5, q.b(q.this).downloadUrl))
          {
            this.xbi = true;
            AppMethodBeat.o(96547);
            return true;
          }
          q.a.a(q.a.this, q.this.context.getString(2131763752));
          q.a.this.b(q.a.this.xaT);
          AppMethodBeat.o(96547);
          return true;
        case 2: 
          if (!AdLandingPagesProxy.getInstance().isApkExist(q.b(q.this).dlB)) {
            q.a.this.b(q.a.this.xaP);
          }
          AppMethodBeat.o(96547);
          return true;
        }
        if (this.xbi) {
          this.xbi = false;
        }
        q.a.this.b(q.a.this.xaS);
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
        com.tencent.mm.sdk.platformtools.ad.d("MicroMsg.AdLandingPageDownloadApkBtnComp.state", "ToOpenState enter, idx=" + q.b(q.this).wVu);
        if (AdLandingPagesProxy.getInstance().isPkgInstalled(q.b(q.this).IK))
        {
          aq.f(new Runnable()
          {
            public final void run()
            {
              AppMethodBeat.i(96548);
              q.c(q.this).setVisibility(8);
              q.d(q.this).setVisibility(0);
              q.d(q.this).setText(2131763753);
              AppMethodBeat.o(96548);
            }
          });
          AppMethodBeat.o(96549);
          return;
        }
        q.a.this.b(q.a.this.xaR);
        AppMethodBeat.o(96549);
      }
      
      public final boolean k(Message paramMessage)
      {
        AppMethodBeat.i(96550);
        com.tencent.mm.sdk.platformtools.ad.d("MicroMsg.AdLandingPageDownloadApkBtnComp.state", "ToOpenState, msg=" + paramMessage.what + ", idx=" + q.b(q.this).wVu);
        com.tencent.mm.sdk.platformtools.ad.i("LogStateTransitionState", hashCode() + "[ToOpenState] recv msg.what " + paramMessage.what);
        switch (paramMessage.what)
        {
        default: 
          AppMethodBeat.o(96550);
          return false;
        case 0: 
          if (com.tencent.mm.plugin.sns.data.j.a(q.this.context, q.b(q.this).dlB, q.b(q.this).IK, "", q.b(q.this).wSw, q.this.dvK, q.this.wBR, q.this.dpC))
          {
            AppMethodBeat.o(96550);
            return true;
          }
          q.a.a(q.a.this, q.this.context.getString(2131763754));
          q.a.this.b(q.a.this.xaS);
          AppMethodBeat.o(96550);
          return true;
        }
        q.a.this.b(q.a.this.xaP);
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
          if ((!TextUtils.isEmpty(paramContext)) && (paramContext.equals(q.b(q.this).IK))) {
            q.this.xaG.Wm(3);
          }
          AppMethodBeat.o(96553);
          return;
        }
        if ("android.intent.action.PACKAGE_REMOVED".equals(paramContext))
        {
          paramContext = paramIntent.getData().getSchemeSpecificPart();
          if ((!TextUtils.isEmpty(paramContext)) && (paramContext.equals(q.b(q.this).IK))) {
            q.this.xaG.Wm(4);
          }
        }
      }
      AppMethodBeat.o(96553);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.q
 * JD-Core Version:    0.7.0.1
 */