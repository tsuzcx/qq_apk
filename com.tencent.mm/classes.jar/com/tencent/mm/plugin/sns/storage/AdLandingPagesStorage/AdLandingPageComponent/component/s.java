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
import com.tencent.mm.plugin.sns.ad.e.f;
import com.tencent.mm.plugin.sns.data.i;
import com.tencent.mm.plugin.sns.data.k;
import com.tencent.mm.plugin.sns.device.appstore.a;
import com.tencent.mm.plugin.sns.model.AdLandingPagesProxy;
import com.tencent.mm.plugin.sns.model.AdLandingPagesProxy.a;
import com.tencent.mm.plugin.sns.model.AdLandingPagesProxy.e;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.a.g.a;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.ah;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.b;
import com.tencent.mm.plugin.sns.ui.widget.SnsTextProgressBar;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.statemachine.LogStateTransitionState;
import com.tencent.mm.sdk.statemachine.State;
import com.tencent.mm.sdk.statemachine.StateMachine;
import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

public final class s
  extends p
  implements Serializable
{
  private View EdA;
  Button EdB;
  private SnsTextProgressBar EdC;
  a EdD;
  private HandlerThread EdE;
  private b EdF;
  boolean EdG;
  boolean EdH;
  private View.OnClickListener EdI;
  AdLandingPagesProxy.e EdJ;
  String adExtInfo;
  String appId;
  String dRS;
  String uxInfo;
  
  public s(Context paramContext, b paramb, ViewGroup paramViewGroup)
  {
    super(paramContext, paramb, paramViewGroup);
    AppMethodBeat.i(96554);
    this.EdH = true;
    this.appId = "";
    this.uxInfo = "";
    this.adExtInfo = "";
    this.dRS = "";
    this.EdI = new s.1(this);
    this.EdJ = new s.2(this);
    Log.d("MicroMsg.AdLandingPageDownloadApkBtnComp.state", "component create, new BtnStateMachine");
    this.EdE = com.tencent.f.c.d.bqr("apkStateMachine");
    this.EdE.start();
    this.EdD = new a("apkStateMachine", this.EdE.getLooper());
    if ((paramContext instanceof Activity))
    {
      this.EdG = ((Activity)paramContext).getIntent().getBooleanExtra("sns_landing_pages_auto_download_for_action_btn", false);
      this.EdH = true;
      Log.i("MicroMsg.AdLandingPageDownloadApkBtnComp", "autoDownloadFromActionBtn=" + this.EdG + ", activity=" + paramContext + ", idx=" + ((b)this.EcX).DXN + ", appId=" + ((b)this.EcX).dNI + ", wxAppid=" + ((b)this.EcX).DXy + ", useGameDownloader=" + ((b)this.EcX).DXz + ", pkg=" + ((b)this.EcX).LG);
    }
    this.Edn.bo("platform", paramb.DXC);
    this.Edn.kv("appid", paramb.dNI);
    this.Edn.kv("channelId", paramb.channelId);
    this.Edn.kv("pkg", paramb.LG);
    this.Edn.kv("appPageUrlAndroid", paramb.appPageUrl);
    try
    {
      this.appId = Util.nullAsNil(((b)this.EcX).dNI);
      this.uxInfo = Util.nullAsNil(fds().uxInfo);
      this.adExtInfo = Util.nullAsNil(fds().adExtInfo);
      this.dRS = fds().getSnsId();
      AppMethodBeat.o(96554);
      return;
    }
    catch (Throwable paramContext)
    {
      Log.e("MicroMsg.AdLandingPageDownloadApkBtnComp.DownloadToastReport", paramContext.toString());
      AppMethodBeat.o(96554);
    }
  }
  
  private static String kt(String paramString1, String paramString2)
  {
    AppMethodBeat.i(96561);
    if (Util.isNullOrNil(paramString1))
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
  
  protected final void eWT()
  {
    AppMethodBeat.i(96555);
    Object localObject1 = new HashMap();
    ((Map)localObject1).put("fontNormalColor", kt(((b)this.EcX).DXK, "#FFFFFF"));
    ((Map)localObject1).put("fontDisableColor", kt(((b)this.EcX).DXL, "#4CFFFFFF"));
    ((Map)localObject1).put("fontPressedColor", kt(((b)this.EcX).DXM, "#99FFFFFF"));
    ((Map)localObject1).put("NormalColor", kt(((b)this.EcX).DXE, "#1AAD19"));
    ((Map)localObject1).put("PressedColor", kt(((b)this.EcX).DXG, "#179B16"));
    ((Map)localObject1).put("DisableColor", kt(((b)this.EcX).DXF, "#661AAD19"));
    ((Map)localObject1).put("borderNormalColor", kt(((b)this.EcX).DXH, "#179E16"));
    ((Map)localObject1).put("borderPressedColor", kt(((b)this.EcX).DXJ, "#158E14"));
    ((Map)localObject1).put("borderDisableColor", kt(((b)this.EcX).DXI, "#00179E16"));
    int j = Color.parseColor((String)((Map)localObject1).get("fontNormalColor"));
    int k = Color.parseColor((String)((Map)localObject1).get("fontDisableColor"));
    int m = Color.parseColor((String)((Map)localObject1).get("fontPressedColor"));
    int n = Color.parseColor((String)((Map)localObject1).get("NormalColor"));
    int i1 = Color.parseColor((String)((Map)localObject1).get("PressedColor"));
    int i2 = Color.parseColor((String)((Map)localObject1).get("DisableColor"));
    int i3 = (int)((b)this.EcX).DYu;
    int i4 = Color.parseColor((String)((Map)localObject1).get("borderNormalColor"));
    int i5 = Color.parseColor((String)((Map)localObject1).get("borderPressedColor"));
    int i6 = Color.parseColor((String)((Map)localObject1).get("borderDisableColor"));
    int i = this.context.getResources().getDimensionPixelSize(2131165210);
    if (((b)this.EcX).tt > 0.0F) {
      i = (int)((b)this.EcX).tt;
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
    this.EdB.setBackground(localStateListDrawable);
    localObject1 = new int[] { -16842910 };
    localObject2 = new int[] { 16842919 };
    localObject3 = new int[] { 16842910 };
    this.EdB.setTextColor(new ColorStateList(new int[][] { localObject1, localObject2, localObject3 }, new int[] { k, m, j }));
    if (((b)this.EcX).fontSize > 0.0F) {
      this.EdB.setTextSize(0, ((b)this.EcX).fontSize);
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
    this.EdC.setProgressDrawable((Drawable)localObject1);
    this.EdC.setPaintColor(((b)this.EcX).DXM);
    if (((b)this.EcX).height > 0.0F)
    {
      localObject1 = (RelativeLayout.LayoutParams)this.EdA.getLayoutParams();
      ((RelativeLayout.LayoutParams)localObject1).height = ((int)((b)this.EcX).height);
      this.EdA.setLayoutParams((ViewGroup.LayoutParams)localObject1);
    }
    this.EdB.setText(((b)this.EcX).title);
    f.a(this.context, (b)this.EcX, this.EdB);
    Log.d("MicroMsg.AdLandingPageDownloadApkBtnComp.state", "fillItem, sendMsg=11");
    this.EdD.sendMessage(11);
    AppMethodBeat.o(96555);
  }
  
  public final void eWZ()
  {
    AppMethodBeat.i(96557);
    super.eWZ();
    Log.d("MicroMsg.AdLandingPageDownloadApkBtnComp.state", "viewWillAppear, sendMsg=2");
    this.EdD.sendMessage(2);
    AdLandingPagesProxy.getInstance().addReportInfo(((b)this.EcX).dNI, fds().aid, fds().kZe, fds().uxInfo);
    AppMethodBeat.o(96557);
  }
  
  public final void eXd()
  {
    AppMethodBeat.i(96558);
    super.eXd();
    Log.i("MicroMsg.AdLandingPageDownloadApkBtnComp", "view destroy");
    this.EdE.quit();
    if (this.EdF != null)
    {
      this.context.unregisterReceiver(this.EdF);
      this.EdF = null;
    }
    AppMethodBeat.o(96558);
  }
  
  @TargetApi(17)
  public final void eXe()
  {
    AppMethodBeat.i(96556);
    this.clickCount = 0;
    Object localObject = this.contentView;
    this.EdA = ((View)localObject).findViewById(2131299792);
    this.EdB = ((Button)((View)localObject).findViewById(2131299751));
    this.EdB.setOnClickListener(this.EdI);
    this.EdC = ((SnsTextProgressBar)((View)localObject).findViewById(2131299777));
    this.EdC.setProgress(0);
    this.EdC.setVisibility(8);
    this.EdC.setOnClickListener(this.EdI);
    Log.d("MicroMsg.AdLandingPageDownloadApkBtnComp.state", "createView, BtnStateMachine start");
    this.EdD.start();
    try
    {
      localObject = (b)this.EcX;
      if (((b)localObject).DXQ > 0)
      {
        if (!a.aU(((b)localObject).DXR)) {
          break label167;
        }
        l.a(fds(), 4, "0", "");
      }
      for (;;)
      {
        l.a(fds(), 1, "1", "");
        AppMethodBeat.o(96556);
        return;
        label167:
        l.a(fds(), 4, "1", "");
      }
      return;
    }
    catch (Exception localException)
    {
      Log.w("MicroMsg.AdLandingPageDownloadApkBtnComp", "report19790 has something wrong");
      AppMethodBeat.o(96556);
    }
  }
  
  final boolean fdA()
  {
    AppMethodBeat.i(202979);
    for (;;)
    {
      try
      {
        boolean bool1 = NetStatusUtil.isWifi(this.context);
        boolean bool2 = AdLandingPagesProxy.getInstance().isFreeSimCard();
        Log.i("MicroMsg.AdLandingPageDownloadApkBtnComp", "isNeedShowNetworkTip, isWifi=" + bool1 + ", isFreeSimCard=" + bool2);
        if (bool1)
        {
          com.tencent.mm.plugin.report.service.h.CyF.dN(1612, 2);
          if ((bool1) || (bool2)) {
            break;
          }
          AppMethodBeat.o(202979);
          return true;
        }
        if (bool2) {
          com.tencent.mm.plugin.report.service.h.CyF.dN(1612, 3);
        } else {
          com.tencent.mm.plugin.report.service.h.CyF.dN(1612, 4);
        }
      }
      catch (Throwable localThrowable)
      {
        Log.e("MicroMsg.AdLandingPageDownloadApkBtnComp", "isNeedShowNetworkTip exp=" + localThrowable.toString());
        AppMethodBeat.o(202979);
        return false;
      }
    }
    AppMethodBeat.o(202979);
    return false;
  }
  
  public final void fdz()
  {
    AppMethodBeat.i(96560);
    Log.d("MicroMsg.AdLandingPageDownloadApkBtnComp", "writing deferred deep link");
    AdLandingPagesProxy.getInstance().writeDeferredDeepLink(((b)this.EcX).LG, ((b)this.EcX).appPageUrl);
    k.jZ(((b)this.EcX).LG, ((b)this.EcX).appPageUrl);
    AppMethodBeat.o(96560);
  }
  
  protected final int getLayout()
  {
    return 2131496365;
  }
  
  final class a
    extends StateMachine
    implements Serializable
  {
    State EdL;
    State EdM;
    State EdN;
    State EdO;
    State EdP;
    State EdQ;
    State EdR;
    State EdS;
    State EdT;
    
    protected a(String paramString, Looper paramLooper)
    {
      super(paramLooper);
      AppMethodBeat.i(96551);
      this.EdL = new c();
      this.EdM = new g();
      this.EdN = new e();
      this.EdO = new h();
      this.EdP = new i();
      this.EdQ = new f();
      this.EdR = new b();
      this.EdS = new a();
      this.EdT = new d();
      addState(this.EdM);
      addState(this.EdL);
      addState(this.EdN);
      addState(this.EdO);
      addState(this.EdP);
      addState(this.EdQ);
      addState(this.EdR);
      addState(this.EdS);
      addState(this.EdT);
      setInitialState(this.EdT);
      AppMethodBeat.o(96551);
    }
    
    final class a
      extends LogStateTransitionState
    {
      a() {}
      
      public final void enter()
      {
        AppMethodBeat.i(96513);
        super.enter();
        Log.d("MicroMsg.AdLandingPageDownloadApkBtnComp.state", "DisableUnsupportPlatformState enter, idx=" + s.b(s.this).DXN);
        MMHandlerThread.postToMainThread(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(96512);
            s.c(s.this).setVisibility(8);
            s.d(s.this).setEnabled(false);
            Button localButton = s.d(s.this);
            if (!TextUtils.isEmpty(s.b(s.this).DXD)) {}
            for (String str = s.b(s.this).DXD;; str = "暂不支持安卓手机")
            {
              localButton.setText(str);
              s.d(s.this).setVisibility(0);
              f.a(s.this.context, s.b(s.this), s.d(s.this));
              AppMethodBeat.o(96512);
              return;
            }
          }
        });
        AppMethodBeat.o(96513);
      }
    }
    
    final class b
      extends LogStateTransitionState
    {
      b() {}
      
      public final void enter()
      {
        AppMethodBeat.i(96515);
        super.enter();
        Log.d("MicroMsg.AdLandingPageDownloadApkBtnComp.state", "DoNetSceneState enter, idx=" + s.b(s.this).DXN);
        AdLandingPagesProxy.getInstance().doAdChannelScene(s.b(s.this).LG, s.b(s.this).channelId, s.this.EdJ, s.b(s.this).DXz);
        Log.i("LogStateTransitionState", "[DoNetSceneState], appid=" + s.b(s.this).dNI + ", pkg=" + s.b(s.this).LG + ", channelId=" + s.b(s.this).channelId + ", useGameDownloadWidget=" + s.b(s.this).DXz + ", hash=" + hashCode());
        AppMethodBeat.o(96515);
      }
      
      public final boolean processMessage(Message paramMessage)
      {
        AppMethodBeat.i(96514);
        Log.d("MicroMsg.AdLandingPageDownloadApkBtnComp.state", "DoNetSceneState msg=" + paramMessage.what + ", idx=" + s.b(s.this).DXN);
        Log.i("LogStateTransitionState", hashCode() + "[DoNetSceneState]recv msg.what " + paramMessage.what);
        if (AdLandingPagesProxy.getInstance().isApkExist(s.b(s.this).dNI))
        {
          s.a.l(s.a.this, s.a.this.EdO);
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
          s.a.m(s.a.this, s.a.this.EdM);
          AppMethodBeat.o(96514);
          return true;
        case 5: 
          s.a.a(s.a.this, s.this.context.getString(2131765948));
          s.a.n(s.a.this, s.a.this.EdQ);
          AppMethodBeat.o(96514);
          return true;
        }
        s.a.o(s.a.this, s.a.this.EdM);
        AppMethodBeat.o(96514);
        return true;
      }
    }
    
    final class c
      extends LogStateTransitionState
    {
      AdLandingPagesProxy.a EdY;
      
      c() {}
      
      public final void enter()
      {
        AppMethodBeat.i(96527);
        super.enter();
        Log.d("MicroMsg.AdLandingPageDownloadApkBtnComp.state", "DownloadingState enter, idx=" + s.b(s.this).DXN);
        MMHandlerThread.postToMainThread(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(96516);
            s.d(s.this).setVisibility(8);
            s.c(s.this).setVisibility(0);
            AppMethodBeat.o(96516);
          }
        });
        if ((AdLandingPagesProxy.getInstance().isPaused(s.b(s.this).dNI)) || (AdLandingPagesProxy.getInstance().isDownloading(s.b(s.this).dNI)))
        {
          if (this.EdY == null) {
            this.EdY = new a((byte)0);
          }
          MMHandlerThread.postToMainThread(new Runnable()
          {
            public final void run()
            {
              AppMethodBeat.i(96517);
              s.c(s.this).setProgress(AdLandingPagesProxy.getInstance().getTaskProgress(s.b(s.this).dNI));
              AppMethodBeat.o(96517);
            }
          });
          if (!AdLandingPagesProxy.getInstance().resumeTask(s.b(s.this).dNI, this.EdY, s.this.fds().aid, s.this.fds().kZe, s.this.fds().uxInfo))
          {
            AdLandingPagesProxy.getInstance().stopTask(s.b(s.this).dNI);
            s.a.p(s.a.this, s.a.this.EdL);
            AppMethodBeat.o(96527);
          }
        }
        else
        {
          if (TextUtils.isEmpty(s.b(s.this).downloadUrl))
          {
            s.a.q(s.a.this, s.a.this.EdR);
            AppMethodBeat.o(96527);
            return;
          }
          if (AdLandingPagesProxy.getInstance().isApkExist(s.b(s.this).dNI))
          {
            MMHandlerThread.postToMainThread(new Runnable()
            {
              public final void run()
              {
                AppMethodBeat.i(96518);
                s.c(s.this).setProgress(100);
                AppMethodBeat.o(96518);
              }
            });
            s.a.r(s.a.this, s.a.this.EdO);
            AppMethodBeat.o(96527);
            return;
          }
          AdLandingPagesProxy.getInstance().stopTask(s.b(s.this).dNI);
          this.EdY = new a((byte)0);
          AdLandingPagesProxy.getInstance().startDownload(s.b(s.this).dNI, s.b(s.this).DXy, s.b(s.this).LG, s.b(s.this).md5, s.b(s.this).downloadUrl, s.b(s.this).DXA, s.b(s.this).DXB, this.EdY, s.this.fds().aid, s.this.fds().kZe, s.this.fds().uxInfo, s.b(s.this).DXz);
        }
        AppMethodBeat.o(96527);
      }
      
      public final boolean processMessage(Message paramMessage)
      {
        AppMethodBeat.i(96528);
        if (paramMessage.what != 1) {
          Log.d("MicroMsg.AdLandingPageDownloadApkBtnComp.state", "DownloadingState, msg=" + paramMessage.what + ", idx=" + s.b(s.this).DXN);
        }
        Log.i("LogStateTransitionState", hashCode() + "[DownloadingState] recv msg.what " + paramMessage.what);
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
          if ((AdLandingPagesProxy.getInstance().pauseTask(s.b(s.this).dNI)) && (AdLandingPagesProxy.getInstance().isPaused(s.b(s.this).dNI))) {
            s.a.s(s.a.this, s.a.this.EdN);
          }
          AppMethodBeat.o(96528);
          return true;
        case 1: 
          MMHandlerThread.postToMainThread(new Runnable()
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
          s.a.t(s.a.this, s.a.this.EdP);
          AppMethodBeat.o(96528);
          return true;
        case 7: 
          s.a.u(s.a.this, s.a.this.EdN);
          AppMethodBeat.o(96528);
          return true;
        case 8: 
          s.a.a(s.a.this, s.this.context.getString(2131765948));
          s.a.v(s.a.this, s.a.this.EdQ);
          AppMethodBeat.o(96528);
          return true;
        }
        s.this.fdz();
        s.a.w(s.a.this, s.a.this.EdO);
        AppMethodBeat.o(96528);
        return true;
      }
      
      final class a
        implements AdLandingPagesProxy.a
      {
        private a() {}
        
        public final void Yr(int paramInt)
        {
          AppMethodBeat.i(96521);
          if (paramInt % 20 == 0) {
            Log.d("MicroMsg.AdLandingPageDownloadApkBtnComp.callback", "progress:" + paramInt + ", idx=" + s.b(s.this).DXN);
          }
          s.a(s.this).sendMessage(1, paramInt);
          AppMethodBeat.o(96521);
        }
        
        public final void eZP()
        {
          AppMethodBeat.i(96522);
          Log.d("MicroMsg.AdLandingPageDownloadApkBtnComp.callback", "paused, idx=" + s.b(s.this).DXN);
          s.a(s.this).sendMessage(7);
          AppMethodBeat.o(96522);
        }
        
        public final void eZQ()
        {
          AppMethodBeat.i(96523);
          Log.d("MicroMsg.AdLandingPageDownloadApkBtnComp.callback", "stopped, idx=" + s.b(s.this).DXN);
          AppMethodBeat.o(96523);
        }
        
        public final void eZR()
        {
          AppMethodBeat.i(96524);
          Log.d("MicroMsg.AdLandingPageDownloadApkBtnComp.callback", "succeed, idx=" + s.b(s.this).DXN);
          s.a(s.this).sendMessage(9);
          AppMethodBeat.o(96524);
        }
        
        public final void eZS()
        {
          AppMethodBeat.i(96525);
          Log.d("MicroMsg.AdLandingPageDownloadApkBtnComp.callback", "failed, idx=" + s.b(s.this).DXN);
          s.a(s.this).sendMessage(8);
          AppMethodBeat.o(96525);
        }
        
        public final void eZT()
        {
          AppMethodBeat.i(96526);
          Log.d("MicroMsg.AdLandingPageDownloadApkBtnComp.callback", "resumed, idx=" + s.b(s.this).DXN);
          s.a(s.this).sendMessage(13);
          AppMethodBeat.o(96526);
        }
        
        public final void start()
        {
          AppMethodBeat.i(96520);
          Log.d("MicroMsg.AdLandingPageDownloadApkBtnComp.callback", "start, idx=" + s.b(s.this).DXN);
          AppMethodBeat.o(96520);
        }
      }
    }
    
    final class d
      extends LogStateTransitionState
    {
      d() {}
      
      public final void enter()
      {
        AppMethodBeat.i(96529);
        super.enter();
        Log.d("MicroMsg.AdLandingPageDownloadApkBtnComp.state", "InitState enter, idx=" + s.b(s.this).DXN);
        b localb = s.b(s.this);
        int i;
        if ((localb.DXC == 0) || (localb.DXC == 2)) {
          i = 1;
        }
        while (i != 0) {
          if (AdLandingPagesProxy.getInstance().isApkExist(s.b(s.this).dNI))
          {
            s.a.a(s.a.this, s.a.this.EdO);
            AppMethodBeat.o(96529);
            return;
            i = 0;
          }
          else
          {
            if (AdLandingPagesProxy.getInstance().isPkgInstalled(s.b(s.this).LG))
            {
              s.a.b(s.a.this, s.a.this.EdP);
              AppMethodBeat.o(96529);
              return;
            }
            s.a.c(s.a.this, s.a.this.EdR);
            AppMethodBeat.o(96529);
            return;
          }
        }
        s.a.d(s.a.this, s.a.this.EdS);
        AppMethodBeat.o(96529);
      }
    }
    
    final class e
      extends LogStateTransitionState
    {
      e() {}
      
      public final void enter()
      {
        AppMethodBeat.i(96532);
        super.enter();
        Log.d("MicroMsg.AdLandingPageDownloadApkBtnComp.state", "PauseState enter, idx=" + s.b(s.this).DXN);
        MMHandlerThread.postToMainThread(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(96530);
            s.c(s.this).setVisibility(8);
            s.d(s.this).setVisibility(0);
            s.d(s.this).setText(2131765947);
            f.a(s.this.context, s.b(s.this), s.d(s.this));
            AppMethodBeat.o(96530);
          }
        });
        AppMethodBeat.o(96532);
      }
      
      public final boolean processMessage(Message paramMessage)
      {
        AppMethodBeat.i(96533);
        Log.d("MicroMsg.AdLandingPageDownloadApkBtnComp.state", "PauseState, msg=" + paramMessage.what + ", idx=" + s.b(s.this).DXN);
        Log.i("LogStateTransitionState", hashCode() + "[PauseState] recv msg.what " + paramMessage.what);
        switch (paramMessage.what)
        {
        default: 
          AppMethodBeat.o(96533);
          return false;
        case 0: 
          if (AdLandingPagesProxy.getInstance().isDownloading(s.b(s.this).dNI)) {
            s.a.a(s.a.this, s.this.context.getString(2131765946));
          }
          for (;;)
          {
            AppMethodBeat.o(96533);
            return true;
            if (s.this.fdA())
            {
              Log.i("LogStateTransitionState", "download not in wifi!");
              i.a(s.this.dRS, s.this.appId, 0, 1, s.this.uxInfo, s.this.adExtInfo, 1);
              com.tencent.mm.ui.base.h.a(s.this.context, 2131768552, 2131768553, new DialogInterface.OnClickListener()
              {
                public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
                {
                  AppMethodBeat.i(96531);
                  s.a.this.sendMessage(12);
                  i.a(s.f(s.this), s.g(s.this), 1, 1, s.h(s.this), s.i(s.this), 1);
                  com.tencent.mm.modelstat.d.d(10, "AdLandingPageDownloadApkBtnComp_PAUSE_MSG_BTN_CLICK", s.a.e.this.hashCode());
                  AppMethodBeat.o(96531);
                }
              }, null);
            }
            else
            {
              int i = s.b(s.this).DXP;
              Log.i("MicroMsg.AdLandingPageDownloadApkBtnComp.GroceryDownload", "showDownloadTip = ".concat(String.valueOf(i)));
              if (i == 1) {
                s.a.a(s.a.this, 1);
              } else {
                s.a.this.sendMessage(12);
              }
            }
          }
        case 3: 
          s.a.x(s.a.this, s.a.this.EdP);
          AppMethodBeat.o(96533);
          return true;
        case 8: 
          s.a.a(s.a.this, s.this.context.getString(2131765948));
          s.a.y(s.a.this, s.a.this.EdQ);
          AppMethodBeat.o(96533);
          return true;
        case 12: 
          s.a.z(s.a.this, s.a.this.EdL);
          AppMethodBeat.o(96533);
          return true;
        }
        s.a.A(s.a.this, s.a.this.EdL);
        AppMethodBeat.o(96533);
        return true;
      }
    }
    
    final class f
      extends LogStateTransitionState
    {
      f() {}
      
      public final void enter()
      {
        AppMethodBeat.i(96535);
        super.enter();
        Log.d("MicroMsg.AdLandingPageDownloadApkBtnComp.state", "ReDownloadState enter, idx=" + s.b(s.this).DXN);
        MMHandlerThread.postToMainThread(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(96534);
            s.c(s.this).setVisibility(8);
            s.d(s.this).setVisibility(0);
            s.d(s.this).setText(2131765953);
            f.a(s.this.context, s.b(s.this), s.d(s.this));
            AppMethodBeat.o(96534);
          }
        });
        AppMethodBeat.o(96535);
      }
      
      public final boolean processMessage(Message paramMessage)
      {
        AppMethodBeat.i(96536);
        Log.d("MicroMsg.AdLandingPageDownloadApkBtnComp.state", "ReDownloadState, msg=" + paramMessage.what + ", idx=" + s.b(s.this).DXN);
        Log.i("LogStateTransitionState", hashCode() + "[ReDownloadState] recv msg.what " + paramMessage.what);
        switch (paramMessage.what)
        {
        default: 
          AppMethodBeat.o(96536);
          return false;
        }
        s.a.I(s.a.this, s.a.this.EdR);
        AppMethodBeat.o(96536);
        return true;
      }
    }
    
    final class g
      extends LogStateTransitionState
    {
      g() {}
      
      public final void enter()
      {
        AppMethodBeat.i(96543);
        super.enter();
        Log.d("MicroMsg.AdLandingPageDownloadApkBtnComp.state", "ToDownloadState enter, idx=" + s.b(s.this).DXN);
        MMHandlerThread.postToMainThread(new Runnable()
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
        if (AdLandingPagesProxy.getInstance().isPkgInstalled(s.b(s.this).LG))
        {
          s.a.e(s.a.this, s.a.this.EdP);
          AppMethodBeat.o(96543);
          return;
        }
        if (AdLandingPagesProxy.getInstance().isApkExist(s.b(s.this).dNI))
        {
          s.a.f(s.a.this, s.a.this.EdO);
          AppMethodBeat.o(96543);
          return;
        }
        if (AdLandingPagesProxy.getInstance().isDownloading(s.b(s.this).dNI))
        {
          s.a.g(s.a.this, s.a.this.EdL);
          AppMethodBeat.o(96543);
          return;
        }
        if (AdLandingPagesProxy.getInstance().isPaused(s.b(s.this).dNI))
        {
          s.a.h(s.a.this, s.a.this.EdN);
          AppMethodBeat.o(96543);
          return;
        }
        MMHandlerThread.postToMainThread(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(96538);
            s.c(s.this).setVisibility(8);
            s.d(s.this).setVisibility(0);
            s.d(s.this).setText(s.b(s.this).title);
            f.a(s.this.context, s.b(s.this), s.d(s.this));
            AppMethodBeat.o(96538);
          }
        });
        boolean bool;
        if (s.this.EdG) {
          if (s.this.fds().DZX) {
            bool = s.b(s.this).DXO;
          }
        }
        for (;;)
        {
          if ((bool) && (s.this.EdH))
          {
            s.this.EdH = false;
            MMHandlerThread.postToMainThreadDelayed(new Runnable()
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
                  for (String str = s.this.context.getString(2131765931, new Object[] { s.b(s.this).DXA, str });; str = s.this.context.getString(2131765930, new Object[] { s.b(s.this).DXA }))
                  {
                    i.a(s.f(s.this), s.g(s.this), 0, 0, s.h(s.this), s.i(s.this), 1);
                    com.tencent.mm.ui.base.h.a(s.this.context, str, "", new DialogInterface.OnClickListener()
                    {
                      public final void onClick(DialogInterface paramAnonymous2DialogInterface, int paramAnonymous2Int)
                      {
                        AppMethodBeat.i(96539);
                        s.a(s.this).sendMessage(0);
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
                  Log.e("LogStateTransitionState", "showAutoDownloadDialog exp=" + localException.toString());
                  AppMethodBeat.o(96540);
                }
              }
            }, 800L);
          }
          AppMethodBeat.o(96543);
          return;
          if (s.b(s.this).DXN == 0)
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
      
      public final boolean processMessage(Message paramMessage)
      {
        AppMethodBeat.i(96544);
        Log.d("MicroMsg.AdLandingPageDownloadApkBtnComp.state", "ToDownloadState, msg=" + paramMessage.what + ", idx=" + s.b(s.this).DXN);
        Log.i("LogStateTransitionState", hashCode() + "[ToDownloadState]recv msg.what " + paramMessage.what);
        switch (paramMessage.what)
        {
        default: 
          AppMethodBeat.o(96544);
          return false;
        case 0: 
          if (AdLandingPagesProxy.getInstance().isDownloading(s.b(s.this).dNI)) {
            s.a.a(s.a.this, s.this.context.getString(2131765946));
          }
          for (;;)
          {
            AppMethodBeat.o(96544);
            return true;
            MMHandlerThread.postToMainThread(new Runnable()
            {
              public final void run()
              {
                AppMethodBeat.i(96542);
                if (s.j(s.this))
                {
                  Log.i("LogStateTransitionState", "download not in wifi!");
                  i.a(s.f(s.this), s.g(s.this), 0, 0, s.h(s.this), s.i(s.this), 1);
                  com.tencent.mm.ui.base.h.a(s.this.context, 2131768552, 2131768553, new DialogInterface.OnClickListener()
                  {
                    public final void onClick(DialogInterface paramAnonymous2DialogInterface, int paramAnonymous2Int)
                    {
                      AppMethodBeat.i(96541);
                      s.a(s.this).sendMessage(12);
                      i.a(s.f(s.this), s.g(s.this), 1, 0, s.h(s.this), s.i(s.this), 1);
                      com.tencent.mm.modelstat.d.d(10, "AdLandingPageDownloadApkBtnComp_TODOWLOAD_MSG_BTN_CLICK", s.a.g.this.hashCode());
                      AppMethodBeat.o(96541);
                    }
                  }, null);
                  AppMethodBeat.o(96542);
                  return;
                }
                int i = s.b(s.this).DXP;
                Log.i("MicroMsg.AdLandingPageDownloadApkBtnComp.GroceryDownload", "showDownloadTip = ".concat(String.valueOf(i)));
                if (i == 1)
                {
                  if (AdLandingPagesProxy.getInstance().isPaused(s.b(s.this).dNI))
                  {
                    s.a.a(s.a.this, 1);
                    AppMethodBeat.o(96542);
                    return;
                  }
                  s.a.a(s.a.this, 0);
                  AppMethodBeat.o(96542);
                  return;
                }
                s.a(s.this).sendMessage(12);
                AppMethodBeat.o(96542);
              }
            });
          }
        case 3: 
          s.a.i(s.a.this, s.a.this.EdP);
          AppMethodBeat.o(96544);
          return true;
        case 11: 
          s.a.j(s.a.this, s.a.this.EdM);
          AppMethodBeat.o(96544);
          return true;
        }
        s.a.k(s.a.this, s.a.this.EdL);
        AppMethodBeat.o(96544);
        return true;
      }
    }
    
    final class h
      extends LogStateTransitionState
    {
      private boolean Eef;
      
      h() {}
      
      public final void enter()
      {
        AppMethodBeat.i(96546);
        Log.d("MicroMsg.AdLandingPageDownloadApkBtnComp.state", "ToInstallState enter, idx=" + s.b(s.this).DXN);
        super.enter();
        if (!AdLandingPagesProxy.getInstance().isApkExist(s.b(s.this).dNI))
        {
          s.a.B(s.a.this, s.a.this.EdM);
          AppMethodBeat.o(96546);
          return;
        }
        MMHandlerThread.postToMainThread(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(96545);
            s.c(s.this).setVisibility(8);
            s.d(s.this).setVisibility(0);
            s.d(s.this).setText(2131765949);
            f.a(s.this.context, s.b(s.this), s.d(s.this));
            AppMethodBeat.o(96545);
          }
        });
        this.Eef = true;
        AppMethodBeat.o(96546);
      }
      
      public final boolean processMessage(Message paramMessage)
      {
        AppMethodBeat.i(96547);
        Log.d("MicroMsg.AdLandingPageDownloadApkBtnComp.state", "ToInstallState, msg=" + paramMessage.what + ", idx=" + s.b(s.this).DXN);
        Log.i("LogStateTransitionState", hashCode() + "[ToInstallState] recv msg.what " + paramMessage.what);
        switch (paramMessage.what)
        {
        case 1: 
        default: 
          AppMethodBeat.o(96547);
          return false;
        case 0: 
          if (AdLandingPagesProxy.getInstance().installApp(s.this.context, s.b(s.this).dNI, s.b(s.this).LG, s.b(s.this).md5, s.b(s.this).downloadUrl))
          {
            this.Eef = true;
            AppMethodBeat.o(96547);
            return true;
          }
          s.a.a(s.a.this, s.this.context.getString(2131765950));
          s.a.C(s.a.this, s.a.this.EdQ);
          AppMethodBeat.o(96547);
          return true;
        case 2: 
          if (!AdLandingPagesProxy.getInstance().isApkExist(s.b(s.this).dNI)) {
            s.a.D(s.a.this, s.a.this.EdM);
          }
          AppMethodBeat.o(96547);
          return true;
        }
        if (this.Eef) {
          this.Eef = false;
        }
        s.a.E(s.a.this, s.a.this.EdP);
        AppMethodBeat.o(96547);
        return true;
      }
    }
    
    final class i
      extends LogStateTransitionState
    {
      i() {}
      
      public final void enter()
      {
        AppMethodBeat.i(96549);
        super.enter();
        Log.d("MicroMsg.AdLandingPageDownloadApkBtnComp.state", "ToOpenState enter, idx=" + s.b(s.this).DXN);
        if (AdLandingPagesProxy.getInstance().isPkgInstalled(s.b(s.this).LG))
        {
          MMHandlerThread.postToMainThread(new Runnable()
          {
            public final void run()
            {
              AppMethodBeat.i(96548);
              s.c(s.this).setVisibility(8);
              s.d(s.this).setVisibility(0);
              s.d(s.this).setText(2131765951);
              f.a(s.this.context, s.b(s.this), s.d(s.this));
              AppMethodBeat.o(96548);
            }
          });
          AppMethodBeat.o(96549);
          return;
        }
        s.a.F(s.a.this, s.a.this.EdO);
        AppMethodBeat.o(96549);
      }
      
      public final boolean processMessage(Message paramMessage)
      {
        AppMethodBeat.i(96550);
        Log.d("MicroMsg.AdLandingPageDownloadApkBtnComp.state", "ToOpenState, msg=" + paramMessage.what + ", idx=" + s.b(s.this).DXN);
        Log.i("LogStateTransitionState", hashCode() + "[ToOpenState] recv msg.what " + paramMessage.what);
        switch (paramMessage.what)
        {
        default: 
          AppMethodBeat.o(96550);
          return false;
        case 0: 
          if (k.a(s.this.context, s.b(s.this).dNI, s.b(s.this).LG, "", s.b(s.this).appPageUrl, s.this.uxInfo, s.this.adExtInfo, s.this.dRS, 1, 2))
          {
            AppMethodBeat.o(96550);
            return true;
          }
          s.a.a(s.a.this, s.this.context.getString(2131765952));
          s.a.G(s.a.this, s.a.this.EdP);
          AppMethodBeat.o(96550);
          return true;
        }
        s.a.H(s.a.this, s.a.this.EdM);
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
          if ((!TextUtils.isEmpty(paramContext)) && (paramContext.equals(s.b(s.this).LG))) {
            s.this.EdD.sendMessage(3);
          }
          AppMethodBeat.o(96553);
          return;
        }
        if ("android.intent.action.PACKAGE_REMOVED".equals(paramContext))
        {
          paramContext = paramIntent.getData().getSchemeSpecificPart();
          if ((!TextUtils.isEmpty(paramContext)) && (paramContext.equals(s.b(s.this).LG))) {
            s.this.EdD.sendMessage(4);
          }
        }
      }
      AppMethodBeat.o(96553);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.s
 * JD-Core Version:    0.7.0.1
 */