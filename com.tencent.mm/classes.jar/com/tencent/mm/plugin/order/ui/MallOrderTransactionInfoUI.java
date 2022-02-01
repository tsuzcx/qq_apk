package com.tencent.mm.plugin.order.ui;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.q;
import com.tencent.mm.plugin.order.model.MallOrderDetailObject;
import com.tencent.mm.plugin.order.model.MallTransactionObject;
import com.tencent.mm.plugin.order.model.a.a;
import com.tencent.mm.plugin.order.ui.a.b;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.base.preference.Preference;
import com.tencent.mm.ui.base.preference.f;
import com.tencent.mm.wallet_core.d.i;
import com.tencent.mm.wallet_core.ui.WalletPreferenceUI;
import com.tencent.mm.wallet_core.ui.c;
import java.util.List;

public class MallOrderTransactionInfoUI
  extends WalletPreferenceUI
{
  private int AQo;
  private MallTransactionObject AQp = null;
  private c AQq;
  protected f nRm;
  
  private Bundle getInput()
  {
    AppMethodBeat.i(66790);
    Bundle localBundle2 = com.tencent.mm.wallet_core.a.bx(this);
    Bundle localBundle1 = localBundle2;
    if (localBundle2 == null) {
      localBundle1 = new Bundle();
    }
    AppMethodBeat.o(66790);
    return localBundle1;
  }
  
  public final boolean e(int paramInt1, int paramInt2, String paramString, q paramq)
  {
    AppMethodBeat.i(66789);
    if ((paramInt1 == 0) && (paramInt2 == 0))
    {
      if ((paramq instanceof com.tencent.mm.plugin.order.model.h))
      {
        paramString = ((com.tencent.mm.plugin.order.model.h)paramq).AOR;
        if (paramString != null)
        {
          this.AQp = paramString.ANI;
          this.nRm.removeAll();
          AppCompatActivity localAppCompatActivity = getContext();
          f localf = this.nRm;
          MallTransactionObject localMallTransactionObject = this.AQp;
          Object[] arrayOfObject = new Object[1];
          arrayOfObject[0] = this.AQq;
          if (localMallTransactionObject == null)
          {
            paramString = null;
            if (paramString != null)
            {
              paramInt1 = 0;
              while (paramInt1 < paramString.size())
              {
                paramq = (Preference)paramString.get(paramInt1);
                this.nRm.c(paramq);
                paramInt1 += 1;
              }
            }
          }
          else
          {
            switch (localMallTransactionObject.efQ)
            {
            default: 
              paramq = new com.tencent.mm.plugin.order.ui.a.a();
              paramString = paramq;
              if ((arrayOfObject[0] instanceof c)) {
                ((com.tencent.mm.plugin.order.ui.a.a)paramq).AQq = ((c)arrayOfObject[0]);
              }
              break;
            }
            for (paramString = paramq;; paramString = new b())
            {
              paramString = paramString.a(localAppCompatActivity, localf, localMallTransactionObject);
              break;
            }
          }
          this.nRm.notifyDataSetChanged();
        }
      }
      AppMethodBeat.o(66789);
      return true;
    }
    AppMethodBeat.o(66789);
    return false;
  }
  
  public int getLayoutId()
  {
    return 2131495455;
  }
  
  public int getResourceId()
  {
    return 2132017234;
  }
  
  public void initView()
  {
    AppMethodBeat.i(66787);
    setMMTitle(2131762892);
    setBackBtn(new MenuItem.OnMenuItemClickListener()
    {
      public final boolean onMenuItemClick(MenuItem paramAnonymousMenuItem)
      {
        AppMethodBeat.i(66785);
        MallOrderTransactionInfoUI.this.finish();
        AppMethodBeat.o(66785);
        return false;
      }
    });
    this.nRm = getPreferenceScreen();
    this.AQq = new c(this);
    this.AQq.hhP();
    AppMethodBeat.o(66787);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(66786);
    super.onCreate(paramBundle);
    paramBundle = com.tencent.mm.wallet_core.a.by(this);
    String str;
    if ((paramBundle != null) && ((paramBundle instanceof com.tencent.mm.plugin.order.a.a)))
    {
      str = getInput().getString("key_trans_id");
      paramBundle = getInput().getString("bill_id");
    }
    for (;;)
    {
      if (Util.isNullOrNil(str))
      {
        Log.w("MicroMsg.mmui.MMPreference", "mOrders info is Illegal!");
        com.tencent.mm.ui.base.h.a(getContext(), 2131767999, 0, new DialogInterface.OnClickListener()
        {
          public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
          {
            AppMethodBeat.i(66784);
            MallOrderTransactionInfoUI.this.finish();
            AppMethodBeat.o(66784);
          }
        });
      }
      this.AQo = getInput().getInt("key_pay_type");
      initView();
      hhW().a(new com.tencent.mm.plugin.order.model.h(str, paramBundle), true, 1);
      AppMethodBeat.o(66786);
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
    AppMethodBeat.i(66788);
    super.onDestroy();
    if (this.AQq != null) {
      this.AQq.release();
    }
    AppMethodBeat.o(66788);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.order.ui.MallOrderTransactionInfoUI
 * JD-Core Version:    0.7.0.1
 */