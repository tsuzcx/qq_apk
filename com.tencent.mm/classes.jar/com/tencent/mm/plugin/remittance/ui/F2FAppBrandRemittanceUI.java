package com.tencent.mm.plugin.remittance.ui;

import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.text.TextPaint;
import android.view.View;
import android.view.Window;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.appcompat.app.ActionBar;
import androidx.lifecycle.q;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.s;
import com.tencent.mm.autogen.a.az;
import com.tencent.mm.model.z;
import com.tencent.mm.platformtools.r;
import com.tencent.mm.platformtools.r.a;
import com.tencent.mm.plugin.collect.model.b;
import com.tencent.mm.plugin.wxpay.a.f;
import com.tencent.mm.plugin.wxpay.a.g;
import com.tencent.mm.plugin.wxpay.a.i;
import com.tencent.mm.protocal.protobuf.xl;
import com.tencent.mm.sdk.event.IListener;
import com.tencent.mm.sdk.platformtools.BackwardSupportUtil.BitmapFactory;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.f.g.a;
import com.tencent.mm.ui.widget.a.e;
import com.tencent.mm.ui.widget.a.g.a;
import com.tencent.mm.ui.widget.a.g.c;
import com.tencent.mm.ui.widget.a.j;
import com.tencent.mm.ui.widget.a.j.a;
import com.tencent.mm.wallet_core.ui.k;

