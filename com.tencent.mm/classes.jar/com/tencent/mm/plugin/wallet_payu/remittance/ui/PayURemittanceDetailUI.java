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
import com.tencent.mm.ak.n;
import com.tencent.mm.br.d;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.u;
import com.tencent.mm.plugin.order.c.a;
import com.tencent.mm.plugin.order.c.a.a;
import com.tencent.mm.plugin.remittance.ui.RemittanceDetailUI;
import com.tencent.mm.plugin.wallet_payu.remittance.a.b;
import com.tencent.mm.plugin.wallet_payu.remittance.a.c;
import com.tencent.mm.pluginsdk.ui.span.k;
import com.tencent.mm.pluginsdk.wallet.f;
import com.tencent.mm.storage.ae;
import com.tencent.mm.ui.base.h;

public class PayURemittanceDetailUI
  extends RemittanceDetailUI
{
  private String BTm;
  private String BTn;
  private int BTo;
  private String mReceiverName;
  private int vxD;
  private int vxE;
  private int wRj;
  private int zmv;
  
  public final void MD(int paramInt)
  {
    AppMethodBeat.i(72195);
    doSceneProgress(new com.tencent.mm.plugin.wallet_payu.remittance.a.e(this.wNg, this.wRf, this.wRc), true);
    AppMethodBeat.o(72195);
  }
  
  public final void ME(int paramInt)
  {
    AppMethodBeat.i(72196);
    doSceneProgress(new com.tencent.mm.plugin.wallet_payu.remittance.a.e(this.wNg, this.wRf, this.wRc, paramInt), true);
    AppMethodBeat.o(72196);
  }
  
  public final void aC(Intent paramIntent)
  {
    AppMethodBeat.i(72197);
    d.b(this, "wallet_payu", ".remittance.ui.PayURemittanceResendMsgUI", paramIntent);
    AppMethodBeat.o(72197);
  }
  
  public final void dyw()
  {
    AppMethodBeat.i(72198);
    doSceneProgress(new c(this.wNg, this.wRj, this.BTm, this.wRf));
    AppMethodBeat.o(72198);
  }
  
  public final void dyx()
  {
    AppMethodBeat.i(72199);
    doSceneProgress(new b(this.wNg, this.wRj, this.BTm, this.wRf));
    AppMethodBeat.o(72199);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(72194);
    super.onCreate(paramBundle);
    this.wRj = getIntent().getIntExtra("total_fee", 0);
    this.BTm = getIntent().getStringExtra("fee_type");
    if (getIntent().getBooleanExtra("is_sender", false))
    {
      this.BTn = u.axw();
      this.mReceiverName = this.wRf;
      AppMethodBeat.o(72194);
      return;
    }
    this.BTn = this.wRf;
    this.mReceiverName = u.axw();
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
      if (paramString.dgm == 0)
      {
        if ((paramInt1 == 0) && (paramInt2 == 0))
        {
          if ((this.wRd == 1) && (!getIntent().getBooleanExtra("is_sender", false)))
          {
            this.wIB.setImageResource(2131234714);
            this.wQr.setText(2131762473);
            this.wQs.setText(com.tencent.mm.wallet_core.ui.e.d(paramString.oxA, paramString.vxl));
            this.wQv.setVisibility(0);
            this.wQv.setOnClickListener(new View.OnClickListener()
            {
              public final void onClick(View paramAnonymousView)
              {
                AppMethodBeat.i(72190);
                PayURemittanceDetailUI.this.dyw();
                AppMethodBeat.o(72190);
              }
            });
            paramn = getString(2131762477, new Object[] { Integer.valueOf(this.wRh) });
            localObject1 = getString(2131762465);
            localObject2 = new SpannableString(paramn + (String)localObject1);
            locala = new a(this);
            locala.vzS = new a.a()
            {
              public final void onClick(View paramAnonymousView)
              {
                AppMethodBeat.i(72192);
                h.d(PayURemittanceDetailUI.this, PayURemittanceDetailUI.this.getString(2131762461, new Object[] { PayURemittanceDetailUI.azY(PayURemittanceDetailUI.f(PayURemittanceDetailUI.this)) }), PayURemittanceDetailUI.this.getString(2131755873), PayURemittanceDetailUI.this.getString(2131762466), PayURemittanceDetailUI.this.getString(2131755691), new DialogInterface.OnClickListener()new DialogInterface.OnClickListener
                {
                  public final void onClick(DialogInterface paramAnonymous2DialogInterface, int paramAnonymous2Int)
                  {
                    AppMethodBeat.i(72191);
                    PayURemittanceDetailUI.this.dyx();
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
            this.usQ.setMovementMethod(LinkMovementMethod.getInstance());
            this.usQ.setText((CharSequence)localObject2);
            this.wQt.setText(getString(2131762482, new Object[] { com.tencent.mm.wallet_core.ui.e.nV(paramString.wLC) }));
            this.wQt.setVisibility(0);
            this.wQu.setVisibility(8);
          }
          AppMethodBeat.o(72200);
          return true;
        }
        ME(0);
        AppMethodBeat.o(72200);
        return true;
      }
      boolean bool1 = bool2;
      if (paramInt1 == 0)
      {
        bool1 = bool2;
        if (paramInt2 == 0)
        {
          this.BTo = paramString.status;
          this.zmv = paramString.wLC;
          this.vxE = paramString.BTi;
          this.vxD = paramString.BTj;
          this.wRj = ((int)(paramString.oxA * 100.0D));
          this.BTm = paramString.vxl;
          paramn = u.axw();
          bool1 = this.mReceiverName.equals(paramn);
          this.wQv.setVisibility(8);
          this.wQs.setText(com.tencent.mm.wallet_core.ui.e.d(this.wRj / 100.0D, this.BTm));
          this.wQw.setVisibility(0);
          this.wQS.setVisibility(8);
          paramInt1 = this.BTo;
        }
      }
      switch (paramInt1)
      {
      default: 
        finish();
        bool1 = true;
        if (paramString.drx == 1)
        {
          g.agS();
          if (!((String)g.agR().agA().get(327729, "0")).equals("0")) {
            break label1562;
          }
          h.a(getContext(), 2131757192, 2131765800, new DialogInterface.OnClickListener()
          {
            public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
            {
              AppMethodBeat.i(72193);
              h.cg(PayURemittanceDetailUI.this.getContext(), PayURemittanceDetailUI.this.getString(2131762455));
              AppMethodBeat.o(72193);
            }
          });
          g.agS();
          g.agR().agA().set(327729, "1");
        }
        break;
      }
      for (;;)
      {
        AppMethodBeat.o(72200);
        return bool1;
        if (!bool1)
        {
          paramn = getString(2131762474, new Object[] { bx(this.mReceiverName, true) });
          this.wQr.setText(k.b(this, paramn, this.wQr.getTextSize()));
          paramn = getString(2131762481, new Object[] { Integer.valueOf(this.wRh) });
          localObject1 = getString(2131762520);
          localObject2 = new SpannableString(paramn + (String)localObject1);
          locala = new a(this);
          locala.vzS = new a.a()
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
                  PayURemittanceDetailUI.this.aC(paramAnonymous2DialogInterface);
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
          this.usQ.setMovementMethod(LinkMovementMethod.getInstance());
          this.usQ.setText((CharSequence)localObject2);
        }
        for (;;)
        {
          this.wIB.setImageResource(2131234714);
          this.wQt.setText(getString(2131762482, new Object[] { com.tencent.mm.wallet_core.ui.e.nV(this.vxE) }));
          this.wQt.setVisibility(0);
          this.wQu.setVisibility(8);
          bool1 = true;
          break;
          this.wIB.setImageResource(2131234714);
          this.wQv.setVisibility(0);
          this.wQv.setOnClickListener(new View.OnClickListener()
          {
            public final void onClick(View paramAnonymousView)
            {
              AppMethodBeat.i(72185);
              PayURemittanceDetailUI.this.dyw();
              AppMethodBeat.o(72185);
            }
          });
          paramn = getString(2131762477, new Object[] { Integer.valueOf(this.wRh) });
          localObject1 = getString(2131762465);
          localObject2 = new SpannableString(paramn + (String)localObject1);
          locala = new a(this);
          locala.vzS = new a.a()
          {
            public final void onClick(View paramAnonymousView)
            {
              AppMethodBeat.i(72187);
              h.d(PayURemittanceDetailUI.this, PayURemittanceDetailUI.this.getString(2131762461, new Object[] { PayURemittanceDetailUI.azX(PayURemittanceDetailUI.e(PayURemittanceDetailUI.this)) }), PayURemittanceDetailUI.this.getString(2131755873), PayURemittanceDetailUI.this.getString(2131762466), PayURemittanceDetailUI.this.getString(2131755691), new DialogInterface.OnClickListener()new DialogInterface.OnClickListener
              {
                public final void onClick(DialogInterface paramAnonymous2DialogInterface, int paramAnonymous2Int)
                {
                  AppMethodBeat.i(72186);
                  PayURemittanceDetailUI.this.dyx();
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
          this.usQ.setMovementMethod(LinkMovementMethod.getInstance());
          this.usQ.setText((CharSequence)localObject2);
        }
        this.wIB.setImageResource(2131691095);
        if (bool1)
        {
          this.wQr.setText(2131762468);
          paramn = getString(2131762449);
          localObject1 = new SpannableString(paramn);
          localObject2 = new a(this);
          ((a)localObject2).vzS = new a.a()
          {
            public final void onClick(View paramAnonymousView)
            {
              AppMethodBeat.i(72188);
              f.at(PayURemittanceDetailUI.this, 0);
              AppMethodBeat.o(72188);
            }
          };
          ((SpannableString)localObject1).setSpan(localObject2, 0, paramn.length(), 33);
          this.usQ.setMovementMethod(LinkMovementMethod.getInstance());
          this.usQ.setText((CharSequence)localObject1);
          this.usQ.setVisibility(0);
        }
        for (;;)
        {
          this.wQt.setText(getString(2131762482, new Object[] { com.tencent.mm.wallet_core.ui.e.nV(this.zmv) }));
          this.wQt.setVisibility(0);
          this.wQu.setText(getString(2131762457, new Object[] { com.tencent.mm.wallet_core.ui.e.nV(this.vxD) }));
          this.wQu.setVisibility(0);
          bool1 = true;
          break;
          paramn = bx(this.mReceiverName, true) + " " + getString(2131762468);
          this.wQr.setText(k.b(this, paramn, this.wQr.getTextSize()));
          this.usQ.setVisibility(8);
        }
        if ((paramInt1 == 2003) && (!bool1))
        {
          this.wIB.setImageResource(2131691097);
          this.wQr.setText(2131762472);
          label1260:
          if (bool1) {
            break label1549;
          }
          paramn = getString(2131762462);
          localObject1 = getString(2131762449);
          localObject2 = new SpannableString(paramn + (String)localObject1);
          locala = new a(this);
          locala.vzS = new a.a()
          {
            public final void onClick(View paramAnonymousView)
            {
              AppMethodBeat.i(72189);
              f.at(PayURemittanceDetailUI.this, 0);
              AppMethodBeat.o(72189);
            }
          };
          ((SpannableString)localObject2).setSpan(locala, paramn.length(), paramn.length() + ((String)localObject1).length(), 33);
          this.usQ.setMovementMethod(LinkMovementMethod.getInstance());
          this.usQ.setText((CharSequence)localObject2);
        }
        for (;;)
        {
          this.usQ.setVisibility(0);
          this.wQt.setText(getString(2131762482, new Object[] { com.tencent.mm.wallet_core.ui.e.nV(this.zmv) }));
          this.wQt.setVisibility(0);
          this.wQu.setText(getString(2131762460, new Object[] { com.tencent.mm.wallet_core.ui.e.nV(this.vxE) }));
          this.wQu.setVisibility(0);
          bool1 = true;
          break;
          this.wIB.setImageResource(2131691096);
          if (bool1)
          {
            this.wQr.setText(2131762470);
            break label1260;
          }
          paramn = bx(this.mReceiverName, true) + getString(2131762470);
          this.wQr.setText(k.b(this, paramn, this.wQr.getTextSize()));
          break label1260;
          label1549:
          this.usQ.setText("");
        }
        label1562:
        h.cg(getContext(), getString(2131762455));
      }
    }
    if (((paramn instanceof c)) || ((paramn instanceof b)))
    {
      if ((paramInt1 == 0) && (paramInt2 == 0))
      {
        if ((paramn instanceof c)) {
          ME(1);
        }
        for (;;)
        {
          AppMethodBeat.o(72200);
          return true;
          bE(0, getString(2131762456));
        }
      }
      bE(paramInt2, paramString);
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