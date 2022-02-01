package com.tencent.mm.plugin.remittance.bankcard.ui;

import android.app.Activity;
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
import com.tencent.mm.an.q;
import com.tencent.mm.plugin.remittance.bankcard.a.l;
import com.tencent.mm.plugin.wxpay.a.c;
import com.tencent.mm.plugin.wxpay.a.f;
import com.tencent.mm.plugin.wxpay.a.g;
import com.tencent.mm.plugin.wxpay.a.i;
import com.tencent.mm.protocal.protobuf.drm;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.base.a;
import com.tencent.mm.wallet_core.c.r;
import com.tencent.mm.wallet_core.c.r.a;

@a(19)
public class BankRemitDetailUI
  extends BankRemitBaseUI
{
  private String IhA;
  private ImageView Iho;
  private ImageView Ihp;
  private ImageView Ihq;
  private TextView Ihr;
  private TextView Ihs;
  private TextView Iht;
  private TextView Ihu;
  private TextView Ihv;
  private TextView Ihw;
  private View Ihx;
  private View Ihy;
  private ViewGroup Ihz;
  private int mRc;
  private int mState;
  private Button qCl;
  private LinearLayout qct;
  
  protected final void eHM()
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
    BankRemitBaseUI.aI(this);
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
    this.Iho = ((ImageView)findViewById(a.f.brdu_state_iv_1));
    this.Ihp = ((ImageView)findViewById(a.f.brdu_state_iv_2));
    this.Ihq = ((ImageView)findViewById(a.f.brdu_state_iv_3));
    this.Ihr = ((TextView)findViewById(a.f.brdu_state_title_tv_1));
    this.Ihs = ((TextView)findViewById(a.f.brdu_state_title_tv_2));
    this.Iht = ((TextView)findViewById(a.f.brdu_state_title_tv_3));
    this.Ihu = ((TextView)findViewById(a.f.brdu_state_desc_tv_1));
    this.Ihv = ((TextView)findViewById(a.f.brdu_state_desc_tv_2));
    this.Ihw = ((TextView)findViewById(a.f.brdu_state_desc_tv_3));
    this.Ihx = findViewById(a.f.brdu_state_line_1);
    this.Ihy = findViewById(a.f.brdu_state_line_2);
    this.qct = ((LinearLayout)findViewById(a.f.brdu_content_layout));
    this.Ihz = ((ViewGroup)findViewById(a.f.brdu_root_layout));
    if (this.mRc == 1)
    {
      findViewById(a.f.brdu_finish_layout).setVisibility(8);
      AppMethodBeat.o(67514);
      return;
    }
    this.qCl = ((Button)findViewById(a.f.brdu_finish_btn));
    this.qCl.setOnClickListener(new BankRemitDetailUI.2(this));
    AppMethodBeat.o(67514);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(67513);
    super.onCreate(paramBundle);
    addSceneEndListener(1579);
    this.IhA = getIntent().getStringExtra("key_transfer_bill_id");
    this.mRc = getIntent().getIntExtra("key_enter_scene", 0);
    Log.i("MicroMsg.BankRemitDetailUI", "billId: %s, enterScene: %s", new Object[] { this.IhA, Integer.valueOf(this.mRc) });
    initView();
    Log.i("MicroMsg.BankRemitDetailUI", "do query detail");
    doSceneProgress(new l(this.IhA));
    if (this.mRc == 0)
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
  
  public boolean onSceneEnd(int paramInt1, int paramInt2, final String paramString, q paramq)
  {
    AppMethodBeat.i(67516);
    if ((paramq instanceof l))
    {
      paramString = (l)paramq;
      paramString.a(new r.a()
      {
        public final void e(int paramAnonymousInt1, int paramAnonymousInt2, String paramAnonymousString, q paramAnonymousq)
        {
          AppMethodBeat.i(67512);
          Log.i("MicroMsg.BankRemitDetailUI", "state: %s, amount: %s, fee: %s, account: %s", new Object[] { Integer.valueOf(paramString.IfM.state), Integer.valueOf(paramString.IfM.amount), Integer.valueOf(paramString.IfM.TYw), paramString.IfM.TYx });
          BankRemitDetailUI.a(BankRemitDetailUI.this, paramString.IfM.state);
          BankRemitDetailUI.a(BankRemitDetailUI.this, paramString.IfM.state, paramString.IfM.TYv);
          BankRemitDetailUI.a(BankRemitDetailUI.this, paramString.IfM);
          BankRemitDetailUI.a(BankRemitDetailUI.this).setVisibility(0);
          AppMethodBeat.o(67512);
        }
      }).b(new r.a()
      {
        public final void e(int paramAnonymousInt1, int paramAnonymousInt2, String paramAnonymousString, q paramAnonymousq)
        {
          AppMethodBeat.i(67511);
          Log.e("MicroMsg.BankRemitDetailUI", "detail reponse error: %s, %s", new Object[] { Integer.valueOf(paramString.IfM.fwx), paramString.IfM.tVo });
          if (!Util.isNullOrNil(paramString.IfM.tVo))
          {
            Toast.makeText(BankRemitDetailUI.this, paramString.IfM.tVo, 1).show();
            AppMethodBeat.o(67511);
            return;
          }
          Toast.makeText(BankRemitDetailUI.this, a.i.bank_remit_detail_fetch_fail_text, 1).show();
          AppMethodBeat.o(67511);
        }
      }).c(new r.a()
      {
        public final void e(int paramAnonymousInt1, int paramAnonymousInt2, String paramAnonymousString, q paramAnonymousq)
        {
          AppMethodBeat.i(67510);
          Log.e("MicroMsg.BankRemitDetailUI", "net error: %s", new Object[] { paramAnonymousq });
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
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.remittance.bankcard.ui.BankRemitDetailUI
 * JD-Core Version:    0.7.0.1
 */