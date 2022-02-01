package com.tencent.mm.plugin.remittance.ui;

import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.text.TextPaint;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.n;
import com.tencent.mm.al.q;
import com.tencent.mm.g.a.aq;
import com.tencent.mm.platformtools.u.a;
import com.tencent.mm.plugin.remittance.model.m;
import com.tencent.mm.protocal.protobuf.ui;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.BackwardSupportUtil.b;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.e.d.a;
import com.tencent.mm.ui.widget.a.d;
import com.tencent.mm.ui.widget.a.f.a;
import com.tencent.mm.ui.widget.a.f.c;
import com.tencent.mm.ui.widget.a.g.a;

@com.tencent.mm.ui.base.a(3)
public class F2FAppBrandRemittanceUI
  extends MMActivity
  implements com.tencent.mm.al.f
{
  private String app_id;
  private d iKm;
  private com.tencent.mm.ui.widget.a.g peB;
  private u.a pfJ;
  private Bitmap wzC;
  private String xZI;
  private ImageView xZJ;
  private c<aq> xZK;
  
  public F2FAppBrandRemittanceUI()
  {
    AppMethodBeat.i(199136);
    this.app_id = "";
    this.xZI = "";
    this.xZK = new c() {};
    this.pfJ = new u.a()
    {
      public final void k(String paramAnonymousString, Bitmap paramAnonymousBitmap) {}
    };
    AppMethodBeat.o(199136);
  }
  
  private void a(Enum paramEnum, String paramString)
  {
    AppMethodBeat.i(199142);
    ad.i("MicroMsg.F2FAppBrandRemittanceUI", "setActivityResultData result :%s , errmsg : %s", new Object[] { paramEnum, paramString });
    Intent localIntent = new Intent();
    localIntent.putExtra("key_result_pay_result", paramEnum);
    localIntent.putExtra("key_result_error_msg", paramString);
    setResult(-1, localIntent);
    finish();
    AppMethodBeat.o(199142);
  }
  
  private void abY(String paramString)
  {
    AppMethodBeat.i(199140);
    ad.i("MicroMsg.F2FAppBrandRemittanceUI", "showErrorDialog,errMsg:%s", new Object[] { paramString });
    f.a locala = new f.a(getContext());
    locala.av("");
    paramString = locala.aXO(paramString).yU(true);
    paramString.EgK = true;
    paramString.afp(2131766205).b(new f.c()
    {
      public final void d(boolean paramAnonymousBoolean, String paramAnonymousString) {}
    }).show();
    if (locala.jcs != null) {
      this.iKm = locala.jcs;
    }
    AppMethodBeat.o(199140);
  }
  
  public int getLayoutId()
  {
    return -1;
  }
  
  public void onBackPressed()
  {
    AppMethodBeat.i(199141);
    a(e.d.a.IUs, "");
    super.onBackPressed();
    AppMethodBeat.o(199141);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(199137);
    ad.i("MicroMsg.F2FAppBrandRemittanceUI", "onCreate（）");
    super.onCreate(paramBundle);
    overridePendingTransition(0, 0);
    getWindow().setFlags(1024, 1024);
    if (getSupportActionBar() != null) {
      getSupportActionBar().hide();
    }
    this.app_id = getIntent().getStringExtra("key_app_id");
    this.xZI = getIntent().getStringExtra("key_confirm_id");
    if (bt.isNullOrNil(this.xZI)) {
      a(e.d.a.IUr, "confirm_id is empty");
    }
    com.tencent.mm.kernel.g.aiU().a(2850, this);
    paramBundle = new m(this.xZI, this.app_id);
    com.tencent.mm.kernel.g.aiU().a(paramBundle, 0);
    AppMethodBeat.o(199137);
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(199138);
    ad.i("MicroMsg.F2FAppBrandRemittanceUI", "onDestroy()");
    super.onDestroy();
    if (this.xZJ != null) {
      this.xZJ.setImageBitmap(null);
    }
    Bitmap localBitmap = this.wzC;
    if ((localBitmap != null) && (!localBitmap.isRecycled()))
    {
      ad.i("MicroMsg.F2FAppBrandRemittanceUI", "bitmap recycle %s", new Object[] { localBitmap });
      localBitmap.recycle();
    }
    com.tencent.mm.platformtools.u.c(this.pfJ);
    this.xZK.dead();
    com.tencent.mm.kernel.g.aiU().b(2850, this);
    AppMethodBeat.o(199138);
  }
  
  public void onPause()
  {
    AppMethodBeat.i(199145);
    super.onPause();
    ad.i("MicroMsg.F2FAppBrandRemittanceUI", "onPause()");
    AppMethodBeat.o(199145);
  }
  
  public void onResume()
  {
    AppMethodBeat.i(199144);
    super.onResume();
    ad.i("MicroMsg.F2FAppBrandRemittanceUI", "onResume()");
    AppMethodBeat.o(199144);
  }
  
  public void onSceneEnd(int paramInt1, int paramInt2, final String paramString, n paramn)
  {
    AppMethodBeat.i(199139);
    ad.i("MicroMsg.F2FAppBrandRemittanceUI", "on Scene End：errType %s , errCode：%s，errMsg:%s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramString });
    if ((paramn instanceof m))
    {
      if ((paramInt1 == 0) && (paramInt2 == 0))
      {
        paramString = (m)paramn;
        if (paramString.xYa == null) {}
        for (paramString = new ui();; paramString = paramString.xYa)
        {
          ad.i("MicroMsg.F2FAppBrandRemittanceUI", "NetSceneF2FMinniProgramConfirm on SceneEnd ok，retcode:%s, retMsg：%s", new Object[] { Integer.valueOf(paramString.dlw), paramString.paA });
          if (paramString.dlw != 0) {
            break label537;
          }
          ad.i("MicroMsg.F2FAppBrandRemittanceUI", "showHalfDialog");
          if ((paramString != null) && (!bt.isNullOrNil(paramString.dAD))) {
            break;
          }
          ad.i("MicroMsg.F2FAppBrandRemittanceUI", "res == null || Util.isNullOrNil(res.qrcode)");
          a(e.d.a.IUr, "get qrcode fail");
          AppMethodBeat.o(199139);
          return;
        }
        com.tencent.mm.plugin.report.service.g.yhR.f(19821, new Object[] { Integer.valueOf(1), this.app_id, Integer.valueOf(0) });
        this.peB = new com.tencent.mm.ui.widget.a.g(getContext(), 2, 3);
        paramn = View.inflate(getContext(), 2131496151, null);
        ((ImageView)paramn.findViewById(2131307151)).setOnClickListener(new View.OnClickListener()
        {
          public final void onClick(View paramAnonymousView)
          {
            AppMethodBeat.i(199134);
            com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
            localb.bd(paramAnonymousView);
            com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/remittance/ui/F2FAppBrandRemittanceUI$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahq());
            F2FAppBrandRemittanceUI.b(F2FAppBrandRemittanceUI.this).bpT();
            F2FAppBrandRemittanceUI.c(F2FAppBrandRemittanceUI.this);
            F2FAppBrandRemittanceUI.a(F2FAppBrandRemittanceUI.this, e.d.a.IUs, "");
            com.tencent.mm.plugin.report.service.g.yhR.f(19821, new Object[] { Integer.valueOf(3), F2FAppBrandRemittanceUI.a(F2FAppBrandRemittanceUI.this), Integer.valueOf(0) });
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/remittance/ui/F2FAppBrandRemittanceUI$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(199134);
          }
        });
        Object localObject = (TextView)paramn.findViewById(2131307189);
        ((TextView)localObject).setText(paramString.title);
        ((TextView)localObject).getPaint().setFakeBoldText(true);
        this.peB.setHeaderView(paramn);
        paramn = View.inflate(getContext(), 2131496150, null);
        this.xZJ = ((ImageView)paramn.findViewById(2131307186));
        this.xZJ.setImageBitmap(null);
        if (bt.isNullOrNil(paramString.FTD))
        {
          ad.i("MicroMsg.F2FAppBrandRemittanceUI", "qrcode： res.head_img null");
          if ((this.wzC == null) || (this.wzC.isRecycled())) {
            break label526;
          }
          this.xZJ.setImageBitmap(this.wzC);
        }
        for (;;)
        {
          ((TextView)paramn.findViewById(2131307188)).setText(paramString.FTE);
          localObject = (TextView)paramn.findViewById(2131307190);
          ((TextView)localObject).setText(paramString.FTF);
          ((TextView)localObject).getPaint().setFakeBoldText(true);
          this.peB.setCustomView(paramn);
          this.peB.ax(paramString.FTG);
          this.peB.afs(0);
          this.peB.KXB = new g.a()
          {
            public final void onClick()
            {
              AppMethodBeat.i(199135);
              ad.i("MicroMsg.F2FAppBrandRemittanceUI", "go to remittaneUI");
              F2FAppBrandRemittanceUI.d(F2FAppBrandRemittanceUI.this).alive();
              com.tencent.mm.plugin.wallet.a locala = new com.tencent.mm.plugin.wallet.a();
              locala.Cwr = F2FAppBrandRemittanceUI.a(F2FAppBrandRemittanceUI.this);
              com.tencent.mm.pluginsdk.wallet.f.a(F2FAppBrandRemittanceUI.this.getContext(), 1, paramString.dAD, 56, locala);
              com.tencent.mm.plugin.report.service.g.yhR.f(19821, new Object[] { Integer.valueOf(2), F2FAppBrandRemittanceUI.a(F2FAppBrandRemittanceUI.this), Integer.valueOf(0) });
              AppMethodBeat.o(199135);
            }
          };
          this.peB.cMW();
          AppMethodBeat.o(199139);
          return;
          localObject = paramString.dAD;
          String str = paramString.FTD;
          paramInt1 = BackwardSupportUtil.b.g(this, 197.0F);
          this.wzC = com.tencent.mm.plugin.collect.model.b.a(this, (String)localObject, com.tencent.mm.model.u.aAm(), 1, str, paramInt1, this.pfJ, false, 1, 2.0F);
          break;
          label526:
          ad.i("MicroMsg.F2FAppBrandRemittanceUI", "qrcode： bmp null ");
        }
        label537:
        abY(paramString.paA);
        AppMethodBeat.o(199139);
        return;
      }
      ad.i("MicroMsg.F2FAppBrandRemittanceUI", "NetSceneF2FMinniProgramConfirm on SceneEnd faile show error dialog ");
      abY(paramString);
    }
    AppMethodBeat.o(199139);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    AppMethodBeat.i(199143);
    ad.i("MicroMsg.F2FAppBrandRemittanceUI", "onWindowFocusChanged");
    if ((this.peB != null) && (!this.peB.isShowing()))
    {
      ad.i("MicroMsg.F2FAppBrandRemittanceUI", "onWindowFocusChanged：mHalfBottomDialog isShowHalfDialog %s, finish Activity", new Object[] { Boolean.valueOf(this.peB.isShowing()) });
      this.peB = null;
      a(e.d.a.IUs, "");
      com.tencent.mm.plugin.report.service.g.yhR.f(19821, new Object[] { Integer.valueOf(3), this.app_id, Integer.valueOf(0) });
    }
    if ((this.iKm != null) && (!this.iKm.isShowing()))
    {
      ad.i("MicroMsg.F2FAppBrandRemittanceUI", "onWindowFocusChanged isShowing:%s,finish Activity", new Object[] { Boolean.valueOf(this.iKm.isShowing()) });
      this.iKm = null;
      a(e.d.a.IUr, "get qrcode fail");
    }
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
    AppMethodBeat.o(199143);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.remittance.ui.F2FAppBrandRemittanceUI
 * JD-Core Version:    0.7.0.1
 */