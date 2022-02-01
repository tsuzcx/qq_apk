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
import com.tencent.mm.model.v;
import com.tencent.mm.platformtools.u;
import com.tencent.mm.platformtools.u.a;
import com.tencent.mm.plugin.remittance.model.m;
import com.tencent.mm.protocal.protobuf.uk;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.BackwardSupportUtil.b;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.e.d.a;
import com.tencent.mm.ui.widget.a.d;
import com.tencent.mm.ui.widget.a.f.a;
import com.tencent.mm.ui.widget.a.f.c;
import com.tencent.mm.ui.widget.a.g.a;

@com.tencent.mm.ui.base.a(3)
public class F2FAppBrandRemittanceUI
  extends MMActivity
  implements com.tencent.mm.ak.f
{
  private String app_id;
  private d iNf;
  private com.tencent.mm.ui.widget.a.g plh;
  private u.a pmp;
  private Bitmap wPn;
  private String ypA;
  private ImageView ypB;
  private c<aq> ypC;
  
  public F2FAppBrandRemittanceUI()
  {
    AppMethodBeat.i(189993);
    this.app_id = "";
    this.ypA = "";
    this.ypC = new c() {};
    this.pmp = new u.a()
    {
      public final void k(String paramAnonymousString, Bitmap paramAnonymousBitmap) {}
    };
    AppMethodBeat.o(189993);
  }
  
  private void a(Enum paramEnum, String paramString)
  {
    AppMethodBeat.i(189999);
    ae.i("MicroMsg.F2FAppBrandRemittanceUI", "setActivityResultData result :%s , errmsg : %s", new Object[] { paramEnum, paramString });
    Intent localIntent = new Intent();
    localIntent.putExtra("key_result_pay_result", paramEnum);
    localIntent.putExtra("key_result_error_msg", paramString);
    setResult(-1, localIntent);
    finish();
    AppMethodBeat.o(189999);
  }
  
  private void acP(String paramString)
  {
    AppMethodBeat.i(189997);
    ae.i("MicroMsg.F2FAppBrandRemittanceUI", "showErrorDialog,errMsg:%s", new Object[] { paramString });
    f.a locala = new f.a(getContext());
    locala.au("");
    paramString = locala.aZq(paramString).zi(true);
    paramString.EyN = true;
    paramString.afY(2131766205).b(new f.c()
    {
      public final void d(boolean paramAnonymousBoolean, String paramAnonymousString) {}
    }).show();
    if (locala.jfl != null) {
      this.iNf = locala.jfl;
    }
    AppMethodBeat.o(189997);
  }
  
  public int getLayoutId()
  {
    return -1;
  }
  
  public void onBackPressed()
  {
    AppMethodBeat.i(189998);
    a(e.d.a.Jpa, "");
    super.onBackPressed();
    AppMethodBeat.o(189998);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(189994);
    ae.i("MicroMsg.F2FAppBrandRemittanceUI", "onCreate（）");
    super.onCreate(paramBundle);
    overridePendingTransition(0, 0);
    getWindow().setFlags(1024, 1024);
    if (getSupportActionBar() != null) {
      getSupportActionBar().hide();
    }
    this.app_id = getIntent().getStringExtra("key_app_id");
    this.ypA = getIntent().getStringExtra("key_confirm_id");
    if (bu.isNullOrNil(this.ypA)) {
      a(e.d.a.JoZ, "confirm_id is empty");
    }
    com.tencent.mm.kernel.g.ajj().a(2850, this);
    paramBundle = new m(this.ypA, this.app_id);
    com.tencent.mm.kernel.g.ajj().a(paramBundle, 0);
    AppMethodBeat.o(189994);
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(189995);
    ae.i("MicroMsg.F2FAppBrandRemittanceUI", "onDestroy()");
    super.onDestroy();
    if (this.ypB != null) {
      this.ypB.setImageBitmap(null);
    }
    Bitmap localBitmap = this.wPn;
    if ((localBitmap != null) && (!localBitmap.isRecycled()))
    {
      ae.i("MicroMsg.F2FAppBrandRemittanceUI", "bitmap recycle %s", new Object[] { localBitmap });
      localBitmap.recycle();
    }
    u.c(this.pmp);
    this.ypC.dead();
    com.tencent.mm.kernel.g.ajj().b(2850, this);
    AppMethodBeat.o(189995);
  }
  
  public void onPause()
  {
    AppMethodBeat.i(190002);
    super.onPause();
    ae.i("MicroMsg.F2FAppBrandRemittanceUI", "onPause()");
    AppMethodBeat.o(190002);
  }
  
  public void onResume()
  {
    AppMethodBeat.i(190001);
    super.onResume();
    ae.i("MicroMsg.F2FAppBrandRemittanceUI", "onResume()");
    AppMethodBeat.o(190001);
  }
  
  public void onSceneEnd(int paramInt1, int paramInt2, final String paramString, n paramn)
  {
    AppMethodBeat.i(189996);
    ae.i("MicroMsg.F2FAppBrandRemittanceUI", "on Scene End：errType %s , errCode：%s，errMsg:%s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramString });
    if ((paramn instanceof m))
    {
      if ((paramInt1 == 0) && (paramInt2 == 0))
      {
        paramString = (m)paramn;
        if (paramString.ynS == null) {}
        for (paramString = new uk();; paramString = paramString.ynS)
        {
          ae.i("MicroMsg.F2FAppBrandRemittanceUI", "NetSceneF2FMinniProgramConfirm on SceneEnd ok，retcode:%s, retMsg：%s", new Object[] { Integer.valueOf(paramString.dmy), paramString.phe });
          if (paramString.dmy != 0) {
            break label560;
          }
          ae.i("MicroMsg.F2FAppBrandRemittanceUI", "showHalfDialog");
          if ((paramString != null) && (!bu.isNullOrNil(paramString.dBI))) {
            break;
          }
          ae.i("MicroMsg.F2FAppBrandRemittanceUI", "res == null || Util.isNullOrNil(res.qrcode)");
          a(e.d.a.JoZ, "get qrcode fail");
          AppMethodBeat.o(189996);
          return;
        }
        com.tencent.mm.plugin.report.service.g.yxI.f(19821, new Object[] { Integer.valueOf(1), this.app_id, Integer.valueOf(0) });
        this.plh = new com.tencent.mm.ui.widget.a.g(getContext(), 2, 3);
        paramn = View.inflate(getContext(), 2131496151, null);
        ((ImageView)paramn.findViewById(2131307151)).setOnClickListener(new View.OnClickListener()
        {
          public final void onClick(View paramAnonymousView)
          {
            AppMethodBeat.i(189991);
            com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
            localb.bd(paramAnonymousView);
            com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/remittance/ui/F2FAppBrandRemittanceUI$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahF());
            F2FAppBrandRemittanceUI.b(F2FAppBrandRemittanceUI.this).bqD();
            F2FAppBrandRemittanceUI.c(F2FAppBrandRemittanceUI.this);
            F2FAppBrandRemittanceUI.a(F2FAppBrandRemittanceUI.this, e.d.a.Jpa, "");
            com.tencent.mm.plugin.report.service.g.yxI.f(19821, new Object[] { Integer.valueOf(3), F2FAppBrandRemittanceUI.a(F2FAppBrandRemittanceUI.this), Integer.valueOf(0) });
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/remittance/ui/F2FAppBrandRemittanceUI$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(189991);
          }
        });
        Object localObject = (TextView)paramn.findViewById(2131307189);
        ((TextView)localObject).setText(paramString.title);
        ((TextView)localObject).getPaint().setFakeBoldText(true);
        this.plh.setHeaderView(paramn);
        paramn = View.inflate(getContext(), 2131496150, null);
        this.ypB = ((ImageView)paramn.findViewById(2131307186));
        this.ypB.setImageBitmap(null);
        if (bu.isNullOrNil(paramString.Gmc))
        {
          ae.i("MicroMsg.F2FAppBrandRemittanceUI", "qrcode： res.head_img null");
          if ((this.wPn == null) || (this.wPn.isRecycled())) {
            break label549;
          }
          this.ypB.setImageBitmap(this.wPn);
        }
        for (;;)
        {
          ((TextView)paramn.findViewById(2131307188)).setText(paramString.Gmd);
          localObject = (TextView)paramn.findViewById(2131307190);
          ((TextView)localObject).setText(paramString.Gme);
          ((TextView)localObject).getPaint().setFakeBoldText(true);
          this.plh.setCustomView(paramn);
          this.plh.aw(paramString.Gmf);
          this.plh.agb(0);
          this.plh.LtZ = new g.a()
          {
            public final void onClick()
            {
              AppMethodBeat.i(189992);
              ae.i("MicroMsg.F2FAppBrandRemittanceUI", "go to remittaneUI");
              F2FAppBrandRemittanceUI.d(F2FAppBrandRemittanceUI.this).alive();
              com.tencent.mm.plugin.wallet.a locala = new com.tencent.mm.plugin.wallet.a();
              locala.CNW = F2FAppBrandRemittanceUI.a(F2FAppBrandRemittanceUI.this);
              com.tencent.mm.pluginsdk.wallet.f.a(F2FAppBrandRemittanceUI.this.getContext(), 1, paramString.dBI, 56, locala);
              com.tencent.mm.plugin.report.service.g.yxI.f(19821, new Object[] { Integer.valueOf(2), F2FAppBrandRemittanceUI.a(F2FAppBrandRemittanceUI.this), Integer.valueOf(0) });
              AppMethodBeat.o(189992);
            }
          };
          this.plh.cPF();
          AppMethodBeat.o(189996);
          return;
          localObject = paramString.dBI;
          String str = paramString.Gmc;
          ae.i("MicroMsg.F2FAppBrandRemittanceUI", "contentUrl： %s ， headUrl：%s", new Object[] { localObject, str });
          paramInt1 = BackwardSupportUtil.b.h(this, 197.0F);
          this.wPn = com.tencent.mm.plugin.collect.model.b.a(this, (String)localObject, v.aAC(), 1, str, paramInt1, this.pmp, false, 1, 2.0F, false);
          break;
          label549:
          ae.i("MicroMsg.F2FAppBrandRemittanceUI", "qrcode： bmp null ");
        }
        label560:
        acP(paramString.phe);
        AppMethodBeat.o(189996);
        return;
      }
      ae.i("MicroMsg.F2FAppBrandRemittanceUI", "NetSceneF2FMinniProgramConfirm on SceneEnd faile show error dialog ");
      acP(paramString);
    }
    AppMethodBeat.o(189996);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    AppMethodBeat.i(190000);
    AppMethodBeat.at(this, paramBoolean);
    ae.i("MicroMsg.F2FAppBrandRemittanceUI", "onWindowFocusChanged");
    if ((this.plh != null) && (!this.plh.isShowing()))
    {
      ae.i("MicroMsg.F2FAppBrandRemittanceUI", "onWindowFocusChanged：mHalfBottomDialog isShowHalfDialog %s, finish Activity", new Object[] { Boolean.valueOf(this.plh.isShowing()) });
      this.plh = null;
      a(e.d.a.Jpa, "");
      com.tencent.mm.plugin.report.service.g.yxI.f(19821, new Object[] { Integer.valueOf(3), this.app_id, Integer.valueOf(0) });
    }
    if ((this.iNf != null) && (!this.iNf.isShowing()))
    {
      ae.i("MicroMsg.F2FAppBrandRemittanceUI", "onWindowFocusChanged isShowing:%s,finish Activity", new Object[] { Boolean.valueOf(this.iNf.isShowing()) });
      this.iNf = null;
      a(e.d.a.JoZ, "get qrcode fail");
    }
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.o(190000);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.remittance.ui.F2FAppBrandRemittanceUI
 * JD-Core Version:    0.7.0.1
 */