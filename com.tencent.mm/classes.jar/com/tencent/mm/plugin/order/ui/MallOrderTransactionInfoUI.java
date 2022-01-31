package com.tencent.mm.plugin.order.ui;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.m;
import com.tencent.mm.plugin.order.model.MallOrderDetailObject;
import com.tencent.mm.plugin.order.model.MallTransactionObject;
import com.tencent.mm.plugin.order.model.a.a;
import com.tencent.mm.plugin.order.ui.a.b;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.ui.base.preference.Preference;
import com.tencent.mm.ui.base.preference.f;
import com.tencent.mm.wallet_core.d.i;
import com.tencent.mm.wallet_core.ui.WalletPreferenceUI;
import com.tencent.mm.wallet_core.ui.c;
import java.util.List;

public class MallOrderTransactionInfoUI
  extends WalletPreferenceUI
{
  protected f iLA;
  private int prr;
  private MallTransactionObject prs = null;
  private c prt;
  
  private Bundle getInput()
  {
    AppMethodBeat.i(43883);
    Bundle localBundle2 = com.tencent.mm.wallet_core.a.aL(this);
    Bundle localBundle1 = localBundle2;
    if (localBundle2 == null) {
      localBundle1 = new Bundle();
    }
    AppMethodBeat.o(43883);
    return localBundle1;
  }
  
  public final boolean e(int paramInt1, int paramInt2, String paramString, m paramm)
  {
    AppMethodBeat.i(43882);
    if ((paramInt1 == 0) && (paramInt2 == 0))
    {
      if ((paramm instanceof com.tencent.mm.plugin.order.model.h))
      {
        paramString = ((com.tencent.mm.plugin.order.model.h)paramm).ppW;
        if (paramString != null)
        {
          this.prs = paramString.poM;
          this.iLA.removeAll();
          AppCompatActivity localAppCompatActivity = getContext();
          f localf = this.iLA;
          MallTransactionObject localMallTransactionObject = this.prs;
          Object[] arrayOfObject = new Object[1];
          arrayOfObject[0] = this.prt;
          if (localMallTransactionObject == null)
          {
            paramString = null;
            if (paramString != null)
            {
              paramInt1 = 0;
              while (paramInt1 < paramString.size())
              {
                paramm = (Preference)paramString.get(paramInt1);
                this.iLA.b(paramm);
                paramInt1 += 1;
              }
            }
          }
          else
          {
            switch (localMallTransactionObject.cLI)
            {
            default: 
              paramm = new com.tencent.mm.plugin.order.ui.a.a();
              paramString = paramm;
              if ((arrayOfObject[0] instanceof c)) {
                ((com.tencent.mm.plugin.order.ui.a.a)paramm).prt = ((c)arrayOfObject[0]);
              }
              break;
            }
            for (paramString = paramm;; paramString = new b())
            {
              paramString = paramString.a(localAppCompatActivity, localf, localMallTransactionObject);
              break;
            }
          }
          this.iLA.notifyDataSetChanged();
        }
      }
      AppMethodBeat.o(43882);
      return true;
    }
    AppMethodBeat.o(43882);
    return false;
  }
  
  public int getLayoutId()
  {
    return 2130970112;
  }
  
  public int getResourceId()
  {
    return 2131165248;
  }
  
  public void initView()
  {
    AppMethodBeat.i(43880);
    setMMTitle(2131301458);
    setBackBtn(new MallOrderTransactionInfoUI.2(this));
    this.iLA = getPreferenceScreen();
    this.prt = new c(this);
    this.prt.dSO();
    AppMethodBeat.o(43880);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(43879);
    super.onCreate(paramBundle);
    paramBundle = com.tencent.mm.wallet_core.a.aM(this);
    String str;
    if ((paramBundle != null) && ((paramBundle instanceof com.tencent.mm.plugin.order.a.a)))
    {
      str = getInput().getString("key_trans_id");
      paramBundle = getInput().getString("bill_id");
    }
    for (;;)
    {
      if (bo.isNullOrNil(str))
      {
        ab.w("MicroMsg.mmui.MMPreference", "mOrders info is Illegal!");
        com.tencent.mm.ui.base.h.a(getContext(), 2131305336, 0, new MallOrderTransactionInfoUI.1(this));
      }
      this.prr = getInput().getInt("key_pay_type");
      initView();
      dSV().a(new com.tencent.mm.plugin.order.model.h(str, paramBundle), true, 1);
      AppMethodBeat.o(43879);
      return;
      if ((getIntent().getIntExtra("scene", 0) == 1) || (getIntent().getIntExtra("scene", 0) == 2))
      {
        str = getIntent().getStringExtra("trans_id");
        paramBundle = getIntent().getStringExtra("bill_id");
      }
      else
      {
        paramBundle = null;
        str = null;
      }
    }
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(43881);
    super.onDestroy();
    if (this.prt != null) {
      this.prt.release();
    }
    AppMethodBeat.o(43881);
  }
  
  public boolean onPreferenceTreeClick(f paramf, Preference paramPreference)
  {
    return false;
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.order.ui.MallOrderTransactionInfoUI
 * JD-Core Version:    0.7.0.1
 */