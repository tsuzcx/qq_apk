package com.tencent.mm.plugin.wallet_payu.remittance.ui;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.os.Bundle;
import android.text.SpannableString;
import android.text.method.LinkMovementMethod;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.q;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.z;
import com.tencent.mm.plugin.order.c.a;
import com.tencent.mm.plugin.order.c.a.a;
import com.tencent.mm.plugin.remittance.ui.RemittanceDetailUI;
import com.tencent.mm.plugin.wallet_payu.remittance.a.b;
import com.tencent.mm.pluginsdk.ui.span.l;
import com.tencent.mm.storage.ao;
import com.tencent.mm.ui.base.h;

public class PayURemittanceDetailUI
  extends RemittanceDetailUI
{
  private int AOC;
  private int AOD;
  private int Cvz;
  private String IuA;
  private int IuB;
  private int IuC;
  private String Iuz;
  private String mReceiverName;
  
  public final void Wg(int paramInt)
  {
    AppMethodBeat.i(72195);
    doSceneProgress(new com.tencent.mm.plugin.wallet_payu.remittance.a.e(this.Crw, this.Cvv, this.Cvs), true);
    AppMethodBeat.o(72195);
  }
  
  public final void Wh(int paramInt)
  {
    AppMethodBeat.i(72196);
    doSceneProgress(new com.tencent.mm.plugin.wallet_payu.remittance.a.e(this.Crw, this.Cvv, this.Cvs, paramInt), true);
    AppMethodBeat.o(72196);
  }
  
  public final void aQ(Intent paramIntent)
  {
    AppMethodBeat.i(72197);
    com.tencent.mm.br.c.b(this, "wallet_payu", ".remittance.ui.PayURemittanceResendMsgUI", paramIntent);
    AppMethodBeat.o(72197);
  }
  
  public final void eOg()
  {
    AppMethodBeat.i(72198);
    doSceneProgress(new com.tencent.mm.plugin.wallet_payu.remittance.a.c(this.Crw, this.Cvz, this.Iuz, this.Cvv));
    AppMethodBeat.o(72198);
  }
  
  public final void eOh()
  {
    AppMethodBeat.i(72199);
    doSceneProgress(new b(this.Crw, this.Cvz, this.Iuz, this.Cvv));
    AppMethodBeat.o(72199);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(72194);
    super.onCreate(paramBundle);
    this.Cvz = getIntent().getIntExtra("total_fee", 0);
    this.Iuz = getIntent().getStringExtra("fee_type");
    if (getIntent().getBooleanExtra("is_sender", false))
    {
      this.IuA = z.aTY();
      this.mReceiverName = this.Cvv;
      AppMethodBeat.o(72194);
      return;
    }
    this.IuA = this.Cvv;
    this.mReceiverName = z.aTY();
    AppMethodBeat.o(72194);
  }
  
  public boolean onSceneEnd(int paramInt1, int paramInt2, String paramString, q paramq)
  {
    boolean bool2 = false;
    AppMethodBeat.i(72200);
    if ((paramq instanceof com.tencent.mm.plugin.wallet_payu.remittance.a.e))
    {
      paramString = (com.tencent.mm.plugin.wallet_payu.remittance.a.e)paramq;
      Object localObject1;
      Object localObject2;
      a locala;
      if (paramString.dJY == 0)
      {
        if ((paramInt1 == 0) && (paramInt2 == 0))
        {
          if ((this.Cvt == 1) && (!getIntent().getBooleanExtra("is_sender", false)))
          {
            this.Cnb.setImageResource(2131235676);
            this.CuH.setText(2131764539);
            this.CuI.setText(com.tencent.mm.wallet_core.ui.f.d(paramString.qwJ, paramString.AOl));
            this.CuL.setVisibility(0);
            this.CuL.setOnClickListener(new PayURemittanceDetailUI.6(this));
            paramq = getString(2131764543, new Object[] { Integer.valueOf(this.Cvx) });
            localObject1 = getString(2131764531);
            localObject2 = new SpannableString(paramq + (String)localObject1);
            locala = new a(this);
            locala.AQT = new a.a()
            {
              public final void onClick(View paramAnonymousView)
              {
                AppMethodBeat.i(72192);
                h.c(PayURemittanceDetailUI.this, PayURemittanceDetailUI.this.getString(2131764527, new Object[] { PayURemittanceDetailUI.aWe(PayURemittanceDetailUI.f(PayURemittanceDetailUI.this)) }), PayURemittanceDetailUI.this.getString(2131755962), PayURemittanceDetailUI.this.getString(2131764532), PayURemittanceDetailUI.this.getString(2131755761), new DialogInterface.OnClickListener()new DialogInterface.OnClickListener
                {
                  public final void onClick(DialogInterface paramAnonymous2DialogInterface, int paramAnonymous2Int)
                  {
                    AppMethodBeat.i(72191);
                    PayURemittanceDetailUI.this.eOh();
                    AppMethodBeat.o(72191);
                  }
                }, new DialogInterface.OnClickListener()
                {
                  public final void onClick(DialogInterface paramAnonymous2DialogInterface, int paramAnonymous2Int) {}
                });
                AppMethodBeat.o(72192);
              }
            };
            ((SpannableString)localObject2).setSpan(locala, paramq.length(), paramq.length() + ((String)localObject1).length(), 33);
            this.zcv.setMovementMethod(LinkMovementMethod.getInstance());
            this.zcv.setText((CharSequence)localObject2);
            this.CuJ.setText(getString(2131764548, new Object[] { com.tencent.mm.wallet_core.ui.f.rZ(paramString.CpR) }));
            this.CuJ.setVisibility(0);
            this.CuK.setVisibility(8);
          }
          AppMethodBeat.o(72200);
          return true;
        }
        Wh(0);
        AppMethodBeat.o(72200);
        return true;
      }
      boolean bool1 = bool2;
      if (paramInt1 == 0)
      {
        bool1 = bool2;
        if (paramInt2 == 0)
        {
          this.IuB = paramString.status;
          this.IuC = paramString.CpR;
          this.AOD = paramString.Iuv;
          this.AOC = paramString.Iuw;
          this.Cvz = ((int)(paramString.qwJ * 100.0D));
          this.Iuz = paramString.AOl;
          paramq = z.aTY();
          bool1 = this.mReceiverName.equals(paramq);
          this.CuL.setVisibility(8);
          this.CuI.setText(com.tencent.mm.wallet_core.ui.f.d(this.Cvz / 100.0D, this.Iuz));
          this.CuM.setVisibility(0);
          this.Cvi.setVisibility(8);
          paramInt1 = this.IuB;
        }
      }
      switch (paramInt1)
      {
      default: 
        finish();
        bool1 = true;
        if (paramString.cSx == 1)
        {
          g.aAi();
          if (!((String)g.aAh().azQ().get(327729, "0")).equals("0")) {
            break label1562;
          }
          h.a(getContext(), 2131757399, 2131768253, new DialogInterface.OnClickListener()
          {
            public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
            {
              AppMethodBeat.i(72193);
              h.cD(PayURemittanceDetailUI.this.getContext(), PayURemittanceDetailUI.this.getString(2131764521));
              AppMethodBeat.o(72193);
            }
          });
          g.aAi();
          g.aAh().azQ().set(327729, "1");
        }
        break;
      }
      for (;;)
      {
        AppMethodBeat.o(72200);
        return bool1;
        if (!bool1)
        {
          paramq = getString(2131764540, new Object[] { bZ(this.mReceiverName, true) });
          this.CuH.setText(l.b(this, paramq, this.CuH.getTextSize()));
          paramq = getString(2131764547, new Object[] { Integer.valueOf(this.Cvx) });
          localObject1 = getString(2131764587);
          localObject2 = new SpannableString(paramq + (String)localObject1);
          locala = new a(this);
          locala.AQT = new a.a()
          {
            public final void onClick(View paramAnonymousView)
            {
              AppMethodBeat.i(72184);
              h.c(PayURemittanceDetailUI.this, PayURemittanceDetailUI.this.getString(2131764509), PayURemittanceDetailUI.this.getString(2131755962), PayURemittanceDetailUI.this.getString(2131764586), PayURemittanceDetailUI.this.getString(2131755761), new DialogInterface.OnClickListener()new DialogInterface.OnClickListener
              {
                public final void onClick(DialogInterface paramAnonymous2DialogInterface, int paramAnonymous2Int)
                {
                  AppMethodBeat.i(72183);
                  paramAnonymous2DialogInterface = new Intent();
                  paramAnonymous2DialogInterface.putExtra("transaction_id", PayURemittanceDetailUI.a(PayURemittanceDetailUI.this));
                  paramAnonymous2DialogInterface.putExtra("receiver_name", PayURemittanceDetailUI.b(PayURemittanceDetailUI.this));
                  paramAnonymous2DialogInterface.putExtra("total_fee", PayURemittanceDetailUI.c(PayURemittanceDetailUI.this));
                  paramAnonymous2DialogInterface.putExtra("fee_type", PayURemittanceDetailUI.d(PayURemittanceDetailUI.this));
                  PayURemittanceDetailUI.this.aQ(paramAnonymous2DialogInterface);
                  AppMethodBeat.o(72183);
                }
              }, new DialogInterface.OnClickListener()
              {
                public final void onClick(DialogInterface paramAnonymous2DialogInterface, int paramAnonymous2Int) {}
              });
              AppMethodBeat.o(72184);
            }
          };
          ((SpannableString)localObject2).setSpan(locala, paramq.length(), paramq.length() + ((String)localObject1).length(), 33);
          this.zcv.setMovementMethod(LinkMovementMethod.getInstance());
          this.zcv.setText((CharSequence)localObject2);
        }
        for (;;)
        {
          this.Cnb.setImageResource(2131235676);
          this.CuJ.setText(getString(2131764548, new Object[] { com.tencent.mm.wallet_core.ui.f.rZ(this.AOD) }));
          this.CuJ.setVisibility(0);
          this.CuK.setVisibility(8);
          bool1 = true;
          break;
          this.Cnb.setImageResource(2131235676);
          this.CuL.setVisibility(0);
          this.CuL.setOnClickListener(new PayURemittanceDetailUI.2(this));
          paramq = getString(2131764543, new Object[] { Integer.valueOf(this.Cvx) });
          localObject1 = getString(2131764531);
          localObject2 = new SpannableString(paramq + (String)localObject1);
          locala = new a(this);
          locala.AQT = new a.a()
          {
            public final void onClick(View paramAnonymousView)
            {
              AppMethodBeat.i(72187);
              h.c(PayURemittanceDetailUI.this, PayURemittanceDetailUI.this.getString(2131764527, new Object[] { PayURemittanceDetailUI.aWd(PayURemittanceDetailUI.e(PayURemittanceDetailUI.this)) }), PayURemittanceDetailUI.this.getString(2131755962), PayURemittanceDetailUI.this.getString(2131764532), PayURemittanceDetailUI.this.getString(2131755761), new DialogInterface.OnClickListener()new DialogInterface.OnClickListener
              {
                public final void onClick(DialogInterface paramAnonymous2DialogInterface, int paramAnonymous2Int)
                {
                  AppMethodBeat.i(72186);
                  PayURemittanceDetailUI.this.eOh();
                  AppMethodBeat.o(72186);
                }
              }, new DialogInterface.OnClickListener()
              {
                public final void onClick(DialogInterface paramAnonymous2DialogInterface, int paramAnonymous2Int) {}
              });
              AppMethodBeat.o(72187);
            }
          };
          ((SpannableString)localObject2).setSpan(locala, paramq.length(), paramq.length() + ((String)localObject1).length(), 33);
          this.zcv.setMovementMethod(LinkMovementMethod.getInstance());
          this.zcv.setText((CharSequence)localObject2);
        }
        this.Cnb.setImageResource(2131691397);
        if (bool1)
        {
          this.CuH.setText(2131764534);
          paramq = getString(2131764515);
          localObject1 = new SpannableString(paramq);
          localObject2 = new a(this);
          ((a)localObject2).AQT = new a.a()
          {
            public final void onClick(View paramAnonymousView)
            {
              AppMethodBeat.i(72188);
              com.tencent.mm.pluginsdk.wallet.f.aF(PayURemittanceDetailUI.this, 0);
              AppMethodBeat.o(72188);
            }
          };
          ((SpannableString)localObject1).setSpan(localObject2, 0, paramq.length(), 33);
          this.zcv.setMovementMethod(LinkMovementMethod.getInstance());
          this.zcv.setText((CharSequence)localObject1);
          this.zcv.setVisibility(0);
        }
        for (;;)
        {
          this.CuJ.setText(getString(2131764548, new Object[] { com.tencent.mm.wallet_core.ui.f.rZ(this.IuC) }));
          this.CuJ.setVisibility(0);
          this.CuK.setText(getString(2131764523, new Object[] { com.tencent.mm.wallet_core.ui.f.rZ(this.AOC) }));
          this.CuK.setVisibility(0);
          bool1 = true;
          break;
          paramq = bZ(this.mReceiverName, true) + " " + getString(2131764534);
          this.CuH.setText(l.b(this, paramq, this.CuH.getTextSize()));
          this.zcv.setVisibility(8);
        }
        if ((paramInt1 == 2003) && (!bool1))
        {
          this.Cnb.setImageResource(2131691399);
          this.CuH.setText(2131764538);
          label1260:
          if (bool1) {
            break label1549;
          }
          paramq = getString(2131764528);
          localObject1 = getString(2131764515);
          localObject2 = new SpannableString(paramq + (String)localObject1);
          locala = new a(this);
          locala.AQT = new a.a()
          {
            public final void onClick(View paramAnonymousView)
            {
              AppMethodBeat.i(72189);
              com.tencent.mm.pluginsdk.wallet.f.aF(PayURemittanceDetailUI.this, 0);
              AppMethodBeat.o(72189);
            }
          };
          ((SpannableString)localObject2).setSpan(locala, paramq.length(), paramq.length() + ((String)localObject1).length(), 33);
          this.zcv.setMovementMethod(LinkMovementMethod.getInstance());
          this.zcv.setText((CharSequence)localObject2);
        }
        for (;;)
        {
          this.zcv.setVisibility(0);
          this.CuJ.setText(getString(2131764548, new Object[] { com.tencent.mm.wallet_core.ui.f.rZ(this.IuC) }));
          this.CuJ.setVisibility(0);
          this.CuK.setText(getString(2131764526, new Object[] { com.tencent.mm.wallet_core.ui.f.rZ(this.AOD) }));
          this.CuK.setVisibility(0);
          bool1 = true;
          break;
          this.Cnb.setImageResource(2131691398);
          if (bool1)
          {
            this.CuH.setText(2131764536);
            break label1260;
          }
          paramq = bZ(this.mReceiverName, true) + getString(2131764536);
          this.CuH.setText(l.b(this, paramq, this.CuH.getTextSize()));
          break label1260;
          label1549:
          this.zcv.setText("");
        }
        label1562:
        h.cD(getContext(), getString(2131764521));
      }
    }
    if (((paramq instanceof com.tencent.mm.plugin.wallet_payu.remittance.a.c)) || ((paramq instanceof b)))
    {
      if ((paramInt1 == 0) && (paramInt2 == 0))
      {
        if ((paramq instanceof com.tencent.mm.plugin.wallet_payu.remittance.a.c)) {
          Wh(1);
        }
        for (;;)
        {
          AppMethodBeat.o(72200);
          return true;
          bY(0, getString(2131764522));
        }
      }
      bY(paramInt2, paramString);
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