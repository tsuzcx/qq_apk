package com.tencent.mm.plugin.remittance.bankcard.ui;

import android.content.Intent;
import android.content.res.Resources;
import android.graphics.drawable.ColorDrawable;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;
import com.tencent.mm.ah.m;
import com.tencent.mm.plugin.remittance.bankcard.a.l;
import com.tencent.mm.plugin.wxpay.a.c;
import com.tencent.mm.plugin.wxpay.a.f;
import com.tencent.mm.plugin.wxpay.a.g;
import com.tencent.mm.plugin.wxpay.a.i;
import com.tencent.mm.protocal.c.bhr;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.a;
import com.tencent.mm.ui.s;
import com.tencent.mm.wallet_core.c.n;
import com.tencent.mm.wallet_core.c.n.a;
import com.tencent.mm.wallet_core.ui.WalletBaseUI;

@a(19)
public class BankRemitDetailUI
  extends BankRemitBaseUI
{
  private int faB;
  private LinearLayout llG;
  private Button llQ;
  private int mState;
  private ViewGroup nwA;
  private String nwB;
  private ImageView nwp;
  private ImageView nwq;
  private ImageView nwr;
  private TextView nws;
  private TextView nwt;
  private TextView nwu;
  private TextView nwv;
  private TextView nww;
  private TextView nwx;
  private View nwy;
  private View nwz;
  
  protected final void baU()
  {
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
        ((TextView)localObject).setTextColor(getResources().getColor(a.c.black));
      }
    }
    if (Build.VERSION.SDK_INT >= 21)
    {
      localObject = getWindow();
      ((Window)localObject).addFlags(-2147483648);
      ((Window)localObject).setStatusBarColor(getResources().getColor(a.c.white));
    }
    BankRemitBaseUI.J(this);
    this.mController.contentView.setFitsSystemWindows(true);
  }
  
  public final boolean c(int paramInt1, int paramInt2, final String paramString, m paramm)
  {
    if ((paramm instanceof l))
    {
      paramString = (l)paramm;
      paramString.a(new BankRemitDetailUI.5(this, paramString)).b(new n.a()
      {
        public final void f(int paramAnonymousInt1, int paramAnonymousInt2, String paramAnonymousString, m paramAnonymousm)
        {
          y.e("MicroMsg.BankRemitDetailUI", "detail reponse error: %s, %s", new Object[] { Integer.valueOf(paramString.nvb.iHq), paramString.nvb.iHr });
          if (!bk.bl(paramString.nvb.iHr))
          {
            Toast.makeText(BankRemitDetailUI.this, paramString.nvb.iHr, 1).show();
            return;
          }
          Toast.makeText(BankRemitDetailUI.this, a.i.bank_remit_detail_fetch_fail_text, 1).show();
        }
      }).c(new BankRemitDetailUI.3(this));
    }
    return true;
  }
  
  protected final int getLayoutId()
  {
    return a.g.bank_remit_detail_ui;
  }
  
  public final void initView()
  {
    this.nwp = ((ImageView)findViewById(a.f.brdu_state_iv_1));
    this.nwq = ((ImageView)findViewById(a.f.brdu_state_iv_2));
    this.nwr = ((ImageView)findViewById(a.f.brdu_state_iv_3));
    this.nws = ((TextView)findViewById(a.f.brdu_state_title_tv_1));
    this.nwt = ((TextView)findViewById(a.f.brdu_state_title_tv_2));
    this.nwu = ((TextView)findViewById(a.f.brdu_state_title_tv_3));
    this.nwv = ((TextView)findViewById(a.f.brdu_state_desc_tv_1));
    this.nww = ((TextView)findViewById(a.f.brdu_state_desc_tv_2));
    this.nwx = ((TextView)findViewById(a.f.brdu_state_desc_tv_3));
    this.nwy = findViewById(a.f.brdu_state_line_1);
    this.nwz = findViewById(a.f.brdu_state_line_2);
    this.llG = ((LinearLayout)findViewById(a.f.brdu_content_layout));
    this.nwA = ((ViewGroup)findViewById(a.f.brdu_root_layout));
    if (this.faB == 1)
    {
      findViewById(a.f.brdu_finish_layout).setVisibility(8);
      return;
    }
    this.llQ = ((Button)findViewById(a.f.brdu_finish_btn));
    this.llQ.setOnClickListener(new BankRemitDetailUI.2(this));
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    kh(1579);
    this.nwB = getIntent().getStringExtra("key_transfer_bill_id");
    this.faB = getIntent().getIntExtra("key_enter_scene", 0);
    y.i("MicroMsg.BankRemitDetailUI", "billId: %s, enterScene: %s", new Object[] { this.nwB, Integer.valueOf(this.faB) });
    initView();
    y.i("MicroMsg.BankRemitDetailUI", "do query detail");
    a(new l(this.nwB), true, true);
    if (this.faB == 0)
    {
      showHomeBtn(false);
      enableBackMenu(false);
      setMMTitle(a.i.bank_remit_detail_title_2);
    }
    for (;;)
    {
      setBackBtn(new BankRemitDetailUI.1(this));
      return;
      showHomeBtn(true);
      enableBackMenu(true);
      setMMTitle(a.i.bank_remit_detail_title_1);
    }
  }
  
  public void onDestroy()
  {
    super.onDestroy();
    ki(1579);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.remittance.bankcard.ui.BankRemitDetailUI
 * JD-Core Version:    0.7.0.1
 */