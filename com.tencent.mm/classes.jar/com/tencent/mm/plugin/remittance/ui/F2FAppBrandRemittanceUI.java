package com.tencent.mm.plugin.remittance.ui;

import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.text.TextPaint;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.appcompat.app.ActionBar;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.an.i;
import com.tencent.mm.an.q;
import com.tencent.mm.an.t;
import com.tencent.mm.f.a.au;
import com.tencent.mm.model.z;
import com.tencent.mm.platformtools.u;
import com.tencent.mm.platformtools.u.a;
import com.tencent.mm.plugin.remittance.model.o;
import com.tencent.mm.plugin.wxpay.a.f;
import com.tencent.mm.plugin.wxpay.a.g;
import com.tencent.mm.plugin.wxpay.a.i;
import com.tencent.mm.pluginsdk.wallet.f;
import com.tencent.mm.protocal.protobuf.vt;
import com.tencent.mm.sdk.event.IListener;
import com.tencent.mm.sdk.platformtools.BackwardSupportUtil.BitmapFactory;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.f.f.a;
import com.tencent.mm.ui.widget.a.d;
import com.tencent.mm.ui.widget.a.f.a;
import com.tencent.mm.ui.widget.a.f.c;
import com.tencent.mm.ui.widget.a.g;
import com.tencent.mm.ui.widget.a.g.a;

