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
import com.tencent.mm.plugin.order.c.a.a;
import com.tencent.mm.plugin.remittance.ui.RemittanceDetailUI;
import com.tencent.mm.plugin.wallet_payu.remittance.a.c;
import com.tencent.mm.pluginsdk.ui.span.k;
import com.tencent.mm.pluginsdk.wallet.f;
import com.tencent.mm.storage.ai;
import com.tencent.mm.ui.base.h;

public class PayURemittanceDetailUI
  extends RemittanceDetailUI
{
  private String DtF;
  private String DtG;
  private int DtH;
  private int DtI;
  private String mReceiverName;
  private int wCX;
  private int wCY;
  private int yeR;
  
  public final void Of(int paramInt)
  {
    AppMethodBeat.i(72195);
    doSceneProgress(new com.tencent.mm.plugin.wallet_payu.remittance.a.e(this.yaO, this.yeN, this.yeK), true);
    AppMethodBeat.o(72195);
  }
  
  public final void Og(int paramInt)
  {
    AppMethodBeat.i(72196);
    doSceneProgress(new com.tencent.mm.plugin.wallet_payu.remittance.a.e(this.yaO, this.yeN, this.yeK, paramInt), true);
    AppMethodBeat.o(72196);
  }
  
  public final void aH(Intent paramIntent)
  {
    AppMethodBeat.i(72197);
    d.b(this, "wallet_payu", ".remittance.ui.PayURemittanceResendMsgUI", paramIntent);
    AppMethodBeat.o(72197);
  }
  
  public final void dJO()
  {
    AppMethodBeat.i(72198);
    doSceneProgress(new c(this.yaO, this.yeR, this.DtF, this.yeN));
    AppMethodBeat.o(72198);
  }
  
  public final void dJP()
  {
    AppMethodBeat.i(72199);
    doSceneProgress(new com.tencent.mm.plugin.wallet_payu.remittance.a.b(this.yaO, this.yeR, this.DtF, this.yeN));
    AppMethodBeat.o(72199);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(72194);
    super.onCreate(paramBundle);
    this.yeR = getIntent().getIntExtra("total_fee", 0);
    this.DtF = getIntent().getStringExtra("fee_type");
    if (getIntent().getBooleanExtra("is_sender", false))
    {
      this.DtG = u.aAm();
      this.mReceiverName = this.yeN;
      AppMethodBeat.o(72194);
      return;
    }
    this.DtG = this.yeN;
    this.mReceiverName = u.aAm();
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
      com.tencent.mm.plugin.order.c.a locala;
      if (paramString.drI == 0)
      {
        if ((paramInt1 == 0) && (paramInt2 == 0))
        {
          if ((this.yeL == 1) && (!getIntent().getBooleanExtra("is_sender", false)))
          {
            this.xWi.setImageResource(2131234714);
            this.ydZ.setText(2131762473);
            this.yea.setText(com.tencent.mm.wallet_core.ui.e.d(paramString.paV, paramString.wCF));
            this.yed.setVisibility(0);
            this.yed.setOnClickListener(new View.OnClickListener()
            {
              public final void onClick(View paramAnonymousView)
              {
                AppMethodBeat.i(72190);
                com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
                localb.bd(paramAnonymousView);
                com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/wallet_payu/remittance/ui/PayURemittanceDetailUI$6", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahq());
                PayURemittanceDetailUI.this.dJO();
                com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/wallet_payu/remittance/ui/PayURemittanceDetailUI$6", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                AppMethodBeat.o(72190);
              }
            });
            paramn = getString(2131762477, new Object[] { Integer.valueOf(this.yeP) });
            localObject1 = getString(2131762465);
            localObject2 = new SpannableString(paramn + (String)localObject1);
            locala = new com.tencent.mm.plugin.order.c.a(this);
            locala.wFm = new a.a()
            {
              public final void onClick(View paramAnonymousView)
              {
                AppMethodBeat.i(72192);
                h.e(PayURemittanceDetailUI.this, PayURemittanceDetailUI.this.getString(2131762461, new Object[] { PayURemittanceDetailUI.aFi(PayURemittanceDetailUI.f(PayURemittanceDetailUI.this)) }), PayURemittanceDetailUI.this.getString(2131755873), PayURemittanceDetailUI.this.getString(2131762466), PayURemittanceDetailUI.this.getString(2131755691), new DialogInterface.OnClickListener()new DialogInterface.OnClickListener
                {
                  public final void onClick(DialogInterface paramAnonymous2DialogInterface, int paramAnonymous2Int)
                  {
                    AppMethodBeat.i(72191);
                    PayURemittanceDetailUI.this.dJP();
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
            this.vvt.setMovementMethod(LinkMovementMethod.getInstance());
            this.vvt.setText((CharSequence)localObject2);
            this.yeb.setText(getString(2131762482, new Object[] { com.tencent.mm.wallet_core.ui.e.ov(paramString.xZj) }));
            this.yeb.setVisibility(0);
            this.yec.setVisibility(8);
          }
          AppMethodBeat.o(72200);
          return true;
        }
        Og(0);
        AppMethodBeat.o(72200);
        return true;
      }
      boolean bool1 = bool2;
      if (paramInt1 == 0)
      {
        bool1 = bool2;
        if (paramInt2 == 0)
        {
          this.DtH = paramString.status;
          this.DtI = paramString.xZj;
          this.wCY = paramString.DtB;
          this.wCX = paramString.DtC;
          this.yeR = ((int)(paramString.paV * 100.0D));
          this.DtF = paramString.wCF;
          paramn = u.aAm();
          bool1 = this.mReceiverName.equals(paramn);
          this.yed.setVisibility(8);
          this.yea.setText(com.tencent.mm.wallet_core.ui.e.d(this.yeR / 100.0D, this.DtF));
          this.yee.setVisibility(0);
          this.yeA.setVisibility(8);
          paramInt1 = this.DtH;
        }
      }
      switch (paramInt1)
      {
      default: 
        finish();
        bool1 = true;
        if (paramString.dDp == 1)
        {
          g.ajD();
          if (!((String)g.ajC().ajl().get(327729, "0")).equals("0")) {
            break label1562;
          }
          h.a(getContext(), 2131757192, 2131765800, new DialogInterface.OnClickListener()
          {
            public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
            {
              AppMethodBeat.i(72193);
              h.cl(PayURemittanceDetailUI.this.getContext(), PayURemittanceDetailUI.this.getString(2131762455));
              AppMethodBeat.o(72193);
            }
          });
          g.ajD();
          g.ajC().ajl().set(327729, "1");
        }
        break;
      }
      for (;;)
      {
        AppMethodBeat.o(72200);
        return bool1;
        if (!bool1)
        {
          paramn = getString(2131762474, new Object[] { bE(this.mReceiverName, true) });
          this.ydZ.setText(k.b(this, paramn, this.ydZ.getTextSize()));
          paramn = getString(2131762481, new Object[] { Integer.valueOf(this.yeP) });
          localObject1 = getString(2131762520);
          localObject2 = new SpannableString(paramn + (String)localObject1);
          locala = new com.tencent.mm.plugin.order.c.a(this);
          locala.wFm = new a.a()
          {
            public final void onClick(View paramAnonymousView)
            {
              AppMethodBeat.i(72184);
              h.e(PayURemittanceDetailUI.this, PayURemittanceDetailUI.this.getString(2131762443), PayURemittanceDetailUI.this.getString(2131755873), PayURemittanceDetailUI.this.getString(2131762519), PayURemittanceDetailUI.this.getString(2131755691), new DialogInterface.OnClickListener()new DialogInterface.OnClickListener
              {
                public final void onClick(DialogInterface paramAnonymous2DialogInterface, int paramAnonymous2Int)
                {
                  AppMethodBeat.i(72183);
                  paramAnonymous2DialogInterface = new Intent();
                  paramAnonymous2DialogInterface.putExtra("transaction_id", PayURemittanceDetailUI.a(PayURemittanceDetailUI.this));
                  paramAnonymous2DialogInterface.putExtra("receiver_name", PayURemittanceDetailUI.b(PayURemittanceDetailUI.this));
                  paramAnonymous2DialogInterface.putExtra("total_fee", PayURemittanceDetailUI.c(PayURemittanceDetailUI.this));
                  paramAnonymous2DialogInterface.putExtra("fee_type", PayURemittanceDetailUI.d(PayURemittanceDetailUI.this));
                  PayURemittanceDetailUI.this.aH(paramAnonymous2DialogInterface);
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
          this.vvt.setMovementMethod(LinkMovementMethod.getInstance());
          this.vvt.setText((CharSequence)localObject2);
        }
        for (;;)
        {
          this.xWi.setImageResource(2131234714);
          this.yeb.setText(getString(2131762482, new Object[] { com.tencent.mm.wallet_core.ui.e.ov(this.wCY) }));
          this.yeb.setVisibility(0);
          this.yec.setVisibility(8);
          bool1 = true;
          break;
          this.xWi.setImageResource(2131234714);
          this.yed.setVisibility(0);
          this.yed.setOnClickListener(new View.OnClickListener()
          {
            public final void onClick(View paramAnonymousView)
            {
              AppMethodBeat.i(72185);
              com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
              localb.bd(paramAnonymousView);
              com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/wallet_payu/remittance/ui/PayURemittanceDetailUI$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahq());
              PayURemittanceDetailUI.this.dJO();
              com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/wallet_payu/remittance/ui/PayURemittanceDetailUI$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
              AppMethodBeat.o(72185);
            }
          });
          paramn = getString(2131762477, new Object[] { Integer.valueOf(this.yeP) });
          localObject1 = getString(2131762465);
          localObject2 = new SpannableString(paramn + (String)localObject1);
          locala = new com.tencent.mm.plugin.order.c.a(this);
          locala.wFm = new a.a()
          {
            public final void onClick(View paramAnonymousView)
            {
              AppMethodBeat.i(72187);
              h.e(PayURemittanceDetailUI.this, PayURemittanceDetailUI.this.getString(2131762461, new Object[] { PayURemittanceDetailUI.aFh(PayURemittanceDetailUI.e(PayURemittanceDetailUI.this)) }), PayURemittanceDetailUI.this.getString(2131755873), PayURemittanceDetailUI.this.getString(2131762466), PayURemittanceDetailUI.this.getString(2131755691), new DialogInterface.OnClickListener()new DialogInterface.OnClickListener
              {
                public final void onClick(DialogInterface paramAnonymous2DialogInterface, int paramAnonymous2Int)
                {
                  AppMethodBeat.i(72186);
                  PayURemittanceDetailUI.this.dJP();
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
          this.vvt.setMovementMethod(LinkMovementMethod.getInstance());
          this.vvt.setText((CharSequence)localObject2);
        }
        this.xWi.setImageResource(2131691095);
        if (bool1)
        {
          this.ydZ.setText(2131762468);
          paramn = getString(2131762449);
          localObject1 = new SpannableString(paramn);
          localObject2 = new com.tencent.mm.plugin.order.c.a(this);
          ((com.tencent.mm.plugin.order.c.a)localObject2).wFm = new a.a()
          {
            public final void onClick(View paramAnonymousView)
            {
              AppMethodBeat.i(72188);
              f.aw(PayURemittanceDetailUI.this, 0);
              AppMethodBeat.o(72188);
            }
          };
          ((SpannableString)localObject1).setSpan(localObject2, 0, paramn.length(), 33);
          this.vvt.setMovementMethod(LinkMovementMethod.getInstance());
          this.vvt.setText((CharSequence)localObject1);
          this.vvt.setVisibility(0);
        }
        for (;;)
        {
          this.yeb.setText(getString(2131762482, new Object[] { com.tencent.mm.wallet_core.ui.e.ov(this.DtI) }));
          this.yeb.setVisibility(0);
          this.yec.setText(getString(2131762457, new Object[] { com.tencent.mm.wallet_core.ui.e.ov(this.wCX) }));
          this.yec.setVisibility(0);
          bool1 = true;
          break;
          paramn = bE(this.mReceiverName, true) + " " + getString(2131762468);
          this.ydZ.setText(k.b(this, paramn, this.ydZ.getTextSize()));
          this.vvt.setVisibility(8);
        }
        if ((paramInt1 == 2003) && (!bool1))
        {
          this.xWi.setImageResource(2131691097);
          this.ydZ.setText(2131762472);
          label1260:
          if (bool1) {
            break label1549;
          }
          paramn = getString(2131762462);
          localObject1 = getString(2131762449);
          localObject2 = new SpannableString(paramn + (String)localObject1);
          locala = new com.tencent.mm.plugin.order.c.a(this);
          locala.wFm = new a.a()
          {
            public final void onClick(View paramAnonymousView)
            {
              AppMethodBeat.i(72189);
              f.aw(PayURemittanceDetailUI.this, 0);
              AppMethodBeat.o(72189);
            }
          };
          ((SpannableString)localObject2).setSpan(locala, paramn.length(), paramn.length() + ((String)localObject1).length(), 33);
          this.vvt.setMovementMethod(LinkMovementMethod.getInstance());
          this.vvt.setText((CharSequence)localObject2);
        }
        for (;;)
        {
          this.vvt.setVisibility(0);
          this.yeb.setText(getString(2131762482, new Object[] { com.tencent.mm.wallet_core.ui.e.ov(this.DtI) }));
          this.yeb.setVisibility(0);
          this.yec.setText(getString(2131762460, new Object[] { com.tencent.mm.wallet_core.ui.e.ov(this.wCY) }));
          this.yec.setVisibility(0);
          bool1 = true;
          break;
          this.xWi.setImageResource(2131691096);
          if (bool1)
          {
            this.ydZ.setText(2131762470);
            break label1260;
          }
          paramn = bE(this.mReceiverName, true) + getString(2131762470);
          this.ydZ.setText(k.b(this, paramn, this.ydZ.getTextSize()));
          break label1260;
          label1549:
          this.vvt.setText("");
        }
        label1562:
        h.cl(getContext(), getString(2131762455));
      }
    }
    if (((paramn instanceof c)) || ((paramn instanceof com.tencent.mm.plugin.wallet_payu.remittance.a.b)))
    {
      if ((paramInt1 == 0) && (paramInt2 == 0))
      {
        if ((paramn instanceof c)) {
          Og(1);
        }
        for (;;)
        {
          AppMethodBeat.o(72200);
          return true;
          bK(0, getString(2131762456));
        }
      }
      bK(paramInt2, paramString);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet_payu.remittance.ui.PayURemittanceDetailUI
 * JD-Core Version:    0.7.0.1
 */