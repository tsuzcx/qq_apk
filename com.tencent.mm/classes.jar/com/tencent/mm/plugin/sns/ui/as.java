package com.tencent.mm.plugin.sns.ui;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Typeface;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bs.d;
import com.tencent.mm.modelsns.SnsAdClick;
import com.tencent.mm.platformtools.ac;
import com.tencent.mm.plugin.messenger.foundation.a.l;
import com.tencent.mm.plugin.sns.data.j;
import com.tencent.mm.plugin.sns.data.q;
import com.tencent.mm.plugin.sns.e.a.1;
import com.tencent.mm.plugin.sns.e.a.2;
import com.tencent.mm.plugin.sns.e.a.3;
import com.tencent.mm.plugin.sns.e.a.a;
import com.tencent.mm.plugin.sns.model.AdLandingPagesProxy;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.a.e;
import com.tencent.mm.plugin.sns.storage.b.b;
import com.tencent.mm.plugin.sns.storage.p;
import com.tencent.mm.plugin.sns.storage.x;
import com.tencent.mm.plugin.sns.ui.d.c;
import com.tencent.mm.pluginsdk.m;
import com.tencent.mm.protocal.protobuf.TimeLineObject;
import com.tencent.mm.protocal.protobuf.abf;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.sdk.platformtools.aq;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.storage.bp;
import com.tencent.mm.ui.widget.RoundedCornerFrameLayout;
import com.tencent.mm.ui.widget.imageview.WeImageView;
import java.util.HashMap;

