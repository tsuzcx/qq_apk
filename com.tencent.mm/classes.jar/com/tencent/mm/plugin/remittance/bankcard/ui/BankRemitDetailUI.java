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
import com.tencent.mm.al.n;
import com.tencent.mm.plugin.remittance.bankcard.a.l;
import com.tencent.mm.protocal.protobuf.coz;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.ui.base.a;
import com.tencent.mm.wallet_core.c.r;
import com.tencent.mm.wallet_core.c.r.a;

@a(19)
public class BankRemitDetailUI
  extends BankRemitBaseUI
{
  private int iYN;
  private LinearLayout lPV;
  private int mState;
  private Button mkr;
  private ImageView xTB;
  private ImageView xTC;
  private ImageView xTD;
  private TextView xTE;
  private TextView xTF;
  private TextView xTG;
  private TextView xTH;
  private TextView xTI;
  private TextView xTJ;
  private View xTK;
  private View xTL;
  private ViewGroup xTM;
  private String xTN;
  
  protected final void dcd()
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
    this.xTB = ((ImageView)findViewById(2131297529));
    this.xTC = ((ImageView)findViewById(2131297530));
    this.xTD = ((ImageView)findViewById(2131297531));
    this.xTE = ((TextView)findViewById(2131297537));
    this.xTF = ((TextView)findViewById(2131297538));
    this.xTG = ((TextView)findViewById(2131297539));
    this.xTH = ((TextView)findViewById(2131297526));
    this.xTI = ((TextView)findViewById(2131297527));
    this.xTJ = ((TextView)findViewById(2131297528));
    this.xTK = findViewById(2131297535);
    this.xTL = findViewById(2131297536);
    this.lPV = ((LinearLayout)findViewById(2131297520));
    this.xTM = ((ViewGroup)findViewById(2131297525));
    if (this.iYN == 1)
    {
      findViewById(2131297524).setVisibility(8);
      AppMethodBeat.o(67514);
      return;
    }
    this.mkr = ((Button)findViewById(2131297523));
    this.mkr.setOnClickListener(new BankRemitDetailUI.2(this));
    AppMethodBeat.o(67514);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(67513);
    super.onCreate(paramBundle);
    addSceneEndListener(1579);
    this.xTN = getIntent().getStringExtra("key_transfer_bill_id");
    this.iYN = getIntent().getIntExtra("key_enter_scene", 0);
    ad.i("MicroMsg.BankRemitDetailUI", "billId: %s, enterScene: %s", new Object[] { this.xTN, Integer.valueOf(this.iYN) });
    initView();
    ad.i("MicroMsg.BankRemitDetailUI", "do query detail");
    doSceneProgress(new l(this.xTN));
    if (this.iYN == 0)
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
          ad.i("MicroMsg.BankRemitDetailUI", "state: %s, amount: %s, fee: %s, account: %s", new Object[] { Integer.valueOf(paramString.xRZ.state), Integer.valueOf(paramString.xRZ.vls), Integer.valueOf(paramString.xRZ.Hio), paramString.xRZ.Hip });
          BankRemitDetailUI.a(BankRemitDetailUI.this, paramString.xRZ.state);
          BankRemitDetailUI.a(BankRemitDetailUI.this, paramString.xRZ.state, paramString.xRZ.Hin);
          BankRemitDetailUI.a(BankRemitDetailUI.this, paramString.xRZ);
          BankRemitDetailUI.a(BankRemitDetailUI.this).setVisibility(0);
          AppMethodBeat.o(67512);
        }
      }).b(new r.a()
      {
        public final void d(int paramAnonymousInt1, int paramAnonymousInt2, String paramAnonymousString, n paramAnonymousn)
        {
          AppMethodBeat.i(67511);
          ad.e("MicroMsg.BankRemitDetailUI", "detail reponse error: %s, %s", new Object[] { Integer.valueOf(paramString.xRZ.dlw), paramString.xRZ.paA });
          if (!bt.isNullOrNil(paramString.xRZ.paA))
          {
            Toast.makeText(BankRemitDetailUI.this, paramString.xRZ.paA, 1).show();
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
          ad.e("MicroMsg.BankRemitDetailUI", "net error: %s", new Object[] { paramAnonymousn });
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.remittance.bankcard.ui.BankRemitDetailUI
 * JD-Core Version:    0.7.0.1
 */