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
import com.tencent.mm.ak.n;
import com.tencent.mm.ak.q;
import com.tencent.mm.g.a.aq;
import com.tencent.mm.platformtools.u.a;
import com.tencent.mm.plugin.collect.model.b;
import com.tencent.mm.plugin.remittance.model.m;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.pluginsdk.wallet.f;
import com.tencent.mm.protocal.protobuf.sn;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.BackwardSupportUtil.b;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.bs;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.e.d.a;
import com.tencent.mm.ui.widget.a.d;
import com.tencent.mm.ui.widget.a.f.a;
import com.tencent.mm.ui.widget.a.f.c;
import com.tencent.mm.ui.widget.a.g.a;

@com.tencent.mm.ui.base.a(3)
public class F2FAppBrandRemittanceUI
  extends MMActivity
  implements com.tencent.mm.ak.g
{
  private String app_id;
  private d iri;
  private com.tencent.mm.ui.widget.a.g oBg;
  private u.a oCo;
  private Bitmap vuj;
  private String wMb;
  private ImageView wMc;
  private c<aq> wMd;
  
  public F2FAppBrandRemittanceUI()
  {
    AppMethodBeat.i(207141);
    this.app_id = "";
    this.wMb = "";
    this.wMd = new c() {};
    this.oCo = new u.a()
    {
      public final void k(String paramAnonymousString, Bitmap paramAnonymousBitmap) {}
    };
    AppMethodBeat.o(207141);
  }
  
  private void Ys(String paramString)
  {
    AppMethodBeat.i(207145);
    ac.i("MicroMsg.F2FAppBrandRemittanceUI", "showErrorDialog,errMsg:%s", new Object[] { paramString });
    f.a locala = new f.a(getContext());
    locala.av("");
    paramString = locala.aRQ(paramString).yi(true);
    paramString.JfY = true;
    paramString.acQ(2131766205).b(new f.c()
    {
      public final void d(boolean paramAnonymousBoolean, String paramAnonymousString) {}
    }).show();
    if (locala.iJj != null) {
      this.iri = locala.iJj;
    }
    AppMethodBeat.o(207145);
  }
  
  private void a(Enum paramEnum, String paramString)
  {
    AppMethodBeat.i(207147);
    ac.i("MicroMsg.F2FAppBrandRemittanceUI", "setActivityResultData result :%s , errmsg : %s", new Object[] { paramEnum, paramString });
    Intent localIntent = new Intent();
    localIntent.putExtra("key_result_pay_result", paramEnum);
    localIntent.putExtra("key_result_error_msg", paramString);
    setResult(-1, localIntent);
    finish();
    AppMethodBeat.o(207147);
  }
  
  public int getLayoutId()
  {
    return -1;
  }
  
  public void onBackPressed()
  {
    AppMethodBeat.i(207146);
    a(e.d.a.Hhc, "");
    super.onBackPressed();
    AppMethodBeat.o(207146);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(207142);
    ac.i("MicroMsg.F2FAppBrandRemittanceUI", "onCreate（）");
    super.onCreate(paramBundle);
    overridePendingTransition(0, 0);
    getWindow().setFlags(1024, 1024);
    if (getSupportActionBar() != null) {
      getSupportActionBar().hide();
    }
    this.app_id = getIntent().getStringExtra("key_app_id");
    this.wMb = getIntent().getStringExtra("key_confirm_id");
    if (bs.isNullOrNil(this.wMb)) {
      a(e.d.a.Hhb, "confirm_id is empty");
    }
    com.tencent.mm.kernel.g.agi().a(2850, this);
    paramBundle = new m(this.wMb, this.app_id);
    com.tencent.mm.kernel.g.agi().a(paramBundle, 0);
    AppMethodBeat.o(207142);
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(207143);
    ac.i("MicroMsg.F2FAppBrandRemittanceUI", "onDestroy()");
    super.onDestroy();
    if (this.wMc != null) {
      this.wMc.setImageBitmap(null);
    }
    Bitmap localBitmap = this.vuj;
    if ((localBitmap != null) && (!localBitmap.isRecycled()))
    {
      ac.i("MicroMsg.F2FAppBrandRemittanceUI", "bitmap recycle %s", new Object[] { localBitmap });
      localBitmap.recycle();
    }
    com.tencent.mm.platformtools.u.c(this.oCo);
    this.wMd.dead();
    com.tencent.mm.kernel.g.agi().b(2850, this);
    AppMethodBeat.o(207143);
  }
  
  public void onPause()
  {
    AppMethodBeat.i(207150);
    super.onPause();
    ac.i("MicroMsg.F2FAppBrandRemittanceUI", "onPause()");
    AppMethodBeat.o(207150);
  }
  
  public void onResume()
  {
    AppMethodBeat.i(207149);
    super.onResume();
    ac.i("MicroMsg.F2FAppBrandRemittanceUI", "onResume()");
    AppMethodBeat.o(207149);
  }
  
  public void onSceneEnd(int paramInt1, int paramInt2, final String paramString, n paramn)
  {
    AppMethodBeat.i(207144);
    ac.i("MicroMsg.F2FAppBrandRemittanceUI", "on Scene End：errType %s , errCode：%s，errMsg:%s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramString });
    if ((paramn instanceof m))
    {
      if ((paramInt1 == 0) && (paramInt2 == 0))
      {
        paramString = (m)paramn;
        if (paramString.wKt == null) {}
        for (paramString = new sn();; paramString = paramString.wKt)
        {
          ac.i("MicroMsg.F2FAppBrandRemittanceUI", "NetSceneF2FMinniProgramConfirm on SceneEnd ok，retcode:%s, retMsg：%s", new Object[] { Integer.valueOf(paramString.dae), paramString.oxf });
          if (paramString.dae != 0) {
            break label537;
          }
          ac.i("MicroMsg.F2FAppBrandRemittanceUI", "showHalfDialog");
          if ((paramString != null) && (!bs.isNullOrNil(paramString.doP))) {
            break;
          }
          ac.i("MicroMsg.F2FAppBrandRemittanceUI", "res == null || Util.isNullOrNil(res.qrcode)");
          a(e.d.a.Hhb, "get qrcode fail");
          AppMethodBeat.o(207144);
          return;
        }
        h.wUl.f(19821, new Object[] { Integer.valueOf(1), this.app_id, Integer.valueOf(0) });
        this.oBg = new com.tencent.mm.ui.widget.a.g(getContext(), 2, 3);
        paramn = View.inflate(getContext(), 2131496151, null);
        ((ImageView)paramn.findViewById(2131307151)).setOnClickListener(new View.OnClickListener()
        {
          public final void onClick(View paramAnonymousView)
          {
            AppMethodBeat.i(207139);
            F2FAppBrandRemittanceUI.b(F2FAppBrandRemittanceUI.this).bmi();
            F2FAppBrandRemittanceUI.c(F2FAppBrandRemittanceUI.this);
            F2FAppBrandRemittanceUI.a(F2FAppBrandRemittanceUI.this, e.d.a.Hhc, "");
            h.wUl.f(19821, new Object[] { Integer.valueOf(3), F2FAppBrandRemittanceUI.a(F2FAppBrandRemittanceUI.this), Integer.valueOf(0) });
            AppMethodBeat.o(207139);
          }
        });
        Object localObject = (TextView)paramn.findViewById(2131307189);
        ((TextView)localObject).setText(paramString.title);
        ((TextView)localObject).getPaint().setFakeBoldText(true);
        this.oBg.setHeaderView(paramn);
        paramn = View.inflate(getContext(), 2131496150, null);
        this.wMc = ((ImageView)paramn.findViewById(2131307186));
        this.wMc.setImageBitmap(null);
        if (bs.isNullOrNil(paramString.Emu))
        {
          ac.i("MicroMsg.F2FAppBrandRemittanceUI", "qrcode： res.head_img null");
          if ((this.vuj == null) || (this.vuj.isRecycled())) {
            break label526;
          }
          this.wMc.setImageBitmap(this.vuj);
        }
        for (;;)
        {
          ((TextView)paramn.findViewById(2131307188)).setText(paramString.Emv);
          localObject = (TextView)paramn.findViewById(2131307190);
          ((TextView)localObject).setText(paramString.Emw);
          ((TextView)localObject).getPaint().setFakeBoldText(true);
          this.oBg.setCustomView(paramn);
          this.oBg.ax(paramString.Emx);
          this.oBg.acS(0);
          this.oBg.Jgo = new g.a()
          {
            public final void onClick()
            {
              AppMethodBeat.i(207140);
              ac.i("MicroMsg.F2FAppBrandRemittanceUI", "go to remittaneUI");
              F2FAppBrandRemittanceUI.d(F2FAppBrandRemittanceUI.this).alive();
              com.tencent.mm.plugin.wallet.a locala = new com.tencent.mm.plugin.wallet.a();
              locala.AWj = F2FAppBrandRemittanceUI.a(F2FAppBrandRemittanceUI.this);
              f.a(F2FAppBrandRemittanceUI.this.getContext(), 1, paramString.doP, 56, locala);
              h.wUl.f(19821, new Object[] { Integer.valueOf(2), F2FAppBrandRemittanceUI.a(F2FAppBrandRemittanceUI.this), Integer.valueOf(0) });
              AppMethodBeat.o(207140);
            }
          };
          this.oBg.cED();
          AppMethodBeat.o(207144);
          return;
          localObject = paramString.doP;
          String str = paramString.Emu;
          paramInt1 = BackwardSupportUtil.b.g(this, 197.0F);
          this.vuj = b.a(this, (String)localObject, com.tencent.mm.model.u.axw(), 1, str, paramInt1, this.oCo, false, 1, 2.0F);
          break;
          label526:
          ac.i("MicroMsg.F2FAppBrandRemittanceUI", "qrcode： bmp null ");
        }
        label537:
        Ys(paramString.oxf);
        AppMethodBeat.o(207144);
        return;
      }
      ac.i("MicroMsg.F2FAppBrandRemittanceUI", "NetSceneF2FMinniProgramConfirm on SceneEnd faile show error dialog ");
      Ys(paramString);
    }
    AppMethodBeat.o(207144);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    AppMethodBeat.i(207148);
    ac.i("MicroMsg.F2FAppBrandRemittanceUI", "onWindowFocusChanged");
    if ((this.oBg != null) && (!this.oBg.isShowing()))
    {
      ac.i("MicroMsg.F2FAppBrandRemittanceUI", "onWindowFocusChanged：mHalfBottomDialog isShowHalfDialog %s, finish Activity", new Object[] { Boolean.valueOf(this.oBg.isShowing()) });
      this.oBg = null;
      a(e.d.a.Hhc, "");
      h.wUl.f(19821, new Object[] { Integer.valueOf(3), this.app_id, Integer.valueOf(0) });
    }
    if ((this.iri != null) && (!this.iri.isShowing()))
    {
      ac.i("MicroMsg.F2FAppBrandRemittanceUI", "onWindowFocusChanged isShowing:%s,finish Activity", new Object[] { Boolean.valueOf(this.iri.isShowing()) });
      this.iri = null;
      a(e.d.a.Hhb, "get qrcode fail");
    }
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
    AppMethodBeat.o(207148);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.remittance.ui.F2FAppBrandRemittanceUI
 * JD-Core Version:    0.7.0.1
 */