@com.tencent.mm.ui.base.a(3)
public class F2FAppBrandRemittanceUI
  extends MMActivity
  implements com.tencent.mm.am.h
{
  private Bitmap MAx;
  private String Olb;
  private ImageView Olc;
  private String app_id;
  private e pjp;
  private IListener<az> vrs;
  private j xcO;
  private r.a xdZ;
  
  public F2FAppBrandRemittanceUI()
  {
    AppMethodBeat.i(289022);
    this.app_id = "";
    this.Olb = "";
    this.vrs = new IListener(com.tencent.mm.app.f.hfK) {};
    this.xdZ = new r.a()
    {
      public final void k(String paramAnonymousString, Bitmap paramAnonymousBitmap) {}
    };
    AppMethodBeat.o(289022);
  }
  
  private void a(Enum paramEnum, String paramString)
  {
    AppMethodBeat.i(289033);
    Log.i("MicroMsg.F2FAppBrandRemittanceUI", "setActivityResultData result :%s , errmsg : %s", new Object[] { paramEnum, paramString });
    Intent localIntent = new Intent();
    localIntent.putExtra("key_result_pay_result", paramEnum);
    localIntent.putExtra("key_result_error_msg", paramString);
    setResult(-1, localIntent);
    finish();
    AppMethodBeat.o(289033);
  }
  
  private void aoP(String paramString)
  {
    AppMethodBeat.i(289029);
    Log.i("MicroMsg.F2FAppBrandRemittanceUI", "showErrorDialog,errMsg:%s", new Object[] { paramString });
    g.a locala = new g.a(getContext());
    locala.bf("");
    paramString = locala.bDE(paramString).NF(true);
    paramString.Xdm = true;
    paramString.aEX(a.i.welcome_i_know).b(new g.c()
    {
      public final void onDialogClick(boolean paramAnonymousBoolean, String paramAnonymousString) {}
    }).show();
    if (locala.pRv != null) {
      this.pjp = locala.pRv;
    }
    AppMethodBeat.o(289029);
  }
  
  public int getLayoutId()
  {
    return -1;
  }
  
  public void onBackPressed()
  {
    AppMethodBeat.i(289061);
    a(f.g.a.adwk, "");
    super.onBackPressed();
    AppMethodBeat.o(289061);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(289047);
    Log.i("MicroMsg.F2FAppBrandRemittanceUI", "onCreate（）");
    super.onCreate(paramBundle);
    overridePendingTransition(0, 0);
    getWindow().setFlags(1024, 1024);
    if (getSupportActionBar() != null) {
      getSupportActionBar().hide();
    }
    this.app_id = getIntent().getStringExtra("key_app_id");
    this.Olb = getIntent().getStringExtra("key_confirm_id");
    if (Util.isNullOrNil(this.Olb)) {
      a(f.g.a.adwj, "confirm_id is empty");
    }
    com.tencent.mm.kernel.h.aZW().a(2850, this);
    paramBundle = new com.tencent.mm.plugin.remittance.model.p(this.Olb, this.app_id);
    com.tencent.mm.kernel.h.aZW().a(paramBundle, 0);
    AppMethodBeat.o(289047);
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(289050);
    Log.i("MicroMsg.F2FAppBrandRemittanceUI", "onDestroy()");
    super.onDestroy();
    if (this.Olc != null) {
      this.Olc.setImageBitmap(null);
    }
    Bitmap localBitmap = this.MAx;
    if ((localBitmap != null) && (!localBitmap.isRecycled()))
    {
      Log.i("MicroMsg.F2FAppBrandRemittanceUI", "bitmap recycle %s", new Object[] { localBitmap });
      localBitmap.recycle();
    }
    r.c(this.xdZ);
    this.vrs.dead();
    com.tencent.mm.kernel.h.aZW().b(2850, this);
    AppMethodBeat.o(289050);
  }
  
  public void onPause()
  {
    AppMethodBeat.i(289070);
    super.onPause();
    Log.i("MicroMsg.F2FAppBrandRemittanceUI", "onPause()");
    AppMethodBeat.o(289070);
  }
  
  public void onResume()
  {
    AppMethodBeat.i(289066);
    super.onResume();
    Log.i("MicroMsg.F2FAppBrandRemittanceUI", "onResume()");
    AppMethodBeat.o(289066);
  }
  
  public void onSceneEnd(int paramInt1, int paramInt2, final String paramString, com.tencent.mm.am.p paramp)
  {
    AppMethodBeat.i(289059);
    Log.i("MicroMsg.F2FAppBrandRemittanceUI", "on Scene End：errType %s , errCode：%s，errMsg:%s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramString });
    if ((paramp instanceof com.tencent.mm.plugin.remittance.model.p))
    {
      if ((paramInt1 == 0) && (paramInt2 == 0))
      {
        paramString = (com.tencent.mm.plugin.remittance.model.p)paramp;
        if (paramString.Ojb == null) {}
        for (paramString = new xl();; paramString = paramString.Ojb)
        {
          Log.i("MicroMsg.F2FAppBrandRemittanceUI", "NetSceneF2FMinniProgramConfirm on SceneEnd ok，retcode:%s, retMsg：%s", new Object[] { Integer.valueOf(paramString.hAV), paramString.wYI });
          if (paramString.hAV != 0) {
            break label560;
          }
          Log.i("MicroMsg.F2FAppBrandRemittanceUI", "showHalfDialog");
          if ((paramString != null) && (!Util.isNullOrNil(paramString.hSC))) {
            break;
          }
          Log.i("MicroMsg.F2FAppBrandRemittanceUI", "res == null || Util.isNullOrNil(res.qrcode)");
          a(f.g.a.adwj, "get qrcode fail");
          AppMethodBeat.o(289059);
          return;
        }
        com.tencent.mm.plugin.report.service.h.OAn.b(19821, new Object[] { Integer.valueOf(1), this.app_id, Integer.valueOf(0) });
        this.xcO = new j(getContext(), 2, 3);
        paramp = View.inflate(getContext(), a.g.f2f_app_brand_remittance_head, null);
        ((ImageView)paramp.findViewById(a.f.back_cion)).setOnClickListener(new k()
        {
          public final void dr(View paramAnonymousView)
          {
            AppMethodBeat.i(289125);
            F2FAppBrandRemittanceUI.b(F2FAppBrandRemittanceUI.this).cyW();
            F2FAppBrandRemittanceUI.c(F2FAppBrandRemittanceUI.this);
            F2FAppBrandRemittanceUI.a(F2FAppBrandRemittanceUI.this, f.g.a.adwk, "");
            com.tencent.mm.plugin.report.service.h.OAn.b(19821, new Object[] { Integer.valueOf(3), F2FAppBrandRemittanceUI.a(F2FAppBrandRemittanceUI.this), Integer.valueOf(0) });
            AppMethodBeat.o(289125);
          }
        });
        Object localObject = (TextView)paramp.findViewById(a.f.f2f_app_brand_title);
        ((TextView)localObject).setText(paramString.title);
        ((TextView)localObject).getPaint().setFakeBoldText(true);
        this.xcO.setHeaderView(paramp);
        paramp = View.inflate(getContext(), a.g.f2f_app_brand_remittance_content, null);
        this.Olc = ((ImageView)paramp.findViewById(a.f.f2f_app_brand_qrcode));
        this.Olc.setImageBitmap(null);
        if (Util.isNullOrNil(paramString.Zga))
        {
          Log.i("MicroMsg.F2FAppBrandRemittanceUI", "qrcode： res.head_img null");
          if ((this.MAx == null) || (this.MAx.isRecycled())) {
            break label549;
          }
          this.Olc.setImageBitmap(this.MAx);
        }
        for (;;)
        {
          ((TextView)paramp.findViewById(a.f.f2f_app_brand_tips)).setText(paramString.Zgb);
          localObject = (TextView)paramp.findViewById(a.f.f2f_app_brand_username);
          ((TextView)localObject).setText(paramString.Zgc);
          ((TextView)localObject).getPaint().setFakeBoldText(true);
          this.xcO.setCustomView(paramp);
          this.xcO.au(paramString.Zgd);
          this.xcO.aFe(0);
          this.xcO.agfR = new j.a()
          {
            public final void onClick()
            {
              AppMethodBeat.i(289135);
              Log.i("MicroMsg.F2FAppBrandRemittanceUI", "go to remittaneUI");
              F2FAppBrandRemittanceUI.d(F2FAppBrandRemittanceUI.this).alive();
              com.tencent.mm.plugin.wallet.a locala = new com.tencent.mm.plugin.wallet.a();
              locala.UYV = F2FAppBrandRemittanceUI.a(F2FAppBrandRemittanceUI.this);
              com.tencent.mm.pluginsdk.wallet.f.a(F2FAppBrandRemittanceUI.this.getContext(), 1, paramString.hSC, 56, locala);
              com.tencent.mm.plugin.report.service.h.OAn.b(19821, new Object[] { Integer.valueOf(2), F2FAppBrandRemittanceUI.a(F2FAppBrandRemittanceUI.this), Integer.valueOf(0) });
              AppMethodBeat.o(289135);
            }
          };
          this.xcO.dDn();
          AppMethodBeat.o(289059);
          return;
          localObject = paramString.hSC;
          String str = paramString.Zga;
          Log.i("MicroMsg.F2FAppBrandRemittanceUI", "contentUrl： %s ， headUrl：%s", new Object[] { localObject, str });
          paramInt1 = BackwardSupportUtil.BitmapFactory.fromDPToPix(this, 197.0F);
          this.MAx = b.a(this, (String)localObject, z.bAM(), 1, str, paramInt1, this.xdZ, false, 1, 2.0F, false);
          break;
          label549:
          Log.i("MicroMsg.F2FAppBrandRemittanceUI", "qrcode： bmp null ");
        }
        label560:
        aoP(paramString.wYI);
        AppMethodBeat.o(289059);
        return;
      }
      Log.i("MicroMsg.F2FAppBrandRemittanceUI", "NetSceneF2FMinniProgramConfirm on SceneEnd faile show error dialog ");
      aoP(paramString);
    }
    AppMethodBeat.o(289059);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    AppMethodBeat.i(289064);
    AppMethodBeat.at(this, paramBoolean);
    Log.i("MicroMsg.F2FAppBrandRemittanceUI", "onWindowFocusChanged");
    if ((this.xcO != null) && (!this.xcO.isShowing()))
    {
      Log.i("MicroMsg.F2FAppBrandRemittanceUI", "onWindowFocusChanged：mHalfBottomDialog isShowHalfDialog %s, finish Activity", new Object[] { Boolean.valueOf(this.xcO.isShowing()) });
      this.xcO = null;
      a(f.g.a.adwk, "");
      com.tencent.mm.plugin.report.service.h.OAn.b(19821, new Object[] { Integer.valueOf(3), this.app_id, Integer.valueOf(0) });
    }
    if ((this.pjp != null) && (!this.pjp.isShowing()))
    {
      Log.i("MicroMsg.F2FAppBrandRemittanceUI", "onWindowFocusChanged isShowing:%s,finish Activity", new Object[] { Boolean.valueOf(this.pjp.isShowing()) });
      this.pjp = null;
      a(f.g.a.adwj, "get qrcode fail");
    }
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.o(289064);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.remittance.ui.F2FAppBrandRemittanceUI
 * JD-Core Version:    0.7.0.1
 */