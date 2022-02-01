package com.tencent.mm.plugin.wallet_payu.remittance.ui;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.os.Bundle;
import android.text.SpannableString;
import android.text.method.LinkMovementMethod;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.n;
import com.tencent.mm.bs.d;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.u;
import com.tencent.mm.plugin.order.c.a;
import com.tencent.mm.plugin.order.c.a.a;
import com.tencent.mm.plugin.remittance.ui.RemittanceDetailUI;
import com.tencent.mm.plugin.wallet_payu.remittance.a.b;
import com.tencent.mm.plugin.wallet_payu.remittance.a.c;
import com.tencent.mm.pluginsdk.ui.span.k;
import com.tencent.mm.pluginsdk.wallet.f;
import com.tencent.mm.storage.ab;
import com.tencent.mm.ui.base.h;

public class PayURemittanceDetailUI
  extends RemittanceDetailUI
{
  private String AAR;
  private String AAS;
  private int AAT;
  private String mReceiverName;
  private int uoH;
  private int uoI;
  private int vHe;
  private int xZv;
  
  public final void KE(int paramInt)
  {
    AppMethodBeat.i(72195);
    doSceneProgress(new com.tencent.mm.plugin.wallet_payu.remittance.a.e(this.vDb, this.vHa, this.vGX), true);
    AppMethodBeat.o(72195);
  }
  
  public final void KF(int paramInt)
  {
    AppMethodBeat.i(72196);
    doSceneProgress(new com.tencent.mm.plugin.wallet_payu.remittance.a.e(this.vDb, this.vHa, this.vGX, paramInt), true);
    AppMethodBeat.o(72196);
  }
  
  public final void aB(Intent paramIntent)
  {
    AppMethodBeat.i(72197);
    d.b(this, "wallet_payu", ".remittance.ui.PayURemittanceResendMsgUI", paramIntent);
    AppMethodBeat.o(72197);
  }
  
  public final void dku()
  {
    AppMethodBeat.i(72198);
    doSceneProgress(new c(this.vDb, this.vHe, this.AAR, this.vHa));
    AppMethodBeat.o(72198);
  }
  
  public final void dkv()
  {
    AppMethodBeat.i(72199);
    doSceneProgress(new b(this.vDb, this.vHe, this.AAR, this.vHa));
    AppMethodBeat.o(72199);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(72194);
    super.onCreate(paramBundle);
    this.vHe = getIntent().getIntExtra("total_fee", 0);
    this.AAR = getIntent().getStringExtra("fee_type");
    if (getIntent().getBooleanExtra("is_sender", false))
    {
      this.AAS = u.aqG();
      this.mReceiverName = this.vHa;
      AppMethodBeat.o(72194);
      return;
    }
    this.AAS = this.vHa;
    this.mReceiverName = u.aqG();
    AppMethodBeat.o(72194);
  }
  
  public boolean onSceneEnd(int paramInt1, int paramInt2, String paramString, n paramn)
  {
    boolean bool2 = false;
    AppMethodBeat.i(72200);
    if ((paramn instanceof com.tencent.mm.plugin.wallet_payu.remittance.a.e))
    {
      paramString = (com.tencent.mm.plugin.wallet_payu.remittance.a.e)paramn;
      Object localObject1;
      Object localObject2;
      a locala;
      if (paramString.diR == 0)
      {
        if ((paramInt1 == 0) && (paramInt2 == 0))
        {
          if ((this.vGY == 1) && (!getIntent().getBooleanExtra("is_sender", false)))
          {
            this.vyw.setImageResource(2131234714);
            this.vGm.setText(2131762473);
            this.vGn.setText(com.tencent.mm.wallet_core.ui.e.d(paramString.nUf, paramString.uop));
            this.vGq.setVisibility(0);
            this.vGq.setOnClickListener(new View.OnClickListener()
            {
              public final void onClick(View paramAnonymousView)
              {
                AppMethodBeat.i(72190);
                PayURemittanceDetailUI.this.dku();
                AppMethodBeat.o(72190);
              }
            });
            paramn = getString(2131762477, new Object[] { Integer.valueOf(this.vHc) });
            localObject1 = getString(2131762465);
            localObject2 = new SpannableString(paramn + (String)localObject1);
            locala = new a(this);
            locala.uqW = new a.a()
            {
              public final void onClick(View paramAnonymousView)
              {
                AppMethodBeat.i(72192);
                h.d(PayURemittanceDetailUI.this, PayURemittanceDetailUI.this.getString(2131762461, new Object[] { PayURemittanceDetailUI.auH(PayURemittanceDetailUI.f(PayURemittanceDetailUI.this)) }), PayURemittanceDetailUI.this.getString(2131755873), PayURemittanceDetailUI.this.getString(2131762466), PayURemittanceDetailUI.this.getString(2131755691), new DialogInterface.OnClickListener()new DialogInterface.OnClickListener
                {
                  public final void onClick(DialogInterface paramAnonymous2DialogInterface, int paramAnonymous2Int)
                  {
                    AppMethodBeat.i(72191);
                    PayURemittanceDetailUI.this.dkv();
                    AppMethodBeat.o(72191);
                  }
                }, new DialogInterface.OnClickListener()
                {
                  public final void onClick(DialogInterface paramAnonymous2DialogInterface, int paramAnonymous2Int) {}
                });
                AppMethodBeat.o(72192);
              }
            };
            ((SpannableString)localObject2).setSpan(locala, paramn.length(), paramn.length() + ((String)localObject1).length(), 33);
            this.tkx.setMovementMethod(LinkMovementMethod.getInstance());
            this.tkx.setText((CharSequence)localObject2);
            this.vGo.setText(getString(2131762482, new Object[] { com.tencent.mm.wallet_core.ui.e.nh(paramString.vBx) }));
            this.vGo.setVisibility(0);
            this.vGp.setVisibility(8);
          }
          AppMethodBeat.o(72200);
          return true;
        }
        KF(0);
        AppMethodBeat.o(72200);
        return true;
      }
      boolean bool1 = bool2;
      if (paramInt1 == 0)
      {
        bool1 = bool2;
        if (paramInt2 == 0)
        {
          this.AAT = paramString.status;
          this.xZv = paramString.vBx;
          this.uoI = paramString.AAN;
          this.uoH = paramString.AAO;
          this.vHe = ((int)(paramString.nUf * 100.0D));
          this.AAR = paramString.uop;
          paramn = u.aqG();
          bool1 = this.mReceiverName.equals(paramn);
          this.vGq.setVisibility(8);
          this.vGn.setText(com.tencent.mm.wallet_core.ui.e.d(this.vHe / 100.0D, this.AAR));
          this.vGr.setVisibility(0);
          this.vGN.setVisibility(8);
          paramInt1 = this.AAT;
        }
      }
      switch (paramInt1)
      {
      default: 
        finish();
        bool1 = true;
        if (paramString.dtM == 1)
        {
          g.afC();
          if (!((String)g.afB().afk().get(327729, "0")).equals("0")) {
            break label1562;
          }
          h.a(getContext(), 2131757192, 2131765800, new DialogInterface.OnClickListener()
          {
            public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
            {
              AppMethodBeat.i(72193);
              h.cf(PayURemittanceDetailUI.this.getContext(), PayURemittanceDetailUI.this.getString(2131762455));
              AppMethodBeat.o(72193);
            }
          });
          g.afC();
          g.afB().afk().set(327729, "1");
        }
        break;
      }
      for (;;)
      {
        AppMethodBeat.o(72200);
        return bool1;
        if (!bool1)
        {
          paramn = getString(2131762474, new Object[] { bq(this.mReceiverName, true) });
          this.vGm.setText(k.b(this, paramn, this.vGm.getTextSize()));
          paramn = getString(2131762481, new Object[] { Integer.valueOf(this.vHc) });
          localObject1 = getString(2131762520);
          localObject2 = new SpannableString(paramn + (String)localObject1);
          locala = new a(this);
          locala.uqW = new a.a()
          {
            public final void onClick(View paramAnonymousView)
            {
              AppMethodBeat.i(72184);
              h.d(PayURemittanceDetailUI.this, PayURemittanceDetailUI.this.getString(2131762443), PayURemittanceDetailUI.this.getString(2131755873), PayURemittanceDetailUI.this.getString(2131762519), PayURemittanceDetailUI.this.getString(2131755691), new DialogInterface.OnClickListener()new DialogInterface.OnClickListener
              {
                public final void onClick(DialogInterface paramAnonymous2DialogInterface, int paramAnonymous2Int)
                {
                  AppMethodBeat.i(72183);
                  paramAnonymous2DialogInterface = new Intent();
                  paramAnonymous2DialogInterface.putExtra("transaction_id", PayURemittanceDetailUI.a(PayURemittanceDetailUI.this));
                  paramAnonymous2DialogInterface.putExtra("receiver_name", PayURemittanceDetailUI.b(PayURemittanceDetailUI.this));
                  paramAnonymous2DialogInterface.putExtra("total_fee", PayURemittanceDetailUI.c(PayURemittanceDetailUI.this));
                  paramAnonymous2DialogInterface.putExtra("fee_type", PayURemittanceDetailUI.d(PayURemittanceDetailUI.this));
                  PayURemittanceDetailUI.this.aB(paramAnonymous2DialogInterface);
                  AppMethodBeat.o(72183);
                }
              }, new DialogInterface.OnClickListener()
              {
                public final void onClick(DialogInterface paramAnonymous2DialogInterface, int paramAnonymous2Int) {}
              });
              AppMethodBeat.o(72184);
            }
          };
          ((SpannableString)localObject2).setSpan(locala, paramn.length(), paramn.length() + ((String)localObject1).length(), 33);
          this.tkx.setMovementMethod(LinkMovementMethod.getInstance());
          this.tkx.setText((CharSequence)localObject2);
        }
        for (;;)
        {
          this.vyw.setImageResource(2131234714);
          this.vGo.setText(getString(2131762482, new Object[] { com.tencent.mm.wallet_core.ui.e.nh(this.uoI) }));
          this.vGo.setVisibility(0);
          this.vGp.setVisibility(8);
          bool1 = true;
          break;
          this.vyw.setImageResource(2131234714);
          this.vGq.setVisibility(0);
          this.vGq.setOnClickListener(new View.OnClickListener()
          {
            public final void onClick(View paramAnonymousView)
            {
              AppMethodBeat.i(72185);
              PayURemittanceDetailUI.this.dku();
              AppMethodBeat.o(72185);
            }
          });
          paramn = getString(2131762477, new Object[] { Integer.valueOf(this.vHc) });
          localObject1 = getString(2131762465);
          localObject2 = new SpannableString(paramn + (String)localObject1);
          locala = new a(this);
          locala.uqW = new a.a()
          {
            public final void onClick(View paramAnonymousView)
            {
              AppMethodBeat.i(72187);
              h.d(PayURemittanceDetailUI.this, PayURemittanceDetailUI.this.getString(2131762461, new Object[] { PayURemittanceDetailUI.auG(PayURemittanceDetailUI.e(PayURemittanceDetailUI.this)) }), PayURemittanceDetailUI.this.getString(2131755873), PayURemittanceDetailUI.this.getString(2131762466), PayURemittanceDetailUI.this.getString(2131755691), new DialogInterface.OnClickListener()new DialogInterface.OnClickListener
              {
                public final void onClick(DialogInterface paramAnonymous2DialogInterface, int paramAnonymous2Int)
                {
                  AppMethodBeat.i(72186);
                  PayURemittanceDetailUI.this.dkv();
                  AppMethodBeat.o(72186);
                }
              }, new DialogInterface.OnClickListener()
              {
                public final void onClick(DialogInterface paramAnonymous2DialogInterface, int paramAnonymous2Int) {}
              });
              AppMethodBeat.o(72187);
            }
          };
          ((SpannableString)localObject2).setSpan(locala, paramn.length(), paramn.length() + ((String)localObject1).length(), 33);
          this.tkx.setMovementMethod(LinkMovementMethod.getInstance());
          this.tkx.setText((CharSequence)localObject2);
        }
        this.vyw.setImageResource(2131691095);
        if (bool1)
        {
          this.vGm.setText(2131762468);
          paramn = getString(2131762449);
          localObject1 = new SpannableString(paramn);
          localObject2 = new a(this);
          ((a)localObject2).uqW = new a.a()
          {
            public final void onClick(View paramAnonymousView)
            {
              AppMethodBeat.i(72188);
              f.an(PayURemittanceDetailUI.this, 0);
              AppMethodBeat.o(72188);
            }
          };
          ((SpannableString)localObject1).setSpan(localObject2, 0, paramn.length(), 33);
          this.tkx.setMovementMethod(LinkMovementMethod.getInstance());
          this.tkx.setText((CharSequence)localObject1);
          this.tkx.setVisibility(0);
        }
        for (;;)
        {
          this.vGo.setText(getString(2131762482, new Object[] { com.tencent.mm.wallet_core.ui.e.nh(this.xZv) }));
          this.vGo.setVisibility(0);
          this.vGp.setText(getString(2131762457, new Object[] { com.tencent.mm.wallet_core.ui.e.nh(this.uoH) }));
          this.vGp.setVisibility(0);
          bool1 = true;
          break;
          paramn = bq(this.mReceiverName, true) + " " + getString(2131762468);
          this.vGm.setText(k.b(this, paramn, this.vGm.getTextSize()));
          this.tkx.setVisibility(8);
        }
        if ((paramInt1 == 2003) && (!bool1))
        {
          this.vyw.setImageResource(2131691097);
          this.vGm.setText(2131762472);
          label1260:
          if (bool1) {
            break label1549;
          }
          paramn = getString(2131762462);
          localObject1 = getString(2131762449);
          localObject2 = new SpannableString(paramn + (String)localObject1);
          locala = new a(this);
          locala.uqW = new a.a()
          {
            public final void onClick(View paramAnonymousView)
            {
              AppMethodBeat.i(72189);
              f.an(PayURemittanceDetailUI.this, 0);
              AppMethodBeat.o(72189);
            }
          };
          ((SpannableString)localObject2).setSpan(locala, paramn.length(), paramn.length() + ((String)localObject1).length(), 33);
          this.tkx.setMovementMethod(LinkMovementMethod.getInstance());
          this.tkx.setText((CharSequence)localObject2);
        }
        for (;;)
        {
          this.tkx.setVisibility(0);
          this.vGo.setText(getString(2131762482, new Object[] { com.tencent.mm.wallet_core.ui.e.nh(this.xZv) }));
          this.vGo.setVisibility(0);
          this.vGp.setText(getString(2131762460, new Object[] { com.tencent.mm.wallet_core.ui.e.nh(this.uoI) }));
          this.vGp.setVisibility(0);
          bool1 = true;
          break;
          this.vyw.setImageResource(2131691096);
          if (bool1)
          {
            this.vGm.setText(2131762470);
            break label1260;
          }
          paramn = bq(this.mReceiverName, true) + getString(2131762470);
          this.vGm.setText(k.b(this, paramn, this.vGm.getTextSize()));
          break label1260;
          label1549:
          this.tkx.setText("");
        }
        label1562:
        h.cf(getContext(), getString(2131762455));
      }
    }
    if (((paramn instanceof c)) || ((paramn instanceof b)))
    {
      if ((paramInt1 == 0) && (paramInt2 == 0))
      {
        if ((paramn instanceof c)) {
          KF(1);
        }
        for (;;)
        {
          AppMethodBeat.o(72200);
          return true;
          bB(0, getString(2131762456));
        }
      }
      bB(paramInt2, paramString);
      AppMethodBeat.o(72200);
      return true;
    }
    AppMethodBeat.o(72200);
    return false;
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet_payu.remittance.ui.PayURemittanceDetailUI
 * JD-Core Version:    0.7.0.1
 */