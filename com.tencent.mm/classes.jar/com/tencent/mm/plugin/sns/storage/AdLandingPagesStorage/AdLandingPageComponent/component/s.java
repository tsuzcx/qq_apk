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
import com.tencent.mm.plugin.sns.data.i;
import com.tencent.mm.plugin.sns.data.k;
import com.tencent.mm.plugin.sns.device.appstore.a;
import com.tencent.mm.plugin.sns.model.AdLandingPagesProxy;
import com.tencent.mm.plugin.sns.model.AdLandingPagesProxy.a;
import com.tencent.mm.plugin.sns.model.AdLandingPagesProxy.e;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.a.d.a;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.af;
import com.tencent.mm.plugin.sns.ui.widget.SnsTextProgressBar;
import com.tencent.mm.sdk.d.c;
import com.tencent.mm.sdk.d.d.c;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.ar;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.ui.base.h;
import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

public final class s
  extends p
  implements Serializable
{
  String appId;
  String dAg;
  String dGD;
  boolean zVA;
  private View.OnClickListener zVB;
  AdLandingPagesProxy.e zVC;
  private View zVt;
  Button zVu;
  private SnsTextProgressBar zVv;
  a zVw;
  private HandlerThread zVx;
  private b zVy;
  boolean zVz;
  String zsJ;
  
  public s(Context paramContext, com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.b paramb, ViewGroup paramViewGroup)
  {
    super(paramContext, paramb, paramViewGroup);
    AppMethodBeat.i(96554);
    this.zVA = true;
    this.appId = "";
    this.dGD = "";
    this.zsJ = "";
    this.dAg = "";
    this.zVB = new s.1(this);
    this.zVC = new s.2(this);
    ae.d("MicroMsg.AdLandingPageDownloadApkBtnComp.state", "component create, new BtnStateMachine");
    this.zVx = com.tencent.e.c.d.bbg("apkStateMachine");
    this.zVx.start();
    this.zVw = new a("apkStateMachine", this.zVx.getLooper());
    if ((paramContext instanceof Activity))
    {
      this.zVz = ((Activity)paramContext).getIntent().getBooleanExtra("sns_landing_pages_auto_download_for_action_btn", false);
      this.zVA = true;
      ae.i("MicroMsg.AdLandingPageDownloadApkBtnComp", "autoDownloadFromActionBtn=" + this.zVz + ", activity=" + paramContext + ", idx=" + ((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.b)this.zUP).zPP + ", appId=" + ((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.b)this.zUP).dwb + ", wxAppid=" + ((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.b)this.zUP).zPA + ", useGameDownloader=" + ((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.b)this.zUP).zPB + ", pkg=" + ((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.b)this.zUP).Lw);
    }
    this.zVg.bm("platform", paramb.zPE);
    this.zVg.jH("appid", paramb.dwb);
    this.zVg.jH("channelId", paramb.channelId);
    this.zVg.jH("pkg", paramb.Lw);
    this.zVg.jH("appPageUrlAndroid", paramb.zMz);
    try
    {
      this.appId = bu.nullAsNil(((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.b)this.zUP).dwb);
      this.dGD = bu.nullAsNil(eaD().dGD);
      this.zsJ = bu.nullAsNil(eaD().zsJ);
      this.dAg = eaD().getSnsId();
      AppMethodBeat.o(96554);
      return;
    }
    catch (Throwable paramContext)
    {
      ae.e("MicroMsg.AdLandingPageDownloadApkBtnComp.DownloadToastReport", paramContext.toString());
      AppMethodBeat.o(96554);
    }
  }
  
  private static String jG(String paramString1, String paramString2)
  {
    AppMethodBeat.i(96561);
    if (bu.isNullOrNil(paramString1))
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
  public final void dUI()
  {
    AppMethodBeat.i(96556);
    this.clickCount = 0;
    Object localObject = this.contentView;
    this.zVt = ((View)localObject).findViewById(2131299227);
    this.zVu = ((Button)((View)localObject).findViewById(2131299195));
    this.zVu.setOnClickListener(this.zVB);
    this.zVv = ((SnsTextProgressBar)((View)localObject).findViewById(2131299215));
    this.zVv.setProgress(0);
    this.zVv.setVisibility(8);
    this.zVv.setOnClickListener(this.zVB);
    ae.d("MicroMsg.AdLandingPageDownloadApkBtnComp.state", "createView, BtnStateMachine start");
    this.zVw.start();
    try
    {
      localObject = (com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.b)this.zUP;
      if (((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.b)localObject).zPS > 0)
      {
        if (!a.aK(((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.b)localObject).zPT)) {
          break label167;
        }
        l.a(eaD(), 4, "0", "");
      }
      for (;;)
      {
        l.a(eaD(), 1, "1", "");
        AppMethodBeat.o(96556);
        return;
        label167:
        l.a(eaD(), 4, "1", "");
      }
      return;
    }
    catch (Exception localException)
    {
      ae.w("MicroMsg.AdLandingPageDownloadApkBtnComp", "report19790 has something wrong");
      AppMethodBeat.o(96556);
    }
  }
  
  protected final void dUJ()
  {
    AppMethodBeat.i(96555);
    Object localObject1 = new HashMap();
    ((Map)localObject1).put("fontNormalColor", jG(((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.b)this.zUP).zPM, "#FFFFFF"));
    ((Map)localObject1).put("fontDisableColor", jG(((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.b)this.zUP).zPN, "#4CFFFFFF"));
    ((Map)localObject1).put("fontPressedColor", jG(((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.b)this.zUP).zPO, "#99FFFFFF"));
    ((Map)localObject1).put("NormalColor", jG(((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.b)this.zUP).zPG, "#1AAD19"));
    ((Map)localObject1).put("PressedColor", jG(((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.b)this.zUP).zPI, "#179B16"));
    ((Map)localObject1).put("DisableColor", jG(((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.b)this.zUP).zPH, "#661AAD19"));
    ((Map)localObject1).put("borderNormalColor", jG(((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.b)this.zUP).zPJ, "#179E16"));
    ((Map)localObject1).put("borderPressedColor", jG(((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.b)this.zUP).zPL, "#158E14"));
    ((Map)localObject1).put("borderDisableColor", jG(((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.b)this.zUP).zPK, "#00179E16"));
    int j = Color.parseColor((String)((Map)localObject1).get("fontNormalColor"));
    int k = Color.parseColor((String)((Map)localObject1).get("fontDisableColor"));
    int m = Color.parseColor((String)((Map)localObject1).get("fontPressedColor"));
    int n = Color.parseColor((String)((Map)localObject1).get("NormalColor"));
    int i1 = Color.parseColor((String)((Map)localObject1).get("PressedColor"));
    int i2 = Color.parseColor((String)((Map)localObject1).get("DisableColor"));
    int i3 = (int)((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.b)this.zUP).zQv;
    int i4 = Color.parseColor((String)((Map)localObject1).get("borderNormalColor"));
    int i5 = Color.parseColor((String)((Map)localObject1).get("borderPressedColor"));
    int i6 = Color.parseColor((String)((Map)localObject1).get("borderDisableColor"));
    int i = this.context.getResources().getDimensionPixelSize(2131165207);
    if (((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.b)this.zUP).tm > 0.0F) {
      i = (int)((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.b)this.zUP).tm;
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
    Object localObject3 = new GradientDrawable();
    ((GradientDrawable)localObject3).setShape(0);
    ((GradientDrawable)localObject3).setCornerRadius(i);
    ((GradientDrawable)localObject3).setColor(n);
    ((GradientDrawable)localObject3).setStroke(i3, i4);
    StateListDrawable localStateListDrawable = new StateListDrawable();
    localStateListDrawable.addState(new int[] { -16842910 }, (Drawable)localObject1);
    localStateListDrawable.addState(new int[] { 16842919 }, (Drawable)localObject2);
    localStateListDrawable.addState(new int[] { 16842910 }, (Drawable)localObject3);
    this.zVu.setBackground(localStateListDrawable);
    localObject1 = new int[] { -16842910 };
    localObject2 = new int[] { 16842919 };
    localObject3 = new int[] { 16842910 };
    this.zVu.setTextColor(new ColorStateList(new int[][] { localObject1, localObject2, localObject3 }, new int[] { k, m, j }));
    if (((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.b)this.zUP).fontSize > 0.0F) {
      this.zVu.setTextSize(0, ((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.b)this.zUP).fontSize);
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
    localObject3 = new GradientDrawable();
    ((GradientDrawable)localObject3).setShape(0);
    ((GradientDrawable)localObject3).setCornerRadius(i);
    ((GradientDrawable)localObject3).setColor(n);
    localObject1 = new LayerDrawable(new Drawable[] { localObject1, localObject2, new ClipDrawable((Drawable)localObject3, 3, 1) });
    ((LayerDrawable)localObject1).setId(0, 16908288);
    ((LayerDrawable)localObject1).setId(1, 16908303);
    ((LayerDrawable)localObject1).setId(2, 16908301);
    this.zVv.setProgressDrawable((Drawable)localObject1);
    this.zVv.setPaintColor(((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.b)this.zUP).zPO);
    if (((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.b)this.zUP).height > 0.0F)
    {
      localObject1 = (RelativeLayout.LayoutParams)this.zVt.getLayoutParams();
      ((RelativeLayout.LayoutParams)localObject1).height = ((int)((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.b)this.zUP).height);
      this.zVt.setLayoutParams((ViewGroup.LayoutParams)localObject1);
    }
    this.zVu.setText(((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.b)this.zUP).title);
    ae.d("MicroMsg.AdLandingPageDownloadApkBtnComp.state", "fillItem, sendMsg=11");
    this.zVw.abg(11);
    AppMethodBeat.o(96555);
  }
  
  public final void dUK()
  {
    AppMethodBeat.i(96557);
    super.dUK();
    ae.d("MicroMsg.AdLandingPageDownloadApkBtnComp.state", "viewWillAppear, sendMsg=2");
    this.zVw.abg(2);
    AdLandingPagesProxy.getInstance().addReportInfo(((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.b)this.zUP).dwb, eaD().zMk, eaD().jWi, eaD().dGD);
    AppMethodBeat.o(96557);
  }
  
  public final void dUM()
  {
    AppMethodBeat.i(96558);
    super.dUM();
    ae.i("MicroMsg.AdLandingPageDownloadApkBtnComp", "view destroy");
    this.zVx.quit();
    if (this.zVy != null)
    {
      this.context.unregisterReceiver(this.zVy);
      this.zVy = null;
    }
    AppMethodBeat.o(96558);
  }
  
  public final void eaK()
  {
    AppMethodBeat.i(96560);
    ae.d("MicroMsg.AdLandingPageDownloadApkBtnComp", "writing deferred deep link");
    AdLandingPagesProxy.getInstance().writeDeferredDeepLink(((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.b)this.zUP).Lw, ((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.b)this.zUP).zMz);
    k.jn(((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.b)this.zUP).Lw, ((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.b)this.zUP).zMz);
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
    c zVE;
    c zVF;
    c zVG;
    c zVH;
    c zVI;
    c zVJ;
    c zVK;
    c zVL;
    c zVM;
    
    protected a(String paramString, Looper paramLooper)
    {
      super(paramLooper);
      AppMethodBeat.i(96551);
      this.zVE = new c();
      this.zVF = new g();
      this.zVG = new e();
      this.zVH = new h();
      this.zVI = new i();
      this.zVJ = new f();
      this.zVK = new b();
      this.zVL = new a();
      this.zVM = new d();
      a(this.zVF);
      a(this.zVE);
      a(this.zVG);
      a(this.zVH);
      a(this.zVI);
      a(this.zVJ);
      a(this.zVK);
      a(this.zVL);
      a(this.zVM);
      b(this.zVM);
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
        ae.d("MicroMsg.AdLandingPageDownloadApkBtnComp.state", "DisableUnsupportPlatformState enter, idx=" + s.b(s.this).zPP);
        ar.f(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(96512);
            s.c(s.this).setVisibility(8);
            s.d(s.this).setEnabled(false);
            Button localButton = s.d(s.this);
            if (!TextUtils.isEmpty(s.b(s.this).zPF)) {}
            for (String str = s.b(s.this).zPF;; str = "暂不支持安卓手机")
            {
              localButton.setText(str);
              s.d(s.this).setVisibility(0);
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
        ae.d("MicroMsg.AdLandingPageDownloadApkBtnComp.state", "DoNetSceneState enter, idx=" + s.b(s.this).zPP);
        AdLandingPagesProxy.getInstance().doAdChannelScene(s.b(s.this).Lw, s.b(s.this).channelId, s.this.zVC, s.b(s.this).zPB);
        ae.i("LogStateTransitionState", "[DoNetSceneState], appid=" + s.b(s.this).dwb + ", pkg=" + s.b(s.this).Lw + ", channelId=" + s.b(s.this).channelId + ", useGameDownloadWidget=" + s.b(s.this).zPB + ", hash=" + hashCode());
        AppMethodBeat.o(96515);
      }
      
      public final boolean k(Message paramMessage)
      {
        AppMethodBeat.i(96514);
        ae.d("MicroMsg.AdLandingPageDownloadApkBtnComp.state", "DoNetSceneState msg=" + paramMessage.what + ", idx=" + s.b(s.this).zPP);
        ae.i("LogStateTransitionState", hashCode() + "[DoNetSceneState]recv msg.what " + paramMessage.what);
        if (AdLandingPagesProxy.getInstance().isApkExist(s.b(s.this).dwb))
        {
          s.a.this.b(s.a.this.zVH);
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
          s.a.this.b(s.a.this.zVF);
          AppMethodBeat.o(96514);
          return true;
        case 5: 
          s.a.a(s.a.this, s.this.context.getString(2131763750));
          s.a.this.b(s.a.this.zVJ);
          AppMethodBeat.o(96514);
          return true;
        }
        s.a.this.b(s.a.this.zVF);
        AppMethodBeat.o(96514);
        return true;
      }
    }
    
    final class c
      extends com.tencent.mm.sdk.d.b
    {
      AdLandingPagesProxy.a zVR;
      
      c() {}
      
      public final void enter()
      {
        AppMethodBeat.i(96527);
        super.enter();
        ae.d("MicroMsg.AdLandingPageDownloadApkBtnComp.state", "DownloadingState enter, idx=" + s.b(s.this).zPP);
        ar.f(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(96516);
            s.d(s.this).setVisibility(8);
            s.c(s.this).setVisibility(0);
            AppMethodBeat.o(96516);
          }
        });
        if ((AdLandingPagesProxy.getInstance().isPaused(s.b(s.this).dwb)) || (AdLandingPagesProxy.getInstance().isDownloading(s.b(s.this).dwb)))
        {
          if (this.zVR == null) {
            this.zVR = new a((byte)0);
          }
          ar.f(new Runnable()
          {
            public final void run()
            {
              AppMethodBeat.i(96517);
              s.c(s.this).setProgress(AdLandingPagesProxy.getInstance().getTaskProgress(s.b(s.this).dwb));
              AppMethodBeat.o(96517);
            }
          });
          if (!AdLandingPagesProxy.getInstance().resumeTask(s.b(s.this).dwb, this.zVR, s.this.eaD().zMk, s.this.eaD().jWi, s.this.eaD().dGD))
          {
            AdLandingPagesProxy.getInstance().stopTask(s.b(s.this).dwb);
            s.a.this.b(s.a.this.zVE);
            AppMethodBeat.o(96527);
          }
        }
        else
        {
          if (TextUtils.isEmpty(s.b(s.this).downloadUrl))
          {
            s.a.this.b(s.a.this.zVK);
            AppMethodBeat.o(96527);
            return;
          }
          if (AdLandingPagesProxy.getInstance().isApkExist(s.b(s.this).dwb))
          {
            ar.f(new Runnable()
            {
              public final void run()
              {
                AppMethodBeat.i(96518);
                s.c(s.this).setProgress(100);
                AppMethodBeat.o(96518);
              }
            });
            s.a.this.b(s.a.this.zVH);
            AppMethodBeat.o(96527);
            return;
          }
          AdLandingPagesProxy.getInstance().stopTask(s.b(s.this).dwb);
          this.zVR = new a((byte)0);
          AdLandingPagesProxy.getInstance().startDownload(s.b(s.this).dwb, s.b(s.this).zPA, s.b(s.this).Lw, s.b(s.this).md5, s.b(s.this).downloadUrl, s.b(s.this).zPC, s.b(s.this).zPD, this.zVR, s.this.eaD().zMk, s.this.eaD().jWi, s.this.eaD().dGD, s.b(s.this).zPB);
        }
        AppMethodBeat.o(96527);
      }
      
      public final boolean k(Message paramMessage)
      {
        AppMethodBeat.i(96528);
        if (paramMessage.what != 1) {
          ae.d("MicroMsg.AdLandingPageDownloadApkBtnComp.state", "DownloadingState, msg=" + paramMessage.what + ", idx=" + s.b(s.this).zPP);
        }
        ae.i("LogStateTransitionState", hashCode() + "[DownloadingState] recv msg.what " + paramMessage.what);
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
          if ((AdLandingPagesProxy.getInstance().pauseTask(s.b(s.this).dwb)) && (AdLandingPagesProxy.getInstance().isPaused(s.b(s.this).dwb))) {
            s.a.this.b(s.a.this.zVG);
          }
          AppMethodBeat.o(96528);
          return true;
        case 1: 
          ar.f(new Runnable()
          {
            public final void run()
            {
              AppMethodBeat.i(96519);
              if (this.val$progress >= 0) {
                s.c(s.this).setProgress(this.val$progress);
              }
              AppMethodBeat.o(96519);
            }
          });
          AppMethodBeat.o(96528);
          return true;
        case 3: 
          s.a.this.b(s.a.this.zVI);
          AppMethodBeat.o(96528);
          return true;
        case 7: 
          s.a.this.b(s.a.this.zVG);
          AppMethodBeat.o(96528);
          return true;
        case 8: 
          s.a.a(s.a.this, s.this.context.getString(2131763750));
          s.a.this.b(s.a.this.zVJ);
          AppMethodBeat.o(96528);
          return true;
        }
        s.this.eaK();
        s.a.this.b(s.a.this.zVH);
        AppMethodBeat.o(96528);
        return true;
      }
      
      final class a
        implements AdLandingPagesProxy.a
      {
        private a() {}
        
        public final void Qu(int paramInt)
        {
          AppMethodBeat.i(96521);
          if (paramInt % 20 == 0) {
            ae.d("MicroMsg.AdLandingPageDownloadApkBtnComp.callback", "progress:" + paramInt + ", idx=" + s.b(s.this).zPP);
          }
          s.a locala = s.a(s.this);
          d.c localc = locala.IBf;
          if (localc != null) {
            localc.sendMessage(Message.obtain(locala.IBf, 1, paramInt, 0));
          }
          AppMethodBeat.o(96521);
        }
        
        public final void dWH()
        {
          AppMethodBeat.i(96522);
          ae.d("MicroMsg.AdLandingPageDownloadApkBtnComp.callback", "paused, idx=" + s.b(s.this).zPP);
          s.a(s.this).abg(7);
          AppMethodBeat.o(96522);
        }
        
        public final void dWI()
        {
          AppMethodBeat.i(96523);
          ae.d("MicroMsg.AdLandingPageDownloadApkBtnComp.callback", "stopped, idx=" + s.b(s.this).zPP);
          AppMethodBeat.o(96523);
        }
        
        public final void dWJ()
        {
          AppMethodBeat.i(96524);
          ae.d("MicroMsg.AdLandingPageDownloadApkBtnComp.callback", "succeed, idx=" + s.b(s.this).zPP);
          s.a(s.this).abg(9);
          AppMethodBeat.o(96524);
        }
        
        public final void dWK()
        {
          AppMethodBeat.i(96525);
          ae.d("MicroMsg.AdLandingPageDownloadApkBtnComp.callback", "failed, idx=" + s.b(s.this).zPP);
          s.a(s.this).abg(8);
          AppMethodBeat.o(96525);
        }
        
        public final void dWL()
        {
          AppMethodBeat.i(96526);
          ae.d("MicroMsg.AdLandingPageDownloadApkBtnComp.callback", "resumed, idx=" + s.b(s.this).zPP);
          s.a(s.this).abg(13);
          AppMethodBeat.o(96526);
        }
        
        public final void start()
        {
          AppMethodBeat.i(96520);
          ae.d("MicroMsg.AdLandingPageDownloadApkBtnComp.callback", "start, idx=" + s.b(s.this).zPP);
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
        ae.d("MicroMsg.AdLandingPageDownloadApkBtnComp.state", "InitState enter, idx=" + s.b(s.this).zPP);
        com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.b localb = s.b(s.this);
        int i;
        if ((localb.zPE == 0) || (localb.zPE == 2)) {
          i = 1;
        }
        while (i != 0) {
          if (AdLandingPagesProxy.getInstance().isApkExist(s.b(s.this).dwb))
          {
            s.a.this.b(s.a.this.zVH);
            AppMethodBeat.o(96529);
            return;
            i = 0;
          }
          else
          {
            if (AdLandingPagesProxy.getInstance().isPkgInstalled(s.b(s.this).Lw))
            {
              s.a.this.b(s.a.this.zVI);
              AppMethodBeat.o(96529);
              return;
            }
            s.a.this.b(s.a.this.zVK);
            AppMethodBeat.o(96529);
            return;
          }
        }
        s.a.this.b(s.a.this.zVL);
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
        ae.d("MicroMsg.AdLandingPageDownloadApkBtnComp.state", "PauseState enter, idx=" + s.b(s.this).zPP);
        ar.f(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(96530);
            s.c(s.this).setVisibility(8);
            s.d(s.this).setVisibility(0);
            s.d(s.this).setText(2131763749);
            AppMethodBeat.o(96530);
          }
        });
        AppMethodBeat.o(96532);
      }
      
      public final boolean k(Message paramMessage)
      {
        AppMethodBeat.i(96533);
        ae.d("MicroMsg.AdLandingPageDownloadApkBtnComp.state", "PauseState, msg=" + paramMessage.what + ", idx=" + s.b(s.this).zPP);
        ae.i("LogStateTransitionState", hashCode() + "[PauseState] recv msg.what " + paramMessage.what);
        switch (paramMessage.what)
        {
        default: 
          AppMethodBeat.o(96533);
          return false;
        case 0: 
          if (AdLandingPagesProxy.getInstance().isDownloading(s.b(s.this).dwb)) {
            s.a.a(s.a.this, s.this.context.getString(2131763748));
          }
          for (;;)
          {
            AppMethodBeat.o(96533);
            return true;
            if (!NetStatusUtil.isWifi(s.this.context))
            {
              ae.i("LogStateTransitionState", "download not in wifi!");
              i.a(s.this.dAg, s.this.appId, 0, 1, s.this.dGD, s.this.zsJ, 1);
              h.a(s.this.context, 2131766086, 2131766087, new DialogInterface.OnClickListener()
              {
                public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
                {
                  AppMethodBeat.i(96531);
                  s.a.this.abg(12);
                  i.a(s.f(s.this), s.g(s.this), 1, 1, s.h(s.this), s.i(s.this), 1);
                  com.tencent.mm.modelstat.d.d(10, "AdLandingPageDownloadApkBtnComp_PAUSE_MSG_BTN_CLICK", s.a.e.this.hashCode());
                  AppMethodBeat.o(96531);
                }
              }, null);
            }
            else
            {
              int i = s.b(s.this).zPR;
              ae.i("MicroMsg.AdLandingPageDownloadApkBtnComp.GroceryDownload", "showDownloadTip = ".concat(String.valueOf(i)));
              if (i == 1) {
                s.a.a(s.a.this, 1);
              } else {
                s.a.this.abg(12);
              }
            }
          }
        case 3: 
          s.a.this.b(s.a.this.zVI);
          AppMethodBeat.o(96533);
          return true;
        case 8: 
          s.a.a(s.a.this, s.this.context.getString(2131763750));
          s.a.this.b(s.a.this.zVJ);
          AppMethodBeat.o(96533);
          return true;
        case 12: 
          s.a.this.b(s.a.this.zVE);
          AppMethodBeat.o(96533);
          return true;
        }
        s.a.this.b(s.a.this.zVE);
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
        ae.d("MicroMsg.AdLandingPageDownloadApkBtnComp.state", "ReDownloadState enter, idx=" + s.b(s.this).zPP);
        ar.f(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(96534);
            s.c(s.this).setVisibility(8);
            s.d(s.this).setVisibility(0);
            s.d(s.this).setText(2131763755);
            AppMethodBeat.o(96534);
          }
        });
        AppMethodBeat.o(96535);
      }
      
      public final boolean k(Message paramMessage)
      {
        AppMethodBeat.i(96536);
        ae.d("MicroMsg.AdLandingPageDownloadApkBtnComp.state", "ReDownloadState, msg=" + paramMessage.what + ", idx=" + s.b(s.this).zPP);
        ae.i("LogStateTransitionState", hashCode() + "[ReDownloadState] recv msg.what " + paramMessage.what);
        switch (paramMessage.what)
        {
        default: 
          AppMethodBeat.o(96536);
          return false;
        }
        s.a.this.b(s.a.this.zVK);
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
        ae.d("MicroMsg.AdLandingPageDownloadApkBtnComp.state", "ToDownloadState enter, idx=" + s.b(s.this).zPP);
        ar.f(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(96537);
            if (s.e(s.this) == null)
            {
              s.a(s.this, new s.b(s.this, (byte)0));
              IntentFilter localIntentFilter = new IntentFilter();
              localIntentFilter.addAction("android.intent.action.PACKAGE_ADDED");
              localIntentFilter.addAction("android.intent.action.PACKAGE_REMOVED");
              localIntentFilter.addDataScheme("package");
              s.this.context.registerReceiver(s.e(s.this), localIntentFilter);
            }
            AppMethodBeat.o(96537);
          }
        });
        if (AdLandingPagesProxy.getInstance().isPkgInstalled(s.b(s.this).Lw))
        {
          s.a.this.b(s.a.this.zVI);
          AppMethodBeat.o(96543);
          return;
        }
        if (AdLandingPagesProxy.getInstance().isApkExist(s.b(s.this).dwb))
        {
          s.a.this.b(s.a.this.zVH);
          AppMethodBeat.o(96543);
          return;
        }
        if (AdLandingPagesProxy.getInstance().isDownloading(s.b(s.this).dwb))
        {
          s.a.this.b(s.a.this.zVE);
          AppMethodBeat.o(96543);
          return;
        }
        if (AdLandingPagesProxy.getInstance().isPaused(s.b(s.this).dwb))
        {
          s.a.this.b(s.a.this.zVG);
          AppMethodBeat.o(96543);
          return;
        }
        ar.f(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(96538);
            s.c(s.this).setVisibility(8);
            s.d(s.this).setVisibility(0);
            s.d(s.this).setText(s.b(s.this).title);
            AppMethodBeat.o(96538);
          }
        });
        boolean bool;
        if (s.this.zVz) {
          if (s.this.eaD().zRQ) {
            bool = s.b(s.this).zPQ;
          }
        }
        for (;;)
        {
          if ((bool) && (s.this.zVA))
          {
            s.this.zVA = false;
            ar.o(new Runnable()
            {
              public final void run()
              {
                AppMethodBeat.i(96540);
                try
                {
                  double d = (float)s.b(s.this).fileSize / 1024.0F / 1024.0F;
                  if (d > 0.0D) {
                    str = String.format("%.1f", new Object[] { Double.valueOf(d) });
                  }
                  for (String str = s.this.context.getString(2131763738, new Object[] { s.b(s.this).zPC, str });; str = s.this.context.getString(2131763737, new Object[] { s.b(s.this).zPC }))
                  {
                    i.a(s.f(s.this), s.g(s.this), 0, 0, s.h(s.this), s.i(s.this), 1);
                    h.a(s.this.context, str, "", new DialogInterface.OnClickListener()
                    {
                      public final void onClick(DialogInterface paramAnonymous2DialogInterface, int paramAnonymous2Int)
                      {
                        AppMethodBeat.i(96539);
                        s.a(s.this).abg(0);
                        i.a(s.f(s.this), s.g(s.this), 1, 0, s.h(s.this), s.i(s.this), 1);
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
                  ae.e("LogStateTransitionState", "showAutoDownloadDialog exp=" + localException.toString());
                  AppMethodBeat.o(96540);
                }
              }
            }, 800L);
          }
          AppMethodBeat.o(96543);
          return;
          if (s.b(s.this).zPP == 0)
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
        ae.d("MicroMsg.AdLandingPageDownloadApkBtnComp.state", "ToDownloadState, msg=" + paramMessage.what + ", idx=" + s.b(s.this).zPP);
        ae.i("LogStateTransitionState", hashCode() + "[ToDownloadState]recv msg.what " + paramMessage.what);
        switch (paramMessage.what)
        {
        default: 
          AppMethodBeat.o(96544);
          return false;
        case 0: 
          if (AdLandingPagesProxy.getInstance().isDownloading(s.b(s.this).dwb)) {
            s.a.a(s.a.this, s.this.context.getString(2131763748));
          }
          for (;;)
          {
            AppMethodBeat.o(96544);
            return true;
            ar.f(new Runnable()
            {
              public final void run()
              {
                AppMethodBeat.i(96542);
                if (!NetStatusUtil.isWifi(s.this.context))
                {
                  ae.i("LogStateTransitionState", "download not in wifi!");
                  i.a(s.f(s.this), s.g(s.this), 0, 0, s.h(s.this), s.i(s.this), 1);
                  h.a(s.this.context, 2131766086, 2131766087, new DialogInterface.OnClickListener()
                  {
                    public final void onClick(DialogInterface paramAnonymous2DialogInterface, int paramAnonymous2Int)
                    {
                      AppMethodBeat.i(96541);
                      s.a(s.this).abg(12);
                      i.a(s.f(s.this), s.g(s.this), 1, 0, s.h(s.this), s.i(s.this), 1);
                      com.tencent.mm.modelstat.d.d(10, "AdLandingPageDownloadApkBtnComp_TODOWLOAD_MSG_BTN_CLICK", s.a.g.this.hashCode());
                      AppMethodBeat.o(96541);
                    }
                  }, null);
                  AppMethodBeat.o(96542);
                  return;
                }
                int i = s.b(s.this).zPR;
                ae.i("MicroMsg.AdLandingPageDownloadApkBtnComp.GroceryDownload", "showDownloadTip = ".concat(String.valueOf(i)));
                if (i == 1)
                {
                  if (AdLandingPagesProxy.getInstance().isPaused(s.b(s.this).dwb))
                  {
                    s.a.a(s.a.this, 1);
                    AppMethodBeat.o(96542);
                    return;
                  }
                  s.a.a(s.a.this, 0);
                  AppMethodBeat.o(96542);
                  return;
                }
                s.a(s.this).abg(12);
                AppMethodBeat.o(96542);
              }
            });
          }
        case 3: 
          s.a.this.b(s.a.this.zVI);
          AppMethodBeat.o(96544);
          return true;
        case 11: 
          s.a.this.b(s.a.this.zVF);
          AppMethodBeat.o(96544);
          return true;
        }
        s.a.this.b(s.a.this.zVE);
        AppMethodBeat.o(96544);
        return true;
      }
    }
    
    final class h
      extends com.tencent.mm.sdk.d.b
    {
      private boolean zVY;
      
      h() {}
      
      public final void enter()
      {
        AppMethodBeat.i(96546);
        ae.d("MicroMsg.AdLandingPageDownloadApkBtnComp.state", "ToInstallState enter, idx=" + s.b(s.this).zPP);
        super.enter();
        if (!AdLandingPagesProxy.getInstance().isApkExist(s.b(s.this).dwb))
        {
          s.a.this.b(s.a.this.zVF);
          AppMethodBeat.o(96546);
          return;
        }
        ar.f(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(96545);
            s.c(s.this).setVisibility(8);
            s.d(s.this).setVisibility(0);
            s.d(s.this).setText(2131763751);
            AppMethodBeat.o(96545);
          }
        });
        this.zVY = true;
        AppMethodBeat.o(96546);
      }
      
      public final boolean k(Message paramMessage)
      {
        AppMethodBeat.i(96547);
        ae.d("MicroMsg.AdLandingPageDownloadApkBtnComp.state", "ToInstallState, msg=" + paramMessage.what + ", idx=" + s.b(s.this).zPP);
        ae.i("LogStateTransitionState", hashCode() + "[ToInstallState] recv msg.what " + paramMessage.what);
        switch (paramMessage.what)
        {
        case 1: 
        default: 
          AppMethodBeat.o(96547);
          return false;
        case 0: 
          if (AdLandingPagesProxy.getInstance().installApp(s.this.context, s.b(s.this).dwb, s.b(s.this).Lw, s.b(s.this).md5, s.b(s.this).downloadUrl))
          {
            this.zVY = true;
            AppMethodBeat.o(96547);
            return true;
          }
          s.a.a(s.a.this, s.this.context.getString(2131763752));
          s.a.this.b(s.a.this.zVJ);
          AppMethodBeat.o(96547);
          return true;
        case 2: 
          if (!AdLandingPagesProxy.getInstance().isApkExist(s.b(s.this).dwb)) {
            s.a.this.b(s.a.this.zVF);
          }
          AppMethodBeat.o(96547);
          return true;
        }
        if (this.zVY) {
          this.zVY = false;
        }
        s.a.this.b(s.a.this.zVI);
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
        ae.d("MicroMsg.AdLandingPageDownloadApkBtnComp.state", "ToOpenState enter, idx=" + s.b(s.this).zPP);
        if (AdLandingPagesProxy.getInstance().isPkgInstalled(s.b(s.this).Lw))
        {
          ar.f(new Runnable()
          {
            public final void run()
            {
              AppMethodBeat.i(96548);
              s.c(s.this).setVisibility(8);
              s.d(s.this).setVisibility(0);
              s.d(s.this).setText(2131763753);
              AppMethodBeat.o(96548);
            }
          });
          AppMethodBeat.o(96549);
          return;
        }
        s.a.this.b(s.a.this.zVH);
        AppMethodBeat.o(96549);
      }
      
      public final boolean k(Message paramMessage)
      {
        AppMethodBeat.i(96550);
        ae.d("MicroMsg.AdLandingPageDownloadApkBtnComp.state", "ToOpenState, msg=" + paramMessage.what + ", idx=" + s.b(s.this).zPP);
        ae.i("LogStateTransitionState", hashCode() + "[ToOpenState] recv msg.what " + paramMessage.what);
        switch (paramMessage.what)
        {
        default: 
          AppMethodBeat.o(96550);
          return false;
        case 0: 
          if (k.a(s.this.context, s.b(s.this).dwb, s.b(s.this).Lw, "", s.b(s.this).zMz, s.this.dGD, s.this.zsJ, s.this.dAg, 1, 2))
          {
            AppMethodBeat.o(96550);
            return true;
          }
          s.a.a(s.a.this, s.this.context.getString(2131763754));
          s.a.this.b(s.a.this.zVI);
          AppMethodBeat.o(96550);
          return true;
        }
        s.a.this.b(s.a.this.zVF);
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
          if ((!TextUtils.isEmpty(paramContext)) && (paramContext.equals(s.b(s.this).Lw))) {
            s.this.zVw.abg(3);
          }
          AppMethodBeat.o(96553);
          return;
        }
        if ("android.intent.action.PACKAGE_REMOVED".equals(paramContext))
        {
          paramContext = paramIntent.getData().getSchemeSpecificPart();
          if ((!TextUtils.isEmpty(paramContext)) && (paramContext.equals(s.b(s.this).Lw))) {
            s.this.zVw.abg(4);
          }
        }
      }
      AppMethodBeat.o(96553);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.s
 * JD-Core Version:    0.7.0.1
 */