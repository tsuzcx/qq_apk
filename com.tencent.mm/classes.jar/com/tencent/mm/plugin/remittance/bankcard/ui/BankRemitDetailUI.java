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
import com.tencent.mm.ak.n;
import com.tencent.mm.plugin.remittance.bankcard.a.l;
import com.tencent.mm.protocal.protobuf.cjz;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.bs;
import com.tencent.mm.ui.base.a;
import com.tencent.mm.wallet_core.c.r;
import com.tencent.mm.wallet_core.c.r.a;

@a(19)
public class BankRemitDetailUI
  extends BankRemitBaseUI
{
  private int iFE;
  private LinearLayout lJf;
  private Button lKB;
  private int mState;
  private ImageView wFU;
  private ImageView wFV;
  private ImageView wFW;
  private TextView wFX;
  private TextView wFY;
  private TextView wFZ;
  private TextView wGa;
  private TextView wGb;
  private TextView wGc;
  private View wGd;
  private View wGe;
  private ViewGroup wGf;
  private String wGg;
  
  protected final void cSW()
  {
    AppMethodBeat.i(67515);
    getSupportActionBar().setBackgroundDrawable(new ColorDrawable(getResources().getColor(2131101179)));
    Object localObject = getSupportActionBar().getCustomView();
    if (localObject != null)
    {
      View localView = ((View)localObject).findViewById(2131299154);
      if (localView != null) {
        localView.setBackgroundColor(getResources().getColor(2131100483));
      }
      localObject = ((View)localObject).findViewById(16908308);
      if ((localObject != null) && ((localObject instanceof TextView))) {
        ((TextView)localObject).setTextColor(getResources().getColor(2131100711));
      }
    }
    if (Build.VERSION.SDK_INT >= 21)
    {
      localObject = getWindow();
      ((Window)localObject).addFlags(-2147483648);
      ((Window)localObject).setStatusBarColor(getResources().getColor(2131101179));
    }
    BankRemitBaseUI.aA(this);
    getContentView().setFitsSystemWindows(true);
    AppMethodBeat.o(67515);
  }
  
  public int getLayoutId()
  {
    return 2131493153;
  }
  
  public void initView()
  {
    AppMethodBeat.i(67514);
    this.wFU = ((ImageView)findViewById(2131297529));
    this.wFV = ((ImageView)findViewById(2131297530));
    this.wFW = ((ImageView)findViewById(2131297531));
    this.wFX = ((TextView)findViewById(2131297537));
    this.wFY = ((TextView)findViewById(2131297538));
    this.wFZ = ((TextView)findViewById(2131297539));
    this.wGa = ((TextView)findViewById(2131297526));
    this.wGb = ((TextView)findViewById(2131297527));
    this.wGc = ((TextView)findViewById(2131297528));
    this.wGd = findViewById(2131297535);
    this.wGe = findViewById(2131297536);
    this.lJf = ((LinearLayout)findViewById(2131297520));
    this.wGf = ((ViewGroup)findViewById(2131297525));
    if (this.iFE == 1)
    {
      findViewById(2131297524).setVisibility(8);
      AppMethodBeat.o(67514);
      return;
    }
    this.lKB = ((Button)findViewById(2131297523));
    this.lKB.setOnClickListener(new BankRemitDetailUI.2(this));
    AppMethodBeat.o(67514);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(67513);
    super.onCreate(paramBundle);
    addSceneEndListener(1579);
    this.wGg = getIntent().getStringExtra("key_transfer_bill_id");
    this.iFE = getIntent().getIntExtra("key_enter_scene", 0);
    ac.i("MicroMsg.BankRemitDetailUI", "billId: %s, enterScene: %s", new Object[] { this.wGg, Integer.valueOf(this.iFE) });
    initView();
    ac.i("MicroMsg.BankRemitDetailUI", "do query detail");
    doSceneProgress(new l(this.wGg));
    if (this.iFE == 0)
    {
      showHomeBtn(false);
      enableBackMenu(false);
      setMMTitle(2131756377);
    }
    for (;;)
    {
      setBackBtn(new BankRemitDetailUI.1(this));
      AppMethodBeat.o(67513);
      return;
      showHomeBtn(true);
      enableBackMenu(true);
      setMMTitle(2131756376);
    }
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(67517);
    super.onDestroy();
    removeSceneEndListener(1579);
    AppMethodBeat.o(67517);
  }
  
  public boolean onSceneEnd(int paramInt1, int paramInt2, final String paramString, n paramn)
  {
    AppMethodBeat.i(67516);
    if ((paramn instanceof l))
    {
      paramString = (l)paramn;
      paramString.a(new r.a()
      {
        public final void d(int paramAnonymousInt1, int paramAnonymousInt2, String paramAnonymousString, n paramAnonymousn)
        {
          AppMethodBeat.i(67512);
          ac.i("MicroMsg.BankRemitDetailUI", "state: %s, amount: %s, fee: %s, account: %s", new Object[] { Integer.valueOf(paramString.wEs.state), Integer.valueOf(paramString.wEs.uiK), Integer.valueOf(paramString.wEs.Fyj), paramString.wEs.Fyk });
          BankRemitDetailUI.a(BankRemitDetailUI.this, paramString.wEs.state);
          BankRemitDetailUI.a(BankRemitDetailUI.this, paramString.wEs.state, paramString.wEs.Fyi);
          BankRemitDetailUI.a(BankRemitDetailUI.this, paramString.wEs);
          BankRemitDetailUI.a(BankRemitDetailUI.this).setVisibility(0);
          AppMethodBeat.o(67512);
        }
      }).b(new r.a()
      {
        public final void d(int paramAnonymousInt1, int paramAnonymousInt2, String paramAnonymousString, n paramAnonymousn)
        {
          AppMethodBeat.i(67511);
          ac.e("MicroMsg.BankRemitDetailUI", "detail reponse error: %s, %s", new Object[] { Integer.valueOf(paramString.wEs.dae), paramString.wEs.oxf });
          if (!bs.isNullOrNil(paramString.wEs.oxf))
          {
            Toast.makeText(BankRemitDetailUI.this, paramString.wEs.oxf, 1).show();
            AppMethodBeat.o(67511);
            return;
          }
          Toast.makeText(BankRemitDetailUI.this, 2131756363, 1).show();
          AppMethodBeat.o(67511);
        }
      }).c(new r.a()
      {
        public final void d(int paramAnonymousInt1, int paramAnonymousInt2, String paramAnonymousString, n paramAnonymousn)
        {
          AppMethodBeat.i(67510);
          ac.e("MicroMsg.BankRemitDetailUI", "net error: %s", new Object[] { paramAnonymousn });
          Toast.makeText(BankRemitDetailUI.this, 2131756363, 1).show();
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.remittance.bankcard.ui.BankRemitDetailUI
 * JD-Core Version:    0.7.0.1
 */