@com.tencent.mm.ui.base.a(3)
public class F2FAppBrandRemittanceUI
  extends MMActivity
  implements i
{
  private Bitmap GEe;
  private String InI;
  private ImageView InJ;
  private IListener<au> InK;
  private String app_id;
  private d mpz;
  private g tZx;
  private u.a uaH;
  
  public F2FAppBrandRemittanceUI()
  {
    AppMethodBeat.i(195816);
    this.app_id = "";
    this.InI = "";
    this.InK = new IListener() {};
    this.uaH = new u.a()
    {
      public final void k(String paramAnonymousString, Bitmap paramAnonymousBitmap) {}
    };
    AppMethodBeat.o(195816);
  }
  
  private void a(Enum paramEnum, String paramString)
  {
    AppMethodBeat.i(195845);
    Log.i("MicroMsg.F2FAppBrandRemittanceUI", "setActivityResultData result :%s , errmsg : %s", new Object[] { paramEnum, paramString });
    Intent localIntent = new Intent();
    localIntent.putExtra("key_result_pay_result", paramEnum);
    localIntent.putExtra("key_result_error_msg", paramString);
    setResult(-1, localIntent);
    finish();
    AppMethodBeat.o(195845);
  }
  
  private void auQ(String paramString)
  {
    AppMethodBeat.i(195841);
    Log.i("MicroMsg.F2FAppBrandRemittanceUI", "showErrorDialog,errMsg:%s", new Object[] { paramString });
    f.a locala = new f.a(getContext());
    locala.aR("");
    paramString = locala.bBl(paramString).HL(true);
    paramString.Qlf = true;
    paramString.ayp(a.i.welcome_i_know).b(new f.c()
    {
      public final void g(boolean paramAnonymousBoolean, String paramAnonymousString) {}
    }).show();
    if (locala.mUO != null) {
      this.mpz = locala.mUO;
    }
    AppMethodBeat.o(195841);
  }
  
  public int getLayoutId()
  {
    return -1;
  }
  
  public void onBackPressed()
  {
    AppMethodBeat.i(195843);
    a(f.f.a.VSc, "");
    super.onBackPressed();
    AppMethodBeat.o(195843);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(195826);
    Log.i("MicroMsg.F2FAppBrandRemittanceUI", "onCreate（）");
    super.onCreate(paramBundle);
    overridePendingTransition(0, 0);
    getWindow().setFlags(1024, 1024);
    if (getSupportActionBar() != null) {
      getSupportActionBar().hide();
    }
    this.app_id = getIntent().getStringExtra("key_app_id");
    this.InI = getIntent().getStringExtra("key_confirm_id");
    if (Util.isNullOrNil(this.InI)) {
      a(f.f.a.VSb, "confirm_id is empty");
    }
    com.tencent.mm.kernel.h.aGY().a(2850, this);
    paramBundle = new o(this.InI, this.app_id);
    com.tencent.mm.kernel.h.aGY().a(paramBundle, 0);
    AppMethodBeat.o(195826);
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(195832);
    Log.i("MicroMsg.F2FAppBrandRemittanceUI", "onDestroy()");
    super.onDestroy();
    if (this.InJ != null) {
      this.InJ.setImageBitmap(null);
    }
    Bitmap localBitmap = this.GEe;
    if ((localBitmap != null) && (!localBitmap.isRecycled()))
    {
      Log.i("MicroMsg.F2FAppBrandRemittanceUI", "bitmap recycle %s", new Object[] { localBitmap });
      localBitmap.recycle();
    }
    u.c(this.uaH);
    this.InK.dead();
    com.tencent.mm.kernel.h.aGY().b(2850, this);
    AppMethodBeat.o(195832);
  }
  
  public void onPause()
  {
    AppMethodBeat.i(195853);
    super.onPause();
    Log.i("MicroMsg.F2FAppBrandRemittanceUI", "onPause()");
    AppMethodBeat.o(195853);
  }
  
  public void onResume()
  {
    AppMethodBeat.i(195850);
    super.onResume();
    Log.i("MicroMsg.F2FAppBrandRemittanceUI", "onResume()");
    AppMethodBeat.o(195850);
  }
  
  public void onSceneEnd(int paramInt1, int paramInt2, final String paramString, q paramq)
  {
    AppMethodBeat.i(195837);
    Log.i("MicroMsg.F2FAppBrandRemittanceUI", "on Scene End：errType %s , errCode：%s，errMsg:%s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramString });
    if ((paramq instanceof o))
    {
      if ((paramInt1 == 0) && (paramInt2 == 0))
      {
        paramString = (o)paramq;
        if (paramString.IlK == null) {}
        for (paramString = new vt();; paramString = paramString.IlK)
        {
          Log.i("MicroMsg.F2FAppBrandRemittanceUI", "NetSceneF2FMinniProgramConfirm on SceneEnd ok，retcode:%s, retMsg：%s", new Object[] { Integer.valueOf(paramString.fwx), paramString.tVo });
          if (paramString.fwx != 0) {
            break label560;
          }
          Log.i("MicroMsg.F2FAppBrandRemittanceUI", "showHalfDialog");
          if ((paramString != null) && (!Util.isNullOrNil(paramString.fMS))) {
            break;
          }
          Log.i("MicroMsg.F2FAppBrandRemittanceUI", "res == null || Util.isNullOrNil(res.qrcode)");
          a(f.f.a.VSb, "get qrcode fail");
          AppMethodBeat.o(195837);
          return;
        }
        com.tencent.mm.plugin.report.service.h.IzE.a(19821, new Object[] { Integer.valueOf(1), this.app_id, Integer.valueOf(0) });
        this.tZx = new g(getContext(), 2, 3);
        paramq = View.inflate(getContext(), a.g.f2f_app_brand_remittance_head, null);
        ((ImageView)paramq.findViewById(a.f.back_cion)).setOnClickListener(new View.OnClickListener()
        {
          public final void onClick(View paramAnonymousView)
          {
            AppMethodBeat.i(274809);
            com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
            localb.bn(paramAnonymousView);
            com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/remittance/ui/F2FAppBrandRemittanceUI$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aFi());
            F2FAppBrandRemittanceUI.b(F2FAppBrandRemittanceUI.this).bYF();
            F2FAppBrandRemittanceUI.c(F2FAppBrandRemittanceUI.this);
            F2FAppBrandRemittanceUI.a(F2FAppBrandRemittanceUI.this, f.f.a.VSc, "");
            com.tencent.mm.plugin.report.service.h.IzE.a(19821, new Object[] { Integer.valueOf(3), F2FAppBrandRemittanceUI.a(F2FAppBrandRemittanceUI.this), Integer.valueOf(0) });
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/remittance/ui/F2FAppBrandRemittanceUI$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(274809);
          }
        });
        Object localObject = (TextView)paramq.findViewById(a.f.f2f_app_brand_title);
        ((TextView)localObject).setText(paramString.title);
        ((TextView)localObject).getPaint().setFakeBoldText(true);
        this.tZx.setHeaderView(paramq);
        paramq = View.inflate(getContext(), a.g.f2f_app_brand_remittance_content, null);
        this.InJ = ((ImageView)paramq.findViewById(a.f.f2f_app_brand_qrcode));
        this.InJ.setImageBitmap(null);
        if (Util.isNullOrNil(paramString.ShU))
        {
          Log.i("MicroMsg.F2FAppBrandRemittanceUI", "qrcode： res.head_img null");
          if ((this.GEe == null) || (this.GEe.isRecycled())) {
            break label549;
          }
          this.InJ.setImageBitmap(this.GEe);
        }
        for (;;)
        {
          ((TextView)paramq.findViewById(a.f.f2f_app_brand_tips)).setText(paramString.ShV);
          localObject = (TextView)paramq.findViewById(a.f.f2f_app_brand_username);
          ((TextView)localObject).setText(paramString.ShW);
          ((TextView)localObject).getPaint().setFakeBoldText(true);
          this.tZx.setCustomView(paramq);
          this.tZx.ah(paramString.ShX);
          this.tZx.ayu(0);
          this.tZx.YnF = new g.a()
          {
            public final void onClick()
            {
              AppMethodBeat.i(246603);
              Log.i("MicroMsg.F2FAppBrandRemittanceUI", "go to remittaneUI");
              F2FAppBrandRemittanceUI.d(F2FAppBrandRemittanceUI.this).alive();
              com.tencent.mm.plugin.wallet.a locala = new com.tencent.mm.plugin.wallet.a();
              locala.Oky = F2FAppBrandRemittanceUI.a(F2FAppBrandRemittanceUI.this);
              f.a(F2FAppBrandRemittanceUI.this.getContext(), 1, paramString.fMS, 56, locala);
              com.tencent.mm.plugin.report.service.h.IzE.a(19821, new Object[] { Integer.valueOf(2), F2FAppBrandRemittanceUI.a(F2FAppBrandRemittanceUI.this), Integer.valueOf(0) });
              AppMethodBeat.o(246603);
            }
          };
          this.tZx.eik();
          AppMethodBeat.o(195837);
          return;
          localObject = paramString.fMS;
          String str = paramString.ShU;
          Log.i("MicroMsg.F2FAppBrandRemittanceUI", "contentUrl： %s ， headUrl：%s", new Object[] { localObject, str });
          paramInt1 = BackwardSupportUtil.BitmapFactory.fromDPToPix(this, 197.0F);
          this.GEe = com.tencent.mm.plugin.collect.model.b.a(this, (String)localObject, z.bcZ(), 1, str, paramInt1, this.uaH, false, 1, 2.0F, false);
          break;
          label549:
          Log.i("MicroMsg.F2FAppBrandRemittanceUI", "qrcode： bmp null ");
        }
        label560:
        auQ(paramString.tVo);
        AppMethodBeat.o(195837);
        return;
      }
      Log.i("MicroMsg.F2FAppBrandRemittanceUI", "NetSceneF2FMinniProgramConfirm on SceneEnd faile show error dialog ");
      auQ(paramString);
    }
    AppMethodBeat.o(195837);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    AppMethodBeat.i(195849);
    AppMethodBeat.at(this, paramBoolean);
    Log.i("MicroMsg.F2FAppBrandRemittanceUI", "onWindowFocusChanged");
    if ((this.tZx != null) && (!this.tZx.isShowing()))
    {
      Log.i("MicroMsg.F2FAppBrandRemittanceUI", "onWindowFocusChanged：mHalfBottomDialog isShowHalfDialog %s, finish Activity", new Object[] { Boolean.valueOf(this.tZx.isShowing()) });
      this.tZx = null;
      a(f.f.a.VSc, "");
      com.tencent.mm.plugin.report.service.h.IzE.a(19821, new Object[] { Integer.valueOf(3), this.app_id, Integer.valueOf(0) });
    }
    if ((this.mpz != null) && (!this.mpz.isShowing()))
    {
      Log.i("MicroMsg.F2FAppBrandRemittanceUI", "onWindowFocusChanged isShowing:%s,finish Activity", new Object[] { Boolean.valueOf(this.mpz.isShowing()) });
      this.mpz = null;
      a(f.f.a.VSb, "get qrcode fail");
    }
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.o(195849);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.remittance.ui.F2FAppBrandRemittanceUI
 * JD-Core Version:    0.7.0.1
 */