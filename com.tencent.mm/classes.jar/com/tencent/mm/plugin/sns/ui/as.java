package com.tencent.mm.plugin.sns.ui;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Typeface;
import android.os.Bundle;
import android.os.Parcelable;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.e.h;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.br.d;
import com.tencent.mm.g.c.aw;
import com.tencent.mm.modelsns.SnsAdClick;
import com.tencent.mm.platformtools.ac;
import com.tencent.mm.plugin.messenger.foundation.a.l;
import com.tencent.mm.plugin.sns.ad.e.j;
import com.tencent.mm.plugin.sns.data.k;
import com.tencent.mm.plugin.sns.data.r;
import com.tencent.mm.plugin.sns.e.b.1;
import com.tencent.mm.plugin.sns.e.b.2;
import com.tencent.mm.plugin.sns.e.b.3;
import com.tencent.mm.plugin.sns.e.b.a;
import com.tencent.mm.plugin.sns.model.AdLandingPagesProxy;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.a.e;
import com.tencent.mm.plugin.sns.storage.b.c;
import com.tencent.mm.plugin.sns.storage.p;
import com.tencent.mm.plugin.sns.storage.x;
import com.tencent.mm.pluginsdk.m;
import com.tencent.mm.protocal.protobuf.TimeLineObject;
import com.tencent.mm.protocal.protobuf.abo;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.ar;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.storage.an;
import com.tencent.mm.storage.bq;
import com.tencent.mm.ui.widget.RoundedCornerFrameLayout;
import com.tencent.mm.ui.widget.imageview.WeImageView;
import java.util.HashMap;

