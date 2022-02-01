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
import com.tencent.mm.model.v;
import com.tencent.mm.plugin.order.c.a.a;
import com.tencent.mm.plugin.remittance.ui.RemittanceDetailUI;
import com.tencent.mm.plugin.wallet_payu.remittance.a.c;
import com.tencent.mm.pluginsdk.ui.span.k;
import com.tencent.mm.storage.aj;
import com.tencent.mm.ui.base.h;

public class PayURemittanceDetailUI
  extends RemittanceDetailUI
{
  private String DLk;
  private String DLl;
  private int DLm;
  private int DLn;
  private String mReceiverName;
  private int wSI;
  private int wSJ;
  private int yuI;
  
  public final void OL(int paramInt)
  {
    AppMethodBeat.i(72195);
    doSceneProgress(new com.tencent.mm.plugin.wallet_payu.remittance.a.e(this.yqF, this.yuE, this.yuB), true);
    AppMethodBeat.o(72195);
  }
  
  public final void OM(int paramInt)
  {
    AppMethodBeat.i(72196);
    doSceneProgress(new com.tencent.mm.plugin.wallet_payu.remittance.a.e(this.yqF, this.yuE, this.yuB, paramInt), true);
    AppMethodBeat.o(72196);
  }
  
  public final void aI(Intent paramIntent)
  {
    AppMethodBeat.i(72197);
    d.b(this, "wallet_payu", ".remittance.ui.PayURemittanceResendMsgUI", paramIntent);
    AppMethodBeat.o(72197);
  }
  
  public final void dNg()
  {
    AppMethodBeat.i(72198);
    doSceneProgress(new c(this.yqF, this.yuI, this.DLk, this.yuE));
    AppMethodBeat.o(72198);
  }
  
  public final void dNh()
  {
    AppMethodBeat.i(72199);
    doSceneProgress(new com.tencent.mm.plugin.wallet_payu.remittance.a.b(this.yqF, this.yuI, this.DLk, this.yuE));
    AppMethodBeat.o(72199);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(72194);
    super.onCreate(paramBundle);
    this.yuI = getIntent().getIntExtra("total_fee", 0);
    this.DLk = getIntent().getStringExtra("fee_type");
    if (getIntent().getBooleanExtra("is_sender", false))
    {
      this.DLl = v.aAC();
      this.mReceiverName = this.yuE;
      AppMethodBeat.o(72194);
      return;
    }
    this.DLl = this.yuE;
    this.mReceiverName = v.aAC();
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
      if (paramString.dsO == 0)
      {
        if ((paramInt1 == 0) && (paramInt2 == 0))
        {
          if ((this.yuC == 1) && (!getIntent().getBooleanExtra("is_sender", false)))
          {
            this.ymb.setImageResource(2131234714);
            this.ytQ.setText(2131762473);
            this.ytR.setText(com.tencent.mm.wallet_core.ui.f.d(paramString.phz, paramString.wSq));
            this.ytU.setVisibility(0);
            this.ytU.setOnClickListener(new View.OnClickListener()
            {
              public final void onClick(View paramAnonymousView)
              {
                AppMethodBeat.i(72190);
                com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
                localb.bd(paramAnonymousView);
                com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/wallet_payu/remittance/ui/PayURemittanceDetailUI$6", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahF());
                PayURemittanceDetailUI.this.dNg();
                com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/wallet_payu/remittance/ui/PayURemittanceDetailUI$6", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                AppMethodBeat.o(72190);
              }
            });
            paramn = getString(2131762477, new Object[] { Integer.valueOf(this.yuG) });
            localObject1 = getString(2131762465);
            localObject2 = new SpannableString(paramn + (String)localObject1);
            locala = new com.tencent.mm.plugin.order.c.a(this);
            locala.wUX = new a.a()
            {
              public final void onClick(View paramAnonymousView)
              {
                AppMethodBeat.i(72192);
                h.e(PayURemittanceDetailUI.this, PayURemittanceDetailUI.this.getString(2131762461, new Object[] { PayURemittanceDetailUI.aGC(PayURemittanceDetailUI.f(PayURemittanceDetailUI.this)) }), PayURemittanceDetailUI.this.getString(2131755873), PayURemittanceDetailUI.this.getString(2131762466), PayURemittanceDetailUI.this.getString(2131755691), new DialogInterface.OnClickListener()new DialogInterface.OnClickListener
                {
                  public final void onClick(DialogInterface paramAnonymous2DialogInterface, int paramAnonymous2Int)
                  {
                    AppMethodBeat.i(72191);
                    PayURemittanceDetailUI.this.dNh();
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
            this.vHx.setMovementMethod(LinkMovementMethod.getInstance());
            this.vHx.setText((CharSequence)localObject2);
            this.ytS.setText(getString(2131762482, new Object[] { com.tencent.mm.wallet_core.ui.f.oy(paramString.ypb) }));
            this.ytS.setVisibility(0);
            this.ytT.setVisibility(8);
          }
          AppMethodBeat.o(72200);
          return true;
        }
        OM(0);
        AppMethodBeat.o(72200);
        return true;
      }
      boolean bool1 = bool2;
      if (paramInt1 == 0)
      {
        bool1 = bool2;
        if (paramInt2 == 0)
        {
          this.DLm = paramString.status;
          this.DLn = paramString.ypb;
          this.wSJ = paramString.DLg;
          this.wSI = paramString.DLh;
          this.yuI = ((int)(paramString.phz * 100.0D));
          this.DLk = paramString.wSq;
          paramn = v.aAC();
          bool1 = this.mReceiverName.equals(paramn);
          this.ytU.setVisibility(8);
          this.ytR.setText(com.tencent.mm.wallet_core.ui.f.d(this.yuI / 100.0D, this.DLk));
          this.ytV.setVisibility(0);
          this.yur.setVisibility(8);
          paramInt1 = this.DLm;
        }
      }
      switch (paramInt1)
      {
      default: 
        finish();
        bool1 = true;
        if (paramString.dEu == 1)
        {
          g.ajS();
          if (!((String)g.ajR().ajA().get(327729, "0")).equals("0")) {
            break label1562;
          }
          h.a(getContext(), 2131757192, 2131765800, new DialogInterface.OnClickListener()
          {
            public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
            {
              AppMethodBeat.i(72193);
              h.cm(PayURemittanceDetailUI.this.getContext(), PayURemittanceDetailUI.this.getString(2131762455));
              AppMethodBeat.o(72193);
            }
          });
          g.ajS();
          g.ajR().ajA().set(327729, "1");
        }
        break;
      }
      for (;;)
      {
        AppMethodBeat.o(72200);
        return bool1;
        if (!bool1)
        {
          paramn = getString(2131762474, new Object[] { bI(this.mReceiverName, true) });
          this.ytQ.setText(k.b(this, paramn, this.ytQ.getTextSize()));
          paramn = getString(2131762481, new Object[] { Integer.valueOf(this.yuG) });
          localObject1 = getString(2131762520);
          localObject2 = new SpannableString(paramn + (String)localObject1);
          locala = new com.tencent.mm.plugin.order.c.a(this);
          locala.wUX = new a.a()
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
                  PayURemittanceDetailUI.this.aI(paramAnonymous2DialogInterface);
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
          this.vHx.setMovementMethod(LinkMovementMethod.getInstance());
          this.vHx.setText((CharSequence)localObject2);
        }
        for (;;)
        {
          this.ymb.setImageResource(2131234714);
          this.ytS.setText(getString(2131762482, new Object[] { com.tencent.mm.wallet_core.ui.f.oy(this.wSJ) }));
          this.ytS.setVisibility(0);
          this.ytT.setVisibility(8);
          bool1 = true;
          break;
          this.ymb.setImageResource(2131234714);
          this.ytU.setVisibility(0);
          this.ytU.setOnClickListener(new View.OnClickListener()
          {
            public final void onClick(View paramAnonymousView)
            {
              AppMethodBeat.i(72185);
              com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
              localb.bd(paramAnonymousView);
              com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/wallet_payu/remittance/ui/PayURemittanceDetailUI$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahF());
              PayURemittanceDetailUI.this.dNg();
              com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/wallet_payu/remittance/ui/PayURemittanceDetailUI$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
              AppMethodBeat.o(72185);
            }
          });
          paramn = getString(2131762477, new Object[] { Integer.valueOf(this.yuG) });
          localObject1 = getString(2131762465);
          localObject2 = new SpannableString(paramn + (String)localObject1);
          locala = new com.tencent.mm.plugin.order.c.a(this);
          locala.wUX = new a.a()
          {
            public final void onClick(View paramAnonymousView)
            {
              AppMethodBeat.i(72187);
              h.e(PayURemittanceDetailUI.this, PayURemittanceDetailUI.this.getString(2131762461, new Object[] { PayURemittanceDetailUI.aGB(PayURemittanceDetailUI.e(PayURemittanceDetailUI.this)) }), PayURemittanceDetailUI.this.getString(2131755873), PayURemittanceDetailUI.this.getString(2131762466), PayURemittanceDetailUI.this.getString(2131755691), new DialogInterface.OnClickListener()new DialogInterface.OnClickListener
              {
                public final void onClick(DialogInterface paramAnonymous2DialogInterface, int paramAnonymous2Int)
                {
                  AppMethodBeat.i(72186);
                  PayURemittanceDetailUI.this.dNh();
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
          this.vHx.setMovementMethod(LinkMovementMethod.getInstance());
          this.vHx.setText((CharSequence)localObject2);
        }
        this.ymb.setImageResource(2131691095);
        if (bool1)
        {
          this.ytQ.setText(2131762468);
          paramn = getString(2131762449);
          localObject1 = new SpannableString(paramn);
          localObject2 = new com.tencent.mm.plugin.order.c.a(this);
          ((com.tencent.mm.plugin.order.c.a)localObject2).wUX = new a.a()
          {
            public final void onClick(View paramAnonymousView)
            {
              AppMethodBeat.i(72188);
              com.tencent.mm.pluginsdk.wallet.f.aw(PayURemittanceDetailUI.this, 0);
              AppMethodBeat.o(72188);
            }
          };
          ((SpannableString)localObject1).setSpan(localObject2, 0, paramn.length(), 33);
          this.vHx.setMovementMethod(LinkMovementMethod.getInstance());
          this.vHx.setText((CharSequence)localObject1);
          this.vHx.setVisibility(0);
        }
        for (;;)
        {
          this.ytS.setText(getString(2131762482, new Object[] { com.tencent.mm.wallet_core.ui.f.oy(this.DLn) }));
          this.ytS.setVisibility(0);
          this.ytT.setText(getString(2131762457, new Object[] { com.tencent.mm.wallet_core.ui.f.oy(this.wSI) }));
          this.ytT.setVisibility(0);
          bool1 = true;
          break;
          paramn = bI(this.mReceiverName, true) + " " + getString(2131762468);
          this.ytQ.setText(k.b(this, paramn, this.ytQ.getTextSize()));
          this.vHx.setVisibility(8);
        }
        if ((paramInt1 == 2003) && (!bool1))
        {
          this.ymb.setImageResource(2131691097);
          this.ytQ.setText(2131762472);
          label1260:
          if (bool1) {
            break label1549;
          }
          paramn = getString(2131762462);
          localObject1 = getString(2131762449);
          localObject2 = new SpannableString(paramn + (String)localObject1);
          locala = new com.tencent.mm.plugin.order.c.a(this);
          locala.wUX = new a.a()
          {
            public final void onClick(View paramAnonymousView)
            {
              AppMethodBeat.i(72189);
              com.tencent.mm.pluginsdk.wallet.f.aw(PayURemittanceDetailUI.this, 0);
              AppMethodBeat.o(72189);
            }
          };
          ((SpannableString)localObject2).setSpan(locala, paramn.length(), paramn.length() + ((String)localObject1).length(), 33);
          this.vHx.setMovementMethod(LinkMovementMethod.getInstance());
          this.vHx.setText((CharSequence)localObject2);
        }
        for (;;)
        {
          this.vHx.setVisibility(0);
          this.ytS.setText(getString(2131762482, new Object[] { com.tencent.mm.wallet_core.ui.f.oy(this.DLn) }));
          this.ytS.setVisibility(0);
          this.ytT.setText(getString(2131762460, new Object[] { com.tencent.mm.wallet_core.ui.f.oy(this.wSJ) }));
          this.ytT.setVisibility(0);
          bool1 = true;
          break;
          this.ymb.setImageResource(2131691096);
          if (bool1)
          {
            this.ytQ.setText(2131762470);
            break label1260;
          }
          paramn = bI(this.mReceiverName, true) + getString(2131762470);
          this.ytQ.setText(k.b(this, paramn, this.ytQ.getTextSize()));
          break label1260;
          label1549:
          this.vHx.setText("");
        }
        label1562:
        h.cm(getContext(), getString(2131762455));
      }
    }
    if (((paramn instanceof c)) || ((paramn instanceof com.tencent.mm.plugin.wallet_payu.remittance.a.b)))
    {
      if ((paramInt1 == 0) && (paramInt2 == 0))
      {
        if ((paramn instanceof c)) {
          OM(1);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet_payu.remittance.ui.PayURemittanceDetailUI
 * JD-Core Version:    0.7.0.1
 */