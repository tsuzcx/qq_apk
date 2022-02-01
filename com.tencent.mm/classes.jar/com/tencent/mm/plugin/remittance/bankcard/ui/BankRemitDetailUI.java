package com.tencent.mm.plugin.remittance.bankcard.ui;

import android.content.Intent;
import android.content.res.Resources;
import android.graphics.drawable.ColorDrawable;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.ActionBar;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.p;
import com.tencent.mm.plugin.remittance.bankcard.b.l;
import com.tencent.mm.plugin.wxpay.a.c;
import com.tencent.mm.plugin.wxpay.a.f;
import com.tencent.mm.plugin.wxpay.a.g;
import com.tencent.mm.plugin.wxpay.a.i;
import com.tencent.mm.protocal.protobuf.ekh;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.component.UIComponent;
import com.tencent.mm.wallet_core.model.r;
import com.tencent.mm.wallet_core.model.r.a;
import java.util.HashSet;

@com.tencent.mm.ui.base.a(19)
public class BankRemitDetailUI
  extends BankRemitBaseUI
{
  private ImageView OdR;
  private ImageView OdS;
  private ImageView OdT;
  private TextView OdU;
  private TextView OdV;
  private TextView OdW;
  private TextView OdX;
  private TextView OdY;
  private TextView OdZ;
  private View Oea;
  private View Oeb;
  private ViewGroup Oec;
  private String Oed;
  private int mState;
  private int pNJ;
  private Button tHj;
  private LinearLayout thn;
  
  protected final void fPx()
  {
    AppMethodBeat.i(67515);
    getSupportActionBar().setBackgroundDrawable(new ColorDrawable(getResources().getColor(a.c.white)));
    Object localObject = getSupportActionBar().getCustomView();
    if (localObject != null)
    {
      View localView = ((View)localObject).findViewById(a.f.divider);
      if (localView != null) {
        localView.setBackgroundColor(getResources().getColor(a.c.half_alpha_white));
      }
      localObject = ((View)localObject).findViewById(16908308);
      if ((localObject != null) && ((localObject instanceof TextView))) {
        ((TextView)localObject).setTextColor(getResources().getColor(a.c.normal_text_color));
      }
    }
    if (Build.VERSION.SDK_INT >= 21)
    {
      localObject = getWindow();
      ((Window)localObject).addFlags(-2147483648);
      ((Window)localObject).setStatusBarColor(getResources().getColor(a.c.white));
    }
    BankRemitBaseUI.bk(this);
    getContentView().setFitsSystemWindows(true);
    AppMethodBeat.o(67515);
  }
  
  public int getLayoutId()
  {
    return a.g.bank_remit_detail_ui;
  }
  
  public void initView()
  {
    AppMethodBeat.i(67514);
    this.OdR = ((ImageView)findViewById(a.f.brdu_state_iv_1));
    this.OdS = ((ImageView)findViewById(a.f.brdu_state_iv_2));
    this.OdT = ((ImageView)findViewById(a.f.brdu_state_iv_3));
    this.OdU = ((TextView)findViewById(a.f.brdu_state_title_tv_1));
    this.OdV = ((TextView)findViewById(a.f.brdu_state_title_tv_2));
    this.OdW = ((TextView)findViewById(a.f.brdu_state_title_tv_3));
    this.OdX = ((TextView)findViewById(a.f.brdu_state_desc_tv_1));
    this.OdY = ((TextView)findViewById(a.f.brdu_state_desc_tv_2));
    this.OdZ = ((TextView)findViewById(a.f.brdu_state_desc_tv_3));
    this.Oea = findViewById(a.f.brdu_state_line_1);
    this.Oeb = findViewById(a.f.brdu_state_line_2);
    this.thn = ((LinearLayout)findViewById(a.f.brdu_content_layout));
    this.Oec = ((ViewGroup)findViewById(a.f.brdu_root_layout));
    if (this.pNJ == 1)
    {
      findViewById(a.f.brdu_finish_layout).setVisibility(8);
      AppMethodBeat.o(67514);
      return;
    }
    this.tHj = ((Button)findViewById(a.f.brdu_finish_btn));
    this.tHj.setOnClickListener(new BankRemitDetailUI.2(this));
    AppMethodBeat.o(67514);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(67513);
    super.onCreate(paramBundle);
    addSceneEndListener(1579);
    this.Oed = getIntent().getStringExtra("key_transfer_bill_id");
    this.pNJ = getIntent().getIntExtra("key_enter_scene", 0);
    Log.i("MicroMsg.BankRemitDetailUI", "billId: %s, enterScene: %s", new Object[] { this.Oed, Integer.valueOf(this.pNJ) });
    initView();
    Log.i("MicroMsg.BankRemitDetailUI", "do query detail");
    doSceneProgress(new l(this.Oed));
    if (this.pNJ == 0)
    {
      showHomeBtn(false);
      enableBackMenu(false);
      setMMTitle(a.i.bank_remit_detail_title_2);
    }
    for (;;)
    {
      setBackBtn(new BankRemitDetailUI.1(this));
      AppMethodBeat.o(67513);
      return;
      showHomeBtn(true);
      enableBackMenu(true);
      setMMTitle(a.i.bank_remit_detail_title_1);
    }
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(67517);
    super.onDestroy();
    removeSceneEndListener(1579);
    AppMethodBeat.o(67517);
  }
  
  public boolean onSceneEnd(int paramInt1, int paramInt2, final String paramString, p paramp)
  {
    AppMethodBeat.i(67516);
    if ((paramp instanceof l))
    {
      paramString = (l)paramp;
      paramString.a(new r.a()
      {
        public final void c(int paramAnonymousInt1, int paramAnonymousInt2, String paramAnonymousString, p paramAnonymousp)
        {
          AppMethodBeat.i(67512);
          Log.i("MicroMsg.BankRemitDetailUI", "state: %s, amount: %s, fee: %s, account: %s", new Object[] { Integer.valueOf(paramString.Ocl.state), Integer.valueOf(paramString.Ocl.amount), Integer.valueOf(paramString.Ocl.abpt), paramString.Ocl.abpu });
          BankRemitDetailUI.a(BankRemitDetailUI.this, paramString.Ocl.state);
          BankRemitDetailUI.a(BankRemitDetailUI.this, paramString.Ocl.state, paramString.Ocl.abps);
          BankRemitDetailUI.a(BankRemitDetailUI.this, paramString.Ocl);
          BankRemitDetailUI.a(BankRemitDetailUI.this).setVisibility(0);
          AppMethodBeat.o(67512);
        }
      }).b(new r.a()
      {
        public final void c(int paramAnonymousInt1, int paramAnonymousInt2, String paramAnonymousString, p paramAnonymousp)
        {
          AppMethodBeat.i(67511);
          Log.e("MicroMsg.BankRemitDetailUI", "detail reponse error: %s, %s", new Object[] { Integer.valueOf(paramString.Ocl.hAV), paramString.Ocl.wYI });
          if (!Util.isNullOrNil(paramString.Ocl.wYI))
          {
            Toast.makeText(BankRemitDetailUI.this, paramString.Ocl.wYI, 1).show();
            AppMethodBeat.o(67511);
            return;
          }
          Toast.makeText(BankRemitDetailUI.this, a.i.bank_remit_detail_fetch_fail_text, 1).show();
          AppMethodBeat.o(67511);
        }
      }).c(new r.a()
      {
        public final void c(int paramAnonymousInt1, int paramAnonymousInt2, String paramAnonymousString, p paramAnonymousp)
        {
          AppMethodBeat.i(67510);
          Log.e("MicroMsg.BankRemitDetailUI", "net error: %s", new Object[] { paramAnonymousp });
          Toast.makeText(BankRemitDetailUI.this, a.i.bank_remit_detail_fetch_fail_text, 1).show();
          AppMethodBeat.o(67510);
        }
      });
    }
    AppMethodBeat.o(67516);
    return true;
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
  
  public void superImportUIComponents(HashSet<Class<? extends UIComponent>> paramHashSet)
  {
    AppMethodBeat.i(288762);
    super.superImportUIComponents(paramHashSet);
    paramHashSet.add(com.tencent.mm.plugin.remittance.bankcard.a.a.class);
    AppMethodBeat.o(288762);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.remittance.bankcard.ui.BankRemitDetailUI
 * JD-Core Version:    0.7.0.1
 */