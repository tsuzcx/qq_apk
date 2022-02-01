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
import com.tencent.mm.ak.i;
import com.tencent.mm.ak.q;
import com.tencent.mm.ak.t;
import com.tencent.mm.g.a.as;
import com.tencent.mm.model.z;
import com.tencent.mm.platformtools.u;
import com.tencent.mm.platformtools.u.a;
import com.tencent.mm.plugin.remittance.model.m;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.pluginsdk.wallet.f;
import com.tencent.mm.protocal.protobuf.vr;
import com.tencent.mm.sdk.event.IListener;
import com.tencent.mm.sdk.platformtools.BackwardSupportUtil.BitmapFactory;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.e.f.a;
import com.tencent.mm.ui.widget.a.d;
import com.tencent.mm.ui.widget.a.f.a;
import com.tencent.mm.ui.widget.a.f.c;
import com.tencent.mm.ui.widget.a.g.a;

@com.tencent.mm.ui.base.a(3)
public class F2FAppBrandRemittanceUI
  extends MMActivity
  implements i
{
  private Bitmap AKT;
  private String Cqr;
  private ImageView Cqs;
  private IListener<as> Cqt;
  private String app_id;
  private d jzT;
  private com.tencent.mm.ui.widget.a.g qAx;
  private u.a qBH;
  
  public F2FAppBrandRemittanceUI()
  {
    AppMethodBeat.i(213740);
    this.app_id = "";
    this.Cqr = "";
    this.Cqt = new IListener() {};
    this.qBH = new u.a()
    {
      public final void k(String paramAnonymousString, Bitmap paramAnonymousBitmap) {}
    };
    AppMethodBeat.o(213740);
  }
  
  private void a(Enum paramEnum, String paramString)
  {
    AppMethodBeat.i(213746);
    Log.i("MicroMsg.F2FAppBrandRemittanceUI", "setActivityResultData result :%s , errmsg : %s", new Object[] { paramEnum, paramString });
    Intent localIntent = new Intent();
    localIntent.putExtra("key_result_pay_result", paramEnum);
    localIntent.putExtra("key_result_error_msg", paramString);
    setResult(-1, localIntent);
    finish();
    AppMethodBeat.o(213746);
  }
  
  private void amW(String paramString)
  {
    AppMethodBeat.i(213744);
    Log.i("MicroMsg.F2FAppBrandRemittanceUI", "showErrorDialog,errMsg:%s", new Object[] { paramString });
    f.a locala = new f.a(getContext());
    locala.aC("");
    paramString = locala.bow(paramString).Dq(true);
    paramString.JnN = true;
    paramString.apa(2131768713).b(new f.c()
    {
      public final void e(boolean paramAnonymousBoolean, String paramAnonymousString) {}
    }).show();
    if (locala.kdo != null) {
      this.jzT = locala.kdo;
    }
    AppMethodBeat.o(213744);
  }
  
  public int getLayoutId()
  {
    return -1;
  }
  
  public void onBackPressed()
  {
    AppMethodBeat.i(213745);
    a(e.f.a.OyZ, "");
    super.onBackPressed();
    AppMethodBeat.o(213745);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(213741);
    Log.i("MicroMsg.F2FAppBrandRemittanceUI", "onCreate（）");
    super.onCreate(paramBundle);
    overridePendingTransition(0, 0);
    getWindow().setFlags(1024, 1024);
    if (getSupportActionBar() != null) {
      getSupportActionBar().hide();
    }
    this.app_id = getIntent().getStringExtra("key_app_id");
    this.Cqr = getIntent().getStringExtra("key_confirm_id");
    if (Util.isNullOrNil(this.Cqr)) {
      a(e.f.a.OyY, "confirm_id is empty");
    }
    com.tencent.mm.kernel.g.azz().a(2850, this);
    paramBundle = new m(this.Cqr, this.app_id);
    com.tencent.mm.kernel.g.azz().a(paramBundle, 0);
    AppMethodBeat.o(213741);
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(213742);
    Log.i("MicroMsg.F2FAppBrandRemittanceUI", "onDestroy()");
    super.onDestroy();
    if (this.Cqs != null) {
      this.Cqs.setImageBitmap(null);
    }
    Bitmap localBitmap = this.AKT;
    if ((localBitmap != null) && (!localBitmap.isRecycled()))
    {
      Log.i("MicroMsg.F2FAppBrandRemittanceUI", "bitmap recycle %s", new Object[] { localBitmap });
      localBitmap.recycle();
    }
    u.c(this.qBH);
    this.Cqt.dead();
    com.tencent.mm.kernel.g.azz().b(2850, this);
    AppMethodBeat.o(213742);
  }
  
  public void onPause()
  {
    AppMethodBeat.i(213749);
    super.onPause();
    Log.i("MicroMsg.F2FAppBrandRemittanceUI", "onPause()");
    AppMethodBeat.o(213749);
  }
  
  public void onResume()
  {
    AppMethodBeat.i(213748);
    super.onResume();
    Log.i("MicroMsg.F2FAppBrandRemittanceUI", "onResume()");
    AppMethodBeat.o(213748);
  }
  
  public void onSceneEnd(int paramInt1, int paramInt2, final String paramString, q paramq)
  {
    AppMethodBeat.i(213743);
    Log.i("MicroMsg.F2FAppBrandRemittanceUI", "on Scene End：errType %s , errCode：%s，errMsg:%s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramString });
    if ((paramq instanceof m))
    {
      if ((paramInt1 == 0) && (paramInt2 == 0))
      {
        paramString = (m)paramq;
        if (paramString.CoI == null) {}
        for (paramString = new vr();; paramString = paramString.CoI)
        {
          Log.i("MicroMsg.F2FAppBrandRemittanceUI", "NetSceneF2FMinniProgramConfirm on SceneEnd ok，retcode:%s, retMsg：%s", new Object[] { Integer.valueOf(paramString.dDN), paramString.qwn });
          if (paramString.dDN != 0) {
            break label560;
          }
          Log.i("MicroMsg.F2FAppBrandRemittanceUI", "showHalfDialog");
          if ((paramString != null) && (!Util.isNullOrNil(paramString.dTx))) {
            break;
          }
          Log.i("MicroMsg.F2FAppBrandRemittanceUI", "res == null || Util.isNullOrNil(res.qrcode)");
          a(e.f.a.OyY, "get qrcode fail");
          AppMethodBeat.o(213743);
          return;
        }
        h.CyF.a(19821, new Object[] { Integer.valueOf(1), this.app_id, Integer.valueOf(0) });
        this.qAx = new com.tencent.mm.ui.widget.a.g(getContext(), 2, 3);
        paramq = View.inflate(getContext(), 2131494055, null);
        ((ImageView)paramq.findViewById(2131297165)).setOnClickListener(new View.OnClickListener()
        {
          public final void onClick(View paramAnonymousView)
          {
            AppMethodBeat.i(213738);
            com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
            localb.bm(paramAnonymousView);
            com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/remittance/ui/F2FAppBrandRemittanceUI$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.axR());
            F2FAppBrandRemittanceUI.b(F2FAppBrandRemittanceUI.this).bMo();
            F2FAppBrandRemittanceUI.c(F2FAppBrandRemittanceUI.this);
            F2FAppBrandRemittanceUI.a(F2FAppBrandRemittanceUI.this, e.f.a.OyZ, "");
            h.CyF.a(19821, new Object[] { Integer.valueOf(3), F2FAppBrandRemittanceUI.a(F2FAppBrandRemittanceUI.this), Integer.valueOf(0) });
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/remittance/ui/F2FAppBrandRemittanceUI$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(213738);
          }
        });
        Object localObject = (TextView)paramq.findViewById(2131300279);
        ((TextView)localObject).setText(paramString.title);
        ((TextView)localObject).getPaint().setFakeBoldText(true);
        this.qAx.setHeaderView(paramq);
        paramq = View.inflate(getContext(), 2131494054, null);
        this.Cqs = ((ImageView)paramq.findViewById(2131300276));
        this.Cqs.setImageBitmap(null);
        if (Util.isNullOrNil(paramString.LgG))
        {
          Log.i("MicroMsg.F2FAppBrandRemittanceUI", "qrcode： res.head_img null");
          if ((this.AKT == null) || (this.AKT.isRecycled())) {
            break label549;
          }
          this.Cqs.setImageBitmap(this.AKT);
        }
        for (;;)
        {
          ((TextView)paramq.findViewById(2131300278)).setText(paramString.LgH);
          localObject = (TextView)paramq.findViewById(2131300280);
          ((TextView)localObject).setText(paramString.LgI);
          ((TextView)localObject).getPaint().setFakeBoldText(true);
          this.qAx.setCustomView(paramq);
          this.qAx.T(paramString.LgJ);
          this.qAx.ape(0);
          this.qAx.QOT = new g.a()
          {
            public final void onClick()
            {
              AppMethodBeat.i(213739);
              Log.i("MicroMsg.F2FAppBrandRemittanceUI", "go to remittaneUI");
              F2FAppBrandRemittanceUI.d(F2FAppBrandRemittanceUI.this).alive();
              com.tencent.mm.plugin.wallet.a locala = new com.tencent.mm.plugin.wallet.a();
              locala.HsN = F2FAppBrandRemittanceUI.a(F2FAppBrandRemittanceUI.this);
              f.a(F2FAppBrandRemittanceUI.this.getContext(), 1, paramString.dTx, 56, locala);
              h.CyF.a(19821, new Object[] { Integer.valueOf(2), F2FAppBrandRemittanceUI.a(F2FAppBrandRemittanceUI.this), Integer.valueOf(0) });
              AppMethodBeat.o(213739);
            }
          };
          this.qAx.dGm();
          AppMethodBeat.o(213743);
          return;
          localObject = paramString.dTx;
          String str = paramString.LgG;
          Log.i("MicroMsg.F2FAppBrandRemittanceUI", "contentUrl： %s ， headUrl：%s", new Object[] { localObject, str });
          paramInt1 = BackwardSupportUtil.BitmapFactory.fromDPToPix(this, 197.0F);
          this.AKT = com.tencent.mm.plugin.collect.model.b.a(this, (String)localObject, z.aTY(), 1, str, paramInt1, this.qBH, false, 1, 2.0F, false);
          break;
          label549:
          Log.i("MicroMsg.F2FAppBrandRemittanceUI", "qrcode： bmp null ");
        }
        label560:
        amW(paramString.qwn);
        AppMethodBeat.o(213743);
        return;
      }
      Log.i("MicroMsg.F2FAppBrandRemittanceUI", "NetSceneF2FMinniProgramConfirm on SceneEnd faile show error dialog ");
      amW(paramString);
    }
    AppMethodBeat.o(213743);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    AppMethodBeat.i(213747);
    AppMethodBeat.at(this, paramBoolean);
    Log.i("MicroMsg.F2FAppBrandRemittanceUI", "onWindowFocusChanged");
    if ((this.qAx != null) && (!this.qAx.isShowing()))
    {
      Log.i("MicroMsg.F2FAppBrandRemittanceUI", "onWindowFocusChanged：mHalfBottomDialog isShowHalfDialog %s, finish Activity", new Object[] { Boolean.valueOf(this.qAx.isShowing()) });
      this.qAx = null;
      a(e.f.a.OyZ, "");
      h.CyF.a(19821, new Object[] { Integer.valueOf(3), this.app_id, Integer.valueOf(0) });
    }
    if ((this.jzT != null) && (!this.jzT.isShowing()))
    {
      Log.i("MicroMsg.F2FAppBrandRemittanceUI", "onWindowFocusChanged isShowing:%s,finish Activity", new Object[] { Boolean.valueOf(this.jzT.isShowing()) });
      this.jzT = null;
      a(e.f.a.OyY, "get qrcode fail");
    }
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.o(213747);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.remittance.ui.F2FAppBrandRemittanceUI
 * JD-Core Version:    0.7.0.1
 */