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
import com.tencent.mm.br.d;
import com.tencent.mm.modelsns.SnsAdClick;
import com.tencent.mm.platformtools.ab;
import com.tencent.mm.plugin.sns.data.j;
import com.tencent.mm.plugin.sns.model.AdLandingPagesProxy;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.a.g.a;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.a.e;
import com.tencent.mm.plugin.sns.storage.b.b;
import com.tencent.mm.plugin.sns.storage.e;
import com.tencent.mm.plugin.sns.storage.p;
import com.tencent.mm.plugin.sns.storage.x;
import com.tencent.mm.pluginsdk.l;
import com.tencent.mm.protocal.protobuf.TimeLineObject;
import com.tencent.mm.protocal.protobuf.zf;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ai;
import com.tencent.mm.sdk.platformtools.bs;
import com.tencent.mm.ui.widget.RoundedCornerFrameLayout;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public final class ap
  implements View.OnClickListener
{
  private String dnn;
  private String dtx;
  private View mContentView;
  private Context mContext;
  private p xHc;
  private com.tencent.mm.ak.g xMk;
  private String xOm;
  private int yFp;
  private RoundedCornerFrameLayout yFq;
  private ImageView yFr;
  private TextView yFs;
  private TextView yFt;
  private Button yFu;
  private View yFv;
  private b.b yFw;
  private b yFx;
  private ap.a yFy;
  public com.tencent.mm.plugin.sns.ad.d.i ywr;
  
  public ap(Context paramContext, View paramView, int paramInt, com.tencent.mm.plugin.sns.ad.d.i parami, b paramb)
  {
    AppMethodBeat.i(98296);
    this.xOm = "";
    this.dtx = "";
    this.dnn = "";
    this.xMk = new ap.1(this);
    this.yFy = new ap.a()
    {
      public final void a(b.b paramAnonymousb)
      {
        AppMethodBeat.i(179160);
        if ((ap.b(ap.this) != null) && (paramAnonymousb != null) && (!bs.isNullOrNil(paramAnonymousb.ygK)))
        {
          ap.b(ap.this).setTextColor(-7829368);
          ap.b(ap.this).setText(paramAnonymousb.ygK);
          ap.b(ap.this).setEnabled(false);
        }
        AppMethodBeat.o(179160);
      }
    };
    ac.d("MicroMsg.SnsAdCardActionBtnCtrl", "init, source=" + paramInt + ", context=" + paramContext + ", static=" + parami);
    this.mContext = paramContext;
    this.yFp = paramInt;
    this.ywr = parami;
    this.yFx = paramb;
    this.mContentView = paramView;
    this.yFv = this.mContentView.findViewById(2131302206);
    this.yFq = ((RoundedCornerFrameLayout)paramView.findViewById(2131307266));
    this.yFr = ((ImageView)paramView.findViewById(2131307265));
    this.yFs = ((TextView)paramView.findViewById(2131296391));
    this.yFt = ((TextView)paramView.findViewById(2131296361));
    this.yFu = ((Button)paramView.findViewById(2131296354));
    this.yFu.setOnClickListener(this);
    this.yFq.setRadius(com.tencent.mm.cc.a.fromDPToPix(this.mContext, 4));
    AppMethodBeat.o(98296);
  }
  
  private int a(String paramString1, String paramString2, String paramString3, SnsAdClick paramSnsAdClick)
  {
    AppMethodBeat.i(210271);
    ac.i("MicroMsg.SnsAdCardActionBtnCtrl", "handleDownload, appPageUrl=" + paramString3 + ", pkg=" + paramString2 + ", appId=" + paramString1);
    Object localObject = a.e.yhL;
    if (com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.a.bd(ai.getContext(), paramString2))
    {
      ac.i("MicroMsg.SnsAdCardActionBtnCtrl", "isPkgInstalled==true");
      if (this.xHc != null)
      {
        paramSnsAdClick = this.xHc.Pg(this.yFp);
        if (paramSnsAdClick != null) {
          this.dtx = bs.nullAsNil(paramSnsAdClick.dtx);
        }
      }
      j.a(this.mContext, paramString1, paramString2, "", paramString3, this.dtx, this.xOm, this.dnn, 0);
      if (!TextUtils.isEmpty(paramString3))
      {
        AppMethodBeat.o(210271);
        return 34;
      }
    }
    else
    {
      paramString3 = a.e.yhL;
      if (!com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.a.isApkExist(paramString1)) {
        break label187;
      }
      ac.i("MicroMsg.SnsAdCardActionBtnCtrl", "isApkExist==true");
      AdLandingPagesProxy.getInstance().installApp(this.mContext, paramString1, paramString2, "", "");
    }
    for (;;)
    {
      AppMethodBeat.o(210271);
      return 21;
      label187:
      boolean bool2 = false;
      boolean bool1 = bool2;
      if (this.xHc != null) {}
      try
      {
        paramString1 = this.xHc.Pg(this.yFp);
        bool1 = j.b(this.mContext, this.xHc, paramString1);
        if (!bool1)
        {
          paramString3 = this.xHc;
          paramString2 = (Activity)this.mContext;
          int i = this.yFp;
          localObject = this.yFv;
          StringBuilder localStringBuilder = new StringBuilder("jumpNativeLandingPageUIForDownload, snsId=");
          if (paramString3 == null) {}
          for (paramString1 = "";; paramString1 = com.tencent.mm.plugin.sns.data.q.wW(paramString3.field_snsId))
          {
            ac.i("MicroMsg.SnsAdCardActionBtnCtrl", paramString1);
            paramString1 = a(paramString3, paramString2, i, (View)localObject);
            if (paramString1 == null) {
              break label413;
            }
            this.yFx.dOE();
            paramString1.putExtra("sns_landing_pages_auto_download_for_action_btn", true);
            paramString1 = new com.tencent.mm.hellhoundlib.b.a().ba(paramString1);
            com.tencent.mm.hellhoundlib.a.a.a(paramString2, paramString1.aeD(), "com/tencent/mm/plugin/sns/ui/SnsAdCardActionBtnCtrl", "jumpNativeLandingPageUIForDownload", "(Lcom/tencent/mm/plugin/sns/storage/SnsInfo;Landroid/app/Activity;ILandroid/view/View;Lcom/tencent/mm/modelsns/SnsAdClick;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
            paramString2.startActivity((Intent)paramString1.lR(0));
            com.tencent.mm.hellhoundlib.a.a.a(paramString2, "com/tencent/mm/plugin/sns/ui/SnsAdCardActionBtnCtrl", "jumpNativeLandingPageUIForDownload", "(Lcom/tencent/mm/plugin/sns/storage/SnsInfo;Landroid/app/Activity;ILandroid/view/View;Lcom/tencent/mm/modelsns/SnsAdClick;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
            paramString2.overridePendingTransition(0, 0);
            break;
          }
          label413:
          a(paramString3, paramSnsAdClick, i, paramString2);
          continue;
        }
        AppMethodBeat.o(210271);
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
    if (com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.i.auO(paramp.dME().field_adxml))
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
      localIntent.putExtra("sns_landing_pages_rawSnsId", paramp.dLV().Id);
      localIntent.putExtra("sns_landing_pages_ux_info", paramp.dMD());
      localIntent.setClass(paramActivity, SnsAdNativeLandingPagesUI.class);
      if (paramInt == 2)
      {
        i = 16;
        localIntent.putExtra("sns_landig_pages_from_source", i);
        localIntent.putExtra("sns_landing_pages_xml", paramp.dME().field_adxml);
        localIntent.putExtra("sns_landing_pages_rec_src", paramp.dMF());
        localIntent.putExtra("sns_landing_pages_xml_prefix", "adxml");
        localIntent.putExtra("sns_landing_pages_need_enter_and_exit_animation", true);
        paramp = paramp.dLV();
        if ((paramp.FQo.Ety != 15) || (paramp.FQv == 1)) {
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
    ac.e("MicroMsg.SnsAdCardActionBtnCtrl", "adxml is invalid, snsId=" + com.tencent.mm.plugin.sns.data.q.wW(paramp.field_snsId));
    AppMethodBeat.o(98301);
    return null;
  }
  
  private static void a(p paramp, SnsAdClick paramSnsAdClick, int paramInt, Context paramContext)
  {
    AppMethodBeat.i(98299);
    String str2 = paramp.dMC();
    String str1 = str2;
    if (TextUtils.isEmpty(str2)) {
      str1 = paramp.dMB();
    }
    if (TextUtils.isEmpty(str1))
    {
      ac.e("MicroMsg.SnsAdCardActionBtnCtrl", "jumpUpdateWebUI both url is empty");
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
    ac.i("MicroMsg.SnsAdCardActionBtnCtrl", "jumpWebUI, url=" + paramString + ", source=" + paramInt + ", snsInfo=" + paramp);
    if ((TextUtils.isEmpty(paramString)) || (paramp == null))
    {
      AppMethodBeat.o(98300);
      return;
    }
    Intent localIntent = new Intent();
    boolean bool1;
    if (paramp.dFR().yfv == 0)
    {
      bool1 = true;
      if (!ab.ivP) {
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
        if (paramp.Pe(32))
        {
          com.tencent.mm.plugin.sns.storage.a locala = paramp.Pg(paramInt);
          str = paramString;
          if (locala != null)
          {
            localIntent.putExtra("KsnsViewId", locala.dyy);
            str = com.tencent.mm.plugin.sns.data.q.iV(paramString, locala.dtx);
            com.tencent.mm.plugin.sns.data.q.g(localIntent, locala.dtx);
          }
        }
      }
      localIntent.putExtra("KRightBtn", bool1);
      paramString = new Bundle();
      if (paramSnsAdClick != null) {
        paramString.putParcelable("KSnsAdTag", paramSnsAdClick);
      }
      paramString.putString("key_snsad_statextstr", paramp.dLV().yAj);
      localIntent.putExtra("jsapiargs", paramString);
      localIntent.putExtra("rawUrl", str);
      localIntent.putExtra("useJs", true);
      localIntent.putExtra("srcUsername", paramp.field_userName);
      localIntent.putExtra("stastic_scene", 15);
      localIntent.putExtra("KPublisherId", "sns_" + com.tencent.mm.plugin.sns.data.q.wW(paramp.field_snsId));
      localIntent.putExtra("pre_username", paramp.field_userName);
      localIntent.putExtra("prePublishId", "sns_" + com.tencent.mm.plugin.sns.data.q.wW(paramp.field_snsId));
      localIntent.putExtra("preUsername", paramp.field_userName);
      com.tencent.mm.plugin.sns.c.a.iyx.i(localIntent, paramContext);
      AppMethodBeat.o(98300);
      return;
      bool1 = false;
      break;
    }
  }
  
  public final void N(p paramp)
  {
    AppMethodBeat.i(98297);
    if (paramp == null)
    {
      ac.e("MicroMsg.SnsAdCardActionBtnCtrl", "refreshUI, snsInfo==null");
      AppMethodBeat.o(98297);
      return;
    }
    this.xHc = paramp;
    this.yFw = paramp.dFR().ygw;
    try
    {
      this.xOm = bs.nullAsNil(paramp.dFR().xOm);
      this.dnn = String.valueOf(j.asL(bs.nullAsNil(paramp.getSnsId())));
      if (this.yFw != null)
      {
        System.currentTimeMillis();
        if (!TextUtils.isEmpty(paramp.dFR().ygh))
        {
          Object localObject1 = com.tencent.mm.cf.g.eXw();
          this.yFs.getContext();
          localObject1 = ((com.tencent.mm.cf.g)localObject1).b(paramp.dFR().ygh, this.yFs.getTextSize());
          this.yFs.setText((CharSequence)localObject1);
          this.yFs.setVisibility(0);
          this.yFs.setTypeface(Typeface.defaultFromStyle(1));
          if (!TextUtils.isEmpty(paramp.dFR().ygi))
          {
            localObject1 = com.tencent.mm.cf.g.eXw();
            this.yFt.getContext();
            localObject1 = ((com.tencent.mm.cf.g)localObject1).b(paramp.dFR().ygi, this.yFt.getTextSize());
            this.yFt.setText((CharSequence)localObject1);
            this.yFt.setVisibility(0);
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
          this.yFu.setTextColor(this.mContext.getResources().getColor(2131100027));
          this.yFu.setEnabled(true);
          if (this.yFw.ygH != 2) {
            break;
          }
          if (TextUtils.isEmpty(this.yFu.getText().toString())) {
            this.yFu.setText(this.yFw.ygG);
          }
          new ap.c(this.yFu, this.yFw.ygR, this.yFw.ygQ, this.yFw.ygG).execute(new Void[0]);
          if (TextUtils.isEmpty(this.yFw.iconUrl)) {
            break label622;
          }
          this.yFq.setVisibility(0);
          com.tencent.mm.plugin.sns.ad.e.a.h(this.yFw.iconUrl, this.yFr);
          AppMethodBeat.o(98297);
          return;
          localThrowable1 = localThrowable1;
          ac.e("MicroMsg.SnsAdCardActionBtnCtrl", localThrowable1.toString());
          continue;
          this.yFt.setVisibility(8);
        }
        if (!TextUtils.isEmpty(paramp.dFR().ygi))
        {
          Object localObject2 = com.tencent.mm.cf.g.eXw();
          this.yFs.getContext();
          localObject2 = ((com.tencent.mm.cf.g)localObject2).b(paramp.dFR().ygi, this.yFs.getTextSize());
          this.yFs.setText((CharSequence)localObject2);
          this.yFs.setVisibility(0);
          this.yFs.setTypeface(Typeface.defaultFromStyle(0));
        }
        for (;;)
        {
          this.yFt.setVisibility(8);
          break;
          this.yFs.setVisibility(8);
        }
      }
      catch (Throwable localThrowable2)
      {
        for (;;)
        {
          ac.e("MicroMsg.SnsAdCardActionBtnCtrl", localThrowable2.toString());
          continue;
          if (this.yFw.ygH == 6)
          {
            try
            {
              paramp = com.tencent.mm.plugin.sns.data.q.wW(paramp.field_snsId);
              if (bs.isNullOrNil(paramp)) {
                continue;
              }
              if (!"1".equals(x.avs(paramp))) {
                break label588;
              }
              this.yFu.setTextColor(-7829368);
              this.yFu.setText(this.yFw.ygK);
              this.yFu.setEnabled(false);
            }
            catch (Throwable paramp)
            {
              ac.e("MicroMsg.SnsAdCardActionBtnCtrl", paramp.toString());
            }
            continue;
            label588:
            this.yFu.setText(this.yFw.ygG);
          }
          else
          {
            this.yFu.setText(this.yFw.ygG);
          }
        }
        label622:
        this.yFq.setVisibility(8);
      }
      AppMethodBeat.o(98297);
    }
  }
  
  public final void onClick(View paramView)
  {
    int i = 1;
    AppMethodBeat.i(98298);
    if (this.yFw == null)
    {
      ac.e("MicroMsg.SnsAdCardActionBtnCtrl", "onClick mActionBtnInfo==null");
      AppMethodBeat.o(98298);
      return;
    }
    for (;;)
    {
      SnsAdClick localSnsAdClick;
      Object localObject3;
      try
      {
        int j = this.yFp;
        if (this.yFp == 0)
        {
          localSnsAdClick = new SnsAdClick(j, i, this.xHc.field_snsId, 26, 0);
          j.a(localSnsAdClick, this.ywr, this.xHc, 26);
        }
        try
        {
          ac.i("MicroMsg.SnsAdCardActionBtnCtrl", "onClick, type=" + this.yFw.ygH + ", snsId=" + com.tencent.mm.plugin.sns.data.q.wW(this.xHc.field_snsId));
          switch (this.yFw.ygH)
          {
          case 3: 
            ac.i("MicroMsg.SnsAdCardActionBtnCtrl", "clickAction=" + localSnsAdClick.hTA);
          }
        }
        catch (Exception paramView)
        {
          ac.e("MicroMsg.SnsAdCardActionBtnCtrl", "onClick exp=" + paramView.toString());
          continue;
        }
        com.tencent.mm.plugin.sns.data.q.a(localSnsAdClick);
        AppMethodBeat.o(98298);
        return;
        i = 2;
        continue;
        localSnsAdClick.hTA = 21;
        localObject1 = this.xHc;
        paramView = (Activity)this.mContext;
        i = this.yFp;
        localObject2 = this.yFv;
        localObject3 = new StringBuilder("jumpNativeLandingPageUI, snsId=");
        if (localObject1 == null)
        {
          l = 0L;
          ac.i("MicroMsg.SnsAdCardActionBtnCtrl", l);
          localObject1 = a((p)localObject1, paramView, i, (View)localObject2);
          if (localObject1 == null) {
            break label468;
          }
          this.yFx.dOE();
          localObject1 = new com.tencent.mm.hellhoundlib.b.a().ba(localObject1);
          com.tencent.mm.hellhoundlib.a.a.a(paramView, ((com.tencent.mm.hellhoundlib.b.a)localObject1).aeD(), "com/tencent/mm/plugin/sns/ui/SnsAdCardActionBtnCtrl", "jumpNativeLandingPageUI", "(Lcom/tencent/mm/plugin/sns/storage/SnsInfo;Landroid/app/Activity;ILandroid/view/View;Lcom/tencent/mm/modelsns/SnsAdClick;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
          paramView.startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject1).lR(0));
          com.tencent.mm.hellhoundlib.a.a.a(paramView, "com/tencent/mm/plugin/sns/ui/SnsAdCardActionBtnCtrl", "jumpNativeLandingPageUI", "(Lcom/tencent/mm/plugin/sns/storage/SnsInfo;Landroid/app/Activity;ILandroid/view/View;Lcom/tencent/mm/modelsns/SnsAdClick;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
          paramView.overridePendingTransition(0, 0);
          continue;
        }
        long l = ((p)localObject1).field_snsId;
      }
      catch (Exception paramView)
      {
        ac.e("MicroMsg.SnsAdCardActionBtnCtrl", "onClick report exp=" + paramView.toString());
        AppMethodBeat.o(98298);
        return;
      }
      continue;
      label468:
      a(this.xHc, localSnsAdClick, this.yFp, this.mContext);
      continue;
      localSnsAdClick.hTA = 0;
      a(this.yFw.ygI, this.xHc, localSnsAdClick, this.yFp, this.mContext);
      continue;
      localSnsAdClick.hTA = 31;
      com.tencent.mm.plugin.sns.ui.d.b.a(this.yFw.pis, this.yFw.hlj, this.yFw.hlk, this.xHc, this.yFp);
      continue;
      localSnsAdClick.hTA = a(this.yFw.ygQ, this.yFw.ygR, this.yFw.yfc, localSnsAdClick);
      continue;
      localSnsAdClick.hTA = 32;
      a(this.yFw.ygI, this.xHc, localSnsAdClick, this.yFp, this.mContext);
      continue;
      localSnsAdClick.hTA = 11;
      Object localObject2 = this.xHc.dFQ();
      Object localObject1 = "";
      paramView = (View)localObject1;
      if (localObject2 != null)
      {
        paramView = (View)localObject1;
        if (((com.tencent.mm.plugin.sns.storage.a)localObject2).yeQ != null) {
          paramView = (String)((com.tencent.mm.plugin.sns.storage.a)localObject2).yeQ.get(this.yFw.nVh);
        }
      }
      if (TextUtils.isEmpty(paramView))
      {
        ac.e("MicroMsg.SnsAdCardActionBtnCtrl", "cardExt is not found in adInfo, tpid=" + this.yFw.nVh);
        paramView = this.yFw.nWf;
      }
      for (;;)
      {
        String str;
        for (;;)
        {
          localObject1 = (Activity)this.mContext;
          localObject2 = this.yFw.nVh;
          ac.i("MicroMsg.SnsAdCardActionBtnCtrl", "jumpCardDetail, cardTpId=" + (String)localObject2 + ", cardExt=" + paramView);
          localObject3 = new Intent();
          ((Intent)localObject3).putExtra("key_card_id", (String)localObject2);
          ((Intent)localObject3).putExtra("key_card_ext", paramView);
          ((Intent)localObject3).putExtra("key_from_scene", 21);
          ((Intent)localObject3).putExtra("key_stastic_scene", 15);
          d.b((Context)localObject1, "card", ".ui.CardDetailUI", (Intent)localObject3);
          break;
          localSnsAdClick.hTA = 33;
          try
          {
            paramView = this.mContext;
            localObject1 = this.yFw;
            localObject2 = this.xHc;
            i = this.yFp;
            localObject3 = ((b.b)localObject1).ygJ;
            str = ((b.b)localObject1).pis;
            if (!bs.T(new String[] { localObject3, str })) {
              break label953;
            }
            ac.e("MicroMsg.SnsAdCardActionBtnCtrl", "tempId or userName is null");
          }
          catch (Throwable paramView)
          {
            ac.e("MicroMsg.SnsAdCardActionBtnCtrl", paramView.toString());
          }
        }
        break;
        label953:
        ArrayList localArrayList = new ArrayList();
        localArrayList.add(((b.b)localObject1).ygJ);
        paramView = g.a.a(str, localArrayList, new ap.3(this, paramView, (b.b)localObject1, (String)localObject3, str, (p)localObject2, i)).dLA();
        com.tencent.mm.kernel.g.agi().a(paramView, 0);
        com.tencent.mm.kernel.g.agi().a(2920, this.xMk);
        break;
      }
    }
  }
  
  public static abstract interface b
  {
    public abstract void dOE();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.ap
 * JD-Core Version:    0.7.0.1
 */