public final class as
  implements View.OnClickListener
{
  private RoundedCornerFrameLayout AnT;
  private ImageView AnU;
  private TextView AnV;
  private TextView AnW;
  private Button AnX;
  private View AnY;
  private b AnZ;
  private a Aoa;
  private String dAg;
  private String dGD;
  private bq hKP;
  private View mContentView;
  private Context mContext;
  private an pSY;
  private p zlW;
  public j zrZ;
  private b.c zsF;
  private int zsG;
  private String zsJ;
  
  public as(Context paramContext, View paramView, int paramInt, j paramj, b paramb)
  {
    AppMethodBeat.i(98296);
    this.zsJ = "";
    this.dGD = "";
    this.dAg = "";
    this.Aoa = new a()
    {
      public final void a(b.c paramAnonymousc)
      {
        AppMethodBeat.i(179160);
        if ((paramAnonymousc == null) || (as.d(as.this) == null))
        {
          ae.e("MicroMsg.SnsAdCardActionBtnCtrl", "adCardActionBtnInfo or mActionBtn is null, can not updateActionBtnTitle");
          AppMethodBeat.o(179160);
          return;
        }
        switch (paramAnonymousc.zOk)
        {
        }
        for (;;)
        {
          AppMethodBeat.o(179160);
          return;
          if (!bu.isNullOrNil(paramAnonymousc.zOn))
          {
            as.d(as.this).setTextColor(-7829368);
            as.d(as.this).setText(paramAnonymousc.zOn);
            as.d(as.this).setEnabled(false);
            AppMethodBeat.o(179160);
            return;
            paramAnonymousc = paramAnonymousc.zth;
            if (!bu.isNullOrNil(paramAnonymousc)) {
              as.d(as.this).setText(paramAnonymousc);
            }
          }
        }
      }
    };
    ae.d("MicroMsg.SnsAdCardActionBtnCtrl", "init, source=" + paramInt + ", context=" + paramContext + ", static=" + paramj);
    this.mContext = paramContext;
    this.zsG = paramInt;
    this.zrZ = paramj;
    this.AnZ = paramb;
    this.mContentView = paramView;
    this.AnY = this.mContentView.findViewById(2131302206);
    this.AnT = ((RoundedCornerFrameLayout)paramView.findViewById(2131307266));
    this.AnU = ((ImageView)paramView.findViewById(2131307265));
    this.AnV = ((TextView)paramView.findViewById(2131296391));
    this.AnW = ((TextView)paramView.findViewById(2131296361));
    this.AnX = ((Button)paramView.findViewById(2131296354));
    this.AnX.setOnClickListener(this);
    this.AnT.setRadius(com.tencent.mm.cb.a.fromDPToPix(this.mContext, 4));
    this.hKP = ((l)com.tencent.mm.kernel.g.ab(l.class)).azF();
    AppMethodBeat.o(98296);
  }
  
  private int a(String paramString1, String paramString2, String paramString3, SnsAdClick paramSnsAdClick)
  {
    AppMethodBeat.i(219794);
    ae.i("MicroMsg.SnsAdCardActionBtnCtrl", "handleDownload, appPageUrl=" + paramString3 + ", pkg=" + paramString2 + ", appId=" + paramString1);
    Object localObject = a.e.zPr;
    if (com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.a.bi(ak.getContext(), paramString2))
    {
      ae.i("MicroMsg.SnsAdCardActionBtnCtrl", "isPkgInstalled==true");
      if (this.zlW != null)
      {
        paramSnsAdClick = this.zlW.Rv(this.zsG);
        if (paramSnsAdClick != null) {
          this.dGD = bu.nullAsNil(paramSnsAdClick.dGD);
        }
      }
      k.a(this.mContext, paramString1, paramString2, "", paramString3, this.dGD, this.zsJ, this.dAg, 0, 0);
      if (!TextUtils.isEmpty(paramString3))
      {
        AppMethodBeat.o(219794);
        return 34;
      }
    }
    else
    {
      localObject = a.e.zPr;
      if (!com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.a.isApkExist(paramString1)) {
        break label195;
      }
      ae.i("MicroMsg.SnsAdCardActionBtnCtrl", "isApkExist==true");
      k.jn(paramString2, paramString3);
      AdLandingPagesProxy.getInstance().installApp(this.mContext, paramString1, paramString2, "", "");
    }
    for (;;)
    {
      AppMethodBeat.o(219794);
      return 21;
      label195:
      boolean bool2 = false;
      boolean bool1 = bool2;
      if (this.zlW != null) {}
      try
      {
        paramString1 = this.zlW.Rv(this.zsG);
        bool1 = k.b(this.mContext, this.zlW, paramString1);
        if (!bool1)
        {
          paramString3 = this.zlW;
          paramString2 = (Activity)this.mContext;
          int i = this.zsG;
          localObject = this.AnY;
          StringBuilder localStringBuilder = new StringBuilder("jumpNativeLandingPageUIForDownload, snsId=");
          if (paramString3 == null) {}
          for (paramString1 = "";; paramString1 = r.zV(paramString3.field_snsId))
          {
            ae.i("MicroMsg.SnsAdCardActionBtnCtrl", paramString1);
            paramString1 = a(paramString3, paramString2, i, (View)localObject);
            if (paramString1 == null) {
              break label422;
            }
            this.AnZ.eey();
            paramString1.putExtra("sns_landing_pages_auto_download_for_action_btn", true);
            paramString1 = new com.tencent.mm.hellhoundlib.b.a().bc(paramString1);
            com.tencent.mm.hellhoundlib.a.a.a(paramString2, paramString1.ahE(), "com/tencent/mm/plugin/sns/ui/SnsAdCardActionBtnCtrl", "jumpNativeLandingPageUIForDownload", "(Lcom/tencent/mm/plugin/sns/storage/SnsInfo;Landroid/app/Activity;ILandroid/view/View;Lcom/tencent/mm/modelsns/SnsAdClick;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
            paramString2.startActivity((Intent)paramString1.mt(0));
            com.tencent.mm.hellhoundlib.a.a.a(paramString2, "com/tencent/mm/plugin/sns/ui/SnsAdCardActionBtnCtrl", "jumpNativeLandingPageUIForDownload", "(Lcom/tencent/mm/plugin/sns/storage/SnsInfo;Landroid/app/Activity;ILandroid/view/View;Lcom/tencent/mm/modelsns/SnsAdClick;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
            paramString2.overridePendingTransition(0, 0);
            break;
          }
          label422:
          a(paramString3, paramSnsAdClick, i, paramString2);
          continue;
        }
        k.jn(paramString2, paramString3);
        AppMethodBeat.o(219794);
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
    if (com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.i.aBm(paramp.ecy().field_adxml))
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
      localIntent.putExtra("sns_landing_pages_rawSnsId", paramp.ebP().Id);
      localIntent.putExtra("sns_landing_pages_ux_info", paramp.ecx());
      localIntent.setClass(paramActivity, SnsAdNativeLandingPagesUI.class);
      if (paramInt == 2)
      {
        i = 16;
        localIntent.putExtra("sns_landig_pages_from_source", i);
        localIntent.putExtra("sns_landing_pages_xml", paramp.ecy().field_adxml);
        localIntent.putExtra("sns_landing_pages_rec_src", paramp.ecz());
        localIntent.putExtra("sns_landing_pages_xml_prefix", "adxml");
        localIntent.putExtra("sns_landing_pages_need_enter_and_exit_animation", true);
        paramp = paramp.ebP();
        if ((paramp.HUG.Gtw != 15) || (paramp.HUN == 1)) {
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
    ae.e("MicroMsg.SnsAdCardActionBtnCtrl", "adxml is invalid, snsId=" + r.zV(paramp.field_snsId));
    AppMethodBeat.o(98301);
    return null;
  }
  
  private static void a(p paramp, SnsAdClick paramSnsAdClick, int paramInt, Context paramContext)
  {
    AppMethodBeat.i(98299);
    String str2 = paramp.ecw();
    String str1 = str2;
    if (TextUtils.isEmpty(str2)) {
      str1 = paramp.ecv();
    }
    if (TextUtils.isEmpty(str1))
    {
      ae.e("MicroMsg.SnsAdCardActionBtnCtrl", "jumpUpdateWebUI both url is empty");
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
    ae.i("MicroMsg.SnsAdCardActionBtnCtrl", "jumpWebUI, url=" + paramString + ", source=" + paramInt + ", snsInfo=" + paramp);
    if ((TextUtils.isEmpty(paramString)) || (paramp == null))
    {
      AppMethodBeat.o(98300);
      return;
    }
    Intent localIntent = new Intent();
    boolean bool1;
    if (paramp.dVj().zMS == 0)
    {
      bool1 = true;
      if (!ac.iRQ) {
        break label388;
      }
      bool1 = bool2;
    }
    label388:
    for (;;)
    {
      String str = paramString;
      if (paramp != null)
      {
        str = paramString;
        if (paramp.Rt(32))
        {
          com.tencent.mm.plugin.sns.storage.a locala = paramp.Rv(paramInt);
          str = paramString;
          if (locala != null)
          {
            localIntent.putExtra("KsnsViewId", locala.aQj);
            str = com.tencent.mm.plugin.sns.ad.b.a.a.ayT(r.jo(paramString, locala.dGD));
            r.g(localIntent, locala.dGD);
          }
        }
      }
      localIntent.putExtra("KRightBtn", bool1);
      paramString = new Bundle();
      if (paramSnsAdClick != null) {
        paramString.putParcelable("KSnsAdTag", paramSnsAdClick);
      }
      paramString.putString("key_snsad_statextstr", paramp.ebP().AiG);
      localIntent.putExtra("jsapiargs", paramString);
      localIntent.putExtra("rawUrl", str);
      localIntent.putExtra("useJs", true);
      localIntent.putExtra("srcUsername", paramp.field_userName);
      localIntent.putExtra("stastic_scene", 15);
      localIntent.putExtra("KPublisherId", "sns_" + r.zV(paramp.field_snsId));
      localIntent.putExtra("pre_username", paramp.field_userName);
      localIntent.putExtra("prePublishId", "sns_" + r.zV(paramp.field_snsId));
      localIntent.putExtra("preUsername", paramp.field_userName);
      com.tencent.mm.plugin.sns.c.a.iUz.i(localIntent, paramContext);
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
      ae.e("MicroMsg.SnsAdCardActionBtnCtrl", "refreshUI, snsInfo==null");
      AppMethodBeat.o(98297);
      return;
    }
    this.zlW = paramp;
    this.zsF = paramp.dVj().zsZ;
    try
    {
      this.zsJ = bu.nullAsNil(paramp.dVj().zsJ);
      this.dAg = String.valueOf(k.aze(bu.nullAsNil(paramp.getSnsId())));
      if (this.zsF != null)
      {
        System.currentTimeMillis();
        if (!TextUtils.isEmpty(paramp.dVj().zNE))
        {
          Object localObject1 = com.tencent.mm.ce.g.fqZ();
          this.AnV.getContext();
          localObject1 = ((com.tencent.mm.ce.g)localObject1).b(paramp.dVj().zNE, this.AnV.getTextSize());
          this.AnV.setText((CharSequence)localObject1);
          this.AnV.setVisibility(0);
          this.AnV.setTypeface(Typeface.defaultFromStyle(1));
          if (!TextUtils.isEmpty(paramp.dVj().zNF))
          {
            localObject1 = com.tencent.mm.ce.g.fqZ();
            this.AnW.getContext();
            localObject1 = ((com.tencent.mm.ce.g)localObject1).b(paramp.dVj().zNF, this.AnW.getTextSize());
            this.AnW.setText((CharSequence)localObject1);
            this.AnW.setVisibility(0);
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
          this.AnX.setTextColor(this.mContext.getResources().getColor(2131100027));
          this.AnX.setEnabled(true);
          if (this.zsF.zOk != 2) {
            break;
          }
          if (TextUtils.isEmpty(this.AnX.getText().toString())) {
            this.AnX.setText(this.zsF.zOj);
          }
          new as.c(this.AnX, this.zsF.zOx, this.zsF.zOw, this.zsF.zOj).execute(new Void[0]);
          if (TextUtils.isEmpty(this.zsF.iconUrl)) {
            break label654;
          }
          this.AnT.setVisibility(0);
          com.tencent.mm.plugin.sns.ad.f.b.i(this.zsF.iconUrl, this.AnU);
          AppMethodBeat.o(98297);
          return;
          localThrowable1 = localThrowable1;
          ae.e("MicroMsg.SnsAdCardActionBtnCtrl", localThrowable1.toString());
          continue;
          this.AnW.setVisibility(8);
        }
        if (!TextUtils.isEmpty(paramp.dVj().zNF))
        {
          Object localObject2 = com.tencent.mm.ce.g.fqZ();
          this.AnV.getContext();
          localObject2 = ((com.tencent.mm.ce.g)localObject2).b(paramp.dVj().zNF, this.AnV.getTextSize());
          this.AnV.setText((CharSequence)localObject2);
          this.AnV.setVisibility(0);
          this.AnV.setTypeface(Typeface.defaultFromStyle(0));
        }
        for (;;)
        {
          this.AnW.setVisibility(8);
          break;
          this.AnV.setVisibility(8);
        }
      }
      catch (Throwable localThrowable2)
      {
        for (;;)
        {
          ae.e("MicroMsg.SnsAdCardActionBtnCtrl", localThrowable2.toString());
          continue;
          if (this.zsF.zOk == 6)
          {
            try
            {
              paramp = r.zV(paramp.field_snsId);
              if (bu.isNullOrNil(paramp)) {
                continue;
              }
              if (!"1".equals(x.aBQ(paramp))) {
                break label588;
              }
              this.AnX.setTextColor(-7829368);
              this.AnX.setText(this.zsF.zOn);
              this.AnX.setEnabled(false);
            }
            catch (Throwable paramp)
            {
              ae.e("MicroMsg.SnsAdCardActionBtnCtrl", paramp.toString());
            }
            continue;
            label588:
            this.AnX.setText(this.zsF.zOj);
          }
          else if (this.zsF.zOk == 7)
          {
            h.MqF.aO(new Runnable()
            {
              public final void run()
              {
                AppMethodBeat.i(219791);
                if ((as.a(as.this) != null) && (!bu.isNullOrNil(as.b(as.this).hTJ)))
                {
                  as.a(as.this, as.a(as.this).BH(as.b(as.this).hTJ));
                  ar.f(new Runnable()
                  {
                    public final void run()
                    {
                      AppMethodBeat.i(219790);
                      if ((as.c(as.this) != null) && (com.tencent.mm.contact.c.lO(as.c(as.this).field_type)))
                      {
                        as.d(as.this).setText(as.b(as.this).zth);
                        AppMethodBeat.o(219790);
                        return;
                      }
                      as.d(as.this).setText(as.b(as.this).zOj);
                      AppMethodBeat.o(219790);
                    }
                  });
                }
                AppMethodBeat.o(219791);
              }
            });
          }
          else
          {
            this.AnX.setText(this.zsF.zOj);
          }
        }
        label654:
        this.AnT.setVisibility(8);
      }
      AppMethodBeat.o(98297);
    }
  }
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(98298);
    localObject1 = new com.tencent.mm.hellhoundlib.b.b();
    ((com.tencent.mm.hellhoundlib.b.b)localObject1).bd(paramView);
    com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/sns/ui/SnsAdCardActionBtnCtrl", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject1).ahF());
    if (this.zsF == null)
    {
      ae.e("MicroMsg.SnsAdCardActionBtnCtrl", "onClick mActionBtnInfo==null");
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/sns/ui/SnsAdCardActionBtnCtrl", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(98298);
      return;
    }
    for (;;)
    {
      try
      {
        int j = this.zsG;
        if (this.zsG == 0)
        {
          i = 1;
          localSnsAdClick = new SnsAdClick(j, i, this.zlW.field_snsId, 26, 0);
          k.a(localSnsAdClick, this.zrZ, this.zlW, 26);
        }
      }
      catch (Exception paramView)
      {
        int i;
        final SnsAdClick localSnsAdClick;
        ae.e("MicroMsg.SnsAdCardActionBtnCtrl", "onClick report exp=" + paramView.toString());
        continue;
        long l = ((p)localObject1).field_snsId;
        continue;
        a(this.zlW, localSnsAdClick, this.zsG, this.mContext);
        continue;
        localSnsAdClick.ipO = 0;
        a(this.zsF.zOl, this.zlW, localSnsAdClick, this.zsG, this.mContext);
        continue;
        localSnsAdClick.ipO = 31;
        com.tencent.mm.plugin.sns.ui.d.c.a(this.zsF.pSx, this.zsF.hGk, this.zsF.hGl, this.zlW, this.zsG);
        continue;
        localSnsAdClick.ipO = a(this.zsF.zOw, this.zsF.zOx, this.zsF.zMz, localSnsAdClick);
        continue;
        localSnsAdClick.ipO = 32;
        a(this.zsF.zOl, this.zlW, localSnsAdClick, this.zsG, this.mContext);
        continue;
        localSnsAdClick.ipO = 11;
        Object localObject2 = this.zlW.dVi();
        localObject1 = "";
        paramView = (View)localObject1;
        if (localObject2 == null) {
          continue;
        }
        paramView = (View)localObject1;
        if (((com.tencent.mm.plugin.sns.storage.a)localObject2).zMm == null) {
          continue;
        }
        paramView = (String)((com.tencent.mm.plugin.sns.storage.a)localObject2).zMm.get(this.zsF.oFe);
        if (!TextUtils.isEmpty(paramView)) {
          continue;
        }
        ae.e("MicroMsg.SnsAdCardActionBtnCtrl", "cardExt is not found in adInfo, tpid=" + this.zsF.oFe);
        paramView = this.zsF.oGb;
        localObject1 = (Activity)this.mContext;
        localObject2 = this.zsF.oFe;
        ae.i("MicroMsg.SnsAdCardActionBtnCtrl", "jumpCardDetail, cardTpId=" + (String)localObject2 + ", cardExt=" + paramView);
        Object localObject3 = new Intent();
        ((Intent)localObject3).putExtra("key_card_id", (String)localObject2);
        ((Intent)localObject3).putExtra("key_card_ext", paramView);
        ((Intent)localObject3).putExtra("key_from_scene", 21);
        ((Intent)localObject3).putExtra("key_stastic_scene", 15);
        d.b((Context)localObject1, "card", ".ui.CardDetailUI", (Intent)localObject3);
        continue;
        localSnsAdClick.ipO = 33;
        try
        {
          ar.f(new Runnable()
          {
            public final void run()
            {
              AppMethodBeat.i(219792);
              try
              {
                if (this.val$context != null)
                {
                  com.tencent.mm.ui.widget.a.e locale = new com.tencent.mm.ui.widget.a.e(this.val$context, true, 0);
                  com.tencent.mm.plugin.sns.e.b localb = new com.tencent.mm.plugin.sns.e.b();
                  Context localContext = this.val$context;
                  b.c localc = this.zsV;
                  p localp = this.AgF;
                  int i = this.ohh;
                  as.a locala = as.e(as.this);
                  Object localObject = as.a(as.this);
                  String str1 = localc.pSx;
                  String str2 = localc.zOm;
                  localObject = com.tencent.mm.plugin.sns.e.b.a(localContext, localc, localp, (bq)localObject);
                  WeImageView localWeImageView = (WeImageView)((View)localObject).findViewById(2131298360);
                  Button localButton = (Button)((View)localObject).findViewById(2131305516);
                  localb.zsP = false;
                  locale.KtV = new b.1(localb, str2, str1, localp, i);
                  localWeImageView.setOnClickListener(new b.2(localb, locale));
                  localb.nMW = locale;
                  localb.mContext = localContext;
                  localButton.setOnClickListener(new b.3(localb, localp, localc, new b.a(localb, localc, localp, i, locala), localContext));
                  locale.P((View)localObject, true);
                  locale.fQw();
                  locale.cPF();
                }
                AppMethodBeat.o(219792);
                return;
              }
              catch (Throwable localThrowable)
              {
                ae.e("MicroMsg.SnsAdCardActionBtnCtrl", localThrowable.toString());
                AppMethodBeat.o(219792);
              }
            }
          });
        }
        catch (Throwable paramView)
        {
          ae.e("MicroMsg.SnsAdCardActionBtnCtrl", paramView.toString());
        }
        continue;
        try
        {
          if ((this.pSY == null) || (!com.tencent.mm.contact.c.lO(this.pSY.field_type))) {
            continue;
          }
          localSnsAdClick.ipO = 39;
          ar.f(new Runnable()
          {
            public final void run()
            {
              AppMethodBeat.i(219793);
              Object localObject1;
              Object localObject2;
              try
              {
                if ((this.lAB == null) || (this.Aod == null) || (this.zsR == null))
                {
                  ae.e("MicroMsg.SnsAdCardActionBtnCtrl", "mContext or mActionBtnInfo or mSnsInfo is null");
                  AppMethodBeat.o(219793);
                  return;
                }
                if ((as.c(as.this) == null) || (!com.tencent.mm.contact.c.lO(as.c(as.this).field_type))) {
                  break label214;
                }
                Context localContext = this.lAB;
                localObject3 = this.zsR;
                localObject1 = localSnsAdClick;
                i = this.zsS;
                localObject2 = this.Aod;
                if ((localContext == null) || (localObject3 == null) || (localObject2 == null) || (bu.isNullOrNil(((b.c)localObject2).hTJ)))
                {
                  AppMethodBeat.o(219793);
                  return;
                }
              }
              catch (Throwable localThrowable)
              {
                ae.e("MicroMsg.SnsAdCardActionBtnCtrl", localThrowable.toString());
                AppMethodBeat.o(219793);
                return;
              }
              Object localObject3 = new Intent();
              ((Intent)localObject3).putExtra("Contact_User", ((b.c)localObject2).hTJ);
              ((Intent)localObject3).putExtra("KSnsAdTag", (Parcelable)localObject1);
              ((Intent)localObject3).putExtra("Contact_Scene", 181);
              if (i == 0) {}
              for (int i = 6;; i = 1)
              {
                ((Intent)localObject3).putExtra("CONTACT_INFO_UI_SOURCE", i);
                com.tencent.mm.plugin.sns.c.a.iUz.c((Intent)localObject3, localThrowable);
                AppMethodBeat.o(219793);
                return;
                label214:
                com.tencent.mm.plugin.sns.e.a locala = new com.tencent.mm.plugin.sns.e.a();
                localObject2 = this.lAB;
                localObject3 = this.zsR;
                localObject1 = this.Aod;
                i = this.zsS;
                bq localbq = as.a(as.this);
                an localan = as.c(as.this);
                as.a locala1 = as.e(as.this);
                locala.zsF = ((b.c)localObject1);
                locala.mContext = ((Context)localObject2);
                locala.zsG = i;
                locala.hKP = localbq;
                locala.pSY = localan;
                locala.zsE = locala1;
                locala.dAg = String.valueOf(k.aze(((p)localObject3).getSnsId()));
                locala.dGD = ((p)localObject3).ecx();
                locala.zsJ = ((p)localObject3).dVj().zsJ;
                localObject2 = new com.tencent.mm.plugin.sns.data.c();
                if (localObject1 == null) {}
                for (;;)
                {
                  locala.zsH = ((com.tencent.mm.plugin.sns.data.c)localObject2);
                  locala.dWd();
                  AppMethodBeat.o(219793);
                  return;
                  ((com.tencent.mm.plugin.sns.data.c)localObject2).hTJ = bu.bI(((b.c)localObject1).hTJ, "");
                  ((com.tencent.mm.plugin.sns.data.c)localObject2).ztf = bu.bI(((b.c)localObject1).ztf, "");
                  ((com.tencent.mm.plugin.sns.data.c)localObject2).dpI = bu.bI(((b.c)localObject1).dpI, "");
                  ((com.tencent.mm.plugin.sns.data.c)localObject2).ztg = bu.bI(((b.c)localObject1).ztg, "");
                  ((com.tencent.mm.plugin.sns.data.c)localObject2).zth = bu.bI(((b.c)localObject1).zth, "");
                }
              }
            }
          });
        }
        catch (Throwable paramView)
        {
          ae.e("MicroMsg.SnsAdCardActionBtnCtrl", paramView.toString());
        }
        continue;
        localSnsAdClick.ipO = 38;
        continue;
        continue;
        continue;
      }
      try
      {
        ae.i("MicroMsg.SnsAdCardActionBtnCtrl", "onClick, type=" + this.zsF.zOk + ", snsId=" + r.zV(this.zlW.field_snsId));
        switch (this.zsF.zOk)
        {
        case 3: 
          ae.i("MicroMsg.SnsAdCardActionBtnCtrl", "clickAction=" + localSnsAdClick.ipO);
        }
      }
      catch (Exception paramView)
      {
        ae.e("MicroMsg.SnsAdCardActionBtnCtrl", "onClick exp=" + paramView.toString());
        continue;
      }
      r.a(localSnsAdClick);
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/sns/ui/SnsAdCardActionBtnCtrl", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(98298);
      return;
      i = 2;
      continue;
      localSnsAdClick.ipO = 21;
      localObject1 = this.zlW;
      paramView = (Activity)this.mContext;
      i = this.zsG;
      localObject2 = this.AnY;
      localObject3 = new StringBuilder("jumpNativeLandingPageUI, snsId=");
      if (localObject1 != null) {
        continue;
      }
      l = 0L;
      ae.i("MicroMsg.SnsAdCardActionBtnCtrl", l);
      localObject1 = a((p)localObject1, paramView, i, (View)localObject2);
      if (localObject1 == null) {
        continue;
      }
      this.AnZ.eey();
      localObject1 = new com.tencent.mm.hellhoundlib.b.a().bc(localObject1);
      com.tencent.mm.hellhoundlib.a.a.a(paramView, ((com.tencent.mm.hellhoundlib.b.a)localObject1).ahE(), "com/tencent/mm/plugin/sns/ui/SnsAdCardActionBtnCtrl", "jumpNativeLandingPageUI", "(Lcom/tencent/mm/plugin/sns/storage/SnsInfo;Landroid/app/Activity;ILandroid/view/View;Lcom/tencent/mm/modelsns/SnsAdClick;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      paramView.startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject1).mt(0));
      com.tencent.mm.hellhoundlib.a.a.a(paramView, "com/tencent/mm/plugin/sns/ui/SnsAdCardActionBtnCtrl", "jumpNativeLandingPageUI", "(Lcom/tencent/mm/plugin/sns/storage/SnsInfo;Landroid/app/Activity;ILandroid/view/View;Lcom/tencent/mm/modelsns/SnsAdClick;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      paramView.overridePendingTransition(0, 0);
    }
  }
  
  public static abstract interface a
  {
    public abstract void a(b.c paramc);
  }
  
  public static abstract interface b
  {
    public abstract void eey();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.as
 * JD-Core Version:    0.7.0.1
 */