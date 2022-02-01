package com.tencent.mm.plugin.sns.ui;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Typeface;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.Parcelable;
import android.text.SpannableString;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.f.h;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.c.ax;
import com.tencent.mm.model.cl;
import com.tencent.mm.modelsns.SnsAdClick;
import com.tencent.mm.platformtools.ac;
import com.tencent.mm.plugin.messenger.foundation.a.l;
import com.tencent.mm.plugin.sns.data.r;
import com.tencent.mm.plugin.sns.e.b.1;
import com.tencent.mm.plugin.sns.e.b.2;
import com.tencent.mm.plugin.sns.e.b.3;
import com.tencent.mm.plugin.sns.e.b.a;
import com.tencent.mm.plugin.sns.model.AdLandingPagesProxy;
import com.tencent.mm.plugin.sns.storage.ADInfo;
import com.tencent.mm.plugin.sns.storage.ADXml;
import com.tencent.mm.plugin.sns.storage.ADXml.AdCardActionBtnInfo;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.a.e;
import com.tencent.mm.plugin.sns.storage.AdSnsInfo;
import com.tencent.mm.plugin.sns.storage.SnsInfo;
import com.tencent.mm.plugin.sns.storage.y;
import com.tencent.mm.pluginsdk.m;
import com.tencent.mm.protocal.protobuf.TimeLineObject;
import com.tencent.mm.protocal.protobuf.adp;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.as;
import com.tencent.mm.storage.bv;
import com.tencent.mm.ui.base.u;
import com.tencent.mm.ui.widget.RoundedCornerFrameLayout;
import com.tencent.mm.ui.widget.a.e;
import com.tencent.mm.ui.widget.imageview.WeImageView;
import java.util.HashMap;

