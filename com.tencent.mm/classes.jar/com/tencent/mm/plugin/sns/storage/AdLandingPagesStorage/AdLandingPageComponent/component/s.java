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
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.sns.ad.d.i;
import com.tencent.mm.plugin.sns.data.c.a;
import com.tencent.mm.plugin.sns.data.k;
import com.tencent.mm.plugin.sns.data.m;
import com.tencent.mm.plugin.sns.i.d;
import com.tencent.mm.plugin.sns.i.f;
import com.tencent.mm.plugin.sns.i.g;
import com.tencent.mm.plugin.sns.i.j;
import com.tencent.mm.plugin.sns.model.AdLandingPagesProxy;
import com.tencent.mm.plugin.sns.model.AdLandingPagesProxy.a;
import com.tencent.mm.plugin.sns.model.AdLandingPagesProxy.e;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.a.g.a;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.ai;
import com.tencent.mm.plugin.sns.ui.widget.SnsTextProgressBar;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.sdk.platformtools.NetStatusUtil;
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
  String JEE;
  int JPL;
  private View Krd;
  Button Kre;
  SnsTextProgressBar Krf;
  b Krg;
  private HandlerThread Krh;
  private c Kri;
  boolean Krj;
  boolean Krk;
  volatile boolean Krl;
  private View.OnClickListener Krm;
  AdLandingPagesProxy.e Krn;
  String adExtInfo;
  String appId;
  int enterScene;
  String fLp;
  String nTp;
  String owd;
  String pId;
  String uxInfo;
  
  public s(Context paramContext, com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.b paramb, ViewGroup paramViewGroup)
  {
    super(paramContext, paramb, paramViewGroup);
    AppMethodBeat.i(96554);
    this.Krk = true;
    this.appId = "";
    this.uxInfo = "";
    this.adExtInfo = "";
    this.fLp = "";
    this.Krl = false;
    this.JEE = "";
    this.pId = "";
    this.nTp = "";
    this.owd = "";
    this.JPL = 2;
    this.Krm = new s.1(this);
    this.Krn = new s.2(this);
    Log.d("MicroMsg.AdLandingPageDownloadApkBtnComp.state", "component create, new BtnStateMachine");
    this.Krh = com.tencent.e.c.d.bDk("apkStateMachine");
    this.Krh.start();
    this.Krg = new b("apkStateMachine", this.Krh.getLooper());
    if ((paramContext instanceof Activity))
    {
      this.Krj = ((Activity)paramContext).getIntent().getBooleanExtra("sns_landing_pages_auto_download_for_action_btn", false);
      this.Krk = true;
      Log.i("MicroMsg.AdLandingPageDownloadApkBtnComp", "autoDownloadFromActionBtn=" + this.Krj + ", activity=" + paramContext + ", idx=" + ((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.b)this.KqB).KkW + ", appId=" + ((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.b)this.KqB).appid + ", wxAppid=" + ((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.b)this.KqB).KkH + ", useGameDownloader=" + ((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.b)this.KqB).KkI + ", pkg=" + ((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.b)this.KqB).abY);
    }
    this.KqQ.br("platform", paramb.KkL);
    this.KqQ.kQ("appid", paramb.appid);
    this.KqQ.kQ("channelId", paramb.channelId);
    this.KqQ.kQ("pkg", paramb.abY);
    this.KqQ.kQ("appPageUrlAndroid", paramb.JxO);
    try
    {
      this.appId = Util.nullAsNil(((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.b)this.KqB).appid);
      this.uxInfo = Util.nullAsNil(fRp().uxInfo);
      this.adExtInfo = Util.nullAsNil(fRp().adExtInfo);
      this.fLp = fRp().getSnsId();
      this.JEE = Util.nullAsNil(fRp().aid);
      this.pId = Util.nullAsNil(fRp().pId);
      this.enterScene = fRp().source;
      this.nTp = Util.nullAsNil(fRp().nTp);
      this.owd = Util.nullAsNil(fRp().owd);
      AppMethodBeat.o(96554);
      return;
    }
    catch (Throwable paramContext)
    {
      Log.e("MicroMsg.AdLandingPageDownloadApkBtnComp.DownloadToastReport", paramContext.toString());
      AppMethodBeat.o(96554);
    }
  }
  
  private static String kO(String paramString1, String paramString2)
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
  
  protected final void fKe()
  {
    AppMethodBeat.i(96555);
    Object localObject1 = new HashMap();
    ((Map)localObject1).put("fontNormalColor", kO(((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.b)this.KqB).KkT, "#FFFFFF"));
    ((Map)localObject1).put("fontDisableColor", kO(((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.b)this.KqB).KkU, "#4CFFFFFF"));
    ((Map)localObject1).put("fontPressedColor", kO(((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.b)this.KqB).KkV, "#99FFFFFF"));
    ((Map)localObject1).put("NormalColor", kO(((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.b)this.KqB).KkN, "#1AAD19"));
    ((Map)localObject1).put("PressedColor", kO(((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.b)this.KqB).KkP, "#179B16"));
    ((Map)localObject1).put("DisableColor", kO(((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.b)this.KqB).KkO, "#661AAD19"));
    ((Map)localObject1).put("borderNormalColor", kO(((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.b)this.KqB).KkQ, "#179E16"));
    ((Map)localObject1).put("borderPressedColor", kO(((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.b)this.KqB).KkS, "#158E14"));
    ((Map)localObject1).put("borderDisableColor", kO(((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.b)this.KqB).KkR, "#00179E16"));
    int j = Color.parseColor((String)((Map)localObject1).get("fontNormalColor"));
    int k = Color.parseColor((String)((Map)localObject1).get("fontDisableColor"));
    int m = Color.parseColor((String)((Map)localObject1).get("fontPressedColor"));
    int n = Color.parseColor((String)((Map)localObject1).get("NormalColor"));
    int i1 = Color.parseColor((String)((Map)localObject1).get("PressedColor"));
    int i2 = Color.parseColor((String)((Map)localObject1).get("DisableColor"));
    int i3 = (int)((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.b)this.KqB).KlN;
    int i4 = Color.parseColor((String)((Map)localObject1).get("borderNormalColor"));
    int i5 = Color.parseColor((String)((Map)localObject1).get("borderPressedColor"));
    int i6 = Color.parseColor((String)((Map)localObject1).get("borderDisableColor"));
    int i = this.context.getResources().getDimensionPixelSize(i.d.ButtonCornerSize);
    if (((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.b)this.KqB).bDI > 0.0F) {
      i = (int)((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.b)this.KqB).bDI;
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
    this.Kre.setBackground(localStateListDrawable);
    this.Kre.setTextColor(new ColorStateList(new int[][] { { -16842910 }, { 16842919 }, { 16842910 } }, new int[] { k, m, j }));
    if (((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.b)this.KqB).fontSize > 0.0F) {
      this.Kre.setTextSize(0, ((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.b)this.KqB).fontSize);
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
    this.Krf.setProgressDrawable((Drawable)localObject1);
    this.Krf.setPaintColor(((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.b)this.KqB).KkV);
    if (((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.b)this.KqB).height > 0.0F)
    {
      localObject1 = (RelativeLayout.LayoutParams)this.Krd.getLayoutParams();
      ((RelativeLayout.LayoutParams)localObject1).height = ((int)((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.b)this.KqB).height);
      this.Krd.setLayoutParams((ViewGroup.LayoutParams)localObject1);
    }
    this.Kre.setText(((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.b)this.KqB).title);
    i.a(this.context, (com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.b)this.KqB, this.Kre);
    Log.d("MicroMsg.AdLandingPageDownloadApkBtnComp.state", "fillItem, sendMsg=11");
    this.Krg.sendMessage(11);
    AppMethodBeat.o(96555);
  }
  
  public final void fKk()
  {
    AppMethodBeat.i(96557);
    super.fKk();
    Log.d("MicroMsg.AdLandingPageDownloadApkBtnComp.state", "viewWillAppear, sendMsg=2");
    this.Krg.sendMessage(2);
    a locala = new a(this.owd, this.enterScene, this.adExtInfo, this.pId, this.JPL);
    AdLandingPagesProxy.getInstance().addReportInfo(((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.b)this.KqB).appid, fRp().aid, fRp().nTp, fRp().uxInfo, locala);
    AppMethodBeat.o(96557);
  }
  
  public final void fKo()
  {
    AppMethodBeat.i(96558);
    super.fKo();
    Log.i("MicroMsg.AdLandingPageDownloadApkBtnComp", "view destroy");
    this.Krh.quit();
    if (this.Kri != null)
    {
      this.context.unregisterReceiver(this.Kri);
      this.Kri = null;
    }
    AppMethodBeat.o(96558);
  }
  
  @TargetApi(17)
  public final void fKp()
  {
    AppMethodBeat.i(96556);
    this.clickCount = 0;
    Object localObject = this.contentView;
    this.Krd = ((View)localObject).findViewById(i.f.downloader);
    this.Kre = ((Button)((View)localObject).findViewById(i.f.download_btn));
    this.Kre.setOnClickListener(this.Krm);
    this.Krf = ((SnsTextProgressBar)((View)localObject).findViewById(i.f.download_progress));
    this.Krf.setProgress(0);
    this.Krf.setVisibility(8);
    this.Krf.setOnClickListener(this.Krm);
    Log.d("MicroMsg.AdLandingPageDownloadApkBtnComp.state", "createView, BtnStateMachine start");
    this.Krg.start();
    try
    {
      localObject = (com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.b)this.KqB;
      if (((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.b)localObject).KkZ > 0)
      {
        if (!com.tencent.mm.plugin.sns.device.appstore.a.aU(((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.b)localObject).Kla)) {
          break label167;
        }
        l.a(fRp(), 4, "0", "");
      }
      for (;;)
      {
        l.a(fRp(), 1, "1", "");
        AppMethodBeat.o(96556);
        return;
        label167:
        l.a(fRp(), 4, "1", "");
      }
      return;
    }
    catch (Exception localException)
    {
      Log.w("MicroMsg.AdLandingPageDownloadApkBtnComp", "report19790 has something wrong");
      AppMethodBeat.o(96556);
    }
  }
  
  final boolean fRv()
  {
    AppMethodBeat.i(242925);
    for (;;)
    {
      try
      {
        boolean bool1 = NetStatusUtil.isWifi(this.context);
        boolean bool2 = AdLandingPagesProxy.getInstance().isFreeSimCard();
        Log.i("MicroMsg.AdLandingPageDownloadApkBtnComp", "isNeedShowNetworkTip, isWifi=" + bool1 + ", isFreeSimCard=" + bool2);
        if (bool1)
        {
          com.tencent.mm.plugin.report.service.h.IzE.el(1612, 2);
          if ((bool1) || (bool2)) {
            break;
          }
          AppMethodBeat.o(242925);
          return true;
        }
        if (bool2) {
          com.tencent.mm.plugin.report.service.h.IzE.el(1612, 3);
        } else {
          com.tencent.mm.plugin.report.service.h.IzE.el(1612, 4);
        }
      }
      catch (Throwable localThrowable)
      {
        Log.e("MicroMsg.AdLandingPageDownloadApkBtnComp", "isNeedShowNetworkTip exp=" + localThrowable.toString());
        AppMethodBeat.o(242925);
        return false;
      }
    }
    AppMethodBeat.o(242925);
    return false;
  }
  
  protected final int getLayout()
  {
    return i.g.sns_ad_comp_down_apk_btn;
  }
  
  public static class a
    implements Serializable
  {
    public int JPL;
    public String adExtInfo;
    public int enterScene;
    public String owd;
    public String pId;
    
    public a(String paramString1, int paramInt1, String paramString2, String paramString3, int paramInt2)
    {
      this.owd = paramString1;
      this.enterScene = paramInt1;
      this.adExtInfo = paramString2;
      this.pId = paramString3;
      this.JPL = paramInt2;
    }
  }
  
  final class b
    extends StateMachine
    implements Serializable
  {
    State Krp;
    State Krq;
    State Krr;
    State Krs;
    State Krt;
    State Kru;
    State Krv;
    State Krw;
    State Krx;
    
    protected b(String paramString, Looper paramLooper)
    {
      super(paramLooper);
      AppMethodBeat.i(96551);
      this.Krp = new c();
      this.Krq = new g();
      this.Krr = new e();
      this.Krs = new h();
      this.Krt = new i();
      this.Kru = new f();
      this.Krv = new b();
      this.Krw = new a();
      this.Krx = new d();
      addState(this.Krq);
      addState(this.Krp);
      addState(this.Krr);
      addState(this.Krs);
      addState(this.Krt);
      addState(this.Kru);
      addState(this.Krv);
      addState(this.Krw);
      addState(this.Krx);
      setInitialState(this.Krx);
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
        Log.d("MicroMsg.AdLandingPageDownloadApkBtnComp.state", "DisableUnsupportPlatformState enter, idx=" + ((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.b)s.this.KqB).KkW);
        MMHandlerThread.postToMainThread(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(96512);
            s.c(s.this).setVisibility(8);
            s.d(s.this).setEnabled(false);
            Button localButton = s.d(s.this);
            if (!TextUtils.isEmpty(s.b(s.this).KkM)) {}
            for (String str = s.b(s.this).KkM;; str = "暂不支持安卓手机")
            {
              localButton.setText(str);
              if (!s.e(s.this)) {
                s.d(s.this).setVisibility(0);
              }
              i.a(s.this.context, s.b(s.this), s.d(s.this));
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
      private long KrC = 0L;
      
      b() {}
      
      public final void enter()
      {
        AppMethodBeat.i(96515);
        super.enter();
        Log.d("MicroMsg.AdLandingPageDownloadApkBtnComp.state", "DoNetSceneState enter, idx=" + ((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.b)s.this.KqB).KkW);
        this.KrC = System.currentTimeMillis();
        com.tencent.mm.plugin.sns.data.b localb = new com.tencent.mm.plugin.sns.data.b(s.this.uxInfo, s.this.owd, s.this.enterScene, s.this.adExtInfo, s.this.JEE, s.this.nTp, s.this.pId);
        try
        {
          c.a locala = new c.a();
          locala.eventId = 4001021;
          locala.uxInfo = localb.uxInfo;
          locala.owd = localb.owd;
          locala.enterScene = localb.enterScene;
          locala.adExtInfo = localb.adExtInfo;
          locala.JEE = localb.JEE;
          locala.nTp = localb.nTp;
          locala.pId = localb.pId;
          locala.iVf = 4;
          com.tencent.mm.plugin.sns.ad.i.j.a(locala.fNh());
          AdLandingPagesProxy.getInstance().doAdChannelScene(((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.b)s.this.KqB).abY, ((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.b)s.this.KqB).channelId, s.this.Krn, ((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.b)s.this.KqB).KkI);
          Log.i("LogStateTransitionState", "[DoNetSceneState], appid=" + ((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.b)s.this.KqB).appid + ", pkg=" + ((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.b)s.this.KqB).abY + ", channelId=" + ((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.b)s.this.KqB).channelId + ", useGameDownloadWidget=" + ((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.b)s.this.KqB).KkI + ", hash=" + hashCode());
          AppMethodBeat.o(96515);
          return;
        }
        catch (Throwable localThrowable)
        {
          for (;;)
          {
            Log.e("AdConversionOnlineReportHelper", localThrowable.toString());
          }
        }
      }
      
      public final boolean processMessage(Message paramMessage)
      {
        AppMethodBeat.i(96514);
        Log.d("MicroMsg.AdLandingPageDownloadApkBtnComp.state", "DoNetSceneState msg=" + paramMessage.what + ", idx=" + ((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.b)s.this.KqB).KkW);
        Log.i("LogStateTransitionState", hashCode() + "[DoNetSceneState]recv msg.what " + paramMessage.what);
        if (AdLandingPagesProxy.getInstance().isApkExist(((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.b)s.this.KqB).appid))
        {
          s.b.l(s.b.this, s.b.this.Krs);
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
          int i = (int)(System.currentTimeMillis() - this.KrC);
          s.b.m(s.b.this, s.b.this.Krq);
          paramMessage = new com.tencent.mm.plugin.sns.data.b(s.this.uxInfo, s.this.owd, s.this.enterScene, s.this.adExtInfo, s.this.JEE, s.this.nTp, s.this.pId);
          paramMessage.JPI = i;
          try
          {
            c.a locala = new c.a();
            locala.eventId = 4001022;
            locala.uxInfo = paramMessage.uxInfo;
            locala.owd = paramMessage.owd;
            locala.enterScene = paramMessage.enterScene;
            locala.adExtInfo = paramMessage.adExtInfo;
            locala.JEE = paramMessage.JEE;
            locala.nTp = paramMessage.nTp;
            locala.pId = paramMessage.pId;
            locala.iVf = 4;
            locala.JPI = paramMessage.JPI;
            com.tencent.mm.plugin.sns.ad.i.j.a(locala.fNh());
            this.KrC = 0L;
            AppMethodBeat.o(96514);
            return true;
          }
          catch (Throwable paramMessage)
          {
            for (;;)
            {
              Log.e("AdConversionOnlineReportHelper", paramMessage.toString());
            }
          }
        case 5: 
          s.b.a(s.b.this, s.this.context.getString(i.j.sns_ad_download_apk_download_error));
          s.b.n(s.b.this, s.b.this.Kru);
          AppMethodBeat.o(96514);
          return true;
        }
        s.b.o(s.b.this, s.b.this.Krq);
        AppMethodBeat.o(96514);
        return true;
      }
    }
    
    final class c
      extends LogStateTransitionState
    {
      AdLandingPagesProxy.a KrD;
      
      c() {}
      
      public final void enter()
      {
        AppMethodBeat.i(96527);
        super.enter();
        Log.d("MicroMsg.AdLandingPageDownloadApkBtnComp.state", "DownloadingState enter, idx=" + ((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.b)s.this.KqB).KkW);
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
        s.a locala = new s.a(s.this.owd, s.this.enterScene, s.this.adExtInfo, s.this.pId, s.this.JPL);
        if ((AdLandingPagesProxy.getInstance().isPaused(((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.b)s.this.KqB).appid)) || (AdLandingPagesProxy.getInstance().isDownloading(((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.b)s.this.KqB).appid)))
        {
          if (this.KrD == null) {
            this.KrD = new a((byte)0);
          }
          MMHandlerThread.postToMainThread(new Runnable()
          {
            public final void run()
            {
              AppMethodBeat.i(96517);
              s.c(s.this).setProgress(AdLandingPagesProxy.getInstance().getTaskProgress(s.b(s.this).appid));
              AppMethodBeat.o(96517);
            }
          });
          if (!AdLandingPagesProxy.getInstance().resumeTask(((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.b)s.this.KqB).appid, this.KrD, s.this.fRp().aid, s.this.fRp().nTp, s.this.fRp().uxInfo, locala))
          {
            AdLandingPagesProxy.getInstance().stopTask(((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.b)s.this.KqB).appid);
            s.b.p(s.b.this, s.b.this.Krp);
            AppMethodBeat.o(96527);
          }
        }
        else
        {
          if (TextUtils.isEmpty(((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.b)s.this.KqB).downloadUrl))
          {
            s.b.q(s.b.this, s.b.this.Krv);
            AppMethodBeat.o(96527);
            return;
          }
          if (AdLandingPagesProxy.getInstance().isApkExist(((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.b)s.this.KqB).appid))
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
            s.b.r(s.b.this, s.b.this.Krs);
            AppMethodBeat.o(96527);
            return;
          }
          AdLandingPagesProxy.getInstance().stopTask(((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.b)s.this.KqB).appid);
          this.KrD = new a((byte)0);
          AdLandingPagesProxy.getInstance().startDownload(((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.b)s.this.KqB).appid, ((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.b)s.this.KqB).KkH, ((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.b)s.this.KqB).abY, ((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.b)s.this.KqB).md5, ((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.b)s.this.KqB).downloadUrl, ((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.b)s.this.KqB).KkJ, ((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.b)s.this.KqB).KkK, this.KrD, s.this.fRp().aid, s.this.fRp().nTp, s.this.fRp().uxInfo, ((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.b)s.this.KqB).KkI, locala);
        }
        AppMethodBeat.o(96527);
      }
      
      public final boolean processMessage(final Message paramMessage)
      {
        AppMethodBeat.i(96528);
        if (paramMessage.what != 1) {
          Log.d("MicroMsg.AdLandingPageDownloadApkBtnComp.state", "DownloadingState, msg=" + paramMessage.what + ", idx=" + ((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.b)s.this.KqB).KkW);
        }
        Log.i("LogStateTransitionState", hashCode() + "[DownloadingState] recv msg.what " + paramMessage.what);
        switch (paramMessage.what)
        {
        case 2: 
        case 4: 
        case 5: 
        case 6: 
        case 10: 
        case 11: 
        case 12: 
        case 13: 
        default: 
          AppMethodBeat.o(96528);
          return false;
        case 0: 
          if ((AdLandingPagesProxy.getInstance().pauseTask(((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.b)s.this.KqB).appid)) && (AdLandingPagesProxy.getInstance().isPaused(((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.b)s.this.KqB).appid))) {
            s.b.s(s.b.this, s.b.this.Krr);
          }
          paramMessage = new s.a(s.this.owd, s.this.enterScene, s.this.adExtInfo, s.this.pId, s.this.JPL);
          com.tencent.mm.plugin.sns.data.b localb = new com.tencent.mm.plugin.sns.data.b(s.this.uxInfo, s.this.owd, s.this.enterScene, s.this.adExtInfo, s.this.JEE, s.this.nTp, s.this.pId, s.this.JPL);
          try
          {
            c.a locala = new c.a();
            locala.eventId = 4001007;
            locala.uxInfo = localb.uxInfo;
            locala.owd = localb.owd;
            locala.enterScene = localb.enterScene;
            locala.adExtInfo = localb.adExtInfo;
            locala.JEE = localb.JEE;
            locala.nTp = localb.nTp;
            locala.pId = localb.pId;
            locala.iVf = 4;
            locala.JPL = localb.JPL;
            com.tencent.mm.plugin.sns.ad.i.j.a(locala.fNh());
            com.tencent.mm.ui.base.h.a(s.this.context, i.j.sns_ad_download_apk_cancel_tip_content, i.j.sns_ad_download_apk_cancel_tip_title, i.j.sns_ad_download_apk_no, i.j.sns_ad_download_apk_yes, false, new DialogInterface.OnClickListener()new DialogInterface.OnClickListener
            {
              public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
              {
                AppMethodBeat.i(239552);
                Log.i("LogStateTransitionState", "tip dialog, continue download, resumeTask");
                AdLandingPagesProxy.getInstance().resumeTask(s.b(s.this).appid, s.b.c.this.KrD, s.this.fRp().aid, s.this.fRp().nTp, s.this.fRp().uxInfo, paramMessage);
                paramAnonymousDialogInterface = new com.tencent.mm.plugin.sns.data.b(s.i(s.this), s.k(s.this), s.l(s.this), s.j(s.this), s.m(s.this), s.n(s.this), s.o(s.this), s.p(s.this));
                try
                {
                  c.a locala = new c.a();
                  locala.eventId = 4001008;
                  locala.uxInfo = paramAnonymousDialogInterface.uxInfo;
                  locala.owd = paramAnonymousDialogInterface.owd;
                  locala.enterScene = paramAnonymousDialogInterface.enterScene;
                  locala.adExtInfo = paramAnonymousDialogInterface.adExtInfo;
                  locala.JEE = paramAnonymousDialogInterface.JEE;
                  locala.nTp = paramAnonymousDialogInterface.nTp;
                  locala.pId = paramAnonymousDialogInterface.pId;
                  locala.iVf = 4;
                  locala.JPL = paramAnonymousDialogInterface.JPL;
                  com.tencent.mm.plugin.sns.ad.i.j.a(locala.fNh());
                  AppMethodBeat.o(239552);
                  return;
                }
                catch (Throwable paramAnonymousDialogInterface)
                {
                  Log.e("AdConversionOnlineReportHelper", paramAnonymousDialogInterface.toString());
                  AppMethodBeat.o(239552);
                }
              }
            }, new DialogInterface.OnClickListener()
            {
              public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
              {
                AppMethodBeat.i(212470);
                Log.i("LogStateTransitionState", "tip dialog, confirm cancel");
                k.a(s.g(s.this), s.h(s.this), 1, 5, s.i(s.this), s.j(s.this), 1);
                AppMethodBeat.o(212470);
              }
            });
            k.a(s.this.fLp, s.this.appId, 0, 5, s.this.uxInfo, s.this.adExtInfo, 1);
            AppMethodBeat.o(96528);
            return true;
          }
          catch (Throwable localThrowable)
          {
            for (;;)
            {
              Log.e("AdConversionOnlineReportHelper", localThrowable.toString());
            }
          }
        case 1: 
          MMHandlerThread.postToMainThread(new Runnable()
          {
            public final void run()
            {
              AppMethodBeat.i(199750);
              if (this.val$progress >= 0) {
                s.c(s.this).setProgress(this.val$progress);
              }
              AppMethodBeat.o(199750);
            }
          });
          AppMethodBeat.o(96528);
          return true;
        case 3: 
          s.b.t(s.b.this, s.b.this.Krt);
          AppMethodBeat.o(96528);
          return true;
        case 7: 
          s.b.u(s.b.this, s.b.this.Krr);
          AppMethodBeat.o(96528);
          return true;
        case 8: 
          s.b.a(s.b.this, s.this.context.getString(i.j.sns_ad_download_apk_download_error));
          s.b.v(s.b.this, s.b.this.Kru);
          AppMethodBeat.o(96528);
          return true;
        case 9: 
          paramMessage = s.this;
          Log.d("MicroMsg.AdLandingPageDownloadApkBtnComp", "writing deferred deep link");
          AdLandingPagesProxy.getInstance().writeDeferredDeepLink(((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.b)paramMessage.KqB).abY, ((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.b)paramMessage.KqB).JxO);
          com.tencent.mm.plugin.sns.ad.d.a.kl(((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.b)paramMessage.KqB).abY, ((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.b)paramMessage.KqB).JxO);
          s.b.w(s.b.this, s.b.this.Krs);
          AppMethodBeat.o(96528);
          return true;
        }
        s.this.Krf.setProgress(0);
        s.b.x(s.b.this, s.b.this.Krq);
        AppMethodBeat.o(96528);
        return true;
      }
      
      final class a
        implements AdLandingPagesProxy.a
      {
        private a() {}
        
        public final void afJ(int paramInt)
        {
          AppMethodBeat.i(96521);
          if (paramInt % 20 == 0) {
            Log.d("MicroMsg.AdLandingPageDownloadApkBtnComp.callback", "progress:" + paramInt + ", idx=" + s.b(s.this).KkW);
          }
          s.a(s.this).sendMessage(1, paramInt);
          AppMethodBeat.o(96521);
        }
        
        public final void fNG()
        {
          AppMethodBeat.i(96522);
          Log.d("MicroMsg.AdLandingPageDownloadApkBtnComp.callback", "paused, idx=" + s.b(s.this).KkW);
          s.a(s.this).sendMessage(7);
          AppMethodBeat.o(96522);
        }
        
        public final void fNH()
        {
          AppMethodBeat.i(96523);
          Log.d("MicroMsg.AdLandingPageDownloadApkBtnComp.callback", "stopped, idx=" + s.b(s.this).KkW);
          s.a(s.this).sendMessage(14);
          AppMethodBeat.o(96523);
        }
        
        public final void fNI()
        {
          AppMethodBeat.i(96524);
          Log.d("MicroMsg.AdLandingPageDownloadApkBtnComp.callback", "succeed, idx=" + s.b(s.this).KkW);
          s.a(s.this).sendMessage(9);
          AppMethodBeat.o(96524);
        }
        
        public final void fNJ()
        {
          AppMethodBeat.i(96525);
          Log.d("MicroMsg.AdLandingPageDownloadApkBtnComp.callback", "failed, idx=" + s.b(s.this).KkW);
          s.a(s.this).sendMessage(8);
          AppMethodBeat.o(96525);
        }
        
        public final void fNK()
        {
          AppMethodBeat.i(96526);
          Log.d("MicroMsg.AdLandingPageDownloadApkBtnComp.callback", "resumed, idx=" + s.b(s.this).KkW);
          s.a(s.this).sendMessage(13);
          AppMethodBeat.o(96526);
        }
        
        public final void start()
        {
          AppMethodBeat.i(96520);
          Log.d("MicroMsg.AdLandingPageDownloadApkBtnComp.callback", "start, idx=" + s.b(s.this).KkW);
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
        Log.d("MicroMsg.AdLandingPageDownloadApkBtnComp.state", "InitState enter, idx=" + ((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.b)s.this.KqB).KkW);
        com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.b localb = (com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.b)s.this.KqB;
        int i;
        if ((localb.KkL == 0) || (localb.KkL == 2)) {
          i = 1;
        }
        while (i != 0) {
          if (AdLandingPagesProxy.getInstance().isApkExist(((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.b)s.this.KqB).appid))
          {
            s.b.a(s.b.this, s.b.this.Krs);
            AppMethodBeat.o(96529);
            return;
            i = 0;
          }
          else
          {
            if (AdLandingPagesProxy.getInstance().isPkgInstalled(((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.b)s.this.KqB).abY))
            {
              s.b.b(s.b.this, s.b.this.Krt);
              AppMethodBeat.o(96529);
              return;
            }
            s.b.c(s.b.this, s.b.this.Krv);
            AppMethodBeat.o(96529);
            return;
          }
        }
        s.b.d(s.b.this, s.b.this.Krw);
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
        Log.d("MicroMsg.AdLandingPageDownloadApkBtnComp.state", "PauseState enter, idx=" + ((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.b)s.this.KqB).KkW);
        MMHandlerThread.postToMainThread(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(96530);
            s.c(s.this).setVisibility(8);
            if (!s.e(s.this)) {
              s.d(s.this).setVisibility(0);
            }
            s.d(s.this).setText(i.j.sns_ad_download_apk_continue);
            i.a(s.this.context, s.b(s.this), s.d(s.this));
            AppMethodBeat.o(96530);
          }
        });
        AppMethodBeat.o(96532);
      }
      
      public final boolean processMessage(Message paramMessage)
      {
        AppMethodBeat.i(96533);
        Log.d("MicroMsg.AdLandingPageDownloadApkBtnComp.state", "PauseState, msg=" + paramMessage.what + ", idx=" + ((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.b)s.this.KqB).KkW);
        Log.i("LogStateTransitionState", hashCode() + "[PauseState] recv msg.what " + paramMessage.what);
        switch (paramMessage.what)
        {
        default: 
          AppMethodBeat.o(96533);
          return false;
        case 0: 
          if (AdLandingPagesProxy.getInstance().isDownloading(((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.b)s.this.KqB).appid)) {
            s.b.a(s.b.this, s.this.context.getString(i.j.sns_ad_download_apk_already));
          }
          for (;;)
          {
            AppMethodBeat.o(96533);
            return true;
            if (s.this.fRv())
            {
              Log.i("LogStateTransitionState", "download not in wifi!");
              k.a(s.this.fLp, s.this.appId, 0, 1, s.this.uxInfo, s.this.adExtInfo, 1);
              com.tencent.mm.plugin.sns.ad.d.b.g(new com.tencent.mm.plugin.sns.data.b(s.this.uxInfo, s.this.owd, s.this.enterScene, s.this.adExtInfo, s.this.JEE, s.this.nTp, s.this.pId, s.this.JPL, 102));
              com.tencent.mm.ui.base.h.a(s.this.context, i.j.webview_download_ui_download_not_in_wifi_tips, i.j.webview_download_ui_download_not_in_wifi_title, new DialogInterface.OnClickListener()
              {
                public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
                {
                  AppMethodBeat.i(96531);
                  s.b.this.sendMessage(12);
                  k.a(s.g(s.this), s.h(s.this), 1, 1, s.i(s.this), s.j(s.this), 1);
                  com.tencent.mm.plugin.sns.ad.d.b.h(new com.tencent.mm.plugin.sns.data.b(s.i(s.this), s.k(s.this), s.l(s.this), s.j(s.this), s.m(s.this), s.n(s.this), s.o(s.this), s.p(s.this), 102));
                  com.tencent.mm.modelstat.d.d(10, "AdLandingPageDownloadApkBtnComp_PAUSE_MSG_BTN_CLICK", s.b.e.this.hashCode());
                  AppMethodBeat.o(96531);
                }
              }, null);
            }
            else
            {
              int i = ((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.b)s.this.KqB).KkY;
              Log.i("MicroMsg.AdLandingPageDownloadApkBtnComp.GroceryDownload", "showDownloadTip = ".concat(String.valueOf(i)));
              if (i == 1) {
                s.b.a(s.b.this, 1);
              } else {
                s.b.this.sendMessage(12);
              }
            }
          }
        case 3: 
          s.b.y(s.b.this, s.b.this.Krt);
          AppMethodBeat.o(96533);
          return true;
        case 8: 
          s.b.a(s.b.this, s.this.context.getString(i.j.sns_ad_download_apk_download_error));
          s.b.z(s.b.this, s.b.this.Kru);
          AppMethodBeat.o(96533);
          return true;
        case 12: 
          s.b.A(s.b.this, s.b.this.Krp);
          AppMethodBeat.o(96533);
          return true;
        }
        s.b.B(s.b.this, s.b.this.Krp);
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
        Log.d("MicroMsg.AdLandingPageDownloadApkBtnComp.state", "ReDownloadState enter, idx=" + ((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.b)s.this.KqB).KkW);
        MMHandlerThread.postToMainThread(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(96534);
            s.c(s.this).setVisibility(8);
            if (!s.e(s.this)) {
              s.d(s.this).setVisibility(0);
            }
            s.d(s.this).setText(i.j.sns_ad_download_apk_retry);
            i.a(s.this.context, s.b(s.this), s.d(s.this));
            AppMethodBeat.o(96534);
          }
        });
        AppMethodBeat.o(96535);
      }
      
      public final boolean processMessage(Message paramMessage)
      {
        AppMethodBeat.i(96536);
        Log.d("MicroMsg.AdLandingPageDownloadApkBtnComp.state", "ReDownloadState, msg=" + paramMessage.what + ", idx=" + ((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.b)s.this.KqB).KkW);
        Log.i("LogStateTransitionState", hashCode() + "[ReDownloadState] recv msg.what " + paramMessage.what);
        switch (paramMessage.what)
        {
        default: 
          AppMethodBeat.o(96536);
          return false;
        }
        s.this.JPL = 2;
        s.b.J(s.b.this, s.b.this.Krv);
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
        Log.d("MicroMsg.AdLandingPageDownloadApkBtnComp.state", "ToDownloadState enter, idx=" + ((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.b)s.this.KqB).KkW);
        MMHandlerThread.postToMainThread(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(96537);
            if (s.f(s.this) == null)
            {
              s.a(s.this, new s.c(s.this, (byte)0));
              IntentFilter localIntentFilter = new IntentFilter();
              localIntentFilter.addAction("android.intent.action.PACKAGE_ADDED");
              localIntentFilter.addAction("android.intent.action.PACKAGE_REMOVED");
              localIntentFilter.addDataScheme("package");
              s.this.context.registerReceiver(s.f(s.this), localIntentFilter);
            }
            AppMethodBeat.o(96537);
          }
        });
        if (AdLandingPagesProxy.getInstance().isPkgInstalled(((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.b)s.this.KqB).abY))
        {
          s.b.e(s.b.this, s.b.this.Krt);
          AppMethodBeat.o(96543);
          return;
        }
        if (AdLandingPagesProxy.getInstance().isApkExist(((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.b)s.this.KqB).appid))
        {
          s.b.f(s.b.this, s.b.this.Krs);
          AppMethodBeat.o(96543);
          return;
        }
        if (AdLandingPagesProxy.getInstance().isDownloading(((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.b)s.this.KqB).appid))
        {
          s.b.g(s.b.this, s.b.this.Krp);
          AppMethodBeat.o(96543);
          return;
        }
        if (AdLandingPagesProxy.getInstance().isPaused(((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.b)s.this.KqB).appid))
        {
          s.b.h(s.b.this, s.b.this.Krr);
          AppMethodBeat.o(96543);
          return;
        }
        MMHandlerThread.postToMainThread(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(96538);
            s.c(s.this).setVisibility(8);
            if (!s.e(s.this)) {
              s.d(s.this).setVisibility(0);
            }
            s.d(s.this).setText(s.b(s.this).title);
            i.a(s.this.context, s.b(s.this), s.d(s.this));
            AppMethodBeat.o(96538);
          }
        });
        s.this.JPL = 2;
        boolean bool;
        if (s.this.Krj) {
          if (s.this.fRp().Kns) {
            bool = ((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.b)s.this.KqB).KkX;
          }
        }
        for (;;)
        {
          if ((bool) && (s.this.Krk))
          {
            s.this.Krk = false;
            MMHandlerThread.postToMainThreadDelayed(new Runnable()
            {
              public final void run()
              {
                AppMethodBeat.i(96540);
                try
                {
                  double d = (float)s.b(s.this).fileSize / 1024.0F / 1024.0F;
                  String str;
                  if (Util.isNullOrNil(s.b(s.this).KkJ)) {
                    str = s.this.context.getString(i.j.sns_ad_action_btn_download_app_default_tip);
                  }
                  for (;;)
                  {
                    k.a(s.g(s.this), s.h(s.this), 0, 0, s.i(s.this), s.j(s.this), 1);
                    com.tencent.mm.plugin.sns.ad.d.b.g(new com.tencent.mm.plugin.sns.data.b(s.i(s.this), s.k(s.this), s.l(s.this), s.j(s.this), s.m(s.this), s.n(s.this), s.o(s.this), 1, 101));
                    com.tencent.mm.ui.base.h.c(s.this.context, str, "", "是", "否", new DialogInterface.OnClickListener()
                    {
                      public final void onClick(DialogInterface paramAnonymous2DialogInterface, int paramAnonymous2Int)
                      {
                        AppMethodBeat.i(96539);
                        s.a(s.this, 1);
                        s.a(s.this).sendMessage(0);
                        k.a(s.g(s.this), s.h(s.this), 1, 0, s.i(s.this), s.j(s.this), 1);
                        com.tencent.mm.plugin.sns.ad.d.b.h(new com.tencent.mm.plugin.sns.data.b(s.i(s.this), s.k(s.this), s.l(s.this), s.j(s.this), s.m(s.this), s.n(s.this), s.o(s.this), s.p(s.this), 101));
                        AppMethodBeat.o(96539);
                      }
                    }, null);
                    AppMethodBeat.o(96540);
                    return;
                    if (d > 0.0D)
                    {
                      str = String.format("%.1f", new Object[] { Double.valueOf(d) });
                      str = s.this.context.getString(i.j.sns_ad_action_btn_download_app_tip_with_size, new Object[] { s.b(s.this).KkJ, str });
                    }
                    else
                    {
                      str = s.this.context.getString(i.j.sns_ad_action_btn_download_app_tip, new Object[] { s.b(s.this).KkJ });
                    }
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
          if (((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.b)s.this.KqB).KkW == 0)
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
        Log.d("MicroMsg.AdLandingPageDownloadApkBtnComp.state", "ToDownloadState, msg=" + paramMessage.what + ", idx=" + ((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.b)s.this.KqB).KkW);
        Log.i("LogStateTransitionState", hashCode() + "[ToDownloadState]recv msg.what " + paramMessage.what);
        switch (paramMessage.what)
        {
        default: 
          AppMethodBeat.o(96544);
          return false;
        case 0: 
          if (AdLandingPagesProxy.getInstance().isDownloading(((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.b)s.this.KqB).appid)) {
            s.b.a(s.b.this, s.this.context.getString(i.j.sns_ad_download_apk_already));
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
                if (s.q(s.this))
                {
                  Log.i("LogStateTransitionState", "download not in wifi!");
                  k.a(s.g(s.this), s.h(s.this), 0, 0, s.i(s.this), s.j(s.this), 1);
                  com.tencent.mm.plugin.sns.ad.d.b.g(new com.tencent.mm.plugin.sns.data.b(s.i(s.this), s.k(s.this), s.l(s.this), s.j(s.this), s.m(s.this), s.n(s.this), s.o(s.this), s.p(s.this), 102));
                  com.tencent.mm.ui.base.h.a(s.this.context, i.j.webview_download_ui_download_not_in_wifi_tips, i.j.webview_download_ui_download_not_in_wifi_title, new DialogInterface.OnClickListener()new DialogInterface.OnClickListener
                  {
                    public final void onClick(DialogInterface paramAnonymous2DialogInterface, int paramAnonymous2Int)
                    {
                      AppMethodBeat.i(96541);
                      s.a(s.this).sendMessage(12);
                      com.tencent.mm.plugin.sns.ad.d.b.h(new com.tencent.mm.plugin.sns.data.b(s.i(s.this), s.k(s.this), s.l(s.this), s.j(s.this), s.m(s.this), s.n(s.this), s.o(s.this), s.p(s.this), 102));
                      k.a(s.g(s.this), s.h(s.this), 1, 0, s.i(s.this), s.j(s.this), 1);
                      com.tencent.mm.modelstat.d.d(10, "AdLandingPageDownloadApkBtnComp_TODOWLOAD_MSG_BTN_CLICK", s.b.g.this.hashCode());
                      AppMethodBeat.o(96541);
                    }
                  }, new DialogInterface.OnClickListener()
                  {
                    public final void onClick(DialogInterface paramAnonymous2DialogInterface, int paramAnonymous2Int)
                    {
                      AppMethodBeat.i(199230);
                      s.a(s.this, 2);
                      AppMethodBeat.o(199230);
                    }
                  });
                  AppMethodBeat.o(96542);
                  return;
                }
                int i = s.b(s.this).KkY;
                Log.i("MicroMsg.AdLandingPageDownloadApkBtnComp.GroceryDownload", "showDownloadTip = ".concat(String.valueOf(i)));
                if (i == 1)
                {
                  if (AdLandingPagesProxy.getInstance().isPaused(s.b(s.this).appid))
                  {
                    s.b.a(s.b.this, 1);
                    AppMethodBeat.o(96542);
                    return;
                  }
                  s.b.a(s.b.this, 0);
                  AppMethodBeat.o(96542);
                  return;
                }
                s.a(s.this).sendMessage(12);
                AppMethodBeat.o(96542);
              }
            });
          }
        case 3: 
          s.b.i(s.b.this, s.b.this.Krt);
          AppMethodBeat.o(96544);
          return true;
        case 11: 
          s.b.j(s.b.this, s.b.this.Krq);
          AppMethodBeat.o(96544);
          return true;
        }
        s.b.k(s.b.this, s.b.this.Krp);
        AppMethodBeat.o(96544);
        return true;
      }
    }
    
    final class h
      extends LogStateTransitionState
    {
      private boolean KrL;
      
      h() {}
      
      public final void enter()
      {
        AppMethodBeat.i(96546);
        Log.d("MicroMsg.AdLandingPageDownloadApkBtnComp.state", "ToInstallState enter, idx=" + ((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.b)s.this.KqB).KkW);
        super.enter();
        if (!AdLandingPagesProxy.getInstance().isApkExist(((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.b)s.this.KqB).appid))
        {
          s.b.C(s.b.this, s.b.this.Krq);
          AppMethodBeat.o(96546);
          return;
        }
        MMHandlerThread.postToMainThread(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(96545);
            s.c(s.this).setVisibility(8);
            if (!s.e(s.this)) {
              s.d(s.this).setVisibility(0);
            }
            s.d(s.this).setText(i.j.sns_ad_download_apk_install);
            i.a(s.this.context, s.b(s.this), s.d(s.this));
            AppMethodBeat.o(96545);
          }
        });
        this.KrL = true;
        AppMethodBeat.o(96546);
      }
      
      public final boolean processMessage(Message paramMessage)
      {
        AppMethodBeat.i(96547);
        Log.d("MicroMsg.AdLandingPageDownloadApkBtnComp.state", "ToInstallState, msg=" + paramMessage.what + ", idx=" + ((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.b)s.this.KqB).KkW);
        Log.i("LogStateTransitionState", hashCode() + "[ToInstallState] recv msg.what " + paramMessage.what);
        switch (paramMessage.what)
        {
        case 1: 
        default: 
          AppMethodBeat.o(96547);
          return false;
        case 0: 
          if (AdLandingPagesProxy.getInstance().installApp(s.this.context, ((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.b)s.this.KqB).appid, ((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.b)s.this.KqB).abY, ((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.b)s.this.KqB).md5, ((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.b)s.this.KqB).downloadUrl))
          {
            this.KrL = true;
            AppMethodBeat.o(96547);
            return true;
          }
          s.b.a(s.b.this, s.this.context.getString(i.j.sns_ad_download_apk_install_error));
          s.b.D(s.b.this, s.b.this.Kru);
          AppMethodBeat.o(96547);
          return true;
        case 2: 
          if (!AdLandingPagesProxy.getInstance().isApkExist(((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.b)s.this.KqB).appid)) {
            s.b.E(s.b.this, s.b.this.Krq);
          }
          AppMethodBeat.o(96547);
          return true;
        }
        if (this.KrL) {
          this.KrL = false;
        }
        s.b.F(s.b.this, s.b.this.Krt);
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
        Log.d("MicroMsg.AdLandingPageDownloadApkBtnComp.state", "ToOpenState enter, idx=" + ((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.b)s.this.KqB).KkW);
        if (AdLandingPagesProxy.getInstance().isPkgInstalled(((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.b)s.this.KqB).abY))
        {
          MMHandlerThread.postToMainThread(new Runnable()
          {
            public final void run()
            {
              AppMethodBeat.i(96548);
              s.c(s.this).setVisibility(8);
              if (!s.e(s.this)) {
                s.d(s.this).setVisibility(0);
              }
              if (Util.isNullOrNil(s.b(s.this).Klb)) {
                s.d(s.this).setText(i.j.sns_ad_download_apk_open);
              }
              for (;;)
              {
                i.a(s.this.context, s.b(s.this), s.d(s.this));
                AppMethodBeat.o(96548);
                return;
                s.d(s.this).setText(s.b(s.this).Klb);
              }
            }
          });
          AppMethodBeat.o(96549);
          return;
        }
        s.b.G(s.b.this, s.b.this.Krs);
        AppMethodBeat.o(96549);
      }
      
      public final boolean processMessage(Message paramMessage)
      {
        AppMethodBeat.i(96550);
        Log.d("MicroMsg.AdLandingPageDownloadApkBtnComp.state", "ToOpenState, msg=" + paramMessage.what + ", idx=" + ((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.b)s.this.KqB).KkW);
        Log.i("LogStateTransitionState", hashCode() + "[ToOpenState] recv msg.what " + paramMessage.what);
        switch (paramMessage.what)
        {
        default: 
          AppMethodBeat.o(96550);
          return false;
        case 0: 
          paramMessage = new com.tencent.mm.plugin.sns.ad.f.j(s.this.owd, s.this.enterScene, s.this.JEE, s.this.nTp, s.this.pId);
          if (m.a(s.this.context, ((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.b)s.this.KqB).appid, ((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.b)s.this.KqB).abY, "", ((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.b)s.this.KqB).JxO, s.this.uxInfo, s.this.adExtInfo, s.this.fLp, 1, 2, paramMessage))
          {
            AppMethodBeat.o(96550);
            return true;
          }
          s.b.a(s.b.this, s.this.context.getString(i.j.sns_ad_download_apk_open_error));
          s.b.H(s.b.this, s.b.this.Krt);
          AppMethodBeat.o(96550);
          return true;
        }
        s.b.I(s.b.this, s.b.this.Krq);
        AppMethodBeat.o(96550);
        return true;
      }
    }
  }
  
  final class c
    extends BroadcastReceiver
    implements Serializable
  {
    private c() {}
    
    public final void onReceive(Context paramContext, Intent paramIntent)
    {
      AppMethodBeat.i(96553);
      if (paramIntent != null)
      {
        paramContext = paramIntent.getAction();
        if ("android.intent.action.PACKAGE_ADDED".equals(paramContext))
        {
          paramContext = paramIntent.getData().getSchemeSpecificPart();
          if ((!TextUtils.isEmpty(paramContext)) && (paramContext.equals(((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.b)s.this.KqB).abY))) {
            s.this.Krg.sendMessage(3);
          }
          AppMethodBeat.o(96553);
          return;
        }
        if ("android.intent.action.PACKAGE_REMOVED".equals(paramContext))
        {
          paramContext = paramIntent.getData().getSchemeSpecificPart();
          if ((!TextUtils.isEmpty(paramContext)) && (paramContext.equals(((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.b)s.this.KqB).abY))) {
            s.this.Krg.sendMessage(4);
          }
        }
      }
      AppMethodBeat.o(96553);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.s
 * JD-Core Version:    0.7.0.1
 */