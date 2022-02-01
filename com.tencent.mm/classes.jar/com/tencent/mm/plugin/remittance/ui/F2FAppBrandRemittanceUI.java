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
import com.tencent.mm.g.a.ap;
import com.tencent.mm.platformtools.u.a;
import com.tencent.mm.plugin.collect.model.b;
import com.tencent.mm.plugin.remittance.model.m;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.pluginsdk.wallet.f;
import com.tencent.mm.protocal.protobuf.sd;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.BackwardSupportUtil.b;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.a;
import com.tencent.mm.ui.e.d.a;
import com.tencent.mm.ui.widget.a.d;
import com.tencent.mm.ui.widget.a.f.a;
import com.tencent.mm.ui.widget.a.f.c;
import com.tencent.mm.ui.widget.a.g.a;

@a(3)
public class F2FAppBrandRemittanceUI
  extends MMActivity
  implements com.tencent.mm.al.g
{
  private String app_id;
  private d hRe;
  private com.tencent.mm.ui.widget.a.g nXL;
  private u.a nYT;
  private Bitmap uln;
  private String vBW;
  private ImageView vBX;
  private c<ap> vBY;
  
  public F2FAppBrandRemittanceUI()
  {
    AppMethodBeat.i(187060);
    this.app_id = "";
    this.vBW = "";
    this.vBY = new c() {};
    this.nYT = new u.a()
    {
      public final void l(String paramAnonymousString, Bitmap paramAnonymousBitmap) {}
    };
    AppMethodBeat.o(187060);
  }
  
  private void Ug(String paramString)
  {
    AppMethodBeat.i(187064);
    ad.i("MicroMsg.F2FAppBrandRemittanceUI", "showErrorDialog,errMsg:%s", new Object[] { paramString });
    f.a locala = new f.a(getContext());
    locala.au("");
    paramString = locala.aMo(paramString).wZ(true);
    paramString.HFB = true;
    paramString.aaF(2131766205).b(new f.c()
    {
      public final void d(boolean paramAnonymousBoolean, String paramAnonymousString) {}
    }).show();
    if (locala.ijc != null) {
      this.hRe = locala.ijc;
    }
    AppMethodBeat.o(187064);
  }
  
  private void a(Enum paramEnum, String paramString)
  {
    AppMethodBeat.i(187066);
    ad.i("MicroMsg.F2FAppBrandRemittanceUI", "setActivityResultData result :%s , errmsg : %s", new Object[] { paramEnum, paramString });
    Intent localIntent = new Intent();
    localIntent.putExtra("key_result_pay_result", paramEnum);
    localIntent.putExtra("key_result_error_msg", paramString);
    setResult(-1, localIntent);
    finish();
    AppMethodBeat.o(187066);
  }
  
  public int getLayoutId()
  {
    return -1;
  }
  
  public void onBackPressed()
  {
    AppMethodBeat.i(187065);
    a(e.d.a.FHU, "");
    super.onBackPressed();
    AppMethodBeat.o(187065);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(187061);
    ad.i("MicroMsg.F2FAppBrandRemittanceUI", "onCreate（）");
    super.onCreate(paramBundle);
    overridePendingTransition(0, 0);
    getWindow().setFlags(1024, 1024);
    if (getSupportActionBar() != null) {
      getSupportActionBar().hide();
    }
    this.app_id = getIntent().getStringExtra("key_app_id");
    this.vBW = getIntent().getStringExtra("key_confirm_id");
    if (bt.isNullOrNil(this.vBW)) {
      a(e.d.a.FHT, "fail:confirm_id is empty");
    }
    com.tencent.mm.kernel.g.aeS().a(2850, this);
    paramBundle = new m(this.vBW, this.app_id);
    com.tencent.mm.kernel.g.aeS().a(paramBundle, 0);
    AppMethodBeat.o(187061);
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(187062);
    ad.i("MicroMsg.F2FAppBrandRemittanceUI", "onDestroy()");
    super.onDestroy();
    if (this.vBX != null) {
      this.vBX.setImageBitmap(null);
    }
    Bitmap localBitmap = this.uln;
    if ((localBitmap != null) && (!localBitmap.isRecycled()))
    {
      ad.i("MicroMsg.F2FAppBrandRemittanceUI", "bitmap recycle %s", new Object[] { localBitmap });
      localBitmap.recycle();
    }
    com.tencent.mm.platformtools.u.c(this.nYT);
    this.vBY.dead();
    com.tencent.mm.kernel.g.aeS().b(2850, this);
    AppMethodBeat.o(187062);
  }
  
  public void onPause()
  {
    AppMethodBeat.i(187069);
    super.onPause();
    ad.i("MicroMsg.F2FAppBrandRemittanceUI", "onPause()");
    AppMethodBeat.o(187069);
  }
  
  public void onResume()
  {
    AppMethodBeat.i(187068);
    super.onResume();
    ad.i("MicroMsg.F2FAppBrandRemittanceUI", "onResume()");
    AppMethodBeat.o(187068);
  }
  
  public void onSceneEnd(int paramInt1, int paramInt2, final String paramString, n paramn)
  {
    AppMethodBeat.i(187063);
    ad.i("MicroMsg.F2FAppBrandRemittanceUI", "on Scene End：errType %s , errCode：%s，errMsg:%s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramString });
    if ((paramn instanceof m))
    {
      if ((paramInt1 == 0) && (paramInt2 == 0))
      {
        paramString = (m)paramn;
        if (paramString.vAo == null) {}
        for (paramString = new sd();; paramString = paramString.vAo)
        {
          ad.i("MicroMsg.F2FAppBrandRemittanceUI", "NetSceneF2FMinniProgramConfirm on SceneEnd ok，retcode:%s, retMsg：%s", new Object[] { Integer.valueOf(paramString.dcG), paramString.nTK });
          if (paramString.dcG != 0) {
            break label522;
          }
          ad.i("MicroMsg.F2FAppBrandRemittanceUI", "showHalfDialog");
          if ((paramString != null) && (!bt.isNullOrNil(paramString.dre))) {
            break;
          }
          ad.i("MicroMsg.F2FAppBrandRemittanceUI", "res == null || Util.isNullOrNil(res.qrcode)");
          a(e.d.a.FHT, "fail:get qrcode fail");
          AppMethodBeat.o(187063);
          return;
        }
        h.vKh.f(19821, new Object[] { Integer.valueOf(1) });
        this.nXL = new com.tencent.mm.ui.widget.a.g(getContext(), 2);
        paramn = View.inflate(getContext(), 2131496151, null);
        ((ImageView)paramn.findViewById(2131307151)).setOnClickListener(new View.OnClickListener()
        {
          public final void onClick(View paramAnonymousView)
          {
            AppMethodBeat.i(187058);
            F2FAppBrandRemittanceUI.a(F2FAppBrandRemittanceUI.this).bfo();
            F2FAppBrandRemittanceUI.b(F2FAppBrandRemittanceUI.this);
            F2FAppBrandRemittanceUI.a(F2FAppBrandRemittanceUI.this, e.d.a.FHU, "");
            h.vKh.f(19821, new Object[] { Integer.valueOf(3) });
            AppMethodBeat.o(187058);
          }
        });
        Object localObject = (TextView)paramn.findViewById(2131307189);
        ((TextView)localObject).setText(paramString.title);
        ((TextView)localObject).getPaint().setFakeBoldText(true);
        this.nXL.setHeaderView(paramn);
        paramn = View.inflate(getContext(), 2131496150, null);
        this.vBX = ((ImageView)paramn.findViewById(2131307186));
        this.vBX.setImageBitmap(null);
        if (bt.isNullOrNil(paramString.CTJ))
        {
          ad.i("MicroMsg.F2FAppBrandRemittanceUI", "qrcode： res.head_img null");
          if ((this.uln == null) || (this.uln.isRecycled())) {
            break label511;
          }
          this.vBX.setImageBitmap(this.uln);
        }
        for (;;)
        {
          ((TextView)paramn.findViewById(2131307188)).setText(paramString.CTK);
          localObject = (TextView)paramn.findViewById(2131307190);
          ((TextView)localObject).setText(paramString.CTL);
          ((TextView)localObject).getPaint().setFakeBoldText(true);
          this.nXL.setCustomView(paramn);
          this.nXL.aw(paramString.CTM);
          this.nXL.aaH(0);
          this.nXL.HFR = new g.a()
          {
            public final void onClick()
            {
              AppMethodBeat.i(187059);
              ad.i("MicroMsg.F2FAppBrandRemittanceUI", "go to remittaneUI");
              F2FAppBrandRemittanceUI.c(F2FAppBrandRemittanceUI.this).alive();
              f.a(F2FAppBrandRemittanceUI.this.getContext(), 1, paramString.dre, 56, null);
              h.vKh.f(19821, new Object[] { Integer.valueOf(2) });
              AppMethodBeat.o(187059);
            }
          };
          this.nXL.csG();
          AppMethodBeat.o(187063);
          return;
          localObject = paramString.dre;
          String str = paramString.CTJ;
          paramInt1 = BackwardSupportUtil.b.g(this, 197.0F);
          this.uln = b.a(this, (String)localObject, com.tencent.mm.model.u.aqG(), 1, str, paramInt1, this.nYT, false, 1, 2.0F);
          break;
          label511:
          ad.i("MicroMsg.F2FAppBrandRemittanceUI", "qrcode： bmp null ");
        }
        label522:
        Ug(paramString.nTK);
        AppMethodBeat.o(187063);
        return;
      }
      ad.i("MicroMsg.F2FAppBrandRemittanceUI", "NetSceneF2FMinniProgramConfirm on SceneEnd faile show error dialog ");
      Ug(paramString);
    }
    AppMethodBeat.o(187063);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    AppMethodBeat.i(187067);
    ad.i("MicroMsg.F2FAppBrandRemittanceUI", "onWindowFocusChanged");
    if ((this.nXL != null) && (!this.nXL.isShowing()))
    {
      ad.i("MicroMsg.F2FAppBrandRemittanceUI", "onWindowFocusChanged：mHalfBottomDialog isShowHalfDialog %s, finish Activity", new Object[] { Boolean.valueOf(this.nXL.isShowing()) });
      this.nXL = null;
      a(e.d.a.FHU, "");
      h.vKh.f(19821, new Object[] { Integer.valueOf(3) });
    }
    if ((this.hRe != null) && (!this.hRe.isShowing()))
    {
      ad.i("MicroMsg.F2FAppBrandRemittanceUI", "onWindowFocusChanged isShowing:%s,finish Activity", new Object[] { Boolean.valueOf(this.hRe.isShowing()) });
      this.hRe = null;
      a(e.d.a.FHT, "fail:get qrcode fail");
    }
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
    AppMethodBeat.o(187067);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.remittance.ui.F2FAppBrandRemittanceUI
 * JD-Core Version:    0.7.0.1
 */