public final class as
  implements View.OnClickListener
{
  private String dFy;
  private String dzb;
  private bp hHX;
  private View mContentView;
  private Context mContext;
  private p yVM;
  private RoundedCornerFrameLayout zWK;
  private ImageView zWL;
  private TextView zWM;
  private TextView zWN;
  private Button zWO;
  private View zWP;
  private b.b zWQ;
  private b zWR;
  private a zWS;
  public com.tencent.mm.plugin.sns.ad.d.i zbv;
  private int zcm;
  private String zeg;
  
  public as(Context paramContext, View paramView, int paramInt, com.tencent.mm.plugin.sns.ad.d.i parami, b paramb)
  {
    AppMethodBeat.i(98296);
    this.zeg = "";
    this.dFy = "";
    this.dzb = "";
    this.zWS = new a()
    {
      public final void a(b.b paramAnonymousb)
      {
        AppMethodBeat.i(198261);
        if ((as.a(as.this) != null) && (paramAnonymousb != null) && (!bt.isNullOrNil(paramAnonymousb.zwO)))
        {
          as.a(as.this).setTextColor(-7829368);
          as.a(as.this).setText(paramAnonymousb.zwO);
          as.a(as.this).setEnabled(false);
        }
        AppMethodBeat.o(198261);
      }
    };
    ad.d("MicroMsg.SnsAdCardActionBtnCtrl", "init, source=" + paramInt + ", context=" + paramContext + ", static=" + parami);
    this.mContext = paramContext;
    this.zcm = paramInt;
    this.zbv = parami;
    this.zWR = paramb;
    this.mContentView = paramView;
    this.zWP = this.mContentView.findViewById(2131302206);
    this.zWK = ((RoundedCornerFrameLayout)paramView.findViewById(2131307266));
    this.zWL = ((ImageView)paramView.findViewById(2131307265));
    this.zWM = ((TextView)paramView.findViewById(2131296391));
    this.zWN = ((TextView)paramView.findViewById(2131296361));
    this.zWO = ((Button)paramView.findViewById(2131296354));
    this.zWO.setOnClickListener(this);
    this.zWK.setRadius(com.tencent.mm.cc.a.fromDPToPix(this.mContext, 4));
    this.hHX = ((l)com.tencent.mm.kernel.g.ab(l.class)).azp();
    AppMethodBeat.o(98296);
  }
  
  private int a(String paramString1, String paramString2, String paramString3, SnsAdClick paramSnsAdClick)
  {
    AppMethodBeat.i(198263);
    ad.i("MicroMsg.SnsAdCardActionBtnCtrl", "handleDownload, appPageUrl=" + paramString3 + ", pkg=" + paramString2 + ", appId=" + paramString1);
    Object localObject = a.e.zxS;
    if (com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.a.bg(aj.getContext(), paramString2))
    {
      ad.i("MicroMsg.SnsAdCardActionBtnCtrl", "isPkgInstalled==true");
      if (this.yVM != null)
      {
        paramSnsAdClick = this.yVM.QO(this.zcm);
        if (paramSnsAdClick != null) {
          this.dFy = bt.nullAsNil(paramSnsAdClick.dFy);
        }
      }
      j.a(this.mContext, paramString1, paramString2, "", paramString3, this.dFy, this.zeg, this.dzb, 0, 0);
      if (!TextUtils.isEmpty(paramString3))
      {
        AppMethodBeat.o(198263);
        return 34;
      }
    }
    else
    {
      localObject = a.e.zxS;
      if (!com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.a.isApkExist(paramString1)) {
        break label194;
      }
      ad.i("MicroMsg.SnsAdCardActionBtnCtrl", "isApkExist==true");
      j.jg(paramString2, paramString3);
      AdLandingPagesProxy.getInstance().installApp(this.mContext, paramString1, paramString2, "", "");
    }
    for (;;)
    {
      AppMethodBeat.o(198263);
      return 21;
      label194:
      boolean bool2 = false;
      boolean bool1 = bool2;
      if (this.yVM != null) {}
      try
      {
        paramString1 = this.yVM.QO(this.zcm);
        bool1 = j.b(this.mContext, this.yVM, paramString1);
        if (!bool1)
        {
          paramString3 = this.yVM;
          paramString2 = (Activity)this.mContext;
          int i = this.zcm;
          localObject = this.zWP;
          StringBuilder localStringBuilder = new StringBuilder("jumpNativeLandingPageUIForDownload, snsId=");
          if (paramString3 == null) {}
          for (paramString1 = "";; paramString1 = q.zw(paramString3.field_snsId))
          {
            ad.i("MicroMsg.SnsAdCardActionBtnCtrl", paramString1);
            paramString1 = a(paramString3, paramString2, i, (View)localObject);
            if (paramString1 == null) {
              break label421;
            }
            this.zWR.eaS();
            paramString1.putExtra("sns_landing_pages_auto_download_for_action_btn", true);
            paramString1 = new com.tencent.mm.hellhoundlib.b.a().bc(paramString1);
            com.tencent.mm.hellhoundlib.a.a.a(paramString2, paramString1.ahp(), "com/tencent/mm/plugin/sns/ui/SnsAdCardActionBtnCtrl", "jumpNativeLandingPageUIForDownload", "(Lcom/tencent/mm/plugin/sns/storage/SnsInfo;Landroid/app/Activity;ILandroid/view/View;Lcom/tencent/mm/modelsns/SnsAdClick;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
            paramString2.startActivity((Intent)paramString1.mq(0));
            com.tencent.mm.hellhoundlib.a.a.a(paramString2, "com/tencent/mm/plugin/sns/ui/SnsAdCardActionBtnCtrl", "jumpNativeLandingPageUIForDownload", "(Lcom/tencent/mm/plugin/sns/storage/SnsInfo;Landroid/app/Activity;ILandroid/view/View;Lcom/tencent/mm/modelsns/SnsAdClick;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
            paramString2.overridePendingTransition(0, 0);
            break;
          }
          label421:
          a(paramString3, paramSnsAdClick, i, paramString2);
          continue;
        }
        j.jg(paramString2, paramString3);
        AppMethodBeat.o(198263);
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
  
  private static Intent a(p paramp, Activity paramActivity, int paramInt, View paramView)
  {
    int i = 2;
    boolean bool = true;
    AppMethodBeat.i(98301);
    if (com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.i.azV(paramp.dYU().field_adxml))
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
      localIntent.putExtra("sns_landing_pages_share_sns_id", paramp.getSnsId());
      localIntent.putExtra("sns_landing_pages_rawSnsId", paramp.dYl().Id);
      localIntent.putExtra("sns_landing_pages_ux_info", paramp.dYT());
      localIntent.setClass(paramActivity, SnsAdNativeLandingPagesUI.class);
      if (paramInt == 2)
      {
        i = 16;
        localIntent.putExtra("sns_landig_pages_from_source", i);
        localIntent.putExtra("sns_landing_pages_xml", paramp.dYU().field_adxml);
        localIntent.putExtra("sns_landing_pages_rec_src", paramp.dYV());
        localIntent.putExtra("sns_landing_pages_xml_prefix", "adxml");
        localIntent.putExtra("sns_landing_pages_need_enter_and_exit_animation", true);
        paramp = paramp.dYl();
        if ((paramp.HAT.GaP != 15) || (paramp.HBa == 1)) {
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
    ad.e("MicroMsg.SnsAdCardActionBtnCtrl", "adxml is invalid, snsId=" + q.zw(paramp.field_snsId));
    AppMethodBeat.o(98301);
    return null;
  }
  
  private static void a(p paramp, SnsAdClick paramSnsAdClick, int paramInt, Context paramContext)
  {
    AppMethodBeat.i(98299);
    String str2 = paramp.dYS();
    String str1 = str2;
    if (TextUtils.isEmpty(str2)) {
      str1 = paramp.dYR();
    }
    if (TextUtils.isEmpty(str1))
    {
      ad.e("MicroMsg.SnsAdCardActionBtnCtrl", "jumpUpdateWebUI both url is empty");
      AppMethodBeat.o(98299);
      return;
    }
    a(str1, paramp, paramSnsAdClick, paramInt, paramContext);
    AppMethodBeat.o(98299);
  }
  
  private static void a(String paramString, p paramp, SnsAdClick paramSnsAdClick, int paramInt, Context paramContext)
  {
    boolean bool2 = false;
    AppMethodBeat.i(98300);
    ad.i("MicroMsg.SnsAdCardActionBtnCtrl", "jumpWebUI, url=" + paramString + ", source=" + paramInt + ", snsInfo=" + paramp);
    if ((TextUtils.isEmpty(paramString)) || (paramp == null))
    {
      AppMethodBeat.o(98300);
      return;
    }
    Intent localIntent = new Intent();
    boolean bool1;
    if (paramp.dRL().zvx == 0)
    {
      bool1 = true;
      if (!ac.iOW) {
        break label385;
      }
      bool1 = bool2;
    }
    label385:
    for (;;)
    {
      String str = paramString;
      if (paramp != null)
      {
        str = paramString;
        if (paramp.QM(32))
        {
          com.tencent.mm.plugin.sns.storage.a locala = paramp.QO(paramInt);
          str = paramString;
          if (locala != null)
          {
            localIntent.putExtra("KsnsViewId", locala.aQj);
            str = q.jh(paramString, locala.dFy);
            q.g(localIntent, locala.dFy);
          }
        }
      }
      localIntent.putExtra("KRightBtn", bool1);
      paramString = new Bundle();
      if (paramSnsAdClick != null) {
        paramString.putParcelable("KSnsAdTag", paramSnsAdClick);
      }
      paramString.putString("key_snsad_statextstr", paramp.dYl().zRz);
      localIntent.putExtra("jsapiargs", paramString);
      localIntent.putExtra("rawUrl", str);
      localIntent.putExtra("useJs", true);
      localIntent.putExtra("srcUsername", paramp.field_userName);
      localIntent.putExtra("stastic_scene", 15);
      localIntent.putExtra("KPublisherId", "sns_" + q.zw(paramp.field_snsId));
      localIntent.putExtra("pre_username", paramp.field_userName);
      localIntent.putExtra("prePublishId", "sns_" + q.zw(paramp.field_snsId));
      localIntent.putExtra("preUsername", paramp.field_userName);
      com.tencent.mm.plugin.sns.c.a.iRG.i(localIntent, paramContext);
      AppMethodBeat.o(98300);
      return;
      bool1 = false;
      break;
    }
  }
  
  public final void P(p paramp)
  {
    AppMethodBeat.i(98297);
    if (paramp == null)
    {
      ad.e("MicroMsg.SnsAdCardActionBtnCtrl", "refreshUI, snsInfo==null");
      AppMethodBeat.o(98297);
      return;
    }
    this.yVM = paramp;
    this.zWQ = paramp.dRL().zcl;
    try
    {
      this.zeg = bt.nullAsNil(paramp.dRL().zeg);
      this.dzb = String.valueOf(j.axN(bt.nullAsNil(paramp.getSnsId())));
      if (this.zWQ != null)
      {
        System.currentTimeMillis();
        if (!TextUtils.isEmpty(paramp.dRL().zwj))
        {
          Object localObject1 = com.tencent.mm.cf.g.fng();
          this.zWM.getContext();
          localObject1 = ((com.tencent.mm.cf.g)localObject1).b(paramp.dRL().zwj, this.zWM.getTextSize());
          this.zWM.setText((CharSequence)localObject1);
          this.zWM.setVisibility(0);
          this.zWM.setTypeface(Typeface.defaultFromStyle(1));
          if (!TextUtils.isEmpty(paramp.dRL().zwk))
          {
            localObject1 = com.tencent.mm.cf.g.fng();
            this.zWN.getContext();
            localObject1 = ((com.tencent.mm.cf.g)localObject1).b(paramp.dRL().zwk, this.zWN.getTextSize());
            this.zWN.setText((CharSequence)localObject1);
            this.zWN.setVisibility(0);
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
          this.zWO.setTextColor(this.mContext.getResources().getColor(2131100027));
          this.zWO.setEnabled(true);
          if (this.zWQ.zwL != 2) {
            break;
          }
          if (TextUtils.isEmpty(this.zWO.getText().toString())) {
            this.zWO.setText(this.zWQ.zwK);
          }
          new as.c(this.zWO, this.zWQ.zwY, this.zWQ.zwX, this.zWQ.zwK).execute(new Void[0]);
          if (TextUtils.isEmpty(this.zWQ.iconUrl)) {
            break label622;
          }
          this.zWK.setVisibility(0);
          com.tencent.mm.plugin.sns.ad.e.a.i(this.zWQ.iconUrl, this.zWL);
          AppMethodBeat.o(98297);
          return;
          localThrowable1 = localThrowable1;
          ad.e("MicroMsg.SnsAdCardActionBtnCtrl", localThrowable1.toString());
          continue;
          this.zWN.setVisibility(8);
        }
        if (!TextUtils.isEmpty(paramp.dRL().zwk))
        {
          Object localObject2 = com.tencent.mm.cf.g.fng();
          this.zWM.getContext();
          localObject2 = ((com.tencent.mm.cf.g)localObject2).b(paramp.dRL().zwk, this.zWM.getTextSize());
          this.zWM.setText((CharSequence)localObject2);
          this.zWM.setVisibility(0);
          this.zWM.setTypeface(Typeface.defaultFromStyle(0));
        }
        for (;;)
        {
          this.zWN.setVisibility(8);
          break;
          this.zWM.setVisibility(8);
        }
      }
      catch (Throwable localThrowable2)
      {
        for (;;)
        {
          ad.e("MicroMsg.SnsAdCardActionBtnCtrl", localThrowable2.toString());
          continue;
          if (this.zWQ.zwL == 6)
          {
            try
            {
              paramp = q.zw(paramp.field_snsId);
              if (bt.isNullOrNil(paramp)) {
                continue;
              }
              if (!"1".equals(x.aAz(paramp))) {
                break label588;
              }
              this.zWO.setTextColor(-7829368);
              this.zWO.setText(this.zWQ.zwO);
              this.zWO.setEnabled(false);
            }
            catch (Throwable paramp)
            {
              ad.e("MicroMsg.SnsAdCardActionBtnCtrl", paramp.toString());
            }
            continue;
            label588:
            this.zWO.setText(this.zWQ.zwK);
          }
          else
          {
            this.zWO.setText(this.zWQ.zwK);
          }
        }
        label622:
        this.zWK.setVisibility(8);
      }
      AppMethodBeat.o(98297);
    }
  }
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(98298);
    localObject1 = new com.tencent.mm.hellhoundlib.b.b();
    ((com.tencent.mm.hellhoundlib.b.b)localObject1).bd(paramView);
    com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/sns/ui/SnsAdCardActionBtnCtrl", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject1).ahq());
    if (this.zWQ == null)
    {
      ad.e("MicroMsg.SnsAdCardActionBtnCtrl", "onClick mActionBtnInfo==null");
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/sns/ui/SnsAdCardActionBtnCtrl", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(98298);
      return;
    }
    for (;;)
    {
      try
      {
        int j = this.zcm;
        if (this.zcm == 0)
        {
          i = 1;
          localSnsAdClick = new SnsAdClick(j, i, this.yVM.field_snsId, 26, 0);
          j.a(localSnsAdClick, this.zbv, this.yVM, 26);
        }
      }
      catch (Exception paramView)
      {
        int i;
        SnsAdClick localSnsAdClick;
        ad.e("MicroMsg.SnsAdCardActionBtnCtrl", "onClick report exp=" + paramView.toString());
        continue;
        long l = ((p)localObject1).field_snsId;
        continue;
        a(this.yVM, localSnsAdClick, this.zcm, this.mContext);
        continue;
        localSnsAdClick.imU = 0;
        a(this.zWQ.zwM, this.yVM, localSnsAdClick, this.zcm, this.mContext);
        continue;
        localSnsAdClick.imU = 31;
        c.a(this.zWQ.pLS, this.zWQ.hDs, this.zWQ.hDt, this.yVM, this.zcm);
        continue;
        localSnsAdClick.imU = a(this.zWQ.zwX, this.zWQ.zwY, this.zWQ.zve, localSnsAdClick);
        continue;
        localSnsAdClick.imU = 32;
        a(this.zWQ.zwM, this.yVM, localSnsAdClick, this.zcm, this.mContext);
        continue;
        localSnsAdClick.imU = 11;
        Object localObject2 = this.yVM.dRK();
        localObject1 = "";
        paramView = (View)localObject1;
        if (localObject2 == null) {
          continue;
        }
        paramView = (View)localObject1;
        if (((com.tencent.mm.plugin.sns.storage.a)localObject2).zuR == null) {
          continue;
        }
        paramView = (String)((com.tencent.mm.plugin.sns.storage.a)localObject2).zuR.get(this.zWQ.oyC);
        if (!TextUtils.isEmpty(paramView)) {
          continue;
        }
        ad.e("MicroMsg.SnsAdCardActionBtnCtrl", "cardExt is not found in adInfo, tpid=" + this.zWQ.oyC);
        paramView = this.zWQ.ozz;
        localObject1 = (Activity)this.mContext;
        localObject2 = this.zWQ.oyC;
        ad.i("MicroMsg.SnsAdCardActionBtnCtrl", "jumpCardDetail, cardTpId=" + (String)localObject2 + ", cardExt=" + paramView);
        Object localObject3 = new Intent();
        ((Intent)localObject3).putExtra("key_card_id", (String)localObject2);
        ((Intent)localObject3).putExtra("key_card_ext", paramView);
        ((Intent)localObject3).putExtra("key_from_scene", 21);
        ((Intent)localObject3).putExtra("key_stastic_scene", 15);
        d.b((Context)localObject1, "card", ".ui.CardDetailUI", (Intent)localObject3);
        continue;
        localSnsAdClick.imU = 33;
        try
        {
          aq.f(new Runnable()
          {
            public final void run()
            {
              AppMethodBeat.i(198262);
              try
              {
                if (this.val$context != null)
                {
                  com.tencent.mm.ui.widget.a.e locale = new com.tencent.mm.ui.widget.a.e(this.val$context, true, 0);
                  com.tencent.mm.plugin.sns.e.a locala = new com.tencent.mm.plugin.sns.e.a();
                  Context localContext = this.val$context;
                  b.b localb = this.zch;
                  p localp = this.zPy;
                  int i = this.obr;
                  as.a locala1 = as.b(as.this);
                  Object localObject = as.c(as.this);
                  String str1 = localb.pLS;
                  String str2 = localb.zwN;
                  localObject = com.tencent.mm.plugin.sns.e.a.a(localContext, localb, localp, (bp)localObject);
                  WeImageView localWeImageView = (WeImageView)((View)localObject).findViewById(2131298360);
                  Button localButton = (Button)((View)localObject).findViewById(2131305516);
                  locala.zcb = false;
                  locale.JXC = new a.1(locala, str2, str1, localp, i);
                  localWeImageView.setOnClickListener(new a.2(locala, locale));
                  locala.nHu = locale;
                  locala.mContext = localContext;
                  localButton.setOnClickListener(new a.3(locala, localp, localb, new a.a(locala, localb, localp, i, locala1), localContext));
                  locale.K((View)localObject, true);
                  locale.fMc();
                  locale.cMW();
                }
                AppMethodBeat.o(198262);
                return;
              }
              catch (Throwable localThrowable)
              {
                ad.e("MicroMsg.SnsAdCardActionBtnCtrl", localThrowable.toString());
                AppMethodBeat.o(198262);
              }
            }
          });
        }
        catch (Throwable paramView)
        {
          ad.e("MicroMsg.SnsAdCardActionBtnCtrl", paramView.toString());
        }
        continue;
        continue;
        continue;
      }
      try
      {
        ad.i("MicroMsg.SnsAdCardActionBtnCtrl", "onClick, type=" + this.zWQ.zwL + ", snsId=" + q.zw(this.yVM.field_snsId));
        switch (this.zWQ.zwL)
        {
        case 3: 
          ad.i("MicroMsg.SnsAdCardActionBtnCtrl", "clickAction=" + localSnsAdClick.imU);
        }
      }
      catch (Exception paramView)
      {
        ad.e("MicroMsg.SnsAdCardActionBtnCtrl", "onClick exp=" + paramView.toString());
        continue;
      }
      q.a(localSnsAdClick);
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/sns/ui/SnsAdCardActionBtnCtrl", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(98298);
      return;
      i = 2;
      continue;
      localSnsAdClick.imU = 21;
      localObject1 = this.yVM;
      paramView = (Activity)this.mContext;
      i = this.zcm;
      localObject2 = this.zWP;
      localObject3 = new StringBuilder("jumpNativeLandingPageUI, snsId=");
      if (localObject1 != null) {
        continue;
      }
      l = 0L;
      ad.i("MicroMsg.SnsAdCardActionBtnCtrl", l);
      localObject1 = a((p)localObject1, paramView, i, (View)localObject2);
      if (localObject1 == null) {
        continue;
      }
      this.zWR.eaS();
      localObject1 = new com.tencent.mm.hellhoundlib.b.a().bc(localObject1);
      com.tencent.mm.hellhoundlib.a.a.a(paramView, ((com.tencent.mm.hellhoundlib.b.a)localObject1).ahp(), "com/tencent/mm/plugin/sns/ui/SnsAdCardActionBtnCtrl", "jumpNativeLandingPageUI", "(Lcom/tencent/mm/plugin/sns/storage/SnsInfo;Landroid/app/Activity;ILandroid/view/View;Lcom/tencent/mm/modelsns/SnsAdClick;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      paramView.startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject1).mq(0));
      com.tencent.mm.hellhoundlib.a.a.a(paramView, "com/tencent/mm/plugin/sns/ui/SnsAdCardActionBtnCtrl", "jumpNativeLandingPageUI", "(Lcom/tencent/mm/plugin/sns/storage/SnsInfo;Landroid/app/Activity;ILandroid/view/View;Lcom/tencent/mm/modelsns/SnsAdClick;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      paramView.overridePendingTransition(0, 0);
    }
  }
  
  public static abstract interface a
  {
    public abstract void a(b.b paramb);
  }
  
  public static abstract interface b
  {
    public abstract void eaS();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.as
 * JD-Core Version:    0.7.0.1
 */