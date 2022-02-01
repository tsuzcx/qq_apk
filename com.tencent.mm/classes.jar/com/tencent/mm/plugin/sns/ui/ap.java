package com.tencent.mm.plugin.sns.ui;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Typeface;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.b.c;
import com.tencent.mm.al.n;
import com.tencent.mm.bs.d;
import com.tencent.mm.modelsns.SnsAdClick;
import com.tencent.mm.msgsubscription.SubscribeMsgRequestResult;
import com.tencent.mm.msgsubscription.SubscribeMsgRequestResult.a;
import com.tencent.mm.platformtools.ab;
import com.tencent.mm.plugin.sns.data.j;
import com.tencent.mm.plugin.sns.f.a.2;
import com.tencent.mm.plugin.sns.f.a.3;
import com.tencent.mm.plugin.sns.f.a.4;
import com.tencent.mm.plugin.sns.k.b.1;
import com.tencent.mm.plugin.sns.model.AdLandingPagesProxy;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.a.g.a;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.a.g.b;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.a.e;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.h;
import com.tencent.mm.plugin.sns.storage.b.a;
import com.tencent.mm.plugin.sns.storage.p;
import com.tencent.mm.plugin.sns.storage.x;
import com.tencent.mm.plugin.sns.storage.y;
import com.tencent.mm.pluginsdk.l;
import com.tencent.mm.protocal.protobuf.TimeLineObject;
import com.tencent.mm.protocal.protobuf.czx;
import com.tencent.mm.protocal.protobuf.yk;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.sdk.platformtools.aq;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.ui.base.t;
import com.tencent.mm.ui.widget.imageview.WeImageView;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public final class ap
  implements View.OnClickListener
{
  private String dpC;
  private String dvK;
  private View mContentView;
  private Context mContext;
  private String wBR;
  private p wvM;
  private com.tencent.mm.al.g wzQ;
  private TextView xsA;
  private TextView xsB;
  private Button xsC;
  private View xsD;
  private b.a xsE;
  public com.tencent.mm.plugin.sns.a.b.i xsF;
  private b xsG;
  private a xsH;
  private int xsz;
  
  public ap(Context paramContext, View paramView, int paramInt, com.tencent.mm.plugin.sns.a.b.i parami, b paramb)
  {
    AppMethodBeat.i(98296);
    this.wBR = "";
    this.dvK = "";
    this.dpC = "";
    this.wzQ = new com.tencent.mm.al.g()
    {
      public final void onSceneEnd(int paramAnonymousInt1, int paramAnonymousInt2, String paramAnonymousString, n paramAnonymousn)
      {
        AppMethodBeat.i(179159);
        ad.i("MicroMsg.SnsAdCardActionBtnCtrl", "onSceneEnd errType %d,errCode %d,errMsg %s,scene %s", new Object[] { Integer.valueOf(paramAnonymousInt1), Integer.valueOf(paramAnonymousInt2), paramAnonymousString, Integer.valueOf(paramAnonymousn.getType()) });
        try
        {
          Object localObject;
          g.b localb;
          if ((paramAnonymousn instanceof com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.a.g))
          {
            localObject = (com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.a.g)paramAnonymousn;
            localb = ((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.a.g)localObject).xfy;
            if (localb != null)
            {
              if ((paramAnonymousInt1 != 0) || (paramAnonymousInt2 != 0))
              {
                bt.nullAsNil(paramAnonymousString);
                localb.c(null);
                com.tencent.mm.kernel.g.aeS().b(paramAnonymousn.getType(), ap.a(ap.this));
                AppMethodBeat.o(179159);
                return;
              }
              localObject = ((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.a.g)localObject).getReqResp();
              if ((localObject instanceof com.tencent.mm.al.b))
              {
                localObject = (com.tencent.mm.al.b)localObject;
                if ((((com.tencent.mm.al.b)localObject).gUT.gUX instanceof czx)) {
                  localObject = (czx)((com.tencent.mm.al.b)localObject).gUT.gUX;
                }
              }
            }
          }
          StringBuilder localStringBuilder;
          SubscribeMsgRequestResult.a locala;
          AppMethodBeat.o(179159);
        }
        catch (Throwable paramAnonymousString)
        {
          try
          {
            localStringBuilder = new StringBuilder("rr = ");
            locala = SubscribeMsgRequestResult.hGs;
            ad.i("MicroMsg.SnsAdCardActionBtnCtrl", SubscribeMsgRequestResult.a.a((czx)localObject));
            bt.nullAsNil(paramAnonymousString);
            paramAnonymousString = SubscribeMsgRequestResult.hGs;
            localb.c(SubscribeMsgRequestResult.a.a((czx)localObject));
            com.tencent.mm.kernel.g.aeS().b(paramAnonymousn.getType(), ap.a(ap.this));
            AppMethodBeat.o(179159);
            return;
          }
          catch (Exception paramAnonymousString)
          {
            ad.e("MicroMsg.SnsAdCardActionBtnCtrl", paramAnonymousString.toString());
          }
          paramAnonymousString = paramAnonymousString;
          ad.e("MicroMsg.SnsAdCardActionBtnCtrl", paramAnonymousString.toString());
          AppMethodBeat.o(179159);
          return;
        }
      }
    };
    this.xsH = new a()
    {
      public final void a(b.a paramAnonymousa)
      {
        AppMethodBeat.i(179160);
        if ((ap.b(ap.this) != null) && (paramAnonymousa != null) && (!bt.isNullOrNil(paramAnonymousa.wTW)))
        {
          ap.b(ap.this).setTextColor(-7829368);
          ap.b(ap.this).setText(paramAnonymousa.wTW);
          ap.b(ap.this).setEnabled(false);
        }
        AppMethodBeat.o(179160);
      }
    };
    ad.d("MicroMsg.SnsAdCardActionBtnCtrl", "init, source=" + paramInt + ", context=" + paramContext + ", static=" + parami);
    this.mContext = paramContext;
    this.xsz = paramInt;
    this.xsF = parami;
    this.xsG = paramb;
    this.mContentView = paramView;
    this.xsD = this.mContentView.findViewById(2131302206);
    this.xsA = ((TextView)paramView.findViewById(2131296391));
    this.xsB = ((TextView)paramView.findViewById(2131296361));
    this.xsC = ((Button)paramView.findViewById(2131296354));
    this.xsC.setOnClickListener(this);
    AppMethodBeat.o(98296);
  }
  
  private static Intent a(p paramp, Activity paramActivity, int paramInt, View paramView)
  {
    int i = 2;
    boolean bool = true;
    AppMethodBeat.i(98301);
    if (com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.i.apF(paramp.dyh().field_adxml))
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
      localIntent.putExtra("sns_landing_pages_rawSnsId", paramp.dxy().Id);
      localIntent.putExtra("sns_landing_pages_ux_info", paramp.dyg());
      localIntent.setClass(paramActivity, SnsAdNativeLandingPagesUI.class);
      if (paramInt == 2)
      {
        i = 16;
        localIntent.putExtra("sns_landig_pages_from_source", i);
        localIntent.putExtra("sns_landing_pages_xml", paramp.dyh().field_adxml);
        localIntent.putExtra("sns_landing_pages_rec_src", paramp.dyi());
        localIntent.putExtra("sns_landing_pages_xml_prefix", "adxml");
        localIntent.putExtra("sns_landing_pages_need_enter_and_exit_animation", true);
        paramp = paramp.dxy();
        if ((paramp.Etm.DaB != 15) || (paramp.Ett == 1)) {
          break label268;
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
        label268:
        bool = false;
      }
    }
    ad.e("MicroMsg.SnsAdCardActionBtnCtrl", "adxml is invalid, snsId=" + com.tencent.mm.plugin.sns.data.q.st(paramp.field_snsId));
    AppMethodBeat.o(98301);
    return null;
  }
  
  private static void a(p paramp, SnsAdClick paramSnsAdClick, int paramInt, Context paramContext)
  {
    AppMethodBeat.i(98299);
    String str2 = paramp.dyf();
    String str1 = str2;
    if (TextUtils.isEmpty(str2)) {
      str1 = paramp.dye();
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
    if (paramp.dxs().wSL == 0)
    {
      bool1 = true;
      if (!ab.hVL) {
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
        if (paramp.Nb(32))
        {
          com.tencent.mm.plugin.sns.storage.a locala = paramp.Nd(paramInt);
          str = paramString;
          if (locala != null)
          {
            localIntent.putExtra("KsnsViewId", locala.dAM);
            str = com.tencent.mm.plugin.sns.data.q.iy(paramString, locala.dvK);
            com.tencent.mm.plugin.sns.data.q.g(localIntent, locala.dvK);
          }
        }
      }
      localIntent.putExtra("KRightBtn", bool1);
      paramString = new Bundle();
      if (paramSnsAdClick != null) {
        paramString.putParcelable("KSnsAdTag", paramSnsAdClick);
      }
      paramString.putString("key_snsad_statextstr", paramp.dxy().xns);
      localIntent.putExtra("jsapiargs", paramString);
      localIntent.putExtra("rawUrl", str);
      localIntent.putExtra("useJs", true);
      localIntent.putExtra("srcUsername", paramp.field_userName);
      localIntent.putExtra("stastic_scene", 15);
      localIntent.putExtra("KPublisherId", "sns_" + com.tencent.mm.plugin.sns.data.q.st(paramp.field_snsId));
      localIntent.putExtra("pre_username", paramp.field_userName);
      localIntent.putExtra("prePublishId", "sns_" + com.tencent.mm.plugin.sns.data.q.st(paramp.field_snsId));
      localIntent.putExtra("preUsername", paramp.field_userName);
      com.tencent.mm.plugin.sns.d.a.hYt.i(localIntent, paramContext);
      AppMethodBeat.o(98300);
      return;
      bool1 = false;
      break;
    }
  }
  
  public final void M(p paramp)
  {
    AppMethodBeat.i(98297);
    if (paramp == null)
    {
      ad.e("MicroMsg.SnsAdCardActionBtnCtrl", "refreshUI, snsInfo==null");
      AppMethodBeat.o(98297);
      return;
    }
    this.wvM = paramp;
    this.xsE = paramp.dxs().wTM;
    try
    {
      this.wBR = bt.nullAsNil(paramp.dxs().wBR);
      this.dpC = String.valueOf(j.anz(bt.nullAsNil(paramp.getSnsId())));
      if (this.xsE != null)
      {
        System.currentTimeMillis();
        if (!TextUtils.isEmpty(paramp.dxs().wTx))
        {
          Object localObject1 = com.tencent.mm.cg.g.eIa();
          this.xsA.getContext();
          localObject1 = ((com.tencent.mm.cg.g)localObject1).b(paramp.dxs().wTx, this.xsA.getTextSize());
          this.xsA.setText((CharSequence)localObject1);
          this.xsA.setVisibility(0);
          this.xsA.setTypeface(Typeface.defaultFromStyle(1));
          if (!TextUtils.isEmpty(paramp.dxs().wTy))
          {
            localObject1 = com.tencent.mm.cg.g.eIa();
            this.xsB.getContext();
            localObject1 = ((com.tencent.mm.cg.g)localObject1).b(paramp.dxs().wTy, this.xsB.getTextSize());
            this.xsB.setText((CharSequence)localObject1);
            this.xsB.setVisibility(0);
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
          this.xsC.setTextColor(this.mContext.getResources().getColor(2131100027));
          this.xsC.setEnabled(true);
          if (this.xsE.wTT != 2) {
            break;
          }
          if (TextUtils.isEmpty(this.xsC.getText().toString())) {
            this.xsC.setText(this.xsE.wTS);
          }
          new ap.c(this.xsC, this.xsE.wUd, this.xsE.wUc, this.xsE.wTS).execute(new Void[0]);
          AppMethodBeat.o(98297);
          return;
          localThrowable1 = localThrowable1;
          ad.e("MicroMsg.SnsAdCardActionBtnCtrl", localThrowable1.toString());
          continue;
          this.xsB.setVisibility(8);
        }
        if (!TextUtils.isEmpty(paramp.dxs().wTy))
        {
          Object localObject2 = com.tencent.mm.cg.g.eIa();
          this.xsA.getContext();
          localObject2 = ((com.tencent.mm.cg.g)localObject2).b(paramp.dxs().wTy, this.xsA.getTextSize());
          this.xsA.setText((CharSequence)localObject2);
          this.xsA.setVisibility(0);
          this.xsA.setTypeface(Typeface.defaultFromStyle(0));
        }
        for (;;)
        {
          this.xsB.setVisibility(8);
          break;
          this.xsA.setVisibility(8);
        }
      }
      catch (Throwable localThrowable2)
      {
        for (;;)
        {
          ad.e("MicroMsg.SnsAdCardActionBtnCtrl", localThrowable2.toString());
        }
        if (this.xsE.wTT == 6)
        {
          try
          {
            paramp = com.tencent.mm.plugin.sns.data.q.st(paramp.field_snsId);
            if (bt.isNullOrNil(paramp)) {
              break label575;
            }
            if ("1".equals(x.aqj(paramp)))
            {
              this.xsC.setTextColor(-7829368);
              this.xsC.setText(this.xsE.wTW);
              this.xsC.setEnabled(false);
              AppMethodBeat.o(98297);
              return;
            }
          }
          catch (Throwable paramp)
          {
            ad.e("MicroMsg.SnsAdCardActionBtnCtrl", paramp.toString());
            AppMethodBeat.o(98297);
            return;
          }
          this.xsC.setText(this.xsE.wTS);
          label575:
          AppMethodBeat.o(98297);
          return;
        }
        this.xsC.setText(this.xsE.wTS);
      }
      AppMethodBeat.o(98297);
    }
  }
  
  public final void onClick(final View paramView)
  {
    final int i = 1;
    boolean bool2 = false;
    AppMethodBeat.i(98298);
    if (this.xsE == null)
    {
      ad.e("MicroMsg.SnsAdCardActionBtnCtrl", "onClick mActionBtnInfo==null");
      AppMethodBeat.o(98298);
      return;
    }
    for (;;)
    {
      SnsAdClick localSnsAdClick;
      try
      {
        int j = this.xsz;
        if (this.xsz == 0)
        {
          localSnsAdClick = new SnsAdClick(j, i, this.wvM.field_snsId, 26, 0);
          j.a(localSnsAdClick, this.xsF, this.wvM, 26);
        }
        try
        {
          ad.i("MicroMsg.SnsAdCardActionBtnCtrl", "onClick, type=" + this.xsE.wTT + ", snsId=" + com.tencent.mm.plugin.sns.data.q.st(this.wvM.field_snsId));
          switch (this.xsE.wTT)
          {
          case 3: 
            ad.i("MicroMsg.SnsAdCardActionBtnCtrl", "clickAction=" + localSnsAdClick.hsY);
          }
        }
        catch (Exception paramView)
        {
          ad.e("MicroMsg.SnsAdCardActionBtnCtrl", "onClick exp=" + paramView.toString());
          continue;
        }
        com.tencent.mm.plugin.sns.data.q.a(localSnsAdClick);
        AppMethodBeat.o(98298);
        return;
        i = 2;
        continue;
        localSnsAdClick.hsY = 21;
        localObject1 = this.wvM;
        paramView = (Activity)this.mContext;
        i = this.xsz;
        localObject2 = this.xsD;
        localObject3 = new StringBuilder("jumpNativeLandingPageUI, snsId=");
        if (localObject1 == null)
        {
          l = 0L;
          ad.i("MicroMsg.SnsAdCardActionBtnCtrl", l);
          localObject1 = a((p)localObject1, paramView, i, (View)localObject2);
          if (localObject1 == null) {
            break label468;
          }
          this.xsG.dAh();
          localObject1 = new com.tencent.mm.hellhoundlib.b.a().bd(localObject1);
          com.tencent.mm.hellhoundlib.a.a.a(paramView, ((com.tencent.mm.hellhoundlib.b.a)localObject1).adn(), "com/tencent/mm/plugin/sns/ui/SnsAdCardActionBtnCtrl", "jumpNativeLandingPageUI", "(Lcom/tencent/mm/plugin/sns/storage/SnsInfo;Landroid/app/Activity;ILandroid/view/View;Lcom/tencent/mm/modelsns/SnsAdClick;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
          paramView.startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject1).lS(0));
          com.tencent.mm.hellhoundlib.a.a.a(paramView, "com/tencent/mm/plugin/sns/ui/SnsAdCardActionBtnCtrl", "jumpNativeLandingPageUI", "(Lcom/tencent/mm/plugin/sns/storage/SnsInfo;Landroid/app/Activity;ILandroid/view/View;Lcom/tencent/mm/modelsns/SnsAdClick;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
          paramView.overridePendingTransition(0, 0);
          continue;
        }
        long l = ((p)localObject1).field_snsId;
      }
      catch (Exception paramView)
      {
        ad.e("MicroMsg.SnsAdCardActionBtnCtrl", "onClick report exp=" + paramView.toString());
        AppMethodBeat.o(98298);
        return;
      }
      continue;
      label468:
      a(this.wvM, localSnsAdClick, this.xsz, this.mContext);
      continue;
      localSnsAdClick.hsY = 0;
      a(this.xsE.wTU, this.wvM, localSnsAdClick, this.xsz, this.mContext);
      continue;
      localSnsAdClick.hsY = 31;
      com.tencent.mm.plugin.sns.ui.d.b.a(this.xsE.oER, this.xsE.gKJ, this.xsE.gKK, this.wvM, this.xsz);
      continue;
      localSnsAdClick.hsY = 21;
      paramView = this.xsE.wUc;
      Object localObject1 = this.xsE.wUd;
      Object localObject2 = this.xsE.wSw;
      ad.i("MicroMsg.SnsAdCardActionBtnCtrl", "handleDownload, appPageUrl=" + (String)localObject2 + ", pkg=" + (String)localObject1 + ", appId=" + paramView);
      Object localObject3 = a.e.wUX;
      if (com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.a.bc(aj.getContext(), (String)localObject1))
      {
        ad.i("MicroMsg.SnsAdCardActionBtnCtrl", "isPkgInstalled==true");
        if (this.wvM != null)
        {
          localObject3 = this.wvM.Nd(this.xsz);
          if (localObject3 != null) {
            this.dvK = bt.nullAsNil(((com.tencent.mm.plugin.sns.storage.a)localObject3).dvK);
          }
        }
        j.a(this.mContext, paramView, (String)localObject1, "", (String)localObject2, this.dvK, this.wBR, this.dpC);
      }
      else
      {
        localObject2 = a.e.wUX;
        if (com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.a.isApkExist(paramView))
        {
          ad.i("MicroMsg.SnsAdCardActionBtnCtrl", "isApkExist==true");
          AdLandingPagesProxy.getInstance().installApp(this.mContext, paramView, (String)localObject1, "", "");
        }
        else
        {
          paramView = this.wvM;
          boolean bool1 = bool2;
          if (paramView != null) {}
          try
          {
            paramView = this.wvM.Nd(this.xsz);
            bool1 = j.a(this.mContext, this.wvM, paramView);
            if (!bool1)
            {
              localObject2 = this.wvM;
              localObject1 = (Activity)this.mContext;
              i = this.xsz;
              localObject3 = this.xsD;
              Object localObject4 = new StringBuilder("jumpNativeLandingPageUIForDownload, snsId=");
              if (localObject2 == null) {}
              for (paramView = "";; paramView = com.tencent.mm.plugin.sns.data.q.st(((p)localObject2).field_snsId))
              {
                ad.i("MicroMsg.SnsAdCardActionBtnCtrl", paramView);
                paramView = a((p)localObject2, (Activity)localObject1, i, (View)localObject3);
                if (paramView == null) {
                  break label1020;
                }
                this.xsG.dAh();
                paramView.putExtra("sns_landing_pages_auto_download_for_action_btn", true);
                paramView = new com.tencent.mm.hellhoundlib.b.a().bd(paramView);
                com.tencent.mm.hellhoundlib.a.a.a(localObject1, paramView.adn(), "com/tencent/mm/plugin/sns/ui/SnsAdCardActionBtnCtrl", "jumpNativeLandingPageUIForDownload", "(Lcom/tencent/mm/plugin/sns/storage/SnsInfo;Landroid/app/Activity;ILandroid/view/View;Lcom/tencent/mm/modelsns/SnsAdClick;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                ((Activity)localObject1).startActivity((Intent)paramView.lS(0));
                com.tencent.mm.hellhoundlib.a.a.a(localObject1, "com/tencent/mm/plugin/sns/ui/SnsAdCardActionBtnCtrl", "jumpNativeLandingPageUIForDownload", "(Lcom/tencent/mm/plugin/sns/storage/SnsInfo;Landroid/app/Activity;ILandroid/view/View;Lcom/tencent/mm/modelsns/SnsAdClick;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                ((Activity)localObject1).overridePendingTransition(0, 0);
                break;
              }
              label1020:
              a((p)localObject2, localSnsAdClick, i, (Context)localObject1);
              continue;
              localSnsAdClick.hsY = 32;
              a(this.xsE.wTU, this.wvM, localSnsAdClick, this.xsz, this.mContext);
              continue;
              localSnsAdClick.hsY = 11;
              localObject2 = this.wvM.dxu();
              localObject1 = "";
              paramView = (View)localObject1;
              if (localObject2 != null)
              {
                paramView = (View)localObject1;
                if (((com.tencent.mm.plugin.sns.storage.a)localObject2).wSk != null) {
                  paramView = (String)((com.tencent.mm.plugin.sns.storage.a)localObject2).wSk.get(this.xsE.nsh);
                }
              }
              if (TextUtils.isEmpty(paramView))
              {
                ad.e("MicroMsg.SnsAdCardActionBtnCtrl", "cardExt is not found in adInfo, tpid=" + this.xsE.nsh);
                paramView = this.xsE.ntf;
                localObject1 = (Activity)this.mContext;
                localObject2 = this.xsE.nsh;
                ad.i("MicroMsg.SnsAdCardActionBtnCtrl", "jumpCardDetail, cardTpId=" + (String)localObject2 + ", cardExt=" + paramView);
                localObject3 = new Intent();
                ((Intent)localObject3).putExtra("key_card_id", (String)localObject2);
                ((Intent)localObject3).putExtra("key_card_ext", paramView);
                ((Intent)localObject3).putExtra("key_from_scene", 21);
                ((Intent)localObject3).putExtra("key_stastic_scene", 15);
                d.b((Context)localObject1, "card", ".ui.CardDetailUI", (Intent)localObject3);
                continue;
                localSnsAdClick.hsY = 33;
                try
                {
                  paramView = this.mContext;
                  localObject1 = this.xsE;
                  localObject2 = this.wvM;
                  i = this.xsz;
                  localObject3 = ((b.a)localObject1).wTV;
                  localObject4 = ((b.a)localObject1).oER;
                  if (!bt.T(new String[] { localObject3, localObject4 })) {
                    break label1374;
                  }
                  ad.e("MicroMsg.SnsAdCardActionBtnCtrl", "tempId or userName is null");
                }
                catch (Throwable paramView)
                {
                  ad.e("MicroMsg.SnsAdCardActionBtnCtrl", paramView.toString());
                }
                continue;
                label1374:
                ArrayList localArrayList = new ArrayList();
                localArrayList.add(((b.a)localObject1).wTV);
                paramView = g.a.a((String)localObject4, localArrayList, new g.b()
                {
                  public final void c(final SubscribeMsgRequestResult paramAnonymousSubscribeMsgRequestResult)
                  {
                    AppMethodBeat.i(179163);
                    if (paramAnonymousSubscribeMsgRequestResult == null)
                    {
                      aq.f(new Runnable()
                      {
                        public final void run()
                        {
                          AppMethodBeat.i(179161);
                          try
                          {
                            if (((ap.3.this.val$context instanceof Activity)) && (!((Activity)ap.3.this.val$context).isFinishing())) {
                              t.ci(ap.3.this.val$context, ap.3.this.wzX.wUa);
                            }
                            AppMethodBeat.o(179161);
                            return;
                          }
                          catch (Throwable localThrowable)
                          {
                            ad.e("MicroMsg.SnsAdCardActionBtnCtrl", localThrowable.toString());
                            AppMethodBeat.o(179161);
                          }
                        }
                      });
                      ad.e("MicroMsg.SnsAdCardActionBtnCtrl", "NetSceneSubscribeInfo result is null");
                      paramAnonymousSubscribeMsgRequestResult = new y(this.wzS, this.gXD, 0, -2);
                      com.tencent.mm.plugin.sns.k.b.a(this.xlw, i, paramAnonymousSubscribeMsgRequestResult);
                      AppMethodBeat.o(179163);
                      return;
                    }
                    aq.f(new Runnable()
                    {
                      public final void run()
                      {
                        AppMethodBeat.i(179162);
                        try
                        {
                          if (ap.3.this.val$context != null)
                          {
                            com.tencent.mm.ui.widget.a.e locale = new com.tencent.mm.ui.widget.a.e(ap.3.this.val$context, true, 0);
                            com.tencent.mm.plugin.sns.f.a locala = new com.tencent.mm.plugin.sns.f.a();
                            Context localContext = ap.3.this.val$context;
                            SubscribeMsgRequestResult localSubscribeMsgRequestResult = paramAnonymousSubscribeMsgRequestResult;
                            b.a locala1 = ap.3.this.wzX;
                            p localp = ap.3.this.xlw;
                            int i = ap.3.this.hQA;
                            ap.a locala2 = ap.c(ap.this);
                            String str1 = locala1.oER;
                            String str2 = locala1.wTV;
                            View localView = LayoutInflater.from(localContext).inflate(2131495530, null);
                            Object localObject1 = (TextView)localView.findViewById(2131306893);
                            Object localObject2 = (ImageView)localView.findViewById(2131306892);
                            Object localObject3 = (TextView)localView.findViewById(2131305527);
                            TextView localTextView = (TextView)localView.findViewById(2131305520);
                            Button localButton = (Button)localView.findViewById(2131305516);
                            String str3 = localSubscribeMsgRequestResult.appName;
                            String str4 = localSubscribeMsgRequestResult.hGe;
                            ((TextView)localObject1).setText(str3);
                            if (!TextUtils.equals((String)((ImageView)localObject2).getTag(2131304927), str4))
                            {
                              ((ImageView)localObject2).setImageDrawable(null);
                              if (!TextUtils.isEmpty(str4))
                              {
                                ad.d("HalfScreenSubscribeUtils", "loadImage, hash=" + localObject2.hashCode() + ", url=" + str4);
                                h.a(str4, new b.1((ImageView)localObject2, str4));
                              }
                            }
                            ((TextView)localObject3).setText(locala1.wTX);
                            localTextView.setText(locala1.wTY);
                            localButton.setText(locala1.wTZ);
                            localObject2 = (WeImageView)localView.findViewById(2131298360);
                            localObject1 = (Button)localView.findViewById(2131305516);
                            locala.wzP = false;
                            locale.GHn = new a.2(locala, str2, str1, localp, i);
                            ((WeImageView)localObject2).setOnClickListener(new a.3(locala, locale));
                            localObject2 = localSubscribeMsgRequestResult.hGg;
                            localObject3 = localSubscribeMsgRequestResult.buffer;
                            ((Button)localObject1).setOnClickListener(new a.4(locala, str1, (List)localObject2, locale, localContext, locala1, str2, localp, i, locala2, localSubscribeMsgRequestResult.hGj, (byte[])localObject3, com.tencent.mm.plugin.sns.k.b.fs((List)localObject2)));
                            locale.J(localView, true);
                            locale.ffu();
                            locale.csG();
                          }
                          AppMethodBeat.o(179162);
                          return;
                        }
                        catch (Throwable localThrowable)
                        {
                          ad.e("MicroMsg.SnsAdCardActionBtnCtrl", localThrowable.toString());
                          AppMethodBeat.o(179162);
                        }
                      }
                    });
                    AppMethodBeat.o(179163);
                  }
                }).dxb();
                com.tencent.mm.kernel.g.aeS().a(paramView, 0);
                com.tencent.mm.kernel.g.aeS().a(2920, this.wzQ);
              }
            }
          }
          catch (Throwable paramView)
          {
            for (;;)
            {
              bool1 = bool2;
            }
          }
        }
      }
    }
  }
  
  public static abstract interface a
  {
    public abstract void a(b.a parama);
  }
  
  public static abstract interface b
  {
    public abstract void dAh();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.ap
 * JD-Core Version:    0.7.0.1
 */