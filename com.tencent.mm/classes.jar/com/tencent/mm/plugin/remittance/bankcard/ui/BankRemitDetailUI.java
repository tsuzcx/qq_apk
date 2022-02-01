package com.tencent.mm.plugin.remittance.bankcard.ui;

import android.app.Activity;
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
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.q;
import com.tencent.mm.plugin.remittance.bankcard.a.l;
import com.tencent.mm.protocal.protobuf.dhs;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.base.a;
import com.tencent.mm.wallet_core.c.r;
import com.tencent.mm.wallet_core.c.r.a;

@a(19)
public class BankRemitDetailUI
  extends BankRemitBaseUI
{
  private TextView CkA;
  private TextView CkB;
  private TextView CkC;
  private TextView CkD;
  private View CkE;
  private View CkF;
  private ViewGroup CkG;
  private String CkH;
  private ImageView Ckv;
  private ImageView Ckw;
  private ImageView Ckx;
  private TextView Cky;
  private TextView Ckz;
  private int jZJ;
  private int mState;
  private Button nAa;
  private LinearLayout ncf;
  
  protected final void dYP()
  {
    AppMethodBeat.i(67515);
    getSupportActionBar().setBackgroundDrawable(new ColorDrawable(getResources().getColor(2131101424)));
    Object localObject = getSupportActionBar().getCustomView();
    if (localObject != null)
    {
      View localView = ((View)localObject).findViewById(2131299682);
      if (localView != null) {
        localView.setBackgroundColor(getResources().getColor(2131100585));
      }
      localObject = ((View)localObject).findViewById(16908308);
      if ((localObject != null) && ((localObject instanceof TextView))) {
        ((TextView)localObject).setTextColor(getResources().getColor(2131100904));
      }
    }
    if (Build.VERSION.SDK_INT >= 21)
    {
      localObject = getWindow();
      ((Window)localObject).addFlags(-2147483648);
      ((Window)localObject).setStatusBarColor(getResources().getColor(2131101424));
    }
    BankRemitBaseUI.aC(this);
    getContentView().setFitsSystemWindows(true);
    AppMethodBeat.o(67515);
  }
  
  public int getLayoutId()
  {
    return 2131493199;
  }
  
  public void initView()
  {
    AppMethodBeat.i(67514);
    this.Ckv = ((ImageView)findViewById(2131297755));
    this.Ckw = ((ImageView)findViewById(2131297756));
    this.Ckx = ((ImageView)findViewById(2131297757));
    this.Cky = ((TextView)findViewById(2131297763));
    this.Ckz = ((TextView)findViewById(2131297764));
    this.CkA = ((TextView)findViewById(2131297765));
    this.CkB = ((TextView)findViewById(2131297752));
    this.CkC = ((TextView)findViewById(2131297753));
    this.CkD = ((TextView)findViewById(2131297754));
    this.CkE = findViewById(2131297761);
    this.CkF = findViewById(2131297762);
    this.ncf = ((LinearLayout)findViewById(2131297746));
    this.CkG = ((ViewGroup)findViewById(2131297751));
    if (this.jZJ == 1)
    {
      findViewById(2131297750).setVisibility(8);
      AppMethodBeat.o(67514);
      return;
    }
    this.nAa = ((Button)findViewById(2131297749));
    this.nAa.setOnClickListener(new BankRemitDetailUI.2(this));
    AppMethodBeat.o(67514);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(67513);
    super.onCreate(paramBundle);
    addSceneEndListener(1579);
    this.CkH = getIntent().getStringExtra("key_transfer_bill_id");
    this.jZJ = getIntent().getIntExtra("key_enter_scene", 0);
    Log.i("MicroMsg.BankRemitDetailUI", "billId: %s, enterScene: %s", new Object[] { this.CkH, Integer.valueOf(this.jZJ) });
    initView();
    Log.i("MicroMsg.BankRemitDetailUI", "do query detail");
    doSceneProgress(new l(this.CkH));
    if (this.jZJ == 0)
    {
      showHomeBtn(false);
      enableBackMenu(false);
      setMMTitle(2131756512);
    }
    for (;;)
    {
      setBackBtn(new BankRemitDetailUI.1(this));
      AppMethodBeat.o(67513);
      return;
      showHomeBtn(true);
      enableBackMenu(true);
      setMMTitle(2131756511);
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
        public final void d(int paramAnonymousInt1, int paramAnonymousInt2, String paramAnonymousString, q paramAnonymousq)
        {
          AppMethodBeat.i(67512);
          Log.i("MicroMsg.BankRemitDetailUI", "state: %s, amount: %s, fee: %s, account: %s", new Object[] { Integer.valueOf(paramString.CiT.state), Integer.valueOf(paramString.CiT.yRL), Integer.valueOf(paramString.CiT.MMC), paramString.CiT.MMD });
          BankRemitDetailUI.a(BankRemitDetailUI.this, paramString.CiT.state);
          BankRemitDetailUI.a(BankRemitDetailUI.this, paramString.CiT.state, paramString.CiT.MMB);
          BankRemitDetailUI.a(BankRemitDetailUI.this, paramString.CiT);
          BankRemitDetailUI.a(BankRemitDetailUI.this).setVisibility(0);
          AppMethodBeat.o(67512);
        }
      }).b(new r.a()
      {
        public final void d(int paramAnonymousInt1, int paramAnonymousInt2, String paramAnonymousString, q paramAnonymousq)
        {
          AppMethodBeat.i(67511);
          Log.e("MicroMsg.BankRemitDetailUI", "detail reponse error: %s, %s", new Object[] { Integer.valueOf(paramString.CiT.dDN), paramString.CiT.qwn });
          if (!Util.isNullOrNil(paramString.CiT.qwn))
          {
            Toast.makeText(BankRemitDetailUI.this, paramString.CiT.qwn, 1).show();
            AppMethodBeat.o(67511);
            return;
          }
          Toast.makeText(BankRemitDetailUI.this, 2131756498, 1).show();
          AppMethodBeat.o(67511);
        }
      }).c(new r.a()
      {
        public final void d(int paramAnonymousInt1, int paramAnonymousInt2, String paramAnonymousString, q paramAnonymousq)
        {
          AppMethodBeat.i(67510);
          Log.e("MicroMsg.BankRemitDetailUI", "net error: %s", new Object[] { paramAnonymousq });
          Toast.makeText(BankRemitDetailUI.this, 2131756498, 1).show();
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