public final class av
  implements View.OnClickListener
{
  private ADXml.AdCardActionBtnInfo DCW;
  private SnsInfo DqO;
  private int DxM;
  public com.tencent.mm.plugin.sns.ad.g.k DzW;
  private RoundedCornerFrameLayout EwE;
  private ImageView EwF;
  private TextView EwG;
  private TextView EwH;
  public Button EwI;
  private View EwJ;
  private b EwK;
  private a EwL;
  private String adExtInfo;
  private String dRS;
  private bv iFD;
  private View mContentView;
  public Context mContext;
  private as rjX;
  private String uxInfo;
  
  public av(Context paramContext, View paramView, int paramInt, com.tencent.mm.plugin.sns.ad.g.k paramk, b paramb)
  {
    AppMethodBeat.i(98296);
    this.adExtInfo = "";
    this.uxInfo = "";
    this.dRS = "";
    this.EwL = new a()
    {
      public final void a(ADXml.AdCardActionBtnInfo paramAnonymousAdCardActionBtnInfo)
      {
        AppMethodBeat.i(179160);
        if ((paramAnonymousAdCardActionBtnInfo == null) || (av.d(av.this) == null))
        {
          Log.e("MicroMsg.SnsAdCardActionBtnCtrl", "adCardActionBtnInfo or mActionBtn is null, can not updateActionBtnTitle");
          AppMethodBeat.o(179160);
          return;
        }
        switch (paramAnonymousAdCardActionBtnInfo.clickActionType)
        {
        }
        for (;;)
        {
          AppMethodBeat.o(179160);
          return;
          if (!Util.isNullOrNil(paramAnonymousAdCardActionBtnInfo.btnTitleAfterOrder))
          {
            av.d(av.this).setTextColor(-7829368);
            av.d(av.this).setText(paramAnonymousAdCardActionBtnInfo.btnTitleAfterOrder);
            av.d(av.this).setEnabled(false);
            AppMethodBeat.o(179160);
            return;
            paramAnonymousAdCardActionBtnInfo = paramAnonymousAdCardActionBtnInfo.btnTitleAfterAddBrand;
            if (!Util.isNullOrNil(paramAnonymousAdCardActionBtnInfo)) {
              av.d(av.this).setText(paramAnonymousAdCardActionBtnInfo);
            }
          }
        }
      }
    };
    Log.d("MicroMsg.SnsAdCardActionBtnCtrl", "init, source=" + paramInt + ", context=" + paramContext + ", static=" + paramk);
    this.mContext = paramContext;
    this.DxM = paramInt;
    this.DzW = paramk;
    this.EwK = paramb;
    this.mContentView = paramView;
    this.EwJ = this.mContentView.findViewById(2131304552);
    this.EwE = ((RoundedCornerFrameLayout)paramView.findViewById(2131296390));
    this.EwF = ((ImageView)paramView.findViewById(2131296389));
    this.EwG = ((TextView)paramView.findViewById(2131296416));
    this.EwH = ((TextView)paramView.findViewById(2131296384));
    this.EwI = ((Button)paramView.findViewById(2131296377));
    this.EwI.setOnClickListener(this);
    this.EwE.setRadius(com.tencent.mm.cb.a.fromDPToPix(this.mContext, 4));
    this.iFD = ((l)com.tencent.mm.kernel.g.af(l.class)).aSN();
    AppMethodBeat.o(98296);
  }
  
  private int a(String paramString1, String paramString2, String paramString3, SnsAdClick paramSnsAdClick)
  {
    AppMethodBeat.i(203406);
    Log.i("MicroMsg.SnsAdCardActionBtnCtrl", "handleDownload, appPageUrl=" + paramString3 + ", pkg=" + paramString2 + ", appId=" + paramString1);
    Object localObject = a.e.DXp;
    if (com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.a.bz(MMApplicationContext.getContext(), paramString2))
    {
      Log.i("MicroMsg.SnsAdCardActionBtnCtrl", "isPkgInstalled==true");
      if (this.DqO != null)
      {
        paramSnsAdClick = this.DqO.getAdInfo(this.DxM);
        if (paramSnsAdClick != null) {
          this.uxInfo = Util.nullAsNil(paramSnsAdClick.uxInfo);
        }
      }
      com.tencent.mm.plugin.sns.data.k.a(this.mContext, paramString1, paramString2, "", paramString3, this.uxInfo, this.adExtInfo, this.dRS, 0, 0);
      if (!TextUtils.isEmpty(paramString3))
      {
        AppMethodBeat.o(203406);
        return 34;
      }
    }
    else
    {
      localObject = a.e.DXp;
      if (!com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.a.isApkExist(paramString1)) {
        break label195;
      }
      Log.i("MicroMsg.SnsAdCardActionBtnCtrl", "isApkExist==true");
      com.tencent.mm.plugin.sns.data.k.jZ(paramString2, paramString3);
      AdLandingPagesProxy.getInstance().installApp(this.mContext, paramString1, paramString2, "", "");
    }
    for (;;)
    {
      AppMethodBeat.o(203406);
      return 21;
      label195:
      boolean bool2 = false;
      boolean bool1 = bool2;
      if (this.DqO != null) {}
      try
      {
        paramString1 = this.DqO.getAdInfo(this.DxM);
        bool1 = com.tencent.mm.plugin.sns.data.k.b(this.mContext, this.DqO, paramString1);
        if (!bool1)
        {
          paramString3 = this.DqO;
          paramString2 = (Activity)this.mContext;
          int i = this.DxM;
          localObject = this.EwJ;
          StringBuilder localStringBuilder = new StringBuilder("jumpNativeLandingPageUIForDownload, snsId=");
          if (paramString3 == null) {}
          for (paramString1 = "";; paramString1 = r.Jb(paramString3.field_snsId))
          {
            Log.i("MicroMsg.SnsAdCardActionBtnCtrl", paramString1);
            paramString1 = a(paramString3, paramString2, i, (View)localObject);
            if (paramString1 == null) {
              break label422;
            }
            this.EwK.fgP();
            paramString1.putExtra("sns_landing_pages_auto_download_for_action_btn", true);
            paramString1 = new com.tencent.mm.hellhoundlib.b.a().bl(paramString1);
            com.tencent.mm.hellhoundlib.a.a.a(paramString2, paramString1.axQ(), "com/tencent/mm/plugin/sns/ui/SnsAdCardActionBtnCtrl", "jumpNativeLandingPageUIForDownload", "(Lcom/tencent/mm/plugin/sns/storage/SnsInfo;Landroid/app/Activity;ILandroid/view/View;Lcom/tencent/mm/modelsns/SnsAdClick;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
            paramString2.startActivity((Intent)paramString1.pG(0));
            com.tencent.mm.hellhoundlib.a.a.a(paramString2, "com/tencent/mm/plugin/sns/ui/SnsAdCardActionBtnCtrl", "jumpNativeLandingPageUIForDownload", "(Lcom/tencent/mm/plugin/sns/storage/SnsInfo;Landroid/app/Activity;ILandroid/view/View;Lcom/tencent/mm/modelsns/SnsAdClick;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
            paramString2.overridePendingTransition(0, 0);
            break;
          }
          label422:
          a(paramString3, paramSnsAdClick, i, paramString2);
          continue;
        }
        com.tencent.mm.plugin.sns.data.k.jZ(paramString2, paramString3);
        AppMethodBeat.o(203406);
        return 36;
      }
      catch (Throwable paramString1)
      {
        for (;;)
        {
          bool1 = bool2;
        }
      }
    }
  }
  
  private static Intent a(SnsInfo paramSnsInfo, Activity paramActivity, int paramInt, View paramView)
  {
    int i = 2;
    boolean bool = true;
    AppMethodBeat.i(98301);
    if (com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.i.aQg(paramSnsInfo.getAdSnsInfo().field_adxml))
    {
      Intent localIntent = new Intent();
      int[] arrayOfInt = new int[2];
      paramView.getLocationInWindow(arrayOfInt);
      int j = paramView.getWidth();
      int k = paramView.getHeight();
      localIntent.putExtra("img_gallery_left", arrayOfInt[0]);
      localIntent.putExtra("img_gallery_top", arrayOfInt[1]);
      localIntent.putExtra("img_gallery_width", j);
      localIntent.putExtra("img_gallery_height", k);
      localIntent.putExtra("sns_landing_pages_share_sns_id", paramSnsInfo.getSnsId());
      localIntent.putExtra("sns_landing_pages_rawSnsId", paramSnsInfo.getTimeLine().Id);
      localIntent.putExtra("sns_landing_pages_ux_info", paramSnsInfo.getUxinfo());
      localIntent.setClass(paramActivity, SnsAdNativeLandingPagesUI.class);
      if (paramInt == 2)
      {
        i = 16;
        localIntent.putExtra("sns_landig_pages_from_source", i);
        localIntent.putExtra("sns_landing_pages_xml", paramSnsInfo.getAdSnsInfo().field_adxml);
        localIntent.putExtra("sns_landing_pages_rec_src", paramSnsInfo.getAdRecSrc());
        localIntent.putExtra("sns_landing_pages_xml_prefix", "adxml");
        localIntent.putExtra("sns_landing_pages_need_enter_and_exit_animation", true);
        paramSnsInfo = paramSnsInfo.getTimeLine();
        if ((paramSnsInfo.ContentObj.LoU != 15) || (paramSnsInfo.sightFolded == 1)) {
          break label284;
        }
      }
      for (;;)
      {
        localIntent.putExtra("sns_landing_is_native_sight_ad", bool);
        AppMethodBeat.o(98301);
        return localIntent;
        if (paramInt == 1) {
          break;
        }
        i = 1;
        break;
        label284:
        bool = false;
      }
    }
    Log.e("MicroMsg.SnsAdCardActionBtnCtrl", "adxml is invalid, snsId=" + r.Jb(paramSnsInfo.field_snsId));
    AppMethodBeat.o(98301);
    return null;
  }
  
  private static void a(SnsInfo paramSnsInfo, SnsAdClick paramSnsAdClick, int paramInt, Context paramContext)
  {
    AppMethodBeat.i(98299);
    String str2 = paramSnsInfo.getAdInfoLink();
    String str1 = str2;
    if (TextUtils.isEmpty(str2)) {
      str1 = paramSnsInfo.getAdLink();
    }
    if (TextUtils.isEmpty(str1))
    {
      Log.e("MicroMsg.SnsAdCardActionBtnCtrl", "jumpUpdateWebUI both url is empty");
      AppMethodBeat.o(98299);
      return;
    }
    a(str1, paramSnsInfo, paramSnsAdClick, paramInt, paramContext);
    AppMethodBeat.o(98299);
  }
  
  private static void a(String paramString, SnsInfo paramSnsInfo, SnsAdClick paramSnsAdClick, int paramInt, Context paramContext)
  {
    boolean bool2 = false;
    AppMethodBeat.i(98300);
    Log.i("MicroMsg.SnsAdCardActionBtnCtrl", "jumpWebUI, url=" + paramString + ", source=" + paramInt + ", snsInfo=" + paramSnsInfo);
    if ((TextUtils.isEmpty(paramString)) || (paramSnsInfo == null))
    {
      AppMethodBeat.o(98300);
      return;
    }
    Intent localIntent = new Intent();
    boolean bool1;
    if (paramSnsInfo.getAdXml().webrightBar == 0)
    {
      bool1 = true;
      if (!ac.jOL) {
        break label386;
      }
      bool1 = bool2;
    }
    label386:
    for (;;)
    {
      String str = paramString;
      if (paramSnsInfo != null)
      {
        str = paramString;
        if (paramSnsInfo.isAd())
        {
          ADInfo localADInfo = paramSnsInfo.getAdInfo(paramInt);
          str = paramString;
          if (localADInfo != null)
          {
            localIntent.putExtra("KsnsViewId", localADInfo.viewId);
            str = com.tencent.mm.plugin.sns.ad.d.a.a.aND(r.kb(paramString, localADInfo.uxInfo));
            r.h(localIntent, localADInfo.uxInfo);
          }
        }
      }
      localIntent.putExtra("KRightBtn", bool1);
      paramString = new Bundle();
      if (paramSnsAdClick != null) {
        paramString.putParcelable("KSnsAdTag", paramSnsAdClick);
      }
      paramString.putString("key_snsad_statextstr", paramSnsInfo.getTimeLine().statExtStr);
      localIntent.putExtra("jsapiargs", paramString);
      localIntent.putExtra("rawUrl", str);
      localIntent.putExtra("useJs", true);
      localIntent.putExtra("srcUsername", paramSnsInfo.field_userName);
      localIntent.putExtra("stastic_scene", 15);
      localIntent.putExtra("KPublisherId", "sns_" + r.Jb(paramSnsInfo.field_snsId));
      localIntent.putExtra("pre_username", paramSnsInfo.field_userName);
      localIntent.putExtra("prePublishId", "sns_" + r.Jb(paramSnsInfo.field_snsId));
      localIntent.putExtra("preUsername", paramSnsInfo.field_userName);
      com.tencent.mm.plugin.sns.c.a.jRt.i(localIntent, paramContext);
      AppMethodBeat.o(98300);
      return;
      bool1 = false;
      break;
    }
  }
  
  public final void V(SnsInfo paramSnsInfo)
  {
    AppMethodBeat.i(98297);
    if (paramSnsInfo == null)
    {
      Log.e("MicroMsg.SnsAdCardActionBtnCtrl", "refreshUI, snsInfo==null");
      AppMethodBeat.o(98297);
      return;
    }
    this.DqO = paramSnsInfo;
    this.DCW = paramSnsInfo.getAdXml().adCardActionBtnInfo;
    try
    {
      this.adExtInfo = Util.nullAsNil(paramSnsInfo.getAdXml().adExtInfo);
      this.dRS = String.valueOf(com.tencent.mm.plugin.sns.data.k.aOa(Util.nullAsNil(paramSnsInfo.getSnsId())));
      if (this.DCW != null)
      {
        System.currentTimeMillis();
        if (!TextUtils.isEmpty(paramSnsInfo.getAdXml().adCardTitle))
        {
          SpannableString localSpannableString1 = com.tencent.mm.ce.g.gxZ().a(this.EwG.getContext(), paramSnsInfo.getAdXml().adCardTitle, this.EwG.getTextSize());
          this.EwG.setText(localSpannableString1);
          this.EwG.setVisibility(0);
          this.EwG.setTypeface(Typeface.defaultFromStyle(1));
          if (!TextUtils.isEmpty(paramSnsInfo.getAdXml().adCardDesc))
          {
            localSpannableString1 = com.tencent.mm.ce.g.gxZ().a(this.EwH.getContext(), paramSnsInfo.getAdXml().adCardDesc, this.EwH.getTextSize());
            this.EwH.setText(localSpannableString1);
            this.EwH.setVisibility(0);
          }
        }
      }
    }
    catch (Throwable localThrowable1)
    {
      try
      {
        for (;;)
        {
          this.EwI.setTextColor(this.mContext.getResources().getColor(2131100053));
          this.EwI.setEnabled(true);
          if (this.DCW.clickActionType != 2) {
            break;
          }
          if (TextUtils.isEmpty(this.EwI.getText().toString())) {
            this.EwI.setText(this.DCW.btnTitle);
          }
          new c(this.EwI, this.DCW.downloadApkPkgName, this.DCW.downloadApkAppId, this.DCW.btnTitle).execute(new Void[0]);
          if (TextUtils.isEmpty(this.DCW.iconUrl)) {
            break label645;
          }
          this.EwE.setVisibility(0);
          com.tencent.mm.plugin.sns.ad.i.b.j(this.DCW.iconUrl, this.EwF);
          AppMethodBeat.o(98297);
          return;
          localThrowable1 = localThrowable1;
          Log.e("MicroMsg.SnsAdCardActionBtnCtrl", localThrowable1.toString());
          continue;
          this.EwH.setVisibility(8);
        }
        if (!TextUtils.isEmpty(paramSnsInfo.getAdXml().adCardDesc))
        {
          SpannableString localSpannableString2 = com.tencent.mm.ce.g.gxZ().a(this.EwG.getContext(), paramSnsInfo.getAdXml().adCardDesc, this.EwG.getTextSize());
          this.EwG.setText(localSpannableString2);
          this.EwG.setVisibility(0);
          this.EwG.setTypeface(Typeface.defaultFromStyle(0));
        }
        for (;;)
        {
          this.EwH.setVisibility(8);
          break;
          this.EwG.setVisibility(8);
        }
      }
      catch (Throwable localThrowable2)
      {
        for (;;)
        {
          Log.e("MicroMsg.SnsAdCardActionBtnCtrl", localThrowable2.toString());
          continue;
          if (this.DCW.clickActionType == 6)
          {
            try
            {
              paramSnsInfo = r.Jb(paramSnsInfo.field_snsId);
              if (Util.isNullOrNil(paramSnsInfo)) {
                continue;
              }
              if (!"1".equals(y.aQL(paramSnsInfo))) {
                break label579;
              }
              this.EwI.setTextColor(-7829368);
              this.EwI.setText(this.DCW.btnTitleAfterOrder);
              this.EwI.setEnabled(false);
            }
            catch (Throwable paramSnsInfo)
            {
              Log.e("MicroMsg.SnsAdCardActionBtnCtrl", paramSnsInfo.toString());
            }
            continue;
            label579:
            this.EwI.setText(this.DCW.btnTitle);
          }
          else if (this.DCW.clickActionType == 7)
          {
            h.RTc.aX(new Runnable()
            {
              public final void run()
              {
                AppMethodBeat.i(203403);
                if ((av.a(av.this) != null) && (!Util.isNullOrNil(av.b(av.this).brandUsername)))
                {
                  av.a(av.this, av.a(av.this).Kn(av.b(av.this).brandUsername));
                  MMHandlerThread.postToMainThread(new Runnable()
                  {
                    public final void run()
                    {
                      AppMethodBeat.i(203402);
                      if ((av.c(av.this) != null) && (com.tencent.mm.contact.c.oR(av.c(av.this).field_type)))
                      {
                        av.d(av.this).setText(av.b(av.this).btnTitleAfterAddBrand);
                        AppMethodBeat.o(203402);
                        return;
                      }
                      av.d(av.this).setText(av.b(av.this).btnTitle);
                      AppMethodBeat.o(203402);
                    }
                  });
                }
                AppMethodBeat.o(203403);
              }
            });
          }
          else
          {
            this.EwI.setText(this.DCW.btnTitle);
          }
        }
        label645:
        this.EwE.setVisibility(8);
      }
      AppMethodBeat.o(98297);
    }
  }
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(98298);
    localObject1 = new com.tencent.mm.hellhoundlib.b.b();
    ((com.tencent.mm.hellhoundlib.b.b)localObject1).bm(paramView);
    com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/sns/ui/SnsAdCardActionBtnCtrl", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject1).axR());
    if (this.DCW == null)
    {
      Log.e("MicroMsg.SnsAdCardActionBtnCtrl", "onClick mActionBtnInfo==null");
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/sns/ui/SnsAdCardActionBtnCtrl", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(98298);
      return;
    }
    for (;;)
    {
      try
      {
        int j = this.DxM;
        if (this.DxM == 0)
        {
          i = 1;
          localSnsAdClick = new SnsAdClick(j, i, this.DqO.field_snsId, 26, 0);
          com.tencent.mm.plugin.sns.data.k.a(localSnsAdClick, this.DzW, this.DqO, 26);
        }
      }
      catch (Exception paramView)
      {
        int i;
        final SnsAdClick localSnsAdClick;
        Log.e("MicroMsg.SnsAdCardActionBtnCtrl", "onClick report exp=" + paramView.toString());
        continue;
        long l1 = ((SnsInfo)localObject1).field_snsId;
        continue;
        a(this.DqO, localSnsAdClick, this.DxM, this.mContext);
        continue;
        localSnsAdClick.jkV = 0;
        a(this.DCW.clickActionLink, this.DqO, localSnsAdClick, this.DxM, this.mContext);
        continue;
        localSnsAdClick.jkV = 31;
        com.tencent.mm.plugin.sns.ui.d.c.a(this.DCW.weappUserName, this.DCW.weappPath, this.DCW.weappVersion, this.DqO, this.DxM);
        try
        {
          com.tencent.mm.plugin.sns.ad.timeline.dynamic.a.eXI().a(this.DxM, this.DqO);
        }
        catch (Throwable paramView) {}
        continue;
        localSnsAdClick.jkV = a(this.DCW.downloadApkAppId, this.DCW.downloadApkPkgName, this.DCW.appPageUrl, localSnsAdClick);
        continue;
        localSnsAdClick.jkV = 32;
        a(this.DCW.clickActionLink, this.DqO, localSnsAdClick, this.DxM, this.mContext);
        continue;
        localSnsAdClick.jkV = 11;
        Object localObject2 = this.DqO.getAdInfo();
        localObject1 = "";
        paramView = (View)localObject1;
        if (localObject2 == null) {
          continue;
        }
        paramView = (View)localObject1;
        if (((ADInfo)localObject2).mappedCanvasCardExt == null) {
          continue;
        }
        paramView = (String)((ADInfo)localObject2).mappedCanvasCardExt.get(this.DCW.cardTpId);
        if (!TextUtils.isEmpty(paramView)) {
          continue;
        }
        Log.e("MicroMsg.SnsAdCardActionBtnCtrl", "cardExt is not found in adInfo, tpid=" + this.DCW.cardTpId);
        paramView = this.DCW.cardExt;
        localObject1 = (Activity)this.mContext;
        localObject2 = this.DCW.cardTpId;
        Log.i("MicroMsg.SnsAdCardActionBtnCtrl", "jumpCardDetail, cardTpId=" + (String)localObject2 + ", cardExt=" + paramView);
        Object localObject3 = new Intent();
        ((Intent)localObject3).putExtra("key_card_id", (String)localObject2);
        ((Intent)localObject3).putExtra("key_card_ext", paramView);
        ((Intent)localObject3).putExtra("key_from_scene", 21);
        ((Intent)localObject3).putExtra("key_stastic_scene", 15);
        com.tencent.mm.br.c.b((Context)localObject1, "card", ".ui.CardDetailUI", (Intent)localObject3);
        continue;
        localSnsAdClick.jkV = 33;
        try
        {
          l1 = this.DCW.subscribeExpiredTime;
          long l2 = cl.aWy() / 1000L;
          if ((l1 > 0L) && (l2 > l1)) {
            continue;
          }
          MMHandlerThread.postToMainThread(new Runnable()
          {
            public final void run()
            {
              AppMethodBeat.i(203404);
              try
              {
                if (this.val$context != null)
                {
                  e locale = new e(this.val$context, true, 0);
                  com.tencent.mm.plugin.sns.e.b localb = new com.tencent.mm.plugin.sns.e.b();
                  Context localContext = this.val$context;
                  ADXml.AdCardActionBtnInfo localAdCardActionBtnInfo = this.DDk;
                  SnsInfo localSnsInfo = this.DxI;
                  int i = this.psA;
                  av.a locala = av.e(av.this);
                  Object localObject = av.a(av.this);
                  String str1 = localAdCardActionBtnInfo.weappUserName;
                  String str2 = localAdCardActionBtnInfo.tempId;
                  localObject = com.tencent.mm.plugin.sns.e.b.a(localContext, localAdCardActionBtnInfo, localSnsInfo, (bv)localObject);
                  WeImageView localWeImageView = (WeImageView)((View)localObject).findViewById(2131298763);
                  Button localButton = (Button)((View)localObject).findViewById(2131308733);
                  localb.DDe = false;
                  locale.PGl = new b.1(localb, str2, str1, localSnsInfo, i);
                  localWeImageView.setOnClickListener(new b.2(localb, locale));
                  localb.oXS = locale;
                  localb.mContext = localContext;
                  localButton.setOnClickListener(new b.3(localb, localSnsInfo, localAdCardActionBtnInfo, new b.a(localb, localAdCardActionBtnInfo, localSnsInfo, i, locala), localContext));
                  locale.V((View)localObject, true);
                  locale.Dm(true);
                  locale.dGm();
                }
                AppMethodBeat.o(203404);
                return;
              }
              catch (Throwable localThrowable)
              {
                Log.e("MicroMsg.SnsAdCardActionBtnCtrl", localThrowable.toString());
                AppMethodBeat.o(203404);
              }
            }
          });
        }
        catch (Throwable paramView)
        {
          Log.e("MicroMsg.SnsAdCardActionBtnCtrl", paramView.toString());
        }
        continue;
        u.cH(this.mContext, this.DCW.subscribeExpiredTip);
        continue;
        try
        {
          if ((this.rjX == null) || (!com.tencent.mm.contact.c.oR(this.rjX.field_type))) {
            continue;
          }
          localSnsAdClick.jkV = 39;
          MMHandlerThread.postToMainThread(new Runnable()
          {
            public final void run()
            {
              AppMethodBeat.i(203405);
              Object localObject1;
              Object localObject2;
              try
              {
                if ((this.mHP == null) || (this.EwO == null) || (this.DDg == null))
                {
                  Log.e("MicroMsg.SnsAdCardActionBtnCtrl", "mContext or mActionBtnInfo or mSnsInfo is null");
                  AppMethodBeat.o(203405);
                  return;
                }
                if ((av.c(av.this) == null) || (!com.tencent.mm.contact.c.oR(av.c(av.this).field_type))) {
                  break label214;
                }
                Context localContext = this.mHP;
                localObject3 = this.DDg;
                localObject1 = localSnsAdClick;
                i = this.DDh;
                localObject2 = this.EwO;
                if ((localContext == null) || (localObject3 == null) || (localObject2 == null) || (Util.isNullOrNil(((ADXml.AdCardActionBtnInfo)localObject2).brandUsername)))
                {
                  AppMethodBeat.o(203405);
                  return;
                }
              }
              catch (Throwable localThrowable)
              {
                Log.e("MicroMsg.SnsAdCardActionBtnCtrl", localThrowable.toString());
                AppMethodBeat.o(203405);
                return;
              }
              Object localObject3 = new Intent();
              ((Intent)localObject3).putExtra("Contact_User", ((ADXml.AdCardActionBtnInfo)localObject2).brandUsername);
              ((Intent)localObject3).putExtra("KSnsAdTag", (Parcelable)localObject1);
              ((Intent)localObject3).putExtra("Contact_Scene", 181);
              if (i == 0) {}
              for (int i = 6;; i = 1)
              {
                ((Intent)localObject3).putExtra("CONTACT_INFO_UI_SOURCE", i);
                com.tencent.mm.plugin.sns.c.a.jRt.c((Intent)localObject3, localThrowable);
                AppMethodBeat.o(203405);
                return;
                label214:
                com.tencent.mm.plugin.sns.e.a locala = new com.tencent.mm.plugin.sns.e.a();
                localObject2 = this.mHP;
                localObject3 = this.DDg;
                localObject1 = this.EwO;
                i = this.DDh;
                bv localbv = av.a(av.this);
                as localas = av.c(av.this);
                av.a locala1 = av.e(av.this);
                locala.DCW = ((ADXml.AdCardActionBtnInfo)localObject1);
                locala.mContext = ((Context)localObject2);
                locala.DxM = i;
                locala.iFD = localbv;
                locala.rjX = localas;
                locala.DCV = locala1;
                locala.dRS = String.valueOf(com.tencent.mm.plugin.sns.data.k.aOa(((SnsInfo)localObject3).getSnsId()));
                locala.uxInfo = ((SnsInfo)localObject3).getUxinfo();
                locala.adExtInfo = ((SnsInfo)localObject3).getAdXml().adExtInfo;
                localObject2 = new com.tencent.mm.plugin.sns.data.d();
                if (localObject1 == null) {}
                for (;;)
                {
                  locala.DCX = ((com.tencent.mm.plugin.sns.data.d)localObject2);
                  locala.eZo();
                  AppMethodBeat.o(203405);
                  return;
                  ((com.tencent.mm.plugin.sns.data.d)localObject2).brandUsername = Util.nullAs(((ADXml.AdCardActionBtnInfo)localObject1).brandUsername, "");
                  ((com.tencent.mm.plugin.sns.data.d)localObject2).brandHead = Util.nullAs(((ADXml.AdCardActionBtnInfo)localObject1).brandHead, "");
                  ((com.tencent.mm.plugin.sns.data.d)localObject2).brandName = Util.nullAs(((ADXml.AdCardActionBtnInfo)localObject1).brandName, "");
                  ((com.tencent.mm.plugin.sns.data.d)localObject2).brandDesc = Util.nullAs(((ADXml.AdCardActionBtnInfo)localObject1).brandDesc, "");
                  ((com.tencent.mm.plugin.sns.data.d)localObject2).btnTitleAfterAddBrand = Util.nullAs(((ADXml.AdCardActionBtnInfo)localObject1).btnTitleAfterAddBrand, "");
                }
              }
            }
          });
        }
        catch (Throwable paramView)
        {
          Log.e("MicroMsg.SnsAdCardActionBtnCtrl", paramView.toString());
        }
        continue;
        localSnsAdClick.jkV = 38;
        continue;
        continue;
        continue;
      }
      try
      {
        Log.i("MicroMsg.SnsAdCardActionBtnCtrl", "onClick, type=" + this.DCW.clickActionType + ", snsId=" + r.Jb(this.DqO.field_snsId));
        switch (this.DCW.clickActionType)
        {
        case 3: 
          localObject1 = com.tencent.mm.plugin.sns.ad.timeline.a.a.d(3, this.mContext);
          if (localObject1 != null) {
            ((com.tencent.mm.plugin.sns.ad.timeline.a.c)localObject1).a(paramView, this.DxM, this.DqO, new com.tencent.mm.plugin.sns.ad.timeline.a.d("snsAdClick", localSnsAdClick));
          }
          Log.i("MicroMsg.SnsAdCardActionBtnCtrl", "clickAction=" + localSnsAdClick.jkV);
        }
      }
      catch (Exception paramView)
      {
        Log.e("MicroMsg.SnsAdCardActionBtnCtrl", "onClick exp=" + paramView.toString());
        continue;
      }
      r.a(localSnsAdClick);
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/sns/ui/SnsAdCardActionBtnCtrl", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(98298);
      return;
      i = 2;
      continue;
      localSnsAdClick.jkV = 21;
      localObject1 = this.DqO;
      paramView = (Activity)this.mContext;
      i = this.DxM;
      localObject2 = this.EwJ;
      localObject3 = new StringBuilder("jumpNativeLandingPageUI, snsId=");
      if (localObject1 != null) {
        continue;
      }
      l1 = 0L;
      Log.i("MicroMsg.SnsAdCardActionBtnCtrl", l1);
      localObject1 = a((SnsInfo)localObject1, paramView, i, (View)localObject2);
      if (localObject1 == null) {
        continue;
      }
      this.EwK.fgP();
      localObject1 = new com.tencent.mm.hellhoundlib.b.a().bl(localObject1);
      com.tencent.mm.hellhoundlib.a.a.a(paramView, ((com.tencent.mm.hellhoundlib.b.a)localObject1).axQ(), "com/tencent/mm/plugin/sns/ui/SnsAdCardActionBtnCtrl", "jumpNativeLandingPageUI", "(Lcom/tencent/mm/plugin/sns/storage/SnsInfo;Landroid/app/Activity;ILandroid/view/View;Lcom/tencent/mm/modelsns/SnsAdClick;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      paramView.startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject1).pG(0));
      com.tencent.mm.hellhoundlib.a.a.a(paramView, "com/tencent/mm/plugin/sns/ui/SnsAdCardActionBtnCtrl", "jumpNativeLandingPageUI", "(Lcom/tencent/mm/plugin/sns/storage/SnsInfo;Landroid/app/Activity;ILandroid/view/View;Lcom/tencent/mm/modelsns/SnsAdClick;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      paramView.overridePendingTransition(0, 0);
    }
  }
  
  public static abstract interface a
  {
    public abstract void a(ADXml.AdCardActionBtnInfo paramAdCardActionBtnInfo);
  }
  
  public static abstract interface b
  {
    public abstract void fgP();
  }
  
  public static final class c
    extends AsyncTask<Void, Void, Integer>
  {
    Button Edp;
    String EwQ;
    String LG;
    String dNI;
    
    public c(Button paramButton, String paramString1, String paramString2, String paramString3)
    {
      this.LG = paramString1;
      this.dNI = paramString2;
      this.Edp = paramButton;
      this.EwQ = paramString3;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.av
 * JD-Core Version:    0.7.0.1
 */