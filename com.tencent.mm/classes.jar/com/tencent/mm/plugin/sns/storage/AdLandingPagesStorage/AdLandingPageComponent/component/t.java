package com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component;

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
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.plugin.sns.b.d;
import com.tencent.mm.plugin.sns.b.f;
import com.tencent.mm.plugin.sns.b.g;
import com.tencent.mm.plugin.sns.b.j;
import com.tencent.mm.plugin.sns.data.c.a;
import com.tencent.mm.plugin.sns.data.m;
import com.tencent.mm.plugin.sns.model.AdLandingPagesProxy;
import com.tencent.mm.plugin.sns.model.AdLandingPagesProxy.a;
import com.tencent.mm.plugin.sns.model.AdLandingPagesProxy.e;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.ai;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.b.h.a;
import com.tencent.mm.plugin.sns.ui.widget.SnsTextProgressBar;
import com.tencent.mm.protocal.protobuf.yy;
import com.tencent.mm.protocal.protobuf.za;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.sdk.platformtools.NetStatusUtil;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.statemachine.LogStateTransitionState;
import com.tencent.mm.sdk.statemachine.State;
import com.tencent.mm.sdk.statemachine.StateMachine;
import java.io.IOException;
import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

public final class t
  extends q
  implements Serializable
{
  String PVG;
  SnsTextProgressBar QPA;
  b QPB;
  private HandlerThread QPC;
  private c QPD;
  boolean QPE;
  boolean QPF;
  volatile boolean QPG;
  private View.OnClickListener QPH;
  AdLandingPagesProxy.e QPI;
  private View QPy;
  Button QPz;
  int Qms;
  String adExtInfo;
  String appId;
  int enterScene;
  String hQX;
  String pId;
  String qTb;
  String rzx;
  String uxInfo;
  
  public t(Context paramContext, com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.b paramb, ViewGroup paramViewGroup)
  {
    super(paramContext, paramb, paramViewGroup);
    AppMethodBeat.i(96554);
    this.QPF = true;
    this.appId = "";
    this.uxInfo = "";
    this.adExtInfo = "";
    this.hQX = "";
    this.QPG = false;
    this.PVG = "";
    this.pId = "";
    this.qTb = "";
    this.rzx = "";
    this.Qms = 2;
    this.QPH = new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(96505);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.cH(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/component/AdLandingPageDownloadApkBtnComp$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aYj());
        t.a(t.this).sendMessage(0);
        t.this.hjr();
        t.this.hja();
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/component/AdLandingPageDownloadApkBtnComp$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(96505);
      }
    };
    this.QPI = new AdLandingPagesProxy.e()
    {
      public final void h(int paramAnonymousInt1, int paramAnonymousInt2, Object paramAnonymousObject)
      {
        AppMethodBeat.i(96506);
        Log.i("MicroMsg.AdLandingPageDownloadApkBtnComp", " AdLandingPagesProxy.Callback, errType=" + paramAnonymousInt1 + ", errNo=" + paramAnonymousInt2);
        if ((paramAnonymousInt1 != 0) || (paramAnonymousInt2 != 0))
        {
          t.a(t.this).sendMessage(5);
          AppMethodBeat.o(96506);
          return;
        }
        za localza = new za();
        try
        {
          localza.parseFrom((byte[])paramAnonymousObject);
          if (!TextUtils.isEmpty(localza.ZhF))
          {
            Log.i("MicroMsg.AdLandingPageDownloadApkBtnComp", "opening url " + localza.ZhF);
            paramAnonymousObject = new Intent();
            paramAnonymousObject.putExtra("rawUrl", localza.ZhF);
            paramAnonymousObject.putExtra("showShare", true);
            com.tencent.mm.br.c.b(t.this.context, "webview", ".ui.tools.WebViewUI", paramAnonymousObject);
            t.a(t.this).sendMessage(10);
            AppMethodBeat.o(96506);
            return;
          }
        }
        catch (IOException paramAnonymousObject)
        {
          for (;;)
          {
            Log.e("MicroMsg.AdLandingPageDownloadApkBtnComp", Util.stackTraceToString(paramAnonymousObject));
          }
          if (localza.ZhE != null)
          {
            paramAnonymousObject = "";
            if (t.b(t.this).QIP)
            {
              t.b(t.this).QIQ = localza.ZhE.Zhy;
              t.b(t.this).md5 = localza.ZhE.Zhw;
              t.b(t.this).downloadUrl = localza.ZhE.Zhx;
              t.b(t.this).fileSize = localza.ZhE.Zhz;
              String str = localza.ZhE.Zhv;
              if ((!TextUtils.isEmpty(t.b(t.this).md5)) && (!TextUtils.isEmpty(t.b(t.this).downloadUrl)))
              {
                paramAnonymousObject = str;
                if (t.b(t.this).fileSize != 0L) {}
              }
              else
              {
                t.b(t.this).QIP = false;
                Log.e("MicroMsg.AdLandingPageDownloadApkBtnComp", "[DoNetSceneState], useGameDownloadWidget, but wxAppInfo is empty");
                paramAnonymousObject = str;
              }
            }
            if (!t.b(t.this).QIP)
            {
              t.b(t.this).QIQ = localza.ZhE.xlJ;
              t.b(t.this).md5 = localza.ZhE.xmv;
              t.b(t.this).downloadUrl = localza.ZhE.Zht;
              t.b(t.this).fileSize = localza.ZhE.Zhu;
              paramAnonymousObject = localza.ZhE.Zhs;
            }
            t.a(t.this).sendMessage(6);
            Log.i("MicroMsg.AdLandingPageDownloadApkBtnComp", "[DoNetSceneState] PkgInfoResp, name=" + t.b(t.this).QIQ + ", useGameDownloadWidget=" + t.b(t.this).QIP + ", fileSize=" + t.b(t.this).fileSize + ", apkId=" + paramAnonymousObject + ", url=" + t.b(t.this).downloadUrl);
            AppMethodBeat.o(96506);
            return;
          }
          Log.e("MicroMsg.AdLandingPageDownloadApkBtnComp", "resp is null");
          t.a(t.this).sendMessage(5);
          AppMethodBeat.o(96506);
        }
      }
      
      public final void onCallback(Object paramAnonymousObject) {}
    };
    Log.d("MicroMsg.AdLandingPageDownloadApkBtnComp.state", "component create, new BtnStateMachine");
    this.QPC = com.tencent.threadpool.c.d.jz("apkStateMachine", 5);
    this.QPC.start();
    this.QPB = new b("apkStateMachine", this.QPC.getLooper());
    if ((paramContext instanceof Activity))
    {
      this.QPE = ((Activity)paramContext).getIntent().getBooleanExtra("sns_landing_pages_auto_download_for_action_btn", false);
      this.QPF = true;
      Log.i("MicroMsg.AdLandingPageDownloadApkBtnComp", "autoDownloadFromActionBtn=" + this.QPE + ", activity=" + paramContext + ", idx=" + ((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.b)this.QOV).QJd + ", appId=" + ((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.b)this.QOV).appid + ", wxAppid=" + ((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.b)this.QOV).QIO + ", useGameDownloader=" + ((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.b)this.QOV).QIP + ", pkg=" + ((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.b)this.QOV).bJH);
    }
    this.QPl.bD("platform", paramb.QIS);
    this.QPl.mx("appid", paramb.appid);
    this.QPl.mx("channelId", paramb.channelId);
    this.QPl.mx("pkg", paramb.bJH);
    this.QPl.mx("appPageUrlAndroid", paramb.PLD);
    try
    {
      this.appId = Util.nullAsNil(((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.b)this.QOV).appid);
      this.uxInfo = Util.nullAsNil(hjn().uxInfo);
      this.adExtInfo = Util.nullAsNil(hjn().adExtInfo);
      this.hQX = hjn().getSnsId();
      this.PVG = Util.nullAsNil(hjn().aid);
      this.pId = Util.nullAsNil(hjn().pId);
      this.enterScene = hjn().source;
      this.qTb = Util.nullAsNil(hjn().qTb);
      this.rzx = Util.nullAsNil(hjn().rzx);
      AppMethodBeat.o(96554);
      return;
    }
    finally
    {
      Log.e("MicroMsg.AdLandingPageDownloadApkBtnComp.DownloadToastReport", paramContext.toString());
      AppMethodBeat.o(96554);
    }
  }
  
  private static String mv(String paramString1, String paramString2)
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
  
  public final void Gs()
  {
    AppMethodBeat.i(96556);
    this.clickCount = 0;
    Object localObject = this.contentView;
    this.QPy = ((View)localObject).findViewById(b.f.downloader);
    this.QPz = ((Button)((View)localObject).findViewById(b.f.download_btn));
    this.QPz.setOnClickListener(this.QPH);
    this.QPA = ((SnsTextProgressBar)((View)localObject).findViewById(b.f.download_progress));
    this.QPA.setProgress(0);
    this.QPA.setVisibility(8);
    this.QPA.setOnClickListener(this.QPH);
    Log.d("MicroMsg.AdLandingPageDownloadApkBtnComp.state", "createView, BtnStateMachine start");
    this.QPB.start();
    try
    {
      localObject = (com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.b)this.QOV;
      if (((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.b)localObject).QJg > 0)
      {
        if (!com.tencent.mm.plugin.sns.device.appstore.a.bu(((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.b)localObject).QJh)) {
          break label167;
        }
        l.a(hjn(), 4, "0", "");
      }
      for (;;)
      {
        l.a(hjn(), 1, "1", "");
        AppMethodBeat.o(96556);
        return;
        label167:
        l.a(hjn(), 4, "1", "");
      }
      return;
    }
    catch (Exception localException)
    {
      Log.w("MicroMsg.AdLandingPageDownloadApkBtnComp", "report19790 has something wrong");
      AppMethodBeat.o(96556);
    }
  }
  
  protected final int getLayout()
  {
    return b.g.sns_ad_comp_down_apk_btn;
  }
  
  protected final void had()
  {
    AppMethodBeat.i(96555);
    Object localObject1 = new HashMap();
    ((Map)localObject1).put("fontNormalColor", mv(((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.b)this.QOV).QJa, "#FFFFFF"));
    ((Map)localObject1).put("fontDisableColor", mv(((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.b)this.QOV).QJb, "#4CFFFFFF"));
    ((Map)localObject1).put("fontPressedColor", mv(((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.b)this.QOV).QJc, "#99FFFFFF"));
    ((Map)localObject1).put("NormalColor", mv(((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.b)this.QOV).QIU, "#1AAD19"));
    ((Map)localObject1).put("PressedColor", mv(((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.b)this.QOV).QIW, "#179B16"));
    ((Map)localObject1).put("DisableColor", mv(((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.b)this.QOV).QIV, "#661AAD19"));
    ((Map)localObject1).put("borderNormalColor", mv(((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.b)this.QOV).QIX, "#179E16"));
    ((Map)localObject1).put("borderPressedColor", mv(((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.b)this.QOV).QIZ, "#158E14"));
    ((Map)localObject1).put("borderDisableColor", mv(((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.b)this.QOV).QIY, "#00179E16"));
    int j = Color.parseColor((String)((Map)localObject1).get("fontNormalColor"));
    int k = Color.parseColor((String)((Map)localObject1).get("fontDisableColor"));
    int m = Color.parseColor((String)((Map)localObject1).get("fontPressedColor"));
    int n = Color.parseColor((String)((Map)localObject1).get("NormalColor"));
    int i1 = Color.parseColor((String)((Map)localObject1).get("PressedColor"));
    int i2 = Color.parseColor((String)((Map)localObject1).get("DisableColor"));
    int i3 = (int)((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.b)this.QOV).QJS;
    int i4 = Color.parseColor((String)((Map)localObject1).get("borderNormalColor"));
    int i5 = Color.parseColor((String)((Map)localObject1).get("borderPressedColor"));
    int i6 = Color.parseColor((String)((Map)localObject1).get("borderDisableColor"));
    int i = this.context.getResources().getDimensionPixelSize(b.d.ButtonCornerSize);
    if (((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.b)this.QOV).dwJ > 0.0F) {
      i = (int)((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.b)this.QOV).dwJ;
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
    this.QPz.setBackground(localStateListDrawable);
    localObject1 = new int[] { -16842910 };
    localObject2 = new int[] { 16842919 };
    localObject3 = new int[] { 16842910 };
    this.QPz.setTextColor(new ColorStateList(new int[][] { localObject1, localObject2, localObject3 }, new int[] { k, m, j }));
    if (((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.b)this.QOV).fontSize > 0.0F) {
      this.QPz.setTextSize(0, ((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.b)this.QOV).fontSize);
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
    this.QPA.setProgressDrawable((Drawable)localObject1);
    this.QPA.setPaintColor(((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.b)this.QOV).QJc);
    if (((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.b)this.QOV).height > 0.0F)
    {
      localObject1 = (RelativeLayout.LayoutParams)this.QPy.getLayoutParams();
      ((RelativeLayout.LayoutParams)localObject1).height = ((int)((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.b)this.QOV).height);
      this.QPy.setLayoutParams((ViewGroup.LayoutParams)localObject1);
    }
    this.QPz.setText(((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.b)this.QOV).title);
    com.tencent.mm.plugin.sns.ad.d.k.a(this.context, (com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.b)this.QOV, this.QPz);
    Log.d("MicroMsg.AdLandingPageDownloadApkBtnComp.state", "fillItem, sendMsg=11");
    this.QPB.sendMessage(11);
    AppMethodBeat.o(96555);
  }
  
  public final void hao()
  {
    AppMethodBeat.i(96557);
    super.hao();
    Log.d("MicroMsg.AdLandingPageDownloadApkBtnComp.state", "viewWillAppear, sendMsg=2");
    this.QPB.sendMessage(2);
    a locala = new a(this.rzx, this.enterScene, this.adExtInfo, this.pId, this.Qms);
    AdLandingPagesProxy.getInstance().addReportInfo(((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.b)this.QOV).appid, hjn().aid, hjn().qTb, hjn().uxInfo, locala);
    AppMethodBeat.o(96557);
  }
  
  public final void has()
  {
    AppMethodBeat.i(96558);
    super.has();
    Log.i("MicroMsg.AdLandingPageDownloadApkBtnComp", "view destroy");
    this.QPC.quit();
    if (this.QPD != null)
    {
      this.context.unregisterReceiver(this.QPD);
      this.QPD = null;
    }
    AppMethodBeat.o(96558);
  }
  
  final boolean hju()
  {
    AppMethodBeat.i(307234);
    for (;;)
    {
      try
      {
        boolean bool1 = NetStatusUtil.isWifi(this.context);
        boolean bool2 = AdLandingPagesProxy.getInstance().isFreeSimCard();
        Log.i("MicroMsg.AdLandingPageDownloadApkBtnComp", "isNeedShowNetworkTip, isWifi=" + bool1 + ", isFreeSimCard=" + bool2);
        if (bool1)
        {
          h.OAn.kJ(1612, 2);
          if ((bool1) || (bool2)) {
            break;
          }
          AppMethodBeat.o(307234);
          return true;
        }
        if (bool2) {
          h.OAn.kJ(1612, 3);
        } else {
          h.OAn.kJ(1612, 4);
        }
      }
      finally
      {
        Log.e("MicroMsg.AdLandingPageDownloadApkBtnComp", "isNeedShowNetworkTip exp=" + localObject.toString());
        AppMethodBeat.o(307234);
        return false;
      }
    }
    AppMethodBeat.o(307234);
    return false;
  }
  
  public static class a
    implements Serializable
  {
    public int Qms;
    public String adExtInfo;
    public int enterScene;
    public String pId;
    public String rzx;
    
    public a(String paramString1, int paramInt1, String paramString2, String paramString3, int paramInt2)
    {
      this.rzx = paramString1;
      this.enterScene = paramInt1;
      this.adExtInfo = paramString2;
      this.pId = paramString3;
      this.Qms = paramInt2;
    }
  }
  
  final class b
    extends StateMachine
    implements Serializable
  {
    State QPK;
    State QPL;
    State QPM;
    State QPN;
    State QPO;
    State QPP;
    State QPQ;
    State QPR;
    State QPS;
    
    protected b(String paramString, Looper paramLooper)
    {
      super(paramLooper);
      AppMethodBeat.i(96551);
      this.QPK = new c();
      this.QPL = new g();
      this.QPM = new e();
      this.QPN = new h();
      this.QPO = new i();
      this.QPP = new f();
      this.QPQ = new b();
      this.QPR = new a();
      this.QPS = new d();
      addState(this.QPL);
      addState(this.QPK);
      addState(this.QPM);
      addState(this.QPN);
      addState(this.QPO);
      addState(this.QPP);
      addState(this.QPQ);
      addState(this.QPR);
      addState(this.QPS);
      setInitialState(this.QPS);
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
        Log.d("MicroMsg.AdLandingPageDownloadApkBtnComp.state", "DisableUnsupportPlatformState enter, idx=" + ((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.b)t.this.QOV).QJd);
        MMHandlerThread.postToMainThread(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(96512);
            t.c(t.this).setVisibility(8);
            t.d(t.this).setEnabled(false);
            Button localButton = t.d(t.this);
            if (!TextUtils.isEmpty(t.b(t.this).QIT)) {}
            for (String str = t.b(t.this).QIT;; str = "暂不支持安卓手机")
            {
              localButton.setText(str);
              if (!t.e(t.this)) {
                t.d(t.this).setVisibility(0);
              }
              com.tencent.mm.plugin.sns.ad.d.k.a(t.this.context, t.b(t.this), t.d(t.this));
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
      private long QPX = 0L;
      
      b() {}
      
      public final void enter()
      {
        AppMethodBeat.i(96515);
        super.enter();
        Log.d("MicroMsg.AdLandingPageDownloadApkBtnComp.state", "DoNetSceneState enter, idx=" + ((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.b)t.this.QOV).QJd);
        this.QPX = System.currentTimeMillis();
        com.tencent.mm.plugin.sns.data.b localb = new com.tencent.mm.plugin.sns.data.b(t.this.uxInfo, t.this.rzx, t.this.enterScene, t.this.adExtInfo, t.this.PVG, t.this.qTb, t.this.pId);
        try
        {
          c.a locala = new c.a();
          locala.eventId = 4001021;
          locala.uxInfo = localb.uxInfo;
          locala.rzx = localb.rzx;
          locala.enterScene = localb.enterScene;
          locala.adExtInfo = localb.adExtInfo;
          locala.PVG = localb.PVG;
          locala.qTb = localb.qTb;
          locala.pId = localb.pId;
          locala.lxk = 4;
          com.tencent.mm.plugin.sns.ad.j.j.a(locala.heI());
          AdLandingPagesProxy.getInstance().doAdChannelScene(((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.b)t.this.QOV).bJH, ((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.b)t.this.QOV).channelId, t.this.QPI, ((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.b)t.this.QOV).QIP);
          Log.i("LogStateTransitionState", "[DoNetSceneState], appid=" + ((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.b)t.this.QOV).appid + ", pkg=" + ((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.b)t.this.QOV).bJH + ", channelId=" + ((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.b)t.this.QOV).channelId + ", useGameDownloadWidget=" + ((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.b)t.this.QOV).QIP + ", hash=" + hashCode());
          AppMethodBeat.o(96515);
          return;
        }
        finally
        {
          for (;;)
          {
            Log.e("AdConversionOnlineReportHelper", localObject.toString());
          }
        }
      }
      
      public final boolean processMessage(Message paramMessage)
      {
        AppMethodBeat.i(96514);
        Log.d("MicroMsg.AdLandingPageDownloadApkBtnComp.state", "DoNetSceneState msg=" + paramMessage.what + ", idx=" + ((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.b)t.this.QOV).QJd);
        Log.i("LogStateTransitionState", hashCode() + "[DoNetSceneState]recv msg.what " + paramMessage.what);
        if (AdLandingPagesProxy.getInstance().isApkExist(((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.b)t.this.QOV).appid))
        {
          t.b.l(t.b.this, t.b.this.QPN);
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
          int i = (int)(System.currentTimeMillis() - this.QPX);
          t.b.m(t.b.this, t.b.this.QPL);
          paramMessage = new com.tencent.mm.plugin.sns.data.b(t.this.uxInfo, t.this.rzx, t.this.enterScene, t.this.adExtInfo, t.this.PVG, t.this.qTb, t.this.pId);
          paramMessage.Qmp = i;
          try
          {
            c.a locala = new c.a();
            locala.eventId = 4001022;
            locala.uxInfo = paramMessage.uxInfo;
            locala.rzx = paramMessage.rzx;
            locala.enterScene = paramMessage.enterScene;
            locala.adExtInfo = paramMessage.adExtInfo;
            locala.PVG = paramMessage.PVG;
            locala.qTb = paramMessage.qTb;
            locala.pId = paramMessage.pId;
            locala.lxk = 4;
            locala.Qmp = paramMessage.Qmp;
            com.tencent.mm.plugin.sns.ad.j.j.a(locala.heI());
            this.QPX = 0L;
            AppMethodBeat.o(96514);
            return true;
          }
          finally
          {
            for (;;)
            {
              Log.e("AdConversionOnlineReportHelper", paramMessage.toString());
            }
          }
        case 5: 
          t.b.a(t.b.this, t.this.context.getString(b.j.sns_ad_download_apk_download_error));
          t.b.n(t.b.this, t.b.this.QPP);
          AppMethodBeat.o(96514);
          return true;
        }
        t.b.o(t.b.this, t.b.this.QPL);
        AppMethodBeat.o(96514);
        return true;
      }
    }
    
    final class c
      extends LogStateTransitionState
    {
      AdLandingPagesProxy.a QPY;
      
      c() {}
      
      public final void enter()
      {
        AppMethodBeat.i(96527);
        super.enter();
        Log.d("MicroMsg.AdLandingPageDownloadApkBtnComp.state", "DownloadingState enter, idx=" + ((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.b)t.this.QOV).QJd);
        MMHandlerThread.postToMainThread(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(96516);
            t.d(t.this).setVisibility(8);
            t.c(t.this).setVisibility(0);
            AppMethodBeat.o(96516);
          }
        });
        t.a locala = new t.a(t.this.rzx, t.this.enterScene, t.this.adExtInfo, t.this.pId, t.this.Qms);
        if ((AdLandingPagesProxy.getInstance().isPaused(((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.b)t.this.QOV).appid)) || (AdLandingPagesProxy.getInstance().isDownloading(((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.b)t.this.QOV).appid)))
        {
          if (this.QPY == null) {
            this.QPY = new a((byte)0);
          }
          MMHandlerThread.postToMainThread(new Runnable()
          {
            public final void run()
            {
              AppMethodBeat.i(96517);
              t.c(t.this).setProgress(AdLandingPagesProxy.getInstance().getTaskProgress(t.b(t.this).appid));
              AppMethodBeat.o(96517);
            }
          });
          if (!AdLandingPagesProxy.getInstance().resumeTask(((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.b)t.this.QOV).appid, this.QPY, t.this.hjn().aid, t.this.hjn().qTb, t.this.hjn().uxInfo, locala))
          {
            AdLandingPagesProxy.getInstance().stopTask(((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.b)t.this.QOV).appid);
            t.b.p(t.b.this, t.b.this.QPK);
            AppMethodBeat.o(96527);
          }
        }
        else
        {
          if (TextUtils.isEmpty(((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.b)t.this.QOV).downloadUrl))
          {
            t.b.q(t.b.this, t.b.this.QPQ);
            AppMethodBeat.o(96527);
            return;
          }
          if (AdLandingPagesProxy.getInstance().isApkExist(((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.b)t.this.QOV).appid))
          {
            MMHandlerThread.postToMainThread(new Runnable()
            {
              public final void run()
              {
                AppMethodBeat.i(96518);
                t.c(t.this).setProgress(100);
                AppMethodBeat.o(96518);
              }
            });
            t.b.r(t.b.this, t.b.this.QPN);
            AppMethodBeat.o(96527);
            return;
          }
          AdLandingPagesProxy.getInstance().stopTask(((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.b)t.this.QOV).appid);
          this.QPY = new a((byte)0);
          AdLandingPagesProxy.getInstance().startDownload(((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.b)t.this.QOV).appid, ((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.b)t.this.QOV).QIO, ((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.b)t.this.QOV).bJH, ((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.b)t.this.QOV).md5, ((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.b)t.this.QOV).downloadUrl, ((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.b)t.this.QOV).QIQ, ((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.b)t.this.QOV).QIR, this.QPY, t.this.hjn().aid, t.this.hjn().qTb, t.this.hjn().uxInfo, ((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.b)t.this.QOV).QIP, locala);
        }
        AppMethodBeat.o(96527);
      }
      
      public final boolean processMessage(final Message paramMessage)
      {
        AppMethodBeat.i(96528);
        if (paramMessage.what != 1) {
          Log.d("MicroMsg.AdLandingPageDownloadApkBtnComp.state", "DownloadingState, msg=" + paramMessage.what + ", idx=" + ((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.b)t.this.QOV).QJd);
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
          if ((AdLandingPagesProxy.getInstance().pauseTask(((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.b)t.this.QOV).appid)) && (AdLandingPagesProxy.getInstance().isPaused(((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.b)t.this.QOV).appid))) {
            t.b.s(t.b.this, t.b.this.QPM);
          }
          paramMessage = new t.a(t.this.rzx, t.this.enterScene, t.this.adExtInfo, t.this.pId, t.this.Qms);
          com.tencent.mm.plugin.sns.data.b localb = new com.tencent.mm.plugin.sns.data.b(t.this.uxInfo, t.this.rzx, t.this.enterScene, t.this.adExtInfo, t.this.PVG, t.this.qTb, t.this.pId, t.this.Qms);
          try
          {
            c.a locala = new c.a();
            locala.eventId = 4001007;
            locala.uxInfo = localb.uxInfo;
            locala.rzx = localb.rzx;
            locala.enterScene = localb.enterScene;
            locala.adExtInfo = localb.adExtInfo;
            locala.PVG = localb.PVG;
            locala.qTb = localb.qTb;
            locala.pId = localb.pId;
            locala.lxk = 4;
            locala.Qms = localb.Qms;
            com.tencent.mm.plugin.sns.ad.j.j.a(locala.heI());
            com.tencent.mm.ui.base.k.a(t.this.context, b.j.sns_ad_download_apk_cancel_tip_content, b.j.sns_ad_download_apk_cancel_tip_title, b.j.sns_ad_download_apk_no, b.j.sns_ad_download_apk_yes, false, new DialogInterface.OnClickListener()new DialogInterface.OnClickListener
            {
              public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
              {
                AppMethodBeat.i(307005);
                Log.i("LogStateTransitionState", "tip dialog, continue download, resumeTask");
                AdLandingPagesProxy.getInstance().resumeTask(t.b(t.this).appid, t.b.c.this.QPY, t.this.hjn().aid, t.this.hjn().qTb, t.this.hjn().uxInfo, paramMessage);
                paramAnonymousDialogInterface = new com.tencent.mm.plugin.sns.data.b(t.i(t.this), t.k(t.this), t.l(t.this), t.j(t.this), t.m(t.this), t.n(t.this), t.o(t.this), t.p(t.this));
                try
                {
                  c.a locala = new c.a();
                  locala.eventId = 4001008;
                  locala.uxInfo = paramAnonymousDialogInterface.uxInfo;
                  locala.rzx = paramAnonymousDialogInterface.rzx;
                  locala.enterScene = paramAnonymousDialogInterface.enterScene;
                  locala.adExtInfo = paramAnonymousDialogInterface.adExtInfo;
                  locala.PVG = paramAnonymousDialogInterface.PVG;
                  locala.qTb = paramAnonymousDialogInterface.qTb;
                  locala.pId = paramAnonymousDialogInterface.pId;
                  locala.lxk = 4;
                  locala.Qms = paramAnonymousDialogInterface.Qms;
                  com.tencent.mm.plugin.sns.ad.j.j.a(locala.heI());
                  AppMethodBeat.o(307005);
                  return;
                }
                finally
                {
                  Log.e("AdConversionOnlineReportHelper", paramAnonymousDialogInterface.toString());
                  AppMethodBeat.o(307005);
                }
              }
            }, new DialogInterface.OnClickListener()
            {
              public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
              {
                AppMethodBeat.i(306988);
                Log.i("LogStateTransitionState", "tip dialog, confirm cancel");
                com.tencent.mm.plugin.sns.data.k.a(t.g(t.this), t.h(t.this), 1, 5, t.i(t.this), t.j(t.this), 1);
                AppMethodBeat.o(306988);
              }
            });
            com.tencent.mm.plugin.sns.data.k.a(t.this.hQX, t.this.appId, 0, 5, t.this.uxInfo, t.this.adExtInfo, 1);
            AppMethodBeat.o(96528);
            return true;
          }
          finally
          {
            for (;;)
            {
              Log.e("AdConversionOnlineReportHelper", localObject.toString());
            }
          }
        case 1: 
          MMHandlerThread.postToMainThread(new Runnable()
          {
            public final void run()
            {
              AppMethodBeat.i(307013);
              if (this.val$progress >= 0) {
                t.c(t.this).setProgress(this.val$progress);
              }
              AppMethodBeat.o(307013);
            }
          });
          AppMethodBeat.o(96528);
          return true;
        case 3: 
          t.b.t(t.b.this, t.b.this.QPO);
          AppMethodBeat.o(96528);
          return true;
        case 7: 
          t.b.u(t.b.this, t.b.this.QPM);
          AppMethodBeat.o(96528);
          return true;
        case 8: 
          t.b.a(t.b.this, t.this.context.getString(b.j.sns_ad_download_apk_download_error));
          t.b.v(t.b.this, t.b.this.QPP);
          AppMethodBeat.o(96528);
          return true;
        case 9: 
          paramMessage = t.this;
          Log.d("MicroMsg.AdLandingPageDownloadApkBtnComp", "writing deferred deep link");
          AdLandingPagesProxy.getInstance().writeDeferredDeepLink(((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.b)paramMessage.QOV).bJH, ((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.b)paramMessage.QOV).PLD);
          com.tencent.mm.plugin.sns.ad.d.b.lK(((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.b)paramMessage.QOV).bJH, ((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.b)paramMessage.QOV).PLD);
          t.b.w(t.b.this, t.b.this.QPN);
          AppMethodBeat.o(96528);
          return true;
        }
        t.this.QPA.setProgress(0);
        t.b.x(t.b.this, t.b.this.QPL);
        AppMethodBeat.o(96528);
        return true;
      }
      
      final class a
        implements AdLandingPagesProxy.a
      {
        private a() {}
        
        public final void aky(int paramInt)
        {
          AppMethodBeat.i(96521);
          if (paramInt % 20 == 0) {
            Log.d("MicroMsg.AdLandingPageDownloadApkBtnComp.callback", "progress:" + paramInt + ", idx=" + t.b(t.this).QJd);
          }
          t.a(t.this).sendMessage(1, paramInt);
          AppMethodBeat.o(96521);
        }
        
        public final void hfr()
        {
          AppMethodBeat.i(96522);
          Log.d("MicroMsg.AdLandingPageDownloadApkBtnComp.callback", "paused, idx=" + t.b(t.this).QJd);
          t.a(t.this).sendMessage(7);
          AppMethodBeat.o(96522);
        }
        
        public final void hfs()
        {
          AppMethodBeat.i(96523);
          Log.d("MicroMsg.AdLandingPageDownloadApkBtnComp.callback", "stopped, idx=" + t.b(t.this).QJd);
          t.a(t.this).sendMessage(14);
          AppMethodBeat.o(96523);
        }
        
        public final void hft()
        {
          AppMethodBeat.i(96524);
          Log.d("MicroMsg.AdLandingPageDownloadApkBtnComp.callback", "succeed, idx=" + t.b(t.this).QJd);
          t.a(t.this).sendMessage(9);
          AppMethodBeat.o(96524);
        }
        
        public final void hfu()
        {
          AppMethodBeat.i(96525);
          Log.d("MicroMsg.AdLandingPageDownloadApkBtnComp.callback", "failed, idx=" + t.b(t.this).QJd);
          t.a(t.this).sendMessage(8);
          AppMethodBeat.o(96525);
        }
        
        public final void hfv()
        {
          AppMethodBeat.i(96526);
          Log.d("MicroMsg.AdLandingPageDownloadApkBtnComp.callback", "resumed, idx=" + t.b(t.this).QJd);
          t.a(t.this).sendMessage(13);
          AppMethodBeat.o(96526);
        }
        
        public final void start()
        {
          AppMethodBeat.i(96520);
          Log.d("MicroMsg.AdLandingPageDownloadApkBtnComp.callback", "start, idx=" + t.b(t.this).QJd);
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
        Log.d("MicroMsg.AdLandingPageDownloadApkBtnComp.state", "InitState enter, idx=" + ((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.b)t.this.QOV).QJd);
        com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.b localb = (com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.b)t.this.QOV;
        int i;
        if ((localb.QIS == 0) || (localb.QIS == 2)) {
          i = 1;
        }
        while (i != 0) {
          if (AdLandingPagesProxy.getInstance().isApkExist(((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.b)t.this.QOV).appid))
          {
            t.b.a(t.b.this, t.b.this.QPN);
            AppMethodBeat.o(96529);
            return;
            i = 0;
          }
          else
          {
            if (AdLandingPagesProxy.getInstance().isPkgInstalled(((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.b)t.this.QOV).bJH))
            {
              t.b.b(t.b.this, t.b.this.QPO);
              AppMethodBeat.o(96529);
              return;
            }
            t.b.c(t.b.this, t.b.this.QPQ);
            AppMethodBeat.o(96529);
            return;
          }
        }
        t.b.d(t.b.this, t.b.this.QPR);
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
        Log.d("MicroMsg.AdLandingPageDownloadApkBtnComp.state", "PauseState enter, idx=" + ((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.b)t.this.QOV).QJd);
        MMHandlerThread.postToMainThread(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(96530);
            t.c(t.this).setVisibility(8);
            if (!t.e(t.this)) {
              t.d(t.this).setVisibility(0);
            }
            t.d(t.this).setText(b.j.sns_ad_download_apk_continue);
            com.tencent.mm.plugin.sns.ad.d.k.a(t.this.context, t.b(t.this), t.d(t.this));
            AppMethodBeat.o(96530);
          }
        });
        AppMethodBeat.o(96532);
      }
      
      public final boolean processMessage(Message paramMessage)
      {
        AppMethodBeat.i(96533);
        Log.d("MicroMsg.AdLandingPageDownloadApkBtnComp.state", "PauseState, msg=" + paramMessage.what + ", idx=" + ((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.b)t.this.QOV).QJd);
        Log.i("LogStateTransitionState", hashCode() + "[PauseState] recv msg.what " + paramMessage.what);
        switch (paramMessage.what)
        {
        default: 
          AppMethodBeat.o(96533);
          return false;
        case 0: 
          if (AdLandingPagesProxy.getInstance().isDownloading(((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.b)t.this.QOV).appid)) {
            t.b.a(t.b.this, t.this.context.getString(b.j.sns_ad_download_apk_already));
          }
          for (;;)
          {
            AppMethodBeat.o(96533);
            return true;
            if (t.this.hju())
            {
              Log.i("LogStateTransitionState", "download not in wifi!");
              com.tencent.mm.plugin.sns.data.k.a(t.this.hQX, t.this.appId, 0, 1, t.this.uxInfo, t.this.adExtInfo, 1);
              com.tencent.mm.plugin.sns.ad.d.c.g(new com.tencent.mm.plugin.sns.data.b(t.this.uxInfo, t.this.rzx, t.this.enterScene, t.this.adExtInfo, t.this.PVG, t.this.qTb, t.this.pId, t.this.Qms, 102));
              com.tencent.mm.ui.base.k.a(t.this.context, b.j.webview_download_ui_download_not_in_wifi_tips, b.j.webview_download_ui_download_not_in_wifi_title, new DialogInterface.OnClickListener()
              {
                public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
                {
                  AppMethodBeat.i(96531);
                  t.b.this.sendMessage(12);
                  com.tencent.mm.plugin.sns.data.k.a(t.g(t.this), t.h(t.this), 1, 1, t.i(t.this), t.j(t.this), 1);
                  com.tencent.mm.plugin.sns.ad.d.c.h(new com.tencent.mm.plugin.sns.data.b(t.i(t.this), t.k(t.this), t.l(t.this), t.j(t.this), t.m(t.this), t.n(t.this), t.o(t.this), t.p(t.this), 102));
                  com.tencent.mm.modelstat.d.d(10, "AdLandingPageDownloadApkBtnComp_PAUSE_MSG_BTN_CLICK", t.b.e.this.hashCode());
                  AppMethodBeat.o(96531);
                }
              }, null);
            }
            else
            {
              int i = ((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.b)t.this.QOV).QJf;
              Log.i("MicroMsg.AdLandingPageDownloadApkBtnComp.GroceryDownload", "showDownloadTip = ".concat(String.valueOf(i)));
              if (i == 1) {
                t.b.a(t.b.this, 1);
              } else {
                t.b.this.sendMessage(12);
              }
            }
          }
        case 3: 
          t.b.y(t.b.this, t.b.this.QPO);
          AppMethodBeat.o(96533);
          return true;
        case 8: 
          t.b.a(t.b.this, t.this.context.getString(b.j.sns_ad_download_apk_download_error));
          t.b.z(t.b.this, t.b.this.QPP);
          AppMethodBeat.o(96533);
          return true;
        case 12: 
          t.b.A(t.b.this, t.b.this.QPK);
          AppMethodBeat.o(96533);
          return true;
        }
        t.b.B(t.b.this, t.b.this.QPK);
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
        Log.d("MicroMsg.AdLandingPageDownloadApkBtnComp.state", "ReDownloadState enter, idx=" + ((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.b)t.this.QOV).QJd);
        MMHandlerThread.postToMainThread(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(96534);
            t.c(t.this).setVisibility(8);
            if (!t.e(t.this)) {
              t.d(t.this).setVisibility(0);
            }
            t.d(t.this).setText(b.j.sns_ad_download_apk_retry);
            com.tencent.mm.plugin.sns.ad.d.k.a(t.this.context, t.b(t.this), t.d(t.this));
            AppMethodBeat.o(96534);
          }
        });
        AppMethodBeat.o(96535);
      }
      
      public final boolean processMessage(Message paramMessage)
      {
        AppMethodBeat.i(96536);
        Log.d("MicroMsg.AdLandingPageDownloadApkBtnComp.state", "ReDownloadState, msg=" + paramMessage.what + ", idx=" + ((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.b)t.this.QOV).QJd);
        Log.i("LogStateTransitionState", hashCode() + "[ReDownloadState] recv msg.what " + paramMessage.what);
        switch (paramMessage.what)
        {
        default: 
          AppMethodBeat.o(96536);
          return false;
        }
        t.this.Qms = 2;
        t.b.J(t.b.this, t.b.this.QPQ);
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
        Log.d("MicroMsg.AdLandingPageDownloadApkBtnComp.state", "ToDownloadState enter, idx=" + ((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.b)t.this.QOV).QJd);
        MMHandlerThread.postToMainThread(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(96537);
            if (t.f(t.this) == null)
            {
              t.a(t.this, new t.c(t.this, (byte)0));
              IntentFilter localIntentFilter = new IntentFilter();
              localIntentFilter.addAction("android.intent.action.PACKAGE_ADDED");
              localIntentFilter.addAction("android.intent.action.PACKAGE_REMOVED");
              localIntentFilter.addDataScheme("package");
              t.this.context.registerReceiver(t.f(t.this), localIntentFilter);
            }
            AppMethodBeat.o(96537);
          }
        });
        if (AdLandingPagesProxy.getInstance().isPkgInstalled(((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.b)t.this.QOV).bJH))
        {
          t.b.e(t.b.this, t.b.this.QPO);
          AppMethodBeat.o(96543);
          return;
        }
        if (AdLandingPagesProxy.getInstance().isApkExist(((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.b)t.this.QOV).appid))
        {
          t.b.f(t.b.this, t.b.this.QPN);
          AppMethodBeat.o(96543);
          return;
        }
        if (AdLandingPagesProxy.getInstance().isDownloading(((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.b)t.this.QOV).appid))
        {
          t.b.g(t.b.this, t.b.this.QPK);
          AppMethodBeat.o(96543);
          return;
        }
        if (AdLandingPagesProxy.getInstance().isPaused(((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.b)t.this.QOV).appid))
        {
          t.b.h(t.b.this, t.b.this.QPM);
          AppMethodBeat.o(96543);
          return;
        }
        MMHandlerThread.postToMainThread(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(96538);
            t.c(t.this).setVisibility(8);
            if (!t.e(t.this)) {
              t.d(t.this).setVisibility(0);
            }
            t.d(t.this).setText(t.b(t.this).title);
            com.tencent.mm.plugin.sns.ad.d.k.a(t.this.context, t.b(t.this), t.d(t.this));
            AppMethodBeat.o(96538);
          }
        });
        t.this.Qms = 2;
        boolean bool;
        if (t.this.QPE) {
          if (t.this.hjn().QLx) {
            bool = ((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.b)t.this.QOV).QJe;
          }
        }
        for (;;)
        {
          if ((bool) && (t.this.QPF))
          {
            t.this.QPF = false;
            MMHandlerThread.postToMainThreadDelayed(new Runnable()
            {
              public final void run()
              {
                AppMethodBeat.i(96540);
                try
                {
                  double d = (float)t.b(t.this).fileSize / 1024.0F / 1024.0F;
                  String str;
                  if (Util.isNullOrNil(t.b(t.this).QIQ)) {
                    str = t.this.context.getString(b.j.sns_ad_action_btn_download_app_default_tip);
                  }
                  for (;;)
                  {
                    com.tencent.mm.plugin.sns.data.k.a(t.g(t.this), t.h(t.this), 0, 0, t.i(t.this), t.j(t.this), 1);
                    com.tencent.mm.plugin.sns.ad.d.c.g(new com.tencent.mm.plugin.sns.data.b(t.i(t.this), t.k(t.this), t.l(t.this), t.j(t.this), t.m(t.this), t.n(t.this), t.o(t.this), 1, 101));
                    com.tencent.mm.ui.base.k.b(t.this.context, str, "", "是", "否", new DialogInterface.OnClickListener()
                    {
                      public final void onClick(DialogInterface paramAnonymous2DialogInterface, int paramAnonymous2Int)
                      {
                        AppMethodBeat.i(96539);
                        t.a(t.this, 1);
                        t.a(t.this).sendMessage(0);
                        com.tencent.mm.plugin.sns.data.k.a(t.g(t.this), t.h(t.this), 1, 0, t.i(t.this), t.j(t.this), 1);
                        com.tencent.mm.plugin.sns.ad.d.c.h(new com.tencent.mm.plugin.sns.data.b(t.i(t.this), t.k(t.this), t.l(t.this), t.j(t.this), t.m(t.this), t.n(t.this), t.o(t.this), t.p(t.this), 101));
                        AppMethodBeat.o(96539);
                      }
                    }, null);
                    AppMethodBeat.o(96540);
                    return;
                    if (d > 0.0D)
                    {
                      str = String.format("%.1f", new Object[] { Double.valueOf(d) });
                      str = t.this.context.getString(b.j.sns_ad_action_btn_download_app_tip_with_size, new Object[] { t.b(t.this).QIQ, str });
                    }
                    else
                    {
                      str = t.this.context.getString(b.j.sns_ad_action_btn_download_app_tip, new Object[] { t.b(t.this).QIQ });
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
          if (((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.b)t.this.QOV).QJd == 0)
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
        Log.d("MicroMsg.AdLandingPageDownloadApkBtnComp.state", "ToDownloadState, msg=" + paramMessage.what + ", idx=" + ((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.b)t.this.QOV).QJd);
        Log.i("LogStateTransitionState", hashCode() + "[ToDownloadState]recv msg.what " + paramMessage.what);
        switch (paramMessage.what)
        {
        default: 
          AppMethodBeat.o(96544);
          return false;
        case 0: 
          if (AdLandingPagesProxy.getInstance().isDownloading(((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.b)t.this.QOV).appid)) {
            t.b.a(t.b.this, t.this.context.getString(b.j.sns_ad_download_apk_already));
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
                if (t.q(t.this))
                {
                  Log.i("LogStateTransitionState", "download not in wifi!");
                  com.tencent.mm.plugin.sns.data.k.a(t.g(t.this), t.h(t.this), 0, 0, t.i(t.this), t.j(t.this), 1);
                  com.tencent.mm.plugin.sns.ad.d.c.g(new com.tencent.mm.plugin.sns.data.b(t.i(t.this), t.k(t.this), t.l(t.this), t.j(t.this), t.m(t.this), t.n(t.this), t.o(t.this), t.p(t.this), 102));
                  com.tencent.mm.ui.base.k.a(t.this.context, b.j.webview_download_ui_download_not_in_wifi_tips, b.j.webview_download_ui_download_not_in_wifi_title, new DialogInterface.OnClickListener()new DialogInterface.OnClickListener
                  {
                    public final void onClick(DialogInterface paramAnonymous2DialogInterface, int paramAnonymous2Int)
                    {
                      AppMethodBeat.i(96541);
                      t.a(t.this).sendMessage(12);
                      com.tencent.mm.plugin.sns.ad.d.c.h(new com.tencent.mm.plugin.sns.data.b(t.i(t.this), t.k(t.this), t.l(t.this), t.j(t.this), t.m(t.this), t.n(t.this), t.o(t.this), t.p(t.this), 102));
                      com.tencent.mm.plugin.sns.data.k.a(t.g(t.this), t.h(t.this), 1, 0, t.i(t.this), t.j(t.this), 1);
                      com.tencent.mm.modelstat.d.d(10, "AdLandingPageDownloadApkBtnComp_TODOWLOAD_MSG_BTN_CLICK", t.b.g.this.hashCode());
                      AppMethodBeat.o(96541);
                    }
                  }, new DialogInterface.OnClickListener()
                  {
                    public final void onClick(DialogInterface paramAnonymous2DialogInterface, int paramAnonymous2Int)
                    {
                      AppMethodBeat.i(306894);
                      t.a(t.this, 2);
                      AppMethodBeat.o(306894);
                    }
                  });
                  AppMethodBeat.o(96542);
                  return;
                }
                int i = t.b(t.this).QJf;
                Log.i("MicroMsg.AdLandingPageDownloadApkBtnComp.GroceryDownload", "showDownloadTip = ".concat(String.valueOf(i)));
                if (i == 1)
                {
                  if (AdLandingPagesProxy.getInstance().isPaused(t.b(t.this).appid))
                  {
                    t.b.a(t.b.this, 1);
                    AppMethodBeat.o(96542);
                    return;
                  }
                  t.b.a(t.b.this, 0);
                  AppMethodBeat.o(96542);
                  return;
                }
                t.a(t.this).sendMessage(12);
                AppMethodBeat.o(96542);
              }
            });
          }
        case 3: 
          t.b.i(t.b.this, t.b.this.QPO);
          AppMethodBeat.o(96544);
          return true;
        case 11: 
          t.b.j(t.b.this, t.b.this.QPL);
          AppMethodBeat.o(96544);
          return true;
        }
        t.b.k(t.b.this, t.b.this.QPK);
        AppMethodBeat.o(96544);
        return true;
      }
    }
    
    final class h
      extends LogStateTransitionState
    {
      private boolean QQg;
      
      h() {}
      
      public final void enter()
      {
        AppMethodBeat.i(96546);
        Log.d("MicroMsg.AdLandingPageDownloadApkBtnComp.state", "ToInstallState enter, idx=" + ((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.b)t.this.QOV).QJd);
        super.enter();
        if (!AdLandingPagesProxy.getInstance().isApkExist(((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.b)t.this.QOV).appid))
        {
          t.b.C(t.b.this, t.b.this.QPL);
          AppMethodBeat.o(96546);
          return;
        }
        MMHandlerThread.postToMainThread(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(96545);
            t.c(t.this).setVisibility(8);
            if (!t.e(t.this)) {
              t.d(t.this).setVisibility(0);
            }
            t.d(t.this).setText(b.j.sns_ad_download_apk_install);
            com.tencent.mm.plugin.sns.ad.d.k.a(t.this.context, t.b(t.this), t.d(t.this));
            AppMethodBeat.o(96545);
          }
        });
        this.QQg = true;
        AppMethodBeat.o(96546);
      }
      
      public final boolean processMessage(Message paramMessage)
      {
        AppMethodBeat.i(96547);
        Log.d("MicroMsg.AdLandingPageDownloadApkBtnComp.state", "ToInstallState, msg=" + paramMessage.what + ", idx=" + ((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.b)t.this.QOV).QJd);
        Log.i("LogStateTransitionState", hashCode() + "[ToInstallState] recv msg.what " + paramMessage.what);
        switch (paramMessage.what)
        {
        case 1: 
        default: 
          AppMethodBeat.o(96547);
          return false;
        case 0: 
          if (AdLandingPagesProxy.getInstance().installApp(t.this.context, ((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.b)t.this.QOV).appid, ((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.b)t.this.QOV).bJH, ((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.b)t.this.QOV).md5, ((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.b)t.this.QOV).downloadUrl))
          {
            this.QQg = true;
            AppMethodBeat.o(96547);
            return true;
          }
          t.b.a(t.b.this, t.this.context.getString(b.j.sns_ad_download_apk_install_error));
          t.b.D(t.b.this, t.b.this.QPP);
          AppMethodBeat.o(96547);
          return true;
        case 2: 
          if (!AdLandingPagesProxy.getInstance().isApkExist(((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.b)t.this.QOV).appid)) {
            t.b.E(t.b.this, t.b.this.QPL);
          }
          AppMethodBeat.o(96547);
          return true;
        }
        if (this.QQg) {
          this.QQg = false;
        }
        t.b.F(t.b.this, t.b.this.QPO);
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
        Log.d("MicroMsg.AdLandingPageDownloadApkBtnComp.state", "ToOpenState enter, idx=" + ((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.b)t.this.QOV).QJd);
        if (AdLandingPagesProxy.getInstance().isPkgInstalled(((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.b)t.this.QOV).bJH))
        {
          MMHandlerThread.postToMainThread(new Runnable()
          {
            public final void run()
            {
              AppMethodBeat.i(96548);
              t.c(t.this).setVisibility(8);
              if (!t.e(t.this)) {
                t.d(t.this).setVisibility(0);
              }
              if (Util.isNullOrNil(t.b(t.this).QJi)) {
                t.d(t.this).setText(b.j.sns_ad_download_apk_open);
              }
              for (;;)
              {
                com.tencent.mm.plugin.sns.ad.d.k.a(t.this.context, t.b(t.this), t.d(t.this));
                AppMethodBeat.o(96548);
                return;
                t.d(t.this).setText(t.b(t.this).QJi);
              }
            }
          });
          AppMethodBeat.o(96549);
          return;
        }
        t.b.G(t.b.this, t.b.this.QPN);
        AppMethodBeat.o(96549);
      }
      
      public final boolean processMessage(Message paramMessage)
      {
        AppMethodBeat.i(96550);
        Log.d("MicroMsg.AdLandingPageDownloadApkBtnComp.state", "ToOpenState, msg=" + paramMessage.what + ", idx=" + ((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.b)t.this.QOV).QJd);
        Log.i("LogStateTransitionState", hashCode() + "[ToOpenState] recv msg.what " + paramMessage.what);
        switch (paramMessage.what)
        {
        default: 
          AppMethodBeat.o(96550);
          return false;
        case 0: 
          paramMessage = new com.tencent.mm.plugin.sns.ad.g.j(t.this.rzx, t.this.enterScene, t.this.PVG, t.this.qTb, t.this.pId);
          if (m.a(t.this.context, ((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.b)t.this.QOV).appid, ((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.b)t.this.QOV).bJH, "", ((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.b)t.this.QOV).PLD, t.this.uxInfo, t.this.adExtInfo, t.this.hQX, 1, 2, paramMessage))
          {
            AppMethodBeat.o(96550);
            return true;
          }
          t.b.a(t.b.this, t.this.context.getString(b.j.sns_ad_download_apk_open_error));
          t.b.H(t.b.this, t.b.this.QPO);
          AppMethodBeat.o(96550);
          return true;
        }
        t.b.I(t.b.this, t.b.this.QPL);
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
          if ((!TextUtils.isEmpty(paramContext)) && (paramContext.equals(((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.b)t.this.QOV).bJH))) {
            t.this.QPB.sendMessage(3);
          }
          AppMethodBeat.o(96553);
          return;
        }
        if ("android.intent.action.PACKAGE_REMOVED".equals(paramContext))
        {
          paramContext = paramIntent.getData().getSchemeSpecificPart();
          if ((!TextUtils.isEmpty(paramContext)) && (paramContext.equals(((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.b)t.this.QOV).bJH))) {
            t.this.QPB.sendMessage(4);
          }
        }
      }
      AppMethodBeat.o(96553);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.t
 * JD-Core Version:    0.7.0.1
 */